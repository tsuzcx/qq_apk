package com.tencent.mobileqq.app.proxy;

public class ProxyObserver
{
  public static final int a = -1;
  public static final int b = 1000;
  public static final int c = 1001;
  public static final int d = 2000;
  public static final int e = 2001;
  
  public void a() {}
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1000: 
      a();
      return;
    }
    b();
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.ProxyObserver
 * JD-Core Version:    0.7.0.1
 */