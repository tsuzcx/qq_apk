package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum so$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43521);
    jzc = new a("release", 0, 1);
    jzd = new a("debug", 1, 2);
    jze = new a("demo", 2, 3);
    jzf = new a[] { jzc, jzd, jze };
    AppMethodBeat.o(43521);
  }
  
  private so$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oK(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return jzc;
    case 2: 
      return jzd;
    }
    return jze;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.so.a
 * JD-Core Version:    0.7.0.1
 */