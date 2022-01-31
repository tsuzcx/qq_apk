package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class AppBrandPrepareTask$a$2
  implements com.tencent.mm.kernel.api.g
{
  AppBrandPrepareTask$a$2(AppBrandPrepareTask.a parama, com.tencent.mm.ipcinvoker.c paramc, g paramg, String paramString, int paramInt1, int paramInt2, AppBrandPrepareTask.PrepareParams paramPrepareParams) {}
  
  public final void BN()
  {
    AppMethodBeat.i(131746);
    com.tencent.mm.kernel.g.RM().b(this);
    com.tencent.mm.kernel.g.RJ();
    boolean bool1 = a.QT();
    boolean bool2 = a.QP();
    Object localObject;
    if ((!bool1) || (bool2))
    {
      ab.i("MicroMsg.AppBrandPrepareTask", "prepareCall, startup done, hasLogin %B, hold %B", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      al.d(new AppBrandPrepareTask.a.2.1(this));
      if (this.ika != null)
      {
        localObject = new AppBrandPrepareTask.PrepareResult();
        AppBrandPrepareTask.PrepareResult.a((AppBrandPrepareTask.PrepareResult)localObject, 3);
        this.ika.ad(localObject);
        AppMethodBeat.o(131746);
      }
    }
    else
    {
      localObject = new AppBrandPrepareTask.a.2.2(this);
      if (com.tencent.mm.kernel.g.RJ().eHg)
      {
        ((com.tencent.mm.sdk.b.c)localObject).callback(null);
        AppMethodBeat.o(131746);
        return;
      }
      ab.i("MicroMsg.AppBrandPrepareTask", "prepareCall account not notifyAllDone yet, wait for it");
      ((com.tencent.mm.sdk.b.c)localObject).alive();
    }
    AppMethodBeat.o(131746);
  }
  
  public final void br(boolean paramBoolean)
  {
    AppMethodBeat.i(131747);
    com.tencent.mm.kernel.g.RM().b(this);
    ab.i("MicroMsg.AppBrandPrepareTask", "kernel onExit(%b), kill prepare process appId[%s] type[%d] scene[%d] sessionId[%s]", new Object[] { Boolean.valueOf(paramBoolean), this.val$appId, Integer.valueOf(this.gWI), Integer.valueOf(this.ikf), AppBrandPrepareTask.PrepareParams.h(this.ikb) });
    if (this.ika != null)
    {
      AppBrandPrepareTask.PrepareResult localPrepareResult = new AppBrandPrepareTask.PrepareResult();
      AppBrandPrepareTask.PrepareResult.a(localPrepareResult, 3);
      this.ika.ad(localPrepareResult);
    }
    AppMethodBeat.o(131747);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a.2
 * JD-Core Version:    0.7.0.1
 */