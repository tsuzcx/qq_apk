package com.tencent.mm.plugin.appbrand.widget.actionbar;

import a.f.b.j;
import a.l;
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

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandCapsuleBarWorkaroundImpl;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/BaseBlinkingCapsuleBarPart;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBar;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkingPart$BlinkHandler;", "()V", "mAnimator", "Landroid/animation/Animator;", "mButton", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;", "applyDescription", "", "description", "", "applyLogo", "logo", "Landroid/graphics/drawable/Drawable;", "blink", "clearAnimation", "destroy", "dismiss", "getContext", "Landroid/content/Context;", "pause", "resume", "setDescription", "resId", "", "setLogo", "drawable", "setStyle", "style", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarColoredStylePart$Style;", "wrap", "button", "luggage-wxa-app_release"})
public final class e
  extends a
  implements b, c.a
{
  AppBrandOptionButton jbC;
  private Animator vM;
  
  private final void clearAnimation()
  {
    AppMethodBeat.i(87606);
    Object localObject = this.vM;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    localObject = this.jbC;
    if (localObject != null)
    {
      localObject = ((AppBrandOptionButton)localObject).getButtonImage();
      if (localObject != null)
      {
        ((ImageView)localObject).clearAnimation();
        AppMethodBeat.o(87606);
        return;
      }
    }
    AppMethodBeat.o(87606);
  }
  
  public final c.a aKe()
  {
    return (c.a)this;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(87601);
    clearAnimation();
    this.jbC = null;
    AppMethodBeat.o(87601);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(87600);
    p(null);
    AppMethodBeat.o(87600);
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(87605);
    Object localObject = this.jbC;
    if (localObject == null) {
      j.ebi();
    }
    localObject = ((AppBrandOptionButton)localObject).getContext();
    j.p(localObject, "mButton!!.context");
    AppMethodBeat.o(87605);
    return localObject;
  }
  
  public final void p(Drawable paramDrawable)
  {
    AppMethodBeat.i(87604);
    AppBrandOptionButton localAppBrandOptionButton = this.jbC;
    if (localAppBrandOptionButton == null) {
      j.ebi();
    }
    clearAnimation();
    if (paramDrawable == null)
    {
      localAppBrandOptionButton.reset();
      AppMethodBeat.o(87604);
      return;
    }
    localAppBrandOptionButton.getButtonImage().setImageDrawable(paramDrawable);
    Animator localAnimator = cw((View)localAppBrandOptionButton.getButtonImage());
    if (!(localAnimator instanceof ValueAnimator)) {}
    for (Object localObject = null;; localObject = localAnimator)
    {
      localObject = (ValueAnimator)localObject;
      if (localObject != null) {
        ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new e.a(localAppBrandOptionButton, paramDrawable));
      }
      localAnimator.start();
      this.vM = localAnimator;
      AppMethodBeat.o(87604);
      return;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(87603);
    Animator localAnimator = this.vM;
    if (localAnimator != null)
    {
      localAnimator.pause();
      AppMethodBeat.o(87603);
      return;
    }
    AppMethodBeat.o(87603);
  }
  
  public final void pp(int paramInt) {}
  
  public final void resume()
  {
    AppMethodBeat.i(87602);
    Animator localAnimator = this.vM;
    if (localAnimator != null)
    {
      localAnimator.resume();
      AppMethodBeat.o(87602);
      return;
    }
    AppMethodBeat.o(87602);
  }
  
  public final void setLogo(int paramInt) {}
  
  public final void setLogo(Drawable paramDrawable)
  {
    AppMethodBeat.i(87599);
    p(paramDrawable);
    AppMethodBeat.o(87599);
  }
  
  public final void w(CharSequence paramCharSequence) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.e
 * JD-Core Version:    0.7.0.1
 */