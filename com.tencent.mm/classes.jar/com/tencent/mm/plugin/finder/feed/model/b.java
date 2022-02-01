package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.b;
import com.tencent.mm.plugin.finder.storage.t;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.j;
import d.b.a;
import d.g.b.k;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentLoader;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "curFeedId", "", "curRefCommentId", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lkotlin/collections/ArrayList;", "addItem", "", "item", "sort", "", "addItems", "", "itemList", "", "toHead", "toTail", "addLevel2Items", "Lkotlin/Pair;", "rootComment", "down", "clearData", "delItemById", "commentId", "delItemByLocalId", "localCommentId", "filterComment", "", "get", "index", "getData", "getPositionToInsertLevel2Comment", "rootCommentId", "getSize", "hasLevel2Item", "root", "hasLevel2ItemAfter", "level2Comment", "hasLevel2ItemBefore", "onAttach", "Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache$Extra;", "feedId", "refCommentId", "useCache", "onDetach", "pos", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "upContinue", "downContinue", "hasExpand", "sameComment", "comment1", "comment2", "sameParent", "updateItem", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "Companion", "plugin-finder_release"})
public final class b
{
  public static final a rmA;
  public static final boolean rmz = false;
  public final String TAG;
  public final ArrayList<com.tencent.mm.plugin.finder.model.l> data;
  public long rmx;
  public long rmy;
  
  static
  {
    AppMethodBeat.i(166031);
    rmA = new a((byte)0);
    AppMethodBeat.o(166031);
  }
  
  public b()
  {
    AppMethodBeat.i(166030);
    this.TAG = "Finder.FinderCommentLoader";
    this.data = new ArrayList();
    AppMethodBeat.o(166030);
  }
  
  public static boolean a(com.tencent.mm.plugin.finder.model.l paraml1, com.tencent.mm.plugin.finder.model.l paraml2)
  {
    AppMethodBeat.i(178290);
    k.h(paraml1, "comment1");
    k.h(paraml2, "comment2");
    if ((paraml1.ruO.field_actionInfo.qXu != 0L) && (paraml1.ruO.field_actionInfo.qXu == paraml2.ruO.field_actionInfo.qXu))
    {
      AppMethodBeat.o(178290);
      return true;
    }
    AppMethodBeat.o(178290);
    return false;
  }
  
  public static boolean b(com.tencent.mm.plugin.finder.model.l paraml1, com.tencent.mm.plugin.finder.model.l paraml2)
  {
    AppMethodBeat.i(178291);
    k.h(paraml1, "comment1");
    k.h(paraml2, "comment2");
    if (paraml1.ruO.field_actionInfo.EDq.commentId == paraml2.ruO.field_actionInfo.EDq.commentId)
    {
      AppMethodBeat.o(178291);
      return true;
    }
    AppMethodBeat.o(178291);
    return false;
  }
  
  public final com.tencent.mm.plugin.finder.model.l DI(int paramInt)
  {
    AppMethodBeat.i(166026);
    Object localObject = this.data.get(paramInt);
    k.g(localObject, "data[index]");
    localObject = (com.tencent.mm.plugin.finder.model.l)localObject;
    AppMethodBeat.o(166026);
    return localObject;
  }
  
  public final void a(List<? extends com.tencent.mm.plugin.finder.model.l> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(166028);
    k.h(paramList, "itemList");
    List localList = dy(paramList);
    if (localList.size() > 1) {
      j.a(localList, (Comparator)new b());
    }
    int i = paramList.size();
    int j = localList.size();
    ac.i(this.TAG, "reduce size: " + (i - j) + ", data size: " + this.data.size());
    if (paramBoolean1)
    {
      this.data.addAll(0, (Collection)localList);
      AppMethodBeat.o(166028);
      return;
    }
    if (paramBoolean2) {
      this.data.addAll(this.data.size(), (Collection)localList);
    }
    AppMethodBeat.o(166028);
  }
  
  public final int b(com.tencent.mm.plugin.finder.model.l paraml)
  {
    int k = 0;
    AppMethodBeat.i(178286);
    k.h(paraml, "item");
    ac.i(this.TAG, "addItem " + paraml.ruO.field_actionInfo.EDq.commentId + ", sort:true");
    Iterator localIterator;
    int j;
    if (paraml.ruO.field_actionInfo.EDq.commentId == 0L)
    {
      localIterator = ((List)this.data).iterator();
      i = 0;
      if (localIterator.hasNext()) {
        if (((com.tencent.mm.plugin.finder.model.l)localIterator.next()).ruO.field_localCommentId == paraml.ruO.field_localCommentId)
        {
          j = 1;
          label127:
          if (j == 0) {
            break label157;
          }
        }
      }
    }
    for (;;)
    {
      if (i < 0) {
        break label260;
      }
      this.data.set(i, paraml);
      AppMethodBeat.o(178286);
      return i;
      j = 0;
      break label127;
      label157:
      i += 1;
      break;
      i = -1;
      continue;
      localIterator = ((List)this.data).iterator();
      i = 0;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label255;
        }
        if (((com.tencent.mm.plugin.finder.model.l)localIterator.next()).ruO.field_actionInfo.EDq.commentId == paraml.ruO.field_actionInfo.EDq.commentId) {}
        for (j = 1;; j = 0)
        {
          if (j == 0) {
            break label248;
          }
          break;
        }
        label248:
        i += 1;
      }
      label255:
      i = -1;
    }
    label260:
    if (paraml.ruO.field_actionInfo.qXu == 0L)
    {
      this.data.size();
      i = k;
      if (paraml.ruO.field_state != -1)
      {
        if (paraml.ruO.field_actionInfo.EDq.displayid == 0L) {
          i = k;
        }
      }
      else
      {
        this.data.add(i, paraml);
        AppMethodBeat.o(178286);
        return i;
      }
      localIterator = ((List)this.data).iterator();
      i = 0;
      label350:
      if (localIterator.hasNext()) {
        if (((com.tencent.mm.plugin.finder.model.l)localIterator.next()).ruO.field_actionInfo.EDq.displayid <= paraml.ruO.field_actionInfo.EDq.displayid)
        {
          j = 1;
          if (j == 0) {
            break label429;
          }
        }
      }
      label401:
      for (j = i;; j = -1)
      {
        i = j;
        if (j >= 0) {
          break;
        }
        i = this.data.size();
        break;
        j = 0;
        break label401;
        label429:
        i += 1;
        break label350;
      }
    }
    int i = t(paraml.ruO.field_actionInfo.qXu, true);
    this.data.add(i, paraml);
    AppMethodBeat.o(178286);
    return i;
  }
  
  public final o<e.b, Boolean> b(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(166025);
    this.rmx = paramLong1;
    this.rmy = paramLong2;
    if (this.data.size() > 0) {
      this.data.clear();
    }
    Object localObject1 = null;
    boolean bool = false;
    if (paramBoolean)
    {
      localObject1 = e.rEI.O(paramLong1, paramLong2);
      paramBoolean = bool;
      if (localObject1 != null)
      {
        ArrayList localArrayList = this.data;
        Object localObject2 = (Iterable)localObject1;
        Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          localCollection.add(new com.tencent.mm.plugin.finder.model.l((t)((Iterator)localObject2).next()));
        }
        localArrayList.addAll((Collection)localCollection);
        ac.i(this.TAG, "onAttach hit datacache, " + ((List)localObject1).size());
        paramBoolean = true;
      }
      localObject1 = e.rEI.P(paramLong1, paramLong2);
    }
    for (;;)
    {
      if (localObject1 != null) {}
      for (int i = ((e.b)localObject1).pos; i >= 0; i = -1)
      {
        if (localObject1 == null) {
          k.fOy();
        }
        localObject1 = new o(localObject1, Boolean.valueOf(paramBoolean));
        AppMethodBeat.o(166025);
        return localObject1;
      }
      bool = true;
      if (paramLong2 == 0L) {
        bool = false;
      }
      ac.i(this.TAG, "miss cache, upContinue:" + bool + ", downContinue:true");
      localObject1 = new o(new e.b(0, null, bool, true, false), Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(166025);
      return localObject1;
      paramBoolean = false;
    }
  }
  
  public final boolean c(com.tencent.mm.plugin.finder.model.l paraml)
  {
    AppMethodBeat.i(178289);
    k.h(paraml, "level2Comment");
    Iterator localIterator = ((Iterable)this.data).iterator();
    int i = 0;
    int j = -1;
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        j.fOc();
      }
      localObject = (com.tencent.mm.plugin.finder.model.l)localObject;
      if (b((com.tencent.mm.plugin.finder.model.l)localObject, paraml))
      {
        ac.d(this.TAG, "hasLevel2ItemAfter cur:" + i + ", before:" + j);
        if (j < 0) {}
        while (i <= j)
        {
          AppMethodBeat.o(178289);
          return false;
        }
        AppMethodBeat.o(178289);
        return true;
      }
      if (!a((com.tencent.mm.plugin.finder.model.l)localObject, paraml)) {
        break label158;
      }
      j = i;
    }
    label158:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(178289);
      return false;
    }
  }
  
  public final List<com.tencent.mm.plugin.finder.model.l> dy(List<? extends com.tencent.mm.plugin.finder.model.l> paramList)
  {
    AppMethodBeat.i(178287);
    List localList = (List)new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.finder.model.l locall = (com.tencent.mm.plugin.finder.model.l)paramList.next();
      Object localObject = (List)this.data;
      int i = 0;
      localObject = ((List)localObject).iterator();
      label68:
      int j;
      label120:
      label126:
      int k;
      if (((Iterator)localObject).hasNext()) {
        if (((com.tencent.mm.plugin.finder.model.l)((Iterator)localObject).next()).ruO.field_actionInfo.EDq.commentId == locall.ruO.field_actionInfo.EDq.commentId)
        {
          j = 1;
          if (j == 0) {
            break label272;
          }
          j = i;
          localObject = localList.iterator();
          i = 0;
          label137:
          if (!((Iterator)localObject).hasNext()) {
            break label297;
          }
          if (((com.tencent.mm.plugin.finder.model.l)((Iterator)localObject).next()).ruO.field_actionInfo.EDq.commentId != locall.ruO.field_actionInfo.EDq.commentId) {
            break label284;
          }
          k = 1;
          label190:
          if (k == 0) {
            break label290;
          }
        }
      }
      for (;;)
      {
        if (j < 0) {
          break label302;
        }
        this.data.set(j, locall);
        ac.i(this.TAG, "filter1:" + locall.ruO.field_actionInfo.EDq.commentId + ", " + locall.ruO.cAR());
        break;
        j = 0;
        break label120;
        label272:
        i += 1;
        break label68;
        j = -1;
        break label126;
        label284:
        k = 0;
        break label190;
        label290:
        i += 1;
        break label137;
        label297:
        i = -1;
      }
      label302:
      if (i >= 0) {
        ac.i(this.TAG, "filter2:" + locall.ruO.field_actionInfo.EDq.commentId);
      } else {
        localList.add(locall);
      }
    }
    AppMethodBeat.o(178287);
    return localList;
  }
  
  public final int t(long paramLong, boolean paramBoolean)
  {
    int k = -1;
    AppMethodBeat.i(178288);
    Object localObject = ((List)this.data).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject).hasNext()) {
      if (((com.tencent.mm.plugin.finder.model.l)((Iterator)localObject).next()).ruO.field_actionInfo.EDq.commentId == paramLong)
      {
        j = 1;
        label66:
        if (j == 0) {
          break label177;
        }
        label71:
        localObject = (List)this.data;
        localObject = ((List)localObject).listIterator(((List)localObject).size());
      }
    }
    label177:
    label192:
    label196:
    for (;;)
    {
      j = k;
      if (((ListIterator)localObject).hasPrevious()) {
        if (((com.tencent.mm.plugin.finder.model.l)((ListIterator)localObject).previous()).ruO.field_actionInfo.qXu != paramLong) {
          break label192;
        }
      }
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          break label196;
        }
        j = ((ListIterator)localObject).nextIndex();
        if ((!paramBoolean) || (j < 0)) {
          break label198;
        }
        AppMethodBeat.o(178288);
        return j + 1;
        j = 0;
        break label66;
        i += 1;
        break;
        i = -1;
        break label71;
      }
    }
    label198:
    AppMethodBeat.o(178288);
    return i + 1;
  }
  
  public final void uk(long paramLong)
  {
    AppMethodBeat.i(166029);
    Object localObject2 = (Iterable)this.data;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label93:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (((com.tencent.mm.plugin.finder.model.l)localObject3).ruO.field_localCommentId == paramLong) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label93;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject1 = (List)localObject1;
    this.data.removeAll((Collection)localObject1);
    AppMethodBeat.o(166029);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentLoader$Companion;", "", "()V", "debugDisable", "", "clearCache", "", "feedId", "", "putCache", "commentId", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lkotlin/collections/ArrayList;", "plugin-finder_release"})
  public static final class a
  {
    public static void a(long paramLong1, long paramLong2, ArrayList<com.tencent.mm.plugin.finder.model.l> paramArrayList)
    {
      AppMethodBeat.i(166023);
      k.h(paramArrayList, "data");
      if (b.cvz())
      {
        AppMethodBeat.o(166023);
        return;
      }
      e locale = e.rEI;
      Object localObject = (Iterable)paramArrayList;
      paramArrayList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramArrayList.add(((com.tencent.mm.plugin.finder.model.l)((Iterator)localObject).next()).ruO);
      }
      locale.a(paramLong1, paramLong2, (List)paramArrayList);
      AppMethodBeat.o(166023);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(166024);
      int i = a.a((Comparable)Long.valueOf(((com.tencent.mm.plugin.finder.model.l)paramT2).ruO.field_actionInfo.EDq.displayid), (Comparable)Long.valueOf(((com.tencent.mm.plugin.finder.model.l)paramT1).ruO.field_actionInfo.EDq.displayid));
      AppMethodBeat.o(166024);
      return i;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class c<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(178285);
      int i = a.a((Comparable)Long.valueOf(((com.tencent.mm.plugin.finder.model.l)paramT2).ruO.field_actionInfo.EDq.displayid), (Comparable)Long.valueOf(((com.tencent.mm.plugin.finder.model.l)paramT1).ruO.field_actionInfo.EDq.displayid));
      AppMethodBeat.o(178285);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.b
 * JD-Core Version:    0.7.0.1
 */