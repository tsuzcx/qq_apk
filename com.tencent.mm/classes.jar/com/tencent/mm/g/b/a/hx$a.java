package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum hx$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43495);
    eue = new a("release", 0, 1);
    euf = new a("debug", 1, 2);
    eug = new a("demo", 2, 3);
    euh = new a[] { eue, euf, eug };
    AppMethodBeat.o(43495);
  }
  
  private hx$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a jc(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return eue;
    case 2: 
      return euf;
    }
    return eug;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hx.a
 * JD-Core Version:    0.7.0.1
 */