package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkWrapper;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/BaseBlinkingCapsuleBarPart;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/CapsuleBarBlinkingPart$BlinkHandler;", "mButton", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;", "(Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;)V", "mAnimator", "Landroid/animation/Animator;", "applyDescription", "", "description", "", "applyLogo", "logo", "Landroid/graphics/drawable/Drawable;", "applyStatus", "status", "", "blink", "prior", "", "clearAnimation", "destroy", "dismiss", "getContext", "Landroid/content/Context;", "getTag", "", "pauseAnimation", "resumeAnimation", "scheduleToUiThread", "runnable", "Ljava/lang/Runnable;", "setDescription", "resId", "setLogo", "drawable", "setStatus", "setTag", "tag", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends h
  implements m.a
{
  private Animator bBZ;
  private final AppBrandOptionButton tCC;
  
  public l(AppBrandOptionButton paramAppBrandOptionButton)
  {
    AppMethodBeat.i(325244);
    this.tCC = paramAppBrandOptionButton;
    AppMethodBeat.o(325244);
  }
  
  private static final void a(AppBrandOptionButton paramAppBrandOptionButton, Drawable paramDrawable, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(325249);
    s.u(paramAppBrandOptionButton, "$button");
    paramAppBrandOptionButton.getButtonImage().setImageDrawable(paramDrawable);
    AppMethodBeat.o(325249);
  }
  
  protected final void CM(int paramInt) {}
  
  public final void CP(int paramInt) {}
  
  protected final void M(Drawable paramDrawable)
  {
    AppMethodBeat.i(325314);
    AppBrandOptionButton localAppBrandOptionButton = this.tCC;
    cGs();
    if (paramDrawable == null)
    {
      localAppBrandOptionButton.reset();
      AppMethodBeat.o(325314);
      return;
    }
    localAppBrandOptionButton.getButtonImage().setImageDrawable(paramDrawable);
    Animator localAnimator = dF((View)localAppBrandOptionButton.getButtonImage());
    if ((localAnimator instanceof ValueAnimator)) {}
    for (ValueAnimator localValueAnimator = (ValueAnimator)localAnimator;; localValueAnimator = null)
    {
      if (localValueAnimator != null) {
        localValueAnimator.addUpdateListener(new l..ExternalSyntheticLambda0(localAppBrandOptionButton, paramDrawable));
      }
      localAnimator.start();
      paramDrawable = ah.aiuX;
      this.bBZ = localAnimator;
      AppMethodBeat.o(325314);
      return;
    }
  }
  
  protected final void P(CharSequence paramCharSequence) {}
  
  public final void Q(CharSequence paramCharSequence) {}
  
  protected final void V(Runnable paramRunnable)
  {
    AppMethodBeat.i(325341);
    this.tCC.post(paramRunnable);
    AppMethodBeat.o(325341);
  }
  
  public final void cGq()
  {
    AppMethodBeat.i(325302);
    Animator localAnimator = this.bBZ;
    if (localAnimator != null) {
      localAnimator.resume();
    }
    AppMethodBeat.o(325302);
  }
  
  public final void cGr()
  {
    AppMethodBeat.i(325309);
    Animator localAnimator = this.bBZ;
    if (localAnimator != null) {
      localAnimator.pause();
    }
    AppMethodBeat.o(325309);
  }
  
  public final void cGs()
  {
    AppMethodBeat.i(325334);
    Object localObject = this.bBZ;
    if (localObject != null) {
      ((Animator)localObject).cancel();
    }
    localObject = this.tCC.getButtonImage();
    if (localObject != null) {
      ((ImageView)localObject).clearAnimation();
    }
    AppMethodBeat.o(325334);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(325298);
    M(null);
    AppMethodBeat.o(325298);
  }
  
  protected final Context getContext()
  {
    AppMethodBeat.i(325326);
    Context localContext = this.tCC.getContext();
    s.s(localContext, "mButton.context");
    AppMethodBeat.o(325326);
    return localContext;
  }
  
  public final void setLogo(int paramInt) {}
  
  public final void setLogo(Drawable paramDrawable)
  {
    AppMethodBeat.i(325278);
    M(paramDrawable);
    AppMethodBeat.o(325278);
  }
  
  public final void setStatus(int paramInt) {}
  
  public final void setTag(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.l
 * JD-Core Version:    0.7.0.1
 */