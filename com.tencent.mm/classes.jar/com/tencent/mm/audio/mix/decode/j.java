package com.tencent.mm.audio.mix.decode;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class j
  implements Comparable<j>, Runnable
{
  private static int hsJ = 1000;
  protected long addTime;
  protected String name;
  protected final int priority;
  
  public j(String paramString)
  {
    AppMethodBeat.i(136829);
    this.name = "";
    this.name = paramString;
    this.addTime = System.currentTimeMillis();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.decode.j
 * JD-Core Version:    0.7.0.1
 */