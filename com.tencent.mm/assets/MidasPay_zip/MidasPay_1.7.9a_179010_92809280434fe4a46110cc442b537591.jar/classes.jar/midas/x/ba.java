package midas.x;

import android.os.Handler;

public class ba
  implements u9.d
{
  public volatile long a;
  public volatile long b = 64L;
  public Handler c;
  public a d;
  
  public ba(Handler paramHandler)
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
  
  public void a(Runnable paramRunnable)
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
  
  public boolean b(Runnable paramRunnable)
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
      ca.a("DefaultRetryer", localStringBuilder.toString());
      this.c.postDelayed(paramRunnable, this.d.a() * 1000L);
      return true;
    }
    finally {}
  }
  
  public class a
  {
    public int a;
    public int b;
    public int c;
    
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
      int i = this.a;
      int j = this.b + i;
      if (j > this.c) {
        return i;
      }
      this.b = i;
      this.a = j;
      return this.a;
    }
    
    public void b()
    {
      this.a = 0;
      this.b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.ba
 * JD-Core Version:    0.7.0.1
 */