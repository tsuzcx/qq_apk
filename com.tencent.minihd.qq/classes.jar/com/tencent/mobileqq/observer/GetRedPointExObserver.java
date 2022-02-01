package com.tencent.mobileqq.observer;

import com.tencent.mobileqq.app.BusinessObserver;

public abstract class GetRedPointExObserver
  implements BusinessObserver
{
  public void a() {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((105 == paramInt) && (paramBoolean)) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.observer.GetRedPointExObserver
 * JD-Core Version:    0.7.0.1
 */