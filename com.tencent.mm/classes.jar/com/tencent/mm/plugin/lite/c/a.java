package com.tencent.mm.plugin.lite.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.plugin.lite.jsapi.a.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public class a
  extends com.tencent.mm.plugin.lite.jsapi.a
{
  public final int cZP()
  {
    return 1;
  }
  
  public final void j(String paramString, JSONObject paramJSONObject)
  {
    int j = 1;
    AppMethodBeat.i(217779);
    String str2 = paramJSONObject.optString("targetAppId");
    String str3 = paramJSONObject.optString("currentUrl");
    String str1 = paramJSONObject.optString("preVerifyAppId");
    paramString = str1;
    if (bu.isNullOrNil(str1)) {
      paramString = paramJSONObject.optString("referrerAppId");
    }
    if (bu.isNullOrNil(str2))
    {
      this.vko.ZC("invalid_targetAppId");
      AppMethodBeat.o(217779);
      return;
    }
    if (bu.isNullOrNil(paramString))
    {
      this.vko.ZC("invalid_referrerAppId");
      AppMethodBeat.o(217779);
      return;
    }
    str1 = bu.nullAsNil(paramJSONObject.optString("envVersion"));
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
      ((p)g.ab(p.class)).b(ak.getContext(), str3, paramString, str2, j, paramJSONObject, 0);
      this.vko.cZN();
      AppMethodBeat.o(217779);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.c.a
 * JD-Core Version:    0.7.0.1
 */