package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.ConcurrentHashMap;

public final class d$a
{
  private static ConcurrentHashMap<Object, d> ftb;
  
  static
  {
    AppMethodBeat.i(59944);
    ftb = new ConcurrentHashMap();
    AppMethodBeat.o(59944);
  }
  
  public static void a(d paramd)
  {
    AppMethodBeat.i(59941);
    ab.i("MicroMsg.IFunctionMessageExtension.Factory", "registerExtensionFor %s, %s", new Object[] { Integer.valueOf(12399999), Integer.valueOf(0) });
    ftb.put(Integer.valueOf(0), paramd);
    e.d.a(Integer.valueOf(12399999), paramd);
    AppMethodBeat.o(59941);
  }
  
  public static d aU(Object paramObject)
  {
    AppMethodBeat.i(59943);
    paramObject = (d)ftb.get(paramObject);
    AppMethodBeat.o(59943);
    return paramObject;
  }
  
  public static void b(d paramd)
  {
    AppMethodBeat.i(59942);
    ab.i("MicroMsg.IFunctionMessageExtension.Factory", "unregisterExtensionFor %s, %s", new Object[] { Integer.valueOf(12399999), Integer.valueOf(0) });
    ftb.remove(Integer.valueOf(0));
    e.d.b(Integer.valueOf(12399999), paramd);
    AppMethodBeat.o(59942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.d.a
 * JD-Core Version:    0.7.0.1
 */