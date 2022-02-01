package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.j.b;
import com.tencent.mm.plugin.appbrand.j.c;
import com.tencent.mm.plugin.appbrand.j.e;
import com.tencent.mm.plugin.appbrand.j.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.d.d;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.n;

final class m$14
  extends a
{
  m$14(m paramm)
  {
    AppMethodBeat.i(160577);
    AppMethodBeat.o(160577);
  }
  
  public final boolean aEv()
  {
    AppMethodBeat.i(266199);
    Object localObject = new c();
    ((n)h.ag(n.class)).registerIndexStorage((i)localObject);
    ((i)localObject).create();
    localObject = new b();
    ((n)h.ag(n.class)).registerNativeLogic(7, (k)localObject);
    ((k)localObject).create();
    localObject = new g();
    ((n)h.ag(n.class)).registerFTSUILogic((d)localObject);
    localObject = new e();
    ((n)h.ag(n.class)).registerFTSUILogic((d)localObject);
    AppMethodBeat.o(266199);
    return true;
  }
  
  public final String getName()
  {
    return "InitFTSWeAppPluginTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.m.14
 * JD-Core Version:    0.7.0.1
 */