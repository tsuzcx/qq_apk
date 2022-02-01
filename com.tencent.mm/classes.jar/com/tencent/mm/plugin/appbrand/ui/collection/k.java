package com.tencent.mm.plugin.appbrand.ui.collection;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;)V", "getDataList", "()Ljava/util/ArrayList;", "mListener", "cloneList", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "onBindViewHolder", "", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "replaceList", "list", "", "plugin-appbrand-integration_release"})
final class k
  extends RecyclerView.a<m>
{
  final ArrayList<LocalUsageInfo> jhZ;
  private final m.a mOd;
  
  public k(ArrayList<LocalUsageInfo> paramArrayList, m.a parama)
  {
    AppMethodBeat.i(51278);
    this.jhZ = paramArrayList;
    this.mOd = parama;
    AppMethodBeat.o(51278);
  }
  
  private void a(m paramm, int paramInt)
  {
    AppMethodBeat.i(51274);
    p.h(paramm, "holder");
    Object localObject = this.jhZ.get(paramInt);
    p.g(localObject, "dataList[position]");
    paramm.g((LocalUsageInfo)localObject);
    AppMethodBeat.o(51274);
  }
  
  public final ArrayList<LocalUsageInfo> bBm()
  {
    AppMethodBeat.i(51270);
    synchronized (this.jhZ)
    {
      ArrayList localArrayList2 = new ArrayList(this.jhZ.size());
      localArrayList2.addAll((Collection)this.jhZ);
      AppMethodBeat.o(51270);
      return localArrayList2;
    }
  }
  
  public final void bG(List<? extends LocalUsageInfo> paramList)
  {
    AppMethodBeat.i(51271);
    p.h(paramList, "list");
    synchronized (this.jhZ)
    {
      this.jhZ.clear();
      this.jhZ.addAll((Collection)paramList);
      AppMethodBeat.o(51271);
      return;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(51272);
    int i = this.jhZ.size();
    AppMethodBeat.o(51272);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(51277);
    LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)this.jhZ.get(paramInt);
    long l = (localLocalUsageInfo.username + localLocalUsageInfo.hSZ).hashCode();
    AppMethodBeat.o(51277);
    return l;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.k
 * JD-Core Version:    0.7.0.1
 */