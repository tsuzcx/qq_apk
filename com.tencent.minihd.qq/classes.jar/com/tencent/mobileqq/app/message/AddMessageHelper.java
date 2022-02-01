package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AddMessageHelper
{
  private static final String a = "AddMessageHelper";
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddMessageHelper", 2, "-----addDatingSafetyGrayTipsMessage  frienduin:" + paramString1 + " istroop：" + paramInt + " msg:" + Utils.a(paramString2));
    }
    long l = MessageCache.a();
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(-1028);
    localMessageForGrayTips.init(paramQQAppInterface.a(), paramString1, paramQQAppInterface.a(), paramString2, l, -1028, paramInt, l);
    localMessageForGrayTips.isread = true;
    if (!MessageHandlerUtils.a(paramQQAppInterface, localMessageForGrayTips)) {
      paramQQAppInterface.a().a(localMessageForGrayTips, paramQQAppInterface.a());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddMessageHelper", 2, "-----addGrayTipsMessage  frienduin:" + paramString1 + " istroop：" + paramInt + " msg:" + Utils.a(paramString2));
    }
    if ((paramBoolean1) && (MsgProxyUtils.d(paramInt)) && (QLog.isColorLevel())) {
      QLog.d("AddMessageHelper", 2, "-----addGrayTipsMessage faild : no troop uin");
    }
    long l = MessageCache.a();
    if (paramBoolean1) {}
    for (int i = -5001;; i = -5000)
    {
      MessageForNewGrayTips localMessageForNewGrayTips = (MessageForNewGrayTips)MessageRecordFactory.a(i);
      localMessageForNewGrayTips.init(paramQQAppInterface.a(), paramString1, paramQQAppInterface.a(), paramString2, l, i, paramInt, l);
      localMessageForNewGrayTips.isread = paramBoolean3;
      localMessageForNewGrayTips.spans = paramArrayList;
      localMessageForNewGrayTips.updateMsgData();
      if ((!paramBoolean2) || (!MessageHandlerUtils.a(paramQQAppInterface, localMessageForNewGrayTips, false))) {
        paramQQAppInterface.a().a(localMessageForNewGrayTips, paramQQAppInterface.a());
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramQQAppInterface, paramString1, paramString2, paramInt, null, paramBoolean1, paramBoolean2, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddMessageHelper", 2, "-----addTroopStrangerGrayTipsMessage  frienduin:" + paramString1 + " istroop：" + paramInt + " msg:" + Utils.a(paramString3));
    }
    long l = MessageCache.a();
    if (paramBoolean1) {}
    for (int i = -5001;; i = -5000)
    {
      MessageForNewGrayTips localMessageForNewGrayTips = (MessageForNewGrayTips)MessageRecordFactory.a(i);
      localMessageForNewGrayTips.init(paramQQAppInterface.a(), paramString1, paramString2, paramString3, l, i, paramInt, l);
      localMessageForNewGrayTips.isread = paramBoolean3;
      localMessageForNewGrayTips.spans = paramArrayList;
      localMessageForNewGrayTips.updateMsgData();
      if ((!paramBoolean2) || (!MessageHandlerUtils.a(paramQQAppInterface, localMessageForNewGrayTips, false))) {
        paramQQAppInterface.a().a(localMessageForNewGrayTips, paramQQAppInterface.a());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.AddMessageHelper
 * JD-Core Version:    0.7.0.1
 */