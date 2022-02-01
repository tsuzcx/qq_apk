package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.protocal.protobuf.acy;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.ada;
import com.tencent.mm.protocal.protobuf.adb;
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.protocal.protobuf.cnv;
import com.tencent.mm.protocal.protobuf.epk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.wxmm.IConfCallBack;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public enum q
{
  public static int EMethodGetQosPara;
  private static final String tRN;
  private int EK;
  private boolean mIsInit;
  public int mRoomType;
  public MMHandler mainHandler;
  private final MMHandler opL;
  private String peY;
  a tQW;
  private final k tQs;
  private final s tRO;
  private final l tRP;
  public final f tRQ;
  public final t tRR;
  public e tRS;
  public q.d tRT;
  private q.a tRU;
  private String tRV;
  private String tRW;
  private int tRX;
  private b<q.a> tRY;
  private b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> tRZ;
  private boolean tSA;
  private final int tSB;
  public Runnable tSC;
  private b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> tSa;
  private b<Map<String, Object>> tSb;
  private b<Map<String, Object>> tSc;
  private l.a tSd;
  private l.a tSe;
  private l.a tSf;
  private l.a tSg;
  private l.a tSh;
  private l.a tSi;
  private l.a tSj;
  private l.a tSk;
  private l.a tSl;
  private boolean tSm;
  public boolean tSn;
  public boolean tSo;
  private boolean tSp;
  private b<String> tSq;
  public long tSr;
  private boolean tSs;
  private boolean tSt;
  private int tSu;
  public h tSv;
  public boolean tSw;
  public boolean tSx;
  private boolean tSy;
  private boolean tSz;
  private int uJ;
  
  static
  {
    AppMethodBeat.i(90930);
    tRM = new q("INSTANCE");
    tSD = new q[] { tRM };
    tRN = MMApplicationContext.getApplicationId();
    EMethodGetQosPara = 25;
    AppMethodBeat.o(90930);
  }
  
  private q()
  {
    AppMethodBeat.i(90899);
    this.tRX = 0;
    this.mRoomType = 1;
    this.uJ = 480;
    this.EK = 640;
    this.tSn = false;
    this.tSo = false;
    this.tSr = -1L;
    this.tSs = false;
    this.tSt = false;
    this.tSu = 0;
    this.tSv = null;
    this.tQW = null;
    this.mainHandler = new q.1(this, Looper.getMainLooper());
    this.tSy = false;
    this.tSz = false;
    this.tSA = false;
    this.tSB = -9999;
    this.tSC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90867);
        if ((q.e(q.this) == q.d.tTF) && (!q.a(q.this)))
        {
          Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: still not join room in %d ms. directly release", new Object[] { Long.valueOf(180000L) });
          q.u(q.this);
        }
        AppMethodBeat.o(90867);
      }
    };
    this.tRO = new s();
    this.tRP = new l();
    this.tQs = new k();
    this.tRQ = new f(this.tQs);
    this.tRR = new t(this.tQs);
    this.tRS = new e(MMApplicationContext.getContext());
    this.opL = new MMHandler("openvoice_voip_worker");
    this.tRT = q.d.tTF;
    this.peY = null;
    ThreadPool.post(new q.12(this), "updateDeviceInfo");
    this.tSm = false;
    this.mIsInit = false;
    this.tSp = false;
    this.tSq = null;
    this.tSv = null;
    this.tSw = true;
    this.tSx = false;
    this.tQW = new a();
    AppMethodBeat.o(90899);
  }
  
  static void I(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90916);
    m.H(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(90916);
  }
  
  static void IH(int paramInt)
  {
    AppMethodBeat.i(90919);
    m.IE(paramInt);
    AppMethodBeat.o(90919);
  }
  
  static int U(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(202821);
    paramInt = m.T(paramArrayOfByte, paramInt);
    AppMethodBeat.o(202821);
    return paramInt;
  }
  
  static int V(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(90918);
    paramInt = m.S(paramArrayOfByte, paramInt);
    AppMethodBeat.o(90918);
    return paramInt;
  }
  
  private void a(b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> paramb)
  {
    AppMethodBeat.i(90902);
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: try trigger succ: %b %b %b", new Object[] { Boolean.valueOf(this.tSy), Boolean.valueOf(this.tSz), Boolean.valueOf(this.tSA) });
    if ((this.tSy) && (this.tSA) && (this.tSz))
    {
      int i;
      if (this.tSp)
      {
        Log.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: require exit. try exit exit again");
        a(paramb, -10086, -9, "interrupted because already cancelled or entered background");
        i = d(this.tRU);
        if (this.tSq != null)
        {
          if (i != 0) {
            break label153;
          }
          this.tSq.a(0, 0, "ok", "");
        }
        for (;;)
        {
          this.tSp = false;
          this.tSq = null;
          AppMethodBeat.o(90902);
          return;
          label153:
          this.tSq.a(-10086, -17, "exit failed", "");
        }
      }
      this.tRR.cNM();
      Object localObject = this.tRQ;
      boolean bool;
      if (((f)localObject).tQu != 2)
      {
        Log.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: error not init when start record!");
        i = 0;
        bool = this.tRQ.aeU();
        if ((i == 0) || (!bool)) {
          break label337;
        }
        j = 0;
        label230:
        p.tRD = j;
        if (i == 0) {
          break label342;
        }
        j = 0;
        label240:
        p.tRF = j;
        if (!bool) {
          break label376;
        }
      }
      label337:
      label342:
      label376:
      for (int j = 0;; j = this.tRQ.tQq.frO)
      {
        p.tRE = j;
        if ((i == 0) || (!bool)) {
          break label390;
        }
        this.tSn = true;
        a(paramb, 0, 0, "ok");
        AppMethodBeat.o(90902);
        return;
        if (((f)localObject).tQp.a(new f.2((f)localObject), ((f)localObject).mSampleRate, ((f)localObject).mChannels, ((f)localObject).tQE) <= 0)
        {
          ((f)localObject).tQy = 1;
          i = 0;
          break;
        }
        i = 1;
        break;
        j = 1;
        break label230;
        localObject = this.tRQ.tQp.tQI.tQh;
        if (localObject != null)
        {
          j = ((com.tencent.mm.plugin.voip.model.c)localObject).gxE();
          break label240;
        }
        j = 0;
        break label240;
      }
      label390:
      b(paramb);
    }
    AppMethodBeat.o(90902);
  }
  
  private void a(b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> paramb, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(90900);
    this.tSm = false;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      this.tRT = q.d.tTH;
    }
    synchronized (this.tRP)
    {
      this.tRP.b(3, this.tSi);
      this.tRP.b(4, this.tSj);
      this.tRP.b(22, this.tSk);
      this.tRP.b(23, this.tSl);
      this.tSi = null;
      this.tSj = null;
      this.tSk = null;
      this.tSl = null;
      ??? = this.tQs.tRa;
      if (paramb != null) {
        paramb.a(paramInt1, paramInt2, paramString, ???);
      }
      if (this.tSb != null) {
        this.tSb.a(0, 0, "", this.tQs.cNA());
      }
      AppMethodBeat.o(90900);
      return;
    }
  }
  
  static boolean a(com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b paramb)
  {
    AppMethodBeat.i(90915);
    if (m.IC(paramb.tQm) > 0)
    {
      AppMethodBeat.o(90915);
      return true;
    }
    AppMethodBeat.o(90915);
    return false;
  }
  
  private void ap(Runnable paramRunnable)
  {
    AppMethodBeat.i(90906);
    this.opL.postDelayed(paramRunnable, 180000L);
    AppMethodBeat.o(90906);
  }
  
  private int asu(String paramString)
  {
    AppMethodBeat.i(90901);
    IConfCallBack localIConfCallBack = this.tRP.lW(true);
    int i = m.a(this.tRV, this.peY, paramString, this.tRX, this.uJ, this.EK, localIConfCallBack);
    this.tSg = new l.a()
    {
      public final boolean cNB()
      {
        return true;
      }
    };
    this.tRP.a(26, this.tSg);
    AppMethodBeat.o(90901);
    return i;
  }
  
  private void b(b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> paramb)
  {
    AppMethodBeat.i(90903);
    a(paramb, -10086, -7, "start audio device failed");
    d(q.a.tTy);
    AppMethodBeat.o(90903);
  }
  
  private static int c(q.a parama)
  {
    AppMethodBeat.i(90908);
    switch (q.22.pip[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(90908);
      return 0;
    case 1: 
    case 2: 
    case 3: 
      AppMethodBeat.o(90908);
      return 0;
    case 4: 
      AppMethodBeat.o(90908);
      return 1;
    case 5: 
      AppMethodBeat.o(90908);
      return 6;
    case 6: 
      AppMethodBeat.o(90908);
      return 8;
    }
    AppMethodBeat.o(90908);
    return 7;
  }
  
  private void cNE()
  {
    this.tSy = false;
    this.tSz = false;
    this.tSA = false;
  }
  
  /* Error */
  private void cNF()
  {
    // Byte code:
    //   0: ldc_w 887
    //   3: invokestatic 170	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 266	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:tQs	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   10: invokevirtual 550	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:cNz	()V
    //   13: aload_0
    //   14: getfield 266	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:tQs	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   17: astore_2
    //   18: aload_2
    //   19: getfield 566	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:tRe	Ljava/util/ArrayList;
    //   22: astore_1
    //   23: aload_1
    //   24: monitorenter
    //   25: aload_2
    //   26: getfield 566	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:tRe	Ljava/util/ArrayList;
    //   29: invokevirtual 890	java/util/ArrayList:clear	()V
    //   32: aload_1
    //   33: monitorexit
    //   34: aload_2
    //   35: getfield 592	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:tRf	Lcom/tencent/e/i/d;
    //   38: ifnull +14 -> 52
    //   41: aload_2
    //   42: getfield 592	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:tRf	Lcom/tencent/e/i/d;
    //   45: iconst_0
    //   46: invokeinterface 896 2 0
    //   51: pop
    //   52: aload_0
    //   53: getfield 273	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:tRQ	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/f;
    //   56: astore_2
    //   57: aload_2
    //   58: getfield 444	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:tQp	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/g;
    //   61: ifnull +137 -> 198
    //   64: aload_2
    //   65: getfield 444	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:tQp	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/g;
    //   68: astore_3
    //   69: aload_3
    //   70: getfield 900	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:tQH	Ljava/lang/Object;
    //   73: astore_1
    //   74: aload_1
    //   75: monitorenter
    //   76: ldc_w 902
    //   79: ldc_w 904
    //   82: iconst_2
    //   83: anewarray 377	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: aload_3
    //   89: getfield 907	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:isStart	Z
    //   92: invokestatic 383	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   95: aastore
    //   96: dup
    //   97: iconst_1
    //   98: aload_3
    //   99: invokevirtual 910	java/lang/Object:hashCode	()I
    //   102: invokestatic 915	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: aastore
    //   106: invokestatic 388	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: aload_3
    //   110: getfield 907	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:isStart	Z
    //   113: ifeq +83 -> 196
    //   116: aload_3
    //   117: getfield 470	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:tQI	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/b/a;
    //   120: astore 4
    //   122: aload 4
    //   124: getfield 476	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:tQh	Lcom/tencent/mm/plugin/voip/model/c;
    //   127: astore 5
    //   129: aload 5
    //   131: ifnull +21 -> 152
    //   134: aload 5
    //   136: invokevirtual 918	com/tencent/mm/plugin/voip/model/c:gxD	()I
    //   139: pop
    //   140: aload 5
    //   142: invokevirtual 921	com/tencent/mm/plugin/voip/model/c:gxA	()I
    //   145: pop
    //   146: aload 4
    //   148: aconst_null
    //   149: putfield 476	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:tQh	Lcom/tencent/mm/plugin/voip/model/c;
    //   152: aload_3
    //   153: getfield 925	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:tQJ	Lcom/tencent/mm/compatible/util/f$a;
    //   156: invokestatic 930	android/os/SystemClock:elapsedRealtime	()J
    //   159: putfield 935	com/tencent/mm/compatible/util/f$a:jvB	J
    //   162: ldc_w 902
    //   165: new 779	java/lang/StringBuilder
    //   168: dup
    //   169: ldc_w 937
    //   172: invokespecial 782	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   175: aload_3
    //   176: getfield 925	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:tQJ	Lcom/tencent/mm/compatible/util/f$a;
    //   179: invokevirtual 940	com/tencent/mm/compatible/util/f$a:avE	()J
    //   182: invokevirtual 943	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   185: invokevirtual 789	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 536	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload_3
    //   192: iconst_0
    //   193: putfield 907	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:isStart	Z
    //   196: aload_1
    //   197: monitorexit
    //   198: aload_2
    //   199: iconst_0
    //   200: putfield 946	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:tQC	Z
    //   203: aload_2
    //   204: getfield 486	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:tQq	Lcom/tencent/mm/audio/b/c;
    //   207: ifnull +25 -> 232
    //   210: aload_2
    //   211: getfield 486	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:tQq	Lcom/tencent/mm/audio/b/c;
    //   214: invokevirtual 949	com/tencent/mm/audio/b/c:aeJ	()Z
    //   217: pop
    //   218: aload_2
    //   219: aconst_null
    //   220: putfield 486	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:tQq	Lcom/tencent/mm/audio/b/c;
    //   223: ldc_w 421
    //   226: ldc_w 951
    //   229: invokestatic 536	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: getstatic 178	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:tRM	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/q;
    //   235: iconst_0
    //   236: invokevirtual 955	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:lY	(Z)V
    //   239: aload_2
    //   240: getstatic 958	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:tQt	I
    //   243: putfield 419	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:tQu	I
    //   246: aload_2
    //   247: getfield 444	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:tQp	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/g;
    //   250: getfield 470	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:tQI	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/b/a;
    //   253: astore_1
    //   254: aload_1
    //   255: invokevirtual 961	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:crg	()V
    //   258: aload_1
    //   259: ldc_w 963
    //   262: invokevirtual 966	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:anT	(Ljava/lang/String;)V
    //   265: aload_1
    //   266: getfield 970	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:mlj	Lcom/tencent/mm/compatible/util/b;
    //   269: invokevirtual 975	com/tencent/mm/compatible/util/b:avz	()Z
    //   272: pop
    //   273: invokestatic 980	com/tencent/mm/plugin/audio/c/a:cru	()V
    //   276: invokestatic 983	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:unInit	()V
    //   279: aload_0
    //   280: getfield 278	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:tRR	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/t;
    //   283: astore_1
    //   284: ldc_w 985
    //   287: ldc_w 987
    //   290: invokestatic 426	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: aload_1
    //   294: monitorenter
    //   295: aload_1
    //   296: getfield 990	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/t:mStarted	Z
    //   299: ifne +133 -> 432
    //   302: aload_1
    //   303: monitorexit
    //   304: aload_0
    //   305: getfield 261	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:tRP	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l;
    //   308: astore_1
    //   309: aload_1
    //   310: monitorenter
    //   311: aload_0
    //   312: getfield 261	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:tRP	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l;
    //   315: bipush 24
    //   317: aload_0
    //   318: getfield 559	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:tSd	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;
    //   321: invokevirtual 504	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/l:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;)V
    //   324: aload_0
    //   325: getfield 261	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:tRP	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l;
    //   328: bipush 25
    //   330: aload_0
    //   331: getfield 562	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:tSe	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;
    //   334: invokevirtual 504	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/l:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;)V
    //   337: aload_0
    //   338: getfield 261	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:tRP	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l;
    //   341: bipush 20
    //   343: aload_0
    //   344: getfield 553	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:tSf	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;
    //   347: invokevirtual 504	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/l:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;)V
    //   350: aload_0
    //   351: getfield 261	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:tRP	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l;
    //   354: bipush 21
    //   356: aload_0
    //   357: getfield 556	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:tSh	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;
    //   360: invokevirtual 504	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/l:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;)V
    //   363: aload_0
    //   364: getfield 261	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:tRP	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l;
    //   367: bipush 26
    //   369: aload_0
    //   370: getfield 864	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:tSg	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;
    //   373: invokevirtual 504	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/l:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;)V
    //   376: aload_0
    //   377: aconst_null
    //   378: putfield 559	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:tSd	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;
    //   381: aload_0
    //   382: aconst_null
    //   383: putfield 562	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:tSe	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;
    //   386: aload_0
    //   387: aconst_null
    //   388: putfield 553	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:tSf	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;
    //   391: aload_0
    //   392: aconst_null
    //   393: putfield 556	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:tSh	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;
    //   396: aload_0
    //   397: aconst_null
    //   398: putfield 864	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:tSg	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;
    //   401: aload_1
    //   402: monitorexit
    //   403: ldc_w 887
    //   406: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   409: return
    //   410: astore_2
    //   411: aload_1
    //   412: monitorexit
    //   413: ldc_w 887
    //   416: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   419: aload_2
    //   420: athrow
    //   421: astore_2
    //   422: aload_1
    //   423: monitorexit
    //   424: ldc_w 887
    //   427: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   430: aload_2
    //   431: athrow
    //   432: aload_1
    //   433: iconst_0
    //   434: putfield 990	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/t:mStarted	Z
    //   437: aload_1
    //   438: monitorexit
    //   439: aload_1
    //   440: getfield 994	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/t:tTW	Ljava/util/Timer;
    //   443: ifnull +15 -> 458
    //   446: aload_1
    //   447: getfield 994	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/t:tTW	Ljava/util/Timer;
    //   450: invokevirtual 998	java/util/Timer:cancel	()V
    //   453: aload_1
    //   454: aconst_null
    //   455: putfield 994	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/t:tTW	Ljava/util/Timer;
    //   458: aload_1
    //   459: getfield 1001	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/t:tTX	Ljava/util/Timer;
    //   462: ifnull +15 -> 477
    //   465: aload_1
    //   466: getfield 1001	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/t:tTX	Ljava/util/Timer;
    //   469: invokevirtual 998	java/util/Timer:cancel	()V
    //   472: aload_1
    //   473: aconst_null
    //   474: putfield 1001	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/t:tTX	Ljava/util/Timer;
    //   477: aload_1
    //   478: getfield 1004	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/t:tUa	Ljava/util/Map;
    //   481: astore_2
    //   482: aload_2
    //   483: monitorenter
    //   484: aload_1
    //   485: getfield 1004	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/t:tUa	Ljava/util/Map;
    //   488: invokeinterface 1005 1 0
    //   493: aload_2
    //   494: monitorexit
    //   495: goto -191 -> 304
    //   498: astore_1
    //   499: aload_2
    //   500: monitorexit
    //   501: ldc_w 887
    //   504: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   507: aload_1
    //   508: athrow
    //   509: astore_1
    //   510: ldc_w 985
    //   513: new 779	java/lang/StringBuilder
    //   516: dup
    //   517: ldc_w 1007
    //   520: invokespecial 782	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   523: aload_1
    //   524: invokevirtual 1008	java/lang/Exception:toString	()Ljava/lang/String;
    //   527: invokevirtual 1011	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: invokevirtual 789	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 426	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: goto -232 -> 304
    //   539: astore_2
    //   540: aload_1
    //   541: monitorexit
    //   542: ldc_w 887
    //   545: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   548: aload_2
    //   549: athrow
    //   550: astore_2
    //   551: aload_1
    //   552: monitorexit
    //   553: ldc_w 887
    //   556: invokestatic 193	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   559: aload_2
    //   560: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	561	0	this	q
    //   498	10	1	localObject2	Object
    //   509	43	1	localException	java.lang.Exception
    //   17	230	2	localObject3	Object
    //   410	10	2	localObject4	Object
    //   421	10	2	localObject5	Object
    //   539	10	2	localObject6	Object
    //   550	10	2	localObject7	Object
    //   68	124	3	localg	g
    //   120	27	4	locala	com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a
    //   127	14	5	localc	com.tencent.mm.plugin.voip.model.c
    // Exception table:
    //   from	to	target	type
    //   25	34	410	finally
    //   76	129	421	finally
    //   134	152	421	finally
    //   152	196	421	finally
    //   196	198	421	finally
    //   484	495	498	finally
    //   293	295	509	java/lang/Exception
    //   439	458	509	java/lang/Exception
    //   458	477	509	java/lang/Exception
    //   477	484	509	java/lang/Exception
    //   499	509	509	java/lang/Exception
    //   540	550	509	java/lang/Exception
    //   295	304	539	finally
    //   432	439	539	finally
    //   311	403	550	finally
  }
  
  private void cNG()
  {
    AppMethodBeat.i(90910);
    ap(this.tSC);
    AppMethodBeat.o(90910);
  }
  
  private boolean cNL()
  {
    AppMethodBeat.i(202825);
    if (this.tRS != null)
    {
      boolean bool = this.tRS.adI();
      AppMethodBeat.o(202825);
      return bool;
    }
    AppMethodBeat.o(202825);
    return true;
  }
  
  private int d(q.a parama)
  {
    AppMethodBeat.i(90909);
    this.tSn = false;
    MultiProcessMMKV.getMMKV(this.peY + "_wxa_voip").putBoolean("isCameraStart", false);
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "appId:%s, exitConferenceSync set isCameraStart false", new Object[] { this.peY });
    if (!cNL())
    {
      Log.i("MicroMsg.OpenVoice.OpenVoiceService", "exitConferenceSync, stop ring");
      stopRing();
    }
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger exit with reason: %s", new Object[] { parama });
    this.tRU = parama;
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "exitConferenceSync: release avcCodec: " + this.tSv);
    this.tSv = null;
    if (this.tSm)
    {
      Log.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: current joining room. waiting for exiting after joining");
      this.tSp = true;
      AppMethodBeat.o(90909);
      return -9999;
    }
    if (this.tRT == q.d.tTF)
    {
      Log.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room! maybe is joining room");
      AppMethodBeat.o(90909);
      return 0;
    }
    int i = m.ID(c(parama));
    cNG();
    AppMethodBeat.o(90909);
    return i;
  }
  
  public static int f(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(90917);
    paramInt1 = m.e(paramInt1, paramArrayOfByte, paramInt2);
    AppMethodBeat.o(90917);
    return paramInt1;
  }
  
  private int lX(boolean paramBoolean)
  {
    AppMethodBeat.i(90911);
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: reset sync, sdkReset %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.tRO.asv(this.peY);
    p.tRD = 0;
    p.tRE = 0;
    p.tRF = 0;
    p.tRG = 0;
    p.tRH = 0;
    p.tRI = 0;
    p.tRJ = 0;
    p.tRK = 0;
    p.tRL = 0;
    this.peY = null;
    this.tRV = null;
    cNF();
    this.mIsInit = false;
    n localn = n.tRo;
    Log.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: stop listen to network change");
    localn.IF(1);
    if (paramBoolean)
    {
      int i = m.cND();
      AppMethodBeat.o(90911);
      return i;
    }
    this.tRP.lW(false);
    this.mainHandler.sendEmptyMessage(272);
    AppMethodBeat.o(90911);
    return 0;
  }
  
  public final void a(final b<String> paramb, final q.a parama)
  {
    AppMethodBeat.i(90907);
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: user triggered exit conference");
    am(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90866);
        int i = q.a(q.this, parama);
        if (i == -9999)
        {
          Log.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: pending exit. waiting for next time");
          q.b(q.this, paramb);
          AppMethodBeat.o(90866);
          return;
        }
        if (paramb != null)
        {
          if (i == 0)
          {
            paramb.a(0, 0, "", "");
            AppMethodBeat.o(90866);
            return;
          }
          paramb.a(-10086, -17, "exit failed", "");
        }
        AppMethodBeat.o(90866);
      }
    });
    AppMethodBeat.o(90907);
  }
  
  public final void a(final boolean paramBoolean, final b<String> paramb)
  {
    AppMethodBeat.i(90912);
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set mute play: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    am(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184480);
        if (q.e(q.this) != q.d.tTH)
        {
          Log.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
          if (paramb != null)
          {
            paramb.a(-10086, -1001, "not in room", "");
            AppMethodBeat.o(184480);
            return;
          }
        }
        q.l(q.this).tQC = paramBoolean;
        if (paramb != null) {
          paramb.a(0, 0, "ok", "");
        }
        AppMethodBeat.o(184480);
      }
    });
    AppMethodBeat.o(90912);
  }
  
  public final void am(Runnable paramRunnable)
  {
    AppMethodBeat.i(90905);
    if (this.opL.getSerialTag().equals(com.tencent.e.j.a.iqg()))
    {
      paramRunnable.run();
      AppMethodBeat.o(90905);
      return;
    }
    this.opL.post(paramRunnable);
    AppMethodBeat.o(90905);
  }
  
  public final void b(final boolean paramBoolean, final b<String> paramb)
  {
    AppMethodBeat.i(90913);
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set mute record: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    am(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184481);
        if (q.e(q.this) != q.d.tTH)
        {
          Log.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
          if (paramb != null)
          {
            paramb.a(-10086, -1001, "not in room", "");
            AppMethodBeat.o(184481);
            return;
          }
        }
        f localf = q.l(q.this);
        boolean bool = paramBoolean;
        localf.tQD = bool;
        q localq = q.tRM;
        String str;
        int i;
        if (bool)
        {
          str = "mute";
          Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: onMicMute %s", new Object[] { str });
          localq.am(new q.20(localq, bool));
          if (localf.tQq == null) {
            break label176;
          }
          localf.tQq.dE(bool);
          i = 1;
        }
        for (;;)
        {
          if (paramb != null)
          {
            if (i != 0)
            {
              paramb.a(0, 0, "ok", "");
              AppMethodBeat.o(184481);
              return;
              str = "unMute";
              break;
              label176:
              i = 0;
              continue;
            }
            paramb.a(-10086, -15, "set mute failed", "");
          }
        }
        AppMethodBeat.o(184481);
      }
    });
    AppMethodBeat.o(90913);
  }
  
  public final void c(final boolean paramBoolean, final b<String> paramb)
  {
    AppMethodBeat.i(202816);
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set handsFree: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    am(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203396);
        if (q.e(q.this) != q.d.tTH)
        {
          Log.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
          if (paramb != null)
          {
            paramb.a(-10086, -1001, "not in room", "");
            AppMethodBeat.o(203396);
            return;
          }
        }
        Object localObject = q.l(q.this);
        boolean bool = paramBoolean;
        localObject = ((f)localObject).tQp;
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker beSpeakerphoneOn: ".concat(String.valueOf(bool)));
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker ignoreBluetooth: false");
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isAvailable: " + ((g)localObject).tQI.isAvailable());
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isSpeakerSetFailed: " + ((g)localObject).tQI.tQg);
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isBluetoothScoAvailable: " + com.tencent.mm.plugin.audio.d.b.a(((g)localObject).tQI.audioManager));
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isBluetoothScoOn: " + ((g)localObject).tQI.crm());
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isHeadsetPlugged: " + ((g)localObject).tQI.crh());
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isSpeakerphoneOn: " + ((g)localObject).tQI.crl());
        if ((bool) && ((((g)localObject).tQI.crm()) || (((g)localObject).tQI.crh()))) {
          bool = false;
        }
        while (paramb != null) {
          if (bool)
          {
            paramb.a(0, 0, "ok", "");
            AppMethodBeat.o(203396);
            return;
            bool = ((g)localObject).tQI.kF(bool);
          }
          else
          {
            paramb.a(-10086, -15, "set handsFree failed", "");
          }
        }
        AppMethodBeat.o(203396);
      }
    });
    AppMethodBeat.o(202816);
  }
  
  public final void cNH()
  {
    AppMethodBeat.i(202817);
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "onCameraStop");
    am(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203039);
        if (!q.w(q.this))
        {
          AppMethodBeat.o(203039);
          return;
        }
        q.b(q.this, false);
        MultiProcessMMKV.getMMKV(q.d(q.this) + "_wxa_voip").putBoolean("isCameraStart", q.w(q.this));
        m.b(q.x(q.this), q.w(q.this), q.y(q.this));
        AppMethodBeat.o(203039);
      }
    });
    AppMethodBeat.o(202817);
  }
  
  public final int cNI()
  {
    return this.mRoomType;
  }
  
  public final t cNJ()
  {
    return this.tRR;
  }
  
  public final boolean cNK()
  {
    return this.tSn;
  }
  
  final void d(final byte[] paramArrayOfByte, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(202820);
    am(new Runnable()
    {
      public final void run()
      {
        int j = 1;
        AppMethodBeat.i(203181);
        if (!q.z(q.this))
        {
          AppMethodBeat.o(203181);
          return;
        }
        Object localObject1;
        Object localObject2;
        Object localObject3;
        int i;
        if (q.this.tSw)
        {
          localObject1 = q.this;
          if (m.e(q.EMethodGetQosPara, ((q)localObject1).tQW.s2p, ((q)localObject1).tQW.s2p.length) >= 0)
          {
            localObject2 = ((q)localObject1).tQW;
            localObject3 = ByteBuffer.wrap(((a)localObject2).s2p);
            ((ByteBuffer)localObject3).order(ByteOrder.LITTLE_ENDIAN);
            ((a)localObject2).iKbps = ((ByteBuffer)localObject3).getShort();
            ((a)localObject2).cFps = ((ByteBuffer)localObject3).get();
            ((a)localObject2).cIPeriod = ((ByteBuffer)localObject3).get();
            ((a)localObject2).cResolution = ((ByteBuffer)localObject3).get();
            ((a)localObject2).tQn = ((ByteBuffer)localObject3).get();
            ((a)localObject2).tQo = ((ByteBuffer)localObject3).get();
            ((a)localObject2).cSkipFlag = ((ByteBuffer)localObject3).get();
            ((a)localObject2).cIReqFlag = ((ByteBuffer)localObject3).get();
            ((a)localObject2).cRsvd1 = ((ByteBuffer)localObject3).get();
            localObject2 = ((q)localObject1).tQW;
            Log.d("OpenVoice[HWEnc]", "raw S2P:" + ((a)localObject2).s2p);
            Log.d("OpenVoice[HWEnc]", "-S2P- iKbps:" + ((a)localObject2).iKbps + ", fps:" + ((a)localObject2).cFps + ", IP:" + ((a)localObject2).cIPeriod + ", Reso:" + ((a)localObject2).cResolution + ", Codec:" + ((a)localObject2).tQn + ", HWEnable:" + ((a)localObject2).tQo + ", Skip:" + ((a)localObject2).cSkipFlag + ", IReq:" + ((a)localObject2).cIReqFlag + ", Rsvd1:" + ((a)localObject2).cRsvd1);
          }
          if (((q)localObject1).tSw) {
            if (8 == ((q)localObject1).tQW.tQn)
            {
              ((q)localObject1).tSx = true;
              if (((q)localObject1).tQW.tQo == 0)
              {
                ((q)localObject1).tSw = false;
                ((q)localObject1).tSx = false;
              }
              if ((1 != ((q)localObject1).tQW.cSkipFlag) && (((q)localObject1).tSw) && (((q)localObject1).tSx)) {
                break label513;
              }
              i = -1;
              if (i >= 0) {
                break label892;
              }
              i = j;
            }
          }
        }
        for (;;)
        {
          if (q.this.tSx)
          {
            if ((q.this.tSv == null) || (i != 0)) {
              break label917;
            }
            i = q.this.tSv.b(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
            if (i < 0)
            {
              Log.e("MicroMsg.OpenVoice.OpenVoiceService", "StopHWEnc!! hw encoder error: ".concat(String.valueOf(i)));
              q.this.tSx = false;
            }
            AppMethodBeat.o(203181);
            return;
            ((q)localObject1).tSx = false;
            break;
            ((q)localObject1).tSx = false;
            break;
            label513:
            if ((((q)localObject1).tSw) && (((q)localObject1).tSv == null))
            {
              ((q)localObject1).tSv = new h(((q)localObject1).tQW.cFps, ((q)localObject1).tQW.iKbps, "video/avc");
              Log.i("MicroMsg.OpenVoice.OpenVoiceService", "create avcCodec: " + ((q)localObject1).tSv);
            }
            for (;;)
            {
              i = 0;
              break;
              localObject2 = ((q)localObject1).tSv;
              localObject1 = ((q)localObject1).tQW;
              if ((((h)localObject2).tQW != null) && (((h)localObject2).tQL != null))
              {
                localObject3 = ((h)localObject2).tQW;
                ((a)localObject3).iKbps = ((a)localObject1).iKbps;
                ((a)localObject3).cFps = ((a)localObject1).cFps;
                ((a)localObject3).cIPeriod = ((a)localObject1).cIPeriod;
                ((a)localObject3).cResolution = ((a)localObject1).cResolution;
                ((a)localObject3).tQn = ((a)localObject1).tQn;
                ((a)localObject3).tQo = ((a)localObject1).tQo;
                ((a)localObject3).cSkipFlag = ((a)localObject1).cSkipFlag;
                ((a)localObject3).cIReqFlag = ((a)localObject1).cIReqFlag;
                ((a)localObject3).cRsvd1 = ((a)localObject1).cRsvd1;
                i = (int)(((h)localObject2).tQW.iKbps * 1.1D);
                if (((h)localObject2).m_br_kbps != i)
                {
                  ((h)localObject2).SetBitRate(i);
                  Log.i("OpenVoice[HWEnc]", "steve[QoS]: Update BR! frameID: " + h.frameID + ", new_br: " + ((h)localObject2).m_br_kbps + ", tuneBR:" + i);
                  ((h)localObject2).m_br_kbps = i;
                }
                if ((1 == ((h)localObject2).tQW.cIReqFlag) && (h.frameID > 0))
                {
                  if (((h)localObject2).tQL != null)
                  {
                    Log.v("OpenVoice[HWEnc]", "steve: Sync frame request soon!");
                    localObject1 = new Bundle();
                    ((Bundle)localObject1).putInt("request-sync", 0);
                    ((h)localObject2).tQL.setParameters((Bundle)localObject1);
                  }
                  Log.i("OpenVoice[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + h.frameID);
                }
                if (((h)localObject2).tQW.cFps != ((h)localObject2).m_framerate) {
                  ((h)localObject2).m_framerate = ((h)localObject2).tQW.cFps;
                }
              }
            }
            label892:
            i = 0;
            continue;
          }
          m.c(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
          label917:
          AppMethodBeat.o(203181);
          return;
          i = 0;
        }
      }
    });
    AppMethodBeat.o(202820);
  }
  
  public final void lY(final boolean paramBoolean)
  {
    AppMethodBeat.i(202818);
    if (paramBoolean) {}
    for (String str = "yes";; str = "no")
    {
      Log.i("MicroMsg.OpenVoice.OpenVoiceService", "onMicSwitch %s", new Object[] { str });
      am(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(203718);
          if (paramBoolean == q.x(q.this))
          {
            AppMethodBeat.o(203718);
            return;
          }
          q.c(q.this, paramBoolean);
          m.b(q.x(q.this), q.w(q.this), q.y(q.this));
          AppMethodBeat.o(203718);
        }
      });
      AppMethodBeat.o(202818);
      return;
    }
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(202822);
    if (this.tRS != null) {
      this.tRS.stop();
    }
    AppMethodBeat.o(202822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q
 * JD-Core Version:    0.7.0.1
 */