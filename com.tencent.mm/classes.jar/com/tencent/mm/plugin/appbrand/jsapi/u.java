package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandOnCopyUrlEvent;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "isCopyShortLink", "", "(Z)V", "dispatchEvent", "", "webviewId", "", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "Companion", "luggage-wechat-full-sdk_release"})
public final class u
  extends s
{
  public static final int CTRL_INDEX = 754;
  public static final String NAME = "onCopyUrl";
  public static final a lya;
  private final boolean lxZ;
  
  static
  {
    AppMethodBeat.i(169553);
    lya = new a((byte)0);
    AppMethodBeat.o(169553);
  }
  
  public u(byte paramByte)
  {
    this();
  }
  
  public u(boolean paramBoolean)
  {
    this.lxZ = paramBoolean;
  }
  
  public final void a(int paramInt, d paramd)
  {
    AppMethodBeat.i(230057);
    p.h(paramd, "service");
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("webviewId", Integer.valueOf(paramInt));
    ((Map)localHashMap).put("shortLinkEnable", Boolean.valueOf(this.lxZ));
    g((f)paramd).K((Map)localHashMap).bEo();
    AppMethodBeat.o(230057);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandOnCopyUrlEvent$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "SHORT_LINK_ENABLE", "WEBVIEW_ID", "luggage-wechat-full-sdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u
 * JD-Core Version:    0.7.0.1
 */