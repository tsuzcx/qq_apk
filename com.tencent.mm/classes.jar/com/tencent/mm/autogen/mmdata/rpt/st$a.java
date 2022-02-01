package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum st$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43552);
    jzM = new a("release", 0, 1);
    jzN = new a("debug", 1, 2);
    jzO = new a("demo", 2, 3);
    jzP = new a[] { jzM, jzN, jzO };
    AppMethodBeat.o(43552);
  }
  
  private st$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oO(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return jzM;
    case 2: 
      return jzN;
    }
    return jzO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.st.a
 * JD-Core Version:    0.7.0.1
 */