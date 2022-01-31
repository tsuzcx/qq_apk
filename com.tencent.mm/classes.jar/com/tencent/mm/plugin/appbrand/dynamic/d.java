package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private static volatile d hnq;
  Map<String, c> hnr;
  
  private d()
  {
    AppMethodBeat.i(10675);
    this.hnr = new ConcurrentHashMap();
    AppMethodBeat.o(10675);
  }
  
  public static d azx()
  {
    AppMethodBeat.i(10676);
    if (hnq == null) {}
    try
    {
      if (hnq == null) {
        hnq = new d();
      }
      d locald = hnq;
      AppMethodBeat.o(10676);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(10676);
    }
  }
  
  public final c AU(String paramString)
  {
    AppMethodBeat.i(10677);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.DynamicPageViewIPCProxyManager", "get IPCProxy from manager failed, key is null or nil.");
      AppMethodBeat.o(10677);
      return null;
    }
    paramString = (c)this.hnr.get(paramString);
    AppMethodBeat.o(10677);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d
 * JD-Core Version:    0.7.0.1
 */