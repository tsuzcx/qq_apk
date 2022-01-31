package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum cp$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128796);
    dcn = new a("release", 0, 1);
    dco = new a("debug", 1, 2);
    dcp = new a("demo", 2, 3);
    dcq = new a[] { dcn, dco, dcp };
    AppMethodBeat.o(128796);
  }
  
  private cp$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a hc(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return dcn;
    case 2: 
      return dco;
    }
    return dcp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cp.a
 * JD-Core Version:    0.7.0.1
 */