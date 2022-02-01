package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.PriorityQueue;

public final class p
{
  public final PriorityQueue<Integer> bHb;
  public int bHc;
  public final Object lock;
  
  public final void xj()
  {
    AppMethodBeat.i(93193);
    synchronized (this.lock)
    {
      this.bHb.remove(Integer.valueOf(0));
      if (this.bHb.isEmpty())
      {
        i = -2147483648;
        this.bHc = i;
        this.lock.notifyAll();
        AppMethodBeat.o(93193);
        return;
      }
      int i = ((Integer)this.bHb.peek()).intValue();
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