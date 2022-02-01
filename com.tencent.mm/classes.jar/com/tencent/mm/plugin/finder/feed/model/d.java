package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.h;
import com.tencent.mm.plugin.finder.storage.data.c;
import com.tencent.mm.plugin.finder.storage.data.c.b;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.ahs;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.b.a;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentLoader;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "curFeedId", "", "curRefCommentId", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lkotlin/collections/ArrayList;", "addItem", "", "item", "sort", "", "addItems", "", "itemList", "", "toHead", "toTail", "addLevel2Items", "Lkotlin/Pair;", "rootComment", "down", "clearData", "delItemById", "commentId", "delItemByLocalId", "localCommentId", "filterComment", "", "get", "index", "getData", "getPositionToInsertLevel2Comment", "rootCommentId", "getSize", "hasLevel2Item", "root", "hasLevel2ItemAfter", "level2Comment", "hasLevel2ItemBefore", "onAttach", "Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache$Extra;", "feedId", "refCommentId", "useCache", "onDetach", "pos", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "upContinue", "downContinue", "hasExpand", "sameComment", "comment1", "comment2", "sameParent", "updateItem", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "Companion", "plugin-finder_release"})
public final class d
{
  public static final boolean qyx = false;
  public static final a qyy;
  public final String TAG;
  public final ArrayList<h> data;
  public long qyv;
  public long qyw;
  
  static
  {
    AppMethodBeat.i(166031);
    qyy = new a((byte)0);
    AppMethodBeat.o(166031);
  }
  
  public d()
  {
    AppMethodBeat.i(166030);
    this.TAG = "Finder.FinderCommentLoader";
    this.data = new ArrayList();
    AppMethodBeat.o(166030);
  }
  
  public static boolean a(h paramh1, h paramh2)
  {
    AppMethodBeat.i(178290);
    d.g.b.k.h(paramh1, "comment1");
    d.g.b.k.h(paramh2, "comment2");
    if ((paramh1.qDA.field_actionInfo.qoB != 0L) && (paramh1.qDA.field_actionInfo.qoB == paramh2.qDA.field_actionInfo.qoB))
    {
      AppMethodBeat.o(178290);
      return true;
    }
    AppMethodBeat.o(178290);
    return false;
  }
  
  public static boolean b(h paramh1, h paramh2)
  {
    AppMethodBeat.i(178291);
    d.g.b.k.h(paramh1, "comment1");
    d.g.b.k.h(paramh2, "comment2");
    if (paramh1.qDA.field_actionInfo.Dkk.commentId == paramh2.qDA.field_actionInfo.Dkk.commentId)
    {
      AppMethodBeat.o(178291);
      return true;
    }
    AppMethodBeat.o(178291);
    return false;
  }
  
  public final h CG(int paramInt)
  {
    AppMethodBeat.i(166026);
    Object localObject = this.data.get(paramInt);
    d.g.b.k.g(localObject, "data[index]");
    localObject = (h)localObject;
    AppMethodBeat.o(166026);
    return localObject;
  }
  
  public final int a(h paramh)
  {
    int k = 0;
    AppMethodBeat.i(178286);
    d.g.b.k.h(paramh, "item");
    ad.i(this.TAG, "addItem " + paramh.qDA.field_actionInfo.Dkk.commentId + ", sort:true");
    Iterator localIterator;
    int j;
    if (paramh.qDA.field_actionInfo.Dkk.commentId == 0L)
    {
      localIterator = ((List)this.data).iterator();
      i = 0;
      if (localIterator.hasNext()) {
        if (((h)localIterator.next()).qDA.field_localCommentId == paramh.qDA.field_localCommentId)
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
      this.data.set(i, paramh);
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
        if (((h)localIterator.next()).qDA.field_actionInfo.Dkk.commentId == paramh.qDA.field_actionInfo.Dkk.commentId) {}
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
    if (paramh.qDA.field_actionInfo.qoB == 0L)
    {
      this.data.size();
      i = k;
      if (paramh.qDA.field_state != -1)
      {
        if (paramh.qDA.field_actionInfo.Dkk.displayid == 0L) {
          i = k;
        }
      }
      else
      {
        this.data.add(i, paramh);
        AppMethodBeat.o(178286);
        return i;
      }
      localIterator = ((List)this.data).iterator();
      i = 0;
      label350:
      if (localIterator.hasNext()) {
        if (((h)localIterator.next()).qDA.field_actionInfo.Dkk.displayid <= paramh.qDA.field_actionInfo.Dkk.displayid)
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
    int i = t(paramh.qDA.field_actionInfo.qoB, true);
    this.data.add(i, paramh);
    AppMethodBeat.o(178286);
    return i;
  }
  
  public final void a(List<? extends h> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(166028);
    d.g.b.k.h(paramList, "itemList");
    List localList = dw(paramList);
    if (localList.size() > 1) {
      j.a(localList, (Comparator)new b());
    }
    int i = paramList.size();
    int j = localList.size();
    ad.i(this.TAG, "reduce size: " + (i - j) + ", data size: " + this.data.size());
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
  
  public final o<c.b, Boolean> b(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(166025);
    this.qyv = paramLong1;
    this.qyw = paramLong2;
    if (this.data.size() > 0) {
      this.data.clear();
    }
    Object localObject1 = null;
    boolean bool = false;
    if (paramBoolean)
    {
      localObject1 = c.qKo.R(paramLong1, paramLong2);
      paramBoolean = bool;
      if (localObject1 != null)
      {
        ArrayList localArrayList = this.data;
        Object localObject2 = (Iterable)localObject1;
        Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          localCollection.add(new h((com.tencent.mm.plugin.finder.storage.k)((Iterator)localObject2).next()));
        }
        localArrayList.addAll((Collection)localCollection);
        ad.i(this.TAG, "onAttach hit datacache, " + ((List)localObject1).size());
        paramBoolean = true;
      }
      localObject1 = c.qKo.S(paramLong1, paramLong2);
    }
    for (;;)
    {
      if (localObject1 != null) {}
      for (int i = ((c.b)localObject1).pos; i >= 0; i = -1)
      {
        if (localObject1 == null) {
          d.g.b.k.fvU();
        }
        localObject1 = new o(localObject1, Boolean.valueOf(paramBoolean));
        AppMethodBeat.o(166025);
        return localObject1;
      }
      bool = true;
      if (paramLong2 == 0L) {
        bool = false;
      }
      ad.i(this.TAG, "miss cache, upContinue:" + bool + ", downContinue:true");
      localObject1 = new o(new c.b(0, null, bool, true, false), Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(166025);
      return localObject1;
      paramBoolean = false;
    }
  }
  
  public final boolean b(h paramh)
  {
    AppMethodBeat.i(178289);
    d.g.b.k.h(paramh, "level2Comment");
    Iterator localIterator = ((Iterable)this.data).iterator();
    int i = 0;
    int j = -1;
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        j.fvx();
      }
      localObject = (h)localObject;
      if (b((h)localObject, paramh))
      {
        ad.d(this.TAG, "hasLevel2ItemAfter cur:" + i + ", before:" + j);
        if (j < 0) {}
        while (i <= j)
        {
          AppMethodBeat.o(178289);
          return false;
        }
        AppMethodBeat.o(178289);
        return true;
      }
      if (!a((h)localObject, paramh)) {
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
  
  public final List<h> dw(List<? extends h> paramList)
  {
    AppMethodBeat.i(178287);
    List localList = (List)new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      h localh = (h)paramList.next();
      Object localObject = (List)this.data;
      int i = 0;
      localObject = ((List)localObject).iterator();
      label68:
      int j;
      label120:
      label126:
      int k;
      if (((Iterator)localObject).hasNext()) {
        if (((h)((Iterator)localObject).next()).qDA.field_actionInfo.Dkk.commentId == localh.qDA.field_actionInfo.Dkk.commentId)
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
          if (((h)((Iterator)localObject).next()).qDA.field_actionInfo.Dkk.commentId != localh.qDA.field_actionInfo.Dkk.commentId) {
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
        this.data.set(j, localh);
        ad.i(this.TAG, "filter1:" + localh.qDA.field_actionInfo.Dkk.commentId + ", " + localh.qDA.cqy());
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
        ad.i(this.TAG, "filter2:" + localh.qDA.field_actionInfo.Dkk.commentId);
      } else {
        localList.add(localh);
      }
    }
    AppMethodBeat.o(178287);
    return localList;
  }
  
  public final void qe(long paramLong)
  {
    AppMethodBeat.i(166029);
    Object localObject2 = (Iterable)this.data;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label93:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (((h)localObject3).qDA.field_localCommentId == paramLong) {}
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
  
  public final int t(long paramLong, boolean paramBoolean)
  {
    int k = -1;
    AppMethodBeat.i(178288);
    Object localObject = ((List)this.data).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject).hasNext()) {
      if (((h)((Iterator)localObject).next()).qDA.field_actionInfo.Dkk.commentId == paramLong)
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
        if (((h)((ListIterator)localObject).previous()).qDA.field_actionInfo.qoB != paramLong) {
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentLoader$Companion;", "", "()V", "debugDisable", "", "clearCache", "", "feedId", "", "putCache", "commentId", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lkotlin/collections/ArrayList;", "plugin-finder_release"})
  public static final class a
  {
    public static void a(long paramLong1, long paramLong2, ArrayList<h> paramArrayList)
    {
      AppMethodBeat.i(166023);
      d.g.b.k.h(paramArrayList, "data");
      if (d.cmx())
      {
        AppMethodBeat.o(166023);
        return;
      }
      c localc = c.qKo;
      Object localObject = (Iterable)paramArrayList;
      paramArrayList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramArrayList.add(((h)((Iterator)localObject).next()).qDA);
      }
      localc.a(paramLong1, paramLong2, (List)paramArrayList);
      AppMethodBeat.o(166023);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(166024);
      int i = a.a((Comparable)Long.valueOf(((h)paramT2).qDA.field_actionInfo.Dkk.displayid), (Comparable)Long.valueOf(((h)paramT1).qDA.field_actionInfo.Dkk.displayid));
      AppMethodBeat.o(166024);
      return i;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class c<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(178285);
      int i = a.a((Comparable)Long.valueOf(((h)paramT2).qDA.field_actionInfo.Dkk.displayid), (Comparable)Long.valueOf(((h)paramT1).qDA.field_actionInfo.Dkk.displayid));
      AppMethodBeat.o(178285);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.d
 * JD-Core Version:    0.7.0.1
 */