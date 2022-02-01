package com.tencent.mm.live.core.core.a;

import android.content.Context;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.b.j;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.trtc.TRTCCloud;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.v;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "debugRunnable", "com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1;", "endScaleAnimation", "", "time", "", "enterRoom", "callback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "floatMode", "normalMode", "onEnterRoom", "result", "", "onError", "errCode", "errMsg", "", "extraInfo", "Landroid/os/Bundle;", "release", "startPush", "startScaleAnimation", "scale", "", "stopPush", "Companion", "plugin-core_release"})
public final class b
  extends com.tencent.mm.live.core.core.trtc.a
  implements a
{
  private static b gHk;
  public static final a gHl;
  private final b gHj;
  
  static
  {
    AppMethodBeat.i(216807);
    gHl = new a((byte)0);
    AppMethodBeat.o(216807);
  }
  
  public b(Context paramContext)
  {
    super(paramContext, true);
    AppMethodBeat.i(216806);
    this.gHj = new b(this);
    AppMethodBeat.o(216806);
  }
  
  public final void a(com.tencent.mm.live.core.core.b paramb)
  {
    AppMethodBeat.i(216799);
    p.h(paramb, "callback");
    super.a(paramb);
    paramb = com.tencent.mm.live.core.core.trtc.a.a.alJ();
    p.g(paramb, "ConfigHelper.getInstance()");
    Object localObject = paramb.alK();
    paramb = com.tencent.mm.live.core.core.trtc.a.a.alJ();
    p.g(paramb, "ConfigHelper.getInstance()");
    paramb = paramb.alL();
    p.g(localObject, "videoConfig");
    ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).dJ(true);
    p.g(paramb, "audioConfig");
    paramb.dG(true);
    localObject = this.gIi;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).startLocalAudio();
    }
    localObject = this.gIi;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).dF(paramb.alX());
    }
    paramb = this.gIi;
    if (paramb != null)
    {
      paramb.alQ();
      AppMethodBeat.o(216799);
      return;
    }
    AppMethodBeat.o(216799);
  }
  
  public final void ale()
  {
    AppMethodBeat.i(216803);
    final long l = bt.HI();
    super.ale();
    LivePreviewView localLivePreviewView = this.gIn;
    if (localLivePreviewView != null)
    {
      localLivePreviewView.a((d.g.a.q)new d(this, l));
      AppMethodBeat.o(216803);
      return;
    }
    AppMethodBeat.o(216803);
  }
  
  public final int ali()
  {
    AppMethodBeat.i(216801);
    this.gIm.e(null);
    this.gIg.enableCustomVideoCapture(false);
    com.tencent.mm.live.core.core.trtc.a.c localc = this.gIi;
    if (localc != null) {
      localc.stopLocalAudio();
    }
    this.gIu = false;
    AppMethodBeat.o(216801);
    return 0;
  }
  
  public final int alj()
  {
    AppMethodBeat.i(216802);
    this.gIg.enableCustomVideoCapture(true);
    com.tencent.mm.live.core.core.trtc.a.c localc = this.gIi;
    if (localc != null) {
      localc.startLocalAudio();
    }
    this.gIu = true;
    this.gIm.e((d.g.a.b)e.gHr);
    this.gIm.f((d.g.a.b)f.gHs);
    AppMethodBeat.o(216802);
    return 0;
  }
  
  public final int cp(Context paramContext)
  {
    AppMethodBeat.i(216798);
    p.h(paramContext, "context");
    Object localObject2 = this.gIt;
    Object localObject1 = this.gIs;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.live.core.core.b.d)localObject1).gHD;
      if (localObject1 == null) {}
    }
    for (localObject1 = Long.valueOf(((com.tencent.mm.live.core.core.b.c)localObject1).gGy); !((com.tencent.mm.live.core.core.b.e)localObject2).b((Long)localObject1); localObject1 = null)
    {
      AppMethodBeat.o(216798);
      return -4;
    }
    final long l = bt.HI();
    localObject1 = new SurfaceView(aj.getContext());
    ((SurfaceView)localObject1).getHolder().addCallback((SurfaceHolder.Callback)new c(this, l, (SurfaceView)localObject1));
    localObject2 = this.gIm.gKS;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.live.core.b.e)localObject2).gLg;
      if (localObject2 != null)
      {
        ((com.tencent.mm.live.core.b.d)localObject2).gLd = 0;
        ((com.tencent.mm.live.core.b.d)localObject2).gLc = 0;
      }
    }
    this.gIl.cx((View)localObject1);
    int i = super.cp(paramContext);
    AppMethodBeat.o(216798);
    return i;
  }
  
  public final void onEnterRoom(long paramLong)
  {
    AppMethodBeat.i(216800);
    super.onEnterRoom(paramLong);
    this.gIf.post((Runnable)this.gHj);
    AppMethodBeat.o(216800);
  }
  
  public final void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(216804);
    if (paramInt == -3301)
    {
      paramBundle = com.tencent.mm.live.core.debug.a.gKp;
      com.tencent.mm.live.core.debug.a.xy("[-3301]create room fail,".concat(String.valueOf(paramString)));
      paramString = this.gIp;
      if (paramString != null) {
        com.tencent.mm.live.core.core.b.a.a(paramString, paramInt);
      }
      this.gIp = null;
      AppMethodBeat.o(216804);
      return;
    }
    super.onError(paramInt, paramString, paramBundle);
    AppMethodBeat.o(216804);
  }
  
  public final void release()
  {
    AppMethodBeat.i(216805);
    super.release();
    this.gIf.removeCallbacks((Runnable)this.gHj);
    this.gIp = null;
    this.gIq = null;
    AppMethodBeat.o(216805);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "TAG", "", "getInstance", "context", "Landroid/content/Context;", "hasInstance", "", "releaseInstance", "", "plugin-core_release"})
  public static final class a
  {
    public static boolean alz()
    {
      AppMethodBeat.i(216787);
      if (b.aly() != null)
      {
        AppMethodBeat.o(216787);
        return true;
      }
      AppMethodBeat.o(216787);
      return false;
    }
    
    public static b cq(Context paramContext)
    {
      AppMethodBeat.i(216786);
      p.h(paramContext, "context");
      if (b.aly() == null) {
        b.d(new b(paramContext));
      }
      paramContext = b.aly();
      if (paramContext == null) {
        p.gfZ();
      }
      AppMethodBeat.o(216786);
      return paramContext;
    }
    
    public static void releaseInstance()
    {
      AppMethodBeat.i(216788);
      b localb = b.aly();
      if (localb != null) {
        localb.release();
      }
      b.d(null);
      AppMethodBeat.o(216788);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-core_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(216789);
      Object localObject = com.tencent.mm.live.core.debug.a.gKp;
      localObject = b.b(this.gHm);
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.live.core.core.trtc.WXTRTCCloudImpl");
        AppMethodBeat.o(216789);
        throw ((Throwable)localObject);
      }
      com.tencent.mm.live.core.debug.a.xz(((com.tencent.mm.live.core.core.trtc.b)localObject).alH().toString());
      b.c(this.gHm).removeCallbacks((Runnable)this);
      b.c(this.gHm).postDelayed((Runnable)this, 10000L);
      AppMethodBeat.o(216789);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$floatMode$1", "Landroid/view/SurfaceHolder$Callback;", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "plugin-core_release"})
  public static final class c
    implements SurfaceHolder.Callback
  {
    c(long paramLong, SurfaceView paramSurfaceView) {}
    
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(216790);
      ad.i("MicroMsg.LiveCoreAnchor", "float surfaceChange, holder:" + paramSurfaceHolder + ", size:[" + paramInt2 + ", " + paramInt3 + ']');
      com.tencent.mm.live.core.c.a.nf((int)bt.aO(l));
      paramSurfaceHolder = b.a(this.gHm);
      SurfaceHolder localSurfaceHolder = this.gHo.getHolder();
      p.g(localSurfaceHolder, "renderView.holder");
      paramSurfaceHolder.bG(localSurfaceHolder.getSurface());
      AppMethodBeat.o(216790);
    }
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder) {}
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(216791);
      ad.i("MicroMsg.LiveCoreAnchor", "float surface destroy");
      AppMethodBeat.o(216791);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.q<j, Integer, Integer, z>
  {
    d(b paramb, long paramLong)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "mFps", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.b<Integer, z>
  {
    public static final e gHr;
    
    static
    {
      AppMethodBeat.i(216795);
      gHr = new e();
      AppMethodBeat.o(216795);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "cost", "", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.b<Integer, z>
  {
    public static final f gHs;
    
    static
    {
      AppMethodBeat.i(216797);
      gHs = new f();
      AppMethodBeat.o(216797);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.a.b
 * JD-Core Version:    0.7.0.1
 */