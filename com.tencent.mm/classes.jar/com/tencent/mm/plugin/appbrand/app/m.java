package com.tencent.mm.plugin.appbrand.app;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.f.a.aad;
import com.tencent.mm.f.a.cl;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.f.a.mi;
import com.tencent.mm.f.a.mr;
import com.tencent.mm.f.a.nh;
import com.tencent.mm.f.a.q;
import com.tencent.mm.f.a.rs;
import com.tencent.mm.f.a.t;
import com.tencent.mm.f.a.zq;
import com.tencent.mm.model.be;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.appcache.ba;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bq;
import com.tencent.mm.plugin.appbrand.appcache.bt;
import com.tencent.mm.plugin.appbrand.appusage.ar;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.appusage.t.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.launching.ai;
import com.tencent.mm.plugin.appbrand.launching.an;
import com.tencent.mm.plugin.appbrand.launching.ap;
import com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.a;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.bw.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

public final class m
  implements be
{
  private static volatile com.tencent.mm.plugin.appbrand.appstorage.d nCN;
  private static volatile com.tencent.mm.plugin.appbrand.config.e nCO;
  private static volatile bm nCP;
  private static volatile bg nCQ;
  private static volatile com.tencent.mm.plugin.appbrand.appusage.x nCR;
  private static volatile z nCS;
  private static volatile ai nCT;
  private static volatile com.tencent.mm.plugin.appbrand.widget.h nCU;
  private static volatile com.tencent.mm.plugin.appbrand.widget.l nCV;
  private static volatile r.a nCW;
  private static volatile com.tencent.mm.plugin.appbrand.widget.r nCX;
  private static volatile com.tencent.mm.aj.b.e nCY;
  private static volatile com.tencent.mm.plugin.appbrand.ab.a nCZ;
  private static volatile ah nDa;
  private static volatile com.tencent.mm.plugin.appbrand.game.b.a.b nDb;
  private static volatile ap nDc;
  private static volatile an nDd;
  private static volatile ba nDe;
  private static volatile bt nDf;
  private static volatile com.tencent.mm.plugin.appbrand.task.a.c nDg;
  private static com.tencent.mm.plugin.appbrand.b.c nDh;
  private static com.tencent.mm.plugin.appbrand.b.b nDi;
  private final com.tencent.mm.network.p lHL;
  private final IListener<mr> logoutListener;
  private MStorage.IOnStorageChange lxt;
  private IListener nDA;
  private final IListener<com.tencent.mm.f.a.l> nDB;
  private final IListener<com.tencent.mm.f.a.u> nDC;
  private final com.tencent.mm.plugin.appbrand.jsapi.audio.o nDD;
  private final AppBrandGuideUI.a nDE;
  private final IListener<fw> nDF;
  private bw.a nDj;
  private com.tencent.mm.vending.b.b nDk;
  private final com.tencent.mm.plugin.auth.a.b nDl;
  private final Set<IListener> nDm;
  private final IListener<aad> nDn;
  private final IListener<nh> nDo;
  private final IListener<rs> nDp;
  private final IListener<com.tencent.mm.f.a.m> nDq;
  private final IListener<t> nDr;
  private final IListener<com.tencent.mm.f.a.r> nDs;
  private final IListener<zq> nDt;
  private final IListener<com.tencent.mm.f.a.l> nDu;
  private final IListener<q> nDv;
  private final IListener<cl> nDw;
  private final IListener<mi> nDx;
  private final ck.a nDy;
  private IListener nDz;
  
  public m()
  {
    AppMethodBeat.i(44202);
    this.nDj = new com.tencent.mm.plugin.appbrand.z.a();
    this.nDk = null;
    this.nDl = new m.15(this);
    this.logoutListener = new m.16(this);
    this.nDn = new m.17(this);
    this.nDo = new m.18(this);
    this.nDp = new m.19(this);
    this.nDq = new m.20(this);
    this.nDr = new m.21(this);
    this.nDs = new m.22(this);
    this.nDt = new IListener() {};
    this.nDu = new m.25(this);
    this.nDv = new m.26(this);
    this.nDw = new IListener() {};
    this.nDx = new IListener() {};
    this.nDy = new bj();
    this.lHL = new m.29(this);
    this.nDz = new m.30(this);
    this.nDA = new m.31(this);
    this.nDB = new m.32(this);
    this.nDC = new m.33(this);
    this.nDD = new com.tencent.mm.plugin.appbrand.jsapi.audio.o();
    this.nDE = new AppBrandGuideUI.a();
    this.lxt = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(255814);
        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString)))
        {
          m.bGa();
          m.bGb();
          m.bGc();
          m.bGd();
          m.bGe();
        }
        AppMethodBeat.o(255814);
      }
    };
    this.nDF = new m.36(this);
    this.nDm = new HashSet();
    this.nDm.add(this.nDu);
    this.nDm.add(new com.tencent.mm.plugin.appbrand.launching.b());
    this.nDm.add(this.nDv);
    this.nDm.add(this.nDo);
    this.nDm.add(this.nDp);
    this.nDm.add(this.nDn);
    this.nDm.add(new com.tencent.mm.plugin.appbrand.config.g());
    this.nDm.add(this.logoutListener);
    this.nDm.add(i.nOE);
    this.nDm.add(this.nDq);
    this.nDm.add(this.nDr);
    this.nDm.add(this.nDs);
    this.nDm.add(this.nDt);
    this.nDm.add(this.nDw);
    this.nDm.add(this.nDx);
    this.nDm.add(this.nDz);
    this.nDm.add(this.nDA);
    this.nDm.add(this.nDB);
    this.nDm.add(this.nDC);
    this.nDm.add(this.nDD);
    AppMethodBeat.o(44202);
  }
  
  public static com.tencent.mm.plugin.appbrand.appstorage.d QF()
  {
    return nCN;
  }
  
  public static com.tencent.mm.plugin.appbrand.config.e QG()
  {
    AppMethodBeat.i(44205);
    if ((nCO == null) && (nCW != null) && (!nCW.isClose())) {
      nCO = new com.tencent.mm.plugin.appbrand.config.e(nCW);
    }
    com.tencent.mm.plugin.appbrand.config.e locale = nCO;
    AppMethodBeat.o(44205);
    return locale;
  }
  
  public static <T> T W(Class<T> paramClass)
  {
    AppMethodBeat.i(44209);
    if (paramClass == com.tencent.mm.plugin.appbrand.appusage.x.class)
    {
      paramClass = nCR;
      AppMethodBeat.o(44209);
      return paramClass;
    }
    if ((paramClass == com.tencent.mm.plugin.appbrand.config.x.class) || (paramClass == z.class))
    {
      paramClass = bFF();
      AppMethodBeat.o(44209);
      return paramClass;
    }
    paramClass = b.W(paramClass);
    AppMethodBeat.o(44209);
    return paramClass;
  }
  
  private HashMap<Integer, h.b> bFA()
  {
    AppMethodBeat.i(44197);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("AppKVStorageDBCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.appstorage.d.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandWxaPkgStorageDBCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return bm.nHe;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandWxaPkgManifestRecordWithDesc".hashCode()), new m.23(this));
    localHashMap.put(Integer.valueOf("AppBrandCommonConfigStorageCreate".hashCode()), new m.34(this));
    localHashMap.put(Integer.valueOf("AppBrandLayoutStorageCreate".hashCode()), new m.37(this));
    localHashMap.put(Integer.valueOf("AppBrandStarAppStorageCreate".hashCode()), new m.38(this));
    localHashMap.put(Integer.valueOf("WxaAttributesTableCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(275624);
        String str = MAutoStorage.getCreateSQLs(WxaAttributes.nFK, "WxaAttributesTable");
        AppMethodBeat.o(275624);
        return new String[] { str };
      }
    });
    localHashMap.put(Integer.valueOf("LaunchWxaAppInfoCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return new String[] { ai.pWF };
      }
    });
    localHashMap.put(Integer.valueOf("DynamicMsgCacheDataCreate".hashCode()), new m.41(this));
    localHashMap.put(Integer.valueOf("LaunchWxaWidgetCacheCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return new String[] { com.tencent.mm.plugin.appbrand.widget.l.pWF };
      }
    });
    localHashMap.put(Integer.valueOf("WxaWidgetInfoStorageCreate".hashCode()), new m.3(this));
    localHashMap.put(Integer.valueOf("WxaUpdateableMsgStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.aj.b.e.lqL;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandCommonKVBinaryDataStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.ab.a.lqL;
      }
    });
    localHashMap.put(Integer.valueOf("PkgUpdateStatsStorage".hashCode()), new m.6(this));
    localHashMap.put(Integer.valueOf("MiniGameInfoStorage".hashCode()), new m.7(this));
    localHashMap.put(Integer.valueOf("AppBrandRecommendCardStorage".hashCode()), new m.8(this));
    localHashMap.put(Integer.valueOf("LaunchWxaJsApiPluginInfoStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ap.lqL;
      }
    });
    localHashMap.put(Integer.valueOf("LaunchWxaAppidABTestInfoStorage".hashCode()), new m.10(this));
    localHashMap.put(Integer.valueOf("AppBrandTaskWxaCheckDemoInfoStorage".hashCode()), new m.11(this));
    Iterator localIterator = b.nBP.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      final String[] arrayOfString = (String[])localEntry.getValue();
      localHashMap.put(Integer.valueOf(((b.a)localEntry.getKey()).hashCode()), new h.b()
      {
        public final String[] getSQLs()
        {
          return arrayOfString;
        }
      });
    }
    AppMethodBeat.o(44197);
    return localHashMap;
  }
  
  public static r.a bFB()
  {
    return nCW;
  }
  
  public static m bFC()
  {
    AppMethodBeat.i(44198);
    Object localObject = (com.tencent.mm.plugin.appbrand.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.appbrand.api.c.class);
    if (localObject != null) {}
    for (localObject = ((PluginAppBrand)localObject).getCore();; localObject = null)
    {
      AppMethodBeat.o(44198);
      return localObject;
    }
  }
  
  public static AppBrandGuideUI.a bFE()
  {
    AppMethodBeat.i(44203);
    if (bFC() == null)
    {
      AppMethodBeat.o(44203);
      return null;
    }
    AppBrandGuideUI.a locala = bFC().nDE;
    AppMethodBeat.o(44203);
    return locala;
  }
  
  public static z bFF()
  {
    AppMethodBeat.i(44204);
    try
    {
      if (((nCS == null) || (!nCS.bLz())) && (nCW != null) && (!nCW.isClose())) {
        nCS = new z(nCW);
      }
      z localz = nCS;
      AppMethodBeat.o(44204);
      return localz;
    }
    finally
    {
      AppMethodBeat.o(44204);
    }
  }
  
  public static ai bFG()
  {
    return nCT;
  }
  
  public static com.tencent.mm.plugin.appbrand.widget.l bFH()
  {
    return nCV;
  }
  
  public static ap bFI()
  {
    return nDc;
  }
  
  public static an bFJ()
  {
    return nDd;
  }
  
  public static com.tencent.mm.plugin.appbrand.task.a.c bFK()
  {
    return nDg;
  }
  
  public static com.tencent.mm.plugin.appbrand.widget.r bFL()
  {
    return nCX;
  }
  
  public static com.tencent.mm.aj.b.e bFM()
  {
    return nCY;
  }
  
  public static com.tencent.mm.plugin.appbrand.appusage.x bFN()
  {
    return nCR;
  }
  
  @Deprecated
  public static com.tencent.mm.plugin.appbrand.appusage.u bFO()
  {
    AppMethodBeat.i(44206);
    com.tencent.mm.plugin.appbrand.appusage.u localu = (com.tencent.mm.plugin.appbrand.appusage.u)W(com.tencent.mm.plugin.appbrand.appusage.u.class);
    AppMethodBeat.o(44206);
    return localu;
  }
  
  public static bm bFP()
  {
    return nCP;
  }
  
  public static bg bFQ()
  {
    return nCQ;
  }
  
  public static com.tencent.mm.plugin.appbrand.widget.h bFR()
  {
    return nCU;
  }
  
  public static com.tencent.mm.plugin.appbrand.b.c bFS()
  {
    AppMethodBeat.i(44207);
    if (nDh == null) {
      nDh = new com.tencent.mm.plugin.appbrand.b.c();
    }
    com.tencent.mm.plugin.appbrand.b.c localc = nDh;
    AppMethodBeat.o(44207);
    return localc;
  }
  
  public static com.tencent.mm.plugin.appbrand.b.b bFT()
  {
    AppMethodBeat.i(44208);
    if (nDi == null) {
      nDi = new com.tencent.mm.plugin.appbrand.b.b();
    }
    com.tencent.mm.plugin.appbrand.b.b localb = nDi;
    AppMethodBeat.o(44208);
    return localb;
  }
  
  public static com.tencent.mm.plugin.appbrand.ab.a bFU()
  {
    return nCZ;
  }
  
  public static ah bFV()
  {
    return nDa;
  }
  
  public static ba bFW()
  {
    return nDe;
  }
  
  public static bt bFX()
  {
    return nDf;
  }
  
  public static com.tencent.mm.plugin.appbrand.backgroundfetch.d bFY()
  {
    AppMethodBeat.i(44210);
    com.tencent.mm.plugin.appbrand.backgroundfetch.d locald = (com.tencent.mm.plugin.appbrand.backgroundfetch.d)W(com.tencent.mm.plugin.appbrand.backgroundfetch.d.class);
    AppMethodBeat.o(44210);
    return locald;
  }
  
  public static com.tencent.mm.plugin.appbrand.backgroundfetch.g bFZ()
  {
    AppMethodBeat.i(44211);
    com.tencent.mm.plugin.appbrand.backgroundfetch.g localg = (com.tencent.mm.plugin.appbrand.backgroundfetch.g)W(com.tencent.mm.plugin.appbrand.backgroundfetch.g.class);
    AppMethodBeat.o(44211);
    return localg;
  }
  
  public final r.a bFD()
  {
    AppMethodBeat.i(44199);
    Object localObject = com.tencent.mm.kernel.h.aHG().cachePath + "AppBrandComm.db";
    if ((nCW != null) && (((String)localObject).equals(nCW.getPath())))
    {
      localObject = nCW;
      AppMethodBeat.o(44199);
      return localObject;
    }
    localObject = com.tencent.mm.platformtools.r.a(hashCode(), (String)localObject, bFA(), true);
    nCW = (r.a)localObject;
    AppMethodBeat.o(44199);
    return localObject;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(44200);
    Log.d("MicroMsg.SubCoreAppBrand", "onAccountPostReset updated %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.nDk = ((com.tencent.mm.plugin.auth.a.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(this.nDl);
    Object localObject2 = MMApplicationContext.getContext().getSharedPreferences("app_brand_global_sp", 0);
    if (localObject2 != null)
    {
      localObject1 = ((SharedPreferences)localObject2).getStringSet("uin_set", new HashSet());
      if (localObject1 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.h.aHE();
        if (((Set)localObject1).add(com.tencent.mm.kernel.b.getUin()))
        {
          localObject2 = ((SharedPreferences)localObject2).edit();
          ((SharedPreferences.Editor)localObject2).remove("uin_set");
          ((SharedPreferences.Editor)localObject2).commit();
          ((SharedPreferences.Editor)localObject2).putStringSet("uin_set", (Set)localObject1);
          ((SharedPreferences.Editor)localObject2).commit();
        }
      }
    }
    Object localObject1 = this.nDm.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((IListener)((Iterator)localObject1).next()).alive();
    }
    com.tencent.mm.plugin.appbrand.floatball.b.bNZ();
    localObject1 = bj.nHv.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a((String)localObject2, this.nDy, true);
    }
    t.b.OO();
    localObject1 = ar.nQT;
    localObject2 = com.tencent.mm.kernel.h.ag(v.class);
    kotlin.g.b.p.j(localObject2, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)localObject2).getSysCmdMsgExtension().a("UpdateWxaUsageListNotify", (ck.a)localObject1, true);
    ar.appForegroundListener.alive();
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().b(this.nDj);
    bFD();
    nCN = new com.tencent.mm.plugin.appbrand.appstorage.d(nCW);
    nCO = new com.tencent.mm.plugin.appbrand.config.e(nCW);
    nCP = new bm(nCW);
    nCQ = new bg(nCW);
    nCR = new com.tencent.mm.plugin.appbrand.appusage.x(nCW);
    nCT = new ai(nCW);
    nCU = new com.tencent.mm.plugin.appbrand.widget.h(nCW);
    nCV = new com.tencent.mm.plugin.appbrand.widget.l(nCW);
    nCX = new com.tencent.mm.plugin.appbrand.widget.r(nCW);
    nCY = new com.tencent.mm.aj.b.e(nCW);
    nCZ = new com.tencent.mm.plugin.appbrand.ab.a(nCW);
    nDa = new ah(nCW);
    nDb = new com.tencent.mm.plugin.appbrand.game.b.a.b(nCW);
    nDc = new ap(nCW);
    nDd = new an(nCW);
    nDe = new ba();
    nDf = new bt();
    nDg = new com.tencent.mm.plugin.appbrand.task.a.c(nCW);
    bFF();
    b.a(nCW);
    com.tencent.mm.plugin.appbrand.o.setup();
    y.bLB();
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon().a(-86016, new m.14(this));
    com.tencent.mm.kernel.h.aHF().a(this.lHL);
    com.tencent.mm.plugin.appbrand.dynamic.g.initialize();
    com.tencent.mm.model.c.d.bgB().add(this.lxt);
    this.nDF.alive();
    com.tencent.mm.pluginsdk.cmd.b.a(new m.a((byte)0), new String[] { "//xwebdebug" });
    com.tencent.mm.plugin.appbrand.config.h.init();
    localObject1 = this.nDE;
    AppBrandGuideUI.a.cjC().registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject1);
    AppBrandStickyBannerLogic.b.d((com.tencent.mm.plugin.appbrand.ui.banner.f)localObject1);
    ((AppBrandGuideUI.a)localObject1).qVd = false;
    com.tencent.mm.plugin.appbrand.floatball.f.bOh();
    com.tencent.mm.plugin.appbrand.floatball.g.bOh();
    com.tencent.mm.plugin.appbrand.keylogger.g.bZk();
    AppMethodBeat.o(44200);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(44201);
    Log.d("MicroMsg.SubCoreAppBrand", "onAccountRelease");
    if (this.nDk != null)
    {
      this.nDk.dead();
      this.nDk = null;
    }
    ??? = this.nDm.iterator();
    while (((Iterator)???).hasNext()) {
      ((IListener)((Iterator)???).next()).dead();
    }
    com.tencent.mm.plugin.appbrand.floatball.b.bOa();
    com.tencent.mm.plugin.appbrand.o.release();
    ??? = bj.nHv.keySet().iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (String)((Iterator)???).next();
      ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b((String)localObject2, this.nDy, true);
    }
    t.b.unregister();
    ??? = ar.nQT;
    Object localObject2 = com.tencent.mm.kernel.h.ag(v.class);
    kotlin.g.b.p.j(localObject2, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)localObject2).getSysCmdMsgExtension().b("UpdateWxaUsageListNotify", (ck.a)???, true);
    ar.appForegroundListener.dead();
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().c(this.nDj);
    bq.shutdown();
    nCN = null;
    nCS = null;
    nCO = null;
    nCP = null;
    nCQ = null;
    nCR = null;
    nCT = null;
    nCU = null;
    nCV = null;
    nCX = null;
    nCY = null;
    nCZ = null;
    nDa = null;
    nDb = null;
    nDc = null;
    nDd = null;
    nDe = null;
    nDf = null;
    nDg = null;
    b.bFh();
    if (nDi != null)
    {
      ??? = nDi;
      ((com.tencent.mm.plugin.appbrand.b.b)???).nVg.clear();
      ((com.tencent.mm.plugin.appbrand.b.b)???).nVh.clear();
      nDi = null;
    }
    nDh = null;
    if (nCW != null)
    {
      nCW.xW(hashCode());
      nCW = null;
    }
    com.tencent.mm.plugin.appbrand.appusage.j.release();
    y.release();
    com.tencent.mm.plugin.appbrand.appcache.predownload.b.j.nJX.cleanup();
    com.tencent.mm.plugin.appbrand.utils.h.clU();
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).unregisterIndexStorage(512);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).unregisterNativeLogic(7);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(144);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(4224);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).unregisterIndexStorage(8);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).unregisterNativeLogic(10);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(208);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(4240);
    com.tencent.mm.kernel.h.aHF().b(this.lHL);
    com.tencent.mm.plugin.appbrand.dynamic.g.release();
    com.tencent.mm.model.c.d.bgB().remove(this.lxt);
    this.nDF.dead();
    com.tencent.mm.plugin.appbrand.config.h.release();
    ??? = this.nDE;
    AppBrandGuideUI.a.cjC().unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)???);
    AppBrandStickyBannerLogic.b.c((com.tencent.mm.plugin.appbrand.ui.banner.f)???);
    ((AppBrandGuideUI.a)???).qVd = false;
    ??? = com.tencent.mm.plugin.appbrand.appstorage.g.nMp;
    com.tencent.mm.kernel.h.aHE();
    long l = new com.tencent.mm.b.p(com.tencent.mm.kernel.b.getUin()).longValue();
    synchronized (com.tencent.mm.plugin.appbrand.appstorage.g.bIz())
    {
      com.tencent.mm.plugin.appbrand.appstorage.g.bIz().remove(Long.valueOf(l));
      Log.i("AppBrandMMKVStorage", "onAccountRelease remove cache uin:".concat(String.valueOf(l)));
      localObject2 = kotlin.x.aazN;
      com.tencent.mm.plugin.appbrand.floatball.f.bOi();
      com.tencent.mm.plugin.appbrand.floatball.g.bOi();
      AppMethodBeat.o(44201);
      return;
    }
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.m
 * JD-Core Version:    0.7.0.1
 */