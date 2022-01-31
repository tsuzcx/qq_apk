package com.tencent.mm.kernel;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import com.tencent.mm.a.o;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.h.a.ca;
import com.tencent.mm.h.a.cb;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.at;
import com.tencent.mm.model.av;
import com.tencent.mm.model.cd;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.z;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.mm.vfs.FileSystemManager.MaintenanceBroadcastReceiver;
import com.tencent.mm.vfs.FileSystemManager.a;
import java.io.File;
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
  private static int dJE = -1;
  private static boolean dJq = true;
  private static boolean dJr = false;
  static b dJt = new b();
  private static String dJu = "NoResetUinStack";
  private static String dJv = null;
  private boolean dJA = false;
  public int dJB = 0;
  public int dJC;
  public List<aq> dJD = new LinkedList();
  long dJF;
  private volatile a dJG = a.dJL;
  public volatile boolean dJH = false;
  private String dJI = "";
  private Map<String, Integer> dJJ = new HashMap();
  private com.tencent.mm.kernel.api.c dJo;
  private com.tencent.mm.ah.y dJp;
  byte[] dJs = new byte[0];
  public com.tencent.mm.model.a dJw;
  public e.c dJx;
  public int dJy;
  public boolean dJz = false;
  
  public a(com.tencent.mm.kernel.api.c paramc)
  {
    Assert.assertNotNull(dJt);
    g.DQ();
    if (bk.g((Integer)g.DP().dKo.get(17)) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      dJq = bool;
      com.tencent.mm.protocal.i.c.a.spv = new av(702);
      this.dJo = paramc;
      return;
    }
  }
  
  public static int CK()
  {
    return b.a(dJt);
  }
  
  public static String CL()
  {
    return new o(b.a(dJt)).toString();
  }
  
  public static String CM()
  {
    return dJv;
  }
  
  public static String CN()
  {
    return dJu;
  }
  
  protected static void CO()
  {
    b.a(dJt, 0);
  }
  
  protected static void CP()
  {
    b.a(dJt, 0);
  }
  
  private void CQ()
  {
    this.dJG = a.dJL;
    this.dJH = false;
    com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreAccount", "mAccountStatus to NotReady");
    ae.getContext().getSharedPreferences(ae.cqR(), 0).edit().putBoolean("isLogin", false).commit();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
    com.tencent.mm.sdk.platformtools.y.w("MMKernel.CoreAccount", "[arthurdan.AccountNR] account storage reset! uin:%d, resetStack is:%s, resetTime:%s", new Object[] { Integer.valueOf(b.a(dJt)), dJu, localSimpleDateFormat.format(new Date()) });
  }
  
  public static boolean CV()
  {
    return dJr;
  }
  
  public static boolean CW()
  {
    if (dJq)
    {
      g.DQ();
      if (g.DN() == null) {
        break label66;
      }
      g.DQ();
      g.DN();
    }
    label66:
    for (String str = o.getString(b.a(dJt));; str = "-1")
    {
      com.tencent.mm.sdk.platformtools.y.w("MMKernel.CoreAccount", "account holded :%s init:%b", new Object[] { str, Boolean.valueOf(g.DN().Dc()) });
      return dJq;
    }
  }
  
  public static int CZ()
  {
    return Da().getInt("notification.user.state", 0);
  }
  
  public static SharedPreferences Da()
  {
    return ae.getContext().getSharedPreferences("notify_key_pref_settings", 4);
  }
  
  public static boolean Db()
  {
    return b.a(dJt) != 0;
  }
  
  public static int De()
  {
    return Integer.valueOf(ae.getContext().getSharedPreferences("system_config_prefs", 4).getInt("default_uin", 0)).intValue();
  }
  
  public static String Df()
  {
    g.DQ();
    if (bk.bl(g.DN().dJI)) {
      Dg();
    }
    g.DQ();
    return g.DN().dJI;
  }
  
  public static void Dg()
  {
    g.DQ();
    g.DN().dJI = (q.zg() + "_" + System.currentTimeMillis());
    g.DQ();
    g.DN().dJJ.clear();
  }
  
  public static void bF(boolean paramBoolean)
  {
    dJr = paramBoolean;
  }
  
  public static String gb(String paramString)
  {
    dJv = paramString;
    return paramString;
  }
  
  public static void gc(String paramString)
  {
    dJu = paramString;
  }
  
  public static int gd(String paramString)
  {
    g.DQ();
    int i;
    int k;
    if (g.DN().dJJ.get(paramString) == null)
    {
      i = 0;
      k = (int)bk.UX();
      if (i != 0) {
        break label79;
      }
      g.DQ();
      g.DN().dJJ.put(paramString, Integer.valueOf(k));
    }
    label79:
    int j;
    do
    {
      return i;
      g.DQ();
      i = ((Integer)g.DN().dJJ.get(paramString)).intValue();
      break;
      j = k - i;
      g.DQ();
      g.DN().dJJ.put(paramString, Integer.valueOf(k));
      i = j;
    } while (j >= 0);
    return 0;
  }
  
  public static void hold()
  {
    g.DQ();
    if (g.DN() != null)
    {
      g.DQ();
      g.DN();
    }
    for (String str = o.getString(b.a(dJt));; str = "-1")
    {
      com.tencent.mm.sdk.platformtools.y.w("MMKernel.CoreAccount", " HOLD ACCOUNT! uin:%s stack:%s init:%b", new Object[] { str, bk.csb(), Boolean.valueOf(g.DN().Dc()) });
      dJq = true;
      g.DQ();
      g.DP().dKo.set(17, Integer.valueOf(1));
      return;
    }
  }
  
  static boolean hu(int paramInt)
  {
    return paramInt != 0;
  }
  
  public static void hv(int paramInt)
  {
    if ((dJE != -1) && (dJE == paramInt)) {
      return;
    }
    dJE = paramInt;
    Da().edit().putInt("notification.user.state", paramInt).commit();
    com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreAccount", "[NOTIFICATION SETTINGS]save UserStatus: %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static boolean hw(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static void unhold()
  {
    g.DQ();
    if (g.DN() != null)
    {
      g.DQ();
      g.DN();
    }
    for (String str = o.getString(b.a(dJt));; str = "-1")
    {
      com.tencent.mm.sdk.platformtools.y.w("MMKernel.CoreAccount", " UN HOLD ACCOUNT! uin:%s init:%b", new Object[] { str, Boolean.valueOf(g.DN().Dc()) });
      dJq = false;
      g.DQ();
      g.DP().dKo.set(17, Integer.valueOf(0));
      return;
    }
  }
  
  final void CR()
  {
    com.tencent.mm.sdk.platformtools.y.w("MMKernel.CoreAccount", "account storage release  uin:%s thread:%s stack:%s", new Object[] { o.getString(b.a(dJt)), Thread.currentThread().getName(), bk.csb() });
    if (!Dc())
    {
      com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreAccount", "Fatal crash error!!! status is not initialized when release(), this callStack is:%s, last reset stack is:%s", new Object[] { bk.csb().toString(), dJu });
      return;
    }
    this.dJo.onAccountRelease();
    g.DQ();
    g.DP().ek(null);
    CQ();
    g.DQ();
    g.DP().dKC.clear();
  }
  
  public final void CS()
  {
    if (!this.dJA)
    {
      com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreAccount", "no need do account initialized notify.");
      return;
    }
    this.dJA = false;
    com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized tid:%d, stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), bk.csb() });
    long l = System.currentTimeMillis();
    this.dJo.onAccountInitialized(this.dJx);
    com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized run tid[%d] take[%d]ms", new Object[] { Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l) });
    CT();
  }
  
  public final void CT()
  {
    if ((Dc()) && (com.tencent.mm.kernel.a.c.DY().dLG))
    {
      com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreAccount", "Flush client version.");
      g.DP().dKw.o(14, Integer.valueOf(d.spa));
    }
  }
  
  public final com.tencent.mm.ah.y CU()
  {
    try
    {
      if (this.dJp == null) {
        this.dJp = new com.tencent.mm.ah.y();
      }
      com.tencent.mm.ah.y localy = this.dJp;
      return localy;
    }
    finally {}
  }
  
  public final void CX()
  {
    if (!Dc()) {
      throw new com.tencent.mm.model.b();
    }
  }
  
  public final void CY()
  {
    new ah(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        aq[] arrayOfaq = new aq[a.b(a.this).size()];
        a.b(a.this).toArray(arrayOfaq);
        int j = arrayOfaq.length;
        int i = 0;
        while (i < j)
        {
          arrayOfaq[i].Hn();
          i += 1;
        }
      }
    });
  }
  
  public final boolean Dc()
  {
    return this.dJG == a.dJM;
  }
  
  public final void Dd()
  {
    com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreAccount", "summerasyncinit setInitializedNotifyAllDone[%b] to true stack[%s]", new Object[] { Boolean.valueOf(this.dJH), bk.csb() });
    this.dJH = true;
    long l = SystemClock.elapsedRealtime();
    com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreAccount", "summerhardcoder setInitializedNotifyAllDone [%d %d] take[%d]ms, stack[%s]", new Object[] { Long.valueOf(this.dJF), Long.valueOf(l), Long.valueOf(l - this.dJF), bk.csb() });
    ca localca = new ca();
    com.tencent.mm.sdk.b.a.udP.m(localca);
  }
  
  final void bE(boolean paramBoolean)
  {
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
        i = g.DS().crd();
        this.dJy = WXHardCoderJNI.startPerformance(bool1, j, k, m, i, WXHardCoderJNI.hcBootTimeout, 101, WXHardCoderJNI.hcBootAction, "MMKernel.CoreAccount");
        com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreAccount", "summerhardcoder startPerformance[%s] stack[%s]", new Object[] { Integer.valueOf(this.dJy), bk.csb() });
      }
    }
    else
    {
      com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreAccount", "UserStatusChange: clear");
    }
    for (;;)
    {
      synchronized (this.dJD)
      {
        this.dJD.clear();
        long l1 = System.currentTimeMillis();
        k = b.a(dJt);
        com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreAccount", "dkacc setAccuin %s hash:%d thread:%d[%s] stack:%s", new Object[] { o.getString(k), Integer.valueOf(com.tencent.mm.a.h.aT(k, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), bk.csb() });
        if (k != 0)
        {
          i = 1;
          if (i != 0) {
            break;
          }
          com.tencent.mm.sdk.platformtools.y.w("MMKernel.CoreAccount", "setAccUin, Reset by MMCore.resetAccUin");
          com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreAccount", "start time check setUinImpl end total time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
          com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreAccount", "mAccountStatus to AccountHasReady");
          return;
          i = 0;
        }
      }
      i = 0;
    }
    o.getString(k);
    g.DQ();
    ??? = g.DP();
    Object localObject3 = new Runnable()
    {
      public final void run()
      {
        a.a(a.this);
      }
    };
    ae.getContext().getSharedPreferences(ae.cqR(), 0).edit().putBoolean("isLogin", true).apply();
    String str = com.tencent.mm.a.g.o(("mm" + k).getBytes());
    ((e)???).dKt = (((e)???).dKs + str + "/");
    ((e)???).cachePath = (ac.dOP + str + "/");
    Object localObject4 = new File(((e)???).cachePath);
    com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "dkacc cachePath:" + ((e)???).cachePath + " accPath:" + ((e)???).dKt);
    long l2;
    Object localObject5;
    if (!((File)localObject4).exists())
    {
      com.tencent.mm.sdk.platformtools.y.w("MMKernel.CoreStorage", "setUin REBUILD data now ! DO NOT FUCKING TELL ME DB BROKEN !!! uin:%s data:%s sd:%s", new Object[] { o.getString(k), ((e)???).cachePath, ((e)???).dKt });
      ((File)localObject4).mkdirs();
      if (!((e)???).cachePath.equalsIgnoreCase(((e)???).dKt))
      {
        l2 = System.currentTimeMillis();
        localObject4 = new File(((e)???).dKt);
        localObject5 = str + "temp" + System.currentTimeMillis();
        localObject5 = com.tencent.mm.compatible.util.e.bkH + (String)localObject5;
        ((File)localObject4).renameTo(new File((String)localObject5));
        com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "find the old files and rename then %s" + (System.currentTimeMillis() - l2), new Object[] { localObject5 });
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      ((e)???).dKB = new cd(((e)???).cachePath, bool1);
      localObject4 = FileSystemManager.cVw();
      ((FileSystemManager)localObject4).cVy().gB("account", str).oc(false);
      ((FileSystemManager)localObject4).cVz();
      localObject5 = FileSystemManager.sContext;
      l2 = ((FileSystemManager)localObject4).xwb;
      if ((420000L >= 0L) && (l2 < 0L))
      {
        localObject6 = new IntentFilter();
        ((IntentFilter)localObject6).addAction("android.intent.action.SCREEN_ON");
        ((IntentFilter)localObject6).addAction("android.intent.action.SCREEN_OFF");
        ((IntentFilter)localObject6).addAction("android.intent.action.ACTION_POWER_CONNECTED");
        ((IntentFilter)localObject6).addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        ((Context)localObject5).registerReceiver(((FileSystemManager)localObject4).xvZ, (IntentFilter)localObject6);
        localObject6 = ((FileSystemManager)localObject4).xvZ;
        ((FileSystemManager.MaintenanceBroadcastReceiver)localObject6).ijn = ((PowerManager)((Context)localObject5).getSystemService("power")).isScreenOn();
        localObject5 = ((Context)localObject5).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (localObject5 != null)
        {
          i = ((Intent)localObject5).getIntExtra("status", -1);
          if ((i != 2) && (i != 5)) {
            break label1067;
          }
          bool2 = true;
          ((FileSystemManager.MaintenanceBroadcastReceiver)localObject6).ijm = bool2;
        }
      }
      for (;;)
      {
        ((FileSystemManager)localObject4).xwb = 420000L;
        ((FileSystemManager)localObject4).xwc = 259200000L;
        ((FileSystemManager)localObject4).xwd = true;
        com.tencent.mm.sdk.platformtools.y.i("VFS.Debug", "SetEnv ${account} = " + str + " and broadcast.");
        ((e)???).Dt();
        str = ((e)???).cachePath + "MicroMsg.db";
        localObject4 = ((e)???).cachePath + "EnMicroMsg.db";
        localObject5 = ((e)???).cachePath + "EnMicroMsg2.db";
        ((e)???).ek(null);
        ((e)???).gg((String)localObject4);
        ((e)???).dKu = new com.tencent.mm.cf.h(new e.2((e)???));
        if (((e)???).dKu.a(str, (String)localObject4, (String)localObject5, k, q.zf(), e.xe(), true)) {
          break label1101;
        }
        throw new SQLiteException("main db init failed");
        label1067:
        bool2 = false;
        break;
        if ((420000L < 0L) && (l2 >= 0L)) {
          ((Context)localObject5).unregisterReceiver(((FileSystemManager)localObject4).xvZ);
        }
      }
      label1101:
      Object localObject6 = ((e)???).dKu.uEk;
      if (!bk.bl((String)localObject6))
      {
        com.tencent.mm.sdk.platformtools.y.e("MMKernel.CoreStorage", "dbinit failed :" + (String)localObject6);
        com.tencent.mm.sdk.a.b.t("init db Failed: [ " + (String)localObject6 + "]", "DBinit");
      }
      localObject6 = ((e)???).dKu;
      if (((com.tencent.mm.cf.h)localObject6).uEh != null) {}
      for (boolean bool2 = ((com.tencent.mm.cf.h)localObject6).uEh.uDG;; bool2 = false)
      {
        if (bool2) {
          ((e)???).dKA = true;
        }
        ((e)???).dKw = new z(((e)???).dKu);
        ((e)???).dKy = new by(((e)???).dKu);
        ((e)???).dKu.uEj = new e.3((e)???);
        ((e)???).dKz = ((e)???).dKy.cwe();
        ((e)???).dKv = new com.tencent.mm.cf.h(((e)???).dKr);
        if (((e)???).dKv.a(str, (String)localObject4, (String)localObject5, k, q.zf(), new HashMap(), true)) {
          break;
        }
        throw new com.tencent.mm.model.b((byte)0);
      }
      ((e)???).dKx = new bs(((e)???).dKw);
      ((e)???).dKx.c(new e.4((e)???));
      ((e)???).dKx.cvZ();
      ((Runnable)localObject3).run();
      if (bool1)
      {
        l2 = ((Long)((e)???).dKw.get(ac.a.uuh, Long.valueOf(0L))).longValue();
        i = ((Integer)((e)???).dKw.get(ac.a.uui, Integer.valueOf(0))).intValue();
        if (l2 > 0L)
        {
          com.tencent.mm.sdk.platformtools.y.w("MMKernel.CoreStorage", "summerinstall new install but firsttime[%d] > 0", new Object[] { Long.valueOf(l2) });
          label1463:
          if (i <= 0) {
            break label1712;
          }
          com.tencent.mm.sdk.platformtools.y.w("MMKernel.CoreStorage", "summerinstall new install but version[%d] > 0", new Object[] { Integer.valueOf(i) });
          label1487:
          com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "edw setAccUin, summerinstall time[%d]，version[%d], clientversion[%d]", new Object[] { (Long)((e)???).dKw.get(ac.a.uuh, Long.valueOf(0L)), (Integer)((e)???).dKw.get(ac.a.uui, Integer.valueOf(0)), Integer.valueOf(d.spa) });
        }
      }
      else
      {
        if (paramBoolean) {
          break label1737;
        }
        g.DQ();
        ??? = bk.pm((String)g.DP().Dz().get(2, null));
        com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreAccount", "summerinit validateUsername username[%s]", new Object[] { ??? });
        if (((String)???).length() > 0) {
          break label1732;
        }
        com.tencent.mm.sdk.platformtools.y.e("MMKernel.CoreAccount", "username of acc stg not set: uin=" + b.a(dJt));
        CQ();
        b.a(dJt, 0);
        dJu = bk.csb().toString();
        ai.d(new Runnable()
        {
          public final void run()
          {
            g.DQ().releaseAll();
          }
        });
      }
      label1712:
      label1732:
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label1737;
        }
        f.nEG.a(598L, 21L, 1L, true);
        com.tencent.mm.sdk.platformtools.y.w("MMKernel.CoreAccount", "setAccUin, validateUsername false no need initialize!");
        break;
        ((e)???).dKw.c(ac.a.uuh, Long.valueOf(System.currentTimeMillis()));
        break label1463;
        ((e)???).dKw.c(ac.a.uui, Integer.valueOf(d.spa));
        break label1487;
      }
      label1737:
      ??? = new cb();
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)???);
      g.DQ();
      ??? = g.DP();
      localObject3 = new e.c();
      j = bk.g((Integer)((e)???).dKw.get(14, null));
      m = d.spa;
      if (m == j) {
        paramBoolean = false;
      }
      for (;;)
      {
        label1804:
        if (paramBoolean)
        {
          ((e)???).dKw.o(8197, "");
          ((e)???).dKw.o(15, Integer.valueOf(0));
        }
        if (j != m)
        {
          bool1 = true;
          label1844:
          if ((j > 620822536) || (j == m)) {
            break label2516;
          }
          ((e)???).dKw.o(274480, Boolean.valueOf(true));
          com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "[initialize] need init emoji");
          label1881:
          if ((j != 0) && (j < 637599744)) {
            ((e)???).dKw.o(348162, Boolean.valueOf(true));
          }
          if (j == m) {
            break label2543;
          }
          i = 1;
          label1915:
          if (i != 0)
          {
            com.tencent.mm.sdk.platformtools.y.w("MMKernel.CoreStorage", "account storage version changed from " + Integer.toHexString(j) + " to " + Integer.toHexString(m) + ", init=" + paramBoolean);
            if (((Integer)((e)???).dKo.get(37, Integer.valueOf(0))).intValue() == 0) {
              ((e)???).dKo.set(37, Integer.valueOf(j));
            }
            ((e)???).dKw.o(30, Boolean.valueOf(false));
            ((e)???).dKw.o(-2046825377, Boolean.valueOf(false));
            ((e)???).dKw.o(-2046825369, Boolean.valueOf(false));
            ((e)???).dKw.o(54, Boolean.valueOf(false));
            ((e)???).dKw.o(-2046825368, Boolean.valueOf(false));
            ((e)???).dKw.o(-2046825366, Boolean.valueOf(true));
            ((e)???).dKw.o(62, Boolean.valueOf(true));
            ae.getContext().getSharedPreferences("update_config_prefs", 4).edit().clear().commit();
            if ((j & 0xFFFFFF00) == (m & 0xFFFFFF00)) {
              ag.Zm("show_whatsnew");
            }
          }
          ((e.c)localObject3).dKL = bool1;
          ((e.c)localObject3).dKM = j;
          this.dJx = ((e.c)localObject3);
          com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreAccount", "check is update :%b ", new Object[] { Boolean.valueOf(((e.c)localObject3).dKL) });
          this.dJA = true;
          if (!this.dJz)
          {
            CS();
            g.DN().Dd();
          }
          at.dVC.Y("last_login_uin", o.getString(k));
          f.nEG.fn(k);
          if (getClass().getClassLoader() != null) {
            break label2548;
          }
          i = -1;
          label2253:
          if (Thread.currentThread().getContextClassLoader() != null) {
            break label2562;
          }
        }
        label2562:
        for (j = -1;; j = Thread.currentThread().getContextClassLoader().hashCode())
        {
          com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreAccount", "SmcLogic.setUin, class loader %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          this.dJw = new com.tencent.mm.model.a();
          com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreAccount", "setAccUin done :%s", new Object[] { o.getString(k) });
          g.DQ();
          if (g.DO().dJT == null) {
            break;
          }
          g.DQ();
          if (g.DO().dJT.edx == null) {
            break;
          }
          g.DQ();
          g.DO().dJT.edx.bP(true);
          g.DQ();
          ??? = g.DO().dJT.edx.KR();
          if ((k == 0) || (??? == null) || (k == ((com.tencent.mm.network.c)???).CK())) {
            break;
          }
          com.tencent.mm.sdk.platformtools.y.w("MMKernel.CoreAccount", "summerauth update acc info with acc stg: old acc uin=%d, this uin=%d", new Object[] { Integer.valueOf(((com.tencent.mm.network.c)???).CK()), Integer.valueOf(k) });
          f.nEG.a(148L, 46L, 1L, false);
          ((com.tencent.mm.network.c)???).fn(k);
          break;
          if ((m > 570425344) && (j <= 570425344))
          {
            paramBoolean = true;
            break label1804;
          }
          if ((m <= 570556456) || (j > 570556456)) {
            break label2575;
          }
          paramBoolean = true;
          break label1804;
          bool1 = false;
          break label1844;
          label2516:
          ((e)???).dKw.o(274480, Boolean.valueOf(false));
          com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreStorage", "[initialize] need not init emoji");
          break label1881;
          label2543:
          i = 0;
          break label1915;
          label2548:
          i = getClass().getClassLoader().hashCode();
          break label2253;
        }
        label2575:
        paramBoolean = false;
      }
    }
  }
  
  public final void be(int paramInt1, int paramInt2)
  {
    if ((this.dJB != paramInt1) || (this.dJC != paramInt2)) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.sdk.platformtools.y.d("MMKernel.CoreAccount", "online status, %d, %d, %d ,%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.dJC), Integer.valueOf(this.dJB) });
      if (i != 0) {
        break;
      }
      return;
    }
    this.dJB = paramInt1;
    this.dJC = paramInt2;
    new ah(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        a.this.CY();
      }
    });
  }
  
  public final void initialize()
  {
    if (Dc()) {
      return;
    }
    synchronized (this.dJs)
    {
      if (Dc()) {
        return;
      }
    }
    int i = b.a(dJt);
    if (i != 0)
    {
      this.dJF = SystemClock.elapsedRealtime();
      com.tencent.mm.sdk.platformtools.y.w("MMKernel.CoreAccount", "auto set up account storage uin: %d, stack: %s", new Object[] { Integer.valueOf(i), bk.csb() });
      bE(false);
    }
  }
  
  public final void release()
  {
    synchronized (this.dJs)
    {
      CR();
      return;
    }
  }
  
  private static enum a
  {
    private a() {}
  }
  
  static final class b
  {
    private static boolean dJQ = true;
    private boolean dJO = false;
    private com.tencent.mm.storage.y dJP;
    private int uin = 0;
    
    private int CK()
    {
      try
      {
        if (!this.dJO)
        {
          Dh();
          this.dJO = true;
        }
        int i = this.uin;
        return i;
      }
      finally {}
    }
    
    /* Error */
    private void Dh()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: aload_0
      //   3: monitorenter
      //   4: aload_0
      //   5: getfield 33	com/tencent/mm/kernel/a$b:dJP	Lcom/tencent/mm/storage/y;
      //   8: invokestatic 39	junit/framework/Assert:assertNotNull	(Ljava/lang/Object;)V
      //   11: aload_0
      //   12: getfield 33	com/tencent/mm/kernel/a$b:dJP	Lcom/tencent/mm/storage/y;
      //   15: astore 5
      //   17: aload 5
      //   19: ifnonnull +18 -> 37
      //   22: ldc 41
      //   24: ldc 43
      //   26: invokestatic 49	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   29: aload_0
      //   30: iload_1
      //   31: putfield 24	com/tencent/mm/kernel/a$b:uin	I
      //   34: aload_0
      //   35: monitorexit
      //   36: return
      //   37: aload 5
      //   39: iconst_1
      //   40: invokevirtual 55	com/tencent/mm/storage/y:get	(I)Ljava/lang/Object;
      //   43: checkcast 57	java/lang/Integer
      //   46: astore_3
      //   47: aload_3
      //   48: astore_2
      //   49: aload_3
      //   50: ifnonnull +154 -> 204
      //   53: aload 5
      //   55: getfield 60	com/tencent/mm/storage/y:unp	Z
      //   58: ifeq +17 -> 75
      //   61: getstatic 66	com/tencent/mm/plugin/report/f:nEG	Lcom/tencent/mm/plugin/report/f;
      //   64: ldc2_w 67
      //   67: ldc2_w 69
      //   70: lconst_1
      //   71: iconst_0
      //   72: invokevirtual 74	com/tencent/mm/plugin/report/f:a	(JJJZ)V
      //   75: invokestatic 80	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
      //   78: ldc 82
      //   80: iconst_4
      //   81: invokevirtual 88	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
      //   84: ldc 90
      //   86: iconst_0
      //   87: invokeinterface 96 3 0
      //   92: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   95: astore 4
      //   97: aload_3
      //   98: astore_2
      //   99: aload 4
      //   101: ifnull +103 -> 204
      //   104: ldc 41
      //   106: ldc 102
      //   108: iconst_3
      //   109: anewarray 4	java/lang/Object
      //   112: dup
      //   113: iconst_0
      //   114: aload_3
      //   115: aastore
      //   116: dup
      //   117: iconst_1
      //   118: aload 4
      //   120: aastore
      //   121: dup
      //   122: iconst_2
      //   123: aload 5
      //   125: getfield 60	com/tencent/mm/storage/y:unp	Z
      //   128: invokestatic 107	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   131: aastore
      //   132: invokestatic 111	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   135: getstatic 18	com/tencent/mm/kernel/a$b:dJQ	Z
      //   138: ifeq +53 -> 191
      //   141: ldc 41
      //   143: ldc 113
      //   145: iconst_2
      //   146: anewarray 4	java/lang/Object
      //   149: dup
      //   150: iconst_0
      //   151: aload 4
      //   153: aastore
      //   154: dup
      //   155: iconst_1
      //   156: invokestatic 119	com/tencent/mm/sdk/platformtools/bk:csb	()Lcom/tencent/mm/sdk/platformtools/ak;
      //   159: aastore
      //   160: invokestatic 121	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   163: getstatic 66	com/tencent/mm/plugin/report/f:nEG	Lcom/tencent/mm/plugin/report/f;
      //   166: sipush 11911
      //   169: iconst_1
      //   170: anewarray 4	java/lang/Object
      //   173: dup
      //   174: iconst_0
      //   175: aload 4
      //   177: invokestatic 125	com/tencent/mm/sdk/platformtools/bk:g	(Ljava/lang/Integer;)I
      //   180: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   183: aastore
      //   184: invokevirtual 129	com/tencent/mm/plugin/report/f:f	(I[Ljava/lang/Object;)V
      //   187: iconst_0
      //   188: putstatic 18	com/tencent/mm/kernel/a$b:dJQ	Z
      //   191: aload 5
      //   193: aload 4
      //   195: invokevirtual 132	java/lang/Integer:intValue	()I
      //   198: invokestatic 135	com/tencent/mm/kernel/a$b:a	(Lcom/tencent/mm/storage/y;I)V
      //   201: aload 4
      //   203: astore_2
      //   204: ldc 41
      //   206: ldc 137
      //   208: iconst_1
      //   209: anewarray 4	java/lang/Object
      //   212: dup
      //   213: iconst_0
      //   214: aload_2
      //   215: invokestatic 125	com/tencent/mm/sdk/platformtools/bk:g	(Ljava/lang/Integer;)I
      //   218: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   221: aastore
      //   222: invokestatic 111	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   225: aload_2
      //   226: invokestatic 125	com/tencent/mm/sdk/platformtools/bk:g	(Ljava/lang/Integer;)I
      //   229: istore_1
      //   230: goto -201 -> 29
      //   233: astore_2
      //   234: aload_0
      //   235: monitorexit
      //   236: aload_2
      //   237: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	238	0	this	b
      //   1	229	1	i	int
      //   48	178	2	localObject1	Object
      //   233	4	2	localObject2	Object
      //   46	69	3	localInteger1	Integer
      //   95	107	4	localInteger2	Integer
      //   15	177	5	localy	com.tencent.mm.storage.y
      // Exception table:
      //   from	to	target	type
      //   4	17	233	finally
      //   22	29	233	finally
      //   29	34	233	finally
      //   37	47	233	finally
      //   53	75	233	finally
      //   75	97	233	finally
      //   104	191	233	finally
      //   191	201	233	finally
      //   204	230	233	finally
    }
    
    private static void a(com.tencent.mm.storage.y paramy, int paramInt)
    {
      com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreAccount", "setSysUin uin: %d, stack: %s", new Object[] { Integer.valueOf(paramInt), bk.csb() });
      ae.getContext().getSharedPreferences("system_config_prefs", 4).edit().putInt("default_uin", paramInt).commit();
      paramy.set(1, Integer.valueOf(paramInt));
    }
    
    private void fn(int paramInt)
    {
      try
      {
        com.tencent.mm.sdk.platformtools.y.i("MMKernel.CoreAccount", "Uin From %s To %s hash:%d thread:%d[%s] stack:%s", new Object[] { o.getString(this.uin), o.getString(paramInt), Integer.valueOf(com.tencent.mm.a.h.aT(paramInt, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), bk.csb() });
        Assert.assertNotNull(this.dJP);
        a(this.dJP, paramInt);
        this.uin = paramInt;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final void a(com.tencent.mm.storage.y paramy)
    {
      try
      {
        this.dJP = paramy;
        return;
      }
      finally
      {
        paramy = finally;
        throw paramy;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a
 * JD-Core Version:    0.7.0.1
 */