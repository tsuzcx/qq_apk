package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.PriorityQueue;

public final class p
{
  public final PriorityQueue<Integer> bbe;
  public int bbf;
  public final Object lock;
  
  public final void ra()
  {
    AppMethodBeat.i(95931);
    synchronized (this.lock)
    {
      this.bbe.remove(Integer.valueOf(0));
      if (this.bbe.isEmpty())
      {
        i = -2147483648;
        this.bbf = i;
        this.lock.notifyAll();
        AppMethodBeat.o(95931);
        return;
      }
      int i = ((Integer)this.bbe.peek()).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.i.p
 * JD-Core Version:    0.7.0.1
 */