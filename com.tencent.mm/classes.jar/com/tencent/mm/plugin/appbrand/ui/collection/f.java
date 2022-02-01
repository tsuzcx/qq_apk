package com.tencent.mm.plugin.appbrand.ui.collection;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;)V", "getDataList", "()Ljava/util/ArrayList;", "mListener", "cloneList", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "onBindViewHolder", "", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "replaceList", "list", "", "plugin-appbrand-integration_release"})
final class f
  extends RecyclerView.a<h>
{
  final ArrayList<LocalUsageInfo> mXB;
  private final h.a rcJ;
  
  public f(ArrayList<LocalUsageInfo> paramArrayList, h.a parama)
  {
    AppMethodBeat.i(51278);
    this.mXB = paramArrayList;
    this.rcJ = parama;
    AppMethodBeat.o(51278);
  }
  
  private void a(h paramh, int paramInt)
  {
    AppMethodBeat.i(51274);
    p.k(paramh, "holder");
    Object localObject = this.mXB.get(paramInt);
    p.j(localObject, "dataList[position]");
    paramh.f((LocalUsageInfo)localObject);
    AppMethodBeat.o(51274);
  }
  
  public final void bR(List<? extends LocalUsageInfo> paramList)
  {
    AppMethodBeat.i(51271);
    p.k(paramList, "list");
    synchronized (this.mXB)
    {
      this.mXB.clear();
      this.mXB.addAll((Collection)paramList);
      AppMethodBeat.o(51271);
      return;
    }
  }
  
  public final ArrayList<LocalUsageInfo> ckX()
  {
    AppMethodBeat.i(51270);
    synchronized (this.mXB)
    {
      ArrayList localArrayList2 = new ArrayList(this.mXB.size());
      localArrayList2.addAll((Collection)this.mXB);
      AppMethodBeat.o(51270);
      return localArrayList2;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(51272);
    int i = this.mXB.size();
    AppMethodBeat.o(51272);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(51277);
    LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)this.mXB.get(paramInt);
    long l = (localLocalUsageInfo.username + localLocalUsageInfo.cBU).hashCode();
    AppMethodBeat.o(51277);
    return l;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.f
 * JD-Core Version:    0.7.0.1
 */