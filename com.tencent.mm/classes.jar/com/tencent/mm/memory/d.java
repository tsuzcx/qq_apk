package com.tencent.mm.memory;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class d<T, S>
{
  protected Queue<T> fdC = new ConcurrentLinkedQueue();
  protected S fdD;
  
  public d(S paramS)
  {
    this.fdD = paramS;
  }
  
  public final S XK()
  {
    return this.fdD;
  }
  
  public final T pop()
  {
    return this.fdC.poll();
  }
  
  public final void put(T paramT)
  {
    this.fdC.add(paramT);
  }
  
  public final int size()
  {
    return this.fdC.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.memory.d
 * JD-Core Version:    0.7.0.1
 */