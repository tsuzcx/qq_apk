package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum io$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43621);
    ewr = new a("release", 0, 1);
    ews = new a("debug", 1, 2);
    ewt = new a("demo", 2, 3);
    ewu = new a[] { ewr, ews, ewt };
    AppMethodBeat.o(43621);
  }
  
  private io$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a ju(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return ewr;
    case 2: 
      return ews;
    }
    return ewt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.io.a
 * JD-Core Version:    0.7.0.1
 */