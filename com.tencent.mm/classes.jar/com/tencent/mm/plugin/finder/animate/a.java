package com.tencent.mm.plugin.finder.animate;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/animate/SpringInterpolator;", "Landroid/view/animation/Interpolator;", "factor", "", "(F)V", "getFactor", "()F", "getInterpolation", "input", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements Interpolator
{
  private final float htO;
  
  public a(float paramFloat)
  {
    this.htO = paramFloat;
  }
  
  public final float getInterpolation(float paramFloat)
  {
    AppMethodBeat.i(329878);
    paramFloat = (float)(Math.pow(2.0D, -10.0F * paramFloat) * Math.sin((paramFloat - this.htO / 4.0F) * 6.283185307179586D / this.htO) + 1.0D);
    AppMethodBeat.o(329878);
    return paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.animate.a
 * JD-Core Version:    0.7.0.1
 */