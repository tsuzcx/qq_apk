package com.tencent.luggage.sdk.d;

import android.app.Activity;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainer;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s.a.a.o;
import com.tencent.mm.plugin.appbrand.s.a.e.a;
import com.tencent.mm.plugin.appbrand.s.a.e.b;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.appbrand.ui.z;
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
  
  public boolean DT()
  {
    AppMethodBeat.i(146894);
    if (getStackSize() <= 0)
    {
      by(false);
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
    com.tencent.mm.sdk.f.a.iV(this.mContext).runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(169444);
        n.I(com.tencent.mm.sdk.f.a.iV(a.this.mContext));
        if (paramc == null) {
          a.a(a.this);
        }
        c localc = (c)a.a(a.this, paramAppBrandInitConfigLU.appId);
        paramAppBrandInitConfigLU.cfo = paramAppBrandStatObject;
        if (localc == null)
        {
          localc = (c)a.a(a.this, paramAppBrandInitConfigLU);
          a.a(a.this, localc);
          a.a(a.this, paramc, localc, paramAppBrandInitConfigLU);
        }
        while (a.this.A(localc)) {
          if (localc.aLJ() != null)
          {
            localc.iDQ = true;
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
            localc.iDQ = false;
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
      ad.i("Luggage.AppBrandRuntimeContainerLU", "onRuntimeClose entered, in.appId[%s], out.appId[%s], out.isFinishing[%b], out.canDoCloseAnimation[%b], mIsActivityPaused[%b], stackSize[%d]", new Object[] { str, paramAppBrandRuntime2.mAppId, Boolean.valueOf(paramAppBrandRuntime2.PR), Boolean.valueOf(paramAppBrandRuntime2.aMe()), Boolean.valueOf(this.iFd), Integer.valueOf(getStackSize()) });
      paramRunnable = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(169447);
          a.a(a.this, paramAppBrandRuntime1, paramAppBrandRuntime2, paramRunnable);
          AppMethodBeat.o(169447);
        }
      };
      if (this.iFd) {
        paramAppBrandRuntime2.iDR = false;
      }
      if (paramAppBrandRuntime2.PR) {
        break label177;
      }
      if (getStackSize() <= 1) {
        break label166;
      }
      if (!paramAppBrandRuntime2.aMe()) {
        break;
      }
      ((z)e.K(z.class)).a(paramAppBrandRuntime1, paramAppBrandRuntime2, paramRunnable);
      AppMethodBeat.o(146893);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(146893);
    return;
    label166:
    by(true);
    AppMethodBeat.o(146893);
    return;
    label177:
    if (!A(paramAppBrandRuntime2))
    {
      paramRunnable.run();
      AppMethodBeat.o(146893);
      return;
    }
    if (getStackSize() > 1)
    {
      if (paramAppBrandRuntime2.aMe())
      {
        ((z)e.K(z.class)).a(paramAppBrandRuntime1, paramAppBrandRuntime2, paramRunnable);
        AppMethodBeat.o(146893);
        return;
      }
      paramRunnable.run();
      AppMethodBeat.o(146893);
      return;
    }
    by(false);
    AppMethodBeat.o(146893);
  }
  
  protected void by(boolean paramBoolean)
  {
    AppMethodBeat.i(146892);
    Activity localActivity = com.tencent.mm.sdk.f.a.iV(this.mContext);
    if (localActivity == null)
    {
      AppMethodBeat.o(146892);
      return;
    }
    if (!localActivity.isFinishing())
    {
      if ((this.iFa.aMC()) && (paramBoolean)) {
        localActivity.moveTaskToBack(true);
      }
      while (getStackSize() <= 0)
      {
        localActivity.overridePendingTransition(0, 0);
        AppMethodBeat.o(146892);
        return;
        localActivity.finish();
      }
      ((z)e.K(z.class)).m(localActivity);
    }
    AppMethodBeat.o(146892);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(146895);
    if (DT())
    {
      AppMethodBeat.o(146895);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(146895);
  }
  
  public void setResizeable(boolean paramBoolean)
  {
    AppMethodBeat.i(186874);
    super.setResizeable(paramBoolean);
    AppMethodBeat.o(186874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.a
 * JD-Core Version:    0.7.0.1
 */