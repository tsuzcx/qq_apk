package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private static volatile d fTO;
  Map<String, c> fTP = new ConcurrentHashMap();
  
  public static d aeU()
  {
    if (fTO == null) {}
    try
    {
      if (fTO == null) {
        fTO = new d();
      }
      return fTO;
    }
    finally {}
  }
  
  public final c sT(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.DynamicPageViewIPCProxyManager", "get IPCProxy from manager failed, key is null or nil.");
      return null;
    }
    return (c)this.fTP.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d
 * JD-Core Version:    0.7.0.1
 */