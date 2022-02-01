package com.tencent.mm.plugin.finder.video;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.d;
import com.tencent.mm.protocal.protobuf.bvf;
import d.g.a.a;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderNormalVideoThumbFetcher;", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "retriever", "Lcom/tencent/mm/compatible/video/VFSMediaMetadataRetriever;", "getRetriever", "()Lcom/tencent/mm/compatible/video/VFSMediaMetadataRetriever;", "setRetriever", "(Lcom/tencent/mm/compatible/video/VFSMediaMetadataRetriever;)V", "cancel", "", "callback", "Lkotlin/Function2;", "", "Landroid/graphics/Bitmap;", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "time", "destroy", "requestFrames", "times", "", "setSize", "width", "", "height", "plugin-finder_release"})
public final class f
  implements com.tencent.mm.videocomposition.c
{
  private final bvf rQt;
  d sNq;
  
  public f(bvf parambvf)
  {
    AppMethodBeat.i(204620);
    this.rQt = parambvf;
    this.sNq = new d();
    parambvf = this.sNq;
    if (parambvf != null)
    {
      parambvf.setDataSource(this.rQt.url);
      AppMethodBeat.o(204620);
      return;
    }
    AppMethodBeat.o(204620);
  }
  
  public final void b(final List<Long> paramList, final m<? super Long, ? super Bitmap, z> paramm)
  {
    AppMethodBeat.i(204617);
    p.h(paramList, "times");
    p.h(paramm, "callback");
    com.tencent.mm.ad.c.b("FinderNormalVideoThumbFetcher_requestFrames", (a)new a(this, paramList, paramm));
    AppMethodBeat.o(204617);
  }
  
  public final void c(m<? super Long, ? super Bitmap, z> paramm)
  {
    AppMethodBeat.i(204618);
    p.h(paramm, "callback");
    AppMethodBeat.o(204618);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(204619);
    d locald = this.sNq;
    if (locald != null) {
      locald.release();
    }
    this.sNq = null;
    AppMethodBeat.o(204619);
  }
  
  public final void setSize(int paramInt1, int paramInt2) {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<z>
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