package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class a$a$1
  implements Runnable
{
  a$a$1(a.a parama, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(94389);
    this.ihX.ihW.k(false, "fail to connect wifi:actionListener" + this.Au);
    ab.i("MicroMsg.wifi_event", "ActionListener onFailure FAIL.");
    AppMethodBeat.o(94389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a.a.1
 * JD-Core Version:    0.7.0.1
 */