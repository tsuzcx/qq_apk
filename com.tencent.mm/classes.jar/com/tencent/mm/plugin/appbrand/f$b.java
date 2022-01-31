package com.tencent.mm.plugin.appbrand;

import a.l;
import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/appbrand/AppBrandPersistentRuntimeConfig$watchApp$2", "Lcom/tencent/mm/plugin/appbrand/util/ActivityLifecycleCallbacksAdapter;", "onActivityStarted", "", "activity", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
public final class f$b
  extends a
{
  public final void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(143708);
    if ((paramActivity instanceof AppBrandUI))
    {
      paramActivity = f.a.gPq;
      f.a.ate();
    }
    AppMethodBeat.o(143708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.f.b
 * JD-Core Version:    0.7.0.1
 */