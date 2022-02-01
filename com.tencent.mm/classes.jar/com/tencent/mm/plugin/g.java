package com.tencent.mm.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;
import com.tencent.mm.modelstat.p;

public final class g
  extends y
{
  private static g mIF;
  
  private g()
  {
    super(p.class);
  }
  
  public static g bwf()
  {
    try
    {
      AppMethodBeat.i(151419);
      if (mIF == null) {
        mIF = new g();
      }
      g localg = mIF;
      AppMethodBeat.o(151419);
      return localg;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.g
 * JD-Core Version:    0.7.0.1
 */