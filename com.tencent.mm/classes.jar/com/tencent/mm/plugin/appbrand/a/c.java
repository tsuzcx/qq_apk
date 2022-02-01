package com.tencent.mm.plugin.appbrand.a;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  public final d jKT;
  public final a<c.a, c> jKU;
  final AppBrandRuntime jzY;
  
  public c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134712);
    this.jKU = new a();
    this.jzY = paramAppBrandRuntime;
    this.jKT = new d(paramAppBrandRuntime)
    {
      final void a(b paramAnonymousb)
      {
        AppMethodBeat.i(134711);
        c localc = c.this;
        synchronized (localc.jKU)
        {
          c.a[] arrayOfa = new c.a[localc.jKU.size()];
          arrayOfa = (c.a[])localc.jKU.keySet().toArray(arrayOfa);
          int j = arrayOfa.length;
          int i = 0;
          if (i < j)
          {
            arrayOfa[i].a(localc.jzY.mAppId, paramAnonymousb);
            i += 1;
          }
        }
        AppMethodBeat.o(134711);
      }
      
      final void bbe()
      {
        AppMethodBeat.i(134710);
        c.this.jzY.finish();
        AppMethodBeat.o(134710);
      }
    };
    AppMethodBeat.o(134712);
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(134713);
    if ((parama == null) || (this.jKT.jLd.get()))
    {
      AppMethodBeat.o(134713);
      return;
    }
    synchronized (this.jKU)
    {
      this.jKU.put(parama, this);
      AppMethodBeat.o(134713);
      return;
    }
  }
  
  public final void b(c.a parama)
  {
    AppMethodBeat.i(134714);
    if ((parama == null) || (b.jKR == this.jKT.bbg()))
    {
      AppMethodBeat.o(134714);
      return;
    }
    synchronized (this.jKU)
    {
      this.jKU.remove(parama);
      AppMethodBeat.o(134714);
      return;
    }
  }
  
  public final void fP(boolean paramBoolean)
  {
    AppMethodBeat.i(162077);
    this.jKT.fP(paramBoolean);
    AppMethodBeat.o(162077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.c
 * JD-Core Version:    0.7.0.1
 */