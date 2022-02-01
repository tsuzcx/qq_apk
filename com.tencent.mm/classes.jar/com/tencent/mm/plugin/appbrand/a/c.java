package com.tencent.mm.plugin.appbrand.a;

import androidx.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  public final d nKU;
  public final a<a, c> nKV;
  final AppBrandRuntime nxs;
  
  public c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134712);
    this.nKV = new a();
    this.nxs = paramAppBrandRuntime;
    this.nKU = new d(paramAppBrandRuntime)
    {
      final void a(b paramAnonymousb)
      {
        AppMethodBeat.i(134711);
        c localc = c.this;
        synchronized (localc.nKV)
        {
          c.a[] arrayOfa = new c.a[localc.nKV.size()];
          arrayOfa = (c.a[])localc.nKV.keySet().toArray(arrayOfa);
          int j = arrayOfa.length;
          int i = 0;
          if (i < j)
          {
            arrayOfa[i].a(localc.nxs.mAppId, paramAnonymousb);
            i += 1;
          }
        }
      }
      
      final void bIe()
      {
        AppMethodBeat.i(134710);
        c.this.nxs.finish();
        AppMethodBeat.o(134710);
      }
    };
    AppMethodBeat.o(134712);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(134713);
    if ((parama == null) || (this.nKU.nLe.get()))
    {
      AppMethodBeat.o(134713);
      return;
    }
    synchronized (this.nKV)
    {
      this.nKV.put(parama, this);
      AppMethodBeat.o(134713);
      return;
    }
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(134714);
    if ((parama == null) || (b.nKS == this.nKU.bIg()))
    {
      AppMethodBeat.o(134714);
      return;
    }
    synchronized (this.nKV)
    {
      this.nKV.remove(parama);
      AppMethodBeat.o(134714);
      return;
    }
  }
  
  public final void hv(boolean paramBoolean)
  {
    AppMethodBeat.i(162077);
    this.nKU.hv(paramBoolean);
    AppMethodBeat.o(162077);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.c
 * JD-Core Version:    0.7.0.1
 */