package android.support.design.a;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public final class i
{
  public long duration = 300L;
  public long gY = 0L;
  private TimeInterpolator gZ = null;
  private int repeatCount = 0;
  private int repeatMode = 1;
  
  public i(long paramLong)
  {
    this.gY = paramLong;
    this.duration = 150L;
  }
  
  private i(long paramLong1, long paramLong2, TimeInterpolator paramTimeInterpolator)
  {
    this.gY = paramLong1;
    this.duration = paramLong2;
    this.gZ = paramTimeInterpolator;
  }
  
  static i a(ValueAnimator paramValueAnimator)
  {
    i locali = new i(paramValueAnimator.getStartDelay(), paramValueAnimator.getDuration(), b(paramValueAnimator));
    locali.repeatCount = paramValueAnimator.getRepeatCount();
    locali.repeatMode = paramValueAnimator.getRepeatMode();
    return locali;
  }
  
  private static TimeInterpolator b(ValueAnimator paramValueAnimator)
  {
    TimeInterpolator localTimeInterpolator = paramValueAnimator.getInterpolator();
    if (((localTimeInterpolator instanceof AccelerateDecelerateInterpolator)) || (localTimeInterpolator == null)) {
      paramValueAnimator = a.gL;
    }
    do
    {
      return paramValueAnimator;
      if ((localTimeInterpolator instanceof AccelerateInterpolator)) {
        return a.gM;
      }
      paramValueAnimator = localTimeInterpolator;
    } while (!(localTimeInterpolator instanceof DecelerateInterpolator));
    return a.gN;
  }
  
  public final void a(Animator paramAnimator)
  {
    paramAnimator.setStartDelay(this.gY);
    paramAnimator.setDuration(this.duration);
    paramAnimator.setInterpolator(getInterpolator());
    if ((paramAnimator instanceof ValueAnimator))
    {
      ((ValueAnimator)paramAnimator).setRepeatCount(this.repeatCount);
      ((ValueAnimator)paramAnimator).setRepeatMode(this.repeatMode);
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return bool1;
                bool1 = bool2;
              } while (paramObject == null);
              bool1 = bool2;
            } while (getClass() != paramObject.getClass());
            paramObject = (i)paramObject;
            bool1 = bool2;
          } while (this.gY != paramObject.gY);
          bool1 = bool2;
        } while (this.duration != paramObject.duration);
        bool1 = bool2;
      } while (this.repeatCount != paramObject.repeatCount);
      bool1 = bool2;
    } while (this.repeatMode != paramObject.repeatMode);
    return getInterpolator().getClass().equals(paramObject.getInterpolator().getClass());
  }
  
  public final TimeInterpolator getInterpolator()
  {
    if (this.gZ != null) {
      return this.gZ;
    }
    return a.gL;
  }
  
  public final int hashCode()
  {
    return ((((int)(this.gY ^ this.gY >>> 32) * 31 + (int)(this.duration ^ this.duration >>> 32)) * 31 + getInterpolator().getClass().hashCode()) * 31 + this.repeatCount) * 31 + this.repeatMode;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\n');
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" delay: ");
    localStringBuilder.append(this.gY);
    localStringBuilder.append(" duration: ");
    localStringBuilder.append(this.duration);
    localStringBuilder.append(" interpolator: ");
    localStringBuilder.append(getInterpolator().getClass());
    localStringBuilder.append(" repeatCount: ");
    localStringBuilder.append(this.repeatCount);
    localStringBuilder.append(" repeatMode: ");
    localStringBuilder.append(this.repeatMode);
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.a.i
 * JD-Core Version:    0.7.0.1
 */