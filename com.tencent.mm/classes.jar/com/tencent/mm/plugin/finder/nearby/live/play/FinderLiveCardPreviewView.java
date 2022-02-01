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
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.plugin.finder.feed.aa;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.plugin.findersdk.a.am;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.io.PrintStream;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/FinderLiveCardPreviewView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveCardPreviewView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "audioEnableView", "Lorg/libpag/PAGView;", "curPlayerStatus", "decorateView", "Landroid/widget/RelativeLayout;", "isAutoRenderMode", "", "isFinishLive", "isMute", "isPause", "liveFeedDecorator", "Lcom/tencent/mm/plugin/finder/feed/FinderLiveFeedDecorator;", "mediaSource", "Lcom/tencent/mm/plugin/finder/nearby/live/play/LiveSource;", "onFirstFrameRendStart", "Lkotlin/Function0;", "", "player", "Lcom/tencent/rtmp/TXLivePlayer;", "getPlayer", "()Lcom/tencent/rtmp/TXLivePlayer;", "setPlayer", "(Lcom/tencent/rtmp/TXLivePlayer;)V", "renderView", "Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;", "getRenderView", "()Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;", "setRenderView", "(Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;)V", "tabId", "voipCallEvent", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "addAudioEnableView", "asView", "Landroid/view/View;", "dismissRenderView", "getMediaSource", "init", "isPlaying", "isUsePhone", "isVoip", "notifyLiveFinish", "pause", "print", "str", "", "release", "restart", "setMediaSource", "setMute", "setScaleMode", "scaleMode", "showRenderView", "start", "startAudioEnableView", "stop", "stopAudioEnableView", "Companion", "LivePlayerListener", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveCardPreviewView
  extends FrameLayout
  implements am
{
  public static final FinderLiveCardPreviewView.a EKj;
  private final IListener<acn> BtB;
  public TXLivePlayer EKk;
  public com.tencent.mm.plugin.finder.video.d EKl;
  private PAGView EKm;
  private RelativeLayout EKn;
  private c EKo;
  private boolean EKp;
  private boolean EKq;
  kotlin.g.a.a<ah> EKr;
  private aa EKs;
  boolean hJi;
  private int idY;
  private boolean lAj;
  private int mUo;
  
  static
  {
    AppMethodBeat.i(341089);
    EKj = new FinderLiveCardPreviewView.a((byte)0);
    AppMethodBeat.o(341089);
  }
  
  public FinderLiveCardPreviewView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(340949);
    this.idY = -1;
    this.lAj = true;
    this.BtB = ((IListener)new FinderLiveCardPreviewView.voipCallEvent.1(this, f.hfK));
    init();
    AppMethodBeat.o(340949);
  }
  
  public FinderLiveCardPreviewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(340959);
    this.idY = -1;
    this.lAj = true;
    this.BtB = ((IListener)new FinderLiveCardPreviewView.voipCallEvent.1(this, f.hfK));
    init();
    AppMethodBeat.o(340959);
  }
  
  public FinderLiveCardPreviewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(340967);
    this.idY = -1;
    this.lAj = true;
    this.BtB = ((IListener)new FinderLiveCardPreviewView.voipCallEvent.1(this, f.hfK));
    init();
    AppMethodBeat.o(340967);
  }
  
  private final void eEY()
  {
    AppMethodBeat.i(340991);
    Xa("stopAudioEnableView");
    PAGView localPAGView = this.EKm;
    if (localPAGView != null) {
      localPAGView.setVisibility(4);
    }
    localPAGView = this.EKm;
    if (localPAGView != null) {
      localPAGView.stop();
    }
    AppMethodBeat.o(340991);
  }
  
  private static boolean eEZ()
  {
    AppMethodBeat.i(341003);
    boolean bool;
    try
    {
      Object localObject = MMApplicationContext.getContext().getSystemService("phone");
      if (localObject != null) {
        break label70;
      }
      localObject = new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
      AppMethodBeat.o(341003);
      throw ((Throwable)localObject);
    }
    catch (Exception localException1)
    {
      bool = false;
    }
    Log.e("FinderLiveCardPreviewView", "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
    AppMethodBeat.o(341003);
    return bool;
    label70:
    int i = ((TelephonyManager)localException1).getCallState();
    switch (i)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      try
      {
        Log.i("FinderLiveCardPreviewView", "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
      }
      catch (Exception localException2) {}
      break;
      bool = false;
      continue;
      bool = true;
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(340981);
    Object localObject = getContext();
    s.s(localObject, "context");
    setRenderView(new com.tencent.mm.plugin.finder.video.d((Context)localObject));
    this.EKn = new RelativeLayout(getContext());
    localObject = new FrameLayout.LayoutParams(-1, -1);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    addView((View)getRenderView(), (ViewGroup.LayoutParams)localObject);
    addView((View)this.EKn, (ViewGroup.LayoutParams)localLayoutParams);
    setPlayer(new TXLivePlayer(getContext()));
    localObject = new TXLivePlayConfig();
    ((TXLivePlayConfig)localObject).setAutoAdjustCacheTime(true);
    ((TXLivePlayConfig)localObject).setMinAutoAdjustCacheTime(1.0F);
    ((TXLivePlayConfig)localObject).setMaxAutoAdjustCacheTime(1.0F);
    ((TXLivePlayConfig)localObject).setEnableMessage(true);
    getPlayer().setPlayerView((TXCloudVideoView)getRenderView());
    getPlayer().setPlayListener((ITXLivePlayListener)new b());
    getPlayer().setConfig((TXLivePlayConfig)localObject);
    getPlayer().setRenderMode(0);
    this.EKq = false;
    setMute(true);
    localObject = aa.AWs;
    this.EKs = new aa(aa.ecq(), (ViewGroup)this.EKn);
    Xa("init view:" + getRenderView() + " player:" + getRenderView());
    AppMethodBeat.o(340981);
  }
  
  final void Xa(String paramString)
  {
    Object localObject3 = null;
    AppMethodBeat.i(341287);
    Object localObject1 = this.EKo;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = "NULL";
      localObject2 = this.EKo;
      if (localObject2 != null) {
        break label132;
      }
      localObject2 = localObject3;
    }
    for (;;)
    {
      Log.i("FinderLiveCardPreviewView", (String)localObject1 + ' ' + localObject2 + ' ' + hashCode() + " == " + paramString);
      AppMethodBeat.o(341287);
      return;
      localObject1 = ((c)localObject1).EJX;
      if (localObject1 == null)
      {
        localObject1 = "NULL";
        break;
      }
      localObject2 = o.aBv(((BaseFinderFeed)localObject1).feedObject.getNickName());
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "NULL";
      break;
      label132:
      Object localObject4 = ((c)localObject2).EJX;
      localObject2 = localObject3;
      if (localObject4 != null)
      {
        localObject4 = ((BaseFinderFeed)localObject4).feedObject;
        localObject2 = localObject3;
        if (localObject4 != null)
        {
          localObject4 = ((FinderItem)localObject4).getLiveInfo();
          localObject2 = localObject3;
          if (localObject4 != null) {
            localObject2 = Long.valueOf(((bip)localObject4).liveId);
          }
        }
      }
    }
  }
  
  public final void bu(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(341213);
    Object localObject = "start mediaSource:" + this.EKo + " isPause:" + this.hJi;
    System.out.print(localObject);
    if (this.hJi)
    {
      getPlayer().resume();
      if (parama != null) {
        parama.invoke();
      }
    }
    label144:
    for (;;)
    {
      this.BtB.alive();
      AppMethodBeat.o(341213);
      return;
      localObject = this.EKo;
      if (localObject == null) {}
      for (parama = null;; parama = Integer.valueOf(getPlayer().startPlay(((d)localObject).url, 1)))
      {
        if (parama != null) {
          break label144;
        }
        parama = s.X("start error for mediaSource:", this.EKo);
        System.out.print(parama);
        break;
        this.EKr = parama;
      }
    }
  }
  
  public final void eEW()
  {
    AppMethodBeat.i(341261);
    getRenderView().setVisibility(4);
    AppMethodBeat.o(341261);
  }
  
  public final void eEX()
  {
    AppMethodBeat.i(341271);
    getRenderView().setVisibility(0);
    AppMethodBeat.o(341271);
  }
  
  public final View eFa()
  {
    return (View)this;
  }
  
  public final c getMediaSource()
  {
    return this.EKo;
  }
  
  public final TXLivePlayer getPlayer()
  {
    AppMethodBeat.i(341100);
    TXLivePlayer localTXLivePlayer = this.EKk;
    if (localTXLivePlayer != null)
    {
      AppMethodBeat.o(341100);
      return localTXLivePlayer;
    }
    s.bIx("player");
    AppMethodBeat.o(341100);
    return null;
  }
  
  public final com.tencent.mm.plugin.finder.video.d getRenderView()
  {
    AppMethodBeat.i(341127);
    com.tencent.mm.plugin.finder.video.d locald = this.EKl;
    if (locald != null)
    {
      AppMethodBeat.o(341127);
      return locald;
    }
    s.bIx("renderView");
    AppMethodBeat.o(341127);
    return null;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(341252);
    boolean bool = getPlayer().isPlaying();
    AppMethodBeat.o(341252);
    return bool;
  }
  
  public final void release()
  {
    AppMethodBeat.i(341243);
    aa localaa = this.EKs;
    if (localaa != null) {
      localaa.eck();
    }
    Xa("release");
    AppMethodBeat.o(341243);
  }
  
  public final void setMediaSource(c paramc)
  {
    AppMethodBeat.i(341156);
    s.u(paramc, "mediaSource");
    if (TextUtils.isEmpty((CharSequence)paramc.url))
    {
      paramc = new IllegalArgumentException();
      AppMethodBeat.o(341156);
      throw paramc;
    }
    this.EKo = paramc;
    Object localObject1 = this.EKs;
    if (localObject1 != null)
    {
      localObject2 = FeedData.Companion;
      ((aa)localObject1).a(FeedData.a.n(paramc.EJX.feedObject));
    }
    localObject1 = this.EKs;
    if (localObject1 != null) {
      ((aa)localObject1).AWC = ((b)new FinderLiveCardPreviewView.c(paramc, this));
    }
    localObject1 = (PAGView)findViewWithTag("FinderLiveCardPreviewView");
    if (localObject1 != null) {
      removeView((View)localObject1);
    }
    this.EKm = new PAGView(getContext());
    localObject1 = this.EKm;
    if (localObject1 != null) {
      ((PAGView)localObject1).setFile(PAGFile.Load(getContext().getAssets(), "finder_nearby_live_square_card_audio_wave.pag"));
    }
    localObject1 = this.EKm;
    if (localObject1 != null) {
      ((PAGView)localObject1).setRepeatCount(-1);
    }
    int i = getContext().getResources().getDimensionPixelSize(p.c.Edge_3A);
    localObject1 = new FrameLayout.LayoutParams(i, i);
    int j = getContext().getResources().getDimensionPixelSize(p.c.Edge_1_5_A);
    Object localObject2 = this.EKo;
    if ((localObject2 != null) && (((c)localObject2).EKv == true))
    {
      i = 1;
      if (i == 0) {
        break label360;
      }
    }
    label360:
    for (i = 51;; i = 53)
    {
      ((FrameLayout.LayoutParams)localObject1).gravity = i;
      ((FrameLayout.LayoutParams)localObject1).leftMargin = j;
      ((FrameLayout.LayoutParams)localObject1).topMargin = j;
      ((FrameLayout.LayoutParams)localObject1).rightMargin = j;
      localObject2 = this.EKm;
      if (localObject2 != null) {
        ((PAGView)localObject2).setVisibility(4);
      }
      localObject2 = this.EKm;
      if (localObject2 != null) {
        ((PAGView)localObject2).setTag("FinderLiveCardPreviewView");
      }
      addView((View)this.EKm, (ViewGroup.LayoutParams)localObject1);
      Xa(s.X("setMediaSource mediaSource:", paramc));
      AppMethodBeat.o(341156);
      return;
      i = 0;
      break;
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    boolean bool3 = true;
    AppMethodBeat.i(341195);
    if ((com.tencent.mm.n.a.aTj()) && (!paramBoolean)) {
      Log.i("FinderLiveCardPreviewView", "setMute true for playing.");
    }
    for (boolean bool2 = true;; bool2 = paramBoolean)
    {
      Object localObject = getContext();
      s.s(localObject, "context");
      int i;
      if ((com.tencent.mm.n.a.p((Context)localObject, false)) || (com.tencent.mm.n.a.s(null, false)) || (com.tencent.mm.n.a.aTe()))
      {
        i = 1;
        boolean bool1 = bool2;
        if (i != 0)
        {
          bool1 = bool2;
          if (!paramBoolean)
          {
            Log.i("FinderLiveCardPreviewView", "setMute true for isVoip.");
            bool1 = true;
          }
        }
        bool2 = bool1;
        if (eEZ())
        {
          bool2 = bool1;
          if (!paramBoolean)
          {
            Log.i("FinderLiveCardPreviewView", "setMute true for isUsePhone.");
            bool2 = true;
          }
        }
        if (!this.EKq) {
          break label231;
        }
        Log.i("FinderLiveCardPreviewView", "setMute true for isFinishLive.");
      }
      label231:
      for (paramBoolean = bool3;; paramBoolean = bool2)
      {
        getPlayer().setMute(paramBoolean);
        if (paramBoolean) {
          eEY();
        }
        for (;;)
        {
          this.lAj = paramBoolean;
          Xa(s.X("setMute isMute:", Boolean.valueOf(paramBoolean)));
          AppMethodBeat.o(341195);
          return;
          i = 0;
          break;
          Xa("startAudioEnableView");
          localObject = this.EKm;
          if (localObject != null) {
            ((PAGView)localObject).setVisibility(0);
          }
          localObject = this.EKm;
          if (localObject != null) {
            ((PAGView)localObject).play();
          }
        }
      }
    }
  }
  
  public final void setPlayer(TXLivePlayer paramTXLivePlayer)
  {
    AppMethodBeat.i(341114);
    s.u(paramTXLivePlayer, "<set-?>");
    this.EKk = paramTXLivePlayer;
    AppMethodBeat.o(341114);
  }
  
  public final void setRenderView(com.tencent.mm.plugin.finder.video.d paramd)
  {
    AppMethodBeat.i(341137);
    s.u(paramd, "<set-?>");
    this.EKl = paramd;
    AppMethodBeat.o(341137);
  }
  
  public final void setScaleMode(int paramInt)
  {
    AppMethodBeat.i(341180);
    getPlayer().setRenderMode(paramInt);
    AppMethodBeat.o(341180);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(341227);
    Xa("stop");
    this.BtB.dead();
    eEY();
    getPlayer().stopPlay(true);
    this.hJi = false;
    this.EKr = null;
    AppMethodBeat.o(341227);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/FinderLiveCardPreviewView$LivePlayerListener;", "Lcom/tencent/rtmp/ITXLivePlayListener;", "(Lcom/tencent/mm/plugin/finder/nearby/live/play/FinderLiveCardPreviewView;)V", "onNetStatus", "", "params", "Landroid/os/Bundle;", "onPlayEvent", "event", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements ITXLivePlayListener
  {
    public b()
    {
      AppMethodBeat.i(340897);
      AppMethodBeat.o(340897);
    }
    
    public final void onNetStatus(Bundle paramBundle)
    {
      boolean bool = true;
      AppMethodBeat.i(340924);
      int i = NetStatusUtil.getNetType(this.EKt.getContext());
      paramBundle = this.EKt;
      StringBuilder localStringBuilder = new StringBuilder("onNetStatus curPlayStatus:").append(FinderLiveCardPreviewView.f(this.EKt)).append(", netQuality:").append(i).append(", isPlaying:");
      TXLivePlayer localTXLivePlayer = this.EKt.getPlayer();
      if ((localTXLivePlayer != null) && (localTXLivePlayer.isPlaying() == true)) {}
      for (;;)
      {
        FinderLiveCardPreviewView.a(paramBundle, bool);
        if ((this.EKt.getPlayer().isPlaying()) && (i != -1) && (FinderLiveCardPreviewView.f(this.EKt) == -2301))
        {
          paramBundle = this.EKt;
          paramBundle.Xa("restart");
          paramBundle.getPlayer().stopPlay(false);
          paramBundle.hJi = false;
          paramBundle.bu(paramBundle.EKr);
        }
        AppMethodBeat.o(340924);
        return;
        bool = false;
      }
    }
    
    public final void onPlayEvent(int paramInt, Bundle paramBundle)
    {
      boolean bool2 = true;
      boolean bool1 = true;
      AppMethodBeat.i(340918);
      FinderLiveCardPreviewView.a(this.EKt, "onPlayEvent:" + paramInt + ", isPlaying:" + this.EKt.getPlayer().isPlaying());
      if (this.EKt.getPlayer().isPlaying()) {
        FinderLiveCardPreviewView.a(this.EKt, paramInt);
      }
      Object localObject;
      switch (paramInt)
      {
      default: 
      case 2004: 
        do
        {
          AppMethodBeat.o(340918);
          return;
          paramBundle = FinderLiveCardPreviewView.b(this.EKt);
        } while (paramBundle == null);
        paramBundle.invoke();
        AppMethodBeat.o(340918);
        return;
      case 2001: 
        localObject = this.EKt;
        if (paramInt == 2004) {}
        for (paramBundle = "EVT_VIDEO_PLAY_BEGIN";; paramBundle = "PLAY_EVT_CONNECT_SUCC")
        {
          FinderLiveCardPreviewView.a((FinderLiveCardPreviewView)localObject, s.X("onPlayEvent ", paramBundle));
          AppMethodBeat.o(340918);
          return;
        }
      case 2103: 
        if (NetStatusUtil.getNetType(this.EKt.getContext()) == -1) {}
        for (;;)
        {
          FinderLiveCardPreviewView.a(this.EKt, s.X("onPlayEvent PLAY_WARNING_RECONNECT, non_network:", Boolean.valueOf(bool1)));
          AppMethodBeat.o(340918);
          return;
          bool1 = false;
        }
      case -2301: 
        if (NetStatusUtil.getNetType(this.EKt.getContext()) == -1) {}
        for (bool1 = bool2;; bool1 = false)
        {
          FinderLiveCardPreviewView.a(this.EKt, s.X("onPlayEvent PLAY_ERR_NET_DISCONNECT, non_network:", Boolean.valueOf(bool1)));
          this.EKt.getPlayer().stopPlay(false);
          FinderLiveCardPreviewView.c(this.EKt);
          AppMethodBeat.o(340918);
          return;
        }
      case 2009: 
        if (paramBundle == null)
        {
          paramInt = 0;
          if (paramBundle != null) {
            break label399;
          }
        }
        label399:
        for (int i = 0;; i = paramBundle.getInt("EVT_PARAM2"))
        {
          FinderLiveCardPreviewView.a(this.EKt, "onPlayEvent PLAY_EVT_CHANGE_RESOLUTION, w:h=" + paramInt + ':' + i);
          paramBundle = FinderLiveCardPreviewView.d(this.EKt);
          if (paramBundle != null) {
            paramBundle.hu(paramInt, i);
          }
          if (FinderLiveCardPreviewView.e(this.EKt)) {
            break label409;
          }
          AppMethodBeat.o(340918);
          return;
          paramInt = paramBundle.getInt("EVT_PARAM1");
          break;
        }
        label409:
        if (i > paramInt)
        {
          this.EKt.getPlayer().setRenderMode(0);
          AppMethodBeat.o(340918);
          return;
        }
        this.EKt.getPlayer().setRenderMode(1);
        AppMethodBeat.o(340918);
        return;
      }
      if (paramBundle == null) {}
      for (paramBundle = null;; paramBundle = paramBundle.getByteArray("EVT_GET_MSG"))
      {
        localObject = FinderLiveCardPreviewView.d(this.EKt);
        if (localObject == null) {
          break;
        }
        ((aa)localObject).bT(paramBundle);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.FinderLiveCardPreviewView
 * JD-Core Version:    0.7.0.1
 */