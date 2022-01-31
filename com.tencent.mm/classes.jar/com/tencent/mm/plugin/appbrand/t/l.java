package com.tencent.mm.plugin.appbrand.t;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
{
  public static Boolean bv(Object paramObject)
  {
    AppMethodBeat.i(87423);
    if ((paramObject instanceof Boolean))
    {
      paramObject = (Boolean)paramObject;
      AppMethodBeat.o(87423);
      return paramObject;
    }
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if ("true".equalsIgnoreCase(paramObject))
      {
        paramObject = Boolean.TRUE;
        AppMethodBeat.o(87423);
        return paramObject;
      }
      if ("false".equalsIgnoreCase(paramObject))
      {
        paramObject = Boolean.FALSE;
        AppMethodBeat.o(87423);
        return paramObject;
      }
    }
    AppMethodBeat.o(87423);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.l
 * JD-Core Version:    0.7.0.1
 */