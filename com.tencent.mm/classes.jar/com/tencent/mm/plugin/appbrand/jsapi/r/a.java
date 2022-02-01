package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/native_navigator/JsApiNavigateBackNative;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.c<g>
{
  @Deprecated
  public static final int CTRL_INDEX = 646;
  @Deprecated
  public static final String NAME = "navigateBackNative";
  private static final a.a sjt;
  
  static
  {
    AppMethodBeat.i(50629);
    sjt = new a.a((byte)0);
    AppMethodBeat.o(50629);
  }
  
  public a()
  {
    AppMethodBeat.i(325598);
    com.tencent.mm.plugin.appbrand.permission.c.afo("navigateBackNative");
    AppMethodBeat.o(325598);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/native_navigator/JsApiNavigateBackNative$invoke$1", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningStateController$OnRunningStateChangedListener;", "onRunningStateChanged", "", "appId", "", "state", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements c.a
  {
    b(g paramg, int paramInt, JSONObject paramJSONObject, com.tencent.luggage.sdk.launching.b<IPCString> paramb, String paramString, a parama) {}
    
    private static final void a(g paramg, int paramInt, JSONObject paramJSONObject, com.tencent.luggage.sdk.launching.b paramb, String paramString, a parama)
    {
      AppMethodBeat.i(325602);
      s.u(parama, "this$0");
      try
      {
        Log.i("MicroMsg.AppBrand.JsApiNavigateBackNative", "invoke onWXAppResult, appId:" + paramg.getAppId() + ", callbackId:" + paramInt + " data:" + paramJSONObject);
        if (paramb != null) {
          paramb.onWXAppResult((Parcelable)new IPCString(paramString));
        }
        paramg.callback(paramInt, parama.ZP("ok"));
        AppMethodBeat.o(325602);
        return;
      }
      catch (Exception paramJSONObject)
      {
        paramg.callback(paramInt, parama.ZP(s.X("fail ", paramJSONObject.getMessage())));
        AppMethodBeat.o(325602);
      }
    }
    
    public final void onRunningStateChanged(String paramString, com.tencent.mm.plugin.appbrand.b.b paramb)
    {
      AppMethodBeat.i(325613);
      s.u(paramString, "appId");
      s.u(paramb, "state");
      if (com.tencent.mm.plugin.appbrand.b.b.qKx == paramb)
      {
        this.rCg.getRuntime().qsB.b((c.a)this);
        MMHandlerThread.postToMainThread(new a.b..ExternalSyntheticLambda0(this.rCg, this.rxe, this.ryr, this.sju, this.sjv, this.sjw));
      }
      AppMethodBeat.o(325613);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.a
 * JD-Core Version:    0.7.0.1
 */