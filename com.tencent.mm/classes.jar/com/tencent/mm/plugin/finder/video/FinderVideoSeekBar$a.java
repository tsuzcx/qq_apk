package com.tencent.mm.plugin.finder.video;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.SeekBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/video/FinderVideoSeekBar$updateProgress$1$1$1"})
final class FinderVideoSeekBar$a
  implements ValueAnimator.AnimatorUpdateListener
{
  FinderVideoSeekBar$a(SeekBar paramSeekBar) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(205450);
    p.g(paramValueAnimator, "it");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(205450);
      throw paramValueAnimator;
    }
    int i = ((Integer)paramValueAnimator).intValue();
    this.tbh.setProgress(i);
    AppMethodBeat.o(205450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoSeekBar.a
 * JD-Core Version:    0.7.0.1
 */