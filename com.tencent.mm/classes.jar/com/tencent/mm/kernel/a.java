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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.i;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.cd;
import com.tencent.mm.g.a.ce;
import com.tencent.mm.g.a.gj;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.as;
import com.tencent.mm.model.av;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.cf;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
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
  private static boolean eGO;
  private static boolean eGP;
  static b eGR;
  private static String eGS;
  private static String eGT;
  private static boolean eGU;
  private static int eHd;
  private com.tencent.mm.kernel.api.c eGM;
  private com.tencent.mm.ai.y eGN;
  byte[] eGQ;
  public com.tencent.mm.model.a eGV;
  public e.c eGW;
  public int eGX;
  public boolean eGY;
  private boolean eGZ;
  public int eHa;
  public int eHb;
  public List<as> eHc;
  long eHe;
  private volatile a eHf;
  public volatile boolean eHg;
  private String eHh;
  private Map<String, Integer> eHi;
  
  static
  {
    AppMethodBeat.i(57921);
    eGO = true;
    eGP = false;
    eGR = new b();
    eGS = "NoResetUinStack";
    eGT = null;
    eHd = -1;
    AppMethodBeat.o(57921);
  }
  
  public a(com.tencent.mm.kernel.api.c paramc)
  {
    AppMethodBeat.i(57893);
    this.eGQ = new byte[0];
    this.eGY = false;
    this.eGZ = false;
    this.eHa = 0;
    this.eHc = new LinkedList();
    this.eHf = a.eHl;
    this.eHg = false;
    this.eHh = "";
    this.eHi = new HashMap();
    Assert.assertNotNull(eGR);
    g.RM();
    boolean bool;
    if (bo.g((Integer)g.RL().eHM.get(17)) != 0)
    {
      bool = true;
      eGO = bool;
      if (!f.whQ) {
        break label144;
      }
    }
    label144:
    for (int i = 763;; i = 702)
    {
      com.tencent.mm.protocal.j.e.a.wim = new ax(i);
      this.eGM = paramc;
      AppMethodBeat.o(57893);
      return;
      bool = false;
      break;
    }
  }
  
  public static SharedPreferences Mu()
  {
    AppMethodBeat.i(57912);
    SharedPreferences localSharedPreferences = ah.getContext().getSharedPreferences("notify_key_pref_settings", com.tencent.mm.compatible.util.h.Mp());
    AppMethodBeat.o(57912);
    return localSharedPreferences;
  }
  
  public static String QC()
  {
    AppMethodBeat.i(57895);
    String str = new com.tencent.mm.a.p(b.a(eGR)).toString();
    AppMethodBeat.o(57895);
    return str;
  }
  
  public static String QD()
  {
    return eGT;
  }
  
  public static boolean QE()
  {
    return eGU;
  }
  
  public static void QF()
  {
    eGU = true;
  }
  
  public static String QG()
  {
    return eGS;
  }
  
  protected static void QH()
  {
    AppMethodBeat.i(57896);
    b.a(eGR, 0);
    AppMethodBeat.o(57896);
  }
  
  protected static void QI()
  {
    AppMethodBeat.i(57897);
    b.a(eGR, 0);
    AppMethodBeat.o(57897);
  }
  
  private void QJ()
  {
    AppMethodBeat.i(57898);
    this.eHf = a.eHl;
    this.eHg = false;
    ab.i("MMKernel.CoreAccount", "mAccountStatus to NotReady");
    ah.getContext().getSharedPreferences(ah.dsP(), 0).edit().putBoolean("isLogin", false).commit();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
    ab.w("MMKernel.CoreAccount", "[arthurdan.AccountNR] account storage reset! uin:%d, resetStack is:%s, resetTime:%s", new Object[] { Integer.valueOf(b.a(eGR)), eGS, localSimpleDateFormat.format(new Date()) });
    AppMethodBeat.o(57898);
  }
  
  public static boolean QO()
  {
    return eGP;
  }
  
  public static boolean QP()
  {
    AppMethodBeat.i(57904);
    if (eGO)
    {
      g.RM();
      if (g.RJ() == null) {
        break label80;
      }
      g.RM();
      g.RJ();
    }
    label80:
    for (String str = com.tencent.mm.a.p.getString(b.a(eGR));; str = "-1")
    {
      ab.w("MMKernel.CoreAccount", "account holded :%s init:%b", new Object[] { str, Boolean.valueOf(g.RJ().QU()) });
      boolean bool = eGO;
      AppMethodBeat.o(57904);
      return bool;
    }
  }
  
  public static int QS()
  {
    AppMethodBeat.i(57911);
    int i = Mu().getInt("notification.user.state", 0);
    AppMethodBeat.o(57911);
    return i;
  }
  
  public static boolean QT()
  {
    AppMethodBeat.i(57915);
    if (b.a(eGR) != 0)
    {
      AppMethodBeat.o(57915);
      return true;
    }
    AppMethodBeat.o(57915);
    return false;
  }
  
  public static int QW()
  {
    AppMethodBeat.i(57917);
    int i = ah.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.h.Mp()).getInt("default_uin", 0);
    AppMethodBeat.o(57917);
    return i;
  }
  
  public static String QX()
  {
    AppMethodBeat.i(57918);
    g.RM();
    if (bo.isNullOrNil(g.RJ().eHh)) {
      QY();
    }
    g.RM();
    String str = g.RJ().eHh;
    AppMethodBeat.o(57918);
    return str;
  }
  
  public static void QY()
  {
    AppMethodBeat.i(57919);
    g.RM();
    g.RJ().eHh = (q.LK() + "_" + System.currentTimeMillis());
    g.RM();
    g.RJ().eHi.clear();
    AppMethodBeat.o(57919);
  }
  
  public static void cv(boolean paramBoolean)
  {
    eGP = paramBoolean;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(57894);
    int i = b.a(eGR);
    AppMethodBeat.o(57894);
    return i;
  }
  
  public static void hold()
  {
    AppMethodBeat.i(57905);
    g.RM();
    if (g.RJ() != null)
    {
      g.RM();
      g.RJ();
    }
    for (String str = com.tencent.mm.a.p.getString(b.a(eGR));; str = "-1")
    {
      ab.w("MMKernel.CoreAccount", " HOLD ACCOUNT! uin:%s stack:%s init:%b", new Object[] { str, bo.dtY(), Boolean.valueOf(g.RJ().QU()) });
      eGO = true;
      g.RM();
      g.RL().eHM.set(17, Integer.valueOf(1));
      AppMethodBeat.o(57905);
      return;
    }
  }
  
  static boolean jK(int paramInt)
  {
    return paramInt != 0;
  }
  
  public static void jL(int paramInt)
  {
    AppMethodBeat.i(57910);
    if ((eHd != -1) && (eHd == paramInt))
    {
      AppMethodBeat.o(57910);
      return;
    }
    eHd = paramInt;
    Mu().edit().putInt("notification.user.state", paramInt).commit();
    ab.i("MMKernel.CoreAccount", "[NOTIFICATION SETTINGS]save UserStatus: %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(57910);
  }
  
  public static boolean jM(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static String mv(String paramString)
  {
    eGT = paramString;
    return paramString;
  }
  
  public static void mw(String paramString)
  {
    eGS = paramString;
  }
  
  public static int mx(String paramString)
  {
    AppMethodBeat.i(57920);
    g.RM();
    if (g.RJ().eHi.get(paramString) == null) {}
    int j;
    for (int i = 0;; i = ((Integer)g.RJ().eHi.get(paramString)).intValue())
    {
      j = (int)bo.aox();
      if (i != 0) {
        break;
      }
      g.RM();
      g.RJ().eHi.put(paramString, Integer.valueOf(j));
      AppMethodBeat.o(57920);
      return i;
      g.RM();
    }
    i = j - i;
    g.RM();
    g.RJ().eHi.put(paramString, Integer.valueOf(j));
    if (i >= 0)
    {
      AppMethodBeat.o(57920);
      return i;
    }
    AppMethodBeat.o(57920);
    return 0;
  }
  
  public static void unhold()
  {
    AppMethodBeat.i(57906);
    g.RM();
    if (g.RJ() != null)
    {
      g.RM();
      g.RJ();
    }
    for (String str = com.tencent.mm.a.p.getString(b.a(eGR));; str = "-1")
    {
      ab.w("MMKernel.CoreAccount", " UN HOLD ACCOUNT! uin:%s init:%b", new Object[] { str, Boolean.valueOf(g.RJ().QU()) });
      eGO = false;
      g.RM();
      g.RL().eHM.set(17, Integer.valueOf(0));
      AppMethodBeat.o(57906);
      return;
    }
  }
  
  final void QK()
  {
    AppMethodBeat.i(57899);
    ab.w("MMKernel.CoreAccount", "account storage release  uin:%s thread:%s stack:%s", new Object[] { com.tencent.mm.a.p.getString(b.a(eGR)), Thread.currentThread().getName(), bo.dtY() });
    if (!QU())
    {
      ab.i("MMKernel.CoreAccount", "Fatal crash error!!! status is not initialized when release(), this callStack is:%s, last reset stack is:%s", new Object[] { bo.dtY().toString(), eGS });
      AppMethodBeat.o(57899);
      return;
    }
    this.eGM.onAccountRelease();
    g.RM();
    g.RL().kr(null);
    QJ();
    g.RM();
    g.RL().eIa.clear();
    AppMethodBeat.o(57899);
  }
  
  public final void QL()
  {
    AppMethodBeat.i(57901);
    if (!this.eGZ)
    {
      ab.i("MMKernel.CoreAccount", "no need do account initialized notify.");
      AppMethodBeat.o(57901);
      return;
    }
    this.eGZ = false;
    ab.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized tid:%d, stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), bo.dtY() });
    long l = System.currentTimeMillis();
    this.eGM.onAccountInitialized(this.eGW);
    ab.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized run tid[%d] take[%d]ms", new Object[] { Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l) });
    QM();
    AppMethodBeat.o(57901);
  }
  
  public final void QM()
  {
    AppMethodBeat.i(57902);
    if ((QU()) && (com.tencent.mm.kernel.a.c.RX().eJg))
    {
      ab.i("MMKernel.CoreAccount", "Flush client version.");
      g.RL().Rl();
    }
    AppMethodBeat.o(57902);
  }
  
  public final com.tencent.mm.ai.y QN()
  {
    try
    {
      AppMethodBeat.i(57903);
      if (this.eGN == null) {
        this.eGN = new com.tencent.mm.ai.y();
      }
      com.tencent.mm.ai.y localy = this.eGN;
      AppMethodBeat.o(57903);
      return localy;
    }
    finally {}
  }
  
  public final void QQ()
  {
    AppMethodBeat.i(57907);
    if (!QU())
    {
      com.tencent.mm.model.b localb = new com.tencent.mm.model.b();
      AppMethodBeat.o(57907);
      throw localb;
    }
    AppMethodBeat.o(57907);
  }
  
  public final void QR()
  {
    AppMethodBeat.i(57908);
    new ak(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(57881);
        as[] arrayOfas = new as[a.b(a.this).size()];
        a.b(a.this).toArray(arrayOfas);
        int j = arrayOfas.length;
        int i = 0;
        while (i < j)
        {
          arrayOfas[i].aaq();
          i += 1;
        }
        AppMethodBeat.o(57881);
      }
    });
    AppMethodBeat.o(57908);
  }
  
  public final boolean QU()
  {
    return this.eHf == a.eHm;
  }
  
  public final void QV()
  {
    AppMethodBeat.i(57916);
    ab.i("MMKernel.CoreAccount", "summerasyncinit setInitializedNotifyAllDone[%b] to true stack[%s]", new Object[] { Boolean.valueOf(this.eHg), bo.dtY() });
    this.eHg = true;
    long l = SystemClock.elapsedRealtime();
    ab.i("MMKernel.CoreAccount", "summerhardcoder setInitializedNotifyAllDone [%d %d] take[%d]ms, stack[%s]", new Object[] { Long.valueOf(this.eHe), Long.valueOf(l), Long.valueOf(l - this.eHe), bo.dtY() });
    cd localcd = new cd();
    com.tencent.mm.sdk.b.a.ymk.l(localcd);
    AppMethodBeat.o(57916);
  }
  
  public final void ci(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(57909);
    if ((this.eHa != paramInt1) || (this.eHb != paramInt2)) {}
    for (int i = 1;; i = 0)
    {
      ab.d("MMKernel.CoreAccount", "online status, %d, %d, %d ,%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.eHb), Integer.valueOf(this.eHa) });
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(57909);
      return;
    }
    this.eHa = paramInt1;
    this.eHb = paramInt2;
    new ak(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(57882);
        a.this.QR();
        AppMethodBeat.o(57882);
      }
    });
    AppMethodBeat.o(57909);
  }
  
  final void cu(boolean paramBoolean)
  {
    AppMethodBeat.i(57900);
    int j;
    final int k;
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
        i = g.RO().dtc();
        this.eGX = WXHardCoderJNI.startPerformance(bool1, j, k, m, i, WXHardCoderJNI.hcBootTimeout, 101, WXHardCoderJNI.hcBootAction, "MMKernel.CoreAccount");
        ab.i("MMKernel.CoreAccount", "summerhardcoder startPerformance[%s] stack[%s]", new Object[] { Integer.valueOf(this.eGX), bo.dtY() });
      }
    }
    else
    {
      ab.i("MMKernel.CoreAccount", "UserStatusChange: clear");
    }
    for (;;)
    {
      synchronized (this.eHc)
      {
        this.eHc.clear();
        long l1 = System.currentTimeMillis();
        k = b.a(eGR);
        ab.i("MMKernel.CoreAccount", "dkacc setAccuin %s hash:%d thread:%d[%s] stack:%s", new Object[] { com.tencent.mm.a.p.getString(k), Integer.valueOf(i.bQ(k, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), bo.dtY() });
        if (k != 0)
        {
          i = 1;
          if (i != 0) {
            break;
          }
          ab.w("MMKernel.CoreAccount", "setAccUin, Reset by MMCore.resetAccUin");
          ab.i("MMKernel.CoreAccount", "start time check setUinImpl end total time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
          ab.i("MMKernel.CoreAccount", "mAccountStatus to AccountHasReady");
          AppMethodBeat.o(57900);
          return;
          i = 0;
        }
      }
      i = 0;
    }
    com.tencent.mm.a.p.getString(k);
    com.tencent.mm.sdk.a.b.dsc();
    g.RM();
    ??? = g.RL();
    Object localObject3 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(57880);
        a.a(a.this);
        String str = com.tencent.mm.a.g.w(("mm" + k).getBytes());
        FileSystemManager localFileSystemManager = FileSystemManager.dQE();
        localFileSystemManager.erS().iE("account", str).rM(false);
        localFileSystemManager.erT();
        Object localObject1 = FileSystemManager.sContext;
        long l = localFileSystemManager.APR;
        boolean bool;
        if ((420000L >= 0L) && (l < 0L))
        {
          Object localObject2 = new IntentFilter();
          ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_ON");
          ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_OFF");
          ((IntentFilter)localObject2).addAction("android.intent.action.ACTION_POWER_CONNECTED");
          ((IntentFilter)localObject2).addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
          ((Context)localObject1).registerReceiver(localFileSystemManager.APO, (IntentFilter)localObject2);
          localObject2 = localFileSystemManager.APO;
          ((FileSystemManager.MaintenanceBroadcastReceiver)localObject2).kkn = ((PowerManager)((Context)localObject1).getSystemService("power")).isScreenOn();
          localObject1 = ((Context)localObject1).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
          if (localObject1 != null)
          {
            int i = ((Intent)localObject1).getIntExtra("status", -1);
            if ((i != 2) && (i != 5)) {
              break label271;
            }
            bool = true;
            ((FileSystemManager.MaintenanceBroadcastReceiver)localObject2).kkm = bool;
          }
        }
        for (;;)
        {
          localFileSystemManager.APR = 420000L;
          localFileSystemManager.APS = 259200000L;
          localFileSystemManager.APT = true;
          ab.i("VFS.Debug", "SetEnv ${account} = " + str + " and broadcast.");
          AppMethodBeat.o(57880);
          return;
          label271:
          bool = false;
          break;
          if ((420000L < 0L) && (l >= 0L)) {
            ((Context)localObject1).unregisterReceiver(localFileSystemManager.APO);
          }
        }
      }
    };
    ah.getContext().getSharedPreferences(ah.dsP(), 0).edit().putBoolean("isLogin", true).apply();
    String str1 = com.tencent.mm.a.g.w("mm".concat(String.valueOf(k)).getBytes());
    ((e)???).eHR = (((e)???).eHQ + str1 + "/");
    ((e)???).cachePath = (ac.eQv + str1 + "/");
    Object localObject4 = new File(((e)???).cachePath);
    ab.i("MMKernel.CoreStorage", "dkacc cachePath:" + ((e)???).cachePath + " accPath:" + ((e)???).eHR);
    long l2;
    if (!((File)localObject4).exists())
    {
      ab.w("MMKernel.CoreStorage", "setUin REBUILD data now ! DO NOT FUCKING TELL ME DB BROKEN !!! uin:%s data:%s sd:%s", new Object[] { com.tencent.mm.a.p.getString(k), ((e)???).cachePath, ((e)???).eHR });
      ((File)localObject4).mkdirs();
      if (!((e)???).cachePath.equalsIgnoreCase(((e)???).eHR))
      {
        l2 = System.currentTimeMillis();
        localObject4 = new File(((e)???).eHR);
        str1 = str1 + "temp" + System.currentTimeMillis();
        str1 = com.tencent.mm.compatible.util.e.eQz + str1;
        ((File)localObject4).renameTo(new File(str1));
        ab.i("MMKernel.CoreStorage", "find the old files and rename then %s" + (System.currentTimeMillis() - l2), new Object[] { str1 });
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      ((e)???).eHZ = new cf(((e)???).cachePath, bool1);
      ((e)???).Rm();
      localObject4 = ((e)???).cachePath + "MicroMsg.db";
      str1 = ((e)???).cachePath + "EnMicroMsg.db";
      String str2 = ((e)???).cachePath + "EnMicroMsg2.db";
      ((e)???).kr(null);
      ((e)???).mB(str1);
      ((e)???).eHS = new com.tencent.mm.cg.h(new e.2((e)???));
      Object localObject5 = ((e)???).eHS;
      l2 = k;
      q.bP(true);
      if (!((com.tencent.mm.cg.h)localObject5).b((String)localObject4, str1, str2, l2, e.getBaseDBFactories(), true))
      {
        ??? = new SQLiteException("main db init failed");
        AppMethodBeat.o(57900);
        throw ((Throwable)???);
      }
      localObject5 = ((e)???).eHS.yQT;
      if (!bo.isNullOrNil((String)localObject5))
      {
        ab.e("MMKernel.CoreStorage", "dbinit failed :".concat(String.valueOf(localObject5)));
        com.tencent.mm.sdk.a.b.G("init db Failed: [ " + (String)localObject5 + "]", "DBinit");
      }
      localObject5 = ((e)???).eHS;
      if (((com.tencent.mm.cg.h)localObject5).yQQ != null) {}
      for (boolean bool2 = ((com.tencent.mm.cg.h)localObject5).yQQ.yQn;; bool2 = false)
      {
        if (bool2) {
          ((e)???).eHY = true;
        }
        ((e)???).eHU = new z(((e)???).eHS);
        ((e)???).eHW = new by(((e)???).eHS);
        ((e)???).eHS.yQS = new e.3((e)???);
        ((e)???).eHX = ((e)???).eHW.dyQ();
        ((e)???).eHT = new com.tencent.mm.cg.h(((e)???).eHP);
        localObject5 = ((e)???).eHT;
        l2 = k;
        q.bP(true);
        if (((com.tencent.mm.cg.h)localObject5).b((String)localObject4, str1, str2, l2, new HashMap(), true)) {
          break;
        }
        ??? = new com.tencent.mm.model.b((byte)0);
        AppMethodBeat.o(57900);
        throw ((Throwable)???);
      }
      ((e)???).eHV = new bs(((e)???).eHU);
      ((e)???).eHV.add(new e.4((e)???));
      ((e)???).eHV.dyJ();
      ((Runnable)localObject3).run();
      if (bool1)
      {
        l2 = ((Long)((e)???).eHU.get(ac.a.yEk, Long.valueOf(0L))).longValue();
        i = ((Integer)((e)???).eHU.get(ac.a.yEl, Integer.valueOf(0))).intValue();
        if (l2 > 0L)
        {
          ab.w("MMKernel.CoreStorage", "summerinstall new install but firsttime[%d] > 0", new Object[] { Long.valueOf(l2) });
          label1239:
          if (i <= 0) {
            break label1488;
          }
          ab.w("MMKernel.CoreStorage", "summerinstall new install but version[%d] > 0", new Object[] { Integer.valueOf(i) });
          label1263:
          ab.i("MMKernel.CoreStorage", "edw setAccUin, summerinstall time[%d]，version[%d], clientversion[%d]", new Object[] { (Long)((e)???).eHU.get(ac.a.yEk, Long.valueOf(0L)), (Integer)((e)???).eHU.get(ac.a.yEl, Integer.valueOf(0)), Integer.valueOf(d.whH) });
        }
      }
      else
      {
        if (paramBoolean) {
          break label1513;
        }
        g.RM();
        ??? = bo.nullAsNil((String)g.RL().Ru().get(2, null));
        ab.i("MMKernel.CoreAccount", "summerinit validateUsername username[%s]", new Object[] { ??? });
        if (((String)???).length() > 0) {
          break label1508;
        }
        ab.e("MMKernel.CoreAccount", "username of acc stg not set: uin=" + b.a(eGR));
        QJ();
        b.a(eGR, 0);
        eGS = bo.dtY().toString();
        al.d(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(57883);
            g.RM().releaseAll();
            AppMethodBeat.o(57883);
          }
        });
      }
      label1488:
      label1508:
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label1513;
        }
        com.tencent.mm.plugin.report.e.qrI.idkeyStat(598L, 21L, 1L, true);
        ab.w("MMKernel.CoreAccount", "setAccUin, validateUsername false no need initialize!");
        break;
        ((e)???).eHU.set(ac.a.yEk, Long.valueOf(System.currentTimeMillis()));
        break label1239;
        ((e)???).eHU.set(ac.a.yEl, Integer.valueOf(d.whH));
        break label1263;
      }
      label1513:
      ??? = new ce();
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)???);
      g.RM();
      ??? = g.RL();
      localObject3 = new e.c();
      j = bo.g((Integer)((e)???).eHU.get(14, null));
      m = d.whH;
      ab.d("MMKernel.CoreStorage", "sVer: %s, cVer: %s.", new Object[] { Integer.toHexString(j), Integer.toHexString(m) });
      if (m == j) {
        paramBoolean = false;
      }
      for (;;)
      {
        label1608:
        if (paramBoolean)
        {
          ((e)???).eHU.set(8197, "");
          ((e)???).eHU.set(15, Integer.valueOf(0));
        }
        if (j != m)
        {
          bool1 = true;
          label1648:
          if ((j > 620822536) || (j == m)) {
            break label2401;
          }
          ((e)???).eHU.set(274480, Boolean.TRUE);
          ab.i("MMKernel.CoreStorage", "[initialize] need init emoji");
          label1684:
          if ((j != 0) && (j < 637599744)) {
            ((e)???).eHU.set(348162, Boolean.TRUE);
          }
          if (j == m) {
            break label2427;
          }
          i = 1;
          label1717:
          if (i == 0) {
            break label2432;
          }
          ab.w("MMKernel.CoreStorage", "account storage version changed from " + Integer.toHexString(j) + " to " + Integer.toHexString(m) + ", init=" + paramBoolean);
          if (((Integer)((e)???).eHM.get(37, Integer.valueOf(0))).intValue() == 0) {
            ((e)???).eHM.set(37, Integer.valueOf(j));
          }
          ((e)???).eHU.set(30, Boolean.FALSE);
          ((e)???).eHU.set(-2046825377, Boolean.FALSE);
          ((e)???).eHU.set(-2046825369, Boolean.FALSE);
          ((e)???).eHU.set(54, Boolean.FALSE);
          ((e)???).eHU.set(-2046825368, Boolean.FALSE);
          ((e)???).eHU.set(-2046825366, Boolean.TRUE);
          ((e)???).eHU.set(62, Boolean.TRUE);
          ah.getContext().getSharedPreferences("update_config_prefs", com.tencent.mm.compatible.util.h.Mp()).edit().clear().commit();
          if (((j & 0xFFFFFF00) == (m & 0xFFFFFF00)) || (j == 0))
          {
            ab.d("MMKernel.CoreStorage", "lock show_whatsnew from if.");
            aj.apk("show_whatsnew");
          }
          label1965:
          paramBoolean = ((e)???).eHU.getBoolean(ac.a.yLG, false);
          ((e)???).eHU.set(ac.a.yLG, Boolean.FALSE);
          ab.i("MMKernel.CoreStorage", "unlock show_whatsnew from testWhatsNew, %s.", new Object[] { Boolean.valueOf(paramBoolean) });
          if (paramBoolean) {
            aj.apl("show_whatsnew");
          }
          ((e.c)localObject3).eIj = bool1;
          ((e.c)localObject3).eIk = j;
          this.eGW = ((e.c)localObject3);
          ab.i("MMKernel.CoreAccount", "check is update :%b ", new Object[] { Boolean.valueOf(((e.c)localObject3).eIj) });
          this.eGZ = true;
          if (!this.eGY)
          {
            QL();
            g.RJ().QV();
          }
          av.flM.ao("last_login_uin", com.tencent.mm.a.p.getString(k));
          com.tencent.mm.plugin.report.e.qrI.setUin(k);
          if (getClass().getClassLoader() != null) {
            break label2451;
          }
          i = -1;
          label2120:
          if (Thread.currentThread().getContextClassLoader() != null) {
            break label2465;
          }
        }
        label2432:
        label2451:
        label2465:
        for (j = -1;; j = Thread.currentThread().getContextClassLoader().hashCode())
        {
          ab.i("MMKernel.CoreAccount", "SmcLogic.setUin, class loader %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          this.eGV = new com.tencent.mm.model.a();
          ab.i("MMKernel.CoreAccount", "setAccUin done :%s", new Object[] { com.tencent.mm.a.p.getString(k) });
          ??? = new gj();
          com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)???);
          g.RM();
          if (g.RK().eHt == null) {
            break;
          }
          g.RM();
          if (g.RK().eHt.ftA == null) {
            break;
          }
          g.RM();
          g.RK().eHt.ftA.cR(true);
          g.RM();
          ??? = g.RK().eHt.ftA.adI();
          if ((k == 0) || (??? == null) || (k == ((com.tencent.mm.network.c)???).getUin())) {
            break;
          }
          ab.w("MMKernel.CoreAccount", "summerauth update acc info with acc stg: old acc uin=%d, this uin=%d", new Object[] { Integer.valueOf(((com.tencent.mm.network.c)???).getUin()), Integer.valueOf(k) });
          com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 46L, 1L, false);
          ((com.tencent.mm.network.c)???).setUin(k);
          break;
          if ((m > 570425344) && (j <= 570425344))
          {
            paramBoolean = true;
            break label1608;
          }
          if ((m <= 570556456) || (j > 570556456)) {
            break label2478;
          }
          paramBoolean = true;
          break label1608;
          bool1 = false;
          break label1648;
          label2401:
          ((e)???).eHU.set(274480, Boolean.FALSE);
          ab.i("MMKernel.CoreStorage", "[initialize] need not init emoji");
          break label1684;
          label2427:
          i = 0;
          break label1717;
          ab.d("MMKernel.CoreStorage", "lock show_whatsnew from else.");
          aj.apk("show_whatsnew");
          break label1965;
          i = getClass().getClassLoader().hashCode();
          break label2120;
        }
        label2478:
        paramBoolean = false;
      }
    }
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(57914);
    if (QU())
    {
      AppMethodBeat.o(57914);
      return;
    }
    synchronized (this.eGQ)
    {
      if (QU())
      {
        AppMethodBeat.o(57914);
        return;
      }
      int i = b.a(eGR);
      if (i != 0)
      {
        this.eHe = SystemClock.elapsedRealtime();
        ab.w("MMKernel.CoreAccount", "auto set up account storage uin: %d, stack: %s", new Object[] { Integer.valueOf(i), bo.dtY() });
        cu(false);
      }
      AppMethodBeat.o(57914);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(57913);
    synchronized (this.eGQ)
    {
      QK();
      AppMethodBeat.o(57913);
      return;
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(57886);
      eHl = new a("NotReady", 0);
      eHm = new a("AccountHasReady", 1);
      eHn = new a[] { eHl, eHm };
      AppMethodBeat.o(57886);
    }
    
    private a() {}
  }
  
  static final class b
  {
    private static boolean eHq = true;
    private boolean eHo = false;
    private com.tencent.mm.storage.y eHp;
    private int uin = 0;
    
    /* Error */
    private void QZ()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc 28
      //   6: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: getfield 36	com/tencent/mm/kernel/a$b:eHp	Lcom/tencent/mm/storage/y;
      //   13: invokestatic 42	junit/framework/Assert:assertNotNull	(Ljava/lang/Object;)V
      //   16: aload_0
      //   17: getfield 36	com/tencent/mm/kernel/a$b:eHp	Lcom/tencent/mm/storage/y;
      //   20: astore 5
      //   22: aload 5
      //   24: ifnonnull +23 -> 47
      //   27: ldc 44
      //   29: ldc 46
      //   31: invokestatic 52	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   34: aload_0
      //   35: iload_1
      //   36: putfield 24	com/tencent/mm/kernel/a$b:uin	I
      //   39: ldc 28
      //   41: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   44: aload_0
      //   45: monitorexit
      //   46: return
      //   47: aload 5
      //   49: iconst_1
      //   50: invokevirtual 61	com/tencent/mm/storage/y:get	(I)Ljava/lang/Object;
      //   53: checkcast 63	java/lang/Integer
      //   56: astore_3
      //   57: aload_3
      //   58: astore_2
      //   59: aload_3
      //   60: ifnonnull +156 -> 216
      //   63: aload 5
      //   65: getfield 66	com/tencent/mm/storage/y:yxb	Z
      //   68: ifeq +17 -> 85
      //   71: getstatic 72	com/tencent/mm/plugin/report/e:qrI	Lcom/tencent/mm/plugin/report/e;
      //   74: ldc2_w 73
      //   77: ldc2_w 75
      //   80: lconst_1
      //   81: iconst_0
      //   82: invokevirtual 80	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
      //   85: invokestatic 86	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
      //   88: ldc 88
      //   90: invokestatic 94	com/tencent/mm/compatible/util/h:Mp	()I
      //   93: invokevirtual 100	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
      //   96: ldc 102
      //   98: iconst_0
      //   99: invokeinterface 108 3 0
      //   104: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   107: astore 4
      //   109: aload_3
      //   110: astore_2
      //   111: aload 4
      //   113: ifnull +103 -> 216
      //   116: ldc 44
      //   118: ldc 114
      //   120: iconst_3
      //   121: anewarray 4	java/lang/Object
      //   124: dup
      //   125: iconst_0
      //   126: aload_3
      //   127: aastore
      //   128: dup
      //   129: iconst_1
      //   130: aload 4
      //   132: aastore
      //   133: dup
      //   134: iconst_2
      //   135: aload 5
      //   137: getfield 66	com/tencent/mm/storage/y:yxb	Z
      //   140: invokestatic 119	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   143: aastore
      //   144: invokestatic 122	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   147: getstatic 18	com/tencent/mm/kernel/a$b:eHq	Z
      //   150: ifeq +53 -> 203
      //   153: ldc 44
      //   155: ldc 124
      //   157: iconst_2
      //   158: anewarray 4	java/lang/Object
      //   161: dup
      //   162: iconst_0
      //   163: aload 4
      //   165: aastore
      //   166: dup
      //   167: iconst_1
      //   168: invokestatic 130	com/tencent/mm/sdk/platformtools/bo:dtY	()Lcom/tencent/mm/sdk/platformtools/an;
      //   171: aastore
      //   172: invokestatic 132	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   175: getstatic 72	com/tencent/mm/plugin/report/e:qrI	Lcom/tencent/mm/plugin/report/e;
      //   178: sipush 11911
      //   181: iconst_1
      //   182: anewarray 4	java/lang/Object
      //   185: dup
      //   186: iconst_0
      //   187: aload 4
      //   189: invokestatic 136	com/tencent/mm/sdk/platformtools/bo:g	(Ljava/lang/Integer;)I
      //   192: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   195: aastore
      //   196: invokevirtual 140	com/tencent/mm/plugin/report/e:e	(I[Ljava/lang/Object;)V
      //   199: iconst_0
      //   200: putstatic 18	com/tencent/mm/kernel/a$b:eHq	Z
      //   203: aload 5
      //   205: aload 4
      //   207: invokevirtual 143	java/lang/Integer:intValue	()I
      //   210: invokestatic 147	com/tencent/mm/kernel/a$b:a	(Lcom/tencent/mm/storage/y;I)V
      //   213: aload 4
      //   215: astore_2
      //   216: ldc 44
      //   218: ldc 149
      //   220: iconst_1
      //   221: anewarray 4	java/lang/Object
      //   224: dup
      //   225: iconst_0
      //   226: aload_2
      //   227: invokestatic 136	com/tencent/mm/sdk/platformtools/bo:g	(Ljava/lang/Integer;)I
      //   230: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   233: aastore
      //   234: invokestatic 122	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   237: aload_2
      //   238: invokestatic 136	com/tencent/mm/sdk/platformtools/bo:g	(Ljava/lang/Integer;)I
      //   241: istore_1
      //   242: goto -208 -> 34
      //   245: astore_2
      //   246: aload_0
      //   247: monitorexit
      //   248: aload_2
      //   249: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	250	0	this	b
      //   1	241	1	i	int
      //   58	180	2	localObject1	Object
      //   245	4	2	localObject2	Object
      //   56	71	3	localInteger1	Integer
      //   107	107	4	localInteger2	Integer
      //   20	184	5	localy	com.tencent.mm.storage.y
      // Exception table:
      //   from	to	target	type
      //   4	22	245	finally
      //   27	34	245	finally
      //   34	44	245	finally
      //   47	57	245	finally
      //   63	85	245	finally
      //   85	109	245	finally
      //   116	203	245	finally
      //   203	213	245	finally
      //   216	242	245	finally
    }
    
    private static void a(com.tencent.mm.storage.y paramy, int paramInt)
    {
      AppMethodBeat.i(57890);
      ab.i("MMKernel.CoreAccount", "setSysUin uin: %d, stack: %s", new Object[] { Integer.valueOf(paramInt), bo.dtY() });
      ah.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.h.Mp()).edit().putInt("default_uin", paramInt).commit();
      paramy.set(1, Integer.valueOf(paramInt));
      AppMethodBeat.o(57890);
    }
    
    private int getUin()
    {
      try
      {
        AppMethodBeat.i(57887);
        if (!this.eHo)
        {
          QZ();
          this.eHo = true;
        }
        int i = this.uin;
        AppMethodBeat.o(57887);
        return i;
      }
      finally {}
    }
    
    private void setUin(int paramInt)
    {
      try
      {
        AppMethodBeat.i(57888);
        ab.i("MMKernel.CoreAccount", "Uin From %s To %s hash:%d thread:%d[%s] stack:%s", new Object[] { com.tencent.mm.a.p.getString(this.uin), com.tencent.mm.a.p.getString(paramInt), Integer.valueOf(i.bQ(paramInt, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), bo.dtY() });
        Assert.assertNotNull(this.eHp);
        a(this.eHp, paramInt);
        this.uin = paramInt;
        AppMethodBeat.o(57888);
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
        this.eHp = paramy;
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