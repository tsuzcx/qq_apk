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
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.u;

public final class n
  implements d
{
  protected volatile q FbO;
  protected HandlerThread FbP;
  protected MMHandler FbQ;
  protected int FbR;
  protected int bufId;
  protected boolean kfR;
  protected Point laW;
  protected boolean lft;
  private final Object lgB;
  protected String lgC;
  protected int lgD;
  protected float lgE;
  private int lgF;
  private float lgG;
  protected c lgH;
  protected int lgJ;
  protected int lgK;
  protected int lgL;
  protected int lgM;
  protected int lgN;
  protected s lgO;
  protected int lgP;
  protected String lgR;
  protected boolean lgS;
  protected String lgT;
  protected boolean lgU;
  protected com.tencent.mm.plugin.mmsight.model.c lgV;
  protected com.tencent.mm.plugin.mmsight.model.c lgW;
  protected VideoTransPara lgX;
  protected m lgY;
  protected boolean lgZ;
  protected boolean lhV;
  protected int lha;
  protected d.a lhb;
  protected Runnable lhc;
  protected boolean lhd;
  protected boolean lhe;
  protected boolean lhf;
  protected com.tencent.mm.plugin.mmsight.model.g lhw;
  private boolean lib;
  protected String mFileName;
  protected String md5;
  protected String thumbPath;
  
  public n(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89551);
    this.lgB = new Object();
    this.lgC = "";
    this.lgD = 0;
    this.lgE = 0.0F;
    this.lgF = -1;
    this.lgG = -1.0F;
    this.lgJ = 480;
    this.lgK = 640;
    this.lgL = 1600000;
    this.lgM = 480;
    this.lgN = 640;
    this.lgR = null;
    this.FbR = 0;
    this.lhV = false;
    this.lgS = false;
    this.thumbPath = null;
    this.lgT = null;
    this.lgU = false;
    this.laW = null;
    this.lgV = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.lgW = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.kfR = false;
    this.lgZ = false;
    this.md5 = "";
    this.lft = false;
    this.lha = 0;
    this.lhc = null;
    this.lhd = false;
    this.lhe = true;
    this.lhf = false;
    this.lib = false;
    this.lhw = new com.tencent.mm.plugin.mmsight.model.g()
    {
      public final boolean ar(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(89541);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preview callback data is null");
          AppMethodBeat.o(89541);
          return false;
        }
        if ((n.this.lgO.Fcd == d.c.FaT) || (n.this.lgO.Fcd == d.c.FaU))
        {
          if (n.this.lgO.Fcd == d.c.FaU)
          {
            n.this.lgO.Fcd = d.c.FaV;
            Log.v("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "forward one more frame");
          }
          n.this.lgW.Ox(1L);
          if (n.this.lgH != null) {
            n.this.lgH.eTD();
          }
          n.this.bY(paramAnonymousArrayOfByte);
          AppMethodBeat.o(89541);
          return true;
        }
        AppMethodBeat.o(89541);
        return false;
      }
    };
    this.lgX = paramVideoTransPara;
    this.lgJ = paramVideoTransPara.width;
    this.lgK = paramVideoTransPara.height;
    this.lgL = paramVideoTransPara.videoBitrate;
    k.eTI();
    int i = k.eTK();
    if (i == -1) {}
    for (this.lgL = paramVideoTransPara.videoBitrate;; this.lgL = i)
    {
      this.lgO = new s();
      Log.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "create MMSightMediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s", new Object[] { Integer.valueOf(this.lgJ), Integer.valueOf(this.lgK), Integer.valueOf(this.lgL) });
      AppMethodBeat.o(89551);
      return;
    }
  }
  
  private boolean uv(int paramInt)
  {
    AppMethodBeat.i(89552);
    long l = Util.currentTicks();
    this.lhV = com.tencent.mm.plugin.mmsight.model.j.EZX.lhV;
    int i = this.lgL;
    this.bufId = SightVideoJNI.initDataBufferForMMSightLock(this.lgM, this.lgN, paramInt, this.lgJ, this.lgK, this.lgX.fps, i, this.lgX.lJn, 8, this.lgX.lJm, 23.0F, false, false, this.lgX.duration, false, false, this.lib);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init, bufId: %s", new Object[] { Integer.valueOf(this.bufId) });
    if (this.bufId < 0)
    {
      Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init failed!");
      com.tencent.mm.plugin.mmsight.model.k.eTs();
      AppMethodBeat.o(89552);
      return false;
    }
    this.lgP = paramInt;
    this.FbO = new q(this.lgM, this.lgN, this.lgJ, this.lgK, this.lgL, this.lgX.kXt, this.lgX.fps, this.lhV);
    int j = this.FbO.ie(this.bufId, paramInt);
    paramInt = 0;
    if (!this.lhf)
    {
      i = -1;
      if (CaptureMMProxy.getInstance() != null) {
        i = CaptureMMProxy.getInstance().getInt(ar.a.Vnk, -1);
      }
      int k;
      boolean bool;
      if (i < 0)
      {
        paramInt = this.lgX.audioSampleRate;
        i = this.lgX.audioBitrate;
        k = this.lgX.audioChannelCount;
        if (this.lgX.lJL == 1) {}
        for (bool = true;; bool = false)
        {
          this.lgH = new g(paramInt, i, k, com.tencent.mm.plugin.sight.base.c.aw(false, bool));
          this.lgH.uf(this.lhd);
          paramInt = this.lgH.J(this.bufId, f.aYe(this.lgC));
          if ((j >= 0) && (paramInt >= 0)) {
            break label793;
          }
          Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
          if ((paramInt >= 0) || (j < 0)) {
            break;
          }
          Log.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac init error, try mediarecorder now");
          this.lgH.clear();
          this.lgH = new i(this.lgX.audioSampleRate, this.lgX.audioBitrate, this.lgX.audioChannelCount);
          this.lgH.uf(this.lhd);
          paramInt = this.lgH.J(this.bufId, f.aYe(this.lgC));
          Log.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[] { Integer.valueOf(paramInt) });
          if (paramInt < 0) {
            break;
          }
          AppMethodBeat.o(89552);
          return true;
        }
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        com.tencent.mm.plugin.mmsight.model.k.eTs();
        AppMethodBeat.o(89552);
        return false;
      }
      if (i == 1)
      {
        paramInt = this.lgX.audioSampleRate;
        i = this.lgX.audioBitrate;
        k = this.lgX.audioChannelCount;
        if (this.lgX.lJL == 1)
        {
          bool = true;
          this.lgH = new g(paramInt, i, k, com.tencent.mm.plugin.sight.base.c.aw(false, bool));
          this.lgH.uf(this.lhd);
          paramInt = this.lgH.J(this.bufId, f.aYe(this.lgC));
        }
      }
      for (;;)
      {
        if ((j >= 0) && (paramInt >= 0)) {
          break label793;
        }
        Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        com.tencent.mm.plugin.mmsight.model.k.eTs();
        AppMethodBeat.o(89552);
        return false;
        bool = false;
        break;
        if (i == 2)
        {
          this.lgH = new i(this.lgX.audioSampleRate, this.lgX.audioBitrate, this.lgX.audioChannelCount);
          this.lgH.uf(this.lhd);
          paramInt = this.lgH.J(this.bufId, f.aYe(this.lgC));
        }
      }
    }
    if (j < 0)
    {
      Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mute init yuv recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(0) });
      SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
      com.tencent.mm.plugin.mmsight.model.k.eTs();
      AppMethodBeat.o(89552);
      return false;
    }
    label793:
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(89552);
    return true;
  }
  
  public final void E(Runnable paramRunnable)
  {
    AppMethodBeat.i(89556);
    this.lhc = paramRunnable;
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", new Object[] { paramRunnable });
    if ((this.FbO == null) || ((this.lgH == null) && (!this.lhf)))
    {
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
      if (paramRunnable != null) {
        MMHandlerThread.postToMainThread(paramRunnable);
      }
      AppMethodBeat.o(89556);
      return;
    }
    if ((this.lgO != null) && (this.lgO.Fcd == d.c.FaW))
    {
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, already in stop status");
      if (this.lgH != null) {
        this.lgH.clear();
      }
      if (this.FbO != null) {
        this.FbO.clear();
      }
      if (paramRunnable != null) {
        MMHandlerThread.postToMainThread(paramRunnable);
      }
      AppMethodBeat.o(89556);
      return;
    }
    this.lhw = null;
    this.lgD = ((int)this.FbO.aUC());
    if (this.lgO != null) {
      this.lgO.a(d.c.FaU);
    }
    if (this.FbO != null) {
      this.FbO.a(new f.a()
      {
        public final void eTF()
        {
          AppMethodBeat.i(89544);
          ThreadPool.post(new n.6(n.this), "MMSightMediaCodecMP4MuxRecorder_stop");
          AppMethodBeat.o(89544);
        }
      });
    }
    if (this.lgH != null) {
      this.lgH.a(new c.b()
      {
        public final void aZQ()
        {
          AppMethodBeat.i(89545);
          Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac stop finish");
          AppMethodBeat.o(89545);
        }
      });
    }
    AppMethodBeat.o(89556);
  }
  
  public final void ON(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void OO(String paramString)
  {
    this.lgT = paramString;
  }
  
  public final void P(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89567);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    if ((this.lgO != null) && (this.lgO.Fcd == d.c.Fbb))
    {
      if (this.FbO != null)
      {
        q localq = this.FbO;
        localq.FbW = paramInt1;
        localq.FbX = paramInt2;
        localq.FbY = paramInt3;
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "resume, newRotation: %s, newFrameWidth: %s, newFrameHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      }
      this.lgO.a(d.c.FaT);
    }
    AppMethodBeat.o(89567);
  }
  
  public final void a(d.a parama)
  {
    this.lhb = parama;
  }
  
  final boolean aZA()
  {
    AppMethodBeat.i(89557);
    long l = Util.currentTicks();
    int i;
    if ((this.FbP != null) && (this.FbQ != null))
    {
      if (com.tencent.mm.compatible.util.d.qV(18))
      {
        this.FbP.quitSafely();
        this.FbQ = null;
      }
    }
    else
    {
      i = this.FbO.frameCount;
      this.lgE = (i * 1000.0F / this.lgD);
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", new Object[] { Integer.valueOf(i), Float.valueOf(this.lgE), Integer.valueOf(this.lgD), this.lgC, Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.lgF), Float.valueOf(this.lgG) });
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "frameCountCallback %s", new Object[] { this.lgW.getValue() });
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "yuvRecorderWriteDataCallback %s", new Object[] { this.lgV.getValue() });
      str = null;
      if (CaptureMMProxy.getInstance() == null) {
        break label381;
      }
      str = CaptureMMProxy.getInstance().getAccVideoPath();
      label210:
      if (Util.isNullOrNil(str)) {
        break label413;
      }
    }
    label413:
    for (String str = com.tencent.mm.plugin.mmsight.d.aPu(str);; str = this.lgC)
    {
      i = this.lgD;
      if (this.lgF > 0) {
        i = this.lgF;
      }
      float f = this.lgE;
      if (this.lgG > 0.0F) {
        f = this.lgG;
      }
      this.lgY = new m(this.bufId, str, f, this.lgL, i, this.lgX.audioSampleRate, this.lhf, false, false);
      l = Util.currentTicks();
      boolean bool = this.lgY.ug(this.lib);
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Boolean.valueOf(bool) });
      if (bool) {
        break label422;
      }
      Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux failed!");
      com.tencent.mm.plugin.mmsight.model.k.eTt();
      AppMethodBeat.o(89557);
      return false;
      this.FbP.quit();
      break;
      label381:
      if (Util.isNullOrNil(this.lgC)) {
        break label210;
      }
      str = new com.tencent.mm.vfs.q(this.lgC).ifB().bOF();
      break label210;
    }
    label422:
    if (((this.lft) && (this.lhV)) || ((!this.lhV) && (!this.lft)) || ((this.lft) && (Math.abs(this.lgP - this.lha) == 0)) || (this.lha == 180))
    {
      l = Util.currentTicks();
      if ((this.lhV) || (this.lft)) {
        break label760;
      }
      i = this.lgP;
    }
    for (;;)
    {
      int j = i;
      if (this.lha == 180)
      {
        j = i;
        if (!this.lhV)
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
        SightVideoJNI.tagRotateVideoVFS(str, this.lgR, j);
        this.lgU = true;
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.lgP), Boolean.valueOf(this.lft), Integer.valueOf(this.lha), Integer.valueOf(j) });
        l = Util.currentTicks();
      }
      try
      {
        u.deleteFile(str);
        u.oo(this.lgR, str);
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "copyFile cost %s", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(89548);
            try
            {
              u.deleteFile(this.lhE);
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
        this.lgO.a(d.c.FaW);
        this.md5 = u.buc(str);
        if ((!Util.isNullOrNil(str)) && (!str.equals(this.lgC)))
        {
          u.oo(str, this.lgC);
          u.deleteFile(str);
        }
        AppMethodBeat.o(89557);
        return true;
      }
      catch (Exception localException)
      {
        label760:
        Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, copy file error");
        AppMethodBeat.o(89557);
      }
      if (this.lhV) {
        i = this.lha;
      } else {
        i = 180;
      }
    }
    return false;
  }
  
  public final String aZC()
  {
    return this.lgT;
  }
  
  public final float aZD()
  {
    return this.lgE;
  }
  
  public final long aZE()
  {
    AppMethodBeat.i(89562);
    if (this.FbO != null)
    {
      long l = this.FbO.aUC();
      AppMethodBeat.o(89562);
      return l;
    }
    AppMethodBeat.o(89562);
    return 0L;
  }
  
  public final d.c aZF()
  {
    return this.lgO.Fcd;
  }
  
  public final int aZG()
  {
    AppMethodBeat.i(89564);
    int i = Math.round(this.lgD / 1000.0F);
    AppMethodBeat.o(89564);
    return i;
  }
  
  public final Point aZH()
  {
    AppMethodBeat.i(89565);
    Point localPoint = new Point(this.lgM, this.lgN);
    AppMethodBeat.o(89565);
    return localPoint;
  }
  
  public final int aZI()
  {
    return this.lgP;
  }
  
  public final boolean aZJ()
  {
    return this.lgZ;
  }
  
  public final com.tencent.mm.audio.b.c.a aZK()
  {
    AppMethodBeat.i(89568);
    if (this.lgH != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.lgH.eTE();
      AppMethodBeat.o(89568);
      return locala;
    }
    AppMethodBeat.o(89568);
    return null;
  }
  
  public final void aZL()
  {
    this.lhe = false;
  }
  
  public final String aZe()
  {
    return this.thumbPath;
  }
  
  public final void av(float paramFloat)
  {
    AppMethodBeat.i(89570);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.lgG = paramFloat;
    AppMethodBeat.o(89570);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(89555);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.lgV.reset();
    this.lgD = 0;
    this.lgW.reset();
    this.lgS = false;
    this.lft = paramBoolean;
    this.lha = paramInt2;
    this.lgO.a(d.c.FaS);
    if (Util.isNullOrNil(this.lgC))
    {
      Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(89555);
      return -1;
    }
    try
    {
      this.mFileName = u.bBW(this.lgC);
      String str2 = u.bBT(this.lgC);
      String str1 = str2;
      if (!str2.endsWith("/")) {
        str1 = str2 + "/";
      }
      this.lgR = (str1 + "tempRotate.mp4");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "retrieve file name error: %s", new Object[] { localException.getMessage() });
        continue;
        this.lgO.a(d.c.Fba);
        continue;
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start yuvRecorder with mute");
        this.FbO.start();
        this.lgO.a(d.c.FaT);
        this.lgZ = false;
        com.tencent.mm.plugin.mmsight.model.k.eTq();
        com.tencent.mm.plugin.mmsight.model.k.aWf();
        paramInt1 = 0;
      }
    }
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", new Object[] { this.lgC, this.lgR });
    this.lgP = paramInt1;
    this.FbP = com.tencent.e.c.d.il("BigSightMediaCodecMP4MuxRecorder_writeYuvData_" + hashCode(), -1);
    this.FbP.start();
    this.FbQ = new MMHandler(this.FbP.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89542);
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "carson：writeYuvData ");
        if (paramAnonymousMessage.what == 1)
        {
          paramAnonymousMessage = (byte[])paramAnonymousMessage.obj;
          if ((paramAnonymousMessage != null) && (n.this.FbO != null)) {
            n.a(n.this, paramAnonymousMessage);
          }
        }
        AppMethodBeat.o(89542);
      }
    };
    if (!this.kfR)
    {
      uv(paramInt1);
      this.kfR = true;
    }
    if ((!this.lhf) && (!this.lhd))
    {
      paramInt1 = this.lgH.a(new c.a()
      {
        public final void aZS()
        {
          AppMethodBeat.i(89543);
          Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "onPcmReady");
          if (n.this.aZF() != d.c.Fba)
          {
            Log.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
            AppMethodBeat.o(89543);
            return;
          }
          n.this.FbO.start();
          n.this.lgO.a(d.c.FaT);
          AppMethodBeat.o(89543);
        }
      });
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start aacRecorder ret: %s", new Object[] { Integer.valueOf(paramInt1) });
      this.lgZ = false;
      if (paramInt1 != 0)
      {
        this.lgO.a(d.c.FaZ);
        com.tencent.mm.plugin.mmsight.model.k.eTq();
        com.tencent.mm.plugin.mmsight.model.k.aWf();
        AppMethodBeat.o(89555);
        return paramInt1;
      }
    }
  }
  
  protected final void bY(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89553);
    if (this.FbO != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramArrayOfByte;
      if (this.FbQ != null) {
        this.FbQ.sendMessage(localMessage);
      }
    }
    AppMethodBeat.o(89553);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(89559);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "cancel record");
    if ((this.FbO == null) || ((this.lgH == null) && (!this.lhf)))
    {
      Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
      AppMethodBeat.o(89559);
      return;
    }
    this.lgO.a(d.c.FaV);
    this.FbO.a(null);
    if (this.lgH != null) {
      this.lgH.a(new c.b()
      {
        public final void aZQ()
        {
          AppMethodBeat.i(89549);
          Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac stop finish");
          AppMethodBeat.o(89549);
        }
      });
    }
    if ((this.FbP != null) && (this.FbQ != null))
    {
      this.FbQ.removeMessages(0);
      this.FbP.quit();
      this.FbQ = null;
    }
    SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
    this.lgO.a(d.c.FaW);
    reset();
    AppMethodBeat.o(89559);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89560);
    try
    {
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "clear");
      if (this.lgH != null) {
        this.lgH.clear();
      }
      if (this.FbO != null) {
        this.FbO.clear();
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
  
  public final void fU(boolean paramBoolean)
  {
    this.lhd = paramBoolean;
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.lgC;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.g getFrameDataCallback()
  {
    return this.lhw;
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
    return this.lft;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89566);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "pause");
    if ((this.lgO != null) && (this.lgO.Fcd == d.c.FaT)) {
      this.lgO.a(d.c.Fbb);
    }
    AppMethodBeat.o(89566);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(89561);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", new Object[] { this.FbO, this.lgH, this.lgY });
    synchronized (this.lgB)
    {
      this.FbO = null;
      this.lgH = null;
      this.lgY = null;
      this.kfR = false;
      this.lgZ = false;
      AppMethodBeat.o(89561);
      return;
    }
  }
  
  public final void setFilePath(String paramString)
  {
    this.lgC = paramString;
  }
  
  public final void setMirror(boolean paramBoolean) {}
  
  public final void setMute(boolean paramBoolean)
  {
    this.lhf = paramBoolean;
  }
  
  public final void u(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(89563);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.lgJ = paramInt3;
    this.lgK = paramInt4;
    this.lgM = paramInt1;
    this.lgN = paramInt2;
    if (j.FbH.k(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = Util.currentTicks();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        j.FbH.as(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    }
    AppMethodBeat.o(89563);
  }
  
  public final boolean uw(int paramInt)
  {
    AppMethodBeat.i(89554);
    if (!this.kfR)
    {
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preInit, cameraOrientation");
      boolean bool = uv(paramInt);
      this.kfR = true;
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
    this.lgF = paramInt;
    AppMethodBeat.o(89569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.n
 * JD-Core Version:    0.7.0.1
 */