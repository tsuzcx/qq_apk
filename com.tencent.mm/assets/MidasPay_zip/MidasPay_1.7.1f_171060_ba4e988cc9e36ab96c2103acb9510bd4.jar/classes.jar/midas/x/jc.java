package midas.x;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class jc
{
  private ExecutorService a = a();
  
  private ExecutorService a()
  {
    try
    {
      if (this.a == null) {
        this.a = Executors.newFixedThreadPool(5, a("Network Thread", false));
      }
      ExecutorService localExecutorService = this.a;
      return localExecutorService;
    }
    finally {}
  }
  
  private static ThreadFactory a(String paramString, final boolean paramBoolean)
  {
    new ThreadFactory()
    {
      private AtomicInteger c = new AtomicInteger(0);
      
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a);
        localStringBuilder.append(" ");
        localStringBuilder.append(this.c.getAndIncrement());
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable, localStringBuilder.toString());
        paramAnonymousRunnable.setPriority(10);
        paramAnonymousRunnable.setDaemon(paramBoolean);
        return paramAnonymousRunnable;
      }
    };
  }
  
  public void a(jd paramjd)
  {
    if (paramjd == null) {
      return;
    }
    try
    {
      this.a.execute(paramjd);
      return;
    }
    finally
    {
      paramjd = finally;
      throw paramjd;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.jc
 * JD-Core Version:    0.7.0.1
 */