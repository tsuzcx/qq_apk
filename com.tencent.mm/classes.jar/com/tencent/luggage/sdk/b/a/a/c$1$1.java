package com.tencent.luggage.sdk.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.udp.libmmudp.UdpNative;

final class c$1$1
  implements Runnable
{
  c$1$1(c.1 param1, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(140707);
    ab.i("Luggage.UdpNativeInstallHelper", "onCallBack apiName:%s", new Object[] { this.bEa });
    this.bEj.bEi.bEg.update();
    AppMethodBeat.o(140707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.c.1.1
 * JD-Core Version:    0.7.0.1
 */