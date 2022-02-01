package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.builder.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "", "doExtraOnBuildDrawerBody", "", "view", "Landroid/view/View;", "doExtraTitleChange", "context", "Landroid/content/Context;", "headerLayout", "Landroid/widget/FrameLayout;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getScene", "", "getTotalItemCount", "onAttach", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "likeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "onDetach", "plugin-finder_release"})
public abstract interface aq
{
  public abstract void a(Context paramContext, FrameLayout paramFrameLayout);
  
  public abstract void a(a parama, FinderItem paramFinderItem, b paramb);
  
  public abstract int cCW();
  
  public abstract RecyclerView.h eO(Context paramContext);
  
  public abstract RecyclerView.i eP(Context paramContext);
  
  public abstract WxRecyclerAdapter<?> eQ(Context paramContext);
  
  public abstract void ee(View paramView);
  
  public abstract int getScene();
  
  public abstract void onDetach();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.aq
 * JD-Core Version:    0.7.0.1
 */