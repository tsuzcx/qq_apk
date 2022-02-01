package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.m;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.b;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.alh;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.b.a;
import d.g.b.p;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentLoader;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "curFeedId", "", "curRefCommentId", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lkotlin/collections/ArrayList;", "addItem", "", "item", "sort", "", "addItems", "", "itemList", "", "toHead", "toTail", "addLevel2Items", "Lkotlin/Pair;", "rootComment", "down", "clearData", "delItemById", "commentId", "delItemByLocalId", "localCommentId", "filterComment", "", "get", "index", "getData", "getPositionToInsertLevel2Comment", "rootCommentId", "getSize", "hasLevel2Item", "root", "hasLevel2ItemAfter", "level2Comment", "hasLevel2ItemBefore", "onAttach", "Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache$Extra;", "feedId", "refCommentId", "useCache", "onDetach", "pos", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "upContinue", "downContinue", "hasExpand", "sameComment", "comment1", "comment2", "sameParent", "updateItem", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "Companion", "plugin-finder_release"})
public final class c
{
  public static final boolean sbf = false;
  public static final a sbg;
  public final String TAG;
  public final ArrayList<m> data;
  public long sbd;
  public long sbe;
  
  static
  {
    AppMethodBeat.i(166031);
    sbg = new a((byte)0);
    AppMethodBeat.o(166031);
  }
  
  public c()
  {
    AppMethodBeat.i(166030);
    this.TAG = "Finder.FinderCommentLoader";
    this.data = new ArrayList();
    AppMethodBeat.o(166030);
  }
  
  public static boolean a(m paramm1, m paramm2)
  {
    AppMethodBeat.i(178290);
    p.h(paramm1, "comment1");
    p.h(paramm2, "comment2");
    if ((paramm1.skh.field_actionInfo.rID != 0L) && (paramm1.skh.field_actionInfo.rID == paramm2.skh.field_actionInfo.rID))
    {
      AppMethodBeat.o(178290);
      return true;
    }
    AppMethodBeat.o(178290);
    return false;
  }
  
  public static boolean b(m paramm1, m paramm2)
  {
    AppMethodBeat.i(178291);
    p.h(paramm1, "comment1");
    p.h(paramm2, "comment2");
    if (paramm1.skh.field_actionInfo.Gla.commentId == paramm2.skh.field_actionInfo.Gla.commentId)
    {
      AppMethodBeat.o(178291);
      return true;
    }
    AppMethodBeat.o(178291);
    return false;
  }
  
  public final m EB(int paramInt)
  {
    AppMethodBeat.i(166026);
    Object localObject = this.data.get(paramInt);
    p.g(localObject, "data[index]");
    localObject = (m)localObject;
    AppMethodBeat.o(166026);
    return localObject;
  }
  
  public final void a(List<? extends m> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(166028);
    p.h(paramList, "itemList");
    List localList = dD(paramList);
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
  
  public final int b(m paramm)
  {
    int k = 0;
    AppMethodBeat.i(178286);
    p.h(paramm, "item");
    ad.i(this.TAG, "addItem " + paramm.skh.field_actionInfo.Gla.commentId + ", sort:true");
    Iterator localIterator;
    int j;
    if (paramm.skh.field_actionInfo.Gla.commentId == 0L)
    {
      localIterator = ((List)this.data).iterator();
      i = 0;
      if (localIterator.hasNext()) {
        if (((m)localIterator.next()).skh.field_localCommentId == paramm.skh.field_localCommentId)
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
      this.data.set(i, paramm);
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
        if (((m)localIterator.next()).skh.field_actionInfo.Gla.commentId == paramm.skh.field_actionInfo.Gla.commentId) {}
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
    if (paramm.skh.field_actionInfo.rID == 0L)
    {
      this.data.size();
      i = k;
      if (paramm.skh.field_state != -1)
      {
        if (paramm.skh.field_actionInfo.Gla.displayid == 0L) {
          i = k;
        }
      }
      else
      {
        this.data.add(i, paramm);
        AppMethodBeat.o(178286);
        return i;
      }
      localIterator = ((List)this.data).iterator();
      i = 0;
      label350:
      if (localIterator.hasNext()) {
        if (((m)localIterator.next()).skh.field_actionInfo.Gla.displayid <= paramm.skh.field_actionInfo.Gla.displayid)
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
    int i = t(paramm.skh.field_actionInfo.rID, true);
    this.data.add(i, paramm);
    AppMethodBeat.o(178286);
    return i;
  }
  
  public final o<e.b, Boolean> b(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(166025);
    this.sbd = paramLong1;
    this.sbe = paramLong2;
    if (this.data.size() > 0) {
      this.data.clear();
    }
    Object localObject1 = null;
    boolean bool = false;
    if (paramBoolean)
    {
      localObject1 = e.szM.P(paramLong1, paramLong2);
      paramBoolean = bool;
      if (localObject1 != null)
      {
        ArrayList localArrayList = this.data;
        Object localObject2 = (Iterable)localObject1;
        Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          localCollection.add(new m((ab)((Iterator)localObject2).next()));
        }
        localArrayList.addAll((Collection)localCollection);
        ad.i(this.TAG, "onAttach hit datacache, " + ((List)localObject1).size());
        paramBoolean = true;
      }
      localObject1 = e.szM.Q(paramLong1, paramLong2);
    }
    for (;;)
    {
      if (localObject1 != null) {}
      for (int i = ((e.b)localObject1).pos; i >= 0; i = -1)
      {
        if (localObject1 == null) {
          p.gfZ();
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
      localObject1 = new o(new e.b(0, null, bool, true, false), Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(166025);
      return localObject1;
      paramBoolean = false;
    }
  }
  
  public final boolean c(m paramm)
  {
    AppMethodBeat.i(178289);
    p.h(paramm, "level2Comment");
    Iterator localIterator = ((Iterable)this.data).iterator();
    int i = 0;
    int j = -1;
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        j.gfB();
      }
      localObject = (m)localObject;
      if (b((m)localObject, paramm))
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
      if (!a((m)localObject, paramm)) {
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
  
  public final List<m> dD(List<? extends m> paramList)
  {
    AppMethodBeat.i(178287);
    List localList = (List)new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      m localm = (m)paramList.next();
      Object localObject = (List)this.data;
      int i = 0;
      localObject = ((List)localObject).iterator();
      label68:
      int j;
      label120:
      label126:
      int k;
      if (((Iterator)localObject).hasNext()) {
        if (((m)((Iterator)localObject).next()).skh.field_actionInfo.Gla.commentId == localm.skh.field_actionInfo.Gla.commentId)
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
          if (((m)((Iterator)localObject).next()).skh.field_actionInfo.Gla.commentId != localm.skh.field_actionInfo.Gla.commentId) {
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
        this.data.set(j, localm);
        ad.i(this.TAG, "filter1:" + localm.skh.field_actionInfo.Gla.commentId + ", " + localm.skh.cIN());
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
        ad.i(this.TAG, "filter2:" + localm.skh.field_actionInfo.Gla.commentId);
      } else {
        localList.add(localm);
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
      if (((m)((Iterator)localObject).next()).skh.field_actionInfo.Gla.commentId == paramLong)
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
        if (((m)((ListIterator)localObject).previous()).skh.field_actionInfo.rID != paramLong) {
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
  
  public final void wi(long paramLong)
  {
    AppMethodBeat.i(166029);
    Object localObject2 = (Iterable)this.data;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label93:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (((m)localObject3).skh.field_localCommentId == paramLong) {}
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentLoader$Companion;", "", "()V", "debugDisable", "", "clearCache", "", "feedId", "", "putCache", "commentId", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lkotlin/collections/ArrayList;", "plugin-finder_release"})
  public static final class a
  {
    public static void a(long paramLong1, long paramLong2, ArrayList<m> paramArrayList)
    {
      AppMethodBeat.i(166023);
      p.h(paramArrayList, "data");
      if (c.cBS())
      {
        AppMethodBeat.o(166023);
        return;
      }
      e locale = e.szM;
      Object localObject = (Iterable)paramArrayList;
      paramArrayList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramArrayList.add(((m)((Iterator)localObject).next()).skh);
      }
      locale.a(paramLong1, paramLong2, (List)paramArrayList);
      AppMethodBeat.o(166023);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(166024);
      int i = a.a((Comparable)Long.valueOf(((m)paramT2).skh.field_actionInfo.Gla.displayid), (Comparable)Long.valueOf(((m)paramT1).skh.field_actionInfo.Gla.displayid));
      AppMethodBeat.o(166024);
      return i;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class c<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(178285);
      int i = a.a((Comparable)Long.valueOf(((m)paramT2).skh.field_actionInfo.Gla.displayid), (Comparable)Long.valueOf(((m)paramT1).skh.field_actionInfo.Gla.displayid));
      AppMethodBeat.o(178285);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.c
 * JD-Core Version:    0.7.0.1
 */