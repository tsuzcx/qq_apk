package com.tencent.mm.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.z;
import com.tencent.mm.b.i;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.cj;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.av;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.ba;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.o;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class a
{
  private static boolean ggB;
  private static boolean ggC;
  static b ggE;
  private static String ggF;
  private static String ggG;
  private static boolean ggH;
  private static int ggQ;
  private z ggA;
  byte[] ggD;
  public com.tencent.mm.model.a ggI;
  public e.c ggJ;
  public int ggK;
  public boolean ggL;
  private boolean ggM;
  public int ggN;
  public int ggO;
  private List<av> ggP;
  long ggR;
  private volatile a ggS;
  public volatile boolean ggT;
  private String ggU;
  private Map<String, Integer> ggV;
  private com.tencent.mm.kernel.api.c ggz;
  
  static
  {
    AppMethodBeat.i(132045);
    ggB = true;
    ggC = false;
    ggE = new b();
    ggF = "NoResetUinStack";
    ggG = null;
    ggQ = -1;
    AppMethodBeat.o(132045);
  }
  
  public a(com.tencent.mm.kernel.api.c paramc)
  {
    AppMethodBeat.i(132014);
    this.ggD = new byte[0];
    this.ggL = false;
    this.ggM = false;
    this.ggN = 0;
    this.ggP = new LinkedList();
    this.ggS = a.ggX;
    this.ggT = false;
    this.ggU = "";
    this.ggV = new HashMap();
    Assert.assertNotNull(ggE);
    g.agS();
    boolean bool;
    if (bs.m((Integer)g.agR().ghx.get(17)) != 0)
    {
      bool = true;
      ggB = bool;
      if (!f.DIl) {
        break label144;
      }
    }
    label144:
    for (int i = 763;; i = 702)
    {
      com.tencent.mm.protocal.j.e.a.DIH = new ba(i);
      this.ggz = paramc;
      AppMethodBeat.o(132014);
      return;
      bool = false;
      break;
    }
  }
  
  public static SharedPreferences Zc()
  {
    AppMethodBeat.i(132035);
    SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("notify_key_pref_settings", com.tencent.mm.compatible.util.g.YK());
    AppMethodBeat.o(132035);
    return localSharedPreferences;
  }
  
  public static String afE()
  {
    AppMethodBeat.i(132016);
    String str = new p(b.a(ggE)).toString();
    AppMethodBeat.o(132016);
    return str;
  }
  
  public static final int afF()
  {
    AppMethodBeat.i(206877);
    int i = b.access$100();
    AppMethodBeat.o(206877);
    return i;
  }
  
  public static String afG()
  {
    return ggG;
  }
  
  public static boolean afH()
  {
    return ggH;
  }
  
  public static void afI()
  {
    ggH = true;
  }
  
  public static String afJ()
  {
    return ggF;
  }
  
  protected static void afK()
  {
    AppMethodBeat.i(132017);
    b.a(ggE, 0);
    AppMethodBeat.o(132017);
  }
  
  protected static void afL()
  {
    AppMethodBeat.i(132018);
    b.a(ggE, 0);
    AppMethodBeat.o(132018);
  }
  
  private void afM()
  {
    AppMethodBeat.i(132019);
    this.ggS = a.ggX;
    this.ggT = false;
    ac.i("MMKernel.CoreAccount", "mAccountStatus to NotReady");
    ai.getContext().getSharedPreferences(ai.eUX(), 0).edit().putBoolean("isLogin", false).commit();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
    ac.w("MMKernel.CoreAccount", "[arthurdan.AccountNR] account storage reset! uin:%d, resetStack is:%s, resetTime:%s", new Object[] { Integer.valueOf(b.a(ggE)), ggF, localSimpleDateFormat.format(new Date()) });
    AppMethodBeat.o(132019);
  }
  
  public static boolean afR()
  {
    return ggC;
  }
  
  public static boolean afS()
  {
    AppMethodBeat.i(132025);
    if (ggB)
    {
      g.agS();
      if (g.agP() == null) {
        break label80;
      }
      g.agS();
      g.agP();
    }
    label80:
    for (String str = p.getString(b.a(ggE));; str = "-1")
    {
      ac.w("MMKernel.CoreAccount", "account holded :%s init:%b", new Object[] { str, Boolean.valueOf(g.agP().afY()) });
      boolean bool = ggB;
      AppMethodBeat.o(132025);
      return bool;
    }
  }
  
  public static int afV()
  {
    AppMethodBeat.i(132034);
    int i = Zc().getInt("notification.user.state", 0);
    AppMethodBeat.o(132034);
    return i;
  }
  
  public static boolean afX()
  {
    AppMethodBeat.i(132039);
    if (b.a(ggE) != 0)
    {
      AppMethodBeat.o(132039);
      return true;
    }
    AppMethodBeat.o(132039);
    return false;
  }
  
  public static int agb()
  {
    AppMethodBeat.i(132041);
    int i = ai.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.YK()).getInt("default_uin", 0);
    AppMethodBeat.o(132041);
    return i;
  }
  
  public static String agc()
  {
    AppMethodBeat.i(132042);
    g.agS();
    if (bs.isNullOrNil(g.agP().ggU)) {
      agd();
    }
    g.agS();
    String str = g.agP().ggU;
    AppMethodBeat.o(132042);
    return str;
  }
  
  public static void agd()
  {
    AppMethodBeat.i(132043);
    g.agS();
    g.agP().ggU = (com.tencent.mm.compatible.deviceinfo.q.XX() + "_" + System.currentTimeMillis());
    g.agS();
    g.agP().ggV.clear();
    AppMethodBeat.o(132043);
  }
  
  public static void dz(boolean paramBoolean)
  {
    ggC = paramBoolean;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(132015);
    int i = b.a(ggE);
    AppMethodBeat.o(132015);
    return i;
  }
  
  public static void hold()
  {
    AppMethodBeat.i(132026);
    g.agS();
    if (g.agP() != null)
    {
      g.agS();
      g.agP();
    }
    for (String str = p.getString(b.a(ggE));; str = "-1")
    {
      ac.w("MMKernel.CoreAccount", " HOLD ACCOUNT! uin:%s stack:%s init:%b", new Object[] { str, bs.eWi(), Boolean.valueOf(g.agP().afY()) });
      ggB = true;
      g.agS();
      g.agR().ghx.set(17, Integer.valueOf(1));
      AppMethodBeat.o(132026);
      return;
    }
  }
  
  static boolean mm(int paramInt)
  {
    return paramInt != 0;
  }
  
  public static void mn(int paramInt)
  {
    AppMethodBeat.i(132033);
    if ((ggQ != -1) && (ggQ == paramInt))
    {
      AppMethodBeat.o(132033);
      return;
    }
    ggQ = paramInt;
    Zc().edit().putInt("notification.user.state", paramInt).commit();
    ac.i("MMKernel.CoreAccount", "[NOTIFICATION SETTINGS]save UserStatus: %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(132033);
  }
  
  public static boolean mo(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static String ua(String paramString)
  {
    ggG = paramString;
    return paramString;
  }
  
  public static void ub(String paramString)
  {
    ggF = paramString;
  }
  
  public static int uc(String paramString)
  {
    AppMethodBeat.i(132044);
    g.agS();
    if (g.agP().ggV.get(paramString) == null) {}
    int j;
    for (int i = 0;; i = ((Integer)g.agP().ggV.get(paramString)).intValue())
    {
      j = (int)bs.aNx();
      if (i != 0) {
        break;
      }
      g.agS();
      g.agP().ggV.put(paramString, Integer.valueOf(j));
      AppMethodBeat.o(132044);
      return i;
      g.agS();
    }
    i = j - i;
    g.agS();
    g.agP().ggV.put(paramString, Integer.valueOf(j));
    if (i >= 0)
    {
      AppMethodBeat.o(132044);
      return i;
    }
    AppMethodBeat.o(132044);
    return 0;
  }
  
  public static void unhold()
  {
    AppMethodBeat.i(132027);
    g.agS();
    if (g.agP() != null)
    {
      g.agS();
      g.agP();
    }
    for (String str = p.getString(b.a(ggE));; str = "-1")
    {
      ac.w("MMKernel.CoreAccount", " UN HOLD ACCOUNT! uin:%s init:%b", new Object[] { str, Boolean.valueOf(g.agP().afY()) });
      ggB = false;
      g.agS();
      g.agR().ghx.set(17, Integer.valueOf(0));
      AppMethodBeat.o(132027);
      return;
    }
  }
  
  public final void a(av paramav)
  {
    AppMethodBeat.i(132029);
    ac.i("MMKernel.CoreAccount", "UserStatusChange: add %s", new Object[] { paramav });
    synchronized (this.ggP)
    {
      if (!this.ggP.contains(paramav)) {
        this.ggP.add(paramav);
      }
      AppMethodBeat.o(132029);
      return;
    }
  }
  
  final void afN()
  {
    AppMethodBeat.i(132020);
    ac.w("MMKernel.CoreAccount", "account storage release  uin:%s thread:%s stack:%s", new Object[] { p.getString(b.a(ggE)), Thread.currentThread().getName(), bs.eWi() });
    if (!afY())
    {
      ac.i("MMKernel.CoreAccount", "Fatal crash error!!! status is not initialized when release(), this callStack is:%s, last reset stack is:%s", new Object[] { bs.eWi().toString(), ggF });
      AppMethodBeat.o(132020);
      return;
    }
    this.ggz.onAccountRelease();
    g.agS();
    g.agR().ro(null);
    afM();
    g.agS();
    g.agR().ghO.clear();
    AppMethodBeat.o(132020);
  }
  
  public final void afO()
  {
    AppMethodBeat.i(132022);
    if (!this.ggM)
    {
      ac.i("MMKernel.CoreAccount", "no need do account initialized notify.");
      AppMethodBeat.o(132022);
      return;
    }
    this.ggM = false;
    ac.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized tid:%d, stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), bs.eWi() });
    long l = System.currentTimeMillis();
    this.ggz.onAccountInitialized(this.ggJ);
    ac.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized run tid[%d] take[%d]ms", new Object[] { Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l) });
    afP();
    AppMethodBeat.o(132022);
  }
  
  public final void afP()
  {
    AppMethodBeat.i(132023);
    if ((afY()) && (com.tencent.mm.kernel.a.c.ahe().giV))
    {
      ac.i("MMKernel.CoreAccount", "Flush client version.");
      g.agR().agr();
    }
    AppMethodBeat.o(132023);
  }
  
  public final z afQ()
  {
    try
    {
      AppMethodBeat.i(132024);
      if (this.ggA == null) {
        this.ggA = new z();
      }
      z localz = this.ggA;
      AppMethodBeat.o(132024);
      return localz;
    }
    finally {}
  }
  
  public final void afT()
  {
    AppMethodBeat.i(132028);
    if (!afY())
    {
      com.tencent.mm.model.b localb = new com.tencent.mm.model.b();
      AppMethodBeat.o(132028);
      throw localb;
    }
    AppMethodBeat.o(132028);
  }
  
  public final void afU()
  {
    AppMethodBeat.i(132031);
    new ao(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132002);
        av[] arrayOfav = new av[a.b(a.this).size()];
        a.b(a.this).toArray(arrayOfav);
        int j = arrayOfav.length;
        int i = 0;
        while (i < j)
        {
          arrayOfav[i].ayD();
          i += 1;
        }
        AppMethodBeat.o(132002);
      }
    });
    AppMethodBeat.o(132031);
  }
  
  public final boolean afW()
  {
    AppMethodBeat.i(132036);
    boolean bool = mo(this.ggN);
    AppMethodBeat.o(132036);
    return bool;
  }
  
  public final boolean afY()
  {
    return this.ggS == a.ggY;
  }
  
  public final boolean afZ()
  {
    return this.ggT;
  }
  
  public final void aga()
  {
    AppMethodBeat.i(132040);
    ac.i("MMKernel.CoreAccount", "summerasyncinit setInitializedNotifyAllDone[%b] to true stack[%s]", new Object[] { Boolean.valueOf(this.ggT), bs.eWi() });
    this.ggT = true;
    long l = SystemClock.elapsedRealtime();
    ac.i("MMKernel.CoreAccount", "summerhardcoder setInitializedNotifyAllDone [%d %d] take[%d]ms, stack[%s]", new Object[] { Long.valueOf(this.ggR), Long.valueOf(l), Long.valueOf(l - this.ggR), bs.eWi() });
    com.tencent.mm.g.a.ci localci = new com.tencent.mm.g.a.ci();
    com.tencent.mm.sdk.b.a.GpY.l(localci);
    AppMethodBeat.o(132040);
  }
  
  public final void b(av paramav)
  {
    AppMethodBeat.i(132030);
    ac.i("MMKernel.CoreAccount", "UserStatusChange: remove %s", new Object[] { paramav });
    synchronized (this.ggP)
    {
      this.ggP.remove(paramav);
      AppMethodBeat.o(132030);
      return;
    }
  }
  
  public final void cM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132032);
    if ((this.ggN != paramInt1) || (this.ggO != paramInt2)) {}
    for (int i = 1;; i = 0)
    {
      ac.d("MMKernel.CoreAccount", "online status, %d, %d, %d ,%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.ggO), Integer.valueOf(this.ggN) });
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(132032);
      return;
    }
    this.ggN = paramInt1;
    this.ggO = paramInt2;
    new ao(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132003);
        a.this.afU();
        AppMethodBeat.o(132003);
      }
    });
    AppMethodBeat.o(132032);
  }
  
  final void dy(boolean paramBoolean)
  {
    AppMethodBeat.i(132021);
    boolean bool1;
    int j;
    int k;
    int m;
    int i;
    if (!paramBoolean)
    {
      bool1 = WXHardCoderJNI.hcBootEnable;
      j = WXHardCoderJNI.hcBootDelay;
      k = WXHardCoderJNI.hcBootCPU;
      m = WXHardCoderJNI.hcBootIO;
      if (WXHardCoderJNI.hcBootThr)
      {
        i = g.agU().eVl();
        this.ggK = WXHardCoderJNI.startPerformance(bool1, j, k, m, i, WXHardCoderJNI.hcBootTimeout, 101, WXHardCoderJNI.hcBootAction, "MMKernel.CoreAccount");
        ac.i("MMKernel.CoreAccount", "summerhardcoder startPerformance[%s] stack[%s]", new Object[] { Integer.valueOf(this.ggK), bs.eWi() });
      }
    }
    else
    {
      ac.i("MMKernel.CoreAccount", "UserStatusChange: clear");
    }
    for (;;)
    {
      synchronized (this.ggP)
      {
        this.ggP.clear();
        long l1 = System.currentTimeMillis();
        k = b.a(ggE);
        ac.i("MMKernel.CoreAccount", "dkacc setAccuin %s hash:%d thread:%d[%s] stack:%s", new Object[] { p.getString(k), Integer.valueOf(i.cc(k, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), bs.eWi() });
        if (k != 0)
        {
          i = 1;
          if (i != 0) {
            break;
          }
          ac.w("MMKernel.CoreAccount", "setAccUin, Reset by MMCore.resetAccUin");
          ac.i("MMKernel.CoreAccount", "start time check setUinImpl end total time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
          ac.i("MMKernel.CoreAccount", "mAccountStatus to AccountHasReady");
          AppMethodBeat.o(132021);
          return;
          i = 0;
        }
      }
      i = 0;
    }
    p.getString(k);
    com.tencent.mm.sdk.a.b.eUh();
    g.agS();
    e locale = g.agR();
    Object localObject5 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132001);
        a.a(a.this);
        AppMethodBeat.o(132001);
      }
    };
    ai.getContext().getSharedPreferences(ai.eUX(), 0).edit().putBoolean("isLogin", true).apply();
    ??? = com.tencent.mm.b.g.getMessageDigest("mm".concat(String.valueOf(k)).getBytes());
    Object localObject3 = e.C(k, (String)???);
    ac.i("MMKernel.CoreStorage", "uinPath: %s, uinSaltPath: %s", new Object[] { ???, localObject3 });
    boolean bool4 = com.tencent.mm.compatible.util.e.YD();
    label411:
    Object localObject4;
    label461:
    long l2;
    label513:
    Object localObject6;
    if (localObject3 == null)
    {
      ac.w("MMKernel.CoreStorage", "Cannot generate account path, skip account renaming!");
      i = 6;
      bool1 = false;
      locale.ghD = ((String)???);
      locale.cachePath = (ah.GDu + locale.ghD + '/');
      if (!bool1) {
        break label1200;
      }
      localObject4 = localObject3;
      locale.ghF = ((String)localObject4);
      locale.ghC = (locale.ghB + locale.ghF + '/');
      if (localObject3 != null) {
        break label1207;
      }
      localObject4 = ???;
      locale.ghE = ((String)localObject4);
      o.adt(i);
      localObject4 = new com.tencent.mm.vfs.e(locale.cachePath);
      ac.i("MMKernel.CoreStorage", "dkacc cachePath:" + locale.cachePath + " accPath:" + locale.ghC);
      if (((com.tencent.mm.vfs.e)localObject4).exists()) {
        break label2982;
      }
      ac.w("MMKernel.CoreStorage", "setUin REBUILD data now ! DO NOT FUCKING TELL ME DB BROKEN !!! uin:%s data:%s sd:%s", new Object[] { p.getString(k), locale.cachePath, locale.ghC });
      ((com.tencent.mm.vfs.e)localObject4).mkdirs();
      if (!locale.cachePath.equalsIgnoreCase(locale.ghC))
      {
        l2 = System.currentTimeMillis();
        localObject4 = new com.tencent.mm.vfs.e(locale.ghC);
        localObject6 = (String)??? + "temp" + System.currentTimeMillis();
        localObject6 = com.tencent.mm.loader.j.b.aph() + (String)localObject6;
        ((com.tencent.mm.vfs.e)localObject4).ae(new com.tencent.mm.vfs.e((String)localObject6));
        ac.i("MMKernel.CoreStorage", "find the old files and rename then %s" + (System.currentTimeMillis() - l2), new Object[] { localObject6 });
      }
    }
    label2188:
    label2469:
    label2982:
    for (boolean bool2 = true;; bool2 = false)
    {
      locale.ghN = new com.tencent.mm.model.ci(locale.cachePath, bool2);
      locale.ags();
      localObject4 = locale.cachePath + "MicroMsg.db";
      localObject6 = locale.cachePath + "EnMicroMsg.db";
      String str = locale.cachePath + "EnMicroMsg2.db";
      locale.ro(null);
      locale.uf((String)localObject6);
      locale.ghG = new h(new e.2(locale));
      Object localObject7 = locale.ghG;
      l2 = k;
      com.tencent.mm.compatible.deviceinfo.q.cF(true);
      if (!((h)localObject7).b((String)localObject4, (String)localObject6, str, l2, e.getBaseDBFactories(), true))
      {
        ??? = new SQLiteException("main db init failed");
        AppMethodBeat.o(132021);
        throw ((Throwable)???);
        if ((!locale.ghB.startsWith(com.tencent.mm.loader.j.b.apb())) || (!bool4))
        {
          ac.w("MMKernel.CoreStorage", "SDCard not available, skip account renaming!");
          i = 1;
          bool1 = false;
          break label411;
        }
        localObject4 = new com.tencent.mm.vfs.e(locale.ghB + (String)???);
        localObject6 = new com.tencent.mm.vfs.e(locale.ghB + (String)localObject3);
        if (((com.tencent.mm.vfs.e)localObject4).isDirectory())
        {
          if (((com.tencent.mm.vfs.e)localObject6).isDirectory())
          {
            ac.i("MMKernel.CoreStorage", "Both uinPath exists, migration shall be taken.");
            i = 2;
            bool1 = true;
            break label411;
          }
          ((com.tencent.mm.vfs.e)localObject6).delete();
          ac.i("MMKernel.CoreStorage", "Move account directory: %s => %s", new Object[] { localObject4, localObject6 });
          if (!((com.tencent.mm.vfs.e)localObject4).ae((com.tencent.mm.vfs.e)localObject6))
          {
            ac.w("MMKernel.CoreStorage", "Failed to move uinPath, use old accPath");
            i = 4;
            bool1 = false;
            break label411;
          }
          ac.i("MMKernel.CoreStorage", "Moved to new uinPath");
          i = 3;
          bool1 = true;
          break label411;
        }
        if (!((com.tencent.mm.vfs.e)localObject6).isDirectory()) {
          ((com.tencent.mm.vfs.e)localObject6).delete();
        }
        ((com.tencent.mm.vfs.e)localObject6).mkdirs();
        i = 5;
        bool1 = true;
        break label411;
        label1200:
        localObject4 = ???;
        break label461;
        label1207:
        localObject4 = localObject3;
        break label513;
      }
      localObject7 = locale.ghG.HbO;
      if (!bs.isNullOrNil((String)localObject7))
      {
        ac.e("MMKernel.CoreStorage", "dbinit failed :".concat(String.valueOf(localObject7)));
        com.tencent.mm.sdk.a.b.N("init db Failed: [ " + (String)localObject7 + "]", "DBinit");
      }
      localObject7 = locale.ghG;
      if (((h)localObject7).HbL != null) {}
      for (boolean bool3 = ((h)localObject7).HbL.Hbi;; bool3 = false)
      {
        if (bool3) {
          locale.ghM = true;
        }
        locale.ghI = new ae(locale.ghG);
        locale.ghK = new cc(locale.ghG);
        locale.ghG.HbN = new e.3(locale);
        locale.ghL = locale.ghK.fcE();
        locale.ghH = new h(locale.ghA);
        localObject7 = locale.ghH;
        l2 = k;
        com.tencent.mm.compatible.deviceinfo.q.cF(true);
        if (((h)localObject7).b((String)localObject4, (String)localObject6, str, l2, new HashMap(), true)) {
          break;
        }
        ??? = new com.tencent.mm.model.b((byte)0);
        AppMethodBeat.o(132021);
        throw ((Throwable)???);
      }
      locale.ghJ = new bw(locale.ghI);
      locale.ghJ.add(new e.4(locale));
      locale.ghJ.fcx();
      ((Runnable)localObject5).run();
      if ((bool4) && (locale.ghB.startsWith(com.tencent.mm.loader.j.b.apb())))
      {
        bool3 = true;
        label1533:
        localObject5 = com.tencent.mm.vfs.a.ghk().ghm();
        localObject6 = ((com.tencent.mm.vfs.a.a)localObject5).lW("account", (String)???).lW("accountSalt", locale.ghE);
        if (!bool3) {
          break label1959;
        }
        localObject4 = locale.ghE;
        label1576:
        ((com.tencent.mm.vfs.a.a)localObject6).lW("accountSd", (String)localObject4);
        if (localObject3 == null) {
          break label1966;
        }
        bool4 = true;
        label1595:
        o.a((com.tencent.mm.vfs.a.a)localObject5, bool3, bool4);
        o.a((com.tencent.mm.vfs.a.a)localObject5, locale.ghB, bool1);
        ((com.tencent.mm.vfs.a.a)localObject5).yo(false);
        ac.i("VFS.Debug", "SetEnv ${account} = ".concat(String.valueOf(???)));
        o.yp(bool1);
        if (bool2)
        {
          l2 = ((Long)locale.ghI.get(ah.a.GKF, Long.valueOf(0L))).longValue();
          i = ((Integer)locale.ghI.get(ah.a.GKG, Integer.valueOf(0))).intValue();
          if (l2 <= 0L) {
            break label1972;
          }
          ac.w("MMKernel.CoreStorage", "summerinstall new install but firsttime[%d] > 0", new Object[] { Long.valueOf(l2) });
          label1724:
          if (i <= 0) {
            break label1992;
          }
          ac.w("MMKernel.CoreStorage", "summerinstall new install but version[%d] > 0", new Object[] { Integer.valueOf(i) });
          label1748:
          ac.i("MMKernel.CoreStorage", "edw setAccUin, summerinstall time[%d]，version[%d], clientversion[%d]", new Object[] { (Long)locale.ghI.get(ah.a.GKF, Long.valueOf(0L)), (Integer)locale.ghI.get(ah.a.GKG, Integer.valueOf(0)), Integer.valueOf(d.DIc) });
        }
        if (paramBoolean) {
          break label2017;
        }
        g.agS();
        ??? = bs.nullAsNil((String)g.agR().agA().get(2, null));
        ac.i("MMKernel.CoreAccount", "summerinit validateUsername username[%s]", new Object[] { ??? });
        if (((String)???).length() > 0) {
          break label2012;
        }
        ac.e("MMKernel.CoreAccount", "username of acc stg not set: uin=" + b.a(ggE));
        afM();
        b.a(ggE, 0);
        ggF = bs.eWi().toString();
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(132004);
            g.agS().releaseAll();
            AppMethodBeat.o(132004);
          }
        });
      }
      label1959:
      label1966:
      label1972:
      label1992:
      label2012:
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label2017;
        }
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(598L, 21L, 1L, true);
        ac.w("MMKernel.CoreAccount", "setAccUin, validateUsername false no need initialize!");
        break;
        bool3 = false;
        break label1533;
        localObject4 = ???;
        break label1576;
        bool4 = false;
        break label1595;
        locale.ghI.set(ah.a.GKF, Long.valueOf(System.currentTimeMillis()));
        break label1724;
        locale.ghI.set(ah.a.GKG, Integer.valueOf(d.DIc));
        break label1748;
      }
      label2017:
      ??? = new cj();
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)???);
      g.agS();
      ??? = g.agR();
      localObject3 = new e.c();
      j = bs.m((Integer)((e)???).ghI.get(14, null));
      m = d.DIc;
      ac.d("MMKernel.CoreStorage", "sVer: %s, cVer: %s.", new Object[] { Integer.toHexString(j), Integer.toHexString(m) });
      if (m == j) {
        paramBoolean = false;
      }
      for (;;)
      {
        label2112:
        if (paramBoolean)
        {
          ((e)???).ghI.set(8197, "");
          ((e)???).ghI.set(15, Integer.valueOf(0));
        }
        if (j != m)
        {
          bool1 = true;
          label2152:
          if ((j > 620822536) || (j == m)) {
            break label2895;
          }
          ((e)???).ghI.set(274480, Boolean.TRUE);
          ac.i("MMKernel.CoreStorage", "[initialize] need init emoji");
          if ((j != 0) && (j < 637599744)) {
            ((e)???).ghI.set(348162, Boolean.TRUE);
          }
          if (j == m) {
            break label2921;
          }
          i = 1;
          label2221:
          if (i == 0) {
            break label2926;
          }
          ac.w("MMKernel.CoreStorage", "account storage version changed from " + Integer.toHexString(j) + " to " + Integer.toHexString(m) + ", init=" + paramBoolean);
          if (((Integer)((e)???).ghx.get(37, Integer.valueOf(0))).intValue() == 0) {
            ((e)???).ghx.set(37, Integer.valueOf(j));
          }
          ((e)???).ghI.set(30, Boolean.FALSE);
          ((e)???).ghI.set(-2046825377, Boolean.FALSE);
          ((e)???).ghI.set(-2046825369, Boolean.FALSE);
          ((e)???).ghI.set(54, Boolean.FALSE);
          ((e)???).ghI.set(-2046825368, Boolean.FALSE);
          ((e)???).ghI.set(-2046825366, Boolean.TRUE);
          ((e)???).ghI.set(62, Boolean.TRUE);
          ai.getContext().getSharedPreferences("update_config_prefs", com.tencent.mm.compatible.util.g.YK()).edit().clear().commit();
          if (((j & 0xFFFFFF00) == (m & 0xFFFFFF00)) || (j == 0))
          {
            ac.d("MMKernel.CoreStorage", "lock show_whatsnew from if.");
            am.aKO("show_whatsnew");
          }
          if (((e)???).ghI.getInt(ah.a.GVb, -1) <= 0) {
            break label2945;
          }
          paramBoolean = true;
          label2486:
          ac.i("MMKernel.CoreStorage", "unlock show_whatsnew from testWhatsNew, %s.", new Object[] { Boolean.valueOf(paramBoolean) });
          if (paramBoolean) {
            am.aKP("show_whatsnew");
          }
          ((e.c)localObject3).ghX = bool1;
          ((e.c)localObject3).ghY = j;
          this.ggJ = ((e.c)localObject3);
          ac.i("MMKernel.CoreAccount", "check is update :%b ", new Object[] { Boolean.valueOf(((e.c)localObject3).ghX) });
          this.ggM = true;
          if (!this.ggL)
          {
            afO();
            g.agP().aga();
          }
          ay.hnA.aL("last_login_uin", p.getString(k));
          com.tencent.mm.plugin.report.e.wTc.setUin(k);
          if (getClass().getClassLoader() != null) {
            break label2950;
          }
          i = -1;
          label2614:
          if (Thread.currentThread().getContextClassLoader() != null) {
            break label2964;
          }
        }
        for (j = -1;; j = Thread.currentThread().getContextClassLoader().hashCode())
        {
          ac.i("MMKernel.CoreAccount", "SmcLogic.setUin, class loader %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          this.ggI = new com.tencent.mm.model.a();
          ac.i("MMKernel.CoreAccount", "setAccUin done :%s", new Object[] { p.getString(k) });
          ??? = new gu();
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)???);
          g.agS();
          if (g.agQ().ghe == null) {
            break;
          }
          g.agS();
          if (g.agQ().ghe.hwg == null) {
            break;
          }
          g.agS();
          g.agQ().ghe.hwg.eE(true);
          g.agS();
          ??? = g.agQ().ghe.hwg.aBZ();
          if ((k == 0) || (??? == null) || (k == ((com.tencent.mm.network.c)???).getUin())) {
            break;
          }
          ac.w("MMKernel.CoreAccount", "summerauth update acc info with acc stg: old acc uin=%d, this uin=%d", new Object[] { Integer.valueOf(((com.tencent.mm.network.c)???).getUin()), Integer.valueOf(k) });
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 46L, 1L, false);
          ((com.tencent.mm.network.c)???).setUin(k);
          break;
          if ((m > 570425344) && (j <= 570425344))
          {
            paramBoolean = true;
            break label2112;
          }
          if ((m <= 570556456) || (j > 570556456)) {
            break label2977;
          }
          paramBoolean = true;
          break label2112;
          bool1 = false;
          break label2152;
          label2895:
          ((e)???).ghI.set(274480, Boolean.FALSE);
          ac.i("MMKernel.CoreStorage", "[initialize] need not init emoji");
          break label2188;
          label2921:
          i = 0;
          break label2221;
          label2926:
          ac.d("MMKernel.CoreStorage", "lock show_whatsnew from else.");
          am.aKO("show_whatsnew");
          break label2469;
          paramBoolean = false;
          break label2486;
          i = getClass().getClassLoader().hashCode();
          break label2614;
        }
        paramBoolean = false;
      }
    }
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(132038);
    if (afY())
    {
      AppMethodBeat.o(132038);
      return;
    }
    synchronized (this.ggD)
    {
      if (afY())
      {
        AppMethodBeat.o(132038);
        return;
      }
      int i = b.a(ggE);
      if (i != 0)
      {
        this.ggR = SystemClock.elapsedRealtime();
        ac.w("MMKernel.CoreAccount", "auto set up account storage uin: %d, stack: %s", new Object[] { Integer.valueOf(i), bs.eWi() });
        dy(false);
      }
      AppMethodBeat.o(132038);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(132037);
    synchronized (this.ggD)
    {
      afN();
      AppMethodBeat.o(132037);
      return;
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(132007);
      ggX = new a("NotReady", 0);
      ggY = new a("AccountHasReady", 1);
      ggZ = new a[] { ggX, ggY };
      AppMethodBeat.o(132007);
    }
    
    private a() {}
  }
  
  static final class b
  {
    private static boolean ghc = true;
    private boolean gha = false;
    private ad ghb;
    private int uin = 0;
    
    private static void a(ad paramad, int paramInt)
    {
      AppMethodBeat.i(132011);
      ac.i("MMKernel.CoreAccount", "setSysUin uin: %d, stack: %s", new Object[] { Integer.valueOf(paramInt), bs.eWi() });
      if (!ai.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.YK()).edit().putInt("default_uin", paramInt).commit())
      {
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 150L, 1L, false);
        ac.e("MMKernel.CoreAccount", "uin_sp save fail");
      }
      paramad.set(1, Integer.valueOf(paramInt));
      paramad.eZZ();
      AppMethodBeat.o(132011);
    }
    
    /* Error */
    private void age()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc 143
      //   6: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: getfield 145	com/tencent/mm/kernel/a$b:ghb	Lcom/tencent/mm/storage/ad;
      //   13: invokestatic 151	junit/framework/Assert:assertNotNull	(Ljava/lang/Object;)V
      //   16: aload_0
      //   17: getfield 145	com/tencent/mm/kernel/a$b:ghb	Lcom/tencent/mm/storage/ad;
      //   20: astore 5
      //   22: aload 5
      //   24: ifnonnull +23 -> 47
      //   27: ldc 51
      //   29: ldc 153
      //   31: invokestatic 156	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   34: aload_0
      //   35: iload_1
      //   36: putfield 24	com/tencent/mm/kernel/a$b:uin	I
      //   39: ldc 143
      //   41: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   44: aload_0
      //   45: monitorexit
      //   46: return
      //   47: aload 5
      //   49: iconst_1
      //   50: invokevirtual 160	com/tencent/mm/storage/ad:get	(I)Ljava/lang/Object;
      //   53: checkcast 55	java/lang/Integer
      //   56: astore_3
      //   57: aload_3
      //   58: astore_2
      //   59: aload_3
      //   60: ifnonnull +140 -> 200
      //   63: aload 5
      //   65: getfield 163	com/tencent/mm/storage/ad:GCY	Z
      //   68: ifeq +17 -> 85
      //   71: getstatic 113	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
      //   74: ldc2_w 114
      //   77: ldc2_w 164
      //   80: lconst_1
      //   81: iconst_0
      //   82: invokevirtual 121	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
      //   85: invokestatic 141	com/tencent/mm/kernel/a$b:agf	()I
      //   88: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   91: astore 4
      //   93: aload_3
      //   94: astore_2
      //   95: aload 4
      //   97: ifnull +103 -> 200
      //   100: ldc 51
      //   102: ldc 167
      //   104: iconst_3
      //   105: anewarray 4	java/lang/Object
      //   108: dup
      //   109: iconst_0
      //   110: aload_3
      //   111: aastore
      //   112: dup
      //   113: iconst_1
      //   114: aload 4
      //   116: aastore
      //   117: dup
      //   118: iconst_2
      //   119: aload 5
      //   121: getfield 163	com/tencent/mm/storage/ad:GCY	Z
      //   124: invokestatic 172	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   127: aastore
      //   128: invokestatic 70	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   131: getstatic 18	com/tencent/mm/kernel/a$b:ghc	Z
      //   134: ifeq +53 -> 187
      //   137: ldc 51
      //   139: ldc 174
      //   141: iconst_2
      //   142: anewarray 4	java/lang/Object
      //   145: dup
      //   146: iconst_0
      //   147: aload 4
      //   149: aastore
      //   150: dup
      //   151: iconst_1
      //   152: invokestatic 65	com/tencent/mm/sdk/platformtools/bs:eWi	()Lcom/tencent/mm/sdk/platformtools/as;
      //   155: aastore
      //   156: invokestatic 176	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   159: getstatic 113	com/tencent/mm/plugin/report/e:wTc	Lcom/tencent/mm/plugin/report/e;
      //   162: sipush 11911
      //   165: iconst_1
      //   166: anewarray 4	java/lang/Object
      //   169: dup
      //   170: iconst_0
      //   171: aload 4
      //   173: invokestatic 180	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Integer;)I
      //   176: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   179: aastore
      //   180: invokevirtual 184	com/tencent/mm/plugin/report/e:f	(I[Ljava/lang/Object;)V
      //   183: iconst_0
      //   184: putstatic 18	com/tencent/mm/kernel/a$b:ghc	Z
      //   187: aload 5
      //   189: aload 4
      //   191: invokevirtual 187	java/lang/Integer:intValue	()I
      //   194: invokestatic 189	com/tencent/mm/kernel/a$b:a	(Lcom/tencent/mm/storage/ad;I)V
      //   197: aload 4
      //   199: astore_2
      //   200: ldc 51
      //   202: ldc 191
      //   204: iconst_1
      //   205: anewarray 4	java/lang/Object
      //   208: dup
      //   209: iconst_0
      //   210: aload_2
      //   211: invokestatic 180	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Integer;)I
      //   214: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   217: aastore
      //   218: invokestatic 70	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   221: aload_2
      //   222: invokestatic 180	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Integer;)I
      //   225: istore_1
      //   226: goto -192 -> 34
      //   229: astore_2
      //   230: aload_0
      //   231: monitorexit
      //   232: aload_2
      //   233: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	234	0	this	b
      //   1	225	1	i	int
      //   58	164	2	localObject1	Object
      //   229	4	2	localObject2	Object
      //   56	55	3	localInteger1	Integer
      //   91	107	4	localInteger2	Integer
      //   20	168	5	localad	ad
      // Exception table:
      //   from	to	target	type
      //   4	22	229	finally
      //   27	34	229	finally
      //   34	44	229	finally
      //   47	57	229	finally
      //   63	85	229	finally
      //   85	93	229	finally
      //   100	187	229	finally
      //   187	197	229	finally
      //   200	226	229	finally
    }
    
    private static int agf()
    {
      AppMethodBeat.i(206875);
      int i = ai.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.YK()).getInt("default_uin", 0);
      AppMethodBeat.o(206875);
      return i;
    }
    
    private int getUin()
    {
      try
      {
        AppMethodBeat.i(132008);
        if (!this.gha)
        {
          age();
          this.gha = true;
        }
        int i = this.uin;
        AppMethodBeat.o(132008);
        return i;
      }
      finally {}
    }
    
    private void setUin(int paramInt)
    {
      try
      {
        AppMethodBeat.i(132009);
        ac.i("MMKernel.CoreAccount", "Uin From %s To %s hash:%d thread:%d[%s] stack:%s", new Object[] { p.getString(this.uin), p.getString(paramInt), Integer.valueOf(i.cc(paramInt, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), bs.eWi() });
        Assert.assertNotNull(this.ghb);
        a(this.ghb, paramInt);
        this.uin = paramInt;
        AppMethodBeat.o(132009);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final void a(ad paramad)
    {
      try
      {
        this.ghb = paramad;
        return;
      }
      finally
      {
        paramad = finally;
        throw paramad;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a
 * JD-Core Version:    0.7.0.1
 */