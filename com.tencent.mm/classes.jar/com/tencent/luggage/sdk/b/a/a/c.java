package com.tencent.luggage.sdk.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.m;
import com.tencent.mm.plugin.appbrand.jsruntime.m.a;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.z.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.udp.libmmudp.UdpNative;
import com.tencent.mm.udp.libmmudp.UdpNative.NativeCallBackInterface;
import com.tencent.mm.udp.libmmudp.a;
import java.lang.ref.WeakReference;

public final class c
{
  protected UdpNative cnK;
  private final a cnL;
  boolean cnz;
  
  public c()
  {
    AppMethodBeat.i(146762);
    this.cnz = true;
    this.cnL = new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146760);
        synchronized (c.this)
        {
          if (c.this.cnK != null)
          {
            ad.i("Luggage.UdpNativeInstallHelper", "DestroyTask destoryUdp");
            c.this.cnK.destoryUdp();
            c.this.cnK = null;
            AppMethodBeat.o(146760);
            return;
          }
          ad.i("Luggage.UdpNativeInstallHelper", "DestroyTask udpNative is null");
        }
      }
    });
    AppMethodBeat.o(146762);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(146764);
    ad.i("Luggage.UdpNativeInstallHelper", "destroyUdpBinding");
    if (parami == null)
    {
      ad.e("Luggage.UdpNativeInstallHelper", "destroyUdpBinding jsruntime is null");
      AppMethodBeat.o(146764);
      return;
    }
    ((m)parami.P(m.class)).a(this.cnL);
    AppMethodBeat.o(146764);
  }
  
  public final void a(final i parami, com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(192188);
    ad.i("Luggage.UdpNativeInstallHelper", "createUdpBinding");
    if (parami == null)
    {
      ad.e("Luggage.UdpNativeInstallHelper", "createUdpBinding jsruntime is null");
      AppMethodBeat.o(192188);
      return;
    }
    a.loadLibraries();
    q localq = (q)parami.P(q.class);
    if (localq == null)
    {
      ad.e("Luggage.UdpNativeInstallHelper", "createUdpBinding jsThreadHandler is null");
      AppMethodBeat.o(192188);
      return;
    }
    paramc = (b)paramc.K(b.class);
    if (paramc != null)
    {
      this.cnz = paramc.Ey();
      ad.i("Luggage.UdpNativeInstallHelper", "createUdpBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(this.cnz) });
    }
    localq.post(new Runnable()
    {
      public final void onCallBack(final long paramAnonymousLong, final String paramAnonymousString)
      {
        AppMethodBeat.i(146758);
        ((q)this.cnB.get()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146757);
            ad.d("Luggage.UdpNativeInstallHelper", "mmudp jsThreadHandler run onCallBack apiName:%s,engineId:%d", new Object[] { paramAnonymousString, Long.valueOf(paramAnonymousLong) });
            c.this.cnK.update(paramAnonymousLong);
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
        ad.i("Luggage.UdpNativeInstallHelper", "createUdpBinding InitCallBack ");
        if (c.this.cnK != null)
        {
          ad.i("Luggage.UdpNativeInstallHelper", "createUdpBinding udpNative != null");
          AppMethodBeat.o(146759);
          return;
        }
        v localv = (v)parami.P(v.class);
        if (localv == null)
        {
          ad.e("Luggage.UdpNativeInstallHelper", "createUdpBinding v8Addon is null");
          AppMethodBeat.o(146759);
          return;
        }
        if (c.this.cnz) {}
        for (c.this.cnK = new UdpNative(localv.getIsolatePtr(), localv.NB(), localv.getUVLoopPtr());; c.this.cnK = new UdpNative(localv.getIsolatePtr(), localv.NB(), 0L))
        {
          ad.i("Luggage.UdpNativeInstallHelper", "createUdpBinding InitCallBack ret:%d", new Object[] { Integer.valueOf(c.this.cnK.InitCallBack(this.cnP)) });
          AppMethodBeat.o(146759);
          return;
        }
      }
    });
    AppMethodBeat.o(192188);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */