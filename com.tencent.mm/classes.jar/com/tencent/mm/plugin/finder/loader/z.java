package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.plugin.finder.preload.c;
import com.tencent.mm.plugin.finder.video.y;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;", "Lcom/tencent/mm/plugin/finder/loader/IFinderVideoDownloader;", "preloadCoreCore", "Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "(Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;)V", "getPreloadCoreCore", "()Lcom/tencent/mm/plugin/finder/preload/MediaPreloadCore;", "createVideoProxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "runOnUI", "", "run", "Lkotlin/Function0;", "CdnCallback", "Companion", "VideoProxy", "plugin-finder_release"})
public final class z
  implements ad
{
  public static final b zuW;
  final c zuV;
  
  static
  {
    AppMethodBeat.i(166363);
    zuW = new b((byte)0);
    AppMethodBeat.o(166363);
  }
  
  public z(c paramc)
  {
    this.zuV = paramc;
  }
  
  public static void U(a<x> parama)
  {
    AppMethodBeat.i(166362);
    p.k(parama, "run");
    d.uiThread((a)new z.d(parama));
    AppMethodBeat.o(166362);
  }
  
  public final f a(aa paramaa, y paramy)
  {
    AppMethodBeat.i(280498);
    p.k(paramaa, "video");
    p.k(paramy, "callback");
    paramaa = (f)new z.c(this, paramaa, paramy);
    AppMethodBeat.o(280498);
    return paramaa;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$Companion;", "", "()V", "TAG", "", "checkFinishValid", "", "mediaId", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.z
 * JD-Core Version:    0.7.0.1
 */