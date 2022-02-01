package com.tencent.mobileqq.msf.core.net.a;

public abstract class m
{
  protected g[] f = { new h("https://3gimg.qq.com/qq_product_operations/nettest/index.html", "MobileQQ1"), new h("https://3gimg.qq.com/qq_product_operations/nettest/index2.html", "MobileQQ2") };
  
  protected a a(g paramg, int paramInt, a.a parama)
  {
    switch (paramg.d)
    {
    case 0: 
    case 1: 
    default: 
      return null;
    }
    return new b(paramInt, ((h)paramg).f, paramg.e, 10000, parama);
  }
  
  public abstract void a();
  
  public abstract void a(String paramString);
  
  public abstract void b();
  
  public abstract void b(String paramString);
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.m
 * JD-Core Version:    0.7.0.1
 */