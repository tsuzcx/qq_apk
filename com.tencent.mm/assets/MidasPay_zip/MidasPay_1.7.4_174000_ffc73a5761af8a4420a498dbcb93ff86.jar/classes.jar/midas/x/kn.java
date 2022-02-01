package midas.x;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class kn
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
  
  public void a(ko paramko)
  {
    if (paramko == null) {
      return;
    }
    try
    {
      this.a.execute(paramko);
      return;
    }
    finally
    {
      paramko = finally;
      throw paramko;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.kn
 * JD-Core Version:    0.7.0.1
 */