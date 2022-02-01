package com.tencent.mm.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.SystemClock;
import androidx.lifecycle.j.a;
import androidx.lifecycle.j.b;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dc;
import com.tencent.mm.autogen.a.dd;
import com.tencent.mm.autogen.a.hu;
import com.tencent.mm.b.i;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.cr;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.co;
import com.tencent.mm.storage.cu;
import com.tencent.mm.vfs.af;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.k.a;
import com.tencent.mm.vfs.u;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class b
{
  private static boolean mBG;
  private static boolean mBH;
  static c mBJ;
  private static String mBK;
  private static String mBL;
  private static boolean mBM;
  private static int mBW;
  private com.tencent.mm.kernel.api.c mBE;
  private com.tencent.mm.am.ab mBF;
  byte[] mBI;
  public com.tencent.mm.model.a mBN;
  public f.c mBO;
  public a mBP;
  public int mBQ;
  public boolean mBR;
  private boolean mBS;
  public int mBT;
  public int mBU;
  private List<bd> mBV;
  long mBX;
  private volatile b.b mBY;
  public volatile boolean mBZ;
  private String mCa;
  private Map<String, Integer> mCb;
  
  static
  {
    AppMethodBeat.i(132045);
    mBG = true;
    mBH = false;
    mBJ = new c();
    mBK = "NoResetUinStack";
    mBL = null;
    mBW = -1;
    AppMethodBeat.o(132045);
  }
  
  public b(com.tencent.mm.kernel.api.c paramc)
  {
    AppMethodBeat.i(132014);
    this.mBI = new byte[0];
    this.mBR = false;
    this.mBS = false;
    this.mBT = 0;
    this.mBV = new LinkedList();
    this.mBY = b.b.mCg;
    this.mBZ = false;
    this.mCa = "";
    this.mCb = new HashMap();
    Assert.assertNotNull(mBJ);
    h.baF();
    boolean bool;
    if (Util.nullAsNil((Integer)h.baE().mCE.get(17)) != 0)
    {
      bool = true;
      mBG = bool;
      if (!com.tencent.mm.protocal.f.Yxs) {
        break label155;
      }
    }
    label155:
    for (int i = 763;; i = 702)
    {
      com.tencent.mm.protocal.j.e.a.YxQ = new bj(i);
      this.mBE = paramc;
      this.mBP = new a();
      AppMethodBeat.o(132014);
      return;
      bool = false;
      break;
    }
  }
  
  public static String Fu(String paramString)
  {
    mBL = paramString;
    return paramString;
  }
  
  public static void Fv(String paramString)
  {
    mBK = paramString;
  }
  
  public static int Fw(String paramString)
  {
    AppMethodBeat.i(132044);
    h.baF();
    if (h.baC().mCb.get(paramString) == null) {}
    int j;
    for (int i = 0;; i = ((Integer)h.baC().mCb.get(paramString)).intValue())
    {
      j = (int)Util.nowSecond();
      if (i != 0) {
        break;
      }
      h.baF();
      h.baC().mCb.put(paramString, Integer.valueOf(j));
      AppMethodBeat.o(132044);
      return i;
      h.baF();
    }
    i = j - i;
    h.baF();
    h.baC().mCb.put(paramString, Integer.valueOf(j));
    if (i >= 0)
    {
      AppMethodBeat.o(132044);
      return i;
    }
    AppMethodBeat.o(132044);
    return 0;
  }
  
  public static SharedPreferences aQC()
  {
    AppMethodBeat.i(132035);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("notify_key_pref_settings", com.tencent.mm.compatible.util.g.aQe());
    AppMethodBeat.o(132035);
    return localSharedPreferences;
  }
  
  private void aZA()
  {
    AppMethodBeat.i(132019);
    Log.i("MMKernel.CoreAccount", "changeToNotReady");
    this.mBY = b.b.mCg;
    this.mBZ = false;
    Log.i("MMKernel.CoreAccount", "mAccountStatus to NotReady");
    MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putBoolean("isLogin", false).commit();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
    Log.w("MMKernel.CoreAccount", "[arthurdan.AccountNR] account storage reset! uin:%d, resetStack is:%s, resetTime:%s", new Object[] { Integer.valueOf(c.a(mBJ)), mBK, localSimpleDateFormat.format(new Date()) });
    AppMethodBeat.o(132019);
  }
  
  public static boolean aZF()
  {
    return mBH;
  }
  
  public static boolean aZG()
  {
    AppMethodBeat.i(132025);
    if (mBG)
    {
      h.baF();
      if (h.baC() == null) {
        break label80;
      }
      h.baF();
      h.baC();
    }
    label80:
    for (String str = com.tencent.mm.b.p.getString(c.a(mBJ));; str = "-1")
    {
      Log.w("MMKernel.CoreAccount", "account holded :%s init:%b", new Object[] { str, Boolean.valueOf(h.baC().aZN()) });
      boolean bool = mBG;
      AppMethodBeat.o(132025);
      return bool;
    }
  }
  
  public static void aZH()
  {
    AppMethodBeat.i(132026);
    h.baF();
    if (h.baC() != null)
    {
      h.baF();
      h.baC();
    }
    for (String str = com.tencent.mm.b.p.getString(c.a(mBJ));; str = "-1")
    {
      Log.w("MMKernel.CoreAccount", " HOLD ACCOUNT! uin:%s stack:%s init:%b", new Object[] { str, Util.getStack(), Boolean.valueOf(h.baC().aZN()) });
      mBG = true;
      h.baF();
      h.baE().mCE.B(17, Integer.valueOf(1));
      AppMethodBeat.o(132026);
      return;
    }
  }
  
  public static void aZI()
  {
    AppMethodBeat.i(132027);
    h.baF();
    if (h.baC() != null)
    {
      h.baF();
      h.baC();
    }
    for (String str = com.tencent.mm.b.p.getString(c.a(mBJ));; str = "-1")
    {
      Log.w("MMKernel.CoreAccount", " UN HOLD ACCOUNT! uin:%s init:%b", new Object[] { str, Boolean.valueOf(h.baC().aZN()) });
      mBG = false;
      h.baF();
      h.baE().mCE.B(17, Integer.valueOf(0));
      AppMethodBeat.o(132027);
      return;
    }
  }
  
  public static int aZL()
  {
    AppMethodBeat.i(132034);
    int i = aQC().getInt("notification.user.state", 0);
    AppMethodBeat.o(132034);
    return i;
  }
  
  public static boolean aZM()
  {
    AppMethodBeat.i(132039);
    if (c.a(mBJ) != 0)
    {
      AppMethodBeat.o(132039);
      return true;
    }
    AppMethodBeat.o(132039);
    return false;
  }
  
  public static int aZP()
  {
    AppMethodBeat.i(132041);
    Integer localInteger2 = Integer.valueOf(MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.aQe()).getInt("default_uin", 0));
    Integer localInteger1 = localInteger2;
    if (localInteger2.intValue() == 0)
    {
      localInteger2 = Integer.valueOf(MultiProcessMMKV.getMMKV("system_config_prefs").decodeInt("default_uin", 0));
      localInteger1 = localInteger2;
      if (localInteger2.intValue() != 0)
      {
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 151L, 1L, false);
        Log.e("MMKernel.CoreAccount", "getUinFromSharedPreferences get from sp fail");
        localInteger1 = localInteger2;
      }
    }
    int i = localInteger1.intValue();
    AppMethodBeat.o(132041);
    return i;
  }
  
  public static int aZQ()
  {
    AppMethodBeat.i(235293);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("system_config_prefs");
    if (!localMultiProcessMMKV.decodeBool("has_uin_timely", false))
    {
      i = aZP();
      AppMethodBeat.o(235293);
      return i;
    }
    int i = localMultiProcessMMKV.decodeInt("default_uin_timely", 0);
    AppMethodBeat.o(235293);
    return i;
  }
  
  public static String aZR()
  {
    AppMethodBeat.i(132042);
    h.baF();
    if (Util.isNullOrNil(h.baC().mCa))
    {
      h.baF();
      h.baC().mCa = (q.aPg() + "_" + System.currentTimeMillis());
    }
    h.baF();
    String str = h.baC().mCa;
    AppMethodBeat.o(132042);
    return str;
  }
  
  public static void aZS()
  {
    AppMethodBeat.i(132043);
    h.baF();
    h.baC().mCa = "";
    h.baF();
    h.baC().mCb.clear();
    AppMethodBeat.o(132043);
  }
  
  public static b.a aZr()
  {
    AppMethodBeat.i(235251);
    Object localObject = (String)h.baE().ban().d(274436, null);
    if ((Util.isNullOrNil((String)localObject)) || ("CN".equalsIgnoreCase((String)localObject)))
    {
      localObject = b.a.mCd;
      AppMethodBeat.o(235251);
      return localObject;
    }
    localObject = b.a.mCe;
    AppMethodBeat.o(235251);
    return localObject;
  }
  
  public static String aZs()
  {
    AppMethodBeat.i(132016);
    String str = new com.tencent.mm.b.p(c.a(mBJ)).toString();
    AppMethodBeat.o(132016);
    return str;
  }
  
  public static final int aZt()
  {
    AppMethodBeat.i(235253);
    int i = c.access$100();
    AppMethodBeat.o(235253);
    return i;
  }
  
  public static String aZu()
  {
    return mBL;
  }
  
  public static boolean aZv()
  {
    return mBM;
  }
  
  public static void aZw()
  {
    mBM = true;
  }
  
  public static String aZx()
  {
    return mBK;
  }
  
  protected static void aZy()
  {
    AppMethodBeat.i(132018);
    c.a(mBJ, 0);
    AppMethodBeat.o(132018);
  }
  
  protected static void aZz()
  {
    AppMethodBeat.i(235263);
    c.sz(0);
    AppMethodBeat.o(235263);
  }
  
  public static void fA(boolean paramBoolean)
  {
    mBH = paramBoolean;
  }
  
  public static String getSalt()
  {
    AppMethodBeat.i(235252);
    h.baF();
    String str = h.baE().ban().b(at.a.adgJ, null);
    AppMethodBeat.o(235252);
    return str;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(132015);
    int i = c.a(mBJ);
    AppMethodBeat.o(132015);
    return i;
  }
  
  public static String getUserName()
  {
    AppMethodBeat.i(235247);
    h.baF();
    String str = Util.nullAsNil((String)h.baE().ban().d(2, null));
    AppMethodBeat.o(235247);
    return str;
  }
  
  static boolean sw(int paramInt)
  {
    return paramInt != 0;
  }
  
  public static void sx(int paramInt)
  {
    AppMethodBeat.i(132033);
    if ((mBW != -1) && (mBW == paramInt))
    {
      AppMethodBeat.o(132033);
      return;
    }
    mBW = paramInt;
    aQC().edit().putInt("notification.user.state", paramInt).commit();
    Log.i("MMKernel.CoreAccount", "[NOTIFICATION SETTINGS]save UserStatus: %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(132033);
  }
  
  public static boolean sy(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public final void a(bd parambd)
  {
    AppMethodBeat.i(132029);
    Log.i("MMKernel.CoreAccount", "UserStatusChange: add %s", new Object[] { parambd });
    synchronized (this.mBV)
    {
      if (!this.mBV.contains(parambd)) {
        this.mBV.add(parambd);
      }
      AppMethodBeat.o(132029);
      return;
    }
  }
  
  final void aZB()
  {
    AppMethodBeat.i(132020);
    Log.w("MMKernel.CoreAccount", "account storage release  uin:%s thread:%s stack:%s", new Object[] { com.tencent.mm.b.p.getString(c.a(mBJ)), Thread.currentThread().getName(), Util.getStack() });
    if (!aZN())
    {
      Log.i("MMKernel.CoreAccount", "Fatal crash error!!! status is not initialized when release(), this callStack is:%s, last reset stack is:%s", new Object[] { Util.getStack().toString(), mBK });
      AppMethodBeat.o(132020);
      return;
    }
    Object localObject1 = this.mBP;
    ((a)localObject1).mBB = null;
    a.a locala = ((a)localObject1).mBC;
    Log.i("MicroMsg.Mvvm.PluginLifecycleRegistry", "moveToDestroyState start");
    localObject1 = locala.observerMap;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = (List)localObject1)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (List)kotlin.a.ab.aivy;
      }
      localObject1 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (androidx.lifecycle.p)((Iterator)localObject1).next();
        Object localObject3 = localObject2.getClass().getMethods();
        kotlin.g.b.s.s(localObject3, "observer::class.java.methods");
        localObject3 = (Object[])localObject3;
        int j = localObject3.length;
        int i = 0;
        while (i < j)
        {
          Method localMethod = (Method)localObject3[i];
          z localz = (z)localMethod.getAnnotation(z.class);
          if ((localz != null) && (localz.Ho() == j.a.ON_DESTROY)) {
            localMethod.invoke(localObject2, new Object[0]);
          }
          i += 1;
        }
      }
      localObject2 = (Map)localObject1;
      localObject1 = (Collection)new ArrayList(((Map)localObject2).size());
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add((androidx.lifecycle.p)((Map.Entry)((Iterator)localObject2).next()).getValue());
      }
    }
    locala.observerMap = null;
    locala.state = j.b.bHg;
    Log.i("MicroMsg.Mvvm.PluginLifecycleRegistry", "moveToDestroyState end");
    this.mBE.onAccountRelease();
    h.baF();
    h.baE().Cg(null);
    aZA();
    h.baF();
    h.baE().mCV.clear();
    AppMethodBeat.o(132020);
  }
  
  public final void aZC()
  {
    AppMethodBeat.i(132022);
    if (!this.mBS)
    {
      Log.i("MMKernel.CoreAccount", "no need do account initialized notify.");
      AppMethodBeat.o(132022);
      return;
    }
    this.mBS = false;
    Log.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized tid:%d, stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), Util.getStack() });
    long l = System.currentTimeMillis();
    this.mBP.aZq();
    this.mBE.onAccountInitialized(this.mBO);
    Log.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized run tid[%d] take[%d]ms", new Object[] { Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l) });
    aZD();
    AppMethodBeat.o(132022);
  }
  
  public final void aZD()
  {
    AppMethodBeat.i(132023);
    if ((aZN()) && (com.tencent.mm.kernel.a.c.baR().mEf))
    {
      Log.i("MMKernel.CoreAccount", "Flush client version.");
      h.baE().baf();
    }
    AppMethodBeat.o(132023);
  }
  
  public final com.tencent.mm.am.ab aZE()
  {
    try
    {
      AppMethodBeat.i(132024);
      if (this.mBF == null) {
        this.mBF = new com.tencent.mm.am.ab();
      }
      com.tencent.mm.am.ab localab = this.mBF;
      AppMethodBeat.o(132024);
      return localab;
    }
    finally {}
  }
  
  public final void aZJ()
  {
    AppMethodBeat.i(132028);
    if (!aZN())
    {
      com.tencent.mm.model.b localb = new com.tencent.mm.model.b();
      AppMethodBeat.o(132028);
      throw localb;
    }
    AppMethodBeat.o(132028);
  }
  
  public final void aZK()
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
          arrayOfbd[i].onNotifyUserStatusChange();
          i += 1;
        }
        AppMethodBeat.o(132002);
      }
    });
    AppMethodBeat.o(132031);
  }
  
  public final boolean aZN()
  {
    return this.mBY == b.b.mCh;
  }
  
  public final void aZO()
  {
    AppMethodBeat.i(132040);
    Log.i("MMKernel.CoreAccount", "summerasyncinit setInitializedNotifyAllDone[%b] to true stack[%s]", new Object[] { Boolean.valueOf(this.mBZ), Util.getStack() });
    this.mBZ = true;
    long l = SystemClock.elapsedRealtime();
    Log.i("MMKernel.CoreAccount", "summerhardcoder setInitializedNotifyAllDone [%d %d] take[%d]ms, stack[%s]", new Object[] { Long.valueOf(this.mBX), Long.valueOf(l), Long.valueOf(l - this.mBX), Util.getStack() });
    new dc().publish();
    AppMethodBeat.o(132040);
  }
  
  public final void b(bd parambd)
  {
    AppMethodBeat.i(132030);
    Log.i("MMKernel.CoreAccount", "UserStatusChange: remove %s", new Object[] { parambd });
    synchronized (this.mBV)
    {
      this.mBV.remove(parambd);
      AppMethodBeat.o(132030);
      return;
    }
  }
  
  public final void ec(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132032);
    if ((this.mBT != paramInt1) || (this.mBU != paramInt2)) {}
    for (int i = 1;; i = 0)
    {
      Log.d("MMKernel.CoreAccount", "online status, %d, %d, %d ,%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.mBU), Integer.valueOf(this.mBT) });
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(132032);
      return;
    }
    this.mBT = paramInt1;
    this.mBU = paramInt2;
    new MMHandler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132003);
        b.this.aZK();
        AppMethodBeat.o(132003);
      }
    });
    AppMethodBeat.o(132032);
  }
  
  final void fz(boolean paramBoolean)
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
      i = h.baH().getProcessTid();
    }
    for (;;)
    {
      this.mBQ = WXHardCoderJNI.startPerformance(bool1, j, k, m, i, WXHardCoderJNI.hcBootTimeout, 101, WXHardCoderJNI.hcBootAction, "MMKernel.CoreAccount");
      Log.i("MMKernel.CoreAccount", "summerhardcoder startPerformance[%s] stack[%s]", new Object[] { Integer.valueOf(this.mBQ), Util.getStack() });
      Log.i("MMKernel.CoreAccount", "UserStatusChange: clear");
      synchronized (this.mBV)
      {
        this.mBV.clear();
        long l1 = System.currentTimeMillis();
        k = c.a(mBJ);
        Log.i("MMKernel.CoreAccount", "dkacc setAccuin %s hash:%d thread:%d[%s] stack:%s", new Object[] { com.tencent.mm.b.p.getString(k), Integer.valueOf(i.jdMethod_do(k, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), Util.getStack() });
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
    CrashReportFactory.setReportID(com.tencent.mm.b.p.getString(k));
    q.aOW();
    h.baF();
    f localf = h.baE();
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
    Object localObject3 = f.E(k, (String)???);
    Log.i("MMKernel.CoreStorage", "uinPath: %s, uinSaltPath: %s", new Object[] { ???, localObject3 });
    boolean bool3 = com.tencent.mm.compatible.util.e.aPU();
    Object localObject4;
    label464:
    long l2;
    label516:
    Object localObject5;
    if (localObject3 == null)
    {
      bool1 = false;
      Log.w("MMKernel.CoreStorage", "Cannot generate account path, skip account renaming!");
      i = 6;
      localf.mCK = ((String)???);
      localf.cachePath = (at.acHq + localf.mCK + '/');
      if (!bool1) {
        break label1352;
      }
      localObject4 = localObject3;
      localf.mCM = ((String)localObject4);
      localf.mCJ = (localf.mCI + localf.mCM + '/');
      if (localObject3 != null) {
        break label1359;
      }
      localObject4 = ???;
      localf.mCL = ((String)localObject4);
      af.aFJ(i);
      localObject4 = new u(localf.cachePath);
      Log.i("MMKernel.CoreStorage", "dkacc cachePath:" + localf.cachePath + " accPath:" + localf.mCJ);
      if (((u)localObject4).jKS()) {
        break label2992;
      }
      Log.w("MMKernel.CoreStorage", "setUin REBUILD data now ! DO NOT FUCKING TELL ME DB BROKEN !!! uin:%s data:%s sd:%s", new Object[] { com.tencent.mm.b.p.getString(k), localf.cachePath, localf.mCJ });
      ((u)localObject4).jKY();
      if (!localf.cachePath.equalsIgnoreCase(localf.mCJ))
      {
        l2 = System.currentTimeMillis();
        localObject4 = new u(localf.mCJ);
        localObject5 = (String)??? + "temp" + System.currentTimeMillis();
        localObject5 = com.tencent.mm.loader.i.b.bmz() + (String)localObject5;
        ((u)localObject4).am(new u((String)localObject5));
        Log.i("MMKernel.CoreStorage", "find the old files and rename then %s" + (System.currentTimeMillis() - l2), new Object[] { localObject5 });
      }
    }
    label1792:
    label2206:
    label2463:
    label2598:
    label2987:
    label2992:
    for (boolean bool2 = true;; bool2 = false)
    {
      localf.mCU = new cr(localf.cachePath, bool2);
      if ((bool3) && (localf.mCI.startsWith(com.tencent.mm.loader.i.b.bmt())))
      {
        bool3 = true;
        label816:
        localObject5 = k.kMs().kMv();
        k.a locala = ((k.a)localObject5).qh("account", (String)???).qh("accountSalt", localf.mCL);
        if (!bool3) {
          break label1372;
        }
        localObject4 = new String[2];
        localObject4[0] = localf.mCL;
        localObject4[1] = ???;
        label873:
        locala.r("accountSd", (String[])localObject4);
        if (localObject3 == null) {
          break label1387;
        }
      }
      label1352:
      label1359:
      label1372:
      label1387:
      for (boolean bool4 = true;; bool4 = false)
      {
        af.a((k.a)localObject5, bool3, bool4);
        af.a((k.a)localObject5, localf.mCI, bool1);
        ((k.a)localObject5).NS(false);
        Log.i("VFS.Debug", "SetEnv ${account} = ".concat(String.valueOf(???)));
        af.NU(bool1);
        localf.bag();
        ??? = localf.cachePath + "MicroMsg.db";
        localObject3 = localf.cachePath + "EnMicroMsg.db";
        localObject4 = localf.cachePath + "EnMicroMsg2.db";
        localf.Cg(null);
        localf.Fy((String)localObject3);
        localf.mCN = new com.tencent.mm.storagebase.h(new f.2(localf));
        localObject5 = localf.mCN;
        l2 = k;
        q.eD(true);
        if (((com.tencent.mm.storagebase.h)localObject5).b((String)???, (String)localObject3, (String)localObject4, l2, f.getBaseDBFactories(), true)) {
          break label1393;
        }
        ??? = new SQLiteException("main db init failed");
        AppMethodBeat.o(132021);
        throw ((Throwable)???);
        if ((!localf.mCI.startsWith(com.tencent.mm.loader.i.b.bmt())) || (!bool3))
        {
          bool1 = false;
          Log.w("MMKernel.CoreStorage", "SDCard not available, skip account renaming!");
          i = 1;
          break;
        }
        localObject4 = new u(localf.mCI + (String)???);
        localObject5 = new u(localf.mCI + (String)localObject3);
        if (((u)localObject4).isDirectory())
        {
          if (((u)localObject5).isDirectory())
          {
            bool1 = true;
            Log.i("MMKernel.CoreStorage", "Both uinPath exists, migration shall be taken.");
            i = 2;
            break;
          }
          ((u)localObject5).diJ();
          Log.i("MMKernel.CoreStorage", "Move account directory: %s => %s", new Object[] { localObject4, localObject5 });
          if (!((u)localObject4).am((u)localObject5))
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
        if (!((u)localObject5).isDirectory()) {
          ((u)localObject5).diJ();
        }
        ((u)localObject5).jKY();
        bool1 = true;
        i = 5;
        break;
        localObject4 = ???;
        break label464;
        localObject4 = localObject3;
        break label516;
        bool3 = false;
        break label816;
        localObject4 = new String[1];
        localObject4[0] = ???;
        break label873;
      }
      label1393:
      localObject5 = localf.mCN.adnJ;
      if (!Util.isNullOrNil((String)localObject5))
      {
        Log.e("MMKernel.CoreStorage", "dbinit failed :".concat(String.valueOf(localObject5)));
        CrashReportFactory.reportRawMessage("init db Failed: [ " + (String)localObject5 + "]", "DBinit");
      }
      localObject5 = localf.mCN;
      if (((com.tencent.mm.storagebase.h)localObject5).adnG != null) {}
      for (bool1 = ((com.tencent.mm.storagebase.h)localObject5).adnG.adnc;; bool1 = false)
      {
        if (bool1) {
          localf.mCT = true;
        }
        localf.mCP = new aq(localf.mCN);
        localf.mCR = new cu(localf.mCN);
        localf.mCN.adnI = new f.3(localf);
        localf.mCS = localf.mCR.jcS();
        localf.mCO = new com.tencent.mm.storagebase.h(localf.mCH);
        localObject5 = localf.mCO;
        l2 = k;
        q.eD(true);
        if (((com.tencent.mm.storagebase.h)localObject5).b((String)???, (String)localObject3, (String)localObject4, l2, new HashMap(), true)) {
          break;
        }
        ??? = new com.tencent.mm.model.b((byte)0);
        AppMethodBeat.o(132021);
        throw ((Throwable)???);
      }
      localf.mCQ = new co(localf.mCP);
      localf.mCQ.add(new f.4(localf));
      localf.mCQ.jcK();
      local1.run();
      if (bool2)
      {
        l2 = ((Long)localf.mCP.get(at.a.acOS, Long.valueOf(0L))).longValue();
        i = ((Integer)localf.mCP.get(at.a.acOT, Integer.valueOf(0))).intValue();
        if (l2 > 0L)
        {
          Log.w("MMKernel.CoreStorage", "summerinstall new install but firsttime[%d] > 0", new Object[] { Long.valueOf(l2) });
          label1768:
          if (i <= 0) {
            break label2017;
          }
          Log.w("MMKernel.CoreStorage", "summerinstall new install but version[%d] > 0", new Object[] { Integer.valueOf(i) });
          Log.i("MMKernel.CoreStorage", "edw setAccUin, summerinstall time[%d]，version[%d], clientversion[%d]", new Object[] { (Long)localf.mCP.get(at.a.acOS, Long.valueOf(0L)), (Integer)localf.mCP.get(at.a.acOT, Integer.valueOf(0)), Integer.valueOf(d.Yxh) });
        }
      }
      else
      {
        if (paramBoolean) {
          break label2042;
        }
        h.baF();
        ??? = Util.nullAsNil((String)h.baE().ban().d(2, null));
        Log.i("MMKernel.CoreAccount", "summerinit validateUsername username[%s]", new Object[] { ??? });
        if (((String)???).length() > 0) {
          break label2037;
        }
        Log.e("MMKernel.CoreAccount", "username of acc stg not set: uin=" + c.a(mBJ));
        aZA();
        c.a(mBJ, 0);
        mBK = Util.getStack().toString();
        MMHandlerThread.postToMainThread(new b.4(this));
      }
      label2017:
      label2037:
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label2042;
        }
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(598L, 21L, 1L, true);
        Log.w("MMKernel.CoreAccount", "setAccUin, validateUsername false no need initialize!");
        break;
        localf.mCP.set(at.a.acOS, Long.valueOf(System.currentTimeMillis()));
        break label1768;
        localf.mCP.set(at.a.acOT, Integer.valueOf(d.Yxh));
        break label1792;
      }
      label2042:
      new dd().publish();
      h.baF();
      ??? = h.baE();
      localObject3 = new f.c();
      j = Util.nullAsNil((Integer)((f)???).mCP.d(14, null));
      m = d.Yxh;
      Log.d("MMKernel.CoreStorage", "sVer: %s, cVer: %s.", new Object[] { Integer.toHexString(j), Integer.toHexString(m) });
      if (m == j) {
        paramBoolean = false;
      }
      for (;;)
      {
        label2130:
        if (paramBoolean)
        {
          ((f)???).mCP.B(8197, "");
          ((f)???).mCP.B(15, Integer.valueOf(0));
        }
        if (j != m)
        {
          bool1 = true;
          label2170:
          if ((j > 620822536) || (j == m)) {
            break label2872;
          }
          ((f)???).mCP.B(274480, Boolean.TRUE);
          Log.i("MMKernel.CoreStorage", "[initialize] need init emoji");
          if ((j != 0) && (j < 637599744)) {
            ((f)???).mCP.B(348162, Boolean.TRUE);
          }
          if (j == m) {
            break label2898;
          }
          i = 1;
          label2239:
          if (i == 0) {
            break label2936;
          }
          Log.w("MMKernel.CoreStorage", "account storage version changed from " + Integer.toHexString(j) + " to " + Integer.toHexString(m) + ", init=" + paramBoolean);
          if (((Integer)((f)???).mCE.d(37, Integer.valueOf(0))).intValue() == 0) {
            ((f)???).mCE.B(37, Integer.valueOf(j));
          }
          ((f)???).mCP.B(30, Boolean.FALSE);
          ((f)???).mCP.B(-2046825377, Boolean.FALSE);
          ((f)???).mCP.B(-2046825369, Boolean.FALSE);
          ((f)???).mCP.B(54, Boolean.FALSE);
          ((f)???).mCP.B(-2046825368, Boolean.FALSE);
          ((f)???).mCP.B(-2046825366, Boolean.TRUE);
          ((f)???).mCP.B(62, Boolean.TRUE);
          MMApplicationContext.getContext().getSharedPreferences("update_config_prefs", com.tencent.mm.compatible.util.g.aQe()).edit().clear().commit();
          if (j != 0) {
            break label2903;
          }
          ((f)???).mCW = true;
          if (((f)???).mCP.getInt(at.a.adcA, -1) <= 0) {
            break label2955;
          }
          paramBoolean = true;
          label2480:
          Log.i("MMKernel.CoreStorage", "unlock show_whatsnew from testWhatsNew, %s.", new Object[] { Boolean.valueOf(paramBoolean) });
          ((f.c)localObject3).mDg = bool1;
          ((f.c)localObject3).mDh = j;
          this.mBO = ((f.c)localObject3);
          Log.i("MMKernel.CoreAccount", "check is update :%b ", new Object[] { Boolean.valueOf(((f.c)localObject3).mDg) });
          this.mBS = true;
          if (!this.mBR)
          {
            aZC();
            h.baC().aZO();
          }
          bg.okT.bc("last_login_uin", com.tencent.mm.b.p.getString(k));
          com.tencent.mm.plugin.report.f.Ozc.setUin(k);
          if (getClass().getClassLoader() != null) {
            break label2960;
          }
          i = -1;
          if (Thread.currentThread().getContextClassLoader() != null) {
            break label2974;
          }
        }
        for (j = -1;; j = Thread.currentThread().getContextClassLoader().hashCode())
        {
          Log.i("MMKernel.CoreAccount", "SmcLogic.setUin, class loader %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          this.mBN = new com.tencent.mm.model.a();
          Log.i("MMKernel.CoreAccount", "setAccUin done :%s", new Object[] { com.tencent.mm.b.p.getString(k) });
          new hu().publish();
          h.baF();
          if (h.baD().mCm == null) {
            break;
          }
          h.baF();
          if (h.baD().mCm.oun == null) {
            break;
          }
          h.baF();
          h.baD().mCm.oun.hb(true);
          h.baF();
          ??? = h.baD().mCm.oun.bGg();
          if ((k == 0) || (??? == null) || (k == ((com.tencent.mm.network.e)???).getUin())) {
            break;
          }
          Log.w("MMKernel.CoreAccount", "summerauth update acc info with acc stg: old acc uin=%d, this uin=%d", new Object[] { Integer.valueOf(((com.tencent.mm.network.e)???).getUin()), Integer.valueOf(k) });
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 46L, 1L, false);
          ((com.tencent.mm.network.e)???).setUin(k);
          break;
          if ((m > 570425344) && (j <= 570425344))
          {
            paramBoolean = true;
            break label2130;
          }
          if ((m <= 570556456) || (j > 570556456)) {
            break label2987;
          }
          paramBoolean = true;
          break label2130;
          bool1 = false;
          break label2170;
          label2872:
          ((f)???).mCP.B(274480, Boolean.FALSE);
          Log.i("MMKernel.CoreStorage", "[initialize] need not init emoji");
          break label2206;
          label2898:
          i = 0;
          break label2239;
          label2903:
          if ((0xFF000000 & j) != (0xFF000000 & m)) {
            break label2463;
          }
          Log.d("MMKernel.CoreStorage", "lock show_whatsnew by same major version");
          MMEntryLock.lock("show_whatsnew");
          break label2463;
          label2936:
          Log.d("MMKernel.CoreStorage", "lock show_whatsnew from else.");
          MMEntryLock.lock("show_whatsnew");
          break label2463;
          paramBoolean = false;
          break label2480;
          i = getClass().getClassLoader().hashCode();
          break label2598;
        }
        paramBoolean = false;
      }
    }
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(132038);
    if (aZN())
    {
      AppMethodBeat.o(132038);
      return;
    }
    synchronized (this.mBI)
    {
      if (aZN())
      {
        AppMethodBeat.o(132038);
        return;
      }
      int i = c.a(mBJ);
      if (i != 0)
      {
        this.mBX = SystemClock.elapsedRealtime();
        Log.w("MMKernel.CoreAccount", "auto set up account storage uin: %d, stack: %s", new Object[] { Integer.valueOf(i), Util.getStack() });
        fz(false);
      }
      AppMethodBeat.o(132038);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(132037);
    synchronized (this.mBI)
    {
      aZB();
      AppMethodBeat.o(132037);
      return;
    }
  }
  
  static final class c
  {
    private static boolean mCk = true;
    private ap mCj;
    private boolean mLoaded = false;
    private int uin = 0;
    
    private static void a(ap paramap, int paramInt)
    {
      AppMethodBeat.i(132011);
      Log.i("MMKernel.CoreAccount", "setSysUin uin: %d, stack: %s", new Object[] { Integer.valueOf(paramInt), Util.getStack() });
      if (!MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.aQe()).edit().putInt("default_uin", paramInt).commit())
      {
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 150L, 1L, false);
        Log.e("MMKernel.CoreAccount", "uin_sp save fail");
      }
      MultiProcessMMKV.getMMKV("system_config_prefs").encode("default_uin", paramInt);
      paramap.B(1, Integer.valueOf(paramInt));
      paramap.iZx();
      sz(paramInt);
      AppMethodBeat.o(132011);
    }
    
    /* Error */
    private void aZT()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc 151
      //   6: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: getfield 153	com/tencent/mm/kernel/b$c:mCj	Lcom/tencent/mm/storage/ap;
      //   13: invokestatic 159	junit/framework/Assert:assertNotNull	(Ljava/lang/Object;)V
      //   16: aload_0
      //   17: getfield 153	com/tencent/mm/kernel/b$c:mCj	Lcom/tencent/mm/storage/ap;
      //   20: astore 5
      //   22: aload 5
      //   24: ifnonnull +23 -> 47
      //   27: ldc 51
      //   29: ldc 161
      //   31: invokestatic 164	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   34: aload_0
      //   35: iload_1
      //   36: putfield 24	com/tencent/mm/kernel/b$c:uin	I
      //   39: ldc 151
      //   41: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   44: aload_0
      //   45: monitorexit
      //   46: return
      //   47: aload 5
      //   49: iconst_1
      //   50: invokevirtual 168	com/tencent/mm/storage/ap:get	(I)Ljava/lang/Object;
      //   53: checkcast 55	java/lang/Integer
      //   56: astore_3
      //   57: aload_3
      //   58: astore_2
      //   59: aload_3
      //   60: ifnonnull +140 -> 200
      //   63: aload 5
      //   65: getfield 171	com/tencent/mm/storage/ap:acGU	Z
      //   68: ifeq +17 -> 85
      //   71: getstatic 113	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
      //   74: ldc2_w 114
      //   77: ldc2_w 172
      //   80: lconst_1
      //   81: iconst_0
      //   82: invokevirtual 121	com/tencent/mm/plugin/report/f:idkeyStat	(JJJZ)V
      //   85: invokestatic 176	com/tencent/mm/kernel/b$c:aZU	()I
      //   88: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   91: astore 4
      //   93: aload_3
      //   94: astore_2
      //   95: aload 4
      //   97: ifnull +103 -> 200
      //   100: ldc 51
      //   102: ldc 178
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
      //   121: getfield 171	com/tencent/mm/storage/ap:acGU	Z
      //   124: invokestatic 183	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   127: aastore
      //   128: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   131: getstatic 18	com/tencent/mm/kernel/b$c:mCk	Z
      //   134: ifeq +53 -> 187
      //   137: ldc 51
      //   139: ldc 185
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
      //   156: invokestatic 187	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   159: getstatic 113	com/tencent/mm/plugin/report/f:Ozc	Lcom/tencent/mm/plugin/report/f;
      //   162: sipush 11911
      //   165: iconst_1
      //   166: anewarray 4	java/lang/Object
      //   169: dup
      //   170: iconst_0
      //   171: aload 4
      //   173: invokestatic 191	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/Integer;)I
      //   176: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   179: aastore
      //   180: invokevirtual 195	com/tencent/mm/plugin/report/f:b	(I[Ljava/lang/Object;)V
      //   183: iconst_0
      //   184: putstatic 18	com/tencent/mm/kernel/b$c:mCk	Z
      //   187: aload 5
      //   189: aload 4
      //   191: invokevirtual 198	java/lang/Integer:intValue	()I
      //   194: invokestatic 200	com/tencent/mm/kernel/b$c:a	(Lcom/tencent/mm/storage/ap;I)V
      //   197: aload 4
      //   199: astore_2
      //   200: ldc 51
      //   202: ldc 202
      //   204: iconst_1
      //   205: anewarray 4	java/lang/Object
      //   208: dup
      //   209: iconst_0
      //   210: aload_2
      //   211: invokestatic 191	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/Integer;)I
      //   214: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   217: aastore
      //   218: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   221: aload_2
      //   222: invokestatic 191	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/Integer;)I
      //   225: istore_1
      //   226: goto -192 -> 34
      //   229: astore_2
      //   230: aload_0
      //   231: monitorexit
      //   232: aload_2
      //   233: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	234	0	this	c
      //   1	225	1	i	int
      //   58	164	2	localObject1	Object
      //   229	4	2	localObject2	Object
      //   56	55	3	localInteger1	Integer
      //   91	107	4	localInteger2	Integer
      //   20	168	5	localap	ap
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
    
    private static int aZU()
    {
      AppMethodBeat.i(235226);
      int i = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.aQe()).getInt("default_uin", 0);
      AppMethodBeat.o(235226);
      return i;
    }
    
    private int getUin()
    {
      try
      {
        AppMethodBeat.i(132008);
        if (!this.mLoaded)
        {
          aZT();
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
        Log.i("MMKernel.CoreAccount", "Uin From %s To %s hash:%d thread:%d[%s] stack:%s", new Object[] { com.tencent.mm.b.p.getString(this.uin), com.tencent.mm.b.p.getString(paramInt), Integer.valueOf(i.jdMethod_do(paramInt, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), Util.getStack() });
        Assert.assertNotNull(this.mCj);
        a(this.mCj, paramInt);
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
    
    public static void sz(int paramInt)
    {
      AppMethodBeat.i(235231);
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("system_config_prefs");
      localMultiProcessMMKV.encode("default_uin_timely", paramInt);
      localMultiProcessMMKV.encode("has_uin_timely", true);
      AppMethodBeat.o(235231);
    }
    
    public final void a(ap paramap)
    {
      try
      {
        this.mCj = paramap;
        return;
      }
      finally
      {
        paramap = finally;
        throw paramap;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.kernel.b
 * JD-Core Version:    0.7.0.1
 */