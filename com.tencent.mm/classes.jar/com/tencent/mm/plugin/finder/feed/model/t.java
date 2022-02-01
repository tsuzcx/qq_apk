package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/LoaderCacheData;", "", "position", "", "feedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(ILjava/util/List;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getFeedList", "()Ljava/util/List;", "getPosition", "()I", "filterFeed", "filterLogic", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "feed", "", "filterFeedImpl", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
{
  public final List<cc> BjH;
  public final String TAG;
  public final int position;
  
  public t(int paramInt, List<? extends cc> paramList)
  {
    AppMethodBeat.i(366421);
    this.position = paramInt;
    this.BjH = paramList;
    this.TAG = "Finder.LoaderCacheData";
    AppMethodBeat.o(366421);
  }
  
  public final ArrayList<cc> ak(b<? super cc, Boolean> paramb)
  {
    AppMethodBeat.i(366429);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)this.BjH).iterator();
    while (localIterator.hasNext())
    {
      cc localcc = (cc)localIterator.next();
      if (!((Boolean)paramb.invoke(localcc)).booleanValue()) {
        localArrayList.add(localcc);
      }
    }
    AppMethodBeat.o(366429);
    return localArrayList;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(366435);
    String str = "position:" + this.position + ",feed size:" + this.BjH.size();
    AppMethodBeat.o(366435);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.t
 * JD-Core Version:    0.7.0.1
 */