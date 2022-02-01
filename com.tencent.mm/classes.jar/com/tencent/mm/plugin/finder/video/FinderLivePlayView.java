package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/video/FinderLivePlayView;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "curPlayerStatus", "isAutoJustRenderMode", "", "()Z", "setAutoJustRenderMode", "(Z)V", "isNeverStart", "setNeverStart", "isPause", "isPreviewing", "isShouldPlayResume", "setShouldPlayResume", "isSupportPauseResume", "setSupportPauseResume", "isViewFocused", "setViewFocused", "lifecycle", "Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "getLifecycle", "()Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;", "setLifecycle", "(Lcom/tencent/mm/plugin/finder/video/VideoPlayLifecycle;)V", "mediaInfo", "Lcom/tencent/mm/plugin/finder/video/MediaInfo;", "playListener", "Lcom/tencent/rtmp/ITXLivePlayListener;", "getPlayListener", "()Lcom/tencent/rtmp/ITXLivePlayListener;", "textureView", "Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;", "getTextureView", "()Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;", "setTextureView", "(Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;)V", "txLivePlayer", "Lcom/tencent/rtmp/TXLivePlayer;", "getTxLivePlayer", "()Lcom/tencent/rtmp/TXLivePlayer;", "setTxLivePlayer", "(Lcom/tencent/rtmp/TXLivePlayer;)V", "videoViewCallback", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "getVideoViewCallback", "()Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "setVideoViewCallback", "(Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;)V", "getBitmap", "Landroid/graphics/Bitmap;", "getCurrentPlayMs", "", "getCurrentPlaySecond", "getIsNeverStart", "getIsShouldPlayResume", "getParentView", "Landroid/view/ViewParent;", "getVideoDuration", "getVideoDurationMs", "getVideoMediaId", "getVideoMediaInfo", "getVideoView", "getVideoViewFocused", "init", "", "isPlaying", "onRelease", "onUIDestroy", "pause", "pauseWithCancel", "play", "prepareToPlay", "print", "str", "removeVideoFooterView", "seekTo", "timestamp", "", "afterSeekPlay", "setFinderVideoCore", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "setIMMVideoViewCallback", "_callback", "setIOnlineVideoProxy", "_proxy", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "setInterceptDetach", "isInterceptDetach", "setIsShouldPlayResume", "shouldPlayResume", "setIsShowBasicControls", "isShow", "setLoop", "loop", "setMute", "isMute", "setPreview", "isPreview", "setScaleType", "scaleType", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$ScaleType;", "setVideoMediaInfo", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isLocal", "feedData", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "setVideoMuteListener", "muteListener", "Lcom/tencent/mm/plugin/finder/video/OnMuteListener;", "setVideoPlayLifecycle", "setVideoViewFocused", "focused", "start", "downloadUrl", "startOrPlay", "stop", "plugin-finder_release"})
public final class FinderLivePlayView
  extends FrameLayout
  implements r
{
  private final String TAG;
  private boolean dLD;
  private int hCl;
  public TXLivePlayer hwO;
  private boolean sZd;
  private boolean wcA;
  private boolean wcB;
  private volatile boolean wcC;
  private boolean wcD;
  public d wcu;
  private i.b wcv;
  private y wcw;
  boolean wcx;
  private s wcy;
  private final ITXLivePlayListener wcz;
  
  public FinderLivePlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(254045);
    this.TAG = "Finder.FinderLivePlayView";
    this.wcz = ((ITXLivePlayListener)new a(this));
    this.wcC = true;
    init();
    AppMethodBeat.o(254045);
  }
  
  public FinderLivePlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(254046);
    this.TAG = "Finder.FinderLivePlayView";
    this.wcz = ((ITXLivePlayListener)new a(this));
    this.wcC = true;
    init();
    AppMethodBeat.o(254046);
  }
  
  public FinderLivePlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(254047);
    this.TAG = "Finder.FinderLivePlayView";
    this.wcz = ((ITXLivePlayListener)new a(this));
    this.wcC = true;
    init();
    AppMethodBeat.o(254047);
  }
  
  private void init()
  {
    AppMethodBeat.i(254021);
    Object localObject1 = getContext();
    p.g(localObject1, "context");
    this.wcu = new d((Context)localObject1);
    localObject1 = new FrameLayout.LayoutParams(-1, -1);
    Object localObject2 = this.wcu;
    if (localObject2 == null) {
      p.btv("textureView");
    }
    addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    this.hwO = new TXLivePlayer(getContext());
    localObject1 = new TXLivePlayConfig();
    ((TXLivePlayConfig)localObject1).setAutoAdjustCacheTime(true);
    ((TXLivePlayConfig)localObject1).setMinAutoAdjustCacheTime(1.0F);
    ((TXLivePlayConfig)localObject1).setMaxAutoAdjustCacheTime(1.0F);
    localObject2 = this.hwO;
    if (localObject2 == null) {
      p.btv("txLivePlayer");
    }
    d locald = this.wcu;
    if (locald == null) {
      p.btv("textureView");
    }
    ((TXLivePlayer)localObject2).setPlayerView((TXCloudVideoView)locald);
    localObject2 = this.hwO;
    if (localObject2 == null) {
      p.btv("txLivePlayer");
    }
    ((TXLivePlayer)localObject2).setPlayListener(this.wcz);
    localObject2 = this.hwO;
    if (localObject2 == null) {
      p.btv("txLivePlayer");
    }
    ((TXLivePlayer)localObject2).setConfig((TXLivePlayConfig)localObject1);
    localObject1 = this.hwO;
    if (localObject1 == null) {
      p.btv("txLivePlayer");
    }
    ((TXLivePlayer)localObject1).setRenderMode(0);
    AppMethodBeat.o(254021);
  }
  
  private final void print(String paramString)
  {
    AppMethodBeat.i(254044);
    Log.i(this.TAG, hashCode() + " === " + paramString);
    AppMethodBeat.o(254044);
  }
  
  private final void start(String paramString)
  {
    AppMethodBeat.i(254029);
    print("start, ".concat(String.valueOf(paramString)));
    Object localObject;
    if ((this.dLD) && (this.wcD))
    {
      paramString = this.hwO;
      if (paramString == null) {
        p.btv("txLivePlayer");
      }
      paramString.resume();
      paramString = com.tencent.mm.plugin.finder.report.live.k.vkd;
      localObject = s.p.voA;
      paramString = this.wcy;
      if (paramString == null) {
        break label112;
      }
    }
    label112:
    for (paramString = paramString.wgm;; paramString = null)
    {
      com.tencent.mm.plugin.finder.report.live.k.a((s.p)localObject, paramString);
      AppMethodBeat.o(254029);
      return;
      localObject = this.hwO;
      if (localObject == null) {
        p.btv("txLivePlayer");
      }
      ((TXLivePlayer)localObject).startPlay(paramString, 1);
      break;
    }
  }
  
  public final void a(com.tencent.mm.plugin.finder.loader.s params, boolean paramBoolean, FeedData paramFeedData)
  {
    AppMethodBeat.i(254038);
    p.h(params, "video");
    p.h(paramFeedData, "feedData");
    print("setVideoMediaInfo " + params.getUrl());
    this.wcy = new s(params.getUrl(), params.getPath(), params.auA(), params.uIw, params, paramFeedData);
    AppMethodBeat.o(254038);
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    return false;
  }
  
  public final boolean dEN()
  {
    AppMethodBeat.i(254030);
    print("prepareToPlay");
    AppMethodBeat.o(254030);
    return true;
  }
  
  public final boolean dEO()
  {
    return this.sZd;
  }
  
  public final boolean dFj()
  {
    AppMethodBeat.i(254028);
    StringBuilder localStringBuilder = new StringBuilder("startOrPlay, ");
    Object localObject = this.wcy;
    if (localObject != null) {}
    for (localObject = ((s)localObject).downloadUrl;; localObject = null)
    {
      print((String)localObject);
      if (this.wcA) {
        break;
      }
      Log.i(this.TAG, "startOrPlay, return, isViewFocused:" + this.wcA);
      AppMethodBeat.o(254028);
      return false;
    }
    if (isPlaying())
    {
      Log.i(this.TAG, "startOrPlay, return, isPlaying!");
      AppMethodBeat.o(254028);
      return false;
    }
    localObject = this.wcy;
    if ((localObject != null) && (!Util.isNullOrNil(((s)localObject).downloadUrl)) && (((s)localObject).downloadUrl != null))
    {
      start(((s)localObject).downloadUrl);
      this.wcC = false;
      AppMethodBeat.o(254028);
      return true;
    }
    AppMethodBeat.o(254028);
    return false;
  }
  
  public final int dFk()
  {
    AppMethodBeat.i(254032);
    print("pauseWithCancel");
    TXLivePlayer localTXLivePlayer = this.hwO;
    if (localTXLivePlayer == null) {
      p.btv("txLivePlayer");
    }
    localTXLivePlayer.pause();
    this.dLD = true;
    AppMethodBeat.o(254032);
    return 0;
  }
  
  public final void dFl() {}
  
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
    return this.wcC;
  }
  
  public final boolean getIsShouldPlayResume()
  {
    return this.wcB;
  }
  
  public final y getLifecycle()
  {
    return this.wcw;
  }
  
  public final ViewParent getParentView()
  {
    AppMethodBeat.i(254023);
    ViewParent localViewParent = getParent();
    AppMethodBeat.o(254023);
    return localViewParent;
  }
  
  public final ITXLivePlayListener getPlayListener()
  {
    return this.wcz;
  }
  
  public final d getTextureView()
  {
    AppMethodBeat.i(254019);
    d locald = this.wcu;
    if (locald == null) {
      p.btv("textureView");
    }
    AppMethodBeat.o(254019);
    return locald;
  }
  
  public final TXLivePlayer getTxLivePlayer()
  {
    AppMethodBeat.i(254017);
    TXLivePlayer localTXLivePlayer = this.hwO;
    if (localTXLivePlayer == null) {
      p.btv("txLivePlayer");
    }
    AppMethodBeat.o(254017);
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
    Object localObject = this.wcy;
    if (localObject != null)
    {
      String str = ((s)localObject).mediaId;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "";
    }
    return localObject;
  }
  
  public final s getVideoMediaInfo()
  {
    return this.wcy;
  }
  
  public final FinderLivePlayView getVideoView()
  {
    return this;
  }
  
  public final i.b getVideoViewCallback()
  {
    return this.wcv;
  }
  
  public final boolean getVideoViewFocused()
  {
    return this.wcA;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(254034);
    TXLivePlayer localTXLivePlayer = this.hwO;
    if (localTXLivePlayer == null) {
      p.btv("txLivePlayer");
    }
    boolean bool = localTXLivePlayer.isPlaying();
    AppMethodBeat.o(254034);
    return bool;
  }
  
  public final void onRelease()
  {
    AppMethodBeat.i(254037);
    print("onRelease");
    this.dLD = false;
    AppMethodBeat.o(254037);
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(254036);
    print("onUIDestroy");
    stop();
    AppMethodBeat.o(254036);
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(254031);
    print("pause");
    Object localObject = this.hwO;
    if (localObject == null) {
      p.btv("txLivePlayer");
    }
    ((TXLivePlayer)localObject).pause();
    this.dLD = true;
    localObject = this.wcw;
    if (localObject != null) {
      ((y)localObject).dFL();
    }
    AppMethodBeat.o(254031);
    return true;
  }
  
  public final boolean play()
  {
    AppMethodBeat.i(254027);
    print("play");
    Object localObject = this.hwO;
    if (localObject == null) {
      p.btv("txLivePlayer");
    }
    ((TXLivePlayer)localObject).resume();
    localObject = this.wcw;
    if (localObject != null) {
      ((y)localObject).dFN();
    }
    AppMethodBeat.o(254027);
    return true;
  }
  
  public final void setAutoJustRenderMode(boolean paramBoolean)
  {
    this.wcx = paramBoolean;
  }
  
  public final void setFinderVideoCore(k paramk) {}
  
  public final void setIMMVideoViewCallback(i.b paramb)
  {
    AppMethodBeat.i(254039);
    p.h(paramb, "_callback");
    print("setIMMVideoViewCallback _callback:" + paramb.hashCode());
    this.wcv = paramb;
    AppMethodBeat.o(254039);
  }
  
  public final void setIOnlineVideoProxy(b paramb)
  {
    AppMethodBeat.i(254041);
    p.h(paramb, "_proxy");
    AppMethodBeat.o(254041);
  }
  
  public final void setInterceptDetach(boolean paramBoolean) {}
  
  public final void setIsShouldPlayResume(boolean paramBoolean)
  {
    AppMethodBeat.i(254024);
    print("setIsShouldPlayResume: ".concat(String.valueOf(paramBoolean)));
    this.wcB = paramBoolean;
    AppMethodBeat.o(254024);
  }
  
  public final void setIsShowBasicControls(boolean paramBoolean) {}
  
  public final void setLifecycle(y paramy)
  {
    this.wcw = paramy;
  }
  
  public final void setLoop(boolean paramBoolean) {}
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(254035);
    print("setMute ".concat(String.valueOf(paramBoolean)));
    TXLivePlayer localTXLivePlayer = this.hwO;
    if (localTXLivePlayer == null) {
      p.btv("txLivePlayer");
    }
    localTXLivePlayer.setMute(paramBoolean);
    AppMethodBeat.o(254035);
  }
  
  public final void setNeverStart(boolean paramBoolean)
  {
    this.wcC = paramBoolean;
  }
  
  public final void setPreview(boolean paramBoolean)
  {
    AppMethodBeat.i(254026);
    print("setPreview: ".concat(String.valueOf(paramBoolean)));
    this.sZd = paramBoolean;
    AppMethodBeat.o(254026);
  }
  
  public final void setScaleType(i.e parame)
  {
    AppMethodBeat.i(254040);
    p.h(parame, "scaleType");
    TXLivePlayer localTXLivePlayer = this.hwO;
    if (localTXLivePlayer == null) {
      p.btv("txLivePlayer");
    }
    if (parame == i.e.Kcb) {}
    for (int i = 1;; i = 0)
    {
      localTXLivePlayer.setRenderMode(i);
      AppMethodBeat.o(254040);
      return;
    }
  }
  
  public final void setShouldPlayResume(boolean paramBoolean)
  {
    this.wcB = paramBoolean;
  }
  
  public final void setSupportPauseResume(boolean paramBoolean)
  {
    this.wcD = paramBoolean;
  }
  
  public final void setTextureView(d paramd)
  {
    AppMethodBeat.i(254020);
    p.h(paramd, "<set-?>");
    this.wcu = paramd;
    AppMethodBeat.o(254020);
  }
  
  public final void setTxLivePlayer(TXLivePlayer paramTXLivePlayer)
  {
    AppMethodBeat.i(254018);
    p.h(paramTXLivePlayer, "<set-?>");
    this.hwO = paramTXLivePlayer;
    AppMethodBeat.o(254018);
  }
  
  public final void setVideoMuteListener(t paramt)
  {
    AppMethodBeat.i(254043);
    p.h(paramt, "muteListener");
    AppMethodBeat.o(254043);
  }
  
  public final void setVideoPlayLifecycle(y paramy)
  {
    AppMethodBeat.i(254042);
    p.h(paramy, "lifecycle");
    print("setVideoPlayLifecycle _callback:" + paramy.hashCode());
    this.wcw = paramy;
    AppMethodBeat.o(254042);
  }
  
  public final void setVideoViewCallback(i.b paramb)
  {
    this.wcv = paramb;
  }
  
  public final void setVideoViewFocused(boolean paramBoolean)
  {
    AppMethodBeat.i(254025);
    Log.i(this.TAG, "setVideoViewFocused ".concat(String.valueOf(paramBoolean)));
    this.wcA = paramBoolean;
    AppMethodBeat.o(254025);
  }
  
  public final void setViewFocused(boolean paramBoolean)
  {
    this.wcA = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(254033);
    print("stop");
    Object localObject = this.hwO;
    if (localObject == null) {
      p.btv("txLivePlayer");
    }
    ((TXLivePlayer)localObject).stopPlay(true);
    this.dLD = false;
    this.wcC = true;
    localObject = this.wcw;
    if (localObject != null)
    {
      ((y)localObject).b(this.wcy);
      AppMethodBeat.o(254033);
      return;
    }
    AppMethodBeat.o(254033);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/video/FinderLivePlayView$playListener$1", "Lcom/tencent/rtmp/ITXLivePlayListener;", "onNetStatus", "", "params", "Landroid/os/Bundle;", "onPlayEvent", "event", "", "plugin-finder_release"})
  public static final class a
    implements ITXLivePlayListener
  {
    public final void onNetStatus(Bundle paramBundle)
    {
      AppMethodBeat.i(254016);
      int i = NetStatusUtil.getNetType(this.wcE.getContext());
      paramBundle = FinderLivePlayView.a(this.wcE);
      StringBuilder localStringBuilder = new StringBuilder("onNetStatus curPlayStatus:").append(FinderLivePlayView.b(this.wcE)).append(", netQuality:").append(i).append(", isPlaying:");
      TXLivePlayer localTXLivePlayer = this.wcE.getTxLivePlayer();
      if ((localTXLivePlayer != null) && (localTXLivePlayer.isPlaying() == true)) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i(paramBundle, bool);
        if ((this.wcE.getTxLivePlayer().isPlaying() != true) || (i == -1) || (FinderLivePlayView.b(this.wcE) != -2301)) {
          break;
        }
        paramBundle = FinderLivePlayView.c(this.wcE);
        if (paramBundle == null) {
          break;
        }
        if ((!Util.isNullOrNil(paramBundle.downloadUrl)) && (paramBundle.downloadUrl != null))
        {
          this.wcE.getTxLivePlayer().stopPlay(false);
          FinderLivePlayView.b(this.wcE, paramBundle.downloadUrl);
        }
        AppMethodBeat.o(254016);
        return;
      }
      AppMethodBeat.o(254016);
    }
    
    public final void onPlayEvent(int paramInt, Bundle paramBundle)
    {
      boolean bool3 = true;
      boolean bool2 = true;
      AppMethodBeat.i(254015);
      Object localObject = FinderLivePlayView.a(this.wcE);
      StringBuilder localStringBuilder = new StringBuilder("onPlayEvent:").append(paramInt).append(", isPlaying:");
      TXLivePlayer localTXLivePlayer = this.wcE.getTxLivePlayer();
      boolean bool1;
      if ((localTXLivePlayer != null) && (localTXLivePlayer.isPlaying() == true))
      {
        bool1 = true;
        Log.i((String)localObject, bool1);
        if (this.wcE.getTxLivePlayer().isPlaying())
        {
          FinderLivePlayView.a(this.wcE, paramInt);
          switch (paramInt)
          {
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(254015);
        return;
        bool1 = false;
        break;
        localObject = this.wcE;
        localStringBuilder = new StringBuilder("onPlayEvent ");
        if (paramInt == 2004) {}
        for (paramBundle = "EVT_VIDEO_PLAY_BEGIN";; paramBundle = "PLAY_EVT_CONNECT_SUCC")
        {
          FinderLivePlayView.a((FinderLivePlayView)localObject, paramBundle);
          paramBundle = this.wcE.getLifecycle();
          if (paramBundle != null)
          {
            FinderLivePlayView.c(this.wcE);
            paramBundle.dFN();
          }
          paramBundle = this.wcE.getLifecycle();
          if (paramBundle == null) {
            break;
          }
          FinderLivePlayView.c(this.wcE);
          paramBundle.Gr(0L);
          AppMethodBeat.o(254015);
          return;
        }
        AppMethodBeat.o(254015);
        return;
        if (NetStatusUtil.getNetType(this.wcE.getContext()) == -1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          FinderLivePlayView.a(this.wcE, "onPlayEvent PLAY_WARNING_RECONNECT, non_network:".concat(String.valueOf(bool1)));
          AppMethodBeat.o(254015);
          return;
        }
        if (NetStatusUtil.getNetType(this.wcE.getContext()) == -1) {}
        for (bool1 = bool3;; bool1 = false)
        {
          FinderLivePlayView.a(this.wcE, "onPlayEvent PLAY_ERR_NET_DISCONNECT, non_network:".concat(String.valueOf(bool1)));
          this.wcE.getTxLivePlayer().stopPlay(false);
          AppMethodBeat.o(254015);
          return;
        }
        if (!this.wcE.wcx)
        {
          AppMethodBeat.o(254015);
          return;
        }
        if (paramBundle != null)
        {
          paramInt = paramBundle.getInt("EVT_PARAM1");
          if (paramBundle == null) {
            break label479;
          }
        }
        label479:
        for (int i = paramBundle.getInt("EVT_PARAM2");; i = 0)
        {
          FinderLivePlayView.a(this.wcE, "onPlayEvent PLAY_EVT_CHANGE_RESOLUTION, w:h=" + paramInt + ':' + i);
          if (i <= paramInt) {
            break label484;
          }
          this.wcE.getTxLivePlayer().setRenderMode(0);
          AppMethodBeat.o(254015);
          return;
          paramInt = 0;
          break;
        }
        label484:
        this.wcE.getTxLivePlayer().setRenderMode(1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderLivePlayView
 * JD-Core Version:    0.7.0.1
 */