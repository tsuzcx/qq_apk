package com.tencent.mobileqq.msf.core.net.a;

public abstract class a
  implements Runnable
{
  public static final int a = 0;
  public static final int b = -1;
  public static final int c = -2;
  public static final int d = -3;
  protected int e;
  protected a f;
  
  public a(int paramInt, a parama)
  {
    this.e = paramInt;
    this.f = parama;
  }
  
  protected abstract int a(String paramString);
  
  protected void a(int paramInt, String paramString)
  {
    b();
    if (this.f != null) {
      this.f.a(this.e, paramInt, paramString, d());
    }
  }
  
  protected abstract boolean a();
  
  protected abstract void b();
  
  protected abstract String c();
  
  protected abstract Object d();
  
  public void run()
  {
    if (!a())
    {
      a(-1, null);
      return;
    }
    String str = c();
    if (str == null)
    {
      a(-2, null);
      return;
    }
    a(a(str), str);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, String paramString, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.a
 * JD-Core Version:    0.7.0.1
 */