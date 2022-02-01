package com.tencent.mobileqq.activity.flaotaio;

import android.content.Context;
import android.util.Log;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;

public class FloatItemBuilderFactory
{
  public static final int a = 5;
  private static final int b = 0;
  private static final int c = 1;
  private static final int d = 2;
  private static final int e = 3;
  private static final int f = 4;
  private Context jdField_a_of_type_AndroidContentContext;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  FloatGrayTipsItemBuilder jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatGrayTipsItemBuilder;
  FloatHongbaoItemBuilder jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHongbaoItemBuilder;
  FloatPicItemBuilder jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatPicItemBuilder;
  FloatPttItemBuilder jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatPttItemBuilder;
  FloatTextItemBuilder jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatTextItemBuilder;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public FloatItemBuilderFactory(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForPic))
    {
      if (!((MessageForPic)paramChatMessage).isMixed) {
        return 1;
      }
    }
    else
    {
      if ((paramChatMessage instanceof MessageForPtt)) {
        return 2;
      }
      if ((paramChatMessage instanceof MessageForGrayTips)) {
        return 3;
      }
      if ((paramChatMessage instanceof MessageForQQWalletMsg)) {
        try
        {
          boolean bool = MessageForQQWalletMsg.isRedPacketMsg(paramChatMessage);
          if (bool) {
            return 4;
          }
        }
        catch (Exception paramChatMessage)
        {
          Log.e("app2", "getMessageType error", paramChatMessage);
        }
      }
    }
    return 0;
  }
  
  public FloatChatItemBuilder a(ChatMessage paramChatMessage)
  {
    switch (a(paramChatMessage))
    {
    default: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatTextItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatTextItemBuilder = new FloatTextItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatTextItemBuilder;
    case 1: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatPicItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatPicItemBuilder = new FloatPicItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatPicItemBuilder;
    case 2: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatPttItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatPttItemBuilder = new FloatPttItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatPttItemBuilder;
    case 3: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatGrayTipsItemBuilder == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatGrayTipsItemBuilder = new FloatGrayTipsItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatGrayTipsItemBuilder;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHongbaoItemBuilder == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHongbaoItemBuilder = new FloatHongbaoItemBuilder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatHongbaoItemBuilder;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatPttItemBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatPttItemBuilder.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatPicItemBuilder != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlaotaioFloatPicItemBuilder.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.flaotaio.FloatItemBuilderFactory
 * JD-Core Version:    0.7.0.1
 */