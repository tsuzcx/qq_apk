package com.tencent.luggage.sdk.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.platform.window.b.a.a;
import com.tencent.mm.plugin.appbrand.platform.window.b.a.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.ab;
import com.tencent.mm.sdk.platformtools.ae;

@SuppressLint({"ViewConstructor"})
public final class c
  extends m<d>
  implements b
{
  private com.tencent.mm.plugin.appbrand.platform.window.e cpR;
  
  public final void a(d paramd, AppBrandInitConfigLU paramAppBrandInitConfigLU, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(220769);
    paramAppBrandInitConfigLU.cmE = paramAppBrandStatObject;
    super.a(paramd, paramAppBrandInitConfigLU);
    AppMethodBeat.o(220769);
  }
  
  public final void b(AppBrandRuntime paramAppBrandRuntime1, AppBrandRuntime paramAppBrandRuntime2, Runnable paramRunnable)
  {
    AppMethodBeat.i(220768);
    super.b(paramAppBrandRuntime1, paramAppBrandRuntime2, paramRunnable);
    String str;
    if (paramAppBrandRuntime1 == null)
    {
      str = "null";
      ae.i("Luggage.FULL.AppBrandRuntimeContainerViewImplLu", "onRuntimeClose entered, in.appId[%s], out.appId[%s]", new Object[] { str, paramAppBrandRuntime2.mAppId });
      paramRunnable.run();
      if ((getStackSize() > 1) || (paramAppBrandRuntime1 != null)) {
        break label145;
      }
      paramAppBrandRuntime1 = getActivity();
      if (paramAppBrandRuntime1 != null) {
        break label99;
      }
      ae.i("Luggage.FULL.AppBrandRuntimeContainerViewImplLu", "closeActivity: fail");
    }
    for (;;)
    {
      ae.i("Luggage.FULL.AppBrandRuntimeContainerViewImplLu", "onRuntimeClose: activity closed");
      AppMethodBeat.o(220768);
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
          ((ab)com.tencent.luggage.a.e.K(ab.class)).m(paramAppBrandRuntime1);
        }
      }
    }
    label145:
    if (paramAppBrandRuntime2.aWJ()) {
      ((ab)com.tencent.luggage.a.e.K(ab.class)).a(paramAppBrandRuntime1, paramAppBrandRuntime2, null);
    }
    AppMethodBeat.o(220768);
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.e getOrientationHandler()
  {
    AppMethodBeat.i(220767);
    if (this.cpR == null) {
      this.cpR = new a(this);
    }
    com.tencent.mm.plugin.appbrand.platform.window.e locale = this.cpR;
    AppMethodBeat.o(220767);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.c
 * JD-Core Version:    0.7.0.1
 */