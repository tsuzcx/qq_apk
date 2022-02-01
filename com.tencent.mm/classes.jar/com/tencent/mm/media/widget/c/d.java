package com.tencent.mm.media.widget.c;

import android.graphics.Point;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.a.c.b;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.m;
import com.tencent.mm.plugin.mmsight.model.a.s;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import kotlin.ah;

public final class d
  implements b
{
  protected int bufId;
  private EGLContext eXL;
  protected String mFileName;
  protected boolean mGp;
  protected String md5;
  private boolean nJm;
  protected boolean nKe;
  protected String nLB;
  protected boolean nLC;
  protected String nLD;
  protected boolean nLE;
  protected com.tencent.mm.plugin.mmsight.model.c nLF;
  protected com.tencent.mm.plugin.mmsight.model.c nLG;
  protected VideoTransPara nLH;
  protected m nLI;
  protected boolean nLJ;
  protected int nLK;
  protected d.a nLL;
  protected Runnable nLM;
  protected boolean nLN;
  protected boolean nLO;
  protected boolean nLP;
  private com.tencent.mm.media.i.a nLS;
  private final Object nLl;
  protected String nLm;
  protected int nLn;
  protected float nLo;
  private int nLp;
  private float nLq;
  protected com.tencent.mm.plugin.mmsight.model.a.c nLr;
  protected int nLt;
  protected int nLu;
  protected int nLv;
  protected int nLw;
  protected int nLx;
  protected s nLy;
  protected int nLz;
  protected com.tencent.mm.plugin.mmsight.model.g nMg;
  protected com.tencent.mm.media.e.g nMp;
  private com.tencent.mm.media.j.a nMq;
  private boolean nMr;
  private int textureId;
  protected String thumbPath;
  
  private d(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(93409);
    this.nLl = new Object();
    this.nLm = "";
    this.nLn = 0;
    this.nLo = 0.0F;
    this.nLp = -1;
    this.nLq = -1.0F;
    this.nLt = 480;
    this.nLu = 640;
    this.nLv = 1600000;
    this.nLw = 480;
    this.nLx = 640;
    this.bufId = -1;
    this.nLB = null;
    this.nLC = false;
    this.thumbPath = null;
    this.nLD = null;
    this.nLE = false;
    this.nLF = new com.tencent.mm.plugin.mmsight.model.c("yuvRecorderWriteData");
    this.nLG = new com.tencent.mm.plugin.mmsight.model.c("frameCountCallback");
    this.mGp = false;
    this.nLJ = false;
    this.md5 = "";
    this.nKe = false;
    this.nLK = 0;
    this.nLM = null;
    this.nLN = false;
    this.nLO = true;
    this.nLP = false;
    this.nJm = false;
    this.nLS = null;
    this.eXL = null;
    this.nMq = null;
    this.textureId = -1;
    this.nMr = false;
    this.nMg = new com.tencent.mm.plugin.mmsight.model.g()
    {
      public final boolean onFrameData(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(93399);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          Log.e("MicroMsg.Media.X264MP4MuxRecorder", "preview callback data is null");
          AppMethodBeat.o(93399);
          return false;
        }
        if ((d.this.nLy.KXM == d.c.KWC) || (d.this.nLy.KXM == d.c.KWD))
        {
          if (d.this.nLy.KXM == d.c.KWD)
          {
            d.this.nLy.KXM = d.c.KWE;
            Log.v("MicroMsg.Media.X264MP4MuxRecorder", "forward one more frame");
          }
          d.this.nLG.ss(1L);
          if (d.this.nLr != null) {
            d.this.nLr.gcw();
          }
          d.a(d.this).a(paramAnonymousArrayOfByte, System.nanoTime(), new kotlin.g.a.b() {});
          d.this.nLF.ss(1L);
          AppMethodBeat.o(93399);
          return true;
        }
        AppMethodBeat.o(93399);
        return false;
      }
    };
    this.nLH = paramVideoTransPara;
    this.nLt = paramVideoTransPara.width;
    this.nLu = paramVideoTransPara.height;
    this.nLy = new s();
    Log.d("MicroMsg.Media.X264MP4MuxRecorder", "create X264MP4MuxRecorder, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(this.nLt), Integer.valueOf(this.nLu) });
    AppMethodBeat.o(93409);
  }
  
  public d(VideoTransPara paramVideoTransPara, com.tencent.mm.media.j.a parama, EGLContext paramEGLContext, int paramInt)
  {
    this(paramVideoTransPara);
    AppMethodBeat.i(237476);
    this.eXL = paramEGLContext;
    this.nMq = parama;
    this.textureId = paramInt;
    this.nLS = new com.tencent.mm.media.i.a(parama);
    paramVideoTransPara = com.tencent.mm.media.util.f.nFE;
    com.tencent.mm.media.util.f.bqF();
    AppMethodBeat.o(237476);
  }
  
  private void bux()
  {
    AppMethodBeat.i(93412);
    int i = this.nLt;
    int j = this.nLu;
    this.nLS.ej(i, j);
    this.nLS.th(this.nLz);
    this.nLS.el(this.nLw, this.nLx);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "outputWidth: %s, outputHeight: %s, cameraPreviewWidth: %s, cameraPreviewHeight: %s, getDataRotate: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(this.nLw), Integer.valueOf(this.nLx), Integer.valueOf(this.nLz) });
    AppMethodBeat.o(93412);
  }
  
  private boolean uv(int paramInt)
  {
    AppMethodBeat.i(93411);
    long l = Util.currentTicks();
    this.nLv = this.nLH.videoBitrate;
    if (this.nLt % 2 != 0) {
      this.nLt += 1;
    }
    if (this.nLu % 2 != 0) {
      this.nLu += 1;
    }
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "real width:%d, height:%d", new Object[] { Integer.valueOf(this.nLt), Integer.valueOf(this.nLu) });
    this.bufId = SightVideoJNI.initDataBufferForMMSightLock(this.nLw, this.nLx, paramInt, this.nLt, this.nLu, this.nLH.fps, this.nLv, this.nLH.oBP, 8, this.nLH.oBO, 23.0F, false, true, this.nLH.duration, false, false, this.nMr);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "init, bufId: %s", new Object[] { Integer.valueOf(this.bufId) });
    if (this.bufId < 0)
    {
      Log.e("MicroMsg.Media.X264MP4MuxRecorder", "init failed!");
      AppMethodBeat.o(93411);
      return false;
    }
    this.nLz = paramInt;
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "mTargetRate " + this.nLv + "  videoParams.fps: " + this.nLH.fps + " mTargetHeight:" + this.nLu + " mTargetWidth:" + this.nLt);
    this.nMp = new com.tencent.mm.media.e.g(this.bufId, this.nLt, this.nLu);
    this.nLS.a(this.eXL, this.nLt, this.nLu, new kotlin.g.a.b() {});
    this.nLS.nBl = new kotlin.g.a.b()
    {
      private ah buP()
      {
        AppMethodBeat.i(237478);
        synchronized (d.b(d.this))
        {
          if (d.this.nMp != null)
          {
            localObject1 = d.c(d.this).nDm;
            if (localObject1 != null) {
              break label207;
            }
          }
          for (Object localObject1 = null;; localObject1 = null)
          {
            if (localObject1 != null)
            {
              ((IntBuffer)localObject1).position(0);
              int[] arrayOfInt = new int[((IntBuffer)localObject1).remaining()];
              ((IntBuffer)localObject1).get(arrayOfInt);
              d.this.nMp.h(arrayOfInt, d.this.nLt, d.this.nLu);
            }
            if ((d.this.nMp != null) && (d.this.nLy.KXM == d.c.KWE))
            {
              d.this.nMp.stop(false);
              if (d.this.nLr != null) {
                d.this.nLr.a(new c.b()
                {
                  public final void buN()
                  {
                    AppMethodBeat.i(237461);
                    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "aac stop finish");
                    AppMethodBeat.o(237461);
                  }
                });
              }
              d.a(d.this).release();
              d.d(d.this);
              if (d.this.nLy != null) {
                d.this.nLy.a(d.c.KWF);
              }
            }
            AppMethodBeat.o(237478);
            return null;
            label207:
            localObject1 = ((com.tencent.mm.media.j.b.a)localObject1).nDH;
            if (localObject1 != null) {
              break;
            }
          }
          localObject1 = ((ByteBuffer)localObject1).asIntBuffer();
        }
      }
    };
    bux();
    paramInt = this.nLH.audioSampleRate;
    int i = this.nLH.audioBitrate;
    int j = this.nLH.audioChannelCount;
    if (this.nLH.oCn == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.nLr = new a(paramInt, i, j, com.tencent.mm.plugin.sight.base.c.aP(true, bool));
      this.nLr.yt(this.nLN);
      paramInt = this.nLr.L(this.bufId, com.tencent.mm.plugin.sight.base.f.aVV(this.nLm));
      Log.i("MicroMsg.Media.X264MP4MuxRecorder", "initImpl used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
      if (paramInt == 0) {
        break;
      }
      com.tencent.mm.media.util.f localf = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.bqI();
      AppMethodBeat.o(93411);
      return false;
    }
    AppMethodBeat.o(93411);
    return true;
  }
  
  public final void A(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(93421);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    int i = paramInt3;
    if (paramInt3 % 16 != 0) {
      i = com.tencent.mm.plugin.mmsight.d.aaX(paramInt3);
    }
    paramInt3 = paramInt4;
    if (paramInt4 % 16 != 0) {
      paramInt3 = com.tencent.mm.plugin.mmsight.d.aaX(paramInt4);
    }
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "setSize, after align, targetWidth: %d, targetHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt3) });
    this.nLw = paramInt1;
    this.nLx = paramInt2;
    AppMethodBeat.o(93421);
  }
  
  public final void Hd(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void He(String paramString)
  {
    this.nLD = paramString;
  }
  
  public final void J(Runnable paramRunnable)
  {
    AppMethodBeat.i(93415);
    synchronized (this.nLl)
    {
      this.nLM = paramRunnable;
      Log.i("MicroMsg.Media.X264MP4MuxRecorder", "!!!!!stop, stopCallback: %s!!!", new Object[] { paramRunnable });
      if ((this.nMp == null) || ((this.nLr == null) && (!this.nLP)))
      {
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
        if (paramRunnable != null) {
          MMHandlerThread.postToMainThread(paramRunnable);
        }
        AppMethodBeat.o(93415);
        return;
      }
      if ((this.nLy != null) && (this.nLy.KXM == d.c.KWF))
      {
        Log.i("MicroMsg.Media.X264MP4MuxRecorder", "stop, already in stop videoRecordStatus");
        if (this.nLr != null) {
          this.nLr.clear();
        }
        if (paramRunnable != null) {
          MMHandlerThread.postToMainThread(paramRunnable);
        }
        AppMethodBeat.o(93415);
        return;
      }
      this.nMg = null;
      this.nLn = ((int)Util.ticksToNow(this.nMp.startTime));
      if (this.nLy != null)
      {
        paramRunnable = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.bqJ();
        this.nLy.a(d.c.KWD);
      }
      AppMethodBeat.o(93415);
      return;
    }
  }
  
  public final void a(d.a parama)
  {
    this.nLL = parama;
  }
  
  public final void ae(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93425);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    this.nLz = paramInt1;
    this.nLw = paramInt2;
    this.nLx = paramInt3;
    this.nLS.th(this.nLz);
    bux();
    if ((this.nLy != null) && (this.nLy.KXM == d.c.KWK)) {
      this.nLy.a(d.c.KWC);
    }
    AppMethodBeat.o(93425);
  }
  
  /* Error */
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 624
    //   3: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 199
    //   8: ldc_w 626
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
    //   40: getfield 143	com/tencent/mm/media/widget/c/d:nLF	Lcom/tencent/mm/plugin/mmsight/model/c;
    //   43: invokevirtual 629	com/tencent/mm/plugin/mmsight/model/c:reset	()V
    //   46: aload_0
    //   47: iconst_0
    //   48: putfield 104	com/tencent/mm/media/widget/c/d:nLn	I
    //   51: aload_0
    //   52: getfield 147	com/tencent/mm/media/widget/c/d:nLG	Lcom/tencent/mm/plugin/mmsight/model/c;
    //   55: invokevirtual 629	com/tencent/mm/plugin/mmsight/model/c:reset	()V
    //   58: aload_0
    //   59: iconst_0
    //   60: putfield 128	com/tencent/mm/media/widget/c/d:nLC	Z
    //   63: aload_0
    //   64: iload_2
    //   65: putfield 155	com/tencent/mm/media/widget/c/d:nKe	Z
    //   68: aload_0
    //   69: iload_3
    //   70: putfield 157	com/tencent/mm/media/widget/c/d:nLK	I
    //   73: aload_0
    //   74: getfield 197	com/tencent/mm/media/widget/c/d:nLy	Lcom/tencent/mm/plugin/mmsight/model/a/s;
    //   77: getstatic 632	com/tencent/mm/plugin/mmsight/model/a/d$c:KWB	Lcom/tencent/mm/plugin/mmsight/model/a/d$c;
    //   80: invokevirtual 445	com/tencent/mm/plugin/mmsight/model/a/s:a	(Lcom/tencent/mm/plugin/mmsight/model/a/d$c;)V
    //   83: aload_0
    //   84: getfield 102	com/tencent/mm/media/widget/c/d:nLm	Ljava/lang/String;
    //   87: invokestatic 370	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   90: ifeq +19 -> 109
    //   93: ldc 199
    //   95: ldc_w 634
    //   98: invokestatic 247	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: ldc_w 624
    //   104: invokestatic 216	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: iconst_m1
    //   108: ireturn
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 102	com/tencent/mm/media/widget/c/d:nLm	Ljava/lang/String;
    //   114: invokestatic 637	com/tencent/mm/vfs/y:bEq	(Ljava/lang/String;)Ljava/lang/String;
    //   117: putfield 639	com/tencent/mm/media/widget/c/d:mFileName	Ljava/lang/String;
    //   120: aload_0
    //   121: getfield 102	com/tencent/mm/media/widget/c/d:nLm	Ljava/lang/String;
    //   124: invokestatic 642	com/tencent/mm/vfs/y:bEo	(Ljava/lang/String;)Ljava/lang/String;
    //   127: astore 5
    //   129: aload 5
    //   131: astore 4
    //   133: aload 5
    //   135: ldc_w 644
    //   138: invokevirtual 647	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   141: ifne +26 -> 167
    //   144: new 490	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 648	java/lang/StringBuilder:<init>	()V
    //   151: aload 5
    //   153: invokevirtual 502	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 644
    //   159: invokevirtual 502	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 509	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: astore 4
    //   167: aload_0
    //   168: new 490	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 648	java/lang/StringBuilder:<init>	()V
    //   175: aload 4
    //   177: invokevirtual 502	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc_w 650
    //   183: invokevirtual 502	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 509	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: putfield 126	com/tencent/mm/media/widget/c/d:nLB	Ljava/lang/String;
    //   192: ldc 199
    //   194: ldc_w 652
    //   197: iconst_2
    //   198: anewarray 4	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: aload_0
    //   204: getfield 102	com/tencent/mm/media/widget/c/d:nLm	Ljava/lang/String;
    //   207: aastore
    //   208: dup
    //   209: iconst_1
    //   210: aload_0
    //   211: getfield 126	com/tencent/mm/media/widget/c/d:nLB	Ljava/lang/String;
    //   214: aastore
    //   215: invokestatic 285	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: aload_0
    //   219: iload_1
    //   220: putfield 263	com/tencent/mm/media/widget/c/d:nLz	I
    //   223: aload_0
    //   224: getfield 149	com/tencent/mm/media/widget/c/d:mGp	Z
    //   227: ifne +14 -> 241
    //   230: aload_0
    //   231: iload_1
    //   232: invokespecial 654	com/tencent/mm/media/widget/c/d:uv	(I)Z
    //   235: pop
    //   236: aload_0
    //   237: iconst_1
    //   238: putfield 149	com/tencent/mm/media/widget/c/d:mGp	Z
    //   241: aload_0
    //   242: getfield 98	com/tencent/mm/media/widget/c/d:nLl	Ljava/lang/Object;
    //   245: astore 4
    //   247: aload 4
    //   249: monitorenter
    //   250: aload_0
    //   251: getfield 332	com/tencent/mm/media/widget/c/d:nMp	Lcom/tencent/mm/media/e/g;
    //   254: invokevirtual 657	com/tencent/mm/media/e/g:start	()V
    //   257: aload 4
    //   259: monitorexit
    //   260: aload_0
    //   261: getfield 165	com/tencent/mm/media/widget/c/d:nLP	Z
    //   264: ifne +126 -> 390
    //   267: aload_0
    //   268: getfield 161	com/tencent/mm/media/widget/c/d:nLN	Z
    //   271: ifne +119 -> 390
    //   274: aload_0
    //   275: getfield 545	com/tencent/mm/media/widget/c/d:nLr	Lcom/tencent/mm/plugin/mmsight/model/a/c;
    //   278: new 18	com/tencent/mm/media/widget/c/d$4
    //   281: dup
    //   282: aload_0
    //   283: invokespecial 658	com/tencent/mm/media/widget/c/d$4:<init>	(Lcom/tencent/mm/media/widget/c/d;)V
    //   286: invokeinterface 661 2 0
    //   291: istore_1
    //   292: ldc 199
    //   294: ldc_w 663
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
    //   313: putfield 151	com/tencent/mm/media/widget/c/d:nLJ	Z
    //   316: iload_1
    //   317: ifeq +60 -> 377
    //   320: aload_0
    //   321: getfield 197	com/tencent/mm/media/widget/c/d:nLy	Lcom/tencent/mm/plugin/mmsight/model/a/s;
    //   324: getstatic 666	com/tencent/mm/plugin/mmsight/model/a/d$c:KWI	Lcom/tencent/mm/plugin/mmsight/model/a/d$c;
    //   327: invokevirtual 445	com/tencent/mm/plugin/mmsight/model/a/s:a	(Lcom/tencent/mm/plugin/mmsight/model/a/d$c;)V
    //   330: ldc_w 624
    //   333: invokestatic 216	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   336: iload_1
    //   337: ireturn
    //   338: astore 4
    //   340: ldc 199
    //   342: ldc_w 668
    //   345: iconst_1
    //   346: anewarray 4	java/lang/Object
    //   349: dup
    //   350: iconst_0
    //   351: aload 4
    //   353: invokevirtual 671	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   356: aastore
    //   357: invokestatic 673	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   360: goto -168 -> 192
    //   363: astore 5
    //   365: aload 4
    //   367: monitorexit
    //   368: ldc_w 624
    //   371: invokestatic 216	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   374: aload 5
    //   376: athrow
    //   377: aload_0
    //   378: getfield 197	com/tencent/mm/media/widget/c/d:nLy	Lcom/tencent/mm/plugin/mmsight/model/a/s;
    //   381: getstatic 676	com/tencent/mm/plugin/mmsight/model/a/d$c:KWJ	Lcom/tencent/mm/plugin/mmsight/model/a/d$c;
    //   384: invokevirtual 445	com/tencent/mm/plugin/mmsight/model/a/s:a	(Lcom/tencent/mm/plugin/mmsight/model/a/d$c;)V
    //   387: goto -57 -> 330
    //   390: ldc 199
    //   392: ldc_w 678
    //   395: invokestatic 388	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   398: aload_0
    //   399: getfield 197	com/tencent/mm/media/widget/c/d:nLy	Lcom/tencent/mm/plugin/mmsight/model/a/s;
    //   402: getstatic 620	com/tencent/mm/plugin/mmsight/model/a/d$c:KWC	Lcom/tencent/mm/plugin/mmsight/model/a/d$c;
    //   405: invokevirtual 445	com/tencent/mm/plugin/mmsight/model/a/s:a	(Lcom/tencent/mm/plugin/mmsight/model/a/d$c;)V
    //   408: aload_0
    //   409: iconst_0
    //   410: putfield 151	com/tencent/mm/media/widget/c/d:nLJ	Z
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
  
  public final void bq(float paramFloat)
  {
    AppMethodBeat.i(93428);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.nLq = paramFloat;
    AppMethodBeat.o(93428);
  }
  
  public final String buA()
  {
    return this.nLD;
  }
  
  public final float buB()
  {
    return this.nLo;
  }
  
  public final long buC()
  {
    AppMethodBeat.i(93420);
    synchronized (this.nLl)
    {
      if (this.nMp != null)
      {
        long l = Util.ticksToNow(this.nMp.startTime);
        AppMethodBeat.o(93420);
        return l;
      }
      AppMethodBeat.o(93420);
      return 0L;
    }
  }
  
  public final d.c buD()
  {
    return this.nLy.KXM;
  }
  
  public final int buE()
  {
    AppMethodBeat.i(93422);
    int i = Math.round(this.nLn / 1000.0F);
    AppMethodBeat.o(93422);
    return i;
  }
  
  public final Point buF()
  {
    AppMethodBeat.i(93423);
    Point localPoint = new Point(this.nLw, this.nLx);
    AppMethodBeat.o(93423);
    return localPoint;
  }
  
  public final int buG()
  {
    return this.nLz;
  }
  
  public final boolean buH()
  {
    return this.nLJ;
  }
  
  public final com.tencent.mm.audio.b.c.a buI()
  {
    AppMethodBeat.i(93426);
    if (this.nLr != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.nLr.gcx();
      AppMethodBeat.o(93426);
      return locala;
    }
    AppMethodBeat.o(93426);
    return null;
  }
  
  public final void buJ()
  {
    this.nLO = false;
  }
  
  public final String bud()
  {
    return this.thumbPath;
  }
  
  public final void buw()
  {
    AppMethodBeat.i(237612);
    if (this.textureId < 0)
    {
      AppMethodBeat.o(237612);
      return;
    }
    if ((this.nLy.KXM == d.c.KWC) || (this.nLy.KXM == d.c.KWD))
    {
      if (this.nLy.KXM == d.c.KWD)
      {
        this.nLy.KXM = d.c.KWE;
        Log.v("MicroMsg.Media.X264MP4MuxRecorder", "forward one more frame");
      }
      this.nLG.ss(1L);
      if (this.nLr != null) {
        this.nLr.gcw();
      }
      this.nLS.a(this.textureId, System.nanoTime(), false);
      this.nLF.ss(1L);
    }
    AppMethodBeat.o(237612);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(93417);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "cancel record");
    synchronized (this.nLl)
    {
      if ((this.nMp == null) || ((this.nLr == null) && (!this.nLP)))
      {
        Log.e("MicroMsg.Media.X264MP4MuxRecorder", "error, yuvRecorder or aacRecorder is null");
        AppMethodBeat.o(93417);
        return;
      }
      this.nLy.a(d.c.KWE);
      this.nMp.stop(true);
      if (this.nLr != null) {
        this.nLr.a(new c.b()
        {
          public final void buN()
          {
            AppMethodBeat.i(237483);
            Log.i("MicroMsg.Media.X264MP4MuxRecorder", "aac stop finish");
            AppMethodBeat.o(237483);
          }
        });
      }
      if (this.bufId >= 0)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(this.bufId);
        this.nLy.a(d.c.KWF);
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
      if (this.nLr != null) {
        this.nLr.clear();
      }
      if (this.nLS != null) {
        this.nLS.release();
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
  
  public final void gI(boolean paramBoolean)
  {
    this.nLN = paramBoolean;
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.nLm;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.g getFrameDataCallback()
  {
    return this.nMg;
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
    return this.nKe;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(93424);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "pause");
    if ((this.nLy != null) && (this.nLy.KXM == d.c.KWC)) {
      this.nLy.a(d.c.KWK);
    }
    AppMethodBeat.o(93424);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(93419);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s, muxer: %s", new Object[] { this.nMp, this.nLr, this.nLI });
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "reset, yuvRecorder: %s, aacRecorder: %s", new Object[] { this.nMp, this.nLr });
    synchronized (this.nLl)
    {
      this.nMp = null;
      this.nLr = null;
      this.nLI = null;
      this.mGp = false;
      this.nLJ = false;
      AppMethodBeat.o(93419);
      return;
    }
  }
  
  public final void setFilePath(String paramString)
  {
    this.nLm = paramString;
  }
  
  public final void setMirror(boolean paramBoolean) {}
  
  public final void setMute(boolean paramBoolean)
  {
    this.nLP = paramBoolean;
  }
  
  public final boolean uw(int paramInt)
  {
    AppMethodBeat.i(93413);
    if (!this.mGp)
    {
      Log.i("MicroMsg.Media.X264MP4MuxRecorder", "preInit, cameraOrientation");
      boolean bool = uv(paramInt);
      this.mGp = true;
      Log.i("MicroMsg.Media.X264MP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(93413);
      return bool;
    }
    com.tencent.mm.media.util.f localf = com.tencent.mm.media.util.f.nFE;
    com.tencent.mm.media.util.f.bqG();
    AppMethodBeat.o(93413);
    return true;
  }
  
  public final void ux(int paramInt)
  {
    AppMethodBeat.i(93427);
    Log.i("MicroMsg.Media.X264MP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.nLp = paramInt;
    AppMethodBeat.o(93427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.d
 * JD-Core Version:    0.7.0.1
 */