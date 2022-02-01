package midas.x;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class k6
{
  public static volatile k6 b;
  public ScheduledExecutorService a = null;
  
  public static k6 b()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new k6();
        }
      }
      finally {}
    }
    return b;
  }
  
  public static ThreadFactory c()
  {
    return new a();
  }
  
  public void a()
  {
    b().a.shutdown();
    b().a = null;
    b = null;
  }
  
  public static final class a
    implements ThreadFactory
  {
    public AtomicInteger a = new AtomicInteger(0);
    
    public Thread newThread(Runnable paramRunnable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Midas_WorkThread-");
      localStringBuilder.append(this.a.getAndIncrement());
      paramRunnable = new Thread(paramRunnable, localStringBuilder.toString());
      paramRunnable.setPriority(10);
      paramRunnable.setDaemon(false);
      return paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.k6
 * JD-Core Version:    0.7.0.1
 */