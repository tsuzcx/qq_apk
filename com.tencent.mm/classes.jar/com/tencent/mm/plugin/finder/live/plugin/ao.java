package com.tencent.mm.plugin.finder.live.plugin;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGameDynamicOperateFrameSetPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGameDynamicFrameSetPlugin;", "entranceRoot", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "getFrameSetParentId", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ao
  extends an
{
  private final ViewGroup CZa;
  private final b nfT;
  
  public ao(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(355801);
    this.CZa = paramViewGroup;
    this.nfT = paramb;
    AppMethodBeat.o(355801);
  }
  
  public final String eqi()
  {
    return "game_operate_frame_set_container";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.ao
 * JD-Core Version:    0.7.0.1
 */