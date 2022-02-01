package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.builder.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "canExpand", "", "comment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "down", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "context", "Landroid/content/Context;", "getCommentScene", "", "getCurrentFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFirstFriendPos", "getFirstOtherPos", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getRootComment", "rootCommentId", "", "getUserScene", "isCommentClose", "isSafeMode", "loadMoreLevel2Comments", "", "rootComment", "onAttach", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "builder", "feedObj", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "displayScene", "isSingleMode", "refCommentId", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "useCache", "blinkRefComment", "commentClose", "oldVer", "onClickComment", "view", "Landroid/view/View;", "item", "onClickCommentDelete", "onClickMore", "onClickResendComment", "position", "onExpandClick", "onLikeComment", "Landroid/widget/ImageView;", "onScrollIdle", "lastVisiblePosition", "plugin-finder_release"})
public abstract interface CommentDrawerContract$NPresenter
  extends a<b>
{
  public abstract s EC(long paramLong);
  
  public abstract void IG(int paramInt);
  
  public abstract void a(View paramView, s params);
  
  public abstract void a(ImageView paramImageView, int paramInt);
  
  public abstract void a(s params, boolean paramBoolean);
  
  public abstract void a(FinderCommentDrawer paramFinderCommentDrawer, b paramb, FinderItem paramFinderItem, CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback, int paramInt, boolean paramBoolean1, long paramLong, an paraman, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5);
  
  public abstract void af(View paramView, int paramInt);
  
  public abstract boolean b(s params, boolean paramBoolean);
  
  public abstract int dcA();
  
  public abstract FinderItem dcB();
  
  public abstract int dcE();
  
  public abstract int dcF();
  
  public abstract RecyclerView.h fi(Context paramContext);
  
  public abstract WxRecyclerAdapter<?> fm(Context paramContext);
  
  public abstract int getCommentScene();
  
  public abstract boolean isCommentClose();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter
 * JD-Core Version:    0.7.0.1
 */