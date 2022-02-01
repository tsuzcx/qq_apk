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
import com.tencent.mm.tcp.libmmtcp.TcpNative;
import com.tencent.mm.tcp.libmmtcp.TcpNative.NativeCallBackInterface;
import com.tencent.mm.tcp.libmmtcp.a;
import java.lang.ref.WeakReference;

public final class c
{
  protected TcpNative cyK;
  private final a cyL;
  boolean cyz;
  
  public c()
  {
    AppMethodBeat.i(237934);
    this.cyz = true;
    this.cyL = new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(244697);
        synchronized (c.this)
        {
          if (c.this.cyK != null)
          {
            Log.i("Luggage.TcpNativeInstallHelper", "DestroyTask destoryTcp");
            c.this.cyK.destoryTcp();
            c.this.cyK = null;
            AppMethodBeat.o(244697);
            return;
          }
          Log.i("Luggage.TcpNativeInstallHelper", "DestroyTask tcpNative is null");
        }
      }
    });
    AppMethodBeat.o(237934);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(237937);
    Log.i("Luggage.TcpNativeInstallHelper", "destroyTcpBinding");
    if (parami == null)
    {
      Log.e("Luggage.TcpNativeInstallHelper", "destroyTcpBinding jsruntime is null");
      AppMethodBeat.o(237937);
      return;
    }
    ((m)parami.Q(m.class)).a(this.cyL);
    AppMethodBeat.o(237937);
  }
  
  public final void a(final i parami, e parame)
  {
    AppMethodBeat.i(237935);
    Log.i("Luggage.TcpNativeInstallHelper", "createTcpBinding");
    if (parami == null)
    {
      Log.e("Luggage.TcpNativeInstallHelper", "createTcpBinding jsruntime is null");
      AppMethodBeat.o(237935);
      return;
    }
    a.loadLibraries();
    q localq = (q)parami.Q(q.class);
    if (localq == null)
    {
      Log.e("Luggage.TcpNativeInstallHelper", "createTcpBinding jsThreadHandler is null");
      AppMethodBeat.o(237935);
      return;
    }
    parame = (b)parame.K(b.class);
    if (parame != null)
    {
      this.cyz = parame.QY();
      Log.i("Luggage.TcpNativeInstallHelper", "createTcpBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(this.cyz) });
    }
    localq.post(new Runnable()
    {
      public final void onCallBack(final long paramAnonymousLong, final String paramAnonymousString)
      {
        AppMethodBeat.i(233933);
        ((q)this.cyB.get()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(243193);
            Log.d("Luggage.TcpNativeInstallHelper", "mmtcp jsThreadHandler run onCallBack apiName:%s,engineId:%d", new Object[] { paramAnonymousString, Long.valueOf(paramAnonymousLong) });
            c.this.cyK.update(paramAnonymousLong);
            AppMethodBeat.o(243193);
          }
        });
        AppMethodBeat.o(233933);
      }
    }
    {
      public final void run()
      {
        AppMethodBeat.i(247732);
        Log.i("Luggage.TcpNativeInstallHelper", "createTcpBinding InitCallBack ");
        if (c.this.cyK != null)
        {
          Log.i("Luggage.TcpNativeInstallHelper", "createTcpBinding tcpNative != null");
          AppMethodBeat.o(247732);
          return;
        }
        v localv = (v)parami.Q(v.class);
        if (localv == null)
        {
          Log.e("Luggage.TcpNativeInstallHelper", "createTcpBinding v8Addon is null");
          AppMethodBeat.o(247732);
          return;
        }
        if (c.this.cyz) {}
        for (c.this.cyK = new TcpNative(localv.getIsolatePtr(), localv.acn(), localv.getUVLoopPtr());; c.this.cyK = new TcpNative(localv.getIsolatePtr(), localv.acn(), 0L))
        {
          Log.i("Luggage.TcpNativeInstallHelper", "createTcpBinding InitCallBack ret:%d", new Object[] { Integer.valueOf(c.this.cyK.InitCallBack(this.cyP)) });
          AppMethodBeat.o(247732);
          return;
        }
      }
    });
    AppMethodBeat.o(237935);
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
      AppMethodBeat.i(246719);
      run();
      AppMethodBeat.o(246719);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */