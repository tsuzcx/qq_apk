package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

public final class t
{
  public int hkZ;
  public int hla;
  
  public static final t vF(String paramString)
  {
    AppMethodBeat.i(20241);
    t localt = new t();
    paramString = k.b.az(paramString, null);
    if (paramString != null)
    {
      paramString = paramString.hkv;
      if (paramString != null)
      {
        localt.hkZ = bs.getInt((String)paramString.get(".msg.appmsg.xmlfulllen"), 0);
        localt.hla = bs.getInt((String)paramString.get(".msg.appmsg.realinnertype"), 0);
      }
    }
    AppMethodBeat.o(20241);
    return localt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.t
 * JD-Core Version:    0.7.0.1
 */