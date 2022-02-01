package com.tencent.mm.memory;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class d<T, S>
{
  protected Queue<T> hww = new ConcurrentLinkedQueue();
  protected S hwx;
  
  public d(S paramS)
  {
    this.hwx = paramS;
  }
  
  public final S ayx()
  {
    return this.hwx;
  }
  
  public final T pop()
  {
    return this.hww.poll();
  }
  
  public final void put(T paramT)
  {
    this.hww.add(paramT);
  }
  
  public final int size()
  {
    return this.hww.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.d
 * JD-Core Version:    0.7.0.1
 */