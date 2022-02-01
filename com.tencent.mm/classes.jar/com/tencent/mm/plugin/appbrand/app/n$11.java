package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.j.b;
import com.tencent.mm.plugin.appbrand.j.c;
import com.tencent.mm.plugin.appbrand.j.e;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.d.d;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.k;

final class n$11
  extends a
{
  n$11(n paramn)
  {
    AppMethodBeat.i(160575);
    AppMethodBeat.o(160575);
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(226332);
    Object localObject = new c();
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.fts.a.n.class)).registerIndexStorage((i)localObject);
    ((i)localObject).create();
    localObject = new b();
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.fts.a.n.class)).registerNativeLogic(7, (k)localObject);
    ((k)localObject).create();
    localObject = new com.tencent.mm.plugin.appbrand.j.g();
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic((d)localObject);
    localObject = new e();
    ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic((d)localObject);
    AppMethodBeat.o(226332);
    return true;
  }
  
  public final String getName()
  {
    return "InitFTSWeAppPluginTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.n.11
 * JD-Core Version:    0.7.0.1
 */