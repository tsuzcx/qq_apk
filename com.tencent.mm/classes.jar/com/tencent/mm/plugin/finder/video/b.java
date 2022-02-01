package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.c;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.videocomposition.n;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.videocomposition.play.a.a.a;
import com.tencent.mm.videocomposition.play.a.a.b;
import com.tencent.mm.xeffect.effect.EffectManager;
import kotlin.g.a.a;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderFakeVideoCoverPreview;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "context", "Landroid/content/Context;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "effectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "playStart", "", "playView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "destroy", "", "getBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "getView", "Landroid/view/View;", "seekTo", "timeMs", "start", "onReady", "Lkotlin/Function0;", "onDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"})
public final class b
  implements p
{
  final VideoCompositionPlayView wbi;
  private final c wbj;
  private final EffectManager wbk;
  private long wbl;
  
  public b(Context paramContext, cjl paramcjl)
  {
    AppMethodBeat.i(253884);
    this.wbk = new EffectManager();
    this.wbi = new VideoCompositionPlayView(paramContext);
    paramcjl = paramcjl.MfU;
    paramContext = paramcjl;
    if (paramcjl == null) {
      paramContext = new acn();
    }
    kotlin.g.b.p.g(paramContext, "media.videoCompositionInfo ?: CompositionInfo()");
    paramContext.iiv = "";
    paramContext.Gzo = false;
    this.wbj = i.d(paramContext);
    this.wbj.start();
    paramContext = i.d(paramContext, this.wbk);
    paramContext.O((kotlin.g.a.b)this.wbj);
    this.wbi.a(paramContext.getComposition());
    this.wbl = paramContext.Gez.getPlayStart();
    AppMethodBeat.o(253884);
  }
  
  public final void a(final a<x> parama1, final a<x> parama2, final kotlin.g.a.b<? super Long, x> paramb)
  {
    AppMethodBeat.i(253880);
    kotlin.g.b.p.h(parama1, "onReady");
    kotlin.g.b.p.h(parama2, "onDestroy");
    kotlin.g.b.p.h(paramb, "onSeekFrame");
    this.wbi.setPlayerCallback((a.a.a)new a(this, parama2, parama1, paramb));
    AppMethodBeat.o(253880);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(253882);
    this.wbj.destroy();
    this.wbk.destroy();
    this.wbi.release();
    AppMethodBeat.o(253882);
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(253883);
    Bitmap localBitmap = this.wbi.getBitmap();
    AppMethodBeat.o(253883);
    return localBitmap;
  }
  
  public final View getView()
  {
    return (View)this.wbi;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(253881);
    this.wbi.seekTo(this.wbl + paramLong);
    AppMethodBeat.o(253881);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderFakeVideoCoverPreview$start$1", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerFrameCallback;", "onFrame", "", "onPlayCompleted", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "plugin-finder_release"})
  public static final class a
    implements a.a.b
  {
    a(a parama1, a parama2, kotlin.g.a.b paramb) {}
    
    public final void Go(long paramLong) {}
    
    public final void dER() {}
    
    public final void dES()
    {
      AppMethodBeat.i(253877);
      parama2.invoke();
      AppMethodBeat.o(253877);
    }
    
    public final void dET() {}
    
    public final void dEU()
    {
      AppMethodBeat.i(253878);
      this.wbm.wbi.pause();
      parama1.invoke();
      AppMethodBeat.o(253878);
    }
    
    public final void dEV() {}
    
    public final void dEW()
    {
      AppMethodBeat.i(253879);
      paramb.invoke(Long.valueOf(0L));
      AppMethodBeat.o(253879);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.b
 * JD-Core Version:    0.7.0.1
 */