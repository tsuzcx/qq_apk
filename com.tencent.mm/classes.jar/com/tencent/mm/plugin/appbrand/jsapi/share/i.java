package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/JsApiShareFileMessage;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class i
  extends com.tencent.mm.plugin.appbrand.jsapi.c<e>
{
  private static final int CTRL_INDEX = 956;
  private static final String NAME = "shareFileMessage";
  public static final a ppS;
  
  static
  {
    AppMethodBeat.i(279619);
    ppS = new a((byte)0);
    AppMethodBeat.o(279619);
  }
  
  public final void a(final e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(279618);
    if (parame == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, env is null");
      AppMethodBeat.o(279618);
      return;
    }
    Object localObject2 = parame.getContext();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof Activity)) {
      localObject1 = null;
    }
    final Activity localActivity = (Activity)localObject1;
    if (localActivity == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, activity is null");
      parame.j(paramInt, agS("fail:activity is null"));
      AppMethodBeat.o(279618);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, data is null");
      parame.j(paramInt, agS("fail:data is null"));
      AppMethodBeat.o(279618);
      return;
    }
    localObject1 = paramJSONObject.optString("filePath");
    localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, filePath is empty");
      parame.j(paramInt, agS("fail:filePath is empty"));
      AppMethodBeat.o(279618);
      return;
    }
    Object localObject3;
    if (n.M((String)localObject1, "wxfile://", false))
    {
      localObject2 = org.apache.commons.a.c.bIf((String)localObject1);
      Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, filePath: " + (String)localObject1 + ", fileExt: " + (String)localObject2);
      localObject3 = parame.getFileSystem();
      if (localObject3 == null) {
        break label438;
      }
      localObject3 = ((r)localObject3).adL((String)localObject1);
      if (localObject3 == null) {
        break label438;
      }
      if (n.M((String)localObject1, "wxfile://", false)) {
        break label421;
      }
      localObject1 = parame.getFileSystem();
      if (localObject1 == null) {
        break label415;
      }
      p.j(localObject3, "realFile");
      localObject1 = ((r)localObject1).adN(((q)localObject3).getName());
      if (localObject1 == null) {
        break label415;
      }
      localObject3 = ((q)localObject3).bOF();
      p.j(localObject1, "newFile");
      if (!u.oo((String)localObject3, ((q)localObject1).bOF())) {
        break label409;
      }
      localObject1 = ((q)localObject1).bOF();
      label346:
      localObject3 = (CharSequence)localObject1;
      if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
        break label444;
      }
    }
    label409:
    label415:
    label421:
    label438:
    label444:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label450;
      }
      Log.w("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, filePath is illegal");
      parame.j(paramInt, agS("fail:filePath is illegal"));
      AppMethodBeat.o(279618);
      return;
      localObject2 = "";
      break;
      localObject1 = null;
      break label346;
      localObject1 = null;
      break label346;
      p.j(localObject3, "realFile");
      localObject1 = ((q)localObject3).bOF();
      break label346;
      localObject1 = null;
      break label346;
    }
    label450:
    Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, realFilePath: ".concat(String.valueOf(localObject1)));
    paramJSONObject = paramJSONObject.optString("fileName");
    Log.i("MicroMsg.AppBrand.JsApiShareFileMessage", "invoke, fileName: ".concat(String.valueOf(paramJSONObject)));
    a.a((Context)localActivity, (AppBrandProxyUIProcessTask.ProcessRequest)new ShareFileToConversationRequest((String)localObject1, (String)localObject2, paramJSONObject), (AppBrandProxyUIProcessTask.b)new b(this, localActivity, parame, paramInt));
    AppMethodBeat.o(279618);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/share/JsApiShareFileMessage$Companion;", "", "()V", "CTRL_INDEX", "", "CTRL_INDEX$annotations", "NAME", "", "NAME$annotations", "PARAM_KEY_FILE_NAME", "PARAM_KEY_FILE_PATH", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareToConversationResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
  static final class b<R extends AppBrandProxyUIProcessTask.ProcessResult>
    implements AppBrandProxyUIProcessTask.b<ShareToConversationResult>
  {
    b(i parami, Activity paramActivity, e parame, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.i
 * JD-Core Version:    0.7.0.1
 */