package com.tencent.mm.memory;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class d<T, S>
{
  protected Queue<T> dOV = new ConcurrentLinkedQueue();
  protected S dOW;
  
  public d(S paramS)
  {
    this.dOW = paramS;
  }
  
  public final S EU()
  {
    return this.dOW;
  }
  
  public final T pop()
  {
    return this.dOV.poll();
  }
  
  public final void put(T paramT)
  {
    this.dOV.add(paramT);
  }
  
  public final int size()
  {
    return this.dOV.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.memory.d
 * JD-Core Version:    0.7.0.1
 */