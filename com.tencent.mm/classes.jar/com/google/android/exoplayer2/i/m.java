package com.google.android.exoplayer2.i;

import java.util.PriorityQueue;

public final class m
{
  public final PriorityQueue<Integer> aSD;
  public int aSE;
  public final Object lock;
  
  public final void oo()
  {
    synchronized (this.lock)
    {
      this.aSD.remove(Integer.valueOf(0));
      if (this.aSD.isEmpty())
      {
        i = -2147483648;
        this.aSE = i;
        this.lock.notifyAll();
        return;
      }
      int i = ((Integer)this.aSD.peek()).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.i.m
 * JD-Core Version:    0.7.0.1
 */