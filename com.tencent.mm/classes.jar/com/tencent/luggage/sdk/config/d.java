package com.tencent.luggage.sdk.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public abstract interface d
{
  public static final d cxU = new d()
  {
    public final String QE()
    {
      AppMethodBeat.i(242814);
      String str = "SessionId@" + hashCode() + "#" + Util.nowMilliSecond();
      AppMethodBeat.o(242814);
      return str;
    }
  };
  
  public abstract String QE();
  
  public static final class a
  {
    public static d cxV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.d
 * JD-Core Version:    0.7.0.1
 */