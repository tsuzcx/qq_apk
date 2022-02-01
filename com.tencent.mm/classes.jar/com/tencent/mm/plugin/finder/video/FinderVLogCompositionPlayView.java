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
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.c;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.aty;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.n;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.videocomposition.play.a;
import com.tencent.mm.videocomposition.play.a.a.a;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.lang.reflect.Field;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderVLogCompositionPlayView;", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "_callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "_isPreviewing", "", "get_isPreviewing", "()Z", "set_isPreviewing", "(Z)V", "effectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "finderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "isFirstTimeStarted", "isInterceptedDetach", "setInterceptedDetach", "isNeverStart", "setNeverStart", "isShouldPlayResume", "setShouldPlayResume", "isShowFullscreen", "setShowFullscreen", "isViewFocused", "setViewFocused", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "mediaId", "", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaInfo", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "originLayer", "", "originSurface", "sessionId", "createPlayer", "", "destroyDrawingCache", "getCurrentPlayMs", "", "getCurrentPlaySecond", "getIsNeverStart", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getPlayStart", "getVideoDuration", "getVideoDurationMs", "getVideoMediaId", "getVideoMediaInfo", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "hookInnerDetach", "isPreviewing", "onAttachedToWindow", "onDetachedFromWindow", "onRelease", "onSurfaceTextureDestroyed", "surface", "Landroid/graphics/SurfaceTexture;", "onUIDestroy", "pause", "pauseWithCancel", "play", "prepareToPlay", "removeVideoFooterView", "seekTo", "seconds", "", "afterPlay", "time", "afterSeekPlay", "setFinderVideoCore", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setIMMVideoViewCallback", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setInterceptDetach", "isInterceptDetach", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", "setMute", "mute", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isLocal", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setVideoMuteListener", "setVideoPlayLifecycle", "setVideoViewFocused", "focused", "start", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "startOrPlay", "stop", "unHookInnerDetach", "Companion", "plugin-finder_release"})
public final class FinderVLogCompositionPlayView
  extends VideoCompositionPlayView
  implements r
{
  public static final a wex;
  private String mediaId;
  private String sessionId;
  private boolean uOq;
  private c wbj;
  private boolean wcA;
  private boolean wcB;
  private volatile boolean wcC;
  private y wcw;
  private s wcy;
  private boolean weo;
  private t wep;
  private i.b weq;
  private cjl wer;
  private boolean wes;
  private EffectManager wet;
  private boolean weu;
  private Object wev;
  private Object wew;
  
  static
  {
    AppMethodBeat.i(254244);
    wex = new a((byte)0);
    AppMethodBeat.o(254244);
  }
  
  public FinderVLogCompositionPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(254243);
    this.wcA = true;
    this.wcC = true;
    this.sessionId = String.valueOf(hashCode());
    this.mediaId = String.valueOf(hashCode());
    this.wes = true;
    setPlayerCallback((a.a.a)new a.a.a()
    {
      private long wem = -1L;
      
      public final void Go(long paramAnonymousLong)
      {
        AppMethodBeat.i(254210);
        y localy = this.wey.getLifecycle();
        if (localy != null)
        {
          FinderVLogCompositionPlayView.f(this.wey);
          FinderVLogCompositionPlayView.g(this.wey);
          this.wey.getVideoDurationMs();
          localy.dFO();
        }
        if ((this.wem == -1L) || (paramAnonymousLong - this.wem > 1000L))
        {
          localy = this.wey.getLifecycle();
          if (localy != null) {
            localy.a(FinderVLogCompositionPlayView.f(this.wey), (int)((paramAnonymousLong - FinderVLogCompositionPlayView.g(this.wey)) / 1000L), this.wey.getVideoDuration());
          }
          this.wem = paramAnonymousLong;
        }
        AppMethodBeat.o(254210);
      }
      
      public final void dER()
      {
        AppMethodBeat.i(254208);
        Object localObject = FinderVLogCompositionPlayView.a(this.wey);
        if (localObject != null) {
          ((i.b)localObject).dK(FinderVLogCompositionPlayView.b(this.wey), FinderVLogCompositionPlayView.c(this.wey));
        }
        if ((FinderVLogCompositionPlayView.d(this.wey)) || (!this.wey.loop))
        {
          localObject = this.wey.getLifecycle();
          if (localObject != null)
          {
            FinderVLogCompositionPlayView.f(this.wey);
            ((y)localObject).dFN();
          }
        }
        for (;;)
        {
          FinderVLogCompositionPlayView.e(this.wey);
          AppMethodBeat.o(254208);
          return;
          if (this.wey.loop)
          {
            localObject = this.wey.getLifecycle();
            if (localObject != null)
            {
              FinderVLogCompositionPlayView.f(this.wey);
              ((y)localObject).dFM();
            }
          }
        }
      }
      
      public final void dES() {}
      
      public final void dET()
      {
        AppMethodBeat.i(254209);
        i.b localb = FinderVLogCompositionPlayView.a(this.wey);
        if (localb != null)
        {
          localb.dI(FinderVLogCompositionPlayView.b(this.wey), FinderVLogCompositionPlayView.c(this.wey));
          AppMethodBeat.o(254209);
          return;
        }
        AppMethodBeat.o(254209);
      }
      
      public final void dEU()
      {
        AppMethodBeat.i(254211);
        Object localObject = FinderVLogCompositionPlayView.a(this.wey);
        if (localObject != null) {
          ((i.b)localObject).fo(FinderVLogCompositionPlayView.b(this.wey), FinderVLogCompositionPlayView.c(this.wey));
        }
        localObject = this.wey.getLifecycle();
        if (localObject != null)
        {
          FinderVLogCompositionPlayView.f(this.wey);
          ((y)localObject).Gr(0L);
          AppMethodBeat.o(254211);
          return;
        }
        AppMethodBeat.o(254211);
      }
      
      public final void dEV()
      {
        AppMethodBeat.i(254212);
        i.b localb = FinderVLogCompositionPlayView.a(this.wey);
        if (localb != null)
        {
          localb.c(FinderVLogCompositionPlayView.b(this.wey), FinderVLogCompositionPlayView.c(this.wey), "", -1, -1);
          AppMethodBeat.o(254212);
          return;
        }
        AppMethodBeat.o(254212);
      }
    });
    AppMethodBeat.o(254243);
  }
  
  public FinderVLogCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254242);
    this.wcA = true;
    this.wcC = true;
    this.sessionId = String.valueOf(hashCode());
    this.mediaId = String.valueOf(hashCode());
    this.wes = true;
    setPlayerCallback((a.a.a)new a.a.a()
    {
      private long wem = -1L;
      
      public final void Go(long paramAnonymousLong)
      {
        AppMethodBeat.i(254210);
        y localy = this.wey.getLifecycle();
        if (localy != null)
        {
          FinderVLogCompositionPlayView.f(this.wey);
          FinderVLogCompositionPlayView.g(this.wey);
          this.wey.getVideoDurationMs();
          localy.dFO();
        }
        if ((this.wem == -1L) || (paramAnonymousLong - this.wem > 1000L))
        {
          localy = this.wey.getLifecycle();
          if (localy != null) {
            localy.a(FinderVLogCompositionPlayView.f(this.wey), (int)((paramAnonymousLong - FinderVLogCompositionPlayView.g(this.wey)) / 1000L), this.wey.getVideoDuration());
          }
          this.wem = paramAnonymousLong;
        }
        AppMethodBeat.o(254210);
      }
      
      public final void dER()
      {
        AppMethodBeat.i(254208);
        Object localObject = FinderVLogCompositionPlayView.a(this.wey);
        if (localObject != null) {
          ((i.b)localObject).dK(FinderVLogCompositionPlayView.b(this.wey), FinderVLogCompositionPlayView.c(this.wey));
        }
        if ((FinderVLogCompositionPlayView.d(this.wey)) || (!this.wey.loop))
        {
          localObject = this.wey.getLifecycle();
          if (localObject != null)
          {
            FinderVLogCompositionPlayView.f(this.wey);
            ((y)localObject).dFN();
          }
        }
        for (;;)
        {
          FinderVLogCompositionPlayView.e(this.wey);
          AppMethodBeat.o(254208);
          return;
          if (this.wey.loop)
          {
            localObject = this.wey.getLifecycle();
            if (localObject != null)
            {
              FinderVLogCompositionPlayView.f(this.wey);
              ((y)localObject).dFM();
            }
          }
        }
      }
      
      public final void dES() {}
      
      public final void dET()
      {
        AppMethodBeat.i(254209);
        i.b localb = FinderVLogCompositionPlayView.a(this.wey);
        if (localb != null)
        {
          localb.dI(FinderVLogCompositionPlayView.b(this.wey), FinderVLogCompositionPlayView.c(this.wey));
          AppMethodBeat.o(254209);
          return;
        }
        AppMethodBeat.o(254209);
      }
      
      public final void dEU()
      {
        AppMethodBeat.i(254211);
        Object localObject = FinderVLogCompositionPlayView.a(this.wey);
        if (localObject != null) {
          ((i.b)localObject).fo(FinderVLogCompositionPlayView.b(this.wey), FinderVLogCompositionPlayView.c(this.wey));
        }
        localObject = this.wey.getLifecycle();
        if (localObject != null)
        {
          FinderVLogCompositionPlayView.f(this.wey);
          ((y)localObject).Gr(0L);
          AppMethodBeat.o(254211);
          return;
        }
        AppMethodBeat.o(254211);
      }
      
      public final void dEV()
      {
        AppMethodBeat.i(254212);
        i.b localb = FinderVLogCompositionPlayView.a(this.wey);
        if (localb != null)
        {
          localb.c(FinderVLogCompositionPlayView.b(this.wey), FinderVLogCompositionPlayView.c(this.wey), "", -1, -1);
          AppMethodBeat.o(254212);
          return;
        }
        AppMethodBeat.o(254212);
      }
    });
    AppMethodBeat.o(254242);
  }
  
  public FinderVLogCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(254241);
    this.wcA = true;
    this.wcC = true;
    this.sessionId = String.valueOf(hashCode());
    this.mediaId = String.valueOf(hashCode());
    this.wes = true;
    setPlayerCallback((a.a.a)new a.a.a()
    {
      private long wem = -1L;
      
      public final void Go(long paramAnonymousLong)
      {
        AppMethodBeat.i(254210);
        y localy = this.wey.getLifecycle();
        if (localy != null)
        {
          FinderVLogCompositionPlayView.f(this.wey);
          FinderVLogCompositionPlayView.g(this.wey);
          this.wey.getVideoDurationMs();
          localy.dFO();
        }
        if ((this.wem == -1L) || (paramAnonymousLong - this.wem > 1000L))
        {
          localy = this.wey.getLifecycle();
          if (localy != null) {
            localy.a(FinderVLogCompositionPlayView.f(this.wey), (int)((paramAnonymousLong - FinderVLogCompositionPlayView.g(this.wey)) / 1000L), this.wey.getVideoDuration());
          }
          this.wem = paramAnonymousLong;
        }
        AppMethodBeat.o(254210);
      }
      
      public final void dER()
      {
        AppMethodBeat.i(254208);
        Object localObject = FinderVLogCompositionPlayView.a(this.wey);
        if (localObject != null) {
          ((i.b)localObject).dK(FinderVLogCompositionPlayView.b(this.wey), FinderVLogCompositionPlayView.c(this.wey));
        }
        if ((FinderVLogCompositionPlayView.d(this.wey)) || (!this.wey.loop))
        {
          localObject = this.wey.getLifecycle();
          if (localObject != null)
          {
            FinderVLogCompositionPlayView.f(this.wey);
            ((y)localObject).dFN();
          }
        }
        for (;;)
        {
          FinderVLogCompositionPlayView.e(this.wey);
          AppMethodBeat.o(254208);
          return;
          if (this.wey.loop)
          {
            localObject = this.wey.getLifecycle();
            if (localObject != null)
            {
              FinderVLogCompositionPlayView.f(this.wey);
              ((y)localObject).dFM();
            }
          }
        }
      }
      
      public final void dES() {}
      
      public final void dET()
      {
        AppMethodBeat.i(254209);
        i.b localb = FinderVLogCompositionPlayView.a(this.wey);
        if (localb != null)
        {
          localb.dI(FinderVLogCompositionPlayView.b(this.wey), FinderVLogCompositionPlayView.c(this.wey));
          AppMethodBeat.o(254209);
          return;
        }
        AppMethodBeat.o(254209);
      }
      
      public final void dEU()
      {
        AppMethodBeat.i(254211);
        Object localObject = FinderVLogCompositionPlayView.a(this.wey);
        if (localObject != null) {
          ((i.b)localObject).fo(FinderVLogCompositionPlayView.b(this.wey), FinderVLogCompositionPlayView.c(this.wey));
        }
        localObject = this.wey.getLifecycle();
        if (localObject != null)
        {
          FinderVLogCompositionPlayView.f(this.wey);
          ((y)localObject).Gr(0L);
          AppMethodBeat.o(254211);
          return;
        }
        AppMethodBeat.o(254211);
      }
      
      public final void dEV()
      {
        AppMethodBeat.i(254212);
        i.b localb = FinderVLogCompositionPlayView.a(this.wey);
        if (localb != null)
        {
          localb.c(FinderVLogCompositionPlayView.b(this.wey), FinderVLogCompositionPlayView.c(this.wey), "", -1, -1);
          AppMethodBeat.o(254212);
          return;
        }
        AppMethodBeat.o(254212);
      }
    });
    AppMethodBeat.o(254241);
  }
  
  private void dFv()
  {
    AppMethodBeat.i(254237);
    try
    {
      Log.i("MicroMsg.FinderVLogCompositionPlayView", "hookInnerDetach");
      Field localField = TextureView.class.getDeclaredField("mLayer");
      p.g(localField, "TextureView::class.java.getDeclaredField(\"mLayer\")");
      localField.setAccessible(true);
      this.wev = localField.get(this);
      localField.set(this, null);
      localField = TextureView.class.getDeclaredField("mSurface");
      p.g(localField, "TextureView::class.java.…DeclaredField(\"mSurface\")");
      localField.setAccessible(true);
      this.wew = localField.get(this);
      localField.set(this, null);
      AppMethodBeat.o(254237);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FinderVLogCompositionPlayView", (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(254237);
    }
  }
  
  private void dFw()
  {
    AppMethodBeat.i(254238);
    try
    {
      Log.i("MicroMsg.FinderVLogCompositionPlayView", "unHookInnerDetach");
      Field localField;
      if (this.wev != null)
      {
        localField = TextureView.class.getDeclaredField("mLayer");
        p.g(localField, "TextureView::class.java.getDeclaredField(\"mLayer\")");
        localField.setAccessible(true);
        localField.set(this, this.wev);
        this.wev = null;
      }
      if (this.wew != null)
      {
        localField = TextureView.class.getDeclaredField("mSurface");
        p.g(localField, "TextureView::class.java.…DeclaredField(\"mSurface\")");
        localField.setAccessible(true);
        localField.set(this, this.wew);
        this.wew = null;
        AppMethodBeat.o(254238);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FinderVLogCompositionPlayView", (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(254238);
    }
  }
  
  private final long getPlayStart()
  {
    AppMethodBeat.i(254235);
    n localn = getComposition();
    if (localn != null)
    {
      long l = localn.getPlayStart();
      AppMethodBeat.o(254235);
      return l;
    }
    AppMethodBeat.o(254235);
    return 0L;
  }
  
  public final void a(com.tencent.mm.plugin.finder.loader.s params, boolean paramBoolean, FeedData paramFeedData)
  {
    AppMethodBeat.i(254227);
    p.h(params, "video");
    p.h(paramFeedData, "feedData");
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " setVideoMedia video:" + params + ", isLocal:" + paramBoolean);
    this.wer = params.uIw;
    this.mediaId = params.auA();
    this.wcy = new s("", "", this.mediaId, this.wer, params, paramFeedData);
    AppMethodBeat.o(254227);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(254225);
    p.h(paramn, "composition");
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " start");
    if (!this.wcA)
    {
      Log.w("MicroMsg.FinderVLogCompositionPlayView", "isViewFocused=" + this.wcA);
      AppMethodBeat.o(254225);
      return;
    }
    if (this.wcC)
    {
      y localy = this.wcw;
      if (localy != null) {
        localy.a(this.wcy, 0);
      }
    }
    if (this.isStarted) {
      if (!isPlaying()) {
        super.resume();
      }
    }
    for (;;)
    {
      this.wcC = false;
      AppMethodBeat.o(254225);
      return;
      super.a(paramn);
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(254233);
    super.seekTo((1000.0D * paramDouble) + getPlayStart());
    if (paramBoolean) {
      dFj();
    }
    AppMethodBeat.o(254233);
    return true;
  }
  
  public final boolean dEN()
  {
    return false;
  }
  
  public final boolean dEO()
  {
    return this.weo;
  }
  
  public final boolean dFj()
  {
    Object localObject3 = null;
    AppMethodBeat.i(254224);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " startOrPlay, " + this.isStarted + ", " + isPlaying());
    boolean bool = this.wcC;
    if (!this.isStarted) {
      setFirstFrame(true);
    }
    Object localObject1;
    Object localObject2;
    ac localac;
    if (getComposition() == null)
    {
      localObject1 = this.wbj;
      if (localObject1 != null) {
        ((c)localObject1).destroy();
      }
      this.wbj = null;
      localObject1 = this.wet;
      if (localObject1 != null) {
        ((EffectManager)localObject1).destroy();
      }
      this.wet = null;
      localObject1 = this.wer;
      if (localObject1 != null)
      {
        localObject1 = ((cjl)localObject1).MfU;
        if (localObject1 != null)
        {
          this.wbj = i.d((acn)localObject1);
          localObject2 = this.wbj;
          if (localObject2 != null) {
            ((c)localObject2).start();
          }
          localObject2 = new EffectManager();
          this.wet = ((EffectManager)localObject2);
          localac = i.d((acn)localObject1, (EffectManager)localObject2);
          Object localObject4 = this.wcy;
          localObject2 = localObject3;
          if (localObject4 != null)
          {
            localObject4 = ((s)localObject4).wgl;
            localObject2 = localObject3;
            if (localObject4 != null) {
              localObject2 = ((cjl)localObject4).MoU;
            }
          }
          if ((localObject2 != null) && (((aty)localObject2).right > ((aty)localObject2).left) && (((aty)localObject2).bottom > ((aty)localObject2).top))
          {
            if (!this.uOq) {
              break label336;
            }
            localObject2 = localac.Gez.hfq();
            localac.q(new Rect(0, 0, ((Size)localObject2).getWidth(), ((Size)localObject2).getHeight()));
          }
          label281:
          localObject2 = this.wbj;
          if (localObject2 == null) {
            p.hyc();
          }
          localac.O((kotlin.g.a.b)localObject2);
          localac.acz(((acn)localObject1).Gxw.fps);
          a(localac.getComposition());
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(254224);
      return bool;
      localObject1 = null;
      break;
      label336:
      if ((((aty)localObject2).right <= ((aty)localObject2).left) || (((aty)localObject2).bottom <= ((aty)localObject2).top)) {
        break label281;
      }
      localac.q(new Rect((int)((aty)localObject2).left, (int)((aty)localObject2).top, (int)((aty)localObject2).right, (int)((aty)localObject2).bottom));
      break label281;
      if (!isPlaying()) {
        resume();
      }
    }
  }
  
  public final int dFk()
  {
    AppMethodBeat.i(254214);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  pauseWithCancel");
    this.wcy = null;
    super.pause();
    AppMethodBeat.o(254214);
    return 0;
  }
  
  public final void dFl() {}
  
  public final void dFu()
  {
    AppMethodBeat.i(254213);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " createPlayer");
    super.dFu();
    Object localObject = this.weq;
    if (localObject != null) {
      ((i.b)localObject).dH(this.sessionId, this.mediaId);
    }
    localObject = getComposition();
    if (localObject != null) {
      localObject = ((n)localObject).hfq();
    }
    while (localObject != null)
    {
      i.b localb = this.weq;
      if (localb != null)
      {
        localb.d(this.sessionId, this.mediaId, ((Size)localObject).getWidth(), ((Size)localObject).getHeight());
        AppMethodBeat.o(254213);
        return;
        localObject = null;
      }
      else
      {
        AppMethodBeat.o(254213);
        return;
      }
    }
    AppMethodBeat.o(254213);
  }
  
  public final void destroyDrawingCache()
  {
    AppMethodBeat.i(254239);
    super.destroyDrawingCache();
    if (this.weu) {
      dFw();
    }
    AppMethodBeat.o(254239);
  }
  
  public final long getCurrentPlayMs()
  {
    AppMethodBeat.i(254217);
    a locala = getPlayer();
    if (locala != null) {}
    for (long l1 = locala.hfu();; l1 = 0L)
    {
      long l2 = getPlayStart();
      AppMethodBeat.o(254217);
      return l1 - l2;
    }
  }
  
  public final int getCurrentPlaySecond()
  {
    AppMethodBeat.i(254216);
    a locala = getPlayer();
    if (locala != null) {}
    for (long l = locala.hfu();; l = 0L)
    {
      int i = (int)(l - getPlayStart()) / 1000;
      AppMethodBeat.o(254216);
      return i;
    }
  }
  
  public final boolean getIsNeverStart()
  {
    return this.wcC;
  }
  
  public final boolean getIsShouldPlayResume()
  {
    return this.wcB;
  }
  
  public final y getLifecycle()
  {
    return this.wcw;
  }
  
  public final s getMediaInfo()
  {
    return this.wcy;
  }
  
  public final t getMuteListener()
  {
    return this.wep;
  }
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(254220);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(254220);
    return localViewParent;
  }
  
  public final int getVideoDuration()
  {
    AppMethodBeat.i(254218);
    n localn = getComposition();
    if (localn != null) {}
    for (long l = localn.getDurationMs();; l = 0L)
    {
      int i = (int)l / 1000;
      AppMethodBeat.o(254218);
      return i;
    }
  }
  
  public final long getVideoDurationMs()
  {
    AppMethodBeat.i(254219);
    n localn = getComposition();
    if (localn != null)
    {
      long l = localn.getDurationMs();
      AppMethodBeat.o(254219);
      return l;
    }
    AppMethodBeat.o(254219);
    return 0L;
  }
  
  public final String getVideoMediaId()
  {
    s locals = this.wcy;
    if (locals != null) {
      return locals.mediaId;
    }
    return null;
  }
  
  public final s getVideoMediaInfo()
  {
    return this.wcy;
  }
  
  public final View getVideoView()
  {
    return (View)this;
  }
  
  public final boolean getVideoViewFocused()
  {
    return this.wcA;
  }
  
  public final boolean get_isPreviewing()
  {
    return this.weo;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(254240);
    if (this.weu) {
      dFv();
    }
    super.onAttachedToWindow();
    if (this.weu) {
      dFw();
    }
    AppMethodBeat.o(254240);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(254236);
    if (this.weu)
    {
      dFv();
      AppMethodBeat.o(254236);
      return;
    }
    try
    {
      super.onDetachedFromWindow();
      AppMethodBeat.o(254236);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FinderVLogCompositionPlayView", (Throwable)localException, "unkown error", new Object[0]);
      AppMethodBeat.o(254236);
    }
  }
  
  public final void onRelease() {}
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(254234);
    Object localObject = this.wbj;
    if (localObject != null) {
      ((c)localObject).destroy();
    }
    this.wbj = null;
    localObject = this.wet;
    if (localObject != null) {
      ((EffectManager)localObject).destroy();
    }
    this.wet = null;
    setComposition(null);
    boolean bool = super.onSurfaceTextureDestroyed(paramSurfaceTexture);
    setPlayer(null);
    AppMethodBeat.o(254234);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(254223);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " onUIDestroy");
    this.wcA = false;
    release();
    Object localObject = this.wbj;
    if (localObject != null) {
      ((c)localObject).destroy();
    }
    localObject = this.wet;
    if (localObject != null)
    {
      ((EffectManager)localObject).destroy();
      AppMethodBeat.o(254223);
      return;
    }
    AppMethodBeat.o(254223);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(254215);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  pause");
    boolean bool = super.pause();
    Object localObject = this.weq;
    if (localObject != null) {
      ((i.b)localObject).dJ(this.sessionId, this.mediaId);
    }
    localObject = this.wcw;
    if (localObject != null) {
      ((y)localObject).dFL();
    }
    AppMethodBeat.o(254215);
    return bool;
  }
  
  public final boolean play()
  {
    AppMethodBeat.i(254221);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " play");
    if (!this.isStarted)
    {
      localObject = getPlayer();
      if (localObject != null) {
        ((a)localObject).start();
      }
    }
    Object localObject = this.weq;
    if (localObject != null) {
      ((i.b)localObject).dK(this.sessionId, this.mediaId);
    }
    localObject = this.wcw;
    if (localObject != null) {
      ((y)localObject).dFN();
    }
    AppMethodBeat.o(254221);
    return true;
  }
  
  public final void setFinderVideoCore(k paramk) {}
  
  public final void setIMMVideoViewCallback(i.b paramb)
  {
    AppMethodBeat.i(254228);
    p.h(paramb, "_callback");
    this.weq = paramb;
    AppMethodBeat.o(254228);
  }
  
  public final void setIOnlineVideoProxy(com.tencent.mm.modelvideo.b paramb)
  {
    AppMethodBeat.i(254230);
    p.h(paramb, "_proxy");
    AppMethodBeat.o(254230);
  }
  
  public final void setInterceptDetach(boolean paramBoolean)
  {
    this.weu = paramBoolean;
  }
  
  public final void setInterceptedDetach(boolean paramBoolean)
  {
    this.weu = paramBoolean;
  }
  
  public final void setIsShouldPlayResume(boolean paramBoolean)
  {
    this.wcB = paramBoolean;
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean) {}
  
  public final void setLifecycle(y paramy)
  {
    this.wcw = paramy;
  }
  
  public final void setMediaInfo(s params)
  {
    this.wcy = params;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(254222);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  setMute:" + paramBoolean);
    super.DB(paramBoolean);
    AppMethodBeat.o(254222);
  }
  
  public final void setMuteListener(t paramt)
  {
    this.wep = paramt;
  }
  
  public final void setNeverStart(boolean paramBoolean)
  {
    this.wcC = paramBoolean;
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    this.weo = paramBoolean;
  }
  
  public final void setScaleType(i.e parame)
  {
    AppMethodBeat.i(254229);
    p.h(parame, "scaleType");
    AppMethodBeat.o(254229);
  }
  
  public final void setShouldPlayResume(boolean paramBoolean)
  {
    this.wcB = paramBoolean;
  }
  
  public final void setShowFullscreen(boolean paramBoolean)
  {
    this.uOq = paramBoolean;
  }
  
  public final void setVideoMuteListener(t paramt)
  {
    AppMethodBeat.i(254232);
    p.h(paramt, "muteListener");
    this.wep = paramt;
    AppMethodBeat.o(254232);
  }
  
  public final void setVideoPlayLifecycle(y paramy)
  {
    AppMethodBeat.i(254231);
    p.h(paramy, "lifecycle");
    this.wcw = paramy;
    AppMethodBeat.o(254231);
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    this.wcA = paramBoolean;
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.wcA = paramBoolean;
  }
  
  public final void set_isPreviewing(boolean paramBoolean)
  {
    this.weo = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(254226);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " stop");
    super.stop();
    y localy = this.wcw;
    if (localy != null) {
      localy.b(this.wcy);
    }
    this.wcC = true;
    this.wes = true;
    this.wcA = false;
    AppMethodBeat.o(254226);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderVLogCompositionPlayView$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVLogCompositionPlayView
 * JD-Core Version:    0.7.0.1
 */