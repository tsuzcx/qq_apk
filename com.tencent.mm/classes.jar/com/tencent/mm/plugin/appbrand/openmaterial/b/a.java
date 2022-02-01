package com.tencent.mm.plugin.appbrand.openmaterial.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ng;
import com.tencent.mm.g.b.a.ny;
import com.tencent.mm.g.b.a.nz;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l;
import kotlin.m;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/openmaterial/report/AppBrandOpenMaterialReporter;", "", "scene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;)V", "appBrandBottomSheetShownNum", "", "getAppBrandBottomSheetShownNum", "()J", "appBrandBottomSheetShownNum$delegate", "Lkotlin/Lazy;", "appBrandExposureReporter", "Lcom/tencent/mm/autogen/mmdata/rpt/wechat_use_weapp_exposeStruct;", "kotlin.jvm.PlatformType", "getAppBrandExposureReporter", "()Lcom/tencent/mm/autogen/mmdata/rpt/wechat_use_weapp_exposeStruct;", "appBrandExposureReporter$delegate", "appBrandListPageShownNum", "getAppBrandListPageShownNum", "appBrandListPageShownNum$delegate", "bottomSheetActionReporter", "Lcom/tencent/mm/autogen/mmdata/rpt/WeChat_use_weapp_openStruct;", "getBottomSheetActionReporter", "()Lcom/tencent/mm/autogen/mmdata/rpt/WeChat_use_weapp_openStruct;", "bottomSheetActionReporter$delegate", "bottomSheetExposedAppBrands", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialModel;", "Lkotlin/collections/HashSet;", "bottomSheetListPageEntranceExposed", "", "listPageActionReporter", "Lcom/tencent/mm/autogen/mmdata/rpt/wechat_use_weapp_clickStruct;", "getListPageActionReporter", "()Lcom/tencent/mm/autogen/mmdata/rpt/wechat_use_weapp_clickStruct;", "listPageActionReporter$delegate", "listPageExposedAppBrands", "myTag", "", "getMyTag", "()Ljava/lang/String;", "myTag$delegate", "sessionId", "convertScene4Report", "onBottomSheetAppBrandClick", "", "openMaterialModel", "onBottomSheetAppBrandExposure", "onBottomSheetListPageEntranceExposure", "onBottomSheetMoreClick", "onBottomSheetShow", "isGrid", "onLaunchListPageDirectly", "onListPageAppBrandClick", "onListPageAppBrandExposure", "plugin-appbrand-integration_release"})
public final class a
{
  public final b nkA;
  public final AppBrandOpenMaterialCollection nkx;
  private final f nlT;
  private final f nlU;
  public final f nlV;
  private final f nlW;
  private final f nlX;
  public final f nlY;
  public final HashSet<AppBrandOpenMaterialModel> nlZ;
  public final HashSet<AppBrandOpenMaterialModel> nma;
  public boolean nmb;
  final String sessionId;
  
  public a(b paramb, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection)
  {
    AppMethodBeat.i(229203);
    this.nkA = paramb;
    this.nkx = paramAppBrandOpenMaterialCollection;
    this.nlT = g.a(k.SWR, (kotlin.g.a.a)new f(this));
    this.sessionId = ad.JX("OpenMaterial#" + this.nkA.name());
    this.nlU = g.a(k.SWR, (kotlin.g.a.a)new d(this));
    this.nlV = g.a(k.SWR, (kotlin.g.a.a)new e(this));
    this.nlW = g.a(k.SWR, (kotlin.g.a.a)new b(this));
    this.nlX = g.a(k.SWR, (kotlin.g.a.a)new a(this));
    this.nlY = g.a(k.SWR, (kotlin.g.a.a)new c(this));
    this.nlZ = new HashSet();
    this.nma = new HashSet();
    AppMethodBeat.o(229203);
  }
  
  public static long d(b paramb)
  {
    AppMethodBeat.i(229202);
    switch (b.$EnumSwitchMapping$0[paramb.ordinal()])
    {
    default: 
      paramb = new m();
      AppMethodBeat.o(229202);
      throw paramb;
    case 1: 
      AppMethodBeat.o(229202);
      return 1L;
    case 2: 
      AppMethodBeat.o(229202);
      return 2L;
    case 3: 
      AppMethodBeat.o(229202);
      return 3L;
    }
    AppMethodBeat.o(229202);
    return 4L;
  }
  
  public final String bQh()
  {
    AppMethodBeat.i(229197);
    String str = (String)this.nlT.getValue();
    AppMethodBeat.o(229197);
    return str;
  }
  
  public final ng bQi()
  {
    AppMethodBeat.i(229198);
    ng localng = (ng)this.nlU.getValue();
    AppMethodBeat.o(229198);
    return localng;
  }
  
  public final nz bQj()
  {
    AppMethodBeat.i(229199);
    nz localnz = (nz)this.nlW.getValue();
    AppMethodBeat.o(229199);
    return localnz;
  }
  
  public final long bQk()
  {
    AppMethodBeat.i(229200);
    long l = ((Number)this.nlX.getValue()).longValue();
    AppMethodBeat.o(229200);
    return l;
  }
  
  public final void bQl()
  {
    AppMethodBeat.i(229201);
    Log.i(bQh(), "onBottomSheetMoreClick");
    bQi().xE(3L).xF(d(this.nkA)).xG(bQk()).xH(0L).bfK();
    AppMethodBeat.o(229201);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<Long>
  {
    a(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/autogen/mmdata/rpt/wechat_use_weapp_exposeStruct;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<nz>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Long>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/autogen/mmdata/rpt/WeChat_use_weapp_openStruct;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<ng>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/autogen/mmdata/rpt/wechat_use_weapp_clickStruct;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<ny>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<String>
  {
    f(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.b.a
 * JD-Core Version:    0.7.0.1
 */