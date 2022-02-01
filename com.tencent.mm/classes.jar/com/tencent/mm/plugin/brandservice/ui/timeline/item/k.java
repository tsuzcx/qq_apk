package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.protocal.protobuf.ph;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"isExpire", "", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "toBizRecArticleCardLite", "Lcom/tencent/mm/protocal/protobuf/BizRecArticleCardLite;", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "plugin-brandservice_release"})
public final class k
{
  public static final ph l(z paramz)
  {
    AppMethodBeat.i(257938);
    p.k(paramz, "$this$toBizRecArticleCardLite");
    ph localph = new ph();
    localph.RXN = paramz.field_msgId;
    localph.RVf = paramz.Vei.style;
    localph.RVg = paramz.Vei.event;
    localph.RXO = paramz.Vei.fMh;
    LinkedList localLinkedList1 = localph.RVd;
    paramz = paramz.hwL().UsF.RVd;
    p.j(paramz, "info.tlRecCardWrapper.extraInfo.BizInfo");
    Object localObject1 = (Iterable)paramz;
    paramz = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (pf)((Iterator)localObject1).next();
      ok localok = new ok();
      localok.RTS = ((pf)localObject2).UserName;
      LinkedList localLinkedList2 = localok.RVG;
      localObject2 = ((pf)localObject2).RXM;
      p.j(localObject2, "info.AppMsg");
      Object localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(((pe)((Iterator)localObject3).next()).RTk);
      }
      localLinkedList2.addAll((Collection)localObject2);
      paramz.add(localok);
    }
    localLinkedList1.addAll((Collection)paramz);
    AppMethodBeat.o(257938);
    return localph;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.k
 * JD-Core Version:    0.7.0.1
 */