package com.tencent.mm.plugin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.c;

public final class b
  implements c
{
  private static b zoC;
  
  public static b eip()
  {
    try
    {
      AppMethodBeat.i(151500);
      if (zoC == null) {
        zoC = new b();
      }
      b localb = zoC;
      AppMethodBeat.o(151500);
      return localb;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.m.b
 * JD-Core Version:    0.7.0.1
 */