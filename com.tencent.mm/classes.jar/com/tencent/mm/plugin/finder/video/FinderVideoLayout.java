package com.tencent.mm.plugin.finder.video;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hq;
import com.tencent.mm.f.a.hq.a;
import com.tencent.mm.f.a.ip;
import com.tencent.mm.f.a.qu;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.event.c.b;
import com.tencent.mm.plugin.finder.event.c.c;
import com.tencent.mm.plugin.finder.loader.aa;
import com.tencent.mm.plugin.finder.loader.ac;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.loader.w;
import com.tencent.mm.plugin.finder.model.av;
import com.tencent.mm.plugin.finder.report.ai;
import com.tencent.mm.plugin.finder.report.h.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.viewmodel.component.au;
import com.tencent.mm.plugin.finder.viewmodel.j.a;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.plugin.findersdk.receiver.HeadsetReceiver.b;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar$SeekBarCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomButtonLayout", "Landroid/view/View;", "getBottomButtonLayout", "()Landroid/view/View;", "bottomButtonLayout$delegate", "Lkotlin/Lazy;", "bulletSubtitleButton", "getBulletSubtitleButton", "bulletSubtitleButton$delegate", "bulletSubtitlePresenter", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;", "bulletSubtitleViewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback;", "fullscreenIcon", "kotlin.jvm.PlatformType", "getFullscreenIcon", "fullscreenIcon$delegate", "isEnableFullScreenEnjoy", "", "isEnablePlay", "()Z", "setEnablePlay", "(Z)V", "isEnableShowLoading", "setEnableShowLoading", "isLongVideo", "setLongVideo", "value", "isMute", "setMute", "isNowPause", "isShowThumbAnimating", "lastCurrentPlaySecond", "lastSeekTime", "", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "loading", "getLoading", "loading$delegate", "longVideoSeekBar", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "getLongVideoSeekBar", "()Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "setLongVideoSeekBar", "(Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;)V", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "muteBtn", "Landroid/widget/ImageView;", "getMuteBtn", "()Landroid/widget/ImageView;", "muteBtn$delegate", "onHeadsetStateChangeListener", "Lcom/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver$OnHeadsetStateChangeListener;", "playAdapterPosition", "getPlayAdapterPosition", "()I", "setPlayAdapterPosition", "(I)V", "playInfo", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "getPlayInfo", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "setPlayInfo", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;)V", "playSpeedRatio", "retryBtn", "getRetryBtn", "retryBtn$delegate", "seekBarLayout", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar;", "startPlayTime", "", "startSeekMode", "tabType", "thumbShowCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isShow", "", "getThumbShowCallback", "()Lkotlin/jvm/functions/Function2;", "setThumbShowCallback", "(Lkotlin/jvm/functions/Function2;)V", "thumbView", "getThumbView", "thumbView$delegate", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "getVideoCore", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setVideoCore", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;)V", "videoPauseCallback", "isPause", "getVideoPauseCallback", "setVideoPauseCallback", "videoStateVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM;", "videoTypeIv", "getVideoTypeIv", "videoTypeIv$delegate", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "getVideoView", "()Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "setVideoView", "(Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;)V", "adaptForCropShow", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "checkVideoDataAvailable", "mediaId", "", "offset", "length", "convert", "position", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "isEnableFullEnjoy", "isSupportBulletSubtitle", "dismissLoading", "dismissRetryBtn", "dismissThumb", "source", "findBestVideo", "feedId", "getBitmap", "Landroid/graphics/Bitmap;", "getCurrentPosMs", "getCurrentPosSec", "getVideoDurationSec", "getVideoPlayBehavior", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "initLongVideoSeekBar", "isEnableSeek", "isSeekMode", "isVideoPlaying", "layoutLoadingIcon", "loginfo", "onAttachedToWindow", "onDetachedFromWindow", "onEnterSeekMode", "isEnter", "showPauseTips", "onError", "sessionId", "errorMsg", "what", "extra", "onFinishDownload", "ret", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onFirstVideoFrameRendered", "onGetVideoSize", "width", "height", "onHandlePausePlay", "onHandleResumePlay", "onMoovReadyDownload", "total", "moovFirstDownloaded", "onMute", "mute", "onNeedIgnoreTouchEvent", "event", "Landroid/view/MotionEvent;", "onPlayAfterSeek", "onPrepared", "onProgressDownload", "onStartDownload", "onStartSeek", "onStopDownload", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onStopSeek", "percent", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "onViewAdded", "child", "onViewRecycled", "onViewRemoved", "pause", "isForceRemoveVideoView", "play", "videoPlayTrace", "Lcom/tencent/mm/plugin/findersdk/trace/FinderVideoPlayTrace;", "prepare", "isLocal", "feedData", "prepareToPlay", "publishSeekEvent", "currSec", "seekSec", "retryPlay", "setStartPlayTime", "timeMs", "mode", "playSpeed", "showLoading", "showRetryBtn", "showThumb", "showVideoPauseTip", "show", "showVideoTypeIv", "toggleVideo", "isPlay", "updateProgress", "offsetMs", "totalMs", "viewLog", "Companion", "PlayInfo", "plugin-finder_release"})
public final class FinderVideoLayout
  extends FrameLayout
  implements r.a, u, y, i.b
{
  public static final a AOj;
  private final z ALf;
  private float AMG;
  private boolean ANL;
  private boolean ANM;
  public final com.tencent.mm.plugin.finder.viewmodel.j ANN;
  private final kotlin.f ANO;
  private boolean ANP;
  private final kotlin.f ANQ;
  private final kotlin.f ANR;
  private final kotlin.f ANS;
  private final kotlin.f ANT;
  public s ANU;
  private final kotlin.f ANV;
  private final kotlin.f ANW;
  private final kotlin.f ANX;
  public b ANY;
  public r ANZ;
  private FinderLongVideoPlayerSeekBar AOa;
  private m<? super Boolean, ? super b, x> AOb;
  private m<? super Boolean, ? super b, x> AOc;
  private int AOd;
  public boolean AOe;
  private boolean AOf;
  private float AOg;
  private int AOh;
  private int AOi;
  private int fEH;
  boolean iYs;
  public boolean isLongVideo;
  private long lzJ;
  private LinkedList<csg> mediaList;
  public l xkW;
  private com.tencent.mm.plugin.finder.feed.e xyR;
  public com.tencent.mm.plugin.finder.feed.d xyS;
  private HeadsetReceiver.b zCi;
  
  static
  {
    AppMethodBeat.i(168083);
    AOj = new a((byte)0);
    AppMethodBeat.o(168083);
  }
  
  public FinderVideoLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168131);
    setTag("Finder.VideoLayout");
    setId(b.f.finder_banner_video_layout);
    setImportantForAccessibility(2);
    this.ANM = true;
    paramContext = com.tencent.mm.ui.component.g.Xox;
    paramContext = com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.j.class);
    p.j(paramContext, "UICProvider.of(PluginFin…StateCacheVM::class.java)");
    this.ANN = ((com.tencent.mm.plugin.finder.viewmodel.j)paramContext);
    this.ANO = kotlin.g.ar((kotlin.g.a.a)new k(this));
    this.zCi = ((HeadsetReceiver.b)new m(this));
    this.ANQ = kotlin.g.ar((kotlin.g.a.a)new c(this));
    this.ANR = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.ANS = kotlin.g.ar((kotlin.g.a.a)new l(this));
    this.ANT = kotlin.g.ar((kotlin.g.a.a)new s(this));
    this.mediaList = new LinkedList();
    this.ANV = kotlin.g.ar((kotlin.g.a.a)new g(this));
    this.ANW = kotlin.g.ar((kotlin.g.a.a)new p(this));
    this.ANX = kotlin.g.ar((kotlin.g.a.a)new v(this));
    this.ALf = ((z)new j(this));
    this.AOe = true;
    this.AOg = -1.0F;
    this.AOh = -1;
    this.AOi = 1;
    this.AMG = 1.0F;
    AppMethodBeat.o(168131);
  }
  
  public FinderVideoLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168132);
    setTag("Finder.VideoLayout");
    setId(b.f.finder_banner_video_layout);
    setImportantForAccessibility(2);
    this.ANM = true;
    paramContext = com.tencent.mm.ui.component.g.Xox;
    paramContext = com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.j.class);
    p.j(paramContext, "UICProvider.of(PluginFin…StateCacheVM::class.java)");
    this.ANN = ((com.tencent.mm.plugin.finder.viewmodel.j)paramContext);
    this.ANO = kotlin.g.ar((kotlin.g.a.a)new k(this));
    this.zCi = ((HeadsetReceiver.b)new m(this));
    this.ANQ = kotlin.g.ar((kotlin.g.a.a)new c(this));
    this.ANR = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.ANS = kotlin.g.ar((kotlin.g.a.a)new l(this));
    this.ANT = kotlin.g.ar((kotlin.g.a.a)new s(this));
    this.mediaList = new LinkedList();
    this.ANV = kotlin.g.ar((kotlin.g.a.a)new g(this));
    this.ANW = kotlin.g.ar((kotlin.g.a.a)new p(this));
    this.ANX = kotlin.g.ar((kotlin.g.a.a)new v(this));
    this.ALf = ((z)new j(this));
    this.AOe = true;
    this.AOg = -1.0F;
    this.AOh = -1;
    this.AOi = 1;
    this.AMG = 1.0F;
    AppMethodBeat.o(168132);
  }
  
  private final void aGk(String paramString)
  {
    AppMethodBeat.i(284812);
    Object localObject = this.AOc;
    if (localObject != null) {
      ((m)localObject).invoke(Boolean.FALSE, this.ANY);
    }
    localObject = this.ANU;
    if ((localObject != null) && (((s)localObject).getAlpha() == 1.0F))
    {
      AppMethodBeat.o(284812);
      return;
    }
    if (this.AOf)
    {
      AppMethodBeat.o(284812);
      return;
    }
    Log.i("Finder.VideoLayout", "[dismissThumb] " + eht() + " source=" + paramString + " isShowThumbAnimating=" + this.AOf);
    paramString = this.ANU;
    if (paramString != null)
    {
      paramString.getVideoView().post((Runnable)new f(paramString, this));
      AppMethodBeat.o(284812);
      return;
    }
    AppMethodBeat.o(284812);
  }
  
  private final void aa(long paramLong1, final long paramLong2)
  {
    AppMethodBeat.i(284826);
    Object localObject;
    if (paramLong1 == -1L)
    {
      localObject = this.ANU;
      if (localObject != null)
      {
        paramLong1 = ((s)localObject).getCurrentPlayMs();
        if (paramLong2 != -1L) {
          break label165;
        }
        localObject = this.ANU;
        if (localObject == null) {
          break label160;
        }
        paramLong2 = ((s)localObject).getVideoDurationMs();
      }
    }
    label160:
    label165:
    for (;;)
    {
      final int i = (int)(paramLong1 / 1000L);
      final int j = (int)(paramLong2 / 1000L);
      localObject = this.ANZ;
      if (localObject != null) {
        post((Runnable)new t((r)localObject, this, paramLong2, paramLong1, i, j));
      }
      localObject = this.AOa;
      if (localObject == null) {
        break label168;
      }
      ((FinderLongVideoPlayerSeekBar)localObject).post((Runnable)new u((FinderLongVideoPlayerSeekBar)localObject, this, j, i));
      AppMethodBeat.o(284826);
      return;
      paramLong1 = 0L;
      break;
      break;
      paramLong2 = 0L;
    }
    label168:
    AppMethodBeat.o(284826);
  }
  
  public static void b(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(284831);
    ip localip = new ip();
    localip.fFK.feedId = paramLong;
    localip.fFK.mediaId = paramString;
    localip.fFK.fFL = paramInt1;
    localip.fFK.fFM = paramInt2;
    EventCenter.instance.publish((IEvent)localip);
    AppMethodBeat.o(284831);
  }
  
  private final void cYm()
  {
    AppMethodBeat.i(168123);
    Object localObject = this.AOa;
    if (localObject != null)
    {
      localObject = ((FinderLongVideoPlayerSeekBar)localObject).getOnCustomLoadingStatusChange();
      if (localObject != null)
      {
        ((kotlin.g.a.b)localObject).invoke(Boolean.FALSE);
        AppMethodBeat.o(168123);
        return;
      }
    }
    getLoading().animate().cancel();
    if (getLoading().getVisibility() != 8) {
      getLoading().setVisibility(8);
    }
    AppMethodBeat.o(168123);
  }
  
  private final boolean ehp()
  {
    b localb = this.ANY;
    return (localb != null) && (localb.AKv == true);
  }
  
  private final void ehq()
  {
    AppMethodBeat.i(168119);
    this.AOf = false;
    Object localObject = this.AOc;
    if (localObject != null) {
      ((m)localObject).invoke(Boolean.TRUE, this.ANY);
    }
    localObject = this.ANU;
    if (localObject != null) {}
    for (float f = ((s)localObject).getAlpha(); f == 0.0F; f = 0.0F)
    {
      AppMethodBeat.o(168119);
      return;
    }
    localObject = this.ANU;
    if (localObject != null) {
      ((s)localObject).setAlpha(0.0F);
    }
    Log.i("Finder.VideoLayout", "[showThumb] " + eht());
    AppMethodBeat.o(168119);
  }
  
  private final void ehr()
  {
    AppMethodBeat.i(168121);
    getRetryBtn().animate().cancel();
    getRetryBtn().setVisibility(0);
    r localr = this.ANZ;
    if (localr != null) {
      localr.setVisibility(8);
    }
    cYm();
    AppMethodBeat.o(168121);
  }
  
  private final void ehs()
  {
    AppMethodBeat.i(168122);
    getRetryBtn().animate().cancel();
    r localr = this.ANZ;
    if (localr != null) {
      localr.setVisibility(0);
    }
    getRetryBtn().setVisibility(8);
    AppMethodBeat.o(168122);
  }
  
  private final View getBottomButtonLayout()
  {
    AppMethodBeat.i(284796);
    View localView = (View)this.ANQ.getValue();
    AppMethodBeat.o(284796);
    return localView;
  }
  
  private final View getBulletSubtitleButton()
  {
    AppMethodBeat.i(284797);
    View localView = (View)this.ANR.getValue();
    AppMethodBeat.o(284797);
    return localView;
  }
  
  private final View getFullscreenIcon()
  {
    AppMethodBeat.i(284798);
    View localView = (View)this.ANV.getValue();
    AppMethodBeat.o(284798);
    return localView;
  }
  
  private final View getLoading()
  {
    AppMethodBeat.i(168084);
    View localView = (View)this.ANO.getValue();
    AppMethodBeat.o(168084);
    return localView;
  }
  
  private final ImageView getMuteBtn()
  {
    AppMethodBeat.i(168086);
    ImageView localImageView = (ImageView)this.ANS.getValue();
    AppMethodBeat.o(168086);
    return localImageView;
  }
  
  private final ImageView getThumbView()
  {
    AppMethodBeat.i(168087);
    ImageView localImageView = (ImageView)this.ANT.getValue();
    AppMethodBeat.o(168087);
    return localImageView;
  }
  
  private final View getVideoTypeIv()
  {
    AppMethodBeat.i(168093);
    View localView = (View)this.ANX.getValue();
    AppMethodBeat.o(168093);
    return localView;
  }
  
  private final void showLoading()
  {
    AppMethodBeat.i(168124);
    StringBuilder localStringBuilder = new StringBuilder("showLoading ");
    Object localObject = this.ANU;
    if (localObject != null) {}
    for (localObject = ((s)localObject).getVideoMediaId();; localObject = null)
    {
      Log.i("Finder.VideoLayout", (String)localObject);
      if (!this.ANM) {
        break label170;
      }
      localObject = this.ANU;
      if (localObject == null) {
        break;
      }
      if (((s)localObject).getVideoViewFocused() != true) {
        break label170;
      }
      localObject = this.AOa;
      if (localObject == null) {
        break label120;
      }
      localObject = ((FinderLongVideoPlayerSeekBar)localObject).getOnCustomLoadingStatusChange();
      if (localObject == null) {
        break label120;
      }
      ((kotlin.g.a.b)localObject).invoke(Boolean.TRUE);
      AppMethodBeat.o(168124);
      return;
    }
    AppMethodBeat.o(168124);
    return;
    label120:
    getLoading().setVisibility(0);
    getLoading().setAlpha(0.0F);
    getLoading().animate().alpha(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new r(this)).start();
    label170:
    AppMethodBeat.o(168124);
  }
  
  public final void a(int paramInt1, int paramInt2, ac paramac)
  {
    AppMethodBeat.i(284811);
    p.k(paramac, "video");
    Object localObject2 = new StringBuilder("[onProgressDownload] videoView=");
    Object localObject1 = this.ANU;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(localObject1.hashCode());
      Log.i("Finder.VideoLayout", localObject1 + " offset=" + paramInt1 + " total=" + paramInt2 + " video=" + paramac.aBv());
      localObject1 = this.ANY;
      if (localObject1 != null) {
        if (!((b)localObject1).AOk) {
          break label291;
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = getVideoPlayBehavior();
        if (localObject2 != null) {
          ((c.b)localObject2).c(((b)localObject1).feed.getExpectId(), ((b)localObject1).zBB.ztO, paramInt1, paramInt2, (ac)((b)localObject1).zBB);
        }
      }
      localObject1 = com.tencent.mm.plugin.finder.preload.c.zKl;
      if (com.tencent.mm.plugin.finder.preload.c.dMG())
      {
        localObject2 = new qu();
        ((qu)localObject2).fPA.mediaId = paramac.dJw().mediaId;
        ((qu)localObject2).fPA.fPB = ((int)(100.0F * paramInt1 / paramInt2));
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
        localObject1 = paramac.dJw().mediaId;
        paramac = (ac)localObject1;
        if (localObject1 == null) {
          paramac = "";
        }
        paramac = com.tencent.mm.plugin.finder.storage.logic.d.bC(paramac, true);
        ((qu)localObject2).fPA.fPD = paramac.field_fileFormat;
        EventCenter.instance.publish((IEvent)localObject2);
      }
      AppMethodBeat.o(284811);
      return;
      localObject1 = null;
      break;
      label291:
      localObject1 = null;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, ac paramac, boolean paramBoolean)
  {
    AppMethodBeat.i(284810);
    p.k(paramac, "video");
    Object localObject2 = new StringBuilder("[onMoovReadyDownload] videoView=");
    Object localObject1 = this.ANU;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(localObject1.hashCode());
      Log.i("Finder.VideoLayout", localObject1 + "  offset=" + paramInt1 + " total=" + paramInt2 + " video=" + paramac + " moovFirstDownloaded=" + paramBoolean);
      paramac = this.ANY;
      if (paramac != null)
      {
        if (!paramac.AOk) {
          break label308;
        }
        label119:
        if (paramac != null)
        {
          localObject1 = ai.zZt;
          localObject2 = paramac.zBB.ztO.mediaId;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ai.bu((String)localObject1, paramBoolean);
          localObject1 = getVideoPlayBehavior();
          if (localObject1 != null) {
            ((c.b)localObject1).b(paramac.feed.getExpectId(), paramac.zBB.ztO, paramInt1, paramInt2, (ac)paramac.zBB);
          }
        }
      }
      paramac = com.tencent.mm.plugin.finder.report.j.zVy;
      com.tencent.mm.plugin.finder.report.j.Pn(this.fEH);
      paramac = com.tencent.mm.plugin.finder.report.h.zVd;
      paramac = this.ANY;
      if (paramac == null) {
        break label313;
      }
      paramac = paramac.feed;
      if (paramac == null) {
        break label313;
      }
      paramac = Long.valueOf(paramac.getId());
      label243:
      if (paramac == null) {
        break label318;
      }
      paramac.longValue();
      paramac = com.tencent.mm.plugin.finder.report.h.Mj(paramac.longValue());
      if ((paramac.zVg <= 0L) || (paramac.zVh != 0L)) {
        break label325;
      }
      paramInt1 = 1;
      label280:
      if (paramInt1 == 0) {
        break label330;
      }
    }
    for (;;)
    {
      if (paramac == null) {
        break label335;
      }
      paramac.zVh = cm.bfE();
      AppMethodBeat.o(284810);
      return;
      localObject1 = null;
      break;
      label308:
      paramac = null;
      break label119;
      label313:
      paramac = null;
      break label243;
      label318:
      AppMethodBeat.o(284810);
      return;
      label325:
      paramInt1 = 0;
      break label280;
      label330:
      paramac = null;
    }
    label335:
    AppMethodBeat.o(284810);
  }
  
  public final void a(int paramInt, ac paramac, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(284809);
    p.k(paramac, "video");
    StringBuilder localStringBuilder = new StringBuilder("[onFinishDownload] ret=").append(paramInt).append(" videoView=");
    Object localObject = this.ANU;
    if (localObject != null)
    {
      localObject = Integer.valueOf(localObject.hashCode());
      Log.i("Finder.VideoLayout", localObject + " FinderVideo=" + paramac);
      cYm();
      paramac = this.ANY;
      if (paramac != null) {
        if (!paramac.AOk) {
          break label168;
        }
      }
    }
    for (;;)
    {
      if (paramac != null)
      {
        localObject = getVideoPlayBehavior();
        if (localObject != null) {
          ((c.b)localObject).a(paramac.feed.getExpectId(), paramac.zBB.ztO, paramInt, paramd, (ac)paramac.zBB);
        }
      }
      if (paramInt < 0) {
        ehr();
      }
      AppMethodBeat.o(284809);
      return;
      localObject = null;
      break;
      label168:
      paramac = null;
    }
  }
  
  public final void a(int paramInt1, FeedData paramFeedData, r paramr, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, m<? super Boolean, ? super b, x> paramm1, m<? super Boolean, ? super b, x> paramm2)
  {
    AppMethodBeat.i(284800);
    p.k(paramFeedData, "feed");
    Log.i("Finder.VideoLayout", "[convert] position=" + paramInt1 + " feedId=" + paramFeedData.getExpectId() + " current=" + System.currentTimeMillis() + " feedTime=" + paramFeedData.getTimestamps() + " urlValidDuration=" + paramFeedData.getUrlValidDuration() + 's');
    this.fEH = paramInt2;
    this.ANP = paramBoolean1;
    this.AOb = paramm1;
    this.AOc = paramm2;
    paramm1 = getLoading().getLayoutParams();
    if ((paramm1 instanceof FrameLayout.LayoutParams))
    {
      if (!this.ANP) {
        break label285;
      }
      paramm2 = getLoading().getContext();
      p.j(paramm2, "loading.context");
      paramm1.width = ((int)paramm2.getResources().getDimension(b.d.Edge_4A));
      paramm1.height = paramm1.width;
      ((FrameLayout.LayoutParams)paramm1).topMargin = 0;
      ((FrameLayout.LayoutParams)paramm1).setMarginEnd(0);
    }
    for (int i = 17;; i = 8388661)
    {
      if (i != ((FrameLayout.LayoutParams)paramm1).gravity)
      {
        ((FrameLayout.LayoutParams)paramm1).gravity = i;
        getLoading().requestLayout();
      }
      showLoading();
      this.ANZ = paramr;
      if (paramr != null) {
        paramr.setSeekBarCallback((r.a)this);
      }
      this.mediaList = paramFeedData.getMediaList();
      if (paramInt1 < this.mediaList.size()) {
        break;
      }
      AppMethodBeat.o(284800);
      return;
      label285:
      paramm2 = getLoading().getContext();
      p.j(paramm2, "loading.context");
      i = (int)paramm2.getResources().getDimension(b.d.Edge_3A);
      paramm1.width = i;
      paramm1.height = paramm1.width;
      ((FrameLayout.LayoutParams)paramm1).topMargin = i;
      ((FrameLayout.LayoutParams)paramm1).setMarginEnd(i);
    }
    paramm1 = this.mediaList.get(paramInt1);
    p.j(paramm1, "mediaList[position]");
    Object localObject = (csg)paramm1;
    long l = paramFeedData.getId();
    paramm2 = ((csg)localObject).mediaId;
    paramm1 = paramm2;
    if (paramm2 == null) {
      paramm1 = "";
    }
    aa localaa = com.tencent.mm.plugin.finder.storage.logic.d.AnN.b(l, (csg)localObject);
    Log.i("Finder.VideoLayout", "[findBestVideo] feedId=" + com.tencent.mm.ae.d.Fw(l) + " mediaId=" + paramm1 + " videoFlag=" + localaa.ztP);
    if (paramFeedData.getId() == 0L)
    {
      paramBoolean1 = true;
      paramm2 = localaa.aBv();
      LinkedList localLinkedList = this.mediaList;
      if (!localaa.ztO.TzU) {
        break label1347;
      }
      paramm1 = localaa.ztO.zBo;
      label523:
      this.ANY = new b(paramFeedData, paramm2, localaa, paramInt1, localLinkedList, paramBoolean1, paramm1, (byte)0);
      paramm1 = ai.zZt;
      paramm2 = localaa.ztO.mediaId;
      paramm1 = paramm2;
      if (paramm2 == null) {
        paramm1 = "";
      }
      ai.u(paramm1, localaa.ztP.detail, localaa.getUrl(), localaa.dIZ());
      ehq();
      this.ANM = true;
      if (((csg)localObject).TAa == null)
      {
        paramm1 = (CharSequence)((csg)localObject).TzX;
        if ((paramm1 != null) && (paramm1.length() != 0)) {
          break label1353;
        }
        paramInt1 = 1;
        label643:
        if ((paramInt1 != 0) || (!this.ANP)) {
          break label1379;
        }
      }
      if (!this.ANP) {
        break label1358;
      }
    }
    label708:
    label973:
    label1358:
    for (paramm1 = (com.tencent.mm.plugin.finder.loader.r)new o((csg)localObject, com.tencent.mm.plugin.finder.storage.u.Alz);; paramm1 = new com.tencent.mm.plugin.finder.loader.r((csg)localObject, com.tencent.mm.plugin.finder.storage.u.Alz, null, null, 12))
    {
      getThumbView().setScaleType(ImageView.ScaleType.CENTER_CROP);
      if (((csg)localObject).mediaType != 9) {
        break label1512;
      }
      paramm2 = com.tencent.mm.plugin.finder.loader.t.ztT;
      paramm2 = com.tencent.mm.plugin.finder.loader.t.dJl();
      localObject = (CharSequence)paramm1.ztQ;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label1525;
      }
      paramInt1 = 1;
      label735:
      if (paramInt1 == 0) {
        paramm2.jGB.aRF().a(new com.tencent.mm.loader.h.a.a((com.tencent.mm.loader.h.a.c)paramm1));
      }
      paramm2 = paramm2.bQ(paramm1);
      if (!this.ANP) {
        break label1530;
      }
      paramm1 = com.tencent.mm.plugin.finder.loader.t.ztT;
      paramm1 = com.tencent.mm.plugin.finder.loader.t.a(t.a.ztV);
      paramm2 = paramm2.a(paramm1).a((com.tencent.mm.loader.f.e)new e(this));
      paramm1 = com.tencent.mm.plugin.finder.storage.d.AjH;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.dUT().aSr()).intValue() <= 0) {
        break label1546;
      }
      paramm1 = new com.tencent.mm.loader.e.d(null, new com.tencent.mm.loader.e.b.g(this), 1);
      label857:
      paramm2.a((com.tencent.mm.loader.f.d)paramm1).c(getThumbView());
      paramm1 = this.ANN.en(localaa.aBv(), paramInt2);
      if (paramm1 != null)
      {
        if (paramr != null) {
          paramr.qW(true);
        }
        if (paramr != null) {
          paramr.setProgress(paramm1.progress);
        }
        re(true);
        if (paramr != null) {
          paramr.egK();
        }
        paramm1 = this.ANY;
        if (paramm1 != null) {
          paramm1.AKv = true;
        }
        if (paramr == null) {
          break label1552;
        }
        paramr.setVisibility(0);
        paramm1 = x.aazN;
        if (paramm1 != null) {}
      }
      else
      {
        paramm1 = (FinderVideoLayout)this;
        paramm1.re(false);
        if (paramr != null) {
          paramr.aGh("Finder.VideoLayoutconvert");
        }
        paramm1 = paramm1.ANY;
        if (paramm1 != null) {
          paramm1.AKv = false;
        }
        if (paramr != null)
        {
          paramr.egH();
          paramr = x.aazN;
        }
      }
      if (paramBoolean2) {
        if (this.xyS != null)
        {
          paramr = this.xyR;
          if (paramr == null) {
            break label1558;
          }
          paramm1 = com.tencent.mm.kernel.h.aHG();
          p.j(paramm1, "MMKernel.storage()");
          paramr.Q(paramm1.aHp().getBoolean(ar.a.VBI, true), false);
          paramr = x.aazN;
          if (paramr != null) {}
        }
        else
        {
          paramr = (FinderVideoLayout)this;
          paramm1 = paramr.getContext();
          p.j(paramm1, "context");
          paramr.xyS = new com.tencent.mm.plugin.finder.feed.d(paramm1);
          paramm1 = (View)paramr;
          paramm2 = paramr.xyS;
          if (paramm2 == null) {
            p.iCn();
          }
          paramr.xyR = new com.tencent.mm.plugin.finder.feed.e(paramm1, paramm2);
          paramm1 = paramr.xyS;
          if (paramm1 == null) {
            p.iCn();
          }
          paramr = paramr.xyR;
          if (paramr == null) {
            p.iCn();
          }
          paramm1.a(paramr);
          paramr = x.aazN;
        }
      }
      paramr = this.xyS;
      if (paramr != null) {
        paramr.a(paramFeedData, paramInt2);
      }
      paramFeedData = getBulletSubtitleButton();
      paramr = this.xyR;
      if (paramr == null) {
        break label1563;
      }
      paramBoolean1 = paramr.getFunctionSwitch();
      label1233:
      paramFeedData.setSelected(paramBoolean1);
      paramFeedData = this.AOa;
      if (paramFeedData == null) {
        break label1574;
      }
      paramFeedData.setVisibility(0);
      paramFeedData.setPlayBtnOnClickListener((View.OnClickListener)new h(paramFeedData, this));
      paramr = this.ANU;
      if (paramr == null) {
        break label1569;
      }
      paramInt1 = paramr.getVideoDuration();
      paramFeedData.setVideoTotalTime(paramInt1);
      paramFeedData.setIsPlay(true);
      paramFeedData.setIplaySeekCallback((com.tencent.mm.plugin.sight.decode.ui.b)new i(paramFeedData, this));
      p.k(this, "videoLayout");
      setOnTouchListener((View.OnTouchListener)new FinderLongVideoPlayerSeekBar.c(paramFeedData, this));
      AppMethodBeat.o(284800);
      return;
      paramBoolean1 = false;
      break;
      paramm1 = null;
      break label523;
      paramInt1 = 0;
      break label643;
    }
    label793:
    label1090:
    label1347:
    label1353:
    label1379:
    paramm1 = "";
    label1285:
    if (this.isLongVideo)
    {
      paramm1 = getContext();
      if (paramm1 == null)
      {
        paramFeedData = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(284800);
        throw paramFeedData;
      }
      paramm1 = ((MMActivity)paramm1).getIntent().getStringExtra("KEY_VIDEO_THUMB_LOCAL_PATH");
      if (paramm1 != null) {
        break label1581;
      }
      paramm1 = "";
    }
    label1546:
    label1552:
    label1558:
    label1563:
    label1569:
    label1574:
    label1581:
    for (;;)
    {
      paramm2 = getContext();
      if (paramm2 == null)
      {
        paramFeedData = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(284800);
        throw paramFeedData;
      }
      ((MMActivity)paramm2).getIntent().removeExtra("KEY_VIDEO_THUMB_LOCAL_PATH");
      paramm1 = new com.tencent.mm.plugin.finder.loader.r((csg)localObject, com.tencent.mm.plugin.finder.storage.u.Alz, null, paramm1, 4);
      break;
      label1512:
      paramm2 = com.tencent.mm.plugin.finder.loader.t.ztT;
      paramm2 = com.tencent.mm.plugin.finder.loader.t.dJe();
      break label708;
      label1525:
      paramInt1 = 0;
      break label735;
      label1530:
      paramm1 = com.tencent.mm.plugin.finder.loader.t.ztT;
      paramm1 = com.tencent.mm.plugin.finder.loader.t.a(t.a.ztU);
      break label793;
      paramm1 = null;
      break label857;
      paramm1 = null;
      break label973;
      paramr = null;
      break label1090;
      paramBoolean1 = true;
      break label1233;
      paramInt1 = 0;
      break label1285;
      AppMethodBeat.o(284800);
      return;
    }
  }
  
  public final void a(int paramInt, final com.tencent.mm.plugin.findersdk.f.a parama)
  {
    AppMethodBeat.i(284802);
    this.AOd = paramInt;
    Object localObject = com.tencent.mm.plugin.finder.live.report.k.yBj;
    com.tencent.mm.plugin.finder.live.report.k.dDm().yDd = paramInt;
    if (this.ANY == null)
    {
      AppMethodBeat.o(284802);
      return;
    }
    if (!this.AOe)
    {
      localObject = new StringBuilder("isEnablePlay false ");
      parama = this.ANY;
      if (parama != null) {}
      for (parama = parama.mediaId;; parama = null)
      {
        Log.w("Finder.VideoLayout", parama);
        AppMethodBeat.o(284802);
        return;
      }
    }
    localObject = this.ANY;
    if (localObject == null) {
      p.iCn();
    }
    l locall = this.xkW;
    if (locall == null) {
      p.bGy("videoCore");
    }
    locall.ehl().a((ViewGroup)this, (ac)((b)localObject).zBB, (kotlin.g.a.b)new n(this, parama, (b)localObject));
    AppMethodBeat.o(284802);
  }
  
  public final void a(ac paramac, com.tencent.mm.i.h paramh, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(284808);
    p.k(paramac, "video");
    StringBuilder localStringBuilder = new StringBuilder("[onStopDownload] videoView=");
    Object localObject = this.ANU;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(localObject.hashCode());; localObject = null)
    {
      Log.i("Finder.VideoLayout", localObject + " FinderVideo=" + paramac + " thumbVisible=" + getThumbView().getVisibility());
      paramac = this.ANY;
      if (paramac == null) {
        break label158;
      }
      localObject = getVideoPlayBehavior();
      if (localObject == null) {
        break;
      }
      ((c.b)localObject).a(paramac.feed.getExpectId(), paramac.zBB.ztO, paramh, paramd, (ac)paramac.zBB);
      AppMethodBeat.o(284808);
      return;
    }
    AppMethodBeat.o(284808);
    return;
    label158:
    AppMethodBeat.o(284808);
  }
  
  public final boolean ac(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(284822);
    p.k(paramMotionEvent, "event");
    if (getBulletSubtitleButton().getVisibility() != 0)
    {
      AppMethodBeat.o(284822);
      return false;
    }
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    ViewParent localViewParent = getBulletSubtitleButton().getParent();
    if (localViewParent == null)
    {
      paramMotionEvent = new kotlin.t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(284822);
      throw paramMotionEvent;
    }
    ((View)localViewParent).getHitRect(localRect2);
    getBulletSubtitleButton().getHitRect(localRect1);
    localRect1.top += localRect2.top;
    localRect1.bottom += localRect2.top;
    localRect1.left += localRect2.left;
    localRect1.right += localRect2.left;
    localRect2 = new Rect();
    getFullscreenIcon().getHitRect(localRect2);
    if ((localRect2.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) || (localRect1.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))
    {
      AppMethodBeat.o(284822);
      return true;
    }
    AppMethodBeat.o(284822);
    return false;
  }
  
  public final void ae(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(169678);
    p.k(paramString, "mediaId");
    paramString = this.ANY;
    if (paramString != null)
    {
      if (paramString.AOk) {}
      while (paramString != null)
      {
        c.b localb = getVideoPlayBehavior();
        if (localb != null)
        {
          localb.e(paramString.feed.getExpectId(), paramString.zBB.ztO, paramInt1, paramInt2, (ac)paramString.zBB);
          AppMethodBeat.o(169678);
          return;
          paramString = null;
        }
        else
        {
          AppMethodBeat.o(169678);
          return;
        }
      }
    }
    AppMethodBeat.o(169678);
  }
  
  public final void b(ac paramac)
  {
    Object localObject2 = null;
    AppMethodBeat.i(284807);
    p.k(paramac, "video");
    Object localObject3 = new StringBuilder("[onStartDownload] videoView=");
    Object localObject1 = this.ANU;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(localObject1.hashCode());
      Log.i("Finder.VideoLayout", localObject1 + " FinderVideo=" + paramac + " thumbVisible=" + getThumbView().getVisibility());
      ehs();
      paramac = this.ANY;
      if (paramac != null) {
        if (!paramac.AOk) {
          break label213;
        }
      }
    }
    for (;;)
    {
      if (paramac != null)
      {
        localObject1 = getVideoPlayBehavior();
        if (localObject1 != null) {
          ((c.b)localObject1).e(paramac.feed.getExpectId(), paramac.zBB.ztO, (ac)paramac.zBB);
        }
      }
      paramac = com.tencent.mm.plugin.finder.report.j.zVy;
      com.tencent.mm.plugin.finder.report.j.Pl(this.fEH);
      localObject1 = com.tencent.mm.plugin.finder.report.h.zVd;
      localObject3 = this.ANY;
      paramac = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((b)localObject3).feed;
        paramac = localObject2;
        if (localObject3 != null) {
          paramac = Long.valueOf(((FeedData)localObject3).getId());
        }
      }
      ((com.tencent.mm.plugin.finder.report.h)localObject1).h(paramac);
      AppMethodBeat.o(284807);
      return;
      localObject1 = null;
      break;
      label213:
      paramac = null;
    }
  }
  
  public final void bl(float paramFloat)
  {
    boolean bool = true;
    AppMethodBeat.i(284820);
    Object localObject2 = new StringBuilder("[seekTo] percent=").append(paramFloat).append(" isSeekMode=").append(ehp()).append(" videoView=");
    Object localObject1 = this.ANU;
    label103:
    int j;
    int i;
    label159:
    label184:
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(localObject1.hashCode());
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(" videoDurationSec=");
      localObject1 = this.ANU;
      if (localObject1 == null) {
        break label406;
      }
      localObject1 = Integer.valueOf(((s)localObject1).getVideoDuration());
      Log.i("Finder.VideoLayout", localObject1);
      localObject2 = this.ANU;
      if (localObject2 != null)
      {
        j = ((s)localObject2).getCurrentPlaySecond();
        localObject1 = this.ANU;
        if (localObject1 == null) {
          break label412;
        }
        i = ((s)localObject1).getVideoDuration();
        paramFloat = androidx.core.b.a.c(i * paramFloat, 0.0F, i - 1.0F);
        double d = paramFloat;
        if (ehp()) {
          break label418;
        }
        if ((((s)localObject2).a(d, bool, 2)) && (Math.abs(j - paramFloat) > 1.0F))
        {
          this.AOg = paramFloat;
          localObject3 = new StringBuilder("[seekTo] successfully seek to ").append(paramFloat).append(" videoDurationSec=");
          localObject1 = this.ANU;
          if (localObject1 == null) {
            break label424;
          }
          localObject1 = Integer.valueOf(((s)localObject1).getVideoDuration());
          label261:
          Log.i("Finder.VideoLayout", localObject1);
        }
        localObject1 = this.ANY;
        if (localObject1 != null) {
          if (!((b)localObject1).AOk) {
            break label430;
          }
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject3 = getVideoPlayBehavior();
        if (localObject3 != null) {
          ((c.b)localObject3).d(((b)localObject1).feed.getExpectId(), ((b)localObject1).zBB.ztO, j, (int)paramFloat, (ac)((b)localObject1).zBB);
        }
        b(((b)localObject1).feed.getExpectId(), ((s)localObject2).getVideoMediaId(), j, (int)paramFloat);
      }
      localObject1 = this.ANY;
      if (localObject1 == null) {
        break label436;
      }
      if (!((b)localObject1).AKv) {
        re(false);
      }
      AppMethodBeat.o(284820);
      return;
      localObject1 = null;
      break;
      label406:
      localObject1 = null;
      break label103;
      label412:
      i = 1;
      break label159;
      label418:
      bool = false;
      break label184;
      label424:
      localObject1 = null;
      break label261;
      label430:
      localObject1 = null;
    }
    label436:
    AppMethodBeat.o(284820);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168103);
    StringBuilder localStringBuilder = new StringBuilder("[onError] videoView=");
    paramString1 = this.ANU;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      Log.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2 + " errorMsg=" + paramString3 + " what=" + paramInt1 + " extra=" + paramInt2);
      paramString1 = this.ANZ;
      if (paramString1 != null) {
        paramString1.setVisibility(8);
      }
      ehr();
      paramString1 = n.zWF;
      n.Py(paramInt1);
      paramString1 = this.ANY;
      if (paramString1 == null) {
        break label181;
      }
      paramString2 = getVideoPlayBehavior();
      if (paramString2 == null) {
        break;
      }
      paramString2.a(paramString1.feed.getExpectId(), paramString1.zBB.ztO, paramInt1);
      AppMethodBeat.o(168103);
      return;
    }
    AppMethodBeat.o(168103);
    return;
    label181:
    AppMethodBeat.o(168103);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168106);
    StringBuilder localStringBuilder = new StringBuilder("[onGetVideoSize] videoView=");
    paramString1 = this.ANU;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      Log.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2 + " width=" + paramInt1 + " height=" + paramInt2);
      AppMethodBeat.o(168106);
      return;
    }
  }
  
  public final void dS(String paramString1, String paramString2)
  {
    Integer localInteger = null;
    AppMethodBeat.i(168104);
    paramString1 = this.ANU;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.getVideoDuration());; paramString1 = null)
    {
      StringBuilder localStringBuilder = new StringBuilder("[onPrepared] videoView=");
      s locals = this.ANU;
      if (locals != null) {
        localInteger = Integer.valueOf(locals.hashCode());
      }
      Log.i("Finder.VideoLayout", localInteger + " mediaId=" + paramString2 + " thumbVisible=" + getThumbView().getVisibility() + " duration=" + paramString1);
      AppMethodBeat.o(168104);
      return;
    }
  }
  
  public final void dT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(168105);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoEnded] videoView=");
    paramString1 = this.ANU;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      Log.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      AppMethodBeat.o(168105);
      return;
    }
  }
  
  public final void dU(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(168107);
    Object localObject2 = new StringBuilder("[onVideoPause] videoView=");
    paramString1 = this.ANU;
    if (paramString1 != null)
    {
      paramString1 = Integer.valueOf(paramString1.hashCode());
      Log.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      cYm();
      paramString1 = com.tencent.mm.plugin.finder.report.h.zVd;
      paramString1 = this.ANY;
      if (paramString1 == null) {
        break label198;
      }
      paramString1 = paramString1.feed;
      if (paramString1 == null) {
        break label198;
      }
      paramString1 = Long.valueOf(paramString1.getId());
      label97:
      if (paramString1 == null) {
        break label203;
      }
      paramString1.longValue();
      localObject2 = com.tencent.mm.plugin.finder.report.h.Mj(paramString1.longValue());
      if ((((h.a)localObject2).zVe <= 0L) || (((h.a)localObject2).zVi != 0L) || (((h.a)localObject2).zVf != 0L)) {
        break label210;
      }
    }
    label198:
    label203:
    label210:
    for (int i = 1;; i = 0)
    {
      paramString2 = localObject1;
      if (i != 0) {
        paramString2 = (String)localObject2;
      }
      if (paramString2 == null) {
        break label215;
      }
      paramString2.zVf = cm.bfE();
      com.tencent.mm.plugin.finder.report.h.zVb.add(paramString2);
      com.tencent.mm.plugin.finder.report.h.zVa.remove(paramString1);
      AppMethodBeat.o(168107);
      return;
      paramString1 = null;
      break;
      paramString1 = null;
      break label97;
      AppMethodBeat.o(168107);
      return;
    }
    label215:
    AppMethodBeat.o(168107);
  }
  
  public final void dV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(168108);
    paramString1 = this.ANU;
    int i;
    label52:
    label104:
    int j;
    label230:
    boolean bool;
    if (paramString1 != null)
    {
      i = paramString1.getVideoDuration();
      Object localObject = new StringBuilder("[onVideoPlay] videoView=");
      paramString1 = this.ANU;
      if (paramString1 == null) {
        break label657;
      }
      paramString1 = Integer.valueOf(paramString1.hashCode());
      localObject = ((StringBuilder)localObject).append(paramString1).append(" mediaId=").append(paramString2).append(" duration=").append(i).append(" isHasPlayed=");
      paramString1 = this.ANY;
      if (paramString1 == null) {
        break label662;
      }
      paramString1 = Boolean.valueOf(paramString1.AOl);
      Log.i("Finder.VideoLayout", paramString1);
      paramString1 = this.ANY;
      if ((paramString1 != null) && (!paramString1.AOl) && (paramString2 != null))
      {
        paramString1 = this.ANN;
        j = this.fEH;
        p.k(paramString2, "mediaId");
        localObject = (j.a)paramString1.Bhy.get(com.tencent.mm.plugin.finder.viewmodel.j.eo(paramString2, j));
        paramString1.Bhy.remove(paramString2);
        paramString2 = new StringBuilder("[getVideoProgress] mediaId=").append(paramString2).append(" tabType=").append(j).append(" progress=");
        if (localObject == null) {
          break label667;
        }
        paramString1 = Integer.valueOf(((j.a)localObject).progress);
        paramString2 = paramString2.append(paramString1).append(" timestamp=");
        if (localObject == null) {
          break label672;
        }
        paramString1 = Double.valueOf(((j.a)localObject).BhA);
        label256:
        Log.i("Finder.VideoStateCacheVM", paramString1);
        if (localObject != null)
        {
          paramString2 = this.ANU;
          if (paramString2 != null)
          {
            float f = ((j.a)localObject).progress;
            paramString1 = this.ANZ;
            if (paramString1 == null) {
              break label677;
            }
            j = paramString1.getMaxProgress();
            label309:
            f = f * 1.0F / j;
            j = paramString2.getCurrentPlaySecond();
            f = androidx.core.b.a.c(f * i, 0.0F, i - 1.0F);
            paramString1 = this.ANZ;
            if (paramString1 != null) {
              paramString1.setProgress(((j.a)localObject).progress);
            }
            double d = f;
            if (ehp()) {
              break label683;
            }
            bool = true;
            label378:
            paramString2.a(d, bool);
            paramString1 = this.ANY;
            if (paramString1 != null)
            {
              if (!paramString1.AOk) {
                break label689;
              }
              label404:
              if (paramString1 != null)
              {
                c.b localb = getVideoPlayBehavior();
                if (localb != null) {
                  localb.d(paramString1.feed.getExpectId(), paramString1.zBB.ztO, j, (int)f, (ac)paramString1.zBB);
                }
                b(paramString1.feed.getExpectId(), paramString2.getVideoMediaId(), j, (int)f);
              }
            }
          }
          paramString2 = this.ANU;
          paramString1 = paramString2;
          if (!(paramString2 instanceof FinderThumbPlayerProxy)) {
            paramString1 = null;
          }
          paramString1 = (FinderThumbPlayerProxy)paramString1;
          if (paramString1 == null) {
            break label694;
          }
          paramString1.setPlaySpeed(((j.a)localObject).BhB);
          paramString1 = x.aazN;
          label511:
          if (paramString1 != null) {}
        }
        else
        {
          paramString2 = this.ANU;
          paramString1 = paramString2;
          if (!(paramString2 instanceof FinderThumbPlayerProxy)) {
            paramString1 = null;
          }
          paramString1 = (FinderThumbPlayerProxy)paramString1;
          if (paramString1 != null)
          {
            paramString1.setPlaySpeed(1.0F);
            paramString1 = x.aazN;
          }
        }
      }
      paramString1 = this.ANY;
      if (paramString1 != null) {
        paramString1.AOl = true;
      }
      cYm();
      ehs();
      paramString1 = this.ANU;
      if (paramString1 != null) {
        paramString1.setKeepScreenOn(true);
      }
      this.AOg = -1.0F;
      b(this);
      paramString2 = com.tencent.mm.plugin.finder.report.h.zVd;
      paramString1 = this.ANY;
      if (paramString1 == null) {
        break label699;
      }
      paramString1 = paramString1.feed;
      if (paramString1 == null) {
        break label699;
      }
    }
    label657:
    label662:
    label667:
    label672:
    label677:
    label683:
    label689:
    label694:
    label699:
    for (paramString1 = Long.valueOf(paramString1.getId());; paramString1 = null)
    {
      paramString2.i(paramString1);
      paramString1 = com.tencent.mm.plugin.finder.report.j.zVy;
      com.tencent.mm.plugin.finder.report.j.Po(this.fEH);
      AppMethodBeat.o(168108);
      return;
      i = 0;
      break;
      paramString1 = null;
      break label52;
      paramString1 = null;
      break label104;
      paramString1 = null;
      break label230;
      paramString1 = null;
      break label256;
      j = 1;
      break label309;
      bool = false;
      break label378;
      paramString1 = null;
      break label404;
      paramString1 = null;
      break label511;
    }
  }
  
  public final void dW(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(168109);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoWaiting] videoView=");
    Object localObject1 = this.ANU;
    if (localObject1 != null) {}
    for (localObject1 = Integer.valueOf(localObject1.hashCode());; localObject1 = null)
    {
      Log.i("Finder.VideoLayout", localObject1 + " mediaId=" + paramString2 + " thumbVisible=" + getThumbView().getVisibility());
      paramString2 = this.ANU;
      if (((paramString2 == null) || (paramString2.getVideoViewFocused() != true)) && (paramString1 != null)) {
        break label186;
      }
      showLoading();
      paramString2 = this.ANY;
      if (paramString2 == null) {
        break label186;
      }
      paramString1 = localObject2;
      if (paramString2.AOk) {
        paramString1 = paramString2;
      }
      if (paramString1 == null) {
        break label186;
      }
      paramString2 = getVideoPlayBehavior();
      if (paramString2 == null) {
        break;
      }
      paramString2.b(paramString1.feed.getExpectId(), paramString1.zBB.ztO, (ac)paramString1.zBB);
      AppMethodBeat.o(168109);
      return;
    }
    AppMethodBeat.o(168109);
    return;
    label186:
    AppMethodBeat.o(168109);
  }
  
  public final void dX(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(168110);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoWaitingEnd] videoView=");
    paramString1 = this.ANU;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      Log.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      cYm();
      paramString2 = this.ANY;
      if (paramString2 == null) {
        break label145;
      }
      paramString1 = localObject;
      if (paramString2.AOk) {
        paramString1 = paramString2;
      }
      if (paramString1 == null) {
        break label145;
      }
      paramString2 = getVideoPlayBehavior();
      if (paramString2 == null) {
        break;
      }
      paramString2.c(paramString1.feed.getExpectId(), paramString1.zBB.ztO, (ac)paramString1.zBB);
      AppMethodBeat.o(168110);
      return;
    }
    AppMethodBeat.o(168110);
    return;
    label145:
    AppMethodBeat.o(168110);
  }
  
  public final String eht()
  {
    Object localObject2 = null;
    AppMethodBeat.i(168130);
    Object localObject3 = new StringBuilder("mediaId:");
    Object localObject1 = this.ANU;
    if (localObject1 != null)
    {
      localObject1 = ((s)localObject1).getVideoMediaId();
      localObject1 = ((StringBuilder)localObject3).append((String)localObject1).append(' ').append(hashCode()).append(':');
      localObject3 = this.ANU;
      if (localObject3 == null) {
        break label137;
      }
    }
    label137:
    for (int i = localObject3.hashCode();; i = 0)
    {
      localObject3 = ((StringBuilder)localObject1).append(i).append(" alpha=");
      s locals = this.ANU;
      localObject1 = localObject2;
      if (locals != null) {
        localObject1 = Float.valueOf(locals.getAlpha());
      }
      localObject1 = localObject1;
      AppMethodBeat.o(168130);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  public final boolean ehu()
  {
    AppMethodBeat.i(284817);
    s locals = this.ANU;
    if (locals != null)
    {
      boolean bool = locals.isPlaying();
      AppMethodBeat.o(284817);
      return bool;
    }
    AppMethodBeat.o(284817);
    return false;
  }
  
  public final void ehv()
  {
    AppMethodBeat.i(284818);
    Object localObject = this.ANU;
    if (localObject != null) {
      ((s)localObject).pause();
    }
    localObject = this.ANY;
    if (localObject != null)
    {
      if (!((b)localObject).AKv) {
        re(true);
      }
      AppMethodBeat.o(284818);
      return;
    }
    AppMethodBeat.o(284818);
  }
  
  public final boolean ehw()
  {
    b localb = this.ANY;
    return (localb != null) && (localb.AOk == true);
  }
  
  public final void fC(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(284806);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoFirstFrameDraw] videoView=");
    paramString1 = this.ANU;
    if (paramString1 != null)
    {
      paramString1 = Integer.valueOf(paramString1.hashCode());
      Log.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      aGk("onVideoFirstFrameDraw");
      paramString1 = com.tencent.mm.plugin.finder.report.j.zVy;
      com.tencent.mm.plugin.finder.report.j.Pm(this.fEH);
      paramString1 = com.tencent.mm.plugin.finder.report.h.zVd;
      paramString1 = this.ANY;
      if (paramString1 == null) {
        break label205;
      }
      paramString1 = paramString1.feed;
      if (paramString1 == null) {
        break label205;
      }
      paramString1 = Long.valueOf(paramString1.getId());
      label111:
      if (paramString1 == null) {
        break label210;
      }
      paramString1.longValue();
      paramString2 = com.tencent.mm.plugin.finder.report.h.Mj(paramString1.longValue());
      if (((paramString2.zVg <= 0L) && (paramString2.zVe <= 0L)) || (paramString2.zVi != 0L)) {
        break label217;
      }
    }
    label205:
    label210:
    label217:
    for (int i = 1;; i = 0)
    {
      paramString1 = localObject;
      if (i != 0) {
        paramString1 = paramString2;
      }
      if (paramString1 == null) {
        break label222;
      }
      paramString1.zVi = cm.bfE();
      com.tencent.mm.plugin.finder.report.h.zVb.add(paramString1);
      com.tencent.mm.plugin.finder.report.h.zVa.clear();
      AppMethodBeat.o(284806);
      return;
      paramString1 = null;
      break;
      paramString1 = null;
      break label111;
      AppMethodBeat.o(284806);
      return;
    }
    label222:
    AppMethodBeat.o(284806);
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(284828);
    Object localObject = this.ANU;
    if (localObject != null)
    {
      Bitmap localBitmap = ((s)localObject).getBitmap();
      localObject = localBitmap;
      if (localBitmap != null) {}
    }
    else
    {
      localObject = getThumbView().getDrawable();
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        AppMethodBeat.o(284828);
        throw ((Throwable)localObject);
      }
      localObject = ((BitmapDrawable)localObject).getBitmap();
    }
    AppMethodBeat.o(284828);
    return localObject;
  }
  
  public final long getCurrentPosMs()
  {
    AppMethodBeat.i(284825);
    s locals = this.ANU;
    if (locals != null)
    {
      long l = locals.getCurrentPlayMs();
      AppMethodBeat.o(284825);
      return l;
    }
    AppMethodBeat.o(284825);
    return 0L;
  }
  
  public final int getCurrentPosSec()
  {
    AppMethodBeat.i(284824);
    s locals = this.ANU;
    if (locals != null)
    {
      int i = locals.getCurrentPlaySecond();
      AppMethodBeat.o(284824);
      return i;
    }
    AppMethodBeat.o(284824);
    return 0;
  }
  
  public final z getLifecycle()
  {
    return this.ALf;
  }
  
  public final FinderLongVideoPlayerSeekBar getLongVideoSeekBar()
  {
    return this.AOa;
  }
  
  public final int getPlayAdapterPosition()
  {
    return this.AOd;
  }
  
  public final b getPlayInfo()
  {
    return this.ANY;
  }
  
  public final View getRetryBtn()
  {
    AppMethodBeat.i(168092);
    View localView = (View)this.ANW.getValue();
    AppMethodBeat.o(168092);
    return localView;
  }
  
  public final m<Boolean, b, x> getThumbShowCallback()
  {
    return this.AOc;
  }
  
  public final l getVideoCore()
  {
    AppMethodBeat.i(168088);
    l locall = this.xkW;
    if (locall == null) {
      p.bGy("videoCore");
    }
    AppMethodBeat.o(168088);
    return locall;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(284823);
    s locals = this.ANU;
    if (locals != null)
    {
      int i = locals.getVideoDuration();
      AppMethodBeat.o(284823);
      return i;
    }
    AppMethodBeat.o(284823);
    return 0;
  }
  
  public final m<Boolean, b, x> getVideoPauseCallback()
  {
    return this.AOb;
  }
  
  public final c.b getVideoPlayBehavior()
  {
    AppMethodBeat.i(168129);
    Object localObject = this.xkW;
    if (localObject == null) {
      p.bGy("videoCore");
    }
    localObject = ((l)localObject).ANB;
    if (localObject != null)
    {
      localObject = (c.b)new c.c((com.tencent.mm.plugin.finder.event.c)localObject);
      AppMethodBeat.o(168129);
      return localObject;
    }
    AppMethodBeat.o(168129);
    return null;
  }
  
  public final s getVideoView()
  {
    return this.ANU;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(284804);
    super.onAttachedToWindow();
    StringBuilder localStringBuilder = new StringBuilder("onAttachedToWindow ");
    Object localObject = this.ANY;
    if (localObject != null) {}
    for (localObject = ((b)localObject).mediaId;; localObject = null)
    {
      Log.i("Finder.VideoLayout", (String)localObject);
      localObject = this.xkW;
      if (localObject == null) {
        p.bGy("videoCore");
      }
      ((l)localObject).ehl().a(this.zCi);
      AppMethodBeat.o(284804);
      return;
    }
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(168099);
    super.onDetachedFromWindow();
    StringBuilder localStringBuilder = new StringBuilder("[onDetachedFromWindow] ");
    Object localObject = this.ANY;
    if (localObject != null)
    {
      localObject = ((b)localObject).mediaId;
      Log.i("Finder.VideoLayout", (String)localObject);
      if (this.ANP) {
        break label116;
      }
    }
    label116:
    for (boolean bool = true;; bool = false)
    {
      pause(bool);
      localObject = this.xyS;
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.feed.d)localObject).onDetach();
      }
      localObject = this.xkW;
      if (localObject == null) {
        p.bGy("videoCore");
      }
      ((l)localObject).ehl().b(this.zCi);
      AppMethodBeat.o(168099);
      return;
      localObject = null;
      break;
    }
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(168101);
    p.k(paramView, "child");
    super.onViewAdded(paramView);
    if ((paramView instanceof s))
    {
      Log.i("Finder.VideoLayout", "[onViewAdded] isPreviewing=" + ((s)paramView).egx() + ' ' + eht());
      if (((s)paramView).egx()) {
        setVisibility(0);
      }
    }
    AppMethodBeat.o(168101);
  }
  
  public final void onViewRemoved(View paramView)
  {
    float f2 = 1.0F;
    int k = 0;
    AppMethodBeat.i(168102);
    p.k(paramView, "child");
    super.onViewRemoved(paramView);
    Object localObject1;
    if ((p.h(paramView, this.ANU)) && ((paramView instanceof s)))
    {
      Log.i("Finder.VideoLayout", "[onViewRemoved] isPreviewing=" + ((s)paramView).egx() + ' ' + eht());
      localObject1 = this.ANZ;
      if (localObject1 != null) {
        ((r)localObject1).egH();
      }
      localObject1 = this.ANY;
      Object localObject3;
      Object localObject4;
      int j;
      label189:
      Object localObject2;
      float f1;
      label228:
      int m;
      if ((localObject1 != null) && (((b)localObject1).AKv == true))
      {
        localObject3 = this.ANN;
        localObject1 = this.ANY;
        if (localObject1 == null) {
          p.iCn();
        }
        localObject4 = ((b)localObject1).mediaId;
        localObject1 = this.ANZ;
        if (localObject1 != null)
        {
          i = ((r)localObject1).getCurrentProgress();
          localObject1 = this.ANU;
          if (localObject1 == null) {
            break label516;
          }
          j = ((s)localObject1).getCurrentPlaySecond();
          localObject2 = this.ANU;
          localObject1 = localObject2;
          if (!(localObject2 instanceof FinderThumbPlayerProxy)) {
            localObject1 = null;
          }
          localObject1 = (FinderThumbPlayerProxy)localObject1;
          if (localObject1 == null) {
            break label522;
          }
          f1 = ((FinderThumbPlayerProxy)localObject1).getPlaySpeedRatio();
          ((com.tencent.mm.plugin.finder.viewmodel.j)localObject3).a((String)localObject4, i, j, f1);
        }
      }
      else
      {
        localObject4 = this.ANN;
        localObject1 = this.ANY;
        if (localObject1 == null) {
          p.iCn();
        }
        localObject3 = ((b)localObject1).mediaId;
        m = this.fEH;
        localObject1 = this.ANZ;
        if (localObject1 == null) {
          break label527;
        }
      }
      label516:
      label522:
      label527:
      for (int i = ((r)localObject1).getCurrentProgress();; i = 0)
      {
        localObject1 = this.ANU;
        j = k;
        if (localObject1 != null) {
          j = ((s)localObject1).getCurrentPlaySecond();
        }
        localObject2 = this.ANU;
        localObject1 = localObject2;
        if (!(localObject2 instanceof FinderThumbPlayerProxy)) {
          localObject1 = null;
        }
        localObject1 = (FinderThumbPlayerProxy)localObject1;
        f1 = f2;
        if (localObject1 != null) {
          f1 = ((FinderThumbPlayerProxy)localObject1).getPlaySpeedRatio();
        }
        p.k(localObject3, "mediaId");
        Log.i("Finder.VideoStateCacheVM", "[storeProgress] mediaId=" + (String)localObject3 + " tabType=" + m + " progress=" + i + " timestamp=" + j);
        localObject1 = (Map)((com.tencent.mm.plugin.finder.viewmodel.j)localObject4).Bhy;
        localObject2 = com.tencent.mm.plugin.finder.viewmodel.j.eo((String)localObject3, m);
        localObject3 = new j.a((String)localObject3);
        ((j.a)localObject3).progress = i;
        ((j.a)localObject3).BhA = j;
        ((j.a)localObject3).BhB = f1;
        ((Map)localObject1).put(localObject2, localObject3);
        if (!((s)paramView).egx()) {
          break label533;
        }
        setVisibility(4);
        AppMethodBeat.o(168102);
        return;
        i = 0;
        break;
        j = 0;
        break label189;
        f1 = 1.0F;
        break label228;
      }
      label533:
      localObject1 = new StringBuilder("[videoView = null] mediaId=");
      paramView = this.ANY;
      if (paramView == null) {
        break label594;
      }
    }
    label594:
    for (paramView = paramView.mediaId;; paramView = null)
    {
      Log.i("Finder.VideoStateCacheVM", paramView);
      ehq();
      cYm();
      this.ANU = null;
      AppMethodBeat.o(168102);
      return;
    }
  }
  
  public final void pause(boolean paramBoolean)
  {
    AppMethodBeat.i(168097);
    Object localObject1 = this.ANY;
    if ((localObject1 != null) && (!((b)localObject1).AOk) && (!paramBoolean))
    {
      AppMethodBeat.o(168097);
      return;
    }
    Object localObject2 = new StringBuilder("[FinderVideoLayout#pause] ").append(eht()).append(" isForceRemoveVideoView=").append(paramBoolean).append(" isSeekMode=");
    localObject1 = this.ANY;
    label130:
    boolean bool;
    label163:
    hq.a locala;
    long l;
    if (localObject1 != null)
    {
      localObject1 = Boolean.valueOf(((b)localObject1).AKv);
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(' ').append("media=");
      localObject1 = this.ANY;
      if (localObject1 == null) {
        break label451;
      }
      localObject1 = ((b)localObject1).mediaId;
      Log.i("Finder.VideoLayout", (String)localObject1);
      localObject1 = this.ANY;
      if (localObject1 == null) {
        break label457;
      }
      bool = ((b)localObject1).AKv;
      localObject1 = this.xkW;
      if (localObject1 == null) {
        p.bGy("videoCore");
      }
      ((l)localObject1).ehl().a((ViewGroup)this, paramBoolean, bool);
      cYm();
      localObject1 = this.xyR;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.feed.e)localObject1).reset(false);
      }
      localObject1 = this.ANY;
      if (localObject1 != null) {
        ((b)localObject1).AOk = false;
      }
      this.AOh = -1;
      localObject1 = this.ANY;
      if (localObject1 != null)
      {
        localObject1 = ((b)localObject1).feed;
        if (localObject1 != null)
        {
          localObject2 = new hq();
          locala = ((hq)localObject2).fEE;
          if (((FeedData)localObject1).getLocalId() == 0L) {
            break label462;
          }
          l = ((FeedData)localObject1).getLocalId();
          label294:
          locala.feedId = l;
          locala = ((hq)localObject2).fEE;
          if (((FeedData)localObject1).getLocalId() == 0L) {
            break label471;
          }
        }
      }
    }
    label451:
    label457:
    label462:
    label471:
    for (paramBoolean = true;; paramBoolean = false)
    {
      locala.fEF = paramBoolean;
      ((hq)localObject2).fEE.fEs = true;
      ((hq)localObject2).fEE.fEH = this.fEH;
      EventCenter.instance.publish((IEvent)localObject2);
      localObject1 = this.ANY;
      if ((localObject1 != null) && (((b)localObject1).zBB.ztO.mediaType == 9))
      {
        localObject2 = getVideoPlayBehavior();
        if (localObject2 != null) {
          ((c.b)localObject2).a(((b)localObject1).feed.getExpectId(), ((b)localObject1).zBB.ztO, ((b)localObject1).mediaList, (ac)((b)localObject1).zBB, null);
        }
      }
      setKeepScreenOn(false);
      AppMethodBeat.o(168097);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label130;
      bool = false;
      break label163;
      l = ((FeedData)localObject1).getFeedId();
      break label294;
    }
  }
  
  public final void re(boolean paramBoolean)
  {
    AppMethodBeat.i(284813);
    Object localObject = this.AOb;
    if (localObject != null) {
      ((m)localObject).invoke(Boolean.valueOf(paramBoolean), this.ANY);
    }
    if (paramBoolean)
    {
      localObject = com.tencent.mm.kernel.h.aHG();
      p.j(localObject, "MMKernel.storage()");
      paramBoolean = ((com.tencent.mm.kernel.f)localObject).aHp().getBoolean(ar.a.VBI, true);
      getBulletSubtitleButton().setSelected(paramBoolean);
      localObject = com.tencent.mm.kernel.h.ae(ae.class);
      p.j(localObject, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if (((ae)localObject).dYT())
      {
        localObject = findViewById(b.f.video_bullet_divider);
        p.j(localObject, "findViewById<View>(R.id.video_bullet_divider)");
        ((View)localObject).setVisibility(8);
        localObject = findViewById(b.f.video_bullet_subtitle_button);
        p.j(localObject, "findViewById<TextView>(R…o_bullet_subtitle_button)");
        ((TextView)localObject).setVisibility(8);
      }
      if (this.xyS != null)
      {
        getBottomButtonLayout().setVisibility(0);
        localObject = this.xyR;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.finder.feed.e)localObject).dsO();
          if (localObject != null) {
            ((WxRecyclerView)localObject).setAlpha(0.3F);
          }
        }
      }
      this.ANL = true;
      AppMethodBeat.o(284813);
      return;
    }
    if (this.xyS != null)
    {
      getBottomButtonLayout().setVisibility(8);
      localObject = this.xyR;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.feed.e)localObject).dsO();
        if (localObject != null) {
          ((WxRecyclerView)localObject).setAlpha(1.0F);
        }
      }
    }
    this.ANL = false;
    AppMethodBeat.o(284813);
  }
  
  public final void rf(boolean paramBoolean)
  {
    b localb = null;
    boolean bool2 = true;
    AppMethodBeat.i(284816);
    Object localObject2 = new StringBuilder("onEnterSeekMode mediaId=");
    Object localObject1 = this.ANY;
    if (localObject1 != null)
    {
      localObject1 = ((b)localObject1).mediaId;
      Log.i("Finder.VideoLayout", (String)localObject1);
      localObject1 = this.ANY;
      if (localObject1 != null) {
        ((b)localObject1).AKv = paramBoolean;
      }
      if (!paramBoolean) {
        break label295;
      }
      localObject1 = this.ANY;
      if (localObject1 != null)
      {
        localObject2 = getVideoPlayBehavior();
        if (localObject2 != null) {
          ((c.b)localObject2).a(((b)localObject1).feed.getExpectId(), ((b)localObject1).zBB.ztO, (ac)((b)localObject1).zBB);
        }
      }
      re(true);
      localObject1 = this.ANU;
      if (localObject1 != null) {
        ((s)localObject1).setVideoViewFocused(false);
      }
      localObject1 = this.ANU;
      if (localObject1 != null) {
        ((s)localObject1).pause();
      }
    }
    for (;;)
    {
      if (!paramBoolean) {
        this.ANN.ekf();
      }
      localObject2 = new StringBuilder("[onEnterSeekMode] isEnter=").append(paramBoolean).append(" alpha=");
      s locals = this.ANU;
      localObject1 = localb;
      if (locals != null) {
        localObject1 = Float.valueOf(locals.getAlpha());
      }
      localObject1 = ((StringBuilder)localObject2).append(localObject1).append(" mediaId=");
      localb = this.ANY;
      if (localb == null) {
        p.iCn();
      }
      Log.i("Finder.VideoLayout", localb.mediaId);
      AppMethodBeat.o(284816);
      return;
      localObject1 = null;
      break;
      label295:
      re(false);
      locals = this.ANU;
      if (locals != null)
      {
        localObject1 = getContext();
        if (localObject1 == null)
        {
          localObject1 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(284816);
          throw ((Throwable)localObject1);
        }
        if (!((MMActivity)localObject1).isPaused())
        {
          bool1 = true;
          label356:
          locals.setVideoViewFocused(bool1);
          localObject1 = this.ANY;
          if (localObject1 != null)
          {
            localObject2 = ((b)localObject1).mediaId;
            localObject1 = localObject2;
            if (localObject2 != null) {}
          }
          else
          {
            localObject1 = "";
          }
          if (this.ANN.en((String)localObject1, this.fEH) == null) {
            break label474;
          }
          a(this, 0, 3);
          if (!com.tencent.mm.q.a.aAo()) {
            break label448;
          }
          bool1 = true;
          label426:
          if (!bool1) {
            break label456;
          }
        }
        for (boolean bool1 = bool2;; bool1 = false)
        {
          locals.setMute(bool1);
          break;
          bool1 = false;
          break label356;
          label448:
          bool1 = this.iYs;
          break label426;
          label456:
          if (this.xkW == null) {
            p.bGy("videoCore");
          }
        }
        label474:
        locals.bqo();
      }
    }
  }
  
  public final void rg(boolean paramBoolean)
  {
    AppMethodBeat.i(284830);
    if (paramBoolean)
    {
      a(this, 0, 3);
      AppMethodBeat.o(284830);
      return;
    }
    pause(false);
    AppMethodBeat.o(284830);
  }
  
  public final void setEnablePlay(boolean paramBoolean)
  {
    this.AOe = paramBoolean;
  }
  
  public final void setEnableShowLoading(boolean paramBoolean)
  {
    this.ANM = paramBoolean;
  }
  
  public final void setLongVideo(boolean paramBoolean)
  {
    this.isLongVideo = paramBoolean;
  }
  
  public final void setLongVideoSeekBar(FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar)
  {
    this.AOa = paramFinderLongVideoPlayerSeekBar;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.iYs = paramBoolean;
  }
  
  public final void setPlayAdapterPosition(int paramInt)
  {
    this.AOd = paramInt;
  }
  
  public final void setPlayInfo(b paramb)
  {
    this.ANY = paramb;
  }
  
  public final void setThumbShowCallback(m<? super Boolean, ? super b, x> paramm)
  {
    this.AOc = paramm;
  }
  
  public final void setVideoCore(l paraml)
  {
    AppMethodBeat.i(168089);
    p.k(paraml, "<set-?>");
    this.xkW = paraml;
    AppMethodBeat.o(168089);
  }
  
  public final void setVideoPauseCallback(m<? super Boolean, ? super b, x> paramm)
  {
    this.AOb = paramm;
  }
  
  public final void setVideoView(s params)
  {
    this.ANU = params;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$Companion;", "", "()V", "ICON_DISMISS_DURATION", "", "LIMIT_SHOW_PROGRESS", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "mediaId", "", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "position", "", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "isLocal", "", "isFocusPlaying", "isSeekMode", "isHasPlayed", "cropInfo", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;ILjava/util/LinkedList;ZZZZLcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;)V", "getCropInfo", "()Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "setCropInfo", "(Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "()Z", "setFocusPlaying", "(Z)V", "setHasPlayed", "setSeekMode", "getMedia", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "getMediaId", "()Ljava/lang/String;", "getMediaList", "()Ljava/util/LinkedList;", "getPosition", "()I", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class b
  {
    public boolean AKv;
    public boolean AOk;
    boolean AOl;
    public final boolean fEF;
    public final FeedData feed;
    public final String mediaId;
    public final LinkedList<csg> mediaList;
    private final int position;
    public final aa zBB;
    css zBo;
    
    private b(FeedData paramFeedData, String paramString, aa paramaa, int paramInt, LinkedList<csg> paramLinkedList, boolean paramBoolean, css paramcss)
    {
      AppMethodBeat.i(249595);
      this.feed = paramFeedData;
      this.mediaId = paramString;
      this.zBB = paramaa;
      this.position = paramInt;
      this.mediaList = paramLinkedList;
      this.fEF = paramBoolean;
      this.AOk = false;
      this.AKv = false;
      this.AOl = false;
      this.zBo = paramcss;
      AppMethodBeat.o(249595);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(168056);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.h(this.feed, paramObject.feed)) || (!p.h(this.mediaId, paramObject.mediaId)) || (!p.h(this.zBB, paramObject.zBB)) || (this.position != paramObject.position) || (!p.h(this.mediaList, paramObject.mediaList)) || (this.fEF != paramObject.fEF) || (this.AOk != paramObject.AOk) || (this.AKv != paramObject.AKv) || (this.AOl != paramObject.AOl) || (!p.h(this.zBo, paramObject.zBo))) {}
        }
      }
      else
      {
        AppMethodBeat.o(168056);
        return true;
      }
      AppMethodBeat.o(168056);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(168054);
      String str = "PlayInfo(feed=" + this.feed + ", mediaId=" + this.mediaId + ", media=" + this.zBB + ", position=" + this.position + ", mediaList=" + this.mediaList + ", isLocal=" + this.fEF + ", isFocusPlaying=" + this.AOk + ", isSeekMode=" + this.AKv + ", isHasPlayed=" + this.AOl + ", cropInfo=" + this.zBo + ")";
      AppMethodBeat.o(168054);
      return str;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<LinearLayout>
  {
    c(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<TextView>
  {
    d(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$bulletSubtitleButton$2$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderVideoLayout.d paramd) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(222833);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/FinderVideoLayout$bulletSubtitleButton$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramView = FinderVideoLayout.j(this.AOn.AOm);
        if (paramView == null) {
          p.iCn();
        }
        if (!paramView.getFunctionSwitch()) {}
        for (boolean bool = true;; bool = false)
        {
          FinderVideoLayout.r(this.AOn.AOm).setSelected(bool);
          paramView = com.tencent.mm.kernel.h.aHG();
          p.j(paramView, "MMKernel.storage()");
          paramView.aHp().set(ar.a.VBI, Boolean.valueOf(bool));
          paramView = FinderVideoLayout.j(this.AOn.AOm);
          if (paramView == null) {
            p.iCn();
          }
          paramView.Q(bool, true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderVideoLayout$bulletSubtitleButton$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(222833);
          return;
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class e<T, R>
    implements com.tencent.mm.loader.f.e<w, Bitmap>
  {
    e(FinderVideoLayout paramFinderVideoLayout) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$dismissThumb$1$1"})
  static final class f
    implements Runnable
  {
    f(s params, FinderVideoLayout paramFinderVideoLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(168058);
      this.AOo.animate().cancel();
      this.AOo.animate().alpha(1.0F).setDuration(200L).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(287652);
          this.AOp.AOo.setAlpha(1.0F);
          FinderVideoLayout.a(this.AOp.AOm, false);
          AppMethodBeat.o(287652);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(287653);
          FinderVideoLayout.a(this.AOp.AOm, true);
          AppMethodBeat.o(287653);
        }
      }).start();
      AppMethodBeat.o(168058);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<View>
  {
    g(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$fullscreenIcon$2$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(View paramView, FinderVideoLayout.g paramg) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(270925);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/FinderVideoLayout$fullscreenIcon$2$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramView = new csf();
        paramView.mediaList.addAll((Collection)FinderVideoLayout.s(this.AOq.AOm));
        localObject = com.tencent.mm.plugin.finder.utils.a.ACH;
        localObject = this.xkv.getContext();
        if (localObject == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(270925);
          throw paramView;
        }
        com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject, null, paramView, null, false, false, 56);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderVideoLayout$fullscreenIcon$2$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(270925);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$initLongVideoSeekBar$1$1"})
  static final class h
    implements View.OnClickListener
  {
    h(FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar, FinderVideoLayout paramFinderVideoLayout) {}
    
    public final void onClick(View paramView)
    {
      boolean bool2 = true;
      AppMethodBeat.i(285054);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/FinderVideoLayout$initLongVideoSeekBar$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      boolean bool3 = this.AOr.cTl();
      paramView = jdField_this;
      if (!bool3)
      {
        bool1 = true;
        paramView.rg(bool1);
        paramView = this.AOr;
        if (bool3) {
          break label164;
        }
      }
      label164:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramView.setIsPlay(bool1);
        if (bool3)
        {
          paramView = jdField_this.getPlayInfo();
          if (paramView != null)
          {
            localObject = jdField_this.getVideoPlayBehavior();
            if (localObject != null) {
              ((c.b)localObject).a(paramView.feed.getExpectId(), paramView.zBB.ztO, (ac)paramView.zBB);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderVideoLayout$initLongVideoSeekBar$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(285054);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/FinderVideoLayout$initLongVideoSeekBar$1$2", "Lcom/tencent/mm/plugin/sight/decode/ui/IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "plugin-finder_release"})
  public static final class i
    implements com.tencent.mm.plugin.sight.decode.ui.b
  {
    i(FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar, FinderVideoLayout paramFinderVideoLayout) {}
    
    public final void aRo()
    {
      AppMethodBeat.i(287764);
      jdField_this.rg(false);
      this.AOr.setIsPlay(false);
      kotlin.g.a.a locala = this.AOr.getOnSeekStart();
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(287764);
        return;
      }
      AppMethodBeat.o(287764);
    }
    
    public final void tY(int paramInt)
    {
      int j = 0;
      AppMethodBeat.i(287763);
      this.AOr.tY(paramInt);
      Object localObject1 = jdField_this.getVideoView();
      if (localObject1 != null) {
        ((s)localObject1).a(paramInt, true);
      }
      FinderVideoLayout.a(jdField_this, 0, 3);
      this.AOr.setIsPlay(true);
      localObject1 = this.AOr.getOnSeekEnd();
      if (localObject1 != null) {
        ((kotlin.g.a.a)localObject1).invoke();
      }
      localObject1 = jdField_this.getPlayInfo();
      if (localObject1 != null)
      {
        Object localObject2;
        long l;
        int i;
        if (((FinderVideoLayout.b)localObject1).AOk)
        {
          if (localObject1 == null) {
            break label272;
          }
          localObject2 = jdField_this.getVideoPlayBehavior();
          if (localObject2 != null)
          {
            l = ((FinderVideoLayout.b)localObject1).feed.getExpectId();
            csg localcsg = ((FinderVideoLayout.b)localObject1).zBB.ztO;
            s locals = jdField_this.getVideoView();
            if (locals == null) {
              break label261;
            }
            i = locals.getCurrentPlaySecond();
            label162:
            ((c.b)localObject2).d(l, localcsg, i, paramInt, (ac)((FinderVideoLayout.b)localObject1).zBB);
          }
          l = ((FinderVideoLayout.b)localObject1).feed.getExpectId();
          localObject1 = jdField_this.getVideoView();
          if (localObject1 == null) {
            break label266;
          }
        }
        label261:
        label266:
        for (localObject1 = ((s)localObject1).getVideoMediaId();; localObject1 = null)
        {
          localObject2 = jdField_this.getVideoView();
          i = j;
          if (localObject2 != null) {
            i = ((s)localObject2).getCurrentPlaySecond();
          }
          FinderVideoLayout.b(l, (String)localObject1, i, paramInt);
          AppMethodBeat.o(287763);
          return;
          localObject1 = null;
          break;
          i = 0;
          break label162;
        }
      }
      label272:
      AppMethodBeat.o(287763);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/FinderVideoLayout$lifecycle$1", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "onBeforePlay", "", "info", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "mediaSource", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "bgPreparedStatus", "", "onBgPrepared", "onFirstFrameUpdate", "prepareCostTime", "", "onFirstVideoFrameRendered", "onPause", "onStopPlayData", "Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;", "onPlay", "onPlayProgress", "offset", "total", "onPlayProgressMs", "offsetMs", "totalMs", "onPlayerConfigChange", "playerConfig", "Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "onReplay", "onStopPlay", "plugin-finder_release"})
  public static final class j
    implements z
  {
    public final void Ma(long paramLong)
    {
      AppMethodBeat.i(266775);
      FinderVideoLayout.b localb = this.AOm.getPlayInfo();
      if (localb != null)
      {
        Object localObject = ai.zZt;
        String str = localb.zBB.ztO.mediaId;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        ai.bv((String)localObject, true);
        this.AOm.fC("", localb.mediaId);
        localObject = this.AOm.getVideoPlayBehavior();
        if (localObject != null)
        {
          ((c.b)localObject).a(localb.feed.getExpectId(), localb.zBB.ztO, (ac)localb.zBB, paramLong);
          AppMethodBeat.o(266775);
          return;
        }
        AppMethodBeat.o(266775);
        return;
      }
      AppMethodBeat.o(266775);
    }
    
    public final void U(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(266786);
      if (this.AOm.getPlayInfo() != null) {
        FinderVideoLayout.a(this.AOm, paramLong1, paramLong2);
      }
      AppMethodBeat.o(266786);
    }
    
    public final void a(com.tencent.mm.plugin.finder.video.reporter.e parame)
    {
      AppMethodBeat.i(266779);
      FinderVideoLayout.b localb = this.AOm.getPlayInfo();
      if (localb != null)
      {
        c.b localb1 = this.AOm.getVideoPlayBehavior();
        if (localb1 != null)
        {
          localb1.a(localb.feed.getExpectId(), localb.zBB.ztO, localb.mediaList, (ac)localb.zBB, parame);
          AppMethodBeat.o(266779);
          return;
        }
        AppMethodBeat.o(266779);
        return;
      }
      AppMethodBeat.o(266779);
    }
    
    public final void a(com.tencent.mm.plugin.finder.video.reporter.f paramf)
    {
      AppMethodBeat.i(266780);
      FinderVideoLayout.b localb = this.AOm.getPlayInfo();
      if (localb != null)
      {
        c.b localb1 = this.AOm.getVideoPlayBehavior();
        if (localb1 != null)
        {
          localb1.a(localb.feed.getExpectId(), localb.zBB.ztO, localb.mediaList, (ac)localb.zBB, paramf);
          AppMethodBeat.o(266780);
          return;
        }
        AppMethodBeat.o(266780);
        return;
      }
      AppMethodBeat.o(266780);
    }
    
    public final void a(t paramt, int paramInt)
    {
      AppMethodBeat.i(266774);
      FinderVideoLayout.b localb = this.AOm.getPlayInfo();
      if (localb != null)
      {
        c.b localb1 = this.AOm.getVideoPlayBehavior();
        if (localb1 != null)
        {
          localb1.a(localb.feed.getId(), localb.zBB.ztO, paramt, this.AOm.getPlayAdapterPosition(), (ac)localb.zBB, paramInt);
          AppMethodBeat.o(266774);
          return;
        }
        AppMethodBeat.o(266774);
        return;
      }
      AppMethodBeat.o(266774);
    }
    
    public final void a(t paramt, com.tencent.mm.plugin.finder.video.reporter.e parame)
    {
      AppMethodBeat.i(266773);
      if (paramt != null)
      {
        Object localObject = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
        localObject = com.tencent.mm.plugin.finder.storage.logic.d.aEU(paramt.mediaId);
        if (!((av)localObject).field_hasPlayed)
        {
          ((av)localObject).field_hasPlayed = true;
          com.tencent.mm.ae.d.h((kotlin.g.a.a)new a((av)localObject));
        }
        localObject = this.AOm.getVideoPlayBehavior();
        if (localObject != null)
        {
          ((c.b)localObject).a(paramt.xzp.getId(), paramt.APg, paramt.xqx, parame);
          AppMethodBeat.o(266773);
          return;
        }
        AppMethodBeat.o(266773);
        return;
      }
      AppMethodBeat.o(266773);
    }
    
    public final void a(csg paramcsg)
    {
      AppMethodBeat.i(266772);
      FinderVideoLayout.a(this.AOm, "onBgPrepared");
      StringBuilder localStringBuilder = new StringBuilder("onBgPrepared ");
      if (paramcsg != null)
      {
        String str = paramcsg.mediaId;
        paramcsg = str;
        if (str != null) {}
      }
      else
      {
        paramcsg = "";
      }
      Log.i("Finder.VideoLayout", paramcsg);
      AppMethodBeat.o(266772);
    }
    
    public final void a(csg paramcsg, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(266782);
      FinderVideoLayout.b localb = this.AOm.getPlayInfo();
      if (localb != null)
      {
        Object localObject = this.AOm.getVideoView();
        int i;
        label184:
        label188:
        boolean bool;
        if (localObject != null)
        {
          i = ((s)localObject).getCurrentPlaySecond();
          localObject = this.AOm.getVideoPlayBehavior();
          if (localObject != null) {
            ((c.b)localObject).a(localb.feed.getExpectId(), localb.zBB.ztO, paramInt1, paramInt2, (ac)localb.zBB);
          }
          if (paramInt1 >= 20)
          {
            localObject = FinderVideoLayout.d(this.AOm);
            if ((localObject != null) && (!((r)localObject).egI()))
            {
              localObject = FinderVideoLayout.d(this.AOm);
              if (localObject != null) {
                ((r)localObject).qW(false);
              }
            }
          }
          localObject = localb.zBo;
          if (localObject != null)
          {
            if ((((css)localObject).endTime <= 0) || (((css)localObject).fod < 0) || (((css)localObject).endTime <= ((css)localObject).fod)) {
              break label493;
            }
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break label498;
            }
            if ((localObject != null) && (i >= ((css)localObject).endTime / 1000))
            {
              s locals = this.AOm.getVideoView();
              localObject = locals;
              if (!(locals instanceof FinderCropVideoView)) {
                localObject = null;
              }
              localObject = (FinderCropVideoView)localObject;
              if (localObject != null)
              {
                localObject = ((FinderCropVideoView)localObject).txH;
                if (localObject != null) {
                  ((com.tencent.mm.pluginsdk.ui.tools.k)localObject).b(0.0D, true);
                }
              }
              localObject = new hq();
              ((hq)localObject).fEE.fEF = true;
              ((hq)localObject).fEE.feedId = localb.feed.getLocalId();
              ((hq)localObject).fEE.fEG = true;
              ((hq)localObject).fEE.fEH = FinderVideoLayout.t(this.AOm);
              EventCenter.instance.publish((IEvent)localObject);
            }
          }
          if ((paramcsg == null) || (paramcsg.TzR != 3))
          {
            paramcsg = com.tencent.mm.plugin.finder.storage.d.AjH;
            paramInt1 = com.tencent.mm.plugin.finder.storage.d.dSX();
            paramcsg = com.tencent.mm.plugin.finder.storage.d.AjH;
            if (i == paramInt1 - ((Number)com.tencent.mm.plugin.finder.storage.d.AeQ.getValue()).intValue())
            {
              paramcsg = new hq();
              localObject = paramcsg.fEE;
              if (localb.feed.getLocalId() == 0L) {
                break label504;
              }
              bool = true;
              label409:
              ((hq.a)localObject).fEF = bool;
              localObject = paramcsg.fEE;
              if (!paramcsg.fEE.fEF) {
                break label510;
              }
            }
          }
        }
        label493:
        label498:
        label504:
        label510:
        for (long l = localb.feed.getLocalId();; l = localb.feed.getFeedId())
        {
          ((hq.a)localObject).feedId = l;
          paramcsg.fEE.fEH = FinderVideoLayout.t(this.AOm);
          EventCenter.instance.publish((IEvent)paramcsg);
          FinderVideoLayout.b(this.AOm);
          AppMethodBeat.o(266782);
          return;
          i = 0;
          break;
          paramInt1 = 0;
          break label184;
          localObject = null;
          break label188;
          bool = false;
          break label409;
        }
      }
      AppMethodBeat.o(266782);
    }
    
    public final void dJU()
    {
      AppMethodBeat.i(168063);
      Object localObject1 = this.AOm.getPlayInfo();
      if (localObject1 != null)
      {
        Object localObject2 = this.AOm.getVideoPlayBehavior();
        if (localObject2 != null) {
          ((c.b)localObject2).d(((FinderVideoLayout.b)localObject1).feed.getExpectId(), ((FinderVideoLayout.b)localObject1).zBB.ztO, (ac)((FinderVideoLayout.b)localObject1).zBB);
        }
        localObject2 = new hq();
        ((hq)localObject2).fEE.feedId = ((FinderVideoLayout.b)localObject1).feed.getExpectId();
        ((hq)localObject2).fEE.fEG = true;
        ((hq)localObject2).fEE.fEH = FinderVideoLayout.t(this.AOm);
        EventCenter.instance.publish((IEvent)localObject2);
        localObject1 = this.AOm.getLongVideoSeekBar();
        if (localObject1 != null)
        {
          localObject1 = ((FinderLongVideoPlayerSeekBar)localObject1).zvL;
          if (localObject1 != null)
          {
            ((FinderLongVideoPlayerSeekBar.b)localObject1).dJB();
            AppMethodBeat.o(168063);
            return;
          }
          AppMethodBeat.o(168063);
          return;
        }
        AppMethodBeat.o(168063);
        return;
      }
      AppMethodBeat.o(168063);
    }
    
    public final void dJV()
    {
      AppMethodBeat.i(168064);
      Object localObject1 = this.AOm.getPlayInfo();
      if (localObject1 != null)
      {
        Object localObject2 = this.AOm.getVideoPlayBehavior();
        if (localObject2 != null) {
          ((c.b)localObject2).a(((FinderVideoLayout.b)localObject1).feed.getExpectId(), ((FinderVideoLayout.b)localObject1).zBB.ztO, ((FinderVideoLayout.b)localObject1).mediaList, (ac)((FinderVideoLayout.b)localObject1).zBB);
        }
        if (FinderVideoLayout.o(this.AOm) > 0L)
        {
          localObject2 = ai.zZt;
          localObject2 = ((FinderVideoLayout.b)localObject1).zBB.ztO.mediaId;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ai.aEg((String)localObject1);
          localObject1 = this.AOm.getVideoView();
          if (localObject1 != null) {
            ((s)localObject1).a(FinderVideoLayout.o(this.AOm) / 1000.0D, true, FinderVideoLayout.p(this.AOm));
          }
          FinderVideoLayout.a(this.AOm, 0L);
          FinderVideoLayout.b(this.AOm, 1);
          localObject2 = this.AOm.getVideoView();
          localObject1 = localObject2;
          if (!(localObject2 instanceof FinderThumbPlayerProxy)) {
            localObject1 = null;
          }
          localObject1 = (FinderThumbPlayerProxy)localObject1;
          if (localObject1 != null) {
            ((FinderThumbPlayerProxy)localObject1).setPlaySpeed(FinderVideoLayout.q(this.AOm));
          }
          FinderVideoLayout.a(this.AOm, 1.0F);
        }
        AppMethodBeat.o(168064);
        return;
      }
      AppMethodBeat.o(168064);
    }
    
    public final void dJW()
    {
      Object localObject2 = null;
      AppMethodBeat.i(266777);
      FinderVideoLayout.b localb = this.AOm.getPlayInfo();
      if (localb != null)
      {
        Object localObject1 = ai.zZt;
        Object localObject3 = localb.zBB.ztO.mediaId;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        ai.aEh((String)localObject1);
        localObject3 = this.AOm;
        String str = localb.mediaId;
        StringBuilder localStringBuilder = new StringBuilder("[onFirstVideoFrameRendered] videoView=");
        localObject1 = ((FinderVideoLayout)localObject3).ANU;
        if (localObject1 != null)
        {
          localObject1 = Integer.valueOf(localObject1.hashCode());
          Log.i("Finder.VideoLayout", localObject1 + " mediaId=" + str);
          localObject1 = com.tencent.mm.plugin.finder.report.h.zVd;
          localObject1 = ((FinderVideoLayout)localObject3).ANY;
          if (localObject1 == null) {
            break label293;
          }
          localObject1 = ((FinderVideoLayout.b)localObject1).feed;
          if (localObject1 == null) {
            break label293;
          }
          localObject1 = Long.valueOf(((FeedData)localObject1).getId());
          label153:
          if (localObject1 != null)
          {
            ((Long)localObject1).longValue();
            localObject3 = com.tencent.mm.plugin.finder.report.h.Mj(((Long)localObject1).longValue());
            if (((((h.a)localObject3).zVg <= 0L) && (((h.a)localObject3).zVe <= 0L)) || (((h.a)localObject3).zVj != 0L)) {
              break label298;
            }
          }
        }
        label293:
        label298:
        for (int i = 1;; i = 0)
        {
          localObject1 = localObject2;
          if (i != 0) {
            localObject1 = localObject3;
          }
          if (localObject1 != null)
          {
            ((h.a)localObject1).zVj = cm.bfE();
            com.tencent.mm.plugin.finder.report.h.zVb.add(localObject1);
            com.tencent.mm.plugin.finder.report.h.zVa.clear();
          }
          localObject1 = this.AOm.getVideoPlayBehavior();
          if (localObject1 == null) {
            break label303;
          }
          ((c.b)localObject1).f(localb.feed.getExpectId(), localb.zBB.ztO, (ac)localb.zBB);
          AppMethodBeat.o(266777);
          return;
          localObject1 = null;
          break;
          localObject1 = null;
          break label153;
        }
        label303:
        AppMethodBeat.o(266777);
        return;
      }
      AppMethodBeat.o(266777);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(av paramav)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends q
    implements kotlin.g.a.a<View>
  {
    k(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    l(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/FinderVideoLayout$onHeadsetStateChangeListener$1", "Lcom/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver$OnHeadsetStateChangeListener;", "onHeadsetStateChange", "", "on", "", "plugin-finder_release"})
  public static final class m
    implements HeadsetReceiver.b
  {
    public final void pR(boolean paramBoolean)
    {
      AppMethodBeat.i(281442);
      Log.i("Finder.FeedFullVideoConvert", "onHeadsetStateChange on:" + paramBoolean + " isVideoPlaying:" + this.AOm.ehu());
      if ((!paramBoolean) && (this.AOm.ehu()))
      {
        if (this.AOm.getLongVideoSeekBar() != null)
        {
          this.AOm.rg(false);
          localObject = this.AOm.getLongVideoSeekBar();
          if (localObject == null) {
            p.iCn();
          }
          ((FinderLongVideoPlayerSeekBar)localObject).setIsPlay(false);
          AppMethodBeat.o(281442);
          return;
        }
        this.AOm.rf(true);
        Object localObject = FinderVideoLayout.d(this.AOm);
        if (localObject != null) {
          ((r)localObject).egK();
        }
        localObject = FinderVideoLayout.d(this.AOm);
        if (localObject != null)
        {
          ((r)localObject).qW(true);
          AppMethodBeat.o(281442);
          return;
        }
      }
      AppMethodBeat.o(281442);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.b<s, x>
  {
    n(FinderVideoLayout paramFinderVideoLayout, com.tencent.mm.plugin.findersdk.f.a parama, FinderVideoLayout.b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$prepareToPlay$1$1"})
  public static final class o
    extends q
    implements kotlin.g.a.b<s, x>
  {
    public o(FinderVideoLayout.b paramb, FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<View>
  {
    p(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$retryBtn$2$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderVideoLayout.p paramp) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(168076);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/FinderVideoLayout$retryBtn$2$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("Finder.VideoLayout", "retry video, position:" + this.AOv.AOm.getPlayAdapterPosition());
        paramView = this.AOv.AOm.getPlayInfo();
        if ((paramView != null) && (paramView.AOk == true))
        {
          paramView = this.AOv.AOm.getVideoView();
          if (paramView != null) {
            paramView.stop();
          }
          FinderVideoLayout.a(this.AOv.AOm, this.AOv.AOm.getPlayAdapterPosition(), 2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderVideoLayout$retryBtn$2$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168076);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<x>
  {
    q(FinderVideoLayout paramFinderVideoLayout, long paramLong, int paramInt, float paramFloat)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/FinderVideoLayout$showLoading$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class r
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(271267);
      FinderVideoLayout.l(this.AOm).setAlpha(1.0F);
      FinderVideoLayout.l(this.AOm).setVisibility(0);
      AppMethodBeat.o(271267);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    s(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$updateProgress$1$1"})
  static final class t
    implements Runnable
  {
    t(r paramr, FinderVideoLayout paramFinderVideoLayout, long paramLong1, long paramLong2, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(287026);
      if ((!this.AOy.egJ()) && (paramLong2 > 0L) && (FinderVideoLayout.m(jdField_this) == -1.0F))
      {
        this.AOy.bk(1.0F * (float)i / (float)paramLong2);
        if (FinderVideoLayout.n(jdField_this) != this.AOB)
        {
          this.AOy.he(this.AOB, this.AOC);
          FinderVideoLayout.a(jdField_this, this.AOB);
        }
      }
      AppMethodBeat.o(287026);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$updateProgress$2$1"})
  static final class u
    implements Runnable
  {
    u(FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar, FinderVideoLayout paramFinderVideoLayout, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(288658);
      this.AOr.setVideoTotalTime(j);
      this.AOr.AS(i);
      Object localObject = this.AOr;
      s locals = jdField_this.getVideoView();
      if (locals != null) {}
      for (long l = locals.getCurrentPlayMs();; l = 0L)
      {
        localObject = ((FinderLongVideoPlayerSeekBar)localObject).zvL;
        if (localObject == null) {
          break;
        }
        ((FinderLongVideoPlayerSeekBar.b)localObject).LX(l);
        AppMethodBeat.o(288658);
        return;
      }
      AppMethodBeat.o(288658);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class v
    extends q
    implements kotlin.g.a.a<View>
  {
    v(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoLayout
 * JD-Core Version:    0.7.0.1
 */