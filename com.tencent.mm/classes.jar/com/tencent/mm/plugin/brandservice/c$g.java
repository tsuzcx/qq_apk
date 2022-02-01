package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.q;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.protocal.protobuf.gg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class c$g
  implements Runnable
{
  c$g(List paramList, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(6450);
    Object localObject1 = com.tencent.mm.plugin.brandservice.b.g.pnw;
    Object localObject2 = this.jAe;
    int i = this.pmo;
    p.h(localObject2, "items");
    com.tencent.mm.plugin.brandservice.b.g.pnu = 0L;
    com.tencent.mm.plugin.brandservice.b.g.pnv.clear();
    localObject1 = new LinkedList();
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (q)((Iterator)localObject3).next();
      j.a((Collection)localObject2, (Iterable)((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(((q)localObject4).msgId, ((q)localObject4).iAc).iAd);
    }
    localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    Object localObject5;
    label241:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      localObject5 = (v)localObject4;
      if (((v)localObject5).url == null) {}
      for (boolean bool = false;; bool = UrlExKt.isMpArticleUrl((String)localObject5))
      {
        if (!bool) {
          break label241;
        }
        ((Collection)localObject2).add(localObject4);
        break;
        localObject5 = ((v)localObject5).url;
        p.g(localObject5, "it.url");
      }
    }
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (v)((Iterator)localObject2).next();
      localObject3 = new gg();
      ((gg)localObject3).Url = ((v)localObject4).url;
      localObject5 = ((gg)localObject3).Url;
      p.g(localObject5, "appMsgUrlInfo.Url");
      ((gg)localObject3).izX = com.tencent.mm.plugin.brandservice.b.g.ahJ((String)localObject5);
      ((gg)localObject3).iAb = ((v)localObject4).type;
      ((gg)localObject3).KKb = ((v)localObject4).iAH;
      if (i == 0)
      {
        if (((v)localObject4).iwf == 1)
        {
          localObject4 = com.tencent.mm.plugin.brandservice.b.a.pmT;
          if (com.tencent.mm.plugin.brandservice.b.a.cle())
          {
            ((gg)localObject3).ReqType = 2;
            ((LinkedList)localObject1).add(localObject3);
          }
        }
      }
      else
      {
        if (((v)localObject4).iwf == 1)
        {
          localObject4 = com.tencent.mm.plugin.brandservice.b.a.pmT;
          if (!com.tencent.mm.plugin.brandservice.b.a.cle()) {}
        }
        for (((gg)localObject3).ReqType = 3;; ((gg)localObject3).ReqType = 1)
        {
          ((LinkedList)localObject1).add(localObject3);
          break;
        }
      }
    }
    Log.v(com.tencent.mm.plugin.brandservice.b.g.TAG, "getAppMsgRelatedInfoForBizMsg size:" + ((LinkedList)localObject1).size());
    com.tencent.mm.plugin.brandservice.b.g.b((LinkedList)localObject1, i);
    AppMethodBeat.o(6450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.c.g
 * JD-Core Version:    0.7.0.1
 */