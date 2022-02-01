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
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vfs.w;

public final class o
  implements d
{
  protected int bufId;
  protected boolean gHg;
  protected Point hsE;
  protected boolean hwM;
  protected String hxA;
  protected int hxB;
  protected float hxC;
  private int hxD;
  private float hxE;
  protected c hxF;
  protected int hxH;
  protected int hxI;
  protected int hxJ;
  protected int hxK;
  protected int hxL;
  protected t hxM;
  protected int hxN;
  protected String hxP;
  protected boolean hxQ;
  protected String hxR;
  protected boolean hxS;
  protected com.tencent.mm.plugin.mmsight.model.c hxT;
  protected com.tencent.mm.plugin.mmsight.model.c hxU;
  protected VideoTransPara hxV;
  protected n hxW;
  protected boolean hxX;
  protected int hxY;
  protected d.a hxZ;
  private final Object hxz;
  protected boolean hyP;
  protected Runnable hya;
  protected boolean hyb;
  protected boolean hyc;
  protected boolean hyd;
  protected com.tencent.mm.plugin.mmsight.model.g hyr;
  protected String mFileName;
  protected String md5;
  protected String thumbPath;
  protected volatile r wcn;
  protected HandlerThread wco;
  protected aq wcp;
  protected int wcq;
  
  public o(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89551);
    this.hxz = new Object();
    this.hxA = "";
    this.hxB = 0;
    this.hxC = 0.0F;
    this.hxD = -1;
    this.hxE = -1.0F;
    this.hxH = 480;
    this.hxI = 640;
    this.hxJ = 1600000;
    this.hxK = 480;
    this.hxL = 640;
    this.hxP = null;
    this.wcq = 0;
    this.hyP = false;
    this.hxQ = false;
    this.thumbPath = null;
    this.hxR = null;
    this.hxS = false;
    this.hsE = null;
    this.hxT = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.hxU = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.gHg = false;
    this.hxX = false;
    this.md5 = "";
    this.hwM = false;
    this.hxY = 0;
    this.hya = null;
    this.hyb = false;
    this.hyc = true;
    this.hyd = false;
    this.hyr = new com.tencent.mm.plugin.mmsight.model.g()
    {
      public final boolean U(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(89541);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          ae.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preview callback data is null");
          AppMethodBeat.o(89541);
          return false;
        }
        if ((o.this.hxM.wcI == d.c.wbs) || (o.this.hxM.wcI == d.c.wbt))
        {
          if (o.this.hxM.wcI == d.c.wbt)
          {
            o.this.hxM.wcI = d.c.wbu;
            ae.v("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "forward one more frame");
          }
          o.this.hxU.yz(1L);
          if (o.this.hxF != null) {
            o.this.hxF.dqg();
          }
          o.this.br(paramAnonymousArrayOfByte);
          AppMethodBeat.o(89541);
          return true;
        }
        AppMethodBeat.o(89541);
        return false;
      }
    };
    this.hxV = paramVideoTransPara;
    this.hxH = paramVideoTransPara.width;
    this.hxI = paramVideoTransPara.height;
    this.hxJ = paramVideoTransPara.videoBitrate;
    l.dqm();
    int i = l.dqo();
    if (i == -1) {}
    for (this.hxJ = paramVideoTransPara.videoBitrate;; this.hxJ = i)
    {
      this.hxM = new t();
      ae.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "create MMSightMediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s", new Object[] { Integer.valueOf(this.hxH), Integer.valueOf(this.hxI), Integer.valueOf(this.hxJ) });
      AppMethodBeat.o(89551);
      return;
    }
  }
  
  private boolean of(int paramInt)
  {
    AppMethodBeat.i(89552);
    long l = bu.HQ();
    this.hyP = com.tencent.mm.plugin.mmsight.model.k.wat.hyP;
    int i = this.hxJ;
    this.bufId = SightVideoJNI.initDataBufferForMMSightLock(this.hxK, this.hxL, paramInt, this.hxH, this.hxI, this.hxV.fps, i, this.hxV.hXX, 8, this.hxV.hXW, 23.0F, false, false, this.hxV.duration, false);
    ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init, bufId: %s", new Object[] { Integer.valueOf(this.bufId) });
    if (this.bufId < 0)
    {
      ae.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init failed!");
      com.tencent.mm.plugin.mmsight.model.l.dpW();
      AppMethodBeat.o(89552);
      return false;
    }
    this.hxN = paramInt;
    this.wcn = new r(this.hxK, this.hxL, this.hxH, this.hxI, this.hxJ, this.hxV.hpl, this.hxV.fps, this.hyP);
    int j = this.wcn.gz(this.bufId, paramInt);
    paramInt = 0;
    if (!this.hyd)
    {
      i = -1;
      if (CaptureMMProxy.getInstance() != null) {
        i = CaptureMMProxy.getInstance().getInt(am.a.IRi, -1);
      }
      int k;
      boolean bool;
      if (i < 0)
      {
        paramInt = this.hxV.audioSampleRate;
        i = this.hxV.audioBitrate;
        k = this.hxV.audioChannelCount;
        if (this.hxV.hYu == 1) {}
        for (bool = true;; bool = false)
        {
          this.hxF = new g(paramInt, i, k, com.tencent.mm.plugin.sight.base.b.af(false, bool));
          this.hxF.ox(this.hyb);
          paramInt = this.hxF.E(this.bufId, e.ayL(this.hxA));
          if ((j >= 0) && (paramInt >= 0)) {
            break label788;
          }
          ae.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
          if ((paramInt >= 0) || (j < 0)) {
            break;
          }
          ae.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac init error, try mediarecorder now");
          this.hxF.clear();
          this.hxF = new i(this.hxV.audioSampleRate, this.hxV.audioBitrate, this.hxV.audioChannelCount);
          this.hxF.ox(this.hyb);
          paramInt = this.hxF.E(this.bufId, e.ayL(this.hxA));
          ae.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[] { Integer.valueOf(paramInt) });
          if (paramInt < 0) {
            break;
          }
          AppMethodBeat.o(89552);
          return true;
        }
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        com.tencent.mm.plugin.mmsight.model.l.dpW();
        AppMethodBeat.o(89552);
        return false;
      }
      if (i == 1)
      {
        paramInt = this.hxV.audioSampleRate;
        i = this.hxV.audioBitrate;
        k = this.hxV.audioChannelCount;
        if (this.hxV.hYu == 1)
        {
          bool = true;
          this.hxF = new g(paramInt, i, k, com.tencent.mm.plugin.sight.base.b.af(false, bool));
          this.hxF.ox(this.hyb);
          paramInt = this.hxF.E(this.bufId, e.ayL(this.hxA));
        }
      }
      for (;;)
      {
        if ((j >= 0) && (paramInt >= 0)) {
          break label788;
        }
        ae.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        com.tencent.mm.plugin.mmsight.model.l.dpW();
        AppMethodBeat.o(89552);
        return false;
        bool = false;
        break;
        if (i == 2)
        {
          this.hxF = new i(this.hxV.audioSampleRate, this.hxV.audioBitrate, this.hxV.audioChannelCount);
          this.hxF.ox(this.hyb);
          paramInt = this.hxF.E(this.bufId, e.ayL(this.hxA));
        }
      }
    }
    if (j < 0)
    {
      ae.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mute init yuv recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(0) });
      SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
      com.tencent.mm.plugin.mmsight.model.l.dpW();
      AppMethodBeat.o(89552);
      return false;
    }
    label788:
    ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
    AppMethodBeat.o(89552);
    return true;
  }
  
  public final void B(Runnable paramRunnable)
  {
    AppMethodBeat.i(89556);
    this.hya = paramRunnable;
    ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", new Object[] { paramRunnable });
    if ((this.wcn == null) || ((this.hxF == null) && (!this.hyd)))
    {
      ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
      if (paramRunnable != null) {
        ar.f(paramRunnable);
      }
      AppMethodBeat.o(89556);
      return;
    }
    if ((this.hxM != null) && (this.hxM.wcI == d.c.wbv))
    {
      ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, already in stop status");
      if (this.hxF != null) {
        this.hxF.clear();
      }
      if (this.wcn != null) {
        this.wcn.clear();
      }
      if (paramRunnable != null) {
        ar.f(paramRunnable);
      }
      AppMethodBeat.o(89556);
      return;
    }
    this.hyr = null;
    this.hxB = ((int)this.wcn.atL());
    if (this.hxM != null) {
      this.hxM.a(d.c.wbt);
    }
    if (this.wcn != null) {
      this.wcn.a(new f.a()
      {
        public final void dqj()
        {
          AppMethodBeat.i(89544);
          com.tencent.mm.sdk.g.b.c(new o.6(o.this), "MMSightMediaCodecMP4MuxRecorder_stop");
          AppMethodBeat.o(89544);
        }
      });
    }
    if (this.hxF != null) {
      this.hxF.a(new o.5(this));
    }
    AppMethodBeat.o(89556);
  }
  
  public final void L(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89567);
    ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    if ((this.hxM != null) && (this.hxM.wcI == d.c.wbA))
    {
      if (this.wcn != null)
      {
        r localr = this.wcn;
        localr.wcB = paramInt1;
        localr.wcC = paramInt2;
        localr.wcD = paramInt3;
        ae.i("MicroMsg.MMSightYUVMediaCodecRecorder", "resume, newRotation: %s, newFrameWidth: %s, newFrameHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      }
      this.hxM.a(d.c.wbs);
    }
    AppMethodBeat.o(89567);
  }
  
  public final String Lj()
  {
    AppMethodBeat.i(89558);
    String str = bu.bI(this.md5, "");
    AppMethodBeat.o(89558);
    return str;
  }
  
  public final void a(d.a parama)
  {
    this.hxZ = parama;
  }
  
  public final void am(float paramFloat)
  {
    AppMethodBeat.i(89570);
    ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.hxE = paramFloat;
    AppMethodBeat.o(89570);
  }
  
  public final boolean aoA()
  {
    return this.hwM;
  }
  
  public final String axP()
  {
    return this.thumbPath;
  }
  
  final boolean aye()
  {
    AppMethodBeat.i(89557);
    long l = bu.HQ();
    int i;
    if ((this.wco != null) && (this.wcp != null))
    {
      if (com.tencent.mm.compatible.util.d.lA(18))
      {
        this.wco.quitSafely();
        this.wcp = null;
      }
    }
    else
    {
      i = this.wcn.frameCount;
      this.hxC = (i * 1000.0F / this.hxB);
      ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", new Object[] { Integer.valueOf(i), Float.valueOf(this.hxC), Integer.valueOf(this.hxB), this.hxA, Long.valueOf(bu.aO(l)), Integer.valueOf(this.hxD), Float.valueOf(this.hxE) });
      ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "frameCountCallback %s", new Object[] { this.hxU.getValue() });
      ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "yuvRecorderWriteDataCallback %s", new Object[] { this.hxT.getValue() });
      str = null;
      if (CaptureMMProxy.getInstance() == null) {
        break label377;
      }
      str = CaptureMMProxy.getInstance().getAccVideoPath();
      label210:
      if (bu.isNullOrNil(str)) {
        break label412;
      }
    }
    label412:
    for (String str = com.tencent.mm.plugin.mmsight.d.arP(str);; str = this.hxA)
    {
      i = this.hxB;
      if (this.hxD > 0) {
        i = this.hxD;
      }
      float f = this.hxC;
      if (this.hxE > 0.0F) {
        f = this.hxE;
      }
      this.hxW = new n(this.bufId, str, f, this.hxJ, i, this.hxV.audioSampleRate, this.hyd, false, false);
      l = bu.HQ();
      boolean bool = this.hxW.dqi();
      ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(bu.aO(l)), Boolean.valueOf(bool) });
      if (bool) {
        break label421;
      }
      ae.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux failed!");
      com.tencent.mm.plugin.mmsight.model.l.dpX();
      AppMethodBeat.o(89557);
      return false;
      this.wco.quit();
      break;
      label377:
      if (bu.isNullOrNil(this.hxA)) {
        break label210;
      }
      str = w.B(new com.tencent.mm.vfs.k(this.hxA).fTg().fTh());
      break label210;
    }
    label421:
    if (((this.hwM) && (this.hyP)) || ((!this.hyP) && (!this.hwM)) || ((this.hwM) && (Math.abs(this.hxN - this.hxY) == 0)) || (this.hxY == 180))
    {
      l = bu.HQ();
      if ((this.hyP) || (this.hwM)) {
        break label759;
      }
      i = this.hxN;
    }
    for (;;)
    {
      int j = i;
      if (this.hxY == 180)
      {
        j = i;
        if (!this.hyP)
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
        SightVideoJNI.tagRotateVideoVFS(str, this.hxP, j);
        this.hxS = true;
        ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(bu.aO(l)), Integer.valueOf(this.hxN), Boolean.valueOf(this.hwM), Integer.valueOf(this.hxY), Integer.valueOf(j) });
        l = bu.HQ();
      }
      try
      {
        com.tencent.mm.vfs.o.deleteFile(str);
        com.tencent.mm.vfs.o.mG(this.hxP, str);
        ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "copyFile cost %s", new Object[] { Long.valueOf(bu.aO(l)) });
        com.tencent.mm.sdk.g.b.c(new o.7(this, this.hxP), "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        this.hxM.a(d.c.wbv);
        this.md5 = com.tencent.mm.vfs.o.aRh(str);
        if ((!bu.isNullOrNil(str)) && (!str.equals(this.hxA)))
        {
          com.tencent.mm.vfs.o.mG(str, this.hxA);
          com.tencent.mm.vfs.o.deleteFile(str);
        }
        AppMethodBeat.o(89557);
        return true;
      }
      catch (Exception localException)
      {
        label759:
        ae.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, copy file error");
        AppMethodBeat.o(89557);
      }
      if (this.hyP) {
        i = this.hxY;
      } else {
        i = 180;
      }
    }
    return false;
  }
  
  public final String ayg()
  {
    return this.hxR;
  }
  
  public final float ayh()
  {
    return this.hxC;
  }
  
  public final long ayi()
  {
    AppMethodBeat.i(89562);
    if (this.wcn != null)
    {
      long l = this.wcn.atL();
      AppMethodBeat.o(89562);
      return l;
    }
    AppMethodBeat.o(89562);
    return 0L;
  }
  
  public final d.c ayj()
  {
    return this.hxM.wcI;
  }
  
  public final int ayk()
  {
    AppMethodBeat.i(89564);
    int i = Math.round(this.hxB / 1000.0F);
    AppMethodBeat.o(89564);
    return i;
  }
  
  public final Point ayl()
  {
    AppMethodBeat.i(89565);
    Point localPoint = new Point(this.hxK, this.hxL);
    AppMethodBeat.o(89565);
    return localPoint;
  }
  
  public final int aym()
  {
    return this.hxN;
  }
  
  public final boolean ayn()
  {
    return this.hxX;
  }
  
  public final com.tencent.mm.audio.b.c.a ayo()
  {
    AppMethodBeat.i(89568);
    if (this.hxF != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.hxF.dqh();
      AppMethodBeat.o(89568);
      return locala;
    }
    AppMethodBeat.o(89568);
    return null;
  }
  
  public final void ayp()
  {
    this.hyc = false;
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(89555);
    ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.hxT.reset();
    this.hxB = 0;
    this.hxU.reset();
    this.hxQ = false;
    this.hwM = paramBoolean;
    this.hxY = paramInt2;
    this.hxM.a(d.c.wbr);
    if (bu.isNullOrNil(this.hxA))
    {
      ae.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(89555);
      return -1;
    }
    try
    {
      this.mFileName = com.tencent.mm.vfs.o.aZW(this.hxA);
      String str2 = com.tencent.mm.vfs.o.aZU(this.hxA);
      String str1 = str2;
      if (!str2.endsWith("/")) {
        str1 = str2 + "/";
      }
      this.hxP = (str1 + "tempRotate.mp4");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "retrieve file name error: %s", new Object[] { localException.getMessage() });
        continue;
        this.hxM.a(d.c.wbz);
        continue;
        ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start yuvRecorder with mute");
        this.wcn.start();
        this.hxM.a(d.c.wbs);
        this.hxX = false;
        com.tencent.mm.plugin.mmsight.model.l.dpU();
        com.tencent.mm.plugin.mmsight.model.l.auO();
        paramInt1 = 0;
      }
    }
    ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", new Object[] { this.hxA, this.hxP });
    this.hxN = paramInt1;
    this.wco = com.tencent.e.c.d.hh("BigSightMediaCodecMP4MuxRecorder_writeYuvData_" + hashCode(), -1);
    this.wco.start();
    this.wcp = new aq(this.wco.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89542);
        ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "carson：writeYuvData ");
        if (paramAnonymousMessage.what == 1)
        {
          paramAnonymousMessage = (byte[])paramAnonymousMessage.obj;
          if ((paramAnonymousMessage != null) && (o.this.wcn != null)) {
            o.a(o.this, paramAnonymousMessage);
          }
        }
        AppMethodBeat.o(89542);
      }
    };
    if (!this.gHg)
    {
      of(paramInt1);
      this.gHg = true;
    }
    if ((!this.hyd) && (!this.hyb))
    {
      paramInt1 = this.hxF.a(new c.a()
      {
        public final void ayu()
        {
          AppMethodBeat.i(89543);
          ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "onPcmReady");
          if (o.this.ayj() != d.c.wbz)
          {
            ae.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
            AppMethodBeat.o(89543);
            return;
          }
          o.this.wcn.start();
          o.this.hxM.a(d.c.wbs);
          AppMethodBeat.o(89543);
        }
      });
      ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start aacRecorder ret: %s", new Object[] { Integer.valueOf(paramInt1) });
      this.hxX = false;
      if (paramInt1 != 0)
      {
        this.hxM.a(d.c.wby);
        com.tencent.mm.plugin.mmsight.model.l.dpU();
        com.tencent.mm.plugin.mmsight.model.l.auO();
        AppMethodBeat.o(89555);
        return paramInt1;
      }
    }
  }
  
  protected final void br(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89553);
    if (this.wcn != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramArrayOfByte;
      if (this.wcp != null) {
        this.wcp.sendMessage(localMessage);
      }
    }
    AppMethodBeat.o(89553);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(89559);
    ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "cancel record");
    if ((this.wcn == null) || ((this.hxF == null) && (!this.hyd)))
    {
      ae.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
      AppMethodBeat.o(89559);
      return;
    }
    this.hxM.a(d.c.wbu);
    this.wcn.a(null);
    if (this.hxF != null) {
      this.hxF.a(new o.8(this));
    }
    if ((this.wco != null) && (this.wcp != null))
    {
      this.wcp.removeMessages(0);
      this.wco.quit();
      this.wcp = null;
    }
    SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
    this.hxM.a(d.c.wbv);
    reset();
    AppMethodBeat.o(89559);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89560);
    try
    {
      ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "clear");
      if (this.hxF != null) {
        this.hxF.clear();
      }
      if (this.wcn != null) {
        this.wcn.clear();
      }
      AppMethodBeat.o(89560);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.MMSightMediaCodecMP4MuxRecorder", localException, "clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89560);
    }
  }
  
  public final void eu(boolean paramBoolean)
  {
    this.hyb = paramBoolean;
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.hxA;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.g getFrameDataCallback()
  {
    return this.hyr;
  }
  
  public final boolean og(int paramInt)
  {
    AppMethodBeat.i(89554);
    if (!this.gHg)
    {
      ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preInit, cameraOrientation");
      boolean bool = of(paramInt);
      this.gHg = true;
      ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(89554);
      return bool;
    }
    AppMethodBeat.o(89554);
    return true;
  }
  
  public final void oh(int paramInt)
  {
    AppMethodBeat.i(89569);
    ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.hxD = paramInt;
    AppMethodBeat.o(89569);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89566);
    ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "pause");
    if ((this.hxM != null) && (this.hxM.wcI == d.c.wbs)) {
      this.hxM.a(d.c.wbA);
    }
    AppMethodBeat.o(89566);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(89561);
    ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", new Object[] { this.wcn, this.hxF, this.hxW });
    synchronized (this.hxz)
    {
      this.wcn = null;
      this.hxF = null;
      this.hxW = null;
      this.gHg = false;
      this.hxX = false;
      AppMethodBeat.o(89561);
      return;
    }
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(89563);
    ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.hxH = paramInt3;
    this.hxI = paramInt4;
    this.hxK = paramInt1;
    this.hxL = paramInt2;
    if (k.wcg.h(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = bu.HQ();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        k.wcg.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      ae.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
    }
    AppMethodBeat.o(89563);
  }
  
  public final void setFilePath(String paramString)
  {
    this.hxA = paramString;
  }
  
  public final void setMirror(boolean paramBoolean) {}
  
  public final void setMute(boolean paramBoolean)
  {
    this.hyd = paramBoolean;
  }
  
  public final void yY(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void yZ(String paramString)
  {
    this.hxR = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.o
 * JD-Core Version:    0.7.0.1
 */