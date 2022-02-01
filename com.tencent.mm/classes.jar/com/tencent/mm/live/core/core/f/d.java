package com.tencent.mm.live.core.core.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.liteav.TXLiteAVExternalDecoderFactoryInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.q;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.kernel.f;
import com.tencent.mm.live.core.a.f;
import com.tencent.mm.live.core.core.e.b;
import com.tencent.mm.live.core.core.e.g;
import com.tencent.mm.live.core.core.e.h;
import com.tencent.mm.live.core.core.e.p;
import com.tencent.mm.live.core.core.e.s;
import com.tencent.mm.live.core.core.model.UserVolumeInfo;
import com.tencent.mm.live.core.core.model.g;
import com.tencent.mm.live.core.core.model.i.b;
import com.tencent.mm.live.core.core.model.i.e;
import com.tencent.mm.live.core.core.model.j;
import com.tencent.mm.live.core.core.trtc.sdkadapter.feature.Vcodec2Decoder;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.live.core.view.LiveVideoView;
import com.tencent.mm.protocal.protobuf.diw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.bf;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import com.tencent.trtc.TRTCCloudDef.TRTCVolumeInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/live/core/core/visitor/IMMLiveVisitorCore;", "Lcom/tencent/rtmp/ITXLivePlayListener;", "()V", "appForegroundListener", "Lcom/tencent/mm/app/IAppForegroundListener;", "cacheMute", "", "cdnPlayerManager", "Lcom/tencent/mm/live/core/core/LiveCdnPlayerManager;", "curPlayerStatus", "", "debugRunnable", "com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1;", "isBackground", "player", "Lcom/tencent/mm/live/core/core/player/ILivePlayer;", "playerView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "streamType", "videoHeight", "getVideoHeight", "()I", "setVideoHeight", "(I)V", "videoRatioWH", "", "getVideoRatioWH", "()F", "setVideoRatioWH", "(F)V", "videoWidth", "getVideoWidth", "setVideoWidth", "cdnPausePlay", "", "cdnResumePlay", "cdnStartPlay", "Lcom/tencent/mm/live/core/view/LiveVideoView;", "playCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "cdnStopPlay", "keepLastFrame", "checkStartPlayState", "directGetTXLivePlayer", "enterRoom", "callback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "floatMode", "context", "Landroid/content/Context;", "forceMoveTask", "dontFinish", "generateType", "opType", "muteVideoImage", "Landroid/graphics/Bitmap;", "isFluentFloatShow", "getCdnPlayerManager", "getLiveMiniManager", "Lcom/tencent/mm/live/core/mini/LiveMiniManager;", "getPlayDesktopSwitch", "getPlayer", "getPlayerView", "getTXLivePlayer", "outterConfig", "Lcom/tencent/rtmp/TXLivePlayConfig;", "switchStreamCallback", "Lcom/tencent/mm/live/core/core/visitor/ILiveSwitchStreamCallback;", "vrLive", "hideMiniWindowWhenBackground", "isAnchorLinkMic", "isAudioMicing", "isCdnMode", "isInLinkMic", "isPlaying", "key", "", "isVideoMicing", "makeRemotePreviewFullScreen", "monitorLiveInfo", "event", "normalMode", "onCdnPlayerAvailalbe", "liveId", "onEnterRoom", "result", "onFirstVideoFrame", "userId", "", "width", "height", "onNetStatus", "params", "Landroid/os/Bundle;", "onPlayEvent", "param", "onRemoteUserLeaveRoom", "reason", "onUserVoiceVolume", "userVolumes", "Ljava/util/ArrayList;", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVolumeInfo;", "totalVolume", "pauseRender", "realSetMute", "mute", "refreshByOrientation", "release", "resumeRender", "setLiveMiniState", "newState", "setMute", "setMuteWhenBackground", "setPlayerView", "glRootView", "setRenderMode", "mode", "setRenderRotation", "rotation", "setTXLivePlayer", "setupLiveRoomInfo", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "setupMiniWindowRenderView", "before", "startLinkMic", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "startPush", "stopLinkMic", "stopPush", "switchAudioLinkMic", "switchToCdnMode", "renderMode", "action", "switchVideoLinkMic", "updateFillMode", "updatePreviewView", "visitRoom", "Companion", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d
  extends com.tencent.mm.live.core.core.trtc.a
  implements c, ITXLivePlayListener
{
  public static final a mUj;
  private static d mUs;
  public float hKI;
  private final q mUk;
  private TXCloudVideoView mUl;
  public com.tencent.mm.live.core.core.c.b mUm;
  public com.tencent.mm.live.core.core.d mUn;
  private int mUo;
  public boolean mUp;
  private boolean mUq;
  private final b mUr;
  public int streamType;
  public int videoHeight;
  public int videoWidth;
  
  static
  {
    AppMethodBeat.i(248134);
    mUj = new a((byte)0);
    AppMethodBeat.o(248134);
  }
  
  public d()
  {
    super(false);
    AppMethodBeat.i(248048);
    this.mUn = new com.tencent.mm.live.core.core.d();
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yZb, 5);
    if (i > 0) {
      sW(i);
    }
    this.mUk = ((q)new q()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        boolean bool = true;
        AppMethodBeat.i(248041);
        Log.i("MicroMsg.LiveCoreVisitor", "onAppBackground setMute");
        d.a(this.mUt, true);
        if (this.mUt.beK()) {
          this.mUt.fP(true);
        }
        if (this.mUt.beL())
        {
          d.d(this.mUt);
          com.tencent.mm.live.core.mini.b.bfR();
        }
        for (;;)
        {
          paramAnonymousString = d.e(this.mUt);
          if (paramAnonymousString != null) {
            paramAnonymousString.fK(bool);
          }
          AppMethodBeat.o(248041);
          return;
          bool = false;
        }
      }
      
      public final void onAppForeground(String paramAnonymousString)
      {
        boolean bool = false;
        AppMethodBeat.i(248036);
        Log.i("MicroMsg.LiveCoreVisitor", s.X("onAppForeground cacheMute:", Boolean.valueOf(d.c(this.mUt))));
        d.a(this.mUt, false);
        if (this.mUt.beK()) {
          this.mUt.setMute(d.c(this.mUt));
        }
        if (this.mUt.beL())
        {
          d.d(this.mUt);
          com.tencent.mm.live.core.mini.b.bfS();
          bool = true;
        }
        paramAnonymousString = d.e(this.mUt);
        if (paramAnonymousString != null) {
          paramAnonymousString.fJ(bool);
        }
        AppMethodBeat.o(248036);
      }
    });
    AppForegroundDelegate.heY.a(this.mUk);
    if ((this instanceof com.tencent.mm.live.core.core.e.a))
    {
      Object localObject = com.tencent.mm.live.core.core.b.a.mOr;
      localObject = com.tencent.mm.live.core.core.b.a.a.beC();
      com.tencent.mm.live.core.core.b.a.enableP2p = false;
      ((com.tencent.mm.live.core.core.b.a)localObject).release();
      Log.i(((com.tencent.mm.live.core.core.b.a)localObject).TAG, "xp2p Wrapper disableP2P");
    }
    Log.i("MicroMsg.LiveCoreVisitor", "get sei report interval:" + i + ", final:" + beV());
    this.mUr = new b(this);
    AppMethodBeat.o(248048);
  }
  
  public static boolean bfK()
  {
    AppMethodBeat.i(248058);
    Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.adaZ, Boolean.TRUE);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(248058);
      throw ((Throwable)localObject);
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    Log.i("MicroMsg.LiveCoreVisitor", s.X("getPlayDesktopSwitch ", Boolean.valueOf(bool)));
    AppMethodBeat.o(248058);
    return bool;
  }
  
  public final int a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, Bitmap paramBitmap, boolean paramBoolean3)
  {
    AppMethodBeat.i(248196);
    s.u(paramContext, "context");
    Log.i("MicroMsg.LiveCoreVisitor", "floatMode isAudioMode:" + this.mRB.bex() + " inVideoMic:" + this.mRB.bet() + " inAudioMic:" + this.mRB.beu() + " isCdnMode:" + bfD());
    if (this.mRB.isFloatMode())
    {
      AppMethodBeat.o(248196);
      return 0;
    }
    long l = Util.currentTicks();
    this.mRB.mNK = i.e.mOg;
    a(paramBitmap, l, paramBoolean3);
    paramInt1 = super.a(paramContext, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramBitmap, paramBoolean3);
    AppMethodBeat.o(248196);
    return paramInt1;
  }
  
  public final com.tencent.mm.live.core.core.c.b a(Context paramContext, TXLivePlayConfig paramTXLivePlayConfig, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(248376);
    s.u(paramContext, "context");
    com.tencent.mm.live.core.core.d locald = this.mUn;
    ITXLivePlayListener localITXLivePlayListener = (ITXLivePlayListener)this;
    s.u(paramContext, "context");
    if (locald.mJG == null)
    {
      locald.mJW = 0;
      if (!paramBoolean) {
        break label375;
      }
      locald.mJX = 2;
      locald.mJW = 1;
      i = 1;
      Log.i(locald.TAG, "customRenderInfo = %d", new Object[] { Integer.valueOf(locald.mJX) });
      g localg = locald.mJH;
      if (localg != null)
      {
        localg.mNw = locald.mJW;
        localg.mNx = locald.mJX;
      }
      if (locald.mJW <= 0) {
        break label793;
      }
      paramContext = (com.tencent.mm.live.core.core.c.b)new com.tencent.mm.live.core.core.d.a.b(paramContext, i);
      label148:
      locald.mJG = paramContext;
      paramContext = paramTXLivePlayConfig;
      if (paramTXLivePlayConfig == null) {
        paramContext = new TXLivePlayConfig();
      }
      locald.mJS = paramContext;
      locald.mJV = paramb;
      paramContext = locald.mJG;
      if (paramContext != null) {
        paramContext.setPlayListener(localITXLivePlayListener);
      }
      paramContext = locald.mJG;
      if (paramContext != null) {
        paramContext.enableHardwareDecode(true);
      }
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yZc, false))
      {
        paramContext = locald.mJG;
        if (paramContext != null) {
          paramContext.enableHardwareDecode(false);
        }
        Log.i(locald.TAG, "txLivePlayer closes the hardware decoder");
      }
      paramBoolean = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yZd, true);
      if ((com.tencent.mm.compatible.deviceinfo.m.aOK() & 0xFF) <= 60) {
        break label808;
      }
    }
    label641:
    label781:
    label793:
    label808:
    for (int i = 1;; i = 0)
    {
      if ((paramBoolean) && (i != 0))
      {
        locald.mJT = 1;
        TXLiveBase.setExternalDecoderFactory((TXLiteAVExternalDecoderFactoryInterface)new Vcodec2Decoder());
        Log.i(locald.TAG, "txLivePlayer opens the vcodec2 decoder");
      }
      locald.bco();
      paramContext = locald.mJG;
      if (paramContext != null) {
        paramContext.setRenderMode(1);
      }
      paramContext = locald.mJG;
      AppMethodBeat.o(248376);
      return paramContext;
      label375:
      boolean bool1;
      label446:
      label456:
      boolean bool2;
      label466:
      boolean bool3;
      label478:
      boolean bool4;
      if (af.lXY.lTG != 1)
      {
        i = com.tencent.mm.compatible.deviceinfo.m.aOK();
        int j = i >> 12 & 0xF;
        int k = i & 0xFF;
        int m = Build.VERSION.SDK_INT;
        int n = com.tencent.mm.media.util.d.nFC.bqn();
        long l = com.tencent.matrix.e.a.aG(MMApplicationContext.getContext()) / 1024L / 1024L;
        if (j >= 4)
        {
          paramBoolean = true;
          if (k < 71) {
            break label731;
          }
          bool1 = true;
          if (m < 23) {
            break label737;
          }
          bool2 = true;
          if (l < 4096L) {
            break label743;
          }
          bool3 = true;
          if (n < ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yZK, 80)) {
            break label749;
          }
          bool4 = true;
          label504:
          Log.i(locald.TAG, "checkLiveRendererSharpenLocalConfig, cpuFlags:%s, nCores:%s,gpuScore %s nFreq:%s, sdkInt:%s, totalMemMB:%s, coreNumCheck:%s, freqCheck:%s, sdkIntCheck:%s, totalMemMBCheck:%s gpuCheck:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
          if ((!paramBoolean) || (!bool1) || (!bool2) || (!bool3) || (!bool4)) {
            break label755;
          }
          i = 1;
          if (i == 0) {
            break label761;
          }
          locald.mJX = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yZJ, 0);
          Log.i(locald.TAG, "clicfg_finder_live_enable_sharpen_xlab_android = %d", new Object[] { Integer.valueOf(locald.mJX) });
        }
      }
      for (;;)
      {
        if ((locald.mJX != 5) && (locald.mJX != 6)) {
          break label781;
        }
        locald.mJW = 1;
        i = 2;
        break;
        paramBoolean = false;
        break label446;
        label731:
        bool1 = false;
        break label456;
        label737:
        bool2 = false;
        break label466;
        label743:
        bool3 = false;
        break label478;
        label749:
        bool4 = false;
        break label504;
        label755:
        i = 0;
        break label641;
        label761:
        locald.mJX = 0;
        Log.i(locald.TAG, "Device check not pass");
      }
      locald.mJW = 0;
      i = 0;
      break;
      paramContext = (com.tencent.mm.live.core.core.c.b)new com.tencent.mm.live.core.core.c.a(paramContext);
      break label148;
    }
  }
  
  public void a(int paramInt, LiveVideoView paramLiveVideoView, kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    Object localObject2 = null;
    com.tencent.mm.live.core.core.b.a.a locala = null;
    AppMethodBeat.i(248323);
    com.tencent.mm.live.core.core.d locald = this.mUn;
    Object localObject3 = locald.TAG;
    StringBuilder localStringBuilder = new StringBuilder("startPlay liveId:");
    Object localObject1 = locald.mJH;
    label101:
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      Log.i((String)localObject3, localObject1 + ",player:" + locald.mJG + ',');
      localObject1 = locald.mJH;
      if (localObject1 != null) {
        break label374;
      }
      localObject1 = null;
      if ((localObject1 == null) || (locald.mJG == null)) {
        break label496;
      }
      if (paramLiveVideoView != null)
      {
        localObject3 = locald.mJG;
        if (localObject3 != null) {
          ((com.tencent.mm.live.core.core.c.b)localObject3).setPlayerView((TXCloudVideoView)paramLiveVideoView);
        }
      }
      paramLiveVideoView = locald.mJG;
      if ((paramLiveVideoView == null) || (paramLiveVideoView.isPlaying())) {
        break label389;
      }
      i = 1;
      label163:
      if (i == 0) {
        break label436;
      }
      localObject2 = locald.TAG;
      localObject3 = new StringBuilder("startPlay liveId:");
      paramLiveVideoView = locald.mJH;
      if (paramLiveVideoView != null) {
        break label395;
      }
      paramLiveVideoView = null;
      label199:
      Log.i((String)localObject2, paramLiveVideoView + ", player:" + locald.mJG + ", url:" + localObject1);
      localObject2 = locald.mJG;
      if (localObject2 != null)
      {
        paramLiveVideoView = com.tencent.mm.live.core.d.a.mWH;
        paramLiveVideoView = locald.mJH;
        if (paramLiveVideoView != null) {
          break label406;
        }
        paramLiveVideoView = locala;
        label267:
        ((com.tencent.mm.live.core.core.c.b)localObject2).D(com.tencent.mm.live.core.d.a.a(paramLiveVideoView, (String)localObject1), locald.mJY);
      }
      paramLiveVideoView = com.tencent.mm.live.core.core.b.a.mOr;
      com.tencent.mm.live.core.core.b.a.a.beC();
      if (!com.tencent.mm.live.core.core.b.a.bez()) {
        break label414;
      }
      paramLiveVideoView = locald.mJG;
      if (paramLiveVideoView != null)
      {
        locala = com.tencent.mm.live.core.core.b.a.mOr;
        paramLiveVideoView.Y(com.tencent.mm.live.core.core.b.a.a.beC().g((String)localObject1, com.tencent.mm.live.core.core.d.getStreamIDByStreamUrl((String)localObject1), false), paramInt);
      }
      label335:
      if (paramb != null) {
        paramb.invoke(Boolean.TRUE);
      }
    }
    for (;;)
    {
      this.streamType = paramInt;
      AppMethodBeat.o(248323);
      return;
      localObject1 = Long.valueOf(((g)localObject1).liveId);
      break;
      label374:
      localObject1 = ((g)localObject1).sP(locald.mJK);
      break label101;
      label389:
      i = 0;
      break label163;
      label395:
      paramLiveVideoView = Long.valueOf(paramLiveVideoView.liveId);
      break label199;
      label406:
      paramLiveVideoView = paramLiveVideoView.mNv;
      break label267;
      label414:
      paramLiveVideoView = locald.mJG;
      if (paramLiveVideoView == null) {
        break label335;
      }
      paramLiveVideoView.Y((String)localObject1, paramInt);
      break label335;
      label436:
      localObject1 = locald.TAG;
      paramLiveVideoView = locald.mJH;
      if (paramLiveVideoView == null) {}
      for (paramLiveVideoView = (LiveVideoView)localObject2;; paramLiveVideoView = Long.valueOf(paramLiveVideoView.liveId))
      {
        Log.i((String)localObject1, s.X("refresh palyView liveId:", paramLiveVideoView));
        if (paramb == null) {
          break;
        }
        paramb.invoke(Boolean.TRUE);
        break;
      }
      label496:
      if (paramb != null) {
        paramb.invoke(Boolean.FALSE);
      }
    }
  }
  
  public final void a(long paramLong, com.tencent.mm.live.core.core.c.b paramb, TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(248250);
    Log.i("MicroMsg.LiveCoreVisitor", "cdnPlayAvailable liveId:" + paramLong + ",player:" + paramb);
    this.mUl = paramTXCloudVideoView;
    this.mUm = paramb;
    AppMethodBeat.o(248250);
  }
  
  public final void a(Bitmap paramBitmap, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(248206);
    if ((this.mRB.bet()) || (this.mRB.beu()) || (!bfD())) {}
    Object localObject;
    for (int i = 1; (this.mRB.bex()) && ((!bfz()) || (i != 0)); i = 0)
    {
      localObject = new ImageView(MMApplicationContext.getContext());
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((ImageView)localObject).setImageBitmap(paramBitmap);
      this.mRq.dc((View)localObject);
      AppMethodBeat.o(248206);
      return;
    }
    if (i != 0)
    {
      paramBitmap = beP().FY(this.mRB.mNM);
      if (paramBitmap != null)
      {
        localObject = ax(paramBitmap.userId, paramBitmap.streamType);
        if (localObject != null) {
          ((TXCloudVideoView)localObject).removeVideoView();
        }
        Log.i("MicroMsg.LiveCoreVisitor", "enter float mode");
        paramBitmap.bgH();
        localObject = new TextureView(MMApplicationContext.getContext());
        ((TextureView)localObject).setSurfaceTextureListener((TextureView.SurfaceTextureListener)new d.h(paramBitmap, paramLong));
        this.mRq.dc((View)localObject);
        AppMethodBeat.o(248206);
      }
    }
    else
    {
      Log.i("MicroMsg.LiveCoreVisitor", "setupMiniWindowRenderView player:" + this.mUm + ", isFluentFloatShow:" + paramBoolean);
      if (!paramBoolean)
      {
        paramBitmap = new TXCloudVideoView(MMApplicationContext.getContext());
        localObject = this.mUm;
        if (localObject != null) {
          ((com.tencent.mm.live.core.core.c.b)localObject).setRenderMode(0);
        }
        this.mRq.dc((View)paramBitmap);
        localObject = this.mUn.mJG;
        if (localObject != null)
        {
          ((com.tencent.mm.live.core.core.c.b)localObject).setPlayerView(paramBitmap);
          AppMethodBeat.o(248206);
        }
      }
      else
      {
        paramBitmap = MMApplicationContext.getContext();
        s.s(paramBitmap, "getContext()");
        paramBitmap = new com.tencent.mm.live.core.view.a(paramBitmap);
        this.mRq.dc((View)paramBitmap);
      }
    }
    AppMethodBeat.o(248206);
  }
  
  public final void a(com.tencent.mm.live.core.core.c.b paramb)
  {
    this.mUn.mJG = paramb;
  }
  
  public final void a(com.tencent.mm.live.core.core.c paramc)
  {
    AppMethodBeat.i(248221);
    s.u(paramc, "callback");
    super.a(paramc);
    paramc = beO();
    Drawable localDrawable = MMApplicationContext.getContext().getResources().getDrawable(a.f.mic_user_leave);
    s.s(localDrawable, "getContext().resources.g…ble(R.raw.mic_user_leave)");
    paramc.setVideoMuteImage(com.tencent.mm.ae.d.drawable2Bitmap(localDrawable), 5);
    com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTi = false;
    com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfo().mSJ = false;
    AppMethodBeat.o(248221);
  }
  
  public final void a(LivePreviewView paramLivePreviewView, com.tencent.mm.live.core.core.c paramc)
  {
    AppMethodBeat.i(248234);
    s.u(paramc, "callback");
    if (paramLivePreviewView != null) {
      this.mRt = paramLivePreviewView;
    }
    a(paramc);
    AppMethodBeat.o(248234);
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(248383);
    com.tencent.mm.live.core.core.d locald = this.mUn;
    locald.mJH = paramg;
    locald.mJK = com.tencent.mm.live.core.core.a.mJp.value;
    Object localObject1;
    boolean bool2;
    boolean bool1;
    label85:
    Object localObject2;
    Object localObject3;
    label111:
    com.tencent.mm.live.core.core.b.a locala;
    label162:
    label220:
    label227:
    Context localContext;
    int i;
    label283:
    int j;
    label289:
    int k;
    label296:
    int m;
    label303:
    int n;
    label310:
    int i1;
    label317:
    int i2;
    label324:
    int i3;
    label331:
    label340:
    label349:
    label358:
    int i4;
    if (paramg == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        locald.mJK = ((Integer)localObject1).intValue();
      }
      bool2 = false;
      bool1 = bool2;
      if (paramg != null)
      {
        if (!paramg.bel()) {
          break label424;
        }
        locald.mJK = paramg.sS(paramg.mNs);
        bool1 = true;
      }
      localObject2 = locald.TAG;
      localObject3 = new StringBuilder("setupLiveRoomInfo cdnQualitySvrcfg:");
      if (paramg != null) {
        break label436;
      }
      localObject1 = null;
      localObject3 = ((StringBuilder)localObject3).append(localObject1).append(",CDN_QUALITY_HD:").append(com.tencent.mm.live.core.core.a.mJp.value).append(", lastCdnQuality:").append(locald.mJK).append(",cdnCustomerSwitchCfg:");
      if (paramg != null) {
        break label448;
      }
      localObject1 = null;
      Log.i((String)localObject2, localObject1 + ",cdnCustomerSwitchCfgEnable:" + bool1);
      localObject1 = com.tencent.mm.live.core.core.b.a.mOr;
      com.tencent.mm.live.core.core.b.a.a.beC();
      if (com.tencent.mm.live.core.core.b.a.bez())
      {
        localObject1 = com.tencent.mm.live.core.core.b.a.mOr;
        localObject3 = com.tencent.mm.live.core.core.b.a.a.beC();
        if (paramg != null) {
          break label460;
        }
        localObject1 = null;
        if (paramg != null) {
          break label472;
        }
        localObject2 = null;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.b.a)localObject3).liveId = ((Long)localObject1).longValue();
        }
        if (localObject2 != null) {
          ((com.tencent.mm.live.core.core.b.a)localObject3).mPd = ((String)localObject2);
        }
        localObject1 = com.tencent.mm.live.core.core.b.a.mOr;
        locala = com.tencent.mm.live.core.core.b.a.a.beC();
        localContext = MMApplicationContext.getContext();
        s.s(localContext, "getContext()");
        if (paramg != null) {
          break label481;
        }
        i = 0;
        if (paramg != null) {
          break label506;
        }
        j = 0;
        if (paramg != null) {
          break label531;
        }
        k = 0;
        if (paramg != null) {
          break label558;
        }
        m = 0;
        if (paramg != null) {
          break label585;
        }
        n = 0;
        if (paramg != null) {
          break label612;
        }
        i1 = 0;
        if (paramg != null) {
          break label639;
        }
        i2 = 0;
        if (paramg != null) {
          break label666;
        }
        i3 = 0;
        if (paramg != null) {
          break label693;
        }
        localObject1 = "";
        if (paramg != null) {
          break label736;
        }
        localObject2 = "";
        if (paramg != null) {
          break label779;
        }
        localObject3 = "";
        if (paramg != null) {
          break label822;
        }
        i4 = 0;
      }
    }
    for (;;)
    {
      locala.a(localContext, i, j, k, m, n, i1, i2, i3, (String)localObject1, (String)localObject2, (String)localObject3, i4);
      Log.i(locald.TAG, "liveRoomInfo setupLiveRoomInfo");
      AppMethodBeat.o(248383);
      return;
      localObject1 = Integer.valueOf(paramg.mNr);
      break;
      label424:
      paramg.mNs = -1;
      bool1 = bool2;
      break label85;
      label436:
      localObject1 = Integer.valueOf(paramg.mNr);
      break label111;
      label448:
      localObject1 = Integer.valueOf(paramg.mNs);
      break label162;
      label460:
      localObject1 = Long.valueOf(paramg.liveId);
      break label220;
      label472:
      localObject2 = paramg.mIA;
      break label227;
      label481:
      localObject1 = paramg.mNv;
      if (localObject1 == null)
      {
        i = 0;
        break label283;
      }
      i = ((diw)localObject1).aaNY;
      break label283;
      label506:
      localObject1 = paramg.mNv;
      if (localObject1 == null)
      {
        j = 0;
        break label289;
      }
      j = ((diw)localObject1).aaNZ;
      break label289;
      label531:
      localObject1 = paramg.mNv;
      if (localObject1 == null)
      {
        k = 0;
        break label296;
      }
      k = ((diw)localObject1).aaOa;
      break label296;
      label558:
      localObject1 = paramg.mNv;
      if (localObject1 == null)
      {
        m = 0;
        break label303;
      }
      m = ((diw)localObject1).aaOb;
      break label303;
      label585:
      localObject1 = paramg.mNv;
      if (localObject1 == null)
      {
        n = 0;
        break label310;
      }
      n = ((diw)localObject1).aaOc;
      break label310;
      label612:
      localObject1 = paramg.mNv;
      if (localObject1 == null)
      {
        i1 = 0;
        break label317;
      }
      i1 = ((diw)localObject1).aaOd;
      break label317;
      label639:
      localObject1 = paramg.mNv;
      if (localObject1 == null)
      {
        i2 = 0;
        break label324;
      }
      i2 = ((diw)localObject1).aaOe;
      break label324;
      label666:
      localObject1 = paramg.mNv;
      if (localObject1 == null)
      {
        i3 = 0;
        break label331;
      }
      i3 = ((diw)localObject1).aaOf;
      break label331;
      label693:
      localObject1 = paramg.mNv;
      if (localObject1 == null)
      {
        localObject1 = "";
        break label340;
      }
      localObject2 = ((diw)localObject1).aaOg;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label340;
      }
      localObject1 = "";
      break label340;
      label736:
      localObject2 = paramg.mNv;
      if (localObject2 == null)
      {
        localObject2 = "";
        break label349;
      }
      localObject3 = ((diw)localObject2).aaOh;
      localObject2 = localObject3;
      if (localObject3 != null) {
        break label349;
      }
      localObject2 = "";
      break label349;
      label779:
      localObject3 = paramg.mNv;
      if (localObject3 == null)
      {
        localObject3 = "";
        break label358;
      }
      String str = ((diw)localObject3).aaOi;
      localObject3 = str;
      if (str != null) {
        break label358;
      }
      localObject3 = "";
      break label358;
      label822:
      paramg = paramg.mNv;
      if (paramg == null) {
        i4 = 0;
      } else {
        i4 = paramg.aaOk;
      }
    }
  }
  
  public final void b(LivePreviewView paramLivePreviewView)
  {
    AppMethodBeat.i(248300);
    com.tencent.mm.live.core.core.trtc.sdkadapter.c localc = beQ();
    if (localc != null) {
      localc.fL(this.mRB.bex());
    }
    bcj();
    a(paramLivePreviewView);
    this.mRB.mNH = i.b.mNW;
    this.mRs.v((kotlin.g.a.b)d.k.mUw);
    AppMethodBeat.o(248300);
  }
  
  public final void bcg()
  {
    AppMethodBeat.i(248214);
    if (!this.mRB.isFloatMode())
    {
      AppMethodBeat.o(248214);
      return;
    }
    Object localObject1 = new StringBuilder("normalMode playerView is empty:");
    boolean bool;
    Object localObject2;
    if (this.mUl == null)
    {
      bool = true;
      localObject2 = ((StringBuilder)localObject1).append(bool).append(", liveId:");
      localObject1 = this.mRA;
      if (localObject1 != null) {
        break label293;
      }
      localObject1 = null;
    }
    for (;;)
    {
      Log.i("MicroMsg.LiveCoreVisitor", localObject1);
      long l = Util.currentTicks();
      this.mRB.mNK = i.e.mOf;
      if (this.mUl != null)
      {
        localObject1 = this.mUm;
        if (localObject1 != null) {
          ((com.tencent.mm.live.core.core.c.b)localObject1).setPlayerView(this.mUl);
        }
      }
      localObject1 = beP().FY(this.mRB.mNM);
      if (localObject1 != null)
      {
        Log.i("MicroMsg.LiveCoreVisitor", s.X("normalMode, find renderSurface for userId:", this.mRB.mNM));
        localObject2 = ax(((com.tencent.mm.live.core.b.h)localObject1).userId, ((com.tencent.mm.live.core.b.h)localObject1).streamType);
        if (localObject2 != null)
        {
          TextureView localTextureView = new TextureView(MMApplicationContext.getContext());
          ((TXCloudVideoView)localObject2).addVideoView(localTextureView);
          localTextureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new d.c((com.tencent.mm.live.core.b.h)localObject1, l));
        }
      }
      if (this.mRB.bet())
      {
        localObject1 = this.mRt;
        if (localObject1 != null) {
          ((LivePreviewView)localObject1).a((kotlin.g.a.b)new d(this), (kotlin.g.a.m)new e(this));
        }
      }
      super.bcg();
      AppMethodBeat.o(248214);
      return;
      bool = false;
      break;
      label293:
      localObject1 = ((com.tencent.mm.live.core.core.model.h)localObject1).mJH;
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = Long.valueOf(((g)localObject1).liveId);
      }
    }
  }
  
  public final int bcj()
  {
    AppMethodBeat.i(248387);
    this.mRs.u((kotlin.g.a.b)d.i.mUu);
    beO().enableCustomVideoCapture(true);
    this.mRC = true;
    AppMethodBeat.o(248387);
    return 0;
  }
  
  public boolean beK()
  {
    return false;
  }
  
  public boolean beL()
  {
    return false;
  }
  
  public final boolean beZ()
  {
    AppMethodBeat.i(248266);
    com.tencent.mm.live.core.core.trtc.sdkadapter.c localc = beQ();
    if ((localc != null) && (localc.mSA == 21)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(248266);
      return true;
    }
    AppMethodBeat.o(248266);
    return false;
  }
  
  public final boolean bfC()
  {
    AppMethodBeat.i(248329);
    boolean bool = this.mUn.isPlaying();
    AppMethodBeat.o(248329);
    return bool;
  }
  
  public final boolean bfD()
  {
    AppMethodBeat.i(248145);
    Object localObject;
    int i;
    if (this.mSe == null)
    {
      localObject = this.mRA;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.live.core.core.model.h)localObject).mJH;
        if (localObject != null)
        {
          i = ((g)localObject).mNn;
          localObject = e.b.mKf;
          if (i == e.b.bcu())
          {
            AppMethodBeat.o(248145);
            return true;
          }
          AppMethodBeat.o(248145);
          return false;
        }
      }
    }
    else
    {
      localObject = this.mSe;
      e.b localb = e.b.mKf;
      i = e.b.bcu();
      if (localObject != null) {
        break label88;
      }
    }
    label88:
    while (((Integer)localObject).intValue() != i)
    {
      AppMethodBeat.o(248145);
      return false;
    }
    AppMethodBeat.o(248145);
    return true;
  }
  
  public final void bfE()
  {
    Object localObject2 = null;
    AppMethodBeat.i(248240);
    com.tencent.mm.live.core.core.trtc.sdkadapter.b.c localc;
    String str;
    if (!TextUtils.isEmpty((CharSequence)this.mRB.mNM))
    {
      localc = beP();
      str = this.mRB.mNM;
      localObject1 = this.mRt;
      if (localObject1 == null)
      {
        localObject1 = null;
        localc.a(str, (TXCloudVideoView)localObject1);
        beP().muteRemoteAudio(this.mRB.mNM, false);
      }
    }
    else if (!TextUtils.isEmpty((CharSequence)this.mRB.mNO))
    {
      localc = beP();
      str = this.mRB.mNO;
      localObject1 = this.mRt;
      if (localObject1 != null) {
        break label202;
      }
    }
    label202:
    for (Object localObject1 = localObject2;; localObject1 = ((LivePreviewView)localObject1).az(this.mRB.mNO, 0))
    {
      localc.a(str, (TXCloudVideoView)localObject1);
      beP().muteRemoteAudio(this.mRB.mNM, false);
      if (this.mRB.bet())
      {
        localObject1 = this.mRt;
        if (localObject1 != null) {
          ((LivePreviewView)localObject1).a((kotlin.g.a.b)new f(this), (kotlin.g.a.m)new g(this));
        }
      }
      AppMethodBeat.o(248240);
      return;
      localObject1 = ((LivePreviewView)localObject1).az(this.mRB.mNM, 0);
      break;
    }
  }
  
  public final int bfF()
  {
    AppMethodBeat.i(248258);
    this.mRB.mNH = i.b.mNV;
    Object localObject = com.tencent.mm.live.core.debug.a.mUy;
    com.tencent.mm.live.core.debug.a.aH("MicroMsg.LiveCoreMic", "[sdk]start link mic");
    localObject = beQ();
    if ((localObject != null) && (((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject).mSA == 20)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(248258);
      return 0;
    }
    com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfo().mSJ = true;
    localObject = beQ();
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject).fL(this.mRB.bex());
    }
    localObject = beQ();
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject).bfu();
    }
    localObject = beQ();
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject).startLocalAudio();
    }
    AppMethodBeat.o(248258);
    return 0;
  }
  
  public final int bfG()
  {
    AppMethodBeat.i(248274);
    this.mRB.mNH = i.b.mNU;
    Object localObject = com.tencent.mm.live.core.debug.a.mUy;
    com.tencent.mm.live.core.debug.a.aH("MicroMsg.LiveCoreMic", "[sdk]stop link mic");
    localObject = beQ();
    if ((localObject != null) && (((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject).mSA == 21)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(248274);
      return 0;
    }
    com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfo().mSJ = false;
    com.tencent.mm.live.core.core.trtc.sdkadapter.a.a.bfr().bfn().mTi = false;
    localObject = beQ();
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject).bfu();
    }
    localObject = beQ();
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.sdkadapter.c)localObject).mSx.stopLocalAudio();
    }
    bce();
    AppMethodBeat.o(248274);
    return 0;
  }
  
  public final void bfH()
  {
    AppMethodBeat.i(248285);
    Log.printInfoStack("MicroMsg.LiveCoreVisitor", "pauseRender", new Object[0]);
    com.tencent.mm.live.core.core.trtc.sdkadapter.b.c localc = beP();
    String str = this.mRB.mNM;
    if (!localc.mTE) {
      localc.mSx.stopRemoteView(str);
    }
    for (;;)
    {
      com.tencent.mm.live.core.core.trtc.sdkadapter.b.b.a.bfv().FS(Util.nullAsNil(str));
      localc.FX(str);
      beP().muteRemoteAudio(this.mRB.mNM, true);
      AppMethodBeat.o(248285);
      return;
      localc.FZ(str);
    }
  }
  
  public final void bfI()
  {
    AppMethodBeat.i(248292);
    if (this.mRt != null)
    {
      Log.printInfoStack("MicroMsg.LiveCoreVisitor", "resumeRender", new Object[0]);
      if (!TextUtils.isEmpty((CharSequence)this.mRB.mNM))
      {
        com.tencent.mm.live.core.core.trtc.sdkadapter.b.c localc = beP();
        String str = this.mRB.mNM;
        Object localObject = this.mRt;
        if (localObject == null) {}
        for (localObject = null;; localObject = ((LivePreviewView)localObject).az(this.mRB.mNM, 0))
        {
          localc.a(str, (TXCloudVideoView)localObject);
          beP().muteRemoteAudio(this.mRB.mNM, false);
          AppMethodBeat.o(248292);
          return;
        }
      }
    }
    else
    {
      Log.w("MicroMsg.LiveCoreVisitor", "previewView == null!");
    }
    AppMethodBeat.o(248292);
  }
  
  public final void bfJ()
  {
    AppMethodBeat.i(248309);
    stopPush();
    bce();
    this.mRB.mNH = i.b.mNV;
    AppMethodBeat.o(248309);
  }
  
  public boolean bfz()
  {
    return false;
  }
  
  public void fO(boolean paramBoolean)
  {
    AppMethodBeat.i(248336);
    this.mUn.fD(paramBoolean);
    AppMethodBeat.o(248336);
  }
  
  public void fP(boolean paramBoolean)
  {
    AppMethodBeat.i(248356);
    this.mUn.setMute(paramBoolean);
    AppMethodBeat.o(248356);
  }
  
  public final void onEnterRoom(long paramLong)
  {
    AppMethodBeat.i(248227);
    super.onEnterRoom(paramLong);
    this.mRi.post((Runnable)this.mUr);
    AppMethodBeat.o(248227);
  }
  
  public final void onFirstVideoFrame(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    AppMethodBeat.i(248400);
    super.onFirstVideoFrame(paramString, paramInt1, paramInt2, paramInt3);
    paramInt1 = this.mRN;
    e.h localh = e.h.mKY;
    if (paramInt1 != e.h.bdj())
    {
      if (bf.bf(MMApplicationContext.getContext()).x > bf.bf(MMApplicationContext.getContext()).y)
      {
        paramInt1 = 1;
        if (paramInt2 <= paramInt3) {
          break label111;
        }
      }
      label111:
      for (paramInt2 = i;; paramInt2 = 0)
      {
        if (paramInt1 != paramInt2) {
          break label116;
        }
        Log.i("MicroMsg.LiveCoreVisitor", "updateFillMode to SCALE_TYPE_CENTER_CROP");
        paramString = beP().FY(paramString);
        if (paramString == null) {
          break label143;
        }
        paramString.ti(2);
        AppMethodBeat.o(248400);
        return;
        paramInt1 = 0;
        break;
      }
      label116:
      Log.i("MicroMsg.LiveCoreVisitor", "updateFillMode to SCALE_TYPE_FIT_MODE");
      paramString = beP().FY(paramString);
      if (paramString != null) {
        paramString.ti(5);
      }
    }
    label143:
    AppMethodBeat.o(248400);
  }
  
  public void onNetStatus(Bundle paramBundle)
  {
    Object localObject3 = null;
    long l2 = 0L;
    AppMethodBeat.i(248187);
    int i = NetStatusUtil.getNetType(MMApplicationContext.getContext());
    Log.i("MicroMsg.LiveCoreVisitor", "onNetStatus curPlayStatus:" + this.mUo + ", netQuality:" + i + ", isPlaying:" + this.mUn.isPlaying() + ",netStatus:" + paramBundle);
    com.tencent.mm.live.core.core.d locald;
    int j;
    Object localObject1;
    Object localObject2;
    if ((this.mUn.isPlaying()) && (i != -1) && (this.mUo == -2301))
    {
      this.mUo = 0;
      locald = this.mUn;
      j = this.streamType;
      localObject1 = locald.mJH;
      if (localObject1 != null) {
        break label622;
      }
      localObject1 = null;
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label637;
      }
      i = 1;
      label161:
      if (i != 0) {
        break label690;
      }
      localObject2 = locald.mJG;
      if (localObject2 != null) {
        ((com.tencent.mm.live.core.core.c.b)localObject2).fD(false);
      }
      Object localObject4 = locald.mJG;
      if (localObject4 != null)
      {
        localObject2 = com.tencent.mm.live.core.d.a.mWH;
        localObject2 = locald.mJH;
        if (localObject2 != null) {
          break label642;
        }
        localObject2 = null;
        label217:
        com.tencent.mm.live.core.core.c.b.a.a((com.tencent.mm.live.core.core.c.b)localObject4, com.tencent.mm.live.core.d.a.a((diw)localObject2, (String)localObject1));
      }
      localObject2 = com.tencent.mm.live.core.core.b.a.mOr;
      com.tencent.mm.live.core.core.b.a.a.beC();
      if (!com.tencent.mm.live.core.core.b.a.bez()) {
        break label652;
      }
      localObject2 = locald.mJG;
      if (localObject2 != null)
      {
        localObject4 = com.tencent.mm.live.core.core.b.a.mOr;
        ((com.tencent.mm.live.core.core.c.b)localObject2).Y(com.tencent.mm.live.core.core.b.a.a.beC().g((String)localObject1, com.tencent.mm.live.core.core.d.getStreamIDByStreamUrl((String)localObject1), false), j);
      }
      label283:
      localObject4 = locald.TAG;
      StringBuilder localStringBuilder = new StringBuilder("tryRestartPlay liveId:");
      localObject2 = locald.mJH;
      if (localObject2 != null) {
        break label677;
      }
      localObject2 = localObject3;
      label318:
      Log.i((String)localObject4, localObject2 + ", player:" + locald.mJG + ", url:" + localObject1);
      label358:
      localObject1 = this.mRy;
      if (localObject1 != null)
      {
        localObject2 = e.g.mKv;
        com.tencent.mm.live.core.core.c.a.a((com.tencent.mm.live.core.core.c)localObject1, e.g.bcR());
      }
    }
    this.mUn.bcm();
    long l1;
    if (paramBundle != null)
    {
      localObject1 = e.s.mLT;
      localObject1 = e.s.bdM();
      localObject2 = this.mRA;
      if (localObject2 == null)
      {
        l1 = 0L;
        label417:
        paramBundle.putLong((String)localObject1, l1);
      }
    }
    else
    {
      if (paramBundle != null)
      {
        localObject1 = e.s.mLT;
        localObject1 = e.s.bdN();
        localObject2 = e.p.mLE;
        paramBundle.putInt((String)localObject1, e.p.bdH());
      }
      if (paramBundle != null)
      {
        localObject1 = e.s.mLT;
        localObject1 = e.s.bdO();
        localObject2 = e.b.mKf;
        paramBundle.putInt((String)localObject1, e.b.bcu());
      }
      if (paramBundle != null)
      {
        localObject1 = e.s.mLT;
        paramBundle.putLong(e.s.bdP(), System.currentTimeMillis());
      }
      if (paramBundle != null)
      {
        localObject1 = e.s.mLT;
        localObject1 = e.s.bdQ();
        localObject2 = this.mRA;
        if (localObject2 != null) {
          break label732;
        }
        l1 = l2;
      }
    }
    for (;;)
    {
      paramBundle.putLong((String)localObject1, l1);
      if (paramBundle != null)
      {
        localObject1 = e.s.mLT;
        paramBundle.putInt(e.s.bdW(), NetStatusUtil.getNetType(MMApplicationContext.getContext()));
      }
      if (paramBundle != null)
      {
        localObject1 = e.s.mLT;
        localObject1 = e.s.bdY();
        localObject2 = com.tencent.mm.live.core.d.c.mWN;
        paramBundle.putString((String)localObject1, com.tencent.mm.live.core.d.c.L(paramBundle));
      }
      localObject1 = this.mRy;
      if (localObject1 != null)
      {
        localObject2 = e.g.mKv;
        ((com.tencent.mm.live.core.core.c)localObject1).callback(e.g.bcS(), paramBundle);
      }
      AppMethodBeat.o(248187);
      return;
      label622:
      localObject1 = ((g)localObject1).sP(locald.mJK);
      break;
      label637:
      i = 0;
      break label161;
      label642:
      localObject2 = ((g)localObject2).mNv;
      break label217;
      label652:
      localObject2 = locald.mJG;
      if (localObject2 == null) {
        break label283;
      }
      ((com.tencent.mm.live.core.core.c.b)localObject2).Y((String)localObject1, j);
      break label283;
      label677:
      localObject2 = Long.valueOf(((g)localObject2).liveId);
      break label318;
      label690:
      Log.w(locald.TAG, "tryRestartPlay fail: url is nullornil");
      break label358;
      localObject2 = ((com.tencent.mm.live.core.core.model.h)localObject2).mJH;
      if (localObject2 == null)
      {
        l1 = 0L;
        break label417;
      }
      l1 = ((g)localObject2).liveId;
      break label417;
      label732:
      localObject2 = ((com.tencent.mm.live.core.core.model.h)localObject2).mJH;
      l1 = l2;
      if (localObject2 != null) {
        l1 = ((g)localObject2).startTime;
      }
    }
  }
  
  public void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(248174);
    Log.d("MicroMsg.LiveCoreVisitor", "onPlayEvent:" + paramInt + ", isPlaying:" + this.mUn.isPlaying() + ", hashcode=" + hashCode());
    if (this.mUn.isPlaying())
    {
      this.mUo = paramInt;
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(248174);
      return;
      ta(0);
      Object localObject1 = this.mRy;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = e.g.mKv;
        com.tencent.mm.live.core.core.c.a.a((com.tencent.mm.live.core.core.c)localObject1, e.g.bcT());
      }
      boolean bool;
      label308:
      label355:
      label376:
      com.tencent.mm.live.core.core.d locald;
      label393:
      Object localObject3;
      label450:
      label457:
      Object localObject4;
      label481:
      String str;
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yZC, 1) == 1)
      {
        bool = true;
        Log.i("MicroMsg.LiveCoreVisitor", "[cdnplay] event :%d, isHttpsEnable:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
        if ((paramInt != 2001) || (!bool)) {
          break;
        }
        if (paramBundle != null) {
          break label919;
        }
        localObject1 = null;
        localObject2 = new k("([0-9]{1,3}.){3}[0-9]{1,3}");
        if (localObject1 != null) {
          break label931;
        }
        paramBundle = "";
        paramBundle = k.a((k)localObject2, (CharSequence)paramBundle);
        if (paramBundle != null) {
          break label937;
        }
        localObject2 = null;
        paramBundle = new k("^10\\.|^192\\.168|^172\\.(1[6-9]|2[0-9]|3[0-1])\\.");
        if ((localObject2 != null) && (paramBundle.bn((CharSequence)localObject2)) && (this.mUn.mJR == 0))
        {
          locald = this.mUn;
          paramBundle = locald.mJH;
          if (paramBundle != null) {
            break label948;
          }
          localObject3 = null;
          if (localObject3 != null) {
            break label962;
          }
          paramBundle = null;
          localObject4 = (CharSequence)paramBundle;
          if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
            break label971;
          }
          i = 1;
          if (i != 0) {
            break label1031;
          }
          str = new k("^http:").e((CharSequence)paramBundle, "https:");
          localObject4 = (CharSequence)str;
          if ((localObject4 != null) && (((CharSequence)localObject4).length() != 0)) {
            break label977;
          }
          i = 1;
          label533:
          if ((i == 0) && (locald.mJH != null))
          {
            localObject4 = locald.mJG;
            if (localObject4 != null) {
              ((com.tencent.mm.live.core.core.c.b)localObject4).fD(false);
            }
            localObject5 = locald.mJG;
            if (localObject5 != null)
            {
              localObject4 = com.tencent.mm.live.core.d.a.mWH;
              localObject4 = locald.mJH;
              if (localObject4 != null) {
                break label983;
              }
              localObject4 = null;
              label598:
              com.tencent.mm.live.core.core.c.b.a.a((com.tencent.mm.live.core.core.c.b)localObject5, com.tencent.mm.live.core.d.a.a((diw)localObject4, str));
            }
            localObject4 = com.tencent.mm.live.core.core.b.a.mOr;
            com.tencent.mm.live.core.core.b.a.a.beC();
            if (!com.tencent.mm.live.core.core.b.a.bez()) {
              break label993;
            }
            localObject4 = locald.mJG;
            if (localObject4 != null)
            {
              localObject5 = com.tencent.mm.live.core.core.b.a.mOr;
              ((com.tencent.mm.live.core.core.c.b)localObject4).Y(com.tencent.mm.live.core.core.b.a.a.beC().g(str, com.tencent.mm.live.core.core.d.getStreamIDByStreamUrl(str), true), 1);
            }
            label664:
            localObject4 = locald.mJH;
            s.checkNotNull(localObject4);
            ((Map)((g)localObject4).mNt).put(Integer.valueOf(locald.mJK), new j(str, ((j)localObject3).level, ((j)localObject3).desc));
            locald.mJR += 1;
          }
          localObject4 = locald.TAG;
          Object localObject5 = new StringBuilder("tryPlayHttpsUrl liveId:");
          localObject3 = locald.mJH;
          if (localObject3 != null) {
            break label1018;
          }
          localObject3 = null;
          label763:
          Log.i((String)localObject4, localObject3 + ", player:" + locald.mJG + ", url:" + paramBundle + ", httpsurl:" + str);
          label813:
          paramBundle = am.aixg;
          localObject4 = String.format("try https innerip:%s", Arrays.copyOf(new Object[] { localObject2 }, 1));
          s.s(localObject4, "java.lang.String.format(format, *args)");
          paramBundle = com.tencent.mm.live.core.c.b.mWD;
          paramBundle = this.mRA;
          if (paramBundle != null) {
            break label1045;
          }
          i = 0;
          label862:
          paramBundle = this.mRA;
          if (paramBundle != null) {
            break label1069;
          }
          paramBundle = "";
        }
      }
      for (;;)
      {
        com.tencent.mm.live.core.c.b.a("onPlayEvent", paramInt, (String)localObject4, i, paramBundle);
        Log.i("MicroMsg.LiveCoreVisitor", "[cdnplay] server ip :%s, ipstr:%s", new Object[] { localObject1, localObject2 });
        break;
        bool = false;
        break label308;
        label919:
        localObject1 = paramBundle.getString("EVT_MSG");
        break label355;
        label931:
        paramBundle = (Bundle)localObject1;
        break label376;
        label937:
        localObject2 = paramBundle.getValue();
        break label393;
        label948:
        localObject3 = paramBundle.sQ(locald.mJK);
        break label450;
        label962:
        paramBundle = ((j)localObject3).url;
        break label457;
        label971:
        i = 0;
        break label481;
        label977:
        i = 0;
        break label533;
        label983:
        localObject4 = ((g)localObject4).mNv;
        break label598;
        label993:
        localObject4 = locald.mJG;
        if (localObject4 == null) {
          break label664;
        }
        ((com.tencent.mm.live.core.core.c.b)localObject4).Y(str, 1);
        break label664;
        label1018:
        localObject3 = Long.valueOf(((g)localObject3).liveId);
        break label763;
        label1031:
        Log.w(locald.TAG, "tryPlayHttpsUrl fail: url is nullornil");
        break label813;
        label1045:
        paramBundle = paramBundle.mNz;
        if (paramBundle == null)
        {
          i = 0;
          break label862;
        }
        i = paramBundle.roomId;
        break label862;
        label1069:
        paramBundle = paramBundle.mJH;
        if (paramBundle == null)
        {
          paramBundle = "";
        }
        else
        {
          localObject3 = paramBundle.mIA;
          paramBundle = (Bundle)localObject3;
          if (localObject3 == null) {
            paramBundle = "";
          }
        }
      }
      if (NetStatusUtil.getNetType(MMApplicationContext.getContext()) == -1)
      {
        paramBundle = this.mRy;
        if (paramBundle != null)
        {
          localObject1 = e.g.mKv;
          com.tencent.mm.live.core.core.c.a.a(paramBundle, e.g.bcU());
        }
      }
      for (;;)
      {
        paramBundle = com.tencent.mm.live.core.core.b.a.mOr;
        com.tencent.mm.live.core.core.b.a.a.beC();
        if (!com.tencent.mm.live.core.core.b.a.bez()) {
          break;
        }
        paramBundle = com.tencent.mm.live.core.core.b.a.mOr;
        com.tencent.mm.live.core.core.b.a.a.beC().beA();
        break;
        paramBundle = this.mRy;
        if (paramBundle != null)
        {
          localObject1 = e.g.mKv;
          com.tencent.mm.live.core.core.c.a.a(paramBundle, e.g.bdh());
        }
      }
      if (NetStatusUtil.getNetType(MMApplicationContext.getContext()) == -1)
      {
        paramBundle = this.mRy;
        if (paramBundle != null)
        {
          localObject1 = e.g.mKv;
          com.tencent.mm.live.core.core.c.a.a(paramBundle, e.g.bcV());
        }
      }
      for (;;)
      {
        if (this.mUn.mJR != 0) {
          break label1263;
        }
        this.mUn.bcn();
        break;
        paramBundle = this.mRy;
        if (paramBundle != null)
        {
          localObject1 = e.g.mKv;
          com.tencent.mm.live.core.core.c.a.a(paramBundle, e.g.bdg());
        }
      }
      label1263:
      this.mUn.fD(false);
      break;
      paramBundle = this.mRy;
      if (paramBundle == null) {
        break;
      }
      localObject1 = e.g.mKv;
      com.tencent.mm.live.core.core.c.a.a(paramBundle, e.g.bdf());
      break;
      paramBundle = this.mUn;
      paramBundle.mJM.add(Long.valueOf(System.currentTimeMillis()));
      if (paramBundle.mJM.size() > paramBundle.mJD) {
        paramBundle.mJM.remove(0);
      }
      paramBundle = this.mRy;
      if (paramBundle == null) {
        break;
      }
      localObject1 = e.g.mKv;
      com.tencent.mm.live.core.core.c.a.a(paramBundle, e.g.bcX());
      break;
      if (paramBundle == null)
      {
        i = 0;
        label1371:
        this.videoWidth = i;
        if (paramBundle != null) {
          break label1465;
        }
        i = 0;
        label1384:
        this.videoHeight = i;
        if ((this.videoWidth == 0) || (this.videoHeight == 0)) {
          break label1477;
        }
      }
      label1465:
      label1477:
      for (float f = 1.0F * this.videoWidth / this.videoHeight;; f = 0.0F)
      {
        this.hKI = f;
        localObject1 = this.mRy;
        if (localObject1 == null) {
          break;
        }
        localObject2 = e.g.mKv;
        ((com.tencent.mm.live.core.core.c)localObject1).callback(e.g.bcW(), paramBundle);
        break;
        i = paramBundle.getInt("EVT_PARAM1");
        break label1371;
        i = paramBundle.getInt("EVT_PARAM2");
        break label1384;
      }
      localObject1 = this.mRA;
      if (localObject1 == null)
      {
        i = 0;
        label1496:
        if (paramBundle != null) {
          break label1545;
        }
      }
      label1545:
      for (paramBundle = null; i > 0; paramBundle = paramBundle.getByteArray("EVT_GET_MSG"))
      {
        h(i, paramBundle);
        break;
        localObject1 = ((com.tencent.mm.live.core.core.model.h)localObject1).mJH;
        if (localObject1 == null)
        {
          i = 0;
          break label1496;
        }
        i = ((g)localObject1).mNu;
        break label1496;
      }
      Log.i("MicroMsg.LiveCoreVisitor", "steve onPlayEvent first I frame :%d", new Object[] { Integer.valueOf(paramInt) });
      paramBundle = this.mUm;
      if (paramBundle == null)
      {
        paramBundle = null;
        label1587:
        if (paramBundle == null) {
          break label1639;
        }
      }
      label1639:
      for (int i = paramBundle.hashCode();; i = 0)
      {
        com.tencent.mm.live.core.core.model.b.sM(i);
        this.mUn.mJR = 0;
        paramBundle = beU();
        if (paramBundle == null) {
          break;
        }
        com.tencent.mm.live.core.core.c.a.a(paramBundle, 2003);
        break;
        paramBundle = paramBundle.getPlayer();
        break label1587;
      }
      paramBundle = this.mRy;
      if (paramBundle == null) {
        break;
      }
      localObject1 = e.g.mKv;
      com.tencent.mm.live.core.core.c.a.a(paramBundle, e.g.bdc());
      break;
      paramBundle = this.mRy;
      if (paramBundle == null) {
        break;
      }
      localObject1 = e.g.mKv;
      com.tencent.mm.live.core.core.c.a.a(paramBundle, e.g.bdd());
      break;
      if ((paramInt == -2304) && (this.mUn.mJR == 0))
      {
        this.mUn.fD(false);
        this.mUn.bcn();
      }
      if (paramBundle == null)
      {
        paramBundle = null;
        label1731:
        localObject1 = com.tencent.mm.live.core.c.b.mWD;
        localObject1 = paramBundle;
        if (paramBundle == null) {
          localObject1 = "";
        }
        paramBundle = this.mRA;
        if (paramBundle != null) {
          break label1819;
        }
        i = 0;
        label1760:
        paramBundle = this.mRA;
        if (paramBundle != null) {
          break label1843;
        }
        paramBundle = "";
      }
      for (;;)
      {
        com.tencent.mm.live.core.c.b.a("onPlayEvent", paramInt, (String)localObject1, i, paramBundle);
        break;
        paramBundle = paramBundle.getString("EVT_MSG");
        if (paramBundle == null)
        {
          paramBundle = null;
          break label1731;
        }
        paramBundle = n.bV(paramBundle, ",", ";");
        break label1731;
        label1819:
        paramBundle = paramBundle.mNz;
        if (paramBundle == null)
        {
          i = 0;
          break label1760;
        }
        i = paramBundle.roomId;
        break label1760;
        label1843:
        paramBundle = paramBundle.mJH;
        if (paramBundle == null)
        {
          paramBundle = "";
        }
        else
        {
          localObject2 = paramBundle.mIA;
          paramBundle = (Bundle)localObject2;
          if (localObject2 == null) {
            paramBundle = "";
          }
        }
      }
      paramBundle = beU();
      if (paramBundle != null)
      {
        com.tencent.mm.live.core.core.c.a.a(paramBundle, 2004);
        AppMethodBeat.o(248174);
        return;
        paramBundle = beU();
        if (paramBundle != null)
        {
          com.tencent.mm.live.core.core.c.a.a(paramBundle, 2001);
          AppMethodBeat.o(248174);
          return;
          paramBundle = beU();
          if (paramBundle != null) {
            com.tencent.mm.live.core.core.c.a.a(paramBundle, 2008);
          }
        }
      }
    }
  }
  
  public final void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    AppMethodBeat.i(248278);
    super.onRemoteUserLeaveRoom(paramString, paramInt);
    AppMethodBeat.o(248278);
  }
  
  public final void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(248405);
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
        s.s(str, "it.userId");
        ((ArrayList)localObject1).add(new UserVolumeInfo(str, ((TRTCCloudDef.TRTCVolumeInfo)localObject2).volume));
      }
    }
    paramArrayList = new Bundle();
    paramArrayList.putParcelableArrayList("live_user_volume_info", (ArrayList)localObject1);
    localObject1 = this.mRy;
    if (localObject1 != null)
    {
      localObject2 = e.g.mKv;
      ((com.tencent.mm.live.core.core.c)localObject1).callback(e.g.bcZ(), paramArrayList);
    }
    AppMethodBeat.o(248405);
  }
  
  public void release()
  {
    AppMethodBeat.i(248392);
    super.release();
    this.mRi.removeCallbacks((Runnable)this.mUr);
    AppForegroundDelegate.heY.b(this.mUk);
    AppMethodBeat.o(248392);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(248348);
    this.mUp = paramBoolean;
    if ((this.mUq) && (beK()))
    {
      fP(true);
      AppMethodBeat.o(248348);
      return;
    }
    fP(paramBoolean);
    AppMethodBeat.o(248348);
  }
  
  public final void setRenderMode(int paramInt)
  {
    AppMethodBeat.i(248342);
    com.tencent.mm.live.core.core.c.b localb = this.mUn.mJG;
    if (localb != null) {
      localb.setRenderMode(paramInt);
    }
    AppMethodBeat.o(248342);
  }
  
  public final int stopPush()
  {
    AppMethodBeat.i(248386);
    this.mRs.u(null);
    beO().enableCustomVideoCapture(false);
    this.mRC = false;
    AppMethodBeat.o(248386);
    return 0;
  }
  
  public final void ta(int paramInt)
  {
    AppMethodBeat.i(248408);
    super.ta(paramInt);
    if (com.tencent.mm.ae.d.ee(paramInt, 4)) {
      fO(false);
    }
    AppMethodBeat.o(248408);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "TAG", "", "getInstance", "hasInstance", "", "releaseInstance", "", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean bek()
    {
      AppMethodBeat.i(248009);
      if (d.bfL() != null)
      {
        AppMethodBeat.o(248009);
        return true;
      }
      AppMethodBeat.o(248009);
      return false;
    }
    
    public static d bfM()
    {
      AppMethodBeat.i(248003);
      if (d.bfL() == null) {
        d.a(new d());
      }
      d locald = d.bfL();
      s.checkNotNull(locald);
      AppMethodBeat.o(248003);
      return locald;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Runnable
  {
    b(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(248008);
      Object localObject = d.f(this.mUt);
      if (localObject != null)
      {
        d locald = this.mUt;
        com.tencent.mm.live.core.debug.a locala = com.tencent.mm.live.core.debug.a.mUy;
        d.h(locald);
        localObject = ((com.tencent.mm.live.core.core.model.h)localObject).mNz.userId;
        s.s(localObject, "trtcParams.userId");
        com.tencent.mm.live.core.debug.a.Gc(String.valueOf(com.tencent.mm.live.core.core.trtc.c.FR((String)localObject)));
      }
      d.g(this.mUt).removeCallbacks((Runnable)this);
      d.g(this.mUt).postDelayed((Runnable)this, 10000L);
      AppMethodBeat.o(248008);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<SurfaceTexture, ah>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "width", "", "height"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.m<Integer, Integer, ah>
  {
    e(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<SurfaceTexture, ah>
  {
    f(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "width", "", "height"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.m<Integer, Integer, ah>
  {
    g(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.core.core.f.d
 * JD-Core Version:    0.7.0.1
 */