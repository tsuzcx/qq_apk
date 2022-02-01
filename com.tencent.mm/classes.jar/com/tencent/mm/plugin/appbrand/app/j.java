package com.tencent.mm.plugin.appbrand.app;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.g.a.kr;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.la;
import com.tencent.mm.g.a.lq;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.a.wl;
import com.tencent.mm.g.a.wx;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.network.n.a;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.av;
import com.tencent.mm.plugin.appbrand.appcache.bc;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.bh;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.bk.a;
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
  private static volatile av jkA;
  private static volatile com.tencent.mm.plugin.appbrand.appcache.bk jkB;
  private static com.tencent.mm.plugin.appbrand.c.c jkC;
  private static com.tencent.mm.plugin.appbrand.c.b jkD;
  private static volatile com.tencent.mm.plugin.appbrand.appstorage.d jkl;
  private static volatile com.tencent.mm.plugin.appbrand.config.d jkm;
  private static volatile bf jkn;
  private static volatile com.tencent.mm.plugin.appbrand.appusage.y jko;
  private static volatile v jkp;
  private static volatile at jkq;
  private static volatile com.tencent.mm.plugin.appbrand.widget.g jkr;
  private static volatile com.tencent.mm.plugin.appbrand.widget.j jks;
  private static volatile r.a jkt;
  private static volatile com.tencent.mm.plugin.appbrand.widget.o jku;
  private static volatile com.tencent.mm.ah.a.d jkv;
  private static volatile com.tencent.mm.plugin.appbrand.y.a jkw;
  private static volatile ae jkx;
  private static volatile com.tencent.mm.plugin.appbrand.game.b.a.b jky;
  private static volatile ay jkz;
  private final com.tencent.mm.network.n hBi;
  private k.a hrd;
  private bk.a jkE;
  private com.tencent.mm.vending.b.b jkF;
  private final com.tencent.mm.plugin.auth.a.a jkG;
  private final Set<com.tencent.mm.sdk.b.c> jkH;
  private final com.tencent.mm.sdk.b.c<la> jkI;
  private final com.tencent.mm.sdk.b.c<wx> jkJ;
  private final com.tencent.mm.sdk.b.c<lq> jkK;
  private final com.tencent.mm.sdk.b.c<pn> jkL;
  private final com.tencent.mm.sdk.b.c<l> jkM;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.q> jkN;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.p> jkO;
  private final com.tencent.mm.sdk.b.c<wl> jkP;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.k> jkQ;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.o> jkR;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.cc> jkS;
  private final com.tencent.mm.sdk.b.c<kr> jkT;
  private final cc.a jkU;
  private com.tencent.mm.sdk.b.c jkV;
  private com.tencent.mm.sdk.b.c jkW;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.k> jkX;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.r> jkY;
  private final AppBrandGuideUI.a jkZ;
  private final com.tencent.mm.sdk.b.c<fi> jla;
  
  public j()
  {
    AppMethodBeat.i(44202);
    this.jkE = new com.tencent.mm.plugin.appbrand.w.a();
    this.jkF = null;
    this.jkG = new com.tencent.mm.plugin.auth.a.a()
    {
      public final void a(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
      {
        int j = 0;
        AppMethodBeat.i(186308);
        if ((paramAnonymousi != null) && ((paramAnonymousi instanceof j.g)))
        {
          com.tencent.mm.plugin.appbrand.appusage.j.aYz().aYA();
          as.fI(true);
        }
        if ((paramAnonymousBoolean) && ((paramAnonymoush instanceof com.tencent.mm.protocal.j.a)) && (paramAnonymoush.getSceneStatus() == 12)) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            as.fI(true);
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
            com.tencent.mm.plugin.appbrand.appusage.a.g.fN(true);
          }
          AppMethodBeat.o(186308);
          return;
        }
      }
      
      public final void a(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2) {}
    };
    this.jkI = new com.tencent.mm.sdk.b.c() {};
    this.jkJ = new com.tencent.mm.sdk.b.c() {};
    this.jkK = new com.tencent.mm.sdk.b.c() {};
    this.jkL = new com.tencent.mm.sdk.b.c() {};
    this.jkM = new com.tencent.mm.sdk.b.c() {};
    this.jkN = new com.tencent.mm.sdk.b.c() {};
    this.jkO = new j.19(this);
    this.jkP = new com.tencent.mm.sdk.b.c() {};
    this.jkQ = new com.tencent.mm.sdk.b.c() {};
    this.jkR = new j.22(this);
    this.jkS = new j.24(this);
    this.jkT = new com.tencent.mm.sdk.b.c() {};
    this.jkU = new bc();
    this.hBi = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(186311);
        com.tencent.mm.plugin.appbrand.task.f.onNetworkChange();
        com.tencent.mm.plugin.appbrand.appcache.b.b.j.jqy.aXE();
        AppMethodBeat.o(186311);
      }
    };
    this.jkV = new j.27(this);
    this.jkW = new com.tencent.mm.sdk.b.c() {};
    this.jkX = new j.29(this);
    this.jkY = new j.30(this);
    this.jkZ = new AppBrandGuideUI.a();
    this.hrd = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(186316);
        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString)))
        {
          j.aVM();
          j.aVN();
          j.aVO();
          j.aVP();
          j.aVQ();
        }
        AppMethodBeat.o(186316);
      }
    };
    this.jla = new com.tencent.mm.sdk.b.c() {};
    this.jkH = new HashSet();
    this.jkH.add(this.jkQ);
    this.jkH.add(new com.tencent.mm.plugin.appbrand.launching.b());
    this.jkH.add(this.jkR);
    this.jkH.add(this.jkK);
    this.jkH.add(this.jkL);
    this.jkH.add(this.jkJ);
    this.jkH.add(new com.tencent.mm.plugin.appbrand.config.f());
    this.jkH.add(this.jkI);
    this.jkH.add(i.juw);
    this.jkH.add(this.jkM);
    this.jkH.add(this.jkN);
    this.jkH.add(this.jkO);
    this.jkH.add(this.jkP);
    this.jkH.add(this.jkS);
    this.jkH.add(this.jkT);
    this.jkH.add(this.jkV);
    this.jkH.add(this.jkW);
    this.jkH.add(this.jkX);
    this.jkH.add(this.jkY);
    AppMethodBeat.o(44202);
  }
  
  public static com.tencent.mm.plugin.appbrand.appstorage.d CJ()
  {
    return jkl;
  }
  
  public static com.tencent.mm.plugin.appbrand.config.d CK()
  {
    AppMethodBeat.i(44205);
    if ((jkm == null) && (jkt != null) && (!jkt.eWz())) {
      jkm = new com.tencent.mm.plugin.appbrand.config.d(jkt);
    }
    com.tencent.mm.plugin.appbrand.config.d locald = jkm;
    AppMethodBeat.o(44205);
    return locald;
  }
  
  public static <T> T T(Class<T> paramClass)
  {
    AppMethodBeat.i(44209);
    if (paramClass == com.tencent.mm.plugin.appbrand.appusage.y.class)
    {
      paramClass = jko;
      AppMethodBeat.o(44209);
      return paramClass;
    }
    paramClass = a.T(paramClass);
    AppMethodBeat.o(44209);
    return paramClass;
  }
  
  public static com.tencent.mm.plugin.appbrand.appusage.y aVA()
  {
    return jko;
  }
  
  @Deprecated
  public static com.tencent.mm.plugin.appbrand.appusage.u aVB()
  {
    AppMethodBeat.i(44206);
    com.tencent.mm.plugin.appbrand.appusage.u localu = (com.tencent.mm.plugin.appbrand.appusage.u)T(com.tencent.mm.plugin.appbrand.appusage.u.class);
    AppMethodBeat.o(44206);
    return localu;
  }
  
  public static bf aVC()
  {
    return jkn;
  }
  
  public static com.tencent.mm.plugin.appbrand.widget.g aVD()
  {
    return jkr;
  }
  
  public static com.tencent.mm.plugin.appbrand.c.c aVE()
  {
    AppMethodBeat.i(44207);
    if (jkC == null) {
      jkC = new com.tencent.mm.plugin.appbrand.c.c();
    }
    com.tencent.mm.plugin.appbrand.c.c localc = jkC;
    AppMethodBeat.o(44207);
    return localc;
  }
  
  public static com.tencent.mm.plugin.appbrand.c.b aVF()
  {
    AppMethodBeat.i(44208);
    if (jkD == null) {
      jkD = new com.tencent.mm.plugin.appbrand.c.b();
    }
    com.tencent.mm.plugin.appbrand.c.b localb = jkD;
    AppMethodBeat.o(44208);
    return localb;
  }
  
  public static com.tencent.mm.plugin.appbrand.y.a aVG()
  {
    return jkw;
  }
  
  public static ae aVH()
  {
    return jkx;
  }
  
  public static av aVI()
  {
    return jkA;
  }
  
  public static com.tencent.mm.plugin.appbrand.appcache.bk aVJ()
  {
    return jkB;
  }
  
  public static com.tencent.mm.plugin.appbrand.backgroundfetch.d aVK()
  {
    AppMethodBeat.i(44210);
    com.tencent.mm.plugin.appbrand.backgroundfetch.d locald = (com.tencent.mm.plugin.appbrand.backgroundfetch.d)T(com.tencent.mm.plugin.appbrand.backgroundfetch.d.class);
    AppMethodBeat.o(44210);
    return locald;
  }
  
  public static com.tencent.mm.plugin.appbrand.backgroundfetch.g aVL()
  {
    AppMethodBeat.i(44211);
    com.tencent.mm.plugin.appbrand.backgroundfetch.g localg = (com.tencent.mm.plugin.appbrand.backgroundfetch.g)T(com.tencent.mm.plugin.appbrand.backgroundfetch.g.class);
    AppMethodBeat.o(44211);
    return localg;
  }
  
  private HashMap<Integer, h.b> aVp()
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
        return bf.joM;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandCommonConfigStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.config.d.hlS;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandLayoutStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.appusage.y.hlS;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandStarAppStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.appusage.u.hlS;
      }
    });
    localHashMap.put(Integer.valueOf("WxaAttributesTableCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return v.hlS;
      }
    });
    localHashMap.put(Integer.valueOf("LaunchWxaAppInfoCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return new String[] { at.lna };
      }
    });
    localHashMap.put(Integer.valueOf("DynamicMsgCacheDataCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.widget.g.hlS;
      }
    });
    localHashMap.put(Integer.valueOf("LaunchWxaWidgetCacheCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return new String[] { com.tencent.mm.plugin.appbrand.widget.j.lna };
      }
    });
    localHashMap.put(Integer.valueOf("WxaWidgetInfoStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.widget.o.hlS;
      }
    });
    localHashMap.put(Integer.valueOf("WxaUpdateableMsgStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.ah.a.d.hlS;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandCommonKVBinaryDataStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.y.a.hlS;
      }
    });
    localHashMap.put(Integer.valueOf("PkgUpdateStatsStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ae.hlS;
      }
    });
    localHashMap.put(Integer.valueOf("MiniGameInfoStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.game.b.a.b.hlS;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandRecommendCardStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.appusage.a.b.hlS;
      }
    });
    localHashMap.put(Integer.valueOf("LaunchWxaJsApiPluginInfoStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ay.hlS;
      }
    });
    Iterator localIterator = a.jjs.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      final String[] arrayOfString = (String[])localEntry.getValue();
      localHashMap.put(Integer.valueOf(((a.a)localEntry.getKey()).hashCode()), new h.b()
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
  
  public static r.a aVq()
  {
    return jkt;
  }
  
  public static j aVr()
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
  
  public static AppBrandGuideUI.a aVt()
  {
    AppMethodBeat.i(44203);
    if (aVr() == null)
    {
      AppMethodBeat.o(44203);
      return null;
    }
    AppBrandGuideUI.a locala = aVr().jkZ;
    AppMethodBeat.o(44203);
    return locala;
  }
  
  public static v aVu()
  {
    AppMethodBeat.i(44204);
    try
    {
      if (((jkp == null) || (!jkp.baH())) && (jkt != null) && (!jkt.eWz())) {
        jkp = new v(jkt);
      }
      v localv = jkp;
      AppMethodBeat.o(44204);
      return localv;
    }
    finally
    {
      AppMethodBeat.o(44204);
    }
  }
  
  public static at aVv()
  {
    return jkq;
  }
  
  public static com.tencent.mm.plugin.appbrand.widget.j aVw()
  {
    return jks;
  }
  
  public static ay aVx()
  {
    return jkz;
  }
  
  public static com.tencent.mm.plugin.appbrand.widget.o aVy()
  {
    return jku;
  }
  
  public static com.tencent.mm.ah.a.d aVz()
  {
    return jkv;
  }
  
  public final r.a aVs()
  {
    AppMethodBeat.i(44199);
    Object localObject = com.tencent.mm.kernel.g.agR().cachePath + "AppBrandComm.db";
    if ((jkt != null) && (((String)localObject).equals(jkt.getPath())))
    {
      localObject = jkt;
      AppMethodBeat.o(44199);
      return localObject;
    }
    localObject = com.tencent.mm.platformtools.r.a(hashCode(), (String)localObject, aVp(), true);
    jkt = (r.a)localObject;
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
    ac.d("MicroMsg.SubCoreAppBrand", "onAccountPostReset updated %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.jkF = ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(this.jkG);
    Object localObject2 = ai.getContext().getSharedPreferences("app_brand_global_sp", 0);
    if (localObject2 != null)
    {
      localObject1 = ((SharedPreferences)localObject2).getStringSet("uin_set", new HashSet());
      if (localObject1 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.agP();
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
    Object localObject1 = this.jkH.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.sdk.b.c)((Iterator)localObject1).next()).alive();
    }
    com.tencent.mm.plugin.appbrand.floatball.c.bdf();
    localObject1 = bc.joz.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().a((String)localObject2, this.jkU, true);
    }
    t.b.AY();
    x.a.AY();
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().c(this.jkE);
    aVs();
    jkl = new com.tencent.mm.plugin.appbrand.appstorage.d(jkt);
    jkm = new com.tencent.mm.plugin.appbrand.config.d(jkt);
    jkn = new bf(jkt);
    jko = new com.tencent.mm.plugin.appbrand.appusage.y(jkt);
    jkq = new at(jkt);
    jkr = new com.tencent.mm.plugin.appbrand.widget.g(jkt);
    jks = new com.tencent.mm.plugin.appbrand.widget.j(jkt);
    jku = new com.tencent.mm.plugin.appbrand.widget.o(jkt);
    jkv = new com.tencent.mm.ah.a.d(jkt);
    jkw = new com.tencent.mm.plugin.appbrand.y.a(jkt);
    jkx = new ae(jkt);
    jky = new com.tencent.mm.plugin.appbrand.game.b.a.b(jkt);
    jkz = new ay(jkt);
    jkA = new av();
    jkB = new com.tencent.mm.plugin.appbrand.appcache.bk();
    aVu();
    a.a(jkt);
    com.tencent.mm.plugin.appbrand.j.setup();
    com.tencent.mm.plugin.appbrand.config.u.baJ();
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon().a(-86016, new j.10(this));
    com.tencent.mm.kernel.g.agQ().a(this.hBi);
    com.tencent.mm.plugin.appbrand.dynamic.g.initialize();
    com.tencent.mm.model.c.d.aAp().add(this.hrd);
    this.jla.alive();
    com.tencent.mm.pluginsdk.cmd.b.a(new j.a((byte)0), new String[] { "//xwebdebug" });
    com.tencent.mm.plugin.appbrand.config.g.init();
    localObject1 = this.jkZ;
    AppBrandGuideUI.a.buZ().registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject1);
    AppBrandStickyBannerLogic.b.d((com.tencent.mm.plugin.appbrand.ui.banner.f)localObject1);
    ((AppBrandGuideUI.a)localObject1).mbt = false;
    com.tencent.mm.plugin.appbrand.floatball.g.bdm();
    com.tencent.mm.plugin.appbrand.floatball.h.bdm();
    com.tencent.mm.plugin.appbrand.keylogger.g.bmM();
    AppMethodBeat.o(44200);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(44201);
    ac.d("MicroMsg.SubCoreAppBrand", "onAccountRelease");
    if (this.jkF != null)
    {
      this.jkF.dead();
      this.jkF = null;
    }
    ??? = this.jkH.iterator();
    while (((Iterator)???).hasNext()) {
      ((com.tencent.mm.sdk.b.c)((Iterator)???).next()).dead();
    }
    com.tencent.mm.plugin.appbrand.floatball.c.bdg();
    com.tencent.mm.plugin.appbrand.j.release();
    ??? = bc.joz.keySet().iterator();
    Object localObject2;
    while (((Iterator)???).hasNext())
    {
      localObject2 = (String)((Iterator)???).next();
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).getSysCmdMsgExtension().b((String)localObject2, this.jkU, true);
    }
    t.b.unregister();
    x.a.unregister();
    ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awG().d(this.jkE);
    bh.shutdown();
    jkl = null;
    jkp = null;
    jkm = null;
    jkn = null;
    jko = null;
    jkq = null;
    jkr = null;
    jks = null;
    jku = null;
    jkv = null;
    jkw = null;
    jkx = null;
    jky = null;
    jkz = null;
    jkA = null;
    jkB = null;
    a.aVc();
    if (jkD != null)
    {
      ??? = jkD;
      ((com.tencent.mm.plugin.appbrand.c.b)???).jAN.clear();
      ((com.tencent.mm.plugin.appbrand.c.b)???).jAO.clear();
      jkD = null;
    }
    jkC = null;
    if (jkt != null)
    {
      jkt.qx(hashCode());
      jkt = null;
    }
    com.tencent.mm.plugin.appbrand.appusage.j.release();
    com.tencent.mm.plugin.appbrand.config.u.release();
    com.tencent.mm.plugin.appbrand.appcache.b.b.j.jqy.cleanup();
    com.tencent.mm.plugin.appbrand.utils.e.bxi();
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterIndexStorage(512);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterNativeLogic(7);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(144);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(4224);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterIndexStorage(8);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterNativeLogic(10);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(208);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(4240);
    com.tencent.mm.kernel.g.agQ().b(this.hBi);
    com.tencent.mm.plugin.appbrand.dynamic.g.release();
    com.tencent.mm.model.c.d.aAp().remove(this.hrd);
    this.jla.dead();
    com.tencent.mm.plugin.appbrand.config.g.release();
    ??? = this.jkZ;
    AppBrandGuideUI.a.buZ().unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)???);
    AppBrandStickyBannerLogic.b.c((com.tencent.mm.plugin.appbrand.ui.banner.f)???);
    ((AppBrandGuideUI.a)???).mbt = false;
    ??? = com.tencent.mm.plugin.appbrand.appstorage.h.jsx;
    com.tencent.mm.kernel.g.agP();
    long l = new com.tencent.mm.b.p(com.tencent.mm.kernel.a.getUin()).longValue();
    synchronized (com.tencent.mm.plugin.appbrand.appstorage.h.aYa())
    {
      com.tencent.mm.plugin.appbrand.appstorage.h.aYa().remove(Long.valueOf(l));
      ac.i("AppBrandMMKVStorage", "onAccountRelease remove cache uin:".concat(String.valueOf(l)));
      localObject2 = d.y.KTp;
      com.tencent.mm.plugin.appbrand.floatball.g.bdn();
      com.tencent.mm.plugin.appbrand.floatball.h.bdn();
      AppMethodBeat.o(44201);
      return;
    }
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.j
 * JD-Core Version:    0.7.0.1
 */