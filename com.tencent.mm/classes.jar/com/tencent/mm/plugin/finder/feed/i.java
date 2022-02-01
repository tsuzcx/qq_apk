package com.tencent.mm.plugin.finder.feed;

import android.support.v7.widget.RecyclerView.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.video.k;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.view.recyclerview.h;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "", "getActivity", "Lcom/tencent/mm/ui/MMActivity;", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getMediaBannerRecyclerViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "isFinderSelfScene", "", "onFavFeed", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onFollow", "isFollow", "onLikeComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "private", "likeAction", "", "preIsPrivate", "shareFeed", "shareFeedToSns", "plugin-finder_release"})
public abstract interface i
{
  public abstract o.f a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.e parame);
  
  public abstract void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3);
  
  public abstract void a(FinderItem paramFinderItem);
  
  public abstract void a(FinderItem paramFinderItem, FinderCommentInfo paramFinderCommentInfo);
  
  public abstract void a(FinderItem paramFinderItem, boolean paramBoolean, h paramh);
  
  public abstract void b(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean);
  
  public abstract boolean dbZ();
  
  public abstract RecyclerView.m dcf();
  
  public abstract com.tencent.mm.plugin.finder.view.e dcg();
  
  public abstract MMActivity getActivity();
  
  public abstract k getVideoCore();
  
  public abstract o.f i(BaseFinderFeed paramBaseFinderFeed);
  
  public abstract o.g j(BaseFinderFeed paramBaseFinderFeed);
  
  public abstract void k(BaseFinderFeed paramBaseFinderFeed);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.i
 * JD-Core Version:    0.7.0.1
 */