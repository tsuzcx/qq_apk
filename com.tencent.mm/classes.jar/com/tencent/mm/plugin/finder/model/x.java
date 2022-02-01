package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "()V", "finderStreamCard", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;)V", "cardBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getCardBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setCardBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "continueAtTheEnd", "", "getContinueAtTheEnd", "()Z", "setContinueAtTheEnd", "(Z)V", "enableMoreLiveAtTheEnd", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "listId", "", "getListId", "()J", "setListId", "(J)V", "liveList", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "getLiveList", "setLiveList", "addIncrementList", "", "newList", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getDataIndex", "liveId", "getFinderFeedLiveListItem", "pos", "getItem", "getItemId", "getItemType", "getLiveItemData", "initListId", "merge", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamResponse;", "parseLiveList", "userInfoList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "removeItem", "index", "replaceList", "toString", "", "tryToAddMoreLiveItem", "tryToRemoveMoreLiveItem", "Companion", "plugin-finder_release"})
public final class x
  implements bu
{
  public static final a zAE;
  public ArrayList<bu> fmA;
  public com.tencent.mm.cd.b xGO;
  private ArrayList<y> zAA;
  public long zAB;
  public boolean zAC;
  private final boolean zAD;
  
  static
  {
    AppMethodBeat.i(282454);
    zAE = new a((byte)0);
    AppMethodBeat.o(282454);
  }
  
  public x()
  {
    AppMethodBeat.i(282451);
    com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
    if (((Number)com.tencent.c.a.a.a.a.a.inn().aSr()).intValue() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.zAD = bool;
      this.xGO = null;
      this.fmA = new ArrayList();
      this.zAA = new ArrayList();
      this.zAB = dKA();
      AppMethodBeat.o(282451);
      return;
    }
  }
  
  public x(bjp parambjp)
  {
    AppMethodBeat.i(282452);
    Object localObject = com.tencent.c.a.a.a.a.a.Zlt;
    if (((Number)com.tencent.c.a.a.a.a.a.inn().aSr()).intValue() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.zAD = bool;
      this.fmA = new ArrayList();
      this.zAA = new ArrayList();
      localObject = this.fmA;
      LinkedList localLinkedList = parambjp.object;
      p.j(localLinkedList, "finderStreamCard.`object`");
      ((ArrayList)localObject).addAll((Collection)eA((List)localLinkedList));
      dKz();
      this.xGO = parambjp.xGO;
      this.zAB = dKA();
      this.zAC = parambjp.zAC;
      AppMethodBeat.o(282452);
      return;
    }
  }
  
  private final long dKA()
  {
    AppMethodBeat.i(282441);
    long l = 4294967295L;
    Iterator localIterator = ((Iterable)this.fmA).iterator();
    while (localIterator.hasNext()) {
      l = ((bu)localIterator.next()).mf() & l;
    }
    Log.i("FinderFeedLiveList", "listId:".concat(String.valueOf(l)));
    AppMethodBeat.o(282441);
    return l;
  }
  
  private final void dKz()
  {
    AppMethodBeat.i(282439);
    if ((this.zAD) && (this.fmA.size() > 0))
    {
      Iterator localIterator = this.fmA.iterator();
      p.j(localIterator, "list.iterator()");
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        p.j(localObject, "iterator.next()");
        if (((bu)localObject instanceof ab)) {
          localIterator.remove();
        }
      }
      if (dKy().size() > 0) {
        this.fmA.add(new ab());
      }
    }
    AppMethodBeat.o(282439);
  }
  
  private static ArrayList<y> eA(List<? extends FinderObject> paramList)
  {
    AppMethodBeat.i(282445);
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      FinderObject localFinderObject = (FinderObject)localObject2;
      com.tencent.mm.plugin.finder.live.view.convert.a locala = com.tencent.mm.plugin.finder.live.view.convert.a.zaD;
      if (com.tencent.mm.plugin.finder.live.view.convert.a.j(localFinderObject)) {
        paramList.add(localObject2);
      }
    }
    localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramList.add(new y((FinderObject)((Iterator)localObject1).next()));
    }
    paramList = new ArrayList((Collection)paramList);
    AppMethodBeat.o(282445);
    return paramList;
  }
  
  public final int Mb(long paramLong)
  {
    AppMethodBeat.i(282447);
    Iterator localIterator = ((List)this.fmA).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (bu)localIterator.next();
      if ((localObject instanceof y))
      {
        localObject = ((y)localObject).zAF;
        if (localObject != null)
        {
          localObject = ((FinderObject)localObject).liveInfo;
          if ((localObject == null) || (((bac)localObject).liveId != paramLong)) {}
        }
      }
      for (int j = 1; j != 0; j = 0)
      {
        AppMethodBeat.o(282447);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(282447);
    return -1;
  }
  
  public final y Mc(long paramLong)
  {
    AppMethodBeat.i(282448);
    Iterator localIterator = ((Iterable)dKy()).iterator();
    Object localObject1;
    int i;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      Object localObject2 = ((y)localObject1).zAF;
      if (localObject2 != null)
      {
        localObject2 = ((FinderObject)localObject2).liveInfo;
        if ((localObject2 != null) && (((bac)localObject2).liveId == paramLong))
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
      localObject1 = (y)localObject1;
      AppMethodBeat.o(282448);
      return localObject1;
      i = 0;
      break label78;
      label101:
      break;
      localObject1 = null;
    }
  }
  
  public final int a(k paramk)
  {
    AppMethodBeat.i(282443);
    p.k(paramk, "obj");
    if (!(paramk instanceof x)) {}
    for (k localk = null;; localk = paramk)
    {
      if ((x)localk != null)
      {
        if (this.zAB == ((x)paramk).zAB)
        {
          AppMethodBeat.o(282443);
          return 0;
        }
        AppMethodBeat.o(282443);
        return -1;
      }
      AppMethodBeat.o(282443);
      return -1;
    }
  }
  
  public final ArrayList<y> a(bcu parambcu)
  {
    AppMethodBeat.i(282446);
    p.k(parambcu, "resp");
    Object localObject1 = parambcu.object;
    Log.i("FinderFeedLiveList", "merge remote list size:" + ((LinkedList)localObject1).size());
    this.xGO = parambcu.lastBuffer;
    boolean bool;
    if (parambcu.continueFlag > 0)
    {
      bool = true;
      this.zAC = bool;
      parambcu = new LinkedList();
      p.j(localObject1, "remote");
      localObject1 = ((Iterable)localObject1).iterator();
    }
    for (;;)
    {
      label97:
      if (!((Iterator)localObject1).hasNext()) {
        break label369;
      }
      FinderObject localFinderObject = (FinderObject)((Iterator)localObject1).next();
      Object localObject2 = (List)this.fmA;
      int i = 0;
      localObject2 = ((List)localObject2).iterator();
      label139:
      int j;
      label175:
      label181:
      label198:
      int k;
      if (((Iterator)localObject2).hasNext()) {
        if (((bu)((Iterator)localObject2).next()).mf() == localFinderObject.id)
        {
          j = 1;
          if (j == 0) {
            break label282;
          }
          j = i;
          localObject2 = (List)parambcu;
          i = 0;
          localObject2 = ((List)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label307;
          }
          if (((FinderObject)((Iterator)localObject2).next()).id != localFinderObject.id) {
            break label294;
          }
          k = 1;
          label233:
          if (k == 0) {
            break label300;
          }
        }
      }
      for (;;)
      {
        if ((j != -1) || (i != -1)) {
          break label312;
        }
        localObject2 = com.tencent.mm.plugin.finder.live.view.convert.a.zaD;
        if (!com.tencent.mm.plugin.finder.live.view.convert.a.j(localFinderObject)) {
          break label312;
        }
        parambcu.add(localFinderObject);
        break label97;
        bool = false;
        break;
        j = 0;
        break label175;
        label282:
        i += 1;
        break label139;
        j = -1;
        break label181;
        label294:
        k = 0;
        break label233;
        label300:
        i += 1;
        break label198;
        label307:
        i = -1;
      }
      label312:
      localObject2 = new StringBuilder("merge live list feed:");
      com.tencent.mm.plugin.finder.live.view.convert.a locala = com.tencent.mm.plugin.finder.live.view.convert.a.zaD;
      Log.i("FinderFeedLiveList", com.tencent.mm.plugin.finder.live.view.convert.a.h(localFinderObject) + ',' + localFinderObject.nickname + " exist!");
    }
    label369:
    if (parambcu.size() > 0)
    {
      parambcu = eA((List)parambcu);
      this.fmA.addAll((Collection)parambcu);
      dKz();
      dKA();
      AppMethodBeat.o(282446);
      return parambcu;
    }
    AppMethodBeat.o(282446);
    return null;
  }
  
  public final int bAQ()
  {
    return 2003;
  }
  
  public final ArrayList<y> dKy()
  {
    AppMethodBeat.i(282437);
    ArrayList localArrayList;
    try
    {
      Object localObject1 = (Iterable)this.fmA;
      Collection localCollection = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if ((localObject2 instanceof y))
        {
          localCollection.add(localObject2);
          continue;
          AppMethodBeat.o(282437);
        }
      }
    }
    catch (Exception localException)
    {
      Log.e("FinderFeedLiveList", "get liveList:" + localException.getMessage());
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      return localArrayList;
      localArrayList = (ArrayList)localArrayList;
    }
  }
  
  public final long mf()
  {
    return this.zAB;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(282449);
    int j = this.fmA.size();
    StringBuilder localStringBuilder1 = new StringBuilder("liveListId,size:" + j + ':');
    int i = 0;
    if (i < j)
    {
      bu localbu = (bu)this.fmA.get(i);
      if ((localbu instanceof y))
      {
        StringBuilder localStringBuilder2 = new StringBuilder("[index:").append(i).append(",username:").append(((y)localbu).zAF.nickname).append(",feedId:").append(((y)localbu).zAF.id).append(",liveId:");
        localObject = ((y)localbu).zAF.liveInfo;
        if (localObject != null)
        {
          localObject = Long.valueOf(((bac)localObject).liveId);
          label159:
          localStringBuilder1.append(localObject + "，friendLikeCount:" + ((y)localbu).zAF.friendLikeCount + ']');
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = null;
        break label159;
        localStringBuilder1.append("[index:" + i + ",feedId:" + localbu.mf() + ']');
      }
    }
    Object localObject = localStringBuilder1.toString();
    p.j(localObject, "sb.toString()");
    AppMethodBeat.o(282449);
    return localObject;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList$Companion;", "", "()V", "ENABLE_FOOTER_ITEM", "", "ENABLE_HEAD_ITEM", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.x
 * JD-Core Version:    0.7.0.1
 */