package com.tencent.mm.plugin.finder.video;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderNormalVideoThumbFetcher;", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "TAG", "", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "retriever", "Lcom/tencent/mm/compatible/video/VFSMediaMetadataRetriever;", "getRetriever", "()Lcom/tencent/mm/compatible/video/VFSMediaMetadataRetriever;", "setRetriever", "(Lcom/tencent/mm/compatible/video/VFSMediaMetadataRetriever;)V", "cancel", "", "callback", "Lkotlin/Function2;", "", "Landroid/graphics/Bitmap;", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "time", "destroy", "requestFrames", "times", "", "setSize", "width", "", "height", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements c
{
  private final dji ANJ;
  com.tencent.mm.compatible.i.d Gow;
  private final String TAG;
  
  public h(dji paramdji)
  {
    AppMethodBeat.i(334727);
    this.ANJ = paramdji;
    this.TAG = "MicroMsg.FinderVideoThumbFetcherFactory";
    this.Gow = new com.tencent.mm.compatible.i.d();
    try
    {
      paramdji = this.Gow;
      if (paramdji != null)
      {
        paramdji.setDataSource(this.ANJ.url);
        AppMethodBeat.o(334727);
        return;
      }
    }
    catch (Exception paramdji)
    {
      Log.printErrStackTrace(this.TAG, (Throwable)paramdji, "", new Object[0]);
      AppMethodBeat.o(334727);
    }
  }
  
  public final void b(List<Long> paramList, final m<? super Long, ? super Bitmap, ah> paramm)
  {
    AppMethodBeat.i(334742);
    s.u(paramList, "times");
    s.u(paramm, "callback");
    com.tencent.mm.ae.d.d("FinderNormalVideoThumbFetcher_requestFrames", (a)new a(paramList, this, paramm));
    AppMethodBeat.o(334742);
  }
  
  public final void cancel(long paramLong) {}
  
  public final void destroy()
  {
    AppMethodBeat.i(334756);
    com.tencent.mm.compatible.i.d locald = this.Gow;
    if (locald != null) {
      locald.release();
    }
    this.Gow = null;
    AppMethodBeat.o(334756);
  }
  
  public final void setSize(int paramInt1, int paramInt2) {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(List<Long> paramList, h paramh, m<? super Long, ? super Bitmap, ah> paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.h
 * JD-Core Version:    0.7.0.1
 */