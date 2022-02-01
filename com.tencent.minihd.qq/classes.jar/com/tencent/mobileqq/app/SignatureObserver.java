package com.tencent.mobileqq.app;

public class SignatureObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void c(boolean paramBoolean, Object paramObject) {}
  
  public void d(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      return;
    case 7: 
      b(paramBoolean, paramObject);
      return;
    case 5: 
      c(paramBoolean, paramObject);
      return;
    case 6: 
      a(paramBoolean, paramObject);
      return;
    }
    d(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureObserver
 * JD-Core Version:    0.7.0.1
 */