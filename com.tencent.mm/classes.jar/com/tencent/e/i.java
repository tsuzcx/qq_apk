package com.tencent.e;

import com.tencent.e.i.d;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public abstract interface i
{
  public abstract b a(String paramString, int paramInt1, int paramInt2, BlockingQueue<Runnable> paramBlockingQueue);
  
  public abstract d<?> a(Runnable paramRunnable, long paramLong1, long paramLong2);
  
  public abstract d<?> a(Runnable paramRunnable, long paramLong, String paramString);
  
  public abstract <T> d<T> a(Callable<T> paramCallable, String paramString);
  
  public abstract d<?> aM(Runnable paramRunnable);
  
  public abstract d<?> aN(Runnable paramRunnable);
  
  public abstract d<?> aO(Runnable paramRunnable);
  
  public abstract d<?> aP(Runnable paramRunnable);
  
  public abstract d<?> aQ(Runnable paramRunnable);
  
  public abstract d<?> aR(Runnable paramRunnable);
  
  public abstract d<?> b(Runnable paramRunnable, long paramLong, String paramString);
  
  public abstract boolean bbc(String paramString);
  
  public abstract b bbd(String paramString);
  
  public abstract <T> d<T> d(Callable<T> paramCallable);
  
  public abstract d<?> f(Runnable paramRunnable, String paramString);
  
  public abstract boolean fZV();
  
  public abstract a fZW();
  
  public abstract d<?> g(Runnable paramRunnable, String paramString);
  
  public abstract d<?> h(Runnable paramRunnable, String paramString);
  
  public abstract d<?> i(Runnable paramRunnable, String paramString);
  
  public abstract boolean isShutdown();
  
  public abstract d<?> q(Runnable paramRunnable, long paramLong);
  
  public abstract d<?> r(Runnable paramRunnable, long paramLong);
  
  public abstract d<?> s(Runnable paramRunnable, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.i
 * JD-Core Version:    0.7.0.1
 */