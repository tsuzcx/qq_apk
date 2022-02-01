package com.tencent.mm.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.modelstat.q;

public final class a
  extends t
{
  private static a hYs;
  
  private a()
  {
    super(q.class);
  }
  
  public static a aGU()
  {
    try
    {
      AppMethodBeat.i(151419);
      if (hYs == null) {
        hYs = new a();
      }
      a locala = hYs;
      AppMethodBeat.o(151419);
      return locala;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.a
 * JD-Core Version:    0.7.0.1
 */