package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.q;
import com.tencent.mm.plugin.appbrand.launching.precondition.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.k;
import com.tencent.mm.plugin.appbrand.report.model.k.a;
import com.tencent.mm.plugin.appbrand.report.model.k.b;
import com.tencent.mm.protocal.protobuf.asv;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class i$5
  implements Runnable
{
  i$5(i parami) {}
  
  public final void run()
  {
    int j = 0;
    AppMethodBeat.i(133449);
    if (i.f(this.iUG) == null)
    {
      AppMethodBeat.o(133449);
      return;
    }
    Object localObject1 = q.axj();
    Object localObject2;
    if (localObject1 != null)
    {
      int i;
      if (((asv)localObject1).xia == 1) {
        i = 1;
      }
      while (i != 0)
      {
        localObject2 = ((asv)localObject1).xib;
        if (localObject2 == null)
        {
          ab.e("MicroMsg.AppBrandLauncherRecentsListHeader", "onCellClicked, useMiniProgram but invalid appInfo, just return");
          AppMethodBeat.o(133449);
          return;
          i = 0;
        }
        else
        {
          if (b.dsf()) {
            j = ((bfs)localObject2).type;
          }
          AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
          localAppBrandStatObject.scene = 1001;
          f.ioc.a(i.f(this.iUG), ((bfs)localObject2).username, null, ((bfs)localObject2).path, j, ((bfs)localObject2).wAy, localAppBrandStatObject, null, null);
          i.g(this.iUG);
          localObject2 = new k();
          ((k)localObject2).iHs = k.b.iHF;
          ((k)localObject2).iHt = ((asv)localObject1).jAI;
          ((k)localObject2).iHu = ((asv)localObject1).xhO;
          if (i == 0) {
            break label257;
          }
        }
      }
    }
    label257:
    for (localObject1 = k.a.iHA;; localObject1 = k.a.iHx)
    {
      ((k)localObject2).iHw = ((k.a)localObject1);
      ((k)localObject2).IE();
      AppMethodBeat.o(133449);
      return;
      if (!bo.isNullOrNil(((asv)localObject1).xhQ))
      {
        ((com.tencent.mm.plugin.appbrand.compat.a.a)g.E(com.tencent.mm.plugin.appbrand.compat.a.a.class)).T(i.f(this.iUG), ((asv)localObject1).xhQ);
        break;
      }
      ab.e("MicroMsg.AppBrandLauncherRecentsListHeader", "onCellClicked, useMiniProgram false, url empty, just return");
      AppMethodBeat.o(133449);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.i.5
 * JD-Core Version:    0.7.0.1
 */