package com.tencent.luggage.sdk.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.n;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.m;
import com.tencent.mm.plugin.appbrand.n.m.a;
import com.tencent.mm.plugin.appbrand.n.q;
import com.tencent.mm.plugin.appbrand.n.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.udp.libmmudp.UdpNative;
import com.tencent.mm.udp.libmmudp.UdpNative.NativeCallBackInterface;
import com.tencent.mm.udp.libmmudp.a;
import java.lang.ref.WeakReference;

public final class d
{
  boolean eqZ;
  protected UdpNative erq;
  private final a err;
  
  public d()
  {
    AppMethodBeat.i(146762);
    this.eqZ = true;
    this.err = new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146760);
        synchronized (d.this)
        {
          if (d.this.erq != null)
          {
            Log.i("Luggage.UdpNativeInstallHelper", "DestroyTask destoryUdp");
            d.this.erq.destoryUdp();
            d.this.erq = null;
            AppMethodBeat.o(146760);
            return;
          }
          Log.i("Luggage.UdpNativeInstallHelper", "DestroyTask udpNative is null");
        }
      }
    });
    AppMethodBeat.o(146762);
  }
  
  public final void b(i parami)
  {
    AppMethodBeat.i(146764);
    Log.i("Luggage.UdpNativeInstallHelper", "destroyUdpBinding");
    if (parami == null)
    {
      Log.e("Luggage.UdpNativeInstallHelper", "destroyUdpBinding jsruntime is null");
      AppMethodBeat.o(146764);
      return;
    }
    ((m)parami.Z(m.class)).a(this.err);
    AppMethodBeat.o(146764);
  }
  
  public final void b(final i parami, f paramf)
  {
    AppMethodBeat.i(220273);
    Log.i("Luggage.UdpNativeInstallHelper", "createUdpBinding");
    if (parami == null)
    {
      Log.e("Luggage.UdpNativeInstallHelper", "createUdpBinding jsruntime is null");
      AppMethodBeat.o(220273);
      return;
    }
    a.loadLibraries();
    q localq = (q)parami.Z(q.class);
    if (localq == null)
    {
      Log.e("Luggage.UdpNativeInstallHelper", "createUdpBinding jsThreadHandler is null");
      AppMethodBeat.o(220273);
      return;
    }
    paramf = (b)paramf.T(b.class);
    if (paramf != null)
    {
      this.eqZ = paramf.aro();
      Log.i("Luggage.UdpNativeInstallHelper", "createUdpBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(this.eqZ) });
    }
    localq.post(new Runnable()
    {
      public final void onCallBack(final long paramAnonymousLong, final String paramAnonymousString)
      {
        AppMethodBeat.i(146758);
        ((q)this.erb.get()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146757);
            Log.d("Luggage.UdpNativeInstallHelper", "mmudp jsThreadHandler run onCallBack apiName:%s,engineId:%d", new Object[] { paramAnonymousString, Long.valueOf(paramAnonymousLong) });
            d.this.erq.update(paramAnonymousLong);
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
        Log.i("Luggage.UdpNativeInstallHelper", "createUdpBinding InitCallBack ");
        if (d.this.erq != null)
        {
          Log.i("Luggage.UdpNativeInstallHelper", "createUdpBinding udpNative != null");
          AppMethodBeat.o(146759);
          return;
        }
        v localv = (v)parami.Z(v.class);
        if (localv == null)
        {
          Log.e("Luggage.UdpNativeInstallHelper", "createUdpBinding v8Addon is null");
          AppMethodBeat.o(146759);
          return;
        }
        if (d.this.eqZ) {}
        for (d.this.erq = new UdpNative(localv.getIsolatePtr(), localv.aEn(), localv.getUVLoopPtr());; d.this.erq = new UdpNative(localv.getIsolatePtr(), localv.aEn(), 0L))
        {
          Log.i("Luggage.UdpNativeInstallHelper", "createUdpBinding InitCallBack ret:%d", new Object[] { Integer.valueOf(d.this.erq.InitCallBack(this.eru)) });
          AppMethodBeat.o(146759);
          return;
        }
      }
    });
    AppMethodBeat.o(220273);
  }
  
  final class a
    extends n
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.b.d
 * JD-Core Version:    0.7.0.1
 */