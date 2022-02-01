package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.TimeFormatterUtils;

public abstract class AbstractChatItemBuilder
  implements ChatItemBuilder
{
  public Context a;
  protected BaseAdapter a;
  public SessionInfo a;
  public QQAppInterface a;
  
  public AbstractChatItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    Context localContext = paramViewGroup.getContext();
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = new LinearLayout(localContext);
      ((LinearLayout)paramViewGroup).setOrientation(1);
      paramView = a();
      paramViewGroup.setTag(paramView);
      paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      if (!paramChatMessage.mNeedTimeStamp) {
        break label361;
      }
      if (paramView.jdField_a_of_type_AndroidWidgetTextView == null)
      {
        localObject = new TextView(localContext);
        paramInt1 = AIOUtils.a(14.0F, localContext.getResources());
        ((TextView)localObject).setTextSize(2, 14.0F);
        ((TextView)localObject).setTextColor(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.a);
        ((TextView)localObject).setPadding(paramInt1, 0, paramInt1, 0);
        ((TextView)localObject).setGravity(17);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.gravity = 1;
        localLayoutParams.topMargin = localContext.getResources().getDimensionPixelOffset(2131493066);
        localLayoutParams.bottomMargin = localContext.getResources().getDimensionPixelOffset(2131493067);
        ((ViewGroup)paramViewGroup).addView((View)localObject, 0, localLayoutParams);
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject);
        ((TextView)localObject).setTag(Long.valueOf(0L));
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (((Long)paramView.jdField_a_of_type_AndroidWidgetTextView.getTag()).longValue() != paramChatMessage.time)
      {
        localObject = TimeFormatterUtils.a(localContext, 3, paramChatMessage.time * 1000L);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
      label262:
      paramChatMessage = a(paramChatMessage, paramView, paramView.jdField_a_of_type_AndroidViewView, (LinearLayout)paramViewGroup, paramOnLongClickAndTouchListener);
      if (paramView.jdField_a_of_type_AndroidViewView != paramChatMessage)
      {
        if (paramView.jdField_a_of_type_AndroidViewView != null) {
          ((ViewGroup)paramViewGroup).removeView(paramView.jdField_a_of_type_AndroidViewView);
        }
        if (paramChatMessage.getLayoutParams() != null) {
          break label382;
        }
        ((ViewGroup)paramViewGroup).addView(paramChatMessage, -1, -2);
      }
    }
    for (;;)
    {
      paramView.jdField_a_of_type_AndroidViewView = paramChatMessage;
      return paramViewGroup;
      localObject = (AbstractChatItemBuilder.ViewHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      break;
      label361:
      if (paramView.jdField_a_of_type_AndroidWidgetTextView == null) {
        break label262;
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      break label262;
      label382:
      ((ViewGroup)paramViewGroup).addView(paramChatMessage);
    }
  }
  
  public abstract View a(MessageRecord paramMessageRecord, AbstractChatItemBuilder.ViewHolder paramViewHolder, View paramView, LinearLayout paramLinearLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener);
  
  public abstract AbstractChatItemBuilder.ViewHolder a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AbstractChatItemBuilder
 * JD-Core Version:    0.7.0.1
 */