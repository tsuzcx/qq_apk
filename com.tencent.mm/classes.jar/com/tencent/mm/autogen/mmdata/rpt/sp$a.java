package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum sp$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43529);
    jzh = new a("release", 0, 1);
    jzi = new a("debug", 1, 2);
    jzj = new a("demo", 2, 3);
    jzk = new a[] { jzh, jzi, jzj };
    AppMethodBeat.o(43529);
  }
  
  private sp$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oL(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return jzh;
    case 2: 
      return jzi;
    }
    return jzj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sp.a
 * JD-Core Version:    0.7.0.1
 */