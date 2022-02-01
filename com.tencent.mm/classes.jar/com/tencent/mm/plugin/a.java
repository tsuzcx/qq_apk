package com.tencent.mm.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;
import com.tencent.mm.modelstat.q;

public final class a
  extends y
{
  private static a jRs;
  
  private a()
  {
    super(q.class);
  }
  
  public static a blX()
  {
    try
    {
      AppMethodBeat.i(151419);
      if (jRs == null) {
        jRs = new a();
      }
      a locala = jRs;
      AppMethodBeat.o(151419);
      return locala;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.a
 * JD-Core Version:    0.7.0.1
 */