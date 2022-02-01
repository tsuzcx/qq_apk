package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acr;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.ada;
import com.tencent.mm.protocal.protobuf.aha;
import com.tencent.mm.protocal.protobuf.ahb;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.protocal.protobuf.cfb;
import com.tencent.mm.protocal.protobuf.efj;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public enum q
{
  public static int EMethodGetQosPara;
  private static final String qtb;
  private final MMHandler luO;
  private boolean mIsInit;
  private int mMaxHeight;
  private int mMaxWidth;
  public MMHandler mainHandler;
  private String mgS;
  private final k qrJ;
  a qsn;
  private boolean qtA;
  public boolean qtB;
  public boolean qtC;
  private boolean qtD;
  private b<String> qtE;
  public long qtF;
  private boolean qtG;
  private boolean qtH;
  private int qtI;
  public h qtJ;
  public boolean qtK;
  public boolean qtL;
  private boolean qtM;
  private boolean qtN;
  private boolean qtO;
  private final int qtP;
  public Runnable qtQ;
  private final s qtc;
  private final l qtd;
  public final f qte;
  public final t qtf;
  public e qtg;
  public d qth;
  private a qti;
  private String qtj;
  private String qtk;
  private int qtl;
  public int qtm;
  private b<a> qtn;
  private b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> qto;
  private b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> qtp;
  private b<HashMap<String, LinkedList>> qtq;
  private l.a qtr;
  private l.a qts;
  private l.a qtt;
  private l.a qtu;
  private l.a qtv;
  private l.a qtw;
  private l.a qtx;
  private l.a qty;
  private l.a qtz;
  
  static
  {
    AppMethodBeat.i(90930);
    qta = new q("INSTANCE");
    qtR = new q[] { qta };
    qtb = MMApplicationContext.getApplicationId();
    EMethodGetQosPara = 25;
    AppMethodBeat.o(90930);
  }
  
  private q()
  {
    AppMethodBeat.i(90899);
    this.qtl = 0;
    this.qtm = 1;
    this.mMaxWidth = 480;
    this.mMaxHeight = 640;
    this.qtB = false;
    this.qtC = false;
    this.qtF = -1L;
    this.qtG = false;
    this.qtH = false;
    this.qtI = 0;
    this.qtJ = null;
    this.qsn = null;
    this.mainHandler = new MMHandler(Looper.getMainLooper())
    {
      TelephonyManager qtS;
      PhoneStateListener qtT;
      
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(184471);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 272)
        {
          if (this.qtS == null)
          {
            this.qtS = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
            this.qtT = new PhoneStateListener()
            {
              public final void onCallStateChanged(int paramAnonymous2Int, String paramAnonymous2String)
              {
                AppMethodBeat.i(184470);
                super.onCallStateChanged(paramAnonymous2Int, paramAnonymous2String);
                switch (paramAnonymous2Int)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(184470);
                  return;
                  q.this.aj(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(184469);
                      Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: hy: phone broken. exit room if in room");
                      q.a(q.this, q.a.quN);
                      AppMethodBeat.o(184469);
                    }
                  });
                }
              }
            };
          }
          paramAnonymousMessage = this.qtS;
          Object localObject = this.qtT;
          localObject = com.tencent.mm.hellhoundlib.b.c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMessage, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/cloudvoip/cloudvoice/service/OpenVoiceService$1", "handleMessage", "(Landroid/os/Message;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
          paramAnonymousMessage.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(1)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMessage, "com/tencent/mm/plugin/cloudvoip/cloudvoice/service/OpenVoiceService$1", "handleMessage", "(Landroid/os/Message;)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        }
        AppMethodBeat.o(184471);
      }
    };
    this.qtM = false;
    this.qtN = false;
    this.qtO = false;
    this.qtP = -9999;
    this.qtQ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90867);
        if ((q.e(q.this) == q.d.quT) && (!q.a(q.this)))
        {
          Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: still not join room in %d ms. directly release", new Object[] { Long.valueOf(180000L) });
          q.u(q.this);
        }
        AppMethodBeat.o(90867);
      }
    };
    this.qtc = new s();
    this.qtd = new l();
    this.qrJ = new k();
    this.qte = new f(this.qrJ);
    this.qtf = new t(this.qrJ);
    this.qtg = new e(MMApplicationContext.getContext());
    this.luO = new MMHandler("openvoice_voip_worker");
    this.qth = d.quT;
    this.mgS = null;
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184479);
        Object localObject = (Bundle)com.tencent.mm.ipcinvoker.h.a(q.qtb, null, q.b.class);
        if (localObject != null)
        {
          localObject = ((Bundle)localObject).getString("device_info", "");
          Log.v("MicroMsg.OpenVoice.OpenVoiceService", "hy: updatad device info %s", new Object[] { localObject });
          ae.DV((String)localObject);
          AppMethodBeat.o(184479);
          return;
        }
        Log.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: can not get device info from mm");
        AppMethodBeat.o(184479);
      }
    }, "updateDeviceInfo");
    this.qtA = false;
    this.mIsInit = false;
    this.qtD = false;
    this.qtE = null;
    this.qtJ = null;
    this.qtK = true;
    this.qtL = false;
    this.qsn = new a();
    AppMethodBeat.o(90899);
  }
  
  static void EZ(int paramInt)
  {
    AppMethodBeat.i(90919);
    m.EW(paramInt);
    AppMethodBeat.o(90919);
  }
  
  static void G(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90916);
    m.F(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(90916);
  }
  
  static int S(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(90918);
    paramInt = m.R(paramArrayOfByte, paramInt);
    AppMethodBeat.o(90918);
    return paramInt;
  }
  
  private void a(b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> paramb)
  {
    AppMethodBeat.i(90902);
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: try trigger succ: %b %b %b", new Object[] { Boolean.valueOf(this.qtM), Boolean.valueOf(this.qtN), Boolean.valueOf(this.qtO) });
    if ((this.qtM) && (this.qtO) && (this.qtN))
    {
      int i;
      if (this.qtD)
      {
        Log.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: require exit. try exit exit again");
        a(paramb, -10086, -9, "interrupted because already cancelled or entered background");
        i = d(this.qti);
        if (this.qtE != null)
        {
          if (i != 0) {
            break label153;
          }
          this.qtE.a(0, 0, "ok", "");
        }
        for (;;)
        {
          this.qtD = false;
          this.qtE = null;
          AppMethodBeat.o(90902);
          return;
          label153:
          this.qtE.a(-10086, -17, "exit failed", "");
        }
      }
      this.qtf.czm();
      Object localObject = this.qte;
      boolean bool;
      if (((f)localObject).qrL != 2)
      {
        Log.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: error not init when start record!");
        i = 0;
        bool = this.qte.aai();
        if ((i == 0) || (!bool)) {
          break label337;
        }
        j = 0;
        label230:
        p.qsR = j;
        if (i == 0) {
          break label342;
        }
        j = 0;
        label240:
        p.qsT = j;
        if (!bool) {
          break label376;
        }
      }
      label337:
      label342:
      label376:
      for (int j = 0;; j = this.qte.qrH.dyZ)
      {
        p.qsS = j;
        if ((i == 0) || (!bool)) {
          break label390;
        }
        this.qtB = true;
        a(paramb, 0, 0, "ok");
        AppMethodBeat.o(90902);
        return;
        if (((f)localObject).qrG.a(new f.2((f)localObject), ((f)localObject).mSampleRate, ((f)localObject).mChannels, ((f)localObject).qrV) <= 0)
        {
          ((f)localObject).qrP = 1;
          i = 0;
          break;
        }
        i = 1;
        break;
        j = 1;
        break label230;
        localObject = this.qte.qrG.qrZ.qrz;
        if (localObject != null)
        {
          j = ((com.tencent.mm.plugin.voip.model.c)localObject).fFs();
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
    this.qtA = false;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      this.qth = d.quV;
    }
    synchronized (this.qtd)
    {
      this.qtd.b(3, this.qtw);
      this.qtd.b(4, this.qtx);
      this.qtd.b(22, this.qty);
      this.qtd.b(23, this.qtz);
      this.qtw = null;
      this.qtx = null;
      this.qty = null;
      this.qtz = null;
      ??? = this.qrJ.qsr;
      if (paramb != null) {
        paramb.a(paramInt1, paramInt2, paramString, ???);
      }
      AppMethodBeat.o(90900);
      return;
    }
  }
  
  static boolean a(com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b paramb)
  {
    AppMethodBeat.i(90915);
    if (m.EU(paramb.qrD) > 0)
    {
      AppMethodBeat.o(90915);
      return true;
    }
    AppMethodBeat.o(90915);
    return false;
  }
  
  private void ak(Runnable paramRunnable)
  {
    AppMethodBeat.i(90906);
    this.luO.postDelayed(paramRunnable, 180000L);
    AppMethodBeat.o(90906);
  }
  
  private int akG(String paramString)
  {
    AppMethodBeat.i(90901);
    IConfCallBack localIConfCallBack = this.qtd.kK(true);
    int i = m.a(this.qtj, this.mgS, paramString, this.qtl, this.mMaxWidth, this.mMaxHeight, localIConfCallBack);
    this.qtu = new l.a()
    {
      public final boolean czb()
      {
        return true;
      }
    };
    this.qtd.a(26, this.qtu);
    AppMethodBeat.o(90901);
    return i;
  }
  
  private void b(b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> paramb)
  {
    AppMethodBeat.i(90903);
    a(paramb, -10086, -7, "start audio device failed");
    d(a.quM);
    AppMethodBeat.o(90903);
  }
  
  static int bh(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(186774);
    int i = m.bg(paramArrayOfByte);
    AppMethodBeat.o(186774);
    return i;
  }
  
  private static int c(a parama)
  {
    AppMethodBeat.i(90908);
    switch (21.mkk[parama.ordinal()])
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
  
  private void czf()
  {
    this.qtM = false;
    this.qtN = false;
    this.qtO = false;
  }
  
  /* Error */
  private void czg()
  {
    // Byte code:
    //   0: ldc_w 887
    //   3: invokestatic 185	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 279	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:qrJ	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   10: getfield 519	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:qsr	Ljava/util/ArrayList;
    //   13: invokevirtual 551	java/util/ArrayList:clear	()V
    //   16: aload_0
    //   17: getfield 279	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:qrJ	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   20: astore_2
    //   21: aload_2
    //   22: getfield 567	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:qst	Ljava/util/ArrayList;
    //   25: astore_1
    //   26: aload_1
    //   27: monitorenter
    //   28: aload_2
    //   29: getfield 567	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:qst	Ljava/util/ArrayList;
    //   32: invokevirtual 551	java/util/ArrayList:clear	()V
    //   35: aload_1
    //   36: monitorexit
    //   37: aload_2
    //   38: getfield 583	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:qsu	Ljava/util/Timer;
    //   41: ifnull +10 -> 51
    //   44: aload_2
    //   45: getfield 583	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:qsu	Ljava/util/Timer;
    //   48: invokevirtual 890	java/util/Timer:cancel	()V
    //   51: aload_0
    //   52: getfield 286	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:qte	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/f;
    //   55: astore_2
    //   56: aload_2
    //   57: getfield 449	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:qrG	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/g;
    //   60: ifnull +137 -> 197
    //   63: aload_2
    //   64: getfield 449	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:qrG	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/g;
    //   67: astore_3
    //   68: aload_3
    //   69: getfield 894	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:qrY	Ljava/lang/Object;
    //   72: astore_1
    //   73: aload_1
    //   74: monitorenter
    //   75: ldc_w 896
    //   78: ldc_w 898
    //   81: iconst_2
    //   82: anewarray 382	java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: aload_3
    //   88: getfield 901	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:isStart	Z
    //   91: invokestatic 388	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: aload_3
    //   98: invokevirtual 904	java/lang/Object:hashCode	()I
    //   101: invokestatic 909	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   104: aastore
    //   105: invokestatic 393	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_3
    //   109: getfield 901	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:isStart	Z
    //   112: ifeq +83 -> 195
    //   115: aload_3
    //   116: getfield 475	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:qrZ	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/b/a;
    //   119: astore 4
    //   121: aload 4
    //   123: getfield 481	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:qrz	Lcom/tencent/mm/plugin/voip/model/c;
    //   126: astore 5
    //   128: aload 5
    //   130: ifnull +21 -> 151
    //   133: aload 5
    //   135: invokevirtual 912	com/tencent/mm/plugin/voip/model/c:fFr	()I
    //   138: pop
    //   139: aload 5
    //   141: invokevirtual 915	com/tencent/mm/plugin/voip/model/c:fFo	()I
    //   144: pop
    //   145: aload 4
    //   147: aconst_null
    //   148: putfield 481	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:qrz	Lcom/tencent/mm/plugin/voip/model/c;
    //   151: aload_3
    //   152: getfield 919	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:qsa	Lcom/tencent/mm/compatible/util/f$a;
    //   155: invokestatic 924	android/os/SystemClock:elapsedRealtime	()J
    //   158: putfield 929	com/tencent/mm/compatible/util/f$a:gLm	J
    //   161: ldc_w 896
    //   164: new 775	java/lang/StringBuilder
    //   167: dup
    //   168: ldc_w 931
    //   171: invokespecial 778	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   174: aload_3
    //   175: getfield 919	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:qsa	Lcom/tencent/mm/compatible/util/f$a;
    //   178: invokevirtual 934	com/tencent/mm/compatible/util/f$a:apr	()J
    //   181: invokevirtual 937	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   184: invokevirtual 785	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 535	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload_3
    //   191: iconst_0
    //   192: putfield 901	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:isStart	Z
    //   195: aload_1
    //   196: monitorexit
    //   197: aload_2
    //   198: iconst_0
    //   199: putfield 940	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:qrT	Z
    //   202: aload_2
    //   203: getfield 491	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:qrH	Lcom/tencent/mm/audio/b/c;
    //   206: ifnull +25 -> 231
    //   209: aload_2
    //   210: getfield 491	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:qrH	Lcom/tencent/mm/audio/b/c;
    //   213: invokevirtual 943	com/tencent/mm/audio/b/c:ZZ	()Z
    //   216: pop
    //   217: aload_2
    //   218: aconst_null
    //   219: putfield 491	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:qrH	Lcom/tencent/mm/audio/b/c;
    //   222: ldc_w 426
    //   225: ldc_w 945
    //   228: invokestatic 535	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: getstatic 193	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:qta	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/q;
    //   234: iconst_0
    //   235: invokevirtual 949	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:kM	(Z)V
    //   238: aload_2
    //   239: getstatic 952	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:qrK	I
    //   242: putfield 424	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:qrL	I
    //   245: aload_2
    //   246: getfield 449	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:qrG	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/g;
    //   249: getfield 475	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/g:qrZ	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/b/a;
    //   252: astore_1
    //   253: aload_1
    //   254: invokevirtual 955	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:cdV	()V
    //   257: aload_1
    //   258: ldc_w 957
    //   261: invokevirtual 960	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:agq	(Ljava/lang/String;)V
    //   264: aload_1
    //   265: getfield 964	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:jvG	Lcom/tencent/mm/compatible/util/b;
    //   268: invokevirtual 969	com/tencent/mm/compatible/util/b:apm	()Z
    //   271: pop
    //   272: invokestatic 974	com/tencent/mm/plugin/audio/c/a:ceh	()V
    //   275: invokestatic 977	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:unInit	()V
    //   278: aload_0
    //   279: getfield 291	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:qtf	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/t;
    //   282: astore_1
    //   283: ldc_w 979
    //   286: ldc_w 981
    //   289: invokestatic 431	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: aload_1
    //   293: monitorenter
    //   294: aload_1
    //   295: getfield 984	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/t:mStarted	Z
    //   298: ifne +133 -> 431
    //   301: aload_1
    //   302: monitorexit
    //   303: aload_0
    //   304: getfield 274	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:qtd	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l;
    //   307: astore_1
    //   308: aload_1
    //   309: monitorenter
    //   310: aload_0
    //   311: getfield 274	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:qtd	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l;
    //   314: bipush 24
    //   316: aload_0
    //   317: getfield 560	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:qtr	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;
    //   320: invokevirtual 509	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/l:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;)V
    //   323: aload_0
    //   324: getfield 274	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:qtd	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l;
    //   327: bipush 25
    //   329: aload_0
    //   330: getfield 563	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:qts	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;
    //   333: invokevirtual 509	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/l:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;)V
    //   336: aload_0
    //   337: getfield 274	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:qtd	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l;
    //   340: bipush 20
    //   342: aload_0
    //   343: getfield 554	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:qtt	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;
    //   346: invokevirtual 509	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/l:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;)V
    //   349: aload_0
    //   350: getfield 274	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:qtd	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l;
    //   353: bipush 21
    //   355: aload_0
    //   356: getfield 557	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:qtv	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;
    //   359: invokevirtual 509	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/l:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;)V
    //   362: aload_0
    //   363: getfield 274	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:qtd	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l;
    //   366: bipush 26
    //   368: aload_0
    //   369: getfield 860	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:qtu	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;
    //   372: invokevirtual 509	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/l:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;)V
    //   375: aload_0
    //   376: aconst_null
    //   377: putfield 560	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:qtr	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;
    //   380: aload_0
    //   381: aconst_null
    //   382: putfield 563	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:qts	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;
    //   385: aload_0
    //   386: aconst_null
    //   387: putfield 554	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:qtt	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;
    //   390: aload_0
    //   391: aconst_null
    //   392: putfield 557	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:qtv	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;
    //   395: aload_0
    //   396: aconst_null
    //   397: putfield 860	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/q:qtu	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/l$a;
    //   400: aload_1
    //   401: monitorexit
    //   402: ldc_w 887
    //   405: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   408: return
    //   409: astore_2
    //   410: aload_1
    //   411: monitorexit
    //   412: ldc_w 887
    //   415: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   418: aload_2
    //   419: athrow
    //   420: astore_2
    //   421: aload_1
    //   422: monitorexit
    //   423: ldc_w 887
    //   426: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   429: aload_2
    //   430: athrow
    //   431: aload_1
    //   432: iconst_0
    //   433: putfield 984	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/t:mStarted	Z
    //   436: aload_1
    //   437: monitorexit
    //   438: aload_1
    //   439: getfield 987	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/t:mTimer	Ljava/util/Timer;
    //   442: ifnull +15 -> 457
    //   445: aload_1
    //   446: getfield 987	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/t:mTimer	Ljava/util/Timer;
    //   449: invokevirtual 890	java/util/Timer:cancel	()V
    //   452: aload_1
    //   453: aconst_null
    //   454: putfield 987	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/t:mTimer	Ljava/util/Timer;
    //   457: aload_1
    //   458: getfield 990	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/t:qvg	Ljava/util/Map;
    //   461: astore_2
    //   462: aload_2
    //   463: monitorenter
    //   464: aload_1
    //   465: getfield 990	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/t:qvg	Ljava/util/Map;
    //   468: invokeinterface 991 1 0
    //   473: aload_2
    //   474: monitorexit
    //   475: goto -172 -> 303
    //   478: astore_1
    //   479: aload_2
    //   480: monitorexit
    //   481: ldc_w 887
    //   484: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   487: aload_1
    //   488: athrow
    //   489: astore_1
    //   490: ldc_w 979
    //   493: new 775	java/lang/StringBuilder
    //   496: dup
    //   497: ldc_w 993
    //   500: invokespecial 778	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   503: aload_1
    //   504: invokevirtual 994	java/lang/Exception:toString	()Ljava/lang/String;
    //   507: invokevirtual 997	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: invokevirtual 785	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokestatic 431	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   516: goto -213 -> 303
    //   519: astore_2
    //   520: aload_1
    //   521: monitorexit
    //   522: ldc_w 887
    //   525: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   528: aload_2
    //   529: athrow
    //   530: astore_2
    //   531: aload_1
    //   532: monitorexit
    //   533: ldc_w 887
    //   536: invokestatic 208	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   539: aload_2
    //   540: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	541	0	this	q
    //   478	10	1	localObject2	Object
    //   489	43	1	localException	java.lang.Exception
    //   20	226	2	localObject3	Object
    //   409	10	2	localObject4	Object
    //   420	10	2	localObject5	Object
    //   519	10	2	localObject6	Object
    //   530	10	2	localObject7	Object
    //   67	124	3	localg	g
    //   119	27	4	locala	com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a
    //   126	14	5	localc	com.tencent.mm.plugin.voip.model.c
    // Exception table:
    //   from	to	target	type
    //   28	37	409	finally
    //   410	412	409	finally
    //   75	128	420	finally
    //   133	151	420	finally
    //   151	195	420	finally
    //   195	197	420	finally
    //   421	423	420	finally
    //   464	475	478	finally
    //   479	481	478	finally
    //   292	294	489	java/lang/Exception
    //   438	457	489	java/lang/Exception
    //   457	464	489	java/lang/Exception
    //   481	489	489	java/lang/Exception
    //   522	530	489	java/lang/Exception
    //   294	303	519	finally
    //   431	438	519	finally
    //   520	522	519	finally
    //   310	402	530	finally
    //   531	533	530	finally
  }
  
  private void czh()
  {
    AppMethodBeat.i(90910);
    ak(this.qtQ);
    AppMethodBeat.o(90910);
  }
  
  private boolean czl()
  {
    AppMethodBeat.i(186776);
    if (this.qtg != null)
    {
      boolean bool = this.qtg.YZ();
      AppMethodBeat.o(186776);
      return bool;
    }
    AppMethodBeat.o(186776);
    return true;
  }
  
  private int d(a parama)
  {
    AppMethodBeat.i(90909);
    this.qtB = false;
    MultiProcessMMKV.getMMKV(this.mgS + "_wxa_voip").putBoolean("isCameraStart", false);
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "appId:%s, exitConferenceSync set isCameraStart false", new Object[] { this.mgS });
    if (!czl())
    {
      Log.i("MicroMsg.OpenVoice.OpenVoiceService", "exitConferenceSync, stop ring");
      stopRing();
    }
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger exit with reason: %s", new Object[] { parama });
    this.qti = parama;
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "exitConferenceSync: release avcCodec: " + this.qtJ);
    this.qtJ = null;
    if (this.qtA)
    {
      Log.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: current joining room. waiting for exiting after joining");
      this.qtD = true;
      AppMethodBeat.o(90909);
      return -9999;
    }
    if (this.qth == d.quT)
    {
      Log.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room! maybe is joining room");
      AppMethodBeat.o(90909);
      return 0;
    }
    int i = m.EV(c(parama));
    czh();
    AppMethodBeat.o(90909);
    return i;
  }
  
  static int f(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(90917);
    paramInt1 = m.e(paramInt1, paramArrayOfByte, paramInt2);
    AppMethodBeat.o(90917);
    return paramInt1;
  }
  
  private int kL(boolean paramBoolean)
  {
    AppMethodBeat.i(90911);
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: reset sync, sdkReset %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.qtc.akH(this.mgS);
    p.qsR = 0;
    p.qsS = 0;
    p.qsT = 0;
    p.qsU = 0;
    p.qsV = 0;
    p.qsW = 0;
    p.qsX = 0;
    p.qsY = 0;
    p.qsZ = 0;
    this.mgS = null;
    this.qtj = null;
    czg();
    this.mIsInit = false;
    n localn = n.qsC;
    Log.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: stop listen to network change");
    localn.EX(1);
    if (paramBoolean)
    {
      int i = m.cze();
      AppMethodBeat.o(90911);
      return i;
    }
    this.qtd.kK(false);
    this.mainHandler.sendEmptyMessage(272);
    AppMethodBeat.o(90911);
    return 0;
  }
  
  public final void a(final b<String> paramb, final a parama)
  {
    AppMethodBeat.i(90907);
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: user triggered exit conference");
    aj(new Runnable()
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
    aj(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184480);
        if (q.e(q.this) != q.d.quV)
        {
          Log.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
          if (paramb != null)
          {
            paramb.a(-10086, -1001, "not in room", "");
            AppMethodBeat.o(184480);
            return;
          }
        }
        q.l(q.this).qrT = paramBoolean;
        if (paramb != null) {
          paramb.a(0, 0, "ok", "");
        }
        AppMethodBeat.o(184480);
      }
    });
    AppMethodBeat.o(90912);
  }
  
  public final void aj(Runnable paramRunnable)
  {
    AppMethodBeat.i(90905);
    if (this.luO.getSerialTag().equals(com.tencent.f.j.a.hmF()))
    {
      paramRunnable.run();
      AppMethodBeat.o(90905);
      return;
    }
    this.luO.post(paramRunnable);
    AppMethodBeat.o(90905);
  }
  
  public final void b(final boolean paramBoolean, final b<String> paramb)
  {
    AppMethodBeat.i(90913);
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set mute record: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    aj(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184481);
        if (q.e(q.this) != q.d.quV)
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
        localf.qrU = bool;
        q localq = q.qta;
        String str;
        int i;
        if (bool)
        {
          str = "mute";
          Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: onMicMute %s", new Object[] { str });
          localq.aj(new q.19(localq, bool));
          if (localf.qrH == null) {
            break label176;
          }
          localf.qrH.de(bool);
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
    AppMethodBeat.i(186770);
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set handsFree: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    aj(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186756);
        if (q.e(q.this) != q.d.quV)
        {
          Log.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
          if (paramb != null)
          {
            paramb.a(-10086, -1001, "not in room", "");
            AppMethodBeat.o(186756);
            return;
          }
        }
        Object localObject = q.l(q.this);
        boolean bool = paramBoolean;
        localObject = ((f)localObject).qrG;
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker beSpeakerphoneOn: ".concat(String.valueOf(bool)));
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker ignoreBluetooth: false");
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isAvailable: " + ((g)localObject).qrZ.isAvailable());
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isSpeakerSetFailed: " + ((g)localObject).qrZ.qry);
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isBluetoothScoAvailable: " + com.tencent.mm.plugin.audio.d.b.a(((g)localObject).qrZ.audioManager));
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isBluetoothScoOn: " + ((g)localObject).qrZ.isBluetoothScoOn());
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isHeadsetPlugged: " + ((g)localObject).qrZ.cdW());
        Log.i("MicroMsg.OpenVoice.OpenVoiceAudioPlayer", "MyshiftSpeaker isSpeakerphoneOn: " + ((g)localObject).qrZ.isSpeakerphoneOn());
        if ((bool) && ((((g)localObject).qrZ.isBluetoothScoOn()) || (((g)localObject).qrZ.cdW()))) {
          bool = false;
        }
        while (paramb != null) {
          if (bool)
          {
            paramb.a(0, 0, "ok", "");
            AppMethodBeat.o(186756);
            return;
            bool = ((g)localObject).qrZ.ju(bool);
          }
          else
          {
            paramb.a(-10086, -15, "set handsFree failed", "");
          }
        }
        AppMethodBeat.o(186756);
      }
    });
    AppMethodBeat.o(186770);
  }
  
  public final void czi()
  {
    AppMethodBeat.i(186771);
    Log.i("MicroMsg.OpenVoice.OpenVoiceService", "onCameraStop");
    aj(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186758);
        if (!q.v(q.this))
        {
          AppMethodBeat.o(186758);
          return;
        }
        q.b(q.this, false);
        MultiProcessMMKV.getMMKV(q.d(q.this) + "_wxa_voip").putBoolean("isCameraStart", q.v(q.this));
        m.b(q.w(q.this), q.v(q.this), q.x(q.this));
        AppMethodBeat.o(186758);
      }
    });
    AppMethodBeat.o(186771);
  }
  
  public final int czj()
  {
    return this.qtm;
  }
  
  public final t czk()
  {
    return this.qtf;
  }
  
  final void d(final byte[] paramArrayOfByte, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(186773);
    aj(new Runnable()
    {
      public final void run()
      {
        int j = 1;
        AppMethodBeat.i(186761);
        if (!q.y(q.this))
        {
          AppMethodBeat.o(186761);
          return;
        }
        Object localObject1;
        Object localObject2;
        Object localObject3;
        int i;
        if (q.this.qtK)
        {
          localObject1 = q.this;
          if (m.e(q.EMethodGetQosPara, ((q)localObject1).qsn.s2p, ((q)localObject1).qsn.s2p.length) >= 0)
          {
            localObject2 = ((q)localObject1).qsn;
            localObject3 = ByteBuffer.wrap(((a)localObject2).s2p);
            ((ByteBuffer)localObject3).order(ByteOrder.LITTLE_ENDIAN);
            ((a)localObject2).iKbps = ((ByteBuffer)localObject3).getShort();
            ((a)localObject2).cFps = ((ByteBuffer)localObject3).get();
            ((a)localObject2).cIPeriod = ((ByteBuffer)localObject3).get();
            ((a)localObject2).cResolution = ((ByteBuffer)localObject3).get();
            ((a)localObject2).qrE = ((ByteBuffer)localObject3).get();
            ((a)localObject2).qrF = ((ByteBuffer)localObject3).get();
            ((a)localObject2).cSkipFlag = ((ByteBuffer)localObject3).get();
            ((a)localObject2).cIReqFlag = ((ByteBuffer)localObject3).get();
            ((a)localObject2).cRsvd1 = ((ByteBuffer)localObject3).get();
            localObject2 = ((q)localObject1).qsn;
            Log.d("OpenVoice[HWEnc]", "raw S2P:" + ((a)localObject2).s2p);
            Log.d("OpenVoice[HWEnc]", "-S2P- iKbps:" + ((a)localObject2).iKbps + ", fps:" + ((a)localObject2).cFps + ", IP:" + ((a)localObject2).cIPeriod + ", Reso:" + ((a)localObject2).cResolution + ", Codec:" + ((a)localObject2).qrE + ", HWEnable:" + ((a)localObject2).qrF + ", Skip:" + ((a)localObject2).cSkipFlag + ", IReq:" + ((a)localObject2).cIReqFlag + ", Rsvd1:" + ((a)localObject2).cRsvd1);
          }
          if (((q)localObject1).qtK) {
            if (8 == ((q)localObject1).qsn.qrE)
            {
              ((q)localObject1).qtL = true;
              if (((q)localObject1).qsn.qrF == 0)
              {
                ((q)localObject1).qtK = false;
                ((q)localObject1).qtL = false;
              }
              if ((1 != ((q)localObject1).qsn.cSkipFlag) && (((q)localObject1).qtK) && (((q)localObject1).qtL)) {
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
          if (q.this.qtL)
          {
            if ((q.this.qtJ == null) || (i != 0)) {
              break label917;
            }
            i = q.this.qtJ.b(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
            if (i < 0)
            {
              Log.e("MicroMsg.OpenVoice.OpenVoiceService", "StopHWEnc!! hw encoder error: ".concat(String.valueOf(i)));
              q.this.qtL = false;
            }
            AppMethodBeat.o(186761);
            return;
            ((q)localObject1).qtL = false;
            break;
            ((q)localObject1).qtL = false;
            break;
            label513:
            if ((((q)localObject1).qtK) && (((q)localObject1).qtJ == null))
            {
              ((q)localObject1).qtJ = new h(((q)localObject1).qsn.cFps, ((q)localObject1).qsn.iKbps, "video/avc");
              Log.i("MicroMsg.OpenVoice.OpenVoiceService", "create avcCodec: " + ((q)localObject1).qtJ);
            }
            for (;;)
            {
              i = 0;
              break;
              localObject2 = ((q)localObject1).qtJ;
              localObject1 = ((q)localObject1).qsn;
              if ((((h)localObject2).qsn != null) && (((h)localObject2).qsc != null))
              {
                localObject3 = ((h)localObject2).qsn;
                ((a)localObject3).iKbps = ((a)localObject1).iKbps;
                ((a)localObject3).cFps = ((a)localObject1).cFps;
                ((a)localObject3).cIPeriod = ((a)localObject1).cIPeriod;
                ((a)localObject3).cResolution = ((a)localObject1).cResolution;
                ((a)localObject3).qrE = ((a)localObject1).qrE;
                ((a)localObject3).qrF = ((a)localObject1).qrF;
                ((a)localObject3).cSkipFlag = ((a)localObject1).cSkipFlag;
                ((a)localObject3).cIReqFlag = ((a)localObject1).cIReqFlag;
                ((a)localObject3).cRsvd1 = ((a)localObject1).cRsvd1;
                i = (int)(((h)localObject2).qsn.iKbps * 1.1D);
                if (((h)localObject2).m_br_kbps != i)
                {
                  ((h)localObject2).SetBitRate(i);
                  Log.i("OpenVoice[HWEnc]", "steve[QoS]: Update BR! frameID: " + h.frameID + ", new_br: " + ((h)localObject2).m_br_kbps + ", tuneBR:" + i);
                  ((h)localObject2).m_br_kbps = i;
                }
                if ((1 == ((h)localObject2).qsn.cIReqFlag) && (h.frameID > 0))
                {
                  if (((h)localObject2).qsc != null)
                  {
                    Log.v("OpenVoice[HWEnc]", "steve: Sync frame request soon!");
                    localObject1 = new Bundle();
                    ((Bundle)localObject1).putInt("request-sync", 0);
                    ((h)localObject2).qsc.setParameters((Bundle)localObject1);
                  }
                  Log.i("OpenVoice[HWEnc]", "steve[QoS]: Force I Frame! frameID: " + h.frameID);
                }
                if (((h)localObject2).qsn.cFps != ((h)localObject2).m_framerate) {
                  ((h)localObject2).m_framerate = ((h)localObject2).qsn.cFps;
                }
              }
            }
            label892:
            i = 0;
            continue;
          }
          m.c(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
          label917:
          AppMethodBeat.o(186761);
          return;
          i = 0;
        }
      }
    });
    AppMethodBeat.o(186773);
  }
  
  public final void kM(final boolean paramBoolean)
  {
    AppMethodBeat.i(186772);
    if (paramBoolean) {}
    for (String str = "yes";; str = "no")
    {
      Log.i("MicroMsg.OpenVoice.OpenVoiceService", "onMicSwitch %s", new Object[] { str });
      aj(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186759);
          if (paramBoolean == q.w(q.this))
          {
            AppMethodBeat.o(186759);
            return;
          }
          q.c(q.this, paramBoolean);
          m.b(q.w(q.this), q.v(q.this), q.x(q.this));
          AppMethodBeat.o(186759);
        }
      });
      AppMethodBeat.o(186772);
      return;
    }
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(186775);
    if (this.qtg != null) {
      this.qtg.stop();
    }
    AppMethodBeat.o(186775);
  }
  
  public static enum a
  {
    public final int cND;
    
    static
    {
      AppMethodBeat.i(90891);
      quK = new a("ReasonInterrupted", 0, 0);
      quL = new a("ReasonManual", 1, 1);
      quM = new a("ReasonDevice", 2, 2);
      quN = new a("ReasonInCommingCall", 3, 3);
      quO = new a("ReasonSessionUpdateFailed", 4, 4);
      quP = new a("ReasonWeappEnterBackground", 5, 5);
      quQ = new a("ReasonWeappStopFromPassiveFloatBall", 6, 6);
      quR = new a("ReasonUnknown", 7, 100);
      quS = new a[] { quK, quL, quM, quN, quO, quP, quQ, quR };
      AppMethodBeat.o(90891);
    }
    
    private a(int paramInt)
    {
      this.cND = paramInt;
    }
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(90896);
      quT = new d("NotInRoom", 0);
      quU = new d("SdkInRoom", 1);
      quV = new d("InRoom", 2);
      quW = new d[] { quT, quU, quV };
      AppMethodBeat.o(90896);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q
 * JD-Core Version:    0.7.0.1
 */