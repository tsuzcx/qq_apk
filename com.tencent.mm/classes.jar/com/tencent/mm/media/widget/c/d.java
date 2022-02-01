package com.tencent.mm.media.widget.c;

import android.graphics.Point;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.d.g.c;
import com.tencent.mm.media.h.a.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.a.c.b;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.a.m;
import com.tencent.mm.plugin.mmsight.model.a.s;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.y;
import java.nio.IntBuffer;

public final class d
  implements b
{
  private boolean gAF;
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
  com.tencent.mm.media.h.a gCM;
  protected com.tencent.mm.plugin.mmsight.model.g gCW;
  final Object gCf;
  protected String gCg;
  protected int gCh;
  protected float gCi;
  private int gCj;
  private float gCk;
  protected com.tencent.mm.plugin.mmsight.model.a.c gCl;
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
  protected com.tencent.mm.media.d.g gDd;
  com.tencent.mm.media.i.a gDe;
  public d.g.a.b gDf;
  protected boolean ggj;
  protected int gmW;
  private EGLContext gwo;
  protected String mFileName;
  protected String md5;
  protected String thumbPath;
  
  private d(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(93409);
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
    this.gmW = -1;
    this.gCv = null;
    this.gCw = false;
    this.thumbPath = null;
    this.gCx = null;
    this.gCy = false;
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
    this.gAF = false;
    this.gCM = null;
    this.gwo = null;
    this.gDe = null;
    this.gCW = new com.tencent.mm.plugin.mmsight.model.g()
    {
      public final boolean W(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(93399);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          ad.e("MicroMsg.Media.X264MP4MuxRecorder", "preview callback data is null");
          AppMethodBeat.o(93399);
          return false;
        }
        if ((d.this.gCs.tFa == d.c.tDO) || (d.this.gCs.tFa == d.c.tDP))
        {
          if (d.this.gCs.tFa == d.c.tDP)
          {
            d.this.gCs.tFa = d.c.tDQ;
            ad.v("MicroMsg.Media.X264MP4MuxRecorder", "forward one more frame");
          }
          d.this.gCA.rt(1L);
          if (d.this.gCl != null) {
            d.this.gCl.cQe();
          }
          d.this.gCM.a(paramAnonymousArrayOfByte, System.nanoTime(), new d.g.a.b() {});
          d.this.gCz.rt(1L);
          AppMethodBeat.o(93399);
          return true;
        }
        AppMethodBeat.o(93399);
        return false;
      }
    };
    this.gDf = new d.g.a.b() {};
    this.gCB = paramVideoTransPara;
    this.gCn = paramVideoTransPara.width;
    this.gCo = paramVideoTransPara.height;
    this.gCs = new s();
    ad.d("MicroMsg.Media.X264MP4MuxRecorder", "create X264MP4MuxRecorder, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(this.gCn), Integer.valueOf(this.gCo) });
    AppMethodBeat.o(93409);
  }
  
  public d(VideoTransPara paramVideoTransPara, com.tencent.mm.media.i.a parama)
  {
    this(paramVideoTransPara);
    AppMethodBeat.i(93410);
    this.gwo = null;
    this.gDe = parama;
    this.gCM = new com.tencent.mm.media.h.a(parama);
    paramVideoTransPara = com.tencent.mm.media.j.d.gwr;
    com.tencent.mm.media.j.d.akK();
    AppMethodBeat.o(93410);
  }
  
  private void aok()
  {
    AppMethodBeat.i(93412);
    int i = this.gCn;
    int j = this.gCo;
    this.gCM.cR(i, j);
    this.gCM.mz(this.gCt);
    this.gCM.cS(this.gCq, this.gCr);
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "outputWidth: %s, outputHeight: %s, cameraPreviewWidth: %s, cameraPreviewHeight: %s, getDataRotate: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.gCq), Integer.valueOf(this.gCr), Integer.valueOf(this.gCt) });
    AppMethodBeat.o(93412);
  }
  
  private boolean mP(int paramInt)
  {
    AppMethodBeat.i(93411);
    long l = bt.GC();
    this.gCp = this.gCB.videoBitrate;
    if (this.gCn % 2 != 0) {
      this.gCn += 1;
    }
    if (this.gCo % 2 != 0) {
      this.gCo += 1;
    }
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "real width:%d, height:%d", new Object[] { Integer.valueOf(this.gCn), Integer.valueOf(this.gCo) });
    this.gmW = SightVideoJNI.initDataBufferForMMSightLock(this.gCq, this.gCr, paramInt, this.gCn, this.gCo, this.gCB.fps, this.gCp, this.gCB.hbY, 8, this.gCB.hbX, 23.0F, false, true, this.gCB.duration, false);
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "init, bufId: %s", new Object[] { Integer.valueOf(this.gmW) });
    if (this.gmW < 0)
    {
      ad.e("MicroMsg.Media.X264MP4MuxRecorder", "init failed!");
      AppMethodBeat.o(93411);
      return false;
    }
    this.gCt = paramInt;
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "mTargetRate " + this.gCp + "  videoParams.fps: " + this.gCB.fps + " mTargetHeight:" + this.gCo + " mTargetWidth:" + this.gCn);
    this.gDd = new com.tencent.mm.media.d.g(this.gmW, this.gCn, this.gCo);
    Object localObject = this.gCM;
    EGLContext localEGLContext = this.gwo;
    paramInt = this.gCn;
    int i = this.gCo;
    d.g.a.b local3 = new d.g.a.b() {};
    ad.i(((com.tencent.mm.media.h.a)localObject).TAG, ((com.tencent.mm.media.h.a)localObject).hashCode() + " initWithSize, eglContext: " + localEGLContext + ", callback: false, width:" + paramInt + ", height:" + i);
    ((com.tencent.mm.media.h.a)localObject).i((d.g.a.a)new a.c((com.tencent.mm.media.h.a)localObject, localEGLContext, paramInt, i, local3));
    this.gCM.gsm = new d.g.a.b()
    {
      private y aoC()
      {
        AppMethodBeat.i(93403);
        for (;;)
        {
          Object localObject2;
          com.tencent.mm.media.d.g localg;
          int i;
          int j;
          synchronized (d.this.gCf)
          {
            if (d.this.gDd != null)
            {
              ??? = d.this.gDe.akl();
              if (??? != null)
              {
                ((IntBuffer)???).position(0);
                localObject2 = new int[((IntBuffer)???).remaining()];
                ((IntBuffer)???).get((int[])localObject2);
                localg = d.this.gDd;
                i = d.this.gCn;
                j = d.this.gCo;
                k.h(localObject2, "data");
                if (localg.gmW >= 0) {
                  break label254;
                }
                ad.e("MicroMsg.X264TransEncoder", "writeRGBData error, buffId error");
              }
            }
            if ((d.this.gDd != null) && (d.this.gCs.tFa == d.c.tDQ))
            {
              d.this.gDd.stop(false);
              if (d.this.gCl != null) {
                d.this.gCl.a(new c.b()
                {
                  public final void aoA()
                  {
                    AppMethodBeat.i(93402);
                    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "aac stop finish");
                    AppMethodBeat.o(93402);
                  }
                });
              }
              d.this.gCM.release();
              localObject2 = d.this;
              ad.m("MicroMsg.Media.X264MP4MuxRecorder", "stopImpl", new Object[0]);
              com.tencent.mm.sdk.g.b.c(new d.6((d)localObject2), "X264MP4MuxRecorder_stop");
              if (d.this.gCs != null) {
                d.this.gCs.a(d.c.tDR);
              }
            }
            AppMethodBeat.o(93403);
            return null;
          }
          label254:
          synchronized (localg.stopLock)
          {
            localg.gqO.postToWorker((Runnable)new g.c(localg, i, j, (int[])localObject2));
            continue;
            localObject3 = finally;
            AppMethodBeat.o(93403);
            throw localObject3;
          }
        }
      }
    };
    aok();
    paramInt = this.gCB.audioSampleRate;
    i = this.gCB.audioBitrate;
    int j = this.gCB.gnH;
    if (this.gCB.hcu == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.gCl = new a(paramInt, i, j, com.tencent.mm.plugin.sight.base.b.Z(true, bool));
      this.gCl.nf(this.gCH);
      paramInt = this.gCl.D(this.gmW, e.anm(this.gCg));
      ad.i("MicroMsg.Media.X264MP4MuxRecorder", "initImpl used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
      if (paramInt == 0) {
        break;
      }
      localObject = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.akN();
      AppMethodBeat.o(93411);
      return false;
    }
    AppMethodBeat.o(93411);
    return true;
  }
  
  public final void C(Runnable paramRunnable)
  {
    AppMethodBeat.i(93415);
    synchronized (this.gCf)
    {
      this.gCG = paramRunnable;
      ad.i("MicroMsg.Media.X264MP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", new Object[] { paramRunnable });
      if ((this.gDd == null) || ((this.gCl == null) && (!this.gCJ)))
      {
        ad.i("MicroMsg.Media.X264MP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
        if (paramRunnable != null) {
          aq.f(paramRunnable);
        }
        AppMethodBeat.o(93415);
        return;
      }
      if ((this.gCs != null) && (this.gCs.tFa == d.c.tDR))
      {
        ad.i("MicroMsg.Media.X264MP4MuxRecorder", "stop, already in stop videoRecordStatus");
        if (this.gCl != null) {
          this.gCl.clear();
        }
        if (paramRunnable != null) {
          aq.f(paramRunnable);
        }
        AppMethodBeat.o(93415);
        return;
      }
      this.gCW = null;
      this.gCh = ((int)bt.aS(this.gDd.startTime));
      if (this.gCs != null)
      {
        paramRunnable = com.tencent.mm.media.j.d.gwr;
        com.tencent.mm.media.j.d.akO();
        this.gCs.a(d.c.tDP);
      }
      AppMethodBeat.o(93415);
      return;
    }
  }
  
  public final void J(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93425);
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    this.gCt = paramInt1;
    this.gCq = paramInt2;
    this.gCr = paramInt3;
    this.gCM.mz(this.gCt);
    aok();
    if ((this.gCs != null) && (this.gCs.tFa == d.c.tDW)) {
      this.gCs.a(d.c.tDO);
    }
    AppMethodBeat.o(93425);
  }
  
  public final String JS()
  {
    AppMethodBeat.i(93416);
    String str = bt.by(this.md5, "");
    AppMethodBeat.o(93416);
    return str;
  }
  
  public final void a(d.a parama)
  {
    this.gCF = parama;
  }
  
  public final void af(float paramFloat)
  {
    AppMethodBeat.i(93428);
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.gCk = paramFloat;
    AppMethodBeat.o(93428);
  }
  
  public final String anX()
  {
    return this.thumbPath;
  }
  
  public final void aoj() {}
  
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
    AppMethodBeat.i(93420);
    synchronized (this.gCf)
    {
      if (this.gDd != null)
      {
        long l = bt.aS(this.gDd.startTime);
        AppMethodBeat.o(93420);
        return l;
      }
      AppMethodBeat.o(93420);
      return 0L;
    }
  }
  
  public final d.c aoq()
  {
    return this.gCs.tFa;
  }
  
  public final int aor()
  {
    AppMethodBeat.i(93422);
    int i = Math.round(this.gCh / 1000.0F);
    AppMethodBeat.o(93422);
    return i;
  }
  
  public final Point aos()
  {
    AppMethodBeat.i(93423);
    Point localPoint = new Point(this.gCq, this.gCr);
    AppMethodBeat.o(93423);
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
    AppMethodBeat.i(93426);
    if (this.gCl != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.gCl.cQf();
      AppMethodBeat.o(93426);
      return locala;
    }
    AppMethodBeat.o(93426);
    return null;
  }
  
  public final void aox()
  {
    this.gCI = false;
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(93414);
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.gCz.reset();
    this.gCh = 0;
    this.gCA.reset();
    this.gCw = false;
    this.gBu = paramBoolean;
    this.gCE = paramInt2;
    this.gCs.a(d.c.tDN);
    if (bt.isNullOrNil(this.gCg))
    {
      ad.e("MicroMsg.Media.X264MP4MuxRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(93414);
      return -1;
    }
    for (;;)
    {
      try
      {
        this.mFileName = i.aMS(this.gCg);
        String str = i.aMQ(this.gCg);
        ??? = str;
        if (!str.endsWith("/")) {
          ??? = str + "/";
        }
        this.gCv = ((String)??? + "tempRotate.mp4");
        ad.i("MicroMsg.Media.X264MP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", new Object[] { this.gCg, this.gCv });
        this.gCt = paramInt1;
        if (!this.ggj)
        {
          mP(paramInt1);
          this.ggj = true;
        }
        this.gCs.a(d.c.tDV);
      }
      catch (Exception localException)
      {
        synchronized (this.gCf)
        {
          this.gDd.start();
          if ((this.gCJ) || (this.gCH)) {
            break label390;
          }
          paramInt1 = this.gCl.a(new com.tencent.mm.plugin.mmsight.model.a.c.a()
          {
            public final void aoB()
            {
              AppMethodBeat.i(93405);
              ad.i("MicroMsg.Media.X264MP4MuxRecorder", "onPcmReady");
              if (d.this.aoq() != d.c.tDV)
              {
                ad.w("MicroMsg.Media.X264MP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
                AppMethodBeat.o(93405);
                return;
              }
              d.this.gCs.a(d.c.tDO);
              AppMethodBeat.o(93405);
            }
          });
          ad.i("MicroMsg.Media.X264MP4MuxRecorder", "start aacRecorder ret: %s", new Object[] { Integer.valueOf(paramInt1) });
          this.gCD = false;
          if (paramInt1 != 0)
          {
            this.gCs.a(d.c.tDU);
            AppMethodBeat.o(93414);
            return paramInt1;
            localException = localException;
            ad.e("MicroMsg.Media.X264MP4MuxRecorder", "retrieve file name error: %s", new Object[] { localException.getMessage() });
          }
        }
      }
      continue;
      label390:
      ad.i("MicroMsg.Media.X264MP4MuxRecorder", "start yuvRecorder with mute");
      this.gCs.a(d.c.tDO);
      this.gCD = false;
      paramInt1 = 0;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(93417);
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "cancel record");
    synchronized (this.gCf)
    {
      if ((this.gDd == null) || ((this.gCl == null) && (!this.gCJ)))
      {
        ad.e("MicroMsg.Media.X264MP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
        AppMethodBeat.o(93417);
        return;
      }
      this.gCs.a(d.c.tDQ);
      this.gDd.stop(true);
      if (this.gCl != null) {
        this.gCl.a(new c.b()
        {
          public final void aoA()
          {
            AppMethodBeat.i(93408);
            ad.i("MicroMsg.Media.X264MP4MuxRecorder", "aac stop finish");
            AppMethodBeat.o(93408);
          }
        });
      }
      if (this.gmW >= 0)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(this.gmW);
        this.gCs.a(d.c.tDR);
        reset();
        AppMethodBeat.o(93417);
        return;
      }
      ad.e("MicroMsg.Media.X264MP4MuxRecorder", "why buf id < 0 ? %d", new Object[] { Integer.valueOf(this.gmW) });
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(93418);
    try
    {
      ad.i("MicroMsg.Media.X264MP4MuxRecorder", "clear");
      if (this.gCl != null) {
        this.gCl.clear();
      }
      if (this.gCM != null) {
        this.gCM.release();
      }
      if (this.gmW >= 0) {
        SightVideoJNI.releaseBigSightDataBufferLock(this.gmW);
      }
      AppMethodBeat.o(93418);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.Media.X264MP4MuxRecorder", localException, "clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(93418);
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
    AppMethodBeat.i(93413);
    if (!this.ggj)
    {
      ad.i("MicroMsg.Media.X264MP4MuxRecorder", "preInit, cameraOrientation");
      boolean bool = mP(paramInt);
      this.ggj = true;
      ad.i("MicroMsg.Media.X264MP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(93413);
      return bool;
    }
    com.tencent.mm.media.j.d locald = com.tencent.mm.media.j.d.gwr;
    com.tencent.mm.media.j.d.akL();
    AppMethodBeat.o(93413);
    return true;
  }
  
  public final void mR(int paramInt)
  {
    AppMethodBeat.i(93427);
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.gCj = paramInt;
    AppMethodBeat.o(93427);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(93424);
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "pause");
    if ((this.gCs != null) && (this.gCs.tFa == d.c.tDO)) {
      this.gCs.a(d.c.tDW);
    }
    AppMethodBeat.o(93424);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(93419);
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", new Object[] { this.gDd, this.gCl, this.gCC });
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s", new Object[] { this.gDd, this.gCl });
    synchronized (this.gCf)
    {
      this.gDd = null;
      this.gCl = null;
      this.gCC = null;
      this.ggj = false;
      this.gCD = false;
      AppMethodBeat.o(93419);
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
    AppMethodBeat.i(93421);
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    int i = paramInt3;
    if (paramInt3 % 16 != 0) {
      i = com.tencent.mm.plugin.mmsight.d.GN(paramInt3);
    }
    paramInt3 = paramInt4;
    if (paramInt4 % 16 != 0) {
      paramInt3 = com.tencent.mm.plugin.mmsight.d.GN(paramInt4);
    }
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt3) });
    this.gCq = paramInt1;
    this.gCr = paramInt2;
    if (j.tEA.g(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      ad.i("MicroMsg.Media.X264MP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = bt.GC();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        j.tEA.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      ad.i("MicroMsg.Media.X264MP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
    }
    AppMethodBeat.o(93421);
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
 * Qualified Name:     com.tencent.mm.media.widget.c.d
 * JD-Core Version:    0.7.0.1
 */