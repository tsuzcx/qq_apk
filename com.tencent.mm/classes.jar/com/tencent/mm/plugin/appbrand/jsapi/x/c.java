package com.tencent.mm.plugin.appbrand.jsapi.x;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "Event_onRealtimeDataResponse", "Priority", "plugin-appbrand-integration_release"})
public final class c
  extends com.tencent.mm.plugin.appbrand.jsapi.c<g>
{
  private static final int CTRL_INDEX = 652;
  private static final String NAME = "operateRealtimeData";
  @Deprecated
  public static final c.a pni;
  
  static
  {
    AppMethodBeat.i(50672);
    pni = new c.a((byte)0);
    CTRL_INDEX = 652;
    NAME = "operateRealtimeData";
    AppMethodBeat.o(50672);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/JsApiOperateRealtimeReport$Priority;", "", "(Ljava/lang/String;I)V", "HIGH", "LOW", "IMMEDIATE", "Companion", "plugin-appbrand-integration_release"})
  public static enum c
  {
    public static final c.c.a pno;
    
    static
    {
      AppMethodBeat.i(50668);
      c localc1 = new c("HIGH", 0);
      pnk = localc1;
      c localc2 = new c("LOW", 1);
      pnl = localc2;
      c localc3 = new c("IMMEDIATE", 2);
      pnm = localc3;
      pnn = new c[] { localc1, localc2, localc3 };
      pno = new c.c.a((byte)0);
      AppMethodBeat.o(50668);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.c
 * JD-Core Version:    0.7.0.1
 */