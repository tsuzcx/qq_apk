package com.tencent.mobileqq.app;

public class QvipSpecialCareObserver
  implements BusinessObserver
{
  public void onSendErrorEvent(Object paramObject) {}
  
  public void onSpecialSoundEvent(Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1000: 
      onSpecialSoundEvent(paramObject);
      return;
    }
    onSendErrorEvent(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QvipSpecialCareObserver
 * JD-Core Version:    0.7.0.1
 */