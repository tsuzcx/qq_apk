package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import androidx.core.g.z;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ba.a;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.m;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.wxa_container.a;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.weishi.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.aw;

public enum t
  implements ap
{
  static
  {
    AppMethodBeat.i(322227);
    ueR = new t("INSTANCE");
    ueS = new t[] { ueR };
    AppMethodBeat.o(322227);
  }
  
  private t() {}
  
  private static boolean Q(Intent paramIntent)
  {
    AppMethodBeat.i(322200);
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("key_appbrand_bring_ui_to_front_from_task_Base_by_task_top_ui", false)))
    {
      AppMethodBeat.o(322200);
      return true;
    }
    AppMethodBeat.o(322200);
    return false;
  }
  
  private static int a(AppBrandStatObject paramAppBrandStatObject)
  {
    if (paramAppBrandStatObject == null) {
      return 0;
    }
    return paramAppBrandStatObject.scene;
  }
  
  private static void a(final AppBrandRuntime paramAppBrandRuntime, final int paramInt, final Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(322212);
    if (!z.au(paramAppBrandRuntime.qsk))
    {
      paramAppBrandRuntime.qsk.setWillNotDraw(true);
      paramAppBrandRuntime.qsk.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(322477);
          t.b(t.this, paramInt, paramAnimationListener);
          AppMethodBeat.o(322477);
        }
      });
      AppMethodBeat.o(322212);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), paramInt);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(322469);
        if (t.this != null) {
          t.this.onAnimationEnd(paramAnonymousAnimation);
        }
        AppMethodBeat.o(322469);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(322473);
        if (t.this != null) {
          t.this.onAnimationRepeat(paramAnonymousAnimation);
        }
        AppMethodBeat.o(322473);
      }
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(322479);
        if (t.this != null) {
          t.this.onAnimationStart(paramAnonymousAnimation);
        }
        paramAppBrandRuntime.qsk.setWillNotDraw(false);
        AppMethodBeat.o(322479);
      }
    });
    paramAppBrandRuntime.qsk.startAnimation(localAnimation);
    paramAppBrandRuntime = paramAppBrandRuntime.qsk.getRootView().findViewById(ba.f.app_brand_activity_container_view);
    if ((paramAppBrandRuntime instanceof a)) {
      ((a)paramAppBrandRuntime).c(localAnimation);
    }
    AppMethodBeat.o(322212);
  }
  
  public static boolean aB(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(48869);
    if ((paramAppBrandRuntime instanceof w))
    {
      paramAppBrandRuntime = (w)paramAppBrandRuntime;
      if ((paramAppBrandRuntime.ccB()) || (paramAppBrandRuntime.asA().epn.scene == 1099))
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
  
  private static boolean b(AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(322186);
    if (a(paramAppBrandStatObject) == 1023)
    {
      AppMethodBeat.o(322186);
      return true;
    }
    AppMethodBeat.o(322186);
    return false;
  }
  
  private static boolean c(AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(322190);
    if ((a(paramAppBrandStatObject) == 1113) || (a(paramAppBrandStatObject) == 1114))
    {
      AppMethodBeat.o(322190);
      return true;
    }
    AppMethodBeat.o(322190);
    return false;
  }
  
  private static boolean cLx()
  {
    AppMethodBeat.i(322205);
    if ((aw.jlc()) && (!b.tYN.cKG()))
    {
      AppMethodBeat.o(322205);
      return true;
    }
    AppMethodBeat.o(322205);
    return false;
  }
  
  private static boolean d(AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(322195);
    if (1024 == a(paramAppBrandStatObject))
    {
      if (paramAppBrandStatObject == null) {}
      for (int i = 0; 6 == i; i = paramAppBrandStatObject.icZ)
      {
        AppMethodBeat.o(322195);
        return true;
      }
    }
    AppMethodBeat.o(322195);
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
    if (((AppBrandInitConfigWC)paramAppBrandInitConfig).qAW != null)
    {
      AppMethodBeat.o(48864);
      return;
    }
    y localy = ((AppBrandInitConfigWC)paramAppBrandInitConfig).aqG();
    if (y.raT == localy)
    {
      paramActivity.overridePendingTransition(0, 0);
      AppMethodBeat.o(48864);
      return;
    }
    AppBrandStatObject localAppBrandStatObject = ((AppBrandInitConfigWC)paramAppBrandInitConfig).epn;
    try
    {
      boolean bool = m.a(paramActivity, paramAppBrandInitConfig, localAppBrandStatObject);
      if (bool)
      {
        AppMethodBeat.o(48864);
        return;
      }
    }
    finally
    {
      if (f.c(paramActivity, paramAppBrandInitConfig))
      {
        AppMethodBeat.o(48864);
        return;
      }
      if (y.raR == localy)
      {
        paramActivity.overridePendingTransition(ba.a.appbrand_ui_push_open_enter_no_delay, ba.a.anim_not_change);
        AppMethodBeat.o(48864);
        return;
      }
      if (cLx())
      {
        paramActivity.overridePendingTransition(ba.a.appbrand_ui_push_open_enter_no_delay, 0);
        AppMethodBeat.o(48864);
        return;
      }
      if ((((AppBrandInitConfigWC)paramAppBrandInitConfig).qYd) || (((AppBrandInitConfigWC)paramAppBrandInitConfig).launchMode == 1))
      {
        paramActivity.overridePendingTransition(MMFragmentActivity.a.upU, MMFragmentActivity.a.upV);
        AppMethodBeat.o(48864);
        return;
      }
      if ((b(localAppBrandStatObject)) || (c(localAppBrandStatObject)))
      {
        paramActivity.overridePendingTransition(ba.a.appbrand_ui_push_open_enter_no_delay, ba.a.anim_not_change);
        AppMethodBeat.o(48864);
        return;
      }
      if (d(localAppBrandStatObject))
      {
        paramActivity.overridePendingTransition(MMFragmentActivity.a.upW, MMFragmentActivity.a.upX);
        AppMethodBeat.o(48864);
        return;
      }
      if (Q(paramActivity.getIntent()))
      {
        paramActivity.overridePendingTransition(ba.a.appbrand_ui_push_open_enter_no_delay, ba.a.anim_not_change);
        AppMethodBeat.o(48864);
        return;
      }
      if (1090 == a(localAppBrandStatObject))
      {
        paramActivity.overridePendingTransition(ba.a.appbrand_ui_switch_enter, ba.a.appbrand_ui_push_open_exit);
        AppMethodBeat.o(48864);
        return;
      }
      paramActivity.overridePendingTransition(ba.a.appbrand_ui_push_open_enter, ba.a.appbrand_ui_push_open_exit);
      AppMethodBeat.o(48864);
    }
  }
  
  public final void a(AppBrandRuntime paramAppBrandRuntime1, final AppBrandRuntime paramAppBrandRuntime2, final Runnable paramRunnable)
  {
    AppMethodBeat.i(48867);
    if (paramAppBrandRuntime2 == null)
    {
      AppMethodBeat.o(48867);
      return;
    }
    HalfScreenConfig localHalfScreenConfig;
    int i;
    label97:
    int j;
    if ((paramAppBrandRuntime2 instanceof w))
    {
      localHalfScreenConfig = ((w)paramAppBrandRuntime2).getInitConfig().qAT;
      if ((localHalfScreenConfig == null) || (!localHalfScreenConfig.isEnable())) {
        break label165;
      }
      switch (7.ufb[localHalfScreenConfig.ez(com.tencent.mm.sdk.system.AndroidContextUtil.castActivityOrNull(paramAppBrandRuntime2.mContext)).ordinal()])
      {
      default: 
        i = ba.a.anim_not_change;
        j = ba.a.anim_not_change;
      }
    }
    for (;;)
    {
      a(paramAppBrandRuntime2, i, new com.tencent.mm.ui.widget.e()
      {
        boolean ueT = false;
        
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(175085);
          if (paramRunnable != null) {
            MMHandlerThread.postToMainThread(paramRunnable);
          }
          AppMethodBeat.o(175085);
        }
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(175086);
          if (((paramAppBrandRuntime2 instanceof w)) && (!this.ueT))
          {
            ((w)paramAppBrandRuntime2).qvN.M(0, paramAnonymousAnimation.getDuration());
            this.ueT = true;
          }
          AppMethodBeat.o(175086);
        }
      });
      if (paramAppBrandRuntime1 != null) {
        a(paramAppBrandRuntime1, j, new com.tencent.mm.ui.widget.e()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(322462);
            if (this.ueV != null) {
              MMHandlerThread.postToMainThread(this.ueV);
            }
            AppMethodBeat.o(322462);
          }
        });
      }
      AppMethodBeat.o(48867);
      return;
      localHalfScreenConfig = null;
      break;
      i = ba.a.appbrand_ui_push_close_exit;
      break label97;
      i = MMFragmentActivity.a.upX;
      break label97;
      label165:
      if (aB(paramAppBrandRuntime2)) {}
      for (i = MMFragmentActivity.a.upX;; i = ba.a.appbrand_ui_push_close_exit)
      {
        if (!aB(paramAppBrandRuntime2)) {
          break label200;
        }
        j = MMFragmentActivity.a.upW;
        break;
      }
      label200:
      j = ba.a.anim_not_change;
    }
  }
  
  public final void a(final AppBrandRuntime paramAppBrandRuntime1, final Runnable paramRunnable, AppBrandRuntime paramAppBrandRuntime2)
  {
    AppMethodBeat.i(322247);
    if (paramAppBrandRuntime1 == null)
    {
      AppMethodBeat.o(322247);
      return;
    }
    Object localObject;
    int i;
    label97:
    int j;
    if ((paramAppBrandRuntime1 instanceof w))
    {
      localObject = ((w)paramAppBrandRuntime1).getInitConfig().qAT;
      if ((localObject == null) || (!((HalfScreenConfig)localObject).isEnable())) {
        break label165;
      }
      switch (7.ufb[localObject.ez(com.tencent.mm.sdk.system.AndroidContextUtil.castActivityOrNull(paramAppBrandRuntime1.mContext)).ordinal()])
      {
      default: 
        i = ba.a.anim_not_change;
        j = ba.a.anim_not_change;
      }
    }
    for (;;)
    {
      a(paramAppBrandRuntime1, i, new com.tencent.mm.ui.widget.e()
      {
        boolean ueT = false;
        
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(322682);
          if (paramRunnable != null) {
            MMHandlerThread.postToMainThread(paramRunnable);
          }
          AppMethodBeat.o(322682);
        }
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(322680);
          if ((paramAppBrandRuntime1 instanceof w))
          {
            if (!this.ueT) {
              ((w)paramAppBrandRuntime1).qvN.jW(paramAnonymousAnimation.getDuration());
            }
            this.ueT = true;
          }
          AppMethodBeat.o(322680);
        }
      });
      if (paramAppBrandRuntime2 != null) {
        a(paramAppBrandRuntime2, j, new com.tencent.mm.ui.widget.e()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(48862);
            if (this.ueX != null) {
              MMHandlerThread.postToMainThread(this.ueX);
            }
            AppMethodBeat.o(48862);
          }
        });
      }
      AppMethodBeat.o(322247);
      return;
      localObject = null;
      break;
      i = ba.a.appbrand_ui_push_open_enter_no_delay;
      break label97;
      i = MMFragmentActivity.a.upU;
      break label97;
      label165:
      if ((paramAppBrandRuntime1 instanceof w)) {}
      for (localObject = ((w)paramAppBrandRuntime1).getInitConfig(); (localObject != null) && (y.raT == ((AppBrandInitConfigWC)localObject).aqG()); localObject = null)
      {
        paramRunnable.run();
        AppMethodBeat.o(322247);
        return;
      }
      if (aB(paramAppBrandRuntime1)) {}
      for (i = MMFragmentActivity.a.upU;; i = ba.a.appbrand_ui_push_open_enter_no_delay)
      {
        if (!aB(paramAppBrandRuntime1)) {
          break label251;
        }
        j = MMFragmentActivity.a.upV;
        break;
      }
      label251:
      j = ba.a.anim_not_change;
    }
  }
  
  public final void b(Activity paramActivity, AppBrandInitConfig paramAppBrandInitConfig)
  {
    AppMethodBeat.i(322240);
    if (paramActivity == null)
    {
      AppMethodBeat.o(322240);
      return;
    }
    Object localObject;
    if ((paramAppBrandInitConfig == null) && ((paramActivity instanceof AppBrandUI)))
    {
      localObject = ((AppBrandUI)paramActivity).mRuntimeContainer;
      if (localObject == null)
      {
        localObject = null;
        if (localObject == null) {
          break label207;
        }
        paramAppBrandInitConfig = ((AppBrandRuntime)localObject).asH();
      }
    }
    label207:
    for (;;)
    {
      if ((paramAppBrandInitConfig instanceof AppBrandInitConfigWC))
      {
        paramAppBrandInitConfig = (AppBrandInitConfigWC)paramAppBrandInitConfig;
        if (y.raT == paramAppBrandInitConfig.aqH())
        {
          paramActivity.overridePendingTransition(0, 0);
          AppMethodBeat.o(322240);
          return;
          localObject = ((com.tencent.mm.plugin.appbrand.ap)localObject).getActiveRuntime();
          break;
        }
        if (y.raR == paramAppBrandInitConfig.aqH())
        {
          paramActivity.overridePendingTransition(ba.a.anim_not_change, ba.a.appbrand_ui_push_close_exit);
          AppMethodBeat.o(322240);
          return;
        }
      }
      int i = 0;
      while (i <= 0)
      {
        if (new Class[] { AppBrandPluginUI.class }[i].isInstance(paramActivity))
        {
          AppMethodBeat.o(322240);
          return;
        }
        i += 1;
      }
      if (cLx())
      {
        paramActivity.overridePendingTransition(0, ba.a.appbrand_ui_push_close_exit);
        AppMethodBeat.o(322240);
        return;
      }
      paramActivity.overridePendingTransition(ba.a.appbrand_ui_push_close_enter, ba.a.appbrand_ui_push_close_exit);
      AppMethodBeat.o(322240);
      return;
    }
  }
  
  public final void l(Activity paramActivity)
  {
    AppMethodBeat.i(48865);
    b(paramActivity, null);
    AppMethodBeat.o(48865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.t
 * JD-Core Version:    0.7.0.1
 */