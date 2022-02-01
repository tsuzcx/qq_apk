package com.tencent.mm.plugin.appbrand.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public a kgy = a.kgz;
  public int progress = 0;
  public int volume = 0;
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(158944);
      kgz = new a("NoMediaPresent", 0);
      kgA = new a("Stopped", 1);
      kgB = new a("Transitioning", 2);
      kgC = new a("Playing", 3);
      kgD = new a("Paused", 4);
      kgE = new a[] { kgz, kgA, kgB, kgC, kgD };
      AppMethodBeat.o(158944);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b.e
 * JD-Core Version:    0.7.0.1
 */