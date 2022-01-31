package com.tencent.mm.plugin.appbrand.widget.actionbar;

import a.l;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandCapsuleBarWorkaroundImpl$applyLogo$1$1"})
final class e$a
  implements ValueAnimator.AnimatorUpdateListener
{
  e$a(AppBrandOptionButton paramAppBrandOptionButton, Drawable paramDrawable) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(87598);
    this.jbD.getButtonImage().setImageDrawable(this.jbE);
    AppMethodBeat.o(87598);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.e.a
 * JD-Core Version:    0.7.0.1
 */