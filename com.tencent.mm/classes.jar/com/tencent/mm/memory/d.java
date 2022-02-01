package com.tencent.mm.memory;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class d<T, S>
{
  protected Queue<T> its = new ConcurrentLinkedQueue();
  protected S itt;
  
  public d(S paramS)
  {
    this.itt = paramS;
  }
  
  public final S aRS()
  {
    return this.itt;
  }
  
  public final T pop()
  {
    return this.its.poll();
  }
  
  public final void put(T paramT)
  {
    this.its.add(paramT);
  }
  
  public final int size()
  {
    return this.its.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.memory.d
 * JD-Core Version:    0.7.0.1
 */