package com.tencent.mm.plugin.finder.live.component;

import android.view.View;
import com.tencent.mm.plugin.finder.live.model.aq;
import com.tencent.mm.plugin.finder.presenter.base.c;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$Presenter;", "getTouchLoc", "", "hideEditView", "", "hideVolumeView", "withAnim", "", "initView", "showEmptyView", "showLoadingView", "showMusicView", "musicData", "", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "showPopupMemu", "view", "Landroid/view/View;", "pos", "", "musicItem", "anchorPosX", "anchorPosY", "volumeAction", "plugin-finder_release"})
public abstract interface a$b
  extends c<a.a>
{
  public abstract void a(View paramView, int paramInt1, aq paramaq, int paramInt2, int paramInt3);
  
  public abstract void dwX();
  
  public abstract void dwZ();
  
  public abstract int[] dxa();
  
  public abstract void dxb();
  
  public abstract void ej(List<aq> paramList);
  
  public abstract void initView();
  
  public abstract void nO(boolean paramBoolean);
  
  public abstract void oF(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.a.b
 * JD-Core Version:    0.7.0.1
 */