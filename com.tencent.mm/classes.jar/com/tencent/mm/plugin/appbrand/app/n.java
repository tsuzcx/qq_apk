package com.tencent.mm.plugin.appbrand.app;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.luggage.sdk.processes.client.LuggageClientProcessMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.abl;
import com.tencent.mm.autogen.a.abz;
import com.tencent.mm.autogen.a.cu;
import com.tencent.mm.autogen.a.gh;
import com.tencent.mm.autogen.a.no;
import com.tencent.mm.autogen.a.ny;
import com.tencent.mm.autogen.a.oo;
import com.tencent.mm.autogen.a.th;
import com.tencent.mm.autogen.a.x;
import com.tencent.mm.model.be;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.network.p.a;
import com.tencent.mm.platformtools.o.a;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bp;
import com.tencent.mm.plugin.appbrand.appcache.bq;
import com.tencent.mm.plugin.appbrand.appcache.bt;
import com.tencent.mm.plugin.appbrand.appusage.s.b;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfigResUpdateListener;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.ac;
import com.tencent.mm.plugin.appbrand.config.ad;
import com.tencent.mm.plugin.appbrand.config.af;
import com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.AppBrandMonitoredBluetoothDeviceService;
import com.tencent.mm.plugin.appbrand.jsapi.audio.WxAudioCheckResUpdateListener;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchFromOuterEventListener;
import com.tencent.mm.plugin.appbrand.launching.aj;
import com.tencent.mm.plugin.appbrand.launching.an;
import com.tencent.mm.plugin.appbrand.launching.ao;
import com.tencent.mm.plugin.appbrand.task.ipc.AppBrandNetworkChangeMessage;
import com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.a;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.b;
import com.tencent.mm.plugin.appbrand.widget.u;
import com.tencent.mm.protocal.j.a;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.by.a;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.wexnet.XNetLibResUpdateCacheFileEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import kotlin.ah;

public final class n
  implements be
{
  private static volatile com.tencent.mm.plugin.appbrand.appstorage.g qCG;
  private static volatile com.tencent.mm.plugin.appbrand.config.e qCH;
  private static volatile bm qCI;
  private static volatile bg qCJ;
  private static volatile w qCK;
  private static volatile af qCL;
  private static volatile aj qCM;
  private static volatile com.tencent.mm.plugin.appbrand.widget.i qCN;
  private static volatile com.tencent.mm.plugin.appbrand.widget.o qCO;
  private static volatile o.a qCP;
  private static volatile u qCQ;
  private static volatile com.tencent.mm.message.c.e qCR;
  private static volatile com.tencent.mm.plugin.appbrand.ae.a qCS;
  private static volatile ai qCT;
  private static volatile com.tencent.mm.plugin.appbrand.game.b.a.b qCU;
  private static volatile com.tencent.mm.plugin.appbrand.launching.aq qCV;
  private static volatile ao qCW;
  private static volatile bb qCX;
  private static volatile bt qCY;
  private static volatile com.tencent.mm.plugin.appbrand.task.a.c qCZ;
  private static com.tencent.mm.plugin.appbrand.c.c qDa;
  private static com.tencent.mm.plugin.appbrand.c.b qDb;
  private final IListener<ny> logoutListener;
  private final com.tencent.mm.network.p oAk;
  private MStorage.IOnStorageChange ooR;
  private by.a qDc;
  private com.tencent.mm.vending.b.b qDd;
  private final com.tencent.mm.plugin.auth.a.b qDe;
  private final Set<IListener<?>> qDf;
  private final IListener<abz> qDg;
  private final IListener<oo> qDh;
  private final IListener<th> qDi;
  private final IListener<com.tencent.mm.autogen.a.o> qDj;
  private final IListener<com.tencent.mm.autogen.a.v> qDk;
  private final IListener<com.tencent.mm.autogen.a.t> qDl;
  private final IListener<abl> qDm;
  private final IListener<com.tencent.mm.autogen.a.n> qDn;
  private final IListener<com.tencent.mm.autogen.a.s> qDo;
  private final IListener<cu> qDp;
  private final IListener<no> qDq;
  private final cl.a qDr;
  private IListener qDs;
  private IListener qDt;
  private final IListener<com.tencent.mm.autogen.a.n> qDu;
  private final IListener<x> qDv;
  private final WxAudioCheckResUpdateListener qDw;
  private final AppBrandGuideUI.a qDx;
  private final IListener<gh> qDy;
  
  public n()
  {
    AppMethodBeat.i(44202);
    this.qDc = new com.tencent.mm.plugin.appbrand.aa.a();
    this.qDd = null;
    this.qDe = new com.tencent.mm.plugin.auth.a.b()
    {
      public final void onAuthResponse(j.h paramAnonymoush, j.i paramAnonymousi, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(317688);
        if ((paramAnonymousi != null) && ((paramAnonymousi instanceof j.g)))
        {
          com.tencent.mm.plugin.appbrand.appusage.i.ciJ().ciK();
          ax.ij(true);
        }
        if ((paramAnonymousBoolean) && ((paramAnonymoush instanceof j.a)) && (paramAnonymoush.getSceneStatus() == 12)) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            ax.ij(true);
          }
          if (((!(paramAnonymoush instanceof j.f)) || (paramAnonymoush.getSceneStatus() != 1)) && ((paramAnonymoush instanceof j.a))) {
            paramAnonymoush.getSceneStatus();
          }
          AppMethodBeat.o(317688);
          return;
        }
      }
      
      public final void onRegResponse(x.b paramAnonymousb, String paramAnonymousString1, int paramAnonymousInt1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt2) {}
    };
    this.logoutListener = new SubCoreAppBrand.23(this, com.tencent.mm.app.f.hfK);
    this.qDg = new SubCoreAppBrand.24(this, com.tencent.mm.app.f.hfK);
    this.qDh = new SubCoreAppBrand.25(this, com.tencent.mm.app.f.hfK);
    this.qDi = new SubCoreAppBrand.26(this, com.tencent.mm.app.f.hfK);
    this.qDj = new SubCoreAppBrand.27(this, com.tencent.mm.app.f.hfK);
    this.qDk = new SubCoreAppBrand.28(this, com.tencent.mm.app.f.hfK);
    this.qDl = new SubCoreAppBrand.29(this, com.tencent.mm.app.f.hfK);
    this.qDm = new SubCoreAppBrand.30(this, com.tencent.mm.app.f.hfK);
    this.qDn = new SubCoreAppBrand.31(this, com.tencent.mm.app.f.hfK);
    this.qDo = new SubCoreAppBrand.32(this, com.tencent.mm.app.f.hfK);
    this.qDp = new SubCoreAppBrand.33(this, com.tencent.mm.app.f.hfK);
    this.qDq = new SubCoreAppBrand.34(this, com.tencent.mm.app.f.hfK);
    this.qDr = new bj();
    this.oAk = new p.a()
    {
      public final void onNetworkChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(317698);
        if (MMApplicationContext.isMainProcess())
        {
          Object localObject2 = (Iterable)com.tencent.mm.plugin.appbrand.task.i.cJV().asg();
          Object localObject1 = (Collection)new ArrayList();
          localObject2 = ((Iterable)localObject2).iterator();
          Object localObject3;
          label88:
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = ((Iterator)localObject2).next();
            if (!((com.tencent.mm.plugin.appbrand.task.d)localObject3).arY()) {}
            for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
            {
              if (paramAnonymousInt == 0) {
                break label88;
              }
              ((Collection)localObject1).add(localObject3);
              break;
            }
          }
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.appbrand.task.d)((Iterator)localObject1).next();
            localObject3 = ((Iterable)((com.tencent.mm.plugin.appbrand.task.d)localObject2).arZ()).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              String str = (String)((Iterator)localObject3).next();
              com.tencent.luggage.sdk.processes.c.a((com.tencent.luggage.sdk.processes.c)localObject2, (LuggageClientProcessMessage)new AppBrandNetworkChangeMessage(str));
            }
          }
        }
        com.tencent.mm.plugin.appbrand.appcache.predownload.b.m.qJG.chu();
        AppMethodBeat.o(317698);
      }
    };
    this.qDs = new SubCoreAppBrand.36(this, com.tencent.mm.app.f.hfK);
    this.qDt = new SubCoreAppBrand.37(this, com.tencent.mm.app.f.hfK);
    this.qDu = new SubCoreAppBrand.38(this, com.tencent.mm.app.f.hfK);
    this.qDv = new SubCoreAppBrand.39(this, com.tencent.mm.app.f.hfK);
    this.qDw = new WxAudioCheckResUpdateListener();
    this.qDx = new AppBrandGuideUI.a();
    this.ooR = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(317690);
        if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString)))
        {
          n.cfx();
          n.cfy();
          n.cfz();
          n.cfA();
          n.cfB();
        }
        AppMethodBeat.o(317690);
      }
    };
    this.qDy = new SubCoreAppBrand.41(this, com.tencent.mm.app.f.hfK);
    this.qDf = new HashSet();
    this.qDf.add(this.qDn);
    this.qDf.add(new AppBrandLaunchFromOuterEventListener());
    this.qDf.add(this.qDo);
    this.qDf.add(this.qDh);
    this.qDf.add(this.qDi);
    this.qDf.add(this.qDg);
    this.qDf.add(new AppBrandGlobalSystemConfigResUpdateListener());
    this.qDf.add(this.logoutListener);
    this.qDf.add(com.tencent.mm.plugin.appbrand.appusage.h.qOw);
    this.qDf.add(this.qDj);
    this.qDf.add(this.qDk);
    this.qDf.add(this.qDl);
    this.qDf.add(this.qDm);
    this.qDf.add(this.qDp);
    this.qDf.add(this.qDq);
    this.qDf.add(this.qDs);
    this.qDf.add(this.qDt);
    this.qDf.add(this.qDu);
    this.qDf.add(this.qDv);
    this.qDf.add(this.qDw);
    this.qDf.add(new XNetLibResUpdateCacheFileEvent());
    AppMethodBeat.o(44202);
  }
  
  public static <T> T ag(Class<T> paramClass)
  {
    AppMethodBeat.i(44209);
    if (paramClass == w.class)
    {
      paramClass = qCK;
      AppMethodBeat.o(44209);
      return paramClass;
    }
    if ((paramClass == ac.class) || (paramClass == af.class))
    {
      paramClass = cfc();
      AppMethodBeat.o(44209);
      return paramClass;
    }
    paramClass = b.ag(paramClass);
    AppMethodBeat.o(44209);
    return paramClass;
  }
  
  public static com.tencent.mm.plugin.appbrand.appstorage.g aqR()
  {
    return qCG;
  }
  
  public static com.tencent.mm.plugin.appbrand.config.e aqS()
  {
    AppMethodBeat.i(44205);
    if ((qCH == null) && (qCP != null) && (!qCP.isClose())) {
      qCH = new com.tencent.mm.plugin.appbrand.config.e(qCP);
    }
    com.tencent.mm.plugin.appbrand.config.e locale = qCH;
    AppMethodBeat.o(44205);
    return locale;
  }
  
  private HashMap<Integer, h.b> ceX()
  {
    AppMethodBeat.i(44197);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("AppKVStorageDBCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.appstorage.g.SQL_CREATE;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandWxaPkgStorageDBCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return bm.qGS;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandWxaPkgManifestRecordWithDesc".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return bg.qGS;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandCommonConfigStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.config.e.nVW;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandLayoutStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return w.nVW;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandStarAppStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.appusage.t.nVW;
      }
    });
    localHashMap.put(Integer.valueOf("WxaAttributesTableCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(317686);
        String str = MAutoStorage.getCreateSQLs(WxaAttributes.DB_INFO, "WxaAttributesTable");
        AppMethodBeat.o(317686);
        return new String[] { str };
      }
    });
    localHashMap.put(Integer.valueOf("LaunchWxaAppInfoCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return new String[] { aj.tbu };
      }
    });
    localHashMap.put(Integer.valueOf("DynamicMsgCacheDataCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.widget.i.nVW;
      }
    });
    localHashMap.put(Integer.valueOf("LaunchWxaWidgetCacheCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return new String[] { com.tencent.mm.plugin.appbrand.widget.o.tbu };
      }
    });
    localHashMap.put(Integer.valueOf("WxaWidgetInfoStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return u.nVW;
      }
    });
    localHashMap.put(Integer.valueOf("WxaUpdateableMsgStorageCreate".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.message.c.e.nVW;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandCommonKVBinaryDataStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.ae.a.nVW;
      }
    });
    localHashMap.put(Integer.valueOf("PkgUpdateStatsStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ai.nVW;
      }
    });
    localHashMap.put(Integer.valueOf("MiniGameInfoStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.game.b.a.b.nVW;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandRecommendCardStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.appusage.a.b.nVW;
      }
    });
    localHashMap.put(Integer.valueOf("LaunchWxaJsApiPluginInfoStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.launching.aq.nVW;
      }
    });
    localHashMap.put(Integer.valueOf("LaunchWxaAppidABTestInfoStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return an.nVW;
      }
    });
    localHashMap.put(Integer.valueOf("AppBrandTaskWxaCheckDemoInfoStorage".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return com.tencent.mm.plugin.appbrand.task.a.c.nVW;
      }
    });
    Iterator localIterator = b.qBg.entrySet().iterator();
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
  
  public static o.a ceY()
  {
    return qCP;
  }
  
  public static n ceZ()
  {
    AppMethodBeat.i(44198);
    Object localObject = (com.tencent.mm.plugin.appbrand.api.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.appbrand.api.c.class);
    if (localObject != null) {}
    for (localObject = ((PluginAppBrand)localObject).getCore();; localObject = null)
    {
      AppMethodBeat.o(44198);
      return localObject;
    }
  }
  
  public static AppBrandGuideUI.a cfb()
  {
    AppMethodBeat.i(44203);
    if (ceZ() == null)
    {
      AppMethodBeat.o(44203);
      return null;
    }
    AppBrandGuideUI.a locala = ceZ().qDx;
    AppMethodBeat.o(44203);
    return locala;
  }
  
  public static af cfc()
  {
    AppMethodBeat.i(44204);
    try
    {
      if (((qCL == null) || (!qCL.ckW())) && (qCP != null) && (!qCP.isClose())) {
        qCL = new af(qCP);
      }
      af localaf = qCL;
      AppMethodBeat.o(44204);
      return localaf;
    }
    finally
    {
      AppMethodBeat.o(44204);
    }
  }
  
  public static aj cfd()
  {
    return qCM;
  }
  
  public static com.tencent.mm.plugin.appbrand.widget.o cfe()
  {
    return qCO;
  }
  
  public static com.tencent.mm.plugin.appbrand.launching.aq cff()
  {
    return qCV;
  }
  
  public static ao cfg()
  {
    return qCW;
  }
  
  public static com.tencent.mm.plugin.appbrand.task.a.c cfh()
  {
    return qCZ;
  }
  
  public static u cfi()
  {
    return qCQ;
  }
  
  public static com.tencent.mm.message.c.e cfj()
  {
    return qCR;
  }
  
  public static w cfk()
  {
    return qCK;
  }
  
  @Deprecated
  public static com.tencent.mm.plugin.appbrand.appusage.t cfl()
  {
    AppMethodBeat.i(44206);
    com.tencent.mm.plugin.appbrand.appusage.t localt = (com.tencent.mm.plugin.appbrand.appusage.t)ag(com.tencent.mm.plugin.appbrand.appusage.t.class);
    AppMethodBeat.o(44206);
    return localt;
  }
  
  public static bm cfm()
  {
    return qCI;
  }
  
  public static bg cfn()
  {
    return qCJ;
  }
  
  public static com.tencent.mm.plugin.appbrand.widget.i cfo()
  {
    return qCN;
  }
  
  public static com.tencent.mm.plugin.appbrand.c.c cfp()
  {
    AppMethodBeat.i(44207);
    if (qDa == null) {
      qDa = new com.tencent.mm.plugin.appbrand.c.c();
    }
    com.tencent.mm.plugin.appbrand.c.c localc = qDa;
    AppMethodBeat.o(44207);
    return localc;
  }
  
  public static com.tencent.mm.plugin.appbrand.c.b cfq()
  {
    AppMethodBeat.i(44208);
    if (qDb == null) {
      qDb = new com.tencent.mm.plugin.appbrand.c.b();
    }
    com.tencent.mm.plugin.appbrand.c.b localb = qDb;
    AppMethodBeat.o(44208);
    return localb;
  }
  
  public static com.tencent.mm.plugin.appbrand.ae.a cfr()
  {
    return qCS;
  }
  
  public static ai cfs()
  {
    return qCT;
  }
  
  public static bb cft()
  {
    return qCX;
  }
  
  public static bt cfu()
  {
    return qCY;
  }
  
  public static com.tencent.mm.plugin.appbrand.backgroundfetch.d cfv()
  {
    AppMethodBeat.i(44210);
    com.tencent.mm.plugin.appbrand.backgroundfetch.d locald = (com.tencent.mm.plugin.appbrand.backgroundfetch.d)ag(com.tencent.mm.plugin.appbrand.backgroundfetch.d.class);
    AppMethodBeat.o(44210);
    return locald;
  }
  
  public static com.tencent.mm.plugin.appbrand.backgroundfetch.g cfw()
  {
    AppMethodBeat.i(44211);
    com.tencent.mm.plugin.appbrand.backgroundfetch.g localg = (com.tencent.mm.plugin.appbrand.backgroundfetch.g)ag(com.tencent.mm.plugin.appbrand.backgroundfetch.g.class);
    AppMethodBeat.o(44211);
    return localg;
  }
  
  public final o.a cfa()
  {
    AppMethodBeat.i(44199);
    Object localObject = com.tencent.mm.kernel.h.baE().cachePath + "AppBrandComm.db";
    if ((qCP != null) && (((String)localObject).equals(qCP.getPath())))
    {
      localObject = qCP;
      AppMethodBeat.o(44199);
      return localObject;
    }
    localObject = com.tencent.mm.platformtools.o.a(hashCode(), (String)localObject, ceX(), true);
    qCP = (o.a)localObject;
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
    this.qDd = ((com.tencent.mm.plugin.auth.a.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(this.qDe);
    Object localObject2 = MMApplicationContext.getContext().getSharedPreferences("app_brand_global_sp", 0);
    if (localObject2 != null)
    {
      localObject1 = ((SharedPreferences)localObject2).getStringSet("uin_set", new HashSet());
      if (localObject1 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        com.tencent.mm.kernel.h.baC();
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
    Object localObject1 = this.qDf.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((IListener)((Iterator)localObject1).next()).alive();
    }
    com.tencent.mm.plugin.appbrand.floatball.c.con();
    localObject1 = bj.qHi.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a((String)localObject2, this.qDr, true);
    }
    s.b.aoW();
    localObject1 = com.tencent.mm.plugin.appbrand.appusage.aq.qQD;
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("UpdateWxaUsageListNotify", (cl.a)localObject1, true);
    com.tencent.mm.plugin.appbrand.appusage.aq.appForegroundListener.alive();
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().b(this.qDc);
    cfa();
    qCG = new com.tencent.mm.plugin.appbrand.appstorage.g(qCP);
    qCH = new com.tencent.mm.plugin.appbrand.config.e(qCP);
    qCI = new bm(qCP);
    qCJ = new bg(qCP);
    ((PluginAppBrand)com.tencent.mm.kernel.h.az(PluginAppBrand.class)).setWxaPkgStorageRouter(new bp(qCI, qCJ));
    qCK = new w(qCP);
    qCM = new aj(qCP);
    qCN = new com.tencent.mm.plugin.appbrand.widget.i(qCP);
    qCO = new com.tencent.mm.plugin.appbrand.widget.o(qCP);
    qCQ = new u(qCP);
    qCR = new com.tencent.mm.message.c.e(qCP);
    qCS = new com.tencent.mm.plugin.appbrand.ae.a(qCP);
    qCT = new ai(qCP);
    qCU = new com.tencent.mm.plugin.appbrand.game.b.a.b(qCP);
    qCV = new com.tencent.mm.plugin.appbrand.launching.aq(qCP);
    qCW = new ao(qCP);
    qCX = new bb();
    qCY = new bt();
    qCZ = new com.tencent.mm.plugin.appbrand.task.a.c(qCP);
    cfc();
    b.a(qCP);
    com.tencent.mm.plugin.appbrand.o.setup();
    ad.ckY();
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon().a(-86016, new n.14(this));
    com.tencent.mm.kernel.h.baD().a(this.oAk);
    com.tencent.mm.plugin.appbrand.dynamic.g.initialize();
    com.tencent.mm.model.newabtest.d.bEt().add(this.ooR);
    this.qDy.alive();
    com.tencent.mm.pluginsdk.cmd.b.a(new n.a((byte)0), new String[] { "//xwebdebug" });
    com.tencent.mm.plugin.appbrand.config.h.init();
    localObject1 = this.qDx;
    AppBrandGuideUI.a.cKQ().registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)localObject1);
    AppBrandStickyBannerLogic.b.d((com.tencent.mm.plugin.appbrand.ui.banner.f)localObject1);
    ((AppBrandGuideUI.a)localObject1).uaK = false;
    com.tencent.mm.plugin.appbrand.floatball.g.cou();
    com.tencent.mm.plugin.appbrand.floatball.h.cou();
    com.tencent.mm.plugin.appbrand.keylogger.g.czw();
    localObject1 = AppBrandMonitoredBluetoothDeviceService.rgb;
    AppBrandMonitoredBluetoothDeviceService.cml();
    AppMethodBeat.o(44200);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(44201);
    Log.d("MicroMsg.SubCoreAppBrand", "onAccountRelease");
    if (this.qDd != null)
    {
      this.qDd.dead();
      this.qDd = null;
    }
    ??? = this.qDf.iterator();
    while (((Iterator)???).hasNext()) {
      ((IListener)((Iterator)???).next()).dead();
    }
    com.tencent.mm.plugin.appbrand.floatball.c.coo();
    com.tencent.mm.plugin.appbrand.o.release();
    ??? = bj.qHi.keySet().iterator();
    Object localObject2;
    while (((Iterator)???).hasNext())
    {
      localObject2 = (String)((Iterator)???).next();
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b((String)localObject2, this.qDr, true);
    }
    s.b.unregister();
    ??? = com.tencent.mm.plugin.appbrand.appusage.aq.qQD;
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("UpdateWxaUsageListNotify", (cl.a)???, true);
    com.tencent.mm.plugin.appbrand.appusage.aq.appForegroundListener.dead();
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().c(this.qDc);
    bq.shutdown();
    qCG = null;
    qCL = null;
    qCH = null;
    qCI = null;
    qCJ = null;
    qCK = null;
    qCM = null;
    qCN = null;
    qCO = null;
    qCQ = null;
    qCR = null;
    qCS = null;
    qCT = null;
    qCU = null;
    qCV = null;
    qCW = null;
    qCX = null;
    qCY = null;
    qCZ = null;
    b.ceu();
    if (qDb != null)
    {
      ??? = qDb;
      ((com.tencent.mm.plugin.appbrand.c.b)???).qUQ.clear();
      ((com.tencent.mm.plugin.appbrand.c.b)???).qUR.clear();
      qDb = null;
    }
    qDa = null;
    if (qCP != null)
    {
      qCP.yb(hashCode());
      qCP = null;
    }
    com.tencent.mm.plugin.appbrand.appusage.i.release();
    ad.release();
    com.tencent.mm.plugin.appbrand.appcache.predownload.b.m.qJG.cleanup();
    com.tencent.mm.plugin.appbrand.utils.l.cNl();
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).unregisterIndexStorage(512);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).unregisterNativeLogic(7);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(144);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(4224);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).unregisterIndexStorage(8);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).unregisterNativeLogic(10);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(208);
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(4240);
    com.tencent.mm.kernel.h.baD().b(this.oAk);
    com.tencent.mm.plugin.appbrand.dynamic.g.release();
    com.tencent.mm.model.newabtest.d.bEt().remove(this.ooR);
    this.qDy.dead();
    com.tencent.mm.plugin.appbrand.config.h.release();
    ??? = this.qDx;
    AppBrandGuideUI.a.cKQ().unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)???);
    AppBrandStickyBannerLogic.b.c((com.tencent.mm.plugin.appbrand.ui.banner.f)???);
    ((AppBrandGuideUI.a)???).uaK = false;
    ??? = com.tencent.mm.plugin.appbrand.appstorage.l.qMo;
    com.tencent.mm.kernel.h.baC();
    long l = new com.tencent.mm.b.p(com.tencent.mm.kernel.b.getUin()).longValue();
    synchronized (com.tencent.mm.plugin.appbrand.appstorage.l.chW())
    {
      com.tencent.mm.plugin.appbrand.appstorage.l.chW().remove(Long.valueOf(l));
      Log.i("AppBrandMMKVStorage", kotlin.g.b.s.X("onAccountRelease remove cache uin:", Long.valueOf(l)));
      localObject2 = ah.aiuX;
      ??? = com.tencent.mm.plugin.appbrand.appstorage.c.qLN;
      com.tencent.mm.kernel.h.baC();
      l = new com.tencent.mm.b.p(com.tencent.mm.kernel.b.getUin()).longValue();
      Log.i("MicroMsg.AppBrandEncryptMMKVStorage", " onAccountRelease before clear cache uin:" + l + "   CACHE size=" + com.tencent.mm.plugin.appbrand.appstorage.c.chW().size() + "  MULTI_WRITE_MODE_CACHE size=" + com.tencent.mm.plugin.appbrand.appstorage.c.chV().size());
      synchronized (com.tencent.mm.plugin.appbrand.appstorage.c.chW())
      {
        localObject2 = com.tencent.mm.plugin.appbrand.appstorage.c.chW().entrySet().iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (kotlin.n.n.i((CharSequence)((Map.Entry)((Iterator)localObject2).next()).getKey(), (CharSequence)String.valueOf(l))) {
            ((Iterator)localObject2).remove();
          }
        }
      }
    }
    Object localObject5 = ah.aiuX;
    synchronized (com.tencent.mm.plugin.appbrand.appstorage.c.chV())
    {
      localObject5 = com.tencent.mm.plugin.appbrand.appstorage.c.chV().entrySet().iterator();
      while (((Iterator)localObject5).hasNext()) {
        if (kotlin.n.n.i((CharSequence)((Map.Entry)((Iterator)localObject5).next()).getKey(), (CharSequence)String.valueOf(l))) {
          ((Iterator)localObject5).remove();
        }
      }
    }
    ah localah = ah.aiuX;
    Log.i("MicroMsg.AppBrandEncryptMMKVStorage", " onAccountRelease after clear cache uin:" + l + "   CACHE size=" + com.tencent.mm.plugin.appbrand.appstorage.c.chW().size() + "  MULTI_WRITE_MODE_CACHE size=" + com.tencent.mm.plugin.appbrand.appstorage.c.chV().size());
    com.tencent.mm.plugin.appbrand.floatball.g.cov();
    com.tencent.mm.plugin.appbrand.floatball.h.cov();
    ??? = AppBrandMonitoredBluetoothDeviceService.rgb;
    AppBrandMonitoredBluetoothDeviceService.cmm();
    AppMethodBeat.o(44201);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.n
 * JD-Core Version:    0.7.0.1
 */