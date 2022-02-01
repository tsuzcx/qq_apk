package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.os.Looper;
import android.os.Message;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.protocal.protobuf.aau;
import com.tencent.mm.protocal.protobuf.aav;
import com.tencent.mm.protocal.protobuf.aew;
import com.tencent.mm.protocal.protobuf.bsh;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.wxmm.IConfCallBack;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public enum p
{
  public static int EMethodGetQosPara;
  public aq hXp;
  private final aq krf;
  private String lbB;
  private boolean mIsInit;
  private int mMaxHeight;
  private int mMaxWidth;
  private final j pcK;
  private final r pdZ;
  private a pdn;
  private boolean peA;
  private b<String> peB;
  public long peC;
  private boolean peD;
  private boolean peE;
  private int peF;
  public g peG;
  public boolean peH;
  public boolean peI;
  private boolean peJ;
  private boolean peK;
  private boolean peL;
  private final int peM;
  public Runnable peN;
  private final k pea;
  public final e peb;
  public final s pec;
  public i ped;
  public p.d pee;
  private a pef;
  private String peg;
  private String peh;
  private int pei;
  public int pej;
  private b<a> pek;
  private b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> pel;
  private b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> pem;
  private b<HashMap<String, LinkedList>> pen;
  private k.a peo;
  private k.a pep;
  private k.a peq;
  private k.a per;
  private k.a pes;
  private k.a pet;
  private k.a peu;
  private k.a pev;
  private k.a pew;
  private boolean pex;
  public boolean pey;
  public boolean pez;
  
  static
  {
    AppMethodBeat.i(90930);
    pdY = new p("INSTANCE");
    peO = new p[] { pdY };
    EMethodGetQosPara = 25;
    AppMethodBeat.o(90930);
  }
  
  private p()
  {
    AppMethodBeat.i(90899);
    this.pei = 0;
    this.pej = 1;
    this.mMaxWidth = 480;
    this.mMaxHeight = 640;
    this.pey = false;
    this.pez = false;
    this.peC = -1L;
    this.peD = false;
    this.peE = false;
    this.peF = 0;
    this.peG = null;
    this.pdn = null;
    this.hXp = new aq(Looper.getMainLooper())
    {
      TelephonyManager peP;
      PhoneStateListener peQ;
      
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(184471);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 272)
        {
          if (this.peP == null)
          {
            this.peP = ((TelephonyManager)ak.getContext().getSystemService("phone"));
            this.peQ = new PhoneStateListener()
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
                  p.this.ad(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(184469);
                      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: hy: phone broken. exit room if in room");
                      p.a(p.this, p.a.pfJ);
                      AppMethodBeat.o(184469);
                    }
                  });
                }
              }
            };
          }
          this.peP.listen(this.peQ, 32);
        }
        AppMethodBeat.o(184471);
      }
    };
    this.peJ = false;
    this.peK = false;
    this.peL = false;
    this.peM = -9999;
    this.peN = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90867);
        if ((p.e(p.this) == p.d.pfP) && (!p.a(p.this)))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: still not join room in %d ms. directly release", new Object[] { Long.valueOf(180000L) });
          p.u(p.this);
        }
        AppMethodBeat.o(90867);
      }
    };
    this.pdZ = new r();
    this.pea = new k();
    this.pcK = new j();
    this.peb = new e(this.pcK);
    this.pec = new s(this.pcK);
    this.ped = new i(ak.getContext());
    this.krf = new aq("openvoice_voip_worker");
    this.pee = p.d.pfP;
    this.lbB = null;
    com.tencent.mm.sdk.g.b.c(new p.12(this), "updateDeviceInfo");
    this.pex = false;
    this.mIsInit = false;
    this.peA = false;
    this.peB = null;
    this.peG = null;
    this.peH = true;
    this.peI = false;
    this.pdn = new a();
    AppMethodBeat.o(90899);
  }
  
  static void Br(int paramInt)
  {
    AppMethodBeat.i(90919);
    l.Bo(paramInt);
    AppMethodBeat.o(90919);
  }
  
  static int Q(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(90918);
    paramInt = l.P(paramArrayOfByte, paramInt);
    AppMethodBeat.o(90918);
    return paramInt;
  }
  
  private void a(b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> paramb)
  {
    AppMethodBeat.i(90902);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: try trigger succ: %b %b %b", new Object[] { Boolean.valueOf(this.peJ), Boolean.valueOf(this.peK), Boolean.valueOf(this.peL) });
    if ((this.peJ) && (this.peL) && (this.peK))
    {
      int i;
      if (this.peA)
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: require exit. try exit exit again");
        a(paramb, -10086, -9, "interrupted because already cancelled or entered background");
        i = d(this.pef);
        if (this.peB != null)
        {
          if (i != 0) {
            break label153;
          }
          this.peB.a(0, 0, "ok", "");
        }
        for (;;)
        {
          this.peA = false;
          this.peB = null;
          AppMethodBeat.o(90902);
          return;
          label153:
          this.peB.a(-10086, -17, "exit failed", "");
        }
      }
      this.pec.cbu();
      Object localObject = this.peb;
      boolean bool;
      if (((e)localObject).pcM != 2)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: error not init when start record!");
        i = 0;
        bool = this.peb.PO();
        if ((i == 0) || (!bool)) {
          break label337;
        }
        j = 0;
        label230:
        o.pdP = j;
        if (i == 0) {
          break label342;
        }
        j = 0;
        label240:
        o.pdR = j;
        if (!bool) {
          break label376;
        }
      }
      label337:
      label342:
      label376:
      for (int j = 0;; j = this.peb.pcI.dhN)
      {
        o.pdQ = j;
        if ((i == 0) || (!bool)) {
          break label390;
        }
        this.pey = true;
        a(paramb, 0, 0, "ok");
        AppMethodBeat.o(90902);
        return;
        if (((e)localObject).pcH.a(new e.2((e)localObject), ((e)localObject).mSampleRate, ((e)localObject).mChannels, ((e)localObject).pcV) <= 0)
        {
          ((e)localObject).pcQ = 1;
          i = 0;
          break;
        }
        i = 1;
        break;
        j = 1;
        break label230;
        localObject = this.peb.pcH.pcZ.pcA;
        if (localObject != null)
        {
          j = ((com.tencent.mm.plugin.voip.model.c)localObject).eyB();
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
    this.pex = false;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      this.pee = p.d.pfR;
    }
    synchronized (this.pea)
    {
      this.pea.b(3, this.pet);
      this.pea.b(4, this.peu);
      this.pea.b(21, this.pev);
      this.pea.b(22, this.pew);
      this.pet = null;
      this.peu = null;
      this.pev = null;
      this.pew = null;
      ??? = this.pcK.pdr;
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
    if (l.Bm(paramb.pcE) == 1)
    {
      AppMethodBeat.o(90915);
      return true;
    }
    AppMethodBeat.o(90915);
    return false;
  }
  
  static int aQ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(211603);
    int i = l.aP(paramArrayOfByte);
    AppMethodBeat.o(211603);
    return i;
  }
  
  private int aaA(String paramString)
  {
    AppMethodBeat.i(90901);
    IConfCallBack localIConfCallBack = this.pea.jH(true);
    int i = l.a(this.peg, this.lbB, paramString, this.pei, this.mMaxWidth, this.mMaxHeight, localIConfCallBack);
    this.per = new k.a()
    {
      public final boolean cbm()
      {
        return true;
      }
    };
    this.pea.a(25, this.per);
    AppMethodBeat.o(90901);
    return i;
  }
  
  private void ae(Runnable paramRunnable)
  {
    AppMethodBeat.i(90906);
    this.krf.postDelayed(paramRunnable, 180000L);
    AppMethodBeat.o(90906);
  }
  
  private void b(b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> paramb)
  {
    AppMethodBeat.i(90903);
    a(paramb, -10086, -7, "start audio device failed");
    d(a.pfI);
    AppMethodBeat.o(90903);
  }
  
  private static int c(a parama)
  {
    AppMethodBeat.i(90908);
    switch (20.leS[parama.ordinal()])
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
  
  private void cbp()
  {
    this.peJ = false;
    this.peK = false;
    this.peL = false;
  }
  
  /* Error */
  private void cbq()
  {
    // Byte code:
    //   0: ldc_w 854
    //   3: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 255	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:pcK	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/j;
    //   10: getfield 493	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/j:pdr	Ljava/util/ArrayList;
    //   13: invokevirtual 525	java/util/ArrayList:clear	()V
    //   16: aload_0
    //   17: getfield 255	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:pcK	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/j;
    //   20: astore_2
    //   21: aload_2
    //   22: getfield 545	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/j:pdt	Ljava/util/ArrayList;
    //   25: astore_1
    //   26: aload_1
    //   27: monitorenter
    //   28: aload_2
    //   29: getfield 545	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/j:pdt	Ljava/util/ArrayList;
    //   32: invokevirtual 525	java/util/ArrayList:clear	()V
    //   35: aload_1
    //   36: monitorexit
    //   37: aload_2
    //   38: getfield 561	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/j:pdu	Ljava/util/Timer;
    //   41: ifnull +10 -> 51
    //   44: aload_2
    //   45: getfield 561	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/j:pdu	Ljava/util/Timer;
    //   48: invokevirtual 857	java/util/Timer:cancel	()V
    //   51: aload_0
    //   52: getfield 262	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:peb	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/e;
    //   55: astore_2
    //   56: aload_2
    //   57: getfield 423	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:pcH	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/f;
    //   60: ifnull +137 -> 197
    //   63: aload_2
    //   64: getfield 423	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:pcH	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/f;
    //   67: astore_3
    //   68: aload_3
    //   69: getfield 861	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:pcY	Ljava/lang/Object;
    //   72: astore_1
    //   73: aload_1
    //   74: monitorenter
    //   75: ldc_w 863
    //   78: ldc_w 865
    //   81: iconst_2
    //   82: anewarray 356	java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: aload_3
    //   88: getfield 868	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:isStart	Z
    //   91: invokestatic 362	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: aload_3
    //   98: invokevirtual 871	java/lang/Object:hashCode	()I
    //   101: invokestatic 876	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   104: aastore
    //   105: invokestatic 367	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_3
    //   109: getfield 868	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:isStart	Z
    //   112: ifeq +83 -> 195
    //   115: aload_3
    //   116: getfield 449	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:pcZ	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/b/a;
    //   119: astore 4
    //   121: aload 4
    //   123: getfield 455	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:pcA	Lcom/tencent/mm/plugin/voip/model/c;
    //   126: astore 5
    //   128: aload 5
    //   130: ifnull +21 -> 151
    //   133: aload 5
    //   135: invokevirtual 879	com/tencent/mm/plugin/voip/model/c:eyA	()I
    //   138: pop
    //   139: aload 5
    //   141: invokevirtual 882	com/tencent/mm/plugin/voip/model/c:eyx	()I
    //   144: pop
    //   145: aload 4
    //   147: aconst_null
    //   148: putfield 455	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:pcA	Lcom/tencent/mm/plugin/voip/model/c;
    //   151: aload_3
    //   152: getfield 886	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:pda	Lcom/tencent/mm/compatible/util/f$a;
    //   155: invokestatic 891	android/os/SystemClock:elapsedRealtime	()J
    //   158: putfield 896	com/tencent/mm/compatible/util/f$a:gfF	J
    //   161: ldc_w 863
    //   164: new 898	java/lang/StringBuilder
    //   167: dup
    //   168: ldc_w 900
    //   171: invokespecial 901	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   174: aload_3
    //   175: getfield 886	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:pda	Lcom/tencent/mm/compatible/util/f$a;
    //   178: invokevirtual 904	com/tencent/mm/compatible/util/f$a:abs	()J
    //   181: invokevirtual 908	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   184: invokevirtual 912	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 509	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload_3
    //   191: iconst_0
    //   192: putfield 868	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:isStart	Z
    //   195: aload_1
    //   196: monitorexit
    //   197: aload_2
    //   198: iconst_0
    //   199: putfield 915	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:mIsPlayMute	Z
    //   202: aload_2
    //   203: getfield 465	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:pcI	Lcom/tencent/mm/audio/b/c;
    //   206: ifnull +25 -> 231
    //   209: aload_2
    //   210: getfield 465	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:pcI	Lcom/tencent/mm/audio/b/c;
    //   213: invokevirtual 918	com/tencent/mm/audio/b/c:PF	()Z
    //   216: pop
    //   217: aload_2
    //   218: aconst_null
    //   219: putfield 465	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:pcI	Lcom/tencent/mm/audio/b/c;
    //   222: ldc_w 400
    //   225: ldc_w 920
    //   228: invokestatic 509	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: getstatic 177	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:pdY	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/p;
    //   234: iconst_0
    //   235: invokevirtual 924	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:jJ	(Z)V
    //   238: aload_2
    //   239: getstatic 927	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:pcL	I
    //   242: putfield 398	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:pcM	I
    //   245: aload_2
    //   246: getfield 423	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:pcH	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/f;
    //   249: getfield 449	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:pcZ	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/b/a;
    //   252: astore_1
    //   253: aload_1
    //   254: invokevirtual 930	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:bHs	()V
    //   257: aload_1
    //   258: ldc_w 932
    //   261: invokevirtual 935	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:Wv	(Ljava/lang/String;)V
    //   264: aload_1
    //   265: getfield 939	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:iAr	Lcom/tencent/mm/compatible/util/b;
    //   268: invokevirtual 944	com/tencent/mm/compatible/util/b:abn	()Z
    //   271: pop
    //   272: invokestatic 949	com/tencent/mm/plugin/audio/c/a:bHF	()V
    //   275: invokestatic 952	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:unInit	()V
    //   278: aload_0
    //   279: getfield 267	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:pec	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/s;
    //   282: astore_1
    //   283: ldc_w 954
    //   286: ldc_w 956
    //   289: invokestatic 405	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: aload_1
    //   293: monitorenter
    //   294: aload_1
    //   295: getfield 959	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/s:mStarted	Z
    //   298: ifne +133 -> 431
    //   301: aload_1
    //   302: monitorexit
    //   303: aload_0
    //   304: getfield 250	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:pea	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   307: astore_1
    //   308: aload_1
    //   309: monitorenter
    //   310: aload_0
    //   311: getfield 250	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:pea	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   314: bipush 23
    //   316: aload_0
    //   317: getfield 538	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:peo	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   320: invokevirtual 483	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;)V
    //   323: aload_0
    //   324: getfield 250	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:pea	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   327: bipush 24
    //   329: aload_0
    //   330: getfield 541	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:pep	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   333: invokevirtual 483	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;)V
    //   336: aload_0
    //   337: getfield 250	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:pea	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   340: bipush 19
    //   342: aload_0
    //   343: getfield 530	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:peq	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   346: invokevirtual 483	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;)V
    //   349: aload_0
    //   350: getfield 250	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:pea	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   353: bipush 20
    //   355: aload_0
    //   356: getfield 535	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:pes	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   359: invokevirtual 483	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;)V
    //   362: aload_0
    //   363: getfield 250	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:pea	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   366: bipush 25
    //   368: aload_0
    //   369: getfield 826	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:per	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   372: invokevirtual 483	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;)V
    //   375: aload_0
    //   376: aconst_null
    //   377: putfield 538	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:peo	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   380: aload_0
    //   381: aconst_null
    //   382: putfield 541	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:pep	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   385: aload_0
    //   386: aconst_null
    //   387: putfield 530	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:peq	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   390: aload_0
    //   391: aconst_null
    //   392: putfield 535	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:pes	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   395: aload_0
    //   396: aconst_null
    //   397: putfield 826	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:per	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   400: aload_1
    //   401: monitorexit
    //   402: ldc_w 854
    //   405: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   408: return
    //   409: astore_2
    //   410: aload_1
    //   411: monitorexit
    //   412: ldc_w 854
    //   415: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   418: aload_2
    //   419: athrow
    //   420: astore_2
    //   421: aload_1
    //   422: monitorexit
    //   423: ldc_w 854
    //   426: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   429: aload_2
    //   430: athrow
    //   431: aload_1
    //   432: iconst_0
    //   433: putfield 959	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/s:mStarted	Z
    //   436: aload_1
    //   437: monitorexit
    //   438: aload_1
    //   439: getfield 962	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/s:mTimer	Ljava/util/Timer;
    //   442: ifnull +15 -> 457
    //   445: aload_1
    //   446: getfield 962	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/s:mTimer	Ljava/util/Timer;
    //   449: invokevirtual 857	java/util/Timer:cancel	()V
    //   452: aload_1
    //   453: aconst_null
    //   454: putfield 962	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/s:mTimer	Ljava/util/Timer;
    //   457: aload_1
    //   458: getfield 965	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/s:pgc	Ljava/util/Map;
    //   461: astore_2
    //   462: aload_2
    //   463: monitorenter
    //   464: aload_1
    //   465: getfield 965	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/s:pgc	Ljava/util/Map;
    //   468: invokeinterface 966 1 0
    //   473: aload_2
    //   474: monitorexit
    //   475: goto -172 -> 303
    //   478: astore_1
    //   479: aload_2
    //   480: monitorexit
    //   481: ldc_w 854
    //   484: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   487: aload_1
    //   488: athrow
    //   489: astore_1
    //   490: ldc_w 954
    //   493: new 898	java/lang/StringBuilder
    //   496: dup
    //   497: ldc_w 968
    //   500: invokespecial 901	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   503: aload_1
    //   504: invokevirtual 969	java/lang/Exception:toString	()Ljava/lang/String;
    //   507: invokevirtual 972	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: invokevirtual 912	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokestatic 405	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   516: goto -213 -> 303
    //   519: astore_2
    //   520: aload_1
    //   521: monitorexit
    //   522: ldc_w 854
    //   525: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   528: aload_2
    //   529: athrow
    //   530: astore_2
    //   531: aload_1
    //   532: monitorexit
    //   533: ldc_w 854
    //   536: invokestatic 184	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   539: aload_2
    //   540: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	541	0	this	p
    //   478	10	1	localObject2	Object
    //   489	43	1	localException	java.lang.Exception
    //   20	226	2	localObject3	Object
    //   409	10	2	localObject4	Object
    //   420	10	2	localObject5	Object
    //   519	10	2	localObject6	Object
    //   530	10	2	localObject7	Object
    //   67	124	3	localf	f
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
  
  private void cbr()
  {
    AppMethodBeat.i(90910);
    ae(this.peN);
    AppMethodBeat.o(90910);
  }
  
  private int cbs()
  {
    AppMethodBeat.i(211604);
    if (l.e(EMethodGetQosPara, this.pdn.s2p, this.pdn.s2p.length) >= 0)
    {
      this.pdn.parseS2PData();
      this.pdn.printS2P();
    }
    if (this.peH) {
      if (8 == this.pdn.pcF) {
        this.peI = true;
      }
    }
    for (;;)
    {
      if (this.pdn.pcG == 0)
      {
        this.peH = false;
        this.peI = false;
      }
      if ((1 != this.pdn.cSkipFlag) && (this.peH) && (this.peI)) {
        break;
      }
      AppMethodBeat.o(211604);
      return -1;
      this.peI = false;
      continue;
      this.peI = false;
    }
    if ((this.peH) && (this.peG == null)) {
      this.peG = new g(this.pdn.cFps, this.pdn.iKbps, "video/avc");
    }
    for (;;)
    {
      AppMethodBeat.o(211604);
      return 0;
      this.peG.a(this.pdn);
    }
  }
  
  private boolean cbt()
  {
    AppMethodBeat.i(211606);
    if (this.ped != null)
    {
      boolean bool = this.ped.OH();
      AppMethodBeat.o(211606);
      return bool;
    }
    AppMethodBeat.o(211606);
    return true;
  }
  
  private int d(a parama)
  {
    AppMethodBeat.i(90909);
    this.pey = false;
    ay.aRW(this.lbB + "_wxa_voip").putBoolean("isCameraStart", false);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.OpenVoice.OpenVoiceService", "appId:%s, exitConferenceSync set isCameraStart false", new Object[] { this.lbB });
    if (!cbt())
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.OpenVoice.OpenVoiceService", "exitConferenceSync, stop ring");
      stopRing();
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger exit with reason: %s", new Object[] { parama });
    this.pef = parama;
    if (this.pex)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: current joining room. waiting for exiting after joining");
      this.peA = true;
      AppMethodBeat.o(90909);
      return -9999;
    }
    if (this.pee == p.d.pfP)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room! maybe is joining room");
      AppMethodBeat.o(90909);
      return 0;
    }
    int i = l.Bn(c(parama));
    cbr();
    AppMethodBeat.o(90909);
    return i;
  }
  
  static int f(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(90917);
    paramInt1 = l.e(paramInt1, paramArrayOfByte, paramInt2);
    AppMethodBeat.o(90917);
    return paramInt1;
  }
  
  private int jI(boolean paramBoolean)
  {
    AppMethodBeat.i(90911);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: reset sync, sdkReset %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.pdZ.aaB(this.lbB);
    o.pdP = 0;
    o.pdQ = 0;
    o.pdR = 0;
    o.pdS = 0;
    o.pdT = 0;
    o.pdU = 0;
    o.pdV = 0;
    o.pdW = 0;
    o.pdX = 0;
    this.lbB = null;
    this.peg = null;
    cbq();
    this.mIsInit = false;
    m localm = m.pdC;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: stop listen to network change");
    localm.Bp(1);
    if (paramBoolean)
    {
      int i = l.cbo();
      AppMethodBeat.o(90911);
      return i;
    }
    this.pea.jH(false);
    this.hXp.sendEmptyMessage(272);
    AppMethodBeat.o(90911);
    return 0;
  }
  
  static void w(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90916);
    l.v(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(90916);
  }
  
  public final void a(final b<String> paramb, final a parama)
  {
    AppMethodBeat.i(90907);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: user triggered exit conference");
    ad(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90866);
        int i = p.a(p.this, parama);
        if (i == -9999)
        {
          com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: pending exit. waiting for next time");
          p.b(p.this, paramb);
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
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set mute play: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ad(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184480);
        if (p.e(p.this) != p.d.pfR)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
          if (paramb != null)
          {
            paramb.a(-10086, -1001, "not in room", "");
            AppMethodBeat.o(184480);
            return;
          }
        }
        p.l(p.this).mIsPlayMute = paramBoolean;
        if (paramb != null) {
          paramb.a(0, 0, "ok", "");
        }
        AppMethodBeat.o(184480);
      }
    });
    AppMethodBeat.o(90912);
  }
  
  public final void ad(Runnable paramRunnable)
  {
    AppMethodBeat.i(90905);
    if (this.krf.getSerialTag().equals(com.tencent.e.j.a.gau()))
    {
      paramRunnable.run();
      AppMethodBeat.o(90905);
      return;
    }
    this.krf.post(paramRunnable);
    AppMethodBeat.o(90905);
  }
  
  public final void b(final boolean paramBoolean, final b<String> paramb)
  {
    AppMethodBeat.i(90913);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set mute record: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ad(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184481);
        if (p.e(p.this) != p.d.pfR)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
          if (paramb != null)
          {
            paramb.a(-10086, -1001, "not in room", "");
            AppMethodBeat.o(184481);
            return;
          }
        }
        e locale = p.l(p.this);
        boolean bool = paramBoolean;
        locale.pcU = bool;
        p localp = p.pdY;
        String str;
        int i;
        if (bool)
        {
          str = "mute";
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: onMicMute %s", new Object[] { str });
          localp.ad(new p.19(localp, bool));
          if (locale.pcI == null) {
            break label176;
          }
          locale.pcI.cw(bool);
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
    AppMethodBeat.i(211600);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set handsFree: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ad(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211587);
        if (p.e(p.this) != p.d.pfR)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
          if (paramb != null)
          {
            paramb.a(-10086, -1001, "not in room", "");
            AppMethodBeat.o(211587);
            return;
          }
        }
        e locale = p.l(p.this);
        boolean bool = paramBoolean;
        bool = locale.pcH.pcZ.it(bool);
        if (paramb != null)
        {
          if (bool)
          {
            paramb.a(0, 0, "ok", "");
            AppMethodBeat.o(211587);
            return;
          }
          paramb.a(-10086, -15, "set handsFree failed", "");
        }
        AppMethodBeat.o(211587);
      }
    });
    AppMethodBeat.o(211600);
  }
  
  final void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(211602);
    int i;
    if (this.peH) {
      if (cbs() < 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (this.peI)
      {
        if ((this.peG != null) && (i == 0))
        {
          paramInt1 = this.peG.b(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
          if (paramInt1 < 0)
          {
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.OpenVoice.OpenVoiceService", "StopHWEnc!! hw encoder error: ".concat(String.valueOf(paramInt1)));
            this.peI = false;
          }
          AppMethodBeat.o(211602);
          return;
          i = 0;
        }
      }
      else {
        l.c(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(211602);
      return;
      i = 0;
    }
  }
  
  public final void jJ(final boolean paramBoolean)
  {
    AppMethodBeat.i(211601);
    if (paramBoolean) {}
    for (String str = "yes";; str = "no")
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.OpenVoice.OpenVoiceService", "onMicSwitch %s", new Object[] { str });
      ad(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(211590);
          if (paramBoolean == p.w(p.this))
          {
            AppMethodBeat.o(211590);
            return;
          }
          p.c(p.this, paramBoolean);
          l.c(p.w(p.this), p.v(p.this), p.x(p.this));
          AppMethodBeat.o(211590);
        }
      });
      AppMethodBeat.o(211601);
      return;
    }
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(211605);
    if (this.ped != null) {
      this.ped.stop();
    }
    AppMethodBeat.o(211605);
  }
  
  public static enum a
  {
    public final int czw;
    
    static
    {
      AppMethodBeat.i(90891);
      pfG = new a("ReasonInterrupted", 0, 0);
      pfH = new a("ReasonManual", 1, 1);
      pfI = new a("ReasonDevice", 2, 2);
      pfJ = new a("ReasonInCommingCall", 3, 3);
      pfK = new a("ReasonSessionUpdateFailed", 4, 4);
      pfL = new a("ReasonWeappEnterBackground", 5, 5);
      pfM = new a("ReasonWeappStopFromPassiveFloatBall", 6, 6);
      pfN = new a("ReasonUnknown", 7, 100);
      pfO = new a[] { pfG, pfH, pfI, pfJ, pfK, pfL, pfM, pfN };
      AppMethodBeat.o(90891);
    }
    
    private a(int paramInt)
    {
      this.czw = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p
 * JD-Core Version:    0.7.0.1
 */