package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseImage
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 29;
  public static final String NAME = "chooseImage";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (m.qH(paramc.getAppId()).fzz)
    {
      paramc.C(paramInt, h("cancel", null));
      return;
    }
    Context localContext = paramc.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      paramc.C(paramInt, h("fail", null));
      return;
    }
    JsApiChooseImage.ChooseRequest localChooseRequest = new JsApiChooseImage.ChooseRequest();
    JSONArray localJSONArray = paramJSONObject.optJSONArray("sourceType");
    String str1 = paramJSONObject.optString("sizeType");
    String str2 = paramJSONObject.optString("count");
    y.i("MicroMsg.JsApiChooseImage", "doChooseImage sourceType = %s, sizeType = %s, count = %s", new Object[] { localJSONArray, str1, str2 });
    label150:
    int i;
    if ((localJSONArray == null) || (localJSONArray.length() == 0))
    {
      localChooseRequest.gvm = true;
      localChooseRequest.gvn = true;
      if (localChooseRequest.gvm)
      {
        e.b(paramc.getAppId(), new JsApiChooseImage.3(this, paramc, paramJSONObject, paramInt));
        paramJSONObject = paramc.getContext();
        if ((paramJSONObject != null) && ((paramJSONObject instanceof Activity))) {
          break label356;
        }
        paramc.C(paramInt, h("fail", null));
        i = 0;
        label213:
        if (i == 0) {
          break label396;
        }
      }
      m.qI(paramc.getAppId()).fzz = true;
      g.a(paramc.getAppId(), new JsApiChooseImage.1(this, paramc));
      if (!bk.bl(str1)) {
        break label398;
      }
    }
    label396:
    label398:
    for (paramJSONObject = "compressed";; paramJSONObject = str1)
    {
      localChooseRequest.gvo = paramJSONObject.contains("compressed");
      localChooseRequest.gvp = paramJSONObject.contains("original");
      localChooseRequest.count = bk.getInt(str2, 9);
      localChooseRequest.appId = paramc.getAppId();
      com.tencent.mm.plugin.appbrand.ipc.a.b(localContext, localChooseRequest, new JsApiChooseImage.2(this, paramc, paramInt));
      return;
      localChooseRequest.gvm = localJSONArray.toString().contains("camera");
      localChooseRequest.gvn = localJSONArray.toString().contains("album");
      break label150;
      label356:
      boolean bool = com.tencent.mm.pluginsdk.permission.a.a((Activity)paramJSONObject, "android.permission.CAMERA", 113, "", "");
      i = bool;
      if (!bool) {
        break label213;
      }
      e.vX(paramc.getAppId());
      i = bool;
      break label213;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage
 * JD-Core Version:    0.7.0.1
 */