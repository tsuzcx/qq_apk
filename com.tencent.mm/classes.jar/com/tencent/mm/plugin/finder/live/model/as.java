package com.tencent.mm.plugin.finder.live.model;

import android.os.Bundle;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/LiveSeiCallback;", "", "()V", "AnchorInfoCallback", "LinkMicCallback", "ReplayCallback", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class as
{
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/LiveSeiCallback$AnchorInfoCallback;", "", "onAnchorInfoCallback", "", "params", "Landroid/os/Bundle;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void ao(Bundle paramBundle);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/LiveSeiCallback$LinkMicCallback;", "", "onLinkMicCallback", "", "params", "Landroid/os/Bundle;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void ap(Bundle paramBundle);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/LiveSeiCallback$ReplayCallback;", "Lcom/tencent/mm/plugin/finder/live/model/LiveSeiCallback$LinkMicCallback;", "Lcom/tencent/mm/plugin/finder/live/model/LiveSeiCallback$AnchorInfoCallback;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
    extends as.a, as.b
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.as
 * JD-Core Version:    0.7.0.1
 */