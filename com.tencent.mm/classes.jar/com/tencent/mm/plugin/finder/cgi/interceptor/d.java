package com.tencent.mm.plugin.finder.cgi.interceptor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ab;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aro;
import d.a.j;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"print", "", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "toRVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"})
public final class d
{
  public static final al a(aro paramaro)
  {
    AppMethodBeat.i(201231);
    d.g.b.p.h(paramaro, "$this$toRVFeed");
    Object localObject1 = b.sAs;
    localObject1 = paramaro.object;
    d.g.b.p.g(localObject1, "`object`");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (FinderObject)localObject3;
      com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
      d.g.b.p.g(localObject4, "it");
      if (com.tencent.mm.plugin.finder.utils.p.o((FinderObject)localObject4)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = (List)localObject1;
    localObject2 = com.tencent.mm.plugin.finder.utils.p.sMo;
    localObject2 = (Iterable)b.a.a((List)localObject1, com.tencent.mm.plugin.finder.utils.p.FT(4), null, 12);
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (FinderItem)((Iterator)localObject2).next();
      localObject4 = b.sAs;
      ((Collection)localObject1).add(b.a.j((FinderItem)localObject3));
    }
    paramaro = (al)new ab(paramaro, new LinkedList((Collection)localObject1));
    AppMethodBeat.o(201231);
    return paramaro;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.interceptor.d
 * JD-Core Version:    0.7.0.1
 */