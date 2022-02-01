package com.tencent.mm.plugin.finder.search.ui;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.mm.view.recyclerview.g;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/ui/IFinderSearchViewConfig;", "", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "forceDarkMode", "", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
{
  public abstract g dUK();
  
  public abstract RecyclerView.LayoutManager fT(Context paramContext);
  
  public abstract RecyclerView.h getItemDecoration();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.ui.b
 * JD-Core Version:    0.7.0.1
 */