package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum te$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43621);
    jBh = new a("release", 0, 1);
    jBi = new a("debug", 1, 2);
    jBj = new a("demo", 2, 3);
    jBk = new a[] { jBh, jBi, jBj };
    AppMethodBeat.o(43621);
  }
  
  private te$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oV(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return jBh;
    case 2: 
      return jBi;
    }
    return jBj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.te.a
 * JD-Core Version:    0.7.0.1
 */