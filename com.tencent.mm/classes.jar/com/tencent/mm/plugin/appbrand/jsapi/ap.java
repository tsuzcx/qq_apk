package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.b;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.utils.at;
import com.tencent.mm.plugin.appbrand.utils.w;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddImageToFavorites;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "doAddImageToFavorites", "", "activity", "Landroid/app/Activity;", "imgPath", "", "doFavoriteAnyProcess", "", "handleErrorTypeAnyProcess", "", "ret", "invoke", "env", "data", "Lorg/json/JSONObject;", "callbackId", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ap
  extends c<f>
{
  private static final int CTRL_INDEX = 924;
  private static final String NAME = "addImageToFavorites";
  public static final ap.a rxc;
  
  static
  {
    AppMethodBeat.i(325562);
    rxc = new ap.a((byte)0);
    AppMethodBeat.o(325562);
  }
  
  private static final IPCInteger c(IPCString paramIPCString)
  {
    AppMethodBeat.i(325557);
    int i;
    if (paramIPCString == null)
    {
      paramIPCString = null;
      if (paramIPCString != null) {
        break label56;
      }
      i = -2147483648;
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrand.JsApiAddImageToFavorites", s.X("doFavoriteMainProcess, result: ", Integer.valueOf(i)));
      paramIPCString = new IPCInteger(i);
      AppMethodBeat.o(325557);
      return paramIPCString;
      paramIPCString = paramIPCString.value;
      break;
      label56:
      dn localdn = new dn();
      ((af)com.tencent.mm.kernel.h.ax(af.class)).a(localdn, 6, paramIPCString);
      localdn.publish();
      i = localdn.hDs.ret;
      Log.i("MicroMsg.AppBrand.JsApiAddImageToFavorites", s.X("doFavoriteMainProcess, ret: ", Integer.valueOf(i)));
    }
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(325565);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "invoke, env is null");
      AppMethodBeat.o(325565);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "invoke, data is null");
      paramf.callback(paramInt, ZP("fail:data is null"));
      AppMethodBeat.o(325565);
      return;
    }
    paramJSONObject = paramJSONObject.optString("url");
    CharSequence localCharSequence = (CharSequence)paramJSONObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "invoke, url is empty");
      paramf.callback(paramInt, ZP("fail:url is empty"));
      AppMethodBeat.o(325565);
      return;
    }
    s.s(paramJSONObject, "imagePath");
    at.a(paramf, paramJSONObject, (w)new c(paramf, paramInt, this));
    AppMethodBeat.o(325565);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/JsApiAddImageToFavorites$invoke$1", "Lcom/tencent/mm/plugin/appbrand/utils/IPathResolveListener;", "onPathResolve", "", "resolvedPath", "", "isPathCreated", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements w
  {
    c(f paramf, int paramInt, ap paramap) {}
    
    private static final void a(ap paramap, Activity paramActivity, String paramString, f paramf, int paramInt)
    {
      AppMethodBeat.i(325824);
      s.u(paramap, "this$0");
      s.u(paramActivity, "$activity");
      boolean bool = ap.d(paramActivity, paramString);
      Log.i("MicroMsg.AppBrand.JsApiAddImageToFavorites", s.X("invoke, success: ", Boolean.valueOf(bool)));
      if (bool) {}
      for (paramActivity = "ok";; paramActivity = "fail")
      {
        paramf.callback(paramInt, paramap.ZP(paramActivity));
        AppMethodBeat.o(325824);
        return;
      }
    }
    
    public final void aA(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(325833);
      Object localObject = (CharSequence)paramString;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "invoke, url is illegal");
        this.rxd.callback(paramInt, jdField_this.ZP("fail:url is illegal"));
        AppMethodBeat.o(325833);
        return;
      }
      if (!ImgUtil.isImgFile(paramString))
      {
        Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "invoke, " + paramString + " is not image");
        y.deleteFile(paramString);
        this.rxd.callback(paramInt, jdField_this.ZP("fail:url is illegal"));
        AppMethodBeat.o(325833);
        return;
      }
      localObject = this.rxd.getContext();
      if ((localObject instanceof Activity))
      {
        localObject = (Activity)localObject;
        com.tencent.threadpool.h.ahAA.bm(new ap.c..ExternalSyntheticLambda0(jdField_this, (Activity)localObject, paramString, this.rxd, paramInt));
        AppMethodBeat.o(325833);
        return;
      }
      Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "invoke, activity is null");
      this.rxd.callback(paramInt, jdField_this.ZP("fail:activity is null"));
      AppMethodBeat.o(325833);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ap
 * JD-Core Version:    0.7.0.1
 */