package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum qo$c
{
  final int value;
  
  static
  {
    AppMethodBeat.i(2595);
    hlc = new c("DEFAULT", 0, 0);
    hld = new c("YES", 1, 1);
    hle = new c("NO", 2, 2);
    hlf = new c[] { hlc, hld, hle };
    AppMethodBeat.o(2595);
  }
  
  private qo$c(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.qo.c
 * JD-Core Version:    0.7.0.1
 */