package com.tencent.mm.plugin.finder.video;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/ThumbFetcherWrapper;", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "start", "", "thumbFetcher", "destroyCallback", "Lkotlin/Function0;", "", "(JLcom/tencent/mm/videocomposition/ITrackThumbFetcher;Lkotlin/jvm/functions/Function0;)V", "getDestroyCallback", "()Lkotlin/jvm/functions/Function0;", "getStart", "()J", "getThumbFetcher", "()Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "cancel", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "time", "destroy", "requestFrames", "times", "", "setSize", "width", "", "height", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
  implements c
{
  private final c FTn;
  private final a<ah> GrH;
  final long start;
  
  public z(long paramLong, c paramc, a<ah> parama)
  {
    AppMethodBeat.i(335284);
    this.start = paramLong;
    this.FTn = paramc;
    this.GrH = parama;
    AppMethodBeat.o(335284);
  }
  
  public final void b(List<Long> paramList, m<? super Long, ? super Bitmap, ah> paramm)
  {
    AppMethodBeat.i(335298);
    s.u(paramList, "times");
    s.u(paramm, "callback");
    c localc = this.FTn;
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(Long.valueOf(((Number)((Iterator)localObject).next()).longValue() + this.start));
    }
    localc.b((List)paramList, (m)new a(paramm, this));
    AppMethodBeat.o(335298);
  }
  
  public final void cancel(long paramLong)
  {
    AppMethodBeat.i(335302);
    this.FTn.cancel(this.start + paramLong);
    AppMethodBeat.o(335302);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(335309);
    this.FTn.destroy();
    this.GrH.invoke();
    AppMethodBeat.o(335309);
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(335290);
    this.FTn.setSize(paramInt1, paramInt2);
    AppMethodBeat.o(335290);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "time", "", "bitmap", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<Long, Bitmap, ah>
  {
    a(m<? super Long, ? super Bitmap, ah> paramm, z paramz)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.z
 * JD-Core Version:    0.7.0.1
 */