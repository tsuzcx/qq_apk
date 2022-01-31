package com.tencent.luggage.sdk.d;

import android.app.Activity;
import android.app.Application;
import com.tencent.luggage.a.e;
import com.tencent.luggage.g.d;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.s;
import java.util.LinkedList;

public class a
  extends k<b>
{
  boolean bFa;
  boolean bFb;
  
  public a(com.tencent.mm.plugin.appbrand.task.i parami, Class<? extends b> paramClass)
  {
    super(parami, paramClass);
    AppMethodBeat.i(140798);
    this.bFa = false;
    this.bFb = false;
    this.gQx.getApplication().registerActivityLifecycleCallbacks(new a.1(this));
    AppMethodBeat.o(140798);
  }
  
  public final void a(b paramb, AppBrandInitConfigLU paramAppBrandInitConfigLU, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(140799);
    if ((paramAppBrandInitConfigLU == null) || (paramAppBrandStatObject == null))
    {
      AppMethodBeat.o(140799);
      return;
    }
    this.gQx.runOnUiThread(new a.2(this, paramb, paramAppBrandInitConfigLU, paramAppBrandStatObject));
    AppMethodBeat.o(140799);
  }
  
  public void b(com.tencent.mm.plugin.appbrand.i parami1, com.tencent.mm.plugin.appbrand.i parami2, Runnable paramRunnable)
  {
    AppMethodBeat.i(140801);
    if (parami1 == null) {}
    for (String str = "null";; str = parami1.mAppId)
    {
      d.i("Luggage.AppBrandRuntimeContainerLU", "onRuntimeClose entered, in.appId[%s], out.appId[%s], out.isFinishing[%b], out.canDoCloseAnimation[%b], mIsActivityPaused[%b], stackSize[%d]", new Object[] { str, parami2.mAppId, Boolean.valueOf(parami2.IR), Boolean.valueOf(parami2.atz()), Boolean.valueOf(this.bFb), Integer.valueOf(this.gQz.size()) });
      paramRunnable = new a.4(this, parami1, parami2, paramRunnable);
      if (this.bFb) {
        parami2.gPR = false;
      }
      if (parami2.IR) {
        break label183;
      }
      if (this.gQz.size() <= 1) {
        break label172;
      }
      if (!parami2.atz()) {
        break;
      }
      ((s)e.q(s.class)).a(parami1, parami2, paramRunnable);
      AppMethodBeat.o(140801);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(140801);
    return;
    label172:
    bf(true);
    AppMethodBeat.o(140801);
    return;
    label183:
    if (!g(parami2))
    {
      paramRunnable.run();
      AppMethodBeat.o(140801);
      return;
    }
    if (this.gQz.size() > 1)
    {
      if (parami2.atz())
      {
        ((s)e.q(s.class)).a(parami1, parami2, paramRunnable);
        AppMethodBeat.o(140801);
        return;
      }
      paramRunnable.run();
      AppMethodBeat.o(140801);
      return;
    }
    bf(false);
    AppMethodBeat.o(140801);
  }
  
  protected void bf(boolean paramBoolean)
  {
    AppMethodBeat.i(140800);
    Activity localActivity = this.gQB.getContext();
    if (!localActivity.isFinishing())
    {
      if ((!this.gQB.aLX()) || (!paramBoolean)) {
        break label66;
      }
      localActivity.moveTaskToBack(true);
    }
    for (;;)
    {
      if (this.gQz.size() <= 0) {
        localActivity.overridePendingTransition(0, 0);
      }
      AppMethodBeat.o(140800);
      return;
      label66:
      localActivity.finish();
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(140803);
    if (wN())
    {
      AppMethodBeat.o(140803);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(140803);
  }
  
  public boolean wN()
  {
    AppMethodBeat.i(140802);
    if (this.gQz.size() <= 0)
    {
      bf(false);
      AppMethodBeat.o(140802);
      return true;
    }
    AppMethodBeat.o(140802);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.a
 * JD-Core Version:    0.7.0.1
 */