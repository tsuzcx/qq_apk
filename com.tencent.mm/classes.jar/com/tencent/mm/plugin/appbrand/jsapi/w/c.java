package com.tencent.mm.plugin.appbrand.jsapi.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "Event_onRealtimeDataResponse", "Priority", "plugin-appbrand-integration_release"})
public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.d<com.tencent.mm.plugin.appbrand.d>
{
  private static final int CTRL_INDEX = 652;
  private static final String NAME = "operateRealtimeData";
  @Deprecated
  public static final a mpd;
  
  static
  {
    AppMethodBeat.i(50672);
    mpd = new a((byte)0);
    CTRL_INDEX = 652;
    NAME = "operateRealtimeData";
    AppMethodBeat.o(50672);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Companion;", "", "()V", "CTRL_INDEX", "", "getCTRL_INDEX", "()I", "NAME", "", "getNAME", "()Ljava/lang/String;", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Event_onRealtimeDataResponse;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "()V", "Companion", "plugin-appbrand-integration_release"})
  public static final class b
    extends s
  {
    public static final int CTRL_INDEX = 653;
    public static final String NAME = "onRealtimeDataResponse";
    @Deprecated
    public static final a mpe;
    
    static
    {
      AppMethodBeat.i(50667);
      mpe = new a((byte)0);
      AppMethodBeat.o(50667);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Event_onRealtimeDataResponse$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"})
    static final class a {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "", "(Ljava/lang/String;I)V", "HIGH", "LOW", "IMMEDIATE", "Companion", "plugin-appbrand-integration_release"})
  public static enum c
  {
    public static final a mpj;
    
    static
    {
      AppMethodBeat.i(50668);
      c localc1 = new c("HIGH", 0);
      mpf = localc1;
      c localc2 = new c("LOW", 1);
      mpg = localc2;
      c localc3 = new c("IMMEDIATE", 2);
      mph = localc3;
      mpi = new c[] { localc1, localc2, localc3 };
      mpj = new a((byte)0);
      AppMethodBeat.o(50668);
    }
    
    private c() {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority$Companion;", "", "()V", "of", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "str", "", "plugin-appbrand-integration_release"})
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.c
 * JD-Core Version:    0.7.0.1
 */