package com.tencent.mm.plugin.finder.video.thumb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.a.b;
import com.tencent.mm.plugin.vlog.ui.thumb.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/thumb/TPTrackThumbInfo;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "(Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;)V", "endTimeMs", "", "getEndTimeMs", "()J", "getMediaInfo", "()Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "playRate", "", "getPlayRate", "()F", "startTimeMs", "getStartTimeMs", "totalDuration", "getTotalDuration", "cropToPlayRange", "", "start", "end", "isEmpty", "", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
{
  public static final a GvQ;
  public final b GvR;
  
  static
  {
    AppMethodBeat.i(335787);
    GvQ = new a((byte)0);
    AppMethodBeat.o(335787);
  }
  
  public c(b paramb)
  {
    AppMethodBeat.i(335782);
    this.GvR = paramb;
    this.UoP = 0L;
    this.UoQ = this.GvR.vYw;
    this.UoR = ((float)hUo() / 1000.0F);
    AppMethodBeat.o(335782);
  }
  
  public final long getEndTimeMs()
  {
    return this.GvR.TBM + this.GvR.TBN;
  }
  
  public final float getPlayRate()
  {
    return 1.0F;
  }
  
  public final long getStartTimeMs()
  {
    return this.GvR.TBM;
  }
  
  public final long getTotalDuration()
  {
    return this.GvR.vYw;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(335813);
    String str = this.GvR.path;
    s.s(str, "mediaInfo.path");
    if (((CharSequence)str).length() == 0)
    {
      AppMethodBeat.o(335813);
      return true;
    }
    AppMethodBeat.o(335813);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/thumb/TPTrackThumbInfo$Companion;", "", "()V", "countPerTime", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.thumb.c
 * JD-Core Version:    0.7.0.1
 */