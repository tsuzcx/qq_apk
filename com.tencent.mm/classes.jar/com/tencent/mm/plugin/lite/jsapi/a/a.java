package com.tencent.mm.plugin.lite.jsapi.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.plugin.lite.jsapi.b.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class a
  extends b
{
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    int j = 1;
    AppMethodBeat.i(198836);
    String str2 = paramJSONObject.optString("targetAppId");
    String str3 = paramJSONObject.optString("currentUrl");
    String str1 = paramJSONObject.optString("preVerifyAppId");
    paramString = str1;
    if (Util.isNullOrNil(str1)) {
      paramString = paramJSONObject.optString("referrerAppId");
    }
    if (Util.isNullOrNil(str2))
    {
      this.yEn.aCS("invalid_targetAppId");
      AppMethodBeat.o(198836);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      this.yEn.aCS("invalid_referrerAppId");
      AppMethodBeat.o(198836);
      return;
    }
    str1 = Util.nullAsNil(paramJSONObject.optString("envVersion"));
    int i = -1;
    switch (str1.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (j = 0;; j = 2)
    {
      paramJSONObject = paramJSONObject.optString("path");
      ((r)g.af(r.class)).b(MMApplicationContext.getContext(), str3, paramString, str2, j, paramJSONObject, 0);
      this.yEn.ecz();
      AppMethodBeat.o(198836);
      return;
      if (!str1.equals("develop")) {
        break;
      }
      i = 0;
      break;
      if (!str1.equals("trial")) {
        break;
      }
      i = 1;
      break;
    }
  }
  
  public final int dTw()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.jsapi.a.a
 * JD-Core Version:    0.7.0.1
 */