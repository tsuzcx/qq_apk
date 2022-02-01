package com.tencent.mm.plugin.flutter.thumbplayer.b;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.c.i.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.thumbplayer.view.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.videocomposition.effect.b.b;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.af;
import com.tencent.thumbplayer.api.ITPPlayer;
import io.flutter.plugin.common.EventChannel.EventSink;
import io.flutter.view.TextureRegistry.SurfaceTextureEntry;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/thumbplayer/player/FlutterTPEffectPlayer;", "Lcom/tencent/mm/videocomposition/effect/EffectRenderController$EffectRenderSurfaceCallback;", "surface", "Lio/flutter/view/TextureRegistry$SurfaceTextureEntry;", "eventSinkProvider", "Lcom/tencent/mm/plugin/flutter/thumbplayer/player/FlutterTPEffectPlayer$TPEventSinkProvider;", "(Lio/flutter/view/TextureRegistry$SurfaceTextureEntry;Lcom/tencent/mm/plugin/flutter/thumbplayer/player/FlutterTPEffectPlayer$TPEventSinkProvider;)V", "TAG", "", "effectMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "Lkotlin/collections/HashMap;", "getEventSinkProvider", "()Lcom/tencent/mm/plugin/flutter/thumbplayer/player/FlutterTPEffectPlayer$TPEventSinkProvider;", "height", "", "isStarted", "", "player", "Lcom/tencent/mm/plugin/flutter/thumbplayer/player/MMMultiSourceCdnTPPlayer;", "playerSurface", "Landroid/view/Surface;", "renderController", "Lcom/tencent/mm/videocomposition/effect/EffectRenderController;", "getSurface", "()Lio/flutter/view/TextureRegistry$SurfaceTextureEntry;", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "textureId", "getTextureId", "()J", "width", "addEffect", "effect", "Lcom/tencent/pigeon/TPPlayerApi$TPPlayerRenderEffect;", "clearEffect", "", "createRenderEffect", "getPlayRange", "Lcom/tencent/mm/plugin/flutter/thumbplayer/player/FlutterTPEffectPlayer$Companion$PlayRange;", "getVideoSize", "Lkotlin/Pair;", "init", "onSurfaceAvailable", "onSurfaceDestroy", "onSurfaceSizeChanged", "onSurfaceUpdate", "pause", "prepare", "recreatePlayer", "release", "removeEffect", "seek", "timeMs", "setLoop", "loop", "setMediaInfo", "mediaInfo", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "loader", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader;", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "setMediaProto", "mediaType", "Lcom/tencent/mm/plugin/flutter/thumbplayer/player/cdn/CdnMediaType;", "mediaProto", "", "setMute", "mute", "setOnFirstFrameRenderedListener", "playerId", "setOnPreparedListener", "setPlayRange", "playRange", "setPlayStartSeek", "setProgressListener", "setScaleType", "scaleType", "setStreamType", "streamType", "start", "stop", "updateEffect", "updateRenderSize", "toEffectType", "Lcom/tencent/mm/plugin/flutter/thumbplayer/player/FlutterTPEffectPlayer$Companion$TPEffectType;", "Companion", "TPEventSinkProvider", "plugin-flutter-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements b.b
{
  public static final a.a HkB;
  public final TextureRegistry.SurfaceTextureEntry HkC;
  final b HkD;
  public final long HkE;
  public final com.tencent.mm.videocomposition.effect.b HkF;
  public b HkG;
  public Surface HkH;
  public HashMap<Long, af> HkI;
  public final String TAG;
  public int height;
  public boolean isStarted;
  public final SurfaceTexture surfaceTexture;
  public int width;
  
  static
  {
    AppMethodBeat.i(263255);
    HkB = new a.a((byte)0);
    com.tencent.mm.videocomposition.d locald = com.tencent.mm.videocomposition.d.agDG;
    com.tencent.mm.videocomposition.d.fXr();
    AppMethodBeat.o(263255);
  }
  
  public a(TextureRegistry.SurfaceTextureEntry paramSurfaceTextureEntry, b paramb)
  {
    AppMethodBeat.i(263230);
    this.HkC = paramSurfaceTextureEntry;
    this.HkD = paramb;
    this.TAG = s.X("MicroMsg.FlutterTPEffectPlayer@", Integer.valueOf(hashCode()));
    paramSurfaceTextureEntry = this.HkC.surfaceTexture();
    s.s(paramSurfaceTextureEntry, "surface.surfaceTexture()");
    this.surfaceTexture = paramSurfaceTextureEntry;
    this.HkE = this.HkC.id();
    this.HkF = new com.tencent.mm.videocomposition.effect.b();
    this.HkI = new HashMap();
    Log.i(this.TAG, s.X("create FlutterTPEffectPlayer,textureId:", Long.valueOf(this.HkE)));
    AppMethodBeat.o(263230);
  }
  
  public final boolean a(i.g paramg)
  {
    AppMethodBeat.i(263267);
    s.u(paramg, "effect");
    paramg = paramg.ahhT;
    paramg = (af)this.HkI.get(paramg);
    if (paramg != null)
    {
      this.HkF.GpO.c(paramg);
      AppMethodBeat.o(263267);
      return true;
    }
    AppMethodBeat.o(263267);
    return false;
  }
  
  public final void b(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(263275);
    Log.i(this.TAG, "onSurfaceAvailable size:[" + paramInt1 + ", " + paramInt2 + ']');
    this.HkH = new Surface(paramSurfaceTexture);
    paramSurfaceTexture = this.HkG;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.b(this.HkH, this.isStarted);
    }
    AppMethodBeat.o(263275);
  }
  
  public final void fva()
  {
    AppMethodBeat.i(263261);
    Object localObject = this.HkG;
    if (localObject != null) {
      ((b)localObject).eLO();
    }
    localObject = this.HkG;
    if (localObject != null) {
      com.tencent.mm.plugin.thumbplayer.e.b.c((com.tencent.mm.plugin.thumbplayer.e.b)localObject);
    }
    localObject = this.HkG;
    if (localObject != null) {
      ((b)localObject).stopAsync();
    }
    localObject = this.HkG;
    if (localObject != null) {
      ((b)localObject).recycle();
    }
    this.HkG = null;
    localObject = MMApplicationContext.getContext();
    s.s(localObject, "getContext()");
    this.HkG = new b((Context)localObject);
    AppMethodBeat.o(263261);
  }
  
  public final void k(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(263281);
    Log.i(this.TAG, "onSurfaceDestroy");
    this.HkH = null;
    paramSurfaceTexture = this.HkG;
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.stop();
    }
    AppMethodBeat.o(263281);
  }
  
  public final void l(SurfaceTexture paramSurfaceTexture) {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/thumbplayer/player/FlutterTPEffectPlayer$TPEventSinkProvider;", "", "getTPEventSink", "Lio/flutter/plugin/common/EventChannel$EventSink;", "plugin-flutter-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract EventChannel.EventSink fvb();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.thumbplayer.e.b, ah>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class e
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.thumbplayer.e.b, ah>
  {
    public e(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/thumbplayer/api/ITPPlayer;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class f
    extends u
    implements kotlin.g.a.b<ITPPlayer, ah>
  {
    public f(long paramLong, a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/thumbplayer/api/ITPPlayer;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class g
    extends u
    implements kotlin.g.a.b<ITPPlayer, ah>
  {
    public g(long paramLong, a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/flutter/thumbplayer/player/FlutterTPEffectPlayer$setProgressListener$1", "Lcom/tencent/mm/plugin/thumbplayer/view/OnPlayerProgressListener;", "onProgress", "", "media", "Lcom/tencent/mm/plugin/thumbplayer/api/TPMediaInfo;", "timeMs", "", "plugin-flutter-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements e
  {
    public h(long paramLong, a parama) {}
    
    public final void a(com.tencent.mm.plugin.thumbplayer.a.b paramb, long paramLong)
    {
      AppMethodBeat.i(263218);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.HkO, paramLong, this.HkN));
      AppMethodBeat.o(263218);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(long paramLong1, long paramLong2, a parama)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.thumbplayer.b.a
 * JD-Core Version:    0.7.0.1
 */