package com.tencent.f;

import com.tencent.f.i.d;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public abstract interface i
{
  public abstract b a(String paramString, int paramInt1, int paramInt2, BlockingQueue<Runnable> paramBlockingQueue);
  
  public abstract d<?> a(Runnable paramRunnable, long paramLong1, long paramLong2);
  
  public abstract d<?> a(Runnable paramRunnable, long paramLong, String paramString);
  
  public abstract <T> d<T> a(Callable<T> paramCallable, String paramString);
  
  public abstract d<?> aV(Runnable paramRunnable);
  
  public abstract d<?> aW(Runnable paramRunnable);
  
  public abstract d<?> aX(Runnable paramRunnable);
  
  public abstract d<?> aY(Runnable paramRunnable);
  
  public abstract d<?> aZ(Runnable paramRunnable);
  
  public abstract d<?> b(Runnable paramRunnable, long paramLong, String paramString);
  
  public abstract d<?> b(Runnable paramRunnable, String paramString);
  
  public abstract d<?> ba(Runnable paramRunnable);
  
  public abstract boolean bqo(String paramString);
  
  public abstract b bqp(String paramString);
  
  public abstract d<?> c(Runnable paramRunnable, String paramString);
  
  public abstract d<?> d(Runnable paramRunnable, String paramString);
  
  public abstract <T> d<T> d(Callable<T> paramCallable);
  
  public abstract d<?> e(Runnable paramRunnable, String paramString);
  
  public abstract boolean hmg();
  
  public abstract a hmh();
  
  public abstract boolean isShutdown();
  
  public abstract d<?> n(Runnable paramRunnable, long paramLong);
  
  public abstract d<?> o(Runnable paramRunnable, long paramLong);
  
  public abstract d<?> p(Runnable paramRunnable, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.f.i
 * JD-Core Version:    0.7.0.1
 */