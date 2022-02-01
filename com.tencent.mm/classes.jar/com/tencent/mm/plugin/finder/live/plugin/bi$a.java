package com.tencent.mm.plugin.finder.live.plugin;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLikeConfettiPlugin$LineInterpolator;", "Landroid/view/animation/Interpolator;", "divide", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)V", "divideInput", "", "divideOutput", "getInterpolation", "input", "plugin-finder_release"})
public final class bi$a
  implements Interpolator
{
  private final float ytv;
  private final float ytw;
  
  public bi$a(PointF paramPointF)
  {
    AppMethodBeat.i(291493);
    this.ytv = paramPointF.x;
    this.ytw = paramPointF.y;
    AppMethodBeat.o(291493);
  }
  
  public final float getInterpolation(float paramFloat)
  {
    if (paramFloat < this.ytv) {
      return paramFloat / this.ytv * this.ytw;
    }
    return this.ytw + (paramFloat - this.ytv) / (1.0F - this.ytv) * (1.0F - this.ytw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bi.a
 * JD-Core Version:    0.7.0.1
 */