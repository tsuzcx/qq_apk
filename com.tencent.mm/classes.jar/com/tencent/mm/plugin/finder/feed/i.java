package com.tencent.mm.plugin.finder.feed;

import androidx.recyclerview.widget.RecyclerView.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.f;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "", "getActivity", "Lcom/tencent/mm/ui/MMActivity;", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "from", "", "getCreateSecondMoreMenuListener", "getMediaBannerRecyclerViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getVideoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "isFinderSelfScene", "", "onFavFeed", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "onFollow", "isFollow", "onLikeComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "private", "likeAction", "preIsPrivate", "shareFeed", "shareFeedToSns", "plugin-finder_release"})
public abstract interface i
{
  public abstract q.f a(BaseFinderFeed paramBaseFinderFeed, e parame);
  
  public abstract q.f a(BaseFinderFeed paramBaseFinderFeed, e parame, int paramInt);
  
  public abstract q.g a(BaseFinderFeed paramBaseFinderFeed, int paramInt, com.tencent.mm.view.recyclerview.i parami);
  
  public abstract void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3);
  
  public abstract void a(FinderItem paramFinderItem, FinderCommentInfo paramFinderCommentInfo);
  
  public abstract void a(FinderItem paramFinderItem, boolean paramBoolean, com.tencent.mm.view.recyclerview.i parami);
  
  public abstract void b(FinderItem paramFinderItem);
  
  public abstract boolean dsp();
  
  public abstract RecyclerView.m dsv();
  
  public abstract f dsw();
  
  public abstract MMActivity getActivity();
  
  public abstract com.tencent.mm.plugin.finder.video.l getVideoCore();
  
  public abstract void k(BaseFinderFeed paramBaseFinderFeed);
  
  public abstract void l(BaseFinderFeed paramBaseFinderFeed);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.i
 * JD-Core Version:    0.7.0.1
 */