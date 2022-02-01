package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.builder.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "", "doExtraOnBuildDrawerBody", "", "view", "Landroid/view/View;", "doExtraTitleChange", "context", "Landroid/content/Context;", "headerLayout", "Landroid/widget/FrameLayout;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getScene", "", "getTotalItemCount", "onAttach", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "likeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "onDetach", "plugin-finder_release"})
public abstract interface bc
{
  public abstract void a(Context paramContext, FrameLayout paramFrameLayout);
  
  public abstract void a(a parama, FinderItem paramFinderItem, b paramb);
  
  public abstract int dth();
  
  public abstract RecyclerView.LayoutManager eW(Context paramContext);
  
  public abstract void ev(View paramView);
  
  public abstract RecyclerView.h fn(Context paramContext);
  
  public abstract WxRecyclerAdapter<?> fs(Context paramContext);
  
  public abstract int getScene();
  
  public abstract void onDetach();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.bc
 * JD-Core Version:    0.7.0.1
 */