package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class i
  implements Comparable<i>, Runnable
{
  private static int cgc = 1000;
  protected long cgd;
  protected String name;
  protected final int priority;
  
  public i(String paramString)
  {
    AppMethodBeat.i(137081);
    this.name = "";
    this.name = paramString;
    this.cgd = System.currentTimeMillis();
    this.priority = 5;
    AppMethodBeat.o(137081);
  }
  
  public void reset() {}
  
  public void run() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.audio.mix.d.i
 * JD-Core Version:    0.7.0.1
 */