package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

class LockOnGetVariable$1
  implements Callable<Void>
{
  LockOnGetVariable$1(LockOnGetVariable paramLockOnGetVariable, Callable paramCallable) {}
  
  public Void call()
  {
    AppMethodBeat.i(72400);
    try
    {
      LockOnGetVariable.access$002(this.this$0, this.val$callable.call());
      return null;
    }
    finally
    {
      LockOnGetVariable.access$100(this.this$0).countDown();
      AppMethodBeat.o(72400);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.internal.LockOnGetVariable.1
 * JD-Core Version:    0.7.0.1
 */