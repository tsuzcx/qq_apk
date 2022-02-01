package com.tencent.mm.media.widget.c;

import android.graphics.Point;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.e.g.c;
import com.tencent.mm.media.i.a.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.a.c.b;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.a.n;
import com.tencent.mm.plugin.mmsight.model.a.t;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.z;
import java.nio.IntBuffer;

public final class d
  implements b
{
  protected int bufId;
  protected boolean gHg;
  private EGLContext hrF;
  private boolean hvU;
  protected boolean hwM;
  protected String hxA;
  protected int hxB;
  protected float hxC;
  private int hxD;
  private float hxE;
  protected com.tencent.mm.plugin.mmsight.model.a.c hxF;
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
  final Object hxz;
  protected com.tencent.mm.media.e.g hyA;
  com.tencent.mm.media.j.a hyB;
  public d.g.a.b hyC;
  protected Runnable hya;
  protected boolean hyb;
  protected boolean hyc;
  protected boolean hyd;
  com.tencent.mm.media.i.a hyg;
  protected com.tencent.mm.plugin.mmsight.model.g hyr;
  protected String mFileName;
  protected String md5;
  protected String thumbPath;
  
  private d(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(93409);
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
    this.bufId = -1;
    this.hxP = null;
    this.hxQ = false;
    this.thumbPath = null;
    this.hxR = null;
    this.hxS = false;
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
    this.hvU = false;
    this.hyg = null;
    this.hrF = null;
    this.hyB = null;
    this.hyr = new com.tencent.mm.plugin.mmsight.model.g()
    {
      public final boolean U(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(93399);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          ae.e("MicroMsg.Media.X264MP4MuxRecorder", "preview callback data is null");
          AppMethodBeat.o(93399);
          return false;
        }
        if ((d.this.hxM.wcI == d.c.wbs) || (d.this.hxM.wcI == d.c.wbt))
        {
          if (d.this.hxM.wcI == d.c.wbt)
          {
            d.this.hxM.wcI = d.c.wbu;
            ae.v("MicroMsg.Media.X264MP4MuxRecorder", "forward one more frame");
          }
          d.this.hxU.yz(1L);
          if (d.this.hxF != null) {
            d.this.hxF.dqg();
          }
          d.this.hyg.a(paramAnonymousArrayOfByte, System.nanoTime(), new d.g.a.b() {});
          d.this.hxT.yz(1L);
          AppMethodBeat.o(93399);
          return true;
        }
        AppMethodBeat.o(93399);
        return false;
      }
    };
    this.hyC = new d.g.a.b() {};
    this.hxV = paramVideoTransPara;
    this.hxH = paramVideoTransPara.width;
    this.hxI = paramVideoTransPara.height;
    this.hxM = new t();
    ae.d("MicroMsg.Media.X264MP4MuxRecorder", "create X264MP4MuxRecorder, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(this.hxH), Integer.valueOf(this.hxI) });
    AppMethodBeat.o(93409);
  }
  
  public d(VideoTransPara paramVideoTransPara, com.tencent.mm.media.j.a parama)
  {
    this(paramVideoTransPara);
    AppMethodBeat.i(93410);
    this.hrF = null;
    this.hyB = parama;
    this.hyg = new com.tencent.mm.media.i.a(parama);
    paramVideoTransPara = com.tencent.mm.media.k.d.hrI;
    com.tencent.mm.media.k.d.auG();
    AppMethodBeat.o(93410);
  }
  
  private void ayd()
  {
    AppMethodBeat.i(93412);
    int i = this.hxH;
    int j = this.hxI;
    this.hyg.cS(i, j);
    this.hyg.ng(this.hxN);
    this.hyg.cU(this.hxK, this.hxL);
    ae.i("MicroMsg.Media.X264MP4MuxRecorder", "outputWidth: %s, outputHeight: %s, cameraPreviewWidth: %s, cameraPreviewHeight: %s, getDataRotate: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.hxK), Integer.valueOf(this.hxL), Integer.valueOf(this.hxN) });
    AppMethodBeat.o(93412);
  }
  
  private boolean of(int paramInt)
  {
    AppMethodBeat.i(93411);
    long l = bu.HQ();
    this.hxJ = this.hxV.videoBitrate;
    if (this.hxH % 2 != 0) {
      this.hxH += 1;
    }
    if (this.hxI % 2 != 0) {
      this.hxI += 1;
    }
    ae.i("MicroMsg.Media.X264MP4MuxRecorder", "real width:%d, height:%d", new Object[] { Integer.valueOf(this.hxH), Integer.valueOf(this.hxI) });
    this.bufId = SightVideoJNI.initDataBufferForMMSightLock(this.hxK, this.hxL, paramInt, this.hxH, this.hxI, this.hxV.fps, this.hxJ, this.hxV.hXX, 8, this.hxV.hXW, 23.0F, false, true, this.hxV.duration, false);
    ae.i("MicroMsg.Media.X264MP4MuxRecorder", "init, bufId: %s", new Object[] { Integer.valueOf(this.bufId) });
    if (this.bufId < 0)
    {
      ae.e("MicroMsg.Media.X264MP4MuxRecorder", "init failed!");
      AppMethodBeat.o(93411);
      return false;
    }
    this.hxN = paramInt;
    ae.i("MicroMsg.Media.X264MP4MuxRecorder", "mTargetRate " + this.hxJ + "  videoParams.fps: " + this.hxV.fps + " mTargetHeight:" + this.hxI + " mTargetWidth:" + this.hxH);
    this.hyA = new com.tencent.mm.media.e.g(this.bufId, this.hxH, this.hxI);
    Object localObject = this.hyg;
    EGLContext localEGLContext = this.hrF;
    paramInt = this.hxH;
    int i = this.hxI;
    d.g.a.b local3 = new d.g.a.b() {};
    ae.i(((com.tencent.mm.media.i.a)localObject).TAG, ((com.tencent.mm.media.i.a)localObject).hashCode() + " initWithSize, eglContext: " + localEGLContext + ", callback: false, width:" + paramInt + ", height:" + i);
    ((com.tencent.mm.media.i.a)localObject).j((d.g.a.a)new a.c((com.tencent.mm.media.i.a)localObject, localEGLContext, paramInt, i, local3));
    this.hyg.hnI = new d.g.a.b()
    {
      private z ayv()
      {
        AppMethodBeat.i(93403);
        for (;;)
        {
          Object localObject2;
          com.tencent.mm.media.e.g localg;
          int i;
          int j;
          synchronized (d.this.hxz)
          {
            if (d.this.hyA != null)
            {
              ??? = d.this.hyB.auj();
              if (??? != null)
              {
                ((IntBuffer)???).position(0);
                localObject2 = new int[((IntBuffer)???).remaining()];
                ((IntBuffer)???).get((int[])localObject2);
                localg = d.this.hyA;
                i = d.this.hxH;
                j = d.this.hxI;
                p.h(localObject2, "data");
                if (localg.bufId >= 0) {
                  break label254;
                }
                ae.e("MicroMsg.X264TransEncoder", "writeRGBData error, buffId error");
              }
            }
            if ((d.this.hyA != null) && (d.this.hxM.wcI == d.c.wbu))
            {
              d.this.hyA.stop(false);
              if (d.this.hxF != null) {
                d.this.hxF.a(new d.4.1(this));
              }
              d.this.hyg.release();
              localObject2 = d.this;
              ae.m("MicroMsg.Media.X264MP4MuxRecorder", "stopImpl", new Object[0]);
              com.tencent.mm.sdk.g.b.c(new d.6((d)localObject2), "X264MP4MuxRecorder_stop");
              if (d.this.hxM != null) {
                d.this.hxM.a(d.c.wbv);
              }
            }
            AppMethodBeat.o(93403);
            return null;
          }
          label254:
          synchronized (localg.stopLock)
          {
            localg.hmC.postToWorker((Runnable)new g.c(localg, i, j, (int[])localObject2));
            continue;
            localObject3 = finally;
            AppMethodBeat.o(93403);
            throw localObject3;
          }
        }
      }
    };
    ayd();
    paramInt = this.hxV.audioSampleRate;
    i = this.hxV.audioBitrate;
    int j = this.hxV.audioChannelCount;
    if (this.hxV.hYu == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.hxF = new a(paramInt, i, j, com.tencent.mm.plugin.sight.base.b.af(true, bool));
      this.hxF.ox(this.hyb);
      paramInt = this.hxF.E(this.bufId, e.ayL(this.hxA));
      ae.i("MicroMsg.Media.X264MP4MuxRecorder", "initImpl used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
      if (paramInt == 0) {
        break;
      }
      localObject = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.auJ();
      AppMethodBeat.o(93411);
      return false;
    }
    AppMethodBeat.o(93411);
    return true;
  }
  
  public final void B(Runnable paramRunnable)
  {
    AppMethodBeat.i(93415);
    synchronized (this.hxz)
    {
      this.hya = paramRunnable;
      ae.i("MicroMsg.Media.X264MP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", new Object[] { paramRunnable });
      if ((this.hyA == null) || ((this.hxF == null) && (!this.hyd)))
      {
        ae.i("MicroMsg.Media.X264MP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
        if (paramRunnable != null) {
          ar.f(paramRunnable);
        }
        AppMethodBeat.o(93415);
        return;
      }
      if ((this.hxM != null) && (this.hxM.wcI == d.c.wbv))
      {
        ae.i("MicroMsg.Media.X264MP4MuxRecorder", "stop, already in stop videoRecordStatus");
        if (this.hxF != null) {
          this.hxF.clear();
        }
        if (paramRunnable != null) {
          ar.f(paramRunnable);
        }
        AppMethodBeat.o(93415);
        return;
      }
      this.hyr = null;
      this.hxB = ((int)bu.aO(this.hyA.startTime));
      if (this.hxM != null)
      {
        paramRunnable = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.auK();
        this.hxM.a(d.c.wbt);
      }
      AppMethodBeat.o(93415);
      return;
    }
  }
  
  public final void L(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93425);
    ae.i("MicroMsg.Media.X264MP4MuxRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    this.hxN = paramInt1;
    this.hxK = paramInt2;
    this.hxL = paramInt3;
    this.hyg.ng(this.hxN);
    ayd();
    if ((this.hxM != null) && (this.hxM.wcI == d.c.wbA)) {
      this.hxM.a(d.c.wbs);
    }
    AppMethodBeat.o(93425);
  }
  
  public final String Lj()
  {
    AppMethodBeat.i(93416);
    String str = bu.bI(this.md5, "");
    AppMethodBeat.o(93416);
    return str;
  }
  
  public final void a(d.a parama)
  {
    this.hxZ = parama;
  }
  
  public final void am(float paramFloat)
  {
    AppMethodBeat.i(93428);
    ae.i("MicroMsg.Media.X264MP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.hxE = paramFloat;
    AppMethodBeat.o(93428);
  }
  
  public final boolean aoA()
  {
    return this.hwM;
  }
  
  public final String axP()
  {
    return this.thumbPath;
  }
  
  public final void ayc() {}
  
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
    AppMethodBeat.i(93420);
    synchronized (this.hxz)
    {
      if (this.hyA != null)
      {
        long l = bu.aO(this.hyA.startTime);
        AppMethodBeat.o(93420);
        return l;
      }
      AppMethodBeat.o(93420);
      return 0L;
    }
  }
  
  public final d.c ayj()
  {
    return this.hxM.wcI;
  }
  
  public final int ayk()
  {
    AppMethodBeat.i(93422);
    int i = Math.round(this.hxB / 1000.0F);
    AppMethodBeat.o(93422);
    return i;
  }
  
  public final Point ayl()
  {
    AppMethodBeat.i(93423);
    Point localPoint = new Point(this.hxK, this.hxL);
    AppMethodBeat.o(93423);
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
    AppMethodBeat.i(93426);
    if (this.hxF != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.hxF.dqh();
      AppMethodBeat.o(93426);
      return locala;
    }
    AppMethodBeat.o(93426);
    return null;
  }
  
  public final void ayp()
  {
    this.hyc = false;
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(93414);
    ae.i("MicroMsg.Media.X264MP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.hxT.reset();
    this.hxB = 0;
    this.hxU.reset();
    this.hxQ = false;
    this.hwM = paramBoolean;
    this.hxY = paramInt2;
    this.hxM.a(d.c.wbr);
    if (bu.isNullOrNil(this.hxA))
    {
      ae.e("MicroMsg.Media.X264MP4MuxRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(93414);
      return -1;
    }
    for (;;)
    {
      try
      {
        this.mFileName = o.aZW(this.hxA);
        String str = o.aZU(this.hxA);
        ??? = str;
        if (!str.endsWith("/")) {
          ??? = str + "/";
        }
        this.hxP = ((String)??? + "tempRotate.mp4");
        ae.i("MicroMsg.Media.X264MP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", new Object[] { this.hxA, this.hxP });
        this.hxN = paramInt1;
        if (!this.gHg)
        {
          of(paramInt1);
          this.gHg = true;
        }
        this.hxM.a(d.c.wbz);
      }
      catch (Exception localException)
      {
        synchronized (this.hxz)
        {
          this.hyA.start();
          if ((this.hyd) || (this.hyb)) {
            break label390;
          }
          paramInt1 = this.hxF.a(new com.tencent.mm.plugin.mmsight.model.a.c.a()
          {
            public final void ayu()
            {
              AppMethodBeat.i(93405);
              ae.i("MicroMsg.Media.X264MP4MuxRecorder", "onPcmReady");
              if (d.this.ayj() != d.c.wbz)
              {
                ae.w("MicroMsg.Media.X264MP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
                AppMethodBeat.o(93405);
                return;
              }
              d.this.hxM.a(d.c.wbs);
              AppMethodBeat.o(93405);
            }
          });
          ae.i("MicroMsg.Media.X264MP4MuxRecorder", "start aacRecorder ret: %s", new Object[] { Integer.valueOf(paramInt1) });
          this.hxX = false;
          if (paramInt1 != 0)
          {
            this.hxM.a(d.c.wby);
            AppMethodBeat.o(93414);
            return paramInt1;
            localException = localException;
            ae.e("MicroMsg.Media.X264MP4MuxRecorder", "retrieve file name error: %s", new Object[] { localException.getMessage() });
          }
        }
      }
      continue;
      label390:
      ae.i("MicroMsg.Media.X264MP4MuxRecorder", "start yuvRecorder with mute");
      this.hxM.a(d.c.wbs);
      this.hxX = false;
      paramInt1 = 0;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(93417);
    ae.i("MicroMsg.Media.X264MP4MuxRecorder", "cancel record");
    synchronized (this.hxz)
    {
      if ((this.hyA == null) || ((this.hxF == null) && (!this.hyd)))
      {
        ae.e("MicroMsg.Media.X264MP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
        AppMethodBeat.o(93417);
        return;
      }
      this.hxM.a(d.c.wbu);
      this.hyA.stop(true);
      if (this.hxF != null) {
        this.hxF.a(new c.b()
        {
          public final void ayt()
          {
            AppMethodBeat.i(93408);
            ae.i("MicroMsg.Media.X264MP4MuxRecorder", "aac stop finish");
            AppMethodBeat.o(93408);
          }
        });
      }
      if (this.bufId >= 0)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        this.hxM.a(d.c.wbv);
        reset();
        AppMethodBeat.o(93417);
        return;
      }
      ae.e("MicroMsg.Media.X264MP4MuxRecorder", "why buf id < 0 ? %d", new Object[] { Integer.valueOf(this.bufId) });
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(93418);
    try
    {
      ae.i("MicroMsg.Media.X264MP4MuxRecorder", "clear");
      if (this.hxF != null) {
        this.hxF.clear();
      }
      if (this.hyg != null) {
        this.hyg.release();
      }
      if (this.bufId >= 0) {
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
      }
      AppMethodBeat.o(93418);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.Media.X264MP4MuxRecorder", localException, "clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(93418);
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
    AppMethodBeat.i(93413);
    if (!this.gHg)
    {
      ae.i("MicroMsg.Media.X264MP4MuxRecorder", "preInit, cameraOrientation");
      boolean bool = of(paramInt);
      this.gHg = true;
      ae.i("MicroMsg.Media.X264MP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(93413);
      return bool;
    }
    com.tencent.mm.media.k.d locald = com.tencent.mm.media.k.d.hrI;
    com.tencent.mm.media.k.d.auH();
    AppMethodBeat.o(93413);
    return true;
  }
  
  public final void oh(int paramInt)
  {
    AppMethodBeat.i(93427);
    ae.i("MicroMsg.Media.X264MP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.hxD = paramInt;
    AppMethodBeat.o(93427);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(93424);
    ae.i("MicroMsg.Media.X264MP4MuxRecorder", "pause");
    if ((this.hxM != null) && (this.hxM.wcI == d.c.wbs)) {
      this.hxM.a(d.c.wbA);
    }
    AppMethodBeat.o(93424);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(93419);
    ae.i("MicroMsg.Media.X264MP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", new Object[] { this.hyA, this.hxF, this.hxW });
    ae.i("MicroMsg.Media.X264MP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s", new Object[] { this.hyA, this.hxF });
    synchronized (this.hxz)
    {
      this.hyA = null;
      this.hxF = null;
      this.hxW = null;
      this.gHg = false;
      this.hxX = false;
      AppMethodBeat.o(93419);
      return;
    }
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(93421);
    ae.i("MicroMsg.Media.X264MP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    int i = paramInt3;
    if (paramInt3 % 16 != 0) {
      i = com.tencent.mm.plugin.mmsight.d.KG(paramInt3);
    }
    paramInt3 = paramInt4;
    if (paramInt4 % 16 != 0) {
      paramInt3 = com.tencent.mm.plugin.mmsight.d.KG(paramInt4);
    }
    ae.i("MicroMsg.Media.X264MP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt3) });
    this.hxK = paramInt1;
    this.hxL = paramInt2;
    if (k.wcg.h(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      ae.i("MicroMsg.Media.X264MP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = bu.HQ();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        k.wcg.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      ae.i("MicroMsg.Media.X264MP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
    }
    AppMethodBeat.o(93421);
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
 * Qualified Name:     com.tencent.mm.media.widget.c.d
 * JD-Core Version:    0.7.0.1
 */