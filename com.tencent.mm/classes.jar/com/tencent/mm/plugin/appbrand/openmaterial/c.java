package com.tencent.mm.plugin.appbrand.openmaterial;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.widget.a.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/openmaterial/BottomSheetEnhanceLogic;", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IEnhanceBottomSheetController;", "openMaterialScene", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;", "context", "Landroid/content/Context;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "openMaterialCollection", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "openMaterialBottomSheet", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;", "launchAppBrandExecutor", "Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;", "(Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialScene;Landroid/content/Context;Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;Lcom/tencent/mm/plugin/appbrand/openmaterial/IAppBrandOpenMaterialBottomSheet;Lcom/tencent/mm/plugin/appbrand/openmaterial/ILaunchAppBrandExecutor;)V", "getBottomSheet", "()Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getContext", "()Landroid/content/Context;", "getOpenMaterialCollection", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "openMaterialReporter", "Lcom/tencent/mm/plugin/appbrand/openmaterial/report/AppBrandOpenMaterialReporter;", "getOpenMaterialReporter", "()Lcom/tencent/mm/plugin/appbrand/openmaterial/report/AppBrandOpenMaterialReporter;", "dead", "", "requireOpenMaterialBottomSheet", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class c
  implements i
{
  public static final c.a trf = new c.a((byte)0);
  private final Context context;
  private final f ngn;
  private final AppBrandOpenMaterialCollection tqV;
  private final k tqW;
  private g trg;
  private final com.tencent.mm.plugin.appbrand.openmaterial.b.a trh;
  
  public c(com.tencent.mm.plugin.appbrand.openmaterial.model.b paramb, Context paramContext, f paramf, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection, g paramg, k paramk)
  {
    this.context = paramContext;
    this.ngn = paramf;
    this.tqV = paramAppBrandOpenMaterialCollection;
    this.trg = paramg;
    this.tqW = paramk;
    this.trh = com.tencent.mm.plugin.appbrand.openmaterial.b.b.b(paramb, this.tqV);
    if ((this.context instanceof MMFragmentActivity))
    {
      ((MMFragmentActivity)this.context).keep((com.tencent.mm.vending.e.a)this);
      return;
    }
    Log.e("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "<init>, context is not lifecycle keeper");
  }
  
  protected final f cDi()
  {
    return this.ngn;
  }
  
  protected final AppBrandOpenMaterialCollection cDj()
  {
    return this.tqV;
  }
  
  protected final com.tencent.mm.plugin.appbrand.openmaterial.b.a cDk()
  {
    return this.trh;
  }
  
  protected final g cDl()
  {
    g localg2 = this.trg;
    g localg1 = localg2;
    if (localg2 == null)
    {
      localg1 = a.tqT.a(this.context, this.ngn, this.tqV, this.tqW, (h)this.trh);
      this.trg = localg1;
    }
    return localg1;
  }
  
  public void dead()
  {
    Log.d("MicroMsg.AppBrand.BottomSheetEnhanceLogic", "dead");
    g localg = this.trg;
    if (localg != null) {
      localg.hide();
    }
    localg = this.trg;
    if (localg != null) {
      localg.dead();
    }
  }
  
  protected final Context getContext()
  {
    return this.context;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.c
 * JD-Core Version:    0.7.0.1
 */