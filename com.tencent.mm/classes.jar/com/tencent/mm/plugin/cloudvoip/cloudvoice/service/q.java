package com.tencent.mm.plugin.cloudvoip.cloudvoice.service;

import android.media.AudioManager;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.protocal.protobuf.afg;
import com.tencent.mm.protocal.protobuf.afh;
import com.tencent.mm.protocal.protobuf.afi;
import com.tencent.mm.protocal.protobuf.afj;
import com.tencent.mm.protocal.protobuf.afp;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.protocal.protobuf.akg;
import com.tencent.mm.protocal.protobuf.den;
import com.tencent.mm.protocal.protobuf.fkj;
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
  private static final String wVd;
  private int bkR;
  private boolean mIsInit;
  public int mRoomType;
  public MMHandler mainHandler;
  private final MMHandler rtv;
  private String skr;
  private boolean tiH;
  private boolean tiI;
  private int vF;
  private final k wTI;
  a wUm;
  private l.a wVA;
  private l.a wVB;
  private OpenVoiceVoIPInterruptListener wVC;
  private boolean wVD;
  public boolean wVE;
  public boolean wVF;
  private boolean wVG;
  private b<String> wVH;
  public long wVI;
  private boolean wVJ;
  private boolean wVK;
  private int wVL;
  public h wVM;
  public boolean wVN;
  public boolean wVO;
  private boolean wVP;
  private boolean wVQ;
  private boolean wVR;
  private final int wVS;
  public Runnable wVT;
  private OpenVoiceVoIPInterruptListener.b wVU;
  private final s wVe;
  private final l wVf;
  public final f wVg;
  public final t wVh;
  public e wVi;
  public d wVj;
  private a wVk;
  private String wVl;
  private String wVm;
  private int wVn;
  private b<a> wVo;
  private b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> wVp;
  private b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> wVq;
  private b<Map<String, Object>> wVr;
  private b<Map<String, Object>> wVs;
  private l.a wVt;
  private l.a wVu;
  private l.a wVv;
  private l.a wVw;
  private l.a wVx;
  private l.a wVy;
  private l.a wVz;
  
  static
  {
    AppMethodBeat.i(90930);
    wVc = new q("INSTANCE");
    wVV = new q[] { wVc };
    wVd = MMApplicationContext.getApplicationId();
    EMethodGetQosPara = 25;
    AppMethodBeat.o(90930);
  }
  
  private q()
  {
    AppMethodBeat.i(90899);
    this.wVn = 0;
    this.mRoomType = 1;
    this.vF = 480;
    this.bkR = 640;
    this.wVE = false;
    this.wVF = false;
    this.wVI = -1L;
    this.wVJ = false;
    this.wVK = false;
    this.wVL = 0;
    this.wVM = null;
    this.wUm = null;
    this.mainHandler = new q.1(this, Looper.getMainLooper());
    this.wVP = false;
    this.wVQ = false;
    this.wVR = false;
    this.wVS = -9999;
    this.wVT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90867);
        if ((q.e(q.this) == q.d.wWW) && (!q.a(q.this)))
        {
          Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: still not join room in %d ms. directly release", new Object[] { Long.valueOf(180000L) });
          q.u(q.this);
        }
        AppMethodBeat.o(90867);
      }
    };
    this.tiH = false;
    this.tiI = false;
    this.wVU = new OpenVoiceVoIPInterruptListener.b()
    {
      public final void cBF()
      {
        AppMethodBeat.i(268314);
        if (!q.A(q.this))
        {
          q.B(q.this);
          AppMethodBeat.o(268314);
          return;
        }
        Log.i("MicroMsg.OpenVoice.OpenVoiceService", "is interrupting");
        AppMethodBeat.o(268314);
      }
      
      public final void cBG()
      {
        AppMethodBeat.i(268318);
        if (q.A(q.this))
        {
          q.C(q.this);
          AppMethodBeat.o(268318);
          return;
        }
        Log.i("MicroMsg.OpenVoice.OpenVoiceService", "not call onInterruptionEnd");
        AppMethodBeat.o(268318);
      }
    };
    this.wVe = new s();
    this.wVf = new l();
    this.wTI = new k();
    this.wVg = new f(this.wTI);
    this.wVh = new t(this.wTI);
    this.wVi = new e(MMApplicationContext.getContext());
    this.rtv = new MMHandler("openvoice_voip_worker");
    this.wVj = d.wWW;
    this.skr = null;
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184479);
        Object localObject = (Bundle)j.a(q.wVd, null, q.b.class);
        if (localObject != null)
        {
          localObject = ((Bundle)localObject).getString("device_info", "");
          Log.v("MicroMsg.OpenVoice.OpenVoiceService", "hy: updatad device info %s", new Object[] { localObject });
          af.Ds((String)localObject);
          AppMethodBeat.o(184479);
          return;
        }
        Log.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: can not get device info from mm");
        AppMethodBeat.o(184479);
      }
    }, "updateDeviceInfo");
    this.wVD = false;
    this.mIsInit = false;
    this.wVG = false;
    this.wVH = null;
    this.wVM = null;
    this.wVN = true;
    this.wVO = false;
    this.wUm = new a();
    this.wVC = new OpenVoiceVoIPInterruptListener();
    AppMethodBeat.o(90899);
  }
  
  static void G(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90916);
    m.F(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(90916);
  }
  
  static void Jk(int paramInt)
  {
    AppMethodBeat.i(90919);
    m.Jh(paramInt);
    AppMethodBeat.o(90919);
  }
  
  static int S(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(268350);
    paramInt = m.R(paramArrayOfByte, paramInt);
    AppMethodBeat.o(268350);
    return paramInt;
  }
  
  static int T(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(90918);
    paramInt = m.Q(paramArrayOfByte, paramInt);
    AppMethodBeat.o(90918);
    return paramInt;
  }
  
  private void a(b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> paramb)
  {
    AppMethodBeat.i(90902);
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: try trigger succ: %b %b %b", new Object[] { Boolean.valueOf(this.wVP), Boolean.valueOf(this.wVQ), Boolean.valueOf(this.wVR) });
    if ((this.wVP) && (this.wVR) && (this.wVQ))
    {
      int i;
      if (this.wVG)
      {
        Log.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: require exit. try exit exit again");
        a(paramb, -10086, -9, "interrupted because already cancelled or entered background");
        i = d(this.wVk);
        if (this.wVH != null)
        {
          if (i != 0) {
            break label153;
          }
          this.wVH.a(0, 0, "ok", "");
        }
        for (;;)
        {
          this.wVG = false;
          this.wVH = null;
          AppMethodBeat.o(90902);
          return;
          label153:
          this.wVH.a(-10086, -17, "exit failed", "");
        }
      }
      this.wVh.drq();
      Object localObject = this.wVg;
      int j;
      if (((f)localObject).wTK != 2)
      {
        Log.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: error not init when start record!");
        i = 0;
        boolean bool = this.wVg.aGR();
        if ((i == 0) || (!bool)) {
          break label397;
        }
        j = 0;
        label230:
        p.wUT = j;
        if (i == 0) {
          break label402;
        }
        j = 0;
        label240:
        p.wUV = j;
        if (!bool) {
          break label436;
        }
        j = 0;
        label251:
        p.wUU = j;
        if ((i == 0) || (!bool)) {
          break label496;
        }
        this.wVE = true;
        a(paramb, 0, 0, "ok");
        if (!this.tiH)
        {
          this.tiH = true;
          if (this.wVC != null)
          {
            this.wVC.wXG = this.wVU;
            paramb = this.wVC;
            if (paramb.wXG != null) {
              break label450;
            }
            Log.e("MicroMsg.OpenVoice.OpenVoiceVoIPInterruptListener", "callback is invalid");
          }
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.OpenVoice.OpenVoiceService", "registerInterruptCallback");
        AppMethodBeat.o(90902);
        return;
        if (((f)localObject).wTF.a(new f.2((f)localObject), ((f)localObject).mSampleRate, ((f)localObject).mChannels, ((f)localObject).wTU) <= 0)
        {
          ((f)localObject).wTO = 1;
          i = 0;
          break;
        }
        i = 1;
        break;
        label397:
        j = 1;
        break label230;
        label402:
        localObject = this.wVg.wTF.wTY.wTy;
        if (localObject == null)
        {
          j = 0;
          break label240;
        }
        j = ((com.tencent.mm.plugin.voip.model.c)localObject).hVG();
        break label240;
        label436:
        j = this.wVg.wTG.hwc;
        break label251;
        label450:
        if (paramb.wXH == null) {
          paramb.wXH = new OpenVoiceVoIPInterruptListener.StartInterruptEventListenTask(paramb.wXG);
        }
        paramb.isStart = true;
        Log.i("MicroMsg.OpenVoice.OpenVoiceVoIPInterruptListener", "startListenInterruptEvent");
        paramb.wXH.bQt();
      }
      label496:
      b(paramb);
    }
    AppMethodBeat.o(90902);
  }
  
  private void a(b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> paramb, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(90900);
    this.wVD = false;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      this.wVj = d.wWY;
    }
    synchronized (this.wVf)
    {
      this.wVf.b(3, this.wVy);
      this.wVf.b(4, this.wVz);
      this.wVf.b(22, this.wVA);
      this.wVf.b(23, this.wVB);
      this.wVy = null;
      this.wVz = null;
      this.wVA = null;
      this.wVB = null;
      ??? = this.wTI.wUq;
      if (paramb != null) {
        paramb.a(paramInt1, paramInt2, paramString, ???);
      }
      if (this.wVr != null) {
        this.wVr.a(0, 0, "", this.wTI.drg());
      }
      AppMethodBeat.o(90900);
      return;
    }
  }
  
  static boolean a(com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b paramb)
  {
    AppMethodBeat.i(90915);
    if (m.Jf(paramb.wTC) > 0)
    {
      AppMethodBeat.o(90915);
      return true;
    }
    AppMethodBeat.o(90915);
    return false;
  }
  
  private int alZ(String paramString)
  {
    AppMethodBeat.i(90901);
    IConfCallBack localIConfCallBack = this.wVf.nr(true);
    int i = m.a(this.wVl, this.skr, paramString, this.wVn, this.vF, this.bkR, localIConfCallBack);
    this.wVw = new l.a()
    {
      public final boolean drh()
      {
        return true;
      }
    };
    this.wVf.a(26, this.wVw);
    AppMethodBeat.o(90901);
    return i;
  }
  
  private void ax(Runnable paramRunnable)
  {
    AppMethodBeat.i(90906);
    this.rtv.postDelayed(paramRunnable, 180000L);
    AppMethodBeat.o(90906);
  }
  
  private void b(b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> paramb)
  {
    AppMethodBeat.i(90903);
    a(paramb, -10086, -7, "start audio device failed");
    d(a.wWP);
    AppMethodBeat.o(90903);
  }
  
  private static int c(a parama)
  {
    AppMethodBeat.i(90908);
    switch (25.snH[parama.ordinal()])
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
  
  private int d(a parama)
  {
    AppMethodBeat.i(90909);
    this.wVE = false;
    MultiProcessMMKV.getMMKV(this.skr + "_wxa_voip").putBoolean("isCameraStart", false);
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "appId:%s, exitConferenceSync set isCameraStart false", new Object[] { this.skr });
    if (!dro())
    {
      Log.i("MicroMsg.OpenVoice.OpenVoiceService", "exitConferenceSync, stop ring");
      stopRing();
    }
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger exit with reason: %s", new Object[] { parama });
    drp();
    this.wVk = parama;
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "exitConferenceSync: release avcCodec: " + this.wVM);
    this.wVM = null;
    if (this.wVD)
    {
      Log.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: current joining room. waiting for exiting after joining");
      this.wVG = true;
      AppMethodBeat.o(90909);
      return -9999;
    }
    if (this.wVj == d.wWW)
    {
      Log.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room! maybe is joining room");
      AppMethodBeat.o(90909);
      return 0;
    }
    int i = m.Jg(c(parama));
    drm();
    AppMethodBeat.o(90909);
    return i;
  }
  
  private void drk()
  {
    this.wVP = false;
    this.wVQ = false;
    this.wVR = false;
  }
  
  /* Error */
  private void drl()
  {
    // Byte code:
    //   0: ldc_w 1004
    //   3: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 293	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/q:wTI	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/k;
    //   10: invokevirtual 622	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/k:drf	()V
    //   13: aload_0
    //   14: getfield 293	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/q:wTI	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/k;
    //   17: astore_2
    //   18: aload_2
    //   19: getfield 638	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/k:wUu	Ljava/util/ArrayList;
    //   22: astore_1
    //   23: aload_1
    //   24: monitorenter
    //   25: aload_2
    //   26: getfield 638	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/k:wUu	Ljava/util/ArrayList;
    //   29: invokevirtual 1007	java/util/ArrayList:clear	()V
    //   32: aload_1
    //   33: monitorexit
    //   34: aload_2
    //   35: getfield 664	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/k:wUv	Lcom/tencent/threadpool/i/d;
    //   38: ifnull +14 -> 52
    //   41: aload_2
    //   42: getfield 664	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/k:wUv	Lcom/tencent/threadpool/i/d;
    //   45: iconst_0
    //   46: invokeinterface 1013 2 0
    //   51: pop
    //   52: aload_0
    //   53: getfield 300	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/q:wVg	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/f;
    //   56: astore_2
    //   57: aload_2
    //   58: getfield 501	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/f:wTF	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/g;
    //   61: ifnull +137 -> 198
    //   64: aload_2
    //   65: getfield 501	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/f:wTF	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/g;
    //   68: astore_3
    //   69: aload_3
    //   70: getfield 1017	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/g:wTX	Ljava/lang/Object;
    //   73: astore_1
    //   74: aload_1
    //   75: monitorenter
    //   76: ldc_w 1019
    //   79: ldc_w 1021
    //   82: iconst_2
    //   83: anewarray 428	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: aload_3
    //   89: getfield 1022	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/g:isStart	Z
    //   92: invokestatic 434	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   95: aastore
    //   96: dup
    //   97: iconst_1
    //   98: aload_3
    //   99: invokevirtual 1025	java/lang/Object:hashCode	()I
    //   102: invokestatic 1030	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: aastore
    //   106: invokestatic 437	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: aload_3
    //   110: getfield 1022	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/g:isStart	Z
    //   113: ifeq +83 -> 196
    //   116: aload_3
    //   117: getfield 527	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/g:wTY	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/b/a;
    //   120: astore 4
    //   122: aload 4
    //   124: getfield 533	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:wTy	Lcom/tencent/mm/plugin/voip/model/c;
    //   127: astore 5
    //   129: aload 5
    //   131: ifnull +21 -> 152
    //   134: aload 5
    //   136: invokevirtual 1033	com/tencent/mm/plugin/voip/model/c:hVF	()I
    //   139: pop
    //   140: aload 5
    //   142: invokevirtual 1036	com/tencent/mm/plugin/voip/model/c:hVC	()I
    //   145: pop
    //   146: aload 4
    //   148: aconst_null
    //   149: putfield 533	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:wTy	Lcom/tencent/mm/plugin/voip/model/c;
    //   152: aload_3
    //   153: getfield 1040	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/g:wTZ	Lcom/tencent/mm/compatible/util/f$a;
    //   156: invokestatic 1045	android/os/SystemClock:elapsedRealtime	()J
    //   159: putfield 1050	com/tencent/mm/compatible/util/f$a:lYS	J
    //   162: ldc_w 1019
    //   165: new 850	java/lang/StringBuilder
    //   168: dup
    //   169: ldc_w 1052
    //   172: invokespecial 853	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   175: aload_3
    //   176: getfield 1040	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/g:wTZ	Lcom/tencent/mm/compatible/util/f$a;
    //   179: invokevirtual 1055	com/tencent/mm/compatible/util/f$a:aPY	()J
    //   182: invokevirtual 1058	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   185: invokevirtual 860	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 373	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload_3
    //   192: iconst_0
    //   193: putfield 1022	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/g:isStart	Z
    //   196: aload_1
    //   197: monitorexit
    //   198: aload_2
    //   199: iconst_0
    //   200: putfield 1061	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/f:wTS	Z
    //   203: aload_2
    //   204: getfield 543	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/f:wTG	Lcom/tencent/mm/audio/b/c;
    //   207: ifnull +25 -> 232
    //   210: aload_2
    //   211: getfield 543	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/f:wTG	Lcom/tencent/mm/audio/b/c;
    //   214: invokevirtual 1064	com/tencent/mm/audio/b/c:aGH	()Z
    //   217: pop
    //   218: aload_2
    //   219: aconst_null
    //   220: putfield 543	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/f:wTG	Lcom/tencent/mm/audio/b/c;
    //   223: ldc_w 469
    //   226: ldc_w 1066
    //   229: invokestatic 373	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: getstatic 198	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/q:wVc	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/q;
    //   235: iconst_0
    //   236: invokevirtual 1070	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/q:nt	(Z)V
    //   239: aload_2
    //   240: getstatic 1073	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/f:wTJ	I
    //   243: putfield 467	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/f:wTK	I
    //   246: aload_2
    //   247: getfield 501	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/f:wTF	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/g;
    //   250: getfield 527	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/g:wTY	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/b/a;
    //   253: astore_1
    //   254: aload_1
    //   255: invokevirtual 1076	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:cTP	()V
    //   258: aload_1
    //   259: ldc_w 1078
    //   262: invokevirtual 1081	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:ahq	(Ljava/lang/String;)V
    //   265: aload_1
    //   266: getfield 1085	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:peV	Lcom/tencent/mm/compatible/util/b;
    //   269: invokevirtual 1090	com/tencent/mm/compatible/util/b:aPS	()Z
    //   272: pop
    //   273: invokestatic 1095	com/tencent/mm/plugin/audio/c/a:cUd	()V
    //   276: invokestatic 1098	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:unInit	()V
    //   279: aload_0
    //   280: getfield 305	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/q:wVh	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/t;
    //   283: astore_1
    //   284: ldc_w 1100
    //   287: ldc_w 1102
    //   290: invokestatic 474	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: aload_1
    //   294: monitorenter
    //   295: aload_1
    //   296: getfield 1105	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/t:mStarted	Z
    //   299: ifne +133 -> 432
    //   302: aload_1
    //   303: monitorexit
    //   304: aload_0
    //   305: getfield 288	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/q:wVf	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/l;
    //   308: astore_1
    //   309: aload_1
    //   310: monitorenter
    //   311: aload_0
    //   312: getfield 288	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/q:wVf	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/l;
    //   315: bipush 24
    //   317: aload_0
    //   318: getfield 631	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/q:wVt	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/l$a;
    //   321: invokevirtual 578	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/l:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/l$a;)V
    //   324: aload_0
    //   325: getfield 288	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/q:wVf	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/l;
    //   328: bipush 25
    //   330: aload_0
    //   331: getfield 634	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/q:wVu	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/l$a;
    //   334: invokevirtual 578	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/l:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/l$a;)V
    //   337: aload_0
    //   338: getfield 288	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/q:wVf	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/l;
    //   341: bipush 20
    //   343: aload_0
    //   344: getfield 625	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/q:wVv	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/l$a;
    //   347: invokevirtual 578	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/l:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/l$a;)V
    //   350: aload_0
    //   351: getfield 288	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/q:wVf	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/l;
    //   354: bipush 21
    //   356: aload_0
    //   357: getfield 628	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/q:wVx	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/l$a;
    //   360: invokevirtual 578	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/l:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/l$a;)V
    //   363: aload_0
    //   364: getfield 288	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/q:wVf	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/l;
    //   367: bipush 26
    //   369: aload_0
    //   370: getfield 926	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/q:wVw	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/l$a;
    //   373: invokevirtual 578	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/l:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/l$a;)V
    //   376: aload_0
    //   377: aconst_null
    //   378: putfield 631	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/q:wVt	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/l$a;
    //   381: aload_0
    //   382: aconst_null
    //   383: putfield 634	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/q:wVu	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/l$a;
    //   386: aload_0
    //   387: aconst_null
    //   388: putfield 625	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/q:wVv	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/l$a;
    //   391: aload_0
    //   392: aconst_null
    //   393: putfield 628	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/q:wVx	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/l$a;
    //   396: aload_0
    //   397: aconst_null
    //   398: putfield 926	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/q:wVw	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/l$a;
    //   401: aload_1
    //   402: monitorexit
    //   403: ldc_w 1004
    //   406: invokestatic 213	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   409: return
    //   410: astore_2
    //   411: aload_1
    //   412: monitorexit
    //   413: ldc_w 1004
    //   416: invokestatic 213	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   419: aload_2
    //   420: athrow
    //   421: astore_2
    //   422: aload_1
    //   423: monitorexit
    //   424: ldc_w 1004
    //   427: invokestatic 213	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   430: aload_2
    //   431: athrow
    //   432: aload_1
    //   433: iconst_0
    //   434: putfield 1105	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/t:mStarted	Z
    //   437: aload_1
    //   438: monitorexit
    //   439: aload_1
    //   440: getfield 1109	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/t:wXn	Ljava/util/Timer;
    //   443: ifnull +15 -> 458
    //   446: aload_1
    //   447: getfield 1109	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/t:wXn	Ljava/util/Timer;
    //   450: invokevirtual 1113	java/util/Timer:cancel	()V
    //   453: aload_1
    //   454: aconst_null
    //   455: putfield 1109	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/t:wXn	Ljava/util/Timer;
    //   458: aload_1
    //   459: getfield 1116	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/t:wXo	Ljava/util/Timer;
    //   462: ifnull +15 -> 477
    //   465: aload_1
    //   466: getfield 1116	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/t:wXo	Ljava/util/Timer;
    //   469: invokevirtual 1113	java/util/Timer:cancel	()V
    //   472: aload_1
    //   473: aconst_null
    //   474: putfield 1116	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/t:wXo	Ljava/util/Timer;
    //   477: aload_1
    //   478: getfield 1119	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/t:wXp	Ljava/util/Map;
    //   481: astore_2
    //   482: aload_2
    //   483: monitorenter
    //   484: aload_1
    //   485: getfield 1119	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/t:wXp	Ljava/util/Map;
    //   488: invokeinterface 1120 1 0
    //   493: aload_2
    //   494: monitorexit
    //   495: goto -191 -> 304
    //   498: astore_1
    //   499: aload_2
    //   500: monitorexit
    //   501: ldc_w 1004
    //   504: invokestatic 213	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   507: aload_1
    //   508: athrow
    //   509: astore_1
    //   510: ldc_w 1100
    //   513: new 850	java/lang/StringBuilder
    //   516: dup
    //   517: ldc_w 1122
    //   520: invokespecial 853	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   523: aload_1
    //   524: invokevirtual 1123	java/lang/Exception:toString	()Ljava/lang/String;
    //   527: invokevirtual 956	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: invokevirtual 860	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 474	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: goto -232 -> 304
    //   539: astore_2
    //   540: aload_1
    //   541: monitorexit
    //   542: ldc_w 1004
    //   545: invokestatic 213	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   548: aload_2
    //   549: athrow
    //   550: astore_2
    //   551: aload_1
    //   552: monitorexit
    //   553: ldc_w 1004
    //   556: invokestatic 213	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private void drm()
  {
    AppMethodBeat.i(90910);
    ax(this.wVT);
    AppMethodBeat.o(90910);
  }
  
  private boolean dro()
  {
    AppMethodBeat.i(268369);
    if (this.wVi != null)
    {
      boolean bool = this.wVi.aFG();
      AppMethodBeat.o(268369);
      return bool;
    }
    AppMethodBeat.o(268369);
    return true;
  }
  
  private void drp()
  {
    AppMethodBeat.i(268372);
    if (!this.tiH)
    {
      AppMethodBeat.o(268372);
      return;
    }
    if (this.wVC != null)
    {
      this.wVC.wXG = null;
      this.wVC.cBJ();
    }
    this.tiH = false;
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "unregisterInterruptCallback");
    AppMethodBeat.o(268372);
  }
  
  public static int e(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(90917);
    paramInt1 = m.d(paramInt1, paramArrayOfByte, paramInt2);
    AppMethodBeat.o(90917);
    return paramInt1;
  }
  
  private int ns(boolean paramBoolean)
  {
    AppMethodBeat.i(90911);
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: reset sync, sdkReset %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.wVe.ama(this.skr);
    p.wUT = 0;
    p.wUU = 0;
    p.wUV = 0;
    p.wUW = 0;
    p.wUX = 0;
    p.wUY = 0;
    p.wUZ = 0;
    p.wVa = 0;
    p.wVb = 0;
    this.skr = null;
    this.wVl = null;
    drl();
    this.mIsInit = false;
    n localn = n.wUE;
    Log.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: stop listen to network change");
    localn.Ji(1);
    if (paramBoolean)
    {
      int i = m.drj();
      AppMethodBeat.o(90911);
      return i;
    }
    this.wVf.nr(false);
    this.mainHandler.sendEmptyMessage(272);
    AppMethodBeat.o(90911);
    return 0;
  }
  
  public final void a(final b<String> paramb, final a parama)
  {
    AppMethodBeat.i(90907);
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: user triggered exit conference");
    au(new Runnable()
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
    au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184480);
        if (q.e(q.this) != q.d.wWY)
        {
          Log.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
          if (paramb != null)
          {
            paramb.a(-10086, -1001, "not in room", "");
            AppMethodBeat.o(184480);
            return;
          }
        }
        q.l(q.this).wTS = paramBoolean;
        if (paramb != null)
        {
          paramb.a(0, 0, "ok", "");
          AppMethodBeat.o(184480);
          return;
        }
        AppMethodBeat.o(184480);
      }
    });
    AppMethodBeat.o(90912);
  }
  
  public final void au(Runnable paramRunnable)
  {
    AppMethodBeat.i(90905);
    if (this.rtv.getSerialTag().equals(com.tencent.threadpool.j.a.jZB()))
    {
      paramRunnable.run();
      AppMethodBeat.o(90905);
      return;
    }
    this.rtv.post(paramRunnable);
    AppMethodBeat.o(90905);
  }
  
  public final void b(final boolean paramBoolean, final b<String> paramb)
  {
    AppMethodBeat.i(90913);
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set mute record: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184481);
        if (q.e(q.this) != q.d.wWY)
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
        localf.wTT = bool;
        q localq = q.wVc;
        String str;
        int i;
        if (bool)
        {
          str = "mute";
          Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: onMicMute %s", new Object[] { str });
          localq.au(new q.20(localq, bool));
          if (localf.wTG == null) {
            break label176;
          }
          localf.wTG.eq(bool);
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
    AppMethodBeat.i(268450);
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set handsFree: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(268281);
        if (q.e(q.this) != q.d.wWY)
        {
          Log.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
          if (paramb != null)
          {
            paramb.a(-10086, -1001, "not in room", "");
            AppMethodBeat.o(268281);
            return;
          }
        }
        Object localObject = q.l(q.this);
        boolean bool = paramBoolean;
        localObject = ((f)localObject).wTF;
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker beSpeakerphoneOn: ".concat(String.valueOf(bool)));
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker ignoreBluetooth: false");
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isAvailable: " + ((g)localObject).wTY.isAvailable());
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isSpeakerSetFailed: " + ((g)localObject).wTY.wTx);
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isBluetoothScoAvailable: " + com.tencent.mm.plugin.audio.d.b.a(((g)localObject).wTY.audioManager));
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isBluetoothScoOn: " + ((g)localObject).wTY.cTV());
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isHeadsetPlugged: " + ((g)localObject).wTY.cTQ());
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isSpeakerphoneOn: " + ((g)localObject).wTY.cTU());
        if ((bool) && ((((g)localObject).wTY.cTV()) || (((g)localObject).wTY.cTQ()))) {
          bool = false;
        }
        while (paramb != null) {
          if (bool)
          {
            paramb.a(0, 0, "ok", "");
            AppMethodBeat.o(268281);
            return;
            bool = ((g)localObject).wTY.lT(bool);
          }
          else
          {
            paramb.a(-10086, -15, "set handsFree failed", "");
          }
        }
        AppMethodBeat.o(268281);
      }
    });
    AppMethodBeat.o(268450);
  }
  
  public final void drn()
  {
    AppMethodBeat.i(268455);
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "onCameraStop");
    au(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(268282);
        if (!q.w(q.this))
        {
          AppMethodBeat.o(268282);
          return;
        }
        q.b(q.this, false);
        MultiProcessMMKV.getMMKV(q.d(q.this) + "_wxa_voip").putBoolean("isCameraStart", q.w(q.this));
        m.b(q.x(q.this), q.w(q.this), q.y(q.this));
        AppMethodBeat.o(268282);
      }
    });
    AppMethodBeat.o(268455);
  }
  
  final void f(final byte[] paramArrayOfByte, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(268460);
    au(new Runnable()
    {
      public final void run()
      {
        int j = 1;
        AppMethodBeat.i(268331);
        if (!q.z(q.this))
        {
          AppMethodBeat.o(268331);
          return;
        }
        Object localObject1;
        Object localObject2;
        Object localObject3;
        int i;
        if (q.this.wVN)
        {
          localObject1 = q.this;
          if (m.d(q.EMethodGetQosPara, ((q)localObject1).wUm.s2p, ((q)localObject1).wUm.s2p.length) >= 0)
          {
            localObject2 = ((q)localObject1).wUm;
            localObject3 = ByteBuffer.wrap(((a)localObject2).s2p);
            ((ByteBuffer)localObject3).order(ByteOrder.LITTLE_ENDIAN);
            ((a)localObject2).iKbps = ((ByteBuffer)localObject3).getShort();
            ((a)localObject2).cFps = ((ByteBuffer)localObject3).get();
            ((a)localObject2).cIPeriod = ((ByteBuffer)localObject3).get();
            ((a)localObject2).cResolution = ((ByteBuffer)localObject3).get();
            ((a)localObject2).wTD = ((ByteBuffer)localObject3).get();
            ((a)localObject2).wTE = ((ByteBuffer)localObject3).get();
            ((a)localObject2).cSkipFlag = ((ByteBuffer)localObject3).get();
            ((a)localObject2).cIReqFlag = ((ByteBuffer)localObject3).get();
            ((a)localObject2).cRsvd1 = ((ByteBuffer)localObject3).get();
            localObject2 = ((q)localObject1).wUm;
            Log.d("OpenVoice[HWEnc]", "raw S2P:" + ((a)localObject2).s2p);
            Log.d("OpenVoice[HWEnc]", "-S2P- iKbps:" + ((a)localObject2).iKbps + ", fps:" + ((a)localObject2).cFps + ", IP:" + ((a)localObject2).cIPeriod + ", Reso:" + ((a)localObject2).cResolution + ", Codec:" + ((a)localObject2).wTD + ", HWEnable:" + ((a)localObject2).wTE + ", Skip:" + ((a)localObject2).cSkipFlag + ", IReq:" + ((a)localObject2).cIReqFlag + ", Rsvd1:" + ((a)localObject2).cRsvd1);
          }
          if (((q)localObject1).wVN) {
            if (8 == ((q)localObject1).wUm.wTD)
            {
              ((q)localObject1).wVO = true;
              if (((q)localObject1).wUm.wTE == 0)
              {
                ((q)localObject1).wVN = false;
                ((q)localObject1).wVO = false;
              }
              if ((1 != ((q)localObject1).wUm.cSkipFlag) && (((q)localObject1).wVN) && (((q)localObject1).wVO)) {
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
          if (q.this.wVO)
          {
            if ((q.this.wVM == null) || (i != 0)) {
              break label917;
            }
            i = q.this.wVM.d(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
            if (i < 0)
            {
              Log.e("MicroMsg.OpenVoice.OpenVoiceService", "StopHWEnc!! hw encoder error: ".concat(String.valueOf(i)));
              q.this.wVO = false;
            }
            AppMethodBeat.o(268331);
            return;
            ((q)localObject1).wVO = false;
            break;
            ((q)localObject1).wVO = false;
            break;
            label513:
            if ((((q)localObject1).wVN) && (((q)localObject1).wVM == null))
            {
              ((q)localObject1).wVM = new h(((q)localObject1).wUm.cFps, ((q)localObject1).wUm.iKbps, "video/avc");
              Log.i("MicroMsg.OpenVoice.OpenVoiceService", "create avcCodec: " + ((q)localObject1).wVM);
            }
            for (;;)
            {
              i = 0;
              break;
              localObject2 = ((q)localObject1).wVM;
              localObject1 = ((q)localObject1).wUm;
              if ((((h)localObject2).wUm != null) && (((h)localObject2).wUb != null))
              {
                localObject3 = ((h)localObject2).wUm;
                ((a)localObject3).iKbps = ((a)localObject1).iKbps;
                ((a)localObject3).cFps = ((a)localObject1).cFps;
                ((a)localObject3).cIPeriod = ((a)localObject1).cIPeriod;
                ((a)localObject3).cResolution = ((a)localObject1).cResolution;
                ((a)localObject3).wTD = ((a)localObject1).wTD;
                ((a)localObject3).wTE = ((a)localObject1).wTE;
                ((a)localObject3).cSkipFlag = ((a)localObject1).cSkipFlag;
                ((a)localObject3).cIReqFlag = ((a)localObject1).cIReqFlag;
                ((a)localObject3).cRsvd1 = ((a)localObject1).cRsvd1;
                i = (int)(((h)localObject2).wUm.iKbps * 1.1D);
                if (((h)localObject2).m_br_kbps != i)
                {
                  ((h)localObject2).SetBitRate(i);
                  Log.i("OpenVoice[HWEnc]", "steve[QoS]: Update BR! frameID: " + h.frameID + ", new_br: " + ((h)localObject2).m_br_kbps + ", tuneBR:" + i);
                  ((h)localObject2).m_br_kbps = i;
                }
                if ((1 == ((h)localObject2).wUm.cIReqFlag) && (h.frameID > 0))
                {
                  if (((h)localObject2).wUb != null)
                  {
                    Log.v("OpenVoice[HWEnc]", "steve: Sync frame request soon!");
                    localObject1 = new Bundle();
                    ((Bundle)localObject1).putInt("request-sync", 0);
                    ((h)localObject2).wUb.setParameters((Bundle)localObject1);
                  }
                  Log.i("OpenVoice[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + h.frameID);
                }
                if (((h)localObject2).wUm.cFps != ((h)localObject2).m_framerate) {
                  ((h)localObject2).m_framerate = ((h)localObject2).wUm.cFps;
                }
              }
            }
            label892:
            i = 0;
            continue;
          }
          m.e(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
          label917:
          AppMethodBeat.o(268331);
          return;
          i = 0;
        }
      }
    });
    AppMethodBeat.o(268460);
  }
  
  public final void nt(final boolean paramBoolean)
  {
    AppMethodBeat.i(268458);
    if (paramBoolean) {}
    for (String str = "yes";; str = "no")
    {
      Log.i("MicroMsg.OpenVoice.OpenVoiceService", "onMicSwitch %s", new Object[] { str });
      au(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(268279);
          if (paramBoolean == q.x(q.this))
          {
            AppMethodBeat.o(268279);
            return;
          }
          q.c(q.this, paramBoolean);
          m.b(q.x(q.this), q.w(q.this), q.y(q.this));
          AppMethodBeat.o(268279);
        }
      });
      AppMethodBeat.o(268458);
      return;
    }
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(268467);
    if (this.wVi != null) {
      this.wVi.stop();
    }
    AppMethodBeat.o(268467);
  }
  
  public static enum a
  {
    public final int eJM;
    
    static
    {
      AppMethodBeat.i(90891);
      wWN = new a("ReasonInterrupted", 0, 0);
      wWO = new a("ReasonManual", 1, 1);
      wWP = new a("ReasonDevice", 2, 2);
      wWQ = new a("ReasonInCommingCall", 3, 3);
      wWR = new a("ReasonSessionUpdateFailed", 4, 4);
      wWS = new a("ReasonWeappEnterBackground", 5, 5);
      wWT = new a("ReasonWeappStopFromPassiveFloatBall", 6, 6);
      wWU = new a("ReasonUnknown", 7, 100);
      wWV = new a[] { wWN, wWO, wWP, wWQ, wWR, wWS, wWT, wWU };
      AppMethodBeat.o(90891);
    }
    
    private a(int paramInt)
    {
      this.eJM = paramInt;
    }
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(90896);
      wWW = new d("NotInRoom", 0);
      wWX = new d("SdkInRoom", 1);
      wWY = new d("InRoom", 2);
      wWZ = new d[] { wWW, wWX, wWY };
      AppMethodBeat.o(90896);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q
 * JD-Core Version:    0.7.0.1
 */