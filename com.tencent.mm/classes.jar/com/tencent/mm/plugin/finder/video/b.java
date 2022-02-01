package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.c;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.videocomposition.j;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.videocomposition.play.a.a.a;
import com.tencent.mm.videocomposition.play.a.a.b;
import com.tencent.mm.xeffect.effect.EffectManager;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderFakeVideoCoverPreview;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "context", "Landroid/content/Context;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "effectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "playStart", "", "playView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "destroy", "", "getBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "getView", "Landroid/view/View;", "seekTo", "timeMs", "start", "onReady", "Lkotlin/Function0;", "onDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"})
public final class b
  implements q
{
  final VideoCompositionPlayView AJS;
  private final c AJT;
  private final EffectManager AJU;
  private long AJV;
  
  public b(Context paramContext, csg paramcsg)
  {
    AppMethodBeat.i(285195);
    this.AJU = new EffectManager();
    this.AJS = new VideoCompositionPlayView(paramContext);
    paramcsg = paramcsg.TpG;
    paramContext = paramcsg;
    if (paramcsg == null) {
      paramContext = new acu();
    }
    p.j(paramContext, "media.videoCompositionInfo ?: CompositionInfo()");
    paramContext.kXi = "";
    paramContext.NmU = false;
    this.AJT = i.c(paramContext);
    this.AJT.start();
    paramContext = i.d(paramContext, this.AJU);
    paramContext.aa((kotlin.g.a.b)this.AJT);
    this.AJS.a(paramContext.getComposition());
    this.AJV = paramContext.NmT.getPlayStart();
    AppMethodBeat.o(285195);
  }
  
  public final void a(final a<x> parama1, final a<x> parama2, final kotlin.g.a.b<? super Long, x> paramb)
  {
    AppMethodBeat.i(285191);
    p.k(parama1, "onReady");
    p.k(parama2, "onDestroy");
    p.k(paramb, "onSeekFrame");
    this.AJS.setPlayerCallback((a.a.a)new a(this, parama2, parama1, paramb));
    AppMethodBeat.o(285191);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(285193);
    this.AJT.destroy();
    this.AJU.destroy();
    this.AJS.release();
    AppMethodBeat.o(285193);
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(285194);
    Bitmap localBitmap = this.AJS.getBitmap();
    AppMethodBeat.o(285194);
    return localBitmap;
  }
  
  public final View getView()
  {
    return (View)this.AJS;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(285192);
    this.AJS.seekTo(this.AJV + paramLong);
    AppMethodBeat.o(285192);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/FinderFakeVideoCoverPreview$start$1", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerFrameCallback;", "onFrame", "", "onPlayCompleted", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "plugin-finder_release"})
  public static final class a
    implements a.a.b
  {
    a(a parama1, a parama2, kotlin.g.a.b paramb) {}
    
    public final void Np(long paramLong) {}
    
    public final void egA() {}
    
    public final void egB()
    {
      AppMethodBeat.i(282970);
      parama2.invoke();
      AppMethodBeat.o(282970);
    }
    
    public final void egC() {}
    
    public final void egD()
    {
      AppMethodBeat.i(282971);
      this.AJW.AJS.pause();
      parama1.invoke();
      AppMethodBeat.o(282971);
    }
    
    public final void egE() {}
    
    public final void egF()
    {
      AppMethodBeat.i(282972);
      paramb.invoke(Long.valueOf(0L));
      AppMethodBeat.o(282972);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.b
 * JD-Core Version:    0.7.0.1
 */