package com.tencent.mm.plugin.finder.live.plugin;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLikeConfettiPlugin$LineInterpolator;", "Landroid/view/animation/Interpolator;", "divide", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)V", "divideInput", "", "divideOutput", "getInterpolation", "input", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class az$a
  implements Interpolator
{
  private final float DdS;
  private final float DdT;
  
  public az$a(PointF paramPointF)
  {
    AppMethodBeat.i(355639);
    this.DdS = paramPointF.x;
    this.DdT = paramPointF.y;
    AppMethodBeat.o(355639);
  }
  
  public final float getInterpolation(float paramFloat)
  {
    if (paramFloat < this.DdS) {
      return paramFloat / this.DdS * this.DdT;
    }
    return this.DdT + (paramFloat - this.DdS) / (1.0F - this.DdS) * (1.0F - this.DdT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.az.a
 * JD-Core Version:    0.7.0.1
 */