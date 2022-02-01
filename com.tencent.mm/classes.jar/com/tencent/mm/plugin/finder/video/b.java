package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.e;
import com.tencent.mm.plugin.vlog.model.c;
import com.tencent.mm.plugin.vlog.model.r;
import com.tencent.mm.plugin.vlog.player.VLogCompositionPlayView;
import com.tencent.mm.plugin.vlog.player.c.a.a;
import com.tencent.mm.plugin.vlog.player.c.a.b;
import com.tencent.mm.protocal.protobuf.bqs;
import d.g.a.a;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/FinderFakeVideoCoverPreview;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "context", "Landroid/content/Context;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "frameRetriever", "Lcom/tencent/mm/media/mix/FrameSeeker;", "playStart", "", "playView", "Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayView;", "destroy", "", "getBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "getView", "Landroid/view/View;", "seekTo", "timeMs", "start", "onReady", "Lkotlin/Function0;", "onDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"})
public final class b
  implements n
{
  final VLogCompositionPlayView rQF;
  private final e rQG;
  private long rQH;
  
  public b(Context paramContext, bqs parambqs)
  {
    AppMethodBeat.i(203698);
    this.rQF = new VLogCompositionPlayView(paramContext);
    paramContext = parambqs.FfQ;
    k.g(paramContext, "compositionInfo");
    this.rQG = c.b(paramContext);
    this.rQG.start();
    paramContext = c.a(paramContext);
    paramContext.D((d.g.a.b)this.rQG);
    this.rQF.a(paramContext);
    this.rQH = paramContext.efB();
    AppMethodBeat.o(203698);
  }
  
  public final void a(final a<y> parama1, final a<y> parama2, final d.g.a.b<? super Long, y> paramb)
  {
    AppMethodBeat.i(203694);
    k.h(parama1, "onReady");
    k.h(parama2, "onDestroy");
    k.h(paramb, "onSeekFrame");
    this.rQF.setPlayerCallback((c.a.a)new a(this, parama2, parama1, paramb));
    AppMethodBeat.o(203694);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(203696);
    this.rQG.destroy();
    this.rQF.release();
    AppMethodBeat.o(203696);
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(203697);
    Bitmap localBitmap = this.rQF.getBitmap();
    AppMethodBeat.o(203697);
    return localBitmap;
  }
  
  public final View getView()
  {
    return (View)this.rQF;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(203695);
    this.rQF.seekTo(this.rQH + paramLong);
    AppMethodBeat.o(203695);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/video/FinderFakeVideoCoverPreview$start$1", "Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayer$Companion$PlayerFrameCallback;", "onFrame", "", "onPlayCompleted", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "plugin-finder_release"})
  public static final class a
    implements c.a.b
  {
    a(a parama1, a parama2, d.g.a.b paramb) {}
    
    public final void cDC() {}
    
    public final void cDD()
    {
      AppMethodBeat.i(203691);
      parama2.invoke();
      AppMethodBeat.o(203691);
    }
    
    public final void cDE() {}
    
    public final void cDF()
    {
      AppMethodBeat.i(203692);
      this.rQI.rQF.pause();
      parama1.invoke();
      AppMethodBeat.o(203692);
    }
    
    public final void cDG() {}
    
    public final void cDH()
    {
      AppMethodBeat.i(203693);
      paramb.ay(Long.valueOf(0L));
      AppMethodBeat.o(203693);
    }
    
    public final void vm(long paramLong) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.b
 * JD-Core Version:    0.7.0.1
 */