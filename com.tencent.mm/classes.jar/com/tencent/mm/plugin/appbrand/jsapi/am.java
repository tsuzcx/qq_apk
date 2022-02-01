package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.utils.e.a;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.ui.widget.snackbar.a.c;
import com.tencent.mm.vfs.u;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddImageToFavorites;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "doAddImageToFavorites", "", "activity", "Landroid/app/Activity;", "imgPath", "", "doFavoriteAnyProcess", "", "handleErrorTypeAnyProcess", "", "ret", "invoke", "env", "data", "Lorg/json/JSONObject;", "callbackId", "Companion", "plugin-appbrand-integration_release"})
public final class am
  extends c<e>
{
  private static final int CTRL_INDEX = 924;
  private static final String NAME = "addImageToFavorites";
  public static final a otl;
  
  static
  {
    AppMethodBeat.i(280903);
    otl = new a((byte)0);
    AppMethodBeat.o(280903);
  }
  
  public final void a(final e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(280902);
    if (parame == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "invoke, env is null");
      AppMethodBeat.o(280902);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "invoke, data is null");
      parame.j(paramInt, agS("fail:data is null"));
      AppMethodBeat.o(280902);
      return;
    }
    paramJSONObject = paramJSONObject.optString("url");
    CharSequence localCharSequence = (CharSequence)paramJSONObject;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "invoke, url is empty");
      parame.j(paramInt, agS("fail:url is empty"));
      AppMethodBeat.o(280902);
      return;
    }
    dd.a(parame, paramJSONObject, (e.a)new d(this, parame, paramInt));
    AppMethodBeat.o(280902);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiAddImageToFavorites$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "PARAM_KEY_IMAGE_PATH", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "it", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b<InputType, ResultType>
    implements m<IPCString, IPCInteger>
  {
    public static final b otm;
    
    static
    {
      AppMethodBeat.i(284164);
      otm = new b();
      AppMethodBeat.o(284164);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(int paramInt, Activity paramActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "localPath", "", "kotlin.jvm.PlatformType", "onLoad"})
  static final class d
    implements e.a
  {
    d(am paramam, e parame, int paramInt) {}
    
    public final void dR(final String paramString)
    {
      AppMethodBeat.i(276134);
      Object localObject = (CharSequence)paramString;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "invoke, url is illegal");
        parame.j(paramInt, this.otp.agS("fail:url is illegal"));
        AppMethodBeat.o(276134);
        return;
      }
      if (!ImgUtil.isImgFile(paramString))
      {
        Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "invoke, " + paramString + " is not image");
        u.deleteFile(paramString);
        parame.j(paramInt, this.otp.agS("fail:url is illegal"));
        AppMethodBeat.o(276134);
        return;
      }
      localObject = parame.getContext();
      if ((localObject instanceof Activity))
      {
        localObject = (Activity)localObject;
        h.ZvG.be((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(281993);
            boolean bool = am.d(this.otc, paramString);
            Log.i("MicroMsg.AppBrand.JsApiAddImageToFavorites", "invoke, success: ".concat(String.valueOf(bool)));
            e locale = this.otq.otj;
            int i = this.otq.otk;
            am localam = this.otq.otp;
            if (bool) {}
            for (String str = "ok";; str = "fail")
            {
              locale.j(i, localam.agS(str));
              AppMethodBeat.o(281993);
              return;
            }
          }
        });
        AppMethodBeat.o(276134);
        return;
      }
      Log.w("MicroMsg.AppBrand.JsApiAddImageToFavorites", "invoke, activity is null");
      parame.j(paramInt, this.otp.agS("fail:activity is null"));
      AppMethodBeat.o(276134);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.am
 * JD-Core Version:    0.7.0.1
 */