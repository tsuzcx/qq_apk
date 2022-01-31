package com.tencent.mm.plugin.appbrand.ui.collection;

import a.k;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ArrayAdapter;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.ui.widget.sortlist.DragSortListView;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends ArrayAdapter<LocalUsageInfo>
{
  DragSortListView hgq;
  final ArrayList<LocalUsageInfo> hgv;
  
  public c(Context paramContext, ArrayList<LocalUsageInfo> paramArrayList)
  {
    super(paramContext, d.apE(), (List)paramArrayList);
    this.hgv = paramArrayList;
  }
  
  public final long getItemId(int paramInt)
  {
    LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)getItem(paramInt);
    return (localLocalUsageInfo.username + localLocalUsageInfo.fJy).hashCode();
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = LayoutInflater.from(getContext());
      a.d.b.g.j(paramView, "LayoutInflater.from(context)");
      paramView = paramView.inflate(d.apE(), paramViewGroup, false);
      paramViewGroup = ((ViewStub)paramView.findViewById(y.g.content_stub)).inflate();
      if (paramViewGroup != null) {
        paramViewGroup.setBackground(null);
      }
      a.d.b.g.j(paramView, "view");
      paramView = new g(paramView);
      paramViewGroup = getItem(paramInt);
      a.d.b.g.j(paramViewGroup, "getItem(position)");
      paramView.f((LocalUsageInfo)paramViewGroup);
      paramViewGroup = paramView.aie;
      a.d.b.g.j(paramViewGroup, "holder.itemView");
      paramViewGroup.setClickable(false);
      if (paramInt != getCount() - 1) {
        break label208;
      }
    }
    label208:
    for (int i = 8;; i = 0)
    {
      paramView.hgH.setVisibility(i);
      paramViewGroup = paramView.hgD;
      a.d.b.g.j(paramViewGroup, "rightExtraBottomLine");
      paramViewGroup.setVisibility(i);
      paramView.hgC.setOnClickListener((View.OnClickListener)new c.a(this, paramInt));
      paramView = paramView.aie;
      a.d.b.g.j(paramView, "holder.itemView");
      return paramView;
      paramView = paramView.getTag();
      if (paramView == null) {
        throw new k("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.collection.CollectionSortViewHolder");
      }
      paramView = (g)paramView;
      break;
    }
  }
  
  public final LocalUsageInfo mq(int paramInt)
  {
    LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)getItem(paramInt);
    super.remove(localLocalUsageInfo);
    return localLocalUsageInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.c
 * JD-Core Version:    0.7.0.1
 */