package com.tencent.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f
{
  public int value;
  
  static
  {
    AppMethodBeat.i(183140);
    IxV = new f("THROW", 0, -3);
    IxW = new f("ERROR", 1, -2);
    IxX = new f("CANCEL", 2, -1);
    IxY = new f("CREATED", 3, 0);
    IxZ = new f("WAITING", 4, 1);
    Iya = new f("RUNNING", 5, 2);
    Iyb = new f("COMPLETE", 6, 3);
    Iyc = new f[] { IxV, IxW, IxX, IxY, IxZ, Iya, Iyb };
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