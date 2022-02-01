package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import mqq.app.BasePadActivity;
import mqq.app.MyFragment;

public class NotAllowIntercepLinearLayout
  extends LinearLayout
{
  public NotAllowIntercepLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public NotAllowIntercepLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NotAllowIntercepLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      if ((getContext() instanceof BasePadActivity))
      {
        Object localObject = (BasePadActivity)getContext();
        if (localObject != null)
        {
          localObject = (MyFragment)((BasePadActivity)localObject).getTopFragment();
          if ((localObject != null) && ((((MyFragment)localObject).getBasePadAct() instanceof StatusHistoryActivity))) {
            ((StatusHistoryActivity)((MyFragment)localObject).getBasePadAct()).a(paramMotionEvent);
          }
        }
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NotAllowIntercepLinearLayout
 * JD-Core Version:    0.7.0.1
 */