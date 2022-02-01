package com.tencent.luggage.sdk.e;

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
import com.tencent.mm.plugin.appbrand.task.q;
import com.tencent.mm.plugin.appbrand.ui.ah;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public class b
  extends AppBrandRuntimeContainer<d>
{
  public b(q paramq, Class<? extends d> paramClass)
  {
    super(paramq, paramClass);
    AppMethodBeat.i(146890);
    AppMethodBeat.o(146890);
  }
  
  public boolean Se()
  {
    AppMethodBeat.i(146894);
    if (getStackSize() <= 0)
    {
      cl(false);
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
    AndroidContextUtil.castActivityOrNull(this.mContext).runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169444);
        n.J(AndroidContextUtil.castActivityOrNull(b.this.mContext));
        if (paramd == null) {
          b.a(b.this, paramAppBrandInitConfigLU.appId);
        }
        d locald = (d)b.b(b.this, paramAppBrandInitConfigLU.appId);
        paramAppBrandInitConfigLU.cxf = paramAppBrandStatObject;
        if (locald == null)
        {
          locald = (d)b.a(b.this, paramAppBrandInitConfigLU);
          b.a(b.this, locald);
          b.a(b.this, paramd, locald, paramAppBrandInitConfigLU);
        }
        while (b.this.x(locald)) {
          if (locald.bBW() != null)
          {
            locald.he(true);
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
            locald.he(false);
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
      Log.i("Luggage.AppBrandRuntimeContainerLU[AppBrandSplashAd]", "onRuntimeClose entered, in.appId[%s], out.appId[%s], out.isFinishing[%b], out.canDoCloseAnimation[%b], mIsActivityPaused[%b], stackSize[%d]", new Object[] { str, paramAppBrandRuntime2.mAppId, Boolean.valueOf(paramAppBrandRuntime2.aol), Boolean.valueOf(paramAppBrandRuntime2.bCw()), Boolean.valueOf(bCU()), Integer.valueOf(getStackSize()) });
      paramRunnable = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(169447);
          b.a(b.this, paramAppBrandRuntime1, paramAppBrandRuntime2, paramRunnable);
          AppMethodBeat.o(169447);
        }
      };
      if (bCU()) {
        paramAppBrandRuntime2.nua = false;
      }
      if (paramAppBrandRuntime2.aol) {
        break label177;
      }
      if (getStackSize() <= 1) {
        break label166;
      }
      if (!paramAppBrandRuntime2.bCw()) {
        break;
      }
      ((ah)e.K(ah.class)).a(paramAppBrandRuntime1, paramAppBrandRuntime2, paramRunnable);
      AppMethodBeat.o(146893);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(146893);
    return;
    label166:
    cl(true);
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
      if (paramAppBrandRuntime2.bCw())
      {
        ((ah)e.K(ah.class)).a(paramAppBrandRuntime1, paramAppBrandRuntime2, paramRunnable);
        AppMethodBeat.o(146893);
        return;
      }
      paramRunnable.run();
      AppMethodBeat.o(146893);
      return;
    }
    cl(false);
    AppMethodBeat.o(146893);
  }
  
  protected void cl(boolean paramBoolean)
  {
    AppMethodBeat.i(146892);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(this.mContext);
    if (localActivity == null)
    {
      AppMethodBeat.o(146892);
      return;
    }
    if (!localActivity.isFinishing())
    {
      boolean bool = this.nvr.bCS();
      int i = getStackSize();
      if ((bool) && (paramBoolean)) {
        localActivity.moveTaskToBack(true);
      }
      while (i <= 0)
      {
        localActivity.overridePendingTransition(0, 0);
        AppMethodBeat.o(146892);
        return;
        localActivity.finish();
      }
      ((ah)e.K(ah.class)).k(localActivity);
    }
    AppMethodBeat.o(146892);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(146895);
    if (Se())
    {
      AppMethodBeat.o(146895);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(146895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.e.b
 * JD-Core Version:    0.7.0.1
 */