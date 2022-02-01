package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.plugin.mmsight.model.p;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ae.a;

public final class n
  implements d
{
  protected boolean gBu;
  protected com.tencent.mm.plugin.mmsight.model.c gCA;
  protected VideoTransPara gCB;
  protected m gCC;
  protected boolean gCD;
  protected int gCE;
  protected d.a gCF;
  protected Runnable gCG;
  protected boolean gCH;
  protected boolean gCI;
  protected boolean gCJ;
  protected com.tencent.mm.plugin.mmsight.model.g gCW;
  private final Object gCf;
  protected String gCg;
  protected int gCh;
  protected float gCi;
  private int gCj;
  private float gCk;
  protected c gCl;
  protected int gCn;
  protected int gCo;
  protected int gCp;
  protected int gCq;
  protected int gCr;
  protected s gCs;
  protected int gCt;
  protected String gCv;
  protected boolean gCw;
  protected String gCx;
  protected boolean gCy;
  protected com.tencent.mm.plugin.mmsight.model.c gCz;
  protected boolean gDs;
  protected boolean ggj;
  protected int gmW;
  protected Point gxn;
  protected String mFileName;
  protected String md5;
  protected volatile q tEH;
  protected HandlerThread tEI;
  protected ap tEJ;
  protected int tEK;
  protected String thumbPath;
  
  public n(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89551);
    this.gCf = new Object();
    this.gCg = "";
    this.gCh = 0;
    this.gCi = 0.0F;
    this.gCj = -1;
    this.gCk = -1.0F;
    this.gCn = 480;
    this.gCo = 640;
    this.gCp = 1600000;
    this.gCq = 480;
    this.gCr = 640;
    this.gCv = null;
    this.tEK = 0;
    this.gDs = false;
    this.gCw = false;
    this.thumbPath = null;
    this.gCx = null;
    this.gCy = false;
    this.gxn = null;
    this.gCz = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.gCA = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.ggj = false;
    this.gCD = false;
    this.md5 = "";
    this.gBu = false;
    this.gCE = 0;
    this.gCG = null;
    this.gCH = false;
    this.gCI = true;
    this.gCJ = false;
    this.gCW = new com.tencent.mm.plugin.mmsight.model.g()
    {
      public final boolean W(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(89541);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          ad.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preview callback data is null");
          AppMethodBeat.o(89541);
          return false;
        }
        if ((n.this.gCs.tFa == d.c.tDO) || (n.this.gCs.tFa == d.c.tDP))
        {
          if (n.this.gCs.tFa == d.c.tDP)
          {
            n.this.gCs.tFa = d.c.tDQ;
            ad.v("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "forward one more frame");
          }
          n.this.gCA.rt(1L);
          if (n.this.gCl != null) {
            n.this.gCl.cQe();
          }
          n.this.bq(paramAnonymousArrayOfByte);
          AppMethodBeat.o(89541);
          return true;
        }
        AppMethodBeat.o(89541);
        return false;
      }
    };
    this.gCB = paramVideoTransPara;
    this.gCn = paramVideoTransPara.width;
    this.gCo = paramVideoTransPara.height;
    this.gCp = paramVideoTransPara.videoBitrate;
    k.cQk();
    int i = k.cQm();
    if (i == -1) {}
    for (this.gCp = paramVideoTransPara.videoBitrate;; this.gCp = i)
    {
      this.gCs = new s();
      ad.d("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "create MMSightMediaCodecMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s", new Object[] { Integer.valueOf(this.gCn), Integer.valueOf(this.gCo), Integer.valueOf(this.gCp) });
      AppMethodBeat.o(89551);
      return;
    }
  }
  
  private boolean mP(int paramInt)
  {
    AppMethodBeat.i(89552);
    long l = bt.GC();
    this.gDs = com.tencent.mm.plugin.mmsight.model.k.tCN.gDs;
    int i = this.gCp;
    this.gmW = SightVideoJNI.initDataBufferForMMSightLock(this.gCq, this.gCr, paramInt, this.gCn, this.gCo, this.gCB.fps, i, this.gCB.hbY, 8, this.gCB.hbX, 23.0F, false, false, this.gCB.duration, false);
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init, bufId: %s", new Object[] { Integer.valueOf(this.gmW) });
    if (this.gmW < 0)
    {
      ad.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init failed!");
      l.cPU();
      AppMethodBeat.o(89552);
      return false;
    }
    this.gCt = paramInt;
    this.tEH = new q(this.gCq, this.gCr, this.gCn, this.gCo, this.gCp, this.gCB.hbW, this.gCB.fps, this.gDs);
    int j = this.tEH.gb(this.gmW, paramInt);
    paramInt = 0;
    if (!this.gCJ)
    {
      i = -1;
      if (CaptureMMProxy.getInstance() != null) {
        i = CaptureMMProxy.getInstance().getInt(ae.a.FmD, -1);
      }
      int k;
      boolean bool;
      if (i < 0)
      {
        paramInt = this.gCB.audioSampleRate;
        i = this.gCB.audioBitrate;
        k = this.gCB.gnH;
        if (this.gCB.hcu == 1) {}
        for (bool = true;; bool = false)
        {
          this.gCl = new g(paramInt, i, k, com.tencent.mm.plugin.sight.base.b.Z(false, bool));
          this.gCl.nf(this.gCH);
          paramInt = this.gCl.D(this.gmW, com.tencent.mm.plugin.sight.base.e.anm(this.gCg));
          if ((j >= 0) && (paramInt >= 0)) {
            break label788;
          }
          ad.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
          if ((paramInt >= 0) || (j < 0)) {
            break;
          }
          ad.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac init error, try mediarecorder now");
          this.gCl.clear();
          this.gCl = new i(this.gCB.audioSampleRate, this.gCB.audioBitrate, this.gCB.gnH);
          this.gCl.nf(this.gCH);
          paramInt = this.gCl.D(this.gmW, com.tencent.mm.plugin.sight.base.e.anm(this.gCg));
          ad.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[] { Integer.valueOf(paramInt) });
          if (paramInt < 0) {
            break;
          }
          AppMethodBeat.o(89552);
          return true;
        }
        SightVideoJNI.releaseBigSightDataBufferLock(this.gmW);
        l.cPU();
        AppMethodBeat.o(89552);
        return false;
      }
      if (i == 1)
      {
        paramInt = this.gCB.audioSampleRate;
        i = this.gCB.audioBitrate;
        k = this.gCB.gnH;
        if (this.gCB.hcu == 1)
        {
          bool = true;
          this.gCl = new g(paramInt, i, k, com.tencent.mm.plugin.sight.base.b.Z(false, bool));
          this.gCl.nf(this.gCH);
          paramInt = this.gCl.D(this.gmW, com.tencent.mm.plugin.sight.base.e.anm(this.gCg));
        }
      }
      for (;;)
      {
        if ((j >= 0) && (paramInt >= 0)) {
          break label788;
        }
        ad.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
        SightVideoJNI.releaseBigSightDataBufferLock(this.gmW);
        l.cPU();
        AppMethodBeat.o(89552);
        return false;
        bool = false;
        break;
        if (i == 2)
        {
          this.gCl = new i(this.gCB.audioSampleRate, this.gCB.audioBitrate, this.gCB.gnH);
          this.gCl.nf(this.gCH);
          paramInt = this.gCl.D(this.gmW, com.tencent.mm.plugin.sight.base.e.anm(this.gCg));
        }
      }
    }
    if (j < 0)
    {
      ad.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mute init yuv recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(0) });
      SightVideoJNI.releaseBigSightDataBufferLock(this.gmW);
      l.cPU();
      AppMethodBeat.o(89552);
      return false;
    }
    label788:
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
    AppMethodBeat.o(89552);
    return true;
  }
  
  public final void C(Runnable paramRunnable)
  {
    AppMethodBeat.i(89556);
    this.gCG = paramRunnable;
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", new Object[] { paramRunnable });
    if ((this.tEH == null) || ((this.gCl == null) && (!this.gCJ)))
    {
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
      if (paramRunnable != null) {
        aq.f(paramRunnable);
      }
      AppMethodBeat.o(89556);
      return;
    }
    if ((this.gCs != null) && (this.gCs.tFa == d.c.tDR))
    {
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, already in stop status");
      if (this.gCl != null) {
        this.gCl.clear();
      }
      if (this.tEH != null) {
        this.tEH.clear();
      }
      if (paramRunnable != null) {
        aq.f(paramRunnable);
      }
      AppMethodBeat.o(89556);
      return;
    }
    this.gCW = null;
    this.gCh = ((int)this.tEH.ajJ());
    if (this.gCs != null) {
      this.gCs.a(d.c.tDP);
    }
    if (this.tEH != null) {
      this.tEH.a(new f.a()
      {
        public final void cQh()
        {
          AppMethodBeat.i(89544);
          com.tencent.mm.sdk.g.b.c(new n.6(n.this), "MMSightMediaCodecMP4MuxRecorder_stop");
          AppMethodBeat.o(89544);
        }
      });
    }
    if (this.gCl != null) {
      this.gCl.a(new c.b()
      {
        public final void aoA()
        {
          AppMethodBeat.i(89545);
          ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac stop finish");
          AppMethodBeat.o(89545);
        }
      });
    }
    AppMethodBeat.o(89556);
  }
  
  public final void J(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89567);
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    if ((this.gCs != null) && (this.gCs.tFa == d.c.tDW))
    {
      if (this.tEH != null)
      {
        q localq = this.tEH;
        localq.tET = paramInt1;
        localq.tEU = paramInt2;
        localq.tEV = paramInt3;
        ad.i("MicroMsg.MMSightYUVMediaCodecRecorder", "resume, newRotation: %s, newFrameWidth: %s, newFrameHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      }
      this.gCs.a(d.c.tDO);
    }
    AppMethodBeat.o(89567);
  }
  
  public final String JS()
  {
    AppMethodBeat.i(89558);
    String str = bt.by(this.md5, "");
    AppMethodBeat.o(89558);
    return str;
  }
  
  public final void a(d.a parama)
  {
    this.gCF = parama;
  }
  
  public final void af(float paramFloat)
  {
    AppMethodBeat.i(89570);
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.gCk = paramFloat;
    AppMethodBeat.o(89570);
  }
  
  public final String anX()
  {
    return this.thumbPath;
  }
  
  final boolean aol()
  {
    AppMethodBeat.i(89557);
    long l = bt.GC();
    int i;
    if ((this.tEI != null) && (this.tEJ != null))
    {
      if (com.tencent.mm.compatible.util.d.lf(18))
      {
        this.tEI.quitSafely();
        this.tEJ = null;
      }
    }
    else
    {
      i = this.tEH.frameCount;
      this.gCi = (i * 1000.0F / this.gCh);
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, frameCount: %s, fps: %s, duration: %s, file: %s handlerrunning %s, overrideDurationMs: %s, overrideFps: %s", new Object[] { Integer.valueOf(i), Float.valueOf(this.gCi), Integer.valueOf(this.gCh), this.gCg, Long.valueOf(bt.aS(l)), Integer.valueOf(this.gCj), Float.valueOf(this.gCk) });
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "frameCountCallback %s", new Object[] { this.gCA.getValue() });
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "yuvRecorderWriteDataCallback %s", new Object[] { this.gCz.getValue() });
      str = null;
      if (CaptureMMProxy.getInstance() == null) {
        break label377;
      }
      str = CaptureMMProxy.getInstance().getAccVideoPath();
      label210:
      if (bt.isNullOrNil(str)) {
        break label412;
      }
    }
    label412:
    for (String str = com.tencent.mm.plugin.mmsight.d.aha(str);; str = this.gCg)
    {
      i = this.gCh;
      if (this.gCj > 0) {
        i = this.gCj;
      }
      float f = this.gCi;
      if (this.gCk > 0.0F) {
        f = this.gCk;
      }
      this.gCC = new m(this.gmW, str, f, this.gCp, i, this.gCB.audioSampleRate, this.gCJ, false, false);
      l = bt.GC();
      boolean bool = this.gCC.cQg();
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(bt.aS(l)), Boolean.valueOf(bool) });
      if (bool) {
        break label421;
      }
      ad.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mux failed!");
      l.cPV();
      AppMethodBeat.o(89557);
      return false;
      this.tEI.quit();
      break;
      label377:
      if (bt.isNullOrNil(this.gCg)) {
        break label210;
      }
      str = com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(this.gCg).fhT().fhU());
      break label210;
    }
    label421:
    if (((this.gBu) && (this.gDs)) || ((!this.gDs) && (!this.gBu)) || ((this.gBu) && (Math.abs(this.gCt - this.gCE) == 0)) || (this.gCE == 180))
    {
      l = bt.GC();
      if ((this.gDs) || (this.gBu)) {
        break label759;
      }
      i = this.gCt;
    }
    for (;;)
    {
      int j = i;
      if (this.gCE == 180)
      {
        j = i;
        if (!this.gDs)
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
        SightVideoJNI.tagRotateVideoVFS(str, this.gCv, j);
        this.gCy = true;
        ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(bt.aS(l)), Integer.valueOf(this.gCt), Boolean.valueOf(this.gBu), Integer.valueOf(this.gCE), Integer.valueOf(j) });
        l = bt.GC();
      }
      try
      {
        com.tencent.mm.vfs.i.deleteFile(str);
        com.tencent.mm.vfs.i.lD(this.gCv, str);
        ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "copyFile cost %s", new Object[] { Long.valueOf(bt.aS(l)) });
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(89548);
            try
            {
              com.tencent.mm.vfs.i.deleteFile(this.gDc);
              AppMethodBeat.o(89548);
              return;
            }
            catch (Exception localException)
            {
              ad.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, delete old file error: %s", new Object[] { localException.getMessage() });
              AppMethodBeat.o(89548);
            }
          }
        }, "BigSightMediaCodecMP4MuxRecorder_tagRotate_after_process");
        SightVideoJNI.releaseBigSightDataBufferLock(this.gmW);
        this.gCs.a(d.c.tDR);
        this.md5 = com.tencent.mm.vfs.i.aEN(str);
        if ((!bt.isNullOrNil(str)) && (!str.equals(this.gCg)))
        {
          com.tencent.mm.vfs.i.lD(str, this.gCg);
          com.tencent.mm.vfs.i.deleteFile(str);
        }
        AppMethodBeat.o(89557);
        return true;
      }
      catch (Exception localException)
      {
        label759:
        ad.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "stop, copy file error");
        AppMethodBeat.o(89557);
      }
      if (this.gDs) {
        i = this.gCE;
      } else {
        i = 180;
      }
    }
    return false;
  }
  
  public final String aon()
  {
    return this.gCx;
  }
  
  public final float aoo()
  {
    return this.gCi;
  }
  
  public final long aop()
  {
    AppMethodBeat.i(89562);
    if (this.tEH != null)
    {
      long l = this.tEH.ajJ();
      AppMethodBeat.o(89562);
      return l;
    }
    AppMethodBeat.o(89562);
    return 0L;
  }
  
  public final d.c aoq()
  {
    return this.gCs.tFa;
  }
  
  public final int aor()
  {
    AppMethodBeat.i(89564);
    int i = Math.round(this.gCh / 1000.0F);
    AppMethodBeat.o(89564);
    return i;
  }
  
  public final Point aos()
  {
    AppMethodBeat.i(89565);
    Point localPoint = new Point(this.gCq, this.gCr);
    AppMethodBeat.o(89565);
    return localPoint;
  }
  
  public final int aot()
  {
    return this.gCt;
  }
  
  public final boolean aou()
  {
    return this.gCD;
  }
  
  public final boolean aov()
  {
    return this.gBu;
  }
  
  public final com.tencent.mm.audio.b.c.a aow()
  {
    AppMethodBeat.i(89568);
    if (this.gCl != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.gCl.cQf();
      AppMethodBeat.o(89568);
      return locala;
    }
    AppMethodBeat.o(89568);
    return null;
  }
  
  public final void aox()
  {
    this.gCI = false;
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(89555);
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.gCz.reset();
    this.gCh = 0;
    this.gCA.reset();
    this.gCw = false;
    this.gBu = paramBoolean;
    this.gCE = paramInt2;
    this.gCs.a(d.c.tDN);
    if (bt.isNullOrNil(this.gCg))
    {
      ad.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(89555);
      return -1;
    }
    try
    {
      this.mFileName = com.tencent.mm.vfs.i.aMS(this.gCg);
      String str2 = com.tencent.mm.vfs.i.aMQ(this.gCg);
      String str1 = str2;
      if (!str2.endsWith("/")) {
        str1 = str2 + "/";
      }
      this.gCv = (str1 + "tempRotate.mp4");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "retrieve file name error: %s", new Object[] { localException.getMessage() });
        continue;
        this.gCs.a(d.c.tDV);
        continue;
        ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start yuvRecorder with mute");
        this.tEH.start();
        this.gCs.a(d.c.tDO);
        this.gCD = false;
        l.cPS();
        l.akS();
        paramInt1 = 0;
      }
    }
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", new Object[] { this.gCg, this.gCv });
    this.gCt = paramInt1;
    this.tEI = com.tencent.e.c.d.gw("BigSightMediaCodecMP4MuxRecorder_writeYuvData_" + hashCode(), -1);
    this.tEI.start();
    this.tEJ = new ap(this.tEI.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(89542);
        ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "carson：writeYuvData ");
        if (paramAnonymousMessage.what == 1)
        {
          paramAnonymousMessage = (byte[])paramAnonymousMessage.obj;
          if ((paramAnonymousMessage != null) && (n.this.tEH != null)) {
            n.a(n.this, paramAnonymousMessage);
          }
        }
        AppMethodBeat.o(89542);
      }
    };
    if (!this.ggj)
    {
      mP(paramInt1);
      this.ggj = true;
    }
    if ((!this.gCJ) && (!this.gCH))
    {
      paramInt1 = this.gCl.a(new c.a()
      {
        public final void aoB()
        {
          AppMethodBeat.i(89543);
          ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "onPcmReady");
          if (n.this.aoq() != d.c.tDV)
          {
            ad.w("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
            AppMethodBeat.o(89543);
            return;
          }
          n.this.tEH.start();
          n.this.gCs.a(d.c.tDO);
          AppMethodBeat.o(89543);
        }
      });
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "start aacRecorder ret: %s", new Object[] { Integer.valueOf(paramInt1) });
      this.gCD = false;
      if (paramInt1 != 0)
      {
        this.gCs.a(d.c.tDU);
        l.cPS();
        l.akS();
        AppMethodBeat.o(89555);
        return paramInt1;
      }
    }
  }
  
  protected final void bq(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89553);
    if (this.tEH != null)
    {
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramArrayOfByte;
      if (this.tEJ != null) {
        this.tEJ.sendMessage(localMessage);
      }
    }
    AppMethodBeat.o(89553);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(89559);
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "cancel record");
    if ((this.tEH == null) || ((this.gCl == null) && (!this.gCJ)))
    {
      ad.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
      AppMethodBeat.o(89559);
      return;
    }
    this.gCs.a(d.c.tDQ);
    this.tEH.a(null);
    if (this.gCl != null) {
      this.gCl.a(new c.b()
      {
        public final void aoA()
        {
          AppMethodBeat.i(89549);
          ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "aac stop finish");
          AppMethodBeat.o(89549);
        }
      });
    }
    if ((this.tEI != null) && (this.tEJ != null))
    {
      this.tEJ.removeMessages(0);
      this.tEI.quit();
      this.tEJ = null;
    }
    SightVideoJNI.releaseBigSightDataBufferLock(this.gmW);
    this.gCs.a(d.c.tDR);
    reset();
    AppMethodBeat.o(89559);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(89560);
    try
    {
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "clear");
      if (this.gCl != null) {
        this.gCl.clear();
      }
      if (this.tEH != null) {
        this.tEH.clear();
      }
      AppMethodBeat.o(89560);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.MMSightMediaCodecMP4MuxRecorder", localException, "clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(89560);
    }
  }
  
  public final void dV(boolean paramBoolean)
  {
    this.gCH = paramBoolean;
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.gCg;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.g getFrameDataCallback()
  {
    return this.gCW;
  }
  
  public final boolean mQ(int paramInt)
  {
    AppMethodBeat.i(89554);
    if (!this.ggj)
    {
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preInit, cameraOrientation");
      boolean bool = mP(paramInt);
      this.ggj = true;
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(89554);
      return bool;
    }
    AppMethodBeat.o(89554);
    return true;
  }
  
  public final void mR(int paramInt)
  {
    AppMethodBeat.i(89569);
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.gCj = paramInt;
    AppMethodBeat.o(89569);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89566);
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "pause");
    if ((this.gCs != null) && (this.gCs.tFa == d.c.tDO)) {
      this.gCs.a(d.c.tDW);
    }
    AppMethodBeat.o(89566);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(89561);
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", new Object[] { this.tEH, this.gCl, this.gCC });
    synchronized (this.gCf)
    {
      this.tEH = null;
      this.gCl = null;
      this.gCC = null;
      this.ggj = false;
      this.gCD = false;
      AppMethodBeat.o(89561);
      return;
    }
  }
  
  public final void ru(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void rv(String paramString)
  {
    this.gCx = paramString;
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(89563);
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.gCn = paramInt3;
    this.gCo = paramInt4;
    this.gCq = paramInt1;
    this.gCr = paramInt2;
    if (j.tEA.g(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = bt.GC();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        j.tEA.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      ad.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
    }
    AppMethodBeat.o(89563);
  }
  
  public final void setFilePath(String paramString)
  {
    this.gCg = paramString;
  }
  
  public final void setMirror(boolean paramBoolean) {}
  
  public final void setMute(boolean paramBoolean)
  {
    this.gCJ = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.n
 * JD-Core Version:    0.7.0.1
 */