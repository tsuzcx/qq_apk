package com.tencent.widget.pulltorefresh.library;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import lty;

public class PullToRefreshHorizontalScrollView
  extends PullToRefreshBase
{
  public PullToRefreshHorizontalScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PullToRefreshHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PullToRefreshHorizontalScrollView(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext, paramMode);
  }
  
  public PullToRefreshHorizontalScrollView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle)
  {
    super(paramContext, paramMode, paramAnimationStyle);
  }
  
  protected HorizontalScrollView a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9) {}
    for (paramContext = new lty(this, paramContext, paramAttributeSet);; paramContext = new HorizontalScrollView(paramContext, paramAttributeSet))
    {
      paramContext.setId(2131296451);
      return paramContext;
    }
  }
  
  public final PullToRefreshBase.Orientation a()
  {
    return PullToRefreshBase.Orientation.HORIZONTAL;
  }
  
  protected boolean i()
  {
    return ((HorizontalScrollView)this.a).getScrollX() == 0;
  }
  
  protected boolean j()
  {
    View localView = ((HorizontalScrollView)this.a).getChildAt(0);
    if (localView != null) {
      return ((HorizontalScrollView)this.a).getScrollX() >= localView.getWidth() - getWidth();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.pulltorefresh.library.PullToRefreshHorizontalScrollView
 * JD-Core Version:    0.7.0.1
 */