package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.protocal.protobuf.nx;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.protocal.protobuf.om;
import com.tencent.mm.protocal.protobuf.oo;
import com.tencent.mm.storage.w;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"isExpire", "", "Lcom/tencent/mm/protocal/protobuf/TLRecCardWrapper;", "toBizRecArticleCardLite", "Lcom/tencent/mm/protocal/protobuf/BizRecArticleCardLite;", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "plugin-brandservice_release"})
public final class i
{
  public static final oo g(w paramw)
  {
    AppMethodBeat.i(208681);
    p.h(paramw, "$this$toBizRecArticleCardLite");
    oo localoo = new oo();
    localoo.Gcv = paramw.field_msgId;
    localoo.Gan = paramw.IIG.style;
    localoo.Gao = paramw.IIG.dmp;
    LinkedList localLinkedList1 = localoo.Gal;
    paramw = paramw.ftk().HTS.Gal;
    p.g(paramw, "info.tlRecCardWrapper.extraInfo.BizInfo");
    Object localObject1 = (Iterable)paramw;
    paramw = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (om)((Iterator)localObject1).next();
      nx localnx = new nx();
      localnx.FZa = ((om)localObject2).nIJ;
      LinkedList localLinkedList2 = localnx.GaF;
      localObject2 = ((om)localObject2).Gcu;
      p.g(localObject2, "info.AppMsg");
      Object localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(((ol)((Iterator)localObject3).next()).FYs);
      }
      localLinkedList2.addAll((Collection)localObject2);
      paramw.add(localnx);
    }
    localLinkedList1.addAll((Collection)paramw);
    AppMethodBeat.o(208681);
    return localoo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.i
 * JD-Core Version:    0.7.0.1
 */