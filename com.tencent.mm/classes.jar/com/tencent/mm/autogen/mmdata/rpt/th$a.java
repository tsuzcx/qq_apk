package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum th$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43643);
    jBZ = new a("release", 0, 1);
    jCa = new a("debug", 1, 2);
    jCb = new a("demo", 2, 3);
    jCc = new a[] { jBZ, jCa, jCb };
    AppMethodBeat.o(43643);
  }
  
  private th$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oX(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return jBZ;
    case 2: 
      return jCa;
    }
    return jCb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.th.a
 * JD-Core Version:    0.7.0.1
 */