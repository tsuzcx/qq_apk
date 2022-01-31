package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionViewHolder;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "(Ljava/util/ArrayList;)V", "getDataList", "()Ljava/util/ArrayList;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-appbrand-integration_release"})
public final class a
  extends RecyclerView.a<m>
{
  final ArrayList<LocalUsageInfo> iRT;
  
  public a(ArrayList<LocalUsageInfo> paramArrayList)
  {
    AppMethodBeat.i(135077);
    this.iRT = paramArrayList;
    AppMethodBeat.o(135077);
  }
  
  private void a(m paramm, int paramInt)
  {
    AppMethodBeat.i(135074);
    j.q(paramm, "holder");
    Object localObject = this.iRT.get(paramInt);
    j.p(localObject, "dataList[position]");
    paramm.f((LocalUsageInfo)localObject);
    AppMethodBeat.o(135074);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(135072);
    int i = this.iRT.size();
    AppMethodBeat.o(135072);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.a
 * JD-Core Version:    0.7.0.1
 */