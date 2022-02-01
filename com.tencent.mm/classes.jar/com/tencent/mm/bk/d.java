package com.tencent.mm.bk;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.compatible.h.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class d
  implements a
{
  protected MediaCodec.BufferInfo bufferInfo;
  protected c deA;
  private int frameCount;
  private int hkE;
  protected z hlf;
  protected long hlm;
  protected int hlw;
  protected int hmM;
  protected String iuH;
  protected a.a ixZ;
  protected MediaFormat iya;
  private byte[] iyb;
  protected int sampleSize;
  protected long startTimeMs;
  
  public d(c paramc, MediaFormat paramMediaFormat, int paramInt)
  {
    AppMethodBeat.i(127078);
    this.iuH = null;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.frameCount = 0;
    this.hkE = -1;
    ae.i("MicroMsg.MediaCodecTranscodeDecoder", "create MediaCodecTranscodeDecoder: %s, %s, %s", new Object[] { paramc, paramMediaFormat, Integer.valueOf(paramInt) });
    this.deA = paramc;
    this.iya = paramMediaFormat;
    this.hmM = paramInt;
    AppMethodBeat.o(127078);
  }
  
  private static int a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(127081);
    ae.i("MicroMsg.MediaCodecTranscodeDecoder", "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[] { paramString, paramMediaCodecInfo });
    long l = bu.HQ();
    paramString = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    ae.i("MicroMsg.MediaCodecTranscodeDecoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
    ae.i("MicroMsg.MediaCodecTranscodeDecoder", "color format length: %s", new Object[] { Integer.valueOf(paramString.colorFormats.length) });
    int i = 0;
    int j = 0;
    if (i < paramString.colorFormats.length)
    {
      int n = paramString.colorFormats[i];
      ae.i("MicroMsg.MediaCodecTranscodeDecoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(n) });
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
    ae.i("MicroMsg.MediaCodecTranscodeDecoder", "codec: %s, colorFormat: %s", new Object[] { paramMediaCodecInfo.getName(), Integer.valueOf(j) });
    AppMethodBeat.o(127081);
    return j;
  }
  
  private boolean a(c paramc)
  {
    AppMethodBeat.i(127082);
    if (this.hlf == null)
    {
      ae.i("MicroMsg.MediaCodecTranscodeDecoder", "input decoder is null");
      AppMethodBeat.o(127082);
      return true;
    }
    Object localObject = this.hlf.getInputBuffers();
    if (localObject == null)
    {
      AppMethodBeat.o(127082);
      return false;
    }
    ae.i("MicroMsg.MediaCodecTranscodeDecoder", "decoderInputByteBuffers size: %d", new Object[] { Integer.valueOf(localObject.length) });
    int i = 0;
    int j;
    long l;
    for (;;)
    {
      j = this.hlf.dequeueInputBuffer(60000L);
      if ((j >= 0) || (i >= 15)) {
        break;
      }
      l = bu.HQ();
      bool1 = atF();
      ae.i("MicroMsg.MediaCodecTranscodeDecoder", "drain cost1 %d", new Object[] { Long.valueOf(bu.aO(l)) });
      if (bool1)
      {
        AppMethodBeat.o(127082);
        return true;
      }
      i += 1;
    }
    if (j >= 0)
    {
      localObject = localObject[j];
      ((ByteBuffer)localObject).clear();
      this.sampleSize = paramc.readSampleData((ByteBuffer)localObject, 0);
      ((ByteBuffer)localObject).position(0);
      l = paramc.gga.getSampleTime();
      ae.i("MicroMsg.MediaCodecTranscodeDecoder", "sampleTime: %s", new Object[] { Long.valueOf(l) });
      if ((this.sampleSize >= 0) && (l < this.hlm * 1000L)) {
        break label346;
      }
    }
    label338:
    label346:
    for (boolean bool1 = true;; bool1 = false)
    {
      ae.i("MicroMsg.MediaCodecTranscodeDecoder", "sawInputEOS: %s", new Object[] { Boolean.valueOf(bool1) });
      paramc = this.hlf;
      int k = this.sampleSize;
      if (bool1)
      {
        i = 4;
        paramc.a(j, k, l, i);
      }
      for (;;)
      {
        l = bu.HQ();
        boolean bool2 = atF();
        ae.i("MicroMsg.MediaCodecTranscodeDecoder", "drain cost2 %d", new Object[] { Long.valueOf(bu.aO(l)) });
        if (!bool2) {
          break label338;
        }
        AppMethodBeat.o(127082);
        return true;
        i = 0;
        break;
        ae.w("MicroMsg.MediaCodecTranscodeDecoder", "input buffer not available");
        bool1 = false;
      }
      AppMethodBeat.o(127082);
      return bool1;
    }
  }
  
  private boolean atF()
  {
    AppMethodBeat.i(127083);
    if (this.hlf == null)
    {
      ae.e("MicroMsg.MediaCodecTranscodeDecoder", "drainDecoder, decoder is null");
      AppMethodBeat.o(127083);
      return true;
    }
    Object localObject = this.hlf.getOutputBuffers();
    ae.i("MicroMsg.MediaCodecTranscodeDecoder", "decoderOutputByteBuffers length: %s", new Object[] { Integer.valueOf(localObject.length) });
    int i = this.hlf.dequeueOutputBuffer(this.bufferInfo, 60000L);
    ae.i("MicroMsg.MediaCodecTranscodeDecoder", "outputBufferIndex-->".concat(String.valueOf(i)));
    if (i == -1)
    {
      ae.i("MicroMsg.MediaCodecTranscodeDecoder", "no output from decoder available, break");
      label96:
      AppMethodBeat.o(127083);
      return false;
    }
    if (i == -3)
    {
      localObject = this.hlf.getOutputBuffers();
      ae.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output buffers changed");
    }
    for (;;)
    {
      int j = this.hlf.dequeueOutputBuffer(this.bufferInfo, 60000L);
      i = j;
      if (j >= 0) {
        break;
      }
      break label96;
      if (i == -2)
      {
        this.iya = this.hlf.getOutputFormat();
        ae.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output format changed: " + this.iya);
      }
      else if (i < 0)
      {
        ae.w("MicroMsg.MediaCodecTranscodeDecoder", "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(i)));
      }
      else
      {
        ae.v("MicroMsg.MediaCodecTranscodeDecoder", "perform decoding");
        a.a locala = localObject[i];
        if (locala == null) {
          break label96;
        }
        long l1 = this.bufferInfo.presentationTimeUs;
        if ((l1 < this.startTimeMs * 1000L) && ((this.bufferInfo.flags & 0x4) == 0))
        {
          this.hlf.releaseOutputBuffer(i, false);
          ae.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder pts: %s, not reach start: %s", new Object[] { Long.valueOf(l1), Long.valueOf(this.startTimeMs * 1000L) });
          AppMethodBeat.o(127083);
          return false;
        }
        if (this.bufferInfo.size != 0)
        {
          locala.position(this.bufferInfo.offset);
          locala.limit(this.bufferInfo.offset + this.bufferInfo.size);
          long l2 = bu.HQ();
          localObject = this.bufferInfo;
          if (locala == null) {
            ae.e("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer error! byteBuffer is null");
          }
          for (;;)
          {
            ae.v("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer %s", new Object[] { Long.valueOf(bu.aO(l2)) });
            this.hlf.releaseOutputBuffer(i, false);
            if ((this.hlm != 1L) && (l1 >= this.hlm * 1000L))
            {
              ae.e("MicroMsg.MediaCodecTranscodeDecoder", "exceed endTimeMs");
              AppMethodBeat.o(127083);
              return true;
              this.frameCount += 1;
              if ((this.hlw > 1) && (this.frameCount % this.hlw == 0)) {
                continue;
              }
              if (this.iyb == null) {
                this.iyb = new byte[locala.remaining()];
              }
              long l3 = bu.HQ();
              try
              {
                this.iya = this.hlf.getOutputFormat();
                locala.get(this.iyb, 0, locala.remaining());
                ae.i("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d cost %d", new Object[] { locala, localObject, Integer.valueOf(((MediaCodec.BufferInfo)localObject).size), Long.valueOf(bu.aO(l3)) });
                if (this.ixZ != null)
                {
                  locala = this.ixZ;
                  byte[] arrayOfByte = this.iyb;
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
                  ae.e("MicroMsg.MediaCodecTranscodeDecoder", "get output format error");
                  continue;
                  boolean bool = false;
                }
              }
            }
          }
          if ((this.bufferInfo.flags & 0x4) != 0)
          {
            ae.i("MicroMsg.MediaCodecTranscodeDecoder", "receive end of stream");
            try
            {
              this.hlf.stop();
              this.hlf.release();
              this.hlf = null;
              AppMethodBeat.o(127083);
              return true;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                ae.e("MicroMsg.MediaCodecTranscodeDecoder", "stop and release decoder error: %s", new Object[] { localException1.getMessage() });
              }
            }
          }
          AppMethodBeat.o(127083);
          return false;
        }
        this.hlf.releaseOutputBuffer(i, false);
      }
    }
  }
  
  private static MediaCodecInfo selectCodec(String paramString)
  {
    AppMethodBeat.i(127080);
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
            AppMethodBeat.o(127080);
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(127080);
    return null;
  }
  
  public final void F(Runnable paramRunnable)
  {
    AppMethodBeat.i(127084);
    this.frameCount = 0;
    while (!a(this.deA))
    {
      this.deA.gga.advance();
      if (this.deA.gga.getSampleTrackIndex() != this.hmM) {
        ae.i("MicroMsg.MediaCodecTranscodeDecoder", "track index not match, break");
      }
    }
    c localc = this.deA;
    ae.i("MicroMsg.MediaCodecTranscodeDecoder", "sendDecoderEOS");
    Object localObject = this.hlf.getInputBuffers();
    int i = this.hlf.dequeueInputBuffer(60000L);
    if (i < 0)
    {
      ae.i("MicroMsg.MediaCodecTranscodeDecoder", "check decoder input buffer index = %d count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      if (atF()) {}
    }
    else if (i >= 0)
    {
      localObject = localObject[i];
      ((ByteBuffer)localObject).clear();
      this.sampleSize = localc.readSampleData((ByteBuffer)localObject, 0);
      ((ByteBuffer)localObject).position(0);
      long l = localc.gga.getSampleTime();
      if (i < 0) {
        break label243;
      }
      ae.i("MicroMsg.MediaCodecTranscodeDecoder", "send EOS, decoderInputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
      this.hlf.a(i, 0, l * 1000L, 4);
    }
    for (;;)
    {
      atF();
      ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127077);
          if (d.this.hlf != null)
          {
            ae.i("MicroMsg.MediaCodecTranscodeDecoder", "delay to stop decoder");
            try
            {
              d.this.hlf.stop();
              d.this.hlf.release();
              d.this.hlf = null;
              AppMethodBeat.o(127077);
              return;
            }
            catch (Exception localException)
            {
              ae.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", localException, "delay to stop decoder error: %s", new Object[] { localException.getMessage() });
            }
          }
          AppMethodBeat.o(127077);
        }
      }, 500L);
      paramRunnable.run();
      AppMethodBeat.o(127084);
      return;
      label243:
      ae.w("MicroMsg.MediaCodecTranscodeDecoder", "input buffer not available");
    }
  }
  
  public final void a(a.a parama)
  {
    this.ixZ = parama;
  }
  
  public final Point aNF()
  {
    AppMethodBeat.i(127086);
    Point localPoint = new Point(this.iya.getInteger("width"), this.iya.getInteger("height"));
    AppMethodBeat.o(127086);
    return localPoint;
  }
  
  public final int aNG()
  {
    AppMethodBeat.i(127085);
    ae.i("MicroMsg.MediaCodecTranscodeDecoder", "src color format: %s", new Object[] { Integer.valueOf(this.hkE) });
    switch (this.hkE)
    {
    default: 
      AppMethodBeat.o(127085);
      return 1;
    case 19: 
      AppMethodBeat.o(127085);
      return 2;
    }
    AppMethodBeat.o(127085);
    return 1;
  }
  
  public final int n(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(127079);
    this.iuH = paramString;
    this.startTimeMs = paramLong1;
    this.hlm = paramLong2;
    ae.i("MicroMsg.MediaCodecTranscodeDecoder", "initDecoder() called with: format = [" + this.iya + "]");
    try
    {
      paramString = this.iya.getString("mime");
      this.hlf = z.vI(paramString);
      MediaCodecInfo localMediaCodecInfo = selectCodec(paramString);
      ae.i("MicroMsg.MediaCodecTranscodeDecoder", "found codec: %s", new Object[] { localMediaCodecInfo });
      if (localMediaCodecInfo != null)
      {
        ae.i("MicroMsg.MediaCodecTranscodeDecoder", "codec name: %s", new Object[] { localMediaCodecInfo.getName() });
        this.hkE = a(localMediaCodecInfo, paramString);
        ae.i("MicroMsg.MediaCodecTranscodeDecoder", "found colorFormat: %s", new Object[] { Integer.valueOf(this.hkE) });
        this.iya.setInteger("color-format", this.hkE);
      }
      this.hlf.a(this.iya, null, 0);
      this.hlf.start();
      AppMethodBeat.o(127079);
      return 0;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", paramString, "Init decoder failed : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(127079);
    }
    return -1;
  }
  
  public final void qp(int paramInt)
  {
    AppMethodBeat.i(127088);
    ae.i("MicroMsg.MediaCodecTranscodeDecoder", "setFrameDropInterval: %s", new Object[] { Integer.valueOf(paramInt) });
    this.hlw = paramInt;
    AppMethodBeat.o(127088);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(127087);
    if (this.hlf != null) {
      try
      {
        ae.i("MicroMsg.MediaCodecTranscodeDecoder", "stop decoder");
        this.hlf.stop();
        this.hlf.release();
        this.hlf = null;
        AppMethodBeat.o(127087);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", localException, "stop decoder error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(127087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bk.d
 * JD-Core Version:    0.7.0.1
 */