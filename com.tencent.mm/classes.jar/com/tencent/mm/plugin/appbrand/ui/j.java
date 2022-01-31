package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.t;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.k;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.weishi.e;
import com.tencent.mm.plugin.appbrand.widget.d;
import com.tencent.mm.ui.MMFragmentActivity.a;

public final class j
  implements s
{
  public static boolean I(i parami)
  {
    AppMethodBeat.i(133162);
    if ((parami instanceof o))
    {
      parami = (o)parami;
      if ((parami.atM()) || (parami.wS().bDh.scene == 1099))
      {
        AppMethodBeat.o(133162);
        return true;
      }
      AppMethodBeat.o(133162);
      return false;
    }
    AppMethodBeat.o(133162);
    return false;
  }
  
  private static int a(AppBrandStatObject paramAppBrandStatObject)
  {
    if (paramAppBrandStatObject == null) {
      return 0;
    }
    return paramAppBrandStatObject.scene;
  }
  
  private static void a(i parami, final int paramInt, final Runnable paramRunnable)
  {
    AppMethodBeat.i(133161);
    if (!t.as(parami.gPC))
    {
      parami.gPC.setWillNotDraw(true);
      parami.gPC.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(133154);
          j.b(this.gWQ, paramInt, paramRunnable);
          AppMethodBeat.o(133154);
        }
      });
      AppMethodBeat.o(133161);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(parami.getContext(), paramInt);
    localAnimation.setAnimationListener(new j.2(paramRunnable, parami));
    parami.gPC.startAnimation(localAnimation);
    AppMethodBeat.o(133161);
  }
  
  public final void a(Activity paramActivity, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(133157);
    if ((paramActivity == null) || (paramActivity.getIntent() == null))
    {
      AppMethodBeat.o(133157);
      return;
    }
    if (!(paramAppBrandInitConfig instanceof AppBrandInitConfigWC))
    {
      AppMethodBeat.o(133157);
      return;
    }
    AppBrandStatObject localAppBrandStatObject = ((AppBrandInitConfigWC)paramAppBrandInitConfig).bDh;
    try
    {
      boolean bool = k.a(paramActivity, paramAppBrandInitConfig, localAppBrandStatObject);
      if (bool)
      {
        AppMethodBeat.o(133157);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (e.b(paramActivity, paramAppBrandInitConfig))
      {
        AppMethodBeat.o(133157);
        return;
      }
      if (((AppBrandInitConfigWC)paramAppBrandInitConfig).hiD)
      {
        paramActivity.overridePendingTransition(MMFragmentActivity.a.zbX, MMFragmentActivity.a.zbY);
        AppMethodBeat.o(133157);
        return;
      }
      if (a(localAppBrandStatObject) == 1023)
      {
        i = 1;
        if (i == 0) {
          if ((a(localAppBrandStatObject) != 1113) && (a(localAppBrandStatObject) != 1114)) {
            break label170;
          }
        }
      }
      label170:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label175;
        }
        paramActivity.overridePendingTransition(2131034144, 2131034130);
        AppMethodBeat.o(133157);
        return;
        i = 0;
        break;
      }
      label175:
      if (1024 == a(localAppBrandStatObject)) {
        if (localAppBrandStatObject == null)
        {
          i = 0;
          if (6 != i) {
            break label230;
          }
        }
      }
      label230:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label235;
        }
        paramActivity.overridePendingTransition(MMFragmentActivity.a.zbZ, MMFragmentActivity.a.zca);
        AppMethodBeat.o(133157);
        return;
        i = localAppBrandStatObject.cJb;
        break;
      }
      label235:
      paramAppBrandInitConfig = paramActivity.getIntent();
      if ((paramAppBrandInitConfig != null) && (paramAppBrandInitConfig.getBooleanExtra("key_appbrand_bring_ui_to_front_from_task_Base_by_task_top_ui", false))) {}
      for (i = 1; i != 0; i = 0)
      {
        paramActivity.overridePendingTransition(2131034144, 2131034130);
        AppMethodBeat.o(133157);
        return;
      }
      if (1090 == a(localAppBrandStatObject))
      {
        paramActivity.overridePendingTransition(2131034145, 2131034143);
        AppMethodBeat.o(133157);
        return;
      }
      paramActivity.overridePendingTransition(2131034144, 2131034143);
      AppMethodBeat.o(133157);
    }
  }
  
  public final void a(i parami1, i parami2)
  {
    AppMethodBeat.i(133159);
    if (parami1 == null)
    {
      AppMethodBeat.o(133159);
      return;
    }
    if (I(parami1))
    {
      i = MMFragmentActivity.a.zbX;
      a(parami1, i, null);
      if (parami2 != null) {
        if (!I(parami1)) {
          break label65;
        }
      }
    }
    label65:
    for (int i = MMFragmentActivity.a.zbY;; i = 2131034130)
    {
      a(parami2, i, null);
      AppMethodBeat.o(133159);
      return;
      i = 2131034144;
      break;
    }
  }
  
  public final void a(i parami1, i parami2, Runnable paramRunnable)
  {
    AppMethodBeat.i(133160);
    if (parami2 == null)
    {
      AppMethodBeat.o(133160);
      return;
    }
    if (I(parami2))
    {
      i = MMFragmentActivity.a.zca;
      a(parami2, i, paramRunnable);
      if (parami1 != null) {
        if (!I(parami2)) {
          break label70;
        }
      }
    }
    label70:
    for (int i = MMFragmentActivity.a.zbZ;; i = 2131034130)
    {
      a(parami1, i, null);
      AppMethodBeat.o(133160);
      return;
      i = 2131034142;
      break;
    }
  }
  
  public final void j(Activity paramActivity)
  {
    AppMethodBeat.i(133158);
    paramActivity.overridePendingTransition(2131034141, 2131034142);
    AppMethodBeat.o(133158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.j
 * JD-Core Version:    0.7.0.1
 */