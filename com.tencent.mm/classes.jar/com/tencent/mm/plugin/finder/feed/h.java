package com.tencent.mm.plugin.finder.feed;

import android.support.v7.widget.RecyclerView.n;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.video.i;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "", "getActivity", "Lcom/tencent/mm/ui/MMActivity;", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getMediaBannerRecyclerViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "isFinderSelfScene", "", "onFavFeed", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onFollow", "isFollow", "onLikeComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "private", "likeAction", "", "preIsPrivate", "shareFeed", "shareFeedToSns", "plugin-finder_release"})
public abstract interface h
{
  public abstract n.d a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.e parame);
  
  public abstract void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3);
  
  public abstract void a(FinderItem paramFinderItem);
  
  public abstract void a(FinderItem paramFinderItem, FinderCommentInfo paramFinderCommentInfo);
  
  public abstract void a(FinderItem paramFinderItem, boolean paramBoolean, com.tencent.mm.view.recyclerview.e parame);
  
  public abstract boolean cCl();
  
  public abstract RecyclerView.n cCr();
  
  public abstract com.tencent.mm.plugin.finder.view.e cCs();
  
  public abstract n.d e(BaseFinderFeed paramBaseFinderFeed);
  
  public abstract n.e f(BaseFinderFeed paramBaseFinderFeed);
  
  public abstract void g(BaseFinderFeed paramBaseFinderFeed);
  
  public abstract MMActivity getActivity();
  
  public abstract i getVideoCore();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.h
 * JD-Core Version:    0.7.0.1
 */