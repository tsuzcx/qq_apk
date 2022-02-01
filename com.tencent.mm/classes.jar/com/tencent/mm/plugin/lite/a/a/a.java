package com.tencent.mm.plugin.lite.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.lite.api.e;
import com.tencent.mm.plugin.lite.api.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class a
  extends e
{
  public final void a(String paramString, JSONObject paramJSONObject, boolean paramBoolean)
  {
    int k = 0;
    AppMethodBeat.i(271561);
    Log.d("LiteAppJsApiPreRenderMiniProgram", "Invoke prerenderMiniProgram");
    if (paramJSONObject == null)
    {
      this.JZj.aJV("data is null");
      AppMethodBeat.o(271561);
      return;
    }
    paramString = new g();
    paramString.qAO = new AppBrandLaunchReferrer();
    paramString.qAO.appId = paramJSONObject.optString("referrerAppId");
    paramString.qAO.qYE = 2;
    paramString.appId = paramJSONObject.optString("targetAppId");
    paramString.qAF = paramJSONObject.optString("path");
    paramJSONObject = paramJSONObject.optString("envVersion");
    int i = -1;
    int j;
    switch (paramJSONObject.hashCode())
    {
    default: 
      j = k;
      switch (i)
      {
      default: 
        j = k;
      }
      break;
    }
    for (;;)
    {
      paramString.euz = j;
      paramString.scene = 1055;
      if ((!Util.isNullOrNil(paramString.appId)) && (!Util.isNullOrNil(paramString.qAF))) {
        break label285;
      }
      this.JZj.aJV("fail");
      AppMethodBeat.o(271561);
      return;
      if (!paramJSONObject.equals("release")) {
        break;
      }
      i = 0;
      break;
      if (!paramJSONObject.equals("develop")) {
        break;
      }
      i = 1;
      break;
      if (!paramJSONObject.equals("trial")) {
        break;
      }
      i = 2;
      break;
      j = 1;
      continue;
      j = 2;
    }
    label285:
    ((t)h.ax(t.class)).b(paramString, new f()
    {
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(271549);
        a.b(a.this).aJV("fail errCode: " + paramAnonymousInt + "  errMsg: " + paramAnonymousString);
        AppMethodBeat.o(271549);
      }
      
      public final void onSuccess()
      {
        AppMethodBeat.i(271540);
        a.a(a.this).fTW();
        AppMethodBeat.o(271540);
      }
    });
    AppMethodBeat.o(271561);
  }
  
  public final int fEx()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.a.a
 * JD-Core Version:    0.7.0.1
 */