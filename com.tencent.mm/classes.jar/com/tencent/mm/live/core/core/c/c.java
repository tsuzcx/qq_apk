package com.tencent.mm.live.core.core.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.liteav.TXLiteAVExternalDecoderFactoryInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.a.c;
import com.tencent.mm.live.core.b.j;
import com.tencent.mm.live.core.b.n;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.live.core.core.e.e;
import com.tencent.mm.live.core.core.e.n;
import com.tencent.mm.live.core.core.e.q;
import com.tencent.mm.live.core.core.model.UserVolumeInfo;
import com.tencent.mm.live.core.core.model.f;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.live.core.core.model.h.b;
import com.tencent.mm.live.core.core.model.h.e;
import com.tencent.mm.live.core.core.trtc.sdkadapter.feature.Vcodec2Decoder;
import com.tencent.mm.live.core.core.trtc.sdkadapter.feature.e;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.LiveVideoView;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ax;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import com.tencent.trtc.TRTCCloudDef.TRTCVolumeInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/live/core/core/visitor/IMMLiveVisitorCore;", "Lcom/tencent/rtmp/ITXLivePlayListener;", "()V", "cdnPlayerManager", "Lcom/tencent/mm/live/core/core/LiveCdnPlayerManager;", "curPlayerStatus", "", "debugRunnable", "com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1;", "playerView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "streamType", "cdnPausePlay", "", "cdnResumePlay", "cdnStartPlay", "Lcom/tencent/mm/live/core/view/LiveVideoView;", "playCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "cdnStopPlay", "keepLastFrame", "enterRoom", "callback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "floatMode", "context", "Landroid/content/Context;", "forceMoveTask", "dontFinish", "generateType", "opType", "muteVideoImage", "Landroid/graphics/Bitmap;", "getCdnPlayerManager", "getTXLivePlayer", "Lcom/tencent/rtmp/TXLivePlayer;", "outterConfig", "Lcom/tencent/rtmp/TXLivePlayConfig;", "isAudioMicing", "isCdnMode", "isInLinkMic", "isVideoMicing", "makeRemotePreviewFullScreen", "normalMode", "onCdnPlayerAvailalbe", "liveId", "", "player", "onEnterRoom", "result", "onFirstVideoFrame", "userId", "", "width", "height", "onNetStatus", "params", "Landroid/os/Bundle;", "onPlayEvent", "event", "param", "onRemoteUserLeaveRoom", "reason", "onUserVoiceVolume", "userVolumes", "Ljava/util/ArrayList;", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVolumeInfo;", "totalVolume", "pauseRender", "refreshByOrientation", "release", "resumeRender", "setLiveMiniState", "newState", "setupLiveRoomInfo", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "startLinkMic", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "startPush", "stopLinkMic", "stopPush", "switchAudioLinkMic", "switchVideoLinkMic", "updateFillMode", "updatePreviewView", "visitRoom", "Companion", "plugin-core_release"})
public class c
  extends com.tencent.mm.live.core.core.trtc.a
  implements b, ITXLivePlayListener
{
  private static c kqp;
  public static final a kqq;
  private TXCloudVideoView kql;
  public com.tencent.mm.live.core.core.d kqm;
  private int kqn;
  private final b kqo;
  private int streamType;
  
  static
  {
    AppMethodBeat.i(198662);
    kqq = new a((byte)0);
    AppMethodBeat.o(198662);
  }
  
  public c()
  {
    super(false);
    AppMethodBeat.i(198661);
    this.kqm = new com.tencent.mm.live.core.core.d();
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIX, 5);
    if (i > 0) {
      sT(i);
    }
    Log.i("MicroMsg.LiveCoreVisitor", "get sei report interval:" + i + ", final:" + aLy());
    this.kqo = new b(this);
    AppMethodBeat.o(198661);
  }
  
  private final boolean aMf()
  {
    AppMethodBeat.i(198568);
    Object localObject = this.knz;
    if (localObject != null)
    {
      localObject = ((g)localObject).kjd;
      if (localObject != null)
      {
        int i = ((f)localObject).kmi;
        localObject = e.b.kjz;
        if (i == e.b.aJK())
        {
          AppMethodBeat.o(198568);
          return true;
        }
      }
    }
    AppMethodBeat.o(198568);
    return false;
  }
  
  public final int a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    AppMethodBeat.i(198591);
    p.k(paramContext, "context");
    Log.i("MicroMsg.LiveCoreVisitor", "floatMode isAudioMode:" + this.knA.aLs() + " inVideoMic:" + this.knA.aLo() + " inAudioMic:" + this.knA.aLp() + " isCdnMode:" + aMf());
    if (this.knA.isFloatMode())
    {
      AppMethodBeat.o(198591);
      return 0;
    }
    final long l = Util.currentTicks();
    this.knA.kmA = h.e.kmX;
    if (this.knA.aLs())
    {
      localObject1 = new ImageView(MMApplicationContext.getContext());
      ((ImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((ImageView)localObject1).setImageBitmap(paramBitmap);
      this.knr.cH((View)localObject1);
    }
    for (;;)
    {
      paramInt1 = super.a(paramContext, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramBitmap);
      AppMethodBeat.o(198591);
      return paramInt1;
      if ((!this.knA.aLo()) && (!this.knA.aLp()) && (aMf())) {
        break;
      }
      localObject1 = this.knm.NL(this.knA.kmC);
      if (localObject1 != null)
      {
        localObject2 = ao(((j)localObject1).userId, ((j)localObject1).streamType);
        if (localObject2 != null) {
          ((TXCloudVideoView)localObject2).removeVideoView();
        }
        Log.i("MicroMsg.LiveCoreVisitor", "enter float mode");
        ((j)localObject1).aMX();
        localObject2 = new TextureView(MMApplicationContext.getContext());
        ((TextureView)localObject2).setSurfaceTextureListener((TextureView.SurfaceTextureListener)new c((j)localObject1, l));
        this.knr.cH((View)localObject2);
      }
    }
    Object localObject1 = this.knm;
    Object localObject2 = this.knz;
    if (localObject2 != null)
    {
      localObject2 = ((g)localObject2).kjd;
      if (localObject2 == null) {}
    }
    for (l = ((f)localObject2).liveId;; l = 0L)
    {
      localObject1 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.b.c)localObject1).FA(l);
      localObject2 = new TXCloudVideoView(MMApplicationContext.getContext());
      this.knr.cH((View)localObject2);
      if (localObject1 == null) {
        break;
      }
      ((TXLivePlayer)localObject1).setPlayerView((TXCloudVideoView)localObject2);
      break;
    }
  }
  
  public final TXLivePlayer a(Context paramContext, TXLivePlayConfig paramTXLivePlayConfig)
  {
    AppMethodBeat.i(198637);
    p.k(paramContext, "context");
    com.tencent.mm.live.core.core.d locald = this.kqm;
    ITXLivePlayListener localITXLivePlayListener = (ITXLivePlayListener)this;
    p.k(paramContext, "context");
    boolean bool;
    if (locald.kjc == null)
    {
      locald.kjc = new TXLivePlayer(paramContext);
      paramContext = paramTXLivePlayConfig;
      if (paramTXLivePlayConfig == null) {
        paramContext = new TXLivePlayConfig();
      }
      locald.kjo = paramContext;
      paramContext = locald.kjc;
      if (paramContext != null) {
        paramContext.setPlayListener(localITXLivePlayListener);
      }
      paramContext = locald.kjc;
      if (paramContext != null) {
        paramContext.enableHardwareDecode(true);
      }
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIY, false))
      {
        paramContext = locald.kjc;
        if (paramContext != null) {
          paramContext.enableHardwareDecode(false);
        }
        Log.i(locald.TAG, "txLivePlayer closes the hardware decoder");
      }
      bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vIZ, false);
      if ((com.tencent.mm.compatible.deviceinfo.m.aus() & 0xFF) <= 60) {
        break label258;
      }
    }
    label258:
    for (int i = 1;; i = 0)
    {
      if ((bool) && (i != 0))
      {
        locald.kjp = 1;
        TXLiveBase.setExternalDecoderFactory((TXLiteAVExternalDecoderFactoryInterface)new Vcodec2Decoder());
        Log.i(locald.TAG, "txLivePlayer opens the vcodec2 decoder");
      }
      locald.aJF();
      paramContext = locald.kjc;
      if (paramContext != null) {
        paramContext.setRenderMode(1);
      }
      paramContext = locald.kjc;
      AppMethodBeat.o(198637);
      return paramContext;
    }
  }
  
  public void a(int paramInt, LiveVideoView paramLiveVideoView, kotlin.g.a.b<? super Boolean, x> paramb)
  {
    String str = null;
    Object localObject2 = null;
    AppMethodBeat.i(198633);
    p.k(paramLiveVideoView, "playerView");
    com.tencent.mm.live.core.core.d locald = this.kqm;
    p.k(paramLiveVideoView, "playerView");
    Object localObject1 = locald.kjd;
    Object localObject3;
    f localf;
    if (localObject1 != null)
    {
      localObject1 = ((f)localObject1).sS(locald.kjg);
      if ((localObject1 == null) || (locald.kjc == null)) {
        break label339;
      }
      localObject3 = locald.kjc;
      if ((localObject3 == null) || (((TXLivePlayer)localObject3).isPlaying())) {
        break label241;
      }
      str = locald.TAG;
      localObject3 = new StringBuilder("startPlay liveId:");
      localf = locald.kjd;
      if (localf != null) {
        localObject2 = Long.valueOf(localf.liveId);
      }
      Log.i(str, localObject2 + ", player:" + locald.kjc + ", url:" + (String)localObject1);
      localObject2 = locald.kjc;
      if (localObject2 != null) {
        ((TXLivePlayer)localObject2).setPlayerView((TXCloudVideoView)paramLiveVideoView);
      }
      paramLiveVideoView = locald.kjc;
      if (paramLiveVideoView != null) {
        paramLiveVideoView.startPlay((String)localObject1, paramInt);
      }
      if (paramb != null) {
        paramb.invoke(Boolean.TRUE);
      }
    }
    for (;;)
    {
      this.streamType = paramInt;
      AppMethodBeat.o(198633);
      return;
      localObject1 = null;
      break;
      label241:
      localObject2 = locald.TAG;
      localObject3 = new StringBuilder("refresh palyView liveId:");
      localf = locald.kjd;
      localObject1 = str;
      if (localf != null) {
        localObject1 = Long.valueOf(localf.liveId);
      }
      Log.i((String)localObject2, localObject1);
      localObject1 = locald.kjc;
      if (localObject1 != null) {
        ((TXLivePlayer)localObject1).setPlayerView((TXCloudVideoView)paramLiveVideoView);
      }
      if (paramb != null)
      {
        paramb.invoke(Boolean.TRUE);
        continue;
        label339:
        if (paramb != null) {
          paramb.invoke(Boolean.FALSE);
        }
      }
    }
  }
  
  public final void a(long paramLong, TXLivePlayer paramTXLivePlayer, TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(198606);
    this.kql = paramTXCloudVideoView;
    this.knm.a(paramLong, paramTXLivePlayer);
    AppMethodBeat.o(198606);
  }
  
  public final void a(com.tencent.mm.live.core.core.c paramc)
  {
    AppMethodBeat.i(198603);
    p.k(paramc, "callback");
    super.a(paramc);
    paramc = this.knl;
    Object localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources().getDrawable(a.c.mic_user_leave);
    p.j(localObject, "MMApplicationContext.get….drawable.mic_user_leave)");
    paramc.setVideoMuteImage(com.tencent.mm.ae.d.drawable2Bitmap((Drawable)localObject), 5);
    paramc = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
    p.j(paramc, "ConfigHelper.getInstance()");
    paramc = paramc.aLJ();
    p.j(paramc, "ConfigHelper.getInstance().videoConfig");
    paramc.ff(false);
    paramc = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
    p.j(paramc, "ConfigHelper.getInstance()");
    paramc = paramc.aLK();
    p.j(paramc, "ConfigHelper.getInstance().audioConfig");
    paramc.fb(false);
    AppMethodBeat.o(198603);
  }
  
  public final void a(LivePreviewView paramLivePreviewView, com.tencent.mm.live.core.core.c paramc)
  {
    AppMethodBeat.i(198605);
    p.k(paramc, "callback");
    if (paramLivePreviewView != null) {
      this.knt = paramLivePreviewView;
    }
    a(paramc);
    AppMethodBeat.o(198605);
  }
  
  public final int aJC()
  {
    AppMethodBeat.i(198645);
    this.kns.e((kotlin.g.a.b)g.kqw);
    this.knl.enableCustomVideoCapture(true);
    this.knB = true;
    AppMethodBeat.o(198645);
    return 0;
  }
  
  public final void aJz()
  {
    AppMethodBeat.i(198599);
    if (!this.knA.isFloatMode())
    {
      AppMethodBeat.o(198599);
      return;
    }
    Object localObject1 = new StringBuilder("normalMode playerView is empty:");
    boolean bool;
    Object localObject2;
    label91:
    final long l2;
    if (this.kql == null)
    {
      bool = true;
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", liveId:");
      localObject1 = this.knz;
      if (localObject1 == null) {
        break label346;
      }
      localObject1 = ((g)localObject1).kjd;
      if (localObject1 == null) {
        break label346;
      }
      localObject1 = Long.valueOf(((f)localObject1).liveId);
      Log.i("MicroMsg.LiveCoreVisitor", localObject1);
      l2 = Util.currentTicks();
      this.knA.kmA = h.e.kmW;
      if (this.kql != null)
      {
        localObject1 = this.knm;
        localObject2 = this.knz;
        if (localObject2 == null) {
          break label352;
        }
        localObject2 = ((g)localObject2).kjd;
        if (localObject2 == null) {
          break label352;
        }
      }
    }
    label346:
    label352:
    for (long l1 = ((f)localObject2).liveId;; l1 = 0L)
    {
      localObject1 = ((com.tencent.mm.live.core.core.trtc.sdkadapter.b.c)localObject1).FA(l1);
      if (localObject1 != null) {
        ((TXLivePlayer)localObject1).setPlayerView(this.kql);
      }
      localObject1 = this.knm.NL(this.knA.kmC);
      if (localObject1 != null)
      {
        Log.i("MicroMsg.LiveCoreVisitor", "normalMode, find renderSurface for userId:" + this.knA.kmC);
        localObject2 = ao(((j)localObject1).userId, ((j)localObject1).streamType);
        if (localObject2 != null)
        {
          TextureView localTextureView = new TextureView(MMApplicationContext.getContext());
          ((TXCloudVideoView)localObject2).addVideoView(localTextureView);
          localTextureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new d((j)localObject1, l2));
        }
      }
      if (this.knA.aLo())
      {
        localObject1 = this.knt;
        if (localObject1 != null) {
          ((LivePreviewView)localObject1).a((kotlin.g.a.q)new e(this));
        }
      }
      super.aJz();
      AppMethodBeat.o(198599);
      return;
      bool = false;
      break;
      localObject1 = null;
      break label91;
    }
  }
  
  public final boolean aLA()
  {
    AppMethodBeat.i(198615);
    com.tencent.mm.live.core.core.trtc.sdkadapter.c localc = this.knn;
    if ((localc == null) || (localc.aLS() != 21))
    {
      AppMethodBeat.o(198615);
      return true;
    }
    AppMethodBeat.o(198615);
    return false;
  }
  
  public final int aMg()
  {
    AppMethodBeat.i(198611);
    this.knA.kmx = h.b.kmM;
    Object localObject = com.tencent.mm.live.core.debug.a.kqB;
    com.tencent.mm.live.core.debug.a.ay("MicroMsg.LiveCoreMic", "[sdk]start link mic");
    localObject = this.knn;
    if ((localObject != null) && (((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject).aLS() == 20))
    {
      AppMethodBeat.o(198611);
      return 0;
    }
    localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
    p.j(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject).aLK();
    p.j(localObject, "ConfigHelper.getInstance().audioConfig");
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject).fb(true);
    localObject = this.knn;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject).eY(this.knA.aLs());
    }
    localObject = this.knn;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject).aLR();
    }
    localObject = this.knn;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject).startLocalAudio();
    }
    AppMethodBeat.o(198611);
    return 0;
  }
  
  public final int aMh()
  {
    AppMethodBeat.i(198619);
    this.knA.kmx = h.b.kmL;
    Object localObject = com.tencent.mm.live.core.debug.a.kqB;
    com.tencent.mm.live.core.debug.a.ay("MicroMsg.LiveCoreMic", "[sdk]stop link mic");
    localObject = this.knn;
    if ((localObject != null) && (((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject).aLS() == 21))
    {
      AppMethodBeat.o(198619);
      return 0;
    }
    localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
    p.j(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject).aLK();
    p.j(localObject, "ConfigHelper.getInstance().audioConfig");
    ((com.tencent.mm.live.core.core.trtc.sdkadapter.feature.a)localObject).fb(false);
    localObject = com.tencent.mm.live.core.core.trtc.sdkadapter.a.aLI();
    p.j(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.sdkadapter.a)localObject).aLJ();
    p.j(localObject, "ConfigHelper.getInstance().videoConfig");
    ((e)localObject).ff(false);
    localObject = this.knn;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject).aLR();
    }
    localObject = this.knn;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject).stopLocalAudio();
    }
    aJx();
    AppMethodBeat.o(198619);
    return 0;
  }
  
  public final void aMi()
  {
    AppMethodBeat.i(198622);
    this.knm.NI(this.knA.kmC);
    this.knm.muteRemoteAudio(this.knA.kmC, true);
    AppMethodBeat.o(198622);
  }
  
  public final void aMj()
  {
    AppMethodBeat.i(198625);
    if (this.knt != null)
    {
      if (!TextUtils.isEmpty((CharSequence)this.knA.kmC))
      {
        com.tencent.mm.live.core.core.trtc.sdkadapter.b.c localc = this.knm;
        String str = this.knA.kmC;
        Object localObject = this.knt;
        if (localObject != null) {}
        for (localObject = ((LivePreviewView)localObject).ap(this.knA.kmC, 0);; localObject = null)
        {
          localc.a(str, (TXCloudVideoView)localObject);
          this.knm.muteRemoteAudio(this.knA.kmC, false);
          AppMethodBeat.o(198625);
          return;
        }
      }
    }
    else {
      Log.w("MicroMsg.LiveCoreVisitor", "previewView == null!");
    }
    AppMethodBeat.o(198625);
  }
  
  public final void aMk()
  {
    AppMethodBeat.i(198627);
    stopPush();
    aJx();
    this.knA.kmx = h.b.kmM;
    AppMethodBeat.o(198627);
  }
  
  public final void b(f paramf)
  {
    AppMethodBeat.i(198641);
    com.tencent.mm.live.core.core.d locald = this.kqm;
    locald.kjd = paramf;
    locald.kjg = com.tencent.mm.live.core.core.a.kiL.value;
    if (paramf != null) {}
    for (paramf = Integer.valueOf(paramf.kjq);; paramf = null)
    {
      if (paramf != null) {
        locald.kjg = paramf.intValue();
      }
      AppMethodBeat.o(198641);
      return;
    }
  }
  
  public final void b(LivePreviewView paramLivePreviewView)
  {
    AppMethodBeat.i(198626);
    com.tencent.mm.live.core.core.trtc.sdkadapter.c localc = this.knn;
    if (localc != null) {
      localc.eY(this.knA.aLs());
    }
    aJC();
    a(paramLivePreviewView);
    this.knA.kmx = h.b.kmN;
    this.kns.f((kotlin.g.a.b)h.kqx);
    AppMethodBeat.o(198626);
  }
  
  public void fi(boolean paramBoolean)
  {
    AppMethodBeat.i(198634);
    this.kqm.eT(paramBoolean);
    AppMethodBeat.o(198634);
  }
  
  public final void onEnterRoom(long paramLong)
  {
    AppMethodBeat.i(198604);
    super.onEnterRoom(paramLong);
    this.knk.post((Runnable)this.kqo);
    AppMethodBeat.o(198604);
  }
  
  public final void onFirstVideoFrame(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    AppMethodBeat.i(198650);
    super.onFirstVideoFrame(paramString, paramInt1, paramInt2, paramInt3);
    if (ax.au(MMApplicationContext.getContext()).x > ax.au(MMApplicationContext.getContext()).y)
    {
      paramInt1 = 1;
      if (paramInt2 <= paramInt3) {
        break label93;
      }
      paramInt2 = i;
    }
    for (;;)
    {
      if (paramInt1 == paramInt2)
      {
        Log.i("MicroMsg.LiveCoreVisitor", "updateFillMode to SCALE_TYPE_CENTER_CROP");
        paramString = this.knm.NL(paramString);
        if (paramString != null)
        {
          paramString.tn(2);
          AppMethodBeat.o(198650);
          return;
          paramInt1 = 0;
          break;
          label93:
          paramInt2 = 0;
          continue;
        }
        AppMethodBeat.o(198650);
        return;
      }
    }
    Log.i("MicroMsg.LiveCoreVisitor", "updateFillMode to SCALE_TYPE_FIT_MODE");
    paramString = this.knm.NL(paramString);
    if (paramString != null)
    {
      paramString.tn(5);
      AppMethodBeat.o(198650);
      return;
    }
    AppMethodBeat.o(198650);
  }
  
  public void onNetStatus(Bundle paramBundle)
  {
    long l2 = 0L;
    Object localObject2 = null;
    AppMethodBeat.i(198588);
    int i = NetStatusUtil.getNetType(MMApplicationContext.getContext());
    Log.i("MicroMsg.LiveCoreVisitor", "onNetStatus curPlayStatus:" + this.kqn + ", netQuality:" + i + ", isPlaying:" + this.kqm.isPlaying() + ",netStatus:" + paramBundle);
    com.tencent.mm.live.core.core.d locald;
    Object localObject1;
    if ((this.kqm.isPlaying()) && (i != -1) && (this.kqn == -2301))
    {
      this.kqn = 0;
      locald = this.kqm;
      int j = this.streamType;
      localObject1 = locald.kjd;
      if (localObject1 == null) {
        break label597;
      }
      localObject1 = ((f)localObject1).sS(locald.kjg);
      Object localObject3 = (CharSequence)localObject1;
      if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
        break label603;
      }
      i = 1;
      label169:
      if (i != 0) {
        break label608;
      }
      localObject3 = locald.kjc;
      if (localObject3 != null) {
        ((TXLivePlayer)localObject3).stopPlay(false);
      }
      localObject3 = locald.kjc;
      if (localObject3 != null) {
        ((TXLivePlayer)localObject3).startPlay((String)localObject1, j);
      }
      localObject3 = locald.TAG;
      StringBuilder localStringBuilder = new StringBuilder("tryRestartPlay liveId:");
      f localf = locald.kjd;
      if (localf != null) {
        localObject2 = Long.valueOf(localf.liveId);
      }
      Log.i((String)localObject3, localObject2 + ", player:" + locald.kjc + ", url:" + (String)localObject1);
      label294:
      localObject1 = this.kny;
      if (localObject1 != null)
      {
        localObject2 = e.e.kjZ;
        com.tencent.mm.live.core.core.c.a.a((com.tencent.mm.live.core.core.c)localObject1, e.e.aJY());
      }
    }
    this.kqm.aJD();
    if (paramBundle != null)
    {
      localObject1 = e.q.klj;
      localObject1 = e.q.aKP();
      localObject2 = this.knz;
      if (localObject2 == null) {
        break label622;
      }
      localObject2 = ((g)localObject2).kjd;
      if (localObject2 == null) {
        break label622;
      }
    }
    label597:
    label603:
    label608:
    label622:
    for (long l1 = ((f)localObject2).liveId;; l1 = 0L)
    {
      paramBundle.putLong((String)localObject1, l1);
      if (paramBundle != null)
      {
        localObject1 = e.q.klj;
        localObject1 = e.q.aKQ();
        localObject2 = e.n.kkL;
        paramBundle.putInt((String)localObject1, e.n.aKL());
      }
      if (paramBundle != null)
      {
        localObject1 = e.q.klj;
        localObject1 = e.q.aKR();
        localObject2 = e.b.kjz;
        paramBundle.putInt((String)localObject1, e.b.aJK());
      }
      if (paramBundle != null)
      {
        localObject1 = e.q.klj;
        paramBundle.putLong(e.q.aKS(), System.currentTimeMillis());
      }
      if (paramBundle != null)
      {
        localObject1 = e.q.klj;
        localObject1 = e.q.aKT();
        localObject2 = this.knz;
        l1 = l2;
        if (localObject2 != null)
        {
          localObject2 = ((g)localObject2).kjd;
          l1 = l2;
          if (localObject2 != null) {
            l1 = ((f)localObject2).startTime;
          }
        }
        paramBundle.putLong((String)localObject1, l1);
      }
      if (paramBundle != null)
      {
        localObject1 = e.q.klj;
        paramBundle.putInt(e.q.aKZ(), NetStatusUtil.getNetType(MMApplicationContext.getContext()));
      }
      if (paramBundle != null)
      {
        localObject1 = e.q.klj;
        localObject1 = e.q.aLa();
        localObject2 = com.tencent.mm.live.core.d.b.ksV;
        paramBundle.putString((String)localObject1, com.tencent.mm.live.core.d.b.E(paramBundle));
      }
      localObject1 = this.kny;
      if (localObject1 == null) {
        break label628;
      }
      localObject2 = e.e.kjZ;
      ((com.tencent.mm.live.core.core.c)localObject1).callback(e.e.aJZ(), paramBundle);
      AppMethodBeat.o(198588);
      return;
      localObject1 = null;
      break;
      i = 0;
      break label169;
      Log.w(locald.TAG, "tryRestartPlay fail: url is nullornil");
      break label294;
    }
    label628:
    AppMethodBeat.o(198588);
  }
  
  public void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int j = 0;
    int i = 0;
    AppMethodBeat.i(198576);
    Log.i("MicroMsg.LiveCoreVisitor", "onPlayEvent:" + paramInt + ", isPlaying:" + this.kqm.isPlaying());
    if (this.kqm.isPlaying())
    {
      this.kqn = paramInt;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(198576);
      return;
      sX(0);
      paramBundle = this.kny;
      if (paramBundle != null)
      {
        localObject1 = e.e.kjZ;
        com.tencent.mm.live.core.core.c.a.a(paramBundle, e.e.aKa());
        AppMethodBeat.o(198576);
        return;
      }
      AppMethodBeat.o(198576);
      return;
      if (NetStatusUtil.getNetType(MMApplicationContext.getContext()) == -1)
      {
        paramBundle = this.kny;
        if (paramBundle != null)
        {
          localObject1 = e.e.kjZ;
          com.tencent.mm.live.core.core.c.a.a(paramBundle, e.e.aKb());
          AppMethodBeat.o(198576);
          return;
        }
        AppMethodBeat.o(198576);
        return;
        if (NetStatusUtil.getNetType(MMApplicationContext.getContext()) == -1)
        {
          paramBundle = this.kny;
          if (paramBundle != null)
          {
            localObject1 = e.e.kjZ;
            com.tencent.mm.live.core.core.c.a.a(paramBundle, e.e.aKc());
          }
        }
        if (this.kqm.kjn == 0)
        {
          this.kqm.aJE();
          AppMethodBeat.o(198576);
          return;
        }
        this.kqm.eT(false);
        AppMethodBeat.o(198576);
        return;
        paramBundle = this.kqm;
        paramBundle.kji.add(Long.valueOf(System.currentTimeMillis()));
        if (paramBundle.kji.size() > paramBundle.kiZ) {
          paramBundle.kji.remove(0);
        }
        paramBundle = this.kny;
        if (paramBundle != null)
        {
          localObject1 = e.e.kjZ;
          com.tencent.mm.live.core.core.c.a.a(paramBundle, e.e.aKe());
          AppMethodBeat.o(198576);
          return;
        }
        AppMethodBeat.o(198576);
        return;
        localObject1 = this.kny;
        if (localObject1 != null)
        {
          localObject2 = e.e.kjZ;
          ((com.tencent.mm.live.core.core.c)localObject1).callback(e.e.aKd(), paramBundle);
          AppMethodBeat.o(198576);
          return;
        }
        AppMethodBeat.o(198576);
        return;
        localObject2 = this.knz;
        paramInt = i;
        if (localObject2 != null)
        {
          localObject2 = ((g)localObject2).kjd;
          paramInt = i;
          if (localObject2 != null) {
            paramInt = ((f)localObject2).kmn;
          }
        }
        if (paramBundle != null) {
          localObject1 = paramBundle.getByteArray("EVT_GET_MSG");
        }
        if (paramInt > 0)
        {
          h(paramInt, (byte[])localObject1);
          AppMethodBeat.o(198576);
          return;
          Log.i("MicroMsg.LiveCoreVisitor", "steve onPlayEvent first I frame :%d", new Object[] { Integer.valueOf(paramInt) });
          this.kqm.kjn = 0;
          AppMethodBeat.o(198576);
          return;
          if ((paramInt == -2304) && (this.kqm.kjn == 0))
          {
            this.kqm.eT(false);
            this.kqm.aJE();
          }
          localObject1 = localObject2;
          if (paramBundle != null) {
            localObject1 = paramBundle.getString("EVT_MSG");
          }
          paramBundle = com.tencent.mm.live.core.c.b.ksO;
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = "";
          }
          localObject1 = this.knz;
          i = j;
          if (localObject1 != null)
          {
            localObject1 = ((g)localObject1).kmq;
            i = j;
            if (localObject1 != null) {
              i = ((TRTCCloudDef.TRTCParams)localObject1).roomId;
            }
          }
          localObject1 = this.knz;
          if (localObject1 != null)
          {
            localObject1 = ((g)localObject1).kjd;
            if (localObject1 != null)
            {
              localObject2 = ((f)localObject1).kie;
              localObject1 = localObject2;
              if (localObject2 != null) {
                break label706;
              }
            }
          }
          localObject1 = "";
          label706:
          com.tencent.mm.live.core.c.b.a("onPlayEvent", paramInt, paramBundle, i, (String)localObject1);
        }
      }
    }
  }
  
  public final void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    AppMethodBeat.i(198620);
    super.onRemoteUserLeaveRoom(paramString, paramInt);
    AppMethodBeat.o(198620);
  }
  
  public final void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(198654);
    super.onUserVoiceVolume(paramArrayList, paramInt);
    Object localObject1 = new ArrayList();
    Object localObject2;
    if (paramArrayList != null)
    {
      paramArrayList = ((Iterable)paramArrayList).iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = (TRTCCloudDef.TRTCVolumeInfo)paramArrayList.next();
        String str = ((TRTCCloudDef.TRTCVolumeInfo)localObject2).userId;
        p.j(str, "it.userId");
        ((ArrayList)localObject1).add(new UserVolumeInfo(str, ((TRTCCloudDef.TRTCVolumeInfo)localObject2).volume));
      }
    }
    paramArrayList = new Bundle();
    paramArrayList.putParcelableArrayList("live_user_volume_info", (ArrayList)localObject1);
    localObject1 = this.kny;
    if (localObject1 != null)
    {
      localObject2 = e.e.kjZ;
      ((com.tencent.mm.live.core.core.c)localObject1).callback(e.e.aKg(), paramArrayList);
      AppMethodBeat.o(198654);
      return;
    }
    AppMethodBeat.o(198654);
  }
  
  public final void release()
  {
    AppMethodBeat.i(198647);
    super.release();
    this.knk.removeCallbacks((Runnable)this.kqo);
    AppMethodBeat.o(198647);
  }
  
  public final void sX(int paramInt)
  {
    AppMethodBeat.i(198658);
    super.sX(paramInt);
    if (com.tencent.mm.ae.d.dr(paramInt, 4)) {
      fi(false);
    }
    AppMethodBeat.o(198658);
  }
  
  public final int stopPush()
  {
    AppMethodBeat.i(198643);
    this.kns.e(null);
    this.knl.enableCustomVideoCapture(false);
    this.knB = false;
    AppMethodBeat.o(198643);
    return 0;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "TAG", "", "getInstance", "hasInstance", "", "releaseInstance", "", "plugin-core_release"})
  public static final class a
  {
    public static boolean aLi()
    {
      AppMethodBeat.i(198967);
      if (c.aMl() != null)
      {
        AppMethodBeat.o(198967);
        return true;
      }
      AppMethodBeat.o(198967);
      return false;
    }
    
    public static c aMm()
    {
      AppMethodBeat.i(198966);
      if (c.aMl() == null) {
        c.e(new c());
      }
      c localc = c.aMl();
      if (localc == null) {
        p.iCn();
      }
      AppMethodBeat.o(198966);
      return localc;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-core_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(199137);
      Object localObject = c.b(this.kqr);
      if (localObject != null)
      {
        com.tencent.mm.live.core.debug.a locala = com.tencent.mm.live.core.debug.a.kqB;
        if (c.c(this.kqr) == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.live.core.core.trtc.WXTRTCCloudImpl");
          AppMethodBeat.o(199137);
          throw ((Throwable)localObject);
        }
        localObject = ((g)localObject).kmq.userId;
        p.j(localObject, "trtcParams.userId");
        com.tencent.mm.live.core.debug.a.NP(String.valueOf(com.tencent.mm.live.core.core.trtc.b.Ny((String)localObject)));
      }
      c.d(this.kqr).removeCallbacks((Runnable)this);
      c.d(this.kqr).postDelayed((Runnable)this, 10000L);
      AppMethodBeat.o(199137);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$floatMode$2", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-core_release"})
  public static final class c
    implements TextureView.SurfaceTextureListener
  {
    c(j paramj, long paramLong) {}
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199249);
      Log.i("MicroMsg.LiveCoreVisitor", "float onSurfaceTextureAvailable, surface:" + paramSurfaceTexture + ", size:[" + paramInt1 + ", " + paramInt2 + ']');
      this.kqs.bO(paramSurfaceTexture);
      this.kqs.dt(paramInt1, paramInt2);
      com.tencent.mm.live.core.c.c.ty((int)Util.ticksToNow(l));
      AppMethodBeat.o(199249);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(199243);
      Log.i("MicroMsg.LiveCoreVisitor", "float onSurfaceTextureDestroyed");
      AppMethodBeat.o(199243);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199241);
      this.kqs.dt(paramInt1, paramInt2);
      AppMethodBeat.o(199241);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$normalMode$1$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "surface", "plugin-core_release"})
  public static final class d
    implements TextureView.SurfaceTextureListener
  {
    d(j paramj, long paramLong) {}
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(200370);
      p.k(paramSurfaceTexture, "surfaceTexture");
      Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureAvailable, size:[%s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.klr.bO(new Surface(paramSurfaceTexture));
      this.klr.dt(paramInt1, paramInt2);
      com.tencent.mm.live.core.c.c.tx((int)Util.ticksToNow(l2));
      AppMethodBeat.o(200370);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(200375);
      p.k(paramSurfaceTexture, "surfaceTexture");
      Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureDestroyed");
      this.klr.aMX();
      AppMethodBeat.o(200375);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(200373);
      p.k(paramSurfaceTexture, "surfaceTexture");
      Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureSizeChanged, size:[%s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.klr.dt(paramInt1, paramInt2);
      AppMethodBeat.o(200373);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(200376);
      p.k(paramSurfaceTexture, "surface");
      AppMethodBeat.o(200376);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.q<n, Integer, Integer, x>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  public static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.q<n, Integer, Integer, x>
  {
    public f(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "mFps", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, x>
  {
    public static final g kqw;
    
    static
    {
      AppMethodBeat.i(198027);
      kqw = new g();
      AppMethodBeat.o(198027);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "cost", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, x>
  {
    public static final h kqx;
    
    static
    {
      AppMethodBeat.i(200828);
      kqx = new h();
      AppMethodBeat.o(200828);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.c.c
 * JD-Core Version:    0.7.0.1
 */