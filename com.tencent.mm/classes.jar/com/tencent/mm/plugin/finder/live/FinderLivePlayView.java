package com.tencent.mm.plugin.finder.live;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.c.a.a.a.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.z;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.video.d;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.cue;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLivePlayView;", "Lcom/tencent/mm/plugin/finder/live/FinderLivePlayBaseView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "curPlayerStatus", "decorateView", "Landroid/widget/RelativeLayout;", "isAutoRenderMode", "", "isFinishLive", "isMute", "isPause", "liveFeedDecorator", "Lcom/tencent/mm/plugin/finder/feed/FinderLiveFeedDecorator;", "mediaSource", "Lcom/tencent/mm/plugin/finder/live/FinderLiveMediaSource;", "onFirstFrameRendStart", "Lkotlin/Function0;", "", "player", "Lcom/tencent/rtmp/TXLivePlayer;", "getPlayer", "()Lcom/tencent/rtmp/TXLivePlayer;", "setPlayer", "(Lcom/tencent/rtmp/TXLivePlayer;)V", "renderView", "Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;", "getRenderView", "()Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;", "setRenderView", "(Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;)V", "adjustDecorateRoot", "videoW", "videoH", "checkLiveStatus", "nonNetwork", "dismissRenderView", "getMediaSource", "init", "isPlaying", "notifyLiveFinish", "pause", "play", "print", "str", "", "debug", "release", "restart", "resume", "setMute", "mute", "showRenderView", "start", "stop", "Companion", "LivePlayerListener", "plugin-finder_release"})
public final class FinderLivePlayView
  extends FinderLivePlayBaseView
{
  public static final a xVM;
  boolean fEs;
  private boolean iYs;
  private int kqn;
  public TXLivePlayer xVE;
  public d xVF;
  g xVG;
  private boolean xVH;
  private boolean xVI;
  kotlin.g.a.a<x> xVJ;
  private RelativeLayout xVK;
  private z xVL;
  
  static
  {
    AppMethodBeat.i(273156);
    xVM = new a((byte)0);
    AppMethodBeat.o(273156);
  }
  
  public FinderLivePlayView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(273153);
    this.xVG = new g("", new FinderObject());
    this.iYs = true;
    init();
    AppMethodBeat.o(273153);
  }
  
  public FinderLivePlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(273154);
    this.xVG = new g("", new FinderObject());
    this.iYs = true;
    init();
    AppMethodBeat.o(273154);
  }
  
  public FinderLivePlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(273155);
    this.xVG = new g("", new FinderObject());
    this.iYs = true;
    init();
    AppMethodBeat.o(273155);
  }
  
  private final void bh(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(273151);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.ha("FinderLivePlayView", this.xVG + ',' + paramString);
      AppMethodBeat.o(273151);
      return;
    }
    Log.i("FinderLivePlayView", this.xVG + ',' + paramString);
    AppMethodBeat.o(273151);
  }
  
  private void init()
  {
    AppMethodBeat.i(273139);
    Object localObject1 = getContext();
    p.j(localObject1, "context");
    this.xVF = new d((Context)localObject1);
    localObject1 = new FrameLayout.LayoutParams(-1, -1);
    Object localObject2 = this.xVF;
    if (localObject2 == null) {
      p.bGy("renderView");
    }
    addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    this.xVK = new RelativeLayout(getContext());
    localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    addView((View)this.xVK, (ViewGroup.LayoutParams)localObject1);
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
    d locald = this.xVF;
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
    bh(localObject2, false);
    AppMethodBeat.o(273139);
  }
  
  public final void a(g paramg, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(273141);
    p.k(paramg, "mediaSource");
    if (b(paramg))
    {
      parama = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.ha("FinderLivePlayView", "checkAutoPlay " + paramg + " is playing!");
      AppMethodBeat.o(273141);
      return;
    }
    b(paramg, parama);
    AppMethodBeat.o(273141);
  }
  
  public final void b(g paramg, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(273142);
    p.k(paramg, "mediaSource");
    bh("start url:" + paramg + " isPause:" + this.fEs, false);
    if (!paramg.isValid())
    {
      AppMethodBeat.o(273142);
      return;
    }
    Object localObject;
    if ((this.fEs) && (this.xVG.a(paramg)))
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
      parama = this.xVL;
      if (parama != null)
      {
        localObject = FeedData.Companion;
        localObject = FinderItem.Companion;
        parama.a(FeedData.a.j(FinderItem.a.b(paramg.xVl, 16384)));
      }
      paramg = this.xVL;
      if (paramg == null) {
        break;
      }
      paramg.xzq = ((b)new d(this));
      AppMethodBeat.o(273142);
      return;
      this.xVG = paramg;
      this.xVJ = parama;
      parama = com.tencent.mm.plugin.finder.live.view.convert.a.zaD;
      parama = com.tencent.mm.plugin.finder.live.view.convert.a.g(this.xVG.xVl);
      localObject = this.xVE;
      if (localObject == null) {
        p.bGy("player");
      }
      ((TXLivePlayer)localObject).startPlay(parama, 1);
      Log.i("FinderLivePlayView", "start play:".concat(String.valueOf(parama)));
    }
    AppMethodBeat.o(273142);
  }
  
  public final boolean b(g paramg)
  {
    AppMethodBeat.i(273148);
    if (paramg != null)
    {
      if (paramg.a(this.xVG))
      {
        paramg = this.xVE;
        if (paramg == null) {
          p.bGy("player");
        }
        if (paramg.isPlaying())
        {
          AppMethodBeat.o(273148);
          return true;
        }
      }
      AppMethodBeat.o(273148);
      return false;
    }
    paramg = this.xVE;
    if (paramg == null) {
      p.bGy("player");
    }
    boolean bool = paramg.isPlaying();
    AppMethodBeat.o(273148);
    return bool;
  }
  
  public final void dwG()
  {
    AppMethodBeat.i(273149);
    d locald = this.xVF;
    if (locald == null) {
      p.bGy("renderView");
    }
    locald.setVisibility(4);
    AppMethodBeat.o(273149);
  }
  
  public final void dwH()
  {
    AppMethodBeat.i(273150);
    d locald = this.xVF;
    if (locald == null) {
      p.bGy("renderView");
    }
    locald.setVisibility(0);
    AppMethodBeat.o(273150);
  }
  
  public final g getMediaSource()
  {
    return this.xVG;
  }
  
  public final TXLivePlayer getPlayer()
  {
    AppMethodBeat.i(273132);
    TXLivePlayer localTXLivePlayer = this.xVE;
    if (localTXLivePlayer == null) {
      p.bGy("player");
    }
    AppMethodBeat.o(273132);
    return localTXLivePlayer;
  }
  
  public final d getRenderView()
  {
    AppMethodBeat.i(273135);
    d locald = this.xVF;
    if (locald == null) {
      p.bGy("renderView");
    }
    AppMethodBeat.o(273135);
    return locald;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(273144);
    bh("pause", false);
    this.fEs = true;
    TXLivePlayer localTXLivePlayer = this.xVE;
    if (localTXLivePlayer == null) {
      p.bGy("player");
    }
    localTXLivePlayer.pause();
    AppMethodBeat.o(273144);
  }
  
  public final void release()
  {
    AppMethodBeat.i(273147);
    bh("release", false);
    z localz = this.xVL;
    if (localz != null)
    {
      localz.dtj();
      AppMethodBeat.o(273147);
      return;
    }
    AppMethodBeat.o(273147);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(273143);
    bh("resume", false);
    this.fEs = false;
    TXLivePlayer localTXLivePlayer = this.xVE;
    if (localTXLivePlayer == null) {
      p.bGy("player");
    }
    localTXLivePlayer.resume();
    AppMethodBeat.o(273143);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(273140);
    TXLivePlayer localTXLivePlayer = this.xVE;
    if (localTXLivePlayer == null) {
      p.bGy("player");
    }
    localTXLivePlayer.setMute(paramBoolean);
    this.iYs = paramBoolean;
    AppMethodBeat.o(273140);
  }
  
  public final void setPlayer(TXLivePlayer paramTXLivePlayer)
  {
    AppMethodBeat.i(273134);
    p.k(paramTXLivePlayer, "<set-?>");
    this.xVE = paramTXLivePlayer;
    AppMethodBeat.o(273134);
  }
  
  public final void setRenderView(d paramd)
  {
    AppMethodBeat.i(273136);
    p.k(paramd, "<set-?>");
    this.xVF = paramd;
    AppMethodBeat.o(273136);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(273145);
    bh("stop", false);
    TXLivePlayer localTXLivePlayer = this.xVE;
    if (localTXLivePlayer == null) {
      p.bGy("player");
    }
    localTXLivePlayer.stopPlay(true);
    this.fEs = false;
    this.xVJ = null;
    AppMethodBeat.o(273145);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLivePlayView$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/FinderLivePlayView$LivePlayerListener;", "Lcom/tencent/rtmp/ITXLivePlayListener;", "(Lcom/tencent/mm/plugin/finder/live/FinderLivePlayView;)V", "onNetStatus", "", "params", "Landroid/os/Bundle;", "onPlayEvent", "event", "", "plugin-finder_release"})
  public final class b
    implements ITXLivePlayListener
  {
    public final void onNetStatus(Bundle paramBundle)
    {
      AppMethodBeat.i(278640);
      int i = NetStatusUtil.getNetType(this.xVN.getContext());
      FinderLivePlayView.b(this.xVN, "onNetStatus curPlayStatus:" + FinderLivePlayView.a(this.xVN) + ", netQuality:" + i + ", isPlaying:" + this.xVN.getPlayer().isPlaying());
      if ((this.xVN.getPlayer().isPlaying()) && (i != -1) && (FinderLivePlayView.a(this.xVN) == -2301))
      {
        paramBundle = this.xVN;
        FinderLivePlayView.a(paramBundle, "restart");
        TXLivePlayer localTXLivePlayer = paramBundle.xVE;
        if (localTXLivePlayer == null) {
          p.bGy("player");
        }
        localTXLivePlayer.stopPlay(false);
        paramBundle.fEs = false;
        paramBundle.b(paramBundle.xVG, paramBundle.xVJ);
      }
      AppMethodBeat.o(278640);
    }
    
    public final void onPlayEvent(int paramInt, Bundle paramBundle)
    {
      boolean bool2 = true;
      boolean bool1 = true;
      AppMethodBeat.i(278639);
      FinderLivePlayView.a(this.xVN, "onPlayEvent:" + paramInt + ", isPlaying:" + this.xVN.getPlayer().isPlaying());
      if (this.xVN.getPlayer().isPlaying()) {
        FinderLivePlayView.a(this.xVN, paramInt);
      }
      Object localObject;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(278639);
        return;
      case 2004: 
        paramBundle = FinderLivePlayView.b(this.xVN);
        if (paramBundle != null)
        {
          paramBundle.invoke();
          AppMethodBeat.o(278639);
          return;
        }
        AppMethodBeat.o(278639);
        return;
      case 2001: 
        localObject = this.xVN;
        StringBuilder localStringBuilder = new StringBuilder("onPlayEvent ");
        if (paramInt == 2004) {}
        for (paramBundle = "EVT_VIDEO_PLAY_BEGIN";; paramBundle = "PLAY_EVT_CONNECT_SUCC")
        {
          FinderLivePlayView.a((FinderLivePlayView)localObject, paramBundle);
          AppMethodBeat.o(278639);
          return;
        }
      case 2103: 
        if (NetStatusUtil.getNetType(this.xVN.getContext()) == -1) {}
        for (;;)
        {
          FinderLivePlayView.a(this.xVN, "onPlayEvent PLAY_WARNING_RECONNECT, non_network:".concat(String.valueOf(bool1)));
          AppMethodBeat.o(278639);
          return;
          bool1 = false;
        }
      case -2301: 
        if (NetStatusUtil.getNetType(this.xVN.getContext()) == -1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          FinderLivePlayView.a(this.xVN, "onPlayEvent PLAY_ERR_NET_DISCONNECT, non_network:".concat(String.valueOf(bool1)));
          FinderLivePlayView.a(this.xVN, bool1);
          AppMethodBeat.o(278639);
          return;
        }
      case 2009: 
        if (paramBundle != null)
        {
          paramInt = paramBundle.getInt("EVT_PARAM1");
          if (paramBundle == null) {
            break label414;
          }
        }
        label414:
        for (int i = paramBundle.getInt("EVT_PARAM2");; i = 0)
        {
          FinderLivePlayView.a(this.xVN, "onPlayEvent PLAY_EVT_CHANGE_RESOLUTION, w:h=" + paramInt + ':' + i);
          paramBundle = FinderLivePlayView.c(this.xVN);
          if (paramBundle != null) {
            paramBundle.gB(paramInt, i);
          }
          if (FinderLivePlayView.d(this.xVN)) {
            break label419;
          }
          AppMethodBeat.o(278639);
          return;
          paramInt = 0;
          break;
        }
        label419:
        if (i > paramInt) {
          this.xVN.getPlayer().setRenderMode(0);
        }
        for (;;)
        {
          FinderLivePlayView.a(this.xVN, paramInt, i);
          AppMethodBeat.o(278639);
          return;
          this.xVN.getPlayer().setRenderMode(1);
        }
      }
      if (paramBundle != null) {}
      for (paramBundle = paramBundle.getByteArray("EVT_GET_MSG");; paramBundle = null)
      {
        localObject = FinderLivePlayView.c(this.xVN);
        if (localObject == null) {
          break;
        }
        ((z)localObject).bT(paramBundle);
        AppMethodBeat.o(278639);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/FinderLivePlayView$checkLiveStatus$1", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderLiveStatusCallback;", "onLiveStatusCallback", "", "liveId", "", "liveStatus", "", "liveInfoResp", "", "plugin-finder_release"})
  public static final class c
    implements b.d
  {
    public final void a(long paramLong, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(274179);
      if (paramInt == 2)
      {
        this.xVN.getPlayer().stopPlay(false);
        FinderLivePlayView.f(this.xVN);
      }
      Log.i("FinderLivePlayView", "checkLiveStatus " + FinderLivePlayView.e(this.xVN) + " liveStatus:" + paramInt + '!');
      AppMethodBeat.o(274179);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MMLiveSEIMsgConnectMicUserInfo;", "invoke"})
  static final class d
    extends q
    implements b<LinkedList<cue>, x>
  {
    d(FinderLivePlayView paramFinderLivePlayView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.FinderLivePlayView
 * JD-Core Version:    0.7.0.1
 */