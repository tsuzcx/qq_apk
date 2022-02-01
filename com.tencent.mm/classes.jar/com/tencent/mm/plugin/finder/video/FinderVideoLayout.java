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
import com.tencent.mm.g.a.pe;
import com.tencent.mm.i.h;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.c.b;
import com.tencent.mm.plugin.finder.event.c.c;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.report.e.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.viewmodel.FinderVideoStateCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderVideoStateCacheVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import d.l;
import d.v;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$SeekBarCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomButtonLayout", "Landroid/view/View;", "getBottomButtonLayout", "()Landroid/view/View;", "bottomButtonLayout$delegate", "Lkotlin/Lazy;", "bulletSubtitleButton", "getBulletSubtitleButton", "bulletSubtitleButton$delegate", "bulletSubtitlePresenter", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitlePresenter;", "bulletSubtitleViewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderBulletSubtitleViewCallback;", "value", "", "isMute", "()Z", "setMute", "(Z)V", "isShowThumbAnimating", "lastCurrentPlaySecond", "lastSeekTime", "", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "loading", "getLoading", "loading$delegate", "muteBtn", "Landroid/widget/ImageView;", "getMuteBtn", "()Landroid/widget/ImageView;", "muteBtn$delegate", "playAdapterPosition", "getPlayAdapterPosition", "()I", "setPlayAdapterPosition", "(I)V", "playInfo", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "getPlayInfo", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "setPlayInfo", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;)V", "retryBtn", "getRetryBtn", "retryBtn$delegate", "seekBarLayout", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar;", "tabType", "thumbView", "getThumbView", "thumbView$delegate", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "getVideoCore", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setVideoCore", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;)V", "videoStateVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM;", "videoTypeIv", "getVideoTypeIv", "videoTypeIv$delegate", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "getVideoView", "()Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "setVideoView", "(Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;)V", "adaptForCropShow", "", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "cancelUpdateProgress", "checkVideoDataAvailable", "mediaId", "", "offset", "length", "convert", "position", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "dismissLoading", "dismissRetryBtn", "dismissThumb", "source", "findBestVideo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getBitmap", "Landroid/graphics/Bitmap;", "getCurrentPosSec", "getVideoDurationSec", "getVideoPlayBehavior", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "isEnableSeek", "isSeekMode", "onDetachedFromWindow", "onEnterSeekMode", "isEnter", "onError", "sessionId", "errorMsg", "what", "extra", "onFinishDownload", "ret", "video", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onGetVideoSize", "width", "height", "onMoovReadyDownload", "total", "onMute", "mute", "onNeedIgnoreTouchEvent", "event", "Landroid/view/MotionEvent;", "onPrepared", "onProgressDownload", "onStartDownload", "onStartSeek", "onStopDownload", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onStopSeek", "percent", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoStopPlay", "onVideoWaiting", "onVideoWaitingEnd", "onViewAdded", "child", "onViewRemoved", "pause", "isForceRemoveVideoView", "play", "prepare", "isLocal", "finderItem", "prepareToPlay", "retryPlay", "showLoading", "showRetryBtn", "showThumb", "showVideoPauseTip", "show", "showVideoTypeIv", "updateProgress", "viewLog", "Companion", "PlayInfo", "plugin-finder_release"})
public final class FinderVideoLayout
  extends FrameLayout
  implements FinderVideoSeekBar.c, q, t, i.b
{
  public static final FinderVideoLayout.a taL;
  private int dvm;
  private boolean fOX;
  public i rWB;
  private final u sZv;
  private com.tencent.mm.plugin.finder.feed.d seK;
  private com.tencent.mm.plugin.finder.feed.c seL;
  private final d.f taA;
  private final d.f taB;
  private o taC;
  private final d.f taD;
  private final d.f taE;
  private b taF;
  private FinderVideoSeekBar taG;
  private int taH;
  private boolean taI;
  private float taJ;
  private int taK;
  private final FinderVideoStateCacheVM taw;
  private final d.f tax;
  private final d.f tay;
  private final d.f taz;
  
  static
  {
    AppMethodBeat.i(168083);
    taL = new FinderVideoLayout.a((byte)0);
    AppMethodBeat.o(168083);
  }
  
  public FinderVideoLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168131);
    setTag("Finder.VideoLayout");
    setId(2131299975);
    paramContext = com.tencent.mm.ui.component.a.KEX;
    paramContext = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoStateCacheVM.class);
    d.g.b.p.g(paramContext, "UICProvider.of(PluginFin…StateCacheVM::class.java)");
    this.taw = ((FinderVideoStateCacheVM)paramContext);
    this.tax = d.g.O((d.g.a.a)new g(this));
    this.tay = d.g.O((d.g.a.a)new c(this));
    this.taz = d.g.O((d.g.a.a)new d(this));
    this.taA = d.g.O((d.g.a.a)new h(this));
    this.taB = d.g.O((d.g.a.a)new m(this));
    this.taD = d.g.O((d.g.a.a)new k(this));
    this.taE = d.g.O((d.g.a.a)new o(this));
    this.sZv = ((u)new f(this));
    this.taJ = -1.0F;
    this.taK = -1;
    AppMethodBeat.o(168131);
  }
  
  public FinderVideoLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168132);
    setTag("Finder.VideoLayout");
    setId(2131299975);
    paramContext = com.tencent.mm.ui.component.a.KEX;
    paramContext = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoStateCacheVM.class);
    d.g.b.p.g(paramContext, "UICProvider.of(PluginFin…StateCacheVM::class.java)");
    this.taw = ((FinderVideoStateCacheVM)paramContext);
    this.tax = d.g.O((d.g.a.a)new g(this));
    this.tay = d.g.O((d.g.a.a)new c(this));
    this.taz = d.g.O((d.g.a.a)new d(this));
    this.taA = d.g.O((d.g.a.a)new h(this));
    this.taB = d.g.O((d.g.a.a)new m(this));
    this.taD = d.g.O((d.g.a.a)new k(this));
    this.taE = d.g.O((d.g.a.a)new o(this));
    this.sZv = ((u)new f(this));
    this.taJ = -1.0F;
    this.taK = -1;
    AppMethodBeat.o(168132);
  }
  
  private final void ake(String paramString)
  {
    AppMethodBeat.i(205431);
    o localo = this.taC;
    if ((localo != null) && (localo.getAlpha() == 1.0F))
    {
      AppMethodBeat.o(205431);
      return;
    }
    if (this.taI)
    {
      AppMethodBeat.o(205431);
      return;
    }
    ae.i("Finder.VideoLayout", "[dismissThumb] " + cPh() + " source=" + paramString + " isShowThumbAnimating=" + this.taI);
    paramString = this.taC;
    if (paramString != null)
    {
      paramString.getVideoView().post((Runnable)new e(paramString, this));
      AppMethodBeat.o(205431);
      return;
    }
    AppMethodBeat.o(205431);
  }
  
  private final boolean cPd()
  {
    FinderVideoSeekBar localFinderVideoSeekBar = this.taG;
    return (localFinderVideoSeekBar != null) && (localFinderVideoSeekBar.taN == true);
  }
  
  private final void cPe()
  {
    AppMethodBeat.i(168119);
    this.taI = false;
    o localo = this.taC;
    if (localo != null) {}
    for (float f = localo.getAlpha(); f == 0.0F; f = 0.0F)
    {
      AppMethodBeat.o(168119);
      return;
    }
    localo = this.taC;
    if (localo != null) {
      localo.setAlpha(0.0F);
    }
    ae.i("Finder.VideoLayout", "[showThumb] " + cPh());
    AppMethodBeat.o(168119);
  }
  
  private final void cPf()
  {
    AppMethodBeat.i(168121);
    getRetryBtn().animate().cancel();
    getRetryBtn().setVisibility(0);
    FinderVideoSeekBar localFinderVideoSeekBar = this.taG;
    if (localFinderVideoSeekBar != null) {
      localFinderVideoSeekBar.setVisibility(8);
    }
    clC();
    AppMethodBeat.o(168121);
  }
  
  private final void cPg()
  {
    AppMethodBeat.i(168122);
    getRetryBtn().animate().cancel();
    FinderVideoSeekBar localFinderVideoSeekBar = this.taG;
    if (localFinderVideoSeekBar != null) {
      localFinderVideoSeekBar.setVisibility(0);
    }
    getRetryBtn().setVisibility(8);
    AppMethodBeat.o(168122);
  }
  
  private final String cPh()
  {
    AppMethodBeat.i(168130);
    Object localObject1 = new StringBuilder().append(hashCode()).append(':');
    Object localObject2 = this.taC;
    int i;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject2 = ((StringBuilder)localObject1).append(i).append(" alpha=");
      localObject1 = this.taC;
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
  
  private final void cPk()
  {
    AppMethodBeat.i(205440);
    FinderVideoSeekBar localFinderVideoSeekBar = this.taG;
    if (localFinderVideoSeekBar != null)
    {
      localFinderVideoSeekBar.cPr();
      AppMethodBeat.o(205440);
      return;
    }
    AppMethodBeat.o(205440);
  }
  
  private final void cei()
  {
    AppMethodBeat.i(205439);
    FinderVideoSeekBar localFinderVideoSeekBar = this.taG;
    if (localFinderVideoSeekBar != null)
    {
      localFinderVideoSeekBar.post((Runnable)new n(localFinderVideoSeekBar, this));
      AppMethodBeat.o(205439);
      return;
    }
    AppMethodBeat.o(205439);
  }
  
  private final void clC()
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
    AppMethodBeat.i(205425);
    View localView = (View)this.tay.getValue();
    AppMethodBeat.o(205425);
    return localView;
  }
  
  private final View getBulletSubtitleButton()
  {
    AppMethodBeat.i(205426);
    View localView = (View)this.taz.getValue();
    AppMethodBeat.o(205426);
    return localView;
  }
  
  private final View getLoading()
  {
    AppMethodBeat.i(168084);
    View localView = (View)this.tax.getValue();
    AppMethodBeat.o(168084);
    return localView;
  }
  
  private final ImageView getMuteBtn()
  {
    AppMethodBeat.i(168086);
    ImageView localImageView = (ImageView)this.taA.getValue();
    AppMethodBeat.o(168086);
    return localImageView;
  }
  
  private final ImageView getThumbView()
  {
    AppMethodBeat.i(168087);
    ImageView localImageView = (ImageView)this.taB.getValue();
    AppMethodBeat.o(168087);
    return localImageView;
  }
  
  private final c.b getVideoPlayBehavior()
  {
    AppMethodBeat.i(168129);
    Object localObject = this.rWB;
    if (localObject == null) {
      d.g.b.p.bdF("videoCore");
    }
    localObject = ((i)localObject).tan;
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
    View localView = (View)this.taE.getValue();
    AppMethodBeat.o(168093);
    return localView;
  }
  
  private final void mn(boolean paramBoolean)
  {
    AppMethodBeat.i(205432);
    if (paramBoolean)
    {
      localObject = com.tencent.mm.kernel.g.ajR();
      d.g.b.p.g(localObject, "MMKernel.storage()");
      paramBoolean = ((com.tencent.mm.kernel.e)localObject).ajA().getBoolean(am.a.Jdu, true);
      getBulletSubtitleButton().setSelected(paramBoolean);
      getBottomButtonLayout().setVisibility(0);
      localObject = this.seK;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.feed.d)localObject).cCI();
        if (localObject != null)
        {
          ((WxRecyclerView)localObject).setAlpha(0.3F);
          AppMethodBeat.o(205432);
          return;
        }
      }
      AppMethodBeat.o(205432);
      return;
    }
    getBottomButtonLayout().setVisibility(8);
    Object localObject = this.seK;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.feed.d)localObject).cCI();
      if (localObject != null)
      {
        ((WxRecyclerView)localObject).setAlpha(1.0F);
        AppMethodBeat.o(205432);
        return;
      }
    }
    AppMethodBeat.o(205432);
  }
  
  private void pause(boolean paramBoolean)
  {
    AppMethodBeat.i(168097);
    Object localObject1 = this.taF;
    if ((localObject1 != null) && (!((b)localObject1).taM))
    {
      AppMethodBeat.o(168097);
      return;
    }
    Object localObject2 = new StringBuilder("[FinderVideoLayout#pause] ").append(cPh()).append(" isForceRemoveVideoView=").append(paramBoolean).append(" isSeekMode=");
    localObject1 = this.taF;
    label114:
    boolean bool;
    if (localObject1 != null)
    {
      localObject1 = Boolean.valueOf(((b)localObject1).taN);
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(' ').append("media=");
      localObject1 = this.taF;
      if (localObject1 == null) {
        break label407;
      }
      localObject1 = ((b)localObject1).mediaId;
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(' ');
      if (ae.getLogLevel() > 1) {
        break label412;
      }
      localObject1 = bu.fpN();
      label138:
      ae.i("Finder.VideoLayout", localObject1);
      localObject1 = this.taF;
      if (localObject1 == null) {
        break label419;
      }
      bool = ((b)localObject1).taN;
      label167:
      localObject1 = this.rWB;
      if (localObject1 == null) {
        d.g.b.p.bdF("videoCore");
      }
      localObject1 = ((i)localObject1).cPa();
      localObject2 = (ViewGroup)this;
      d.g.b.p.h(localObject2, "parent");
      ((Map)((FinderVideoRecycler)localObject1).tol).put(Integer.valueOf(((ViewGroup)localObject2).hashCode()), null);
      localObject2 = ((ViewGroup)localObject2).findViewWithTag(Integer.valueOf(((ViewGroup)localObject2).hashCode()));
      if ((localObject2 instanceof o))
      {
        localObject2 = (o)localObject2;
        ((o)localObject2).setVideoViewFocused(false);
        if ((!bool) && (paramBoolean)) {
          break label424;
        }
        ((o)localObject2).cOO();
        ae.i("Finder.VideoRecycler", "[pauseOrRecycle] pauseWithCancel a videoView(" + localObject2.hashCode() + ") isForceRemove=" + paramBoolean + " isTryKeep=" + bool + " ret=0");
      }
    }
    for (;;)
    {
      clC();
      localObject1 = this.seK;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.finder.feed.d)localObject1).reset(false);
      }
      if (paramBoolean)
      {
        mn(false);
        localObject1 = this.taG;
        if (localObject1 != null) {
          ((FinderVideoSeekBar)localObject1).setSeekMode(false);
        }
      }
      localObject1 = this.taF;
      if (localObject1 != null) {
        ((b)localObject1).taM = false;
      }
      this.taK = -1;
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
    Object localObject = this.taC;
    if (localObject != null) {}
    for (localObject = ((o)localObject).getVideoMediaId();; localObject = null)
    {
      ae.i("Finder.VideoLayout", (String)localObject);
      localObject = this.taC;
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
  
  public final boolean R(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205436);
    d.g.b.p.h(paramMotionEvent, "event");
    if (getBulletSubtitleButton().getVisibility() != 0)
    {
      AppMethodBeat.o(205436);
      return false;
    }
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    ViewParent localViewParent = getBulletSubtitleButton().getParent();
    if (localViewParent == null)
    {
      paramMotionEvent = new v("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(205436);
      throw paramMotionEvent;
    }
    ((View)localViewParent).getHitRect(localRect2);
    getBulletSubtitleButton().getHitRect(localRect1);
    localRect1.top += localRect2.top;
    localRect1.bottom += localRect2.top;
    localRect1.left += localRect2.left;
    localRect1.right += localRect2.left;
    boolean bool = localRect1.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    AppMethodBeat.o(205436);
    return bool;
  }
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    Object localObject2 = null;
    AppMethodBeat.i(168114);
    d.g.b.p.h(paramm, "video");
    StringBuilder localStringBuilder = new StringBuilder("[onMoovReadyDownload] videoView=");
    Object localObject1 = this.taC;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(localObject1.hashCode());
      ae.i("Finder.VideoLayout", localObject1 + "  offset=" + paramInt1 + " total=" + paramInt2 + " video=" + paramm);
      paramm = this.taF;
      if (paramm != null)
      {
        if (!paramm.taM) {
          break label268;
        }
        label111:
        if (paramm != null)
        {
          localObject1 = getVideoPlayBehavior();
          if (localObject1 != null) {
            ((c.b)localObject1).b(paramm.feed.getExpectId(), paramm.suv.srx, paramInt1, paramInt2, paramm.suv);
          }
        }
      }
      paramm = com.tencent.mm.plugin.finder.report.f.syc;
      com.tencent.mm.plugin.finder.report.f.Fi(this.dvm);
      paramm = com.tencent.mm.plugin.finder.report.e.sxO;
      paramm = this.taF;
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
      localObject1 = com.tencent.mm.plugin.finder.report.e.wG(paramm.longValue());
      if ((((e.a)localObject1).sxR <= 0L) || (((e.a)localObject1).sxS != 0L)) {
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
      paramm.sxS = ch.aDc();
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
    Object localObject = this.taC;
    if (localObject != null)
    {
      localObject = Integer.valueOf(localObject.hashCode());
      ae.i("Finder.VideoLayout", localObject + " FinderVideo=" + paramm);
      clC();
      paramm = this.taF;
      if (paramm != null) {
        if (!paramm.taM) {
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
          ((c.b)localObject).a(paramm.feed.getExpectId(), paramm.suv.srx, paramInt, paramd, paramm.suv);
        }
      }
      if (paramInt < 0) {
        cPf();
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
    AppMethodBeat.i(205427);
    d.g.b.p.h(paramFinderItem, "feed");
    ae.i("Finder.VideoLayout", "[convert] position=" + paramInt1 + " feedId=" + paramFinderItem.getExpectId() + " current=" + System.currentTimeMillis() + " feedTime=" + paramFinderItem.getTimestamps() + " urlValidDuration=" + paramFinderItem.getFeedObject().urlValidDuration + 's');
    this.dvm = paramInt2;
    if (paramFinderVideoSeekBar != null) {
      paramFinderVideoSeekBar.setSeekBarCallback((FinderVideoSeekBar.c)this);
    }
    this.taG = paramFinderVideoSeekBar;
    Object localObject3 = paramFinderItem.getMediaList();
    if (paramInt1 >= ((LinkedList)localObject3).size())
    {
      AppMethodBeat.o(205427);
      return;
    }
    Object localObject1 = ((LinkedList)localObject3).get(paramInt1);
    d.g.b.p.g(localObject1, "mediaList[position]");
    bvz localbvz = (bvz)localObject1;
    Object localObject2 = localbvz.mediaId;
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
    localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.b(localbvz);
    ae.i("Finder.VideoLayout", "[findBestVideo] mediaId=" + (String)localObject1 + " videoFlag=" + ((m)localObject2).sry);
    boolean bool;
    if (paramFinderItem.getId() == 0L)
    {
      bool = true;
      this.taF = new b(paramFinderItem, ((m)localObject2).aeM(), (m)localObject2, paramInt1, (LinkedList)localObject3, bool, (byte)0);
      cPe();
      localObject1 = new com.tencent.mm.plugin.finder.loader.g(localbvz, r.sJv);
      localObject3 = com.tencent.mm.plugin.finder.loader.i.srW;
      localObject3 = com.tencent.mm.plugin.finder.loader.i.cEn().bI(localObject1);
      localObject1 = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cJT().value()).intValue() <= 0) {
        break label674;
      }
      localObject1 = new com.tencent.mm.loader.e.d(null, new com.tencent.mm.loader.e.b.g(this), 1);
      label343:
      localObject1 = ((com.tencent.mm.loader.a.b)localObject3).a((com.tencent.mm.loader.f.d)localObject1);
      localObject3 = com.tencent.mm.plugin.finder.loader.i.srW;
      ((com.tencent.mm.loader.b)localObject1).a(com.tencent.mm.plugin.finder.loader.i.a(i.a.srX)).c(getThumbView());
      localObject1 = this.taw.akk(((m)localObject2).aeM());
      if (localObject1 == null) {
        break label680;
      }
      if (paramFinderVideoSeekBar != null) {
        paramFinderVideoSeekBar.mp(true);
      }
      if (paramFinderVideoSeekBar != null) {
        paramFinderVideoSeekBar.setProgress(((FinderVideoStateCacheVM.a)localObject1).progress);
      }
      mn(true);
      if (paramFinderVideoSeekBar != null) {
        paramFinderVideoSeekBar.setSeekMode(true);
      }
      localObject1 = this.taF;
      if (localObject1 != null) {
        ((b)localObject1).taN = true;
      }
      if (paramFinderVideoSeekBar != null) {
        paramFinderVideoSeekBar.setVisibility(0);
      }
      label463:
      if (this.seL != null)
      {
        paramFinderVideoSeekBar = this.seK;
        if (paramFinderVideoSeekBar == null) {
          break label708;
        }
        localObject1 = com.tencent.mm.kernel.g.ajR();
        d.g.b.p.g(localObject1, "MMKernel.storage()");
        paramFinderVideoSeekBar.M(((com.tencent.mm.kernel.e)localObject1).ajA().getBoolean(am.a.Jdu, true), false);
      }
    }
    label674:
    label680:
    label708:
    for (paramFinderVideoSeekBar = d.z.Nhr;; paramFinderVideoSeekBar = null)
    {
      if (paramFinderVideoSeekBar == null)
      {
        paramFinderVideoSeekBar = (FinderVideoLayout)this;
        localObject1 = paramFinderVideoSeekBar.getContext();
        d.g.b.p.g(localObject1, "context");
        paramFinderVideoSeekBar.seL = new com.tencent.mm.plugin.finder.feed.c((Context)localObject1);
        localObject1 = (View)paramFinderVideoSeekBar;
        localObject2 = paramFinderVideoSeekBar.seL;
        if (localObject2 == null) {
          d.g.b.p.gkB();
        }
        paramFinderVideoSeekBar.seK = new com.tencent.mm.plugin.finder.feed.d((View)localObject1, (com.tencent.mm.plugin.finder.feed.c)localObject2);
        localObject1 = paramFinderVideoSeekBar.seL;
        if (localObject1 == null) {
          d.g.b.p.gkB();
        }
        paramFinderVideoSeekBar = paramFinderVideoSeekBar.seK;
        if (paramFinderVideoSeekBar == null) {
          d.g.b.p.gkB();
        }
        ((com.tencent.mm.plugin.finder.feed.c)localObject1).a(paramFinderVideoSeekBar);
        paramFinderVideoSeekBar = d.z.Nhr;
      }
      paramFinderVideoSeekBar = this.seL;
      if (paramFinderVideoSeekBar != null) {
        paramFinderVideoSeekBar.a(paramFinderItem, paramInt2);
      }
      paramFinderItem = getBulletSubtitleButton();
      paramFinderVideoSeekBar = this.seK;
      if (paramFinderVideoSeekBar == null) {
        d.g.b.p.gkB();
      }
      paramFinderItem.setSelected(paramFinderVideoSeekBar.getFunctionSwitch());
      AppMethodBeat.o(205427);
      return;
      bool = false;
      break;
      localObject1 = null;
      break label343;
      ((FinderVideoLayout)this).mn(false);
      if (paramFinderVideoSeekBar != null) {
        paramFinderVideoSeekBar.setSeekMode(false);
      }
      if (paramFinderVideoSeekBar == null) {
        break label463;
      }
      paramFinderVideoSeekBar.cPq();
      break label463;
    }
  }
  
  public final void a(m paramm, h paramh, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(168112);
    d.g.b.p.h(paramm, "video");
    StringBuilder localStringBuilder = new StringBuilder("[onStopDownload] videoView=");
    Object localObject = this.taC;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(localObject.hashCode());; localObject = null)
    {
      ae.i("Finder.VideoLayout", localObject + " FinderVideo=" + paramm + " thumbVisible=" + getThumbView().getVisibility());
      paramm = this.taF;
      if (paramm == null) {
        break label155;
      }
      localObject = getVideoPlayBehavior();
      if (localObject == null) {
        break;
      }
      ((c.b)localObject).a(paramm.feed.getExpectId(), paramm.suv.srx, paramh, paramd, paramm.suv);
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
    paramString = this.taF;
    if (paramString != null)
    {
      if (paramString.taM) {}
      while (paramString != null)
      {
        c.b localb = getVideoPlayBehavior();
        if (localb != null)
        {
          localb.e(paramString.feed.getExpectId(), paramString.suv.srx, paramInt1, paramInt2, paramString.suv);
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
    Object localObject1 = this.taC;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(localObject1.hashCode());
      ae.i("Finder.VideoLayout", localObject1 + " offset=" + paramInt1 + " total=" + paramInt2 + " video=" + paramm.aeM());
      localObject1 = this.taF;
      if (localObject1 != null) {
        if (!((b)localObject1).taM) {
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
          ((c.b)localObject2).c(((b)localObject1).feed.getExpectId(), ((b)localObject1).suv.srx, paramInt1, paramInt2, ((b)localObject1).suv);
        }
      }
      localObject1 = MediaPreloadCore.stL;
      if (MediaPreloadCore.cEO())
      {
        localObject2 = new pe();
        ((pe)localObject2).dEi.mediaId = paramm.srx.mediaId;
        ((pe)localObject2).dEi.process = ((int)(100.0F * paramInt1 / paramInt2));
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
        localObject1 = paramm.srx.mediaId;
        paramm = (m)localObject1;
        if (localObject1 == null) {
          paramm = "";
        }
        paramm = com.tencent.mm.plugin.finder.storage.logic.c.bi(paramm, true);
        ((pe)localObject2).dEi.dEk = paramm.field_fileFormat;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject2);
      }
      AppMethodBeat.o(168115);
      return;
      localObject1 = null;
      break;
      label282:
      localObject1 = null;
    }
  }
  
  public final void b(m paramm)
  {
    Object localObject2 = null;
    AppMethodBeat.i(168111);
    d.g.b.p.h(paramm, "video");
    Object localObject3 = new StringBuilder("[onStartDownload] videoView=");
    Object localObject1 = this.taC;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(localObject1.hashCode());
      ae.i("Finder.VideoLayout", localObject1 + " FinderVideo=" + paramm + " thumbVisible=" + getThumbView().getVisibility());
      cPg();
      paramm = this.taF;
      if (paramm != null) {
        if (!paramm.taM) {
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
          ((c.b)localObject1).f(paramm.feed.getExpectId(), paramm.suv.srx, paramm.suv);
        }
      }
      paramm = com.tencent.mm.plugin.finder.report.f.syc;
      com.tencent.mm.plugin.finder.report.f.Fg(this.dvm);
      localObject1 = com.tencent.mm.plugin.finder.report.e.sxO;
      localObject3 = this.taF;
      paramm = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((b)localObject3).feed;
        paramm = localObject2;
        if (localObject3 != null) {
          paramm = Long.valueOf(((FinderItem)localObject3).getId());
        }
      }
      ((com.tencent.mm.plugin.finder.report.e)localObject1).e(paramm);
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
    AppMethodBeat.i(205435);
    Object localObject2 = new StringBuilder("[seekTo] percent=").append(paramFloat).append(" isSeekMode=").append(cPd()).append(" videoView=");
    Object localObject1 = this.taC;
    label103:
    int j;
    int i;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(localObject1.hashCode());
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(" videoDurationSec=");
      localObject1 = this.taC;
      if (localObject1 == null) {
        break label379;
      }
      localObject1 = Integer.valueOf(((o)localObject1).getVideoDuration());
      ae.i("Finder.VideoLayout", localObject1);
      localObject1 = this.taC;
      if (localObject1 != null)
      {
        j = ((o)localObject1).getCurrentPlaySecond();
        localObject2 = this.taC;
        if (localObject2 == null) {
          break label385;
        }
        i = ((o)localObject2).getVideoDuration();
        label159:
        paramFloat = android.support.v4.b.a.j(i * paramFloat, i - 1.0F);
        double d = paramFloat;
        if (cPd()) {
          break label391;
        }
        label183:
        if ((((o)localObject1).c(d, bool)) && (Math.abs(j - paramFloat) > 1.0F))
        {
          this.taJ = paramFloat;
          localObject2 = new StringBuilder("[seekTo] successfully seek to ").append(paramFloat).append(" videoDurationSec=");
          localObject1 = this.taC;
          if (localObject1 == null) {
            break label397;
          }
          localObject1 = Integer.valueOf(((o)localObject1).getVideoDuration());
          ae.i("Finder.VideoLayout", localObject1);
        }
        label259:
        localObject1 = this.taF;
        if (localObject1 != null) {
          if (!((b)localObject1).taM) {
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
          ((c.b)localObject2).d(((b)localObject1).feed.getExpectId(), ((b)localObject1).suv.srx, j, (int)paramFloat, ((b)localObject1).suv);
        }
      }
      localObject1 = this.taF;
      if (localObject1 == null) {
        break label409;
      }
      if (!((b)localObject1).taN) {
        mn(false);
      }
      AppMethodBeat.o(205435);
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
    AppMethodBeat.o(205435);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168103);
    StringBuilder localStringBuilder = new StringBuilder("[onError] videoView=");
    paramString1 = this.taC;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      ae.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2 + " errorMsg=" + paramString3 + " what=" + paramInt1 + " extra=" + paramInt2);
      paramString1 = this.taG;
      if (paramString1 != null) {
        paramString1.setVisibility(8);
      }
      cPf();
      paramString1 = com.tencent.mm.plugin.finder.report.i.syT;
      com.tencent.mm.plugin.finder.report.i.Fv(paramInt1);
      paramString1 = this.taF;
      if (paramString1 == null) {
        break label179;
      }
      paramString2 = getVideoPlayBehavior();
      if (paramString2 == null) {
        break;
      }
      paramString2.a(paramString1.feed.getExpectId(), paramString1.suv.srx, paramInt1);
      AppMethodBeat.o(168103);
      return;
    }
    AppMethodBeat.o(168103);
    return;
    label179:
    AppMethodBeat.o(168103);
  }
  
  public final void cPc()
  {
    AppMethodBeat.i(205429);
    b localb = this.taF;
    if (localb != null)
    {
      i locali = this.rWB;
      if (locali == null) {
        d.g.b.p.bdF("videoCore");
      }
      locali.cPa().a((ViewGroup)this, localb.suv, (d.g.a.b)new j(localb, this));
      AppMethodBeat.o(205429);
      return;
    }
    AppMethodBeat.o(205429);
  }
  
  public final void cPi()
  {
    AppMethodBeat.i(205434);
    Object localObject = this.taC;
    if (localObject != null) {
      ((o)localObject).pause();
    }
    localObject = this.taF;
    if ((localObject != null) && (!((b)localObject).taN)) {
      mn(true);
    }
    cPk();
    AppMethodBeat.o(205434);
  }
  
  public final boolean cPj()
  {
    b localb = this.taF;
    return (localb != null) && (localb.taM == true);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168106);
    StringBuilder localStringBuilder = new StringBuilder("[onGetVideoSize] videoView=");
    paramString1 = this.taC;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      ae.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2 + " width=" + paramInt1 + " height=" + paramInt2);
      AppMethodBeat.o(168106);
      return;
    }
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    Integer localInteger = null;
    AppMethodBeat.i(168104);
    paramString1 = this.taC;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.getVideoDuration());; paramString1 = null)
    {
      StringBuilder localStringBuilder = new StringBuilder("[onPrepared] videoView=");
      o localo = this.taC;
      if (localo != null) {
        localInteger = Integer.valueOf(localo.hashCode());
      }
      ae.i("Finder.VideoLayout", localInteger + " mediaId=" + paramString2 + " thumbVisible=" + getThumbView().getVisibility() + " duration=" + paramString1);
      AppMethodBeat.o(168104);
      return;
    }
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(168105);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoEnded] videoView=");
    paramString1 = this.taC;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      ae.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      AppMethodBeat.o(168105);
      return;
    }
  }
  
  public final void du(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(168107);
    Object localObject2 = new StringBuilder("[onVideoPause] videoView=");
    paramString1 = this.taC;
    if (paramString1 != null)
    {
      paramString1 = Integer.valueOf(paramString1.hashCode());
      ae.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      clC();
      paramString1 = com.tencent.mm.plugin.finder.report.e.sxO;
      paramString1 = this.taF;
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
      localObject2 = com.tencent.mm.plugin.finder.report.e.wG(paramString1.longValue());
      if ((((e.a)localObject2).sxP <= 0L) || (((e.a)localObject2).sxT != 0L) || (((e.a)localObject2).sxQ != 0L)) {
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
      paramString2.sxQ = ch.aDc();
      com.tencent.mm.plugin.finder.report.e.sxM.add(paramString2);
      com.tencent.mm.plugin.finder.report.e.sxL.remove(paramString1);
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
  
  public final void dv(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(168108);
    paramString1 = this.taC;
    int i;
    Object localObject2;
    if (paramString1 != null)
    {
      i = paramString1.getVideoDuration();
      localObject2 = new StringBuilder("[onVideoPlay] videoView=");
      paramString1 = this.taC;
      if (paramString1 == null) {
        break label223;
      }
      paramString1 = Integer.valueOf(paramString1.hashCode());
      label54:
      paramString2 = ((StringBuilder)localObject2).append(paramString1).append(" mediaId=").append(paramString2).append(" duration=").append(i).append(" isHasPlayed=");
      paramString1 = this.taF;
      if (paramString1 == null) {
        break label228;
      }
    }
    label223:
    label228:
    for (paramString1 = Boolean.valueOf(paramString1.taO);; paramString1 = null)
    {
      ae.i("Finder.VideoLayout", paramString1);
      clC();
      cPg();
      paramString1 = this.taC;
      if (paramString1 != null) {
        paramString1.setKeepScreenOn(true);
      }
      this.taJ = -1.0F;
      cei();
      paramString2 = com.tencent.mm.plugin.finder.report.e.sxO;
      localObject2 = this.taF;
      paramString1 = localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((b)localObject2).feed;
        paramString1 = localObject1;
        if (localObject2 != null) {
          paramString1 = Long.valueOf(((FinderItem)localObject2).getId());
        }
      }
      paramString2.f(paramString1);
      paramString1 = com.tencent.mm.plugin.finder.report.f.syc;
      com.tencent.mm.plugin.finder.report.f.Fj(this.dvm);
      AppMethodBeat.o(168108);
      return;
      i = 0;
      break;
      paramString1 = null;
      break label54;
    }
  }
  
  public final void dw(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(168109);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoWaiting] videoView=");
    Object localObject1 = this.taC;
    if (localObject1 != null) {}
    for (localObject1 = Integer.valueOf(localObject1.hashCode());; localObject1 = null)
    {
      ae.i("Finder.VideoLayout", localObject1 + " mediaId=" + paramString2 + " thumbVisible=" + getThumbView().getVisibility());
      paramString2 = this.taC;
      if (((paramString2 == null) || (paramString2.getVideoViewFocused() != true)) && (paramString1 != null)) {
        break label183;
      }
      showLoading();
      paramString2 = this.taF;
      if (paramString2 == null) {
        break label183;
      }
      paramString1 = localObject2;
      if (paramString2.taM) {
        paramString1 = paramString2;
      }
      if (paramString1 == null) {
        break label183;
      }
      paramString2 = getVideoPlayBehavior();
      if (paramString2 == null) {
        break;
      }
      paramString2.b(paramString1.feed.getExpectId(), paramString1.suv.srx, paramString1.suv);
      AppMethodBeat.o(168109);
      return;
    }
    AppMethodBeat.o(168109);
    return;
    label183:
    AppMethodBeat.o(168109);
  }
  
  public final void dx(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(168110);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoWaitingEnd] videoView=");
    paramString1 = this.taC;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      ae.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      clC();
      paramString2 = this.taF;
      if (paramString2 == null) {
        break label142;
      }
      paramString1 = localObject;
      if (paramString2.taM) {
        paramString1 = paramString2;
      }
      if (paramString1 == null) {
        break label142;
      }
      paramString2 = getVideoPlayBehavior();
      if (paramString2 == null) {
        break;
      }
      paramString2.c(paramString1.feed.getExpectId(), paramString1.suv.srx, paramString1.suv);
      AppMethodBeat.o(168110);
      return;
    }
    AppMethodBeat.o(168110);
    return;
    label142:
    AppMethodBeat.o(168110);
  }
  
  public final void eX(String paramString1, String paramString2)
  {
    Object localObject = null;
    AppMethodBeat.i(205430);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoFirstFrameDraw] videoView=");
    paramString1 = this.taC;
    if (paramString1 != null)
    {
      paramString1 = Integer.valueOf(paramString1.hashCode());
      ae.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      ake("onVideoFirstFrameDraw");
      paramString1 = com.tencent.mm.plugin.finder.report.f.syc;
      com.tencent.mm.plugin.finder.report.f.Fh(this.dvm);
      paramString1 = com.tencent.mm.plugin.finder.report.e.sxO;
      paramString1 = this.taF;
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
      paramString2 = com.tencent.mm.plugin.finder.report.e.wG(paramString1.longValue());
      if (((paramString2.sxR <= 0L) && (paramString2.sxP <= 0L)) || (paramString2.sxT != 0L)) {
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
      paramString1.sxT = ch.aDc();
      com.tencent.mm.plugin.finder.report.e.sxM.add(paramString1);
      com.tencent.mm.plugin.finder.report.e.sxL.clear();
      AppMethodBeat.o(205430);
      return;
      paramString1 = null;
      break;
      paramString1 = null;
      break label111;
      AppMethodBeat.o(205430);
      return;
    }
    label222:
    AppMethodBeat.o(205430);
  }
  
  public final Bitmap getBitmap()
  {
    AppMethodBeat.i(205441);
    Object localObject = this.taC;
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
        AppMethodBeat.o(205441);
        throw ((Throwable)localObject);
      }
      localObject = ((BitmapDrawable)localObject).getBitmap();
    }
    AppMethodBeat.o(205441);
    return localObject;
  }
  
  public final int getCurrentPosSec()
  {
    AppMethodBeat.i(205438);
    o localo = this.taC;
    if (localo != null)
    {
      int i = localo.getCurrentPlaySecond();
      AppMethodBeat.o(205438);
      return i;
    }
    AppMethodBeat.o(205438);
    return 0;
  }
  
  public final u getLifecycle()
  {
    return this.sZv;
  }
  
  public final int getPlayAdapterPosition()
  {
    return this.taH;
  }
  
  public final b getPlayInfo()
  {
    return this.taF;
  }
  
  public final View getRetryBtn()
  {
    AppMethodBeat.i(168092);
    View localView = (View)this.taD.getValue();
    AppMethodBeat.o(168092);
    return localView;
  }
  
  public final i getVideoCore()
  {
    AppMethodBeat.i(168088);
    i locali = this.rWB;
    if (locali == null) {
      d.g.b.p.bdF("videoCore");
    }
    AppMethodBeat.o(168088);
    return locali;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(205437);
    o localo = this.taC;
    if (localo != null)
    {
      int i = localo.getVideoDuration();
      AppMethodBeat.o(205437);
      return i;
    }
    AppMethodBeat.o(205437);
    return 0;
  }
  
  public final o getVideoView()
  {
    return this.taC;
  }
  
  public final void mo(boolean paramBoolean)
  {
    b localb = null;
    AppMethodBeat.i(205433);
    Object localObject1 = this.taC;
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
      localObject1 = this.taF;
      if (localObject1 != null)
      {
        localObject2 = getVideoPlayBehavior();
        if (localObject2 != null) {
          ((c.b)localObject2).a(((b)localObject1).feed.getExpectId(), ((b)localObject1).suv.srx, ((b)localObject1).suv);
        }
      }
      mn(true);
      localObject1 = this.taC;
      if (localObject1 != null) {
        ((o)localObject1).setVideoViewFocused(false);
      }
      localObject1 = this.taC;
      if (localObject1 == null) {
        break label266;
      }
      localObject1 = Boolean.valueOf(((o)localObject1).pause());
    }
    for (;;)
    {
      localObject2 = this.taF;
      if (localObject2 != null) {
        ((b)localObject2).taN = paramBoolean;
      }
      cPk();
      if (!paramBoolean) {
        this.taw.clear();
      }
      localObject2 = new StringBuilder("[onEnterSeekMode] isEnter=").append(paramBoolean).append(" ret=").append(localObject1).append(" alpha=");
      o localo = this.taC;
      localObject1 = localb;
      if (localo != null) {
        localObject1 = Float.valueOf(localo.getAlpha());
      }
      localObject1 = ((StringBuilder)localObject2).append(localObject1).append(" mediaId=");
      localb = this.taF;
      if (localb == null) {
        d.g.b.p.gkB();
      }
      ae.i("Finder.VideoLayout", localb.mediaId);
      AppMethodBeat.o(205433);
      return;
      bool = false;
      break;
      label266:
      localObject1 = null;
      continue;
      label271:
      mn(false);
      localObject1 = this.taC;
      if (localObject1 != null) {
        ((o)localObject1).setVideoViewFocused(true);
      }
      localObject1 = this.taC;
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
    Object localObject1 = this.taF;
    Object localObject2;
    Object localObject3;
    if ((localObject1 != null) && (((b)localObject1).taN == true))
    {
      localObject1 = this.taF;
      if ((localObject1 != null) && (((b)localObject1).taM == true))
      {
        localObject1 = this.taw;
        localObject2 = this.taF;
        if (localObject2 == null) {
          d.g.b.p.gkB();
        }
        localObject2 = ((b)localObject2).mediaId;
        localObject3 = this.taG;
        if (localObject3 == null) {
          break label215;
        }
      }
    }
    label215:
    for (int i = ((FinderVideoSeekBar)localObject3).getCurrentProgress();; i = 0)
    {
      localObject3 = this.taC;
      if (localObject3 != null) {
        j = ((o)localObject3).getCurrentPlaySecond();
      }
      d.g.b.p.h(localObject2, "mediaId");
      ae.i("Finder.VideoStateCacheVM", "[store] mediaId=" + (String)localObject2 + " progress=" + i + " timestamp=" + j);
      localObject2 = new FinderVideoStateCacheVM.a((String)localObject2);
      ((FinderVideoStateCacheVM.a)localObject2).progress = i;
      ((FinderVideoStateCacheVM.a)localObject2).tlv = j;
      ((FinderVideoStateCacheVM)localObject1).tlt = ((FinderVideoStateCacheVM.a)localObject2);
      pause(true);
      localObject1 = this.seL;
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
      ae.i("Finder.VideoLayout", "[onViewAdded] isPreviewing=" + ((o)paramView).cOB() + ' ' + cPh());
      if (((o)paramView).cOB()) {
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
    if ((d.g.b.p.i(paramView, this.taC)) && ((paramView instanceof o)))
    {
      ae.i("Finder.VideoLayout", "[onViewRemoved] isPreviewing=" + ((o)paramView).cOB() + ' ' + cPh());
      FinderVideoSeekBar localFinderVideoSeekBar = this.taG;
      if (localFinderVideoSeekBar != null) {
        localFinderVideoSeekBar.cPq();
      }
      if (((o)paramView).cOB())
      {
        setVisibility(4);
        AppMethodBeat.o(168102);
        return;
      }
      cPe();
      clC();
      this.taC = null;
    }
    AppMethodBeat.o(168102);
  }
  
  public final void play(int paramInt)
  {
    AppMethodBeat.i(168095);
    this.taH = paramInt;
    if (this.taF == null)
    {
      AppMethodBeat.o(168095);
      return;
    }
    final b localb = this.taF;
    if (localb == null) {
      d.g.b.p.gkB();
    }
    i locali = this.rWB;
    if (locali == null) {
      d.g.b.p.bdF("videoCore");
    }
    locali.cPa().a((ViewGroup)this, localb.suv, (d.g.a.b)new i(this, localb));
    AppMethodBeat.o(168095);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.fOX = paramBoolean;
  }
  
  public final void setPlayAdapterPosition(int paramInt)
  {
    this.taH = paramInt;
  }
  
  public final void setPlayInfo(b paramb)
  {
    this.taF = paramb;
  }
  
  public final void setVideoCore(i parami)
  {
    AppMethodBeat.i(168089);
    d.g.b.p.h(parami, "<set-?>");
    this.rWB = parami;
    AppMethodBeat.o(168089);
  }
  
  public final void setVideoView(o paramo)
  {
    this.taC = paramo;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "mediaId", "", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "position", "", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "isLocal", "", "isFocusPlaying", "isSeekMode", "isHasPlayed", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/loader/FinderVideo;ILjava/util/LinkedList;ZZZZ)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "()Z", "setFocusPlaying", "(Z)V", "setHasPlayed", "setSeekMode", "getMedia", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "getMediaId", "()Ljava/lang/String;", "getMediaList", "()Ljava/util/LinkedList;", "getPosition", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class b
  {
    final boolean dDV;
    final FinderItem feed;
    final String mediaId;
    final LinkedList<bvz> mediaList;
    private final int position;
    public final m suv;
    boolean taM;
    boolean taN;
    boolean taO;
    
    private b(FinderItem paramFinderItem, String paramString, m paramm, int paramInt, LinkedList<bvz> paramLinkedList, boolean paramBoolean)
    {
      AppMethodBeat.i(168053);
      this.feed = paramFinderItem;
      this.mediaId = paramString;
      this.suv = paramm;
      this.position = paramInt;
      this.mediaList = paramLinkedList;
      this.dDV = paramBoolean;
      this.taM = false;
      this.taN = false;
      this.taO = false;
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
          if ((!d.g.b.p.i(this.feed, paramObject.feed)) || (!d.g.b.p.i(this.mediaId, paramObject.mediaId)) || (!d.g.b.p.i(this.suv, paramObject.suv)) || (this.position != paramObject.position) || (!d.g.b.p.i(this.mediaList, paramObject.mediaList)) || (this.dDV != paramObject.dDV) || (this.taM != paramObject.taM) || (this.taN != paramObject.taN) || (this.taO != paramObject.taO)) {}
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
      String str = "PlayInfo(feed=" + this.feed + ", mediaId=" + this.mediaId + ", media=" + this.suv + ", position=" + this.position + ", mediaList=" + this.mediaList + ", isLocal=" + this.dDV + ", isFocusPlaying=" + this.taM + ", isSeekMode=" + this.taN + ", isHasPlayed=" + this.taO + ")";
      AppMethodBeat.o(168054);
      return str;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<LinearLayout>
  {
    c(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<TextView>
  {
    d(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$bulletSubtitleButton$2$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderVideoLayout.d paramd) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(205413);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoLayout$bulletSubtitleButton$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramView = FinderVideoLayout.i(this.taQ.taP);
        if (paramView == null) {
          d.g.b.p.gkB();
        }
        if (!paramView.getFunctionSwitch()) {}
        for (boolean bool = true;; bool = false)
        {
          FinderVideoLayout.o(this.taQ.taP).setSelected(bool);
          paramView = com.tencent.mm.kernel.g.ajR();
          d.g.b.p.g(paramView, "MMKernel.storage()");
          paramView.ajA().set(am.a.Jdu, Boolean.valueOf(bool));
          paramView = FinderVideoLayout.i(this.taQ.taP);
          if (paramView == null) {
            d.g.b.p.gkB();
          }
          paramView.M(bool, true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderVideoLayout$bulletSubtitleButton$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(205413);
          return;
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$dismissThumb$1$1"})
  static final class e
    implements Runnable
  {
    e(o paramo, FinderVideoLayout paramFinderVideoLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(168058);
      this.taR.animate().cancel();
      this.taR.animate().alpha(1.0F).setDuration(200L).setListener((Animator.AnimatorListener)new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(205415);
          this.taS.taR.setAlpha(1.0F);
          FinderVideoLayout.a(this.taS.taP, false);
          AppMethodBeat.o(205415);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(205416);
          FinderVideoLayout.a(this.taS.taP, true);
          AppMethodBeat.o(205416);
        }
      }).start();
      AppMethodBeat.o(168058);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/video/FinderVideoLayout$lifecycle$1", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "onBeforePlay", "", "info", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "bgPreparedStatus", "", "onBgPrepared", "onFirstFrameUpdate", "prepareCostTime", "", "onPause", "onPlay", "onPlayProgress", "offset", "total", "onReplay", "onStopPlay", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "plugin-finder_release"})
  public static final class f
    implements u
  {
    public final void GA(int paramInt)
    {
      AppMethodBeat.i(205420);
      FinderVideoLayout.b localb = this.taP.getPlayInfo();
      if (localb != null)
      {
        c.b localb1 = FinderVideoLayout.p(this.taP);
        if (localb1 != null)
        {
          localb1.a(localb.feed.getId(), localb.suv.srx, this.taP.getPlayAdapterPosition(), localb.suv, paramInt);
          AppMethodBeat.o(205420);
          return;
        }
        AppMethodBeat.o(205420);
        return;
      }
      AppMethodBeat.o(205420);
    }
    
    public final void b(p paramp)
    {
      AppMethodBeat.i(205419);
      if (paramp != null)
      {
        Object localObject = com.tencent.mm.plugin.finder.storage.logic.c.sLt;
        localObject = com.tencent.mm.plugin.finder.storage.logic.c.ajA(paramp.mediaId);
        if (!((com.tencent.mm.plugin.finder.model.z)localObject).field_hasPlayed)
        {
          ((com.tencent.mm.plugin.finder.model.z)localObject).field_hasPlayed = true;
          com.tencent.mm.ac.c.b(null, (d.g.a.a)new a((com.tencent.mm.plugin.finder.model.z)localObject));
        }
        localObject = FinderVideoLayout.p(this.taP);
        if (localObject != null)
        {
          ((c.b)localObject).e(paramp.rSd.getId(), paramp.tbA, paramp.rYW);
          AppMethodBeat.o(205419);
          return;
        }
        AppMethodBeat.o(205419);
        return;
      }
      AppMethodBeat.o(205419);
    }
    
    public final void cPl()
    {
      AppMethodBeat.i(168062);
      FinderVideoLayout.b localb = this.taP.getPlayInfo();
      if (localb != null)
      {
        c.b localb1 = FinderVideoLayout.p(this.taP);
        if (localb1 != null)
        {
          localb1.b(localb.feed.getExpectId(), localb.suv.srx, localb.mediaList, localb.suv);
          AppMethodBeat.o(168062);
          return;
        }
        AppMethodBeat.o(168062);
        return;
      }
      AppMethodBeat.o(168062);
    }
    
    public final void cPm()
    {
      AppMethodBeat.i(168063);
      FinderVideoLayout.b localb = this.taP.getPlayInfo();
      if (localb != null)
      {
        c.b localb1 = FinderVideoLayout.p(this.taP);
        if (localb1 != null)
        {
          localb1.d(localb.feed.getExpectId(), localb.suv.srx, localb.suv);
          AppMethodBeat.o(168063);
          return;
        }
        AppMethodBeat.o(168063);
        return;
      }
      AppMethodBeat.o(168063);
    }
    
    public final void cPn()
    {
      AppMethodBeat.i(168064);
      FinderVideoLayout.b localb = this.taP.getPlayInfo();
      if (localb != null)
      {
        c.b localb1 = FinderVideoLayout.p(this.taP);
        if (localb1 != null)
        {
          localb1.a(localb.feed.getExpectId(), localb.suv.srx, localb.mediaList, localb.suv);
          AppMethodBeat.o(168064);
          return;
        }
        AppMethodBeat.o(168064);
        return;
      }
      AppMethodBeat.o(168064);
    }
    
    public final void e(bvz parambvz)
    {
      AppMethodBeat.i(205418);
      FinderVideoLayout.a(this.taP, "onBgPrepared");
      StringBuilder localStringBuilder = new StringBuilder("onBgPrepared ");
      if (parambvz != null)
      {
        String str = parambvz.mediaId;
        parambvz = str;
        if (str != null) {}
      }
      else
      {
        parambvz = "";
      }
      ae.i("Finder.VideoLayout", parambvz);
      AppMethodBeat.o(205418);
    }
    
    public final void fX(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(168065);
      Object localObject = this.taP.getPlayInfo();
      if (localObject != null)
      {
        c.b localb = FinderVideoLayout.p(this.taP);
        if (localb != null) {
          localb.a(((FinderVideoLayout.b)localObject).feed.getExpectId(), ((FinderVideoLayout.b)localObject).suv.srx, paramInt1, paramInt2, ((FinderVideoLayout.b)localObject).suv);
        }
        if (paramInt1 >= 20)
        {
          localObject = FinderVideoLayout.c(this.taP);
          if ((localObject != null) && (!((FinderVideoSeekBar)localObject).cPs()))
          {
            localObject = FinderVideoLayout.c(this.taP);
            if (localObject != null) {
              ((FinderVideoSeekBar)localObject).mp(false);
            }
          }
        }
        FinderVideoLayout.q(this.taP);
        AppMethodBeat.o(168065);
        return;
      }
      AppMethodBeat.o(168065);
    }
    
    public final void xK(long paramLong)
    {
      AppMethodBeat.i(205421);
      FinderVideoLayout.b localb = this.taP.getPlayInfo();
      if (localb != null)
      {
        this.taP.eX("", localb.mediaId);
        c.b localb1 = FinderVideoLayout.p(this.taP);
        if (localb1 != null)
        {
          localb1.a(localb.feed.getExpectId(), localb.suv.srx, localb.suv, paramLong);
          AppMethodBeat.o(205421);
          return;
        }
        AppMethodBeat.o(205421);
        return;
      }
      AppMethodBeat.o(205421);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.a<d.z>
    {
      a(com.tencent.mm.plugin.finder.model.z paramz)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.a<View>
  {
    g(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.a<ImageView>
  {
    h(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.b<o, d.z>
  {
    i(FinderVideoLayout paramFinderVideoLayout, FinderVideoLayout.b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$prepareToPlay$1$1"})
  static final class j
    extends d.g.b.q
    implements d.g.a.b<o, d.z>
  {
    j(FinderVideoLayout.b paramb, FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class k
    extends d.g.b.q
    implements d.g.a.a<View>
  {
    k(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$retryBtn$2$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderVideoLayout.k paramk) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(168076);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoLayout$retryBtn$2$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramView = this.taV.taP.getPlayInfo();
        if ((paramView != null) && (paramView.taM == true))
        {
          paramView = this.taV.taP.getVideoView();
          if (paramView != null) {
            paramView.stop();
          }
          this.taV.taP.play(this.taV.taP.getPlayAdapterPosition());
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderVideoLayout$retryBtn$2$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(168076);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/video/FinderVideoLayout$showLoading$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class l
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(205423);
      FinderVideoLayout.l(this.taP).setAlpha(1.0F);
      FinderVideoLayout.l(this.taP).setVisibility(0);
      AppMethodBeat.o(205423);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends d.g.b.q
    implements d.g.a.a<ImageView>
  {
    m(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$updateProgress$1$1"})
  static final class n
    implements Runnable
  {
    n(FinderVideoSeekBar paramFinderVideoSeekBar, FinderVideoLayout paramFinderVideoLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(205424);
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
        if ((!this.taW.taN) && (j > 0) && (FinderVideoLayout.m(jdField_this) == -1.0F) && (FinderVideoLayout.n(jdField_this) != i))
        {
          localObject1 = this.taW;
          localSeekBar = ((FinderVideoSeekBar)localObject1).getVideoSeekBar();
          if (localSeekBar != null)
          {
            k = localSeekBar.getMax();
            ((FinderVideoSeekBar)localObject1).cPr();
            float f = 1.0F * (i + 1.3F) / j;
            m = d.h.a.cm(k * f);
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
            k += Math.max(1, d.h.a.cm(n / 76.470589F));
            if (ae.getLogLevel() <= 1) {
              ae.d("Finder.VideoSeekBar", "[setProgress] isWithAnim=true offsetSec=" + i + " allSec=" + j + " target=" + m + " current=" + k + " diff=" + n + " real=" + (m - k));
            }
            if (k - m <= 10) {
              break label441;
            }
            ae.d("Finder.VideoSeekBar", "[updateProgress] reset current=0, current=" + k + ", target=" + m);
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
        ((FinderVideoSeekBar)localObject1).tbe = ((ValueAnimator)localObject2);
        FinderVideoLayout.a(jdField_this, i);
        AppMethodBeat.o(205424);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoLayout
 * JD-Core Version:    0.7.0.1
 */