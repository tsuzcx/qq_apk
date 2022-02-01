package com.tencent.mm.plugin.finder.uniComments;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.plugin.finder.uniComments.storge.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerContract$NPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/uniComments/UniTimelineDrawerBuilder;", "canExpand", "", "comment", "Lcom/tencent/mm/plugin/finder/uniComments/storge/UniFeedComment;", "down", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "context", "Landroid/content/Context;", "getCommentScene", "", "getCurrentFeed", "Lcom/tencent/mm/plugin/finder/uniComments/model/UniEntityItem;", "getFirstFriendPos", "getFirstOtherPos", "getItemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getRootComment", "rootCommentId", "", "getUserScene", "isCommentClose", "isSafeMode", "loadMoreLevel2Comments", "", "rootComment", "onAttach", "drawer", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawer;", "builder", "feedObj", "onCloseDrawerCallback", "Lcom/tencent/mm/plugin/finder/uniComments/UniCommentDrawerContract$CloseDrawerCallback;", "displayScene", "isSingleMode", "refCommentId", "replyCommentObj", "Lcom/tencent/mm/plugin/finder/uniComments/storge/LocalUniCommentObject;", "useCache", "blinkRefComment", "commentClose", "oldVer", "isOnlyShowDesc", "onClickComment", "view", "Landroid/view/View;", "item", "onClickCommentDelete", "onClickMore", "onClickResendComment", "position", "onExpandClick", "onLikeComment", "Landroid/widget/ImageView;", "onScrollIdle", "lastVisiblePosition", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface e$b
  extends a<i>
{
  public abstract void NE(int paramInt);
  
  public abstract void a(View paramView, d paramd);
  
  public abstract void a(UniCommentDrawer paramUniCommentDrawer, i parami, com.tencent.mm.plugin.finder.uniComments.model.b paramb, e.a parama, int paramInt, boolean paramBoolean1, long paramLong, com.tencent.mm.plugin.finder.uniComments.storge.b paramb1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5);
  
  public abstract void a(d paramd, boolean paramBoolean);
  
  public abstract void as(View paramView, int paramInt);
  
  public abstract void b(ImageView paramImageView, int paramInt);
  
  public abstract boolean b(d paramd, boolean paramBoolean);
  
  public abstract int ebS();
  
  public abstract int ebW();
  
  public abstract int ebX();
  
  public abstract com.tencent.mm.plugin.finder.uniComments.model.b fdi();
  
  public abstract int getCommentScene();
  
  public abstract RecyclerView.h gl(Context paramContext);
  
  public abstract WxRecyclerAdapter<?> gr(Context paramContext);
  
  public abstract boolean isCommentClose();
  
  public abstract d qx(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.uniComments.e.b
 * JD-Core Version:    0.7.0.1
 */