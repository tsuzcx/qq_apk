package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import java.nio.ByteBuffer;

@TargetApi(16)
public class r
  implements f
{
  private long FbB;
  int FbV;
  int FbW;
  int FbX;
  int FbY;
  a FbZ;
  private o Fbm;
  private boolean Fbo;
  private boolean Fbq;
  f.a Fca;
  private a.a Fcb;
  private ByteBuffer[] aPq;
  private ByteBuffer[] bcY;
  private int bitrate;
  private MediaCodec.BufferInfo bufferInfo;
  int colorFormat;
  boolean frA;
  int frameCount;
  private int frameRate;
  private boolean isStart;
  private long jWQ;
  private int kSh;
  protected aa kTH;
  private final Object kTT;
  boolean lhV;
  protected MediaFormat mediaFormat;
  private int miN;
  private int miO;
  private boolean miP;
  private int nqW;
  private int nqX;
  private long startTime;
  int targetHeight;
  int targetWidth;
  
  public r(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    AppMethodBeat.i(89588);
    this.startTime = 0L;
    this.jWQ = 0L;
    this.miN = -1;
    this.miO = -1;
    this.bitrate = 0;
    this.isStart = false;
    this.frA = false;
    this.miP = false;
    this.FbV = -1;
    this.FbW = -1;
    this.FbX = -1;
    this.FbY = -1;
    this.lhV = false;
    this.kTT = new Object();
    this.Fbo = false;
    this.Fbq = true;
    this.FbB = 0L;
    this.Fcb = new a.a()
    {
      public final void bX(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(89586);
        long l = Util.currentTicks();
        boolean bool2 = r.this.FbZ.eTC();
        r localr = r.this;
        if ((bool2) && (r.this.frA)) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          localr.d(paramAnonymousArrayOfByte, bool1);
          com.tencent.mm.bm.b.miJ.as(paramAnonymousArrayOfByte);
          Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "markStop: %s isEnd %s costTime %d", new Object[] { Boolean.valueOf(r.this.frA), Boolean.valueOf(bool2), Long.valueOf(Util.ticksToNow(l)) });
          if ((bool2) && (r.this.frA)) {
            r.this.eTN();
          }
          AppMethodBeat.o(89586);
          return;
        }
      }
    };
    this.FbZ = new a(this.Fcb);
    this.nqW = paramInt1;
    this.nqX = paramInt2;
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, init targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, after align 16, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.targetWidth = paramInt3;
    this.targetHeight = paramInt4;
    this.frameRate = paramInt7;
    this.kSh = paramInt6;
    this.Fbm = null;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.bitrate = paramInt5;
    this.lhV = paramBoolean;
    this.Fbq = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFH, true);
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create BigSightMediaCodecYUVRecorder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s, needRotateEachFrame: %s, muxer: %s", new Object[] { Integer.valueOf(this.nqW), Integer.valueOf(this.nqX), Integer.valueOf(this.targetWidth), Integer.valueOf(this.targetHeight), Integer.valueOf(paramInt5), Boolean.valueOf(paramBoolean), null });
    AppMethodBeat.o(89588);
  }
  
  private void aUD()
  {
    AppMethodBeat.i(89593);
    this.miO = this.kTH.a(this.bufferInfo, 100L);
    Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "outputBufferIndex-->" + this.miO);
    do
    {
      if (this.miO != -1) {
        break label149;
      }
      Log.d("MicroMsg.MMSightYUVMediaCodecRecorder", "no output from encoder available, break encoderEndStream %s", new Object[] { Boolean.valueOf(this.miP) });
      if (!this.miP) {
        break;
      }
      this.miO = this.kTH.a(this.bufferInfo, 100L);
      if (this.miO <= 0) {
        Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "get outputBufferIndex %d", new Object[] { Integer.valueOf(this.miO) });
      }
    } while ((this.miO >= 0) || (this.miP));
    label149:
    do
    {
      AppMethodBeat.o(89593);
      return;
      if (this.miO == -3)
      {
        this.aPq = this.kTH.avk();
        Log.d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output buffers changed");
        break;
      }
      if (this.miO == -2)
      {
        Log.d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output format changed: ".concat(String.valueOf(this.kTH.avi())));
        if (this.Fbm == null) {
          break;
        }
        AppMethodBeat.o(89593);
        throw null;
      }
      if (this.miO < 0)
      {
        Log.w("MicroMsg.MMSightYUVMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + this.miO);
        break;
      }
      Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "perform encoding");
      Object localObject = this.aPq[this.miO];
      if (localObject == null)
      {
        localObject = new RuntimeException("encoderOutputBuffer " + this.miO + " was null");
        AppMethodBeat.o(89593);
        throw ((Throwable)localObject);
      }
      this.frameCount += 1;
      if ((this.bufferInfo.flags & 0x2) != 0) {
        Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[] { Integer.valueOf(this.bufferInfo.size), Boolean.FALSE });
      }
      if (this.bufferInfo.size != 0)
      {
        if (this.Fbm != null)
        {
          AppMethodBeat.o(89593);
          throw null;
        }
        ((ByteBuffer)localObject).position(this.bufferInfo.offset);
        ((ByteBuffer)localObject).limit(this.bufferInfo.offset + this.bufferInfo.size);
        i((ByteBuffer)localObject, this.bufferInfo);
      }
      this.kTH.releaseOutputBuffer(this.miO, false);
      if ((this.bufferInfo.flags & 0x4) == 0) {
        break;
      }
      if (!this.frA)
      {
        Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "reached end of stream unexpectedly");
        AppMethodBeat.o(89593);
        return;
      }
      Log.w("MicroMsg.MMSightYUVMediaCodecRecorder", "do stop encoder");
      aUx();
    } while (this.Fca == null);
    this.Fca.eTF();
    this.Fca = null;
    AppMethodBeat.o(89593);
  }
  
  private void aUx()
  {
    AppMethodBeat.i(89599);
    if (this.Fbq)
    {
      eTO();
      AppMethodBeat.o(89599);
      return;
    }
    synchronized (this.kTT)
    {
      if ((this.Fbo) || (0L == this.startTime))
      {
        AppMethodBeat.o(89599);
        return;
      }
      this.Fbo = true;
      eTO();
      AppMethodBeat.o(89599);
      return;
    }
  }
  
  private int bri()
  {
    AppMethodBeat.i(89591);
    long l1 = Util.currentTicks();
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    Object localObject2;
    if (i < k)
    {
      ??? = MediaCodecList.getCodecInfoAt(i);
      if (((MediaCodecInfo)???).isEncoder())
      {
        localObject2 = ((MediaCodecInfo)???).getSupportedTypes();
        j = 0;
        label45:
        if (j < localObject2.length) {
          if (!localObject2[j].equalsIgnoreCase("video/avc")) {}
        }
      }
    }
    for (;;)
    {
      if (??? != null) {
        break label109;
      }
      Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "Unable to find an appropriate codec for video/avc");
      k.aWn();
      AppMethodBeat.o(89591);
      return -1;
      j += 1;
      break label45;
      i += 1;
      break;
      ??? = null;
    }
    label109:
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "found codec: %s, used %sms", new Object[] { ((MediaCodecInfo)???).getName(), Long.valueOf(Util.ticksToNow(l1)) });
    l1 = Util.currentTicks();
    i = -1;
    if (CaptureMMProxy.getInstance() != null) {
      i = CaptureMMProxy.getInstance().getInt(ar.a.Vnq, -1);
    }
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "saveColorFormat: %s", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      this.colorFormat = i;
      l1 = Util.ticksToNow(l1);
      if ((this.colorFormat > 0) && (l1 > 200L) && (CaptureMMProxy.getInstance() != null)) {
        CaptureMMProxy.getInstance().set(ar.a.Vnq, Integer.valueOf(this.colorFormat));
      }
      Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "found colorFormat: %s, used %sms", new Object[] { Integer.valueOf(this.colorFormat), Long.valueOf(l1) });
      l1 = Util.currentTicks();
      Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "initRotate: %s", new Object[] { Integer.valueOf(this.FbV) });
      if (!this.lhV) {
        break label813;
      }
      if ((this.FbV != 180) && (this.FbV != 0)) {
        break label797;
      }
      i = this.targetWidth;
      label324:
      if ((this.FbV != 180) && (this.FbV != 0)) {
        break label805;
      }
      j = this.targetHeight;
      label346:
      this.mediaFormat = MediaFormat.createVideoFormat("video/avc", i, j);
      label358:
      Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "createVideoFormat used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l1)) });
      if ((??? != null) && (!d.qV(23))) {
        break label974;
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = ((MediaCodecInfo)???).getCapabilitiesForType("video/avc");
        if (localObject2 == null) {
          continue;
        }
        localObject2 = ((MediaCodecInfo.CodecCapabilities)localObject2).profileLevels;
        if (localObject2 == null) {
          continue;
        }
        localCodecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        localCodecProfileLevel.level = 0;
        localCodecProfileLevel.profile = 0;
        k = localObject2.length;
        i = 0;
        if (i >= k) {
          continue;
        }
        Object localObject4 = localObject2[i];
        m = localObject4.profile;
        n = localObject4.level;
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "profile: %s, level: %s", new Object[] { Integer.valueOf(m), Integer.valueOf(n) });
        switch (m)
        {
        }
      }
      catch (Exception localException1)
      {
        try
        {
          MediaCodecInfo.CodecProfileLevel localCodecProfileLevel;
          int m;
          int n;
          long l2;
          label797:
          label805:
          label813:
          if (d.qV(21)) {
            this.mediaFormat.setInteger("bitrate-mode", 1);
          }
          this.mediaFormat.setInteger("bitrate", this.bitrate);
          this.mediaFormat.setInteger("frame-rate", this.frameRate);
          this.mediaFormat.setInteger("color-format", this.colorFormat);
          this.mediaFormat.setInteger("i-frame-interval", this.kSh);
          Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "mediaFormat: %s", new Object[] { this.mediaFormat });
          this.kTH = aa.KT(((MediaCodecInfo)???).getName());
          this.kTH.a(this.mediaFormat, null, 1);
          this.kTH.start();
          if (this.Fbq)
          {
            AppMethodBeat.o(89591);
            return 0;
            localException1 = localException1;
            Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "trySetProfile error: %s", new Object[] { localException1.getMessage() });
            continue;
          }
        }
        catch (Exception localException2)
        {
          Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "trySetBitRateMode error: %s", new Object[] { localException2.getMessage() });
          continue;
          synchronized (this.kTT)
          {
            this.Fbo = false;
            AppMethodBeat.o(89591);
            return 0;
          }
        }
        j = 0;
        continue;
      }
      if ((j != 0) && (m >= localCodecProfileLevel.profile) && (n >= localCodecProfileLevel.level))
      {
        localCodecProfileLevel.profile = m;
        localCodecProfileLevel.level = n;
      }
      i += 1;
      continue;
      i = 0;
      l2 = Util.currentTicks();
      localObject2 = ((MediaCodecInfo)???).getCapabilitiesForType("video/avc");
      Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "getCapabilitiesForType used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l2)) });
      Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "color format length: %s", new Object[] { Integer.valueOf(((MediaCodecInfo.CodecCapabilities)localObject2).colorFormats.length) });
      j = 0;
      if (j < ((MediaCodecInfo.CodecCapabilities)localObject2).colorFormats.length)
      {
        n = localObject2.colorFormats[j];
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "capabilities colorFormat: %s", new Object[] { Integer.valueOf(n) });
        switch (n)
        {
        default: 
          m = 0;
          k = i;
          if (m != 0) {
            if (n <= i)
            {
              k = i;
              if (n != 21) {}
            }
            else
            {
              k = n;
            }
          }
          j += 1;
          i = k;
          break;
        case 19: 
        case 21: 
        case 2130706688: 
          m = 1;
          break;
        }
      }
      else
      {
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "codec: %s, colorFormat: %s", new Object[] { ((MediaCodecInfo)???).getName(), Integer.valueOf(i) });
        break;
        i = this.targetHeight;
        break label324;
        j = this.targetWidth;
        break label346;
        if ((this.FbV == 180) || (this.FbV == 0))
        {
          i = this.targetHeight;
          if ((this.FbV != 180) && (this.FbV != 0)) {
            continue;
          }
          j = this.targetWidth;
          this.mediaFormat = MediaFormat.createVideoFormat("video/avc", i, j);
          break label358;
        }
        i = this.targetWidth;
        continue;
        j = this.targetHeight;
        continue;
        j = 1;
      }
    }
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "best profile: %s, level: %s", new Object[] { Integer.valueOf(localCodecProfileLevel.profile), Integer.valueOf(localCodecProfileLevel.level) });
    if ((localCodecProfileLevel.profile > 0) && (localCodecProfileLevel.level >= 256))
    {
      this.mediaFormat.setInteger("profile", localCodecProfileLevel.profile);
      this.mediaFormat.setInteger("level", 256);
    }
  }
  
  private void eTO()
  {
    AppMethodBeat.i(89600);
    try
    {
      if (this.FbZ != null) {
        this.FbZ.stop();
      }
      if (this.kTH != null)
      {
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "stop encoder");
        this.kTH.stop();
        this.kTH.release();
        this.isStart = false;
        this.kTH = null;
      }
      AppMethodBeat.o(89600);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89600);
    }
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(89595);
    this.Fca = parama;
    this.frA = true;
    boolean bool = this.FbZ.eTC();
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "!!!stop, isStart!!: %s %s isEnd %s", new Object[] { Boolean.valueOf(this.isStart), this.Fca, Boolean.valueOf(bool) });
    if (bool) {
      eTN();
    }
    AppMethodBeat.o(89595);
  }
  
  public final long aUC()
  {
    AppMethodBeat.i(89597);
    if (this.startTime <= 0L)
    {
      Log.w("MicroMsg.MMSightYUVMediaCodecRecorder", "do not start record");
      AppMethodBeat.o(89597);
      return 0L;
    }
    long l = (System.nanoTime() - this.startTime) / 1000000L;
    AppMethodBeat.o(89597);
    return l;
  }
  
  public void clear()
  {
    AppMethodBeat.i(89598);
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "clear");
    aUx();
    AppMethodBeat.o(89598);
  }
  
  public final void d(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(89592);
    if (!this.Fbq) {
      synchronized (this.kTT)
      {
        if (this.Fbo)
        {
          AppMethodBeat.o(89592);
          return;
        }
      }
    }
    try
    {
      if (!this.isStart)
      {
        Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData, not start!");
        AppMethodBeat.o(89592);
        return;
        paramArrayOfByte = finally;
        AppMethodBeat.o(89592);
        throw paramArrayOfByte;
      }
      if (this.kTH == null)
      {
        Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
        AppMethodBeat.o(89592);
        return;
      }
      if (this.Fbm != null)
      {
        AppMethodBeat.o(89592);
        throw null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      k.aWo();
      Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData error: %s", new Object[] { paramArrayOfByte.getMessage() });
      Log.printErrStackTrace("MicroMsg.MMSightYUVMediaCodecRecorder", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(89592);
      return;
    }
    long l1 = Util.currentTicks();
    this.bcY = this.kTH.avj();
    this.aPq = this.kTH.avk();
    int i = this.kTH.EX(100L);
    this.miN = i;
    if (i < 0)
    {
      Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "video no input available, drain first");
      aUD();
    }
    if (this.kTH == null)
    {
      Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
      AppMethodBeat.o(89592);
      return;
    }
    Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "inputBufferIndex: %s", new Object[] { Integer.valueOf(this.miN) });
    long l2 = Util.currentTicks();
    long l3;
    if (this.miN >= 0)
    {
      l3 = System.nanoTime();
      long l4 = paramArrayOfByte.length * 1000000000L / 1600000L;
      if (this.Fbm != null)
      {
        AppMethodBeat.o(89592);
        throw null;
      }
      l3 = (l3 - l4 - this.startTime) / 1000L;
      if ((l3 < 0L) && (this.FbB <= 0L)) {
        this.FbB = (-l3);
      }
      l3 += this.FbB;
      Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "presentationTime: ".concat(String.valueOf(l3)));
      ??? = this.bcY[this.miN];
      ((ByteBuffer)???).clear();
      ((ByteBuffer)???).put(paramArrayOfByte);
      ((ByteBuffer)???).position(0);
      if ((this.isStart) && (!paramBoolean)) {
        this.kTH.a(this.miN, paramArrayOfByte.length, l3, 0);
      }
    }
    for (;;)
    {
      aUD();
      Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder used %sms %sms", new Object[] { Long.valueOf(Util.ticksToNow(l1)), Long.valueOf(Util.ticksToNow(l2)) });
      AppMethodBeat.o(89592);
      return;
      Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "end of stream");
      this.miP = true;
      this.kTH.a(this.miN, paramArrayOfByte.length, l3, 4);
      continue;
      Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "input buffer not available");
    }
  }
  
  final void eTN()
  {
    AppMethodBeat.i(89596);
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "stopImp %s  isStart:%b", new Object[] { Util.getStack().toString(), Boolean.valueOf(this.isStart) });
    try
    {
      if (this.isStart) {
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(89587);
            r.a(r.this);
            if (r.this.Fca != null)
            {
              r.this.Fca.eTF();
              r.this.Fca = null;
            }
            AppMethodBeat.o(89587);
          }
        }, 500L);
      }
      AppMethodBeat.o(89596);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "stop error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89596);
    }
  }
  
  protected void i(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    AppMethodBeat.i(89594);
    if ((this.Fbm != null) && ((paramBufferInfo.flags & 0x4) == 0))
    {
      AppMethodBeat.o(89594);
      throw null;
    }
    AppMethodBeat.o(89594);
  }
  
  public int ie(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89590);
    try
    {
      this.FbV = paramInt2;
      paramInt1 = bri();
      AppMethodBeat.o(89590);
      return paramInt1;
    }
    catch (Exception localException1)
    {
      Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "init error: %s, try to re-init again", new Object[] { localException1.getMessage() });
      try
      {
        if (CaptureMMProxy.getInstance() != null) {
          CaptureMMProxy.getInstance().set(ar.a.Vnq, Integer.valueOf(-1));
        }
        paramInt1 = bri();
        AppMethodBeat.o(89590);
        return paramInt1;
      }
      catch (Exception localException2)
      {
        Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "re-init again error: %s", new Object[] { localException2.getMessage() });
        k.aWn();
        AppMethodBeat.o(89590);
      }
    }
    return -1;
  }
  
  public final void start()
  {
    AppMethodBeat.i(89589);
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "Start");
    this.isStart = true;
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "Start：isStart：" + this.isStart);
    this.startTime = System.nanoTime();
    AppMethodBeat.o(89589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.r
 * JD-Core Version:    0.7.0.1
 */