package com.tencent.mm.live.core.core.d;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.b.h;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.mm.live.core.core.b.f;
import com.tencent.mm.live.core.core.b.g;
import com.tencent.mm.live.core.core.b.g.b;
import com.tencent.mm.live.core.core.b.g.d;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.live.core.core.e.a;
import com.tencent.mm.live.core.core.e.d;
import com.tencent.mm.live.core.core.e.i;
import com.tencent.mm.live.core.core.e.j;
import com.tencent.mm.live.core.core.trtc.a.g;
import com.tencent.mm.live.core.core.trtc.a.h;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/live/core/core/visitor/IMMLiveVisitorCore;", "Lcom/tencent/rtmp/ITXLivePlayListener;", "()V", "cdnPlayerManager", "Lcom/tencent/mm/live/core/core/LiveCdnPlayerManager;", "curPlayerStatus", "", "debugRunnable", "com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1;", "playerView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "streamType", "cdnStartPlay", "", "Lcom/tencent/mm/live/core/view/LiveVideoView;", "playCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "cdnStopPlay", "keepLastFrame", "enterRoom", "callback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "floatMode", "context", "Landroid/content/Context;", "forceMoveTask", "dontFinish", "generateType", "opType", "getTXLivePlayer", "Lcom/tencent/rtmp/TXLivePlayer;", "outterConfig", "Lcom/tencent/rtmp/TXLivePlayConfig;", "isAudioMicing", "isCdnMode", "isInLinkMic", "isVideoMicing", "makeRemotePreviewFullScreen", "normalMode", "onCdnPlayerAvailalbe", "liveId", "", "player", "onEnterRoom", "result", "onFirstVideoFrame", "userId", "", "width", "height", "onNetStatus", "params", "Landroid/os/Bundle;", "onPlayEvent", "event", "param", "onRemoteUserLeaveRoom", "reason", "pauseRender", "refreshByOrientation", "release", "resumeRender", "setupLiveRoomInfo", "liveRoomInfo", "Lcom/tencent/mm/live/core/core/model/LiveRoomInfo;", "startLinkMic", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "startPush", "stopLinkMic", "stopPush", "switchAudioLinkMic", "switchVideoLinkMic", "updateFillMode", "updatePreviewView", "visitRoom", "Companion", "plugin-core_release"})
public class b
  extends com.tencent.mm.live.core.core.trtc.a
  implements a, ITXLivePlayListener
{
  private static b hCn;
  public static final a hCo;
  private TXCloudVideoView hCj;
  private com.tencent.mm.live.core.core.d hCk;
  private int hCl;
  private final b hCm;
  public int streamType;
  
  static
  {
    AppMethodBeat.i(196558);
    hCo = new a((byte)0);
    AppMethodBeat.o(196558);
  }
  
  public b()
  {
    super(false);
    AppMethodBeat.i(196557);
    this.hCk = com.tencent.mm.live.core.core.d.hwY;
    this.hCm = new b(this);
    AppMethodBeat.o(196557);
  }
  
  public final int a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(196537);
    p.h(paramContext, "context");
    if (this.hAz.isFloatMode())
    {
      AppMethodBeat.o(196537);
      return 0;
    }
    final long l = Util.currentTicks();
    this.hAz.hzE = g.d.hzX;
    if ((!this.hAz.aDt()) && (!this.hAz.aDu()))
    {
      localObject1 = this.hAy;
      int i = j;
      if (localObject1 != null)
      {
        localObject1 = ((f)localObject1).hwP;
        i = j;
        if (localObject1 != null)
        {
          int k = ((e)localObject1).hzl;
          localObject1 = e.a.hxc;
          i = j;
          if (k == e.a.aCf()) {
            i = 1;
          }
        }
      }
      if (i != 0) {}
    }
    else
    {
      localObject1 = this.hAm.Gy(this.hAz.hzG);
      if (localObject1 != null)
      {
        localObject2 = W(((h)localObject1).userId, ((h)localObject1).streamType);
        if (localObject2 != null) {
          ((TXCloudVideoView)localObject2).removeVideoView();
        }
        Log.i("MicroMsg.LiveCoreVisitor", "enter float mode");
        ((h)localObject1).aEG();
        localObject2 = new TextureView(MMApplicationContext.getContext());
        ((TextureView)localObject2).setSurfaceTextureListener((TextureView.SurfaceTextureListener)new c((h)localObject1, l));
        this.hAq.co((View)localObject2);
      }
      paramInt1 = super.a(paramContext, paramBoolean1, paramBoolean2, paramInt1, paramInt2);
      AppMethodBeat.o(196537);
      return paramInt1;
    }
    Object localObject1 = this.hAm;
    Object localObject2 = this.hAy;
    if (localObject2 != null)
    {
      localObject2 = ((f)localObject2).hwP;
      if (localObject2 == null) {}
    }
    for (l = ((e)localObject2).liveId;; l = 0L)
    {
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a.b.c)localObject1).zv(l);
      localObject2 = new TXCloudVideoView(MMApplicationContext.getContext());
      this.hAq.co((View)localObject2);
      ((TXLivePlayer)localObject1).setPlayerView((TXCloudVideoView)localObject2);
      break;
    }
  }
  
  public final void a(long paramLong, TXLivePlayer paramTXLivePlayer, TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(196543);
    this.hCj = paramTXCloudVideoView;
    this.hAm.a(paramLong, paramTXLivePlayer);
    AppMethodBeat.o(196543);
  }
  
  public final void a(com.tencent.mm.live.core.core.c paramc)
  {
    AppMethodBeat.i(196539);
    p.h(paramc, "callback");
    super.a(paramc);
    paramc = com.tencent.mm.live.core.core.trtc.a.a.aDC();
    p.g(paramc, "ConfigHelper.getInstance()");
    paramc = paramc.aDD();
    p.g(paramc, "ConfigHelper.getInstance().videoConfig");
    paramc.eC(false);
    paramc = com.tencent.mm.live.core.core.trtc.a.a.aDC();
    p.g(paramc, "ConfigHelper.getInstance()");
    paramc = paramc.aDE();
    p.g(paramc, "ConfigHelper.getInstance().audioConfig");
    paramc.ez(false);
    AppMethodBeat.o(196539);
  }
  
  public final void a(LivePreviewView paramLivePreviewView)
  {
    this.hAs = paramLivePreviewView;
  }
  
  public final void a(LivePreviewView paramLivePreviewView, com.tencent.mm.live.core.core.c paramc)
  {
    AppMethodBeat.i(196541);
    p.h(paramc, "callback");
    this.hAs = paramLivePreviewView;
    a(paramc);
    AppMethodBeat.o(196541);
  }
  
  public final void aBU()
  {
    AppMethodBeat.i(196538);
    if (!this.hAz.isFloatMode())
    {
      AppMethodBeat.o(196538);
      return;
    }
    final long l2 = Util.currentTicks();
    this.hAz.hzE = g.d.hzW;
    Object localObject1;
    Object localObject2;
    if (this.hCj != null)
    {
      localObject1 = this.hAm;
      localObject2 = this.hAy;
      if (localObject2 == null) {
        break label248;
      }
      localObject2 = ((f)localObject2).hwP;
      if (localObject2 == null) {
        break label248;
      }
    }
    label248:
    for (long l1 = ((e)localObject2).liveId;; l1 = 0L)
    {
      ((com.tencent.mm.live.core.core.trtc.a.b.c)localObject1).zv(l1).setPlayerView(this.hCj);
      localObject1 = this.hAm.Gy(this.hAz.hzG);
      if (localObject1 != null)
      {
        Log.i("MicroMsg.LiveCoreVisitor", "normalMode, find renderSurface for userId:" + this.hAz.hzG);
        localObject2 = W(((h)localObject1).userId, ((h)localObject1).streamType);
        if (localObject2 != null)
        {
          TextureView localTextureView = new TextureView(MMApplicationContext.getContext());
          ((TXCloudVideoView)localObject2).addVideoView(localTextureView);
          localTextureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new d((h)localObject1, l2));
        }
      }
      if (this.hAz.aDt())
      {
        localObject1 = this.hAs;
        if (localObject1 != null) {
          ((LivePreviewView)localObject1).a((kotlin.g.a.q)new e(this));
        }
      }
      super.aBU();
      AppMethodBeat.o(196538);
      return;
    }
  }
  
  public final int aBX()
  {
    AppMethodBeat.i(196553);
    this.hAr.e(null);
    this.hAl.enableCustomVideoCapture(false);
    this.hAA = false;
    AppMethodBeat.o(196553);
    return 0;
  }
  
  public final int aBY()
  {
    AppMethodBeat.i(196554);
    this.hAr.e((kotlin.g.a.b)g.hCv);
    this.hAl.enableCustomVideoCapture(true);
    this.hAA = true;
    AppMethodBeat.o(196554);
    return 0;
  }
  
  public final void aDX()
  {
    Object localObject2 = null;
    AppMethodBeat.i(196542);
    com.tencent.mm.live.core.core.trtc.a.b.c localc;
    String str;
    if (!TextUtils.isEmpty((CharSequence)this.hAz.hzG))
    {
      localc = this.hAm;
      str = this.hAz.hzG;
      localObject1 = this.hAs;
      if (localObject1 == null) {
        break label202;
      }
    }
    label202:
    for (Object localObject1 = ((LivePreviewView)localObject1).X(this.hAz.hzG, 0);; localObject1 = null)
    {
      localc.a(str, (TXCloudVideoView)localObject1);
      this.hAm.muteRemoteAudio(this.hAz.hzG, false);
      if (!TextUtils.isEmpty((CharSequence)this.hAz.hzI))
      {
        localc = this.hAm;
        str = this.hAz.hzI;
        LivePreviewView localLivePreviewView = this.hAs;
        localObject1 = localObject2;
        if (localLivePreviewView != null) {
          localObject1 = localLivePreviewView.X(this.hAz.hzI, 0);
        }
        localc.a(str, (TXCloudVideoView)localObject1);
        this.hAm.muteRemoteAudio(this.hAz.hzG, false);
      }
      if (!this.hAz.aDt()) {
        break;
      }
      localObject1 = this.hAs;
      if (localObject1 == null) {
        break;
      }
      ((LivePreviewView)localObject1).a((kotlin.g.a.q)new f(this));
      AppMethodBeat.o(196542);
      return;
    }
    AppMethodBeat.o(196542);
  }
  
  public final int aDY()
  {
    AppMethodBeat.i(196544);
    this.hAz.hzB = g.b.hzO;
    Object localObject = com.tencent.mm.live.core.debug.a.hCA;
    com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "[sdk]start link mic");
    localObject = this.hAn;
    if ((localObject != null) && (((com.tencent.mm.live.core.core.trtc.a.c)localObject).aDP() == 20))
    {
      AppMethodBeat.o(196544);
      return 0;
    }
    localObject = com.tencent.mm.live.core.core.trtc.a.a.aDC();
    p.g(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aDE();
    p.g(localObject, "ConfigHelper.getInstance().audioConfig");
    ((com.tencent.mm.live.core.core.trtc.a.a.a)localObject).ez(true);
    localObject = this.hAn;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).aDK();
    }
    localObject = this.hAn;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).aDO();
    }
    localObject = this.hAn;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).startLocalAudio();
    }
    AppMethodBeat.o(196544);
    return 0;
  }
  
  public final int aDZ()
  {
    AppMethodBeat.i(196546);
    this.hAz.hzB = g.b.hzN;
    Object localObject = com.tencent.mm.live.core.debug.a.hCA;
    com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "[sdk]stop link mic");
    localObject = this.hAn;
    if ((localObject != null) && (((com.tencent.mm.live.core.core.trtc.a.c)localObject).aDP() == 21))
    {
      AppMethodBeat.o(196546);
      return 0;
    }
    localObject = com.tencent.mm.live.core.core.trtc.a.a.aDC();
    p.g(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aDE();
    p.g(localObject, "ConfigHelper.getInstance().audioConfig");
    ((com.tencent.mm.live.core.core.trtc.a.a.a)localObject).ez(false);
    localObject = com.tencent.mm.live.core.core.trtc.a.a.aDC();
    p.g(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aDD();
    p.g(localObject, "ConfigHelper.getInstance().videoConfig");
    ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).eC(false);
    localObject = this.hAn;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).aDO();
    }
    localObject = this.hAn;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).stopLocalAudio();
    }
    aBS();
    AppMethodBeat.o(196546);
    return 0;
  }
  
  public final boolean aDx()
  {
    AppMethodBeat.i(196545);
    com.tencent.mm.live.core.core.trtc.a.c localc = this.hAn;
    if ((localc == null) || (localc.aDP() != 21))
    {
      AppMethodBeat.o(196545);
      return true;
    }
    AppMethodBeat.o(196545);
    return false;
  }
  
  public final void aEa()
  {
    AppMethodBeat.i(196548);
    this.hAm.Gv(this.hAz.hzG);
    this.hAm.muteRemoteAudio(this.hAz.hzG, true);
    AppMethodBeat.o(196548);
  }
  
  public final void aEb()
  {
    AppMethodBeat.i(196549);
    if (this.hAs != null)
    {
      if (!TextUtils.isEmpty((CharSequence)this.hAz.hzG))
      {
        com.tencent.mm.live.core.core.trtc.a.b.c localc = this.hAm;
        String str = this.hAz.hzG;
        Object localObject = this.hAs;
        if (localObject != null) {}
        for (localObject = ((LivePreviewView)localObject).X(this.hAz.hzG, 0);; localObject = null)
        {
          localc.a(str, (TXCloudVideoView)localObject);
          this.hAm.muteRemoteAudio(this.hAz.hzG, false);
          AppMethodBeat.o(196549);
          return;
        }
      }
    }
    else {
      Log.w("MicroMsg.LiveCoreVisitor", "previewView == null!");
    }
    AppMethodBeat.o(196549);
  }
  
  public final void aEc()
  {
    AppMethodBeat.i(196550);
    Log.i("MicroMsg.LiveCoreVisitor", "[makeRemotePreviewFullScreen] anchorID:" + this.hAz.hzG + " preview:" + this.hAs);
    if (this.hAs != null)
    {
      if (!TextUtils.isEmpty((CharSequence)this.hAz.hzG))
      {
        LivePreviewView localLivePreviewView = this.hAs;
        if (localLivePreviewView != null)
        {
          localLivePreviewView.GE(this.hAz.hzG);
          AppMethodBeat.o(196550);
          return;
        }
        AppMethodBeat.o(196550);
      }
    }
    else {
      Log.w("MicroMsg.LiveCoreVisitor", "previewView == null!");
    }
    AppMethodBeat.o(196550);
  }
  
  public final void aEd()
  {
    AppMethodBeat.i(196552);
    aBX();
    aBS();
    this.hAz.hzB = g.b.hzO;
    AppMethodBeat.o(196552);
  }
  
  public final void b(LivePreviewView paramLivePreviewView)
  {
    AppMethodBeat.i(196551);
    Object localObject = this.hAn;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).aDK();
    }
    aBY();
    if (paramLivePreviewView == null) {
      Log.e("MicroMsg.LiveCore", "startPreview preiewView is null");
    }
    do
    {
      this.hAz.hzB = g.b.hzP;
      this.hAr.f((kotlin.g.a.b)h.hCw);
      AppMethodBeat.o(196551);
      return;
      this.hAr.aEz();
      localObject = com.tencent.mm.live.core.debug.a.hCA;
      com.tencent.mm.live.core.debug.a.GA("startPreview ".concat(String.valueOf(paramLivePreviewView)));
      this.hAs = paramLivePreviewView;
      localObject = com.tencent.mm.live.core.core.trtc.a.a.aDC();
      p.g(localObject, "ConfigHelper.getInstance()");
      localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aDE();
      p.g(localObject, "ConfigHelper.getInstance().audioConfig");
      ((com.tencent.mm.live.core.core.trtc.a.a.a)localObject).ez(true);
      localObject = com.tencent.mm.live.core.core.trtc.a.a.aDC();
      p.g(localObject, "ConfigHelper.getInstance()");
      localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aDD();
      p.g(localObject, "ConfigHelper.getInstance().videoConfig");
      ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).eC(true);
      paramLivePreviewView.a((kotlin.g.a.q)new a.h(this));
      paramLivePreviewView = this.hAt;
    } while ((paramLivePreviewView == null) || (paramLivePreviewView.aPc() != true));
    paramLivePreviewView = com.tencent.mm.live.core.core.trtc.a.a.aDC();
    p.g(paramLivePreviewView, "ConfigHelper.getInstance()");
    paramLivePreviewView = paramLivePreviewView.aDG();
    localObject = this.hAt;
    int i;
    if (localObject != null)
    {
      i = ((com.tencent.mm.media.widget.a.d)localObject).aPu();
      label218:
      paramLivePreviewView.hBp = i;
      Log.i("MicroMsg.LiveCore", "start preview success");
      localObject = this.hAr;
      paramLivePreviewView = this.hAt;
      if (paramLivePreviewView == null) {
        break label291;
      }
    }
    label291:
    for (paramLivePreviewView = paramLivePreviewView.aPr();; paramLivePreviewView = null)
    {
      if (paramLivePreviewView == null) {
        p.hyc();
      }
      ((com.tencent.mm.live.core.b.d)localObject).a(paramLivePreviewView);
      this.hAr.setOnDrawListener((kotlin.g.a.b)new a.g(this));
      break;
      i = 0;
      break label218;
    }
  }
  
  public final void onEnterRoom(long paramLong)
  {
    AppMethodBeat.i(196540);
    super.onEnterRoom(paramLong);
    this.hAk.post((Runnable)this.hCm);
    AppMethodBeat.o(196540);
  }
  
  public final void onFirstVideoFrame(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    AppMethodBeat.i(196556);
    super.onFirstVideoFrame(paramString, paramInt1, paramInt2, paramInt3);
    if (au.az(MMApplicationContext.getContext()).x > au.az(MMApplicationContext.getContext()).y)
    {
      paramInt1 = 1;
      if (paramInt2 <= paramInt3) {
        break label94;
      }
      paramInt2 = i;
    }
    for (;;)
    {
      if (paramInt1 == paramInt2)
      {
        Log.i("MicroMsg.LiveCoreVisitor", "updateFillMode to SCALE_TYPE_CENTER_CROP");
        paramString = this.hAm.Gy(paramString);
        if (paramString != null)
        {
          paramString.qy(2);
          AppMethodBeat.o(196556);
          return;
          paramInt1 = 0;
          break;
          label94:
          paramInt2 = 0;
          continue;
        }
        AppMethodBeat.o(196556);
        return;
      }
    }
    Log.i("MicroMsg.LiveCoreVisitor", "updateFillMode to SCALE_TYPE_FIT_MODE");
    paramString = this.hAm.Gy(paramString);
    if (paramString != null)
    {
      paramString.qy(5);
      AppMethodBeat.o(196556);
      return;
    }
    AppMethodBeat.o(196556);
  }
  
  public void onNetStatus(Bundle paramBundle)
  {
    long l2 = 0L;
    AppMethodBeat.i(196536);
    int i = NetStatusUtil.getNetType(MMApplicationContext.getContext());
    Log.i("MicroMsg.LiveCoreVisitor", "onNetStatus curPlayStatus:" + this.hCl + ", netQuality:" + i + ", isPlaying:" + com.tencent.mm.live.core.core.d.isPlaying() + ",netStatus:" + paramBundle);
    Object localObject2;
    if ((com.tencent.mm.live.core.core.d.isPlaying()) && (i != -1) && (this.hCl == -2301))
    {
      localObject1 = com.tencent.mm.live.core.core.d.hwY;
      com.tencent.mm.live.core.core.d.qq(this.streamType);
      localObject1 = this.hAx;
      if (localObject1 != null)
      {
        localObject2 = e.d.hxF;
        c.a.a((com.tencent.mm.live.core.core.c)localObject1, e.d.aCy());
      }
    }
    Object localObject1 = com.tencent.mm.live.core.core.d.hwY;
    com.tencent.mm.live.core.core.d.aBZ();
    if (paramBundle != null)
    {
      localObject1 = e.j.hyq;
      localObject1 = e.j.aCY();
      localObject2 = this.hAy;
      if (localObject2 == null) {
        break label405;
      }
      localObject2 = ((f)localObject2).hwP;
      if (localObject2 == null) {
        break label405;
      }
    }
    label405:
    for (long l1 = ((e)localObject2).liveId;; l1 = 0L)
    {
      paramBundle.putLong((String)localObject1, l1);
      if (paramBundle != null)
      {
        localObject1 = e.j.hyq;
        localObject1 = e.j.aCZ();
        localObject2 = e.i.hyd;
        paramBundle.putInt((String)localObject1, e.i.aCX());
      }
      if (paramBundle != null)
      {
        localObject1 = e.j.hyq;
        localObject1 = e.j.aDa();
        localObject2 = e.a.hxc;
        paramBundle.putInt((String)localObject1, e.a.aCf());
      }
      if (paramBundle != null)
      {
        localObject1 = e.j.hyq;
        paramBundle.putLong(e.j.aDb(), System.currentTimeMillis());
      }
      if (paramBundle != null)
      {
        localObject1 = e.j.hyq;
        localObject1 = e.j.aDc();
        localObject2 = this.hAy;
        l1 = l2;
        if (localObject2 != null)
        {
          localObject2 = ((f)localObject2).hwP;
          l1 = l2;
          if (localObject2 != null) {
            l1 = ((e)localObject2).startTime;
          }
        }
        paramBundle.putLong((String)localObject1, l1);
      }
      if (paramBundle != null)
      {
        localObject1 = e.j.hyq;
        paramBundle.putInt(e.j.aDi(), NetStatusUtil.getNetType(MMApplicationContext.getContext()));
      }
      if (paramBundle != null)
      {
        localObject1 = e.j.hyq;
        localObject1 = e.j.aDj();
        localObject2 = com.tencent.mm.live.core.d.b.hEQ;
        paramBundle.putString((String)localObject1, com.tencent.mm.live.core.d.b.x(paramBundle));
      }
      localObject1 = this.hAx;
      if (localObject1 == null) {
        break;
      }
      localObject2 = e.d.hxF;
      ((com.tencent.mm.live.core.core.c)localObject1).callback(e.d.aCz(), paramBundle);
      AppMethodBeat.o(196536);
      return;
    }
    AppMethodBeat.o(196536);
  }
  
  public void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(196535);
    Log.i("MicroMsg.LiveCoreVisitor", "onPlayEvent:" + paramInt + ", isPlaying:" + com.tencent.mm.live.core.core.d.isPlaying());
    if (com.tencent.mm.live.core.core.d.isPlaying()) {
      this.hCl = paramInt;
    }
    switch (paramInt)
    {
    default: 
    case 2001: 
    case 2004: 
    case 2103: 
    case -2301: 
      do
      {
        do
        {
          AppMethodBeat.o(196535);
          return;
          a(com.tencent.mm.live.core.mini.d.hCV);
          paramBundle = this.hAx;
          if (paramBundle != null)
          {
            localObject = e.d.hxF;
            c.a.a(paramBundle, e.d.aCA());
            AppMethodBeat.o(196535);
            return;
          }
          AppMethodBeat.o(196535);
          return;
        } while (NetStatusUtil.getNetType(MMApplicationContext.getContext()) != -1);
        paramBundle = this.hAx;
        if (paramBundle != null)
        {
          localObject = e.d.hxF;
          c.a.a(paramBundle, e.d.aCB());
          AppMethodBeat.o(196535);
          return;
        }
        AppMethodBeat.o(196535);
        return;
        com.tencent.mm.live.core.core.d.ev(false);
        if (NetStatusUtil.getNetType(MMApplicationContext.getContext()) == -1)
        {
          paramBundle = this.hAx;
          if (paramBundle != null)
          {
            localObject = e.d.hxF;
            c.a.a(paramBundle, e.d.aCC());
          }
        }
        paramBundle = com.tencent.mm.live.core.core.d.hwY;
      } while (!com.tencent.mm.live.core.core.d.aCc());
      paramBundle = com.tencent.mm.live.core.core.d.hwY;
      com.tencent.mm.live.core.core.d.aCb();
      AppMethodBeat.o(196535);
      return;
    case 2105: 
      paramBundle = com.tencent.mm.live.core.core.d.hwY;
      com.tencent.mm.live.core.core.d.aCa();
      paramBundle = this.hAx;
      if (paramBundle != null)
      {
        localObject = e.d.hxF;
        c.a.a(paramBundle, e.d.aCE());
        AppMethodBeat.o(196535);
        return;
      }
      AppMethodBeat.o(196535);
      return;
    case 2009: 
      localObject = this.hAx;
      if (localObject != null)
      {
        e.d locald = e.d.hxF;
        ((com.tencent.mm.live.core.core.c)localObject).callback(e.d.aCD(), paramBundle);
        AppMethodBeat.o(196535);
        return;
      }
      AppMethodBeat.o(196535);
      return;
    }
    Object localObject = com.tencent.mm.live.core.core.d.hwY;
    if ((com.tencent.mm.live.core.core.d.aCc()) && ((paramInt == 2101) || (paramInt == -2304) || (paramInt == 2108)))
    {
      localObject = com.tencent.mm.live.core.core.d.hwY;
      com.tencent.mm.live.core.core.d.aCb();
    }
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getString("EVT_MSG");; paramBundle = null)
    {
      localObject = com.tencent.mm.live.core.c.b.hEJ;
      localObject = paramBundle;
      if (paramBundle == null) {
        localObject = "";
      }
      com.tencent.mm.live.core.c.b.h("onPlayEvent", paramInt, (String)localObject);
      break;
    }
  }
  
  public final void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    AppMethodBeat.i(196547);
    super.onRemoteUserLeaveRoom(paramString, paramInt);
    AppMethodBeat.o(196547);
  }
  
  public final void release()
  {
    AppMethodBeat.i(196555);
    super.release();
    this.hAk.removeCallbacks((Runnable)this.hCm);
    AppMethodBeat.o(196555);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "TAG", "", "getInstance", "context", "Landroid/content/Context;", "hasInstance", "", "releaseInstance", "", "plugin-core_release"})
  public static final class a
  {
    public static boolean aDp()
    {
      AppMethodBeat.i(196515);
      if (b.aEe() != null)
      {
        AppMethodBeat.o(196515);
        return true;
      }
      AppMethodBeat.o(196515);
      return false;
    }
    
    public static b aEf()
    {
      AppMethodBeat.i(196514);
      if (b.aEe() == null) {
        b.e(new b());
      }
      b localb = b.aEe();
      if (localb == null) {
        p.hyc();
      }
      AppMethodBeat.o(196514);
      return localb;
    }
    
    public static void releaseInstance()
    {
      AppMethodBeat.i(196516);
      b localb = b.aEe();
      if (localb != null) {
        localb.release();
      }
      b.e(null);
      AppMethodBeat.o(196516);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-core_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(196517);
      Object localObject = b.b(this.hCp);
      if (localObject != null)
      {
        com.tencent.mm.live.core.debug.a locala = com.tencent.mm.live.core.debug.a.hCA;
        if (b.c(this.hCp) == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.live.core.core.trtc.WXTRTCCloudImpl");
          AppMethodBeat.o(196517);
          throw ((Throwable)localObject);
        }
        localObject = ((f)localObject).hzu.userId;
        p.g(localObject, "trtcParams.userId");
        com.tencent.mm.live.core.debug.a.GC(String.valueOf(com.tencent.mm.live.core.core.trtc.b.Gq((String)localObject)));
      }
      b.d(this.hCp).removeCallbacks((Runnable)this);
      b.d(this.hCp).postDelayed((Runnable)this, 10000L);
      AppMethodBeat.o(196517);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$floatMode$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-core_release"})
  public static final class c
    implements TextureView.SurfaceTextureListener
  {
    c(h paramh, long paramLong) {}
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(196520);
      Log.i("MicroMsg.LiveCoreVisitor", "float onSurfaceTextureAvailable, surface:" + paramSurfaceTexture + ", size:[" + paramInt1 + ", " + paramInt2 + ']');
      this.hCq.bO(paramSurfaceTexture);
      this.hCq.cX(paramInt1, paramInt2);
      com.tencent.mm.live.core.c.c.qJ((int)Util.ticksToNow(l));
      AppMethodBeat.o(196520);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(196519);
      Log.i("MicroMsg.LiveCoreVisitor", "float onSurfaceTextureDestroyed");
      AppMethodBeat.o(196519);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(196518);
      this.hCq.cX(paramInt1, paramInt2);
      AppMethodBeat.o(196518);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$normalMode$1$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "surface", "plugin-core_release"})
  public static final class d
    implements TextureView.SurfaceTextureListener
  {
    d(h paramh, long paramLong) {}
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(196521);
      p.h(paramSurfaceTexture, "surfaceTexture");
      Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureAvailable, size:[%s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.hCr.bO(new Surface(paramSurfaceTexture));
      this.hCr.cX(paramInt1, paramInt2);
      com.tencent.mm.live.core.c.c.qI((int)Util.ticksToNow(l2));
      AppMethodBeat.o(196521);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(196523);
      p.h(paramSurfaceTexture, "surfaceTexture");
      Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureDestroyed");
      this.hCr.aEG();
      AppMethodBeat.o(196523);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(196522);
      p.h(paramSurfaceTexture, "surfaceTexture");
      Log.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureSizeChanged, size:[%s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.hCr.cX(paramInt1, paramInt2);
      AppMethodBeat.o(196522);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(196524);
      p.h(paramSurfaceTexture, "surface");
      AppMethodBeat.o(196524);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.q<com.tencent.mm.live.core.b.l, Integer, Integer, x>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.q<com.tencent.mm.live.core.b.l, Integer, Integer, x>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "mFps", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, x>
  {
    public static final g hCv;
    
    static
    {
      AppMethodBeat.i(196532);
      hCv = new g();
      AppMethodBeat.o(196532);
    }
    
    g()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "cost", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, x>
  {
    public static final h hCw;
    
    static
    {
      AppMethodBeat.i(196534);
      hCw = new h();
      AppMethodBeat.o(196534);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.d.b
 * JD-Core Version:    0.7.0.1
 */