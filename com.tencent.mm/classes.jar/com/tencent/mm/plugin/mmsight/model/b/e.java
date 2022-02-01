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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.nio.ByteBuffer;

public final class e
  implements a
{
  protected MediaCodec.BufferInfo bufferInfo;
  protected c ddy;
  private int frameCount;
  protected int hiI;
  protected z hir;
  protected long hiy;
  protected int hjY;
  protected String irN;
  protected MediaFormat ivg;
  private byte[] ivh;
  protected int sampleSize;
  protected long startTimeMs;
  protected h vQV;
  private boolean vQY;
  
  public e()
  {
    AppMethodBeat.i(89620);
    this.irN = null;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.hjY = -1;
    this.frameCount = 0;
    this.vQY = false;
    AppMethodBeat.o(89620);
  }
  
  private boolean a(c paramc)
  {
    AppMethodBeat.i(89622);
    if (this.hir == null)
    {
      ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "input decoder is null");
      AppMethodBeat.o(89622);
      return true;
    }
    Object localObject = this.hir.getInputBuffers();
    if (localObject == null)
    {
      AppMethodBeat.o(89622);
      return false;
    }
    ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoderInputByteBuffers size: %d", new Object[] { Integer.valueOf(localObject.length) });
    int i = 0;
    int j;
    long l;
    for (;;)
    {
      j = this.hir.dequeueInputBuffer(60000L);
      if ((j >= 0) || (i >= 15)) {
        break;
      }
      l = bt.HI();
      bool1 = atq();
      ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "drain cost1 %d", new Object[] { Long.valueOf(bt.aO(l)) });
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
      l = paramc.gdS.getSampleTime();
      ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sampleTime: %s", new Object[] { Long.valueOf(l) });
      if ((this.sampleSize >= 0) && (l < this.hiy * 1000L)) {
        break label346;
      }
    }
    label338:
    label346:
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sawInputEOS: %s", new Object[] { Boolean.valueOf(bool1) });
      paramc = this.hir;
      int k = this.sampleSize;
      if (bool1)
      {
        i = 4;
        paramc.a(j, k, l, i);
      }
      for (;;)
      {
        l = bt.HI();
        boolean bool2 = atq();
        ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "drain cost2 %d", new Object[] { Long.valueOf(bt.aO(l)) });
        if (!bool2) {
          break label338;
        }
        AppMethodBeat.o(89622);
        return true;
        i = 0;
        break;
        ad.w("MicroMsg.MMSightRemuxMediaCodecDecoder", "input buffer not available");
        bool1 = false;
      }
      AppMethodBeat.o(89622);
      return bool1;
    }
  }
  
  private boolean atq()
  {
    AppMethodBeat.i(89623);
    if (this.hir == null)
    {
      ad.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "drainDecoder, decoder is null");
      AppMethodBeat.o(89623);
      return true;
    }
    Object localObject = this.hir.getOutputBuffers();
    ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoderOutputByteBuffers length: %s", new Object[] { Integer.valueOf(localObject.length) });
    int i = this.hir.dequeueOutputBuffer(this.bufferInfo, 60000L);
    ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "outputBufferIndex-->".concat(String.valueOf(i)));
    if (i == -1)
    {
      ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "no output from decoder available, break");
      label96:
      AppMethodBeat.o(89623);
      return false;
    }
    if (i == -3)
    {
      localObject = this.hir.getOutputBuffers();
      ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder output buffers changed");
    }
    for (;;)
    {
      int j = this.hir.dequeueOutputBuffer(this.bufferInfo, 60000L);
      i = j;
      if (j >= 0) {
        break;
      }
      break label96;
      if (i == -2)
      {
        this.ivg = this.hir.getOutputFormat();
        ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder output format changed: " + this.ivg);
      }
      else if (i < 0)
      {
        ad.w("MicroMsg.MMSightRemuxMediaCodecDecoder", "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(i)));
      }
      else
      {
        ad.v("MicroMsg.MMSightRemuxMediaCodecDecoder", "perform decoding");
        h localh = localObject[i];
        if (localh == null) {
          break label96;
        }
        long l1 = this.bufferInfo.presentationTimeUs;
        if ((l1 < this.startTimeMs * 1000L) && ((this.bufferInfo.flags & 0x4) == 0))
        {
          this.hir.releaseOutputBuffer(i, false);
          ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder pts: %s, not reach start: %s", new Object[] { Long.valueOf(l1), Long.valueOf(this.startTimeMs * 1000L) });
          AppMethodBeat.o(89623);
          return false;
        }
        if (this.bufferInfo.size != 0)
        {
          localh.position(this.bufferInfo.offset);
          localh.limit(this.bufferInfo.offset + this.bufferInfo.size);
          long l2 = bt.HI();
          localObject = this.bufferInfo;
          if (localh == null) {
            ad.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer error! byteBuffer is null");
          }
          for (;;)
          {
            ad.v("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer %s", new Object[] { Long.valueOf(bt.aO(l2)) });
            this.hir.releaseOutputBuffer(i, false);
            if ((this.hiy != 1L) && (l1 >= this.hiy * 1000L))
            {
              ad.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "exceed endTimeMs");
              this.vQY = true;
              AppMethodBeat.o(89623);
              return true;
              this.frameCount += 1;
              if ((this.hiI > 1) && (this.frameCount % this.hiI == 0)) {
                continue;
              }
              if (this.ivh == null) {
                this.ivh = new byte[localh.remaining()];
              }
              long l3 = bt.HI();
              try
              {
                this.ivg = this.hir.getOutputFormat();
                localh.get(this.ivh, 0, localh.remaining());
                ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d cost %d", new Object[] { localh, localObject, Integer.valueOf(((MediaCodec.BufferInfo)localObject).size), Long.valueOf(bt.aO(l3)) });
                if (this.vQV != null) {
                  if ((this.hiy != 1L) && (((MediaCodec.BufferInfo)localObject).presentationTimeUs >= this.hiy * 1000L))
                  {
                    j = 1;
                    localh = this.vQV;
                    byte[] arrayOfByte = this.ivh;
                    if ((this.ivh != null) && (!this.vQY) && (j == 0)) {
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
                  ad.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "get output format error");
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
            ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "receive end of stream");
            try
            {
              this.hir.stop();
              this.hir.release();
              this.vQY = true;
              this.hir = null;
              AppMethodBeat.o(89623);
              return true;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                ad.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "stop and release decoder error: %s", new Object[] { localException1.getMessage() });
              }
            }
          }
          AppMethodBeat.o(89623);
          return false;
        }
        this.hir.releaseOutputBuffer(i, false);
      }
    }
  }
  
  public final void a(h paramh)
  {
    this.vQV = paramh;
  }
  
  public final Point aNh()
  {
    AppMethodBeat.i(89626);
    Point localPoint = new Point(this.ivg.getInteger("width"), this.ivg.getInteger("height"));
    AppMethodBeat.o(89626);
    return localPoint;
  }
  
  public final int aNi()
  {
    AppMethodBeat.i(89625);
    int i = this.ivg.getInteger("color-format");
    ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "src color format: %s", new Object[] { Integer.valueOf(i) });
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
  
  public final void dny()
  {
    AppMethodBeat.i(89624);
    this.frameCount = 0;
    this.vQY = false;
    while (!a(this.ddy))
    {
      this.ddy.gdS.advance();
      if (this.ddy.gdS.getSampleTrackIndex() != this.hjY) {
        ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "track index not match, break");
      }
    }
    c localc = this.ddy;
    ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sendDecoderEOS");
    Object localObject = this.hir.getInputBuffers();
    int i = this.hir.dequeueInputBuffer(60000L);
    if (i < 0)
    {
      ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "check decoder input buffer index = %d count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      if (atq()) {}
    }
    else if (i >= 0)
    {
      localObject = localObject[i];
      ((ByteBuffer)localObject).clear();
      this.sampleSize = localc.readSampleData((ByteBuffer)localObject, 0);
      ((ByteBuffer)localObject).position(0);
      long l = localc.gdS.getSampleTime();
      if (i < 0) {
        break label257;
      }
      ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "send EOS, decoderInputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
      this.hir.a(i, 0, l * 1000L, 4);
    }
    for (;;)
    {
      this.vQY = true;
      atq();
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89619);
          if (e.this.hir != null)
          {
            ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "delay to stop decoder");
            try
            {
              e.this.hir.stop();
              e.this.hir.release();
              e.this.hir = null;
              AppMethodBeat.o(89619);
              return;
            }
            catch (Exception localException)
            {
              ad.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecDecoder", localException, "delay to stop decoder error: %s", new Object[] { localException.getMessage() });
            }
          }
          AppMethodBeat.o(89619);
        }
      }, 500L);
      this.ddy.gdS.release();
      AppMethodBeat.o(89624);
      return;
      label257:
      ad.w("MicroMsg.MMSightRemuxMediaCodecDecoder", "input buffer not available");
    }
  }
  
  public final int e(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(89621);
    int j;
    int i;
    label245:
    int m;
    if (!bt.isNullOrNil(paramString))
    {
      ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "initDecoder, srcFilePath: %s, startTime: %s, endTime: %s, videoFps: %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
      try
      {
        this.ddy = new c();
        this.ddy.vx(paramString);
        paramInt = 0;
        for (;;)
        {
          if (paramInt < this.ddy.gdS.getTrackCount())
          {
            localObject = this.ddy.getTrackFormat(paramInt);
            if (((MediaFormat)localObject).getString("mime").toLowerCase().startsWith("video/"))
            {
              this.hjY = paramInt;
              this.ivg = ((MediaFormat)localObject);
            }
          }
          else
          {
            paramInt = this.hjY;
            if (paramInt >= 0) {
              break;
            }
            AppMethodBeat.o(89621);
            return -1;
          }
          paramInt += 1;
        }
        this.irN = paramString;
        this.startTimeMs = paramLong1;
        this.hiy = paramLong2;
        this.ddy.selectTrack(this.hjY);
        Object localObject = this.ivg.getString("mime");
        this.hir = z.vm((String)localObject);
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
        ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "found codec: %s", new Object[] { paramString });
        if (paramString != null)
        {
          ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "codec name: %s", new Object[] { paramString.getName() });
          ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[] { localObject, paramString });
          i = 0;
          paramLong1 = bt.HI();
          localObject = paramString.getCapabilitiesForType((String)localObject);
          ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bt.aO(paramLong1)) });
          ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "color format length: %s", new Object[] { Integer.valueOf(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats.length) });
          paramInt = 0;
          label390:
          if (paramInt < ((MediaCodecInfo.CodecCapabilities)localObject).colorFormats.length)
          {
            m = localObject.colorFormats[paramInt];
            ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(m) });
          }
        }
        switch (m)
        {
        case 20: 
          ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "codec: %s, colorFormat: %s", new Object[] { paramString.getName(), Integer.valueOf(i) });
          ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "found colorFormat: %s", new Object[] { Integer.valueOf(i) });
          this.ivg.setInteger("color-format", i);
          this.hir.a(this.ivg, null, 0);
          this.hir.start();
          AppMethodBeat.o(89621);
          return 0;
        }
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecDecoder", paramString, "Init decoder failed : %s", new Object[] { paramString.getMessage() });
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
  
  public final void qm(int paramInt)
  {
    AppMethodBeat.i(89627);
    ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "setFrameDropInterval: %s", new Object[] { Integer.valueOf(paramInt) });
    this.hiI = paramInt;
    AppMethodBeat.o(89627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.e
 * JD-Core Version:    0.7.0.1
 */