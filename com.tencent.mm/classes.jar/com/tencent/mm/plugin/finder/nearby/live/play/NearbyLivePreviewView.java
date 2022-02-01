package com.tencent.mm.plugin.finder.nearby.live.play;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.feed.aa;
import com.tencent.mm.plugin.finder.live.fluent.e;
import com.tencent.mm.plugin.finder.live.fluent.g;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.o;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.ui.TXCloudVideoView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePreviewView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "audioEnableView", "Lorg/libpag/PAGView;", "curPlayerStatus", "currentFeedId", "", "decorateView", "Landroid/widget/RelativeLayout;", "isAutoRenderMode", "", "isFinishLive", "isFirstFrameRendered", "()Z", "setFirstFrameRendered", "(Z)V", "isMute", "isPause", "isReusePlayer", "setReusePlayer", "liveFeedDecorator", "Lcom/tencent/mm/plugin/finder/feed/FinderLiveFeedDecorator;", "mediaSource", "Lcom/tencent/mm/plugin/finder/nearby/live/play/LiveSource;", "onFirstFrameRendStart", "Lkotlin/Function0;", "", "player", "Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "getPlayer", "()Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "setPlayer", "(Lcom/tencent/mm/live/core/core/player/ILivePlayer;)V", "renderSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "getRenderSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "setRenderSurfaceTexture", "(Landroid/graphics/SurfaceTexture;)V", "renderView", "Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;", "getRenderView", "()Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;", "setRenderView", "(Lcom/tencent/mm/plugin/finder/video/FinderLiveTextureView;)V", "tabId", "videoHeight", "videoRatioWH", "", "videoWidth", "voipCallEvent", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "addAudioEnableView", "changeResolution", "dismissRenderView", "getMediaSource", "getVideoHeight", "getVideoRatioWH", "getVideoWidth", "init", "isPlaying", "isUsePhone", "isVoip", "notifyChangeFirstFrame", "notifyFirstFrameRendered", "notifyLiveFinish", "pause", "print", "str", "", "release", "removePlayer", "restart", "reusePlayer", "outerParams", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchLiveAutoPlayParams;", "setIsReuse", "reuse", "setMediaSource", "setMute", "setScaleMode", "scaleMode", "setVolume", "volume", "showRenderView", "start", "startAudioEnableView", "stop", "stopAudioEnableView", "Companion", "LivePlayerListener", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class NearbyLivePreviewView
  extends FrameLayout
{
  public static final NearbyLivePreviewView.a ELe;
  private final IListener<acn> BtB;
  public com.tencent.mm.plugin.finder.video.d EKl;
  private PAGView EKm;
  private RelativeLayout EKn;
  private c EKo;
  private boolean EKp;
  private boolean EKq;
  kotlin.g.a.a<ah> EKr;
  private aa EKs;
  boolean ELf;
  public SurfaceTexture ELg;
  public boolean ELh;
  long Eac;
  boolean hJi;
  float hKI;
  private int idY;
  boolean lAj;
  com.tencent.mm.live.core.core.c.b mUm;
  private int mUo;
  int videoHeight;
  int videoWidth;
  
  static
  {
    AppMethodBeat.i(341173);
    ELe = new NearbyLivePreviewView.a((byte)0);
    AppMethodBeat.o(341173);
  }
  
  public NearbyLivePreviewView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(341031);
    this.idY = -1;
    this.lAj = true;
    this.BtB = ((IListener)new NearbyLivePreviewView.voipCallEvent.1(this, f.hfK));
    init();
    AppMethodBeat.o(341031);
  }
  
  public NearbyLivePreviewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(341044);
    this.idY = -1;
    this.lAj = true;
    this.BtB = ((IListener)new NearbyLivePreviewView.voipCallEvent.1(this, f.hfK));
    init();
    AppMethodBeat.o(341044);
  }
  
  public NearbyLivePreviewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(341054);
    this.idY = -1;
    this.lAj = true;
    this.BtB = ((IListener)new NearbyLivePreviewView.voipCallEvent.1(this, f.hfK));
    init();
    AppMethodBeat.o(341054);
  }
  
  private static final void c(NearbyLivePreviewView paramNearbyLivePreviewView)
  {
    AppMethodBeat.i(341088);
    s.u(paramNearbyLivePreviewView, "this$0");
    Object localObject = g.CCu;
    localObject = g.nW(paramNearbyLivePreviewView.Eac);
    if ((localObject instanceof e))
    {
      ((e)localObject).CCp.ejM();
      localObject = g.CCu;
      g.eju();
    }
    paramNearbyLivePreviewView.eFm();
    AppMethodBeat.o(341088);
  }
  
  private final void eEY()
  {
    AppMethodBeat.i(341071);
    Xa("stopAudioEnableView");
    PAGView localPAGView = this.EKm;
    if (localPAGView != null) {
      localPAGView.setVisibility(4);
    }
    localPAGView = this.EKm;
    if (localPAGView != null) {
      localPAGView.stop();
    }
    AppMethodBeat.o(341071);
  }
  
  private static boolean eEZ()
  {
    AppMethodBeat.i(341082);
    boolean bool;
    try
    {
      Object localObject = MMApplicationContext.getContext().getSystemService("phone");
      if (localObject != null) {
        break label70;
      }
      localObject = new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
      AppMethodBeat.o(341082);
      throw ((Throwable)localObject);
    }
    catch (Exception localException1)
    {
      bool = false;
    }
    Log.e("NearbyLivePreviewView", "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
    AppMethodBeat.o(341082);
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
        Log.i("NearbyLivePreviewView", "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
      }
      catch (Exception localException2) {}
      break;
      bool = false;
      continue;
      bool = true;
    }
  }
  
  private final void eFm()
  {
    AppMethodBeat.i(341077);
    this.ELh = true;
    kotlin.g.a.a locala = this.EKr;
    if (locala != null) {
      locala.invoke();
    }
    AppMethodBeat.o(341077);
  }
  
  private void init()
  {
    AppMethodBeat.i(341062);
    Object localObject1 = getContext();
    s.s(localObject1, "context");
    setRenderView(new com.tencent.mm.plugin.finder.video.d((Context)localObject1));
    this.EKn = new RelativeLayout(getContext());
    localObject1 = new FrameLayout.LayoutParams(-1, -1);
    Object localObject2 = new FrameLayout.LayoutParams(-1, -1);
    addView((View)getRenderView(), (ViewGroup.LayoutParams)localObject1);
    addView((View)this.EKn, (ViewGroup.LayoutParams)localObject2);
    localObject1 = getContext();
    s.s(localObject1, "context");
    this.mUm = ((com.tencent.mm.live.core.core.c.b)new com.tencent.mm.live.core.core.c.a((Context)localObject1));
    localObject1 = new TXLivePlayConfig();
    ((TXLivePlayConfig)localObject1).setAutoAdjustCacheTime(true);
    ((TXLivePlayConfig)localObject1).setMinAutoAdjustCacheTime(1.0F);
    ((TXLivePlayConfig)localObject1).setMaxAutoAdjustCacheTime(1.0F);
    ((TXLivePlayConfig)localObject1).setEnableMessage(true);
    localObject2 = this.mUm;
    if (localObject2 != null) {
      ((com.tencent.mm.live.core.core.c.b)localObject2).setPlayListener((ITXLivePlayListener)new b());
    }
    localObject2 = this.mUm;
    if (localObject2 != null) {
      ((com.tencent.mm.live.core.core.c.b)localObject2).setConfig((TXLivePlayConfig)localObject1);
    }
    localObject1 = this.mUm;
    if (localObject1 != null) {
      ((com.tencent.mm.live.core.core.c.b)localObject1).setRenderMode(0);
    }
    this.EKq = false;
    setMute(true);
    localObject1 = aa.AWs;
    this.EKs = new aa(aa.ecq(), (ViewGroup)this.EKn, (kotlin.g.a.b)new NearbyLivePreviewView.d(this));
    Xa("init view:" + getRenderView() + " player:" + getRenderView());
    AppMethodBeat.o(341062);
  }
  
  final void Xa(String paramString)
  {
    Object localObject3 = null;
    AppMethodBeat.i(341361);
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
      Log.i("NearbyLivePreviewView", (String)localObject1 + ' ' + localObject2 + ' ' + hashCode() + " == " + paramString);
      AppMethodBeat.o(341361);
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
    AppMethodBeat.i(341314);
    Xa("start player:" + this.mUm + " isPause:" + this.hJi + " mediaSource:" + this.EKo);
    if (this.hJi)
    {
      parama = this.mUm;
      if (parama != null) {
        parama.resume();
      }
      eFm();
      this.BtB.alive();
      AppMethodBeat.o(341314);
      return;
    }
    if (this.EKo == null)
    {
      Log.e("NearbyLivePreviewView", s.X("start player return for mediaSource:", this.EKo));
      AppMethodBeat.o(341314);
      return;
    }
    this.EKr = parama;
    getRenderView().removeVideoView();
    getRenderView().addVideoView(new TextureView(getContext()));
    parama = this.mUm;
    if (parama != null) {
      parama.setPlayerView((TXCloudVideoView)getRenderView());
    }
    parama = this.mUm;
    if (parama != null) {
      parama.setPlayListener((ITXLivePlayListener)new b());
    }
    Object localObject1 = this.mUm;
    if (localObject1 != null)
    {
      parama = com.tencent.mm.live.core.d.a.mWH;
      parama = this.EKo;
      if (parama != null) {
        break label312;
      }
      parama = null;
      label228:
      Object localObject2 = this.EKo;
      s.checkNotNull(localObject2);
      parama = com.tencent.mm.live.core.d.a.a(parama, ((d)localObject2).url);
      localObject2 = com.tencent.d.a.a.a.a.a.ahiX;
      if (((Number)com.tencent.d.a.a.a.a.a.jUp().bmg()).intValue() != 1) {
        break label348;
      }
    }
    label312:
    label348:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.live.core.core.c.b)localObject1).D(parama, bool);
      parama = this.mUm;
      if (parama == null) {
        break;
      }
      localObject1 = this.EKo;
      s.checkNotNull(localObject1);
      parama.Y(((d)localObject1).url, 1);
      break;
      parama = parama.EJX;
      if (parama == null)
      {
        parama = null;
        break label228;
      }
      parama = parama.feedObject;
      if (parama == null)
      {
        parama = null;
        break label228;
      }
      parama = parama.getLiveInfo();
      break label228;
    }
  }
  
  public final void eEW()
  {
    AppMethodBeat.i(341333);
    getRenderView().setVisibility(4);
    AppMethodBeat.o(341333);
  }
  
  public final void eEX()
  {
    AppMethodBeat.i(341338);
    getRenderView().setVisibility(0);
    AppMethodBeat.o(341338);
  }
  
  public final com.tencent.mm.live.core.core.c.b eFj()
  {
    AppMethodBeat.i(341246);
    Log.w("NearbyLivePreviewView", s.X("disConnectPlayer player:", this.mUm));
    com.tencent.mm.live.core.core.c.b localb = this.mUm;
    this.mUm = null;
    AppMethodBeat.o(341246);
    return localb;
  }
  
  final void eFk()
  {
    AppMethodBeat.i(341343);
    Object localObject = this.EKs;
    if (localObject != null) {
      ((aa)localObject).hu(this.videoWidth, this.videoHeight);
    }
    if (!this.EKp)
    {
      AppMethodBeat.o(341343);
      return;
    }
    if (this.videoHeight > this.videoWidth)
    {
      localObject = this.mUm;
      if (localObject != null)
      {
        ((com.tencent.mm.live.core.core.c.b)localObject).setRenderMode(0);
        AppMethodBeat.o(341343);
      }
    }
    else
    {
      localObject = this.mUm;
      if (localObject != null) {
        ((com.tencent.mm.live.core.core.c.b)localObject).setRenderMode(1);
      }
    }
    AppMethodBeat.o(341343);
  }
  
  final void eFl()
  {
    AppMethodBeat.i(341350);
    com.tencent.mm.live.core.core.c.b localb = this.mUm;
    if (localb != null) {
      localb.setPlayerView((TXCloudVideoView)getRenderView());
    }
    getRenderView().post(new NearbyLivePreviewView..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(341350);
  }
  
  public final c getMediaSource()
  {
    return this.EKo;
  }
  
  public final com.tencent.mm.live.core.core.c.b getPlayer()
  {
    return this.mUm;
  }
  
  public final SurfaceTexture getRenderSurfaceTexture()
  {
    AppMethodBeat.i(341221);
    SurfaceTexture localSurfaceTexture = this.ELg;
    if (localSurfaceTexture != null)
    {
      AppMethodBeat.o(341221);
      return localSurfaceTexture;
    }
    s.bIx("renderSurfaceTexture");
    AppMethodBeat.o(341221);
    return null;
  }
  
  public final com.tencent.mm.plugin.finder.video.d getRenderView()
  {
    AppMethodBeat.i(341207);
    com.tencent.mm.plugin.finder.video.d locald = this.EKl;
    if (locald != null)
    {
      AppMethodBeat.o(341207);
      return locald;
    }
    s.bIx("renderView");
    AppMethodBeat.o(341207);
    return null;
  }
  
  public final int getVideoHeight()
  {
    return this.videoHeight;
  }
  
  public final float getVideoRatioWH()
  {
    return this.hKI;
  }
  
  public final int getVideoWidth()
  {
    return this.videoWidth;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(341329);
    com.tencent.mm.live.core.core.c.b localb = this.mUm;
    if ((localb != null) && (localb.isPlaying() == true))
    {
      AppMethodBeat.o(341329);
      return true;
    }
    AppMethodBeat.o(341329);
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(341324);
    aa localaa = this.EKs;
    if (localaa != null) {
      localaa.eck();
    }
    Xa("release");
    AppMethodBeat.o(341324);
  }
  
  public final void setFirstFrameRendered(boolean paramBoolean)
  {
    this.ELh = paramBoolean;
  }
  
  public final void setIsReuse(boolean paramBoolean)
  {
    this.ELf = paramBoolean;
  }
  
  public final void setMediaSource(c paramc)
  {
    AppMethodBeat.i(341253);
    s.u(paramc, "mediaSource");
    if (TextUtils.isEmpty((CharSequence)paramc.url))
    {
      paramc = new IllegalArgumentException();
      AppMethodBeat.o(341253);
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
      ((aa)localObject1).AWC = ((kotlin.g.a.b)new NearbyLivePreviewView.c(paramc, this));
    }
    localObject1 = (PAGView)findViewWithTag("NearbyLivePreviewView");
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
    int i = getContext().getResources().getDimensionPixelSize(e.c.Edge_3A);
    localObject1 = new FrameLayout.LayoutParams(i, i);
    int j = getContext().getResources().getDimensionPixelSize(e.c.Edge_1_5_A);
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
        ((PAGView)localObject2).setTag("NearbyLivePreviewView");
      }
      addView((View)this.EKm, (ViewGroup.LayoutParams)localObject1);
      Xa(s.X("setMediaSource mediaSource:", paramc));
      AppMethodBeat.o(341253);
      return;
      i = 0;
      break;
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    boolean bool3 = true;
    AppMethodBeat.i(341299);
    if ((com.tencent.mm.n.a.aTj()) && (!paramBoolean)) {
      Log.i("NearbyLivePreviewView", "setMute true for playing.");
    }
    for (boolean bool2 = true;; bool2 = paramBoolean)
    {
      Object localObject = com.tencent.mm.plugin.finder.nearby.live.play.abtest.a.ELr;
      boolean bool1 = bool2;
      if (!com.tencent.mm.plugin.finder.nearby.live.play.abtest.a.eFu())
      {
        bool1 = bool2;
        if (!paramBoolean)
        {
          Log.i("NearbyLivePreviewView", "setMute true for mute test.");
          bool1 = true;
        }
      }
      localObject = getContext();
      s.s(localObject, "context");
      int i;
      if ((com.tencent.mm.n.a.p((Context)localObject, false)) || (com.tencent.mm.n.a.s(null, false)) || (com.tencent.mm.n.a.aTe()))
      {
        i = 1;
        bool2 = bool1;
        if (i != 0)
        {
          bool2 = bool1;
          if (!paramBoolean)
          {
            Log.i("NearbyLivePreviewView", "setMute true for isVoip.");
            bool2 = true;
          }
        }
        bool1 = bool2;
        if (eEZ())
        {
          bool1 = bool2;
          if (!paramBoolean)
          {
            Log.i("NearbyLivePreviewView", "setMute true for isUsePhone.");
            bool1 = true;
          }
        }
        if (!this.EKq) {
          break label274;
        }
        Log.i("NearbyLivePreviewView", "setMute true for isFinishLive.");
      }
      label274:
      for (paramBoolean = bool3;; paramBoolean = bool1)
      {
        localObject = this.mUm;
        if (localObject != null) {
          ((com.tencent.mm.live.core.core.c.b)localObject).setMute(paramBoolean);
        }
        if (paramBoolean) {
          eEY();
        }
        for (;;)
        {
          this.lAj = paramBoolean;
          Xa(s.X("setMute isMute:", Boolean.valueOf(paramBoolean)));
          AppMethodBeat.o(341299);
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
  
  public final void setPlayer(com.tencent.mm.live.core.core.c.b paramb)
  {
    this.mUm = paramb;
  }
  
  public final void setRenderSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(341229);
    s.u(paramSurfaceTexture, "<set-?>");
    this.ELg = paramSurfaceTexture;
    AppMethodBeat.o(341229);
  }
  
  public final void setRenderView(com.tencent.mm.plugin.finder.video.d paramd)
  {
    AppMethodBeat.i(341214);
    s.u(paramd, "<set-?>");
    this.EKl = paramd;
    AppMethodBeat.o(341214);
  }
  
  public final void setReusePlayer(boolean paramBoolean)
  {
    this.ELf = paramBoolean;
  }
  
  public final void setScaleMode(int paramInt)
  {
    AppMethodBeat.i(341282);
    com.tencent.mm.live.core.core.c.b localb = this.mUm;
    if (localb != null) {
      localb.setRenderMode(paramInt);
    }
    AppMethodBeat.o(341282);
  }
  
  public final void setVolume(int paramInt)
  {
    AppMethodBeat.i(341290);
    com.tencent.mm.live.core.core.c.b localb = this.mUm;
    if (localb != null) {
      localb.setVolume(paramInt);
    }
    AppMethodBeat.o(341290);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(341319);
    Xa("stop");
    this.BtB.dead();
    eEY();
    com.tencent.mm.live.core.core.c.b localb = this.mUm;
    if (localb != null) {
      localb.fD(true);
    }
    this.hJi = false;
    this.EKr = null;
    this.videoWidth = 0;
    this.videoHeight = 0;
    this.hKI = 0.0F;
    this.ELh = false;
    AppMethodBeat.o(341319);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePreviewView$LivePlayerListener;", "Lcom/tencent/rtmp/ITXLivePlayListener;", "(Lcom/tencent/mm/plugin/finder/nearby/live/play/NearbyLivePreviewView;)V", "onNetStatus", "", "params", "Landroid/os/Bundle;", "onPlayEvent", "event", "", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements ITXLivePlayListener
  {
    public b()
    {
      AppMethodBeat.i(340928);
      AppMethodBeat.o(340928);
    }
    
    public final void onNetStatus(Bundle paramBundle)
    {
      int i = 1;
      AppMethodBeat.i(340946);
      int j = NetStatusUtil.getNetType(this.ELi.getContext());
      paramBundle = this.ELi;
      Object localObject = new StringBuilder("onNetStatus curPlayStatus:").append(NearbyLivePreviewView.k(this.ELi)).append(", netQuality:").append(j).append(", isPlaying:");
      com.tencent.mm.live.core.core.c.b localb = this.ELi.getPlayer();
      boolean bool;
      if ((localb != null) && (localb.isPlaying() == true))
      {
        bool = true;
        NearbyLivePreviewView.a(paramBundle, bool);
        paramBundle = this.ELi.getPlayer();
        if ((paramBundle == null) || (paramBundle.isPlaying() != true)) {
          break label199;
        }
      }
      for (;;)
      {
        if ((i != 0) && (j != -1) && (NearbyLivePreviewView.k(this.ELi) == -2301))
        {
          paramBundle = this.ELi;
          paramBundle.Xa("restart");
          localObject = paramBundle.mUm;
          if (localObject != null) {
            ((com.tencent.mm.live.core.core.c.b)localObject).fD(false);
          }
          paramBundle.hJi = false;
          paramBundle.bu(paramBundle.EKr);
        }
        AppMethodBeat.o(340946);
        return;
        bool = false;
        break;
        label199:
        i = 0;
      }
    }
    
    public final void onPlayEvent(int paramInt, Bundle paramBundle)
    {
      boolean bool2 = true;
      boolean bool1 = true;
      int j = 0;
      AppMethodBeat.i(340938);
      Object localObject = this.ELi.getPlayer();
      if ((localObject != null) && (((com.tencent.mm.live.core.core.c.b)localObject).isPlaying() == true)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          NearbyLivePreviewView.a(this.ELi, paramInt);
        }
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(340938);
          return;
        }
      }
      Log.i("NearbyLivePreviewView", "receive EVT_PLAY_VIEW_CHANGED_FIRST_I_FRAME");
      AppMethodBeat.o(340938);
      return;
      localObject = this.ELi;
      if (paramInt == 2004) {}
      for (paramBundle = "EVT_VIDEO_PLAY_BEGIN";; paramBundle = "PLAY_EVT_CONNECT_SUCC")
      {
        NearbyLivePreviewView.a((NearbyLivePreviewView)localObject, s.X("onPlayEvent ", paramBundle));
        AppMethodBeat.o(340938);
        return;
      }
      if (NetStatusUtil.getNetType(this.ELi.getContext()) == -1) {}
      for (;;)
      {
        NearbyLivePreviewView.a(this.ELi, s.X("onPlayEvent PLAY_WARNING_RECONNECT, non_network:", Boolean.valueOf(bool1)));
        AppMethodBeat.o(340938);
        return;
        bool1 = false;
      }
      if (NetStatusUtil.getNetType(this.ELi.getContext()) == -1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        NearbyLivePreviewView.a(this.ELi, s.X("onPlayEvent PLAY_ERR_NET_DISCONNECT, non_network:", Boolean.valueOf(bool1)));
        paramBundle = this.ELi.getPlayer();
        if (paramBundle != null) {
          paramBundle.fD(false);
        }
        NearbyLivePreviewView.d(this.ELi);
        AppMethodBeat.o(340938);
        return;
      }
      localObject = this.ELi;
      if (paramBundle == null)
      {
        paramInt = 0;
        NearbyLivePreviewView.b((NearbyLivePreviewView)localObject, paramInt);
        localObject = this.ELi;
        if (paramBundle != null) {
          break label443;
        }
      }
      label443:
      for (paramInt = j;; paramInt = paramBundle.getInt("EVT_PARAM2"))
      {
        NearbyLivePreviewView.c((NearbyLivePreviewView)localObject, paramInt);
        NearbyLivePreviewView.a(this.ELi, 1.0F * NearbyLivePreviewView.e(this.ELi) / NearbyLivePreviewView.f(this.ELi));
        NearbyLivePreviewView.a(this.ELi, "onPlayEvent PLAY_EVT_CHANGE_RESOLUTION, w:h=" + NearbyLivePreviewView.e(this.ELi) + ':' + NearbyLivePreviewView.f(this.ELi) + " videoRatioWH:" + NearbyLivePreviewView.g(this.ELi));
        NearbyLivePreviewView.h(this.ELi);
        NearbyLivePreviewView.i(this.ELi);
        AppMethodBeat.o(340938);
        return;
        paramInt = paramBundle.getInt("EVT_PARAM1");
        break;
      }
      if (paramBundle == null) {}
      for (paramBundle = null;; paramBundle = paramBundle.getByteArray("EVT_GET_MSG"))
      {
        localObject = NearbyLivePreviewView.j(this.ELi);
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
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.play.NearbyLivePreviewView
 * JD-Core Version:    0.7.0.1
 */