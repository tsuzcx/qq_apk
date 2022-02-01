package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.a.dn.b;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddVideoToFavorites;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "doAddVideoToFavorites", "", "activity", "Landroid/app/Activity;", "videoPath", "", "thumbPath", "doFavoriteAnyProcess", "", "handleErrorTypeAnyProcess", "", "ret", "invoke", "env", "data", "Lorg/json/JSONObject;", "callbackId", "Companion", "DoFavoriteParams", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class JsApiAddVideoToFavorites
  extends c<f>
{
  private static final int CTRL_INDEX = 959;
  private static final String NAME = "addVideoToFavorites";
  public static final JsApiAddVideoToFavorites.a rxw;
  
  static
  {
    AppMethodBeat.i(325449);
    rxw = new JsApiAddVideoToFavorites.a((byte)0);
    AppMethodBeat.o(325449);
  }
  
  private static final IPCInteger a(JsApiAddVideoToFavorites.DoFavoriteParams paramDoFavoriteParams)
  {
    AppMethodBeat.i(325446);
    for (;;)
    {
      try
      {
        str1 = paramDoFavoriteParams.videoPath;
        str2 = paramDoFavoriteParams.thumbPath;
        paramDoFavoriteParams = new com.tencent.mm.autogen.a.dn();
        j = dn.ZT(str1);
        if (j > 0) {
          continue;
        }
        Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", s.X("doFavoriteMainProcess, durationS: ", Integer.valueOf(j)));
        i = -2147483648;
      }
      catch (Exception paramDoFavoriteParams)
      {
        String str1;
        String str2;
        int j;
        CharSequence localCharSequence;
        Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", s.X("doFavoriteMainProcess, fail since ", paramDoFavoriteParams));
        int i = -2147483648;
        continue;
        i = 1;
        continue;
        i = 0;
        continue;
      }
      Log.i("MicroMsg.AppBrand.JsApiAddVideoToFavorites", s.X("doFavoriteMainProcess, result: ", Integer.valueOf(i)));
      paramDoFavoriteParams = new IPCInteger(i);
      AppMethodBeat.o(325446);
      return paramDoFavoriteParams;
      str2 = dn.dO(str1, str2);
      localCharSequence = (CharSequence)str2;
      if (localCharSequence == null) {
        continue;
      }
      if (localCharSequence.length() != 0) {
        continue;
      }
      continue;
      if (i != 0)
      {
        Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "doFavoriteMainProcess, thumbPath is empty");
        i = -2147483648;
      }
      else
      {
        ((af)com.tencent.mm.kernel.h.ax(af.class)).a(paramDoFavoriteParams, str1, str2, j, "", "");
        paramDoFavoriteParams.publish();
        i = paramDoFavoriteParams.hDs.ret;
        Log.i("MicroMsg.AppBrand.JsApiAddVideoToFavorites", s.X("doFavoriteMainProcess, ret: ", Integer.valueOf(i)));
      }
    }
  }
  
  private static final void a(JsApiAddVideoToFavorites paramJsApiAddVideoToFavorites, Activity paramActivity, String paramString1, String paramString2, f paramf, int paramInt)
  {
    AppMethodBeat.i(325441);
    s.u(paramJsApiAddVideoToFavorites, "this$0");
    paramString1 = (IPCInteger)com.tencent.mm.ipcinvoker.wx_extension.b.a.a(new JsApiAddVideoToFavorites.DoFavoriteParams(paramString1, paramString2), JsApiAddVideoToFavorites..ExternalSyntheticLambda0.INSTANCE);
    int i;
    label55:
    boolean bool;
    if (paramString1 == null)
    {
      paramString1 = null;
      Log.i("MicroMsg.AppBrand.JsApiAddVideoToFavorites", s.X("doFavoriteAnyProcess, result: ", paramString1));
      if (paramString1 != null) {
        break label133;
      }
      i = -2147483648;
      d.uiThread((kotlin.g.a.a)new JsApiAddVideoToFavorites.b(i, paramActivity));
      if (i != 0) {
        break label142;
      }
      bool = true;
      label79:
      Log.i("MicroMsg.AppBrand.JsApiAddVideoToFavorites", s.X("invoke, success: ", Boolean.valueOf(bool)));
      if (!bool) {
        break label148;
      }
    }
    label133:
    label142:
    label148:
    for (paramActivity = "ok";; paramActivity = "fail")
    {
      paramf.callback(paramInt, paramJsApiAddVideoToFavorites.ZP(paramActivity));
      AppMethodBeat.o(325441);
      return;
      paramString1 = Integer.valueOf(paramString1.value);
      break;
      i = paramString1.intValue();
      break label55;
      bool = false;
      break label79;
    }
  }
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(325466);
    if (paramf == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, env is null");
      AppMethodBeat.o(325466);
      return;
    }
    Object localObject1 = paramf.getContext();
    if ((localObject1 instanceof Activity)) {}
    for (Activity localActivity = (Activity)localObject1; localActivity == null; localActivity = null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, activity is null");
      paramf.callback(paramInt, ZP("fail:activity is null"));
      AppMethodBeat.o(325466);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, data is null");
      paramf.callback(paramInt, ZP("fail:data is null"));
      AppMethodBeat.o(325466);
      return;
    }
    localObject1 = paramJSONObject.optString("videoPath");
    Object localObject3 = (CharSequence)localObject1;
    if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, videoPath is empty");
      paramf.callback(paramInt, ZP("fail:videoPath is empty"));
      AppMethodBeat.o(325466);
      return;
    }
    Log.i("MicroMsg.AppBrand.JsApiAddVideoToFavorites", s.X("invoke, videoPath: ", localObject1));
    localObject3 = paramf.getFileSystem();
    if (localObject3 == null)
    {
      localObject1 = null;
      localObject3 = (CharSequence)localObject1;
      if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
        break label308;
      }
    }
    label308:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label314;
      }
      Log.w("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, videoPath is illegal");
      paramf.callback(paramInt, ZP("fail:videoPath is illegal"));
      AppMethodBeat.o(325466);
      return;
      localObject1 = ((w)localObject3).Wm((String)localObject1);
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ah.v(((u)localObject1).jKT());
      break;
    }
    label314:
    Log.i("MicroMsg.AppBrand.JsApiAddVideoToFavorites", s.X("invoke, realVideoPath: ", localObject1));
    localObject3 = paramJSONObject.optString("thumbPath");
    paramJSONObject = paramf.getFileSystem();
    if (paramJSONObject == null) {
      paramJSONObject = localObject2;
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrand.JsApiAddVideoToFavorites", "invoke, thumbPath: " + localObject3 + ", realThumbPath: " + paramJSONObject);
      com.tencent.threadpool.h.ahAA.bm(new JsApiAddVideoToFavorites..ExternalSyntheticLambda1(this, localActivity, (String)localObject1, paramJSONObject, paramf, paramInt));
      AppMethodBeat.o(325466);
      return;
      u localu = paramJSONObject.Wm((String)localObject3);
      paramJSONObject = localObject2;
      if (localu != null) {
        paramJSONObject = ah.v(localu.jKT());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddVideoToFavorites
 * JD-Core Version:    0.7.0.1
 */