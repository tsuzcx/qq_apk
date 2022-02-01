package com.tencent.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f
{
  public int value;
  
  static
  {
    AppMethodBeat.i(183140);
    JZE = new f("THROW", 0, -3);
    JZF = new f("ERROR", 1, -2);
    JZG = new f("CANCEL", 2, -1);
    JZH = new f("CREATED", 3, 0);
    JZI = new f("WAITING", 4, 1);
    JZJ = new f("RUNNING", 5, 2);
    JZK = new f("COMPLETE", 6, 3);
    JZL = new f[] { JZE, JZF, JZG, JZH, JZI, JZJ, JZK };
    AppMethodBeat.o(183140);
  }
  
  private f(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.f
 * JD-Core Version:    0.7.0.1
 */