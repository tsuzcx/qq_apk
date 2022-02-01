package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum sf$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43474);
    jxK = new a("release", 0, 1);
    jxL = new a("debug", 1, 2);
    jxM = new a("demo", 2, 3);
    jxN = new a[] { jxK, jxL, jxM };
    AppMethodBeat.o(43474);
  }
  
  private sf$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oD(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return jxK;
    case 2: 
      return jxL;
    }
    return jxM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sf.a
 * JD-Core Version:    0.7.0.1
 */