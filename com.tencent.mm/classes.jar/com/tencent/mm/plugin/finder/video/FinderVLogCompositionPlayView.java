package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.util.Size;
import android.view.TextureView;
import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.c;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.dhd;
import com.tencent.mm.protocal.protobuf.duz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.j;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.videocomposition.play.a.a.a;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.lang.reflect.Field;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderVLogCompositionPlayView;", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "_callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "_isPreviewing", "", "get_isPreviewing", "()Z", "set_isPreviewing", "(Z)V", "effectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "finderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "isFirstTimeStarted", "isFullScreen", "isInterceptedDetach", "setInterceptedDetach", "isNeverStart", "setNeverStart", "isShouldPlayResume", "setShouldPlayResume", "isShowFullscreen", "setShowFullscreen", "isViewFocused", "setViewFocused", "lastPlayTime", "", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "mediaId", "", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaInfo", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "originLayer", "", "originSurface", "sessionId", "createPlayer", "", "destroyDrawingCache", "getCurrentPlayMs", "getCurrentPlaySecond", "getIsNeverStart", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getPlayStart", "getVideoDuration", "getVideoDurationMs", "getVideoMediaId", "getVideoMediaInfo", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "hookInnerDetach", "isFullScreenEnjoy", "isPreviewing", "onAttachedToWindow", "onDetachedFromWindow", "onRelease", "onSurfaceTextureDestroyed", "surface", "Landroid/graphics/SurfaceTexture;", "onUIDestroy", "pause", "pauseWithCancel", "play", "prepareToPlay", "removeVideoFooterView", "reset", "seekTo", "seconds", "", "afterPlay", "timestamp", "afterSeekPlay", "mode", "time", "setFinderVideoPlayTrace", "videoPlayTrace", "Lcom/tencent/mm/plugin/findersdk/trace/FinderVideoPlayTrace;", "setFullScreenEnjoy", "isFull", "setIMMVideoViewCallback", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setInterceptDetach", "isInterceptDetach", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", "setMute", "mute", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "isLocal", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setVideoMuteListener", "setVideoPlayLifecycle", "setVideoViewFocused", "focused", "start", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "startOrPlay", "stop", "unHookInnerDetach", "Companion", "plugin-finder_release"})
public final class FinderVLogCompositionPlayView
  extends VideoCompositionPlayView
  implements s
{
  public static final a ANs;
  private boolean AJP;
  private c AJT;
  private z ALf;
  private t ALh;
  private boolean ALj;
  private boolean ALk;
  private volatile boolean ALl;
  private boolean ANj;
  private u ANk;
  private i.b ANl;
  private csg ANm;
  private boolean ANn;
  private EffectManager ANo;
  private boolean ANp;
  private Object ANq;
  private Object ANr;
  private String mediaId;
  private String sessionId;
  private boolean zAH;
  private long zXq;
  
  static
  {
    AppMethodBeat.i(283539);
    ANs = new a((byte)0);
    AppMethodBeat.o(283539);
  }
  
  public FinderVLogCompositionPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(283538);
    this.ALj = true;
    this.ALl = true;
    this.sessionId = String.valueOf(hashCode());
    this.mediaId = String.valueOf(hashCode());
    this.ANn = true;
    setPlayerCallback((a.a.a)new a.a.a()
    {
      private long ANd = -1L;
      
      public final void Np(long paramAnonymousLong)
      {
        AppMethodBeat.i(279631);
        z localz = this.ANt.getLifecycle();
        if (localz != null)
        {
          FinderVLogCompositionPlayView.f(this.ANt);
          localz.U(paramAnonymousLong - FinderVLogCompositionPlayView.g(this.ANt), this.ANt.getVideoDurationMs());
        }
        if ((this.ANd == -1L) || (paramAnonymousLong - this.ANd > 1000L) || (paramAnonymousLong < this.ANd))
        {
          localz = this.ANt.getLifecycle();
          if (localz != null) {
            localz.a(FinderVLogCompositionPlayView.f(this.ANt), (int)((paramAnonymousLong - FinderVLogCompositionPlayView.g(this.ANt)) / 1000L), this.ANt.getVideoDuration());
          }
          this.ANd = paramAnonymousLong;
        }
        AppMethodBeat.o(279631);
      }
      
      public final void egA()
      {
        AppMethodBeat.i(279629);
        Object localObject = FinderVLogCompositionPlayView.a(this.ANt);
        if (localObject != null) {
          ((i.b)localObject).dV(FinderVLogCompositionPlayView.b(this.ANt), FinderVLogCompositionPlayView.c(this.ANt));
        }
        if ((FinderVLogCompositionPlayView.d(this.ANt)) || (!this.ANt.loop))
        {
          localObject = this.ANt.getLifecycle();
          if (localObject != null)
          {
            FinderVLogCompositionPlayView.f(this.ANt);
            ((z)localObject).dJV();
          }
        }
        for (;;)
        {
          FinderVLogCompositionPlayView.e(this.ANt);
          AppMethodBeat.o(279629);
          return;
          if (this.ANt.loop)
          {
            localObject = this.ANt.getLifecycle();
            if (localObject != null)
            {
              FinderVLogCompositionPlayView.f(this.ANt);
              ((z)localObject).dJU();
            }
          }
        }
      }
      
      public final void egB() {}
      
      public final void egC()
      {
        AppMethodBeat.i(279630);
        i.b localb = FinderVLogCompositionPlayView.a(this.ANt);
        if (localb != null)
        {
          localb.dT(FinderVLogCompositionPlayView.b(this.ANt), FinderVLogCompositionPlayView.c(this.ANt));
          AppMethodBeat.o(279630);
          return;
        }
        AppMethodBeat.o(279630);
      }
      
      public final void egD()
      {
        AppMethodBeat.i(279632);
        Object localObject = FinderVLogCompositionPlayView.a(this.ANt);
        if (localObject != null) {
          ((i.b)localObject).fC(FinderVLogCompositionPlayView.b(this.ANt), FinderVLogCompositionPlayView.c(this.ANt));
        }
        localObject = this.ANt.getLifecycle();
        if (localObject != null)
        {
          FinderVLogCompositionPlayView.f(this.ANt);
          ((z)localObject).Ma(0L);
          AppMethodBeat.o(279632);
          return;
        }
        AppMethodBeat.o(279632);
      }
      
      public final void egE()
      {
        AppMethodBeat.i(279633);
        i.b localb = FinderVLogCompositionPlayView.a(this.ANt);
        if (localb != null)
        {
          localb.c(FinderVLogCompositionPlayView.b(this.ANt), FinderVLogCompositionPlayView.c(this.ANt), "", -1, -1);
          AppMethodBeat.o(279633);
          return;
        }
        AppMethodBeat.o(279633);
      }
    });
    AppMethodBeat.o(283538);
  }
  
  public FinderVLogCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(283537);
    this.ALj = true;
    this.ALl = true;
    this.sessionId = String.valueOf(hashCode());
    this.mediaId = String.valueOf(hashCode());
    this.ANn = true;
    setPlayerCallback((a.a.a)new a.a.a()
    {
      private long ANd = -1L;
      
      public final void Np(long paramAnonymousLong)
      {
        AppMethodBeat.i(279631);
        z localz = this.ANt.getLifecycle();
        if (localz != null)
        {
          FinderVLogCompositionPlayView.f(this.ANt);
          localz.U(paramAnonymousLong - FinderVLogCompositionPlayView.g(this.ANt), this.ANt.getVideoDurationMs());
        }
        if ((this.ANd == -1L) || (paramAnonymousLong - this.ANd > 1000L) || (paramAnonymousLong < this.ANd))
        {
          localz = this.ANt.getLifecycle();
          if (localz != null) {
            localz.a(FinderVLogCompositionPlayView.f(this.ANt), (int)((paramAnonymousLong - FinderVLogCompositionPlayView.g(this.ANt)) / 1000L), this.ANt.getVideoDuration());
          }
          this.ANd = paramAnonymousLong;
        }
        AppMethodBeat.o(279631);
      }
      
      public final void egA()
      {
        AppMethodBeat.i(279629);
        Object localObject = FinderVLogCompositionPlayView.a(this.ANt);
        if (localObject != null) {
          ((i.b)localObject).dV(FinderVLogCompositionPlayView.b(this.ANt), FinderVLogCompositionPlayView.c(this.ANt));
        }
        if ((FinderVLogCompositionPlayView.d(this.ANt)) || (!this.ANt.loop))
        {
          localObject = this.ANt.getLifecycle();
          if (localObject != null)
          {
            FinderVLogCompositionPlayView.f(this.ANt);
            ((z)localObject).dJV();
          }
        }
        for (;;)
        {
          FinderVLogCompositionPlayView.e(this.ANt);
          AppMethodBeat.o(279629);
          return;
          if (this.ANt.loop)
          {
            localObject = this.ANt.getLifecycle();
            if (localObject != null)
            {
              FinderVLogCompositionPlayView.f(this.ANt);
              ((z)localObject).dJU();
            }
          }
        }
      }
      
      public final void egB() {}
      
      public final void egC()
      {
        AppMethodBeat.i(279630);
        i.b localb = FinderVLogCompositionPlayView.a(this.ANt);
        if (localb != null)
        {
          localb.dT(FinderVLogCompositionPlayView.b(this.ANt), FinderVLogCompositionPlayView.c(this.ANt));
          AppMethodBeat.o(279630);
          return;
        }
        AppMethodBeat.o(279630);
      }
      
      public final void egD()
      {
        AppMethodBeat.i(279632);
        Object localObject = FinderVLogCompositionPlayView.a(this.ANt);
        if (localObject != null) {
          ((i.b)localObject).fC(FinderVLogCompositionPlayView.b(this.ANt), FinderVLogCompositionPlayView.c(this.ANt));
        }
        localObject = this.ANt.getLifecycle();
        if (localObject != null)
        {
          FinderVLogCompositionPlayView.f(this.ANt);
          ((z)localObject).Ma(0L);
          AppMethodBeat.o(279632);
          return;
        }
        AppMethodBeat.o(279632);
      }
      
      public final void egE()
      {
        AppMethodBeat.i(279633);
        i.b localb = FinderVLogCompositionPlayView.a(this.ANt);
        if (localb != null)
        {
          localb.c(FinderVLogCompositionPlayView.b(this.ANt), FinderVLogCompositionPlayView.c(this.ANt), "", -1, -1);
          AppMethodBeat.o(279633);
          return;
        }
        AppMethodBeat.o(279633);
      }
    });
    AppMethodBeat.o(283537);
  }
  
  public FinderVLogCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(283536);
    this.ALj = true;
    this.ALl = true;
    this.sessionId = String.valueOf(hashCode());
    this.mediaId = String.valueOf(hashCode());
    this.ANn = true;
    setPlayerCallback((a.a.a)new a.a.a()
    {
      private long ANd = -1L;
      
      public final void Np(long paramAnonymousLong)
      {
        AppMethodBeat.i(279631);
        z localz = this.ANt.getLifecycle();
        if (localz != null)
        {
          FinderVLogCompositionPlayView.f(this.ANt);
          localz.U(paramAnonymousLong - FinderVLogCompositionPlayView.g(this.ANt), this.ANt.getVideoDurationMs());
        }
        if ((this.ANd == -1L) || (paramAnonymousLong - this.ANd > 1000L) || (paramAnonymousLong < this.ANd))
        {
          localz = this.ANt.getLifecycle();
          if (localz != null) {
            localz.a(FinderVLogCompositionPlayView.f(this.ANt), (int)((paramAnonymousLong - FinderVLogCompositionPlayView.g(this.ANt)) / 1000L), this.ANt.getVideoDuration());
          }
          this.ANd = paramAnonymousLong;
        }
        AppMethodBeat.o(279631);
      }
      
      public final void egA()
      {
        AppMethodBeat.i(279629);
        Object localObject = FinderVLogCompositionPlayView.a(this.ANt);
        if (localObject != null) {
          ((i.b)localObject).dV(FinderVLogCompositionPlayView.b(this.ANt), FinderVLogCompositionPlayView.c(this.ANt));
        }
        if ((FinderVLogCompositionPlayView.d(this.ANt)) || (!this.ANt.loop))
        {
          localObject = this.ANt.getLifecycle();
          if (localObject != null)
          {
            FinderVLogCompositionPlayView.f(this.ANt);
            ((z)localObject).dJV();
          }
        }
        for (;;)
        {
          FinderVLogCompositionPlayView.e(this.ANt);
          AppMethodBeat.o(279629);
          return;
          if (this.ANt.loop)
          {
            localObject = this.ANt.getLifecycle();
            if (localObject != null)
            {
              FinderVLogCompositionPlayView.f(this.ANt);
              ((z)localObject).dJU();
            }
          }
        }
      }
      
      public final void egB() {}
      
      public final void egC()
      {
        AppMethodBeat.i(279630);
        i.b localb = FinderVLogCompositionPlayView.a(this.ANt);
        if (localb != null)
        {
          localb.dT(FinderVLogCompositionPlayView.b(this.ANt), FinderVLogCompositionPlayView.c(this.ANt));
          AppMethodBeat.o(279630);
          return;
        }
        AppMethodBeat.o(279630);
      }
      
      public final void egD()
      {
        AppMethodBeat.i(279632);
        Object localObject = FinderVLogCompositionPlayView.a(this.ANt);
        if (localObject != null) {
          ((i.b)localObject).fC(FinderVLogCompositionPlayView.b(this.ANt), FinderVLogCompositionPlayView.c(this.ANt));
        }
        localObject = this.ANt.getLifecycle();
        if (localObject != null)
        {
          FinderVLogCompositionPlayView.f(this.ANt);
          ((z)localObject).Ma(0L);
          AppMethodBeat.o(279632);
          return;
        }
        AppMethodBeat.o(279632);
      }
      
      public final void egE()
      {
        AppMethodBeat.i(279633);
        i.b localb = FinderVLogCompositionPlayView.a(this.ANt);
        if (localb != null)
        {
          localb.c(FinderVLogCompositionPlayView.b(this.ANt), FinderVLogCompositionPlayView.c(this.ANt), "", -1, -1);
          AppMethodBeat.o(279633);
          return;
        }
        AppMethodBeat.o(279633);
      }
    });
    AppMethodBeat.o(283536);
  }
  
  private void ehj()
  {
    AppMethodBeat.i(283532);
    try
    {
      Log.i("MicroMsg.FinderVLogCompositionPlayView", "hookInnerDetach");
      Field localField = TextureView.class.getDeclaredField("mLayer");
      p.j(localField, "TextureView::class.java.getDeclaredField(\"mLayer\")");
      localField.setAccessible(true);
      this.ANq = localField.get(this);
      localField.set(this, null);
      localField = TextureView.class.getDeclaredField("mSurface");
      p.j(localField, "TextureView::class.java.…DeclaredField(\"mSurface\")");
      localField.setAccessible(true);
      this.ANr = localField.get(this);
      localField.set(this, null);
      AppMethodBeat.o(283532);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FinderVLogCompositionPlayView", (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(283532);
    }
  }
  
  private void ehk()
  {
    AppMethodBeat.i(283533);
    try
    {
      Log.i("MicroMsg.FinderVLogCompositionPlayView", "unHookInnerDetach");
      Field localField;
      if (this.ANq != null)
      {
        localField = TextureView.class.getDeclaredField("mLayer");
        p.j(localField, "TextureView::class.java.getDeclaredField(\"mLayer\")");
        localField.setAccessible(true);
        localField.set(this, this.ANq);
        this.ANq = null;
      }
      if (this.ANr != null)
      {
        localField = TextureView.class.getDeclaredField("mSurface");
        p.j(localField, "TextureView::class.java.…DeclaredField(\"mSurface\")");
        localField.setAccessible(true);
        localField.set(this, this.ANr);
        this.ANr = null;
        AppMethodBeat.o(283533);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FinderVLogCompositionPlayView", (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(283533);
    }
  }
  
  private final long getPlayStart()
  {
    AppMethodBeat.i(283530);
    j localj = getComposition();
    if (localj != null)
    {
      long l = localj.getPlayStart();
      AppMethodBeat.o(283530);
      return l;
    }
    AppMethodBeat.o(283530);
    return 0L;
  }
  
  private final void reset()
  {
    this.ALl = true;
    this.ANn = true;
    this.ALj = false;
  }
  
  public final void a(com.tencent.mm.plugin.finder.loader.ac paramac, boolean paramBoolean, FeedData paramFeedData)
  {
    AppMethodBeat.i(283521);
    p.k(paramac, "video");
    p.k(paramFeedData, "feedData");
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " setVideoMedia video:" + paramac + ", isLocal:" + paramBoolean);
    this.ANm = paramac.dJw();
    this.mediaId = paramac.aBv();
    this.ALh = new t("", "", this.mediaId, this.ANm, paramac, paramFeedData);
    AppMethodBeat.o(283521);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(283517);
    p.k(paramj, "composition");
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " start");
    if (!this.ALj)
    {
      Log.w("MicroMsg.FinderVLogCompositionPlayView", "isViewFocused=" + this.ALj);
      AppMethodBeat.o(283517);
      return;
    }
    if (this.ALl)
    {
      z localz = this.ALf;
      if (localz != null) {
        localz.a(this.ALh, 0);
      }
    }
    if (isStarted()) {
      if (!isPlaying()) {
        super.resume();
      }
    }
    for (;;)
    {
      this.ALl = false;
      AppMethodBeat.o(283517);
      return;
      super.a(paramj);
    }
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(283527);
    super.seekTo((1000.0D * paramDouble) + getPlayStart());
    if (paramBoolean) {
      egV();
    }
    AppMethodBeat.o(283527);
    return true;
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(283528);
    paramBoolean = a(paramDouble, paramBoolean);
    AppMethodBeat.o(283528);
    return paramBoolean;
  }
  
  public final boolean bqo()
  {
    AppMethodBeat.i(283511);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " play");
    if (getComposition() == null)
    {
      egV();
      seekTo(this.zXq);
    }
    for (;;)
    {
      Object localObject = this.ANl;
      if (localObject != null) {
        ((i.b)localObject).dV(this.sessionId, this.mediaId);
      }
      localObject = this.ALf;
      if (localObject != null) {
        ((z)localObject).dJV();
      }
      AppMethodBeat.o(283511);
      return true;
      if (!isStarted())
      {
        localObject = getPlayer();
        if (localObject != null) {
          ((com.tencent.mm.videocomposition.play.a)localObject).start();
        }
      }
    }
  }
  
  public final void destroyDrawingCache()
  {
    AppMethodBeat.i(283534);
    super.destroyDrawingCache();
    if (this.ANp) {
      ehk();
    }
    AppMethodBeat.o(283534);
  }
  
  public final boolean egV()
  {
    AppMethodBeat.i(283516);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " startOrPlay, " + isStarted() + ", " + isPlaying());
    boolean bool = this.ALl;
    if (!isStarted()) {
      setFirstFrame(true);
    }
    Object localObject1;
    Object localObject2;
    label231:
    Object localObject3;
    if (getComposition() == null)
    {
      localObject1 = this.AJT;
      if (localObject1 != null) {
        ((c)localObject1).destroy();
      }
      this.AJT = null;
      localObject1 = this.ANo;
      if (localObject1 != null) {
        ((EffectManager)localObject1).destroy();
      }
      this.ANo = null;
      localObject1 = this.ANm;
      if (localObject1 != null)
      {
        localObject1 = ((csg)localObject1).TpG;
        if (localObject1 != null)
        {
          this.AJT = i.c((acu)localObject1);
          localObject2 = this.AJT;
          if (localObject2 != null) {
            ((c)localObject2).start();
          }
          localObject2 = new EffectManager();
          this.ANo = ((EffectManager)localObject2);
          localObject2 = i.d((acu)localObject1, (EffectManager)localObject2);
          if ((((acu)localObject1).NkX.SoJ != null) || (((acu)localObject1).NkX.SoK != null)) {
            break label286;
          }
          if (this.zAH) {
            ((com.tencent.mm.plugin.vlog.model.ac)localObject2).x(new Rect(0, 0, ((acu)localObject1).NkX.BXA, ((acu)localObject1).NkX.BXB));
          }
          localObject3 = this.AJT;
          if (localObject3 == null) {
            p.iCn();
          }
          ((com.tencent.mm.plugin.vlog.model.ac)localObject2).aa((b)localObject3);
          ((com.tencent.mm.plugin.vlog.model.ac)localObject2).akf(((acu)localObject1).NkX.fps);
          a(((com.tencent.mm.plugin.vlog.model.ac)localObject2).getComposition());
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(283516);
      return bool;
      localObject1 = null;
      break;
      label286:
      if (this.zAH)
      {
        localObject3 = new Rect();
        localduz = ((acu)localObject1).NkX.SoJ.Sro;
        p.j(localduz, "compositionInfo.outputCo…fullScreenConfig.cropRect");
        i.a(localduz, (Rect)localObject3);
        ((com.tencent.mm.plugin.vlog.model.ac)localObject2).x((Rect)localObject3);
        break label231;
      }
      localObject3 = new Rect();
      duz localduz = ((acu)localObject1).NkX.SoK.Sro;
      p.j(localduz, "compositionInfo.outputConfig.cropConfig.cropRect");
      i.a(localduz, (Rect)localObject3);
      ((com.tencent.mm.plugin.vlog.model.ac)localObject2).x((Rect)localObject3);
      break label231;
      if (!isPlaying()) {
        resume();
      }
    }
  }
  
  public final int egW()
  {
    AppMethodBeat.i(283504);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  pauseWithCancel");
    this.ALh = null;
    super.pause();
    AppMethodBeat.o(283504);
    return 0;
  }
  
  public final void egX() {}
  
  public final boolean egw()
  {
    return false;
  }
  
  public final boolean egx()
  {
    return this.ANj;
  }
  
  public final void ehi()
  {
    AppMethodBeat.i(283503);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " createPlayer");
    super.ehi();
    Object localObject = this.ANl;
    if (localObject != null) {
      ((i.b)localObject).dS(this.sessionId, this.mediaId);
    }
    localObject = getComposition();
    if (localObject != null) {
      localObject = ((j)localObject).igJ();
    }
    while (localObject != null)
    {
      i.b localb = this.ANl;
      if (localb != null)
      {
        localb.d(this.sessionId, this.mediaId, ((Size)localObject).getWidth(), ((Size)localObject).getHeight());
        AppMethodBeat.o(283503);
        return;
        localObject = null;
      }
      else
      {
        AppMethodBeat.o(283503);
        return;
      }
    }
    AppMethodBeat.o(283503);
  }
  
  public final long getCurrentPlayMs()
  {
    AppMethodBeat.i(283507);
    com.tencent.mm.videocomposition.play.a locala = getPlayer();
    if (locala != null) {}
    for (long l1 = locala.igQ();; l1 = 0L)
    {
      long l2 = getPlayStart();
      AppMethodBeat.o(283507);
      return l1 - l2;
    }
  }
  
  public final int getCurrentPlaySecond()
  {
    AppMethodBeat.i(283506);
    com.tencent.mm.videocomposition.play.a locala = getPlayer();
    if (locala != null) {}
    for (long l = locala.igQ();; l = 0L)
    {
      int i = (int)(l - getPlayStart()) / 1000;
      AppMethodBeat.o(283506);
      return i;
    }
  }
  
  public final boolean getIsNeverStart()
  {
    return this.ALl;
  }
  
  public final boolean getIsShouldPlayResume()
  {
    return this.ALk;
  }
  
  public final z getLifecycle()
  {
    return this.ALf;
  }
  
  public final t getMediaInfo()
  {
    return this.ALh;
  }
  
  public final u getMuteListener()
  {
    return this.ANk;
  }
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(283510);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(283510);
    return localViewParent;
  }
  
  public final int getVideoDuration()
  {
    AppMethodBeat.i(283508);
    j localj = getComposition();
    if (localj != null) {}
    for (long l = localj.getDurationMs();; l = 0L)
    {
      int i = (int)l / 1000;
      AppMethodBeat.o(283508);
      return i;
    }
  }
  
  public final long getVideoDurationMs()
  {
    AppMethodBeat.i(283509);
    j localj = getComposition();
    if (localj != null)
    {
      long l = localj.getDurationMs();
      AppMethodBeat.o(283509);
      return l;
    }
    AppMethodBeat.o(283509);
    return 0L;
  }
  
  public final String getVideoMediaId()
  {
    t localt = this.ALh;
    if (localt != null) {
      return localt.mediaId;
    }
    return null;
  }
  
  public final t getVideoMediaInfo()
  {
    return this.ALh;
  }
  
  public final View getVideoView()
  {
    return (View)this;
  }
  
  public final boolean getVideoViewFocused()
  {
    return this.ALj;
  }
  
  public final boolean get_isPreviewing()
  {
    return this.ANj;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(283535);
    if (this.ANp) {
      ehj();
    }
    super.onAttachedToWindow();
    if (this.ANp) {
      ehk();
    }
    AppMethodBeat.o(283535);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(283531);
    if (this.ANp)
    {
      ehj();
      AppMethodBeat.o(283531);
      return;
    }
    try
    {
      super.onDetachedFromWindow();
      AppMethodBeat.o(283531);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FinderVLogCompositionPlayView", (Throwable)localException, "unkown error", new Object[0]);
      AppMethodBeat.o(283531);
    }
  }
  
  public final void onRelease() {}
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(283529);
    this.zXq = getCurrentPlayMs();
    Object localObject = this.AJT;
    if (localObject != null) {
      ((c)localObject).destroy();
    }
    this.AJT = null;
    localObject = this.ANo;
    if (localObject != null) {
      ((EffectManager)localObject).destroy();
    }
    this.ANo = null;
    setComposition(null);
    boolean bool = super.onSurfaceTextureDestroyed(paramSurfaceTexture);
    setPlayer(null);
    AppMethodBeat.o(283529);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(283513);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " onUIDestroy");
    this.ALj = false;
    reset();
    release();
    Object localObject = this.AJT;
    if (localObject != null) {
      ((c)localObject).destroy();
    }
    localObject = this.ANo;
    if (localObject != null)
    {
      ((EffectManager)localObject).destroy();
      AppMethodBeat.o(283513);
      return;
    }
    AppMethodBeat.o(283513);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(283505);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  pause");
    boolean bool = super.pause();
    Object localObject = this.ANl;
    if (localObject != null) {
      ((i.b)localObject).dU(this.sessionId, this.mediaId);
    }
    localObject = this.ALf;
    if (localObject != null) {
      ((z)localObject).a(null);
    }
    AppMethodBeat.o(283505);
    return bool;
  }
  
  public final void setFinderVideoPlayTrace(com.tencent.mm.plugin.findersdk.f.a parama) {}
  
  public final void setFullScreenEnjoy(boolean paramBoolean)
  {
    this.AJP = paramBoolean;
  }
  
  public final void setIMMVideoViewCallback(i.b paramb)
  {
    AppMethodBeat.i(283522);
    p.k(paramb, "_callback");
    this.ANl = paramb;
    AppMethodBeat.o(283522);
  }
  
  public final void setIOnlineVideoProxy(f paramf)
  {
    AppMethodBeat.i(283524);
    p.k(paramf, "_proxy");
    AppMethodBeat.o(283524);
  }
  
  public final void setInterceptDetach(boolean paramBoolean)
  {
    this.ANp = paramBoolean;
  }
  
  public final void setInterceptedDetach(boolean paramBoolean)
  {
    this.ANp = paramBoolean;
  }
  
  public final void setIsShouldPlayResume(boolean paramBoolean)
  {
    this.ALk = paramBoolean;
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean) {}
  
  public final void setLifecycle(z paramz)
  {
    this.ALf = paramz;
  }
  
  public final void setMediaInfo(t paramt)
  {
    this.ALh = paramt;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(283512);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  setMute:" + paramBoolean);
    super.Ib(paramBoolean);
    AppMethodBeat.o(283512);
  }
  
  public final void setMuteListener(u paramu)
  {
    this.ANk = paramu;
  }
  
  public final void setNeverStart(boolean paramBoolean)
  {
    this.ALl = paramBoolean;
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    this.ANj = paramBoolean;
  }
  
  public final void setScaleType(i.e parame)
  {
    AppMethodBeat.i(283523);
    p.k(parame, "scaleType");
    AppMethodBeat.o(283523);
  }
  
  public final void setShouldPlayResume(boolean paramBoolean)
  {
    this.ALk = paramBoolean;
  }
  
  public final void setShowFullscreen(boolean paramBoolean)
  {
    this.zAH = paramBoolean;
  }
  
  public final void setVideoMuteListener(u paramu)
  {
    AppMethodBeat.i(283526);
    p.k(paramu, "muteListener");
    this.ANk = paramu;
    AppMethodBeat.o(283526);
  }
  
  public final void setVideoPlayLifecycle(z paramz)
  {
    AppMethodBeat.i(283525);
    p.k(paramz, "lifecycle");
    this.ALf = paramz;
    AppMethodBeat.o(283525);
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    this.ALj = paramBoolean;
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.ALj = paramBoolean;
  }
  
  public final void set_isPreviewing(boolean paramBoolean)
  {
    this.ANj = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(283520);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " stop");
    super.stop();
    z localz = this.ALf;
    if (localz != null) {
      z.a.a(localz, this.ALh);
    }
    reset();
    AppMethodBeat.o(283520);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderVLogCompositionPlayView$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVLogCompositionPlayView
 * JD-Core Version:    0.7.0.1
 */