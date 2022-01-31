package com.tencent.luggage.sdk.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.i;
import com.tencent.mm.plugin.appbrand.i.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.udp.libmmudp.UdpNative;
import com.tencent.mm.udp.libmmudp.UdpNative.NativeCallBackInterface;

final class c$2
  implements Runnable
{
  c$2(c paramc, i parami, UdpNative.NativeCallBackInterface paramNativeCallBackInterface) {}
  
  public final void run()
  {
    AppMethodBeat.i(140709);
    ab.i("Luggage.UdpNativeInstallHelper", "createUdpBinding InitCallBack ");
    s locals = (s)this.bEc.v(s.class);
    if (locals == null)
    {
      ab.e("Luggage.UdpNativeInstallHelper", "createUdpBinding v8Addon is null");
      AppMethodBeat.o(140709);
      return;
    }
    this.bEi.bEg = new UdpNative(locals.getIsolatePtr(), locals.aGD());
    ab.i("Luggage.UdpNativeInstallHelper", "createUdpBinding InitCallBack ret:%d", new Object[] { Integer.valueOf(this.bEi.bEg.InitCallBack(this.bEk)) });
    AppMethodBeat.o(140709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.c.2
 * JD-Core Version:    0.7.0.1
 */