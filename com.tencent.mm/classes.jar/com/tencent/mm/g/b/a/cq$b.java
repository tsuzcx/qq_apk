package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum cq$b
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128807);
    dcy = new b("sync", 0, 0);
    dcz = new b("async", 1, 1);
    dcA = new b[] { dcy, dcz };
    AppMethodBeat.o(128807);
  }
  
  private cq$b(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cq.b
 * JD-Core Version:    0.7.0.1
 */