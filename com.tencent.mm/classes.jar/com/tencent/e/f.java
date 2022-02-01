package com.tencent.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f
{
  public int value;
  
  static
  {
    AppMethodBeat.i(183140);
    Mqw = new f("THROW", 0, -3);
    Mqx = new f("ERROR", 1, -2);
    Mqy = new f("CANCEL", 2, -1);
    Mqz = new f("CREATED", 3, 0);
    MqA = new f("WAITING", 4, 1);
    MqB = new f("RUNNING", 5, 2);
    MqC = new f("COMPLETE", 6, 3);
    MqD = new f[] { Mqw, Mqx, Mqy, Mqz, MqA, MqB, MqC };
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