package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum sr$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43547);
    jzt = new a("release", 0, 1);
    jzu = new a("debug", 1, 2);
    jzv = new a("demo", 2, 3);
    jzw = new a[] { jzt, jzu, jzv };
    AppMethodBeat.o(43547);
  }
  
  private sr$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a oN(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return jzt;
    case 2: 
      return jzu;
    }
    return jzv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.sr.a
 * JD-Core Version:    0.7.0.1
 */