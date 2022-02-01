package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum iz$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43711);
    ezo = new a("release", 0, 1);
    ezp = new a("debug", 1, 2);
    ezq = new a("demo", 2, 3);
    ezr = new a[] { ezo, ezp, ezq };
    AppMethodBeat.o(43711);
  }
  
  private iz$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a jF(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return ezo;
    case 2: 
      return ezp;
    }
    return ezq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.iz.a
 * JD-Core Version:    0.7.0.1
 */