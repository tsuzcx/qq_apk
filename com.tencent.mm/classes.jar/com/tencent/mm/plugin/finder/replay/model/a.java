package com.tencent.mm.plugin.finder.replay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/model/FinderLiveReplayLogicConfig;", "", "()V", "cachePlayOffset", "", "getCachePlayOffset", "()Z", "setCachePlayOffset", "(Z)V", "haveMiniView", "getHaveMiniView", "setHaveMiniView", "replace", "", "newConfig", "toString", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public boolean FlP = true;
  public boolean FlQ = true;
  
  public final String toString()
  {
    AppMethodBeat.i(332752);
    String str = "haveMiniView:" + this.FlP + ",cachePlayOffset:" + this.FlQ;
    AppMethodBeat.o(332752);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.model.a
 * JD-Core Version:    0.7.0.1
 */