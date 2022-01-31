package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.game.a.b;
import com.tencent.mm.plugin.appbrand.game.a.f;
import com.tencent.mm.plugin.fts.a.i;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.n;

final class e$10
  extends com.tencent.mm.plugin.fts.a.a.a
{
  e$10(e parame) {}
  
  public final boolean execute()
  {
    Object localObject = new com.tencent.mm.plugin.appbrand.game.a.a();
    ((n)g.t(n.class)).registerIndexStorage((i)localObject);
    ((i)localObject).create();
    localObject = new b();
    ((n)g.t(n.class)).registerNativeLogic(10, (k)localObject);
    ((k)localObject).create();
    localObject = new f();
    ((n)g.t(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    localObject = new com.tencent.mm.plugin.appbrand.game.a.d();
    ((n)g.t(n.class)).registerFTSUILogic((com.tencent.mm.plugin.fts.a.d.d)localObject);
    return true;
  }
  
  public final String getName()
  {
    return "InitFTSMiniGamePluginTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.e.10
 * JD-Core Version:    0.7.0.1
 */