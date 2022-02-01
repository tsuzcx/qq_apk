package com.tencent.mm.plugin.appbrand.a;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  final AppBrandRuntime jDb;
  public final d jOf;
  public final a<c.a, c> jOg;
  
  public c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134712);
    this.jOg = new a();
    this.jDb = paramAppBrandRuntime;
    this.jOf = new d(paramAppBrandRuntime)
    {
      final void a(b paramAnonymousb)
      {
        AppMethodBeat.i(134711);
        c localc = c.this;
        synchronized (localc.jOg)
        {
          c.a[] arrayOfa = new c.a[localc.jOg.size()];
          arrayOfa = (c.a[])localc.jOg.keySet().toArray(arrayOfa);
          int j = arrayOfa.length;
          int i = 0;
          if (i < j)
          {
            arrayOfa[i].a(localc.jDb.mAppId, paramAnonymousb);
            i += 1;
          }
        }
        AppMethodBeat.o(134711);
      }
      
      final void bbG()
      {
        AppMethodBeat.i(134710);
        c.this.jDb.finish();
        AppMethodBeat.o(134710);
      }
    };
    AppMethodBeat.o(134712);
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(134713);
    if ((parama == null) || (this.jOf.jOp.get()))
    {
      AppMethodBeat.o(134713);
      return;
    }
    synchronized (this.jOg)
    {
      this.jOg.put(parama, this);
      AppMethodBeat.o(134713);
      return;
    }
  }
  
  public final void b(c.a parama)
  {
    AppMethodBeat.i(134714);
    if ((parama == null) || (b.jOd == this.jOf.bbI()))
    {
      AppMethodBeat.o(134714);
      return;
    }
    synchronized (this.jOg)
    {
      this.jOg.remove(parama);
      AppMethodBeat.o(134714);
      return;
    }
  }
  
  public final void fO(boolean paramBoolean)
  {
    AppMethodBeat.i(162077);
    this.jOf.fO(paramBoolean);
    AppMethodBeat.o(162077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.c
 * JD-Core Version:    0.7.0.1
 */