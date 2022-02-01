package com.tencent.mm.msgsubscription.ui.a;

import android.view.animation.Interpolator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/interpolator/EaseInOut;", "Landroid/view/animation/Interpolator;", "()V", "getInterpolation", "", "input", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements Interpolator
{
  public final float getInterpolation(float paramFloat)
  {
    if (paramFloat < 0.5F)
    {
      paramFloat *= 2.0F;
      return paramFloat * (0.5F * paramFloat * paramFloat * paramFloat * paramFloat);
    }
    paramFloat = (paramFloat - 0.5F) * 2.0F - 1.0F;
    return paramFloat * (0.5F * paramFloat * paramFloat * paramFloat * paramFloat) + 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.a.a
 * JD-Core Version:    0.7.0.1
 */