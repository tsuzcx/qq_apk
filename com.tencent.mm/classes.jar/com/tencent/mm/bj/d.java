package com.tencent.mm.bj;

import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;

public final class d
  implements a
{
  protected long aZw;
  protected MediaExtractor cfO;
  protected MediaCodec eRD;
  protected MediaCodec.BufferInfo eRL;
  protected long eRN;
  protected int eRW;
  private int eRx;
  protected int eUR;
  protected String fVg;
  protected a.a fYv;
  protected MediaFormat fYw;
  private byte[] fYx;
  private int frameCount;
  protected int sampleSize;
  
  public d(MediaExtractor paramMediaExtractor, MediaFormat paramMediaFormat, int paramInt)
  {
    AppMethodBeat.i(50908);
    this.fVg = null;
    this.eRL = new MediaCodec.BufferInfo();
    this.frameCount = 0;
    this.eRx = -1;
    ab.i("MicroMsg.MediaCodecTranscodeDecoder", "create MediaCodecTranscodeDecoder: %s, %s, %s", new Object[] { paramMediaExtractor, paramMediaFormat, Integer.valueOf(paramInt) });
    this.cfO = paramMediaExtractor;
    this.fYw = paramMediaFormat;
    this.eUR = paramInt;
    AppMethodBeat.o(50908);
  }
  
  private boolean UE()
  {
    AppMethodBeat.i(50912);
    if (this.eRD == null)
    {
      ab.e("MicroMsg.MediaCodecTranscodeDecoder", "drainDecoder, decoder is null");
      AppMethodBeat.o(50912);
      return true;
    }
    Object localObject = this.eRD.getOutputBuffers();
    ab.i("MicroMsg.MediaCodecTranscodeDecoder", "decoderOutputByteBuffers length: %s", new Object[] { Integer.valueOf(localObject.length) });
    int i = this.eRD.dequeueOutputBuffer(this.eRL, 60000L);
    ab.i("MicroMsg.MediaCodecTranscodeDecoder", "outputBufferIndex-->".concat(String.valueOf(i)));
    if (i == -1)
    {
      ab.i("MicroMsg.MediaCodecTranscodeDecoder", "no output from decoder available, break");
      label96:
      AppMethodBeat.o(50912);
      return false;
    }
    if (i == -3)
    {
      localObject = this.eRD.getOutputBuffers();
      ab.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output buffers changed");
    }
    for (;;)
    {
      int j = this.eRD.dequeueOutputBuffer(this.eRL, 60000L);
      i = j;
      if (j >= 0) {
        break;
      }
      break label96;
      if (i == -2)
      {
        this.fYw = this.eRD.getOutputFormat();
        ab.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output format changed: " + this.fYw);
      }
      else if (i < 0)
      {
        ab.w("MicroMsg.MediaCodecTranscodeDecoder", "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(i)));
      }
      else
      {
        ab.v("MicroMsg.MediaCodecTranscodeDecoder", "perform decoding");
        a.a locala = localObject[i];
        if (locala == null) {
          break label96;
        }
        long l1 = this.eRL.presentationTimeUs;
        if ((l1 < this.aZw * 1000L) && ((this.eRL.flags & 0x4) == 0))
        {
          this.eRD.releaseOutputBuffer(i, false);
          ab.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder pts: %s, not reach start: %s", new Object[] { Long.valueOf(l1), Long.valueOf(this.aZw * 1000L) });
          AppMethodBeat.o(50912);
          return false;
        }
        if (this.eRL.size != 0)
        {
          locala.position(this.eRL.offset);
          locala.limit(this.eRL.offset + this.eRL.size);
          long l2 = bo.yB();
          localObject = this.eRL;
          if (locala == null) {
            ab.e("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer error! byteBuffer is null");
          }
          for (;;)
          {
            ab.v("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer %s", new Object[] { Long.valueOf(bo.av(l2)) });
            this.eRD.releaseOutputBuffer(i, false);
            if ((this.eRN != 1L) && (l1 >= this.eRN * 1000L))
            {
              ab.e("MicroMsg.MediaCodecTranscodeDecoder", "exceed endTimeMs");
              AppMethodBeat.o(50912);
              return true;
              this.frameCount += 1;
              if ((this.eRW > 1) && (this.frameCount % this.eRW == 0)) {
                continue;
              }
              if (this.fYx == null) {
                this.fYx = new byte[locala.remaining()];
              }
              long l3 = bo.yB();
              try
              {
                this.fYw = this.eRD.getOutputFormat();
                locala.get(this.fYx, 0, locala.remaining());
                ab.i("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d cost %d", new Object[] { locala, localObject, Integer.valueOf(((MediaCodec.BufferInfo)localObject).size), Long.valueOf(bo.av(l3)) });
                if (this.fYv != null)
                {
                  locala = this.fYv;
                  byte[] arrayOfByte = this.fYx;
                  if ((((MediaCodec.BufferInfo)localObject).flags & 0x4) != 0)
                  {
                    bool = true;
                    locala.a(arrayOfByte, bool, ((MediaCodec.BufferInfo)localObject).presentationTimeUs);
                  }
                }
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  ab.e("MicroMsg.MediaCodecTranscodeDecoder", "get output format error");
                  continue;
                  boolean bool = false;
                }
              }
            }
          }
          if ((this.eRL.flags & 0x4) != 0)
          {
            ab.i("MicroMsg.MediaCodecTranscodeDecoder", "receive end of stream");
            try
            {
              this.eRD.stop();
              this.eRD.release();
              this.eRD = null;
              AppMethodBeat.o(50912);
              return true;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                ab.e("MicroMsg.MediaCodecTranscodeDecoder", "stop and release decoder error: %s", new Object[] { localException1.getMessage() });
              }
            }
          }
          AppMethodBeat.o(50912);
          return false;
        }
        this.eRD.releaseOutputBuffer(i, false);
      }
    }
  }
  
  private static int a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(50911);
    ab.i("MicroMsg.MediaCodecTranscodeDecoder", "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[] { paramString, paramMediaCodecInfo });
    long l = bo.yB();
    paramString = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    ab.i("MicroMsg.MediaCodecTranscodeDecoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bo.av(l)) });
    ab.i("MicroMsg.MediaCodecTranscodeDecoder", "color format length: %s", new Object[] { Integer.valueOf(paramString.colorFormats.length) });
    int i = 0;
    int j = 0;
    if (i < paramString.colorFormats.length)
    {
      int n = paramString.colorFormats[i];
      ab.i("MicroMsg.MediaCodecTranscodeDecoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(n) });
      switch (n)
      {
      }
      for (int m = 0;; m = 1)
      {
        int k = j;
        if (m != 0) {
          if (n <= j)
          {
            k = j;
            if (n != 21) {}
          }
          else
          {
            k = n;
          }
        }
        i += 1;
        j = k;
        break;
      }
    }
    ab.i("MicroMsg.MediaCodecTranscodeDecoder", "codec: %s, colorFormat: %s", new Object[] { paramMediaCodecInfo.getName(), Integer.valueOf(j) });
    AppMethodBeat.o(50911);
    return j;
  }
  
  private static MediaCodecInfo selectCodec(String paramString)
  {
    AppMethodBeat.i(50910);
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (!localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int j = 0;
        while (j < arrayOfString.length)
        {
          if (arrayOfString[j].equalsIgnoreCase(paramString))
          {
            AppMethodBeat.o(50910);
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(50910);
    return null;
  }
  
  public final void a(a.a parama)
  {
    this.fYv = parama;
  }
  
  public final Point amc()
  {
    AppMethodBeat.i(50915);
    Point localPoint = new Point(this.fYw.getInteger("width"), this.fYw.getInteger("height"));
    AppMethodBeat.o(50915);
    return localPoint;
  }
  
  public final int amd()
  {
    AppMethodBeat.i(50914);
    ab.i("MicroMsg.MediaCodecTranscodeDecoder", "src color format: %s", new Object[] { Integer.valueOf(this.eRx) });
    switch (this.eRx)
    {
    default: 
      AppMethodBeat.o(50914);
      return 1;
    case 19: 
      AppMethodBeat.o(50914);
      return 2;
    }
    AppMethodBeat.o(50914);
    return 1;
  }
  
  public final void mm(int paramInt)
  {
    AppMethodBeat.i(50917);
    ab.i("MicroMsg.MediaCodecTranscodeDecoder", "setFrameDropInterval: %s", new Object[] { Integer.valueOf(paramInt) });
    this.eRW = paramInt;
    AppMethodBeat.o(50917);
  }
  
  public final int p(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(50909);
    this.fVg = paramString;
    this.aZw = paramLong1;
    this.eRN = paramLong2;
    ab.i("MicroMsg.MediaCodecTranscodeDecoder", "initDecoder() called with: format = [" + this.fYw + "]");
    try
    {
      paramString = this.fYw.getString("mime");
      this.eRD = MediaCodec.createDecoderByType(paramString);
      MediaCodecInfo localMediaCodecInfo = selectCodec(paramString);
      ab.i("MicroMsg.MediaCodecTranscodeDecoder", "found codec: %s", new Object[] { localMediaCodecInfo });
      if (localMediaCodecInfo != null)
      {
        ab.i("MicroMsg.MediaCodecTranscodeDecoder", "codec name: %s", new Object[] { localMediaCodecInfo.getName() });
        this.eRx = a(localMediaCodecInfo, paramString);
        ab.i("MicroMsg.MediaCodecTranscodeDecoder", "found colorFormat: %s", new Object[] { Integer.valueOf(this.eRx) });
        this.fYw.setInteger("color-format", this.eRx);
      }
      this.eRD.configure(this.fYw, null, null, 0);
      this.eRD.start();
      AppMethodBeat.o(50909);
      return 0;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", paramString, "Init decoder failed : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(50909);
    }
    return -1;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(50916);
    if (this.eRD != null) {
      try
      {
        ab.i("MicroMsg.MediaCodecTranscodeDecoder", "stop decoder");
        this.eRD.stop();
        this.eRD.release();
        this.eRD = null;
        AppMethodBeat.o(50916);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", localException, "stop decoder error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(50916);
  }
  
  public final void y(Runnable paramRunnable)
  {
    AppMethodBeat.i(50913);
    this.frameCount = 0;
    Object localObject1 = this.cfO;
    if (this.eRD == null) {
      ab.i("MicroMsg.MediaCodecTranscodeDecoder", "input decoder is null");
    }
    Object localObject2;
    long l;
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1)
      {
        this.cfO.advance();
        if (this.cfO.getSampleTrackIndex() == this.eUR) {
          break;
        }
        ab.i("MicroMsg.MediaCodecTranscodeDecoder", "track index not match, break");
      }
      localObject1 = this.cfO;
      ab.i("MicroMsg.MediaCodecTranscodeDecoder", "sendDecoderEOS");
      localObject2 = this.eRD.getInputBuffers();
      i = this.eRD.dequeueInputBuffer(60000L);
      if (i < 0)
      {
        ab.i("MicroMsg.MediaCodecTranscodeDecoder", "check decoder input buffer index = %d count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
        if (UE()) {}
      }
      else
      {
        if (i >= 0)
        {
          localObject2 = localObject2[i];
          ((ByteBuffer)localObject2).clear();
          this.sampleSize = ((MediaExtractor)localObject1).readSampleData((ByteBuffer)localObject2, 0);
          ((ByteBuffer)localObject2).position(0);
          l = ((MediaExtractor)localObject1).getSampleTime();
          if (i < 0) {
            break label572;
          }
          ab.i("MicroMsg.MediaCodecTranscodeDecoder", "send EOS, decoderInputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
          this.eRD.queueInputBuffer(i, 0, 0, l * 1000L, 4);
        }
        label223:
        UE();
      }
      al.p(new d.1(this), 500L);
      paramRunnable.run();
      AppMethodBeat.o(50913);
      return;
      localObject2 = this.eRD.getInputBuffers();
      if (localObject2 != null) {
        break label275;
      }
    }
    label275:
    ab.i("MicroMsg.MediaCodecTranscodeDecoder", "decoderInputByteBuffers size: %d", new Object[] { Integer.valueOf(localObject2.length) });
    int i = 0;
    int j;
    for (;;)
    {
      j = this.eRD.dequeueInputBuffer(60000L);
      if ((j >= 0) || (i >= 15)) {
        break label371;
      }
      l = bo.yB();
      bool1 = UE();
      ab.i("MicroMsg.MediaCodecTranscodeDecoder", "drain cost1 %d", new Object[] { Long.valueOf(bo.av(l)) });
      if (bool1)
      {
        bool1 = true;
        break;
      }
      i += 1;
    }
    label371:
    if (j >= 0)
    {
      localObject2 = localObject2[j];
      ((ByteBuffer)localObject2).clear();
      this.sampleSize = ((MediaExtractor)localObject1).readSampleData((ByteBuffer)localObject2, 0);
      ((ByteBuffer)localObject2).position(0);
      l = ((MediaExtractor)localObject1).getSampleTime();
      ab.i("MicroMsg.MediaCodecTranscodeDecoder", "sampleTime: %s", new Object[] { Long.valueOf(l) });
      if ((this.sampleSize >= 0) && (l < this.eRN * 1000L)) {
        break label583;
      }
    }
    label572:
    label583:
    for (bool1 = true;; bool1 = false)
    {
      ab.i("MicroMsg.MediaCodecTranscodeDecoder", "sawInputEOS: %s", new Object[] { Boolean.valueOf(bool1) });
      localObject1 = this.eRD;
      int k = this.sampleSize;
      if (bool1)
      {
        i = 4;
        label496:
        ((MediaCodec)localObject1).queueInputBuffer(j, 0, k, l, i);
      }
      for (;;)
      {
        l = bo.yB();
        boolean bool2 = UE();
        ab.i("MicroMsg.MediaCodecTranscodeDecoder", "drain cost2 %d", new Object[] { Long.valueOf(bo.av(l)) });
        if (!bool2) {
          break;
        }
        bool1 = true;
        break;
        i = 0;
        break label496;
        ab.w("MicroMsg.MediaCodecTranscodeDecoder", "input buffer not available");
        bool1 = false;
      }
      ab.w("MicroMsg.MediaCodecTranscodeDecoder", "input buffer not available");
      break label223;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.bj.d
 * JD-Core Version:    0.7.0.1
 */