package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/LoaderCacheData;", "", "position", "", "feedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(ILjava/util/List;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getFeedList", "()Ljava/util/List;", "getPosition", "()I", "filterFeed", "filterLogic", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "feed", "", "filterFeedImpl", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "toString", "plugin-finder_release"})
public final class i
{
  private final String TAG;
  public final int position;
  public final List<bo> tXV;
  
  public i(int paramInt, List<? extends bo> paramList)
  {
    AppMethodBeat.i(244941);
    this.position = paramInt;
    this.tXV = paramList;
    this.TAG = "Finder.LoaderCacheData";
    AppMethodBeat.o(244941);
  }
  
  private final ArrayList<bo> B(b<? super bo, Boolean> paramb)
  {
    AppMethodBeat.i(244938);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)this.tXV).iterator();
    while (localIterator.hasNext())
    {
      bo localbo = (bo)localIterator.next();
      if (!((Boolean)paramb.invoke(localbo)).booleanValue()) {
        localArrayList.add(localbo);
      }
    }
    AppMethodBeat.o(244938);
    return localArrayList;
  }
  
  public final i C(b<? super bo, Boolean> paramb)
  {
    AppMethodBeat.i(244939);
    p.h(paramb, "filterLogic");
    Log.i(this.TAG, "before filterFeed ".concat(String.valueOf(this)));
    Object localObject = y.vXH;
    localObject = y.n(this.position, this.tXV);
    paramb = B(paramb);
    y localy = y.vXH;
    paramb = new i(y.a((bo)localObject, (List)paramb), (List)paramb);
    Log.i(this.TAG, "after filterFeed ".concat(String.valueOf(paramb)));
    AppMethodBeat.o(244939);
    return paramb;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(244940);
    String str = "position:" + this.position + ",feed size:" + this.tXV.size();
    AppMethodBeat.o(244940);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.i
 * JD-Core Version:    0.7.0.1
 */