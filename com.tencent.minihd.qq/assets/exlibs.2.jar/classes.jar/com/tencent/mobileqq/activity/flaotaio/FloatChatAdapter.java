package com.tencent.mobileqq.activity.flaotaio;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.widget.XBaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FloatChatAdapter
  extends XBaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public FloatItemBuilderFactory a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public FloatChatAdapter(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatItemBuilderFactory = new FloatItemBuilderFactory(paramContext, paramQQAppInterface, paramSessionInfo);
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return this.jdField_a_of_type_JavaUtilList.indexOf(paramChatMessage);
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatItemBuilderFactory != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatItemBuilderFactory.a();
    }
  }
  
  public void a(List paramList)
  {
    a(paramList, true);
  }
  
  public void a(List paramList, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext()) {}
        switch (((ChatMessage)localIterator.next()).msgtype)
        {
        case -5005: 
        case -4020: 
        case -4001: 
        case -3013: 
        case -3010: 
        case -3009: 
        case -2019: 
        case -1046: 
        case -1043: 
        case -1041: 
        case -1026: 
        case -1017: 
        case -1016: 
        case -1015: 
        case -1014: 
        case -1002: 
          localIterator.remove();
          continue;
          this.jdField_a_of_type_JavaUtilList = paramList;
        }
      }
      finally {}
      if (paramBoolean) {
        super.notifyDataSetChanged();
      }
      return;
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return ((ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt)).uniseq;
  }
  
  public int getItemViewType(int paramInt)
  {
    ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localChatMessage != null) {
      localChatMessage.parse();
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatItemBuilderFactory.a(localChatMessage);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localChatMessage != null) {
      localChatMessage.parse();
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatItemBuilderFactory.a(localChatMessage).a(paramInt, this.jdField_a_of_type_JavaUtilList.size(), localChatMessage, paramView, paramViewGroup);
    if (paramView != null) {
      paramView.setTag(2131296312, localChatMessage);
    }
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.FloatChatAdapter
 * JD-Core Version:    0.7.0.1
 */