package com.tencent.mm.plugin.finder.ui.at;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmlist.MMSearchLiveList;
import com.tencent.mm.plugin.mvvmlist.a.b;
import com.tencent.mm.plugin.mvvmlist.a.c;
import com.tencent.mm.plugin.mvvmlist.a.d;
import com.tencent.mm.plugin.mvvmlist.a.f;
import com.tencent.mm.plugin.mvvmlist.e;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveList;", "Lcom/tencent/mm/plugin/mvvmlist/MMSearchLiveList;", "Lcom/tencent/mm/plugin/finder/ui/at/FinderAtSomeoneLiveItem;", "", "dataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "searchDataSource", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseSearchDataSource;", "config", "Lcom/tencent/mm/plugin/mvvmlist/MvvmListConfig;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Lcom/tencent/mm/plugin/mvvmlist/datasource/IDataSource;Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseSearchDataSource;Lcom/tencent/mm/plugin/mvvmlist/MvvmListConfig;Landroidx/lifecycle/LifecycleOwner;)V", "showHeadList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getShowHeadList", "()Ljava/util/ArrayList;", "getLogTag", "handleSnapshotList", "", "snapshotList", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderAtSomeoneLiveList
  extends MMSearchLiveList<g, String>
{
  final ArrayList<String> FWy;
  
  public FinderAtSomeoneLiveList(f<g, c<g>, d<g>> paramf, b<g, String> paramb, e parame, q paramq)
  {
    super(paramf, paramb, parame, paramq);
    AppMethodBeat.i(347881);
    this.FWy = new ArrayList();
    AppMethodBeat.o(347881);
  }
  
  public final String getLogTag()
  {
    return "MicroMsg.Mvvm.MvvmList";
  }
  
  public final List<g> hF(List<g> paramList)
  {
    AppMethodBeat.i(347891);
    s.u(paramList, "snapshotList");
    p.N(paramList);
    this.FWy.clear();
    this.FWy.add("🔍");
    Object localObject = "";
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      if (localg.type == 3)
      {
        if (!s.p(localg.FWw, localObject))
        {
          localg.FWu = true;
          localObject = localg.FWw;
          this.FWy.add(localObject);
        }
        else
        {
          localg.FWu = false;
        }
      }
      else if (localg.type == 0)
      {
        if ((!Util.isNullOrNil(localg.FWw)) && (!s.p(localg.FWw, localObject)))
        {
          localg.FWu = true;
          localObject = localg.FWw;
        }
        else
        {
          localg.FWu = false;
        }
      }
      else {
        localg.FWu = false;
      }
    }
    localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add((g)((g)((Iterator)localObject).next()).gsx());
    }
    paramList = (List)paramList;
    AppMethodBeat.o(347891);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.at.FinderAtSomeoneLiveList
 * JD-Core Version:    0.7.0.1
 */