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
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.widget.c;
import d.g.b.k;
import d.l;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;
import me.imid.swipebacklayout.lib.SwipeBackLayout.b;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView;", "Lme/imid/swipebacklayout/lib/SwipeBackLayout;", "Landroid/content/DialogInterface;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "appearAnimation", "Landroid/view/animation/Animation;", "dismissAnimation", "drawStatusBarLayout", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "iconImageView", "Landroid/widget/ImageView;", "negativeButton", "Landroid/content/DialogInterface$OnClickListener;", "getNegativeButton", "()Landroid/content/DialogInterface$OnClickListener;", "setNegativeButton", "(Landroid/content/DialogInterface$OnClickListener;)V", "pageContainer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainer;", "positiveButton", "getPositiveButton", "setPositiveButton", "cancel", "", "cleanup", "dismiss", "dismissWithoutAnimation", "dispatchKeyEventPreIme", "", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onDetachedFromWindow", "resetStyle", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "show", "endAction", "Ljava/lang/Runnable;", "plugin-appbrand-integration_release"})
public final class j
  extends SwipeBackLayout
  implements DialogInterface
{
  u cdW;
  private com.tencent.mm.ui.statusbar.b lAa;
  com.tencent.mm.plugin.appbrand.widget.actionbar.b lAb;
  ImageView lAc;
  private DialogInterface.OnClickListener lzW;
  private DialogInterface.OnClickListener lzX;
  private Animation lzY;
  Animation lzZ;
  
  public j(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(50928);
    bw.cI((View)this);
    a((SwipeBackLayout.a)new SwipeBackLayout.b()
    {
      public final void AT() {}
      
      public final int bp(boolean paramAnonymousBoolean)
      {
        return 1;
      }
      
      public final void bpU()
      {
        AppMethodBeat.i(50916);
        this.lAd.setVisibility(8);
        this.lAd.post((Runnable)new a(this));
        AppMethodBeat.o(50916);
      }
      
      public final void h(int paramAnonymousInt, float paramAnonymousFloat) {}
      
      public final void k(MotionEvent paramAnonymousMotionEvent) {}
      
      @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
      static final class a
        implements Runnable
      {
        a(j.1 param1) {}
        
        public final void run()
        {
          AppMethodBeat.i(50915);
          ViewParent localViewParent = this.lAe.lAd.getParent();
          Object localObject = localViewParent;
          if (!(localViewParent instanceof ViewGroup)) {
            localObject = null;
          }
          localObject = (ViewGroup)localObject;
          if (localObject != null)
          {
            ((ViewGroup)localObject).removeView((View)this.lAe.lAd);
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
    ((com.tencent.mm.ui.statusbar.b)localObject1).xK(false);
    ((com.tencent.mm.ui.statusbar.b)localObject1).L(0, true);
    this.lAa = ((com.tencent.mm.ui.statusbar.b)localObject1);
    addView((View)this.lAa, new ViewGroup.LayoutParams(-1, -1));
    setContentView((View)this.lAa);
    localObject1 = new com.tencent.mm.plugin.appbrand.widget.actionbar.b(paramContext);
    ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).setFullscreenMode(false);
    ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).setBackButtonClickListener((View.OnClickListener)new a(this, paramContext));
    ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).setCloseButtonClickListener((View.OnClickListener)new b(this, paramContext));
    Object localObject2 = this.lAa;
    if (localObject2 == null) {
      k.fOy();
    }
    ((com.tencent.mm.ui.statusbar.b)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.b.dT(paramContext)));
    this.lAb = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1);
    localObject1 = LayoutInflater.from(paramContext).inflate(2131493013, (ViewGroup)this.lAa, false);
    ((TextView)((View)localObject1).findViewById(2131296715)).setText(2131755520);
    ((TextView)((View)localObject1).findViewById(2131296713)).setText(2131755519);
    localObject2 = this.lAa;
    if (localObject2 == null) {
      k.fOy();
    }
    ((com.tencent.mm.ui.statusbar.b)localObject2).addView((View)localObject1);
    k.g(localObject1, "this");
    localObject2 = ((View)localObject1).getLayoutParams();
    localObject1 = localObject2;
    if (!(localObject2 instanceof ViewGroup.MarginLayoutParams)) {
      localObject1 = null;
    }
    localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
    if (localObject1 != null) {
      ((ViewGroup.MarginLayoutParams)localObject1).topMargin = com.tencent.mm.plugin.appbrand.widget.b.dT(paramContext);
    }
    this.lAc = ((ImageView)findViewById(2131296714));
    findViewById(2131296713).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(50917);
        paramAnonymousView = this.lAd.getPositiveButton();
        if (paramAnonymousView != null)
        {
          paramAnonymousView.onClick((DialogInterface)this.lAd, -1);
          AppMethodBeat.o(50917);
          return;
        }
        AppMethodBeat.o(50917);
      }
    });
    AppMethodBeat.o(50928);
  }
  
  public final void bpT()
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
    DialogInterface.OnClickListener localOnClickListener = this.lzX;
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
    Animation localAnimation = this.lzY;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    this.lzY = AnimationUtils.loadAnimation(getContext(), MMFragmentActivity.a.mnF);
    localAnimation = this.lzY;
    if (localAnimation == null) {
      k.fOy();
    }
    localAnimation.setAnimationListener((Animation.AnimationListener)new c(this));
    localAnimation = this.lzY;
    if (localAnimation == null) {
      k.fOy();
    }
    startAnimation(localAnimation);
    AppMethodBeat.o(50922);
  }
  
  public final boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(50927);
    if ((this.lzY != null) || (this.lzZ != null))
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
    if ((this.lzY != null) || (this.lzZ != null))
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
    return this.lzX;
  }
  
  public final DialogInterface.OnClickListener getPositiveButton()
  {
    return this.lzW;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(50925);
    super.onDetachedFromWindow();
    this.lzW = null;
    this.lzX = null;
    this.lzY = null;
    this.lzZ = null;
    this.cdW = null;
    AppMethodBeat.o(50925);
  }
  
  public final void setNegativeButton(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.lzX = paramOnClickListener;
  }
  
  public final void setPositiveButton(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.lzW = paramOnClickListener;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$3$1"})
  static final class a
    implements View.OnClickListener
  {
    a(j paramj, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(50913);
      this.lAd.dismiss();
      AppMethodBeat.o(50913);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$3$2"})
  static final class b
    implements View.OnClickListener
  {
    b(j paramj, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(50914);
      paramView = j.b(this.lAd);
      if (paramView != null)
      {
        paramView = paramView.getRuntime();
        if (paramView != null)
        {
          g.a(paramView.getAppId(), g.d.jdc);
          paramView.close();
          AppMethodBeat.o(50914);
          return;
        }
      }
      AppMethodBeat.o(50914);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$dismiss$1", "Lcom/tencent/mm/ui/widget/MMAnimationListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "plugin-appbrand-integration_release"})
  public static final class c
    extends c
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(50919);
      this.lAd.setVisibility(8);
      ap.f((Runnable)new a(this));
      AppMethodBeat.o(50919);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(j.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(50918);
        this.lAf.lAd.cleanup();
        AppMethodBeat.o(50918);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$show$1", "Lcom/tencent/mm/ui/widget/MMAnimationListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "plugin-appbrand-integration_release"})
  public static final class d
    extends c
  {
    d(Runnable paramRunnable) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(50920);
      j.a(this.lAd);
      paramAnimation = this.lAg;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.j
 * JD-Core Version:    0.7.0.1
 */