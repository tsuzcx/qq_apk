package com.tencent.mm.plugin.abtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.c.d;
import com.tencent.mm.model.y;

public final class c
  extends y
{
  private static c mQw;
  
  private c()
  {
    super(d.class);
  }
  
  public static c bxj()
  {
    try
    {
      AppMethodBeat.i(153140);
      if (mQw == null) {
        mQw = new c();
      }
      c localc = mQw;
      AppMethodBeat.o(153140);
      return localc;
    }
    finally {}
  }
  
  public final void MU(String paramString)
  {
    AppMethodBeat.i(153141);
    super.MU(paramString);
    AppMethodBeat.o(153141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.abtest.c
 * JD-Core Version:    0.7.0.1
 */