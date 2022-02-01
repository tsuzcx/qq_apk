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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.nio.ByteBuffer;

public final class e
  implements a
{
  protected MediaCodec.BufferInfo bufferInfo;
  protected c deA;
  private int frameCount;
  protected z hlf;
  protected long hlm;
  protected int hlw;
  protected int hmM;
  protected String iuH;
  protected MediaFormat iya;
  private byte[] iyb;
  protected int sampleSize;
  protected long startTimeMs;
  protected h wcZ;
  private boolean wdc;
  
  public e()
  {
    AppMethodBeat.i(89620);
    this.iuH = null;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.hmM = -1;
    this.frameCount = 0;
    this.wdc = false;
    AppMethodBeat.o(89620);
  }
  
  private boolean a(c paramc)
  {
    AppMethodBeat.i(89622);
    if (this.hlf == null)
    {
      ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "input decoder is null");
      AppMethodBeat.o(89622);
      return true;
    }
    Object localObject = this.hlf.getInputBuffers();
    if (localObject == null)
    {
      AppMethodBeat.o(89622);
      return false;
    }
    ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoderInputByteBuffers size: %d", new Object[] { Integer.valueOf(localObject.length) });
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
      ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "drain cost1 %d", new Object[] { Long.valueOf(bu.aO(l)) });
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
      this.sampleSize = paramc.readSampleData((ByteBuffer)localObject, 0);
      ((ByteBuffer)localObject).position(0);
      l = paramc.gga.getSampleTime();
      ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sampleTime: %s", new Object[] { Long.valueOf(l) });
      if ((this.sampleSize >= 0) && (l < this.hlm * 1000L)) {
        break label346;
      }
    }
    label338:
    label346:
    for (boolean bool1 = true;; bool1 = false)
    {
      ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sawInputEOS: %s", new Object[] { Boolean.valueOf(bool1) });
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
        ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "drain cost2 %d", new Object[] { Long.valueOf(bu.aO(l)) });
        if (!bool2) {
          break label338;
        }
        AppMethodBeat.o(89622);
        return true;
        i = 0;
        break;
        ae.w("MicroMsg.MMSightRemuxMediaCodecDecoder", "input buffer not available");
        bool1 = false;
      }
      AppMethodBeat.o(89622);
      return bool1;
    }
  }
  
  private boolean atF()
  {
    AppMethodBeat.i(89623);
    if (this.hlf == null)
    {
      ae.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "drainDecoder, decoder is null");
      AppMethodBeat.o(89623);
      return true;
    }
    Object localObject = this.hlf.getOutputBuffers();
    ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoderOutputByteBuffers length: %s", new Object[] { Integer.valueOf(localObject.length) });
    int i = this.hlf.dequeueOutputBuffer(this.bufferInfo, 60000L);
    ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "outputBufferIndex-->".concat(String.valueOf(i)));
    if (i == -1)
    {
      ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "no output from decoder available, break");
      label96:
      AppMethodBeat.o(89623);
      return false;
    }
    if (i == -3)
    {
      localObject = this.hlf.getOutputBuffers();
      ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder output buffers changed");
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
        ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder output format changed: " + this.iya);
      }
      else if (i < 0)
      {
        ae.w("MicroMsg.MMSightRemuxMediaCodecDecoder", "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(i)));
      }
      else
      {
        ae.v("MicroMsg.MMSightRemuxMediaCodecDecoder", "perform decoding");
        h localh = localObject[i];
        if (localh == null) {
          break label96;
        }
        long l1 = this.bufferInfo.presentationTimeUs;
        if ((l1 < this.startTimeMs * 1000L) && ((this.bufferInfo.flags & 0x4) == 0))
        {
          this.hlf.releaseOutputBuffer(i, false);
          ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder pts: %s, not reach start: %s", new Object[] { Long.valueOf(l1), Long.valueOf(this.startTimeMs * 1000L) });
          AppMethodBeat.o(89623);
          return false;
        }
        if (this.bufferInfo.size != 0)
        {
          localh.position(this.bufferInfo.offset);
          localh.limit(this.bufferInfo.offset + this.bufferInfo.size);
          long l2 = bu.HQ();
          localObject = this.bufferInfo;
          if (localh == null) {
            ae.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer error! byteBuffer is null");
          }
          for (;;)
          {
            ae.v("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer %s", new Object[] { Long.valueOf(bu.aO(l2)) });
            this.hlf.releaseOutputBuffer(i, false);
            if ((this.hlm != 1L) && (l1 >= this.hlm * 1000L))
            {
              ae.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "exceed endTimeMs");
              this.wdc = true;
              AppMethodBeat.o(89623);
              return true;
              this.frameCount += 1;
              if ((this.hlw > 1) && (this.frameCount % this.hlw == 0)) {
                continue;
              }
              if (this.iyb == null) {
                this.iyb = new byte[localh.remaining()];
              }
              long l3 = bu.HQ();
              try
              {
                this.iya = this.hlf.getOutputFormat();
                localh.get(this.iyb, 0, localh.remaining());
                ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d cost %d", new Object[] { localh, localObject, Integer.valueOf(((MediaCodec.BufferInfo)localObject).size), Long.valueOf(bu.aO(l3)) });
                if (this.wcZ != null) {
                  if ((this.hlm != 1L) && (((MediaCodec.BufferInfo)localObject).presentationTimeUs >= this.hlm * 1000L))
                  {
                    j = 1;
                    localh = this.wcZ;
                    byte[] arrayOfByte = this.iyb;
                    if ((this.iyb != null) && (!this.wdc) && (j == 0)) {
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
                  ae.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "get output format error");
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
            ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "receive end of stream");
            try
            {
              this.hlf.stop();
              this.hlf.release();
              this.wdc = true;
              this.hlf = null;
              AppMethodBeat.o(89623);
              return true;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                ae.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "stop and release decoder error: %s", new Object[] { localException1.getMessage() });
              }
            }
          }
          AppMethodBeat.o(89623);
          return false;
        }
        this.hlf.releaseOutputBuffer(i, false);
      }
    }
  }
  
  public final void a(h paramh)
  {
    this.wcZ = paramh;
  }
  
  public final Point aNF()
  {
    AppMethodBeat.i(89626);
    Point localPoint = new Point(this.iya.getInteger("width"), this.iya.getInteger("height"));
    AppMethodBeat.o(89626);
    return localPoint;
  }
  
  public final int aNG()
  {
    AppMethodBeat.i(89625);
    int i = this.iya.getInteger("color-format");
    ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "src color format: %s", new Object[] { Integer.valueOf(i) });
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
  
  public final void dqw()
  {
    AppMethodBeat.i(89624);
    this.frameCount = 0;
    this.wdc = false;
    while (!a(this.deA))
    {
      this.deA.gga.advance();
      if (this.deA.gga.getSampleTrackIndex() != this.hmM) {
        ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "track index not match, break");
      }
    }
    c localc = this.deA;
    ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sendDecoderEOS");
    Object localObject = this.hlf.getInputBuffers();
    int i = this.hlf.dequeueInputBuffer(60000L);
    if (i < 0)
    {
      ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "check decoder input buffer index = %d count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
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
        break label257;
      }
      ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "send EOS, decoderInputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
      this.hlf.a(i, 0, l * 1000L, 4);
    }
    for (;;)
    {
      this.wdc = true;
      atF();
      ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89619);
          if (e.this.hlf != null)
          {
            ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "delay to stop decoder");
            try
            {
              e.this.hlf.stop();
              e.this.hlf.release();
              e.this.hlf = null;
              AppMethodBeat.o(89619);
              return;
            }
            catch (Exception localException)
            {
              ae.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecDecoder", localException, "delay to stop decoder error: %s", new Object[] { localException.getMessage() });
            }
          }
          AppMethodBeat.o(89619);
        }
      }, 500L);
      this.deA.gga.release();
      AppMethodBeat.o(89624);
      return;
      label257:
      ae.w("MicroMsg.MMSightRemuxMediaCodecDecoder", "input buffer not available");
    }
  }
  
  public final int e(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(89621);
    int j;
    int i;
    label245:
    int m;
    if (!bu.isNullOrNil(paramString))
    {
      ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "initDecoder, srcFilePath: %s, startTime: %s, endTime: %s, videoFps: %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
      try
      {
        this.deA = new c();
        this.deA.vT(paramString);
        paramInt = 0;
        for (;;)
        {
          if (paramInt < this.deA.gga.getTrackCount())
          {
            localObject = this.deA.getTrackFormat(paramInt);
            if (((MediaFormat)localObject).getString("mime").toLowerCase().startsWith("video/"))
            {
              this.hmM = paramInt;
              this.iya = ((MediaFormat)localObject);
            }
          }
          else
          {
            paramInt = this.hmM;
            if (paramInt >= 0) {
              break;
            }
            AppMethodBeat.o(89621);
            return -1;
          }
          paramInt += 1;
        }
        this.iuH = paramString;
        this.startTimeMs = paramLong1;
        this.hlm = paramLong2;
        this.deA.selectTrack(this.hmM);
        Object localObject = this.iya.getString("mime");
        this.hlf = z.vI((String)localObject);
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
        ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "found codec: %s", new Object[] { paramString });
        if (paramString != null)
        {
          ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "codec name: %s", new Object[] { paramString.getName() });
          ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[] { localObject, paramString });
          i = 0;
          paramLong1 = bu.HQ();
          localObject = paramString.getCapabilitiesForType((String)localObject);
          ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bu.aO(paramLong1)) });
          ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "color format length: %s", new Object[] { Integer.valueOf(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats.length) });
          paramInt = 0;
          label390:
          if (paramInt < ((MediaCodecInfo.CodecCapabilities)localObject).colorFormats.length)
          {
            m = localObject.colorFormats[paramInt];
            ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(m) });
          }
        }
        switch (m)
        {
        case 20: 
          ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "codec: %s, colorFormat: %s", new Object[] { paramString.getName(), Integer.valueOf(i) });
          ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "found colorFormat: %s", new Object[] { Integer.valueOf(i) });
          this.iya.setInteger("color-format", i);
          this.hlf.a(this.iya, null, 0);
          this.hlf.start();
          AppMethodBeat.o(89621);
          return 0;
        }
      }
      catch (Exception paramString)
      {
        ae.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecDecoder", paramString, "Init decoder failed : %s", new Object[] { paramString.getMessage() });
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
  
  public final void qp(int paramInt)
  {
    AppMethodBeat.i(89627);
    ae.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "setFrameDropInterval: %s", new Object[] { Integer.valueOf(paramInt) });
    this.hlw = paramInt;
    AppMethodBeat.o(89627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.e
 * JD-Core Version:    0.7.0.1
 */