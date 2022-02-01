package com.tencent.mm.plugin.finder.nearby.live.play;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.x;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/LiveSource;", "Lcom/tencent/mm/plugin/finder/nearby/live/play/MediaSource;", "liveUrl", "", "feed", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "isLeftPos", "", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;Z)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "()Z", "getLiveUrl", "()Ljava/lang/String;", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends d
{
  private final String CCl;
  final x EJX;
  final boolean EKv;
  
  public c(String paramString, x paramx, boolean paramBoolean)
  {
    super(paramString);
    AppMethodBeat.i(340988);
    this.CCl = paramString;
    this.EJX = paramx;
    this.EKv = paramBoolean;
    AppMethodBeat.o(340988);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(340995);
    String str = "feed:" + this.EJX + " liveUrl:" + this.CCl + " isLeftPos:" + this.EKv;
    AppMethodBeat.o(340995);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.c
 * JD-Core Version:    0.7.0.1
 */