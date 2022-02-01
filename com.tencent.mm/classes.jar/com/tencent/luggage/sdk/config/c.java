package com.tencent.luggage.sdk.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.sdk.platformtools.Util;

public abstract interface c
{
  public static final c cxS = new c()
  {
    public final String QD()
    {
      AppMethodBeat.i(246761);
      String str = p.getString(hashCode()) + "_" + Util.nowMilliSecond();
      AppMethodBeat.o(246761);
      return str;
    }
  };
  
  public abstract String QD();
  
  public static final class a
  {
    public static c cxT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.c
 * JD-Core Version:    0.7.0.1
 */