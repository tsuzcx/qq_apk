package com.tencent.mm.plugin.appbrand.dynamic.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.z.b.c;
import java.util.HashMap;
import java.util.Map;
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
  
  public final JSONObject toJSONObject()
  {
    AppMethodBeat.i(10913);
    Object localObject = new HashMap();
    Context localContext = ah.getContext();
    boolean bool = at.isConnected(localContext);
    ((HashMap)localObject).put("isConnected", Boolean.valueOf(bool));
    if (!bool) {
      ((HashMap)localObject).put("networkType", "none");
    }
    for (;;)
    {
      localObject = new JSONObject((Map)localObject);
      AppMethodBeat.o(10913);
      return localObject;
      if (at.is2G(localContext)) {
        ((HashMap)localObject).put("networkType", "2g");
      } else if (at.is3G(localContext)) {
        ((HashMap)localObject).put("networkType", "3g");
      } else if (at.is4G(localContext)) {
        ((HashMap)localObject).put("networkType", "4g");
      } else if (at.isWifi(localContext)) {
        ((HashMap)localObject).put("networkType", "wifi");
      } else {
        ((HashMap)localObject).put("networkType", "unknown");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f.d
 * JD-Core Version:    0.7.0.1
 */