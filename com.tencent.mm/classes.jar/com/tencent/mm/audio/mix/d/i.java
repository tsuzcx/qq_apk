package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class i
  implements Comparable<i>, Runnable
{
  private static int deO = 1000;
  protected long deP;
  protected String name;
  protected final int priority;
  
  public i(String paramString)
  {
    AppMethodBeat.i(136829);
    this.name = "";
    this.name = paramString;
    this.deP = System.currentTimeMillis();
    this.priority = 5;
    AppMethodBeat.o(136829);
  }
  
  public void reset() {}
  
  public void run()
  {
    AppMethodBeat.i(136830);
    AppMethodBeat.o(136830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.i
 * JD-Core Version:    0.7.0.1
 */