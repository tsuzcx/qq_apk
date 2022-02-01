package com.tencent.mm.plugin.appbrand.openmaterial.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ty;
import com.tencent.mm.autogen.mmdata.rpt.uw;
import com.tencent.mm.autogen.mmdata.rpt.ux;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.openmaterial.h;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.o;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/openmaterial/report/AppBrandOpenMaterialReporter;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialReporter;", "_openMaterialScene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "_openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "_sessionId", "", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;Ljava/lang/String;)V", "appBrandBottomSheetShownNum", "", "getAppBrandBottomSheetShownNum", "()J", "appBrandBottomSheetShownNum$delegate", "Lkotlin/Lazy;", "appBrandExposureReporter", "Lcom/tencent/mm/autogen/mmdata/rpt/wechat_use_weapp_exposeStruct;", "getAppBrandExposureReporter", "()Lcom/tencent/mm/autogen/mmdata/rpt/wechat_use_weapp_exposeStruct;", "appBrandExposureReporter$delegate", "appBrandListPageShownNum", "getAppBrandListPageShownNum", "appBrandListPageShownNum$delegate", "bottomSheetActionReporter", "Lcom/tencent/mm/autogen/mmdata/rpt/WeChat_use_weapp_openStruct;", "getBottomSheetActionReporter", "()Lcom/tencent/mm/autogen/mmdata/rpt/WeChat_use_weapp_openStruct;", "bottomSheetActionReporter$delegate", "bottomSheetExposedAppBrands", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialModel;", "Lkotlin/collections/HashSet;", "bottomSheetListPageEntranceExposed", "", "listPageActionReporter", "Lcom/tencent/mm/autogen/mmdata/rpt/wechat_use_weapp_clickStruct;", "getListPageActionReporter", "()Lcom/tencent/mm/autogen/mmdata/rpt/wechat_use_weapp_clickStruct;", "listPageActionReporter$delegate", "listPageExposedAppBrands", "myTag", "convertScene4Report", "scene", "getOpenMaterialCollection", "getOpenMaterialScene", "getSessionId", "onBottomSheetAppBrandClick", "", "openMaterialModel", "onBottomSheetAppBrandExposure", "onBottomSheetListPageEntranceExposure", "onBottomSheetMoreClick", "onBottomSheetShow", "onLaunchListPageDirectly", "onListPageAppBrandClick", "onListPageAppBrandExposure", "updateSessionId", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements h
{
  public String djQ;
  public String ilK;
  public final b tse;
  public final AppBrandOpenMaterialCollection tsf;
  private final j tsg;
  private final j tsh;
  private final j tsi;
  private final j tsj;
  private final j tsk;
  public final HashSet<AppBrandOpenMaterialModel> tsl;
  private final HashSet<AppBrandOpenMaterialModel> tsm;
  private boolean tsn;
  
  public a(b paramb, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, String paramString)
  {
    AppMethodBeat.i(323798);
    this.tse = paramb;
    this.tsf = paramAppBrandOpenMaterialCollection;
    this.ilK = paramString;
    this.djQ = s.X("MicroMsg.AppBrand.AppBrandOpenMaterialReporter#", this.ilK);
    this.tsg = k.a(o.aiuH, (kotlin.g.a.a)e.tsq);
    this.tsh = k.a(o.aiuH, (kotlin.g.a.a)f.tsr);
    this.tsi = k.a(o.aiuH, (kotlin.g.a.a)c.tsp);
    this.tsj = k.a(o.aiuH, (kotlin.g.a.a)new b(this));
    this.tsk = k.a(o.aiuH, (kotlin.g.a.a)new d(this));
    this.tsl = new HashSet();
    this.tsm = new HashSet();
    AppMethodBeat.o(323798);
  }
  
  public static long d(b paramb)
  {
    AppMethodBeat.i(323815);
    switch (a.$EnumSwitchMapping$0[paramb.ordinal()])
    {
    default: 
      paramb = new kotlin.p();
      AppMethodBeat.o(323815);
      throw paramb;
    case 1: 
      AppMethodBeat.o(323815);
      return 1L;
    case 2: 
      AppMethodBeat.o(323815);
      return 2L;
    case 3: 
      AppMethodBeat.o(323815);
      return 3L;
    }
    AppMethodBeat.o(323815);
    return 4L;
  }
  
  public final void b(AppBrandOpenMaterialModel paramAppBrandOpenMaterialModel)
  {
    AppMethodBeat.i(323858);
    s.u(paramAppBrandOpenMaterialModel, "openMaterialModel");
    Log.i(this.djQ, "onListPageAppBrandClick");
    Object localObject = this.tsf.trP;
    s.s(localObject, "_openMaterialCollection.…dOpenMaterialDetailModels");
    long l = kotlin.a.p.a((List)localObject, paramAppBrandOpenMaterialModel) + 1;
    Log.d(this.djQ, s.X("onListPageAppBrandClick, index: ", Long.valueOf(l)));
    uw localuw = (uw)this.tsh.getValue();
    localuw.jFi = localuw.F("session", this.ilK, true);
    localuw.jFk = ((Number)this.tsk.getValue()).longValue();
    localuw.jFl = l;
    localuw.jIg = localuw.F("weapp_ID", paramAppBrandOpenMaterialModel.appId, true);
    localObject = paramAppBrandOpenMaterialModel.appName;
    paramAppBrandOpenMaterialModel = (AppBrandOpenMaterialModel)localObject;
    if (localObject == null) {
      paramAppBrandOpenMaterialModel = "";
    }
    localuw.jFn = localuw.F("weapp_name", paramAppBrandOpenMaterialModel, true);
    localuw.bMH();
    AppMethodBeat.o(323858);
  }
  
  public final void c(AppBrandOpenMaterialModel paramAppBrandOpenMaterialModel)
  {
    AppMethodBeat.i(323872);
    s.u(paramAppBrandOpenMaterialModel, "openMaterialModel");
    Log.i(this.djQ, "onListPageAppBrandExposure");
    if (this.tsm.contains(paramAppBrandOpenMaterialModel))
    {
      AppMethodBeat.o(323872);
      return;
    }
    Object localObject = cDw().Az(this.ilK);
    ((ux)localObject).jIh = 2L;
    ux localux = ((ux)localObject).AA(paramAppBrandOpenMaterialModel.appId);
    String str = paramAppBrandOpenMaterialModel.appName;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localux.AB((String)localObject).bMH();
    this.tsm.add(paramAppBrandOpenMaterialModel);
    AppMethodBeat.o(323872);
  }
  
  public final b cDo()
  {
    return this.tse;
  }
  
  public final void cDp()
  {
    try
    {
      AppMethodBeat.i(323843);
      Log.i(this.djQ, "updateSessionId");
      String str = ad.Jo(s.X("OpenMaterial#", this.tse.name()));
      s.s(str, "buildSessionId(\"OpenMate…openMaterialScene.name}\")");
      this.ilK = str;
      this.djQ = s.X("MicroMsg.AppBrand.AppBrandOpenMaterialReporter#", this.ilK);
      AppMethodBeat.o(323843);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void cDq()
  {
    AppMethodBeat.i(323851);
    Log.i(this.djQ, "onBottomSheetMoreClick");
    ty localty = cDv().Aa(this.ilK);
    localty.ime = 3L;
    localty.jFj = d(this.tse);
    localty.jFk = cDx();
    localty.jFl = 0L;
    localty.bMH();
    AppMethodBeat.o(323851);
  }
  
  public final void cDr()
  {
    AppMethodBeat.i(323853);
    Log.i(this.djQ, "onLaunchListPageDirectly");
    ty localty = cDv().Aa(this.ilK);
    localty.ime = 4L;
    localty.jFj = d(this.tse);
    localty.jFk = cDx();
    localty.jFl = 0L;
    localty.bMH();
    AppMethodBeat.o(323853);
  }
  
  public final void cDs()
  {
    AppMethodBeat.i(323862);
    Log.i(this.djQ, "onBottomSheetListPageEntranceExposure");
    if (this.tsn)
    {
      AppMethodBeat.o(323862);
      return;
    }
    ty localty = cDv().Aa(this.ilK);
    localty.ime = 2L;
    localty.jFj = d(this.tse);
    localty.jFk = cDx();
    localty.jFl = 0L;
    localty.bMH();
    this.tsn = true;
    AppMethodBeat.o(323862);
  }
  
  public final ty cDv()
  {
    AppMethodBeat.i(323821);
    ty localty = (ty)this.tsg.getValue();
    AppMethodBeat.o(323821);
    return localty;
  }
  
  public final ux cDw()
  {
    AppMethodBeat.i(323825);
    ux localux = (ux)this.tsi.getValue();
    AppMethodBeat.o(323825);
    return localux;
  }
  
  public final long cDx()
  {
    AppMethodBeat.i(323828);
    long l = ((Number)this.tsj.getValue()).longValue();
    AppMethodBeat.o(323828);
    return l;
  }
  
  public final void cDy()
  {
    AppMethodBeat.i(323849);
    Log.i(this.djQ, "onBottomSheetShow");
    ty localty = cDv().Aa(this.ilK);
    localty.ime = 1L;
    localty.jFj = d(this.tse);
    localty.jFk = cDx();
    localty.jFl = 0L;
    localty.bMH();
    if (b.trZ == this.tse)
    {
      localty = cDv().Aa(this.ilK);
      localty.ime = 5L;
      localty.jFj = d(this.tse);
      localty.jFk = cDx();
      localty.jFl = 0L;
      localty.bMH();
    }
    AppMethodBeat.o(323849);
  }
  
  public final String getSessionId()
  {
    return this.ilK;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Long>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/autogen/mmdata/rpt/wechat_use_weapp_exposeStruct;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ux>
  {
    public static final c tsp;
    
    static
    {
      AppMethodBeat.i(323799);
      tsp = new c();
      AppMethodBeat.o(323799);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Long>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/autogen/mmdata/rpt/WeChat_use_weapp_openStruct;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ty>
  {
    public static final e tsq;
    
    static
    {
      AppMethodBeat.i(323794);
      tsq = new e();
      AppMethodBeat.o(323794);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/autogen/mmdata/rpt/wechat_use_weapp_clickStruct;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<uw>
  {
    public static final f tsr;
    
    static
    {
      AppMethodBeat.i(323785);
      tsr = new f();
      AppMethodBeat.o(323785);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.b.a
 * JD-Core Version:    0.7.0.1
 */