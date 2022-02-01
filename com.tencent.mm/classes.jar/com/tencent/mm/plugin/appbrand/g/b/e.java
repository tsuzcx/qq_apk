package com.tencent.mm.plugin.appbrand.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  public a kdh = a.kdi;
  public int progress = 0;
  public int volume = 0;
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(158944);
      kdi = new a("NoMediaPresent", 0);
      kdj = new a("Stopped", 1);
      kdk = new a("Transitioning", 2);
      kdl = new a("Playing", 3);
      kdm = new a("Paused", 4);
      kdn = new a[] { kdi, kdj, kdk, kdl, kdm };
      AppMethodBeat.o(158944);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.b.e
 * JD-Core Version:    0.7.0.1
 */