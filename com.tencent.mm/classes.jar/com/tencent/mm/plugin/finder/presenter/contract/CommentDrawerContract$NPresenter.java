package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.plugin.finder.model.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.k;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "canExpand", "", "comment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "down", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "context", "Landroid/content/Context;", "getCommentScene", "", "getCurrentFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFirstFriendPos", "getFirstOtherPos", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getRootComment", "rootCommentId", "", "getUserScene", "isCommentClose", "isSafeMode", "loadMoreLevel2Comments", "", "rootComment", "onAttach", "builder", "feedObj", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "displayScene", "isSingleMode", "refCommentId", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "useCache", "blinkRefComment", "commentClose", "oldVer", "onClickComment", "view", "Landroid/view/View;", "item", "onClickCommentDelete", "onClickMore", "onClickResendComment", "position", "onExpandClick", "onLikeComment", "Landroid/widget/ImageView;", "onScrollIdle", "lastVisiblePosition", "plugin-finder_release"})
public abstract interface CommentDrawerContract$NPresenter
  extends com.tencent.mm.plugin.finder.presenter.base.a<com.tencent.mm.plugin.finder.view.builder.a>
{
  public abstract void CD(int paramInt);
  
  public abstract void a(View paramView, h paramh);
  
  public abstract void a(ImageView paramImageView, int paramInt);
  
  public abstract void a(h paramh, boolean paramBoolean);
  
  public abstract void a(com.tencent.mm.plugin.finder.view.builder.a parama, FinderItem paramFinderItem, CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback, int paramInt, boolean paramBoolean1, long paramLong, k paramk, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5);
  
  public abstract void ae(View paramView, int paramInt);
  
  public abstract boolean b(h paramh, boolean paramBoolean);
  
  public abstract int clT();
  
  public abstract FinderItem clU();
  
  public abstract RecyclerView.h eC(Context paramContext);
  
  public abstract WxRecyclerAdapter<?> eD(Context paramContext);
  
  public abstract int fTh();
  
  public abstract int fTi();
  
  public abstract int getCommentScene();
  
  public abstract boolean isCommentClose();
  
  public abstract h qa(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter
 * JD-Core Version:    0.7.0.1
 */