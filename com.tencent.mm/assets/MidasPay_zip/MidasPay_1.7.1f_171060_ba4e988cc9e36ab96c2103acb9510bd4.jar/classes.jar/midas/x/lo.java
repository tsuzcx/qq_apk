package midas.x;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class lo
{
  public static ThreadFactory a(String paramString)
  {
    new ThreadFactory()
    {
      private AtomicInteger b = new AtomicInteger(0);
      
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Midas_IPThread-");
        localStringBuilder.append(this.a);
        localStringBuilder.append("-");
        localStringBuilder.append(this.b.getAndIncrement());
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable, localStringBuilder.toString());
        paramAnonymousRunnable.setPriority(10);
        paramAnonymousRunnable.setDaemon(false);
        return paramAnonymousRunnable;
      }
    };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.lo
 * JD-Core Version:    0.7.0.1
 */