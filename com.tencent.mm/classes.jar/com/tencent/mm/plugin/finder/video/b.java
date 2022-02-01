package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.c;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.h;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.videocomposition.j;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.videocomposition.play.a.a.a;
import com.tencent.mm.videocomposition.play.a.a.b;
import com.tencent.mm.xeffect.effect.EffectManager;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderFakeVideoCoverPreview;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "context", "Landroid/content/Context;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "effectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "playStart", "", "playView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "destroy", "", "getBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "getView", "Landroid/view/View;", "seekTo", "timeMs", "start", "onReady", "Lkotlin/Function0;", "onDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements r
{
  final VideoCompositionPlayView GmD;
  private final c GmE;
  private final EffectManager GmF;
  private long GmG;
  
  public b(Context paramContext, dji paramdji)
  {
    AppMethodBeat.i(334920);
    this.GmF = new EffectManager();
    this.GmD = new VideoCompositionPlayView(paramContext);
    paramdji = paramdji.aaDI;
    paramContext = paramdji;
    if (paramdji == null) {
      paramContext = new afb();
    }
    paramContext.nBT = "";
    paramContext.Uax = false;
    this.GmE = h.e(paramContext);
    this.GmE.start();
    paramContext = h.d(paramContext, this.GmF);
    paramContext.aK((kotlin.g.a.b)this.GmE);
    this.GmD.a(paramContext.getComposition());
    this.GmG = paramContext.Uaw.getPlayStart();
    AppMethodBeat.o(334920);
  }
  
  public final void a(final a<ah> parama1, a<ah> parama2, final kotlin.g.a.b<? super Long, ah> paramb)
  {
    AppMethodBeat.i(334927);
    s.u(parama1, "onReady");
    s.u(parama2, "onDestroy");
    s.u(paramb, "onSeekFrame");
    this.GmD.setPlayerCallback((a.a.a)new a(parama2, this, parama1, paramb));
    AppMethodBeat.o(334927);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(334940);
    this.GmE.destroy();
    this.GmF.destroy();
    this.GmD.release();
    AppMethodBeat.o(334940);
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(334955);
    Bitmap localBitmap = this.GmD.getBitmap();
    AppMethodBeat.o(334955);
    return localBitmap;
  }
  
  public final View getView()
  {
    return (View)this.GmD;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(334934);
    this.GmD.seekTo(this.GmG + paramLong);
    AppMethodBeat.o(334934);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderFakeVideoCoverPreview$start$1", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerFrameCallback;", "onFrame", "", "onPlayCompleted", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements a.a.b
  {
    a(a<ah> parama1, b paramb, a<ah> parama2, kotlin.g.a.b<? super Long, ah> paramb1) {}
    
    public final void fiA()
    {
      AppMethodBeat.i(334705);
      jdField_this.GmD.pause();
      parama1.invoke();
      AppMethodBeat.o(334705);
    }
    
    public final void fiB() {}
    
    public final void fiC()
    {
      AppMethodBeat.i(334715);
      paramb.invoke(Long.valueOf(0L));
      AppMethodBeat.o(334715);
    }
    
    public final void fix() {}
    
    public final void fiy()
    {
      AppMethodBeat.i(334688);
      this.GmH.invoke();
      AppMethodBeat.o(334688);
    }
    
    public final void fiz() {}
    
    public final void qT(long paramLong) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.b
 * JD-Core Version:    0.7.0.1
 */