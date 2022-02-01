package com.tencent.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f
{
  public int value;
  
  static
  {
    AppMethodBeat.i(183140);
    RST = new f("THROW", 0, -3);
    RSU = new f("ERROR", 1, -2);
    RSV = new f("CANCEL", 2, -1);
    RSW = new f("CREATED", 3, 0);
    RSX = new f("WAITING", 4, 1);
    RSY = new f("RUNNING", 5, 2);
    RSZ = new f("COMPLETE", 6, 3);
    RTa = new f[] { RST, RSU, RSV, RSW, RSX, RSY, RSZ };
    AppMethodBeat.o(183140);
  }
  
  private f(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.f.f
 * JD-Core Version:    0.7.0.1
 */