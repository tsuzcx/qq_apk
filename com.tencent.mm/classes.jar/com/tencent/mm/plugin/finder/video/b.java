package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.c;
import com.tencent.mm.plugin.vlog.model.f;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.protocal.protobuf.aaq;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.videocomposition.h;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.videocomposition.play.a.a.a;
import com.tencent.mm.videocomposition.play.a.a.b;
import d.g.a.a;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/FinderFakeVideoCoverPreview;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "context", "Landroid/content/Context;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "playStart", "", "playView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "destroy", "", "getBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "getView", "Landroid/view/View;", "seekTo", "timeMs", "start", "onReady", "Lkotlin/Function0;", "onDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"})
public final class b
  implements n
{
  final VideoCompositionPlayView sYq;
  private final c sYr;
  private long sYs;
  
  public b(Context paramContext, bvz parambvz)
  {
    AppMethodBeat.i(205231);
    this.sYq = new VideoCompositionPlayView(paramContext);
    parambvz = parambvz.HiW;
    paramContext = parambvz;
    if (parambvz == null) {
      paramContext = new aaq();
    }
    p.g(paramContext, "media.videoCompositionInfo ?: CompositionInfo()");
    this.sYr = f.b(paramContext);
    this.sYr.start();
    paramContext = f.a(paramContext);
    paramContext.F((d.g.a.b)this.sYr);
    this.sYq.a(paramContext.getComposition());
    this.sYs = paramContext.BXI.getPlayStart();
    AppMethodBeat.o(205231);
  }
  
  public final void a(final a<z> parama1, final a<z> parama2, final d.g.a.b<? super Long, z> paramb)
  {
    AppMethodBeat.i(205227);
    p.h(parama1, "onReady");
    p.h(parama2, "onDestroy");
    p.h(paramb, "onSeekFrame");
    this.sYq.setPlayerCallback((a.a.a)new a(this, parama2, parama1, paramb));
    AppMethodBeat.o(205227);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(205229);
    this.sYr.destroy();
    this.sYq.release();
    AppMethodBeat.o(205229);
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(205230);
    Bitmap localBitmap = this.sYq.getBitmap();
    AppMethodBeat.o(205230);
    return localBitmap;
  }
  
  public final View getView()
  {
    return (View)this.sYq;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(205228);
    this.sYq.seekTo(this.sYs + paramLong);
    AppMethodBeat.o(205228);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/video/FinderFakeVideoCoverPreview$start$1", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerFrameCallback;", "onFrame", "", "onPlayCompleted", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "plugin-finder_release"})
  public static final class a
    implements a.a.b
  {
    a(a parama1, a parama2, d.g.a.b paramb) {}
    
    public final void cOE() {}
    
    public final void cOF()
    {
      AppMethodBeat.i(205224);
      parama2.invoke();
      AppMethodBeat.o(205224);
    }
    
    public final void cOG() {}
    
    public final void cOH()
    {
      AppMethodBeat.i(205225);
      this.sYt.sYq.pause();
      parama1.invoke();
      AppMethodBeat.o(205225);
    }
    
    public final void cOI() {}
    
    public final void cOJ()
    {
      AppMethodBeat.i(205226);
      paramb.invoke(Long.valueOf(0L));
      AppMethodBeat.o(205226);
    }
    
    public final void xH(long paramLong) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.b
 * JD-Core Version:    0.7.0.1
 */