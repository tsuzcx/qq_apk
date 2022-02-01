package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.amo;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.a;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/data/FinderItemOp;", "Lcom/tencent/mm/plugin/finder/storage/data/PageDataOp;", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "()V", "extract", "data", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "isTargetDataType", "", "dataType", "", "remove", "svrId", "", "list", "Ljava/util/LinkedList;", "svrIds", "", "removeLocal", "localId", "targetDataType", "updateLocal", "item", "plugin-finder_release"})
public final class h
{
  public static final h szU;
  
  static
  {
    AppMethodBeat.i(203824);
    szU = new h();
    AppMethodBeat.o(203824);
  }
  
  public static FinderItem a(amo paramamo)
  {
    int j = 1;
    AppMethodBeat.i(203819);
    p.h(paramamo, "data");
    int i;
    Object localObject;
    if (paramamo.dataType == 0)
    {
      i = 1;
      if ((i == 0) || (paramamo.Gmf == null)) {
        break label229;
      }
      localObject = ((PluginFinder)g.ad(PluginFinder.class)).getFeedStorage();
      switch (paramamo.type)
      {
      default: 
        localObject = FinderItem.syk;
        localObject = paramamo.Gmf;
        p.g(localObject, "data.`object`");
        localObject = FinderItem.a.a((FinderObject)localObject, paramamo.Gmg);
        paramamo = com.tencent.mm.plugin.finder.api.c.rHn;
        paramamo = ((FinderItem)localObject).getFeedObject().contact.username;
        p.g(paramamo, "item.feedObject.contact.username");
        if (c.a.agW(paramamo) == null)
        {
          paramamo = com.tencent.mm.plugin.finder.api.c.rHn;
          paramamo = ((FinderItem)localObject).getFeedObject().contact;
          p.g(paramamo, "item.feedObject.contact");
          c.a.b(paramamo);
        }
        paramamo = d.szI;
        paramamo = (amo)localObject;
        if (d.a.wT(((FinderItem)localObject).field_id) == null)
        {
          paramamo = d.szI;
          d.a.f((FinderItem)localObject);
          paramamo = (amo)localObject;
        }
        break;
      }
    }
    for (;;)
    {
      if (paramamo == null) {
        break label229;
      }
      AppMethodBeat.o(203819);
      return paramamo;
      i = 0;
      break;
      paramamo = ((i)localObject).wP(paramamo.id);
      if (paramamo != null)
      {
        if (paramamo.getLocalId() != 0L) {}
        for (i = j;; i = 0)
        {
          if (i != 0) {
            break label222;
          }
          paramamo = null;
          break;
        }
      }
      else
      {
        label222:
        paramamo = null;
      }
    }
    label229:
    AppMethodBeat.o(203819);
    return null;
  }
  
  public static boolean a(long paramLong, FinderItem paramFinderItem, LinkedList<amo> paramLinkedList)
  {
    AppMethodBeat.i(203820);
    p.h(paramFinderItem, "item");
    p.h(paramLinkedList, "list");
    Iterator localIterator = ((Iterable)paramLinkedList).iterator();
    int i;
    if (localIterator.hasNext())
    {
      paramLinkedList = localIterator.next();
      amo localamo = (amo)paramLinkedList;
      if ((localamo.dataType == 0) && (localamo.type == 2) && (localamo.Gmf.id == paramLong))
      {
        i = 1;
        label85:
        if (i == 0) {
          break label134;
        }
      }
    }
    for (;;)
    {
      paramLinkedList = (amo)paramLinkedList;
      if (paramLinkedList == null) {
        break label141;
      }
      paramLinkedList.type = 1;
      paramLinkedList.Gmf.id = paramFinderItem.field_id;
      paramLinkedList.Gmf = paramFinderItem.getFeedObject();
      AppMethodBeat.o(203820);
      return true;
      i = 0;
      break label85;
      label134:
      break;
      paramLinkedList = null;
    }
    label141:
    AppMethodBeat.o(203820);
    return false;
  }
  
  public static boolean a(long paramLong, LinkedList<amo> paramLinkedList)
  {
    AppMethodBeat.i(203821);
    p.h(paramLinkedList, "list");
    y.a locala = new y.a();
    locala.MLQ = false;
    com.tencent.mm.ad.c.a(paramLinkedList, (b)new a(paramLong, locala));
    boolean bool = locala.MLQ;
    AppMethodBeat.o(203821);
    return bool;
  }
  
  public static boolean a(List<Long> paramList, LinkedList<amo> paramLinkedList)
  {
    AppMethodBeat.i(203822);
    p.h(paramList, "svrIds");
    p.h(paramLinkedList, "list");
    final y.a locala = new y.a();
    locala.MLQ = false;
    com.tencent.mm.ad.c.a(paramLinkedList, (b)new b(paramList, locala));
    boolean bool = locala.MLQ;
    AppMethodBeat.o(203822);
    return bool;
  }
  
  public static boolean b(long paramLong, LinkedList<amo> paramLinkedList)
  {
    AppMethodBeat.i(203823);
    p.h(paramLinkedList, "list");
    y.a locala = new y.a();
    locala.MLQ = false;
    com.tencent.mm.ad.c.a(paramLinkedList, (b)new c(paramLong, locala));
    boolean bool = locala.MLQ;
    AppMethodBeat.o(203823);
    return bool;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "invoke"})
  static final class a
    extends q
    implements b<amo, Boolean>
  {
    a(long paramLong, y.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "invoke"})
  static final class b
    extends q
    implements b<amo, Boolean>
  {
    b(List paramList, y.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "invoke"})
  static final class c
    extends q
    implements b<amo, Boolean>
  {
    c(long paramLong, y.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.h
 * JD-Core Version:    0.7.0.1
 */