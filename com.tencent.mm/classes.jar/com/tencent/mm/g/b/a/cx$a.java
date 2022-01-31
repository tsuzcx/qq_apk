package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum cx$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128897);
    ddK = new a("release", 0, 1);
    ddL = new a("debug", 1, 2);
    ddM = new a("demo", 2, 3);
    ddN = new a[] { ddK, ddL, ddM };
    AppMethodBeat.o(128897);
  }
  
  private cx$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a hl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return ddK;
    case 2: 
      return ddL;
    }
    return ddM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cx.a
 * JD-Core Version:    0.7.0.1
 */