package com.tencent.mm.media.widget.b;

import android.graphics.Point;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.media.d.g;
import com.tencent.mm.media.g.a.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.a.m;
import com.tencent.mm.plugin.mmsight.model.a.s;
import com.tencent.mm.plugin.mmsight.model.f;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public final class d
  implements b
{
  protected String cqq;
  protected boolean eLc;
  protected int eRm;
  private EGLContext eZz;
  final Object fbZ;
  protected Runnable fcA;
  protected boolean fcB;
  protected boolean fcC;
  protected boolean fcD;
  com.tencent.mm.media.g.a fcG;
  protected f fcP;
  protected g fcW;
  com.tencent.mm.media.h.a fcX;
  public a.f.a.b fcY;
  protected String fca;
  protected int fcb;
  protected float fcc;
  private int fcd;
  private float fce;
  protected com.tencent.mm.plugin.mmsight.model.a.c fcf;
  protected int fch;
  protected int fci;
  protected int fcj;
  protected int fck;
  protected int fcl;
  protected s fcm;
  protected int fcn;
  protected String fco;
  protected boolean fcp;
  protected String fcq;
  protected boolean fcr;
  protected com.tencent.mm.plugin.mmsight.model.b fcs;
  protected com.tencent.mm.plugin.mmsight.model.b fct;
  protected VideoTransPara fcu;
  protected m fcv;
  protected boolean fcw;
  protected boolean fcx;
  protected int fcy;
  protected d.a fcz;
  private boolean isRecording;
  protected String mFileName;
  protected String thumbPath;
  
  private d(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(12788);
    this.fbZ = new Object();
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
    this.eRm = -1;
    this.fco = null;
    this.fcp = false;
    this.thumbPath = null;
    this.fcq = null;
    this.fcr = false;
    this.fcs = new com.tencent.mm.plugin.mmsight.model.b("yuvRecorderWriteData");
    this.fct = new com.tencent.mm.plugin.mmsight.model.b("frameCountCallback");
    this.eLc = false;
    this.fcw = false;
    this.cqq = "";
    this.fcx = false;
    this.fcy = 0;
    this.fcA = null;
    this.fcB = false;
    this.fcC = true;
    this.fcD = false;
    this.isRecording = false;
    this.fcG = null;
    this.eZz = null;
    this.fcX = null;
    this.fcP = new d.1(this);
    this.fcY = new d.2(this);
    this.fcu = paramVideoTransPara;
    this.fch = paramVideoTransPara.width;
    this.fci = paramVideoTransPara.height;
    this.fcm = new s();
    ab.d("MicroMsg.Media.X264MP4MuxRecorder", "create X264MP4MuxRecorder, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(this.fch), Integer.valueOf(this.fci) });
    AppMethodBeat.o(12788);
  }
  
  public d(VideoTransPara paramVideoTransPara, com.tencent.mm.media.h.a parama)
  {
    this(paramVideoTransPara);
    AppMethodBeat.i(12789);
    this.eZz = null;
    this.fcX = parama;
    this.fcG = new com.tencent.mm.media.g.a(parama);
    paramVideoTransPara = com.tencent.mm.media.i.c.eZC;
    com.tencent.mm.media.i.c.Vx();
    AppMethodBeat.o(12789);
  }
  
  private void Xr()
  {
    AppMethodBeat.i(12791);
    int i = this.fch;
    int j = this.fci;
    this.fcG.cl(i, j);
    this.fcG.jX(this.fcn);
    this.fcG.cm(this.fck, this.fcl);
    ab.i("MicroMsg.Media.X264MP4MuxRecorder", "outputWidth: %s, outputHeight: %s, cameraPreviewWidth: %s, cameraPreviewHeight: %s, getDataRotate: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.fck), Integer.valueOf(this.fcl), Integer.valueOf(this.fcn) });
    AppMethodBeat.o(12791);
  }
  
  private boolean kl(int paramInt)
  {
    AppMethodBeat.i(12790);
    long l = bo.yB();
    this.fcj = this.fcu.videoBitrate;
    this.eRm = SightVideoJNI.initDataBufferForMMSightLock(this.fck, this.fcl, paramInt, this.fch, this.fci, this.fcu.fps, this.fcj, this.fcu.fzW, 8, this.fcu.fzV, 23.0F, false, true, this.fcu.duration, false);
    ab.i("MicroMsg.Media.X264MP4MuxRecorder", "init, bufId: %s", new Object[] { Integer.valueOf(this.eRm) });
    if (this.eRm < 0)
    {
      ab.e("MicroMsg.Media.X264MP4MuxRecorder", "init failed!");
      AppMethodBeat.o(12790);
      return false;
    }
    this.fcn = paramInt;
    Object localObject = new com.tencent.mm.media.b.c();
    ab.i("MicroMsg.Media.X264MP4MuxRecorder", "mTargetRate " + this.fcj + "  videoParams.fps: " + this.fcu.fps + " mTargetHeight:" + this.fci + " mTargetWidth:" + this.fch);
    ((com.tencent.mm.media.b.c)localObject).bitrate = this.fcj;
    ((com.tencent.mm.media.b.c)localObject).eRw = this.fcu.fps;
    ((com.tencent.mm.media.b.c)localObject).eRv = this.fci;
    ((com.tencent.mm.media.b.c)localObject).eRu = this.fch;
    this.fcW = new g(this.eRm, this.fch, this.fci);
    localObject = this.fcG;
    EGLContext localEGLContext = this.eZz;
    paramInt = this.fch;
    int i = this.fci;
    d.3 local3 = new d.3(this);
    ab.i(((com.tencent.mm.media.g.a)localObject).TAG, ((com.tencent.mm.media.g.a)localObject).hashCode() + " initWithSize, eglContext: " + localEGLContext + ", callback: false, width:" + paramInt + ", height:" + i);
    ((com.tencent.mm.media.g.a)localObject).d((a.f.a.a)new a.c((com.tencent.mm.media.g.a)localObject, localEGLContext, paramInt, i, local3));
    this.fcG.eVT = new d.4(this);
    Xr();
    this.fcf = new a(this.fcu.audioSampleRate, this.fcu.fzT, this.fcu.eRF);
    this.fcf.jn(this.fcB);
    paramInt = this.fcf.t(this.eRm, com.tencent.mm.plugin.sight.base.d.Zm(this.fca));
    ab.i("MicroMsg.Media.X264MP4MuxRecorder", "initImpl used %sms", new Object[] { Long.valueOf(bo.av(l)) });
    if (paramInt != 0)
    {
      localObject = com.tencent.mm.media.i.c.eZC;
      com.tencent.mm.media.i.c.VA();
      AppMethodBeat.o(12790);
      return false;
    }
    AppMethodBeat.o(12790);
    return true;
  }
  
  public final String Al()
  {
    AppMethodBeat.i(12795);
    String str = bo.bf(this.cqq, "");
    AppMethodBeat.o(12795);
    return str;
  }
  
  public final void G(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(12804);
    ab.i("MicroMsg.Media.X264MP4MuxRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    this.fcn = paramInt1;
    this.fck = paramInt2;
    this.fcl = paramInt3;
    this.fcG.jX(this.fcn);
    Xr();
    if ((this.fcm != null) && (this.fcm.oJP == d.c.oIO)) {
      this.fcm.a(d.c.oIG);
    }
    AppMethodBeat.o(12804);
  }
  
  public final boolean XA()
  {
    return this.fcw;
  }
  
  public final c.a XB()
  {
    AppMethodBeat.i(12805);
    if (this.fcf != null)
    {
      c.a locala = this.fcf.bRl();
      AppMethodBeat.o(12805);
      return locala;
    }
    AppMethodBeat.o(12805);
    return null;
  }
  
  public final void XC()
  {
    this.fcC = false;
  }
  
  public final long Xf()
  {
    AppMethodBeat.i(12799);
    synchronized (this.fbZ)
    {
      if (this.fcW != null)
      {
        long l = bo.av(this.fcW.startTime);
        AppMethodBeat.o(12799);
        return l;
      }
      AppMethodBeat.o(12799);
      return 0L;
    }
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
    AppMethodBeat.i(12801);
    int i = Math.round(this.fcb / 1000.0F);
    AppMethodBeat.o(12801);
    return i;
  }
  
  public final Point Xy()
  {
    AppMethodBeat.i(12802);
    Point localPoint = new Point(this.fck, this.fcl);
    AppMethodBeat.o(12802);
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
    AppMethodBeat.i(12807);
    ab.i("MicroMsg.Media.X264MP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.fce = paramFloat;
    AppMethodBeat.o(12807);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(12793);
    ab.i("MicroMsg.Media.X264MP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.fcs.reset();
    this.fcb = 0;
    this.fct.reset();
    this.fcp = false;
    this.fcx = paramBoolean;
    this.fcy = paramInt2;
    this.fcm.a(d.c.oIF);
    if (bo.isNullOrNil(this.fca))
    {
      ab.e("MicroMsg.Media.X264MP4MuxRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(12793);
      return -1;
    }
    for (;;)
    {
      try
      {
        this.mFileName = e.avM(this.fca);
        String str = e.avK(this.fca);
        ??? = str;
        if (!str.endsWith("/")) {
          ??? = str + "/";
        }
        this.fco = ((String)??? + "tempRotate.mp4");
        ab.i("MicroMsg.Media.X264MP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", new Object[] { this.fca, this.fco });
        this.fcn = paramInt1;
        if (!this.eLc)
        {
          kl(paramInt1);
          this.eLc = true;
        }
        this.fcm.a(d.c.oIN);
      }
      catch (Exception localException)
      {
        synchronized (this.fbZ)
        {
          this.fcW.start();
          if ((this.fcD) || (this.fcB)) {
            break label390;
          }
          paramInt1 = this.fcf.a(new d.5(this));
          ab.i("MicroMsg.Media.X264MP4MuxRecorder", "start aacRecorder ret: %s", new Object[] { Integer.valueOf(paramInt1) });
          this.fcw = false;
          if (paramInt1 != 0)
          {
            this.fcm.a(d.c.oIM);
            AppMethodBeat.o(12793);
            return paramInt1;
            localException = localException;
            ab.e("MicroMsg.Media.X264MP4MuxRecorder", "retrieve file name error: %s", new Object[] { localException.getMessage() });
          }
        }
      }
      continue;
      label390:
      ab.i("MicroMsg.Media.X264MP4MuxRecorder", "start yuvRecorder with mute");
      this.fcm.a(d.c.oIG);
      this.fcw = false;
      paramInt1 = 0;
    }
  }
  
  public final void cG(boolean paramBoolean)
  {
    this.fcB = paramBoolean;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(12796);
    ab.i("MicroMsg.Media.X264MP4MuxRecorder", "cancel record");
    synchronized (this.fbZ)
    {
      if ((this.fcW == null) || ((this.fcf == null) && (!this.fcD)))
      {
        ab.e("MicroMsg.Media.X264MP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
        AppMethodBeat.o(12796);
        return;
      }
      this.fcm.a(d.c.oII);
      this.fcW.stop(true);
      if (this.fcf != null) {
        this.fcf.a(new d.7(this));
      }
      if (this.eRm >= 0)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(this.eRm);
        this.fcm.a(d.c.oIJ);
        reset();
        AppMethodBeat.o(12796);
        return;
      }
      ab.e("MicroMsg.Media.X264MP4MuxRecorder", "why buf id < 0 ? %d", new Object[] { Integer.valueOf(this.eRm) });
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(12797);
    try
    {
      ab.i("MicroMsg.Media.X264MP4MuxRecorder", "clear");
      if (this.fcf != null) {
        this.fcf.clear();
      }
      if (this.fcG != null) {
        this.fcG.release();
      }
      if (this.eRm >= 0) {
        SightVideoJNI.releaseBigSightDataBufferLock(this.eRm);
      }
      AppMethodBeat.o(12797);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.Media.X264MP4MuxRecorder", localException, "clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(12797);
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
    AppMethodBeat.i(12792);
    if (!this.eLc)
    {
      ab.i("MicroMsg.Media.X264MP4MuxRecorder", "preInit, cameraOrientation");
      boolean bool = kl(paramInt);
      this.eLc = true;
      ab.i("MicroMsg.Media.X264MP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(12792);
      return bool;
    }
    com.tencent.mm.media.i.c localc = com.tencent.mm.media.i.c.eZC;
    com.tencent.mm.media.i.c.Vy();
    AppMethodBeat.o(12792);
    return true;
  }
  
  public final void kn(int paramInt)
  {
    AppMethodBeat.i(12806);
    ab.i("MicroMsg.Media.X264MP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.fcd = paramInt;
    AppMethodBeat.o(12806);
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
    AppMethodBeat.i(12803);
    ab.i("MicroMsg.Media.X264MP4MuxRecorder", "pause");
    if ((this.fcm != null) && (this.fcm.oJP == d.c.oIG)) {
      this.fcm.a(d.c.oIO);
    }
    AppMethodBeat.o(12803);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(12798);
    ab.i("MicroMsg.Media.X264MP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", new Object[] { this.fcW, this.fcf, this.fcv });
    ab.i("MicroMsg.Media.X264MP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s", new Object[] { this.fcW, this.fcf });
    synchronized (this.fbZ)
    {
      this.fcW = null;
      this.fcf = null;
      this.fcv = null;
      this.eLc = false;
      this.fcw = false;
      AppMethodBeat.o(12798);
      return;
    }
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(12800);
    ab.i("MicroMsg.Media.X264MP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    int i = paramInt3;
    if (paramInt3 % 16 != 0) {
      i = com.tencent.mm.plugin.mmsight.d.zn(paramInt3);
    }
    paramInt3 = paramInt4;
    if (paramInt4 % 16 != 0) {
      paramInt3 = com.tencent.mm.plugin.mmsight.d.zn(paramInt4);
    }
    ab.i("MicroMsg.Media.X264MP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt3) });
    this.fck = paramInt1;
    this.fcl = paramInt2;
    if (j.oJp.f(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      ab.i("MicroMsg.Media.X264MP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = bo.yB();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        j.oJp.O(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      ab.i("MicroMsg.Media.X264MP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(bo.av(l)) });
    }
    AppMethodBeat.o(12800);
  }
  
  public final void setFilePath(String paramString)
  {
    this.fca = paramString;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.fcD = paramBoolean;
  }
  
  public final void u(Runnable paramRunnable)
  {
    AppMethodBeat.i(12794);
    synchronized (this.fbZ)
    {
      this.fcA = paramRunnable;
      ab.i("MicroMsg.Media.X264MP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", new Object[] { paramRunnable });
      if ((this.fcW == null) || ((this.fcf == null) && (!this.fcD)))
      {
        ab.i("MicroMsg.Media.X264MP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
        if (paramRunnable != null) {
          al.d(paramRunnable);
        }
        AppMethodBeat.o(12794);
        return;
      }
      if ((this.fcm != null) && (this.fcm.oJP == d.c.oIJ))
      {
        ab.i("MicroMsg.Media.X264MP4MuxRecorder", "stop, already in stop videoRecordStatus");
        if (this.fcf != null) {
          this.fcf.clear();
        }
        if (paramRunnable != null) {
          al.d(paramRunnable);
        }
        AppMethodBeat.o(12794);
        return;
      }
      this.fcP = null;
      this.fcb = ((int)bo.av(this.fcW.startTime));
      if (this.fcm != null)
      {
        paramRunnable = com.tencent.mm.media.i.c.eZC;
        com.tencent.mm.media.i.c.VB();
        this.fcm.a(d.c.oIH);
      }
      AppMethodBeat.o(12794);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.d
 * JD-Core Version:    0.7.0.1
 */