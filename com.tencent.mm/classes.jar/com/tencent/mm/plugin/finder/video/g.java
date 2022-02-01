package com.tencent.mm.plugin.finder.video;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.c;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderNormalVideoThumbFetcher;", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "TAG", "", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "retriever", "Lcom/tencent/mm/compatible/video/VFSMediaMetadataRetriever;", "getRetriever", "()Lcom/tencent/mm/compatible/video/VFSMediaMetadataRetriever;", "setRetriever", "(Lcom/tencent/mm/compatible/video/VFSMediaMetadataRetriever;)V", "cancel", "", "callback", "Lkotlin/Function2;", "", "Landroid/graphics/Bitmap;", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "time", "destroy", "requestFrames", "times", "", "setSize", "width", "", "height", "plugin-finder_release"})
public final class g
  implements c
{
  com.tencent.mm.compatible.i.d ALA;
  private final String TAG;
  private final csg xqw;
  
  public g(csg paramcsg)
  {
    AppMethodBeat.i(290819);
    this.xqw = paramcsg;
    this.TAG = "MicroMsg.FinderVideoThumbFetcherFactory";
    this.ALA = new com.tencent.mm.compatible.i.d();
    try
    {
      paramcsg = this.ALA;
      if (paramcsg != null)
      {
        paramcsg.setDataSource(this.xqw.url);
        AppMethodBeat.o(290819);
        return;
      }
      AppMethodBeat.o(290819);
      return;
    }
    catch (Exception paramcsg)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramcsg, "", new Object[0]);
      AppMethodBeat.o(290819);
    }
  }
  
  public final void b(final List<Long> paramList, final m<? super Long, ? super Bitmap, x> paramm)
  {
    AppMethodBeat.i(290817);
    p.k(paramList, "times");
    p.k(paramm, "callback");
    com.tencent.mm.ae.d.b("FinderNormalVideoThumbFetcher_requestFrames", (a)new a(this, paramList, paramm));
    AppMethodBeat.o(290817);
  }
  
  public final void cancel(long paramLong) {}
  
  public final void destroy()
  {
    AppMethodBeat.i(290818);
    com.tencent.mm.compatible.i.d locald = this.ALA;
    if (locald != null) {
      locald.release();
    }
    this.ALA = null;
    AppMethodBeat.o(290818);
  }
  
  public final void setSize(int paramInt1, int paramInt2) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.g
 * JD-Core Version:    0.7.0.1
 */