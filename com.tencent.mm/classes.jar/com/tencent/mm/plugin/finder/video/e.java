package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.f;
import com.tencent.mm.plugin.vlog.model.m;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.player.VLogCompositionPlayView;
import com.tencent.mm.plugin.vlog.player.g.a.a;
import com.tencent.mm.protocal.protobuf.bmd;
import d.g.a.a;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderFakeVideoCoverPreview;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "context", "Landroid/content/Context;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "frameRetriever", "Lcom/tencent/mm/media/mix/FrameSeeker;", "playView", "Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayView;", "destroy", "", "getBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "getView", "Landroid/view/View;", "seekTo", "timeMs", "", "start", "onReady", "Lkotlin/Function0;", "onDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder_release"})
public final class e
  implements n
{
  final VLogCompositionPlayView LbD;
  private final f LbE;
  
  public e(Context paramContext, bmd parambmd)
  {
    AppMethodBeat.i(199713);
    this.LbD = new VLogCompositionPlayView(paramContext);
    paramContext = parambmd.LzL;
    k.g(paramContext, "compositionInfo");
    this.LbE = m.b(paramContext);
    this.LbE.start();
    paramContext = m.a(paramContext);
    paramContext.K((b)this.LbE);
    this.LbD.a(paramContext);
    AppMethodBeat.o(199713);
  }
  
  public final void a(a<y> parama1, a<y> parama2, b<? super Long, y> paramb)
  {
    AppMethodBeat.i(199709);
    k.h(parama1, "onReady");
    k.h(parama2, "onDestroy");
    k.h(paramb, "onSeekFrame");
    this.LbD.setPlayerCallback((g.a.a)new e.a(this, parama2, parama1, paramb));
    AppMethodBeat.o(199709);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(199711);
    this.LbE.destroy();
    this.LbD.release();
    AppMethodBeat.o(199711);
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(199712);
    Bitmap localBitmap = this.LbD.getBitmap();
    AppMethodBeat.o(199712);
    return localBitmap;
  }
  
  public final View getView()
  {
    return (View)this.LbD;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(199710);
    this.LbD.seekTo(paramLong);
    AppMethodBeat.o(199710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.e
 * JD-Core Version:    0.7.0.1
 */