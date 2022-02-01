package com.tencent.mm.plugin.finder.video;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.b.b;
import com.tencent.mm.plugin.finder.event.b.c;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.loader.j;
import com.tencent.mm.plugin.finder.model.r;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.FinderVideoStateCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderVideoStateCacheVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g;
import d.g.b.u;
import d.g.b.w;
import d.y;
import java.util.LinkedList;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$SeekBarCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "isMute", "()Z", "setMute", "(Z)V", "isShowThumbAnimating", "lastCurrentPlaySecond", "lastSeekTime", "", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "loading", "Landroid/view/View;", "getLoading", "()Landroid/view/View;", "loading$delegate", "Lkotlin/Lazy;", "muteBtn", "Landroid/widget/ImageView;", "getMuteBtn", "()Landroid/widget/ImageView;", "muteBtn$delegate", "pauseIcon", "getPauseIcon", "pauseIcon$delegate", "playAdapterPosition", "getPlayAdapterPosition", "()I", "setPlayAdapterPosition", "(I)V", "playInfo", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "retryBtn", "getRetryBtn", "retryBtn$delegate", "seekBarLayout", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar;", "thumbView", "getThumbView", "thumbView$delegate", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "getVideoCore", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setVideoCore", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;)V", "videoStateVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM;", "videoTypeIv", "getVideoTypeIv", "videoTypeIv$delegate", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "getVideoView", "()Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "setVideoView", "(Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;)V", "adaptForCropShow", "", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "cancelUpdateProgress", "checkVideoDataAvailable", "mediaId", "", "offset", "length", "convert", "position", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "dismissLoading", "dismissRetryBtn", "dismissThumb", "source", "findBestVideo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getCurrentPosSec", "getVideoDurationSec", "getVideoPlayBehavior", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "isSeekMode", "onDetachedFromWindow", "onEnterSeekMode", "isEnter", "onError", "sessionId", "errorMsg", "what", "extra", "onFinishDownload", "ret", "video", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onGetVideoSize", "width", "height", "onMoovReadyDownload", "total", "onMute", "mute", "onPrepared", "onProgressDownload", "onStartDownload", "onStartSeek", "onStopDownload", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onStopSeek", "percent", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoStopPlay", "onVideoWaiting", "onVideoWaitingEnd", "onViewAdded", "child", "onViewRemoved", "pause", "isForceRemoveVideoView", "play", "prepare", "isLocal", "finderItem", "retryPlay", "showLoading", "showRetryBtn", "showThumb", "showVideoPauseTip", "show", "showVideoTypeIv", "updateProgress", "viewLog", "Companion", "PlayInfo", "plugin-finder_release"})
public final class FinderVideoLayout
  extends FrameLayout
  implements FinderVideoSeekBar.c, q, s, h.b
{
  public static final a qUf;
  private final t Lck;
  private final FinderVideoStateCacheVM Lcu;
  private final d.f Lcv;
  private o Lcw;
  private FinderVideoSeekBar Lcx;
  private float Lcy;
  private int Lcz;
  private boolean fqj;
  private final d.f qTS;
  private final d.f qTU;
  private final d.f qTV;
  private final d.f qTZ;
  private final d.f qUa;
  private b qUc;
  private int qUd;
  private boolean qUe;
  public c qrq;
  
  static
  {
    AppMethodBeat.i(168083);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(FinderVideoLayout.class), "loading", "getLoading()Landroid/view/View;")), (d.l.k)w.a(new u(w.bk(FinderVideoLayout.class), "pauseIcon", "getPauseIcon()Landroid/view/View;")), (d.l.k)w.a(new u(w.bk(FinderVideoLayout.class), "muteBtn", "getMuteBtn()Landroid/widget/ImageView;")), (d.l.k)w.a(new u(w.bk(FinderVideoLayout.class), "thumbView", "getThumbView()Landroid/widget/ImageView;")), (d.l.k)w.a(new u(w.bk(FinderVideoLayout.class), "retryBtn", "getRetryBtn()Landroid/view/View;")), (d.l.k)w.a(new u(w.bk(FinderVideoLayout.class), "videoTypeIv", "getVideoTypeIv()Landroid/view/View;")) };
    qUf = new a((byte)0);
    AppMethodBeat.o(168083);
  }
  
  public FinderVideoLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168131);
    setTag("Finder.VideoLayout");
    setId(2131299975);
    paramContext = com.tencent.mm.ui.component.a.LCX;
    paramContext = com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderVideoStateCacheVM.class);
    d.g.b.k.g(paramContext, "UICProvider.of(PluginFin…StateCacheVM::class.java)");
    this.Lcu = ((FinderVideoStateCacheVM)paramContext);
    this.qTS = g.E((d.g.a.a)new g(this));
    this.Lcv = g.E((d.g.a.a)new e(this));
    this.qTU = g.E((d.g.a.a)new h(this));
    this.qTV = g.E((d.g.a.a)new r(this));
    this.qTZ = g.E((d.g.a.a)new n(this));
    this.qUa = g.E((d.g.a.a)new s(this));
    this.Lck = ((t)new f(this));
    this.Lcy = -1.0F;
    this.Lcz = -1;
    AppMethodBeat.o(168131);
  }
  
  public FinderVideoLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168132);
    setTag("Finder.VideoLayout");
    setId(2131299975);
    paramContext = com.tencent.mm.ui.component.a.LCX;
    paramContext = com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderVideoStateCacheVM.class);
    d.g.b.k.g(paramContext, "UICProvider.of(PluginFin…StateCacheVM::class.java)");
    this.Lcu = ((FinderVideoStateCacheVM)paramContext);
    this.qTS = g.E((d.g.a.a)new g(this));
    this.Lcv = g.E((d.g.a.a)new e(this));
    this.qTU = g.E((d.g.a.a)new h(this));
    this.qTV = g.E((d.g.a.a)new r(this));
    this.qTZ = g.E((d.g.a.a)new n(this));
    this.qUa = g.E((d.g.a.a)new s(this));
    this.Lck = ((t)new f(this));
    this.Lcy = -1.0F;
    this.Lcz = -1;
    AppMethodBeat.o(168132);
  }
  
  private final void bRa()
  {
    AppMethodBeat.i(199805);
    FinderVideoSeekBar localFinderVideoSeekBar = this.Lcx;
    if (localFinderVideoSeekBar != null)
    {
      localFinderVideoSeekBar.post((Runnable)new i(localFinderVideoSeekBar, this));
      AppMethodBeat.o(199805);
      return;
    }
    AppMethodBeat.o(199805);
  }
  
  private final void bYv()
  {
    AppMethodBeat.i(168123);
    getLoading().animate().cancel();
    if (getLoading().getVisibility() != 8) {
      getLoading().setVisibility(8);
    }
    AppMethodBeat.o(168123);
  }
  
  private final void csm()
  {
    AppMethodBeat.i(168119);
    this.qUe = false;
    o localo = this.Lcw;
    if (localo != null) {}
    for (float f = localo.getAlpha(); f == 0.0F; f = 0.0F)
    {
      AppMethodBeat.o(168119);
      return;
    }
    localo = this.Lcw;
    if (localo != null) {
      localo.setAlpha(0.0F);
    }
    ad.i("Finder.VideoLayout", "[showThumb] " + cst());
    AppMethodBeat.o(168119);
  }
  
  private final void cso()
  {
    AppMethodBeat.i(168121);
    getRetryBtn().animate().cancel();
    getRetryBtn().setVisibility(0);
    FinderVideoSeekBar localFinderVideoSeekBar = this.Lcx;
    if (localFinderVideoSeekBar != null) {
      localFinderVideoSeekBar.setVisibility(8);
    }
    bYv();
    AppMethodBeat.o(168121);
  }
  
  private final void csp()
  {
    AppMethodBeat.i(168122);
    getRetryBtn().animate().cancel();
    FinderVideoSeekBar localFinderVideoSeekBar = this.Lcx;
    if (localFinderVideoSeekBar != null) {
      localFinderVideoSeekBar.setVisibility(0);
    }
    getRetryBtn().setVisibility(8);
    AppMethodBeat.o(168122);
  }
  
  private final String cst()
  {
    AppMethodBeat.i(168130);
    Object localObject1 = new StringBuilder().append(hashCode()).append(':');
    Object localObject2 = this.Lcw;
    int i;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject2 = ((StringBuilder)localObject1).append(i).append(" alpha=");
      localObject1 = this.Lcw;
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
  
  private final boolean fWr()
  {
    FinderVideoSeekBar localFinderVideoSeekBar = this.Lcx;
    return (localFinderVideoSeekBar != null) && (localFinderVideoSeekBar.LcA == true);
  }
  
  private final void fWt()
  {
    AppMethodBeat.i(199806);
    FinderVideoSeekBar localFinderVideoSeekBar = this.Lcx;
    if (localFinderVideoSeekBar != null)
    {
      localFinderVideoSeekBar.fWy();
      AppMethodBeat.o(199806);
      return;
    }
    AppMethodBeat.o(199806);
  }
  
  private final View getLoading()
  {
    AppMethodBeat.i(168084);
    View localView = (View)this.qTS.getValue();
    AppMethodBeat.o(168084);
    return localView;
  }
  
  private final ImageView getMuteBtn()
  {
    AppMethodBeat.i(168086);
    ImageView localImageView = (ImageView)this.qTU.getValue();
    AppMethodBeat.o(168086);
    return localImageView;
  }
  
  private final View getPauseIcon()
  {
    AppMethodBeat.i(199795);
    View localView = (View)this.Lcv.getValue();
    AppMethodBeat.o(199795);
    return localView;
  }
  
  private final ImageView getThumbView()
  {
    AppMethodBeat.i(168087);
    ImageView localImageView = (ImageView)this.qTV.getValue();
    AppMethodBeat.o(168087);
    return localImageView;
  }
  
  private final b.b getVideoPlayBehavior()
  {
    AppMethodBeat.i(168129);
    Object localObject = this.qrq;
    if (localObject == null) {
      d.g.b.k.aPZ("videoCore");
    }
    localObject = ((c)localObject).qTI;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.finder.event.a)localObject).qrY;
      if (localObject != null)
      {
        localObject = (b.b)new b.c((com.tencent.mm.plugin.finder.event.b)localObject);
        AppMethodBeat.o(168129);
        return localObject;
      }
    }
    AppMethodBeat.o(168129);
    return null;
  }
  
  private final View getVideoTypeIv()
  {
    AppMethodBeat.i(168093);
    View localView = (View)this.qUa.getValue();
    AppMethodBeat.o(168093);
    return localView;
  }
  
  private void pause(boolean paramBoolean)
  {
    AppMethodBeat.i(168097);
    Object localObject1 = this.qUc;
    if ((localObject1 != null) && (!((b)localObject1).kQm))
    {
      AppMethodBeat.o(168097);
      return;
    }
    Object localObject2 = new StringBuilder("[FinderVideoLayout#pause] ").append(cst()).append(" isForceRemoveVideoView=").append(paramBoolean).append(" isSeekMode=");
    localObject1 = this.qUc;
    label114:
    boolean bool;
    if (localObject1 != null)
    {
      localObject1 = Boolean.valueOf(((b)localObject1).LcA);
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(' ').append("media=");
      localObject1 = this.qUc;
      if (localObject1 == null) {
        break label398;
      }
      localObject1 = ((b)localObject1).mediaId;
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(' ');
      if (ad.getLogLevel() > 1) {
        break label403;
      }
      localObject1 = bt.eGN();
      label138:
      ad.i("Finder.VideoLayout", localObject1);
      localObject1 = this.qUc;
      if (localObject1 == null) {
        break label410;
      }
      bool = ((b)localObject1).LcA;
      label167:
      localObject1 = this.qrq;
      if (localObject1 == null) {
        d.g.b.k.aPZ("videoCore");
      }
      localObject1 = ((c)localObject1).fWq();
      localObject2 = (ViewGroup)this;
      d.g.b.k.h(localObject2, "parent");
      ((Map)((FinderVideoRecycler)localObject1).LjP).put(Integer.valueOf(((ViewGroup)localObject2).hashCode()), null);
      localObject2 = ((ViewGroup)localObject2).findViewWithTag(Integer.valueOf(((ViewGroup)localObject2).hashCode()));
      if ((localObject2 instanceof o))
      {
        localObject2 = (o)localObject2;
        ((o)localObject2).setVideoViewFocused(false);
        if ((!bool) && (paramBoolean)) {
          break label415;
        }
        ((o)localObject2).csz();
        ad.i("Finder.VideoRecycler", "[pauseOrRecycle] pauseWithCancel a videoView(" + localObject2.hashCode() + ") isForceRemove=" + paramBoolean + " isTryKeep=" + bool);
      }
    }
    for (;;)
    {
      bYv();
      if ((!bool) || (paramBoolean)) {
        csm();
      }
      if (paramBoolean)
      {
        yL(false);
        localObject1 = this.Lcx;
        if (localObject1 != null) {
          ((FinderVideoSeekBar)localObject1).setSeekMode(false);
        }
      }
      localObject1 = this.qUc;
      if (localObject1 != null) {
        ((b)localObject1).kQm = false;
      }
      this.Lcz = -1;
      setKeepScreenOn(false);
      AppMethodBeat.o(168097);
      return;
      localObject1 = null;
      break;
      label398:
      localObject1 = null;
      break label114;
      label403:
      localObject1 = "";
      break label138;
      label410:
      bool = false;
      break label167;
      label415:
      FinderVideoRecycler.a((FinderVideoRecycler)localObject1, (o)localObject2, "pauseAndRecycle");
    }
  }
  
  private final void showLoading()
  {
    AppMethodBeat.i(168124);
    o localo = this.Lcw;
    if (localo != null)
    {
      if (localo.getVideoViewFocused() == true)
      {
        getLoading().setVisibility(0);
        getLoading().setAlpha(0.0F);
        getLoading().animate().alpha(1.0F).setDuration(1000L).withEndAction((Runnable)new o(this)).start();
      }
      AppMethodBeat.o(168124);
      return;
    }
    AppMethodBeat.o(168124);
  }
  
  private final void yL(boolean paramBoolean)
  {
    AppMethodBeat.i(199799);
    if (paramBoolean)
    {
      getPauseIcon().setVisibility(0);
      AppMethodBeat.o(199799);
      return;
    }
    getPauseIcon().setVisibility(8);
    AppMethodBeat.o(199799);
  }
  
  public final void a(int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(168114);
    d.g.b.k.h(paraml, "video");
    StringBuilder localStringBuilder = new StringBuilder("[onMoovReadyDownload] videoView=");
    Object localObject = this.Lcw;
    if (localObject != null)
    {
      localObject = Integer.valueOf(localObject.hashCode());
      ad.i("Finder.VideoLayout", localObject + "  offset=" + paramInt1 + " total=" + paramInt2 + " video=" + paraml);
      paraml = this.qUc;
      if (paraml == null) {
        break label178;
      }
      if (!paraml.kQm) {
        break label166;
      }
    }
    for (;;)
    {
      if (paraml != null)
      {
        localObject = getVideoPlayBehavior();
        if (localObject != null)
        {
          ((b.b)localObject).b(paraml.feed.getExpectId(), "", paraml.qUh.qCj, paramInt1, paramInt2, paraml.qUh);
          AppMethodBeat.o(168114);
          return;
          localObject = null;
          break;
          label166:
          paraml = null;
          continue;
        }
        AppMethodBeat.o(168114);
        return;
      }
    }
    label178:
    AppMethodBeat.o(168114);
  }
  
  public final void a(int paramInt, com.tencent.mm.plugin.finder.loader.l paraml, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(168113);
    d.g.b.k.h(paraml, "video");
    StringBuilder localStringBuilder = new StringBuilder("[onFinishDownload] ret=").append(paramInt).append(" videoView=");
    Object localObject = this.Lcw;
    if (localObject != null)
    {
      localObject = Integer.valueOf(localObject.hashCode());
      ad.i("Finder.VideoLayout", localObject + " FinderVideo=" + paraml);
      bYv();
      paraml = this.qUc;
      if (paraml != null) {
        if (!paraml.kQm) {
          break label168;
        }
      }
    }
    for (;;)
    {
      if (paraml != null)
      {
        localObject = getVideoPlayBehavior();
        if (localObject != null) {
          ((b.b)localObject).a(paraml.feed.getExpectId(), "", paraml.qUh.qCj, paramInt, paramd, paraml.qUh);
        }
      }
      if (paramInt < 0) {
        cso();
      }
      AppMethodBeat.o(168113);
      return;
      localObject = null;
      break;
      label168:
      paraml = null;
    }
  }
  
  public final void a(int paramInt, FinderItem paramFinderItem, FinderVideoSeekBar paramFinderVideoSeekBar)
  {
    AppMethodBeat.i(199796);
    d.g.b.k.h(paramFinderItem, "feed");
    ad.i("Finder.VideoLayout", "[convert] position=" + paramInt + " feedId=" + paramFinderItem.getExpectId() + " current=" + System.currentTimeMillis() + " feedTime=" + paramFinderItem.getTimestamps() + " urlValidDuration=" + paramFinderItem.getFeedObject().urlValidDuration + 's');
    if (paramFinderVideoSeekBar != null) {
      paramFinderVideoSeekBar.setSeekBarCallback((FinderVideoSeekBar.c)this);
    }
    this.Lcx = paramFinderVideoSeekBar;
    Object localObject2 = paramFinderItem.getMediaList();
    if (paramInt >= ((LinkedList)localObject2).size())
    {
      AppMethodBeat.o(199796);
      return;
    }
    Object localObject1 = ((LinkedList)localObject2).get(paramInt);
    d.g.b.k.g(localObject1, "mediaList[position]");
    bmd localbmd = (bmd)localObject1;
    d.g.b.k.g(localbmd.mediaId, "mediaInfo.mediaId");
    localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
    localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.b(localbmd);
    ad.i("Finder.VideoLayout", "[findBestVideo] video=" + ((com.tencent.mm.plugin.finder.loader.l)localObject1).getPath());
    if (paramFinderItem.getId() == 0L) {}
    for (boolean bool = true;; bool = false)
    {
      this.qUc = new b(paramFinderItem, ((com.tencent.mm.plugin.finder.loader.l)localObject1).aaX(), (com.tencent.mm.plugin.finder.loader.l)localObject1, paramInt, (LinkedList)localObject2, bool, (byte)0);
      csm();
      paramFinderItem = new com.tencent.mm.plugin.finder.loader.f(localbmd, com.tencent.mm.plugin.finder.storage.h.qJZ);
      localObject2 = com.tencent.mm.plugin.finder.loader.h.qCF;
      paramFinderItem = com.tencent.mm.plugin.finder.loader.h.cmU().bI(paramFinderItem);
      localObject2 = com.tencent.mm.plugin.finder.loader.h.qCF;
      paramFinderItem.a(com.tencent.mm.plugin.finder.loader.h.a(h.a.qCG)).a((com.tencent.mm.loader.f.d)c.LcC).c(getThumbView());
      paramFinderItem = this.Lcu.aVJ(((com.tencent.mm.plugin.finder.loader.l)localObject1).aaX());
      if (paramFinderItem == null) {
        break label404;
      }
      if (paramFinderVideoSeekBar != null) {
        paramFinderVideoSeekBar.yN(true);
      }
      if (paramFinderVideoSeekBar != null) {
        paramFinderVideoSeekBar.setProgress(paramFinderItem.progress);
      }
      yL(true);
      if (paramFinderVideoSeekBar != null) {
        paramFinderVideoSeekBar.setSeekMode(true);
      }
      paramFinderItem = this.qUc;
      if (paramFinderItem != null) {
        paramFinderItem.LcA = true;
      }
      if (paramFinderVideoSeekBar == null) {
        break;
      }
      paramFinderVideoSeekBar.setVisibility(0);
      AppMethodBeat.o(199796);
      return;
    }
    AppMethodBeat.o(199796);
    return;
    label404:
    ((FinderVideoLayout)this).yL(false);
    if (paramFinderVideoSeekBar != null) {
      paramFinderVideoSeekBar.setSeekMode(false);
    }
    if (paramFinderVideoSeekBar != null)
    {
      paramFinderVideoSeekBar.fWx();
      AppMethodBeat.o(199796);
      return;
    }
    AppMethodBeat.o(199796);
  }
  
  public final void a(com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(168111);
    d.g.b.k.h(paraml, "video");
    StringBuilder localStringBuilder = new StringBuilder("[onStartDownload] videoView=");
    Object localObject = this.Lcw;
    if (localObject != null)
    {
      localObject = Integer.valueOf(localObject.hashCode());
      ad.i("Finder.VideoLayout", localObject + " FinderVideo=" + paraml + " thumbVisible=" + getThumbView().getVisibility());
      csp();
      paraml = this.qUc;
      if (paraml == null) {
        break label165;
      }
      if (!paraml.kQm) {
        break label153;
      }
    }
    for (;;)
    {
      if (paraml != null)
      {
        localObject = getVideoPlayBehavior();
        if (localObject != null)
        {
          ((b.b)localObject).f(paraml.feed.getExpectId(), "", paraml.qUh.qCj, paraml.qUh);
          AppMethodBeat.o(168111);
          return;
          localObject = null;
          break;
          label153:
          paraml = null;
          continue;
        }
        AppMethodBeat.o(168111);
        return;
      }
    }
    label165:
    AppMethodBeat.o(168111);
  }
  
  public final void a(com.tencent.mm.plugin.finder.loader.l paraml, com.tencent.mm.i.h paramh, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(168112);
    d.g.b.k.h(paraml, "video");
    StringBuilder localStringBuilder = new StringBuilder("[onStopDownload] videoView=");
    Object localObject = this.Lcw;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(localObject.hashCode());; localObject = null)
    {
      ad.i("Finder.VideoLayout", localObject + " FinderVideo=" + paraml + " thumbVisible=" + getThumbView().getVisibility());
      paraml = this.qUc;
      if (paraml == null) {
        break label158;
      }
      localObject = getVideoPlayBehavior();
      if (localObject == null) {
        break;
      }
      ((b.b)localObject).a(paraml.feed.getExpectId(), "", paraml.qUh.qCj, paramh, paramd, paraml.qUh);
      AppMethodBeat.o(168112);
      return;
    }
    AppMethodBeat.o(168112);
    return;
    label158:
    AppMethodBeat.o(168112);
  }
  
  public final void aa(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(169678);
    d.g.b.k.h(paramString, "mediaId");
    paramString = this.qUc;
    if (paramString != null)
    {
      if (paramString.kQm) {}
      while (paramString != null)
      {
        b.b localb = getVideoPlayBehavior();
        if (localb != null)
        {
          localb.e(paramString.feed.getExpectId(), "", paramString.qUh.qCj, paramInt1, paramInt2, paramString.qUh);
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
  
  public final void b(int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(168115);
    d.g.b.k.h(paraml, "video");
    StringBuilder localStringBuilder = new StringBuilder("[onProgressDownload] videoView=");
    Object localObject = this.Lcw;
    if (localObject != null)
    {
      localObject = Integer.valueOf(localObject.hashCode());
      ad.i("Finder.VideoLayout", localObject + " offset=" + paramInt1 + " total=" + paramInt2 + " video=" + paraml.aaX());
      paraml = this.qUc;
      if (paraml == null) {
        break label181;
      }
      if (!paraml.kQm) {
        break label169;
      }
    }
    for (;;)
    {
      if (paraml != null)
      {
        localObject = getVideoPlayBehavior();
        if (localObject != null)
        {
          ((b.b)localObject).c(paraml.feed.getExpectId(), "", paraml.qUh.qCj, paramInt1, paramInt2, paraml.qUh);
          AppMethodBeat.o(168115);
          return;
          localObject = null;
          break;
          label169:
          paraml = null;
          continue;
        }
        AppMethodBeat.o(168115);
        return;
      }
    }
    label181:
    AppMethodBeat.o(168115);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168103);
    StringBuilder localStringBuilder = new StringBuilder("[onError] videoView=");
    paramString1 = this.Lcw;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      ad.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2 + " errorMsg=" + paramString3 + " what=" + paramInt1 + " extra=" + paramInt2);
      paramString1 = this.Lcx;
      if (paramString1 != null) {
        paramString1.setVisibility(8);
      }
      cso();
      paramString1 = com.tencent.mm.plugin.finder.report.b.qFq;
      com.tencent.mm.plugin.finder.report.b.CM(paramInt1);
      AppMethodBeat.o(168103);
      return;
    }
  }
  
  public final void ca(float paramFloat)
  {
    boolean bool = true;
    AppMethodBeat.i(199802);
    Object localObject2 = new StringBuilder("[seekTo] percent=").append(paramFloat).append(" isSeekMode=").append(fWr()).append(" videoView=");
    Object localObject1 = this.Lcw;
    label103:
    int j;
    int i;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(localObject1.hashCode());
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(" videoDurationSec=");
      localObject1 = this.Lcw;
      if (localObject1 == null) {
        break label382;
      }
      localObject1 = Integer.valueOf(((o)localObject1).getVideoDuration());
      ad.i("Finder.VideoLayout", localObject1);
      localObject1 = this.Lcw;
      if (localObject1 != null)
      {
        j = ((o)localObject1).getCurrentPlaySecond();
        localObject2 = this.Lcw;
        if (localObject2 == null) {
          break label388;
        }
        i = ((o)localObject2).getVideoDuration();
        label159:
        paramFloat = android.support.v4.b.a.j(i * paramFloat, i - 1.0F);
        double d = paramFloat;
        if (fWr()) {
          break label394;
        }
        label183:
        if ((((o)localObject1).c(d, bool)) && (Math.abs(j - paramFloat) > 1.0F))
        {
          this.Lcy = paramFloat;
          localObject2 = new StringBuilder("[seekTo] successfully seek to ").append(paramFloat).append(" videoDurationSec=");
          localObject1 = this.Lcw;
          if (localObject1 == null) {
            break label400;
          }
          localObject1 = Integer.valueOf(((o)localObject1).getVideoDuration());
          ad.i("Finder.VideoLayout", localObject1);
        }
        label259:
        localObject1 = this.qUc;
        if (localObject1 != null) {
          if (!((b)localObject1).kQm) {
            break label406;
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
          ((b.b)localObject2).d(((b)localObject1).feed.getExpectId(), "", ((b)localObject1).qUh.qCj, j, (int)paramFloat, ((b)localObject1).qUh);
        }
      }
      localObject1 = this.qUc;
      if (localObject1 == null) {
        break label412;
      }
      if (!((b)localObject1).LcA) {
        yL(false);
      }
      AppMethodBeat.o(199802);
      return;
      localObject1 = null;
      break;
      label382:
      localObject1 = null;
      break label103;
      label388:
      i = 1;
      break label159;
      label394:
      bool = false;
      break label183;
      label400:
      localObject1 = null;
      break label259;
      label406:
      localObject1 = null;
    }
    label412:
    AppMethodBeat.o(199802);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168106);
    StringBuilder localStringBuilder = new StringBuilder("[onGetVideoSize] videoView=");
    paramString1 = this.Lcw;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      ad.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2 + " width=" + paramInt1 + " height=" + paramInt2);
      AppMethodBeat.o(168106);
      return;
    }
  }
  
  public final void db(String paramString1, String paramString2)
  {
    Integer localInteger = null;
    AppMethodBeat.i(168104);
    paramString1 = this.Lcw;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.getVideoDuration());; paramString1 = null)
    {
      StringBuilder localStringBuilder = new StringBuilder("[onPrepared] videoView=");
      o localo = this.Lcw;
      if (localo != null) {
        localInteger = Integer.valueOf(localo.hashCode());
      }
      ad.i("Finder.VideoLayout", localInteger + " mediaId=" + paramString2 + " thumbVisible=" + getThumbView().getVisibility() + " duration=" + paramString1);
      AppMethodBeat.o(168104);
      return;
    }
  }
  
  public final void dc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(168105);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoEnded] videoView=");
    paramString1 = this.Lcw;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      ad.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      AppMethodBeat.o(168105);
      return;
    }
  }
  
  public final void dd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(168107);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoPause] videoView=");
    paramString1 = this.Lcw;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      ad.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      bYv();
      AppMethodBeat.o(168107);
      return;
    }
  }
  
  public final void de(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(168108);
    paramString1 = this.Lcw;
    int i;
    Object localObject2;
    if (paramString1 != null)
    {
      i = paramString1.getVideoDuration();
      localObject2 = new StringBuilder("[onVideoPlay] videoView=");
      paramString1 = this.Lcw;
      if (paramString1 == null) {
        break label171;
      }
    }
    label171:
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      paramString2 = ((StringBuilder)localObject2).append(paramString1).append(" mediaId=").append(paramString2).append(" duration=").append(i).append(" isHasPlayed=");
      localObject2 = this.qUc;
      paramString1 = localObject1;
      if (localObject2 != null) {
        paramString1 = Boolean.valueOf(((b)localObject2).LcB);
      }
      ad.i("Finder.VideoLayout", paramString1);
      bYv();
      csp();
      paramString1 = this.Lcw;
      if (paramString1 != null) {
        paramString1.setKeepScreenOn(true);
      }
      this.Lcy = -1.0F;
      bRa();
      AppMethodBeat.o(168108);
      return;
      i = 0;
      break;
    }
  }
  
  public final void dg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(168109);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoWaiting] videoView=");
    Object localObject = this.Lcw;
    if (localObject != null)
    {
      localObject = Integer.valueOf(localObject.hashCode());
      ad.i("Finder.VideoLayout", localObject + " mediaId=" + paramString2 + " thumbVisible=" + getThumbView().getVisibility());
      paramString2 = this.Lcw;
      if (((paramString2 == null) || (paramString2.getVideoViewFocused() != true)) && (paramString1 != null)) {
        break label183;
      }
      showLoading();
      paramString1 = this.qUc;
      if (paramString1 == null) {
        break label183;
      }
      if (!paramString1.kQm) {
        break label171;
      }
    }
    for (;;)
    {
      if (paramString1 != null)
      {
        paramString2 = getVideoPlayBehavior();
        if (paramString2 != null)
        {
          paramString2.b(paramString1.feed.getExpectId(), "", paramString1.qUh.qCj, paramString1.qUh);
          AppMethodBeat.o(168109);
          return;
          localObject = null;
          break;
          label171:
          paramString1 = null;
          continue;
        }
        AppMethodBeat.o(168109);
        return;
      }
    }
    label183:
    AppMethodBeat.o(168109);
  }
  
  public final void dh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(168110);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoWaitingEnd] videoView=");
    paramString1 = this.Lcw;
    if (paramString1 != null)
    {
      paramString1 = Integer.valueOf(paramString1.hashCode());
      ad.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      bYv();
      paramString1 = this.qUc;
      if (paramString1 == null) {
        break label142;
      }
      if (!paramString1.kQm) {
        break label130;
      }
    }
    for (;;)
    {
      if (paramString1 != null)
      {
        paramString2 = getVideoPlayBehavior();
        if (paramString2 != null)
        {
          paramString2.c(paramString1.feed.getExpectId(), "", paramString1.qUh.qCj, paramString1.qUh);
          AppMethodBeat.o(168110);
          return;
          paramString1 = null;
          break;
          label130:
          paramString1 = null;
          continue;
        }
        AppMethodBeat.o(168110);
        return;
      }
    }
    label142:
    AppMethodBeat.o(168110);
  }
  
  public final void fWs()
  {
    AppMethodBeat.i(199801);
    Object localObject = this.Lcw;
    if (localObject != null) {
      ((o)localObject).pause();
    }
    localObject = this.qUc;
    if ((localObject != null) && (!((b)localObject).LcA)) {
      yL(true);
    }
    fWt();
    AppMethodBeat.o(199801);
  }
  
  public final int getCurrentPosSec()
  {
    AppMethodBeat.i(199804);
    o localo = this.Lcw;
    if (localo != null)
    {
      int i = localo.getCurrentPlaySecond();
      AppMethodBeat.o(199804);
      return i;
    }
    AppMethodBeat.o(199804);
    return 0;
  }
  
  public final t getLifecycle()
  {
    return this.Lck;
  }
  
  public final int getPlayAdapterPosition()
  {
    return this.qUd;
  }
  
  public final View getRetryBtn()
  {
    AppMethodBeat.i(168092);
    View localView = (View)this.qTZ.getValue();
    AppMethodBeat.o(168092);
    return localView;
  }
  
  public final c getVideoCore()
  {
    AppMethodBeat.i(168088);
    c localc = this.qrq;
    if (localc == null) {
      d.g.b.k.aPZ("videoCore");
    }
    AppMethodBeat.o(168088);
    return localc;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(199803);
    o localo = this.Lcw;
    if (localo != null)
    {
      int i = localo.getVideoDuration();
      AppMethodBeat.o(199803);
      return i;
    }
    AppMethodBeat.o(199803);
    return 0;
  }
  
  public final o getVideoView()
  {
    return this.Lcw;
  }
  
  public final void jw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(199798);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoFirstFrameDraw] videoView=");
    paramString1 = this.Lcw;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      ad.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      paramString1 = this.Lcw;
      if ((paramString1 == null) || (paramString1.getAlpha() != 1.0F)) {
        break;
      }
      AppMethodBeat.o(199798);
      return;
    }
    if (!this.qUe)
    {
      ad.i("Finder.VideoLayout", "[dismissThumb] " + cst() + " source=" + "onVideoFirstFrameDraw" + " isShowThumbAnimating=" + this.qUe);
      paramString1 = this.Lcw;
      if (paramString1 != null)
      {
        paramString1.getVideoView().post((Runnable)new d(paramString1, this));
        AppMethodBeat.o(199798);
        return;
      }
    }
    AppMethodBeat.o(199798);
  }
  
  protected final void onDetachedFromWindow()
  {
    int j = 0;
    AppMethodBeat.i(168099);
    super.onDetachedFromWindow();
    Object localObject1 = this.qUc;
    Object localObject2;
    Object localObject3;
    if ((localObject1 != null) && (((b)localObject1).LcA == true))
    {
      localObject1 = this.qUc;
      if ((localObject1 != null) && (((b)localObject1).kQm == true))
      {
        localObject1 = this.Lcu;
        localObject2 = this.qUc;
        if (localObject2 == null) {
          d.g.b.k.fvU();
        }
        localObject2 = ((b)localObject2).mediaId;
        localObject3 = this.Lcx;
        if (localObject3 == null) {
          break label202;
        }
      }
    }
    label202:
    for (int i = ((FinderVideoSeekBar)localObject3).getCurrentProgress();; i = 0)
    {
      localObject3 = this.Lcw;
      if (localObject3 != null) {
        j = ((o)localObject3).getCurrentPlaySecond();
      }
      d.g.b.k.h(localObject2, "mediaId");
      ad.i("Finder.VideoStateCacheVM", "[store] mediaId=" + (String)localObject2 + " progress=" + i + " timestamp=" + j);
      localObject2 = new FinderVideoStateCacheVM.a((String)localObject2);
      ((FinderVideoStateCacheVM.a)localObject2).progress = i;
      ((FinderVideoStateCacheVM.a)localObject2).LhD = j;
      ((FinderVideoStateCacheVM)localObject1).LhB = ((FinderVideoStateCacheVM.a)localObject2);
      pause(true);
      AppMethodBeat.o(168099);
      return;
    }
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(168101);
    d.g.b.k.h(paramView, "child");
    super.onViewAdded(paramView);
    if ((paramView instanceof o))
    {
      ad.i("Finder.VideoLayout", "[onViewAdded] isPreviewing=" + ((o)paramView).cPP() + ' ' + cst());
      if (((o)paramView).cPP()) {
        setVisibility(0);
      }
    }
    AppMethodBeat.o(168101);
  }
  
  public final void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(168102);
    d.g.b.k.h(paramView, "child");
    super.onViewRemoved(paramView);
    if ((d.g.b.k.g(paramView, this.Lcw)) && ((paramView instanceof o)))
    {
      ad.i("Finder.VideoLayout", "[onViewRemoved] isPreviewing=" + ((o)paramView).cPP() + ' ' + cst());
      FinderVideoSeekBar localFinderVideoSeekBar = this.Lcx;
      if (localFinderVideoSeekBar != null) {
        localFinderVideoSeekBar.fWx();
      }
      if (((o)paramView).cPP())
      {
        setVisibility(4);
        AppMethodBeat.o(168102);
        return;
      }
      csm();
      bYv();
      this.Lcw = null;
    }
    AppMethodBeat.o(168102);
  }
  
  public final void play(int paramInt)
  {
    AppMethodBeat.i(168095);
    this.qUd = paramInt;
    if (this.qUc == null)
    {
      AppMethodBeat.o(168095);
      return;
    }
    final b localb = this.qUc;
    if (localb == null) {
      d.g.b.k.fvU();
    }
    c localc = this.qrq;
    if (localc == null) {
      d.g.b.k.aPZ("videoCore");
    }
    localc.fWq().a((ViewGroup)this, localb.qUh, (d.g.a.b)new j(this, localb));
    AppMethodBeat.o(168095);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.fqj = paramBoolean;
  }
  
  public final void setPlayAdapterPosition(int paramInt)
  {
    this.qUd = paramInt;
  }
  
  public final void setVideoCore(c paramc)
  {
    AppMethodBeat.i(168089);
    d.g.b.k.h(paramc, "<set-?>");
    this.qrq = paramc;
    AppMethodBeat.o(168089);
  }
  
  public final void setVideoView(o paramo)
  {
    this.Lcw = paramo;
  }
  
  public final void yM(boolean paramBoolean)
  {
    b localb = null;
    AppMethodBeat.i(199800);
    Object localObject1 = this.Lcw;
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
        break label274;
      }
      localObject1 = this.qUc;
      if (localObject1 != null)
      {
        localObject2 = getVideoPlayBehavior();
        if (localObject2 != null) {
          ((b.b)localObject2).a(((b)localObject1).feed.getExpectId(), "", ((b)localObject1).qUh.qCj, ((b)localObject1).qUh);
        }
      }
      yL(true);
      localObject1 = this.Lcw;
      if (localObject1 != null) {
        ((o)localObject1).setVideoViewFocused(false);
      }
      localObject1 = this.Lcw;
      if (localObject1 == null) {
        break label269;
      }
      localObject1 = Boolean.valueOf(((o)localObject1).pause());
    }
    for (;;)
    {
      localObject2 = this.qUc;
      if (localObject2 != null) {
        ((b)localObject2).LcA = paramBoolean;
      }
      fWt();
      if (!paramBoolean) {
        this.Lcu.clear();
      }
      localObject2 = new StringBuilder("[onEnterSeekMode] isEnter=").append(paramBoolean).append(" ret=").append(localObject1).append(" alpha=");
      o localo = this.Lcw;
      localObject1 = localb;
      if (localo != null) {
        localObject1 = Float.valueOf(localo.getAlpha());
      }
      localObject1 = ((StringBuilder)localObject2).append(localObject1).append(" mediaId=");
      localb = this.qUc;
      if (localb == null) {
        d.g.b.k.fvU();
      }
      ad.i("Finder.VideoLayout", localb.mediaId);
      AppMethodBeat.o(199800);
      return;
      bool = false;
      break;
      label269:
      localObject1 = null;
      continue;
      label274:
      yL(false);
      localObject1 = this.Lcw;
      if (localObject1 != null) {
        ((o)localObject1).setVideoViewFocused(true);
      }
      localObject1 = this.Lcw;
      if (localObject1 != null) {
        localObject1 = Boolean.valueOf(((o)localObject1).play());
      } else {
        localObject1 = null;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$Companion;", "", "()V", "ICON_DISMISS_DURATION", "", "LIMIT_SHOW_PROGRESS", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "mediaId", "", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "position", "", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "isLocal", "", "isPlaying", "isSeekMode", "isHasPlayed", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/loader/FinderVideo;ILjava/util/LinkedList;ZZZZ)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "()Z", "setHasPlayed", "(Z)V", "setPlaying", "setSeekMode", "getMedia", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "getMediaId", "()Ljava/lang/String;", "getMediaList", "()Ljava/util/LinkedList;", "getPosition", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class b
  {
    boolean LcA;
    boolean LcB;
    final boolean dtp;
    final FinderItem feed;
    boolean kQm;
    final String mediaId;
    final LinkedList<bmd> mediaList;
    private final int position;
    final com.tencent.mm.plugin.finder.loader.l qUh;
    
    private b(FinderItem paramFinderItem, String paramString, com.tencent.mm.plugin.finder.loader.l paraml, int paramInt, LinkedList<bmd> paramLinkedList, boolean paramBoolean)
    {
      AppMethodBeat.i(168053);
      this.feed = paramFinderItem;
      this.mediaId = paramString;
      this.qUh = paraml;
      this.position = paramInt;
      this.mediaList = paramLinkedList;
      this.dtp = paramBoolean;
      this.kQm = false;
      this.LcA = false;
      this.LcB = false;
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
          if ((!d.g.b.k.g(this.feed, paramObject.feed)) || (!d.g.b.k.g(this.mediaId, paramObject.mediaId)) || (!d.g.b.k.g(this.qUh, paramObject.qUh)) || (this.position != paramObject.position) || (!d.g.b.k.g(this.mediaList, paramObject.mediaList)) || (this.dtp != paramObject.dtp) || (this.kQm != paramObject.kQm) || (this.LcA != paramObject.LcA) || (this.LcB != paramObject.LcB)) {}
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
      String str = "PlayInfo(feed=" + this.feed + ", mediaId=" + this.mediaId + ", media=" + this.qUh + ", position=" + this.position + ", mediaList=" + this.mediaList + ", isLocal=" + this.dtp + ", isPlaying=" + this.kQm + ", isSeekMode=" + this.LcA + ", isHasPlayed=" + this.LcB + ")";
      AppMethodBeat.o(168054);
      return str;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class c<T, R>
    implements com.tencent.mm.loader.f.d<j, Bitmap>
  {
    public static final c LcC;
    
    static
    {
      AppMethodBeat.i(199787);
      LcC = new c();
      AppMethodBeat.o(199787);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$dismissThumb$1$1"})
  static final class d
    implements Runnable
  {
    d(o paramo, FinderVideoLayout paramFinderVideoLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(168058);
      this.LcD.animate().cancel();
      this.LcD.animate().alpha(1.0F).setDuration(200L).withStartAction((Runnable)new FinderVideoLayout.d.1(this)).withEndAction((Runnable)new FinderVideoLayout.d.2(this)).start();
      AppMethodBeat.o(168058);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<TextView>
  {
    e(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/video/FinderVideoLayout$lifecycle$1", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "onBeforePlay", "", "info", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "onFirstFrameUpdate", "onPause", "onPlay", "onPlayProgress", "offset", "", "total", "onReplay", "onStopPlay", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "plugin-finder_release"})
  public static final class f
    implements t
  {
    public final void a(p paramp)
    {
      AppMethodBeat.i(199791);
      if (paramp != null)
      {
        Object localObject = com.tencent.mm.plugin.finder.storage.logic.c.KXF;
        localObject = com.tencent.mm.plugin.finder.storage.logic.c.aVA(paramp.mediaId);
        if (!((r)localObject).field_hasPlayed)
        {
          ((r)localObject).field_hasPlayed = true;
          com.tencent.mm.ad.c.b(null, (d.g.a.a)new a((r)localObject));
        }
        localObject = FinderVideoLayout.f(this.qUi);
        if (localObject != null)
        {
          ((b.b)localObject).e(paramp.qpt.getId(), "", paramp.LcX, paramp.qCU);
          AppMethodBeat.o(199791);
          return;
        }
        AppMethodBeat.o(199791);
        return;
      }
      AppMethodBeat.o(199791);
    }
    
    public final void csu()
    {
      AppMethodBeat.i(168061);
      FinderVideoLayout.b localb = FinderVideoLayout.c(this.qUi);
      if (localb != null)
      {
        this.qUi.jw("", localb.mediaId);
        b.b localb1 = FinderVideoLayout.f(this.qUi);
        if (localb1 != null)
        {
          localb1.c(localb.feed.getExpectId(), localb.feed.getObjectNonceId(), localb.qUh.qCj, localb.mediaList, localb.qUh);
          AppMethodBeat.o(168061);
          return;
        }
        AppMethodBeat.o(168061);
        return;
      }
      AppMethodBeat.o(168061);
    }
    
    public final void csv()
    {
      AppMethodBeat.i(168062);
      FinderVideoLayout.b localb = FinderVideoLayout.c(this.qUi);
      if (localb != null)
      {
        b.b localb1 = FinderVideoLayout.f(this.qUi);
        if (localb1 != null)
        {
          localb1.b(localb.feed.getExpectId(), localb.feed.getObjectNonceId(), localb.qUh.qCj, localb.mediaList, localb.qUh);
          AppMethodBeat.o(168062);
          return;
        }
        AppMethodBeat.o(168062);
        return;
      }
      AppMethodBeat.o(168062);
    }
    
    public final void csw()
    {
      AppMethodBeat.i(168063);
      FinderVideoLayout.b localb = FinderVideoLayout.c(this.qUi);
      if (localb != null)
      {
        b.b localb1 = FinderVideoLayout.f(this.qUi);
        if (localb1 != null)
        {
          localb1.d(localb.feed.getExpectId(), localb.feed.getObjectNonceId(), localb.qUh.qCj, localb.qUh);
          AppMethodBeat.o(168063);
          return;
        }
        AppMethodBeat.o(168063);
        return;
      }
      AppMethodBeat.o(168063);
    }
    
    public final void csx()
    {
      AppMethodBeat.i(168064);
      FinderVideoLayout.b localb = FinderVideoLayout.c(this.qUi);
      if (localb != null)
      {
        b.b localb1 = FinderVideoLayout.f(this.qUi);
        if (localb1 != null)
        {
          localb1.a(localb.feed.getExpectId(), localb.feed.getObjectNonceId(), localb.qUh.qCj, localb.mediaList, localb.qUh);
          AppMethodBeat.o(168064);
          return;
        }
        AppMethodBeat.o(168064);
        return;
      }
      AppMethodBeat.o(168064);
    }
    
    public final void fD(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(168065);
      Object localObject = FinderVideoLayout.c(this.qUi);
      if (localObject != null)
      {
        b.b localb = FinderVideoLayout.f(this.qUi);
        if (localb != null) {
          localb.a(((FinderVideoLayout.b)localObject).feed.getExpectId(), ((FinderVideoLayout.b)localObject).feed.getObjectNonceId(), ((FinderVideoLayout.b)localObject).qUh.qCj, paramInt1, paramInt2, ((FinderVideoLayout.b)localObject).qUh);
        }
        if (paramInt1 >= 20)
        {
          localObject = FinderVideoLayout.i(this.qUi);
          if ((localObject != null) && (!((FinderVideoSeekBar)localObject).fWz()))
          {
            localObject = FinderVideoLayout.i(this.qUi);
            if (localObject != null) {
              ((FinderVideoSeekBar)localObject).yN(false);
            }
          }
        }
        FinderVideoLayout.n(this.qUi);
        AppMethodBeat.o(168065);
        return;
      }
      AppMethodBeat.o(168065);
    }
    
    public final void fWu()
    {
      AppMethodBeat.i(199792);
      FinderVideoLayout.b localb = FinderVideoLayout.c(this.qUi);
      if (localb != null)
      {
        b.b localb1 = FinderVideoLayout.f(this.qUi);
        if (localb1 != null)
        {
          localb1.a(localb.feed.getId(), localb.feed.getObjectNonceId(), localb.qUh.qCj, localb.mediaList, this.qUi.getPlayAdapterPosition(), localb.qUh);
          AppMethodBeat.o(199792);
          return;
        }
        AppMethodBeat.o(199792);
        return;
      }
      AppMethodBeat.o(199792);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(r paramr)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    g(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<ImageView>
  {
    h(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$updateProgress$1$1"})
  static final class i
    implements Runnable
  {
    i(FinderVideoSeekBar paramFinderVideoSeekBar, FinderVideoLayout paramFinderVideoLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(199794);
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
        if ((!this.LcH.LcA) && (j > 0) && (FinderVideoLayout.l(jdField_this) == -1.0F) && (FinderVideoLayout.m(jdField_this) != i))
        {
          localObject1 = this.LcH;
          localSeekBar = ((FinderVideoSeekBar)localObject1).getVideoSeekBar();
          if (localSeekBar != null)
          {
            k = localSeekBar.getMax();
            ((FinderVideoSeekBar)localObject1).fWy();
            float f = 1.0F * (i + 1.3F) / j;
            m = d.h.a.bU(k * f);
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
            k += Math.max(1, d.h.a.bU(n / 76.470589F));
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
        d.g.b.k.g(localObject2, "this");
        ((ValueAnimator)localObject2).setInterpolator((TimeInterpolator)new LinearInterpolator());
        ((ValueAnimator)localObject2).setDuration(1300L);
        ((ValueAnimator)localObject2).start();
        ((FinderVideoSeekBar)localObject1).LcO = ((ValueAnimator)localObject2);
        FinderVideoLayout.a(jdField_this, i);
        AppMethodBeat.o(199794);
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.b<o, y>
  {
    j(FinderVideoLayout paramFinderVideoLayout, FinderVideoLayout.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    n(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$retryBtn$2$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderVideoLayout.n paramn) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(168076);
        paramView = this.qUr.qUi.getVideoView();
        if (paramView != null) {
          paramView.stop();
        }
        this.qUr.qUi.play(this.qUr.qUi.getPlayAdapterPosition());
        AppMethodBeat.o(168076);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(FinderVideoLayout paramFinderVideoLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(168078);
      FinderVideoLayout.h(this.qUi).setAlpha(1.0F);
      FinderVideoLayout.h(this.qUi).setVisibility(0);
      AppMethodBeat.o(168078);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class r
    extends d.g.b.l
    implements d.g.a.a<ImageView>
  {
    r(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class s
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    s(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoLayout
 * JD-Core Version:    0.7.0.1
 */