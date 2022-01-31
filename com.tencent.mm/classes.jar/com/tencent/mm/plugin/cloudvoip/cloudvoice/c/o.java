package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.content.Context;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.wxmm.IConfCallBack;
import java.util.ArrayList;

public enum o
{
  public static int EMethodGetQosPara;
  private String hUm;
  private final al huT;
  private final j kJD;
  private final q kKO;
  private final k kKP;
  private final e kKQ;
  public final r kKR;
  o.d kKS;
  private o.a kKT;
  private String kKU;
  private int kKV;
  public int kKW;
  private b<o.a> kKX;
  private b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.b.b>> kKY;
  private b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.b.b>> kKZ;
  a kKi;
  private k.a kLa;
  private k.a kLb;
  private k.a kLc;
  private k.a kLd;
  private k.a kLe;
  private k.a kLf;
  private k.a kLg;
  private k.a kLh;
  private boolean kLi;
  private boolean kLj;
  private b<String> kLk;
  public long kLl;
  public g kLm;
  public boolean kLn;
  public boolean kLo;
  private PhoneStateListener kLp;
  private boolean kLq;
  private boolean kLr;
  private boolean kLs;
  private final int kLt;
  public Runnable kLu;
  private boolean mIsInit;
  private int mMaxHeight;
  private int mMaxWidth;
  
  static
  {
    AppMethodBeat.i(135586);
    kKN = new o("INSTANCE");
    kLv = new o[] { kKN };
    EMethodGetQosPara = 25;
    AppMethodBeat.o(135586);
  }
  
  private o()
  {
    AppMethodBeat.i(135556);
    this.kKV = 0;
    this.kKW = 1;
    this.mMaxWidth = 480;
    this.mMaxHeight = 640;
    this.kLl = -1L;
    this.kLm = null;
    this.kKi = null;
    this.kLp = new o.11(this);
    this.kLq = false;
    this.kLr = false;
    this.kLs = false;
    this.kLt = -9999;
    this.kLu = new o.7(this);
    this.kKO = new q();
    this.kKP = new k();
    this.kJD = new j();
    this.kKQ = new e(this.kJD);
    this.kKR = new r(this.kJD);
    this.huT = new al("openvoice_voip_worker");
    this.kKS = o.d.kMl;
    this.hUm = null;
    Object localObject = (Bundle)com.tencent.mm.ipcinvoker.f.a("com.tencent.mm", null, o.b.class);
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("device_info", "");
      ab.v("MicroMsg.OpenVoice.OpenVoiceService", "hy: updatad device info %s", new Object[] { localObject });
      ac.ll((String)localObject);
    }
    for (;;)
    {
      this.kLi = false;
      this.mIsInit = false;
      this.kLj = false;
      this.kLk = null;
      this.kLm = null;
      this.kLn = true;
      this.kLo = false;
      this.kKi = new a();
      AppMethodBeat.o(135556);
      return;
      ab.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: can not get device info from mm");
    }
  }
  
  private int Jm(String paramString)
  {
    AppMethodBeat.i(135558);
    IConfCallBack localIConfCallBack = this.kKP.gk(true);
    int i = l.a(this.kKU, this.hUm, paramString, this.kKV, this.mMaxWidth, this.mMaxHeight, localIConfCallBack);
    this.kLd = new o.13(this);
    this.kKP.a(8, this.kLd);
    AppMethodBeat.o(135558);
    return i;
  }
  
  static int O(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(135574);
    paramInt = l.N(paramArrayOfByte, paramInt);
    AppMethodBeat.o(135574);
    return paramInt;
  }
  
  private void P(Runnable paramRunnable)
  {
    AppMethodBeat.i(135563);
    this.huT.o(paramRunnable, 180000L);
    AppMethodBeat.o(135563);
  }
  
  private static int a(o.a parama)
  {
    AppMethodBeat.i(135565);
    switch (o.10.hVJ[parama.ordinal()])
    {
    default: 
      AppMethodBeat.o(135565);
      return 0;
    case 1: 
    case 2: 
    case 3: 
      AppMethodBeat.o(135565);
      return 0;
    case 4: 
      AppMethodBeat.o(135565);
      return 1;
    case 5: 
      AppMethodBeat.o(135565);
      return 6;
    case 6: 
      AppMethodBeat.o(135565);
      return 8;
    }
    AppMethodBeat.o(135565);
    return 7;
  }
  
  private void a(b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.b.b>> paramb)
  {
    int k = 1;
    AppMethodBeat.i(135559);
    ab.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: try trigger succ: %b %b %b", new Object[] { Boolean.valueOf(this.kLq), Boolean.valueOf(this.kLr), Boolean.valueOf(this.kLs) });
    if ((this.kLq) && (this.kLs) && (this.kLr))
    {
      int i;
      if (this.kLj)
      {
        ab.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: require exit. try exit exit again");
        a(paramb, -10086, -9, "interrupted because already cancelled or entered background");
        i = b(this.kKT);
        if (this.kLk != null)
        {
          if (i != 0) {
            break label153;
          }
          this.kLk.a(0, 0, "ok", "");
        }
        for (;;)
        {
          this.kLj = false;
          this.kLk = null;
          AppMethodBeat.o(135559);
          return;
          label153:
          this.kLk.a(-10086, -17, "exit failed", "");
        }
      }
      this.kKR.bhv();
      Object localObject = this.kKQ;
      boolean bool;
      if (((e)localObject).kJF != 2)
      {
        ab.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: error not init when start record!");
        i = 0;
        bool = this.kKQ.EC();
        j = k;
        if (i != 0)
        {
          j = k;
          if (bool) {
            j = 0;
          }
        }
        n.kKE = j;
        if (i != 0) {
          break label361;
        }
        localObject = this.kKQ.kJA;
        if (((f)localObject).kJR == null) {
          break label361;
        }
        j = ((f)localObject).kJR.cLK();
        label269:
        n.kKG = j;
        if (!bool) {
          break label366;
        }
      }
      label361:
      label366:
      for (int j = 0;; j = this.kKQ.kJB.cjh)
      {
        n.kKF = j;
        if ((i == 0) || (!bool)) {
          break label380;
        }
        a(paramb, 0, 0, "ok");
        AppMethodBeat.o(135559);
        return;
        if (((e)localObject).kJA.a(new e.2((e)localObject), ((e)localObject).mSampleRate, ((e)localObject).mChannels, ((e)localObject).kJO) <= 0)
        {
          ((e)localObject).kJJ = 1;
          i = 0;
          break;
        }
        i = 1;
        break;
        j = 0;
        break label269;
      }
      label380:
      b(paramb);
    }
    AppMethodBeat.o(135559);
  }
  
  private void a(b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.b.b>> paramb, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(135557);
    this.kLi = false;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      this.kKS = o.d.kMn;
    }
    synchronized (this.kKP)
    {
      this.kKP.b(1, this.kLe);
      this.kKP.b(2, this.kLf);
      this.kKP.b(4, this.kLg);
      this.kKP.b(5, this.kLh);
      this.kLe = null;
      this.kLf = null;
      this.kLg = null;
      this.kLh = null;
      ??? = this.kJD.kKm;
      if (paramb != null) {
        paramb.a(paramInt1, paramInt2, paramString, ???);
      }
      AppMethodBeat.o(135557);
      return;
    }
  }
  
  static boolean a(com.tencent.mm.plugin.cloudvoip.cloudvoice.b.b paramb)
  {
    AppMethodBeat.i(135571);
    if (l.tH(paramb.kJx) == 1)
    {
      AppMethodBeat.o(135571);
      return true;
    }
    AppMethodBeat.o(135571);
    return false;
  }
  
  static int aA(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(145862);
    int i = l.az(paramArrayOfByte);
    AppMethodBeat.o(145862);
    return i;
  }
  
  private int b(o.a parama)
  {
    AppMethodBeat.i(135566);
    ab.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger exit with reason: %s", new Object[] { parama });
    this.kKT = parama;
    if (this.kLi)
    {
      ab.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: current joining room. waiting for exiting after joining");
      this.kLj = true;
      AppMethodBeat.o(135566);
      return -9999;
    }
    if (this.kKS == o.d.kMl)
    {
      ab.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room! maybe is joining room");
      AppMethodBeat.o(135566);
      return 0;
    }
    int i = l.tI(a(parama));
    bhu();
    AppMethodBeat.o(135566);
    return i;
  }
  
  private void b(b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.b.b>> paramb)
  {
    AppMethodBeat.i(135560);
    a(paramb, -10086, -7, "start audio device failed");
    b(o.a.kMf);
    AppMethodBeat.o(135560);
  }
  
  private void bhs()
  {
    this.kLq = false;
    this.kLr = false;
    this.kLs = false;
  }
  
  /* Error */
  private void bht()
  {
    // Byte code:
    //   0: ldc_w 712
    //   3: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 160	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/o:kJD	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/j;
    //   10: getfield 425	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/j:kKm	Ljava/util/ArrayList;
    //   13: invokevirtual 463	java/util/ArrayList:clear	()V
    //   16: aload_0
    //   17: getfield 160	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/o:kJD	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/j;
    //   20: astore_2
    //   21: aload_2
    //   22: getfield 484	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/j:kKo	Ljava/util/ArrayList;
    //   25: astore_1
    //   26: aload_1
    //   27: monitorenter
    //   28: aload_2
    //   29: getfield 484	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/j:kKo	Ljava/util/ArrayList;
    //   32: invokevirtual 463	java/util/ArrayList:clear	()V
    //   35: aload_1
    //   36: monitorexit
    //   37: aload_2
    //   38: getfield 500	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/j:kKp	Ljava/util/Timer;
    //   41: ifnull +10 -> 51
    //   44: aload_2
    //   45: getfield 500	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/j:kKp	Ljava/util/Timer;
    //   48: invokevirtual 715	java/util/Timer:cancel	()V
    //   51: aload_0
    //   52: getfield 167	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/o:kKQ	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/e;
    //   55: astore_2
    //   56: aload_2
    //   57: getfield 358	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/e:kJA	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/f;
    //   60: ifnull +129 -> 189
    //   63: aload_2
    //   64: getfield 358	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/e:kJA	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/f;
    //   67: astore_3
    //   68: aload_3
    //   69: getfield 719	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/f:kJS	Ljava/lang/Object;
    //   72: astore_1
    //   73: aload_1
    //   74: monitorenter
    //   75: ldc_w 721
    //   78: ldc_w 723
    //   81: iconst_2
    //   82: anewarray 210	java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: aload_3
    //   88: getfield 726	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/f:isStart	Z
    //   91: invokestatic 312	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: aload_3
    //   98: invokevirtual 729	java/lang/Object:hashCode	()I
    //   101: invokestatic 734	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   104: aastore
    //   105: invokestatic 314	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_3
    //   109: getfield 726	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/f:isStart	Z
    //   112: ifeq +75 -> 187
    //   115: aload_3
    //   116: getfield 364	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/f:kJR	Lcom/tencent/mm/plugin/voip/model/c;
    //   119: astore 4
    //   121: aload 4
    //   123: ifnull +64 -> 187
    //   126: aload_3
    //   127: getfield 738	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/f:kJX	Lcom/tencent/mm/compatible/util/g$a;
    //   130: invokestatic 744	android/os/SystemClock:elapsedRealtime	()J
    //   133: putfield 749	com/tencent/mm/compatible/util/g$a:etf	J
    //   136: aload 4
    //   138: invokevirtual 752	com/tencent/mm/plugin/voip/model/c:cLJ	()I
    //   141: pop
    //   142: ldc_w 721
    //   145: new 754	java/lang/StringBuilder
    //   148: dup
    //   149: ldc_w 756
    //   152: invokespecial 757	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: aload_3
    //   156: getfield 738	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/f:kJX	Lcom/tencent/mm/compatible/util/g$a;
    //   159: invokevirtual 760	com/tencent/mm/compatible/util/g$a:Mm	()J
    //   162: invokevirtual 764	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   165: invokevirtual 768	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 441	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload 4
    //   173: invokevirtual 771	com/tencent/mm/plugin/voip/model/c:cLG	()I
    //   176: pop
    //   177: aload_3
    //   178: iconst_0
    //   179: putfield 726	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/f:isStart	Z
    //   182: aload_3
    //   183: aconst_null
    //   184: putfield 364	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/f:kJR	Lcom/tencent/mm/plugin/voip/model/c;
    //   187: aload_1
    //   188: monitorexit
    //   189: aload_2
    //   190: iconst_0
    //   191: putfield 774	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/e:kJN	Z
    //   194: aload_2
    //   195: getfield 399	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/e:kJB	Lcom/tencent/mm/audio/b/c;
    //   198: ifnull +25 -> 223
    //   201: aload_2
    //   202: getfield 399	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/e:kJB	Lcom/tencent/mm/audio/b/c;
    //   205: invokevirtual 777	com/tencent/mm/audio/b/c:Et	()Z
    //   208: pop
    //   209: aload_2
    //   210: aconst_null
    //   211: putfield 399	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/e:kJB	Lcom/tencent/mm/audio/b/c;
    //   214: ldc_w 344
    //   217: ldc_w 779
    //   220: invokestatic 441	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload_2
    //   224: getstatic 782	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/e:kJE	I
    //   227: putfield 342	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/e:kJF	I
    //   230: aload_2
    //   231: getfield 358	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/e:kJA	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/f;
    //   234: astore_1
    //   235: invokestatic 788	com/tencent/mm/compatible/b/g:KC	()Lcom/tencent/mm/compatible/b/g;
    //   238: invokevirtual 791	com/tencent/mm/compatible/b/g:KS	()V
    //   241: invokestatic 788	com/tencent/mm/compatible/b/g:KC	()Lcom/tencent/mm/compatible/b/g;
    //   244: iconst_0
    //   245: invokevirtual 794	com/tencent/mm/compatible/b/g:setMode	(I)V
    //   248: aload_1
    //   249: getfield 798	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/f:kJT	Lcom/tencent/mm/plugin/voip/HeadsetPlugReceiver;
    //   252: invokestatic 611	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   255: invokevirtual 804	com/tencent/mm/plugin/voip/HeadsetPlugReceiver:fg	(Landroid/content/Context;)V
    //   258: invokestatic 788	com/tencent/mm/compatible/b/g:KC	()Lcom/tencent/mm/compatible/b/g;
    //   261: invokevirtual 807	com/tencent/mm/compatible/b/g:KF	()V
    //   264: invokestatic 788	com/tencent/mm/compatible/b/g:KC	()Lcom/tencent/mm/compatible/b/g;
    //   267: aload_1
    //   268: invokevirtual 810	com/tencent/mm/compatible/b/g:b	(Lcom/tencent/mm/compatible/b/g$a;)V
    //   271: aload_1
    //   272: getfield 814	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/f:gaP	Lcom/tencent/mm/compatible/util/b;
    //   275: invokevirtual 819	com/tencent/mm/compatible/util/b:Mh	()Z
    //   278: pop
    //   279: aload_0
    //   280: getfield 172	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/o:kKR	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/r;
    //   283: astore_1
    //   284: ldc_w 821
    //   287: ldc_w 823
    //   290: invokestatic 242	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: aload_1
    //   294: monitorenter
    //   295: aload_1
    //   296: getfield 826	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/r:mStarted	Z
    //   299: ifne +114 -> 413
    //   302: aload_1
    //   303: monitorexit
    //   304: aload_0
    //   305: getfield 155	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/o:kKP	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/k;
    //   308: astore_1
    //   309: aload_1
    //   310: monitorenter
    //   311: aload_0
    //   312: getfield 155	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/o:kKP	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/k;
    //   315: bipush 6
    //   317: aload_0
    //   318: getfield 473	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/o:kLa	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/k$a;
    //   321: invokevirtual 415	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/k$a;)V
    //   324: aload_0
    //   325: getfield 155	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/o:kKP	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/k;
    //   328: bipush 7
    //   330: aload_0
    //   331: getfield 478	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/o:kLb	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/k$a;
    //   334: invokevirtual 415	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/k$a;)V
    //   337: aload_0
    //   338: getfield 155	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/o:kKP	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/k;
    //   341: iconst_3
    //   342: aload_0
    //   343: getfield 468	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/o:kLc	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/k$a;
    //   346: invokevirtual 415	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/k$a;)V
    //   349: aload_0
    //   350: getfield 155	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/o:kKP	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/k;
    //   353: bipush 8
    //   355: aload_0
    //   356: getfield 262	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/o:kLd	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/k$a;
    //   359: invokevirtual 415	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/k$a;)V
    //   362: aload_0
    //   363: aconst_null
    //   364: putfield 473	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/o:kLa	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/k$a;
    //   367: aload_0
    //   368: aconst_null
    //   369: putfield 478	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/o:kLb	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/k$a;
    //   372: aload_0
    //   373: aconst_null
    //   374: putfield 468	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/o:kLc	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/k$a;
    //   377: aload_0
    //   378: aconst_null
    //   379: putfield 262	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/o:kLd	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/c/k$a;
    //   382: aload_1
    //   383: monitorexit
    //   384: ldc_w 712
    //   387: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   390: return
    //   391: astore_2
    //   392: aload_1
    //   393: monitorexit
    //   394: ldc_w 712
    //   397: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   400: aload_2
    //   401: athrow
    //   402: astore_2
    //   403: aload_1
    //   404: monitorexit
    //   405: ldc_w 712
    //   408: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   411: aload_2
    //   412: athrow
    //   413: aload_1
    //   414: iconst_0
    //   415: putfield 826	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/r:mStarted	Z
    //   418: aload_1
    //   419: monitorexit
    //   420: aload_1
    //   421: getfield 829	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/r:mTimer	Ljava/util/Timer;
    //   424: ifnull +15 -> 439
    //   427: aload_1
    //   428: getfield 829	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/r:mTimer	Ljava/util/Timer;
    //   431: invokevirtual 715	java/util/Timer:cancel	()V
    //   434: aload_1
    //   435: aconst_null
    //   436: putfield 829	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/r:mTimer	Ljava/util/Timer;
    //   439: aload_1
    //   440: getfield 833	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/r:mThread	Landroid/os/HandlerThread;
    //   443: invokevirtual 838	android/os/HandlerThread:quit	()Z
    //   446: pop
    //   447: aload_1
    //   448: aconst_null
    //   449: putfield 833	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/r:mThread	Landroid/os/HandlerThread;
    //   452: aload_1
    //   453: getfield 842	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/r:kMy	Ljava/util/Map;
    //   456: astore_2
    //   457: aload_2
    //   458: monitorenter
    //   459: aload_1
    //   460: getfield 842	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/r:kMy	Ljava/util/Map;
    //   463: invokeinterface 845 1 0
    //   468: aload_2
    //   469: monitorexit
    //   470: goto -166 -> 304
    //   473: astore_1
    //   474: aload_2
    //   475: monitorexit
    //   476: ldc_w 712
    //   479: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   482: aload_1
    //   483: athrow
    //   484: astore_1
    //   485: ldc_w 821
    //   488: new 754	java/lang/StringBuilder
    //   491: dup
    //   492: ldc_w 847
    //   495: invokespecial 757	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   498: aload_1
    //   499: invokevirtual 848	java/lang/Exception:toString	()Ljava/lang/String;
    //   502: invokevirtual 851	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 768	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokestatic 242	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   511: goto -207 -> 304
    //   514: astore_2
    //   515: aload_1
    //   516: monitorexit
    //   517: ldc_w 712
    //   520: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   523: aload_2
    //   524: athrow
    //   525: astore_2
    //   526: aload_1
    //   527: monitorexit
    //   528: ldc_w 712
    //   531: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   534: aload_2
    //   535: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	536	0	this	o
    //   473	10	1	localObject2	Object
    //   484	43	1	localException	java.lang.Exception
    //   20	211	2	localObject3	Object
    //   391	10	2	localObject4	Object
    //   402	10	2	localObject5	Object
    //   514	10	2	localObject6	Object
    //   525	10	2	localObject7	Object
    //   67	116	3	localf	f
    //   119	53	4	localc	com.tencent.mm.plugin.voip.model.c
    // Exception table:
    //   from	to	target	type
    //   28	37	391	finally
    //   392	394	391	finally
    //   75	121	402	finally
    //   126	187	402	finally
    //   187	189	402	finally
    //   403	405	402	finally
    //   459	470	473	finally
    //   474	476	473	finally
    //   293	295	484	java/lang/Exception
    //   420	439	484	java/lang/Exception
    //   439	459	484	java/lang/Exception
    //   476	484	484	java/lang/Exception
    //   517	525	484	java/lang/Exception
    //   295	304	514	finally
    //   413	420	514	finally
    //   515	517	514	finally
    //   311	384	525	finally
    //   526	528	525	finally
  }
  
  private void bhu()
  {
    AppMethodBeat.i(135567);
    P(this.kLu);
    AppMethodBeat.o(135567);
  }
  
  static int f(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(135573);
    paramInt1 = l.e(paramInt1, paramArrayOfByte, paramInt2);
    AppMethodBeat.o(135573);
    return paramInt1;
  }
  
  private int gl(boolean paramBoolean)
  {
    AppMethodBeat.i(135568);
    ab.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: reset sync, sdkReset %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kKO.reset(this.hUm);
    n.kKE = 0;
    n.kKF = 0;
    n.kKG = 0;
    n.kKH = 0;
    n.kKI = 0;
    n.kKJ = 0;
    n.kKK = 0;
    n.kKL = 0;
    n.kKM = 0;
    this.hUm = null;
    this.kKU = null;
    bht();
    this.mIsInit = false;
    Object localObject = m.kKx;
    ab.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: stop listen to network change");
    ((m)localObject).tK(1);
    if (paramBoolean)
    {
      int i = l.bhr();
      AppMethodBeat.o(135568);
      return i;
    }
    this.kKP.gk(false);
    localObject = (TelephonyManager)ah.getContext().getSystemService("phone");
    if (localObject != null) {
      ((TelephonyManager)localObject).listen(this.kLp, 0);
    }
    AppMethodBeat.o(135568);
    return 0;
  }
  
  static void tM(int paramInt)
  {
    AppMethodBeat.i(135575);
    l.tJ(paramInt);
    AppMethodBeat.o(135575);
  }
  
  static void u(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(135572);
    l.t(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(135572);
  }
  
  public final void O(Runnable paramRunnable)
  {
    AppMethodBeat.i(135562);
    if (Thread.currentThread() == this.huT.oNc.getLooper().getThread())
    {
      paramRunnable.run();
      AppMethodBeat.o(135562);
      return;
    }
    this.huT.ac(paramRunnable);
    AppMethodBeat.o(135562);
  }
  
  public final void a(b<String> paramb, o.a parama)
  {
    AppMethodBeat.i(135564);
    ab.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: user triggered exit conference");
    O(new o.6(this, parama, paramb));
    AppMethodBeat.o(135564);
  }
  
  public final void a(boolean paramBoolean, b<String> paramb)
  {
    AppMethodBeat.i(135569);
    ab.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set mute play: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    O(new o.8(this, paramb, paramBoolean));
    AppMethodBeat.o(135569);
  }
  
  public final void b(boolean paramBoolean, b<String> paramb)
  {
    AppMethodBeat.i(135570);
    ab.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set mute record: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    O(new o.9(this, paramb, paramBoolean));
    AppMethodBeat.o(135570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o
 * JD-Core Version:    0.7.0.1
 */