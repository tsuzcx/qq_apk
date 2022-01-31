package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.q;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.y.a;
import com.tencent.mm.ui.MMFragmentActivity.a;

public final class h
  implements r
{
  private static int a(AppBrandStatObject paramAppBrandStatObject)
  {
    if (paramAppBrandStatObject == null) {
      return 0;
    }
    return paramAppBrandStatObject.scene;
  }
  
  private static void a(i parami, int paramInt, Runnable paramRunnable)
  {
    if (!q.al(parami.fyq))
    {
      parami.fyq.setWillNotDraw(true);
      parami.fyq.post(new h.1(parami, paramInt, paramRunnable));
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(parami.getContext(), paramInt);
    localAnimation.setAnimationListener(new h.2(paramRunnable, parami));
    parami.fyq.startAnimation(localAnimation);
  }
  
  public final void a(Activity paramActivity, AppBrandStatObject paramAppBrandStatObject)
  {
    int j = 1;
    if ((paramActivity == null) || (paramActivity.getIntent() == null)) {
      return;
    }
    if (a(paramAppBrandStatObject) == 1023) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramActivity.overridePendingTransition(y.a.appbrand_ui_push_open_enter, y.a.anim_not_change);
      return;
    }
    if (1024 == a(paramAppBrandStatObject)) {
      if (paramAppBrandStatObject == null)
      {
        i = 0;
        if (6 != i) {
          break label94;
        }
      }
    }
    label94:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label99;
      }
      paramActivity.overridePendingTransition(MMFragmentActivity.a.uOg, MMFragmentActivity.a.uOh);
      return;
      i = paramAppBrandStatObject.caB;
      break;
    }
    label99:
    Intent localIntent = paramActivity.getIntent();
    if ((localIntent != null) && (localIntent.getBooleanExtra("key_appbrand_bring_ui_to_front_from_task_Base_by_task_top_ui", false))) {}
    for (i = j; i != 0; i = 0)
    {
      paramActivity.overridePendingTransition(y.a.appbrand_ui_push_open_enter, y.a.anim_not_change);
      return;
    }
    if (1090 == a(paramAppBrandStatObject))
    {
      paramActivity.overridePendingTransition(y.a.appbrand_ui_switch_enter, y.a.appbrand_ui_push_enter_exit);
      return;
    }
    paramActivity.overridePendingTransition(y.a.appbrand_ui_push_open_enter, y.a.appbrand_ui_push_enter_exit);
  }
  
  public final void a(i parami1, i parami2, Runnable paramRunnable)
  {
    if (parami1 == null) {}
    do
    {
      return;
      if (!parami1.ZG()) {
        break;
      }
      i = MMFragmentActivity.a.uOe;
      a(parami1, i, null);
    } while (parami2 == null);
    if (parami1.ZG()) {}
    for (int i = MMFragmentActivity.a.uOf;; i = y.a.anim_not_change)
    {
      a(parami2, i, paramRunnable);
      return;
      i = y.a.appbrand_ui_push_open_enter;
      break;
    }
  }
  
  public final void b(i parami1, i parami2, Runnable paramRunnable)
  {
    if (parami2 == null) {}
    do
    {
      return;
      if (!parami2.ZG()) {
        break;
      }
      i = MMFragmentActivity.a.uOh;
      a(parami2, i, paramRunnable);
    } while (parami1 == null);
    if (parami2.ZG()) {}
    for (int i = MMFragmentActivity.a.uOg;; i = y.a.anim_not_change)
    {
      a(parami1, i, null);
      return;
      i = y.a.appbrand_ui_push_close_exit;
      break;
    }
  }
  
  public final void h(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    paramActivity.overridePendingTransition(y.a.appbrand_ui_push_close_enter, y.a.appbrand_ui_push_close_exit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.h
 * JD-Core Version:    0.7.0.1
 */