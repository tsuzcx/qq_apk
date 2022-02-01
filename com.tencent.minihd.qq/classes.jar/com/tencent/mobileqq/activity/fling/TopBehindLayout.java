package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class TopBehindLayout
  extends FrameLayout
{
  private View a;
  
  public TopBehindLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public TopBehindLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TopBehindLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext) {}
  
  public void setContent(View paramView)
  {
    if (this.a != null) {
      removeView(this.a);
    }
    this.a = paramView;
    addView(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.TopBehindLayout
 * JD-Core Version:    0.7.0.1
 */