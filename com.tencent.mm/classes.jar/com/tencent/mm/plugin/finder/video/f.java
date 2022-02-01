package com.tencent.mm.plugin.finder.video;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.d;
import com.tencent.mm.protocal.protobuf.bqs;
import d.g.a.a;
import d.g.a.m;
import d.g.b.k;
import d.y;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/FinderNormalVideoThumbFetcher;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ITrackThumbFetcher;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "retriever", "Lcom/tencent/mm/compatible/video/VFSMediaMetadataRetriever;", "getRetriever", "()Lcom/tencent/mm/compatible/video/VFSMediaMetadataRetriever;", "setRetriever", "(Lcom/tencent/mm/compatible/video/VFSMediaMetadataRetriever;)V", "destroy", "", "init", "requestFrames", "times", "", "", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "setSize", "width", "", "height", "plugin-finder_release"})
public final class f
  implements com.tencent.mm.plugin.vlog.ui.thumb.c
{
  d rQQ;
  private final bqs rcY;
  
  public f(bqs parambqs)
  {
    AppMethodBeat.i(203711);
    this.rcY = parambqs;
    AppMethodBeat.o(203711);
  }
  
  public final void b(final List<Long> paramList, final m<? super Long, ? super Bitmap, y> paramm)
  {
    AppMethodBeat.i(203709);
    k.h(paramList, "times");
    k.h(paramm, "callback");
    com.tencent.mm.ac.c.b("FinderNormalVideoThumbFetcher_requestFrames", (a)new a(this, paramList, paramm));
    AppMethodBeat.o(203709);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(203710);
    d locald = this.rQQ;
    if (locald != null) {
      locald.release();
    }
    this.rQQ = null;
    AppMethodBeat.o(203710);
  }
  
  public final void init()
  {
    AppMethodBeat.i(203708);
    this.rQQ = new d();
    d locald = this.rQQ;
    if (locald != null)
    {
      locald.setDataSource(this.rcY.url);
      AppMethodBeat.o(203708);
      return;
    }
    AppMethodBeat.o(203708);
  }
  
  public final void setSize(int paramInt1, int paramInt2) {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<y>
  {
    a(f paramf, List paramList, m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.f
 * JD-Core Version:    0.7.0.1
 */