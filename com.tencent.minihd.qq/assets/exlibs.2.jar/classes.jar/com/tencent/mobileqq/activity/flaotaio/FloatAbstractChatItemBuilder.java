package com.tencent.mobileqq.activity.flaotaio;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;

public abstract class FloatAbstractChatItemBuilder
  implements FloatChatItemBuilder
{
  protected float a;
  public Context a;
  public SessionInfo a;
  public QQAppInterface a;
  
  public FloatAbstractChatItemBuilder(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = this.jdField_a_of_type_AndroidContentContext;
    if (paramView == null)
    {
      paramView = new LinearLayout(paramViewGroup);
      ((LinearLayout)paramView).setOrientation(1);
      paramViewGroup = a();
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      paramChatMessage = a(paramChatMessage, paramViewGroup, paramViewGroup.jdField_a_of_type_AndroidViewView, (LinearLayout)paramView);
      if (paramViewGroup.jdField_a_of_type_AndroidViewView != paramChatMessage)
      {
        if (paramViewGroup.jdField_a_of_type_AndroidViewView != null) {
          ((ViewGroup)paramView).removeView(paramViewGroup.jdField_a_of_type_AndroidViewView);
        }
        if (paramChatMessage.getLayoutParams() != null) {
          break label139;
        }
        ((ViewGroup)paramView).addView(paramChatMessage, -1, -2);
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramChatMessage;
      return paramView;
      paramViewGroup = (FloatAbstractChatItemBuilder.ViewHolder)paramView.getTag();
      break;
      label139:
      ((ViewGroup)paramView).addView(paramChatMessage);
    }
  }
  
  protected abstract View a(MessageRecord paramMessageRecord, FloatAbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout);
  
  protected abstract FloatAbstractChatItemBuilder.ViewHolder a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.FloatAbstractChatItemBuilder
 * JD-Core Version:    0.7.0.1
 */