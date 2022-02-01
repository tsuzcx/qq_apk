package com.tencent.mm.plugin.ae;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;
import com.tencent.mm.modelcontrol.d;

public final class a
  extends y
{
  private static a GRD;
  
  private a()
  {
    super(d.class);
  }
  
  public static a foH()
  {
    try
    {
      AppMethodBeat.i(151531);
      if (GRD == null) {
        GRD = new a();
      }
      a locala = GRD;
      AppMethodBeat.o(151531);
      return locala;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ae.a
 * JD-Core Version:    0.7.0.1
 */