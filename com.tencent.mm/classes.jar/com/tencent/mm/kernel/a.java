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
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bd;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storage.cj;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.e.a;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.u;
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
  private static boolean gCS;
  private static boolean gCT;
  static b gCV;
  private static String gCW;
  private static String gCX;
  private static boolean gCY;
  private static int gDh;
  private com.tencent.mm.kernel.api.c gCQ;
  private z gCR;
  byte[] gCU;
  public com.tencent.mm.model.a gCZ;
  public e.c gDa;
  public int gDb;
  public boolean gDc;
  private boolean gDd;
  public int gDe;
  public int gDf;
  private List<ay> gDg;
  long gDi;
  private volatile a gDj;
  public volatile boolean gDk;
  private String gDl;
  private Map<String, Integer> gDm;
  
  static
  {
    AppMethodBeat.i(132045);
    gCS = true;
    gCT = false;
    gCV = new b();
    gCW = "NoResetUinStack";
    gCX = null;
    gDh = -1;
    AppMethodBeat.o(132045);
  }
  
  public a(com.tencent.mm.kernel.api.c paramc)
  {
    AppMethodBeat.i(132014);
    this.gCU = new byte[0];
    this.gDc = false;
    this.gDd = false;
    this.gDe = 0;
    this.gDg = new LinkedList();
    this.gDj = a.gDo;
    this.gDk = false;
    this.gDl = "";
    this.gDm = new HashMap();
    Assert.assertNotNull(gCV);
    g.ajS();
    boolean bool;
    if (bu.o((Integer)g.ajR().gDO.get(17)) != 0)
    {
      bool = true;
      gCS = bool;
      if (!f.FFQ) {
        break label144;
      }
    }
    label144:
    for (int i = 763;; i = 702)
    {
      com.tencent.mm.protocal.j.e.a.FGm = new bd(i);
      this.gCQ = paramc;
      AppMethodBeat.o(132014);
      return;
      bool = false;
      break;
    }
  }
  
  public static SharedPreferences abL()
  {
    AppMethodBeat.i(132035);
    SharedPreferences localSharedPreferences = ak.getContext().getSharedPreferences("notify_key_pref_settings", com.tencent.mm.compatible.util.g.abv());
    AppMethodBeat.o(132035);
    return localSharedPreferences;
  }
  
  public static String aiF()
  {
    AppMethodBeat.i(132016);
    String str = new p(b.a(gCV)).toString();
    AppMethodBeat.o(132016);
    return str;
  }
  
  public static final int aiG()
  {
    AppMethodBeat.i(193544);
    int i = b.access$100();
    AppMethodBeat.o(193544);
    return i;
  }
  
  public static String aiH()
  {
    return gCX;
  }
  
  public static boolean aiI()
  {
    return gCY;
  }
  
  public static void aiJ()
  {
    gCY = true;
  }
  
  public static String aiK()
  {
    return gCW;
  }
  
  protected static void aiL()
  {
    AppMethodBeat.i(132017);
    b.a(gCV, 0);
    AppMethodBeat.o(132017);
  }
  
  protected static void aiM()
  {
    AppMethodBeat.i(132018);
    b.a(gCV, 0);
    AppMethodBeat.o(132018);
  }
  
  private void aiN()
  {
    AppMethodBeat.i(132019);
    this.gDj = a.gDo;
    this.gDk = false;
    ae.i("MMKernel.CoreAccount", "mAccountStatus to NotReady");
    ak.getContext().getSharedPreferences(ak.fow(), 0).edit().putBoolean("isLogin", false).commit();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
    ae.w("MMKernel.CoreAccount", "[arthurdan.AccountNR] account storage reset! uin:%d, resetStack is:%s, resetTime:%s", new Object[] { Integer.valueOf(b.a(gCV)), gCW, localSimpleDateFormat.format(new Date()) });
    AppMethodBeat.o(132019);
  }
  
  public static boolean aiS()
  {
    return gCT;
  }
  
  public static boolean aiT()
  {
    AppMethodBeat.i(132025);
    if (gCS)
    {
      g.ajS();
      if (g.ajP() == null) {
        break label80;
      }
      g.ajS();
      g.ajP();
    }
    label80:
    for (String str = p.getString(b.a(gCV));; str = "-1")
    {
      ae.w("MMKernel.CoreAccount", "account holded :%s init:%b", new Object[] { str, Boolean.valueOf(g.ajP().aiZ()) });
      boolean bool = gCS;
      AppMethodBeat.o(132025);
      return bool;
    }
  }
  
  public static int aiW()
  {
    AppMethodBeat.i(132034);
    int i = abL().getInt("notification.user.state", 0);
    AppMethodBeat.o(132034);
    return i;
  }
  
  public static boolean aiY()
  {
    AppMethodBeat.i(132039);
    if (b.a(gCV) != 0)
    {
      AppMethodBeat.o(132039);
      return true;
    }
    AppMethodBeat.o(132039);
    return false;
  }
  
  public static int ajc()
  {
    AppMethodBeat.i(132041);
    int i = ak.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.abv()).getInt("default_uin", 0);
    AppMethodBeat.o(132041);
    return i;
  }
  
  public static String ajd()
  {
    AppMethodBeat.i(132042);
    g.ajS();
    if (bu.isNullOrNil(g.ajP().gDl)) {
      aje();
    }
    g.ajS();
    String str = g.ajP().gDl;
    AppMethodBeat.o(132042);
    return str;
  }
  
  public static void aje()
  {
    AppMethodBeat.i(132043);
    g.ajS();
    g.ajP().gDl = (com.tencent.mm.compatible.deviceinfo.q.aaH() + "_" + System.currentTimeMillis());
    g.ajS();
    g.ajP().gDm.clear();
    AppMethodBeat.o(132043);
  }
  
  public static void dC(boolean paramBoolean)
  {
    gCT = paramBoolean;
  }
  
  public static int getUin()
  {
    AppMethodBeat.i(132015);
    int i = b.a(gCV);
    AppMethodBeat.o(132015);
    return i;
  }
  
  public static void hold()
  {
    AppMethodBeat.i(132026);
    g.ajS();
    if (g.ajP() != null)
    {
      g.ajS();
      g.ajP();
    }
    for (String str = p.getString(b.a(gCV));; str = "-1")
    {
      ae.w("MMKernel.CoreAccount", " HOLD ACCOUNT! uin:%s stack:%s init:%b", new Object[] { str, bu.fpN(), Boolean.valueOf(g.ajP().aiZ()) });
      gCS = true;
      g.ajS();
      g.ajR().gDO.set(17, Integer.valueOf(1));
      AppMethodBeat.o(132026);
      return;
    }
  }
  
  static boolean mO(int paramInt)
  {
    return paramInt != 0;
  }
  
  public static void mP(int paramInt)
  {
    AppMethodBeat.i(132033);
    if ((gDh != -1) && (gDh == paramInt))
    {
      AppMethodBeat.o(132033);
      return;
    }
    gDh = paramInt;
    abL().edit().putInt("notification.user.state", paramInt).commit();
    ae.i("MMKernel.CoreAccount", "[NOTIFICATION SETTINGS]save UserStatus: %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(132033);
  }
  
  public static boolean mQ(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static void unhold()
  {
    AppMethodBeat.i(132027);
    g.ajS();
    if (g.ajP() != null)
    {
      g.ajS();
      g.ajP();
    }
    for (String str = p.getString(b.a(gCV));; str = "-1")
    {
      ae.w("MMKernel.CoreAccount", " UN HOLD ACCOUNT! uin:%s init:%b", new Object[] { str, Boolean.valueOf(g.ajP().aiZ()) });
      gCS = false;
      g.ajS();
      g.ajR().gDO.set(17, Integer.valueOf(0));
      AppMethodBeat.o(132027);
      return;
    }
  }
  
  public static void xA(String paramString)
  {
    gCW = paramString;
  }
  
  public static int xB(String paramString)
  {
    AppMethodBeat.i(132044);
    g.ajS();
    if (g.ajP().gDm.get(paramString) == null) {}
    int j;
    for (int i = 0;; i = ((Integer)g.ajP().gDm.get(paramString)).intValue())
    {
      j = (int)bu.aRi();
      if (i != 0) {
        break;
      }
      g.ajS();
      g.ajP().gDm.put(paramString, Integer.valueOf(j));
      AppMethodBeat.o(132044);
      return i;
      g.ajS();
    }
    i = j - i;
    g.ajS();
    g.ajP().gDm.put(paramString, Integer.valueOf(j));
    if (i >= 0)
    {
      AppMethodBeat.o(132044);
      return i;
    }
    AppMethodBeat.o(132044);
    return 0;
  }
  
  public static String xz(String paramString)
  {
    gCX = paramString;
    return paramString;
  }
  
  public final void a(ay paramay)
  {
    AppMethodBeat.i(132029);
    ae.i("MMKernel.CoreAccount", "UserStatusChange: add %s", new Object[] { paramay });
    synchronized (this.gDg)
    {
      if (!this.gDg.contains(paramay)) {
        this.gDg.add(paramay);
      }
      AppMethodBeat.o(132029);
      return;
    }
  }
  
  final void aiO()
  {
    AppMethodBeat.i(132020);
    ae.w("MMKernel.CoreAccount", "account storage release  uin:%s thread:%s stack:%s", new Object[] { p.getString(b.a(gCV)), Thread.currentThread().getName(), bu.fpN() });
    if (!aiZ())
    {
      ae.i("MMKernel.CoreAccount", "Fatal crash error!!! status is not initialized when release(), this callStack is:%s, last reset stack is:%s", new Object[] { bu.fpN().toString(), gCW });
      AppMethodBeat.o(132020);
      return;
    }
    this.gCQ.onAccountRelease();
    g.ajS();
    g.ajR().uv(null);
    aiN();
    g.ajS();
    g.ajR().gEf.clear();
    AppMethodBeat.o(132020);
  }
  
  public final void aiP()
  {
    AppMethodBeat.i(132022);
    if (!this.gDd)
    {
      ae.i("MMKernel.CoreAccount", "no need do account initialized notify.");
      AppMethodBeat.o(132022);
      return;
    }
    this.gDd = false;
    ae.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized tid:%d, stack[%s]", new Object[] { Long.valueOf(Thread.currentThread().getId()), bu.fpN() });
    long l = System.currentTimeMillis();
    this.gCQ.onAccountInitialized(this.gDa);
    ae.i("MMKernel.CoreAccount", "summerasyncinit onAccountInitialized run tid[%d] take[%d]ms", new Object[] { Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - l) });
    aiQ();
    AppMethodBeat.o(132022);
  }
  
  public final void aiQ()
  {
    AppMethodBeat.i(132023);
    if ((aiZ()) && (com.tencent.mm.kernel.a.c.ake().gFm))
    {
      ae.i("MMKernel.CoreAccount", "Flush client version.");
      g.ajR().ajs();
    }
    AppMethodBeat.o(132023);
  }
  
  public final z aiR()
  {
    try
    {
      AppMethodBeat.i(132024);
      if (this.gCR == null) {
        this.gCR = new z();
      }
      z localz = this.gCR;
      AppMethodBeat.o(132024);
      return localz;
    }
    finally {}
  }
  
  public final void aiU()
  {
    AppMethodBeat.i(132028);
    if (!aiZ())
    {
      com.tencent.mm.model.b localb = new com.tencent.mm.model.b();
      AppMethodBeat.o(132028);
      throw localb;
    }
    AppMethodBeat.o(132028);
  }
  
  public final void aiV()
  {
    AppMethodBeat.i(132031);
    new aq(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132002);
        ay[] arrayOfay = new ay[a.b(a.this).size()];
        a.b(a.this).toArray(arrayOfay);
        int j = arrayOfay.length;
        int i = 0;
        while (i < j)
        {
          arrayOfay[i].aBX();
          i += 1;
        }
        AppMethodBeat.o(132002);
      }
    });
    AppMethodBeat.o(132031);
  }
  
  public final boolean aiX()
  {
    AppMethodBeat.i(132036);
    boolean bool = mQ(this.gDe);
    AppMethodBeat.o(132036);
    return bool;
  }
  
  public final boolean aiZ()
  {
    return this.gDj == a.gDp;
  }
  
  public final boolean aja()
  {
    return this.gDk;
  }
  
  public final void ajb()
  {
    AppMethodBeat.i(132040);
    ae.i("MMKernel.CoreAccount", "summerasyncinit setInitializedNotifyAllDone[%b] to true stack[%s]", new Object[] { Boolean.valueOf(this.gDk), bu.fpN() });
    this.gDk = true;
    long l = SystemClock.elapsedRealtime();
    ae.i("MMKernel.CoreAccount", "summerhardcoder setInitializedNotifyAllDone [%d %d] take[%d]ms, stack[%s]", new Object[] { Long.valueOf(this.gDi), Long.valueOf(l), Long.valueOf(l - this.gDi), bu.fpN() });
    com.tencent.mm.g.a.cl localcl = new com.tencent.mm.g.a.cl();
    com.tencent.mm.sdk.b.a.IvT.l(localcl);
    AppMethodBeat.o(132040);
  }
  
  public final void b(ay paramay)
  {
    AppMethodBeat.i(132030);
    ae.i("MMKernel.CoreAccount", "UserStatusChange: remove %s", new Object[] { paramay });
    synchronized (this.gDg)
    {
      this.gDg.remove(paramay);
      AppMethodBeat.o(132030);
      return;
    }
  }
  
  public final void cO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132032);
    if ((this.gDe != paramInt1) || (this.gDf != paramInt2)) {}
    for (int i = 1;; i = 0)
    {
      ae.d("MMKernel.CoreAccount", "online status, %d, %d, %d ,%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.gDf), Integer.valueOf(this.gDe) });
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(132032);
      return;
    }
    this.gDe = paramInt1;
    this.gDf = paramInt2;
    new aq(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132003);
        a.this.aiV();
        AppMethodBeat.o(132003);
      }
    });
    AppMethodBeat.o(132032);
  }
  
  final void dB(boolean paramBoolean)
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
        i = g.ajU().foN();
        this.gDb = WXHardCoderJNI.startPerformance(bool1, j, k, m, i, WXHardCoderJNI.hcBootTimeout, 101, WXHardCoderJNI.hcBootAction, "MMKernel.CoreAccount");
        ae.i("MMKernel.CoreAccount", "summerhardcoder startPerformance[%s] stack[%s]", new Object[] { Integer.valueOf(this.gDb), bu.fpN() });
      }
    }
    else
    {
      ae.i("MMKernel.CoreAccount", "UserStatusChange: clear");
    }
    for (;;)
    {
      synchronized (this.gDg)
      {
        this.gDg.clear();
        long l1 = System.currentTimeMillis();
        k = b.a(gCV);
        ae.i("MMKernel.CoreAccount", "dkacc setAccuin %s hash:%d thread:%d[%s] stack:%s", new Object[] { p.getString(k), Integer.valueOf(i.cf(k, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), bu.fpN() });
        if (k != 0)
        {
          i = 1;
          if (i != 0) {
            break;
          }
          ae.w("MMKernel.CoreAccount", "setAccUin, Reset by MMCore.resetAccUin");
          ae.i("MMKernel.CoreAccount", "start time check setUinImpl end total time %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
          ae.i("MMKernel.CoreAccount", "mAccountStatus to AccountHasReady");
          AppMethodBeat.o(132021);
          return;
          i = 0;
        }
      }
      i = 0;
    }
    p.getString(k);
    com.tencent.mm.sdk.a.b.fnC();
    g.ajS();
    e locale = g.ajR();
    Object localObject5 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132001);
        a.a(a.this);
        AppMethodBeat.o(132001);
      }
    };
    ak.getContext().getSharedPreferences(ak.fow(), 0).edit().putBoolean("isLogin", true).apply();
    ??? = com.tencent.mm.b.g.getMessageDigest("mm".concat(String.valueOf(k)).getBytes());
    Object localObject3 = e.C(k, (String)???);
    ae.i("MMKernel.CoreStorage", "uinPath: %s, uinSaltPath: %s", new Object[] { ???, localObject3 });
    boolean bool4 = com.tencent.mm.compatible.util.e.abo();
    label411:
    Object localObject4;
    label461:
    long l2;
    label513:
    Object localObject6;
    if (localObject3 == null)
    {
      ae.w("MMKernel.CoreStorage", "Cannot generate account path, skip account renaming!");
      i = 6;
      bool1 = false;
      locale.gDU = ((String)???);
      locale.cachePath = (am.IKh + locale.gDU + '/');
      if (!bool1) {
        break label1200;
      }
      localObject4 = localObject3;
      locale.gDW = ((String)localObject4);
      locale.gDT = (locale.gDS + locale.gDW + '/');
      if (localObject3 != null) {
        break label1207;
      }
      localObject4 = ???;
      locale.gDV = ((String)localObject4);
      u.agD(i);
      localObject4 = new k(locale.cachePath);
      ae.i("MMKernel.CoreStorage", "dkacc cachePath:" + locale.cachePath + " accPath:" + locale.gDT);
      if (((k)localObject4).exists()) {
        break label2982;
      }
      ae.w("MMKernel.CoreStorage", "setUin REBUILD data now ! DO NOT FUCKING TELL ME DB BROKEN !!! uin:%s data:%s sd:%s", new Object[] { p.getString(k), locale.cachePath, locale.gDT });
      ((k)localObject4).mkdirs();
      if (!locale.cachePath.equalsIgnoreCase(locale.gDT))
      {
        l2 = System.currentTimeMillis();
        localObject4 = new k(locale.gDT);
        localObject6 = (String)??? + "temp" + System.currentTimeMillis();
        localObject6 = com.tencent.mm.loader.j.b.asj() + (String)localObject6;
        ((k)localObject4).ag(new k((String)localObject6));
        ae.i("MMKernel.CoreStorage", "find the old files and rename then %s" + (System.currentTimeMillis() - l2), new Object[] { localObject6 });
      }
    }
    label2188:
    label2469:
    label2982:
    for (boolean bool2 = true;; bool2 = false)
    {
      locale.gEe = new com.tencent.mm.model.cl(locale.cachePath, bool2);
      locale.ajt();
      localObject4 = locale.cachePath + "MicroMsg.db";
      localObject6 = locale.cachePath + "EnMicroMsg.db";
      String str = locale.cachePath + "EnMicroMsg2.db";
      locale.uv(null);
      locale.xE((String)localObject6);
      locale.gDX = new h(new e.2(locale));
      Object localObject7 = locale.gDX;
      l2 = k;
      com.tencent.mm.compatible.deviceinfo.q.cH(true);
      if (!((h)localObject7).b((String)localObject4, (String)localObject6, str, l2, e.getBaseDBFactories(), true))
      {
        ??? = new SQLiteException("main db init failed");
        AppMethodBeat.o(132021);
        throw ((Throwable)???);
        if ((!locale.gDS.startsWith(com.tencent.mm.loader.j.b.asd())) || (!bool4))
        {
          ae.w("MMKernel.CoreStorage", "SDCard not available, skip account renaming!");
          i = 1;
          bool1 = false;
          break label411;
        }
        localObject4 = new k(locale.gDS + (String)???);
        localObject6 = new k(locale.gDS + (String)localObject3);
        if (((k)localObject4).isDirectory())
        {
          if (((k)localObject6).isDirectory())
          {
            ae.i("MMKernel.CoreStorage", "Both uinPath exists, migration shall be taken.");
            i = 2;
            bool1 = true;
            break label411;
          }
          ((k)localObject6).delete();
          ae.i("MMKernel.CoreStorage", "Move account directory: %s => %s", new Object[] { localObject4, localObject6 });
          if (!((k)localObject4).ag((k)localObject6))
          {
            ae.w("MMKernel.CoreStorage", "Failed to move uinPath, use old accPath");
            i = 4;
            bool1 = false;
            break label411;
          }
          ae.i("MMKernel.CoreStorage", "Moved to new uinPath");
          i = 3;
          bool1 = true;
          break label411;
        }
        if (!((k)localObject6).isDirectory()) {
          ((k)localObject6).delete();
        }
        ((k)localObject6).mkdirs();
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
      localObject7 = locale.gDX.JjM;
      if (!bu.isNullOrNil((String)localObject7))
      {
        ae.e("MMKernel.CoreStorage", "dbinit failed :".concat(String.valueOf(localObject7)));
        com.tencent.mm.sdk.a.b.O("init db Failed: [ " + (String)localObject7 + "]", "DBinit");
      }
      localObject7 = locale.gDX;
      if (((h)localObject7).JjJ != null) {}
      for (boolean bool3 = ((h)localObject7).JjJ.Jjd;; bool3 = false)
      {
        if (bool3) {
          locale.gEd = true;
        }
        locale.gDZ = new aj(locale.gDX);
        locale.gEb = new cj(locale.gDX);
        locale.gDX.JjL = new e.3(locale);
        locale.gEc = locale.gEb.fwM();
        locale.gDY = new h(locale.gDR);
        localObject7 = locale.gDY;
        l2 = k;
        com.tencent.mm.compatible.deviceinfo.q.cH(true);
        if (((h)localObject7).b((String)localObject4, (String)localObject6, str, l2, new HashMap(), true)) {
          break;
        }
        ??? = new com.tencent.mm.model.b((byte)0);
        AppMethodBeat.o(132021);
        throw ((Throwable)???);
      }
      locale.gEa = new cd(locale.gDZ);
      locale.gEa.add(new e.4(locale));
      locale.gEa.fwF();
      ((Runnable)localObject5).run();
      if ((bool4) && (locale.gDS.startsWith(com.tencent.mm.loader.j.b.asd())))
      {
        bool3 = true;
        label1533:
        localObject5 = com.tencent.mm.vfs.e.fSU().gEk();
        localObject6 = ((e.a)localObject5).mC("account", (String)???).mC("accountSalt", locale.gDV);
        if (!bool3) {
          break label1959;
        }
        localObject4 = locale.gDV;
        label1576:
        ((e.a)localObject6).mC("accountSd", (String)localObject4);
        if (localObject3 == null) {
          break label1966;
        }
        bool4 = true;
        label1595:
        u.a((e.a)localObject5, bool3, bool4);
        u.a((e.a)localObject5, locale.gDS, bool1);
        ((e.a)localObject5).zo(false);
        ae.i("VFS.Debug", "SetEnv ${account} = ".concat(String.valueOf(???)));
        u.zp(bool1);
        if (bool2)
        {
          l2 = ((Long)locale.gDZ.get(am.a.IRv, Long.valueOf(0L))).longValue();
          i = ((Integer)locale.gDZ.get(am.a.IRw, Integer.valueOf(0))).intValue();
          if (l2 <= 0L) {
            break label1972;
          }
          ae.w("MMKernel.CoreStorage", "summerinstall new install but firsttime[%d] > 0", new Object[] { Long.valueOf(l2) });
          label1724:
          if (i <= 0) {
            break label1992;
          }
          ae.w("MMKernel.CoreStorage", "summerinstall new install but version[%d] > 0", new Object[] { Integer.valueOf(i) });
          label1748:
          ae.i("MMKernel.CoreStorage", "edw setAccUin, summerinstall time[%d]，version[%d], clientversion[%d]", new Object[] { (Long)locale.gDZ.get(am.a.IRv, Long.valueOf(0L)), (Integer)locale.gDZ.get(am.a.IRw, Integer.valueOf(0)), Integer.valueOf(d.FFH) });
        }
        if (paramBoolean) {
          break label2017;
        }
        g.ajS();
        ??? = bu.nullAsNil((String)g.ajR().ajA().get(2, null));
        ae.i("MMKernel.CoreAccount", "summerinit validateUsername username[%s]", new Object[] { ??? });
        if (((String)???).length() > 0) {
          break label2012;
        }
        ae.e("MMKernel.CoreAccount", "username of acc stg not set: uin=" + b.a(gCV));
        aiN();
        b.a(gCV, 0);
        gCW = bu.fpN().toString();
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(132004);
            g.ajS().releaseAll();
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
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(598L, 21L, 1L, true);
        ae.w("MMKernel.CoreAccount", "setAccUin, validateUsername false no need initialize!");
        break;
        bool3 = false;
        break label1533;
        localObject4 = ???;
        break label1576;
        bool4 = false;
        break label1595;
        locale.gDZ.set(am.a.IRv, Long.valueOf(System.currentTimeMillis()));
        break label1724;
        locale.gDZ.set(am.a.IRw, Integer.valueOf(d.FFH));
        break label1748;
      }
      label2017:
      ??? = new cm();
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)???);
      g.ajS();
      ??? = g.ajR();
      localObject3 = new e.c();
      j = bu.o((Integer)((e)???).gDZ.get(14, null));
      m = d.FFH;
      ae.d("MMKernel.CoreStorage", "sVer: %s, cVer: %s.", new Object[] { Integer.toHexString(j), Integer.toHexString(m) });
      if (m == j) {
        paramBoolean = false;
      }
      for (;;)
      {
        label2112:
        if (paramBoolean)
        {
          ((e)???).gDZ.set(8197, "");
          ((e)???).gDZ.set(15, Integer.valueOf(0));
        }
        if (j != m)
        {
          bool1 = true;
          label2152:
          if ((j > 620822536) || (j == m)) {
            break label2895;
          }
          ((e)???).gDZ.set(274480, Boolean.TRUE);
          ae.i("MMKernel.CoreStorage", "[initialize] need init emoji");
          if ((j != 0) && (j < 637599744)) {
            ((e)???).gDZ.set(348162, Boolean.TRUE);
          }
          if (j == m) {
            break label2921;
          }
          i = 1;
          label2221:
          if (i == 0) {
            break label2926;
          }
          ae.w("MMKernel.CoreStorage", "account storage version changed from " + Integer.toHexString(j) + " to " + Integer.toHexString(m) + ", init=" + paramBoolean);
          if (((Integer)((e)???).gDO.get(37, Integer.valueOf(0))).intValue() == 0) {
            ((e)???).gDO.set(37, Integer.valueOf(j));
          }
          ((e)???).gDZ.set(30, Boolean.FALSE);
          ((e)???).gDZ.set(-2046825377, Boolean.FALSE);
          ((e)???).gDZ.set(-2046825369, Boolean.FALSE);
          ((e)???).gDZ.set(54, Boolean.FALSE);
          ((e)???).gDZ.set(-2046825368, Boolean.FALSE);
          ((e)???).gDZ.set(-2046825366, Boolean.TRUE);
          ((e)???).gDZ.set(62, Boolean.TRUE);
          ak.getContext().getSharedPreferences("update_config_prefs", com.tencent.mm.compatible.util.g.abv()).edit().clear().commit();
          if (((j & 0xFFFFFF00) == (m & 0xFFFFFF00)) || (j == 0))
          {
            ae.d("MMKernel.CoreStorage", "lock show_whatsnew from if.");
            ao.aRR("show_whatsnew");
          }
          if (((e)???).gDZ.getInt(am.a.Jcm, -1) <= 0) {
            break label2945;
          }
          paramBoolean = true;
          label2486:
          ae.i("MMKernel.CoreStorage", "unlock show_whatsnew from testWhatsNew, %s.", new Object[] { Boolean.valueOf(paramBoolean) });
          if (paramBoolean) {
            ao.aRS("show_whatsnew");
          }
          ((e.c)localObject3).gEo = bool1;
          ((e.c)localObject3).gEp = j;
          this.gDa = ((e.c)localObject3);
          ae.i("MMKernel.CoreAccount", "check is update :%b ", new Object[] { Boolean.valueOf(((e.c)localObject3).gEo) });
          this.gDd = true;
          if (!this.gDc)
          {
            aiP();
            g.ajP().ajb();
          }
          bb.hIK.aM("last_login_uin", p.getString(k));
          com.tencent.mm.plugin.report.e.ywz.setUin(k);
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
          ae.i("MMKernel.CoreAccount", "SmcLogic.setUin, class loader %s, %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          this.gCZ = new com.tencent.mm.model.a();
          ae.i("MMKernel.CoreAccount", "setAccUin done :%s", new Object[] { p.getString(k) });
          ??? = new gy();
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)???);
          g.ajS();
          if (g.ajQ().gDv == null) {
            break;
          }
          g.ajS();
          if (g.ajQ().gDv.hRo == null) {
            break;
          }
          g.ajS();
          g.ajQ().gDv.hRo.eI(true);
          g.ajS();
          ??? = g.ajQ().gDv.hRo.aFs();
          if ((k == 0) || (??? == null) || (k == ((com.tencent.mm.network.c)???).getUin())) {
            break;
          }
          ae.w("MMKernel.CoreAccount", "summerauth update acc info with acc stg: old acc uin=%d, this uin=%d", new Object[] { Integer.valueOf(((com.tencent.mm.network.c)???).getUin()), Integer.valueOf(k) });
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 46L, 1L, false);
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
          ((e)???).gDZ.set(274480, Boolean.FALSE);
          ae.i("MMKernel.CoreStorage", "[initialize] need not init emoji");
          break label2188;
          label2921:
          i = 0;
          break label2221;
          label2926:
          ae.d("MMKernel.CoreStorage", "lock show_whatsnew from else.");
          ao.aRR("show_whatsnew");
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
    if (aiZ())
    {
      AppMethodBeat.o(132038);
      return;
    }
    synchronized (this.gCU)
    {
      if (aiZ())
      {
        AppMethodBeat.o(132038);
        return;
      }
      int i = b.a(gCV);
      if (i != 0)
      {
        this.gDi = SystemClock.elapsedRealtime();
        ae.w("MMKernel.CoreAccount", "auto set up account storage uin: %d, stack: %s", new Object[] { Integer.valueOf(i), bu.fpN() });
        dB(false);
      }
      AppMethodBeat.o(132038);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(132037);
    synchronized (this.gCU)
    {
      aiO();
      AppMethodBeat.o(132037);
      return;
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(132007);
      gDo = new a("NotReady", 0);
      gDp = new a("AccountHasReady", 1);
      gDq = new a[] { gDo, gDp };
      AppMethodBeat.o(132007);
    }
    
    private a() {}
  }
  
  static final class b
  {
    private static boolean gDt = true;
    private boolean gDr = false;
    private ai gDs;
    private int uin = 0;
    
    private static void a(ai paramai, int paramInt)
    {
      AppMethodBeat.i(132011);
      ae.i("MMKernel.CoreAccount", "setSysUin uin: %d, stack: %s", new Object[] { Integer.valueOf(paramInt), bu.fpN() });
      if (!ak.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.abv()).edit().putInt("default_uin", paramInt).commit())
      {
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 150L, 1L, false);
        ae.e("MMKernel.CoreAccount", "uin_sp save fail");
      }
      paramai.set(1, Integer.valueOf(paramInt));
      paramai.fub();
      AppMethodBeat.o(132011);
    }
    
    /* Error */
    private void ajf()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc 143
      //   6: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: getfield 145	com/tencent/mm/kernel/a$b:gDs	Lcom/tencent/mm/storage/ai;
      //   13: invokestatic 151	junit/framework/Assert:assertNotNull	(Ljava/lang/Object;)V
      //   16: aload_0
      //   17: getfield 145	com/tencent/mm/kernel/a$b:gDs	Lcom/tencent/mm/storage/ai;
      //   20: astore 5
      //   22: aload 5
      //   24: ifnonnull +23 -> 47
      //   27: ldc 51
      //   29: ldc 153
      //   31: invokestatic 156	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
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
      //   50: invokevirtual 160	com/tencent/mm/storage/ai:get	(I)Ljava/lang/Object;
      //   53: checkcast 55	java/lang/Integer
      //   56: astore_3
      //   57: aload_3
      //   58: astore_2
      //   59: aload_3
      //   60: ifnonnull +140 -> 200
      //   63: aload 5
      //   65: getfield 163	com/tencent/mm/storage/ai:IJL	Z
      //   68: ifeq +17 -> 85
      //   71: getstatic 113	com/tencent/mm/plugin/report/e:ywz	Lcom/tencent/mm/plugin/report/e;
      //   74: ldc2_w 114
      //   77: ldc2_w 164
      //   80: lconst_1
      //   81: iconst_0
      //   82: invokevirtual 121	com/tencent/mm/plugin/report/e:idkeyStat	(JJJZ)V
      //   85: invokestatic 141	com/tencent/mm/kernel/a$b:ajg	()I
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
      //   121: getfield 163	com/tencent/mm/storage/ai:IJL	Z
      //   124: invokestatic 172	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   127: aastore
      //   128: invokestatic 70	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   131: getstatic 18	com/tencent/mm/kernel/a$b:gDt	Z
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
      //   152: invokestatic 65	com/tencent/mm/sdk/platformtools/bu:fpN	()Lcom/tencent/mm/sdk/platformtools/au;
      //   155: aastore
      //   156: invokestatic 176	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   159: getstatic 113	com/tencent/mm/plugin/report/e:ywz	Lcom/tencent/mm/plugin/report/e;
      //   162: sipush 11911
      //   165: iconst_1
      //   166: anewarray 4	java/lang/Object
      //   169: dup
      //   170: iconst_0
      //   171: aload 4
      //   173: invokestatic 179	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Integer;)I
      //   176: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   179: aastore
      //   180: invokevirtual 183	com/tencent/mm/plugin/report/e:f	(I[Ljava/lang/Object;)V
      //   183: iconst_0
      //   184: putstatic 18	com/tencent/mm/kernel/a$b:gDt	Z
      //   187: aload 5
      //   189: aload 4
      //   191: invokevirtual 186	java/lang/Integer:intValue	()I
      //   194: invokestatic 188	com/tencent/mm/kernel/a$b:a	(Lcom/tencent/mm/storage/ai;I)V
      //   197: aload 4
      //   199: astore_2
      //   200: ldc 51
      //   202: ldc 190
      //   204: iconst_1
      //   205: anewarray 4	java/lang/Object
      //   208: dup
      //   209: iconst_0
      //   210: aload_2
      //   211: invokestatic 179	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Integer;)I
      //   214: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   217: aastore
      //   218: invokestatic 70	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   221: aload_2
      //   222: invokestatic 179	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Integer;)I
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
      //   20	168	5	localai	ai
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
    
    private static int ajg()
    {
      AppMethodBeat.i(193542);
      int i = ak.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.abv()).getInt("default_uin", 0);
      AppMethodBeat.o(193542);
      return i;
    }
    
    private int getUin()
    {
      try
      {
        AppMethodBeat.i(132008);
        if (!this.gDr)
        {
          ajf();
          this.gDr = true;
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
        ae.i("MMKernel.CoreAccount", "Uin From %s To %s hash:%d thread:%d[%s] stack:%s", new Object[] { p.getString(this.uin), p.getString(paramInt), Integer.valueOf(i.cf(paramInt, 100)), Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName(), bu.fpN() });
        Assert.assertNotNull(this.gDs);
        a(this.gDs, paramInt);
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
    
    public final void a(ai paramai)
    {
      try
      {
        this.gDs = paramai;
        return;
      }
      finally
      {
        paramai = finally;
        throw paramai;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.a
 * JD-Core Version:    0.7.0.1
 */