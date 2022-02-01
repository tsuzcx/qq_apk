package com.tencent.mm.memory;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class d<T, S>
{
  protected Queue<T> heo = new ConcurrentLinkedQueue();
  protected S hep;
  
  public d(S paramS)
  {
    this.hep = paramS;
  }
  
  public final S avK()
  {
    return this.hep;
  }
  
  public final T pop()
  {
    return this.heo.poll();
  }
  
  public final void put(T paramT)
  {
    this.heo.add(paramT);
  }
  
  public final int size()
  {
    return this.heo.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.d
 * JD-Core Version:    0.7.0.1
 */