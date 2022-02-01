package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.w;
import android.view.ViewGroup;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.c;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "", "getIfReachBottom", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getViewHolder", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "viewParent", "Landroid/view/ViewGroup;", "getViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"})
public abstract interface z
{
  public abstract c B(d.g.a.b<? super Integer, ? extends com.tencent.mm.view.recyclerview.b<?>> paramb);
  
  public abstract c cBj();
  
  public abstract RecyclerView.i eL(Context paramContext);
  
  public abstract RecyclerView.n f(MMActivity paramMMActivity);
  
  public abstract RecyclerView.h getItemDecoration();
  
  public abstract RecyclerView.w q(ViewGroup paramViewGroup);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.z
 * JD-Core Version:    0.7.0.1
 */