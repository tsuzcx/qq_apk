package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private static volatile d keX;
  Map<String, c> keY;
  
  private d()
  {
    AppMethodBeat.i(121156);
    this.keY = new ConcurrentHashMap();
    AppMethodBeat.o(121156);
  }
  
  public static d bfG()
  {
    AppMethodBeat.i(121157);
    if (keX == null) {}
    try
    {
      if (keX == null) {
        keX = new d();
      }
      d locald = keX;
      AppMethodBeat.o(121157);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(121157);
    }
  }
  
  public final c Op(String paramString)
  {
    AppMethodBeat.i(121158);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.DynamicPageViewIPCProxyManager", "get IPCProxy from manager failed, key is null or nil.");
      AppMethodBeat.o(121158);
      return null;
    }
    paramString = (c)this.keY.get(paramString);
    AppMethodBeat.o(121158);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d
 * JD-Core Version:    0.7.0.1
 */