package midas.x;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class qd
{
  public static ThreadFactory a(String paramString)
  {
    return new a(paramString);
  }
  
  public static final class a
    implements ThreadFactory
  {
    public AtomicInteger a = new AtomicInteger(0);
    
    public a(String paramString) {}
    
    public Thread newThread(Runnable paramRunnable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Midas_IPThread-");
      localStringBuilder.append(this.b);
      localStringBuilder.append("-");
      localStringBuilder.append(this.a.getAndIncrement());
      paramRunnable = new Thread(paramRunnable, localStringBuilder.toString());
      paramRunnable.setPriority(10);
      paramRunnable.setDaemon(false);
      return paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.qd
 * JD-Core Version:    0.7.0.1
 */