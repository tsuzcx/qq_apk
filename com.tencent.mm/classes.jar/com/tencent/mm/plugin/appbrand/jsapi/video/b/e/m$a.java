package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import java.util.concurrent.FutureTask;

final class m$a<T>
  extends FutureTask<T>
  implements Comparable<a<T>>
{
  volatile long kSB = 0L;
  
  public m$a(Runnable paramRunnable, long paramLong)
  {
    super(paramRunnable, null);
    this.kSB = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.e.m.a
 * JD-Core Version:    0.7.0.1
 */