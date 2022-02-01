package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.aa;

public final class o
  implements d
{
  protected int bufId;
  protected boolean htU;
  protected Point ilV;
  protected boolean iqo;
  protected float irA;
  private int irB;
  private float irC;
  protected c irD;
  protected int irF;
  protected int irG;
  protected int irH;
  protected int irI;
  protected int irJ;
  protected t irK;
  protected int irL;
  protected String irN;
  protected boolean irO;
  protected String irP;
  protected boolean irQ;
  protected com.tencent.mm.plugin.mmsight.model.c irR;
  protected com.tencent.mm.plugin.mmsight.model.c irS;
  protected VideoTransPara irT;
  protected n irU;
  protected boolean irV;
  protected int irW;
  protected d.a irX;
  protected Runnable irY;
  protected boolean irZ;
  private final Object irx;
  protected String iry;
  protected int irz;
  protected boolean isQ;
  protected boolean isa;
  protected boolean isb;
  protected com.tencent.mm.plugin.mmsight.model.g iss;
  protected String mFileName;
  protected String md5;
  protected String thumbPath;
  protected volatile r zwp;
  protected HandlerThread zwq;
  protected MMHandler zwr;
  protected int zws;
  
  public o(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89551);
    this.irx = new Object();
    this.iry = "";
    this.irz = 0;
    this.irA = 0.0F;
    this.irB = -1;
    this.irC = -1.0F;
    this.irF = 480;
    this.irG = 640;
    this.irH = 1600000;
    this.irI = 480;
    this.irJ = 640;
    this.irN = null;
    this.zws = 0;
    this.isQ = false;
    this.irO = false;
    this.thumbPath = null;
    this.irP = null;
    this.irQ = false;
    this.ilV = null;
    this.irR = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.irS = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.htU = false;
    this.irV = false;
    this.md5 = "";
    this.iqo = false;
    this.irW = 0;
    this.irY = null;
    this.irZ = false;
    this.isa = true;
    this.isb = false;
    this.iss = new com.tencent.mm.plugin.mmsight.model.g()
    {
      public final boolean ai(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(89541);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preview callback data is null");
          AppMethodBeat.o(89541);
          return false;
        }
        if ((o.this.irK.zwJ == d.c.zvu) || (o.this.irK.zwJ == d.c.zvv))
        {
          if (o.this.irK.zwJ == d.c.zvv)
          {
            o.this.irK.zwJ = d.c.zvw;
            Log.v("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "forward one more frame");
          }
          o.this.irS.Hi(1L);
          if (o.this.irD != null) {
            o.this.irD.ejW();
          }
          o.this.bI(paramAnonymousArrayOfByte);
          AppMethodBeat.o(89541);
          return true;
        }
        AppMethodBeat.o(89541);
        return false;
      }
    };
    this.irT = paramVideoTransPara;
    this.irF = paramVideoTransPara.width;
    this.irG = paramVideoTransPara.height;
    this.irH = paramVideoTransPara.videoBitrate;
    l.ekc();
    int i = l.eke();
    if (i == -1) {}
    for (this.irH = paramVideoTransPara.videoBitrate;; this.irH = i)
    {
      this.irK = new t();
      Log.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "create MMSightMediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s", new Object[] { Integer.valueOf(this.irF), Integer.valueOf(this.irG), Integer.valueOf(this.irH) });
      AppMethodBeat.o(89551);
      return;
    }
  }
  
  private boolean rB(int paramInt)
  {
    AppMethodBeat.i(89552);
    long l = Util.currentTicks();
    this.isQ = com.tencent.mm.plugin.mmsight.model.k.zuy.isQ;
    int i = this.irH;
    this.bufId = SightVideoJNI.initDataBufferForMMSightLock(this.irI, this.irJ, paramInt, this.irF, this.irG, this.irT.fps, i, this.irT.iSV, 8, this.irT.iSU, 23.0F, false, false, this.irT.duration, false);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init, bufId: %s", new Object[] { Integer.valueOf(this.bufId) });
    if (this.bufId < 0)
    {
      Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init failed!");
      com.tencent.mm.plugin.mmsight.model.l.ejL();
      AppMethodBeat.o(89552);
      return false;
    }
    this.irL = paramInt;
    this.zwp = new r(this.irI, this.irJ, this.irF, this.irG, this.irH, this.irT.iiH, this.irT.fps, this.isQ);
    int j = this.zwp.ha(this.bufId, paramInt);
    paramInt = 0;
    if (!this.isb)
    {
      i = -1;
      if (CaptureMMProxy.getInstance() != null) {
        i = CaptureMMProxy.getInstance().getInt(ar.a.NZk, -1);
      }
      int k;
      boolean bool;
      if (i < 0)
      {
        paramInt = this.irT.audioSampleRate;
        i = this.irT.audioBitrate;
        k = this.irT.audioChannelCount;
        if (this.irT.iTs == 1) {}
        for (bool = true;; bool = false)
        {
          this.irD = new g(paramInt, i, k, b.ak(false, bool));
          this.irD.rc(this.irZ);
          paramInt = this.irD.H(this.bufId, e.aNv(this.iry));
          if ((j >= 0) && (paramInt >= 0)) {
            break label788;
          }
          Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
          if ((paramInt >= 0) || (j < 0)) {
            break;
          }
          Log.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac init error, try mediarecorder now");
          this.irD.clear();
          this.irD = new i(this.irT.audioSampleRate, this.irT.audioBitrate, this.irT.audioChannelCount);
          this.irD.rc(this.irZ);
          paramInt = this.irD.H(this.bufId, e.aNv(this.iry));
          Log.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[] { Integer.valueOf(paramInt) });
          if (paramInt < 0) {
            break;
          }
          AppMethodBeat.o(89552);
          return true;
        }
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        com.tencent.mm.plugin.mmsight.model.l.ejL();
        AppMethodBeat.o(89552);
        return false;
      }
      if (i == 1)
      {
        paramInt = this.irT.audioSampleRate;
        i = this.irT.audioBitrate;
        k = this.irT.audioChannelCount;
        if (this.irT.iTs == 1)
        {
          bool = true;
          this.irD = new g(paramInt, i, k, b.ak(false, bool));
          this.irD.rc(this.irZ);
          paramInt = this.irD.H(this.bufId, e.aNv(this.iry));
        }
      }
      for (;;)
      {
        if ((j >= 0) && (paramInt >= 0)) {
          break label788;
        }
        Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        com.tencent.mm.plugin.mmsight.model.l.ejL();
        AppMethodBeat.o(89552);
        return false;
        bool = false;
        break;
        if (i == 2)
        {
          this.irD = new i(this.irT.audioSampleRate, this.irT.audioBitrate, this.irT.audioChannelCount);
          this.irD.rc(this.irZ);
          paramInt = this.irD.H(this.bufId, e.aNv(this.iry));
        }
      }
    }
    if (j < 0)
    {
      Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mute init yuv recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(0) });
      SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
      com.tencent.mm.plugin.mmsight.model.l.ejL();
      AppMethodBeat.o(89552);
      return false;
    }
    label788:
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(89552);
    return true;
  }
  
  public final void E(Runnable paramRunnable)
  {
    AppMethodBeat.i(89556);
    this.irY = paramRunnable;
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", new Object[] { paramRunnable });
    if ((this.zwp == null) || ((this.irD == null) && (!this.isb)))
    {
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
      if (paramRunnable != null) {
        MMHandlerThread.postToMainThread(paramRunnable);
      }
      AppMethodBeat.o(89556);
      return;
    }
    if ((this.irK != null) && (this.irK.zwJ == d.c.zvx))
    {
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, already in stop status");
      if (this.irD != null) {
        this.irD.clear();
      }
      if (this.zwp != null) {
        this.zwp.clear();
      }
      if (paramRunnable != null) {
        MMHandlerThread.postToMainThread(paramRunnable);
      }
      AppMethodBeat.o(89556);
      return;
    }
    this.iss = null;
    this.irz = ((int)this.zwp.aMm());
    if (this.irK != null) {
      this.irK.a(d.c.zvv);
    }
    if (this.zwp != null) {
      this.zwp.a(new f.a()
      {
        public final void ejZ()
        {
          AppMethodBeat.i(89544);
          ThreadPool.post(new o.6(o.this), "MMSightMediaCodecMP4MuxRecorder_stop");
          AppMethodBeat.o(89544);
        }
      });
    }
    if (this.irD != null) {
      this.irD.a(new c.b()
      {
        public final void aQX()
        {
          AppMethodBeat.i(89545);
          Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac stop finish");
          AppMethodBeat.o(89545);
        }
      });
    }
    AppMethodBeat.o(89556);
  }
  
  public final void HA(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void HB(String paramString)
  {
    this.irP = paramString;
  }
  
  public final void M(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89567);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    if ((this.irK != null) && (this.irK.zwJ == d.c.zvC))
    {
      if (this.zwp != null)
      {
        r localr = this.zwp;
        localr.zwC = paramInt1;
        localr.zwD = paramInt2;
        localr.zwE = paramInt3;
        Log.i("MicroMsg.MMSightYUVMediaCodecRecorder", "resume, newRotation: %s, newFrameWidth: %s, newFrameHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      }
      this.irK.a(d.c.zvu);
    }
    AppMethodBeat.o(89567);
  }
  
  public final void a(d.a parama)
  {
    this.irX = parama;
  }
  
  final boolean aQI()
  {
    AppMethodBeat.i(89557);
    long l = Util.currentTicks();
    int i;
    if ((this.zwq != null) && (this.zwr != null))
    {
      if (com.tencent.mm.compatible.util.d.oD(18))
      {
        this.zwq.quitSafely();
        this.zwr = null;
      }
    }
    else
    {
      i = this.zwp.frameCount;
      this.irA = (i * 1000.0F / this.irz);
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", new Object[] { Integer.valueOf(i), Float.valueOf(this.irA), Integer.valueOf(this.irz), this.iry, Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.irB), Float.valueOf(this.irC) });
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "frameCountCallback %s", new Object[] { this.irS.getValue() });
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "yuvRecorderWriteDataCallback %s", new Object[] { this.irR.getValue() });
      str = null;
      if (CaptureMMProxy.getInstance() == null) {
        break label377;
      }
      str = CaptureMMProxy.getInstance().getAccVideoPath();
      label210:
      if (Util.isNullOrNil(str)) {
        break label412;
      }
    }
    label412:
    for (String str = com.tencent.mm.plugin.mmsight.d.aFk(str);; str = this.iry)
    {
      i = this.irz;
      if (this.irB > 0) {
        i = this.irB;
      }
      float f = this.irA;
      if (this.irC > 0.0F) {
        f = this.irC;
      }
      this.irU = new n(this.bufId, str, f, this.irH, i, this.irT.audioSampleRate, this.isb, false, false);
      l = Util.currentTicks();
      boolean bool = this.irU.ejY();
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Boolean.valueOf(bool) });
      if (bool) {
        break label421;
      }
      Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux failed!");
      com.tencent.mm.plugin.mmsight.model.l.ejM();
      AppMethodBeat.o(89557);
      return false;
      this.zwq.quit();
      break;
      label377:
      if (Util.isNullOrNil(this.iry)) {
        break label210;
      }
      str = aa.z(new com.tencent.mm.vfs.o(this.iry).heq().her());
      break label210;
    }
    label421:
    if (((this.iqo) && (this.isQ)) || ((!this.isQ) && (!this.iqo)) || ((this.iqo) && (Math.abs(this.irL - this.irW) == 0)) || (this.irW == 180))
    {
      l = Util.currentTicks();
      if ((this.isQ) || (this.iqo)) {
        break label759;
      }
      i = this.irL;
    }
    for (;;)
    {
      int j = i;
      if (this.irW == 180)
      {
        j = i;
        if (!this.isQ)
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
        SightVideoJNI.tagRotateVideoVFS(str, this.irN, j);
        this.irQ = true;
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.irL), Boolean.valueOf(this.iqo), Integer.valueOf(this.irW), Integer.valueOf(j) });
        l = Util.currentTicks();
      }
      try
      {
        com.tencent.mm.vfs.s.deleteFile(str);
        com.tencent.mm.vfs.s.nx(this.irN, str);
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "copyFile cost %s", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(89548);
            try
            {
              com.tencent.mm.vfs.s.deleteFile(this.isA);
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
        this.irK.a(d.c.zvx);
        this.md5 = com.tencent.mm.vfs.s.bhK(str);
        if ((!Util.isNullOrNil(str)) && (!str.equals(this.iry)))
        {
          com.tencent.mm.vfs.s.nx(str, this.iry);
          com.tencent.mm.vfs.s.deleteFile(str);
        }
        AppMethodBeat.o(89557);
        return true;
      }
      catch (Exception localException)
      {
        label759:
        Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, copy file error");
        AppMethodBeat.o(89557);
      }
      if (this.isQ) {
        i = this.irW;
      } else {
        i = 180;
      }
    }
    return false;
  }
  
  public final String aQK()
  {
    return this.irP;
  }
  
  public final float aQL()
  {
    return this.irA;
  }
  
  public final long aQM()
  {
    AppMethodBeat.i(89562);
    if (this.zwp != null)
    {
      long l = this.zwp.aMm();
      AppMethodBeat.o(89562);
      return l;
    }
    AppMethodBeat.o(89562);
    return 0L;
  }
  
  public final d.c aQN()
  {
    return this.irK.zwJ;
  }
  
  public final int aQO()
  {
    AppMethodBeat.i(89564);
    int i = Math.round(this.irz / 1000.0F);
    AppMethodBeat.o(89564);
    return i;
  }
  
  public final Point aQP()
  {
    AppMethodBeat.i(89565);
    Point localPoint = new Point(this.irI, this.irJ);
    AppMethodBeat.o(89565);
    return localPoint;
  }
  
  public final int aQQ()
  {
    return this.irL;
  }
  
  public final boolean aQR()
  {
    return this.irV;
  }
  
  public final com.tencent.mm.audio.b.c.a aQS()
  {
    AppMethodBeat.i(89568);
    if (this.irD != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.irD.ejX();
      AppMethodBeat.o(89568);
      return locala;
    }
    AppMethodBeat.o(89568);
    return null;
  }
  
  public final void aQT()
  {
    this.isa = false;
  }
  
  public final String aQn()
  {
    return this.thumbPath;
  }
  
  public final void av(float paramFloat)
  {
    AppMethodBeat.i(89570);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.irC = paramFloat;
    AppMethodBeat.o(89570);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(89555);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.irR.reset();
    this.irz = 0;
    this.irS.reset();
    this.irO = false;
    this.iqo = paramBoolean;
    this.irW = paramInt2;
    this.irK.a(d.c.zvt);
    if (Util.isNullOrNil(this.iry))
    {
      Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(89555);
      return -1;
    }
    try
    {
      this.mFileName = com.tencent.mm.vfs.s.bpb(this.iry);
      String str2 = com.tencent.mm.vfs.s.boZ(this.iry);
      String str1 = str2;
      if (!str2.endsWith("/")) {
        str1 = str2 + "/";
      }
      this.irN = (str1 + "tempRotate.mp4");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "retrieve file name error: %s", new Object[] { localException.getMessage() });
        continue;
        this.irK.a(d.c.zvB);
        continue;
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start yuvRecorder with mute");
        this.zwp.start();
        this.irK.a(d.c.zvu);
        this.irV = false;
        com.tencent.mm.plugin.mmsight.model.l.ejJ();
        com.tencent.mm.plugin.mmsight.model.l.aNB();
        paramInt1 = 0;
      }
    }
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", new Object[] { this.iry, this.irN });
    this.irL = paramInt1;
    this.zwq = com.tencent.f.c.d.hB("BigSightMediaCodecMP4MuxRecorder_writeYuvData_" + hashCode(), -1);
    this.zwq.start();
    this.zwr = new MMHandler(this.zwq.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89542);
        Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "carson：writeYuvData ");
        if (paramAnonymousMessage.what == 1)
        {
          paramAnonymousMessage = (byte[])paramAnonymousMessage.obj;
          if ((paramAnonymousMessage != null) && (o.this.zwp != null)) {
            o.a(o.this, paramAnonymousMessage);
          }
        }
        AppMethodBeat.o(89542);
      }
    };
    if (!this.htU)
    {
      rB(paramInt1);
      this.htU = true;
    }
    if ((!this.isb) && (!this.irZ))
    {
      paramInt1 = this.irD.a(new c.a()
      {
        public final void aQY()
        {
          AppMethodBeat.i(89543);
          Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "onPcmReady");
          if (o.this.aQN() != d.c.zvB)
          {
            Log.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
            AppMethodBeat.o(89543);
            return;
          }
          o.this.zwp.start();
          o.this.irK.a(d.c.zvu);
          AppMethodBeat.o(89543);
        }
      });
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start aacRecorder ret: %s", new Object[] { Integer.valueOf(paramInt1) });
      this.irV = false;
      if (paramInt1 != 0)
      {
        this.irK.a(d.c.zvA);
        com.tencent.mm.plugin.mmsight.model.l.ejJ();
        com.tencent.mm.plugin.mmsight.model.l.aNB();
        AppMethodBeat.o(89555);
        return paramInt1;
      }
    }
  }
  
  protected final void bI(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89553);
    if (this.zwp != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramArrayOfByte;
      if (this.zwr != null) {
        this.zwr.sendMessage(localMessage);
      }
    }
    AppMethodBeat.o(89553);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(89559);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "cancel record");
    if ((this.zwp == null) || ((this.irD == null) && (!this.isb)))
    {
      Log.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
      AppMethodBeat.o(89559);
      return;
    }
    this.irK.a(d.c.zvw);
    this.zwp.a(null);
    if (this.irD != null) {
      this.irD.a(new c.b()
      {
        public final void aQX()
        {
          AppMethodBeat.i(89549);
          Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac stop finish");
          AppMethodBeat.o(89549);
        }
      });
    }
    if ((this.zwq != null) && (this.zwr != null))
    {
      this.zwr.removeMessages(0);
      this.zwq.quit();
      this.zwr = null;
    }
    SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
    this.irK.a(d.c.zvx);
    reset();
    AppMethodBeat.o(89559);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89560);
    try
    {
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "clear");
      if (this.irD != null) {
        this.irD.clear();
      }
      if (this.zwp != null) {
        this.zwp.clear();
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
  
  public final void fk(boolean paramBoolean)
  {
    this.irZ = paramBoolean;
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.iry;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.g getFrameDataCallback()
  {
    return this.iss;
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
    return this.iqo;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89566);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "pause");
    if ((this.irK != null) && (this.irK.zwJ == d.c.zvu)) {
      this.irK.a(d.c.zvC);
    }
    AppMethodBeat.o(89566);
  }
  
  public final boolean rC(int paramInt)
  {
    AppMethodBeat.i(89554);
    if (!this.htU)
    {
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preInit, cameraOrientation");
      boolean bool = rB(paramInt);
      this.htU = true;
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(89554);
      return bool;
    }
    AppMethodBeat.o(89554);
    return true;
  }
  
  public final void rD(int paramInt)
  {
    AppMethodBeat.i(89569);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.irB = paramInt;
    AppMethodBeat.o(89569);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(89561);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", new Object[] { this.zwp, this.irD, this.irU });
    synchronized (this.irx)
    {
      this.zwp = null;
      this.irD = null;
      this.irU = null;
      this.htU = false;
      this.irV = false;
      AppMethodBeat.o(89561);
      return;
    }
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(89563);
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.irF = paramInt3;
    this.irG = paramInt4;
    this.irI = paramInt1;
    this.irJ = paramInt2;
    if (k.zwi.h(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = Util.currentTicks();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        k.zwi.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      Log.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    }
    AppMethodBeat.o(89563);
  }
  
  public final void setFilePath(String paramString)
  {
    this.iry = paramString;
  }
  
  public final void setMirror(boolean paramBoolean) {}
  
  public final void setMute(boolean paramBoolean)
  {
    this.isb = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.o
 * JD-Core Version:    0.7.0.1
 */