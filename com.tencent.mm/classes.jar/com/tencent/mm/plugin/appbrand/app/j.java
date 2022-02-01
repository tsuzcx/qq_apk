package com.tencent.mm.plugin.appbrand.app;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fm;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.py;
import com.tencent.mm.g.a.q;
import com.tencent.mm.g.a.xi;
import com.tencent.mm.g.a.xu;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.az;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.network.n.a;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.appbrand.appcache.ag;
import com.tencent.mm.plugin.appbrand.appcache.au;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.appusage.t.b;
import com.tencent.mm.plugin.appbrand.appusage.x.a;
import com.tencent.mm.plugin.appbrand.appusage.y;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.plugin.appbrand.launching.aw;
import com.tencent.mm.plugin.appbrand.launching.bb;
import com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.a;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.br.a;
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
  implements az
{
  private static volatile com.tencent.mm.plugin.appbrand.appstorage.d jGZ;
  private static volatile com.tencent.mm.plugin.appbrand.config.d jHa;
  private static volatile bh jHb;
  private static volatile y jHc;
  private static volatile w jHd;
  private static volatile aw jHe;
  private static volatile com.tencent.mm.plugin.appbrand.widget.g jHf;
  private static volatile com.tencent.mm.plugin.appbrand.widget.j jHg;
  private static volatile r.a jHh;
  private static volatile com.tencent.mm.plugin.appbrand.widget.o jHi;
  private static volatile com.tencent.mm.ah.a.d jHj;
  private static volatile com.tencent.mm.plugin.appbrand.x.a jHk;
  private static volatile ag jHl;
  private static volatile com.tencent.mm.plugin.appbrand.game.b.a.b jHm;
  private static volatile bb jHn;
  private static volatile ax jHo;
  private static volatile bm jHp;
  private static volatile com.tencent.mm.plugin.appbrand.task.a.c jHq;
  private static com.tencent.mm.plugin.appbrand.b.c jHr;
  private static com.tencent.mm.plugin.appbrand.b.b jHs;
  private k.a hMo;
  private final com.tencent.mm.network.n hWv;
  private final com.tencent.mm.sdk.b.c<py> jHA;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.l> jHB;
  private final com.tencent.mm.sdk.b.c<q> jHC;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.p> jHD;
  private final com.tencent.mm.sdk.b.c<xi> jHE;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.k> jHF;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.o> jHG;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.cf> jHH;
  private final com.tencent.mm.sdk.b.c<lb> jHI;
  private final cf.a jHJ;
  private com.tencent.mm.sdk.b.c jHK;
  private com.tencent.mm.sdk.b.c jHL;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.k> jHM;
  private final com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.r> jHN;
  private final AppBrandGuideUI.a jHO;
  private final com.tencent.mm.sdk.b.c<fm> jHP;
  private br.a jHt;
  private com.tencent.mm.vending.b.b jHu;
  private final com.tencent.mm.plugin.auth.a.a jHv;
  private final Set<com.tencent.mm.sdk.b.c> jHw;
  private final com.tencent.mm.sdk.b.c<lk> jHx;
  private final com.tencent.mm.sdk.b.c<xu> jHy;
  private final com.tencent.mm.sdk.b.c<ma> jHz;
  
  public j()
  {
    AppMethodBeat.i(44202);
    this.jHt = new com.tencent.mm.plugin.appbrand.v.a();
    this.jHu = null;
    this.jHv = new com.tencent.mm.plugin.auth.a.a()
    {
      public final void a(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
      {
        int j = 0;
        AppMethodBeat.i(222109);
        if ((paramAnonymousi != null) && ((paramAnonymousi instanceof j.g)))
        {
          com.tencent.mm.plugin.appbrand.appusage.j.bcB().bcC();
          au.fL(true);
        }
        if ((paramAnonymousBoolean) && ((paramAnonymoush instanceof com.tencent.mm.protocal.j.a)) && (paramAnonymoush.getSceneStatus() == 12)) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            au.fL(true);
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
            com.tencent.mm.plugin.appbrand.appusage.a.g.fQ(true);
          }
          AppMethodBeat.o(222109);
          return;
        }
      }
      
      public final void a(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2) {}
    };
    this.jHx = new com.tencent.mm.sdk.b.c() {};
    this.jHy = new j.15(this);
    this.jHz = new com.tencent.mm.sdk.b.c() {};
    this.jHA = new com.tencent.mm.sdk.b.c() {};
    this.jHB = new com.tencent.mm.sdk.b.c() {};
    this.jHC = new com.tencent.mm.sdk.b.c() {};
    this.jHD = new com.tencent.mm.sdk.b.c() {};
    this.jHE = new com.tencent.mm.sdk.b.c() {};
    this.jHF = new com.tencent.mm.sdk.b.c() {};
    this.jHG = new j.24(this);
    this.jHH = new j.25(this);
    this.jHI = new com.tencent.mm.sdk.b.c() {};
    this.jHJ = new be();
    this.hWv = new n.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(222112);
        com.tencent.mm.plugin.appbrand.task.f.onNetworkChange();
        com.tencent.mm.plugin.appbrand.appcache.b.b.j.jNE.bbE();
        AppMethodBeat.o(222112);
      }
    };
    this.jHK = new j.28(this);
    this.jHL = new com.tencent.mm.sdk.b.c() {};
    this.jHM = new com.tencent.mm.sdk.b.c() {};
    this.jHN = new com.tencent.mm.sdk.b.c() {};
    this.jHO = new AppBrandGuideUI.a();
    this.hMo = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(222119);
        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString)))
        {
          j.aZE();
          j.aZF();
          j.aZG();
          j.aZH();
          j.aZI();
        }
        AppMethodBeat.o(222119);
      }
    };
    this.jHP = new com.tencent.mm.sdk.b.c() {};
    this.jHw = new HashSet();
    this.jHw.add(this.jHF);
    this.jHw.add(new com.tencent.mm.plugin.appbrand.launching.b());
    this.jHw.add(this.jHG);
    this.jHw.add(this.jHz);
    this.jHw.add(this.jHA);
    this.jHw.add(this.jHy);
    this.jHw.add(new com.tencent.mm.plugin.appbrand.config.f());
    this.jHw.add(this.jHx);
    this.jHw.add(i.jRH);
    this.jHw.add(this.jHB);
    this.jHw.add(this.jHC);
    this.jHw.add(this.jHD);
    this.jHw.add(this.jHE);
    this.jHw.add(this.jHH);
    this.jHw.add(this.jHI);
    this.jHw.add(this.jHK);
    this.jHw.add(this.jHL);
    this.jHw.add(this.jHM);
    this.jHw.add(this.jHN);
    AppMethodBeat.o(44202);
  }
  
  public static com.tencent.mm.plugin.appbrand.appstorage.d El()
  {
    return jGZ;
  }
  
  public static com.tencent.mm.plugin.appbrand.config.d Em()
  {
    AppMethodBeat.i(44205);
    if ((jHa == null) && (jHh != null) && (!jHh.fqe())) {
      jHa = new com.tencent.mm.plugin.appbrand.config.d(jHh);
    }
    com.tencent.mm.plugin.appbrand.config.d locald = jHa;
    AppMethodBeat.o(44205);
    return locald;
  }
  
  public static <T> T T(Class<T> paramClass)
  {
    AppMethodBeat.i(44209);
    if (paramClass == y.class)
    {
      paramClass = jHc;
      AppMethodBeat.o(44209);
      return paramClass;
    }
    if ((paramClass == com.tencent.mm.plugin.appbrand.config.u.class) || (paramClass == w.class))
    {
      paramClass = aZl();
      AppMethodBeat.o(44209);
      return paramClass;
    }
    paramClass = a.T(paramClass);
    AppMethodBeat.o(44209);
    return paramClass;
  }
  
  public static ax aZA()
  {
    return jHo;
  }
  
  public static bm aZB()
  {
    return jHp;
  }
  
  public static com.tencent.mm.plugin.appbrand.backgroundfetch.d aZC()
  {
    AppMethodBeat.i(44210);
    com.tencent.mm.plugin.appbrand.backgroundfetch.d locald = (com.tencent.mm.plugin.appbrand.backgroundfetch.d)T(com.tencent.mm.plugin.appbrand.backgroundfetch.d.class);
    AppMethodBeat.o(44210);
    return locald;
  }
  
  public static com.tencent.mm.plugin.appbrand.backgroundfetch.g aZD()
  {
    AppMethodBeat.i(44211);
    com.tencent.mm.plugin.appbrand.backgroundfetch.g localg = (com.tencent.mm.plugin.appbrand.backgroundfetch.g)T(com.tencent.mm.plugin.appbrand.backgroundfetch.g.class);
    AppMethodBeat.o(44211);
    return localg;
  }
  
  private HashMap<Integer, h.b> aZg()
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
        return bh.jLJ;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandCommonConfigStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.config.d.hGX;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandLayoutStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return y.hGX;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandStarAppStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.appusage.u.hGX;
      }
    });
    localHashMap.put(Integer.valueOf("WxaAttributesTableCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(222122);
        String str = com.tencent.mm.sdk.e.j.getCreateSQLs(WxaAttributes.jJU, "WxaAttributesTable");
        AppMethodBeat.o(222122);
        return new String[] { str };
      }
    });
    localHashMap.put(Integer.valueOf("LaunchWxaAppInfoCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return new String[] { aw.lOU };
      }
    });
    localHashMap.put(Integer.valueOf("DynamicMsgCacheDataCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.widget.g.hGX;
      }
    });
    localHashMap.put(Integer.valueOf("LaunchWxaWidgetCacheCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return new String[] { com.tencent.mm.plugin.appbrand.widget.j.lOU };
      }
    });
    localHashMap.put(Integer.valueOf("WxaWidgetInfoStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.widget.o.hGX;
      }
    });
    localHashMap.put(Integer.valueOf("WxaUpdateableMsgStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.ah.a.d.hGX;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandCommonKVBinaryDataStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.x.a.hGX;
      }
    });
    localHashMap.put(Integer.valueOf("PkgUpdateStatsStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ag.hGX;
      }
    });
    localHashMap.put(Integer.valueOf("MiniGameInfoStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.game.b.a.b.hGX;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandRecommendCardStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.appusage.a.b.hGX;
      }
    });
    localHashMap.put(Integer.valueOf("LaunchWxaJsApiPluginInfoStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return bb.hGX;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandTaskWxaCheckDemoInfoStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.task.a.c.hGX;
      }
    });
    Iterator localIterator = a.jGe.entrySet().iterator();
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
  
  public static r.a aZh()
  {
    return jHh;
  }
  
  public static j aZi()
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
  
  public static AppBrandGuideUI.a aZk()
  {
    AppMethodBeat.i(44203);
    if (aZi() == null)
    {
      AppMethodBeat.o(44203);
      return null;
    }
    AppBrandGuideUI.a locala = aZi().jHO;
    AppMethodBeat.o(44203);
    return locala;
  }
  
  public static w aZl()
  {
    AppMethodBeat.i(44204);
    try
    {
      if (((jHd == null) || (!jHd.beO())) && (jHh != null) && (!jHh.fqe())) {
        jHd = new w(jHh);
      }
      w localw = jHd;
      AppMethodBeat.o(44204);
      return localw;
    }
    finally
    {
      AppMethodBeat.o(44204);
    }
  }
  
  public static aw aZm()
  {
    return jHe;
  }
  
  public static com.tencent.mm.plugin.appbrand.widget.j aZn()
  {
    return jHg;
  }
  
  public static bb aZo()
  {
    return jHn;
  }
  
  public static com.tencent.mm.plugin.appbrand.task.a.c aZp()
  {
    return jHq;
  }
  
  public static com.tencent.mm.plugin.appbrand.widget.o aZq()
  {
    return jHi;
  }
  
  public static com.tencent.mm.ah.a.d aZr()
  {
    return jHj;
  }
  
  public static y aZs()
  {
    return jHc;
  }
  
  @Deprecated
  public static com.tencent.mm.plugin.appbrand.appusage.u aZt()
  {
    AppMethodBeat.i(44206);
    com.tencent.mm.plugin.appbrand.appusage.u localu = (com.tencent.mm.plugin.appbrand.appusage.u)T(com.tencent.mm.plugin.appbrand.appusage.u.class);
    AppMethodBeat.o(44206);
    return localu;
  }
  
  public static bh aZu()
  {
    return jHb;
  }
  
  public static com.tencent.mm.plugin.appbrand.widget.g aZv()
  {
    return jHf;
  }
  
  public static com.tencent.mm.plugin.appbrand.b.c aZw()
  {
    AppMethodBeat.i(44207);
    if (jHr == null) {
      jHr = new com.tencent.mm.plugin.appbrand.b.c();
    }
    com.tencent.mm.plugin.appbrand.b.c localc = jHr;
    AppMethodBeat.o(44207);
    return localc;
  }
  
  public static com.tencent.mm.plugin.appbrand.b.b aZx()
  {
    AppMethodBeat.i(44208);
    if (jHs == null) {
      jHs = new com.tencent.mm.plugin.appbrand.b.b();
    }
    com.tencent.mm.plugin.appbrand.b.b localb = jHs;
    AppMethodBeat.o(44208);
    return localb;
  }
  
  public static com.tencent.mm.plugin.appbrand.x.a aZy()
  {
    return jHk;
  }
  
  public static ag aZz()
  {
    return jHl;
  }
  
  public final r.a aZj()
  {
    AppMethodBeat.i(44199);
    Object localObject = com.tencent.mm.kernel.g.ajR().cachePath + "AppBrandComm.db";
    if ((jHh != null) && (((String)localObject).equals(jHh.getPath())))
    {
      localObject = jHh;
      AppMethodBeat.o(44199);
      return localObject;
    }
    localObject = com.tencent.mm.platformtools.r.a(hashCode(), (String)localObject, aZg(), true);
    jHh = (r.a)localObject;
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
    ae.d("MicroMsg.SubCoreAppBrand", "onAccountPostReset updated %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.jHu = ((com.tencent.mm.plugin.auth.a.b)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(this.jHv);
    Object localObject2 = ak.getContext().getSharedPreferences("app_brand_global_sp", 0);
    if (localObject2 != null)
    {
      localObject1 = ((SharedPreferences)localObject2).getStringSet("uin_set", new HashSet());
      if (localObject1 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.g.ajP();
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
    Object localObject1 = this.jHw.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((com.tencent.mm.sdk.b.c)((Iterator)localObject1).next()).alive();
    }
    com.tencent.mm.plugin.appbrand.floatball.c.bhr();
    localObject1 = be.jLw.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a((String)localObject2, this.jHJ, true);
    }
    t.b.CA();
    x.a.CA();
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().c(this.jHt);
    aZj();
    jGZ = new com.tencent.mm.plugin.appbrand.appstorage.d(jHh);
    jHa = new com.tencent.mm.plugin.appbrand.config.d(jHh);
    jHb = new bh(jHh);
    jHc = new y(jHh);
    jHe = new aw(jHh);
    jHf = new com.tencent.mm.plugin.appbrand.widget.g(jHh);
    jHg = new com.tencent.mm.plugin.appbrand.widget.j(jHh);
    jHi = new com.tencent.mm.plugin.appbrand.widget.o(jHh);
    jHj = new com.tencent.mm.ah.a.d(jHh);
    jHk = new com.tencent.mm.plugin.appbrand.x.a(jHh);
    jHl = new ag(jHh);
    jHm = new com.tencent.mm.plugin.appbrand.game.b.a.b(jHh);
    jHn = new bb(jHh);
    jHo = new ax();
    jHp = new bm();
    jHq = new com.tencent.mm.plugin.appbrand.task.a.c(jHh);
    aZl();
    a.a(jHh);
    com.tencent.mm.plugin.appbrand.k.setup();
    v.beQ();
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon().a(-86016, new j.11(this));
    com.tencent.mm.kernel.g.ajQ().a(this.hWv);
    com.tencent.mm.plugin.appbrand.dynamic.g.initialize();
    com.tencent.mm.model.c.d.aDI().add(this.hMo);
    this.jHP.alive();
    com.tencent.mm.pluginsdk.cmd.b.a(new j.a((byte)0), new String[] { "//xwebdebug" });
    com.tencent.mm.plugin.appbrand.config.g.init();
    localObject1 = this.jHO;
    AppBrandGuideUI.a.bAa().registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject1);
    AppBrandStickyBannerLogic.b.d((com.tencent.mm.plugin.appbrand.ui.banner.f)localObject1);
    ((AppBrandGuideUI.a)localObject1).mGG = false;
    com.tencent.mm.plugin.appbrand.floatball.g.bhy();
    com.tencent.mm.plugin.appbrand.floatball.h.bhy();
    com.tencent.mm.plugin.appbrand.keylogger.g.brh();
    AppMethodBeat.o(44200);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(44201);
    ae.d("MicroMsg.SubCoreAppBrand", "onAccountRelease");
    if (this.jHu != null)
    {
      this.jHu.dead();
      this.jHu = null;
    }
    ??? = this.jHw.iterator();
    while (((Iterator)???).hasNext()) {
      ((com.tencent.mm.sdk.b.c)((Iterator)???).next()).dead();
    }
    com.tencent.mm.plugin.appbrand.floatball.c.bhs();
    com.tencent.mm.plugin.appbrand.k.release();
    ??? = be.jLw.keySet().iterator();
    Object localObject2;
    while (((Iterator)???).hasNext())
    {
      localObject2 = (String)((Iterator)???).next();
      ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b((String)localObject2, this.jHJ, true);
    }
    t.b.unregister();
    x.a.unregister();
    ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().d(this.jHt);
    bj.shutdown();
    jGZ = null;
    jHd = null;
    jHa = null;
    jHb = null;
    jHc = null;
    jHe = null;
    jHf = null;
    jHg = null;
    jHi = null;
    jHj = null;
    jHk = null;
    jHl = null;
    jHm = null;
    jHn = null;
    jHo = null;
    jHp = null;
    jHq = null;
    a.aYR();
    if (jHs != null)
    {
      ??? = jHs;
      ((com.tencent.mm.plugin.appbrand.b.b)???).jXZ.clear();
      ((com.tencent.mm.plugin.appbrand.b.b)???).jYa.clear();
      jHs = null;
    }
    jHr = null;
    if (jHh != null)
    {
      jHh.ra(hashCode());
      jHh = null;
    }
    com.tencent.mm.plugin.appbrand.appusage.j.release();
    v.release();
    com.tencent.mm.plugin.appbrand.appcache.b.b.j.jNE.cleanup();
    com.tencent.mm.plugin.appbrand.utils.f.bCi();
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterIndexStorage(512);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterNativeLogic(7);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(144);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(4224);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterIndexStorage(8);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterNativeLogic(10);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(208);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(4240);
    com.tencent.mm.kernel.g.ajQ().b(this.hWv);
    com.tencent.mm.plugin.appbrand.dynamic.g.release();
    com.tencent.mm.model.c.d.aDI().remove(this.hMo);
    this.jHP.dead();
    com.tencent.mm.plugin.appbrand.config.g.release();
    ??? = this.jHO;
    AppBrandGuideUI.a.bAa().unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)???);
    AppBrandStickyBannerLogic.b.c((com.tencent.mm.plugin.appbrand.ui.banner.f)???);
    ((AppBrandGuideUI.a)???).mGG = false;
    ??? = com.tencent.mm.plugin.appbrand.appstorage.h.jPD;
    com.tencent.mm.kernel.g.ajP();
    long l = new com.tencent.mm.b.p(com.tencent.mm.kernel.a.getUin()).longValue();
    synchronized (com.tencent.mm.plugin.appbrand.appstorage.h.bca())
    {
      com.tencent.mm.plugin.appbrand.appstorage.h.bca().remove(Long.valueOf(l));
      ae.i("AppBrandMMKVStorage", "onAccountRelease remove cache uin:".concat(String.valueOf(l)));
      localObject2 = z.Nhr;
      com.tencent.mm.plugin.appbrand.floatball.g.bhz();
      com.tencent.mm.plugin.appbrand.floatball.h.bhz();
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