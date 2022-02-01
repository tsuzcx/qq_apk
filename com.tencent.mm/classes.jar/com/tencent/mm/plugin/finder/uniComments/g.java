package com.tencent.mm.plugin.finder.uniComments;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.u;
import com.tencent.mm.plugin.finder.uniComments.storge.b;
import com.tencent.mm.plugin.finder.uniComments.storge.d;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.atd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.b.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/UniCommentLoader;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "curFeedId", "", "curRefCommentId", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;", "Lkotlin/collections/ArrayList;", "headerData", "Lcom/tencent/mm/plugin/finder/model/FinderFeedCommentHeaderContent;", "getHeaderData", "()Lcom/tencent/mm/plugin/finder/model/FinderFeedCommentHeaderContent;", "setHeaderData", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedCommentHeaderContent;)V", "addHeaderData", "", "header", "addItem", "", "item", "sort", "", "addItems", "itemList", "", "toHead", "toTail", "addLevel2Items", "Lkotlin/Pair;", "rootComment", "down", "clearData", "isDetached", "delItemById", "commentId", "delItemByLocalId", "localCommentId", "filterComment", "", "get", "index", "getData", "getPositionToInsertLevel2Comment", "rootCommentId", "getSize", "hasLevel2Item", "root", "hasLevel2ItemAfter", "level2Comment", "hasLevel2ItemBefore", "onAttach", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentCache$Extra;", "context", "Landroid/content/Context;", "feedId", "feedObj", "Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;", "refCommentId", "useCache", "commentScene", "onDetach", "pos", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "upContinue", "downContinue", "hasExpand", "sameComment", "comment1", "comment2", "sameParent", "updateItem", "Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  static final boolean Bff = false;
  public static final a FZD;
  long Bfc;
  long Bfd;
  u Bfe;
  final String TAG;
  final ArrayList<d> data;
  
  static
  {
    AppMethodBeat.i(341440);
    FZD = new a((byte)0);
    AppMethodBeat.o(341440);
  }
  
  public g()
  {
    AppMethodBeat.i(341414);
    this.TAG = "MicroMsg.MusicUni.FinderCommentLoader";
    this.data = new ArrayList();
    AppMethodBeat.o(341414);
  }
  
  public static boolean a(d paramd1, d paramd2)
  {
    AppMethodBeat.i(341425);
    s.u(paramd1, "comment1");
    s.u(paramd2, "comment2");
    if ((paramd1.Gbp.field_actionInfo.ABa != 0L) && (paramd1.Gbp.field_actionInfo.ABa == paramd2.Gbp.field_actionInfo.ABa))
    {
      AppMethodBeat.o(341425);
      return true;
    }
    AppMethodBeat.o(341425);
    return false;
  }
  
  public static boolean b(d paramd1, d paramd2)
  {
    AppMethodBeat.i(341434);
    s.u(paramd1, "comment1");
    s.u(paramd2, "comment2");
    if (paramd1.Gbp.eZI().commentId == paramd2.Gbp.eZI().commentId)
    {
      AppMethodBeat.o(341434);
      return true;
    }
    AppMethodBeat.o(341434);
    return false;
  }
  
  public final d TL(int paramInt)
  {
    AppMethodBeat.i(341450);
    Object localObject = this.data.get(paramInt);
    s.s(localObject, "data[index]");
    localObject = (d)localObject;
    AppMethodBeat.o(341450);
    return localObject;
  }
  
  public final void a(List<? extends d> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    AppMethodBeat.i(341468);
    s.u(paramList, "itemList");
    List localList = gd(paramList);
    if (localList.size() > 1) {
      p.a(localList, (Comparator)new b());
    }
    int j = paramList.size();
    int k = localList.size();
    Log.i(this.TAG, "reduce size: " + (j - k) + ", data size: " + this.data.size());
    if (paramBoolean1)
    {
      paramList = this.data;
      if (this.Bfe == null) {
        i = 0;
      }
      paramList.addAll(i, (Collection)localList);
      AppMethodBeat.o(341468);
      return;
    }
    if (paramBoolean2) {
      this.data.addAll(this.data.size(), (Collection)localList);
    }
    AppMethodBeat.o(341468);
  }
  
  public final int b(d paramd)
  {
    int k = 0;
    AppMethodBeat.i(341459);
    s.u(paramd, "item");
    Log.i(this.TAG, "addItem " + paramd.Gbp.eZI().commentId + ", sort:true");
    Iterator localIterator;
    int j;
    if (paramd.Gbp.eZI().commentId == 0L)
    {
      localIterator = ((List)this.data).iterator();
      i = 0;
      if (localIterator.hasNext()) {
        if (((d)localIterator.next()).Gbp.field_localCommentId == paramd.Gbp.field_localCommentId)
        {
          j = 1;
          label122:
          if (j == 0) {
            break label152;
          }
        }
      }
    }
    for (;;)
    {
      if (i < 0) {
        break label249;
      }
      this.data.set(i, paramd);
      AppMethodBeat.o(341459);
      return i;
      j = 0;
      break label122;
      label152:
      i += 1;
      break;
      i = -1;
      continue;
      localIterator = ((List)this.data).iterator();
      i = 0;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label244;
        }
        if (((d)localIterator.next()).Gbp.eZI().commentId == paramd.Gbp.eZI().commentId) {}
        for (j = 1;; j = 0)
        {
          if (j == 0) {
            break label237;
          }
          break;
        }
        label237:
        i += 1;
      }
      label244:
      i = -1;
    }
    label249:
    if (paramd.Gbp.field_actionInfo.ABa == 0L)
    {
      this.data.size();
      if ((paramd.Gbp.field_state == -1) || (paramd.Gbp.eZI().displayid == 0L))
      {
        if (this.Bfe == null) {}
        for (i = k;; i = 1)
        {
          this.data.add(i, paramd);
          AppMethodBeat.o(341459);
          return i;
        }
      }
      localIterator = ((List)this.data).iterator();
      i = 0;
      if (localIterator.hasNext()) {
        if (((d)localIterator.next()).Gbp.eZI().displayid <= paramd.Gbp.eZI().displayid)
        {
          j = 1;
          if (j == 0) {
            break label418;
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
        break label390;
        i += 1;
        break label345;
      }
    }
    label345:
    int i = y(paramd.Gbp.field_actionInfo.ABa, true);
    label390:
    label418:
    this.data.add(i, paramd);
    AppMethodBeat.o(341459);
    return i;
  }
  
  public final boolean c(d paramd)
  {
    AppMethodBeat.i(341499);
    s.u(paramd, "level2Comment");
    Iterator localIterator = ((Iterable)this.data).iterator();
    int i = 0;
    int j = -1;
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        p.kkW();
      }
      localObject = (d)localObject;
      if (b((d)localObject, paramd))
      {
        Log.d(this.TAG, "hasLevel2ItemAfter cur:" + i + ", before:" + j);
        if (j >= 0)
        {
          if (j < i)
          {
            AppMethodBeat.o(341499);
            return true;
          }
          AppMethodBeat.o(341499);
          return false;
        }
        AppMethodBeat.o(341499);
        return false;
      }
      if (!a((d)localObject, paramd)) {
        break label166;
      }
      j = i;
    }
    label166:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(341499);
      return false;
    }
  }
  
  final List<d> gd(List<? extends d> paramList)
  {
    AppMethodBeat.i(341479);
    List localList = (List)new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      d locald = (d)paramList.next();
      Object localObject = (List)this.data;
      int i = 0;
      localObject = ((List)localObject).iterator();
      label68:
      int j;
      label114:
      label120:
      int k;
      if (((Iterator)localObject).hasNext()) {
        if (((d)((Iterator)localObject).next()).Gbp.eZI().commentId == locald.Gbp.eZI().commentId)
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
          if (((d)((Iterator)localObject).next()).Gbp.eZI().commentId != locald.Gbp.eZI().commentId) {
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
        this.data.set(j, locald);
        Log.i(this.TAG, "filter1:" + locald.Gbp.eZI().commentId + ", " + locald.Gbp.eZM());
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
        Log.i(this.TAG, s.X("filter2:", Long.valueOf(locald.Gbp.eZI().commentId)));
      } else {
        localList.add(locald);
      }
    }
    AppMethodBeat.o(341479);
    return localList;
  }
  
  public final void nC(long paramLong)
  {
    AppMethodBeat.i(341485);
    Object localObject2 = (Iterable)this.data;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label93:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (((d)localObject3).Gbp.field_localCommentId == paramLong) {}
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
    AppMethodBeat.o(341485);
  }
  
  final int y(long paramLong, boolean paramBoolean)
  {
    int k = -1;
    AppMethodBeat.i(341489);
    Object localObject = ((List)this.data).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject).hasNext()) {
      if (((d)((Iterator)localObject).next()).Gbp.eZI().commentId == paramLong)
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
        if (((d)((ListIterator)localObject).previous()).Gbp.field_actionInfo.ABa != paramLong) {
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
        AppMethodBeat.o(341489);
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
    AppMethodBeat.o(341489);
    return i + 1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/UniCommentLoader$Companion;", "", "()V", "debugDisable", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
  public static final class b<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(341335);
      int i = a.b((Comparable)Long.valueOf(((d)paramT2).Gbp.eZI().displayid), (Comparable)Long.valueOf(((d)paramT1).Gbp.eZI().displayid));
      AppMethodBeat.o(341335);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
  public static final class c<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(341345);
      int i = a.b((Comparable)Long.valueOf(((d)paramT2).Gbp.eZI().displayid), (Comparable)Long.valueOf(((d)paramT1).Gbp.eZI().displayid));
      AppMethodBeat.o(341345);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.g
 * JD-Core Version:    0.7.0.1
 */