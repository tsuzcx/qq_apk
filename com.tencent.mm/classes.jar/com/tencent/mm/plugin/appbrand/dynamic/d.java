package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private static volatile d jKL;
  Map<String, c> jKM;
  
  private d()
  {
    AppMethodBeat.i(121156);
    this.jKM = new ConcurrentHashMap();
    AppMethodBeat.o(121156);
  }
  
  public static d bcc()
  {
    AppMethodBeat.i(121157);
    if (jKL == null) {}
    try
    {
      if (jKL == null) {
        jKL = new d();
      }
      d locald = jKL;
      AppMethodBeat.o(121157);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(121157);
    }
  }
  
  public final c KV(String paramString)
  {
    AppMethodBeat.i(121158);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.DynamicPageViewIPCProxyManager", "get IPCProxy from manager failed, key is null or nil.");
      AppMethodBeat.o(121158);
      return null;
    }
    paramString = (c)this.jKM.get(paramString);
    AppMethodBeat.o(121158);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d
 * JD-Core Version:    0.7.0.1
 */