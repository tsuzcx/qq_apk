package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.QQDoyen;

public class QzoneMsgObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, QQDoyen paramQQDoyen) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    a(paramBoolean, (QQDoyen)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QzoneMsgObserver
 * JD-Core Version:    0.7.0.1
 */