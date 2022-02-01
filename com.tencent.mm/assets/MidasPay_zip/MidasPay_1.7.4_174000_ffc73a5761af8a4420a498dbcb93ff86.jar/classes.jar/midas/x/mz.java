package midas.x;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class mz
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.mz
 * JD-Core Version:    0.7.0.1
 */