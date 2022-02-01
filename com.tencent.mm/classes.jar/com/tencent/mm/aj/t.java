package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class t
{
  public int lpG;
  public int lpH;
  
  public static final t OV(String paramString)
  {
    AppMethodBeat.i(20241);
    t localt = new t();
    paramString = k.b.aG(paramString, null);
    if (paramString != null)
    {
      paramString = paramString.lpa;
      if (paramString != null)
      {
        localt.lpG = Util.getInt((String)paramString.get(".msg.appmsg.xmlfulllen"), 0);
        localt.lpH = Util.getInt((String)paramString.get(".msg.appmsg.realinnertype"), 0);
      }
    }
    AppMethodBeat.o(20241);
    return localt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.t
 * JD-Core Version:    0.7.0.1
 */