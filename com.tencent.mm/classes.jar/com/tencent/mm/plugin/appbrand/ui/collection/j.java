package com.tencent.mm.plugin.appbrand.ui.collection;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;", "(Ljava/util/ArrayList;Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionVerticalListViewHolder$IEnterWxaListener;)V", "getDataList", "()Ljava/util/ArrayList;", "mListener", "cloneList", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "onBindViewHolder", "", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "replaceList", "list", "", "plugin-appbrand-integration_release"})
final class j
  extends RecyclerView.a<l>
{
  final ArrayList<LocalUsageInfo> iRT;
  private final l.a iSe;
  
  public j(ArrayList<LocalUsageInfo> paramArrayList, l.a parama)
  {
    AppMethodBeat.i(135113);
    this.iRT = paramArrayList;
    this.iSe = parama;
    AppMethodBeat.o(135113);
  }
  
  private void a(l paraml, int paramInt)
  {
    AppMethodBeat.i(135109);
    a.f.b.j.q(paraml, "holder");
    Object localObject = this.iRT.get(paramInt);
    a.f.b.j.p(localObject, "dataList[position]");
    paraml.f((LocalUsageInfo)localObject);
    AppMethodBeat.o(135109);
  }
  
  public final void aL(List<? extends LocalUsageInfo> paramList)
  {
    AppMethodBeat.i(135106);
    a.f.b.j.q(paramList, "list");
    synchronized (this.iRT)
    {
      this.iRT.clear();
      this.iRT.addAll((Collection)paramList);
      AppMethodBeat.o(135106);
      return;
    }
  }
  
  public final ArrayList<LocalUsageInfo> aMZ()
  {
    AppMethodBeat.i(135105);
    synchronized (this.iRT)
    {
      ArrayList localArrayList2 = new ArrayList(this.iRT.size());
      localArrayList2.addAll((Collection)this.iRT);
      AppMethodBeat.o(135105);
      return localArrayList2;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(135107);
    int i = this.iRT.size();
    AppMethodBeat.o(135107);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(135112);
    LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)this.iRT.get(paramInt);
    long l = (localLocalUsageInfo.username + localLocalUsageInfo.hcr).hashCode();
    AppMethodBeat.o(135112);
    return l;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.j
 * JD-Core Version:    0.7.0.1
 */