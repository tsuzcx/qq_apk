package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum su$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(369040);
    jzV = new a("release", 0, 1);
    jzW = new a("debug", 1, 2);
    jzX = new a("demo", 2, 3);
    jzY = new a[] { jzV, jzW, jzX };
    AppMethodBeat.o(369040);
  }
  
  private su$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oP(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return jzV;
    case 2: 
      return jzW;
    }
    return jzX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.su.a
 * JD-Core Version:    0.7.0.1
 */