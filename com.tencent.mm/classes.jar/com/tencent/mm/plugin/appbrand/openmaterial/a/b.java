package com.tencent.mm.plugin.appbrand.openmaterial.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.openmaterial.k;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/openmaterial/data/IOpenMaterialDataSource;", "", "fetchOpenMaterials", "", "materialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/MaterialModel;", "fetchOpenMaterialsCallback", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IFetchOpenMaterialsCallback;", "fetchOpenMaterialsQuickly", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "prefetchOpenMaterialsOnLaunchAppBrand", "Companion", "plugin-appbrand-integration_release"})
public abstract interface b
{
  public static final a qna = a.qnb;
  
  public abstract AppBrandOpenMaterialCollection a(MaterialModel paramMaterialModel);
  
  public abstract void a(MaterialModel paramMaterialModel, k paramk);
  
  public abstract void c(MaterialModel paramMaterialModel);
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/openmaterial/data/IOpenMaterialDataSource$Companion;", "", "()V", "USE_FAKE_IMPL_KEY", "", "useFakeImpl", "", "getUseFakeImpl", "()Z", "invoke", "Lcom/tencent/mm/plugin/appbrand/openmaterial/data/IOpenMaterialDataSource;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(275837);
      qnb = new a();
      AppMethodBeat.o(275837);
    }
    
    public static b ccV()
    {
      boolean bool = false;
      AppMethodBeat.i(275836);
      Object localObject = f.nCi.aal();
      if (localObject != null) {
        bool = ((MultiProcessMMKV)localObject).getBoolean("open_material_fake", false);
      }
      if (bool)
      {
        Log.d("MicroMsg.AppBrand.OpenMaterialDataSource", "create OpenMaterialDataSource, use FakeOpenMaterialDataSource");
        localObject = (b)a.qmX;
        AppMethodBeat.o(275836);
        return localObject;
      }
      Log.d("MicroMsg.AppBrand.OpenMaterialDataSource", "create OpenMaterialDataSource, use WeChatOpenMaterialDataSourceAnyProcess");
      localObject = (b)e.qnd;
      AppMethodBeat.o(275836);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.a.b
 * JD-Core Version:    0.7.0.1
 */