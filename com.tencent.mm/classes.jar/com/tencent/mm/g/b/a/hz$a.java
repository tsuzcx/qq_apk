package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum hz$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43495);
    evL = new a("release", 0, 1);
    evM = new a("debug", 1, 2);
    evN = new a("demo", 2, 3);
    evO = new a[] { evL, evM, evN };
    AppMethodBeat.o(43495);
  }
  
  private hz$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a je(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return evL;
    case 2: 
      return evM;
    }
    return evN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hz.a
 * JD-Core Version:    0.7.0.1
 */