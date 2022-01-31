package com.tencent.mm.plugin.appbrand;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;

final class i$13
  implements MessageQueue.IdleHandler
{
  i$13(i parami, Runnable paramRunnable) {}
  
  public final boolean queueIdle()
  {
    Looper.myQueue().removeIdleHandler(this);
    try
    {
      this.fyU.run();
      label16:
      return false;
    }
    catch (Exception localException)
    {
      break label16;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.13
 * JD-Core Version:    0.7.0.1
 */