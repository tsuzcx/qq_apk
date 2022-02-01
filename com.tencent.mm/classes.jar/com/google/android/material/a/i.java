package com.google.android.material.a;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  private int cFH = 1;
  private int crd = 0;
  public long delay = 0L;
  private TimeInterpolator dnD = null;
  public long duration = 300L;
  
  public i(long paramLong)
  {
    this.delay = paramLong;
    this.duration = 150L;
  }
  
  private i(long paramLong1, long paramLong2, TimeInterpolator paramTimeInterpolator)
  {
    this.delay = paramLong1;
    this.duration = paramLong2;
    this.dnD = paramTimeInterpolator;
  }
  
  static i a(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(209168);
    i locali = new i(paramValueAnimator.getStartDelay(), paramValueAnimator.getDuration(), b(paramValueAnimator));
    locali.crd = paramValueAnimator.getRepeatCount();
    locali.cFH = paramValueAnimator.getRepeatMode();
    AppMethodBeat.o(209168);
    return locali;
  }
  
  private static TimeInterpolator b(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(209172);
    paramValueAnimator = paramValueAnimator.getInterpolator();
    if (((paramValueAnimator instanceof AccelerateDecelerateInterpolator)) || (paramValueAnimator == null))
    {
      paramValueAnimator = a.dnr;
      AppMethodBeat.o(209172);
      return paramValueAnimator;
    }
    if ((paramValueAnimator instanceof AccelerateInterpolator))
    {
      paramValueAnimator = a.dns;
      AppMethodBeat.o(209172);
      return paramValueAnimator;
    }
    if ((paramValueAnimator instanceof DecelerateInterpolator))
    {
      paramValueAnimator = a.dnt;
      AppMethodBeat.o(209172);
      return paramValueAnimator;
    }
    AppMethodBeat.o(209172);
    return paramValueAnimator;
  }
  
  public final TimeInterpolator LS()
  {
    if (this.dnD != null) {
      return this.dnD;
    }
    return a.dnr;
  }
  
  public final void b(Animator paramAnimator)
  {
    AppMethodBeat.i(209188);
    paramAnimator.setStartDelay(this.delay);
    paramAnimator.setDuration(this.duration);
    paramAnimator.setInterpolator(LS());
    if ((paramAnimator instanceof ValueAnimator))
    {
      ((ValueAnimator)paramAnimator).setRepeatCount(this.crd);
      ((ValueAnimator)paramAnimator).setRepeatMode(this.cFH);
    }
    AppMethodBeat.o(209188);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(209202);
    if (this == paramObject)
    {
      AppMethodBeat.o(209202);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(209202);
      return false;
    }
    paramObject = (i)paramObject;
    if (this.delay != paramObject.delay)
    {
      AppMethodBeat.o(209202);
      return false;
    }
    if (this.duration != paramObject.duration)
    {
      AppMethodBeat.o(209202);
      return false;
    }
    if (this.crd != paramObject.crd)
    {
      AppMethodBeat.o(209202);
      return false;
    }
    if (this.cFH != paramObject.cFH)
    {
      AppMethodBeat.o(209202);
      return false;
    }
    boolean bool = LS().getClass().equals(paramObject.LS().getClass());
    AppMethodBeat.o(209202);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(209215);
    int i = (int)(this.delay ^ this.delay >>> 32);
    int j = (int)(this.duration ^ this.duration >>> 32);
    int k = LS().getClass().hashCode();
    int m = this.crd;
    int n = this.cFH;
    AppMethodBeat.o(209215);
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(209222);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append('\n');
    ((StringBuilder)localObject).append(getClass().getName());
    ((StringBuilder)localObject).append('{');
    ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(this)));
    ((StringBuilder)localObject).append(" delay: ");
    ((StringBuilder)localObject).append(this.delay);
    ((StringBuilder)localObject).append(" duration: ");
    ((StringBuilder)localObject).append(this.duration);
    ((StringBuilder)localObject).append(" interpolator: ");
    ((StringBuilder)localObject).append(LS().getClass());
    ((StringBuilder)localObject).append(" repeatCount: ");
    ((StringBuilder)localObject).append(this.crd);
    ((StringBuilder)localObject).append(" repeatMode: ");
    ((StringBuilder)localObject).append(this.cFH);
    ((StringBuilder)localObject).append("}\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(209222);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.a.i
 * JD-Core Version:    0.7.0.1
 */