package com.tencent.mm.plugin.finder.video.thumb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.e.b.b;
import com.tencent.mm.plugin.vlog.ui.thumb.g;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/thumb/TPThumbFetcherFactory;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;", "()V", "createFromTrackInfo", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "extra", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements g
{
  public final com.tencent.mm.videocomposition.c a(com.tencent.mm.plugin.vlog.ui.thumb.a parama, Object paramObject)
  {
    AppMethodBeat.i(335786);
    s.u(parama, "trackInfo");
    if (!(parama instanceof c))
    {
      parama = (Throwable)new IllegalStateException("trackInfo is not TPTrackThumbInfo".toString());
      AppMethodBeat.o(335786);
      throw parama;
    }
    if (!(paramObject instanceof b.b))
    {
      parama = (Throwable)new IllegalStateException("not set resourceLoader".toString());
      AppMethodBeat.o(335786);
      throw parama;
    }
    parama = (com.tencent.mm.videocomposition.c)new b((c)parama, (b.b)paramObject);
    AppMethodBeat.o(335786);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.thumb.a
 * JD-Core Version:    0.7.0.1
 */