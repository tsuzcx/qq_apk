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
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddVideoToFavorites;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class ap
  extends d<f>
{
  private static final int CTRL_INDEX = 959;
  private static final String NAME = "addVideoToFavorites";
  public static final a lyI;
  
  static
  {
    AppMethodBeat.i(228270);
    lyI = new a((byte)0);
    AppMethodBeat.o(228270);
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(228269);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, env is null");
      AppMethodBeat.o(228269);
      return;
    }
    Object localObject3 = paramf.getContext();
    Object localObject1 = localObject3;
    if (!(localObject3 instanceof Activity)) {
      localObject1 = null;
    }
    if ((Activity)localObject1 == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, activity is null");
      paramf.i(paramInt, Zf("fail:activity is null"));
      AppMethodBeat.o(228269);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, data is null");
      paramf.i(paramInt, Zf("fail:data is null"));
      AppMethodBeat.o(228269);
      return;
    }
    localObject1 = paramJSONObject.optString("videoPath");
    localObject3 = (CharSequence)localObject1;
    if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, videoPath is empty");
      paramf.i(paramInt, Zf("fail:videoPath is empty"));
      AppMethodBeat.o(228269);
      return;
    }
    Log.i("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, videoPath: ".concat(String.valueOf(localObject1)));
    localObject3 = paramf.getFileSystem();
    if (localObject3 != null)
    {
      localObject1 = ((q)localObject3).VY((String)localObject1);
      if (localObject1 != null)
      {
        localObject1 = ((o)localObject1).getAbsolutePath();
        localObject3 = (CharSequence)localObject1;
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          break label295;
        }
      }
    }
    label295:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label301;
      }
      Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, videoPath is illegal");
      paramf.i(paramInt, Zf("fail:videoPath is illegal"));
      AppMethodBeat.o(228269);
      return;
      localObject1 = null;
      break;
    }
    label301:
    Log.i("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, realVideoPath: ".concat(String.valueOf(localObject1)));
    localObject3 = paramJSONObject.optString("thumbPath");
    Object localObject4 = paramf.getFileSystem();
    paramJSONObject = localObject2;
    if (localObject4 != null)
    {
      localObject4 = ((q)localObject4).VY((String)localObject3);
      paramJSONObject = localObject2;
      if (localObject4 != null) {
        paramJSONObject = ((o)localObject4).getAbsolutePath();
      }
    }
    Log.i("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, thumbPath: " + (String)localObject3 + ", realThumbPath: " + paramJSONObject);
    a.a(paramf.getContext(), (AppBrandProxyUIProcessTask.ProcessRequest)new AddVideoToFavoritesRequest((String)localObject1, paramJSONObject), (AppBrandProxyUIProcessTask.b)new b(this, paramf, paramInt));
    AppMethodBeat.o(228269);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddVideoToFavorites$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_KEY_THUMB_PATH", "PARAM_KEY_VIDEO_PATH", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/AddToFavoritesResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
  static final class b<R extends AppBrandProxyUIProcessTask.ProcessResult>
    implements AppBrandProxyUIProcessTask.b<AddToFavoritesResult>
  {
    b(ap paramap, f paramf, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ap
 * JD-Core Version:    0.7.0.1
 */