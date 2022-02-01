package com.tencent.mm.plugin.finder.live;

import com.tencent.mm.plugin.finder.live.viewmodel.data.g;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/live/FinderLiveContract$Presenter;", "getRLLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "initView", "", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;", "initPos", "", "clickLiveId", "", "keyboardChange", "show", "", "height", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onInit", "onLoadMoreResult", "oriDataSize", "incrementSize", "onNewIntent", "intent", "onOrderResult", "notifyPos", "upIncrementSize", "downIncrementSize", "onPreloadResult", "lastItemPos", "onUninit", "restartLive", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface c$b
  extends c<c.a>
{
  public abstract void a(g paramg, int paramInt1, int paramInt2);
  
  public abstract void a(g paramg, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void a(g paramg, int paramInt, long paramLong);
  
  public abstract void b(g paramg, int paramInt1, int paramInt2);
  
  public abstract RefreshLoadMoreLayout egG();
  
  public abstract void egH();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.c.b
 * JD-Core Version:    0.7.0.1
 */