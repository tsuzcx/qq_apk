package com.tencent.mm.plugin.appbrand.openmaterial;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.widget.a.e;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/openmaterial/BottomSheetEnhanceLogic;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IEnhanceBottomSheetController;", "openMaterialScene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "context", "Landroid/content/Context;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "openMaterialBottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;Landroid/content/Context;Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;)V", "getBottomSheet", "()Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getContext", "()Landroid/content/Context;", "getOpenMaterialCollection", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "openMaterialReporter", "Lcom/tencent/mm/plugin/appbrand/openmaterial/report/AppBrandOpenMaterialReporter;", "getOpenMaterialReporter", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/report/AppBrandOpenMaterialReporter;", "dead", "", "requireOpenMaterialBottomSheet", "Companion", "plugin-appbrand-integration_release"})
public abstract class c
  implements j
{
  public static final a qmn = new a((byte)0);
  private final Context context;
  final e kCR;
  private final AppBrandOpenMaterialCollection qlV;
  private final l qlW;
  final com.tencent.mm.plugin.appbrand.openmaterial.b.a qml;
  private h qmm;
  
  public c(b paramb, Context paramContext, e parame, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, h paramh, l paraml)
  {
    this.context = paramContext;
    this.kCR = parame;
    this.qlV = paramAppBrandOpenMaterialCollection;
    this.qmm = paramh;
    this.qlW = paraml;
    this.qml = com.tencent.mm.plugin.appbrand.openmaterial.b.c.b(paramb, this.qlV);
    if ((this.context instanceof MMFragmentActivity))
    {
      ((MMFragmentActivity)this.context).keep((com.tencent.mm.vending.e.a)this);
      return;
    }
    Log.e("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "<init>, context is not lifecycle keeper");
  }
  
  protected final h ccM()
  {
    h localh2 = this.qmm;
    h localh1 = localh2;
    if (localh2 == null)
    {
      localh1 = a.qlZ.a(this.context, this.kCR, this.qlV, this.qlW, (i)this.qml);
      this.qmm = localh1;
    }
    return localh1;
  }
  
  protected final AppBrandOpenMaterialCollection ccN()
  {
    return this.qlV;
  }
  
  public void dead()
  {
    Log.d("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "dead");
    h localh = this.qmm;
    if (localh != null) {
      localh.hide();
    }
    localh = this.qmm;
    if (localh != null) {
      localh.dead();
    }
  }
  
  protected final Context getContext()
  {
    return this.context;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/openmaterial/BottomSheetEnhanceLogic$Companion;", "", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IEnhanceBottomSheetController;", "openMaterialScene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "context", "Landroid/content/Context;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "openMaterialBottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "needEnhance", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.c
 * JD-Core Version:    0.7.0.1
 */