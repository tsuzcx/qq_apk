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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkWrapper;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/BaseBlinkingCapsuleBarPart;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkingPart$BlinkHandler;", "mButton", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;", "(Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;)V", "mAnimator", "Landroid/animation/Animator;", "applyDescription", "", "description", "", "applyLogo", "logo", "Landroid/graphics/drawable/Drawable;", "applyStatus", "status", "", "blink", "clearAnimation", "destroy", "dismiss", "getContext", "Landroid/content/Context;", "pauseAnimation", "resumeAnimation", "scheduleToUiThread", "runnable", "Ljava/lang/Runnable;", "setDescription", "resId", "setLogo", "drawable", "setStatus", "luggage-wxa-app_release"})
public final class h
  extends f
  implements i.a
{
  private Animator Vp;
  private final AppBrandOptionButton qxx;
  
  public h(AppBrandOptionButton paramAppBrandOptionButton)
  {
    AppMethodBeat.i(242614);
    this.qxx = paramAppBrandOptionButton;
    AppMethodBeat.o(242614);
  }
  
  protected final void Cw(int paramInt) {}
  
  public final void Cy(int paramInt) {}
  
  protected final void D(final Drawable paramDrawable)
  {
    AppMethodBeat.i(242609);
    AppBrandOptionButton localAppBrandOptionButton = this.qxx;
    cfD();
    if (paramDrawable == null)
    {
      localAppBrandOptionButton.reset();
      AppMethodBeat.o(242609);
      return;
    }
    localAppBrandOptionButton.getButtonImage().setImageDrawable(paramDrawable);
    Animator localAnimator = cY((View)localAppBrandOptionButton.getButtonImage());
    if (!(localAnimator instanceof ValueAnimator)) {}
    for (Object localObject = null;; localObject = localAnimator)
    {
      localObject = (ValueAnimator)localObject;
      if (localObject != null) {
        ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(localAppBrandOptionButton, paramDrawable));
      }
      localAnimator.start();
      this.Vp = localAnimator;
      AppMethodBeat.o(242609);
      return;
    }
  }
  
  protected final void L(CharSequence paramCharSequence) {}
  
  public final void M(CharSequence paramCharSequence) {}
  
  protected final void P(Runnable paramRunnable)
  {
    AppMethodBeat.i(242613);
    this.qxx.post(paramRunnable);
    AppMethodBeat.o(242613);
  }
  
  public final void cfB()
  {
    AppMethodBeat.i(242604);
    Animator localAnimator = this.Vp;
    if (localAnimator != null)
    {
      localAnimator.resume();
      AppMethodBeat.o(242604);
      return;
    }
    AppMethodBeat.o(242604);
  }
  
  public final void cfC()
  {
    AppMethodBeat.i(242606);
    Animator localAnimator = this.Vp;
    if (localAnimator != null)
    {
      localAnimator.pause();
      AppMethodBeat.o(242606);
      return;
    }
    AppMethodBeat.o(242606);
  }
  
  public final void cfD()
  {
    AppMethodBeat.i(242612);
    Object localObject = this.Vp;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    localObject = this.qxx.getButtonImage();
    if (localObject != null)
    {
      ((ImageView)localObject).clearAnimation();
      AppMethodBeat.o(242612);
      return;
    }
    AppMethodBeat.o(242612);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(242602);
    D(null);
    AppMethodBeat.o(242602);
  }
  
  protected final Context getContext()
  {
    AppMethodBeat.i(242610);
    Context localContext = this.qxx.getContext();
    p.j(localContext, "mButton.context");
    AppMethodBeat.o(242610);
    return localContext;
  }
  
  public final void setLogo(int paramInt) {}
  
  public final void setLogo(Drawable paramDrawable)
  {
    AppMethodBeat.i(242599);
    D(paramDrawable);
    AppMethodBeat.o(242599);
  }
  
  public final void setStatus(int paramInt) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkWrapper$applyLogo$1$1"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(AppBrandOptionButton paramAppBrandOptionButton, Drawable paramDrawable) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(242742);
      this.qxy.getButtonImage().setImageDrawable(paramDrawable);
      AppMethodBeat.o(242742);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.h
 * JD-Core Version:    0.7.0.1
 */