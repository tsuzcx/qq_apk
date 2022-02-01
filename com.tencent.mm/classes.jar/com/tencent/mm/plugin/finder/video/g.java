package com.tencent.mm.plugin.finder.video;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cjl;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderNormalVideoThumbFetcher;", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "retriever", "Lcom/tencent/mm/compatible/video/VFSMediaMetadataRetriever;", "getRetriever", "()Lcom/tencent/mm/compatible/video/VFSMediaMetadataRetriever;", "setRetriever", "(Lcom/tencent/mm/compatible/video/VFSMediaMetadataRetriever;)V", "cancel", "", "callback", "Lkotlin/Function2;", "", "Landroid/graphics/Bitmap;", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "time", "destroy", "requestFrames", "times", "", "setSize", "width", "", "height", "plugin-finder_release"})
public final class g
  implements com.tencent.mm.videocomposition.g
{
  private final cjl tHM;
  com.tencent.mm.compatible.i.d wcR;
  
  public g(cjl paramcjl)
  {
    AppMethodBeat.i(254068);
    this.tHM = paramcjl;
    this.wcR = new com.tencent.mm.compatible.i.d();
    paramcjl = this.wcR;
    if (paramcjl != null)
    {
      paramcjl.setDataSource(this.tHM.url);
      AppMethodBeat.o(254068);
      return;
    }
    AppMethodBeat.o(254068);
  }
  
  public final void b(final List<Long> paramList, final m<? super Long, ? super Bitmap, x> paramm)
  {
    AppMethodBeat.i(254066);
    p.h(paramList, "times");
    p.h(paramm, "callback");
    com.tencent.mm.ac.d.b("FinderNormalVideoThumbFetcher_requestFrames", (a)new a(this, paramList, paramm));
    AppMethodBeat.o(254066);
  }
  
  public final void cancel(long paramLong) {}
  
  public final void destroy()
  {
    AppMethodBeat.i(254067);
    com.tencent.mm.compatible.i.d locald = this.wcR;
    if (locald != null) {
      locald.release();
    }
    this.wcR = null;
    AppMethodBeat.o(254067);
  }
  
  public final void setSize(int paramInt1, int paramInt2) {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(g paramg, List paramList, m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.g
 * JD-Core Version:    0.7.0.1
 */