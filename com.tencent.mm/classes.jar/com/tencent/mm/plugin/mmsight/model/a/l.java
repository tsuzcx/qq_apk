package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import com.tencent.e.i.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;

public final class l
  implements d
{
  private a FbK;
  private boolean kfR;
  boolean lft;
  String lgC;
  private int lgD;
  private float lgE;
  int lgF;
  float lgG;
  private int lgJ;
  private int lgK;
  int lgL;
  int lgM;
  int lgN;
  s lgO;
  int lgP;
  String lgR;
  boolean lgS;
  private String lgT;
  private boolean lgU;
  VideoTransPara lgX;
  boolean lgZ;
  c lhN;
  p lhO;
  e lhQ;
  private HandlerThread lhR;
  MMHandler lhS;
  int lhT;
  int lhU;
  boolean lhV;
  private boolean lhW;
  private int lhX;
  private boolean lhY;
  public boolean lhZ;
  int lha;
  d.a lhb;
  boolean lhe;
  private com.tencent.mm.plugin.mmsight.model.g lhw;
  boolean lib;
  private String mFileName;
  private String md5;
  String thumbPath;
  
  public l(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89518);
    this.FbK = null;
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
    this.lib = false;
    this.lhw = new com.tencent.mm.plugin.mmsight.model.g()
    {
      public final boolean ar(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(89506);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          AppMethodBeat.o(89506);
          return false;
        }
        if (l.this.lgO.Fcd == d.c.FaT)
        {
          Object localObject = l.this;
          if ((!((l)localObject).lgS) && (((l)localObject).lhe))
          {
            ((l)localObject).lgS = true;
            byte[] arrayOfByte = new byte[paramAnonymousArrayOfByte.length];
            System.arraycopy(paramAnonymousArrayOfByte, 0, arrayOfByte, 0, paramAnonymousArrayOfByte.length);
            ThreadPool.post(new l.7((l)localObject, arrayOfByte), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
          }
          if (l.this.lhS != null)
          {
            localObject = Message.obtain();
            ((Message)localObject).what = 1;
            ((Message)localObject).obj = paramAnonymousArrayOfByte;
            l.this.lhS.sendMessage((Message)localObject);
          }
          AppMethodBeat.o(89506);
          return true;
        }
        AppMethodBeat.o(89506);
        return false;
      }
    };
    this.lgX = paramVideoTransPara;
    this.lgJ = paramVideoTransPara.width;
    this.lgK = paramVideoTransPara.height;
    this.lgL = paramVideoTransPara.videoBitrate;
    k.eTI();
    int i = k.eTK();
    if (i == -1) {}
    for (this.lgL = paramVideoTransPara.videoBitrate;; this.lgL = i)
    {
      this.lgO = new s();
      this.kfR = false;
      Log.d("MicroMsg.MMSightFFMpegRecorder", "create MMSightFFMpegRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s,  defaultRate: %s", new Object[] { Integer.valueOf(this.lgJ), Integer.valueOf(this.lgK), Integer.valueOf(this.lgL), Integer.valueOf(i) });
      AppMethodBeat.o(89518);
      return;
    }
  }
  
  private boolean uv(int paramInt)
  {
    AppMethodBeat.i(89527);
    long l = Util.currentTicks();
    this.lhV = com.tencent.mm.plugin.mmsight.model.j.EZX.lhV;
    this.lgP = paramInt;
    int j;
    label65:
    int n;
    int m;
    if (!this.lhV) {
      if ((paramInt == 0) || (paramInt == 180))
      {
        i = this.lgM;
        if ((paramInt != 0) && (paramInt != 180)) {
          break label178;
        }
        j = this.lgN;
        k = this.lgJ;
        n = this.lgK;
        m = i;
        i = n;
      }
    }
    for (;;)
    {
      n = this.lgL;
      j = SightVideoJNI.initDataBufferForMMSightLock(m, j, paramInt, k, i, this.lgX.fps, n, this.lgX.lJn, 8, this.lgX.lJm, 23.0F, this.lhV, true, this.lgX.duration, false, false, this.lib);
      if (j >= 0) {
        break label301;
      }
      Log.e("MicroMsg.MMSightFFMpegRecorder", "init failed!");
      com.tencent.mm.plugin.mmsight.model.k.eTr();
      AppMethodBeat.o(89527);
      return false;
      i = this.lgN;
      break;
      label178:
      j = this.lgM;
      break label65;
      if ((paramInt == 0) || (paramInt == 180))
      {
        i = this.lgM;
        label202:
        if ((paramInt != 0) && (paramInt != 180)) {
          break label269;
        }
        j = this.lgN;
        label218:
        if ((paramInt != 0) && (paramInt != 180)) {
          break label277;
        }
      }
      label269:
      label277:
      for (k = this.lgJ;; k = this.lgK)
      {
        if ((paramInt != 0) && (paramInt != 180)) {
          break label286;
        }
        n = this.lgK;
        m = i;
        i = n;
        break;
        i = this.lgN;
        break label202;
        j = this.lgM;
        break label218;
      }
      label286:
      n = this.lgJ;
      m = i;
      i = n;
    }
    label301:
    this.lhX = j;
    this.lhO = new p(this.lhV, paramInt, k, i, this.lhW);
    int k = this.lhO.Xc(j);
    paramInt = 0;
    int i = -1;
    if (CaptureMMProxy.getInstance() != null) {
      i = CaptureMMProxy.getInstance().getInt(ar.a.Vnk, -1);
    }
    boolean bool;
    if (i < 0)
    {
      paramInt = this.lgX.audioSampleRate;
      i = this.lgX.audioBitrate;
      m = this.lgX.audioChannelCount;
      if (this.lgX.lJL == 1) {}
      for (bool = true;; bool = false)
      {
        this.lhN = new g(paramInt, i, m, com.tencent.mm.plugin.sight.base.c.aw(true, bool));
        this.lhN.uf(this.lhY);
        paramInt = this.lhN.J(j, f.aYe(this.lgC));
        if ((k >= 0) && (paramInt >= 0)) {
          break label856;
        }
        Log.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt) });
        if ((paramInt >= 0) || (k < 0)) {
          break;
        }
        Log.w("MicroMsg.MMSightFFMpegRecorder", "aac init error, try mediarecorder now");
        this.lhN.clear();
        this.lhN = new i(this.lgX.audioSampleRate, this.lgX.audioBitrate, this.lgX.audioChannelCount);
        this.lhN.uf(this.lhY);
        paramInt = this.lhN.J(j, f.aYe(this.lgC));
        Log.w("MicroMsg.MMSightFFMpegRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt < 0) {
          break;
        }
        AppMethodBeat.o(89527);
        return true;
      }
      SightVideoJNI.releaseBigSightDataBufferLock(j);
      com.tencent.mm.plugin.mmsight.model.k.eTr();
      AppMethodBeat.o(89527);
      return false;
    }
    if (i == 1)
    {
      paramInt = this.lgX.audioSampleRate;
      i = this.lgX.audioBitrate;
      m = this.lgX.audioChannelCount;
      if (this.lgX.lJL == 1)
      {
        bool = true;
        this.lhN = new g(paramInt, i, m, com.tencent.mm.plugin.sight.base.c.aw(true, bool));
        this.lhN.uf(this.lhY);
        paramInt = this.lhN.J(j, f.aYe(this.lgC));
      }
    }
    for (;;)
    {
      if ((k >= 0) && (paramInt >= 0)) {
        break label856;
      }
      Log.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt) });
      SightVideoJNI.releaseBigSightDataBufferLock(j);
      com.tencent.mm.plugin.mmsight.model.k.eTr();
      AppMethodBeat.o(89527);
      return false;
      bool = false;
      break;
      if (i == 2)
      {
        this.lhN = new i(this.lgX.audioSampleRate, this.lgX.audioBitrate, this.lgX.audioChannelCount);
        this.lhN.uf(this.lhY);
        paramInt = this.lhN.J(j, f.aYe(this.lgC));
      }
    }
    label856:
    Log.i("MicroMsg.MMSightFFMpegRecorder", "initImpl used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(89527);
    return true;
  }
  
  private boolean uy(int paramInt)
  {
    AppMethodBeat.i(89520);
    if ((this.FbK != null) && (!this.FbK.lij))
    {
      if (!this.FbK.lig)
      {
        this.FbK.callback = null;
        this.FbK.lii = true;
        this.FbK.lih = true;
        this.FbK.cancel();
      }
      synchronized (this.FbK.lik)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(paramInt);
        if (this.FbK.lie != paramInt) {
          SightVideoJNI.releaseBigSightDataBufferLock(this.FbK.lie);
        }
        AppMethodBeat.o(89520);
        return true;
      }
    }
    AppMethodBeat.o(89520);
    return false;
  }
  
  /* Error */
  public final void E(final Runnable paramRunnable)
  {
    // Byte code:
    //   0: ldc_w 464
    //   3: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 98	com/tencent/mm/plugin/mmsight/model/a/l:FbK	Lcom/tencent/mm/plugin/mmsight/model/a/l$a;
    //   10: ifnonnull +125 -> 135
    //   13: iconst_1
    //   14: istore_2
    //   15: aload_0
    //   16: getfield 98	com/tencent/mm/plugin/mmsight/model/a/l:FbK	Lcom/tencent/mm/plugin/mmsight/model/a/l$a;
    //   19: ifnull +121 -> 140
    //   22: aload_0
    //   23: getfield 98	com/tencent/mm/plugin/mmsight/model/a/l:FbK	Lcom/tencent/mm/plugin/mmsight/model/a/l$a;
    //   26: getfield 275	com/tencent/mm/plugin/mmsight/model/a/l$a:lig	Z
    //   29: ifeq +111 -> 140
    //   32: iconst_1
    //   33: istore_3
    //   34: aload_0
    //   35: getfield 98	com/tencent/mm/plugin/mmsight/model/a/l:FbK	Lcom/tencent/mm/plugin/mmsight/model/a/l$a;
    //   38: ifnull +107 -> 145
    //   41: aload_0
    //   42: getfield 98	com/tencent/mm/plugin/mmsight/model/a/l:FbK	Lcom/tencent/mm/plugin/mmsight/model/a/l$a;
    //   45: getfield 455	com/tencent/mm/plugin/mmsight/model/a/l$a:lih	Z
    //   48: ifeq +97 -> 145
    //   51: iconst_1
    //   52: istore 4
    //   54: ldc 201
    //   56: ldc_w 466
    //   59: iconst_3
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: iload_2
    //   66: invokestatic 471	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   69: aastore
    //   70: dup
    //   71: iconst_1
    //   72: iload_3
    //   73: invokestatic 471	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   76: aastore
    //   77: dup
    //   78: iconst_2
    //   79: iload 4
    //   81: invokestatic 471	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   84: aastore
    //   85: invokestatic 259	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: aload_0
    //   89: getfield 98	com/tencent/mm/plugin/mmsight/model/a/l:FbK	Lcom/tencent/mm/plugin/mmsight/model/a/l$a;
    //   92: ifnull +71 -> 163
    //   95: aload_0
    //   96: getfield 98	com/tencent/mm/plugin/mmsight/model/a/l:FbK	Lcom/tencent/mm/plugin/mmsight/model/a/l$a;
    //   99: getfield 275	com/tencent/mm/plugin/mmsight/model/a/l$a:lig	Z
    //   102: ifeq +61 -> 163
    //   105: aload_0
    //   106: getfield 98	com/tencent/mm/plugin/mmsight/model/a/l:FbK	Lcom/tencent/mm/plugin/mmsight/model/a/l$a;
    //   109: getfield 459	com/tencent/mm/plugin/mmsight/model/a/l$a:lik	Ljava/lang/Object;
    //   112: astore 5
    //   114: aload 5
    //   116: monitorenter
    //   117: aload_0
    //   118: invokevirtual 305	com/tencent/mm/plugin/mmsight/model/a/l:reset	()V
    //   121: aload_1
    //   122: invokestatic 311	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   125: aload 5
    //   127: monitorexit
    //   128: ldc_w 464
    //   131: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   155: ldc_w 464
    //   158: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aload_1
    //   162: athrow
    //   163: ldc 201
    //   165: ldc_w 473
    //   168: iconst_2
    //   169: anewarray 4	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload_0
    //   175: getfield 164	com/tencent/mm/plugin/mmsight/model/a/l:lhZ	Z
    //   178: invokestatic 471	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: aload_0
    //   185: getfield 130	com/tencent/mm/plugin/mmsight/model/a/l:lhS	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   188: aastore
    //   189: invokestatic 259	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: aload_0
    //   193: getfield 164	com/tencent/mm/plugin/mmsight/model/a/l:lhZ	Z
    //   196: ifeq +34 -> 230
    //   199: aload_0
    //   200: getfield 130	com/tencent/mm/plugin/mmsight/model/a/l:lhS	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   203: ifnull +27 -> 230
    //   206: aload_0
    //   207: getfield 130	com/tencent/mm/plugin/mmsight/model/a/l:lhS	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   210: new 10	com/tencent/mm/plugin/mmsight/model/a/l$2
    //   213: dup
    //   214: aload_0
    //   215: aload_1
    //   216: invokespecial 475	com/tencent/mm/plugin/mmsight/model/a/l$2:<init>	(Lcom/tencent/mm/plugin/mmsight/model/a/l;Ljava/lang/Runnable;)V
    //   219: invokevirtual 481	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   222: pop
    //   223: ldc_w 464
    //   226: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: return
    //   230: new 12	com/tencent/mm/plugin/mmsight/model/a/l$3
    //   233: dup
    //   234: aload_0
    //   235: aload_1
    //   236: invokespecial 482	com/tencent/mm/plugin/mmsight/model/a/l$3:<init>	(Lcom/tencent/mm/plugin/mmsight/model/a/l;Ljava/lang/Runnable;)V
    //   239: ldc_w 484
    //   242: invokestatic 489	com/tencent/mm/sdk/thread/ThreadPool:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   245: ldc_w 464
    //   248: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	l
    //   0	252	1	paramRunnable	Runnable
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
    AppMethodBeat.i(89534);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    if ((this.lgO != null) && (this.lgO.Fcd == d.c.Fbb))
    {
      if (this.lhO != null) {
        this.lhO.P(paramInt1, paramInt2, paramInt3);
      }
      this.lgO.a(d.c.FaT);
    }
    AppMethodBeat.o(89534);
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
    AppMethodBeat.i(89525);
    long l = this.lhO.aUC();
    AppMethodBeat.o(89525);
    return l;
  }
  
  public final d.c aZF()
  {
    return this.lgO.Fcd;
  }
  
  public final int aZG()
  {
    AppMethodBeat.i(89531);
    int i = Math.round(this.lgD / 1000.0F);
    AppMethodBeat.o(89531);
    return i;
  }
  
  public final Point aZH()
  {
    AppMethodBeat.i(89532);
    Point localPoint = new Point(this.lgM, this.lgN);
    AppMethodBeat.o(89532);
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
    AppMethodBeat.i(89535);
    if (this.lhN != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.lhN.eTE();
      AppMethodBeat.o(89535);
      return locala;
    }
    AppMethodBeat.o(89535);
    return null;
  }
  
  public final void aZL()
  {
    this.lhe = false;
  }
  
  final void aZQ()
  {
    if (this.FbK != null) {
      this.FbK.lih = true;
    }
  }
  
  final void aZS()
  {
    AppMethodBeat.i(89530);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "ashutest::pcm ready");
    if ((this.FbK != null) && (!this.FbK.lij)) {
      Log.e("MicroMsg.MMSightFFMpegRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", new Object[] { this.FbK });
    }
    synchronized (this.FbK.lik)
    {
      uy(this.FbK.lie);
      if (this.lgO.Fcd != d.c.Fba)
      {
        Log.w("MicroMsg.MMSightFFMpegRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
        AppMethodBeat.o(89530);
        return;
      }
    }
    this.lgO.a(d.c.FaT);
    this.FbK = new a();
    this.FbK.lie = this.lhX;
    ThreadPool.post(this.FbK, "SightCustomAsyncMediaRecorder_encode_" + Util.currentTicks(), 5);
    AppMethodBeat.o(89530);
  }
  
  public final String aZe()
  {
    return this.thumbPath;
  }
  
  public final void av(float paramFloat)
  {
    AppMethodBeat.i(89537);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.lgG = paramFloat;
    AppMethodBeat.o(89537);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(89529);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { this.lgO.Fcd, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.lft = paramBoolean;
    this.lgD = 0;
    this.lha = paramInt2;
    this.lgO.a(d.c.FaS);
    String str = this.lgC;
    if (this.FbK == null)
    {
      paramBoolean = true;
      if ((this.FbK != null) && (!this.FbK.lij)) {
        break label179;
      }
    }
    label179:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.MMSightFFMpegRecorder", "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]", new Object[] { str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if ((this.FbK == null) || (this.FbK.lij)) {
        break label185;
      }
      Log.w("MicroMsg.MMSightFFMpegRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
      AppMethodBeat.o(89529);
      return -1;
      paramBoolean = false;
      break;
    }
    label185:
    if (Util.isNullOrNil(this.lgC))
    {
      Log.e("MicroMsg.MMSightFFMpegRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(89529);
      return -1;
    }
    this.mFileName = u.bBW(this.lgC);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "mCurRecordPath: %s", new Object[] { this.lgC });
    this.lgP = paramInt1;
    Log.i("MicroMsg.MMSightFFMpegRecorder", "start, cameraOrientation: %s", new Object[] { Integer.valueOf(this.lgP) });
    if (!this.kfR)
    {
      uv(paramInt1);
      this.kfR = true;
    }
    this.lhO.start();
    if (!this.lhY)
    {
      paramInt1 = this.lhN.a(new c.a()
      {
        public final void aZS()
        {
          AppMethodBeat.i(89510);
          l.this.aZS();
          AppMethodBeat.o(89510);
        }
      });
      Log.i("MicroMsg.MMSightFFMpegRecorder", "start aac recorder ret: %d", new Object[] { Integer.valueOf(paramInt1) });
      this.lhR = com.tencent.e.c.d.ik("BigSightWriteCameraData", 0);
      this.lhR.start();
      this.lhS = new MMHandler(this.lhR.getLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(89511);
          if (l.this.lhT == -1)
          {
            l.this.lhT = Process.myTid();
            Log.i("MicroMsg.MMSightFFMpegRecorder", "writeCameraTid: %s", new Object[] { Integer.valueOf(l.this.lhT) });
          }
          l locall;
          byte[] arrayOfByte;
          int k;
          int j;
          int i;
          if (paramAnonymousMessage.what == 1)
          {
            l.this.lhN.eTD();
            locall = l.this;
            arrayOfByte = (byte[])paramAnonymousMessage.obj;
            if (!locall.lhV) {
              break label149;
            }
            paramAnonymousMessage = locall.lhO;
            k = arrayOfByte.length;
            j = locall.lgM;
            i = locall.lgN;
          }
          for (;;)
          {
            paramAnonymousMessage.f(arrayOfByte, k, j, i);
            j.FbH.as(arrayOfByte);
            locall.lgZ = true;
            AppMethodBeat.o(89511);
            return;
            label149:
            paramAnonymousMessage = locall.lhO;
            k = arrayOfByte.length;
            if ((locall.lgP == 0) || (locall.lgP == 180)) {}
            for (i = locall.lgM;; i = locall.lgN)
            {
              if ((locall.lgP != 0) && (locall.lgP != 180)) {
                break label228;
              }
              m = locall.lgN;
              j = i;
              i = m;
              break;
            }
            label228:
            int m = locall.lgM;
            j = i;
            i = m;
          }
        }
      };
      this.lgZ = false;
      if (paramInt1 == 0) {
        break label441;
      }
      this.lgO.a(d.c.FaZ);
    }
    for (;;)
    {
      com.tencent.mm.plugin.mmsight.model.k.eTq();
      Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCapture");
      h.IzE.idkeyStat(440L, 1L, 1L, false);
      if (this.lhY) {
        aZS();
      }
      AppMethodBeat.o(89529);
      return paramInt1;
      paramInt1 = 0;
      break;
      label441:
      this.lgO.a(d.c.Fba);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(89522);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "cancel");
    this.lgO.a(d.c.FaV);
    clear();
    this.lgO.a(d.c.FaW);
    AppMethodBeat.o(89522);
  }
  
  public final void clear()
  {
    boolean bool2 = true;
    AppMethodBeat.i(89521);
    int i = -1;
    if (this.lhO != null)
    {
      i = this.lhO.FbU;
      if (i < 0)
      {
        Log.v("MicroMsg.MMSightFFMpegRecorder", "call clear, but bufID error");
        AppMethodBeat.o(89521);
        return;
      }
      this.lhO.stop();
    }
    if (this.lhN != null) {
      this.lhN.a(null);
    }
    boolean bool1;
    if (this.FbK == null)
    {
      bool1 = true;
      if ((this.FbK == null) || (!this.FbK.lii)) {
        break label177;
      }
    }
    for (;;)
    {
      Log.v("MicroMsg.MMSightFFMpegRecorder", "ashutest::clear bufID %d, encodeRunnable null ? %B, markCancel %B", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((i >= 0) && (!uy(i)))
      {
        SightVideoJNI.releaseRecorderBufferRef("clear");
        SightVideoJNI.releaseBigSightDataBufferLock(i);
      }
      if (this.lhR != null) {
        this.lhR.quit();
      }
      AppMethodBeat.o(89521);
      return;
      bool1 = false;
      break;
      label177:
      bool2 = false;
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
  
  public final com.tencent.mm.plugin.mmsight.model.g getFrameDataCallback()
  {
    return this.lhw;
  }
  
  public final String getMd5()
  {
    AppMethodBeat.i(89524);
    String str = Util.nullAs(this.md5, "");
    AppMethodBeat.o(89524);
    return str;
  }
  
  public final boolean isLandscape()
  {
    return this.lft;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89533);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "pause");
    if ((this.lgO != null) && (this.lgO.Fcd == d.c.FaT)) {
      this.lgO.a(d.c.Fbb);
    }
    AppMethodBeat.o(89533);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(89526);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "reset");
    this.lgO.Fcd = d.c.FaW;
    this.lgZ = false;
    if (this.lhN != null) {
      this.lhN.clear();
    }
    if (this.lhO != null) {
      this.lhO.clear();
    }
    clear();
    AppMethodBeat.o(89526);
  }
  
  public final void setFilePath(String paramString)
  {
    this.lgC = paramString;
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.lhW = paramBoolean;
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void u(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(89519);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "setSize, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.lgJ = paramInt3;
    this.lgK = paramInt4;
    this.lgM = paramInt1;
    this.lgN = paramInt2;
    if (j.FbH.k(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      Log.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = Util.currentTicks();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        j.FbH.as(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      Log.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    }
    AppMethodBeat.o(89519);
  }
  
  public final boolean uw(int paramInt)
  {
    AppMethodBeat.i(89528);
    if (!this.kfR)
    {
      Log.i("MicroMsg.MMSightFFMpegRecorder", "preInit, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = uv(paramInt);
      this.kfR = true;
      Log.i("MicroMsg.MMSightFFMpegRecorder", "initImpl result: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(89528);
      return bool;
    }
    AppMethodBeat.o(89528);
    return true;
  }
  
  public final void ux(int paramInt)
  {
    AppMethodBeat.i(89536);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "overrideDurationMs: %s", new Object[] { Integer.valueOf(paramInt) });
    this.lgF = paramInt;
    AppMethodBeat.o(89536);
  }
  
  final class a
    extends b
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
      AppMethodBeat.i(89516);
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
          String str2 = u.bBT(l.this.lgC);
          String str1 = str2;
          if (!str2.endsWith("/")) {
            str1 = str2 + "/";
          }
          l.this.lgR = (str1 + "tempRotate.mp4");
        }
        catch (Exception this$1)
        {
          for (;;)
          {
            Log.e("MicroMsg.MMSightFFMpegRecorder", "retrieve file name error: %s", new Object[] { l.this.getMessage() });
          }
        }
        AppMethodBeat.o(89516);
        return;
      }
    }
    
    public final String getKey()
    {
      return "MicroMsg.MMSightFFMpegRecorder";
    }
    
    public final void run()
    {
      AppMethodBeat.i(89517);
      if (l.this.lhU == -1)
      {
        l.this.lhU = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        Log.i("MicroMsg.MMSightFFMpegRecorder", "encodeTid: %s", new Object[] { Integer.valueOf(l.this.lhU) });
      }
      int i;
      int j;
      for (;;)
      {
        synchronized (this.lik)
        {
          if (this.lih) {
            break label201;
          }
          l = Util.currentTicks();
          i = SightVideoJNI.triggerEncode(this.lie, Math.max(0, this.kUo), false);
          Log.i("MicroMsg.MMSightFFMpegRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.kUo), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          j = Math.abs(i - this.kUo);
          if (j > 5) {}
        }
        try
        {
          Thread.sleep(100L);
          this.kUo = i;
          continue;
          localObject2 = finally;
          AppMethodBeat.o(89517);
          throw localObject2;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Log.e("MicroMsg.MMSightFFMpegRecorder", "thread sleep error");
          }
        }
      }
      label201:
      long l = Util.currentTicks();
      if (!this.lii) {
        this.kUo = SightVideoJNI.triggerEncode(this.lie, this.kUo, true);
      }
      Log.i("MicroMsg.MMSightFFMpegRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.kUo), Boolean.valueOf(this.lii), Long.valueOf(Thread.currentThread().getId()) });
      if (!this.lii)
      {
        i = Math.max(1000, this.duration);
        if (l.this.lgF > 0) {
          i = l.this.lgF;
        }
        float f = this.cLa;
        if (l.this.lgG > 0.0F) {
          f = l.this.lgG;
        }
        l.this.lhQ = new m(this.lie, l.this.lgC, f, l.this.lgL, i, l.this.lgX.audioSampleRate, false, true, false);
        l = Util.currentTicks();
        boolean bool = l.this.lhQ.ug(l.this.lib);
        Log.i("MicroMsg.MMSightFFMpegRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Boolean.valueOf(bool) });
        if (!bool)
        {
          Log.e("MicroMsg.MMSightFFMpegRecorder", "mux failed!");
          SightVideoJNI.releaseBigSightDataBufferLock(this.lie);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89513);
              if (l.this.lhb != null) {
                l.this.lhb.bBE();
              }
              AppMethodBeat.o(89513);
            }
          });
          Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCaptureMuxError");
          h.IzE.idkeyStat(440L, 30L, 1L, false);
          AppMethodBeat.o(89517);
          return;
        }
        if (((l.this.lft) && (l.this.lhV)) || ((!l.this.lhV) && (!l.this.lft)) || ((l.this.lft) && (Math.abs(l.this.lgP - l.this.lha) == 0)) || (l.this.lha == 180))
        {
          l = Util.currentTicks();
          if ((l.this.lhV) || (l.this.lft)) {
            break label902;
          }
          i = l.this.lgP;
        }
      }
      for (;;)
      {
        j = i;
        if (l.this.lha == 180)
        {
          j = i;
          if (!l.this.lhV)
          {
            i += 180;
            j = i;
            if (i > 360) {
              j = i - 360;
            }
          }
        }
        final String str;
        if (j > 0)
        {
          SightVideoJNI.tagRotateVideoVFS(l.this.lgC, l.this.lgR, j);
          Log.i("MicroMsg.MMSightFFMpegRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(l.this.lgP), Boolean.valueOf(l.this.lft), Integer.valueOf(l.this.lha), Integer.valueOf(j) });
          str = l.this.lgR;
        }
        try
        {
          u.on(l.this.lgR, l.this.lgC);
          ThreadPool.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89515);
              try
              {
                u.deleteFile(str);
                AppMethodBeat.o(89515);
                return;
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.MMSightFFMpegRecorder", "stop, delete old file error: %s", new Object[] { localException.getMessage() });
                AppMethodBeat.o(89515);
              }
            }
          }, "BigSightFFMpegRecorder_tagRotate_after_process");
          Log.i("MicroMsg.MMSightFFMpegRecorder", "tag rotate used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
          SightVideoJNI.releaseBigSightDataBufferLock(this.lie);
          Log.i("MicroMsg.MMSightFFMpegRecorder", "all finish, callback: %s", new Object[] { this.callback });
          l.this.reset();
          MMHandlerThread.postToMainThread(this.callback);
          this.lij = true;
          l.this.lhU = -1;
          l.this.lhT = -1;
          AppMethodBeat.o(89517);
          return;
        }
        catch (Exception localException2)
        {
          label902:
          Log.e("MicroMsg.MMSightFFMpegRecorder", "stop, copy file error");
          SightVideoJNI.releaseBigSightDataBufferLock(this.lie);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89514);
              if (l.this.lhb != null) {
                l.this.lhb.bBE();
              }
              AppMethodBeat.o(89514);
            }
          });
          AppMethodBeat.o(89517);
          return;
        }
        if (l.this.lhV) {
          i = l.this.lha;
        } else {
          i = 180;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.l
 * JD-Core Version:    0.7.0.1
 */