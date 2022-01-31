package com.tencent.mm.plugin.appbrand.ui.collection;

import a.l;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/appbrand/ui/collection/AppBrandLauncherCollectionList$onViewCreated$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherCollectionList$f
  implements ViewTreeObserver.OnPreDrawListener
{
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(135057);
    Object localObject = AppBrandLauncherCollectionList.b(this.iRN);
    if (localObject != null)
    {
      localObject = ((h)localObject).getViewTreeObserver();
      if (localObject != null) {
        ((ViewTreeObserver)localObject).removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      }
    }
    AppBrandLauncherCollectionList.c(this.iRN);
    AppMethodBeat.o(135057);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList.f
 * JD-Core Version:    0.7.0.1
 */