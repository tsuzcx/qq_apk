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
import com.tencent.mm.g.a.ou;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.b.b;
import com.tencent.mm.plugin.finder.event.b.c;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.loader.j;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.plugin.finder.viewmodel.FinderVideoStateCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderVideoStateCacheVM.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g;
import d.y;
import java.util.LinkedList;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar$SeekBarCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "isMute", "()Z", "setMute", "(Z)V", "isShowThumbAnimating", "lastCurrentPlaySecond", "lastSeekTime", "", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "loading", "Landroid/view/View;", "getLoading", "()Landroid/view/View;", "loading$delegate", "Lkotlin/Lazy;", "muteBtn", "Landroid/widget/ImageView;", "getMuteBtn", "()Landroid/widget/ImageView;", "muteBtn$delegate", "pauseIcon", "getPauseIcon", "pauseIcon$delegate", "playAdapterPosition", "getPlayAdapterPosition", "()I", "setPlayAdapterPosition", "(I)V", "playInfo", "Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "retryBtn", "getRetryBtn", "retryBtn$delegate", "seekBarLayout", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar;", "thumbView", "getThumbView", "thumbView$delegate", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "getVideoCore", "()Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setVideoCore", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;)V", "videoStateVM", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderVideoStateCacheVM;", "videoTypeIv", "getVideoTypeIv", "videoTypeIv$delegate", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "getVideoView", "()Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "setVideoView", "(Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;)V", "adaptForCropShow", "", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "cancelUpdateProgress", "checkVideoDataAvailable", "mediaId", "", "offset", "length", "convert", "position", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "dismissLoading", "dismissRetryBtn", "dismissThumb", "source", "findBestVideo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getCurrentPosSec", "getVideoDurationSec", "getVideoPlayBehavior", "Lcom/tencent/mm/plugin/finder/event/PlayEventSubscriber$VideoPlayBehavior;", "isSeekMode", "onDetachedFromWindow", "onEnterSeekMode", "isEnter", "onError", "sessionId", "errorMsg", "what", "extra", "onFinishDownload", "ret", "video", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onGetVideoSize", "width", "height", "onMoovReadyDownload", "total", "onMute", "mute", "onPrepared", "onProgressDownload", "onStartDownload", "onStartSeek", "onStopDownload", "taskInfo", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "onStopSeek", "percent", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoStopPlay", "onVideoWaiting", "onVideoWaitingEnd", "onViewAdded", "child", "onViewRemoved", "pause", "isForceRemoveVideoView", "play", "prepare", "isLocal", "finderItem", "prepareToPlay", "retryPlay", "showLoading", "showRetryBtn", "showThumb", "showVideoPauseTip", "show", "showVideoTypeIv", "updateProgress", "viewLog", "Companion", "PlayInfo", "plugin-finder_release"})
public final class FinderVideoLayout
  extends FrameLayout
  implements FinderVideoSeekBar.c, q, t, h.b
{
  public static final FinderVideoLayout.a rSP;
  private boolean ftN;
  private final u rRI;
  private final FinderVideoStateCacheVM rSB;
  private final d.f rSC;
  private final d.f rSD;
  private final d.f rSE;
  private final d.f rSF;
  private o rSG;
  private final d.f rSH;
  private final d.f rSI;
  private b rSJ;
  private FinderVideoSeekBar rSK;
  private int rSL;
  private boolean rSM;
  private float rSN;
  private int rSO;
  public i rbo;
  
  static
  {
    AppMethodBeat.i(168083);
    $$delegatedProperties = new d.l.k[] { (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(FinderVideoLayout.class), "loading", "getLoading()Landroid/view/View;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(FinderVideoLayout.class), "pauseIcon", "getPauseIcon()Landroid/view/View;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(FinderVideoLayout.class), "muteBtn", "getMuteBtn()Landroid/widget/ImageView;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(FinderVideoLayout.class), "thumbView", "getThumbView()Landroid/widget/ImageView;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(FinderVideoLayout.class), "retryBtn", "getRetryBtn()Landroid/view/View;")), (d.l.k)d.g.b.w.a(new d.g.b.u(d.g.b.w.bn(FinderVideoLayout.class), "videoTypeIv", "getVideoTypeIv()Landroid/view/View;")) };
    rSP = new FinderVideoLayout.a((byte)0);
    AppMethodBeat.o(168083);
  }
  
  public FinderVideoLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168131);
    setTag("Finder.VideoLayout");
    setId(2131299975);
    paramContext = com.tencent.mm.ui.component.a.IrY;
    paramContext = com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderVideoStateCacheVM.class);
    d.g.b.k.g(paramContext, "UICProvider.of(PluginFin…StateCacheVM::class.java)");
    this.rSB = ((FinderVideoStateCacheVM)paramContext);
    this.rSC = g.K((d.g.a.a)new f(this));
    this.rSD = g.K((d.g.a.a)new h(this));
    this.rSE = g.K((d.g.a.a)new g(this));
    this.rSF = g.K((d.g.a.a)new l(this));
    this.rSH = g.K((d.g.a.a)new j(this));
    this.rSI = g.K((d.g.a.a)new n(this));
    this.rRI = ((u)new e(this));
    this.rSN = -1.0F;
    this.rSO = -1;
    AppMethodBeat.o(168131);
  }
  
  public FinderVideoLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168132);
    setTag("Finder.VideoLayout");
    setId(2131299975);
    paramContext = com.tencent.mm.ui.component.a.IrY;
    paramContext = com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderVideoStateCacheVM.class);
    d.g.b.k.g(paramContext, "UICProvider.of(PluginFin…StateCacheVM::class.java)");
    this.rSB = ((FinderVideoStateCacheVM)paramContext);
    this.rSC = g.K((d.g.a.a)new f(this));
    this.rSD = g.K((d.g.a.a)new h(this));
    this.rSE = g.K((d.g.a.a)new g(this));
    this.rSF = g.K((d.g.a.a)new l(this));
    this.rSH = g.K((d.g.a.a)new j(this));
    this.rSI = g.K((d.g.a.a)new n(this));
    this.rRI = ((u)new e(this));
    this.rSN = -1.0F;
    this.rSO = -1;
    AppMethodBeat.o(168132);
  }
  
  private final void bYp()
  {
    AppMethodBeat.i(203869);
    FinderVideoSeekBar localFinderVideoSeekBar = this.rSK;
    if (localFinderVideoSeekBar != null)
    {
      localFinderVideoSeekBar.post((Runnable)new m(localFinderVideoSeekBar, this));
      AppMethodBeat.o(203869);
      return;
    }
    AppMethodBeat.o(203869);
  }
  
  private final boolean cDZ()
  {
    FinderVideoSeekBar localFinderVideoSeekBar = this.rSK;
    return (localFinderVideoSeekBar != null) && (localFinderVideoSeekBar.rSQ == true);
  }
  
  private final void cEa()
  {
    AppMethodBeat.i(168119);
    this.rSM = false;
    o localo = this.rSG;
    if (localo != null) {}
    for (float f = localo.getAlpha(); f == 0.0F; f = 0.0F)
    {
      AppMethodBeat.o(168119);
      return;
    }
    localo = this.rSG;
    if (localo != null) {
      localo.setAlpha(0.0F);
    }
    ac.i("Finder.VideoLayout", "[showThumb] " + cEd());
    AppMethodBeat.o(168119);
  }
  
  private final void cEb()
  {
    AppMethodBeat.i(168121);
    getRetryBtn().animate().cancel();
    getRetryBtn().setVisibility(0);
    FinderVideoSeekBar localFinderVideoSeekBar = this.rSK;
    if (localFinderVideoSeekBar != null) {
      localFinderVideoSeekBar.setVisibility(8);
    }
    cfJ();
    AppMethodBeat.o(168121);
  }
  
  private final void cEc()
  {
    AppMethodBeat.i(168122);
    getRetryBtn().animate().cancel();
    FinderVideoSeekBar localFinderVideoSeekBar = this.rSK;
    if (localFinderVideoSeekBar != null) {
      localFinderVideoSeekBar.setVisibility(0);
    }
    getRetryBtn().setVisibility(8);
    AppMethodBeat.o(168122);
  }
  
  private final String cEd()
  {
    AppMethodBeat.i(168130);
    Object localObject1 = new StringBuilder().append(hashCode()).append(':');
    Object localObject2 = this.rSG;
    int i;
    if (localObject2 != null)
    {
      i = localObject2.hashCode();
      localObject2 = ((StringBuilder)localObject1).append(i).append(" alpha=");
      localObject1 = this.rSG;
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
  
  private final void cEf()
  {
    AppMethodBeat.i(203870);
    FinderVideoSeekBar localFinderVideoSeekBar = this.rSK;
    if (localFinderVideoSeekBar != null)
    {
      localFinderVideoSeekBar.cEo();
      AppMethodBeat.o(203870);
      return;
    }
    AppMethodBeat.o(203870);
  }
  
  private final void cfJ()
  {
    AppMethodBeat.i(168123);
    getLoading().animate().cancel();
    if (getLoading().getVisibility() != 8) {
      getLoading().setVisibility(8);
    }
    AppMethodBeat.o(168123);
  }
  
  private final View getLoading()
  {
    AppMethodBeat.i(168084);
    View localView = (View)this.rSC.getValue();
    AppMethodBeat.o(168084);
    return localView;
  }
  
  private final ImageView getMuteBtn()
  {
    AppMethodBeat.i(168086);
    ImageView localImageView = (ImageView)this.rSE.getValue();
    AppMethodBeat.o(168086);
    return localImageView;
  }
  
  private final View getPauseIcon()
  {
    AppMethodBeat.i(203859);
    View localView = (View)this.rSD.getValue();
    AppMethodBeat.o(203859);
    return localView;
  }
  
  private final ImageView getThumbView()
  {
    AppMethodBeat.i(168087);
    ImageView localImageView = (ImageView)this.rSF.getValue();
    AppMethodBeat.o(168087);
    return localImageView;
  }
  
  private final b.b getVideoPlayBehavior()
  {
    AppMethodBeat.i(168129);
    Object localObject = this.rbo;
    if (localObject == null) {
      d.g.b.k.aVY("videoCore");
    }
    localObject = ((i)localObject).rSs;
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
    View localView = (View)this.rSI.getValue();
    AppMethodBeat.o(168093);
    return localView;
  }
  
  private final void lQ(boolean paramBoolean)
  {
    AppMethodBeat.i(203863);
    if (paramBoolean)
    {
      getPauseIcon().setVisibility(0);
      AppMethodBeat.o(203863);
      return;
    }
    getPauseIcon().setVisibility(8);
    AppMethodBeat.o(203863);
  }
  
  private void pause(boolean paramBoolean)
  {
    AppMethodBeat.i(168097);
    Object localObject1 = this.rSJ;
    if ((localObject1 != null) && (!((b)localObject1).lrL))
    {
      AppMethodBeat.o(168097);
      return;
    }
    Object localObject2 = new StringBuilder("[FinderVideoLayout#pause] ").append(cEd()).append(" isForceRemoveVideoView=").append(paramBoolean).append(" isSeekMode=");
    localObject1 = this.rSJ;
    label114:
    boolean bool;
    if (localObject1 != null)
    {
      localObject1 = Boolean.valueOf(((b)localObject1).rSQ);
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(' ').append("media=");
      localObject1 = this.rSJ;
      if (localObject1 == null) {
        break label393;
      }
      localObject1 = ((b)localObject1).mediaId;
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(' ');
      if (ac.getLogLevel() > 1) {
        break label398;
      }
      localObject1 = bs.eWi();
      label138:
      ac.i("Finder.VideoLayout", localObject1);
      localObject1 = this.rSJ;
      if (localObject1 == null) {
        break label405;
      }
      bool = ((b)localObject1).rSQ;
      label167:
      localObject1 = this.rbo;
      if (localObject1 == null) {
        d.g.b.k.aVY("videoCore");
      }
      localObject1 = ((i)localObject1).cDX();
      localObject2 = (ViewGroup)this;
      d.g.b.k.h(localObject2, "parent");
      ((Map)((FinderVideoRecycler)localObject1).sfw).put(Integer.valueOf(((ViewGroup)localObject2).hashCode()), null);
      localObject2 = ((ViewGroup)localObject2).findViewWithTag(Integer.valueOf(((ViewGroup)localObject2).hashCode()));
      if ((localObject2 instanceof o))
      {
        localObject2 = (o)localObject2;
        ((o)localObject2).setVideoViewFocused(false);
        if ((!bool) && (paramBoolean)) {
          break label410;
        }
        ((o)localObject2).cDN();
        ac.i("Finder.VideoRecycler", "[pauseOrRecycle] pauseWithCancel a videoView(" + localObject2.hashCode() + ") isForceRemove=" + paramBoolean + " isTryKeep=" + bool + " ret=0");
      }
    }
    for (;;)
    {
      cfJ();
      if (paramBoolean)
      {
        lQ(false);
        localObject1 = this.rSK;
        if (localObject1 != null) {
          ((FinderVideoSeekBar)localObject1).setSeekMode(false);
        }
      }
      localObject1 = this.rSJ;
      if (localObject1 != null) {
        ((b)localObject1).lrL = false;
      }
      this.rSO = -1;
      setKeepScreenOn(false);
      AppMethodBeat.o(168097);
      return;
      localObject1 = null;
      break;
      label393:
      localObject1 = null;
      break label114;
      label398:
      localObject1 = "";
      break label138;
      label405:
      bool = false;
      break label167;
      label410:
      ((FinderVideoRecycler)localObject1).a((o)localObject2, "pauseAndRecycle");
    }
  }
  
  private final void showLoading()
  {
    AppMethodBeat.i(168124);
    o localo = this.rSG;
    if (localo != null)
    {
      if (localo.getVideoViewFocused() == true)
      {
        getLoading().setVisibility(0);
        getLoading().setAlpha(0.0F);
        getLoading().animate().alpha(1.0F).setDuration(1000L).withEndAction((Runnable)new k(this)).start();
      }
      AppMethodBeat.o(168124);
      return;
    }
    AppMethodBeat.o(168124);
  }
  
  public final void a(int paramInt1, int paramInt2, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(168114);
    d.g.b.k.h(paraml, "video");
    StringBuilder localStringBuilder = new StringBuilder("[onMoovReadyDownload] videoView=");
    Object localObject = this.rSG;
    if (localObject != null)
    {
      localObject = Integer.valueOf(localObject.hashCode());
      ac.i("Finder.VideoLayout", localObject + "  offset=" + paramInt1 + " total=" + paramInt2 + " video=" + paraml);
      paraml = this.rSJ;
      if (paraml == null) {
        break label178;
      }
      if (!paraml.lrL) {
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
          ((b.b)localObject).b(paraml.feed.getExpectId(), "", paraml.rvQ.rtl, paramInt1, paramInt2, paraml.rvQ);
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
    Object localObject = this.rSG;
    if (localObject != null)
    {
      localObject = Integer.valueOf(localObject.hashCode());
      ac.i("Finder.VideoLayout", localObject + " FinderVideo=" + paraml);
      cfJ();
      paraml = this.rSJ;
      if (paraml != null) {
        if (!paraml.lrL) {
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
          ((b.b)localObject).a(paraml.feed.getExpectId(), "", paraml.rvQ.rtl, paramInt, paramd, paraml.rvQ);
        }
      }
      if (paramInt < 0) {
        cEb();
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
    AppMethodBeat.i(203860);
    d.g.b.k.h(paramFinderItem, "feed");
    ac.i("Finder.VideoLayout", "[convert] position=" + paramInt + " feedId=" + paramFinderItem.getExpectId() + " current=" + System.currentTimeMillis() + " feedTime=" + paramFinderItem.getTimestamps() + " urlValidDuration=" + paramFinderItem.getFeedObject().urlValidDuration + 's');
    if (paramFinderVideoSeekBar != null) {
      paramFinderVideoSeekBar.setSeekBarCallback((FinderVideoSeekBar.c)this);
    }
    this.rSK = paramFinderVideoSeekBar;
    Object localObject2 = paramFinderItem.getMediaList();
    if (paramInt >= ((LinkedList)localObject2).size())
    {
      AppMethodBeat.o(203860);
      return;
    }
    Object localObject1 = ((LinkedList)localObject2).get(paramInt);
    d.g.b.k.g(localObject1, "mediaList[position]");
    bqs localbqs = (bqs)localObject1;
    String str = localbqs.mediaId;
    d.g.b.k.g(str, "mediaInfo.mediaId");
    localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
    localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.b(localbqs);
    ac.i("Finder.VideoLayout", "[findBestVideo] mediaId=" + str + " videoFlag=" + ((com.tencent.mm.plugin.finder.loader.l)localObject1).rtm);
    if (paramFinderItem.getId() == 0L) {}
    for (boolean bool = true;; bool = false)
    {
      this.rSJ = new b(paramFinderItem, ((com.tencent.mm.plugin.finder.loader.l)localObject1).abW(), (com.tencent.mm.plugin.finder.loader.l)localObject1, paramInt, (LinkedList)localObject2, bool, (byte)0);
      cEa();
      paramFinderItem = new com.tencent.mm.plugin.finder.loader.f(localbqs, m.rDR);
      localObject2 = com.tencent.mm.plugin.finder.loader.h.rtK;
      paramFinderItem = com.tencent.mm.plugin.finder.loader.h.cwn().bG(paramFinderItem);
      localObject2 = com.tencent.mm.plugin.finder.loader.h.rtK;
      paramFinderItem.a(com.tencent.mm.plugin.finder.loader.h.a(h.a.rtL)).a((com.tencent.mm.loader.f.d)c.rSS).c(getThumbView());
      paramFinderItem = this.rSB.aeQ(((com.tencent.mm.plugin.finder.loader.l)localObject1).abW());
      if (paramFinderItem == null) {
        break label419;
      }
      if (paramFinderVideoSeekBar != null) {
        paramFinderVideoSeekBar.lS(true);
      }
      if (paramFinderVideoSeekBar != null) {
        paramFinderVideoSeekBar.setProgress(paramFinderItem.progress);
      }
      lQ(true);
      if (paramFinderVideoSeekBar != null) {
        paramFinderVideoSeekBar.setSeekMode(true);
      }
      paramFinderItem = this.rSJ;
      if (paramFinderItem != null) {
        paramFinderItem.rSQ = true;
      }
      if (paramFinderVideoSeekBar == null) {
        break;
      }
      paramFinderVideoSeekBar.setVisibility(0);
      AppMethodBeat.o(203860);
      return;
    }
    AppMethodBeat.o(203860);
    return;
    label419:
    ((FinderVideoLayout)this).lQ(false);
    if (paramFinderVideoSeekBar != null) {
      paramFinderVideoSeekBar.setSeekMode(false);
    }
    if (paramFinderVideoSeekBar != null)
    {
      paramFinderVideoSeekBar.cEn();
      AppMethodBeat.o(203860);
      return;
    }
    AppMethodBeat.o(203860);
  }
  
  public final void a(com.tencent.mm.plugin.finder.loader.l paraml, com.tencent.mm.i.h paramh, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(168112);
    d.g.b.k.h(paraml, "video");
    StringBuilder localStringBuilder = new StringBuilder("[onStopDownload] videoView=");
    Object localObject = this.rSG;
    if (localObject != null) {}
    for (localObject = Integer.valueOf(localObject.hashCode());; localObject = null)
    {
      ac.i("Finder.VideoLayout", localObject + " FinderVideo=" + paraml + " thumbVisible=" + getThumbView().getVisibility());
      paraml = this.rSJ;
      if (paraml == null) {
        break label158;
      }
      localObject = getVideoPlayBehavior();
      if (localObject == null) {
        break;
      }
      ((b.b)localObject).a(paraml.feed.getExpectId(), "", paraml.rvQ.rtl, paramh, paramd, paraml.rvQ);
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
    paramString = this.rSJ;
    if (paramString != null)
    {
      if (paramString.lrL) {}
      while (paramString != null)
      {
        b.b localb = getVideoPlayBehavior();
        if (localb != null)
        {
          localb.e(paramString.feed.getExpectId(), "", paramString.rvQ.rtl, paramInt1, paramInt2, paramString.rvQ);
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
    Object localObject2 = new StringBuilder("[onProgressDownload] videoView=");
    Object localObject1 = this.rSG;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(localObject1.hashCode());
      ac.i("Finder.VideoLayout", localObject1 + " offset=" + paramInt1 + " total=" + paramInt2 + " video=" + paraml.abW());
      localObject1 = this.rSJ;
      if (localObject1 != null) {
        if (!((b)localObject1).lrL) {
          break label279;
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = getVideoPlayBehavior();
        if (localObject2 != null) {
          ((b.b)localObject2).c(((b)localObject1).feed.getExpectId(), "", ((b)localObject1).rvQ.rtl, paramInt1, paramInt2, ((b)localObject1).rvQ);
        }
      }
      localObject1 = MediaPreloadCore.rvo;
      if (MediaPreloadCore.cwJ())
      {
        localObject1 = new ou();
        ((ou)localObject1).drl.mediaId = paraml.rtl.mediaId;
        ((ou)localObject1).drl.process = ((int)(100.0F * paramInt1 / paramInt2));
        localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
        paraml = paraml.rtl.mediaId;
        d.g.b.k.g(paraml, "video.mediaObj.mediaId");
        paraml = com.tencent.mm.plugin.finder.storage.logic.c.ba(paraml, true);
        ((ou)localObject1).drl.drn = paraml.field_fileFormat;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
      }
      AppMethodBeat.o(168115);
      return;
      localObject1 = null;
      break;
      label279:
      localObject1 = null;
    }
  }
  
  public final void b(com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(168111);
    d.g.b.k.h(paraml, "video");
    StringBuilder localStringBuilder = new StringBuilder("[onStartDownload] videoView=");
    Object localObject = this.rSG;
    if (localObject != null)
    {
      localObject = Integer.valueOf(localObject.hashCode());
      ac.i("Finder.VideoLayout", localObject + " FinderVideo=" + paraml + " thumbVisible=" + getThumbView().getVisibility());
      cEc();
      paraml = this.rSJ;
      if (paraml == null) {
        break label165;
      }
      if (!paraml.lrL) {
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
          ((b.b)localObject).f(paraml.feed.getExpectId(), "", paraml.rvQ.rtl, paraml.rvQ);
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
  
  public final void ba(float paramFloat)
  {
    boolean bool = true;
    AppMethodBeat.i(203866);
    Object localObject2 = new StringBuilder("[seekTo] percent=").append(paramFloat).append(" isSeekMode=").append(cDZ()).append(" videoView=");
    Object localObject1 = this.rSG;
    label103:
    int j;
    int i;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(localObject1.hashCode());
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(" videoDurationSec=");
      localObject1 = this.rSG;
      if (localObject1 == null) {
        break label382;
      }
      localObject1 = Integer.valueOf(((o)localObject1).getVideoDuration());
      ac.i("Finder.VideoLayout", localObject1);
      localObject1 = this.rSG;
      if (localObject1 != null)
      {
        j = ((o)localObject1).getCurrentPlaySecond();
        localObject2 = this.rSG;
        if (localObject2 == null) {
          break label388;
        }
        i = ((o)localObject2).getVideoDuration();
        label159:
        paramFloat = android.support.v4.b.a.j(i * paramFloat, i - 1.0F);
        double d = paramFloat;
        if (cDZ()) {
          break label394;
        }
        label183:
        if ((((o)localObject1).c(d, bool)) && (Math.abs(j - paramFloat) > 1.0F))
        {
          this.rSN = paramFloat;
          localObject2 = new StringBuilder("[seekTo] successfully seek to ").append(paramFloat).append(" videoDurationSec=");
          localObject1 = this.rSG;
          if (localObject1 == null) {
            break label400;
          }
          localObject1 = Integer.valueOf(((o)localObject1).getVideoDuration());
          ac.i("Finder.VideoLayout", localObject1);
        }
        label259:
        localObject1 = this.rSJ;
        if (localObject1 != null) {
          if (!((b)localObject1).lrL) {
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
          ((b.b)localObject2).d(((b)localObject1).feed.getExpectId(), "", ((b)localObject1).rvQ.rtl, j, (int)paramFloat, ((b)localObject1).rvQ);
        }
      }
      localObject1 = this.rSJ;
      if (localObject1 == null) {
        break label412;
      }
      if (!((b)localObject1).rSQ) {
        lQ(false);
      }
      AppMethodBeat.o(203866);
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
    AppMethodBeat.o(203866);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168103);
    StringBuilder localStringBuilder = new StringBuilder("[onError] videoView=");
    paramString1 = this.rSG;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      ac.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2 + " errorMsg=" + paramString3 + " what=" + paramInt1 + " extra=" + paramInt2);
      paramString1 = this.rSK;
      if (paramString1 != null) {
        paramString1.setVisibility(8);
      }
      cEb();
      paramString1 = com.tencent.mm.plugin.finder.report.d.rxr;
      com.tencent.mm.plugin.finder.report.d.DV(paramInt1);
      paramString1 = this.rSJ;
      if (paramString1 == null) {
        break label179;
      }
      paramString2 = getVideoPlayBehavior();
      if (paramString2 == null) {
        break;
      }
      paramString2.a(paramString1.feed.getExpectId(), paramString1.rvQ.rtl, paramInt1);
      AppMethodBeat.o(168103);
      return;
    }
    AppMethodBeat.o(168103);
    return;
    label179:
    AppMethodBeat.o(168103);
  }
  
  public final void cEe()
  {
    AppMethodBeat.i(203865);
    Object localObject = this.rSG;
    if (localObject != null) {
      ((o)localObject).pause();
    }
    localObject = this.rSJ;
    if ((localObject != null) && (!((b)localObject).rSQ)) {
      lQ(true);
    }
    cEf();
    AppMethodBeat.o(203865);
  }
  
  public final void cMP()
  {
    AppMethodBeat.i(210207);
    b localb = this.rSJ;
    if (localb != null)
    {
      i locali = this.rbo;
      if (locali == null) {
        d.g.b.k.aVY("videoCore");
      }
      locali.cDX().a((ViewGroup)this, localb.rvQ, (d.g.a.b)new FinderVideoLayout.o(localb, this));
      AppMethodBeat.o(210207);
      return;
    }
    AppMethodBeat.o(210207);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168106);
    StringBuilder localStringBuilder = new StringBuilder("[onGetVideoSize] videoView=");
    paramString1 = this.rSG;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      ac.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2 + " width=" + paramInt1 + " height=" + paramInt2);
      AppMethodBeat.o(168106);
      return;
    }
  }
  
  public final void jdMethod_do(String paramString1, String paramString2)
  {
    Integer localInteger = null;
    AppMethodBeat.i(168104);
    paramString1 = this.rSG;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.getVideoDuration());; paramString1 = null)
    {
      StringBuilder localStringBuilder = new StringBuilder("[onPrepared] videoView=");
      o localo = this.rSG;
      if (localo != null) {
        localInteger = Integer.valueOf(localo.hashCode());
      }
      ac.i("Finder.VideoLayout", localInteger + " mediaId=" + paramString2 + " thumbVisible=" + getThumbView().getVisibility() + " duration=" + paramString1);
      AppMethodBeat.o(168104);
      return;
    }
  }
  
  public final void dp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(168105);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoEnded] videoView=");
    paramString1 = this.rSG;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      ac.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      AppMethodBeat.o(168105);
      return;
    }
  }
  
  public final void dq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(168107);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoPause] videoView=");
    paramString1 = this.rSG;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      ac.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      cfJ();
      AppMethodBeat.o(168107);
      return;
    }
  }
  
  public final void dr(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(168108);
    paramString1 = this.rSG;
    int i;
    Object localObject2;
    if (paramString1 != null)
    {
      i = paramString1.getVideoDuration();
      localObject2 = new StringBuilder("[onVideoPlay] videoView=");
      paramString1 = this.rSG;
      if (paramString1 == null) {
        break label171;
      }
    }
    label171:
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      paramString2 = ((StringBuilder)localObject2).append(paramString1).append(" mediaId=").append(paramString2).append(" duration=").append(i).append(" isHasPlayed=");
      localObject2 = this.rSJ;
      paramString1 = localObject1;
      if (localObject2 != null) {
        paramString1 = Boolean.valueOf(((b)localObject2).rSR);
      }
      ac.i("Finder.VideoLayout", paramString1);
      cfJ();
      cEc();
      paramString1 = this.rSG;
      if (paramString1 != null) {
        paramString1.setKeepScreenOn(true);
      }
      this.rSN = -1.0F;
      bYp();
      AppMethodBeat.o(168108);
      return;
      i = 0;
      break;
    }
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    AppMethodBeat.i(168109);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoWaiting] videoView=");
    Object localObject = this.rSG;
    if (localObject != null)
    {
      localObject = Integer.valueOf(localObject.hashCode());
      ac.i("Finder.VideoLayout", localObject + " mediaId=" + paramString2 + " thumbVisible=" + getThumbView().getVisibility());
      paramString2 = this.rSG;
      if (((paramString2 == null) || (paramString2.getVideoViewFocused() != true)) && (paramString1 != null)) {
        break label183;
      }
      showLoading();
      paramString1 = this.rSJ;
      if (paramString1 == null) {
        break label183;
      }
      if (!paramString1.lrL) {
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
          paramString2.b(paramString1.feed.getExpectId(), "", paramString1.rvQ.rtl, paramString1.rvQ);
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
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(168110);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoWaitingEnd] videoView=");
    paramString1 = this.rSG;
    if (paramString1 != null)
    {
      paramString1 = Integer.valueOf(paramString1.hashCode());
      ac.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      cfJ();
      paramString1 = this.rSJ;
      if (paramString1 == null) {
        break label142;
      }
      if (!paramString1.lrL) {
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
          paramString2.c(paramString1.feed.getExpectId(), "", paramString1.rvQ.rtl, paramString1.rvQ);
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
  
  public final void eJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(203862);
    StringBuilder localStringBuilder = new StringBuilder("[onVideoFirstFrameDraw] videoView=");
    paramString1 = this.rSG;
    if (paramString1 != null) {}
    for (paramString1 = Integer.valueOf(paramString1.hashCode());; paramString1 = null)
    {
      ac.i("Finder.VideoLayout", paramString1 + " mediaId=" + paramString2);
      paramString1 = this.rSG;
      if ((paramString1 == null) || (paramString1.getAlpha() != 1.0F)) {
        break;
      }
      AppMethodBeat.o(203862);
      return;
    }
    if (!this.rSM)
    {
      ac.i("Finder.VideoLayout", "[dismissThumb] " + cEd() + " source=" + "onVideoFirstFrameDraw" + " isShowThumbAnimating=" + this.rSM);
      paramString1 = this.rSG;
      if (paramString1 != null)
      {
        paramString1.getVideoView().post((Runnable)new d(paramString1, this));
        AppMethodBeat.o(203862);
        return;
      }
    }
    AppMethodBeat.o(203862);
  }
  
  public final int getCurrentPosSec()
  {
    AppMethodBeat.i(203868);
    o localo = this.rSG;
    if (localo != null)
    {
      int i = localo.getCurrentPlaySecond();
      AppMethodBeat.o(203868);
      return i;
    }
    AppMethodBeat.o(203868);
    return 0;
  }
  
  public final u getLifecycle()
  {
    return this.rRI;
  }
  
  public final int getPlayAdapterPosition()
  {
    return this.rSL;
  }
  
  public final View getRetryBtn()
  {
    AppMethodBeat.i(168092);
    View localView = (View)this.rSH.getValue();
    AppMethodBeat.o(168092);
    return localView;
  }
  
  public final i getVideoCore()
  {
    AppMethodBeat.i(168088);
    i locali = this.rbo;
    if (locali == null) {
      d.g.b.k.aVY("videoCore");
    }
    AppMethodBeat.o(168088);
    return locali;
  }
  
  public final int getVideoDurationSec()
  {
    AppMethodBeat.i(203867);
    o localo = this.rSG;
    if (localo != null)
    {
      int i = localo.getVideoDuration();
      AppMethodBeat.o(203867);
      return i;
    }
    AppMethodBeat.o(203867);
    return 0;
  }
  
  public final o getVideoView()
  {
    return this.rSG;
  }
  
  public final void lR(boolean paramBoolean)
  {
    b localb = null;
    AppMethodBeat.i(203864);
    Object localObject1 = this.rSG;
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
      localObject1 = this.rSJ;
      if (localObject1 != null)
      {
        localObject2 = getVideoPlayBehavior();
        if (localObject2 != null) {
          ((b.b)localObject2).a(((b)localObject1).feed.getExpectId(), "", ((b)localObject1).rvQ.rtl, ((b)localObject1).rvQ);
        }
      }
      lQ(true);
      localObject1 = this.rSG;
      if (localObject1 != null) {
        ((o)localObject1).setVideoViewFocused(false);
      }
      localObject1 = this.rSG;
      if (localObject1 == null) {
        break label269;
      }
      localObject1 = Boolean.valueOf(((o)localObject1).pause());
    }
    for (;;)
    {
      localObject2 = this.rSJ;
      if (localObject2 != null) {
        ((b)localObject2).rSQ = paramBoolean;
      }
      cEf();
      if (!paramBoolean) {
        this.rSB.clear();
      }
      localObject2 = new StringBuilder("[onEnterSeekMode] isEnter=").append(paramBoolean).append(" ret=").append(localObject1).append(" alpha=");
      o localo = this.rSG;
      localObject1 = localb;
      if (localo != null) {
        localObject1 = Float.valueOf(localo.getAlpha());
      }
      localObject1 = ((StringBuilder)localObject2).append(localObject1).append(" mediaId=");
      localb = this.rSJ;
      if (localb == null) {
        d.g.b.k.fOy();
      }
      ac.i("Finder.VideoLayout", localb.mediaId);
      AppMethodBeat.o(203864);
      return;
      bool = false;
      break;
      label269:
      localObject1 = null;
      continue;
      label274:
      lQ(false);
      localObject1 = this.rSG;
      if (localObject1 != null) {
        ((o)localObject1).setVideoViewFocused(true);
      }
      localObject1 = this.rSG;
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
    Object localObject1 = this.rSJ;
    Object localObject2;
    Object localObject3;
    if ((localObject1 != null) && (((b)localObject1).rSQ == true))
    {
      localObject1 = this.rSJ;
      if ((localObject1 != null) && (((b)localObject1).lrL == true))
      {
        localObject1 = this.rSB;
        localObject2 = this.rSJ;
        if (localObject2 == null) {
          d.g.b.k.fOy();
        }
        localObject2 = ((b)localObject2).mediaId;
        localObject3 = this.rSK;
        if (localObject3 == null) {
          break label202;
        }
      }
    }
    label202:
    for (int i = ((FinderVideoSeekBar)localObject3).getCurrentProgress();; i = 0)
    {
      localObject3 = this.rSG;
      if (localObject3 != null) {
        j = ((o)localObject3).getCurrentPlaySecond();
      }
      d.g.b.k.h(localObject2, "mediaId");
      ac.i("Finder.VideoStateCacheVM", "[store] mediaId=" + (String)localObject2 + " progress=" + i + " timestamp=" + j);
      localObject2 = new FinderVideoStateCacheVM.a((String)localObject2);
      ((FinderVideoStateCacheVM.a)localObject2).progress = i;
      ((FinderVideoStateCacheVM.a)localObject2).sdg = j;
      ((FinderVideoStateCacheVM)localObject1).sde = ((FinderVideoStateCacheVM.a)localObject2);
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
      ac.i("Finder.VideoLayout", "[onViewAdded] isPreviewing=" + ((o)paramView).cDz() + ' ' + cEd());
      if (((o)paramView).cDz()) {
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
    if ((d.g.b.k.g(paramView, this.rSG)) && ((paramView instanceof o)))
    {
      ac.i("Finder.VideoLayout", "[onViewRemoved] isPreviewing=" + ((o)paramView).cDz() + ' ' + cEd());
      FinderVideoSeekBar localFinderVideoSeekBar = this.rSK;
      if (localFinderVideoSeekBar != null) {
        localFinderVideoSeekBar.cEn();
      }
      if (((o)paramView).cDz())
      {
        setVisibility(4);
        AppMethodBeat.o(168102);
        return;
      }
      cEa();
      cfJ();
      this.rSG = null;
    }
    AppMethodBeat.o(168102);
  }
  
  public final void play(int paramInt)
  {
    AppMethodBeat.i(168095);
    this.rSL = paramInt;
    if (this.rSJ == null)
    {
      AppMethodBeat.o(168095);
      return;
    }
    final b localb = this.rSJ;
    if (localb == null) {
      d.g.b.k.fOy();
    }
    i locali = this.rbo;
    if (locali == null) {
      d.g.b.k.aVY("videoCore");
    }
    locali.cDX().a((ViewGroup)this, localb.rvQ, (d.g.a.b)new i(this, localb));
    AppMethodBeat.o(168095);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.ftN = paramBoolean;
  }
  
  public final void setPlayAdapterPosition(int paramInt)
  {
    this.rSL = paramInt;
  }
  
  public final void setVideoCore(i parami)
  {
    AppMethodBeat.i(168089);
    d.g.b.k.h(parami, "<set-?>");
    this.rbo = parami;
    AppMethodBeat.o(168089);
  }
  
  public final void setVideoView(o paramo)
  {
    this.rSG = paramo;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/FinderVideoLayout$PlayInfo;", "", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "mediaId", "", "media", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "position", "", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "isLocal", "", "isPlaying", "isSeekMode", "isHasPlayed", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/loader/FinderVideo;ILjava/util/LinkedList;ZZZZ)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "()Z", "setHasPlayed", "(Z)V", "setPlaying", "setSeekMode", "getMedia", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "getMediaId", "()Ljava/lang/String;", "getMediaList", "()Ljava/util/LinkedList;", "getPosition", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
  public static final class b
  {
    final boolean dqZ;
    final FinderItem feed;
    boolean lrL;
    final String mediaId;
    final LinkedList<bqs> mediaList;
    private final int position;
    boolean rSQ;
    boolean rSR;
    final com.tencent.mm.plugin.finder.loader.l rvQ;
    
    private b(FinderItem paramFinderItem, String paramString, com.tencent.mm.plugin.finder.loader.l paraml, int paramInt, LinkedList<bqs> paramLinkedList, boolean paramBoolean)
    {
      AppMethodBeat.i(168053);
      this.feed = paramFinderItem;
      this.mediaId = paramString;
      this.rvQ = paraml;
      this.position = paramInt;
      this.mediaList = paramLinkedList;
      this.dqZ = paramBoolean;
      this.lrL = false;
      this.rSQ = false;
      this.rSR = false;
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
          if ((!d.g.b.k.g(this.feed, paramObject.feed)) || (!d.g.b.k.g(this.mediaId, paramObject.mediaId)) || (!d.g.b.k.g(this.rvQ, paramObject.rvQ)) || (this.position != paramObject.position) || (!d.g.b.k.g(this.mediaList, paramObject.mediaList)) || (this.dqZ != paramObject.dqZ) || (this.lrL != paramObject.lrL) || (this.rSQ != paramObject.rSQ) || (this.rSR != paramObject.rSR)) {}
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
      String str = "PlayInfo(feed=" + this.feed + ", mediaId=" + this.mediaId + ", media=" + this.rvQ + ", position=" + this.position + ", mediaList=" + this.mediaList + ", isLocal=" + this.dqZ + ", isPlaying=" + this.lrL + ", isSeekMode=" + this.rSQ + ", isHasPlayed=" + this.rSR + ")";
      AppMethodBeat.o(168054);
      return str;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class c<T, R>
    implements com.tencent.mm.loader.f.d<j, Bitmap>
  {
    public static final c rSS;
    
    static
    {
      AppMethodBeat.i(203851);
      rSS = new c();
      AppMethodBeat.o(203851);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$dismissThumb$1$1"})
  static final class d
    implements Runnable
  {
    d(o paramo, FinderVideoLayout paramFinderVideoLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(168058);
      this.rST.animate().cancel();
      this.rST.animate().alpha(1.0F).setDuration(200L).withStartAction((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(203852);
          FinderVideoLayout.a(this.rSV.rSU, true);
          AppMethodBeat.o(203852);
        }
      }).withEndAction((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(203853);
          this.rSV.rST.setAlpha(1.0F);
          FinderVideoLayout.a(this.rSV.rSU, false);
          AppMethodBeat.o(203853);
        }
      }).start();
      AppMethodBeat.o(168058);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/video/FinderVideoLayout$lifecycle$1", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "onBeforePlay", "", "info", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "onFirstFrameUpdate", "onPause", "onPlay", "onPlayProgress", "offset", "", "total", "onReplay", "onStopPlay", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "plugin-finder_release"})
  public static final class e
    implements u
  {
    public final void b(p paramp)
    {
      AppMethodBeat.i(203855);
      if (paramp != null)
      {
        Object localObject = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
        localObject = com.tencent.mm.plugin.finder.storage.logic.c.aei(paramp.mediaId);
        if (!((com.tencent.mm.plugin.finder.model.w)localObject).field_hasPlayed)
        {
          ((com.tencent.mm.plugin.finder.model.w)localObject).field_hasPlayed = true;
          com.tencent.mm.ac.c.b(null, (d.g.a.a)new a((com.tencent.mm.plugin.finder.model.w)localObject));
        }
        localObject = FinderVideoLayout.m(this.rSU);
        if (localObject != null)
        {
          ((b.b)localObject).e(paramp.qYz.getId(), "", paramp.rTE, paramp.rcZ);
          AppMethodBeat.o(203855);
          return;
        }
        AppMethodBeat.o(203855);
        return;
      }
      AppMethodBeat.o(203855);
    }
    
    public final void cEg()
    {
      AppMethodBeat.i(203856);
      FinderVideoLayout.b localb = FinderVideoLayout.g(this.rSU);
      if (localb != null)
      {
        b.b localb1 = FinderVideoLayout.m(this.rSU);
        if (localb1 != null)
        {
          localb1.a(localb.feed.getId(), localb.feed.getObjectNonceId(), localb.rvQ.rtl, localb.mediaList, this.rSU.getPlayAdapterPosition(), localb.rvQ);
          AppMethodBeat.o(203856);
          return;
        }
        AppMethodBeat.o(203856);
        return;
      }
      AppMethodBeat.o(203856);
    }
    
    public final void cEh()
    {
      AppMethodBeat.i(168061);
      FinderVideoLayout.b localb = FinderVideoLayout.g(this.rSU);
      if (localb != null)
      {
        this.rSU.eJ("", localb.mediaId);
        b.b localb1 = FinderVideoLayout.m(this.rSU);
        if (localb1 != null)
        {
          localb1.c(localb.feed.getExpectId(), localb.feed.getObjectNonceId(), localb.rvQ.rtl, localb.mediaList, localb.rvQ);
          AppMethodBeat.o(168061);
          return;
        }
        AppMethodBeat.o(168061);
        return;
      }
      AppMethodBeat.o(168061);
    }
    
    public final void cEi()
    {
      AppMethodBeat.i(168062);
      FinderVideoLayout.b localb = FinderVideoLayout.g(this.rSU);
      if (localb != null)
      {
        b.b localb1 = FinderVideoLayout.m(this.rSU);
        if (localb1 != null)
        {
          localb1.b(localb.feed.getExpectId(), localb.feed.getObjectNonceId(), localb.rvQ.rtl, localb.mediaList, localb.rvQ);
          AppMethodBeat.o(168062);
          return;
        }
        AppMethodBeat.o(168062);
        return;
      }
      AppMethodBeat.o(168062);
    }
    
    public final void cEj()
    {
      AppMethodBeat.i(168063);
      FinderVideoLayout.b localb = FinderVideoLayout.g(this.rSU);
      if (localb != null)
      {
        b.b localb1 = FinderVideoLayout.m(this.rSU);
        if (localb1 != null)
        {
          localb1.d(localb.feed.getExpectId(), localb.feed.getObjectNonceId(), localb.rvQ.rtl, localb.rvQ);
          AppMethodBeat.o(168063);
          return;
        }
        AppMethodBeat.o(168063);
        return;
      }
      AppMethodBeat.o(168063);
    }
    
    public final void cEk()
    {
      AppMethodBeat.i(168064);
      FinderVideoLayout.b localb = FinderVideoLayout.g(this.rSU);
      if (localb != null)
      {
        b.b localb1 = FinderVideoLayout.m(this.rSU);
        if (localb1 != null)
        {
          localb1.a(localb.feed.getExpectId(), localb.feed.getObjectNonceId(), localb.rvQ.rtl, localb.mediaList, localb.rvQ);
          AppMethodBeat.o(168064);
          return;
        }
        AppMethodBeat.o(168064);
        return;
      }
      AppMethodBeat.o(168064);
    }
    
    public final void fJ(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(168065);
      Object localObject = FinderVideoLayout.g(this.rSU);
      if (localObject != null)
      {
        b.b localb = FinderVideoLayout.m(this.rSU);
        if (localb != null) {
          localb.a(((FinderVideoLayout.b)localObject).feed.getExpectId(), ((FinderVideoLayout.b)localObject).feed.getObjectNonceId(), ((FinderVideoLayout.b)localObject).rvQ.rtl, paramInt1, paramInt2, ((FinderVideoLayout.b)localObject).rvQ);
        }
        if (paramInt1 >= 20)
        {
          localObject = FinderVideoLayout.c(this.rSU);
          if ((localObject != null) && (!((FinderVideoSeekBar)localObject).cEp()))
          {
            localObject = FinderVideoLayout.c(this.rSU);
            if (localObject != null) {
              ((FinderVideoSeekBar)localObject).lS(false);
            }
          }
        }
        FinderVideoLayout.n(this.rSU);
        AppMethodBeat.o(168065);
        return;
      }
      AppMethodBeat.o(168065);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(com.tencent.mm.plugin.finder.model.w paramw)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    f(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<ImageView>
  {
    g(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<TextView>
  {
    h(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "videoView", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.b<o, y>
  {
    i(FinderVideoLayout paramFinderVideoLayout, FinderVideoLayout.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    j(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$retryBtn$2$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderVideoLayout.j paramj) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(168076);
        paramView = this.rSY.rSU.getVideoView();
        if (paramView != null) {
          paramView.stop();
        }
        this.rSY.rSU.play(this.rSY.rSU.getPlayAdapterPosition());
        AppMethodBeat.o(168076);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(FinderVideoLayout paramFinderVideoLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(168078);
      FinderVideoLayout.j(this.rSU).setAlpha(1.0F);
      FinderVideoLayout.j(this.rSU).setVisibility(0);
      AppMethodBeat.o(168078);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends d.g.b.l
    implements d.g.a.a<ImageView>
  {
    l(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/video/FinderVideoLayout$updateProgress$1$1"})
  static final class m
    implements Runnable
  {
    m(FinderVideoSeekBar paramFinderVideoSeekBar, FinderVideoLayout paramFinderVideoLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(203858);
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
        if ((!this.rSZ.rSQ) && (j > 0) && (FinderVideoLayout.k(jdField_this) == -1.0F) && (FinderVideoLayout.l(jdField_this) != i))
        {
          localObject1 = this.rSZ;
          localSeekBar = ((FinderVideoSeekBar)localObject1).getVideoSeekBar();
          if (localSeekBar != null)
          {
            k = localSeekBar.getMax();
            ((FinderVideoSeekBar)localObject1).cEo();
            float f = 1.0F * (i + 1.3F) / j;
            m = d.h.a.cj(k * f);
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
            k += Math.max(1, d.h.a.cj(n / 76.470589F));
            if (ac.getLogLevel() <= 1) {
              ac.d("Finder.VideoSeekBar", "[setProgress] isWithAnim=true offsetSec=" + i + " allSec=" + j + " target=" + m + " current=" + k + " diff=" + n + " real=" + (m - k));
            }
            if (k - m <= 10) {
              break label441;
            }
            ac.d("Finder.VideoSeekBar", "[updateProgress] reset current=0, current=" + k + ", target=" + m);
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
        ((FinderVideoSeekBar)localObject1).rTh = ((ValueAnimator)localObject2);
        FinderVideoLayout.a(jdField_this, i);
        AppMethodBeat.o(203858);
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends d.g.b.l
    implements d.g.a.a<View>
  {
    n(FinderVideoLayout paramFinderVideoLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderVideoLayout
 * JD-Core Version:    0.7.0.1
 */