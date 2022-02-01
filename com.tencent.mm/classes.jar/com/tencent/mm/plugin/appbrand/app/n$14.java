package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.j.b;
import com.tencent.mm.plugin.appbrand.j.e;
import com.tencent.mm.plugin.appbrand.j.g;
import com.tencent.mm.plugin.fts.a.d.d;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.k;

final class n$14
  extends com.tencent.mm.plugin.fts.a.a.c
{
  n$14(n paramn)
  {
    AppMethodBeat.i(160577);
    AppMethodBeat.o(160577);
  }
  
  public final boolean aXz()
  {
    AppMethodBeat.i(317689);
    Object localObject = new com.tencent.mm.plugin.appbrand.j.c();
    ((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).registerIndexStorage((i)localObject);
    ((i)localObject).create();
    localObject = new b();
    ((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).registerNativeLogic(7, (k)localObject);
    ((k)localObject).create();
    localObject = new g();
    ((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic((d)localObject);
    localObject = new e();
    ((com.tencent.mm.plugin.fts.a.n)h.az(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic((d)localObject);
    AppMethodBeat.o(317689);
    return true;
  }
  
  public final String getName()
  {
    return "InitFTSWeAppPluginTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.n.14
 * JD-Core Version:    0.7.0.1
 */