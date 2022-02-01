package midas.x;

import android.os.Handler;

public class jv
  implements jo.c
{
  private volatile long a;
  private volatile long b = 64L;
  private Handler c;
  private a d;
  
  public jv(Handler paramHandler)
  {
    if (paramHandler != null)
    {
      this.c = paramHandler;
      this.d = new a(15);
      this.a = 0L;
      return;
    }
    throw new IllegalArgumentException("handler is Null");
  }
  
  public boolean a(Runnable paramRunnable)
  {
    try
    {
      this.a += 1L;
      if (this.b > 0L)
      {
        long l1 = this.a;
        long l2 = this.b;
        if (l1 > l2) {
          return false;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("retry() mRetryCount.next = ");
      localStringBuilder.append(this.a);
      jw.b("DefaultRetryer", localStringBuilder.toString());
      this.c.postDelayed(paramRunnable, this.d.a() * 1000L);
      return true;
    }
    finally {}
  }
  
  public void b(Runnable paramRunnable)
  {
    try
    {
      this.c.removeCallbacks(paramRunnable);
      this.d = new a(15);
      this.a = 0L;
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
  
  class a
  {
    int a;
    int b;
    int c;
    
    public a(int paramInt)
    {
      b();
      this.c = paramInt;
    }
    
    public int a()
    {
      if ((this.a == 0) && (this.b == 0))
      {
        this.a = 1;
        return 0;
      }
      int i = this.a + this.b;
      if (i > this.c) {
        return this.a;
      }
      this.b = this.a;
      this.a = i;
      return this.a;
    }
    
    public void b()
    {
      this.a = 0;
      this.b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.jv
 * JD-Core Version:    0.7.0.1
 */