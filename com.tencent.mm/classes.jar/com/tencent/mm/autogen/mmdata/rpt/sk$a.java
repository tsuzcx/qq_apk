package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum sk$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43485);
    jyu = new a("release", 0, 1);
    jyv = new a("debug", 1, 2);
    jyw = new a("test", 2, 3);
    jyx = new a[] { jyu, jyv, jyw };
    AppMethodBeat.o(43485);
  }
  
  private sk$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oF(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return jyu;
    case 2: 
      return jyv;
    }
    return jyw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sk.a
 * JD-Core Version:    0.7.0.1
 */