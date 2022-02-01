package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.n;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.axb;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.ah.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/data/FinderItemOp;", "Lcom/tencent/mm/plugin/finder/storage/data/PageDataOp;", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "()V", "extract", "data", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "isTargetDataType", "", "dataType", "", "nameFilter", "Lkotlin/Function1;", "userNames", "", "", "remove", "list", "Ljava/util/LinkedList;", "filter", "svrId", "", "svrIds", "removeLocal", "localId", "targetDataType", "update", "newOne", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "updateLocal", "item", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h FMZ;
  
  static
  {
    AppMethodBeat.i(339386);
    FMZ = new h();
    AppMethodBeat.o(339386);
  }
  
  public static FinderItem a(axb paramaxb)
  {
    int j = 1;
    AppMethodBeat.i(339348);
    s.u(paramaxb, "data");
    Object localObject1 = paramaxb.ZIo;
    int i;
    if (paramaxb.dataType == 0)
    {
      i = 1;
      if ((i == 0) || (localObject1 == null)) {
        break label203;
      }
      localObject2 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFeedStorage();
      if (paramaxb.type != 2) {
        break label113;
      }
      paramaxb = ((n)localObject2).qc(paramaxb.id);
      if (paramaxb != null) {
        break label88;
      }
      paramaxb = null;
    }
    label88:
    label111:
    for (;;)
    {
      if (paramaxb == null) {
        break label203;
      }
      AppMethodBeat.o(339348);
      return paramaxb;
      i = 0;
      break;
      if (paramaxb.getLocalId() != 0L) {}
      for (i = j;; i = 0)
      {
        if (i != 0) {
          break label111;
        }
        paramaxb = null;
        break;
      }
    }
    label113:
    Object localObject2 = FinderItem.Companion;
    localObject1 = FinderItem.a.e((FinderObject)localObject1, paramaxb.ZIp);
    paramaxb = com.tencent.mm.plugin.finder.api.d.AwY;
    paramaxb = ((FinderItem)localObject1).getFeedObject().contact;
    if (paramaxb == null) {}
    for (paramaxb = null;; paramaxb = paramaxb.username)
    {
      if (d.a.auT(paramaxb) == null)
      {
        paramaxb = com.tencent.mm.plugin.finder.api.d.AwY;
        d.a.e(((FinderItem)localObject1).getFeedObject().contact);
      }
      paramaxb = e.FMN;
      if (e.a.jn(((FinderItem)localObject1).field_id) == null)
      {
        paramaxb = e.FMN;
        e.a.s((FinderItem)localObject1);
      }
      paramaxb = (axb)localObject1;
      break;
    }
    label203:
    AppMethodBeat.o(339348);
    return null;
  }
  
  public static boolean a(long paramLong, FinderItem paramFinderItem, LinkedList<axb> paramLinkedList)
  {
    AppMethodBeat.i(339352);
    s.u(paramFinderItem, "item");
    s.u(paramLinkedList, "list");
    Object localObject1 = ((Iterable)paramLinkedList).iterator();
    int i;
    if (((Iterator)localObject1).hasNext())
    {
      paramLinkedList = ((Iterator)localObject1).next();
      Object localObject2 = (axb)paramLinkedList;
      if ((((axb)localObject2).dataType == 0) && (((axb)localObject2).type == 2))
      {
        localObject2 = ((axb)localObject2).ZIo;
        if ((localObject2 != null) && (((FinderObject)localObject2).id == paramLong))
        {
          i = 1;
          label94:
          if (i == 0) {
            break label162;
          }
          i = 1;
          label102:
          if (i == 0) {
            break label166;
          }
        }
      }
    }
    for (;;)
    {
      paramLinkedList = (axb)paramLinkedList;
      if (paramLinkedList == null) {
        break label173;
      }
      paramLinkedList.type = 1;
      localObject1 = paramLinkedList.ZIo;
      if (localObject1 != null) {
        ((FinderObject)localObject1).id = paramFinderItem.field_id;
      }
      paramLinkedList.ZIo = paramFinderItem.getFeedObject();
      AppMethodBeat.o(339352);
      return true;
      i = 0;
      break label94;
      label162:
      i = 0;
      break label102;
      label166:
      break;
      paramLinkedList = null;
    }
    label173:
    AppMethodBeat.o(339352);
    return false;
  }
  
  public static boolean a(long paramLong, FinderObject paramFinderObject, LinkedList<axb> paramLinkedList)
  {
    boolean bool = false;
    AppMethodBeat.i(339380);
    s.u(paramFinderObject, "newOne");
    s.u(paramLinkedList, "list");
    Iterator localIterator = ((List)paramLinkedList).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext())
    {
      Object localObject = (axb)localIterator.next();
      if ((((axb)localObject).dataType == 0) && (((axb)localObject).type != 2))
      {
        localObject = ((axb)localObject).ZIo;
        if ((localObject != null) && (((FinderObject)localObject).id == paramLong))
        {
          j = 1;
          label98:
          if (j == 0) {
            break label146;
          }
          j = 1;
          label106:
          if (j == 0) {
            break label152;
          }
        }
      }
    }
    for (;;)
    {
      if (i >= 0)
      {
        ((axb)paramLinkedList.get(i)).ZIo = paramFinderObject;
        bool = true;
      }
      AppMethodBeat.o(339380);
      return bool;
      j = 0;
      break label98;
      label146:
      j = 0;
      break label106;
      label152:
      i += 1;
      break;
      i = -1;
    }
  }
  
  public static boolean a(long paramLong, LinkedList<axb> paramLinkedList)
  {
    AppMethodBeat.i(339357);
    s.u(paramLinkedList, "list");
    ah.a locala = new ah.a();
    com.tencent.mm.ae.d.a(paramLinkedList, (b)new h.b(paramLong, locala));
    boolean bool = locala.aiwY;
    AppMethodBeat.o(339357);
    return bool;
  }
  
  public static boolean b(long paramLong, LinkedList<axb> paramLinkedList)
  {
    AppMethodBeat.i(339373);
    s.u(paramLinkedList, "list");
    ah.a locala = new ah.a();
    com.tencent.mm.ae.d.a(paramLinkedList, (b)new h.e(paramLong, locala));
    boolean bool = locala.aiwY;
    AppMethodBeat.o(339373);
    return bool;
  }
  
  public static boolean b(LinkedList<axb> paramLinkedList, b<? super axb, Boolean> paramb)
  {
    AppMethodBeat.i(339369);
    s.u(paramLinkedList, "list");
    s.u(paramb, "filter");
    ah.a locala = new ah.a();
    com.tencent.mm.ae.d.a(paramLinkedList, (b)new h.d(paramb, locala));
    boolean bool = locala.aiwY;
    AppMethodBeat.o(339369);
    return bool;
  }
  
  public static boolean c(List<Long> paramList, LinkedList<axb> paramLinkedList)
  {
    AppMethodBeat.i(339360);
    s.u(paramList, "svrIds");
    s.u(paramLinkedList, "list");
    ah.a locala = new ah.a();
    com.tencent.mm.ae.d.a(paramLinkedList, (b)new h.c(paramList, locala));
    boolean bool = locala.aiwY;
    AppMethodBeat.o(339360);
    return bool;
  }
  
  public static int fac()
  {
    return 0;
  }
  
  public static b<axb, Boolean> hB(List<String> paramList)
  {
    AppMethodBeat.i(339365);
    s.u(paramList, "userNames");
    paramList = (b)new h.a(paramList);
    AppMethodBeat.o(339365);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.data.h
 * JD-Core Version:    0.7.0.1
 */