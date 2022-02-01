package com.tencent.mobileqq.activity.widget;

import com.tencent.mobileqq.app.BusinessObserver;

public class WidgetObserver
  implements BusinessObserver
{
  public void a() {}
  
  protected void a(String paramString) {}
  
  public void b() {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1000: 
      a();
      return;
    case 1001: 
      b();
      return;
    }
    a((String)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.WidgetObserver
 * JD-Core Version:    0.7.0.1
 */