package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;

public final class n
  implements d
{
  protected int KXA;
  protected volatile q KXx;
  protected HandlerThread KXy;
  protected MMHandler KXz;
  protected int bufId;
  protected String mFileName;
  protected boolean mGp;
  protected String md5;
  protected Point nGb;
  protected boolean nKe;
  protected String nLB;
  protected boolean nLC;
  protected String nLD;
  protected boolean nLE;
  protected com.tencent.mm.plugin.mmsight.model.c nLF;
  protected com.tencent.mm.plugin.mmsight.model.c nLG;
  protected VideoTransPara nLH;
  protected m nLI;
  protected boolean nLJ;
  protected int nLK;
  protected d.a nLL;
  protected Runnable nLM;
  protected boolean nLN;
  protected boolean nLO;
  protected boolean nLP;
  private final Object nLl;
  protected String nLm;
  protected int nLn;
  protected float nLo;
  private int nLp;
  private float nLq;
  protected c nLr;
  protected int nLt;
  protected int nLu;
  protected int nLv;
  protected int nLw;
  protected int nLx;
  protected s nLy;
  protected int nLz;
  protected boolean nME;
  private boolean nMK;
  protected com.tencent.mm.plugin.mmsight.model.g nMg;
  protected String thumbPath;
  
  public n(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89551);
    this.nLl = new Object();
    this.nLm = "";
    this.nLn = 0;
    this.nLo = 0.0F;
    this.nLp = -1;
    this.nLq = -1.0F;
    this.nLt = 480;
    this.nLu = 640;
    this.nLv = 1600000;
    this.nLw = 480;
    this.nLx = 640;
    this.nLB = null;
    this.KXA = 0;
    this.nME = false;
    this.nLC = false;
    this.thumbPath = null;
    this.nLD = null;
    this.nLE = false;
    this.nGb = null;
    this.nLF = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.nLG = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.mGp = false;
    this.nLJ = false;
    this.md5 = "";
    this.nKe = false;
    this.nLK = 0;
    this.nLM = null;
    this.nLN = false;
    this.nLO = true;
    this.nLP = false;
    this.nMK = false;
    this.nMg = new com.tencent.mm.plugin.mmsight.model.g()
    {
      public final boolean onFrameData(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(89541);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preview callback data is null");
          AppMethodBeat.o(89541);
          return false;
        }
        if ((n.this.nLy.KXM == d.c.KWC) || (n.this.nLy.KXM == d.c.KWD))
        {
          if (n.this.nLy.KXM == d.c.KWD)
          {
            n.this.nLy.KXM = d.c.KWE;
            Log.v("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "forward one more frame");
          }
          n.this.nLG.ss(1L);
          if (n.this.nLr != null) {
            n.this.nLr.gcw();
          }
          n.this.ca(paramAnonymousArrayOfByte);
          AppMethodBeat.o(89541);
          return true;
        }
        AppMethodBeat.o(89541);
        return false;
      }
    };
    this.nLH = paramVideoTransPara;
    this.nLt = paramVideoTransPara.width;
    this.nLu = paramVideoTransPara.height;
    this.nLv = paramVideoTransPara.videoBitrate;
    k.gcB();
    int i = k.gcC();
    if (i == -1) {}
    for (this.nLv = paramVideoTransPara.videoBitrate;; this.nLv = i)
    {
      this.nLy = new s();
      Log.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "create MMSightMediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s", new Object[] { Integer.valueOf(this.nLt), Integer.valueOf(this.nLu), Integer.valueOf(this.nLv) });
      AppMethodBeat.o(89551);
      return;
    }
  }
  
  private boolean uv(int paramInt)
  {
    AppMethodBeat.i(89552);
    long l = Util.currentTicks();
    this.nME = com.tencent.mm.plugin.mmsight.model.j.KVJ.nME;
    int i = this.nLv;
    this.bufId = SightVideoJNI.initDataBufferForMMSightLock(this.nLw, this.nLx, paramInt, this.nLt, this.nLu, this.nLH.fps, i, this.nLH.oBP, 8, this.nLH.oBO, 23.0F, false, false, this.nLH.duration, false, false, this.nMK);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init, bufId: %s", new Object[] { Integer.valueOf(this.bufId) });
    if (this.bufId < 0)
    {
      Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init failed!");
      com.tencent.mm.plugin.mmsight.model.k.gcl();
      AppMethodBeat.o(89552);
      return false;
    }
    this.nLz = paramInt;
    this.KXx = new q(this.nLw, this.nLx, this.nLt, this.nLu, this.nLv, this.nLH.nCd, this.nLH.fps, this.nME);
    int j = this.KXx.jJ(this.bufId, paramInt);
    paramInt = 0;
    if (!this.nLP)
    {
      i = -1;
      if (CaptureMMProxy.getInstance() != null) {
        i = CaptureMMProxy.getInstance().getInt(at.a.acOF, -1);
      }
      int k;
      boolean bool;
      if (i < 0)
      {
        paramInt = this.nLH.audioSampleRate;
        i = this.nLH.audioBitrate;
        k = this.nLH.audioChannelCount;
        if (this.nLH.oCn == 1) {}
        for (bool = true;; bool = false)
        {
          this.nLr = new g(paramInt, i, k, com.tencent.mm.plugin.sight.base.c.aP(false, bool));
          this.nLr.yt(this.nLN);
          paramInt = this.nLr.L(this.bufId, f.aVV(this.nLm));
          if ((j >= 0) && (paramInt >= 0)) {
            break label793;
          }
          Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
          if ((paramInt >= 0) || (j < 0)) {
            break;
          }
          Log.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac init error, try mediarecorder now");
          this.nLr.clear();
          this.nLr = new i(this.nLH.audioSampleRate, this.nLH.audioBitrate, this.nLH.audioChannelCount);
          this.nLr.yt(this.nLN);
          paramInt = this.nLr.L(this.bufId, f.aVV(this.nLm));
          Log.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[] { Integer.valueOf(paramInt) });
          if (paramInt < 0) {
            break;
          }
          AppMethodBeat.o(89552);
          return true;
        }
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        com.tencent.mm.plugin.mmsight.model.k.gcl();
        AppMethodBeat.o(89552);
        return false;
      }
      if (i == 1)
      {
        paramInt = this.nLH.audioSampleRate;
        i = this.nLH.audioBitrate;
        k = this.nLH.audioChannelCount;
        if (this.nLH.oCn == 1)
        {
          bool = true;
          this.nLr = new g(paramInt, i, k, com.tencent.mm.plugin.sight.base.c.aP(false, bool));
          this.nLr.yt(this.nLN);
          paramInt = this.nLr.L(this.bufId, f.aVV(this.nLm));
        }
      }
      for (;;)
      {
        if ((j >= 0) && (paramInt >= 0)) {
          break label793;
        }
        Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        com.tencent.mm.plugin.mmsight.model.k.gcl();
        AppMethodBeat.o(89552);
        return false;
        bool = false;
        break;
        if (i == 2)
        {
          this.nLr = new i(this.nLH.audioSampleRate, this.nLH.audioBitrate, this.nLH.audioChannelCount);
          this.nLr.yt(this.nLN);
          paramInt = this.nLr.L(this.bufId, f.aVV(this.nLm));
        }
      }
    }
    if (j < 0)
    {
      Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mute init yuv recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(0) });
      SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
      com.tencent.mm.plugin.mmsight.model.k.gcl();
      AppMethodBeat.o(89552);
      return false;
    }
    label793:
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(89552);
    return true;
  }
  
  public final void A(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(89563);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.nLt = paramInt3;
    this.nLu = paramInt4;
    this.nLw = paramInt1;
    this.nLx = paramInt2;
    if (j.KXq.m(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = Util.currentTicks();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        j.KXq.as(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    }
    AppMethodBeat.o(89563);
  }
  
  public final void Hd(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void He(String paramString)
  {
    this.nLD = paramString;
  }
  
  public final void J(Runnable paramRunnable)
  {
    AppMethodBeat.i(89556);
    this.nLM = paramRunnable;
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", new Object[] { paramRunnable });
    if ((this.KXx == null) || ((this.nLr == null) && (!this.nLP)))
    {
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
      if (paramRunnable != null) {
        MMHandlerThread.postToMainThread(paramRunnable);
      }
      AppMethodBeat.o(89556);
      return;
    }
    if ((this.nLy != null) && (this.nLy.KXM == d.c.KWF))
    {
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, already in stop status");
      if (this.nLr != null) {
        this.nLr.clear();
      }
      if (this.KXx != null) {
        this.KXx.clear();
      }
      if (paramRunnable != null) {
        MMHandlerThread.postToMainThread(paramRunnable);
      }
      AppMethodBeat.o(89556);
      return;
    }
    this.nMg = null;
    this.nLn = ((int)this.KXx.bpj());
    if (this.nLy != null) {
      this.nLy.a(d.c.KWD);
    }
    if (this.KXx != null) {
      this.KXx.a(new f.a()
      {
        public final void gcy()
        {
          AppMethodBeat.i(89544);
          ThreadPool.post(new n.6(n.this), "MMSightMediaCodecMP4MuxRecorder_stop");
          AppMethodBeat.o(89544);
        }
      });
    }
    if (this.nLr != null) {
      this.nLr.a(new c.b()
      {
        public final void buN()
        {
          AppMethodBeat.i(89545);
          Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac stop finish");
          AppMethodBeat.o(89545);
        }
      });
    }
    AppMethodBeat.o(89556);
  }
  
  public final void a(d.a parama)
  {
    this.nLL = parama;
  }
  
  public final void ae(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89567);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    if ((this.nLy != null) && (this.nLy.KXM == d.c.KWK))
    {
      if (this.KXx != null)
      {
        q localq = this.KXx;
        localq.KXF = paramInt1;
        localq.KXG = paramInt2;
        localq.KXH = paramInt3;
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "resume, newRotation: %s, newFrameWidth: %s, newFrameHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      }
      this.nLy.a(d.c.KWC);
    }
    AppMethodBeat.o(89567);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(89555);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.nLF.reset();
    this.nLn = 0;
    this.nLG.reset();
    this.nLC = false;
    this.nKe = paramBoolean;
    this.nLK = paramInt2;
    this.nLy.a(d.c.KWB);
    if (Util.isNullOrNil(this.nLm))
    {
      Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(89555);
      return -1;
    }
    try
    {
      this.mFileName = y.bEq(this.nLm);
      String str2 = y.bEo(this.nLm);
      String str1 = str2;
      if (!str2.endsWith("/")) {
        str1 = str2 + "/";
      }
      this.nLB = (str1 + "tempRotate.mp4");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "retrieve file name error: %s", new Object[] { localException.getMessage() });
        continue;
        this.nLy.a(d.c.KWJ);
        continue;
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start yuvRecorder with mute");
        this.KXx.start();
        this.nLy.a(d.c.KWC);
        this.nLJ = false;
        com.tencent.mm.plugin.mmsight.model.k.gcj();
        com.tencent.mm.plugin.mmsight.model.k.bqN();
        paramInt1 = 0;
      }
    }
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", new Object[] { this.nLm, this.nLB });
    this.nLz = paramInt1;
    this.KXy = com.tencent.threadpool.c.d.jx("BigSightMediaCodecMP4MuxRecorder_writeYuvData_" + hashCode(), -1);
    this.KXy.start();
    this.KXz = new MMHandler(this.KXy.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89542);
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "carson：writeYuvData ");
        if (paramAnonymousMessage.what == 1)
        {
          paramAnonymousMessage = (byte[])paramAnonymousMessage.obj;
          if ((paramAnonymousMessage != null) && (n.this.KXx != null)) {
            n.a(n.this, paramAnonymousMessage);
          }
        }
        AppMethodBeat.o(89542);
      }
    };
    if (!this.mGp)
    {
      uv(paramInt1);
      this.mGp = true;
    }
    if ((!this.nLP) && (!this.nLN))
    {
      paramInt1 = this.nLr.a(new c.a()
      {
        public final void buO()
        {
          AppMethodBeat.i(89543);
          Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "onPcmReady");
          if (n.this.buD() != d.c.KWJ)
          {
            Log.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
            AppMethodBeat.o(89543);
            return;
          }
          n.this.KXx.start();
          n.this.nLy.a(d.c.KWC);
          AppMethodBeat.o(89543);
        }
      });
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start aacRecorder ret: %s", new Object[] { Integer.valueOf(paramInt1) });
      this.nLJ = false;
      if (paramInt1 != 0)
      {
        this.nLy.a(d.c.KWI);
        com.tencent.mm.plugin.mmsight.model.k.gcj();
        com.tencent.mm.plugin.mmsight.model.k.bqN();
        AppMethodBeat.o(89555);
        return paramInt1;
      }
    }
  }
  
  public final void bq(float paramFloat)
  {
    AppMethodBeat.i(89570);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.nLq = paramFloat;
    AppMethodBeat.o(89570);
  }
  
  public final String buA()
  {
    return this.nLD;
  }
  
  public final float buB()
  {
    return this.nLo;
  }
  
  public final long buC()
  {
    AppMethodBeat.i(89562);
    if (this.KXx != null)
    {
      long l = this.KXx.bpj();
      AppMethodBeat.o(89562);
      return l;
    }
    AppMethodBeat.o(89562);
    return 0L;
  }
  
  public final d.c buD()
  {
    return this.nLy.KXM;
  }
  
  public final int buE()
  {
    AppMethodBeat.i(89564);
    int i = Math.round(this.nLn / 1000.0F);
    AppMethodBeat.o(89564);
    return i;
  }
  
  public final Point buF()
  {
    AppMethodBeat.i(89565);
    Point localPoint = new Point(this.nLw, this.nLx);
    AppMethodBeat.o(89565);
    return localPoint;
  }
  
  public final int buG()
  {
    return this.nLz;
  }
  
  public final boolean buH()
  {
    return this.nLJ;
  }
  
  public final com.tencent.mm.audio.b.c.a buI()
  {
    AppMethodBeat.i(89568);
    if (this.nLr != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.nLr.gcx();
      AppMethodBeat.o(89568);
      return locala;
    }
    AppMethodBeat.o(89568);
    return null;
  }
  
  public final void buJ()
  {
    this.nLO = false;
  }
  
  public final String bud()
  {
    return this.thumbPath;
  }
  
  final boolean buy()
  {
    AppMethodBeat.i(89557);
    long l = Util.currentTicks();
    int i;
    if ((this.KXy != null) && (this.KXz != null))
    {
      if (com.tencent.mm.compatible.util.d.rb(18))
      {
        this.KXy.quitSafely();
        this.KXz = null;
      }
    }
    else
    {
      i = this.KXx.frameCount;
      this.nLo = (i * 1000.0F / this.nLn);
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", new Object[] { Integer.valueOf(i), Float.valueOf(this.nLo), Integer.valueOf(this.nLn), this.nLm, Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.nLp), Float.valueOf(this.nLq) });
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "frameCountCallback %s", new Object[] { this.nLG.getValue() });
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "yuvRecorderWriteDataCallback %s", new Object[] { this.nLF.getValue() });
      str = null;
      if (CaptureMMProxy.getInstance() == null) {
        break label381;
      }
      str = CaptureMMProxy.getInstance().getAccVideoPath();
      label210:
      if (Util.isNullOrNil(str)) {
        break label416;
      }
    }
    label416:
    for (String str = com.tencent.mm.plugin.mmsight.d.aMs(str);; str = this.nLm)
    {
      i = this.nLn;
      if (this.nLp > 0) {
        i = this.nLp;
      }
      float f = this.nLo;
      if (this.nLq > 0.0F) {
        f = this.nLq;
      }
      this.nLI = new m(this.bufId, str, f, this.nLv, i, this.nLH.audioSampleRate, this.nLP, false, false);
      l = Util.currentTicks();
      boolean bool = this.nLI.yu(this.nMK);
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Boolean.valueOf(bool) });
      if (bool) {
        break label425;
      }
      Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux failed!");
      com.tencent.mm.plugin.mmsight.model.k.gcm();
      AppMethodBeat.o(89557);
      return false;
      this.KXy.quit();
      break;
      label381:
      if (Util.isNullOrNil(this.nLm)) {
        break label210;
      }
      str = ah.v(new u(this.nLm).jKP().jKT());
      break label210;
    }
    label425:
    if (((this.nKe) && (this.nME)) || ((!this.nME) && (!this.nKe)) || ((this.nKe) && (Math.abs(this.nLz - this.nLK) == 0)) || (this.nLK == 180))
    {
      l = Util.currentTicks();
      if ((this.nME) || (this.nKe)) {
        break label763;
      }
      i = this.nLz;
    }
    for (;;)
    {
      int j = i;
      if (this.nLK == 180)
      {
        j = i;
        if (!this.nME)
        {
          i += 180;
          j = i;
          if (i > 360) {
            j = i - 360;
          }
        }
      }
      if (j > 0)
      {
        SightVideoJNI.tagRotateVideoVFS(str, this.nLB, j);
        this.nLE = true;
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.nLz), Boolean.valueOf(this.nKe), Integer.valueOf(this.nLK), Integer.valueOf(j) });
        l = Util.currentTicks();
      }
      try
      {
        y.deleteFile(str);
        y.qn(this.nLB, str);
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "copyFile cost %s", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(89548);
            try
            {
              y.deleteFile(this.nMo);
              AppMethodBeat.o(89548);
              return;
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, delete old file error: %s", new Object[] { localException.getMessage() });
              AppMethodBeat.o(89548);
            }
          }
        }, "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        this.nLy.a(d.c.KWF);
        this.md5 = y.bub(str);
        if ((!Util.isNullOrNil(str)) && (!str.equals(this.nLm)))
        {
          y.qn(str, this.nLm);
          y.deleteFile(str);
        }
        AppMethodBeat.o(89557);
        return true;
      }
      catch (Exception localException)
      {
        label763:
        Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, copy file error");
        AppMethodBeat.o(89557);
      }
      if (this.nME) {
        i = this.nLK;
      } else {
        i = 180;
      }
    }
    return false;
  }
  
  protected final void ca(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89553);
    if (this.KXx != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramArrayOfByte;
      if (this.KXz != null) {
        this.KXz.sendMessage(localMessage);
      }
    }
    AppMethodBeat.o(89553);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(89559);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "cancel record");
    if ((this.KXx == null) || ((this.nLr == null) && (!this.nLP)))
    {
      Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
      AppMethodBeat.o(89559);
      return;
    }
    this.nLy.a(d.c.KWE);
    this.KXx.a(null);
    if (this.nLr != null) {
      this.nLr.a(new c.b()
      {
        public final void buN()
        {
          AppMethodBeat.i(89549);
          Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac stop finish");
          AppMethodBeat.o(89549);
        }
      });
    }
    if ((this.KXy != null) && (this.KXz != null))
    {
      this.KXz.removeMessages(0);
      this.KXy.quit();
      this.KXz = null;
    }
    SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
    this.nLy.a(d.c.KWF);
    reset();
    AppMethodBeat.o(89559);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89560);
    try
    {
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "clear");
      if (this.nLr != null) {
        this.nLr.clear();
      }
      if (this.KXx != null) {
        this.KXx.clear();
      }
      AppMethodBeat.o(89560);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.MMSightMediaCodecMP4MuxRecorder", localException, "clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89560);
    }
  }
  
  public final void gI(boolean paramBoolean)
  {
    this.nLN = paramBoolean;
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.nLm;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.g getFrameDataCallback()
  {
    return this.nMg;
  }
  
  public final String getMd5()
  {
    AppMethodBeat.i(89558);
    String str = Util.nullAs(this.md5, "");
    AppMethodBeat.o(89558);
    return str;
  }
  
  public final boolean isLandscape()
  {
    return this.nKe;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89566);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "pause");
    if ((this.nLy != null) && (this.nLy.KXM == d.c.KWC)) {
      this.nLy.a(d.c.KWK);
    }
    AppMethodBeat.o(89566);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(89561);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", new Object[] { this.KXx, this.nLr, this.nLI });
    synchronized (this.nLl)
    {
      this.KXx = null;
      this.nLr = null;
      this.nLI = null;
      this.mGp = false;
      this.nLJ = false;
      AppMethodBeat.o(89561);
      return;
    }
  }
  
  public final void setFilePath(String paramString)
  {
    this.nLm = paramString;
  }
  
  public final void setMirror(boolean paramBoolean) {}
  
  public final void setMute(boolean paramBoolean)
  {
    this.nLP = paramBoolean;
  }
  
  public final boolean uw(int paramInt)
  {
    AppMethodBeat.i(89554);
    if (!this.mGp)
    {
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preInit, cameraOrientation");
      boolean bool = uv(paramInt);
      this.mGp = true;
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(89554);
      return bool;
    }
    AppMethodBeat.o(89554);
    return true;
  }
  
  public final void ux(int paramInt)
  {
    AppMethodBeat.i(89569);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.nLp = paramInt;
    AppMethodBeat.o(89569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.n
 * JD-Core Version:    0.7.0.1
 */