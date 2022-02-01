package com.tencent.luggage.sdk.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.a.b.a.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.sdk.platformtools.ac;

@SuppressLint({"ViewConstructor"})
public final class b
  extends l<c>
  implements com.tencent.mm.plugin.appbrand.r.a.b.a.b
{
  private com.tencent.mm.plugin.appbrand.r.a.e ceX;
  
  public final void a(c paramc, AppBrandInitConfigLU paramAppBrandInitConfigLU, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(206129);
    paramAppBrandInitConfigLU.ccl = paramAppBrandStatObject;
    super.a(paramc, paramAppBrandInitConfigLU);
    AppMethodBeat.o(206129);
  }
  
  public final void b(AppBrandRuntime paramAppBrandRuntime1, AppBrandRuntime paramAppBrandRuntime2, Runnable paramRunnable)
  {
    AppMethodBeat.i(206128);
    super.b(paramAppBrandRuntime1, paramAppBrandRuntime2, paramRunnable);
    String str;
    if (paramAppBrandRuntime1 == null)
    {
      str = "null";
      ac.i("Luggage.FULL.AppBrandRuntimeContainerViewImplLu", "onRuntimeClose entered, in.appId[%s], out.appId[%s]", new Object[] { str, paramAppBrandRuntime2.mAppId });
      paramRunnable.run();
      if ((getStackSize() > 1) || (paramAppBrandRuntime1 != null)) {
        break label145;
      }
      paramAppBrandRuntime1 = getActivity();
      if (paramAppBrandRuntime1 != null) {
        break label99;
      }
      ac.i("Luggage.FULL.AppBrandRuntimeContainerViewImplLu", "closeActivity: fail");
    }
    for (;;)
    {
      ac.i("Luggage.FULL.AppBrandRuntimeContainerViewImplLu", "onRuntimeClose: activity closed");
      AppMethodBeat.o(206128);
      return;
      str = paramAppBrandRuntime1.mAppId;
      break;
      label99:
      if (!paramAppBrandRuntime1.isFinishing())
      {
        paramAppBrandRuntime1.moveTaskToBack(true);
        if (getStackSize() <= 0) {
          paramAppBrandRuntime1.overridePendingTransition(0, 0);
        } else {
          ((y)com.tencent.luggage.a.e.K(y.class)).m(paramAppBrandRuntime1);
        }
      }
    }
    label145:
    if (paramAppBrandRuntime2.aSU()) {
      ((y)com.tencent.luggage.a.e.K(y.class)).a(paramAppBrandRuntime1, paramAppBrandRuntime2, null);
    }
    AppMethodBeat.o(206128);
  }
  
  public final com.tencent.mm.plugin.appbrand.r.a.e getOrientationHandler()
  {
    AppMethodBeat.i(206127);
    if (this.ceX == null) {
      this.ceX = new a(this);
    }
    com.tencent.mm.plugin.appbrand.r.a.e locale = this.ceX;
    AppMethodBeat.o(206127);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.b
 * JD-Core Version:    0.7.0.1
 */