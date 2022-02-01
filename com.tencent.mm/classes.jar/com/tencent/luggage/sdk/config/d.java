package com.tencent.luggage.sdk.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public abstract interface d
{
  public static final d czi = new d()
  {
    public final String NJ()
    {
      AppMethodBeat.i(229829);
      String str = "SessionId@" + hashCode() + "#" + Util.nowMilliSecond();
      AppMethodBeat.o(229829);
      return str;
    }
  };
  
  public abstract String NJ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.d
 * JD-Core Version:    0.7.0.1
 */