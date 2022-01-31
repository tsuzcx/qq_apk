package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseVideo
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 36;
  public static final String NAME = "chooseVideo";
  private static volatile boolean gvT = false;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (gvT) {
      paramc.C(paramInt, h("cancel", null));
    }
    label304:
    label344:
    for (;;)
    {
      return;
      Context localContext = paramc.getContext();
      if ((localContext == null) || (!(localContext instanceof Activity)))
      {
        paramc.C(paramInt, h("fail", null));
        return;
      }
      JsApiChooseVideo.ChooseRequest localChooseRequest = new JsApiChooseVideo.ChooseRequest();
      JSONArray localJSONArray = paramJSONObject.optJSONArray("sourceType");
      String str = paramJSONObject.optString("maxDuration");
      y.i("MicroMsg.JsApiChooseVideo", "doChooseVideo sourceType = %s, maxDuration = %s", new Object[] { localJSONArray, str });
      int i;
      if ((localJSONArray == null) || (localJSONArray.length() == 0))
      {
        localChooseRequest.gvm = true;
        localChooseRequest.gvn = true;
        localChooseRequest.gvV = paramJSONObject.optBoolean("compressed", true);
        if (localChooseRequest.gvm)
        {
          e.a(paramc.getAppId(), new JsApiChooseVideo.3(this, paramc, paramJSONObject, paramInt));
          paramJSONObject = paramc.getContext();
          if ((paramJSONObject != null) && ((paramJSONObject instanceof Activity))) {
            break label304;
          }
          paramc.C(paramInt, h("fail", null));
          i = 0;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label344;
        }
        gvT = true;
        g.a(paramc.getAppId(), new JsApiChooseVideo.1(this, paramc));
        localChooseRequest.maxDuration = bk.getInt(str, 60);
        localChooseRequest.appId = paramc.getAppId();
        com.tencent.mm.plugin.appbrand.ipc.a.b(localContext, localChooseRequest, new JsApiChooseVideo.2(this, paramc, paramInt));
        return;
        localChooseRequest.gvm = localJSONArray.toString().contains("camera");
        localChooseRequest.gvn = localJSONArray.toString().contains("album");
        break;
        boolean bool = com.tencent.mm.pluginsdk.permission.a.a((Activity)paramJSONObject, "android.permission.CAMERA", 115, "", "");
        i = bool;
        if (bool)
        {
          e.vX(paramc.getAppId());
          i = bool;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo
 * JD-Core Version:    0.7.0.1
 */