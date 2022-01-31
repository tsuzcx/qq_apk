package com.tencent.mm.plugin.appbrand.ui.collection;

import a.f.b.j;
import a.v;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ArrayAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import java.util.ArrayList;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragSortAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "context", "Landroid/content/Context;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getDataList", "()Ljava/util/ArrayList;", "mList", "Lcom/tencent/mm/ui/widget/sortlist/DragSortListView;", "attachListView", "", "list", "getItemId", "", "position", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "onBindViewHolder", "holder", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionSortViewHolder;", "item", "onCreateViewHolder", "inflater", "Landroid/view/LayoutInflater;", "remove", "index", "plugin-appbrand-integration_release"})
public final class c
  extends ArrayAdapter<LocalUsageInfo>
{
  DragSortListView iRF;
  final ArrayList<LocalUsageInfo> iRT;
  
  public c(Context paramContext, ArrayList<LocalUsageInfo> paramArrayList)
  {
    super(paramContext, d.aMY(), (List)paramArrayList);
    AppMethodBeat.i(135092);
    this.iRT = paramArrayList;
    AppMethodBeat.o(135092);
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(135090);
    LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)getItem(paramInt);
    long l = (localLocalUsageInfo.username + localLocalUsageInfo.hcr).hashCode();
    AppMethodBeat.o(135090);
    return l;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(135091);
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(getContext());
      j.p(paramView, "LayoutInflater.from(context)");
      paramView = paramView.inflate(d.aMY(), paramViewGroup, false);
      paramViewGroup = ((ViewStub)paramView.findViewById(2131821174)).inflate();
      if (paramViewGroup != null) {
        paramViewGroup.setBackground(null);
      }
      j.p(paramView, "view");
      paramView = new i(paramView);
      paramViewGroup = getItem(paramInt);
      j.p(paramViewGroup, "getItem(position)");
      paramView.f((LocalUsageInfo)paramViewGroup);
      paramViewGroup = paramView.aku;
      j.p(paramViewGroup, "holder.itemView");
      paramViewGroup.setClickable(false);
      if (paramInt != getCount() - 1) {
        break label224;
      }
    }
    label224:
    for (int i = 8;; i = 0)
    {
      paramView.iSi.setVisibility(i);
      paramViewGroup = paramView.iSd;
      j.p(paramViewGroup, "rightExtraBottomLine");
      paramViewGroup.setVisibility(i);
      paramView.iSc.setOnClickListener((View.OnClickListener)new c.a(this, paramInt));
      paramView = paramView.aku;
      j.p(paramView, "holder.itemView");
      AppMethodBeat.o(135091);
      return paramView;
      paramView = paramView.getTag();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.collection.CollectionSortViewHolder");
        AppMethodBeat.o(135091);
        throw paramView;
      }
      paramView = (i)paramView;
      break;
    }
  }
  
  public final LocalUsageInfo pE(int paramInt)
  {
    AppMethodBeat.i(135089);
    LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)getItem(paramInt);
    super.remove(localLocalUsageInfo);
    AppMethodBeat.o(135089);
    return localLocalUsageInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.c
 * JD-Core Version:    0.7.0.1
 */