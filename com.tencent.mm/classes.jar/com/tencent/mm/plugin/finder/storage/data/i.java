package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.a;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/data/FinderItemOp;", "Lcom/tencent/mm/plugin/finder/storage/data/PageDataOp;", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "()V", "extract", "data", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "isTargetDataType", "", "dataType", "", "remove", "svrId", "", "list", "Ljava/util/LinkedList;", "svrIds", "", "removeLocal", "localId", "targetDataType", "update", "newOne", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "updateLocal", "item", "plugin-finder_release"})
public final class i
{
  public static final i vGl;
  
  static
  {
    AppMethodBeat.i(252004);
    vGl = new i();
    AppMethodBeat.o(252004);
  }
  
  public static FinderItem a(aqq paramaqq)
  {
    int j = 1;
    AppMethodBeat.i(251998);
    p.h(paramaqq, "data");
    Object localObject1 = paramaqq.LCD;
    int i;
    Object localObject2;
    if (paramaqq.dataType == 0)
    {
      i = 1;
      if ((i == 0) || (localObject1 == null)) {
        break label219;
      }
      localObject2 = ((PluginFinder)g.ah(PluginFinder.class)).getFeedStorage();
      switch (paramaqq.type)
      {
      default: 
        localObject2 = FinderItem.Companion;
        localObject1 = FinderItem.a.a((FinderObject)localObject1, paramaqq.LCE);
        paramaqq = c.tsp;
        paramaqq = ((FinderItem)localObject1).getFeedObject().contact;
        if (paramaqq == null) {
          break;
        }
      }
    }
    for (paramaqq = paramaqq.username;; paramaqq = null)
    {
      if (c.a.asG(paramaqq) == null)
      {
        paramaqq = c.tsp;
        c.a.b(((FinderItem)localObject1).getFeedObject().contact);
      }
      paramaqq = e.vFX;
      if (e.a.Fy(((FinderItem)localObject1).field_id) == null)
      {
        paramaqq = e.vFX;
        e.a.n((FinderItem)localObject1);
      }
      paramaqq = (aqq)localObject1;
      for (;;)
      {
        if (paramaqq == null) {
          break label219;
        }
        AppMethodBeat.o(251998);
        return paramaqq;
        i = 0;
        break;
        paramaqq = ((com.tencent.mm.plugin.finder.storage.l)localObject2).Fz(paramaqq.id);
        if (paramaqq != null)
        {
          if (paramaqq.getLocalId() != 0L) {}
          for (i = j;; i = 0)
          {
            if (i != 0) {
              break label207;
            }
            paramaqq = null;
            break;
          }
        }
        else
        {
          label207:
          paramaqq = null;
        }
      }
    }
    label219:
    AppMethodBeat.o(251998);
    return null;
  }
  
  public static boolean a(long paramLong, FinderItem paramFinderItem, LinkedList<aqq> paramLinkedList)
  {
    AppMethodBeat.i(251999);
    p.h(paramFinderItem, "item");
    p.h(paramLinkedList, "list");
    Object localObject1 = ((Iterable)paramLinkedList).iterator();
    int i;
    if (((Iterator)localObject1).hasNext())
    {
      paramLinkedList = ((Iterator)localObject1).next();
      Object localObject2 = (aqq)paramLinkedList;
      if ((((aqq)localObject2).dataType == 0) && (((aqq)localObject2).type == 2))
      {
        localObject2 = ((aqq)localObject2).LCD;
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
      paramLinkedList = (aqq)paramLinkedList;
      if (paramLinkedList == null) {
        break label159;
      }
      paramLinkedList.type = 1;
      localObject1 = paramLinkedList.LCD;
      if (localObject1 != null) {
        ((FinderObject)localObject1).id = paramFinderItem.field_id;
      }
      paramLinkedList.LCD = paramFinderItem.getFeedObject();
      AppMethodBeat.o(251999);
      return true;
      i = 0;
      break label94;
      label152:
      break;
      paramLinkedList = null;
    }
    label159:
    AppMethodBeat.o(251999);
    return false;
  }
  
  public static boolean a(long paramLong, FinderObject paramFinderObject, LinkedList<aqq> paramLinkedList)
  {
    boolean bool = false;
    AppMethodBeat.i(252003);
    p.h(paramFinderObject, "newOne");
    p.h(paramLinkedList, "list");
    Iterator localIterator = ((List)paramLinkedList).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext())
    {
      Object localObject = (aqq)localIterator.next();
      if ((((aqq)localObject).dataType == 0) && (((aqq)localObject).type != 2))
      {
        localObject = ((aqq)localObject).LCD;
        if ((localObject != null) && (((FinderObject)localObject).id == paramLong))
        {
          j = 1;
          label98:
          if (j == 0) {
            break label138;
          }
        }
      }
    }
    for (;;)
    {
      if (i >= 0)
      {
        ((aqq)paramLinkedList.get(i)).LCD = paramFinderObject;
        bool = true;
      }
      AppMethodBeat.o(252003);
      return bool;
      j = 0;
      break label98;
      label138:
      i += 1;
      break;
      i = -1;
    }
  }
  
  public static boolean a(long paramLong, LinkedList<aqq> paramLinkedList)
  {
    AppMethodBeat.i(252000);
    p.h(paramLinkedList, "list");
    z.a locala = new z.a();
    locala.SYB = false;
    d.a(paramLinkedList, (b)new a(paramLong, locala));
    boolean bool = locala.SYB;
    AppMethodBeat.o(252000);
    return bool;
  }
  
  public static boolean a(List<Long> paramList, LinkedList<aqq> paramLinkedList)
  {
    AppMethodBeat.i(252001);
    p.h(paramList, "svrIds");
    p.h(paramLinkedList, "list");
    final z.a locala = new z.a();
    locala.SYB = false;
    d.a(paramLinkedList, (b)new b(paramList, locala));
    boolean bool = locala.SYB;
    AppMethodBeat.o(252001);
    return bool;
  }
  
  public static boolean b(long paramLong, LinkedList<aqq> paramLinkedList)
  {
    AppMethodBeat.i(252002);
    p.h(paramLinkedList, "list");
    z.a locala = new z.a();
    locala.SYB = false;
    d.a(paramLinkedList, (b)new c(paramLong, locala));
    boolean bool = locala.SYB;
    AppMethodBeat.o(252002);
    return bool;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "invoke"})
  static final class a
    extends q
    implements b<aqq, Boolean>
  {
    a(long paramLong, z.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "invoke"})
  static final class b
    extends q
    implements b<aqq, Boolean>
  {
    b(List paramList, z.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "invoke"})
  static final class c
    extends q
    implements b<aqq, Boolean>
  {
    c(long paramLong, z.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.i
 * JD-Core Version:    0.7.0.1
 */