package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.sdk.b.a.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandOnCopyUrlEvent;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "isCopyShortLink", "", "(Z)V", "dispatchEvent", "", "webviewId", "", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
  extends s
{
  public static final int CTRL_INDEX = 754;
  public static final String NAME = "onCopyUrl";
  public static final a rwJ;
  private final boolean rwK;
  
  static
  {
    AppMethodBeat.i(169553);
    rwJ = new a((byte)0);
    AppMethodBeat.o(169553);
  }
  
  public v(byte paramByte)
  {
    this();
  }
  
  public v(boolean paramBoolean)
  {
    this.rwK = paramBoolean;
  }
  
  public final void a(int paramInt, d paramd)
  {
    AppMethodBeat.i(325657);
    kotlin.g.b.s.u(paramd, "service");
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("webviewId", Integer.valueOf(paramInt));
    ((Map)localHashMap).put("shortLinkEnable", Boolean.valueOf(this.rwK));
    h((f)paramd).K((Map)localHashMap).cpV();
    AppMethodBeat.o(325657);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandOnCopyUrlEvent$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "SHORT_LINK_ENABLE", "WEBVIEW_ID", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v
 * JD-Core Version:    0.7.0.1
 */