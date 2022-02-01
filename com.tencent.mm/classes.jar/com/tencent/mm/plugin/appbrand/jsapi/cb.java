package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.m.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class cb
  extends c<y>
{
  public static final int CTRL_INDEX = 247;
  public static final String NAME = "openDeliveryList";
  private static final String rzJ;
  
  static
  {
    AppMethodBeat.i(325539);
    rzJ = "https://" + WeChatHosts.domainString(a.g.host_mp_weixin_qq_com) + "/bizmall/expressentry";
    AppMethodBeat.o(325539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cb
 * JD-Core Version:    0.7.0.1
 */