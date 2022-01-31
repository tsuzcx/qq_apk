package com.tencent.mm.plugin.appbrand.b;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;

final class d$6$1
  implements MessageQueue.IdleHandler
{
  d$6$1(d.6 param6) {}
  
  public final boolean queueIdle()
  {
    Looper.myLooper().quit();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.d.6.1
 * JD-Core Version:    0.7.0.1
 */