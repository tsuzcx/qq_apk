package com.tencent.mm.plugin.finder.video;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
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
import com.tencent.mm.g.a.hj;
import com.tencent.mm.g.a.hj.a;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.c.b;
import com.tencent.mm.plugin.finder.event.c.c;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.report.af;
import com.tencent.mm.plugin.finder.report.f.a;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.viewmodel.FinderVideoStateCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderVideoStateCacheVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar$SeekBarCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomButtonLayout", "Landroid/view/View;", "getBottomButtonLayout", "()Landroid/view/View;", "bottomButtonLayout$delegate", "Lkotlin/Lazy;", "bulletSubtitleButton", "getBulletSubtitleButton", "bulletSubtitleButton$delegate", "bulletSubtitlePresenter", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;", "bulletSubtitleViewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback;", "fullscreenIcon", "kotlin.jvm.PlatformType", "getFullscreenIcon", "fullscreenIcon$delegate", "isEnableFullScreenEnjoy", "", "isEnableShowLoading", "()Z", "setEnableShowLoading", "(Z)V", "isLongVideo", "setLongVideo", "value", "isMute", "setMute", "isNowPause", "isShowThumbAnimating", "lastCurrentPlaySecond", "lastSeekTime", "", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "loading", "getLoading", "loading$delegate", "longVideoSeekBar", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "getLongVideoSeekBar", "()Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "setLongVideoSeekBar", "(Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;)V", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "muteBtn", "Landroid/widget/ImageView;", "getMuteBtn", "()Landroid/widget/ImageView;", "muteBtn$delegate", "playAdapterPosition", "getPlayAdapterPosition", "()I", "setPlayAdapterPosition", "(I)V", "playInfo", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "getPlayInfo", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "setPlayInfo", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;)V", "retryBtn", "getRetryBtn", "retryBtn$delegate", "seekBarLayout", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar;", "startPlayTime", "", "tabType", "thumbShowCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isShow", "", "getThumbShowCallback", "()Lkotlin/jvm/functions/Function2;", "setThumbShowCallback", "(Lkotlin/jvm/functions/Function2;)V", "thumbView", "getThumbView", "thumbView$delegate", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "getVideoCore", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setVideoCore", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;)V", "videoPauseCallback", "isPause", "getVideoPauseCallback", "setVideoPauseCallback", "videoStateVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM;", "videoTypeIv", "getVideoTypeIv", "videoTypeIv$delegate", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "getVideoView", "()Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "setVideoView", "(Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;)V", "adaptForCropShow", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "checkVideoDataAvailable", "mediaId", "", "offset", "length", "convert", "position", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "isEnableFullEnjoy", "isSupportBulletSubtitle", "dismissLoading", "dismissRetryBtn", "dismissThumb", "source", "findBestVideo", "feedId", "getBitmap", "Landroid/graphics/Bitmap;", "getCurrentPosMs", "getCurrentPosSec", "getVideoDurationSec", "getVideoPlayBehavior", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "initLongVideoSeekBar", "isEnableSeek", "isSeekMode", "isVideoPlaying", "layoutLoadingIcon", "loginfo", "onDetachedFromWindow", "onEnterSeekMode", "isEnter", "showPauseTips", "onError", "sessionId", "errorMsg", "what", "extra", "onFinishDownload", "ret", "video", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onFirstVideoFrameRendered", "onGetVideoSize", "width", "height", "onHandlePausePlay", "onHandleResumePlay", "onMoovReadyDownload", "total", "moovFirstDownloaded", "onMute", "mute", "onNeedIgnoreTouchEvent", "event", "Landroid/view/MotionEvent;", "onPrepared", "onProgressDownload", "onStartDownload", "onStartSeek", "onStopDownload", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onStopSeek", "percent", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "onViewAdded", "child", "onViewRecycled", "onViewRemoved", "pause", "isForceRemoveVideoView", "play", "prepare", "isLocal", "feedData", "prepareToPlay", "retryPlay", "setStartPlayTime", "timeMs", "showLoading", "showRetryBtn", "showThumb", "showVideoPauseTip", "show", "showVideoTypeIv", "toggleVideo", "isPlay", "updateProgress", "viewLog", "Companion", "PlayInfo", "plugin-finder_release"})
public final class FinderVideoLayout
  extends FrameLayout
  implements q.a, t, x, i.b
{
  public static final a wfy;
  private int dLS;
  boolean guh;
  private long iJF;
  public boolean isLongVideo;
  private LinkedList<cjl> mediaList;
  public k tCD;
  private com.tencent.mm.plugin.finder.feed.e tOr;
  public com.tencent.mm.plugin.finder.feed.d tOs;
  private final y wcw;
  private boolean wfc;
  private boolean wfd;
  public final FinderVideoStateCacheVM wfe;
  private final kotlin.f wff;
  private boolean wfg;
  private final kotlin.f wfh;
  private final kotlin.f wfi;
  private final kotlin.f wfj;
  private final kotlin.f wfk;
  public r wfl;
  private final kotlin.f wfm;
  private final kotlin.f wfn;
  private final kotlin.f wfo;
  public b wfp;
  public q wfq;
  private FinderLongVideoPlayerSeekBar wfr;
  private kotlin.g.a.m<? super Boolean, ? super b, kotlin.x> wfs;
  private kotlin.g.a.m<? super Boolean, ? super b, kotlin.x> wft;
  private int wfu;
  private boolean wfv;
  private float wfw;
  private int wfx;
  
  static
  {
    AppMethodBeat.i(168083);
    wfy = new a((byte)0);
    AppMethodBeat.o(168083);
  }
  
  public FinderVideoLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168131);
    setTag("Finder.VideoLayout");
    setId(2131300776);
    this.wfd = true;
    paramContext = com.tencent.mm.ui.component.a.PRN;
    paramContext = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoStateCacheVM.class);
    p.g(paramContext, "UICProvider.of(PluginFin…StateCacheVM::class.java)");
    this.wfe = ((FinderVideoStateCacheVM)paramContext);
    this.wff = kotlin.g.ah((kotlin.g.a.a)new k(this));
    this.wfh = kotlin.g.ah((kotlin.g.a.a)new c(this));
    this.wfi = kotlin.g.ah((kotlin.g.a.a)new d(this));
    this.wfj = kotlin.g.ah((kotlin.g.a.a)new l(this));
    this.wfk = kotlin.g.ah((kotlin.g.a.a)new r(this));
    this.mediaList = new LinkedList();
    this.wfm = kotlin.g.ah((kotlin.g.a.a)new g(this));
    this.wfn = kotlin.g.ah((kotlin.g.a.a)new o(this));
    this.wfo = kotlin.g.ah((kotlin.g.a.a)new u(this));
    this.wcw = ((y)new j(this));
    this.wfw = -1.0F;
    this.wfx = -1;
    AppMethodBeat.o(168131);
  }
  
  public FinderVideoLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168132);
    setTag("Finder.VideoLayout");
    setId(2131300776);
    this.wfd = true;
    paramContext = com.tencent.mm.ui.component.a.PRN;
    paramContext = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoStateCacheVM.class);
    p.g(paramContext, "UICProvider.of(PluginFin…StateCacheVM::class.java)");
    this.wfe = ((FinderVideoStateCacheVM)paramContext);
    this.wff = kotlin.g.ah((kotlin.g.a.a)new k(this));
    this.wfh = kotlin.g.ah((kotlin.g.a.a)new c(this));
    this.wfi = kotlin.g.ah((kotlin.g.a.a)new d(this));
    this.wfj = kotlin.g.ah((kotlin.g.a.a)new l(this));
    this.wfk = kotlin.g.ah((kotlin.g.a.a)new r(this));
    this.mediaList = new LinkedList();
    this.wfm = kotlin.g.ah((kotlin.g.a.a)new g(this));
    this.wfn = kotlin.g.ah((kotlin.g.a.a)new o(this));
    this.wfo = kotlin.g.ah((kotlin.g.a.a)new u(this));
    this.wcw = ((y)new j(this));
    this.wfw = -1.0F;
    this.wfx = -1;
    AppMethodBeat.o(168132);
  }
  
  private final void awJ(String paramString)
  {
    AppMethodBeat.i(254312);
    Object localObject = this.wft;
    if (localObject != null) {
      ((kotlin.g.a.m)localObject).invoke(Boolean.FALSE, this.wfp);
    }
    localObject = this.wfl;
    if ((localObject != null) && (((r)localObject).getAlpha() == 1.0F))
    {
      AppMethodBeat.o(254312);
      return;
    }
    if (this.wfv)
    {
      AppMethodBeat.o(254312);
      return;
    }
    Log.i("Finder.VideoLayout", "[dismissThumb] " + dFF() + " source=" + paramString + " isShowThumbAnimating=" + this.wfv);
    paramString = this.wfl;
    if (paramString != null)
    {
      paramString.getVideoView().post((Runnable)new f(paramString, this));
      AppMethodBeat.o(254312);
      return;
    }
    AppMethodBeat.o(254312);
  }
  
  private final void cBY()
  {
    AppMethodBeat.i(254322);
    Object localObject = this.wfq;
    if (localObject != null) {
      post((Runnable)new s((q)localObject, this));
    }
    localObject = this.wfr;
    if (localObject != null)
    {
      ((FinderLongVideoPlayerSeekBar)localObject).post((Runnable)new t((FinderLongVideoPlayerSeekBar)localObject, this));
      AppMethodBeat.o(254322);
      return;
    }
    AppMethodBeat.o(254322);
  }
  
  private final void cJE()
  {
    AppMethodBeat.i(168123);
    Object localObject = this.wfr;
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
  
  private final boolean dFB()
  {
    b localb = this.wfp;
    return (localb != null) && (localb.wbG == true);
  }
  
  private final void dFC()
  {
    AppMethodBeat.i(168119);
    this.wfv = false;
    Object localObject = this.wft;
    if (localObject != null) {
      ((kotlin.g.a.m)localObject).invoke(Boolean.TRUE, this.wfp);
    }
    localObject = this.wfl;
    if (localObject != null) {}
    for (float f = ((r)localObject).getAlpha(); f == 0.0F; f = 0.0F)
    {
      AppMethodBeat.o(168119);
      return;
    }
    localObject = this.wfl;
    if (localObject != null) {
      ((r)localObject).setAlpha(0.0F);
    }
    Log.i("Finder.VideoLayout", "[showThumb] " + dFF());
    AppMethodBeat.o(168119);
  }
  
  private final void dFD()
  {
    AppMethodBeat.i(168121);
    getRetryBtn().animate().cancel();
    getRetryBtn().setVisibility(0);
    q localq = this.wfq;
    if (localq != null) {
      localq.setVisibility(8);
    }
    cJE();
    AppMethodBeat.o(168121);
  }
  
  private final void dFE()
  {
    AppMethodBeat.i(168122);
    getRetryBtn().animate().cancel();
    q localq = this.wfq;
    if (localq != null) {
      localq.setVisibility(0);
    }
    getRetryBtn().setVisibility(8);
    AppMethodBeat.o(168122);
  }
  
  private final String dFF()
  {
    Object localObject2 = null;
    AppMethodBeat.i(168130);
    Object localObject3 = new StringBuilder("mediaId:");
    Object localObject1 = this.wfl;
    if (localObject1 != null)
    {
      localObject1 = ((r)localObject1).getVideoMediaId();
      localObject1 = ((StringBuilder)localObject3).append((String)localObject1).append(' ').append(hashCode()).append(':');
      localObject3 = this.wfl;
      if (localObject3 == null) {
        break label137;
      }
    }
    label137:
    for (int i = localObject3.hashCode();; i = 0)
    {
      localObject3 = ((StringBuilder)localObject1).append(i).append(" alpha=");
      r localr = this.wfl;
      localObject1 = localObject2;
      if (localr != null) {
        localObject1 = Float.valueOf(localr.getAlpha());
      }
      localObject1 = localObject1;
      AppMethodBeat.o(168130);
      return localObject1;
      localObject1 = null;
      break;
    }
  }
  
  private final View getBottomButtonLayout()
  {
    AppMethodBeat.i(254300);
    View localView = (View)this.wfh.getValue();
    AppMethodBeat.o(254300);
    return localView;
  }
  
  private final View getBulletSubtitleButton()
  {
    AppMethodBeat.i(254301);
    View localView = (View)this.wfi.getValue();
    AppMethodBeat.o(254301);
    return localView;
  }
  
  private final View getFullscreenIcon()
  {
    AppMethodBeat.i(254302);
    View localView = (View)this.wfm.getValue();
    AppMethodBeat.o(254302);
    return localView;
  }
  
  private final View getLoading()
  {
    AppMethodBeat.i(168084);
    View localView = (View)this.wff.getValue();
    AppMethodBeat.o(168084);
    return localView;
  }
  
  private final ImageView getMuteBtn()
  {
    AppMethodBeat.i(168086);
    ImageView localImageView = (ImageView)this.wfj.getValue();
    AppMethodBeat.o(168086);
    return localImageView;
  }
  
  private final ImageView getThumbView()
  {
    AppMethodBeat.i(168087);
    ImageView localImageView = (ImageView)this.wfk.getValue();
    AppMethodBeat.o(168087);
    return localImageView;
  }
  
  private final c.b getVideoPlayBehavior()
  {
    AppMethodBeat.i(168129);
    Object localObject = this.tCD;
    if (localObject == null) {
      p.btv("videoCore");
    }
    localObject = ((k)localObject).weT;
    if (localObject != null)
    {
      localObject = (c.b)new c.c((com.tencent.mm.plugin.finder.event.c)localObject);
      AppMethodBeat.o(168129);
      return localObject;
    }
    AppMethodBeat.o(168129);
    return null;
  }
  
  private final View getVideoTypeIv()
  {
    AppMethodBeat.i(168093);
    View localView = (View)this.wfo.getValue();
    AppMethodBeat.o(168093);
    return localView;
  }
  
  private final void oP(boolean paramBoolean)
  {
    AppMethodBeat.i(254313);
    Object localObject = this.wfs;
    if (localObject != null) {
      ((kotlin.g.a.m)localObject).invoke(Boolean.valueOf(paramBoolean), this.wfp);
    }
    if (paramBoolean)
    {
      localObject = com.tencent.mm.kernel.g.aAh();
      p.g(localObject, "MMKernel.storage()");
      paramBoolean = ((com.tencent.mm.kernel.e)localObject).azQ().getBoolean(ar.a.OmJ, true);
      getBulletSubtitleButton().setSelected(paramBoolean);
      localObject = com.tencent.mm.kernel.g.af(ad.class);
      p.g(localObject, "MMKernel.service(IFinder…enModeConfig::class.java)");
      if (((ad)localObject).dxX())
      {
        localObject = findViewById(2131309729);
        p.g(localObject, "findViewById<View>(R.id.video_bullet_divider)");
        ((View)localObject).setVisibility(8);
        localObject = findViewById(2131309730);
        p.g(localObject, "findViewById<TextView>(R…o_bullet_subtitle_button)");
        ((TextView)localObject).setVisibility(8);
      }
      if (this.tOs != null)
      {
        getBottomButtonLayout().setVisibility(0);
        localObject = this.tOr;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.finder.feed.e)localObject).dcy();
          if (localObject != null) {
            ((WxRecyclerView)localObject).setAlpha(0.3F);
          }
        }
      }
      this.wfc = true;
      AppMethodBeat.o(254313);
      return;
    }
    if (this.tOs != null)
    {
      getBottomButtonLayout().setVisibility(8);
      localObject = this.tOr;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.feed.e)localObject).dcy();
        if (localObject != null) {
          ((WxRecyclerView)localObject).setAlpha(1.0F);
        }
      }
    }
    this.wfc = false;
    AppMethodBeat.o(254313);
  }
  
  private final void showLoading()
  {
    AppMethodBeat.i(168124);
    StringBuilder localStringBuilder = new StringBuilder("showLoading ");
    Object localObject = this.wfl;
    if (localObject != null) {}
    for (localObject = ((r)localObject).getVideoMediaId();; localObject = null)
    {
      Log.i("Finder.VideoLayout", (String)localObject);
      if (!this.wfd) {
        break label170;
      }
      localObject = this.wfl;
      if (localObject == null) {
        break;
      }
      if (((r)localObject).getVideoViewFocused() != true) {
        break label170;
      }
      localObject = this.wfr;
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
    getLoading().animate().alpha(1.0F).setDuration(1000L).setListener((Animator.AnimatorListener)new q(this)).start();
    label170:
    AppMethodBeat.o(168124);
  }
  
  public final void Q(boolean paramBoolean1, boolean paramBoolean2)
  {
    b localb = null;
    AppMethodBeat.i(254314);
    Object localObject2 = new StringBuilder("onEnterSeekMode mediaId=");
    Object localObject1 = this.wfp;
    if (localObject1 != null)
    {
      localObject1 = ((b)localObject1).mediaId;
      Log.i("Finder.VideoLayout", (String)localObject1);
      localObject1 = this.wfp;
      if (localObject1 != null) {
        ((b)localObject1).wbG = paramBoolean1;
      }
      if (!paramBoolean1) {
        break label265;
      }
      localObject1 = this.wfp;
      if (localObject1 != null)
      {
        localObject2 = getVideoPlayBehavior();
        if (localObject2 != null) {
          ((c.b)localObject2).a(((b)localObject1).feed.getExpectId(), ((b)localObject1).uPf.uIw, ((b)localObject1).uPf);
        }
      }
      oP(paramBoolean2);
      localObject1 = this.wfl;
      if (localObject1 != null) {
        ((r)localObject1).setVideoViewFocused(false);
      }
      localObject1 = this.wfl;
      if (localObject1 != null) {
        ((r)localObject1).pause();
      }
    }
    for (;;)
    {
      if (!paramBoolean1) {
        this.wfe.clear();
      }
      localObject2 = new StringBuilder("[onEnterSeekMode] isEnter=").append(paramBoolean1).append(" alpha=");
      r localr = this.wfl;
      localObject1 = localb;
      if (localr != null) {
        localObject1 = Float.valueOf(localr.getAlpha());
      }
      localObject1 = ((StringBuilder)localObject2).append(localObject1).append(" mediaId=");
      localb = this.wfp;
      if (localb == null) {
        p.hyc();
      }
      Log.i("Finder.VideoLayout", localb.mediaId);
      AppMethodBeat.o(254314);
      return;
      localObject1 = null;
      break;
      label265:
      oP(false);
      localr = this.wfl;
      if (localr != null)
      {
        localr.setVideoViewFocused(true);
        localObject1 = this.wfp;
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
        if (this.wfe.dR((String)localObject1, this.dLS) != null)
        {
          play(0);
          if (com.tencent.mm.q.a.aty())
          {
            paramBoolean2 = true;
            label344:
            if (!paramBoolean2) {
              break label369;
            }
          }
          for (paramBoolean2 = true;; paramBoolean2 = false)
          {
            localr.setMute(paramBoolean2);
            break;
            paramBoolean2 = this.guh;
            break label344;
            label369:
            if (this.tCD == null) {
              p.btv("videoCore");
            }
          }
        }
        localr.play();
      }
    }
  }
  
  public final boolean W(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(254318);
    p.h(paramMotionEvent, "event");
    if (getBulletSubtitleButton().getVisibility() != 0)
    {
      AppMethodBeat.o(254318);
      return false;
    }
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    ViewParent localViewParent = getBulletSubtitleButton().getParent();
    if (localViewParent == null)
    {
      paramMotionEvent = new kotlin.t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(254318);
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
      AppMethodBeat.o(254318);
      return true;
    }
    AppMethodBeat.o(254318);
    return false;
  }
  
  public final void a(int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.s params)
  {
    AppMethodBeat.i(254311);
    p.h(params, "video");
    Object localObject2 = new StringBuilder("[onProgressDownload] videoView=");
    Object localObject1 = this.wfl;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(localObject1.hashCode());
      Log.i("Finder.VideoLayout", localObject1 + " offset=" + paramInt1 + " total=" + paramInt2 + " video=" + params.auA());
      localObject1 = this.wfp;
      if (localObject1 != null) {
        if (!((b)localObject1).wfz) {
          break label282;
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = getVideoPlayBehavior();
        if (localObject2 != null) {
          ((c.b)localObject2).c(((b)localObject1).feed.getExpectId(), ((b)localObject1).uPf.uIw, paramInt1, paramInt2, ((b)localObject1).uPf);
        }
      }
      localObject1 = MediaPreloadCore.uTV;
      if (MediaPreloadCore.dlF())
      {
        localObject2 = new pw();
        ((pw)localObject2).dVW.mediaId = params.uIw.mediaId;
        ((pw)localObject2).dVW.process = ((int)(100.0F * paramInt1 / paramInt2));
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
        localObject1 = params.uIw.mediaId;
        params = (com.tencent.mm.plugin.finder.loader.s)localObject1;
        if (localObject1 == null) {
          params = "";
        }
        params = com.tencent.mm.plugin.finder.storage.logic.d.bv(params, true);
        ((pw)localObject2).dVW.dVY = params.field_fileFormat;
        EventCenter.instance.publish((IEvent)localObject2);
      }
      AppMethodBeat.o(254311);
      return;
      localObject1 = null;
      break;
      label282:
      localObject1 = null;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.s params, boolean paramBoolean)
  {
    AppMethodBeat.i(254310);
    p.h(params, "video");
    Object localObject2 = new StringBuilder("[onMoovReadyDownload] videoView=");
    Object localObject1 = this.wfl;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(localObject1.hashCode());
      Log.i("Finder.VideoLayout", localObject1 + "  offset=" + paramInt1 + " total=" + paramInt2 + " video=" + params + " moovFirstDownloaded=" + paramBoolean);
      params = this.wfp;
      if (params != null)
      {
        if (!params.wfz) {
          break label305;
        }
        label119:
        if (params != null)
        {
          localObject1 = af.viA;
          localObject2 = params.uPf.uIw.mediaId;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          af.bp((String)localObject1, paramBoolean);
          localObject1 = getVideoPlayBehavior();
          if (localObject1 != null) {
            ((c.b)localObject1).b(params.feed.getExpectId(), params.uPf.uIw, paramInt1, paramInt2, params.uPf);
          }
        }
      }
      params = com.tencent.mm.plugin.finder.report.h.veu;
      com.tencent.mm.plugin.finder.report.h.Kj(this.dLS);
      params = com.tencent.mm.plugin.finder.report.f.veb;
      params = this.wfp;
      if (params == null) {
        break label310;
      }
      params = params.feed;
      if (params == null) {
        break label310;
      }
      params = Long.valueOf(params.getId());
      label240:
      if (params == null) {
        break label315;
      }
      params.longValue();
      params = com.tencent.mm.plugin.finder.report.f.EZ(params.longValue());
      if ((params.vee <= 0L) || (params.vef != 0L)) {
        break label322;
      }
      paramInt1 = 1;
      label277:
      if (paramInt1 == 0) {
        break label327;
      }
    }
    for (;;)
    {
      if (params == null) {
        break label332;
      }
      params.vef = cl.aWA();
      AppMethodBeat.o(254310);
      return;
      localObject1 = null;
      break;
      label305:
      params = null;
      break label119;
      label310:
      params = null;
      break label240;
      label315:
      AppMethodBeat.o(254310);
      return;
      label322:
      paramInt1 = 0;
      break label277;
      label327:
      params = null;
    }
    label332:
    AppMethodBeat.o(254310);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.finder.loader.s params, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(254309);
    p.h(params, "video");
    StringBuilder localStringBuilder = new StringBuilder("[onFinishDownload] ret=").append(paramInt).append(" videoView=");
    Object localObject = this.wfl;
    if (localObject != null)
    {
      localObject = Integer.valueOf(localObject.hashCode());
      Log.i("Finder.VideoLayout", localObject + " FinderVideo=" + params);
      cJE();
      params = this.wfp;
      if (params != null) {
        if (!params.wfz) {
          break label165;
        }
      }
    }
    for (;;)
    {
      if (params != null)
      {
        localObject = getVideoPlayBehavior();
        if (localObject != null) {
          ((c.b)localObject).a(params.feed.getExpectId(), params.uPf.uIw, paramInt, paramd, params.uPf);
        }
      }
      if (paramInt < 0) {
        dFD();
      }
      AppMethodBeat.o(254309);
      return;
      localObject = null;
      break;
      label165:
      params = null;
    }
  }
  
  public final void a(int paramInt1, FeedData paramFeedData, q paramq, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, kotlin.g.a.m<? super Boolean, ? super b, kotlin.x> paramm1, kotlin.g.a.m<? super Boolean, ? super b, kotlin.x> paramm2)
  {
    AppMethodBeat.i(254303);
    p.h(paramFeedData, "feed");
    Log.i("Finder.VideoLayout", "[convert] position=" + paramInt1 + " feedId=" + paramFeedData.getExpectId() + " current=" + System.currentTimeMillis() + " feedTime=" + paramFeedData.getTimestamps() + " urlValidDuration=" + paramFeedData.getUrlValidDuration() + 's');
    this.dLS = paramInt2;
    this.wfg = paramBoolean1;
    this.wfs = paramm1;
    this.wft = paramm2;
    paramm1 = getLoading().getLayoutParams();
    if ((paramm1 instanceof FrameLayout.LayoutParams))
    {
      if (!this.wfg) {
        break label285;
      }
      paramm2 = getLoading().getContext();
      p.g(paramm2, "loading.context");
      paramm1.width = ((int)paramm2.getResources().getDimension(2131165303));
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
      this.wfq = paramq;
      if (paramq != null) {
        paramq.setSeekBarCallback((q.a)this);
      }
      this.mediaList = paramFeedData.getMediaList();
      if (paramInt1 < this.mediaList.size()) {
        break;
      }
      AppMethodBeat.o(254303);
      return;
      label285:
      paramm2 = getLoading().getContext();
      p.g(paramm2, "loading.context");
      i = (int)paramm2.getResources().getDimension(2131165299);
      paramm1.width = i;
      paramm1.height = paramm1.width;
      ((FrameLayout.LayoutParams)paramm1).topMargin = i;
      ((FrameLayout.LayoutParams)paramm1).setMarginEnd(i);
    }
    paramm1 = this.mediaList.get(paramInt1);
    p.g(paramm1, "mediaList[position]");
    Object localObject = (cjl)paramm1;
    long l = paramFeedData.getId();
    paramm2 = ((cjl)localObject).mediaId;
    paramm1 = paramm2;
    if (paramm2 == null) {
      paramm1 = "";
    }
    com.tencent.mm.plugin.finder.loader.s locals = com.tencent.mm.plugin.finder.storage.logic.d.vGR.b(l, (cjl)localObject);
    Log.i("Finder.VideoLayout", "[findBestVideo] feedId=" + com.tencent.mm.ac.d.zs(l) + " mediaId=" + paramm1 + " videoFlag=" + locals.uIx);
    if (paramFeedData.getId() == 0L)
    {
      paramBoolean1 = true;
      paramm2 = locals.auA();
      LinkedList localLinkedList = this.mediaList;
      if (!locals.uIw.MoO) {
        break label1309;
      }
      paramm1 = locals.uIw.uOR;
      label523:
      this.wfp = new b(paramFeedData, paramm2, locals, paramInt1, localLinkedList, paramBoolean1, paramm1, (byte)0);
      paramm1 = af.viA;
      paramm2 = locals.uIw.mediaId;
      paramm1 = paramm2;
      if (paramm2 == null) {
        paramm1 = "";
      }
      af.q(paramm1, locals.uIx.detail, locals.getUrl(), locals.djW());
      dFC();
      this.wfd = true;
      if (((cjl)localObject).MoU == null) {
        break label1336;
      }
      if (!this.wfg) {
        break label1315;
      }
    }
    label670:
    label1315:
    for (paramm1 = (com.tencent.mm.plugin.finder.loader.k)new i((cjl)localObject, com.tencent.mm.plugin.finder.storage.x.vEo);; paramm1 = new com.tencent.mm.plugin.finder.loader.k((cjl)localObject, com.tencent.mm.plugin.finder.storage.x.vEo, null, null, 12))
    {
      getThumbView().setScaleType(ImageView.ScaleType.CENTER_CROP);
      if (((cjl)localObject).mediaType != 9) {
        break label1469;
      }
      paramm2 = com.tencent.mm.plugin.finder.loader.m.uJa;
      paramm2 = com.tencent.mm.plugin.finder.loader.m.dke();
      localObject = (CharSequence)paramm1.uIy;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label1482;
      }
      paramInt1 = 1;
      label697:
      if (paramInt1 == 0) {
        paramm2.gVF.aJF().a(new com.tencent.mm.loader.h.a.a((com.tencent.mm.loader.h.a.c)paramm1));
      }
      paramm2 = paramm2.bQ(paramm1);
      if (!this.wfg) {
        break label1487;
      }
      paramm1 = com.tencent.mm.plugin.finder.loader.m.uJa;
      paramm1 = com.tencent.mm.plugin.finder.loader.m.a(m.a.uJc);
      label755:
      paramm2 = paramm2.a(paramm1).a((com.tencent.mm.loader.f.e)new e(this));
      paramm1 = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dtK().value()).intValue() <= 0) {
        break label1503;
      }
      paramm1 = new com.tencent.mm.loader.e.d(null, new com.tencent.mm.loader.e.b.g(this), 1);
      label819:
      paramm2.a((com.tencent.mm.loader.f.d)paramm1).c(getThumbView());
      paramm1 = this.wfe.dR(locals.auA(), paramInt2);
      if (paramm1 != null)
      {
        if (paramq != null) {
          paramq.oI(true);
        }
        if (paramq != null) {
          paramq.setProgress(paramm1.progress);
        }
        oP(true);
        if (paramq != null) {
          paramq.dFa();
        }
        paramm1 = this.wfp;
        if (paramm1 != null) {
          paramm1.wbG = true;
        }
        if (paramq == null) {
          break label1509;
        }
        paramq.setVisibility(0);
        paramm1 = kotlin.x.SXb;
        label935:
        if (paramm1 != null) {}
      }
      else
      {
        paramm1 = (FinderVideoLayout)this;
        paramm1.oP(false);
        if (paramq != null) {
          paramq.awG("Finder.VideoLayoutconvert");
        }
        paramm1 = paramm1.wfp;
        if (paramm1 != null) {
          paramm1.wbG = false;
        }
        if (paramq != null)
        {
          paramq.dEX();
          paramq = kotlin.x.SXb;
        }
      }
      if (paramBoolean2) {
        if (this.tOs != null)
        {
          paramq = this.tOr;
          if (paramq == null) {
            break label1515;
          }
          paramm1 = com.tencent.mm.kernel.g.aAh();
          p.g(paramm1, "MMKernel.storage()");
          paramq.L(paramm1.azQ().getBoolean(ar.a.OmJ, true), false);
          paramq = kotlin.x.SXb;
          if (paramq != null) {}
        }
        else
        {
          paramq = (FinderVideoLayout)this;
          paramm1 = paramq.getContext();
          p.g(paramm1, "context");
          paramq.tOs = new com.tencent.mm.plugin.finder.feed.d(paramm1);
          paramm1 = (View)paramq;
          paramm2 = paramq.tOs;
          if (paramm2 == null) {
            p.hyc();
          }
          paramq.tOr = new com.tencent.mm.plugin.finder.feed.e(paramm1, paramm2);
          paramm1 = paramq.tOs;
          if (paramm1 == null) {
            p.hyc();
          }
          paramq = paramq.tOr;
          if (paramq == null) {
            p.hyc();
          }
          paramm1.a(paramq);
          paramq = kotlin.x.SXb;
        }
      }
      paramq = this.tOs;
      if (paramq != null) {
        paramq.a(paramFeedData, paramInt2);
      }
      paramFeedData = getBulletSubtitleButton();
      paramq = this.tOr;
      if (paramq == null) {
        break label1520;
      }
      paramBoolean1 = paramq.getFunctionSwitch();
      label1195:
      paramFeedData.setSelected(paramBoolean1);
      paramFeedData = this.wfr;
      if (paramFeedData == null) {
        break label1531;
      }
      paramFeedData.setVisibility(0);
      paramFeedData.setPlayBtnOnClickListener((View.OnClickListener)new h(paramFeedData, this));
      paramq = this.wfl;
      if (paramq == null) {
        break label1526;
      }
      paramInt1 = paramq.getVideoDuration();
      label1247:
      paramFeedData.setVideoTotalTime(paramInt1);
      paramFeedData.setIsPlay(true);
      paramFeedData.setIplaySeekCallback((com.tencent.mm.plugin.sight.decode.ui.b)new i(paramFeedData, this));
      p.h(this, "videoLayout");
      setOnTouchListener((View.OnTouchListener)new FinderLongVideoPlayerSeekBar.c(paramFeedData, this));
      AppMethodBeat.o(254303);
      return;
      paramBoolean1 = false;
      break;
      paramm1 = null;
      break label523;
    }
    label1052:
    label1309:
    label1336:
    paramm1 = "";
    if (this.isLongVideo)
    {
      paramm1 = getContext();
      if (paramm1 == null)
      {
        paramFeedData = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(254303);
        throw paramFeedData;
      }
      paramm1 = ((MMActivity)paramm1).getIntent().getStringExtra("KEY_VIDEO_THUMB_LOCAL_PATH");
      if (paramm1 != null) {
        break label1538;
      }
      paramm1 = "";
    }
    label1538:
    for (;;)
    {
      paramm2 = getContext();
      if (paramm2 == null)
      {
        paramFeedData = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(254303);
        throw paramFeedData;
      }
      ((MMActivity)paramm2).getIntent().removeExtra("KEY_VIDEO_THUMB_LOCAL_PATH");
      paramm1 = new com.tencent.mm.plugin.finder.loader.k((cjl)localObject, com.tencent.mm.plugin.finder.storage.x.vEo, null, paramm1, 4);
      break;
      label1469:
      paramm2 = com.tencent.mm.plugin.finder.loader.m.uJa;
      paramm2 = com.tencent.mm.plugin.finder.loader.m.djY();
      break label670;
      label1482:
      paramInt1 = 0;
      break label697;
      label1487:
      paramm1 = com.tencent.mm.plugin.finder.loader.m.uJa;
      paramm1 = com.tencent.mm.plugin.finder.loader.m.a(m.a.uJb);
      break label755;
      label1503:
      paramm1 = null;
      break label819;
      label1509:
      paramm1 = null;
      break label935;
      label1515:
      paramq = null;
      break label1052;
      label1520:
      paramBoolean1 = true;
      break label1195;
      label1526:
      paramInt1 = 0;
      break label1247;
      label1531:
      AppMethodBeat.o(254303);
      return;
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.loader.s params, com.tencent.mm.i.h paramh, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(254308);
    p.h(params, "video");
    StringBuilder localStringBuilder = new StringBuilder("[onStopDownload] videoView=");
    Object localObject = this.wfl;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(localObject.hashCode());; localObject = null)
    {
      Log.i("Finder.VideoLayout", localObject + " FinderVideo=" + params + " thumbVisible=" + getThumbView().getVisibility());
      params = this.wfp;
      if (params == null) {
        break label155;
      }
      localObject = getVideoPlayBehavior();
      if (localObject == null) {
        break;
      }
      ((c.b)localObject).a(params.feed.getExpectId(), params.uPf.uIw, paramh, paramd, params.uPf);
      AppMethodBeat.o(254308);
      return;
    }
    AppMethodBeat.o(254308);
    return;
    label155:
    AppMethodBeat.o(254308);
  }
  
  public final void ac(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(169678);
    p.h(paramString, "mediaId");
    paramString = this.wfp;
    if (paramString != null)
    {
      if (paramString.wfz) {}
      while (paramString != null)
      {
        c.b localb = getVideoPlayBehavior();
        if (localb != null)
        {
          localb.e(paramString.feed.getExpectId(), paramString.uPf.uIw, paramInt1, paramInt2, paramString.uPf);
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
  
  public final void b(com.tencent.mm.plugin.finder.loader.s params)
  {
    Object localObject2 = null;
    AppMethodBeat.i(254307);
    p.h(params, "video");
    Object localObject3 = new StringBuilder("[onStartDownload] videoView=");
    Object localObject1 = this.wfl;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(localObject1.hashCode());
      Log.i("Finder.VideoLayout", localObject1 + " FinderVideo=" + params + " thumbVisible=" + getThumbView().getVisibility());
      dFE();
      params = this.wfp;
      if (params != null) {
        if (!params.wfz) {
          break label210;
        }
      }
    }
    for (;;)
    {
      if (params != null)
      {
        localObject1 = getVideoPlayBehavior();
        if (localObject1 != null) {
          ((c.b)localObject1).f(params.feed.getExpectId(), params.uPf.uIw, params.uPf);
        }
      }
      params = com.tencent.mm.plugin.finder.report.h.veu;
      com.tencent.mm.plugin.finder.report.h.Kh(this.dLS);
      localObject1 = com.tencent.mm.plugin.finder.report.f.veb;
      localObject3 = this.wfp;
      params = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((b)localObject3).feed;
        params = localObject2;
        if (localObject3 != null) {
          params = Long.valueOf(((FeedData)localObject3).getId());
        }
      }
      ((com.tencent.mm.plugin.finder.report.f)localObject1).h(params);
      AppMethodBeat.o(254307);
      return;
      localObject1 = null;
      break;
      label210:
      params = null;
    }
  }
  
  public final void bn(float paramFloat)
  {
    boolean bool = true;
    AppMethodBeat.i(254317);
    Object localObject2 = new StringBuilder("[seekTo] percent=").append(paramFloat).append(" isSeekMode=").append(dFB()).append(" videoView=");
    Object localObject1 = this.wfl;
    label103:
    int j;
    int i;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(localObject1.hashCode());
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(" videoDurationSec=");
      localObject1 = this.wfl;
      if (localObject1 == null) {
        break label379;
      }
      localObject1 = Integer.valueOf(((r)localObject1).getVideoDuration());
      Log.i("Finder.VideoLayout", localObject1);
      localObject1 = this.wfl;
      if (localObject1 != null)
      {
        j = ((r)localObject1).getCurrentPlaySecond();
        localObject2 = this.wfl;
        if (localObject2 == null) {
          break label385;
        }
        i = ((r)localObject2).getVideoDuration();
        label159:
        paramFloat = android.support.v4.b.a.j(i * paramFloat, i - 1.0F);
        double d = paramFloat;
        if (dFB()) {
          break label391;
        }
        label183:
        if ((((r)localObject1).c(d, bool)) && (Math.abs(j - paramFloat) > 1.0F))
        {
          this.wfw = paramFloat;
          localObject2 = new StringBuilder("[seekTo] successfully seek to ").append(paramFloat).append(" videoDurationSec=");
          localObject1 = this.wfl;
          if (localObject1 == null) {
            break label397;
          }
          localObject1 = Integer.valueOf(((r)localObject1).getVideoDuration());
          Log.i("Finder.VideoLayout", localObject1);
        }
        label259:
        localObject1 = this.wfp;
        if (localObject1 != null) {
          if (!((b)localObject1).wfz) {
            break label403;
          }
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = getVideoPlayBehavior();
        if (localObject2 != null) {
          ((c.b)localObject2).d(((b)localObject1).feed.getExpectId(), ((b)localObject1).uPf.uIw, j, (int)paramFloat, ((b)localObject1).uPf);
        }
      }
      localObject1 = this.wfp;
      if (localObject1 == null) {
        break label409;
      }
      if (!((b)localObject1).wbG) {
        oP(false);
      }
      AppMethodBeat.o(254317);
      return;
      localObject1 = null;
      break;
      label379:
      localObject1 = null;
      break label103;
      label385:
      i = 1;
      break label159;
      label391:
      bool = false;
      break label183;
      label397:
      localObject1 = null;
      break label259;
      label403:
      localObject1 = null;
    }
    label409:
    AppMethodBeat.o(254317);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168103);
    StringBuilder localStringBuilder = new StringBuilder("[onError] videoView=");
    paramString1 = this.wfl;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      Log.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2 + " errorMsg=" + paramString3 + " what=" + paramInt1 + " extra=" + paramInt2);
      paramString1 = this.wfq;
      if (paramString1 != null) {
        paramString1.setVisibility(8);
      }
      dFD();
      paramString1 = com.tencent.mm.plugin.finder.report.k.vfA;
      com.tencent.mm.plugin.finder.report.k.Kv(paramInt1);
      paramString1 = this.wfp;
      if (paramString1 == null) {
        break label181;
      }
      paramString2 = getVideoPlayBehavior();
      if (paramString2 == null) {
        break;
      }
      paramString2.a(paramString1.feed.getExpectId(), paramString1.uPf.uIw, paramInt1);
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
    paramString1 = this.wfl;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      Log.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2 + " width=" + paramInt1 + " height=" + paramInt2);
      AppMethodBeat.o(168106);
      return;
    }
  }
  
  public final void dFA()
  {
    AppMethodBeat.i(254305);
    b localb = this.wfp;
    if (localb != null)
    {
      k localk = this.tCD;
      if (localk == null) {
        p.btv("videoCore");
      }
      localk.dFx().a((ViewGroup)this, localb.uPf, (kotlin.g.a.b)new n(localb, this));
      AppMethodBeat.o(254305);
      return;
    }
    AppMethodBeat.o(254305);
  }
  
  public final boolean dFG()
  {
    AppMethodBeat.i(254315);
    r localr = this.wfl;
    if (localr != null)
    {
      boolean bool = localr.isPlaying();
      AppMethodBeat.o(254315);
      return bool;
    }
    AppMethodBeat.o(254315);
    return false;
  }
  
  public final void dFH()
  {
    AppMethodBeat.i(254316);
    Object localObject = this.wfl;
    if (localObject != null) {
      ((r)localObject).pause();
    }
    localObject = this.wfp;
    if (localObject != null)
    {
      if (!((b)localObject).wbG) {
        oP(true);
      }
      AppMethodBeat.o(254316);
      return;
    }
    AppMethodBeat.o(254316);
  }
  
  public final boolean dFI()
  {
    b localb = this.wfp;
    return (localb != null) && (localb.wfz == true);
  }
  
  public final String dFJ()
  {
    AppMethodBeat.i(254326);
    Object localObject2 = this.wfp;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = ((b)localObject2).uPf;
      ((b)localObject2).feed.getExpectId();
      localObject2 = ((b)localObject2).mediaList;
      localObject2 = "[FinderVideoLayout#loginfo] layout=[" + getWidth() + ':' + getHeight() + "] videoView=[" + getWidth() + ':' + getHeight() + "] video=[" + ((com.tencent.mm.plugin.finder.loader.s)localObject1).uIw.width + ':' + ((com.tencent.mm.plugin.finder.loader.s)localObject1).uIw.height + "] " + dFF() + ' ' + "media=" + localObject1 + ' ' + "mediaList=" + ((LinkedList)localObject2).size();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "[FinderVideoLayout#loginfo] playInfo is null";
    }
    AppMethodBeat.o(254326);
    return localObject1;
  }
  
  public final void dH(String paramString1, String paramString2)
  {
    Integer localInteger = null;
    AppMethodBeat.i(168104);
    paramString1 = this.wfl;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.getVideoDuration());; paramString1 = null)
    {
      StringBuilder localStringBuilder = new StringBuilder("[onPrepared] videoView=");
      r localr = this.wfl;
      if (localr != null) {
        localInteger = Integer.valueOf(localr.hashCode());
      }
      Log.i("Finder.VideoLayout", localInteger + " mediaId=" + paramString2 + " thumbVisible=" + getThumbView().getVisibility() + " duration=" + paramString1);
      AppMethodBeat.o(168104);
      return;
    }
  }
  
  public final void dI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(168105);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoEnded] videoView=");
    paramString1 = this.wfl;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      Log.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      AppMethodBeat.o(168105);
      return;
    }
  }
  
  public final void dJ(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(168107);
    Object localObject2 = new StringBuilder("[onVideoPause] videoView=");
    paramString1 = this.wfl;
    if (paramString1 != null)
    {
      paramString1 = Integer.valueOf(paramString1.hashCode());
      Log.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      cJE();
      paramString1 = com.tencent.mm.plugin.finder.report.f.veb;
      paramString1 = this.wfp;
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
      localObject2 = com.tencent.mm.plugin.finder.report.f.EZ(paramString1.longValue());
      if ((((f.a)localObject2).vec <= 0L) || (((f.a)localObject2).veg != 0L) || (((f.a)localObject2).ved != 0L)) {
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
      paramString2.ved = cl.aWA();
      com.tencent.mm.plugin.finder.report.f.vdZ.add(paramString2);
      com.tencent.mm.plugin.finder.report.f.vdY.remove(paramString1);
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
  
  public final void dK(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(168108);
    paramString1 = this.wfl;
    int i;
    Object localObject2;
    if (paramString1 != null)
    {
      i = paramString1.getVideoDuration();
      localObject2 = new StringBuilder("[onVideoPlay] videoView=");
      paramString1 = this.wfl;
      if (paramString1 == null) {
        break label223;
      }
      paramString1 = Integer.valueOf(paramString1.hashCode());
      label54:
      paramString2 = ((StringBuilder)localObject2).append(paramString1).append(" mediaId=").append(paramString2).append(" duration=").append(i).append(" isHasPlayed=");
      paramString1 = this.wfp;
      if (paramString1 == null) {
        break label228;
      }
    }
    label223:
    label228:
    for (paramString1 = Boolean.valueOf(paramString1.wfA);; paramString1 = null)
    {
      Log.i("Finder.VideoLayout", paramString1);
      cJE();
      dFE();
      paramString1 = this.wfl;
      if (paramString1 != null) {
        paramString1.setKeepScreenOn(true);
      }
      this.wfw = -1.0F;
      cBY();
      paramString2 = com.tencent.mm.plugin.finder.report.f.veb;
      localObject2 = this.wfp;
      paramString1 = localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((b)localObject2).feed;
        paramString1 = localObject1;
        if (localObject2 != null) {
          paramString1 = Long.valueOf(((FeedData)localObject2).getId());
        }
      }
      paramString2.i(paramString1);
      paramString1 = com.tencent.mm.plugin.finder.report.h.veu;
      com.tencent.mm.plugin.finder.report.h.Kk(this.dLS);
      AppMethodBeat.o(168108);
      return;
      i = 0;
      break;
      paramString1 = null;
      break label54;
    }
  }
  
  public final void dL(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(168109);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoWaiting] videoView=");
    Object localObject1 = this.wfl;
    if (localObject1 != null) {}
    for (localObject1 = Integer.valueOf(localObject1.hashCode());; localObject1 = null)
    {
      Log.i("Finder.VideoLayout", localObject1 + " mediaId=" + paramString2 + " thumbVisible=" + getThumbView().getVisibility());
      paramString2 = this.wfl;
      if (((paramString2 == null) || (paramString2.getVideoViewFocused() != true)) && (paramString1 != null)) {
        break label183;
      }
      showLoading();
      paramString2 = this.wfp;
      if (paramString2 == null) {
        break label183;
      }
      paramString1 = localObject2;
      if (paramString2.wfz) {
        paramString1 = paramString2;
      }
      if (paramString1 == null) {
        break label183;
      }
      paramString2 = getVideoPlayBehavior();
      if (paramString2 == null) {
        break;
      }
      paramString2.b(paramString1.feed.getExpectId(), paramString1.uPf.uIw, paramString1.uPf);
      AppMethodBeat.o(168109);
      return;
    }
    AppMethodBeat.o(168109);
    return;
    label183:
    AppMethodBeat.o(168109);
  }
  
  public final void dM(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(168110);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoWaitingEnd] videoView=");
    paramString1 = this.wfl;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      Log.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      cJE();
      paramString2 = this.wfp;
      if (paramString2 == null) {
        break label142;
      }
      paramString1 = localObject;
      if (paramString2.wfz) {
        paramString1 = paramString2;
      }
      if (paramString1 == null) {
        break label142;
      }
      paramString2 = getVideoPlayBehavior();
      if (paramString2 == null) {
        break;
      }
      paramString2.c(paramString1.feed.getExpectId(), paramString1.uPf.uIw, paramString1.uPf);
      AppMethodBeat.o(168110);
      return;
    }
    AppMethodBeat.o(168110);
    return;
    label142:
    AppMethodBeat.o(168110);
  }
  
  public final void fo(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(254306);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoFirstFrameDraw] videoView=");
    paramString1 = this.wfl;
    if (paramString1 != null)
    {
      paramString1 = Integer.valueOf(paramString1.hashCode());
      Log.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      awJ("onVideoFirstFrameDraw");
      paramString1 = com.tencent.mm.plugin.finder.report.h.veu;
      com.tencent.mm.plugin.finder.report.h.Ki(this.dLS);
      paramString1 = com.tencent.mm.plugin.finder.report.f.veb;
      paramString1 = this.wfp;
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
      paramString2 = com.tencent.mm.plugin.finder.report.f.EZ(paramString1.longValue());
      if (((paramString2.vee <= 0L) && (paramString2.vec <= 0L)) || (paramString2.veg != 0L)) {
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
      paramString1.veg = cl.aWA();
      com.tencent.mm.plugin.finder.report.f.vdZ.add(paramString1);
      com.tencent.mm.plugin.finder.report.f.vdY.clear();
      AppMethodBeat.o(254306);
      return;
      paramString1 = null;
      break;
      paramString1 = null;
      break label111;
      AppMethodBeat.o(254306);
      return;
    }
    label222:
    AppMethodBeat.o(254306);
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(254323);
    Object localObject = this.wfl;
    if (localObject != null)
    {
      Bitmap localBitmap = ((r)localObject).getBitmap();
      localObject = localBitmap;
      if (localBitmap != null) {}
    }
    else
    {
      localObject = getThumbView().getDrawable();
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        AppMethodBeat.o(254323);
        throw ((Throwable)localObject);
      }
      localObject = ((BitmapDrawable)localObject).getBitmap();
    }
    AppMethodBeat.o(254323);
    return localObject;
  }
  
  public final long getCurrentPosMs()
  {
    AppMethodBeat.i(254321);
    r localr = this.wfl;
    if (localr != null)
    {
      long l = localr.getCurrentPlayMs();
      AppMethodBeat.o(254321);
      return l;
    }
    AppMethodBeat.o(254321);
    return 0L;
  }
  
  public final int getCurrentPosSec()
  {
    AppMethodBeat.i(254320);
    r localr = this.wfl;
    if (localr != null)
    {
      int i = localr.getCurrentPlaySecond();
      AppMethodBeat.o(254320);
      return i;
    }
    AppMethodBeat.o(254320);
    return 0;
  }
  
  public final y getLifecycle()
  {
    return this.wcw;
  }
  
  public final FinderLongVideoPlayerSeekBar getLongVideoSeekBar()
  {
    return this.wfr;
  }
  
  public final int getPlayAdapterPosition()
  {
    return this.wfu;
  }
  
  public final b getPlayInfo()
  {
    return this.wfp;
  }
  
  public final View getRetryBtn()
  {
    AppMethodBeat.i(168092);
    View localView = (View)this.wfn.getValue();
    AppMethodBeat.o(168092);
    return localView;
  }
  
  public final kotlin.g.a.m<Boolean, b, kotlin.x> getThumbShowCallback()
  {
    return this.wft;
  }
  
  public final k getVideoCore()
  {
    AppMethodBeat.i(168088);
    k localk = this.tCD;
    if (localk == null) {
      p.btv("videoCore");
    }
    AppMethodBeat.o(168088);
    return localk;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(254319);
    r localr = this.wfl;
    if (localr != null)
    {
      int i = localr.getVideoDuration();
      AppMethodBeat.o(254319);
      return i;
    }
    AppMethodBeat.o(254319);
    return 0;
  }
  
  public final kotlin.g.a.m<Boolean, b, kotlin.x> getVideoPauseCallback()
  {
    return this.wfs;
  }
  
  public final r getVideoView()
  {
    return this.wfl;
  }
  
  public final void oQ(boolean paramBoolean)
  {
    AppMethodBeat.i(254325);
    if (paramBoolean)
    {
      play(0);
      AppMethodBeat.o(254325);
      return;
    }
    pause(false);
    AppMethodBeat.o(254325);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(168099);
    super.onDetachedFromWindow();
    Object localObject = getContext();
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(168099);
      throw ((Throwable)localObject);
    }
    if (((Activity)localObject).isFinishing())
    {
      pause(true);
      localObject = this.tOs;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.finder.feed.d)localObject).onDetach();
        AppMethodBeat.o(168099);
        return;
      }
    }
    AppMethodBeat.o(168099);
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(168101);
    p.h(paramView, "child");
    super.onViewAdded(paramView);
    if ((paramView instanceof r))
    {
      Log.i("Finder.VideoLayout", "[onViewAdded] isPreviewing=" + ((r)paramView).dEO() + ' ' + dFF());
      if (((r)paramView).dEO()) {
        setVisibility(0);
      }
    }
    AppMethodBeat.o(168101);
  }
  
  public final void onViewRemoved(View paramView)
  {
    int j = 0;
    AppMethodBeat.i(168102);
    p.h(paramView, "child");
    super.onViewRemoved(paramView);
    if ((p.j(paramView, this.wfl)) && ((paramView instanceof r)))
    {
      Log.i("Finder.VideoLayout", "[onViewRemoved] isPreviewing=" + ((r)paramView).dEO() + ' ' + dFF());
      Object localObject1 = this.wfq;
      if (localObject1 != null) {
        ((q)localObject1).dEX();
      }
      localObject1 = this.wfp;
      Object localObject2;
      Object localObject3;
      if ((localObject1 != null) && (((b)localObject1).wbG == true))
      {
        localObject1 = this.wfe;
        localObject2 = this.wfp;
        if (localObject2 == null) {
          p.hyc();
        }
        localObject2 = ((b)localObject2).mediaId;
        localObject3 = this.wfq;
        if (localObject3 == null) {
          break label217;
        }
      }
      label217:
      for (int i = ((q)localObject3).getCurrentProgress();; i = 0)
      {
        localObject3 = this.wfl;
        if (localObject3 != null) {
          j = ((r)localObject3).getCurrentPlaySecond();
        }
        ((FinderVideoStateCacheVM)localObject1).ah((String)localObject2, i, j);
        if (!((r)paramView).dEO()) {
          break;
        }
        setVisibility(4);
        AppMethodBeat.o(168102);
        return;
      }
      dFC();
      cJE();
      this.wfl = null;
    }
    AppMethodBeat.o(168102);
  }
  
  public final void pause(boolean paramBoolean)
  {
    AppMethodBeat.i(168097);
    Object localObject1 = this.wfp;
    if ((localObject1 != null) && (!((b)localObject1).wfz))
    {
      AppMethodBeat.o(168097);
      return;
    }
    Object localObject2 = new StringBuilder("[FinderVideoLayout#pause] ").append(dFF()).append(" isForceRemoveVideoView=").append(paramBoolean).append(" isSeekMode=");
    localObject1 = this.wfp;
    label126:
    boolean bool;
    label152:
    label185:
    label363:
    hj.a locala;
    long l;
    if (localObject1 != null)
    {
      localObject1 = Boolean.valueOf(((b)localObject1).wbG);
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(' ').append("media=");
      localObject1 = this.wfp;
      if (localObject1 == null) {
        break label543;
      }
      localObject1 = ((b)localObject1).mediaId;
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(' ');
      if (Log.getLogLevel() > 1) {
        break label549;
      }
      localObject1 = Util.getStack();
      Log.i("Finder.VideoLayout", localObject1);
      localObject1 = this.wfp;
      if (localObject1 == null) {
        break label557;
      }
      bool = ((b)localObject1).wbG;
      localObject1 = this.tCD;
      if (localObject1 == null) {
        p.btv("videoCore");
      }
      localObject1 = ((k)localObject1).dFx();
      localObject2 = (ViewGroup)this;
      p.h(localObject2, "parent");
      ((Map)((FinderVideoRecycler)localObject1).wAY).put(Integer.valueOf(((ViewGroup)localObject2).hashCode()), null);
      localObject2 = ((ViewGroup)localObject2).findViewWithTag(Integer.valueOf(((ViewGroup)localObject2).hashCode()));
      if ((localObject2 instanceof r))
      {
        localObject2 = (r)localObject2;
        Log.i("Finder.VideoRecycler", "[pauseOrRecycle] pauseWithCancel mediaId:" + ((r)localObject2).getVideoMediaId() + " videoView(" + localObject2.hashCode() + ") isForceRemove=" + paramBoolean + " isTryKeep=" + bool);
        ((r)localObject2).setVideoViewFocused(false);
        if ((!bool) && (paramBoolean)) {
          break label562;
        }
        ((r)localObject2).dFk();
      }
      cJE();
      localObject1 = this.tOr;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.feed.e)localObject1).reset(false);
      }
      localObject1 = this.wfp;
      if (localObject1 != null) {
        ((b)localObject1).wfz = false;
      }
      this.wfx = -1;
      localObject1 = this.wfp;
      if (localObject1 != null)
      {
        localObject1 = ((b)localObject1).feed;
        if (localObject1 != null)
        {
          localObject2 = new hj();
          locala = ((hj)localObject2).dLP;
          if (((FeedData)localObject1).getLocalId() == 0L) {
            break label575;
          }
          l = ((FeedData)localObject1).getLocalId();
          label461:
          locala.feedId = l;
          locala = ((hj)localObject2).dLP;
          if (((FeedData)localObject1).getLocalId() == 0L) {
            break label584;
          }
        }
      }
    }
    label543:
    label549:
    label557:
    label562:
    label575:
    label584:
    for (paramBoolean = true;; paramBoolean = false)
    {
      locala.dLQ = paramBoolean;
      ((hj)localObject2).dLP.dLD = true;
      ((hj)localObject2).dLP.dLS = this.dLS;
      EventCenter.instance.publish((IEvent)localObject2);
      setKeepScreenOn(false);
      AppMethodBeat.o(168097);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label126;
      localObject1 = "";
      break label152;
      bool = false;
      break label185;
      ((FinderVideoRecycler)localObject1).a((r)localObject2, "pauseAndRecycle");
      break label363;
      l = ((FeedData)localObject1).getFeedId();
      break label461;
    }
  }
  
  public final void play(int paramInt)
  {
    AppMethodBeat.i(168095);
    this.wfu = paramInt;
    Object localObject = com.tencent.mm.plugin.finder.report.live.k.vkd;
    com.tencent.mm.plugin.finder.report.live.k.dpl().vlQ = paramInt;
    if (this.wfp == null)
    {
      AppMethodBeat.o(168095);
      return;
    }
    localObject = this.wfp;
    if (localObject == null) {
      p.hyc();
    }
    k localk = this.tCD;
    if (localk == null) {
      p.btv("videoCore");
    }
    localk.dFx().a((ViewGroup)this, ((b)localObject).uPf, (kotlin.g.a.b)new m(this, (b)localObject));
    AppMethodBeat.o(168095);
  }
  
  public final void setEnableShowLoading(boolean paramBoolean)
  {
    this.wfd = paramBoolean;
  }
  
  public final void setLongVideo(boolean paramBoolean)
  {
    this.isLongVideo = paramBoolean;
  }
  
  public final void setLongVideoSeekBar(FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar)
  {
    this.wfr = paramFinderLongVideoPlayerSeekBar;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.guh = paramBoolean;
  }
  
  public final void setPlayAdapterPosition(int paramInt)
  {
    this.wfu = paramInt;
  }
  
  public final void setPlayInfo(b paramb)
  {
    this.wfp = paramb;
  }
  
  public final void setStartPlayTime(final long paramLong)
  {
    AppMethodBeat.i(254324);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new p(this, paramLong));
    AppMethodBeat.o(254324);
  }
  
  public final void setThumbShowCallback(kotlin.g.a.m<? super Boolean, ? super b, kotlin.x> paramm)
  {
    this.wft = paramm;
  }
  
  public final void setVideoCore(k paramk)
  {
    AppMethodBeat.i(168089);
    p.h(paramk, "<set-?>");
    this.tCD = paramk;
    AppMethodBeat.o(168089);
  }
  
  public final void setVideoPauseCallback(kotlin.g.a.m<? super Boolean, ? super b, kotlin.x> paramm)
  {
    this.wfs = paramm;
  }
  
  public final void setVideoView(r paramr)
  {
    this.wfl = paramr;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$Companion;", "", "()V", "ICON_DISMISS_DURATION", "", "LIMIT_SHOW_PROGRESS", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "mediaId", "", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "position", "", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "isLocal", "", "isFocusPlaying", "isSeekMode", "isHasPlayed", "cropInfo", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;ILjava/util/LinkedList;ZZZZLcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;)V", "getCropInfo", "()Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "setCropInfo", "(Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "()Z", "setFocusPlaying", "(Z)V", "setHasPlayed", "setSeekMode", "getMedia", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "getMediaId", "()Ljava/lang/String;", "getMediaList", "()Ljava/util/LinkedList;", "getPosition", "()I", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class b
  {
    final boolean dLQ;
    public final FeedData feed;
    public final String mediaId;
    final LinkedList<cjl> mediaList;
    private final int position;
    cjx uOR;
    public final com.tencent.mm.plugin.finder.loader.s uPf;
    public boolean wbG;
    boolean wfA;
    public boolean wfz;
    
    private b(FeedData paramFeedData, String paramString, com.tencent.mm.plugin.finder.loader.s params, int paramInt, LinkedList<cjl> paramLinkedList, boolean paramBoolean, cjx paramcjx)
    {
      AppMethodBeat.i(254274);
      this.feed = paramFeedData;
      this.mediaId = paramString;
      this.uPf = params;
      this.position = paramInt;
      this.mediaList = paramLinkedList;
      this.dLQ = paramBoolean;
      this.wfz = false;
      this.wbG = false;
      this.wfA = false;
      this.uOR = paramcjx;
      AppMethodBeat.o(254274);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(168056);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.j(this.feed, paramObject.feed)) || (!p.j(this.mediaId, paramObject.mediaId)) || (!p.j(this.uPf, paramObject.uPf)) || (this.position != paramObject.position) || (!p.j(this.mediaList, paramObject.mediaList)) || (this.dLQ != paramObject.dLQ) || (this.wfz != paramObject.wfz) || (this.wbG != paramObject.wbG) || (this.wfA != paramObject.wfA) || (!p.j(this.uOR, paramObject.uOR))) {}
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
      String str = "PlayInfo(feed=" + this.feed + ", mediaId=" + this.mediaId + ", media=" + this.uPf + ", position=" + this.position + ", mediaList=" + this.mediaList + ", isLocal=" + this.dLQ + ", isFocusPlaying=" + this.wfz + ", isSeekMode=" + this.wbG + ", isHasPlayed=" + this.wfA + ", cropInfo=" + this.uOR + ")";
      AppMethodBeat.o(168054);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    c(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    d(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$bulletSubtitleButton$2$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderVideoLayout.d paramd) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(254276);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoLayout$bulletSubtitleButton$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramView = FinderVideoLayout.j(this.wfC.wfB);
        if (paramView == null) {
          p.hyc();
        }
        if (!paramView.getFunctionSwitch()) {}
        for (boolean bool = true;; bool = false)
        {
          FinderVideoLayout.q(this.wfC.wfB).setSelected(bool);
          paramView = com.tencent.mm.kernel.g.aAh();
          p.g(paramView, "MMKernel.storage()");
          paramView.azQ().set(ar.a.OmJ, Boolean.valueOf(bool));
          paramView = FinderVideoLayout.j(this.wfC.wfB);
          if (paramView == null) {
            p.hyc();
          }
          paramView.L(bool, true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderVideoLayout$bulletSubtitleButton$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(254276);
          return;
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class e<T, R>
    implements com.tencent.mm.loader.f.e<o, Bitmap>
  {
    e(FinderVideoLayout paramFinderVideoLayout) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$dismissThumb$1$1"})
  static final class f
    implements Runnable
  {
    f(r paramr, FinderVideoLayout paramFinderVideoLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(168058);
      this.wfD.animate().cancel();
      this.wfD.animate().alpha(1.0F).setDuration(200L).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(254279);
          this.wfE.wfD.setAlpha(1.0F);
          FinderVideoLayout.a(this.wfE.wfB, false);
          AppMethodBeat.o(254279);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(254280);
          FinderVideoLayout.a(this.wfE.wfB, true);
          AppMethodBeat.o(254280);
        }
      }).start();
      AppMethodBeat.o(168058);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    g(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$fullscreenIcon$2$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(View paramView, FinderVideoLayout.g paramg) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(254281);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoLayout$fullscreenIcon$2$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramView = new cjk();
        paramView.mediaList.addAll((Collection)FinderVideoLayout.r(this.wfF.wfB));
        localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
        localObject = this.tCl.getContext();
        if (localObject == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(254281);
          throw paramView;
        }
        com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject, null, paramView, null, false, 24);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderVideoLayout$fullscreenIcon$2$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(254281);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$initLongVideoSeekBar$1$1"})
  static final class h
    implements View.OnClickListener
  {
    h(FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar, FinderVideoLayout paramFinderVideoLayout) {}
    
    public final void onClick(View paramView)
    {
      boolean bool2 = true;
      AppMethodBeat.i(254283);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoLayout$initLongVideoSeekBar$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      boolean bool3 = this.wfG.cEF();
      paramView = jdField_this;
      if (!bool3)
      {
        bool1 = true;
        paramView.oQ(bool1);
        paramView = this.wfG;
        if (bool3) {
          break label161;
        }
      }
      label161:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramView.setIsPlay(bool1);
        if (bool3)
        {
          paramView = jdField_this.getPlayInfo();
          if (paramView != null)
          {
            localObject = FinderVideoLayout.o(jdField_this);
            if (localObject != null) {
              ((c.b)localObject).a(paramView.feed.getExpectId(), paramView.uPf.uIw, paramView.uPf);
            }
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderVideoLayout$initLongVideoSeekBar$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(254283);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderVideoLayout$initLongVideoSeekBar$1$2", "Lcom/tencent/mm/plugin/sight/decode/ui/IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "plugin-finder_release"})
  public static final class i
    implements com.tencent.mm.plugin.sight.decode.ui.b
  {
    i(FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar, FinderVideoLayout paramFinderVideoLayout) {}
    
    public final void aJq()
    {
      AppMethodBeat.i(254285);
      jdField_this.oQ(false);
      this.wfG.setIsPlay(false);
      kotlin.g.a.a locala = this.wfG.getOnSeekStart();
      if (locala != null)
      {
        locala.invoke();
        AppMethodBeat.o(254285);
        return;
      }
      AppMethodBeat.o(254285);
    }
    
    public final void rk(int paramInt)
    {
      AppMethodBeat.i(254284);
      Object localObject = this.wfG.uKd;
      if (localObject != null) {
        ((FinderLongVideoPlayerSeekBar.b)localObject).rk(paramInt);
      }
      localObject = jdField_this.getVideoView();
      if (localObject != null) {
        ((r)localObject).c(paramInt, true);
      }
      FinderVideoLayout.a(jdField_this);
      this.wfG.setIsPlay(true);
      localObject = this.wfG.getOnSeekEnd();
      if (localObject != null) {
        ((kotlin.g.a.a)localObject).invoke();
      }
      localObject = jdField_this.getPlayInfo();
      if (localObject != null)
      {
        c.b localb;
        long l;
        cjl localcjl;
        r localr;
        if (((FinderVideoLayout.b)localObject).wfz)
        {
          if (localObject == null) {
            break label211;
          }
          localb = FinderVideoLayout.o(jdField_this);
          if (localb == null) {
            break label205;
          }
          l = ((FinderVideoLayout.b)localObject).feed.getExpectId();
          localcjl = ((FinderVideoLayout.b)localObject).uPf.uIw;
          localr = jdField_this.getVideoView();
          if (localr == null) {
            break label200;
          }
        }
        label200:
        for (int i = localr.getCurrentPlaySecond();; i = 0)
        {
          localb.d(l, localcjl, i, paramInt, ((FinderVideoLayout.b)localObject).uPf);
          AppMethodBeat.o(254284);
          return;
          localObject = null;
          break;
        }
        label205:
        AppMethodBeat.o(254284);
        return;
      }
      label211:
      AppMethodBeat.o(254284);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderVideoLayout$lifecycle$1", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "onBeforePlay", "", "info", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "mediaSource", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "bgPreparedStatus", "", "onBgPrepared", "onFirstFrameUpdate", "prepareCostTime", "", "onFirstVideoFrameRendered", "onPause", "onPlay", "onPlayProgress", "offset", "total", "onPlayProgressMs", "offsetMs", "totalMs", "onPlayerConfigChange", "playerConfig", "Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "onReplay", "onStopPlay", "plugin-finder_release"})
  public static final class j
    implements y
  {
    public final void Gr(long paramLong)
    {
      AppMethodBeat.i(254290);
      FinderVideoLayout.b localb = this.wfB.getPlayInfo();
      if (localb != null)
      {
        Object localObject = af.viA;
        String str = localb.uPf.uIw.mediaId;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        af.bq((String)localObject, true);
        this.wfB.fo("", localb.mediaId);
        localObject = FinderVideoLayout.o(this.wfB);
        if (localObject != null)
        {
          ((c.b)localObject).a(localb.feed.getExpectId(), localb.uPf.uIw, localb.uPf, paramLong);
          AppMethodBeat.o(254290);
          return;
        }
        AppMethodBeat.o(254290);
        return;
      }
      AppMethodBeat.o(254290);
    }
    
    public final void a(com.tencent.mm.plugin.finder.video.reporter.c paramc)
    {
      AppMethodBeat.i(254292);
      FinderVideoLayout.b localb = this.wfB.getPlayInfo();
      if (localb != null)
      {
        c.b localb1 = FinderVideoLayout.o(this.wfB);
        if (localb1 != null)
        {
          localb1.a(localb.feed.getExpectId(), localb.uPf.uIw, localb.mediaList, localb.uPf, paramc);
          AppMethodBeat.o(254292);
          return;
        }
        AppMethodBeat.o(254292);
        return;
      }
      AppMethodBeat.o(254292);
    }
    
    public final void a(s params, int paramInt)
    {
      AppMethodBeat.i(254289);
      FinderVideoLayout.b localb = this.wfB.getPlayInfo();
      if (localb != null)
      {
        c.b localb1 = FinderVideoLayout.o(this.wfB);
        if (localb1 != null)
        {
          localb1.a(localb.feed.getId(), localb.uPf.uIw, params, this.wfB.getPlayAdapterPosition(), localb.uPf, paramInt);
          AppMethodBeat.o(254289);
          return;
        }
        AppMethodBeat.o(254289);
        return;
      }
      AppMethodBeat.o(254289);
    }
    
    public final void a(cjl paramcjl, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(254293);
      FinderVideoLayout.b localb = this.wfB.getPlayInfo();
      if (localb != null)
      {
        Object localObject = this.wfB.getVideoView();
        int i;
        label181:
        label185:
        boolean bool;
        if (localObject != null)
        {
          i = ((r)localObject).getCurrentPlaySecond();
          localObject = FinderVideoLayout.o(this.wfB);
          if (localObject != null) {
            ((c.b)localObject).a(localb.feed.getExpectId(), localb.uPf.uIw, paramInt1, paramInt2, localb.uPf);
          }
          if (paramInt1 >= 20)
          {
            localObject = FinderVideoLayout.d(this.wfB);
            if ((localObject != null) && (!((q)localObject).dEY()))
            {
              localObject = FinderVideoLayout.d(this.wfB);
              if (localObject != null) {
                ((q)localObject).oI(false);
              }
            }
          }
          localObject = localb.uOR;
          if (localObject != null)
          {
            if ((((cjx)localObject).iqg <= 0) || (((cjx)localObject).dvv < 0) || (((cjx)localObject).iqg <= ((cjx)localObject).dvv)) {
              break label490;
            }
            paramInt1 = 1;
            if (paramInt1 == 0) {
              break label495;
            }
            if ((localObject != null) && (i >= ((cjx)localObject).iqg / 1000))
            {
              r localr = this.wfB.getVideoView();
              localObject = localr;
              if (!(localr instanceof FinderCropVideoView)) {
                localObject = null;
              }
              localObject = (FinderCropVideoView)localObject;
              if (localObject != null)
              {
                localObject = ((FinderCropVideoView)localObject).qbJ;
                if (localObject != null) {
                  ((j)localObject).d(0.0D, true);
                }
              }
              localObject = new hj();
              ((hj)localObject).dLP.dLQ = true;
              ((hj)localObject).dLP.feedId = localb.feed.getLocalId();
              ((hj)localObject).dLP.dLR = true;
              ((hj)localObject).dLP.dLS = FinderVideoLayout.s(this.wfB);
              EventCenter.instance.publish((IEvent)localObject);
            }
          }
          if ((paramcjl == null) || (paramcjl.MoL != 3))
          {
            paramcjl = com.tencent.mm.plugin.finder.storage.c.vCb;
            paramInt1 = com.tencent.mm.plugin.finder.storage.c.drG();
            paramcjl = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (i == paramInt1 - ((Number)com.tencent.mm.plugin.finder.storage.c.vxi.getValue()).intValue())
            {
              paramcjl = new hj();
              localObject = paramcjl.dLP;
              if (localb.feed.getLocalId() == 0L) {
                break label501;
              }
              bool = true;
              label406:
              ((hj.a)localObject).dLQ = bool;
              localObject = paramcjl.dLP;
              if (!paramcjl.dLP.dLQ) {
                break label507;
              }
            }
          }
        }
        label490:
        label495:
        label501:
        label507:
        for (long l = localb.feed.getLocalId();; l = localb.feed.getFeedId())
        {
          ((hj.a)localObject).feedId = l;
          paramcjl.dLP.dLS = FinderVideoLayout.s(this.wfB);
          EventCenter.instance.publish((IEvent)paramcjl);
          FinderVideoLayout.t(this.wfB);
          AppMethodBeat.o(254293);
          return;
          i = 0;
          break;
          paramInt1 = 0;
          break label181;
          localObject = null;
          break label185;
          bool = false;
          break label406;
        }
      }
      AppMethodBeat.o(254293);
    }
    
    public final void b(s params)
    {
      AppMethodBeat.i(254288);
      if (params != null)
      {
        Object localObject = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
        localObject = com.tencent.mm.plugin.finder.storage.logic.d.avH(params.mediaId);
        if (!((at)localObject).field_hasPlayed)
        {
          ((at)localObject).field_hasPlayed = true;
          com.tencent.mm.ac.d.i((kotlin.g.a.a)new a((at)localObject));
        }
        localObject = FinderVideoLayout.o(this.wfB);
        if (localObject != null)
        {
          ((c.b)localObject).e(params.wgm.getId(), params.wgl, params.tHN);
          AppMethodBeat.o(254288);
          return;
        }
        AppMethodBeat.o(254288);
        return;
      }
      AppMethodBeat.o(254288);
    }
    
    public final void dFK()
    {
      Object localObject2 = null;
      AppMethodBeat.i(254291);
      FinderVideoLayout.b localb = this.wfB.getPlayInfo();
      if (localb != null)
      {
        Object localObject1 = af.viA;
        Object localObject3 = localb.uPf.uIw.mediaId;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        af.auO((String)localObject1);
        localObject3 = this.wfB;
        String str = localb.mediaId;
        StringBuilder localStringBuilder = new StringBuilder("[onFirstVideoFrameRendered] videoView=");
        localObject1 = ((FinderVideoLayout)localObject3).wfl;
        if (localObject1 != null)
        {
          localObject1 = Integer.valueOf(localObject1.hashCode());
          Log.i("Finder.VideoLayout", localObject1 + " mediaId=" + str);
          localObject1 = com.tencent.mm.plugin.finder.report.f.veb;
          localObject1 = ((FinderVideoLayout)localObject3).wfp;
          if (localObject1 == null) {
            break label291;
          }
          localObject1 = ((FinderVideoLayout.b)localObject1).feed;
          if (localObject1 == null) {
            break label291;
          }
          localObject1 = Long.valueOf(((FeedData)localObject1).getId());
          label154:
          if (localObject1 != null)
          {
            ((Long)localObject1).longValue();
            localObject3 = com.tencent.mm.plugin.finder.report.f.EZ(((Long)localObject1).longValue());
            if (((((f.a)localObject3).vee <= 0L) && (((f.a)localObject3).vec <= 0L)) || (((f.a)localObject3).veh != 0L)) {
              break label296;
            }
          }
        }
        label291:
        label296:
        for (int i = 1;; i = 0)
        {
          localObject1 = localObject2;
          if (i != 0) {
            localObject1 = localObject3;
          }
          if (localObject1 != null)
          {
            ((f.a)localObject1).veh = cl.aWA();
            com.tencent.mm.plugin.finder.report.f.vdZ.add(localObject1);
            com.tencent.mm.plugin.finder.report.f.vdY.clear();
          }
          localObject1 = FinderVideoLayout.o(this.wfB);
          if (localObject1 == null) {
            break label301;
          }
          ((c.b)localObject1).g(localb.feed.getExpectId(), localb.uPf.uIw, localb.uPf);
          AppMethodBeat.o(254291);
          return;
          localObject1 = null;
          break;
          localObject1 = null;
          break label154;
        }
        label301:
        AppMethodBeat.o(254291);
        return;
      }
      AppMethodBeat.o(254291);
    }
    
    public final void dFL()
    {
      AppMethodBeat.i(168062);
      FinderVideoLayout.b localb = this.wfB.getPlayInfo();
      if (localb != null)
      {
        c.b localb1 = FinderVideoLayout.o(this.wfB);
        if (localb1 != null)
        {
          localb1.b(localb.feed.getExpectId(), localb.uPf.uIw, localb.mediaList, localb.uPf);
          AppMethodBeat.o(168062);
          return;
        }
        AppMethodBeat.o(168062);
        return;
      }
      AppMethodBeat.o(168062);
    }
    
    public final void dFM()
    {
      AppMethodBeat.i(168063);
      FinderVideoLayout.b localb = this.wfB.getPlayInfo();
      if (localb != null)
      {
        Object localObject = FinderVideoLayout.o(this.wfB);
        if (localObject != null) {
          ((c.b)localObject).d(localb.feed.getExpectId(), localb.uPf.uIw, localb.uPf);
        }
        localObject = new hj();
        ((hj)localObject).dLP.feedId = localb.feed.getExpectId();
        ((hj)localObject).dLP.dLR = true;
        ((hj)localObject).dLP.dLS = FinderVideoLayout.s(this.wfB);
        EventCenter.instance.publish((IEvent)localObject);
        AppMethodBeat.o(168063);
        return;
      }
      AppMethodBeat.o(168063);
    }
    
    public final void dFN()
    {
      AppMethodBeat.i(168064);
      Object localObject1 = this.wfB.getPlayInfo();
      if (localObject1 != null)
      {
        Object localObject2 = FinderVideoLayout.o(this.wfB);
        if (localObject2 != null) {
          ((c.b)localObject2).a(((FinderVideoLayout.b)localObject1).feed.getExpectId(), ((FinderVideoLayout.b)localObject1).uPf.uIw, ((FinderVideoLayout.b)localObject1).mediaList, ((FinderVideoLayout.b)localObject1).uPf);
        }
        if (FinderVideoLayout.p(this.wfB) > 0L)
        {
          localObject2 = af.viA;
          localObject2 = ((FinderVideoLayout.b)localObject1).uPf.uIw.mediaId;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          af.auN((String)localObject1);
          localObject1 = this.wfB.getVideoView();
          if (localObject1 != null) {
            ((r)localObject1).c(FinderVideoLayout.p(this.wfB) / 1000.0D, true);
          }
          FinderVideoLayout.a(this.wfB, 0L);
        }
        AppMethodBeat.o(168064);
        return;
      }
      AppMethodBeat.o(168064);
    }
    
    public final void dFO()
    {
      AppMethodBeat.i(254294);
      if (this.wfB.getPlayInfo() != null) {
        FinderVideoLayout.t(this.wfB);
      }
      AppMethodBeat.o(254294);
    }
    
    public final void l(cjl paramcjl)
    {
      AppMethodBeat.i(254287);
      FinderVideoLayout.a(this.wfB, "onBgPrepared");
      StringBuilder localStringBuilder = new StringBuilder("onBgPrepared ");
      if (paramcjl != null)
      {
        String str = paramcjl.mediaId;
        paramcjl = str;
        if (str != null) {}
      }
      else
      {
        paramcjl = "";
      }
      Log.i("Finder.VideoLayout", paramcjl);
      AppMethodBeat.o(254287);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(at paramat)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    k(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ImageView>
  {
    l(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.b<r, kotlin.x>
  {
    m(FinderVideoLayout paramFinderVideoLayout, FinderVideoLayout.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$prepareToPlay$1$1"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.b<r, kotlin.x>
  {
    n(FinderVideoLayout.b paramb, FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    o(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$retryBtn$2$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderVideoLayout.o paramo) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(168076);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoLayout$retryBtn$2$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("Finder.VideoLayout", "retry video, position:" + this.wfJ.wfB.getPlayAdapterPosition());
        paramView = this.wfJ.wfB.getPlayInfo();
        if ((paramView != null) && (paramView.wfz == true))
        {
          paramView = this.wfJ.wfB.getVideoView();
          if (paramView != null) {
            paramView.stop();
          }
          this.wfJ.wfB.play(this.wfJ.wfB.getPlayAdapterPosition());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderVideoLayout$retryBtn$2$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168076);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.a<kotlin.x>
  {
    p(FinderVideoLayout paramFinderVideoLayout, long paramLong)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderVideoLayout$showLoading$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class q
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(254297);
      FinderVideoLayout.l(this.wfB).setAlpha(1.0F);
      FinderVideoLayout.l(this.wfB).setVisibility(0);
      AppMethodBeat.o(254297);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class r
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ImageView>
  {
    r(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$updateProgress$1$1"})
  static final class s
    implements Runnable
  {
    s(q paramq, FinderVideoLayout paramFinderVideoLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(254298);
      r localr = jdField_this.getVideoView();
      long l1;
      if (localr != null)
      {
        l1 = localr.getCurrentPlayMs();
        localr = jdField_this.getVideoView();
        if (localr == null) {
          break label155;
        }
      }
      label155:
      for (long l2 = localr.getVideoDurationMs();; l2 = 0L)
      {
        int i = (int)l1 / 1000;
        int j = (int)l2 / 1000;
        if ((!this.wfL.dEZ()) && (l2 > 0L) && (FinderVideoLayout.m(jdField_this) == -1.0F))
        {
          this.wfL.bm((float)l1 * 1.0F / (float)l2);
          if (FinderVideoLayout.n(jdField_this) != i)
          {
            this.wfL.gs(i, j);
            FinderVideoLayout.a(jdField_this, i);
          }
        }
        AppMethodBeat.o(254298);
        return;
        l1 = 0L;
        break;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$updateProgress$2$1"})
  static final class t
    implements Runnable
  {
    t(FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar, FinderVideoLayout paramFinderVideoLayout) {}
    
    public final void run()
    {
      int j = 0;
      AppMethodBeat.i(254299);
      this.wfG.setIsPlay(true);
      Object localObject = jdField_this.getVideoView();
      int i;
      r localr;
      if (localObject != null)
      {
        i = ((r)localObject).getCurrentPlaySecond();
        localObject = jdField_this.getVideoView();
        if (localObject != null) {
          j = ((r)localObject).getVideoDuration();
        }
        this.wfG.setVideoTotalTime(j);
        this.wfG.xv(i);
        localObject = this.wfG;
        localr = jdField_this.getVideoView();
        if (localr == null) {
          break label134;
        }
      }
      label134:
      for (long l = localr.getCurrentPlayMs();; l = 0L)
      {
        localObject = ((FinderLongVideoPlayerSeekBar)localObject).uKd;
        if (localObject == null) {
          break label139;
        }
        ((FinderLongVideoPlayerSeekBar.b)localObject).onProgress(l);
        AppMethodBeat.o(254299);
        return;
        i = 0;
        break;
      }
      label139:
      AppMethodBeat.o(254299);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class u
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    u(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoLayout
 * JD-Core Version:    0.7.0.1
 */