package com.tencent.mm.plugin.appbrand.h.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public a jiH = a.jiJ;
  public int progress = 0;
  public int volume = 0;
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(158944);
      jiJ = new a("NoMediaPresent", 0);
      jiK = new a("Stopped", 1);
      jiL = new a("Transitioning", 2);
      jiM = new a("Playing", 3);
      jiN = new a("Paused", 4);
      jiO = new a[] { jiJ, jiK, jiL, jiM, jiN };
      AppMethodBeat.o(158944);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.h.b.e
 * JD-Core Version:    0.7.0.1
 */