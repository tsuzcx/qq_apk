package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum sj$b
{
  final int value;
  
  static
  {
    AppMethodBeat.i(180155);
    jyj = new b("release", 0, 1);
    jyk = new b("debug", 1, 2);
    jyl = new b("demo", 2, 3);
    jym = new b[] { jyj, jyk, jyl };
    AppMethodBeat.o(180155);
  }
  
  private sj$b(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sj.b
 * JD-Core Version:    0.7.0.1
 */