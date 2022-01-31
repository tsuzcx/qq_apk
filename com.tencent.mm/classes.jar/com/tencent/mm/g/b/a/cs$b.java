package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum cs$b
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128837);
    dcV = new b("sync", 0, 0);
    dcW = new b("async", 1, 1);
    dcX = new b[] { dcV, dcW };
    AppMethodBeat.o(128837);
  }
  
  private cs$b(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cs.b
 * JD-Core Version:    0.7.0.1
 */