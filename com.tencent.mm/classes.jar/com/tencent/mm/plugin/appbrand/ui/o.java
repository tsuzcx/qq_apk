package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.t;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aa.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.m;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.MMFragmentActivity.a;

public final class o
  implements ab
{
  private static void a(final AppBrandRuntime paramAppBrandRuntime, final int paramInt, final Runnable paramRunnable)
  {
    AppMethodBeat.i(48868);
    if (!t.ay(paramAppBrandRuntime.jzF))
    {
      paramAppBrandRuntime.jzF.setWillNotDraw(true);
      paramAppBrandRuntime.jzF.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(175084);
          o.b(this.jLH, paramInt, paramRunnable);
          AppMethodBeat.o(175084);
        }
      });
      AppMethodBeat.o(48868);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(ak.getContext(), paramInt);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(175085);
        if (this.jCM != null) {
          ar.f(this.jCM);
        }
        AppMethodBeat.o(175085);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(175086);
        paramAppBrandRuntime.jzF.setWillNotDraw(false);
        AppMethodBeat.o(175086);
      }
    });
    paramAppBrandRuntime.jzF.startAnimation(localAnimation);
    AppMethodBeat.o(48868);
  }
  
  public static boolean al(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48869);
    if ((paramAppBrandRuntime instanceof p))
    {
      paramAppBrandRuntime = (p)paramAppBrandRuntime;
      if ((paramAppBrandRuntime.aXo()) || (paramAppBrandRuntime.Fg().cmE.scene == 1099))
      {
        AppMethodBeat.o(48869);
        return true;
      }
      AppMethodBeat.o(48869);
      return false;
    }
    AppMethodBeat.o(48869);
    return false;
  }
  
  private static int b(AppBrandStatObject paramAppBrandStatObject)
  {
    if (paramAppBrandStatObject == null) {
      return 0;
    }
    return paramAppBrandStatObject.scene;
  }
  
  public final void a(Activity paramActivity, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(48864);
    if ((paramActivity == null) || (paramActivity.getIntent() == null))
    {
      AppMethodBeat.o(48864);
      return;
    }
    if (!(paramAppBrandInitConfig instanceof AppBrandInitConfigWC))
    {
      AppMethodBeat.o(48864);
      return;
    }
    AppBrandStatObject localAppBrandStatObject = ((AppBrandInitConfigWC)paramAppBrandInitConfig).cmE;
    try
    {
      boolean bool = m.a(paramActivity, paramAppBrandInitConfig, localAppBrandStatObject);
      if (bool)
      {
        AppMethodBeat.o(48864);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (e.b(paramActivity, paramAppBrandInitConfig))
      {
        AppMethodBeat.o(48864);
        return;
      }
      if ((((AppBrandInitConfigWC)paramAppBrandInitConfig).kaJ) || (((AppBrandInitConfigWC)paramAppBrandInitConfig).launchMode == 1))
      {
        paramActivity.overridePendingTransition(MMFragmentActivity.a.mTi, MMFragmentActivity.a.mTj);
        AppMethodBeat.o(48864);
        return;
      }
      if (b(localAppBrandStatObject) == 1023)
      {
        i = 1;
        if (i == 0) {
          if ((b(localAppBrandStatObject) != 1113) && (b(localAppBrandStatObject) != 1114)) {
            break label181;
          }
        }
      }
      label181:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label186;
        }
        paramActivity.overridePendingTransition(2130772004, 2130771986);
        AppMethodBeat.o(48864);
        return;
        i = 0;
        break;
      }
      label186:
      if (1024 == b(localAppBrandStatObject)) {
        if (localAppBrandStatObject == null)
        {
          i = 0;
          if (6 != i) {
            break label241;
          }
        }
      }
      label241:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label246;
        }
        paramActivity.overridePendingTransition(MMFragmentActivity.a.mTk, MMFragmentActivity.a.mTl);
        AppMethodBeat.o(48864);
        return;
        i = localAppBrandStatObject.dLf;
        break;
      }
      label246:
      paramAppBrandInitConfig = paramActivity.getIntent();
      if ((paramAppBrandInitConfig != null) && (paramAppBrandInitConfig.getBooleanExtra("key_appbrand_bring_ui_to_front_from_task_Base_by_task_top_ui", false))) {}
      for (i = 1; i != 0; i = 0)
      {
        paramActivity.overridePendingTransition(2130772004, 2130771986);
        AppMethodBeat.o(48864);
        return;
      }
      if (1090 == b(localAppBrandStatObject))
      {
        paramActivity.overridePendingTransition(2130772005, 2130772003);
        AppMethodBeat.o(48864);
        return;
      }
      paramActivity.overridePendingTransition(2130772004, 2130772003);
      AppMethodBeat.o(48864);
    }
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime1, AppBrandRuntime paramAppBrandRuntime2)
  {
    AppMethodBeat.i(48866);
    if (paramAppBrandRuntime1 == null)
    {
      AppMethodBeat.o(48866);
      return;
    }
    if (al(paramAppBrandRuntime1))
    {
      i = MMFragmentActivity.a.mTi;
      a(paramAppBrandRuntime1, i, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48861);
          if ((paramAppBrandRuntime1 instanceof p)) {
            ((p)paramAppBrandRuntime1).onEnterAnimationComplete();
          }
          if (this.mKt != null) {
            this.mKt.run();
          }
          AppMethodBeat.o(48861);
        }
      });
      if (paramAppBrandRuntime2 != null) {
        if (!al(paramAppBrandRuntime1)) {
          break label73;
        }
      }
    }
    label73:
    for (int i = MMFragmentActivity.a.mTj;; i = 2130771986)
    {
      a(paramAppBrandRuntime2, i, null);
      AppMethodBeat.o(48866);
      return;
      i = 2130772004;
      break;
    }
  }
  
  public final void a(AppBrandRuntime paramAppBrandRuntime1, AppBrandRuntime paramAppBrandRuntime2, Runnable paramRunnable)
  {
    AppMethodBeat.i(48867);
    if (paramAppBrandRuntime2 == null)
    {
      AppMethodBeat.o(48867);
      return;
    }
    if (al(paramAppBrandRuntime2))
    {
      i = MMFragmentActivity.a.mTl;
      a(paramAppBrandRuntime2, i, paramRunnable);
      if (paramAppBrandRuntime1 != null) {
        if (!al(paramAppBrandRuntime2)) {
          break label70;
        }
      }
    }
    label70:
    for (int i = MMFragmentActivity.a.mTk;; i = 2130771986)
    {
      a(paramAppBrandRuntime1, i, null);
      AppMethodBeat.o(48867);
      return;
      i = 2130772002;
      break;
    }
  }
  
  public final void m(Activity paramActivity)
  {
    AppMethodBeat.i(48865);
    if (paramActivity == null)
    {
      AppMethodBeat.o(48865);
      return;
    }
    int i = 0;
    while (i <= 0)
    {
      if (new Class[] { AppBrandPluginUI.class }[0].isInstance(paramActivity))
      {
        AppMethodBeat.o(48865);
        return;
      }
      i += 1;
    }
    paramActivity.overridePendingTransition(2130772001, 2130772002);
    AppMethodBeat.o(48865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.o
 * JD-Core Version:    0.7.0.1
 */