package com.tencent.mm.live.core.core.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/live/core/core/visitor/IMMLiveVisitorCore;", "Lcom/tencent/rtmp/ITXLivePlayListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "debugRunnable", "com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1;", "playerView", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "enterRoom", "", "callback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "floatMode", "", "isAudioMicing", "", "isCdnMode", "isInLinkMic", "isVideoMicing", "normalMode", "onCdnPlayerAvailalbe", "liveId", "", "player", "Lcom/tencent/rtmp/TXLivePlayer;", "onEnterRoom", "result", "onNetStatus", "status", "Landroid/os/Bundle;", "onPlayEvent", "event", "param", "onRemoteUserLeaveRoom", "userId", "", "reason", "pauseRender", "refreshByOrientation", "release", "resumeRender", "startLinkMic", "previewView", "Lcom/tencent/mm/live/core/view/LivePreviewView;", "startPush", "stopLinkMic", "stopPush", "switchAudioLinkMic", "switchVideoLinkMic", "updatePreviewView", "visitRoom", "Companion", "plugin-core_release"})
public final class b
  extends com.tencent.mm.live.core.core.trtc.a
  implements a, ITXLivePlayListener
{
  private static b gML;
  public static final a gMM;
  private TXCloudVideoView gMJ;
  private final b gMK;
  
  static
  {
    AppMethodBeat.i(196903);
    gMM = new a((byte)0);
    AppMethodBeat.o(196903);
  }
  
  public b(Context paramContext)
  {
    super(paramContext, false);
    AppMethodBeat.i(196902);
    this.gMK = new b(this);
    AppMethodBeat.o(196902);
  }
  
  public final void a(long paramLong, TXLivePlayer paramTXLivePlayer, TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(196890);
    this.gMJ = paramTXCloudVideoView;
    this.gKQ.a(paramLong, paramTXLivePlayer);
    AppMethodBeat.o(196890);
  }
  
  public final void a(com.tencent.mm.live.core.core.b paramb)
  {
    AppMethodBeat.i(196886);
    p.h(paramb, "callback");
    super.a(paramb);
    paramb = com.tencent.mm.live.core.core.trtc.a.a.alY();
    p.g(paramb, "ConfigHelper.getInstance()");
    paramb = paramb.alZ();
    p.g(paramb, "ConfigHelper.getInstance().videoConfig");
    paramb.dK(false);
    paramb = com.tencent.mm.live.core.core.trtc.a.a.alY();
    p.g(paramb, "ConfigHelper.getInstance()");
    paramb = paramb.ama();
    p.g(paramb, "ConfigHelper.getInstance().audioConfig");
    paramb.dH(false);
    AppMethodBeat.o(196886);
  }
  
  public final void a(LivePreviewView paramLivePreviewView, com.tencent.mm.live.core.core.b paramb)
  {
    AppMethodBeat.i(196888);
    p.h(paramb, "callback");
    this.gKW = paramLivePreviewView;
    a(paramb);
    AppMethodBeat.o(196888);
  }
  
  public final boolean alV()
  {
    AppMethodBeat.i(196892);
    com.tencent.mm.live.core.core.trtc.a.c localc = this.gKR;
    if ((localc == null) || (localc.aml() != 21))
    {
      AppMethodBeat.o(196892);
      return true;
    }
    AppMethodBeat.o(196892);
    return false;
  }
  
  public final void alt()
  {
    AppMethodBeat.i(196885);
    if (!this.gLc.isFloatMode())
    {
      AppMethodBeat.o(196885);
      return;
    }
    long l2 = bu.HQ();
    this.gLc.gKu = e.d.gKK;
    Object localObject1;
    Object localObject2;
    if (this.gMJ != null)
    {
      localObject1 = this.gKQ;
      localObject2 = this.gLb;
      if (localObject2 == null) {
        break label247;
      }
      localObject2 = ((com.tencent.mm.live.core.core.b.d)localObject2).gKm;
      if (localObject2 == null) {
        break label247;
      }
    }
    label247:
    for (long l1 = ((com.tencent.mm.live.core.core.b.c)localObject2).gJh;; l1 = 0L)
    {
      ((com.tencent.mm.live.core.core.trtc.a.b.c)localObject1).rr(l1).setPlayerView(this.gMJ);
      localObject1 = this.gKQ.ye(this.gLc.gKw);
      if (localObject1 != null)
      {
        ae.i("MicroMsg.LiveCoreVisitor", "normalMode, find renderSurface for userId:" + this.gLc.gKw);
        localObject2 = U(((f)localObject1).userId, ((f)localObject1).streamType);
        if (localObject2 != null)
        {
          TextureView localTextureView = new TextureView(((TXCloudVideoView)localObject2).getContext());
          ((TXCloudVideoView)localObject2).addVideoView(localTextureView);
          localTextureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new b.d((f)localObject1, l2));
        }
      }
      if (this.gLc.alT())
      {
        localObject1 = this.gKW;
        if (localObject1 != null) {
          ((LivePreviewView)localObject1).a((d.g.a.q)new e(this));
        }
      }
      super.alt();
      AppMethodBeat.o(196885);
      return;
    }
  }
  
  public final int alx()
  {
    AppMethodBeat.i(196899);
    this.gKV.e(null);
    this.gKP.enableCustomVideoCapture(false);
    this.gLd = false;
    AppMethodBeat.o(196899);
    return 0;
  }
  
  public final int aly()
  {
    AppMethodBeat.i(196900);
    this.gKV.e((d.g.a.b)g.gMT);
    this.gKP.enableCustomVideoCapture(true);
    this.gLd = true;
    AppMethodBeat.o(196900);
    return 0;
  }
  
  public final void amr()
  {
    Object localObject2 = null;
    AppMethodBeat.i(196889);
    com.tencent.mm.live.core.core.trtc.a.b.c localc;
    String str;
    if (!TextUtils.isEmpty((CharSequence)this.gLc.gKw))
    {
      localc = this.gKQ;
      str = this.gLc.gKw;
      localObject1 = this.gKW;
      if (localObject1 == null) {
        break label202;
      }
    }
    label202:
    for (Object localObject1 = ((LivePreviewView)localObject1).V(this.gLc.gKw, 0);; localObject1 = null)
    {
      localc.a(str, (TXCloudVideoView)localObject1);
      this.gKQ.muteRemoteAudio(this.gLc.gKw, false);
      if (!TextUtils.isEmpty((CharSequence)this.gLc.gKx))
      {
        localc = this.gKQ;
        str = this.gLc.gKx;
        LivePreviewView localLivePreviewView = this.gKW;
        localObject1 = localObject2;
        if (localLivePreviewView != null) {
          localObject1 = localLivePreviewView.V(this.gLc.gKx, 0);
        }
        localc.a(str, (TXCloudVideoView)localObject1);
        this.gKQ.muteRemoteAudio(this.gLc.gKw, false);
      }
      if (!this.gLc.alT()) {
        break;
      }
      localObject1 = this.gKW;
      if (localObject1 == null) {
        break;
      }
      ((LivePreviewView)localObject1).a((d.g.a.q)new f(this));
      AppMethodBeat.o(196889);
      return;
    }
    AppMethodBeat.o(196889);
  }
  
  public final int ams()
  {
    AppMethodBeat.i(196891);
    this.gLc.gKt = e.b.gKD;
    Object localObject = com.tencent.mm.live.core.debug.a.gMY;
    com.tencent.mm.live.core.debug.a.as("MicroMsg.LiveCoreMic", "[sdk]start link mic");
    localObject = this.gKR;
    if ((localObject != null) && (((com.tencent.mm.live.core.core.trtc.a.c)localObject).aml() == 20))
    {
      AppMethodBeat.o(196891);
      return 0;
    }
    localObject = com.tencent.mm.live.core.core.trtc.a.a.alY();
    p.g(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).ama();
    p.g(localObject, "ConfigHelper.getInstance().audioConfig");
    ((com.tencent.mm.live.core.core.trtc.a.a.a)localObject).dH(true);
    localObject = this.gKR;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).amg();
    }
    localObject = this.gKR;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).amk();
    }
    localObject = this.gKR;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).startLocalAudio();
    }
    AppMethodBeat.o(196891);
    return 0;
  }
  
  public final int amt()
  {
    AppMethodBeat.i(196893);
    this.gLc.gKt = e.b.gKC;
    Object localObject = com.tencent.mm.live.core.debug.a.gMY;
    com.tencent.mm.live.core.debug.a.as("MicroMsg.LiveCoreMic", "[sdk]stop link mic");
    localObject = this.gKR;
    if ((localObject != null) && (((com.tencent.mm.live.core.core.trtc.a.c)localObject).aml() == 21))
    {
      AppMethodBeat.o(196893);
      return 0;
    }
    localObject = com.tencent.mm.live.core.core.trtc.a.a.alY();
    p.g(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).ama();
    p.g(localObject, "ConfigHelper.getInstance().audioConfig");
    ((com.tencent.mm.live.core.core.trtc.a.a.a)localObject).dH(false);
    localObject = com.tencent.mm.live.core.core.trtc.a.a.alY();
    p.g(localObject, "ConfigHelper.getInstance()");
    localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).alZ();
    p.g(localObject, "ConfigHelper.getInstance().videoConfig");
    ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).dK(false);
    localObject = this.gKR;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).amk();
    }
    localObject = this.gKR;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).stopLocalAudio();
    }
    alr();
    AppMethodBeat.o(196893);
    return 0;
  }
  
  public final void amu()
  {
    AppMethodBeat.i(196895);
    this.gKQ.yb(this.gLc.gKw);
    this.gKQ.muteRemoteAudio(this.gLc.gKw, true);
    AppMethodBeat.o(196895);
  }
  
  public final void amv()
  {
    AppMethodBeat.i(196896);
    if (this.gKW != null)
    {
      if (!TextUtils.isEmpty((CharSequence)this.gLc.gKw))
      {
        com.tencent.mm.live.core.core.trtc.a.b.c localc = this.gKQ;
        String str = this.gLc.gKw;
        Object localObject = this.gKW;
        if (localObject != null) {}
        for (localObject = ((LivePreviewView)localObject).V(this.gLc.gKw, 0);; localObject = null)
        {
          localc.a(str, (TXCloudVideoView)localObject);
          this.gKQ.muteRemoteAudio(this.gLc.gKw, false);
          AppMethodBeat.o(196896);
          return;
        }
      }
    }
    else {
      ae.w("MicroMsg.LiveCoreVisitor", "previewView == null!");
    }
    AppMethodBeat.o(196896);
  }
  
  public final void amw()
  {
    AppMethodBeat.i(196898);
    alx();
    alr();
    this.gLc.gKt = e.b.gKD;
    AppMethodBeat.o(196898);
  }
  
  public final void b(LivePreviewView paramLivePreviewView)
  {
    this.gKW = paramLivePreviewView;
  }
  
  public final void c(LivePreviewView paramLivePreviewView)
  {
    AppMethodBeat.i(196897);
    Object localObject = this.gKR;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).amg();
    }
    aly();
    if (paramLivePreviewView == null) {
      ae.e("MicroMsg.LiveCore", "startPreview preiewView is null");
    }
    do
    {
      this.gLc.gKt = e.b.gKE;
      this.gKV.f((d.g.a.b)h.gMU);
      AppMethodBeat.o(196897);
      return;
      this.gKV.amD();
      localObject = com.tencent.mm.live.core.debug.a.gMY;
      com.tencent.mm.live.core.debug.a.yg("startPreview ".concat(String.valueOf(paramLivePreviewView)));
      this.gKW = paramLivePreviewView;
      localObject = com.tencent.mm.live.core.core.trtc.a.a.alY();
      p.g(localObject, "ConfigHelper.getInstance()");
      localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).ama();
      p.g(localObject, "ConfigHelper.getInstance().audioConfig");
      ((com.tencent.mm.live.core.core.trtc.a.a.a)localObject).dH(true);
      localObject = com.tencent.mm.live.core.core.trtc.a.a.alY();
      p.g(localObject, "ConfigHelper.getInstance()");
      localObject = ((com.tencent.mm.live.core.core.trtc.a.a)localObject).alZ();
      p.g(localObject, "ConfigHelper.getInstance().videoConfig");
      ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).dK(true);
      paramLivePreviewView.a((d.g.a.q)new a.h(this));
      paramLivePreviewView = this.gKX;
    } while ((paramLivePreviewView == null) || (paramLivePreviewView.awp() != true));
    paramLivePreviewView = com.tencent.mm.live.core.core.trtc.a.a.alY();
    p.g(paramLivePreviewView, "ConfigHelper.getInstance()");
    paramLivePreviewView = paramLivePreviewView.amc();
    localObject = this.gKX;
    int i;
    if (localObject != null)
    {
      i = ((com.tencent.mm.media.widget.a.e)localObject).awE();
      label213:
      paramLivePreviewView.gLQ = i;
      ae.i("MicroMsg.LiveCore", "start preview success");
      localObject = this.gKV;
      paramLivePreviewView = this.gKX;
      if (paramLivePreviewView == null) {
        break label286;
      }
    }
    label286:
    for (paramLivePreviewView = paramLivePreviewView.awA();; paramLivePreviewView = null)
    {
      if (paramLivePreviewView == null) {
        p.gkB();
      }
      ((com.tencent.mm.live.core.b.b)localObject).a(paramLivePreviewView);
      this.gKV.setOnDrawListener((d.g.a.b)new a.g(this));
      break;
      i = 0;
      break label213;
    }
  }
  
  public final int cr(Context paramContext)
  {
    int j = 0;
    AppMethodBeat.i(196884);
    p.h(paramContext, "context");
    if (this.gLc.isFloatMode())
    {
      AppMethodBeat.o(196884);
      return 0;
    }
    long l = bu.HQ();
    this.gLc.gKu = e.d.gKL;
    int i;
    if ((!this.gLc.alT()) && (!this.gLc.alU()))
    {
      localObject1 = this.gLb;
      i = j;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.live.core.core.b.d)localObject1).gKm;
        i = j;
        if (localObject1 != null)
        {
          int k = ((com.tencent.mm.live.core.core.b.c)localObject1).gKh;
          localObject1 = c.a.gJD;
          i = j;
          if (k == c.a.alA()) {
            i = 1;
          }
        }
      }
      if (i != 0) {}
    }
    else
    {
      localObject1 = this.gKQ.ye(this.gLc.gKw);
      if (localObject1 != null)
      {
        localObject2 = U(((f)localObject1).userId, ((f)localObject1).streamType);
        if (localObject2 != null) {
          ((TXCloudVideoView)localObject2).removeVideoView();
        }
        ae.i("MicroMsg.LiveCoreVisitor", "enter float mode");
        ((f)localObject1).amK();
        localObject2 = new SurfaceView(ak.getContext());
        ((SurfaceView)localObject2).getHolder().addCallback((SurfaceHolder.Callback)new b.c((f)localObject1, l));
        this.gKU.cx((View)localObject2);
      }
      i = super.cr(paramContext);
      AppMethodBeat.o(196884);
      return i;
    }
    Object localObject1 = this.gKQ;
    Object localObject2 = this.gLb;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.live.core.core.b.d)localObject2).gKm;
      if (localObject2 == null) {}
    }
    for (l = ((com.tencent.mm.live.core.core.b.c)localObject2).gJh;; l = 0L)
    {
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a.b.c)localObject1).rr(l);
      localObject2 = new TXCloudVideoView(ak.getContext());
      this.gKU.cx((View)localObject2);
      ((TXLivePlayer)localObject1).setPlayerView((TXCloudVideoView)localObject2);
      break;
    }
  }
  
  public final void onEnterRoom(long paramLong)
  {
    AppMethodBeat.i(196887);
    super.onEnterRoom(paramLong);
    this.gKO.post((Runnable)this.gMK);
    AppMethodBeat.o(196887);
  }
  
  public final void onNetStatus(Bundle paramBundle) {}
  
  public final void onPlayEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(196883);
    ae.i("MicroMsg.LiveCoreVisitor", "onPlayEvent ".concat(String.valueOf(paramInt)));
    paramBundle = com.tencent.mm.live.core.debug.a.gMY;
    com.tencent.mm.live.core.debug.a.yg("onPlayEvent ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(196883);
  }
  
  public final void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    AppMethodBeat.i(196894);
    super.onRemoteUserLeaveRoom(paramString, paramInt);
    AppMethodBeat.o(196894);
  }
  
  public final void release()
  {
    AppMethodBeat.i(196901);
    super.release();
    this.gKO.removeCallbacks((Runnable)this.gMK);
    AppMethodBeat.o(196901);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "TAG", "", "getInstance", "context", "Landroid/content/Context;", "hasInstance", "", "releaseInstance", "", "plugin-core_release"})
  public static final class a
  {
    public static boolean alO()
    {
      AppMethodBeat.i(196867);
      if (b.amx() != null)
      {
        AppMethodBeat.o(196867);
        return true;
      }
      AppMethodBeat.o(196867);
      return false;
    }
    
    public static b ct(Context paramContext)
    {
      AppMethodBeat.i(196866);
      p.h(paramContext, "context");
      if (b.amx() == null) {
        b.e(new b(paramContext));
      }
      paramContext = b.amx();
      if (paramContext == null) {
        p.gkB();
      }
      AppMethodBeat.o(196866);
      return paramContext;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore$debugRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-core_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(196868);
      Object localObject = b.b(this.gMN);
      if (localObject != null)
      {
        com.tencent.mm.live.core.debug.a locala = com.tencent.mm.live.core.debug.a.gMY;
        if (b.c(this.gMN) == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.live.core.core.trtc.WXTRTCCloudImpl");
          AppMethodBeat.o(196868);
          throw ((Throwable)localObject);
        }
        localObject = ((com.tencent.mm.live.core.core.b.d)localObject).gKl.userId;
        p.g(localObject, "trtcParams.userId");
        com.tencent.mm.live.core.debug.a.yi(String.valueOf(com.tencent.mm.live.core.core.trtc.b.xW((String)localObject)));
      }
      b.d(this.gMN).removeCallbacks((Runnable)this);
      b.d(this.gMN).postDelayed((Runnable)this, 10000L);
      AppMethodBeat.o(196868);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.q<j, Integer, Integer, z>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.q<j, Integer, Integer, z>
  {
    f(b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "mFps", "", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.b<Integer, z>
  {
    public static final g gMT;
    
    static
    {
      AppMethodBeat.i(196880);
      gMT = new g();
      AppMethodBeat.o(196880);
    }
    
    g()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "cost", "", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.b<Integer, z>
  {
    public static final h gMU;
    
    static
    {
      AppMethodBeat.i(196882);
      gMU = new h();
      AppMethodBeat.o(196882);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.core.c.b
 * JD-Core Version:    0.7.0.1
 */