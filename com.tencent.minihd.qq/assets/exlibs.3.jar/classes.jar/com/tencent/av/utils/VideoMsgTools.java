package com.tencent.av.utils;

import android.content.Context;
import cab;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qcall.QCallProxy;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.qav.ipc.QavMsgRecord;
import com.tencent.qav.ipc.QavStateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class VideoMsgTools
{
  private static final String a = "VideoMsgTools";
  
  public static int a(Context paramContext, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramString.contains(paramContext.getString(2131362856))) {
      return 2131427999;
    }
    if (paramBoolean) {
      return 2131427945;
    }
    return 2131427942;
  }
  
  public static int a(Context paramContext, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 2130838906;
    if (paramInt == 13) {
      if (paramBoolean1)
      {
        paramInt = i;
        if (paramBoolean2) {
          paramInt = 2130838907;
        }
      }
    }
    do
    {
      return paramInt;
      if (paramBoolean2) {
        return 2130838691;
      }
      return 2130838690;
      if (paramString.contains(paramContext.getString(2131362857)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130838964;
          }
          return 2130838963;
        }
        if (paramBoolean2) {
          return 2130838691;
        }
        return 2130838690;
      }
      if (paramString.contains(paramContext.getString(2131362858)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130838964;
          }
          return 2130838963;
        }
        if (paramBoolean2) {
          return 2130838691;
        }
        return 2130838690;
      }
      if (paramString.contains(paramContext.getString(2131362856)))
      {
        if (paramBoolean1) {
          return 2130838962;
        }
        return 2130838689;
      }
      if (paramString.contains(paramContext.getString(2131362860)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130838964;
          }
          return 2130838963;
        }
        if (paramBoolean2) {
          return 2130838691;
        }
        return 2130838690;
      }
      if (paramString.contains(paramContext.getString(2131362855)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130838964;
          }
          return 2130838963;
        }
        if (paramBoolean2) {
          return 2130838691;
        }
        return 2130838690;
      }
      if (paramString.contains(paramContext.getString(2131362859)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130838964;
          }
          return 2130838963;
        }
        if (paramBoolean2) {
          return 2130838691;
        }
        return 2130838690;
      }
      if (paramString.contains(paramContext.getString(2131363150)))
      {
        if (paramBoolean1)
        {
          if (paramBoolean2) {
            return 2130838964;
          }
          return 2130838963;
        }
        if (paramBoolean2) {
          return 2130838691;
        }
        return 2130838690;
      }
      if (!paramBoolean1) {
        break;
      }
      paramInt = i;
    } while (!paramBoolean2);
    return 2130838907;
    if (paramBoolean2) {
      return 2130838691;
    }
    return 2130838690;
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    switch (paramInt1)
    {
    default: 
      return "";
    case 0: 
    case 9: 
    case 15: 
    case 48: 
    case 59: 
    case 62: 
    case 63: 
      if (paramString != null)
      {
        paramContext = paramContext.getString(2131362857);
        return paramContext + " " + paramString;
      }
      if (paramInt2 == 9500) {
        return paramContext.getString(2131363221);
      }
      return paramContext.getString(2131362858);
    case 2: 
    case 24: 
    case 47: 
      if (paramString != null)
      {
        paramContext = paramContext.getString(2131362857);
        return paramContext + " " + paramString;
      }
      if (paramBoolean)
      {
        if (paramInt2 == 9500) {
          return paramContext.getString(2131363221);
        }
        return paramContext.getString(2131362858);
      }
      if (paramInt2 == 9500) {
        return paramContext.getString(2131363222);
      }
      return paramContext.getString(2131362856);
    case 1: 
      if (paramInt2 == 9500) {
        return paramContext.getString(2131363222);
      }
      return paramContext.getString(2131362856);
    case 3: 
      return paramContext.getString(2131362860);
    case 10: 
      if (paramInt2 == 9500) {
        return paramContext.getString(2131363222);
      }
      return paramContext.getString(2131362856);
    case 7: 
      return paramContext.getString(2131362855);
    case 12: 
      if (paramBoolean)
      {
        if (paramInt2 == 9500) {
          return paramContext.getString(2131363223);
        }
        return paramContext.getString(2131363224);
      }
      if (paramInt2 == 9500) {
        return paramContext.getString(2131363222);
      }
      return paramContext.getString(2131362856);
    case 42: 
    case 43: 
      if (paramInt2 == 9500) {
        return paramContext.getString(2131363221);
      }
      return paramContext.getString(2131362858);
    case 49: 
      return paramContext.getString(2131363150);
    case 53: 
      return paramContext.getString(2131363152);
    }
    if (paramInt2 == 9500) {
      return paramContext.getString(2131363222);
    }
    return paramContext.getString(2131362856);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, QavMsgRecord paramQavMsgRecord, int paramInt, String paramString)
  {
    String str1 = a(BaseApplicationImpl.getContext(), paramQavMsgRecord.jdField_a_of_type_Int, 0, paramQavMsgRecord.c, paramString);
    String str2 = TransfileUtile.a(str1, paramQavMsgRecord.jdField_a_of_type_Int, 3, paramQavMsgRecord.jdField_a_of_type_Boolean);
    MessageRecord localMessageRecord = MessageRecordFactory.a(-2009);
    localMessageRecord.selfuin = paramQQAppInterface.a();
    localMessageRecord.frienduin = paramQavMsgRecord.jdField_b_of_type_JavaLangString;
    label138:
    long l;
    if (paramQavMsgRecord.c)
    {
      paramString = paramQavMsgRecord.jdField_a_of_type_JavaLangString;
      localMessageRecord.senderuin = paramString;
      localMessageRecord.msg = str2;
      localMessageRecord.msgtype = -2009;
      localMessageRecord.isread = paramQavMsgRecord.jdField_b_of_type_Boolean;
      if (paramInt == 0) {
        localMessageRecord.isread = true;
      }
      localMessageRecord.istroop = paramInt;
      localMessageRecord.extraflag = 3;
      if (!paramQavMsgRecord.c) {
        break label253;
      }
      localMessageRecord.issend = 1;
      paramString = (QCallFacade)paramQQAppInterface.getManager(37);
      if (paramString == null) {
        break label333;
      }
      paramString = paramString.a().a(paramQavMsgRecord.jdField_b_of_type_JavaLangString, paramInt);
      if (paramString == null) {
        break label333;
      }
      l = paramString.lastCallTime;
      if (QLog.isColorLevel()) {
        QLog.d("QCallFacade", 2, "VideoMsgTools updateDoubleCallStatus lastCallTime = " + paramString.lastCallTime);
      }
    }
    for (;;)
    {
      paramString = (QavStateManager)paramQQAppInterface.getManager(87);
      if (0L > 0L) {
        localMessageRecord.time = 0L;
      }
      for (;;)
      {
        ThreadManager.b(new cab(paramQQAppInterface, localMessageRecord));
        return;
        paramString = paramQavMsgRecord.jdField_b_of_type_JavaLangString;
        break;
        label253:
        localMessageRecord.issend = 0;
        break label138;
        if (str1.equals(paramQQAppInterface.a().getString(2131362856))) {
          localMessageRecord.time = MessageCache.a();
        } else if ((l > 0L) && (paramQavMsgRecord.jdField_a_of_type_Int != 7)) {
          localMessageRecord.time = MessageCache.a();
        } else {
          localMessageRecord.time = (MessageCache.a() - paramString.a());
        }
      }
      label333:
      l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools
 * JD-Core Version:    0.7.0.1
 */