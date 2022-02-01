package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.nv;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.protocal.protobuf.om;
import com.tencent.mm.storage.w;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"isExpire", "", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "toBizRecArticleCardLite", "Lcom/tencent/mm/protocal/protobuf/BizRecArticleCardLite;", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "plugin-brandservice_release"})
public final class i
{
  public static final om g(w paramw)
  {
    AppMethodBeat.i(209707);
    p.h(paramw, "$this$toBizRecArticleCardLite");
    om localom = new om();
    localom.FJW = paramw.field_msgId;
    localom.FHR = paramw.Ioq.style;
    localom.FHS = paramw.Ioq.dln;
    LinkedList localLinkedList1 = localom.FHP;
    paramw = paramw.fpm().HAf.FHP;
    p.g(paramw, "info.tlRecCardWrapper.extraInfo.BizInfo");
    Object localObject1 = (Iterable)paramw;
    paramw = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ok)((Iterator)localObject1).next();
      nv localnv = new nv();
      localnv.FGE = ((ok)localObject2).nDo;
      LinkedList localLinkedList2 = localnv.FIj;
      localObject2 = ((ok)localObject2).FJV;
      p.g(localObject2, "info.AppMsg");
      Object localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(((oj)((Iterator)localObject3).next()).FFW);
      }
      localLinkedList2.addAll((Collection)localObject2);
      paramw.add(localnv);
    }
    localLinkedList1.addAll((Collection)paramw);
    AppMethodBeat.o(209707);
    return localom;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.i
 * JD-Core Version:    0.7.0.1
 */