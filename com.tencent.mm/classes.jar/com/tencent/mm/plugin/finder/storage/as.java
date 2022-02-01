package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import kotlin.Metadata;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "", "()V", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "extraMap", "Lkotlin/Function1;", "", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "context", "Landroid/content/Context;", "getViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "Lcom/tencent/mm/ui/MMActivity;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class as
{
  public abstract g au(b<? super Integer, ? extends f<?>> paramb);
  
  public g ech()
  {
    return au(null);
  }
  
  public abstract RecyclerView.LayoutManager fT(Context paramContext);
  
  public abstract RecyclerView.h getItemDecoration();
  
  public abstract RecyclerView.m j(MMActivity paramMMActivity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.as
 * JD-Core Version:    0.7.0.1
 */