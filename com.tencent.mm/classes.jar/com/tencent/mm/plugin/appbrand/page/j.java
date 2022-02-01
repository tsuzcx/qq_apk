package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.widget.c;
import d.g.b.p;
import d.l;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;
import me.imid.swipebacklayout.lib.SwipeBackLayout.b;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView;", "Lme/imid/swipebacklayout/lib/SwipeBackLayout;", "Landroid/content/DialogInterface;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "appearAnimation", "Landroid/view/animation/Animation;", "dismissAnimation", "drawStatusBarLayout", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "iconImageView", "Landroid/widget/ImageView;", "negativeButton", "Landroid/content/DialogInterface$OnClickListener;", "getNegativeButton", "()Landroid/content/DialogInterface$OnClickListener;", "setNegativeButton", "(Landroid/content/DialogInterface$OnClickListener;)V", "pageContainer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainer;", "positiveButton", "getPositiveButton", "setPositiveButton", "cancel", "", "cleanup", "dismiss", "dismissWithoutAnimation", "dispatchKeyEventPreIme", "", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onDetachedFromWindow", "resetStyle", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "show", "endAction", "Ljava/lang/Runnable;", "plugin-appbrand-integration_release"})
public final class j
  extends SwipeBackLayout
  implements DialogInterface
{
  u com;
  ImageView lZA;
  private DialogInterface.OnClickListener lZu;
  private DialogInterface.OnClickListener lZv;
  private Animation lZw;
  Animation lZx;
  private com.tencent.mm.ui.statusbar.b lZy;
  com.tencent.mm.plugin.appbrand.widget.actionbar.b lZz;
  
  public j(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(50928);
    bv.cK((View)this);
    a((SwipeBackLayout.a)new SwipeBackLayout.b()
    {
      public final void Cs() {}
      
      public final int bq(boolean paramAnonymousBoolean)
      {
        return 1;
      }
      
      public final void btU()
      {
        AppMethodBeat.i(50916);
        this.lZB.setVisibility(8);
        this.lZB.post((Runnable)new a(this));
        AppMethodBeat.o(50916);
      }
      
      public final void i(int paramAnonymousInt, float paramAnonymousFloat) {}
      
      public final void k(MotionEvent paramAnonymousMotionEvent) {}
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
      static final class a
        implements Runnable
      {
        a(j.1 param1) {}
        
        public final void run()
        {
          AppMethodBeat.i(50915);
          ViewParent localViewParent = this.lZC.lZB.getParent();
          Object localObject = localViewParent;
          if (!(localViewParent instanceof ViewGroup)) {
            localObject = null;
          }
          localObject = (ViewGroup)localObject;
          if (localObject != null)
          {
            ((ViewGroup)localObject).removeView((View)this.lZC.lZB);
            AppMethodBeat.o(50915);
            return;
          }
          AppMethodBeat.o(50915);
        }
      }
    });
    Object localObject1 = new com.tencent.mm.ui.statusbar.b(paramContext);
    ((com.tencent.mm.ui.statusbar.b)localObject1).setClickable(true);
    ((com.tencent.mm.ui.statusbar.b)localObject1).setBackgroundColor(-1);
    ((com.tencent.mm.ui.statusbar.b)localObject1).setWillNotDraw(false);
    ((com.tencent.mm.ui.statusbar.b)localObject1).yy(false);
    ((com.tencent.mm.ui.statusbar.b)localObject1).L(0, true);
    this.lZy = ((com.tencent.mm.ui.statusbar.b)localObject1);
    addView((View)this.lZy, new ViewGroup.LayoutParams(-1, -1));
    setContentView((View)this.lZy);
    localObject1 = new com.tencent.mm.plugin.appbrand.widget.actionbar.b(paramContext);
    ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).setFullscreenMode(false);
    ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).setBackButtonClickListener((View.OnClickListener)new a(this, paramContext));
    ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).setCloseButtonClickListener((View.OnClickListener)new b(this, paramContext));
    Object localObject2 = this.lZy;
    if (localObject2 == null) {
      p.gfZ();
    }
    ((com.tencent.mm.ui.statusbar.b)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.b.dT(paramContext)));
    this.lZz = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1);
    localObject1 = LayoutInflater.from(paramContext).inflate(2131493013, (ViewGroup)this.lZy, false);
    ((TextView)((View)localObject1).findViewById(2131296715)).setText(2131755520);
    ((TextView)((View)localObject1).findViewById(2131296713)).setText(2131755519);
    localObject2 = this.lZy;
    if (localObject2 == null) {
      p.gfZ();
    }
    ((com.tencent.mm.ui.statusbar.b)localObject2).addView((View)localObject1);
    p.g(localObject1, "this");
    localObject2 = ((View)localObject1).getLayoutParams();
    localObject1 = localObject2;
    if (!(localObject2 instanceof ViewGroup.MarginLayoutParams)) {
      localObject1 = null;
    }
    localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
    if (localObject1 != null) {
      ((ViewGroup.MarginLayoutParams)localObject1).topMargin = com.tencent.mm.plugin.appbrand.widget.b.dT(paramContext);
    }
    this.lZA = ((ImageView)findViewById(2131296714));
    findViewById(2131296713).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(50917);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = this.lZB.getPositiveButton();
        if (paramAnonymousView != null) {
          paramAnonymousView.onClick((DialogInterface)this.lZB, -1);
        }
        a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(50917);
      }
    });
    AppMethodBeat.o(50928);
  }
  
  public final void btT()
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
    DialogInterface.OnClickListener localOnClickListener = this.lZv;
    if (localOnClickListener != null)
    {
      localOnClickListener.onClick((DialogInterface)this, -2);
      AppMethodBeat.o(50924);
      return;
    }
    AppMethodBeat.o(50924);
  }
  
  public final void cleanup()
  {
    Object localObject1 = null;
    AppMethodBeat.i(50921);
    Object localObject2 = getAnimation();
    if (localObject2 != null) {
      ((Animation)localObject2).cancel();
    }
    localObject2 = getAnimation();
    if (localObject2 != null) {
      ((Animation)localObject2).setAnimationListener(null);
    }
    localObject2 = getParent();
    if (!(localObject2 instanceof ViewGroup)) {}
    for (;;)
    {
      localObject1 = (ViewGroup)localObject1;
      if (localObject1 != null)
      {
        ((ViewGroup)localObject1).removeView((View)this);
        AppMethodBeat.o(50921);
        return;
      }
      AppMethodBeat.o(50921);
      return;
      localObject1 = localObject2;
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(50922);
    Animation localAnimation = this.lZw;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    this.lZw = AnimationUtils.loadAnimation(getContext(), MMFragmentActivity.a.mOh);
    localAnimation = this.lZw;
    if (localAnimation == null) {
      p.gfZ();
    }
    localAnimation.setAnimationListener((Animation.AnimationListener)new c(this));
    localAnimation = this.lZw;
    if (localAnimation == null) {
      p.gfZ();
    }
    startAnimation(localAnimation);
    AppMethodBeat.o(50922);
  }
  
  public final boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(50927);
    if ((this.lZw != null) || (this.lZx != null))
    {
      AppMethodBeat.o(50927);
      return true;
    }
    if ((paramKeyEvent != null) && (paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4))
    {
      f.aC(getContext());
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
    if ((this.lZw != null) || (this.lZx != null))
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
    return this.lZv;
  }
  
  public final DialogInterface.OnClickListener getPositiveButton()
  {
    return this.lZu;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(50925);
    super.onDetachedFromWindow();
    this.lZu = null;
    this.lZv = null;
    this.lZw = null;
    this.lZx = null;
    this.com = null;
    AppMethodBeat.o(50925);
  }
  
  public final void setNegativeButton(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.lZv = paramOnClickListener;
  }
  
  public final void setPositiveButton(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.lZu = paramOnClickListener;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$3$1"})
  static final class a
    implements View.OnClickListener
  {
    a(j paramj, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(50913);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      a.b("com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.lZB.dismiss();
      a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(50913);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$3$2"})
  static final class b
    implements View.OnClickListener
  {
    b(j paramj, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(50914);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      a.b("com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$$special$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = j.b(this.lZB);
      if (paramView != null)
      {
        paramView = paramView.getRuntime();
        if (paramView != null)
        {
          g.a(paramView.getAppId(), g.d.jwl);
          paramView.close();
        }
      }
      a.a(this, "com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$$special$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(50914);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$dismiss$1", "Lcom/tencent/mm/ui/widget/MMAnimationListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "plugin-appbrand-integration_release"})
  public static final class c
    extends c
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(50919);
      this.lZB.setVisibility(8);
      aq.f((Runnable)new a(this));
      AppMethodBeat.o(50919);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(j.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(50918);
        this.lZD.lZB.cleanup();
        AppMethodBeat.o(50918);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$show$1", "Lcom/tencent/mm/ui/widget/MMAnimationListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "plugin-appbrand-integration_release"})
  public static final class d
    extends c
  {
    d(Runnable paramRunnable) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(50920);
      j.a(this.lZB);
      paramAnimation = this.lZE;
      if (paramAnimation != null)
      {
        paramAnimation.run();
        AppMethodBeat.o(50920);
        return;
      }
      AppMethodBeat.o(50920);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.j
 * JD-Core Version:    0.7.0.1
 */