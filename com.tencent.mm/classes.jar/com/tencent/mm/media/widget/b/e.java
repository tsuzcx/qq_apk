package com.tencent.mm.media.widget.b;

import android.graphics.Point;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.g;
import com.tencent.mm.plugin.mmsight.model.a.i;
import com.tencent.mm.plugin.mmsight.model.a.p;
import com.tencent.mm.plugin.mmsight.model.a.s;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;

public final class e
  implements b
{
  private String cqq;
  private boolean eLc;
  boolean fcC;
  private long fcN;
  private f fcP;
  String fca;
  private int fcb;
  private float fcc;
  int fcd;
  float fce;
  private int fch;
  private int fci;
  int fcj;
  int fck;
  int fcl;
  s fcm;
  int fcn;
  String fco;
  boolean fcp;
  private String fcq;
  private boolean fcr;
  VideoTransPara fcu;
  boolean fcw;
  boolean fcx;
  int fcy;
  d.a fcz;
  com.tencent.mm.plugin.mmsight.model.a.c fdd;
  p fde;
  private e.a fdf;
  com.tencent.mm.plugin.mmsight.model.a.e fdg;
  private HandlerThread fdh;
  ak fdi;
  int fdj;
  int fdk;
  boolean fdl;
  private int fdm;
  private boolean fdn;
  private boolean fdo;
  private long fdp;
  private String mFileName;
  String thumbPath;
  
  public e(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(152056);
    this.fdf = null;
    this.fca = "";
    this.fcb = 0;
    this.fcc = 0.0F;
    this.fcd = -1;
    this.fce = -1.0F;
    this.fch = 480;
    this.fci = 640;
    this.fcj = 1600000;
    this.fck = 480;
    this.fcl = 640;
    this.fcn = 0;
    this.fco = null;
    this.fdh = null;
    this.fdi = null;
    this.fdj = -1;
    this.fdk = -1;
    this.fdl = false;
    this.thumbPath = null;
    this.fcq = null;
    this.fcr = false;
    this.fcp = false;
    this.eLc = false;
    this.fdm = -1;
    this.fcw = false;
    this.cqq = "";
    this.fcx = false;
    this.fcy = 0;
    this.fdn = false;
    this.fcC = true;
    this.fdo = false;
    this.fcN = 0L;
    this.fdp = 0L;
    this.fcP = new e.1(this);
    this.fcu = paramVideoTransPara;
    this.fch = paramVideoTransPara.width;
    this.fci = paramVideoTransPara.height;
    this.fcj = paramVideoTransPara.videoBitrate;
    this.fcm = new s();
    this.eLc = false;
    ab.i("MicroMsg.X264YUVMP4MuxRecorder", "create X264YUVMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s", new Object[] { Integer.valueOf(this.fch), Integer.valueOf(this.fci), Integer.valueOf(this.fcj) });
    paramVideoTransPara = com.tencent.mm.media.i.c.eZC;
    com.tencent.mm.media.i.c.Vx();
    AppMethodBeat.o(152056);
  }
  
  private boolean kl(int paramInt)
  {
    AppMethodBeat.i(152065);
    long l = bo.yB();
    if (com.tencent.mm.plugin.mmsight.model.j.oHG != null) {
      this.fdl = com.tencent.mm.plugin.mmsight.model.j.oHG.fdl;
    }
    this.fcn = paramInt;
    label75:
    int k;
    label94:
    int n;
    com.tencent.mm.media.i.c localc;
    if (!this.fdl)
    {
      if ((paramInt == 90) || (paramInt == 270))
      {
        j = this.fck;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label222;
        }
        i = this.fcl;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label230;
        }
        k = this.fci;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label239;
        }
      }
      label222:
      label230:
      label239:
      for (m = this.fch;; m = this.fci)
      {
        n = j;
        j = m;
        m = i;
        i = n;
        n = this.fcj;
        m = SightVideoJNI.initDataBufferForMMSightLock(i, m, paramInt, k, j, this.fcu.fps, n, this.fcu.fzW, 8, this.fcu.fzV, 23.0F, this.fdl, true, this.fcu.duration, false);
        if (m >= 0) {
          break label369;
        }
        ab.e("MicroMsg.X264YUVMP4MuxRecorder", "init failed!");
        localc = com.tencent.mm.media.i.c.eZC;
        com.tencent.mm.media.i.c.Vy();
        AppMethodBeat.o(152065);
        return false;
        j = this.fcl;
        break;
        i = this.fck;
        break label75;
        k = this.fch;
        break label94;
      }
    }
    if ((paramInt == 90) || (paramInt == 270))
    {
      i = this.fck;
      label266:
      if ((paramInt != 90) && (paramInt != 270)) {
        break label343;
      }
      j = this.fcl;
      label284:
      if ((paramInt != 90) && (paramInt != 270)) {
        break label351;
      }
      k = this.fch;
      label303:
      if ((paramInt != 90) && (paramInt != 270)) {
        break label360;
      }
    }
    label343:
    label351:
    label360:
    for (int m = this.fci;; m = this.fch)
    {
      n = m;
      m = j;
      j = n;
      break;
      i = this.fcl;
      break label266;
      j = this.fck;
      break label284;
      k = this.fci;
      break label303;
    }
    label369:
    this.fdm = m;
    this.fde = new p(this.fdl, paramInt, k, j);
    int j = this.fde.zt(m);
    paramInt = 0;
    int i = -1;
    if (CaptureMMProxy.getInstance() != null) {
      i = CaptureMMProxy.getInstance().getInt(ac.a.yEc, -1);
    }
    if (i < 0)
    {
      this.fdd = new g(this.fcu.audioSampleRate, this.fcu.fzT, this.fcu.eRF);
      this.fdd.jn(this.fdn);
      paramInt = this.fdd.t(m, com.tencent.mm.plugin.sight.base.d.Zm(this.fca));
      if ((j < 0) || (paramInt < 0))
      {
        ab.e("MicroMsg.X264YUVMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
        if ((paramInt < 0) && (j >= 0))
        {
          ab.w("MicroMsg.X264YUVMP4MuxRecorder", "aac init error, try mediarecorder now");
          this.fdd.clear();
          this.fdd = new i(this.fcu.audioSampleRate, this.fcu.fzT, this.fcu.eRF);
          this.fdd.jn(this.fdn);
          paramInt = this.fdd.t(m, com.tencent.mm.plugin.sight.base.d.Zm(this.fca));
          ab.w("MicroMsg.X264YUVMP4MuxRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[] { Integer.valueOf(paramInt) });
          if (paramInt >= 0)
          {
            AppMethodBeat.o(152065);
            return true;
          }
        }
        SightVideoJNI.releaseBigSightDataBufferLock(m);
        AppMethodBeat.o(152065);
        return false;
      }
    }
    else
    {
      if (i == 1)
      {
        this.fdd = new g(this.fcu.audioSampleRate, this.fcu.fzT, this.fcu.eRF);
        this.fdd.jn(this.fdn);
        paramInt = this.fdd.t(m, com.tencent.mm.plugin.sight.base.d.Zm(this.fca));
      }
      for (;;)
      {
        if (paramInt < 0)
        {
          localc = com.tencent.mm.media.i.c.eZC;
          com.tencent.mm.media.i.c.VA();
        }
        if ((j >= 0) && (paramInt >= 0)) {
          break;
        }
        ab.e("MicroMsg.X264YUVMP4MuxRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
        SightVideoJNI.releaseBigSightDataBufferLock(m);
        localc = com.tencent.mm.media.i.c.eZC;
        com.tencent.mm.media.i.c.Vy();
        AppMethodBeat.o(152065);
        return false;
        if (i == 2)
        {
          this.fdd = new i(this.fcu.audioSampleRate, this.fcu.fzT, this.fcu.eRF);
          this.fdd.jn(this.fdn);
          paramInt = this.fdd.t(m, com.tencent.mm.plugin.sight.base.d.Zm(this.fca));
        }
      }
    }
    ab.i("MicroMsg.X264YUVMP4MuxRecorder", "initImpl used %sms", new Object[] { Long.valueOf(bo.av(l)) });
    AppMethodBeat.o(152065);
    return true;
  }
  
  private boolean ko(int paramInt)
  {
    AppMethodBeat.i(152058);
    if ((this.fdf != null) && (!this.fdf.fdx))
    {
      if (!this.fdf.fdu)
      {
        this.fdf.callback = null;
        this.fdf.fdw = true;
        this.fdf.fdv = true;
        com.tencent.mm.sdk.g.d.ysm.remove(this.fdf);
      }
      synchronized (this.fdf.fdy)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(paramInt);
        if (this.fdf.fds != paramInt) {
          SightVideoJNI.releaseBigSightDataBufferLock(this.fdf.fds);
        }
        AppMethodBeat.o(152058);
        return true;
      }
    }
    AppMethodBeat.o(152058);
    return false;
  }
  
  public final String Al()
  {
    AppMethodBeat.i(152062);
    String str = bo.bf(this.cqq, "");
    AppMethodBeat.o(152062);
    return str;
  }
  
  public final void G(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(152072);
    ab.i("MicroMsg.X264YUVMP4MuxRecorder", "resume, cameraOrientation: %s, lastPauseTimeMs:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(this.fdp) });
    if ((this.fcm != null) && (this.fcm.oJP == d.c.oIO))
    {
      if (this.fde != null) {
        this.fde.G(paramInt1, paramInt2, paramInt3);
      }
      this.fcm.a(d.c.oIG);
      if (this.fdp > 0L) {
        this.fcN += System.currentTimeMillis() - this.fdp;
      }
    }
    AppMethodBeat.o(152072);
  }
  
  public final boolean XA()
  {
    return this.fcw;
  }
  
  public final c.a XB()
  {
    AppMethodBeat.i(152073);
    if (this.fdd != null)
    {
      c.a locala = this.fdd.bRl();
      AppMethodBeat.o(152073);
      return locala;
    }
    AppMethodBeat.o(152073);
    return null;
  }
  
  public final void XC()
  {
    this.fcC = false;
  }
  
  final void XE()
  {
    if (this.fdf != null) {
      this.fdf.fdv = true;
    }
  }
  
  final void XF()
  {
    AppMethodBeat.i(152068);
    ab.i("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::pcm ready");
    if ((this.fdf != null) && (!this.fdf.fdx)) {
      ab.e("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", new Object[] { this.fdf });
    }
    synchronized (this.fdf.fdy)
    {
      ko(this.fdf.fds);
      if (this.fcm.oJP != d.c.oIN)
      {
        ab.w("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
        AppMethodBeat.o(152068);
        return;
      }
    }
    this.fcm.a(d.c.oIG);
    this.fdf = new e.a(this);
    this.fdf.fds = this.fdm;
    com.tencent.mm.sdk.g.d.f(this.fdf, "SightCustomAsyncMediaRecorder_encode_" + bo.yB());
    AppMethodBeat.o(152068);
  }
  
  public final long Xf()
  {
    AppMethodBeat.i(152063);
    long l = this.fde.UQ();
    AppMethodBeat.o(152063);
    return l;
  }
  
  public final String Xi()
  {
    return this.thumbPath;
  }
  
  public final void Xq() {}
  
  public final String Xu()
  {
    return this.fcq;
  }
  
  public final float Xv()
  {
    return this.fcc;
  }
  
  public final d.c Xw()
  {
    return this.fcm.oJP;
  }
  
  public final int Xx()
  {
    AppMethodBeat.i(152069);
    int i = Math.round(this.fcb / 1000.0F);
    AppMethodBeat.o(152069);
    return i;
  }
  
  public final Point Xy()
  {
    AppMethodBeat.i(152070);
    Point localPoint = new Point(this.fck, this.fcl);
    AppMethodBeat.o(152070);
    return localPoint;
  }
  
  public final int Xz()
  {
    return this.fcn;
  }
  
  public final void a(d.a parama)
  {
    this.fcz = parama;
  }
  
  public final void ag(float paramFloat)
  {
    AppMethodBeat.i(152075);
    ab.i("MicroMsg.X264YUVMP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.fce = paramFloat;
    AppMethodBeat.o(152075);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(152067);
    ab.i("MicroMsg.X264YUVMP4MuxRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { this.fcm.oJP, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.fcx = paramBoolean;
    this.fcN = 0L;
    this.fdp = 0L;
    this.fcb = 0;
    this.fcy = paramInt2;
    this.fcm.a(d.c.oIF);
    String str = this.fca;
    if (this.fdf == null)
    {
      paramBoolean = true;
      if ((this.fdf != null) && (!this.fdf.fdx)) {
        break label189;
      }
    }
    label189:
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.X264YUVMP4MuxRecorder", "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]", new Object[] { str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if ((this.fdf == null) || (this.fdf.fdx)) {
        break label195;
      }
      ab.w("MicroMsg.X264YUVMP4MuxRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
      AppMethodBeat.o(152067);
      return -1;
      paramBoolean = false;
      break;
    }
    label195:
    if (bo.isNullOrNil(this.fca))
    {
      ab.e("MicroMsg.X264YUVMP4MuxRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(152067);
      return -1;
    }
    this.mFileName = com.tencent.mm.vfs.e.avM(this.fca);
    ab.i("MicroMsg.X264YUVMP4MuxRecorder", "mCurRecordPath: %s", new Object[] { this.fca });
    this.fcn = paramInt1;
    ab.i("MicroMsg.X264YUVMP4MuxRecorder", "start, cameraOrientation: %s", new Object[] { Integer.valueOf(this.fcn) });
    if (!this.eLc)
    {
      kl(paramInt1);
      this.eLc = true;
    }
    this.fde.start();
    if (!this.fdn)
    {
      paramInt1 = this.fdd.a(new e.5(this));
      ab.i("MicroMsg.X264YUVMP4MuxRecorder", "start aac recorder ret: %d", new Object[] { Integer.valueOf(paramInt1) });
      this.fdh = com.tencent.mm.sdk.g.d.ey("BigSightWriteCameraData", 0);
      this.fdh.start();
      this.fdi = new e.6(this, this.fdh.getLooper());
      this.fcw = false;
      if (paramInt1 == 0) {
        break label427;
      }
      this.fcm.a(d.c.oIM);
    }
    for (;;)
    {
      if (this.fdn) {
        XF();
      }
      AppMethodBeat.o(152067);
      return paramInt1;
      paramInt1 = 0;
      break;
      label427:
      this.fcm.a(d.c.oIN);
    }
  }
  
  public final void cG(boolean paramBoolean)
  {
    this.fdn = paramBoolean;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(152060);
    ab.i("MicroMsg.X264YUVMP4MuxRecorder", "cancel");
    this.fcm.a(d.c.oII);
    clear();
    this.fcm.a(d.c.oIJ);
    AppMethodBeat.o(152060);
  }
  
  public final void clear()
  {
    boolean bool2 = true;
    AppMethodBeat.i(152059);
    int i = -1;
    if (this.fde != null)
    {
      i = this.fde.oJG;
      if (i < 0)
      {
        ab.v("MicroMsg.X264YUVMP4MuxRecorder", "call clear, but bufID error");
        AppMethodBeat.o(152059);
        return;
      }
      this.fde.stop();
    }
    if (this.fdd != null) {
      this.fdd.a(null);
    }
    boolean bool1;
    if (this.fdf == null)
    {
      bool1 = true;
      if ((this.fdf == null) || (!this.fdf.fdw)) {
        break label187;
      }
    }
    for (;;)
    {
      ab.v("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::clear bufID %d, encodeRunnable null ? %B, markCancel %B", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((i >= 0) && (!ko(i)))
      {
        SightVideoJNI.releaseRecorderBufferRef("clear");
        SightVideoJNI.releaseBigSightDataBufferLock(i);
      }
      if (this.fdh != null) {
        this.fdh.quit();
      }
      this.fcN = 0L;
      this.fdp = 0L;
      AppMethodBeat.o(152059);
      return;
      bool1 = false;
      break;
      label187:
      bool2 = false;
    }
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.fca;
  }
  
  public final f getFrameDataCallback()
  {
    return this.fcP;
  }
  
  public final boolean isLandscape()
  {
    return this.fcx;
  }
  
  public final boolean km(int paramInt)
  {
    AppMethodBeat.i(152066);
    if (!this.eLc)
    {
      ab.i("MicroMsg.X264YUVMP4MuxRecorder", "preInit, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = kl(paramInt);
      this.eLc = true;
      ab.i("MicroMsg.X264YUVMP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(152066);
      return bool;
    }
    AppMethodBeat.o(152066);
    return true;
  }
  
  public final void kn(int paramInt)
  {
    AppMethodBeat.i(152074);
    ab.i("MicroMsg.X264YUVMP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.fcd = paramInt;
    AppMethodBeat.o(152074);
  }
  
  public final void mV(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void mW(String paramString)
  {
    this.fcq = paramString;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(152071);
    ab.i("MicroMsg.X264YUVMP4MuxRecorder", "pause");
    if ((this.fcm != null) && (this.fcm.oJP == d.c.oIG))
    {
      this.fcm.a(d.c.oIO);
      this.fdp = System.currentTimeMillis();
    }
    AppMethodBeat.o(152071);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(152064);
    ab.i("MicroMsg.X264YUVMP4MuxRecorder", "reset");
    this.fcm.oJP = d.c.oIJ;
    this.fcw = false;
    if (this.fdd != null) {
      this.fdd.clear();
    }
    if (this.fde != null) {
      this.fde.clear();
    }
    clear();
    AppMethodBeat.o(152064);
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(152057);
    ab.i("MicroMsg.X264YUVMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.fck = paramInt1;
    this.fcl = paramInt2;
    if (com.tencent.mm.plugin.mmsight.model.a.j.oJp.f(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      ab.i("MicroMsg.X264YUVMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = bo.yB();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        com.tencent.mm.plugin.mmsight.model.a.j.oJp.O(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      ab.i("MicroMsg.X264YUVMP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(bo.av(l)) });
    }
    AppMethodBeat.o(152057);
  }
  
  public final void setFilePath(String paramString)
  {
    this.fca = paramString;
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void u(Runnable paramRunnable)
  {
    AppMethodBeat.i(152061);
    boolean bool1;
    if (this.fdf == null) {
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2;
      label34:
      boolean bool3;
      if ((this.fdf != null) && (this.fdf.fdu))
      {
        bool2 = true;
        if ((this.fdf == null) || (!this.fdf.fdv)) {
          break label145;
        }
        bool3 = true;
        ab.i("MicroMsg.X264YUVMP4MuxRecorder", "stop, encodeThread null ? %B, has trigger finish ? %B, has finish callback ? %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((this.fdf == null) || (!this.fdf.fdu)) {
          break;
        }
      }
      synchronized (this.fdf.fdy)
      {
        reset();
        al.d(paramRunnable);
        AppMethodBeat.o(152061);
        return;
        bool1 = false;
        continue;
        bool2 = false;
        break label34;
        label145:
        bool3 = false;
      }
    }
    ab.i("MicroMsg.X264YUVMP4MuxRecorder", "stopOnCameraDataThread: %s, writeCameraDataHandler: %s", new Object[] { Boolean.valueOf(this.fdo), this.fdi });
    if ((this.fdo) && (this.fdi != null))
    {
      this.fdi.post(new e.2(this, paramRunnable));
      AppMethodBeat.o(152061);
      return;
    }
    com.tencent.mm.sdk.g.d.post(new e.3(this, paramRunnable), "MMSightFFMpegRecorder_stop");
    AppMethodBeat.o(152061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.e
 * JD-Core Version:    0.7.0.1
 */