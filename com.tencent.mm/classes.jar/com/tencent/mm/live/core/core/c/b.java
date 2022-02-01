package com.tencent.mm.live.core.core.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.b.f;
import com.tencent.mm.live.core.b.j;
import com.tencent.mm.live.core.core.b.e.b;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.live.core.core.c.b;
import com.tencent.mm.live.core.core.trtc.a.g;
import com.tencent.mm.live.core.core.trtc.a.h;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import d.g.a.m;
import d.g.a.q;
import d.g.b.k;
import d.g.b.z;
import d.n.n;
import d.v;
import d.y;
import java.util.Arrays;
import java.util.Locale;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/live/core/core/visitor/IMMLiveVisitorCore;", "Lcom/tencent/rtmp/ITXLivePlayListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "debugRunnable", "com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1;", "playerView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "enterRoom", "", "callback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "floatMode", "", "isAudioMicing", "", "isCdnMode", "isInLinkMic", "isVideoMicing", "normalMode", "onCdnPlayerAvailalbe", "liveId", "", "player", "Lcom/tencent/rtmp/TXLivePlayer;", "onEnterRoom", "result", "onNetStatus", "status", "Landroid/os/Bundle;", "onPlayEvent", "event", "param", "onUserExit", "userId", "", "reason", "pauseRender", "refreshByOrientation", "release", "resumeRender", "startLinkMic", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "startPush", "stopLinkMic", "stopPush", "switchAudioLinkMic", "switchVideoLinkMic", "updatePreviewView", "visitRoom", "Companion", "plugin-core_release"})
public final class b
  extends com.tencent.mm.live.core.core.trtc.a
  implements a, ITXLivePlayListener
{
  private static b qOj;
  public static final a qOk;
  private TXCloudVideoView qOh;
  private final b qOi;
  
  static
  {
    AppMethodBeat.i(205697);
    qOk = new a((byte)0);
    AppMethodBeat.o(205697);
  }
  
  public b(Context paramContext)
  {
    super(paramContext, false);
    AppMethodBeat.i(205696);
    this.qOi = new b(this);
    AppMethodBeat.o(205696);
  }
  
  public final void a(long paramLong, TXLivePlayer paramTXLivePlayer, TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(205684);
    this.qOh = paramTXCloudVideoView;
    this.qDS.a(paramLong, paramTXLivePlayer);
    AppMethodBeat.o(205684);
  }
  
  public final void a(com.tencent.mm.live.core.core.b paramb)
  {
    AppMethodBeat.i(205680);
    k.h(paramb, "callback");
    super.a(paramb);
    paramb = com.tencent.mm.live.core.core.trtc.a.a.cpE();
    k.g(paramb, "ConfigHelper.getInstance()");
    paramb = paramb.cpF();
    k.g(paramb, "ConfigHelper.getInstance().videoConfig");
    paramb.kP(false);
    paramb = com.tencent.mm.live.core.core.trtc.a.a.cpE();
    k.g(paramb, "ConfigHelper.getInstance()");
    paramb = paramb.cpP();
    k.g(paramb, "ConfigHelper.getInstance().audioConfig");
    paramb.kd(false);
    AppMethodBeat.o(205680);
  }
  
  public final void a(LivePreviewView paramLivePreviewView, com.tencent.mm.live.core.core.b paramb)
  {
    AppMethodBeat.i(205682);
    k.h(paramb, "callback");
    this.qDY = paramLivePreviewView;
    a(paramb);
    AppMethodBeat.o(205682);
  }
  
  public final void b(LivePreviewView paramLivePreviewView)
  {
    this.qDY = paramLivePreviewView;
  }
  
  public final void bYR()
  {
    AppMethodBeat.i(205690);
    if (this.qDY != null)
    {
      if (!TextUtils.isEmpty((CharSequence)this.qEd.qzR))
      {
        com.tencent.mm.live.core.core.trtc.a.b.c localc = this.qDS;
        String str = this.qEd.qzR;
        Object localObject = this.qDY;
        if (localObject != null) {}
        for (localObject = ((LivePreviewView)localObject).gO(this.qEd.qzR, 0);; localObject = null)
        {
          localc.a(str, (TXCloudVideoView)localObject);
          this.qDS.muteRemoteAudio(this.qEd.qzR, false);
          AppMethodBeat.o(205690);
          return;
        }
      }
    }
    else {
      ad.w("MicroMsg.LiveCoreVisitor", "previewView == null!");
    }
    AppMethodBeat.o(205690);
  }
  
  public final void bYS()
  {
    AppMethodBeat.i(205689);
    this.qDS.aTZ(this.qEd.qzR);
    this.qDS.muteRemoteAudio(this.qEd.qzR, true);
    AppMethodBeat.o(205689);
  }
  
  public final void c(LivePreviewView paramLivePreviewView)
  {
    AppMethodBeat.i(205691);
    Object localObject = this.qDT;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).cqG();
    }
    clI();
    if (paramLivePreviewView == null) {
      ad.e("MicroMsg.LiveCore", "startPreview preiewView is null");
    }
    do
    {
      this.qEd.qzO = e.b.qAY;
      this.qDX.v((d.g.a.b)g.qOG);
      this.qDX.D((d.g.a.b)h.qOH);
      AppMethodBeat.o(205691);
      return;
      this.qDX.czD();
      localObject = com.tencent.mm.live.core.debug.a.qOL;
      com.tencent.mm.live.core.debug.a.aUc("startPreview ".concat(String.valueOf(paramLivePreviewView)));
      this.qDY = paramLivePreviewView;
      localObject = com.tencent.mm.live.core.core.trtc.a.a.cpE();
      k.g(localObject, "ConfigHelper.getInstance()");
      localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).cpP();
      k.g(localObject, "ConfigHelper.getInstance().audioConfig");
      ((com.tencent.mm.live.core.core.trtc.a.a.a)localObject).kd(true);
      localObject = com.tencent.mm.live.core.core.trtc.a.a.cpE();
      k.g(localObject, "ConfigHelper.getInstance()");
      localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).cpF();
      k.g(localObject, "ConfigHelper.getInstance().videoConfig");
      ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).kP(true);
      paramLivePreviewView.c((q)new a.h(this));
      paramLivePreviewView = this.gAz;
    } while ((paramLivePreviewView == null) || (paramLivePreviewView.amv() != true));
    paramLivePreviewView = com.tencent.mm.live.core.core.trtc.a.a.cpE();
    k.g(paramLivePreviewView, "ConfigHelper.getInstance()");
    paramLivePreviewView = paramLivePreviewView.cpV();
    localObject = this.gAz;
    int i;
    if (localObject != null)
    {
      i = ((com.tencent.mm.media.widget.a.e)localObject).amK();
      label226:
      paramLivePreviewView.qGm = i;
      ad.i("MicroMsg.LiveCore", "start preview success");
      localObject = this.qDX;
      paramLivePreviewView = this.gAz;
      if (paramLivePreviewView == null) {
        break label299;
      }
    }
    label299:
    for (paramLivePreviewView = paramLivePreviewView.amG();; paramLivePreviewView = null)
    {
      if (paramLivePreviewView == null) {
        k.fvU();
      }
      ((com.tencent.mm.live.core.b.b)localObject).a(paramLivePreviewView);
      this.qDX.setOnDrawListener((d.g.a.b)new a.g(this));
      break;
      i = 0;
      break label226;
    }
  }
  
  public final int clG()
  {
    AppMethodBeat.i(205693);
    this.qDj.enableCustomVideoCapture(false);
    this.qEg = false;
    AppMethodBeat.o(205693);
    return 0;
  }
  
  public final int clI()
  {
    AppMethodBeat.i(205694);
    this.qDj.enableCustomVideoCapture(true);
    this.qEg = true;
    AppMethodBeat.o(205694);
    return 0;
  }
  
  public final void clo()
  {
    AppMethodBeat.i(205679);
    if (!this.qEd.qzP)
    {
      AppMethodBeat.o(205679);
      return;
    }
    final long l2 = bt.GC();
    this.qEd.qzP = false;
    Object localObject1;
    Object localObject2;
    if (this.qOh != null)
    {
      localObject1 = this.qDS;
      localObject2 = this.qEc;
      if (localObject2 == null) {
        break label247;
      }
      localObject2 = ((com.tencent.mm.live.core.core.b.d)localObject2).qzr;
      if (localObject2 == null) {
        break label247;
      }
    }
    label247:
    for (long l1 = ((com.tencent.mm.live.core.core.b.c)localObject2).DlB;; l1 = 0L)
    {
      ((com.tencent.mm.live.core.core.trtc.a.b.c)localObject1).Bb(l1).setPlayerView(this.qOh);
      localObject1 = this.qDS.aUb(this.qEd.qzR);
      if (localObject1 != null)
      {
        ad.i("MicroMsg.LiveCoreVisitor", "normalMode, find renderSurface for userId:" + this.qEd.qzR);
        localObject2 = gN(((f)localObject1).userId, ((f)localObject1).streamType);
        if (localObject2 != null)
        {
          TextureView localTextureView = new TextureView(((TXCloudVideoView)localObject2).getContext());
          ((TXCloudVideoView)localObject2).addVideoView(localTextureView);
          localTextureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new d((f)localObject1, l2));
        }
      }
      if (this.qEd.cnw())
      {
        localObject1 = this.qDY;
        if (localObject1 != null) {
          ((LivePreviewView)localObject1).c((q)new e(this));
        }
      }
      super.clo();
      AppMethodBeat.o(205679);
      return;
    }
  }
  
  public final boolean col()
  {
    AppMethodBeat.i(205686);
    com.tencent.mm.live.core.core.trtc.a.c localc = this.qDT;
    if ((localc == null) || (localc.cro() != 21))
    {
      AppMethodBeat.o(205686);
      return true;
    }
    AppMethodBeat.o(205686);
    return false;
  }
  
  public final void csi()
  {
    Object localObject2 = null;
    AppMethodBeat.i(205683);
    com.tencent.mm.live.core.core.trtc.a.b.c localc;
    String str;
    if (!TextUtils.isEmpty((CharSequence)this.qEd.qzR))
    {
      localc = this.qDS;
      str = this.qEd.qzR;
      localObject1 = this.qDY;
      if (localObject1 == null) {
        break label202;
      }
    }
    label202:
    for (Object localObject1 = ((LivePreviewView)localObject1).gO(this.qEd.qzR, 0);; localObject1 = null)
    {
      localc.a(str, (TXCloudVideoView)localObject1);
      this.qDS.muteRemoteAudio(this.qEd.qzR, false);
      if (!TextUtils.isEmpty((CharSequence)this.qEd.qAd))
      {
        localc = this.qDS;
        str = this.qEd.qAd;
        LivePreviewView localLivePreviewView = this.qDY;
        localObject1 = localObject2;
        if (localLivePreviewView != null) {
          localObject1 = localLivePreviewView.gO(this.qEd.qAd, 0);
        }
        localc.a(str, (TXCloudVideoView)localObject1);
        this.qDS.muteRemoteAudio(this.qEd.qzR, false);
      }
      if (!this.qEd.cnw()) {
        break;
      }
      localObject1 = this.qDY;
      if (localObject1 == null) {
        break;
      }
      ((LivePreviewView)localObject1).c((q)new f(this));
      AppMethodBeat.o(205683);
      return;
    }
    AppMethodBeat.o(205683);
  }
  
  public final int csk()
  {
    AppMethodBeat.i(205685);
    this.qEd.qzO = e.b.qAX;
    Object localObject = com.tencent.mm.live.core.debug.a.qOL;
    com.tencent.mm.live.core.debug.a.bZ("MicroMsg.LiveCoreMic", "[sdk]start link mic");
    localObject = this.qDT;
    if ((localObject != null) && (((com.tencent.mm.live.core.core.trtc.a.c)localObject).cro() == 20))
    {
      AppMethodBeat.o(205685);
      return 0;
    }
    localObject = com.tencent.mm.live.core.core.trtc.a.a.cpE();
    k.g(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).cpP();
    k.g(localObject, "ConfigHelper.getInstance().audioConfig");
    ((com.tencent.mm.live.core.core.trtc.a.a.a)localObject).kd(true);
    localObject = this.qDT;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).cqG();
    }
    localObject = this.qDT;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).crn();
    }
    localObject = this.qDT;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).startLocalAudio();
    }
    AppMethodBeat.o(205685);
    return 0;
  }
  
  public final int csn()
  {
    AppMethodBeat.i(205687);
    this.qEd.qzO = e.b.qAR;
    Object localObject = com.tencent.mm.live.core.debug.a.qOL;
    com.tencent.mm.live.core.debug.a.bZ("MicroMsg.LiveCoreMic", "[sdk]stop link mic");
    localObject = this.qDT;
    if ((localObject != null) && (((com.tencent.mm.live.core.core.trtc.a.c)localObject).cro() == 21))
    {
      AppMethodBeat.o(205687);
      return 0;
    }
    localObject = com.tencent.mm.live.core.core.trtc.a.a.cpE();
    k.g(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).cpP();
    k.g(localObject, "ConfigHelper.getInstance().audioConfig");
    ((com.tencent.mm.live.core.core.trtc.a.a.a)localObject).kd(false);
    localObject = com.tencent.mm.live.core.core.trtc.a.a.cpE();
    k.g(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).cpF();
    k.g(localObject, "ConfigHelper.getInstance().videoConfig");
    ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).kP(false);
    localObject = this.qDT;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).crn();
    }
    localObject = this.qDT;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).stopLocalAudio();
    }
    clf();
    AppMethodBeat.o(205687);
    return 0;
  }
  
  public final void csq()
  {
    AppMethodBeat.i(205692);
    clG();
    clf();
    this.qEd.qzO = e.b.qAX;
    AppMethodBeat.o(205692);
  }
  
  public final int eE(Context paramContext)
  {
    int j = 0;
    AppMethodBeat.i(205678);
    k.h(paramContext, "context");
    if (this.qEd.qzP)
    {
      AppMethodBeat.o(205678);
      return 0;
    }
    final long l = bt.GC();
    this.qEd.qzP = true;
    int i;
    if ((!this.qEd.cnw()) && (!this.qEd.cnx()))
    {
      localObject1 = this.qEc;
      i = j;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.b.d)localObject1).qzr;
        i = j;
        if (localObject1 != null)
        {
          int k = ((com.tencent.mm.live.core.core.b.c)localObject1).qzb;
          localObject1 = c.a.qxl;
          i = j;
          if (k == c.a.clO()) {
            i = 1;
          }
        }
      }
      if (i != 0) {}
    }
    else
    {
      localObject1 = this.qDS.aUb(this.qEd.qzR);
      if (localObject1 != null)
      {
        localObject2 = gN(((f)localObject1).userId, ((f)localObject1).streamType);
        if (localObject2 != null) {
          ((TXCloudVideoView)localObject2).removeVideoView();
        }
        ad.i("MicroMsg.LiveCoreVisitor", "enter float mode");
        ((f)localObject1).cAi();
        localObject2 = new SurfaceView(aj.getContext());
        ((SurfaceView)localObject2).getHolder().addCallback((SurfaceHolder.Callback)new c((f)localObject1, l));
        this.qDW.cV((View)localObject2);
      }
      i = super.eE(paramContext);
      AppMethodBeat.o(205678);
      return i;
    }
    Object localObject1 = this.qDS;
    Object localObject2 = this.qEc;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.live.core.core.b.d)localObject2).qzr;
      if (localObject2 == null) {}
    }
    for (l = ((com.tencent.mm.live.core.core.b.c)localObject2).DlB;; l = 0L)
    {
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a.b.c)localObject1).Bb(l);
      localObject2 = new TXCloudVideoView(aj.getContext());
      this.qDW.cV((View)localObject2);
      ((TXLivePlayer)localObject1).setPlayerView((TXCloudVideoView)localObject2);
      break;
    }
  }
  
  public final void onEnterRoom(long paramLong)
  {
    AppMethodBeat.i(205681);
    super.onEnterRoom(paramLong);
    this.gAC.post((Runnable)this.qOi);
    AppMethodBeat.o(205681);
  }
  
  public final void onNetStatus(Bundle paramBundle) {}
  
  public final void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(205677);
    ad.i("MicroMsg.LiveCoreVisitor", "onPlayEvent ".concat(String.valueOf(paramInt)));
    paramBundle = com.tencent.mm.live.core.debug.a.qOL;
    com.tencent.mm.live.core.debug.a.aUc("onPlayEvent ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(205677);
  }
  
  public final void onUserExit(String paramString, int paramInt)
  {
    AppMethodBeat.i(205688);
    super.onUserExit(paramString, paramInt);
    if ((!bt.isNullOrNil(this.qEd.qzR)) && (k.g(this.qEd.qzR, paramString)))
    {
      ad.i("MicroMsg.LiveCoreVisitor", "anchor exit, userId:" + this.qEd.qzR);
      paramString = this.qEb;
      if (paramString != null)
      {
        c.b localb = c.b.qye;
        com.tencent.mm.live.core.core.b.a.a(paramString, c.b.clR());
        AppMethodBeat.o(205688);
        return;
      }
    }
    AppMethodBeat.o(205688);
  }
  
  public final void release()
  {
    AppMethodBeat.i(205695);
    super.release();
    this.gAC.removeCallbacks((Runnable)this.qOi);
    AppMethodBeat.o(205695);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "TAG", "", "getInstance", "context", "Landroid/content/Context;", "hasInstance", "", "releaseInstance", "", "plugin-core_release"})
  public static final class a
  {
    public static boolean cnr()
    {
      AppMethodBeat.i(205661);
      if (b.css() != null)
      {
        AppMethodBeat.o(205661);
        return true;
      }
      AppMethodBeat.o(205661);
      return false;
    }
    
    public static b eH(Context paramContext)
    {
      AppMethodBeat.i(205660);
      k.h(paramContext, "context");
      if (b.css() == null) {
        b.e(new b(paramContext));
      }
      paramContext = b.css();
      if (paramContext == null) {
        k.fvU();
      }
      AppMethodBeat.o(205660);
      return paramContext;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-core_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(205662);
      Object localObject1 = b.b(this.qOl);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.live.core.debug.a.qOL;
        localObject2 = b.c(this.qOl);
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.live.core.core.trtc.WXTRTCCloudImpl");
          AppMethodBeat.o(205662);
          throw ((Throwable)localObject1);
        }
        localObject2 = (com.tencent.mm.live.core.core.trtc.b)localObject2;
        Object localObject3 = ((com.tencent.mm.live.core.core.b.d)localObject1).qzq.userId;
        k.g(localObject3, "trtcParams.userId");
        k.h(localObject3, "sdkuid");
        localObject1 = ((com.tencent.mm.live.core.core.trtc.b)localObject2).mRoomInfo.getUser((String)localObject3);
        if (localObject1 == null) {
          break label1075;
        }
        localObject1 = String.valueOf(((TRTCRoomInfo.UserInfo)localObject1).tinyID);
        localObject2 = com.tencent.liteav.basic.util.d.a();
        long l = TXCStatus.a((String)localObject1, 17014, 0);
        int i = TXCStatus.c((String)localObject1, 5003, 0);
        Object localObject4 = new StringBuilder();
        z localz = z.Jhz;
        localObject3 = String.format("REMOTE: [%s]%s RTT:%dms\n", Arrays.copyOf(new Object[] { localObject3, "B", Integer.valueOf(TXCStatus.c("18446744073709551615", 12002)) }, 3));
        k.g(localObject3, "java.lang.String.format(format, *args)");
        localObject3 = ((StringBuilder)localObject4).append((String)localObject3);
        localObject4 = z.Jhz;
        localObject4 = Locale.CHINA;
        k.g(localObject4, "Locale.CHINA");
        localObject4 = String.format((Locale)localObject4, "RECV:%dkbps LOSS:%d-%d-%d%%|%d-%d-%d%%|%d%%\n", Arrays.copyOf(new Object[] { Integer.valueOf(TXCStatus.c((String)localObject1, 17001, 0) + TXCStatus.c((String)localObject1, 18001)), Integer.valueOf(TXCStatus.c((String)localObject1, 17010, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 17005, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 17011, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 18013)), Integer.valueOf(TXCStatus.c((String)localObject1, 18007)), Integer.valueOf(TXCStatus.c((String)localObject1, 18014)), Integer.valueOf(TXCStatus.c((String)localObject1, 16002)) }, 8));
        k.g(localObject4, "java.lang.String.format(locale, format, *args)");
        localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
        localObject4 = z.Jhz;
        localObject4 = Locale.CHINA;
        k.g(localObject4, "Locale.CHINA");
        localObject4 = String.format((Locale)localObject4, "BIT:%d|%dkbps RES:%dx%d FPS:%d-%d\n", Arrays.copyOf(new Object[] { Integer.valueOf(TXCStatus.c((String)localObject1, 17002, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 18002)), Integer.valueOf(i >> 16), Integer.valueOf(i & 0xFFFF), Integer.valueOf((int)TXCStatus.d((String)localObject1, 6002, 0)), Integer.valueOf((int)TXCStatus.d((String)localObject1, 17003, 0)) }, 6));
        k.g(localObject4, "java.lang.String.format(locale, format, *args)");
        localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
        localObject4 = z.Jhz;
        localObject4 = Locale.CHINA;
        k.g(localObject4, "Locale.CHINA");
        localObject4 = String.format((Locale)localObject4, "FEC:%d-%d-%d%%|%d-%d-%d%%    ARQ:%d-%d|%d-%d\n", Arrays.copyOf(new Object[] { Integer.valueOf(TXCStatus.c((String)localObject1, 17007, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 17005, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 17006, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 18009)), Integer.valueOf(TXCStatus.c((String)localObject1, 18007)), Integer.valueOf(TXCStatus.c((String)localObject1, 18008)), Integer.valueOf(TXCStatus.c((String)localObject1, 17009, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 17008, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 18012)), Integer.valueOf(TXCStatus.c((String)localObject1, 18010)) }, 10));
        k.g(localObject4, "java.lang.String.format(locale, format, *args)");
        localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
        localObject4 = z.Jhz;
        localObject4 = Locale.CHINA;
        k.g(localObject4, "Locale.CHINA");
        localObject2 = String.format((Locale)localObject4, "CPU:%d%%|%d%%  RPS:%d  LFR:%d  DERR:%d\n", Arrays.copyOf(new Object[] { Integer.valueOf(localObject2[0] / 10), Integer.valueOf(localObject2[1] / 10), Integer.valueOf(TXCStatus.c((String)localObject1, 17012, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 17013, 0)), Long.valueOf(l) }, 5));
        k.g(localObject2, "java.lang.String.format(locale, format, *args)");
        localObject2 = ((StringBuilder)localObject3).append((String)localObject2);
        localObject3 = z.Jhz;
        localObject3 = Locale.CHINA;
        k.g(localObject3, "Locale.CHINA");
        localObject1 = String.format((Locale)localObject3, "Jitter: %d,%d|%d,%d|%d\n", Arrays.copyOf(new Object[] { Integer.valueOf(TXCStatus.c((String)localObject1, 2007)), Integer.valueOf(TXCStatus.c((String)localObject1, 6010, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 6011, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 6012, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 18015)) }, 5));
        k.g(localObject1, "java.lang.String.format(locale, format, *args)");
        localObject1 = (String)localObject1;
        localObject2 = new SpannableString((CharSequence)localObject1);
        i = n.e((CharSequence)localObject1, "DECERR:");
        if ((-1 != i) && (l > 0L)) {
          ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(-65536), i + 7, ((String)localObject1).length(), 33);
        }
      }
      label1075:
      for (localObject1 = (CharSequence)localObject2;; localObject1 = null)
      {
        com.tencent.mm.live.core.debug.a.aUe(String.valueOf(localObject1));
        b.d(this.qOl).removeCallbacks((Runnable)this);
        b.d(this.qOl).postDelayed((Runnable)this, 10000L);
        AppMethodBeat.o(205662);
        return;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$floatMode$1", "Landroid/view/SurfaceHolder$Callback;", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "plugin-core_release"})
  public static final class c
    implements SurfaceHolder.Callback
  {
    c(f paramf, long paramLong) {}
    
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(205663);
      ad.i("MicroMsg.LiveCoreVisitor", "float surfaceChange, holder:" + paramSurfaceHolder + ", size:[" + paramInt2 + ", " + paramInt3 + ']');
      f localf = this.qOm;
      if (paramSurfaceHolder != null) {}
      for (paramSurfaceHolder = paramSurfaceHolder.getSurface();; paramSurfaceHolder = null)
      {
        localf.gc(paramSurfaceHolder);
        this.qOm.cR(paramInt2, paramInt3);
        com.tencent.mm.live.core.c.b.WG((int)bt.aS(l));
        AppMethodBeat.o(205663);
        return;
      }
    }
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder) {}
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(205664);
      ad.i("MicroMsg.LiveCoreVisitor", "float surface destroy");
      AppMethodBeat.o(205664);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$normalMode$1$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "surface", "plugin-core_release"})
  public static final class d
    implements TextureView.SurfaceTextureListener
  {
    d(f paramf, long paramLong) {}
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205665);
      k.h(paramSurfaceTexture, "surfaceTexture");
      ad.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureAvailable, size:[%s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.qOn.gc(new Surface(paramSurfaceTexture));
      this.qOn.cR(paramInt1, paramInt2);
      com.tencent.mm.live.core.c.b.UO((int)bt.aS(l2));
      AppMethodBeat.o(205665);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(205667);
      k.h(paramSurfaceTexture, "surfaceTexture");
      ad.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureDestroyed");
      this.qOn.cAi();
      AppMethodBeat.o(205667);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(205666);
      k.h(paramSurfaceTexture, "surfaceTexture");
      ad.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureSizeChanged, size:[%s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.qOn.cR(paramInt1, paramInt2);
      AppMethodBeat.o(205666);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(205668);
      k.h(paramSurfaceTexture, "surface");
      AppMethodBeat.o(205668);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  static final class e
    extends d.g.b.l
    implements q<j, Integer, Integer, y>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  static final class f
    extends d.g.b.l
    implements q<j, Integer, Integer, y>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "mFps", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<Integer, y>
  {
    public static final g qOG;
    
    static
    {
      AppMethodBeat.i(205674);
      qOG = new g();
      AppMethodBeat.o(205674);
    }
    
    g()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "cost", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.b<Integer, y>
  {
    public static final h qOH;
    
    static
    {
      AppMethodBeat.i(205676);
      qOH = new h();
      AppMethodBeat.o(205676);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.c.b
 * JD-Core Version:    0.7.0.1
 */