package com.tencent.mm.plugin.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.c;

public final class b
  implements c
{
  private static b oCw;
  
  public static b bPG()
  {
    try
    {
      AppMethodBeat.i(79105);
      if (oCw == null) {
        oCw = new b();
      }
      b localb = oCw;
      AppMethodBeat.o(79105);
      return localb;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.m.b
 * JD-Core Version:    0.7.0.1
 */