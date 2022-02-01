package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class t
{
  public int iAk;
  public int iAl;
  
  public static final t HI(String paramString)
  {
    AppMethodBeat.i(20241);
    t localt = new t();
    paramString = k.b.aD(paramString, null);
    if (paramString != null)
    {
      paramString = paramString.izF;
      if (paramString != null)
      {
        localt.iAk = Util.getInt((String)paramString.get(".msg.appmsg.xmlfulllen"), 0);
        localt.iAl = Util.getInt((String)paramString.get(".msg.appmsg.realinnertype"), 0);
      }
    }
    AppMethodBeat.o(20241);
    return localt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ag.t
 * JD-Core Version:    0.7.0.1
 */