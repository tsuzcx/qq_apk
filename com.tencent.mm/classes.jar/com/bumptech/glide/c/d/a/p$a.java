package com.bumptech.glide.c.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

final class p$a
  implements Lock
{
  public final void lock() {}
  
  public final void lockInterruptibly() {}
  
  public final Condition newCondition()
  {
    AppMethodBeat.i(77434);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Should not be called");
    AppMethodBeat.o(77434);
    throw localUnsupportedOperationException;
  }
  
  public final boolean tryLock()
  {
    return true;
  }
  
  public final boolean tryLock(long paramLong, TimeUnit paramTimeUnit)
  {
    return true;
  }
  
  public final void unlock() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.bumptech.glide.c.d.a.p.a
 * JD-Core Version:    0.7.0.1
 */