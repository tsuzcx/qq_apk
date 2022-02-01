package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.Animation;
import com.tencent.tencentmap.mapsdk.maps.model.IAnimationSet;

public final class he
  extends hd
  implements IAnimationSet
{
  public he(boolean paramBoolean)
  {
    AppMethodBeat.i(226079);
    if (this.a == null) {
      this.a = new hv(paramBoolean);
    }
    AppMethodBeat.o(226079);
  }
  
  public final boolean addAnimation(Animation paramAnimation)
  {
    AppMethodBeat.i(226095);
    if (paramAnimation == null)
    {
      AppMethodBeat.o(226095);
      return false;
    }
    if ((paramAnimation instanceof hd))
    {
      paramAnimation = (hd)paramAnimation;
      if (paramAnimation.a == null)
      {
        AppMethodBeat.o(226095);
        return false;
      }
      if (this.a == null)
      {
        AppMethodBeat.o(226095);
        return false;
      }
      ((hv)this.a).a(paramAnimation.a);
      AppMethodBeat.o(226095);
      return true;
    }
    AppMethodBeat.o(226095);
    return false;
  }
  
  public final void cleanAnimation()
  {
    AppMethodBeat.i(226100);
    if (this.a == null)
    {
      AppMethodBeat.o(226100);
      return;
    }
    ((hv)this.a).c();
    AppMethodBeat.o(226100);
  }
  
  public final void setDuration(long paramLong)
  {
    AppMethodBeat.i(226085);
    if (this.a == null)
    {
      AppMethodBeat.o(226085);
      return;
    }
    this.a.a(paramLong);
    AppMethodBeat.o(226085);
  }
  
  public final void setInterpolator(Interpolator paramInterpolator)
  {
    if (this.a == null) {}
    while (paramInterpolator == null) {
      return;
    }
    this.a.f = paramInterpolator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.he
 * JD-Core Version:    0.7.0.1
 */