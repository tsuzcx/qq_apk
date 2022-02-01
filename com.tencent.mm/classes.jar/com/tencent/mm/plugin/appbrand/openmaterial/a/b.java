package com.tencent.mm.plugin.appbrand.openmaterial.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.openmaterial.j;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.MaterialModel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/openmaterial/data/IOpenMaterialDataSource;", "", "fetchOpenMaterials", "", "materialModel", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/MaterialModel;", "fetchOpenMaterialsCallback", "Lcom/tencent/mm/plugin/appbrand/openmaterial/IFetchOpenMaterialsCallback;", "fetchOpenMaterialsQuickly", "Lcom/tencent/mm/plugin/appbrand/openmaterial/model/AppBrandOpenMaterialCollection;", "prefetchOpenMaterialsOnLaunchAppBrand", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
{
  public static final a trG = a.trH;
  
  public abstract AppBrandOpenMaterialCollection a(MaterialModel paramMaterialModel);
  
  public abstract void a(MaterialModel paramMaterialModel, j paramj);
  
  public abstract void c(MaterialModel paramMaterialModel);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/openmaterial/data/IOpenMaterialDataSource$Companion;", "", "()V", "USE_FAKE_IMPL_KEY", "", "useFakeImpl", "", "getUseFakeImpl", "()Z", "invoke", "Lcom/tencent/mm/plugin/appbrand/openmaterial/data/IOpenMaterialDataSource;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static
    {
      AppMethodBeat.i(323690);
      trH = new a();
      AppMethodBeat.o(323690);
    }
    
    public static b cDt()
    {
      boolean bool = false;
      AppMethodBeat.i(323685);
      Object localObject = f.qBv;
      localObject = f.aBP();
      if (localObject == null) {}
      while (bool)
      {
        Log.d("MicroMsg.AppBrand.OpenMaterialDataSource", "create OpenMaterialDataSource, use FakeOpenMaterialDataSource");
        localObject = (b)a.trF;
        AppMethodBeat.o(323685);
        return localObject;
        bool = ((MultiProcessMMKV)localObject).getBoolean("open_material_fake", false);
      }
      Log.d("MicroMsg.AppBrand.OpenMaterialDataSource", "create OpenMaterialDataSource, use WeChatOpenMaterialDataSourceAnyProcess");
      localObject = (b)e.trJ;
      AppMethodBeat.o(323685);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.a.b
 * JD-Core Version:    0.7.0.1
 */