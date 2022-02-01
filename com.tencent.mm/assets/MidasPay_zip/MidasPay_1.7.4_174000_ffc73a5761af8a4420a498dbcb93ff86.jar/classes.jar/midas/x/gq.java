package midas.x;

import android.os.Handler;

public class gq
{
  Handler a = new Handler();
  Runnable b = new Runnable()
  {
    public void run()
    {
      gq.a(gq.this);
      if (!gq.b(gq.this))
      {
        gq.g(gq.this).b(gq.c(gq.this), gq.d(gq.this), gq.e(gq.this), gq.f(gq.this));
        gq.this.a.removeCallbacksAndMessages(null);
        return;
      }
      if (gq.d(gq.this) >= gq.c(gq.this) - gq.e(gq.this))
      {
        gq.g(gq.this).c(gq.c(gq.this), gq.d(gq.this), gq.e(gq.this), gq.f(gq.this));
        gq.this.a.removeCallbacksAndMessages(null);
        return;
      }
      gq.g(gq.this).a(gq.c(gq.this), gq.d(gq.this), gq.e(gq.this), gq.f(gq.this));
      gq.this.a.postDelayed(gq.this.b, gq.f(gq.this) * 1000L);
    }
  };
  private long c;
  private long d;
  private long e;
  private long f;
  private boolean g = false;
  private a h;
  
  public gq(long paramLong1, long paramLong2, long paramLong3, a parama)
  {
    this.h = parama;
    this.d = paramLong1;
    this.e = paramLong2;
    this.c = paramLong3;
    this.f = 0L;
    c();
  }
  
  public void a()
  {
    this.g = true;
    if (this.f >= this.d - this.e) {
      c();
    }
    this.a.post(this.b);
  }
  
  public void b()
  {
    this.g = false;
    this.a.removeCallbacksAndMessages(null);
  }
  
  public void c()
  {
    this.f = 0L;
    this.g = false;
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
    
    public abstract void b(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
    
    public abstract void c(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.gq
 * JD-Core Version:    0.7.0.1
 */