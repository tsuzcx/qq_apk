package com.tencent.mm.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.z;
import com.tencent.mm.b.i;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.cj;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.av;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.ba;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bz;
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
  private static boolean gbV;
  private static boolean gbW;
  static b gbY;
  private static String gbZ;
  private static String gca;
  private static boolean gcb;
  private static int gck;
  private com.tencent.mm.kernel.api.c gbT;
  private z gbU;
  byte[] gbX;
  public com.tencent.mm.model.a gcc;
  public e.c gcd;
  public int gce;
  public boolean gcf;
  private boolean gcg;
  public int gch;
  public int gci;
  private List<av> gcj;
  long gcl;
  private volatile a gcm;
  public volatile boolean gcn;
  private String gco;
  private Map<String, Integer> gcp;
  
  static
  {
    AppMethodBeat.i(132045);
    gbV = true;
    gbW = false;
    gbY = new b();
    gbZ = "NoResetUinStack";
    gca = null;
    gck = -1;
    AppMethodBeat.o(132045);
  }
  
  public a(com.tencent.mm.kernel.api.c paramc)
  {
    AppMethodBeat.i(132014);
    this.gbX = new byte[0];
    this.gcf = false;
    this.gcg = false;
    this.gch = 0;
    this.gcj = new LinkedList();
    this.gcm = a.gcr;
    this.gcn = false;
    this.gco = "";
    this.gcp = new HashMap();
    Assert.assertNotNull(gbY);
    g.afC();
    boolean bool;
    if (com.tencent.mm.sdk.platformtools.bt.l((Integer)g.afB().gcR.get(17)) != 0)
    {
      bool = true;
      gbV = bool;
      if (!f.CpT) {
        break label144;
      }
    }
    label144:
    for (int i = 763;; i = 702)
    {
      com.tencent.mm.protocal.j.e.a.Cqp = new ba(i);
      this.gbT = paramc;
      AppMethodBeat.o(132014);
      return;
      bool = false;
      break;
    }
  }
  
  public static SharedPreferences Yf()
  {
    AppMethodBeat.i(132035);
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("notify_key_pref_settings", com.tencent.mm.compatible.util.g.XN());
    AppMethodBeat.o(132035);
    return localSharedPreferences;
  }
  
  public static boolean aeB()
  {
    return gbW;
  }
  
  public static boolean aeC()
  {
    AppMethodBeat.i(132025);
    if (gbV)
    {
      g.afC();
      if (g.afz() == null) {
        break label77;
      }
      g.afC();
      g.afz();
    }
    label77:
    for (String str = p.getString(b.a(gbY));; str = "-1")
    {
      ad.w("MMKernel.CoreAccount", "account holded :%s init:%b", new Object[] { str, Boolean.valueOf(g.afz().aeI()) });
      boolean bool = gbV;
      AppMethodBeat.o(132025);
      return bool;
    }
  }
  
  public static int aeF()
  {
    AppMethodBeat.i(132034);
    int i = Yf().getInt("notification.user.state", 0);
    AppMethodBeat.o(132034);
    return i;
  }
  
  public static boolean aeH()
  {
    AppMethodBeat.i(132039);
    if (b.a(gbY) != 0)
    {
      AppMethodBeat.o(132039);
      return true;
    }
    AppMethodBeat.o(132039);
    return false;
  }
  
  public static int aeL()
  {
    AppMethodBeat.i(132041);
    int i = aj.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.XN()).getInt("default_uin", 0);
    AppMethodBeat.o(132041);
    return i;
  }
  
  public static String aeM()
  {
    AppMethodBeat.i(132042);
    g.afC();
    if (com.tencent.mm.sdk.platformtools.bt.isNullOrNil(g.afz().gco)) {
      aeN();
    }
    g.afC();
    String str = g.afz().gco;
    AppMethodBeat.o(132042);
    return str;
  }
  
  public static void aeN()
  {
    AppMethodBeat.i(132043);
    g.afC();
    g.afz().gco = (com.tencent.mm.compatible.deviceinfo.q.Xa() + "_" + System.currentTimeMillis());
    g.afC();
    g.afz().gcp.clear();
    AppMethodBeat.o(132043);
  }
  
  public static String aeo()
  {
    AppMethodBeat.i(132016);
    String str = new p(b.a(gbY)).toString();
    AppMethodBeat.o(132016);
    return str;
  }
  
  public static final int aep()
  {
    AppMethodBeat.i(192870);
    int i = b.access$100();
    AppMethodBeat.o(192870);
    return i;
  }
  
  public static String aeq()
  {
    return gca;
  }
  
  public static boolean aer()
  {
    return gcb;
  }
  
  public static void aes()
  {
    gcb = true;
  }
  
  public static String aet()
  {
    return gbZ;
  }
  
  protected static void aeu()
  {
    AppMethodBeat.i(132017);
    b.a(gbY, 0);
    AppMethodBeat.o(132017);
  }
  
  protected static void aev()
  {
    AppMethodBeat.i(132018);
    b.a(gbY, 0);
    AppMethodBeat.o(132018);
  }
  
  private void aew()
  {
    AppMethodBeat.i(132019);
    this.gcm = a.gcr;
    this.gcn = false;
    ad.i("MMKernel.CoreAccount", "mAccountStatus to NotReady");
    aj.getContext().getSharedPreferences(aj.eFD(), 0).edit().putBoolean("isLogin", false).commit();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
    ad.w("MMKernel.CoreAccount", "[arthurdan.AccountNR] account storage reset! uin:%d, resetStack is:%s, resetTime:%s", new Object[] { Integer.valueOf(b.a(gbY)), gbZ, localSimpleDateFormat.format(new Date()) });
    AppMethodBeat.o(132019);
  }
  
  public static void dz(boolean paramBoolean)
  {
    gbW = paramBoolean;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(132015);
    int i = b.a(gbY);
    AppMethodBeat.o(132015);
    return i;
  }
  
  public static void hold()
  {
    AppMethodBeat.i(132026);
    g.afC();
    if (g.afz() != null)
    {
      g.afC();
      g.afz();
    }
    for (String str = p.getString(b.a(gbY));; str = "-1")
    {
      ad.w("MMKernel.CoreAccount", " HOLD ACCOUNT! uin:%s stack:%s init:%b", new Object[] { str, com.tencent.mm.sdk.platformtools.bt.eGN(), Boolean.valueOf(g.afz().aeI()) });
      gbV = true;
      g.afC();
      g.afB().gcR.set(17, Integer.valueOf(1));
      AppMethodBeat.o(132026);
      return;
    }
  }
  
  static boolean mn(int paramInt)
  {
    return paramInt != 0;
  }
  
  public static void mo(int paramInt)
  {
    AppMethodBeat.i(132033);
    if ((gck != -1) && (gck == paramInt))
    {
      AppMethodBeat.o(132033);
      return;
    }
    gck = paramInt;
    Yf().edit().putInt("notification.user.state", paramInt).commit();
    ad.i("MMKernel.CoreAccount", "[NOTIFICATION SETTINGS]save UserStatus: %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(132033);
  }
  
  public static boolean mp(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static String qL(String paramString)
  {
    gca = paramString;
    return paramString;
  }
  
  public static void qM(String paramString)
  {
    gbZ = paramString;
  }
  
  public static int qN(String paramString)
  {
    AppMethodBeat.i(132044);
    g.afC();
    if (g.afz().gcp.get(paramString) == null) {}
    int j;
    for (int i = 0;; i = ((Integer)g.afz().gcp.get(paramString)).intValue())
    {
      j = (int)com.tencent.mm.sdk.platformtools.bt.aGK();
      if (i != 0) {
        break;
      }
      g.afC();
      g.afz().gcp.put(paramString, Integer.valueOf(j));
      AppMethodBeat.o(132044);
      return i;
      g.afC();
    }
    i = j - i;
    g.afC();
    g.afz().gcp.put(paramString, Integer.valueOf(j));
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
    g.afC();
    if (g.afz() != null)
    {
      g.afC();
      g.afz();
    }
    for (String str = p.getString(b.a(gbY));; str = "-1")
    {
      ad.w("MMKernel.CoreAccount", " UN HOLD ACCOUNT! uin:%s init:%b", new Object[] { str, Boolean.valueOf(g.afz().aeI()) });
      gbV = false;
      g.afC();
      g.afB().gcR.set(17, Integer.valueOf(0));
      AppMethodBeat.o(132027);
      return;
    }
  }
  
  public final void a(av paramav)
  {
    AppMethodBeat.i(132029);
    ad.i("MMKernel.CoreAccount", "UserStatusChange: add %s", new Object[] { paramav });
    synchronized (this.gcj)
    {
      if (!this.gcj.contains(paramav)) {
        this.gcj.add(paramav);
      }
      AppMethodBeat.o(132029);
      return;
    }
  }
  
  public final z aeA()
  {
    try
    {
      AppMethodBeat.i(132024);
      if (this.gbU == null) {
        this.gbU = new z();
      }
      z localz = this.gbU;
      AppMethodBeat.o(132024);
      return localz;
    }
    finally {}
  }
  
  public final void aeD()
  {
    AppMethodBeat.i(132028);
    if (!aeI())
    {
      com.tencent.mm.model.b localb = new com.tencent.mm.model.b();
      AppMethodBeat.o(132028);
      throw localb;
    }
    AppMethodBeat.o(132028);
  }
  
  public final void aeE()
  {
    AppMethodBeat.i(132031);
    new ap(Looper.getMainLooper()).post(new Runnable()
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
          arrayOfav[i].arM();
          i += 1;
        }
        AppMethodBeat.o(132002);
      }
    });
    AppMethodBeat.o(132031);
  }
  
  public final boolean aeG()
  {
    AppMethodBeat.i(132036);
    boolean bool = mp(this.gch);
    AppMethodBeat.o(132036);
    return bool;
  }
  
  public final boolean aeI()
  {
    return this.gcm == a.gcs;
  }
  
  public final boolean aeJ()
  {
    return this.gcn;
  }
  
  public final void aeK()
  {
    AppMethodBeat.i(132040);
    ad.i("MMKernel.CoreAccount", "summerasyncinit setInitializedNotifyAllDone[%b] to true stack[%s]", new Object[] { Boolean.valueOf(this.gcn), com.tencent.mm.sdk.platformtools.bt.eGN() });
    this.gcn = true;
    long l = SystemClock.elapsedRealtime();
    ad.i("MMKernel.CoreAccount", "summerhardcoder setInitializedNotifyAllDone [%d %d] take[%d]ms, stack[%s]", new Object[] { Long.valueOf(this.gcl), Long.valueOf(l), Long.valueOf(l - this.gcl), com.tencent.mm.sdk.platformtools.bt.eGN() });
    com.tencent.mm.g.a.ci localci = new com.tencent.mm.g.a.ci();
    com.tencent.mm.sdk.b.a.ESL.l(localci);
    AppMethodBeat.o(132040);
  }
  
  final void aex()
  {
    AppMethodBeat.i(132020);
    ad.w("MMKernel.CoreAccount", "account storage release  uin:%s thread:%s stack:%s", new Object[] { p.getString(b.a(gbY)), Thread.currentThread().getName(), com.tencent.mm.sdk.platformtools.bt.eGN() });
    if (!aeI())
    {
      ad.i("MMKernel.CoreAccount", "Fatal crash error!!! status is not initialized when release(), this callStack is:%s, last reset stack is:%s", new Object[] { com.tencent.mm.sdk.platformtools.bt.eGN().toString(), gbZ });
      AppMethodBeat.o(132020);
      return;
    }
    this.gbT.onAccountRelease();
    g.afC();
    g.afB().oi(null);
    aew();
    g.afC();
    g.afB().gdi.clear();
    AppMethodBeat.o(132020);
  }
  
  public final void aey()
  {
    AppMethodBeat.i(132022);
    if (!this.gcg)
    {
      ad.i("MMKernel.CoreAccount", "no need do account initialized notify.");
      AppMethodBeat.o(132022);
      return;
    }
    this.gcg = false;
    ad.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized tid:%d, stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), com.tencent.mm.sdk.platformtools.bt.eGN() });
    long l = System.currentTimeMillis();
    this.gbT.onAccountInitialized(this.gcd);
    ad.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized run tid[%d] take[%d]ms", new Object[] { Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l) });
    aez();
    AppMethodBeat.o(132022);
  }
  
  public final void aez()
  {
    AppMethodBeat.i(132023);
    if ((aeI()) && (com.tencent.mm.kernel.a.c.afO().gep))
    {
      ad.i("MMKernel.CoreAccount", "Flush client version.");
      g.afB().afb();
    }
    AppMethodBeat.o(132023);
  }
  
  public final void b(av paramav)
  {
    AppMethodBeat.i(132030);
    ad.i("MMKernel.CoreAccount", "UserStatusChange: remove %s", new Object[] { paramav });
    synchronized (this.gcj)
    {
      this.gcj.remove(paramav);
      AppMethodBeat.o(132030);
      return;
    }
  }
  
  public final void cO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132032);
    if ((this.gch != paramInt1) || (this.gci != paramInt2)) {}
    for (int i = 1;; i = 0)
    {
      ad.d("MMKernel.CoreAccount", "online status, %d, %d, %d ,%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.gci), Integer.valueOf(this.gch) });
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(132032);
      return;
    }
    this.gch = paramInt1;
    this.gci = paramInt2;
    new ap(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132003);
        a.this.aeE();
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
        i = g.afE().eFQ();
        this.gce = WXHardCoderJNI.startPerformance(bool1, j, k, m, i, WXHardCoderJNI.hcBootTimeout, 101, WXHardCoderJNI.hcBootAction, "MMKernel.CoreAccount");
        ad.i("MMKernel.CoreAccount", "summerhardcoder startPerformance[%s] stack[%s]", new Object[] { Integer.valueOf(this.gce), com.tencent.mm.sdk.platformtools.bt.eGN() });
      }
    }
    else
    {
      ad.i("MMKernel.CoreAccount", "UserStatusChange: clear");
    }
    for (;;)
    {
      synchronized (this.gcj)
      {
        this.gcj.clear();
        long l1 = System.currentTimeMillis();
        k = b.a(gbY);
        ad.i("MMKernel.CoreAccount", "dkacc setAccuin %s hash:%d thread:%d[%s] stack:%s", new Object[] { p.getString(k), Integer.valueOf(i.cf(k, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), com.tencent.mm.sdk.platformtools.bt.eGN() });
        if (k != 0)
        {
          i = 1;
          if (i != 0) {
            break;
          }
          ad.w("MMKernel.CoreAccount", "setAccUin, Reset by MMCore.resetAccUin");
          ad.i("MMKernel.CoreAccount", "start time check setUinImpl end total time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
          ad.i("MMKernel.CoreAccount", "mAccountStatus to AccountHasReady");
          AppMethodBeat.o(132021);
          return;
          i = 0;
        }
      }
      i = 0;
    }
    p.getString(k);
    com.tencent.mm.sdk.a.b.eEN();
    g.afC();
    e locale = g.afB();
    Object localObject5 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132001);
        a.a(a.this);
        AppMethodBeat.o(132001);
      }
    };
    aj.getContext().getSharedPreferences(aj.eFD(), 0).edit().putBoolean("isLogin", true).apply();
    ??? = com.tencent.mm.b.g.getMessageDigest("mm".concat(String.valueOf(k)).getBytes());
    Object localObject3 = e.C(k, (String)???);
    ad.i("MMKernel.CoreStorage", "uinPath: %s, uinSaltPath: %s", new Object[] { ???, localObject3 });
    boolean bool4 = com.tencent.mm.compatible.util.e.XG();
    label412:
    Object localObject4;
    label462:
    long l2;
    label514:
    Object localObject6;
    if (localObject3 == null)
    {
      ad.w("MMKernel.CoreStorage", "Cannot generate account path, skip account renaming!");
      i = 6;
      bool1 = false;
      locale.gcX = ((String)???);
      locale.cachePath = (ae.FfH + locale.gcX + '/');
      if (!bool1) {
        break label1201;
      }
      localObject4 = localObject3;
      locale.gcZ = ((String)localObject4);
      locale.gcW = (locale.gcV + locale.gcZ + '/');
      if (localObject3 != null) {
        break label1208;
      }
      localObject4 = ???;
      locale.gcY = ((String)localObject4);
      o.abe(i);
      localObject4 = new com.tencent.mm.vfs.e(locale.cachePath);
      ad.i("MMKernel.CoreStorage", "dkacc cachePath:" + locale.cachePath + " accPath:" + locale.gcW);
      if (((com.tencent.mm.vfs.e)localObject4).exists()) {
        break label2983;
      }
      ad.w("MMKernel.CoreStorage", "setUin REBUILD data now ! DO NOT FUCKING TELL ME DB BROKEN !!! uin:%s data:%s sd:%s", new Object[] { p.getString(k), locale.cachePath, locale.gcW });
      ((com.tencent.mm.vfs.e)localObject4).mkdirs();
      if (!locale.cachePath.equalsIgnoreCase(locale.gcW))
      {
        l2 = System.currentTimeMillis();
        localObject4 = new com.tencent.mm.vfs.e(locale.gcW);
        localObject6 = (String)??? + "temp" + System.currentTimeMillis();
        localObject6 = com.tencent.mm.loader.j.b.aih() + (String)localObject6;
        ((com.tencent.mm.vfs.e)localObject4).af(new com.tencent.mm.vfs.e((String)localObject6));
        ad.i("MMKernel.CoreStorage", "find the old files and rename then %s" + (System.currentTimeMillis() - l2), new Object[] { localObject6 });
      }
    }
    label2189:
    label2470:
    label2983:
    for (boolean bool2 = true;; bool2 = false)
    {
      locale.gdh = new com.tencent.mm.model.ci(locale.cachePath, bool2);
      locale.afc();
      localObject4 = locale.cachePath + "MicroMsg.db";
      localObject6 = locale.cachePath + "EnMicroMsg.db";
      String str = locale.cachePath + "EnMicroMsg2.db";
      locale.oi(null);
      locale.qQ((String)localObject6);
      locale.gda = new h(new e.2(locale));
      Object localObject7 = locale.gda;
      l2 = k;
      com.tencent.mm.compatible.deviceinfo.q.cG(true);
      if (!((h)localObject7).b((String)localObject4, (String)localObject6, str, l2, e.getBaseDBFactories(), true))
      {
        ??? = new SQLiteException("main db init failed");
        AppMethodBeat.o(132021);
        throw ((Throwable)???);
        if ((!locale.gcV.startsWith(com.tencent.mm.loader.j.b.aib())) || (!bool4))
        {
          ad.w("MMKernel.CoreStorage", "SDCard not available, skip account renaming!");
          i = 1;
          bool1 = false;
          break label412;
        }
        localObject4 = new com.tencent.mm.vfs.e(locale.gcV + (String)???);
        localObject6 = new com.tencent.mm.vfs.e(locale.gcV + (String)localObject3);
        if (((com.tencent.mm.vfs.e)localObject4).isDirectory())
        {
          if (((com.tencent.mm.vfs.e)localObject6).isDirectory())
          {
            ad.i("MMKernel.CoreStorage", "Both uinPath exists, migration shall be taken.");
            i = 2;
            bool1 = true;
            break label412;
          }
          ((com.tencent.mm.vfs.e)localObject6).delete();
          ad.i("MMKernel.CoreStorage", "Move account directory: %s => %s", new Object[] { localObject4, localObject6 });
          if (!((com.tencent.mm.vfs.e)localObject4).af((com.tencent.mm.vfs.e)localObject6))
          {
            ad.w("MMKernel.CoreStorage", "Failed to move uinPath, use old accPath");
            i = 4;
            bool1 = false;
            break label412;
          }
          ad.i("MMKernel.CoreStorage", "Moved to new uinPath");
          i = 3;
          bool1 = true;
          break label412;
        }
        if (!((com.tencent.mm.vfs.e)localObject6).isDirectory()) {
          ((com.tencent.mm.vfs.e)localObject6).delete();
        }
        ((com.tencent.mm.vfs.e)localObject6).mkdirs();
        i = 5;
        bool1 = true;
        break label412;
        label1201:
        localObject4 = ???;
        break label462;
        label1208:
        localObject4 = localObject3;
        break label514;
      }
      localObject7 = locale.gda.FCL;
      if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil((String)localObject7))
      {
        ad.e("MMKernel.CoreStorage", "dbinit failed :".concat(String.valueOf(localObject7)));
        com.tencent.mm.sdk.a.b.M("init db Failed: [ " + (String)localObject7 + "]", "DBinit");
      }
      localObject7 = locale.gda;
      if (((h)localObject7).FCI != null) {}
      for (boolean bool3 = ((h)localObject7).FCI.FCf;; bool3 = false)
      {
        if (bool3) {
          locale.gdg = true;
        }
        locale.gdc = new ab(locale.gda);
        locale.gde = new bz(locale.gda);
        locale.gda.FCK = new e.3(locale);
        locale.gdf = locale.gde.eNa();
        locale.gdb = new h(locale.gcU);
        localObject7 = locale.gdb;
        l2 = k;
        com.tencent.mm.compatible.deviceinfo.q.cG(true);
        if (((h)localObject7).b((String)localObject4, (String)localObject6, str, l2, new HashMap(), true)) {
          break;
        }
        ??? = new com.tencent.mm.model.b((byte)0);
        AppMethodBeat.o(132021);
        throw ((Throwable)???);
      }
      locale.gdd = new com.tencent.mm.storage.bt(locale.gdc);
      locale.gdd.add(new e.4(locale));
      locale.gdd.eMT();
      ((Runnable)localObject5).run();
      if ((bool4) && (locale.gcV.startsWith(com.tencent.mm.loader.j.b.aib())))
      {
        bool3 = true;
        label1534:
        localObject5 = com.tencent.mm.vfs.a.gap().gar();
        localObject6 = ((com.tencent.mm.vfs.a.a)localObject5).lz("account", (String)???).lz("accountSalt", locale.gcY);
        if (!bool3) {
          break label1960;
        }
        localObject4 = locale.gcY;
        label1577:
        ((com.tencent.mm.vfs.a.a)localObject6).lz("accountSd", (String)localObject4);
        if (localObject3 == null) {
          break label1967;
        }
        bool4 = true;
        label1596:
        o.a((com.tencent.mm.vfs.a.a)localObject5, bool3, bool4);
        o.a((com.tencent.mm.vfs.a.a)localObject5, locale.gcV, bool1);
        ((com.tencent.mm.vfs.a.a)localObject5).xf(false);
        ad.i("VFS.Debug", "SetEnv ${account} = ".concat(String.valueOf(???)));
        o.xg(bool1);
        if (bool2)
        {
          l2 = ((Long)locale.gdc.get(ae.a.FmQ, Long.valueOf(0L))).longValue();
          i = ((Integer)locale.gdc.get(ae.a.FmR, Integer.valueOf(0))).intValue();
          if (l2 <= 0L) {
            break label1973;
          }
          ad.w("MMKernel.CoreStorage", "summerinstall new install but firsttime[%d] > 0", new Object[] { Long.valueOf(l2) });
          label1725:
          if (i <= 0) {
            break label1993;
          }
          ad.w("MMKernel.CoreStorage", "summerinstall new install but version[%d] > 0", new Object[] { Integer.valueOf(i) });
          label1749:
          ad.i("MMKernel.CoreStorage", "edw setAccUin, summerinstall time[%d]，version[%d], clientversion[%d]", new Object[] { (Long)locale.gdc.get(ae.a.FmQ, Long.valueOf(0L)), (Integer)locale.gdc.get(ae.a.FmR, Integer.valueOf(0)), Integer.valueOf(d.CpK) });
        }
        if (paramBoolean) {
          break label2018;
        }
        g.afC();
        ??? = com.tencent.mm.sdk.platformtools.bt.nullAsNil((String)g.afB().afk().get(2, null));
        ad.i("MMKernel.CoreAccount", "summerinit validateUsername username[%s]", new Object[] { ??? });
        if (((String)???).length() > 0) {
          break label2013;
        }
        ad.e("MMKernel.CoreAccount", "username of acc stg not set: uin=" + b.a(gbY));
        aew();
        b.a(gbY, 0);
        gbZ = com.tencent.mm.sdk.platformtools.bt.eGN().toString();
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(132004);
            g.afC().releaseAll();
            AppMethodBeat.o(132004);
          }
        });
      }
      label1960:
      label1967:
      label1973:
      label1993:
      label2013:
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label2018;
        }
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(598L, 21L, 1L, true);
        ad.w("MMKernel.CoreAccount", "setAccUin, validateUsername false no need initialize!");
        break;
        bool3 = false;
        break label1534;
        localObject4 = ???;
        break label1577;
        bool4 = false;
        break label1596;
        locale.gdc.set(ae.a.FmQ, Long.valueOf(System.currentTimeMillis()));
        break label1725;
        locale.gdc.set(ae.a.FmR, Integer.valueOf(d.CpK));
        break label1749;
      }
      label2018:
      ??? = new cj();
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)???);
      g.afC();
      ??? = g.afB();
      localObject3 = new e.c();
      j = com.tencent.mm.sdk.platformtools.bt.l((Integer)((e)???).gdc.get(14, null));
      m = d.CpK;
      ad.d("MMKernel.CoreStorage", "sVer: %s, cVer: %s.", new Object[] { Integer.toHexString(j), Integer.toHexString(m) });
      if (m == j) {
        paramBoolean = false;
      }
      for (;;)
      {
        label2113:
        if (paramBoolean)
        {
          ((e)???).gdc.set(8197, "");
          ((e)???).gdc.set(15, Integer.valueOf(0));
        }
        if (j != m)
        {
          bool1 = true;
          label2153:
          if ((j > 620822536) || (j == m)) {
            break label2896;
          }
          ((e)???).gdc.set(274480, Boolean.TRUE);
          ad.i("MMKernel.CoreStorage", "[initialize] need init emoji");
          if ((j != 0) && (j < 637599744)) {
            ((e)???).gdc.set(348162, Boolean.TRUE);
          }
          if (j == m) {
            break label2922;
          }
          i = 1;
          label2222:
          if (i == 0) {
            break label2927;
          }
          ad.w("MMKernel.CoreStorage", "account storage version changed from " + Integer.toHexString(j) + " to " + Integer.toHexString(m) + ", init=" + paramBoolean);
          if (((Integer)((e)???).gcR.get(37, Integer.valueOf(0))).intValue() == 0) {
            ((e)???).gcR.set(37, Integer.valueOf(j));
          }
          ((e)???).gdc.set(30, Boolean.FALSE);
          ((e)???).gdc.set(-2046825377, Boolean.FALSE);
          ((e)???).gdc.set(-2046825369, Boolean.FALSE);
          ((e)???).gdc.set(54, Boolean.FALSE);
          ((e)???).gdc.set(-2046825368, Boolean.FALSE);
          ((e)???).gdc.set(-2046825366, Boolean.TRUE);
          ((e)???).gdc.set(62, Boolean.TRUE);
          aj.getContext().getSharedPreferences("update_config_prefs", com.tencent.mm.compatible.util.g.XN()).edit().clear().commit();
          if (((j & 0xFFFFFF00) == (m & 0xFFFFFF00)) || (j == 0))
          {
            ad.d("MMKernel.CoreStorage", "lock show_whatsnew from if.");
            an.aFx("show_whatsnew");
          }
          if (((e)???).gdc.getInt(ae.a.FwN, -1) <= 0) {
            break label2946;
          }
          paramBoolean = true;
          label2487:
          ad.i("MMKernel.CoreStorage", "unlock show_whatsnew from testWhatsNew, %s.", new Object[] { Boolean.valueOf(paramBoolean) });
          if (paramBoolean) {
            an.aFy("show_whatsnew");
          }
          ((e.c)localObject3).gdr = bool1;
          ((e.c)localObject3).gds = j;
          this.gcd = ((e.c)localObject3);
          ad.i("MMKernel.CoreAccount", "check is update :%b ", new Object[] { Boolean.valueOf(((e.c)localObject3).gdr) });
          this.gcg = true;
          if (!this.gcf)
          {
            aey();
            g.afz().aeK();
          }
          ay.gNa.aD("last_login_uin", p.getString(k));
          com.tencent.mm.plugin.report.e.vIY.setUin(k);
          if (getClass().getClassLoader() != null) {
            break label2951;
          }
          i = -1;
          label2615:
          if (Thread.currentThread().getContextClassLoader() != null) {
            break label2965;
          }
        }
        for (j = -1;; j = Thread.currentThread().getContextClassLoader().hashCode())
        {
          ad.i("MMKernel.CoreAccount", "SmcLogic.setUin, class loader %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          this.gcc = new com.tencent.mm.model.a();
          ad.i("MMKernel.CoreAccount", "setAccUin done :%s", new Object[] { p.getString(k) });
          ??? = new gt();
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)???);
          g.afC();
          if (g.afA().gcy == null) {
            break;
          }
          g.afC();
          if (g.afA().gcy.gVH == null) {
            break;
          }
          g.afC();
          g.afA().gcy.gVH.ej(true);
          g.afC();
          ??? = g.afA().gcy.gVH.avg();
          if ((k == 0) || (??? == null) || (k == ((com.tencent.mm.network.c)???).getUin())) {
            break;
          }
          ad.w("MMKernel.CoreAccount", "summerauth update acc info with acc stg: old acc uin=%d, this uin=%d", new Object[] { Integer.valueOf(((com.tencent.mm.network.c)???).getUin()), Integer.valueOf(k) });
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 46L, 1L, false);
          ((com.tencent.mm.network.c)???).setUin(k);
          break;
          if ((m > 570425344) && (j <= 570425344))
          {
            paramBoolean = true;
            break label2113;
          }
          if ((m <= 570556456) || (j > 570556456)) {
            break label2978;
          }
          paramBoolean = true;
          break label2113;
          bool1 = false;
          break label2153;
          label2896:
          ((e)???).gdc.set(274480, Boolean.FALSE);
          ad.i("MMKernel.CoreStorage", "[initialize] need not init emoji");
          break label2189;
          label2922:
          i = 0;
          break label2222;
          label2927:
          ad.d("MMKernel.CoreStorage", "lock show_whatsnew from else.");
          an.aFx("show_whatsnew");
          break label2470;
          paramBoolean = false;
          break label2487;
          i = getClass().getClassLoader().hashCode();
          break label2615;
        }
        paramBoolean = false;
      }
    }
  }
  
  public final void initialize()
  {
    AppMethodBeat.i(132038);
    if (aeI())
    {
      AppMethodBeat.o(132038);
      return;
    }
    synchronized (this.gbX)
    {
      if (aeI())
      {
        AppMethodBeat.o(132038);
        return;
      }
      int i = b.a(gbY);
      if (i != 0)
      {
        this.gcl = SystemClock.elapsedRealtime();
        ad.w("MMKernel.CoreAccount", "auto set up account storage uin: %d, stack: %s", new Object[] { Integer.valueOf(i), com.tencent.mm.sdk.platformtools.bt.eGN() });
        dy(false);
      }
      AppMethodBeat.o(132038);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(132037);
    synchronized (this.gbX)
    {
      aex();
      AppMethodBeat.o(132037);
      return;
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(132007);
      gcr = new a("NotReady", 0);
      gcs = new a("AccountHasReady", 1);
      gct = new a[] { gcr, gcs };
      AppMethodBeat.o(132007);
    }
    
    private a() {}
  }
  
  static final class b
  {
    private static boolean gcw = true;
    private boolean gcu = false;
    private aa gcv;
    private int uin = 0;
    
    private static void a(aa paramaa, int paramInt)
    {
      AppMethodBeat.i(132011);
      ad.i("MMKernel.CoreAccount", "setSysUin uin: %d, stack: %s", new Object[] { Integer.valueOf(paramInt), com.tencent.mm.sdk.platformtools.bt.eGN() });
      if (!aj.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.XN()).edit().putInt("default_uin", paramInt).commit())
      {
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 150L, 1L, false);
        ad.e("MMKernel.CoreAccount", "uin_sp save fail");
      }
      paramaa.set(1, Integer.valueOf(paramInt));
      paramaa.eKx();
      AppMethodBeat.o(132011);
    }
    
    /* Error */
    private void aeO()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc 143
      //   6: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: getfield 145	com/tencent/mm/kernel/a$b:gcv	Lcom/tencent/mm/storage/aa;
      //   13: invokestatic 151	junit/framework/Assert:assertNotNull	(Ljava/lang/Object;)V
      //   16: aload_0
      //   17: getfield 145	com/tencent/mm/kernel/a$b:gcv	Lcom/tencent/mm/storage/aa;
      //   20: astore 5
      //   22: aload 5
      //   24: ifnonnull +23 -> 47
      //   27: ldc 51
      //   29: ldc 153
      //   31: invokestatic 156	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
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
      //   50: invokevirtual 160	com/tencent/mm/storage/aa:get	(I)Ljava/lang/Object;
      //   53: checkcast 55	java/lang/Integer
      //   56: astore_3
      //   57: aload_3
      //   58: astore_2
      //   59: aload_3
      //   60: ifnonnull +140 -> 200
      //   63: aload 5
      //   65: getfield 163	com/tencent/mm/storage/aa:Ffl	Z
      //   68: ifeq +17 -> 85
      //   71: getstatic 113	com/tencent/mm/plugin/report/e:vIY	Lcom/tencent/mm/plugin/report/e;
      //   74: ldc2_w 114
      //   77: ldc2_w 164
      //   80: lconst_1
      //   81: iconst_0
      //   82: invokevirtual 121	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
      //   85: invokestatic 141	com/tencent/mm/kernel/a$b:aeP	()I
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
      //   121: getfield 163	com/tencent/mm/storage/aa:Ffl	Z
      //   124: invokestatic 172	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   127: aastore
      //   128: invokestatic 70	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   131: getstatic 18	com/tencent/mm/kernel/a$b:gcw	Z
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
      //   152: invokestatic 65	com/tencent/mm/sdk/platformtools/bt:eGN	()Lcom/tencent/mm/sdk/platformtools/at;
      //   155: aastore
      //   156: invokestatic 176	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   159: getstatic 113	com/tencent/mm/plugin/report/e:vIY	Lcom/tencent/mm/plugin/report/e;
      //   162: sipush 11911
      //   165: iconst_1
      //   166: anewarray 4	java/lang/Object
      //   169: dup
      //   170: iconst_0
      //   171: aload 4
      //   173: invokestatic 180	com/tencent/mm/sdk/platformtools/bt:l	(Ljava/lang/Integer;)I
      //   176: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   179: aastore
      //   180: invokevirtual 184	com/tencent/mm/plugin/report/e:f	(I[Ljava/lang/Object;)V
      //   183: iconst_0
      //   184: putstatic 18	com/tencent/mm/kernel/a$b:gcw	Z
      //   187: aload 5
      //   189: aload 4
      //   191: invokevirtual 187	java/lang/Integer:intValue	()I
      //   194: invokestatic 189	com/tencent/mm/kernel/a$b:a	(Lcom/tencent/mm/storage/aa;I)V
      //   197: aload 4
      //   199: astore_2
      //   200: ldc 51
      //   202: ldc 191
      //   204: iconst_1
      //   205: anewarray 4	java/lang/Object
      //   208: dup
      //   209: iconst_0
      //   210: aload_2
      //   211: invokestatic 180	com/tencent/mm/sdk/platformtools/bt:l	(Ljava/lang/Integer;)I
      //   214: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   217: aastore
      //   218: invokestatic 70	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   221: aload_2
      //   222: invokestatic 180	com/tencent/mm/sdk/platformtools/bt:l	(Ljava/lang/Integer;)I
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
      //   20	168	5	localaa	aa
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
    
    private static int aeP()
    {
      AppMethodBeat.i(192868);
      int i = aj.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.XN()).getInt("default_uin", 0);
      AppMethodBeat.o(192868);
      return i;
    }
    
    private int getUin()
    {
      try
      {
        AppMethodBeat.i(132008);
        if (!this.gcu)
        {
          aeO();
          this.gcu = true;
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
        ad.i("MMKernel.CoreAccount", "Uin From %s To %s hash:%d thread:%d[%s] stack:%s", new Object[] { p.getString(this.uin), p.getString(paramInt), Integer.valueOf(i.cf(paramInt, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), com.tencent.mm.sdk.platformtools.bt.eGN() });
        Assert.assertNotNull(this.gcv);
        a(this.gcv, paramInt);
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
    
    public final void a(aa paramaa)
    {
      try
      {
        this.gcv = paramaa;
        return;
      }
      finally
      {
        paramaa = finally;
        throw paramaa;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a
 * JD-Core Version:    0.7.0.1
 */