package com.tencent.mm.memory;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class d<T, S>
{
  protected Queue<T> gDN = new ConcurrentLinkedQueue();
  protected S gDO;
  
  public d(S paramS)
  {
    this.gDO = paramS;
  }
  
  public final S aoT()
  {
    return this.gDO;
  }
  
  public final T pop()
  {
    return this.gDN.poll();
  }
  
  public final void put(T paramT)
  {
    this.gDN.add(paramT);
  }
  
  public final int size()
  {
    return this.gDN.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.d
 * JD-Core Version:    0.7.0.1
 */