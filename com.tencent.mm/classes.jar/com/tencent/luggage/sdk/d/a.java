package com.tencent.luggage.sdk.d;

import android.app.Activity;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer;
import com.tencent.mm.plugin.appbrand.r.a.a.o;
import com.tencent.mm.plugin.appbrand.r.a.e.a;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.appbrand.ui.aa;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.sdk.platformtools.ad;

public class a
  extends AppBrandRuntimeContainer<c>
{
  public a(g paramg, Class<? extends c> paramClass)
  {
    super(paramg, paramClass);
    AppMethodBeat.i(146890);
    AppMethodBeat.o(146890);
  }
  
  public boolean EV()
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
  
  public final void a(final c paramc, final AppBrandInitConfigLU paramAppBrandInitConfigLU, final AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(146891);
    if ((paramAppBrandInitConfigLU == null) || (paramAppBrandStatObject == null))
    {
      AppMethodBeat.o(146891);
      return;
    }
    com.tencent.mm.sdk.f.a.jq(this.mContext).runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169444);
        n.I(com.tencent.mm.sdk.f.a.jq(a.this.mContext));
        if (paramc == null) {
          a.a(a.this);
        }
        c localc = (c)a.a(a.this, paramAppBrandInitConfigLU.appId);
        paramAppBrandInitConfigLU.cmC = paramAppBrandStatObject;
        if (localc == null)
        {
          localc = (c)a.a(a.this, paramAppBrandInitConfigLU);
          a.a(a.this, localc);
          a.a(a.this, paramc, localc, paramAppBrandInitConfigLU);
        }
        while (a.this.x(localc)) {
          if (localc.aVM() != null)
          {
            localc.jwY = true;
            AppMethodBeat.o(169444);
            return;
            if (paramc == localc)
            {
              a.a(a.this, localc, paramAppBrandInitConfigLU);
              a.this.onResume();
            }
            else
            {
              a.b(a.this, paramc, localc, paramAppBrandInitConfigLU);
            }
          }
          else
          {
            localc.jwY = false;
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
      ad.i("Luggage.AppBrandRuntimeContainerLU[AppBrandSplashAd]", "onRuntimeClose entered, in.appId[%s], out.appId[%s], out.isFinishing[%b], out.canDoCloseAnimation[%b], mIsActivityPaused[%b], stackSize[%d]", new Object[] { str, paramAppBrandRuntime2.mAppId, Boolean.valueOf(paramAppBrandRuntime2.SB), Boolean.valueOf(paramAppBrandRuntime2.aWi()), Boolean.valueOf(this.jym), Integer.valueOf(getStackSize()) });
      paramRunnable = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(169447);
          a.a(a.this, paramAppBrandRuntime1, paramAppBrandRuntime2, paramRunnable);
          AppMethodBeat.o(169447);
        }
      };
      if (this.jym) {
        paramAppBrandRuntime2.jwZ = false;
      }
      if (paramAppBrandRuntime2.SB) {
        break label177;
      }
      if (getStackSize() <= 1) {
        break label166;
      }
      if (!paramAppBrandRuntime2.aWi()) {
        break;
      }
      ((aa)e.K(aa.class)).a(paramAppBrandRuntime1, paramAppBrandRuntime2, paramRunnable);
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
    if (!x(paramAppBrandRuntime2))
    {
      paramRunnable.run();
      AppMethodBeat.o(146893);
      return;
    }
    if (getStackSize() > 1)
    {
      if (paramAppBrandRuntime2.aWi())
      {
        ((aa)e.K(aa.class)).a(paramAppBrandRuntime1, paramAppBrandRuntime2, paramRunnable);
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
    Activity localActivity = com.tencent.mm.sdk.f.a.jq(this.mContext);
    if (localActivity == null)
    {
      AppMethodBeat.o(146892);
      return;
    }
    if (!localActivity.isFinishing())
    {
      if ((this.jyj.aWA()) && (paramBoolean)) {
        localActivity.moveTaskToBack(true);
      }
      while (getStackSize() <= 0)
      {
        localActivity.overridePendingTransition(0, 0);
        AppMethodBeat.o(146892);
        return;
        localActivity.finish();
      }
      ((aa)e.K(aa.class)).m(localActivity);
    }
    AppMethodBeat.o(146892);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(146895);
    if (EV())
    {
      AppMethodBeat.o(146895);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(146895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.a
 * JD-Core Version:    0.7.0.1
 */