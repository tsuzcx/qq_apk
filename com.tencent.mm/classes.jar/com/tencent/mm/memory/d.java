package com.tencent.mm.memory;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class d<T, S>
{
  protected Queue<T> liA = new ConcurrentLinkedQueue();
  protected S liB;
  
  public d(S paramS)
  {
    this.liB = paramS;
  }
  
  public final S baM()
  {
    return this.liB;
  }
  
  public final T pop()
  {
    return this.liA.poll();
  }
  
  public final void put(T paramT)
  {
    this.liA.add(paramT);
  }
  
  public final int size()
  {
    return this.liA.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.d
 * JD-Core Version:    0.7.0.1
 */