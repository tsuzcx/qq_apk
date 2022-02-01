package com.tencent.luggage.sdk.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public abstract interface e
{
  public static final e eqp = new e()
  {
    public final String aqQ()
    {
      AppMethodBeat.i(220236);
      String str = "SessionId@" + hashCode() + "#" + Util.nowMilliSecond();
      AppMethodBeat.o(220236);
      return str;
    }
  };
  
  public abstract String aqQ();
  
  public static final class a
  {
    public static e eqq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.e
 * JD-Core Version:    0.7.0.1
 */