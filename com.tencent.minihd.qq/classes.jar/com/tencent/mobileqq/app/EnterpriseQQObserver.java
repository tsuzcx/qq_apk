package com.tencent.mobileqq.app;

public class EnterpriseQQObserver
  implements BusinessObserver
{
  public static final int a = 1;
  public static final int b = 2;
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramBoolean, paramObject);
      return;
    }
    b(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.EnterpriseQQObserver
 * JD-Core Version:    0.7.0.1
 */