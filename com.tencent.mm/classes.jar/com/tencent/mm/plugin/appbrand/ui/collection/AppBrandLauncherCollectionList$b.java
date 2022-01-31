package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.l;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.f;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/appbrand/ui/collection/AppBrandLauncherCollectionList$initView$2", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragFeatureView;", "onListMayChanged", "", "onListMayChanged$plugin_appbrand_integration_release", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherCollectionList$b
  extends b
{
  AppBrandLauncherCollectionList$b(Context paramContext, h paramh)
  {
    super(paramh, localh);
  }
  
  public final void aMV()
  {
    AppMethodBeat.i(135050);
    a locala = AppBrandLauncherCollectionList.a(this.iRN);
    if (locala != null)
    {
      Object localObject = f.haW;
      localObject = f.awS();
      if (localObject == null) {
        j.ebi();
      }
      f.a((f)localObject, (List)locala.iRT);
      AppMethodBeat.o(135050);
      return;
    }
    AppMethodBeat.o(135050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList.b
 * JD-Core Version:    0.7.0.1
 */