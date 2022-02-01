package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum tn$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43687);
    jDG = new a("release", 0, 1);
    jDH = new a("debug", 1, 2);
    jDI = new a("demo", 2, 3);
    jDJ = new a[] { jDG, jDH, jDI };
    AppMethodBeat.o(43687);
  }
  
  private tn$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a pe(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return jDG;
    case 2: 
      return jDH;
    }
    return jDI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.tn.a
 * JD-Core Version:    0.7.0.1
 */