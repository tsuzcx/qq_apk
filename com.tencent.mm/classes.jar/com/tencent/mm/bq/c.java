package com.tencent.mm.bq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.model.q.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
{
  public static n wgQ;
  public static m wgR;
  
  public static void anb(String paramString)
  {
    AppMethodBeat.i(114682);
    if (((h)g.RI().Rj()).SD()) {
      d.a(paramString, wgQ, wgR);
    }
    AppMethodBeat.o(114682);
  }
  
  public static q.a anc(String paramString)
  {
    AppMethodBeat.i(114684);
    q.a local2 = new q.a()
    {
      public final at createSubCore()
      {
        AppMethodBeat.i(114681);
        at localat = d.ane(this.wgS);
        AppMethodBeat.o(114681);
        return localat;
      }
    };
    ab.i("MicroMsg.PluginCompatHelper", "CompatSubCore creator %s for plugin %s", new Object[] { local2, paramString });
    AppMethodBeat.o(114684);
    return local2;
  }
  
  public static void b(String paramString, q paramq)
  {
    AppMethodBeat.i(114683);
    new c.1(paramString, paramq).alone();
    AppMethodBeat.o(114683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bq.c
 * JD-Core Version:    0.7.0.1
 */