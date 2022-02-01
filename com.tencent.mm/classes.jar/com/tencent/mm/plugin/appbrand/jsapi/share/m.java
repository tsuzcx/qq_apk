package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/JsApiShareVideoMessage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class m
  extends c<e>
{
  private static final int CTRL_INDEX = 957;
  private static final String NAME = "shareVideoMessage";
  public static final a pqj;
  
  static
  {
    AppMethodBeat.i(268750);
    pqj = new a((byte)0);
    AppMethodBeat.o(268750);
  }
  
  public final void a(final e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(268749);
    if (parame == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, env is null");
      AppMethodBeat.o(268749);
      return;
    }
    Object localObject2 = parame.getContext();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof Activity)) {
      localObject1 = null;
    }
    localObject2 = (Activity)localObject1;
    if (localObject2 == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, activity is null");
      parame.j(paramInt, agS("fail:activity is null"));
      AppMethodBeat.o(268749);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, data is null");
      parame.j(paramInt, agS("fail:data is null"));
      AppMethodBeat.o(268749);
      return;
    }
    localObject1 = paramJSONObject.optString("videoPath");
    Object localObject3 = (CharSequence)localObject1;
    if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, videoPath is empty");
      parame.j(paramInt, agS("fail:videoPath is empty"));
      AppMethodBeat.o(268749);
      return;
    }
    Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, videoPath: ".concat(String.valueOf(localObject1)));
    localObject3 = parame.getFileSystem();
    if (localObject3 != null)
    {
      localObject1 = ((r)localObject3).adL((String)localObject1);
      if (localObject1 != null)
      {
        localObject1 = ((q)localObject1).bOF();
        localObject3 = (CharSequence)localObject1;
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          break label296;
        }
      }
    }
    label296:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label302;
      }
      Log.w("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, videoPath is illegal");
      parame.j(paramInt, agS("fail:videoPath is illegal"));
      AppMethodBeat.o(268749);
      return;
      localObject1 = null;
      break;
    }
    label302:
    Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, realVideoPath: ".concat(String.valueOf(localObject1)));
    localObject3 = paramJSONObject.optString("thumbPath");
    paramJSONObject = parame.getFileSystem();
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.adL((String)localObject3);
      if (paramJSONObject == null) {}
    }
    for (paramJSONObject = paramJSONObject.bOF();; paramJSONObject = null)
    {
      Log.i("MicroMsg.AppBrand.JsApiShareVideoMessage", "invoke, thumbPath: " + (String)localObject3 + ", realThumbPath: " + paramJSONObject);
      a.a((Context)localObject2, (AppBrandProxyUIProcessTask.ProcessRequest)new ShareVideoToConversationRequest((String)localObject1, paramJSONObject), (AppBrandProxyUIProcessTask.b)new b(this, (Activity)localObject2, parame, paramInt));
      AppMethodBeat.o(268749);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/JsApiShareVideoMessage$Companion;", "", "()V", "CTRL_INDEX", "", "CTRL_INDEX$annotations", "NAME", "", "NAME$annotations", "PARAM_KEY_THUMB_PATH", "PARAM_KEY_VIDEO_PATH", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareToConversationResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
  static final class b<R extends AppBrandProxyUIProcessTask.ProcessResult>
    implements AppBrandProxyUIProcessTask.b<ShareToConversationResult>
  {
    b(m paramm, Activity paramActivity, e parame, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.m
 * JD-Core Version:    0.7.0.1
 */