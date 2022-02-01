package com.tencent.mm.plugin.mmsight.model.b;

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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.nio.ByteBuffer;

public final class e
  implements a
{
  protected MediaCodec.BufferInfo bufferInfo;
  protected long bvf;
  protected c cSi;
  private int frameCount;
  protected int gOI;
  protected z gOr;
  protected long gOz;
  protected int gRG;
  protected String hYr;
  protected MediaFormat ibK;
  private byte[] ibL;
  protected int sampleSize;
  protected h uNM;
  private boolean uNP;
  
  public e()
  {
    AppMethodBeat.i(89620);
    this.hYr = null;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.gRG = -1;
    this.frameCount = 0;
    this.uNP = false;
    AppMethodBeat.o(89620);
  }
  
  private boolean a(c paramc)
  {
    AppMethodBeat.i(89622);
    if (this.gOr == null)
    {
      ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "input decoder is null");
      AppMethodBeat.o(89622);
      return true;
    }
    Object localObject = this.gOr.getInputBuffers();
    if (localObject == null)
    {
      AppMethodBeat.o(89622);
      return false;
    }
    ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoderInputByteBuffers size: %d", new Object[] { Integer.valueOf(localObject.length) });
    int i = 0;
    int j;
    long l;
    for (;;)
    {
      j = this.gOr.dequeueInputBuffer(60000L);
      if ((j >= 0) || (i >= 15)) {
        break;
      }
      l = bs.Gn();
      bool1 = aqv();
      ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "drain cost1 %d", new Object[] { Long.valueOf(bs.aO(l)) });
      if (bool1)
      {
        AppMethodBeat.o(89622);
        return true;
      }
      i += 1;
    }
    if (j >= 0)
    {
      localObject = localObject[j];
      ((ByteBuffer)localObject).clear();
      this.sampleSize = paramc.j((ByteBuffer)localObject);
      ((ByteBuffer)localObject).position(0);
      l = paramc.fKr.getSampleTime();
      ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sampleTime: %s", new Object[] { Long.valueOf(l) });
      if ((this.sampleSize >= 0) && (l < this.gOz * 1000L)) {
        break label345;
      }
    }
    label337:
    label345:
    for (boolean bool1 = true;; bool1 = false)
    {
      ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sawInputEOS: %s", new Object[] { Boolean.valueOf(bool1) });
      paramc = this.gOr;
      int k = this.sampleSize;
      if (bool1)
      {
        i = 4;
        paramc.a(j, k, l, i);
      }
      for (;;)
      {
        l = bs.Gn();
        boolean bool2 = aqv();
        ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "drain cost2 %d", new Object[] { Long.valueOf(bs.aO(l)) });
        if (!bool2) {
          break label337;
        }
        AppMethodBeat.o(89622);
        return true;
        i = 0;
        break;
        ac.w("MicroMsg.MMSightRemuxMediaCodecDecoder", "input buffer not available");
        bool1 = false;
      }
      AppMethodBeat.o(89622);
      return bool1;
    }
  }
  
  private boolean aqv()
  {
    AppMethodBeat.i(89623);
    if (this.gOr == null)
    {
      ac.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "drainDecoder, decoder is null");
      AppMethodBeat.o(89623);
      return true;
    }
    Object localObject = this.gOr.getOutputBuffers();
    ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoderOutputByteBuffers length: %s", new Object[] { Integer.valueOf(localObject.length) });
    int i = this.gOr.dequeueOutputBuffer(this.bufferInfo, 60000L);
    ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "outputBufferIndex-->".concat(String.valueOf(i)));
    if (i == -1)
    {
      ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "no output from decoder available, break");
      label96:
      AppMethodBeat.o(89623);
      return false;
    }
    if (i == -3)
    {
      localObject = this.gOr.getOutputBuffers();
      ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder output buffers changed");
    }
    for (;;)
    {
      int j = this.gOr.dequeueOutputBuffer(this.bufferInfo, 60000L);
      i = j;
      if (j >= 0) {
        break;
      }
      break label96;
      if (i == -2)
      {
        this.ibK = this.gOr.getOutputFormat();
        ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder output format changed: " + this.ibK);
      }
      else if (i < 0)
      {
        ac.w("MicroMsg.MMSightRemuxMediaCodecDecoder", "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(i)));
      }
      else
      {
        ac.v("MicroMsg.MMSightRemuxMediaCodecDecoder", "perform decoding");
        h localh = localObject[i];
        if (localh == null) {
          break label96;
        }
        long l1 = this.bufferInfo.presentationTimeUs;
        if ((l1 < this.bvf * 1000L) && ((this.bufferInfo.flags & 0x4) == 0))
        {
          this.gOr.releaseOutputBuffer(i, false);
          ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder pts: %s, not reach start: %s", new Object[] { Long.valueOf(l1), Long.valueOf(this.bvf * 1000L) });
          AppMethodBeat.o(89623);
          return false;
        }
        if (this.bufferInfo.size != 0)
        {
          localh.position(this.bufferInfo.offset);
          localh.limit(this.bufferInfo.offset + this.bufferInfo.size);
          long l2 = bs.Gn();
          localObject = this.bufferInfo;
          if (localh == null) {
            ac.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer error! byteBuffer is null");
          }
          for (;;)
          {
            ac.v("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer %s", new Object[] { Long.valueOf(bs.aO(l2)) });
            this.gOr.releaseOutputBuffer(i, false);
            if ((this.gOz != 1L) && (l1 >= this.gOz * 1000L))
            {
              ac.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "exceed endTimeMs");
              this.uNP = true;
              AppMethodBeat.o(89623);
              return true;
              this.frameCount += 1;
              if ((this.gOI > 1) && (this.frameCount % this.gOI == 0)) {
                continue;
              }
              if (this.ibL == null) {
                this.ibL = new byte[localh.remaining()];
              }
              long l3 = bs.Gn();
              try
              {
                this.ibK = this.gOr.getOutputFormat();
                localh.get(this.ibL, 0, localh.remaining());
                ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d cost %d", new Object[] { localh, localObject, Integer.valueOf(((MediaCodec.BufferInfo)localObject).size), Long.valueOf(bs.aO(l3)) });
                if (this.uNM != null) {
                  if ((this.gOz != 1L) && (((MediaCodec.BufferInfo)localObject).presentationTimeUs >= this.gOz * 1000L))
                  {
                    j = 1;
                    localh = this.uNM;
                    byte[] arrayOfByte = this.ibL;
                    if ((this.ibL != null) && (!this.uNP) && (j == 0)) {
                      break label686;
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
                  ac.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "get output format error");
                  continue;
                  j = 0;
                  continue;
                  label686:
                  boolean bool = false;
                }
              }
            }
          }
          if ((this.bufferInfo.flags & 0x4) != 0)
          {
            ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "receive end of stream");
            try
            {
              this.gOr.stop();
              this.gOr.release();
              this.uNP = true;
              this.gOr = null;
              AppMethodBeat.o(89623);
              return true;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                ac.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "stop and release decoder error: %s", new Object[] { localException1.getMessage() });
              }
            }
          }
          AppMethodBeat.o(89623);
          return false;
        }
        this.gOr.releaseOutputBuffer(i, false);
      }
    }
  }
  
  public final void a(h paramh)
  {
    this.uNM = paramh;
  }
  
  public final Point aJY()
  {
    AppMethodBeat.i(89626);
    Point localPoint = new Point(this.ibK.getInteger("width"), this.ibK.getInteger("height"));
    AppMethodBeat.o(89626);
    return localPoint;
  }
  
  public final int aJZ()
  {
    AppMethodBeat.i(89625);
    int i = this.ibK.getInteger("color-format");
    ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "src color format: %s", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      AppMethodBeat.o(89625);
      return 1;
    case 19: 
      AppMethodBeat.o(89625);
      return 2;
    }
    AppMethodBeat.o(89625);
    return 1;
  }
  
  public final void dea()
  {
    AppMethodBeat.i(89624);
    this.frameCount = 0;
    this.uNP = false;
    while (!a(this.cSi))
    {
      this.cSi.fKr.advance();
      if (this.cSi.fKr.getSampleTrackIndex() != this.gRG) {
        ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "track index not match, break");
      }
    }
    c localc = this.cSi;
    ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sendDecoderEOS");
    Object localObject = this.gOr.getInputBuffers();
    int i = this.gOr.dequeueInputBuffer(60000L);
    if (i < 0)
    {
      ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "check decoder input buffer index = %d count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      if (aqv()) {}
    }
    else if (i >= 0)
    {
      localObject = localObject[i];
      ((ByteBuffer)localObject).clear();
      this.sampleSize = localc.j((ByteBuffer)localObject);
      ((ByteBuffer)localObject).position(0);
      long l = localc.fKr.getSampleTime();
      if (i < 0) {
        break label256;
      }
      ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "send EOS, decoderInputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
      this.gOr.a(i, 0, l * 1000L, 4);
    }
    for (;;)
    {
      this.uNP = true;
      aqv();
      ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89619);
          if (e.this.gOr != null)
          {
            ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "delay to stop decoder");
            try
            {
              e.this.gOr.stop();
              e.this.gOr.release();
              e.this.gOr = null;
              AppMethodBeat.o(89619);
              return;
            }
            catch (Exception localException)
            {
              ac.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecDecoder", localException, "delay to stop decoder error: %s", new Object[] { localException.getMessage() });
            }
          }
          AppMethodBeat.o(89619);
        }
      }, 500L);
      this.cSi.fKr.release();
      AppMethodBeat.o(89624);
      return;
      label256:
      ac.w("MicroMsg.MMSightRemuxMediaCodecDecoder", "input buffer not available");
    }
  }
  
  public final int e(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(89621);
    int j;
    int i;
    label245:
    int m;
    if (!bs.isNullOrNil(paramString))
    {
      ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "initDecoder, srcFilePath: %s, startTime: %s, endTime: %s, videoFps: %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
      try
      {
        this.cSi = new c();
        this.cSi.sI(paramString);
        paramInt = 0;
        for (;;)
        {
          if (paramInt < this.cSi.fKr.getTrackCount())
          {
            localObject = this.cSi.getTrackFormat(paramInt);
            if (((MediaFormat)localObject).getString("mime").toLowerCase().startsWith("video/"))
            {
              this.gRG = paramInt;
              this.ibK = ((MediaFormat)localObject);
            }
          }
          else
          {
            paramInt = this.gRG;
            if (paramInt >= 0) {
              break;
            }
            AppMethodBeat.o(89621);
            return -1;
          }
          paramInt += 1;
        }
        this.hYr = paramString;
        this.bvf = paramLong1;
        this.gOz = paramLong2;
        this.cSi.selectTrack(this.gRG);
        Object localObject = this.ibK.getString("mime");
        this.gOr = z.sx((String)localObject);
        j = MediaCodecList.getCodecCount();
        paramInt = 0;
        if (paramInt >= j) {
          break label649;
        }
        paramString = MediaCodecList.getCodecInfoAt(paramInt);
        if (paramString.isEncoder()) {
          break label640;
        }
        String[] arrayOfString = paramString.getSupportedTypes();
        i = 0;
        if (i >= arrayOfString.length) {
          break label640;
        }
        if (!arrayOfString[i].equalsIgnoreCase((String)localObject)) {
          break label631;
        }
        label266:
        ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "found codec: %s", new Object[] { paramString });
        if (paramString != null)
        {
          ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "codec name: %s", new Object[] { paramString.getName() });
          ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[] { localObject, paramString });
          i = 0;
          paramLong1 = bs.Gn();
          localObject = paramString.getCapabilitiesForType((String)localObject);
          ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bs.aO(paramLong1)) });
          ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "color format length: %s", new Object[] { Integer.valueOf(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats.length) });
          paramInt = 0;
          label390:
          if (paramInt < ((MediaCodecInfo.CodecCapabilities)localObject).colorFormats.length)
          {
            m = localObject.colorFormats[paramInt];
            ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(m) });
          }
        }
        switch (m)
        {
        case 20: 
          ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "codec: %s, colorFormat: %s", new Object[] { paramString.getName(), Integer.valueOf(i) });
          ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "found colorFormat: %s", new Object[] { Integer.valueOf(i) });
          this.ibK.setInteger("color-format", i);
          this.gOr.a(this.ibK, null, 0);
          this.gOr.start();
          AppMethodBeat.o(89621);
          return 0;
        }
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecDecoder", paramString, "Init decoder failed : %s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(89621);
        return -1;
      }
    }
    else
    {
      AppMethodBeat.o(89621);
      return -1;
    }
    for (int k = 0;; k = 1)
    {
      j = i;
      if (k != 0) {
        if (m <= i)
        {
          j = i;
          if (m != 21) {}
        }
        else
        {
          j = m;
        }
      }
      paramInt += 1;
      i = j;
      break label390;
      label631:
      i += 1;
      break label245;
      label640:
      paramInt += 1;
      break;
      label649:
      paramString = null;
      break label266;
    }
  }
  
  public final void pK(int paramInt)
  {
    AppMethodBeat.i(89627);
    ac.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "setFrameDropInterval: %s", new Object[] { Integer.valueOf(paramInt) });
    this.gOI = paramInt;
    AppMethodBeat.o(89627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.e
 * JD-Core Version:    0.7.0.1
 */