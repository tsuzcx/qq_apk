package com.tencent.luggage.sdk.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.platform.window.c.a.a;
import com.tencent.mm.plugin.appbrand.platform.window.c.a.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.ah;
import com.tencent.mm.sdk.platformtools.Log;

@SuppressLint({"ViewConstructor"})
public final class c
  extends n<d>
  implements b
{
  private com.tencent.mm.plugin.appbrand.platform.window.e cCk;
  
  public final boolean OG()
  {
    return false;
  }
  
  public final void a(d paramd, AppBrandInitConfigLU paramAppBrandInitConfigLU, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(229873);
    paramAppBrandInitConfigLU.cyA = paramAppBrandStatObject;
    super.a(paramd, paramAppBrandInitConfigLU);
    AppMethodBeat.o(229873);
  }
  
  public final void b(AppBrandRuntime paramAppBrandRuntime1, AppBrandRuntime paramAppBrandRuntime2, Runnable paramRunnable)
  {
    AppMethodBeat.i(229872);
    super.b(paramAppBrandRuntime1, paramAppBrandRuntime2, paramRunnable);
    String str;
    if (paramAppBrandRuntime1 == null)
    {
      str = "null";
      Log.i("Luggage.FULL.AppBrandRuntimeContainerViewImplLu", "onRuntimeClose entered, in.appId[%s], out.appId[%s]", new Object[] { str, paramAppBrandRuntime2.mAppId });
      paramRunnable.run();
      if ((getStackSize() > 1) || (paramAppBrandRuntime1 != null)) {
        break label145;
      }
      paramAppBrandRuntime1 = getActivity();
      if (paramAppBrandRuntime1 != null) {
        break label99;
      }
      Log.i("Luggage.FULL.AppBrandRuntimeContainerViewImplLu", "closeActivity: fail");
    }
    for (;;)
    {
      Log.i("Luggage.FULL.AppBrandRuntimeContainerViewImplLu", "onRuntimeClose: activity closed");
      AppMethodBeat.o(229872);
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
          ((ah)com.tencent.luggage.a.e.M(ah.class)).m(paramAppBrandRuntime1);
        }
      }
    }
    label145:
    if (paramAppBrandRuntime2.brG()) {
      ((ah)com.tencent.luggage.a.e.M(ah.class)).a(paramAppBrandRuntime1, paramAppBrandRuntime2, null);
    }
    AppMethodBeat.o(229872);
  }
  
  public final com.tencent.mm.plugin.appbrand.platform.window.e getOrientationHandler()
  {
    AppMethodBeat.i(229871);
    if (this.cCk == null) {
      this.cCk = new a(this);
    }
    com.tencent.mm.plugin.appbrand.platform.window.e locale = this.cCk;
    AppMethodBeat.o(229871);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.c
 * JD-Core Version:    0.7.0.1
 */