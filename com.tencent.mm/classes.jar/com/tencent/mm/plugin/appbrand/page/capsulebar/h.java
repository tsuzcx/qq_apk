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
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkWrapper;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/BaseBlinkingCapsuleBarPart;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkingPart$BlinkHandler;", "mButton", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;", "(Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;)V", "mAnimator", "Landroid/animation/Animator;", "applyDescription", "", "description", "", "applyLogo", "logo", "Landroid/graphics/drawable/Drawable;", "applyStatus", "status", "", "blink", "clearAnimation", "destroy", "dismiss", "getContext", "Landroid/content/Context;", "pauseAnimation", "resumeAnimation", "scheduleToUiThread", "runnable", "Ljava/lang/Runnable;", "setDescription", "resId", "setLogo", "drawable", "setStatus", "luggage-wxa-app_release"})
public final class h
  extends f
  implements i.a
{
  private Animator EZ;
  private final AppBrandOptionButton mkY;
  
  public h(AppBrandOptionButton paramAppBrandOptionButton)
  {
    AppMethodBeat.i(208113);
    this.mkY = paramAppBrandOptionButton;
    AppMethodBeat.o(208113);
  }
  
  protected final void A(CharSequence paramCharSequence) {}
  
  protected final void K(Runnable paramRunnable)
  {
    AppMethodBeat.i(208112);
    this.mkY.post(paramRunnable);
    AppMethodBeat.o(208112);
  }
  
  public final void bwr()
  {
    AppMethodBeat.i(208107);
    Animator localAnimator = this.EZ;
    if (localAnimator != null)
    {
      localAnimator.resume();
      AppMethodBeat.o(208107);
      return;
    }
    AppMethodBeat.o(208107);
  }
  
  public final void bws()
  {
    AppMethodBeat.i(208108);
    Animator localAnimator = this.EZ;
    if (localAnimator != null)
    {
      localAnimator.pause();
      AppMethodBeat.o(208108);
      return;
    }
    AppMethodBeat.o(208108);
  }
  
  public final void clearAnimation()
  {
    AppMethodBeat.i(208111);
    Object localObject = this.EZ;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    localObject = this.mkY.getButtonImage();
    if (localObject != null)
    {
      ((ImageView)localObject).clearAnimation();
      AppMethodBeat.o(208111);
      return;
    }
    AppMethodBeat.o(208111);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(208106);
    y(null);
    AppMethodBeat.o(208106);
  }
  
  protected final Context getContext()
  {
    AppMethodBeat.i(208110);
    Context localContext = this.mkY.getContext();
    p.g(localContext, "mButton.context");
    AppMethodBeat.o(208110);
    return localContext;
  }
  
  public final void setDescription(CharSequence paramCharSequence) {}
  
  public final void setLogo(int paramInt) {}
  
  public final void setLogo(Drawable paramDrawable)
  {
    AppMethodBeat.i(208105);
    y(paramDrawable);
    AppMethodBeat.o(208105);
  }
  
  public final void setStatus(int paramInt) {}
  
  protected final void va(int paramInt) {}
  
  public final void vb(int paramInt) {}
  
  protected final void y(final Drawable paramDrawable)
  {
    AppMethodBeat.i(208109);
    AppBrandOptionButton localAppBrandOptionButton = this.mkY;
    clearAnimation();
    if (paramDrawable == null)
    {
      localAppBrandOptionButton.reset();
      AppMethodBeat.o(208109);
      return;
    }
    localAppBrandOptionButton.getButtonImage().setImageDrawable(paramDrawable);
    Animator localAnimator = cM((View)localAppBrandOptionButton.getButtonImage());
    if (!(localAnimator instanceof ValueAnimator)) {}
    for (Object localObject = null;; localObject = localAnimator)
    {
      localObject = (ValueAnimator)localObject;
      if (localObject != null) {
        ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(localAppBrandOptionButton, paramDrawable));
      }
      localAnimator.start();
      this.EZ = localAnimator;
      AppMethodBeat.o(208109);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkWrapper$applyLogo$1$1"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(AppBrandOptionButton paramAppBrandOptionButton, Drawable paramDrawable) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(208104);
      this.mkZ.getButtonImage().setImageDrawable(paramDrawable);
      AppMethodBeat.o(208104);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.h
 * JD-Core Version:    0.7.0.1
 */