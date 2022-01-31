package com.tencent.luggage.game.a;

import com.tencent.luggage.g.d;
import com.tencent.magicbrush.MBRuntime.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.g;
import com.tencent.mm.plugin.appbrand.i.i;
import com.tencent.mm.plugin.appbrand.i.q;
import com.tencent.mm.plugin.appbrand.jsapi.bs;
import com.tencent.mm.plugin.appbrand.jsapi.bt;
import com.tencent.mm.plugin.appbrand.t.m;
import com.tencent.mm.sdk.platformtools.f;

final class c$b
  extends MBRuntime.a
{
  c$b(c paramc) {}
  
  public final void onJsExceptionOccurred(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(140328);
    d.e("MicroMsg.MBRuntimeSimple", "[WAGame][AppBrand] message = [%s] stackTrace = [%s]", new Object[] { paramString1, paramString2 });
    if (this.bzQ.bzL == null)
    {
      AppMethodBeat.o(140328);
      return;
    }
    Object localObject = (q)this.bzQ.bzL.v(q.class);
    if (paramInt == ((q)localObject).aGB().aGA())
    {
      bs.a(this.bzQ.bzL, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[] { m.Fr(paramString1), m.Fr(paramString2) }), 0);
      AppMethodBeat.o(140328);
      return;
    }
    localObject = ((q)localObject).ow(paramInt);
    if (localObject == null)
    {
      if (f.DEBUG)
      {
        paramString1 = new IllegalStateException("[DebugOnly] j2v8 not follow the pattern");
        AppMethodBeat.o(140328);
        throw paramString1;
      }
      AppMethodBeat.o(140328);
      return;
    }
    bt.a((i)localObject, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[] { m.Fr(paramString1), m.Fr(paramString2) }));
    AppMethodBeat.o(140328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.game.a.c.b
 * JD-Core Version:    0.7.0.1
 */