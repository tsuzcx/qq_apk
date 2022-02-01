package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.PriorityQueue;

public final class p
{
  public final PriorityQueue<Integer> bzf;
  public int bzg;
  public final Object lock;
  
  public final void vX()
  {
    AppMethodBeat.i(93193);
    synchronized (this.lock)
    {
      this.bzf.remove(Integer.valueOf(0));
      if (this.bzf.isEmpty())
      {
        i = -2147483648;
        this.bzg = i;
        this.lock.notifyAll();
        AppMethodBeat.o(93193);
        return;
      }
      int i = ((Integer)this.bzf.peek()).intValue();
    }
  }
  
  public static final class a
    extends IOException
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i.p
 * JD-Core Version:    0.7.0.1
 */