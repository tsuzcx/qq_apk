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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.z;
import java.nio.IntBuffer;

public final class d
  implements b
{
  protected int bufId;
  protected boolean gEz;
  private EGLContext hoR;
  protected boolean htY;
  private boolean htg;
  final Object huL;
  protected String huM;
  protected int huN;
  protected float huO;
  private int huP;
  private float huQ;
  protected com.tencent.mm.plugin.mmsight.model.a.c huR;
  protected int huT;
  protected int huU;
  protected int huV;
  protected int huW;
  protected int huX;
  protected t huY;
  protected int huZ;
  protected com.tencent.mm.plugin.mmsight.model.g hvD;
  protected com.tencent.mm.media.e.g hvM;
  com.tencent.mm.media.j.a hvN;
  public d.g.a.b hvO;
  protected String hvb;
  protected boolean hvc;
  protected String hvd;
  protected boolean hve;
  protected com.tencent.mm.plugin.mmsight.model.c hvf;
  protected com.tencent.mm.plugin.mmsight.model.c hvg;
  protected VideoTransPara hvh;
  protected n hvi;
  protected boolean hvj;
  protected int hvk;
  protected d.a hvl;
  protected Runnable hvm;
  protected boolean hvn;
  protected boolean hvo;
  protected boolean hvp;
  com.tencent.mm.media.i.a hvs;
  protected String mFileName;
  protected String md5;
  protected String thumbPath;
  
  private d(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(93409);
    this.huL = new Object();
    this.huM = "";
    this.huN = 0;
    this.huO = 0.0F;
    this.huP = -1;
    this.huQ = -1.0F;
    this.huT = 480;
    this.huU = 640;
    this.huV = 1600000;
    this.huW = 480;
    this.huX = 640;
    this.bufId = -1;
    this.hvb = null;
    this.hvc = false;
    this.thumbPath = null;
    this.hvd = null;
    this.hve = false;
    this.hvf = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.hvg = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.gEz = false;
    this.hvj = false;
    this.md5 = "";
    this.htY = false;
    this.hvk = 0;
    this.hvm = null;
    this.hvn = false;
    this.hvo = true;
    this.hvp = false;
    this.htg = false;
    this.hvs = null;
    this.hoR = null;
    this.hvN = null;
    this.hvD = new com.tencent.mm.plugin.mmsight.model.g()
    {
      public final boolean U(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(93399);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          ad.e("MicroMsg.Media.X264MP4MuxRecorder", "preview callback data is null");
          AppMethodBeat.o(93399);
          return false;
        }
        if ((d.this.huY.vQE == d.c.vPp) || (d.this.huY.vQE == d.c.vPq))
        {
          if (d.this.huY.vQE == d.c.vPq)
          {
            d.this.huY.vQE = d.c.vPr;
            ad.v("MicroMsg.Media.X264MP4MuxRecorder", "forward one more frame");
          }
          d.this.hvg.yf(1L);
          if (d.this.huR != null) {
            d.this.huR.dni();
          }
          d.this.hvs.a(paramAnonymousArrayOfByte, System.nanoTime(), new d.g.a.b() {});
          d.this.hvf.yf(1L);
          AppMethodBeat.o(93399);
          return true;
        }
        AppMethodBeat.o(93399);
        return false;
      }
    };
    this.hvO = new d.g.a.b() {};
    this.hvh = paramVideoTransPara;
    this.huT = paramVideoTransPara.width;
    this.huU = paramVideoTransPara.height;
    this.huY = new t();
    ad.d("MicroMsg.Media.X264MP4MuxRecorder", "create X264MP4MuxRecorder, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(this.huT), Integer.valueOf(this.huU) });
    AppMethodBeat.o(93409);
  }
  
  public d(VideoTransPara paramVideoTransPara, com.tencent.mm.media.j.a parama)
  {
    this(paramVideoTransPara);
    AppMethodBeat.i(93410);
    this.hoR = null;
    this.hvN = parama;
    this.hvs = new com.tencent.mm.media.i.a(parama);
    paramVideoTransPara = com.tencent.mm.media.k.d.hoU;
    com.tencent.mm.media.k.d.aur();
    AppMethodBeat.o(93410);
  }
  
  private void axO()
  {
    AppMethodBeat.i(93412);
    int i = this.huT;
    int j = this.huU;
    this.hvs.cS(i, j);
    this.hvs.nd(this.huZ);
    this.hvs.cU(this.huW, this.huX);
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "outputWidth: %s, outputHeight: %s, cameraPreviewWidth: %s, cameraPreviewHeight: %s, getDataRotate: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.huW), Integer.valueOf(this.huX), Integer.valueOf(this.huZ) });
    AppMethodBeat.o(93412);
  }
  
  private boolean oc(int paramInt)
  {
    AppMethodBeat.i(93411);
    long l = bt.HI();
    this.huV = this.hvh.videoBitrate;
    if (this.huT % 2 != 0) {
      this.huT += 1;
    }
    if (this.huU % 2 != 0) {
      this.huU += 1;
    }
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "real width:%d, height:%d", new Object[] { Integer.valueOf(this.huT), Integer.valueOf(this.huU) });
    this.bufId = SightVideoJNI.initDataBufferForMMSightLock(this.huW, this.huX, paramInt, this.huT, this.huU, this.hvh.fps, this.huV, this.hvh.hVf, 8, this.hvh.hVe, 23.0F, false, true, this.hvh.duration, false);
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "init, bufId: %s", new Object[] { Integer.valueOf(this.bufId) });
    if (this.bufId < 0)
    {
      ad.e("MicroMsg.Media.X264MP4MuxRecorder", "init failed!");
      AppMethodBeat.o(93411);
      return false;
    }
    this.huZ = paramInt;
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "mTargetRate " + this.huV + "  videoParams.fps: " + this.hvh.fps + " mTargetHeight:" + this.huU + " mTargetWidth:" + this.huT);
    this.hvM = new com.tencent.mm.media.e.g(this.bufId, this.huT, this.huU);
    Object localObject = this.hvs;
    EGLContext localEGLContext = this.hoR;
    paramInt = this.huT;
    int i = this.huU;
    d.g.a.b local3 = new d.g.a.b() {};
    ad.i(((com.tencent.mm.media.i.a)localObject).TAG, ((com.tencent.mm.media.i.a)localObject).hashCode() + " initWithSize, eglContext: " + localEGLContext + ", callback: false, width:" + paramInt + ", height:" + i);
    ((com.tencent.mm.media.i.a)localObject).i((d.g.a.a)new a.c((com.tencent.mm.media.i.a)localObject, localEGLContext, paramInt, i, local3));
    this.hvs.hkU = new d.g.a.b()
    {
      private z ayg()
      {
        AppMethodBeat.i(93403);
        for (;;)
        {
          Object localObject2;
          com.tencent.mm.media.e.g localg;
          int i;
          int j;
          synchronized (d.this.huL)
          {
            if (d.this.hvM != null)
            {
              ??? = d.this.hvN.atU();
              if (??? != null)
              {
                ((IntBuffer)???).position(0);
                localObject2 = new int[((IntBuffer)???).remaining()];
                ((IntBuffer)???).get((int[])localObject2);
                localg = d.this.hvM;
                i = d.this.huT;
                j = d.this.huU;
                p.h(localObject2, "data");
                if (localg.bufId >= 0) {
                  break label254;
                }
                ad.e("MicroMsg.X264TransEncoder", "writeRGBData error, buffId error");
              }
            }
            if ((d.this.hvM != null) && (d.this.huY.vQE == d.c.vPr))
            {
              d.this.hvM.stop(false);
              if (d.this.huR != null) {
                d.this.huR.a(new c.b()
                {
                  public final void aye()
                  {
                    AppMethodBeat.i(93402);
                    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "aac stop finish");
                    AppMethodBeat.o(93402);
                  }
                });
              }
              d.this.hvs.release();
              localObject2 = d.this;
              ad.m("MicroMsg.Media.X264MP4MuxRecorder", "stopImpl", new Object[0]);
              com.tencent.mm.sdk.g.b.c(new d.6((d)localObject2), "X264MP4MuxRecorder_stop");
              if (d.this.huY != null) {
                d.this.huY.a(d.c.vPs);
              }
            }
            AppMethodBeat.o(93403);
            return null;
          }
          label254:
          synchronized (localg.stopLock)
          {
            localg.hjO.postToWorker((Runnable)new g.c(localg, i, j, (int[])localObject2));
            continue;
            localObject3 = finally;
            AppMethodBeat.o(93403);
            throw localObject3;
          }
        }
      }
    };
    axO();
    paramInt = this.hvh.audioSampleRate;
    i = this.hvh.audioBitrate;
    int j = this.hvh.audioChannelCount;
    if (this.hvh.hVC == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.huR = new a(paramInt, i, j, com.tencent.mm.plugin.sight.base.b.ag(true, bool));
      this.huR.os(this.hvn);
      paramInt = this.huR.E(this.bufId, e.axv(this.huM));
      ad.i("MicroMsg.Media.X264MP4MuxRecorder", "initImpl used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
      if (paramInt == 0) {
        break;
      }
      localObject = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.auu();
      AppMethodBeat.o(93411);
      return false;
    }
    AppMethodBeat.o(93411);
    return true;
  }
  
  public final void D(Runnable paramRunnable)
  {
    AppMethodBeat.i(93415);
    synchronized (this.huL)
    {
      this.hvm = paramRunnable;
      ad.i("MicroMsg.Media.X264MP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", new Object[] { paramRunnable });
      if ((this.hvM == null) || ((this.huR == null) && (!this.hvp)))
      {
        ad.i("MicroMsg.Media.X264MP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
        if (paramRunnable != null) {
          aq.f(paramRunnable);
        }
        AppMethodBeat.o(93415);
        return;
      }
      if ((this.huY != null) && (this.huY.vQE == d.c.vPs))
      {
        ad.i("MicroMsg.Media.X264MP4MuxRecorder", "stop, already in stop videoRecordStatus");
        if (this.huR != null) {
          this.huR.clear();
        }
        if (paramRunnable != null) {
          aq.f(paramRunnable);
        }
        AppMethodBeat.o(93415);
        return;
      }
      this.hvD = null;
      this.huN = ((int)bt.aO(this.hvM.startTime));
      if (this.huY != null)
      {
        paramRunnable = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.auv();
        this.huY.a(d.c.vPq);
      }
      AppMethodBeat.o(93415);
      return;
    }
  }
  
  public final void L(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93425);
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    this.huZ = paramInt1;
    this.huW = paramInt2;
    this.huX = paramInt3;
    this.hvs.nd(this.huZ);
    axO();
    if ((this.huY != null) && (this.huY.vQE == d.c.vPx)) {
      this.huY.a(d.c.vPp);
    }
    AppMethodBeat.o(93425);
  }
  
  public final String Lb()
  {
    AppMethodBeat.i(93416);
    String str = bt.bI(this.md5, "");
    AppMethodBeat.o(93416);
    return str;
  }
  
  public final void a(d.a parama)
  {
    this.hvl = parama;
  }
  
  public final void am(float paramFloat)
  {
    AppMethodBeat.i(93428);
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.huQ = paramFloat;
    AppMethodBeat.o(93428);
  }
  
  public final boolean aol()
  {
    return this.htY;
  }
  
  public final String axA()
  {
    return this.thumbPath;
  }
  
  public final void axN() {}
  
  public final String axR()
  {
    return this.hvd;
  }
  
  public final float axS()
  {
    return this.huO;
  }
  
  public final long axT()
  {
    AppMethodBeat.i(93420);
    synchronized (this.huL)
    {
      if (this.hvM != null)
      {
        long l = bt.aO(this.hvM.startTime);
        AppMethodBeat.o(93420);
        return l;
      }
      AppMethodBeat.o(93420);
      return 0L;
    }
  }
  
  public final d.c axU()
  {
    return this.huY.vQE;
  }
  
  public final int axV()
  {
    AppMethodBeat.i(93422);
    int i = Math.round(this.huN / 1000.0F);
    AppMethodBeat.o(93422);
    return i;
  }
  
  public final Point axW()
  {
    AppMethodBeat.i(93423);
    Point localPoint = new Point(this.huW, this.huX);
    AppMethodBeat.o(93423);
    return localPoint;
  }
  
  public final int axX()
  {
    return this.huZ;
  }
  
  public final boolean axY()
  {
    return this.hvj;
  }
  
  public final com.tencent.mm.audio.b.c.a axZ()
  {
    AppMethodBeat.i(93426);
    if (this.huR != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.huR.dnj();
      AppMethodBeat.o(93426);
      return locala;
    }
    AppMethodBeat.o(93426);
    return null;
  }
  
  public final void aya()
  {
    this.hvo = false;
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(93414);
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.hvf.reset();
    this.huN = 0;
    this.hvg.reset();
    this.hvc = false;
    this.htY = paramBoolean;
    this.hvk = paramInt2;
    this.huY.a(d.c.vPo);
    if (bt.isNullOrNil(this.huM))
    {
      ad.e("MicroMsg.Media.X264MP4MuxRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(93414);
      return -1;
    }
    for (;;)
    {
      try
      {
        this.mFileName = i.aYt(this.huM);
        String str = i.aYr(this.huM);
        ??? = str;
        if (!str.endsWith("/")) {
          ??? = str + "/";
        }
        this.hvb = ((String)??? + "tempRotate.mp4");
        ad.i("MicroMsg.Media.X264MP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", new Object[] { this.huM, this.hvb });
        this.huZ = paramInt1;
        if (!this.gEz)
        {
          oc(paramInt1);
          this.gEz = true;
        }
        this.huY.a(d.c.vPw);
      }
      catch (Exception localException)
      {
        synchronized (this.huL)
        {
          this.hvM.start();
          if ((this.hvp) || (this.hvn)) {
            break label390;
          }
          paramInt1 = this.huR.a(new com.tencent.mm.plugin.mmsight.model.a.c.a()
          {
            public final void ayf()
            {
              AppMethodBeat.i(93405);
              ad.i("MicroMsg.Media.X264MP4MuxRecorder", "onPcmReady");
              if (d.this.axU() != d.c.vPw)
              {
                ad.w("MicroMsg.Media.X264MP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
                AppMethodBeat.o(93405);
                return;
              }
              d.this.huY.a(d.c.vPp);
              AppMethodBeat.o(93405);
            }
          });
          ad.i("MicroMsg.Media.X264MP4MuxRecorder", "start aacRecorder ret: %s", new Object[] { Integer.valueOf(paramInt1) });
          this.hvj = false;
          if (paramInt1 != 0)
          {
            this.huY.a(d.c.vPv);
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
      this.huY.a(d.c.vPp);
      this.hvj = false;
      paramInt1 = 0;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(93417);
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "cancel record");
    synchronized (this.huL)
    {
      if ((this.hvM == null) || ((this.huR == null) && (!this.hvp)))
      {
        ad.e("MicroMsg.Media.X264MP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
        AppMethodBeat.o(93417);
        return;
      }
      this.huY.a(d.c.vPr);
      this.hvM.stop(true);
      if (this.huR != null) {
        this.huR.a(new c.b()
        {
          public final void aye()
          {
            AppMethodBeat.i(93408);
            ad.i("MicroMsg.Media.X264MP4MuxRecorder", "aac stop finish");
            AppMethodBeat.o(93408);
          }
        });
      }
      if (this.bufId >= 0)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        this.huY.a(d.c.vPs);
        reset();
        AppMethodBeat.o(93417);
        return;
      }
      ad.e("MicroMsg.Media.X264MP4MuxRecorder", "why buf id < 0 ? %d", new Object[] { Integer.valueOf(this.bufId) });
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(93418);
    try
    {
      ad.i("MicroMsg.Media.X264MP4MuxRecorder", "clear");
      if (this.huR != null) {
        this.huR.clear();
      }
      if (this.hvs != null) {
        this.hvs.release();
      }
      if (this.bufId >= 0) {
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
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
  
  public final void es(boolean paramBoolean)
  {
    this.hvn = paramBoolean;
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.huM;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.g getFrameDataCallback()
  {
    return this.hvD;
  }
  
  public final boolean od(int paramInt)
  {
    AppMethodBeat.i(93413);
    if (!this.gEz)
    {
      ad.i("MicroMsg.Media.X264MP4MuxRecorder", "preInit, cameraOrientation");
      boolean bool = oc(paramInt);
      this.gEz = true;
      ad.i("MicroMsg.Media.X264MP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(93413);
      return bool;
    }
    com.tencent.mm.media.k.d locald = com.tencent.mm.media.k.d.hoU;
    com.tencent.mm.media.k.d.aus();
    AppMethodBeat.o(93413);
    return true;
  }
  
  public final void oe(int paramInt)
  {
    AppMethodBeat.i(93427);
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.huP = paramInt;
    AppMethodBeat.o(93427);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(93424);
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "pause");
    if ((this.huY != null) && (this.huY.vQE == d.c.vPp)) {
      this.huY.a(d.c.vPx);
    }
    AppMethodBeat.o(93424);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(93419);
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", new Object[] { this.hvM, this.huR, this.hvi });
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s", new Object[] { this.hvM, this.huR });
    synchronized (this.huL)
    {
      this.hvM = null;
      this.huR = null;
      this.hvi = null;
      this.gEz = false;
      this.hvj = false;
      AppMethodBeat.o(93419);
      return;
    }
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(93421);
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    int i = paramInt3;
    if (paramInt3 % 16 != 0) {
      i = com.tencent.mm.plugin.mmsight.d.Kg(paramInt3);
    }
    paramInt3 = paramInt4;
    if (paramInt4 % 16 != 0) {
      paramInt3 = com.tencent.mm.plugin.mmsight.d.Kg(paramInt4);
    }
    ad.i("MicroMsg.Media.X264MP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt3) });
    this.huW = paramInt1;
    this.huX = paramInt2;
    if (k.vQc.g(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      ad.i("MicroMsg.Media.X264MP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = bt.HI();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        k.vQc.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      ad.i("MicroMsg.Media.X264MP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(bt.aO(l)) });
    }
    AppMethodBeat.o(93421);
  }
  
  public final void setFilePath(String paramString)
  {
    this.huM = paramString;
  }
  
  public final void setMirror(boolean paramBoolean) {}
  
  public final void setMute(boolean paramBoolean)
  {
    this.hvp = paramBoolean;
  }
  
  public final void yo(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void yp(String paramString)
  {
    this.hvd = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.d
 * JD-Core Version:    0.7.0.1
 */