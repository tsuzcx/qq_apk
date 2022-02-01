package com.tencent.mm.plugin.finder.video;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.d;
import com.tencent.mm.protocal.protobuf.bmd;
import d.g.a.a;
import d.g.a.m;
import d.g.b.k;
import d.y;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderNormalVideoThumbFetcher;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ITrackThumbFetcher;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "retriever", "Lcom/tencent/mm/compatible/video/VFSMediaMetadataRetriever;", "getRetriever", "()Lcom/tencent/mm/compatible/video/VFSMediaMetadataRetriever;", "setRetriever", "(Lcom/tencent/mm/compatible/video/VFSMediaMetadataRetriever;)V", "destroy", "", "init", "requestFrames", "times", "", "", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "setSize", "width", "", "height", "plugin-finder_release"})
public final class i
  implements com.tencent.mm.plugin.vlog.ui.thumb.c
{
  d LbM;
  private final bmd qsb;
  
  public i(bmd parambmd)
  {
    AppMethodBeat.i(199726);
    this.qsb = parambmd;
    AppMethodBeat.o(199726);
  }
  
  public final void b(final List<Long> paramList, final m<? super Long, ? super Bitmap, y> paramm)
  {
    AppMethodBeat.i(199724);
    k.h(paramList, "times");
    k.h(paramm, "callback");
    com.tencent.mm.ad.c.b("FinderNormalVideoThumbFetcher_requestFrames", (a)new a(this, paramList, paramm));
    AppMethodBeat.o(199724);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(199725);
    d locald = this.LbM;
    if (locald != null) {
      locald.release();
    }
    this.LbM = null;
    AppMethodBeat.o(199725);
  }
  
  public final void init()
  {
    AppMethodBeat.i(199723);
    this.LbM = new d();
    d locald = this.LbM;
    if (locald != null)
    {
      locald.setDataSource(this.qsb.url);
      AppMethodBeat.o(199723);
      return;
    }
    AppMethodBeat.o(199723);
  }
  
  public final void setSize(int paramInt1, int paramInt2) {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<y>
  {
    a(i parami, List paramList, m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.i
 * JD-Core Version:    0.7.0.1
 */