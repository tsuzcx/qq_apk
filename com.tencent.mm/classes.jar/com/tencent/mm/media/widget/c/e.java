package com.tencent.mm.media.widget.c;

import android.graphics.Point;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.c.b;
import com.tencent.mm.plugin.mmsight.model.a.d.a;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.m;
import com.tencent.mm.plugin.mmsight.model.a.p;
import com.tencent.mm.plugin.mmsight.model.a.s;
import com.tencent.mm.plugin.mmsight.model.g;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;

public final class e
  implements b
{
  private String mFileName;
  private boolean mGp;
  private String md5;
  private boolean nKe;
  private String nLB;
  private boolean nLC;
  private String nLD;
  private boolean nLE;
  private VideoTransPara nLH;
  private boolean nLJ;
  private int nLK;
  private d.a nLL;
  private boolean nLO;
  private boolean nLP;
  private long nLZ;
  private String nLm;
  private int nLn;
  private float nLo;
  private int nLp;
  private float nLq;
  private int nLt;
  private int nLu;
  private int nLv;
  private int nLw;
  private int nLx;
  private s nLy;
  private int nLz;
  private HandlerThread nMA;
  private MMHandler nMB;
  private int nMC;
  private int nMD;
  private boolean nME;
  private boolean nMF;
  private int nMG;
  private boolean nMH;
  private boolean nMI;
  private long nMJ;
  private boolean nMK;
  private boolean nMa;
  private g nMg;
  public com.tencent.mm.plugin.mmsight.model.a.c nMw;
  private p nMx;
  private a nMy;
  private com.tencent.mm.plugin.mmsight.model.a.e nMz;
  private String thumbPath;
  
  public e(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(93444);
    this.nMy = null;
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
    this.nLz = 0;
    this.nLB = null;
    this.nMA = null;
    this.nMB = null;
    this.nMC = -1;
    this.nMD = -1;
    this.nME = false;
    this.nMF = false;
    this.thumbPath = null;
    this.nLD = null;
    this.nLE = false;
    this.nLC = false;
    this.mGp = false;
    this.nMG = -1;
    this.nLJ = false;
    this.md5 = "";
    this.nKe = false;
    this.nLK = 0;
    this.nMH = false;
    this.nLO = true;
    this.nMI = false;
    this.nLZ = 0L;
    this.nMJ = 0L;
    this.nLP = false;
    this.nMK = false;
    this.nMg = new g()
    {
      public final boolean onFrameData(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(93431);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          AppMethodBeat.o(93431);
          return false;
        }
        if (e.a(e.this).KXM == d.c.KWC)
        {
          e.a(e.this, paramAnonymousArrayOfByte);
          if (e.b(e.this) != null)
          {
            Message localMessage = Message.obtain();
            localMessage.what = 1;
            localMessage.obj = paramAnonymousArrayOfByte;
            e.b(e.this).sendMessage(localMessage);
          }
          AppMethodBeat.o(93431);
          return true;
        }
        AppMethodBeat.o(93431);
        return false;
      }
    };
    this.nMa = false;
    this.nLH = paramVideoTransPara;
    this.nLt = paramVideoTransPara.width;
    this.nLu = paramVideoTransPara.height;
    this.nLv = paramVideoTransPara.videoBitrate;
    this.nLy = new s();
    this.mGp = false;
    int i;
    boolean bool;
    if (this.nLH.oCn == 1)
    {
      i = 1;
      if (i == 0) {
        break label379;
      }
      Log.i("MicroMsg.WechatSight.PacketMuxerController", "x264YUVMP4MuxRecorderUseFFMpeg hevc");
      bool = true;
    }
    for (;;)
    {
      this.nMK = bool;
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "create X264YUVMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s, enableHevc:%s", new Object[] { Integer.valueOf(this.nLt), Integer.valueOf(this.nLu), Integer.valueOf(this.nLv), Integer.valueOf(paramVideoTransPara.oCn) });
      com.tencent.mm.media.util.f localf = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.bqF();
      if (paramVideoTransPara.oCn == 1)
      {
        paramVideoTransPara = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.brF();
      }
      AppMethodBeat.o(93444);
      return;
      i = 0;
      break;
      label379:
      bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zbB, false);
      Log.i("MicroMsg.WechatSight.PacketMuxerController", "x264YUVMP4MuxRecorderUseFFMpeg:%s", new Object[] { Boolean.valueOf(bool) });
    }
  }
  
  private void buN()
  {
    if (this.nMy != null) {
      this.nMy.nMQ = true;
    }
  }
  
  private void buO()
  {
    AppMethodBeat.i(93456);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::pcm ready");
    if ((this.nMy != null) && (!this.nMy.nMS)) {
      Log.e("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", new Object[] { this.nMy });
    }
    synchronized (this.nMy.nMT)
    {
      uy(this.nMy.nMN);
      if (this.nLy.KXM != d.c.KWJ)
      {
        Log.w("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
        AppMethodBeat.o(93456);
        return;
      }
    }
    this.nLy.a(d.c.KWC);
    this.nMy = new a();
    this.nMy.nMN = this.nMG;
    com.tencent.threadpool.h.ahAA.bm(this.nMy);
    AppMethodBeat.o(93456);
  }
  
  private void buQ()
  {
    boolean bool2 = true;
    AppMethodBeat.i(237486);
    int i = -1;
    if (this.nMx != null)
    {
      i = this.nMx.KXD;
      if (i < 0)
      {
        Log.v("MicroMsg.X264YUVMP4MuxRecorder", "call clear, but bufID error");
        AppMethodBeat.o(237486);
        return;
      }
      this.nMx.stop();
    }
    boolean bool1;
    if (this.nMy == null)
    {
      bool1 = true;
      if ((this.nMy == null) || (!this.nMy.nMR)) {
        break label177;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::clear bufID %d, encodeRunnable null ? %B, markCancel %B", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((i >= 0) && (!uy(i)))
      {
        SightVideoJNI.releaseRecorderBufferRefLock("clear");
        SightVideoJNI.releaseBigSightDataBufferLock(i);
      }
      if (this.nMw != null) {
        this.nMw.a(null);
      }
      if (this.nMA != null) {
        this.nMA.quit();
      }
      AppMethodBeat.o(237486);
      return;
      bool1 = false;
      break;
      label177:
      bool2 = false;
    }
  }
  
  private boolean uv(int paramInt)
  {
    AppMethodBeat.i(93453);
    long l = Util.currentTicks();
    if (com.tencent.mm.plugin.mmsight.model.j.KVJ != null) {
      this.nME = com.tencent.mm.plugin.mmsight.model.j.KVJ.nME;
    }
    this.nLz = paramInt;
    int j;
    int i;
    label76:
    int k;
    label95:
    int m;
    label114:
    int n;
    float f;
    int i1;
    int i2;
    boolean bool2;
    int i3;
    if (!this.nME) {
      if ((paramInt == 90) || (paramInt == 270))
      {
        j = this.nLw;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label301;
        }
        i = this.nLx;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label309;
        }
        k = this.nLu;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label318;
        }
        m = this.nLt;
        n = j;
        j = i;
        i = n;
        n = this.nLv;
        k = com.tencent.mm.plugin.mmsight.d.aaX(k);
        m = com.tencent.mm.plugin.mmsight.d.aaX(m);
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "real width:%d, height:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
        f = this.nLH.fps;
        i1 = this.nLH.oBP;
        i2 = this.nLH.oBO;
        bool2 = this.nME;
        i3 = this.nLH.duration;
        if (this.nLH.oCn != 1) {
          break label440;
        }
      }
    }
    com.tencent.mm.media.util.f localf;
    label301:
    label309:
    label440:
    for (boolean bool1 = true;; bool1 = false)
    {
      i = SightVideoJNI.initDataBufferForMMSightLock(i, j, paramInt, k, m, f, n, i1, 8, i2, 23.0F, bool2, true, i3, false, bool1, this.nMK);
      if (i >= 0) {
        break label446;
      }
      Log.e("MicroMsg.X264YUVMP4MuxRecorder", "init failed!");
      localf = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.bqG();
      AppMethodBeat.o(93453);
      return false;
      j = this.nLx;
      break;
      i = this.nLw;
      break label76;
      k = this.nLt;
      break label95;
      label318:
      m = this.nLu;
      break label114;
      if ((paramInt == 90) || (paramInt == 270))
      {
        i = this.nLw;
        label345:
        if ((paramInt != 90) && (paramInt != 270)) {
          break label413;
        }
        j = this.nLx;
        label364:
        if ((paramInt != 90) && (paramInt != 270)) {
          break label422;
        }
        k = this.nLt;
        label383:
        if ((paramInt != 90) && (paramInt != 270)) {
          break label431;
        }
      }
      for (m = this.nLu;; m = this.nLt)
      {
        break;
        i = this.nLx;
        break label345;
        j = this.nLw;
        break label364;
        k = this.nLu;
        break label383;
      }
    }
    label413:
    label422:
    label431:
    label446:
    this.nMG = i;
    this.nMx = new p(this.nME, paramInt, k, m, this.nMF);
    this.nMx.abe(i);
    if (CaptureMMProxy.getInstance() != null) {
      CaptureMMProxy.getInstance().getInt(at.a.acOF, -1);
    }
    if (!this.nLP)
    {
      paramInt = this.nLH.audioSampleRate;
      j = this.nLH.audioBitrate;
      k = this.nLH.audioChannelCount;
      if (this.nLH.oCn != 1) {
        break label649;
      }
    }
    label649:
    for (bool1 = true;; bool1 = false)
    {
      this.nMw = new a(paramInt, j, k, com.tencent.mm.plugin.sight.base.c.aP(true, bool1));
      this.nMw.yt(this.nMH);
      if (this.nMw.L(i, com.tencent.mm.plugin.sight.base.f.aVV(this.nLm)) < 0)
      {
        localf = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.bqI();
      }
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "initImpl used %sms, bufferId:%s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(i) });
      AppMethodBeat.o(93453);
      return true;
    }
  }
  
  private boolean uy(int paramInt)
  {
    AppMethodBeat.i(93446);
    if ((this.nMy != null) && (!this.nMy.nMS))
    {
      if (!this.nMy.nMP)
      {
        this.nMy.callback = null;
        this.nMy.nMR = true;
        this.nMy.nMQ = true;
        this.nMy.cancel();
      }
      synchronized (this.nMy.nMT)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(paramInt);
        if (this.nMy.nMN != paramInt) {
          SightVideoJNI.releaseBigSightDataBufferLock(this.nMy.nMN);
        }
        AppMethodBeat.o(93446);
        return true;
      }
    }
    AppMethodBeat.o(93446);
    return false;
  }
  
  public final void A(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(93445);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.nLw = paramInt1;
    this.nLx = paramInt2;
    if (com.tencent.mm.plugin.mmsight.model.a.j.KXq.m(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = Util.currentTicks();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        com.tencent.mm.plugin.mmsight.model.a.j.KXq.as(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    }
    AppMethodBeat.o(93445);
  }
  
  public final void Hd(String paramString)
  {
    this.thumbPath = paramString;
  }
  
  public final void He(String paramString)
  {
    this.nLD = paramString;
  }
  
  /* Error */
  public final void J(final Runnable paramRunnable)
  {
    // Byte code:
    //   0: ldc_w 727
    //   3: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 105	com/tencent/mm/media/widget/c/e:nMy	Lcom/tencent/mm/media/widget/c/e$a;
    //   10: ifnonnull +125 -> 135
    //   13: iconst_1
    //   14: istore_2
    //   15: aload_0
    //   16: getfield 105	com/tencent/mm/media/widget/c/e:nMy	Lcom/tencent/mm/media/widget/c/e$a;
    //   19: ifnull +121 -> 140
    //   22: aload_0
    //   23: getfield 105	com/tencent/mm/media/widget/c/e:nMy	Lcom/tencent/mm/media/widget/c/e$a;
    //   26: getfield 331	com/tencent/mm/media/widget/c/e$a:nMP	Z
    //   29: ifeq +111 -> 140
    //   32: iconst_1
    //   33: istore_3
    //   34: aload_0
    //   35: getfield 105	com/tencent/mm/media/widget/c/e:nMy	Lcom/tencent/mm/media/widget/c/e$a;
    //   38: ifnull +107 -> 145
    //   41: aload_0
    //   42: getfield 105	com/tencent/mm/media/widget/c/e:nMy	Lcom/tencent/mm/media/widget/c/e$a;
    //   45: getfield 411	com/tencent/mm/media/widget/c/e$a:nMQ	Z
    //   48: ifeq +97 -> 145
    //   51: iconst_1
    //   52: istore 4
    //   54: ldc 218
    //   56: ldc_w 729
    //   59: iconst_3
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: iload_2
    //   66: invokestatic 268	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   69: aastore
    //   70: dup
    //   71: iconst_1
    //   72: iload_3
    //   73: invokestatic 268	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   76: aastore
    //   77: dup
    //   78: iconst_2
    //   79: iload 4
    //   81: invokestatic 268	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   84: aastore
    //   85: invokestatic 229	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: aload_0
    //   89: getfield 105	com/tencent/mm/media/widget/c/e:nMy	Lcom/tencent/mm/media/widget/c/e$a;
    //   92: ifnull +71 -> 163
    //   95: aload_0
    //   96: getfield 105	com/tencent/mm/media/widget/c/e:nMy	Lcom/tencent/mm/media/widget/c/e$a;
    //   99: getfield 331	com/tencent/mm/media/widget/c/e$a:nMP	Z
    //   102: ifeq +61 -> 163
    //   105: aload_0
    //   106: getfield 105	com/tencent/mm/media/widget/c/e:nMy	Lcom/tencent/mm/media/widget/c/e$a;
    //   109: getfield 426	com/tencent/mm/media/widget/c/e$a:nMT	Ljava/lang/Object;
    //   112: astore 5
    //   114: aload 5
    //   116: monitorenter
    //   117: aload_0
    //   118: invokevirtual 360	com/tencent/mm/media/widget/c/e:reset	()V
    //   121: aload_1
    //   122: invokestatic 366	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   125: aload 5
    //   127: monitorexit
    //   128: ldc_w 727
    //   131: invokestatic 244	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: return
    //   135: iconst_0
    //   136: istore_2
    //   137: goto -122 -> 15
    //   140: iconst_0
    //   141: istore_3
    //   142: goto -108 -> 34
    //   145: iconst_0
    //   146: istore 4
    //   148: goto -94 -> 54
    //   151: astore_1
    //   152: aload 5
    //   154: monitorexit
    //   155: ldc_w 727
    //   158: invokestatic 244	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aload_1
    //   162: athrow
    //   163: ldc 218
    //   165: ldc_w 731
    //   168: iconst_2
    //   169: anewarray 4	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload_0
    //   175: getfield 171	com/tencent/mm/media/widget/c/e:nMI	Z
    //   178: invokestatic 268	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: aload_0
    //   185: getfield 137	com/tencent/mm/media/widget/c/e:nMB	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   188: aastore
    //   189: invokestatic 229	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: aload_0
    //   193: getfield 171	com/tencent/mm/media/widget/c/e:nMI	Z
    //   196: ifeq +34 -> 230
    //   199: aload_0
    //   200: getfield 137	com/tencent/mm/media/widget/c/e:nMB	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   203: ifnull +27 -> 230
    //   206: aload_0
    //   207: getfield 137	com/tencent/mm/media/widget/c/e:nMB	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   210: new 12	com/tencent/mm/media/widget/c/e$3
    //   213: dup
    //   214: aload_0
    //   215: aload_1
    //   216: invokespecial 733	com/tencent/mm/media/widget/c/e$3:<init>	(Lcom/tencent/mm/media/widget/c/e;Ljava/lang/Runnable;)V
    //   219: invokevirtual 739	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   222: pop
    //   223: ldc_w 727
    //   226: invokestatic 244	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: return
    //   230: getstatic 383	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   233: new 14	com/tencent/mm/media/widget/c/e$4
    //   236: dup
    //   237: aload_0
    //   238: aload_1
    //   239: invokespecial 740	com/tencent/mm/media/widget/c/e$4:<init>	(Lcom/tencent/mm/media/widget/c/e;Ljava/lang/Runnable;)V
    //   242: invokeinterface 391 2 0
    //   247: pop
    //   248: ldc_w 727
    //   251: invokestatic 244	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   254: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	e
    //   0	255	1	paramRunnable	Runnable
    //   14	123	2	bool1	boolean
    //   33	109	3	bool2	boolean
    //   52	95	4	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   117	128	151	finally
  }
  
  public final void a(com.tencent.mm.plugin.mmsight.model.a.c paramc)
  {
    AppMethodBeat.i(93464);
    if (paramc != null)
    {
      this.nMa = true;
      paramc.uu(this.nMG);
    }
    AppMethodBeat.o(93464);
  }
  
  public final void a(d.a parama)
  {
    this.nLL = parama;
  }
  
  public final void ae(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(93460);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "resume, cameraOrientation: %s, lastPauseTimeMs:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(this.nMJ) });
    if ((this.nLy != null) && (this.nLy.KXM == d.c.KWK))
    {
      if (this.nMx != null) {
        this.nMx.ae(paramInt1, paramInt2, paramInt3);
      }
      this.nLy.a(d.c.KWC);
      if (this.nMJ > 0L) {
        this.nLZ += System.currentTimeMillis() - this.nMJ;
      }
    }
    AppMethodBeat.o(93460);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(93455);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s, bufId:%S", new Object[] { this.nLy.KXM, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(this.nMG) });
    this.nKe = paramBoolean;
    this.nLZ = 0L;
    this.nMJ = 0L;
    this.nLn = 0;
    this.nLK = paramInt2;
    this.nLy.a(d.c.KWB);
    String str = this.nLm;
    if (this.nMy == null)
    {
      paramBoolean = true;
      if ((this.nMy != null) && (!this.nMy.nMS)) {
        break label199;
      }
    }
    label199:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]", new Object[] { str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if ((this.nMy == null) || (this.nMy.nMS)) {
        break label205;
      }
      Log.w("MicroMsg.X264YUVMP4MuxRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
      AppMethodBeat.o(93455);
      return -1;
      paramBoolean = false;
      break;
    }
    label205:
    if (Util.isNullOrNil(this.nLm))
    {
      Log.e("MicroMsg.X264YUVMP4MuxRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(93455);
      return -1;
    }
    this.mFileName = y.bEq(this.nLm);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "mCurRecordPath: %s", new Object[] { this.nLm });
    this.nLz = paramInt1;
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "start, cameraOrientation: %s, mute:%s", new Object[] { Integer.valueOf(this.nLz), Boolean.valueOf(this.nLP) });
    if (!this.mGp)
    {
      uv(paramInt1);
      this.mGp = true;
    }
    this.nMx.start();
    if ((!this.nMH) && (this.nMw != null))
    {
      paramInt1 = this.nMw.a(new com.tencent.mm.plugin.mmsight.model.a.c.a()
      {
        public final void buO()
        {
          AppMethodBeat.i(93436);
          e.t(e.this);
          AppMethodBeat.o(93436);
        }
      });
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "start aac recorder ret: %d", new Object[] { Integer.valueOf(paramInt1) });
      this.nMA = com.tencent.threadpool.c.d.jw("BigSightWriteCameraData", 5);
      this.nMA.start();
      this.nMB = new MMHandler(this.nMA.getLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(93437);
          if (e.u(e.this) == -1)
          {
            e.b(e.this, Process.myTid());
            Log.i("MicroMsg.X264YUVMP4MuxRecorder", "writeCameraTid: %s", new Object[] { Integer.valueOf(e.u(e.this)) });
          }
          if (paramAnonymousMessage.what == 1)
          {
            if (e.v(e.this) != null) {
              e.v(e.this).gcw();
            }
            e.b(e.this, (byte[])paramAnonymousMessage.obj);
          }
          AppMethodBeat.o(93437);
        }
      };
      this.nLJ = false;
      if (paramInt1 == 0) {
        break label461;
      }
      this.nLy.a(d.c.KWI);
    }
    for (;;)
    {
      if ((this.nMH) || (this.nLP)) {
        buO();
      }
      AppMethodBeat.o(93455);
      return paramInt1;
      paramInt1 = 0;
      break;
      label461:
      this.nLy.a(d.c.KWJ);
    }
  }
  
  public final void bq(float paramFloat)
  {
    AppMethodBeat.i(93463);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.nLq = paramFloat;
    AppMethodBeat.o(93463);
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
    AppMethodBeat.i(93451);
    long l = this.nMx.bpj();
    AppMethodBeat.o(93451);
    return l;
  }
  
  public final d.c buD()
  {
    return this.nLy.KXM;
  }
  
  public final int buE()
  {
    AppMethodBeat.i(93457);
    int i = Math.round(this.nLn / 1000.0F);
    AppMethodBeat.o(93457);
    return i;
  }
  
  public final Point buF()
  {
    AppMethodBeat.i(93458);
    Point localPoint = new Point(this.nLw, this.nLx);
    AppMethodBeat.o(93458);
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
    AppMethodBeat.i(93461);
    if (this.nMw != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.nMw.gcx();
      AppMethodBeat.o(93461);
      return locala;
    }
    AppMethodBeat.o(93461);
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
  
  public final void buw() {}
  
  public final void cancel()
  {
    AppMethodBeat.i(93448);
    Log.printInfoStack("MicroMsg.X264YUVMP4MuxRecorder", "cancel", new Object[0]);
    this.nLy.a(d.c.KWE);
    if (this.nMB != null) {
      this.nMB.removeMessages(1);
    }
    clear();
    this.nLy.a(d.c.KWF);
    AppMethodBeat.o(93448);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(93447);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "clear, hasWriteCameraData:%s", new Object[] { Boolean.valueOf(this.nLJ) });
    if (this.nLJ) {
      com.tencent.threadpool.h.ahAA.bm(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(93432);
          e.c(e.this);
          AppMethodBeat.o(93432);
        }
      });
    }
    for (;;)
    {
      this.nLZ = 0L;
      this.nMJ = 0L;
      AppMethodBeat.o(93447);
      return;
      buQ();
    }
  }
  
  public final void gI(boolean paramBoolean)
  {
    this.nMH = paramBoolean;
  }
  
  public final String getFileName()
  {
    return this.mFileName;
  }
  
  public final String getFilePath()
  {
    return this.nLm;
  }
  
  public final g getFrameDataCallback()
  {
    return this.nMg;
  }
  
  public final String getMd5()
  {
    AppMethodBeat.i(93450);
    String str = Util.nullAs(this.md5, "");
    AppMethodBeat.o(93450);
    return str;
  }
  
  public final boolean isLandscape()
  {
    return this.nKe;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(93459);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "pause");
    if ((this.nLy != null) && (this.nLy.KXM == d.c.KWC))
    {
      this.nLy.a(d.c.KWK);
      this.nMJ = System.currentTimeMillis();
    }
    AppMethodBeat.o(93459);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(93452);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "reset");
    this.nLy.KXM = d.c.KWF;
    if (this.nMB != null) {
      this.nMB.removeMessages(1);
    }
    if (this.nMw != null) {
      this.nMw.clear();
    }
    if (this.nMx != null) {
      this.nMx.clear();
    }
    clear();
    this.nLJ = false;
    AppMethodBeat.o(93452);
  }
  
  public final void setFilePath(String paramString)
  {
    this.nLm = paramString;
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.nMF = paramBoolean;
    if (this.nMx != null) {
      this.nMx.nMF = paramBoolean;
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(237671);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "setMute:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.nLP = paramBoolean;
    AppMethodBeat.o(237671);
  }
  
  public final boolean uw(int paramInt)
  {
    AppMethodBeat.i(93454);
    if (!this.mGp)
    {
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "preInit, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = uv(paramInt);
      this.mGp = true;
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(93454);
      return bool;
    }
    AppMethodBeat.o(93454);
    return true;
  }
  
  public final void ux(int paramInt)
  {
    AppMethodBeat.i(93462);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.nLp = paramInt;
    AppMethodBeat.o(93462);
  }
  
  final class a
    extends com.tencent.threadpool.i.b
  {
    Runnable callback;
    int duration;
    float eGw;
    int nMN;
    volatile boolean nMO;
    boolean nMP;
    boolean nMQ;
    boolean nMR;
    boolean nMS;
    final Object nMT;
    volatile int nzX;
    
    public a()
    {
      AppMethodBeat.i(93442);
      this.nzX = 0;
      this.nMO = true;
      this.nMP = false;
      this.nMQ = false;
      this.nMR = false;
      this.nMS = false;
      this.nMT = new Object();
      this.callback = null;
      synchronized (this.nMT)
      {
        try
        {
          String str2 = y.bEo(e.e(e.this));
          String str1 = str2;
          if (!str2.endsWith("/")) {
            str1 = str2 + "/";
          }
          e.a(e.this, str1 + "tempRotate.mp4");
        }
        catch (Exception this$1)
        {
          for (;;)
          {
            Log.e("MicroMsg.X264YUVMP4MuxRecorder", "retrieve file name error: %s", new Object[] { e.this.getMessage() });
          }
        }
        AppMethodBeat.o(93442);
        return;
      }
    }
    
    public final String getKey()
    {
      return "SightCustomAsyncMediaRecorder_encode";
    }
    
    public final void run()
    {
      boolean bool1 = true;
      AppMethodBeat.i(93443);
      if (e.f(e.this) == -1)
      {
        e.a(e.this, Process.myTid());
        Process.setThreadPriority(Process.myTid(), -2);
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "encodeTid: %s", new Object[] { Integer.valueOf(e.f(e.this)) });
      }
      int i;
      int j;
      for (;;)
      {
        synchronized (this.nMT)
        {
          if (this.nMQ) {
            break label205;
          }
          l = Util.currentTicks();
          i = SightVideoJNI.triggerEncode(this.nMN, Math.max(0, this.nzX), false);
          Log.i("MicroMsg.X264YUVMP4MuxRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.nzX), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          j = Math.abs(i - this.nzX);
          if (j > 5) {}
        }
        try
        {
          Thread.sleep(100L);
          this.nzX = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(93443);
          throw localObject2;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Log.e("MicroMsg.X264YUVMP4MuxRecorder", "thread sleep error");
          }
        }
      }
      label205:
      long l = Util.currentTicks();
      if (!this.nMR) {
        this.nzX = SightVideoJNI.triggerEncode(this.nMN, this.nzX, true);
      }
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.nzX), Boolean.valueOf(this.nMR), Long.valueOf(Thread.currentThread().getId()) });
      Object localObject3;
      Object localObject4;
      if (!this.nMR)
      {
        i = Math.max(1000, this.duration);
        if (e.g(e.this) > 0) {
          i = e.g(e.this);
        }
        float f = this.eGw;
        if (e.h(e.this) > 0.0F) {
          f = e.h(e.this);
        }
        localObject3 = e.this;
        j = this.nMN;
        localObject4 = e.e(e.this);
        int k = e.i(e.this);
        int m = e.j(e.this).audioSampleRate;
        boolean bool2 = e.k(e.this);
        if (e.j(e.this).oCn == 1) {}
        for (;;)
        {
          e.a((e)localObject3, new m(j, (String)localObject4, f, k, i, m, bool2, true, bool1));
          l = Util.currentTicks();
          bool1 = e.m(e.this).yu(e.l(e.this));
          Log.i("MicroMsg.X264YUVMP4MuxRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Boolean.valueOf(bool1) });
          if (bool1) {
            break;
          }
          Log.e("MicroMsg.X264YUVMP4MuxRecorder", "mux failed!");
          SightVideoJNI.releaseBigSightDataBufferLock(this.nMN);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(93439);
              if (e.n(e.this) != null) {
                e.n(e.this).cba();
              }
              AppMethodBeat.o(93439);
            }
          });
          localObject3 = com.tencent.mm.media.util.f.nFE;
          com.tencent.mm.media.util.f.bqL();
          AppMethodBeat.o(93443);
          return;
          bool1 = false;
        }
        localObject3 = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.bqM();
        if (((e.o(e.this)) && (e.p(e.this))) || ((!e.p(e.this)) && (!e.o(e.this))) || ((e.o(e.this)) && (Math.abs(e.q(e.this) - e.r(e.this)) == 0)) || (e.r(e.this) == 180))
        {
          l = Util.currentTicks();
          if ((e.p(e.this)) || (e.o(e.this))) {
            break label992;
          }
          i = e.q(e.this);
        }
      }
      for (;;)
      {
        j = i;
        if (e.r(e.this) == 180)
        {
          j = i;
          if (!e.p(e.this))
          {
            i += 180;
            j = i;
            if (i > 360) {
              j = i - 360;
            }
          }
        }
        if (j > 0)
        {
          SightVideoJNI.tagRotateVideoVFS(e.e(e.this), e.s(e.this), j);
          Log.i("MicroMsg.X264YUVMP4MuxRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(e.q(e.this)), Boolean.valueOf(e.o(e.this)), Integer.valueOf(e.r(e.this)), Integer.valueOf(j) });
          localObject3 = e.s(e.this);
        }
        try
        {
          y.O(e.s(e.this), e.e(e.this), false);
          com.tencent.threadpool.h.ahAA.bm(new com.tencent.threadpool.i.h()
          {
            public final String getKey()
            {
              return "BigSightFFMpegRecorder_tagRotate_after_process";
            }
            
            public final void run()
            {
              AppMethodBeat.i(93441);
              try
              {
                y.deleteFile(this.nMo);
                AppMethodBeat.o(93441);
                return;
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.X264YUVMP4MuxRecorder", "stop, delete old file error: %s", new Object[] { localException.getMessage() });
                AppMethodBeat.o(93441);
              }
            }
          });
          Log.i("MicroMsg.X264YUVMP4MuxRecorder", "tag rotate used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
        }
        catch (Exception localException2)
        {
          label920:
          Log.e("MicroMsg.X264YUVMP4MuxRecorder", "stop, copy file error");
          SightVideoJNI.releaseBigSightDataBufferLock(this.nMN);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(93440);
              if (e.n(e.this) != null) {
                e.n(e.this).cba();
              }
              AppMethodBeat.o(93440);
            }
          });
          AppMethodBeat.o(93443);
          return;
        }
        try
        {
          localObject3 = com.tencent.mm.plugin.sight.base.f.aVX(e.e(e.this));
          if (localObject3 != null)
          {
            localObject4 = com.tencent.mm.media.util.f.nFE;
            com.tencent.mm.media.util.f.et(((com.tencent.mm.plugin.sight.base.b)localObject3).videoBitrate, ((com.tencent.mm.plugin.sight.base.b)localObject3).frameRate);
          }
        }
        catch (Exception localException3)
        {
          break label920;
          i = 180;
        }
        SightVideoJNI.releaseBigSightDataBufferLock(this.nMN);
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "all finish, callback: %s", new Object[] { this.callback });
        e.this.reset();
        MMHandlerThread.postToMainThread(this.callback);
        this.nMS = true;
        e.a(e.this, -1);
        e.b(e.this, -1);
        AppMethodBeat.o(93443);
        return;
        label992:
        if (e.p(e.this)) {
          i = e.r(e.this);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.c.e
 * JD-Core Version:    0.7.0.1
 */