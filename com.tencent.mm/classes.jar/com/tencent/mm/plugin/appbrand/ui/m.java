package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.t;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.k;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.d;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMFragmentActivity.a;

public final class m
  implements z
{
  private static int a(AppBrandStatObject paramAppBrandStatObject)
  {
    if (paramAppBrandStatObject == null) {
      return 0;
    }
    return paramAppBrandStatObject.scene;
  }
  
  private static void a(final AppBrandRuntime paramAppBrandRuntime, final int paramInt, final Runnable paramRunnable)
  {
    AppMethodBeat.i(48868);
    if (!t.ay(paramAppBrandRuntime.iDA))
    {
      paramAppBrandRuntime.iDA.setWillNotDraw(true);
      paramAppBrandRuntime.iDA.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(175084);
          m.b(this.iOB, paramInt, paramRunnable);
          AppMethodBeat.o(175084);
        }
      });
      AppMethodBeat.o(48868);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(aj.getContext(), paramInt);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(175085);
        if (this.iGG != null) {
          aq.f(this.iGG);
        }
        AppMethodBeat.o(175085);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(175086);
        paramAppBrandRuntime.iDA.setWillNotDraw(false);
        AppMethodBeat.o(175086);
      }
    });
    paramAppBrandRuntime.iDA.startAnimation(localAnimation);
    AppMethodBeat.o(48868);
  }
  
  public static boolean ar(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48869);
    if ((paramAppBrandRuntime instanceof o))
    {
      paramAppBrandRuntime = (o)paramAppBrandRuntime;
      if ((paramAppBrandRuntime.aMT()) || (paramAppBrandRuntime.DZ().cfo.scene == 1099))
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
    AppBrandStatObject localAppBrandStatObject = ((AppBrandInitConfigWC)paramAppBrandInitConfig).cfo;
    try
    {
      boolean bool = k.a(paramActivity, paramAppBrandInitConfig, localAppBrandStatObject);
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
      if ((((AppBrandInitConfigWC)paramAppBrandInitConfig).jdl) || (((AppBrandInitConfigWC)paramAppBrandInitConfig).launchMode == 1))
      {
        paramActivity.overridePendingTransition(MMFragmentActivity.a.lLF, MMFragmentActivity.a.lLG);
        AppMethodBeat.o(48864);
        return;
      }
      if (a(localAppBrandStatObject) == 1023)
      {
        i = 1;
        if (i == 0) {
          if ((a(localAppBrandStatObject) != 1113) && (a(localAppBrandStatObject) != 1114)) {
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
      if (1024 == a(localAppBrandStatObject)) {
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
        paramActivity.overridePendingTransition(MMFragmentActivity.a.lLH, MMFragmentActivity.a.lLI);
        AppMethodBeat.o(48864);
        return;
        i = localAppBrandStatObject.dzS;
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
      if (1090 == a(localAppBrandStatObject))
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
    if (ar(paramAppBrandRuntime1))
    {
      i = MMFragmentActivity.a.lLF;
      a(paramAppBrandRuntime1, i, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48861);
          if ((paramAppBrandRuntime1 instanceof o)) {
            ((o)paramAppBrandRuntime1).onEnterAnimationComplete();
          }
          if (this.lCX != null) {
            this.lCX.run();
          }
          AppMethodBeat.o(48861);
        }
      });
      if (paramAppBrandRuntime2 != null) {
        if (!ar(paramAppBrandRuntime1)) {
          break label73;
        }
      }
    }
    label73:
    for (int i = MMFragmentActivity.a.lLG;; i = 2130771986)
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
    if (ar(paramAppBrandRuntime2))
    {
      i = MMFragmentActivity.a.lLI;
      a(paramAppBrandRuntime2, i, paramRunnable);
      if (paramAppBrandRuntime1 != null) {
        if (!ar(paramAppBrandRuntime2)) {
          break label70;
        }
      }
    }
    label70:
    for (int i = MMFragmentActivity.a.lLH;; i = 2130771986)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.m
 * JD-Core Version:    0.7.0.1
 */