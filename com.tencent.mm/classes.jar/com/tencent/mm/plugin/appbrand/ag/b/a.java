package com.tencent.mm.plugin.appbrand.ag.b;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.g.j;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.Vector;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/video/player/LuggageSupportDrmMediaPlayer;", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer2;", "generalPlayerCreator", "Lkotlin/Function0;", "Lcom/tencent/mm/plugin/appbrand/video/player/PlayerCreator;", "drmPlayerCreator", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "anotherPlayer", "curPlayer", "drmPlayer", "drmPlayerPendingActions", "Ljava/util/Vector;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "generalPlayer", "generalPlayerPendingActions", "addOnCompletionListener", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer$OnCompletionListener;", "addOnPreparedListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer$OnPreparedListener;", "addOnSeekCompleteListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer$OnSeekCompleteListener;", "castTo", "PlayerImpl", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "playerClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer;", "doOrAddPendingAction", "name", "", "action", "getCurrentPosition", "", "getDuration", "getPlayerType", "getState", "getVideoHeight", "getVideoWidth", "isPlaying", "", "pause", "prepareAsync", "release", "removeOnCompletionListener", "removeOnPreparedListener", "removeOnSeekCompleteListener", "requireDrmPlayer", "requireGeneralPlayer", "reset", "seekTo", "msc", "", "setDataSource", "path", "referrer", "videoType", "setDataSourceAsync", "onDataSourceSetListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer$OnDataSourceSetListener;", "setDrmDataSource", "sourceUrl", "provisionUrl", "licenseUrl", "setLooping", "looping", "setMute", "mute", "setOnBufferingUpdateListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer$OnBufferingUpdateListener;", "setOnCompletionListener", "setOnDownstreamChangedListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer$OnDownstreamChangedListener;", "setOnErrorListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer$OnErrorListener;", "setOnHitPreloadListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer$OnHitPreloadListener;", "setOnInfoListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer$OnInfoListener;", "setOnPreparedListener", "setOnSeekCompleteListener", "setOnVideoSizeChangedListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer$OnVideoSizeChangedListener;", "setSpeed", "speed", "", "setState", "state", "setSurface", "surface", "Landroid/view/Surface;", "setVolume", "left", "right", "start", "stop", "Companion", "luggage-tp-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.plugin.appbrand.jsapi.video.e.h
{
  public static final a.a usu;
  private com.tencent.mm.plugin.appbrand.jsapi.video.e.h usA;
  private final Vector<b<com.tencent.mm.plugin.appbrand.jsapi.video.e.h, ah>> usB;
  private final Vector<b<com.tencent.mm.plugin.appbrand.jsapi.video.e.h, ah>> usC;
  private final kotlin.g.a.a<com.tencent.mm.plugin.appbrand.jsapi.video.e.h> usv;
  private final kotlin.g.a.a<com.tencent.mm.plugin.appbrand.jsapi.video.e.h> usw;
  private com.tencent.mm.plugin.appbrand.jsapi.video.e.h usx;
  private com.tencent.mm.plugin.appbrand.jsapi.video.e.h usy;
  private com.tencent.mm.plugin.appbrand.jsapi.video.e.h usz;
  
  static
  {
    AppMethodBeat.i(318121);
    usu = new a.a((byte)0);
    AppMethodBeat.o(318121);
  }
  
  public a(kotlin.g.a.a<? extends com.tencent.mm.plugin.appbrand.jsapi.video.e.h> parama1, kotlin.g.a.a<? extends com.tencent.mm.plugin.appbrand.jsapi.video.e.h> parama2)
  {
    AppMethodBeat.i(318057);
    this.usv = parama1;
    this.usw = parama2;
    this.usB = new Vector();
    this.usC = new Vector();
    AppMethodBeat.o(318057);
  }
  
  private static final void a(a parama, String paramString1, String paramString2, g.c paramc)
  {
    AppMethodBeat.i(318117);
    s.u(parama, "this$0");
    s.u(paramString1, "$path");
    parama.ey(paramString1, paramString2);
    if (paramc == null)
    {
      AppMethodBeat.o(318117);
      return;
    }
    d.uiThread((kotlin.g.a.a)new e(paramc));
    AppMethodBeat.o(318117);
  }
  
  private final void aa(b<? super com.tencent.mm.plugin.appbrand.jsapi.video.e.h, ah> paramb)
  {
    AppMethodBeat.i(318067);
    Object localObject = cNP();
    if (localObject == null)
    {
      localObject = null;
      if (localObject == null) {
        ((a)this).usB.add(paramb);
      }
      localObject = cNQ();
      if (localObject != null) {
        break label80;
      }
    }
    for (localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null) {
        ((a)this).usC.add(paramb);
      }
      AppMethodBeat.o(318067);
      return;
      paramb.invoke(localObject);
      localObject = ah.aiuX;
      break;
      label80:
      paramb.invoke(localObject);
    }
  }
  
  private final com.tencent.mm.plugin.appbrand.jsapi.video.e.h cNN()
  {
    AppMethodBeat.i(318080);
    for (;;)
    {
      try
      {
        Object localObject1 = this.usx;
        if (localObject1 != null) {
          break label175;
        }
        localObject1 = this.usv.invoke();
        i = 1;
        this.usx = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.h)localObject1);
        this.usz = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.h)localObject1);
        this.usA = this.usy;
        ??? = ah.aiuX;
        if (i == 0) {
          break label158;
        }
        synchronized (this.usB)
        {
          localObject5 = ((Iterable)this.usB).iterator();
          if (((Iterator)localObject5).hasNext())
          {
            b localb = (b)((Iterator)localObject5).next();
            s.checkNotNull(localObject1);
            localb.invoke(localObject1);
          }
        }
        this.usB.clear();
      }
      finally
      {
        AppMethodBeat.o(318080);
      }
      Object localObject5 = ah.aiuX;
      label158:
      s.checkNotNull(localObject3);
      com.tencent.mm.plugin.appbrand.jsapi.video.e.h localh = (com.tencent.mm.plugin.appbrand.jsapi.video.e.h)localObject3;
      AppMethodBeat.o(318080);
      return localh;
      label175:
      int i = 0;
    }
  }
  
  private final com.tencent.mm.plugin.appbrand.jsapi.video.e.h cNO()
  {
    AppMethodBeat.i(318088);
    for (;;)
    {
      try
      {
        Object localObject1 = this.usy;
        if (localObject1 != null) {
          break label175;
        }
        localObject1 = this.usw.invoke();
        i = 1;
        this.usy = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.h)localObject1);
        this.usz = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.h)localObject1);
        this.usA = this.usx;
        ??? = ah.aiuX;
        if (i == 0) {
          break label158;
        }
        synchronized (this.usC)
        {
          localObject5 = ((Iterable)this.usC).iterator();
          if (((Iterator)localObject5).hasNext())
          {
            b localb = (b)((Iterator)localObject5).next();
            s.checkNotNull(localObject1);
            localb.invoke(localObject1);
          }
        }
        this.usC.clear();
      }
      finally
      {
        AppMethodBeat.o(318088);
      }
      Object localObject5 = ah.aiuX;
      label158:
      s.checkNotNull(localObject3);
      com.tencent.mm.plugin.appbrand.jsapi.video.e.h localh = (com.tencent.mm.plugin.appbrand.jsapi.video.e.h)localObject3;
      AppMethodBeat.o(318088);
      return localh;
      label175:
      int i = 0;
    }
  }
  
  private final com.tencent.mm.plugin.appbrand.jsapi.video.e.h cNP()
  {
    try
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.h localh = this.usx;
      return localh;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private final com.tencent.mm.plugin.appbrand.jsapi.video.e.h cNQ()
  {
    try
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.h localh = this.usy;
      return localh;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private final com.tencent.mm.plugin.appbrand.jsapi.video.e.h cNR()
  {
    try
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.h localh = this.usz;
      return localh;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private final com.tencent.mm.plugin.appbrand.jsapi.video.e.h cNS()
  {
    try
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.e.h localh = this.usA;
      return localh;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void M(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(318143);
    s.u(paramString1, "sourceUrl");
    cNO().M(paramString1, paramString2, paramString3);
    AppMethodBeat.o(318143);
  }
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(318179);
    aa((b)new h(parama));
    AppMethodBeat.o(318179);
  }
  
  public final void a(g.b paramb)
  {
    AppMethodBeat.i(318172);
    aa((b)new i(paramb));
    AppMethodBeat.o(318172);
  }
  
  public final void a(g.d paramd)
  {
    AppMethodBeat.i(318188);
    aa((b)new j(paramd));
    AppMethodBeat.o(318188);
  }
  
  public final void a(g.e parame)
  {
    AppMethodBeat.i(318164);
    aa((b)new k(parame));
    AppMethodBeat.o(318164);
  }
  
  public final void a(g.f paramf)
  {
    AppMethodBeat.i(318191);
    aa((b)new l(paramf));
    AppMethodBeat.o(318191);
  }
  
  public final void a(g.g paramg)
  {
    AppMethodBeat.i(318161);
    aa((b)new m(paramg));
    AppMethodBeat.o(318161);
  }
  
  public final void a(g.h paramh)
  {
    AppMethodBeat.i(318168);
    aa((b)new n(paramh));
    AppMethodBeat.o(318168);
  }
  
  public final void a(g.i parami)
  {
    AppMethodBeat.i(318176);
    aa((b)new o(parami));
    AppMethodBeat.o(318176);
  }
  
  public final void a(g.j paramj)
  {
    AppMethodBeat.i(318183);
    aa((b)new p(paramj));
    AppMethodBeat.o(318183);
  }
  
  public final void a(String paramString1, String paramString2, g.c paramc)
  {
    AppMethodBeat.i(318140);
    s.u(paramString1, "path");
    com.tencent.threadpool.h.ahAA.bm(new a..ExternalSyntheticLambda0(this, paramString1, paramString2, paramc));
    AppMethodBeat.o(318140);
  }
  
  public final <PlayerImpl extends g> PlayerImpl aU(Class<PlayerImpl> paramClass)
  {
    AppMethodBeat.i(318213);
    s.u(paramClass, "playerClass");
    com.tencent.mm.plugin.appbrand.jsapi.video.e.h localh = cNR();
    if (localh == null)
    {
      AppMethodBeat.o(318213);
      return null;
    }
    paramClass = localh.aU(paramClass);
    AppMethodBeat.o(318213);
    return paramClass;
  }
  
  public final void b(g.b paramb)
  {
    AppMethodBeat.i(318202);
    s.u(paramb, "listener");
    aa((b)new b(paramb));
    AppMethodBeat.o(318202);
  }
  
  public final void b(g.h paramh)
  {
    AppMethodBeat.i(318196);
    s.u(paramh, "listener");
    aa((b)new c(paramh));
    AppMethodBeat.o(318196);
  }
  
  public final void b(g.i parami)
  {
    AppMethodBeat.i(318198);
    s.u(parami, "listener");
    aa((b)new d(parami));
    AppMethodBeat.o(318198);
  }
  
  public final boolean bN(float paramFloat)
  {
    AppMethodBeat.i(318300);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.h localh = cNR();
    if (localh == null) {}
    for (boolean bool = false;; bool = localh.bN(paramFloat))
    {
      localh = cNS();
      if (localh != null) {
        localh.bN(paramFloat);
      }
      AppMethodBeat.o(318300);
      return bool;
    }
  }
  
  public final void cM(String paramString, int paramInt)
  {
    AppMethodBeat.i(318132);
    if (paramString == null)
    {
      AppMethodBeat.o(318132);
      return;
    }
    setDataSource(paramString);
    AppMethodBeat.o(318132);
  }
  
  public final void ey(String paramString1, String paramString2)
  {
    AppMethodBeat.i(318138);
    s.u(paramString1, "path");
    cNN().ey(paramString1, paramString2);
    AppMethodBeat.o(318138);
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(318233);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.h localh = cNR();
    if (localh == null)
    {
      AppMethodBeat.o(318233);
      return 0;
    }
    int i = localh.getCurrentPosition();
    AppMethodBeat.o(318233);
    return i;
  }
  
  public final int getDuration()
  {
    AppMethodBeat.i(318228);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.h localh = cNR();
    if (localh == null)
    {
      AppMethodBeat.o(318228);
      return 0;
    }
    int i = localh.getDuration();
    AppMethodBeat.o(318228);
    return i;
  }
  
  public final int getPlayerType()
  {
    AppMethodBeat.i(318209);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.h localh = cNR();
    if (localh == null)
    {
      AppMethodBeat.o(318209);
      return 0;
    }
    int i = localh.getPlayerType();
    AppMethodBeat.o(318209);
    return i;
  }
  
  public final int getState()
  {
    AppMethodBeat.i(318218);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.h localh = cNR();
    if (localh == null)
    {
      AppMethodBeat.o(318218);
      return 0;
    }
    int i = localh.getState();
    AppMethodBeat.o(318218);
    return i;
  }
  
  public final int getVideoHeight()
  {
    AppMethodBeat.i(318246);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.h localh = cNR();
    if (localh == null)
    {
      AppMethodBeat.o(318246);
      return 0;
    }
    int i = localh.getVideoHeight();
    AppMethodBeat.o(318246);
    return i;
  }
  
  public final int getVideoWidth()
  {
    AppMethodBeat.i(318241);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.h localh = cNR();
    if (localh == null)
    {
      AppMethodBeat.o(318241);
      return 0;
    }
    int i = localh.getVideoWidth();
    AppMethodBeat.o(318241);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(318224);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.h localh = cNR();
    if (localh == null)
    {
      AppMethodBeat.o(318224);
      return false;
    }
    boolean bool = localh.isPlaying();
    AppMethodBeat.o(318224);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(318274);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.h localh = cNR();
    if (localh != null) {
      localh.pause();
    }
    AppMethodBeat.o(318274);
  }
  
  public final void prepareAsync()
  {
    AppMethodBeat.i(318260);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.h localh = cNR();
    if (localh != null) {
      localh.prepareAsync();
    }
    AppMethodBeat.o(318260);
  }
  
  public final void release()
  {
    AppMethodBeat.i(318147);
    Object localObject1 = cNP();
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.h)localObject1).release();
    }
    localObject1 = cNQ();
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.video.e.h)localObject1).release();
    }
    try
    {
      this.usx = null;
      this.usy = null;
      this.usz = null;
      this.usA = null;
      localObject1 = ah.aiuX;
      return;
    }
    finally
    {
      AppMethodBeat.o(318147);
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(318307);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.h localh = cNP();
    if (localh != null) {
      localh.reset();
    }
    localh = cNQ();
    if (localh != null) {
      localh.reset();
    }
    AppMethodBeat.o(318307);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(318286);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.h localh = cNR();
    if (localh != null) {
      localh.seekTo(paramLong);
    }
    AppMethodBeat.o(318286);
  }
  
  public final void setDataSource(String paramString)
  {
    AppMethodBeat.i(318129);
    s.u(paramString, "path");
    cNN().setDataSource(paramString);
    AppMethodBeat.o(318129);
  }
  
  public final void setLooping(boolean paramBoolean)
  {
    AppMethodBeat.i(318159);
    aa((b)new f(paramBoolean));
    AppMethodBeat.o(318159);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(318154);
    aa((b)new g(paramBoolean));
    AppMethodBeat.o(318154);
  }
  
  public final void setSurface(Surface paramSurface)
  {
    AppMethodBeat.i(318151);
    aa((b)new q(paramSurface));
    AppMethodBeat.o(318151);
  }
  
  public final void setVolume(float paramFloat1, final float paramFloat2)
  {
    AppMethodBeat.i(318156);
    aa((b)new r(paramFloat1, paramFloat2));
    AppMethodBeat.o(318156);
  }
  
  public final void start()
  {
    AppMethodBeat.i(318267);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.h localh = cNR();
    if (localh != null) {
      localh.start();
    }
    AppMethodBeat.o(318267);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(318291);
    com.tencent.mm.plugin.appbrand.jsapi.video.e.h localh = cNR();
    if (localh != null) {
      localh.stop();
    }
    AppMethodBeat.o(318291);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer2;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<com.tencent.mm.plugin.appbrand.jsapi.video.e.h, ah>
  {
    b(g.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer2;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<com.tencent.mm.plugin.appbrand.jsapi.video.e.h, ah>
  {
    c(g.h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer2;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<com.tencent.mm.plugin.appbrand.jsapi.video.e.h, ah>
  {
    d(g.i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(g.c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer2;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements b<com.tencent.mm.plugin.appbrand.jsapi.video.e.h, ah>
  {
    f(boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer2;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements b<com.tencent.mm.plugin.appbrand.jsapi.video.e.h, ah>
  {
    g(boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer2;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements b<com.tencent.mm.plugin.appbrand.jsapi.video.e.h, ah>
  {
    h(g.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer2;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements b<com.tencent.mm.plugin.appbrand.jsapi.video.e.h, ah>
  {
    i(g.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer2;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements b<com.tencent.mm.plugin.appbrand.jsapi.video.e.h, ah>
  {
    j(g.d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer2;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements b<com.tencent.mm.plugin.appbrand.jsapi.video.e.h, ah>
  {
    k(g.e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer2;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements b<com.tencent.mm.plugin.appbrand.jsapi.video.e.h, ah>
  {
    l(g.f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer2;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements b<com.tencent.mm.plugin.appbrand.jsapi.video.e.h, ah>
  {
    m(g.g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer2;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements b<com.tencent.mm.plugin.appbrand.jsapi.video.e.h, ah>
  {
    n(g.h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer2;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements b<com.tencent.mm.plugin.appbrand.jsapi.video.e.h, ah>
  {
    o(g.i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer2;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends u
    implements b<com.tencent.mm.plugin.appbrand.jsapi.video.e.h, ah>
  {
    p(g.j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer2;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements b<com.tencent.mm.plugin.appbrand.jsapi.video.e.h, ah>
  {
    q(Surface paramSurface)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/player/IMediaPlayer2;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends u
    implements b<com.tencent.mm.plugin.appbrand.jsapi.video.e.h, ah>
  {
    r(float paramFloat1, float paramFloat2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ag.b.a
 * JD-Core Version:    0.7.0.1
 */