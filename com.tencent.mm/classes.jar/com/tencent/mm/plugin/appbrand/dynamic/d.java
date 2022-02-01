package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private static volatile d kin;
  Map<String, c> kio;
  
  private d()
  {
    AppMethodBeat.i(121156);
    this.kio = new ConcurrentHashMap();
    AppMethodBeat.o(121156);
  }
  
  public static d bgo()
  {
    AppMethodBeat.i(121157);
    if (kin == null) {}
    try
    {
      if (kin == null) {
        kin = new d();
      }
      d locald = kin;
      AppMethodBeat.o(121157);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(121157);
    }
  }
  
  public final c OX(String paramString)
  {
    AppMethodBeat.i(121158);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.DynamicPageViewIPCProxyManager", "get IPCProxy from manager failed, key is null or nil.");
      AppMethodBeat.o(121158);
      return null;
    }
    paramString = (c)this.kio.get(paramString);
    AppMethodBeat.o(121158);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d
 * JD-Core Version:    0.7.0.1
 */