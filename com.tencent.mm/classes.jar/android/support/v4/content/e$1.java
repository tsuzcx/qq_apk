package android.support.v4.content;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class e$1
  implements ThreadFactory
{
  private final AtomicInteger mCount = new AtomicInteger(1);
  
  public final Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "ModernAsyncTask #" + this.mCount.getAndIncrement());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v4.content.e.1
 * JD-Core Version:    0.7.0.1
 */