package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public final class o
{
  public int fjF;
  public int fjG;
  
  public static final o nd(String paramString)
  {
    AppMethodBeat.i(16198);
    o localo = new o();
    paramString = j.b.ab(paramString, null);
    if (paramString != null)
    {
      paramString = paramString.fjm;
      if (paramString != null)
      {
        localo.fjF = bo.getInt((String)paramString.get(".msg.appmsg.xmlfulllen"), 0);
        localo.fjG = bo.getInt((String)paramString.get(".msg.appmsg.realinnertype"), 0);
      }
    }
    AppMethodBeat.o(16198);
    return localo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.af.o
 * JD-Core Version:    0.7.0.1
 */