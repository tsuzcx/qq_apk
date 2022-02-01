package com.tencent.mm.plugin.finder.feed;

import androidx.recyclerview.widget.RecyclerView.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.video.l;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.h;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "", "getActivity", "Lcom/tencent/mm/ui/MMActivity;", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "from", "", "getCreateQuickMoreMenuListener", "getCreateSecondMoreMenuListener", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getMediaBannerRecyclerViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getMoreMenuItemLongSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemLongSelectedListener;", "bottomSheet", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getVideoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "isFinderSelfScene", "", "onFavFeed", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "source", "onFollow", "isFollow", "onLikeComment", "comment", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "private", "likeAction", "preIsPrivate", "shareFeed", "shareFeedToSns", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface i
{
  public abstract u.g a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.f paramf);
  
  public abstract u.g a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.f paramf, int paramInt);
  
  public abstract u.g a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.f paramf, j paramj);
  
  public abstract u.h a(com.tencent.mm.ui.widget.a.f paramf, BaseFinderFeed paramBaseFinderFeed, j paramj);
  
  public abstract u.i a(BaseFinderFeed paramBaseFinderFeed, int paramInt, j paramj);
  
  public abstract void a(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3);
  
  public abstract void a(FinderItem paramFinderItem, boolean paramBoolean, j paramj, int paramInt);
  
  public abstract com.tencent.mm.plugin.finder.view.f ebA();
  
  public abstract boolean ebw();
  
  public abstract RecyclerView.m ebz();
  
  public abstract void f(BaseFinderFeed paramBaseFinderFeed);
  
  public abstract MMActivity getActivity();
  
  public abstract l getVideoCore();
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.i
 * JD-Core Version:    0.7.0.1
 */