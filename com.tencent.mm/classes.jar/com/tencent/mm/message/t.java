package com.tencent.mm.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class t
{
  public int nUI;
  public int nUJ;
  
  public static final t Hk(String paramString)
  {
    AppMethodBeat.i(20241);
    t localt = new t();
    paramString = k.b.aP(paramString, null);
    if (paramString != null)
    {
      paramString = paramString.nUd;
      if (paramString != null)
      {
        localt.nUI = Util.getInt((String)paramString.get(".msg.appmsg.xmlfulllen"), 0);
        localt.nUJ = Util.getInt((String)paramString.get(".msg.appmsg.realinnertype"), 0);
      }
    }
    AppMethodBeat.o(20241);
    return localt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.message.t
 * JD-Core Version:    0.7.0.1
 */