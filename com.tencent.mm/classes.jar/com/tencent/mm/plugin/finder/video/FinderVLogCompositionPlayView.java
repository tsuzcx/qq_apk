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
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.c;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dzm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.j;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.videocomposition.play.a.a.a;
import com.tencent.mm.xeffect.effect.EffectManager;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderVLogCompositionPlayView;", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "Lcom/tencent/mm/plugin/finder/video/IFinderVLogCompositionPlayView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "_callback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "_isPreviewing", "", "get_isPreviewing", "()Z", "set_isPreviewing", "(Z)V", "contextTag", "effectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "finderMedia", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "frameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "isFirstTimeStarted", "isFullScreen", "isInterceptedDetach", "setInterceptedDetach", "isNeverStart", "setNeverStart", "isReplay", "isShouldPlayResume", "setShouldPlayResume", "isShowFullscreen", "setShowFullscreen", "isViewFocused", "setViewFocused", "lastPlayTime", "", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "mediaId", "", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "getMediaInfo", "()Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "setMediaInfo", "(Lcom/tencent/mm/plugin/finder/video/MediaInfo;)V", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "getMuteListener", "()Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setMuteListener", "(Lcom/tencent/mm/plugin/finder/video/OnMuteListener;)V", "originLayer", "", "originSurface", "sessionId", "createPlayer", "", "destroyDrawingCache", "getContextTag", "getCurrentPlayMs", "getCurrentPlaySecond", "getFinderFluentSwitchParams", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams;", "feedId", "getIsNeverStart", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getPlayStart", "getPlayer", "getVideoDuration", "getVideoDurationMs", "getVideoMediaId", "getVideoMediaInfo", "getVideoView", "Landroid/view/View;", "getVideoViewFocused", "hookInnerDetach", "isEnableFluentSwitchExit", "isFullScreenEnjoy", "isPreviewing", "onAttachedToWindow", "onDetachedFromWindow", "onRelease", "onSurfaceTextureDestroyed", "surface", "Landroid/graphics/SurfaceTexture;", "onUIDestroy", "pause", "pauseWithCancel", "play", "prepareToPlay", "prepareforReuse", "removeVideoFooterView", "reset", "seekTo", "seconds", "", "afterPlay", "timestamp", "afterSeekPlay", "mode", "time", "setContextTag", "tag", "setFinderVideoPlayTrace", "videoPlayTrace", "Lcom/tencent/mm/plugin/findersdk/trace/FinderVideoPlayTrace;", "setFullScreenEnjoy", "isFull", "setFullscreen", "setIMMVideoViewCallback", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setInterceptDetach", "isInterceptDetach", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", "setLivePlayer", "txPlayer", "Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "setMute", "mute", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "isLocal", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setVideoMuteListener", "setVideoPlayLifecycle", "setVideoViewFocused", "focused", "start", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "startOrPlay", "offset", "(Ljava/lang/Integer;)Z", "stop", "unHookInnerDetach", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderVLogCompositionPlayView
  extends VideoCompositionPlayView
  implements q
{
  public static final FinderVLogCompositionPlayView.a GpH;
  private v BtQ;
  private boolean ECP;
  private boolean Flq;
  private boolean Flr;
  private boolean Fls;
  private ab Flu;
  private long FsW;
  private c GmE;
  private volatile boolean GnV;
  private boolean GpI;
  private w GpJ;
  private i.b GpK;
  private dji GpL;
  private boolean GpM;
  private boolean GpN;
  private EffectManager GpO;
  private boolean GpP;
  private Object GpQ;
  private Object GpR;
  private int contextTag;
  private String mediaId;
  private String sessionId;
  
  static
  {
    AppMethodBeat.i(335121);
    GpH = new FinderVLogCompositionPlayView.a((byte)0);
    AppMethodBeat.o(335121);
  }
  
  public FinderVLogCompositionPlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(335057);
    this.Flr = true;
    this.GnV = true;
    this.sessionId = String.valueOf(hashCode());
    this.mediaId = String.valueOf(hashCode());
    this.GpM = true;
    this.contextTag = -1;
    setPlayerCallback((a.a.a)new a.a.a()
    {
      private long FlA = -1L;
      
      public final void fiA()
      {
        AppMethodBeat.i(335325);
        Object localObject = FinderVLogCompositionPlayView.a(this.GpS);
        if (localObject != null) {
          ((i.b)localObject).gE(FinderVLogCompositionPlayView.b(this.GpS), FinderVLogCompositionPlayView.c(this.GpS));
        }
        localObject = this.GpS.getLifecycle();
        if (localObject != null)
        {
          FinderVLogCompositionPlayView.e(this.GpS);
          ((ab)localObject).ph(0L);
        }
        AppMethodBeat.o(335325);
      }
      
      public final void fiB()
      {
        AppMethodBeat.i(335333);
        i.b localb = FinderVLogCompositionPlayView.a(this.GpS);
        if (localb != null) {
          localb.d(FinderVLogCompositionPlayView.b(this.GpS), FinderVLogCompositionPlayView.c(this.GpS), "", -1, -1);
        }
        AppMethodBeat.o(335333);
      }
      
      public final void fix()
      {
        AppMethodBeat.i(335300);
        Object localObject = FinderVLogCompositionPlayView.a(this.GpS);
        if (localObject != null) {
          ((i.b)localObject).eo(FinderVLogCompositionPlayView.b(this.GpS), FinderVLogCompositionPlayView.c(this.GpS));
        }
        if ((FinderVLogCompositionPlayView.d(this.GpS)) || (!this.GpS.loop))
        {
          localObject = this.GpS.getLifecycle();
          if (localObject != null)
          {
            FinderVLogCompositionPlayView.e(this.GpS);
            ((ab)localObject).egu();
          }
        }
        FinderVLogCompositionPlayView.f(this.GpS);
        FinderVLogCompositionPlayView.a(this.GpS, false);
        AppMethodBeat.o(335300);
      }
      
      public final void fiy() {}
      
      public final void fiz()
      {
        AppMethodBeat.i(335314);
        i.b localb = FinderVLogCompositionPlayView.a(this.GpS);
        if (localb != null) {
          localb.em(FinderVLogCompositionPlayView.b(this.GpS), FinderVLogCompositionPlayView.c(this.GpS));
        }
        AppMethodBeat.o(335314);
      }
      
      public final void qT(long paramAnonymousLong)
      {
        AppMethodBeat.i(335319);
        ab localab = this.GpS.getLifecycle();
        if (localab != null)
        {
          FinderVLogCompositionPlayView.e(this.GpS);
          localab.ar(paramAnonymousLong - FinderVLogCompositionPlayView.g(this.GpS), this.GpS.getVideoDurationMs());
        }
        if ((this.FlA == -1L) || (paramAnonymousLong - this.FlA > 1000L) || (paramAnonymousLong < this.FlA))
        {
          localab = this.GpS.getLifecycle();
          if (localab != null) {
            localab.a(FinderVLogCompositionPlayView.e(this.GpS), (int)((paramAnonymousLong - FinderVLogCompositionPlayView.g(this.GpS)) / 1000L), this.GpS.getVideoDuration());
          }
          this.FlA = paramAnonymousLong;
        }
        if ((this.GpS.getVideoDurationMs() > 0L) && (paramAnonymousLong > 0L) && (this.GpS.getVideoDurationMs() - paramAnonymousLong <= 500L) && (!FinderVLogCompositionPlayView.h(this.GpS)) && (this.GpS.loop))
        {
          localab = this.GpS.getLifecycle();
          if (localab != null)
          {
            FinderVLogCompositionPlayView.e(this.GpS);
            localab.eCP();
          }
          FinderVLogCompositionPlayView.a(this.GpS, true);
        }
        AppMethodBeat.o(335319);
      }
    });
    AppMethodBeat.o(335057);
  }
  
  public FinderVLogCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(335049);
    this.Flr = true;
    this.GnV = true;
    this.sessionId = String.valueOf(hashCode());
    this.mediaId = String.valueOf(hashCode());
    this.GpM = true;
    this.contextTag = -1;
    setPlayerCallback((a.a.a)new a.a.a()
    {
      private long FlA = -1L;
      
      public final void fiA()
      {
        AppMethodBeat.i(335325);
        Object localObject = FinderVLogCompositionPlayView.a(this.GpS);
        if (localObject != null) {
          ((i.b)localObject).gE(FinderVLogCompositionPlayView.b(this.GpS), FinderVLogCompositionPlayView.c(this.GpS));
        }
        localObject = this.GpS.getLifecycle();
        if (localObject != null)
        {
          FinderVLogCompositionPlayView.e(this.GpS);
          ((ab)localObject).ph(0L);
        }
        AppMethodBeat.o(335325);
      }
      
      public final void fiB()
      {
        AppMethodBeat.i(335333);
        i.b localb = FinderVLogCompositionPlayView.a(this.GpS);
        if (localb != null) {
          localb.d(FinderVLogCompositionPlayView.b(this.GpS), FinderVLogCompositionPlayView.c(this.GpS), "", -1, -1);
        }
        AppMethodBeat.o(335333);
      }
      
      public final void fix()
      {
        AppMethodBeat.i(335300);
        Object localObject = FinderVLogCompositionPlayView.a(this.GpS);
        if (localObject != null) {
          ((i.b)localObject).eo(FinderVLogCompositionPlayView.b(this.GpS), FinderVLogCompositionPlayView.c(this.GpS));
        }
        if ((FinderVLogCompositionPlayView.d(this.GpS)) || (!this.GpS.loop))
        {
          localObject = this.GpS.getLifecycle();
          if (localObject != null)
          {
            FinderVLogCompositionPlayView.e(this.GpS);
            ((ab)localObject).egu();
          }
        }
        FinderVLogCompositionPlayView.f(this.GpS);
        FinderVLogCompositionPlayView.a(this.GpS, false);
        AppMethodBeat.o(335300);
      }
      
      public final void fiy() {}
      
      public final void fiz()
      {
        AppMethodBeat.i(335314);
        i.b localb = FinderVLogCompositionPlayView.a(this.GpS);
        if (localb != null) {
          localb.em(FinderVLogCompositionPlayView.b(this.GpS), FinderVLogCompositionPlayView.c(this.GpS));
        }
        AppMethodBeat.o(335314);
      }
      
      public final void qT(long paramAnonymousLong)
      {
        AppMethodBeat.i(335319);
        ab localab = this.GpS.getLifecycle();
        if (localab != null)
        {
          FinderVLogCompositionPlayView.e(this.GpS);
          localab.ar(paramAnonymousLong - FinderVLogCompositionPlayView.g(this.GpS), this.GpS.getVideoDurationMs());
        }
        if ((this.FlA == -1L) || (paramAnonymousLong - this.FlA > 1000L) || (paramAnonymousLong < this.FlA))
        {
          localab = this.GpS.getLifecycle();
          if (localab != null) {
            localab.a(FinderVLogCompositionPlayView.e(this.GpS), (int)((paramAnonymousLong - FinderVLogCompositionPlayView.g(this.GpS)) / 1000L), this.GpS.getVideoDuration());
          }
          this.FlA = paramAnonymousLong;
        }
        if ((this.GpS.getVideoDurationMs() > 0L) && (paramAnonymousLong > 0L) && (this.GpS.getVideoDurationMs() - paramAnonymousLong <= 500L) && (!FinderVLogCompositionPlayView.h(this.GpS)) && (this.GpS.loop))
        {
          localab = this.GpS.getLifecycle();
          if (localab != null)
          {
            FinderVLogCompositionPlayView.e(this.GpS);
            localab.eCP();
          }
          FinderVLogCompositionPlayView.a(this.GpS, true);
        }
        AppMethodBeat.o(335319);
      }
    });
    AppMethodBeat.o(335049);
  }
  
  public FinderVLogCompositionPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(335042);
    this.Flr = true;
    this.GnV = true;
    this.sessionId = String.valueOf(hashCode());
    this.mediaId = String.valueOf(hashCode());
    this.GpM = true;
    this.contextTag = -1;
    setPlayerCallback((a.a.a)new a.a.a()
    {
      private long FlA = -1L;
      
      public final void fiA()
      {
        AppMethodBeat.i(335325);
        Object localObject = FinderVLogCompositionPlayView.a(this.GpS);
        if (localObject != null) {
          ((i.b)localObject).gE(FinderVLogCompositionPlayView.b(this.GpS), FinderVLogCompositionPlayView.c(this.GpS));
        }
        localObject = this.GpS.getLifecycle();
        if (localObject != null)
        {
          FinderVLogCompositionPlayView.e(this.GpS);
          ((ab)localObject).ph(0L);
        }
        AppMethodBeat.o(335325);
      }
      
      public final void fiB()
      {
        AppMethodBeat.i(335333);
        i.b localb = FinderVLogCompositionPlayView.a(this.GpS);
        if (localb != null) {
          localb.d(FinderVLogCompositionPlayView.b(this.GpS), FinderVLogCompositionPlayView.c(this.GpS), "", -1, -1);
        }
        AppMethodBeat.o(335333);
      }
      
      public final void fix()
      {
        AppMethodBeat.i(335300);
        Object localObject = FinderVLogCompositionPlayView.a(this.GpS);
        if (localObject != null) {
          ((i.b)localObject).eo(FinderVLogCompositionPlayView.b(this.GpS), FinderVLogCompositionPlayView.c(this.GpS));
        }
        if ((FinderVLogCompositionPlayView.d(this.GpS)) || (!this.GpS.loop))
        {
          localObject = this.GpS.getLifecycle();
          if (localObject != null)
          {
            FinderVLogCompositionPlayView.e(this.GpS);
            ((ab)localObject).egu();
          }
        }
        FinderVLogCompositionPlayView.f(this.GpS);
        FinderVLogCompositionPlayView.a(this.GpS, false);
        AppMethodBeat.o(335300);
      }
      
      public final void fiy() {}
      
      public final void fiz()
      {
        AppMethodBeat.i(335314);
        i.b localb = FinderVLogCompositionPlayView.a(this.GpS);
        if (localb != null) {
          localb.em(FinderVLogCompositionPlayView.b(this.GpS), FinderVLogCompositionPlayView.c(this.GpS));
        }
        AppMethodBeat.o(335314);
      }
      
      public final void qT(long paramAnonymousLong)
      {
        AppMethodBeat.i(335319);
        ab localab = this.GpS.getLifecycle();
        if (localab != null)
        {
          FinderVLogCompositionPlayView.e(this.GpS);
          localab.ar(paramAnonymousLong - FinderVLogCompositionPlayView.g(this.GpS), this.GpS.getVideoDurationMs());
        }
        if ((this.FlA == -1L) || (paramAnonymousLong - this.FlA > 1000L) || (paramAnonymousLong < this.FlA))
        {
          localab = this.GpS.getLifecycle();
          if (localab != null) {
            localab.a(FinderVLogCompositionPlayView.e(this.GpS), (int)((paramAnonymousLong - FinderVLogCompositionPlayView.g(this.GpS)) / 1000L), this.GpS.getVideoDuration());
          }
          this.FlA = paramAnonymousLong;
        }
        if ((this.GpS.getVideoDurationMs() > 0L) && (paramAnonymousLong > 0L) && (this.GpS.getVideoDurationMs() - paramAnonymousLong <= 500L) && (!FinderVLogCompositionPlayView.h(this.GpS)) && (this.GpS.loop))
        {
          localab = this.GpS.getLifecycle();
          if (localab != null)
          {
            FinderVLogCompositionPlayView.e(this.GpS);
            localab.eCP();
          }
          FinderVLogCompositionPlayView.a(this.GpS, true);
        }
        AppMethodBeat.o(335319);
      }
    });
    AppMethodBeat.o(335042);
  }
  
  private void fjn()
  {
    AppMethodBeat.i(335066);
    try
    {
      Log.i("MicroMsg.FinderVLogCompositionPlayView", "hookInnerDetach");
      Field localField = TextureView.class.getDeclaredField("mLayer");
      localField.setAccessible(true);
      this.GpQ = localField.get(this);
      localField.set(this, null);
      localField = TextureView.class.getDeclaredField("mSurface");
      localField.setAccessible(true);
      this.GpR = localField.get(this);
      localField.set(this, null);
      AppMethodBeat.o(335066);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FinderVLogCompositionPlayView", (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(335066);
    }
  }
  
  private void fjo()
  {
    AppMethodBeat.i(335077);
    try
    {
      Log.i("MicroMsg.FinderVLogCompositionPlayView", "unHookInnerDetach");
      Field localField;
      if (this.GpQ != null)
      {
        localField = TextureView.class.getDeclaredField("mLayer");
        localField.setAccessible(true);
        localField.set(this, this.GpQ);
        this.GpQ = null;
      }
      if (this.GpR != null)
      {
        localField = TextureView.class.getDeclaredField("mSurface");
        localField.setAccessible(true);
        localField.set(this, this.GpR);
        this.GpR = null;
        AppMethodBeat.o(335077);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FinderVLogCompositionPlayView", (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(335077);
    }
  }
  
  private final long getPlayStart()
  {
    AppMethodBeat.i(335060);
    j localj = getComposition();
    if (localj == null)
    {
      AppMethodBeat.o(335060);
      return 0L;
    }
    long l = localj.getPlayStart();
    AppMethodBeat.o(335060);
    return l;
  }
  
  private final void reset()
  {
    this.GnV = true;
    this.GpM = true;
    this.Flr = false;
  }
  
  public final void a(com.tencent.mm.live.core.core.c.b paramb, long paramLong)
  {
    AppMethodBeat.i(335199);
    s.u(paramb, "txPlayer");
    AppMethodBeat.o(335199);
  }
  
  public final void a(x paramx, boolean paramBoolean, FeedData paramFeedData)
  {
    AppMethodBeat.i(335369);
    s.u(paramx, "video");
    s.u(paramFeedData, "feedData");
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " setVideoMedia video:" + paramx + ", isLocal:" + paramBoolean);
    this.GpL = paramx.eCF();
    this.mediaId = paramx.aUt();
    this.BtQ = new v("", "", this.mediaId, this.GpL, paramx, paramFeedData);
    AppMethodBeat.o(335369);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(335348);
    s.u(paramj, "composition");
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " start");
    if (!this.Flr)
    {
      Log.w("MicroMsg.FinderVLogCompositionPlayView", s.X("isViewFocused=", Boolean.valueOf(this.Flr)));
      AppMethodBeat.o(335348);
      return;
    }
    if (this.GnV)
    {
      ab localab = this.Flu;
      if (localab != null) {
        localab.a(this.BtQ, 0);
      }
    }
    if (isStarted()) {
      if (!isPlaying()) {
        super.resume();
      }
    }
    for (;;)
    {
      this.GnV = false;
      AppMethodBeat.o(335348);
      return;
      super.a(paramj);
    }
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(335457);
    paramBoolean = b(paramDouble, paramBoolean);
    AppMethodBeat.o(335457);
    return paramBoolean;
  }
  
  public final boolean b(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(335449);
    super.seekTo((1000.0D * paramDouble) + getPlayStart());
    if (paramBoolean) {
      ((t)this).r(null);
    }
    AppMethodBeat.o(335449);
    return true;
  }
  
  public final boolean bNU()
  {
    AppMethodBeat.i(335303);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " play");
    if (getComposition() == null)
    {
      ((t)this).r(null);
      seekTo(this.FsW);
    }
    for (;;)
    {
      Object localObject = this.GpK;
      if (localObject != null) {
        ((i.b)localObject).eo(this.sessionId, this.mediaId);
      }
      localObject = this.Flu;
      if (localObject != null) {
        ((ab)localObject).egu();
      }
      AppMethodBeat.o(335303);
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
  
  public final boolean boa()
  {
    return this.GpI;
  }
  
  public final void destroyDrawingCache()
  {
    AppMethodBeat.i(335489);
    super.destroyDrawingCache();
    if (this.GpP) {
      fjo();
    }
    AppMethodBeat.o(335489);
  }
  
  public final boolean eLI()
  {
    return false;
  }
  
  public final int eLK()
  {
    AppMethodBeat.i(335217);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  pauseWithCancel");
    this.BtQ = null;
    super.pause();
    AppMethodBeat.o(335217);
    return 0;
  }
  
  public final void eLL() {}
  
  public final void eLM() {}
  
  public final boolean eLN()
  {
    return false;
  }
  
  public final void fjm()
  {
    AppMethodBeat.i(335208);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " createPlayer");
    super.fjm();
    Object localObject = this.GpK;
    if (localObject != null) {
      ((i.b)localObject).el(this.sessionId, this.mediaId);
    }
    localObject = getComposition();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((j)localObject).jLX())
    {
      if (localObject != null)
      {
        i.b localb = this.GpK;
        if (localb != null) {
          localb.e(this.sessionId, this.mediaId, ((Size)localObject).getWidth(), ((Size)localObject).getHeight());
        }
      }
      AppMethodBeat.o(335208);
      return;
    }
  }
  
  public final int getContextTag()
  {
    return this.contextTag;
  }
  
  public final long getCurrentPlayMs()
  {
    AppMethodBeat.i(335237);
    com.tencent.mm.videocomposition.play.a locala = getPlayer();
    if (locala == null) {}
    for (long l1 = 0L;; l1 = locala.jMf())
    {
      long l2 = getPlayStart();
      AppMethodBeat.o(335237);
      return l1 - l2;
    }
  }
  
  public final int getCurrentPlaySecond()
  {
    AppMethodBeat.i(335233);
    com.tencent.mm.videocomposition.play.a locala = getPlayer();
    if (locala == null) {}
    for (long l = 0L;; l = locala.jMf())
    {
      int i = (int)(l - getPlayStart()) / 1000;
      AppMethodBeat.o(335233);
      return i;
    }
  }
  
  public final boolean getIsNeverStart()
  {
    return this.GnV;
  }
  
  public final boolean getIsShouldPlayResume()
  {
    return this.Fls;
  }
  
  public final ab getLifecycle()
  {
    return this.Flu;
  }
  
  public final v getMediaInfo()
  {
    return this.BtQ;
  }
  
  public final w getMuteListener()
  {
    return this.GpJ;
  }
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(335274);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(335274);
    return localViewParent;
  }
  
  public final Object getPlayer()
  {
    AppMethodBeat.i(335443);
    com.tencent.mm.videocomposition.play.a locala = getPlayer();
    AppMethodBeat.o(335443);
    return locala;
  }
  
  public final int getVideoDuration()
  {
    AppMethodBeat.i(335243);
    j localj = getComposition();
    if (localj == null) {}
    for (long l = 0L;; l = localj.getDurationMs())
    {
      int i = (int)l / 1000;
      AppMethodBeat.o(335243);
      return i;
    }
  }
  
  public final long getVideoDurationMs()
  {
    AppMethodBeat.i(335248);
    j localj = getComposition();
    if (localj == null)
    {
      AppMethodBeat.o(335248);
      return 0L;
    }
    long l = localj.getDurationMs();
    AppMethodBeat.o(335248);
    return l;
  }
  
  public final String getVideoMediaId()
  {
    v localv = this.BtQ;
    if (localv == null) {
      return null;
    }
    return localv.mediaId;
  }
  
  public final v getVideoMediaInfo()
  {
    return this.BtQ;
  }
  
  public final View getVideoView()
  {
    return (View)this;
  }
  
  public final boolean getVideoViewFocused()
  {
    return this.Flr;
  }
  
  public final boolean get_isPreviewing()
  {
    return this.GpI;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(335500);
    if (this.GpP) {
      fjn();
    }
    super.onAttachedToWindow();
    if (this.GpP) {
      fjo();
    }
    AppMethodBeat.o(335500);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(335480);
    if (this.GpP)
    {
      fjn();
      AppMethodBeat.o(335480);
      return;
    }
    try
    {
      super.onDetachedFromWindow();
      AppMethodBeat.o(335480);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.FinderVLogCompositionPlayView", (Throwable)localException, "unkown error", new Object[0]);
      AppMethodBeat.o(335480);
    }
  }
  
  public final void onRelease() {}
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(335465);
    s.u(paramSurfaceTexture, "surface");
    this.FsW = getCurrentPlayMs();
    Object localObject = this.GmE;
    if (localObject != null) {
      ((c)localObject).destroy();
    }
    this.GmE = null;
    localObject = this.GpO;
    if (localObject != null) {
      ((EffectManager)localObject).destroy();
    }
    this.GpO = null;
    setComposition(null);
    boolean bool = super.onSurfaceTextureDestroyed(paramSurfaceTexture);
    setPlayer(null);
    AppMethodBeat.o(335465);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(335323);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " onUIDestroy");
    this.Flr = false;
    reset();
    release();
    Object localObject = this.GmE;
    if (localObject != null) {
      ((c)localObject).destroy();
    }
    localObject = this.GpO;
    if (localObject != null) {
      ((EffectManager)localObject).destroy();
    }
    AppMethodBeat.o(335323);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(335226);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  pause");
    boolean bool = super.pause();
    Object localObject = this.GpK;
    if (localObject != null) {
      ((i.b)localObject).en(this.sessionId, this.mediaId);
    }
    localObject = this.Flu;
    if (localObject != null) {
      ((ab)localObject).a(null);
    }
    AppMethodBeat.o(335226);
    return bool;
  }
  
  public final com.tencent.mm.plugin.finder.live.fluent.h pu(long paramLong)
  {
    return null;
  }
  
  public final boolean r(Integer paramInteger)
  {
    AppMethodBeat.i(335339);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " startOrPlay, " + isStarted() + ", " + isPlaying());
    boolean bool = this.GnV;
    if (!isStarted()) {
      setFirstFrame(true);
    }
    Object localObject1;
    label228:
    Object localObject2;
    if (getComposition() == null)
    {
      paramInteger = this.GmE;
      if (paramInteger != null) {
        paramInteger.destroy();
      }
      this.GmE = null;
      paramInteger = this.GpO;
      if (paramInteger != null) {
        paramInteger.destroy();
      }
      this.GpO = null;
      paramInteger = this.GpL;
      if (paramInteger == null)
      {
        paramInteger = null;
        if (paramInteger != null)
        {
          this.GmE = com.tencent.mm.plugin.vlog.model.h.e(paramInteger);
          localObject1 = this.GmE;
          if (localObject1 != null) {
            ((c)localObject1).start();
          }
          localObject1 = new EffectManager();
          this.GpO = ((EffectManager)localObject1);
          localObject1 = com.tencent.mm.plugin.vlog.model.h.d(paramInteger, (EffectManager)localObject1);
          if ((paramInteger.TYB.Znv != null) || (paramInteger.TYB.Znw != null)) {
            break label283;
          }
          if (this.ECP) {
            ((ac)localObject1).F(new Rect(0, 0, paramInteger.TYB.HJN, paramInteger.TYB.HJO));
          }
          localObject2 = this.GmE;
          s.checkNotNull(localObject2);
          ((ac)localObject1).aK((kotlin.g.a.b)localObject2);
          ((ac)localObject1).apz(paramInteger.TYB.fps);
          a(((ac)localObject1).getComposition());
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(335339);
      return bool;
      paramInteger = paramInteger.aaDI;
      break;
      label283:
      if (this.ECP)
      {
        localObject2 = new Rect();
        com.tencent.mm.plugin.vlog.model.h.a(paramInteger.TYB.Znv.Zqq, (Rect)localObject2);
        ((ac)localObject1).F((Rect)localObject2);
        break label228;
      }
      localObject2 = new Rect();
      com.tencent.mm.plugin.vlog.model.h.a(paramInteger.TYB.Znw.Zqq, (Rect)localObject2);
      ((ac)localObject1).F((Rect)localObject2);
      break label228;
      if (!isPlaying()) {
        resume();
      }
    }
  }
  
  public final void setContextTag(int paramInt)
  {
    this.contextTag = paramInt;
  }
  
  public final void setFinderVideoPlayTrace(com.tencent.mm.plugin.findersdk.f.a parama) {}
  
  public final void setFullScreenEnjoy(boolean paramBoolean)
  {
    this.Flq = paramBoolean;
  }
  
  public final void setFullscreen(boolean paramBoolean)
  {
    this.ECP = paramBoolean;
  }
  
  public final void setIMMVideoViewCallback(i.b paramb)
  {
    AppMethodBeat.i(335385);
    s.u(paramb, "_callback");
    this.GpK = paramb;
    AppMethodBeat.o(335385);
  }
  
  public final void setIOnlineVideoProxy(f paramf)
  {
    AppMethodBeat.i(335391);
    s.u(paramf, "_proxy");
    AppMethodBeat.o(335391);
  }
  
  public final void setInterceptDetach(boolean paramBoolean)
  {
    this.GpP = paramBoolean;
  }
  
  public final void setInterceptedDetach(boolean paramBoolean)
  {
    this.GpP = paramBoolean;
  }
  
  public final void setIsShouldPlayResume(boolean paramBoolean)
  {
    this.Fls = paramBoolean;
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean) {}
  
  public final void setLifecycle(ab paramab)
  {
    this.Flu = paramab;
  }
  
  public final void setMediaInfo(v paramv)
  {
    this.BtQ = paramv;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(335313);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + "  setMute:" + paramBoolean);
    super.NX(paramBoolean);
    AppMethodBeat.o(335313);
  }
  
  public final void setMuteListener(w paramw)
  {
    this.GpJ = paramw;
  }
  
  public final void setNeverStart(boolean paramBoolean)
  {
    this.GnV = paramBoolean;
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    this.GpI = paramBoolean;
  }
  
  public final void setScaleType(i.e parame)
  {
    AppMethodBeat.i(335388);
    s.u(parame, "scaleType");
    AppMethodBeat.o(335388);
  }
  
  public final void setShouldPlayResume(boolean paramBoolean)
  {
    this.Fls = paramBoolean;
  }
  
  public final void setShowFullscreen(boolean paramBoolean)
  {
    this.ECP = paramBoolean;
  }
  
  public final void setVideoMuteListener(w paramw)
  {
    AppMethodBeat.i(335416);
    s.u(paramw, "muteListener");
    this.GpJ = paramw;
    AppMethodBeat.o(335416);
  }
  
  public final void setVideoPlayLifecycle(ab paramab)
  {
    AppMethodBeat.i(335408);
    s.u(paramab, "lifecycle");
    this.Flu = paramab;
    AppMethodBeat.o(335408);
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    this.Flr = paramBoolean;
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.Flr = paramBoolean;
  }
  
  public final void set_isPreviewing(boolean paramBoolean)
  {
    this.GpI = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(335358);
    Log.i("MicroMsg.FinderVLogCompositionPlayView", hashCode() + " stop");
    super.stop();
    ab localab = this.Flu;
    if (localab != null) {
      ab.a.a(localab, this.BtQ);
    }
    reset();
    AppMethodBeat.o(335358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVLogCompositionPlayView
 * JD-Core Version:    0.7.0.1
 */