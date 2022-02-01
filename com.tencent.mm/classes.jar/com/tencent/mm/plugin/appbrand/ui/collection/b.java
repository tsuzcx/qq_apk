package com.tencent.mm.plugin.appbrand.ui.collection;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionViewHolder;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "(Ljava/util/ArrayList;)V", "getDataList", "()Ljava/util/ArrayList;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-appbrand-integration_release"})
public final class b
  extends RecyclerView.a<n>
{
  final ArrayList<LocalUsageInfo> jhZ;
  
  public b(ArrayList<LocalUsageInfo> paramArrayList)
  {
    AppMethodBeat.i(51241);
    this.jhZ = paramArrayList;
    AppMethodBeat.o(51241);
  }
  
  private void a(n paramn, int paramInt)
  {
    AppMethodBeat.i(51238);
    p.h(paramn, "holder");
    Object localObject = this.jhZ.get(paramInt);
    p.g(localObject, "dataList[position]");
    paramn.g((LocalUsageInfo)localObject);
    AppMethodBeat.o(51238);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(51236);
    int i = this.jhZ.size();
    AppMethodBeat.o(51236);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.b
 * JD-Core Version:    0.7.0.1
 */