package midas.x;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class fw
{
  private static volatile fw b;
  public ScheduledExecutorService a = null;
  
  public static fw a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new fw();
        }
      }
      finally {}
    }
    return b;
  }
  
  private static ThreadFactory c()
  {
    new ThreadFactory()
    {
      private AtomicInteger a = new AtomicInteger(0);
      
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Midas_WorkThread-");
        localStringBuilder.append(this.a.getAndIncrement());
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable, localStringBuilder.toString());
        paramAnonymousRunnable.setPriority(10);
        paramAnonymousRunnable.setDaemon(false);
        return paramAnonymousRunnable;
      }
    };
  }
  
  public void b()
  {
    a().a.shutdown();
    a().a = null;
    b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.fw
 * JD-Core Version:    0.7.0.1
 */