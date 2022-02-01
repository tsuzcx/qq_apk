package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import androidx.core.g.w;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ag.e;
import com.tencent.mm.plugin.appbrand.au.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.m;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.ar;

public enum p
  implements ah
{
  static
  {
    AppMethodBeat.i(272627);
    qYV = new p("INSTANCE");
    qYW = new p[] { qYV };
    AppMethodBeat.o(272627);
  }
  
  private p() {}
  
  private static boolean N(Intent paramIntent)
  {
    AppMethodBeat.i(272622);
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("key_appbrand_bring_ui_to_front_from_task_Base_by_task_top_ui", false)))
    {
      AppMethodBeat.o(272622);
      return true;
    }
    AppMethodBeat.o(272622);
    return false;
  }
  
  private static void a(final AppBrandRuntime paramAppBrandRuntime, final int paramInt, final Runnable paramRunnable)
  {
    AppMethodBeat.i(48868);
    if (!w.ah(paramAppBrandRuntime.ntC))
    {
      paramAppBrandRuntime.ntC.setWillNotDraw(true);
      paramAppBrandRuntime.ntC.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(175084);
          p.b(this.nNE, paramInt, paramRunnable);
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
        if (this.nxa != null) {
          MMHandlerThread.postToMainThread(this.nxa);
        }
        AppMethodBeat.o(175085);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(175086);
        paramAppBrandRuntime.ntC.setWillNotDraw(false);
        AppMethodBeat.o(175086);
      }
    });
    paramAppBrandRuntime.ntC.startAnimation(localAnimation);
    AppMethodBeat.o(48868);
  }
  
  public static boolean an(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48869);
    if ((paramAppBrandRuntime instanceof t))
    {
      paramAppBrandRuntime = (t)paramAppBrandRuntime;
      if ((paramAppBrandRuntime.bDl()) || (paramAppBrandRuntime.Sk().cxf.scene == 1099))
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
  
  private static boolean c(AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(272618);
    if (b(paramAppBrandStatObject) == 1023)
    {
      AppMethodBeat.o(272618);
      return true;
    }
    AppMethodBeat.o(272618);
    return false;
  }
  
  private static boolean d(AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(272620);
    if ((b(paramAppBrandStatObject) == 1113) || (b(paramAppBrandStatObject) == 1114))
    {
      AppMethodBeat.o(272620);
      return true;
    }
    AppMethodBeat.o(272620);
    return false;
  }
  
  private static boolean e(AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(272621);
    if (1024 == b(paramAppBrandStatObject))
    {
      if (paramAppBrandStatObject == null) {}
      for (int i = 0; 6 == i; i = paramAppBrandStatObject.fXa)
      {
        AppMethodBeat.o(272621);
        return true;
      }
    }
    AppMethodBeat.o(272621);
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
    if (((AppBrandInitConfigWC)paramAppBrandInitConfig).nBI != null)
    {
      AppMethodBeat.o(48864);
      return;
    }
    AppBrandStatObject localAppBrandStatObject = ((AppBrandInitConfigWC)paramAppBrandInitConfig).cxf;
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
      if (ar.hIO())
      {
        paramActivity.overridePendingTransition(au.a.appbrand_ui_push_open_enter, 0);
        AppMethodBeat.o(48864);
        return;
      }
      if ((((AppBrandInitConfigWC)paramAppBrandInitConfig).nYb) || (((AppBrandInitConfigWC)paramAppBrandInitConfig).launchMode == 1))
      {
        paramActivity.overridePendingTransition(MMFragmentActivity.a.rhY, MMFragmentActivity.a.rhZ);
        AppMethodBeat.o(48864);
        return;
      }
      if ((c(localAppBrandStatObject)) || (d(localAppBrandStatObject)))
      {
        paramActivity.overridePendingTransition(au.a.appbrand_ui_push_open_enter, au.a.anim_not_change);
        AppMethodBeat.o(48864);
        return;
      }
      if (e(localAppBrandStatObject))
      {
        paramActivity.overridePendingTransition(MMFragmentActivity.a.ria, MMFragmentActivity.a.rib);
        AppMethodBeat.o(48864);
        return;
      }
      if (N(paramActivity.getIntent()))
      {
        paramActivity.overridePendingTransition(au.a.appbrand_ui_push_open_enter, au.a.anim_not_change);
        AppMethodBeat.o(48864);
        return;
      }
      if (1090 == b(localAppBrandStatObject))
      {
        paramActivity.overridePendingTransition(au.a.appbrand_ui_switch_enter, au.a.appbrand_ui_push_enter_exit);
        AppMethodBeat.o(48864);
        return;
      }
      paramActivity.overridePendingTransition(au.a.appbrand_ui_push_open_enter, au.a.appbrand_ui_push_enter_exit);
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
    if (an(paramAppBrandRuntime2))
    {
      i = MMFragmentActivity.a.rib;
      a(paramAppBrandRuntime2, i, paramRunnable);
      if (paramAppBrandRuntime1 != null) {
        if (!an(paramAppBrandRuntime2)) {
          break label71;
        }
      }
    }
    label71:
    for (int i = MMFragmentActivity.a.ria;; i = au.a.anim_not_change)
    {
      a(paramAppBrandRuntime1, i, null);
      AppMethodBeat.o(48867);
      return;
      i = au.a.appbrand_ui_push_close_exit;
      break;
    }
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime1, final Runnable paramRunnable, AppBrandRuntime paramAppBrandRuntime2)
  {
    AppMethodBeat.i(272625);
    if (paramAppBrandRuntime1 == null)
    {
      AppMethodBeat.o(272625);
      return;
    }
    if (an(paramAppBrandRuntime1))
    {
      i = MMFragmentActivity.a.rhY;
      a(paramAppBrandRuntime1, i, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48861);
          if ((paramAppBrandRuntime1 instanceof t)) {
            ((t)paramAppBrandRuntime1).onEnterAnimationComplete();
          }
          if (paramRunnable != null) {
            paramRunnable.run();
          }
          AppMethodBeat.o(48861);
        }
      });
      if (paramAppBrandRuntime2 != null) {
        if (!an(paramAppBrandRuntime1)) {
          break label80;
        }
      }
    }
    label80:
    for (int i = MMFragmentActivity.a.rhZ;; i = au.a.anim_not_change)
    {
      a(paramAppBrandRuntime2, i, null);
      AppMethodBeat.o(272625);
      return;
      i = au.a.appbrand_ui_push_open_enter;
      break;
    }
  }
  
  public final void k(Activity paramActivity)
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
    if (ar.hIO())
    {
      paramActivity.overridePendingTransition(0, au.a.appbrand_ui_push_close_exit);
      AppMethodBeat.o(48865);
      return;
    }
    paramActivity.overridePendingTransition(au.a.appbrand_ui_push_close_enter, au.a.appbrand_ui_push_close_exit);
    AppMethodBeat.o(48865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.p
 * JD-Core Version:    0.7.0.1
 */