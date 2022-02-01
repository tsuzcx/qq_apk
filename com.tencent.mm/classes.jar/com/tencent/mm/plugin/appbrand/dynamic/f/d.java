package com.tencent.mm.plugin.appbrand.dynamic.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.b.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
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
    AppMethodBeat.i(121394);
    Object localObject = new HashMap();
    Context localContext = MMApplicationContext.getContext();
    boolean bool = NetStatusUtil.isConnected(localContext);
    ((HashMap)localObject).put("isConnected", Boolean.valueOf(bool));
    if (!bool) {
      ((HashMap)localObject).put("networkType", "none");
    }
    for (;;)
    {
      localObject = new JSONObject((Map)localObject);
      AppMethodBeat.o(121394);
      return localObject;
      if (NetStatusUtil.is2G(localContext)) {
        ((HashMap)localObject).put("networkType", "2g");
      } else if (NetStatusUtil.is3G(localContext)) {
        ((HashMap)localObject).put("networkType", "3g");
      } else if (NetStatusUtil.is4G(localContext)) {
        ((HashMap)localObject).put("networkType", "4g");
      } else if (NetStatusUtil.isWifi(localContext)) {
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