package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum sn$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43513);
    jyW = new a("release", 0, 1);
    jyX = new a("debug", 1, 2);
    jyY = new a("demo", 2, 3);
    jyZ = new a[] { jyW, jyX, jyY };
    AppMethodBeat.o(43513);
  }
  
  private sn$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oJ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return jyW;
    case 2: 
      return jyX;
    }
    return jyY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sn.a
 * JD-Core Version:    0.7.0.1
 */