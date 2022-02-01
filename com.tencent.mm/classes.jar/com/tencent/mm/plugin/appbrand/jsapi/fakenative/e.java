package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.bg;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.ui.b.a.b.a;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vfs.u;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiSaveSplashScreenshot;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "saveSplashScreenshot";
  public static final a rWP;
  
  static
  {
    AppMethodBeat.i(326596);
    rWP = new a((byte)0);
    AppMethodBeat.o(326596);
  }
  
  private static final Bitmap a(w paramw, com.tencent.mm.plugin.appbrand.service.c paramc, int paramInt, e parame, Void paramVoid)
  {
    AppMethodBeat.i(326584);
    s.u(paramw, "$runtime");
    s.u(parame, "this$0");
    paramw = bg.J((AppBrandRuntime)paramw);
    if ((paramw == null) || (paramw.isRecycled()))
    {
      g.jJL().gM(null);
      Log.e("MicroMsg.AppBrand.JsApiSaveRuntimeSnapshot", s.X("save failed, appId=", paramc.getAppId()));
      paramc.callback(paramInt, parame.ZP("fail"));
    }
    AppMethodBeat.o(326584);
    return paramw;
  }
  
  private static final ah a(w paramw, com.tencent.mm.plugin.appbrand.service.c paramc, int paramInt, e parame, Bitmap paramBitmap)
  {
    AppMethodBeat.i(326595);
    s.u(paramw, "$runtime");
    s.u(parame, "this$0");
    Object localObject1 = com.tencent.mm.plugin.appbrand.ui.b.a.b.upH;
    Object localObject2 = paramw.getInitConfig();
    s.s(localObject2, "runtime.initConfig");
    s.u(localObject2, "config");
    StringBuilder localStringBuilder = new StringBuilder().append(((AppBrandInitConfigWC)localObject2).appId).append('_').append(((AppBrandInitConfig)localObject2).eul).append('_').append(((AppBrandInitConfigWC)localObject2).appVersion).append('_');
    if (aw.isDarkMode()) {}
    for (localObject1 = "dark";; localObject1 = "normal")
    {
      localObject1 = (String)localObject1 + '_' + Util.nowMilliSecond() + ".png";
      localObject2 = ((AppBrandInitConfigWC)localObject2).appId;
      s.s(localObject2, "config.appId");
      localObject1 = new u(b.a.agr((String)localObject2), (String)localObject1);
      localObject2 = ((u)localObject1).jKP();
      if (localObject2 != null) {
        ((u)localObject2).jKY();
      }
      localObject1 = ((u)localObject1).toString();
      s.s(localObject1, "VFSFile(generateDir(conf…le?.mkdirs() }.toString()");
      s.checkNotNull(paramBitmap);
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, (String)localObject1, true);
      Log.i("MicroMsg.AppBrand.JsApiSaveRuntimeSnapshot", "saveBitmap ok, appId=" + paramc.getAppId() + ", path=" + (String)localObject1);
      paramBitmap = new com.tencent.mm.plugin.appbrand.ui.b.a.a();
      paramBitmap.field_appId = paramw.mAppId;
      paramBitmap.field_versionType = paramw.qsh.eul;
      paramBitmap.field_appVersion = paramw.asw();
      paramBitmap.field_isDarkMode = aw.isDarkMode();
      paramBitmap.field_screenshotFilePath = ((String)localObject1);
      com.tencent.mm.ipcinvoker.wx_extension.b.a.a(paramBitmap, e..ExternalSyntheticLambda0.INSTANCE, new e..ExternalSyntheticLambda1(paramc, paramInt, parame, (String)localObject1));
      paramw = ah.aiuX;
      AppMethodBeat.o(326595);
      return paramw;
    }
  }
  
  private static final void a(com.tencent.mm.plugin.appbrand.service.c paramc, int paramInt, e parame, String paramString, IPCVoid paramIPCVoid)
  {
    AppMethodBeat.i(326591);
    s.u(parame, "this$0");
    s.u(paramString, "$path");
    paramc.callback(paramInt, parame.ZP("ok"));
    Log.i("MicroMsg.AppBrand.JsApiSaveRuntimeSnapshot", "invokeMM ok, appId=" + paramc.getAppId() + ", path=" + paramString);
    AppMethodBeat.o(326591);
  }
  
  private static final void a(com.tencent.mm.plugin.appbrand.ui.b.a.a parama, f paramf)
  {
    AppMethodBeat.i(326586);
    com.tencent.mm.plugin.appbrand.ui.b.a.b localb = (com.tencent.mm.plugin.appbrand.ui.b.a.b)n.ag(com.tencent.mm.plugin.appbrand.ui.b.a.b.class);
    if ((localb != null) && (parama != null)) {
      localb.a(parama.field_appId, parama.field_versionType, parama.field_appVersion, parama.field_isDarkMode, parama.field_screenshotFilePath);
    }
    if (paramf != null) {
      com.tencent.mm.ipcinvoker.wx_extension.b.a.b(paramf);
    }
    AppMethodBeat.o(326586);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/fakenative/JsApiSaveSplashScreenshot$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "checkCanInvoke", "", "env", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "data", "Lorg/json/JSONObject;", "callbackId", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean b(com.tencent.mm.plugin.appbrand.service.c paramc)
    {
      AppMethodBeat.i(326570);
      s.u(paramc, "env");
      b.a locala = com.tencent.mm.plugin.appbrand.ui.b.a.b.upH;
      if ((b.a.cNh()) && (paramc.getRuntime().getInitConfig().qYd))
      {
        AppMethodBeat.o(326570);
        return true;
      }
      AppMethodBeat.o(326570);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.e
 * JD-Core Version:    0.7.0.1
 */