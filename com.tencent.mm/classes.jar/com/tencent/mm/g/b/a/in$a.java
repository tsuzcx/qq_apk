package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum in$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43613);
    ewl = new a("release", 0, 1);
    ewm = new a("debug", 1, 2);
    ewn = new a("demo", 2, 3);
    ewo = new a[] { ewl, ewm, ewn };
    AppMethodBeat.o(43613);
  }
  
  private in$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a jt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return ewl;
    case 2: 
      return ewm;
    }
    return ewn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.in.a
 * JD-Core Version:    0.7.0.1
 */