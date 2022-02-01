package com.tencent.mm.plugin.finder.replay.widget;

import android.content.Context;
import com.tencent.mm.plugin.finder.live.plugin.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/widget/IFinderLiveReplayFullScreenReplayUI;", "Lcom/tencent/mm/plugin/finder/replay/widget/IFinderLiveReplayUI;", "finishUI", "", "getUIContext", "Landroid/content/Context;", "getView", "T", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "setUIClickListener", "listener", "Lcom/tencent/mm/plugin/finder/replay/widget/IFinderLiveReplayUI$UIClickListener;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface e
  extends f
{
  public abstract <T extends b> T bf(Class<T> paramClass);
  
  public abstract void dmh();
  
  public abstract Context getUIContext();
  
  public abstract void setUIClickListener(f.a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.widget.e
 * JD-Core Version:    0.7.0.1
 */