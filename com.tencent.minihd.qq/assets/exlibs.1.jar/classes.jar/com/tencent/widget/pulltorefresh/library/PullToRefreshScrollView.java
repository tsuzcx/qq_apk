package com.tencent.widget.pulltorefresh.library;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import lub;

public class PullToRefreshScrollView
  extends PullToRefreshBase
{
  public PullToRefreshScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PullToRefreshScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PullToRefreshScrollView(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext, paramMode);
  }
  
  public PullToRefreshScrollView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle)
  {
    super(paramContext, paramMode, paramAnimationStyle);
  }
  
  protected ScrollView a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9) {}
    for (paramContext = new lub(this, paramContext, paramAttributeSet);; paramContext = new ScrollView(paramContext, paramAttributeSet))
    {
      paramContext.setId(2131296451);
      return paramContext;
    }
  }
  
  public final PullToRefreshBase.Orientation a()
  {
    return PullToRefreshBase.Orientation.VERTICAL;
  }
  
  protected boolean i()
  {
    return ((ScrollView)this.a).getScrollY() == 0;
  }
  
  protected boolean j()
  {
    View localView = ((ScrollView)this.a).getChildAt(0);
    if (localView != null) {
      return ((ScrollView)this.a).getScrollY() >= localView.getHeight() - getHeight();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.pulltorefresh.library.PullToRefreshScrollView
 * JD-Core Version:    0.7.0.1
 */