package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum sl$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43495);
    jyL = new a("release", 0, 1);
    jyM = new a("debug", 1, 2);
    jyN = new a("demo", 2, 3);
    jyO = new a[] { jyL, jyM, jyN };
    AppMethodBeat.o(43495);
  }
  
  private sl$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oH(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return jyL;
    case 2: 
      return jyM;
    }
    return jyN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sl.a
 * JD-Core Version:    0.7.0.1
 */