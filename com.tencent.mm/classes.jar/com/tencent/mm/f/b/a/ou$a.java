package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ou$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43513);
    hdi = new a("release", 0, 1);
    hdj = new a("debug", 1, 2);
    hdk = new a("demo", 2, 3);
    hdl = new a[] { hdi, hdj, hdk };
    AppMethodBeat.o(43513);
  }
  
  private ou$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a ot(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return hdi;
    case 2: 
      return hdj;
    }
    return hdk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ou.a
 * JD-Core Version:    0.7.0.1
 */