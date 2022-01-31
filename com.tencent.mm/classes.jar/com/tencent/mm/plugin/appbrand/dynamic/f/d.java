package com.tencent.mm.plugin.appbrand.dynamic.f;

import android.content.Context;
import com.tencent.mm.aa.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashMap;
import org.json.JSONObject;

public final class d
  extends c
{
  public d()
  {
    super("onNetworkStatusChange");
  }
  
  d(int paramInt)
  {
    super("onNetworkStatusChange", paramInt);
  }
  
  public final JSONObject rB()
  {
    HashMap localHashMap = new HashMap();
    Context localContext = ae.getContext();
    boolean bool = aq.isConnected(localContext);
    localHashMap.put("isConnected", Boolean.valueOf(bool));
    if (!bool) {
      localHashMap.put("networkType", "none");
    }
    for (;;)
    {
      return new JSONObject(localHashMap);
      if (aq.is2G(localContext)) {
        localHashMap.put("networkType", "2g");
      } else if (aq.is3G(localContext)) {
        localHashMap.put("networkType", "3g");
      } else if (aq.is4G(localContext)) {
        localHashMap.put("networkType", "4g");
      } else if (aq.isWifi(localContext)) {
        localHashMap.put("networkType", "wifi");
      } else {
        localHashMap.put("networkType", "unknown");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f.d
 * JD-Core Version:    0.7.0.1
 */