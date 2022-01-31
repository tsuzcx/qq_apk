package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import com.tencent.mm.sdk.platformtools.y;

final class a$a$1
  implements Runnable
{
  a$a$1(a.a parama, int paramInt) {}
  
  public final void run()
  {
    this.gHo.gHn.g(false, "fail to connect wifi:actionListener" + this.zQ);
    y.i("MicroMsg.wifi_event", "ActionListener onFailure FAIL.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a.a.1
 * JD-Core Version:    0.7.0.1
 */