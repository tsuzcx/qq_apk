package com.tencent.mobileqq.activity.messagesearch;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatHistorySearchData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import gom;
import gon;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MessageResultAdapter
  extends BaseAdapter
{
  private static final String jdField_a_of_type_JavaLangString = MessageResultAdapter.class.getSimpleName();
  final int jdField_a_of_type_Int = 20;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public ChatHistorySearchData a;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  public Object a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private String b;
  
  public MessageResultAdapter(Context paramContext, WeakReferenceHandler paramWeakReferenceHandler, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = paramWeakReferenceHandler;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private ChatHistorySearchData a(ChatHistorySearchData paramChatHistorySearchData, ArrayList paramArrayList)
  {
    int i = 0;
    while (i < 20)
    {
      if (paramChatHistorySearchData == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "chatHistorySearchData == null");
        }
        return paramChatHistorySearchData;
      }
      if (paramChatHistorySearchData.mSearchData1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "chatHistorySearchData.mSearchData1 == null");
        }
        paramChatHistorySearchData.offset = 0;
        return paramChatHistorySearchData;
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "chatHistorySearchData.offset = " + paramChatHistorySearchData.offset);
      }
      int k = paramChatHistorySearchData.offset;
      while (k < paramChatHistorySearchData.mSearchData1.size())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramChatHistorySearchData.mSearchData1.get(k);
        paramChatHistorySearchData.offset += 1;
        int j = i;
        if (a(localMessageRecord))
        {
          paramArrayList.add(new MessageItem(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord));
          i += 1;
          j = i;
          if (i == 20)
          {
            if (QLog.isColorLevel()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "getMessageRecords, one page, offset = " + paramChatHistorySearchData.offset);
            }
            return paramChatHistorySearchData;
          }
        }
        k += 1;
        i = j;
      }
      if ((paramChatHistorySearchData.mSearchData2 == null) || (paramChatHistorySearchData.mSearchData2.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "chatHistorySearchData.mSearchData2 == null or empty");
        }
        return paramChatHistorySearchData;
      }
      paramChatHistorySearchData = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramChatHistorySearchData.mSearchData2);
      paramChatHistorySearchData.offset = 0;
    }
    return paramChatHistorySearchData;
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (paramMessageRecord.msg == null) || (paramMessageRecord.msg.trim().length() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "isValidData, empty item");
      }
    }
    String str;
    do
    {
      return false;
      str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageRecord.isSend(), paramMessageRecord.senderuin).toLowerCase(Locale.US);
      paramMessageRecord = MessageItem.a(paramMessageRecord.msg).toLowerCase(Locale.US);
    } while ((!str.contains(MessageItem.jdField_a_of_type_JavaLangString)) && (!paramMessageRecord.contains(MessageItem.jdField_a_of_type_JavaLangString)));
    return true;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(String paramString, MessageResultAdapter.LOAD_TYPE paramLOAD_TYPE)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "loadMessageResult, keyword = " + paramString + ", loadType = " + paramLOAD_TYPE.ordinal());
    }
    if (paramString == null) {
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramString;
    MessageItem.a(paramString);
    new Thread(new gom(this, paramString, paramLOAD_TYPE)).start();
  }
  
  public void a(List paramList, int paramInt)
  {
    if (paramInt == MessageResultAdapter.LOAD_TYPE.LOAD_REFRESH.mValue) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    while (paramInt != MessageResultAdapter.LOAD_TYPE.LOAD_MORE.mValue) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MessageItem localMessageItem = (MessageItem)getItem(paramInt);
    View localView;
    MessageRecord localMessageRecord;
    String str2;
    if (paramView == null)
    {
      localView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130903375, null);
      paramViewGroup = new gon(null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131297264));
      paramViewGroup.b = ((TextView)localView.findViewById(2131297269));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131296551));
      paramViewGroup.c = ((TextView)localView.findViewById(2131297921));
      localView.setTag(paramViewGroup);
      localMessageRecord = localMessageItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      str2 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageRecord.isSend(), localMessageRecord.senderuin);
      paramViewGroup.b.setText(localMessageItem.a(localMessageRecord.msg));
      String str1 = localMessageRecord.senderuin;
      paramView = str1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)
      {
        paramView = str1;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)
        {
          if (!localMessageRecord.isSend()) {
            break label305;
          }
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        }
      }
      label200:
      if (!AnonymousChatHelper.a(localMessageRecord)) {
        break label316;
      }
      paramView = AnonymousChatHelper.a(localMessageRecord);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131363837) + paramView.jdField_b_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(URLDrawable.getDrawable(AnonymousChatHelper.a(paramView.jdField_b_of_type_Int)));
    }
    for (;;)
    {
      paramViewGroup.c.setText(localMessageItem.a(localMessageRecord.time));
      return localView;
      paramViewGroup = (gon)paramView.getTag();
      localView = paramView;
      break;
      label305:
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      break label200;
      label316:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localMessageItem.a(str2));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramView));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.MessageResultAdapter
 * JD-Core Version:    0.7.0.1
 */