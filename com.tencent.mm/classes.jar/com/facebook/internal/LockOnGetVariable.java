package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

public class LockOnGetVariable<T>
{
  private CountDownLatch initLatch;
  private T value;
  
  public LockOnGetVariable(T paramT)
  {
    this.value = paramT;
  }
  
  public LockOnGetVariable(final Callable<T> paramCallable)
  {
    AppMethodBeat.i(17838);
    this.initLatch = new CountDownLatch(1);
    FacebookSdk.getExecutor().execute(new FutureTask(new Callable()
    {
      public Void call()
      {
        AppMethodBeat.i(17836);
        try
        {
          LockOnGetVariable.access$002(LockOnGetVariable.this, paramCallable.call());
          return null;
        }
        finally
        {
          LockOnGetVariable.this.initLatch.countDown();
          AppMethodBeat.o(17836);
        }
      }
    }));
    AppMethodBeat.o(17838);
  }
  
  private void waitOnInit()
  {
    AppMethodBeat.i(17840);
    if (this.initLatch == null)
    {
      AppMethodBeat.o(17840);
      return;
    }
    try
    {
      this.initLatch.await();
      AppMethodBeat.o(17840);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      AppMethodBeat.o(17840);
    }
  }
  
  public T getValue()
  {
    AppMethodBeat.i(17839);
    waitOnInit();
    Object localObject = this.value;
    AppMethodBeat.o(17839);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.internal.LockOnGetVariable
 * JD-Core Version:    0.7.0.1
 */