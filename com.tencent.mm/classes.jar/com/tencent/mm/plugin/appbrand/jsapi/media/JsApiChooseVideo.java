package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.permission.n;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseVideo
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 36;
  public static final String NAME = "chooseVideo";
  private static volatile boolean hRE = false;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(131296);
    if (hRE)
    {
      paramc.h(paramInt, j("cancel", null));
      AppMethodBeat.o(131296);
      return;
    }
    Context localContext = paramc.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      paramc.h(paramInt, j("fail", null));
      AppMethodBeat.o(131296);
      return;
    }
    JsApiChooseVideo.ChooseRequest localChooseRequest = new JsApiChooseVideo.ChooseRequest();
    JSONArray localJSONArray = paramJSONObject.optJSONArray("sourceType");
    String str = paramJSONObject.optString("maxDuration");
    ab.i("MicroMsg.JsApiChooseVideo", "doChooseVideo sourceType = %s, maxDuration = %s", new Object[] { localJSONArray, str });
    int i;
    if ((localJSONArray == null) || (localJSONArray.length() == 0))
    {
      localChooseRequest.hQD = true;
      localChooseRequest.hQE = true;
      localChooseRequest.hRG = paramJSONObject.optBoolean("compressed", true);
      if (!localChooseRequest.hQD) {
        break label304;
      }
      n.a(paramc.getAppId(), new JsApiChooseVideo.3(this, paramc, paramJSONObject, paramInt));
      paramJSONObject = paramc.getContext();
      if ((paramJSONObject != null) && ((paramJSONObject instanceof Activity))) {
        break label262;
      }
      paramc.h(paramInt, j("fail", null));
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label304;
      }
      AppMethodBeat.o(131296);
      return;
      localChooseRequest.hQD = localJSONArray.toString().contains("camera");
      localChooseRequest.hQE = localJSONArray.toString().contains("album");
      break;
      label262:
      boolean bool = b.a((Activity)paramJSONObject, "android.permission.CAMERA", 115, "", "");
      i = bool;
      if (bool)
      {
        n.EA(paramc.getAppId());
        i = bool;
      }
    }
    label304:
    hRE = true;
    e.a(paramc.getAppId(), new JsApiChooseVideo.1(this, paramc));
    localChooseRequest.maxDuration = bo.getInt(str, 60);
    localChooseRequest.appId = paramc.getAppId();
    com.tencent.mm.plugin.appbrand.ipc.a.b(localContext, localChooseRequest, new JsApiChooseVideo.2(this, paramc, paramInt));
    AppMethodBeat.o(131296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo
 * JD-Core Version:    0.7.0.1
 */