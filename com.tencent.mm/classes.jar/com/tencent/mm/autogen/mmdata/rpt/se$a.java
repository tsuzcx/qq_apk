package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum se$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43468);
    jxE = new a("release", 0, 1);
    jxF = new a("debug", 1, 2);
    jxG = new a("demo", 2, 3);
    jxH = new a[] { jxE, jxF, jxG };
    AppMethodBeat.o(43468);
  }
  
  private se$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oC(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return jxE;
    case 2: 
      return jxF;
    }
    return jxG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.se.a
 * JD-Core Version:    0.7.0.1
 */