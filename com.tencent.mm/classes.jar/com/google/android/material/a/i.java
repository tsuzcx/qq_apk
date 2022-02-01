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
  private int aLK = 1;
  private int buA = 0;
  private TimeInterpolator buz = null;
  public long delay = 0L;
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
    this.buz = paramTimeInterpolator;
  }
  
  static i a(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(234253);
    i locali = new i(paramValueAnimator.getStartDelay(), paramValueAnimator.getDuration(), b(paramValueAnimator));
    locali.buA = paramValueAnimator.getRepeatCount();
    locali.aLK = paramValueAnimator.getRepeatMode();
    AppMethodBeat.o(234253);
    return locali;
  }
  
  private static TimeInterpolator b(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(234256);
    paramValueAnimator = paramValueAnimator.getInterpolator();
    if (((paramValueAnimator instanceof AccelerateDecelerateInterpolator)) || (paramValueAnimator == null))
    {
      paramValueAnimator = a.bun;
      AppMethodBeat.o(234256);
      return paramValueAnimator;
    }
    if ((paramValueAnimator instanceof AccelerateInterpolator))
    {
      paramValueAnimator = a.buo;
      AppMethodBeat.o(234256);
      return paramValueAnimator;
    }
    if ((paramValueAnimator instanceof DecelerateInterpolator))
    {
      paramValueAnimator = a.bup;
      AppMethodBeat.o(234256);
      return paramValueAnimator;
    }
    AppMethodBeat.o(234256);
    return paramValueAnimator;
  }
  
  public final void b(Animator paramAnimator)
  {
    AppMethodBeat.i(234252);
    paramAnimator.setStartDelay(this.delay);
    paramAnimator.setDuration(this.duration);
    paramAnimator.setInterpolator(np());
    if ((paramAnimator instanceof ValueAnimator))
    {
      ((ValueAnimator)paramAnimator).setRepeatCount(this.buA);
      ((ValueAnimator)paramAnimator).setRepeatMode(this.aLK);
    }
    AppMethodBeat.o(234252);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(234258);
    if (this == paramObject)
    {
      AppMethodBeat.o(234258);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(234258);
      return false;
    }
    paramObject = (i)paramObject;
    if (this.delay != paramObject.delay)
    {
      AppMethodBeat.o(234258);
      return false;
    }
    if (this.duration != paramObject.duration)
    {
      AppMethodBeat.o(234258);
      return false;
    }
    if (this.buA != paramObject.buA)
    {
      AppMethodBeat.o(234258);
      return false;
    }
    if (this.aLK != paramObject.aLK)
    {
      AppMethodBeat.o(234258);
      return false;
    }
    boolean bool = np().getClass().equals(paramObject.np().getClass());
    AppMethodBeat.o(234258);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(234259);
    int i = (int)(this.delay ^ this.delay >>> 32);
    int j = (int)(this.duration ^ this.duration >>> 32);
    int k = np().getClass().hashCode();
    int m = this.buA;
    int n = this.aLK;
    AppMethodBeat.o(234259);
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  public final TimeInterpolator np()
  {
    if (this.buz != null) {
      return this.buz;
    }
    return a.bun;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(234260);
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
    ((StringBuilder)localObject).append(np().getClass());
    ((StringBuilder)localObject).append(" repeatCount: ");
    ((StringBuilder)localObject).append(this.buA);
    ((StringBuilder)localObject).append(" repeatMode: ");
    ((StringBuilder)localObject).append(this.aLK);
    ((StringBuilder)localObject).append("}\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(234260);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.a.i
 * JD-Core Version:    0.7.0.1
 */