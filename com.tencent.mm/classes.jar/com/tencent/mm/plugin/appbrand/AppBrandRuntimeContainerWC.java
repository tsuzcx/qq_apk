package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.platform.window.c.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.widget.input.w;
import com.tencent.mm.plugin.appbrand.widget.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ao;

public class AppBrandRuntimeContainerWC
  extends com.tencent.luggage.sdk.d.b
{
  private boolean jBH;
  public final Class[] jBI;
  
  static
  {
    AppMethodBeat.i(43852);
    q.a.a(com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.g.lSU);
    q.a.a(com.tencent.mm.plugin.appbrand.luggage.c.b.lUU);
    AppMethodBeat.o(43852);
  }
  
  public AppBrandRuntimeContainerWC(com.tencent.mm.plugin.appbrand.task.g paramg)
  {
    super(paramg, p.class);
    AppMethodBeat.i(43841);
    this.jBH = false;
    this.jBI = new Class[] { l.class };
    if (Build.VERSION.SDK_INT >= 21)
    {
      getContext();
      if (com.tencent.mm.plugin.appbrand.widget.input.a.bEC()) {
        m.a(com.tencent.mm.sdk.f.a.jw(this.mContext), com.tencent.mm.sdk.f.a.jw(this.mContext).getWindow().getDecorView());
      }
    }
    if (Build.VERSION.SDK_INT >= 26) {
      this.mContentView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
      {
        public final void onSystemUiVisibilityChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(174649);
          Object localObject;
          if (android.support.v4.view.t.aC(AppBrandRuntimeContainerWC.this.mContentView))
          {
            localObject = com.tencent.mm.sdk.f.a.jw(AppBrandRuntimeContainerWC.this.mContext);
            if ((localObject != null) && (((Activity)localObject).getWindow() != null))
            {
              bool = ao.acF(((Activity)localObject).getWindow().getNavigationBarColor());
              localObject = ((Activity)localObject).getWindow();
              if (bool) {
                break label73;
              }
            }
          }
          label73:
          for (boolean bool = true;; bool = false)
          {
            al.d((Window)localObject, bool);
            AppMethodBeat.o(174649);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(43841);
  }
  
  private static void a(Configuration paramConfiguration)
  {
    AppMethodBeat.i(180171);
    if (Build.VERSION.SDK_INT < 29)
    {
      AppMethodBeat.o(180171);
      return;
    }
    paramConfiguration.uiMode &= 0xFFFFFFCF;
    if (!al.isDarkMode()) {}
    for (paramConfiguration.uiMode |= 0x10;; paramConfiguration.uiMode |= 0x20)
    {
      ak.getContext().getResources().updateConfiguration(paramConfiguration, ak.getResources().getDisplayMetrics());
      AppMethodBeat.o(180171);
      return;
    }
  }
  
  private void aXj()
  {
    AppMethodBeat.i(43845);
    if (((com.tencent.mm.sdk.f.a.jw(this.mContext) instanceof AppBrandPluginUI)) && (((Boolean)com.tencent.mm.plugin.appbrand.game.a.q.kol.att()).booleanValue())) {
      com.tencent.mm.ui.base.b.bj(com.tencent.mm.sdk.f.a.jw(this.mContext));
    }
    AppMethodBeat.o(43845);
  }
  
  private void f(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(43843);
    if (paramAppBrandInitConfig == null)
    {
      AppMethodBeat.o(43843);
      return;
    }
    int i;
    if (((paramAppBrandInitConfig instanceof AppBrandInitConfigLU)) && (((AppBrandInitConfigLU)paramAppBrandInitConfig).Ee()))
    {
      i = 1;
      if (i == 0) {
        break label82;
      }
    }
    label82:
    for (paramAppBrandInitConfig = w.dk(this.mContentView);; paramAppBrandInitConfig = com.tencent.luggage.game.widget.input.a.co(this.mContentView))
    {
      if ((paramAppBrandInitConfig != null) && ((paramAppBrandInitConfig.getParent() instanceof ViewGroup))) {
        ((ViewGroup)paramAppBrandInitConfig.getParent()).removeView(paramAppBrandInitConfig);
      }
      AppMethodBeat.o(43843);
      return;
      i = 0;
      break;
    }
  }
  
  public final boolean Fa()
  {
    AppMethodBeat.i(43846);
    if (getStackSize() <= 0)
    {
      bx(false);
      AppMethodBeat.o(43846);
      return true;
    }
    AppMethodBeat.o(43846);
    return false;
  }
  
  public final void a(WindowManager.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(43842);
    super.a(paramLayoutParams);
    int j;
    if ((com.tencent.mm.sdk.f.a.jw(this.mContext) != null) && (com.tencent.mm.sdk.f.a.jw(this.mContext).getWindow() != null))
    {
      paramLayoutParams = com.tencent.mm.sdk.f.a.jw(this.mContext).getWindow().getDecorView();
      if ((paramLayoutParams.getWindowSystemUiVisibility() & 0x2) == 0)
      {
        paramLayoutParams = paramLayoutParams.getBackground();
        if ((paramLayoutParams instanceof m))
        {
          paramLayoutParams = (m)paramLayoutParams;
          j = com.tencent.mm.sdk.f.a.jw(this.mContext).getWindow().getNavigationBarColor();
          if (j == paramLayoutParams.mYw) {
            break label116;
          }
        }
      }
    }
    label116:
    for (int i = 1;; i = 0)
    {
      paramLayoutParams.mYw = j;
      if (i != 0) {
        paramLayoutParams.invalidateSelf();
      }
      AppMethodBeat.o(43842);
      return;
    }
  }
  
  public final void b(AppBrandRuntime paramAppBrandRuntime1, AppBrandRuntime paramAppBrandRuntime2, final Runnable paramRunnable)
  {
    AppMethodBeat.i(43844);
    super.b(paramAppBrandRuntime1, paramAppBrandRuntime2, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174651);
        paramRunnable.run();
        if ((AppBrandRuntimeContainerWC.this.getActiveRuntime() != null) && (!AppBrandRuntimeWCAccessible.isGame(AppBrandRuntimeContainerWC.this.getActiveRuntime()))) {
          AppBrandRuntimeContainerWC.b(AppBrandRuntimeContainerWC.this);
        }
        AppMethodBeat.o(174651);
      }
    });
    AppMethodBeat.o(43844);
  }
  
  public final void bx(boolean paramBoolean)
  {
    AppMethodBeat.i(43847);
    if (this.jBH)
    {
      ae.i("MicroMsg.AppBrandRuntimeContainerWC", "closeActivity(%b), mKeepActivityFrontOnce=TRUE", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(43847);
      return;
    }
    super.bx(paramBoolean);
    if (((com.tencent.mm.sdk.f.a.jw(this.mContext) instanceof AppBrandPluginUI)) && (com.tencent.mm.sdk.f.a.jw(this.mContext).isFinishing()))
    {
      AppBrandRuntime localAppBrandRuntime = getActiveRuntime();
      if (localAppBrandRuntime != null) {}
      try
      {
        if (localAppBrandRuntime.aWm().getCurrentPage().mSwiping) {
          com.tencent.mm.sdk.f.a.jw(this.mContext).overridePendingTransition(0, 0);
        }
        AppMethodBeat.o(43847);
        return;
      }
      catch (NullPointerException localNullPointerException) {}
    }
    AppMethodBeat.o(43847);
  }
  
  public final void onConfigurationChanged(final Configuration paramConfiguration)
  {
    AppMethodBeat.i(180170);
    a(paramConfiguration);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(180168);
        AppBrandRuntimeContainerWC.b(paramConfiguration);
        AppMethodBeat.o(180168);
      }
    });
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(180170);
  }
  
  public void setWindowDescription(c.a parama)
  {
    AppMethodBeat.i(174652);
    Activity localActivity = com.tencent.mm.sdk.f.a.jw(this.mContext);
    if (localActivity == null)
    {
      AppMethodBeat.o(174652);
      return;
    }
    if (((localActivity instanceof AppBrandUI)) && (((AppBrandUI)localActivity).aXc())) {
      super.setWindowDescription(parama);
    }
    AppMethodBeat.o(174652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC
 * JD-Core Version:    0.7.0.1
 */