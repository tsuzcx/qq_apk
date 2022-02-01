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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.trtc.TRTCCloud;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.v;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "debugRunnable", "com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1;", "endScaleAnimation", "", "time", "", "enterRoom", "callback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "floatMode", "normalMode", "onEnterRoom", "result", "", "onError", "errCode", "errMsg", "", "extraInfo", "Landroid/os/Bundle;", "release", "startPush", "startScaleAnimation", "scale", "", "stopPush", "Companion", "plugin-core_release"})
public final class b
  extends com.tencent.mm.live.core.core.trtc.a
  implements a
{
  private static b gJT;
  public static final a gJU;
  private final b gJS;
  
  static
  {
    AppMethodBeat.i(196819);
    gJU = new a((byte)0);
    AppMethodBeat.o(196819);
  }
  
  public b(Context paramContext)
  {
    super(paramContext, true);
    AppMethodBeat.i(196818);
    this.gJS = new b(this);
    AppMethodBeat.o(196818);
  }
  
  public final void a(com.tencent.mm.live.core.core.b paramb)
  {
    AppMethodBeat.i(196811);
    p.h(paramb, "callback");
    super.a(paramb);
    paramb = com.tencent.mm.live.core.core.trtc.a.a.alY();
    p.g(paramb, "ConfigHelper.getInstance()");
    Object localObject = paramb.alZ();
    paramb = com.tencent.mm.live.core.core.trtc.a.a.alY();
    p.g(paramb, "ConfigHelper.getInstance()");
    paramb = paramb.ama();
    p.g(localObject, "videoConfig");
    ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).dK(true);
    p.g(paramb, "audioConfig");
    paramb.dH(true);
    localObject = this.gKR;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).startLocalAudio();
    }
    localObject = this.gKR;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).dG(paramb.amm());
    }
    paramb = this.gKR;
    if (paramb != null)
    {
      paramb.amf();
      AppMethodBeat.o(196811);
      return;
    }
    AppMethodBeat.o(196811);
  }
  
  public final void alt()
  {
    AppMethodBeat.i(196815);
    final long l = bu.HQ();
    super.alt();
    LivePreviewView localLivePreviewView = this.gKW;
    if (localLivePreviewView != null)
    {
      localLivePreviewView.a((d.g.a.q)new d(this, l));
      AppMethodBeat.o(196815);
      return;
    }
    AppMethodBeat.o(196815);
  }
  
  public final int alx()
  {
    AppMethodBeat.i(196813);
    this.gKV.e(null);
    this.gKP.enableCustomVideoCapture(false);
    com.tencent.mm.live.core.core.trtc.a.c localc = this.gKR;
    if (localc != null) {
      localc.stopLocalAudio();
    }
    this.gLd = false;
    AppMethodBeat.o(196813);
    return 0;
  }
  
  public final int aly()
  {
    AppMethodBeat.i(196814);
    this.gKP.enableCustomVideoCapture(true);
    com.tencent.mm.live.core.core.trtc.a.c localc = this.gKR;
    if (localc != null) {
      localc.startLocalAudio();
    }
    this.gLd = true;
    this.gKV.e((d.g.a.b)e.gKa);
    this.gKV.f((d.g.a.b)f.gKb);
    AppMethodBeat.o(196814);
    return 0;
  }
  
  public final int cr(Context paramContext)
  {
    AppMethodBeat.i(196810);
    p.h(paramContext, "context");
    Object localObject2 = this.gLc;
    Object localObject1 = this.gLb;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.live.core.core.b.d)localObject1).gKm;
      if (localObject1 == null) {}
    }
    for (localObject1 = Long.valueOf(((com.tencent.mm.live.core.core.b.c)localObject1).gJh); !((com.tencent.mm.live.core.core.b.e)localObject2).b((Long)localObject1); localObject1 = null)
    {
      AppMethodBeat.o(196810);
      return -4;
    }
    final long l = bu.HQ();
    localObject1 = new SurfaceView(ak.getContext());
    ((SurfaceView)localObject1).getHolder().addCallback((SurfaceHolder.Callback)new c(this, l, (SurfaceView)localObject1));
    localObject2 = this.gKV.gNB;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.live.core.b.e)localObject2).gNP;
      if (localObject2 != null)
      {
        ((com.tencent.mm.live.core.b.d)localObject2).gNM = 0;
        ((com.tencent.mm.live.core.b.d)localObject2).gNL = 0;
      }
    }
    this.gKU.cx((View)localObject1);
    int i = super.cr(paramContext);
    AppMethodBeat.o(196810);
    return i;
  }
  
  public final void onEnterRoom(long paramLong)
  {
    AppMethodBeat.i(196812);
    super.onEnterRoom(paramLong);
    this.gKO.post((Runnable)this.gJS);
    AppMethodBeat.o(196812);
  }
  
  public final void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(196816);
    if (paramInt == -3301)
    {
      paramBundle = com.tencent.mm.live.core.debug.a.gMY;
      com.tencent.mm.live.core.debug.a.yh("[-3301]create room fail,".concat(String.valueOf(paramString)));
      paramString = this.gKY;
      if (paramString != null) {
        com.tencent.mm.live.core.core.b.a.a(paramString, paramInt);
      }
      this.gKY = null;
      AppMethodBeat.o(196816);
      return;
    }
    super.onError(paramInt, paramString, paramBundle);
    AppMethodBeat.o(196816);
  }
  
  public final void release()
  {
    AppMethodBeat.i(196817);
    super.release();
    this.gKO.removeCallbacks((Runnable)this.gJS);
    this.gKY = null;
    this.gKZ = null;
    AppMethodBeat.o(196817);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "TAG", "", "getInstance", "context", "Landroid/content/Context;", "hasInstance", "", "releaseInstance", "", "plugin-core_release"})
  public static final class a
  {
    public static boolean alO()
    {
      AppMethodBeat.i(196799);
      if (b.alN() != null)
      {
        AppMethodBeat.o(196799);
        return true;
      }
      AppMethodBeat.o(196799);
      return false;
    }
    
    public static b cs(Context paramContext)
    {
      AppMethodBeat.i(196798);
      p.h(paramContext, "context");
      if (b.alN() == null) {
        b.d(new b(paramContext));
      }
      paramContext = b.alN();
      if (paramContext == null) {
        p.gkB();
      }
      AppMethodBeat.o(196798);
      return paramContext;
    }
    
    public static void releaseInstance()
    {
      AppMethodBeat.i(196800);
      b localb = b.alN();
      if (localb != null) {
        localb.release();
      }
      b.d(null);
      AppMethodBeat.o(196800);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-core_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(196801);
      Object localObject = com.tencent.mm.live.core.debug.a.gMY;
      localObject = b.b(this.gJV);
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.live.core.core.trtc.WXTRTCCloudImpl");
        AppMethodBeat.o(196801);
        throw ((Throwable)localObject);
      }
      com.tencent.mm.live.core.debug.a.yi(((com.tencent.mm.live.core.core.trtc.b)localObject).alW().toString());
      b.c(this.gJV).removeCallbacks((Runnable)this);
      b.c(this.gJV).postDelayed((Runnable)this, 10000L);
      AppMethodBeat.o(196801);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$floatMode$1", "Landroid/view/SurfaceHolder$Callback;", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "plugin-core_release"})
  public static final class c
    implements SurfaceHolder.Callback
  {
    c(long paramLong, SurfaceView paramSurfaceView) {}
    
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(196802);
      ae.i("MicroMsg.LiveCoreAnchor", "float surfaceChange, holder:" + paramSurfaceHolder + ", size:[" + paramInt2 + ", " + paramInt3 + ']');
      com.tencent.mm.live.core.c.a.ni((int)bu.aO(l));
      paramSurfaceHolder = b.a(this.gJV);
      SurfaceHolder localSurfaceHolder = this.gJX.getHolder();
      p.g(localSurfaceHolder, "renderView.holder");
      paramSurfaceHolder.bG(localSurfaceHolder.getSurface());
      AppMethodBeat.o(196802);
    }
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder) {}
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(196803);
      ae.i("MicroMsg.LiveCoreAnchor", "float surface destroy");
      AppMethodBeat.o(196803);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.q<j, Integer, Integer, z>
  {
    d(b paramb, long paramLong)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "mFps", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.b<Integer, z>
  {
    public static final e gKa;
    
    static
    {
      AppMethodBeat.i(196807);
      gKa = new e();
      AppMethodBeat.o(196807);
    }
    
    e()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "cost", "", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.b<Integer, z>
  {
    public static final f gKb;
    
    static
    {
      AppMethodBeat.i(196809);
      gKb = new f();
      AppMethodBeat.o(196809);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.core.a.b
 * JD-Core Version:    0.7.0.1
 */