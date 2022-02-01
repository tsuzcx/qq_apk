package com.tencent.mm.plugin.finder.live.component;

import android.view.View;
import com.tencent.mm.plugin.finder.live.model.at;
import com.tencent.mm.plugin.finder.presenter.base.c;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$Presenter;", "getTouchLoc", "", "hideEditView", "", "hideVolumeView", "withAnim", "", "initView", "showEmptyView", "showLoadingView", "showMusicView", "musicData", "", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "showPopupMemu", "view", "Landroid/view/View;", "pos", "", "musicItem", "anchorPosX", "anchorPosY", "volumeAction", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface j$b
  extends c<j.a>
{
  public abstract void a(View paramView, int paramInt1, at paramat, int paramInt2, int paramInt3);
  
  public abstract void ehE();
  
  public abstract void ehG();
  
  public abstract int[] ehH();
  
  public abstract void ehI();
  
  public abstract void gl(List<at> paramList);
  
  public abstract void initView();
  
  public abstract void po(boolean paramBoolean);
  
  public abstract void qp(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.j.b
 * JD-Core Version:    0.7.0.1
 */