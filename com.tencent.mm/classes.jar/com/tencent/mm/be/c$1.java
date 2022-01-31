package com.tencent.mm.be;

import android.os.Looper;
import android.os.MessageQueue;

public final class c$1
  implements Runnable
{
  public c$1(c paramc) {}
  
  public final void run()
  {
    Looper.myQueue().addIdleHandler(new c.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.be.c.1
 * JD-Core Version:    0.7.0.1
 */