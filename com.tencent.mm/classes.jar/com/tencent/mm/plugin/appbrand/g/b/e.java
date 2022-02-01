package com.tencent.mm.plugin.appbrand.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public a lkh = a.lki;
  public int progress = 0;
  public int volume = 0;
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(158944);
      lki = new a("NoMediaPresent", 0);
      lkj = new a("Stopped", 1);
      lkk = new a("Transitioning", 2);
      lkl = new a("Playing", 3);
      lkm = new a("Paused", 4);
      lkn = new a[] { lki, lkj, lkk, lkl, lkm };
      AppMethodBeat.o(158944);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b.e
 * JD-Core Version:    0.7.0.1
 */