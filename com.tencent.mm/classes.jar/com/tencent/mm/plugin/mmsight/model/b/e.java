package com.tencent.mm.plugin.mmsight.model.b;

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

public final class e
  implements a
{
  protected long aZw;
  protected MediaExtractor cfO;
  protected MediaCodec eRD;
  protected MediaCodec.BufferInfo eRL;
  protected long eRN;
  protected int eRW;
  protected int eUR;
  protected String fVg;
  protected MediaFormat fYw;
  private byte[] fYx;
  private int frameCount;
  protected h oKg;
  private boolean oKj;
  protected int sampleSize;
  
  public e()
  {
    AppMethodBeat.i(76705);
    this.fVg = null;
    this.eRL = new MediaCodec.BufferInfo();
    this.eUR = -1;
    this.frameCount = 0;
    this.oKj = false;
    AppMethodBeat.o(76705);
  }
  
  private boolean UE()
  {
    AppMethodBeat.i(76709);
    if (this.eRD == null)
    {
      ab.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "drainDecoder, decoder is null");
      AppMethodBeat.o(76709);
      return true;
    }
    Object localObject = this.eRD.getOutputBuffers();
    ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoderOutputByteBuffers length: %s", new Object[] { Integer.valueOf(localObject.length) });
    int i = this.eRD.dequeueOutputBuffer(this.eRL, 60000L);
    ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "outputBufferIndex-->".concat(String.valueOf(i)));
    if (i == -1)
    {
      ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "no output from decoder available, break");
      label96:
      AppMethodBeat.o(76709);
      return false;
    }
    if (i == -3)
    {
      localObject = this.eRD.getOutputBuffers();
      ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder output buffers changed");
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
        ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder output format changed: " + this.fYw);
      }
      else if (i < 0)
      {
        ab.w("MicroMsg.MMSightRemuxMediaCodecDecoder", "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(i)));
      }
      else
      {
        ab.v("MicroMsg.MMSightRemuxMediaCodecDecoder", "perform decoding");
        h localh = localObject[i];
        if (localh == null) {
          break label96;
        }
        long l1 = this.eRL.presentationTimeUs;
        if ((l1 < this.aZw * 1000L) && ((this.eRL.flags & 0x4) == 0))
        {
          this.eRD.releaseOutputBuffer(i, false);
          ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder pts: %s, not reach start: %s", new Object[] { Long.valueOf(l1), Long.valueOf(this.aZw * 1000L) });
          AppMethodBeat.o(76709);
          return false;
        }
        if (this.eRL.size != 0)
        {
          localh.position(this.eRL.offset);
          localh.limit(this.eRL.offset + this.eRL.size);
          long l2 = bo.yB();
          localObject = this.eRL;
          if (localh == null) {
            ab.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer error! byteBuffer is null");
          }
          for (;;)
          {
            ab.v("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer %s", new Object[] { Long.valueOf(bo.av(l2)) });
            this.eRD.releaseOutputBuffer(i, false);
            if ((this.eRN != 1L) && (l1 >= this.eRN * 1000L))
            {
              ab.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "exceed endTimeMs");
              this.oKj = true;
              AppMethodBeat.o(76709);
              return true;
              this.frameCount += 1;
              if ((this.eRW > 1) && (this.frameCount % this.eRW == 0)) {
                continue;
              }
              if (this.fYx == null) {
                this.fYx = new byte[localh.remaining()];
              }
              long l3 = bo.yB();
              try
              {
                this.fYw = this.eRD.getOutputFormat();
                localh.get(this.fYx, 0, localh.remaining());
                ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d cost %d", new Object[] { localh, localObject, Integer.valueOf(((MediaCodec.BufferInfo)localObject).size), Long.valueOf(bo.av(l3)) });
                if (this.oKg != null) {
                  if ((this.eRN != 1L) && (((MediaCodec.BufferInfo)localObject).presentationTimeUs >= this.eRN * 1000L))
                  {
                    j = 1;
                    localh = this.oKg;
                    byte[] arrayOfByte = this.fYx;
                    if ((this.fYx != null) && (!this.oKj) && (j == 0)) {
                      break label683;
                    }
                    bool = true;
                    localh.a(arrayOfByte, bool, ((MediaCodec.BufferInfo)localObject).presentationTimeUs / 1000L);
                  }
                }
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  ab.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "get output format error");
                  continue;
                  j = 0;
                  continue;
                  label683:
                  boolean bool = false;
                }
              }
            }
          }
          if ((this.eRL.flags & 0x4) != 0)
          {
            ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "receive end of stream");
            try
            {
              this.eRD.stop();
              this.eRD.release();
              this.oKj = true;
              this.eRD = null;
              AppMethodBeat.o(76709);
              return true;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                ab.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "stop and release decoder error: %s", new Object[] { localException1.getMessage() });
              }
            }
          }
          AppMethodBeat.o(76709);
          return false;
        }
        this.eRD.releaseOutputBuffer(i, false);
      }
    }
  }
  
  private static int a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(76708);
    ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[] { paramString, paramMediaCodecInfo });
    long l = bo.yB();
    paramString = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bo.av(l)) });
    ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "color format length: %s", new Object[] { Integer.valueOf(paramString.colorFormats.length) });
    int i = 0;
    int j = 0;
    if (i < paramString.colorFormats.length)
    {
      int n = paramString.colorFormats[i];
      ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(n) });
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
    ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "codec: %s, colorFormat: %s", new Object[] { paramMediaCodecInfo.getName(), Integer.valueOf(j) });
    AppMethodBeat.o(76708);
    return j;
  }
  
  private static MediaCodecInfo selectCodec(String paramString)
  {
    AppMethodBeat.i(76707);
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
            AppMethodBeat.o(76707);
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(76707);
    return null;
  }
  
  public final void a(h paramh)
  {
    this.oKg = paramh;
  }
  
  public final Point amc()
  {
    AppMethodBeat.i(76712);
    Point localPoint = new Point(this.fYw.getInteger("width"), this.fYw.getInteger("height"));
    AppMethodBeat.o(76712);
    return localPoint;
  }
  
  public final int amd()
  {
    AppMethodBeat.i(76711);
    int i = this.fYw.getInteger("color-format");
    ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "src color format: %s", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      AppMethodBeat.o(76711);
      return 1;
    case 19: 
      AppMethodBeat.o(76711);
      return 2;
    }
    AppMethodBeat.o(76711);
    return 1;
  }
  
  public final void bRx()
  {
    AppMethodBeat.i(76710);
    this.frameCount = 0;
    this.oKj = false;
    Object localObject1 = this.cfO;
    if (this.eRD == null) {
      ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "input decoder is null");
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
        ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "track index not match, break");
      }
      localObject1 = this.cfO;
      ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sendDecoderEOS");
      localObject2 = this.eRD.getInputBuffers();
      i = this.eRD.dequeueInputBuffer(60000L);
      if (i < 0)
      {
        ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "check decoder input buffer index = %d count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
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
            break label581;
          }
          ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "send EOS, decoderInputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
          this.eRD.queueInputBuffer(i, 0, 0, l * 1000L, 4);
        }
        label228:
        this.oKj = true;
        UE();
      }
      al.p(new e.1(this), 500L);
      this.cfO.release();
      AppMethodBeat.o(76710);
      return;
      localObject2 = this.eRD.getInputBuffers();
      if (localObject2 != null) {
        break label286;
      }
    }
    label286:
    ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoderInputByteBuffers size: %d", new Object[] { Integer.valueOf(localObject2.length) });
    int i = 0;
    int j;
    for (;;)
    {
      j = this.eRD.dequeueInputBuffer(60000L);
      if ((j >= 0) || (i >= 15)) {
        break label382;
      }
      l = bo.yB();
      bool1 = UE();
      ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "drain cost1 %d", new Object[] { Long.valueOf(bo.av(l)) });
      if (bool1)
      {
        bool1 = true;
        break;
      }
      i += 1;
    }
    label382:
    if (j >= 0)
    {
      localObject2 = localObject2[j];
      ((ByteBuffer)localObject2).clear();
      this.sampleSize = ((MediaExtractor)localObject1).readSampleData((ByteBuffer)localObject2, 0);
      ((ByteBuffer)localObject2).position(0);
      l = ((MediaExtractor)localObject1).getSampleTime();
      ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sampleTime: %s", new Object[] { Long.valueOf(l) });
      if ((this.sampleSize >= 0) && (l < this.eRN * 1000L)) {
        break label592;
      }
    }
    label581:
    label592:
    for (bool1 = true;; bool1 = false)
    {
      ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sawInputEOS: %s", new Object[] { Boolean.valueOf(bool1) });
      localObject1 = this.eRD;
      int k = this.sampleSize;
      if (bool1)
      {
        i = 4;
        label506:
        ((MediaCodec)localObject1).queueInputBuffer(j, 0, k, l, i);
      }
      for (;;)
      {
        l = bo.yB();
        boolean bool2 = UE();
        ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "drain cost2 %d", new Object[] { Long.valueOf(bo.av(l)) });
        if (!bool2) {
          break;
        }
        bool1 = true;
        break;
        i = 0;
        break label506;
        ab.w("MicroMsg.MMSightRemuxMediaCodecDecoder", "input buffer not available");
        bool1 = false;
      }
      ab.w("MicroMsg.MMSightRemuxMediaCodecDecoder", "input buffer not available");
      break label228;
    }
  }
  
  public final int e(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(76706);
    if (!bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "initDecoder, srcFilePath: %s, startTime: %s, endTime: %s, videoFps: %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
      try
      {
        this.cfO = new MediaExtractor();
        this.cfO.setDataSource(paramString);
        paramInt = 0;
        for (;;)
        {
          if (paramInt < this.cfO.getTrackCount())
          {
            localObject = this.cfO.getTrackFormat(paramInt);
            if (((MediaFormat)localObject).getString("mime").toLowerCase().startsWith("video/"))
            {
              this.eUR = paramInt;
              this.fYw = ((MediaFormat)localObject);
            }
          }
          else
          {
            paramInt = this.eUR;
            if (paramInt >= 0) {
              break;
            }
            AppMethodBeat.o(76706);
            return -1;
          }
          paramInt += 1;
        }
        this.fVg = paramString;
        this.aZw = paramLong1;
        this.eRN = paramLong2;
        this.cfO.selectTrack(this.eUR);
        paramString = this.fYw.getString("mime");
        this.eRD = MediaCodec.createDecoderByType(paramString);
        Object localObject = selectCodec(paramString);
        ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "found codec: %s", new Object[] { localObject });
        if (localObject != null)
        {
          ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "codec name: %s", new Object[] { ((MediaCodecInfo)localObject).getName() });
          paramInt = a((MediaCodecInfo)localObject, paramString);
          ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "found colorFormat: %s", new Object[] { Integer.valueOf(paramInt) });
          this.fYw.setInteger("color-format", paramInt);
        }
        this.eRD.configure(this.fYw, null, null, 0);
        this.eRD.start();
        AppMethodBeat.o(76706);
        return 0;
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecDecoder", paramString, "Init decoder failed : %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(76706);
        return -1;
      }
    }
    AppMethodBeat.o(76706);
    return -1;
  }
  
  public final void mm(int paramInt)
  {
    AppMethodBeat.i(76713);
    ab.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "setFrameDropInterval: %s", new Object[] { Integer.valueOf(paramInt) });
    this.eRW = paramInt;
    AppMethodBeat.o(76713);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.e
 * JD-Core Version:    0.7.0.1
 */