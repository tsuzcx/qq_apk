package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private static volatile d ogH;
  Map<String, c> ogI;
  
  private d()
  {
    AppMethodBeat.i(121156);
    this.ogI = new ConcurrentHashMap();
    AppMethodBeat.o(121156);
  }
  
  public static d bNd()
  {
    AppMethodBeat.i(121157);
    if (ogH == null) {}
    try
    {
      if (ogH == null) {
        ogH = new d();
      }
      d locald = ogH;
      AppMethodBeat.o(121157);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(121157);
    }
  }
  
  public final c afW(String paramString)
  {
    AppMethodBeat.i(121158);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.DynamicPageViewIPCProxyManager", "get IPCProxy from manager failed, key is null or nil.");
      AppMethodBeat.o(121158);
      return null;
    }
    paramString = (c)this.ogI.get(paramString);
    AppMethodBeat.o(121158);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d
 * JD-Core Version:    0.7.0.1
 */