package com.tencent.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f
{
  public int value;
  
  static
  {
    AppMethodBeat.i(183140);
    LTz = new f("THROW", 0, -3);
    LTA = new f("ERROR", 1, -2);
    LTB = new f("CANCEL", 2, -1);
    LTC = new f("CREATED", 3, 0);
    LTD = new f("WAITING", 4, 1);
    LTF = new f("RUNNING", 5, 2);
    LTG = new f("COMPLETE", 6, 3);
    LTH = new f[] { LTz, LTA, LTB, LTC, LTD, LTF, LTG };
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