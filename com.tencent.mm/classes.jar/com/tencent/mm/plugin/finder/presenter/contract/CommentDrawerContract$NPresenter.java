package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.au;
import com.tencent.mm.plugin.finder.view.FinderCommentDrawer;
import com.tencent.mm.plugin.finder.view.builder.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$NPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/view/builder/FinderTimelineDrawerBuilder;", "canExpand", "", "comment", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "down", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "context", "Landroid/content/Context;", "getCommentScene", "", "getCurrentFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getFirstFriendPos", "getFirstOtherPos", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getRootComment", "rootCommentId", "", "getUserScene", "isCommentClose", "isSafeMode", "loadMoreLevel2Comments", "", "rootComment", "onAttach", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentDrawer;", "builder", "feedObj", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "displayScene", "isSingleMode", "refCommentId", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderCommentObject;", "useCache", "blinkRefComment", "blinkDuration", "commentClose", "oldVer", "isOnlyShowDesc", "onClickComment", "view", "Landroid/view/View;", "item", "onClickCommentDelete", "onClickMore", "onClickResendComment", "position", "onExpandClick", "onLikeComment", "Landroid/widget/ImageView;", "onScrollIdle", "lastVisiblePosition", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface CommentDrawerContract$NPresenter
  extends a<b>
{
  public abstract void NE(int paramInt);
  
  public abstract void a(View paramView, t paramt);
  
  public abstract void a(t paramt, boolean paramBoolean);
  
  public abstract void a(FinderCommentDrawer paramFinderCommentDrawer, b paramb, FinderItem paramFinderItem, CommentDrawerContract.CloseDrawerCallback paramCloseDrawerCallback, int paramInt, boolean paramBoolean1, long paramLong1, au paramau, boolean paramBoolean2, boolean paramBoolean3, long paramLong2, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6);
  
  public abstract void as(View paramView, int paramInt);
  
  public abstract void b(ImageView paramImageView, int paramInt);
  
  public abstract boolean b(t paramt, boolean paramBoolean);
  
  public abstract int ebS();
  
  public abstract FinderItem ebT();
  
  public abstract int ebW();
  
  public abstract int ebX();
  
  public abstract int getCommentScene();
  
  public abstract RecyclerView.h gl(Context paramContext);
  
  public abstract WxRecyclerAdapter<?> gr(Context paramContext);
  
  public abstract boolean isCommentClose();
  
  public abstract t nq(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.NPresenter
 * JD-Core Version:    0.7.0.1
 */