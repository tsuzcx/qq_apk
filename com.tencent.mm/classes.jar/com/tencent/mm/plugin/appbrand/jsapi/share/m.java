package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/JsApiShareVideoMessage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class m
  extends d<f>
{
  private static final int CTRL_INDEX = 957;
  private static final String NAME = "shareVideoMessage";
  public static final a msa;
  
  static
  {
    AppMethodBeat.i(228526);
    msa = new a((byte)0);
    AppMethodBeat.o(228526);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(228525);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, env is null");
      AppMethodBeat.o(228525);
      return;
    }
    Object localObject3 = paramf.getContext();
    Object localObject1 = localObject3;
    if (!(localObject3 instanceof Activity)) {
      localObject1 = null;
    }
    localObject3 = (Activity)localObject1;
    if (localObject3 == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, activity is null");
      paramf.i(paramInt, Zf("fail:activity is null"));
      AppMethodBeat.o(228525);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, data is null");
      paramf.i(paramInt, Zf("fail:data is null"));
      AppMethodBeat.o(228525);
      return;
    }
    localObject1 = paramJSONObject.optString("videoPath");
    Object localObject4 = (CharSequence)localObject1;
    if ((localObject4 == null) || (((CharSequence)localObject4).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, videoPath is empty");
      paramf.i(paramInt, Zf("fail:videoPath is empty"));
      AppMethodBeat.o(228525);
      return;
    }
    Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, videoPath: ".concat(String.valueOf(localObject1)));
    localObject4 = paramf.getFileSystem();
    if (localObject4 != null)
    {
      localObject1 = ((q)localObject4).VY((String)localObject1);
      if (localObject1 != null)
      {
        localObject1 = ((o)localObject1).getAbsolutePath();
        localObject4 = (CharSequence)localObject1;
        if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
          break label299;
        }
      }
    }
    label299:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label305;
      }
      Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, videoPath is illegal");
      paramf.i(paramInt, Zf("fail:videoPath is illegal"));
      AppMethodBeat.o(228525);
      return;
      localObject1 = null;
      break;
    }
    label305:
    Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, realVideoPath: ".concat(String.valueOf(localObject1)));
    localObject4 = paramJSONObject.optString("thumbPath");
    Object localObject5 = paramf.getFileSystem();
    paramJSONObject = localObject2;
    if (localObject5 != null)
    {
      localObject5 = ((q)localObject5).VY((String)localObject4);
      paramJSONObject = localObject2;
      if (localObject5 != null) {
        paramJSONObject = ((o)localObject5).getAbsolutePath();
      }
    }
    Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, thumbPath: " + (String)localObject4 + ", realThumbPath: " + paramJSONObject);
    a.a((Context)localObject3, (AppBrandProxyUIProcessTask.ProcessRequest)new ShareVideoToConversationRequest((String)localObject1, paramJSONObject), (AppBrandProxyUIProcessTask.b)new m.b(this, paramf, paramInt));
    AppMethodBeat.o(228525);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/JsApiShareVideoMessage$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_KEY_THUMB_PATH", "PARAM_KEY_VIDEO_PATH", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.m
 * JD-Core Version:    0.7.0.1
 */