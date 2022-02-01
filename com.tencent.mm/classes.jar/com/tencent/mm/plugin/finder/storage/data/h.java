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
import com.tencent.mm.protocal.protobuf.ana;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.a;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/data/FinderItemOp;", "Lcom/tencent/mm/plugin/finder/storage/data/PageDataOp;", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "()V", "extract", "data", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "isTargetDataType", "", "dataType", "", "remove", "svrId", "", "list", "Ljava/util/LinkedList;", "svrIds", "", "removeLocal", "localId", "targetDataType", "updateLocal", "item", "plugin-finder_release"})
public final class h
{
  public static final h sKR;
  
  static
  {
    AppMethodBeat.i(204415);
    sKR = new h();
    AppMethodBeat.o(204415);
  }
  
  public static FinderItem a(ana paramana)
  {
    int j = 1;
    AppMethodBeat.i(204410);
    p.h(paramana, "data");
    Object localObject1 = paramana.GFh;
    int i;
    Object localObject2;
    if (paramana.dataType == 0)
    {
      i = 1;
      if ((i == 0) || (localObject1 == null)) {
        break label219;
      }
      localObject2 = ((PluginFinder)g.ad(PluginFinder.class)).getFeedStorage();
      switch (paramana.type)
      {
      default: 
        localObject2 = FinderItem.sJb;
        localObject1 = FinderItem.a.a((FinderObject)localObject1, paramana.GFi);
        paramana = com.tencent.mm.plugin.finder.api.c.rPy;
        paramana = ((FinderItem)localObject1).getFeedObject().contact;
        if (paramana == null) {
          break;
        }
      }
    }
    for (paramana = paramana.username;; paramana = null)
    {
      if (c.a.ahT(paramana) == null)
      {
        paramana = com.tencent.mm.plugin.finder.api.c.rPy;
        c.a.b(((FinderItem)localObject1).getFeedObject().contact);
      }
      paramana = d.sKD;
      if (d.a.xk(((FinderItem)localObject1).field_id) == null)
      {
        paramana = d.sKD;
        d.a.f((FinderItem)localObject1);
      }
      paramana = (ana)localObject1;
      for (;;)
      {
        if (paramana == null) {
          break label219;
        }
        AppMethodBeat.o(204410);
        return paramana;
        i = 0;
        break;
        paramana = ((i)localObject2).xg(paramana.id);
        if (paramana != null)
        {
          if (paramana.getLocalId() != 0L) {}
          for (i = j;; i = 0)
          {
            if (i != 0) {
              break label207;
            }
            paramana = null;
            break;
          }
        }
        else
        {
          label207:
          paramana = null;
        }
      }
    }
    label219:
    AppMethodBeat.o(204410);
    return null;
  }
  
  public static boolean a(long paramLong, FinderItem paramFinderItem, LinkedList<ana> paramLinkedList)
  {
    AppMethodBeat.i(204411);
    p.h(paramFinderItem, "item");
    p.h(paramLinkedList, "list");
    Object localObject1 = ((Iterable)paramLinkedList).iterator();
    int i;
    if (((Iterator)localObject1).hasNext())
    {
      paramLinkedList = ((Iterator)localObject1).next();
      Object localObject2 = (ana)paramLinkedList;
      if ((((ana)localObject2).dataType == 0) && (((ana)localObject2).type == 2))
      {
        localObject2 = ((ana)localObject2).GFh;
        if ((localObject2 != null) && (((FinderObject)localObject2).id == paramLong))
        {
          i = 1;
          label94:
          if (i == 0) {
            break label152;
          }
        }
      }
    }
    for (;;)
    {
      paramLinkedList = (ana)paramLinkedList;
      if (paramLinkedList == null) {
        break label159;
      }
      paramLinkedList.type = 1;
      localObject1 = paramLinkedList.GFh;
      if (localObject1 != null) {
        ((FinderObject)localObject1).id = paramFinderItem.field_id;
      }
      paramLinkedList.GFh = paramFinderItem.getFeedObject();
      AppMethodBeat.o(204411);
      return true;
      i = 0;
      break label94;
      label152:
      break;
      paramLinkedList = null;
    }
    label159:
    AppMethodBeat.o(204411);
    return false;
  }
  
  public static boolean a(long paramLong, LinkedList<ana> paramLinkedList)
  {
    AppMethodBeat.i(204412);
    p.h(paramLinkedList, "list");
    y.a locala = new y.a();
    locala.NiT = false;
    com.tencent.mm.ac.c.a(paramLinkedList, (b)new a(paramLong, locala));
    boolean bool = locala.NiT;
    AppMethodBeat.o(204412);
    return bool;
  }
  
  public static boolean a(List<Long> paramList, LinkedList<ana> paramLinkedList)
  {
    AppMethodBeat.i(204413);
    p.h(paramList, "svrIds");
    p.h(paramLinkedList, "list");
    final y.a locala = new y.a();
    locala.NiT = false;
    com.tencent.mm.ac.c.a(paramLinkedList, (b)new b(paramList, locala));
    boolean bool = locala.NiT;
    AppMethodBeat.o(204413);
    return bool;
  }
  
  public static boolean b(long paramLong, LinkedList<ana> paramLinkedList)
  {
    AppMethodBeat.i(204414);
    p.h(paramLinkedList, "list");
    y.a locala = new y.a();
    locala.NiT = false;
    com.tencent.mm.ac.c.a(paramLinkedList, (b)new c(paramLong, locala));
    boolean bool = locala.NiT;
    AppMethodBeat.o(204414);
    return bool;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "invoke"})
  static final class a
    extends q
    implements b<ana, Boolean>
  {
    a(long paramLong, y.a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "invoke"})
  static final class b
    extends q
    implements b<ana, Boolean>
  {
    b(List paramList, y.a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "invoke"})
  static final class c
    extends q
    implements b<ana, Boolean>
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