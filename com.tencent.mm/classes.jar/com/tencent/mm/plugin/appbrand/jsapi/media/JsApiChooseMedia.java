package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseMedia
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 193;
  public static final String NAME = "chooseMedia";
  private static volatile boolean gvC = false;
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (gvC)
    {
      y.e("MicroMsg.JsApiChooseMedia", "chooseMedia sChoosingMedia is true, do not again");
      paramc.C(paramInt, h("cancel", null));
      return;
    }
    Context localContext1 = paramc.getContext();
    if ((localContext1 == null) || (!(localContext1 instanceof Activity)))
    {
      y.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  pageContext is null");
      paramc.C(paramInt, h("fail:page context is null", null));
      return;
    }
    if (paramJSONObject == null)
    {
      y.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  data is null");
      paramc.C(paramInt, h("fail:data is null", null));
      return;
    }
    y.i("MicroMsg.JsApiChooseMedia", "chooseMedia data:" + paramJSONObject.toString());
    String str1 = "";
    if ((paramJSONObject.optJSONArray("sourceType") != null) && (paramJSONObject.optJSONArray("sourceType").length() > 0))
    {
      str1 = paramJSONObject.optJSONArray("sourceType").toString();
      if (!bk.bl(str1)) {
        break label848;
      }
    }
    label205:
    label848:
    for (String str2 = "camera|album";; str2 = str1)
    {
      str1 = "";
      if ((paramJSONObject.optJSONArray("mediaType") != null) && (paramJSONObject.optJSONArray("mediaType").length() > 0))
      {
        str1 = paramJSONObject.optJSONArray("mediaType").toString();
        if (!bk.bl(str1)) {
          break label841;
        }
      }
      for (String str3 = "video|image";; str3 = str1)
      {
        int i = Math.min(paramJSONObject.optInt("maxDuration", 10), 10);
        if ((i < 3) || (i > 10))
        {
          y.e("MicroMsg.JsApiChooseMedia", "maxDuration is invalid");
          i = 10;
        }
        for (;;)
        {
          String str4 = paramJSONObject.optString("camera");
          if (bk.bl(str4)) {
            str4 = "back";
          }
          for (;;)
          {
            int j = Math.min(paramJSONObject.optInt("count", 9), 9);
            str1 = "";
            if ((paramJSONObject.optJSONArray("sizeType") != null) && (paramJSONObject.optJSONArray("sizeType").length() > 0))
            {
              str1 = paramJSONObject.optJSONArray("sizeType").toString();
              if (!bk.bl(str1)) {
                break label832;
              }
              str1 = "original|compressed";
            }
            for (;;)
            {
              y.i("MicroMsg.JsApiChooseMedia", "chooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", new Object[] { str2, str3, Integer.valueOf(i), str4, Integer.valueOf(j), str1 });
              e.b(paramc.getAppId(), new JsApiChooseMedia.3(this, paramc, paramJSONObject, paramInt));
              Context localContext2 = paramc.getContext();
              int k;
              if ((localContext2 == null) || (!(localContext2 instanceof Activity)))
              {
                y.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestAudioPermission pageContext is null");
                paramc.C(paramInt, h("fail", null));
                k = 0;
              }
              boolean bool;
              for (;;)
              {
                if (k != 0) {
                  break label538;
                }
                y.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestAudioPermission is fail");
                return;
                y.e("MicroMsg.JsApiChooseMedia", "sourceType is invalid param");
                break;
                y.e("MicroMsg.JsApiChooseMedia", "mediaType is invalid param");
                break label205;
                y.e("MicroMsg.JsApiChooseMedia", "sizeType is invalid param");
                break label327;
                bool = com.tencent.mm.pluginsdk.permission.a.a((Activity)localContext2, "android.permission.RECORD_AUDIO", 120, "", "");
                k = bool;
                if (bool)
                {
                  e.vX(paramc.getAppId());
                  k = bool;
                }
              }
              e.b(paramc.getAppId(), new JsApiChooseMedia.4(this, paramc, paramJSONObject, paramInt));
              paramJSONObject = paramc.getContext();
              if ((paramJSONObject == null) || (!(paramJSONObject instanceof Activity)))
              {
                y.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestCameraPermission pageContext is null");
                paramc.C(paramInt, h("fail", null));
                k = 0;
              }
              while (k == 0)
              {
                y.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestCameraPermission is fail");
                return;
                bool = com.tencent.mm.pluginsdk.permission.a.a((Activity)paramJSONObject, "android.permission.CAMERA", 119, "", "");
                k = bool;
                if (bool)
                {
                  e.vX(paramc.getAppId());
                  k = bool;
                }
              }
              y.i("MicroMsg.JsApiChooseMedia", "do chooseMedia");
              gvC = true;
              g.a(paramc.getAppId(), new JsApiChooseMedia.1(this, paramc));
              paramJSONObject = new JsApiChooseMedia.ChooseRequest();
              paramJSONObject.appId = paramc.getAppId();
              paramJSONObject.gvE = str2.contains("album");
              paramJSONObject.gvF = str2.contains("camera");
              paramJSONObject.gvG = str3.contains("image");
              paramJSONObject.gvH = str3.contains("video");
              if ((!str4.contains("back")) && (str4.contains("front"))) {}
              for (paramJSONObject.isFront = true;; paramJSONObject.isFront = false)
              {
                paramJSONObject.maxDuration = i;
                paramJSONObject.count = j;
                paramJSONObject.gvo = str1.contains("compressed");
                paramJSONObject.gvp = str1.contains("original");
                com.tencent.mm.plugin.appbrand.ipc.a.a(localContext1, paramJSONObject, new JsApiChooseMedia.2(this, paramc, paramInt));
                return;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia
 * JD-Core Version:    0.7.0.1
 */