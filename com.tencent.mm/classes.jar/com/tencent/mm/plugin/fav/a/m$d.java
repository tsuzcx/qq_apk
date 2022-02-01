package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum m$d
{
  private int value = 0;
  
  static
  {
    AppMethodBeat.i(103436);
    qaE = new d("Samll", 0, 1);
    qaF = new d("Full", 1, 2);
    qaG = new d("Complete", 2, 3);
    qaH = new d[] { qaE, qaF, qaG };
    AppMethodBeat.o(103436);
  }
  
  private m$d(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.m.d
 * JD-Core Version:    0.7.0.1
 */