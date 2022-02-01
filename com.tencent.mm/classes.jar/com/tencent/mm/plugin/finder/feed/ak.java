package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.builder.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "", "doExtraOnBuildDrawerBody", "", "view", "Landroid/view/View;", "doExtraTitleChange", "context", "Landroid/content/Context;", "headerLayout", "Landroid/widget/FrameLayout;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getScene", "", "getTotalItemCount", "onAttach", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "onDetach", "plugin-finder_release"})
public abstract interface ak
{
  public abstract void a(Context paramContext, FrameLayout paramFrameLayout);
  
  public abstract void a(b paramb, FinderItem paramFinderItem);
  
  public abstract RecyclerView.h eC(Context paramContext);
  
  public abstract WxRecyclerAdapter<?> eD(Context paramContext);
  
  public abstract int fTk();
  
  public abstract void gO(View paramView);
  
  public abstract int getScene();
  
  public abstract RecyclerView.i lw(Context paramContext);
  
  public abstract void onDetach();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ak
 * JD-Core Version:    0.7.0.1
 */