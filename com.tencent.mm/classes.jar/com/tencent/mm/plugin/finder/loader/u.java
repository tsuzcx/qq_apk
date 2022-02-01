package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.video.aa;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;", "Lcom/tencent/mm/plugin/finder/loader/IFinderVideoDownloader;", "preloadCoreCore", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;)V", "getPreloadCoreCore", "()Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "createVideoProxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "runOnUI", "", "run", "Lkotlin/Function0;", "CdnCallback", "Companion", "VideoProxy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  implements y
{
  public static final b EyU;
  final com.tencent.mm.plugin.finder.preload.f EyV;
  
  static
  {
    AppMethodBeat.i(166363);
    EyU = new b((byte)0);
    AppMethodBeat.o(166363);
  }
  
  public u(com.tencent.mm.plugin.finder.preload.f paramf)
  {
    this.EyV = paramf;
  }
  
  public static void bt(a<ah> parama)
  {
    AppMethodBeat.i(166362);
    s.u(parama, "run");
    d.uiThread((a)new d(parama));
    AppMethodBeat.o(166362);
  }
  
  public final com.tencent.mm.modelvideo.f a(v paramv, aa paramaa)
  {
    AppMethodBeat.i(331791);
    s.u(paramv, "video");
    s.u(paramaa, "callback");
    paramv = (com.tencent.mm.modelvideo.f)new u.c(this, paramv, paramaa);
    AppMethodBeat.o(331791);
    return paramv;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$Companion;", "", "()V", "TAG", "", "checkFinishValid", "", "mediaId", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements a<ah>
  {
    d(a<ah> parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.u
 * JD-Core Version:    0.7.0.1
 */