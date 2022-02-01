package com.tencent.mm.plugin.appbrand.app;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.g.a.kr;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.g.a.wa;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.network.n.a;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.av;
import com.tencent.mm.plugin.appbrand.appcache.bc;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.bk;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.appusage.t.b;
import com.tencent.mm.plugin.appbrand.appusage.x.a;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.launching.at;
import com.tencent.mm.plugin.appbrand.launching.ay;
import com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.a;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.bh.a;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

public final class j
  implements aw
{
  private static volatile com.tencent.mm.plugin.appbrand.appstorage.d iKf;
  private static volatile com.tencent.mm.plugin.appbrand.config.d iKg;
  private static volatile bf iKh;
  private static volatile com.tencent.mm.plugin.appbrand.appusage.y iKi;
  private static volatile v iKj;
  private static volatile at iKk;
  private static volatile com.tencent.mm.plugin.appbrand.widget.g iKl;
  private static volatile com.tencent.mm.plugin.appbrand.widget.j iKm;
  private static volatile r.a iKn;
  private static volatile com.tencent.mm.plugin.appbrand.widget.o iKo;
  private static volatile com.tencent.mm.ai.a.d iKp;
  private static volatile com.tencent.mm.plugin.appbrand.z.a iKq;
  private static volatile ae iKr;
  private static volatile com.tencent.mm.plugin.appbrand.game.b.a.b iKs;
  private static volatile ay iKt;
  private static volatile av iKu;
  private static volatile bk iKv;
  private static com.tencent.mm.plugin.appbrand.c.c iKw;
  private static com.tencent.mm.plugin.appbrand.c.b iKx;
  private k.a gQD;
  private final com.tencent.mm.network.n haH;
  private final com.tencent.mm.plugin.auth.a.a iKA;
  private final Set<com.tencent.mm.sdk.b.c> iKB;
  private final com.tencent.mm.sdk.b.c<kr> iKC;
  private final com.tencent.mm.sdk.b.c<wm> iKD;
  private final com.tencent.mm.sdk.b.c<lh> iKE;
  private final com.tencent.mm.sdk.b.c<pe> iKF;
  private final com.tencent.mm.sdk.b.c<l> iKG;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.q> iKH;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.p> iKI;
  private final com.tencent.mm.sdk.b.c<wa> iKJ;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.k> iKK;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.o> iKL;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.cc> iKM;
  private final com.tencent.mm.sdk.b.c<kj> iKN;
  private final cc.a iKO;
  private com.tencent.mm.sdk.b.c iKP;
  private com.tencent.mm.sdk.b.c iKQ;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.k> iKR;
  private final AppBrandGuideUI.a iKS;
  private final com.tencent.mm.sdk.b.c<fh> iKT;
  private bh.a iKy;
  private com.tencent.mm.vending.b.b iKz;
  
  public j()
  {
    AppMethodBeat.i(44202);
    this.iKy = new com.tencent.mm.plugin.appbrand.x.a();
    this.iKz = null;
    this.iKA = new com.tencent.mm.plugin.auth.a.a()
    {
      public final void a(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
      {
        int j = 0;
        AppMethodBeat.i(195607);
        if ((paramAnonymousi != null) && ((paramAnonymousi instanceof j.g)))
        {
          com.tencent.mm.plugin.appbrand.appusage.j.aRE().aRF();
          as.fm(true);
        }
        if ((paramAnonymousBoolean) && ((paramAnonymoush instanceof com.tencent.mm.protocal.j.a)) && (paramAnonymoush.getSceneStatus() == 12)) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            as.fm(true);
          }
          if ((!(paramAnonymoush instanceof j.f)) || (paramAnonymoush.getSceneStatus() != 1))
          {
            i = j;
            if ((paramAnonymoush instanceof com.tencent.mm.protocal.j.a))
            {
              i = j;
              if (paramAnonymoush.getSceneStatus() != 12) {}
            }
          }
          else
          {
            i = 1;
          }
          if (i != 0) {
            com.tencent.mm.plugin.appbrand.appusage.a.g.fr(true);
          }
          AppMethodBeat.o(195607);
          return;
        }
      }
      
      public final void a(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2) {}
    };
    this.iKC = new j.13(this);
    this.iKD = new j.14(this);
    this.iKE = new com.tencent.mm.sdk.b.c() {};
    this.iKF = new j.16(this);
    this.iKG = new j.17(this);
    this.iKH = new j.18(this);
    this.iKI = new j.19(this);
    this.iKJ = new com.tencent.mm.sdk.b.c() {};
    this.iKK = new com.tencent.mm.sdk.b.c() {};
    this.iKL = new j.22(this);
    this.iKM = new j.24(this);
    this.iKN = new j.25(this);
    this.iKO = new bc();
    this.haH = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(195610);
        com.tencent.mm.plugin.appbrand.task.f.onNetworkChange();
        com.tencent.mm.plugin.appbrand.appcache.b.b.j.iQo.aQJ();
        AppMethodBeat.o(195610);
      }
    };
    this.iKP = new j.27(this);
    this.iKQ = new com.tencent.mm.sdk.b.c() {};
    this.iKR = new j.29(this);
    this.iKS = new AppBrandGuideUI.a();
    this.gQD = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(195613);
        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString)))
        {
          j.aOU();
          j.aOV();
          j.aOW();
          j.aOX();
          j.aOY();
        }
        AppMethodBeat.o(195613);
      }
    };
    this.iKT = new com.tencent.mm.sdk.b.c() {};
    this.iKB = new HashSet();
    this.iKB.add(this.iKK);
    this.iKB.add(new com.tencent.mm.plugin.appbrand.launching.b());
    this.iKB.add(this.iKL);
    this.iKB.add(this.iKE);
    this.iKB.add(this.iKF);
    this.iKB.add(this.iKD);
    this.iKB.add(new com.tencent.mm.plugin.appbrand.config.f());
    this.iKB.add(this.iKC);
    this.iKB.add(i.iUk);
    this.iKB.add(this.iKG);
    this.iKB.add(this.iKH);
    this.iKB.add(this.iKI);
    this.iKB.add(this.iKJ);
    this.iKB.add(this.iKM);
    this.iKB.add(this.iKN);
    this.iKB.add(this.iKP);
    this.iKB.add(this.iKQ);
    this.iKB.add(this.iKR);
    AppMethodBeat.o(44202);
  }
  
  public static com.tencent.mm.plugin.appbrand.appstorage.d Dg()
  {
    return iKf;
  }
  
  public static com.tencent.mm.plugin.appbrand.config.d Dh()
  {
    AppMethodBeat.i(44205);
    if ((iKg == null) && (iKn != null) && (!iKn.eHe())) {
      iKg = new com.tencent.mm.plugin.appbrand.config.d(iKn);
    }
    com.tencent.mm.plugin.appbrand.config.d locald = iKg;
    AppMethodBeat.o(44205);
    return locald;
  }
  
  public static <T> T T(Class<T> paramClass)
  {
    AppMethodBeat.i(44209);
    if (paramClass == com.tencent.mm.plugin.appbrand.appusage.y.class)
    {
      paramClass = iKi;
      AppMethodBeat.o(44209);
      return paramClass;
    }
    paramClass = b.T(paramClass);
    AppMethodBeat.o(44209);
    return paramClass;
  }
  
  public static AppBrandGuideUI.a aOB()
  {
    AppMethodBeat.i(44203);
    if (aOz() == null)
    {
      AppMethodBeat.o(44203);
      return null;
    }
    AppBrandGuideUI.a locala = aOz().iKS;
    AppMethodBeat.o(44203);
    return locala;
  }
  
  public static v aOC()
  {
    AppMethodBeat.i(44204);
    try
    {
      if (((iKj == null) || (!iKj.aTJ())) && (iKn != null) && (!iKn.eHe())) {
        iKj = new v(iKn);
      }
      v localv = iKj;
      AppMethodBeat.o(44204);
      return localv;
    }
    finally
    {
      AppMethodBeat.o(44204);
    }
  }
  
  public static at aOD()
  {
    return iKk;
  }
  
  public static com.tencent.mm.plugin.appbrand.widget.j aOE()
  {
    return iKm;
  }
  
  public static ay aOF()
  {
    return iKt;
  }
  
  public static com.tencent.mm.plugin.appbrand.widget.o aOG()
  {
    return iKo;
  }
  
  public static com.tencent.mm.ai.a.d aOH()
  {
    return iKp;
  }
  
  public static com.tencent.mm.plugin.appbrand.appusage.y aOI()
  {
    return iKi;
  }
  
  @Deprecated
  public static com.tencent.mm.plugin.appbrand.appusage.u aOJ()
  {
    AppMethodBeat.i(44206);
    com.tencent.mm.plugin.appbrand.appusage.u localu = (com.tencent.mm.plugin.appbrand.appusage.u)T(com.tencent.mm.plugin.appbrand.appusage.u.class);
    AppMethodBeat.o(44206);
    return localu;
  }
  
  public static bf aOK()
  {
    return iKh;
  }
  
  public static com.tencent.mm.plugin.appbrand.widget.g aOL()
  {
    return iKl;
  }
  
  public static com.tencent.mm.plugin.appbrand.c.c aOM()
  {
    AppMethodBeat.i(44207);
    if (iKw == null) {
      iKw = new com.tencent.mm.plugin.appbrand.c.c();
    }
    com.tencent.mm.plugin.appbrand.c.c localc = iKw;
    AppMethodBeat.o(44207);
    return localc;
  }
  
  public static com.tencent.mm.plugin.appbrand.c.b aON()
  {
    AppMethodBeat.i(44208);
    if (iKx == null) {
      iKx = new com.tencent.mm.plugin.appbrand.c.b();
    }
    com.tencent.mm.plugin.appbrand.c.b localb = iKx;
    AppMethodBeat.o(44208);
    return localb;
  }
  
  public static com.tencent.mm.plugin.appbrand.z.a aOO()
  {
    return iKq;
  }
  
  public static ae aOP()
  {
    return iKr;
  }
  
  public static av aOQ()
  {
    return iKu;
  }
  
  public static bk aOR()
  {
    return iKv;
  }
  
  public static com.tencent.mm.plugin.appbrand.backgroundfetch.d aOS()
  {
    AppMethodBeat.i(44210);
    com.tencent.mm.plugin.appbrand.backgroundfetch.d locald = (com.tencent.mm.plugin.appbrand.backgroundfetch.d)T(com.tencent.mm.plugin.appbrand.backgroundfetch.d.class);
    AppMethodBeat.o(44210);
    return locald;
  }
  
  public static com.tencent.mm.plugin.appbrand.backgroundfetch.g aOT()
  {
    AppMethodBeat.i(44211);
    com.tencent.mm.plugin.appbrand.backgroundfetch.g localg = (com.tencent.mm.plugin.appbrand.backgroundfetch.g)T(com.tencent.mm.plugin.appbrand.backgroundfetch.g.class);
    AppMethodBeat.o(44211);
    return localg;
  }
  
  private HashMap<Integer, h.b> aOx()
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
        return bf.iOD;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandCommonConfigStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.config.d.gLs;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandLayoutStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.appusage.y.gLs;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandStarAppStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.appusage.u.gLs;
      }
    });
    localHashMap.put(Integer.valueOf("WxaAttributesTableCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return v.gLs;
      }
    });
    localHashMap.put(Integer.valueOf("LaunchWxaAppInfoCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return new String[] { at.kLE };
      }
    });
    localHashMap.put(Integer.valueOf("DynamicMsgCacheDataCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.widget.g.gLs;
      }
    });
    localHashMap.put(Integer.valueOf("LaunchWxaWidgetCacheCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return new String[] { com.tencent.mm.plugin.appbrand.widget.j.kLE };
      }
    });
    localHashMap.put(Integer.valueOf("WxaWidgetInfoStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.widget.o.gLs;
      }
    });
    localHashMap.put(Integer.valueOf("WxaUpdateableMsgStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.ai.a.d.gLs;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandCommonKVBinaryDataStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.z.a.gLs;
      }
    });
    localHashMap.put(Integer.valueOf("PkgUpdateStatsStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ae.gLs;
      }
    });
    localHashMap.put(Integer.valueOf("MiniGameInfoStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.game.b.a.b.gLs;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandRecommendCardStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.appusage.a.b.gLs;
      }
    });
    localHashMap.put(Integer.valueOf("LaunchWxaJsApiPluginInfoStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ay.gLs;
      }
    });
    Iterator localIterator = b.iJo.entrySet().iterator();
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
  
  public static r.a aOy()
  {
    return iKn;
  }
  
  public static j aOz()
  {
    AppMethodBeat.i(44198);
    Object localObject = (com.tencent.mm.plugin.appbrand.a.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.appbrand.a.c.class);
    if (localObject != null) {}
    for (localObject = ((PluginAppBrand)localObject).getCore();; localObject = null)
    {
      AppMethodBeat.o(44198);
      return localObject;
    }
  }
  
  public final r.a aOA()
  {
    AppMethodBeat.i(44199);
    Object localObject = com.tencent.mm.kernel.g.afB().cachePath + "AppBrandComm.db";
    if ((iKn != null) && (((String)localObject).equals(iKn.getPath())))
    {
      localObject = iKn;
      AppMethodBeat.o(44199);
      return localObject;
    }
    localObject = r.a(hashCode(), (String)localObject, aOx(), true);
    iKn = (r.a)localObject;
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
    ad.d("MicroMsg.SubCoreAppBrand", "onAccountPostReset updated %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.iKz = ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(this.iKA);
    Object localObject2 = aj.getContext().getSharedPreferences("app_brand_global_sp", 0);
    if (localObject2 != null)
    {
      localObject1 = ((SharedPreferences)localObject2).getStringSet("uin_set", new HashSet());
      if (localObject1 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.afz();
        if (((Set)localObject1).add(com.tencent.mm.kernel.a.getUin()))
        {
          localObject2 = ((SharedPreferences)localObject2).edit();
          ((SharedPreferences.Editor)localObject2).remove("uin_set");
          ((SharedPreferences.Editor)localObject2).commit();
          ((SharedPreferences.Editor)localObject2).putStringSet("uin_set", (Set)localObject1);
          ((SharedPreferences.Editor)localObject2).commit();
        }
      }
    }
    Object localObject1 = this.iKB.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.sdk.b.c)((Iterator)localObject1).next()).alive();
    }
    com.tencent.mm.plugin.appbrand.floatball.c.aWh();
    localObject1 = bc.iOq.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a((String)localObject2, this.iKO, true);
    }
    t.b.Bu();
    x.a.Bu();
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().c(this.iKy);
    aOA();
    iKf = new com.tencent.mm.plugin.appbrand.appstorage.d(iKn);
    iKg = new com.tencent.mm.plugin.appbrand.config.d(iKn);
    iKh = new bf(iKn);
    iKi = new com.tencent.mm.plugin.appbrand.appusage.y(iKn);
    iKk = new at(iKn);
    iKl = new com.tencent.mm.plugin.appbrand.widget.g(iKn);
    iKm = new com.tencent.mm.plugin.appbrand.widget.j(iKn);
    iKo = new com.tencent.mm.plugin.appbrand.widget.o(iKn);
    iKp = new com.tencent.mm.ai.a.d(iKn);
    iKq = new com.tencent.mm.plugin.appbrand.z.a(iKn);
    iKr = new ae(iKn);
    iKs = new com.tencent.mm.plugin.appbrand.game.b.a.b(iKn);
    iKt = new ay(iKn);
    iKu = new av();
    iKv = new bk();
    aOC();
    b.a(iKn);
    com.tencent.mm.plugin.appbrand.j.setup();
    com.tencent.mm.plugin.appbrand.config.u.aTL();
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon().a(-86016, new j.10(this));
    com.tencent.mm.kernel.g.afA().a(this.haH);
    com.tencent.mm.plugin.appbrand.dynamic.g.initialize();
    com.tencent.mm.model.c.d.aty().add(this.gQD);
    this.iKT.alive();
    com.tencent.mm.pluginsdk.cmd.b.a(new j.a((byte)0), new String[] { "//xwebdebug" });
    com.tencent.mm.plugin.appbrand.config.g.init();
    localObject1 = this.iKS;
    AppBrandGuideUI.a.bod().registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject1);
    AppBrandStickyBannerLogic.b.d((com.tencent.mm.plugin.appbrand.ui.banner.f)localObject1);
    ((AppBrandGuideUI.a)localObject1).lzx = false;
    com.tencent.mm.plugin.appbrand.floatball.g.aWo();
    com.tencent.mm.plugin.appbrand.keylogger.g.bfS();
    AppMethodBeat.o(44200);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(44201);
    ad.d("MicroMsg.SubCoreAppBrand", "onAccountRelease");
    if (this.iKz != null)
    {
      this.iKz.dead();
      this.iKz = null;
    }
    ??? = this.iKB.iterator();
    while (((Iterator)???).hasNext()) {
      ((com.tencent.mm.sdk.b.c)((Iterator)???).next()).dead();
    }
    com.tencent.mm.plugin.appbrand.floatball.c.aWi();
    com.tencent.mm.plugin.appbrand.j.release();
    ??? = bc.iOq.keySet().iterator();
    Object localObject2;
    while (((Iterator)???).hasNext())
    {
      localObject2 = (String)((Iterator)???).next();
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b((String)localObject2, this.iKO, true);
    }
    t.b.unregister();
    x.a.unregister();
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apR().d(this.iKy);
    com.tencent.mm.plugin.appbrand.appcache.bh.shutdown();
    iKf = null;
    iKj = null;
    iKg = null;
    iKh = null;
    iKi = null;
    iKk = null;
    iKl = null;
    iKm = null;
    iKo = null;
    iKp = null;
    iKq = null;
    iKr = null;
    iKs = null;
    iKt = null;
    iKu = null;
    iKv = null;
    b.aOm();
    if (iKx != null)
    {
      ??? = iKx;
      ((com.tencent.mm.plugin.appbrand.c.b)???).jaA.clear();
      ((com.tencent.mm.plugin.appbrand.c.b)???).jaB.clear();
      iKx = null;
    }
    iKw = null;
    if (iKn != null)
    {
      iKn.pK(hashCode());
      iKn = null;
    }
    com.tencent.mm.plugin.appbrand.appusage.j.release();
    com.tencent.mm.plugin.appbrand.config.u.release();
    com.tencent.mm.plugin.appbrand.appcache.b.b.j.iQo.cleanup();
    com.tencent.mm.plugin.appbrand.utils.e.bql();
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterIndexStorage(512);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterNativeLogic(7);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(144);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(4224);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterIndexStorage(8);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterNativeLogic(10);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(208);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(4240);
    com.tencent.mm.kernel.g.afA().b(this.haH);
    com.tencent.mm.plugin.appbrand.dynamic.g.release();
    com.tencent.mm.model.c.d.aty().remove(this.gQD);
    this.iKT.dead();
    com.tencent.mm.plugin.appbrand.config.g.release();
    ??? = this.iKS;
    AppBrandGuideUI.a.bod().unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)???);
    AppBrandStickyBannerLogic.b.c((com.tencent.mm.plugin.appbrand.ui.banner.f)???);
    ((AppBrandGuideUI.a)???).lzx = false;
    ??? = h.iSm;
    com.tencent.mm.kernel.g.afz();
    long l = new com.tencent.mm.b.p(com.tencent.mm.kernel.a.getUin()).longValue();
    synchronized (h.aRf())
    {
      h.aRf().remove(Long.valueOf(l));
      ad.i("AppBrandMMKVStorage", "onAccountRelease remove cache uin:".concat(String.valueOf(l)));
      localObject2 = d.y.JfV;
      com.tencent.mm.plugin.appbrand.floatball.g.aWp();
      AppMethodBeat.o(44201);
      return;
    }
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.j
 * JD-Core Version:    0.7.0.1
 */