package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandPrepareTask$a$2
  implements com.tencent.mm.kernel.api.g
{
  AppBrandPrepareTask$a$2(AppBrandPrepareTask.a parama, com.tencent.mm.ipcinvoker.c paramc, d paramd) {}
  
  public final void aP(boolean paramBoolean) {}
  
  public final void tj()
  {
    com.tencent.mm.kernel.g.DN();
    boolean bool1 = a.Db();
    boolean bool2 = a.CW();
    if ((!bool1) || (bool2))
    {
      y.i("MicroMsg.AppBrandPrepareTask", "prepareCall, startup done, hasLogin %B, hold %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      ai.d(new AppBrandPrepareTask.a.2.1(this));
      if (this.gJs != null)
      {
        localObject = new AppBrandPrepareTask.PrepareResult();
        AppBrandPrepareTask.PrepareResult.a((AppBrandPrepareTask.PrepareResult)localObject, 3);
        this.gJs.U(localObject);
      }
      return;
    }
    Object localObject = new AppBrandPrepareTask.a.2.2(this);
    if (com.tencent.mm.kernel.g.DN().dJH)
    {
      ((com.tencent.mm.sdk.b.c)localObject).a(null);
      return;
    }
    y.i("MicroMsg.AppBrandPrepareTask", "prepareCall account not notifyAllDone yet, wait for it");
    ((com.tencent.mm.sdk.b.c)localObject).cqo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a.2
 * JD-Core Version:    0.7.0.1
 */