package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ic$a
{
  final int value;
  
  static
  {
    AppMethodBeat.i(43521);
    ewc = new a("release", 0, 1);
    ewd = new a("debug", 1, 2);
    ewe = new a("demo", 2, 3);
    ewf = new a[] { ewc, ewd, ewe };
    AppMethodBeat.o(43521);
  }
  
  private ic$a(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static a jh(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return ewc;
    case 2: 
      return ewd;
    }
    return ewe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ic.a
 * JD-Core Version:    0.7.0.1
 */