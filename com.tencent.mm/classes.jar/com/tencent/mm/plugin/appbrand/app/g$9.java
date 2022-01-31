package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.e;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.d.d;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.n;

final class g$9
  extends a
{
  g$9(g paramg) {}
  
  public final boolean execute()
  {
    AppMethodBeat.i(129249);
    Object localObject = new c();
    ((n)com.tencent.mm.kernel.g.G(n.class)).registerIndexStorage((i)localObject);
    ((i)localObject).create();
    localObject = new b();
    ((n)com.tencent.mm.kernel.g.G(n.class)).registerNativeLogic(7, (k)localObject);
    ((k)localObject).create();
    localObject = new com.tencent.mm.plugin.appbrand.g.g();
    ((n)com.tencent.mm.kernel.g.G(n.class)).registerFTSUILogic((d)localObject);
    localObject = new e();
    ((n)com.tencent.mm.kernel.g.G(n.class)).registerFTSUILogic((d)localObject);
    AppMethodBeat.o(129249);
    return true;
  }
  
  public final String getName()
  {
    return "InitFTSWeAppPluginTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.g.9
 * JD-Core Version:    0.7.0.1
 */