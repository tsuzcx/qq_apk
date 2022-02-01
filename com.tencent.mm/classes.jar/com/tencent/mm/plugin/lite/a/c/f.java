package com.tencent.mm.plugin.lite.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class f
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(271585);
    String str2 = paramJSONObject.optString("targetAppId");
    String str3 = paramJSONObject.optString("currentUrl");
    String str1 = paramJSONObject.optString("preVerifyAppId");
    paramString = str1;
    if (Util.isNullOrNil(str1)) {
      paramString = paramJSONObject.optString("referrerAppId");
    }
    if (Util.isNullOrNil(str2))
    {
      this.JZj.aJV("invalid_targetAppId");
      AppMethodBeat.o(271585);
      return;
    }
    if (Util.isNullOrNil(paramString))
    {
      this.JZj.aJV("invalid_referrerAppId");
      AppMethodBeat.o(271585);
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
      ((t)h.ax(t.class)).b(MMApplicationContext.getContext(), str3, paramString, str2, j, paramJSONObject, 0);
      this.JZj.fTW();
      AppMethodBeat.o(271585);
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
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.c.f
 * JD-Core Version:    0.7.0.1
 */