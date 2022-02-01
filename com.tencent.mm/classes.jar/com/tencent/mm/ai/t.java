package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public final class t
{
  public int hDi;
  public int hDj;
  
  public static final t yw(String paramString)
  {
    AppMethodBeat.i(20241);
    t localt = new t();
    paramString = k.b.aA(paramString, null);
    if (paramString != null)
    {
      paramString = paramString.hCE;
      if (paramString != null)
      {
        localt.hDi = bt.getInt((String)paramString.get(".msg.appmsg.xmlfulllen"), 0);
        localt.hDj = bt.getInt((String)paramString.get(".msg.appmsg.realinnertype"), 0);
      }
    }
    AppMethodBeat.o(20241);
    return localt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.t
 * JD-Core Version:    0.7.0.1
 */