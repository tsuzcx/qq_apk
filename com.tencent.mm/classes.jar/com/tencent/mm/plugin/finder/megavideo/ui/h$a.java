package com.tencent.mm.plugin.finder.megavideo.ui;

import com.tencent.mm.plugin.finder.megavideo.floatball.b;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.protocal.protobuf.cwl;
import com.tencent.mm.view.recyclerview.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "bindMultiTaskInfo", "", "multiTaskHelper", "Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "info", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "isMultiTask", "", "bindVideoFloatBall", "floatBallHelper", "Lcom/tencent/mm/plugin/finder/megavideo/floatball/MegaVideoFloatBallHelper;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getCurrentVideoPosSec", "", "getMediaBannerRecyclerViewPool", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getVideoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "getViewCallback", "loadInitData", "loadMoreData", "onAttach", "feedLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "callback", "onBackPressed", "isFromCloseBtn", "onConfigurationChanged", "isLandScape", "onFavMegaVideo", "megaVideo", "isFav", "onLikeMegaVideo", "isLike", "isPrivate", "likeAction", "onMultiTaskPause", "onMultiTaskResume", "onUIPause", "onUIResume", "postCheckPlay", "refreshMsgNotify", "releaseResource", "currPos", "requestRefresh", "shareFeed", "shareFeedToSns", "updateMultiHistoryTask", "Lkotlin/Pair;", "isUpdate", "isFromMultiTask", "plugin-finder_release"})
public abstract interface h$a
  extends com.tencent.mm.plugin.finder.presenter.base.a<h.b>
{
  public abstract void a(b paramb, cwl paramcwl);
  
  public abstract void a(BaseMegaVideoLoader paramBaseMegaVideoLoader, h.b paramb);
  
  public abstract void a(com.tencent.mm.plugin.finder.megavideo.multitask.a parama, cwl paramcwl, boolean paramBoolean);
  
  public abstract h.b dJY();
  
  public abstract void dJZ();
  
  public abstract void dsF();
  
  public abstract f dsu();
  
  public abstract int dtf();
  
  public abstract void onUIPause();
  
  public abstract void pP(boolean paramBoolean);
  
  public abstract boolean pQ(boolean paramBoolean);
  
  public abstract void requestRefresh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.h.a
 * JD-Core Version:    0.7.0.1
 */