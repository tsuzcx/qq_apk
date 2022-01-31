package com.tencent.luggage.sdk.d;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.luggage.g.d;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.a.a.b;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

final class a$2
  implements Runnable
{
  a$2(a parama, b paramb, AppBrandInitConfigLU paramAppBrandInitConfigLU, AppBrandStatObject paramAppBrandStatObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(140795);
    n.w(this.bFc.gQx);
    if (this.bFd == null) {
      this.bFc.atI();
    }
    a locala = this.bFc;
    Object localObject2 = this.bFe.appId;
    Object localObject3 = locala.gQz.iterator();
    Object localObject1;
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (com.tencent.mm.plugin.appbrand.i)((Iterator)localObject3).next();
      if (((com.tencent.mm.plugin.appbrand.i)localObject1).mAppId.equals(localObject2))
      {
        localObject1 = (b)localObject1;
        this.bFe.bDh = this.bFf;
        if (localObject1 != null) {
          break label292;
        }
        localObject1 = (b)this.bFc.g(this.bFe);
        locala = this.bFc;
        localObject4 = this.bFe;
        if ((!TextUtils.isEmpty(((AppBrandInitConfigLU)localObject4).hha)) && (((AppBrandInitConfigLU)localObject4).vY())) {
          break label208;
        }
        label148:
        this.bFc.a(this.bFd, (com.tencent.mm.plugin.appbrand.i)localObject1, this.bFe);
      }
    }
    for (;;)
    {
      if (this.bFc.g((com.tencent.mm.plugin.appbrand.i)localObject1))
      {
        if (((b)localObject1).ati() != null)
        {
          ((com.tencent.mm.plugin.appbrand.i)localObject1).gPQ = true;
          AppMethodBeat.o(140795);
          return;
          localObject1 = (com.tencent.mm.plugin.appbrand.i)locala.gQA.get(localObject2);
          break;
          label208:
          localObject2 = locala.gQB.getContext();
          if ((localObject2 == null) || (((Activity)localObject2).isFinishing())) {
            break label148;
          }
          localObject3 = ((AppBrandInitConfigLU)localObject4).appId;
          d.i("Luggage.AppBrandRuntimeContainerLU", "tryRequestOrientation appId[%s] orientation[%s]", new Object[] { ((AppBrandInitConfigLU)localObject4).appId, ((AppBrandInitConfigLU)localObject4).hha });
          localObject4 = com.tencent.mm.plugin.appbrand.config.a.a.j((AppBrandInitConfig)localObject4);
          com.tencent.mm.plugin.appbrand.config.a.a.s((Activity)localObject2).a((a.b)localObject4, new a.3(locala, (String)localObject3));
          break label148;
          label292:
          if (this.bFd == localObject1)
          {
            this.bFc.b(null, (com.tencent.mm.plugin.appbrand.i)localObject1, this.bFe);
            this.bFc.onResume();
            continue;
          }
          this.bFc.b(this.bFd, (com.tencent.mm.plugin.appbrand.i)localObject1, this.bFe);
          continue;
        }
        ((com.tencent.mm.plugin.appbrand.i)localObject1).gPQ = false;
      }
    }
    AppMethodBeat.o(140795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.d.a.2
 * JD-Core Version:    0.7.0.1
 */