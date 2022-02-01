package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.loader.ac;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.findersdk.f.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.cud;
import com.tencent.mm.protocal.protobuf.cue;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderLivePlayView;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "curPlayerStatus", "decorateView", "Landroid/widget/RelativeLayout;", "isAutoJustRenderMode", "", "()Z", "setAutoJustRenderMode", "(Z)V", "isFullScreen", "isNeverStart", "setNeverStart", "isPause", "isPreviewing", "isShouldPlayResume", "setShouldPlayResume", "isSupportPauseResume", "setSupportPauseResume", "isViewFocused", "setViewFocused", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "liveFeedDecorator", "Lcom/tencent/mm/plugin/finder/feed/FinderLiveFeedDecorator;", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "playListener", "Lcom/tencent/rtmp/ITXLivePlayListener;", "getPlayListener", "()Lcom/tencent/rtmp/ITXLivePlayListener;", "textureView", "Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;", "getTextureView", "()Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;", "setTextureView", "(Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;)V", "txLivePlayer", "Lcom/tencent/rtmp/TXLivePlayer;", "getTxLivePlayer", "()Lcom/tencent/rtmp/TXLivePlayer;", "setTxLivePlayer", "(Lcom/tencent/rtmp/TXLivePlayer;)V", "videoViewCallback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "getVideoViewCallback", "()Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setVideoViewCallback", "(Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;)V", "adjustDecorateRoot", "", "videoW", "videoH", "dismissRenderView", "getBitmap", "Landroid/graphics/Bitmap;", "getCurrentPlayMs", "", "getCurrentPlaySecond", "getIsNeverStart", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getVideoDuration", "getVideoDurationMs", "getVideoMediaId", "getVideoMediaInfo", "getVideoView", "getVideoViewFocused", "init", "isFullScreenEnjoy", "isPlaying", "onRelease", "onUIDestroy", "pause", "pauseWithCancel", "play", "prepareToPlay", "print", "str", "removeVideoFooterView", "seekTo", "timestamp", "", "afterSeekPlay", "mode", "setFinderVideoPlayTrace", "videoPlayTrace", "Lcom/tencent/mm/plugin/findersdk/trace/FinderVideoPlayTrace;", "setFullScreenEnjoy", "isFull", "setIMMVideoViewCallback", "_callback", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setInterceptDetach", "isInterceptDetach", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", "setLoop", "loop", "setMute", "isMute", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/IFinderMediaLoaderData;", "isLocal", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setVideoMuteListener", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setVideoPlayLifecycle", "setVideoViewFocused", "focused", "showRenderView", "start", "downloadUrl", "startOrPlay", "stop", "plugin-finder_release"})
public final class FinderLivePlayView
  extends FrameLayout
  implements s
{
  private boolean AJP;
  public d ALe;
  private z ALf;
  boolean ALg;
  private t ALh;
  private final ITXLivePlayListener ALi;
  private boolean ALj;
  private boolean ALk;
  private volatile boolean ALl;
  private boolean ALm;
  private final String TAG;
  private boolean fEs;
  public TXLivePlayer kjc;
  private int kqn;
  private boolean wFf;
  private RelativeLayout xVK;
  private com.tencent.mm.plugin.finder.feed.z xVL;
  private i.b zxu;
  
  public FinderLivePlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(281249);
    this.TAG = "Finder.FinderLivePlayView";
    this.ALi = ((ITXLivePlayListener)new a(this));
    this.ALl = true;
    init();
    AppMethodBeat.o(281249);
  }
  
  public FinderLivePlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(281251);
    this.TAG = "Finder.FinderLivePlayView";
    this.ALi = ((ITXLivePlayListener)new a(this));
    this.ALl = true;
    init();
    AppMethodBeat.o(281251);
  }
  
  public FinderLivePlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(281253);
    this.TAG = "Finder.FinderLivePlayView";
    this.ALi = ((ITXLivePlayListener)new a(this));
    this.ALl = true;
    init();
    AppMethodBeat.o(281253);
  }
  
  private final void aex(String paramString)
  {
    AppMethodBeat.i(281247);
    Log.i(this.TAG, hashCode() + " === " + paramString);
    AppMethodBeat.o(281247);
  }
  
  private void init()
  {
    AppMethodBeat.i(281217);
    Object localObject1 = getContext();
    p.j(localObject1, "context");
    this.ALe = new d((Context)localObject1);
    localObject1 = new FrameLayout.LayoutParams(-1, -1);
    Object localObject2 = this.ALe;
    if (localObject2 == null) {
      p.bGy("textureView");
    }
    addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    this.xVK = new RelativeLayout(getContext());
    localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    addView((View)this.xVK, (ViewGroup.LayoutParams)localObject1);
    this.kjc = new TXLivePlayer(getContext());
    localObject1 = new TXLivePlayConfig();
    ((TXLivePlayConfig)localObject1).setAutoAdjustCacheTime(true);
    ((TXLivePlayConfig)localObject1).setMinAutoAdjustCacheTime(1.0F);
    ((TXLivePlayConfig)localObject1).setMaxAutoAdjustCacheTime(1.0F);
    ((TXLivePlayConfig)localObject1).setEnableMessage(true);
    localObject2 = this.kjc;
    if (localObject2 == null) {
      p.bGy("txLivePlayer");
    }
    d locald = this.ALe;
    if (locald == null) {
      p.bGy("textureView");
    }
    ((TXLivePlayer)localObject2).setPlayerView((TXCloudVideoView)locald);
    localObject2 = this.kjc;
    if (localObject2 == null) {
      p.bGy("txLivePlayer");
    }
    ((TXLivePlayer)localObject2).setPlayListener(this.ALi);
    localObject2 = this.kjc;
    if (localObject2 == null) {
      p.bGy("txLivePlayer");
    }
    ((TXLivePlayer)localObject2).setConfig((TXLivePlayConfig)localObject1);
    localObject1 = this.kjc;
    if (localObject1 == null) {
      p.bGy("txLivePlayer");
    }
    ((TXLivePlayer)localObject1).setRenderMode(0);
    this.xVL = new com.tencent.mm.plugin.finder.feed.z(0, (ViewGroup)this.xVK);
    AppMethodBeat.o(281217);
  }
  
  private final void start(String paramString)
  {
    AppMethodBeat.i(281227);
    aex("start, ".concat(String.valueOf(paramString)));
    Object localObject;
    if ((this.fEs) && (this.ALm))
    {
      paramString = this.kjc;
      if (paramString == null) {
        p.bGy("txLivePlayer");
      }
      paramString.resume();
      paramString = k.yBj;
      localObject = s.t.yGN;
      paramString = this.ALh;
      if (paramString == null) {
        break label112;
      }
    }
    label112:
    for (paramString = paramString.xzp;; paramString = null)
    {
      k.a((s.t)localObject, paramString);
      AppMethodBeat.o(281227);
      return;
      localObject = this.kjc;
      if (localObject == null) {
        p.bGy("txLivePlayer");
      }
      ((TXLivePlayer)localObject).startPlay(paramString, 1);
      break;
    }
  }
  
  public final void a(ac paramac, boolean paramBoolean, FeedData paramFeedData)
  {
    AppMethodBeat.i(281240);
    p.k(paramac, "video");
    p.k(paramFeedData, "feedData");
    aex("setVideoMediaInfo " + paramac.getUrl());
    this.ALh = new t(paramac.getUrl(), paramac.getPath(), paramac.aBv(), paramac.dJw(), paramac, paramFeedData);
    paramac = this.xVL;
    if (paramac != null) {
      paramac.a(paramFeedData);
    }
    paramac = this.xVL;
    if (paramac != null)
    {
      paramac.xzq = ((b)new b(this));
      AppMethodBeat.o(281240);
      return;
    }
    AppMethodBeat.o(281240);
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean)
  {
    return false;
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean, int paramInt)
  {
    return false;
  }
  
  public final boolean bqo()
  {
    AppMethodBeat.i(281225);
    aex("play");
    Object localObject = this.kjc;
    if (localObject == null) {
      p.bGy("txLivePlayer");
    }
    ((TXLivePlayer)localObject).resume();
    localObject = this.ALf;
    if (localObject != null) {
      ((z)localObject).dJV();
    }
    AppMethodBeat.o(281225);
    return true;
  }
  
  public final boolean egV()
  {
    AppMethodBeat.i(281226);
    Object localObject2 = new StringBuilder("startOrPlay, ");
    Object localObject1 = this.ALh;
    if (localObject1 != null) {}
    for (localObject1 = ((t)localObject1).downloadUrl;; localObject1 = null)
    {
      aex((String)localObject1);
      if (this.ALj) {
        break;
      }
      Log.i(this.TAG, "startOrPlay, return, isViewFocused:" + this.ALj);
      AppMethodBeat.o(281226);
      return false;
    }
    if (isPlaying())
    {
      Log.i(this.TAG, "startOrPlay, return, isPlaying!");
      AppMethodBeat.o(281226);
      return false;
    }
    localObject1 = this.ALh;
    if ((localObject1 != null) && (!Util.isNullOrNil(((t)localObject1).downloadUrl)) && (((t)localObject1).downloadUrl != null))
    {
      localObject2 = ((t)localObject1).downloadUrl;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      start((String)localObject1);
      this.ALl = false;
      AppMethodBeat.o(281226);
      return true;
    }
    AppMethodBeat.o(281226);
    return false;
  }
  
  public final int egW()
  {
    AppMethodBeat.i(281231);
    aex("pauseWithCancel");
    TXLivePlayer localTXLivePlayer = this.kjc;
    if (localTXLivePlayer == null) {
      p.bGy("txLivePlayer");
    }
    localTXLivePlayer.pause();
    this.fEs = true;
    AppMethodBeat.o(281231);
    return 0;
  }
  
  public final void egX() {}
  
  public final boolean egw()
  {
    AppMethodBeat.i(281229);
    aex("prepareToPlay");
    AppMethodBeat.o(281229);
    return true;
  }
  
  public final boolean egx()
  {
    return this.wFf;
  }
  
  public final Bitmap getBitmap()
  {
    return null;
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
    return this.ALl;
  }
  
  public final boolean getIsShouldPlayResume()
  {
    return this.ALk;
  }
  
  public final z getLifecycle()
  {
    return this.ALf;
  }
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(281221);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(281221);
    return localViewParent;
  }
  
  public final ITXLivePlayListener getPlayListener()
  {
    return this.ALi;
  }
  
  public final d getTextureView()
  {
    AppMethodBeat.i(281208);
    d locald = this.ALe;
    if (locald == null) {
      p.bGy("textureView");
    }
    AppMethodBeat.o(281208);
    return locald;
  }
  
  public final TXLivePlayer getTxLivePlayer()
  {
    AppMethodBeat.i(281204);
    TXLivePlayer localTXLivePlayer = this.kjc;
    if (localTXLivePlayer == null) {
      p.bGy("txLivePlayer");
    }
    AppMethodBeat.o(281204);
    return localTXLivePlayer;
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
    Object localObject = this.ALh;
    if (localObject != null)
    {
      String str = ((t)localObject).mediaId;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    return localObject;
  }
  
  public final t getVideoMediaInfo()
  {
    return this.ALh;
  }
  
  public final FinderLivePlayView getVideoView()
  {
    return this;
  }
  
  public final i.b getVideoViewCallback()
  {
    return this.zxu;
  }
  
  public final boolean getVideoViewFocused()
  {
    return this.ALj;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(281234);
    TXLivePlayer localTXLivePlayer = this.kjc;
    if (localTXLivePlayer == null) {
      p.bGy("txLivePlayer");
    }
    boolean bool = localTXLivePlayer.isPlaying();
    AppMethodBeat.o(281234);
    return bool;
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(281238);
    aex("onRelease");
    com.tencent.mm.plugin.finder.feed.z localz = this.xVL;
    if (localz != null) {
      localz.dtj();
    }
    this.fEs = false;
    AppMethodBeat.o(281238);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(281237);
    aex("onUIDestroy");
    stop();
    AppMethodBeat.o(281237);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(281230);
    aex("pause");
    Object localObject = this.kjc;
    if (localObject == null) {
      p.bGy("txLivePlayer");
    }
    ((TXLivePlayer)localObject).pause();
    this.fEs = true;
    localObject = this.ALf;
    if (localObject != null) {
      ((z)localObject).a(null);
    }
    AppMethodBeat.o(281230);
    return true;
  }
  
  public final void setAutoJustRenderMode(boolean paramBoolean)
  {
    this.ALg = paramBoolean;
  }
  
  public final void setFinderVideoPlayTrace(a parama) {}
  
  public final void setFullScreenEnjoy(boolean paramBoolean)
  {
    this.AJP = paramBoolean;
  }
  
  public final void setIMMVideoViewCallback(i.b paramb)
  {
    AppMethodBeat.i(281241);
    p.k(paramb, "_callback");
    aex("setIMMVideoViewCallback _callback:" + paramb.hashCode());
    this.zxu = paramb;
    AppMethodBeat.o(281241);
  }
  
  public final void setIOnlineVideoProxy(f paramf)
  {
    AppMethodBeat.i(281243);
    p.k(paramf, "_proxy");
    AppMethodBeat.o(281243);
  }
  
  public final void setInterceptDetach(boolean paramBoolean) {}
  
  public final void setIsShouldPlayResume(boolean paramBoolean)
  {
    AppMethodBeat.i(281222);
    aex("setIsShouldPlayResume: ".concat(String.valueOf(paramBoolean)));
    this.ALk = paramBoolean;
    AppMethodBeat.o(281222);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean) {}
  
  public final void setLifecycle(z paramz)
  {
    this.ALf = paramz;
  }
  
  public final void setLoop(boolean paramBoolean) {}
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(281236);
    aex("setMute ".concat(String.valueOf(paramBoolean)));
    TXLivePlayer localTXLivePlayer = this.kjc;
    if (localTXLivePlayer == null) {
      p.bGy("txLivePlayer");
    }
    localTXLivePlayer.setMute(paramBoolean);
    AppMethodBeat.o(281236);
  }
  
  public final void setNeverStart(boolean paramBoolean)
  {
    this.ALl = paramBoolean;
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    AppMethodBeat.i(281224);
    aex("setPreview: ".concat(String.valueOf(paramBoolean)));
    this.wFf = paramBoolean;
    AppMethodBeat.o(281224);
  }
  
  public final void setScaleType(i.e parame)
  {
    AppMethodBeat.i(281242);
    p.k(parame, "scaleType");
    TXLivePlayer localTXLivePlayer = this.kjc;
    if (localTXLivePlayer == null) {
      p.bGy("txLivePlayer");
    }
    if (parame == i.e.RcG) {}
    for (int i = 1;; i = 0)
    {
      localTXLivePlayer.setRenderMode(i);
      AppMethodBeat.o(281242);
      return;
    }
  }
  
  public final void setShouldPlayResume(boolean paramBoolean)
  {
    this.ALk = paramBoolean;
  }
  
  public final void setSupportPauseResume(boolean paramBoolean)
  {
    this.ALm = paramBoolean;
  }
  
  public final void setTextureView(d paramd)
  {
    AppMethodBeat.i(281210);
    p.k(paramd, "<set-?>");
    this.ALe = paramd;
    AppMethodBeat.o(281210);
  }
  
  public final void setTxLivePlayer(TXLivePlayer paramTXLivePlayer)
  {
    AppMethodBeat.i(281206);
    p.k(paramTXLivePlayer, "<set-?>");
    this.kjc = paramTXLivePlayer;
    AppMethodBeat.o(281206);
  }
  
  public final void setVideoMuteListener(u paramu)
  {
    AppMethodBeat.i(281246);
    p.k(paramu, "muteListener");
    AppMethodBeat.o(281246);
  }
  
  public final void setVideoPlayLifecycle(z paramz)
  {
    AppMethodBeat.i(281245);
    p.k(paramz, "lifecycle");
    aex("setVideoPlayLifecycle _callback:" + paramz.hashCode());
    this.ALf = paramz;
    AppMethodBeat.o(281245);
  }
  
  public final void setVideoViewCallback(i.b paramb)
  {
    this.zxu = paramb;
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    AppMethodBeat.i(281223);
    Log.i(this.TAG, "setVideoViewFocused ".concat(String.valueOf(paramBoolean)));
    this.ALj = paramBoolean;
    AppMethodBeat.o(281223);
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.ALj = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(281233);
    aex("stop");
    Object localObject = this.kjc;
    if (localObject == null) {
      p.bGy("txLivePlayer");
    }
    ((TXLivePlayer)localObject).stopPlay(true);
    this.fEs = false;
    this.ALl = true;
    localObject = this.ALf;
    if (localObject != null)
    {
      z.a.a((z)localObject, this.ALh);
      AppMethodBeat.o(281233);
      return;
    }
    AppMethodBeat.o(281233);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/video/FinderLivePlayView$playListener$1", "Lcom/tencent/rtmp/ITXLivePlayListener;", "onNetStatus", "", "params", "Landroid/os/Bundle;", "onPlayEvent", "event", "", "plugin-finder_release"})
  public static final class a
    implements ITXLivePlayListener
  {
    public final void onNetStatus(Bundle paramBundle)
    {
      AppMethodBeat.i(290838);
      int i = NetStatusUtil.getNetType(this.ALn.getContext());
      paramBundle = FinderLivePlayView.d(this.ALn);
      Object localObject1 = new StringBuilder("onNetStatus curPlayStatus:").append(FinderLivePlayView.e(this.ALn)).append(", netQuality:").append(i).append(", isPlaying:");
      Object localObject2 = this.ALn.getTxLivePlayer();
      if ((localObject2 != null) && (((TXLivePlayer)localObject2).isPlaying() == true)) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i(paramBundle, bool);
        if ((this.ALn.getTxLivePlayer().isPlaying() != true) || (i == -1) || (FinderLivePlayView.e(this.ALn) != -2301)) {
          break;
        }
        paramBundle = FinderLivePlayView.a(this.ALn);
        if (paramBundle == null) {
          break;
        }
        if ((!Util.isNullOrNil(paramBundle.downloadUrl)) && (paramBundle.downloadUrl != null))
        {
          this.ALn.getTxLivePlayer().stopPlay(false);
          localObject2 = this.ALn;
          localObject1 = paramBundle.downloadUrl;
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = "";
          }
          FinderLivePlayView.b((FinderLivePlayView)localObject2, paramBundle);
        }
        AppMethodBeat.o(290838);
        return;
      }
      AppMethodBeat.o(290838);
    }
    
    public final void onPlayEvent(int paramInt, Bundle paramBundle)
    {
      boolean bool3 = true;
      boolean bool2 = true;
      int i = 0;
      AppMethodBeat.i(290837);
      Object localObject = FinderLivePlayView.d(this.ALn);
      StringBuilder localStringBuilder = new StringBuilder("onPlayEvent:").append(paramInt).append(", isPlaying:");
      TXLivePlayer localTXLivePlayer = this.ALn.getTxLivePlayer();
      if ((localTXLivePlayer != null) && (localTXLivePlayer.isPlaying() == true)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        Log.i((String)localObject, bool1);
        if (this.ALn.getTxLivePlayer().isPlaying()) {
          FinderLivePlayView.a(this.ALn, paramInt);
        }
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(290837);
          return;
        }
      }
      localObject = this.ALn;
      localStringBuilder = new StringBuilder("onPlayEvent ");
      if (paramInt == 2004)
      {
        paramBundle = "EVT_VIDEO_PLAY_BEGIN";
        FinderLivePlayView.a((FinderLivePlayView)localObject, paramBundle);
        paramBundle = this.ALn.getLifecycle();
        if (paramBundle != null)
        {
          FinderLivePlayView.a(this.ALn);
          paramBundle.dJV();
        }
        paramBundle = this.ALn.getLifecycle();
        if (paramBundle != null)
        {
          FinderLivePlayView.a(this.ALn);
          paramBundle.Ma(0L);
        }
        paramBundle = FinderLivePlayView.a(this.ALn);
        if (paramBundle == null) {
          break label394;
        }
        paramBundle = paramBundle.xzp;
        if (paramBundle == null) {
          break label394;
        }
        paramInt = paramBundle.getAnchorStatus();
        label296:
        if (!com.tencent.mm.ae.d.dr(paramInt, 256)) {
          break label399;
        }
        FinderLivePlayView.b(this.ALn);
      }
      for (;;)
      {
        paramBundle = FinderLivePlayView.f(this.ALn);
        if (paramBundle == null) {
          break label409;
        }
        if (paramBundle.enable)
        {
          paramBundle.xzk = false;
          paramBundle.xzl = new com.tencent.mm.plugin.finder.feed.z.a();
          paramBundle.xzm = new com.tencent.mm.plugin.finder.feed.z.a();
          paramBundle.xzn = new cud();
          paramBundle.xzo.clear();
          paramBundle.xzj = false;
        }
        AppMethodBeat.o(290837);
        return;
        paramBundle = "PLAY_EVT_CONNECT_SUCC";
        break;
        label394:
        paramInt = 0;
        break label296;
        label399:
        FinderLivePlayView.c(this.ALn);
      }
      label409:
      AppMethodBeat.o(290837);
      return;
      localObject = this.ALn;
      localStringBuilder = new StringBuilder("onPlayEvent ");
      if (paramInt == 2004) {}
      for (paramBundle = "EVT_VIDEO_PLAY_BEGIN";; paramBundle = "PLAY_EVT_CONNECT_SUCC")
      {
        FinderLivePlayView.a((FinderLivePlayView)localObject, paramBundle);
        paramBundle = this.ALn.getLifecycle();
        if (paramBundle != null)
        {
          FinderLivePlayView.a(this.ALn);
          paramBundle.dJV();
        }
        paramBundle = this.ALn.getLifecycle();
        if (paramBundle != null)
        {
          FinderLivePlayView.a(this.ALn);
          paramBundle.Ma(0L);
        }
        paramBundle = FinderLivePlayView.a(this.ALn);
        paramInt = i;
        if (paramBundle != null)
        {
          paramBundle = paramBundle.xzp;
          paramInt = i;
          if (paramBundle != null) {
            paramInt = paramBundle.getAnchorStatus();
          }
        }
        if (!com.tencent.mm.ae.d.dr(paramInt, 256)) {
          break;
        }
        FinderLivePlayView.b(this.ALn);
        AppMethodBeat.o(290837);
        return;
      }
      FinderLivePlayView.c(this.ALn);
      AppMethodBeat.o(290837);
      return;
      if (NetStatusUtil.getNetType(this.ALn.getContext()) == -1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        FinderLivePlayView.a(this.ALn, "onPlayEvent PLAY_WARNING_RECONNECT, non_network:".concat(String.valueOf(bool1)));
        AppMethodBeat.o(290837);
        return;
      }
      if (NetStatusUtil.getNetType(this.ALn.getContext()) == -1) {}
      for (bool1 = bool3;; bool1 = false)
      {
        FinderLivePlayView.a(this.ALn, "onPlayEvent PLAY_ERR_NET_DISCONNECT, non_network:".concat(String.valueOf(bool1)));
        this.ALn.getTxLivePlayer().stopPlay(false);
        AppMethodBeat.o(290837);
        return;
      }
      if (paramBundle != null)
      {
        paramInt = paramBundle.getInt("EVT_PARAM1");
        if (paramBundle == null) {
          break label780;
        }
      }
      label780:
      for (i = paramBundle.getInt("EVT_PARAM2");; i = 0)
      {
        FinderLivePlayView.a(this.ALn, "onPlayEvent PLAY_EVT_CHANGE_RESOLUTION, w:h=" + paramInt + ':' + i);
        paramBundle = FinderLivePlayView.f(this.ALn);
        if (paramBundle != null) {
          paramBundle.gB(paramInt, i);
        }
        if (this.ALn.ALg) {
          break label785;
        }
        AppMethodBeat.o(290837);
        return;
        paramInt = 0;
        break;
      }
      label785:
      if (i > paramInt) {
        this.ALn.getTxLivePlayer().setRenderMode(0);
      }
      for (;;)
      {
        FinderLivePlayView.a(this.ALn, paramInt, i);
        AppMethodBeat.o(290837);
        return;
        this.ALn.getTxLivePlayer().setRenderMode(1);
      }
      if (paramBundle != null) {}
      for (paramBundle = paramBundle.getByteArray("EVT_GET_MSG");; paramBundle = null)
      {
        localObject = FinderLivePlayView.f(this.ALn);
        if (localObject == null) {
          break;
        }
        ((com.tencent.mm.plugin.finder.feed.z)localObject).bT(paramBundle);
        AppMethodBeat.o(290837);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MMLiveSEIMsgConnectMicUserInfo;", "invoke"})
  static final class b
    extends q
    implements b<LinkedList<cue>, x>
  {
    b(FinderLivePlayView paramFinderLivePlayView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderLivePlayView
 * JD-Core Version:    0.7.0.1
 */