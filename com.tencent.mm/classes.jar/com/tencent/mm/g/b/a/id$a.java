package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum id$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43529);
    ewh = new a("release", 0, 1);
    ewi = new a("debug", 1, 2);
    ewj = new a("demo", 2, 3);
    ewk = new a[] { ewh, ewi, ewj };
    AppMethodBeat.o(43529);
  }
  
  private id$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a ji(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return ewh;
    case 2: 
      return ewi;
    }
    return ewj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.id.a
 * JD-Core Version:    0.7.0.1
 */