package com.tencent.mm.plugin.finder.preload.worker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.preload.c;
import com.tencent.mm.plugin.thumbplayer.b.f;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.a;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "invoke"})
final class b$d
  extends d.g.b.l
  implements a<c>
{
  b$d(b paramb, String paramString, boolean paramBoolean)
  {
    super(0);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$cancel$1$1$1", "Lcom/tencent/mm/plugin/thumbplayer/cdn/StopPreloadDownloadCallback;", "onStop", "", "ret", "", "plugin-finder_release"})
  public static final class a
    implements f
  {
    a(b.d paramd) {}
    
    public final void DO(int paramInt)
    {
      AppMethodBeat.i(202651);
      ac.i(b.b(this.rwn.rwi), "preload task on Stop " + this.rwn.oWs + ' ' + paramInt);
      b.da("stopPreload", paramInt);
      AppMethodBeat.o(202651);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.worker.b.d
 * JD-Core Version:    0.7.0.1
 */