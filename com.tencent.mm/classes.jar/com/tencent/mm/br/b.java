package com.tencent.mm.br;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.a;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static m KxT;
  public static l KxU;
  
  public static void b(String paramString, final y paramy)
  {
    AppMethodBeat.i(133694);
    new a()
    {
      public final void execute(com.tencent.mm.kernel.b.g paramAnonymousg)
      {
        AppMethodBeat.i(133691);
        String str = this.KxV;
        y localy = paramy;
        c.a(str, b.KxT, b.KxU);
        paramAnonymousg = localy;
        if (localy == null) {
          paramAnonymousg = new y(b.bfR(str));
        }
        y.a("plugin.".concat(String.valueOf(str)), paramAnonymousg);
        AppMethodBeat.o(133691);
      }
    }.alone();
    AppMethodBeat.o(133694);
  }
  
  public static void bfQ(String paramString)
  {
    AppMethodBeat.i(133693);
    if (((h)com.tencent.mm.kernel.g.aAe().azG()).aBb()) {
      c.a(paramString, KxT, KxU);
    }
    AppMethodBeat.o(133693);
  }
  
  public static y.a bfR(String paramString)
  {
    AppMethodBeat.i(133695);
    y.a local2 = new y.a()
    {
      public final bd createSubCore()
      {
        AppMethodBeat.i(133692);
        bd localbd = c.bfT(this.KxV);
        AppMethodBeat.o(133692);
        return localbd;
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