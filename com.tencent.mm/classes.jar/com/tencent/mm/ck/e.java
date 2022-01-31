package com.tencent.mm.ck;

import com.tencent.mm.vending.h.d;

public final class e
  extends d
{
  public final void cancel() {}
  
  public final String getType()
  {
    return "WxNoLooperScheduler";
  }
  
  public final void j(Runnable paramRunnable, long paramLong)
  {
    paramRunnable.run();
  }
  
  public final void k(Runnable paramRunnable)
  {
    paramRunnable.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ck.e
 * JD-Core Version:    0.7.0.1
 */