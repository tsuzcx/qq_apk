package com.tencent.mm.plugin.appbrand.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.b.b;
import com.tencent.mm.plugin.appbrand.game.b.f;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.n;

final class g$10
  extends com.tencent.mm.plugin.fts.a.a.a
{
  g$10(g paramg) {}
  
  public final boolean execute()
  {
    AppMethodBeat.i(129250);
    Object localObject = new com.tencent.mm.plugin.appbrand.game.b.a();
    ((n)com.tencent.mm.kernel.g.G(n.class)).registerIndexStorage((i)localObject);
    ((i)localObject).create();
    localObject = new b();
    ((n)com.tencent.mm.kernel.g.G(n.class)).registerNativeLogic(10, (k)localObject);
    ((k)localObject).create();
    localObject = new f();
    ((n)com.tencent.mm.kernel.g.G(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new com.tencent.mm.plugin.appbrand.game.b.d();
    ((n)com.tencent.mm.kernel.g.G(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    AppMethodBeat.o(129250);
    return true;
  }
  
  public final String getName()
  {
    return "InitFTSMiniGamePluginTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.g.10
 * JD-Core Version:    0.7.0.1
 */