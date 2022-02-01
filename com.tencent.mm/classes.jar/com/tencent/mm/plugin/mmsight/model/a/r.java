package com.tencent.mm.plugin.mmsight.model.a;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.be.b;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import java.nio.ByteBuffer;

public class r
  implements f
{
  private o KWV;
  private boolean KWX;
  private boolean KWZ;
  int KXE;
  int KXF;
  int KXG;
  int KXH;
  a KXI;
  f.a KXJ;
  private a.a KXK;
  private long KXk;
  private int bitrate;
  private MediaCodec.BufferInfo bufferInfo;
  private ByteBuffer[] cJm;
  private ByteBuffer[] cWS;
  int colorFormat;
  int frameCount;
  private int frameRate;
  boolean hvE;
  private boolean isStart;
  protected MediaFormat mediaFormat;
  private long mwK;
  boolean nME;
  int nxO;
  int nxP;
  private int nxQ;
  private final Object nzC;
  protected aa nzs;
  private int pck;
  private int pcl;
  private boolean pcm;
  private int qpD;
  private int qpE;
  private long startTime;
  
  public r(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean)
  {
    AppMethodBeat.i(89588);
    this.startTime = 0L;
    this.mwK = 0L;
    this.pck = -1;
    this.pcl = -1;
    this.bitrate = 0;
    this.isStart = false;
    this.hvE = false;
    this.pcm = false;
    this.KXE = -1;
    this.KXF = -1;
    this.KXG = -1;
    this.KXH = -1;
    this.nME = false;
    this.nzC = new Object();
    this.KWX = false;
    this.KWZ = true;
    this.KXk = 0L;
    this.KXK = new a.a()
    {
      public final void bZ(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(89586);
        long l = Util.currentTicks();
        boolean bool2 = r.this.KXI.gcv();
        r localr = r.this;
        if ((bool2) && (r.this.hvE)) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          localr.d(paramAnonymousArrayOfByte, bool1);
          b.pcg.as(paramAnonymousArrayOfByte);
          Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "markStop: %s isEnd %s costTime %d", new Object[] { Boolean.valueOf(r.this.hvE), Boolean.valueOf(bool2), Long.valueOf(Util.ticksToNow(l)) });
          if ((bool2) && (r.this.hvE)) {
            r.this.gcF();
          }
          AppMethodBeat.o(89586);
          return;
        }
      }
    };
    this.KXI = new a(this.KXK);
    this.qpD = paramInt1;
    this.qpE = paramInt2;
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, init targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create MMSightYUVMediaCodecRecorder, after align 16, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.nxO = paramInt3;
    this.nxP = paramInt4;
    this.frameRate = paramInt7;
    this.nxQ = paramInt6;
    this.KWV = null;
    this.bufferInfo = new MediaCodec.BufferInfo();
    this.bitrate = paramInt5;
    this.nME = paramBoolean;
    this.KWZ = ((c)h.ax(c.class)).a(c.a.yVg, false);
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "create BigSightMediaCodecYUVRecorder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s, needRotateEachFrame: %s, muxer: %s", new Object[] { Integer.valueOf(this.qpD), Integer.valueOf(this.qpE), Integer.valueOf(this.nxO), Integer.valueOf(this.nxP), Integer.valueOf(paramInt5), Boolean.valueOf(paramBoolean), null });
    AppMethodBeat.o(89588);
  }
  
  private int bOO()
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
        label44:
        if (j < localObject2.length) {
          if (!localObject2[j].equalsIgnoreCase("video/avc")) {}
        }
      }
    }
    for (;;)
    {
      if (??? != null) {
        break label105;
      }
      Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "Unable to find an appropriate codec for video/avc");
      k.bqV();
      AppMethodBeat.o(89591);
      return -1;
      j += 1;
      break label44;
      i += 1;
      break;
      ??? = null;
    }
    label105:
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "found codec: %s, used %sms", new Object[] { ((MediaCodecInfo)???).getName(), Long.valueOf(Util.ticksToNow(l1)) });
    l1 = Util.currentTicks();
    i = -1;
    if (CaptureMMProxy.getInstance() != null) {
      i = CaptureMMProxy.getInstance().getInt(at.a.acOL, -1);
    }
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "saveColorFormat: %s", new Object[] { Integer.valueOf(i) });
    if (i > 0)
    {
      this.colorFormat = i;
      l1 = Util.ticksToNow(l1);
      if ((this.colorFormat > 0) && (l1 > 200L) && (CaptureMMProxy.getInstance() != null)) {
        CaptureMMProxy.getInstance().set(at.a.acOL, Integer.valueOf(this.colorFormat));
      }
      Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "found colorFormat: %s, used %sms", new Object[] { Integer.valueOf(this.colorFormat), Long.valueOf(l1) });
      l1 = Util.currentTicks();
      Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "initRotate: %s", new Object[] { Integer.valueOf(this.KXE) });
      if (!this.nME) {
        break label805;
      }
      if ((this.KXE != 180) && (this.KXE != 0)) {
        break label789;
      }
      i = this.nxO;
      label319:
      if ((this.KXE != 180) && (this.KXE != 0)) {
        break label797;
      }
      j = this.nxP;
      label341:
      this.mediaFormat = MediaFormat.createVideoFormat("video/avc", i, j);
      label352:
      Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "createVideoFormat used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l1)) });
      if ((??? != null) && (!d.rb(23))) {
        break label965;
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
          label789:
          label797:
          label805:
          if (d.rb(21)) {
            this.mediaFormat.setInteger("bitrate-mode", 1);
          }
          this.mediaFormat.setInteger("bitrate", this.bitrate);
          this.mediaFormat.setInteger("frame-rate", this.frameRate);
          this.mediaFormat.setInteger("color-format", this.colorFormat);
          this.mediaFormat.setInteger("i-frame-interval", this.nxQ);
          Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "mediaFormat: %s", new Object[] { this.mediaFormat });
          this.nzs = aa.Dx(((MediaCodecInfo)???).getName());
          this.nzs.a(this.mediaFormat, null, 1);
          this.nzs.start();
          if (this.KWZ)
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
          synchronized (this.nzC)
          {
            this.KWX = false;
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
        i = this.nxP;
        break label319;
        j = this.nxO;
        break label341;
        if ((this.KXE == 180) || (this.KXE == 0))
        {
          i = this.nxP;
          if ((this.KXE != 180) && (this.KXE != 0)) {
            continue;
          }
          j = this.nxO;
          this.mediaFormat = MediaFormat.createVideoFormat("video/avc", i, j);
          break label352;
        }
        i = this.nxO;
        continue;
        j = this.nxP;
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
  
  private void boZ()
  {
    AppMethodBeat.i(89599);
    if (this.KWZ)
    {
      gcG();
      AppMethodBeat.o(89599);
      return;
    }
    synchronized (this.nzC)
    {
      if ((this.KWX) || (0L == this.startTime))
      {
        AppMethodBeat.o(89599);
        return;
      }
      this.KWX = true;
      gcG();
      AppMethodBeat.o(89599);
      return;
    }
  }
  
  private void bpk()
  {
    AppMethodBeat.i(89593);
    this.pcl = this.nzs.dequeueOutputBuffer(this.bufferInfo, 100L);
    Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "outputBufferIndex-->" + this.pcl);
    do
    {
      if (this.pcl != -1) {
        break label154;
      }
      Log.d("MicroMsg.MMSightYUVMediaCodecRecorder", "no output from encoder available, break encoderEndStream %s", new Object[] { Boolean.valueOf(this.pcm) });
      if (!this.pcm) {
        break;
      }
      this.pcl = this.nzs.dequeueOutputBuffer(this.bufferInfo, 100L);
      if (this.pcl <= 0) {
        Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "get outputBufferIndex %d", new Object[] { Integer.valueOf(this.pcl) });
      }
    } while ((this.pcl >= 0) || (this.pcm));
    label154:
    do
    {
      AppMethodBeat.o(89593);
      return;
      if (this.pcl == -3)
      {
        this.cJm = this.nzs.aPE();
        Log.d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output buffers changed");
        break;
      }
      if (this.pcl == -2)
      {
        Log.d("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder output format changed: ".concat(String.valueOf(this.nzs.getOutputFormat())));
        if (this.KWV == null) {
          break;
        }
        AppMethodBeat.o(89593);
        throw null;
      }
      if (this.pcl < 0)
      {
        Log.w("MicroMsg.MMSightYUVMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + this.pcl);
        break;
      }
      Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "perform encoding");
      Object localObject = this.cJm[this.pcl];
      if (localObject == null)
      {
        localObject = new RuntimeException("encoderOutputBuffer " + this.pcl + " was null");
        AppMethodBeat.o(89593);
        throw ((Throwable)localObject);
      }
      this.frameCount += 1;
      if ((this.bufferInfo.flags & 0x2) != 0)
      {
        Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[] { Integer.valueOf(this.bufferInfo.size), Boolean.valueOf(boY()) });
        if (boY()) {
          this.bufferInfo.size = 0;
        }
      }
      if (this.bufferInfo.size != 0)
      {
        if (this.KWV != null)
        {
          AppMethodBeat.o(89593);
          throw null;
        }
        ((ByteBuffer)localObject).position(this.bufferInfo.offset);
        ((ByteBuffer)localObject).limit(this.bufferInfo.offset + this.bufferInfo.size);
        i((ByteBuffer)localObject, this.bufferInfo);
      }
      this.nzs.releaseOutputBuffer(this.pcl, false);
      if ((this.bufferInfo.flags & 0x4) == 0) {
        break;
      }
      if (!this.hvE)
      {
        Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "reached end of stream unexpectedly");
        AppMethodBeat.o(89593);
        return;
      }
      Log.w("MicroMsg.MMSightYUVMediaCodecRecorder", "do stop encoder");
      boZ();
    } while (this.KXJ == null);
    this.KXJ.gcy();
    this.KXJ = null;
    AppMethodBeat.o(89593);
  }
  
  private void gcG()
  {
    AppMethodBeat.i(89600);
    try
    {
      if (this.KXI != null) {
        this.KXI.stop();
      }
      if (this.nzs != null)
      {
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "stop encoder");
        this.nzs.stop();
        this.nzs.release();
        this.isStart = false;
        this.nzs = null;
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
    this.KXJ = parama;
    this.hvE = true;
    boolean bool = this.KXI.gcv();
    Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "!!!stop, isStart!!: %s %s isEnd %s", new Object[] { Boolean.valueOf(this.isStart), this.KXJ, Boolean.valueOf(bool) });
    if (bool) {
      gcF();
    }
    AppMethodBeat.o(89595);
  }
  
  protected boolean boY()
  {
    return false;
  }
  
  public final long bpj()
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
    boZ();
    AppMethodBeat.o(89598);
  }
  
  public final void d(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(89592);
    if (!this.KWZ) {
      synchronized (this.nzC)
      {
        if (this.KWX)
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
      if (this.nzs == null)
      {
        Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
        AppMethodBeat.o(89592);
        return;
      }
      if (this.KWV != null)
      {
        AppMethodBeat.o(89592);
        throw null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      k.bqW();
      Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "writeData error: %s", new Object[] { paramArrayOfByte.getMessage() });
      Log.printErrStackTrace("MicroMsg.MMSightYUVMediaCodecRecorder", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(89592);
      return;
    }
    long l1 = Util.currentTicks();
    this.cWS = this.nzs.aPD();
    this.cJm = this.nzs.aPE();
    int i = this.nzs.dequeueInputBuffer(100L);
    this.pck = i;
    if (i < 0)
    {
      Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "video no input available, drain first");
      bpk();
    }
    if (this.nzs == null)
    {
      Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder is null");
      AppMethodBeat.o(89592);
      return;
    }
    Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "inputBufferIndex: %s", new Object[] { Integer.valueOf(this.pck) });
    long l2 = Util.currentTicks();
    long l3;
    if (this.pck >= 0)
    {
      l3 = System.nanoTime();
      long l4 = paramArrayOfByte.length * 1000000000L / 1600000L;
      if (this.KWV != null)
      {
        AppMethodBeat.o(89592);
        throw null;
      }
      l3 = (l3 - l4 - this.startTime) / 1000L;
      if ((l3 < 0L) && (this.KXk <= 0L)) {
        this.KXk = (-l3);
      }
      l3 += this.KXk;
      Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "presentationTime: ".concat(String.valueOf(l3)));
      ??? = this.cWS[this.pck];
      ((ByteBuffer)???).clear();
      ((ByteBuffer)???).put(paramArrayOfByte);
      ((ByteBuffer)???).position(0);
      if ((this.isStart) && (!paramBoolean)) {
        this.nzs.a(this.pck, paramArrayOfByte.length, l3, 0);
      }
    }
    for (;;)
    {
      bpk();
      Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "encoder used %sms %sms", new Object[] { Long.valueOf(Util.ticksToNow(l1)), Long.valueOf(Util.ticksToNow(l2)) });
      AppMethodBeat.o(89592);
      return;
      Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "end of stream");
      this.pcm = true;
      this.nzs.a(this.pck, paramArrayOfByte.length, l3, 4);
      continue;
      Log.v("MicroMsg.MMSightYUVMediaCodecRecorder", "input buffer not available");
    }
  }
  
  final void gcF()
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
            if (r.this.KXJ != null)
            {
              r.this.KXJ.gcy();
              r.this.KXJ = null;
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
    if ((this.KWV != null) && ((paramBufferInfo.flags & 0x4) == 0))
    {
      AppMethodBeat.o(89594);
      throw null;
    }
    AppMethodBeat.o(89594);
  }
  
  public int jJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(89590);
    try
    {
      this.KXE = paramInt2;
      paramInt1 = bOO();
      AppMethodBeat.o(89590);
      return paramInt1;
    }
    catch (Exception localException1)
    {
      Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "init error: %s, try to re-init again", new Object[] { localException1.getMessage() });
      try
      {
        if (CaptureMMProxy.getInstance() != null) {
          CaptureMMProxy.getInstance().set(at.a.acOL, Integer.valueOf(-1));
        }
        paramInt1 = bOO();
        AppMethodBeat.o(89590);
        return paramInt1;
      }
      catch (Exception localException2)
      {
        Log.e("MicroMsg.MMSightYUVMediaCodecRecorder", "re-init again error: %s", new Object[] { localException2.getMessage() });
        k.bqV();
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