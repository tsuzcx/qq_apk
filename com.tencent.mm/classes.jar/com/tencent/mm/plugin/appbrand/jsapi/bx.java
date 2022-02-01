package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.l.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class bx
  extends c<v>
{
  public static final int CTRL_INDEX = 247;
  public static final String NAME = "openDeliveryList";
  private static final String owp;
  
  static
  {
    AppMethodBeat.i(237086);
    owp = "https://" + WeChatHosts.domainString(a.g.host_mp_weixin_qq_com) + "/bizmall/expressentry";
    AppMethodBeat.o(237086);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bx
 * JD-Core Version:    0.7.0.1
 */