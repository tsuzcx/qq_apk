package com.tencent.luggage.sdk.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.l;
import com.tencent.mm.plugin.appbrand.jsapi.f;
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

public final class c
{
  boolean czD;
  protected UdpNative czO;
  private final a czP;
  
  public c()
  {
    AppMethodBeat.i(146762);
    this.czD = true;
    this.czP = new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(146760);
        synchronized (c.this)
        {
          if (c.this.czO != null)
          {
            Log.i("Luggage.UdpNativeInstallHelper", "DestroyTask destoryUdp");
            c.this.czO.destoryUdp();
            c.this.czO = null;
            AppMethodBeat.o(146760);
            return;
          }
          Log.i("Luggage.UdpNativeInstallHelper", "DestroyTask udpNative is null");
        }
      }
    });
    AppMethodBeat.o(146762);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(146764);
    Log.i("Luggage.UdpNativeInstallHelper", "destroyUdpBinding");
    if (parami == null)
    {
      Log.e("Luggage.UdpNativeInstallHelper", "destroyUdpBinding jsruntime is null");
      AppMethodBeat.o(146764);
      return;
    }
    ((m)parami.R(m.class)).a(this.czP);
    AppMethodBeat.o(146764);
  }
  
  public final void a(final i parami, f paramf)
  {
    AppMethodBeat.i(229839);
    Log.i("Luggage.UdpNativeInstallHelper", "createUdpBinding");
    if (parami == null)
    {
      Log.e("Luggage.UdpNativeInstallHelper", "createUdpBinding jsruntime is null");
      AppMethodBeat.o(229839);
      return;
    }
    a.loadLibraries();
    q localq = (q)parami.R(q.class);
    if (localq == null)
    {
      Log.e("Luggage.UdpNativeInstallHelper", "createUdpBinding jsThreadHandler is null");
      AppMethodBeat.o(229839);
      return;
    }
    paramf = (b)paramf.M(b.class);
    if (paramf != null)
    {
      this.czD = paramf.Oa();
      Log.i("Luggage.UdpNativeInstallHelper", "createUdpBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(this.czD) });
    }
    localq.post(new Runnable()
    {
      public final void onCallBack(final long paramAnonymousLong, final String paramAnonymousString)
      {
        AppMethodBeat.i(146758);
        ((q)this.czF.get()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(146757);
            Log.d("Luggage.UdpNativeInstallHelper", "mmudp jsThreadHandler run onCallBack apiName:%s,engineId:%d", new Object[] { paramAnonymousString, Long.valueOf(paramAnonymousLong) });
            c.this.czO.update(paramAnonymousLong);
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
        if (c.this.czO != null)
        {
          Log.i("Luggage.UdpNativeInstallHelper", "createUdpBinding udpNative != null");
          AppMethodBeat.o(146759);
          return;
        }
        v localv = (v)parami.R(v.class);
        if (localv == null)
        {
          Log.e("Luggage.UdpNativeInstallHelper", "createUdpBinding v8Addon is null");
          AppMethodBeat.o(146759);
          return;
        }
        if (c.this.czD) {}
        for (c.this.czO = new UdpNative(localv.getIsolatePtr(), localv.XK(), localv.getUVLoopPtr());; c.this.czO = new UdpNative(localv.getIsolatePtr(), localv.XK(), 0L))
        {
          Log.i("Luggage.UdpNativeInstallHelper", "createUdpBinding InitCallBack ret:%d", new Object[] { Integer.valueOf(c.this.czO.InitCallBack(this.czT)) });
          AppMethodBeat.o(146759);
          return;
        }
      }
    });
    AppMethodBeat.o(229839);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */