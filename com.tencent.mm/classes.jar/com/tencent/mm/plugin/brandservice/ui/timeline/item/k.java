package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.oq;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.protocal.protobuf.pl;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"isExpire", "", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "toBizRecArticleCardLite", "Lcom/tencent/mm/protocal/protobuf/BizRecArticleCardLite;", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "plugin-brandservice_release"})
public final class k
{
  public static final pl l(z paramz)
  {
    AppMethodBeat.i(195295);
    p.h(paramz, "$this$toBizRecArticleCardLite");
    pl localpl = new pl();
    localpl.KWz = paramz.field_msgId;
    localpl.KUh = paramz.NQn.style;
    localpl.KUi = paramz.NQn.event;
    localpl.KWA = paramz.NQn.dSJ;
    LinkedList localLinkedList1 = localpl.KUf;
    paramz = paramz.gAD().Nga.KUf;
    p.g(paramz, "info.tlRecCardWrapper.extraInfo.BizInfo");
    Object localObject1 = (Iterable)paramz;
    paramz = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (pj)((Iterator)localObject1).next();
      oq localoq = new oq();
      localoq.KSV = ((pj)localObject2).UserName;
      LinkedList localLinkedList2 = localoq.KUB;
      localObject2 = ((pj)localObject2).KWy;
      p.g(localObject2, "info.AppMsg");
      Object localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(((pi)((Iterator)localObject3).next()).KSj);
      }
      localLinkedList2.addAll((Collection)localObject2);
      paramz.add(localoq);
    }
    localLinkedList1.addAll((Collection)paramz);
    AppMethodBeat.o(195295);
    return localpl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.k
 * JD-Core Version:    0.7.0.1
 */