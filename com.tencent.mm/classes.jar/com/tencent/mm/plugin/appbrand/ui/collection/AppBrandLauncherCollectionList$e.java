package com.tencent.mm.plugin.appbrand.ui.collection;

import a.l;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/appbrand/ui/collection/AppBrandLauncherCollectionList$onConfigurationChanged$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "counter", "", "onGlobalLayout", "", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherCollectionList$e
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int counter;
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(135056);
    this.counter += 1;
    if (this.counter < 2)
    {
      AppMethodBeat.o(135056);
      return;
    }
    Object localObject = AppBrandLauncherCollectionList.b(this.iRN);
    if (localObject != null)
    {
      localObject = ((h)localObject).getViewTreeObserver();
      if (localObject != null) {
        ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      }
    }
    AppBrandLauncherCollectionList.c(this.iRN);
    AppMethodBeat.o(135056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.AppBrandLauncherCollectionList.e
 * JD-Core Version:    0.7.0.1
 */