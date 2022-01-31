package com.tencent.mm.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.model.q
{
  private static a gmN;
  
  private a()
  {
    super(com.tencent.mm.modelstat.q.class);
  }
  
  public static a aoF()
  {
    try
    {
      AppMethodBeat.i(79046);
      if (gmN == null) {
        gmN = new a();
      }
      a locala = gmN;
      AppMethodBeat.o(79046);
      return locala;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.a
 * JD-Core Version:    0.7.0.1
 */