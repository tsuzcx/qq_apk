package com.tencent.mm.plugin.finder.video;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/ThumbFetcherWrapper;", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "start", "", "thumbFetcher", "destroyCallback", "Lkotlin/Function0;", "", "(JLcom/tencent/mm/videocomposition/ITrackThumbFetcher;Lkotlin/jvm/functions/Function0;)V", "getDestroyCallback", "()Lkotlin/jvm/functions/Function0;", "getStart", "()J", "getThumbFetcher", "()Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "cancel", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "time", "destroy", "requestFrames", "times", "", "setSize", "width", "", "height", "plugin-finder_release"})
public final class x
  implements c
{
  private final a<kotlin.x> APo;
  private final c Aub;
  final long start;
  
  public x(long paramLong, c paramc, a<kotlin.x> parama)
  {
    AppMethodBeat.i(263196);
    this.start = paramLong;
    this.Aub = paramc;
    this.APo = parama;
    AppMethodBeat.o(263196);
  }
  
  public final void b(List<Long> paramList, final m<? super Long, ? super Bitmap, kotlin.x> paramm)
  {
    AppMethodBeat.i(263191);
    p.k(paramList, "times");
    p.k(paramm, "callback");
    c localc = this.Aub;
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(Long.valueOf(((Number)((Iterator)localObject).next()).longValue() + this.start));
    }
    localc.b((List)paramList, (m)new a(this, paramm));
    AppMethodBeat.o(263191);
  }
  
  public final void cancel(long paramLong)
  {
    AppMethodBeat.i(263193);
    this.Aub.cancel(this.start + paramLong);
    AppMethodBeat.o(263193);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(263194);
    this.Aub.destroy();
    this.APo.invoke();
    AppMethodBeat.o(263194);
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(263190);
    this.Aub.setSize(paramInt1, paramInt2);
    AppMethodBeat.o(263190);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "time", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  static final class a
    extends q
    implements m<Long, Bitmap, kotlin.x>
  {
    a(x paramx, m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.x
 * JD-Core Version:    0.7.0.1
 */