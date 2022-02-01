package com.tencent.e.h;

import com.tencent.e.i.k;
import java.util.concurrent.Future;

public abstract interface d
{
  public abstract String getName();
  
  public abstract <V> Future<V> h(k<V> paramk);
  
  public abstract boolean isShutdown();
  
  public abstract void j(k<?> paramk);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.h.d
 * JD-Core Version:    0.7.0.1
 */