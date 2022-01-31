package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashMap;
import java.util.HashSet;

public final class p
  extends l
{
  private static final int CTRL_INDEX = 153;
  private static final String NAME = "onNetworkStatusChange";
  private static p gfn;
  private static HashSet<String> gfo = new HashSet();
  
  public static void f(c paramc)
  {
    for (;;)
    {
      HashMap localHashMap;
      Context localContext;
      try
      {
        localHashMap = new HashMap();
        localContext = ae.getContext();
        boolean bool = aq.isConnected(localContext);
        localHashMap.put("isConnected", Boolean.valueOf(bool));
        if (!bool)
        {
          localHashMap.put("networkType", "none");
          if (gfn == null) {
            gfn = new p();
          }
          gfn.d(paramc).o(localHashMap).dispatch();
          return;
        }
        if (aq.is2G(localContext))
        {
          localHashMap.put("networkType", "2g");
          continue;
        }
        if (!aq.is3G(localContext)) {
          break label122;
        }
      }
      finally {}
      localHashMap.put("networkType", "3g");
      continue;
      label122:
      if (aq.is4G(localContext)) {
        localHashMap.put("networkType", "4g");
      } else if (aq.isWifi(localContext)) {
        localHashMap.put("networkType", "wifi");
      } else {
        localHashMap.put("networkType", "unknown");
      }
    }
  }
  
  public static void tN(String paramString)
  {
    try
    {
      gfo.add(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void tO(String paramString)
  {
    try
    {
      gfo.remove(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p
 * JD-Core Version:    0.7.0.1
 */