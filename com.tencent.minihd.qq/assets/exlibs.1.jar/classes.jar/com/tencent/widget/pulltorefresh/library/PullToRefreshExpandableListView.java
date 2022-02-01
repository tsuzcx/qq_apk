package com.tencent.widget.pulltorefresh.library;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ExpandableListView;
import ltu;
import ltv;

public class PullToRefreshExpandableListView
  extends PullToRefreshAdapterViewBase
{
  public PullToRefreshExpandableListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PullToRefreshExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PullToRefreshExpandableListView(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext, paramMode);
  }
  
  public PullToRefreshExpandableListView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle)
  {
    super(paramContext, paramMode, paramAnimationStyle);
  }
  
  protected ExpandableListView a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9) {}
    for (paramContext = new ltv(this, paramContext, paramAttributeSet);; paramContext = new ltu(this, paramContext, paramAttributeSet))
    {
      paramContext.setId(16908298);
      return paramContext;
    }
  }
  
  public final PullToRefreshBase.Orientation a()
  {
    return PullToRefreshBase.Orientation.VERTICAL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.pulltorefresh.library.PullToRefreshExpandableListView
 * JD-Core Version:    0.7.0.1
 */