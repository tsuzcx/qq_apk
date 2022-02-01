package com.tencent.mm.media.widget.c;

import android.graphics.Point;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.e.c.d;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b.a;
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
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.u;

public final class e
  implements b
{
  private boolean kfR;
  private boolean lft;
  private String lgC;
  private int lgD;
  private float lgE;
  private int lgF;
  private float lgG;
  private int lgJ;
  private int lgK;
  private int lgL;
  private int lgM;
  private int lgN;
  private s lgO;
  private int lgP;
  private String lgR;
  private boolean lgS;
  private String lgT;
  private boolean lgU;
  private VideoTransPara lgX;
  private boolean lgZ;
  private com.tencent.mm.plugin.mmsight.model.a.c lhN;
  private p lhO;
  private a lhP;
  private com.tencent.mm.plugin.mmsight.model.a.e lhQ;
  private HandlerThread lhR;
  private MMHandler lhS;
  private int lhT;
  private int lhU;
  private boolean lhV;
  private boolean lhW;
  private int lhX;
  private boolean lhY;
  private boolean lhZ;
  private int lha;
  private d.a lhb;
  private boolean lhe;
  private boolean lhf;
  private long lhp;
  private boolean lhq;
  private g lhw;
  private long lia;
  private boolean lib;
  private String mFileName;
  private String md5;
  private String thumbPath;
  
  public e(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(93444);
    this.lhP = null;
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
    this.lgP = 0;
    this.lgR = null;
    this.lhR = null;
    this.lhS = null;
    this.lhT = -1;
    this.lhU = -1;
    this.lhV = false;
    this.lhW = false;
    this.thumbPath = null;
    this.lgT = null;
    this.lgU = false;
    this.lgS = false;
    this.kfR = false;
    this.lhX = -1;
    this.lgZ = false;
    this.md5 = "";
    this.lft = false;
    this.lha = 0;
    this.lhY = false;
    this.lhe = true;
    this.lhZ = false;
    this.lhp = 0L;
    this.lia = 0L;
    this.lhf = false;
    this.lib = false;
    this.lhw = new g()
    {
      public final boolean ar(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(93431);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          AppMethodBeat.o(93431);
          return false;
        }
        if (e.a(e.this).Fcd == d.c.FaT)
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
    this.lhq = false;
    this.lgX = paramVideoTransPara;
    this.lgJ = paramVideoTransPara.width;
    this.lgK = paramVideoTransPara.height;
    this.lgL = paramVideoTransPara.videoBitrate;
    this.lgO = new s();
    this.kfR = false;
    int i;
    boolean bool;
    if (this.lgX.lJL == 1)
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
      this.lib = bool;
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "create X264YUVMP4MuxRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s, enableHevc:%s", new Object[] { Integer.valueOf(this.lgJ), Integer.valueOf(this.lgK), Integer.valueOf(this.lgL), Integer.valueOf(paramVideoTransPara.lJL) });
      com.tencent.mm.media.k.f localf = com.tencent.mm.media.k.f.laB;
      com.tencent.mm.media.k.f.aVX();
      if (paramVideoTransPara.lJL == 1)
      {
        paramVideoTransPara = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aWX();
      }
      AppMethodBeat.o(93444);
      return;
      i = 0;
      break;
      label379:
      bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vLb, false);
      Log.i("MicroMsg.WechatSight.PacketMuxerController", "x264YUVMP4MuxRecorderUseFFMpeg:%s", new Object[] { Boolean.valueOf(bool) });
    }
  }
  
  private void aZQ()
  {
    if (this.lhP != null) {
      this.lhP.lih = true;
    }
  }
  
  private void aZS()
  {
    AppMethodBeat.i(93456);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::pcm ready");
    if ((this.lhP != null) && (!this.lhP.lij)) {
      Log.e("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", new Object[] { this.lhP });
    }
    synchronized (this.lhP.lik)
    {
      uy(this.lhP.lie);
      if (this.lgO.Fcd != d.c.Fba)
      {
        Log.w("MicroMsg.X264YUVMP4MuxRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
        AppMethodBeat.o(93456);
        return;
      }
    }
    this.lgO.a(d.c.FaT);
    this.lhP = new a();
    this.lhP.lie = this.lhX;
    com.tencent.e.h.ZvG.be(this.lhP);
    AppMethodBeat.o(93456);
  }
  
  private void aZT()
  {
    boolean bool2 = true;
    AppMethodBeat.i(261924);
    int i = -1;
    if (this.lhO != null)
    {
      i = this.lhO.FbU;
      if (i < 0)
      {
        Log.v("MicroMsg.X264YUVMP4MuxRecorder", "call clear, but bufID error");
        AppMethodBeat.o(261924);
        return;
      }
      this.lhO.stop();
    }
    boolean bool1;
    if (this.lhP == null)
    {
      bool1 = true;
      if ((this.lhP == null) || (!this.lhP.lii)) {
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
      if (this.lhN != null) {
        this.lhN.a(null);
      }
      if (this.lhR != null) {
        this.lhR.quit();
      }
      AppMethodBeat.o(261924);
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
    if (com.tencent.mm.plugin.mmsight.model.j.EZX != null) {
      this.lhV = com.tencent.mm.plugin.mmsight.model.j.EZX.lhV;
    }
    this.lgP = paramInt;
    int j;
    int i;
    label76:
    int k;
    label95:
    int m;
    label114:
    int i1;
    int n;
    if (!this.lhV) {
      if ((paramInt == 90) || (paramInt == 270))
      {
        j = this.lgM;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label321;
        }
        i = this.lgN;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label329;
        }
        k = this.lgK;
        if ((paramInt != 90) && (paramInt != 270)) {
          break label338;
        }
        m = this.lgJ;
        i1 = j;
        j = m;
        n = i;
        i = i1;
        i1 = this.lgL;
        m = k;
        if (k % 2 != 0) {
          m = k + 1;
        }
        if (j % 2 == 0) {
          break label683;
        }
        j += 1;
      }
    }
    label384:
    label403:
    label677:
    label683:
    for (;;)
    {
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "real width:%d, height:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(j) });
      float f = this.lgX.fps;
      k = this.lgX.lJn;
      int i2 = this.lgX.lJm;
      boolean bool2 = this.lhV;
      int i3 = this.lgX.duration;
      if (this.lgX.lJL == 1) {}
      com.tencent.mm.media.k.f localf;
      for (boolean bool1 = true;; bool1 = false)
      {
        i = SightVideoJNI.initDataBufferForMMSightLock(i, n, paramInt, m, j, f, i1, k, 8, i2, 23.0F, bool2, true, i3, false, bool1, this.lib);
        if (i >= 0) {
          break label474;
        }
        Log.e("MicroMsg.X264YUVMP4MuxRecorder", "init failed!");
        localf = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aVY();
        AppMethodBeat.o(93453);
        return false;
        j = this.lgN;
        break;
        label321:
        i = this.lgM;
        break label76;
        label329:
        k = this.lgJ;
        break label95;
        label338:
        m = this.lgK;
        break label114;
        if ((paramInt == 90) || (paramInt == 270))
        {
          i = this.lgM;
          label365:
          if ((paramInt != 90) && (paramInt != 270)) {
            break label441;
          }
          j = this.lgN;
          if ((paramInt != 90) && (paramInt != 270)) {
            break label450;
          }
          k = this.lgJ;
          if ((paramInt != 90) && (paramInt != 270)) {
            break label459;
          }
        }
        label441:
        label450:
        label459:
        for (m = this.lgK;; m = this.lgJ)
        {
          n = j;
          j = m;
          break;
          i = this.lgN;
          break label365;
          j = this.lgM;
          break label384;
          k = this.lgK;
          break label403;
        }
      }
      label474:
      this.lhX = i;
      this.lhO = new p(this.lhV, paramInt, m, j, this.lhW);
      this.lhO.Xc(i);
      if (CaptureMMProxy.getInstance() != null) {
        CaptureMMProxy.getInstance().getInt(ar.a.Vnk, -1);
      }
      if (!this.lhf)
      {
        paramInt = this.lgX.audioSampleRate;
        j = this.lgX.audioBitrate;
        k = this.lgX.audioChannelCount;
        if (this.lgX.lJL != 1) {
          break label677;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        this.lhN = new a(paramInt, j, k, com.tencent.mm.plugin.sight.base.c.aw(true, bool1));
        this.lhN.uf(this.lhY);
        if (this.lhN.J(i, com.tencent.mm.plugin.sight.base.f.aYe(this.lgC)) < 0)
        {
          localf = com.tencent.mm.media.k.f.laB;
          com.tencent.mm.media.k.f.aWa();
        }
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "initImpl used %sms, bufferId:%s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(i) });
        AppMethodBeat.o(93453);
        return true;
      }
    }
  }
  
  private boolean uy(int paramInt)
  {
    AppMethodBeat.i(93446);
    if ((this.lhP != null) && (!this.lhP.lij))
    {
      if (!this.lhP.lig)
      {
        this.lhP.callback = null;
        this.lhP.lii = true;
        this.lhP.lih = true;
        this.lhP.cancel();
      }
      synchronized (this.lhP.lik)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(paramInt);
        if (this.lhP.lie != paramInt) {
          SightVideoJNI.releaseBigSightDataBufferLock(this.lhP.lie);
        }
        AppMethodBeat.o(93446);
        return true;
      }
    }
    AppMethodBeat.o(93446);
    return false;
  }
  
  /* Error */
  public final void E(final Runnable paramRunnable)
  {
    // Byte code:
    //   0: ldc_w 709
    //   3: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 105	com/tencent/mm/media/widget/c/e:lhP	Lcom/tencent/mm/media/widget/c/e$a;
    //   10: ifnonnull +125 -> 135
    //   13: iconst_1
    //   14: istore_2
    //   15: aload_0
    //   16: getfield 105	com/tencent/mm/media/widget/c/e:lhP	Lcom/tencent/mm/media/widget/c/e$a;
    //   19: ifnull +121 -> 140
    //   22: aload_0
    //   23: getfield 105	com/tencent/mm/media/widget/c/e:lhP	Lcom/tencent/mm/media/widget/c/e$a;
    //   26: getfield 331	com/tencent/mm/media/widget/c/e$a:lig	Z
    //   29: ifeq +111 -> 140
    //   32: iconst_1
    //   33: istore_3
    //   34: aload_0
    //   35: getfield 105	com/tencent/mm/media/widget/c/e:lhP	Lcom/tencent/mm/media/widget/c/e$a;
    //   38: ifnull +107 -> 145
    //   41: aload_0
    //   42: getfield 105	com/tencent/mm/media/widget/c/e:lhP	Lcom/tencent/mm/media/widget/c/e$a;
    //   45: getfield 394	com/tencent/mm/media/widget/c/e$a:lih	Z
    //   48: ifeq +97 -> 145
    //   51: iconst_1
    //   52: istore 4
    //   54: ldc 218
    //   56: ldc_w 711
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
    //   89: getfield 105	com/tencent/mm/media/widget/c/e:lhP	Lcom/tencent/mm/media/widget/c/e$a;
    //   92: ifnull +71 -> 163
    //   95: aload_0
    //   96: getfield 105	com/tencent/mm/media/widget/c/e:lhP	Lcom/tencent/mm/media/widget/c/e$a;
    //   99: getfield 331	com/tencent/mm/media/widget/c/e$a:lig	Z
    //   102: ifeq +61 -> 163
    //   105: aload_0
    //   106: getfield 105	com/tencent/mm/media/widget/c/e:lhP	Lcom/tencent/mm/media/widget/c/e$a;
    //   109: getfield 409	com/tencent/mm/media/widget/c/e$a:lik	Ljava/lang/Object;
    //   112: astore 5
    //   114: aload 5
    //   116: monitorenter
    //   117: aload_0
    //   118: invokevirtual 360	com/tencent/mm/media/widget/c/e:reset	()V
    //   121: aload_1
    //   122: invokestatic 366	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   125: aload 5
    //   127: monitorexit
    //   128: ldc_w 709
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
    //   155: ldc_w 709
    //   158: invokestatic 244	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aload_1
    //   162: athrow
    //   163: ldc 218
    //   165: ldc_w 713
    //   168: iconst_2
    //   169: anewarray 4	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload_0
    //   175: getfield 171	com/tencent/mm/media/widget/c/e:lhZ	Z
    //   178: invokestatic 268	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: aload_0
    //   185: getfield 137	com/tencent/mm/media/widget/c/e:lhS	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   188: aastore
    //   189: invokestatic 229	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: aload_0
    //   193: getfield 171	com/tencent/mm/media/widget/c/e:lhZ	Z
    //   196: ifeq +34 -> 230
    //   199: aload_0
    //   200: getfield 137	com/tencent/mm/media/widget/c/e:lhS	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   203: ifnull +27 -> 230
    //   206: aload_0
    //   207: getfield 137	com/tencent/mm/media/widget/c/e:lhS	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   210: new 12	com/tencent/mm/media/widget/c/e$3
    //   213: dup
    //   214: aload_0
    //   215: aload_1
    //   216: invokespecial 715	com/tencent/mm/media/widget/c/e$3:<init>	(Lcom/tencent/mm/media/widget/c/e;Ljava/lang/Runnable;)V
    //   219: invokevirtual 721	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   222: pop
    //   223: ldc_w 709
    //   226: invokestatic 244	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: return
    //   230: getstatic 383	com/tencent/e/h:ZvG	Lcom/tencent/e/i;
    //   233: new 14	com/tencent/mm/media/widget/c/e$4
    //   236: dup
    //   237: aload_0
    //   238: aload_1
    //   239: invokespecial 722	com/tencent/mm/media/widget/c/e$4:<init>	(Lcom/tencent/mm/media/widget/c/e;Ljava/lang/Runnable;)V
    //   242: invokeinterface 391 2 0
    //   247: pop
    //   248: ldc_w 709
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
    AppMethodBeat.i(93460);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "resume, cameraOrientation: %s, lastPauseTimeMs:%s", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(this.lia) });
    if ((this.lgO != null) && (this.lgO.Fcd == d.c.Fbb))
    {
      if (this.lhO != null) {
        this.lhO.P(paramInt1, paramInt2, paramInt3);
      }
      this.lgO.a(d.c.FaT);
      if (this.lia > 0L) {
        this.lhp += System.currentTimeMillis() - this.lia;
      }
    }
    AppMethodBeat.o(93460);
  }
  
  public final void a(com.tencent.mm.plugin.mmsight.model.a.c paramc)
  {
    AppMethodBeat.i(93464);
    if (paramc != null)
    {
      this.lhq = true;
      paramc.uu(this.lhX);
    }
    AppMethodBeat.o(93464);
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
    AppMethodBeat.i(93451);
    long l = this.lhO.aUC();
    AppMethodBeat.o(93451);
    return l;
  }
  
  public final d.c aZF()
  {
    return this.lgO.Fcd;
  }
  
  public final int aZG()
  {
    AppMethodBeat.i(93457);
    int i = Math.round(this.lgD / 1000.0F);
    AppMethodBeat.o(93457);
    return i;
  }
  
  public final Point aZH()
  {
    AppMethodBeat.i(93458);
    Point localPoint = new Point(this.lgM, this.lgN);
    AppMethodBeat.o(93458);
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
    AppMethodBeat.i(93461);
    if (this.lhN != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.lhN.eTE();
      AppMethodBeat.o(93461);
      return locala;
    }
    AppMethodBeat.o(93461);
    return null;
  }
  
  public final void aZL()
  {
    this.lhe = false;
  }
  
  public final com.tencent.mm.plugin.mmsight.model.a.c aZO()
  {
    return this.lhN;
  }
  
  public final String aZe()
  {
    return this.thumbPath;
  }
  
  public final void aZy() {}
  
  public final void av(float paramFloat)
  {
    AppMethodBeat.i(93463);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.lgG = paramFloat;
    AppMethodBeat.o(93463);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(93455);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s, bufId:%S", new Object[] { this.lgO.Fcd, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Integer.valueOf(this.lhX) });
    this.lft = paramBoolean;
    this.lhp = 0L;
    this.lia = 0L;
    this.lgD = 0;
    this.lha = paramInt2;
    this.lgO.a(d.c.FaS);
    String str = this.lgC;
    if (this.lhP == null)
    {
      paramBoolean = true;
      if ((this.lhP != null) && (!this.lhP.lij)) {
        break label199;
      }
    }
    label199:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]", new Object[] { str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if ((this.lhP == null) || (this.lhP.lij)) {
        break label205;
      }
      Log.w("MicroMsg.X264YUVMP4MuxRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
      AppMethodBeat.o(93455);
      return -1;
      paramBoolean = false;
      break;
    }
    label205:
    if (Util.isNullOrNil(this.lgC))
    {
      Log.e("MicroMsg.X264YUVMP4MuxRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(93455);
      return -1;
    }
    this.mFileName = u.bBW(this.lgC);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "mCurRecordPath: %s", new Object[] { this.lgC });
    this.lgP = paramInt1;
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "start, cameraOrientation: %s, mute:%s", new Object[] { Integer.valueOf(this.lgP), Boolean.valueOf(this.lhf) });
    if (!this.kfR)
    {
      uv(paramInt1);
      this.kfR = true;
    }
    this.lhO.start();
    if ((!this.lhY) && (this.lhN != null))
    {
      paramInt1 = this.lhN.a(new com.tencent.mm.plugin.mmsight.model.a.c.a()
      {
        public final void aZS()
        {
          AppMethodBeat.i(93436);
          e.t(e.this);
          AppMethodBeat.o(93436);
        }
      });
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "start aac recorder ret: %d", new Object[] { Integer.valueOf(paramInt1) });
      this.lhR = d.ik("BigSightWriteCameraData", 5);
      this.lhR.start();
      this.lhS = new MMHandler(this.lhR.getLooper())
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
              e.v(e.this).eTD();
            }
            e.b(e.this, (byte[])paramAnonymousMessage.obj);
          }
          AppMethodBeat.o(93437);
        }
      };
      this.lgZ = false;
      if (paramInt1 == 0) {
        break label461;
      }
      this.lgO.a(d.c.FaZ);
    }
    for (;;)
    {
      if ((this.lhY) || (this.lhf)) {
        aZS();
      }
      AppMethodBeat.o(93455);
      return paramInt1;
      paramInt1 = 0;
      break;
      label461:
      this.lgO.a(d.c.Fba);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(93448);
    Log.printInfoStack("MicroMsg.X264YUVMP4MuxRecorder", "cancel", new Object[0]);
    this.lgO.a(d.c.FaV);
    if (this.lhS != null) {
      this.lhS.removeMessages(1);
    }
    clear();
    this.lgO.a(d.c.FaW);
    AppMethodBeat.o(93448);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(93447);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "clear, hasWriteCameraData:%s", new Object[] { Boolean.valueOf(this.lgZ) });
    if (this.lgZ) {
      com.tencent.e.h.ZvG.be(new Runnable()
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
      this.lhp = 0L;
      this.lia = 0L;
      AppMethodBeat.o(93447);
      return;
      aZT();
    }
  }
  
  public final void fU(boolean paramBoolean)
  {
    this.lhY = paramBoolean;
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
    AppMethodBeat.i(93450);
    String str = Util.nullAs(this.md5, "");
    AppMethodBeat.o(93450);
    return str;
  }
  
  public final boolean isLandscape()
  {
    return this.lft;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(93459);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "pause");
    if ((this.lgO != null) && (this.lgO.Fcd == d.c.FaT))
    {
      this.lgO.a(d.c.Fbb);
      this.lia = System.currentTimeMillis();
    }
    AppMethodBeat.o(93459);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(93452);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "reset");
    this.lgO.Fcd = d.c.FaW;
    if (this.lhS != null) {
      this.lhS.removeMessages(1);
    }
    if (this.lhN != null) {
      this.lhN.clear();
    }
    if (this.lhO != null) {
      this.lhO.clear();
    }
    clear();
    this.lgZ = false;
    AppMethodBeat.o(93452);
  }
  
  public final void setFilePath(String paramString)
  {
    this.lgC = paramString;
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.lhW = paramBoolean;
    if (this.lhO != null) {
      this.lhO.lhW = paramBoolean;
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(261949);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "setMute:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lhf = paramBoolean;
    AppMethodBeat.o(261949);
  }
  
  public final void u(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(93445);
    Log.i("MicroMsg.X264YUVMP4MuxRecorder", "setSize, width: %s, height: %s, targetWidth: %s, targetHeight: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    this.lgM = paramInt1;
    this.lgN = paramInt2;
    if (com.tencent.mm.plugin.mmsight.model.a.j.FbH.k(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = Util.currentTicks();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        com.tencent.mm.plugin.mmsight.model.a.j.FbH.as(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    }
    AppMethodBeat.o(93445);
  }
  
  public final boolean uw(int paramInt)
  {
    AppMethodBeat.i(93454);
    if (!this.kfR)
    {
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "preInit, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = uv(paramInt);
      this.kfR = true;
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
    this.lgF = paramInt;
    AppMethodBeat.o(93462);
  }
  
  final class a
    extends com.tencent.e.i.b
  {
    float cLa;
    Runnable callback;
    int duration;
    volatile int kUo;
    int lie;
    volatile boolean lif;
    boolean lig;
    boolean lih;
    boolean lii;
    boolean lij;
    final Object lik;
    
    public a()
    {
      AppMethodBeat.i(93442);
      this.kUo = 0;
      this.lif = true;
      this.lig = false;
      this.lih = false;
      this.lii = false;
      this.lij = false;
      this.lik = new Object();
      this.callback = null;
      synchronized (this.lik)
      {
        try
        {
          String str2 = u.bBT(e.e(e.this));
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
        synchronized (this.lik)
        {
          if (this.lih) {
            break label205;
          }
          l = Util.currentTicks();
          i = SightVideoJNI.triggerEncode(this.lie, Math.max(0, this.kUo), false);
          Log.i("MicroMsg.X264YUVMP4MuxRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.kUo), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          j = Math.abs(i - this.kUo);
          if (j > 5) {}
        }
        try
        {
          Thread.sleep(100L);
          this.kUo = i;
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
      if (!this.lii) {
        this.kUo = SightVideoJNI.triggerEncode(this.lie, this.kUo, true);
      }
      Log.i("MicroMsg.X264YUVMP4MuxRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.kUo), Boolean.valueOf(this.lii), Long.valueOf(Thread.currentThread().getId()) });
      Object localObject3;
      Object localObject4;
      if (!this.lii)
      {
        i = Math.max(1000, this.duration);
        if (e.g(e.this) > 0) {
          i = e.g(e.this);
        }
        float f = this.cLa;
        if (e.h(e.this) > 0.0F) {
          f = e.h(e.this);
        }
        localObject3 = e.this;
        j = this.lie;
        localObject4 = e.e(e.this);
        int k = e.i(e.this);
        int m = e.j(e.this).audioSampleRate;
        boolean bool2 = e.k(e.this);
        if (e.j(e.this).lJL == 1) {}
        for (;;)
        {
          e.a((e)localObject3, new m(j, (String)localObject4, f, k, i, m, bool2, true, bool1));
          l = Util.currentTicks();
          bool1 = e.m(e.this).ug(e.l(e.this));
          Log.i("MicroMsg.X264YUVMP4MuxRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Boolean.valueOf(bool1) });
          if (bool1) {
            break;
          }
          Log.e("MicroMsg.X264YUVMP4MuxRecorder", "mux failed!");
          SightVideoJNI.releaseBigSightDataBufferLock(this.lie);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(93439);
              if (e.n(e.this) != null) {
                e.n(e.this).bBE();
              }
              AppMethodBeat.o(93439);
            }
          });
          localObject3 = com.tencent.mm.media.k.f.laB;
          com.tencent.mm.media.k.f.aWd();
          AppMethodBeat.o(93443);
          return;
          bool1 = false;
        }
        localObject3 = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aWe();
        if (((e.o(e.this)) && (e.p(e.this))) || ((!e.p(e.this)) && (!e.o(e.this))) || ((e.o(e.this)) && (Math.abs(e.q(e.this) - e.r(e.this)) == 0)) || (e.r(e.this) == 180))
        {
          l = Util.currentTicks();
          if ((e.p(e.this)) || (e.o(e.this))) {
            break label991;
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
          u.on(e.s(e.this), e.e(e.this));
          com.tencent.e.h.ZvG.be(new com.tencent.e.i.h()
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
                u.deleteFile(this.lhE);
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
          label919:
          Log.e("MicroMsg.X264YUVMP4MuxRecorder", "stop, copy file error");
          SightVideoJNI.releaseBigSightDataBufferLock(this.lie);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(93440);
              if (e.n(e.this) != null) {
                e.n(e.this).bBE();
              }
              AppMethodBeat.o(93440);
            }
          });
          AppMethodBeat.o(93443);
          return;
        }
        try
        {
          localObject3 = com.tencent.mm.plugin.sight.base.f.aYg(e.e(e.this));
          if (localObject3 != null)
          {
            localObject4 = com.tencent.mm.media.k.f.laB;
            com.tencent.mm.media.k.f.dz(((com.tencent.mm.plugin.sight.base.b)localObject3).videoBitrate, ((com.tencent.mm.plugin.sight.base.b)localObject3).frameRate);
          }
        }
        catch (Exception localException3)
        {
          break label919;
          i = 180;
        }
        SightVideoJNI.releaseBigSightDataBufferLock(this.lie);
        Log.i("MicroMsg.X264YUVMP4MuxRecorder", "all finish, callback: %s", new Object[] { this.callback });
        e.this.reset();
        MMHandlerThread.postToMainThread(this.callback);
        this.lij = true;
        e.a(e.this, -1);
        e.b(e.this, -1);
        AppMethodBeat.o(93443);
        return;
        label991:
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