package com.tencent.device.msg.data;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.qphone.base.util.BaseApplication;

public class MessageForDevPtt
  extends MessageForPtt
{
  public long fileSessionId = 0L;
  
  public String getSummary()
  {
    Object localObject = BaseApplicationImpl.a().a();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (this.fileSize > 0L)
      {
        if (isSendFromLocal()) {
          return ((QQAppInterface)localObject).a().getString(2131368067);
        }
        return "一条语音消息";
      }
      if (this.fileSize == -1L)
      {
        if (isSendFromLocal()) {
          return ((QQAppInterface)localObject).a().getString(2131368067);
        }
        return "一条语音消息";
      }
      return "一条语音消息";
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.msg.data.MessageForDevPtt
 * JD-Core Version:    0.7.0.1
 */