package com.tencent.mm.plugin.finder.feed.model;

import android.content.Context;
import android.text.SpannableString;
import androidx.lifecycle.LiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.jumper.i;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.plugin.finder.model.u;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.au;
import com.tencent.mm.plugin.finder.storage.data.f;
import com.tencent.mm.plugin.finder.storage.data.f.b;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.atd;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.b.a;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentLoader;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "curFeedId", "", "curRefCommentId", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lkotlin/collections/ArrayList;", "headerData", "Lcom/tencent/mm/plugin/finder/model/FinderFeedCommentHeaderContent;", "getHeaderData", "()Lcom/tencent/mm/plugin/finder/model/FinderFeedCommentHeaderContent;", "setHeaderData", "(Lcom/tencent/mm/plugin/finder/model/FinderFeedCommentHeaderContent;)V", "addHeaderData", "", "header", "addItem", "", "item", "sort", "", "addItems", "itemList", "", "toHead", "toTail", "addLevel2Items", "Lkotlin/Pair;", "rootComment", "down", "clearData", "isDetached", "delItemById", "commentId", "delItemByLocalId", "localCommentId", "filterComment", "", "get", "index", "getData", "getPositionToInsertLevel2Comment", "rootCommentId", "getSize", "hasLevel2Item", "root", "hasLevel2ItemAfter", "level2Comment", "hasLevel2ItemBefore", "onAttach", "Lcom/tencent/mm/plugin/finder/storage/data/FinderCommentCache$Extra;", "context", "Landroid/content/Context;", "feedId", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "refCommentId", "useCache", "commentScene", "onDetach", "pos", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "upContinue", "downContinue", "hasExpand", "sameComment", "comment1", "comment2", "sameParent", "updateItem", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final a Bfb;
  public static final boolean Bff = false;
  public long Bfc;
  public long Bfd;
  public u Bfe;
  public final String TAG;
  public final ArrayList<t> data;
  
  static
  {
    AppMethodBeat.i(166031);
    Bfb = new a((byte)0);
    AppMethodBeat.o(166031);
  }
  
  public h()
  {
    AppMethodBeat.i(166030);
    this.TAG = "Finder.FinderCommentLoader";
    this.data = new ArrayList();
    AppMethodBeat.o(166030);
  }
  
  public static boolean a(t paramt1, t paramt2)
  {
    AppMethodBeat.i(178290);
    s.u(paramt1, "comment1");
    s.u(paramt2, "comment2");
    if ((paramt1.ECu.field_actionInfo.ABa != 0L) && (paramt1.ECu.field_actionInfo.ABa == paramt2.ECu.field_actionInfo.ABa))
    {
      AppMethodBeat.o(178290);
      return true;
    }
    AppMethodBeat.o(178290);
    return false;
  }
  
  private final void b(u paramu)
  {
    AppMethodBeat.i(365978);
    this.Bfe = paramu;
    this.data.add(paramu);
    AppMethodBeat.o(365978);
  }
  
  public static boolean b(t paramt1, t paramt2)
  {
    AppMethodBeat.i(178291);
    s.u(paramt1, "comment1");
    s.u(paramt2, "comment2");
    if (paramt1.bZA() == paramt2.bZA())
    {
      AppMethodBeat.o(178291);
      return true;
    }
    AppMethodBeat.o(178291);
    return false;
  }
  
  public final t Ob(int paramInt)
  {
    AppMethodBeat.i(166026);
    Object localObject = this.data.get(paramInt);
    s.s(localObject, "data[index]");
    localObject = (t)localObject;
    AppMethodBeat.o(166026);
    return localObject;
  }
  
  public final r<f.b, Boolean> a(Context paramContext, long paramLong1, FinderItem paramFinderItem, long paramLong2, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(366029);
    s.u(paramContext, "context");
    s.u(paramFinderItem, "feedObj");
    this.Bfc = paramLong1;
    this.Bfd = paramLong2;
    if (this.data.size() > 0) {
      this.data.clear();
    }
    Object localObject1 = av.GiL;
    s.u(paramFinderItem, "item");
    s.u(paramContext, "context");
    String str2 = av.cn(paramFinderItem.getLocation().city, paramFinderItem.getLocation().poiName);
    SpannableString localSpannableString = paramFinderItem.getDescriptionFullSpan();
    String str1 = paramFinderItem.getExtReading().title;
    Object localObject2 = paramFinderItem.getTopicList();
    paramContext = paramFinderItem.getFeedObject().objectDesc;
    label131:
    label155:
    label163:
    int j;
    label223:
    int k;
    if (paramContext == null)
    {
      paramContext = null;
      if (paramContext != null) {
        break label459;
      }
      localObject1 = null;
      if (!Util.isNullOrNil((String)localObject1))
      {
        if ((paramContext == null) || (paramContext.ocD != 0L)) {
          break label468;
        }
        i = 1;
        if (i == 0) {
          break label474;
        }
      }
      i = 1;
      paramContext = k.aeZF;
      paramContext = (Set)((i)k.cn(cn.class).q(i.class)).l(paramFinderItem.getFeedObject().id, paramFinderItem.getFeedObject().adFlag, paramInt).getValue();
      if (paramContext != null) {
        break label480;
      }
      paramContext = null;
      if (paramContext != null) {
        break label555;
      }
      j = 1;
      paramContext = (CharSequence)str2;
      if ((paramContext != null) && (paramContext.length() != 0)) {
        break label561;
      }
      k = 1;
      label245:
      if (k == 0) {
        break label579;
      }
      paramContext = (CharSequence)localSpannableString;
      if ((paramContext != null) && (paramContext.length() != 0)) {
        break label567;
      }
      k = 1;
      label272:
      if (k == 0) {
        break label579;
      }
      paramContext = (CharSequence)str1;
      if ((paramContext != null) && (paramContext.length() != 0)) {
        break label573;
      }
      k = 1;
      label299:
      if ((k == 0) || (!((List)localObject2).isEmpty()) || (i == 0) || (j == 0)) {
        break label579;
      }
    }
    boolean bool;
    label531:
    label548:
    label555:
    label561:
    label567:
    label573:
    label579:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        b(new u(paramFinderItem));
      }
      paramContext = null;
      bool = false;
      if (!paramBoolean) {
        break label774;
      }
      paramContext = f.FMT.aw(paramLong1, paramLong2);
      paramBoolean = bool;
      if (paramContext == null) {
        break label641;
      }
      paramFinderItem = this.data;
      localObject2 = (Iterable)paramContext;
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add(new t((au)((Iterator)localObject2).next()));
      }
      paramContext = paramContext.event;
      break;
      label459:
      localObject1 = paramContext.eventName;
      break label131;
      label468:
      i = 0;
      break label155;
      label474:
      i = 0;
      break label163;
      label480:
      localObject1 = ((Iterable)paramContext).iterator();
      label491:
      if (((Iterator)localObject1).hasNext())
      {
        paramContext = ((Iterator)localObject1).next();
        if (((com.tencent.mm.plugin.finder.feed.jumper.h)paramContext).feedId == paramFinderItem.getFeedObject().id)
        {
          j = 1;
          if (j == 0) {
            break label548;
          }
        }
      }
      for (;;)
      {
        paramContext = (com.tencent.mm.plugin.finder.feed.jumper.h)paramContext;
        break;
        j = 0;
        break label531;
        break label491;
        paramContext = null;
      }
      j = 0;
      break label223;
      k = 0;
      break label245;
      k = 0;
      break label272;
      k = 0;
      break label299;
    }
    paramFinderItem.addAll((Collection)localObject1);
    Log.i(this.TAG, "onAttach hit datacache, commentScene=" + paramInt + ' ' + paramContext.size());
    paramBoolean = true;
    label641:
    paramContext = f.FMT.ax(paramLong1, paramLong2);
    for (;;)
    {
      if (paramContext == null) {}
      for (paramInt = -1; paramInt >= 0; paramInt = paramContext.pos)
      {
        s.checkNotNull(paramContext);
        paramContext = new r(paramContext, Boolean.valueOf(paramBoolean));
        AppMethodBeat.o(366029);
        return paramContext;
      }
      bool = true;
      if (paramLong2 == 0L) {
        bool = false;
      }
      Log.i(this.TAG, "miss cache, upContinue:" + bool + ", downContinue:true");
      paramContext = new r(new f.b(0, null, bool, true, false), Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(366029);
      return paramContext;
      label774:
      paramBoolean = false;
    }
  }
  
  public final void a(List<? extends t> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 1;
    AppMethodBeat.i(166028);
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
      AppMethodBeat.o(166028);
      return;
    }
    if (paramBoolean2) {
      this.data.addAll(this.data.size(), (Collection)localList);
    }
    AppMethodBeat.o(166028);
  }
  
  public final int b(t paramt)
  {
    int k = 0;
    AppMethodBeat.i(178286);
    s.u(paramt, "item");
    Log.i(this.TAG, "addItem " + paramt.bZA() + ", sort:true");
    Iterator localIterator;
    int j;
    if (paramt.ECu.eZI().commentId == 0L)
    {
      localIterator = ((List)this.data).iterator();
      i = 0;
      if (localIterator.hasNext()) {
        if (((t)localIterator.next()).ECu.field_localCommentId == paramt.ECu.field_localCommentId)
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
      this.data.set(i, paramt);
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
        if (((t)localIterator.next()).ECu.eZI().commentId == paramt.ECu.eZI().commentId) {}
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
    if (paramt.ECu.field_actionInfo.ABa == 0L)
    {
      this.data.size();
      if ((paramt.ECu.field_state == -1) || (paramt.ECu.eZI().displayid == 0L))
      {
        if (this.Bfe == null) {}
        for (i = k;; i = 1)
        {
          this.data.add(i, paramt);
          AppMethodBeat.o(178286);
          return i;
        }
      }
      localIterator = ((List)this.data).iterator();
      i = 0;
      if (localIterator.hasNext()) {
        if (((t)localIterator.next()).ECu.eZI().displayid <= paramt.ECu.eZI().displayid)
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
    int i = y(paramt.ECu.field_actionInfo.ABa, true);
    label388:
    label416:
    this.data.add(i, paramt);
    AppMethodBeat.o(178286);
    return i;
  }
  
  public final boolean c(t paramt)
  {
    AppMethodBeat.i(178289);
    s.u(paramt, "level2Comment");
    Iterator localIterator = ((Iterable)this.data).iterator();
    int i = 0;
    int j = -1;
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        p.kkW();
      }
      localObject = (t)localObject;
      if (b((t)localObject, paramt))
      {
        Log.d(this.TAG, "hasLevel2ItemAfter cur:" + i + ", before:" + j);
        if (j >= 0)
        {
          if (j < i)
          {
            AppMethodBeat.o(178289);
            return true;
          }
          AppMethodBeat.o(178289);
          return false;
        }
        AppMethodBeat.o(178289);
        return false;
      }
      if (!a((t)localObject, paramt)) {
        break label166;
      }
      j = i;
    }
    label166:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(178289);
      return false;
    }
  }
  
  public final List<t> gd(List<? extends t> paramList)
  {
    AppMethodBeat.i(178287);
    List localList = (List)new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      t localt = (t)paramList.next();
      Object localObject = (List)this.data;
      int i = 0;
      localObject = ((List)localObject).iterator();
      label68:
      int j;
      label114:
      label120:
      int k;
      if (((Iterator)localObject).hasNext()) {
        if (((t)((Iterator)localObject).next()).ECu.eZI().commentId == localt.ECu.eZI().commentId)
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
          if (((t)((Iterator)localObject).next()).ECu.eZI().commentId != localt.ECu.eZI().commentId) {
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
        this.data.set(j, localt);
        Log.i(this.TAG, "filter1:" + localt.ECu.eZI().commentId + ", " + localt.ECu.eZM());
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
        Log.i(this.TAG, s.X("filter2:", Long.valueOf(localt.ECu.eZI().commentId)));
      } else {
        localList.add(localt);
      }
    }
    AppMethodBeat.o(178287);
    return localList;
  }
  
  public final void nC(long paramLong)
  {
    AppMethodBeat.i(166029);
    Object localObject2 = (Iterable)this.data;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label93:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (((t)localObject3).ECu.field_localCommentId == paramLong) {}
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
  
  public final void qb(boolean paramBoolean)
  {
    AppMethodBeat.i(366075);
    this.data.clear();
    if (!paramBoolean)
    {
      u localu = this.Bfe;
      if (localu != null) {
        b(localu);
      }
    }
    AppMethodBeat.o(366075);
  }
  
  public final int y(long paramLong, boolean paramBoolean)
  {
    int k = -1;
    AppMethodBeat.i(178288);
    Object localObject = ((List)this.data).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject).hasNext()) {
      if (((t)((Iterator)localObject).next()).ECu.eZI().commentId == paramLong)
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
        if (((t)((ListIterator)localObject).previous()).ECu.field_actionInfo.ABa != paramLong) {
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
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentLoader$Companion;", "", "()V", "debugDisable", "", "clearCache", "", "feedId", "", "putCache", "commentId", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "Lkotlin/collections/ArrayList;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(long paramLong1, long paramLong2, ArrayList<t> paramArrayList)
    {
      AppMethodBeat.i(166023);
      s.u(paramArrayList, "data");
      if (h.edM())
      {
        AppMethodBeat.o(166023);
        return;
      }
      f localf = f.FMT;
      Object localObject = (Iterable)paramArrayList;
      paramArrayList = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramArrayList.add(((t)((Iterator)localObject).next()).ECu);
      }
      localf.a(paramLong1, paramLong2, (List)paramArrayList);
      AppMethodBeat.o(166023);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
  public static final class b<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(166024);
      int i = a.b((Comparable)Long.valueOf(((t)paramT2).ECu.eZI().displayid), (Comparable)Long.valueOf(((t)paramT1).ECu.eZI().displayid));
      AppMethodBeat.o(166024);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
  public static final class c<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(178285);
      int i = a.b((Comparable)Long.valueOf(((t)paramT2).ECu.eZI().displayid), (Comparable)Long.valueOf(((t)paramT1).ECu.eZI().displayid));
      AppMethodBeat.o(178285);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.h
 * JD-Core Version:    0.7.0.1
 */