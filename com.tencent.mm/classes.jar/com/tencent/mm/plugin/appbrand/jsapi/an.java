package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddFileToFavorites;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class an
  extends d<f>
{
  private static final int CTRL_INDEX = 958;
  private static final String NAME = "addFileToFavorites";
  public static final a lyl;
  
  static
  {
    AppMethodBeat.i(228263);
    lyl = new a((byte)0);
    AppMethodBeat.o(228263);
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(228262);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, env is null");
      AppMethodBeat.o(228262);
      return;
    }
    Object localObject2 = paramf.getContext();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof Activity)) {
      localObject1 = null;
    }
    if ((Activity)localObject1 == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, activity is null");
      paramf.i(paramInt, Zf("fail:activity is null"));
      AppMethodBeat.o(228262);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, data is null");
      paramf.i(paramInt, Zf("fail:data is null"));
      AppMethodBeat.o(228262);
      return;
    }
    localObject2 = paramJSONObject.optString("filePath");
    localObject1 = (CharSequence)localObject2;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, filePath is empty");
      paramf.i(paramInt, Zf("fail:filePath is empty"));
      AppMethodBeat.o(228262);
      return;
    }
    if (n.J((String)localObject2, "wxfile://", false))
    {
      localObject1 = org.apache.commons.a.d.getExtension((String)localObject2);
      Log.i("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, filePath: " + (String)localObject2 + ", fileExt: " + (String)localObject1);
      Object localObject3 = paramf.getFileSystem();
      if (localObject3 == null) {
        break label328;
      }
      localObject2 = ((q)localObject3).VY((String)localObject2);
      if (localObject2 == null) {
        break label328;
      }
      localObject2 = ((o)localObject2).getAbsolutePath();
      label265:
      localObject3 = (CharSequence)localObject2;
      if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
        break label334;
      }
    }
    label328:
    label334:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label340;
      }
      Log.w("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, filePath is illegal");
      paramf.i(paramInt, Zf("fail:filePath is illegal"));
      AppMethodBeat.o(228262);
      return;
      localObject1 = "";
      break;
      localObject2 = null;
      break label265;
    }
    label340:
    Log.i("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, realFilePath: ".concat(String.valueOf(localObject2)));
    paramJSONObject = paramJSONObject.optString("fileName");
    Log.i("MicroMsg.AppBrand.JsApiAddFileToFavorites", "invoke, fileName: ".concat(String.valueOf(paramJSONObject)));
    a.a(paramf.getContext(), (AppBrandProxyUIProcessTask.ProcessRequest)new AddFileToFavoritesRequest((String)localObject2, (String)localObject1, paramJSONObject), (AppBrandProxyUIProcessTask.b)new b(this, paramf, paramInt));
    AppMethodBeat.o(228262);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddFileToFavorites$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_KEY_FILE_NAME", "PARAM_KEY_FILE_PATH", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/AddToFavoritesResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
  static final class b<R extends AppBrandProxyUIProcessTask.ProcessResult>
    implements AppBrandProxyUIProcessTask.b<AddToFavoritesResult>
  {
    b(an paraman, f paramf, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.an
 * JD-Core Version:    0.7.0.1
 */