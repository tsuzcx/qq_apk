package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/JsApiShareFileMessage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class i
  extends com.tencent.mm.plugin.appbrand.jsapi.d<f>
{
  private static final int CTRL_INDEX = 956;
  private static final String NAME = "shareFileMessage";
  public static final a mrK;
  
  static
  {
    AppMethodBeat.i(228522);
    mrK = new a((byte)0);
    AppMethodBeat.o(228522);
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(228521);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, env is null");
      AppMethodBeat.o(228521);
      return;
    }
    Object localObject2 = paramf.getContext();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof Activity)) {
      localObject1 = null;
    }
    Activity localActivity = (Activity)localObject1;
    if (localActivity == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, activity is null");
      paramf.i(paramInt, Zf("fail:activity is null"));
      AppMethodBeat.o(228521);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, data is null");
      paramf.i(paramInt, Zf("fail:data is null"));
      AppMethodBeat.o(228521);
      return;
    }
    localObject1 = paramJSONObject.optString("filePath");
    localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, filePath is empty");
      paramf.i(paramInt, Zf("fail:filePath is empty"));
      AppMethodBeat.o(228521);
      return;
    }
    Object localObject3;
    if (n.J((String)localObject1, "wxfile://", false))
    {
      localObject2 = org.apache.commons.a.d.getExtension((String)localObject1);
      Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, filePath: " + (String)localObject1 + ", fileExt: " + (String)localObject2);
      localObject3 = paramf.getFileSystem();
      if (localObject3 == null) {
        break label428;
      }
      localObject3 = ((q)localObject3).VY((String)localObject1);
      if (localObject3 == null) {
        break label428;
      }
      if (n.J((String)localObject1, "wxfile://", false)) {
        break label411;
      }
      localObject1 = paramf.getFileSystem();
      if (localObject1 == null) {
        break label405;
      }
      p.g(localObject3, "realFile");
      localObject1 = ((q)localObject1).Wa(((o)localObject3).getName());
      if (localObject1 == null) {
        break label405;
      }
      if (!((o)localObject3).am((o)localObject1)) {
        break label399;
      }
      p.g(localObject1, "newFile");
      localObject1 = ((o)localObject1).getAbsolutePath();
      label336:
      localObject3 = (CharSequence)localObject1;
      if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
        break label434;
      }
    }
    label399:
    label405:
    label411:
    label428:
    label434:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label440;
      }
      Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, filePath is illegal");
      paramf.i(paramInt, Zf("fail:filePath is illegal"));
      AppMethodBeat.o(228521);
      return;
      localObject2 = "";
      break;
      localObject1 = null;
      break label336;
      localObject1 = null;
      break label336;
      p.g(localObject3, "realFile");
      localObject1 = ((o)localObject3).getAbsolutePath();
      break label336;
      localObject1 = null;
      break label336;
    }
    label440:
    Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, realFilePath: ".concat(String.valueOf(localObject1)));
    paramJSONObject = paramJSONObject.optString("fileName");
    Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, fileName: ".concat(String.valueOf(paramJSONObject)));
    a.a((Context)localActivity, (AppBrandProxyUIProcessTask.ProcessRequest)new ShareFileToConversationRequest((String)localObject1, (String)localObject2, paramJSONObject), (AppBrandProxyUIProcessTask.b)new i.b(this, paramf, paramInt));
    AppMethodBeat.o(228521);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/JsApiShareFileMessage$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_KEY_FILE_NAME", "PARAM_KEY_FILE_PATH", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.i
 * JD-Core Version:    0.7.0.1
 */