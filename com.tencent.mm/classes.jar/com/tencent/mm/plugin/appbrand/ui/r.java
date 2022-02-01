package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.u;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.e;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.m;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.ao;

public final class r
  implements ah
{
  private static void a(final AppBrandRuntime paramAppBrandRuntime, final int paramInt, final Runnable paramRunnable)
  {
    AppMethodBeat.i(48868);
    if (!u.az(paramAppBrandRuntime.kAt))
    {
      paramAppBrandRuntime.kAt.setWillNotDraw(true);
      paramAppBrandRuntime.kAt.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(175084);
          r.b(this.kTg, paramInt, paramRunnable);
          AppMethodBeat.o(175084);
        }
      });
      AppMethodBeat.o(48868);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), paramInt);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(175085);
        if (this.kDM != null) {
          MMHandlerThread.postToMainThread(this.kDM);
        }
        AppMethodBeat.o(175085);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(175086);
        paramAppBrandRuntime.kAt.setWillNotDraw(false);
        AppMethodBeat.o(175086);
      }
    });
    paramAppBrandRuntime.kAt.startAnimation(localAnimation);
    AppMethodBeat.o(48868);
  }
  
  public static boolean am(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48869);
    if ((paramAppBrandRuntime instanceof q))
    {
      paramAppBrandRuntime = (q)paramAppBrandRuntime;
      if ((paramAppBrandRuntime.bsr()) || (paramAppBrandRuntime.ON().cyA.scene == 1099))
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
    if (((AppBrandInitConfigWC)paramAppBrandInitConfig).kHP != null)
    {
      AppMethodBeat.o(48864);
      return;
    }
    AppBrandStatObject localAppBrandStatObject = ((AppBrandInitConfigWC)paramAppBrandInitConfig).cyA;
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
      if (ao.gJN())
      {
        paramActivity.overridePendingTransition(2130772009, 0);
        AppMethodBeat.o(48864);
        return;
      }
      if ((((AppBrandInitConfigWC)paramAppBrandInitConfig).ldN) || (((AppBrandInitConfigWC)paramAppBrandInitConfig).launchMode == 1))
      {
        paramActivity.overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
        AppMethodBeat.o(48864);
        return;
      }
      if (b(localAppBrandStatObject) == 1023)
      {
        i = 1;
        if (i == 0) {
          if ((b(localAppBrandStatObject) != 1113) && (b(localAppBrandStatObject) != 1114)) {
            break label216;
          }
        }
      }
      label216:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label221;
        }
        paramActivity.overridePendingTransition(2130772009, 2130771986);
        AppMethodBeat.o(48864);
        return;
        i = 0;
        break;
      }
      label221:
      if (1024 == b(localAppBrandStatObject)) {
        if (localAppBrandStatObject == null)
        {
          i = 0;
          if (6 != i) {
            break label276;
          }
        }
      }
      label276:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label281;
        }
        paramActivity.overridePendingTransition(MMFragmentActivity.a.ogo, MMFragmentActivity.a.ogp);
        AppMethodBeat.o(48864);
        return;
        i = localAppBrandStatObject.ecU;
        break;
      }
      label281:
      paramAppBrandInitConfig = paramActivity.getIntent();
      if ((paramAppBrandInitConfig != null) && (paramAppBrandInitConfig.getBooleanExtra("key_appbrand_bring_ui_to_front_from_task_Base_by_task_top_ui", false))) {}
      for (i = 1; i != 0; i = 0)
      {
        paramActivity.overridePendingTransition(2130772009, 2130771986);
        AppMethodBeat.o(48864);
        return;
      }
      if (1090 == b(localAppBrandStatObject))
      {
        paramActivity.overridePendingTransition(2130772010, 2130772008);
        AppMethodBeat.o(48864);
        return;
      }
      paramActivity.overridePendingTransition(2130772009, 2130772008);
      AppMethodBeat.o(48864);
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
    if (am(paramAppBrandRuntime2))
    {
      i = MMFragmentActivity.a.ogp;
      a(paramAppBrandRuntime2, i, paramRunnable);
      if (paramAppBrandRuntime1 != null) {
        if (!am(paramAppBrandRuntime2)) {
          break label70;
        }
      }
    }
    label70:
    for (int i = MMFragmentActivity.a.ogo;; i = 2130771986)
    {
      a(paramAppBrandRuntime1, i, null);
      AppMethodBeat.o(48867);
      return;
      i = 2130772007;
      break;
    }
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime1, final Runnable paramRunnable, AppBrandRuntime paramAppBrandRuntime2)
  {
    AppMethodBeat.i(227699);
    if (paramAppBrandRuntime1 == null)
    {
      AppMethodBeat.o(227699);
      return;
    }
    if (am(paramAppBrandRuntime1))
    {
      i = MMFragmentActivity.a.ogm;
      a(paramAppBrandRuntime1, i, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48861);
          if ((paramAppBrandRuntime1 instanceof q)) {
            ((q)paramAppBrandRuntime1).onEnterAnimationComplete();
          }
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(48861);
        }
      });
      if (paramAppBrandRuntime2 != null) {
        if (!am(paramAppBrandRuntime1)) {
          break label79;
        }
      }
    }
    label79:
    for (int i = MMFragmentActivity.a.ogn;; i = 2130771986)
    {
      a(paramAppBrandRuntime2, i, null);
      AppMethodBeat.o(227699);
      return;
      i = 2130772009;
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
    if (ao.gJN())
    {
      paramActivity.overridePendingTransition(0, 2130772007);
      AppMethodBeat.o(48865);
      return;
    }
    paramActivity.overridePendingTransition(2130772006, 2130772007);
    AppMethodBeat.o(48865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.r
 * JD-Core Version:    0.7.0.1
 */