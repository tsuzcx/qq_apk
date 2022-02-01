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
  protected long bxw;
  protected c cUM;
  private int frameCount;
  protected z gnF;
  protected long gnO;
  protected int gnX;
  protected int gqY;
  protected MediaFormat hBj;
  private byte[] hBk;
  protected String hxQ;
  protected int sampleSize;
  protected h tFr;
  private boolean tFu;
  
  public e()
  {
    AppMethodBeat.i(89620);
    this.hxQ = null;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.gqY = -1;
    this.frameCount = 0;
    this.tFu = false;
    AppMethodBeat.o(89620);
  }
  
  private boolean a(c paramc)
  {
    AppMethodBeat.i(89622);
    if (this.gnF == null)
    {
      ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "input decoder is null");
      AppMethodBeat.o(89622);
      return true;
    }
    Object localObject = this.gnF.getInputBuffers();
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
      j = this.gnF.dequeueInputBuffer(60000L);
      if ((j >= 0) || (i >= 15)) {
        break;
      }
      l = bt.GC();
      bool1 = ajw();
      ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "drain cost1 %d", new Object[] { Long.valueOf(bt.aS(l)) });
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
      l = paramc.fGK.getSampleTime();
      ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sampleTime: %s", new Object[] { Long.valueOf(l) });
      if ((this.sampleSize >= 0) && (l < this.gnO * 1000L)) {
        break label345;
      }
    }
    label337:
    label345:
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sawInputEOS: %s", new Object[] { Boolean.valueOf(bool1) });
      paramc = this.gnF;
      int k = this.sampleSize;
      if (bool1)
      {
        i = 4;
        paramc.a(j, k, l, i);
      }
      for (;;)
      {
        l = bt.GC();
        boolean bool2 = ajw();
        ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "drain cost2 %d", new Object[] { Long.valueOf(bt.aS(l)) });
        if (!bool2) {
          break label337;
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
  
  private boolean ajw()
  {
    AppMethodBeat.i(89623);
    if (this.gnF == null)
    {
      ad.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "drainDecoder, decoder is null");
      AppMethodBeat.o(89623);
      return true;
    }
    Object localObject = this.gnF.getOutputBuffers();
    ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoderOutputByteBuffers length: %s", new Object[] { Integer.valueOf(localObject.length) });
    int i = this.gnF.dequeueOutputBuffer(this.bufferInfo, 60000L);
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
      localObject = this.gnF.getOutputBuffers();
      ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder output buffers changed");
    }
    for (;;)
    {
      int j = this.gnF.dequeueOutputBuffer(this.bufferInfo, 60000L);
      i = j;
      if (j >= 0) {
        break;
      }
      break label96;
      if (i == -2)
      {
        this.hBj = this.gnF.getOutputFormat();
        ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder output format changed: " + this.hBj);
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
        if ((l1 < this.bxw * 1000L) && ((this.bufferInfo.flags & 0x4) == 0))
        {
          this.gnF.releaseOutputBuffer(i, false);
          ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder pts: %s, not reach start: %s", new Object[] { Long.valueOf(l1), Long.valueOf(this.bxw * 1000L) });
          AppMethodBeat.o(89623);
          return false;
        }
        if (this.bufferInfo.size != 0)
        {
          localh.position(this.bufferInfo.offset);
          localh.limit(this.bufferInfo.offset + this.bufferInfo.size);
          long l2 = bt.GC();
          localObject = this.bufferInfo;
          if (localh == null) {
            ad.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer error! byteBuffer is null");
          }
          for (;;)
          {
            ad.v("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer %s", new Object[] { Long.valueOf(bt.aS(l2)) });
            this.gnF.releaseOutputBuffer(i, false);
            if ((this.gnO != 1L) && (l1 >= this.gnO * 1000L))
            {
              ad.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "exceed endTimeMs");
              this.tFu = true;
              AppMethodBeat.o(89623);
              return true;
              this.frameCount += 1;
              if ((this.gnX > 1) && (this.frameCount % this.gnX == 0)) {
                continue;
              }
              if (this.hBk == null) {
                this.hBk = new byte[localh.remaining()];
              }
              long l3 = bt.GC();
              try
              {
                this.hBj = this.gnF.getOutputFormat();
                localh.get(this.hBk, 0, localh.remaining());
                ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d cost %d", new Object[] { localh, localObject, Integer.valueOf(((MediaCodec.BufferInfo)localObject).size), Long.valueOf(bt.aS(l3)) });
                if (this.tFr != null) {
                  if ((this.gnO != 1L) && (((MediaCodec.BufferInfo)localObject).presentationTimeUs >= this.gnO * 1000L))
                  {
                    j = 1;
                    localh = this.tFr;
                    byte[] arrayOfByte = this.hBk;
                    if ((this.hBk != null) && (!this.tFu) && (j == 0)) {
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
              this.gnF.stop();
              this.gnF.release();
              this.tFu = true;
              this.gnF = null;
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
        this.gnF.releaseOutputBuffer(i, false);
      }
    }
  }
  
  public final void a(h paramh)
  {
    this.tFr = paramh;
  }
  
  public final Point aDh()
  {
    AppMethodBeat.i(89626);
    Point localPoint = new Point(this.hBj.getInteger("width"), this.hBj.getInteger("height"));
    AppMethodBeat.o(89626);
    return localPoint;
  }
  
  public final int aDi()
  {
    AppMethodBeat.i(89625);
    int i = this.hBj.getInteger("color-format");
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
  
  public final void cQs()
  {
    AppMethodBeat.i(89624);
    this.frameCount = 0;
    this.tFu = false;
    while (!a(this.cUM))
    {
      this.cUM.fGK.advance();
      if (this.cUM.fGK.getSampleTrackIndex() != this.gqY) {
        ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "track index not match, break");
      }
    }
    c localc = this.cUM;
    ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sendDecoderEOS");
    Object localObject = this.gnF.getInputBuffers();
    int i = this.gnF.dequeueInputBuffer(60000L);
    if (i < 0)
    {
      ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "check decoder input buffer index = %d count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      if (ajw()) {}
    }
    else if (i >= 0)
    {
      localObject = localObject[i];
      ((ByteBuffer)localObject).clear();
      this.sampleSize = localc.j((ByteBuffer)localObject);
      ((ByteBuffer)localObject).position(0);
      long l = localc.fGK.getSampleTime();
      if (i < 0) {
        break label256;
      }
      ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "send EOS, decoderInputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
      this.gnF.a(i, 0, l * 1000L, 4);
    }
    for (;;)
    {
      this.tFu = true;
      ajw();
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89619);
          if (e.this.gnF != null)
          {
            ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "delay to stop decoder");
            try
            {
              e.this.gnF.stop();
              e.this.gnF.release();
              e.this.gnF = null;
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
      this.cUM.fGK.release();
      AppMethodBeat.o(89624);
      return;
      label256:
      ad.w("MicroMsg.MMSightRemuxMediaCodecDecoder", "input buffer not available");
    }
  }
  
  public final int d(String paramString, long paramLong1, long paramLong2, int paramInt)
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
        this.cUM = new c();
        this.cUM.px(paramString);
        paramInt = 0;
        for (;;)
        {
          if (paramInt < this.cUM.fGK.getTrackCount())
          {
            localObject = this.cUM.getTrackFormat(paramInt);
            if (((MediaFormat)localObject).getString("mime").toLowerCase().startsWith("video/"))
            {
              this.gqY = paramInt;
              this.hBj = ((MediaFormat)localObject);
            }
          }
          else
          {
            paramInt = this.gqY;
            if (paramInt >= 0) {
              break;
            }
            AppMethodBeat.o(89621);
            return -1;
          }
          paramInt += 1;
        }
        this.hxQ = paramString;
        this.bxw = paramLong1;
        this.gnO = paramLong2;
        this.cUM.selectTrack(this.gqY);
        Object localObject = this.hBj.getString("mime");
        this.gnF = z.pl((String)localObject);
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
          paramLong1 = bt.GC();
          localObject = paramString.getCapabilitiesForType((String)localObject);
          ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(bt.aS(paramLong1)) });
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
          this.hBj.setInteger("color-format", i);
          this.gnF.a(this.hBj, null, 0);
          this.gnF.start();
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
  
  public final void oV(int paramInt)
  {
    AppMethodBeat.i(89627);
    ad.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "setFrameDropInterval: %s", new Object[] { Integer.valueOf(paramInt) });
    this.gnX = paramInt;
    AppMethodBeat.o(89627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.e
 * JD-Core Version:    0.7.0.1
 */