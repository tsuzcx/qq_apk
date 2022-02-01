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
import com.tencent.mm.tcp.libmmtcp.TcpNative;
import com.tencent.mm.tcp.libmmtcp.TcpNative.NativeCallBackInterface;
import com.tencent.mm.tcp.libmmtcp.a;
import java.lang.ref.WeakReference;

public final class c
{
  boolean eqZ;
  protected TcpNative erk;
  private final a erl;
  
  public c()
  {
    AppMethodBeat.i(220270);
    this.eqZ = true;
    this.erl = new a(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(220268);
        synchronized (c.this)
        {
          if (c.this.erk != null)
          {
            Log.i("Luggage.TcpNativeInstallHelper", "DestroyTask destoryTcp");
            c.this.erk.destoryTcp();
            c.this.erk = null;
            AppMethodBeat.o(220268);
            return;
          }
          Log.i("Luggage.TcpNativeInstallHelper", "DestroyTask tcpNative is null");
        }
      }
    });
    AppMethodBeat.o(220270);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(220276);
    Log.i("Luggage.TcpNativeInstallHelper", "destroyTcpBinding");
    if (parami == null)
    {
      Log.e("Luggage.TcpNativeInstallHelper", "destroyTcpBinding jsruntime is null");
      AppMethodBeat.o(220276);
      return;
    }
    ((m)parami.Z(m.class)).a(this.erl);
    AppMethodBeat.o(220276);
  }
  
  public final void a(final i parami, f paramf)
  {
    AppMethodBeat.i(220272);
    Log.i("Luggage.TcpNativeInstallHelper", "createTcpBinding");
    if (parami == null)
    {
      Log.e("Luggage.TcpNativeInstallHelper", "createTcpBinding jsruntime is null");
      AppMethodBeat.o(220272);
      return;
    }
    a.loadLibraries();
    q localq = (q)parami.Z(q.class);
    if (localq == null)
    {
      Log.e("Luggage.TcpNativeInstallHelper", "createTcpBinding jsThreadHandler is null");
      AppMethodBeat.o(220272);
      return;
    }
    paramf = (b)paramf.T(b.class);
    if (paramf != null)
    {
      this.eqZ = paramf.aro();
      Log.i("Luggage.TcpNativeInstallHelper", "createTcpBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(this.eqZ) });
    }
    localq.post(new Runnable()
    {
      public final void onCallBack(final long paramAnonymousLong, final String paramAnonymousString)
      {
        AppMethodBeat.i(220278);
        ((q)this.erb.get()).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(220263);
            Log.d("Luggage.TcpNativeInstallHelper", "mmtcp jsThreadHandler run onCallBack apiName:%s,engineId:%d", new Object[] { paramAnonymousString, Long.valueOf(paramAnonymousLong) });
            c.this.erk.update(paramAnonymousLong);
            AppMethodBeat.o(220263);
          }
        });
        AppMethodBeat.o(220278);
      }
    }
    {
      public final void run()
      {
        AppMethodBeat.i(220269);
        Log.i("Luggage.TcpNativeInstallHelper", "createTcpBinding InitCallBack ");
        if (c.this.erk != null)
        {
          Log.i("Luggage.TcpNativeInstallHelper", "createTcpBinding tcpNative != null");
          AppMethodBeat.o(220269);
          return;
        }
        v localv = (v)parami.Z(v.class);
        if (localv == null)
        {
          Log.e("Luggage.TcpNativeInstallHelper", "createTcpBinding v8Addon is null");
          AppMethodBeat.o(220269);
          return;
        }
        if (c.this.eqZ) {}
        for (c.this.erk = new TcpNative(localv.getIsolatePtr(), localv.aEn(), localv.getUVLoopPtr());; c.this.erk = new TcpNative(localv.getIsolatePtr(), localv.aEn(), 0L))
        {
          Log.i("Luggage.TcpNativeInstallHelper", "createTcpBinding InitCallBack ret:%d", new Object[] { Integer.valueOf(c.this.erk.InitCallBack(this.erp)) });
          AppMethodBeat.o(220269);
          return;
        }
      }
    });
    AppMethodBeat.o(220272);
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
      AppMethodBeat.i(220265);
      run();
      AppMethodBeat.o(220265);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.b.c
 * JD-Core Version:    0.7.0.1
 */