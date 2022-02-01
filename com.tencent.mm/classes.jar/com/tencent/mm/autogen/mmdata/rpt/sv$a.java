package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum sv$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43564);
    jAd = new a("release", 0, 1);
    jAe = new a("debug", 1, 2);
    jAf = new a("demo", 2, 3);
    jAg = new a[] { jAd, jAe, jAf };
    AppMethodBeat.o(43564);
  }
  
  private sv$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oQ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return jAd;
    case 2: 
      return jAe;
    }
    return jAf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sv.a
 * JD-Core Version:    0.7.0.1
 */