package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.a.a;
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

public final class JsApiChooseMedia
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 193;
  public static final String NAME = "chooseMedia";
  private static volatile boolean hQT = false;
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(131213);
    if (hQT)
    {
      ab.e("MicroMsg.JsApiChooseMedia", "chooseMedia sChoosingMedia is true, do not again");
      paramc.h(paramInt, j("cancel", null));
      AppMethodBeat.o(131213);
      return;
    }
    Context localContext1 = paramc.getContext();
    if ((localContext1 == null) || (!(localContext1 instanceof Activity)))
    {
      ab.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  pageContext is null");
      paramc.h(paramInt, j("fail:page context is null", null));
      AppMethodBeat.o(131213);
      return;
    }
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  data is null");
      paramc.h(paramInt, j("fail:data is null", null));
      AppMethodBeat.o(131213);
      return;
    }
    ab.i("MicroMsg.JsApiChooseMedia", "chooseMedia data:" + paramJSONObject.toString());
    String str1 = "";
    if ((paramJSONObject.optJSONArray("sourceType") != null) && (paramJSONObject.optJSONArray("sourceType").length() > 0))
    {
      str1 = paramJSONObject.optJSONArray("sourceType").toString();
      if (!bo.isNullOrNil(str1)) {
        break label883;
      }
    }
    label225:
    label867:
    label876:
    label883:
    for (String str2 = "camera|album";; str2 = str1)
    {
      str1 = "";
      if ((paramJSONObject.optJSONArray("mediaType") != null) && (paramJSONObject.optJSONArray("mediaType").length() > 0))
      {
        str1 = paramJSONObject.optJSONArray("mediaType").toString();
        if (!bo.isNullOrNil(str1)) {
          break label876;
        }
      }
      for (String str3 = "video|image";; str3 = str1)
      {
        int i = Math.min(paramJSONObject.optInt("maxDuration", 10), 10);
        if ((i < 3) || (i > 10))
        {
          ab.e("MicroMsg.JsApiChooseMedia", "maxDuration is invalid");
          i = 10;
        }
        for (;;)
        {
          String str4 = paramJSONObject.optString("camera");
          if (bo.isNullOrNil(str4)) {
            str4 = "back";
          }
          for (;;)
          {
            int j = Math.min(paramJSONObject.optInt("count", 9), 9);
            str1 = "";
            if ((paramJSONObject.optJSONArray("sizeType") != null) && (paramJSONObject.optJSONArray("sizeType").length() > 0))
            {
              str1 = paramJSONObject.optJSONArray("sizeType").toString();
              if (!bo.isNullOrNil(str1)) {
                break label867;
              }
              str1 = "original|compressed";
            }
            for (;;)
            {
              ab.i("MicroMsg.JsApiChooseMedia", "chooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", new Object[] { str2, str3, Integer.valueOf(i), str4, Integer.valueOf(j), str1 });
              n.b(paramc.getAppId(), new JsApiChooseMedia.3(this, paramc, paramJSONObject, paramInt));
              Context localContext2 = paramc.getContext();
              int k;
              if ((localContext2 == null) || (!(localContext2 instanceof Activity)))
              {
                ab.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestAudioPermission pageContext is null");
                paramc.h(paramInt, j("fail", null));
                k = 0;
              }
              boolean bool;
              for (;;)
              {
                if (k != 0) {
                  break label563;
                }
                ab.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestAudioPermission is fail");
                AppMethodBeat.o(131213);
                return;
                ab.e("MicroMsg.JsApiChooseMedia", "sourceType is invalid param");
                break;
                ab.e("MicroMsg.JsApiChooseMedia", "mediaType is invalid param");
                break label225;
                ab.e("MicroMsg.JsApiChooseMedia", "sizeType is invalid param");
                break label347;
                bool = b.a((Activity)localContext2, "android.permission.RECORD_AUDIO", 120, "", "");
                k = bool;
                if (bool)
                {
                  n.EA(paramc.getAppId());
                  k = bool;
                }
              }
              n.b(paramc.getAppId(), new a.a()
              {
                public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
                {
                  AppMethodBeat.i(131157);
                  if (paramAnonymousInt != 119)
                  {
                    ab.e("MicroMsg.JsApiChooseMedia", "requestCameraPermission requestCode is not for choose media");
                    AppMethodBeat.o(131157);
                    return;
                  }
                  if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
                  {
                    ab.i("MicroMsg.JsApiChooseMedia", "requestCameraPermission permission is grant for choose media");
                    JsApiChooseMedia.this.a(paramc, paramJSONObject, paramInt);
                    AppMethodBeat.o(131157);
                    return;
                  }
                  ab.e("MicroMsg.JsApiChooseMedia", "requestCameraPermission sys perm denied for choose media");
                  paramc.h(paramInt, JsApiChooseMedia.this.j("fail:system permission denied", null));
                  AppMethodBeat.o(131157);
                }
              });
              paramJSONObject = paramc.getContext();
              if ((paramJSONObject == null) || (!(paramJSONObject instanceof Activity)))
              {
                ab.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestCameraPermission pageContext is null");
                paramc.h(paramInt, j("fail", null));
                k = 0;
              }
              while (k == 0)
              {
                ab.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestCameraPermission is fail");
                AppMethodBeat.o(131213);
                return;
                bool = b.a((Activity)paramJSONObject, "android.permission.CAMERA", 119, "", "");
                k = bool;
                if (bool)
                {
                  n.EA(paramc.getAppId());
                  k = bool;
                }
              }
              ab.i("MicroMsg.JsApiChooseMedia", "do chooseMedia");
              hQT = true;
              e.a(paramc.getAppId(), new JsApiChooseMedia.1(this, paramc));
              paramJSONObject = new JsApiChooseMedia.ChooseRequest();
              paramJSONObject.appId = paramc.getAppId();
              paramJSONObject.hQV = str2.contains("album");
              paramJSONObject.hQW = str2.contains("camera");
              paramJSONObject.hQX = str3.contains("image");
              paramJSONObject.hQY = str3.contains("video");
              if ((!str4.contains("back")) && (str4.contains("front"))) {}
              for (paramJSONObject.isFront = true;; paramJSONObject.isFront = false)
              {
                paramJSONObject.maxDuration = i;
                paramJSONObject.count = j;
                paramJSONObject.hQF = str1.contains("compressed");
                paramJSONObject.hQG = str1.contains("original");
                com.tencent.mm.plugin.appbrand.ipc.a.a(localContext1, paramJSONObject, new JsApiChooseMedia.2(this, paramc, paramInt));
                AppMethodBeat.o(131213);
                return;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia
 * JD-Core Version:    0.7.0.1
 */