package com.tencent.mm.live.core.core.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.b.f;
import com.tencent.mm.live.core.b.j;
import com.tencent.mm.live.core.core.b.e.b;
import com.tencent.mm.live.core.core.b.e.d;
import com.tencent.mm.live.core.core.c.a;
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
import d.g.b.p;
import d.l;
import d.v;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/live/core/core/visitor/IMMLiveVisitorCore;", "Lcom/tencent/rtmp/ITXLivePlayListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "debugRunnable", "com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1;", "playerView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "enterRoom", "", "callback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "floatMode", "", "isAudioMicing", "", "isCdnMode", "isInLinkMic", "isVideoMicing", "normalMode", "onCdnPlayerAvailalbe", "liveId", "", "player", "Lcom/tencent/rtmp/TXLivePlayer;", "onEnterRoom", "result", "onNetStatus", "status", "Landroid/os/Bundle;", "onPlayEvent", "event", "param", "onRemoteUserLeaveRoom", "userId", "", "reason", "pauseRender", "refreshByOrientation", "release", "resumeRender", "startLinkMic", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "startPush", "stopLinkMic", "stopPush", "switchAudioLinkMic", "switchVideoLinkMic", "updatePreviewView", "visitRoom", "Companion", "plugin-core_release"})
public final class b
  extends com.tencent.mm.live.core.core.trtc.a
  implements a, ITXLivePlayListener
{
  private static b gKc;
  public static final a gKd;
  private TXCloudVideoView gKa;
  private final b gKb;
  
  static
  {
    AppMethodBeat.i(216891);
    gKd = new a((byte)0);
    AppMethodBeat.o(216891);
  }
  
  public b(Context paramContext)
  {
    super(paramContext, false);
    AppMethodBeat.i(216890);
    this.gKb = new b(this);
    AppMethodBeat.o(216890);
  }
  
  public final void a(long paramLong, TXLivePlayer paramTXLivePlayer, TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(216878);
    this.gKa = paramTXCloudVideoView;
    this.gIh.a(paramLong, paramTXLivePlayer);
    AppMethodBeat.o(216878);
  }
  
  public final void a(com.tencent.mm.live.core.core.b paramb)
  {
    AppMethodBeat.i(216874);
    p.h(paramb, "callback");
    super.a(paramb);
    paramb = com.tencent.mm.live.core.core.trtc.a.a.alJ();
    p.g(paramb, "ConfigHelper.getInstance()");
    paramb = paramb.alK();
    p.g(paramb, "ConfigHelper.getInstance().videoConfig");
    paramb.dJ(false);
    paramb = com.tencent.mm.live.core.core.trtc.a.a.alJ();
    p.g(paramb, "ConfigHelper.getInstance()");
    paramb = paramb.alL();
    p.g(paramb, "ConfigHelper.getInstance().audioConfig");
    paramb.dG(false);
    AppMethodBeat.o(216874);
  }
  
  public final void a(LivePreviewView paramLivePreviewView, com.tencent.mm.live.core.core.b paramb)
  {
    AppMethodBeat.i(216876);
    p.h(paramb, "callback");
    this.gIn = paramLivePreviewView;
    a(paramb);
    AppMethodBeat.o(216876);
  }
  
  public final boolean alG()
  {
    AppMethodBeat.i(216880);
    com.tencent.mm.live.core.core.trtc.a.c localc = this.gIi;
    if ((localc == null) || (localc.alW() != 21))
    {
      AppMethodBeat.o(216880);
      return true;
    }
    AppMethodBeat.o(216880);
    return false;
  }
  
  public final void ale()
  {
    AppMethodBeat.i(216873);
    if (!this.gIt.isFloatMode())
    {
      AppMethodBeat.o(216873);
      return;
    }
    final long l2 = bt.HI();
    this.gIt.gHL = e.d.gIb;
    Object localObject1;
    Object localObject2;
    if (this.gKa != null)
    {
      localObject1 = this.gIh;
      localObject2 = this.gIs;
      if (localObject2 == null) {
        break label247;
      }
      localObject2 = ((com.tencent.mm.live.core.core.b.d)localObject2).gHD;
      if (localObject2 == null) {
        break label247;
      }
    }
    label247:
    for (long l1 = ((com.tencent.mm.live.core.core.b.c)localObject2).gGy;; l1 = 0L)
    {
      ((com.tencent.mm.live.core.core.trtc.a.b.c)localObject1).re(l1).setPlayerView(this.gKa);
      localObject1 = this.gIh.xv(this.gIt.gHN);
      if (localObject1 != null)
      {
        ad.i("MicroMsg.LiveCoreVisitor", "normalMode, find renderSurface for userId:" + this.gIt.gHN);
        localObject2 = T(((f)localObject1).userId, ((f)localObject1).streamType);
        if (localObject2 != null)
        {
          TextureView localTextureView = new TextureView(((TXCloudVideoView)localObject2).getContext());
          ((TXCloudVideoView)localObject2).addVideoView(localTextureView);
          localTextureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new d((f)localObject1, l2));
        }
      }
      if (this.gIt.alE())
      {
        localObject1 = this.gIn;
        if (localObject1 != null) {
          ((LivePreviewView)localObject1).a((d.g.a.q)new e(this));
        }
      }
      super.ale();
      AppMethodBeat.o(216873);
      return;
    }
  }
  
  public final int ali()
  {
    AppMethodBeat.i(216887);
    this.gIm.e(null);
    this.gIg.enableCustomVideoCapture(false);
    this.gIu = false;
    AppMethodBeat.o(216887);
    return 0;
  }
  
  public final int alj()
  {
    AppMethodBeat.i(216888);
    this.gIm.e((d.g.a.b)g.gKk);
    this.gIg.enableCustomVideoCapture(true);
    this.gIu = true;
    AppMethodBeat.o(216888);
    return 0;
  }
  
  public final void amc()
  {
    Object localObject2 = null;
    AppMethodBeat.i(216877);
    com.tencent.mm.live.core.core.trtc.a.b.c localc;
    String str;
    if (!TextUtils.isEmpty((CharSequence)this.gIt.gHN))
    {
      localc = this.gIh;
      str = this.gIt.gHN;
      localObject1 = this.gIn;
      if (localObject1 == null) {
        break label202;
      }
    }
    label202:
    for (Object localObject1 = ((LivePreviewView)localObject1).U(this.gIt.gHN, 0);; localObject1 = null)
    {
      localc.a(str, (TXCloudVideoView)localObject1);
      this.gIh.muteRemoteAudio(this.gIt.gHN, false);
      if (!TextUtils.isEmpty((CharSequence)this.gIt.gHO))
      {
        localc = this.gIh;
        str = this.gIt.gHO;
        LivePreviewView localLivePreviewView = this.gIn;
        localObject1 = localObject2;
        if (localLivePreviewView != null) {
          localObject1 = localLivePreviewView.U(this.gIt.gHO, 0);
        }
        localc.a(str, (TXCloudVideoView)localObject1);
        this.gIh.muteRemoteAudio(this.gIt.gHN, false);
      }
      if (!this.gIt.alE()) {
        break;
      }
      localObject1 = this.gIn;
      if (localObject1 == null) {
        break;
      }
      ((LivePreviewView)localObject1).a((d.g.a.q)new f(this));
      AppMethodBeat.o(216877);
      return;
    }
    AppMethodBeat.o(216877);
  }
  
  public final int amd()
  {
    AppMethodBeat.i(216879);
    this.gIt.gHK = e.b.gHU;
    Object localObject = com.tencent.mm.live.core.debug.a.gKp;
    com.tencent.mm.live.core.debug.a.ar("MicroMsg.LiveCoreMic", "[sdk]start link mic");
    localObject = this.gIi;
    if ((localObject != null) && (((com.tencent.mm.live.core.core.trtc.a.c)localObject).alW() == 20))
    {
      AppMethodBeat.o(216879);
      return 0;
    }
    localObject = com.tencent.mm.live.core.core.trtc.a.a.alJ();
    p.g(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).alL();
    p.g(localObject, "ConfigHelper.getInstance().audioConfig");
    ((com.tencent.mm.live.core.core.trtc.a.a.a)localObject).dG(true);
    localObject = this.gIi;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).alR();
    }
    localObject = this.gIi;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).alV();
    }
    localObject = this.gIi;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).startLocalAudio();
    }
    AppMethodBeat.o(216879);
    return 0;
  }
  
  public final int ame()
  {
    AppMethodBeat.i(216881);
    this.gIt.gHK = e.b.gHT;
    Object localObject = com.tencent.mm.live.core.debug.a.gKp;
    com.tencent.mm.live.core.debug.a.ar("MicroMsg.LiveCoreMic", "[sdk]stop link mic");
    localObject = this.gIi;
    if ((localObject != null) && (((com.tencent.mm.live.core.core.trtc.a.c)localObject).alW() == 21))
    {
      AppMethodBeat.o(216881);
      return 0;
    }
    localObject = com.tencent.mm.live.core.core.trtc.a.a.alJ();
    p.g(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).alL();
    p.g(localObject, "ConfigHelper.getInstance().audioConfig");
    ((com.tencent.mm.live.core.core.trtc.a.a.a)localObject).dG(false);
    localObject = com.tencent.mm.live.core.core.trtc.a.a.alJ();
    p.g(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).alK();
    p.g(localObject, "ConfigHelper.getInstance().videoConfig");
    ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).dJ(false);
    localObject = this.gIi;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).alV();
    }
    localObject = this.gIi;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).stopLocalAudio();
    }
    alc();
    AppMethodBeat.o(216881);
    return 0;
  }
  
  public final void amf()
  {
    AppMethodBeat.i(216883);
    this.gIh.xs(this.gIt.gHN);
    this.gIh.muteRemoteAudio(this.gIt.gHN, true);
    AppMethodBeat.o(216883);
  }
  
  public final void amg()
  {
    AppMethodBeat.i(216884);
    if (this.gIn != null)
    {
      if (!TextUtils.isEmpty((CharSequence)this.gIt.gHN))
      {
        com.tencent.mm.live.core.core.trtc.a.b.c localc = this.gIh;
        String str = this.gIt.gHN;
        Object localObject = this.gIn;
        if (localObject != null) {}
        for (localObject = ((LivePreviewView)localObject).U(this.gIt.gHN, 0);; localObject = null)
        {
          localc.a(str, (TXCloudVideoView)localObject);
          this.gIh.muteRemoteAudio(this.gIt.gHN, false);
          AppMethodBeat.o(216884);
          return;
        }
      }
    }
    else {
      ad.w("MicroMsg.LiveCoreVisitor", "previewView == null!");
    }
    AppMethodBeat.o(216884);
  }
  
  public final void amh()
  {
    AppMethodBeat.i(216886);
    ali();
    alc();
    this.gIt.gHK = e.b.gHU;
    AppMethodBeat.o(216886);
  }
  
  public final void b(LivePreviewView paramLivePreviewView)
  {
    this.gIn = paramLivePreviewView;
  }
  
  public final void c(LivePreviewView paramLivePreviewView)
  {
    AppMethodBeat.i(216885);
    Object localObject = this.gIi;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).alR();
    }
    alj();
    if (paramLivePreviewView == null) {
      ad.e("MicroMsg.LiveCore", "startPreview preiewView is null");
    }
    do
    {
      this.gIt.gHK = e.b.gHV;
      this.gIm.f((d.g.a.b)h.gKl);
      AppMethodBeat.o(216885);
      return;
      this.gIm.amo();
      localObject = com.tencent.mm.live.core.debug.a.gKp;
      com.tencent.mm.live.core.debug.a.xx("startPreview ".concat(String.valueOf(paramLivePreviewView)));
      this.gIn = paramLivePreviewView;
      localObject = com.tencent.mm.live.core.core.trtc.a.a.alJ();
      p.g(localObject, "ConfigHelper.getInstance()");
      localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).alL();
      p.g(localObject, "ConfigHelper.getInstance().audioConfig");
      ((com.tencent.mm.live.core.core.trtc.a.a.a)localObject).dG(true);
      localObject = com.tencent.mm.live.core.core.trtc.a.a.alJ();
      p.g(localObject, "ConfigHelper.getInstance()");
      localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).alK();
      p.g(localObject, "ConfigHelper.getInstance().videoConfig");
      ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).dJ(true);
      paramLivePreviewView.a((d.g.a.q)new a.h(this));
      paramLivePreviewView = this.gIo;
    } while ((paramLivePreviewView == null) || (paramLivePreviewView.awa() != true));
    paramLivePreviewView = com.tencent.mm.live.core.core.trtc.a.a.alJ();
    p.g(paramLivePreviewView, "ConfigHelper.getInstance()");
    paramLivePreviewView = paramLivePreviewView.alN();
    localObject = this.gIo;
    int i;
    if (localObject != null)
    {
      i = ((com.tencent.mm.media.widget.a.e)localObject).awp();
      label213:
      paramLivePreviewView.gJh = i;
      ad.i("MicroMsg.LiveCore", "start preview success");
      localObject = this.gIm;
      paramLivePreviewView = this.gIo;
      if (paramLivePreviewView == null) {
        break label286;
      }
    }
    label286:
    for (paramLivePreviewView = paramLivePreviewView.awl();; paramLivePreviewView = null)
    {
      if (paramLivePreviewView == null) {
        p.gfZ();
      }
      ((com.tencent.mm.live.core.b.b)localObject).a(paramLivePreviewView);
      this.gIm.setOnDrawListener((d.g.a.b)new a.g(this));
      break;
      i = 0;
      break label213;
    }
  }
  
  public final int cp(Context paramContext)
  {
    int j = 0;
    AppMethodBeat.i(216872);
    p.h(paramContext, "context");
    if (this.gIt.isFloatMode())
    {
      AppMethodBeat.o(216872);
      return 0;
    }
    final long l = bt.HI();
    this.gIt.gHL = e.d.gIc;
    int i;
    if ((!this.gIt.alE()) && (!this.gIt.alF()))
    {
      localObject1 = this.gIs;
      i = j;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.b.d)localObject1).gHD;
        i = j;
        if (localObject1 != null)
        {
          int k = ((com.tencent.mm.live.core.core.b.c)localObject1).gHy;
          localObject1 = c.a.gGU;
          i = j;
          if (k == c.a.all()) {
            i = 1;
          }
        }
      }
      if (i != 0) {}
    }
    else
    {
      localObject1 = this.gIh.xv(this.gIt.gHN);
      if (localObject1 != null)
      {
        localObject2 = T(((f)localObject1).userId, ((f)localObject1).streamType);
        if (localObject2 != null) {
          ((TXCloudVideoView)localObject2).removeVideoView();
        }
        ad.i("MicroMsg.LiveCoreVisitor", "enter float mode");
        ((f)localObject1).amv();
        localObject2 = new SurfaceView(aj.getContext());
        ((SurfaceView)localObject2).getHolder().addCallback((SurfaceHolder.Callback)new c((f)localObject1, l));
        this.gIl.cx((View)localObject2);
      }
      i = super.cp(paramContext);
      AppMethodBeat.o(216872);
      return i;
    }
    Object localObject1 = this.gIh;
    Object localObject2 = this.gIs;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.live.core.core.b.d)localObject2).gHD;
      if (localObject2 == null) {}
    }
    for (l = ((com.tencent.mm.live.core.core.b.c)localObject2).gGy;; l = 0L)
    {
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a.b.c)localObject1).re(l);
      localObject2 = new TXCloudVideoView(aj.getContext());
      this.gIl.cx((View)localObject2);
      ((TXLivePlayer)localObject1).setPlayerView((TXCloudVideoView)localObject2);
      break;
    }
  }
  
  public final void onEnterRoom(long paramLong)
  {
    AppMethodBeat.i(216875);
    super.onEnterRoom(paramLong);
    this.gIf.post((Runnable)this.gKb);
    AppMethodBeat.o(216875);
  }
  
  public final void onNetStatus(Bundle paramBundle) {}
  
  public final void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(216871);
    ad.i("MicroMsg.LiveCoreVisitor", "onPlayEvent ".concat(String.valueOf(paramInt)));
    paramBundle = com.tencent.mm.live.core.debug.a.gKp;
    com.tencent.mm.live.core.debug.a.xx("onPlayEvent ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(216871);
  }
  
  public final void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    AppMethodBeat.i(216882);
    super.onRemoteUserLeaveRoom(paramString, paramInt);
    AppMethodBeat.o(216882);
  }
  
  public final void release()
  {
    AppMethodBeat.i(216889);
    super.release();
    this.gIf.removeCallbacks((Runnable)this.gKb);
    AppMethodBeat.o(216889);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "TAG", "", "getInstance", "context", "Landroid/content/Context;", "hasInstance", "", "releaseInstance", "", "plugin-core_release"})
  public static final class a
  {
    public static boolean alz()
    {
      AppMethodBeat.i(216855);
      if (b.ami() != null)
      {
        AppMethodBeat.o(216855);
        return true;
      }
      AppMethodBeat.o(216855);
      return false;
    }
    
    public static b cr(Context paramContext)
    {
      AppMethodBeat.i(216854);
      p.h(paramContext, "context");
      if (b.ami() == null) {
        b.e(new b(paramContext));
      }
      paramContext = b.ami();
      if (paramContext == null) {
        p.gfZ();
      }
      AppMethodBeat.o(216854);
      return paramContext;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-core_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(216856);
      Object localObject = b.b(this.gKe);
      if (localObject != null)
      {
        com.tencent.mm.live.core.debug.a locala = com.tencent.mm.live.core.debug.a.gKp;
        if (b.c(this.gKe) == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.live.core.core.trtc.WXTRTCCloudImpl");
          AppMethodBeat.o(216856);
          throw ((Throwable)localObject);
        }
        localObject = ((com.tencent.mm.live.core.core.b.d)localObject).gHC.userId;
        p.g(localObject, "trtcParams.userId");
        com.tencent.mm.live.core.debug.a.xz(String.valueOf(com.tencent.mm.live.core.core.trtc.b.xn((String)localObject)));
      }
      b.d(this.gKe).removeCallbacks((Runnable)this);
      b.d(this.gKe).postDelayed((Runnable)this, 10000L);
      AppMethodBeat.o(216856);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$floatMode$1", "Landroid/view/SurfaceHolder$Callback;", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "plugin-core_release"})
  public static final class c
    implements SurfaceHolder.Callback
  {
    c(f paramf, long paramLong) {}
    
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(216857);
      ad.i("MicroMsg.LiveCoreVisitor", "float surfaceChange, holder:" + paramSurfaceHolder + ", size:[" + paramInt2 + ", " + paramInt3 + ']');
      f localf = this.gKf;
      if (paramSurfaceHolder != null) {}
      for (paramSurfaceHolder = paramSurfaceHolder.getSurface();; paramSurfaceHolder = null)
      {
        localf.bG(paramSurfaceHolder);
        this.gKf.cS(paramInt2, paramInt3);
        com.tencent.mm.live.core.c.b.no((int)bt.aO(l));
        AppMethodBeat.o(216857);
        return;
      }
    }
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder) {}
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(216858);
      ad.i("MicroMsg.LiveCoreVisitor", "float surface destroy");
      AppMethodBeat.o(216858);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$normalMode$1$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "surface", "plugin-core_release"})
  public static final class d
    implements TextureView.SurfaceTextureListener
  {
    d(f paramf, long paramLong) {}
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(216859);
      p.h(paramSurfaceTexture, "surfaceTexture");
      ad.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureAvailable, size:[%s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.gKg.bG(new Surface(paramSurfaceTexture));
      this.gKg.cS(paramInt1, paramInt2);
      com.tencent.mm.live.core.c.b.nn((int)bt.aO(l2));
      AppMethodBeat.o(216859);
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(216861);
      p.h(paramSurfaceTexture, "surfaceTexture");
      ad.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureDestroyed");
      this.gKg.amv();
      AppMethodBeat.o(216861);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(216860);
      p.h(paramSurfaceTexture, "surfaceTexture");
      ad.i("MicroMsg.LiveCoreVisitor", "customRender onSurfaceTextureSizeChanged, size:[%s, %s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.gKg.cS(paramInt1, paramInt2);
      AppMethodBeat.o(216860);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(216862);
      p.h(paramSurfaceTexture, "surface");
      AppMethodBeat.o(216862);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.q<j, Integer, Integer, z>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.q<j, Integer, Integer, z>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "mFps", "", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.b<Integer, z>
  {
    public static final g gKk;
    
    static
    {
      AppMethodBeat.i(216868);
      gKk = new g();
      AppMethodBeat.o(216868);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "cost", "", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.b<Integer, z>
  {
    public static final h gKl;
    
    static
    {
      AppMethodBeat.i(216870);
      gKl = new h();
      AppMethodBeat.o(216870);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.c.b
 * JD-Core Version:    0.7.0.1
 */