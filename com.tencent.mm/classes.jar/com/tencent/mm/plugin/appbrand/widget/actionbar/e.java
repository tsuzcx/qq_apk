package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.a.a;
import com.tencent.mm.plugin.appbrand.page.a.b;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandCapsuleBarWorkaroundImpl;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/BaseBlinkingCapsuleBarPart;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBar;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkingPart$BlinkHandler;", "()V", "mAnimator", "Landroid/animation/Animator;", "mButton", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;", "applyDescription", "", "description", "", "applyLogo", "logo", "Landroid/graphics/drawable/Drawable;", "applyStatus", "status", "", "blink", "clearAnimation", "destroy", "dismiss", "getContext", "Landroid/content/Context;", "pause", "resume", "scheduleToUiThread", "runnable", "Ljava/lang/Runnable;", "setDescription", "resId", "setLogo", "drawable", "setStatus", "setStyle", "style", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarColoredStylePart$Style;", "wrap", "button", "luggage-wxa-app_release"})
public final class e
  extends a
  implements b, c.a
{
  private Animator Di;
  AppBrandOptionButton mtA;
  
  private final void clearAnimation()
  {
    AppMethodBeat.i(135623);
    Object localObject = this.Di;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    localObject = this.mtA;
    if (localObject != null)
    {
      localObject = ((AppBrandOptionButton)localObject).getButtonImage();
      if (localObject != null)
      {
        ((ImageView)localObject).clearAnimation();
        AppMethodBeat.o(135623);
        return;
      }
    }
    AppMethodBeat.o(135623);
  }
  
  public final void A(CharSequence paramCharSequence) {}
  
  public final void N(Runnable paramRunnable)
  {
    AppMethodBeat.i(160942);
    ap.f(paramRunnable);
    AppMethodBeat.o(160942);
  }
  
  public final c.a brA()
  {
    return (c.a)this;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(135618);
    clearAnimation();
    this.mtA = null;
    AppMethodBeat.o(135618);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(135617);
    x(null);
    AppMethodBeat.o(135617);
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(135622);
    Object localObject = this.mtA;
    if (localObject == null) {
      k.fOy();
    }
    localObject = ((AppBrandOptionButton)localObject).getContext();
    k.g(localObject, "mButton!!.context");
    AppMethodBeat.o(135622);
    return localObject;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(135620);
    Animator localAnimator = this.Di;
    if (localAnimator != null)
    {
      localAnimator.pause();
      AppMethodBeat.o(135620);
      return;
    }
    AppMethodBeat.o(135620);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(135619);
    Animator localAnimator = this.Di;
    if (localAnimator != null)
    {
      localAnimator.resume();
      AppMethodBeat.o(135619);
      return;
    }
    AppMethodBeat.o(135619);
  }
  
  public final void setLogo(int paramInt) {}
  
  public final void setLogo(Drawable paramDrawable)
  {
    AppMethodBeat.i(135616);
    x(paramDrawable);
    AppMethodBeat.o(135616);
  }
  
  public final void setStatus(int paramInt) {}
  
  public final void ug(int paramInt) {}
  
  public final void us(int paramInt) {}
  
  public final void x(final Drawable paramDrawable)
  {
    AppMethodBeat.i(135621);
    AppBrandOptionButton localAppBrandOptionButton = this.mtA;
    if (localAppBrandOptionButton == null) {
      k.fOy();
    }
    clearAnimation();
    if (paramDrawable == null)
    {
      localAppBrandOptionButton.reset();
      AppMethodBeat.o(135621);
      return;
    }
    localAppBrandOptionButton.getButtonImage().setImageDrawable(paramDrawable);
    Animator localAnimator = cJ((View)localAppBrandOptionButton.getButtonImage());
    if (!(localAnimator instanceof ValueAnimator)) {}
    for (Object localObject = null;; localObject = localAnimator)
    {
      localObject = (ValueAnimator)localObject;
      if (localObject != null) {
        ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(localAppBrandOptionButton, paramDrawable));
      }
      localAnimator.start();
      this.Di = localAnimator;
      AppMethodBeat.o(135621);
      return;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandCapsuleBarWorkaroundImpl$applyLogo$1$1"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(AppBrandOptionButton paramAppBrandOptionButton, Drawable paramDrawable) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(135615);
      this.mtB.getButtonImage().setImageDrawable(paramDrawable);
      AppMethodBeat.o(135615);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.e
 * JD-Core Version:    0.7.0.1
 */