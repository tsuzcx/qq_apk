package com.tencent.mm.plugin.appbrand.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  public static boolean qKB = false;
  public final d qKC;
  public final androidx.b.a<c.a, c> qKD;
  private final AppBrandRuntime qwG;
  
  public c(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(134712);
    this.qKD = new androidx.b.a();
    this.qwG = paramAppBrandRuntime;
    this.qKC = new d(paramAppBrandRuntime)
    {
      final void a(b paramAnonymousb)
      {
        AppMethodBeat.i(134711);
        c.a(c.this, paramAnonymousb);
        AppMethodBeat.o(134711);
      }
      
      final void chB()
      {
        AppMethodBeat.i(134710);
        c.a(c.this).finish();
        c.a(c.this, new androidx.a.a.c.a() {});
        AppMethodBeat.o(134710);
      }
    };
    AppMethodBeat.o(134712);
  }
  
  public final void a(c.a parama)
  {
    AppMethodBeat.i(134713);
    if ((parama == null) || (this.qKC.qKN.get()))
    {
      AppMethodBeat.o(134713);
      return;
    }
    synchronized (this.qKD)
    {
      this.qKD.put(parama, this);
      AppMethodBeat.o(134713);
      return;
    }
  }
  
  public final void b(c.a parama)
  {
    AppMethodBeat.i(134714);
    if ((parama == null) || (b.qKz == this.qKC.chD()))
    {
      AppMethodBeat.o(134714);
      return;
    }
    synchronized (this.qKD)
    {
      this.qKD.remove(parama);
      AppMethodBeat.o(134714);
      return;
    }
  }
  
  public final void chA()
  {
    AppMethodBeat.i(316949);
    this.qKC.a(d.a.qLl);
    AppMethodBeat.o(316949);
  }
  
  public final void im(boolean paramBoolean)
  {
    AppMethodBeat.i(162077);
    this.qKC.im(paramBoolean);
    AppMethodBeat.o(162077);
  }
  
  public static abstract interface b
    extends c.a
  {
    public abstract void ccv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.c
 * JD-Core Version:    0.7.0.1
 */