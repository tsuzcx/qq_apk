package com.tencent.mm.bs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.t;
import com.tencent.mm.model.t.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
{
  public static m Fmq;
  public static l Fmr;
  
  public static void aNQ(String paramString)
  {
    AppMethodBeat.i(133693);
    if (((h)com.tencent.mm.kernel.g.ajz().ajb()).akw()) {
      d.a(paramString, Fmq, Fmr);
    }
    AppMethodBeat.o(133693);
  }
  
  public static t.a aNR(String paramString)
  {
    AppMethodBeat.i(133695);
    t.a local2 = new t.a()
    {
      public final ax createSubCore()
      {
        AppMethodBeat.i(133692);
        ax localax = d.aNT(this.Fms);
        AppMethodBeat.o(133692);
        return localax;
      }
    };
    ad.i("MicroMsg.PluginCompatHelper", "CompatSubCore creator %s for plugin %s", new Object[] { local2, paramString });
    AppMethodBeat.o(133695);
    return local2;
  }
  
  public static void b(String paramString, final t paramt)
  {
    AppMethodBeat.i(133694);
    new a()
    {
      public final void execute(com.tencent.mm.kernel.b.g paramAnonymousg)
      {
        AppMethodBeat.i(133691);
        String str = this.Fms;
        t localt = paramt;
        d.a(str, c.Fmq, c.Fmr);
        paramAnonymousg = localt;
        if (localt == null) {
          paramAnonymousg = new t(c.aNR(str));
        }
        t.a("plugin.".concat(String.valueOf(str)), paramAnonymousg);
        AppMethodBeat.o(133691);
      }
    }.alone();
    AppMethodBeat.o(133694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bs.c
 * JD-Core Version:    0.7.0.1
 */