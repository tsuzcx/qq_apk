package com.tencent.mm.plugin.finder.megavideo.ui;

import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.protocal.protobuf.cnu;
import com.tencent.mm.view.recyclerview.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$ViewCallback;", "bindMultiTaskInfo", "", "multiTaskHelper", "Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "info", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "isMultiTask", "", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getActivity", "Lcom/tencent/mm/ui/MMFragmentActivity;", "getCommentDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getMediaBannerRecyclerViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getVideoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "getViewCallback", "loadInitData", "loadMoreData", "onAttach", "feedLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/BaseMegaVideoLoader;", "callback", "onBackPressed", "isFromCloseBtn", "onConfigurationChanged", "isLandScape", "onFavMegaVideo", "megaVideo", "isFav", "onLikeMegaVideo", "isLike", "isPrivate", "onMultiTaskPause", "onMultiTaskResume", "onUIPause", "onUIResume", "postCheckPlay", "refreshMsgNotify", "releaseResource", "currPos", "", "requestRefresh", "shareFeed", "shareFeedToSns", "updateMultiHistoryTask", "Lkotlin/Pair;", "isUpdate", "isFromMultiTask", "plugin-finder_release"})
public abstract interface h$a
  extends com.tencent.mm.plugin.finder.presenter.base.a<h.b>
{
  public abstract void a(BaseMegaVideoLoader paramBaseMegaVideoLoader, h.b paramb);
  
  public abstract void a(com.tencent.mm.plugin.finder.megavideo.multitask.a parama, cnu paramcnu, boolean paramBoolean);
  
  public abstract f dce();
  
  public abstract void dcp();
  
  public abstract h.b dko();
  
  public abstract void dkp();
  
  public abstract void nI(boolean paramBoolean);
  
  public abstract boolean nJ(boolean paramBoolean);
  
  public abstract void requestRefresh();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.h.a
 * JD-Core Version:    0.7.0.1
 */