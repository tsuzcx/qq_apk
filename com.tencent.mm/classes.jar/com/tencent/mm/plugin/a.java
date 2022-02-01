package com.tencent.mm.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.modelstat.q;

public final class a
  extends t
{
  private static a iyw;
  
  private a()
  {
    super(q.class);
  }
  
  public static a aNI()
  {
    try
    {
      AppMethodBeat.i(151419);
      if (iyw == null) {
        iyw = new a();
      }
      a locala = iyw;
      AppMethodBeat.o(151419);
      return locala;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.a
 * JD-Core Version:    0.7.0.1
 */