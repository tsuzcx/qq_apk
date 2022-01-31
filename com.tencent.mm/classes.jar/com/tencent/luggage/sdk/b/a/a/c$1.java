package com.tencent.luggage.sdk.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.n;
import com.tencent.mm.udp.libmmudp.UdpNative.NativeCallBackInterface;

final class c$1
  implements UdpNative.NativeCallBackInterface
{
  c$1(c paramc, n paramn) {}
  
  public final void onCallBack(String paramString)
  {
    AppMethodBeat.i(140708);
    this.bDY.post(new c.1.1(this, paramString));
    AppMethodBeat.o(140708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.c.1
 * JD-Core Version:    0.7.0.1
 */