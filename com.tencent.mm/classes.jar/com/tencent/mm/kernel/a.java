package com.tencent.mm.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.ac;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.i;
import com.tencent.mm.b.p;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.f;
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
import com.tencent.mm.storage.ck;
import com.tencent.mm.storage.cq;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.g.a;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.y;
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
  private static boolean hpG;
  private static boolean hpH;
  static b hpJ;
  private static String hpK;
  private static String hpL;
  private static boolean hpM;
  private static int hpV;
  private com.tencent.mm.kernel.api.c hpE;
  private ac hpF;
  byte[] hpI;
  public com.tencent.mm.model.a hpN;
  public e.c hpO;
  public int hpP;
  public boolean hpQ;
  private boolean hpR;
  public int hpS;
  public int hpT;
  private List<bc> hpU;
  long hpW;
  private volatile a hpX;
  public volatile boolean hpY;
  private String hpZ;
  private Map<String, Integer> hqa;
  
  static
  {
    AppMethodBeat.i(132045);
    hpG = true;
    hpH = false;
    hpJ = new b();
    hpK = "NoResetUinStack";
    hpL = null;
    hpV = -1;
    AppMethodBeat.o(132045);
  }
  
  public a(com.tencent.mm.kernel.api.c paramc)
  {
    AppMethodBeat.i(132014);
    this.hpI = new byte[0];
    this.hpQ = false;
    this.hpR = false;
    this.hpS = 0;
    this.hpU = new LinkedList();
    this.hpX = a.hqc;
    this.hpY = false;
    this.hpZ = "";
    this.hqa = new HashMap();
    Assert.assertNotNull(hpJ);
    g.aAi();
    boolean bool;
    if (Util.nullAsNil((Integer)g.aAh().hqB.get(17)) != 0)
    {
      bool = true;
      hpG = bool;
      if (!f.KyZ) {
        break label144;
      }
    }
    label144:
    for (int i = 763;; i = 702)
    {
      com.tencent.mm.protocal.j.e.a.Kzx = new bh(i);
      this.hpE = paramc;
      AppMethodBeat.o(132014);
      return;
      bool = false;
      break;
    }
  }
  
  public static String FL(String paramString)
  {
    hpL = paramString;
    return paramString;
  }
  
  public static void FM(String paramString)
  {
    hpK = paramString;
  }
  
  public static int FN(String paramString)
  {
    AppMethodBeat.i(132044);
    g.aAi();
    if (g.aAf().hqa.get(paramString) == null) {}
    int j;
    for (int i = 0;; i = ((Integer)g.aAf().hqa.get(paramString)).intValue())
    {
      j = (int)Util.nowSecond();
      if (i != 0) {
        break;
      }
      g.aAi();
      g.aAf().hqa.put(paramString, Integer.valueOf(j));
      AppMethodBeat.o(132044);
      return i;
      g.aAi();
    }
    i = j - i;
    g.aAi();
    g.aAf().hqa.put(paramString, Integer.valueOf(j));
    if (i >= 0)
    {
      AppMethodBeat.o(132044);
      return i;
    }
    AppMethodBeat.o(132044);
    return 0;
  }
  
  public static SharedPreferences apK()
  {
    AppMethodBeat.i(132035);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("notify_key_pref_settings", com.tencent.mm.compatible.util.g.aps());
    AppMethodBeat.o(132035);
    return localSharedPreferences;
  }
  
  public static String ayV()
  {
    AppMethodBeat.i(132016);
    String str = new p(b.a(hpJ)).toString();
    AppMethodBeat.o(132016);
    return str;
  }
  
  public static final int ayW()
  {
    AppMethodBeat.i(196988);
    int i = b.access$100();
    AppMethodBeat.o(196988);
    return i;
  }
  
  public static String ayX()
  {
    return hpL;
  }
  
  public static boolean ayY()
  {
    return hpM;
  }
  
  public static void ayZ()
  {
    hpM = true;
  }
  
  public static String aza()
  {
    return hpK;
  }
  
  protected static void azb()
  {
    AppMethodBeat.i(132017);
    b.a(hpJ, 0);
    AppMethodBeat.o(132017);
  }
  
  protected static void azc()
  {
    AppMethodBeat.i(132018);
    b.a(hpJ, 0);
    AppMethodBeat.o(132018);
  }
  
  private void azd()
  {
    AppMethodBeat.i(132019);
    this.hpX = a.hqc;
    this.hpY = false;
    Log.i("MMKernel.CoreAccount", "mAccountStatus to NotReady");
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("isLogin", false).commit();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
    Log.w("MMKernel.CoreAccount", "[arthurdan.AccountNR] account storage reset! uin:%d, resetStack is:%s, resetTime:%s", new Object[] { Integer.valueOf(b.a(hpJ)), hpK, localSimpleDateFormat.format(new Date()) });
    AppMethodBeat.o(132019);
  }
  
  public static boolean azi()
  {
    return hpH;
  }
  
  public static boolean azj()
  {
    AppMethodBeat.i(132025);
    if (hpG)
    {
      g.aAi();
      if (g.aAf() == null) {
        break label81;
      }
      g.aAi();
      g.aAf();
    }
    label81:
    for (String str = p.getString(b.a(hpJ));; str = "-1")
    {
      Log.w("MMKernel.CoreAccount", "account holded :%s init:%b", new Object[] { str, Boolean.valueOf(g.aAf().azp()) });
      boolean bool = hpG;
      AppMethodBeat.o(132025);
      return bool;
    }
  }
  
  public static int azm()
  {
    AppMethodBeat.i(132034);
    int i = apK().getInt("notification.user.state", 0);
    AppMethodBeat.o(132034);
    return i;
  }
  
  public static boolean azo()
  {
    AppMethodBeat.i(132039);
    if (b.a(hpJ) != 0)
    {
      AppMethodBeat.o(132039);
      return true;
    }
    AppMethodBeat.o(132039);
    return false;
  }
  
  public static int azs()
  {
    AppMethodBeat.i(132041);
    Integer localInteger2 = Integer.valueOf(MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.aps()).getInt("default_uin", 0));
    Integer localInteger1 = localInteger2;
    if (localInteger2.intValue() == 0)
    {
      localInteger2 = Integer.valueOf(MultiProcessMMKV.getMMKV("system_config_prefs").decodeInt("default_uin", 0));
      localInteger1 = localInteger2;
      if (localInteger2.intValue() != 0)
      {
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 151L, 1L, false);
        Log.e("MMKernel.CoreAccount", "getUinFromSharedPreferences get from sp fail");
        localInteger1 = localInteger2;
      }
    }
    int i = localInteger1.intValue();
    AppMethodBeat.o(132041);
    return i;
  }
  
  public static String azt()
  {
    AppMethodBeat.i(132042);
    g.aAi();
    if (Util.isNullOrNil(g.aAf().hpZ))
    {
      g.aAi();
      g.aAf().hpZ = (q.aoG() + "_" + System.currentTimeMillis());
    }
    g.aAi();
    String str = g.aAf().hpZ;
    AppMethodBeat.o(132042);
    return str;
  }
  
  public static void azu()
  {
    AppMethodBeat.i(132043);
    g.aAi();
    g.aAf().hpZ = "";
    g.aAi();
    g.aAf().hqa.clear();
    AppMethodBeat.o(132043);
  }
  
  public static void es(boolean paramBoolean)
  {
    hpH = paramBoolean;
  }
  
  public static String getSalt()
  {
    AppMethodBeat.i(196987);
    g.aAi();
    String str = g.aAh().azQ().a(ar.a.Oop, null);
    AppMethodBeat.o(196987);
    return str;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(132015);
    int i = b.a(hpJ);
    AppMethodBeat.o(132015);
    return i;
  }
  
  public static void hold()
  {
    AppMethodBeat.i(132026);
    g.aAi();
    if (g.aAf() != null)
    {
      g.aAi();
      g.aAf();
    }
    for (String str = p.getString(b.a(hpJ));; str = "-1")
    {
      Log.w("MMKernel.CoreAccount", " HOLD ACCOUNT! uin:%s stack:%s init:%b", new Object[] { str, Util.getStack(), Boolean.valueOf(g.aAf().azp()) });
      hpG = true;
      g.aAi();
      g.aAh().hqB.set(17, Integer.valueOf(1));
      AppMethodBeat.o(132026);
      return;
    }
  }
  
  static boolean qb(int paramInt)
  {
    return paramInt != 0;
  }
  
  public static void qc(int paramInt)
  {
    AppMethodBeat.i(132033);
    if ((hpV != -1) && (hpV == paramInt))
    {
      AppMethodBeat.o(132033);
      return;
    }
    hpV = paramInt;
    apK().edit().putInt("notification.user.state", paramInt).commit();
    Log.i("MMKernel.CoreAccount", "[NOTIFICATION SETTINGS]save UserStatus: %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(132033);
  }
  
  public static boolean qd(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static void unhold()
  {
    AppMethodBeat.i(132027);
    g.aAi();
    if (g.aAf() != null)
    {
      g.aAi();
      g.aAf();
    }
    for (String str = p.getString(b.a(hpJ));; str = "-1")
    {
      Log.w("MMKernel.CoreAccount", " UN HOLD ACCOUNT! uin:%s init:%b", new Object[] { str, Boolean.valueOf(g.aAf().azp()) });
      hpG = false;
      g.aAi();
      g.aAh().hqB.set(17, Integer.valueOf(0));
      AppMethodBeat.o(132027);
      return;
    }
  }
  
  public final void a(bc parambc)
  {
    AppMethodBeat.i(132029);
    Log.i("MMKernel.CoreAccount", "UserStatusChange: add %s", new Object[] { parambc });
    synchronized (this.hpU)
    {
      if (!this.hpU.contains(parambc)) {
        this.hpU.add(parambc);
      }
      AppMethodBeat.o(132029);
      return;
    }
  }
  
  final void aze()
  {
    AppMethodBeat.i(132020);
    Log.w("MMKernel.CoreAccount", "account storage release  uin:%s thread:%s stack:%s", new Object[] { p.getString(b.a(hpJ)), Thread.currentThread().getName(), Util.getStack() });
    if (!azp())
    {
      Log.i("MMKernel.CoreAccount", "Fatal crash error!!! status is not initialized when release(), this callStack is:%s, last reset stack is:%s", new Object[] { Util.getStack().toString(), hpK });
      AppMethodBeat.o(132020);
      return;
    }
    this.hpE.onAccountRelease();
    g.aAi();
    g.aAh().CL(null);
    azd();
    g.aAi();
    g.aAh().hqS.clear();
    AppMethodBeat.o(132020);
  }
  
  public final void azf()
  {
    AppMethodBeat.i(132022);
    if (!this.hpR)
    {
      Log.i("MMKernel.CoreAccount", "no need do account initialized notify.");
      AppMethodBeat.o(132022);
      return;
    }
    this.hpR = false;
    Log.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized tid:%d, stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Util.getStack() });
    long l = System.currentTimeMillis();
    this.hpE.onAccountInitialized(this.hpO);
    Log.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized run tid[%d] take[%d]ms", new Object[] { Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l) });
    azg();
    AppMethodBeat.o(132022);
  }
  
  public final void azg()
  {
    AppMethodBeat.i(132023);
    if ((azp()) && (com.tencent.mm.kernel.a.c.aAu().hsa))
    {
      Log.i("MMKernel.CoreAccount", "Flush client version.");
      g.aAh().azI();
    }
    AppMethodBeat.o(132023);
  }
  
  public final ac azh()
  {
    try
    {
      AppMethodBeat.i(132024);
      if (this.hpF == null) {
        this.hpF = new ac();
      }
      ac localac = this.hpF;
      AppMethodBeat.o(132024);
      return localac;
    }
    finally {}
  }
  
  public final void azk()
  {
    AppMethodBeat.i(132028);
    if (!azp())
    {
      com.tencent.mm.model.b localb = new com.tencent.mm.model.b();
      AppMethodBeat.o(132028);
      throw localb;
    }
    AppMethodBeat.o(132028);
  }
  
  public final void azl()
  {
    AppMethodBeat.i(132031);
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132002);
        bc[] arrayOfbc = new bc[a.b(a.this).size()];
        a.b(a.this).toArray(arrayOfbc);
        int j = arrayOfbc.length;
        int i = 0;
        while (i < j)
        {
          arrayOfbc[i].aVw();
          i += 1;
        }
        AppMethodBeat.o(132002);
      }
    });
    AppMethodBeat.o(132031);
  }
  
  public final boolean azn()
  {
    AppMethodBeat.i(132036);
    boolean bool = qd(this.hpS);
    AppMethodBeat.o(132036);
    return bool;
  }
  
  public final boolean azp()
  {
    return this.hpX == a.hqd;
  }
  
  public final boolean azq()
  {
    return this.hpY;
  }
  
  public final void azr()
  {
    AppMethodBeat.i(132040);
    Log.i("MMKernel.CoreAccount", "summerasyncinit setInitializedNotifyAllDone[%b] to true stack[%s]", new Object[] { Boolean.valueOf(this.hpY), Util.getStack() });
    this.hpY = true;
    long l = SystemClock.elapsedRealtime();
    Log.i("MMKernel.CoreAccount", "summerhardcoder setInitializedNotifyAllDone [%d %d] take[%d]ms, stack[%s]", new Object[] { Long.valueOf(this.hpW), Long.valueOf(l), Long.valueOf(l - this.hpW), Util.getStack() });
    co localco = new co();
    EventCenter.instance.publish(localco);
    AppMethodBeat.o(132040);
  }
  
  public final void b(bc parambc)
  {
    AppMethodBeat.i(132030);
    Log.i("MMKernel.CoreAccount", "UserStatusChange: remove %s", new Object[] { parambc });
    synchronized (this.hpU)
    {
      this.hpU.remove(parambc);
      AppMethodBeat.o(132030);
      return;
    }
  }
  
  public final void cU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132032);
    if ((this.hpS != paramInt1) || (this.hpT != paramInt2)) {}
    for (int i = 1;; i = 0)
    {
      Log.d("MMKernel.CoreAccount", "online status, %d, %d, %d ,%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.hpT), Integer.valueOf(this.hpS) });
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(132032);
      return;
    }
    this.hpS = paramInt1;
    this.hpT = paramInt2;
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132003);
        a.this.azl();
        AppMethodBeat.o(132003);
      }
    });
    AppMethodBeat.o(132032);
  }
  
  final void er(boolean paramBoolean)
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
        i = g.aAk().getProcessTid();
        this.hpP = WXHardCoderJNI.startPerformance(bool1, j, k, m, i, WXHardCoderJNI.hcBootTimeout, 101, WXHardCoderJNI.hcBootAction, "MMKernel.CoreAccount");
        Log.i("MMKernel.CoreAccount", "summerhardcoder startPerformance[%s] stack[%s]", new Object[] { Integer.valueOf(this.hpP), Util.getStack() });
      }
    }
    else
    {
      Log.i("MMKernel.CoreAccount", "UserStatusChange: clear");
    }
    for (;;)
    {
      synchronized (this.hpU)
      {
        this.hpU.clear();
        long l1 = System.currentTimeMillis();
        k = b.a(hpJ);
        Log.i("MMKernel.CoreAccount", "dkacc setAccuin %s hash:%d thread:%d[%s] stack:%s", new Object[] { p.getString(k), Integer.valueOf(i.ch(k, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), Util.getStack() });
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
          i = 0;
        }
      }
      i = 0;
    }
    CrashReportFactory.setReportID(p.getString(k));
    g.aAi();
    e locale = g.aAh();
    Object localObject5 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132001);
        a.a(a.this);
        AppMethodBeat.o(132001);
      }
    };
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("isLogin", true).apply();
    ??? = com.tencent.mm.b.g.getMessageDigest("mm".concat(String.valueOf(k)).getBytes());
    Object localObject3 = e.E(k, (String)???);
    Log.i("MMKernel.CoreStorage", "uinPath: %s, uinSaltPath: %s", new Object[] { ???, localObject3 });
    boolean bool4 = com.tencent.mm.compatible.util.e.apn();
    label418:
    Object localObject4;
    label468:
    long l2;
    label520:
    Object localObject6;
    if (localObject3 == null)
    {
      Log.w("MMKernel.CoreStorage", "Cannot generate account path, skip account renaming!");
      i = 6;
      bool1 = false;
      locale.hqH = ((String)???);
      locale.cachePath = (ar.NSe + locale.hqH + '/');
      if (!bool1) {
        break label1207;
      }
      localObject4 = localObject3;
      locale.hqJ = ((String)localObject4);
      locale.hqG = (locale.hqF + locale.hqJ + '/');
      if (localObject3 != null) {
        break label1214;
      }
      localObject4 = ???;
      locale.hqI = ((String)localObject4);
      y.apG(i);
      localObject4 = new o(locale.cachePath);
      Log.i("MMKernel.CoreStorage", "dkacc cachePath:" + locale.cachePath + " accPath:" + locale.hqG);
      if (((o)localObject4).exists()) {
        break label2995;
      }
      Log.w("MMKernel.CoreStorage", "setUin REBUILD data now ! DO NOT FUCKING TELL ME DB BROKEN !!! uin:%s data:%s sd:%s", new Object[] { p.getString(k), locale.cachePath, locale.hqG });
      ((o)localObject4).mkdirs();
      if (!locale.cachePath.equalsIgnoreCase(locale.hqG))
      {
        l2 = System.currentTimeMillis();
        localObject4 = new o(locale.hqG);
        localObject6 = (String)??? + "temp" + System.currentTimeMillis();
        localObject6 = com.tencent.mm.loader.j.b.aKJ() + (String)localObject6;
        ((o)localObject4).am(new o((String)localObject6));
        Log.i("MMKernel.CoreStorage", "find the old files and rename then %s" + (System.currentTimeMillis() - l2), new Object[] { localObject6 });
      }
    }
    label1540:
    label1583:
    label1969:
    label2995:
    for (boolean bool2 = true;; bool2 = false)
    {
      locale.hqR = new com.tencent.mm.model.cp(locale.cachePath, bool2);
      locale.azJ();
      localObject4 = locale.cachePath + "MicroMsg.db";
      localObject6 = locale.cachePath + "EnMicroMsg.db";
      String str = locale.cachePath + "EnMicroMsg2.db";
      locale.CL(null);
      locale.FP((String)localObject6);
      locale.hqK = new h(new e.2(locale));
      Object localObject7 = locale.hqK;
      l2 = k;
      q.dr(true);
      if (!((h)localObject7).b((String)localObject4, (String)localObject6, str, l2, e.getBaseDBFactories(), true))
      {
        ??? = new SQLiteException("main db init failed");
        AppMethodBeat.o(132021);
        throw ((Throwable)???);
        if ((!locale.hqF.startsWith(com.tencent.mm.loader.j.b.aKD())) || (!bool4))
        {
          Log.w("MMKernel.CoreStorage", "SDCard not available, skip account renaming!");
          i = 1;
          bool1 = false;
          break label418;
        }
        localObject4 = new o(locale.hqF + (String)???);
        localObject6 = new o(locale.hqF + (String)localObject3);
        if (((o)localObject4).isDirectory())
        {
          if (((o)localObject6).isDirectory())
          {
            Log.i("MMKernel.CoreStorage", "Both uinPath exists, migration shall be taken.");
            i = 2;
            bool1 = true;
            break label418;
          }
          ((o)localObject6).delete();
          Log.i("MMKernel.CoreStorage", "Move account directory: %s => %s", new Object[] { localObject4, localObject6 });
          if (!((o)localObject4).am((o)localObject6))
          {
            Log.w("MMKernel.CoreStorage", "Failed to move uinPath, use old accPath");
            i = 4;
            bool1 = false;
            break label418;
          }
          Log.i("MMKernel.CoreStorage", "Moved to new uinPath");
          i = 3;
          bool1 = true;
          break label418;
        }
        if (!((o)localObject6).isDirectory()) {
          ((o)localObject6).delete();
        }
        ((o)localObject6).mkdirs();
        i = 5;
        bool1 = true;
        break label418;
        label1207:
        localObject4 = ???;
        break label468;
        label1214:
        localObject4 = localObject3;
        break label520;
      }
      localObject7 = locale.hqK.OtE;
      if (!Util.isNullOrNil((String)localObject7))
      {
        Log.e("MMKernel.CoreStorage", "dbinit failed :".concat(String.valueOf(localObject7)));
        CrashReportFactory.reportRawMessage("init db Failed: [ " + (String)localObject7 + "]", "DBinit");
      }
      localObject7 = locale.hqK;
      if (((h)localObject7).OtB != null) {}
      for (boolean bool3 = ((h)localObject7).OtB.OsV;; bool3 = false)
      {
        if (bool3) {
          locale.hqQ = true;
        }
        locale.hqM = new ao(locale.hqK);
        locale.hqO = new cq(locale.hqK);
        locale.hqK.OtD = new e.3(locale);
        locale.hqP = locale.hqO.gEy();
        locale.hqL = new h(locale.hqE);
        localObject7 = locale.hqL;
        l2 = k;
        q.dr(true);
        if (((h)localObject7).b((String)localObject4, (String)localObject6, str, l2, new HashMap(), true)) {
          break;
        }
        ??? = new com.tencent.mm.model.b((byte)0);
        AppMethodBeat.o(132021);
        throw ((Throwable)???);
      }
      locale.hqN = new ck(locale.hqM);
      locale.hqN.add(new e.4(locale));
      locale.hqN.gEr();
      ((Runnable)localObject5).run();
      if ((bool4) && (locale.hqF.startsWith(com.tencent.mm.loader.j.b.aKD())))
      {
        bool3 = true;
        localObject5 = com.tencent.mm.vfs.g.hRR().hRT();
        localObject6 = ((g.a)localObject5).nt("account", (String)???).nt("accountSalt", locale.hqI);
        if (!bool3) {
          break label1969;
        }
        localObject4 = locale.hqI;
        ((g.a)localObject6).nt("accountSd", (String)localObject4);
        if (localObject3 == null) {
          break label1976;
        }
        bool4 = true;
        label1602:
        y.a((g.a)localObject5, bool3, bool4);
        y.a((g.a)localObject5, locale.hqF, bool1);
        ((g.a)localObject5).Dx(false);
        Log.i("VFS.Debug", "SetEnv ${account} = ".concat(String.valueOf(???)));
        y.Dz(bool1);
        if (bool2)
        {
          l2 = ((Long)locale.hqM.get(ar.a.NZx, Long.valueOf(0L))).longValue();
          i = ((Integer)locale.hqM.get(ar.a.NZy, Integer.valueOf(0))).intValue();
          if (l2 <= 0L) {
            break label1982;
          }
          Log.w("MMKernel.CoreStorage", "summerinstall new install but firsttime[%d] > 0", new Object[] { Long.valueOf(l2) });
          label1731:
          if (i <= 0) {
            break label2002;
          }
          Log.w("MMKernel.CoreStorage", "summerinstall new install but version[%d] > 0", new Object[] { Integer.valueOf(i) });
          label1755:
          Log.i("MMKernel.CoreStorage", "edw setAccUin, summerinstall time[%d]，version[%d], clientversion[%d]", new Object[] { (Long)locale.hqM.get(ar.a.NZx, Long.valueOf(0L)), (Integer)locale.hqM.get(ar.a.NZy, Integer.valueOf(0)), Integer.valueOf(d.KyO) });
        }
        if (paramBoolean) {
          break label2027;
        }
        g.aAi();
        ??? = Util.nullAsNil((String)g.aAh().azQ().get(2, null));
        Log.i("MMKernel.CoreAccount", "summerinit validateUsername username[%s]", new Object[] { ??? });
        if (((String)???).length() > 0) {
          break label2022;
        }
        Log.e("MMKernel.CoreAccount", "username of acc stg not set: uin=" + b.a(hpJ));
        azd();
        b.a(hpJ, 0);
        hpK = Util.getStack().toString();
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(132004);
            g.aAi().releaseAll();
            AppMethodBeat.o(132004);
          }
        });
      }
      label1976:
      label1982:
      label2002:
      label2022:
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label2027;
        }
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(598L, 21L, 1L, true);
        Log.w("MMKernel.CoreAccount", "setAccUin, validateUsername false no need initialize!");
        break;
        bool3 = false;
        break label1540;
        localObject4 = ???;
        break label1583;
        bool4 = false;
        break label1602;
        locale.hqM.set(ar.a.NZx, Long.valueOf(System.currentTimeMillis()));
        break label1731;
        locale.hqM.set(ar.a.NZy, Integer.valueOf(d.KyO));
        break label1755;
      }
      label2027:
      ??? = new com.tencent.mm.g.a.cp();
      EventCenter.instance.publish((IEvent)???);
      g.aAi();
      ??? = g.aAh();
      localObject3 = new e.c();
      j = Util.nullAsNil((Integer)((e)???).hqM.get(14, null));
      m = d.KyO;
      Log.d("MMKernel.CoreStorage", "sVer: %s, cVer: %s.", new Object[] { Integer.toHexString(j), Integer.toHexString(m) });
      if (m == j) {
        paramBoolean = false;
      }
      for (;;)
      {
        label2122:
        if (paramBoolean)
        {
          ((e)???).hqM.set(8197, "");
          ((e)???).hqM.set(15, Integer.valueOf(0));
        }
        if (j != m)
        {
          bool1 = true;
          label2162:
          if ((j > 620822536) || (j == m)) {
            break label2875;
          }
          ((e)???).hqM.set(274480, Boolean.TRUE);
          Log.i("MMKernel.CoreStorage", "[initialize] need init emoji");
          if ((j != 0) && (j < 637599744)) {
            ((e)???).hqM.set(348162, Boolean.TRUE);
          }
          if (j == m) {
            break label2901;
          }
          i = 1;
          label2231:
          if (i == 0) {
            break label2939;
          }
          Log.w("MMKernel.CoreStorage", "account storage version changed from " + Integer.toHexString(j) + " to " + Integer.toHexString(m) + ", init=" + paramBoolean);
          if (((Integer)((e)???).hqB.get(37, Integer.valueOf(0))).intValue() == 0) {
            ((e)???).hqB.set(37, Integer.valueOf(j));
          }
          ((e)???).hqM.set(30, Boolean.FALSE);
          ((e)???).hqM.set(-2046825377, Boolean.FALSE);
          ((e)???).hqM.set(-2046825369, Boolean.FALSE);
          ((e)???).hqM.set(54, Boolean.FALSE);
          ((e)???).hqM.set(-2046825368, Boolean.FALSE);
          ((e)???).hqM.set(-2046825366, Boolean.TRUE);
          ((e)???).hqM.set(62, Boolean.TRUE);
          MMApplicationContext.getContext().getSharedPreferences("update_config_prefs", com.tencent.mm.compatible.util.g.aps()).edit().clear().commit();
          if (j != 0) {
            break label2906;
          }
          ((e)???).hqT = true;
          if (((e)???).hqM.getInt(ar.a.Olo, -1) <= 0) {
            break label2958;
          }
          paramBoolean = true;
          Log.i("MMKernel.CoreStorage", "unlock show_whatsnew from testWhatsNew, %s.", new Object[] { Boolean.valueOf(paramBoolean) });
          ((e.c)localObject3).hrc = bool1;
          ((e.c)localObject3).hrd = j;
          this.hpO = ((e.c)localObject3);
          Log.i("MMKernel.CoreAccount", "check is update :%b ", new Object[] { Boolean.valueOf(((e.c)localObject3).hrc) });
          this.hpR = true;
          if (!this.hpQ)
          {
            azf();
            g.aAf().azr();
          }
          bf.iDu.aO("last_login_uin", p.getString(k));
          com.tencent.mm.plugin.report.e.Cxv.setUin(k);
          if (getClass().getClassLoader() != null) {
            break label2963;
          }
          i = -1;
          if (Thread.currentThread().getContextClassLoader() != null) {
            break label2977;
          }
        }
        for (j = -1;; j = Thread.currentThread().getContextClassLoader().hashCode())
        {
          Log.i("MMKernel.CoreAccount", "SmcLogic.setUin, class loader %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          this.hpN = new com.tencent.mm.model.a();
          Log.i("MMKernel.CoreAccount", "setAccUin done :%s", new Object[] { p.getString(k) });
          ??? = new hc();
          EventCenter.instance.publish((IEvent)???);
          g.aAi();
          if (g.aAg().hqi == null) {
            break;
          }
          g.aAi();
          if (g.aAg().hqi.iMw == null) {
            break;
          }
          g.aAi();
          g.aAg().hqi.iMw.fz(true);
          g.aAi();
          ??? = g.aAg().hqi.iMw.aZh();
          if ((k == 0) || (??? == null) || (k == ((com.tencent.mm.network.e)???).getUin())) {
            break;
          }
          Log.w("MMKernel.CoreAccount", "summerauth update acc info with acc stg: old acc uin=%d, this uin=%d", new Object[] { Integer.valueOf(((com.tencent.mm.network.e)???).getUin()), Integer.valueOf(k) });
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 46L, 1L, false);
          ((com.tencent.mm.network.e)???).setUin(k);
          break;
          if ((m > 570425344) && (j <= 570425344))
          {
            paramBoolean = true;
            break label2122;
          }
          if ((m <= 570556456) || (j > 570556456)) {
            break label2990;
          }
          paramBoolean = true;
          break label2122;
          bool1 = false;
          break label2162;
          label2875:
          ((e)???).hqM.set(274480, Boolean.FALSE);
          Log.i("MMKernel.CoreStorage", "[initialize] need not init emoji");
          break label2198;
          label2901:
          i = 0;
          break label2231;
          label2906:
          if ((0xFF000000 & j) != (0xFF000000 & m)) {
            break label2455;
          }
          Log.d("MMKernel.CoreStorage", "lock show_whatsnew by same major version");
          MMEntryLock.lock("show_whatsnew");
          break label2455;
          label2939:
          Log.d("MMKernel.CoreStorage", "lock show_whatsnew from else.");
          MMEntryLock.lock("show_whatsnew");
          break label2455;
          paramBoolean = false;
          break label2472;
          i = getClass().getClassLoader().hashCode();
          break label2591;
        }
        paramBoolean = false;
      }
    }
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(132038);
    if (azp())
    {
      AppMethodBeat.o(132038);
      return;
    }
    synchronized (this.hpI)
    {
      if (azp())
      {
        AppMethodBeat.o(132038);
        return;
      }
      int i = b.a(hpJ);
      if (i != 0)
      {
        this.hpW = SystemClock.elapsedRealtime();
        Log.w("MMKernel.CoreAccount", "auto set up account storage uin: %d, stack: %s", new Object[] { Integer.valueOf(i), Util.getStack() });
        er(false);
      }
      AppMethodBeat.o(132038);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(132037);
    synchronized (this.hpI)
    {
      aze();
      AppMethodBeat.o(132037);
      return;
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(132007);
      hqc = new a("NotReady", 0);
      hqd = new a("AccountHasReady", 1);
      hqe = new a[] { hqc, hqd };
      AppMethodBeat.o(132007);
    }
    
    private a() {}
  }
  
  static final class b
  {
    private static boolean hqg = true;
    private an hqf;
    private boolean mLoaded = false;
    private int uin = 0;
    
    private static void a(an paraman, int paramInt)
    {
      AppMethodBeat.i(132011);
      Log.i("MMKernel.CoreAccount", "setSysUin uin: %d, stack: %s", new Object[] { Integer.valueOf(paramInt), Util.getStack() });
      if (!MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.aps()).edit().putInt("default_uin", paramInt).commit())
      {
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 150L, 1L, false);
        Log.e("MMKernel.CoreAccount", "uin_sp save fail");
      }
      MultiProcessMMKV.getMMKV("system_config_prefs").encode("default_uin", paramInt);
      paraman.set(1, Integer.valueOf(paramInt));
      paraman.gBH();
      AppMethodBeat.o(132011);
    }
    
    /* Error */
    private void azv()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc 153
      //   6: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: getfield 155	com/tencent/mm/kernel/a$b:hqf	Lcom/tencent/mm/storage/an;
      //   13: invokestatic 161	junit/framework/Assert:assertNotNull	(Ljava/lang/Object;)V
      //   16: aload_0
      //   17: getfield 155	com/tencent/mm/kernel/a$b:hqf	Lcom/tencent/mm/storage/an;
      //   20: astore 5
      //   22: aload 5
      //   24: ifnonnull +23 -> 47
      //   27: ldc 51
      //   29: ldc 163
      //   31: invokestatic 166	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   34: aload_0
      //   35: iload_1
      //   36: putfield 24	com/tencent/mm/kernel/a$b:uin	I
      //   39: ldc 153
      //   41: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   44: aload_0
      //   45: monitorexit
      //   46: return
      //   47: aload 5
      //   49: iconst_1
      //   50: invokevirtual 170	com/tencent/mm/storage/an:get	(I)Ljava/lang/Object;
      //   53: checkcast 55	java/lang/Integer
      //   56: astore_3
      //   57: aload_3
      //   58: astore_2
      //   59: aload_3
      //   60: ifnonnull +140 -> 200
      //   63: aload 5
      //   65: getfield 173	com/tencent/mm/storage/an:NRI	Z
      //   68: ifeq +17 -> 85
      //   71: getstatic 113	com/tencent/mm/plugin/report/e:Cxv	Lcom/tencent/mm/plugin/report/e;
      //   74: ldc2_w 114
      //   77: ldc2_w 174
      //   80: lconst_1
      //   81: iconst_0
      //   82: invokevirtual 121	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
      //   85: invokestatic 151	com/tencent/mm/kernel/a$b:azw	()I
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
      //   121: getfield 173	com/tencent/mm/storage/an:NRI	Z
      //   124: invokestatic 182	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   127: aastore
      //   128: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   131: getstatic 18	com/tencent/mm/kernel/a$b:hqg	Z
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
      //   159: getstatic 113	com/tencent/mm/plugin/report/e:Cxv	Lcom/tencent/mm/plugin/report/e;
      //   162: sipush 11911
      //   165: iconst_1
      //   166: anewarray 4	java/lang/Object
      //   169: dup
      //   170: iconst_0
      //   171: aload 4
      //   173: invokestatic 190	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/Integer;)I
      //   176: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   179: aastore
      //   180: invokevirtual 193	com/tencent/mm/plugin/report/e:a	(I[Ljava/lang/Object;)V
      //   183: iconst_0
      //   184: putstatic 18	com/tencent/mm/kernel/a$b:hqg	Z
      //   187: aload 5
      //   189: aload 4
      //   191: invokevirtual 196	java/lang/Integer:intValue	()I
      //   194: invokestatic 198	com/tencent/mm/kernel/a$b:a	(Lcom/tencent/mm/storage/an;I)V
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
    
    private static int azw()
    {
      AppMethodBeat.i(196985);
      int i = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.aps()).getInt("default_uin", 0);
      AppMethodBeat.o(196985);
      return i;
    }
    
    private int getUin()
    {
      try
      {
        AppMethodBeat.i(132008);
        if (!this.mLoaded)
        {
          azv();
          this.mLoaded = true;
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
        Log.i("MMKernel.CoreAccount", "Uin From %s To %s hash:%d thread:%d[%s] stack:%s", new Object[] { p.getString(this.uin), p.getString(paramInt), Integer.valueOf(i.ch(paramInt, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), Util.getStack() });
        Assert.assertNotNull(this.hqf);
        a(this.hqf, paramInt);
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
        this.hqf = paraman;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a
 * JD-Core Version:    0.7.0.1
 */