package com.tencent.mm.plugin.appbrand.a;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  final AppBrandRuntime kEc;
  public final d kQM;
  public final a<a, c> kQN;
  
  public c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134712);
    this.kQN = new a();
    this.kEc = paramAppBrandRuntime;
    this.kQM = new d(paramAppBrandRuntime)
    {
      final void a(b paramAnonymousb)
      {
        AppMethodBeat.i(134711);
        c localc = c.this;
        synchronized (localc.kQN)
        {
          c.a[] arrayOfa = new c.a[localc.kQN.size()];
          arrayOfa = (c.a[])localc.kQN.keySet().toArray(arrayOfa);
          int j = arrayOfa.length;
          int i = 0;
          if (i < j)
          {
            arrayOfa[i].a(localc.kEc.mAppId, paramAnonymousb);
            i += 1;
          }
        }
        AppMethodBeat.o(134711);
      }
      
      final void bwW()
      {
        AppMethodBeat.i(134710);
        c.this.kEc.finish();
        AppMethodBeat.o(134710);
      }
    };
    AppMethodBeat.o(134712);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(134713);
    if ((parama == null) || (this.kQM.kQW.get()))
    {
      AppMethodBeat.o(134713);
      return;
    }
    synchronized (this.kQN)
    {
      this.kQN.put(parama, this);
      AppMethodBeat.o(134713);
      return;
    }
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(134714);
    if ((parama == null) || (b.kQK == this.kQM.bwY()))
    {
      AppMethodBeat.o(134714);
      return;
    }
    synchronized (this.kQN)
    {
      this.kQN.remove(parama);
      AppMethodBeat.o(134714);
      return;
    }
  }
  
  public final void gK(boolean paramBoolean)
  {
    AppMethodBeat.i(162077);
    this.kQM.gK(paramBoolean);
    AppMethodBeat.o(162077);
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.c
 * JD-Core Version:    0.7.0.1
 */