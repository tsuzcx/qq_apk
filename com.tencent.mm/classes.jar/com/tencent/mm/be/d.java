package com.tencent.mm.be;

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

public final class d
  implements a
{
  protected MediaCodec.BufferInfo bufferInfo;
  private int colorFormat;
  protected long endTimeMs;
  private int frameCount;
  protected int nyO;
  protected aa nyz;
  protected String oYr;
  protected c pcp;
  protected a.a pcq;
  protected MediaFormat pcr;
  private byte[] pcs;
  protected int sampleSize;
  protected long startTimeMs;
  protected int videoTrackIndex;
  
  public d(c paramc, MediaFormat paramMediaFormat, int paramInt)
  {
    AppMethodBeat.i(127078);
    this.oYr = null;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.frameCount = 0;
    this.colorFormat = -1;
    Log.i("MicroMsg.MediaCodecTranscodeDecoder", "create MediaCodecTranscodeDecoder: %s, %s, %s", new Object[] { paramc, paramMediaFormat, Integer.valueOf(paramInt) });
    this.pcp = paramc;
    this.pcr = paramMediaFormat;
    this.videoTrackIndex = paramInt;
    AppMethodBeat.o(127078);
  }
  
  private boolean a(c paramc)
  {
    AppMethodBeat.i(127082);
    if (this.nyz == null)
    {
      Log.i("MicroMsg.MediaCodecTranscodeDecoder", "input decoder is null");
      AppMethodBeat.o(127082);
      return true;
    }
    Object localObject = this.nyz.aPD();
    if (localObject == null)
    {
      AppMethodBeat.o(127082);
      return false;
    }
    Log.i("MicroMsg.MediaCodecTranscodeDecoder", "decoderInputByteBuffers size: %d", new Object[] { Integer.valueOf(localObject.length) });
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
      Log.i("MicroMsg.MediaCodecTranscodeDecoder", "drain cost1 %d", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
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
      l = paramc.lZm.getSampleTime();
      Log.i("MicroMsg.MediaCodecTranscodeDecoder", "sampleTime: %s", new Object[] { Long.valueOf(l) });
      if ((this.sampleSize >= 0) && (l < this.endTimeMs * 1000L)) {
        break label346;
      }
    }
    label338:
    label346:
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.MediaCodecTranscodeDecoder", "sawInputEOS: %s", new Object[] { Boolean.valueOf(bool1) });
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
        Log.i("MicroMsg.MediaCodecTranscodeDecoder", "drain cost2 %d", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        if (!bool2) {
          break label338;
        }
        AppMethodBeat.o(127082);
        return true;
        i = 0;
        break;
        Log.w("MicroMsg.MediaCodecTranscodeDecoder", "input buffer not available");
        bool1 = false;
      }
      AppMethodBeat.o(127082);
      return bool1;
    }
  }
  
  private boolean boW()
  {
    AppMethodBeat.i(127083);
    if (this.nyz == null)
    {
      Log.e("MicroMsg.MediaCodecTranscodeDecoder", "drainDecoder, decoder is null");
      AppMethodBeat.o(127083);
      return true;
    }
    Object localObject = this.nyz.aPE();
    Log.i("MicroMsg.MediaCodecTranscodeDecoder", "decoderOutputByteBuffers length: %s", new Object[] { Integer.valueOf(localObject.length) });
    int i = this.nyz.dequeueOutputBuffer(this.bufferInfo, 60000L);
    Log.i("MicroMsg.MediaCodecTranscodeDecoder", "outputBufferIndex-->".concat(String.valueOf(i)));
    if (i == -1)
    {
      Log.i("MicroMsg.MediaCodecTranscodeDecoder", "no output from decoder available, break");
      label96:
      AppMethodBeat.o(127083);
      return false;
    }
    if (i == -3)
    {
      localObject = this.nyz.aPE();
      Log.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output buffers changed");
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
        Log.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output format changed: " + this.pcr);
      }
      else if (i < 0)
      {
        Log.w("MicroMsg.MediaCodecTranscodeDecoder", "unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(i)));
      }
      else
      {
        Log.v("MicroMsg.MediaCodecTranscodeDecoder", "perform decoding");
        a.a locala = localObject[i];
        if (locala == null) {
          break label96;
        }
        long l1 = this.bufferInfo.presentationTimeUs;
        if ((l1 < this.startTimeMs * 1000L) && ((this.bufferInfo.flags & 0x4) == 0))
        {
          this.nyz.releaseOutputBuffer(i, false);
          Log.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder pts: %s, not reach start: %s", new Object[] { Long.valueOf(l1), Long.valueOf(this.startTimeMs * 1000L) });
          AppMethodBeat.o(127083);
          return false;
        }
        if (this.bufferInfo.size != 0)
        {
          locala.position(this.bufferInfo.offset);
          locala.limit(this.bufferInfo.offset + this.bufferInfo.size);
          long l2 = Util.currentTicks();
          localObject = this.bufferInfo;
          if (locala == null) {
            Log.e("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer error! byteBuffer is null");
          }
          for (;;)
          {
            Log.v("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer %s", new Object[] { Long.valueOf(Util.ticksToNow(l2)) });
            this.nyz.releaseOutputBuffer(i, false);
            if ((this.endTimeMs != 1L) && (l1 >= this.endTimeMs * 1000L))
            {
              Log.e("MicroMsg.MediaCodecTranscodeDecoder", "exceed endTimeMs");
              AppMethodBeat.o(127083);
              return true;
              this.frameCount += 1;
              if ((this.nyO > 1) && (this.frameCount % this.nyO == 0)) {
                continue;
              }
              if (this.pcs == null) {
                this.pcs = new byte[locala.remaining()];
              }
              long l3 = Util.currentTicks();
              try
              {
                this.pcr = this.nyz.getOutputFormat();
                locala.get(this.pcs, 0, locala.remaining());
                Log.i("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d cost %d", new Object[] { locala, localObject, Integer.valueOf(((MediaCodec.BufferInfo)localObject).size), Long.valueOf(Util.ticksToNow(l3)) });
                if (this.pcq != null)
                {
                  locala = this.pcq;
                  byte[] arrayOfByte = this.pcs;
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
                  Log.e("MicroMsg.MediaCodecTranscodeDecoder", "get output format error");
                  continue;
                  boolean bool = false;
                }
              }
            }
          }
          if ((this.bufferInfo.flags & 0x4) != 0)
          {
            Log.i("MicroMsg.MediaCodecTranscodeDecoder", "receive end of stream");
            try
            {
              this.nyz.stop();
              this.nyz.release();
              this.nyz = null;
              AppMethodBeat.o(127083);
              return true;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                Log.e("MicroMsg.MediaCodecTranscodeDecoder", "stop and release decoder error: %s", new Object[] { localException1.getMessage() });
              }
            }
          }
          AppMethodBeat.o(127083);
          return false;
        }
        this.nyz.releaseOutputBuffer(i, false);
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
  
  private static int selectColorFormat(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    AppMethodBeat.i(127081);
    Log.i("MicroMsg.MediaCodecTranscodeDecoder", "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[] { paramString, paramMediaCodecInfo });
    long l = Util.currentTicks();
    paramString = paramMediaCodecInfo.getCapabilitiesForType(paramString);
    Log.i("MicroMsg.MediaCodecTranscodeDecoder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    Log.i("MicroMsg.MediaCodecTranscodeDecoder", "color format length: %s", new Object[] { Integer.valueOf(paramString.colorFormats.length) });
    int i = 0;
    int j = 0;
    if (i < paramString.colorFormats.length)
    {
      int n = paramString.colorFormats[i];
      Log.i("MicroMsg.MediaCodecTranscodeDecoder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(n) });
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
    Log.i("MicroMsg.MediaCodecTranscodeDecoder", "codec: %s, colorFormat: %s", new Object[] { paramMediaCodecInfo.getName(), Integer.valueOf(j) });
    AppMethodBeat.o(127081);
    return j;
  }
  
  public final void O(Runnable paramRunnable)
  {
    AppMethodBeat.i(127084);
    this.frameCount = 0;
    while (!a(this.pcp))
    {
      this.pcp.lZm.advance();
      if (this.pcp.lZm.getSampleTrackIndex() != this.videoTrackIndex) {
        Log.i("MicroMsg.MediaCodecTranscodeDecoder", "track index not match, break");
      }
    }
    c localc = this.pcp;
    Log.i("MicroMsg.MediaCodecTranscodeDecoder", "sendDecoderEOS");
    Object localObject = this.nyz.aPD();
    int i = this.nyz.dequeueInputBuffer(60000L);
    if (i < 0)
    {
      Log.i("MicroMsg.MediaCodecTranscodeDecoder", "check decoder input buffer index = %d count = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
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
        break label243;
      }
      Log.i("MicroMsg.MediaCodecTranscodeDecoder", "send EOS, decoderInputBufferIndex: %s", new Object[] { Integer.valueOf(i) });
      this.nyz.a(i, 0, l * 1000L, 4);
    }
    for (;;)
    {
      boW();
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(127077);
          if (d.this.nyz != null)
          {
            Log.i("MicroMsg.MediaCodecTranscodeDecoder", "delay to stop decoder");
            try
            {
              d.this.nyz.stop();
              d.this.nyz.release();
              d.this.nyz = null;
              AppMethodBeat.o(127077);
              return;
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", localException, "delay to stop decoder error: %s", new Object[] { localException.getMessage() });
            }
          }
          AppMethodBeat.o(127077);
        }
      }, 500L);
      paramRunnable.run();
      AppMethodBeat.o(127084);
      return;
      label243:
      Log.w("MicroMsg.MediaCodecTranscodeDecoder", "input buffer not available");
    }
  }
  
  public final void a(a.a parama)
  {
    this.pcq = parama;
  }
  
  public final Point bOM()
  {
    AppMethodBeat.i(127086);
    Point localPoint = new Point(this.pcr.getInteger("width"), this.pcr.getInteger("height"));
    AppMethodBeat.o(127086);
    return localPoint;
  }
  
  public final int bON()
  {
    AppMethodBeat.i(127085);
    Log.i("MicroMsg.MediaCodecTranscodeDecoder", "src color format: %s", new Object[] { Integer.valueOf(this.colorFormat) });
    switch (this.colorFormat)
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
  
  public final int o(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(127079);
    this.oYr = paramString;
    this.startTimeMs = paramLong1;
    this.endTimeMs = paramLong2;
    Log.i("MicroMsg.MediaCodecTranscodeDecoder", "initDecoder() called with: format = [" + this.pcr + "]");
    try
    {
      paramString = this.pcr.getString("mime");
      this.nyz = aa.Dw(paramString);
      MediaCodecInfo localMediaCodecInfo = selectCodec(paramString);
      Log.i("MicroMsg.MediaCodecTranscodeDecoder", "found codec: %s", new Object[] { localMediaCodecInfo });
      if (localMediaCodecInfo != null)
      {
        Log.i("MicroMsg.MediaCodecTranscodeDecoder", "codec name: %s", new Object[] { localMediaCodecInfo.getName() });
        this.colorFormat = selectColorFormat(localMediaCodecInfo, paramString);
        Log.i("MicroMsg.MediaCodecTranscodeDecoder", "found colorFormat: %s", new Object[] { Integer.valueOf(this.colorFormat) });
        this.pcr.setInteger("color-format", this.colorFormat);
      }
      this.nyz.a(this.pcr, null, 0);
      this.nyz.start();
      AppMethodBeat.o(127079);
      return 0;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", paramString, "Init decoder failed : %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(127079);
    }
    return -1;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(127087);
    if (this.nyz != null) {
      try
      {
        Log.i("MicroMsg.MediaCodecTranscodeDecoder", "stop decoder");
        this.nyz.stop();
        this.nyz.release();
        this.nyz = null;
        AppMethodBeat.o(127087);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", localException, "stop decoder error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(127087);
  }
  
  public final void xe(int paramInt)
  {
    AppMethodBeat.i(127088);
    Log.i("MicroMsg.MediaCodecTranscodeDecoder", "setFrameDropInterval: %s", new Object[] { Integer.valueOf(paramInt) });
    this.nyO = paramInt;
    AppMethodBeat.o(127088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.be.d
 * JD-Core Version:    0.7.0.1
 */