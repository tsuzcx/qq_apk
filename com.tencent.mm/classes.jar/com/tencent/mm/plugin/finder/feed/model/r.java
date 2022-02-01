package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/LoaderCacheData;", "", "position", "", "feedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(ILjava/util/List;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getFeedList", "()Ljava/util/List;", "getPosition", "()I", "filterFeed", "filterLogic", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "feed", "", "filterFeedImpl", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "toString", "plugin-finder_release"})
public final class r
{
  private final String TAG;
  public final int position;
  public final List<bu> xJU;
  
  public r(int paramInt, List<? extends bu> paramList)
  {
    AppMethodBeat.i(252367);
    this.position = paramInt;
    this.xJU = paramList;
    this.TAG = "Finder.LoaderCacheData";
    AppMethodBeat.o(252367);
  }
  
  private final ArrayList<bu> G(b<? super bu, Boolean> paramb)
  {
    AppMethodBeat.i(252364);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)this.xJU).iterator();
    while (localIterator.hasNext())
    {
      bu localbu = (bu)localIterator.next();
      if (!((Boolean)paramb.invoke(localbu)).booleanValue()) {
        localArrayList.add(localbu);
      }
    }
    AppMethodBeat.o(252364);
    return localArrayList;
  }
  
  public final r H(b<? super bu, Boolean> paramb)
  {
    AppMethodBeat.i(252365);
    p.k(paramb, "filterLogic");
    Log.i(this.TAG, "before filterFeed ".concat(String.valueOf(this)));
    Object localObject = aj.AGc;
    localObject = aj.q(this.position, this.xJU);
    paramb = G(paramb);
    aj localaj = aj.AGc;
    paramb = new r(aj.a((bu)localObject, (List)paramb), (List)paramb);
    Log.i(this.TAG, "after filterFeed ".concat(String.valueOf(paramb)));
    AppMethodBeat.o(252365);
    return paramb;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(252366);
    String str = "position:" + this.position + ",feed size:" + this.xJU.size();
    AppMethodBeat.o(252366);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.r
 * JD-Core Version:    0.7.0.1
 */