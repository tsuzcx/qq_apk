package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.widget.WidgetContainer.OnWidgetMoveListener;

public class CustomRelativeLayout
  extends RelativeLayout
{
  private ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  private WidgetContainer.OnWidgetMoveListener jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer$OnWidgetMoveListener;
  
  public CustomRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public CustomRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CustomRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getRawX();
    float f2 = paramMotionEvent.getRawY();
    paramMotionEvent = new int[2];
    paramView.getLocationInWindow(paramMotionEvent);
    return (f1 >= paramMotionEvent[0]) && (f1 <= paramMotionEvent[0] + paramView.getWidth()) && (f2 >= paramMotionEvent[1]) && (f2 <= paramMotionEvent[1] + paramView.getHeight());
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer$OnWidgetMoveListener = null;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (Conversation.b)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageButton == null) {
        this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131302027));
      }
      if ((this.jdField_a_of_type_AndroidWidgetImageButton == null) || (a(this.jdField_a_of_type_AndroidWidgetImageButton, paramMotionEvent)) || (this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer$OnWidgetMoveListener == null)) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer$OnWidgetMoveListener.a(paramMotionEvent);
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setWidgetMoveListener(WidgetContainer.OnWidgetMoveListener paramOnWidgetMoveListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetWidgetContainer$OnWidgetMoveListener = paramOnWidgetMoveListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomRelativeLayout
 * JD-Core Version:    0.7.0.1
 */