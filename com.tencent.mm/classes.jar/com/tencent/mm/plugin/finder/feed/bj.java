package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.builder.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/IDrawerPresenter;", "", "doExtraOnBuildDrawerBody", "", "view", "Landroid/view/View;", "doExtraTitleChange", "context", "Landroid/content/Context;", "headerLayout", "Landroid/widget/FrameLayout;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getItemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getScene", "", "getTotalItemCount", "onAttach", "builder", "Lcom/tencent/mm/plugin/finder/view/builder/FinderLikeDrawerBuilder;", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "likeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "onDetach", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface bj
{
  public abstract void a(Context paramContext, FrameLayout paramFrameLayout);
  
  public abstract void a(a parama, FinderItem paramFinderItem, b paramb);
  
  public abstract int eci();
  
  public abstract RecyclerView.LayoutManager fT(Context paramContext);
  
  public abstract void fx(View paramView);
  
  public abstract int getScene();
  
  public abstract RecyclerView.h gl(Context paramContext);
  
  public abstract WxRecyclerAdapter<?> gr(Context paramContext);
  
  public abstract void onDetach();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.bj
 * JD-Core Version:    0.7.0.1
 */