package com.tencent.mm.plugin.finder.view.animation;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
final class b$d
  implements ValueAnimator.AnimatorUpdateListener
{
  b$d(View paramView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(168456);
    paramValueAnimator = paramValueAnimator.getAnimatedValue("scale");
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(168456);
      throw paramValueAnimator;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    this.kfz.setScaleX(f);
    this.kfz.setScaleY(f);
    AppMethodBeat.o(168456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.b.d
 * JD-Core Version:    0.7.0.1
 */