package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.utils.c;
import com.tencent.mm.plugin.appbrand.utils.c.a;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddImageToFavorites;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class ao
  extends d<f>
{
  private static final int CTRL_INDEX = 924;
  private static final String NAME = "addImageToFavorites";
  public static final a lyp;
  
  static
  {
    AppMethodBeat.i(228267);
    lyp = new a((byte)0);
    AppMethodBeat.o(228267);
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(228266);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "invoke, env is null");
      AppMethodBeat.o(228266);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "invoke, data is null");
      paramf.i(paramInt, Zf("fail:data is null"));
      AppMethodBeat.o(228266);
      return;
    }
    paramJSONObject = paramJSONObject.optString("url");
    CharSequence localCharSequence = (CharSequence)paramJSONObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "invoke, url is empty");
      paramf.i(paramInt, Zf("fail:url is empty"));
      AppMethodBeat.o(228266);
      return;
    }
    c.a(paramf, paramJSONObject, null, (c.a)new b(this, paramf, paramInt));
    AppMethodBeat.o(228266);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddImageToFavorites$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_KEY_IMAGE_PATH", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "localPath", "", "kotlin.jvm.PlatformType", "onLoad"})
  static final class b
    implements c.a
  {
    b(ao paramao, f paramf, int paramInt) {}
    
    public final void Wz(String paramString)
    {
      AppMethodBeat.i(228265);
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "invoke, url is illegal");
        paramf.i(paramInt, this.lyq.Zf("fail:url is illegal"));
        AppMethodBeat.o(228265);
        return;
      }
      if (!ImgUtil.isImgFile(paramString))
      {
        Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "invoke, " + paramString + " is not image");
        s.deleteFile(paramString);
        paramf.i(paramInt, this.lyq.Zf("fail:url is illegal"));
        AppMethodBeat.o(228265);
        return;
      }
      a.a(paramf.getContext(), (AppBrandProxyUIProcessTask.ProcessRequest)new AddImageToFavoritesRequest(paramString), (AppBrandProxyUIProcessTask.b)new AppBrandProxyUIProcessTask.b() {});
      AppMethodBeat.o(228265);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ao
 * JD-Core Version:    0.7.0.1
 */