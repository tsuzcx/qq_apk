package com.tencent.mm.plugin.finder.video;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.SeekBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$updateProgress$1$1$1"})
final class FinderVideoSeekBar$a
  implements ValueAnimator.AnimatorUpdateListener
{
  FinderVideoSeekBar$a(SeekBar paramSeekBar) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(203876);
    k.g(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(203876);
      throw paramValueAnimator;
    }
    int i = ((Integer)paramValueAnimator).intValue();
    this.rTk.setProgress(i);
    AppMethodBeat.o(203876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoSeekBar.a
 * JD-Core Version:    0.7.0.1
 */