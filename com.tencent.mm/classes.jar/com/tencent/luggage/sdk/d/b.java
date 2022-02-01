package com.tencent.luggage.sdk.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s.a.b.a.a;
import com.tencent.mm.plugin.appbrand.ui.z;
import com.tencent.mm.sdk.platformtools.ad;

@SuppressLint({"ViewConstructor"})
public final class b
  extends l<c>
  implements com.tencent.mm.plugin.appbrand.s.a.b.a.b
{
  private com.tencent.mm.plugin.appbrand.s.a.e cic;
  
  public final void a(c paramc, AppBrandInitConfigLU paramAppBrandInitConfigLU, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(186877);
    paramAppBrandInitConfigLU.cfo = paramAppBrandStatObject;
    super.a(paramc, paramAppBrandInitConfigLU);
    AppMethodBeat.o(186877);
  }
  
  public final void b(AppBrandRuntime paramAppBrandRuntime1, AppBrandRuntime paramAppBrandRuntime2, Runnable paramRunnable)
  {
    AppMethodBeat.i(186876);
    super.b(paramAppBrandRuntime1, paramAppBrandRuntime2, paramRunnable);
    String str;
    if (paramAppBrandRuntime1 == null)
    {
      str = "null";
      ad.i("Luggage.FULL.AppBrandRuntimeContainerViewImplLu", "onRuntimeClose entered, in.appId[%s], out.appId[%s]", new Object[] { str, paramAppBrandRuntime2.mAppId });
      paramRunnable.run();
      if ((getStackSize() > 1) || (paramAppBrandRuntime1 != null)) {
        break label145;
      }
      paramAppBrandRuntime1 = getActivity();
      if (paramAppBrandRuntime1 != null) {
        break label99;
      }
      ad.i("Luggage.FULL.AppBrandRuntimeContainerViewImplLu", "closeActivity: fail");
    }
    for (;;)
    {
      ad.i("Luggage.FULL.AppBrandRuntimeContainerViewImplLu", "onRuntimeClose: activity closed");
      AppMethodBeat.o(186876);
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
          ((z)com.tencent.luggage.a.e.K(z.class)).m(paramAppBrandRuntime1);
        }
      }
    }
    label145:
    if (paramAppBrandRuntime2.aMe()) {
      ((z)com.tencent.luggage.a.e.K(z.class)).a(paramAppBrandRuntime1, paramAppBrandRuntime2, null);
    }
    AppMethodBeat.o(186876);
  }
  
  public final com.tencent.mm.plugin.appbrand.s.a.e getOrientationHandler()
  {
    AppMethodBeat.i(186875);
    if (this.cic == null) {
      this.cic = new a(this);
    }
    com.tencent.mm.plugin.appbrand.s.a.e locale = this.cic;
    AppMethodBeat.o(186875);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.b
 * JD-Core Version:    0.7.0.1
 */