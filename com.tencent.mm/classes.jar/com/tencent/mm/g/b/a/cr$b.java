package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum cr$b
{
  final int value;
  
  static
  {
    AppMethodBeat.i(128823);
    dcK = new b("ok", 0, 0);
    dcL = new b("common_fail", 1, 1);
    dcM = new b[] { dcK, dcL };
    AppMethodBeat.o(128823);
  }
  
  private cr$b(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static b hf(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return dcK;
    }
    return dcL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cr.b
 * JD-Core Version:    0.7.0.1
 */