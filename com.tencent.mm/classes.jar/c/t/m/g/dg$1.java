package c.t.m.g;

import java.util.concurrent.ThreadFactory;

final class dg$1
  implements ThreadFactory
{
  public final Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "network_request_pool");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     c.t.m.g.dg.1
 * JD-Core Version:    0.7.0.1
 */