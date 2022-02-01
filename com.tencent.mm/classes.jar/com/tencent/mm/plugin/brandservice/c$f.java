package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.q;
import com.tencent.mm.plugin.brandservice.b.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.protocal.protobuf.gg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class c$f
  implements Runnable
{
  c$f(List paramList) {}
  
  public final void run()
  {
    AppMethodBeat.i(195083);
    Object localObject1 = g.pnw;
    localObject1 = this.jAe;
    int i = this.pmo;
    p.h(localObject1, "items");
    g.pnu = 0L;
    g.pnv.clear();
    LinkedList localLinkedList = new LinkedList();
    Object localObject3 = (Iterable)localObject1;
    Object localObject2 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    Object localObject4;
    Object localObject5;
    label147:
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((Iterator)localObject3).next();
      localObject5 = (q)localObject4;
      if (((q)localObject5).Url == null) {}
      for (boolean bool = false;; bool = UrlExKt.isMpArticleUrl((String)localObject5))
      {
        if (!bool) {
          break label147;
        }
        ((Collection)localObject2).add(localObject4);
        break;
        localObject5 = ((q)localObject5).Url;
        p.g(localObject5, "it.Url");
      }
    }
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (q)((Iterator)localObject2).next();
      localObject4 = new gg();
      ((gg)localObject4).Url = ((q)localObject3).Url;
      localObject5 = ((gg)localObject4).Url;
      p.g(localObject5, "appMsgUrlInfo.Url");
      ((gg)localObject4).izX = g.ahJ((String)localObject5);
      ((gg)localObject4).iAb = ((q)localObject3).iAb;
      ((gg)localObject4).ReqType = ((q)localObject3).ReqType;
      if (((gg)localObject4).ReqType > 0) {
        localLinkedList.add(localObject4);
      }
    }
    Log.v(g.TAG, "getAppMsgRelatedInfoForAppMsg size:" + ((List)localObject1).size());
    g.b(localLinkedList, i);
    AppMethodBeat.o(195083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.c.f
 * JD-Core Version:    0.7.0.1
 */