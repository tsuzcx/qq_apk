package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private static volatile d jky;
  Map<String, c> jkz;
  
  private d()
  {
    AppMethodBeat.i(121156);
    this.jkz = new ConcurrentHashMap();
    AppMethodBeat.o(121156);
  }
  
  public static d aVe()
  {
    AppMethodBeat.i(121157);
    if (jky == null) {}
    try
    {
      if (jky == null) {
        jky = new d();
      }
      d locald = jky;
      AppMethodBeat.o(121157);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(121157);
    }
  }
  
  public final c GR(String paramString)
  {
    AppMethodBeat.i(121158);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.DynamicPageViewIPCProxyManager", "get IPCProxy from manager failed, key is null or nil.");
      AppMethodBeat.o(121158);
      return null;
    }
    paramString = (c)this.jkz.get(paramString);
    AppMethodBeat.o(121158);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d
 * JD-Core Version:    0.7.0.1
 */