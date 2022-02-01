package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.n;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.b;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.alr;
import com.tencent.mm.sdk.platformtools.ae;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentLoader;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "curFeedId", "", "curRefCommentId", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lkotlin/collections/ArrayList;", "addItem", "", "item", "sort", "", "addItems", "", "itemList", "", "toHead", "toTail", "addLevel2Items", "Lkotlin/Pair;", "rootComment", "down", "clearData", "delItemById", "commentId", "delItemByLocalId", "localCommentId", "filterComment", "", "get", "index", "getData", "getPositionToInsertLevel2Comment", "rootCommentId", "getSize", "hasLevel2Item", "root", "hasLevel2ItemAfter", "level2Comment", "hasLevel2ItemBefore", "onAttach", "Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache$Extra;", "feedId", "refCommentId", "useCache", "onDetach", "pos", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "upContinue", "downContinue", "hasExpand", "sameComment", "comment1", "comment2", "sameParent", "updateItem", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "Companion", "plugin-finder_release"})
public final class c
{
  public static final boolean sjU = false;
  public static final a sjV;
  public final String TAG;
  public final ArrayList<n> data;
  public long sjS;
  public long sjT;
  
  static
  {
    AppMethodBeat.i(166031);
    sjV = new a((byte)0);
    AppMethodBeat.o(166031);
  }
  
  public c()
  {
    AppMethodBeat.i(166030);
    this.TAG = "Finder.FinderCommentLoader";
    this.data = new ArrayList();
    AppMethodBeat.o(166030);
  }
  
  public static boolean a(n paramn1, n paramn2)
  {
    AppMethodBeat.i(178290);
    p.h(paramn1, "comment1");
    p.h(paramn2, "comment2");
    if ((paramn1.ste.field_actionInfo.rQN != 0L) && (paramn1.ste.field_actionInfo.rQN == paramn2.ste.field_actionInfo.rQN))
    {
      AppMethodBeat.o(178290);
      return true;
    }
    AppMethodBeat.o(178290);
    return false;
  }
  
  public static boolean b(n paramn1, n paramn2)
  {
    AppMethodBeat.i(178291);
    p.h(paramn1, "comment1");
    p.h(paramn2, "comment2");
    if (paramn1.ste.cLl().commentId == paramn2.ste.cLl().commentId)
    {
      AppMethodBeat.o(178291);
      return true;
    }
    AppMethodBeat.o(178291);
    return false;
  }
  
  public final n EO(int paramInt)
  {
    AppMethodBeat.i(166026);
    Object localObject = this.data.get(paramInt);
    p.g(localObject, "data[index]");
    localObject = (n)localObject;
    AppMethodBeat.o(166026);
    return localObject;
  }
  
  public final void a(List<? extends n> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(166028);
    p.h(paramList, "itemList");
    List localList = dG(paramList);
    if (localList.size() > 1) {
      j.a(localList, (Comparator)new b());
    }
    int i = paramList.size();
    int j = localList.size();
    ae.i(this.TAG, "reduce size: " + (i - j) + ", data size: " + this.data.size());
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
  
  public final int b(n paramn)
  {
    int k = 0;
    AppMethodBeat.i(178286);
    p.h(paramn, "item");
    ae.i(this.TAG, "addItem " + paramn.ste.cLl().commentId + ", sort:true");
    Iterator localIterator;
    int j;
    if (paramn.ste.cLl().commentId == 0L)
    {
      localIterator = ((List)this.data).iterator();
      i = 0;
      if (localIterator.hasNext()) {
        if (((n)localIterator.next()).ste.field_localCommentId == paramn.ste.field_localCommentId)
        {
          j = 1;
          label121:
          if (j == 0) {
            break label151;
          }
        }
      }
    }
    for (;;)
    {
      if (i < 0) {
        break label248;
      }
      this.data.set(i, paramn);
      AppMethodBeat.o(178286);
      return i;
      j = 0;
      break label121;
      label151:
      i += 1;
      break;
      i = -1;
      continue;
      localIterator = ((List)this.data).iterator();
      i = 0;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label243;
        }
        if (((n)localIterator.next()).ste.cLl().commentId == paramn.ste.cLl().commentId) {}
        for (j = 1;; j = 0)
        {
          if (j == 0) {
            break label236;
          }
          break;
        }
        label236:
        i += 1;
      }
      label243:
      i = -1;
    }
    label248:
    if (paramn.ste.field_actionInfo.rQN == 0L)
    {
      this.data.size();
      i = k;
      if (paramn.ste.field_state != -1)
      {
        if (paramn.ste.cLl().displayid == 0L) {
          i = k;
        }
      }
      else
      {
        this.data.add(i, paramn);
        AppMethodBeat.o(178286);
        return i;
      }
      localIterator = ((List)this.data).iterator();
      i = 0;
      if (localIterator.hasNext()) {
        if (((n)localIterator.next()).ste.cLl().displayid <= paramn.ste.cLl().displayid)
        {
          j = 1;
          label380:
          if (j == 0) {
            break label408;
          }
        }
      }
      for (j = i;; j = -1)
      {
        i = j;
        if (j >= 0) {
          break;
        }
        i = this.data.size();
        break;
        j = 0;
        break label380;
        i += 1;
        break label335;
      }
    }
    label335:
    int i = t(paramn.ste.field_actionInfo.rQN, true);
    label408:
    this.data.add(i, paramn);
    AppMethodBeat.o(178286);
    return i;
  }
  
  public final o<e.b, Boolean> b(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(166025);
    this.sjS = paramLong1;
    this.sjT = paramLong2;
    if (this.data.size() > 0) {
      this.data.clear();
    }
    Object localObject1 = null;
    boolean bool = false;
    if (paramBoolean)
    {
      localObject1 = e.sKJ.O(paramLong1, paramLong2);
      paramBoolean = bool;
      if (localObject1 != null)
      {
        ArrayList localArrayList = this.data;
        Object localObject2 = (Iterable)localObject1;
        Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          localCollection.add(new n((ab)((Iterator)localObject2).next()));
        }
        localArrayList.addAll((Collection)localCollection);
        ae.i(this.TAG, "onAttach hit datacache, " + ((List)localObject1).size());
        paramBoolean = true;
      }
      localObject1 = e.sKJ.P(paramLong1, paramLong2);
    }
    for (;;)
    {
      if (localObject1 != null) {}
      for (int i = ((e.b)localObject1).pos; i >= 0; i = -1)
      {
        if (localObject1 == null) {
          p.gkB();
        }
        localObject1 = new o(localObject1, Boolean.valueOf(paramBoolean));
        AppMethodBeat.o(166025);
        return localObject1;
      }
      bool = true;
      if (paramLong2 == 0L) {
        bool = false;
      }
      ae.i(this.TAG, "miss cache, upContinue:" + bool + ", downContinue:true");
      localObject1 = new o(new e.b(0, null, bool, true, false), Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(166025);
      return localObject1;
      paramBoolean = false;
    }
  }
  
  public final boolean c(n paramn)
  {
    AppMethodBeat.i(178289);
    p.h(paramn, "level2Comment");
    Iterator localIterator = ((Iterable)this.data).iterator();
    int i = 0;
    int j = -1;
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        j.gkd();
      }
      localObject = (n)localObject;
      if (b((n)localObject, paramn))
      {
        ae.d(this.TAG, "hasLevel2ItemAfter cur:" + i + ", before:" + j);
        if (j < 0) {}
        while (i <= j)
        {
          AppMethodBeat.o(178289);
          return false;
        }
        AppMethodBeat.o(178289);
        return true;
      }
      if (!a((n)localObject, paramn)) {
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
  
  public final List<n> dG(List<? extends n> paramList)
  {
    AppMethodBeat.i(178287);
    List localList = (List)new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      n localn = (n)paramList.next();
      Object localObject = (List)this.data;
      int i = 0;
      localObject = ((List)localObject).iterator();
      label68:
      int j;
      label114:
      label120:
      int k;
      if (((Iterator)localObject).hasNext()) {
        if (((n)((Iterator)localObject).next()).ste.cLl().commentId == localn.ste.cLl().commentId)
        {
          j = 1;
          if (j == 0) {
            break label257;
          }
          j = i;
          localObject = localList.iterator();
          i = 0;
          label131:
          if (!((Iterator)localObject).hasNext()) {
            break label282;
          }
          if (((n)((Iterator)localObject).next()).ste.cLl().commentId != localn.ste.cLl().commentId) {
            break label269;
          }
          k = 1;
          label178:
          if (k == 0) {
            break label275;
          }
        }
      }
      for (;;)
      {
        if (j < 0) {
          break label287;
        }
        this.data.set(j, localn);
        ae.i(this.TAG, "filter1:" + localn.ste.cLl().commentId + ", " + localn.ste.cLq());
        break;
        j = 0;
        break label114;
        label257:
        i += 1;
        break label68;
        j = -1;
        break label120;
        label269:
        k = 0;
        break label178;
        label275:
        i += 1;
        break label131;
        label282:
        i = -1;
      }
      label287:
      if (i >= 0) {
        ae.i(this.TAG, "filter2:" + localn.ste.cLl().commentId);
      } else {
        localList.add(localn);
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
      if (((n)((Iterator)localObject).next()).ste.cLl().commentId == paramLong)
      {
        j = 1;
        label63:
        if (j == 0) {
          break label174;
        }
        label68:
        localObject = (List)this.data;
        localObject = ((List)localObject).listIterator(((List)localObject).size());
      }
    }
    label174:
    label189:
    label193:
    for (;;)
    {
      j = k;
      if (((ListIterator)localObject).hasPrevious()) {
        if (((n)((ListIterator)localObject).previous()).ste.field_actionInfo.rQN != paramLong) {
          break label189;
        }
      }
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          break label193;
        }
        j = ((ListIterator)localObject).nextIndex();
        if ((!paramBoolean) || (j < 0)) {
          break label195;
        }
        AppMethodBeat.o(178288);
        return j + 1;
        j = 0;
        break label63;
        i += 1;
        break;
        i = -1;
        break label68;
      }
    }
    label195:
    AppMethodBeat.o(178288);
    return i + 1;
  }
  
  public final void wy(long paramLong)
  {
    AppMethodBeat.i(166029);
    Object localObject2 = (Iterable)this.data;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label93:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (((n)localObject3).ste.field_localCommentId == paramLong) {}
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentLoader$Companion;", "", "()V", "debugDisable", "", "clearCache", "", "feedId", "", "putCache", "commentId", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lkotlin/collections/ArrayList;", "plugin-finder_release"})
  public static final class a
  {
    public static void a(long paramLong1, long paramLong2, ArrayList<n> paramArrayList)
    {
      AppMethodBeat.i(166023);
      p.h(paramArrayList, "data");
      if (c.cDE())
      {
        AppMethodBeat.o(166023);
        return;
      }
      e locale = e.sKJ;
      Object localObject = (Iterable)paramArrayList;
      paramArrayList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramArrayList.add(((n)((Iterator)localObject).next()).ste);
      }
      locale.a(paramLong1, paramLong2, (List)paramArrayList);
      AppMethodBeat.o(166023);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(166024);
      int i = a.a((Comparable)Long.valueOf(((n)paramT2).ste.cLl().displayid), (Comparable)Long.valueOf(((n)paramT1).ste.cLl().displayid));
      AppMethodBeat.o(166024);
      return i;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class c<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(178285);
      int i = a.a((Comparable)Long.valueOf(((n)paramT2).ste.cLl().displayid), (Comparable)Long.valueOf(((n)paramT1).ste.cLl().displayid));
      AppMethodBeat.o(178285);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.c
 * JD-Core Version:    0.7.0.1
 */