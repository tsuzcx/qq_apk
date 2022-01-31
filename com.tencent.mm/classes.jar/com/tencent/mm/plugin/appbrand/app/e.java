package com.tencent.mm.plugin.appbrand.app;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.h.a.bu;
import com.tencent.mm.h.a.ix;
import com.tencent.mm.h.a.jf;
import com.tencent.mm.h.a.jt;
import com.tencent.mm.h.a.mv;
import com.tencent.mm.h.a.o;
import com.tencent.mm.h.a.su;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.t.a;
import com.tencent.mm.plugin.appbrand.appcache.ag;
import com.tencent.mm.plugin.appbrand.appcache.ap;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.appusage.r.b;
import com.tencent.mm.plugin.appbrand.appusage.s.a;
import com.tencent.mm.plugin.appbrand.appusage.v.a;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.q.c.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.a;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

public final class e
  implements com.tencent.mm.model.ar
{
  private static volatile com.tencent.mm.plugin.appbrand.appstorage.b fAX;
  private static volatile com.tencent.mm.plugin.appbrand.config.c fAY;
  private static volatile com.tencent.mm.plugin.appbrand.appcache.ar fAZ;
  private static volatile w fBa;
  private static volatile q fBb;
  private static volatile com.tencent.mm.plugin.appbrand.launching.s fBc;
  private static volatile com.tencent.mm.plugin.appbrand.widget.h fBd;
  private static volatile com.tencent.mm.plugin.appbrand.widget.i fBe;
  private static volatile t.a fBf;
  private static volatile com.tencent.mm.plugin.appbrand.widget.m fBg;
  private static volatile com.tencent.mm.ae.a.c fBh;
  private static volatile com.tencent.mm.plugin.appbrand.t.a fBi;
  private static volatile v fBj;
  private static volatile com.tencent.mm.plugin.appbrand.game.a.a.c fBk;
  private static volatile ag fBl;
  private static com.tencent.mm.plugin.appbrand.c.c fBm;
  private static com.tencent.mm.plugin.appbrand.c.b fBn;
  private j.a dYS = new e.31(this);
  private final com.tencent.mm.network.n eiF = new e.25(this);
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.h.a.n> fBA = new e.21(this);
  private final com.tencent.mm.sdk.b.c<bu> fBB = new e.22(this);
  private final com.tencent.mm.sdk.b.c<ix> fBC = new e.24(this);
  private final bx.a fBD = new ap();
  private com.tencent.mm.sdk.b.c fBE = new e.26(this);
  private com.tencent.mm.sdk.b.c fBF = new e.27(this);
  private com.tencent.mm.sdk.b.c fBG = new e.28(this);
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.h.a.k> fBH = new e.29(this);
  private j.a fBI = new j.a()
  {
    public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.l paramAnonymousl)
    {
      int i;
      if ((paramAnonymousl != null) && (!bk.bl(paramAnonymousl.bGt)) && (paramAnonymousl.bGt.equalsIgnoreCase("single")) && (paramAnonymousl.gbI == 5) && (paramAnonymousl.obj != null) && ((paramAnonymousl.obj instanceof s.a)))
      {
        paramAnonymousString = ((s.a)paramAnonymousl.obj).field_username;
        i = ((s.a)paramAnonymousl.obj).field_versionType;
        if (bk.bl(paramAnonymousString)) {
          y.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler.javayhu", "handleStarAppChangeEvent, username is null");
        }
      }
      else
      {
        return;
      }
      y.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler.javayhu", "handleRemoveStarAppEvent, delete star app(%s_v%d)", new Object[] { paramAnonymousString, Integer.valueOf(i) });
      ((com.tencent.mm.plugin.appbrand.backgroundfetch.h)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.backgroundfetch.h.class)).ag(paramAnonymousString, 0);
      ((com.tencent.mm.plugin.appbrand.backgroundfetch.h)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.backgroundfetch.h.class)).ag(paramAnonymousString, 1);
    }
  };
  private final AppBrandGuideUI.a fBJ = new AppBrandGuideUI.a();
  private be.a fBo = new com.tencent.mm.plugin.appbrand.s.a();
  private com.tencent.mm.vending.b.b fBp = null;
  private final com.tencent.mm.plugin.auth.a.a fBq = new e.11(this);
  private final Set<com.tencent.mm.sdk.b.c> fBr = new HashSet();
  private final com.tencent.mm.sdk.b.c<jf> fBs = new e.13(this);
  private final com.tencent.mm.sdk.b.c<su> fBt = new e.14(this);
  private final com.tencent.mm.sdk.b.c<jt> fBu = new e.15(this);
  private final com.tencent.mm.sdk.b.c<mv> fBv = new com.tencent.mm.sdk.b.c() {};
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.h.a.l> fBw = new e.17(this);
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.h.a.p> fBx = new e.18(this);
  private final com.tencent.mm.sdk.b.c<o> fBy = new e.19(this);
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.h.a.k> fBz = new e.20(this);
  
  public e()
  {
    this.fBr.add(this.fBz);
    this.fBr.add(new com.tencent.mm.plugin.appbrand.launching.a());
    this.fBr.add(this.fBA);
    this.fBr.add(this.fBu);
    this.fBr.add(this.fBv);
    this.fBr.add(this.fBt);
    this.fBr.add(new com.tencent.mm.plugin.appbrand.config.f());
    this.fBr.add(this.fBs);
    this.fBr.add(com.tencent.mm.plugin.appbrand.appusage.i.fIi);
    this.fBr.add(this.fBw);
    this.fBr.add(this.fBx);
    this.fBr.add(this.fBy);
    this.fBr.add(this.fBE);
    this.fBr.add(this.fBB);
    this.fBr.add(this.fBC);
    this.fBr.add(this.fBF);
    this.fBr.add(this.fBG);
    this.fBr.add(this.fBH);
  }
  
  public static <T> T G(Class<T> paramClass)
  {
    if (paramClass == w.class) {
      return fBa;
    }
    return a.G(paramClass);
  }
  
  private HashMap<Integer, h.d> aaN()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("AppKVStorageDBCreate".hashCode()), new e.1(this));
    localHashMap.put(Integer.valueOf("AppBrandWxaPkgStorageDBCreate".hashCode()), new e.12(this));
    localHashMap.put(Integer.valueOf("AppBrandCommonConfigStorageCreate".hashCode()), new e.23(this));
    localHashMap.put(Integer.valueOf("AppBrandLayoutStorageCreate".hashCode()), new e.32(this));
    localHashMap.put(Integer.valueOf("AppBrandStarAppStorageCreate".hashCode()), new e.33(this));
    localHashMap.put(Integer.valueOf("WxaAttributesTableCreate".hashCode()), new e.34(this));
    localHashMap.put(Integer.valueOf("LaunchWxaAppInfoCreate".hashCode()), new e.35(this));
    localHashMap.put(Integer.valueOf("DynamicMsgCacheDataCreate".hashCode()), new e.36(this));
    localHashMap.put(Integer.valueOf("LaunchWxaWidgetCacheCreate".hashCode()), new e.37(this));
    localHashMap.put(Integer.valueOf("WxaWidgetInfoStorageCreate".hashCode()), new e.2(this));
    localHashMap.put(Integer.valueOf("WxaUpdateableMsgStorageCreate".hashCode()), new h.d()
    {
      public final String[] rK()
      {
        return com.tencent.mm.ae.a.c.dUb;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandCommonKVBinaryDataStorage".hashCode()), new e.4(this));
    localHashMap.put(Integer.valueOf("PkgUpdateStatsStorage".hashCode()), new e.5(this));
    localHashMap.put(Integer.valueOf("MiniGameInfoStorage".hashCode()), new e.6(this));
    localHashMap.put(Integer.valueOf("AppBrandRecommendWxaStorage".hashCode()), new e.7(this));
    Iterator localIterator = a.fAH.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String[] arrayOfString = (String[])localEntry.getValue();
      localHashMap.put(Integer.valueOf(((a.a)localEntry.getKey()).hashCode()), new e.8(this, arrayOfString));
    }
    return localHashMap;
  }
  
  public static t.a aaO()
  {
    return fBf;
  }
  
  public static e aaP()
  {
    com.tencent.mm.plugin.appbrand.a.b localb = (com.tencent.mm.plugin.appbrand.a.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.appbrand.a.b.class);
    if (localb != null) {
      return ((PluginAppBrand)localb).getCore();
    }
    return null;
  }
  
  public static AppBrandGuideUI.a aaR()
  {
    if (aaP() == null) {
      return null;
    }
    return aaP().fBJ;
  }
  
  public static com.tencent.mm.plugin.appbrand.appstorage.b aaS()
  {
    return fAX;
  }
  
  public static q aaT()
  {
    try
    {
      if (((fBb == null) || (!fBb.ael())) && (fBf != null) && (!fBf.csp())) {
        fBb = new q(fBf);
      }
      return fBb;
    }
    finally {}
  }
  
  public static com.tencent.mm.plugin.appbrand.launching.s aaU()
  {
    return fBc;
  }
  
  public static com.tencent.mm.plugin.appbrand.widget.i aaV()
  {
    return fBe;
  }
  
  public static com.tencent.mm.plugin.appbrand.widget.m aaW()
  {
    return fBg;
  }
  
  public static com.tencent.mm.ae.a.c aaX()
  {
    return fBh;
  }
  
  public static com.tencent.mm.plugin.appbrand.config.c aaY()
  {
    if ((fAY == null) && (fBf != null) && (!fBf.csp())) {
      fAY = new com.tencent.mm.plugin.appbrand.config.c(fBf);
    }
    return fAY;
  }
  
  public static w aaZ()
  {
    return fBa;
  }
  
  @Deprecated
  public static com.tencent.mm.plugin.appbrand.appusage.s aba()
  {
    return (com.tencent.mm.plugin.appbrand.appusage.s)G(com.tencent.mm.plugin.appbrand.appusage.s.class);
  }
  
  public static com.tencent.mm.plugin.appbrand.appcache.ar abb()
  {
    return fAZ;
  }
  
  public static com.tencent.mm.plugin.appbrand.widget.h abc()
  {
    return fBd;
  }
  
  public static com.tencent.mm.plugin.appbrand.c.c abd()
  {
    if (fBm == null) {
      fBm = new com.tencent.mm.plugin.appbrand.c.c();
    }
    return fBm;
  }
  
  public static com.tencent.mm.plugin.appbrand.c.b abe()
  {
    if (fBn == null) {
      fBn = new com.tencent.mm.plugin.appbrand.c.b();
    }
    return fBn;
  }
  
  public static com.tencent.mm.plugin.appbrand.t.a abf()
  {
    return fBi;
  }
  
  public static v abg()
  {
    return fBj;
  }
  
  public static com.tencent.mm.plugin.appbrand.game.a.a.c abh()
  {
    return fBk;
  }
  
  public static ag abi()
  {
    return fBl;
  }
  
  public static com.tencent.mm.plugin.appbrand.backgroundfetch.d abj()
  {
    return (com.tencent.mm.plugin.appbrand.backgroundfetch.d)G(com.tencent.mm.plugin.appbrand.backgroundfetch.d.class);
  }
  
  public final t.a aaQ()
  {
    Object localObject = com.tencent.mm.kernel.g.DP().cachePath + "AppBrandComm.db";
    if ((fBf != null) && (((String)localObject).equals(fBf.getPath()))) {
      return fBf;
    }
    localObject = t.a(hashCode(), (String)localObject, aaN(), true);
    fBf = (t.a)localObject;
    return localObject;
  }
  
  public final void bh(boolean paramBoolean)
  {
    y.d("MicroMsg.SubCoreAppBrand", "onAccountPostReset updated %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.fBp = ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(this.fBq);
    Object localObject2 = ae.getContext().getSharedPreferences("app_brand_global_sp", 0);
    if (localObject2 != null)
    {
      localObject1 = ((SharedPreferences)localObject2).getStringSet("uin_set", new HashSet());
      if (localObject1 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.DN();
        if (((Set)localObject1).add(com.tencent.mm.kernel.a.CK()))
        {
          localObject2 = ((SharedPreferences)localObject2).edit();
          ((SharedPreferences.Editor)localObject2).remove("uin_set");
          ((SharedPreferences.Editor)localObject2).commit();
          ((SharedPreferences.Editor)localObject2).putStringSet("uin_set", (Set)localObject1);
          ((SharedPreferences.Editor)localObject2).commit();
        }
      }
    }
    Object localObject1 = this.fBr.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.sdk.b.c)((Iterator)localObject1).next()).cqo();
    }
    localObject1 = ap.fEo.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a((String)localObject2, this.fBD, true);
    }
    r.b.adn();
    v.a.adn();
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().c(this.fBo);
    aaQ();
    fAX = new com.tencent.mm.plugin.appbrand.appstorage.b(fBf);
    fAY = new com.tencent.mm.plugin.appbrand.config.c(fBf);
    fAZ = new com.tencent.mm.plugin.appbrand.appcache.ar(fBf);
    fBa = new w(fBf);
    fBc = new com.tencent.mm.plugin.appbrand.launching.s(fBf);
    fBd = new com.tencent.mm.plugin.appbrand.widget.h(fBf);
    fBe = new com.tencent.mm.plugin.appbrand.widget.i(fBf);
    fBg = new com.tencent.mm.plugin.appbrand.widget.m(fBf);
    fBh = new com.tencent.mm.ae.a.c(fBf);
    fBi = new com.tencent.mm.plugin.appbrand.t.a(fBf);
    fBj = new v(fBf);
    fBk = new com.tencent.mm.plugin.appbrand.game.a.a.c(fBf);
    fBl = new ag();
    aaT();
    a.a(fBf);
    com.tencent.mm.plugin.appbrand.h.setup();
    r.aem();
    c.a.haI.prepare();
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a()
    {
      public final boolean execute()
      {
        Object localObject = new com.tencent.mm.plugin.appbrand.g.c();
        ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class)).registerIndexStorage((com.tencent.mm.plugin.fts.a.i)localObject);
        ((com.tencent.mm.plugin.fts.a.i)localObject).create();
        localObject = new com.tencent.mm.plugin.appbrand.g.b();
        ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class)).registerNativeLogic(7, (com.tencent.mm.plugin.fts.a.k)localObject);
        ((com.tencent.mm.plugin.fts.a.k)localObject).create();
        localObject = new com.tencent.mm.plugin.appbrand.g.g();
        ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
        localObject = new com.tencent.mm.plugin.appbrand.g.e();
        ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
        return true;
      }
      
      public final String getName()
      {
        return "InitFTSWeAppPluginTask";
      }
    });
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon().a(-86016, new e.10(this));
    com.tencent.mm.kernel.g.DO().a(this.eiF);
    com.tencent.mm.plugin.appbrand.dynamic.g.initialize();
    com.tencent.mm.model.c.c.IX().c(this.dYS);
    if (aba() != null) {
      aba().c(this.fBI);
    }
    com.tencent.mm.plugin.appbrand.config.g.init();
    localObject1 = this.fBJ;
    AppBrandGuideUI.a.aoU().registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject1);
    AppBrandStickyBannerLogic.b.d((com.tencent.mm.plugin.appbrand.ui.banner.f)localObject1);
    ((AppBrandGuideUI.a)localObject1).hcN = false;
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    y.d("MicroMsg.SubCoreAppBrand", "onAccountRelease");
    if (this.fBp != null)
    {
      this.fBp.dead();
      this.fBp = null;
    }
    Object localObject = this.fBr.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.sdk.b.c)((Iterator)localObject).next()).dead();
    }
    com.tencent.mm.plugin.appbrand.h.release();
    localObject = ap.fEo.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b(str, this.fBD, true);
    }
    r.b.unregister();
    v.a.unregister();
    ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FB().d(this.fBo);
    at.shutdown();
    fAX = null;
    fBb = null;
    fAY = null;
    fAZ = null;
    fBa = null;
    fBc = null;
    fBd = null;
    fBe = null;
    fBg = null;
    fBh = null;
    fBi = null;
    fBj = null;
    fBk = null;
    fBl = null;
    a.aaI();
    if (fBn != null)
    {
      localObject = fBn;
      ((com.tencent.mm.plugin.appbrand.c.b)localObject).fNf.clear();
      ((com.tencent.mm.plugin.appbrand.c.b)localObject).fNg.clear();
      fBn = null;
    }
    fBm = null;
    if (fBf != null)
    {
      fBf.jK(hashCode());
      fBf = null;
    }
    com.tencent.mm.plugin.appbrand.appusage.j.release();
    r.release();
    localObject = com.tencent.mm.plugin.appbrand.appcache.b.b.i.fFt;
    if (((com.tencent.mm.plugin.appbrand.appcache.b.b.i)localObject).fFv != null) {
      ((com.tencent.mm.plugin.appbrand.appcache.b.b.i)localObject).fFv.cKY();
    }
    ((com.tencent.mm.plugin.appbrand.appcache.b.b.i)localObject).fFu = false;
    localObject = c.a.haI;
    y.d("MicroMsg.WxaFTSSearchCore", "reset");
    com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.plugin.appbrand.q.c)localObject).haE);
    com.tencent.mm.sdk.b.a.udP.d(((com.tencent.mm.plugin.appbrand.q.c)localObject).haF);
    ((com.tencent.mm.plugin.appbrand.q.c)localObject).haG.dead();
    com.tencent.mm.plugin.appbrand.v.c.aqp();
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class)).unregisterIndexStorage(512);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class)).unregisterNativeLogic(7);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(144);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(4224);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class)).unregisterIndexStorage(8);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class)).unregisterNativeLogic(10);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(208);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(4240);
    com.tencent.mm.kernel.g.DO().b(this.eiF);
    com.tencent.mm.plugin.appbrand.dynamic.g.release();
    com.tencent.mm.model.c.c.IX().d(this.dYS);
    com.tencent.mm.plugin.appbrand.config.g.release();
    localObject = this.fBJ;
    AppBrandGuideUI.a.aoU().unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject);
    AppBrandStickyBannerLogic.b.c((com.tencent.mm.plugin.appbrand.ui.banner.f)localObject);
    ((AppBrandGuideUI.a)localObject).hcN = false;
    com.tencent.mm.plugin.appbrand.appusage.a.a.release();
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.e
 * JD-Core Version:    0.7.0.1
 */