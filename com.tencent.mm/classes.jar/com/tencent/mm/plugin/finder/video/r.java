package com.tencent.mm.plugin.finder.video;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.ui.thumb.c;
import d.g.a.a;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.y;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/ThumbFetcherWrapper;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ITrackThumbFetcher;", "thumbFetcher", "destroyCallback", "Lkotlin/Function0;", "", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/ITrackThumbFetcher;Lkotlin/jvm/functions/Function0;)V", "getDestroyCallback", "()Lkotlin/jvm/functions/Function0;", "getThumbFetcher", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/ITrackThumbFetcher;", "destroy", "init", "requestFrames", "times", "", "", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "setSize", "width", "", "height", "plugin-finder_release"})
public final class r
  implements c
{
  private final c KZb;
  private final a<y> LcY;
  
  public r(c paramc, a<y> parama)
  {
    AppMethodBeat.i(199863);
    this.KZb = paramc;
    this.LcY = parama;
    AppMethodBeat.o(199863);
  }
  
  public final void b(List<Long> paramList, m<? super Long, ? super Bitmap, y> paramm)
  {
    AppMethodBeat.i(199861);
    k.h(paramList, "times");
    k.h(paramm, "callback");
    this.KZb.b(paramList, paramm);
    AppMethodBeat.o(199861);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(199862);
    this.KZb.destroy();
    this.LcY.invoke();
    AppMethodBeat.o(199862);
  }
  
  public final void init()
  {
    AppMethodBeat.i(199859);
    this.KZb.init();
    AppMethodBeat.o(199859);
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199860);
    this.KZb.setSize(paramInt1, paramInt2);
    AppMethodBeat.o(199860);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.r
 * JD-Core Version:    0.7.0.1
 */