package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bjl;
import com.tencent.mm.protocal.protobuf.dkl;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.protocal.protobuf.xx;
import com.tencent.mm.protocal.protobuf.xz;
import com.tencent.mm.protocal.protobuf.ya;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.wxmm.IConfCallBack;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public enum o
{
  public static int EMethodGetQosPara;
  private ap hbq;
  private final ap jth;
  private String kaY;
  private boolean mIsInit;
  private int mMaxHeight;
  private int mMaxWidth;
  private final j nPH;
  private final q nQP;
  private final k nQQ;
  private final e nQR;
  public final r nQS;
  d nQT;
  private a nQU;
  private String nQV;
  private String nQW;
  private int nQX;
  public int nQY;
  private b<a> nQZ;
  a nQj;
  private b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> nRa;
  private b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> nRb;
  private b<HashMap<String, LinkedList>> nRc;
  private k.a nRd;
  private k.a nRe;
  private k.a nRf;
  private k.a nRg;
  private k.a nRh;
  private k.a nRi;
  private k.a nRj;
  private k.a nRk;
  private k.a nRl;
  private boolean nRm;
  private boolean nRn;
  private b<String> nRo;
  public long nRp;
  private boolean nRq;
  public g nRr;
  public boolean nRs;
  public boolean nRt;
  private boolean nRu;
  private boolean nRv;
  private boolean nRw;
  private final int nRx;
  public Runnable nRy;
  
  static
  {
    AppMethodBeat.i(90930);
    nQO = new o("INSTANCE");
    nRz = new o[] { nQO };
    EMethodGetQosPara = 25;
    AppMethodBeat.o(90930);
  }
  
  private o()
  {
    AppMethodBeat.i(90899);
    this.nQX = 0;
    this.nQY = 1;
    this.mMaxWidth = 480;
    this.mMaxHeight = 640;
    this.nRp = -1L;
    this.nRq = false;
    this.nRr = null;
    this.nQj = null;
    this.hbq = new ap(Looper.getMainLooper())
    {
      TelephonyManager nRA;
      PhoneStateListener nRB;
      
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(184471);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 272)
        {
          if (this.nRA == null)
          {
            this.nRA = ((TelephonyManager)aj.getContext().getSystemService("phone"));
            this.nRB = new PhoneStateListener()
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
                  o.this.ae(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(184469);
                      ad.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: hy: phone broken. exit room if in room");
                      o.a(o.this, o.a.nSr);
                      AppMethodBeat.o(184469);
                    }
                  });
                }
              }
            };
          }
          this.nRA.listen(this.nRB, 32);
        }
        AppMethodBeat.o(184471);
      }
    };
    this.nRu = false;
    this.nRv = false;
    this.nRw = false;
    this.nRx = -9999;
    this.nRy = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90865);
        if ((o.e(o.this) == o.d.nSw) && (!o.a(o.this)))
        {
          ad.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: still not join room in %d ms. directly release", new Object[] { Long.valueOf(180000L) });
          o.u(o.this);
        }
        AppMethodBeat.o(90865);
      }
    };
    this.nQP = new q();
    this.nQQ = new k();
    this.nPH = new j();
    this.nQR = new e(this.nPH);
    this.nQS = new r(this.nPH);
    this.jth = new ap("openvoice_voip_worker");
    this.nQT = d.nSw;
    this.kaY = null;
    Object localObject = (Bundle)h.a("com.tencent.mm", null, o.b.class);
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("device_info", "");
      ad.v("MicroMsg.OpenVoice.OpenVoiceService", "hy: updatad device info %s", new Object[] { localObject });
      ae.ph((String)localObject);
    }
    for (;;)
    {
      this.nRm = false;
      this.mIsInit = false;
      this.nRn = false;
      this.nRo = null;
      this.nRr = null;
      this.nRs = true;
      this.nRt = false;
      this.nQj = new a();
      AppMethodBeat.o(90899);
      return;
      ad.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: can not get device info from mm");
    }
  }
  
  private int RQ(String paramString)
  {
    AppMethodBeat.i(90901);
    IConfCallBack localIConfCallBack = this.nQQ.iU(true);
    int i = l.a(this.nQV, this.kaY, paramString, this.nQX, this.mMaxWidth, this.mMaxHeight, localIConfCallBack);
    this.nRg = new k.a()
    {
      public final boolean bOg()
      {
        return true;
      }
    };
    this.nQQ.a(23, this.nRg);
    AppMethodBeat.o(90901);
    return i;
  }
  
  static int S(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(90918);
    paramInt = l.R(paramArrayOfByte, paramInt);
    AppMethodBeat.o(90918);
    return paramInt;
  }
  
  private static int a(a parama)
  {
    AppMethodBeat.i(90908);
    switch (15.kef[parama.ordinal()])
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
  
  private void a(b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> paramb)
  {
    int k = 1;
    AppMethodBeat.i(90902);
    ad.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: try trigger succ: %b %b %b", new Object[] { Boolean.valueOf(this.nRu), Boolean.valueOf(this.nRv), Boolean.valueOf(this.nRw) });
    if ((this.nRu) && (this.nRw) && (this.nRv))
    {
      int i;
      if (this.nRn)
      {
        ad.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: require exit. try exit exit again");
        a(paramb, -10086, -9, "interrupted because already cancelled or entered background");
        i = b(this.nQU);
        if (this.nRo != null)
        {
          if (i != 0) {
            break label156;
          }
          this.nRo.a(0, 0, "ok", "");
        }
        for (;;)
        {
          this.nRn = false;
          this.nRo = null;
          AppMethodBeat.o(90902);
          return;
          label156:
          this.nRo.a(-10086, -17, "exit failed", "");
        }
      }
      this.nQS.bOm();
      Object localObject = this.nQR;
      boolean bool;
      if (((e)localObject).nPJ != 2)
      {
        ad.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: error not init when start record!");
        i = 0;
        bool = this.nQR.Ok();
        j = k;
        if (i != 0)
        {
          j = k;
          if (bool) {
            j = 0;
          }
        }
        n.nQF = j;
        if (i == 0) {
          break label341;
        }
        j = 0;
        label249:
        n.nQH = j;
        if (!bool) {
          break label375;
        }
      }
      label341:
      label375:
      for (int j = 0;; j = this.nQR.nPF.cXZ)
      {
        n.nQG = j;
        if ((i == 0) || (!bool)) {
          break label389;
        }
        a(paramb, 0, 0, "ok");
        AppMethodBeat.o(90902);
        return;
        if (((e)localObject).nPE.a(new e.2((e)localObject), ((e)localObject).mSampleRate, ((e)localObject).mChannels, ((e)localObject).nPR) <= 0)
        {
          ((e)localObject).nPN = 1;
          i = 0;
          break;
        }
        i = 1;
        break;
        localObject = this.nQR.nPE.nPV.nPx;
        if (localObject != null)
        {
          j = ((com.tencent.mm.plugin.voip.model.c)localObject).dRX();
          break label249;
        }
        j = 0;
        break label249;
      }
      label389:
      b(paramb);
    }
    AppMethodBeat.o(90902);
  }
  
  private void a(b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> paramb, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(90900);
    this.nRm = false;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      this.nQT = d.nSy;
    }
    synchronized (this.nQQ)
    {
      this.nQQ.b(1, this.nRi);
      this.nQQ.b(2, this.nRj);
      this.nQQ.b(19, this.nRk);
      this.nQQ.b(20, this.nRl);
      this.nRi = null;
      this.nRj = null;
      this.nRk = null;
      this.nRl = null;
      ??? = this.nPH.nQn;
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
    if (l.zA(paramb.nPB) == 1)
    {
      AppMethodBeat.o(90915);
      return true;
    }
    AppMethodBeat.o(90915);
    return false;
  }
  
  static int aP(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(90914);
    int i = l.aO(paramArrayOfByte);
    AppMethodBeat.o(90914);
    return i;
  }
  
  private void af(Runnable paramRunnable)
  {
    AppMethodBeat.i(90906);
    this.jth.postDelayed(paramRunnable, 180000L);
    AppMethodBeat.o(90906);
  }
  
  private int b(a parama)
  {
    AppMethodBeat.i(90909);
    ad.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger exit with reason: %s", new Object[] { parama });
    this.nQU = parama;
    if (this.nRm)
    {
      ad.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: current joining room. waiting for exiting after joining");
      this.nRn = true;
      AppMethodBeat.o(90909);
      return -9999;
    }
    if (this.nQT == d.nSw)
    {
      ad.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room! maybe is joining room");
      AppMethodBeat.o(90909);
      return 0;
    }
    int i = l.zB(a(parama));
    bOl();
    AppMethodBeat.o(90909);
    return i;
  }
  
  private void b(b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> paramb)
  {
    AppMethodBeat.i(90903);
    a(paramb, -10086, -7, "start audio device failed");
    b(a.nSq);
    AppMethodBeat.o(90903);
  }
  
  private void bOj()
  {
    this.nRu = false;
    this.nRv = false;
    this.nRw = false;
  }
  
  /* Error */
  private void bOk()
  {
    // Byte code:
    //   0: ldc_w 783
    //   3: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 244	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:nPH	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/j;
    //   10: getfield 502	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/j:nQn	Ljava/util/ArrayList;
    //   13: invokevirtual 532	java/util/ArrayList:clear	()V
    //   16: aload_0
    //   17: getfield 244	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:nPH	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/j;
    //   20: astore_2
    //   21: aload_2
    //   22: getfield 548	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/j:nQp	Ljava/util/ArrayList;
    //   25: astore_1
    //   26: aload_1
    //   27: monitorenter
    //   28: aload_2
    //   29: getfield 548	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/j:nQp	Ljava/util/ArrayList;
    //   32: invokevirtual 532	java/util/ArrayList:clear	()V
    //   35: aload_1
    //   36: monitorexit
    //   37: aload_2
    //   38: getfield 564	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/j:nQq	Ljava/util/Timer;
    //   41: ifnull +10 -> 51
    //   44: aload_2
    //   45: getfield 564	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/j:nQq	Ljava/util/Timer;
    //   48: invokevirtual 786	java/util/Timer:cancel	()V
    //   51: aload_0
    //   52: getfield 251	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:nQR	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/e;
    //   55: astore_2
    //   56: aload_2
    //   57: getfield 435	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:nPE	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/f;
    //   60: ifnull +137 -> 197
    //   63: aload_2
    //   64: getfield 435	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:nPE	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/f;
    //   67: astore_3
    //   68: aload_3
    //   69: getfield 790	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:nPU	Ljava/lang/Object;
    //   72: astore_1
    //   73: aload_1
    //   74: monitorenter
    //   75: ldc_w 792
    //   78: ldc_w 794
    //   81: iconst_2
    //   82: anewarray 293	java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: aload_3
    //   88: getfield 797	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:isStart	Z
    //   91: invokestatic 383	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: aload_3
    //   98: invokevirtual 800	java/lang/Object:hashCode	()I
    //   101: invokestatic 805	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   104: aastore
    //   105: invokestatic 385	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_3
    //   109: getfield 797	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:isStart	Z
    //   112: ifeq +83 -> 195
    //   115: aload_3
    //   116: getfield 461	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:nPV	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/b/a;
    //   119: astore 4
    //   121: aload 4
    //   123: getfield 467	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:nPx	Lcom/tencent/mm/plugin/voip/model/c;
    //   126: astore 5
    //   128: aload 5
    //   130: ifnull +21 -> 151
    //   133: aload 5
    //   135: invokevirtual 808	com/tencent/mm/plugin/voip/model/c:dRW	()I
    //   138: pop
    //   139: aload 5
    //   141: invokevirtual 811	com/tencent/mm/plugin/voip/model/c:dRT	()I
    //   144: pop
    //   145: aload 4
    //   147: aconst_null
    //   148: putfield 467	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:nPx	Lcom/tencent/mm/plugin/voip/model/c;
    //   151: aload_3
    //   152: getfield 815	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:nPW	Lcom/tencent/mm/compatible/util/f$a;
    //   155: invokestatic 821	android/os/SystemClock:elapsedRealtime	()J
    //   158: putfield 826	com/tencent/mm/compatible/util/f$a:fGp	J
    //   161: ldc_w 792
    //   164: new 828	java/lang/StringBuilder
    //   167: dup
    //   168: ldc_w 830
    //   171: invokespecial 831	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   174: aload_3
    //   175: getfield 815	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:nPW	Lcom/tencent/mm/compatible/util/f$a;
    //   178: invokevirtual 834	com/tencent/mm/compatible/util/f$a:XK	()J
    //   181: invokevirtual 838	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   184: invokevirtual 842	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 518	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload_3
    //   191: iconst_0
    //   192: putfield 797	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:isStart	Z
    //   195: aload_1
    //   196: monitorexit
    //   197: aload_2
    //   198: iconst_0
    //   199: putfield 845	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:mIsPlayMute	Z
    //   202: aload_2
    //   203: getfield 476	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:nPF	Lcom/tencent/mm/audio/b/c;
    //   206: ifnull +25 -> 231
    //   209: aload_2
    //   210: getfield 476	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:nPF	Lcom/tencent/mm/audio/b/c;
    //   213: invokevirtual 848	com/tencent/mm/audio/b/c:Ob	()Z
    //   216: pop
    //   217: aload_2
    //   218: aconst_null
    //   219: putfield 476	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:nPF	Lcom/tencent/mm/audio/b/c;
    //   222: ldc_w 415
    //   225: ldc_w 850
    //   228: invokestatic 518	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload_2
    //   232: getstatic 853	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:nPI	I
    //   235: putfield 413	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:nPJ	I
    //   238: aload_2
    //   239: getfield 435	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:nPE	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/f;
    //   242: getfield 461	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:nPV	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/b/a;
    //   245: astore_1
    //   246: aload_1
    //   247: invokevirtual 856	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:bvv	()V
    //   250: aload_1
    //   251: ldc_w 858
    //   254: invokevirtual 861	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:Oc	(Ljava/lang/String;)V
    //   257: aload_1
    //   258: getfield 865	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:hDB	Lcom/tencent/mm/compatible/util/b;
    //   261: invokevirtual 870	com/tencent/mm/compatible/util/b:XF	()Z
    //   264: pop
    //   265: invokestatic 873	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:NX	()V
    //   268: aload_0
    //   269: getfield 256	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:nQS	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/r;
    //   272: astore_1
    //   273: ldc_w 875
    //   276: ldc_w 877
    //   279: invokestatic 325	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   282: aload_1
    //   283: monitorenter
    //   284: aload_1
    //   285: getfield 880	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/r:mStarted	Z
    //   288: ifne +133 -> 421
    //   291: aload_1
    //   292: monitorexit
    //   293: aload_0
    //   294: getfield 239	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:nQQ	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   297: astore_1
    //   298: aload_1
    //   299: monitorenter
    //   300: aload_0
    //   301: getfield 239	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:nQQ	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   304: bipush 21
    //   306: aload_0
    //   307: getfield 541	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:nRd	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   310: invokevirtual 492	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;)V
    //   313: aload_0
    //   314: getfield 239	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:nQQ	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   317: bipush 22
    //   319: aload_0
    //   320: getfield 544	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:nRe	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   323: invokevirtual 492	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;)V
    //   326: aload_0
    //   327: getfield 239	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:nQQ	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   330: bipush 17
    //   332: aload_0
    //   333: getfield 535	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:nRf	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   336: invokevirtual 492	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;)V
    //   339: aload_0
    //   340: getfield 239	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:nQQ	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   343: bipush 18
    //   345: aload_0
    //   346: getfield 538	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:nRh	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   349: invokevirtual 492	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;)V
    //   352: aload_0
    //   353: getfield 239	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:nQQ	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   356: bipush 23
    //   358: aload_0
    //   359: getfield 343	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:nRg	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   362: invokevirtual 492	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;)V
    //   365: aload_0
    //   366: aconst_null
    //   367: putfield 541	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:nRd	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   370: aload_0
    //   371: aconst_null
    //   372: putfield 544	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:nRe	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   375: aload_0
    //   376: aconst_null
    //   377: putfield 535	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:nRf	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   380: aload_0
    //   381: aconst_null
    //   382: putfield 538	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:nRh	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   385: aload_0
    //   386: aconst_null
    //   387: putfield 343	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/o:nRg	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   390: aload_1
    //   391: monitorexit
    //   392: ldc_w 783
    //   395: invokestatic 181	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   398: return
    //   399: astore_2
    //   400: aload_1
    //   401: monitorexit
    //   402: ldc_w 783
    //   405: invokestatic 181	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   408: aload_2
    //   409: athrow
    //   410: astore_2
    //   411: aload_1
    //   412: monitorexit
    //   413: ldc_w 783
    //   416: invokestatic 181	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   419: aload_2
    //   420: athrow
    //   421: aload_1
    //   422: iconst_0
    //   423: putfield 880	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/r:mStarted	Z
    //   426: aload_1
    //   427: monitorexit
    //   428: aload_1
    //   429: getfield 883	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/r:mTimer	Ljava/util/Timer;
    //   432: ifnull +15 -> 447
    //   435: aload_1
    //   436: getfield 883	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/r:mTimer	Ljava/util/Timer;
    //   439: invokevirtual 786	java/util/Timer:cancel	()V
    //   442: aload_1
    //   443: aconst_null
    //   444: putfield 883	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/r:mTimer	Ljava/util/Timer;
    //   447: aload_1
    //   448: getfield 887	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/r:nSJ	Ljava/util/Map;
    //   451: astore_2
    //   452: aload_2
    //   453: monitorenter
    //   454: aload_1
    //   455: getfield 887	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/r:nSJ	Ljava/util/Map;
    //   458: invokeinterface 890 1 0
    //   463: aload_2
    //   464: monitorexit
    //   465: goto -172 -> 293
    //   468: astore_1
    //   469: aload_2
    //   470: monitorexit
    //   471: ldc_w 783
    //   474: invokestatic 181	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   477: aload_1
    //   478: athrow
    //   479: astore_1
    //   480: ldc_w 875
    //   483: new 828	java/lang/StringBuilder
    //   486: dup
    //   487: ldc_w 892
    //   490: invokespecial 831	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   493: aload_1
    //   494: invokevirtual 893	java/lang/Exception:toString	()Ljava/lang/String;
    //   497: invokevirtual 896	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: invokevirtual 842	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: invokestatic 325	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   506: goto -213 -> 293
    //   509: astore_2
    //   510: aload_1
    //   511: monitorexit
    //   512: ldc_w 783
    //   515: invokestatic 181	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   518: aload_2
    //   519: athrow
    //   520: astore_2
    //   521: aload_1
    //   522: monitorexit
    //   523: ldc_w 783
    //   526: invokestatic 181	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   529: aload_2
    //   530: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	531	0	this	o
    //   468	10	1	localObject2	Object
    //   479	43	1	localException	java.lang.Exception
    //   20	219	2	localObject3	Object
    //   399	10	2	localObject4	Object
    //   410	10	2	localObject5	Object
    //   509	10	2	localObject6	Object
    //   520	10	2	localObject7	Object
    //   67	124	3	localf	f
    //   119	27	4	locala	com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a
    //   126	14	5	localc	com.tencent.mm.plugin.voip.model.c
    // Exception table:
    //   from	to	target	type
    //   28	37	399	finally
    //   400	402	399	finally
    //   75	128	410	finally
    //   133	151	410	finally
    //   151	195	410	finally
    //   195	197	410	finally
    //   411	413	410	finally
    //   454	465	468	finally
    //   469	471	468	finally
    //   282	284	479	java/lang/Exception
    //   428	447	479	java/lang/Exception
    //   447	454	479	java/lang/Exception
    //   471	479	479	java/lang/Exception
    //   512	520	479	java/lang/Exception
    //   284	293	509	finally
    //   421	428	509	finally
    //   510	512	509	finally
    //   300	392	520	finally
    //   521	523	520	finally
  }
  
  private void bOl()
  {
    AppMethodBeat.i(90910);
    af(this.nRy);
    AppMethodBeat.o(90910);
  }
  
  static int f(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(90917);
    paramInt1 = l.e(paramInt1, paramArrayOfByte, paramInt2);
    AppMethodBeat.o(90917);
    return paramInt1;
  }
  
  private int iW(boolean paramBoolean)
  {
    AppMethodBeat.i(90911);
    ad.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: reset sync, sdkReset %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.nQP.RR(this.kaY);
    n.nQF = 0;
    n.nQG = 0;
    n.nQH = 0;
    n.nQI = 0;
    n.nQJ = 0;
    n.nQK = 0;
    n.nQL = 0;
    n.nQM = 0;
    n.nQN = 0;
    this.kaY = null;
    this.nQV = null;
    bOk();
    this.mIsInit = false;
    m localm = m.nQy;
    ad.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: stop listen to network change");
    localm.zD(1);
    if (paramBoolean)
    {
      int i = l.bOi();
      AppMethodBeat.o(90911);
      return i;
    }
    this.nQQ.iU(false);
    this.hbq.sendEmptyMessage(272);
    AppMethodBeat.o(90911);
    return 0;
  }
  
  static void x(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90916);
    l.w(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(90916);
  }
  
  static void zF(int paramInt)
  {
    AppMethodBeat.i(90919);
    l.zC(paramInt);
    AppMethodBeat.o(90919);
  }
  
  public final void a(final b<String> paramb, final a parama)
  {
    AppMethodBeat.i(90907);
    ad.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: user triggered exit conference");
    ae(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90864);
        int i = o.a(o.this, parama);
        if (i == -9999)
        {
          ad.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: pending exit. waiting for next time");
          o.b(o.this, paramb);
          AppMethodBeat.o(90864);
          return;
        }
        if (paramb != null)
        {
          if (i == 0)
          {
            paramb.a(0, 0, "", "");
            AppMethodBeat.o(90864);
            return;
          }
          paramb.a(-10086, -17, "exit failed", "");
        }
        AppMethodBeat.o(90864);
      }
    });
    AppMethodBeat.o(90907);
  }
  
  public final void a(final boolean paramBoolean, final b<String> paramb)
  {
    AppMethodBeat.i(90912);
    ad.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set mute play: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ae(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90867);
        if (o.e(o.this) != o.d.nSy)
        {
          ad.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
          if (paramb != null)
          {
            paramb.a(-10086, -1001, "not in room", "");
            AppMethodBeat.o(90867);
            return;
          }
        }
        o.l(o.this).mIsPlayMute = paramBoolean;
        if (paramb != null) {
          paramb.a(0, 0, "ok", "");
        }
        AppMethodBeat.o(90867);
      }
    });
    AppMethodBeat.o(90912);
  }
  
  public final void ae(Runnable paramRunnable)
  {
    AppMethodBeat.i(90905);
    if (this.jth.getSerialTag().equals(com.tencent.e.j.a.fon()))
    {
      paramRunnable.run();
      AppMethodBeat.o(90905);
      return;
    }
    this.jth.post(paramRunnable);
    AppMethodBeat.o(90905);
  }
  
  public final void b(final boolean paramBoolean, final b<String> paramb)
  {
    AppMethodBeat.i(90913);
    ad.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set mute record: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ae(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90868);
        if (o.e(o.this) != o.d.nSy)
        {
          ad.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
          if (paramb != null)
          {
            paramb.a(-10086, -1001, "not in room", "");
            AppMethodBeat.o(90868);
            return;
          }
        }
        e locale = o.l(o.this);
        boolean bool = paramBoolean;
        int i;
        if (locale.nPF != null)
        {
          locale.nPF.ct(bool);
          i = 1;
        }
        while (paramb != null) {
          if (i != 0)
          {
            paramb.a(0, 0, "ok", "");
            AppMethodBeat.o(90868);
            return;
            i = 0;
          }
          else
          {
            paramb.a(-10086, -15, "set mute failed", "");
          }
        }
        AppMethodBeat.o(90868);
      }
    });
    AppMethodBeat.o(90913);
  }
  
  public static enum a
  {
    public final int cqY;
    
    static
    {
      AppMethodBeat.i(90891);
      nSo = new a("ReasonInterrupted", 0, 0);
      nSp = new a("ReasonManual", 1, 1);
      nSq = new a("ReasonDevice", 2, 2);
      nSr = new a("ReasonInCommingCall", 3, 3);
      nSs = new a("ReasonSessionUpdateFailed", 4, 4);
      nSt = new a("ReasonWeappEnterBackground", 5, 5);
      nSu = new a("ReasonUnknown", 6, 100);
      nSv = new a[] { nSo, nSp, nSq, nSr, nSs, nSt, nSu };
      AppMethodBeat.o(90891);
    }
    
    private a(int paramInt)
    {
      this.cqY = paramInt;
    }
  }
  
  static enum d
  {
    static
    {
      AppMethodBeat.i(90896);
      nSw = new d("NotInRoom", 0);
      nSx = new d("SdkInRoom", 1);
      nSy = new d("InRoom", 2);
      nSz = new d[] { nSw, nSx, nSy };
      AppMethodBeat.o(90896);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.o
 * JD-Core Version:    0.7.0.1
 */