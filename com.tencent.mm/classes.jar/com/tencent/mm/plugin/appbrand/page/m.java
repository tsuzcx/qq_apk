package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.luggage.l.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.widget.e;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;
import me.imid.swipebacklayout.lib.SwipeBackLayout.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView;", "Lme/imid/swipebacklayout/lib/SwipeBackLayout;", "Landroid/content/DialogInterface;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "appearAnimation", "Landroid/view/animation/Animation;", "dismissAnimation", "drawStatusBarLayout", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "iconImageView", "Landroid/widget/ImageView;", "negativeButton", "Landroid/content/DialogInterface$OnClickListener;", "getNegativeButton", "()Landroid/content/DialogInterface$OnClickListener;", "setNegativeButton", "(Landroid/content/DialogInterface$OnClickListener;)V", "pageContainer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainer;", "positiveButton", "getPositiveButton", "setPositiveButton", "cancel", "", "cleanup", "dismiss", "dismissWithoutAnimation", "dispatchKeyEventPreIme", "", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onDetachedFromWindow", "resetStyle", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "show", "endAction", "Ljava/lang/Runnable;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends SwipeBackLayout
  implements DialogInterface
{
  x erR;
  com.tencent.mm.plugin.appbrand.widget.actionbar.b qyW;
  private DialogInterface.OnClickListener tut;
  private DialogInterface.OnClickListener tuu;
  private Animation tuv;
  Animation tuw;
  private com.tencent.mm.ui.statusbar.b tux;
  ImageView tuy;
  
  public m(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(50928);
    ck.dE((View)this);
    a((SwipeBackLayout.a)new SwipeBackLayout.b()
    {
      private static final void b(m paramAnonymousm)
      {
        AppMethodBeat.i(324884);
        s.u(paramAnonymousm, "this$0");
        Object localObject = paramAnonymousm.getParent();
        if ((localObject instanceof ViewGroup)) {}
        for (localObject = (ViewGroup)localObject;; localObject = null)
        {
          if (localObject != null) {
            ((ViewGroup)localObject).removeView((View)paramAnonymousm);
          }
          AppMethodBeat.o(324884);
          return;
        }
      }
      
      public final void aoM() {}
      
      public final void cDW()
      {
        AppMethodBeat.i(50916);
        this.tuz.setVisibility(8);
        this.tuz.post(new m.1..ExternalSyntheticLambda0(this.tuz));
        AppMethodBeat.o(50916);
      }
      
      public final int cI(boolean paramAnonymousBoolean)
      {
        return 1;
      }
      
      public final void n(int paramAnonymousInt, float paramAnonymousFloat) {}
      
      public final void n(MotionEvent paramAnonymousMotionEvent) {}
    });
    Object localObject1 = new com.tencent.mm.ui.statusbar.b(paramContext);
    ((com.tencent.mm.ui.statusbar.b)localObject1).setClickable(true);
    ((com.tencent.mm.ui.statusbar.b)localObject1).setBackgroundColor(-1);
    ((com.tencent.mm.ui.statusbar.b)localObject1).setWillNotDraw(false);
    ((com.tencent.mm.ui.statusbar.b)localObject1).MU(false);
    ((com.tencent.mm.ui.statusbar.b)localObject1).aj(0, true);
    Object localObject2 = ah.aiuX;
    this.tux = ((com.tencent.mm.ui.statusbar.b)localObject1);
    addView((View)this.tux, new ViewGroup.LayoutParams(-1, -1));
    setContentView((View)this.tux);
    localObject1 = new com.tencent.mm.plugin.appbrand.widget.actionbar.b(paramContext);
    ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).setFullscreenMode(false);
    ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).setBackButtonClickListener(new m..ExternalSyntheticLambda0(this));
    ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).setCloseButtonClickListener(new m..ExternalSyntheticLambda2(this));
    localObject2 = this.tux;
    s.checkNotNull(localObject2);
    ((com.tencent.mm.ui.statusbar.b)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.b.fs(paramContext)));
    localObject2 = ah.aiuX;
    this.qyW = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1);
    localObject1 = LayoutInflater.from(paramContext).inflate(ba.g.app_brand_modularizing_error_view, (ViewGroup)this.tux, false);
    ((TextView)((View)localObject1).findViewById(ba.f.app_brand_error_page_reason)).setText(ba.i.app_brand_modularizing_error_replay_tips);
    ((TextView)((View)localObject1).findViewById(ba.f.app_brand_error_page_index)).setText(ba.i.app_brand_modularizing_error_replay_confirm_tips);
    localObject2 = this.tux;
    s.checkNotNull(localObject2);
    ((com.tencent.mm.ui.statusbar.b)localObject2).addView((View)localObject1);
    localObject1 = ((View)localObject1).getLayoutParams();
    if ((localObject1 instanceof ViewGroup.MarginLayoutParams)) {}
    for (localObject1 = (ViewGroup.MarginLayoutParams)localObject1;; localObject1 = null)
    {
      if (localObject1 != null) {
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = com.tencent.mm.plugin.appbrand.widget.b.fs(paramContext);
      }
      this.tuy = ((ImageView)findViewById(ba.f.app_brand_error_page_iv));
      findViewById(ba.f.app_brand_error_page_index).setOnClickListener(new m..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(50928);
      return;
    }
  }
  
  private static final void a(m paramm, View paramView)
  {
    AppMethodBeat.i(324905);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramm);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramm, "this$0");
    paramm.dismiss();
    a.a(new Object(), "com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(324905);
  }
  
  private static final void b(m paramm, View paramView)
  {
    AppMethodBeat.i(324906);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramm);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramm, "this$0");
    paramm = paramm.erR;
    if (paramm != null)
    {
      paramm = paramm.getRuntime();
      if (paramm != null)
      {
        k.a(paramm.mAppId, k.d.qrG);
        paramm.close();
      }
    }
    a.a(new Object(), "com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(324906);
  }
  
  private static final void c(m paramm, View paramView)
  {
    AppMethodBeat.i(324909);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramm);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramm, "this$0");
    paramView = paramm.getPositiveButton();
    if (paramView != null) {
      paramView.onClick((DialogInterface)paramm, -1);
    }
    a.a(new Object(), "com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(324909);
  }
  
  public final void cDV()
  {
    AppMethodBeat.i(50923);
    setVisibility(8);
    cleanup();
    AppMethodBeat.o(50923);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(50924);
    dismiss();
    DialogInterface.OnClickListener localOnClickListener = this.tuu;
    if (localOnClickListener != null) {
      localOnClickListener.onClick((DialogInterface)this, -2);
    }
    AppMethodBeat.o(50924);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(50921);
    Object localObject = getAnimation();
    if (localObject != null) {
      ((Animation)localObject).cancel();
    }
    localObject = getAnimation();
    if (localObject != null) {
      ((Animation)localObject).setAnimationListener(null);
    }
    localObject = getParent();
    if ((localObject instanceof ViewGroup)) {}
    for (localObject = (ViewGroup)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((ViewGroup)localObject).removeView((View)this);
      }
      AppMethodBeat.o(50921);
      return;
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(50922);
    Animation localAnimation = this.tuv;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    this.tuv = AnimationUtils.loadAnimation(getContext(), MMFragmentActivity.a.upX);
    localAnimation = this.tuv;
    s.checkNotNull(localAnimation);
    localAnimation.setAnimationListener((Animation.AnimationListener)new a(this));
    localAnimation = this.tuv;
    s.checkNotNull(localAnimation);
    startAnimation(localAnimation);
    AppMethodBeat.o(50922);
  }
  
  public final boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    int j = 0;
    AppMethodBeat.i(50927);
    if ((this.tuv != null) || (this.tuw != null))
    {
      AppMethodBeat.o(50927);
      return true;
    }
    if ((paramKeyEvent != null) && (paramKeyEvent.getAction() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      i = j;
      if (paramKeyEvent != null)
      {
        i = j;
        if (paramKeyEvent.getKeyCode() == 4) {
          i = 1;
        }
      }
      if (i == 0) {
        break;
      }
      f.bv(getContext());
      dismiss();
      AppMethodBeat.o(50927);
      return true;
    }
    boolean bool = super.dispatchKeyEventPreIme(paramKeyEvent);
    AppMethodBeat.o(50927);
    return bool;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(50926);
    if ((this.tuv != null) || (this.tuw != null))
    {
      AppMethodBeat.o(50926);
      return true;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(50926);
    return bool;
  }
  
  public final DialogInterface.OnClickListener getNegativeButton()
  {
    return this.tuu;
  }
  
  public final DialogInterface.OnClickListener getPositiveButton()
  {
    return this.tut;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(50925);
    super.onDetachedFromWindow();
    this.tut = null;
    this.tuu = null;
    this.tuv = null;
    this.tuw = null;
    this.erR = null;
    AppMethodBeat.o(50925);
  }
  
  public final void setNegativeButton(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.tuu = paramOnClickListener;
  }
  
  public final void setPositiveButton(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.tut = paramOnClickListener;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$dismiss$1", "Lcom/tencent/mm/ui/widget/MMAnimationListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends e
  {
    a(m paramm) {}
    
    private static final void c(m paramm)
    {
      AppMethodBeat.i(324862);
      s.u(paramm, "this$0");
      paramm.cleanup();
      AppMethodBeat.o(324862);
    }
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(50919);
      this.tuz.setVisibility(8);
      MMHandlerThread.postToMainThread(new m.a..ExternalSyntheticLambda0(this.tuz));
      AppMethodBeat.o(50919);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$show$1", "Lcom/tencent/mm/ui/widget/MMAnimationListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends e
  {
    b(m paramm, Runnable paramRunnable) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(50920);
      m.a(this.tuz);
      paramAnimation = this.tuA;
      if (paramAnimation != null) {
        paramAnimation.run();
      }
      AppMethodBeat.o(50920);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.m
 * JD-Core Version:    0.7.0.1
 */