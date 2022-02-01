package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;

public class InputLinearLayout
  extends LinearLayout
{
  private int a = 1;
  
  public InputLinearLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public InputLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setClipToPadding(false);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a == 1) {}
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    int i = paramMotionEvent.getAction();
    if (i == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return true;
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = getChildAt(0);
    if ((localView != null) && (localView.getVisibility() != 8)) {
      localView.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    }
  }
  
  public void setStatus(int paramInt)
  {
    this.a = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.InputLinearLayout
 * JD-Core Version:    0.7.0.1
 */