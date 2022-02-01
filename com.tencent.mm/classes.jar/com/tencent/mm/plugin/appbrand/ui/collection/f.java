package com.tencent.mm.plugin.appbrand.ui.collection;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;)V", "getDataList", "()Ljava/util/ArrayList;", "mListener", "cloneList", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "onBindViewHolder", "", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "replaceList", "list", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class f
  extends RecyclerView.a<h>
{
  final ArrayList<LocalUsageInfo> pUj;
  private final h.a uit;
  
  public f(ArrayList<LocalUsageInfo> paramArrayList, h.a parama)
  {
    AppMethodBeat.i(51278);
    this.pUj = paramArrayList;
    this.uit = parama;
    AppMethodBeat.o(51278);
  }
  
  private void a(h paramh, int paramInt)
  {
    AppMethodBeat.i(51274);
    s.u(paramh, "holder");
    Object localObject = this.pUj.get(paramInt);
    s.s(localObject, "dataList[position]");
    paramh.f((LocalUsageInfo)localObject);
    AppMethodBeat.o(51274);
  }
  
  public final ArrayList<LocalUsageInfo> cMm()
  {
    AppMethodBeat.i(51270);
    synchronized (this.pUj)
    {
      ArrayList localArrayList2 = new ArrayList(this.pUj.size());
      localArrayList2.addAll((Collection)this.pUj);
      AppMethodBeat.o(51270);
      return localArrayList2;
    }
  }
  
  public final void dG(List<? extends LocalUsageInfo> paramList)
  {
    AppMethodBeat.i(51271);
    s.u(paramList, "list");
    synchronized (this.pUj)
    {
      this.pUj.clear();
      this.pUj.addAll((Collection)paramList);
      AppMethodBeat.o(51271);
      return;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(51272);
    int i = this.pUj.size();
    AppMethodBeat.o(51272);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(51277);
    LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)this.pUj.get(paramInt);
    long l = s.X(localLocalUsageInfo.username, Integer.valueOf(localLocalUsageInfo.euz)).hashCode();
    AppMethodBeat.o(51277);
    return l;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.f
 * JD-Core Version:    0.7.0.1
 */