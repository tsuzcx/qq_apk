package com.tencent.mobileqq.bubble;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.qphone.base.util.QLog;

public class ChatXListView
  extends FPSXListView
{
  private static final float jdField_a_of_type_Float = -1.0F;
  private static int jdField_b_of_type_Int = 100;
  private static int c = jdField_b_of_type_Int;
  int jdField_a_of_type_Int;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private ChatActivity jdField_a_of_type_ComTencentMobileqqActivityChatActivity;
  private ChatXListView.OnBottomOverScrollListener jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnBottomOverScrollListener;
  private float jdField_b_of_type_Float = -1.0F;
  
  public ChatXListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ChatXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public ChatXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if ((paramContext instanceof ChatActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity = ((ChatActivity)paramContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityChatActivity.a();
    }
    if ((c == jdField_b_of_type_Int) && ((paramContext instanceof Activity)))
    {
      paramInt = ((Activity)paramContext).getWindowManager().getDefaultDisplay().getHeight();
      if (paramInt > 0) {
        break label117;
      }
      paramInt = jdField_b_of_type_Int;
    }
    for (;;)
    {
      c = paramInt;
      if (QLog.isColorLevel()) {
        QLog.d("ChatXListView", 2, "ChatXListView open_panel_threshold_value = " + c);
      }
      return;
      label117:
      paramInt >>= 2;
    }
  }
  
  public ChatXListView.OnBottomOverScrollListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnBottomOverScrollListener;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnBottomOverScrollListener != null)
    {
      if (i != 0) {
        break label52;
      }
      if ((this.jdField_b_of_type_Float != -1.0F) || (!this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnBottomOverScrollListener.j())) {}
    }
    for (this.jdField_b_of_type_Float = paramMotionEvent.getY();; this.jdField_b_of_type_Float = -1.0F)
    {
      label52:
      do
      {
        do
        {
          return super.dispatchTouchEvent(paramMotionEvent);
        } while ((i != 1) && (i != 3) && (i != 2));
        float f = paramMotionEvent.getY();
        if (this.jdField_b_of_type_Float - f > c)
        {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnBottomOverScrollListener.aa();
          this.jdField_b_of_type_Float = -1.0F;
        }
      } while ((i != 1) && (i != 3));
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnBottomOverScrollListener.ab();
    }
  }
  
  public boolean isInEditMode()
  {
    return true;
  }
  
  public void offsetChildrenTopAndBottom(int paramInt)
  {
    super.offsetChildrenTopAndBottom(paramInt);
    if ((paramInt != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.m(paramInt);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt2 - paramInt4;
    if ((paramInt1 != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.m(-paramInt1);
    }
  }
  
  public void setChatPie(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  public void setShowPanelListener(ChatXListView.OnBottomOverScrollListener paramOnBottomOverScrollListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView$OnBottomOverScrollListener = paramOnBottomOverScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.ChatXListView
 * JD-Core Version:    0.7.0.1
 */