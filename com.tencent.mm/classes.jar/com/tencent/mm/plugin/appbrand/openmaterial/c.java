package com.tencent.mm.plugin.appbrand.openmaterial;

import android.content.Context;
import com.tencent.mm.g.b.a.ng;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.widget.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/openmaterial/BottomSheetEnhanceLogic;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IEnhanceBottomSheetController;", "openMaterialScene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "context", "Landroid/content/Context;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "openMaterialBottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;Landroid/content/Context;Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;)V", "getBottomSheet", "()Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getContext", "()Landroid/content/Context;", "isEnhanceInteractionEnabled", "", "()Z", "setEnhanceInteractionEnabled", "(Z)V", "getOpenMaterialCollection", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "openMaterialReporter", "Lcom/tencent/mm/plugin/appbrand/openmaterial/report/AppBrandOpenMaterialReporter;", "getOpenMaterialReporter", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/report/AppBrandOpenMaterialReporter;", "dead", "", "enableEnhanceInteraction", "enable", "requireOpenMaterialBottomSheet", "Companion", "plugin-appbrand-integration_release"})
public abstract class c
  implements h
{
  public static final c.a nkP = new c.a((byte)0);
  final Context context;
  final e hOv;
  boolean nkN;
  private g nkO;
  final AppBrandOpenMaterialCollection nkx;
  private final j nky;
  final com.tencent.mm.plugin.appbrand.openmaterial.b.a nkz;
  
  public c(b paramb, Context paramContext, e parame, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, g paramg, j paramj)
  {
    this.context = paramContext;
    this.hOv = parame;
    this.nkx = paramAppBrandOpenMaterialCollection;
    this.nkO = paramg;
    this.nky = paramj;
    this.nkN = true;
    paramContext = this.nkx;
    if (this.hOv.hbo() == 0)
    {
      p.h(paramb, "scene");
      p.h(paramContext, "openMaterialCollection");
      paramb = new com.tencent.mm.plugin.appbrand.openmaterial.b.a(paramb, paramContext);
      Log.i(paramb.bQh(), "onBottomSheetShow, isGrid: ".concat(String.valueOf(bool)));
      paramContext = paramb.bQi();
      if (!bool) {
        break label206;
      }
    }
    label206:
    for (long l = 1L;; l = 5L)
    {
      paramContext.xE(l).xF(com.tencent.mm.plugin.appbrand.openmaterial.b.a.d(paramb.nkA)).xG(paramb.bQk()).xH(0L).bfK();
      this.nkz = paramb;
      if (!(this.context instanceof MMFragmentActivity)) {
        break label214;
      }
      ((MMFragmentActivity)this.context).keep((com.tencent.mm.vending.e.a)this);
      return;
      bool = false;
      break;
    }
    label214:
    Log.e("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "<init>, context is not lifecycle keeper");
  }
  
  protected final g bQb()
  {
    g localg = this.nkO;
    Object localObject = localg;
    if (localg == null)
    {
      localObject = a.nkB;
      localObject = a.a.a(this.context, this.hOv, this.nkx, this.nky, this.nkz);
      this.nkO = ((g)localObject);
    }
    return localObject;
  }
  
  public void dead()
  {
    Log.d("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "dead");
    g localg = this.nkO;
    if (localg != null) {
      localg.hide();
    }
    localg = this.nkO;
    if (localg != null) {
      localg.dead();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.c
 * JD-Core Version:    0.7.0.1
 */