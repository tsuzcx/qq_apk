package com.google.android.exoplayer2.b;

final class g$1
  extends Thread
{
  g$1(g paramg) {}
  
  public final void run()
  {
    g localg = this.ayP;
    try
    {
      boolean bool;
      do
      {
        bool = localg.lK();
      } while (bool);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new IllegalStateException(localInterruptedException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.b.g.1
 * JD-Core Version:    0.7.0.1
 */