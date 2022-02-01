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
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i.b;
import java.io.ByteArrayOutputStream;

public final class l
  implements d
{
  private a KXt;
  private String mFileName;
  private boolean mGp;
  private String md5;
  boolean nKe;
  String nLB;
  boolean nLC;
  private String nLD;
  private boolean nLE;
  VideoTransPara nLH;
  boolean nLJ;
  int nLK;
  d.a nLL;
  boolean nLO;
  String nLm;
  private int nLn;
  private float nLo;
  int nLp;
  float nLq;
  private int nLt;
  private int nLu;
  int nLv;
  int nLw;
  int nLx;
  s nLy;
  int nLz;
  private HandlerThread nMA;
  MMHandler nMB;
  int nMC;
  int nMD;
  boolean nME;
  private boolean nMF;
  private int nMG;
  private boolean nMH;
  public boolean nMI;
  boolean nMK;
  private com.tencent.mm.plugin.mmsight.model.g nMg;
  c nMw;
  p nMx;
  e nMz;
  String thumbPath;
  
  public l(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(89518);
    this.KXt = null;
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
    this.nMK = false;
    this.nMg = new com.tencent.mm.plugin.mmsight.model.g()
    {
      public final boolean onFrameData(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(89506);
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length <= 0))
        {
          AppMethodBeat.o(89506);
          return false;
        }
        if (l.this.nLy.KXM == d.c.KWC)
        {
          Object localObject = l.this;
          if ((!((l)localObject).nLC) && (((l)localObject).nLO))
          {
            ((l)localObject).nLC = true;
            byte[] arrayOfByte = new byte[paramAnonymousArrayOfByte.length];
            System.arraycopy(paramAnonymousArrayOfByte, 0, arrayOfByte, 0, paramAnonymousArrayOfByte.length);
            ThreadPool.post(new l.7((l)localObject, arrayOfByte), "BigSightMediaCodecMP4MuxRecorder_saveThumb");
          }
          if (l.this.nMB != null)
          {
            localObject = Message.obtain();
            ((Message)localObject).what = 1;
            ((Message)localObject).obj = paramAnonymousArrayOfByte;
            l.this.nMB.sendMessage((Message)localObject);
          }
          AppMethodBeat.o(89506);
          return true;
        }
        AppMethodBeat.o(89506);
        return false;
      }
    };
    this.nLH = paramVideoTransPara;
    this.nLt = paramVideoTransPara.width;
    this.nLu = paramVideoTransPara.height;
    this.nLv = paramVideoTransPara.videoBitrate;
    k.gcB();
    int i = k.gcC();
    if (i == -1) {}
    for (this.nLv = paramVideoTransPara.videoBitrate;; this.nLv = i)
    {
      this.nLy = new s();
      this.mGp = false;
      Log.d("MicroMsg.MMSightFFMpegRecorder", "create MMSightFFMpegRecorder, targetWidth: %s, targetHeight: %s, targetRate: %s,  defaultRate: %s", new Object[] { Integer.valueOf(this.nLt), Integer.valueOf(this.nLu), Integer.valueOf(this.nLv), Integer.valueOf(i) });
      AppMethodBeat.o(89518);
      return;
    }
  }
  
  private boolean uv(int paramInt)
  {
    AppMethodBeat.i(89527);
    long l = Util.currentTicks();
    this.nME = com.tencent.mm.plugin.mmsight.model.j.KVJ.nME;
    this.nLz = paramInt;
    int j;
    label65:
    int n;
    int m;
    if (!this.nME) {
      if ((paramInt == 0) || (paramInt == 180))
      {
        i = this.nLw;
        if ((paramInt != 0) && (paramInt != 180)) {
          break label178;
        }
        j = this.nLx;
        k = this.nLt;
        n = this.nLu;
        m = i;
        i = n;
      }
    }
    for (;;)
    {
      n = this.nLv;
      j = SightVideoJNI.initDataBufferForMMSightLock(m, j, paramInt, k, i, this.nLH.fps, n, this.nLH.oBP, 8, this.nLH.oBO, 23.0F, this.nME, true, this.nLH.duration, false, false, this.nMK);
      if (j >= 0) {
        break label301;
      }
      Log.e("MicroMsg.MMSightFFMpegRecorder", "init failed!");
      com.tencent.mm.plugin.mmsight.model.k.gck();
      AppMethodBeat.o(89527);
      return false;
      i = this.nLx;
      break;
      label178:
      j = this.nLw;
      break label65;
      if ((paramInt == 0) || (paramInt == 180))
      {
        i = this.nLw;
        label202:
        if ((paramInt != 0) && (paramInt != 180)) {
          break label269;
        }
        j = this.nLx;
        label218:
        if ((paramInt != 0) && (paramInt != 180)) {
          break label277;
        }
      }
      label269:
      label277:
      for (k = this.nLt;; k = this.nLu)
      {
        if ((paramInt != 0) && (paramInt != 180)) {
          break label286;
        }
        n = this.nLu;
        m = i;
        i = n;
        break;
        i = this.nLx;
        break label202;
        j = this.nLw;
        break label218;
      }
      label286:
      n = this.nLt;
      m = i;
      i = n;
    }
    label301:
    this.nMG = j;
    this.nMx = new p(this.nME, paramInt, k, i, this.nMF);
    int k = this.nMx.abe(j);
    paramInt = 0;
    int i = -1;
    if (CaptureMMProxy.getInstance() != null) {
      i = CaptureMMProxy.getInstance().getInt(at.a.acOF, -1);
    }
    boolean bool;
    if (i < 0)
    {
      paramInt = this.nLH.audioSampleRate;
      i = this.nLH.audioBitrate;
      m = this.nLH.audioChannelCount;
      if (this.nLH.oCn == 1) {}
      for (bool = true;; bool = false)
      {
        this.nMw = new g(paramInt, i, m, com.tencent.mm.plugin.sight.base.c.aP(true, bool));
        this.nMw.yt(this.nMH);
        paramInt = this.nMw.L(j, f.aVV(this.nLm));
        if ((k >= 0) && (paramInt >= 0)) {
          break label856;
        }
        Log.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt) });
        if ((paramInt >= 0) || (k < 0)) {
          break;
        }
        Log.w("MicroMsg.MMSightFFMpegRecorder", "aac init error, try mediarecorder now");
        this.nMw.clear();
        this.nMw = new i(this.nLH.audioSampleRate, this.nLH.audioBitrate, this.nLH.audioChannelCount);
        this.nMw.yt(this.nMH);
        paramInt = this.nMw.L(j, f.aVV(this.nLm));
        Log.w("MicroMsg.MMSightFFMpegRecorder", "MMSightAACMediaRecorder init ret: %s", new Object[] { Integer.valueOf(paramInt) });
        if (paramInt < 0) {
          break;
        }
        AppMethodBeat.o(89527);
        return true;
      }
      SightVideoJNI.releaseBigSightDataBufferLock(j);
      com.tencent.mm.plugin.mmsight.model.k.gck();
      AppMethodBeat.o(89527);
      return false;
    }
    if (i == 1)
    {
      paramInt = this.nLH.audioSampleRate;
      i = this.nLH.audioBitrate;
      m = this.nLH.audioChannelCount;
      if (this.nLH.oCn == 1)
      {
        bool = true;
        this.nMw = new g(paramInt, i, m, com.tencent.mm.plugin.sight.base.c.aP(true, bool));
        this.nMw.yt(this.nMH);
        paramInt = this.nMw.L(j, f.aVV(this.nLm));
      }
    }
    for (;;)
    {
      if ((k >= 0) && (paramInt >= 0)) {
        break label856;
      }
      Log.e("MicroMsg.MMSightFFMpegRecorder", "init yuv or aac recorder error!! %d %d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt) });
      SightVideoJNI.releaseBigSightDataBufferLock(j);
      com.tencent.mm.plugin.mmsight.model.k.gck();
      AppMethodBeat.o(89527);
      return false;
      bool = false;
      break;
      if (i == 2)
      {
        this.nMw = new i(this.nLH.audioSampleRate, this.nLH.audioBitrate, this.nLH.audioChannelCount);
        this.nMw.yt(this.nMH);
        paramInt = this.nMw.L(j, f.aVV(this.nLm));
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
    if ((this.KXt != null) && (!this.KXt.nMS))
    {
      if (!this.KXt.nMP)
      {
        this.KXt.callback = null;
        this.KXt.nMR = true;
        this.KXt.nMQ = true;
        this.KXt.cancel();
      }
      synchronized (this.KXt.nMT)
      {
        SightVideoJNI.releaseBigSightDataBufferLock(paramInt);
        if (this.KXt.nMN != paramInt) {
          SightVideoJNI.releaseBigSightDataBufferLock(this.KXt.nMN);
        }
        AppMethodBeat.o(89520);
        return true;
      }
    }
    AppMethodBeat.o(89520);
    return false;
  }
  
  public final void A(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(89519);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "setSize, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.nLt = paramInt3;
    this.nLu = paramInt4;
    this.nLw = paramInt1;
    this.nLx = paramInt2;
    if (j.KXq.m(Integer.valueOf(paramInt1 * paramInt2 * 3 / 2)) == null)
    {
      Log.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData, width: %s, height: %s, count: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(3) });
      long l = Util.currentTicks();
      paramInt3 = 0;
      while (paramInt3 < 3)
      {
        j.KXq.as(new byte[paramInt1 * paramInt2 * 3 / 2]);
        paramInt3 += 1;
      }
      Log.i("MicroMsg.MMSightFFMpegRecorder", "preloadCameraData used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    }
    AppMethodBeat.o(89519);
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
    //   0: ldc_w 490
    //   3: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 98	com/tencent/mm/plugin/mmsight/model/a/l:KXt	Lcom/tencent/mm/plugin/mmsight/model/a/l$a;
    //   10: ifnonnull +125 -> 135
    //   13: iconst_1
    //   14: istore_2
    //   15: aload_0
    //   16: getfield 98	com/tencent/mm/plugin/mmsight/model/a/l:KXt	Lcom/tencent/mm/plugin/mmsight/model/a/l$a;
    //   19: ifnull +121 -> 140
    //   22: aload_0
    //   23: getfield 98	com/tencent/mm/plugin/mmsight/model/a/l:KXt	Lcom/tencent/mm/plugin/mmsight/model/a/l$a;
    //   26: getfield 275	com/tencent/mm/plugin/mmsight/model/a/l$a:nMP	Z
    //   29: ifeq +111 -> 140
    //   32: iconst_1
    //   33: istore_3
    //   34: aload_0
    //   35: getfield 98	com/tencent/mm/plugin/mmsight/model/a/l:KXt	Lcom/tencent/mm/plugin/mmsight/model/a/l$a;
    //   38: ifnull +107 -> 145
    //   41: aload_0
    //   42: getfield 98	com/tencent/mm/plugin/mmsight/model/a/l:KXt	Lcom/tencent/mm/plugin/mmsight/model/a/l$a;
    //   45: getfield 455	com/tencent/mm/plugin/mmsight/model/a/l$a:nMQ	Z
    //   48: ifeq +97 -> 145
    //   51: iconst_1
    //   52: istore 4
    //   54: ldc 201
    //   56: ldc_w 492
    //   59: iconst_3
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: iload_2
    //   66: invokestatic 497	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   69: aastore
    //   70: dup
    //   71: iconst_1
    //   72: iload_3
    //   73: invokestatic 497	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   76: aastore
    //   77: dup
    //   78: iconst_2
    //   79: iload 4
    //   81: invokestatic 497	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   84: aastore
    //   85: invokestatic 259	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: aload_0
    //   89: getfield 98	com/tencent/mm/plugin/mmsight/model/a/l:KXt	Lcom/tencent/mm/plugin/mmsight/model/a/l$a;
    //   92: ifnull +71 -> 163
    //   95: aload_0
    //   96: getfield 98	com/tencent/mm/plugin/mmsight/model/a/l:KXt	Lcom/tencent/mm/plugin/mmsight/model/a/l$a;
    //   99: getfield 275	com/tencent/mm/plugin/mmsight/model/a/l$a:nMP	Z
    //   102: ifeq +61 -> 163
    //   105: aload_0
    //   106: getfield 98	com/tencent/mm/plugin/mmsight/model/a/l:KXt	Lcom/tencent/mm/plugin/mmsight/model/a/l$a;
    //   109: getfield 459	com/tencent/mm/plugin/mmsight/model/a/l$a:nMT	Ljava/lang/Object;
    //   112: astore 5
    //   114: aload 5
    //   116: monitorenter
    //   117: aload_0
    //   118: invokevirtual 305	com/tencent/mm/plugin/mmsight/model/a/l:reset	()V
    //   121: aload_1
    //   122: invokestatic 311	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   125: aload 5
    //   127: monitorexit
    //   128: ldc_w 490
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
    //   155: ldc_w 490
    //   158: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aload_1
    //   162: athrow
    //   163: ldc 201
    //   165: ldc_w 499
    //   168: iconst_2
    //   169: anewarray 4	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload_0
    //   175: getfield 164	com/tencent/mm/plugin/mmsight/model/a/l:nMI	Z
    //   178: invokestatic 497	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: aload_0
    //   185: getfield 130	com/tencent/mm/plugin/mmsight/model/a/l:nMB	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   188: aastore
    //   189: invokestatic 259	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: aload_0
    //   193: getfield 164	com/tencent/mm/plugin/mmsight/model/a/l:nMI	Z
    //   196: ifeq +34 -> 230
    //   199: aload_0
    //   200: getfield 130	com/tencent/mm/plugin/mmsight/model/a/l:nMB	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   203: ifnull +27 -> 230
    //   206: aload_0
    //   207: getfield 130	com/tencent/mm/plugin/mmsight/model/a/l:nMB	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   210: new 10	com/tencent/mm/plugin/mmsight/model/a/l$2
    //   213: dup
    //   214: aload_0
    //   215: aload_1
    //   216: invokespecial 501	com/tencent/mm/plugin/mmsight/model/a/l$2:<init>	(Lcom/tencent/mm/plugin/mmsight/model/a/l;Ljava/lang/Runnable;)V
    //   219: invokevirtual 507	com/tencent/mm/sdk/platformtools/MMHandler:post	(Ljava/lang/Runnable;)Z
    //   222: pop
    //   223: ldc_w 490
    //   226: invokestatic 218	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: return
    //   230: new 12	com/tencent/mm/plugin/mmsight/model/a/l$3
    //   233: dup
    //   234: aload_0
    //   235: aload_1
    //   236: invokespecial 508	com/tencent/mm/plugin/mmsight/model/a/l$3:<init>	(Lcom/tencent/mm/plugin/mmsight/model/a/l;Ljava/lang/Runnable;)V
    //   239: ldc_w 510
    //   242: invokestatic 515	com/tencent/mm/sdk/thread/ThreadPool:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   245: ldc_w 490
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
  
  public final void a(d.a parama)
  {
    this.nLL = parama;
  }
  
  public final void ae(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(89534);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "resume, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt1) });
    if ((this.nLy != null) && (this.nLy.KXM == d.c.KWK))
    {
      if (this.nMx != null) {
        this.nMx.ae(paramInt1, paramInt2, paramInt3);
      }
      this.nLy.a(d.c.KWC);
    }
    AppMethodBeat.o(89534);
  }
  
  public final int b(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(89529);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "request start, last status %s, cameraOrientation: %s, isLandscape: %s, degree: %s", new Object[] { this.nLy.KXM, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    this.nKe = paramBoolean;
    this.nLn = 0;
    this.nLK = paramInt2;
    this.nLy.a(d.c.KWB);
    String str = this.nLm;
    if (this.KXt == null)
    {
      paramBoolean = true;
      if ((this.KXt != null) && (!this.KXt.nMS)) {
        break label179;
      }
    }
    label179:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.MMSightFFMpegRecorder", "initialize: filePath[%s], encodeThread null[%B], encodeThreadFinish[%B]", new Object[] { str, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      if ((this.KXt == null) || (this.KXt.nMS)) {
        break label185;
      }
      Log.w("MicroMsg.MMSightFFMpegRecorder", "ERROR, status, wait last encode thread finish!!! MUST NOT BE HERE");
      AppMethodBeat.o(89529);
      return -1;
      paramBoolean = false;
      break;
    }
    label185:
    if (Util.isNullOrNil(this.nLm))
    {
      Log.e("MicroMsg.MMSightFFMpegRecorder", "start error, mCurRecordPath is null!!");
      AppMethodBeat.o(89529);
      return -1;
    }
    this.mFileName = y.bEq(this.nLm);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "mCurRecordPath: %s", new Object[] { this.nLm });
    this.nLz = paramInt1;
    Log.i("MicroMsg.MMSightFFMpegRecorder", "start, cameraOrientation: %s", new Object[] { Integer.valueOf(this.nLz) });
    if (!this.mGp)
    {
      uv(paramInt1);
      this.mGp = true;
    }
    this.nMx.start();
    if (!this.nMH)
    {
      paramInt1 = this.nMw.a(new c.a()
      {
        public final void buO()
        {
          AppMethodBeat.i(89510);
          l.this.buO();
          AppMethodBeat.o(89510);
        }
      });
      Log.i("MicroMsg.MMSightFFMpegRecorder", "start aac recorder ret: %d", new Object[] { Integer.valueOf(paramInt1) });
      this.nMA = com.tencent.threadpool.c.d.jw("BigSightWriteCameraData", 0);
      this.nMA.start();
      this.nMB = new MMHandler(this.nMA.getLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(89511);
          if (l.this.nMC == -1)
          {
            l.this.nMC = Process.myTid();
            Log.i("MicroMsg.MMSightFFMpegRecorder", "writeCameraTid: %s", new Object[] { Integer.valueOf(l.this.nMC) });
          }
          l locall;
          byte[] arrayOfByte;
          int k;
          int j;
          int i;
          if (paramAnonymousMessage.what == 1)
          {
            l.this.nMw.gcw();
            locall = l.this;
            arrayOfByte = (byte[])paramAnonymousMessage.obj;
            if (!locall.nME) {
              break label146;
            }
            paramAnonymousMessage = locall.nMx;
            k = arrayOfByte.length;
            j = locall.nLw;
            i = locall.nLx;
          }
          for (;;)
          {
            paramAnonymousMessage.h(arrayOfByte, k, j, i);
            j.KXq.as(arrayOfByte);
            locall.nLJ = true;
            AppMethodBeat.o(89511);
            return;
            label146:
            paramAnonymousMessage = locall.nMx;
            k = arrayOfByte.length;
            if ((locall.nLz == 0) || (locall.nLz == 180)) {}
            for (i = locall.nLw;; i = locall.nLx)
            {
              if ((locall.nLz != 0) && (locall.nLz != 180)) {
                break label225;
              }
              m = locall.nLx;
              j = i;
              i = m;
              break;
            }
            label225:
            int m = locall.nLw;
            j = i;
            i = m;
          }
        }
      };
      this.nLJ = false;
      if (paramInt1 == 0) {
        break label441;
      }
      this.nLy.a(d.c.KWI);
    }
    for (;;)
    {
      com.tencent.mm.plugin.mmsight.model.k.gcj();
      Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCapture");
      h.OAn.idkeyStat(440L, 1L, 1L, false);
      if (this.nMH) {
        buO();
      }
      AppMethodBeat.o(89529);
      return paramInt1;
      paramInt1 = 0;
      break;
      label441:
      this.nLy.a(d.c.KWJ);
    }
  }
  
  public final void bq(float paramFloat)
  {
    AppMethodBeat.i(89537);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "overrideFps: %s", new Object[] { Float.valueOf(paramFloat) });
    this.nLq = paramFloat;
    AppMethodBeat.o(89537);
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
    AppMethodBeat.i(89525);
    long l = this.nMx.bpj();
    AppMethodBeat.o(89525);
    return l;
  }
  
  public final d.c buD()
  {
    return this.nLy.KXM;
  }
  
  public final int buE()
  {
    AppMethodBeat.i(89531);
    int i = Math.round(this.nLn / 1000.0F);
    AppMethodBeat.o(89531);
    return i;
  }
  
  public final Point buF()
  {
    AppMethodBeat.i(89532);
    Point localPoint = new Point(this.nLw, this.nLx);
    AppMethodBeat.o(89532);
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
    AppMethodBeat.i(89535);
    if (this.nMw != null)
    {
      com.tencent.mm.audio.b.c.a locala = this.nMw.gcx();
      AppMethodBeat.o(89535);
      return locala;
    }
    AppMethodBeat.o(89535);
    return null;
  }
  
  public final void buJ()
  {
    this.nLO = false;
  }
  
  final void buN()
  {
    if (this.KXt != null) {
      this.KXt.nMQ = true;
    }
  }
  
  final void buO()
  {
    AppMethodBeat.i(89530);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "ashutest::pcm ready");
    if ((this.KXt != null) && (!this.KXt.nMS)) {
      Log.e("MicroMsg.MMSightFFMpegRecorder", "ashutest::OnPcmReady, last encode thread[%s] status error!!! MUST NOT BE HERE", new Object[] { this.KXt });
    }
    synchronized (this.KXt.nMT)
    {
      uy(this.KXt.nMN);
      if (this.nLy.KXM != d.c.KWJ)
      {
        Log.w("MicroMsg.MMSightFFMpegRecorder", "ashutest::not MediaStatus.Initialized, maybe canceled by user");
        AppMethodBeat.o(89530);
        return;
      }
    }
    this.nLy.a(d.c.KWC);
    this.KXt = new a();
    this.KXt.nMN = this.nMG;
    ThreadPool.post(this.KXt, "SightCustomAsyncMediaRecorder_encode_" + Util.currentTicks(), 5);
    AppMethodBeat.o(89530);
  }
  
  public final String bud()
  {
    return this.thumbPath;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(89522);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "cancel");
    this.nLy.a(d.c.KWE);
    clear();
    this.nLy.a(d.c.KWF);
    AppMethodBeat.o(89522);
  }
  
  public final void clear()
  {
    boolean bool2 = true;
    AppMethodBeat.i(89521);
    int i = -1;
    if (this.nMx != null)
    {
      i = this.nMx.KXD;
      if (i < 0)
      {
        Log.v("MicroMsg.MMSightFFMpegRecorder", "call clear, but bufID error");
        AppMethodBeat.o(89521);
        return;
      }
      this.nMx.stop();
    }
    if (this.nMw != null) {
      this.nMw.a(null);
    }
    boolean bool1;
    if (this.KXt == null)
    {
      bool1 = true;
      if ((this.KXt == null) || (!this.KXt.nMR)) {
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
      if (this.nMA != null) {
        this.nMA.quit();
      }
      AppMethodBeat.o(89521);
      return;
      bool1 = false;
      break;
      label177:
      bool2 = false;
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
  
  public final com.tencent.mm.plugin.mmsight.model.g getFrameDataCallback()
  {
    return this.nMg;
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
    return this.nKe;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(89533);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "pause");
    if ((this.nLy != null) && (this.nLy.KXM == d.c.KWC)) {
      this.nLy.a(d.c.KWK);
    }
    AppMethodBeat.o(89533);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(89526);
    Log.i("MicroMsg.MMSightFFMpegRecorder", "reset");
    this.nLy.KXM = d.c.KWF;
    this.nLJ = false;
    if (this.nMw != null) {
      this.nMw.clear();
    }
    if (this.nMx != null) {
      this.nMx.clear();
    }
    clear();
    AppMethodBeat.o(89526);
  }
  
  public final void setFilePath(String paramString)
  {
    this.nLm = paramString;
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    this.nMF = paramBoolean;
  }
  
  public final void setMute(boolean paramBoolean) {}
  
  public final boolean uw(int paramInt)
  {
    AppMethodBeat.i(89528);
    if (!this.mGp)
    {
      Log.i("MicroMsg.MMSightFFMpegRecorder", "preInit, cameraOrientation: %s", new Object[] { Integer.valueOf(paramInt) });
      boolean bool = uv(paramInt);
      this.mGp = true;
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
    this.nLp = paramInt;
    AppMethodBeat.o(89536);
  }
  
  final class a
    extends b
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
      AppMethodBeat.i(89516);
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
          String str2 = y.bEo(l.this.nLm);
          String str1 = str2;
          if (!str2.endsWith("/")) {
            str1 = str2 + "/";
          }
          l.this.nLB = (str1 + "tempRotate.mp4");
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
      if (l.this.nMD == -1)
      {
        l.this.nMD = Process.myTid();
        Process.setThreadPriority(Process.myTid(), -2);
        Log.i("MicroMsg.MMSightFFMpegRecorder", "encodeTid: %s", new Object[] { Integer.valueOf(l.this.nMD) });
      }
      int i;
      int j;
      for (;;)
      {
        synchronized (this.nMT)
        {
          if (this.nMQ) {
            break label201;
          }
          l = Util.currentTicks();
          i = SightVideoJNI.triggerEncode(this.nMN, Math.max(0, this.nzX), false);
          Log.i("MicroMsg.MMSightFFMpegRecorder", "ing: trgger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.nzX), Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()) });
          j = Math.abs(i - this.nzX);
          if (j > 5) {}
        }
        try
        {
          Thread.sleep(100L);
          this.nzX = i;
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
      if (!this.nMR) {
        this.nzX = SightVideoJNI.triggerEncode(this.nMN, this.nzX, true);
      }
      Log.i("MicroMsg.MMSightFFMpegRecorder", "end: trgger encode use %dms, curEncode index %d, markCancel %B, threadId: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(this.nzX), Boolean.valueOf(this.nMR), Long.valueOf(Thread.currentThread().getId()) });
      if (!this.nMR)
      {
        i = Math.max(1000, this.duration);
        if (l.this.nLp > 0) {
          i = l.this.nLp;
        }
        float f = this.eGw;
        if (l.this.nLq > 0.0F) {
          f = l.this.nLq;
        }
        l.this.nMz = new m(this.nMN, l.this.nLm, f, l.this.nLv, i, l.this.nLH.audioSampleRate, false, true, false);
        l = Util.currentTicks();
        boolean bool = l.this.nMz.yu(l.this.nMK);
        Log.i("MicroMsg.MMSightFFMpegRecorder", "mux used %sms, success: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Boolean.valueOf(bool) });
        if (!bool)
        {
          Log.e("MicroMsg.MMSightFFMpegRecorder", "mux failed!");
          SightVideoJNI.releaseBigSightDataBufferLock(this.nMN);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89513);
              if (l.this.nLL != null) {
                l.this.nLL.cba();
              }
              AppMethodBeat.o(89513);
            }
          });
          Log.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegCaptureMuxError");
          h.OAn.idkeyStat(440L, 30L, 1L, false);
          AppMethodBeat.o(89517);
          return;
        }
        if (((l.this.nKe) && (l.this.nME)) || ((!l.this.nME) && (!l.this.nKe)) || ((l.this.nKe) && (Math.abs(l.this.nLz - l.this.nLK) == 0)) || (l.this.nLK == 180))
        {
          l = Util.currentTicks();
          if ((l.this.nME) || (l.this.nKe)) {
            break label903;
          }
          i = l.this.nLz;
        }
      }
      for (;;)
      {
        j = i;
        if (l.this.nLK == 180)
        {
          j = i;
          if (!l.this.nME)
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
          SightVideoJNI.tagRotateVideoVFS(l.this.nLm, l.this.nLB, j);
          Log.i("MicroMsg.MMSightFFMpegRecorder", "tagRotateVideo used %sms, cameraOrientation: %s, isLandscape: %s, deviceDegree: %s, rotateDegree: %s", new Object[] { Long.valueOf(Util.ticksToNow(l)), Integer.valueOf(l.this.nLz), Boolean.valueOf(l.this.nKe), Integer.valueOf(l.this.nLK), Integer.valueOf(j) });
          str = l.this.nLB;
        }
        try
        {
          y.O(l.this.nLB, l.this.nLm, false);
          ThreadPool.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89515);
              try
              {
                y.deleteFile(str);
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
          SightVideoJNI.releaseBigSightDataBufferLock(this.nMN);
          Log.i("MicroMsg.MMSightFFMpegRecorder", "all finish, callback: %s", new Object[] { this.callback });
          l.this.reset();
          MMHandlerThread.postToMainThread(this.callback);
          this.nMS = true;
          l.this.nMD = -1;
          l.this.nMC = -1;
          AppMethodBeat.o(89517);
          return;
        }
        catch (Exception localException2)
        {
          label903:
          Log.e("MicroMsg.MMSightFFMpegRecorder", "stop, copy file error");
          SightVideoJNI.releaseBigSightDataBufferLock(this.nMN);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(89514);
              if (l.this.nLL != null) {
                l.this.nLL.cba();
              }
              AppMethodBeat.o(89514);
            }
          });
          AppMethodBeat.o(89517);
          return;
        }
        if (l.this.nME) {
          i = l.this.nLK;
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