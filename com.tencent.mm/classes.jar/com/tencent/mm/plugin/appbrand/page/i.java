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
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.widget.c;
import d.g.b.k;
import d.l;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.SwipeBackLayout.a;
import me.imid.swipebacklayout.lib.SwipeBackLayout.b;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView;", "Lme/imid/swipebacklayout/lib/SwipeBackLayout;", "Landroid/content/DialogInterface;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "appearAnimation", "Landroid/view/animation/Animation;", "dismissAnimation", "drawStatusBarLayout", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "iconImageView", "Landroid/widget/ImageView;", "negativeButton", "Landroid/content/DialogInterface$OnClickListener;", "getNegativeButton", "()Landroid/content/DialogInterface$OnClickListener;", "setNegativeButton", "(Landroid/content/DialogInterface$OnClickListener;)V", "pageContainer", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainer;", "positiveButton", "getPositiveButton", "setPositiveButton", "cancel", "", "cleanup", "dismiss", "dismissWithoutAnimation", "dispatchKeyEventPreIme", "", "event", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onDetachedFromWindow", "resetStyle", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "show", "endAction", "Ljava/lang/Runnable;", "plugin-appbrand-integration_release"})
public final class i
  extends SwipeBackLayout
  implements DialogInterface
{
  t chb;
  private DialogInterface.OnClickListener kYm;
  private DialogInterface.OnClickListener kYn;
  private Animation kYo;
  Animation kYp;
  private com.tencent.mm.ui.statusbar.b kYq;
  com.tencent.mm.plugin.appbrand.widget.actionbar.b kYr;
  ImageView kYs;
  
  public i(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(50928);
    cb.cG((View)this);
    a((SwipeBackLayout.a)new SwipeBackLayout.b()
    {
      public final void Bp() {}
      
      public final void bjc()
      {
        AppMethodBeat.i(50916);
        this.kYt.setVisibility(8);
        this.kYt.post((Runnable)new a(this));
        AppMethodBeat.o(50916);
      }
      
      public final int bq(boolean paramAnonymousBoolean)
      {
        return 1;
      }
      
      public final void h(int paramAnonymousInt, float paramAnonymousFloat) {}
      
      public final void m(MotionEvent paramAnonymousMotionEvent) {}
      
      @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
      static final class a
        implements Runnable
      {
        a(i.1 param1) {}
        
        public final void run()
        {
          AppMethodBeat.i(50915);
          ViewParent localViewParent = this.kYu.kYt.getParent();
          Object localObject = localViewParent;
          if (!(localViewParent instanceof ViewGroup)) {
            localObject = null;
          }
          localObject = (ViewGroup)localObject;
          if (localObject != null)
          {
            ((ViewGroup)localObject).removeView((View)this.kYu.kYt);
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
    ((com.tencent.mm.ui.statusbar.b)localObject1).wD(false);
    ((com.tencent.mm.ui.statusbar.b)localObject1).L(0, true);
    this.kYq = ((com.tencent.mm.ui.statusbar.b)localObject1);
    addView((View)this.kYq, new ViewGroup.LayoutParams(-1, -1));
    setContentView((View)this.kYq);
    localObject1 = new com.tencent.mm.plugin.appbrand.widget.actionbar.b(paramContext);
    ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).setFullscreenMode(false);
    ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).setBackButtonClickListener((View.OnClickListener)new a(this, paramContext));
    ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1).setCloseButtonClickListener((View.OnClickListener)new b(this, paramContext));
    Object localObject2 = this.kYq;
    if (localObject2 == null) {
      k.fvU();
    }
    ((com.tencent.mm.ui.statusbar.b)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.b.dL(paramContext)));
    this.kYr = ((com.tencent.mm.plugin.appbrand.widget.actionbar.b)localObject1);
    localObject1 = LayoutInflater.from(paramContext).inflate(2131493013, (ViewGroup)this.kYq, false);
    ((TextView)((View)localObject1).findViewById(2131296715)).setText(2131755520);
    ((TextView)((View)localObject1).findViewById(2131296713)).setText(2131755519);
    localObject2 = this.kYq;
    if (localObject2 == null) {
      k.fvU();
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
      ((ViewGroup.MarginLayoutParams)localObject1).topMargin = com.tencent.mm.plugin.appbrand.widget.b.dL(paramContext);
    }
    this.kYs = ((ImageView)findViewById(2131296714));
    findViewById(2131296713).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(50917);
        paramAnonymousView = this.kYt.getPositiveButton();
        if (paramAnonymousView != null)
        {
          paramAnonymousView.onClick((DialogInterface)this.kYt, -1);
          AppMethodBeat.o(50917);
          return;
        }
        AppMethodBeat.o(50917);
      }
    });
    AppMethodBeat.o(50928);
  }
  
  public final void bjb()
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
    DialogInterface.OnClickListener localOnClickListener = this.kYn;
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
    Animation localAnimation = this.kYo;
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    this.kYo = AnimationUtils.loadAnimation(getContext(), MMFragmentActivity.a.lLI);
    localAnimation = this.kYo;
    if (localAnimation == null) {
      k.fvU();
    }
    localAnimation.setAnimationListener((Animation.AnimationListener)new c(this));
    localAnimation = this.kYo;
    if (localAnimation == null) {
      k.fvU();
    }
    startAnimation(localAnimation);
    AppMethodBeat.o(50922);
  }
  
  public final boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(50927);
    if ((this.kYo != null) || (this.kYp != null))
    {
      AppMethodBeat.o(50927);
      return true;
    }
    if ((paramKeyEvent != null) && (paramKeyEvent.getAction() == 0) && (paramKeyEvent.getKeyCode() == 4))
    {
      f.aB(getContext());
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
    if ((this.kYo != null) || (this.kYp != null))
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
    return this.kYn;
  }
  
  public final DialogInterface.OnClickListener getPositiveButton()
  {
    return this.kYm;
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(50925);
    super.onDetachedFromWindow();
    this.kYm = null;
    this.kYn = null;
    this.kYo = null;
    this.kYp = null;
    this.chb = null;
    AppMethodBeat.o(50925);
  }
  
  public final void setNegativeButton(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.kYn = paramOnClickListener;
  }
  
  public final void setPositiveButton(DialogInterface.OnClickListener paramOnClickListener)
  {
    this.kYm = paramOnClickListener;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$3$1"})
  static final class a
    implements View.OnClickListener
  {
    a(i parami, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(50913);
      this.kYt.dismiss();
      AppMethodBeat.o(50913);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$3$2"})
  static final class b
    implements View.OnClickListener
  {
    b(i parami, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(50914);
      paramView = i.b(this.kYt);
      if (paramView != null)
      {
        paramView = paramView.getRuntime();
        if (paramView != null)
        {
          g.a(paramView.getAppId(), g.d.iDc);
          paramView.close();
          AppMethodBeat.o(50914);
          return;
        }
      }
      AppMethodBeat.o(50914);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$dismiss$1", "Lcom/tencent/mm/ui/widget/MMAnimationListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "plugin-appbrand-integration_release"})
  public static final class c
    extends c
  {
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(50919);
      this.kYt.setVisibility(8);
      aq.f((Runnable)new a(this));
      AppMethodBeat.o(50919);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(i.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(50918);
        this.kYv.kYt.cleanup();
        AppMethodBeat.o(50918);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/page/AppBrandModularizingErrorReplayView$show$1", "Lcom/tencent/mm/ui/widget/MMAnimationListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "plugin-appbrand-integration_release"})
  public static final class d
    extends c
  {
    d(Runnable paramRunnable) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(50920);
      i.a(this.kYt);
      paramAnimation = this.kYw;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.i
 * JD-Core Version:    0.7.0.1
 */