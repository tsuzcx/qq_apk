package com.tencent.mm.plugin.finder.live.component;

import com.tencent.mm.plugin.finder.live.model.at;
import com.tencent.mm.plugin.finder.presenter.base.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/live/component/FinderLiveAnchorMusicLoadMoreInterface;", "deleteMusic", "", "musicItem", "Lcom/tencent/mm/plugin/finder/live/model/MusicItem;", "pos", "", "hide", "hideEditView", "pauseMusic", "playComplete", "playError", "songId", "playMusic", "forcePlay", "", "playStart", "resumeMusic", "setMusicVolume", "progress", "showMusicView", "showSearchView", "stopMusic", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface j$a
  extends k, a<j.b>
{
  public abstract void OA(int paramInt);
  
  public abstract void OB(int paramInt);
  
  public abstract void a(at paramat, int paramInt);
  
  public abstract void a(at paramat, int paramInt, boolean paramBoolean);
  
  public abstract void b(at paramat, int paramInt);
  
  public abstract void bLi();
  
  public abstract void ehC();
  
  public abstract void ehD();
  
  public abstract void ehE();
  
  public abstract void ehF();
  
  public abstract void hide();
  
  public abstract void playStart();
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.component.j.a
 * JD-Core Version:    0.7.0.1
 */