package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.asm;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.aa.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/data/FinderItemOp;", "Lcom/tencent/mm/plugin/finder/storage/data/PageDataOp;", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "()V", "extract", "data", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "isTargetDataType", "", "dataType", "", "nameFilter", "Lkotlin/Function1;", "userNames", "", "", "remove", "list", "Ljava/util/LinkedList;", "filter", "svrId", "", "svrIds", "removeLocal", "localId", "targetDataType", "update", "newOne", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "updateLocal", "item", "plugin-finder_release"})
public final class h
{
  public static final h Ang;
  
  static
  {
    AppMethodBeat.i(282185);
    Ang = new h();
    AppMethodBeat.o(282185);
  }
  
  public static FinderItem a(asm paramasm)
  {
    int j = 1;
    AppMethodBeat.i(282177);
    p.k(paramasm, "data");
    Object localObject1 = paramasm.SFP;
    int i;
    Object localObject2;
    if (paramasm.dataType == 0)
    {
      i = 1;
      if ((i == 0) || (localObject1 == null)) {
        break label219;
      }
      localObject2 = ((PluginFinder)com.tencent.mm.kernel.h.ag(PluginFinder.class)).getFeedStorage();
      switch (paramasm.type)
      {
      default: 
        localObject2 = FinderItem.Companion;
        localObject1 = FinderItem.a.b((FinderObject)localObject1, paramasm.SFQ);
        paramasm = com.tencent.mm.plugin.finder.api.d.wZQ;
        paramasm = ((FinderItem)localObject1).getFeedObject().contact;
        if (paramasm == null) {
          break;
        }
      }
    }
    for (paramasm = paramasm.username;; paramasm = null)
    {
      if (d.a.aAK(paramasm) == null)
      {
        paramasm = com.tencent.mm.plugin.finder.api.d.wZQ;
        d.a.b(((FinderItem)localObject1).getFeedObject().contact);
      }
      paramasm = e.AmW;
      if (e.a.MH(((FinderItem)localObject1).field_id) == null)
      {
        paramasm = e.AmW;
        e.a.o((FinderItem)localObject1);
      }
      paramasm = (asm)localObject1;
      for (;;)
      {
        if (paramasm == null) {
          break label219;
        }
        AppMethodBeat.o(282177);
        return paramasm;
        i = 0;
        break;
        paramasm = ((m)localObject2).MI(paramasm.id);
        if (paramasm != null)
        {
          if (paramasm.getLocalId() != 0L) {}
          for (i = j;; i = 0)
          {
            if (i != 0) {
              break label207;
            }
            paramasm = null;
            break;
          }
        }
        else
        {
          label207:
          paramasm = null;
        }
      }
    }
    label219:
    AppMethodBeat.o(282177);
    return null;
  }
  
  public static boolean a(long paramLong, FinderItem paramFinderItem, LinkedList<asm> paramLinkedList)
  {
    AppMethodBeat.i(282178);
    p.k(paramFinderItem, "item");
    p.k(paramLinkedList, "list");
    Object localObject1 = ((Iterable)paramLinkedList).iterator();
    int i;
    if (((Iterator)localObject1).hasNext())
    {
      paramLinkedList = ((Iterator)localObject1).next();
      Object localObject2 = (asm)paramLinkedList;
      if ((((asm)localObject2).dataType == 0) && (((asm)localObject2).type == 2))
      {
        localObject2 = ((asm)localObject2).SFP;
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
      paramLinkedList = (asm)paramLinkedList;
      if (paramLinkedList == null) {
        break label159;
      }
      paramLinkedList.type = 1;
      localObject1 = paramLinkedList.SFP;
      if (localObject1 != null) {
        ((FinderObject)localObject1).id = paramFinderItem.field_id;
      }
      paramLinkedList.SFP = paramFinderItem.getFeedObject();
      AppMethodBeat.o(282178);
      return true;
      i = 0;
      break label94;
      label152:
      break;
      paramLinkedList = null;
    }
    label159:
    AppMethodBeat.o(282178);
    return false;
  }
  
  public static boolean a(long paramLong, FinderObject paramFinderObject, LinkedList<asm> paramLinkedList)
  {
    boolean bool = false;
    AppMethodBeat.i(282184);
    p.k(paramFinderObject, "newOne");
    p.k(paramLinkedList, "list");
    Iterator localIterator = ((List)paramLinkedList).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext())
    {
      Object localObject = (asm)localIterator.next();
      if ((((asm)localObject).dataType == 0) && (((asm)localObject).type != 2))
      {
        localObject = ((asm)localObject).SFP;
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
        ((asm)paramLinkedList.get(i)).SFP = paramFinderObject;
        bool = true;
      }
      AppMethodBeat.o(282184);
      return bool;
      j = 0;
      break label98;
      label138:
      i += 1;
      break;
      i = -1;
    }
  }
  
  public static boolean a(long paramLong, LinkedList<asm> paramLinkedList)
  {
    AppMethodBeat.i(282179);
    p.k(paramLinkedList, "list");
    aa.a locala = new aa.a();
    locala.aaBx = false;
    com.tencent.mm.ae.d.a(paramLinkedList, (b)new b(paramLong, locala));
    boolean bool = locala.aaBx;
    AppMethodBeat.o(282179);
    return bool;
  }
  
  public static boolean b(long paramLong, LinkedList<asm> paramLinkedList)
  {
    AppMethodBeat.i(282183);
    p.k(paramLinkedList, "list");
    aa.a locala = new aa.a();
    locala.aaBx = false;
    com.tencent.mm.ae.d.a(paramLinkedList, (b)new e(paramLong, locala));
    boolean bool = locala.aaBx;
    AppMethodBeat.o(282183);
    return bool;
  }
  
  public static boolean b(LinkedList<asm> paramLinkedList, b<? super asm, Boolean> paramb)
  {
    AppMethodBeat.i(282182);
    p.k(paramLinkedList, "list");
    p.k(paramb, "filter");
    final aa.a locala = new aa.a();
    locala.aaBx = false;
    com.tencent.mm.ae.d.a(paramLinkedList, (b)new d(paramb, locala));
    boolean bool = locala.aaBx;
    AppMethodBeat.o(282182);
    return bool;
  }
  
  public static boolean c(List<Long> paramList, LinkedList<asm> paramLinkedList)
  {
    AppMethodBeat.i(282180);
    p.k(paramList, "svrIds");
    p.k(paramLinkedList, "list");
    final aa.a locala = new aa.a();
    locala.aaBx = false;
    com.tencent.mm.ae.d.a(paramLinkedList, (b)new c(paramList, locala));
    boolean bool = locala.aaBx;
    AppMethodBeat.o(282180);
    return bool;
  }
  
  public static b<asm, Boolean> eP(List<String> paramList)
  {
    AppMethodBeat.i(282181);
    p.k(paramList, "userNames");
    paramList = (b)new a(paramList);
    AppMethodBeat.o(282181);
    return paramList;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "invoke"})
  static final class a
    extends q
    implements b<asm, Boolean>
  {
    a(List paramList)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "invoke"})
  static final class b
    extends q
    implements b<asm, Boolean>
  {
    b(long paramLong, aa.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "invoke"})
  static final class c
    extends q
    implements b<asm, Boolean>
  {
    c(List paramList, aa.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "invoke"})
  static final class d
    extends q
    implements b<asm, Boolean>
  {
    d(b paramb, aa.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "item", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "invoke"})
  static final class e
    extends q
    implements b<asm, Boolean>
  {
    e(long paramLong, aa.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.h
 * JD-Core Version:    0.7.0.1
 */