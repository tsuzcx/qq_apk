package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.d.a.a.a.b.b.g;
import com.tencent.d.a.a.a.b.b.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.plugin.finder.live.fluent.h.a;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.replay.a.a;
import com.tencent.mm.plugin.finder.report.r;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.findersdk.a.ao;
import com.tencent.mm.plugin.findersdk.a.au;
import com.tencent.mm.plugin.g;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.bgr;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderLivePlayView;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLivePlayView2;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "contextTag", "curPlayerStatus", "curVideoHeight", "curVideoWidth", "currentFeedId", "", "decorateView", "Landroid/widget/RelativeLayout;", "isAutoJustRenderMode", "", "()Z", "setAutoJustRenderMode", "(Z)V", "isFullScreen", "isLiveFreeTimerInit", "setLiveFreeTimerInit", "isNeverStart", "setNeverStart", "isPause", "isPreviewing", "isShouldPlayResume", "setShouldPlayResume", "isSupportPauseResume", "setSupportPauseResume", "isViewFocused", "setViewFocused", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "liveFeedDecorator", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveFeedDecorator;", "liveFreeTimeManager", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveFreeTimeManager;", "getLiveFreeTimeManager", "()Lcom/tencent/mm/plugin/finder/replay/FinderLiveFreeTimeManager;", "liveFreeTimeManager$delegate", "Lkotlin/Lazy;", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "playListener", "Lcom/tencent/rtmp/ITXLivePlayListener;", "getPlayListener", "()Lcom/tencent/rtmp/ITXLivePlayListener;", "textureView", "Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;", "getTextureView", "()Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;", "setTextureView", "(Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;)V", "txLivePlayer", "Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "getTxLivePlayer", "()Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "setTxLivePlayer", "(Lcom/tencent/mm/live/core/core/player/ILivePlayer;)V", "videoHeight", "videoViewCallback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "getVideoViewCallback", "()Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setVideoViewCallback", "(Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;)V", "videoWidth", "adjustDecorateRoot", "", "videoW", "videoH", "assignIsAutoJustRenderMode", "ret", "assignIsSupportPauseResume", "checkChargeLivePlayPuase", "freeTimeOver", "checkChargeLivePlayStart", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "detachFluentPreviewView", "dismissRenderView", "getBitmap", "Landroid/graphics/Bitmap;", "getContextTag", "getCurrentPlayMs", "getCurrentPlaySecond", "getFinderFluentSwitchParams", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams;", "feedId", "getIsNeverStart", "getIsShouldPlayResume", "getMaskViewResolution", "", "viewWidth", "viewHeight", "ratio", "", "getParentView", "Landroid/view/ViewParent;", "getPlayer", "", "getVideoDuration", "getVideoDurationMs", "getVideoMediaId", "", "getVideoMediaInfo", "getVideoView", "getVideoViewFocused", "init", "initLivePlayer", "txPlayer", "isReuse", "isEnableFluentSwitchExit", "isFullScreenEnjoy", "isLandscapeVideo", "isLinkMicVideo", "isPlaying", "notifyLiveFinish", "onRelease", "onUIDestroy", "pause", "pauseWithCancel", "play", "prepareToPlay", "prepareforReuse", "print", "str", "removePlayer", "removeVideoFooterView", "seekTo", "timestamp", "", "afterSeekPlay", "mode", "setContextTag", "tag", "setFinderVideoPlayTrace", "videoPlayTrace", "Lcom/tencent/mm/plugin/findersdk/trace/FinderVideoPlayTrace;", "setFullScreenEnjoy", "isFull", "setIMMVideoViewCallback", "_callback", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setInterceptDetach", "isInterceptDetach", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", "setLivePlayer", "setLoop", "loop", "setMute", "isMute", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "isLocal", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setVideoMuteListener", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setVideoPlayLifecycle", "setVideoViewFocused", "focused", "showRenderView", "start", "downloadUrl", "startOrPlay", "offset", "(Ljava/lang/Integer;)Z", "stop", "Companion", "LiveTimmerCallback", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLivePlayView
  extends FrameLayout
  implements t, au
{
  public static final FinderLivePlayView.a GnM;
  private v BtQ;
  private i.b EAt;
  private RelativeLayout EKn;
  private long Eac;
  private boolean Flq;
  private boolean Flr;
  private boolean Fls;
  private ab Flu;
  public d GnN;
  boolean GnO;
  private ao GnP;
  private int GnQ;
  private int GnR;
  private boolean GnS;
  private final kotlin.j GnT;
  private final ITXLivePlayListener GnU;
  private volatile boolean GnV;
  private boolean GnW;
  private int contextTag;
  private boolean hJi;
  private com.tencent.mm.live.core.core.c.b mJG;
  private int mUo;
  private boolean nvB;
  private int videoHeight;
  private int videoWidth;
  
  static
  {
    AppMethodBeat.i(335518);
    GnM = new FinderLivePlayView.a((byte)0);
    AppMethodBeat.o(335518);
  }
  
  public FinderLivePlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(335296);
    this.contextTag = -1;
    this.videoWidth = -1;
    this.videoHeight = -1;
    this.GnT = k.cm((kotlin.g.a.a)new c(this));
    this.GnU = ((ITXLivePlayListener)new d(this));
    this.GnV = true;
    init();
    AppMethodBeat.o(335296);
  }
  
  public FinderLivePlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(335301);
    this.contextTag = -1;
    this.videoWidth = -1;
    this.videoHeight = -1;
    this.GnT = k.cm((kotlin.g.a.a)new c(this));
    this.GnU = ((ITXLivePlayListener)new d(this));
    this.GnV = true;
    init();
    AppMethodBeat.o(335301);
  }
  
  public FinderLivePlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(335306);
    this.contextTag = -1;
    this.videoWidth = -1;
    this.videoHeight = -1;
    this.GnT = k.cm((kotlin.g.a.a)new c(this));
    this.GnU = ((ITXLivePlayListener)new d(this));
    this.GnV = true;
    init();
    AppMethodBeat.o(335306);
  }
  
  private final void Xa(String paramString)
  {
    AppMethodBeat.i(335381);
    Log.i("Finder.FinderLivePlayView", hashCode() + " === " + paramString);
    AppMethodBeat.o(335381);
  }
  
  private final void b(com.tencent.mm.live.core.core.c.b paramb)
  {
    AppMethodBeat.i(335324);
    Log.i("Finder.FinderLivePlayView", "initLivePlayer " + paramb + " currentFeedId: " + this.Eac);
    this.mJG = paramb;
    paramb = new TXLivePlayConfig();
    paramb.setAutoAdjustCacheTime(true);
    paramb.setMinAutoAdjustCacheTime(1.0F);
    paramb.setMaxAutoAdjustCacheTime(1.0F);
    paramb.setEnableMessage(true);
    com.tencent.mm.live.core.core.c.b localb = this.mJG;
    if (localb != null) {
      localb.setPlayListener(this.GnU);
    }
    localb = this.mJG;
    if (localb != null) {
      localb.setConfig(paramb);
    }
    paramb = this.mJG;
    if (paramb != null) {
      paramb.setPlayerView((TXCloudVideoView)getTextureView());
    }
    if ((this.videoHeight > this.videoWidth) || (this.videoWidth == 0))
    {
      paramb = this.mJG;
      if (paramb != null) {
        paramb.setRenderMode(0);
      }
    }
    for (;;)
    {
      this.GnP = ((g)com.tencent.mm.kernel.h.ax(g.class)).i((ViewGroup)this.EKn);
      if (isPlaying()) {
        this.GnV = false;
      }
      AppMethodBeat.o(335324);
      return;
      paramb = this.mJG;
      if (paramb != null) {
        paramb.setRenderMode(1);
      }
    }
  }
  
  private final boolean e(bip parambip)
  {
    AppMethodBeat.i(335341);
    if (((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).isUnPurchasedChargeLive(parambip))
    {
      Object localObject = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveChargeInfoStorage();
      long l;
      int i;
      if (parambip == null)
      {
        l = 0L;
        i = ((com.tencent.d.a.a.a.d.b)localObject).ov(l);
        localObject = new StringBuilder("checkChargeLivePlayStart live is charge live:");
        if (parambip != null) {
          break label168;
        }
      }
      label168:
      for (parambip = null;; parambip = Long.valueOf(parambip.liveId))
      {
        parambip = ((StringBuilder)localObject).append(parambip).append(",totalFreeTimeToWatch:");
        localObject = com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.Eci;
        Log.i("Finder.FinderLivePlayView", com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.eyn() + ",usedTime:" + i);
        parambip = com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.Eci;
        if (com.tencent.mm.plugin.finder.live.viewmodel.data.business.d.eyn() <= i) {
          break label179;
        }
        if (getLiveFreeTimeManager().eLs()) {
          Log.i("Finder.FinderLivePlayView", "charge live timer is running!");
        }
        getLiveFreeTimeManager().exT();
        AppMethodBeat.o(335341);
        return true;
        l = parambip.liveId;
        break;
      }
      label179:
      parambip = this.mJG;
      if (parambip != null) {
        parambip.fD(false);
      }
      fiR();
      AppMethodBeat.o(335341);
      return false;
    }
    Log.i("Finder.FinderLivePlayView", "checkChargeLivePlayStart live is normal live!");
    AppMethodBeat.o(335341);
    return true;
  }
  
  private final void fiO()
  {
    AppMethodBeat.i(335331);
    Object localObject = com.tencent.mm.plugin.finder.live.fluent.a.CCh;
    if (!com.tencent.mm.plugin.finder.live.fluent.a.ejm())
    {
      AppMethodBeat.o(335331);
      return;
    }
    localObject = findViewWithTag("nearby-live-fluent-preview-view-tag");
    if (localObject != null) {
      removeView((View)localObject);
    }
    AppMethodBeat.o(335331);
  }
  
  private final void fiR()
  {
    AppMethodBeat.i(335386);
    Xa("notifyLiveFinish");
    Object localObject = this.BtQ;
    if (localObject != null)
    {
      localObject = ((v)localObject).AWA;
      if (localObject != null)
      {
        if localif = new if();
        localif.hJB.id = ((FeedData)localObject).getLiveId();
        localif.hJB.username = ((FeedData)localObject).getUserName();
        localif.hJB.liveStatus = 2;
        localif.hJB.hJD = ((FeedData)localObject).getPosition();
        localif.hJB.type = 19;
        localif.publish();
      }
    }
    AppMethodBeat.o(335386);
  }
  
  private final com.tencent.mm.plugin.finder.replay.a getLiveFreeTimeManager()
  {
    AppMethodBeat.i(335288);
    com.tencent.mm.plugin.finder.replay.a locala = (com.tencent.mm.plugin.finder.replay.a)this.GnT.getValue();
    AppMethodBeat.o(335288);
    return locala;
  }
  
  private static boolean hE(int paramInt1, int paramInt2)
  {
    bool2 = false;
    AppMethodBeat.i(335390);
    Log.i("Finder.FinderLivePlayView", "isLinkMicVideo videoWidth:" + paramInt1 + ",videoHeight:" + paramInt2);
    bool1 = bool2;
    if (paramInt1 > 0)
    {
      bool1 = bool2;
      if (paramInt2 <= 0) {}
    }
    for (;;)
    {
      try
      {
        float f = new BigDecimal(paramInt1 / paramInt2).setScale(1, 4).floatValue();
        if (f != 1.1F) {
          continue;
        }
        paramInt1 = 1;
        if (paramInt1 == 0)
        {
          if (f != 1.0F) {
            continue;
          }
          paramInt1 = 1;
          bool1 = bool2;
          if (paramInt1 == 0) {}
        }
        else
        {
          bool1 = true;
        }
      }
      catch (Exception localException)
      {
        Log.w("Finder.FinderLivePlayView", s.X("ex:", localException.getMessage()));
        bool1 = bool2;
        continue;
      }
      AppMethodBeat.o(335390);
      return bool1;
      paramInt1 = 0;
      continue;
      paramInt1 = 0;
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(335316);
    Object localObject = getContext();
    s.s(localObject, "context");
    setTextureView(new d((Context)localObject));
    localObject = new FrameLayout.LayoutParams(-1, -1);
    addView((View)getTextureView(), (ViewGroup.LayoutParams)localObject);
    this.EKn = new RelativeLayout(getContext());
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    addView((View)this.EKn, (ViewGroup.LayoutParams)localObject);
    localObject = getContext();
    s.s(localObject, "context");
    b((com.tencent.mm.live.core.core.c.b)new com.tencent.mm.live.core.core.c.a((Context)localObject));
    AppMethodBeat.o(335316);
  }
  
  private final void start(String paramString)
  {
    boolean bool1 = false;
    Object localObject2 = null;
    AppMethodBeat.i(335375);
    Object localObject1 = this.BtQ;
    if (localObject1 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      boolean bool2 = e((bip)localObject1);
      Xa("start,canPlay:" + bool2 + ", " + paramString);
      if (bool2) {
        break;
      }
      AppMethodBeat.o(335375);
      return;
      localObject1 = ((v)localObject1).AWA;
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((FeedData)localObject1).getLiveInfo();
      }
    }
    com.tencent.mm.live.core.core.c.b localb;
    com.tencent.d.a.a.a.a.a locala;
    if ((this.hJi) && (this.GnW))
    {
      localb = this.mJG;
      if (localb != null)
      {
        localObject1 = com.tencent.mm.live.core.d.a.mWH;
        localObject1 = this.BtQ;
        if (localObject1 == null)
        {
          localObject1 = null;
          localObject1 = com.tencent.mm.live.core.d.a.a((bip)localObject1, paramString);
          locala = com.tencent.d.a.a.a.a.a.ahiX;
          if (((Number)com.tencent.d.a.a.a.a.a.jUp().bmg()).intValue() != 1) {
            break label272;
          }
          bool1 = true;
          label180:
          localb.D((String)localObject1, bool1);
        }
      }
      else
      {
        localObject1 = this.mJG;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.c.b)localObject1).Y(paramString, 1);
        }
        paramString = com.tencent.mm.plugin.finder.live.report.j.Dob;
        localObject1 = q.w.DwP;
        paramString = this.BtQ;
        if (paramString != null) {
          break label439;
        }
      }
    }
    label272:
    label300:
    label439:
    for (paramString = localObject2;; paramString = paramString.AWA)
    {
      com.tencent.mm.plugin.finder.live.report.j.a((q.w)localObject1, paramString);
      AppMethodBeat.o(335375);
      return;
      localObject1 = ((v)localObject1).AWA;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((FeedData)localObject1).getLiveInfo();
      break;
      bool1 = false;
      break label180;
      localObject1 = (CharSequence)paramString;
      int i;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
      {
        i = 1;
        if (i != 0) {
          break label409;
        }
        localObject1 = r.Fqi;
        r.eMF();
        localb = this.mJG;
        if (localb != null)
        {
          localObject1 = com.tencent.mm.live.core.d.a.mWH;
          localObject1 = this.BtQ;
          if (localObject1 != null) {
            break label411;
          }
          localObject1 = null;
        }
      }
      for (;;)
      {
        localObject1 = com.tencent.mm.live.core.d.a.a((bip)localObject1, paramString);
        locala = com.tencent.d.a.a.a.a.a.ahiX;
        if (((Number)com.tencent.d.a.a.a.a.a.jUp().bmg()).intValue() == 1) {
          bool1 = true;
        }
        localb.D((String)localObject1, bool1);
        localObject1 = this.mJG;
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.live.core.core.c.b)localObject1).Y(paramString, 1);
        break;
        i = 0;
        break label300;
        break;
        localObject1 = ((v)localObject1).AWA;
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = ((FeedData)localObject1).getLiveInfo();
        }
      }
    }
  }
  
  private final void uA(boolean paramBoolean)
  {
    long l2 = 0L;
    AppMethodBeat.i(335350);
    Object localObject1;
    Object localObject2;
    long l1;
    if (this.GnS)
    {
      localObject1 = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveChargeInfoStorage();
      localObject2 = this.BtQ;
      if (localObject2 == null) {
        l1 = 0L;
      }
    }
    for (int i = ((com.tencent.d.a.a.a.d.b)localObject1).ov(l1);; i = 0)
    {
      Log.i("Finder.FinderLivePlayView", "checkChargeLivePlayPuase freeTimeOver:" + paramBoolean + ",isLiveFreeTimerInit:" + this.GnS + ",watchTime:" + i);
      if (!paramBoolean) {
        break label180;
      }
      localObject1 = this.mJG;
      if (localObject1 != null) {
        ((com.tencent.mm.live.core.core.c.b)localObject1).fD(false);
      }
      fiR();
      AppMethodBeat.o(335350);
      return;
      localObject2 = ((v)localObject2).AWA;
      if (localObject2 == null)
      {
        l1 = 0L;
        break;
      }
      localObject2 = ((FeedData)localObject2).getLiveInfo();
      if (localObject2 == null)
      {
        l1 = 0L;
        break;
      }
      l1 = ((bip)localObject2).liveId;
      break;
    }
    label180:
    if ((this.GnS) && (getLiveFreeTimeManager().eLs()))
    {
      localObject1 = getLiveFreeTimeManager();
      localObject2 = this.BtQ;
      if (localObject2 != null) {
        break label237;
      }
      l1 = l2;
    }
    for (;;)
    {
      com.tencent.mm.plugin.finder.replay.a.a((com.tencent.mm.plugin.finder.replay.a)localObject1, l1, getLiveFreeTimeManager().eLr());
      AppMethodBeat.o(335350);
      return;
      label237:
      localObject2 = ((v)localObject2).AWA;
      l1 = l2;
      if (localObject2 != null) {
        l1 = ((FeedData)localObject2).getLiveId();
      }
    }
  }
  
  public final void a(com.tencent.mm.live.core.core.c.b paramb, long paramLong)
  {
    AppMethodBeat.i(335611);
    s.u(paramb, "txPlayer");
    this.Eac = paramLong;
    b(paramb);
    AppMethodBeat.o(335611);
  }
  
  public final void a(x paramx, boolean paramBoolean, FeedData paramFeedData)
  {
    AppMethodBeat.i(335857);
    s.u(paramx, "video");
    s.u(paramFeedData, "feedData");
    Xa(s.X("setVideoMediaInfo ", paramx.getUrl()));
    this.BtQ = new v(paramx.getUrl(), paramx.getPath(), paramx.aUt(), paramx.eCF(), paramx, paramFeedData);
    paramx = this.GnP;
    if (paramx != null) {
      paramx.a(paramFeedData);
    }
    paramx = this.GnP;
    if (paramx != null) {
      paramx.aj((kotlin.g.a.b)new e(this));
    }
    AppMethodBeat.o(335857);
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean, int paramInt)
  {
    return false;
  }
  
  public final boolean b(double paramDouble, boolean paramBoolean)
  {
    return false;
  }
  
  public final boolean bNU()
  {
    Object localObject1 = null;
    AppMethodBeat.i(335754);
    Xa("play");
    Object localObject2 = this.BtQ;
    if (localObject2 == null) {}
    for (;;)
    {
      if (e((bip)localObject1))
      {
        localObject1 = this.mJG;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.c.b)localObject1).resume();
        }
      }
      localObject1 = this.Flu;
      if (localObject1 != null) {
        ((ab)localObject1).egu();
      }
      AppMethodBeat.o(335754);
      return true;
      localObject2 = ((v)localObject2).AWA;
      if (localObject2 != null) {
        localObject1 = ((FeedData)localObject2).getLiveInfo();
      }
    }
  }
  
  public final boolean boa()
  {
    return this.nvB;
  }
  
  public final boolean eLI()
  {
    AppMethodBeat.i(335767);
    Xa("prepareToPlay");
    AppMethodBeat.o(335767);
    return true;
  }
  
  public final int eLK()
  {
    AppMethodBeat.i(335788);
    Xa("pauseWithCancel");
    com.tencent.mm.live.core.core.c.b localb = this.mJG;
    if (localb != null) {
      localb.fD(false);
    }
    this.hJi = true;
    AppMethodBeat.o(335788);
    return 0;
  }
  
  public final void eLL()
  {
    this.EAt = null;
    this.Flu = null;
  }
  
  public final void eLM() {}
  
  public final boolean eLN()
  {
    AppMethodBeat.i(370257);
    com.tencent.mm.plugin.finder.live.fluent.a locala = com.tencent.mm.plugin.finder.live.fluent.a.CCh;
    boolean bool = com.tencent.mm.plugin.finder.live.fluent.a.ejm();
    AppMethodBeat.o(370257);
    return bool;
  }
  
  public final void fiP()
  {
    this.GnW = true;
  }
  
  public final void fiQ()
  {
    this.GnO = true;
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(335966);
    int i;
    int j;
    if (this.GnR > 0)
    {
      i = this.GnR;
      if (this.GnQ <= 0) {
        break label98;
      }
      j = this.GnQ;
    }
    for (;;)
    {
      localObject = getTextureView().getVideoView();
      if (localObject != null) {
        break label146;
      }
      AppMethodBeat.o(335966);
      return null;
      localObject = getTextureView().getVideoView();
      if (localObject == null) {}
      for (localObject = null;; localObject = Integer.valueOf(((TextureView)localObject).getWidth()))
      {
        if (localObject != null) {
          break label90;
        }
        i = getTextureView().getWidth();
        break;
      }
      label90:
      i = ((Integer)localObject).intValue();
      break;
      label98:
      localObject = getTextureView().getVideoView();
      if (localObject == null) {}
      for (localObject = null;; localObject = Integer.valueOf(((TextureView)localObject).getHeight()))
      {
        if (localObject != null) {
          break label138;
        }
        j = getTextureView().getHeight();
        break;
      }
      label138:
      j = ((Integer)localObject).intValue();
    }
    label146:
    Object localObject = ((TextureView)localObject).getBitmap(i, j);
    AppMethodBeat.o(335966);
    return localObject;
  }
  
  public final int getContextTag()
  {
    return this.contextTag;
  }
  
  public final long getCurrentPlayMs()
  {
    return 0L;
  }
  
  public final int getCurrentPlaySecond()
  {
    return 0;
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
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(335707);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(335707);
    return localViewParent;
  }
  
  public final ITXLivePlayListener getPlayListener()
  {
    return this.GnU;
  }
  
  public final Object getPlayer()
  {
    return this.mJG;
  }
  
  public final d getTextureView()
  {
    AppMethodBeat.i(335538);
    d locald = this.GnN;
    if (locald != null)
    {
      AppMethodBeat.o(335538);
      return locald;
    }
    s.bIx("textureView");
    AppMethodBeat.o(335538);
    return null;
  }
  
  public final com.tencent.mm.live.core.core.c.b getTxLivePlayer()
  {
    return this.mJG;
  }
  
  public final int getVideoDuration()
  {
    return 0;
  }
  
  public final long getVideoDurationMs()
  {
    return 0L;
  }
  
  public final String getVideoMediaId()
  {
    Object localObject = this.BtQ;
    if (localObject == null) {
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = ((v)localObject).mediaId;
      localObject = str;
    } while (str != null);
    return "";
  }
  
  public final v getVideoMediaInfo()
  {
    return this.BtQ;
  }
  
  public final FinderLivePlayView getVideoView()
  {
    return this;
  }
  
  public final i.b getVideoViewCallback()
  {
    return this.EAt;
  }
  
  public final boolean getVideoViewFocused()
  {
    return this.Flr;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(335812);
    com.tencent.mm.live.core.core.c.b localb = this.mJG;
    if ((localb != null) && (localb.isPlaying() == true))
    {
      AppMethodBeat.o(335812);
      return true;
    }
    AppMethodBeat.o(335812);
    return false;
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(335842);
    Xa("onRelease");
    ao localao = this.GnP;
    if (localao != null) {
      localao.eck();
    }
    this.hJi = false;
    AppMethodBeat.o(335842);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(335833);
    Xa("onUIDestroy");
    stop();
    AppMethodBeat.o(335833);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(335783);
    Xa("pause");
    Object localObject = this.mJG;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.c.b)localObject).fD(false);
    }
    this.hJi = true;
    localObject = this.Flu;
    if (localObject != null) {
      ((ab)localObject).a(null);
    }
    fiO();
    AppMethodBeat.o(335783);
    return true;
  }
  
  public final com.tencent.mm.plugin.finder.live.fluent.h pu(long paramLong)
  {
    AppMethodBeat.i(335955);
    Object localObject = getTextureView().getVideoView();
    if (localObject == null) {}
    for (localObject = null; (localObject == null) || (!com.tencent.mm.plugin.finder.live.model.v.CGh.ekX()); localObject = ((TextureView)localObject).getSurfaceTexture())
    {
      AppMethodBeat.o(335955);
      return null;
    }
    float f = 1.0F * this.videoWidth / this.videoHeight;
    localObject = h.a.CCD;
    View localView = (View)this;
    TextureView localTextureView = getTextureView().getVideoView();
    s.s(localTextureView, "textureView.videoView");
    com.tencent.mm.live.core.core.c.b localb = this.mJG;
    this.mJG = null;
    uA(false);
    int k = this.videoWidth;
    int m = this.videoHeight;
    int j = getTextureView().getWidth();
    int n = getTextureView().getHeight();
    int[] arrayOfInt = new int[2];
    int i = this.videoWidth;
    int i1 = this.videoHeight;
    boolean bool;
    if ((i > 0) && (i1 > 0))
    {
      bool = true;
      Log.i("Finder.FinderLivePlayView", "isLandscapeVideo validVideoSize:" + bool + " videoRes[" + i + ", " + i1 + ']');
      if ((!bool) || (i < i1)) {
        break label353;
      }
      i = 1;
      label239:
      if ((i == 0) && (!hE(this.videoWidth, this.videoHeight))) {
        break label377;
      }
      if (f != 0.0F) {
        break label359;
      }
      i = 1;
      label267:
      if (i != 0) {
        break label365;
      }
    }
    label353:
    label359:
    label365:
    for (i = (int)(j / f);; i = getTextureView().getHeight())
    {
      arrayOfInt[0] = j;
      arrayOfInt[1] = i;
      localObject = new com.tencent.mm.plugin.finder.live.fluent.f((h.a)localObject, false, paramLong, localView, localTextureView, localb, k, m, f, arrayOfInt);
      ((com.tencent.mm.plugin.finder.live.fluent.f)localObject).mUN = ((View)this);
      fiO();
      localObject = (com.tencent.mm.plugin.finder.live.fluent.h)localObject;
      AppMethodBeat.o(335955);
      return localObject;
      bool = false;
      break;
      i = 0;
      break label239;
      i = 0;
      break label267;
    }
    label377:
    if (f == 0.0F)
    {
      i = 1;
      if (i != 0) {
        break label420;
      }
    }
    label386:
    label420:
    for (i = (int)(n * f);; i = j)
    {
      arrayOfInt[0] = i;
      arrayOfInt[1] = n;
      break;
      i = 0;
      break label386;
    }
  }
  
  public final boolean r(Integer paramInteger)
  {
    String str = null;
    AppMethodBeat.i(335760);
    Object localObject = new StringBuilder("startOrPlay, ");
    paramInteger = this.BtQ;
    if (paramInteger == null)
    {
      paramInteger = null;
      localObject = ((StringBuilder)localObject).append(paramInteger).append(", ");
      paramInteger = this.BtQ;
      if (paramInteger != null) {
        break label124;
      }
    }
    label124:
    for (paramInteger = null;; paramInteger = paramInteger.downloadUrl)
    {
      Xa(paramInteger);
      if (this.Flr) {
        break label132;
      }
      Log.i("Finder.FinderLivePlayView", s.X("startOrPlay, return, isViewFocused:", Boolean.valueOf(this.Flr)));
      AppMethodBeat.o(335760);
      return false;
      paramInteger = paramInteger.AWA;
      if (paramInteger == null)
      {
        paramInteger = null;
        break;
      }
      paramInteger = Long.valueOf(paramInteger.getLiveId());
      break;
    }
    label132:
    if (isPlaying())
    {
      Log.i("Finder.FinderLivePlayView", "startOrPlay, return, isPlaying!");
      paramInteger = this.BtQ;
      if (paramInteger == null) {
        paramInteger = str;
      }
      for (;;)
      {
        e(paramInteger);
        AppMethodBeat.o(335760);
        return false;
        localObject = paramInteger.AWA;
        paramInteger = str;
        if (localObject != null) {
          paramInteger = ((FeedData)localObject).getLiveInfo();
        }
      }
    }
    paramInteger = this.BtQ;
    if ((paramInteger != null) && (!Util.isNullOrNil(paramInteger.downloadUrl)) && (paramInteger.downloadUrl != null))
    {
      str = paramInteger.downloadUrl;
      paramInteger = str;
      if (str == null) {
        paramInteger = "";
      }
      start(paramInteger);
      setNeverStart(false);
      AppMethodBeat.o(335760);
      return true;
    }
    AppMethodBeat.o(335760);
    return false;
  }
  
  public final void setAutoJustRenderMode(boolean paramBoolean)
  {
    this.GnO = paramBoolean;
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
  
  public final void setIMMVideoViewCallback(i.b paramb)
  {
    AppMethodBeat.i(335863);
    s.u(paramb, "_callback");
    Xa(s.X("setIMMVideoViewCallback _callback:", Integer.valueOf(paramb.hashCode())));
    this.EAt = paramb;
    AppMethodBeat.o(335863);
  }
  
  public final void setIOnlineVideoProxy(com.tencent.mm.modelvideo.f paramf)
  {
    AppMethodBeat.i(335876);
    s.u(paramf, "_proxy");
    AppMethodBeat.o(335876);
  }
  
  public final void setInterceptDetach(boolean paramBoolean) {}
  
  public final void setIsShouldPlayResume(boolean paramBoolean)
  {
    AppMethodBeat.i(335718);
    Xa(s.X("setIsShouldPlayResume: ", Boolean.valueOf(paramBoolean)));
    this.Fls = paramBoolean;
    AppMethodBeat.o(335718);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean) {}
  
  public final void setLifecycle(ab paramab)
  {
    this.Flu = paramab;
  }
  
  public final void setLiveFreeTimerInit(boolean paramBoolean)
  {
    this.GnS = paramBoolean;
  }
  
  public final void setLoop(boolean paramBoolean) {}
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(335820);
    Xa(s.X("setMute ", Boolean.valueOf(paramBoolean)));
    com.tencent.mm.live.core.core.c.b localb = this.mJG;
    if (localb != null) {
      localb.setMute(paramBoolean);
    }
    AppMethodBeat.o(335820);
  }
  
  public final void setNeverStart(boolean paramBoolean)
  {
    this.GnV = paramBoolean;
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    AppMethodBeat.i(335732);
    Xa(s.X("setPreview: ", Boolean.valueOf(paramBoolean)));
    this.nvB = paramBoolean;
    AppMethodBeat.o(335732);
  }
  
  public final void setScaleType(i.e parame)
  {
    AppMethodBeat.i(335868);
    s.u(parame, "scaleType");
    com.tencent.mm.live.core.core.c.b localb = this.mJG;
    if (localb != null) {
      if (parame != i.e.XYM) {
        break label45;
      }
    }
    label45:
    for (int i = 1;; i = 0)
    {
      localb.setRenderMode(i);
      AppMethodBeat.o(335868);
      return;
    }
  }
  
  public final void setShouldPlayResume(boolean paramBoolean)
  {
    this.Fls = paramBoolean;
  }
  
  public final void setSupportPauseResume(boolean paramBoolean)
  {
    this.GnW = paramBoolean;
  }
  
  public final void setTextureView(d paramd)
  {
    AppMethodBeat.i(335549);
    s.u(paramd, "<set-?>");
    this.GnN = paramd;
    AppMethodBeat.o(335549);
  }
  
  public final void setTxLivePlayer(com.tencent.mm.live.core.core.c.b paramb)
  {
    this.mJG = paramb;
  }
  
  public final void setVideoMuteListener(w paramw)
  {
    AppMethodBeat.i(335924);
    s.u(paramw, "muteListener");
    AppMethodBeat.o(335924);
  }
  
  public final void setVideoPlayLifecycle(ab paramab)
  {
    AppMethodBeat.i(335917);
    s.u(paramab, "lifecycle");
    Xa(s.X("setVideoPlayLifecycle _callback:", Integer.valueOf(paramab.hashCode())));
    this.Flu = paramab;
    AppMethodBeat.o(335917);
  }
  
  public final void setVideoViewCallback(i.b paramb)
  {
    this.EAt = paramb;
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    AppMethodBeat.i(335724);
    Log.i("Finder.FinderLivePlayView", s.X("setVideoViewFocused ", Boolean.valueOf(paramBoolean)));
    this.Flr = paramBoolean;
    AppMethodBeat.o(335724);
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.Flr = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(335802);
    Xa("stop");
    uA(false);
    Object localObject = this.mJG;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.c.b)localObject).fD(true);
    }
    this.hJi = false;
    this.GnV = true;
    localObject = this.Flu;
    if (localObject != null) {
      ab.a.a((ab)localObject, this.BtQ);
    }
    AppMethodBeat.o(335802);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderLivePlayView$LiveTimmerCallback;", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveFreeTimeManager$Callback;", "rFinderLivePlayView", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/finder/video/FinderLivePlayView;", "(Lcom/tencent/mm/plugin/finder/video/FinderLivePlayView;Ljava/lang/ref/WeakReference;)V", "updateTimer", "", "freeTomeToWatch", "", "totalFreeTimeToWatch", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements a.a
  {
    private final WeakReference<FinderLivePlayView> GnX;
    
    public b()
    {
      AppMethodBeat.i(334989);
      this.GnX = localObject;
      AppMethodBeat.o(334989);
    }
    
    public final void hG(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(334997);
      if (paramInt1 <= 0)
      {
        FinderLivePlayView localFinderLivePlayView = (FinderLivePlayView)this.GnX.get();
        if (localFinderLivePlayView != null)
        {
          FinderLivePlayView.b(localFinderLivePlayView);
          AppMethodBeat.o(334997);
          return;
        }
        Log.i("Finder.FinderLivePlayView", "timer finish bug reference is null!");
      }
      AppMethodBeat.o(334997);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/replay/FinderLiveFreeTimeManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.finder.replay.a>
  {
    c(FinderLivePlayView paramFinderLivePlayView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderLivePlayView$playListener$1", "Lcom/tencent/rtmp/ITXLivePlayListener;", "onNetStatus", "", "params", "Landroid/os/Bundle;", "onPlayEvent", "event", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements ITXLivePlayListener
  {
    d(FinderLivePlayView paramFinderLivePlayView) {}
    
    public final void onNetStatus(Bundle paramBundle)
    {
      int i = 1;
      AppMethodBeat.i(335012);
      int j = NetStatusUtil.getNetType(this.GnY.getContext());
      paramBundle = new StringBuilder("onNetStatus curPlayStatus:").append(FinderLivePlayView.k(this.GnY)).append(", netQuality:").append(j).append(", isPlaying:");
      Object localObject = this.GnY.getTxLivePlayer();
      boolean bool;
      if ((localObject != null) && (((com.tencent.mm.live.core.core.c.b)localObject).isPlaying() == true))
      {
        bool = true;
        Log.i("Finder.FinderLivePlayView", bool);
        paramBundle = this.GnY.getTxLivePlayer();
        if ((paramBundle == null) || (paramBundle.isPlaying() != true)) {
          break label228;
        }
      }
      for (;;)
      {
        if ((i != 0) && (j != -1) && (FinderLivePlayView.k(this.GnY) == -2301))
        {
          paramBundle = FinderLivePlayView.c(this.GnY);
          if (paramBundle != null)
          {
            FinderLivePlayView localFinderLivePlayView = this.GnY;
            if ((!Util.isNullOrNil(paramBundle.downloadUrl)) && (paramBundle.downloadUrl != null))
            {
              localObject = localFinderLivePlayView.getTxLivePlayer();
              if (localObject != null) {
                ((com.tencent.mm.live.core.core.c.b)localObject).fD(false);
              }
              localObject = paramBundle.downloadUrl;
              paramBundle = (Bundle)localObject;
              if (localObject == null) {
                paramBundle = "";
              }
              FinderLivePlayView.b(localFinderLivePlayView, paramBundle);
            }
          }
        }
        AppMethodBeat.o(335012);
        return;
        bool = false;
        break;
        label228:
        i = 0;
      }
    }
    
    public final void onPlayEvent(int paramInt, Bundle paramBundle)
    {
      int j = 1;
      boolean bool3 = true;
      boolean bool2 = true;
      int m = 0;
      int k = 0;
      AppMethodBeat.i(335003);
      Object localObject = new StringBuilder("onPlayEvent:").append(paramInt).append(", isPlaying:");
      com.tencent.mm.live.core.core.c.b localb = this.GnY.getTxLivePlayer();
      boolean bool1;
      int i;
      if ((localb != null) && (localb.isPlaying() == true))
      {
        bool1 = true;
        Log.i("Finder.FinderLivePlayView", bool1);
        localObject = this.GnY.getTxLivePlayer();
        if ((localObject == null) || (((com.tencent.mm.live.core.core.c.b)localObject).isPlaying() != true)) {
          break label216;
        }
        i = 1;
        label110:
        if (i != 0)
        {
          FinderLivePlayView.a(this.GnY, paramInt);
          switch (paramInt)
          {
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(335003);
        return;
        bool1 = false;
        break;
        label216:
        i = 0;
        break label110;
        paramBundle = r.Fqi;
        r.eMI();
        localObject = this.GnY;
        if (paramInt == 2004)
        {
          paramBundle = "EVT_VIDEO_PLAY_BEGIN";
          FinderLivePlayView.a((FinderLivePlayView)localObject, s.X("onPlayEvent ", paramBundle));
          paramBundle = this.GnY.getLifecycle();
          if (paramBundle != null)
          {
            FinderLivePlayView.c(this.GnY);
            paramBundle.egu();
          }
          paramBundle = this.GnY.getLifecycle();
          if (paramBundle != null)
          {
            FinderLivePlayView.c(this.GnY);
            paramBundle.ph(0L);
          }
          paramBundle = FinderLivePlayView.c(this.GnY);
          if (paramBundle != null) {
            break label378;
          }
          paramInt = k;
          label323:
          if (!com.tencent.mm.ae.d.ee(paramInt, 256)) {
            break label398;
          }
          FinderLivePlayView.d(this.GnY);
        }
        for (;;)
        {
          paramBundle = FinderLivePlayView.f(this.GnY);
          if (paramBundle != null) {
            paramBundle.ecl();
          }
          this.GnY.setKeepScreenOn(true);
          AppMethodBeat.o(335003);
          return;
          paramBundle = "PLAY_EVT_CONNECT_SUCC";
          break;
          label378:
          paramBundle = paramBundle.AWA;
          paramInt = k;
          if (paramBundle == null) {
            break label323;
          }
          paramInt = paramBundle.getAnchorStatus();
          break label323;
          label398:
          FinderLivePlayView.e(this.GnY);
        }
        paramBundle = r.Fqi;
        r.eMG();
        localObject = this.GnY;
        if (paramInt == 2004)
        {
          paramBundle = "EVT_VIDEO_PLAY_BEGIN";
          FinderLivePlayView.a((FinderLivePlayView)localObject, s.X("onPlayEvent ", paramBundle));
          paramBundle = this.GnY.getLifecycle();
          if (paramBundle != null)
          {
            FinderLivePlayView.c(this.GnY);
            paramBundle.egu();
          }
          paramBundle = this.GnY.getLifecycle();
          if (paramBundle != null)
          {
            FinderLivePlayView.c(this.GnY);
            paramBundle.ph(0L);
          }
          paramBundle = FinderLivePlayView.c(this.GnY);
          if (paramBundle != null) {
            break label539;
          }
          paramInt = m;
        }
        for (;;)
        {
          if (!com.tencent.mm.ae.d.ee(paramInt, 256)) {
            break label559;
          }
          FinderLivePlayView.d(this.GnY);
          AppMethodBeat.o(335003);
          return;
          paramBundle = "PLAY_EVT_CONNECT_SUCC";
          break;
          label539:
          paramBundle = paramBundle.AWA;
          paramInt = m;
          if (paramBundle != null) {
            paramInt = paramBundle.getAnchorStatus();
          }
        }
        label559:
        FinderLivePlayView.e(this.GnY);
        AppMethodBeat.o(335003);
        return;
        if (NetStatusUtil.getNetType(this.GnY.getContext()) == -1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          FinderLivePlayView.a(this.GnY, s.X("onPlayEvent PLAY_WARNING_RECONNECT, non_network:", Boolean.valueOf(bool1)));
          if (!bool1) {
            break;
          }
          AppMethodBeat.o(335003);
          return;
        }
        if (NetStatusUtil.getNetType(this.GnY.getContext()) == -1)
        {
          bool1 = true;
          label641:
          FinderLivePlayView.a(this.GnY, s.X("onPlayEvent PLAY_ERR_NET_DISCONNECT, non_network:", Boolean.valueOf(bool1)));
          paramBundle = this.GnY.getTxLivePlayer();
          if (paramBundle != null) {
            paramBundle.fD(false);
          }
          FinderLivePlayView.a(this.GnY);
          paramBundle = FinderLivePlayView.c(this.GnY);
          if (paramBundle == null) {
            break label772;
          }
          paramBundle = paramBundle.AWA;
          if (paramBundle == null) {
            break label772;
          }
          paramBundle = paramBundle.getLiveInfo();
          if (paramBundle == null) {
            break label772;
          }
          paramBundle = paramBundle.ZSn;
          if (paramBundle == null) {
            break label772;
          }
          paramInt = paramBundle.mIY;
          paramBundle = b.g.ahoC;
          if (paramInt != b.g.a.jWh()) {
            break label772;
          }
          paramInt = j;
          label742:
          if (paramInt == 0) {
            break label777;
          }
          FinderLivePlayView.a(this.GnY, "onPlayEvent PLAY_ERR_NET_DISCONNECT but is olympics live, ignore");
        }
        while (bool1)
        {
          AppMethodBeat.o(335003);
          return;
          bool1 = false;
          break label641;
          label772:
          paramInt = 0;
          break label742;
          label777:
          FinderLivePlayView.g(this.GnY);
        }
        if (NetStatusUtil.getNetType(this.GnY.getContext()) == -1) {}
        for (bool1 = bool3;; bool1 = false)
        {
          FinderLivePlayView.a(this.GnY, s.X("onPlayEvent PLAY_EVT_PLAY_END, non_network:", Boolean.valueOf(bool1)));
          paramBundle = this.GnY.getTxLivePlayer();
          if (paramBundle != null) {
            paramBundle.fD(false);
          }
          FinderLivePlayView.a(this.GnY);
          FinderLivePlayView.g(this.GnY);
          AppMethodBeat.o(335003);
          return;
        }
        localObject = this.GnY;
        if (paramBundle == null)
        {
          paramInt = 0;
          FinderLivePlayView.b((FinderLivePlayView)localObject, paramInt);
          localObject = this.GnY;
          if (paramBundle != null) {
            break label1008;
          }
        }
        label1008:
        for (paramInt = 0;; paramInt = paramBundle.getInt("EVT_PARAM2"))
        {
          FinderLivePlayView.c((FinderLivePlayView)localObject, paramInt);
          FinderLivePlayView.a(this.GnY, "onPlayEvent PLAY_EVT_CHANGE_RESOLUTION, w:h=" + FinderLivePlayView.h(this.GnY) + ':' + FinderLivePlayView.i(this.GnY));
          paramBundle = FinderLivePlayView.f(this.GnY);
          if (paramBundle != null) {
            paramBundle.hu(FinderLivePlayView.h(this.GnY), FinderLivePlayView.i(this.GnY));
          }
          if (this.GnY.GnO) {
            break label1019;
          }
          AppMethodBeat.o(335003);
          return;
          paramInt = paramBundle.getInt("EVT_PARAM1");
          break;
        }
        label1019:
        if (FinderLivePlayView.i(this.GnY) > FinderLivePlayView.h(this.GnY))
        {
          paramBundle = this.GnY.getTxLivePlayer();
          if (paramBundle != null) {
            paramBundle.setRenderMode(0);
          }
        }
        for (;;)
        {
          FinderLivePlayView.a(this.GnY, FinderLivePlayView.h(this.GnY), FinderLivePlayView.i(this.GnY));
          FinderLivePlayView.j(this.GnY);
          AppMethodBeat.o(335003);
          return;
          paramBundle = this.GnY.getTxLivePlayer();
          if (paramBundle != null) {
            paramBundle.setRenderMode(1);
          }
        }
        if (paramBundle == null) {}
        for (paramBundle = null;; paramBundle = paramBundle.getByteArray("EVT_GET_MSG"))
        {
          localObject = FinderLivePlayView.f(this.GnY);
          if (localObject == null) {
            break;
          }
          ((ao)localObject).bT(paramBundle);
          AppMethodBeat.o(335003);
          return;
        }
        paramBundle = r.Fqi;
        paramBundle = FinderLivePlayView.c(this.GnY);
        if (paramBundle == null) {}
        for (paramBundle = null;; paramBundle = paramBundle.AWA)
        {
          r.a(null, paramBundle);
          Log.i("Finder.FinderLivePlayView", "TXLivePlayer:receive first frame");
          AppMethodBeat.o(335003);
          return;
        }
        paramBundle = r.Fqi;
        r.eMH();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<List<? extends String>, ah>
  {
    e(FinderLivePlayView paramFinderLivePlayView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderLivePlayView
 * JD-Core Version:    0.7.0.1
 */