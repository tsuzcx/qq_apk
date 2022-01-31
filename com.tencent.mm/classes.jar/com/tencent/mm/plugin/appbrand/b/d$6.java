package com.tencent.mm.plugin.appbrand.b;

import android.os.Looper;
import android.os.MessageQueue;

final class d$6
  implements Runnable
{
  d$6(d paramd) {}
  
  public final void run()
  {
    Looper.myQueue().addIdleHandler(new d.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.d.6
 * JD-Core Version:    0.7.0.1
 */