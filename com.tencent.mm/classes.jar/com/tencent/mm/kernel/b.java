package com.tencent.mm.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.ac;
import com.tencent.mm.an.t;
import com.tencent.mm.b.p;
import com.tencent.mm.f.a.cs;
import com.tencent.mm.f.a.ct;
import com.tencent.mm.f.a.hj;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.cq;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.cl;
import com.tencent.mm.storage.cr;
import com.tencent.mm.vfs.ab;
import com.tencent.mm.vfs.h.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class b
{
  private static boolean kbA;
  private static boolean kbB;
  static b kbD;
  private static String kbE;
  private static String kbF;
  private static boolean kbG;
  private static int kbQ;
  byte[] kbC;
  public com.tencent.mm.model.a kbH;
  public f.c kbI;
  public a kbJ;
  public int kbK;
  public boolean kbL;
  private boolean kbM;
  public int kbN;
  public int kbO;
  private List<bd> kbP;
  long kbR;
  private volatile b.a kbS;
  public volatile boolean kbT;
  private String kbU;
  private Map<String, Integer> kbV;
  private com.tencent.mm.kernel.api.c kby;
  private ac kbz;
  
  static
  {
    AppMethodBeat.i(132045);
    kbA = true;
    kbB = false;
    kbD = new b();
    kbE = "NoResetUinStack";
    kbF = null;
    kbQ = -1;
    AppMethodBeat.o(132045);
  }
  
  public b(com.tencent.mm.kernel.api.c paramc)
  {
    AppMethodBeat.i(132014);
    this.kbC = new byte[0];
    this.kbL = false;
    this.kbM = false;
    this.kbN = 0;
    this.kbP = new LinkedList();
    this.kbS = b.a.kbX;
    this.kbT = false;
    this.kbU = "";
    this.kbV = new HashMap();
    Assert.assertNotNull(kbD);
    h.aHH();
    boolean bool;
    if (Util.nullAsNil((Integer)h.aHG().kcw.get(17)) != 0)
    {
      bool = true;
      kbA = bool;
      if (!com.tencent.mm.protocal.f.RAO) {
        break label155;
      }
    }
    label155:
    for (int i = 763;; i = 702)
    {
      com.tencent.mm.protocal.j.e.a.RBn = new bi(i);
      this.kby = paramc;
      this.kbJ = new a();
      AppMethodBeat.o(132014);
      return;
      bool = false;
      break;
    }
  }
  
  public static String ML(String paramString)
  {
    kbF = paramString;
    return paramString;
  }
  
  public static void MM(String paramString)
  {
    kbE = paramString;
  }
  
  public static int MN(String paramString)
  {
    AppMethodBeat.i(132044);
    h.aHH();
    if (h.aHE().kbV.get(paramString) == null) {}
    int j;
    for (int i = 0;; i = ((Integer)h.aHE().kbV.get(paramString)).intValue())
    {
      j = (int)Util.nowSecond();
      if (i != 0) {
        break;
      }
      h.aHH();
      h.aHE().kbV.put(paramString, Integer.valueOf(j));
      AppMethodBeat.o(132044);
      return i;
      h.aHH();
    }
    i = j - i;
    h.aHH();
    h.aHE().kbV.put(paramString, Integer.valueOf(j));
    if (i >= 0)
    {
      AppMethodBeat.o(132044);
      return i;
    }
    AppMethodBeat.o(132044);
    return 0;
  }
  
  public static boolean aGD()
  {
    return kbB;
  }
  
  public static boolean aGE()
  {
    AppMethodBeat.i(132025);
    if (kbA)
    {
      h.aHH();
      if (h.aHE() == null) {
        break label77;
      }
      h.aHH();
      h.aHE();
    }
    label77:
    for (String str = p.getString(b.a(kbD));; str = "-1")
    {
      Log.w("MMKernel.CoreAccount", "account holded :%s init:%b", new Object[] { str, Boolean.valueOf(h.aHE().aGM()) });
      boolean bool = kbA;
      AppMethodBeat.o(132025);
      return bool;
    }
  }
  
  public static void aGF()
  {
    AppMethodBeat.i(132026);
    h.aHH();
    if (h.aHE() != null)
    {
      h.aHH();
      h.aHE();
    }
    for (String str = p.getString(b.a(kbD));; str = "-1")
    {
      Log.w("MMKernel.CoreAccount", " HOLD ACCOUNT! uin:%s stack:%s init:%b", new Object[] { str, Util.getStack(), Boolean.valueOf(h.aHE().aGM()) });
      kbA = true;
      h.aHH();
      h.aHG().kcw.i(17, Integer.valueOf(1));
      AppMethodBeat.o(132026);
      return;
    }
  }
  
  public static void aGG()
  {
    AppMethodBeat.i(132027);
    h.aHH();
    if (h.aHE() != null)
    {
      h.aHH();
      h.aHE();
    }
    for (String str = p.getString(b.a(kbD));; str = "-1")
    {
      Log.w("MMKernel.CoreAccount", " UN HOLD ACCOUNT! uin:%s init:%b", new Object[] { str, Boolean.valueOf(h.aHE().aGM()) });
      kbA = false;
      h.aHH();
      h.aHG().kcw.i(17, Integer.valueOf(0));
      AppMethodBeat.o(132027);
      return;
    }
  }
  
  public static int aGJ()
  {
    AppMethodBeat.i(132034);
    int i = awd().getInt("notification.user.state", 0);
    AppMethodBeat.o(132034);
    return i;
  }
  
  public static boolean aGL()
  {
    AppMethodBeat.i(132039);
    if (b.a(kbD) != 0)
    {
      AppMethodBeat.o(132039);
      return true;
    }
    AppMethodBeat.o(132039);
    return false;
  }
  
  public static int aGP()
  {
    AppMethodBeat.i(132041);
    Integer localInteger2 = Integer.valueOf(MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.avK()).getInt("default_uin", 0));
    Integer localInteger1 = localInteger2;
    if (localInteger2.intValue() == 0)
    {
      localInteger2 = Integer.valueOf(MultiProcessMMKV.getMMKV("system_config_prefs").decodeInt("default_uin", 0));
      localInteger1 = localInteger2;
      if (localInteger2.intValue() != 0)
      {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 151L, 1L, false);
        Log.e("MMKernel.CoreAccount", "getUinFromSharedPreferences get from sp fail");
        localInteger1 = localInteger2;
      }
    }
    int i = localInteger1.intValue();
    AppMethodBeat.o(132041);
    return i;
  }
  
  public static int aGQ()
  {
    AppMethodBeat.i(202087);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("system_config_prefs");
    if (!localMultiProcessMMKV.decodeBool("has_uin_timely", false))
    {
      i = aGP();
      AppMethodBeat.o(202087);
      return i;
    }
    int i = localMultiProcessMMKV.decodeInt("default_uin_timely", 0);
    AppMethodBeat.o(202087);
    return i;
  }
  
  public static String aGR()
  {
    AppMethodBeat.i(132042);
    h.aHH();
    if (Util.isNullOrNil(h.aHE().kbU))
    {
      h.aHH();
      h.aHE().kbU = (com.tencent.mm.compatible.deviceinfo.q.auM() + "_" + System.currentTimeMillis());
    }
    h.aHH();
    String str = h.aHE().kbU;
    AppMethodBeat.o(132042);
    return str;
  }
  
  public static void aGS()
  {
    AppMethodBeat.i(132043);
    h.aHH();
    h.aHE().kbU = "";
    h.aHH();
    h.aHE().kbV.clear();
    AppMethodBeat.o(132043);
  }
  
  public static String aGq()
  {
    AppMethodBeat.i(132016);
    String str = new p(b.a(kbD)).toString();
    AppMethodBeat.o(132016);
    return str;
  }
  
  public static final int aGr()
  {
    AppMethodBeat.i(201953);
    int i = b.access$100();
    AppMethodBeat.o(201953);
    return i;
  }
  
  public static String aGs()
  {
    return kbF;
  }
  
  public static boolean aGt()
  {
    return kbG;
  }
  
  public static void aGu()
  {
    kbG = true;
  }
  
  public static String aGv()
  {
    return kbE;
  }
  
  protected static void aGw()
  {
    AppMethodBeat.i(132018);
    b.a(kbD, 0);
    AppMethodBeat.o(132018);
  }
  
  protected static void aGx()
  {
    AppMethodBeat.i(201960);
    b.sD(0);
    AppMethodBeat.o(201960);
  }
  
  private void aGy()
  {
    AppMethodBeat.i(132019);
    this.kbS = b.a.kbX;
    this.kbT = false;
    Log.i("MMKernel.CoreAccount", "mAccountStatus to NotReady");
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("isLogin", false).commit();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
    Log.w("MMKernel.CoreAccount", "[arthurdan.AccountNR] account storage reset! uin:%d, resetStack is:%s, resetTime:%s", new Object[] { Integer.valueOf(b.a(kbD)), kbE, localSimpleDateFormat.format(new Date()) });
    AppMethodBeat.o(132019);
  }
  
  public static SharedPreferences awd()
  {
    AppMethodBeat.i(132035);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("notify_key_pref_settings", com.tencent.mm.compatible.util.g.avK());
    AppMethodBeat.o(132035);
    return localSharedPreferences;
  }
  
  public static void eQ(boolean paramBoolean)
  {
    kbB = paramBoolean;
  }
  
  public static String getSalt()
  {
    AppMethodBeat.i(201948);
    h.aHH();
    String str = h.aHG().aHp().a(ar.a.VDI, null);
    AppMethodBeat.o(201948);
    return str;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(132015);
    int i = b.a(kbD);
    AppMethodBeat.o(132015);
    return i;
  }
  
  static boolean sA(int paramInt)
  {
    return paramInt != 0;
  }
  
  public static void sB(int paramInt)
  {
    AppMethodBeat.i(132033);
    if ((kbQ != -1) && (kbQ == paramInt))
    {
      AppMethodBeat.o(132033);
      return;
    }
    kbQ = paramInt;
    awd().edit().putInt("notification.user.state", paramInt).commit();
    Log.i("MMKernel.CoreAccount", "[NOTIFICATION SETTINGS]save UserStatus: %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(132033);
  }
  
  public static boolean sC(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public final void a(bd parambd)
  {
    AppMethodBeat.i(132029);
    Log.i("MMKernel.CoreAccount", "UserStatusChange: add %s", new Object[] { parambd });
    synchronized (this.kbP)
    {
      if (!this.kbP.contains(parambd)) {
        this.kbP.add(parambd);
      }
      AppMethodBeat.o(132029);
      return;
    }
  }
  
  public final void aGA()
  {
    AppMethodBeat.i(132022);
    if (!this.kbM)
    {
      Log.i("MMKernel.CoreAccount", "no need do account initialized notify.");
      AppMethodBeat.o(132022);
      return;
    }
    this.kbM = false;
    Log.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized tid:%d, stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Util.getStack() });
    long l = System.currentTimeMillis();
    this.kbJ.aGp();
    this.kby.onAccountInitialized(this.kbI);
    Log.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized run tid[%d] take[%d]ms", new Object[] { Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l) });
    aGB();
    AppMethodBeat.o(132022);
  }
  
  public final void aGB()
  {
    AppMethodBeat.i(132023);
    if ((aGM()) && (com.tencent.mm.kernel.a.c.aHV().kdV))
    {
      Log.i("MMKernel.CoreAccount", "Flush client version.");
      h.aHG().aHh();
    }
    AppMethodBeat.o(132023);
  }
  
  public final ac aGC()
  {
    try
    {
      AppMethodBeat.i(132024);
      if (this.kbz == null) {
        this.kbz = new ac();
      }
      ac localac = this.kbz;
      AppMethodBeat.o(132024);
      return localac;
    }
    finally {}
  }
  
  public final void aGH()
  {
    AppMethodBeat.i(132028);
    if (!aGM())
    {
      com.tencent.mm.model.b localb = new com.tencent.mm.model.b();
      AppMethodBeat.o(132028);
      throw localb;
    }
    AppMethodBeat.o(132028);
  }
  
  public final void aGI()
  {
    AppMethodBeat.i(132031);
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132002);
        bd[] arrayOfbd = new bd[b.b(b.this).size()];
        b.b(b.this).toArray(arrayOfbd);
        int j = arrayOfbd.length;
        int i = 0;
        while (i < j)
        {
          arrayOfbd[i].bez();
          i += 1;
        }
        AppMethodBeat.o(132002);
      }
    });
    AppMethodBeat.o(132031);
  }
  
  public final boolean aGK()
  {
    AppMethodBeat.i(132036);
    boolean bool = sC(this.kbN);
    AppMethodBeat.o(132036);
    return bool;
  }
  
  public final boolean aGM()
  {
    return this.kbS == b.a.kbY;
  }
  
  public final boolean aGN()
  {
    return this.kbT;
  }
  
  public final void aGO()
  {
    AppMethodBeat.i(132040);
    Log.i("MMKernel.CoreAccount", "summerasyncinit setInitializedNotifyAllDone[%b] to true stack[%s]", new Object[] { Boolean.valueOf(this.kbT), Util.getStack() });
    this.kbT = true;
    long l = SystemClock.elapsedRealtime();
    Log.i("MMKernel.CoreAccount", "summerhardcoder setInitializedNotifyAllDone [%d %d] take[%d]ms, stack[%s]", new Object[] { Long.valueOf(this.kbR), Long.valueOf(l), Long.valueOf(l - this.kbR), Util.getStack() });
    cs localcs = new cs();
    EventCenter.instance.publish(localcs);
    AppMethodBeat.o(132040);
  }
  
  public final a aGT()
  {
    return this.kbJ;
  }
  
  final void aGz()
  {
    AppMethodBeat.i(132020);
    Log.w("MMKernel.CoreAccount", "account storage release  uin:%s thread:%s stack:%s", new Object[] { p.getString(b.a(kbD)), Thread.currentThread().getName(), Util.getStack() });
    if (!aGM())
    {
      Log.i("MMKernel.CoreAccount", "Fatal crash error!!! status is not initialized when release(), this callStack is:%s, last reset stack is:%s", new Object[] { Util.getStack().toString(), kbE });
      AppMethodBeat.o(132020);
      return;
    }
    a locala = this.kbJ;
    com.tencent.e.h.ZvG.bc((Runnable)new a.d(locala));
    this.kby.onAccountRelease();
    h.aHH();
    h.aHG().JA(null);
    aGy();
    h.aHH();
    h.aHG().kcN.clear();
    AppMethodBeat.o(132020);
  }
  
  public final void b(bd parambd)
  {
    AppMethodBeat.i(132030);
    Log.i("MMKernel.CoreAccount", "UserStatusChange: remove %s", new Object[] { parambd });
    synchronized (this.kbP)
    {
      this.kbP.remove(parambd);
      AppMethodBeat.o(132030);
      return;
    }
  }
  
  public final void dp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132032);
    if ((this.kbN != paramInt1) || (this.kbO != paramInt2)) {}
    for (int i = 1;; i = 0)
    {
      Log.d("MMKernel.CoreAccount", "online status, %d, %d, %d ,%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.kbO), Integer.valueOf(this.kbN) });
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(132032);
      return;
    }
    this.kbN = paramInt1;
    this.kbO = paramInt2;
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132003);
        b.this.aGI();
        AppMethodBeat.o(132003);
      }
    });
    AppMethodBeat.o(132032);
  }
  
  final void eP(boolean paramBoolean)
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
      if (!WXHardCoderJNI.hcBootThr) {
        break label255;
      }
      i = h.aHJ().getProcessTid();
    }
    for (;;)
    {
      this.kbK = WXHardCoderJNI.startPerformance(bool1, j, k, m, i, WXHardCoderJNI.hcBootTimeout, 101, WXHardCoderJNI.hcBootAction, "MMKernel.CoreAccount");
      Log.i("MMKernel.CoreAccount", "summerhardcoder startPerformance[%s] stack[%s]", new Object[] { Integer.valueOf(this.kbK), Util.getStack() });
      Log.i("MMKernel.CoreAccount", "UserStatusChange: clear");
      synchronized (this.kbP)
      {
        this.kbP.clear();
        long l1 = System.currentTimeMillis();
        k = b.a(kbD);
        Log.i("MMKernel.CoreAccount", "dkacc setAccuin %s hash:%d thread:%d[%s] stack:%s", new Object[] { p.getString(k), Integer.valueOf(com.tencent.mm.b.i.cA(k, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), Util.getStack() });
        if (k != 0)
        {
          i = 1;
          if (i != 0) {
            break;
          }
          Log.w("MMKernel.CoreAccount", "setAccUin, Reset by MMCore.resetAccUin");
          Log.i("MMKernel.CoreAccount", "start time check setUinImpl end total time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
          Log.i("MMKernel.CoreAccount", "mAccountStatus to AccountHasReady");
          AppMethodBeat.o(132021);
          return;
          label255:
          i = 0;
        }
      }
    }
    CrashReportFactory.setReportID(p.getString(k));
    h.aHH();
    f localf = h.aHG();
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132001);
        b.a(b.this);
        AppMethodBeat.o(132001);
      }
    };
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("isLogin", true).apply();
    ??? = com.tencent.mm.b.g.getMessageDigest("mm".concat(String.valueOf(k)).getBytes());
    Object localObject3 = f.F(k, (String)???);
    Log.i("MMKernel.CoreStorage", "uinPath: %s, uinSaltPath: %s", new Object[] { ???, localObject3 });
    boolean bool3 = com.tencent.mm.compatible.util.e.avA();
    Object localObject4;
    label461:
    long l2;
    label513:
    Object localObject5;
    if (localObject3 == null)
    {
      bool1 = false;
      Log.w("MMKernel.CoreStorage", "Cannot generate account path, skip account renaming!");
      i = 6;
      localf.kcC = ((String)???);
      localf.cachePath = (ar.Vgb + localf.kcC + '/');
      if (!bool1) {
        break label1335;
      }
      localObject4 = localObject3;
      localf.kcE = ((String)localObject4);
      localf.kcB = (localf.kcA + localf.kcE + '/');
      if (localObject3 != null) {
        break label1342;
      }
      localObject4 = ???;
      localf.kcD = ((String)localObject4);
      ab.azf(i);
      localObject4 = new com.tencent.mm.vfs.q(localf.cachePath);
      Log.i("MMKernel.CoreStorage", "dkacc cachePath:" + localf.cachePath + " accPath:" + localf.kcB);
      if (((com.tencent.mm.vfs.q)localObject4).ifE()) {
        break label2981;
      }
      Log.w("MMKernel.CoreStorage", "setUin REBUILD data now ! DO NOT FUCKING TELL ME DB BROKEN !!! uin:%s data:%s sd:%s", new Object[] { p.getString(k), localf.cachePath, localf.kcB });
      ((com.tencent.mm.vfs.q)localObject4).ifL();
      if (!localf.cachePath.equalsIgnoreCase(localf.kcB))
      {
        l2 = System.currentTimeMillis();
        localObject4 = new com.tencent.mm.vfs.q(localf.kcB);
        localObject5 = (String)??? + "temp" + System.currentTimeMillis();
        localObject5 = com.tencent.mm.loader.j.b.aSL() + (String)localObject5;
        ((com.tencent.mm.vfs.q)localObject4).aj(new com.tencent.mm.vfs.q((String)localObject5));
        Log.i("MMKernel.CoreStorage", "find the old files and rename then %s" + (System.currentTimeMillis() - l2), new Object[] { localObject5 });
      }
    }
    label2188:
    label2445:
    label2462:
    label2976:
    label2981:
    for (boolean bool2 = true;; bool2 = false)
    {
      localf.kcM = new cq(localf.cachePath, bool2);
      if ((bool3) && (localf.kcA.startsWith(com.tencent.mm.loader.j.b.aSF())))
      {
        bool3 = true;
        label813:
        localObject5 = com.tencent.mm.vfs.h.iWH().iWK();
        h.a locala = ((h.a)localObject5).oj("account", (String)???).oj("accountSalt", localf.kcD);
        if (!bool3) {
          break label1355;
        }
        localObject4 = localf.kcD;
        label856:
        locala.oj("accountSd", (String)localObject4);
        if (localObject3 == null) {
          break label1362;
        }
      }
      label1335:
      label1342:
      label1355:
      label1362:
      for (boolean bool4 = true;; bool4 = false)
      {
        ab.a((h.a)localObject5, bool3, bool4);
        ab.a((h.a)localObject5, localf.kcA, bool1);
        ((h.a)localObject5).HX(false);
        Log.i("VFS.Debug", "SetEnv ${account} = ".concat(String.valueOf(???)));
        ab.HZ(bool1);
        localf.aHi();
        ??? = localf.cachePath + "MicroMsg.db";
        localObject3 = localf.cachePath + "EnMicroMsg.db";
        localObject4 = localf.cachePath + "EnMicroMsg2.db";
        localf.JA(null);
        localf.MP((String)localObject3);
        localf.kcF = new com.tencent.mm.storagebase.h(new f.2(localf));
        localObject5 = localf.kcF;
        l2 = k;
        com.tencent.mm.compatible.deviceinfo.q.dR(true);
        if (((com.tencent.mm.storagebase.h)localObject5).b((String)???, (String)localObject3, (String)localObject4, l2, f.getBaseDBFactories(), true)) {
          break label1368;
        }
        ??? = new SQLiteException("main db init failed");
        AppMethodBeat.o(132021);
        throw ((Throwable)???);
        if ((!localf.kcA.startsWith(com.tencent.mm.loader.j.b.aSF())) || (!bool3))
        {
          bool1 = false;
          Log.w("MMKernel.CoreStorage", "SDCard not available, skip account renaming!");
          i = 1;
          break;
        }
        localObject4 = new com.tencent.mm.vfs.q(localf.kcA + (String)???);
        localObject5 = new com.tencent.mm.vfs.q(localf.kcA + (String)localObject3);
        if (((com.tencent.mm.vfs.q)localObject4).isDirectory())
        {
          if (((com.tencent.mm.vfs.q)localObject5).isDirectory())
          {
            bool1 = true;
            Log.i("MMKernel.CoreStorage", "Both uinPath exists, migration shall be taken.");
            i = 2;
            break;
          }
          ((com.tencent.mm.vfs.q)localObject5).cFq();
          Log.i("MMKernel.CoreStorage", "Move account directory: %s => %s", new Object[] { localObject4, localObject5 });
          if (!((com.tencent.mm.vfs.q)localObject4).aj((com.tencent.mm.vfs.q)localObject5))
          {
            Log.w("MMKernel.CoreStorage", "Failed to move uinPath, use old accPath");
            bool1 = false;
            i = 4;
            break;
          }
          Log.i("MMKernel.CoreStorage", "Moved to new uinPath");
          bool1 = true;
          i = 3;
          break;
        }
        if (!((com.tencent.mm.vfs.q)localObject5).isDirectory()) {
          ((com.tencent.mm.vfs.q)localObject5).cFq();
        }
        ((com.tencent.mm.vfs.q)localObject5).ifL();
        bool1 = true;
        i = 5;
        break;
        localObject4 = ???;
        break label461;
        localObject4 = localObject3;
        break label513;
        bool3 = false;
        break label813;
        localObject4 = ???;
        break label856;
      }
      label1368:
      localObject5 = localf.kcF.VJF;
      if (!Util.isNullOrNil((String)localObject5))
      {
        Log.e("MMKernel.CoreStorage", "dbinit failed :".concat(String.valueOf(localObject5)));
        CrashReportFactory.reportRawMessage("init db Failed: [ " + (String)localObject5 + "]", "DBinit");
      }
      localObject5 = localf.kcF;
      if (((com.tencent.mm.storagebase.h)localObject5).VJC != null) {}
      for (bool1 = ((com.tencent.mm.storagebase.h)localObject5).VJC.VIY;; bool1 = false)
      {
        if (bool1) {
          localf.kcL = true;
        }
        localf.kcH = new ao(localf.kcF);
        localf.kcJ = new cr(localf.kcF);
        localf.kcF.VJE = new f.3(localf);
        localf.kcK = localf.kcJ.hAP();
        localf.kcG = new com.tencent.mm.storagebase.h(localf.kcz);
        localObject5 = localf.kcG;
        l2 = k;
        com.tencent.mm.compatible.deviceinfo.q.dR(true);
        if (((com.tencent.mm.storagebase.h)localObject5).b((String)???, (String)localObject3, (String)localObject4, l2, new HashMap(), true)) {
          break;
        }
        ??? = new com.tencent.mm.model.b((byte)0);
        AppMethodBeat.o(132021);
        throw ((Throwable)???);
      }
      localf.kcI = new cl(localf.kcH);
      localf.kcI.add(new f.4(localf));
      localf.kcI.hAH();
      local1.run();
      if (bool2)
      {
        l2 = ((Long)localf.kcH.get(ar.a.Vnx, Long.valueOf(0L))).longValue();
        i = ((Integer)localf.kcH.get(ar.a.Vny, Integer.valueOf(0))).intValue();
        if (l2 > 0L)
        {
          Log.w("MMKernel.CoreStorage", "summerinstall new install but firsttime[%d] > 0", new Object[] { Long.valueOf(l2) });
          label1743:
          if (i <= 0) {
            break label1992;
          }
          Log.w("MMKernel.CoreStorage", "summerinstall new install but version[%d] > 0", new Object[] { Integer.valueOf(i) });
          label1767:
          Log.i("MMKernel.CoreStorage", "edw setAccUin, summerinstall time[%d]，version[%d], clientversion[%d]", new Object[] { (Long)localf.kcH.get(ar.a.Vnx, Long.valueOf(0L)), (Integer)localf.kcH.get(ar.a.Vny, Integer.valueOf(0)), Integer.valueOf(d.RAD) });
        }
      }
      else
      {
        if (paramBoolean) {
          break label2017;
        }
        h.aHH();
        ??? = Util.nullAsNil((String)h.aHG().aHp().b(2, null));
        Log.i("MMKernel.CoreAccount", "summerinit validateUsername username[%s]", new Object[] { ??? });
        if (((String)???).length() > 0) {
          break label2012;
        }
        Log.e("MMKernel.CoreAccount", "username of acc stg not set: uin=" + b.a(kbD));
        aGy();
        b.a(kbD, 0);
        kbE = Util.getStack().toString();
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(132004);
            h.aHH().releaseAll();
            AppMethodBeat.o(132004);
          }
        });
      }
      label1992:
      label2012:
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label2017;
        }
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(598L, 21L, 1L, true);
        Log.w("MMKernel.CoreAccount", "setAccUin, validateUsername false no need initialize!");
        break;
        localf.kcH.set(ar.a.Vnx, Long.valueOf(System.currentTimeMillis()));
        break label1743;
        localf.kcH.set(ar.a.Vny, Integer.valueOf(d.RAD));
        break label1767;
      }
      label2017:
      ??? = new ct();
      EventCenter.instance.publish((IEvent)???);
      h.aHH();
      ??? = h.aHG();
      localObject3 = new f.c();
      j = Util.nullAsNil((Integer)((f)???).kcH.b(14, null));
      m = d.RAD;
      Log.d("MMKernel.CoreStorage", "sVer: %s, cVer: %s.", new Object[] { Integer.toHexString(j), Integer.toHexString(m) });
      if (m == j) {
        paramBoolean = false;
      }
      for (;;)
      {
        label2112:
        if (paramBoolean)
        {
          ((f)???).kcH.i(8197, "");
          ((f)???).kcH.i(15, Integer.valueOf(0));
        }
        if (j != m)
        {
          bool1 = true;
          label2152:
          if ((j > 620822536) || (j == m)) {
            break label2861;
          }
          ((f)???).kcH.i(274480, Boolean.TRUE);
          Log.i("MMKernel.CoreStorage", "[initialize] need init emoji");
          if ((j != 0) && (j < 637599744)) {
            ((f)???).kcH.i(348162, Boolean.TRUE);
          }
          if (j == m) {
            break label2887;
          }
          i = 1;
          label2221:
          if (i == 0) {
            break label2925;
          }
          Log.w("MMKernel.CoreStorage", "account storage version changed from " + Integer.toHexString(j) + " to " + Integer.toHexString(m) + ", init=" + paramBoolean);
          if (((Integer)((f)???).kcw.b(37, Integer.valueOf(0))).intValue() == 0) {
            ((f)???).kcw.i(37, Integer.valueOf(j));
          }
          ((f)???).kcH.i(30, Boolean.FALSE);
          ((f)???).kcH.i(-2046825377, Boolean.FALSE);
          ((f)???).kcH.i(-2046825369, Boolean.FALSE);
          ((f)???).kcH.i(54, Boolean.FALSE);
          ((f)???).kcH.i(-2046825368, Boolean.FALSE);
          ((f)???).kcH.i(-2046825366, Boolean.TRUE);
          ((f)???).kcH.i(62, Boolean.TRUE);
          MMApplicationContext.getContext().getSharedPreferences("update_config_prefs", com.tencent.mm.compatible.util.g.avK()).edit().clear().commit();
          if (j != 0) {
            break label2892;
          }
          ((f)???).kcO = true;
          if (((f)???).kcH.getInt(ar.a.VAj, -1) <= 0) {
            break label2944;
          }
          paramBoolean = true;
          Log.i("MMKernel.CoreStorage", "unlock show_whatsnew from testWhatsNew, %s.", new Object[] { Boolean.valueOf(paramBoolean) });
          ((f.c)localObject3).kcX = bool1;
          ((f.c)localObject3).kcY = j;
          this.kbI = ((f.c)localObject3);
          Log.i("MMKernel.CoreAccount", "check is update :%b ", new Object[] { Boolean.valueOf(((f.c)localObject3).kcX) });
          this.kbM = true;
          if (!this.kbL)
          {
            aGA();
            h.aHE().aGO();
          }
          bg.ltv.aS("last_login_uin", p.getString(k));
          com.tencent.mm.plugin.report.f.Iyx.setUin(k);
          if (getClass().getClassLoader() != null) {
            break label2949;
          }
          i = -1;
          if (Thread.currentThread().getContextClassLoader() != null) {
            break label2963;
          }
        }
        for (j = -1;; j = Thread.currentThread().getContextClassLoader().hashCode())
        {
          Log.i("MMKernel.CoreAccount", "SmcLogic.setUin, class loader %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          this.kbH = new com.tencent.mm.model.a();
          Log.i("MMKernel.CoreAccount", "setAccUin done :%s", new Object[] { p.getString(k) });
          ??? = new hj();
          EventCenter.instance.publish((IEvent)???);
          h.aHH();
          if (h.aHF().kcd == null) {
            break;
          }
          h.aHH();
          if (h.aHF().kcd.lCD == null) {
            break;
          }
          h.aHH();
          h.aHF().kcd.lCD.gk(true);
          h.aHH();
          ??? = h.aHF().kcd.lCD.biw();
          if ((k == 0) || (??? == null) || (k == ((com.tencent.mm.network.e)???).getUin())) {
            break;
          }
          Log.w("MMKernel.CoreAccount", "summerauth update acc info with acc stg: old acc uin=%d, this uin=%d", new Object[] { Integer.valueOf(((com.tencent.mm.network.e)???).getUin()), Integer.valueOf(k) });
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 46L, 1L, false);
          ((com.tencent.mm.network.e)???).setUin(k);
          break;
          if ((m > 570425344) && (j <= 570425344))
          {
            paramBoolean = true;
            break label2112;
          }
          if ((m <= 570556456) || (j > 570556456)) {
            break label2976;
          }
          paramBoolean = true;
          break label2112;
          bool1 = false;
          break label2152;
          label2861:
          ((f)???).kcH.i(274480, Boolean.FALSE);
          Log.i("MMKernel.CoreStorage", "[initialize] need not init emoji");
          break label2188;
          label2887:
          i = 0;
          break label2221;
          label2892:
          if ((0xFF000000 & j) != (0xFF000000 & m)) {
            break label2445;
          }
          Log.d("MMKernel.CoreStorage", "lock show_whatsnew by same major version");
          MMEntryLock.lock("show_whatsnew");
          break label2445;
          label2925:
          Log.d("MMKernel.CoreStorage", "lock show_whatsnew from else.");
          MMEntryLock.lock("show_whatsnew");
          break label2445;
          paramBoolean = false;
          break label2462;
          i = getClass().getClassLoader().hashCode();
          break label2580;
        }
        paramBoolean = false;
      }
    }
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(132038);
    if (aGM())
    {
      AppMethodBeat.o(132038);
      return;
    }
    synchronized (this.kbC)
    {
      if (aGM())
      {
        AppMethodBeat.o(132038);
        return;
      }
      int i = b.a(kbD);
      if (i != 0)
      {
        this.kbR = SystemClock.elapsedRealtime();
        Log.w("MMKernel.CoreAccount", "auto set up account storage uin: %d, stack: %s", new Object[] { Integer.valueOf(i), Util.getStack() });
        eP(false);
      }
      AppMethodBeat.o(132038);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(132037);
    synchronized (this.kbC)
    {
      aGz();
      AppMethodBeat.o(132037);
      return;
    }
  }
  
  static final class b
  {
    private static boolean kcb = true;
    private an kca;
    private boolean mLoaded = false;
    private int uin = 0;
    
    private static void a(an paraman, int paramInt)
    {
      AppMethodBeat.i(132011);
      Log.i("MMKernel.CoreAccount", "setSysUin uin: %d, stack: %s", new Object[] { Integer.valueOf(paramInt), Util.getStack() });
      if (!MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.avK()).edit().putInt("default_uin", paramInt).commit())
      {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 150L, 1L, false);
        Log.e("MMKernel.CoreAccount", "uin_sp save fail");
      }
      MultiProcessMMKV.getMMKV("system_config_prefs").encode("default_uin", paramInt);
      paraman.i(1, Integer.valueOf(paramInt));
      paraman.hxS();
      sD(paramInt);
      AppMethodBeat.o(132011);
    }
    
    /* Error */
    private void aGU()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc 150
      //   6: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: getfield 152	com/tencent/mm/kernel/b$b:kca	Lcom/tencent/mm/storage/an;
      //   13: invokestatic 158	junit/framework/Assert:assertNotNull	(Ljava/lang/Object;)V
      //   16: aload_0
      //   17: getfield 152	com/tencent/mm/kernel/b$b:kca	Lcom/tencent/mm/storage/an;
      //   20: astore 5
      //   22: aload 5
      //   24: ifnonnull +23 -> 47
      //   27: ldc 51
      //   29: ldc 160
      //   31: invokestatic 163	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   34: aload_0
      //   35: iload_1
      //   36: putfield 24	com/tencent/mm/kernel/b$b:uin	I
      //   39: ldc 150
      //   41: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   44: aload_0
      //   45: monitorexit
      //   46: return
      //   47: aload 5
      //   49: iconst_1
      //   50: invokevirtual 167	com/tencent/mm/storage/an:get	(I)Ljava/lang/Object;
      //   53: checkcast 55	java/lang/Integer
      //   56: astore_3
      //   57: aload_3
      //   58: astore_2
      //   59: aload_3
      //   60: ifnonnull +140 -> 200
      //   63: aload 5
      //   65: getfield 170	com/tencent/mm/storage/an:VfF	Z
      //   68: ifeq +17 -> 85
      //   71: getstatic 113	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
      //   74: ldc2_w 114
      //   77: ldc2_w 171
      //   80: lconst_1
      //   81: iconst_0
      //   82: invokevirtual 121	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
      //   85: invokestatic 175	com/tencent/mm/kernel/b$b:aGV	()I
      //   88: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   91: astore 4
      //   93: aload_3
      //   94: astore_2
      //   95: aload 4
      //   97: ifnull +103 -> 200
      //   100: ldc 51
      //   102: ldc 177
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
      //   121: getfield 170	com/tencent/mm/storage/an:VfF	Z
      //   124: invokestatic 182	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   127: aastore
      //   128: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   131: getstatic 18	com/tencent/mm/kernel/b$b:kcb	Z
      //   134: ifeq +53 -> 187
      //   137: ldc 51
      //   139: ldc 184
      //   141: iconst_2
      //   142: anewarray 4	java/lang/Object
      //   145: dup
      //   146: iconst_0
      //   147: aload 4
      //   149: aastore
      //   150: dup
      //   151: iconst_1
      //   152: invokestatic 65	com/tencent/mm/sdk/platformtools/Util:getStack	()Lcom/tencent/mm/sdk/platformtools/MMStack;
      //   155: aastore
      //   156: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   159: getstatic 113	com/tencent/mm/plugin/report/f:Iyx	Lcom/tencent/mm/plugin/report/f;
      //   162: sipush 11911
      //   165: iconst_1
      //   166: anewarray 4	java/lang/Object
      //   169: dup
      //   170: iconst_0
      //   171: aload 4
      //   173: invokestatic 190	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/Integer;)I
      //   176: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   179: aastore
      //   180: invokevirtual 193	com/tencent/mm/plugin/report/f:a	(I[Ljava/lang/Object;)V
      //   183: iconst_0
      //   184: putstatic 18	com/tencent/mm/kernel/b$b:kcb	Z
      //   187: aload 5
      //   189: aload 4
      //   191: invokevirtual 196	java/lang/Integer:intValue	()I
      //   194: invokestatic 198	com/tencent/mm/kernel/b$b:a	(Lcom/tencent/mm/storage/an;I)V
      //   197: aload 4
      //   199: astore_2
      //   200: ldc 51
      //   202: ldc 200
      //   204: iconst_1
      //   205: anewarray 4	java/lang/Object
      //   208: dup
      //   209: iconst_0
      //   210: aload_2
      //   211: invokestatic 190	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/Integer;)I
      //   214: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   217: aastore
      //   218: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   221: aload_2
      //   222: invokestatic 190	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/Integer;)I
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
      //   20	168	5	localan	an
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
    
    private static int aGV()
    {
      AppMethodBeat.i(213286);
      int i = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.avK()).getInt("default_uin", 0);
      AppMethodBeat.o(213286);
      return i;
    }
    
    private int getUin()
    {
      try
      {
        AppMethodBeat.i(132008);
        if (!this.mLoaded)
        {
          aGU();
          this.mLoaded = true;
        }
        int i = this.uin;
        AppMethodBeat.o(132008);
        return i;
      }
      finally {}
    }
    
    public static void sD(int paramInt)
    {
      AppMethodBeat.i(213294);
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("system_config_prefs");
      localMultiProcessMMKV.encode("default_uin_timely", paramInt);
      localMultiProcessMMKV.encode("has_uin_timely", true);
      AppMethodBeat.o(213294);
    }
    
    private void setUin(int paramInt)
    {
      try
      {
        AppMethodBeat.i(132009);
        Log.i("MMKernel.CoreAccount", "Uin From %s To %s hash:%d thread:%d[%s] stack:%s", new Object[] { p.getString(this.uin), p.getString(paramInt), Integer.valueOf(com.tencent.mm.b.i.cA(paramInt, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), Util.getStack() });
        Assert.assertNotNull(this.kca);
        a(this.kca, paramInt);
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
    
    public final void a(an paraman)
    {
      try
      {
        this.kca = paraman;
        return;
      }
      finally
      {
        paraman = finally;
        throw paraman;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.b
 * JD-Core Version:    0.7.0.1
 */