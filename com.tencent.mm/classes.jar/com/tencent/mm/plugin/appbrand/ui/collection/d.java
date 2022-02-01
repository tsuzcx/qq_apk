package com.tencent.mm.plugin.appbrand.ui.collection;

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
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragSortAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "context", "Landroid/content/Context;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getDataList", "()Ljava/util/ArrayList;", "mList", "Lcom/tencent/mm/ui/widget/sortlist/DragSortListView;", "attachListView", "", "list", "getItemId", "", "position", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "onBindViewHolder", "holder", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionSortViewHolder;", "item", "onCreateViewHolder", "inflater", "Landroid/view/LayoutInflater;", "remove", "index", "plugin-appbrand-integration_release"})
public final class d
  extends ArrayAdapter<LocalUsageInfo>
{
  final ArrayList<LocalUsageInfo> dataList;
  DragSortListView lGg;
  
  public d(Context paramContext, ArrayList<LocalUsageInfo> paramArrayList)
  {
    super(paramContext, e.bpo(), (List)paramArrayList);
    AppMethodBeat.i(51256);
    this.dataList = paramArrayList;
    AppMethodBeat.o(51256);
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(51254);
    LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)getItem(paramInt);
    long l = (localLocalUsageInfo.username + localLocalUsageInfo.gXn).hashCode();
    AppMethodBeat.o(51254);
    return l;
  }
  
  public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(51255);
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(getContext());
      k.g(paramView, "LayoutInflater.from(context)");
      paramView = paramView.inflate(e.bpo(), paramViewGroup, false);
      paramViewGroup = ((ViewStub)paramView.findViewById(2131298774)).inflate();
      if (paramViewGroup != null) {
        paramViewGroup.setBackground(null);
      }
      k.g(paramView, "view");
      paramView = new j(paramView);
      paramViewGroup = getItem(paramInt);
      k.g(paramViewGroup, "getItem(position)");
      paramView.g((LocalUsageInfo)paramViewGroup);
      paramViewGroup = paramView.arI;
      k.g(paramViewGroup, "holder.itemView");
      paramViewGroup.setClickable(false);
      if (paramInt != getCount() - 1) {
        break label224;
      }
    }
    label224:
    for (int i = 8;; i = 0)
    {
      paramView.lGJ.setVisibility(i);
      paramViewGroup = paramView.lGD;
      k.g(paramViewGroup, "rightExtraBottomLine");
      paramViewGroup.setVisibility(i);
      paramView.lGC.setOnClickListener((View.OnClickListener)new a(this, paramInt));
      paramView = paramView.arI;
      k.g(paramView, "holder.itemView");
      AppMethodBeat.o(51255);
      return paramView;
      paramView = paramView.getTag();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.collection.CollectionSortViewHolder");
        AppMethodBeat.o(51255);
        throw paramView;
      }
      paramView = (j)paramView;
      break;
    }
  }
  
  public final LocalUsageInfo uc(int paramInt)
  {
    AppMethodBeat.i(51253);
    LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)getItem(paramInt);
    super.remove(localLocalUsageInfo);
    AppMethodBeat.o(51253);
    return localLocalUsageInfo;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(d paramd, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(51252);
      paramView = d.a(this.lGx);
      if (paramView != null)
      {
        paramView.removeItem(paramInt);
        AppMethodBeat.o(51252);
        return;
      }
      AppMethodBeat.o(51252);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.d
 * JD-Core Version:    0.7.0.1
 */