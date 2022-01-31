package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Point;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;

public final class l
  implements d
{
  private String cqq;
  private boolean eLc;
  boolean fcC;
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
  c fdd;
  p fde;
  e fdg;
  private HandlerThread fdh;
  ak fdi;
  int fdj;
  int fdk;
  boolean fdl;
  private int fdm;
  private boolean fdn;
  public boolean fdo;
  private String mFileName;
  private l.a oJs;
  String thumbPath;
  
  public l(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(76606);
    this.oJs = null;
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
    this.fcP = new l.1(this);
    this.fcu = paramVideoTransPara;
    this.fch = paramVideoTransPara.width;
    this.fci = paramVideoTransPara.height;
    this.fcj = paramVideoTransPara.videoBitrate;
    k.bRq();
    int i = k.bRs();
    if (i == -1) {}
    for (this.fcj = paramVideoTransPara.videoBitrate;; this.fcj = i)
    {
      this.fcm = new s();
      this.eLc = false;
      ab.d("MicroMsg.MMSightFFMpegRecorder", "create MMSightFFMpegRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s,  defaultRate: %s", new Object[] { Integer.valueOf(this.fch), Integer.valueOf(this.fci), Integer.valueOf(this.fcj), Integer.valueOf(i) });
      AppMethodBeat.o(76606);
      return;
    }
  }
  
  private boolean kl(int paramInt)
  {
    AppMethodBeat.i(76615);
    long l = bo.yB();
    this.fdl = com.tencent.mm.plugin.mmsight.model.j.oHG.fdl;
    this.fcn = paramInt;
    int j;
    label65:
    int n;
    int m;
    if (!this.fdl) {
      if ((paramInt == 0) || (paramInt == 180))
      {
        i = this.fck;
        if ((paramInt != 0) && (paramInt != 180)) {
          break label173;
        }
        j = this.fcl;
        k = this.fch;
        n = this.fci;
        m = i;
        i = n;
      }
    }
    for (;;)
    {
      n = this.fcj;
      j = SightVideoJNI.initDataBufferForMMSightLock(m, j, paramInt, k, i, this.fcu.fps, n, this.fcu.fzW, 8, this.fcu.fzV, 23.0F, this.fdl, true, this.fcu.duration, false);
      if (j >= 0) {
        break label296;
      }
      ab.e("MicroMsg.MMSightFFMpegRecorder", "init failed!");
      com.tencent.mm.plugin.mmsight.model.k.bQY();
      AppMethodBeat.o(76615);
      return false;
      i = this.fcl;
      break;
      label173:
      j = this.fck;
      break label65;
      if ((paramInt == 0) || (paramInt == 180))
      {
        i = this.fck;
        label197:
        if ((paramInt != 0) && (paramInt != 180)) {
          break label264;
        }
        j = this.fcl;
        label213:
        if ((paramInt != 0) && (paramInt != 180)) {
          break label272;
        }
      }
      label264:
      label272:
      for (k = this.fch;; k = this.fci)
      {
        if ((paramInt != 0) && (paramInt != 180)) {
          break label281;
        }
        n = this.fci;
        m = i;
        i = n;
        break;
        i = this.fcl;
        break label197;
        j = this.fck;
        break label213;
      }
      label281:
      n = this.fch;
      m = i;
      i = n;
    }
    label296:
    this.fdm = j;
    this.fde = new p(this.fdl, paramInt, k, i);
    int k = this.fde.zt(j);
    paramInt = 0;
    int i = -1;
    if (CaptureMMProxy.getInstance() != null) {
      i = CaptureMMProxy.getInstance().getInt(ac.a.yEc, -1);
    }
    if (i < 0)
    {
      this.fdd = new g(this.fcu.audioSampleRate, this.fcu.fzT, this.fcu.eRF);
      this.fdd.jn(this.fdn);
      paramInt = this.fdd.t(j, com.tencent.mm.plugin.sight.base.d.Zm(this.fca));
      if ((k < 0) || (paramInt < 0))
      {
        ab.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt) });
        if ((paramInt < 0) && (k >= 0))
        {
          ab.w("MicroMsg.MMSightFFMpegRecorder", "aac init error, try mediarecorder now");
          this.fdd.clear();
          this.fdd = new i(this.fcu.audioSampleRate, this.fcu.fzT, this.fcu.eRF);
          this.fdd.jn(this.fdn);
          paramInt = this.fdd.t(j, com.tencent.mm.plugin.sight.base.d.Zm(this.fca));
          ab.w("MicroMsg.MMSightFFMpegRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[] { Integer.valueOf(paramInt) });
          if (paramInt >= 0)
          {
            AppMethodBeat.o(76615);
            return true;
          }
        }
        SightVideoJNI.releaseBigSightDataBufferLock(j);
        com.tencent.mm.plugin.mmsight.model.k.bQY();
        AppMethodBeat.o(76615);
        return false;
      }
    }
    else
    {
      if (i == 1)
      {
        this.fdd = new g(this.fcu.audioSampleRate, this.fcu.fzT, this.fcu.eRF);
        this.fdd.jn(this.fdn);
        paramInt = this.fdd.t(j, com.tencent.mm.plugin.sight.base.d.Zm(this.fca));
      }
      while ((k < 0) || (paramInt < 0))
      {
        ab.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt) });
        SightVideoJNI.releaseBigSightDataBufferLock(j);
        com.tencent.mm.plugin.mmsight.model.k.bQY();
        AppMethodBeat.o(76615);
        return false;
        if (i == 2)
        {
          this.fdd = new i(this.fcu.audioSampleRate, this.fcu.fzT, this.fcu.eRF);
          this.fdd.jn(this.fdn);
          paramInt = this.fdd.t(j, com.tencent.mm.plugin.sight.base.d.Zm(this.fca));
        }
      }
    }
    ab.i("MicroMsg.MMSightFFMpegRecorder", "initImpl used %sms", new Object[] { Long.valueOf(bo.av(l)) });
    AppMethodBeat.o(76615);
    return true;
  }
  
  private boolean ko(int paramInt)
  {
    AppMethodBeat.i(76608);
    if ((this.oJs != null) && (!this.oJs.fdx))
    {
      if (!this.oJs.fdu)
      {
        this.oJs.callback = null;
        this.oJs.fdw = true;
        this.oJs.fdv = true;
        com.tencent.mm.sdk.g.d.ysm.remove(this.oJs);
      }
      synchronized (this.oJs.fdy)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(paramInt);
        if (this.oJs.fds != paramInt) {
          SightVideoJNI.releaseBigSightDataBufferLock(this.oJs.fds);
        }
        AppMethodBeat.o(76608);
        return true;
      }
    }
    AppMethodBeat.o(76608);
    return false;
  }
  
  public final String Al()
  {
    AppMethodBeat.i(76612);
    String str = bo.bf(this.cqq, "");
    AppMethodBeat.o(76612);
    return str;
  }
  
  public final void G(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(76622);
    ab.i("MicroMsg.MMSightFFMpegRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    if ((this.fcm != null) && (this.fcm.oJP == d.c.oIO))
    {
      if (this.fde != null) {
        this.fde.G(paramInt1, paramInt2, paramInt3);
      }
      this.fcm.a(d.c.oIG);
    }
    AppMethodBeat.o(76622);
  }
  
  public final boolean XA()
  {
    return this.fcw;
  }
  
  public final c.a XB()
  {
    AppMethodBeat.i(76623);
    if (this.fdd != null)
    {
      c.a locala = this.fdd.bRl();
      AppMethodBeat.o(76623);
      return locala;
    }
    AppMethodBeat.o(76623);
    return null;
  }
  
  public final void XC()
  {
    this.fcC = false;
  }
  
  final void XE()
  {
    if (this.oJs != null) {
      this.oJs.fdv = true;
    }
  }
  
  final void XF()
  {
    AppMethodBeat.i(76618);
    ab.i("MicroMsg.MMSightFFMpegRecorder", "ashutest::pcm ready");
    if ((this.oJs != null) && (!this.oJs.fdx)) {
      ab.e("MicroMsg.MMSightFFMpegRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", new Object[] { this.oJs });
    }
    synchronized (this.oJs.fdy)
    {
      ko(this.oJs.fds);
      if (this.fcm.oJP != d.c.oIN)
      {
        ab.w("MicroMsg.MMSightFFMpegRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
        AppMethodBeat.o(76618);
        return;
      }
    }
    this.fcm.a(d.c.oIG);
    this.oJs = new l.a(this);
    this.oJs.fds = this.fdm;
    com.tencent.mm.sdk.g.d.f(this.oJs, "SightCustomAsyncMediaRecorder_encode_" + bo.yB());
    AppMethodBeat.o(76618);
  }
  
  public final long Xf()
  {
    AppMethodBeat.i(76613);
    long l = this.fde.UQ();
    AppMethodBeat.o(76613);
    return l;
  }
  
  public final String Xi()
  {
    return this.thumbPath;
  }
  
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
    AppMethodBeat.i(76619);
    int i = Math.round(this.fcb / 1000.0F);
    AppMethodBeat.o(76619);
    return i;
  }
  
  public final Point Xy()
  {
    AppMethodBeat.i(76620);
    Point localPoint = new Point(this.fck, this.fcl);
    AppMethodBeat.o(76620);
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
    AppMethodBeat.i(76625);
    ab.i("MicroMsg.MMSightFFMpegRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.fce = paramFloat;
    AppMethodBeat.o(76625);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(76617);
    ab.i("MicroMsg.MMSightFFMpegRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { this.fcm.oJP, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.fcx = paramBoolean;
    this.fcb = 0;
    this.fcy = paramInt2;
    this.fcm.a(d.c.oIF);
    String str = this.fca;
    if (this.oJs == null)
    {
      paramBoolean = true;
      if ((this.oJs != null) && (!this.oJs.fdx)) {
        break label179;
      }
    }
    label179:
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.MMSightFFMpegRecorder", "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]", new Object[] { str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if ((this.oJs == null) || (this.oJs.fdx)) {
        break label185;
      }
      ab.w("MicroMsg.MMSightFFMpegRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
      AppMethodBeat.o(76617);
      return -1;
      paramBoolean = false;
      break;
    }
    label185:
    if (bo.isNullOrNil(this.fca))
    {
      ab.e("MicroMsg.MMSightFFMpegRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(76617);
      return -1;
    }
    this.mFileName = com.tencent.mm.vfs.e.avM(this.fca);
    ab.i("MicroMsg.MMSightFFMpegRecorder", "mCurRecordPath: %s", new Object[] { this.fca });
    this.fcn = paramInt1;
    ab.i("MicroMsg.MMSightFFMpegRecorder", "start, cameraOrientation: %s", new Object[] { Integer.valueOf(this.fcn) });
    if (!this.eLc)
    {
      kl(paramInt1);
      this.eLc = true;
    }
    this.fde.start();
    if (!this.fdn)
    {
      paramInt1 = this.fdd.a(new l.5(this));
      ab.i("MicroMsg.MMSightFFMpegRecorder", "start aac recorder ret: %d", new Object[] { Integer.valueOf(paramInt1) });
      this.fdh = com.tencent.mm.sdk.g.d.ey("BigSightWriteCameraData", 0);
      this.fdh.start();
      this.fdi = new l.6(this, this.fdh.getLooper());
      this.fcw = false;
      if (paramInt1 == 0) {
        break label441;
      }
      this.fcm.a(d.c.oIM);
    }
    for (;;)
    {
      com.tencent.mm.plugin.mmsight.model.k.bQX();
      ab.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCapture");
      h.qsU.idkeyStat(440L, 1L, 1L, false);
      if (this.fdn) {
        XF();
      }
      AppMethodBeat.o(76617);
      return paramInt1;
      paramInt1 = 0;
      break;
      label441:
      this.fcm.a(d.c.oIN);
    }
  }
  
  public final void cG(boolean paramBoolean)
  {
    this.fdn = paramBoolean;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(76610);
    ab.i("MicroMsg.MMSightFFMpegRecorder", "cancel");
    this.fcm.a(d.c.oII);
    clear();
    this.fcm.a(d.c.oIJ);
    AppMethodBeat.o(76610);
  }
  
  public final void clear()
  {
    boolean bool2 = true;
    AppMethodBeat.i(76609);
    int i = -1;
    if (this.fde != null)
    {
      i = this.fde.oJG;
      if (i < 0)
      {
        ab.v("MicroMsg.MMSightFFMpegRecorder", "call clear, but bufID error");
        AppMethodBeat.o(76609);
        return;
      }
      this.fde.stop();
    }
    if (this.fdd != null) {
      this.fdd.a(null);
    }
    boolean bool1;
    if (this.oJs == null)
    {
      bool1 = true;
      if ((this.oJs == null) || (!this.oJs.fdw)) {
        break label177;
      }
    }
    for (;;)
    {
      ab.v("MicroMsg.MMSightFFMpegRecorder", "ashutest::clear bufID %d, encodeRunnable null ? %B, markCancel %B", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((i >= 0) && (!ko(i)))
      {
        SightVideoJNI.releaseRecorderBufferRef("clear");
        SightVideoJNI.releaseBigSightDataBufferLock(i);
      }
      if (this.fdh != null) {
        this.fdh.quit();
      }
      AppMethodBeat.o(76609);
      return;
      bool1 = false;
      break;
      label177:
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
    AppMethodBeat.i(76616);
    if (!this.eLc)
    {
      ab.i("MicroMsg.MMSightFFMpegRecorder", "preInit, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = kl(paramInt);
      this.eLc = true;
      ab.i("MicroMsg.MMSightFFMpegRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(76616);
      return bool;
    }
    AppMethodBeat.o(76616);
    return true;
  }
  
  public final void kn(int paramInt)
  {
    AppMethodBeat.i(76624);
    ab.i("MicroMsg.MMSightFFMpegRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.fcd = paramInt;
    AppMethodBeat.o(76624);
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
    AppMethodBeat.i(76621);
    ab.i("MicroMsg.MMSightFFMpegRecorder", "pause");
    if ((this.fcm != null) && (this.fcm.oJP == d.c.oIG)) {
      this.fcm.a(d.c.oIO);
    }
    AppMethodBeat.o(76621);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(76614);
    ab.i("MicroMsg.MMSightFFMpegRecorder", "reset");
    this.fcm.oJP = d.c.oIJ;
    this.fcw = false;
    if (this.fdd != null) {
      this.fdd.clear();
    }
    if (this.fde != null) {
      this.fde.clear();
    }
    clear();
    AppMethodBeat.o(76614);
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(76607);
    ab.i("MicroMsg.MMSightFFMpegRecorder", "setSize, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.fch = paramInt3;
    this.fci = paramInt4;
    this.fck = paramInt1;
    this.fcl = paramInt2;
    if (j.oJp.f(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      ab.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = bo.yB();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        j.oJp.O(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      ab.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(bo.av(l)) });
    }
    AppMethodBeat.o(76607);
  }
  
  public final void setFilePath(String paramString)
  {
    this.fca = paramString;
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void u(Runnable paramRunnable)
  {
    AppMethodBeat.i(76611);
    boolean bool1;
    if (this.oJs == null) {
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2;
      label34:
      boolean bool3;
      if ((this.oJs != null) && (this.oJs.fdu))
      {
        bool2 = true;
        if ((this.oJs == null) || (!this.oJs.fdv)) {
          break label145;
        }
        bool3 = true;
        ab.i("MicroMsg.MMSightFFMpegRecorder", "stop, encodeThread null ? %B, has trigger finish ? %B, has finish callback ? %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((this.oJs == null) || (!this.oJs.fdu)) {
          break;
        }
      }
      synchronized (this.oJs.fdy)
      {
        reset();
        al.d(paramRunnable);
        AppMethodBeat.o(76611);
        return;
        bool1 = false;
        continue;
        bool2 = false;
        break label34;
        label145:
        bool3 = false;
      }
    }
    ab.i("MicroMsg.MMSightFFMpegRecorder", "stopOnCameraDataThread: %s, writeCameraDataHandler: %s", new Object[] { Boolean.valueOf(this.fdo), this.fdi });
    if ((this.fdo) && (this.fdi != null))
    {
      this.fdi.post(new l.2(this, paramRunnable));
      AppMethodBeat.o(76611);
      return;
    }
    com.tencent.mm.sdk.g.d.post(new l.3(this, paramRunnable), "MMSightFFMpegRecorder_stop");
    AppMethodBeat.o(76611);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.l
 * JD-Core Version:    0.7.0.1
 */