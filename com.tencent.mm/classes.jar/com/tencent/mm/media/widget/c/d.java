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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.s;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import kotlin.g.b.p;
import kotlin.x;

public final class d
  implements b
{
  protected int bufId;
  protected boolean htU;
  private EGLContext ilv;
  private boolean ipv;
  protected boolean iqo;
  protected float irA;
  private int irB;
  private float irC;
  protected com.tencent.mm.plugin.mmsight.model.a.c irD;
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
  final Object irx;
  protected String iry;
  protected int irz;
  protected com.tencent.mm.media.e.g isB;
  com.tencent.mm.media.j.a isC;
  public kotlin.g.a.b isD;
  protected boolean isa;
  protected boolean isb;
  com.tencent.mm.media.i.a ise;
  protected com.tencent.mm.plugin.mmsight.model.g iss;
  protected String mFileName;
  protected String md5;
  protected String thumbPath;
  
  private d(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(93409);
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
    this.bufId = -1;
    this.irN = null;
    this.irO = false;
    this.thumbPath = null;
    this.irP = null;
    this.irQ = false;
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
    this.ipv = false;
    this.ise = null;
    this.ilv = null;
    this.isC = null;
    this.iss = new com.tencent.mm.plugin.mmsight.model.g()
    {
      public final boolean ai(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(93399);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          Log.e("MicroMsg.Media.X264MP4MuxRecorder", "preview callback data is null");
          AppMethodBeat.o(93399);
          return false;
        }
        if ((d.this.irK.zwJ == d.c.zvu) || (d.this.irK.zwJ == d.c.zvv))
        {
          if (d.this.irK.zwJ == d.c.zvv)
          {
            d.this.irK.zwJ = d.c.zvw;
            Log.v("MicroMsg.Media.X264MP4MuxRecorder", "forward one more frame");
          }
          d.this.irS.Hi(1L);
          if (d.this.irD != null) {
            d.this.irD.ejW();
          }
          d.this.ise.a(paramAnonymousArrayOfByte, System.nanoTime(), new kotlin.g.a.b() {});
          d.this.irR.Hi(1L);
          AppMethodBeat.o(93399);
          return true;
        }
        AppMethodBeat.o(93399);
        return false;
      }
    };
    this.isD = new kotlin.g.a.b() {};
    this.irT = paramVideoTransPara;
    this.irF = paramVideoTransPara.width;
    this.irG = paramVideoTransPara.height;
    this.irK = new t();
    Log.d("MicroMsg.Media.X264MP4MuxRecorder", "create X264MP4MuxRecorder, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(this.irF), Integer.valueOf(this.irG) });
    AppMethodBeat.o(93409);
  }
  
  public d(VideoTransPara paramVideoTransPara, com.tencent.mm.media.j.a parama)
  {
    this(paramVideoTransPara);
    AppMethodBeat.i(93410);
    this.ilv = null;
    this.isC = parama;
    this.ise = new com.tencent.mm.media.i.a(parama);
    paramVideoTransPara = com.tencent.mm.media.k.e.ilC;
    com.tencent.mm.media.k.e.aNt();
    AppMethodBeat.o(93410);
  }
  
  private void aQH()
  {
    AppMethodBeat.i(93412);
    int i = this.irF;
    int j = this.irG;
    this.ise.cX(i, j);
    this.ise.qx(this.irL);
    this.ise.cZ(this.irI, this.irJ);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "outputWidth: %s, outputHeight: %s, cameraPreviewWidth: %s, cameraPreviewHeight: %s, getDataRotate: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.irI), Integer.valueOf(this.irJ), Integer.valueOf(this.irL) });
    AppMethodBeat.o(93412);
  }
  
  private boolean rB(int paramInt)
  {
    AppMethodBeat.i(93411);
    long l = Util.currentTicks();
    this.irH = this.irT.videoBitrate;
    if (this.irF % 2 != 0) {
      this.irF += 1;
    }
    if (this.irG % 2 != 0) {
      this.irG += 1;
    }
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "real width:%d, height:%d", new Object[] { Integer.valueOf(this.irF), Integer.valueOf(this.irG) });
    this.bufId = SightVideoJNI.initDataBufferForMMSightLock(this.irI, this.irJ, paramInt, this.irF, this.irG, this.irT.fps, this.irH, this.irT.iSV, 8, this.irT.iSU, 23.0F, false, true, this.irT.duration, false);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "init, bufId: %s", new Object[] { Integer.valueOf(this.bufId) });
    if (this.bufId < 0)
    {
      Log.e("MicroMsg.Media.X264MP4MuxRecorder", "init failed!");
      AppMethodBeat.o(93411);
      return false;
    }
    this.irL = paramInt;
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "mTargetRate " + this.irH + "  videoParams.fps: " + this.irT.fps + " mTargetHeight:" + this.irG + " mTargetWidth:" + this.irF);
    this.isB = new com.tencent.mm.media.e.g(this.bufId, this.irF, this.irG);
    Object localObject = this.ise;
    EGLContext localEGLContext = this.ilv;
    paramInt = this.irF;
    int i = this.irG;
    kotlin.g.a.b local3 = new kotlin.g.a.b() {};
    Log.i(((com.tencent.mm.media.i.a)localObject).TAG, ((com.tencent.mm.media.i.a)localObject).hashCode() + " initWithSize, eglContext: " + localEGLContext + ", callback: false, width:" + paramInt + ", height:" + i);
    ((com.tencent.mm.media.i.a)localObject).k((kotlin.g.a.a)new a.c((com.tencent.mm.media.i.a)localObject, localEGLContext, paramInt, i, local3));
    this.ise.ihb = new kotlin.g.a.b()
    {
      private x aQZ()
      {
        AppMethodBeat.i(93403);
        for (;;)
        {
          int[] arrayOfInt;
          com.tencent.mm.media.e.g localg;
          int i;
          int j;
          synchronized (d.this.irx)
          {
            if (d.this.isB != null)
            {
              ??? = d.this.isC.ijo;
              if (??? == null) {
                continue;
              }
              ??? = ((com.tencent.mm.media.j.b.a)???).ijF;
              if (??? == null) {
                continue;
              }
              ??? = ((ByteBuffer)???).asIntBuffer();
              if (??? != null)
              {
                ((IntBuffer)???).position(0);
                arrayOfInt = new int[((IntBuffer)???).remaining()];
                ((IntBuffer)???).get(arrayOfInt);
                localg = d.this.isB;
                i = d.this.irF;
                j = d.this.irG;
                p.h(arrayOfInt, "data");
                if (localg.bufId >= 0) {
                  break label278;
                }
                Log.e("MicroMsg.X264TransEncoder", "writeRGBData error, buffId error");
              }
            }
            if ((d.this.isB != null) && (d.this.irK.zwJ == d.c.zvw))
            {
              d.this.isB.stop(false);
              if (d.this.irD != null) {
                d.this.irD.a(new c.b()
                {
                  public final void aQX()
                  {
                    AppMethodBeat.i(93402);
                    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "aac stop finish");
                    AppMethodBeat.o(93402);
                  }
                });
              }
              d.this.ise.release();
              ??? = d.this;
              Log.printInfoStack("MicroMsg.Media.X264MP4MuxRecorder", "stopImpl", new Object[0]);
              ThreadPool.post(new d.6((d)???), "X264MP4MuxRecorder_stop");
              if (d.this.irK != null) {
                d.this.irK.a(d.c.zvx);
              }
            }
            AppMethodBeat.o(93403);
            return null;
            ??? = null;
            continue;
            ??? = null;
          }
          label278:
          synchronized (localg.stopLock)
          {
            localg.ify.postToWorker((Runnable)new g.c(localg, i, j, arrayOfInt));
            continue;
            localObject2 = finally;
            AppMethodBeat.o(93403);
            throw localObject2;
          }
        }
      }
    };
    aQH();
    paramInt = this.irT.audioSampleRate;
    i = this.irT.audioBitrate;
    int j = this.irT.audioChannelCount;
    if (this.irT.iTs == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.irD = new a(paramInt, i, j, com.tencent.mm.plugin.sight.base.b.ak(true, bool));
      this.irD.rc(this.irZ);
      paramInt = this.irD.H(this.bufId, com.tencent.mm.plugin.sight.base.e.aNv(this.iry));
      Log.i("MicroMsg.Media.X264MP4MuxRecorder", "initImpl used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      if (paramInt == 0) {
        break;
      }
      localObject = com.tencent.mm.media.k.e.ilC;
      com.tencent.mm.media.k.e.aNw();
      AppMethodBeat.o(93411);
      return false;
    }
    AppMethodBeat.o(93411);
    return true;
  }
  
  public final void E(Runnable paramRunnable)
  {
    AppMethodBeat.i(93415);
    synchronized (this.irx)
    {
      this.irY = paramRunnable;
      Log.i("MicroMsg.Media.X264MP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", new Object[] { paramRunnable });
      if ((this.isB == null) || ((this.irD == null) && (!this.isb)))
      {
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
        if (paramRunnable != null) {
          MMHandlerThread.postToMainThread(paramRunnable);
        }
        AppMethodBeat.o(93415);
        return;
      }
      if ((this.irK != null) && (this.irK.zwJ == d.c.zvx))
      {
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "stop, already in stop videoRecordStatus");
        if (this.irD != null) {
          this.irD.clear();
        }
        if (paramRunnable != null) {
          MMHandlerThread.postToMainThread(paramRunnable);
        }
        AppMethodBeat.o(93415);
        return;
      }
      this.iss = null;
      this.irz = ((int)Util.ticksToNow(this.isB.startTime));
      if (this.irK != null)
      {
        paramRunnable = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aNx();
        this.irK.a(d.c.zvv);
      }
      AppMethodBeat.o(93415);
      return;
    }
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
    AppMethodBeat.i(93425);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    this.irL = paramInt1;
    this.irI = paramInt2;
    this.irJ = paramInt3;
    this.ise.qx(this.irL);
    aQH();
    if ((this.irK != null) && (this.irK.zwJ == d.c.zvC)) {
      this.irK.a(d.c.zvu);
    }
    AppMethodBeat.o(93425);
  }
  
  public final void a(d.a parama)
  {
    this.irX = parama;
  }
  
  public final void aQG() {}
  
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
    AppMethodBeat.i(93420);
    synchronized (this.irx)
    {
      if (this.isB != null)
      {
        long l = Util.ticksToNow(this.isB.startTime);
        AppMethodBeat.o(93420);
        return l;
      }
      AppMethodBeat.o(93420);
      return 0L;
    }
  }
  
  public final d.c aQN()
  {
    return this.irK.zwJ;
  }
  
  public final int aQO()
  {
    AppMethodBeat.i(93422);
    int i = Math.round(this.irz / 1000.0F);
    AppMethodBeat.o(93422);
    return i;
  }
  
  public final Point aQP()
  {
    AppMethodBeat.i(93423);
    Point localPoint = new Point(this.irI, this.irJ);
    AppMethodBeat.o(93423);
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
    AppMethodBeat.i(93426);
    if (this.irD != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.irD.ejX();
      AppMethodBeat.o(93426);
      return locala;
    }
    AppMethodBeat.o(93426);
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
    AppMethodBeat.i(93428);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.irC = paramFloat;
    AppMethodBeat.o(93428);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(93414);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "start, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.irR.reset();
    this.irz = 0;
    this.irS.reset();
    this.irO = false;
    this.iqo = paramBoolean;
    this.irW = paramInt2;
    this.irK.a(d.c.zvt);
    if (Util.isNullOrNil(this.iry))
    {
      Log.e("MicroMsg.Media.X264MP4MuxRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(93414);
      return -1;
    }
    for (;;)
    {
      try
      {
        this.mFileName = s.bpb(this.iry);
        String str = s.boZ(this.iry);
        ??? = str;
        if (!str.endsWith("/")) {
          ??? = str + "/";
        }
        this.irN = ((String)??? + "tempRotate.mp4");
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "mCurRecordPath: %s, tempRotateFilePath: %s", new Object[] { this.iry, this.irN });
        this.irL = paramInt1;
        if (!this.htU)
        {
          rB(paramInt1);
          this.htU = true;
        }
        this.irK.a(d.c.zvB);
      }
      catch (Exception localException)
      {
        synchronized (this.irx)
        {
          this.isB.start();
          if ((this.isb) || (this.irZ)) {
            break label390;
          }
          paramInt1 = this.irD.a(new com.tencent.mm.plugin.mmsight.model.a.c.a()
          {
            public final void aQY()
            {
              AppMethodBeat.i(93405);
              Log.i("MicroMsg.Media.X264MP4MuxRecorder", "onPcmReady");
              if (d.this.aQN() != d.c.zvB)
              {
                Log.w("MicroMsg.Media.X264MP4MuxRecorder", "not MediaStatus.Initialized, maybe canceled by user");
                AppMethodBeat.o(93405);
                return;
              }
              d.this.irK.a(d.c.zvu);
              AppMethodBeat.o(93405);
            }
          });
          Log.i("MicroMsg.Media.X264MP4MuxRecorder", "start aacRecorder ret: %s", new Object[] { Integer.valueOf(paramInt1) });
          this.irV = false;
          if (paramInt1 != 0)
          {
            this.irK.a(d.c.zvA);
            AppMethodBeat.o(93414);
            return paramInt1;
            localException = localException;
            Log.e("MicroMsg.Media.X264MP4MuxRecorder", "retrieve file name error: %s", new Object[] { localException.getMessage() });
          }
        }
      }
      continue;
      label390:
      Log.i("MicroMsg.Media.X264MP4MuxRecorder", "start yuvRecorder with mute");
      this.irK.a(d.c.zvu);
      this.irV = false;
      paramInt1 = 0;
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(93417);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "cancel record");
    synchronized (this.irx)
    {
      if ((this.isB == null) || ((this.irD == null) && (!this.isb)))
      {
        Log.e("MicroMsg.Media.X264MP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
        AppMethodBeat.o(93417);
        return;
      }
      this.irK.a(d.c.zvw);
      this.isB.stop(true);
      if (this.irD != null) {
        this.irD.a(new c.b()
        {
          public final void aQX()
          {
            AppMethodBeat.i(93408);
            Log.i("MicroMsg.Media.X264MP4MuxRecorder", "aac stop finish");
            AppMethodBeat.o(93408);
          }
        });
      }
      if (this.bufId >= 0)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        this.irK.a(d.c.zvx);
        reset();
        AppMethodBeat.o(93417);
        return;
      }
      Log.e("MicroMsg.Media.X264MP4MuxRecorder", "why buf id < 0 ? %d", new Object[] { Integer.valueOf(this.bufId) });
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(93418);
    try
    {
      Log.i("MicroMsg.Media.X264MP4MuxRecorder", "clear");
      if (this.irD != null) {
        this.irD.clear();
      }
      if (this.ise != null) {
        this.ise.release();
      }
      if (this.bufId >= 0) {
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
      }
      AppMethodBeat.o(93418);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Media.X264MP4MuxRecorder", localException, "clear error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(93418);
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
    AppMethodBeat.i(93416);
    String str = Util.nullAs(this.md5, "");
    AppMethodBeat.o(93416);
    return str;
  }
  
  public final boolean isLandscape()
  {
    return this.iqo;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(93424);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "pause");
    if ((this.irK != null) && (this.irK.zwJ == d.c.zvu)) {
      this.irK.a(d.c.zvC);
    }
    AppMethodBeat.o(93424);
  }
  
  public final boolean rC(int paramInt)
  {
    AppMethodBeat.i(93413);
    if (!this.htU)
    {
      Log.i("MicroMsg.Media.X264MP4MuxRecorder", "preInit, cameraOrientation");
      boolean bool = rB(paramInt);
      this.htU = true;
      Log.i("MicroMsg.Media.X264MP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(93413);
      return bool;
    }
    com.tencent.mm.media.k.e locale = com.tencent.mm.media.k.e.ilC;
    com.tencent.mm.media.k.e.aNu();
    AppMethodBeat.o(93413);
    return true;
  }
  
  public final void rD(int paramInt)
  {
    AppMethodBeat.i(93427);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.irB = paramInt;
    AppMethodBeat.o(93427);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(93419);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", new Object[] { this.isB, this.irD, this.irU });
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s", new Object[] { this.isB, this.irD });
    synchronized (this.irx)
    {
      this.isB = null;
      this.irD = null;
      this.irU = null;
      this.htU = false;
      this.irV = false;
      AppMethodBeat.o(93419);
      return;
    }
  }
  
  public final void s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(93421);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    int i = paramInt3;
    if (paramInt3 % 16 != 0) {
      i = com.tencent.mm.plugin.mmsight.d.QH(paramInt3);
    }
    paramInt3 = paramInt4;
    if (paramInt4 % 16 != 0) {
      paramInt3 = com.tencent.mm.plugin.mmsight.d.QH(paramInt4);
    }
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt3) });
    this.irI = paramInt1;
    this.irJ = paramInt2;
    if (k.zwi.h(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      Log.i("MicroMsg.Media.X264MP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = Util.currentTicks();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        k.zwi.k(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      Log.i("MicroMsg.Media.X264MP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    }
    AppMethodBeat.o(93421);
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
 * Qualified Name:     com.tencent.mm.media.widget.c.d
 * JD-Core Version:    0.7.0.1
 */