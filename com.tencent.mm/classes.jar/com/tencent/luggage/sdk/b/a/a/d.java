package com.tencent.luggage.sdk.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.m;
import com.tencent.mm.plugin.appbrand.jsruntime.m.a;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.udp.libmmudp.UdpNative;
import com.tencent.mm.udp.libmmudp.UdpNative.NativeCallBackInterface;
import com.tencent.mm.udp.libmmudp.a;
import java.lang.ref.WeakReference;

public final class d
{
  boolean cdi;
  protected UdpNative cdu;
  private final a cdv;
  
  public d()
  {
    AppMethodBeat.i(146762);
    this.cdi = true;
    this.cdv = new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146760);
        synchronized (d.this)
        {
          if (d.this.cdu != null)
          {
            ac.i("Luggage.UdpNativeInstallHelper", "DestroyTask destoryUdp");
            d.this.cdu.destoryUdp();
            d.this.cdu = null;
            AppMethodBeat.o(146760);
            return;
          }
          ac.i("Luggage.UdpNativeInstallHelper", "DestroyTask udpNative is null");
        }
      }
    });
    AppMethodBeat.o(146762);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(146764);
    ac.i("Luggage.UdpNativeInstallHelper", "destroyUdpBinding");
    if (parami == null)
    {
      ac.e("Luggage.UdpNativeInstallHelper", "destroyUdpBinding jsruntime is null");
      AppMethodBeat.o(146764);
      return;
    }
    ((m)parami.P(m.class)).a(this.cdv);
    AppMethodBeat.o(146764);
  }
  
  public final void a(final i parami, com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(206120);
    ac.i("Luggage.UdpNativeInstallHelper", "createUdpBinding");
    if (parami == null)
    {
      ac.e("Luggage.UdpNativeInstallHelper", "createUdpBinding jsruntime is null");
      AppMethodBeat.o(206120);
      return;
    }
    a.loadLibraries();
    q localq = (q)parami.P(q.class);
    if (localq == null)
    {
      ac.e("Luggage.UdpNativeInstallHelper", "createUdpBinding jsThreadHandler is null");
      AppMethodBeat.o(206120);
      return;
    }
    paramc = (b)paramc.K(b.class);
    if (paramc != null)
    {
      this.cdi = paramc.CZ();
      ac.i("Luggage.UdpNativeInstallHelper", "createUdpBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(this.cdi) });
    }
    localq.post(new Runnable()
    {
      public final void onCallBack(final long paramAnonymousLong, final String paramAnonymousString)
      {
        AppMethodBeat.i(146758);
        ((q)this.cdk.get()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146757);
            ac.d("Luggage.UdpNativeInstallHelper", "mmudp jsThreadHandler run onCallBack apiName:%s,engineId:%d", new Object[] { paramAnonymousString, Long.valueOf(paramAnonymousLong) });
            d.this.cdu.update(paramAnonymousLong);
            AppMethodBeat.o(146757);
          }
        });
        AppMethodBeat.o(146758);
      }
    }
    {
      public final void run()
      {
        AppMethodBeat.i(146759);
        ac.i("Luggage.UdpNativeInstallHelper", "createUdpBinding InitCallBack ");
        if (d.this.cdu != null)
        {
          ac.i("Luggage.UdpNativeInstallHelper", "createUdpBinding udpNative != null");
          AppMethodBeat.o(146759);
          return;
        }
        v localv = (v)parami.P(v.class);
        if (localv == null)
        {
          ac.e("Luggage.UdpNativeInstallHelper", "createUdpBinding v8Addon is null");
          AppMethodBeat.o(146759);
          return;
        }
        if (d.this.cdi) {}
        for (d.this.cdu = new UdpNative(localv.getIsolatePtr(), localv.LS(), localv.getUVLoopPtr());; d.this.cdu = new UdpNative(localv.getIsolatePtr(), localv.LS(), 0L))
        {
          ac.i("Luggage.UdpNativeInstallHelper", "createUdpBinding InitCallBack ret:%d", new Object[] { Integer.valueOf(d.this.cdu.InitCallBack(this.cdz)) });
          AppMethodBeat.o(146759);
          return;
        }
      }
    });
    AppMethodBeat.o(206120);
  }
  
  final class a
    extends c
    implements m.a
  {
    a(Runnable paramRunnable)
    {
      super();
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(146761);
      run();
      AppMethodBeat.o(146761);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */