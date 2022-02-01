package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum tt$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43752);
    jET = new a("release", 0, 1);
    jEU = new a("debug", 1, 2);
    jEV = new a("demo", 2, 3);
    jEW = new a[] { jET, jEU, jEV };
    AppMethodBeat.o(43752);
  }
  
  private tt$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a pj(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return jET;
    case 2: 
      return jEU;
    }
    return jEV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.tt.a
 * JD-Core Version:    0.7.0.1
 */