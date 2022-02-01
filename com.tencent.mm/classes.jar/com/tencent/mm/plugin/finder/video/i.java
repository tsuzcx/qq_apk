package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.view.MMTPEffectVideoLayout;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.videocomposition.effect.EffectRenderView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderOnlineVideoCoverPreview;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoCoverPreview;", "context", "Landroid/content/Context;", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;)V", "videoLayout", "Lcom/tencent/mm/plugin/thumbplayer/view/MMTPEffectVideoLayout;", "destroy", "", "getBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "getResourceLoader", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader;", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "getView", "Landroid/view/View;", "seekTo", "timeMs", "", "start", "onReady", "Lkotlin/Function0;", "onDestroy", "onSeekFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameUs", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  implements r
{
  public final MMTPEffectVideoLayout Goz;
  
  public i(Context paramContext, dji paramdji)
  {
    AppMethodBeat.i(334739);
    this.Goz = new MMTPEffectVideoLayout(paramContext, (byte)0);
    paramContext = new com.tencent.mm.plugin.finder.loader.v(paramdji, com.tencent.mm.plugin.finder.storage.v.FLk, 0, null, 12);
    paramContext = new com.tencent.mm.plugin.thumbplayer.a.b(paramContext.aUt(), paramContext.getPath(), paramContext.getUrl() + '/' + paramContext.eCf(), (int)paramdji.width, (int)paramdji.height);
    paramContext.decodeKey = paramdji.decodeKey;
    this.Goz.fva();
    this.Goz.setMediaInfo(paramContext);
    paramContext = this.Goz.getPlayer();
    if (paramContext != null) {
      paramContext.Flr = true;
    }
    paramContext = this.Goz.getPlayer();
    if (paramContext != null) {
      paramContext.setMute(true);
    }
    paramContext = this.Goz.getPlayer();
    if (paramContext != null) {
      paramContext.hLh();
    }
    AppMethodBeat.o(334739);
  }
  
  public final void a(final a<ah> parama1, a<ah> parama2, kotlin.g.a.b<? super Long, ah> paramb)
  {
    AppMethodBeat.i(334747);
    s.u(parama1, "onReady");
    s.u(parama2, "onDestroy");
    s.u(paramb, "onSeekFrame");
    this.Goz.setOnFirstFrameAvailable((q)new a(this, parama1));
    this.Goz.setOnFrameAvailable((q)new i.b(paramb));
    AppMethodBeat.o(334747);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(334763);
    com.tencent.mm.plugin.thumbplayer.e.b localb = this.Goz.getPlayer();
    if (localb != null) {
      localb.stopAsync();
    }
    localb = this.Goz.getPlayer();
    if (localb != null) {
      localb.recycle();
    }
    this.Goz.TGP.HkF.release();
    AppMethodBeat.o(334763);
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(334778);
    Bitmap localBitmap = this.Goz.getBitmap();
    AppMethodBeat.o(334778);
    return localBitmap;
  }
  
  public final View getView()
  {
    return (View)this.Goz;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(334755);
    com.tencent.mm.plugin.thumbplayer.e.b localb = this.Goz.getPlayer();
    if (localb != null) {
      com.tencent.mm.plugin.thumbplayer.e.b.a(localb, (int)paramLong, true, 4);
    }
    AppMethodBeat.o(334755);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/graphics/SurfaceTexture;", "<anonymous parameter 1>", "", "<anonymous parameter 2>"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements q<SurfaceTexture, Integer, Integer, ah>
  {
    a(i parami, a<ah> parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.i
 * JD-Core Version:    0.7.0.1
 */