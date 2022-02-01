package com.tencent.luggage.sdk.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.sdk.platformtools.Util;

public abstract interface d
{
  public static final d eqn = new d()
  {
    public final String aqP()
    {
      AppMethodBeat.i(220225);
      String str = p.getString(hashCode()) + "_" + Util.nowMilliSecond();
      AppMethodBeat.o(220225);
      return str;
    }
  };
  
  public abstract String aqP();
  
  public static final class a
  {
    public static d eqo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.config.d
 * JD-Core Version:    0.7.0.1
 */