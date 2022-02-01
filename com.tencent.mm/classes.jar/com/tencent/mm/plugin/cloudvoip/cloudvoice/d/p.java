package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.bnd;
import com.tencent.mm.protocal.protobuf.yq;
import com.tencent.mm.protocal.protobuf.yr;
import com.tencent.mm.protocal.protobuf.ys;
import com.tencent.mm.protocal.protobuf.yu;
import com.tencent.mm.protocal.protobuf.yv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
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
  public ao hBR;
  private final ao jTB;
  private String kBL;
  private boolean mIsInit;
  private int mMaxHeight;
  private int mMaxWidth;
  private final j osL;
  private a oto;
  public boolean ouA;
  public boolean ouB;
  private boolean ouC;
  private b<String> ouD;
  public long ouE;
  private boolean ouF;
  private boolean ouG;
  public g ouH;
  public boolean ouI;
  public boolean ouJ;
  private boolean ouK;
  private boolean ouL;
  private boolean ouM;
  private final int ouN;
  public Runnable ouO;
  private final r oua;
  private final k oub;
  private final e ouc;
  public final s oud;
  public i oue;
  d ouf;
  private p.a oug;
  private String ouh;
  private String oui;
  private int ouj;
  public int ouk;
  private b<p.a> oul;
  private b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> oum;
  private b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> oun;
  private b<HashMap<String, LinkedList>> ouo;
  private k.a oup;
  private k.a ouq;
  private k.a our;
  private k.a ous;
  private k.a ouu;
  private k.a ouv;
  private k.a ouw;
  private k.a oux;
  private k.a ouy;
  private boolean ouz;
  
  static
  {
    AppMethodBeat.i(90930);
    otZ = new p("INSTANCE");
    ouP = new p[] { otZ };
    EMethodGetQosPara = 25;
    AppMethodBeat.o(90930);
  }
  
  private p()
  {
    AppMethodBeat.i(90899);
    this.ouj = 0;
    this.ouk = 1;
    this.mMaxWidth = 480;
    this.mMaxHeight = 640;
    this.ouA = false;
    this.ouB = false;
    this.ouE = -1L;
    this.ouF = false;
    this.ouG = false;
    this.ouH = null;
    this.oto = null;
    this.hBR = new ao(Looper.getMainLooper())
    {
      TelephonyManager ouQ;
      PhoneStateListener ouR;
      
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(184471);
        super.handleMessage(paramAnonymousMessage);
        if (paramAnonymousMessage.what == 272)
        {
          if (this.ouQ == null)
          {
            this.ouQ = ((TelephonyManager)ai.getContext().getSystemService("phone"));
            this.ouR = new PhoneStateListener()
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
                  p.this.ag(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(184469);
                      ac.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: hy: phone broken. exit room if in room");
                      p.a(p.this, p.a.ovK);
                      AppMethodBeat.o(184469);
                    }
                  });
                }
              }
            };
          }
          this.ouQ.listen(this.ouR, 32);
        }
        AppMethodBeat.o(184471);
      }
    };
    this.ouK = false;
    this.ouL = false;
    this.ouM = false;
    this.ouN = -9999;
    this.ouO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90866);
        if ((p.e(p.this) == p.d.ovQ) && (!p.a(p.this)))
        {
          ac.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: still not join room in %d ms. directly release", new Object[] { Long.valueOf(180000L) });
          p.u(p.this);
        }
        AppMethodBeat.o(90866);
      }
    };
    this.oua = new r();
    this.oub = new k();
    this.osL = new j();
    this.ouc = new e(this.osL);
    this.oud = new s(this.osL);
    this.oue = new i(ai.getContext());
    this.jTB = new ao("openvoice_voip_worker");
    this.ouf = d.ovQ;
    this.kBL = null;
    Object localObject = (Bundle)h.a("com.tencent.mm", null, p.b.class);
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("device_info", "");
      ac.v("MicroMsg.OpenVoice.OpenVoiceService", "hy: updatad device info %s", new Object[] { localObject });
      ae.st((String)localObject);
    }
    for (;;)
    {
      this.ouz = false;
      this.mIsInit = false;
      this.ouC = false;
      this.ouD = null;
      this.ouH = null;
      this.ouI = true;
      this.ouJ = false;
      this.oto = new a();
      AppMethodBeat.o(90899);
      return;
      ac.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: can not get device info from mm");
    }
  }
  
  static void Aw(int paramInt)
  {
    AppMethodBeat.i(90919);
    l.At(paramInt);
    AppMethodBeat.o(90919);
  }
  
  static int Q(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(90918);
    paramInt = l.P(paramArrayOfByte, paramInt);
    AppMethodBeat.o(90918);
    return paramInt;
  }
  
  private int Wc(String paramString)
  {
    AppMethodBeat.i(90901);
    IConfCallBack localIConfCallBack = this.oub.jx(true);
    int i = l.a(this.ouh, this.kBL, paramString, this.ouj, this.mMaxWidth, this.mMaxHeight, localIConfCallBack);
    this.ous = new k.a()
    {
      public final boolean bVt()
      {
        return true;
      }
    };
    this.oub.a(23, this.ous);
    AppMethodBeat.o(90901);
    return i;
  }
  
  private void a(b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> paramb)
  {
    AppMethodBeat.i(90902);
    ac.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: try trigger succ: %b %b %b", new Object[] { Boolean.valueOf(this.ouK), Boolean.valueOf(this.ouL), Boolean.valueOf(this.ouM) });
    if ((this.ouK) && (this.ouM) && (this.ouL))
    {
      int i;
      if (this.ouC)
      {
        ac.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: require exit. try exit exit again");
        a(paramb, -10086, -9, "interrupted because already cancelled or entered background");
        i = d(this.oug);
        if (this.ouD != null)
        {
          if (i != 0) {
            break label153;
          }
          this.ouD.a(0, 0, "ok", "");
        }
        for (;;)
        {
          this.ouC = false;
          this.ouD = null;
          AppMethodBeat.o(90902);
          return;
          label153:
          this.ouD.a(-10086, -17, "exit failed", "");
        }
      }
      this.oud.bVC();
      Object localObject = this.ouc;
      boolean bool;
      if (((e)localObject).osN != 2)
      {
        ac.e("MicroMsg.OpenVoice.OpenVoiceAudioMgr", "hy: error not init when start record!");
        i = 0;
        bool = this.ouc.Og();
        if ((i == 0) || (!bool)) {
          break label337;
        }
        j = 0;
        label230:
        o.otQ = j;
        if (i == 0) {
          break label342;
        }
        j = 0;
        label240:
        o.otS = j;
        if (!bool) {
          break label376;
        }
      }
      label337:
      label342:
      label376:
      for (int j = 0;; j = this.ouc.osJ.cVv)
      {
        o.otR = j;
        if ((i == 0) || (!bool)) {
          break label390;
        }
        this.ouA = true;
        a(paramb, 0, 0, "ok");
        AppMethodBeat.o(90902);
        return;
        if (((e)localObject).osI.a(new e.2((e)localObject), ((e)localObject).mSampleRate, ((e)localObject).mChannels, ((e)localObject).osW) <= 0)
        {
          ((e)localObject).osR = 1;
          i = 0;
          break;
        }
        i = 1;
        break;
        j = 1;
        break label230;
        localObject = this.ouc.osI.ota.osB;
        if (localObject != null)
        {
          j = ((com.tencent.mm.plugin.voip.model.c)localObject).ehj();
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
    this.ouz = false;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      this.ouf = d.ovS;
    }
    synchronized (this.oub)
    {
      this.oub.b(1, this.ouv);
      this.oub.b(2, this.ouw);
      this.oub.b(19, this.oux);
      this.oub.b(20, this.ouy);
      this.ouv = null;
      this.ouw = null;
      this.oux = null;
      this.ouy = null;
      ??? = this.osL.ots;
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
    if (l.Ar(paramb.osF) == 1)
    {
      AppMethodBeat.o(90915);
      return true;
    }
    AppMethodBeat.o(90915);
    return false;
  }
  
  static int aO(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(90914);
    int i = l.aN(paramArrayOfByte);
    AppMethodBeat.o(90914);
    return i;
  }
  
  private void ah(Runnable paramRunnable)
  {
    AppMethodBeat.i(90906);
    this.jTB.postDelayed(paramRunnable, 180000L);
    AppMethodBeat.o(90906);
  }
  
  private void b(b<ArrayList<com.tencent.mm.plugin.cloudvoip.cloudvoice.c.b>> paramb)
  {
    AppMethodBeat.i(90903);
    a(paramb, -10086, -7, "start audio device failed");
    d(p.a.ovJ);
    AppMethodBeat.o(90903);
  }
  
  private int bVA()
  {
    AppMethodBeat.i(200777);
    if (l.e(EMethodGetQosPara, this.oto.s2p, this.oto.s2p.length) >= 0)
    {
      this.oto.parseS2PData();
      this.oto.printS2P();
    }
    if (this.ouI) {
      if (8 == this.oto.osG) {
        this.ouJ = true;
      }
    }
    for (;;)
    {
      if (this.oto.osH == 0)
      {
        this.ouI = false;
        this.ouJ = false;
      }
      if ((1 != this.oto.cSkipFlag) && (this.ouI) && (this.ouJ)) {
        break;
      }
      AppMethodBeat.o(200777);
      return -1;
      this.ouJ = false;
      continue;
      this.ouJ = false;
    }
    if ((this.ouI) && (this.ouH == null)) {
      this.ouH = new g(this.oto.cFps, this.oto.iKbps, "video/avc");
    }
    for (;;)
    {
      AppMethodBeat.o(200777);
      return 0;
      this.ouH.a(this.oto);
    }
  }
  
  private boolean bVB()
  {
    AppMethodBeat.i(200779);
    if (this.oue != null)
    {
      boolean bool = this.oue.Na();
      AppMethodBeat.o(200779);
      return bool;
    }
    AppMethodBeat.o(200779);
    return true;
  }
  
  private void bVw()
  {
    this.ouK = false;
    this.ouL = false;
    this.ouM = false;
  }
  
  /* Error */
  private void bVx()
  {
    // Byte code:
    //   0: ldc_w 899
    //   3: invokestatic 174	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 258	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:osL	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/j;
    //   10: getfield 527	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/j:ots	Ljava/util/ArrayList;
    //   13: invokevirtual 557	java/util/ArrayList:clear	()V
    //   16: aload_0
    //   17: getfield 258	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:osL	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/j;
    //   20: astore_2
    //   21: aload_2
    //   22: getfield 573	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/j:otu	Ljava/util/ArrayList;
    //   25: astore_1
    //   26: aload_1
    //   27: monitorenter
    //   28: aload_2
    //   29: getfield 573	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/j:otu	Ljava/util/ArrayList;
    //   32: invokevirtual 557	java/util/ArrayList:clear	()V
    //   35: aload_1
    //   36: monitorexit
    //   37: aload_2
    //   38: getfield 589	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/j:otv	Ljava/util/Timer;
    //   41: ifnull +10 -> 51
    //   44: aload_2
    //   45: getfield 589	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/j:otv	Ljava/util/Timer;
    //   48: invokevirtual 902	java/util/Timer:cancel	()V
    //   51: aload_0
    //   52: getfield 265	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:ouc	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/e;
    //   55: astore_2
    //   56: aload_2
    //   57: getfield 458	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:osI	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/f;
    //   60: ifnull +137 -> 197
    //   63: aload_2
    //   64: getfield 458	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:osI	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/f;
    //   67: astore_3
    //   68: aload_3
    //   69: getfield 906	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:osZ	Ljava/lang/Object;
    //   72: astore_1
    //   73: aload_1
    //   74: monitorenter
    //   75: ldc_w 908
    //   78: ldc_w 910
    //   81: iconst_2
    //   82: anewarray 321	java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: aload_3
    //   88: getfield 913	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:isStart	Z
    //   91: invokestatic 406	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: aload_3
    //   98: invokevirtual 916	java/lang/Object:hashCode	()I
    //   101: invokestatic 921	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   104: aastore
    //   105: invokestatic 408	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_3
    //   109: getfield 913	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:isStart	Z
    //   112: ifeq +83 -> 195
    //   115: aload_3
    //   116: getfield 484	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:ota	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/b/a;
    //   119: astore 4
    //   121: aload 4
    //   123: getfield 490	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:osB	Lcom/tencent/mm/plugin/voip/model/c;
    //   126: astore 5
    //   128: aload 5
    //   130: ifnull +21 -> 151
    //   133: aload 5
    //   135: invokevirtual 924	com/tencent/mm/plugin/voip/model/c:ehi	()I
    //   138: pop
    //   139: aload 5
    //   141: invokevirtual 927	com/tencent/mm/plugin/voip/model/c:ehf	()I
    //   144: pop
    //   145: aload 4
    //   147: aconst_null
    //   148: putfield 490	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:osB	Lcom/tencent/mm/plugin/voip/model/c;
    //   151: aload_3
    //   152: getfield 931	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:otb	Lcom/tencent/mm/compatible/util/f$a;
    //   155: invokestatic 936	android/os/SystemClock:elapsedRealtime	()J
    //   158: putfield 941	com/tencent/mm/compatible/util/f$a:fJW	J
    //   161: ldc_w 908
    //   164: new 943	java/lang/StringBuilder
    //   167: dup
    //   168: ldc_w 945
    //   171: invokespecial 946	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   174: aload_3
    //   175: getfield 931	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:otb	Lcom/tencent/mm/compatible/util/f$a;
    //   178: invokevirtual 949	com/tencent/mm/compatible/util/f$a:YH	()J
    //   181: invokevirtual 953	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   184: invokevirtual 957	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 543	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload_3
    //   191: iconst_0
    //   192: putfield 913	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:isStart	Z
    //   195: aload_1
    //   196: monitorexit
    //   197: aload_2
    //   198: iconst_0
    //   199: putfield 960	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:mIsPlayMute	Z
    //   202: aload_2
    //   203: getfield 500	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:osJ	Lcom/tencent/mm/audio/b/c;
    //   206: ifnull +25 -> 231
    //   209: aload_2
    //   210: getfield 500	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:osJ	Lcom/tencent/mm/audio/b/c;
    //   213: invokevirtual 963	com/tencent/mm/audio/b/c:NX	()Z
    //   216: pop
    //   217: aload_2
    //   218: aconst_null
    //   219: putfield 500	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:osJ	Lcom/tencent/mm/audio/b/c;
    //   222: ldc_w 438
    //   225: ldc_w 965
    //   228: invokestatic 543	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: getstatic 182	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:otZ	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/p;
    //   234: iconst_0
    //   235: invokevirtual 969	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:jz	(Z)V
    //   238: aload_2
    //   239: getstatic 972	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:osM	I
    //   242: putfield 436	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:osN	I
    //   245: aload_2
    //   246: getfield 458	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/e:osI	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/f;
    //   249: getfield 484	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/f:ota	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/b/a;
    //   252: astore_1
    //   253: aload_1
    //   254: invokevirtual 975	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:bCr	()V
    //   257: aload_1
    //   258: ldc_w 977
    //   261: invokevirtual 980	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:Sl	(Ljava/lang/String;)V
    //   264: aload_1
    //   265: getfield 984	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:ied	Lcom/tencent/mm/compatible/util/b;
    //   268: invokevirtual 989	com/tencent/mm/compatible/util/b:YC	()Z
    //   271: pop
    //   272: invokestatic 994	com/tencent/mm/plugin/audio/c/a:bAg	()V
    //   275: invokestatic 997	com/tencent/mm/plugin/cloudvoip/cloudvoice/b/a:unInit	()V
    //   278: aload_0
    //   279: getfield 270	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oud	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/s;
    //   282: astore_1
    //   283: ldc_w 999
    //   286: ldc_w 1001
    //   289: invokestatic 353	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: aload_1
    //   293: monitorenter
    //   294: aload_1
    //   295: getfield 1004	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/s:mStarted	Z
    //   298: ifne +133 -> 431
    //   301: aload_1
    //   302: monitorexit
    //   303: aload_0
    //   304: getfield 253	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oub	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   307: astore_1
    //   308: aload_1
    //   309: monitorenter
    //   310: aload_0
    //   311: getfield 253	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oub	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   314: bipush 21
    //   316: aload_0
    //   317: getfield 566	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oup	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   320: invokevirtual 517	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;)V
    //   323: aload_0
    //   324: getfield 253	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oub	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   327: bipush 22
    //   329: aload_0
    //   330: getfield 569	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:ouq	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   333: invokevirtual 517	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;)V
    //   336: aload_0
    //   337: getfield 253	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oub	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   340: bipush 17
    //   342: aload_0
    //   343: getfield 560	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:our	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   346: invokevirtual 517	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;)V
    //   349: aload_0
    //   350: getfield 253	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oub	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   353: bipush 18
    //   355: aload_0
    //   356: getfield 563	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:ouu	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   359: invokevirtual 517	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;)V
    //   362: aload_0
    //   363: getfield 253	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oub	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k;
    //   366: bipush 23
    //   368: aload_0
    //   369: getfield 382	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:ous	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   372: invokevirtual 517	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/k:b	(ILcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;)V
    //   375: aload_0
    //   376: aconst_null
    //   377: putfield 566	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:oup	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   380: aload_0
    //   381: aconst_null
    //   382: putfield 569	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:ouq	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   385: aload_0
    //   386: aconst_null
    //   387: putfield 560	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:our	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   390: aload_0
    //   391: aconst_null
    //   392: putfield 563	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:ouu	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   395: aload_0
    //   396: aconst_null
    //   397: putfield 382	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/p:ous	Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/d/k$a;
    //   400: aload_1
    //   401: monitorexit
    //   402: ldc_w 899
    //   405: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   408: return
    //   409: astore_2
    //   410: aload_1
    //   411: monitorexit
    //   412: ldc_w 899
    //   415: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   418: aload_2
    //   419: athrow
    //   420: astore_2
    //   421: aload_1
    //   422: monitorexit
    //   423: ldc_w 899
    //   426: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   429: aload_2
    //   430: athrow
    //   431: aload_1
    //   432: iconst_0
    //   433: putfield 1004	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/s:mStarted	Z
    //   436: aload_1
    //   437: monitorexit
    //   438: aload_1
    //   439: getfield 1007	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/s:mTimer	Ljava/util/Timer;
    //   442: ifnull +15 -> 457
    //   445: aload_1
    //   446: getfield 1007	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/s:mTimer	Ljava/util/Timer;
    //   449: invokevirtual 902	java/util/Timer:cancel	()V
    //   452: aload_1
    //   453: aconst_null
    //   454: putfield 1007	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/s:mTimer	Ljava/util/Timer;
    //   457: aload_1
    //   458: getfield 1010	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/s:owd	Ljava/util/Map;
    //   461: astore_2
    //   462: aload_2
    //   463: monitorenter
    //   464: aload_1
    //   465: getfield 1010	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/s:owd	Ljava/util/Map;
    //   468: invokeinterface 1011 1 0
    //   473: aload_2
    //   474: monitorexit
    //   475: goto -172 -> 303
    //   478: astore_1
    //   479: aload_2
    //   480: monitorexit
    //   481: ldc_w 899
    //   484: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   487: aload_1
    //   488: athrow
    //   489: astore_1
    //   490: ldc_w 999
    //   493: new 943	java/lang/StringBuilder
    //   496: dup
    //   497: ldc_w 1013
    //   500: invokespecial 946	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   503: aload_1
    //   504: invokevirtual 1014	java/lang/Exception:toString	()Ljava/lang/String;
    //   507: invokevirtual 1017	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: invokevirtual 957	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokestatic 353	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   516: goto -213 -> 303
    //   519: astore_2
    //   520: aload_1
    //   521: monitorexit
    //   522: ldc_w 899
    //   525: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   528: aload_2
    //   529: athrow
    //   530: astore_2
    //   531: aload_1
    //   532: monitorexit
    //   533: ldc_w 899
    //   536: invokestatic 189	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private void bVy()
  {
    AppMethodBeat.i(90910);
    ah(this.ouO);
    AppMethodBeat.o(90910);
  }
  
  private static int c(p.a parama)
  {
    AppMethodBeat.i(90908);
    switch (p.19.kEX[parama.ordinal()])
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
  
  private int d(p.a parama)
  {
    AppMethodBeat.i(90909);
    this.ouA = false;
    aw.aKT(this.kBL + "_wxa_voip").putBoolean("isCameraStart", false);
    ac.i("MicroMsg.OpenVoice.OpenVoiceService", "appId:%s, exitConferenceSync set isCameraStart false", new Object[] { this.kBL });
    if (!bVB())
    {
      ac.i("MicroMsg.OpenVoice.OpenVoiceService", "exitConferenceSync, stop ring");
      stopRing();
    }
    ac.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: trigger exit with reason: %s", new Object[] { parama });
    this.oug = parama;
    if (this.ouz)
    {
      ac.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: current joining room. waiting for exiting after joining");
      this.ouC = true;
      AppMethodBeat.o(90909);
      return -9999;
    }
    if (this.ouf == d.ovQ)
    {
      ac.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room! maybe is joining room");
      AppMethodBeat.o(90909);
      return 0;
    }
    int i = l.As(c(parama));
    bVy();
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
  
  private int jy(boolean paramBoolean)
  {
    AppMethodBeat.i(90911);
    ac.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: reset sync, sdkReset %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.oua.Wd(this.kBL);
    o.otQ = 0;
    o.otR = 0;
    o.otS = 0;
    o.otT = 0;
    o.otU = 0;
    o.otV = 0;
    o.otW = 0;
    o.otX = 0;
    o.otY = 0;
    this.kBL = null;
    this.ouh = null;
    bVx();
    this.mIsInit = false;
    m localm = m.otD;
    ac.i("MicroMsg.OpenVoice.OpenVoiceNetworkMgr", "hy: stop listen to network change");
    localm.Au(1);
    if (paramBoolean)
    {
      int i = l.bVv();
      AppMethodBeat.o(90911);
      return i;
    }
    this.oub.jx(false);
    this.hBR.sendEmptyMessage(272);
    AppMethodBeat.o(90911);
    return 0;
  }
  
  static void w(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90916);
    l.v(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(90916);
  }
  
  public final void a(final b<String> paramb, final p.a parama)
  {
    AppMethodBeat.i(90907);
    ac.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: user triggered exit conference");
    ag(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90865);
        int i = p.a(p.this, parama);
        if (i == -9999)
        {
          ac.w("MicroMsg.OpenVoice.OpenVoiceService", "hy: pending exit. waiting for next time");
          p.b(p.this, paramb);
          AppMethodBeat.o(90865);
          return;
        }
        if (paramb != null)
        {
          if (i == 0)
          {
            paramb.a(0, 0, "", "");
            AppMethodBeat.o(90865);
            return;
          }
          paramb.a(-10086, -17, "exit failed", "");
        }
        AppMethodBeat.o(90865);
      }
    });
    AppMethodBeat.o(90907);
  }
  
  public final void a(final boolean paramBoolean, final b<String> paramb)
  {
    AppMethodBeat.i(90912);
    ac.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set mute play: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ag(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(90868);
        if (p.e(p.this) != p.d.ovS)
        {
          ac.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
          if (paramb != null)
          {
            paramb.a(-10086, -1001, "not in room", "");
            AppMethodBeat.o(90868);
            return;
          }
        }
        p.l(p.this).mIsPlayMute = paramBoolean;
        if (paramb != null) {
          paramb.a(0, 0, "ok", "");
        }
        AppMethodBeat.o(90868);
      }
    });
    AppMethodBeat.o(90912);
  }
  
  public final void ag(Runnable paramRunnable)
  {
    AppMethodBeat.i(90905);
    if (this.jTB.getSerialTag().equals(com.tencent.e.j.a.fED()))
    {
      paramRunnable.run();
      AppMethodBeat.o(90905);
      return;
    }
    this.jTB.post(paramRunnable);
    AppMethodBeat.o(90905);
  }
  
  public final void b(final boolean paramBoolean, final b<String> paramb)
  {
    AppMethodBeat.i(90913);
    ac.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set mute record: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ag(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184480);
        if (p.e(p.this) != p.d.ovS)
        {
          ac.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
          if (paramb != null)
          {
            paramb.a(-10086, -1001, "not in room", "");
            AppMethodBeat.o(184480);
            return;
          }
        }
        e locale = p.l(p.this);
        boolean bool = paramBoolean;
        locale.osV = bool;
        p localp = p.otZ;
        String str;
        int i;
        if (bool)
        {
          str = "mute";
          ac.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: onMicMute %s", new Object[] { str });
          localp.ag(new p.18(localp, bool));
          if (locale.osJ == null) {
            break label176;
          }
          locale.osJ.cu(bool);
          i = 1;
        }
        for (;;)
        {
          if (paramb != null)
          {
            if (i != 0)
            {
              paramb.a(0, 0, "ok", "");
              AppMethodBeat.o(184480);
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
        AppMethodBeat.o(184480);
      }
    });
    AppMethodBeat.o(90913);
  }
  
  public final boolean bVz()
  {
    AppMethodBeat.i(200774);
    if (this.ouf == d.ovS)
    {
      boolean bool = this.ouc.bVp();
      AppMethodBeat.o(200774);
      return bool;
    }
    AppMethodBeat.o(200774);
    return false;
  }
  
  public final void c(final boolean paramBoolean, final b<String> paramb)
  {
    AppMethodBeat.i(200773);
    ac.i("MicroMsg.OpenVoice.OpenVoiceService", "hy: set handsFree: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ag(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(184481);
        if (p.e(p.this) != p.d.ovS)
        {
          ac.e("MicroMsg.OpenVoice.OpenVoiceService", "hy: not in room!");
          if (paramb != null)
          {
            paramb.a(-10086, -1001, "not in room", "");
            AppMethodBeat.o(184481);
            return;
          }
        }
        e locale = p.l(p.this);
        boolean bool = paramBoolean;
        bool = locale.osI.ota.im(bool);
        if (paramb != null)
        {
          if (bool)
          {
            paramb.a(0, 0, "ok", "");
            AppMethodBeat.o(184481);
            return;
          }
          paramb.a(-10086, -15, "set handsFree failed", "");
        }
        AppMethodBeat.o(184481);
      }
    });
    AppMethodBeat.o(200773);
  }
  
  final void d(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(200776);
    int i;
    if (this.ouI) {
      if (bVA() < 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (this.ouJ)
      {
        if ((this.ouH != null) && (i == 0))
        {
          paramInt1 = this.ouH.b(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
          if (paramInt1 < 0)
          {
            ac.e("MicroMsg.OpenVoice.OpenVoiceService", "StopHWEnc!! hw encoder error: ".concat(String.valueOf(paramInt1)));
            this.ouJ = false;
          }
          AppMethodBeat.o(200776);
          return;
          i = 0;
        }
      }
      else {
        l.c(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(200776);
      return;
      i = 0;
    }
  }
  
  public final void jz(final boolean paramBoolean)
  {
    AppMethodBeat.i(200775);
    if (paramBoolean) {}
    for (String str = "yes";; str = "no")
    {
      ac.i("MicroMsg.OpenVoice.OpenVoiceService", "onMicSwitch %s", new Object[] { str });
      ag(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(200761);
          if (paramBoolean == p.w(p.this))
          {
            AppMethodBeat.o(200761);
            return;
          }
          p.c(p.this, paramBoolean);
          l.I(p.w(p.this), p.v(p.this));
          AppMethodBeat.o(200761);
        }
      });
      AppMethodBeat.o(200775);
      return;
    }
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(200778);
    if (this.oue != null) {
      this.oue.stop();
    }
    AppMethodBeat.o(200778);
  }
  
  static enum d
  {
    static
    {
      AppMethodBeat.i(90896);
      ovQ = new d("NotInRoom", 0);
      ovR = new d("SdkInRoom", 1);
      ovS = new d("InRoom", 2);
      ovT = new d[] { ovQ, ovR, ovS };
      AppMethodBeat.o(90896);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p
 * JD-Core Version:    0.7.0.1
 */