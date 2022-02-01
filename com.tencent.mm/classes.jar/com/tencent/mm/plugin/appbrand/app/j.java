package com.tencent.mm.plugin.appbrand.app;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.k;
import com.tencent.mm.g.a.la;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.g.a.px;
import com.tencent.mm.g.a.q;
import com.tencent.mm.g.a.xe;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.network.n.a;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bi;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.appusage.t.b;
import com.tencent.mm.plugin.appbrand.appusage.x.a;
import com.tencent.mm.plugin.appbrand.appusage.y;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.plugin.appbrand.launching.bb;
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
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.a;
import com.tencent.mm.storagebase.h.b;
import d.z;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

public final class j
  implements ax
{
  private static volatile com.tencent.mm.plugin.appbrand.appstorage.d jEb;
  private static volatile com.tencent.mm.plugin.appbrand.config.d jEc;
  private static volatile bg jEd;
  private static volatile y jEe;
  private static volatile w jEf;
  private static volatile com.tencent.mm.plugin.appbrand.launching.aw jEg;
  private static volatile com.tencent.mm.plugin.appbrand.widget.g jEh;
  private static volatile com.tencent.mm.plugin.appbrand.widget.j jEi;
  private static volatile r.a jEj;
  private static volatile com.tencent.mm.plugin.appbrand.widget.o jEk;
  private static volatile com.tencent.mm.ai.a.d jEl;
  private static volatile com.tencent.mm.plugin.appbrand.y.a jEm;
  private static volatile af jEn;
  private static volatile com.tencent.mm.plugin.appbrand.game.b.a.b jEo;
  private static volatile bb jEp;
  private static volatile com.tencent.mm.plugin.appbrand.appcache.aw jEq;
  private static volatile bl jEr;
  private static com.tencent.mm.plugin.appbrand.b.c jEs;
  private static com.tencent.mm.plugin.appbrand.b.b jEt;
  private k.a hJv;
  private final com.tencent.mm.network.n hTD;
  private final com.tencent.mm.sdk.b.c<lz> jEA;
  private final com.tencent.mm.sdk.b.c<px> jEB;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.l> jEC;
  private final com.tencent.mm.sdk.b.c<q> jED;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.p> jEE;
  private final com.tencent.mm.sdk.b.c<xe> jEF;
  private final com.tencent.mm.sdk.b.c<k> jEG;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.o> jEH;
  private final com.tencent.mm.sdk.b.c<cf> jEI;
  private final com.tencent.mm.sdk.b.c<la> jEJ;
  private final cd.a jEK;
  private com.tencent.mm.sdk.b.c jEL;
  private com.tencent.mm.sdk.b.c jEM;
  private final com.tencent.mm.sdk.b.c<k> jEN;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.r> jEO;
  private final AppBrandGuideUI.a jEP;
  private final com.tencent.mm.sdk.b.c<fl> jEQ;
  private bq.a jEu;
  private com.tencent.mm.vending.b.b jEv;
  private final com.tencent.mm.plugin.auth.a.a jEw;
  private final Set<com.tencent.mm.sdk.b.c> jEx;
  private final com.tencent.mm.sdk.b.c<lj> jEy;
  private final com.tencent.mm.sdk.b.c<xq> jEz;
  
  public j()
  {
    AppMethodBeat.i(44202);
    this.jEu = new com.tencent.mm.plugin.appbrand.w.a();
    this.jEv = null;
    this.jEw = new com.tencent.mm.plugin.auth.a.a()
    {
      public final void a(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
      {
        int j = 0;
        AppMethodBeat.i(187995);
        if ((paramAnonymousi != null) && ((paramAnonymousi instanceof j.g)))
        {
          com.tencent.mm.plugin.appbrand.appusage.j.bbX().bbY();
          at.fM(true);
        }
        if ((paramAnonymousBoolean) && ((paramAnonymoush instanceof com.tencent.mm.protocal.j.a)) && (paramAnonymoush.getSceneStatus() == 12)) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            at.fM(true);
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
            com.tencent.mm.plugin.appbrand.appusage.a.g.fR(true);
          }
          AppMethodBeat.o(187995);
          return;
        }
      }
      
      public final void a(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2) {}
    };
    this.jEy = new j.13(this);
    this.jEz = new j.14(this);
    this.jEA = new com.tencent.mm.sdk.b.c() {};
    this.jEB = new com.tencent.mm.sdk.b.c() {};
    this.jEC = new com.tencent.mm.sdk.b.c() {};
    this.jED = new com.tencent.mm.sdk.b.c() {};
    this.jEE = new com.tencent.mm.sdk.b.c() {};
    this.jEF = new com.tencent.mm.sdk.b.c() {};
    this.jEG = new com.tencent.mm.sdk.b.c() {};
    this.jEH = new j.22(this);
    this.jEI = new j.24(this);
    this.jEJ = new com.tencent.mm.sdk.b.c() {};
    this.jEK = new bd();
    this.hTD = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(187998);
        com.tencent.mm.plugin.appbrand.task.f.onNetworkChange();
        com.tencent.mm.plugin.appbrand.appcache.b.b.j.jKs.bbc();
        AppMethodBeat.o(187998);
      }
    };
    this.jEL = new j.27(this);
    this.jEM = new com.tencent.mm.sdk.b.c() {};
    this.jEN = new com.tencent.mm.sdk.b.c() {};
    this.jEO = new com.tencent.mm.sdk.b.c() {};
    this.jEP = new AppBrandGuideUI.a();
    this.hJv = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(188003);
        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString)))
        {
          j.aZh();
          j.aZi();
          j.aZj();
          j.aZk();
          j.aZl();
        }
        AppMethodBeat.o(188003);
      }
    };
    this.jEQ = new com.tencent.mm.sdk.b.c() {};
    this.jEx = new HashSet();
    this.jEx.add(this.jEG);
    this.jEx.add(new com.tencent.mm.plugin.appbrand.launching.b());
    this.jEx.add(this.jEH);
    this.jEx.add(this.jEA);
    this.jEx.add(this.jEB);
    this.jEx.add(this.jEz);
    this.jEx.add(new com.tencent.mm.plugin.appbrand.config.f());
    this.jEx.add(this.jEy);
    this.jEx.add(i.jOp);
    this.jEx.add(this.jEC);
    this.jEx.add(this.jED);
    this.jEx.add(this.jEE);
    this.jEx.add(this.jEF);
    this.jEx.add(this.jEI);
    this.jEx.add(this.jEJ);
    this.jEx.add(this.jEL);
    this.jEx.add(this.jEM);
    this.jEx.add(this.jEN);
    this.jEx.add(this.jEO);
    AppMethodBeat.o(44202);
  }
  
  public static com.tencent.mm.plugin.appbrand.appstorage.d Ei()
  {
    return jEb;
  }
  
  public static com.tencent.mm.plugin.appbrand.config.d Ej()
  {
    AppMethodBeat.i(44205);
    if ((jEc == null) && (jEj != null) && (!jEj.fmj())) {
      jEc = new com.tencent.mm.plugin.appbrand.config.d(jEj);
    }
    com.tencent.mm.plugin.appbrand.config.d locald = jEc;
    AppMethodBeat.o(44205);
    return locald;
  }
  
  public static <T> T T(Class<T> paramClass)
  {
    AppMethodBeat.i(44209);
    if (paramClass == y.class)
    {
      paramClass = jEe;
      AppMethodBeat.o(44209);
      return paramClass;
    }
    if ((paramClass == com.tencent.mm.plugin.appbrand.config.u.class) || (paramClass == w.class))
    {
      paramClass = aYP();
      AppMethodBeat.o(44209);
      return paramClass;
    }
    paramClass = a.T(paramClass);
    AppMethodBeat.o(44209);
    return paramClass;
  }
  
  private HashMap<Integer, h.b> aYK()
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
        return bg.jII;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandCommonConfigStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.config.d.hEf;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandLayoutStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return y.hEf;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandStarAppStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.appusage.u.hEf;
      }
    });
    localHashMap.put(Integer.valueOf("WxaAttributesTableCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(188006);
        String str = com.tencent.mm.sdk.e.j.getCreateSQLs(WxaAttributes.jGU, "WxaAttributesTable");
        AppMethodBeat.o(188006);
        return new String[] { str };
      }
    });
    localHashMap.put(Integer.valueOf("LaunchWxaAppInfoCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return new String[] { com.tencent.mm.plugin.appbrand.launching.aw.lKt };
      }
    });
    localHashMap.put(Integer.valueOf("DynamicMsgCacheDataCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.widget.g.hEf;
      }
    });
    localHashMap.put(Integer.valueOf("LaunchWxaWidgetCacheCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return new String[] { com.tencent.mm.plugin.appbrand.widget.j.lKt };
      }
    });
    localHashMap.put(Integer.valueOf("WxaWidgetInfoStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.widget.o.hEf;
      }
    });
    localHashMap.put(Integer.valueOf("WxaUpdateableMsgStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.ai.a.d.hEf;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandCommonKVBinaryDataStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.y.a.hEf;
      }
    });
    localHashMap.put(Integer.valueOf("PkgUpdateStatsStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return af.hEf;
      }
    });
    localHashMap.put(Integer.valueOf("MiniGameInfoStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.game.b.a.b.hEf;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandRecommendCardStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.appusage.a.b.hEf;
      }
    });
    localHashMap.put(Integer.valueOf("LaunchWxaJsApiPluginInfoStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return bb.hEf;
      }
    });
    Iterator localIterator = a.jDg.entrySet().iterator();
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
  
  public static r.a aYL()
  {
    return jEj;
  }
  
  public static j aYM()
  {
    AppMethodBeat.i(44198);
    Object localObject = (com.tencent.mm.plugin.appbrand.api.c)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.appbrand.api.c.class);
    if (localObject != null) {}
    for (localObject = ((PluginAppBrand)localObject).getCore();; localObject = null)
    {
      AppMethodBeat.o(44198);
      return localObject;
    }
  }
  
  public static AppBrandGuideUI.a aYO()
  {
    AppMethodBeat.i(44203);
    if (aYM() == null)
    {
      AppMethodBeat.o(44203);
      return null;
    }
    AppBrandGuideUI.a locala = aYM().jEP;
    AppMethodBeat.o(44203);
    return locala;
  }
  
  public static w aYP()
  {
    AppMethodBeat.i(44204);
    try
    {
      if (((jEf == null) || (!jEf.beh())) && (jEj != null) && (!jEj.fmj())) {
        jEf = new w(jEj);
      }
      w localw = jEf;
      AppMethodBeat.o(44204);
      return localw;
    }
    finally
    {
      AppMethodBeat.o(44204);
    }
  }
  
  public static com.tencent.mm.plugin.appbrand.launching.aw aYQ()
  {
    return jEg;
  }
  
  public static com.tencent.mm.plugin.appbrand.widget.j aYR()
  {
    return jEi;
  }
  
  public static bb aYS()
  {
    return jEp;
  }
  
  public static com.tencent.mm.plugin.appbrand.widget.o aYT()
  {
    return jEk;
  }
  
  public static com.tencent.mm.ai.a.d aYU()
  {
    return jEl;
  }
  
  public static y aYV()
  {
    return jEe;
  }
  
  @Deprecated
  public static com.tencent.mm.plugin.appbrand.appusage.u aYW()
  {
    AppMethodBeat.i(44206);
    com.tencent.mm.plugin.appbrand.appusage.u localu = (com.tencent.mm.plugin.appbrand.appusage.u)T(com.tencent.mm.plugin.appbrand.appusage.u.class);
    AppMethodBeat.o(44206);
    return localu;
  }
  
  public static bg aYX()
  {
    return jEd;
  }
  
  public static com.tencent.mm.plugin.appbrand.widget.g aYY()
  {
    return jEh;
  }
  
  public static com.tencent.mm.plugin.appbrand.b.c aYZ()
  {
    AppMethodBeat.i(44207);
    if (jEs == null) {
      jEs = new com.tencent.mm.plugin.appbrand.b.c();
    }
    com.tencent.mm.plugin.appbrand.b.c localc = jEs;
    AppMethodBeat.o(44207);
    return localc;
  }
  
  public static com.tencent.mm.plugin.appbrand.b.b aZa()
  {
    AppMethodBeat.i(44208);
    if (jEt == null) {
      jEt = new com.tencent.mm.plugin.appbrand.b.b();
    }
    com.tencent.mm.plugin.appbrand.b.b localb = jEt;
    AppMethodBeat.o(44208);
    return localb;
  }
  
  public static com.tencent.mm.plugin.appbrand.y.a aZb()
  {
    return jEm;
  }
  
  public static af aZc()
  {
    return jEn;
  }
  
  public static com.tencent.mm.plugin.appbrand.appcache.aw aZd()
  {
    return jEq;
  }
  
  public static bl aZe()
  {
    return jEr;
  }
  
  public static com.tencent.mm.plugin.appbrand.backgroundfetch.d aZf()
  {
    AppMethodBeat.i(44210);
    com.tencent.mm.plugin.appbrand.backgroundfetch.d locald = (com.tencent.mm.plugin.appbrand.backgroundfetch.d)T(com.tencent.mm.plugin.appbrand.backgroundfetch.d.class);
    AppMethodBeat.o(44210);
    return locald;
  }
  
  public static com.tencent.mm.plugin.appbrand.backgroundfetch.g aZg()
  {
    AppMethodBeat.i(44211);
    com.tencent.mm.plugin.appbrand.backgroundfetch.g localg = (com.tencent.mm.plugin.appbrand.backgroundfetch.g)T(com.tencent.mm.plugin.appbrand.backgroundfetch.g.class);
    AppMethodBeat.o(44211);
    return localg;
  }
  
  public final r.a aYN()
  {
    AppMethodBeat.i(44199);
    Object localObject = com.tencent.mm.kernel.g.ajC().cachePath + "AppBrandComm.db";
    if ((jEj != null) && (((String)localObject).equals(jEj.getPath())))
    {
      localObject = jEj;
      AppMethodBeat.o(44199);
      return localObject;
    }
    localObject = com.tencent.mm.platformtools.r.a(hashCode(), (String)localObject, aYK(), true);
    jEj = (r.a)localObject;
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
    this.jEv = ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(this.jEw);
    Object localObject2 = aj.getContext().getSharedPreferences("app_brand_global_sp", 0);
    if (localObject2 != null)
    {
      localObject1 = ((SharedPreferences)localObject2).getStringSet("uin_set", new HashSet());
      if (localObject1 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.ajA();
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
    Object localObject1 = this.jEx.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.sdk.b.c)((Iterator)localObject1).next()).alive();
    }
    com.tencent.mm.plugin.appbrand.floatball.c.bgJ();
    localObject1 = bd.jIv.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).getSysCmdMsgExtension().a((String)localObject2, this.jEK, true);
    }
    t.b.Cx();
    x.a.Cx();
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().c(this.jEu);
    aYN();
    jEb = new com.tencent.mm.plugin.appbrand.appstorage.d(jEj);
    jEc = new com.tencent.mm.plugin.appbrand.config.d(jEj);
    jEd = new bg(jEj);
    jEe = new y(jEj);
    jEg = new com.tencent.mm.plugin.appbrand.launching.aw(jEj);
    jEh = new com.tencent.mm.plugin.appbrand.widget.g(jEj);
    jEi = new com.tencent.mm.plugin.appbrand.widget.j(jEj);
    jEk = new com.tencent.mm.plugin.appbrand.widget.o(jEj);
    jEl = new com.tencent.mm.ai.a.d(jEj);
    jEm = new com.tencent.mm.plugin.appbrand.y.a(jEj);
    jEn = new af(jEj);
    jEo = new com.tencent.mm.plugin.appbrand.game.b.a.b(jEj);
    jEp = new bb(jEj);
    jEq = new com.tencent.mm.plugin.appbrand.appcache.aw();
    jEr = new bl();
    aYP();
    a.a(jEj);
    com.tencent.mm.plugin.appbrand.j.setup();
    v.bej();
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon().a(-86016, new j.10(this));
    com.tencent.mm.kernel.g.ajB().a(this.hTD);
    com.tencent.mm.plugin.appbrand.dynamic.g.initialize();
    com.tencent.mm.model.c.d.aDs().add(this.hJv);
    this.jEQ.alive();
    com.tencent.mm.pluginsdk.cmd.b.a(new j.a((byte)0), new String[] { "//xwebdebug" });
    com.tencent.mm.plugin.appbrand.config.g.init();
    localObject1 = this.jEP;
    AppBrandGuideUI.a.bzf().registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject1);
    AppBrandStickyBannerLogic.b.d((com.tencent.mm.plugin.appbrand.ui.banner.f)localObject1);
    ((AppBrandGuideUI.a)localObject1).mBB = false;
    com.tencent.mm.plugin.appbrand.floatball.g.bgQ();
    com.tencent.mm.plugin.appbrand.floatball.h.bgQ();
    com.tencent.mm.plugin.appbrand.keylogger.g.bqx();
    AppMethodBeat.o(44200);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(44201);
    ad.d("MicroMsg.SubCoreAppBrand", "onAccountRelease");
    if (this.jEv != null)
    {
      this.jEv.dead();
      this.jEv = null;
    }
    ??? = this.jEx.iterator();
    while (((Iterator)???).hasNext()) {
      ((com.tencent.mm.sdk.b.c)((Iterator)???).next()).dead();
    }
    com.tencent.mm.plugin.appbrand.floatball.c.bgK();
    com.tencent.mm.plugin.appbrand.j.release();
    ??? = bd.jIv.keySet().iterator();
    Object localObject2;
    while (((Iterator)???).hasNext())
    {
      localObject2 = (String)((Iterator)???).next();
      ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).getSysCmdMsgExtension().b((String)localObject2, this.jEK, true);
    }
    t.b.unregister();
    x.a.unregister();
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().d(this.jEu);
    bi.shutdown();
    jEb = null;
    jEf = null;
    jEc = null;
    jEd = null;
    jEe = null;
    jEg = null;
    jEh = null;
    jEi = null;
    jEk = null;
    jEl = null;
    jEm = null;
    jEn = null;
    jEo = null;
    jEp = null;
    jEq = null;
    jEr = null;
    a.aYw();
    if (jEt != null)
    {
      ??? = jEt;
      ((com.tencent.mm.plugin.appbrand.b.b)???).jUI.clear();
      ((com.tencent.mm.plugin.appbrand.b.b)???).jUJ.clear();
      jEt = null;
    }
    jEs = null;
    if (jEj != null)
    {
      jEj.qX(hashCode());
      jEj = null;
    }
    com.tencent.mm.plugin.appbrand.appusage.j.release();
    v.release();
    com.tencent.mm.plugin.appbrand.appcache.b.b.j.jKs.cleanup();
    com.tencent.mm.plugin.appbrand.utils.e.bBo();
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterIndexStorage(512);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterNativeLogic(7);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(144);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(4224);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterIndexStorage(8);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterNativeLogic(10);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(208);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(4240);
    com.tencent.mm.kernel.g.ajB().b(this.hTD);
    com.tencent.mm.plugin.appbrand.dynamic.g.release();
    com.tencent.mm.model.c.d.aDs().remove(this.hJv);
    this.jEQ.dead();
    com.tencent.mm.plugin.appbrand.config.g.release();
    ??? = this.jEP;
    AppBrandGuideUI.a.bzf().unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)???);
    AppBrandStickyBannerLogic.b.c((com.tencent.mm.plugin.appbrand.ui.banner.f)???);
    ((AppBrandGuideUI.a)???).mBB = false;
    ??? = com.tencent.mm.plugin.appbrand.appstorage.h.jMr;
    com.tencent.mm.kernel.g.ajA();
    long l = new com.tencent.mm.b.p(com.tencent.mm.kernel.a.getUin()).longValue();
    synchronized (com.tencent.mm.plugin.appbrand.appstorage.h.bby())
    {
      com.tencent.mm.plugin.appbrand.appstorage.h.bby().remove(Long.valueOf(l));
      ad.i("AppBrandMMKVStorage", "onAccountRelease remove cache uin:".concat(String.valueOf(l)));
      localObject2 = z.MKo;
      com.tencent.mm.plugin.appbrand.floatball.g.bgR();
      com.tencent.mm.plugin.appbrand.floatball.h.bgR();
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