package com.tencent.mobileqq.app;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;

public class CardPayHandler
  extends BusinessHandler
{
  public CardPayHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class a()
  {
    return CardPayObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = -1;
    if ("CardPayControl.queryChannel".equals(paramToServiceMsg.getServiceCmd())) {
      i = 0;
    }
    for (;;)
    {
      a(i, paramFromServiceMsg.isSuccess(), paramObject);
      return;
      if ("CardPayControl.queryPayOrder".equals(paramToServiceMsg.getServiceCmd())) {
        i = 1;
      } else if ("CardPayControl.queryOrderIndex".equals(paramToServiceMsg.getServiceCmd())) {
        i = 2;
      } else if ("CardPayControl.queryOrderDetail".equals(paramToServiceMsg.getServiceCmd())) {
        i = 3;
      }
    }
  }
  
  public void a(String paramString, HashMap paramHashMap)
  {
    paramString = new ToServiceMsg("mobileqq.service", this.a.a(), paramString);
    paramString.setAttributes(paramHashMap);
    a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.CardPayHandler
 * JD-Core Version:    0.7.0.1
 */