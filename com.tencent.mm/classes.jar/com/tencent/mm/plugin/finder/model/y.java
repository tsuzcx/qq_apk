package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "()V", "finderStreamCard", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;)V", "cardBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getCardBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setCardBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "continueAtTheEnd", "", "getContinueAtTheEnd", "()Z", "setContinueAtTheEnd", "(Z)V", "enableMoreLiveAtTheEnd", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "listId", "", "getListId", "()J", "setListId", "(J)V", "liveList", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "getLiveList", "setLiveList", "addIncrementList", "", "newList", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getDataIndex", "liveId", "getFinderFeedLiveListItem", "pos", "getItem", "getItemId", "getItemType", "getLiveItemData", "initListId", "merge", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamResponse;", "parseLiveList", "userInfoList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "removeItem", "index", "replaceList", "toString", "", "tryToAddMoreLiveItem", "tryToRemoveMoreLiveItem", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
  implements cc
{
  public static final a ECI;
  public com.tencent.mm.bx.b AEA;
  private ArrayList<z> ECJ;
  public long ECK;
  public boolean ECL;
  private final boolean ECM;
  public ArrayList<cc> hqL;
  
  static
  {
    AppMethodBeat.i(332268);
    ECI = new a((byte)0);
    AppMethodBeat.o(332268);
  }
  
  public y()
  {
    AppMethodBeat.i(332243);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jTU().bmg()).intValue() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.ECM = bool;
      this.AEA = null;
      this.hqL = new ArrayList();
      this.ECJ = new ArrayList();
      this.ECK = eDp();
      AppMethodBeat.o(332243);
      return;
    }
  }
  
  public y(bwa parambwa)
  {
    AppMethodBeat.i(332248);
    Object localObject = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jTU().bmg()).intValue() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.ECM = bool;
      this.hqL = new ArrayList();
      this.ECJ = new ArrayList();
      localObject = this.hqL;
      LinkedList localLinkedList = parambwa.object;
      s.s(localLinkedList, "finderStreamCard.`object`");
      ((ArrayList)localObject).addAll((Collection)hc((List)localLinkedList));
      eDn();
      this.AEA = parambwa.AEA;
      this.ECK = eDp();
      this.ECL = parambwa.ECL;
      AppMethodBeat.o(332248);
      return;
    }
  }
  
  private final void eDo()
  {
    AppMethodBeat.i(332254);
    Iterator localIterator = this.hqL.iterator();
    s.s(localIterator, "list.iterator()");
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      s.s(localObject, "iterator.next()");
      if (((cc)localObject instanceof ac)) {
        localIterator.remove();
      }
    }
    AppMethodBeat.o(332254);
  }
  
  public static ArrayList<z> hc(List<? extends FinderObject> paramList)
  {
    AppMethodBeat.i(332262);
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      FinderObject localFinderObject = (FinderObject)localObject2;
      com.tencent.mm.plugin.finder.live.view.convert.a locala = com.tencent.mm.plugin.finder.live.view.convert.a.DUC;
      if (com.tencent.mm.plugin.finder.live.view.convert.a.j(localFinderObject)) {
        paramList.add(localObject2);
      }
    }
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.add(new z((FinderObject)((Iterator)localObject1).next()));
    }
    paramList = new ArrayList((Collection)paramList);
    AppMethodBeat.o(332262);
    return paramList;
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(332317);
    s.u(paramk, "obj");
    y localy;
    if ((paramk instanceof y)) {
      localy = (y)paramk;
    }
    while (localy != null) {
      if (this.ECK == ((y)paramk).ECK)
      {
        AppMethodBeat.o(332317);
        return 0;
        localy = null;
      }
      else
      {
        AppMethodBeat.o(332317);
        return -1;
      }
    }
    AppMethodBeat.o(332317);
    return -1;
  }
  
  public final long bZA()
  {
    return this.ECK;
  }
  
  public final int bZB()
  {
    return 2003;
  }
  
  public final ArrayList<z> eDm()
  {
    AppMethodBeat.i(332279);
    ArrayList localArrayList;
    try
    {
      Object localObject1 = (Iterable)this.hqL;
      Collection localCollection = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof z))
        {
          localCollection.add(localObject2);
          continue;
          AppMethodBeat.o(332279);
        }
      }
    }
    catch (Exception localException)
    {
      Log.e("FinderFeedLiveList", s.X("get liveList:", localException.getMessage()));
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      return localArrayList;
      localArrayList = (ArrayList)localArrayList;
    }
  }
  
  public final void eDn()
  {
    AppMethodBeat.i(332285);
    if ((this.ECM) && (this.hqL.size() > 0))
    {
      eDo();
      if (eDm().size() > 0) {
        this.hqL.add(new ac());
      }
    }
    AppMethodBeat.o(332285);
  }
  
  public final long eDp()
  {
    AppMethodBeat.i(332292);
    long l = 4294967295L;
    Iterator localIterator = ((Iterable)this.hqL).iterator();
    while (localIterator.hasNext()) {
      l = ((cc)localIterator.next()).bZA() & l;
    }
    Log.i("FinderFeedLiveList", s.X("listId:", Long.valueOf(l)));
    AppMethodBeat.o(332292);
    return l;
  }
  
  public final int pi(long paramLong)
  {
    AppMethodBeat.i(332326);
    Iterator localIterator = ((List)this.hqL).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (cc)localIterator.next();
      if ((localObject instanceof z))
      {
        localObject = ((z)localObject).ECN;
        if (localObject != null)
        {
          localObject = ((FinderObject)localObject).liveInfo;
          if ((localObject != null) && (((bip)localObject).liveId == paramLong))
          {
            j = 1;
            if (j == 0) {
              break label119;
            }
          }
        }
      }
      label119:
      for (int j = 1;; j = 0)
      {
        if (j == 0) {
          break label125;
        }
        AppMethodBeat.o(332326);
        return i;
        j = 0;
        break;
      }
      label125:
      i += 1;
    }
    AppMethodBeat.o(332326);
    return -1;
  }
  
  public final z pj(long paramLong)
  {
    AppMethodBeat.i(332335);
    Iterator localIterator = ((Iterable)eDm()).iterator();
    Object localObject1;
    int i;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      Object localObject2 = ((z)localObject1).ECN;
      if (localObject2 != null)
      {
        localObject2 = ((FinderObject)localObject2).liveInfo;
        if ((localObject2 != null) && (((bip)localObject2).liveId == paramLong))
        {
          i = 1;
          label78:
          if (i == 0) {
            break label101;
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = (z)localObject1;
      AppMethodBeat.o(332335);
      return localObject1;
      i = 0;
      break label78;
      label101:
      break;
      localObject1 = null;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(332344);
    int j = this.hqL.size();
    StringBuilder localStringBuilder1 = new StringBuilder("liveListId,size:" + j + ':');
    int i = 0;
    if (i < j)
    {
      cc localcc = (cc)this.hqL.get(i);
      if ((localcc instanceof z))
      {
        StringBuilder localStringBuilder2 = new StringBuilder("[index:").append(i).append(",username:").append(((z)localcc).ECN.nickname).append(",feedId:").append(((z)localcc).ECN.id).append(",liveId:");
        localObject = ((z)localcc).ECN.liveInfo;
        if (localObject == null)
        {
          localObject = null;
          label153:
          localStringBuilder1.append(localObject + "，friendLikeCount:" + ((z)localcc).ECN.friendLikeCount + ']');
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = Long.valueOf(((bip)localObject).liveId);
        break label153;
        localStringBuilder1.append("[index:" + i + ",feedId:" + localcc.bZA() + ']');
      }
    }
    Object localObject = localStringBuilder1.toString();
    s.s(localObject, "sb.toString()");
    AppMethodBeat.o(332344);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList$Companion;", "", "()V", "ENABLE_FOOTER_ITEM", "", "ENABLE_HEAD_ITEM", "TAG", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.y
 * JD-Core Version:    0.7.0.1
 */