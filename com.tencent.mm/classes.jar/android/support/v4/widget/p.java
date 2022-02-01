package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

@Deprecated
public final class p
{
  public OverScroller SC;
  
  private p(Context paramContext, Interpolator paramInterpolator)
  {
    if (paramInterpolator != null) {}
    for (paramContext = new OverScroller(paramContext, paramInterpolator);; paramContext = new OverScroller(paramContext))
    {
      this.SC = paramContext;
      return;
    }
  }
  
  @Deprecated
  public static p a(Context paramContext, Interpolator paramInterpolator)
  {
    return new p(paramContext, paramInterpolator);
  }
  
  @Deprecated
  public final void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.SC.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.p
 * JD-Core Version:    0.7.0.1
 */