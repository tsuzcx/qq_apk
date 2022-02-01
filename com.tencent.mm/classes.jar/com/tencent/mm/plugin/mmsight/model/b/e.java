package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Point;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.compatible.i.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;

public final class e
  implements a
{
  protected h KYd;
  private boolean KYg;
  protected MediaCodec.BufferInfo bufferInfo;
  protected long endTimeMs;
  private int frameCount;
  protected int nyO;
  protected aa nyz;
  protected String oYr;
  protected c pcp;
  protected MediaFormat pcr;
  private byte[] pcs;
  protected int sampleSize;
  protected long startTimeMs;
  protected int videoTrackIndex;
  
  public e()
  {
    AppMethodBeat.i(89620);
    this.oYr = null;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.videoTrackIndex = -1;
    this.frameCount = 0;
    this.KYg = false;
    AppMethodBeat.o(89620);
  }
  
  private boolean a(c paramc)
  {
    AppMethodBeat.i(89622);
    if (this.nyz == null)
    {
      Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "input decoder is null");
      AppMethodBeat.o(89622);
      return true;
    }
    Object localObject = this.nyz.aPD();
    if (localObject == null)
    {
      AppMethodBeat.o(89622);
      return false;
    }
    Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoderInputByteBuffers size: %d", new Object[] { Integer.valueOf(localObject.length) });
    int i = 0;
    int j;
    long l;
    for (;;)
    {
      j = this.nyz.dequeueInputBuffer(60000L);
      if ((j >= 0) || (i >= 15)) {
        break;
      }
      l = Util.currentTicks();
      bool1 = boW();
      Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "drain cost1 %d", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
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
      l = paramc.lZm.getSampleTime();
      Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sampleTime: %s", new Object[] { Long.valueOf(l) });
      if ((this.sampleSize >= 0) && (l < this.endTimeMs * 1000L)) {
        break label346;
      }
    }
    label338:
    label346:
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sawInputEOS: %s", new Object[] { Boolean.valueOf(bool1) });
      paramc = this.nyz;
      int k = this.sampleSize;
      if (bool1)
      {
        i = 4;
        paramc.a(j, k, l, i);
      }
      for (;;)
      {
        l = Util.currentTicks();
        boolean bool2 = boW();
        Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "drain cost2 %d", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        if (!bool2) {
          break label338;
        }
        AppMethodBeat.o(89622);
        return true;
        i = 0;
        break;
        Log.w("MicroMsg.MMSightRemuxMediaCodecDecoder", "input buffer not available");
        bool1 = false;
      }
      AppMethodBeat.o(89622);
      return bool1;
    }
  }
  
  private boolean boW()
  {
    AppMethodBeat.i(89623);
    if (this.nyz == null)
    {
      Log.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "drainDecoder, decoder is null");
      AppMethodBeat.o(89623);
      return true;
    }
    Object localObject = this.nyz.aPE();
    Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoderOutputByteBuffers length: %s", new Object[] { Integer.valueOf(localObject.length) });
    int i = this.nyz.dequeueOutputBuffer(this.bufferInfo, 60000L);
    Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "outputBufferIndex-->".concat(String.valueOf(i)));
    if (i == -1)
    {
      Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "no output from decoder available, break");
      label96:
      AppMethodBeat.o(89623);
      return false;
    }
    if (i == -3)
    {
      localObject = this.nyz.aPE();
      Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder output buffers changed");
    }
    for (;;)
    {
      int j = this.nyz.dequeueOutputBuffer(this.bufferInfo, 60000L);
      i = j;
      if (j >= 0) {
        break;
      }
      break label96;
      if (i == -2)
      {
        this.pcr = this.nyz.getOutputFormat();
        Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder output format changed: " + this.pcr);
      }
      else if (i < 0)
      {
        Log.w("MicroMsg.MMSightRemuxMediaCodecDecoder", "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(i)));
      }
      else
      {
        Log.v("MicroMsg.MMSightRemuxMediaCodecDecoder", "perform decoding");
        h localh = localObject[i];
        if (localh == null) {
          break label96;
        }
        long l1 = this.bufferInfo.presentationTimeUs;
        if ((l1 < this.startTimeMs * 1000L) && ((this.bufferInfo.flags & 0x4) == 0))
        {
          this.nyz.releaseOutputBuffer(i, false);
          Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "decoder pts: %s, not reach start: %s", new Object[] { Long.valueOf(l1), Long.valueOf(this.startTimeMs * 1000L) });
          AppMethodBeat.o(89623);
          return false;
        }
        if (this.bufferInfo.size != 0)
        {
          localh.position(this.bufferInfo.offset);
          localh.limit(this.bufferInfo.offset + this.bufferInfo.size);
          long l2 = Util.currentTicks();
          localObject = this.bufferInfo;
          if (localh == null) {
            Log.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer error! byteBuffer is null");
          }
          for (;;)
          {
            Log.v("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer %s", new Object[] { Long.valueOf(Util.ticksToNow(l2)) });
            this.nyz.releaseOutputBuffer(i, false);
            if ((this.endTimeMs != 1L) && (l1 >= this.endTimeMs * 1000L))
            {
              Log.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "exceed endTimeMs");
              this.KYg = true;
              AppMethodBeat.o(89623);
              return true;
              this.frameCount += 1;
              if ((this.nyO > 1) && (this.frameCount % this.nyO == 0)) {
                continue;
              }
              if (this.pcs == null) {
                this.pcs = new byte[localh.remaining()];
              }
              long l3 = Util.currentTicks();
              try
              {
                this.pcr = this.nyz.getOutputFormat();
                localh.get(this.pcs, 0, localh.remaining());
                Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d cost %d", new Object[] { localh, localObject, Integer.valueOf(((MediaCodec.BufferInfo)localObject).size), Long.valueOf(Util.ticksToNow(l3)) });
                if (this.KYd != null) {
                  if ((this.endTimeMs != 1L) && (((MediaCodec.BufferInfo)localObject).presentationTimeUs >= this.endTimeMs * 1000L))
                  {
                    j = 1;
                    localh = this.KYd;
                    byte[] arrayOfByte = this.pcs;
                    if ((this.pcs != null) && (!this.KYg) && (j == 0)) {
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
                  Log.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "get output format error");
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
            Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "receive end of stream");
            try
            {
              this.nyz.stop();
              this.nyz.release();
              this.KYg = true;
              this.nyz = null;
              AppMethodBeat.o(89623);
              return true;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                Log.e("MicroMsg.MMSightRemuxMediaCodecDecoder", "stop and release decoder error: %s", new Object[] { localException1.getMessage() });
              }
            }
          }
          AppMethodBeat.o(89623);
          return false;
        }
        this.nyz.releaseOutputBuffer(i, false);
      }
    }
  }
  
  public final void a(h paramh)
  {
    this.KYd = paramh;
  }
  
  public final Point bOM()
  {
    AppMethodBeat.i(89626);
    Point localPoint = new Point(this.pcr.getInteger("width"), this.pcr.getInteger("height"));
    AppMethodBeat.o(89626);
    return localPoint;
  }
  
  public final int bON()
  {
    AppMethodBeat.i(89625);
    int i = this.pcr.getInteger("color-format");
    Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "src color format: %s", new Object[] { Integer.valueOf(i) });
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
  
  public final int e(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(89621);
    int j;
    int i;
    label245:
    int m;
    if (!Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "initDecoder, srcFilePath: %s, startTime: %s, endTime: %s, videoFps: %s", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt) });
      try
      {
        this.pcp = new c();
        this.pcp.setDataSource(paramString);
        paramInt = 0;
        for (;;)
        {
          if (paramInt < this.pcp.lZm.getTrackCount())
          {
            localObject = this.pcp.getTrackFormat(paramInt);
            if (((MediaFormat)localObject).getString("mime").toLowerCase().startsWith("video/"))
            {
              this.videoTrackIndex = paramInt;
              this.pcr = ((MediaFormat)localObject);
            }
          }
          else
          {
            paramInt = this.videoTrackIndex;
            if (paramInt >= 0) {
              break;
            }
            AppMethodBeat.o(89621);
            return -1;
          }
          paramInt += 1;
        }
        this.oYr = paramString;
        this.startTimeMs = paramLong1;
        this.endTimeMs = paramLong2;
        this.pcp.selectTrack(this.videoTrackIndex);
        Object localObject = this.pcr.getString("mime");
        this.nyz = aa.Dw((String)localObject);
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
        Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "found codec: %s", new Object[] { paramString });
        if (paramString != null)
        {
          Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "codec name: %s", new Object[] { paramString.getName() });
          Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[] { localObject, paramString });
          i = 0;
          paramLong1 = Util.currentTicks();
          localObject = paramString.getCapabilitiesForType((String)localObject);
          Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(Util.ticksToNow(paramLong1)) });
          Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "color format length: %s", new Object[] { Integer.valueOf(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats.length) });
          paramInt = 0;
          label390:
          if (paramInt < ((MediaCodecInfo.CodecCapabilities)localObject).colorFormats.length)
          {
            m = localObject.colorFormats[paramInt];
            Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(m) });
          }
        }
        switch (m)
        {
        case 20: 
          Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "codec: %s, colorFormat: %s", new Object[] { paramString.getName(), Integer.valueOf(i) });
          Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "found colorFormat: %s", new Object[] { Integer.valueOf(i) });
          this.pcr.setInteger("color-format", i);
          this.nyz.a(this.pcr, null, 0);
          this.nyz.start();
          AppMethodBeat.o(89621);
          return 0;
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecDecoder", paramString, "Init decoder failed : %s", new Object[] { paramString.getMessage() });
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
  
  public final void gcH()
  {
    AppMethodBeat.i(89624);
    this.frameCount = 0;
    this.KYg = false;
    while (!a(this.pcp))
    {
      this.pcp.lZm.advance();
      if (this.pcp.lZm.getSampleTrackIndex() != this.videoTrackIndex) {
        Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "track index not match, break");
      }
    }
    c localc = this.pcp;
    Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "sendDecoderEOS");
    Object localObject = this.nyz.aPD();
    int i = this.nyz.dequeueInputBuffer(60000L);
    if (i < 0)
    {
      Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "check decoder input buffer index = %d count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      if (boW()) {}
    }
    else if (i >= 0)
    {
      localObject = localObject[i];
      ((ByteBuffer)localObject).clear();
      this.sampleSize = localc.readSampleData((ByteBuffer)localObject, 0);
      ((ByteBuffer)localObject).position(0);
      long l = localc.lZm.getSampleTime();
      if (i < 0) {
        break label257;
      }
      Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "send EOS, decoderInputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
      this.nyz.a(i, 0, l * 1000L, 4);
    }
    for (;;)
    {
      this.KYg = true;
      boW();
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(89619);
          if (e.this.nyz != null)
          {
            Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "delay to stop decoder");
            try
            {
              e.this.nyz.stop();
              e.this.nyz.release();
              e.this.nyz = null;
              AppMethodBeat.o(89619);
              return;
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecDecoder", localException, "delay to stop decoder error: %s", new Object[] { localException.getMessage() });
            }
          }
          AppMethodBeat.o(89619);
        }
      }, 500L);
      this.pcp.lZm.release();
      AppMethodBeat.o(89624);
      return;
      label257:
      Log.w("MicroMsg.MMSightRemuxMediaCodecDecoder", "input buffer not available");
    }
  }
  
  public final void xe(int paramInt)
  {
    AppMethodBeat.i(89627);
    Log.i("MicroMsg.MMSightRemuxMediaCodecDecoder", "setFrameDropInterval: %s", new Object[] { Integer.valueOf(paramInt) });
    this.nyO = paramInt;
    AppMethodBeat.o(89627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.b.e
 * JD-Core Version:    0.7.0.1
 */