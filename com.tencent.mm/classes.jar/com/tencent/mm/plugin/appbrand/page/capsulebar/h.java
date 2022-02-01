package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkWrapper;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/BaseBlinkingCapsuleBarPart;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkingPart$BlinkHandler;", "mButton", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;", "(Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;)V", "mAnimator", "Landroid/animation/Animator;", "applyDescription", "", "description", "", "applyLogo", "logo", "Landroid/graphics/drawable/Drawable;", "applyStatus", "status", "", "blink", "clearAnimation", "destroy", "dismiss", "getContext", "Landroid/content/Context;", "pauseAnimation", "resumeAnimation", "scheduleToUiThread", "runnable", "Ljava/lang/Runnable;", "setDescription", "resId", "setLogo", "drawable", "setStatus", "luggage-wxa-app_release"})
public final class h
  extends f
  implements i.a
{
  private Animator Fj;
  private final AppBrandOptionButton nvw;
  
  public h(AppBrandOptionButton paramAppBrandOptionButton)
  {
    AppMethodBeat.i(219729);
    this.nvw = paramAppBrandOptionButton;
    AppMethodBeat.o(219729);
  }
  
  protected final void E(CharSequence paramCharSequence) {}
  
  protected final void P(Runnable paramRunnable)
  {
    AppMethodBeat.i(219728);
    this.nvw.post(paramRunnable);
    AppMethodBeat.o(219728);
  }
  
  public final void bSA()
  {
    AppMethodBeat.i(219724);
    Animator localAnimator = this.Fj;
    if (localAnimator != null)
    {
      localAnimator.pause();
      AppMethodBeat.o(219724);
      return;
    }
    AppMethodBeat.o(219724);
  }
  
  public final void bSz()
  {
    AppMethodBeat.i(219723);
    Animator localAnimator = this.Fj;
    if (localAnimator != null)
    {
      localAnimator.resume();
      AppMethodBeat.o(219723);
      return;
    }
    AppMethodBeat.o(219723);
  }
  
  public final void clearAnimation()
  {
    AppMethodBeat.i(219727);
    Object localObject = this.Fj;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    localObject = this.nvw.getButtonImage();
    if (localObject != null)
    {
      ((ImageView)localObject).clearAnimation();
      AppMethodBeat.o(219727);
      return;
    }
    AppMethodBeat.o(219727);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(219722);
    y(null);
    AppMethodBeat.o(219722);
  }
  
  protected final Context getContext()
  {
    AppMethodBeat.i(219726);
    Context localContext = this.nvw.getContext();
    p.g(localContext, "mButton.context");
    AppMethodBeat.o(219726);
    return localContext;
  }
  
  public final void setDescription(CharSequence paramCharSequence) {}
  
  public final void setLogo(int paramInt) {}
  
  public final void setLogo(Drawable paramDrawable)
  {
    AppMethodBeat.i(219721);
    y(paramDrawable);
    AppMethodBeat.o(219721);
  }
  
  public final void setStatus(int paramInt) {}
  
  protected final void y(final Drawable paramDrawable)
  {
    AppMethodBeat.i(219725);
    AppBrandOptionButton localAppBrandOptionButton = this.nvw;
    clearAnimation();
    if (paramDrawable == null)
    {
      localAppBrandOptionButton.reset();
      AppMethodBeat.o(219725);
      return;
    }
    localAppBrandOptionButton.getButtonImage().setImageDrawable(paramDrawable);
    Animator localAnimator = cF((View)localAppBrandOptionButton.getButtonImage());
    if (!(localAnimator instanceof ValueAnimator)) {}
    for (Object localObject = null;; localObject = localAnimator)
    {
      localObject = (ValueAnimator)localObject;
      if (localObject != null) {
        ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(localAppBrandOptionButton, paramDrawable));
      }
      localAnimator.start();
      this.Fj = localAnimator;
      AppMethodBeat.o(219725);
      return;
    }
  }
  
  protected final void yS(int paramInt) {}
  
  public final void yT(int paramInt) {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkWrapper$applyLogo$1$1"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(AppBrandOptionButton paramAppBrandOptionButton, Drawable paramDrawable) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(219720);
      this.nvx.getButtonImage().setImageDrawable(paramDrawable);
      AppMethodBeat.o(219720);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.h
 * JD-Core Version:    0.7.0.1
 */