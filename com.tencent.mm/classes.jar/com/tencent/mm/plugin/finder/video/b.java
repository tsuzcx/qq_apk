package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.c;
import com.tencent.mm.plugin.vlog.model.f;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.videocomposition.h;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.videocomposition.play.a.a.a;
import com.tencent.mm.videocomposition.play.a.a.b;
import d.g.a.a;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderFakeVideoCoverPreview;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "context", "Landroid/content/Context;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "playStart", "", "playView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "destroy", "", "getBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "getView", "Landroid/view/View;", "seekTo", "timeMs", "start", "onReady", "Lkotlin/Function0;", "onDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"})
public final class b
  implements n
{
  final VideoCompositionPlayView sNf;
  private final c sNg;
  private long sNh;
  
  public b(Context paramContext, bvf parambvf)
  {
    AppMethodBeat.i(204607);
    this.sNf = new VideoCompositionPlayView(paramContext);
    paramContext = parambvf.GPu;
    p.g(paramContext, "compositionInfo");
    this.sNg = f.b(paramContext);
    this.sNg.start();
    paramContext = f.a(paramContext);
    paramContext.E((d.g.a.b)this.sNg);
    this.sNf.a(paramContext.getComposition());
    this.sNh = paramContext.BGk.getPlayStart();
    AppMethodBeat.o(204607);
  }
  
  public final void a(final a<z> parama1, final a<z> parama2, final d.g.a.b<? super Long, z> paramb)
  {
    AppMethodBeat.i(204603);
    p.h(parama1, "onReady");
    p.h(parama2, "onDestroy");
    p.h(paramb, "onSeekFrame");
    this.sNf.setPlayerCallback((a.a.a)new a(this, parama2, parama1, paramb));
    AppMethodBeat.o(204603);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(204605);
    this.sNg.destroy();
    this.sNf.release();
    AppMethodBeat.o(204605);
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(204606);
    Bitmap localBitmap = this.sNf.getBitmap();
    AppMethodBeat.o(204606);
    return localBitmap;
  }
  
  public final View getView()
  {
    return (View)this.sNf;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(204604);
    this.sNf.seekTo(this.sNh + paramLong);
    AppMethodBeat.o(204604);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/video/FinderFakeVideoCoverPreview$start$1", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerFrameCallback;", "onFrame", "", "onPlayCompleted", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "plugin-finder_release"})
  public static final class a
    implements a.a.b
  {
    a(a parama1, a parama2, d.g.a.b paramb) {}
    
    public final void cLW() {}
    
    public final void cLX()
    {
      AppMethodBeat.i(204600);
      parama2.invoke();
      AppMethodBeat.o(204600);
    }
    
    public final void cLY() {}
    
    public final void cLZ()
    {
      AppMethodBeat.i(204601);
      this.sNi.sNf.pause();
      parama1.invoke();
      AppMethodBeat.o(204601);
    }
    
    public final void cMa() {}
    
    public final void cMb()
    {
      AppMethodBeat.i(204602);
      paramb.invoke(Long.valueOf(0L));
      AppMethodBeat.o(204602);
    }
    
    public final void xp(long paramLong) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.b
 * JD-Core Version:    0.7.0.1
 */