package com.tencent.mm.plugin.finder.video;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.ui.thumb.c;
import d.a.j;
import d.g.a.a;
import d.g.a.m;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/ThumbFetcherWrapper;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ITrackThumbFetcher;", "start", "", "thumbFetcher", "destroyCallback", "Lkotlin/Function0;", "", "(JLcom/tencent/mm/plugin/vlog/ui/thumb/ITrackThumbFetcher;Lkotlin/jvm/functions/Function0;)V", "getDestroyCallback", "()Lkotlin/jvm/functions/Function0;", "getStart", "()J", "getThumbFetcher", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/ITrackThumbFetcher;", "destroy", "init", "requestFrames", "times", "", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "setSize", "width", "", "height", "plugin-finder_release"})
public final class s
  implements c
{
  private final c rKw;
  private final a<y> rTF;
  final long start;
  
  public s(long paramLong, c paramc, a<y> parama)
  {
    AppMethodBeat.i(203931);
    this.start = paramLong;
    this.rKw = paramc;
    this.rTF = parama;
    AppMethodBeat.o(203931);
  }
  
  public final void b(List<Long> paramList, final m<? super Long, ? super Bitmap, y> paramm)
  {
    AppMethodBeat.i(203929);
    k.h(paramList, "times");
    k.h(paramm, "callback");
    c localc = this.rKw;
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(Long.valueOf(((Number)((Iterator)localObject).next()).longValue() + this.start));
    }
    localc.b((List)paramList, (m)new a(this, paramm));
    AppMethodBeat.o(203929);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(203930);
    this.rKw.destroy();
    this.rTF.invoke();
    AppMethodBeat.o(203930);
  }
  
  public final void init()
  {
    AppMethodBeat.i(203927);
    this.rKw.init();
    AppMethodBeat.o(203927);
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(203928);
    this.rKw.setSize(paramInt1, paramInt2);
    AppMethodBeat.o(203928);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "time", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  static final class a
    extends d.g.b.l
    implements m<Long, Bitmap, y>
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