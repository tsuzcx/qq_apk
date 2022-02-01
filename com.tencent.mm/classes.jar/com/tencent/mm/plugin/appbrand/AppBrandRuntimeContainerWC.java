package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.view.t;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.f;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.j;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.r.a.c.b;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.widget.input.w;
import com.tencent.mm.plugin.appbrand.widget.m;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.am;
import d.g.b.k;
import d.v;
import java.util.List;
import java.util.Locale;

public class AppBrandRuntimeContainerWC
  extends com.tencent.luggage.sdk.d.a
{
  private boolean jfB;
  public final Class[] jfC;
  
  static
  {
    AppMethodBeat.i(43852);
    p.a.a(f.lqU);
    p.a.a(com.tencent.mm.plugin.appbrand.luggage.c.b.lrj);
    AppMethodBeat.o(43852);
  }
  
  public AppBrandRuntimeContainerWC(com.tencent.mm.plugin.appbrand.task.g paramg)
  {
    super(paramg, o.class);
    AppMethodBeat.i(43841);
    this.jfB = false;
    this.jfC = new Class[] { j.class };
    paramg = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pST, "null");
    k.h(paramg, "blackList");
    Object localObject = Locale.US;
    k.g(localObject, "Locale.US");
    paramg = paramg.toLowerCase((Locale)localObject);
    k.g(paramg, "(this as java.lang.String).toLowerCase(locale)");
    paramg = d.n.n.a((CharSequence)paramg, new String[] { ";" });
    boolean bool;
    if (paramg.contains("all")) {
      bool = true;
    }
    for (;;)
    {
      this.jfi = bool;
      if (Build.VERSION.SDK_INT >= 21)
      {
        getContext();
        if (com.tencent.mm.plugin.appbrand.widget.input.a.bzH()) {
          m.a(com.tencent.mm.sdk.f.a.jg(this.mContext), com.tencent.mm.sdk.f.a.jg(this.mContext).getWindow().getDecorView());
        }
      }
      if (Build.VERSION.SDK_INT >= 26) {
        this.mContentView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
        {
          public final void onSystemUiVisibilityChange(int paramAnonymousInt)
          {
            AppMethodBeat.i(174649);
            Object localObject;
            if (t.aC(AppBrandRuntimeContainerWC.this.mContentView))
            {
              localObject = com.tencent.mm.sdk.f.a.jg(AppBrandRuntimeContainerWC.this.mContext);
              if ((localObject != null) && (((Activity)localObject).getWindow() != null))
              {
                bool = am.ZN(((Activity)localObject).getWindow().getNavigationBarColor());
                localObject = ((Activity)localObject).getWindow();
                if (bool) {
                  break label73;
                }
              }
            }
            label73:
            for (boolean bool = true;; bool = false)
            {
              aj.d((Window)localObject, bool);
              AppMethodBeat.o(174649);
              return;
            }
          }
        });
      }
      AppMethodBeat.o(43841);
      return;
      if (!paramg.contains("null"))
      {
        localObject = Build.MODEL;
        k.g(localObject, "Build.MODEL");
        Locale localLocale = Locale.US;
        k.g(localLocale, "Locale.US");
        if (localObject == null)
        {
          paramg = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(43841);
          throw paramg;
        }
        localObject = ((String)localObject).toLowerCase(localLocale);
        k.g(localObject, "(this as java.lang.String).toLowerCase(locale)");
        if (paramg.contains(localObject))
        {
          bool = true;
          continue;
        }
      }
      bool = false;
    }
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
    if (!aj.DT()) {}
    for (paramConfiguration.uiMode |= 0x10;; paramConfiguration.uiMode |= 0x20)
    {
      ai.getContext().getResources().updateConfiguration(paramConfiguration, ai.getResources().getDisplayMetrics());
      AppMethodBeat.o(180171);
      return;
    }
  }
  
  private void aTF()
  {
    AppMethodBeat.i(43845);
    if (((com.tencent.mm.sdk.f.a.jg(this.mContext) instanceof AppBrandPluginUI)) && (((Boolean)com.tencent.mm.plugin.appbrand.game.a.n.jQG.aqp()).booleanValue())) {
      com.tencent.mm.ui.base.b.bi(com.tencent.mm.sdk.f.a.jg(this.mContext));
    }
    AppMethodBeat.o(43845);
  }
  
  private void g(AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(43843);
    if (paramAppBrandInitConfig == null)
    {
      AppMethodBeat.o(43843);
      return;
    }
    int i;
    if (((paramAppBrandInitConfig instanceof AppBrandInitConfigLU)) && (((AppBrandInitConfigLU)paramAppBrandInitConfig).CC()))
    {
      i = 1;
      if (i == 0) {
        break label85;
      }
    }
    label85:
    for (paramAppBrandInitConfig = w.di(this.mContentView);; paramAppBrandInitConfig = com.tencent.luggage.game.widget.input.a.co(this.mContentView))
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
  
  public final boolean Dw()
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
    if ((com.tencent.mm.sdk.f.a.jg(this.mContext) != null) && (com.tencent.mm.sdk.f.a.jg(this.mContext).getWindow() != null))
    {
      paramLayoutParams = com.tencent.mm.sdk.f.a.jg(this.mContext).getWindow().getDecorView();
      if ((paramLayoutParams.getWindowSystemUiVisibility() & 0x2) == 0)
      {
        paramLayoutParams = paramLayoutParams.getBackground();
        if ((paramLayoutParams instanceof m))
        {
          paramLayoutParams = (m)paramLayoutParams;
          j = com.tencent.mm.sdk.f.a.jg(this.mContext).getWindow().getNavigationBarColor();
          if (j == paramLayoutParams.msI) {
            break label118;
          }
        }
      }
    }
    label118:
    for (int i = 1;; i = 0)
    {
      paramLayoutParams.msI = j;
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
    if (this.jfB)
    {
      ac.i("MicroMsg.AppBrandRuntimeContainerWC", "closeActivity(%b), mKeepActivityFrontOnce=TRUE", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(43847);
      return;
    }
    super.bx(paramBoolean);
    if (((com.tencent.mm.sdk.f.a.jg(this.mContext) instanceof AppBrandPluginUI)) && (com.tencent.mm.sdk.f.a.jg(this.mContext).isFinishing()))
    {
      AppBrandRuntime localAppBrandRuntime = getActiveRuntime();
      if (localAppBrandRuntime != null) {}
      try
      {
        if (localAppBrandRuntime.aSA().getCurrentPage().mSwiping) {
          com.tencent.mm.sdk.f.a.jg(this.mContext).overridePendingTransition(0, 0);
        }
        AppMethodBeat.o(43847);
        return;
      }
      catch (NullPointerException localNullPointerException) {}
    }
    AppMethodBeat.o(43847);
  }
  
  public final int getWindowColor()
  {
    AppMethodBeat.i(180169);
    AppBrandRuntime localAppBrandRuntime = getActiveRuntime();
    if (((localAppBrandRuntime instanceof o)) && (((o)localAppBrandRuntime).CC())) {}
    for (int i = com.tencent.mm.cc.a.n(getContext(), 2131100017);; i = super.getWindowColor())
    {
      AppMethodBeat.o(180169);
      return i;
    }
  }
  
  public final void onConfigurationChanged(final Configuration paramConfiguration)
  {
    AppMethodBeat.i(180170);
    a(paramConfiguration);
    ap.f(new Runnable()
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
  
  public void setWindowDescription(c.b paramb)
  {
    AppMethodBeat.i(174652);
    Activity localActivity = com.tencent.mm.sdk.f.a.jg(this.mContext);
    if (localActivity == null)
    {
      AppMethodBeat.o(174652);
      return;
    }
    if (((localActivity instanceof AppBrandUI)) && (((AppBrandUI)localActivity).aTs())) {
      super.setWindowDescription(paramb);
    }
    AppMethodBeat.o(174652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.AppBrandRuntimeContainerWC
 * JD-Core Version:    0.7.0.1
 */