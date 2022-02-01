package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/native_navigator/JsApiNavigateBackNative;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.d<com.tencent.mm.plugin.appbrand.d>
{
  public static final int CTRL_INDEX = 646;
  public static final String NAME = "navigateBackNative";
  @Deprecated
  public static final a mfV;
  
  static
  {
    AppMethodBeat.i(50629);
    mfV = new a((byte)0);
    AppMethodBeat.o(50629);
  }
  
  public a()
  {
    AppMethodBeat.i(228432);
    com.tencent.mm.plugin.appbrand.permission.c.aem("navigateBackNative");
    AppMethodBeat.o(228432);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/native_navigator/JsApiNavigateBackNative$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/native_navigator/JsApiNavigateBackNative$invoke$1", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningStateController$OnRunningStateChangedListener;", "onRunningStateChanged", "", "appId", "", "state", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "plugin-appbrand-integration_release"})
  public static final class b
    implements c.a
  {
    b(com.tencent.mm.plugin.appbrand.d paramd, int paramInt, JSONObject paramJSONObject, com.tencent.luggage.sdk.launching.a parama, String paramString) {}
    
    public final void a(String paramString, b paramb)
    {
      AppMethodBeat.i(228431);
      p.h(paramString, "appId");
      p.h(paramb, "state");
      if (b.kQI == paramb)
      {
        paramString = this.lBv.getRuntime();
        p.g(paramString, "env.runtime");
        paramString.brl().b((c.a)this);
        MMHandlerThread.postToMainThread((Runnable)new a(this));
      }
      AppMethodBeat.o(228431);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(a.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(228430);
        try
        {
          a.bHC();
          Log.i("MicroMsg.AppBrand.JsApiNavigateBackNative", "invoke onWXAppResult, appId:" + this.mfZ.lBv.getAppId() + ", callbackId:" + this.mfZ.lyo + " data:" + this.mfZ.lFq);
          com.tencent.luggage.sdk.launching.a locala = this.mfZ.mfX;
          if (locala != null) {
            locala.b((Parcelable)new IPCString(this.mfZ.mfY));
          }
          this.mfZ.lBv.i(this.mfZ.lyo, this.mfZ.mfW.Zf("ok"));
          AppMethodBeat.o(228430);
          return;
        }
        catch (Exception localException)
        {
          this.mfZ.lBv.i(this.mfZ.lyo, this.mfZ.mfW.Zf("fail " + localException.getMessage()));
          AppMethodBeat.o(228430);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.a
 * JD-Core Version:    0.7.0.1
 */