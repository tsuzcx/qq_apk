package com.tencent.mm.plugin.finder.video;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.g;
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
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/ThumbFetcherWrapper;", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "start", "", "thumbFetcher", "destroyCallback", "Lkotlin/Function0;", "", "(JLcom/tencent/mm/videocomposition/ITrackThumbFetcher;Lkotlin/jvm/functions/Function0;)V", "getDestroyCallback", "()Lkotlin/jvm/functions/Function0;", "getStart", "()J", "getThumbFetcher", "()Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "cancel", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "time", "destroy", "requestFrames", "times", "", "setSize", "width", "", "height", "plugin-finder_release"})
public final class w
  implements g
{
  final long start;
  private final g vNj;
  private final a<x> wgu;
  
  public w(long paramLong, g paramg, a<x> parama)
  {
    AppMethodBeat.i(254416);
    this.start = paramLong;
    this.vNj = paramg;
    this.wgu = parama;
    AppMethodBeat.o(254416);
  }
  
  public final void b(List<Long> paramList, final m<? super Long, ? super Bitmap, x> paramm)
  {
    AppMethodBeat.i(254413);
    p.h(paramList, "times");
    p.h(paramm, "callback");
    g localg = this.vNj;
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(Long.valueOf(((Number)((Iterator)localObject).next()).longValue() + this.start));
    }
    localg.b((List)paramList, (m)new a(this, paramm));
    AppMethodBeat.o(254413);
  }
  
  public final void cancel(long paramLong)
  {
    AppMethodBeat.i(254414);
    this.vNj.cancel(this.start + paramLong);
    AppMethodBeat.o(254414);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(254415);
    this.vNj.destroy();
    this.wgu.invoke();
    AppMethodBeat.o(254415);
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(254412);
    this.vNj.setSize(paramInt1, paramInt2);
    AppMethodBeat.o(254412);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "time", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  static final class a
    extends q
    implements m<Long, Bitmap, x>
  {
    a(w paramw, m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.w
 * JD-Core Version:    0.7.0.1
 */