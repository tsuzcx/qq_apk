package com.tencent.mm.plugin.finder.video;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ib;
import com.tencent.mm.autogen.a.ib.a;
import com.tencent.mm.autogen.a.jj;
import com.tencent.mm.autogen.a.si;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.event.c.b;
import com.tencent.mm.plugin.finder.event.c.c;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.model.az;
import com.tencent.mm.plugin.finder.report.ax;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.plugin.finder.viewmodel.component.bi;
import com.tencent.mm.plugin.finder.viewmodel.l.a;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.receiver.HeadsetReceiver.b;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.protocal.protobuf.bgr;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.vfs.y;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.thumbplayer.api.ITPPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar$SeekBarCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomButtonLayout", "Landroid/view/View;", "getBottomButtonLayout", "()Landroid/view/View;", "bottomButtonLayout$delegate", "Lkotlin/Lazy;", "bulletSubtitleButton", "getBulletSubtitleButton", "bulletSubtitleButton$delegate", "bulletSubtitlePresenter", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;", "bulletSubtitleViewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback;", "ftppTag", "", "fullscreenIcon", "kotlin.jvm.PlatformType", "getFullscreenIcon", "fullscreenIcon$delegate", "isEnableFullScreenEnjoy", "", "isEnablePlay", "()Z", "setEnablePlay", "(Z)V", "isEnableShowLoading", "setEnableShowLoading", "isLongVideo", "setLongVideo", "value", "isMute", "setMute", "isNowPause", "isPreRenderFirstFrame", "setPreRenderFirstFrame", "isSelectedToPlay", "setSelectedToPlay", "isShowThumbAnimating", "lastCurrentPlaySecond", "lastSeekTime", "", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "loading", "getLoading", "loading$delegate", "longVideoSeekBar", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "getLongVideoSeekBar", "()Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "setLongVideoSeekBar", "(Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;)V", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "muteBtn", "Landroid/widget/ImageView;", "getMuteBtn", "()Landroid/widget/ImageView;", "muteBtn$delegate", "onHeadsetStateChangeListener", "Lcom/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver$OnHeadsetStateChangeListener;", "playAdapterPosition", "getPlayAdapterPosition", "()I", "setPlayAdapterPosition", "(I)V", "playInfo", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "getPlayInfo", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "setPlayInfo", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;)V", "playSpeedRatio", "retryBtn", "getRetryBtn", "retryBtn$delegate", "seekBarLayout", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar;", "startPlayTime", "", "startSeekMode", "tabType", "thumbShowCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isShow", "", "getThumbShowCallback", "()Lkotlin/jvm/functions/Function2;", "setThumbShowCallback", "(Lkotlin/jvm/functions/Function2;)V", "thumbView", "getThumbView", "thumbView$delegate", "videoCallBackList", "Lcom/tencent/mm/plugin/finder/video/IVideoCallBack;", "getVideoCallBackList", "()Ljava/util/LinkedList;", "videoCallBackList$delegate", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "getVideoCore", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setVideoCore", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;)V", "videoPauseCallback", "isPause", "getVideoPauseCallback", "setVideoPauseCallback", "videoStateVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM;", "videoTypeIv", "getVideoTypeIv", "videoTypeIv$delegate", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "getVideoView", "()Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "setVideoView", "(Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;)V", "adaptForCropShow", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "addVideoCallBack", "callBack", "checkVideoDataAvailable", "mediaId", "offset", "length", "checkVideoLivePlay", "convert", "position", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "isEnableFullEnjoy", "isSupportBulletSubtitle", "dismissLoading", "dismissRetryBtn", "dismissThumb", "invokeSouce", "findBestVideo", "feedId", "getBitmap", "Landroid/graphics/Bitmap;", "getCurrentPosMs", "getCurrentPosSec", "getFTPPTag", "getVideoDurationSec", "getVideoPlayBehavior", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "initFTPPTag", "invokeSource", "initLiveVideoView", "director", "Lcom/tencent/mm/plugin/finder/live/fluent/IFinderFluentSwitchDirector;", "info", "initLongVideoSeekBar", "isEnableSeek", "isFluentFinderLive", "isSeekMode", "isVideoPlaying", "layoutLoadingIcon", "loginfo", "onAttachedToWindow", "onDetachedFromWindow", "onEnterSeekMode", "isEnter", "showPauseTips", "onError", "sessionId", "errorMsg", "what", "extra", "onFinishDownload", "ret", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onFirstVideoFrameRendered", "onGetVideoSize", "width", "height", "onHandlePausePlay", "onHandleResumePlay", "onMoovReadyDownload", "total", "moovFirstDownloaded", "onMute", "mute", "onNeedIgnoreTouchEvent", "event", "Landroid/view/MotionEvent;", "onPlayAfterSeek", "onPrepared", "onProgressDownload", "onSeekComplete", "player", "Lcom/tencent/thumbplayer/api/ITPPlayer;", "onStartDownload", "onStartSeek", "onStopDownload", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onStopSeek", "percent", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "onViewAdded", "child", "onViewRecycled", "onViewRemoved", "pause", "isForceRemoveVideoView", "play", "videoPlayTrace", "Lcom/tencent/mm/plugin/findersdk/trace/FinderVideoPlayTrace;", "prepare", "isLocal", "feedData", "prepareToPlay", "publishSeekEvent", "currSec", "seekSec", "removeVideoCallBack", "retryFindSpecPlay", "retryPlay", "setStartPlayTime", "timeMs", "mode", "playSpeed", "showLoading", "showRetryBtn", "showThumb", "showVideoPauseTip", "show", "showVideoTypeIv", "toggleVideo", "isPlay", "updateProgress", "offsetMs", "totalMs", "viewLog", "Companion", "PlayInfo", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderVideoLayout
  extends FrameLayout
  implements aa, s.a, w, i.b
{
  public static final FinderVideoLayout.a Gqj;
  public l AJn;
  private com.tencent.mm.plugin.finder.feed.e AWe;
  public com.tencent.mm.plugin.finder.feed.d AWf;
  private HeadsetReceiver.b EEW;
  private String FkY;
  private float Flp;
  private final ab Flu;
  public b GqA;
  public s GqB;
  private FinderLongVideoPlayerSeekBar GqC;
  private m<? super Boolean, ? super b, ah> GqD;
  private m<? super Boolean, ? super b, ah> GqE;
  private int GqF;
  public boolean GqG;
  private boolean GqH;
  private float GqI;
  private int GqJ;
  private int GqK;
  private boolean Gqk;
  private boolean Gql;
  public final com.tencent.mm.plugin.finder.viewmodel.l Gqm;
  private final j Gqn;
  private boolean Gqo;
  private boolean Gqp;
  private final j Gqq;
  private final j Gqr;
  private final j Gqs;
  private final j Gqt;
  private final j Gqu;
  public t Gqv;
  private final j Gqw;
  private final j Gqx;
  private final j Gqy;
  public boolean Gqz;
  private int hJx;
  public boolean isLongVideo;
  public boolean lAj;
  public LinkedList<dji> mediaList;
  private long ork;
  
  static
  {
    AppMethodBeat.i(168083);
    Gqj = new FinderVideoLayout.a((byte)0);
    AppMethodBeat.o(168083);
  }
  
  public FinderVideoLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168131);
    setTag("Finder.VideoLayout");
    setId(e.e.finder_banner_video_layout);
    setImportantForAccessibility(2);
    this.FkY = "Finder.VideoLayout";
    this.Gql = true;
    paramContext = com.tencent.mm.ui.component.k.aeZF;
    paramContext = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.l.class);
    kotlin.g.b.s.s(paramContext, "UICProvider.of(PluginFin…StateCacheVM::class.java)");
    this.Gqm = ((com.tencent.mm.plugin.finder.viewmodel.l)paramContext);
    this.Gqn = kotlin.k.cm((kotlin.g.a.a)new FinderVideoLayout.h(this));
    this.Gqq = kotlin.k.cm((kotlin.g.a.a)FinderVideoLayout.q.GqV);
    this.EEW = ((HeadsetReceiver.b)new j(this));
    this.Gqr = kotlin.k.cm((kotlin.g.a.a)new FinderVideoLayout.c(this));
    this.Gqs = kotlin.k.cm((kotlin.g.a.a)new FinderVideoLayout.d(this));
    this.Gqt = kotlin.k.cm((kotlin.g.a.a)new FinderVideoLayout.i(this));
    this.Gqu = kotlin.k.cm((kotlin.g.a.a)new FinderVideoLayout.p(this));
    this.mediaList = new LinkedList();
    this.Gqw = kotlin.k.cm((kotlin.g.a.a)new FinderVideoLayout.e(this));
    this.Gqx = kotlin.k.cm((kotlin.g.a.a)new FinderVideoLayout.m(this));
    this.Gqy = kotlin.k.cm((kotlin.g.a.a)new FinderVideoLayout.r(this));
    this.Flu = ((ab)new g(this));
    this.GqG = true;
    this.GqI = -1.0F;
    this.GqJ = -1;
    this.GqK = 1;
    this.Flp = 1.0F;
    AppMethodBeat.o(168131);
  }
  
  public FinderVideoLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168132);
    setTag("Finder.VideoLayout");
    setId(e.e.finder_banner_video_layout);
    setImportantForAccessibility(2);
    this.FkY = "Finder.VideoLayout";
    this.Gql = true;
    paramContext = com.tencent.mm.ui.component.k.aeZF;
    paramContext = com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.l.class);
    kotlin.g.b.s.s(paramContext, "UICProvider.of(PluginFin…StateCacheVM::class.java)");
    this.Gqm = ((com.tencent.mm.plugin.finder.viewmodel.l)paramContext);
    this.Gqn = kotlin.k.cm((kotlin.g.a.a)new FinderVideoLayout.h(this));
    this.Gqq = kotlin.k.cm((kotlin.g.a.a)FinderVideoLayout.q.GqV);
    this.EEW = ((HeadsetReceiver.b)new j(this));
    this.Gqr = kotlin.k.cm((kotlin.g.a.a)new FinderVideoLayout.c(this));
    this.Gqs = kotlin.k.cm((kotlin.g.a.a)new FinderVideoLayout.d(this));
    this.Gqt = kotlin.k.cm((kotlin.g.a.a)new FinderVideoLayout.i(this));
    this.Gqu = kotlin.k.cm((kotlin.g.a.a)new FinderVideoLayout.p(this));
    this.mediaList = new LinkedList();
    this.Gqw = kotlin.k.cm((kotlin.g.a.a)new FinderVideoLayout.e(this));
    this.Gqx = kotlin.k.cm((kotlin.g.a.a)new FinderVideoLayout.m(this));
    this.Gqy = kotlin.k.cm((kotlin.g.a.a)new FinderVideoLayout.r(this));
    this.Flu = ((ab)new g(this));
    this.GqG = true;
    this.GqI = -1.0F;
    this.GqJ = -1;
    this.GqK = 1;
    this.Flp = 1.0F;
    AppMethodBeat.o(168132);
  }
  
  private final void a(com.tencent.mm.plugin.finder.loader.v paramv, FeedData paramFeedData, String paramString)
  {
    AppMethodBeat.i(335163);
    String str2 = String.valueOf(hashCode());
    int i = paramFeedData.getPosition();
    paramv = paramv.ExE;
    if (paramv == null) {
      paramv = "";
    }
    for (;;)
    {
      String str1 = com.tencent.mm.ae.d.hF(paramFeedData.getFeedId());
      String str3 = paramFeedData.getDescription();
      paramFeedData = paramFeedData.getNickName();
      this.FkY = ("FVLT." + i + '.' + o.aBv(str3) + '.' + o.aBv(str2));
      Log.i(this.FkY, "initFTPPTag from " + paramString + " pos:" + i + " mediaId:" + paramv + " feedId:" + str1 + " nickName:" + paramFeedData + " description:" + str3 + " finderVideoLayoutHashCode:" + str2);
      AppMethodBeat.o(335163);
      return;
      str1 = paramv.mediaId;
      paramv = str1;
      if (str1 == null) {
        paramv = "";
      }
    }
  }
  
  private static final void a(FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar, int paramInt1, int paramInt2, FinderVideoLayout paramFinderVideoLayout)
  {
    AppMethodBeat.i(335186);
    kotlin.g.b.s.u(paramFinderLongVideoPlayerSeekBar, "$it");
    kotlin.g.b.s.u(paramFinderVideoLayout, "this$0");
    paramFinderLongVideoPlayerSeekBar.setVideoTotalTime(paramInt1);
    paramFinderLongVideoPlayerSeekBar.Bh(paramInt2);
    paramFinderVideoLayout = paramFinderVideoLayout.getVideoView();
    if (paramFinderVideoLayout == null) {}
    for (long l = 0L;; l = paramFinderVideoLayout.getCurrentPlayMs())
    {
      paramFinderLongVideoPlayerSeekBar = paramFinderLongVideoPlayerSeekBar.Goa;
      if (paramFinderLongVideoPlayerSeekBar != null) {
        paramFinderLongVideoPlayerSeekBar.qU(l);
      }
      AppMethodBeat.o(335186);
      return;
    }
  }
  
  private static final void a(FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar, FinderVideoLayout paramFinderVideoLayout, View paramView)
  {
    boolean bool2 = true;
    AppMethodBeat.i(335195);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLongVideoPlayerSeekBar);
    localb.cH(paramFinderVideoLayout);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/video/FinderVideoLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderLongVideoPlayerSeekBar, "$it");
    kotlin.g.b.s.u(paramFinderVideoLayout, "this$0");
    boolean bool3 = paramFinderLongVideoPlayerSeekBar.dxE();
    if (!bool3)
    {
      bool1 = true;
      paramFinderVideoLayout.uH(bool1);
      if (bool3) {
        break label196;
      }
    }
    label196:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramFinderLongVideoPlayerSeekBar.setIsPlay(bool1);
      if (bool3)
      {
        paramFinderLongVideoPlayerSeekBar = paramFinderVideoLayout.getPlayInfo();
        if (paramFinderLongVideoPlayerSeekBar != null)
        {
          paramFinderVideoLayout = paramFinderVideoLayout.getVideoPlayBehavior();
          if (paramFinderVideoLayout != null) {
            paramFinderVideoLayout.a(paramFinderLongVideoPlayerSeekBar.feed.getExpectId(), paramFinderLongVideoPlayerSeekBar.EEv.ExE, (x)paramFinderLongVideoPlayerSeekBar.EEv);
          }
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/video/FinderVideoLayout", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(335195);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static final void a(FinderVideoLayout paramFinderVideoLayout, com.tencent.mm.loader.g.a.a parama, com.tencent.mm.loader.d.b.g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(335171);
    kotlin.g.b.s.u(paramFinderVideoLayout, "this$0");
    if (paramBitmap != null)
    {
      parama = paramFinderVideoLayout.getFTPPTag();
      paramg = new StringBuilder("[convert] mediaId=");
      b localb = paramFinderVideoLayout.getPlayInfo();
      kotlin.g.b.s.checkNotNull(localb);
      Log.i(parama, localb.mediaId + " thumb[" + paramBitmap.getWidth() + ':' + paramBitmap.getHeight() + "] view[" + paramFinderVideoLayout.getThumbView().getWidth() + ':' + paramFinderVideoLayout.getThumbView().getHeight() + "] scaleType=" + paramFinderVideoLayout.getThumbView().getScaleType() + ' ');
    }
    AppMethodBeat.o(335171);
  }
  
  private static final void a(s params, long paramLong1, FinderVideoLayout paramFinderVideoLayout, long paramLong2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(335178);
    kotlin.g.b.s.u(params, "$it");
    kotlin.g.b.s.u(paramFinderVideoLayout, "this$0");
    if ((!params.fiG()) && (paramLong1 > 0L)) {
      if (paramFinderVideoLayout.GqI != -1.0F) {
        break label100;
      }
    }
    label100:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        params.co(1.0F * (float)paramLong2 / (float)paramLong1);
        if (paramFinderVideoLayout.GqJ != paramInt1)
        {
          params.iw(paramInt1, paramInt2);
          paramFinderVideoLayout.GqJ = paramInt1;
        }
      }
      AppMethodBeat.o(335178);
      return;
    }
  }
  
  private final void a(t paramt, com.tencent.mm.plugin.finder.loader.v paramv, LinkedList<dji> paramLinkedList)
  {
    boolean bool2 = true;
    AppMethodBeat.i(335086);
    Log.i(getFTPPTag(), kotlin.g.b.s.X("checkVideoLivePlay isSeekMode:", Boolean.valueOf(fjt())));
    if (!fjt())
    {
      paramt.setVideoViewFocused(true);
      if (paramt.r(null))
      {
        Log.i(getFTPPTag(), "[FinderVideoLayout#start] layout=[" + getWidth() + ':' + getHeight() + "] videoView=[" + getWidth() + ':' + getHeight() + "] video=[" + paramv.ExE.width + ':' + paramv.ExE.height + "] " + fjx() + " media=" + paramv + " mediaList=" + paramLinkedList.size() + ' ');
        dEE();
      }
      if (!com.tencent.mm.n.a.aTj()) {
        break label226;
      }
      bool1 = true;
      if (!bool1) {
        break label235;
      }
    }
    for (boolean bool1 = bool2;; bool1 = l.fjs())
    {
      paramt.setMute(bool1);
      AppMethodBeat.o(335086);
      return;
      label226:
      bool1 = this.lAj;
      break;
      label235:
      getVideoCore();
    }
  }
  
  private final void aCr(String paramString)
  {
    AppMethodBeat.i(335105);
    Object localObject = this.GqE;
    if (localObject != null) {
      ((m)localObject).invoke(Boolean.FALSE, this.GqA);
    }
    localObject = this.Gqv;
    if (localObject == null) {}
    for (localObject = null; kotlin.g.b.s.a((Float)localObject, 1.0F); localObject = Float.valueOf(((t)localObject).getAlpha()))
    {
      Log.w(getFTPPTag(), "dismissThumb return for alpha == 1.");
      AppMethodBeat.o(335105);
      return;
    }
    if (this.GqH)
    {
      Log.w(getFTPPTag(), kotlin.g.b.s.X("dismissThumb return for isShowThumbAnimating:", Boolean.valueOf(this.GqH)));
      AppMethodBeat.o(335105);
      return;
    }
    localObject = this.Gqv;
    if (localObject != null) {
      ((t)localObject).setAlpha(1.0F);
    }
    Log.i(getFTPPTag(), "[dismissThumb] " + paramString + ' ' + fjx());
    AppMethodBeat.o(335105);
  }
  
  private final void au(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(335136);
    Object localObject;
    if (paramLong1 == -1L)
    {
      localObject = this.Gqv;
      if (localObject == null)
      {
        paramLong1 = 0L;
        if (paramLong2 != -1L) {
          break label196;
        }
        localObject = this.Gqv;
        if (localObject != null) {
          break label185;
        }
        paramLong2 = 0L;
      }
    }
    label185:
    label196:
    for (;;)
    {
      int i = (int)(paramLong1 / 1000L);
      int j = (int)(paramLong2 / 1000L);
      localObject = this.GqB;
      if (localObject != null) {
        post(new FinderVideoLayout..ExternalSyntheticLambda3((s)localObject, paramLong2, this, paramLong1, i, j));
      }
      localObject = this.GqC;
      if (localObject != null) {
        ((FinderLongVideoPlayerSeekBar)localObject).post(new FinderVideoLayout..ExternalSyntheticLambda2((FinderLongVideoPlayerSeekBar)localObject, j, i, this));
      }
      localObject = ((Iterable)getVideoCallBackList()).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((u)((Iterator)localObject).next()).au(paramLong1, paramLong2);
      }
      paramLong1 = ((t)localObject).getCurrentPlayMs();
      break;
      break;
      paramLong2 = ((t)localObject).getVideoDurationMs();
    }
    AppMethodBeat.o(335136);
  }
  
  public static void b(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(335155);
    jj localjj = new jj();
    localjj.hKV.feedId = paramLong;
    localjj.hKV.mediaId = paramString;
    localjj.hKV.hKW = paramInt1;
    localjj.hKV.hKX = paramInt2;
    localjj.publish();
    AppMethodBeat.o(335155);
  }
  
  private final void dEE()
  {
    AppMethodBeat.i(168123);
    Object localObject = this.GqC;
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
  
  private final boolean fjt()
  {
    b localb = this.GqA;
    return (localb != null) && (localb.Gnn == true);
  }
  
  private final void fju()
  {
    int i = 0;
    AppMethodBeat.i(168119);
    this.GqH = false;
    Object localObject = this.GqE;
    if (localObject != null) {
      ((m)localObject).invoke(Boolean.TRUE, this.GqA);
    }
    localObject = this.Gqv;
    if (localObject == null) {}
    for (float f = 0.0F;; f = ((t)localObject).getAlpha())
    {
      if (f == 0.0F) {
        i = 1;
      }
      if (i == 0) {
        break;
      }
      AppMethodBeat.o(168119);
      return;
    }
    localObject = this.Gqv;
    if (localObject != null) {
      ((t)localObject).setAlpha(0.0F);
    }
    Log.i(getFTPPTag(), kotlin.g.b.s.X("[showThumb] ", fjx()));
    AppMethodBeat.o(168119);
  }
  
  private final void fjv()
  {
    AppMethodBeat.i(168121);
    getRetryBtn().animate().cancel();
    getRetryBtn().setVisibility(0);
    s locals = this.GqB;
    if (locals != null) {
      locals.setVisibility(8);
    }
    dEE();
    AppMethodBeat.o(168121);
  }
  
  private final void fjw()
  {
    AppMethodBeat.i(168122);
    getRetryBtn().animate().cancel();
    s locals = this.GqB;
    if (locals != null) {
      locals.setVisibility(0);
    }
    getRetryBtn().setVisibility(8);
    AppMethodBeat.o(168122);
  }
  
  private final View getBottomButtonLayout()
  {
    AppMethodBeat.i(335045);
    Object localObject = this.Gqr.getValue();
    kotlin.g.b.s.s(localObject, "<get-bottomButtonLayout>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(335045);
    return localObject;
  }
  
  private final View getBulletSubtitleButton()
  {
    AppMethodBeat.i(335051);
    Object localObject = this.Gqs.getValue();
    kotlin.g.b.s.s(localObject, "<get-bulletSubtitleButton>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(335051);
    return localObject;
  }
  
  private final View getFullscreenIcon()
  {
    AppMethodBeat.i(335063);
    View localView = (View)this.Gqw.getValue();
    AppMethodBeat.o(335063);
    return localView;
  }
  
  private final View getLoading()
  {
    AppMethodBeat.i(168084);
    Object localObject = this.Gqn.getValue();
    kotlin.g.b.s.s(localObject, "<get-loading>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(168084);
    return localObject;
  }
  
  private final ImageView getMuteBtn()
  {
    AppMethodBeat.i(168086);
    Object localObject = this.Gqt.getValue();
    kotlin.g.b.s.s(localObject, "<get-muteBtn>(...)");
    localObject = (ImageView)localObject;
    AppMethodBeat.o(168086);
    return localObject;
  }
  
  private final ImageView getThumbView()
  {
    AppMethodBeat.i(168087);
    Object localObject = this.Gqu.getValue();
    kotlin.g.b.s.s(localObject, "<get-thumbView>(...)");
    localObject = (ImageView)localObject;
    AppMethodBeat.o(168087);
    return localObject;
  }
  
  private final View getVideoTypeIv()
  {
    AppMethodBeat.i(168093);
    Object localObject = this.Gqy.getValue();
    kotlin.g.b.s.s(localObject, "<get-videoTypeIv>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(168093);
    return localObject;
  }
  
  private final void showLoading()
  {
    AppMethodBeat.i(168124);
    String str = getFTPPTag();
    Object localObject = this.Gqv;
    int i;
    if (localObject == null)
    {
      localObject = null;
      Log.i(str, kotlin.g.b.s.X("showLoading ", localObject));
      if (!this.Gql) {
        break label165;
      }
      localObject = this.Gqv;
      if ((localObject == null) || (((t)localObject).getVideoViewFocused() != true)) {
        break label110;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        localObject = this.GqC;
        if (localObject != null)
        {
          localObject = ((FinderLongVideoPlayerSeekBar)localObject).getOnCustomLoadingStatusChange();
          if (localObject != null)
          {
            ((kotlin.g.a.b)localObject).invoke(Boolean.TRUE);
            AppMethodBeat.o(168124);
            return;
            localObject = ((t)localObject).getVideoMediaId();
            break;
            label110:
            i = 0;
            continue;
          }
        }
        getLoading().setVisibility(0);
        getLoading().setAlpha(0.0F);
        getLoading().animate().alpha(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new FinderVideoLayout.o(this)).start();
      }
    }
    label165:
    AppMethodBeat.o(168124);
  }
  
  public final com.tencent.mm.plugin.finder.loader.v a(long paramLong, String paramString, dji paramdji)
  {
    AppMethodBeat.i(335793);
    paramdji = com.tencent.mm.plugin.finder.storage.logic.e.FNF.b(paramLong, paramdji);
    Log.i(getFTPPTag(), "[findBestVideo] feedId=" + com.tencent.mm.ae.d.hF(paramLong) + " mediaId=" + paramString + " videoFlag=" + paramdji.ExF);
    AppMethodBeat.o(335793);
    return paramdji;
  }
  
  public final void a(int paramInt1, int paramInt2, x paramx)
  {
    AppMethodBeat.i(335773);
    kotlin.g.b.s.u(paramx, "video");
    Object localObject2 = getFTPPTag();
    StringBuilder localStringBuilder = new StringBuilder("[onProgressDownload] videoView=");
    Object localObject1 = this.Gqv;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i((String)localObject2, localObject1 + " offset=" + paramInt1 + " total=" + paramInt2 + " video=" + paramx.aUt());
      localObject1 = this.GqA;
      if (localObject1 != null) {
        if (!((b)localObject1).GqL) {
          break label302;
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = getVideoPlayBehavior();
        if (localObject2 != null) {
          ((c.b)localObject2).c(((b)localObject1).feed.getExpectId(), ((b)localObject1).EEv.ExE, paramInt1, paramInt2, (x)((b)localObject1).EEv);
        }
      }
      localObject1 = com.tencent.mm.plugin.finder.preload.f.EUC;
      if (com.tencent.mm.plugin.finder.preload.f.eHI())
      {
        localObject2 = new si();
        ((si)localObject2).hVv.mediaId = paramx.eCF().mediaId;
        ((si)localObject2).hVv.hVw = ((int)(100.0F * paramInt1 / paramInt2));
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
        localObject1 = paramx.eCF().mediaId;
        paramx = (x)localObject1;
        if (localObject1 == null) {
          paramx = "";
        }
        paramx = com.tencent.mm.plugin.finder.storage.logic.e.bS(paramx, true);
        ((si)localObject2).hVv.hVy = paramx.field_fileFormat;
        ((si)localObject2).hVv.hVx = paramx.field_hasPlayed;
        ((si)localObject2).publish();
      }
      AppMethodBeat.o(335773);
      return;
      localObject1 = Integer.valueOf(localObject1.hashCode());
      break;
      label302:
      localObject1 = null;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, x paramx, boolean paramBoolean)
  {
    AppMethodBeat.i(335764);
    kotlin.g.b.s.u(paramx, "video");
    String str = getFTPPTag();
    StringBuilder localStringBuilder = new StringBuilder("[onMoovReadyDownload] videoView=");
    Object localObject = this.Gqv;
    label263:
    if (localObject == null)
    {
      localObject = null;
      Log.i(str, localObject + "  offset=" + paramInt1 + " total=" + paramInt2 + " video=" + paramx + " moovFirstDownloaded=" + paramBoolean);
      paramx = this.GqA;
      if (paramx != null)
      {
        if (!paramx.GqL) {
          break label298;
        }
        label117:
        if (paramx != null)
        {
          localObject = ax.Fur;
          str = paramx.EEv.ExE.mediaId;
          localObject = str;
          if (str == null) {
            localObject = "";
          }
          ax.bL((String)localObject, paramBoolean);
          localObject = getVideoPlayBehavior();
          if (localObject != null) {
            ((c.b)localObject).b(paramx.feed.getExpectId(), paramx.EEv.ExE, paramInt1, paramInt2, (x)paramx.EEv);
          }
        }
      }
      paramx = com.tencent.mm.plugin.finder.report.s.Fqv;
      com.tencent.mm.plugin.finder.report.s.Sq(this.hJx);
      paramx = com.tencent.mm.plugin.finder.report.p.FpQ;
      paramx = this.GqA;
      if (paramx != null) {
        break label303;
      }
      paramx = null;
      label226:
      if (paramx != null)
      {
        paramx.longValue();
        paramx = com.tencent.mm.plugin.finder.report.p.pB(paramx.longValue());
        if ((paramx.FpW <= 0L) || (paramx.FpX != 0L)) {
          break label317;
        }
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label322;
        }
      }
    }
    for (;;)
    {
      if (paramx != null) {
        paramx.FpX = cn.bDw();
      }
      AppMethodBeat.o(335764);
      return;
      localObject = Integer.valueOf(localObject.hashCode());
      break;
      label298:
      paramx = null;
      break label117;
      label303:
      paramx = Long.valueOf(paramx.feed.getId());
      break label226;
      label317:
      paramInt1 = 0;
      break label263;
      label322:
      paramx = null;
    }
  }
  
  public final void a(int paramInt, x paramx, com.tencent.mm.g.d paramd)
  {
    AppMethodBeat.i(335753);
    kotlin.g.b.s.u(paramx, "video");
    String str = getFTPPTag();
    StringBuilder localStringBuilder = new StringBuilder("[onFinishDownload] ret=").append(paramInt).append(" videoView=");
    Object localObject = this.Gqv;
    if (localObject == null)
    {
      localObject = null;
      Log.i(str, localObject + " FinderVideo=" + paramx);
      dEE();
      paramx = this.GqA;
      if (paramx != null) {
        if (!paramx.GqL) {
          break label173;
        }
      }
    }
    for (;;)
    {
      if (paramx != null)
      {
        localObject = getVideoPlayBehavior();
        if (localObject != null) {
          ((c.b)localObject).a(paramx.feed.getExpectId(), paramx.EEv.ExE, paramInt, paramd, (x)paramx.EEv);
        }
      }
      if (paramInt < 0) {
        fjv();
      }
      AppMethodBeat.o(335753);
      return;
      localObject = Integer.valueOf(localObject.hashCode());
      break;
      label173:
      paramx = null;
    }
  }
  
  public final void a(int paramInt1, FeedData paramFeedData, s params, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, m<? super Boolean, ? super b, ah> paramm1, m<? super Boolean, ? super b, ah> paramm2)
  {
    AppMethodBeat.i(335515);
    kotlin.g.b.s.u(paramFeedData, "feed");
    Log.i(getFTPPTag(), "[convert] position=" + paramInt1 + " feedId=" + paramFeedData.getExpectId() + " current=" + System.currentTimeMillis() + " feedTime=" + paramFeedData.getTimestamps() + " urlValidDuration=" + paramFeedData.getUrlValidDuration() + 's');
    if (paramFeedData.getVrLive() == 1)
    {
      i = 1;
      this.hJx = paramInt2;
      this.Gqo = paramBoolean1;
      this.GqD = paramm1;
      this.GqE = paramm2;
      paramm1 = paramFeedData.getLiveInfo();
      if (paramm1 != null) {
        break label212;
      }
      paramBoolean1 = false;
    }
    for (;;)
    {
      if ((i == 0) && (!paramBoolean1)) {
        break label245;
      }
      getLoading().setVisibility(8);
      this.GqB = params;
      if (params != null) {
        params.setSeekBarCallback((s.a)this);
      }
      this.mediaList = paramFeedData.getMediaList();
      if (paramInt1 < this.mediaList.size()) {
        break label424;
      }
      AppMethodBeat.o(335515);
      return;
      i = 0;
      break;
      label212:
      paramm1 = paramm1.ZSn;
      if (paramm1 == null)
      {
        paramBoolean1 = false;
      }
      else
      {
        paramm2 = com.tencent.d.a.a.a.b.b.ahnU;
        paramBoolean1 = com.tencent.d.a.a.a.b.b.a(paramm1);
      }
    }
    label245:
    paramm1 = getLoading().getLayoutParams();
    if ((paramm1 instanceof FrameLayout.LayoutParams))
    {
      if (!this.Gqo) {
        break label360;
      }
      paramm1.width = ((int)getLoading().getContext().getResources().getDimension(e.c.Edge_4A));
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
      break;
      label360:
      i = (int)getLoading().getContext().getResources().getDimension(e.c.Edge_3A);
      paramm1.width = i;
      paramm1.height = paramm1.width;
      ((FrameLayout.LayoutParams)paramm1).topMargin = i;
      ((FrameLayout.LayoutParams)paramm1).setMarginEnd(i);
    }
    label424:
    paramm1 = this.mediaList.get(paramInt1);
    kotlin.g.b.s.s(paramm1, "mediaList[position]");
    Object localObject = (dji)paramm1;
    long l = paramFeedData.getId();
    paramm2 = ((dji)localObject).mediaId;
    paramm1 = paramm2;
    if (paramm2 == null) {
      paramm1 = "";
    }
    com.tencent.mm.plugin.finder.loader.v localv = a(l, paramm1, (dji)localObject);
    if ((paramFeedData.getId() == 0L) && (y.ZC(localv.getUrl())))
    {
      paramBoolean1 = true;
      paramm2 = localv.aUt();
      LinkedList localLinkedList = this.mediaList;
      if (!localv.ExE.aaPf) {
        break label1282;
      }
      paramm1 = localv.ExE.EDC;
      label545:
      this.GqA = new b(paramFeedData, paramm2, localv, paramInt1, localLinkedList, paramBoolean1, false, paramm1, (byte)0);
      paramm1 = ax.Fur;
      paramm2 = localv.ExE.mediaId;
      paramm1 = paramm2;
      if (paramm2 == null) {
        paramm1 = "";
      }
      ax.x(paramm1, localv.ExF.detail, localv.getUrl(), localv.eCf());
      fju();
      this.Gql = true;
      if (((dji)localObject).aaPl == null)
      {
        paramm1 = (CharSequence)((dji)localObject).aaPi;
        if ((paramm1 != null) && (paramm1.length() != 0)) {
          break label1288;
        }
        paramInt1 = 1;
        label666:
        if ((paramInt1 != 0) || (!this.Gqo)) {
          break label1314;
        }
      }
      if (!this.Gqo) {
        break label1293;
      }
      paramm1 = (n)new com.tencent.mm.plugin.finder.loader.k((dji)localObject, com.tencent.mm.plugin.finder.storage.v.FKZ);
      label701:
      getThumbView().setScaleType(ImageView.ScaleType.CENTER_CROP);
      if (((dji)localObject).mediaType != 9) {
        break label1450;
      }
      paramm2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramm2 = com.tencent.mm.plugin.finder.loader.p.eCt();
      label731:
      localObject = (CharSequence)paramm1.ExG;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label1463;
      }
      paramInt1 = 1;
      label758:
      if (paramInt1 == 0) {
        paramm2.mgj.blu().c(new com.tencent.mm.loader.g.a.a((com.tencent.mm.loader.g.a.c)paramm1));
      }
      paramm2 = paramm2.dk(paramm1);
      if (!this.Gqo) {
        break label1468;
      }
      paramm1 = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramm1 = com.tencent.mm.plugin.finder.loader.p.a(com.tencent.mm.plugin.finder.loader.p.a.ExK);
      label816:
      paramm2 = paramm2.a(paramm1).a(new FinderVideoLayout..ExternalSyntheticLambda1(this));
      paramm1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eTs().bmg()).intValue() <= 0) {
        break label1484;
      }
      paramm1 = new com.tencent.mm.loader.d.d(null, new com.tencent.mm.loader.d.b.g(this), 1);
      label877:
      paramm2.a((com.tencent.mm.loader.e.d)paramm1).d(getThumbView());
      paramm1 = this.Gqm.fb(localv.aUt(), paramInt2);
      if (paramm1 != null) {
        break label1490;
      }
      paramm1 = null;
      label922:
      if (paramm1 == null)
      {
        paramm1 = (FinderVideoLayout)this;
        if (params != null) {
          params.setProgress(0);
        }
        paramm1.uF(false);
        if (params != null) {
          params.aCk(kotlin.g.b.s.X(paramm1.getFTPPTag(), "convert"));
        }
        paramm1 = paramm1.getPlayInfo();
        if (paramm1 != null) {
          paramm1.Gnn = false;
        }
        if (params != null) {
          params.fiE();
        }
      }
      if (paramBoolean2)
      {
        if (this.AWf != null) {
          break label1573;
        }
        params = null;
        label1013:
        if (params == null)
        {
          params = (FinderVideoLayout)this;
          paramm1 = params.getContext();
          kotlin.g.b.s.s(paramm1, "context");
          params.AWf = new com.tencent.mm.plugin.finder.feed.d(paramm1);
          paramm1 = (View)params;
          paramm2 = params.AWf;
          kotlin.g.b.s.checkNotNull(paramm2);
          params.AWe = new com.tencent.mm.plugin.finder.feed.e(paramm1, paramm2);
          paramm1 = params.AWf;
          kotlin.g.b.s.checkNotNull(paramm1);
          params = params.AWe;
          kotlin.g.b.s.checkNotNull(params);
          paramm1.a(params);
        }
      }
      params = this.AWf;
      if (params != null)
      {
        kotlin.g.b.s.u(paramFeedData, "feed");
        params.hJx = paramInt2;
        params.isLoading = false;
        params.feed = paramFeedData;
        paramm1 = com.tencent.mm.plugin.finder.report.d.FnC;
        com.tencent.mm.plugin.finder.report.d.start(paramFeedData.getId());
        params.data.clear();
        params.ALE.bZE.notifyChanged();
        params.releaseListener();
        params.ATR = false;
      }
      paramFeedData = getBulletSubtitleButton();
      params = this.AWe;
      if (params != null) {
        break label1612;
      }
      paramBoolean1 = true;
      label1194:
      paramFeedData.setSelected(paramBoolean1);
      paramFeedData = this.GqC;
      if (paramFeedData != null)
      {
        paramFeedData.setVisibility(0);
        paramFeedData.setPlayBtnOnClickListener(new FinderVideoLayout..ExternalSyntheticLambda0(paramFeedData, this));
        params = getVideoView();
        if (params != null) {
          break label1621;
        }
      }
    }
    label1282:
    label1288:
    label1293:
    label1314:
    label1450:
    label1463:
    label1468:
    label1484:
    label1490:
    label1621:
    for (paramInt1 = 0;; paramInt1 = params.getVideoDuration())
    {
      paramFeedData.setVideoTotalTime(paramInt1);
      paramFeedData.setIsPlay(true);
      paramFeedData.setIplaySeekCallback((com.tencent.mm.plugin.sight.decode.ui.b)new f(paramFeedData, this));
      paramFeedData.a(this);
      AppMethodBeat.o(335515);
      return;
      paramBoolean1 = false;
      break;
      paramm1 = null;
      break label545;
      paramInt1 = 0;
      break label666;
      paramm1 = new n((dji)localObject, com.tencent.mm.plugin.finder.storage.v.FKZ, null, null, 12);
      break label701;
      paramm1 = "";
      if (this.isLongVideo)
      {
        paramm1 = getContext();
        if (paramm1 == null)
        {
          paramFeedData = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(335515);
          throw paramFeedData;
        }
        paramm1 = ((MMActivity)paramm1).getIntent().getStringExtra("KEY_VIDEO_THUMB_LOCAL_PATH");
        if (paramm1 == null) {
          paramm1 = "";
        }
        for (;;)
        {
          paramm2 = getContext();
          if (paramm2 != null) {
            break;
          }
          paramFeedData = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(335515);
          throw paramFeedData;
        }
        ((MMActivity)paramm2).getIntent().removeExtra("KEY_VIDEO_THUMB_LOCAL_PATH");
      }
      paramm1 = new n((dji)localObject, com.tencent.mm.plugin.finder.storage.v.FKZ, null, paramm1, 4);
      break label701;
      paramm2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramm2 = com.tencent.mm.plugin.finder.loader.p.eCl();
      break label731;
      paramInt1 = 0;
      break label758;
      paramm1 = com.tencent.mm.plugin.finder.loader.p.ExI;
      paramm1 = com.tencent.mm.plugin.finder.loader.p.a(com.tencent.mm.plugin.finder.loader.p.a.ExJ);
      break label816;
      paramm1 = null;
      break label877;
      if (params != null) {
        params.ux(true);
      }
      if (params != null) {
        params.setProgress(paramm1.progress);
      }
      uF(true);
      if (params != null) {
        params.fiH();
      }
      paramm1 = getPlayInfo();
      if (paramm1 != null) {
        paramm1.Gnn = true;
      }
      if (params == null)
      {
        paramm1 = null;
        break label922;
      }
      params.setVisibility(0);
      paramm1 = ah.aiuX;
      break label922;
      params = this.AWe;
      if (params == null)
      {
        params = null;
        break label1013;
      }
      params.V(com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adee, true), false);
      params = ah.aiuX;
      break label1013;
      paramBoolean1 = params.getFunctionSwitch();
      break label1194;
    }
  }
  
  public final void a(int paramInt, final com.tencent.mm.plugin.findersdk.f.a parama)
  {
    int j = 0;
    AppMethodBeat.i(335563);
    this.GqF = paramInt;
    ((ce)com.tencent.mm.kernel.h.ax(ce.class)).etm().DpW = paramInt;
    if (this.GqA == null)
    {
      Log.w(getFTPPTag(), "play playAdapterPosition:" + paramInt + " return for playInfo");
      AppMethodBeat.o(335563);
      return;
    }
    Object localObject1 = this.GqA;
    if ((localObject1 != null) && (((b)localObject1).feed.getMediaType() == 9))
    {
      i = 1;
      if (i == 0) {
        break label161;
      }
      localObject1 = this.GqA;
      if ((localObject1 == null) || (((b)localObject1).feed.getVrLive() != 1)) {
        break label156;
      }
    }
    label156:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label161;
      }
      Log.w("Finder.VideoAutoPlayManager", "playSelectedFeed return for vrLiveType");
      AppMethodBeat.o(335563);
      return;
      i = 0;
      break;
    }
    label161:
    localObject1 = this.GqA;
    kotlin.g.b.s.checkNotNull(localObject1);
    ((b)localObject1).feed.setPosition(paramInt);
    a(((b)localObject1).EEv, ((b)localObject1).feed, "prepare");
    Object localObject2 = ((b)localObject1).feed.getLiveInfo();
    boolean bool1;
    if (localObject2 == null)
    {
      bool1 = false;
      if ((this.GqG) && (!bool1)) {
        break label330;
      }
      localObject1 = getFTPPTag();
      localObject2 = new StringBuilder("isEnablePlay false ");
      parama = this.GqA;
      if (parama != null) {
        break label322;
      }
    }
    Object localObject3;
    label322:
    for (parama = null;; parama = parama.mediaId)
    {
      Log.w((String)localObject1, parama + " isOlympic: " + bool1);
      AppMethodBeat.o(335563);
      return;
      localObject2 = ((bip)localObject2).ZSn;
      if (localObject2 == null)
      {
        bool1 = false;
        break;
      }
      localObject3 = com.tencent.d.a.a.a.b.b.ahnU;
      bool1 = com.tencent.d.a.a.a.b.b.a((bgr)localObject2);
      break;
    }
    label330:
    localObject2 = com.tencent.mm.plugin.finder.live.fluent.g.CCu;
    localObject2 = com.tencent.mm.plugin.finder.live.fluent.g.nW(((b)localObject1).feed.getFeedId());
    paramInt = j;
    if (this.Gqv != null)
    {
      paramInt = j;
      if (localObject2 != null)
      {
        paramInt = j;
        if ((localObject2 instanceof com.tencent.mm.plugin.finder.live.fluent.e))
        {
          if (((com.tencent.mm.plugin.finder.live.fluent.e)localObject2).ejq() != null) {
            break label509;
          }
          paramInt = j;
        }
      }
    }
    while (paramInt != 0)
    {
      parama = this.Gqv;
      Log.i("Finder.VideoLayout", kotlin.g.b.s.X("fluent live exit initLiveVideoView media = ", Long.valueOf(((b)localObject1).feed.getFeedId())));
      if ((localObject2 instanceof com.tencent.mm.plugin.finder.live.fluent.e))
      {
        localObject2 = ((com.tencent.mm.plugin.finder.live.fluent.e)localObject2).ejq();
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.finder.live.fluent.h)localObject2).CCB;
          if ((localObject2 != null) && (parama != null)) {
            parama.a((com.tencent.mm.live.core.core.c.b)localObject2, ((b)localObject1).feed.getFeedId());
          }
        }
      }
      parama = this.Gqv;
      kotlin.g.b.s.checkNotNull(parama);
      a(parama, ((b)localObject1).EEv, ((b)localObject1).mediaList);
      AppMethodBeat.o(335563);
      return;
      label509:
      localObject3 = this.Gqv;
      kotlin.g.b.s.checkNotNull(localObject3);
      paramInt = j;
      if (((t)localObject3).eLN())
      {
        label572:
        boolean bool2;
        if (this.Gqv != null)
        {
          localObject3 = this.Gqv;
          kotlin.g.b.s.checkNotNull(localObject3);
          if (kotlin.g.b.s.p(((t)localObject3).getVideoMediaId(), ((b)localObject1).mediaId))
          {
            bool1 = true;
            localObject3 = this.Gqv;
            kotlin.g.b.s.checkNotNull(localObject3);
            if (((t)localObject3).getPlayer() != null)
            {
              localObject3 = ((com.tencent.mm.plugin.finder.live.fluent.e)localObject2).ejq();
              kotlin.g.b.s.checkNotNull(localObject3);
              localObject3 = ((com.tencent.mm.plugin.finder.live.fluent.h)localObject3).CCB;
              t localt = this.Gqv;
              kotlin.g.b.s.checkNotNull(localt);
              if (!kotlin.g.b.s.p(localObject3, localt.getPlayer())) {
                break label772;
              }
            }
            bool2 = true;
            label644:
            localObject3 = ((com.tencent.mm.plugin.finder.live.fluent.e)localObject2).ejq();
            if (localObject3 != null) {
              break label778;
            }
          }
        }
        label772:
        label778:
        for (boolean bool3 = false;; bool3 = ((com.tencent.mm.plugin.finder.live.fluent.f)localObject3).CCr)
        {
          localObject3 = com.tencent.mm.plugin.finder.live.fluent.g.CCu;
          boolean bool4 = com.tencent.mm.plugin.finder.live.fluent.g.ejr();
          Log.i("Finder.VideoLayout", "isFluentFinderLive isSameFeed: " + bool1 + " isFluentFinderLive " + bool2 + " isFloatWindowExit " + bool3 + " isLiveRoomTriggerFinish: " + bool4);
          paramInt = j;
          if (!bool1) {
            break;
          }
          paramInt = j;
          if (!bool2) {
            break;
          }
          paramInt = j;
          if (bool3) {
            break;
          }
          paramInt = j;
          if (!bool4) {
            break;
          }
          paramInt = 1;
          break;
          bool1 = false;
          break label572;
          bool2 = false;
          break label644;
        }
      }
    }
    getVideoCore().fjp().a((ViewGroup)this, (x)((b)localObject1).EEv, (kotlin.g.a.b)new k(this, parama, (b)localObject1));
    AppMethodBeat.o(335563);
  }
  
  public final void a(final long paramLong, int paramInt, final float paramFloat)
  {
    AppMethodBeat.i(335859);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new n(this, paramLong, paramInt, paramFloat));
    AppMethodBeat.o(335859);
  }
  
  public final void a(x paramx, com.tencent.mm.g.h paramh, com.tencent.mm.g.d paramd)
  {
    AppMethodBeat.i(335745);
    kotlin.g.b.s.u(paramx, "video");
    String str = getFTPPTag();
    StringBuilder localStringBuilder = new StringBuilder("[onStopDownload] videoView=");
    Object localObject = this.Gqv;
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf(localObject.hashCode()))
    {
      Log.i(str, localObject + " FinderVideo=" + paramx + " thumbVisible=" + getThumbView().getVisibility());
      paramx = this.GqA;
      if (paramx != null)
      {
        localObject = getVideoPlayBehavior();
        if (localObject != null) {
          ((c.b)localObject).a(paramx.feed.getExpectId(), paramx.EEv.ExE, paramh, paramd, (x)paramx.EEv);
        }
      }
      AppMethodBeat.o(335745);
      return;
    }
  }
  
  public final void a(u paramu)
  {
    AppMethodBeat.i(335875);
    kotlin.g.b.s.u(paramu, "callBack");
    getVideoCallBackList().remove(paramu);
    AppMethodBeat.o(335875);
  }
  
  public final boolean ad(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(335836);
    kotlin.g.b.s.u(paramMotionEvent, "event");
    if (getBulletSubtitleButton().getVisibility() != 0)
    {
      AppMethodBeat.o(335836);
      return false;
    }
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    ViewParent localViewParent = getBulletSubtitleButton().getParent();
    if (localViewParent == null)
    {
      paramMotionEvent = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(335836);
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
      AppMethodBeat.o(335836);
      return true;
    }
    AppMethodBeat.o(335836);
    return false;
  }
  
  public final void aj(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(169678);
    kotlin.g.b.s.u(paramString, "mediaId");
    paramString = this.GqA;
    if (paramString != null) {
      if (!paramString.GqL) {
        break label81;
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        c.b localb = getVideoPlayBehavior();
        if (localb != null) {
          localb.e(paramString.feed.getExpectId(), paramString.EEv.ExE, paramInt1, paramInt2, (x)paramString.EEv);
        }
      }
      AppMethodBeat.o(169678);
      return;
      label81:
      paramString = null;
    }
  }
  
  public final void b(x paramx)
  {
    Object localObject2 = null;
    AppMethodBeat.i(335733);
    kotlin.g.b.s.u(paramx, "video");
    String str = getFTPPTag();
    StringBuilder localStringBuilder = new StringBuilder("[onStartDownload] videoView=");
    Object localObject1 = this.Gqv;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i(str, localObject1 + " FinderVideo=" + paramx + " thumbVisible=" + getThumbView().getVisibility());
      fjw();
      paramx = this.GqA;
      if (paramx != null)
      {
        if (!paramx.GqL) {
          break label192;
        }
        label104:
        if (paramx != null)
        {
          localObject1 = getVideoPlayBehavior();
          if (localObject1 != null) {
            ((c.b)localObject1).e(paramx.feed.getExpectId(), paramx.EEv.ExE, (x)paramx.EEv);
          }
        }
      }
      paramx = com.tencent.mm.plugin.finder.report.s.Fqv;
      com.tencent.mm.plugin.finder.report.s.So(this.hJx);
      paramx = com.tencent.mm.plugin.finder.report.p.FpQ;
      paramx = this.GqA;
      if (paramx != null) {
        break label197;
      }
    }
    label192:
    label197:
    for (paramx = localObject2;; paramx = Long.valueOf(paramx.feed.getId()))
    {
      com.tencent.mm.plugin.finder.report.p.h(paramx);
      AppMethodBeat.o(335733);
      return;
      localObject1 = Integer.valueOf(localObject1.hashCode());
      break;
      paramx = null;
      break label104;
    }
  }
  
  public final void cq(float paramFloat)
  {
    int j = 1;
    AppMethodBeat.i(335823);
    Object localObject2 = getFTPPTag();
    Object localObject3 = new StringBuilder("[seekTo] percent=").append(paramFloat).append(" isSeekMode=").append(fjt()).append(" videoView=");
    Object localObject1 = this.Gqv;
    label93:
    boolean bool;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject3 = ((StringBuilder)localObject3).append(localObject1).append(" videoDurationSec=");
      localObject1 = this.Gqv;
      if (localObject1 != null) {
        break label404;
      }
      localObject1 = null;
      Log.i((String)localObject2, localObject1);
      localObject2 = this.Gqv;
      if (localObject2 != null)
      {
        int k = ((t)localObject2).getCurrentPlaySecond();
        localObject1 = getVideoView();
        if (localObject1 != null) {
          break label419;
        }
        i = 1;
        label142:
        paramFloat = androidx.core.b.a.g(i * paramFloat, 0.0F, i - 1.0F);
        if (Math.abs(k - paramFloat) > 1.0F)
        {
          double d = paramFloat;
          if (fjt()) {
            break label431;
          }
          bool = true;
          label183:
          if (((t)localObject2).a(d, bool, 2))
          {
            this.GqI = paramFloat;
            localObject3 = getFTPPTag();
            StringBuilder localStringBuilder = new StringBuilder("[seekTo] successfully seek to ").append(paramFloat).append(" videoDurationSec=");
            localObject1 = getVideoView();
            if (localObject1 != null) {
              break label437;
            }
            localObject1 = null;
            label244:
            Log.i((String)localObject3, localObject1);
          }
        }
        localObject1 = getPlayInfo();
        if (localObject1 != null)
        {
          if (!((b)localObject1).GqL) {
            break label452;
          }
          label278:
          if (localObject1 != null)
          {
            localObject3 = getVideoPlayBehavior();
            if (localObject3 != null) {
              ((c.b)localObject3).d(((b)localObject1).feed.getExpectId(), ((b)localObject1).EEv.ExE, k, (int)paramFloat, (x)((b)localObject1).EEv);
            }
            b(((b)localObject1).feed.getExpectId(), ((t)localObject2).getVideoMediaId(), k, (int)paramFloat);
          }
        }
      }
      localObject1 = this.GqA;
      if ((localObject1 == null) || (((b)localObject1).Gnn)) {
        break label458;
      }
    }
    label404:
    label419:
    label431:
    label437:
    label452:
    label458:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        uF(false);
      }
      AppMethodBeat.o(335823);
      return;
      localObject1 = Integer.valueOf(localObject1.hashCode());
      break;
      localObject1 = Integer.valueOf(((t)localObject1).getVideoDuration());
      break label93;
      i = ((t)localObject1).getVideoDuration();
      break label142;
      bool = false;
      break label183;
      localObject1 = Integer.valueOf(((t)localObject1).getVideoDuration());
      break label244;
      localObject1 = null;
      break label278;
    }
  }
  
  public final void d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168103);
    String str = getFTPPTag();
    StringBuilder localStringBuilder = new StringBuilder("[onError] videoView=");
    paramString1 = this.Gqv;
    if (paramString1 == null) {}
    for (paramString1 = null;; paramString1 = Integer.valueOf(paramString1.hashCode()))
    {
      Log.i(str, paramString1 + " mediaId=" + paramString2 + " errorMsg=" + paramString3 + " what=" + paramInt1 + " extra=" + paramInt2);
      paramString1 = this.GqB;
      if (paramString1 != null) {
        paramString1.setVisibility(8);
      }
      fjv();
      paramString1 = z.FrZ;
      z.SC(paramInt1);
      paramString1 = this.GqA;
      if (paramString1 != null)
      {
        paramString2 = getVideoPlayBehavior();
        if (paramString2 != null) {
          paramString2.a(paramString1.feed.getExpectId(), paramString1.EEv.ExE, paramInt1);
        }
      }
      AppMethodBeat.o(168103);
      return;
    }
  }
  
  public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168106);
    String str = getFTPPTag();
    StringBuilder localStringBuilder = new StringBuilder("[onGetVideoSize] videoView=");
    paramString1 = this.Gqv;
    if (paramString1 == null) {}
    for (paramString1 = null;; paramString1 = Integer.valueOf(paramString1.hashCode()))
    {
      Log.i(str, paramString1 + " mediaId=" + paramString2 + " width=" + paramInt1 + " height=" + paramInt2);
      AppMethodBeat.o(168106);
      return;
    }
  }
  
  public final void el(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(168104);
    paramString1 = this.Gqv;
    String str;
    StringBuilder localStringBuilder;
    t localt;
    if (paramString1 == null)
    {
      paramString1 = null;
      str = getFTPPTag();
      localStringBuilder = new StringBuilder("[onPrepared] videoView=");
      localt = this.Gqv;
      if (localt != null) {
        break label118;
      }
    }
    for (;;)
    {
      Log.i(str, localObject + " mediaId=" + paramString2 + " thumbVisible=" + getThumbView().getVisibility() + " duration=" + paramString1);
      AppMethodBeat.o(168104);
      return;
      paramString1 = Integer.valueOf(paramString1.getVideoDuration());
      break;
      label118:
      localObject = Integer.valueOf(localt.hashCode());
    }
  }
  
  public final void em(String paramString1, String paramString2)
  {
    AppMethodBeat.i(168105);
    String str = getFTPPTag();
    StringBuilder localStringBuilder = new StringBuilder("[onVideoEnded] videoView=");
    paramString1 = this.Gqv;
    if (paramString1 == null) {}
    for (paramString1 = null;; paramString1 = Integer.valueOf(paramString1.hashCode()))
    {
      Log.i(str, paramString1 + " mediaId=" + paramString2);
      AppMethodBeat.o(168105);
      return;
    }
  }
  
  public final void en(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(168107);
    Object localObject2 = getFTPPTag();
    StringBuilder localStringBuilder = new StringBuilder("[onVideoPause] videoView=");
    paramString1 = this.Gqv;
    if (paramString1 == null)
    {
      paramString1 = null;
      Log.i((String)localObject2, paramString1 + " mediaId=" + paramString2);
      dEE();
      paramString1 = com.tencent.mm.plugin.finder.report.p.FpQ;
      paramString1 = this.GqA;
      if (paramString1 != null) {
        break label188;
      }
      paramString1 = null;
      label81:
      if (paramString1 != null)
      {
        paramString1.longValue();
        localObject2 = com.tencent.mm.plugin.finder.report.p.pB(paramString1.longValue());
        if ((((com.tencent.mm.plugin.finder.report.p.a)localObject2).FpU <= 0L) || (((com.tencent.mm.plugin.finder.report.p.a)localObject2).FpY != 0L) || (((com.tencent.mm.plugin.finder.report.p.a)localObject2).FpV != 0L)) {
          break label202;
        }
      }
    }
    label188:
    label202:
    for (int i = 1;; i = 0)
    {
      paramString2 = localObject1;
      if (i != 0) {
        paramString2 = (String)localObject2;
      }
      if (paramString2 != null)
      {
        paramString2.FpV = cn.bDw();
        com.tencent.mm.plugin.finder.report.p.FpS.add(paramString2);
        com.tencent.mm.plugin.finder.report.p.FpR.remove(paramString1);
      }
      AppMethodBeat.o(168107);
      return;
      paramString1 = Integer.valueOf(paramString1.hashCode());
      break;
      paramString1 = Long.valueOf(paramString1.feed.getId());
      break label81;
    }
  }
  
  public final void eo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(168108);
    paramString1 = this.Gqv;
    int i;
    Object localObject1;
    Object localObject2;
    label47:
    label93:
    int j;
    if (paramString1 == null)
    {
      i = 0;
      localObject1 = getFTPPTag();
      localObject2 = new StringBuilder("[onVideoPlay] videoView=");
      paramString1 = this.Gqv;
      if (paramString1 != null) {
        break label391;
      }
      paramString1 = null;
      localObject2 = ((StringBuilder)localObject2).append(paramString1).append(" mediaId=").append(paramString2).append(" duration=").append(i).append(" isHasPlayed=");
      paramString1 = this.GqA;
      if (paramString1 != null) {
        break label402;
      }
      paramString1 = null;
      Log.i((String)localObject1, paramString1);
      paramString1 = this.GqA;
      if ((paramString1 == null) || (paramString1.GqM)) {
        break label413;
      }
      j = 1;
      label126:
      if ((j != 0) && (paramString2 != null))
      {
        paramString1 = this.Gqm;
        j = this.hJx;
        kotlin.g.b.s.u(paramString2, "mediaId");
        localObject1 = (l.a)paramString1.GLA.get(com.tencent.mm.plugin.finder.viewmodel.l.fc(paramString2, j));
        paramString1.GLA.remove(com.tencent.mm.plugin.finder.viewmodel.l.fc(paramString2, j));
        paramString2 = new StringBuilder("[getVideoProgress] mediaId=").append(paramString2).append(" tabType=").append(j).append(" progress=");
        if (localObject1 != null) {
          break label419;
        }
        paramString1 = null;
        paramString2 = paramString2.append(paramString1).append(" timestamp=");
        if (localObject1 != null) {
          break label431;
        }
        paramString1 = null;
        Log.i("Finder.VideoStateCacheVM", paramString1);
        if (localObject1 != null) {
          break label443;
        }
        paramString1 = null;
        if (paramString1 == null)
        {
          paramString1 = getVideoView();
          if (!(paramString1 instanceof FinderThumbPlayerProxy)) {
            break label705;
          }
          paramString1 = (FinderThumbPlayerProxy)paramString1;
          if (paramString1 != null) {
            paramString1.setPlaySpeed(1.0F);
          }
        }
      }
      label224:
      label243:
      paramString1 = this.GqA;
      label264:
      label285:
      if (paramString1 != null) {
        paramString1.GqM = true;
      }
      dEE();
      fjw();
      paramString1 = this.Gqv;
      if (paramString1 != null) {
        paramString1.setKeepScreenOn(true);
      }
      this.GqI = -1.0F;
      c(this);
      paramString1 = com.tencent.mm.plugin.finder.report.p.FpQ;
      paramString1 = this.GqA;
      if (paramString1 != null) {
        break label710;
      }
    }
    label391:
    label402:
    label413:
    label419:
    label431:
    label443:
    label705:
    label710:
    for (paramString1 = null;; paramString1 = Long.valueOf(paramString1.feed.getId()))
    {
      com.tencent.mm.plugin.finder.report.p.i(paramString1);
      paramString1 = com.tencent.mm.plugin.finder.report.s.Fqv;
      com.tencent.mm.plugin.finder.report.s.Sr(this.hJx);
      AppMethodBeat.o(168108);
      return;
      i = paramString1.getVideoDuration();
      break;
      paramString1 = Integer.valueOf(paramString1.hashCode());
      break label47;
      paramString1 = Boolean.valueOf(paramString1.GqM);
      break label93;
      j = 0;
      break label126;
      paramString1 = Integer.valueOf(((l.a)localObject1).progress);
      break label224;
      paramString1 = Double.valueOf(((l.a)localObject1).GLB);
      break label243;
      paramString2 = getVideoView();
      label472:
      boolean bool;
      if (paramString2 != null)
      {
        float f = ((l.a)localObject1).progress;
        paramString1 = this.GqB;
        if (paramString1 != null) {
          break label662;
        }
        j = 1;
        f = f * 1.0F / j;
        j = paramString2.getCurrentPlaySecond();
        f = androidx.core.b.a.g(f * i, 0.0F, i - 1.0F);
        paramString1 = this.GqB;
        if (paramString1 != null) {
          paramString1.setProgress(((l.a)localObject1).progress);
        }
        double d = f;
        if (fjt()) {
          break label673;
        }
        bool = true;
        paramString2.b(d, bool);
        paramString1 = getPlayInfo();
        if (paramString1 != null)
        {
          if (!paramString1.GqL) {
            break label679;
          }
          if (paramString1 != null)
          {
            localObject2 = getVideoPlayBehavior();
            if (localObject2 != null) {
              ((c.b)localObject2).d(paramString1.feed.getExpectId(), paramString1.EEv.ExE, j, (int)f, (x)paramString1.EEv);
            }
            b(paramString1.feed.getExpectId(), paramString2.getVideoMediaId(), j, (int)f);
          }
        }
      }
      paramString1 = getVideoView();
      if ((paramString1 instanceof FinderThumbPlayerProxy)) {}
      for (paramString1 = (FinderThumbPlayerProxy)paramString1;; paramString1 = null)
      {
        if (paramString1 != null) {
          break label689;
        }
        paramString1 = null;
        break;
        j = paramString1.getMaxProgress();
        break label472;
        bool = false;
        break label541;
        paramString1 = null;
        break label567;
      }
      paramString1.setPlaySpeed(((l.a)localObject1).GLC);
      paramString1 = ah.aiuX;
      break label264;
      paramString1 = null;
      break label285;
    }
  }
  
  public final void ep(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(168109);
    String str = getFTPPTag();
    StringBuilder localStringBuilder = new StringBuilder("[onVideoWaiting] videoView=");
    Object localObject1 = this.Gqv;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i(str, localObject1 + " mediaId=" + paramString2 + " thumbVisible=" + getThumbView().getVisibility());
      paramString2 = this.Gqv;
      if ((paramString2 == null) || (paramString2.getVideoViewFocused() != true)) {
        break label196;
      }
    }
    label196:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) || (paramString1 == null))
      {
        showLoading();
        paramString2 = this.GqA;
        if (paramString2 != null)
        {
          paramString1 = localObject2;
          if (paramString2.GqL) {
            paramString1 = paramString2;
          }
          if (paramString1 != null)
          {
            paramString2 = getVideoPlayBehavior();
            if (paramString2 != null) {
              paramString2.b(paramString1.feed.getExpectId(), paramString1.EEv.ExE, (x)paramString1.EEv);
            }
          }
        }
      }
      AppMethodBeat.o(168109);
      return;
      localObject1 = Integer.valueOf(localObject1.hashCode());
      break;
    }
  }
  
  public final void eq(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(168110);
    String str = getFTPPTag();
    StringBuilder localStringBuilder = new StringBuilder("[onVideoWaitingEnd] videoView=");
    paramString1 = this.Gqv;
    if (paramString1 == null) {}
    for (paramString1 = null;; paramString1 = Integer.valueOf(paramString1.hashCode()))
    {
      Log.i(str, paramString1 + " mediaId=" + paramString2);
      dEE();
      paramString2 = this.GqA;
      if (paramString2 != null)
      {
        paramString1 = localObject;
        if (paramString2.GqL) {
          paramString1 = paramString2;
        }
        if (paramString1 != null)
        {
          paramString2 = getVideoPlayBehavior();
          if (paramString2 != null) {
            paramString2.c(paramString1.feed.getExpectId(), paramString1.EEv.ExE, (x)paramString1.EEv);
          }
        }
      }
      AppMethodBeat.o(168110);
      return;
    }
  }
  
  public final boolean fjA()
  {
    b localb = this.GqA;
    return (localb != null) && (localb.GqL == true);
  }
  
  public final String fjx()
  {
    Object localObject2 = null;
    AppMethodBeat.i(168130);
    Object localObject3 = new StringBuilder("mediaId:");
    Object localObject1 = this.Gqv;
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(' ').append(hashCode()).append(':');
      localObject3 = this.Gqv;
      if (localObject3 == null) {
        break label124;
      }
      i = localObject3.hashCode();
      label72:
      localObject3 = ((StringBuilder)localObject1).append(i).append(" alpha=");
      localObject1 = this.Gqv;
      if (localObject1 != null) {
        break label129;
      }
    }
    label129:
    for (localObject1 = localObject2;; localObject1 = Float.valueOf(((t)localObject1).getAlpha()))
    {
      localObject1 = localObject1;
      AppMethodBeat.o(168130);
      return localObject1;
      localObject1 = ((t)localObject1).getVideoMediaId();
      break;
      label124:
      i = 0;
      break label72;
    }
  }
  
  public final boolean fjy()
  {
    AppMethodBeat.i(335808);
    t localt = this.Gqv;
    if (localt == null)
    {
      AppMethodBeat.o(335808);
      return false;
    }
    boolean bool = localt.isPlaying();
    AppMethodBeat.o(335808);
    return bool;
  }
  
  public final void fjz()
  {
    AppMethodBeat.i(335815);
    Object localObject = this.Gqv;
    if (localObject != null) {
      ((t)localObject).pause();
    }
    localObject = this.GqA;
    if ((localObject != null) && (!((b)localObject).Gnn)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        uF(true);
      }
      AppMethodBeat.o(335815);
      return;
    }
  }
  
  public final void gE(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(335717);
    String str = getFTPPTag();
    StringBuilder localStringBuilder = new StringBuilder("[onVideoFirstFrameDraw] videoView=");
    paramString1 = this.Gqv;
    if (paramString1 == null)
    {
      paramString1 = null;
      Log.i(str, paramString1 + " mediaId=" + paramString2);
      aCr("onVideoFirstFrameDraw");
      paramString1 = com.tencent.mm.plugin.finder.report.s.Fqv;
      com.tencent.mm.plugin.finder.report.s.Sp(this.hJx);
      paramString1 = com.tencent.mm.plugin.finder.report.p.FpQ;
      paramString1 = this.GqA;
      if (paramString1 != null) {
        break label195;
      }
      paramString1 = null;
      label95:
      if (paramString1 != null)
      {
        paramString1.longValue();
        paramString2 = com.tencent.mm.plugin.finder.report.p.pB(paramString1.longValue());
        if (((paramString2.FpW <= 0L) && (paramString2.FpU <= 0L)) || (paramString2.FpY != 0L)) {
          break label209;
        }
      }
    }
    label195:
    label209:
    for (int i = 1;; i = 0)
    {
      paramString1 = localObject;
      if (i != 0) {
        paramString1 = paramString2;
      }
      if (paramString1 != null)
      {
        paramString1.FpY = cn.bDw();
        com.tencent.mm.plugin.finder.report.p.FpS.add(paramString1);
        com.tencent.mm.plugin.finder.report.p.FpR.clear();
      }
      AppMethodBeat.o(335717);
      return;
      paramString1 = Integer.valueOf(paramString1.hashCode());
      break;
      paramString1 = Long.valueOf(paramString1.feed.getId());
      break label95;
    }
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(335855);
    Object localObject = this.Gqv;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label81;
      }
      localObject = getThumbView().getDrawable();
      if (!(localObject instanceof BitmapDrawable)) {
        break label63;
      }
    }
    label63:
    for (localObject = (BitmapDrawable)localObject;; localObject = null)
    {
      if (localObject != null) {
        break label68;
      }
      AppMethodBeat.o(335855);
      return null;
      localObject = ((t)localObject).getBitmap();
      break;
    }
    label68:
    localObject = ((BitmapDrawable)localObject).getBitmap();
    AppMethodBeat.o(335855);
    return localObject;
    label81:
    AppMethodBeat.o(335855);
    return localObject;
  }
  
  public final long getCurrentPosMs()
  {
    AppMethodBeat.i(335850);
    t localt = this.Gqv;
    if (localt == null)
    {
      AppMethodBeat.o(335850);
      return 0L;
    }
    long l = localt.getCurrentPlayMs();
    AppMethodBeat.o(335850);
    return l;
  }
  
  public final int getCurrentPosSec()
  {
    AppMethodBeat.i(335846);
    t localt = this.Gqv;
    if (localt == null)
    {
      AppMethodBeat.o(335846);
      return 0;
    }
    int i = localt.getCurrentPlaySecond();
    AppMethodBeat.o(335846);
    return i;
  }
  
  public final String getFTPPTag()
  {
    AppMethodBeat.i(335867);
    String str = String.valueOf(this.FkY);
    AppMethodBeat.o(335867);
    return str;
  }
  
  public final ab getLifecycle()
  {
    return this.Flu;
  }
  
  public final FinderLongVideoPlayerSeekBar getLongVideoSeekBar()
  {
    return this.GqC;
  }
  
  public final int getPlayAdapterPosition()
  {
    return this.GqF;
  }
  
  public final b getPlayInfo()
  {
    return this.GqA;
  }
  
  public final View getRetryBtn()
  {
    AppMethodBeat.i(168092);
    Object localObject = this.Gqx.getValue();
    kotlin.g.b.s.s(localObject, "<get-retryBtn>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(168092);
    return localObject;
  }
  
  public final m<Boolean, b, ah> getThumbShowCallback()
  {
    return this.GqE;
  }
  
  public final LinkedList<u> getVideoCallBackList()
  {
    AppMethodBeat.i(335365);
    LinkedList localLinkedList = (LinkedList)this.Gqq.getValue();
    AppMethodBeat.o(335365);
    return localLinkedList;
  }
  
  public final l getVideoCore()
  {
    AppMethodBeat.i(168088);
    l locall = this.AJn;
    if (locall != null)
    {
      AppMethodBeat.o(168088);
      return locall;
    }
    kotlin.g.b.s.bIx("videoCore");
    AppMethodBeat.o(168088);
    return null;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(335840);
    t localt = this.Gqv;
    if (localt == null)
    {
      AppMethodBeat.o(335840);
      return 0;
    }
    int i = localt.getVideoDuration();
    AppMethodBeat.o(335840);
    return i;
  }
  
  public final m<Boolean, b, ah> getVideoPauseCallback()
  {
    return this.GqD;
  }
  
  public final c.b getVideoPlayBehavior()
  {
    AppMethodBeat.i(168129);
    Object localObject = getVideoCore().Gqa;
    if (localObject == null)
    {
      AppMethodBeat.o(168129);
      return null;
    }
    localObject = (c.b)new c.c((com.tencent.mm.plugin.finder.event.c)localObject);
    AppMethodBeat.o(168129);
    return localObject;
  }
  
  public final t getVideoView()
  {
    return this.Gqv;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(335585);
    super.onAttachedToWindow();
    String str = getFTPPTag();
    Object localObject = this.GqA;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((b)localObject).mediaId)
    {
      Log.i(str, kotlin.g.b.s.X("onAttachedToWindow ", localObject));
      getVideoCore().fjp().a(this.EEW);
      AppMethodBeat.o(335585);
      return;
    }
  }
  
  protected final void onDetachedFromWindow()
  {
    boolean bool = false;
    AppMethodBeat.i(168099);
    super.onDetachedFromWindow();
    Object localObject2 = getFTPPTag();
    Object localObject1 = this.GqA;
    Object localObject3;
    int j;
    s locals;
    int i;
    label99:
    int k;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i((String)localObject2, kotlin.g.b.s.X("[onDetachedFromWindow] ", localObject1));
      localObject1 = this.Gqv;
      if (localObject1 != null)
      {
        localObject2 = this.Gqm;
        localObject3 = getPlayInfo();
        kotlin.g.b.s.checkNotNull(localObject3);
        localObject3 = ((b)localObject3).mediaId;
        j = this.hJx;
        locals = this.GqB;
        if (locals != null) {
          break label213;
        }
        i = 0;
        k = ((t)localObject1).getCurrentPlaySecond();
        localObject1 = getVideoView();
        if (!(localObject1 instanceof FinderThumbPlayerProxy)) {
          break label224;
        }
        localObject1 = (FinderThumbPlayerProxy)localObject1;
        label129:
        if (localObject1 != null) {
          break label230;
        }
      }
    }
    label213:
    label224:
    label230:
    for (float f = 1.0F;; f = ((FinderThumbPlayerProxy)localObject1).getPlaySpeedRatio())
    {
      ((com.tencent.mm.plugin.finder.viewmodel.l)localObject2).a((String)localObject3, j, i, k, f);
      if (!this.Gqo) {
        bool = true;
      }
      pause(bool);
      localObject1 = this.AWf;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.feed.d)localObject1).onDetach();
      }
      getVideoCore().fjp().b(this.EEW);
      AppMethodBeat.o(168099);
      return;
      localObject1 = ((b)localObject1).mediaId;
      break;
      i = locals.getCurrentProgress();
      break label99;
      localObject1 = null;
      break label129;
    }
  }
  
  public final void onSeekComplete(ITPPlayer paramITPPlayer) {}
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(168101);
    kotlin.g.b.s.u(paramView, "child");
    super.onViewAdded(paramView);
    if ((paramView instanceof t))
    {
      Log.i(getFTPPTag(), "[onViewAdded] isPreviewing=" + ((t)paramView).boa() + ' ' + fjx());
      if (((t)paramView).boa()) {
        setVisibility(0);
      }
    }
    AppMethodBeat.o(168101);
  }
  
  public final void onViewRemoved(View paramView)
  {
    int k = 0;
    AppMethodBeat.i(168102);
    kotlin.g.b.s.u(paramView, "child");
    super.onViewRemoved(paramView);
    Object localObject;
    if ((kotlin.g.b.s.p(paramView, this.Gqv)) && ((paramView instanceof t)))
    {
      Log.i(getFTPPTag(), "[onViewRemoved] isPreviewing=" + ((t)paramView).boa() + ' ' + fjx());
      localObject = this.GqB;
      if (localObject != null) {
        ((s)localObject).fiE();
      }
      localObject = this.GqA;
      int i;
      com.tencent.mm.plugin.finder.viewmodel.l locall;
      String str;
      label164:
      int j;
      label178:
      label199:
      label206:
      int m;
      if ((localObject != null) && (((b)localObject).Gnn == true))
      {
        i = 1;
        if (i != 0)
        {
          locall = this.Gqm;
          localObject = this.GqA;
          kotlin.g.b.s.checkNotNull(localObject);
          str = ((b)localObject).mediaId;
          localObject = this.GqB;
          if (localObject != null) {
            break label345;
          }
          i = 0;
          localObject = this.Gqv;
          if (localObject != null) {
            break label356;
          }
          j = 0;
          localObject = this.Gqv;
          if (!(localObject instanceof FinderThumbPlayerProxy)) {
            break label368;
          }
          localObject = (FinderThumbPlayerProxy)localObject;
          if (localObject != null) {
            break label374;
          }
          f = 1.0F;
          locall.a(str, i, j, f);
        }
        locall = this.Gqm;
        localObject = this.GqA;
        kotlin.g.b.s.checkNotNull(localObject);
        str = ((b)localObject).mediaId;
        m = this.hJx;
        localObject = this.GqB;
        if (localObject != null) {
          break label383;
        }
        i = 0;
        label260:
        localObject = this.Gqv;
        if (localObject != null) {
          break label394;
        }
        j = k;
        label275:
        localObject = this.Gqv;
        if (!(localObject instanceof FinderThumbPlayerProxy)) {
          break label406;
        }
        localObject = (FinderThumbPlayerProxy)localObject;
        label296:
        if (localObject != null) {
          break label412;
        }
      }
      label394:
      label406:
      label412:
      for (float f = 1.0F;; f = ((FinderThumbPlayerProxy)localObject).getPlaySpeedRatio())
      {
        locall.a(str, m, i, j, f);
        if (!((t)paramView).boa()) {
          break label421;
        }
        setVisibility(4);
        AppMethodBeat.o(168102);
        return;
        i = 0;
        break;
        label345:
        i = ((s)localObject).getCurrentProgress();
        break label164;
        label356:
        j = ((t)localObject).getCurrentPlaySecond();
        break label178;
        label368:
        localObject = null;
        break label199;
        label374:
        f = ((FinderThumbPlayerProxy)localObject).getPlaySpeedRatio();
        break label206;
        label383:
        i = ((s)localObject).getCurrentProgress();
        break label260;
        j = ((t)localObject).getCurrentPlaySecond();
        break label275;
        localObject = null;
        break label296;
      }
      label421:
      localObject = getFTPPTag();
      paramView = this.GqA;
      if (paramView != null) {
        break label470;
      }
    }
    label470:
    for (paramView = null;; paramView = paramView.mediaId)
    {
      Log.i((String)localObject, kotlin.g.b.s.X("[videoView = null] mediaId=", paramView));
      fju();
      dEE();
      this.Gqv = null;
      AppMethodBeat.o(168102);
      return;
    }
  }
  
  public final void pause(boolean paramBoolean)
  {
    AppMethodBeat.i(168097);
    Object localObject1 = this.GqA;
    if ((localObject1 != null) && (!((b)localObject1).GqL)) {}
    for (int i = 1; (i != 0) && (!paramBoolean); i = 0)
    {
      AppMethodBeat.o(168097);
      return;
    }
    Object localObject2 = getFTPPTag();
    Object localObject3 = new StringBuilder("[FinderVideoLayout#pause] ").append(fjx()).append(" isForceRemoveVideoView=").append(paramBoolean).append(" isSeekMode=");
    localObject1 = this.GqA;
    label131:
    boolean bool;
    label159:
    long l;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject3 = ((StringBuilder)localObject3).append(localObject1).append(" media=");
      localObject1 = this.GqA;
      if (localObject1 != null) {
        break label429;
      }
      localObject1 = null;
      Log.i((String)localObject2, localObject1);
      localObject1 = this.GqA;
      if (localObject1 != null) {
        break label439;
      }
      bool = false;
      getVideoCore().fjp().a((ViewGroup)this, paramBoolean, bool);
      dEE();
      localObject1 = this.AWe;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.feed.e)localObject1).reset();
      }
      localObject1 = this.GqA;
      if (localObject1 != null) {
        ((b)localObject1).GqL = false;
      }
      this.GqJ = -1;
      localObject1 = this.GqA;
      if (localObject1 != null)
      {
        localObject1 = ((b)localObject1).feed;
        localObject2 = new ib();
        localObject3 = ((ib)localObject2).hJu;
        if (((FeedData)localObject1).getLocalId() == 0L) {
          break label448;
        }
        l = ((FeedData)localObject1).getLocalId();
        label270:
        ((ib.a)localObject3).feedId = l;
        localObject3 = ((ib)localObject2).hJu;
        if (((FeedData)localObject1).getLocalId() == 0L) {
          break label458;
        }
      }
    }
    label429:
    label439:
    label448:
    label458:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((ib.a)localObject3).hJv = paramBoolean;
      ((ib)localObject2).hJu.hJi = true;
      ((ib)localObject2).hJu.hJx = this.hJx;
      ((ib)localObject2).publish();
      localObject1 = this.GqA;
      if ((localObject1 != null) && (((b)localObject1).EEv.ExE.mediaType == 9))
      {
        localObject2 = getVideoPlayBehavior();
        if (localObject2 != null) {
          ((c.b)localObject2).a(((b)localObject1).feed.getExpectId(), ((b)localObject1).EEv.ExE, ((b)localObject1).mediaList, (x)((b)localObject1).EEv, null);
        }
      }
      setKeepScreenOn(false);
      AppMethodBeat.o(168097);
      return;
      localObject1 = Boolean.valueOf(((b)localObject1).Gnn);
      break;
      localObject1 = ((b)localObject1).mediaId;
      break label131;
      bool = ((b)localObject1).Gnn;
      break label159;
      l = ((FeedData)localObject1).getFeedId();
      break label270;
    }
  }
  
  public final void setEnablePlay(boolean paramBoolean)
  {
    this.GqG = paramBoolean;
  }
  
  public final void setEnableShowLoading(boolean paramBoolean)
  {
    this.Gql = paramBoolean;
  }
  
  public final void setLongVideo(boolean paramBoolean)
  {
    this.isLongVideo = paramBoolean;
  }
  
  public final void setLongVideoSeekBar(FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar)
  {
    this.GqC = paramFinderLongVideoPlayerSeekBar;
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.lAj = paramBoolean;
  }
  
  public final void setPlayAdapterPosition(int paramInt)
  {
    this.GqF = paramInt;
  }
  
  public final void setPlayInfo(b paramb)
  {
    this.GqA = paramb;
  }
  
  public final void setPreRenderFirstFrame(boolean paramBoolean)
  {
    this.Gqz = paramBoolean;
  }
  
  public final void setSelectedToPlay(boolean paramBoolean)
  {
    this.Gqp = paramBoolean;
  }
  
  public final void setThumbShowCallback(m<? super Boolean, ? super b, ah> paramm)
  {
    this.GqE = paramm;
  }
  
  public final void setVideoCore(l paraml)
  {
    AppMethodBeat.i(168089);
    kotlin.g.b.s.u(paraml, "<set-?>");
    this.AJn = paraml;
    AppMethodBeat.o(168089);
  }
  
  public final void setVideoPauseCallback(m<? super Boolean, ? super b, ah> paramm)
  {
    this.GqD = paramm;
  }
  
  public final void setVideoView(t paramt)
  {
    this.Gqv = paramt;
  }
  
  public final void uF(boolean paramBoolean)
  {
    Object localObject1 = null;
    AppMethodBeat.i(335777);
    Object localObject2 = this.GqD;
    if (localObject2 != null) {
      ((m)localObject2).invoke(Boolean.valueOf(paramBoolean), this.GqA);
    }
    if (paramBoolean)
    {
      paramBoolean = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adee, true);
      getBulletSubtitleButton().setSelected(paramBoolean);
      if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())
      {
        findViewById(e.e.video_bullet_divider).setVisibility(8);
        ((TextView)findViewById(e.e.video_bullet_subtitle_button)).setVisibility(8);
      }
      if (this.AWf != null)
      {
        getBottomButtonLayout().setVisibility(0);
        localObject2 = this.AWe;
        if (localObject2 != null) {
          break label149;
        }
      }
      for (;;)
      {
        if (localObject1 != null) {
          ((WxRecyclerView)localObject1).setAlpha(0.3F);
        }
        this.Gqk = true;
        AppMethodBeat.o(335777);
        return;
        label149:
        localObject1 = ((com.tencent.mm.plugin.finder.feed.e)localObject2).ebQ();
      }
    }
    if (this.AWf != null)
    {
      getBottomButtonLayout().setVisibility(8);
      localObject1 = this.AWe;
      if (localObject1 != null) {
        break label205;
      }
    }
    label205:
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.finder.feed.e)localObject1).ebQ())
    {
      if (localObject1 != null) {
        ((WxRecyclerView)localObject1).setAlpha(1.0F);
      }
      this.Gqk = false;
      AppMethodBeat.o(335777);
      return;
    }
  }
  
  public final void uG(boolean paramBoolean)
  {
    b localb = null;
    boolean bool2 = true;
    AppMethodBeat.i(335803);
    Object localObject2 = getFTPPTag();
    Object localObject3 = new StringBuilder("onEnterSeekMode mediaId=");
    Object localObject1 = this.GqA;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((b)localObject1).mediaId)
    {
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(" isPaused:");
      localObject3 = getContext();
      if (localObject3 != null) {
        break;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(335803);
      throw ((Throwable)localObject1);
    }
    Log.i((String)localObject2, ((MMActivity)localObject3).isPaused() + " isSelectedToPlay:" + this.Gqp);
    localObject1 = this.GqA;
    if (localObject1 != null) {
      ((b)localObject1).Gnn = paramBoolean;
    }
    if (paramBoolean)
    {
      localObject1 = this.GqA;
      if (localObject1 != null)
      {
        localObject2 = getVideoPlayBehavior();
        if (localObject2 != null) {
          ((c.b)localObject2).a(((b)localObject1).feed.getExpectId(), ((b)localObject1).EEv.ExE, (x)((b)localObject1).EEv);
        }
      }
      uF(true);
      localObject1 = this.Gqv;
      if (localObject1 != null) {
        ((t)localObject1).setVideoViewFocused(false);
      }
      localObject1 = this.Gqv;
      if (localObject1 != null) {
        ((t)localObject1).pause();
      }
      if (!paramBoolean) {
        this.Gqm.fmP();
      }
      localObject2 = getFTPPTag();
      localObject3 = new StringBuilder("[onEnterSeekMode] isEnter=").append(paramBoolean).append(" alpha=");
      localObject1 = this.Gqv;
      if (localObject1 != null) {
        break label554;
      }
    }
    label424:
    label554:
    for (localObject1 = localb;; localObject1 = Float.valueOf(((t)localObject1).getAlpha()))
    {
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(" mediaId=");
      localb = this.GqA;
      kotlin.g.b.s.checkNotNull(localb);
      Log.i((String)localObject2, localb.mediaId);
      AppMethodBeat.o(335803);
      return;
      uF(false);
      localObject2 = this.Gqv;
      if (localObject2 == null) {
        break;
      }
      localObject1 = getContext();
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(335803);
        throw ((Throwable)localObject1);
      }
      if ((!((MMActivity)localObject1).isPaused()) && (this.Gqp))
      {
        bool1 = true;
        ((t)localObject2).setVideoViewFocused(bool1);
        localObject1 = getPlayInfo();
        if (localObject1 != null) {
          break label488;
        }
      }
      label467:
      label488:
      for (localObject1 = "";; localObject1 = ((b)localObject1).mediaId)
      {
        if (this.Gqm.fb((String)localObject1, this.hJx) != null) {
          break label498;
        }
        localObject1 = null;
        if (localObject1 != null) {
          break label532;
        }
        ((t)localObject2).bNU();
        break;
        bool1 = false;
        break label424;
      }
      label498:
      a(this, 0, 3);
      if (com.tencent.mm.n.a.aTj())
      {
        bool1 = true;
        if (!bool1) {
          break label542;
        }
      }
      for (boolean bool1 = bool2;; bool1 = l.fjs())
      {
        ((t)localObject2).setMute(bool1);
        localObject1 = ah.aiuX;
        break label467;
        break;
        bool1 = this.lAj;
        break label512;
        getVideoCore();
      }
    }
  }
  
  public final void uH(boolean paramBoolean)
  {
    AppMethodBeat.i(335864);
    if (paramBoolean)
    {
      a(this, 0, 3);
      AppMethodBeat.o(335864);
      return;
    }
    pause(false);
    AppMethodBeat.o(335864);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "", "feed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "mediaId", "", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "position", "", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "isLocal", "", "isFocusPlaying", "isSeekMode", "isHasPlayed", "cropInfo", "Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "(Lcom/tencent/mm/plugin/finder/storage/FeedData;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;ILjava/util/LinkedList;ZZZZLcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;)V", "getCropInfo", "()Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;", "setCropInfo", "(Lcom/tencent/mm/protocal/protobuf/LocalVideoCropInfo;)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FeedData;", "()Z", "setFocusPlaying", "(Z)V", "setHasPlayed", "setSeekMode", "getMedia", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "getMediaId", "()Ljava/lang/String;", "getMediaList", "()Ljava/util/LinkedList;", "getPosition", "()I", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    dju EDC;
    public final com.tencent.mm.plugin.finder.loader.v EEv;
    public boolean Gnn;
    public boolean GqL;
    boolean GqM;
    public final FeedData feed;
    public final boolean hJv;
    public final String mediaId;
    public final LinkedList<dji> mediaList;
    public final int position;
    
    private b(FeedData paramFeedData, String paramString, com.tencent.mm.plugin.finder.loader.v paramv, int paramInt, LinkedList<dji> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2, dju paramdju)
    {
      AppMethodBeat.i(335240);
      this.feed = paramFeedData;
      this.mediaId = paramString;
      this.EEv = paramv;
      this.position = paramInt;
      this.mediaList = paramLinkedList;
      this.hJv = paramBoolean1;
      this.GqL = paramBoolean2;
      this.Gnn = false;
      this.GqM = false;
      this.EDC = paramdju;
      AppMethodBeat.o(335240);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(168056);
      if (this == paramObject)
      {
        AppMethodBeat.o(168056);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(168056);
        return false;
      }
      paramObject = (b)paramObject;
      if (!kotlin.g.b.s.p(this.feed, paramObject.feed))
      {
        AppMethodBeat.o(168056);
        return false;
      }
      if (!kotlin.g.b.s.p(this.mediaId, paramObject.mediaId))
      {
        AppMethodBeat.o(168056);
        return false;
      }
      if (!kotlin.g.b.s.p(this.EEv, paramObject.EEv))
      {
        AppMethodBeat.o(168056);
        return false;
      }
      if (this.position != paramObject.position)
      {
        AppMethodBeat.o(168056);
        return false;
      }
      if (!kotlin.g.b.s.p(this.mediaList, paramObject.mediaList))
      {
        AppMethodBeat.o(168056);
        return false;
      }
      if (this.hJv != paramObject.hJv)
      {
        AppMethodBeat.o(168056);
        return false;
      }
      if (this.GqL != paramObject.GqL)
      {
        AppMethodBeat.o(168056);
        return false;
      }
      if (this.Gnn != paramObject.Gnn)
      {
        AppMethodBeat.o(168056);
        return false;
      }
      if (this.GqM != paramObject.GqM)
      {
        AppMethodBeat.o(168056);
        return false;
      }
      if (!kotlin.g.b.s.p(this.EDC, paramObject.EDC))
      {
        AppMethodBeat.o(168056);
        return false;
      }
      AppMethodBeat.o(168056);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(168054);
      String str = "PlayInfo(feed=" + this.feed + ", mediaId=" + this.mediaId + ", media=" + this.EEv + ", position=" + this.position + ", mediaList=" + this.mediaList + ", isLocal=" + this.hJv + ", isFocusPlaying=" + this.GqL + ", isSeekMode=" + this.Gnn + ", isHasPlayed=" + this.GqM + ", cropInfo=" + this.EDC + ')';
      AppMethodBeat.o(168054);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderVideoLayout$initLongVideoSeekBar$1$2", "Lcom/tencent/mm/plugin/sight/decode/ui/IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "onSeeking", "currentTime", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements com.tencent.mm.plugin.sight.decode.ui.b
  {
    f(FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar, FinderVideoLayout paramFinderVideoLayout) {}
    
    public final void blc()
    {
      AppMethodBeat.i(335145);
      jdField_this.uH(false);
      this.GqO.setIsPlay(false);
      kotlin.g.a.a locala = this.GqO.getOnSeekStart();
      if (locala != null) {
        locala.invoke();
      }
      AppMethodBeat.o(335145);
    }
    
    public final void tS(int paramInt)
    {
      int j = 0;
      AppMethodBeat.i(335135);
      Object localObject1 = jdField_this.getVideoView();
      if (localObject1 != null) {
        ((t)localObject1).b(paramInt, true);
      }
      FinderVideoLayout.a(jdField_this, 0, 3);
      this.GqO.setIsPlay(true);
      localObject1 = this.GqO.getOnSeekEnd();
      if (localObject1 != null) {
        ((kotlin.g.a.a)localObject1).invoke();
      }
      localObject1 = jdField_this.getPlayInfo();
      Object localObject2;
      long l;
      t localt;
      if (localObject1 != null)
      {
        if (!((FinderVideoLayout.b)localObject1).GqL) {
          break label225;
        }
        if (localObject1 != null)
        {
          localObject2 = jdField_this;
          c.b localb = ((FinderVideoLayout)localObject2).getVideoPlayBehavior();
          if (localb != null)
          {
            l = ((FinderVideoLayout.b)localObject1).feed.getExpectId();
            dji localdji = ((FinderVideoLayout.b)localObject1).EEv.ExE;
            localt = ((FinderVideoLayout)localObject2).getVideoView();
            if (localt != null) {
              break label231;
            }
            i = 0;
            label150:
            localb.d(l, localdji, i, paramInt, (x)((FinderVideoLayout.b)localObject1).EEv);
          }
          l = ((FinderVideoLayout.b)localObject1).feed.getExpectId();
          localObject1 = ((FinderVideoLayout)localObject2).getVideoView();
          if (localObject1 != null) {
            break label242;
          }
          localObject1 = null;
          label196:
          localObject2 = ((FinderVideoLayout)localObject2).getVideoView();
          if (localObject2 != null) {
            break label254;
          }
        }
      }
      label225:
      label231:
      label242:
      label254:
      for (int i = j;; i = ((t)localObject2).getCurrentPlaySecond())
      {
        FinderVideoLayout.b(l, (String)localObject1, i, paramInt);
        AppMethodBeat.o(335135);
        return;
        localObject1 = null;
        break;
        i = localt.getCurrentPlaySecond();
        break label150;
        localObject1 = ((t)localObject1).getVideoMediaId();
        break label196;
      }
    }
    
    public final void tT(int paramInt) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderVideoLayout$lifecycle$1", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "onBeforePlay", "", "info", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "mediaSource", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "bgPreparedStatus", "", "onBgPrepared", "onFirstFrameUpdate", "prepareCostTime", "", "onFirstVideoFrameRendered", "videoTrace", "Lcom/tencent/mm/plugin/findersdk/trace/FinderVideoPlayTrace;", "onPause", "onStopPlayData", "Lcom/tencent/mm/plugin/finder/video/reporter/OnStopPlayData;", "onPlay", "onPlayProgress", "offset", "total", "onPlayProgressMs", "offsetMs", "totalMs", "onPlayerConfigChange", "playerConfig", "Lcom/tencent/mm/plugin/finder/video/reporter/PlayerConfig;", "onReplay", "onStopPlay", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements ab
  {
    g(FinderVideoLayout paramFinderVideoLayout) {}
    
    public final void a(com.tencent.mm.plugin.finder.video.reporter.d paramd)
    {
      AppMethodBeat.i(335196);
      FinderVideoLayout.b localb = this.GqN.getPlayInfo();
      if (localb != null)
      {
        FinderVideoLayout localFinderVideoLayout = this.GqN;
        c.b localb1 = localFinderVideoLayout.getVideoPlayBehavior();
        if (localb1 != null) {
          localb1.a(localb.feed.getExpectId(), localb.EEv.ExE, localb.mediaList, (x)localb.EEv, paramd);
        }
        paramd = ((Iterable)FinderVideoLayout.n(localFinderVideoLayout)).iterator();
        while (paramd.hasNext()) {
          ((u)paramd.next()).onVideoPause();
        }
      }
      AppMethodBeat.o(335196);
    }
    
    public final void a(com.tencent.mm.plugin.finder.video.reporter.e parame)
    {
      AppMethodBeat.i(335211);
      FinderVideoLayout.b localb = this.GqN.getPlayInfo();
      if (localb != null)
      {
        c.b localb1 = this.GqN.getVideoPlayBehavior();
        if (localb1 != null) {
          localb1.a(localb.feed.getExpectId(), localb.EEv.ExE, localb.mediaList, (x)localb.EEv, parame);
        }
      }
      AppMethodBeat.o(335211);
    }
    
    public final void a(v paramv, int paramInt)
    {
      AppMethodBeat.i(335168);
      FinderVideoLayout.b localb = this.GqN.getPlayInfo();
      if (localb != null)
      {
        FinderVideoLayout localFinderVideoLayout = this.GqN;
        c.b localb1 = localFinderVideoLayout.getVideoPlayBehavior();
        if (localb1 != null) {
          localb1.a(localb.feed.getId(), localb.EEv.ExE, paramv, localFinderVideoLayout.getPlayAdapterPosition(), (x)localb.EEv, paramInt);
        }
      }
      AppMethodBeat.o(335168);
    }
    
    public final void a(v paramv, com.tencent.mm.plugin.finder.video.reporter.d paramd)
    {
      AppMethodBeat.i(335162);
      if (paramv != null)
      {
        Object localObject1 = this.GqN;
        Object localObject2 = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
        localObject2 = com.tencent.mm.plugin.finder.storage.logic.e.aAN(paramv.mediaId);
        if (!((az)localObject2).field_hasPlayed)
        {
          ((az)localObject2).field_hasPlayed = true;
          com.tencent.mm.ae.d.B((kotlin.g.a.a)new a((az)localObject2));
        }
        localObject1 = ((FinderVideoLayout)localObject1).getVideoPlayBehavior();
        if (localObject1 != null) {
          ((c.b)localObject1).a(paramv.AWA.getId(), paramv.Grz, paramv.ANK, paramd);
        }
      }
      AppMethodBeat.o(335162);
    }
    
    public final void a(com.tencent.mm.plugin.findersdk.f.a parama)
    {
      Object localObject2 = null;
      AppMethodBeat.i(335189);
      FinderVideoLayout.b localb = this.GqN.getPlayInfo();
      FinderVideoLayout localFinderVideoLayout;
      Object localObject1;
      Object localObject3;
      if (localb != null)
      {
        localFinderVideoLayout = this.GqN;
        localObject1 = ax.Fur;
        localObject3 = localb.EEv.ExE.mediaId;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        ax.aAb((String)localObject1);
        localObject3 = localb.mediaId;
        String str = localFinderVideoLayout.getFTPPTag();
        StringBuilder localStringBuilder = new StringBuilder("[onFirstVideoFrameRendered] videoView=");
        localObject1 = localFinderVideoLayout.Gqv;
        if (localObject1 != null) {
          break label271;
        }
        localObject1 = null;
        Log.i(str, localObject1 + " mediaId=" + localObject3);
        localObject1 = com.tencent.mm.plugin.finder.report.p.FpQ;
        localObject1 = localFinderVideoLayout.GqA;
        if (localObject1 != null) {
          break label282;
        }
        localObject1 = null;
        label137:
        if (localObject1 != null)
        {
          ((Long)localObject1).longValue();
          localObject3 = com.tencent.mm.plugin.finder.report.p.pB(((Long)localObject1).longValue());
          if (((((com.tencent.mm.plugin.finder.report.p.a)localObject3).FpW <= 0L) && (((com.tencent.mm.plugin.finder.report.p.a)localObject3).FpU <= 0L)) || (((com.tencent.mm.plugin.finder.report.p.a)localObject3).FpZ != 0L)) {
            break label296;
          }
        }
      }
      label271:
      label282:
      label296:
      for (int i = 1;; i = 0)
      {
        localObject1 = localObject2;
        if (i != 0) {
          localObject1 = localObject3;
        }
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.finder.report.p.a)localObject1).FpZ = cn.bDw();
          com.tencent.mm.plugin.finder.report.p.FpS.add(localObject1);
          com.tencent.mm.plugin.finder.report.p.FpR.clear();
        }
        localObject1 = localFinderVideoLayout.getVideoPlayBehavior();
        if (localObject1 != null) {
          ((c.b)localObject1).a(localb.feed.getExpectId(), localb.EEv.ExE, (x)localb.EEv, parama);
        }
        AppMethodBeat.o(335189);
        return;
        localObject1 = Integer.valueOf(localObject1.hashCode());
        break;
        localObject1 = Long.valueOf(((FinderVideoLayout.b)localObject1).feed.getId());
        break label137;
      }
    }
    
    public final void a(dji paramdji)
    {
      AppMethodBeat.i(335152);
      this.GqN.setPreRenderFirstFrame(true);
      FinderVideoLayout.a(this.GqN, "onBgPrepared");
      String str2 = FinderVideoLayout.j(this.GqN);
      if (paramdji == null) {
        paramdji = "";
      }
      for (;;)
      {
        Log.i(str2, kotlin.g.b.s.X("onBgPrepared ", paramdji));
        AppMethodBeat.o(335152);
        return;
        String str1 = paramdji.mediaId;
        paramdji = str1;
        if (str1 == null) {
          paramdji = "";
        }
      }
    }
    
    public final void a(dji paramdji, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(335225);
      FinderVideoLayout.b localb = this.GqN.getPlayInfo();
      FinderVideoLayout localFinderVideoLayout;
      Object localObject;
      int i;
      label116:
      boolean bool;
      label386:
      if (localb != null)
      {
        localFinderVideoLayout = this.GqN;
        localObject = localFinderVideoLayout.getVideoView();
        if (localObject != null) {
          break label455;
        }
        i = 0;
        localObject = localFinderVideoLayout.getVideoPlayBehavior();
        if (localObject != null) {
          ((c.b)localObject).a(localb.feed.getExpectId(), localb.EEv.ExE, paramInt1, paramInt2, (x)localb.EEv);
        }
        if (paramInt1 >= 20)
        {
          localObject = FinderVideoLayout.d(localFinderVideoLayout);
          if ((localObject == null) || (((s)localObject).fiF())) {
            break label467;
          }
          paramInt1 = 1;
          if (paramInt1 != 0)
          {
            localObject = FinderVideoLayout.d(localFinderVideoLayout);
            if (localObject != null) {
              ((s)localObject).ux(false);
            }
          }
        }
        localObject = localb.EDC;
        if (localObject != null)
        {
          if ((((dju)localObject).endTime <= 0) || (((dju)localObject).startTime < 0) || (((dju)localObject).endTime <= ((dju)localObject).startTime)) {
            break label472;
          }
          paramInt1 = 1;
          label183:
          if (paramInt1 == 0) {
            break label477;
          }
          label187:
          if ((localObject != null) && (i >= ((dju)localObject).endTime / 1000))
          {
            localObject = localFinderVideoLayout.getVideoView();
            if (!(localObject instanceof FinderCropVideoView)) {
              break label483;
            }
            localObject = (FinderCropVideoView)localObject;
            label228:
            if (localObject != null)
            {
              localObject = ((FinderCropVideoView)localObject).wCd;
              if (localObject != null) {
                ((i)localObject).c(0.0D, true);
              }
            }
            localObject = new ib();
            ((ib)localObject).hJu.hJv = true;
            ((ib)localObject).hJu.feedId = localb.feed.getLocalId();
            ((ib)localObject).hJu.hJw = true;
            ((ib)localObject).hJu.hJx = FinderVideoLayout.o(localFinderVideoLayout);
            ((ib)localObject).publish();
          }
        }
        if ((paramdji == null) || (paramdji.aaPc != 3)) {
          break label489;
        }
        paramInt1 = 1;
        label330:
        if (paramInt1 == 0)
        {
          paramdji = com.tencent.mm.plugin.finder.storage.d.FAy;
          paramInt1 = com.tencent.mm.plugin.finder.storage.d.eRl();
          paramdji = com.tencent.mm.plugin.finder.storage.d.FAy;
          if (i == paramInt1 - com.tencent.mm.plugin.finder.storage.d.eRk())
          {
            paramdji = new ib();
            localObject = paramdji.hJu;
            if (localb.feed.getLocalId() == 0L) {
              break label494;
            }
            bool = true;
            ((ib.a)localObject).hJv = bool;
            localObject = paramdji.hJu;
            if (!paramdji.hJu.hJv) {
              break label500;
            }
          }
        }
      }
      label455:
      label467:
      label472:
      label477:
      label483:
      label489:
      label494:
      label500:
      for (long l = localb.feed.getLocalId();; l = localb.feed.getFeedId())
      {
        ((ib.a)localObject).feedId = l;
        paramdji.hJu.hJx = FinderVideoLayout.o(localFinderVideoLayout);
        paramdji.publish();
        FinderVideoLayout.c(localFinderVideoLayout);
        AppMethodBeat.o(335225);
        return;
        i = ((t)localObject).getCurrentPlaySecond();
        break;
        paramInt1 = 0;
        break label116;
        paramInt1 = 0;
        break label183;
        localObject = null;
        break label187;
        localObject = null;
        break label228;
        paramInt1 = 0;
        break label330;
        bool = false;
        break label386;
      }
    }
    
    public final void ar(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(335228);
      if (this.GqN.getPlayInfo() != null) {
        FinderVideoLayout.a(this.GqN, paramLong1, paramLong2);
      }
      AppMethodBeat.o(335228);
    }
    
    public final void eCP()
    {
      AppMethodBeat.i(168063);
      FinderVideoLayout.b localb = this.GqN.getPlayInfo();
      if (localb != null)
      {
        FinderVideoLayout localFinderVideoLayout = this.GqN;
        Object localObject = localFinderVideoLayout.getVideoPlayBehavior();
        if (localObject != null) {
          ((c.b)localObject).d(localb.feed.getExpectId(), localb.EEv.ExE, (x)localb.EEv);
        }
        localObject = new ib();
        ((ib)localObject).hJu.feedId = localb.feed.getExpectId();
        ((ib)localObject).hJu.hJw = true;
        ((ib)localObject).hJu.hJx = FinderVideoLayout.o(localFinderVideoLayout);
        ((ib)localObject).publish();
        localFinderVideoLayout.getLongVideoSeekBar();
      }
      AppMethodBeat.o(168063);
    }
    
    public final void egu()
    {
      AppMethodBeat.i(168064);
      Object localObject1 = this.GqN.getPlayInfo();
      if (localObject1 != null)
      {
        FinderVideoLayout localFinderVideoLayout = this.GqN;
        Object localObject2 = localFinderVideoLayout.getVideoPlayBehavior();
        if (localObject2 != null) {
          ((c.b)localObject2).a(((FinderVideoLayout.b)localObject1).feed.getExpectId(), ((FinderVideoLayout.b)localObject1).EEv.ExE, ((FinderVideoLayout.b)localObject1).mediaList, (x)((FinderVideoLayout.b)localObject1).EEv);
        }
        if (FinderVideoLayout.p(localFinderVideoLayout) > 0L)
        {
          localObject2 = ax.Fur;
          localObject2 = ((FinderVideoLayout.b)localObject1).EEv.ExE.mediaId;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          ax.aAa((String)localObject1);
          if (!(localFinderVideoLayout.getVideoView() instanceof FinderThumbPlayerProxy)) {
            break label233;
          }
          localObject1 = localFinderVideoLayout.getVideoView();
          if (!(localObject1 instanceof FinderThumbPlayerProxy)) {
            break label228;
          }
          localObject1 = (FinderThumbPlayerProxy)localObject1;
          if (localObject1 != null) {
            ((FinderThumbPlayerProxy)localObject1).b(FinderVideoLayout.p(localFinderVideoLayout), true, FinderVideoLayout.q(localFinderVideoLayout));
          }
          label145:
          FinderVideoLayout.a(localFinderVideoLayout, 0L);
          FinderVideoLayout.a(localFinderVideoLayout, 1);
          localObject1 = localFinderVideoLayout.getVideoView();
          if (!(localObject1 instanceof FinderThumbPlayerProxy)) {
            break label266;
          }
        }
        label266:
        for (localObject1 = (FinderThumbPlayerProxy)localObject1;; localObject1 = null)
        {
          if (localObject1 != null) {
            ((FinderThumbPlayerProxy)localObject1).setPlaySpeed(FinderVideoLayout.r(localFinderVideoLayout));
          }
          FinderVideoLayout.a(localFinderVideoLayout, 1.0F);
          localObject1 = ((Iterable)FinderVideoLayout.n(localFinderVideoLayout)).iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((u)((Iterator)localObject1).next()).onVideoPlay();
          }
          label228:
          localObject1 = null;
          break;
          label233:
          localObject1 = localFinderVideoLayout.getVideoView();
          if (localObject1 == null) {
            break label145;
          }
          ((t)localObject1).a(FinderVideoLayout.p(localFinderVideoLayout) / 1000.0D, true, FinderVideoLayout.q(localFinderVideoLayout));
          break label145;
        }
      }
      AppMethodBeat.o(168064);
    }
    
    public final void ph(long paramLong)
    {
      AppMethodBeat.i(335175);
      FinderVideoLayout.b localb = this.GqN.getPlayInfo();
      if (localb != null)
      {
        FinderVideoLayout localFinderVideoLayout = this.GqN;
        Object localObject = ax.Fur;
        String str = localb.EEv.ExE.mediaId;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        ax.bM((String)localObject, true);
        localFinderVideoLayout.gE("", localb.mediaId);
        localObject = localFinderVideoLayout.getVideoPlayBehavior();
        if (localObject != null) {
          ((c.b)localObject).a(localb.feed.getExpectId(), localb.EEv.ExE, (x)localb.EEv, paramLong);
        }
      }
      AppMethodBeat.o(335175);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      a(az paramaz)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderVideoLayout$onHeadsetStateChangeListener$1", "Lcom/tencent/mm/plugin/findersdk/receiver/HeadsetReceiver$OnHeadsetStateChangeListener;", "onHeadsetStateChange", "", "on", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements HeadsetReceiver.b
  {
    j(FinderVideoLayout paramFinderVideoLayout) {}
    
    public final void sO(boolean paramBoolean)
    {
      AppMethodBeat.i(335150);
      Log.i(FinderVideoLayout.j(this.GqN), "onHeadsetStateChange on:" + paramBoolean + " isVideoPlaying:" + this.GqN.fjy());
      if ((!paramBoolean) && (this.GqN.fjy()))
      {
        if (this.GqN.getLongVideoSeekBar() != null)
        {
          this.GqN.uH(false);
          localObject = this.GqN.getLongVideoSeekBar();
          kotlin.g.b.s.checkNotNull(localObject);
          ((FinderLongVideoPlayerSeekBar)localObject).setIsPlay(false);
          AppMethodBeat.o(335150);
          return;
        }
        this.GqN.uG(true);
        Object localObject = FinderVideoLayout.d(this.GqN);
        if (localObject != null) {
          ((s)localObject).fiH();
        }
        localObject = FinderVideoLayout.d(this.GqN);
        if (localObject != null) {
          ((s)localObject).ux(true);
        }
      }
      AppMethodBeat.o(335150);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.b<t, ah>
  {
    k(FinderVideoLayout paramFinderVideoLayout, com.tencent.mm.plugin.findersdk.f.a parama, FinderVideoLayout.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.b<t, ah>
  {
    public l(FinderVideoLayout paramFinderVideoLayout, FinderVideoLayout.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    n(FinderVideoLayout paramFinderVideoLayout, long paramLong, int paramInt, float paramFloat)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoLayout
 * JD-Core Version:    0.7.0.1
 */