package com.tencent.mm.plugin.appbrand.b;

import android.os.Handler;
import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  final AppBrandRuntime iGV;
  public final d iQP;
  public final a<a, c> iQQ;
  
  public c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134712);
    this.iQQ = new a();
    this.iGV = paramAppBrandRuntime;
    this.iQP = new d(paramAppBrandRuntime)
    {
      final void a(b paramAnonymousb)
      {
        AppMethodBeat.i(134711);
        c localc = c.this;
        synchronized (localc.iQQ)
        {
          c.a[] arrayOfa = new c.a[localc.iQQ.size()];
          arrayOfa = (c.a[])localc.iQQ.keySet().toArray(arrayOfa);
          int j = arrayOfa.length;
          int i = 0;
          if (i < j)
          {
            arrayOfa[i].a(localc.iGV.mAppId, paramAnonymousb);
            i += 1;
          }
        }
        AppMethodBeat.o(134711);
      }
      
      final void aQM()
      {
        AppMethodBeat.i(134710);
        c.this.iGV.finish();
        AppMethodBeat.o(134710);
      }
    };
    AppMethodBeat.o(134712);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(134713);
    if ((parama == null) || (this.iQP.iQZ.get()))
    {
      AppMethodBeat.o(134713);
      return;
    }
    synchronized (this.iQQ)
    {
      this.iQQ.put(parama, this);
      AppMethodBeat.o(134713);
      return;
    }
  }
  
  public final boolean aQL()
  {
    AppMethodBeat.i(134715);
    d locald = this.iQP;
    switch (d.7.iRi[locald.aQO().ordinal()])
    {
    default: 
      AppMethodBeat.o(134715);
      return false;
    case 1: 
      AppMethodBeat.o(134715);
      return true;
    case 2: 
    case 3: 
      AppMethodBeat.o(134715);
      return false;
    }
    boolean bool = ((Boolean)new d.5(locald, Boolean.FALSE).b(new ap(locald.EXN.getLooper()))).booleanValue();
    AppMethodBeat.o(134715);
    return bool;
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(134714);
    if ((parama == null) || (b.iQN == this.iQP.aQO()))
    {
      AppMethodBeat.o(134714);
      return;
    }
    synchronized (this.iQQ)
    {
      this.iQQ.remove(parama);
      AppMethodBeat.o(134714);
      return;
    }
  }
  
  public final void fp(boolean paramBoolean)
  {
    AppMethodBeat.i(162077);
    this.iQP.fp(paramBoolean);
    AppMethodBeat.o(162077);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.c
 * JD-Core Version:    0.7.0.1
 */