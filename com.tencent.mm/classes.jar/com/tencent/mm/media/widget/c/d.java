package com.tencent.mm.media.widget.c;

import android.graphics.Point;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.e.h;
import com.tencent.mm.media.e.h.c;
import com.tencent.mm.media.i.a.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.a.m;
import com.tencent.mm.plugin.mmsight.model.a.s;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import kotlin.g.b.p;
import kotlin.x;

public final class d
  implements b
{
  protected int bufId;
  protected boolean kfR;
  private EGLContext lau;
  private boolean leA;
  protected boolean lft;
  private final Object lgB;
  protected String lgC;
  protected int lgD;
  protected float lgE;
  private int lgF;
  private float lgG;
  protected com.tencent.mm.plugin.mmsight.model.a.c lgH;
  protected int lgJ;
  protected int lgK;
  protected int lgL;
  protected int lgM;
  protected int lgN;
  protected s lgO;
  protected int lgP;
  protected String lgR;
  protected boolean lgS;
  protected String lgT;
  protected boolean lgU;
  protected com.tencent.mm.plugin.mmsight.model.c lgV;
  protected com.tencent.mm.plugin.mmsight.model.c lgW;
  protected VideoTransPara lgX;
  protected m lgY;
  protected boolean lgZ;
  protected h lhF;
  private com.tencent.mm.media.j.a lhG;
  private boolean lhH;
  public kotlin.g.a.b lhI;
  protected int lha;
  protected d.a lhb;
  protected Runnable lhc;
  protected boolean lhd;
  protected boolean lhe;
  protected boolean lhf;
  private com.tencent.mm.media.i.a lhi;
  protected g lhw;
  protected String mFileName;
  protected String md5;
  protected String thumbPath;
  
  private d(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(93409);
    this.lgB = new Object();
    this.lgC = "";
    this.lgD = 0;
    this.lgE = 0.0F;
    this.lgF = -1;
    this.lgG = -1.0F;
    this.lgJ = 480;
    this.lgK = 640;
    this.lgL = 1600000;
    this.lgM = 480;
    this.lgN = 640;
    this.bufId = -1;
    this.lgR = null;
    this.lgS = false;
    this.thumbPath = null;
    this.lgT = null;
    this.lgU = false;
    this.lgV = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.lgW = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.kfR = false;
    this.lgZ = false;
    this.md5 = "";
    this.lft = false;
    this.lha = 0;
    this.lhc = null;
    this.lhd = false;
    this.lhe = true;
    this.lhf = false;
    this.leA = false;
    this.lhi = null;
    this.lau = null;
    this.lhG = null;
    this.lhH = false;
    this.lhw = new g()
    {
      public final boolean ar(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(93399);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          Log.e("MicroMsg.Media.X264MP4MuxRecorder", "preview callback data is null");
          AppMethodBeat.o(93399);
          return false;
        }
        if ((d.this.lgO.Fcd == d.c.FaT) || (d.this.lgO.Fcd == d.c.FaU))
        {
          if (d.this.lgO.Fcd == d.c.FaU)
          {
            d.this.lgO.Fcd = d.c.FaV;
            Log.v("MicroMsg.Media.X264MP4MuxRecorder", "forward one more frame");
          }
          d.this.lgW.Ox(1L);
          if (d.this.lgH != null) {
            d.this.lgH.eTD();
          }
          d.a(d.this).a(paramAnonymousArrayOfByte, System.nanoTime(), new kotlin.g.a.b() {});
          d.this.lgV.Ox(1L);
          AppMethodBeat.o(93399);
          return true;
        }
        AppMethodBeat.o(93399);
        return false;
      }
    };
    this.lhI = new kotlin.g.a.b()
    {
      private x e(Integer paramAnonymousInteger)
      {
        AppMethodBeat.i(259327);
        if ((d.this.lgO.Fcd == d.c.FaT) || (d.this.lgO.Fcd == d.c.FaU))
        {
          if (d.this.lgO.Fcd == d.c.FaU)
          {
            d.this.lgO.Fcd = d.c.FaV;
            Log.v("MicroMsg.Media.X264MP4MuxRecorder", "forward one more frame");
          }
          d.this.lgW.Ox(1L);
          if (d.this.lgH != null) {
            d.this.lgH.eTD();
          }
          d.a(d.this).x(paramAnonymousInteger.intValue(), System.nanoTime());
          d.this.lgV.Ox(1L);
        }
        AppMethodBeat.o(259327);
        return null;
      }
    };
    this.lgX = paramVideoTransPara;
    this.lgJ = paramVideoTransPara.width;
    this.lgK = paramVideoTransPara.height;
    this.lgO = new s();
    Log.d("MicroMsg.Media.X264MP4MuxRecorder", "create X264MP4MuxRecorder, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(this.lgJ), Integer.valueOf(this.lgK) });
    AppMethodBeat.o(93409);
  }
  
  public d(VideoTransPara paramVideoTransPara, com.tencent.mm.media.j.a parama)
  {
    this(paramVideoTransPara);
    AppMethodBeat.i(93410);
    this.lau = null;
    this.lhG = parama;
    this.lhi = new com.tencent.mm.media.i.a(parama);
    paramVideoTransPara = com.tencent.mm.media.k.f.laB;
    com.tencent.mm.media.k.f.aVX();
    AppMethodBeat.o(93410);
  }
  
  private void aZz()
  {
    AppMethodBeat.i(93412);
    int i = this.lgJ;
    int j = this.lgK;
    this.lhi.dt(i, j);
    this.lhi.tm(this.lgP);
    this.lhi.dv(this.lgM, this.lgN);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "outputWidth: %s, outputHeight: %s, cameraPreviewWidth: %s, cameraPreviewHeight: %s, getDataRotate: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.lgM), Integer.valueOf(this.lgN), Integer.valueOf(this.lgP) });
    AppMethodBeat.o(93412);
  }
  
  private boolean uv(int paramInt)
  {
    AppMethodBeat.i(93411);
    long l = Util.currentTicks();
    this.lgL = this.lgX.videoBitrate;
    if (this.lgJ % 2 != 0) {
      this.lgJ += 1;
    }
    if (this.lgK % 2 != 0) {
      this.lgK += 1;
    }
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "real width:%d, height:%d", new Object[] { Integer.valueOf(this.lgJ), Integer.valueOf(this.lgK) });
    this.bufId = SightVideoJNI.initDataBufferForMMSightLock(this.lgM, this.lgN, paramInt, this.lgJ, this.lgK, this.lgX.fps, this.lgL, this.lgX.lJn, 8, this.lgX.lJm, 23.0F, false, true, this.lgX.duration, false, false, this.lhH);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "init, bufId: %s", new Object[] { Integer.valueOf(this.bufId) });
    if (this.bufId < 0)
    {
      Log.e("MicroMsg.Media.X264MP4MuxRecorder", "init failed!");
      AppMethodBeat.o(93411);
      return false;
    }
    this.lgP = paramInt;
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "mTargetRate " + this.lgL + "  videoParams.fps: " + this.lgX.fps + " mTargetHeight:" + this.lgK + " mTargetWidth:" + this.lgJ);
    this.lhF = new h(this.bufId, this.lgJ, this.lgK);
    Object localObject = this.lhi;
    EGLContext localEGLContext = this.lau;
    paramInt = this.lgJ;
    int i = this.lgK;
    kotlin.g.a.b local3 = new kotlin.g.a.b() {};
    Log.i(((com.tencent.mm.media.i.a)localObject).TAG, ((com.tencent.mm.media.i.a)localObject).hashCode() + " initWithSize, eglContext: " + localEGLContext + ", callback: false, width:" + paramInt + ", height:" + i);
    ((com.tencent.mm.media.i.a)localObject).j((kotlin.g.a.a)new a.c((com.tencent.mm.media.i.a)localObject, localEGLContext, paramInt, i, local3));
    this.lhi.kVP = new kotlin.g.a.b()
    {
      private x aZR()
      {
        AppMethodBeat.i(93403);
        for (;;)
        {
          int[] arrayOfInt;
          h localh;
          int i;
          int j;
          synchronized (d.b(d.this))
          {
            if (d.this.lhF != null)
            {
              ??? = d.c(d.this).kYb;
              if (??? == null) {
                continue;
              }
              ??? = ((com.tencent.mm.media.j.b.a)???).kYz;
              if (??? == null) {
                continue;
              }
              ??? = ((ByteBuffer)???).asIntBuffer();
              if (??? != null)
              {
                ((IntBuffer)???).position(0);
                arrayOfInt = new int[((IntBuffer)???).remaining()];
                ((IntBuffer)???).get(arrayOfInt);
                localh = d.this.lhF;
                i = d.this.lgJ;
                j = d.this.lgK;
                p.k(arrayOfInt, "data");
                if (localh.bufId >= 0) {
                  break label256;
                }
                Log.e("MicroMsg.X264TransEncoder", "writeRGBData error, buffId error");
              }
            }
            if ((d.this.lhF != null) && (d.this.lgO.Fcd == d.c.FaV))
            {
              d.this.lhF.stop(false);
              if (d.this.lgH != null) {
                d.this.lgH.a(new d.4.1(this));
              }
              d.a(d.this).release();
              d.d(d.this);
              if (d.this.lgO != null) {
                d.this.lgO.a(d.c.FaW);
              }
            }
            AppMethodBeat.o(93403);
            return null;
            ??? = null;
            continue;
            ??? = null;
          }
          label256:
          synchronized (localh.aFF)
          {
            localh.kUm.postToWorker((Runnable)new h.c(localh, i, j, arrayOfInt));
            continue;
            localObject2 = finally;
            AppMethodBeat.o(93403);
            throw localObject2;
          }
        }
      }
    };
    aZz();
    paramInt = this.lgX.audioSampleRate;
    i = this.lgX.audioBitrate;
    int j = this.lgX.audioChannelCount;
    if (this.lgX.lJL == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.lgH = new a(paramInt, i, j, com.tencent.mm.plugin.sight.base.c.aw(true, bool));
      this.lgH.uf(this.lhd);
      paramInt = this.lgH.J(this.bufId, com.tencent.mm.plugin.sight.base.f.aYe(this.lgC));
      Log.i("MicroMsg.Media.X264MP4MuxRecorder", "initImpl used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      if (paramInt == 0) {
        break;
      }
      localObject = com.tencent.mm.media.k.f.laB;
      com.tencent.mm.media.k.f.aWa();
      AppMethodBeat.o(93411);
      return false;
    }
    AppMethodBeat.o(93411);
    return true;
  }
  
  public final void E(Runnable paramRunnable)
  {
    AppMethodBeat.i(93415);
    synchronized (this.lgB)
    {
      this.lhc = paramRunnable;
      Log.i("MicroMsg.Media.X264MP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", new Object[] { paramRunnable });
      if ((this.lhF == null) || ((this.lgH == null) && (!this.lhf)))
      {
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
        if (paramRunnable != null) {
          MMHandlerThread.postToMainThread(paramRunnable);
        }
        AppMethodBeat.o(93415);
        return;
      }
      if ((this.lgO != null) && (this.lgO.Fcd == d.c.FaW))
      {
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "stop, already in stop videoRecordStatus");
        if (this.lgH != null) {
          this.lgH.clear();
        }
        if (paramRunnable != null) {
          MMHandlerThread.postToMainThread(paramRunnable);
        }
        AppMethodBeat.o(93415);
        return;
      }
      this.lhw = null;
      this.lgD = ((int)Util.ticksToNow(this.lhF.startTime));
      if (this.lgO != null)
      {
        paramRunnable = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aWb();
        this.lgO.a(d.c.FaU);
      }
      AppMethodBeat.o(93415);
      return;
    }
  }
  
  public final void ON(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void OO(String paramString)
  {
    this.lgT = paramString;
  }
  
  public final void P(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93425);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    this.lgP = paramInt1;
    this.lgM = paramInt2;
    this.lgN = paramInt3;
    this.lhi.tm(this.lgP);
    aZz();
    if ((this.lgO != null) && (this.lgO.Fcd == d.c.Fbb)) {
      this.lgO.a(d.c.FaT);
    }
    AppMethodBeat.o(93425);
  }
  
  public final void a(d.a parama)
  {
    this.lhb = parama;
  }
  
  public final String aZC()
  {
    return this.lgT;
  }
  
  public final float aZD()
  {
    return this.lgE;
  }
  
  public final long aZE()
  {
    AppMethodBeat.i(93420);
    synchronized (this.lgB)
    {
      if (this.lhF != null)
      {
        long l = Util.ticksToNow(this.lhF.startTime);
        AppMethodBeat.o(93420);
        return l;
      }
      AppMethodBeat.o(93420);
      return 0L;
    }
  }
  
  public final d.c aZF()
  {
    return this.lgO.Fcd;
  }
  
  public final int aZG()
  {
    AppMethodBeat.i(93422);
    int i = Math.round(this.lgD / 1000.0F);
    AppMethodBeat.o(93422);
    return i;
  }
  
  public final Point aZH()
  {
    AppMethodBeat.i(93423);
    Point localPoint = new Point(this.lgM, this.lgN);
    AppMethodBeat.o(93423);
    return localPoint;
  }
  
  public final int aZI()
  {
    return this.lgP;
  }
  
  public final boolean aZJ()
  {
    return this.lgZ;
  }
  
  public final com.tencent.mm.audio.b.c.a aZK()
  {
    AppMethodBeat.i(93426);
    if (this.lgH != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.lgH.eTE();
      AppMethodBeat.o(93426);
      return locala;
    }
    AppMethodBeat.o(93426);
    return null;
  }
  
  public final void aZL()
  {
    this.lhe = false;
  }
  
  public final String aZe()
  {
    return this.thumbPath;
  }
  
  public final void aZy() {}
  
  public final void av(float paramFloat)
  {
    AppMethodBeat.i(93428);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.lgG = paramFloat;
    AppMethodBeat.o(93428);
  }
  
  /* Error */
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 668
    //   3: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 199
    //   8: ldc_w 670
    //   11: iconst_3
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: iload_1
    //   18: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: iload_2
    //   25: invokestatic 407	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   28: aastore
    //   29: dup
    //   30: iconst_2
    //   31: iload_3
    //   32: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   35: aastore
    //   36: invokestatic 285	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: aload_0
    //   40: getfield 142	com/tencent/mm/media/widget/c/d:lgV	Lcom/tencent/mm/plugin/mmsight/model/c;
    //   43: invokevirtual 673	com/tencent/mm/plugin/mmsight/model/c:reset	()V
    //   46: aload_0
    //   47: iconst_0
    //   48: putfield 103	com/tencent/mm/media/widget/c/d:lgD	I
    //   51: aload_0
    //   52: getfield 146	com/tencent/mm/media/widget/c/d:lgW	Lcom/tencent/mm/plugin/mmsight/model/c;
    //   55: invokevirtual 673	com/tencent/mm/plugin/mmsight/model/c:reset	()V
    //   58: aload_0
    //   59: iconst_0
    //   60: putfield 127	com/tencent/mm/media/widget/c/d:lgS	Z
    //   63: aload_0
    //   64: iload_2
    //   65: putfield 154	com/tencent/mm/media/widget/c/d:lft	Z
    //   68: aload_0
    //   69: iload_3
    //   70: putfield 156	com/tencent/mm/media/widget/c/d:lha	I
    //   73: aload_0
    //   74: getfield 197	com/tencent/mm/media/widget/c/d:lgO	Lcom/tencent/mm/plugin/mmsight/model/a/s;
    //   77: getstatic 676	com/tencent/mm/plugin/mmsight/model/a/d$c:FaS	Lcom/tencent/mm/plugin/mmsight/model/a/d$c;
    //   80: invokevirtual 438	com/tencent/mm/plugin/mmsight/model/a/s:a	(Lcom/tencent/mm/plugin/mmsight/model/a/d$c;)V
    //   83: aload_0
    //   84: getfield 101	com/tencent/mm/media/widget/c/d:lgC	Ljava/lang/String;
    //   87: invokestatic 370	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   90: ifeq +19 -> 109
    //   93: ldc 199
    //   95: ldc_w 678
    //   98: invokestatic 247	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: ldc_w 668
    //   104: invokestatic 216	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: iconst_m1
    //   108: ireturn
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 101	com/tencent/mm/media/widget/c/d:lgC	Ljava/lang/String;
    //   114: invokestatic 681	com/tencent/mm/vfs/u:bBW	(Ljava/lang/String;)Ljava/lang/String;
    //   117: putfield 683	com/tencent/mm/media/widget/c/d:mFileName	Ljava/lang/String;
    //   120: aload_0
    //   121: getfield 101	com/tencent/mm/media/widget/c/d:lgC	Ljava/lang/String;
    //   124: invokestatic 686	com/tencent/mm/vfs/u:bBT	(Ljava/lang/String;)Ljava/lang/String;
    //   127: astore 5
    //   129: aload 5
    //   131: astore 4
    //   133: aload 5
    //   135: ldc_w 688
    //   138: invokevirtual 691	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   141: ifne +26 -> 167
    //   144: new 483	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 510	java/lang/StringBuilder:<init>	()V
    //   151: aload 5
    //   153: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 688
    //   159: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 502	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: astore 4
    //   167: aload_0
    //   168: new 483	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 510	java/lang/StringBuilder:<init>	()V
    //   175: aload 4
    //   177: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc_w 693
    //   183: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 502	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: putfield 125	com/tencent/mm/media/widget/c/d:lgR	Ljava/lang/String;
    //   192: ldc 199
    //   194: ldc_w 695
    //   197: iconst_2
    //   198: anewarray 4	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: aload_0
    //   204: getfield 101	com/tencent/mm/media/widget/c/d:lgC	Ljava/lang/String;
    //   207: aastore
    //   208: dup
    //   209: iconst_1
    //   210: aload_0
    //   211: getfield 125	com/tencent/mm/media/widget/c/d:lgR	Ljava/lang/String;
    //   214: aastore
    //   215: invokestatic 285	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: aload_0
    //   219: iload_1
    //   220: putfield 263	com/tencent/mm/media/widget/c/d:lgP	I
    //   223: aload_0
    //   224: getfield 148	com/tencent/mm/media/widget/c/d:kfR	Z
    //   227: ifne +14 -> 241
    //   230: aload_0
    //   231: iload_1
    //   232: invokespecial 697	com/tencent/mm/media/widget/c/d:uv	(I)Z
    //   235: pop
    //   236: aload_0
    //   237: iconst_1
    //   238: putfield 148	com/tencent/mm/media/widget/c/d:kfR	Z
    //   241: aload_0
    //   242: getfield 97	com/tencent/mm/media/widget/c/d:lgB	Ljava/lang/Object;
    //   245: astore 4
    //   247: aload 4
    //   249: monitorenter
    //   250: aload_0
    //   251: getfield 332	com/tencent/mm/media/widget/c/d:lhF	Lcom/tencent/mm/media/e/h;
    //   254: invokevirtual 700	com/tencent/mm/media/e/h:start	()V
    //   257: aload 4
    //   259: monitorexit
    //   260: aload_0
    //   261: getfield 164	com/tencent/mm/media/widget/c/d:lhf	Z
    //   264: ifne +126 -> 390
    //   267: aload_0
    //   268: getfield 160	com/tencent/mm/media/widget/c/d:lhd	Z
    //   271: ifne +119 -> 390
    //   274: aload_0
    //   275: getfield 561	com/tencent/mm/media/widget/c/d:lgH	Lcom/tencent/mm/plugin/mmsight/model/a/c;
    //   278: new 18	com/tencent/mm/media/widget/c/d$5
    //   281: dup
    //   282: aload_0
    //   283: invokespecial 701	com/tencent/mm/media/widget/c/d$5:<init>	(Lcom/tencent/mm/media/widget/c/d;)V
    //   286: invokeinterface 704 2 0
    //   291: istore_1
    //   292: ldc 199
    //   294: ldc_w 706
    //   297: iconst_1
    //   298: anewarray 4	java/lang/Object
    //   301: dup
    //   302: iconst_0
    //   303: iload_1
    //   304: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   307: aastore
    //   308: invokestatic 285	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   311: aload_0
    //   312: iconst_0
    //   313: putfield 150	com/tencent/mm/media/widget/c/d:lgZ	Z
    //   316: iload_1
    //   317: ifeq +60 -> 377
    //   320: aload_0
    //   321: getfield 197	com/tencent/mm/media/widget/c/d:lgO	Lcom/tencent/mm/plugin/mmsight/model/a/s;
    //   324: getstatic 709	com/tencent/mm/plugin/mmsight/model/a/d$c:FaZ	Lcom/tencent/mm/plugin/mmsight/model/a/d$c;
    //   327: invokevirtual 438	com/tencent/mm/plugin/mmsight/model/a/s:a	(Lcom/tencent/mm/plugin/mmsight/model/a/d$c;)V
    //   330: ldc_w 668
    //   333: invokestatic 216	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   336: iload_1
    //   337: ireturn
    //   338: astore 4
    //   340: ldc 199
    //   342: ldc_w 711
    //   345: iconst_1
    //   346: anewarray 4	java/lang/Object
    //   349: dup
    //   350: iconst_0
    //   351: aload 4
    //   353: invokevirtual 714	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   356: aastore
    //   357: invokestatic 716	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   360: goto -168 -> 192
    //   363: astore 5
    //   365: aload 4
    //   367: monitorexit
    //   368: ldc_w 668
    //   371: invokestatic 216	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   374: aload 5
    //   376: athrow
    //   377: aload_0
    //   378: getfield 197	com/tencent/mm/media/widget/c/d:lgO	Lcom/tencent/mm/plugin/mmsight/model/a/s;
    //   381: getstatic 719	com/tencent/mm/plugin/mmsight/model/a/d$c:Fba	Lcom/tencent/mm/plugin/mmsight/model/a/d$c;
    //   384: invokevirtual 438	com/tencent/mm/plugin/mmsight/model/a/s:a	(Lcom/tencent/mm/plugin/mmsight/model/a/d$c;)V
    //   387: goto -57 -> 330
    //   390: ldc 199
    //   392: ldc_w 721
    //   395: invokestatic 388	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   398: aload_0
    //   399: getfield 197	com/tencent/mm/media/widget/c/d:lgO	Lcom/tencent/mm/plugin/mmsight/model/a/s;
    //   402: getstatic 622	com/tencent/mm/plugin/mmsight/model/a/d$c:FaT	Lcom/tencent/mm/plugin/mmsight/model/a/d$c;
    //   405: invokevirtual 438	com/tencent/mm/plugin/mmsight/model/a/s:a	(Lcom/tencent/mm/plugin/mmsight/model/a/d$c;)V
    //   408: aload_0
    //   409: iconst_0
    //   410: putfield 150	com/tencent/mm/media/widget/c/d:lgZ	Z
    //   413: iconst_0
    //   414: istore_1
    //   415: goto -85 -> 330
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	this	d
    //   0	418	1	paramInt1	int
    //   0	418	2	paramBoolean	boolean
    //   0	418	3	paramInt2	int
    //   338	28	4	localException	Exception
    //   127	25	5	str	String
    //   363	12	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   109	129	338	java/lang/Exception
    //   133	167	338	java/lang/Exception
    //   167	192	338	java/lang/Exception
    //   250	260	363	finally
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(93417);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "cancel record");
    synchronized (this.lgB)
    {
      if ((this.lhF == null) || ((this.lgH == null) && (!this.lhf)))
      {
        Log.e("MicroMsg.Media.X264MP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
        AppMethodBeat.o(93417);
        return;
      }
      this.lgO.a(d.c.FaV);
      this.lhF.stop(true);
      if (this.lgH != null) {
        this.lgH.a(new d.7(this));
      }
      if (this.bufId >= 0)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        this.lgO.a(d.c.FaW);
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
      if (this.lgH != null) {
        this.lgH.clear();
      }
      if (this.lhi != null) {
        this.lhi.release();
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
  
  public final void fU(boolean paramBoolean)
  {
    this.lhd = paramBoolean;
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.lgC;
  }
  
  public final g getFrameDataCallback()
  {
    return this.lhw;
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
    return this.lft;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(93424);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "pause");
    if ((this.lgO != null) && (this.lgO.Fcd == d.c.FaT)) {
      this.lgO.a(d.c.Fbb);
    }
    AppMethodBeat.o(93424);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(93419);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", new Object[] { this.lhF, this.lgH, this.lgY });
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s", new Object[] { this.lhF, this.lgH });
    synchronized (this.lgB)
    {
      this.lhF = null;
      this.lgH = null;
      this.lgY = null;
      this.kfR = false;
      this.lgZ = false;
      AppMethodBeat.o(93419);
      return;
    }
  }
  
  public final void setFilePath(String paramString)
  {
    this.lgC = paramString;
  }
  
  public final void setMirror(boolean paramBoolean) {}
  
  public final void setMute(boolean paramBoolean)
  {
    this.lhf = paramBoolean;
  }
  
  public final void u(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(93421);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    int i = paramInt3;
    if (paramInt3 % 16 != 0) {
      i = com.tencent.mm.plugin.mmsight.d.WV(paramInt3);
    }
    paramInt3 = paramInt4;
    if (paramInt4 % 16 != 0) {
      paramInt3 = com.tencent.mm.plugin.mmsight.d.WV(paramInt4);
    }
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt3) });
    this.lgM = paramInt1;
    this.lgN = paramInt2;
    if (j.FbH.k(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      Log.i("MicroMsg.Media.X264MP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = Util.currentTicks();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        j.FbH.as(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      Log.i("MicroMsg.Media.X264MP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    }
    AppMethodBeat.o(93421);
  }
  
  public final boolean uw(int paramInt)
  {
    AppMethodBeat.i(93413);
    if (!this.kfR)
    {
      Log.i("MicroMsg.Media.X264MP4MuxRecorder", "preInit, cameraOrientation");
      boolean bool = uv(paramInt);
      this.kfR = true;
      Log.i("MicroMsg.Media.X264MP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(93413);
      return bool;
    }
    com.tencent.mm.media.k.f localf = com.tencent.mm.media.k.f.laB;
    com.tencent.mm.media.k.f.aVY();
    AppMethodBeat.o(93413);
    return true;
  }
  
  public final void ux(int paramInt)
  {
    AppMethodBeat.i(93427);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.lgF = paramInt;
    AppMethodBeat.o(93427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.d
 * JD-Core Version:    0.7.0.1
 */