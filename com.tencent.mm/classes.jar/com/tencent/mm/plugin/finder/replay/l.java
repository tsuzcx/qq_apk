package com.tencent.mm.plugin.finder.replay;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.mm.plugin.finder.live.component.statecomponent.e;
import com.tencent.mm.plugin.finder.live.view.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayStateComponent;", "Lcom/tencent/mm/plugin/finder/live/component/statecomponent/StateComponent;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "baseRouter", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "getBaseRouter", "()Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "setBaseRouter", "(Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;)V", "getContext", "()Landroidx/appcompat/app/AppCompatActivity;", "activate", "", "deactivate", "onBindData", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class l
  extends e
{
  public final AppCompatActivity CCa;
  public a FkM;
  
  public l(AppCompatActivity paramAppCompatActivity)
  {
    this.CCa = paramAppCompatActivity;
  }
  
  public void c(a parama)
  {
    s.u(parama, "baseRouter");
    setBuContext(parama.getBuContext());
    this.FkM = parama;
  }
  
  public void deactivate() {}
  
  public void eBc() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.l
 * JD-Core Version:    0.7.0.1
 */