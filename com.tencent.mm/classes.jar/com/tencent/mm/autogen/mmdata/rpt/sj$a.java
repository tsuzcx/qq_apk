package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum sj$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(180152);
    jyf = new a("release", 0, 1);
    jyg = new a("debug", 1, 2);
    jyh = new a("demo", 2, 3);
    jyi = new a[] { jyf, jyg, jyh };
    AppMethodBeat.o(180152);
  }
  
  private sj$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oE(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return jyf;
    case 2: 
      return jyg;
    }
    return jyh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sj.a
 * JD-Core Version:    0.7.0.1
 */