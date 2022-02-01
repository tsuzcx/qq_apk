package com.tencent.mm.plugin.finder.nearby.live.play;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.w;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/play/LiveSource;", "Lcom/tencent/mm/plugin/finder/nearby/live/play/MediaSource;", "liveUrl", "", "feed", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "isLeftPos", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;Z)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "()Z", "getLiveUrl", "()Ljava/lang/String;", "toString", "plugin-finder-nearby_release"})
public final class a
  extends b
{
  private final String zFd;
  final w zFe;
  final boolean zFf;
  
  public a(String paramString, w paramw, boolean paramBoolean)
  {
    super(paramString);
    AppMethodBeat.i(201346);
    this.zFd = paramString;
    this.zFe = paramw;
    this.zFf = paramBoolean;
    AppMethodBeat.o(201346);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(201344);
    String str = "feed:" + this.zFe + " liveUrl:" + this.zFd + " isLeftPos:" + this.zFf;
    AppMethodBeat.o(201344);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.a
 * JD-Core Version:    0.7.0.1
 */