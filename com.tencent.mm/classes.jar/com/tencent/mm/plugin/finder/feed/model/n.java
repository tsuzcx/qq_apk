package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.cgi.ae;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.b.a;
import d.g.b.k;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/ProfileData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/model/ProfileInit;", "Lcom/tencent/mm/plugin/finder/feed/model/ProfileRequest;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "map", "", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "alive", "", "call", "request", "callback", "callInitData", "", "init", "dead", "mergeLocalData", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "nowList", "username", "", "start", "", "end", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class n
  extends f<o, p, BaseFinderFeed>
  implements com.tencent.mm.al.g
{
  private final Map<ae, e<BaseFinderFeed>> map;
  
  public n(dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(198320);
    this.map = ((Map)new LinkedHashMap());
    AppMethodBeat.o(198320);
  }
  
  private static List<FinderItem> i(List<? extends FinderItem> paramList, String paramString)
  {
    AppMethodBeat.i(166083);
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; (i != 0) || ((k.g(paramString, u.aqO()) ^ true)); i = 0)
    {
      AppMethodBeat.o(166083);
      return paramList;
    }
    if (f.DEBUG)
    {
      localObject1 = i.qTa;
      i.l(paramList, "nowList");
    }
    ad.i(f.TAG, "mergeLocalData start 0 end 2147483647");
    Object localObject1 = new LinkedList();
    Object localObject2 = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
    paramString = b.a.Zw(paramString);
    ((LinkedList)localObject1).addAll((Collection)paramList);
    localObject2 = (List)localObject1;
    if (((List)localObject2).size() > 1) {
      j.a((List)localObject2, (Comparator)new a());
    }
    c.a(paramString, (d.g.a.b)new b(paramList));
    ((LinkedList)localObject1).addAll(0, (Collection)paramString);
    if (f.DEBUG)
    {
      paramList = i.qTa;
      i.l((List)localObject1, "newList");
    }
    ad.i(f.TAG, "dblist size:" + paramString.size());
    paramList = ((Iterable)paramString).iterator();
    while (paramList.hasNext())
    {
      paramString = (FinderItem)paramList.next();
      ad.i(f.TAG, "dblist item, localId:" + paramString.getLocalId() + ", id:" + paramString.getId());
    }
    paramList = (List)localObject1;
    AppMethodBeat.o(166083);
    return paramList;
  }
  
  public final void alive()
  {
    AppMethodBeat.i(166079);
    com.tencent.mm.kernel.g.aeS().a(3736, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(166079);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(166080);
    com.tencent.mm.kernel.g.aeS().b(3736, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(166080);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(166081);
    e locale = (e)this.map.get(paramn);
    if (locale != null)
    {
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderUserPage");
        AppMethodBeat.o(166081);
        throw paramString;
      }
      ae localae = (ae)paramn;
      this.map.remove(paramn);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {}
      for (boolean bool = localae.qpI;; bool = true)
      {
        Object localObject = localae.qpi;
        paramn = (com.tencent.mm.al.n)localObject;
        if (localObject == null) {
          paramn = (List)new LinkedList();
        }
        localObject = paramn;
        if (localae.pullType == 1) {
          localObject = i(paramn, localae.qpK);
        }
        paramString = new q(paramInt1, paramInt2, paramString);
        localObject = (Iterable)localObject;
        paramn = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          FinderItem localFinderItem = (FinderItem)((Iterator)localObject).next();
          b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
          paramn.add(b.a.h(localFinderItem));
        }
      }
      paramString.setIncrementList((List)paramn);
      paramString.setPullType(localae.pullType);
      paramn = localae.rr.auL();
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageRequest");
        AppMethodBeat.o(166081);
        throw paramString;
      }
      paramString.qyO = ((alt)paramn).wET;
      paramString.setHasMore(bool);
      paramn = localae.rr.auM();
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
        AppMethodBeat.o(166081);
        throw paramString;
      }
      paramString.setLastBuffer(((FinderUserPageResponse)paramn).lastBuffer);
      locale.onFetchDone((IResponse)paramString);
      AppMethodBeat.o(166081);
      return;
    }
    AppMethodBeat.o(166081);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(166076);
      int i = a.a((Comparable)Integer.valueOf(((FinderItem)paramT2).getCreateTime()), (Comparable)Integer.valueOf(((FinderItem)paramT1).getCreateTime()));
      AppMethodBeat.o(166076);
      return i;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "removeIt", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<FinderItem, Boolean>
  {
    b(List paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.n
 * JD-Core Version:    0.7.0.1
 */