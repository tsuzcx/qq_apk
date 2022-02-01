package com.tencent.mm.br;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static m Ywg;
  public static l Ywh;
  
  public static void b(String paramString, final y paramy)
  {
    AppMethodBeat.i(133694);
    new a()
    {
      public final void execute(g paramAnonymousg)
      {
        AppMethodBeat.i(133691);
        String str = b.this;
        y localy = paramy;
        c.a(str, b.Ywg, b.Ywh);
        paramAnonymousg = localy;
        if (localy == null) {
          paramAnonymousg = new y(b.bsb(str));
        }
        y.a("plugin.".concat(String.valueOf(str)), paramAnonymousg);
        AppMethodBeat.o(133691);
      }
    }.alone();
    AppMethodBeat.o(133694);
  }
  
  public static void bsa(String paramString)
  {
    AppMethodBeat.i(133693);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA()) {
      c.a(paramString, Ywg, Ywh);
    }
    AppMethodBeat.o(133693);
  }
  
  public static y.a bsb(String paramString)
  {
    AppMethodBeat.i(133695);
    y.a local2 = new y.a()
    {
      public final be createSubCore()
      {
        AppMethodBeat.i(133692);
        be localbe = c.bsd(b.this);
        AppMethodBeat.o(133692);
        return localbe;
      }
    };
    Log.i("MicroMsg.PluginCompatHelper", "CompatSubCore creator %s for plugin %s", new Object[] { local2, paramString });
    AppMethodBeat.o(133695);
    return local2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.br.b
 * JD-Core Version:    0.7.0.1
 */