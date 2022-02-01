package com.tencent.mm.plugin.finder.replay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayViewManager;", "", "rv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "reportObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "plugin", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayPluginLayout;", "getPlugin", "()Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayPluginLayout;", "setPlugin", "(Lcom/tencent/mm/plugin/finder/replay/FinderLiveReplayPluginLayout;)V", "pos", "", "getPos", "()I", "setPos", "(I)V", "recyclerView", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "activatePlugin", "", "deactivatePlugin", "release", "updatePlugins", "newPlugin", "newPos", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
{
  private WxRecyclerView AZd;
  FinderLiveReplayPluginLayout FkW;
  int pos;
  private final bui reportObj;
  
  public o(WxRecyclerView paramWxRecyclerView, bui parambui)
  {
    AppMethodBeat.i(332623);
    this.reportObj = parambui;
    this.AZd = paramWxRecyclerView;
    this.pos = -1;
    AppMethodBeat.o(332623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.o
 * JD-Core Version:    0.7.0.1
 */