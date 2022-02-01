package com.tencent.mm.plugin.appbrand.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public a oeS = a.oeT;
  public int progress = 0;
  public int volume = 0;
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(158944);
      oeT = new a("NoMediaPresent", 0);
      oeU = new a("Stopped", 1);
      oeV = new a("Transitioning", 2);
      oeW = new a("Playing", 3);
      oeX = new a("Paused", 4);
      oeY = new a[] { oeT, oeU, oeV, oeW, oeX };
      AppMethodBeat.o(158944);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b.e
 * JD-Core Version:    0.7.0.1
 */