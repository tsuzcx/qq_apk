package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum sy$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43577);
    jAr = new a("release", 0, 1);
    jAs = new a("debug", 1, 2);
    jAt = new a("demo", 2, 3);
    jAu = new a[] { jAr, jAs, jAt };
    AppMethodBeat.o(43577);
  }
  
  private sy$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oR(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return jAr;
    case 2: 
      return jAs;
    }
    return jAt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sy.a
 * JD-Core Version:    0.7.0.1
 */