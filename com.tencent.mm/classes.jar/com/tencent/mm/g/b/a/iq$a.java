package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum iq$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43635);
    ewE = new a("release", 0, 1);
    ewF = new a("debug", 1, 2);
    ewG = new a("demo", 2, 3);
    ewH = new a[] { ewE, ewF, ewG };
    AppMethodBeat.o(43635);
  }
  
  private iq$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a jv(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return ewE;
    case 2: 
      return ewF;
    }
    return ewG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.iq.a
 * JD-Core Version:    0.7.0.1
 */