package com.tencent.mm.d.a;

import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.h;
import com.tencent.mm.plugin.appbrand.i.w;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public final class l
{
  public final c cbC;
  public final e cbD;
  final LinkedList<n> cbE;
  private final FutureTask<V8Context> cbF;
  V8Object cbG;
  public final f cbf;
  
  public l(c paramc, f paramf, l.a parama)
  {
    AppMethodBeat.i(113846);
    this.cbE = new LinkedList();
    this.cbG = null;
    this.cbC = paramc;
    this.cbF = new FutureTask(new l.1(this, parama));
    paramc.k(this.cbF);
    paramc = paramf;
    if (paramf == null) {
      paramc = new s();
    }
    this.cbf = paramc;
    this.cbD = new k(this);
    this.cbC.k(new l.6(this));
    AppMethodBeat.o(113846);
  }
  
  public final V8Context Cu()
  {
    AppMethodBeat.i(113847);
    try
    {
      V8Context localV8Context = (V8Context)this.cbF.get(10L, TimeUnit.SECONDS);
      AppMethodBeat.o(113847);
      return localV8Context;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.J2V8.V8ContextEngine", localException, "getV8Context failed", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  public final void a(int paramInt, h paramh)
  {
    AppMethodBeat.i(113850);
    this.cbC.a(paramInt, paramh);
    AppMethodBeat.o(113850);
  }
  
  public final void a(String paramString, l.b paramb)
  {
    AppMethodBeat.i(113848);
    this.cbC.k(new l.8(this, paramb, paramString));
    AppMethodBeat.o(113848);
  }
  
  public final void a(String paramString1, String paramString2, l.b paramb)
  {
    AppMethodBeat.i(113849);
    this.cbC.k(new l.9(this, paramString1, paramb, paramString2));
    AppMethodBeat.o(113849);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(113851);
    this.cbC.l(new l.2(this));
    AppMethodBeat.o(113851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.d.a.l
 * JD-Core Version:    0.7.0.1
 */