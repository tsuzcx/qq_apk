package com.tencent.mm.memory;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class d<T, S>
{
  protected Queue<T> hzk = new ConcurrentLinkedQueue();
  protected S hzl;
  
  public d(S paramS)
  {
    this.hzl = paramS;
  }
  
  public final S ayM()
  {
    return this.hzl;
  }
  
  public final T pop()
  {
    return this.hzk.poll();
  }
  
  public final void put(T paramT)
  {
    this.hzk.add(paramT);
  }
  
  public final int size()
  {
    return this.hzk.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.d
 * JD-Core Version:    0.7.0.1
 */