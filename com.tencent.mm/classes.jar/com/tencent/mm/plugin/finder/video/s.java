package com.tencent.mm.plugin.finder.video;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.c;
import d.a.j;
import d.g.a.a;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/ThumbFetcherWrapper;", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "start", "", "thumbFetcher", "destroyCallback", "Lkotlin/Function0;", "", "(JLcom/tencent/mm/videocomposition/ITrackThumbFetcher;Lkotlin/jvm/functions/Function0;)V", "getDestroyCallback", "()Lkotlin/jvm/functions/Function0;", "getStart", "()J", "getThumbFetcher", "()Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "cancel", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "time", "destroy", "requestFrames", "times", "", "setSize", "width", "", "height", "plugin-finder_release"})
public final class s
  implements c
{
  private final c sFx;
  private final a<z> sQq;
  final long start;
  
  public s(long paramLong, c paramc, a<z> parama)
  {
    AppMethodBeat.i(204888);
    this.start = paramLong;
    this.sFx = paramc;
    this.sQq = parama;
    AppMethodBeat.o(204888);
  }
  
  public final void b(List<Long> paramList, final m<? super Long, ? super Bitmap, z> paramm)
  {
    AppMethodBeat.i(204885);
    p.h(paramList, "times");
    p.h(paramm, "callback");
    c localc = this.sFx;
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(Long.valueOf(((Number)((Iterator)localObject).next()).longValue() + this.start));
    }
    localc.b((List)paramList, (m)new a(this, paramm));
    AppMethodBeat.o(204885);
  }
  
  public final void c(m<? super Long, ? super Bitmap, z> paramm)
  {
    AppMethodBeat.i(204886);
    p.h(paramm, "callback");
    this.sFx.c(paramm);
    AppMethodBeat.o(204886);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(204887);
    this.sFx.destroy();
    this.sQq.invoke();
    AppMethodBeat.o(204887);
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204884);
    this.sFx.setSize(paramInt1, paramInt2);
    AppMethodBeat.o(204884);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "time", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  static final class a
    extends q
    implements m<Long, Bitmap, z>
  {
    a(s params, m paramm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.s
 * JD-Core Version:    0.7.0.1
 */