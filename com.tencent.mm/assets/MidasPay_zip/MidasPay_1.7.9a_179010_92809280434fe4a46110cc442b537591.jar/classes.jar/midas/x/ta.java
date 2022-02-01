package midas.x;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ta
{
  public ExecutorService a = a();
  
  public static ThreadFactory a(String paramString, final boolean paramBoolean)
  {
    return new a(paramString, paramBoolean);
  }
  
  public final ExecutorService a()
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
  
  public void a(ua paramua)
  {
    if (paramua == null) {
      return;
    }
    try
    {
      this.a.execute(paramua);
      return;
    }
    finally
    {
      paramua = finally;
      throw paramua;
    }
  }
  
  public static final class a
    implements ThreadFactory
  {
    public AtomicInteger a = new AtomicInteger(0);
    
    public a(String paramString, boolean paramBoolean) {}
    
    public Thread newThread(Runnable paramRunnable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.a.getAndIncrement());
      paramRunnable = new Thread(paramRunnable, localStringBuilder.toString());
      paramRunnable.setPriority(10);
      paramRunnable.setDaemon(paramBoolean);
      return paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.ta
 * JD-Core Version:    0.7.0.1
 */