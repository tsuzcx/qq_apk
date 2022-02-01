package com.tencent.mm.plugin.appbrand.ui.collection;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ArrayAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionDragSortAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "context", "Landroid/content/Context;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getDataList", "()Ljava/util/ArrayList;", "mList", "Lcom/tencent/mm/ui/widget/sortlist/DragSortListView;", "attachListView", "", "list", "getItemId", "", "position", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "onBindViewHolder", "holder", "Lcom/tencent/mm/plugin/appbrand/ui/collection/CollectionSortViewHolder;", "item", "onCreateViewHolder", "inflater", "Landroid/view/LayoutInflater;", "remove", "index", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends ArrayAdapter<LocalUsageInfo>
{
  final ArrayList<LocalUsageInfo> pUj;
  DragSortListView uii;
  
  public b(Context paramContext, ArrayList<LocalUsageInfo> paramArrayList)
  {
    super(paramContext, c.cMk(), (List)paramArrayList);
    AppMethodBeat.i(51256);
    this.pUj = paramArrayList;
    AppMethodBeat.o(51256);
  }
  
  private static final void a(b paramb, int paramInt, View paramView)
  {
    AppMethodBeat.i(322637);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.sc(paramInt);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/ui/collection/CollectionDragSortAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramView = paramb.uii;
    if (paramView != null) {
      paramView.removeItem(paramInt);
    }
    paramView = paramb.getContext();
    s.s(paramView, "context");
    new com.tencent.mm.plugin.appbrand.widget.h.c(paramView).X((CharSequence)paramb.getContext().getResources().getString(ba.i.app_brand_usage_modify_collection_removed)).show();
    a.a(new Object(), "com/tencent/mm/plugin/appbrand/ui/collection/CollectionDragSortAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(322637);
  }
  
  public final LocalUsageInfo Dq(int paramInt)
  {
    AppMethodBeat.i(51253);
    LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)getItem(paramInt);
    super.remove(localLocalUsageInfo);
    AppMethodBeat.o(51253);
    return localLocalUsageInfo;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(51254);
    LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)getItem(paramInt);
    s.checkNotNull(localLocalUsageInfo);
    long l = s.X(localLocalUsageInfo.username, Integer.valueOf(localLocalUsageInfo.euz)).hashCode();
    AppMethodBeat.o(51254);
    return l;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(51255);
    s.u(paramViewGroup, "parent");
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(getContext());
      s.s(paramView, "from(context)");
      paramView = paramView.inflate(c.cMk(), paramViewGroup, false);
      paramViewGroup = ((ViewStub)paramView.findViewById(ba.f.content_stub)).inflate();
      if (paramViewGroup != null) {
        paramViewGroup.setBackground(null);
      }
      s.s(paramView, "view");
      paramView = new e(paramView);
      paramViewGroup = getItem(paramInt);
      s.checkNotNull(paramViewGroup);
      s.s(paramViewGroup, "getItem(position)!!");
      paramView.f((LocalUsageInfo)paramViewGroup);
      paramView.caK.setClickable(false);
      paramView.uiq.setContentDescription((CharSequence)getContext().getResources().getString(ba.i.delete_Imgbtn));
      if (paramInt != getCount() - 1) {
        break label233;
      }
    }
    label233:
    for (int i = 8;; i = 0)
    {
      paramView.uir.setVisibility(i);
      paramView.uiq.setOnClickListener(new b..ExternalSyntheticLambda0(this, paramInt));
      paramView = paramView.caK;
      s.s(paramView, "holder.itemView");
      AppMethodBeat.o(51255);
      return paramView;
      paramView = paramView.getTag();
      if (paramView == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.collection.CollectionSortViewHolder");
        AppMethodBeat.o(51255);
        throw paramView;
      }
      paramView = (e)paramView;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.b
 * JD-Core Version:    0.7.0.1
 */