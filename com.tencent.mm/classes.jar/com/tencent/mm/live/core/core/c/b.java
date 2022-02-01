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
import com.tencent.mm.live.core.core.b.e.d;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.live.core.core.trtc.a.g;
import com.tencent.mm.live.core.core.trtc.a.h;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/live/core/core/visitor/IMMLiveVisitorCore;", "Lcom/tencent/rtmp/ITXLivePlayListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "debugRunnable", "com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1;", "playerView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "enterRoom", "", "callback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "floatMode", "", "isAudioMicing", "", "isCdnMode", "isInLinkMic", "isVideoMicing", "normalMode", "onCdnPlayerAvailalbe", "liveId", "", "player", "Lcom/tencent/rtmp/TXLivePlayer;", "onEnterRoom", "result", "onNetStatus", "status", "Landroid/os/Bundle;", "onPlayEvent", "event", "param", "onRemoteUserLeaveRoom", "userId", "", "reason", "pauseRender", "refreshByOrientation", "release", "resumeRender", "startLinkMic", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "startPush", "stopLinkMic", "stopPush", "switchAudioLinkMic", "switchVideoLinkMic", "updatePreviewView", "visitRoom", "Companion", "plugin-core_release"})
public final class b
  extends com.tencent.mm.live.core.core.trtc.a
  implements a, ITXLivePlayListener
{
  private static b gqs;
  public static final b.a gqt;
  private TXCloudVideoView gqq;
  private final b gqr;
  
  static
  {
    AppMethodBeat.i(209233);
    gqt = new b.a((byte)0);
    AppMethodBeat.o(209233);
  }
  
  public b(Context paramContext)
  {
    super(paramContext, false);
    AppMethodBeat.i(209232);
    this.gqr = new b(this);
    AppMethodBeat.o(209232);
  }
  
  public final void a(long paramLong, TXLivePlayer paramTXLivePlayer, TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(209220);
    this.gqq = paramTXCloudVideoView;
    this.goz.a(paramLong, paramTXLivePlayer);
    AppMethodBeat.o(209220);
  }
  
  public final void a(com.tencent.mm.live.core.core.b paramb)
  {
    AppMethodBeat.i(209216);
    k.h(paramb, "callback");
    super.a(paramb);
    paramb = com.tencent.mm.live.core.core.trtc.a.a.aiX();
    k.g(paramb, "ConfigHelper.getInstance()");
    paramb = paramb.aiY();
    k.g(paramb, "ConfigHelper.getInstance().videoConfig");
    paramb.dH(false);
    paramb = com.tencent.mm.live.core.core.trtc.a.a.aiX();
    k.g(paramb, "ConfigHelper.getInstance()");
    paramb = paramb.aiZ();
    k.g(paramb, "ConfigHelper.getInstance().audioConfig");
    paramb.dE(false);
    AppMethodBeat.o(209216);
  }
  
  public final void a(LivePreviewView paramLivePreviewView, com.tencent.mm.live.core.core.b paramb)
  {
    AppMethodBeat.i(209218);
    k.h(paramb, "callback");
    this.goF = paramLivePreviewView;
    a(paramb);
    AppMethodBeat.o(209218);
  }
  
  public final boolean aiU()
  {
    AppMethodBeat.i(209222);
    com.tencent.mm.live.core.core.trtc.a.c localc = this.goA;
    if ((localc == null) || (localc.ajk() != 21))
    {
      AppMethodBeat.o(209222);
      return true;
    }
    AppMethodBeat.o(209222);
    return false;
  }
  
  public final void ais()
  {
    AppMethodBeat.i(209215);
    if (!this.goL.isFloatMode())
    {
      AppMethodBeat.o(209215);
      return;
    }
    final long l2 = bs.Gn();
    this.goL.goc = e.d.got;
    Object localObject1;
    Object localObject2;
    if (this.gqq != null)
    {
      localObject1 = this.goz;
      localObject2 = this.goK;
      if (localObject2 == null) {
        break label247;
      }
      localObject2 = ((com.tencent.mm.live.core.core.b.d)localObject2).gnU;
      if (localObject2 == null) {
        break label247;
      }
    }
    label247:
    for (long l1 = ((com.tencent.mm.live.core.core.b.c)localObject2).gmP;; l1 = 0L)
    {
      ((com.tencent.mm.live.core.core.trtc.a.b.c)localObject1).pd(l1).setPlayerView(this.gqq);
      localObject1 = this.goz.uE(this.goL.goe);
      if (localObject1 != null)
      {
        ac.i("MicroMsg.LiveCoreVisitor", "normalMode, find renderSurface for userId:" + this.goL.goe);
        localObject2 = Q(((f)localObject1).userId, ((f)localObject1).streamType);
        if (localObject2 != null)
        {
          TextureView localTextureView = new TextureView(((TXCloudVideoView)localObject2).getContext());
          ((TXCloudVideoView)localObject2).addVideoView(localTextureView);
          localTextureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new d((f)localObject1, l2));
        }
      }
      if (this.goL.aiS())
      {
        localObject1 = this.goF;
        if (localObject1 != null) {
          ((LivePreviewView)localObject1).a((q)new e(this));
        }
      }
      super.ais();
      AppMethodBeat.o(209215);
      return;
    }
  }
  
  public final int aiw()
  {
    AppMethodBeat.i(209229);
    this.goE.d(null);
    this.goy.enableCustomVideoCapture(false);
    this.goM = false;
    AppMethodBeat.o(209229);
    return 0;
  }
  
  public final int aix()
  {
    AppMethodBeat.i(209230);
    this.goE.d((d.g.a.b)g.gqA);
    this.goy.enableCustomVideoCapture(true);
    this.goM = true;
    AppMethodBeat.o(209230);
    return 0;
  }
  
  public final void ajq()
  {
    Object localObject2 = null;
    AppMethodBeat.i(209219);
    com.tencent.mm.live.core.core.trtc.a.b.c localc;
    String str;
    if (!TextUtils.isEmpty((CharSequence)this.goL.goe))
    {
      localc = this.goz;
      str = this.goL.goe;
      localObject1 = this.goF;
      if (localObject1 == null) {
        break label202;
      }
    }
    label202:
    for (Object localObject1 = ((LivePreviewView)localObject1).R(this.goL.goe, 0);; localObject1 = null)
    {
      localc.a(str, (TXCloudVideoView)localObject1);
      this.goz.muteRemoteAudio(this.goL.goe, false);
      if (!TextUtils.isEmpty((CharSequence)this.goL.gof))
      {
        localc = this.goz;
        str = this.goL.gof;
        LivePreviewView localLivePreviewView = this.goF;
        localObject1 = localObject2;
        if (localLivePreviewView != null) {
          localObject1 = localLivePreviewView.R(this.goL.gof, 0);
        }
        localc.a(str, (TXCloudVideoView)localObject1);
        this.goz.muteRemoteAudio(this.goL.goe, false);
      }
      if (!this.goL.aiS()) {
        break;
      }
      localObject1 = this.goF;
      if (localObject1 == null) {
        break;
      }
      ((LivePreviewView)localObject1).a((q)new f(this));
      AppMethodBeat.o(209219);
      return;
    }
    AppMethodBeat.o(209219);
  }
  
  public final int ajr()
  {
    AppMethodBeat.i(209221);
    this.goL.gob = e.b.gol;
    Object localObject = com.tencent.mm.live.core.debug.a.gqF;
    com.tencent.mm.live.core.debug.a.aq("MicroMsg.LiveCoreMic", "[sdk]start link mic");
    localObject = this.goA;
    if ((localObject != null) && (((com.tencent.mm.live.core.core.trtc.a.c)localObject).ajk() == 20))
    {
      AppMethodBeat.o(209221);
      return 0;
    }
    localObject = com.tencent.mm.live.core.core.trtc.a.a.aiX();
    k.g(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aiZ();
    k.g(localObject, "ConfigHelper.getInstance().audioConfig");
    ((com.tencent.mm.live.core.core.trtc.a.a.a)localObject).dE(true);
    localObject = this.goA;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).ajf();
    }
    localObject = this.goA;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).ajj();
    }
    localObject = this.goA;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).startLocalAudio();
    }
    AppMethodBeat.o(209221);
    return 0;
  }
  
  public final int ajs()
  {
    AppMethodBeat.i(209223);
    this.goL.gob = e.b.gok;
    Object localObject = com.tencent.mm.live.core.debug.a.gqF;
    com.tencent.mm.live.core.debug.a.aq("MicroMsg.LiveCoreMic", "[sdk]stop link mic");
    localObject = this.goA;
    if ((localObject != null) && (((com.tencent.mm.live.core.core.trtc.a.c)localObject).ajk() == 21))
    {
      AppMethodBeat.o(209223);
      return 0;
    }
    localObject = com.tencent.mm.live.core.core.trtc.a.a.aiX();
    k.g(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aiZ();
    k.g(localObject, "ConfigHelper.getInstance().audioConfig");
    ((com.tencent.mm.live.core.core.trtc.a.a.a)localObject).dE(false);
    localObject = com.tencent.mm.live.core.core.trtc.a.a.aiX();
    k.g(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aiY();
    k.g(localObject, "ConfigHelper.getInstance().videoConfig");
    ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).dH(false);
    localObject = this.goA;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).ajj();
    }
    localObject = this.goA;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).stopLocalAudio();
    }
    aiq();
    AppMethodBeat.o(209223);
    return 0;
  }
  
  public final void ajt()
  {
    AppMethodBeat.i(209225);
    this.goz.uB(this.goL.goe);
    this.goz.muteRemoteAudio(this.goL.goe, true);
    AppMethodBeat.o(209225);
  }
  
  public final void aju()
  {
    AppMethodBeat.i(209226);
    if (this.goF != null)
    {
      if (!TextUtils.isEmpty((CharSequence)this.goL.goe))
      {
        com.tencent.mm.live.core.core.trtc.a.b.c localc = this.goz;
        String str = this.goL.goe;
        Object localObject = this.goF;
        if (localObject != null) {}
        for (localObject = ((LivePreviewView)localObject).R(this.goL.goe, 0);; localObject = null)
        {
          localc.a(str, (TXCloudVideoView)localObject);
          this.goz.muteRemoteAudio(this.goL.goe, false);
          AppMethodBeat.o(209226);
          return;
        }
      }
    }
    else {
      ac.w("MicroMsg.LiveCoreVisitor", "previewView == null!");
    }
    AppMethodBeat.o(209226);
  }
  
  public final void ajv()
  {
    AppMethodBeat.i(209228);
    aiw();
    aiq();
    this.goL.gob = e.b.gol;
    AppMethodBeat.o(209228);
  }
  
  public final void b(LivePreviewView paramLivePreviewView)
  {
    this.goF = paramLivePreviewView;
  }
  
  public final void c(LivePreviewView paramLivePreviewView)
  {
    AppMethodBeat.i(209227);
    Object localObject = this.goA;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).ajf();
    }
    aix();
    if (paramLivePreviewView == null) {
      ac.e("MicroMsg.LiveCore", "startPreview preiewView is null");
    }
    do
    {
      this.goL.gob = e.b.gom;
      this.goE.e((d.g.a.b)h.gqB);
      AppMethodBeat.o(209227);
      return;
      this.goE.ajC();
      localObject = com.tencent.mm.live.core.debug.a.gqF;
      com.tencent.mm.live.core.debug.a.uG("startPreview ".concat(String.valueOf(paramLivePreviewView)));
      this.goF = paramLivePreviewView;
      localObject = com.tencent.mm.live.core.core.trtc.a.a.aiX();
      k.g(localObject, "ConfigHelper.getInstance()");
      localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aiZ();
      k.g(localObject, "ConfigHelper.getInstance().audioConfig");
      ((com.tencent.mm.live.core.core.trtc.a.a.a)localObject).dE(true);
      localObject = com.tencent.mm.live.core.core.trtc.a.a.aiX();
      k.g(localObject, "ConfigHelper.getInstance()");
      localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).aiY();
      k.g(localObject, "ConfigHelper.getInstance().videoConfig");
      ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).dH(true);
      paramLivePreviewView.a((q)new a.h(this));
      paramLivePreviewView = this.goG;
    } while ((paramLivePreviewView == null) || (paramLivePreviewView.atn() != true));
    paramLivePreviewView = com.tencent.mm.live.core.core.trtc.a.a.aiX();
    k.g(paramLivePreviewView, "ConfigHelper.getInstance()");
    paramLivePreviewView = paramLivePreviewView.ajb();
    localObject = this.goG;
    int i;
    if (localObject != null)
    {
      i = ((com.tencent.mm.media.widget.a.e)localObject).atC();
      label213:
      paramLivePreviewView.gpy = i;
      ac.i("MicroMsg.LiveCore", "start preview success");
      localObject = this.goE;
      paramLivePreviewView = this.goG;
      if (paramLivePreviewView == null) {
        break label286;
      }
    }
    label286:
    for (paramLivePreviewView = paramLivePreviewView.aty();; paramLivePreviewView = null)
    {
      if (paramLivePreviewView == null) {
        k.fOy();
      }
      ((com.tencent.mm.live.core.b.b)localObject).a(paramLivePreviewView);
      this.goE.setOnDrawListener((d.g.a.b)new a.g(this));
      break;
      i = 0;
      break label213;
    }
  }
  
  public final int cs(Context paramContext)
  {
    int j = 0;
    AppMethodBeat.i(209214);
    k.h(paramContext, "context");
    if (this.goL.isFloatMode())
    {
      AppMethodBeat.o(209214);
      return 0;
    }
    final long l = bs.Gn();
    this.goL.goc = e.d.gou;
    int i;
    if ((!this.goL.aiS()) && (!this.goL.aiT()))
    {
      localObject1 = this.goK;
      i = j;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.b.d)localObject1).gnU;
        i = j;
        if (localObject1 != null)
        {
          int k = ((com.tencent.mm.live.core.core.b.c)localObject1).gnP;
          localObject1 = c.a.gnl;
          i = j;
          if (k == c.a.aiz()) {
            i = 1;
          }
        }
      }
      if (i != 0) {}
    }
    else
    {
      localObject1 = this.goz.uE(this.goL.goe);
      if (localObject1 != null)
      {
        localObject2 = Q(((f)localObject1).userId, ((f)localObject1).streamType);
        if (localObject2 != null) {
          ((TXCloudVideoView)localObject2).removeVideoView();
        }
        ac.i("MicroMsg.LiveCoreVisitor", "enter float mode");
        ((f)localObject1).ajJ();
        localObject2 = new SurfaceView(ai.getContext());
        ((SurfaceView)localObject2).getHolder().addCallback((SurfaceHolder.Callback)new c((f)localObject1, l));
        this.goD.cw((View)localObject2);
      }
      i = super.cs(paramContext);
      AppMethodBeat.o(209214);
      return i;
    }
    Object localObject1 = this.goz;
    Object localObject2 = this.goK;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.live.core.core.b.d)localObject2).gnU;
      if (localObject2 == null) {}
    }
    for (l = ((com.tencent.mm.live.core.core.b.c)localObject2).gmP;; l = 0L)
    {
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a.b.c)localObject1).pd(l);
      localObject2 = new TXCloudVideoView(ai.getContext());
      this.goD.cw((View)localObject2);
      ((TXLivePlayer)localObject1).setPlayerView((TXCloudVideoView)localObject2);
      break;
    }
  }
  
  public final void onEnterRoom(long paramLong)
  {
    AppMethodBeat.i(209217);
    super.onEnterRoom(paramLong);
    this.gox.post((Runnable)this.gqr);
    AppMethodBeat.o(209217);
  }
  
  public final void onNetStatus(Bundle paramBundle) {}
  
  public final void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(209213);
    ac.i("MicroMsg.LiveCoreVisitor", "onPlayEvent ".concat(String.valueOf(paramInt)));
    paramBundle = com.tencent.mm.live.core.debug.a.gqF;
    com.tencent.mm.live.core.debug.a.uG("onPlayEvent ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(209213);
  }
  
  public final void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    AppMethodBeat.i(209224);
    super.onRemoteUserLeaveRoom(paramString, paramInt);
    AppMethodBeat.o(209224);
  }
  
  public final void release()
  {
    AppMethodBeat.i(209231);
    super.release();
    this.gox.removeCallbacks((Runnable)this.gqr);
    AppMethodBeat.o(209231);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-core_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(209198);
      Object localObject1 = b.b(this.gqu);
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.live.core.debug.a.gqF;
        localObject2 = b.c(this.gqu);
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.live.core.core.trtc.WXTRTCCloudImpl");
          AppMethodBeat.o(209198);
          throw ((Throwable)localObject1);
        }
        localObject2 = (com.tencent.mm.live.core.core.trtc.b)localObject2;
        Object localObject3 = ((com.tencent.mm.live.core.core.b.d)localObject1).gnT.userId;
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
        z localz = z.KUT;
        localObject3 = String.format("REMOTE: [%s]%s RTT:%dms\n", Arrays.copyOf(new Object[] { localObject3, "B", Integer.valueOf(TXCStatus.c("18446744073709551615", 12002)) }, 3));
        k.g(localObject3, "java.lang.String.format(format, *args)");
        localObject3 = ((StringBuilder)localObject4).append((String)localObject3);
        localObject4 = z.KUT;
        localObject4 = Locale.CHINA;
        k.g(localObject4, "Locale.CHINA");
        localObject4 = String.format((Locale)localObject4, "RECV:%dkbps LOSS:%d-%d-%d%%|%d-%d-%d%%|%d%%\n", Arrays.copyOf(new Object[] { Integer.valueOf(TXCStatus.c((String)localObject1, 17001, 0) + TXCStatus.c((String)localObject1, 18001)), Integer.valueOf(TXCStatus.c((String)localObject1, 17010, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 17005, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 17011, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 18013)), Integer.valueOf(TXCStatus.c((String)localObject1, 18007)), Integer.valueOf(TXCStatus.c((String)localObject1, 18014)), Integer.valueOf(TXCStatus.c((String)localObject1, 16002)) }, 8));
        k.g(localObject4, "java.lang.String.format(locale, format, *args)");
        localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
        localObject4 = z.KUT;
        localObject4 = Locale.CHINA;
        k.g(localObject4, "Locale.CHINA");
        localObject4 = String.format((Locale)localObject4, "BIT:%d|%dkbps RES:%dx%d FPS:%d-%d\n", Arrays.copyOf(new Object[] { Integer.valueOf(TXCStatus.c((String)localObject1, 17002, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 18002)), Integer.valueOf(i >> 16), Integer.valueOf(i & 0xFFFF), Integer.valueOf((int)TXCStatus.d((String)localObject1, 6002, 0)), Integer.valueOf((int)TXCStatus.d((String)localObject1, 17003, 0)) }, 6));
        k.g(localObject4, "java.lang.String.format(locale, format, *args)");
        localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
        localObject4 = z.KUT;
        localObject4 = Locale.CHINA;
        k.g(localObject4, "Locale.CHINA");
        localObject4 = String.format((Locale)localObject4, "FEC:%d-%d-%d%%|%d-%d-%d%%    ARQ:%d-%d|%d-%d\n", Arrays.copyOf(new Object[] { Integer.valueOf(TXCStatus.c((String)localObject1, 17007, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 17005, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 17006, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 18009)), Integer.valueOf(TXCStatus.c((String)localObject1, 18007)), Integer.valueOf(TXCStatus.c((String)localObject1, 18008)), Integer.valueOf(TXCStatus.c((String)localObject1, 17009, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 17008, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 18012)), Integer.valueOf(TXCStatus.c((String)localObject1, 18010)) }, 10));
        k.g(localObject4, "java.lang.String.format(locale, format, *args)");
        localObject3 = ((StringBuilder)localObject3).append((String)localObject4);
        localObject4 = z.KUT;
        localObject4 = Locale.CHINA;
        k.g(localObject4, "Locale.CHINA");
        localObject2 = String.format((Locale)localObject4, "CPU:%d%%|%d%%  RPS:%d  LFR:%d  DERR:%d\n", Arrays.copyOf(new Object[] { Integer.valueOf(localObject2[0] / 10), Integer.valueOf(localObject2[1] / 10), Integer.valueOf(TXCStatus.c((String)localObject1, 17012, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 17013, 0)), Long.valueOf(l) }, 5));
        k.g(localObject2, "java.lang.String.format(locale, format, *args)");
        localObject2 = ((StringBuilder)localObject3).append((String)localObject2);
        localObject3 = z.KUT;
        localObject3 = Locale.CHINA;
        k.g(localObject3, "Locale.CHINA");
        localObject1 = String.format((Locale)localObject3, "Jitter: %d,%d|%d,%d|%d\n", Arrays.copyOf(new Object[] { Integer.valueOf(TXCStatus.c((String)localObject1, 2007)), Integer.valueOf(TXCStatus.c((String)localObject1, 6010, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 6011, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 6012, 0)), Integer.valueOf(TXCStatus.c((String)localObject1, 18015)) }, 5));
        k.g(localObject1, "java.lang.String.format(locale, format, *args)");
        localObject1 = (String)localObject1;
        localObject2 = new SpannableString((CharSequence)localObject1);
        i = n.f((CharSequence)localObject1, "DECERR:");
        if ((-1 != i) && (l > 0L)) {
          ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(-65536), i + 7, ((String)localObject1).length(), 33);
        }
      }
      label1075:
      for (localObject1 = (CharSequence)localObject2;; localObject1 = null)
      {
        com.tencent.mm.live.core.debug.a.uI(String.valueOf(localObject1));
        b.d(this.gqu).removeCallbacks((Runnable)this);
        b.d(this.gqu).postDelayed((Runnable)this, 10000L);
        AppMethodBeat.o(209198);
        return;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$floatMode$1", "Landroid/view/SurfaceHolder$Callback;", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "plugin-core_release"})
  public static final class c
    implements SurfaceHolder.Callback
  {
    c(f paramf, long paramLong) {}
    
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(209199);
      ac.i("MicroMsg.LiveCoreVisitor", "float surfaceChange, holder:" + paramSurfaceHolder + ", size:[" + paramInt2 + ", " + paramInt3 + ']');
      f localf = this.gqv;
      if (paramSurfaceHolder != null) {}
      for (paramSurfaceHolder = paramSurfaceHolder.getSurface();; paramSurfaceHolder = null)
      {
        localf.bE(paramSurfaceHolder);
        this.gqv.cQ(paramInt2, paramInt3);
        com.tencent.mm.live.core.c.b.mP((int)bs.aO(l));
        AppMethodBeat.o(209199);
        return;
      }
    }
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder) {}
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(209200);
      ac.i("MicroMsg.LiveCoreVisitor", "float surface destroy");
      AppMethodBeat.o(209200);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$normalMode$1$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "surface", "plugin-core_release"})
  public static final class d
    implements TextureView.SurfaceTextureListener
  {
    d(f paramf, long paramLong) {}
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(209201);
      k.h(paramSurfaceTexture, "surfaceTexture");
      ac.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureAvailable, size:[%s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.gqw.bE(new Surface(paramSurfaceTexture));
      this.gqw.cQ(paramInt1, paramInt2);
      com.tencent.mm.live.core.c.b.mO((int)bs.aO(l2));
      AppMethodBeat.o(209201);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(209203);
      k.h(paramSurfaceTexture, "surfaceTexture");
      ac.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureDestroyed");
      this.gqw.ajJ();
      AppMethodBeat.o(209203);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(209202);
      k.h(paramSurfaceTexture, "surfaceTexture");
      ac.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureSizeChanged, size:[%s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.gqw.cQ(paramInt1, paramInt2);
      AppMethodBeat.o(209202);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(209204);
      k.h(paramSurfaceTexture, "surface");
      AppMethodBeat.o(209204);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  static final class e
    extends d.g.b.l
    implements q<j, Integer, Integer, y>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  static final class f
    extends d.g.b.l
    implements q<j, Integer, Integer, y>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "mFps", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<Integer, y>
  {
    public static final g gqA;
    
    static
    {
      AppMethodBeat.i(209210);
      gqA = new g();
      AppMethodBeat.o(209210);
    }
    
    g()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "cost", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.b<Integer, y>
  {
    public static final h gqB;
    
    static
    {
      AppMethodBeat.i(209212);
      gqB = new h();
      AppMethodBeat.o(209212);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.core.c.b
 * JD-Core Version:    0.7.0.1
 */