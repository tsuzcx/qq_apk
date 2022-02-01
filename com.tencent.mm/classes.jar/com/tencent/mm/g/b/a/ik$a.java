package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ik$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43585);
    evS = new a("release", 0, 1);
    evT = new a("debug", 1, 2);
    evU = new a("demo", 2, 3);
    evV = new a[] { evS, evT, evU };
    AppMethodBeat.o(43585);
  }
  
  private ik$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a jq(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return evS;
    case 2: 
      return evT;
    }
    return evU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ik.a
 * JD-Core Version:    0.7.0.1
 */