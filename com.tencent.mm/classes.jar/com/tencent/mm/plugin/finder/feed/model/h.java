package com.tencent.mm.plugin.finder.feed.model;

import android.text.SpannableString;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.am;
import com.tencent.mm.plugin.finder.storage.data.f;
import com.tencent.mm.plugin.finder.storage.data.f.b;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.apk;
import com.tencent.mm.protocal.protobuf.asl;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.a.j;
import kotlin.b.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentLoader;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "curFeedId", "", "curRefCommentId", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lkotlin/collections/ArrayList;", "headerData", "Lcom/tencent/mm/plugin/finder/model/FinderFeedCommentHeaderContent;", "getHeaderData", "()Lcom/tencent/mm/plugin/finder/model/FinderFeedCommentHeaderContent;", "setHeaderData", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedCommentHeaderContent;)V", "addHeaderData", "", "header", "addItem", "", "item", "sort", "", "addItems", "itemList", "", "toHead", "toTail", "addLevel2Items", "Lkotlin/Pair;", "rootComment", "down", "clearData", "isDetached", "delItemById", "commentId", "delItemByLocalId", "localCommentId", "filterComment", "", "get", "index", "getData", "getPositionToInsertLevel2Comment", "rootCommentId", "getSize", "hasLevel2Item", "root", "hasLevel2ItemAfter", "level2Comment", "hasLevel2ItemBefore", "onAttach", "Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache$Extra;", "feedId", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "refCommentId", "useCache", "commentScene", "onDetach", "pos", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "upContinue", "downContinue", "hasExpand", "sameComment", "comment1", "comment2", "sameParent", "updateItem", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "Companion", "plugin-finder_release"})
public final class h
{
  public static final boolean xGm = false;
  public static final a xGn;
  public final String TAG;
  public final ArrayList<s> data;
  public long xGj;
  public long xGk;
  public t xGl;
  
  static
  {
    AppMethodBeat.i(166031);
    xGn = new a((byte)0);
    AppMethodBeat.o(166031);
  }
  
  public h()
  {
    AppMethodBeat.i(166030);
    this.TAG = "Finder.FinderCommentLoader";
    this.data = new ArrayList();
    AppMethodBeat.o(166030);
  }
  
  private final void a(t paramt)
  {
    AppMethodBeat.i(226959);
    this.xGl = paramt;
    this.data.add(paramt);
    AppMethodBeat.o(226959);
  }
  
  public static boolean a(s params1, s params2)
  {
    AppMethodBeat.i(178290);
    p.k(params1, "comment1");
    p.k(params2, "comment2");
    if ((params1.zAt.field_actionInfo.xbP != 0L) && (params1.zAt.field_actionInfo.xbP == params2.zAt.field_actionInfo.xbP))
    {
      AppMethodBeat.o(178290);
      return true;
    }
    AppMethodBeat.o(178290);
    return false;
  }
  
  public static boolean b(s params1, s params2)
  {
    AppMethodBeat.i(178291);
    p.k(params1, "comment1");
    p.k(params2, "comment2");
    if (params1.mf() == params2.mf())
    {
      AppMethodBeat.o(178291);
      return true;
    }
    AppMethodBeat.o(178291);
    return false;
  }
  
  public final void KW(long paramLong)
  {
    AppMethodBeat.i(166029);
    Object localObject2 = (Iterable)this.data;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label92:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (((s)localObject3).zAt.field_localCommentId == paramLong) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label92;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject1 = (List)localObject1;
    this.data.removeAll((Collection)localObject1);
    AppMethodBeat.o(166029);
  }
  
  public final s ME(int paramInt)
  {
    AppMethodBeat.i(166026);
    Object localObject = this.data.get(paramInt);
    p.j(localObject, "data[index]");
    localObject = (s)localObject;
    AppMethodBeat.o(166026);
    return localObject;
  }
  
  public final o<f.b, Boolean> a(long paramLong1, FinderItem paramFinderItem, long paramLong2, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(226978);
    p.k(paramFinderItem, "feedObj");
    this.xGj = paramLong1;
    this.xGk = paramLong2;
    if (this.data.size() > 0) {
      this.data.clear();
    }
    Object localObject1;
    Object localObject3;
    Object localObject2;
    label136:
    label162:
    int j;
    if (aj.a(aj.AGc, 0, paramInt, 1))
    {
      localObject1 = aj.AGc;
      p.k(paramFinderItem, "item");
      String str2 = aj.hu(paramFinderItem.getLocation().city, paramFinderItem.getLocation().poiName);
      SpannableString localSpannableString = paramFinderItem.getDescriptionFullSpan();
      String str1 = paramFinderItem.getExtReading().title;
      localObject3 = paramFinderItem.getTopicList();
      localObject1 = paramFinderItem.getFeedObject().objectDesc;
      if (localObject1 == null) {
        break label393;
      }
      localObject1 = ((FinderObjectDesc)localObject1).event;
      if (localObject1 == null) {
        break label399;
      }
      localObject2 = ((bfv)localObject1).eventName;
      if ((!Util.isNullOrNil((String)localObject2)) && ((localObject1 == null) || (((bfv)localObject1).xdR != 0L))) {
        break label405;
      }
      i = 1;
      localObject1 = (CharSequence)str2;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label411;
      }
      j = 1;
      label187:
      if (j == 0) {
        break label429;
      }
      localObject1 = (CharSequence)localSpannableString;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label417;
      }
      j = 1;
      label217:
      if (j == 0) {
        break label429;
      }
      localObject1 = (CharSequence)str1;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label423;
      }
      j = 1;
      label247:
      if ((j == 0) || (!((List)localObject3).isEmpty()) || (i == 0)) {
        break label429;
      }
    }
    boolean bool;
    label393:
    label399:
    label405:
    label411:
    label417:
    label423:
    label429:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        a(new t(paramFinderItem));
      }
      paramFinderItem = null;
      bool = false;
      if (!paramBoolean) {
        break label627;
      }
      paramFinderItem = f.Anc.Y(paramLong1, paramLong2);
      paramBoolean = bool;
      if (paramFinderItem == null) {
        break label491;
      }
      localObject1 = this.data;
      localObject3 = (Iterable)paramFinderItem;
      localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(new s((am)((Iterator)localObject3).next()));
      }
      localObject1 = null;
      break;
      localObject2 = null;
      break label136;
      i = 0;
      break label162;
      j = 0;
      break label187;
      j = 0;
      break label217;
      j = 0;
      break label247;
    }
    ((ArrayList)localObject1).addAll((Collection)localObject2);
    Log.i(this.TAG, "onAttach hit datacache, commentScene=" + paramInt + ' ' + paramFinderItem.size());
    paramBoolean = true;
    label491:
    paramFinderItem = f.Anc.Z(paramLong1, paramLong2);
    for (;;)
    {
      if (paramFinderItem != null) {}
      for (paramInt = paramFinderItem.pos; paramInt >= 0; paramInt = -1)
      {
        if (paramFinderItem == null) {
          p.iCn();
        }
        paramFinderItem = new o(paramFinderItem, Boolean.valueOf(paramBoolean));
        AppMethodBeat.o(226978);
        return paramFinderItem;
      }
      bool = true;
      if (paramLong2 == 0L) {
        bool = false;
      }
      Log.i(this.TAG, "miss cache, upContinue:" + bool + ", downContinue:true");
      paramFinderItem = new o(new f.b(0, null, bool, true, false), Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(226978);
      return paramFinderItem;
      label627:
      paramBoolean = false;
    }
  }
  
  public final void a(List<? extends s> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    AppMethodBeat.i(166028);
    p.k(paramList, "itemList");
    List localList = ee(paramList);
    if (localList.size() > 1) {
      j.a(localList, (Comparator)new b());
    }
    int j = paramList.size();
    int k = localList.size();
    Log.i(this.TAG, "reduce size: " + (j - k) + ", data size: " + this.data.size());
    if (paramBoolean1)
    {
      paramList = this.data;
      if (this.xGl == null) {
        i = 0;
      }
      paramList.addAll(i, (Collection)localList);
      AppMethodBeat.o(166028);
      return;
    }
    if (paramBoolean2) {
      this.data.addAll(this.data.size(), (Collection)localList);
    }
    AppMethodBeat.o(166028);
  }
  
  public final int b(s params)
  {
    int k = 0;
    AppMethodBeat.i(178286);
    p.k(params, "item");
    Log.i(this.TAG, "addItem " + params.mf() + ", sort:true");
    Iterator localIterator;
    int j;
    if (params.zAt.dYY().commentId == 0L)
    {
      localIterator = ((List)this.data).iterator();
      i = 0;
      if (localIterator.hasNext()) {
        if (((s)localIterator.next()).zAt.field_localCommentId == params.zAt.field_localCommentId)
        {
          j = 1;
          label118:
          if (j == 0) {
            break label149;
          }
        }
      }
    }
    for (;;)
    {
      if (i < 0) {
        break label246;
      }
      this.data.set(i, params);
      AppMethodBeat.o(178286);
      return i;
      j = 0;
      break label118;
      label149:
      i += 1;
      break;
      i = -1;
      continue;
      localIterator = ((List)this.data).iterator();
      i = 0;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label241;
        }
        if (((s)localIterator.next()).zAt.dYY().commentId == params.zAt.dYY().commentId) {}
        for (j = 1;; j = 0)
        {
          if (j == 0) {
            break label234;
          }
          break;
        }
        label234:
        i += 1;
      }
      label241:
      i = -1;
    }
    label246:
    if (params.zAt.field_actionInfo.xbP == 0L)
    {
      this.data.size();
      if ((params.zAt.field_state == -1) || (params.zAt.dYY().displayid == 0L))
      {
        if (this.xGl == null) {}
        for (i = k;; i = 1)
        {
          this.data.add(i, params);
          AppMethodBeat.o(178286);
          return i;
        }
      }
      localIterator = ((List)this.data).iterator();
      i = 0;
      if (localIterator.hasNext()) {
        if (((s)localIterator.next()).zAt.dYY().displayid <= params.zAt.dYY().displayid)
        {
          j = 1;
          if (j == 0) {
            break label416;
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
        break label388;
        i += 1;
        break label343;
      }
    }
    label343:
    int i = t(params.zAt.field_actionInfo.xbP, true);
    label388:
    label416:
    this.data.add(i, params);
    AppMethodBeat.o(178286);
    return i;
  }
  
  public final boolean c(s params)
  {
    AppMethodBeat.i(178289);
    p.k(params, "level2Comment");
    Iterator localIterator = ((Iterable)this.data).iterator();
    int i = 0;
    int j = -1;
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        j.iBO();
      }
      localObject = (s)localObject;
      if (b((s)localObject, params))
      {
        Log.d(this.TAG, "hasLevel2ItemAfter cur:" + i + ", before:" + j);
        if (j < 0) {}
        while (i <= j)
        {
          AppMethodBeat.o(178289);
          return false;
        }
        AppMethodBeat.o(178289);
        return true;
      }
      if (!a((s)localObject, params)) {
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
  
  public final List<s> ee(List<? extends s> paramList)
  {
    AppMethodBeat.i(178287);
    List localList = (List)new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      s locals = (s)paramList.next();
      Object localObject = (List)this.data;
      int i = 0;
      localObject = ((List)localObject).iterator();
      label68:
      int j;
      label114:
      label120:
      int k;
      if (((Iterator)localObject).hasNext()) {
        if (((s)((Iterator)localObject).next()).zAt.dYY().commentId == locals.zAt.dYY().commentId)
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
          if (((s)((Iterator)localObject).next()).zAt.dYY().commentId != locals.zAt.dYY().commentId) {
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
        this.data.set(j, locals);
        Log.i(this.TAG, "filter1:" + locals.zAt.dYY().commentId + ", " + locals.zAt.dZd());
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
        Log.i(this.TAG, "filter2:" + locals.zAt.dYY().commentId);
      } else {
        localList.add(locals);
      }
    }
    AppMethodBeat.o(178287);
    return localList;
  }
  
  public final void ow(boolean paramBoolean)
  {
    AppMethodBeat.i(227015);
    this.data.clear();
    if (!paramBoolean)
    {
      t localt = this.xGl;
      if (localt != null)
      {
        a(localt);
        AppMethodBeat.o(227015);
        return;
      }
    }
    AppMethodBeat.o(227015);
  }
  
  public final int t(long paramLong, boolean paramBoolean)
  {
    int k = -1;
    AppMethodBeat.i(178288);
    Object localObject = ((List)this.data).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject).hasNext()) {
      if (((s)((Iterator)localObject).next()).zAt.dYY().commentId == paramLong)
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
        if (((s)((ListIterator)localObject).previous()).zAt.field_actionInfo.xbP != paramLong) {
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentLoader$Companion;", "", "()V", "debugDisable", "", "clearCache", "", "feedId", "", "putCache", "commentId", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lkotlin/collections/ArrayList;", "plugin-finder_release"})
  public static final class a
  {
    public static void a(long paramLong1, long paramLong2, ArrayList<s> paramArrayList)
    {
      AppMethodBeat.i(166023);
      p.k(paramArrayList, "data");
      if (h.dun())
      {
        AppMethodBeat.o(166023);
        return;
      }
      f localf = f.Anc;
      Object localObject = (Iterable)paramArrayList;
      paramArrayList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramArrayList.add(((s)((Iterator)localObject).next()).zAt);
      }
      localf.a(paramLong1, paramLong2, (List)paramArrayList);
      AppMethodBeat.o(166023);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class b<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(166024);
      int i = a.a((Comparable)Long.valueOf(((s)paramT2).zAt.dYY().displayid), (Comparable)Long.valueOf(((s)paramT1).zAt.dYY().displayid));
      AppMethodBeat.o(166024);
      return i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class c<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(178285);
      int i = a.a((Comparable)Long.valueOf(((s)paramT2).zAt.dYY().displayid), (Comparable)Long.valueOf(((s)paramT1).zAt.dYY().displayid));
      AppMethodBeat.o(178285);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.h
 * JD-Core Version:    0.7.0.1
 */