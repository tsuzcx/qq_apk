package com.tencent.mm.plugin.finder.video;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pd;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.b.b;
import com.tencent.mm.plugin.finder.event.b.c;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.report.y.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.viewmodel.FinderVideoStateCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderVideoStateCacheVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import d.f;
import d.l;
import d.v;
import d.z;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$SeekBarCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomButtonLayout", "Landroid/view/View;", "getBottomButtonLayout", "()Landroid/view/View;", "bottomButtonLayout$delegate", "Lkotlin/Lazy;", "bulletSubtitleButton", "getBulletSubtitleButton", "bulletSubtitleButton$delegate", "bulletSubtitlePresenter", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;", "bulletSubtitleViewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback;", "value", "", "isMute", "()Z", "setMute", "(Z)V", "isShowThumbAnimating", "lastCurrentPlaySecond", "lastSeekTime", "", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "loading", "getLoading", "loading$delegate", "muteBtn", "Landroid/widget/ImageView;", "getMuteBtn", "()Landroid/widget/ImageView;", "muteBtn$delegate", "playAdapterPosition", "getPlayAdapterPosition", "()I", "setPlayAdapterPosition", "(I)V", "playInfo", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "retryBtn", "getRetryBtn", "retryBtn$delegate", "seekBarLayout", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar;", "tabType", "thumbView", "getThumbView", "thumbView$delegate", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "getVideoCore", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setVideoCore", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;)V", "videoStateVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM;", "videoTypeIv", "getVideoTypeIv", "videoTypeIv$delegate", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "getVideoView", "()Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "setVideoView", "(Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;)V", "adaptForCropShow", "", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "cancelUpdateProgress", "checkVideoDataAvailable", "mediaId", "", "offset", "length", "convert", "position", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "dismissLoading", "dismissRetryBtn", "dismissThumb", "source", "findBestVideo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getBitmap", "Landroid/graphics/Bitmap;", "getCurrentPosSec", "getVideoDurationSec", "getVideoPlayBehavior", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "isEnableSeek", "isSeekMode", "onDetachedFromWindow", "onEnterSeekMode", "isEnter", "onError", "sessionId", "errorMsg", "what", "extra", "onFinishDownload", "ret", "video", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onGetVideoSize", "width", "height", "onMoovReadyDownload", "total", "onMute", "mute", "onNeedIgnoreTouchEvent", "event", "Landroid/view/MotionEvent;", "onPrepared", "onProgressDownload", "onStartDownload", "onStartSeek", "onStopDownload", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onStopSeek", "percent", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoStopPlay", "onVideoWaiting", "onVideoWaitingEnd", "onViewAdded", "child", "onViewRemoved", "pause", "isForceRemoveVideoView", "play", "prepare", "isLocal", "finderItem", "prepareToPlay", "retryPlay", "showLoading", "showRetryBtn", "showThumb", "showVideoPauseTip", "show", "showVideoTypeIv", "updateProgress", "viewLog", "Companion", "PlayInfo", "plugin-finder_release"})
public final class FinderVideoLayout
  extends FrameLayout
  implements FinderVideoSeekBar.c, q, t, i.b
{
  public static final a sPy;
  private int duh;
  private boolean fMP;
  public i rOe;
  private com.tencent.mm.plugin.finder.feed.d rWd;
  private com.tencent.mm.plugin.finder.feed.c rWe;
  private final u sOk;
  private final FinderVideoStateCacheVM sPj;
  private final f sPk;
  private final f sPl;
  private final f sPm;
  private final f sPn;
  private final f sPo;
  private o sPp;
  private final f sPq;
  private final f sPr;
  private b sPs;
  private FinderVideoSeekBar sPt;
  private int sPu;
  private boolean sPv;
  private float sPw;
  private int sPx;
  
  static
  {
    AppMethodBeat.i(168083);
    sPy = new a((byte)0);
    AppMethodBeat.o(168083);
  }
  
  public FinderVideoLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168131);
    setTag("Finder.VideoLayout");
    setId(2131299975);
    paramContext = com.tencent.mm.ui.component.a.KiD;
    paramContext = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoStateCacheVM.class);
    d.g.b.p.g(paramContext, "UICProvider.of(PluginFin…StateCacheVM::class.java)");
    this.sPj = ((FinderVideoStateCacheVM)paramContext);
    this.sPk = d.g.O((d.g.a.a)new g(this));
    this.sPl = d.g.O((d.g.a.a)new c(this));
    this.sPm = d.g.O((d.g.a.a)new d(this));
    this.sPn = d.g.O((d.g.a.a)new h(this));
    this.sPo = d.g.O((d.g.a.a)new m(this));
    this.sPq = d.g.O((d.g.a.a)new k(this));
    this.sPr = d.g.O((d.g.a.a)new o(this));
    this.sOk = ((u)new f(this));
    this.sPw = -1.0F;
    this.sPx = -1;
    AppMethodBeat.o(168131);
  }
  
  public FinderVideoLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168132);
    setTag("Finder.VideoLayout");
    setId(2131299975);
    paramContext = com.tencent.mm.ui.component.a.KiD;
    paramContext = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoStateCacheVM.class);
    d.g.b.p.g(paramContext, "UICProvider.of(PluginFin…StateCacheVM::class.java)");
    this.sPj = ((FinderVideoStateCacheVM)paramContext);
    this.sPk = d.g.O((d.g.a.a)new g(this));
    this.sPl = d.g.O((d.g.a.a)new c(this));
    this.sPm = d.g.O((d.g.a.a)new d(this));
    this.sPn = d.g.O((d.g.a.a)new h(this));
    this.sPo = d.g.O((d.g.a.a)new m(this));
    this.sPq = d.g.O((d.g.a.a)new k(this));
    this.sPr = d.g.O((d.g.a.a)new o(this));
    this.sOk = ((u)new f(this));
    this.sPw = -1.0F;
    this.sPx = -1;
    AppMethodBeat.o(168132);
  }
  
  private final void ajh(String paramString)
  {
    AppMethodBeat.i(204806);
    o localo = this.sPp;
    if ((localo != null) && (localo.getAlpha() == 1.0F))
    {
      AppMethodBeat.o(204806);
      return;
    }
    if (this.sPv)
    {
      AppMethodBeat.o(204806);
      return;
    }
    ad.i("Finder.VideoLayout", "[dismissThumb] " + cMy() + " source=" + paramString + " isShowThumbAnimating=" + this.sPv);
    paramString = this.sPp;
    if (paramString != null)
    {
      paramString.getVideoView().post((Runnable)new e(paramString, this));
      AppMethodBeat.o(204806);
      return;
    }
    AppMethodBeat.o(204806);
  }
  
  private final void cMB()
  {
    AppMethodBeat.i(204815);
    FinderVideoSeekBar localFinderVideoSeekBar = this.sPt;
    if (localFinderVideoSeekBar != null)
    {
      localFinderVideoSeekBar.cMI();
      AppMethodBeat.o(204815);
      return;
    }
    AppMethodBeat.o(204815);
  }
  
  private final boolean cMu()
  {
    FinderVideoSeekBar localFinderVideoSeekBar = this.sPt;
    return (localFinderVideoSeekBar != null) && (localFinderVideoSeekBar.sPA == true);
  }
  
  private final void cMv()
  {
    AppMethodBeat.i(168119);
    this.sPv = false;
    o localo = this.sPp;
    if (localo != null) {}
    for (float f = localo.getAlpha(); f == 0.0F; f = 0.0F)
    {
      AppMethodBeat.o(168119);
      return;
    }
    localo = this.sPp;
    if (localo != null) {
      localo.setAlpha(0.0F);
    }
    ad.i("Finder.VideoLayout", "[showThumb] " + cMy());
    AppMethodBeat.o(168119);
  }
  
  private final void cMw()
  {
    AppMethodBeat.i(168121);
    getRetryBtn().animate().cancel();
    getRetryBtn().setVisibility(0);
    FinderVideoSeekBar localFinderVideoSeekBar = this.sPt;
    if (localFinderVideoSeekBar != null) {
      localFinderVideoSeekBar.setVisibility(8);
    }
    ckm();
    AppMethodBeat.o(168121);
  }
  
  private final void cMx()
  {
    AppMethodBeat.i(168122);
    getRetryBtn().animate().cancel();
    FinderVideoSeekBar localFinderVideoSeekBar = this.sPt;
    if (localFinderVideoSeekBar != null) {
      localFinderVideoSeekBar.setVisibility(0);
    }
    getRetryBtn().setVisibility(8);
    AppMethodBeat.o(168122);
  }
  
  private final String cMy()
  {
    AppMethodBeat.i(168130);
    Object localObject1 = new StringBuilder().append(hashCode()).append(':');
    Object localObject2 = this.sPp;
    int i;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject2 = ((StringBuilder)localObject1).append(i).append(" alpha=");
      localObject1 = this.sPp;
      if (localObject1 == null) {
        break label93;
      }
    }
    label93:
    for (localObject1 = Float.valueOf(((o)localObject1).getAlpha());; localObject1 = null)
    {
      localObject1 = localObject1;
      AppMethodBeat.o(168130);
      return localObject1;
      i = 0;
      break;
    }
  }
  
  private final void ccT()
  {
    AppMethodBeat.i(204814);
    FinderVideoSeekBar localFinderVideoSeekBar = this.sPt;
    if (localFinderVideoSeekBar != null)
    {
      localFinderVideoSeekBar.post((Runnable)new n(localFinderVideoSeekBar, this));
      AppMethodBeat.o(204814);
      return;
    }
    AppMethodBeat.o(204814);
  }
  
  private final void ckm()
  {
    AppMethodBeat.i(168123);
    getLoading().animate().cancel();
    if (getLoading().getVisibility() != 8) {
      getLoading().setVisibility(8);
    }
    AppMethodBeat.o(168123);
  }
  
  private final View getBottomButtonLayout()
  {
    AppMethodBeat.i(204800);
    View localView = (View)this.sPl.getValue();
    AppMethodBeat.o(204800);
    return localView;
  }
  
  private final View getBulletSubtitleButton()
  {
    AppMethodBeat.i(204801);
    View localView = (View)this.sPm.getValue();
    AppMethodBeat.o(204801);
    return localView;
  }
  
  private final View getLoading()
  {
    AppMethodBeat.i(168084);
    View localView = (View)this.sPk.getValue();
    AppMethodBeat.o(168084);
    return localView;
  }
  
  private final ImageView getMuteBtn()
  {
    AppMethodBeat.i(168086);
    ImageView localImageView = (ImageView)this.sPn.getValue();
    AppMethodBeat.o(168086);
    return localImageView;
  }
  
  private final ImageView getThumbView()
  {
    AppMethodBeat.i(168087);
    ImageView localImageView = (ImageView)this.sPo.getValue();
    AppMethodBeat.o(168087);
    return localImageView;
  }
  
  private final b.b getVideoPlayBehavior()
  {
    AppMethodBeat.i(168129);
    Object localObject = this.rOe;
    if (localObject == null) {
      d.g.b.p.bcb("videoCore");
    }
    localObject = ((i)localObject).sPa;
    if (localObject != null)
    {
      localObject = (b.b)new b.c((com.tencent.mm.plugin.finder.event.b)localObject);
      AppMethodBeat.o(168129);
      return localObject;
    }
    AppMethodBeat.o(168129);
    return null;
  }
  
  private final View getVideoTypeIv()
  {
    AppMethodBeat.i(168093);
    View localView = (View)this.sPr.getValue();
    AppMethodBeat.o(168093);
    return localView;
  }
  
  private final void mi(boolean paramBoolean)
  {
    AppMethodBeat.i(204807);
    if (paramBoolean)
    {
      localObject = com.tencent.mm.kernel.g.ajC();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      paramBoolean = ((com.tencent.mm.kernel.e)localObject).ajl().getBoolean(al.a.IIP, true);
      getBulletSubtitleButton().setSelected(paramBoolean);
      getBottomButtonLayout().setVisibility(0);
      localObject = this.rWd;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.feed.d)localObject).cAW();
        if (localObject != null)
        {
          ((WxRecyclerView)localObject).setAlpha(0.3F);
          AppMethodBeat.o(204807);
          return;
        }
      }
      AppMethodBeat.o(204807);
      return;
    }
    getBottomButtonLayout().setVisibility(8);
    Object localObject = this.rWd;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.feed.d)localObject).cAW();
      if (localObject != null)
      {
        ((WxRecyclerView)localObject).setAlpha(1.0F);
        AppMethodBeat.o(204807);
        return;
      }
    }
    AppMethodBeat.o(204807);
  }
  
  private void pause(boolean paramBoolean)
  {
    AppMethodBeat.i(168097);
    Object localObject1 = this.sPs;
    if ((localObject1 != null) && (!((b)localObject1).sPz))
    {
      AppMethodBeat.o(168097);
      return;
    }
    Object localObject2 = new StringBuilder("[FinderVideoLayout#pause] ").append(cMy()).append(" isForceRemoveVideoView=").append(paramBoolean).append(" isSeekMode=");
    localObject1 = this.sPs;
    label114:
    boolean bool;
    if (localObject1 != null)
    {
      localObject1 = Boolean.valueOf(((b)localObject1).sPA);
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(' ').append("media=");
      localObject1 = this.sPs;
      if (localObject1 == null) {
        break label407;
      }
      localObject1 = ((b)localObject1).mediaId;
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(' ');
      if (ad.getLogLevel() > 1) {
        break label412;
      }
      localObject1 = bt.flS();
      label138:
      ad.i("Finder.VideoLayout", localObject1);
      localObject1 = this.sPs;
      if (localObject1 == null) {
        break label419;
      }
      bool = ((b)localObject1).sPA;
      label167:
      localObject1 = this.rOe;
      if (localObject1 == null) {
        d.g.b.p.bcb("videoCore");
      }
      localObject1 = ((i)localObject1).cMr();
      localObject2 = (ViewGroup)this;
      d.g.b.p.h(localObject2, "parent");
      ((Map)((FinderVideoRecycler)localObject1).tdt).put(Integer.valueOf(((ViewGroup)localObject2).hashCode()), null);
      localObject2 = ((ViewGroup)localObject2).findViewWithTag(Integer.valueOf(((ViewGroup)localObject2).hashCode()));
      if ((localObject2 instanceof o))
      {
        localObject2 = (o)localObject2;
        ((o)localObject2).setVideoViewFocused(false);
        if ((!bool) && (paramBoolean)) {
          break label424;
        }
        ((o)localObject2).cMg();
        ad.i("Finder.VideoRecycler", "[pauseOrRecycle] pauseWithCancel a videoView(" + localObject2.hashCode() + ") isForceRemove=" + paramBoolean + " isTryKeep=" + bool + " ret=0");
      }
    }
    for (;;)
    {
      ckm();
      localObject1 = this.rWd;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.feed.d)localObject1).reset(false);
      }
      if (paramBoolean)
      {
        mi(false);
        localObject1 = this.sPt;
        if (localObject1 != null) {
          ((FinderVideoSeekBar)localObject1).setSeekMode(false);
        }
      }
      localObject1 = this.sPs;
      if (localObject1 != null) {
        ((b)localObject1).sPz = false;
      }
      this.sPx = -1;
      setKeepScreenOn(false);
      AppMethodBeat.o(168097);
      return;
      localObject1 = null;
      break;
      label407:
      localObject1 = null;
      break label114;
      label412:
      localObject1 = "";
      break label138;
      label419:
      bool = false;
      break label167;
      label424:
      ((FinderVideoRecycler)localObject1).a((o)localObject2, "pauseAndRecycle");
    }
  }
  
  private final void showLoading()
  {
    AppMethodBeat.i(168124);
    StringBuilder localStringBuilder = new StringBuilder("showLoading ");
    Object localObject = this.sPp;
    if (localObject != null) {}
    for (localObject = ((o)localObject).getVideoMediaId();; localObject = null)
    {
      ad.i("Finder.VideoLayout", (String)localObject);
      localObject = this.sPp;
      if (localObject == null) {
        break;
      }
      if (((o)localObject).getVideoViewFocused() == true)
      {
        getLoading().setVisibility(0);
        getLoading().setAlpha(0.0F);
        getLoading().animate().alpha(1.0F).setDuration(1000L).setListener((Animator.AnimatorListener)new l(this)).start();
      }
      AppMethodBeat.o(168124);
      return;
    }
    AppMethodBeat.o(168124);
  }
  
  public final boolean T(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(204811);
    d.g.b.p.h(paramMotionEvent, "event");
    if (getBulletSubtitleButton().getVisibility() != 0)
    {
      AppMethodBeat.o(204811);
      return false;
    }
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    ViewParent localViewParent = getBulletSubtitleButton().getParent();
    if (localViewParent == null)
    {
      paramMotionEvent = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(204811);
      throw paramMotionEvent;
    }
    ((View)localViewParent).getHitRect(localRect2);
    getBulletSubtitleButton().getHitRect(localRect1);
    localRect1.top += localRect2.top;
    localRect1.bottom += localRect2.top;
    localRect1.left += localRect2.left;
    localRect1.right += localRect2.left;
    boolean bool = localRect1.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    AppMethodBeat.o(204811);
    return bool;
  }
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    Object localObject2 = null;
    AppMethodBeat.i(168114);
    d.g.b.p.h(paramm, "video");
    StringBuilder localStringBuilder = new StringBuilder("[onMoovReadyDownload] videoView=");
    Object localObject1 = this.sPp;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(localObject1.hashCode());
      ad.i("Finder.VideoLayout", localObject1 + "  offset=" + paramInt1 + " total=" + paramInt2 + " video=" + paramm);
      paramm = this.sPs;
      if (paramm != null)
      {
        if (!paramm.sPz) {
          break label268;
        }
        label111:
        if (paramm != null)
        {
          localObject1 = getVideoPlayBehavior();
          if (localObject1 != null) {
            ((b.b)localObject1).b(paramm.feed.getExpectId(), paramm.slw.siC, paramInt1, paramInt2, paramm.slw);
          }
        }
      }
      paramm = com.tencent.mm.plugin.finder.report.e.snY;
      com.tencent.mm.plugin.finder.report.e.abY(this.duh);
      paramm = com.tencent.mm.plugin.finder.report.y.LjV;
      paramm = this.sPs;
      if (paramm == null) {
        break label273;
      }
      paramm = paramm.feed;
      if (paramm == null) {
        break label273;
      }
      paramm = Long.valueOf(paramm.getId());
      label194:
      if (paramm == null) {
        break label278;
      }
      paramm.longValue();
      localObject1 = com.tencent.mm.plugin.finder.report.y.FS(paramm.longValue());
      if ((((y.a)localObject1).soj <= 0L) || (((y.a)localObject1).LjY != 0L)) {
        break label285;
      }
    }
    label268:
    label273:
    label278:
    label285:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramm = localObject2;
      if (paramInt1 != 0) {
        paramm = (m)localObject1;
      }
      if (paramm == null) {
        break label290;
      }
      paramm.LjY = cf.aCM();
      AppMethodBeat.o(168114);
      return;
      localObject1 = null;
      break;
      paramm = null;
      break label111;
      paramm = null;
      break label194;
      AppMethodBeat.o(168114);
      return;
    }
    label290:
    AppMethodBeat.o(168114);
  }
  
  public final void a(int paramInt, m paramm, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(168113);
    d.g.b.p.h(paramm, "video");
    StringBuilder localStringBuilder = new StringBuilder("[onFinishDownload] ret=").append(paramInt).append(" videoView=");
    Object localObject = this.sPp;
    if (localObject != null)
    {
      localObject = Integer.valueOf(localObject.hashCode());
      ad.i("Finder.VideoLayout", localObject + " FinderVideo=" + paramm);
      ckm();
      paramm = this.sPs;
      if (paramm != null) {
        if (!paramm.sPz) {
          break label165;
        }
      }
    }
    for (;;)
    {
      if (paramm != null)
      {
        localObject = getVideoPlayBehavior();
        if (localObject != null) {
          ((b.b)localObject).a(paramm.feed.getExpectId(), paramm.slw.siC, paramInt, paramd, paramm.slw);
        }
      }
      if (paramInt < 0) {
        cMw();
      }
      AppMethodBeat.o(168113);
      return;
      localObject = null;
      break;
      label165:
      paramm = null;
    }
  }
  
  public final void a(int paramInt1, FinderItem paramFinderItem, FinderVideoSeekBar paramFinderVideoSeekBar, int paramInt2)
  {
    AppMethodBeat.i(204802);
    d.g.b.p.h(paramFinderItem, "feed");
    ad.i("Finder.VideoLayout", "[convert] position=" + paramInt1 + " feedId=" + paramFinderItem.getExpectId() + " current=" + System.currentTimeMillis() + " feedTime=" + paramFinderItem.getTimestamps() + " urlValidDuration=" + paramFinderItem.getFeedObject().urlValidDuration + 's');
    this.duh = paramInt2;
    if (paramFinderVideoSeekBar != null) {
      paramFinderVideoSeekBar.setSeekBarCallback((FinderVideoSeekBar.c)this);
    }
    this.sPt = paramFinderVideoSeekBar;
    Object localObject1 = paramFinderItem.getMediaList();
    if (paramInt1 >= ((LinkedList)localObject1).size())
    {
      AppMethodBeat.o(204802);
      return;
    }
    Object localObject2 = ((LinkedList)localObject1).get(paramInt1);
    d.g.b.p.g(localObject2, "mediaList[position]");
    Object localObject3 = (bvf)localObject2;
    String str = ((bvf)localObject3).mediaId;
    d.g.b.p.g(str, "mediaInfo.mediaId");
    localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
    localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.b((bvf)localObject3);
    ad.i("Finder.VideoLayout", "[findBestVideo] mediaId=" + str + " videoFlag=" + ((m)localObject2).siD);
    boolean bool;
    if (paramFinderItem.getId() == 0L)
    {
      bool = true;
      this.sPs = new b(paramFinderItem, ((m)localObject2).aeA(), (m)localObject2, paramInt1, (LinkedList)localObject1, bool, (byte)0);
      cMv();
      localObject1 = new com.tencent.mm.plugin.finder.loader.g((bvf)localObject3, r.syE);
      localObject3 = com.tencent.mm.plugin.finder.loader.i.sja;
      localObject3 = com.tencent.mm.plugin.finder.loader.i.cCB().bI(localObject1);
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cHX().value()).intValue() <= 0) {
        break label668;
      }
      localObject1 = new com.tencent.mm.loader.e.d(null, new com.tencent.mm.loader.e.b.g(this), 1);
      label337:
      localObject1 = ((com.tencent.mm.loader.a.b)localObject3).a((com.tencent.mm.loader.f.d)localObject1);
      localObject3 = com.tencent.mm.plugin.finder.loader.i.sja;
      ((com.tencent.mm.loader.b)localObject1).a(com.tencent.mm.plugin.finder.loader.i.a(i.a.sjb)).c(getThumbView());
      localObject1 = this.sPj.ajn(((m)localObject2).aeA());
      if (localObject1 == null) {
        break label674;
      }
      if (paramFinderVideoSeekBar != null) {
        paramFinderVideoSeekBar.mk(true);
      }
      if (paramFinderVideoSeekBar != null) {
        paramFinderVideoSeekBar.setProgress(((FinderVideoStateCacheVM.a)localObject1).progress);
      }
      mi(true);
      if (paramFinderVideoSeekBar != null) {
        paramFinderVideoSeekBar.setSeekMode(true);
      }
      localObject1 = this.sPs;
      if (localObject1 != null) {
        ((b)localObject1).sPA = true;
      }
      if (paramFinderVideoSeekBar != null) {
        paramFinderVideoSeekBar.setVisibility(0);
      }
      label457:
      if (this.rWe != null)
      {
        paramFinderVideoSeekBar = this.rWd;
        if (paramFinderVideoSeekBar == null) {
          break label702;
        }
        localObject1 = com.tencent.mm.kernel.g.ajC();
        d.g.b.p.g(localObject1, "MMKernel.storage()");
        paramFinderVideoSeekBar.N(((com.tencent.mm.kernel.e)localObject1).ajl().getBoolean(al.a.IIP, true), false);
      }
    }
    label668:
    label674:
    label702:
    for (paramFinderVideoSeekBar = z.MKo;; paramFinderVideoSeekBar = null)
    {
      if (paramFinderVideoSeekBar == null)
      {
        paramFinderVideoSeekBar = (FinderVideoLayout)this;
        localObject1 = paramFinderVideoSeekBar.getContext();
        d.g.b.p.g(localObject1, "context");
        paramFinderVideoSeekBar.rWe = new com.tencent.mm.plugin.finder.feed.c((Context)localObject1);
        localObject1 = (View)paramFinderVideoSeekBar;
        localObject2 = paramFinderVideoSeekBar.rWe;
        if (localObject2 == null) {
          d.g.b.p.gfZ();
        }
        paramFinderVideoSeekBar.rWd = new com.tencent.mm.plugin.finder.feed.d((View)localObject1, (com.tencent.mm.plugin.finder.feed.c)localObject2);
        localObject1 = paramFinderVideoSeekBar.rWe;
        if (localObject1 == null) {
          d.g.b.p.gfZ();
        }
        paramFinderVideoSeekBar = paramFinderVideoSeekBar.rWd;
        if (paramFinderVideoSeekBar == null) {
          d.g.b.p.gfZ();
        }
        ((com.tencent.mm.plugin.finder.feed.c)localObject1).a(paramFinderVideoSeekBar);
        paramFinderVideoSeekBar = z.MKo;
      }
      paramFinderVideoSeekBar = this.rWe;
      if (paramFinderVideoSeekBar != null) {
        paramFinderVideoSeekBar.a(paramFinderItem, paramInt2);
      }
      paramFinderItem = getBulletSubtitleButton();
      paramFinderVideoSeekBar = this.rWd;
      if (paramFinderVideoSeekBar == null) {
        d.g.b.p.gfZ();
      }
      paramFinderItem.setSelected(paramFinderVideoSeekBar.getFunctionSwitch());
      AppMethodBeat.o(204802);
      return;
      bool = false;
      break;
      localObject1 = null;
      break label337;
      ((FinderVideoLayout)this).mi(false);
      if (paramFinderVideoSeekBar != null) {
        paramFinderVideoSeekBar.setSeekMode(false);
      }
      if (paramFinderVideoSeekBar == null) {
        break label457;
      }
      paramFinderVideoSeekBar.cMH();
      break label457;
    }
  }
  
  public final void a(m paramm, com.tencent.mm.i.h paramh, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(168112);
    d.g.b.p.h(paramm, "video");
    StringBuilder localStringBuilder = new StringBuilder("[onStopDownload] videoView=");
    Object localObject = this.sPp;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(localObject.hashCode());; localObject = null)
    {
      ad.i("Finder.VideoLayout", localObject + " FinderVideo=" + paramm + " thumbVisible=" + getThumbView().getVisibility());
      paramm = this.sPs;
      if (paramm == null) {
        break label155;
      }
      localObject = getVideoPlayBehavior();
      if (localObject == null) {
        break;
      }
      ((b.b)localObject).a(paramm.feed.getExpectId(), paramm.slw.siC, paramh, paramd, paramm.slw);
      AppMethodBeat.o(168112);
      return;
    }
    AppMethodBeat.o(168112);
    return;
    label155:
    AppMethodBeat.o(168112);
  }
  
  public final void ae(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(169678);
    d.g.b.p.h(paramString, "mediaId");
    paramString = this.sPs;
    if (paramString != null)
    {
      if (paramString.sPz) {}
      while (paramString != null)
      {
        b.b localb = getVideoPlayBehavior();
        if (localb != null)
        {
          localb.e(paramString.feed.getExpectId(), paramString.slw.siC, paramInt1, paramInt2, paramString.slw);
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
  
  public final void b(int paramInt1, int paramInt2, m paramm)
  {
    AppMethodBeat.i(168115);
    d.g.b.p.h(paramm, "video");
    Object localObject2 = new StringBuilder("[onProgressDownload] videoView=");
    Object localObject1 = this.sPp;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(localObject1.hashCode());
      ad.i("Finder.VideoLayout", localObject1 + " offset=" + paramInt1 + " total=" + paramInt2 + " video=" + paramm.aeA());
      localObject1 = this.sPs;
      if (localObject1 != null) {
        if (!((b)localObject1).sPz) {
          break label276;
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = getVideoPlayBehavior();
        if (localObject2 != null) {
          ((b.b)localObject2).c(((b)localObject1).feed.getExpectId(), ((b)localObject1).slw.siC, paramInt1, paramInt2, ((b)localObject1).slw);
        }
      }
      localObject1 = MediaPreloadCore.skO;
      if (MediaPreloadCore.cDb())
      {
        localObject1 = new pd();
        ((pd)localObject1).dDd.mediaId = paramm.siC.mediaId;
        ((pd)localObject1).dDd.process = ((int)(100.0F * paramInt1 / paramInt2));
        localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
        paramm = paramm.siC.mediaId;
        d.g.b.p.g(paramm, "video.mediaObj.mediaId");
        paramm = com.tencent.mm.plugin.finder.storage.logic.c.bf(paramm, true);
        ((pd)localObject1).dDd.dDf = paramm.field_fileFormat;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      }
      AppMethodBeat.o(168115);
      return;
      localObject1 = null;
      break;
      label276:
      localObject1 = null;
    }
  }
  
  public final void b(m paramm)
  {
    Object localObject2 = null;
    AppMethodBeat.i(168111);
    d.g.b.p.h(paramm, "video");
    Object localObject3 = new StringBuilder("[onStartDownload] videoView=");
    Object localObject1 = this.sPp;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(localObject1.hashCode());
      ad.i("Finder.VideoLayout", localObject1 + " FinderVideo=" + paramm + " thumbVisible=" + getThumbView().getVisibility());
      cMx();
      paramm = this.sPs;
      if (paramm != null) {
        if (!paramm.sPz) {
          break label210;
        }
      }
    }
    for (;;)
    {
      if (paramm != null)
      {
        localObject1 = getVideoPlayBehavior();
        if (localObject1 != null) {
          ((b.b)localObject1).f(paramm.feed.getExpectId(), paramm.slw.siC, paramm.slw);
        }
      }
      paramm = com.tencent.mm.plugin.finder.report.e.snY;
      com.tencent.mm.plugin.finder.report.e.EM(this.duh);
      localObject1 = com.tencent.mm.plugin.finder.report.y.LjV;
      localObject3 = this.sPs;
      paramm = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((b)localObject3).feed;
        paramm = localObject2;
        if (localObject3 != null) {
          paramm = Long.valueOf(((FinderItem)localObject3).getId());
        }
      }
      ((com.tencent.mm.plugin.finder.report.y)localObject1).i(paramm);
      AppMethodBeat.o(168111);
      return;
      localObject1 = null;
      break;
      label210:
      paramm = null;
    }
  }
  
  public final void bd(float paramFloat)
  {
    boolean bool = true;
    AppMethodBeat.i(204810);
    Object localObject2 = new StringBuilder("[seekTo] percent=").append(paramFloat).append(" isSeekMode=").append(cMu()).append(" videoView=");
    Object localObject1 = this.sPp;
    label103:
    int j;
    int i;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(localObject1.hashCode());
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(" videoDurationSec=");
      localObject1 = this.sPp;
      if (localObject1 == null) {
        break label379;
      }
      localObject1 = Integer.valueOf(((o)localObject1).getVideoDuration());
      ad.i("Finder.VideoLayout", localObject1);
      localObject1 = this.sPp;
      if (localObject1 != null)
      {
        j = ((o)localObject1).getCurrentPlaySecond();
        localObject2 = this.sPp;
        if (localObject2 == null) {
          break label385;
        }
        i = ((o)localObject2).getVideoDuration();
        label159:
        paramFloat = android.support.v4.b.a.j(i * paramFloat, i - 1.0F);
        double d = paramFloat;
        if (cMu()) {
          break label391;
        }
        label183:
        if ((((o)localObject1).c(d, bool)) && (Math.abs(j - paramFloat) > 1.0F))
        {
          this.sPw = paramFloat;
          localObject2 = new StringBuilder("[seekTo] successfully seek to ").append(paramFloat).append(" videoDurationSec=");
          localObject1 = this.sPp;
          if (localObject1 == null) {
            break label397;
          }
          localObject1 = Integer.valueOf(((o)localObject1).getVideoDuration());
          ad.i("Finder.VideoLayout", localObject1);
        }
        label259:
        localObject1 = this.sPs;
        if (localObject1 != null) {
          if (!((b)localObject1).sPz) {
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
          ((b.b)localObject2).d(((b)localObject1).feed.getExpectId(), ((b)localObject1).slw.siC, j, (int)paramFloat, ((b)localObject1).slw);
        }
      }
      localObject1 = this.sPs;
      if (localObject1 == null) {
        break label409;
      }
      if (!((b)localObject1).sPA) {
        mi(false);
      }
      AppMethodBeat.o(204810);
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
    AppMethodBeat.o(204810);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168103);
    StringBuilder localStringBuilder = new StringBuilder("[onError] videoView=");
    paramString1 = this.sPp;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      ad.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2 + " errorMsg=" + paramString3 + " what=" + paramInt1 + " extra=" + paramInt2);
      paramString1 = this.sPt;
      if (paramString1 != null) {
        paramString1.setVisibility(8);
      }
      cMw();
      paramString1 = com.tencent.mm.plugin.finder.report.h.soM;
      com.tencent.mm.plugin.finder.report.h.EZ(paramInt1);
      paramString1 = this.sPs;
      if (paramString1 == null) {
        break label179;
      }
      paramString2 = getVideoPlayBehavior();
      if (paramString2 == null) {
        break;
      }
      paramString2.a(paramString1.feed.getExpectId(), paramString1.slw.siC, paramInt1);
      AppMethodBeat.o(168103);
      return;
    }
    AppMethodBeat.o(168103);
    return;
    label179:
    AppMethodBeat.o(168103);
  }
  
  public final boolean cMA()
  {
    b localb = this.sPs;
    return (localb != null) && (localb.sPz == true);
  }
  
  public final void cMt()
  {
    AppMethodBeat.i(204804);
    b localb = this.sPs;
    if (localb != null)
    {
      i locali = this.rOe;
      if (locali == null) {
        d.g.b.p.bcb("videoCore");
      }
      locali.cMr().a((ViewGroup)this, localb.slw, (d.g.a.b)new j(localb, this));
      AppMethodBeat.o(204804);
      return;
    }
    AppMethodBeat.o(204804);
  }
  
  public final void cMz()
  {
    AppMethodBeat.i(204809);
    Object localObject = this.sPp;
    if (localObject != null) {
      ((o)localObject).pause();
    }
    localObject = this.sPs;
    if ((localObject != null) && (!((b)localObject).sPA)) {
      mi(true);
    }
    cMB();
    AppMethodBeat.o(204809);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168106);
    StringBuilder localStringBuilder = new StringBuilder("[onGetVideoSize] videoView=");
    paramString1 = this.sPp;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      ad.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2 + " width=" + paramInt1 + " height=" + paramInt2);
      AppMethodBeat.o(168106);
      return;
    }
  }
  
  public final void dq(String paramString1, String paramString2)
  {
    Integer localInteger = null;
    AppMethodBeat.i(168104);
    paramString1 = this.sPp;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.getVideoDuration());; paramString1 = null)
    {
      StringBuilder localStringBuilder = new StringBuilder("[onPrepared] videoView=");
      o localo = this.sPp;
      if (localo != null) {
        localInteger = Integer.valueOf(localo.hashCode());
      }
      ad.i("Finder.VideoLayout", localInteger + " mediaId=" + paramString2 + " thumbVisible=" + getThumbView().getVisibility() + " duration=" + paramString1);
      AppMethodBeat.o(168104);
      return;
    }
  }
  
  public final void dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(168105);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoEnded] videoView=");
    paramString1 = this.sPp;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      ad.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      AppMethodBeat.o(168105);
      return;
    }
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(168107);
    Object localObject2 = new StringBuilder("[onVideoPause] videoView=");
    paramString1 = this.sPp;
    if (paramString1 != null)
    {
      paramString1 = Integer.valueOf(paramString1.hashCode());
      ad.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      ckm();
      paramString1 = com.tencent.mm.plugin.finder.report.y.LjV;
      paramString1 = this.sPs;
      if (paramString1 == null) {
        break label196;
      }
      paramString1 = paramString1.feed;
      if (paramString1 == null) {
        break label196;
      }
      paramString1 = Long.valueOf(paramString1.getId());
      label97:
      if (paramString1 == null) {
        break label201;
      }
      paramString1.longValue();
      localObject2 = com.tencent.mm.plugin.finder.report.y.FS(paramString1.longValue());
      if ((((y.a)localObject2).LjW <= 0L) || (((y.a)localObject2).sok != 0L) || (((y.a)localObject2).LjX != 0L)) {
        break label208;
      }
    }
    label196:
    label201:
    label208:
    for (int i = 1;; i = 0)
    {
      paramString2 = localObject1;
      if (i != 0) {
        paramString2 = (String)localObject2;
      }
      if (paramString2 == null) {
        break label213;
      }
      paramString2.LjX = cf.aCM();
      com.tencent.mm.plugin.finder.report.y.LjT.add(paramString2);
      com.tencent.mm.plugin.finder.report.y.LjS.remove(paramString1);
      AppMethodBeat.o(168107);
      return;
      paramString1 = null;
      break;
      paramString1 = null;
      break label97;
      AppMethodBeat.o(168107);
      return;
    }
    label213:
    AppMethodBeat.o(168107);
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(168108);
    paramString1 = this.sPp;
    int i;
    Object localObject2;
    if (paramString1 != null)
    {
      i = paramString1.getVideoDuration();
      localObject2 = new StringBuilder("[onVideoPlay] videoView=");
      paramString1 = this.sPp;
      if (paramString1 == null) {
        break label223;
      }
      paramString1 = Integer.valueOf(paramString1.hashCode());
      label54:
      paramString2 = ((StringBuilder)localObject2).append(paramString1).append(" mediaId=").append(paramString2).append(" duration=").append(i).append(" isHasPlayed=");
      paramString1 = this.sPs;
      if (paramString1 == null) {
        break label228;
      }
    }
    label223:
    label228:
    for (paramString1 = Boolean.valueOf(paramString1.sPB);; paramString1 = null)
    {
      ad.i("Finder.VideoLayout", paramString1);
      ckm();
      cMx();
      paramString1 = this.sPp;
      if (paramString1 != null) {
        paramString1.setKeepScreenOn(true);
      }
      this.sPw = -1.0F;
      ccT();
      paramString2 = com.tencent.mm.plugin.finder.report.y.LjV;
      localObject2 = this.sPs;
      paramString1 = localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((b)localObject2).feed;
        paramString1 = localObject1;
        if (localObject2 != null) {
          paramString1 = Long.valueOf(((FinderItem)localObject2).getId());
        }
      }
      paramString2.j(paramString1);
      paramString1 = com.tencent.mm.plugin.finder.report.e.snY;
      com.tencent.mm.plugin.finder.report.e.amd(this.duh);
      AppMethodBeat.o(168108);
      return;
      i = 0;
      break;
      paramString1 = null;
      break label54;
    }
  }
  
  public final void du(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(168109);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoWaiting] videoView=");
    Object localObject1 = this.sPp;
    if (localObject1 != null) {}
    for (localObject1 = Integer.valueOf(localObject1.hashCode());; localObject1 = null)
    {
      ad.i("Finder.VideoLayout", localObject1 + " mediaId=" + paramString2 + " thumbVisible=" + getThumbView().getVisibility());
      paramString2 = this.sPp;
      if (((paramString2 == null) || (paramString2.getVideoViewFocused() != true)) && (paramString1 != null)) {
        break label183;
      }
      showLoading();
      paramString2 = this.sPs;
      if (paramString2 == null) {
        break label183;
      }
      paramString1 = localObject2;
      if (paramString2.sPz) {
        paramString1 = paramString2;
      }
      if (paramString1 == null) {
        break label183;
      }
      paramString2 = getVideoPlayBehavior();
      if (paramString2 == null) {
        break;
      }
      paramString2.b(paramString1.feed.getExpectId(), paramString1.slw.siC, paramString1.slw);
      AppMethodBeat.o(168109);
      return;
    }
    AppMethodBeat.o(168109);
    return;
    label183:
    AppMethodBeat.o(168109);
  }
  
  public final void dv(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(168110);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoWaitingEnd] videoView=");
    paramString1 = this.sPp;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      ad.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      ckm();
      paramString2 = this.sPs;
      if (paramString2 == null) {
        break label142;
      }
      paramString1 = localObject;
      if (paramString2.sPz) {
        paramString1 = paramString2;
      }
      if (paramString1 == null) {
        break label142;
      }
      paramString2 = getVideoPlayBehavior();
      if (paramString2 == null) {
        break;
      }
      paramString2.c(paramString1.feed.getExpectId(), paramString1.slw.siC, paramString1.slw);
      AppMethodBeat.o(168110);
      return;
    }
    AppMethodBeat.o(168110);
    return;
    label142:
    AppMethodBeat.o(168110);
  }
  
  public final void eT(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(204805);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoFirstFrameDraw] videoView=");
    paramString1 = this.sPp;
    if (paramString1 != null)
    {
      paramString1 = Integer.valueOf(paramString1.hashCode());
      ad.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      ajh("onVideoFirstFrameDraw");
      paramString1 = com.tencent.mm.plugin.finder.report.e.snY;
      com.tencent.mm.plugin.finder.report.e.EN(this.duh);
      paramString1 = com.tencent.mm.plugin.finder.report.y.LjV;
      paramString1 = this.sPs;
      if (paramString1 == null) {
        break label203;
      }
      paramString1 = paramString1.feed;
      if (paramString1 == null) {
        break label203;
      }
      paramString1 = Long.valueOf(paramString1.getId());
      label111:
      if (paramString1 == null) {
        break label208;
      }
      paramString1.longValue();
      paramString2 = com.tencent.mm.plugin.finder.report.y.FS(paramString1.longValue());
      if (((paramString2.soj <= 0L) && (paramString2.LjW <= 0L)) || (paramString2.sok != 0L)) {
        break label215;
      }
    }
    label203:
    label208:
    label215:
    for (int i = 1;; i = 0)
    {
      paramString1 = localObject;
      if (i != 0) {
        paramString1 = paramString2;
      }
      if (paramString1 == null) {
        break label220;
      }
      paramString1.sok = cf.aCM();
      com.tencent.mm.plugin.finder.report.y.LjT.add(paramString1);
      com.tencent.mm.plugin.finder.report.y.LjS.clear();
      AppMethodBeat.o(204805);
      return;
      paramString1 = null;
      break;
      paramString1 = null;
      break label111;
      AppMethodBeat.o(204805);
      return;
    }
    label220:
    AppMethodBeat.o(204805);
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(204816);
    Object localObject = this.sPp;
    if (localObject != null)
    {
      Bitmap localBitmap = ((o)localObject).getBitmap();
      localObject = localBitmap;
      if (localBitmap != null) {}
    }
    else
    {
      localObject = getThumbView().getDrawable();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        AppMethodBeat.o(204816);
        throw ((Throwable)localObject);
      }
      localObject = ((BitmapDrawable)localObject).getBitmap();
    }
    AppMethodBeat.o(204816);
    return localObject;
  }
  
  public final int getCurrentPosSec()
  {
    AppMethodBeat.i(204813);
    o localo = this.sPp;
    if (localo != null)
    {
      int i = localo.getCurrentPlaySecond();
      AppMethodBeat.o(204813);
      return i;
    }
    AppMethodBeat.o(204813);
    return 0;
  }
  
  public final u getLifecycle()
  {
    return this.sOk;
  }
  
  public final int getPlayAdapterPosition()
  {
    return this.sPu;
  }
  
  public final View getRetryBtn()
  {
    AppMethodBeat.i(168092);
    View localView = (View)this.sPq.getValue();
    AppMethodBeat.o(168092);
    return localView;
  }
  
  public final i getVideoCore()
  {
    AppMethodBeat.i(168088);
    i locali = this.rOe;
    if (locali == null) {
      d.g.b.p.bcb("videoCore");
    }
    AppMethodBeat.o(168088);
    return locali;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(204812);
    o localo = this.sPp;
    if (localo != null)
    {
      int i = localo.getVideoDuration();
      AppMethodBeat.o(204812);
      return i;
    }
    AppMethodBeat.o(204812);
    return 0;
  }
  
  public final o getVideoView()
  {
    return this.sPp;
  }
  
  public final void mj(boolean paramBoolean)
  {
    b localb = null;
    AppMethodBeat.i(204808);
    Object localObject1 = this.sPp;
    boolean bool;
    Object localObject2;
    if (localObject1 != null)
    {
      if (!paramBoolean)
      {
        bool = true;
        ((o)localObject1).setVideoViewFocused(bool);
      }
    }
    else
    {
      if (!paramBoolean) {
        break label271;
      }
      localObject1 = this.sPs;
      if (localObject1 != null)
      {
        localObject2 = getVideoPlayBehavior();
        if (localObject2 != null) {
          ((b.b)localObject2).a(((b)localObject1).feed.getExpectId(), ((b)localObject1).slw.siC, ((b)localObject1).slw);
        }
      }
      mi(true);
      localObject1 = this.sPp;
      if (localObject1 != null) {
        ((o)localObject1).setVideoViewFocused(false);
      }
      localObject1 = this.sPp;
      if (localObject1 == null) {
        break label266;
      }
      localObject1 = Boolean.valueOf(((o)localObject1).pause());
    }
    for (;;)
    {
      localObject2 = this.sPs;
      if (localObject2 != null) {
        ((b)localObject2).sPA = paramBoolean;
      }
      cMB();
      if (!paramBoolean) {
        this.sPj.clear();
      }
      localObject2 = new StringBuilder("[onEnterSeekMode] isEnter=").append(paramBoolean).append(" ret=").append(localObject1).append(" alpha=");
      o localo = this.sPp;
      localObject1 = localb;
      if (localo != null) {
        localObject1 = Float.valueOf(localo.getAlpha());
      }
      localObject1 = ((StringBuilder)localObject2).append(localObject1).append(" mediaId=");
      localb = this.sPs;
      if (localb == null) {
        d.g.b.p.gfZ();
      }
      ad.i("Finder.VideoLayout", localb.mediaId);
      AppMethodBeat.o(204808);
      return;
      bool = false;
      break;
      label266:
      localObject1 = null;
      continue;
      label271:
      mi(false);
      localObject1 = this.sPp;
      if (localObject1 != null) {
        ((o)localObject1).setVideoViewFocused(true);
      }
      localObject1 = this.sPp;
      if (localObject1 != null) {
        localObject1 = Boolean.valueOf(((o)localObject1).play());
      } else {
        localObject1 = null;
      }
    }
  }
  
  protected final void onDetachedFromWindow()
  {
    int j = 0;
    AppMethodBeat.i(168099);
    super.onDetachedFromWindow();
    Object localObject1 = this.sPs;
    Object localObject2;
    Object localObject3;
    if ((localObject1 != null) && (((b)localObject1).sPA == true))
    {
      localObject1 = this.sPs;
      if ((localObject1 != null) && (((b)localObject1).sPz == true))
      {
        localObject1 = this.sPj;
        localObject2 = this.sPs;
        if (localObject2 == null) {
          d.g.b.p.gfZ();
        }
        localObject2 = ((b)localObject2).mediaId;
        localObject3 = this.sPt;
        if (localObject3 == null) {
          break label215;
        }
      }
    }
    label215:
    for (int i = ((FinderVideoSeekBar)localObject3).getCurrentProgress();; i = 0)
    {
      localObject3 = this.sPp;
      if (localObject3 != null) {
        j = ((o)localObject3).getCurrentPlaySecond();
      }
      d.g.b.p.h(localObject2, "mediaId");
      ad.i("Finder.VideoStateCacheVM", "[store] mediaId=" + (String)localObject2 + " progress=" + i + " timestamp=" + j);
      localObject2 = new FinderVideoStateCacheVM.a((String)localObject2);
      ((FinderVideoStateCacheVM.a)localObject2).progress = i;
      ((FinderVideoStateCacheVM.a)localObject2).taH = j;
      ((FinderVideoStateCacheVM)localObject1).taF = ((FinderVideoStateCacheVM.a)localObject2);
      pause(true);
      localObject1 = this.rWe;
      if (localObject1 == null) {
        break;
      }
      ((com.tencent.mm.plugin.finder.feed.c)localObject1).onDetach();
      AppMethodBeat.o(168099);
      return;
    }
    AppMethodBeat.o(168099);
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(168101);
    d.g.b.p.h(paramView, "child");
    super.onViewAdded(paramView);
    if ((paramView instanceof o))
    {
      ad.i("Finder.VideoLayout", "[onViewAdded] isPreviewing=" + ((o)paramView).cLT() + ' ' + cMy());
      if (((o)paramView).cLT()) {
        setVisibility(0);
      }
    }
    AppMethodBeat.o(168101);
  }
  
  public final void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(168102);
    d.g.b.p.h(paramView, "child");
    super.onViewRemoved(paramView);
    if ((d.g.b.p.i(paramView, this.sPp)) && ((paramView instanceof o)))
    {
      ad.i("Finder.VideoLayout", "[onViewRemoved] isPreviewing=" + ((o)paramView).cLT() + ' ' + cMy());
      FinderVideoSeekBar localFinderVideoSeekBar = this.sPt;
      if (localFinderVideoSeekBar != null) {
        localFinderVideoSeekBar.cMH();
      }
      if (((o)paramView).cLT())
      {
        setVisibility(4);
        AppMethodBeat.o(168102);
        return;
      }
      cMv();
      ckm();
      this.sPp = null;
    }
    AppMethodBeat.o(168102);
  }
  
  public final void play(int paramInt)
  {
    AppMethodBeat.i(168095);
    this.sPu = paramInt;
    if (this.sPs == null)
    {
      AppMethodBeat.o(168095);
      return;
    }
    final b localb = this.sPs;
    if (localb == null) {
      d.g.b.p.gfZ();
    }
    i locali = this.rOe;
    if (locali == null) {
      d.g.b.p.bcb("videoCore");
    }
    locali.cMr().a((ViewGroup)this, localb.slw, (d.g.a.b)new i(this, localb));
    AppMethodBeat.o(168095);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.fMP = paramBoolean;
  }
  
  public final void setPlayAdapterPosition(int paramInt)
  {
    this.sPu = paramInt;
  }
  
  public final void setVideoCore(i parami)
  {
    AppMethodBeat.i(168089);
    d.g.b.p.h(parami, "<set-?>");
    this.rOe = parami;
    AppMethodBeat.o(168089);
  }
  
  public final void setVideoView(o paramo)
  {
    this.sPp = paramo;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$Companion;", "", "()V", "ICON_DISMISS_DURATION", "", "LIMIT_SHOW_PROGRESS", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "mediaId", "", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "position", "", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "isLocal", "", "isFocusPlaying", "isSeekMode", "isHasPlayed", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/loader/FinderVideo;ILjava/util/LinkedList;ZZZZ)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "()Z", "setFocusPlaying", "(Z)V", "setHasPlayed", "setSeekMode", "getMedia", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "getMediaId", "()Ljava/lang/String;", "getMediaList", "()Ljava/util/LinkedList;", "getPosition", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class b
  {
    final boolean dCQ;
    final FinderItem feed;
    final String mediaId;
    final LinkedList<bvf> mediaList;
    private final int position;
    boolean sPA;
    boolean sPB;
    boolean sPz;
    final m slw;
    
    private b(FinderItem paramFinderItem, String paramString, m paramm, int paramInt, LinkedList<bvf> paramLinkedList, boolean paramBoolean)
    {
      AppMethodBeat.i(168053);
      this.feed = paramFinderItem;
      this.mediaId = paramString;
      this.slw = paramm;
      this.position = paramInt;
      this.mediaList = paramLinkedList;
      this.dCQ = paramBoolean;
      this.sPz = false;
      this.sPA = false;
      this.sPB = false;
      AppMethodBeat.o(168053);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(168056);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!d.g.b.p.i(this.feed, paramObject.feed)) || (!d.g.b.p.i(this.mediaId, paramObject.mediaId)) || (!d.g.b.p.i(this.slw, paramObject.slw)) || (this.position != paramObject.position) || (!d.g.b.p.i(this.mediaList, paramObject.mediaList)) || (this.dCQ != paramObject.dCQ) || (this.sPz != paramObject.sPz) || (this.sPA != paramObject.sPA) || (this.sPB != paramObject.sPB)) {}
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
      String str = "PlayInfo(feed=" + this.feed + ", mediaId=" + this.mediaId + ", media=" + this.slw + ", position=" + this.position + ", mediaList=" + this.mediaList + ", isLocal=" + this.dCQ + ", isFocusPlaying=" + this.sPz + ", isSeekMode=" + this.sPA + ", isHasPlayed=" + this.sPB + ")";
      AppMethodBeat.o(168054);
      return str;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<LinearLayout>
  {
    c(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<TextView>
  {
    d(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$bulletSubtitleButton$2$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderVideoLayout.d paramd) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(204789);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoLayout$bulletSubtitleButton$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramView = FinderVideoLayout.j(this.sPD.sPC);
        if (paramView == null) {
          d.g.b.p.gfZ();
        }
        if (!paramView.getFunctionSwitch()) {}
        for (boolean bool = true;; bool = false)
        {
          FinderVideoLayout.p(this.sPD.sPC).setSelected(bool);
          paramView = com.tencent.mm.kernel.g.ajC();
          d.g.b.p.g(paramView, "MMKernel.storage()");
          paramView.ajl().set(al.a.IIP, Boolean.valueOf(bool));
          paramView = FinderVideoLayout.j(this.sPD.sPC);
          if (paramView == null) {
            d.g.b.p.gfZ();
          }
          paramView.N(bool, true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderVideoLayout$bulletSubtitleButton$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(204789);
          return;
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$dismissThumb$1$1"})
  static final class e
    implements Runnable
  {
    e(o paramo, FinderVideoLayout paramFinderVideoLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(168058);
      this.sPE.animate().cancel();
      this.sPE.animate().alpha(1.0F).setDuration(200L).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(221556);
          this.sPF.sPE.setAlpha(1.0F);
          FinderVideoLayout.a(this.sPF.sPC, false);
          AppMethodBeat.o(221556);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(221557);
          FinderVideoLayout.a(this.sPF.sPC, true);
          AppMethodBeat.o(221557);
        }
      }).start();
      AppMethodBeat.o(168058);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/video/FinderVideoLayout$lifecycle$1", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "onBeforePlay", "", "info", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "bgPreparedStatus", "", "onBgPrepared", "onFirstFrameUpdate", "prepareCostTime", "", "onPause", "onPlay", "onPlayProgress", "offset", "total", "onReplay", "onStopPlay", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "plugin-finder_release"})
  public static final class f
    implements u
  {
    public final void Ga(int paramInt)
    {
      AppMethodBeat.i(204796);
      FinderVideoLayout.b localb = FinderVideoLayout.g(this.sPC);
      if (localb != null)
      {
        b.b localb1 = FinderVideoLayout.q(this.sPC);
        if (localb1 != null)
        {
          localb1.a(localb.feed.getId(), localb.slw.siC, this.sPC.getPlayAdapterPosition(), localb.slw, paramInt);
          AppMethodBeat.o(204796);
          return;
        }
        AppMethodBeat.o(204796);
        return;
      }
      AppMethodBeat.o(204796);
    }
    
    public final void b(p paramp)
    {
      AppMethodBeat.i(204795);
      if (paramp != null)
      {
        Object localObject = com.tencent.mm.plugin.finder.storage.logic.c.sAv;
        localObject = com.tencent.mm.plugin.finder.storage.logic.c.aiD(paramp.mediaId);
        if (!((com.tencent.mm.plugin.finder.model.y)localObject).field_hasPlayed)
        {
          ((com.tencent.mm.plugin.finder.model.y)localObject).field_hasPlayed = true;
          com.tencent.mm.ad.c.b(null, (d.g.a.a)new a((com.tencent.mm.plugin.finder.model.y)localObject));
        }
        localObject = FinderVideoLayout.q(this.sPC);
        if (localObject != null)
        {
          ((b.b)localObject).e(paramp.rJP.getId(), paramp.sQp, paramp.rQu);
          AppMethodBeat.o(204795);
          return;
        }
        AppMethodBeat.o(204795);
        return;
      }
      AppMethodBeat.o(204795);
    }
    
    public final void cMC()
    {
      AppMethodBeat.i(168062);
      FinderVideoLayout.b localb = FinderVideoLayout.g(this.sPC);
      if (localb != null)
      {
        b.b localb1 = FinderVideoLayout.q(this.sPC);
        if (localb1 != null)
        {
          localb1.b(localb.feed.getExpectId(), localb.slw.siC, localb.mediaList, localb.slw);
          AppMethodBeat.o(168062);
          return;
        }
        AppMethodBeat.o(168062);
        return;
      }
      AppMethodBeat.o(168062);
    }
    
    public final void cMD()
    {
      AppMethodBeat.i(168063);
      FinderVideoLayout.b localb = FinderVideoLayout.g(this.sPC);
      if (localb != null)
      {
        b.b localb1 = FinderVideoLayout.q(this.sPC);
        if (localb1 != null)
        {
          localb1.d(localb.feed.getExpectId(), localb.slw.siC, localb.slw);
          AppMethodBeat.o(168063);
          return;
        }
        AppMethodBeat.o(168063);
        return;
      }
      AppMethodBeat.o(168063);
    }
    
    public final void cME()
    {
      AppMethodBeat.i(168064);
      FinderVideoLayout.b localb = FinderVideoLayout.g(this.sPC);
      if (localb != null)
      {
        b.b localb1 = FinderVideoLayout.q(this.sPC);
        if (localb1 != null)
        {
          localb1.a(localb.feed.getExpectId(), localb.slw.siC, localb.mediaList, localb.slw);
          AppMethodBeat.o(168064);
          return;
        }
        AppMethodBeat.o(168064);
        return;
      }
      AppMethodBeat.o(168064);
    }
    
    public final void e(bvf parambvf)
    {
      AppMethodBeat.i(204794);
      FinderVideoLayout.a(this.sPC, "onBgPrepared");
      StringBuilder localStringBuilder = new StringBuilder("onBgPrepared ");
      if (parambvf != null)
      {
        String str = parambvf.mediaId;
        parambvf = str;
        if (str != null) {}
      }
      else
      {
        parambvf = "";
      }
      ad.i("Finder.VideoLayout", parambvf);
      AppMethodBeat.o(204794);
    }
    
    public final void fX(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(168065);
      Object localObject = FinderVideoLayout.g(this.sPC);
      if (localObject != null)
      {
        b.b localb = FinderVideoLayout.q(this.sPC);
        if (localb != null) {
          localb.a(((FinderVideoLayout.b)localObject).feed.getExpectId(), ((FinderVideoLayout.b)localObject).slw.siC, paramInt1, paramInt2, ((FinderVideoLayout.b)localObject).slw);
        }
        if (paramInt1 >= 20)
        {
          localObject = FinderVideoLayout.c(this.sPC);
          if ((localObject != null) && (!((FinderVideoSeekBar)localObject).cMJ()))
          {
            localObject = FinderVideoLayout.c(this.sPC);
            if (localObject != null) {
              ((FinderVideoSeekBar)localObject).mk(false);
            }
          }
        }
        FinderVideoLayout.r(this.sPC);
        AppMethodBeat.o(168065);
        return;
      }
      AppMethodBeat.o(168065);
    }
    
    public final void xq(long paramLong)
    {
      AppMethodBeat.i(204797);
      FinderVideoLayout.b localb = FinderVideoLayout.g(this.sPC);
      if (localb != null)
      {
        this.sPC.eT("", localb.mediaId);
        b.b localb1 = FinderVideoLayout.q(this.sPC);
        if (localb1 != null)
        {
          localb1.a(localb.feed.getExpectId(), localb.slw.siC, localb.slw, paramLong);
          AppMethodBeat.o(204797);
          return;
        }
        AppMethodBeat.o(204797);
        return;
      }
      AppMethodBeat.o(204797);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.a<z>
    {
      a(com.tencent.mm.plugin.finder.model.y paramy)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.a<View>
  {
    g(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.a<ImageView>
  {
    h(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.b<o, z>
  {
    i(FinderVideoLayout paramFinderVideoLayout, FinderVideoLayout.b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$prepareToPlay$1$1"})
  static final class j
    extends d.g.b.q
    implements d.g.a.b<o, z>
  {
    j(FinderVideoLayout.b paramb, FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends d.g.b.q
    implements d.g.a.a<View>
  {
    k(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$retryBtn$2$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderVideoLayout.k paramk) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(168076);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoLayout$retryBtn$2$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramView = FinderVideoLayout.g(this.sPI.sPC);
        if ((paramView != null) && (paramView.sPz == true))
        {
          paramView = this.sPI.sPC.getVideoView();
          if (paramView != null) {
            paramView.stop();
          }
          this.sPI.sPC.play(this.sPI.sPC.getPlayAdapterPosition());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderVideoLayout$retryBtn$2$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168076);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/video/FinderVideoLayout$showLoading$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class l
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(221558);
      FinderVideoLayout.m(this.sPC).setAlpha(1.0F);
      FinderVideoLayout.m(this.sPC).setVisibility(0);
      AppMethodBeat.o(221558);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends d.g.b.q
    implements d.g.a.a<ImageView>
  {
    m(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$updateProgress$1$1"})
  static final class n
    implements Runnable
  {
    n(FinderVideoSeekBar paramFinderVideoSeekBar, FinderVideoLayout paramFinderVideoLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(204799);
      Object localObject1 = jdField_this.getVideoView();
      int i;
      label49:
      SeekBar localSeekBar;
      int k;
      int m;
      Object localObject2;
      if (localObject1 != null)
      {
        i = ((o)localObject1).getCurrentPlaySecond();
        localObject1 = jdField_this.getVideoView();
        if (localObject1 == null) {
          break label424;
        }
        j = ((o)localObject1).getVideoDuration();
        if ((!this.sPJ.sPA) && (j > 0) && (FinderVideoLayout.n(jdField_this) == -1.0F) && (FinderVideoLayout.o(jdField_this) != i))
        {
          localObject1 = this.sPJ;
          localSeekBar = ((FinderVideoSeekBar)localObject1).getVideoSeekBar();
          if (localSeekBar != null)
          {
            k = localSeekBar.getMax();
            ((FinderVideoSeekBar)localObject1).cMI();
            float f = 1.0F * (i + 1.3F) / j;
            m = d.h.a.co(k * f);
            localObject2 = ((FinderVideoSeekBar)localObject1).getVideoSeekBar();
            if (localObject2 == null) {
              break label429;
            }
            k = ((SeekBar)localObject2).getProgress();
            label157:
            int n = Math.abs(m - k);
            localObject2 = ((FinderVideoSeekBar)localObject1).getVideoSeekBar();
            if (localObject2 == null) {
              break label435;
            }
            k = ((SeekBar)localObject2).getProgress();
            label186:
            k += Math.max(1, d.h.a.co(n / 76.470589F));
            if (ad.getLogLevel() <= 1) {
              ad.d("Finder.VideoSeekBar", "[setProgress] isWithAnim=true offsetSec=" + i + " allSec=" + j + " target=" + m + " current=" + k + " diff=" + n + " real=" + (m - k));
            }
            if (k - m <= 10) {
              break label441;
            }
            ad.d("Finder.VideoSeekBar", "[updateProgress] reset current=0, current=" + k + ", target=" + m);
          }
        }
      }
      label424:
      label429:
      label435:
      label441:
      for (int j = 0;; j = k)
      {
        localObject2 = ValueAnimator.ofInt(new int[] { j, m });
        ((ValueAnimator)localObject2).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new FinderVideoSeekBar.a(localSeekBar));
        d.g.b.p.g(localObject2, "this");
        ((ValueAnimator)localObject2).setInterpolator((TimeInterpolator)new LinearInterpolator());
        ((ValueAnimator)localObject2).setDuration(1300L);
        ((ValueAnimator)localObject2).start();
        ((FinderVideoSeekBar)localObject1).sPR = ((ValueAnimator)localObject2);
        FinderVideoLayout.a(jdField_this, i);
        AppMethodBeat.o(204799);
        return;
        i = 0;
        break;
        j = 0;
        break label49;
        k = 0;
        break label157;
        k = 0;
        break label186;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class o
    extends d.g.b.q
    implements d.g.a.a<View>
  {
    o(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoLayout
 * JD-Core Version:    0.7.0.1
 */