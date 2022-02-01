package com.tencent.luggage.sdk.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.m;
import com.tencent.mm.plugin.appbrand.jsruntime.m.a;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.y.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.udp.libmmudp.UdpNative;
import com.tencent.mm.udp.libmmudp.UdpNative.NativeCallBackInterface;
import com.tencent.mm.udp.libmmudp.a;
import java.lang.ref.WeakReference;

public final class c
{
  boolean cnB;
  protected UdpNative cnM;
  private final a cnN;
  
  public c()
  {
    AppMethodBeat.i(146762);
    this.cnB = true;
    this.cnN = new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146760);
        synchronized (c.this)
        {
          if (c.this.cnM != null)
          {
            ae.i("Luggage.UdpNativeInstallHelper", "DestroyTask destoryUdp");
            c.this.cnM.destoryUdp();
            c.this.cnM = null;
            AppMethodBeat.o(146760);
            return;
          }
          ae.i("Luggage.UdpNativeInstallHelper", "DestroyTask udpNative is null");
        }
      }
    });
    AppMethodBeat.o(146762);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(146764);
    ae.i("Luggage.UdpNativeInstallHelper", "destroyUdpBinding");
    if (parami == null)
    {
      ae.e("Luggage.UdpNativeInstallHelper", "destroyUdpBinding jsruntime is null");
      AppMethodBeat.o(146764);
      return;
    }
    ((m)parami.P(m.class)).a(this.cnN);
    AppMethodBeat.o(146764);
  }
  
  public final void a(final i parami, com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(220761);
    ae.i("Luggage.UdpNativeInstallHelper", "createUdpBinding");
    if (parami == null)
    {
      ae.e("Luggage.UdpNativeInstallHelper", "createUdpBinding jsruntime is null");
      AppMethodBeat.o(220761);
      return;
    }
    a.loadLibraries();
    q localq = (q)parami.P(q.class);
    if (localq == null)
    {
      ae.e("Luggage.UdpNativeInstallHelper", "createUdpBinding jsThreadHandler is null");
      AppMethodBeat.o(220761);
      return;
    }
    paramc = (b)paramc.K(b.class);
    if (paramc != null)
    {
      this.cnB = paramc.EA();
      ae.i("Luggage.UdpNativeInstallHelper", "createUdpBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(this.cnB) });
    }
    localq.post(new Runnable()
    {
      public final void onCallBack(final long paramAnonymousLong, final String paramAnonymousString)
      {
        AppMethodBeat.i(146758);
        ((q)this.cnD.get()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146757);
            ae.d("Luggage.UdpNativeInstallHelper", "mmudp jsThreadHandler run onCallBack apiName:%s,engineId:%d", new Object[] { paramAnonymousString, Long.valueOf(paramAnonymousLong) });
            c.this.cnM.update(paramAnonymousLong);
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
        ae.i("Luggage.UdpNativeInstallHelper", "createUdpBinding InitCallBack ");
        if (c.this.cnM != null)
        {
          ae.i("Luggage.UdpNativeInstallHelper", "createUdpBinding udpNative != null");
          AppMethodBeat.o(146759);
          return;
        }
        v localv = (v)parami.P(v.class);
        if (localv == null)
        {
          ae.e("Luggage.UdpNativeInstallHelper", "createUdpBinding v8Addon is null");
          AppMethodBeat.o(146759);
          return;
        }
        if (c.this.cnB) {}
        for (c.this.cnM = new UdpNative(localv.getIsolatePtr(), localv.Nz(), localv.getUVLoopPtr());; c.this.cnM = new UdpNative(localv.getIsolatePtr(), localv.Nz(), 0L))
        {
          ae.i("Luggage.UdpNativeInstallHelper", "createUdpBinding InitCallBack ret:%d", new Object[] { Integer.valueOf(c.this.cnM.InitCallBack(this.cnR)) });
          AppMethodBeat.o(146759);
          return;
        }
      }
    });
    AppMethodBeat.o(220761);
  }
  
  final class a
    extends l
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
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */