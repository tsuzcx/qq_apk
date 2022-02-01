package com.tencent.mm.memory;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class d<T, S>
{
  protected Queue<T> nNl = new ConcurrentLinkedQueue();
  protected S nNm;
  
  public d(S paramS)
  {
    this.nNm = paramS;
  }
  
  public final S bvH()
  {
    return this.nNm;
  }
  
  public final T pop()
  {
    return this.nNl.poll();
  }
  
  public final void put(T paramT)
  {
    this.nNl.add(paramT);
  }
  
  public final int size()
  {
    return this.nNl.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.d
 * JD-Core Version:    0.7.0.1
 */