package com.tencent.matrix.resource.d.a;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class a<T>
{
  public final AtomicReference<T> bPQ = new AtomicReference();
  public final CountDownLatch bPR = new CountDownLatch(1);
  
  public final boolean a(TimeUnit paramTimeUnit)
  {
    try
    {
      boolean bool = this.bPR.await(5L, paramTimeUnit);
      return bool;
    }
    catch (InterruptedException paramTimeUnit)
    {
      throw new RuntimeException("Did not expect thread to be interrupted", paramTimeUnit);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.resource.d.a.a
 * JD-Core Version:    0.7.0.1
 */