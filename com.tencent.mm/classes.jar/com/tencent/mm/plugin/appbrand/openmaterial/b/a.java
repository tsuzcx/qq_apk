package com.tencent.mm.plugin.appbrand.openmaterial.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.qf;
import com.tencent.mm.f.b.a.qz;
import com.tencent.mm.f.b.a.ra;
import com.tencent.mm.model.ad;
import com.tencent.mm.plugin.appbrand.openmaterial.i;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialModel;
import com.tencent.mm.plugin.appbrand.openmaterial.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.k;
import kotlin.l;
import kotlin.m;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/openmaterial/report/AppBrandOpenMaterialReporter;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialReporter;", "_openMaterialScene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "_openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "_sessionId", "", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;Ljava/lang/String;)V", "appBrandBottomSheetShownNum", "", "getAppBrandBottomSheetShownNum", "()J", "appBrandBottomSheetShownNum$delegate", "Lkotlin/Lazy;", "appBrandExposureReporter", "Lcom/tencent/mm/autogen/mmdata/rpt/wechat_use_weapp_exposeStruct;", "getAppBrandExposureReporter", "()Lcom/tencent/mm/autogen/mmdata/rpt/wechat_use_weapp_exposeStruct;", "appBrandExposureReporter$delegate", "appBrandListPageShownNum", "getAppBrandListPageShownNum", "appBrandListPageShownNum$delegate", "bottomSheetActionReporter", "Lcom/tencent/mm/autogen/mmdata/rpt/WeChat_use_weapp_openStruct;", "getBottomSheetActionReporter", "()Lcom/tencent/mm/autogen/mmdata/rpt/WeChat_use_weapp_openStruct;", "bottomSheetActionReporter$delegate", "bottomSheetExposedAppBrands", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialModel;", "Lkotlin/collections/HashSet;", "bottomSheetListPageEntranceExposed", "", "listPageActionReporter", "Lcom/tencent/mm/autogen/mmdata/rpt/wechat_use_weapp_clickStruct;", "getListPageActionReporter", "()Lcom/tencent/mm/autogen/mmdata/rpt/wechat_use_weapp_clickStruct;", "listPageActionReporter$delegate", "listPageExposedAppBrands", "myTag", "convertScene4Report", "scene", "getOpenMaterialCollection", "getOpenMaterialScene", "getSessionId", "onBottomSheetAppBrandClick", "", "openMaterialModel", "onBottomSheetAppBrandExposure", "onBottomSheetListPageEntranceExposure", "onBottomSheetMoreClick", "onBottomSheetShow", "onLaunchListPageDirectly", "onListPageAppBrandClick", "onListPageAppBrandExposure", "updateSessionId", "plugin-appbrand-integration_release"})
public final class a
  implements i
{
  public String bqj;
  public String gfl;
  private final f qnA;
  private final f qnB;
  public final HashSet<AppBrandOpenMaterialModel> qnC;
  private final HashSet<AppBrandOpenMaterialModel> qnD;
  private boolean qnE;
  public final b qnF;
  public final AppBrandOpenMaterialCollection qnG;
  private final f qnx;
  private final f qny;
  private final f qnz;
  
  public a(b paramb, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, String paramString)
  {
    AppMethodBeat.i(274408);
    this.qnF = paramb;
    this.qnG = paramAppBrandOpenMaterialCollection;
    this.gfl = paramString;
    this.bqj = ("MicroMsg.AppBrand.AppBrandOpenMaterialReporter#" + this.gfl);
    this.qnx = g.a(k.aazD, (kotlin.g.a.a)a.d.qnJ);
    this.qny = g.a(k.aazD, (kotlin.g.a.a)a.e.qnK);
    this.qnz = g.a(k.aazD, (kotlin.g.a.a)a.b.qnI);
    this.qnA = g.a(k.aazD, (kotlin.g.a.a)new a.a(this));
    this.qnB = g.a(k.aazD, (kotlin.g.a.a)new a.c(this));
    this.qnC = new HashSet();
    this.qnD = new HashSet();
    AppMethodBeat.o(274408);
  }
  
  public static long d(b paramb)
  {
    AppMethodBeat.i(274407);
    switch (b.$EnumSwitchMapping$0[paramb.ordinal()])
    {
    default: 
      paramb = new m();
      AppMethodBeat.o(274407);
      throw paramb;
    case 1: 
      AppMethodBeat.o(274407);
      return 1L;
    case 2: 
      AppMethodBeat.o(274407);
      return 2L;
    case 3: 
      AppMethodBeat.o(274407);
      return 3L;
    }
    AppMethodBeat.o(274407);
    return 4L;
  }
  
  public final void a(AppBrandOpenMaterialModel paramAppBrandOpenMaterialModel)
  {
    AppMethodBeat.i(274403);
    p.k(paramAppBrandOpenMaterialModel, "openMaterialModel");
    Log.i(this.bqj, "onListPageAppBrandClick");
    Object localObject = this.qnG.qni;
    p.j(localObject, "_openMaterialCollection.…dOpenMaterialDetailModels");
    long l = j.a((List)localObject, paramAppBrandOpenMaterialModel) + 1;
    Log.d(this.bqj, "onListPageAppBrandClick, index: ".concat(String.valueOf(l)));
    qz localqz = ((qz)this.qny.getValue()).HR(this.gfl).Eu(((Number)this.qnB.getValue()).longValue()).Ev(l).HS(paramAppBrandOpenMaterialModel.appId);
    localObject = paramAppBrandOpenMaterialModel.appName;
    paramAppBrandOpenMaterialModel = (AppBrandOpenMaterialModel)localObject;
    if (localObject == null) {
      paramAppBrandOpenMaterialModel = "";
    }
    localqz.HT(paramAppBrandOpenMaterialModel).bpa();
    AppMethodBeat.o(274403);
  }
  
  public final void b(AppBrandOpenMaterialModel paramAppBrandOpenMaterialModel)
  {
    AppMethodBeat.i(274406);
    p.k(paramAppBrandOpenMaterialModel, "openMaterialModel");
    Log.i(this.bqj, "onListPageAppBrandExposure");
    if (this.qnD.contains(paramAppBrandOpenMaterialModel))
    {
      AppMethodBeat.o(274406);
      return;
    }
    ra localra = ccY().HU(this.gfl).Ew(2L).HV(paramAppBrandOpenMaterialModel.appId);
    String str2 = paramAppBrandOpenMaterialModel.appName;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localra.HW(str1).bpa();
    this.qnD.add(paramAppBrandOpenMaterialModel);
    AppMethodBeat.o(274406);
  }
  
  public final b ccQ()
  {
    return this.qnF;
  }
  
  public final void ccR()
  {
    try
    {
      AppMethodBeat.i(274396);
      Log.i(this.bqj, "updateSessionId");
      String str = ad.Rp("OpenMaterial#" + this.qnF.name());
      p.j(str, "DataCenter.buildSessionI…openMaterialScene.name}\")");
      this.gfl = str;
      this.bqj = ("MicroMsg.AppBrand.AppBrandOpenMaterialReporter#" + this.gfl);
      AppMethodBeat.o(274396);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void ccS()
  {
    AppMethodBeat.i(274399);
    Log.i(this.bqj, "onBottomSheetMoreClick");
    ccX().Hb(this.gfl).DE(3L).DF(d(this.qnF)).DG(ccZ()).DH(0L).bpa();
    AppMethodBeat.o(274399);
  }
  
  public final void ccT()
  {
    AppMethodBeat.i(274401);
    Log.i(this.bqj, "onLaunchListPageDirectly");
    ccX().Hb(this.gfl).DE(4L).DF(d(this.qnF)).DG(ccZ()).DH(0L).bpa();
    AppMethodBeat.o(274401);
  }
  
  public final void ccU()
  {
    AppMethodBeat.i(274405);
    Log.i(this.bqj, "onBottomSheetListPageEntranceExposure");
    if (this.qnE)
    {
      AppMethodBeat.o(274405);
      return;
    }
    ccX().Hb(this.gfl).DE(2L).DF(d(this.qnF)).DG(ccZ()).DH(0L).bpa();
    this.qnE = true;
    AppMethodBeat.o(274405);
  }
  
  public final qf ccX()
  {
    AppMethodBeat.i(274389);
    qf localqf = (qf)this.qnx.getValue();
    AppMethodBeat.o(274389);
    return localqf;
  }
  
  public final ra ccY()
  {
    AppMethodBeat.i(274391);
    ra localra = (ra)this.qnz.getValue();
    AppMethodBeat.o(274391);
    return localra;
  }
  
  public final long ccZ()
  {
    AppMethodBeat.i(274393);
    long l = ((Number)this.qnA.getValue()).longValue();
    AppMethodBeat.o(274393);
    return l;
  }
  
  public final void cda()
  {
    AppMethodBeat.i(274397);
    Log.i(this.bqj, "onBottomSheetShow");
    ccX().Hb(this.gfl).DE(1L).DF(d(this.qnF)).DG(ccZ()).DH(0L).bpa();
    if (b.qns == this.qnF) {
      ccX().Hb(this.gfl).DE(5L).DF(d(this.qnF)).DG(ccZ()).DH(0L).bpa();
    }
    AppMethodBeat.o(274397);
  }
  
  public final String getSessionId()
  {
    return this.gfl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.b.a
 * JD-Core Version:    0.7.0.1
 */