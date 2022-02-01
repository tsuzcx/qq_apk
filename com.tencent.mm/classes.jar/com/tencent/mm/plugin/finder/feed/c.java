package com.tencent.mm.plugin.finder.feed;

import android.support.v7.widget.RecyclerView.n;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.f;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "", "getActivity", "Lcom/tencent/mm/ui/MMActivity;", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getMediaBannerRecyclerViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "isFinderSelfScene", "", "onFavFeed", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "onFollow", "isFollow", "onLikeComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "likeAction", "", "shareFeed", "plugin-finder_release"})
public abstract interface c
{
  public abstract n.c a(BaseFinderFeed paramBaseFinderFeed, e parame);
  
  public abstract void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean, int paramInt);
  
  public abstract void a(FinderItem paramFinderItem);
  
  public abstract void a(FinderItem paramFinderItem, FinderCommentInfo paramFinderCommentInfo);
  
  public abstract n.c c(BaseFinderFeed paramBaseFinderFeed);
  
  public abstract boolean clH();
  
  public abstract RecyclerView.n clM();
  
  public abstract n.d d(BaseFinderFeed paramBaseFinderFeed);
  
  public abstract void d(FinderItem paramFinderItem, boolean paramBoolean);
  
  public abstract f fSW();
  
  public abstract MMActivity getActivity();
  
  public abstract com.tencent.mm.plugin.finder.video.c getVideoCore();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.c
 * JD-Core Version:    0.7.0.1
 */