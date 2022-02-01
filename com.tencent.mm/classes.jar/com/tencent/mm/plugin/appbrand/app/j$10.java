package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.k.b;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.e;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.d.d;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.n;

final class j$10
  extends a
{
  j$10(j paramj) {}
  
  public final boolean execute()
  {
    AppMethodBeat.i(195606);
    Object localObject = new c();
    ((n)com.tencent.mm.kernel.g.ad(n.class)).registerIndexStorage((i)localObject);
    ((i)localObject).create();
    localObject = new b();
    ((n)com.tencent.mm.kernel.g.ad(n.class)).registerNativeLogic(7, (k)localObject);
    ((k)localObject).create();
    localObject = new com.tencent.mm.plugin.appbrand.k.g();
    ((n)com.tencent.mm.kernel.g.ad(n.class)).registerFTSUILogic((d)localObject);
    localObject = new e();
    ((n)com.tencent.mm.kernel.g.ad(n.class)).registerFTSUILogic((d)localObject);
    AppMethodBeat.o(195606);
    return true;
  }
  
  public final String getName()
  {
    return "InitFTSWeAppPluginTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.j.10
 * JD-Core Version:    0.7.0.1
 */