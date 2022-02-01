package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/native_navigator/JsApiNavigateBackNative;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends com.tencent.mm.plugin.appbrand.jsapi.c<g>
{
  public static final int CTRL_INDEX = 646;
  public static final String NAME = "navigateBackNative";
  @Deprecated
  public static final a.a pec;
  
  static
  {
    AppMethodBeat.i(50629);
    pec = new a.a((byte)0);
    AppMethodBeat.o(50629);
  }
  
  public a()
  {
    AppMethodBeat.i(253823);
    com.tencent.mm.plugin.appbrand.permission.c.amg("navigateBackNative");
    AppMethodBeat.o(253823);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/native_navigator/JsApiNavigateBackNative$invoke$1", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningStateController$OnRunningStateChangedListener;", "onRunningStateChanged", "", "appId", "", "state", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "plugin-appbrand-integration_release"})
  public static final class b
    implements c.a
  {
    b(g paramg, int paramInt, JSONObject paramJSONObject, com.tencent.luggage.sdk.launching.a parama, String paramString) {}
    
    public final void a(String paramString, b paramb)
    {
      AppMethodBeat.i(277415);
      p.k(paramString, "appId");
      p.k(paramb, "state");
      if (b.nKQ == paramb)
      {
        paramString = this.owL.getRuntime();
        p.j(paramString, "env.runtime");
        paramString.bCb().b((c.a)this);
        MMHandlerThread.postToMainThread((Runnable)new a(this));
      }
      AppMethodBeat.o(277415);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(a.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(277347);
        try
        {
          a.bTk();
          Log.i("MicroMsg.AppBrand.JsApiNavigateBackNative", "invoke onWXAppResult, appId:" + this.peg.owL.getAppId() + ", callbackId:" + this.peg.otk + " data:" + this.peg.oAR);
          com.tencent.luggage.sdk.launching.a locala = this.peg.pee;
          if (locala != null) {
            locala.b((Parcelable)new IPCString(this.peg.pef));
          }
          this.peg.owL.j(this.peg.otk, this.peg.ped.agS("ok"));
          AppMethodBeat.o(277347);
          return;
        }
        catch (Exception localException)
        {
          this.peg.owL.j(this.peg.otk, this.peg.ped.agS("fail " + localException.getMessage()));
          AppMethodBeat.o(277347);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.a
 * JD-Core Version:    0.7.0.1
 */