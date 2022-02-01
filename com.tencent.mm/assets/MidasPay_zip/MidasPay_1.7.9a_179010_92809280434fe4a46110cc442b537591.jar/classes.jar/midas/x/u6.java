package midas.x;

import android.os.Handler;

public class u6
{
  public long a;
  public long b;
  public long c;
  public long d;
  public boolean e = false;
  public Handler f = new Handler();
  public b g;
  public Runnable h = new a();
  
  public u6(long paramLong1, long paramLong2, long paramLong3, b paramb)
  {
    this.g = paramb;
    this.b = paramLong1;
    this.c = paramLong2;
    this.a = paramLong3;
    this.d = 0L;
    a();
  }
  
  public void a()
  {
    this.d = 0L;
    this.e = false;
  }
  
  public void b()
  {
    this.e = true;
    if (this.d >= this.b - this.c) {
      a();
    }
    this.f.post(this.h);
  }
  
  public void c()
  {
    this.e = false;
    this.f.removeCallbacksAndMessages(null);
  }
  
  public class a
    implements Runnable
  {
    public a() {}
    
    public void run()
    {
      u6.b(u6.this);
      if (!u6.c(u6.this))
      {
        u6.g(u6.this).a(u6.d(u6.this), u6.a(u6.this), u6.e(u6.this), u6.f(u6.this));
        u6.this.f.removeCallbacksAndMessages(null);
        return;
      }
      if (u6.a(u6.this) >= u6.d(u6.this) - u6.e(u6.this))
      {
        u6.g(u6.this).b(u6.d(u6.this), u6.a(u6.this), u6.e(u6.this), u6.f(u6.this));
        u6.this.f.removeCallbacksAndMessages(null);
        return;
      }
      u6.g(u6.this).c(u6.d(u6.this), u6.a(u6.this), u6.e(u6.this), u6.f(u6.this));
      u6 localu6 = u6.this;
      localu6.f.postDelayed(localu6.h, u6.f(localu6) * 1000L);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
    
    public abstract void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
    
    public abstract void c(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.u6
 * JD-Core Version:    0.7.0.1
 */