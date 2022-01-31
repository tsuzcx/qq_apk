package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum dd$d
{
  final int value;
  
  static
  {
    AppMethodBeat.i(51107);
    deN = new d("DEFAULT", 0, 0);
    deO = new d("DOING", 1, 1);
    deP = new d("DONE", 2, 2);
    deQ = new d[] { deN, deO, deP };
    AppMethodBeat.o(51107);
  }
  
  private dd$d(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dd.d
 * JD-Core Version:    0.7.0.1
 */