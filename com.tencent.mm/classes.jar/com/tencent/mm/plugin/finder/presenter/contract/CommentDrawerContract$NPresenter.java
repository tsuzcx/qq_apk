package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.plugin.finder.model.m;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.builder.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "canExpand", "", "comment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "down", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "context", "Landroid/content/Context;", "getCommentScene", "", "getCurrentFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFirstFriendPos", "getFirstOtherPos", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getRootComment", "rootCommentId", "", "getUserScene", "isCommentClose", "isSafeMode", "loadMoreLevel2Comments", "", "rootComment", "onAttach", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "builder", "feedObj", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "displayScene", "isSingleMode", "refCommentId", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "useCache", "blinkRefComment", "commentClose", "oldVer", "onClickComment", "view", "Landroid/view/View;", "item", "onClickCommentDelete", "onClickMore", "onClickResendComment", "position", "onExpandClick", "onLikeComment", "Landroid/widget/ImageView;", "onScrollIdle", "lastVisiblePosition", "plugin-finder_release"})
public abstract interface CommentDrawerContract$NPresenter
  extends a<b>
{
  public abstract void Ey(int paramInt);
  
  public abstract void a(View paramView, m paramm);
  
  public abstract void a(ImageView paramImageView, int paramInt);
  
  public abstract void a(m paramm, boolean paramBoolean);
  
  public abstract void a(FinderCommentDrawer paramFinderCommentDrawer, b paramb, FinderItem paramFinderItem, CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback, int paramInt, boolean paramBoolean1, long paramLong, ab paramab, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5);
  
  public abstract void ag(View paramView, int paramInt);
  
  public abstract boolean b(m paramm, boolean paramBoolean);
  
  public abstract int cAZ();
  
  public abstract int cBa();
  
  public abstract FinderItem cBb();
  
  public abstract int cBe();
  
  public abstract int cBf();
  
  public abstract RecyclerView.h eK(Context paramContext);
  
  public abstract WxRecyclerAdapter<?> eM(Context paramContext);
  
  public abstract boolean isCommentClose();
  
  public abstract m wg(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter
 * JD-Core Version:    0.7.0.1
 */