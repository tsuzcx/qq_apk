package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ArrayAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragSortAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "context", "Landroid/content/Context;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getDataList", "()Ljava/util/ArrayList;", "mList", "Lcom/tencent/mm/ui/widget/sortlist/DragSortListView;", "attachListView", "", "list", "getItemId", "", "position", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "onBindViewHolder", "holder", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionSortViewHolder;", "item", "onCreateViewHolder", "inflater", "Landroid/view/LayoutInflater;", "remove", "index", "plugin-appbrand-integration_release"})
public final class b
  extends ArrayAdapter<LocalUsageInfo>
{
  final ArrayList<LocalUsageInfo> kgc;
  DragSortListView oaR;
  
  public b(Context paramContext, ArrayList<LocalUsageInfo> paramArrayList)
  {
    super(paramContext, c.bYk(), (List)paramArrayList);
    AppMethodBeat.i(51256);
    this.kgc = paramArrayList;
    AppMethodBeat.o(51256);
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(51254);
    LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)getItem(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    if (localLocalUsageInfo == null) {
      p.hyc();
    }
    long l = (localLocalUsageInfo.username + localLocalUsageInfo.iOo).hashCode();
    AppMethodBeat.o(51254);
    return l;
  }
  
  public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(51255);
    p.h(paramViewGroup, "parent");
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(getContext());
      p.g(paramView, "LayoutInflater.from(context)");
      paramView = paramView.inflate(c.bYk(), paramViewGroup, false);
      paramViewGroup = ((ViewStub)paramView.findViewById(2131299219)).inflate();
      if (paramViewGroup != null) {
        paramViewGroup.setBackground(null);
      }
      p.g(paramView, "view");
      paramView = new e(paramView);
      paramViewGroup = getItem(paramInt);
      if (paramViewGroup == null) {
        p.hyc();
      }
      p.g(paramViewGroup, "getItem(position)!!");
      paramView.f((LocalUsageInfo)paramViewGroup);
      paramViewGroup = paramView.aus;
      p.g(paramViewGroup, "holder.itemView");
      paramViewGroup.setClickable(false);
      if (paramInt != getCount() - 1) {
        break label237;
      }
    }
    label237:
    for (int i = 8;; i = 0)
    {
      paramView.obi.setVisibility(i);
      paramViewGroup = paramView.obc;
      p.g(paramViewGroup, "rightExtraBottomLine");
      paramViewGroup.setVisibility(i);
      paramView.obb.setOnClickListener((View.OnClickListener)new a(this, paramInt));
      paramView = paramView.aus;
      p.g(paramView, "holder.itemView");
      AppMethodBeat.o(51255);
      return paramView;
      paramView = paramView.getTag();
      if (paramView == null)
      {
        paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.collection.CollectionSortViewHolder");
        AppMethodBeat.o(51255);
        throw paramView;
      }
      paramView = (e)paramView;
      break;
    }
  }
  
  public final LocalUsageInfo zt(int paramInt)
  {
    AppMethodBeat.i(51253);
    LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)getItem(paramInt);
    super.remove(localLocalUsageInfo);
    AppMethodBeat.o(51253);
    return localLocalUsageInfo;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(b paramb, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(51252);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/appbrand/ui/collection/CollectionDragSortAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = b.a(this.oaW);
      if (paramView != null) {
        paramView.removeItem(paramInt);
      }
      a.a(this, "com/tencent/mm/plugin/appbrand/ui/collection/CollectionDragSortAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(51252);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.b
 * JD-Core Version:    0.7.0.1
 */