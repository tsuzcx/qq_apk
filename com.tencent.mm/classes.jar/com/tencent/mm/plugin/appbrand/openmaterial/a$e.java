package com.tencent.mm.plugin.appbrand.openmaterial;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.OpenMaterialJsBridge;
import com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.OpenMaterialWebView;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class a$e
  implements Runnable
{
  a$e(a parama, OpenMaterialWebView paramOpenMaterialWebView, OpenMaterialJsBridge paramOpenMaterialJsBridge) {}
  
  public final void run()
  {
    int i = 0;
    AppMethodBeat.i(229078);
    Object localObject = ai.afr(7);
    if (localObject == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "loadDataAsync, openMaterialTemplate is null");
      AppMethodBeat.o(229078);
      return;
    }
    final String str = ((at)localObject).fYs() + '/' + at.fYy();
    Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "loadDataAsync, htmlPath: ".concat(String.valueOf(str)));
    localObject = s.aW(str, 0, -1);
    if (localObject != null)
    {
      if (localObject.length == 0) {
        i = 1;
      }
      if (i == 0) {}
    }
    else
    {
      Log.w("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "loadDataAsync, rawHtmlContent is empty");
      AppMethodBeat.o(229078);
      return;
    }
    str = "file://".concat(String.valueOf(str));
    Log.d("MicroMsg.AppBrand.AppBrandOpenMaterialBottomSheet", "loadDataAsync, baseUrl: ".concat(String.valueOf(str)));
    OpenMaterialJsBridge localOpenMaterialJsBridge = this.nkH;
    List localList = a.b(this.nkC).nlF;
    p.g(localList, "openMaterialCollection.a…dOpenMaterialDetailModels");
    localObject = localOpenMaterialJsBridge.attachMyOpenMaterials2Template((byte[])localObject, localList);
    h.RTc.aV((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(229077);
        this.nkI.nkG.loadDataWithBaseURL(str, new String(this.nkK, d.UTF_8), "text/html", "utf-8", null);
        AppMethodBeat.o(229077);
      }
    });
    AppMethodBeat.o(229078);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.a.e
 * JD-Core Version:    0.7.0.1
 */