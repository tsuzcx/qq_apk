package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.axi;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "()V", "finderStreamCard", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "(Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;)V", "cardBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getCardBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setCardBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "continueAtTheEnd", "", "getContinueAtTheEnd", "()Z", "setContinueAtTheEnd", "(Z)V", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "Lkotlin/collections/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "listId", "", "getListId", "()J", "setListId", "(J)V", "addAllList", "", "newList", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getIndex", "liveId", "getItemId", "getItemType", "initListId", "merge", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamResponse;", "parseLiveList", "userInfoList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "replaceList", "toString", "", "Companion", "plugin-finder_release"})
public final class x
  implements bo
{
  private static final String TAG = "FinderFeedLiveList";
  public static final a uOn;
  public ArrayList<y> dtS;
  public b tVe;
  public long uOl;
  public boolean uOm;
  
  static
  {
    AppMethodBeat.i(248747);
    uOn = new a((byte)0);
    TAG = "FinderFeedLiveList";
    AppMethodBeat.o(248747);
  }
  
  public x()
  {
    AppMethodBeat.i(248745);
    this.tVe = null;
    this.dtS = new ArrayList();
    this.uOl = dkB();
    AppMethodBeat.o(248745);
  }
  
  public x(bcu parambcu)
  {
    AppMethodBeat.i(248746);
    LinkedList localLinkedList = parambcu.object;
    p.g(localLinkedList, "finderStreamCard.`object`");
    this.dtS = ei((List)localLinkedList);
    this.tVe = parambcu.tVe;
    this.uOl = dkB();
    this.uOm = parambcu.uOm;
    AppMethodBeat.o(248746);
  }
  
  private static ArrayList<y> ei(List<? extends FinderObject> paramList)
  {
    AppMethodBeat.i(248741);
    p.h(paramList, "userInfoList");
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(new y((FinderObject)((Iterator)localObject).next()));
    }
    paramList = new ArrayList((Collection)paramList);
    AppMethodBeat.o(248741);
    return paramList;
  }
  
  public final int a(i parami)
  {
    AppMethodBeat.i(248740);
    p.h(parami, "obj");
    if (!(parami instanceof x)) {
      parami = null;
    }
    for (;;)
    {
      if ((x)parami != null)
      {
        AppMethodBeat.o(248740);
        return 0;
      }
      AppMethodBeat.o(248740);
      return -1;
    }
  }
  
  public final ArrayList<y> a(axi paramaxi)
  {
    AppMethodBeat.i(248742);
    p.h(paramaxi, "resp");
    Object localObject1 = paramaxi.object;
    Log.i(TAG, "merge remote list size:" + ((LinkedList)localObject1).size());
    this.tVe = paramaxi.lastBuffer;
    boolean bool;
    if (paramaxi.continueFlag > 0)
    {
      bool = true;
      this.uOm = bool;
      paramaxi = new LinkedList();
      p.g(localObject1, "remote");
      localObject1 = ((Iterable)localObject1).iterator();
    }
    for (;;)
    {
      label94:
      if (!((Iterator)localObject1).hasNext()) {
        break label345;
      }
      FinderObject localFinderObject = (FinderObject)((Iterator)localObject1).next();
      Object localObject2 = (List)this.dtS;
      int i = 0;
      localObject2 = ((List)localObject2).iterator();
      label136:
      int j;
      label173:
      label179:
      label196:
      int k;
      if (((Iterator)localObject2).hasNext()) {
        if (((y)((Iterator)localObject2).next()).uOo.id == localFinderObject.id)
        {
          j = 1;
          if (j == 0) {
            break label267;
          }
          j = i;
          localObject2 = (List)paramaxi;
          i = 0;
          localObject2 = ((List)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label292;
          }
          if (((FinderObject)((Iterator)localObject2).next()).id != localFinderObject.id) {
            break label279;
          }
          k = 1;
          label231:
          if (k == 0) {
            break label285;
          }
        }
      }
      for (;;)
      {
        if ((j != -1) || (i != -1)) {
          break label297;
        }
        paramaxi.add(localFinderObject);
        break label94;
        bool = false;
        break;
        j = 0;
        break label173;
        label267:
        i += 1;
        break label136;
        j = -1;
        break label179;
        label279:
        k = 0;
        break label231;
        label285:
        i += 1;
        break label196;
        label292:
        i = -1;
      }
      label297:
      Log.i(TAG, "merge live list feed:" + localFinderObject.id + ',' + localFinderObject.nickname + " exist!");
    }
    label345:
    if (paramaxi.size() > 0)
    {
      paramaxi = ei((List)paramaxi);
      p.h(paramaxi, "newList");
      this.dtS.addAll((Collection)paramaxi);
      dkB();
      AppMethodBeat.o(248742);
      return paramaxi;
    }
    AppMethodBeat.o(248742);
    return null;
  }
  
  public final int cxn()
  {
    return 2003;
  }
  
  public final long dkB()
  {
    AppMethodBeat.i(248739);
    long l = 4294967295L;
    Iterator localIterator = ((Iterable)this.dtS).iterator();
    while (localIterator.hasNext()) {
      l = ((y)localIterator.next()).uOo.id & l;
    }
    Log.i(TAG, "listId:".concat(String.valueOf(l)));
    AppMethodBeat.o(248739);
    return l;
  }
  
  public final int getIndex(long paramLong)
  {
    AppMethodBeat.i(248743);
    Iterator localIterator = ((List)this.dtS).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = ((y)localIterator.next()).uOo;
      if (localObject != null)
      {
        localObject = ((FinderObject)localObject).liveInfo;
        if ((localObject == null) || (((awe)localObject).liveId != paramLong)) {}
      }
      for (int j = 1; j != 0; j = 0)
      {
        AppMethodBeat.o(248743);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(248743);
    return -1;
  }
  
  public final long lT()
  {
    return this.uOl;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(248744);
    int j = this.dtS.size();
    StringBuilder localStringBuilder1 = new StringBuilder("liveListId,size:" + j + ':');
    int i = 0;
    if (i < j)
    {
      StringBuilder localStringBuilder2 = new StringBuilder("[username:").append(((y)this.dtS.get(i)).uOo.nickname).append(",feedId:").append(((y)this.dtS.get(i)).uOo.id).append(",liveId:");
      localObject = ((y)this.dtS.get(i)).uOo.liveInfo;
      if (localObject != null) {}
      for (localObject = Long.valueOf(((awe)localObject).liveId);; localObject = null)
      {
        localStringBuilder1.append(localObject + "，friendLikeCount:" + ((y)this.dtS.get(i)).uOo.friendLikeCount + ']');
        i += 1;
        break;
      }
    }
    Object localObject = localStringBuilder1.toString();
    p.g(localObject, "sb.toString()");
    AppMethodBeat.o(248744);
    return localObject;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.model.x
 * JD-Core Version:    0.7.0.1
 */