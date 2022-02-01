package com.tencent.mm.plugin.appbrand.jsapi.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.al.d;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/voip/JsApiInsertXWebCloudVoice;", "Lcom/tencent/mm/plugin/appbrand/jsapi/voip/AppBrandCloudVoiceJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/ICreatePluginJsApi;", "()V", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
  implements d
{
  public static final int CTRL_INDEX = 934;
  public static final String NAME = "insertXWebVoIPView";
  public static final c.a sKt;
  
  static
  {
    AppMethodBeat.i(325814);
    sKt = new c.a((byte)0);
    AppMethodBeat.o(325814);
  }
  
  public c()
  {
    AppMethodBeat.i(325811);
    com.tencent.mm.plugin.appbrand.permission.c.afo("insertXWebVoIPView");
    AppMethodBeat.o(325811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aj.c
 * JD-Core Version:    0.7.0.1
 */