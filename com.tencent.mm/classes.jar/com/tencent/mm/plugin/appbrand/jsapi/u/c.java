package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "Event_onRealtimeDataResponse", "Priority", "plugin-appbrand-integration_release"})
public final class c
  extends a<d>
{
  private static final int CTRL_INDEX = 652;
  private static final String NAME = "operateRealtimeData";
  @Deprecated
  public static final a lfM;
  
  static
  {
    AppMethodBeat.i(50672);
    lfM = new a((byte)0);
    CTRL_INDEX = 652;
    NAME = "operateRealtimeData";
    AppMethodBeat.o(50672);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Companion;", "", "()V", "CTRL_INDEX", "", "getCTRL_INDEX", "()I", "NAME", "", "getNAME", "()Ljava/lang/String;", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Event_onRealtimeDataResponse;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "()V", "Companion", "plugin-appbrand-integration_release"})
  public static final class b
    extends p
  {
    public static final int CTRL_INDEX = 653;
    public static final String NAME = "onRealtimeDataResponse";
    @Deprecated
    public static final a lfN;
    
    static
    {
      AppMethodBeat.i(50667);
      lfN = new a((byte)0);
      AppMethodBeat.o(50667);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Event_onRealtimeDataResponse$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "plugin-appbrand-integration_release"})
    static final class a {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "", "(Ljava/lang/String;I)V", "HIGH", "LOW", "Companion", "plugin-appbrand-integration_release"})
  public static enum c
  {
    public static final a lfR;
    
    static
    {
      AppMethodBeat.i(50668);
      c localc1 = new c("HIGH", 0);
      lfO = localc1;
      c localc2 = new c("LOW", 1);
      lfP = localc2;
      lfQ = new c[] { localc1, localc2 };
      lfR = new a((byte)0);
      AppMethodBeat.o(50668);
    }
    
    private c() {}
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority$Companion;", "", "()V", "of", "Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "str", "", "plugin-appbrand-integration_release"})
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.c
 * JD-Core Version:    0.7.0.1
 */