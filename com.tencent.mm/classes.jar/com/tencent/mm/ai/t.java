package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public final class t
{
  public int gKA;
  public int gKz;
  
  public static final t rC(String paramString)
  {
    AppMethodBeat.i(20241);
    t localt = new t();
    paramString = k.b.ar(paramString, null);
    if (paramString != null)
    {
      paramString = paramString.gJV;
      if (paramString != null)
      {
        localt.gKz = bt.getInt((String)paramString.get(".msg.appmsg.xmlfulllen"), 0);
        localt.gKA = bt.getInt((String)paramString.get(".msg.appmsg.realinnertype"), 0);
      }
    }
    AppMethodBeat.o(20241);
    return localt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ai.t
 * JD-Core Version:    0.7.0.1
 */