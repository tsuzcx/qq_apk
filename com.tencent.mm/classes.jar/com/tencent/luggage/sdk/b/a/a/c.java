package com.tencent.luggage.sdk.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.i;
import com.tencent.mm.plugin.appbrand.i.m;
import com.tencent.mm.plugin.appbrand.i.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.udp.libmmudp.UdpNative;
import com.tencent.mm.udp.libmmudp.a;

public final class c
{
  protected UdpNative bEg;
  private final c.a bEh;
  
  public c()
  {
    AppMethodBeat.i(140712);
    this.bEh = new c.a(this, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(140710);
        if (c.this.bEg != null) {
          synchronized (c.this)
          {
            if (c.this.bEg != null)
            {
              c.this.bEg.destoryUdp();
              c.this.bEg = null;
            }
            AppMethodBeat.o(140710);
            return;
          }
        }
        AppMethodBeat.o(140710);
      }
    });
    AppMethodBeat.o(140712);
  }
  
  public final void d(i parami)
  {
    AppMethodBeat.i(140713);
    ab.i("Luggage.UdpNativeInstallHelper", "createUdpBinding");
    if (this.bEg != null)
    {
      ab.i("Luggage.UdpNativeInstallHelper", "createUdpBinding udpNative != null");
      AppMethodBeat.o(140713);
      return;
    }
    if (parami == null)
    {
      ab.e("Luggage.UdpNativeInstallHelper", "createUdpBinding jsruntime is null");
      AppMethodBeat.o(140713);
      return;
    }
    a.loadLibraries();
    n localn = (n)parami.v(n.class);
    if (localn == null)
    {
      ab.e("Luggage.UdpNativeInstallHelper", "createUdpBinding jsThreadHandler is null");
      AppMethodBeat.o(140713);
      return;
    }
    localn.post(new c.2(this, parami, new c.1(this, localn)));
    AppMethodBeat.o(140713);
  }
  
  public final void e(i parami)
  {
    AppMethodBeat.i(140714);
    ab.i("Luggage.UdpNativeInstallHelper", "destroyUdpBinding");
    if (this.bEg == null)
    {
      ab.i("Luggage.UdpNativeInstallHelper", "destroyUdpBinding is null");
      AppMethodBeat.o(140714);
      return;
    }
    if (parami == null)
    {
      ab.e("Luggage.UdpNativeInstallHelper", "destroyUdpBinding jsruntime is null");
      AppMethodBeat.o(140714);
      return;
    }
    ((m)parami.v(m.class)).a(this.bEh);
    AppMethodBeat.o(140714);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */