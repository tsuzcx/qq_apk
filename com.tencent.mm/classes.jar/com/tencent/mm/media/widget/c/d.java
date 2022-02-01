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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.y;
import java.nio.IntBuffer;

public final class d
  implements b
{
  protected int gNJ;
  private EGLContext gWL;
  protected boolean gkP;
  protected boolean hbQ;
  private boolean hba;
  final Object hcD;
  protected String hcE;
  protected int hcF;
  protected float hcG;
  private int hcH;
  private float hcI;
  protected com.tencent.mm.plugin.mmsight.model.a.c hcJ;
  protected int hcL;
  protected int hcM;
  protected int hcN;
  protected int hcO;
  protected int hcP;
  protected s hcQ;
  protected int hcR;
  protected String hcT;
  protected boolean hcU;
  protected String hcV;
  protected boolean hcW;
  protected com.tencent.mm.plugin.mmsight.model.c hcX;
  protected com.tencent.mm.plugin.mmsight.model.c hcY;
  protected VideoTransPara hcZ;
  protected com.tencent.mm.media.d.g hdE;
  com.tencent.mm.media.i.a hdF;
  public d.g.a.b hdG;
  protected m hda;
  protected boolean hdb;
  protected int hdc;
  protected d.a hdd;
  protected Runnable hde;
  protected boolean hdf;
  protected boolean hdg;
  protected boolean hdh;
  com.tencent.mm.media.h.a hdk;
  protected com.tencent.mm.plugin.mmsight.model.g hdv;
  protected String mFileName;
  protected String md5;
  protected String thumbPath;
  
  private d(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(93409);
    this.hcD = new Object();
    this.hcE = "";
    this.hcF = 0;
    this.hcG = 0.0F;
    this.hcH = -1;
    this.hcI = -1.0F;
    this.hcL = 480;
    this.hcM = 640;
    this.hcN = 1600000;
    this.hcO = 480;
    this.hcP = 640;
    this.gNJ = -1;
    this.hcT = null;
    this.hcU = false;
    this.thumbPath = null;
    this.hcV = null;
    this.hcW = false;
    this.hcX = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.hcY = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.gkP = false;
    this.hdb = false;
    this.md5 = "";
    this.hbQ = false;
    this.hdc = 0;
    this.hde = null;
    this.hdf = false;
    this.hdg = true;
    this.hdh = false;
    this.hba = false;
    this.hdk = null;
    this.gWL = null;
    this.hdF = null;
    this.hdv = new com.tencent.mm.plugin.mmsight.model.g()
    {
      public final boolean V(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(93399);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          ac.e("MicroMsg.Media.X264MP4MuxRecorder", "preview callback data is null");
          AppMethodBeat.o(93399);
          return false;
        }
        if ((d.this.hcQ.uNv == d.c.uMj) || (d.this.hcQ.uNv == d.c.uMk))
        {
          if (d.this.hcQ.uNv == d.c.uMk)
          {
            d.this.hcQ.uNv = d.c.uMl;
            ac.v("MicroMsg.Media.X264MP4MuxRecorder", "forward one more frame");
          }
          d.this.hcY.vW(1L);
          if (d.this.hcJ != null) {
            d.this.hcJ.ddM();
          }
          d.this.hdk.a(paramAnonymousArrayOfByte, System.nanoTime(), new d.g.a.b() {});
          d.this.hcX.vW(1L);
          AppMethodBeat.o(93399);
          return true;
        }
        AppMethodBeat.o(93399);
        return false;
      }
    };
    this.hdG = new d.g.a.b() {};
    this.hcZ = paramVideoTransPara;
    this.hcL = paramVideoTransPara.width;
    this.hcM = paramVideoTransPara.height;
    this.hcQ = new s();
    ac.d("MicroMsg.Media.X264MP4MuxRecorder", "create X264MP4MuxRecorder, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(this.hcL), Integer.valueOf(this.hcM) });
    AppMethodBeat.o(93409);
  }
  
  public d(VideoTransPara paramVideoTransPara, com.tencent.mm.media.i.a parama)
  {
    this(paramVideoTransPara);
    AppMethodBeat.i(93410);
    this.gWL = null;
    this.hdF = parama;
    this.hdk = new com.tencent.mm.media.h.a(parama);
    paramVideoTransPara = com.tencent.mm.media.j.d.gWO;
    com.tencent.mm.media.j.d.arE();
    AppMethodBeat.o(93410);
  }
  
  private void avb()
  {
    AppMethodBeat.i(93412);
    int i = this.hcL;
    int j = this.hcM;
    this.hdk.cQ(i, j);
    this.hdk.mE(this.hcR);
    this.hdk.cS(this.hcO, this.hcP);
    ac.i("MicroMsg.Media.X264MP4MuxRecorder", "outputWidth: %s, outputHeight: %s, cameraPreviewWidth: %s, cameraPreviewHeight: %s, getDataRotate: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.hcO), Integer.valueOf(this.hcP), Integer.valueOf(this.hcR) });
    AppMethodBeat.o(93412);
  }
  
  private boolean nD(int paramInt)
  {
    AppMethodBeat.i(93411);
    long l = bs.Gn();
    this.hcN = this.hcZ.videoBitrate;
    if (this.hcL % 2 != 0) {
      this.hcL += 1;
    }
    if (this.hcM % 2 != 0) {
      this.hcM += 1;
    }
    ac.i("MicroMsg.Media.X264MP4MuxRecorder", "real width:%d, height:%d", new Object[] { Integer.valueOf(this.hcL), Integer.valueOf(this.hcM) });
    this.gNJ = SightVideoJNI.initDataBufferForMMSightLock(this.hcO, this.hcP, paramInt, this.hcL, this.hcM, this.hcZ.fps, this.hcN, this.hcZ.hCA, 8, this.hcZ.hCz, 23.0F, false, true, this.hcZ.duration, false);
    ac.i("MicroMsg.Media.X264MP4MuxRecorder", "init, bufId: %s", new Object[] { Integer.valueOf(this.gNJ) });
    if (this.gNJ < 0)
    {
      ac.e("MicroMsg.Media.X264MP4MuxRecorder", "init failed!");
      AppMethodBeat.o(93411);
      return false;
    }
    this.hcR = paramInt;
    ac.i("MicroMsg.Media.X264MP4MuxRecorder", "mTargetRate " + this.hcN + "  videoParams.fps: " + this.hcZ.fps + " mTargetHeight:" + this.hcM + " mTargetWidth:" + this.hcL);
    this.hdE = new com.tencent.mm.media.d.g(this.gNJ, this.hcL, this.hcM);
    Object localObject = this.hdk;
    EGLContext localEGLContext = this.gWL;
    paramInt = this.hcL;
    int i = this.hcM;
    d.g.a.b local3 = new d.g.a.b() {};
    ac.i(((com.tencent.mm.media.h.a)localObject).TAG, ((com.tencent.mm.media.h.a)localObject).hashCode() + " initWithSize, eglContext: " + localEGLContext + ", callback: false, width:" + paramInt + ", height:" + i);
    ((com.tencent.mm.media.h.a)localObject).i((d.g.a.a)new a.c((com.tencent.mm.media.h.a)localObject, localEGLContext, paramInt, i, local3));
    this.hdk.gST = new d.g.a.b()
    {
      private y avt()
      {
        AppMethodBeat.i(93403);
        for (;;)
        {
          Object localObject2;
          com.tencent.mm.media.d.g localg;
          int i;
          int j;
          synchronized (d.this.hcD)
          {
            if (d.this.hdE != null)
            {
              ??? = d.this.hdF.arh();
              if (??? != null)
              {
                ((IntBuffer)???).position(0);
                localObject2 = new int[((IntBuffer)???).remaining()];
                ((IntBuffer)???).get((int[])localObject2);
                localg = d.this.hdE;
                i = d.this.hcL;
                j = d.this.hcM;
                k.h(localObject2, "data");
                if (localg.gNJ >= 0) {
                  break label254;
                }
                ac.e("MicroMsg.X264TransEncoder", "writeRGBData error, buffId error");
              }
            }
            if ((d.this.hdE != null) && (d.this.hcQ.uNv == d.c.uMl))
            {
              d.this.hdE.stop(false);
              if (d.this.hcJ != null) {
                d.this.hcJ.a(new c.b()
                {
                  public final void avr()
                  {
                    AppMethodBeat.i(93402);
                    ac.i("MicroMsg.Media.X264MP4MuxRecorder", "aac stop finish");
                    AppMethodBeat.o(93402);
                  }
                });
              }
              d.this.hdk.release();
              localObject2 = d.this;
              ac.m("MicroMsg.Media.X264MP4MuxRecorder", "stopImpl", new Object[0]);
              com.tencent.mm.sdk.g.b.c(new d.6((d)localObject2), "X264MP4MuxRecorder_stop");
              if (d.this.hcQ != null) {
                d.this.hcQ.a(d.c.uMm);
              }
            }
            AppMethodBeat.o(93403);
            return null;
          }
          label254:
          synchronized (localg.stopLock)
          {
            localg.gRw.postToWorker((Runnable)new g.c(localg, i, j, (int[])localObject2));
            continue;
            localObject3 = finally;
            AppMethodBeat.o(93403);
            throw localObject3;
          }
        }
      }
    };
    avb();
    paramInt = this.hcZ.audioSampleRate;
    i = this.hcZ.audioBitrate;
    int j = this.hcZ.gOt;
    if (this.hcZ.hCX == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.hcJ = new a(paramInt, i, j, com.tencent.mm.plugin.sight.base.b.ac(true, bool));
      this.hcJ.nY(this.hdf);
      paramInt = this.hcJ.E(this.gNJ, e.asv(this.hcE));
      ac.i("MicroMsg.Media.X264MP4MuxRecorder", "initImpl used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
      if (paramInt == 0) {
        break;
      }
      localObject = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.arH();
      AppMethodBeat.o(93411);
      return false;
    }
    AppMethodBeat.o(93411);
    return true;
  }
  
  public final void E(Runnable paramRunnable)
  {
    AppMethodBeat.i(93415);
    synchronized (this.hcD)
    {
      this.hde = paramRunnable;
      ac.i("MicroMsg.Media.X264MP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", new Object[] { paramRunnable });
      if ((this.hdE == null) || ((this.hcJ == null) && (!this.hdh)))
      {
        ac.i("MicroMsg.Media.X264MP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
        if (paramRunnable != null) {
          ap.f(paramRunnable);
        }
        AppMethodBeat.o(93415);
        return;
      }
      if ((this.hcQ != null) && (this.hcQ.uNv == d.c.uMm))
      {
        ac.i("MicroMsg.Media.X264MP4MuxRecorder", "stop, already in stop videoRecordStatus");
        if (this.hcJ != null) {
          this.hcJ.clear();
        }
        if (paramRunnable != null) {
          ap.f(paramRunnable);
        }
        AppMethodBeat.o(93415);
        return;
      }
      this.hdv = null;
      this.hcF = ((int)bs.aO(this.hdE.startTime));
      if (this.hcQ != null)
      {
        paramRunnable = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.arI();
        this.hcQ.a(d.c.uMk);
      }
      AppMethodBeat.o(93415);
      return;
    }
  }
  
  public final String JC()
  {
    AppMethodBeat.i(93416);
    String str = bs.bG(this.md5, "");
    AppMethodBeat.o(93416);
    return str;
  }
  
  public final void K(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93425);
    ac.i("MicroMsg.Media.X264MP4MuxRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    this.hcR = paramInt1;
    this.hcO = paramInt2;
    this.hcP = paramInt3;
    this.hdk.mE(this.hcR);
    avb();
    if ((this.hcQ != null) && (this.hcQ.uNv == d.c.uMr)) {
      this.hcQ.a(d.c.uMj);
    }
    AppMethodBeat.o(93425);
  }
  
  public final void a(d.a parama)
  {
    this.hdd = parama;
  }
  
  public final void aj(float paramFloat)
  {
    AppMethodBeat.i(93428);
    ac.i("MicroMsg.Media.X264MP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.hcI = paramFloat;
    AppMethodBeat.o(93428);
  }
  
  public final boolean aly()
  {
    return this.hbQ;
  }
  
  public final String auN()
  {
    return this.thumbPath;
  }
  
  public final void ava() {}
  
  public final String ave()
  {
    return this.hcV;
  }
  
  public final float avf()
  {
    return this.hcG;
  }
  
  public final long avg()
  {
    AppMethodBeat.i(93420);
    synchronized (this.hcD)
    {
      if (this.hdE != null)
      {
        long l = bs.aO(this.hdE.startTime);
        AppMethodBeat.o(93420);
        return l;
      }
      AppMethodBeat.o(93420);
      return 0L;
    }
  }
  
  public final d.c avh()
  {
    return this.hcQ.uNv;
  }
  
  public final int avi()
  {
    AppMethodBeat.i(93422);
    int i = Math.round(this.hcF / 1000.0F);
    AppMethodBeat.o(93422);
    return i;
  }
  
  public final Point avj()
  {
    AppMethodBeat.i(93423);
    Point localPoint = new Point(this.hcO, this.hcP);
    AppMethodBeat.o(93423);
    return localPoint;
  }
  
  public final int avk()
  {
    return this.hcR;
  }
  
  public final boolean avl()
  {
    return this.hdb;
  }
  
  public final com.tencent.mm.audio.b.c.a avm()
  {
    AppMethodBeat.i(93426);
    if (this.hcJ != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.hcJ.ddN();
      AppMethodBeat.o(93426);
      return locala;
    }
    AppMethodBeat.o(93426);
    return null;
  }
  
  public final void avn()
  {
    this.hdg = false;
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(93414);
    ac.i("MicroMsg.Media.X264MP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.hcX.reset();
    this.hcF = 0;
    this.hcY.reset();
    this.hcU = false;
    this.hbQ = paramBoolean;
    this.hdc = paramInt2;
    this.hcQ.a(d.c.uMi);
    if (bs.isNullOrNil(this.hcE))
    {
      ac.e("MicroMsg.Media.X264MP4MuxRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(93414);
      return -1;
    }
    for (;;)
    {
      try
      {
        this.mFileName = i.aSu(this.hcE);
        String str = i.aSs(this.hcE);
        ??? = str;
        if (!str.endsWith("/")) {
          ??? = str + "/";
        }
        this.hcT = ((String)??? + "tempRotate.mp4");
        ac.i("MicroMsg.Media.X264MP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", new Object[] { this.hcE, this.hcT });
        this.hcR = paramInt1;
        if (!this.gkP)
        {
          nD(paramInt1);
          this.gkP = true;
        }
        this.hcQ.a(d.c.uMq);
      }
      catch (Exception localException)
      {
        synchronized (this.hcD)
        {
          this.hdE.start();
          if ((this.hdh) || (this.hdf)) {
            break label390;
          }
          paramInt1 = this.hcJ.a(new com.tencent.mm.plugin.mmsight.model.a.c.a()
          {
            public final void avs()
            {
              AppMethodBeat.i(93405);
              ac.i("MicroMsg.Media.X264MP4MuxRecorder", "onPcmReady");
              if (d.this.avh() != d.c.uMq)
              {
                ac.w("MicroMsg.Media.X264MP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
                AppMethodBeat.o(93405);
                return;
              }
              d.this.hcQ.a(d.c.uMj);
              AppMethodBeat.o(93405);
            }
          });
          ac.i("MicroMsg.Media.X264MP4MuxRecorder", "start aacRecorder ret: %s", new Object[] { Integer.valueOf(paramInt1) });
          this.hdb = false;
          if (paramInt1 != 0)
          {
            this.hcQ.a(d.c.uMp);
            AppMethodBeat.o(93414);
            return paramInt1;
            localException = localException;
            ac.e("MicroMsg.Media.X264MP4MuxRecorder", "retrieve file name error: %s", new Object[] { localException.getMessage() });
          }
        }
      }
      continue;
      label390:
      ac.i("MicroMsg.Media.X264MP4MuxRecorder", "start yuvRecorder with mute");
      this.hcQ.a(d.c.uMj);
      this.hdb = false;
      paramInt1 = 0;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(93417);
    ac.i("MicroMsg.Media.X264MP4MuxRecorder", "cancel record");
    synchronized (this.hcD)
    {
      if ((this.hdE == null) || ((this.hcJ == null) && (!this.hdh)))
      {
        ac.e("MicroMsg.Media.X264MP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
        AppMethodBeat.o(93417);
        return;
      }
      this.hcQ.a(d.c.uMl);
      this.hdE.stop(true);
      if (this.hcJ != null) {
        this.hcJ.a(new c.b()
        {
          public final void avr()
          {
            AppMethodBeat.i(93408);
            ac.i("MicroMsg.Media.X264MP4MuxRecorder", "aac stop finish");
            AppMethodBeat.o(93408);
          }
        });
      }
      if (this.gNJ >= 0)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(this.gNJ);
        this.hcQ.a(d.c.uMm);
        reset();
        AppMethodBeat.o(93417);
        return;
      }
      ac.e("MicroMsg.Media.X264MP4MuxRecorder", "why buf id < 0 ? %d", new Object[] { Integer.valueOf(this.gNJ) });
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(93418);
    try
    {
      ac.i("MicroMsg.Media.X264MP4MuxRecorder", "clear");
      if (this.hcJ != null) {
        this.hcJ.clear();
      }
      if (this.hdk != null) {
        this.hdk.release();
      }
      if (this.gNJ >= 0) {
        SightVideoJNI.releaseBigSightDataBufferLock(this.gNJ);
      }
      AppMethodBeat.o(93418);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.Media.X264MP4MuxRecorder", localException, "clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(93418);
    }
  }
  
  public final void eq(boolean paramBoolean)
  {
    this.hdf = paramBoolean;
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.hcE;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.g getFrameDataCallback()
  {
    return this.hdv;
  }
  
  public final boolean nE(int paramInt)
  {
    AppMethodBeat.i(93413);
    if (!this.gkP)
    {
      ac.i("MicroMsg.Media.X264MP4MuxRecorder", "preInit, cameraOrientation");
      boolean bool = nD(paramInt);
      this.gkP = true;
      ac.i("MicroMsg.Media.X264MP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(93413);
      return bool;
    }
    com.tencent.mm.media.j.d locald = com.tencent.mm.media.j.d.gWO;
    com.tencent.mm.media.j.d.arF();
    AppMethodBeat.o(93413);
    return true;
  }
  
  public final void nF(int paramInt)
  {
    AppMethodBeat.i(93427);
    ac.i("MicroMsg.Media.X264MP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.hcH = paramInt;
    AppMethodBeat.o(93427);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(93424);
    ac.i("MicroMsg.Media.X264MP4MuxRecorder", "pause");
    if ((this.hcQ != null) && (this.hcQ.uNv == d.c.uMj)) {
      this.hcQ.a(d.c.uMr);
    }
    AppMethodBeat.o(93424);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(93419);
    ac.i("MicroMsg.Media.X264MP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", new Object[] { this.hdE, this.hcJ, this.hda });
    ac.i("MicroMsg.Media.X264MP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s", new Object[] { this.hdE, this.hcJ });
    synchronized (this.hcD)
    {
      this.hdE = null;
      this.hcJ = null;
      this.hda = null;
      this.gkP = false;
      this.hdb = false;
      AppMethodBeat.o(93419);
      return;
    }
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(93421);
    ac.i("MicroMsg.Media.X264MP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    int i = paramInt3;
    if (paramInt3 % 16 != 0) {
      i = com.tencent.mm.plugin.mmsight.d.IJ(paramInt3);
    }
    paramInt3 = paramInt4;
    if (paramInt4 % 16 != 0) {
      paramInt3 = com.tencent.mm.plugin.mmsight.d.IJ(paramInt4);
    }
    ac.i("MicroMsg.Media.X264MP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt3) });
    this.hcO = paramInt1;
    this.hcP = paramInt2;
    if (j.uMV.g(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      ac.i("MicroMsg.Media.X264MP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = bs.Gn();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        j.uMV.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      ac.i("MicroMsg.Media.X264MP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(bs.aO(l)) });
    }
    AppMethodBeat.o(93421);
  }
  
  public final void setFilePath(String paramString)
  {
    this.hcE = paramString;
  }
  
  public final void setMirror(boolean paramBoolean) {}
  
  public final void setMute(boolean paramBoolean)
  {
    this.hdh = paramBoolean;
  }
  
  public final void vx(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void vy(String paramString)
  {
    this.hcV = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.d
 * JD-Core Version:    0.7.0.1
 */