package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.PriorityQueue;

public final class p
{
  public final PriorityQueue<Integer> bHs;
  public int bHt;
  public final Object lock;
  
  public final void xr()
  {
    AppMethodBeat.i(93193);
    synchronized (this.lock)
    {
      this.bHs.remove(Integer.valueOf(0));
      if (this.bHs.isEmpty())
      {
        i = -2147483648;
        this.bHt = i;
        this.lock.notifyAll();
        AppMethodBeat.o(93193);
        return;
      }
      int i = ((Integer)this.bHs.peek()).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.i.p
 * JD-Core Version:    0.7.0.1
 */