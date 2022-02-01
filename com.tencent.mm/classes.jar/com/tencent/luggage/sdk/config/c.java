package com.tencent.luggage.sdk.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.sdk.platformtools.Util;

public abstract interface c
{
  public static final c czg = new c()
  {
    public final String NI()
    {
      AppMethodBeat.i(229828);
      String str = p.getString(hashCode()) + "_" + Util.nowMilliSecond();
      AppMethodBeat.o(229828);
      return str;
    }
  };
  
  public abstract String NI();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.c
 * JD-Core Version:    0.7.0.1
 */