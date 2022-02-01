package com.tencent.mm.plugin.appbrand.b;

import android.os.Handler;
import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  final AppBrandRuntime jgY;
  public final d jqZ;
  public final a<a, c> jra;
  
  public c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134712);
    this.jra = new a();
    this.jgY = paramAppBrandRuntime;
    this.jqZ = new d(paramAppBrandRuntime)
    {
      final void a(b paramAnonymousb)
      {
        AppMethodBeat.i(134711);
        c localc = c.this;
        synchronized (localc.jra)
        {
          c.a[] arrayOfa = new c.a[localc.jra.size()];
          arrayOfa = (c.a[])localc.jra.keySet().toArray(arrayOfa);
          int j = arrayOfa.length;
          int i = 0;
          if (i < j)
          {
            arrayOfa[i].a(localc.jgY.mAppId, paramAnonymousb);
            i += 1;
          }
        }
        AppMethodBeat.o(134711);
      }
      
      final void aXH()
      {
        AppMethodBeat.i(134710);
        c.this.jgY.finish();
        AppMethodBeat.o(134710);
      }
    };
    AppMethodBeat.o(134712);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(134713);
    if ((parama == null) || (this.jqZ.jrj.get()))
    {
      AppMethodBeat.o(134713);
      return;
    }
    synchronized (this.jra)
    {
      this.jra.put(parama, this);
      AppMethodBeat.o(134713);
      return;
    }
  }
  
  public final boolean aXG()
  {
    AppMethodBeat.i(134715);
    d locald = this.jqZ;
    switch (d.7.jrs[locald.aXJ().ordinal()])
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
    boolean bool = ((Boolean)new d.5(locald, Boolean.FALSE).b(new ao(locald.GuZ.getLooper()))).booleanValue();
    AppMethodBeat.o(134715);
    return bool;
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(134714);
    if ((parama == null) || (b.jqX == this.jqZ.aXJ()))
    {
      AppMethodBeat.o(134714);
      return;
    }
    synchronized (this.jra)
    {
      this.jra.remove(parama);
      AppMethodBeat.o(134714);
      return;
    }
  }
  
  public final void fL(boolean paramBoolean)
  {
    AppMethodBeat.i(162077);
    this.jqZ.fL(paramBoolean);
    AppMethodBeat.o(162077);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.c
 * JD-Core Version:    0.7.0.1
 */