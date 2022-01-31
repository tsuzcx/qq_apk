package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.j;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.ui.AppBrandEmbedUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.widget.input.w;
import com.tencent.mm.plugin.appbrand.widget.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.b;
import java.util.LinkedList;

public final class l
  extends com.tencent.luggage.sdk.d.a
{
  private boolean gQL;
  public final Class[] gQM;
  
  public l(com.tencent.mm.plugin.appbrand.task.i parami)
  {
    super(parami, o.class);
    AppMethodBeat.i(128961);
    this.gQL = false;
    this.gQM = new Class[] { j.class };
    if ((Build.VERSION.SDK_INT >= 21) && (com.tencent.mm.plugin.appbrand.widget.input.a.aQr())) {
      m.a(this.gQx, this.gQx.getWindow().getDecorView());
    }
    AppMethodBeat.o(128961);
  }
  
  private void atL()
  {
    AppMethodBeat.i(128969);
    if ((this.gQx instanceof AppBrandPluginUI)) {
      b.aD(this.gQx);
    }
    AppMethodBeat.o(128969);
  }
  
  private void h(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(156243);
    if (paramAppBrandInitConfig == null)
    {
      AppMethodBeat.o(156243);
      return;
    }
    int i;
    if (((paramAppBrandInitConfig instanceof AppBrandInitConfigLU)) && (((AppBrandInitConfigLU)paramAppBrandInitConfig).vY()))
    {
      i = 1;
      if (i == 0) {
        break label82;
      }
    }
    label82:
    for (paramAppBrandInitConfig = w.cQ(this.gQy);; paramAppBrandInitConfig = com.tencent.luggage.game.widget.input.a.cf(this.gQy))
    {
      if ((paramAppBrandInitConfig != null) && ((paramAppBrandInitConfig.getParent() instanceof ViewGroup))) {
        ((ViewGroup)paramAppBrandInitConfig.getParent()).removeView(paramAppBrandInitConfig);
      }
      AppMethodBeat.o(156243);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(WindowManager.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(143031);
    super.a(paramLayoutParams);
    int j;
    if ((this.gQx != null) && (this.gQx.getWindow() != null))
    {
      paramLayoutParams = this.gQx.getWindow().getDecorView();
      if ((paramLayoutParams.getWindowSystemUiVisibility() & 0x2) == 0)
      {
        paramLayoutParams = paramLayoutParams.getBackground();
        if ((paramLayoutParams instanceof m))
        {
          paramLayoutParams = (m)paramLayoutParams;
          j = this.gQx.getWindow().getNavigationBarColor();
          if (j == paramLayoutParams.jaK) {
            break label104;
          }
        }
      }
    }
    label104:
    for (int i = 1;; i = 0)
    {
      paramLayoutParams.jaK = j;
      if (i != 0) {
        paramLayoutParams.invalidateSelf();
      }
      AppMethodBeat.o(143031);
      return;
    }
  }
  
  public final void a(i parami, MiniProgramNavigationBackResult paramMiniProgramNavigationBackResult)
  {
    AppMethodBeat.i(128965);
    if (paramMiniProgramNavigationBackResult != null) {
      try
      {
        if ((this.gQx instanceof AppBrandEmbedUI))
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("result_key_mini_program_navigate_back_result", paramMiniProgramNavigationBackResult);
          this.gQx.setResult(-1, localIntent);
          this.gQx.finish();
          AppMethodBeat.o(128965);
          return;
        }
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.AppBrandRuntimeContainerWC", localException, "close runtime %s", new Object[] { parami.mAppId });
      }
    }
    super.a(parami, paramMiniProgramNavigationBackResult);
    AppMethodBeat.o(128965);
  }
  
  public final void b(i parami1, i parami2, Runnable paramRunnable)
  {
    AppMethodBeat.i(128967);
    super.b(parami1, parami2, new l.1(this, paramRunnable));
    AppMethodBeat.o(128967);
  }
  
  public final void bf(boolean paramBoolean)
  {
    AppMethodBeat.i(128966);
    if (this.gQL)
    {
      ab.i("MicroMsg.AppBrandRuntimeContainerWC", "closeActivity(%b), mKeepActivityFrontOnce=TRUE", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(128966);
      return;
    }
    super.bf(paramBoolean);
    if (((this.gQx instanceof AppBrandPluginUI)) && (this.gQx.isFinishing()))
    {
      i locali = atG();
      if (locali != null) {}
      try
      {
        if (locali.atj().getCurrentPage().mSwiping) {
          this.gQx.overridePendingTransition(0, 0);
        }
        AppMethodBeat.o(128966);
        return;
      }
      catch (NullPointerException localNullPointerException) {}
    }
    AppMethodBeat.o(128966);
  }
  
  public final Activity getContext()
  {
    return this.gQx;
  }
  
  public final boolean wN()
  {
    AppMethodBeat.i(128970);
    if (this.gQz.size() <= 0)
    {
      bf(false);
      AppMethodBeat.o(128970);
      return true;
    }
    AppMethodBeat.o(128970);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.l
 * JD-Core Version:    0.7.0.1
 */