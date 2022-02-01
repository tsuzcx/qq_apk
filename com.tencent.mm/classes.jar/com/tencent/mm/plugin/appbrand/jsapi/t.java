package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandOnCopyUrlEvent;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "isCopyShortLink", "", "(Z)V", "dispatchEvent", "", "webviewId", "", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "Companion", "luggage-wechat-full-sdk_release"})
public final class t
  extends r
{
  public static final int CTRL_INDEX = 754;
  public static final String NAME = "onCopyUrl";
  public static final a osN;
  private final boolean osM;
  
  static
  {
    AppMethodBeat.i(169553);
    osN = new a((byte)0);
    AppMethodBeat.o(169553);
  }
  
  public t(byte paramByte)
  {
    this();
  }
  
  public t(boolean paramBoolean)
  {
    this.osM = paramBoolean;
  }
  
  public final void a(int paramInt, d paramd)
  {
    AppMethodBeat.i(237841);
    p.k(paramd, "service");
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("webviewId", Integer.valueOf(paramInt));
    ((Map)localHashMap).put("shortLinkEnable", Boolean.valueOf(this.osM));
    i((e)paramd).D((Map)localHashMap).bPO();
    AppMethodBeat.o(237841);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandOnCopyUrlEvent$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "SHORT_LINK_ENABLE", "WEBVIEW_ID", "luggage-wechat-full-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t
 * JD-Core Version:    0.7.0.1
 */