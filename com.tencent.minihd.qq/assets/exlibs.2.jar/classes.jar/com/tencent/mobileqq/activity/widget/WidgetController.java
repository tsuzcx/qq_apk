package com.tencent.mobileqq.activity.widget;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class WidgetController
  extends BusinessHandler
{
  public static final int a = 1000;
  public static final int b = 1001;
  public static final int c = 2000;
  
  public WidgetController(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class a()
  {
    return WidgetObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void a(String paramString)
  {
    if ("2909288299".equalsIgnoreCase(paramString)) {
      a(1001, true, null);
    }
    while (!"2010741172".equalsIgnoreCase(paramString)) {
      return;
    }
    a(1000, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.WidgetController
 * JD-Core Version:    0.7.0.1
 */