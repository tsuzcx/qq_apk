package com.tencent.luggage.sdk.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.l;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.m;
import com.tencent.mm.plugin.appbrand.m.m.a;
import com.tencent.mm.plugin.appbrand.m.q;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.udp.libmmudp.UdpNative;
import com.tencent.mm.udp.libmmudp.UdpNative.NativeCallBackInterface;
import com.tencent.mm.udp.libmmudp.a;
import java.lang.ref.WeakReference;

public final class d
{
  protected UdpNative cyQ;
  private final a cyR;
  boolean cyz;
  
  public d()
  {
    AppMethodBeat.i(146762);
    this.cyz = true;
    this.cyR = new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146760);
        synchronized (d.this)
        {
          if (d.this.cyQ != null)
          {
            Log.i("Luggage.UdpNativeInstallHelper", "DestroyTask destoryUdp");
            d.this.cyQ.destoryUdp();
            d.this.cyQ = null;
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
    ((m)parami.Q(m.class)).a(this.cyR);
    AppMethodBeat.o(146764);
  }
  
  public final void b(final i parami, e parame)
  {
    AppMethodBeat.i(233918);
    Log.i("Luggage.UdpNativeInstallHelper", "createUdpBinding");
    if (parami == null)
    {
      Log.e("Luggage.UdpNativeInstallHelper", "createUdpBinding jsruntime is null");
      AppMethodBeat.o(233918);
      return;
    }
    a.loadLibraries();
    q localq = (q)parami.Q(q.class);
    if (localq == null)
    {
      Log.e("Luggage.UdpNativeInstallHelper", "createUdpBinding jsThreadHandler is null");
      AppMethodBeat.o(233918);
      return;
    }
    parame = (b)parame.K(b.class);
    if (parame != null)
    {
      this.cyz = parame.QY();
      Log.i("Luggage.UdpNativeInstallHelper", "createUdpBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(this.cyz) });
    }
    localq.post(new Runnable()
    {
      public final void onCallBack(final long paramAnonymousLong, final String paramAnonymousString)
      {
        AppMethodBeat.i(146758);
        ((q)this.cyB.get()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146757);
            Log.d("Luggage.UdpNativeInstallHelper", "mmudp jsThreadHandler run onCallBack apiName:%s,engineId:%d", new Object[] { paramAnonymousString, Long.valueOf(paramAnonymousLong) });
            d.this.cyQ.update(paramAnonymousLong);
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
        if (d.this.cyQ != null)
        {
          Log.i("Luggage.UdpNativeInstallHelper", "createUdpBinding udpNative != null");
          AppMethodBeat.o(146759);
          return;
        }
        v localv = (v)parami.Q(v.class);
        if (localv == null)
        {
          Log.e("Luggage.UdpNativeInstallHelper", "createUdpBinding v8Addon is null");
          AppMethodBeat.o(146759);
          return;
        }
        if (d.this.cyz) {}
        for (d.this.cyQ = new UdpNative(localv.getIsolatePtr(), localv.acn(), localv.getUVLoopPtr());; d.this.cyQ = new UdpNative(localv.getIsolatePtr(), localv.acn(), 0L))
        {
          Log.i("Luggage.UdpNativeInstallHelper", "createUdpBinding InitCallBack ret:%d", new Object[] { Integer.valueOf(d.this.cyQ.InitCallBack(this.cyU)) });
          AppMethodBeat.o(146759);
          return;
        }
      }
    });
    AppMethodBeat.o(233918);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */