package com.tencent.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f
{
  public int value;
  
  static
  {
    AppMethodBeat.i(183140);
    Zvx = new f("THROW", 0, -3);
    Zvy = new f("ERROR", 1, -2);
    Zvz = new f("CANCEL", 2, -1);
    ZvA = new f("CREATED", 3, 0);
    ZvB = new f("WAITING", 4, 1);
    ZvC = new f("RUNNING", 5, 2);
    ZvD = new f("COMPLETE", 6, 3);
    ZvE = new f[] { Zvx, Zvy, Zvz, ZvA, ZvB, ZvC, ZvD };
    AppMethodBeat.o(183140);
  }
  
  private f(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.e.f
 * JD-Core Version:    0.7.0.1
 */