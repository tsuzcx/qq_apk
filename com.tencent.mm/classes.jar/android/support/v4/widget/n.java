package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
public final class n
{
  public OverScroller iY;
  
  private n(Context paramContext, Interpolator paramInterpolator)
  {
    if (paramInterpolator != null) {}
    for (paramContext = new OverScroller(paramContext, paramInterpolator);; paramContext = new OverScroller(paramContext))
    {
      this.iY = paramContext;
      return;
    }
  }
  
  @Deprecated
  public static n a(Context paramContext, Interpolator paramInterpolator)
  {
    return new n(paramContext, paramInterpolator);
  }
  
  @Deprecated
  public final void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.iY.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.n
 * JD-Core Version:    0.7.0.1
 */