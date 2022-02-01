package com.tencent.mm.plugin.finder.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/FinderLiveViewManager;", "", "rv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "plugin", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;", "getPlugin", "()Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;", "setPlugin", "(Lcom/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout;)V", "pos", "", "getPos", "()I", "setPos", "(I)V", "recyclerView", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "activatePlugin", "", "data", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "isFromFloat", "", "deactivatePlugin", "release", "reportWhenSlideLiveRoom", "oldPos", "newPos", "updatePlugins", "newPlugin", "plugin-finder_release"})
public final class f
{
  int pos;
  WxRecyclerView ufR;
  FinderLiveVisitorPluginLayout ufS;
  
  public f(WxRecyclerView paramWxRecyclerView)
  {
    AppMethodBeat.i(245861);
    this.ufR = paramWxRecyclerView;
    this.pos = -1;
    AppMethodBeat.o(245861);
  }
  
  public final void release()
  {
    AppMethodBeat.i(245860);
    Object localObject = FinderLiveViewCallback.ufM;
    Log.i(FinderLiveViewCallback.access$getTAG$cp(), "release:" + this.ufS);
    localObject = this.ufS;
    if (localObject != null)
    {
      ((FinderLiveVisitorPluginLayout)localObject).checkMiniWindow();
      ((FinderLiveVisitorPluginLayout)localObject).unMount();
      AppMethodBeat.o(245860);
      return;
    }
    AppMethodBeat.o(245860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.f
 * JD-Core Version:    0.7.0.1
 */