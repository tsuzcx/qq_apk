package com.tencent.mm.plugin.finder.nearby.live.play;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.feed.z;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.j;
import com.tencent.mm.plugin.finder.video.d;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.cue;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePreviewView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "audioEnableView", "Lorg/libpag/PAGView;", "curPlayerStatus", "decorateView", "Landroid/widget/RelativeLayout;", "isAutoRenderMode", "", "isFinishLive", "isMute", "isPause", "liveFeedDecorator", "Lcom/tencent/mm/plugin/finder/feed/FinderLiveFeedDecorator;", "mediaSource", "Lcom/tencent/mm/plugin/finder/nearby/live/play/LiveSource;", "onFirstFrameRendStart", "Lkotlin/Function0;", "", "player", "Lcom/tencent/rtmp/TXLivePlayer;", "getPlayer", "()Lcom/tencent/rtmp/TXLivePlayer;", "setPlayer", "(Lcom/tencent/rtmp/TXLivePlayer;)V", "renderView", "Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;", "getRenderView", "()Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;", "setRenderView", "(Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;)V", "tabId", "voipCallEvent", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "addAudioEnableView", "dismissRenderView", "getMediaSource", "init", "isPlaying", "isUsePhone", "isVoip", "notifyLiveFinish", "pause", "print", "str", "", "release", "restart", "setMediaSource", "setMute", "setScaleMode", "scaleMode", "showRenderView", "start", "startAudioEnableView", "stop", "stopAudioEnableView", "Companion", "LivePlayerListener", "plugin-finder-nearby_release"})
public final class NearbyLivePreviewView
  extends FrameLayout
{
  public static final a zFM;
  boolean fEs;
  private int fXY;
  boolean iYs;
  private int kqn;
  public TXLivePlayer xVE;
  public d xVF;
  private boolean xVH;
  private boolean xVI;
  kotlin.g.a.a<x> xVJ;
  private RelativeLayout xVK;
  private z xVL;
  private final IListener<aaq> yhs;
  private PAGView zFK;
  private a zFL;
  
  static
  {
    AppMethodBeat.i(199797);
    zFM = new a((byte)0);
    AppMethodBeat.o(199797);
  }
  
  public NearbyLivePreviewView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(199788);
    this.fXY = -1;
    this.iYs = true;
    this.yhs = ((IListener)new d(this));
    init();
    AppMethodBeat.o(199788);
  }
  
  public NearbyLivePreviewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(199791);
    this.fXY = -1;
    this.iYs = true;
    this.yhs = ((IListener)new d(this));
    init();
    AppMethodBeat.o(199791);
  }
  
  public NearbyLivePreviewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(199794);
    this.fXY = -1;
    this.iYs = true;
    this.yhs = ((IListener)new d(this));
    init();
    AppMethodBeat.o(199794);
  }
  
  private final void dLV()
  {
    AppMethodBeat.i(199775);
    aex("stopAudioEnableView");
    PAGView localPAGView = this.zFK;
    if (localPAGView != null) {
      localPAGView.setVisibility(4);
    }
    localPAGView = this.zFK;
    if (localPAGView != null)
    {
      localPAGView.stop();
      AppMethodBeat.o(199775);
      return;
    }
    AppMethodBeat.o(199775);
  }
  
  private static boolean dLW()
  {
    AppMethodBeat.i(199780);
    boolean bool;
    try
    {
      Object localObject = MMApplicationContext.getContext().getSystemService("phone");
      if (localObject != null) {
        break label70;
      }
      localObject = new t("null cannot be cast to non-null type android.telephony.TelephonyManager");
      AppMethodBeat.o(199780);
      throw ((Throwable)localObject);
    }
    catch (Exception localException1)
    {
      bool = false;
    }
    Log.e("NearbyLivePreviewView", "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
    for (;;)
    {
      AppMethodBeat.o(199780);
      return bool;
      label70:
      TelephonyManager localTelephonyManager = (TelephonyManager)localException1;
      if (localTelephonyManager != null)
      {
        int i = localTelephonyManager.getCallState();
        switch (i)
        {
        default: 
          bool = false;
        }
        for (;;)
        {
          try
          {
            Log.i("NearbyLivePreviewView", "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
          }
          catch (Exception localException2) {}
          break;
          bool = false;
          continue;
          bool = true;
        }
      }
      bool = false;
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(199740);
    Object localObject1 = getContext();
    p.j(localObject1, "context");
    this.xVF = new d((Context)localObject1);
    this.xVK = new RelativeLayout(getContext());
    localObject1 = new FrameLayout.LayoutParams(-1, -1);
    Object localObject2 = new FrameLayout.LayoutParams(-1, -1);
    d locald = this.xVF;
    if (locald == null) {
      p.bGy("renderView");
    }
    addView((View)locald, (ViewGroup.LayoutParams)localObject1);
    addView((View)this.xVK, (ViewGroup.LayoutParams)localObject2);
    this.xVE = new TXLivePlayer(getContext());
    localObject1 = new TXLivePlayConfig();
    ((TXLivePlayConfig)localObject1).setAutoAdjustCacheTime(true);
    ((TXLivePlayConfig)localObject1).setMinAutoAdjustCacheTime(1.0F);
    ((TXLivePlayConfig)localObject1).setMaxAutoAdjustCacheTime(1.0F);
    ((TXLivePlayConfig)localObject1).setEnableMessage(true);
    localObject2 = this.xVE;
    if (localObject2 == null) {
      p.bGy("player");
    }
    locald = this.xVF;
    if (locald == null) {
      p.bGy("renderView");
    }
    ((TXLivePlayer)localObject2).setPlayerView((TXCloudVideoView)locald);
    localObject2 = this.xVE;
    if (localObject2 == null) {
      p.bGy("player");
    }
    ((TXLivePlayer)localObject2).setPlayListener((ITXLivePlayListener)new b());
    localObject2 = this.xVE;
    if (localObject2 == null) {
      p.bGy("player");
    }
    ((TXLivePlayer)localObject2).setConfig((TXLivePlayConfig)localObject1);
    localObject1 = this.xVE;
    if (localObject1 == null) {
      p.bGy("player");
    }
    ((TXLivePlayer)localObject1).setRenderMode(0);
    this.xVI = false;
    setMute(true);
    this.xVL = new z(1, (ViewGroup)this.xVK);
    localObject1 = new StringBuilder("init view:");
    localObject2 = this.xVF;
    if (localObject2 == null) {
      p.bGy("renderView");
    }
    localObject1 = ((StringBuilder)localObject1).append(localObject2).append(" player:");
    localObject2 = this.xVF;
    if (localObject2 == null) {
      p.bGy("renderView");
    }
    aex(localObject2);
    AppMethodBeat.o(199740);
  }
  
  public final void V(kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(199764);
    aex("start mediaSource:" + this.zFL + " isPause:" + this.fEs);
    Object localObject;
    if (this.fEs)
    {
      localObject = this.xVE;
      if (localObject == null) {
        p.bGy("player");
      }
      ((TXLivePlayer)localObject).resume();
      if (parama != null) {
        parama.invoke();
      }
    }
    for (;;)
    {
      this.yhs.alive();
      AppMethodBeat.o(199764);
      return;
      localObject = this.zFL;
      if (localObject != null)
      {
        this.xVJ = parama;
        parama = this.xVE;
        if (parama == null) {
          p.bGy("player");
        }
        parama.startPlay(((b)localObject).url, 1);
      }
      else
      {
        aex("start error for mediaSource:" + this.zFL);
      }
    }
  }
  
  final void aex(String paramString)
  {
    AppMethodBeat.i(199786);
    Object localObject1 = this.zFL;
    if (localObject1 != null)
    {
      localObject1 = ((a)localObject1).zFe;
      if (localObject1 != null)
      {
        localObject2 = j.aFz(((BaseFinderFeed)localObject1).feedObject.getNickName());
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label45;
        }
      }
    }
    localObject1 = "NULL";
    label45:
    Object localObject2 = this.zFL;
    if (localObject2 != null)
    {
      localObject2 = ((a)localObject2).zFe;
      if (localObject2 != null)
      {
        localObject2 = ((BaseFinderFeed)localObject2).feedObject;
        if (localObject2 != null)
        {
          localObject2 = ((FinderItem)localObject2).getLiveInfo();
          if (localObject2 == null) {}
        }
      }
    }
    for (localObject2 = Long.valueOf(((bac)localObject2).liveId);; localObject2 = null)
    {
      Log.i("NearbyLivePreviewView", (String)localObject1 + ' ' + localObject2 + ' ' + hashCode() + " == " + paramString);
      AppMethodBeat.o(199786);
      return;
    }
  }
  
  public final void dwG()
  {
    AppMethodBeat.i(199773);
    d locald = this.xVF;
    if (locald == null) {
      p.bGy("renderView");
    }
    locald.setVisibility(4);
    AppMethodBeat.o(199773);
  }
  
  public final void dwH()
  {
    AppMethodBeat.i(199774);
    d locald = this.xVF;
    if (locald == null) {
      p.bGy("renderView");
    }
    locald.setVisibility(0);
    AppMethodBeat.o(199774);
  }
  
  public final a getMediaSource()
  {
    return this.zFL;
  }
  
  public final TXLivePlayer getPlayer()
  {
    AppMethodBeat.i(199727);
    TXLivePlayer localTXLivePlayer = this.xVE;
    if (localTXLivePlayer == null) {
      p.bGy("player");
    }
    AppMethodBeat.o(199727);
    return localTXLivePlayer;
  }
  
  public final d getRenderView()
  {
    AppMethodBeat.i(199732);
    d locald = this.xVF;
    if (locald == null) {
      p.bGy("renderView");
    }
    AppMethodBeat.o(199732);
    return locald;
  }
  
  public final void release()
  {
    AppMethodBeat.i(199770);
    z localz = this.xVL;
    if (localz != null) {
      localz.dtj();
    }
    aex("release");
    AppMethodBeat.o(199770);
  }
  
  public final void setMediaSource(final a parama)
  {
    AppMethodBeat.i(199755);
    p.k(parama, "mediaSource");
    if (TextUtils.isEmpty((CharSequence)parama.url))
    {
      parama = (Throwable)new IllegalArgumentException();
      AppMethodBeat.o(199755);
      throw parama;
    }
    this.zFL = parama;
    Object localObject1 = this.xVL;
    if (localObject1 != null)
    {
      localObject2 = FeedData.Companion;
      ((z)localObject1).a(FeedData.a.j(parama.zFe.feedObject));
    }
    localObject1 = this.xVL;
    if (localObject1 != null) {
      ((z)localObject1).xzq = ((kotlin.g.a.b)new c(this, parama));
    }
    localObject1 = (PAGView)findViewWithTag("NearbyLivePreviewView");
    if (localObject1 != null) {
      removeView((View)localObject1);
    }
    this.zFK = new PAGView(getContext());
    localObject1 = this.zFK;
    if (localObject1 != null)
    {
      localObject2 = getContext();
      p.j(localObject2, "context");
      ((PAGView)localObject1).setFile(PAGFile.Load(((Context)localObject2).getAssets(), "finder_nearby_live_square_card_audio_wave.pag"));
    }
    localObject1 = this.zFK;
    if (localObject1 != null) {
      ((PAGView)localObject1).setRepeatCount(-1);
    }
    localObject1 = getContext();
    p.j(localObject1, "context");
    int i = ((Context)localObject1).getResources().getDimensionPixelSize(b.d.Edge_3A);
    localObject1 = new FrameLayout.LayoutParams(i, i);
    Object localObject2 = getContext();
    p.j(localObject2, "context");
    int j = ((Context)localObject2).getResources().getDimensionPixelSize(b.d.Edge_1_5_A);
    localObject2 = this.zFL;
    if ((localObject2 != null) && (((a)localObject2).zFf == true)) {}
    for (i = 51;; i = 53)
    {
      ((FrameLayout.LayoutParams)localObject1).gravity = i;
      ((FrameLayout.LayoutParams)localObject1).leftMargin = j;
      ((FrameLayout.LayoutParams)localObject1).topMargin = j;
      ((FrameLayout.LayoutParams)localObject1).rightMargin = j;
      localObject2 = this.zFK;
      if (localObject2 != null) {
        ((PAGView)localObject2).setVisibility(4);
      }
      localObject2 = this.zFK;
      if (localObject2 != null) {
        ((PAGView)localObject2).setTag("NearbyLivePreviewView");
      }
      addView((View)this.zFK, (ViewGroup.LayoutParams)localObject1);
      aex("setMediaSource mediaSource:".concat(String.valueOf(parama)));
      AppMethodBeat.o(199755);
      return;
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    boolean bool3 = true;
    AppMethodBeat.i(199760);
    if ((com.tencent.mm.q.a.aAo()) && (!paramBoolean)) {
      Log.i("NearbyLivePreviewView", "setMute true for playing.");
    }
    for (boolean bool2 = true;; bool2 = paramBoolean)
    {
      Object localObject = com.tencent.mm.plugin.finder.nearby.live.play.abtest.a.zFX;
      localObject = getContext();
      p.j(localObject, "context");
      int i;
      if ((com.tencent.mm.q.a.p((Context)localObject, false)) || (com.tencent.mm.q.a.r(null, false)) || (com.tencent.mm.q.a.aAj()))
      {
        i = 1;
        boolean bool1 = bool2;
        if (i != 0)
        {
          bool1 = bool2;
          if (!paramBoolean)
          {
            Log.i("NearbyLivePreviewView", "setMute true for isVoip.");
            bool1 = true;
          }
        }
        bool2 = bool1;
        if (dLW())
        {
          bool2 = bool1;
          if (!paramBoolean)
          {
            Log.i("NearbyLivePreviewView", "setMute true for isUsePhone.");
            bool2 = true;
          }
        }
        if (!this.xVI) {
          break label251;
        }
        Log.i("NearbyLivePreviewView", "setMute true for isFinishLive.");
      }
      label251:
      for (paramBoolean = bool3;; paramBoolean = bool2)
      {
        localObject = this.xVE;
        if (localObject == null) {
          p.bGy("player");
        }
        ((TXLivePlayer)localObject).setMute(paramBoolean);
        if (paramBoolean) {
          dLV();
        }
        for (;;)
        {
          this.iYs = paramBoolean;
          aex("setMute isMute:".concat(String.valueOf(paramBoolean)));
          AppMethodBeat.o(199760);
          return;
          i = 0;
          break;
          aex("startAudioEnableView");
          localObject = this.zFK;
          if (localObject != null) {
            ((PAGView)localObject).setVisibility(0);
          }
          localObject = this.zFK;
          if (localObject != null) {
            ((PAGView)localObject).play();
          }
        }
      }
    }
  }
  
  public final void setPlayer(TXLivePlayer paramTXLivePlayer)
  {
    AppMethodBeat.i(199728);
    p.k(paramTXLivePlayer, "<set-?>");
    this.xVE = paramTXLivePlayer;
    AppMethodBeat.o(199728);
  }
  
  public final void setRenderView(d paramd)
  {
    AppMethodBeat.i(199735);
    p.k(paramd, "<set-?>");
    this.xVF = paramd;
    AppMethodBeat.o(199735);
  }
  
  public final void setScaleMode(int paramInt)
  {
    AppMethodBeat.i(199756);
    TXLivePlayer localTXLivePlayer = this.xVE;
    if (localTXLivePlayer == null) {
      p.bGy("player");
    }
    localTXLivePlayer.setRenderMode(paramInt);
    AppMethodBeat.o(199756);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(199768);
    aex("stop");
    this.yhs.dead();
    dLV();
    TXLivePlayer localTXLivePlayer = this.xVE;
    if (localTXLivePlayer == null) {
      p.bGy("player");
    }
    localTXLivePlayer.stopPlay(true);
    this.fEs = false;
    this.xVJ = null;
    AppMethodBeat.o(199768);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePreviewView$Companion;", "", "()V", "TAG", "", "plugin-finder-nearby_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePreviewView$LivePlayerListener;", "Lcom/tencent/rtmp/ITXLivePlayListener;", "(Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePreviewView;)V", "onNetStatus", "", "params", "Landroid/os/Bundle;", "onPlayEvent", "event", "", "plugin-finder-nearby_release"})
  public final class b
    implements ITXLivePlayListener
  {
    public final void onNetStatus(Bundle paramBundle)
    {
      boolean bool = true;
      AppMethodBeat.i(201829);
      int i = NetStatusUtil.getNetType(this.zFN.getContext());
      paramBundle = this.zFN;
      Object localObject = new StringBuilder("onNetStatus curPlayStatus:").append(NearbyLivePreviewView.b(this.zFN)).append(", netQuality:").append(i).append(", isPlaying:");
      TXLivePlayer localTXLivePlayer = this.zFN.getPlayer();
      if ((localTXLivePlayer != null) && (localTXLivePlayer.isPlaying() == true)) {}
      for (;;)
      {
        NearbyLivePreviewView.a(paramBundle, bool);
        if ((this.zFN.getPlayer().isPlaying()) && (i != -1) && (NearbyLivePreviewView.b(this.zFN) == -2301))
        {
          paramBundle = this.zFN;
          paramBundle.aex("restart");
          localObject = paramBundle.xVE;
          if (localObject == null) {
            p.bGy("player");
          }
          ((TXLivePlayer)localObject).stopPlay(false);
          paramBundle.fEs = false;
          paramBundle.V(paramBundle.xVJ);
        }
        AppMethodBeat.o(201829);
        return;
        bool = false;
      }
    }
    
    public final void onPlayEvent(int paramInt, Bundle paramBundle)
    {
      boolean bool2 = true;
      boolean bool1 = true;
      AppMethodBeat.i(201825);
      NearbyLivePreviewView.a(this.zFN, "onPlayEvent:" + paramInt + ", isPlaying:" + this.zFN.getPlayer().isPlaying());
      if (this.zFN.getPlayer().isPlaying()) {
        NearbyLivePreviewView.a(this.zFN, paramInt);
      }
      Object localObject;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(201825);
        return;
      case 2004: 
        paramBundle = NearbyLivePreviewView.c(this.zFN);
        if (paramBundle != null)
        {
          paramBundle.invoke();
          AppMethodBeat.o(201825);
          return;
        }
        AppMethodBeat.o(201825);
        return;
      case 2001: 
        localObject = this.zFN;
        StringBuilder localStringBuilder = new StringBuilder("onPlayEvent ");
        if (paramInt == 2004) {}
        for (paramBundle = "EVT_VIDEO_PLAY_BEGIN";; paramBundle = "PLAY_EVT_CONNECT_SUCC")
        {
          NearbyLivePreviewView.a((NearbyLivePreviewView)localObject, paramBundle);
          AppMethodBeat.o(201825);
          return;
        }
      case 2103: 
        if (NetStatusUtil.getNetType(this.zFN.getContext()) == -1) {}
        for (;;)
        {
          NearbyLivePreviewView.a(this.zFN, "onPlayEvent PLAY_WARNING_RECONNECT, non_network:".concat(String.valueOf(bool1)));
          AppMethodBeat.o(201825);
          return;
          bool1 = false;
        }
      case -2301: 
        if (NetStatusUtil.getNetType(this.zFN.getContext()) == -1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          NearbyLivePreviewView.a(this.zFN, "onPlayEvent PLAY_ERR_NET_DISCONNECT, non_network:".concat(String.valueOf(bool1)));
          this.zFN.getPlayer().stopPlay(false);
          NearbyLivePreviewView.d(this.zFN);
          AppMethodBeat.o(201825);
          return;
        }
      case 2009: 
        if (paramBundle != null)
        {
          paramInt = paramBundle.getInt("EVT_PARAM1");
          if (paramBundle == null) {
            break label424;
          }
        }
        label424:
        for (int i = paramBundle.getInt("EVT_PARAM2");; i = 0)
        {
          NearbyLivePreviewView.a(this.zFN, "onPlayEvent PLAY_EVT_CHANGE_RESOLUTION, w:h=" + paramInt + ':' + i);
          paramBundle = NearbyLivePreviewView.e(this.zFN);
          if (paramBundle != null) {
            paramBundle.gB(paramInt, i);
          }
          if (NearbyLivePreviewView.f(this.zFN)) {
            break label429;
          }
          AppMethodBeat.o(201825);
          return;
          paramInt = 0;
          break;
        }
        label429:
        if (i > paramInt)
        {
          this.zFN.getPlayer().setRenderMode(0);
          AppMethodBeat.o(201825);
          return;
        }
        this.zFN.getPlayer().setRenderMode(1);
        AppMethodBeat.o(201825);
        return;
      }
      if (paramBundle != null) {}
      for (paramBundle = paramBundle.getByteArray("EVT_GET_MSG");; paramBundle = null)
      {
        localObject = NearbyLivePreviewView.e(this.zFN);
        if (localObject == null) {
          break;
        }
        ((z)localObject).bT(paramBundle);
        AppMethodBeat.o(201825);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MMLiveSEIMsgConnectMicUserInfo;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<LinkedList<cue>, x>
  {
    c(NearbyLivePreviewView paramNearbyLivePreviewView, a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePreviewView$voipCallEvent$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "callback", "", "event", "plugin-finder-nearby_release"})
  public static final class d
    extends IListener<aaq>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.NearbyLivePreviewView
 * JD-Core Version:    0.7.0.1
 */