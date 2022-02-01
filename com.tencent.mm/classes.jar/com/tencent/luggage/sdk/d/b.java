package com.tencent.luggage.sdk.d;

import android.app.Activity;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.platform.window.e.a;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.appbrand.ui.ab;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.sdk.f.a;
import com.tencent.mm.sdk.platformtools.ae;

public class b
  extends AppBrandRuntimeContainer<d>
{
  public b(g paramg, Class<? extends d> paramClass)
  {
    super(paramg, paramClass);
    AppMethodBeat.i(146890);
    AppMethodBeat.o(146890);
  }
  
  public boolean Fa()
  {
    AppMethodBeat.i(146894);
    if (getStackSize() <= 0)
    {
      bx(false);
      AppMethodBeat.o(146894);
      return true;
    }
    AppMethodBeat.o(146894);
    return false;
  }
  
  public final void a(final d paramd, final AppBrandInitConfigLU paramAppBrandInitConfigLU, final AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(146891);
    if ((paramAppBrandInitConfigLU == null) || (paramAppBrandStatObject == null))
    {
      AppMethodBeat.o(146891);
      return;
    }
    a.jw(this.mContext).runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169444);
        n.J(a.jw(b.this.mContext));
        if (paramd == null) {
          b.a(b.this, paramAppBrandInitConfigLU.appId);
        }
        d locald = (d)b.b(b.this, paramAppBrandInitConfigLU.appId);
        paramAppBrandInitConfigLU.cmE = paramAppBrandStatObject;
        if (locald == null)
        {
          locald = (d)b.a(b.this, paramAppBrandInitConfigLU);
          b.a(b.this, locald);
          b.a(b.this, paramd, locald, paramAppBrandInitConfigLU);
        }
        while (b.this.w(locald)) {
          if (locald.aWl() != null)
          {
            locald.jzW = true;
            AppMethodBeat.o(169444);
            return;
            if (paramd == locald)
            {
              b.a(b.this, locald, paramAppBrandInitConfigLU);
              b.this.onResume();
            }
            else
            {
              b.b(b.this, paramd, locald, paramAppBrandInitConfigLU);
            }
          }
          else
          {
            locald.jzW = false;
          }
        }
        AppMethodBeat.o(169444);
      }
    });
    AppMethodBeat.o(146891);
  }
  
  public void b(final AppBrandRuntime paramAppBrandRuntime1, final AppBrandRuntime paramAppBrandRuntime2, final Runnable paramRunnable)
  {
    AppMethodBeat.i(146893);
    if (paramAppBrandRuntime1 == null) {}
    for (String str = "null";; str = paramAppBrandRuntime1.mAppId)
    {
      ae.i("Luggage.AppBrandRuntimeContainerLU[AppBrandSplashAd]", "onRuntimeClose entered, in.appId[%s], out.appId[%s], out.isFinishing[%b], out.canDoCloseAnimation[%b], mIsActivityPaused[%b], stackSize[%d]", new Object[] { str, paramAppBrandRuntime2.mAppId, Boolean.valueOf(paramAppBrandRuntime2.SB), Boolean.valueOf(paramAppBrandRuntime2.aWJ()), Boolean.valueOf(this.jBn), Integer.valueOf(getStackSize()) });
      paramRunnable = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(169447);
          b.a(b.this, paramAppBrandRuntime1, paramAppBrandRuntime2, paramRunnable);
          AppMethodBeat.o(169447);
        }
      };
      if (this.jBn) {
        paramAppBrandRuntime2.jzX = false;
      }
      if (paramAppBrandRuntime2.SB) {
        break label177;
      }
      if (getStackSize() <= 1) {
        break label166;
      }
      if (!paramAppBrandRuntime2.aWJ()) {
        break;
      }
      ((ab)e.K(ab.class)).a(paramAppBrandRuntime1, paramAppBrandRuntime2, paramRunnable);
      AppMethodBeat.o(146893);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(146893);
    return;
    label166:
    bx(true);
    AppMethodBeat.o(146893);
    return;
    label177:
    if (!w(paramAppBrandRuntime2))
    {
      paramRunnable.run();
      AppMethodBeat.o(146893);
      return;
    }
    if (getStackSize() > 1)
    {
      if (paramAppBrandRuntime2.aWJ())
      {
        ((ab)e.K(ab.class)).a(paramAppBrandRuntime1, paramAppBrandRuntime2, paramRunnable);
        AppMethodBeat.o(146893);
        return;
      }
      paramRunnable.run();
      AppMethodBeat.o(146893);
      return;
    }
    bx(false);
    AppMethodBeat.o(146893);
  }
  
  protected void bx(boolean paramBoolean)
  {
    AppMethodBeat.i(146892);
    Activity localActivity = a.jw(this.mContext);
    if (localActivity == null)
    {
      AppMethodBeat.o(146892);
      return;
    }
    if (!localActivity.isFinishing())
    {
      if ((this.jBk.aXc()) && (paramBoolean)) {
        localActivity.moveTaskToBack(true);
      }
      while (getStackSize() <= 0)
      {
        localActivity.overridePendingTransition(0, 0);
        AppMethodBeat.o(146892);
        return;
        localActivity.finish();
      }
      ((ab)e.K(ab.class)).m(localActivity);
    }
    AppMethodBeat.o(146892);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(146895);
    if (Fa())
    {
      AppMethodBeat.o(146895);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(146895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.b
 * JD-Core Version:    0.7.0.1
 */