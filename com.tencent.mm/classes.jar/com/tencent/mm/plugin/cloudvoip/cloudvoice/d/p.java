package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Looper;
import android.os.Message;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.protocal.protobuf.aap;
import com.tencent.mm.protocal.protobuf.aaq;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.aau;
import com.tencent.mm.protocal.protobuf.aen;
import com.tencent.mm.protocal.protobuf.brn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.wxmm.IConfCallBack;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public enum p
{
  public static int EMethodGetQosPara;
  public ap hUx;
  private String kXS;
  private final ap knP;
  private boolean mIsInit;
  private int mMaxHeight;
  private int mMaxWidth;
  private a oWK;
  private final j oWh;
  public i oXA;
  public d oXB;
  private a oXC;
  private String oXD;
  private String oXE;
  private int oXF;
  public int oXG;
  private b<a> oXH;
  private b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> oXI;
  private b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> oXJ;
  private b<HashMap<String, LinkedList>> oXK;
  private k.a oXL;
  private k.a oXM;
  private k.a oXN;
  private k.a oXO;
  private k.a oXP;
  private k.a oXQ;
  private k.a oXR;
  private k.a oXS;
  private k.a oXT;
  private boolean oXU;
  public boolean oXV;
  public boolean oXW;
  private boolean oXX;
  private b<String> oXY;
  public long oXZ;
  private final r oXw;
  private final k oXx;
  public final e oXy;
  public final s oXz;
  private boolean oYa;
  private boolean oYb;
  public g oYc;
  public boolean oYd;
  public boolean oYe;
  private boolean oYf;
  private boolean oYg;
  private boolean oYh;
  private final int oYi;
  public Runnable oYj;
  
  static
  {
    AppMethodBeat.i(90930);
    oXv = new p("INSTANCE");
    oYk = new p[] { oXv };
    EMethodGetQosPara = 25;
    AppMethodBeat.o(90930);
  }
  
  private p()
  {
    AppMethodBeat.i(90899);
    this.oXF = 0;
    this.oXG = 1;
    this.mMaxWidth = 480;
    this.mMaxHeight = 640;
    this.oXV = false;
    this.oXW = false;
    this.oXZ = -1L;
    this.oYa = false;
    this.oYb = false;
    this.oYc = null;
    this.oWK = null;
    this.hUx = new ap(Looper.getMainLooper())
    {
      TelephonyManager oYl;
      PhoneStateListener oYm;
      
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(184471);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 272)
        {
          if (this.oYl == null)
          {
            this.oYl = ((TelephonyManager)aj.getContext().getSystemService("phone"));
            this.oYm = new PhoneStateListener()
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
                  p.this.af(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(184469);
                      ad.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: hy: phone broken. exit room if in room");
                      p.a(p.this, p.a.oZf);
                      AppMethodBeat.o(184469);
                    }
                  });
                }
              }
            };
          }
          this.oYl.listen(this.oYm, 32);
        }
        AppMethodBeat.o(184471);
      }
    };
    this.oYf = false;
    this.oYg = false;
    this.oYh = false;
    this.oYi = -9999;
    this.oYj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90867);
        if ((p.e(p.this) == p.d.oZl) && (!p.a(p.this)))
        {
          ad.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: still not join room in %d ms. directly release", new Object[] { Long.valueOf(180000L) });
          p.u(p.this);
        }
        AppMethodBeat.o(90867);
      }
    };
    this.oXw = new r();
    this.oXx = new k();
    this.oWh = new j();
    this.oXy = new e(this.oWh);
    this.oXz = new s(this.oWh);
    this.oXA = new i(aj.getContext());
    this.knP = new ap("openvoice_voip_worker");
    this.oXB = d.oZl;
    this.kXS = null;
    com.tencent.mm.sdk.g.b.c(new p.12(this), "updateDeviceInfo");
    this.oXU = false;
    this.mIsInit = false;
    this.oXX = false;
    this.oXY = null;
    this.oYc = null;
    this.oYd = true;
    this.oYe = false;
    this.oWK = new a();
    AppMethodBeat.o(90899);
  }
  
  static void Bf(int paramInt)
  {
    AppMethodBeat.i(90919);
    l.Bc(paramInt);
    AppMethodBeat.o(90919);
  }
  
  static int Q(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(90918);
    paramInt = l.P(paramArrayOfByte, paramInt);
    AppMethodBeat.o(90918);
    return paramInt;
  }
  
  private int ZJ(String paramString)
  {
    AppMethodBeat.i(90901);
    IConfCallBack localIConfCallBack = this.oXx.jI(true);
    int i = l.a(this.oXD, this.kXS, paramString, this.oXF, this.mMaxWidth, this.mMaxHeight, localIConfCallBack);
    this.oXO = new k.a()
    {
      public final boolean bZX()
      {
        return true;
      }
    };
    this.oXx.a(25, this.oXO);
    AppMethodBeat.o(90901);
    return i;
  }
  
  private void a(b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> paramb)
  {
    AppMethodBeat.i(90902);
    ad.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: try trigger succ: %b %b %b", new Object[] { Boolean.valueOf(this.oYf), Boolean.valueOf(this.oYg), Boolean.valueOf(this.oYh) });
    if ((this.oYf) && (this.oYh) && (this.oYg))
    {
      int i;
      if (this.oXX)
      {
        ad.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: require exit. try exit exit again");
        a(paramb, -10086, -9, "interrupted because already cancelled or entered background");
        i = d(this.oXC);
        if (this.oXY != null)
        {
          if (i != 0) {
            break label153;
          }
          this.oXY.a(0, 0, "ok", "");
        }
        for (;;)
        {
          this.oXX = false;
          this.oXY = null;
          AppMethodBeat.o(90902);
          return;
          label153:
          this.oXY.a(-10086, -17, "exit failed", "");
        }
      }
      this.oXz.caf();
      Object localObject = this.oXy;
      boolean bool;
      if (((e)localObject).oWj != 2)
      {
        ad.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: error not init when start record!");
        i = 0;
        bool = this.oXy.PP();
        if ((i == 0) || (!bool)) {
          break label337;
        }
        j = 0;
        label230:
        o.oXm = j;
        if (i == 0) {
          break label342;
        }
        j = 0;
        label240:
        o.oXo = j;
        if (!bool) {
          break label376;
        }
      }
      label337:
      label342:
      label376:
      for (int j = 0;; j = this.oXy.oWf.dgL)
      {
        o.oXn = j;
        if ((i == 0) || (!bool)) {
          break label390;
        }
        this.oXV = true;
        a(paramb, 0, 0, "ok");
        AppMethodBeat.o(90902);
        return;
        if (((e)localObject).oWe.a(new e.2((e)localObject), ((e)localObject).mSampleRate, ((e)localObject).mChannels, ((e)localObject).oWs) <= 0)
        {
          ((e)localObject).oWn = 1;
          i = 0;
          break;
        }
        i = 1;
        break;
        j = 1;
        break label230;
        localObject = this.oXy.oWe.oWw.oVX;
        if (localObject != null)
        {
          j = ((com.tencent.mm.plugin.voip.model.c)localObject).euV();
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
    this.oXU = false;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      this.oXB = d.oZn;
    }
    synchronized (this.oXx)
    {
      this.oXx.b(3, this.oXQ);
      this.oXx.b(4, this.oXR);
      this.oXx.b(21, this.oXS);
      this.oXx.b(22, this.oXT);
      this.oXQ = null;
      this.oXR = null;
      this.oXS = null;
      this.oXT = null;
      ??? = this.oWh.oWO;
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
    if (l.Ba(paramb.oWb) == 1)
    {
      AppMethodBeat.o(90915);
      return true;
    }
    AppMethodBeat.o(90915);
    return false;
  }
  
  static int aR(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(90914);
    int i = l.aQ(paramArrayOfByte);
    AppMethodBeat.o(90914);
    return i;
  }
  
  private void ag(Runnable paramRunnable)
  {
    AppMethodBeat.i(90906);
    this.knP.postDelayed(paramRunnable, 180000L);
    AppMethodBeat.o(90906);
  }
  
  private void b(b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> paramb)
  {
    AppMethodBeat.i(90903);
    a(paramb, -10086, -7, "start audio device failed");
    d(a.oZe);
    AppMethodBeat.o(90903);
  }
  
  private static int c(a parama)
  {
    AppMethodBeat.i(90908);
    switch (20.lbi[parama.ordinal()])
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
  
  private void caa()
  {
    this.oYf = false;
    this.oYg = false;
    this.oYh = false;
  }
  
  /* Error */
  private void cab()
  {
    // Byte code:
    //   0: ldc_w 855
    //   3: invokestatic 177	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 261	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oWh	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/j;
    //   10: getfield 513	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/j:oWO	Ljava/util/ArrayList;
    //   13: invokevirtual 543	java/util/ArrayList:clear	()V
    //   16: aload_0
    //   17: getfield 261	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oWh	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/j;
    //   20: astore_2
    //   21: aload_2
    //   22: getfield 559	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/j:oWQ	Ljava/util/ArrayList;
    //   25: astore_1
    //   26: aload_1
    //   27: monitorenter
    //   28: aload_2
    //   29: getfield 559	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/j:oWQ	Ljava/util/ArrayList;
    //   32: invokevirtual 543	java/util/ArrayList:clear	()V
    //   35: aload_1
    //   36: monitorexit
    //   37: aload_2
    //   38: getfield 575	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/j:oWR	Ljava/util/Timer;
    //   41: ifnull +10 -> 51
    //   44: aload_2
    //   45: getfield 575	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/j:oWR	Ljava/util/Timer;
    //   48: invokevirtual 858	java/util/Timer:cancel	()V
    //   51: aload_0
    //   52: getfield 268	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oXy	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/e;
    //   55: astore_2
    //   56: aload_2
    //   57: getfield 444	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:oWe	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/f;
    //   60: ifnull +137 -> 197
    //   63: aload_2
    //   64: getfield 444	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:oWe	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/f;
    //   67: astore_3
    //   68: aload_3
    //   69: getfield 862	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:oWv	Ljava/lang/Object;
    //   72: astore_1
    //   73: aload_1
    //   74: monitorenter
    //   75: ldc_w 864
    //   78: ldc_w 866
    //   81: iconst_2
    //   82: anewarray 377	java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: aload_3
    //   88: getfield 869	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:isStart	Z
    //   91: invokestatic 383	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: aload_3
    //   98: invokevirtual 872	java/lang/Object:hashCode	()I
    //   101: invokestatic 877	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   104: aastore
    //   105: invokestatic 388	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_3
    //   109: getfield 869	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:isStart	Z
    //   112: ifeq +83 -> 195
    //   115: aload_3
    //   116: getfield 470	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:oWw	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/b/a;
    //   119: astore 4
    //   121: aload 4
    //   123: getfield 476	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:oVX	Lcom/tencent/mm/plugin/voip/model/c;
    //   126: astore 5
    //   128: aload 5
    //   130: ifnull +21 -> 151
    //   133: aload 5
    //   135: invokevirtual 880	com/tencent/mm/plugin/voip/model/c:euU	()I
    //   138: pop
    //   139: aload 5
    //   141: invokevirtual 883	com/tencent/mm/plugin/voip/model/c:euR	()I
    //   144: pop
    //   145: aload 4
    //   147: aconst_null
    //   148: putfield 476	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:oVX	Lcom/tencent/mm/plugin/voip/model/c;
    //   151: aload_3
    //   152: getfield 887	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:oWx	Lcom/tencent/mm/compatible/util/f$a;
    //   155: invokestatic 892	android/os/SystemClock:elapsedRealtime	()J
    //   158: putfield 897	com/tencent/mm/compatible/util/f$a:gdx	J
    //   161: ldc_w 864
    //   164: new 899	java/lang/StringBuilder
    //   167: dup
    //   168: ldc_w 901
    //   171: invokespecial 902	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   174: aload_3
    //   175: getfield 887	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:oWx	Lcom/tencent/mm/compatible/util/f$a;
    //   178: invokevirtual 905	com/tencent/mm/compatible/util/f$a:abj	()J
    //   181: invokevirtual 909	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   184: invokevirtual 913	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 529	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload_3
    //   191: iconst_0
    //   192: putfield 869	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:isStart	Z
    //   195: aload_1
    //   196: monitorexit
    //   197: aload_2
    //   198: iconst_0
    //   199: putfield 916	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:mIsPlayMute	Z
    //   202: aload_2
    //   203: getfield 486	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:oWf	Lcom/tencent/mm/audio/b/c;
    //   206: ifnull +25 -> 231
    //   209: aload_2
    //   210: getfield 486	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:oWf	Lcom/tencent/mm/audio/b/c;
    //   213: invokevirtual 919	com/tencent/mm/audio/b/c:PG	()Z
    //   216: pop
    //   217: aload_2
    //   218: aconst_null
    //   219: putfield 486	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:oWf	Lcom/tencent/mm/audio/b/c;
    //   222: ldc_w 421
    //   225: ldc_w 921
    //   228: invokestatic 529	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: getstatic 185	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oXv	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/p;
    //   234: iconst_0
    //   235: invokevirtual 925	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:jK	(Z)V
    //   238: aload_2
    //   239: getstatic 928	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:oWi	I
    //   242: putfield 419	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:oWj	I
    //   245: aload_2
    //   246: getfield 444	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:oWe	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/f;
    //   249: getfield 470	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:oWw	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/b/a;
    //   252: astore_1
    //   253: aload_1
    //   254: invokevirtual 931	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:bGw	()V
    //   257: aload_1
    //   258: ldc_w 933
    //   261: invokevirtual 936	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:VJ	(Ljava/lang/String;)V
    //   264: aload_1
    //   265: getfield 940	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:ixy	Lcom/tencent/mm/compatible/util/b;
    //   268: invokevirtual 945	com/tencent/mm/compatible/util/b:abe	()Z
    //   271: pop
    //   272: invokestatic 950	com/tencent/mm/plugin/audio/c/a:bGJ	()V
    //   275: invokestatic 953	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:unInit	()V
    //   278: aload_0
    //   279: getfield 273	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oXz	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/s;
    //   282: astore_1
    //   283: ldc_w 955
    //   286: ldc_w 957
    //   289: invokestatic 426	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: aload_1
    //   293: monitorenter
    //   294: aload_1
    //   295: getfield 960	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/s:mStarted	Z
    //   298: ifne +133 -> 431
    //   301: aload_1
    //   302: monitorexit
    //   303: aload_0
    //   304: getfield 256	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oXx	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   307: astore_1
    //   308: aload_1
    //   309: monitorenter
    //   310: aload_0
    //   311: getfield 256	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oXx	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   314: bipush 23
    //   316: aload_0
    //   317: getfield 552	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oXL	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   320: invokevirtual 503	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;)V
    //   323: aload_0
    //   324: getfield 256	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oXx	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   327: bipush 24
    //   329: aload_0
    //   330: getfield 555	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oXM	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   333: invokevirtual 503	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;)V
    //   336: aload_0
    //   337: getfield 256	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oXx	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   340: bipush 19
    //   342: aload_0
    //   343: getfield 546	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oXN	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   346: invokevirtual 503	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;)V
    //   349: aload_0
    //   350: getfield 256	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oXx	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   353: bipush 20
    //   355: aload_0
    //   356: getfield 549	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oXP	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   359: invokevirtual 503	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;)V
    //   362: aload_0
    //   363: getfield 256	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oXx	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   366: bipush 25
    //   368: aload_0
    //   369: getfield 355	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oXO	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   372: invokevirtual 503	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;)V
    //   375: aload_0
    //   376: aconst_null
    //   377: putfield 552	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oXL	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   380: aload_0
    //   381: aconst_null
    //   382: putfield 555	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oXM	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   385: aload_0
    //   386: aconst_null
    //   387: putfield 546	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oXN	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   390: aload_0
    //   391: aconst_null
    //   392: putfield 549	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oXP	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   395: aload_0
    //   396: aconst_null
    //   397: putfield 355	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oXO	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   400: aload_1
    //   401: monitorexit
    //   402: ldc_w 855
    //   405: invokestatic 192	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   408: return
    //   409: astore_2
    //   410: aload_1
    //   411: monitorexit
    //   412: ldc_w 855
    //   415: invokestatic 192	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   418: aload_2
    //   419: athrow
    //   420: astore_2
    //   421: aload_1
    //   422: monitorexit
    //   423: ldc_w 855
    //   426: invokestatic 192	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   429: aload_2
    //   430: athrow
    //   431: aload_1
    //   432: iconst_0
    //   433: putfield 960	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/s:mStarted	Z
    //   436: aload_1
    //   437: monitorexit
    //   438: aload_1
    //   439: getfield 963	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/s:mTimer	Ljava/util/Timer;
    //   442: ifnull +15 -> 457
    //   445: aload_1
    //   446: getfield 963	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/s:mTimer	Ljava/util/Timer;
    //   449: invokevirtual 858	java/util/Timer:cancel	()V
    //   452: aload_1
    //   453: aconst_null
    //   454: putfield 963	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/s:mTimer	Ljava/util/Timer;
    //   457: aload_1
    //   458: getfield 966	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/s:oZy	Ljava/util/Map;
    //   461: astore_2
    //   462: aload_2
    //   463: monitorenter
    //   464: aload_1
    //   465: getfield 966	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/s:oZy	Ljava/util/Map;
    //   468: invokeinterface 967 1 0
    //   473: aload_2
    //   474: monitorexit
    //   475: goto -172 -> 303
    //   478: astore_1
    //   479: aload_2
    //   480: monitorexit
    //   481: ldc_w 855
    //   484: invokestatic 192	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   487: aload_1
    //   488: athrow
    //   489: astore_1
    //   490: ldc_w 955
    //   493: new 899	java/lang/StringBuilder
    //   496: dup
    //   497: ldc_w 969
    //   500: invokespecial 902	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   503: aload_1
    //   504: invokevirtual 970	java/lang/Exception:toString	()Ljava/lang/String;
    //   507: invokevirtual 973	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: invokevirtual 913	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokestatic 426	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   516: goto -213 -> 303
    //   519: astore_2
    //   520: aload_1
    //   521: monitorexit
    //   522: ldc_w 855
    //   525: invokestatic 192	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   528: aload_2
    //   529: athrow
    //   530: astore_2
    //   531: aload_1
    //   532: monitorexit
    //   533: ldc_w 855
    //   536: invokestatic 192	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private void cac()
  {
    AppMethodBeat.i(90910);
    ag(this.oYj);
    AppMethodBeat.o(90910);
  }
  
  private int cad()
  {
    AppMethodBeat.i(190948);
    if (l.e(EMethodGetQosPara, this.oWK.s2p, this.oWK.s2p.length) >= 0)
    {
      this.oWK.parseS2PData();
      this.oWK.printS2P();
    }
    if (this.oYd) {
      if (8 == this.oWK.oWc) {
        this.oYe = true;
      }
    }
    for (;;)
    {
      if (this.oWK.oWd == 0)
      {
        this.oYd = false;
        this.oYe = false;
      }
      if ((1 != this.oWK.cSkipFlag) && (this.oYd) && (this.oYe)) {
        break;
      }
      AppMethodBeat.o(190948);
      return -1;
      this.oYe = false;
      continue;
      this.oYe = false;
    }
    if ((this.oYd) && (this.oYc == null)) {
      this.oYc = new g(this.oWK.cFps, this.oWK.iKbps, "video/avc");
    }
    for (;;)
    {
      AppMethodBeat.o(190948);
      return 0;
      this.oYc.a(this.oWK);
    }
  }
  
  private boolean cae()
  {
    AppMethodBeat.i(190950);
    if (this.oXA != null)
    {
      boolean bool = this.oXA.OJ();
      AppMethodBeat.o(190950);
      return bool;
    }
    AppMethodBeat.o(190950);
    return true;
  }
  
  private int d(a parama)
  {
    AppMethodBeat.i(90909);
    this.oXV = false;
    ax.aQz(this.kXS + "_wxa_voip").putBoolean("isCameraStart", false);
    ad.i("MicroMsg.OpenVoice.OpenVoiceService", "appId:%s, exitConferenceSync set isCameraStart false", new Object[] { this.kXS });
    if (!cae())
    {
      ad.i("MicroMsg.OpenVoice.OpenVoiceService", "exitConferenceSync, stop ring");
      stopRing();
    }
    ad.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger exit with reason: %s", new Object[] { parama });
    this.oXC = parama;
    if (this.oXU)
    {
      ad.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: current joining room. waiting for exiting after joining");
      this.oXX = true;
      AppMethodBeat.o(90909);
      return -9999;
    }
    if (this.oXB == d.oZl)
    {
      ad.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room! maybe is joining room");
      AppMethodBeat.o(90909);
      return 0;
    }
    int i = l.Bb(c(parama));
    cac();
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
  
  private int jJ(boolean paramBoolean)
  {
    AppMethodBeat.i(90911);
    ad.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: reset sync, sdkReset %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.oXw.ZK(this.kXS);
    o.oXm = 0;
    o.oXn = 0;
    o.oXo = 0;
    o.oXp = 0;
    o.oXq = 0;
    o.oXr = 0;
    o.oXs = 0;
    o.oXt = 0;
    o.oXu = 0;
    this.kXS = null;
    this.oXD = null;
    cab();
    this.mIsInit = false;
    m localm = m.oWZ;
    ad.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: stop listen to network change");
    localm.Bd(1);
    if (paramBoolean)
    {
      int i = l.bZZ();
      AppMethodBeat.o(90911);
      return i;
    }
    this.oXx.jI(false);
    this.hUx.sendEmptyMessage(272);
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
    ad.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: user triggered exit conference");
    af(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90866);
        int i = p.a(p.this, parama);
        if (i == -9999)
        {
          ad.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: pending exit. waiting for next time");
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
    ad.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set mute play: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    af(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184480);
        if (p.e(p.this) != p.d.oZn)
        {
          ad.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
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
  
  public final void af(Runnable paramRunnable)
  {
    AppMethodBeat.i(90905);
    if (this.knP.getSerialTag().equals(com.tencent.e.j.a.fVV()))
    {
      paramRunnable.run();
      AppMethodBeat.o(90905);
      return;
    }
    this.knP.post(paramRunnable);
    AppMethodBeat.o(90905);
  }
  
  public final void b(final boolean paramBoolean, final b<String> paramb)
  {
    AppMethodBeat.i(90913);
    ad.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set mute record: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    af(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184481);
        if (p.e(p.this) != p.d.oZn)
        {
          ad.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
          if (paramb != null)
          {
            paramb.a(-10086, -1001, "not in room", "");
            AppMethodBeat.o(184481);
            return;
          }
        }
        e locale = p.l(p.this);
        boolean bool = paramBoolean;
        locale.oWr = bool;
        p localp = p.oXv;
        String str;
        int i;
        if (bool)
        {
          str = "mute";
          ad.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: onMicMute %s", new Object[] { str });
          localp.af(new p.19(localp, bool));
          if (locale.oWf == null) {
            break label176;
          }
          locale.oWf.cw(bool);
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
    AppMethodBeat.i(190945);
    ad.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set handsFree: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    af(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190932);
        if (p.e(p.this) != p.d.oZn)
        {
          ad.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
          if (paramb != null)
          {
            paramb.a(-10086, -1001, "not in room", "");
            AppMethodBeat.o(190932);
            return;
          }
        }
        e locale = p.l(p.this);
        boolean bool = paramBoolean;
        bool = locale.oWe.oWw.iv(bool);
        if (paramb != null)
        {
          if (bool)
          {
            paramb.a(0, 0, "ok", "");
            AppMethodBeat.o(190932);
            return;
          }
          paramb.a(-10086, -15, "set handsFree failed", "");
        }
        AppMethodBeat.o(190932);
      }
    });
    AppMethodBeat.o(190945);
  }
  
  final void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(190947);
    int i;
    if (this.oYd) {
      if (cad() < 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (this.oYe)
      {
        if ((this.oYc != null) && (i == 0))
        {
          paramInt1 = this.oYc.b(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
          if (paramInt1 < 0)
          {
            ad.e("MicroMsg.OpenVoice.OpenVoiceService", "StopHWEnc!! hw encoder error: ".concat(String.valueOf(paramInt1)));
            this.oYe = false;
          }
          AppMethodBeat.o(190947);
          return;
          i = 0;
        }
      }
      else {
        l.c(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(190947);
      return;
      i = 0;
    }
  }
  
  public final void jK(final boolean paramBoolean)
  {
    AppMethodBeat.i(190946);
    if (paramBoolean) {}
    for (String str = "yes";; str = "no")
    {
      ad.i("MicroMsg.OpenVoice.OpenVoiceService", "onMicSwitch %s", new Object[] { str });
      af(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(190935);
          if (paramBoolean == p.w(p.this))
          {
            AppMethodBeat.o(190935);
            return;
          }
          p.c(p.this, paramBoolean);
          l.J(p.w(p.this), p.v(p.this));
          AppMethodBeat.o(190935);
        }
      });
      AppMethodBeat.o(190946);
      return;
    }
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(190949);
    if (this.oXA != null) {
      this.oXA.stop();
    }
    AppMethodBeat.o(190949);
  }
  
  public static enum a
  {
    public final int cyP;
    
    static
    {
      AppMethodBeat.i(90891);
      oZc = new a("ReasonInterrupted", 0, 0);
      oZd = new a("ReasonManual", 1, 1);
      oZe = new a("ReasonDevice", 2, 2);
      oZf = new a("ReasonInCommingCall", 3, 3);
      oZg = new a("ReasonSessionUpdateFailed", 4, 4);
      oZh = new a("ReasonWeappEnterBackground", 5, 5);
      oZi = new a("ReasonWeappStopFromPassiveFloatBall", 6, 6);
      oZj = new a("ReasonUnknown", 7, 100);
      oZk = new a[] { oZc, oZd, oZe, oZf, oZg, oZh, oZi, oZj };
      AppMethodBeat.o(90891);
    }
    
    private a(int paramInt)
    {
      this.cyP = paramInt;
    }
  }
  
  public static enum d
  {
    static
    {
      AppMethodBeat.i(90896);
      oZl = new d("NotInRoom", 0);
      oZm = new d("SdkInRoom", 1);
      oZn = new d("InRoom", 2);
      oZo = new d[] { oZl, oZm, oZn };
      AppMethodBeat.o(90896);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p
 * JD-Core Version:    0.7.0.1
 */