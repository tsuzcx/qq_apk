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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.trtc.TRTCCloud;
import d.g.a.m;
import d.g.a.q;
import d.g.b.k;
import d.v;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "debugRunnable", "com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1;", "endScaleAnimation", "", "time", "", "enterRoom", "callback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "floatMode", "normalMode", "onEnterRoom", "result", "", "onError", "errCode", "errMsg", "", "extraInfo", "Landroid/os/Bundle;", "release", "startPush", "startScaleAnimation", "scale", "", "stopPush", "Companion", "plugin-core_release"})
public final class b
  extends com.tencent.mm.live.core.core.trtc.a
  implements a
{
  private static b gnB;
  public static final b.a gnC;
  private final b gnA;
  
  static
  {
    AppMethodBeat.i(209150);
    gnC = new b.a((byte)0);
    AppMethodBeat.o(209150);
  }
  
  public b(Context paramContext)
  {
    super(paramContext, true);
    AppMethodBeat.i(209149);
    this.gnA = new b(this);
    AppMethodBeat.o(209149);
  }
  
  public final void a(com.tencent.mm.live.core.core.b paramb)
  {
    AppMethodBeat.i(209142);
    k.h(paramb, "callback");
    super.a(paramb);
    paramb = com.tencent.mm.live.core.core.trtc.a.a.aiX();
    k.g(paramb, "ConfigHelper.getInstance()");
    Object localObject = paramb.aiY();
    paramb = com.tencent.mm.live.core.core.trtc.a.a.aiX();
    k.g(paramb, "ConfigHelper.getInstance()");
    paramb = paramb.aiZ();
    k.g(localObject, "videoConfig");
    ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).dH(true);
    k.g(paramb, "audioConfig");
    paramb.dE(true);
    localObject = this.goA;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).startLocalAudio();
    }
    localObject = this.goA;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).dD(paramb.ajl());
    }
    paramb = this.goA;
    if (paramb != null)
    {
      paramb.aje();
      AppMethodBeat.o(209142);
      return;
    }
    AppMethodBeat.o(209142);
  }
  
  public final void ais()
  {
    AppMethodBeat.i(209146);
    final long l = bs.Gn();
    super.ais();
    LivePreviewView localLivePreviewView = this.goF;
    if (localLivePreviewView != null)
    {
      localLivePreviewView.a((q)new d(this, l));
      AppMethodBeat.o(209146);
      return;
    }
    AppMethodBeat.o(209146);
  }
  
  public final int aiw()
  {
    AppMethodBeat.i(209144);
    this.goE.d(null);
    this.goy.enableCustomVideoCapture(false);
    com.tencent.mm.live.core.core.trtc.a.c localc = this.goA;
    if (localc != null) {
      localc.stopLocalAudio();
    }
    this.goM = false;
    AppMethodBeat.o(209144);
    return 0;
  }
  
  public final int aix()
  {
    AppMethodBeat.i(209145);
    this.goy.enableCustomVideoCapture(true);
    com.tencent.mm.live.core.core.trtc.a.c localc = this.goA;
    if (localc != null) {
      localc.startLocalAudio();
    }
    this.goM = true;
    this.goE.d((d.g.a.b)e.gnI);
    this.goE.e((d.g.a.b)f.gnJ);
    AppMethodBeat.o(209145);
    return 0;
  }
  
  public final int cs(Context paramContext)
  {
    AppMethodBeat.i(209141);
    k.h(paramContext, "context");
    Object localObject2 = this.goL;
    Object localObject1 = this.goK;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.live.core.core.b.d)localObject1).gnU;
      if (localObject1 == null) {}
    }
    for (localObject1 = Long.valueOf(((com.tencent.mm.live.core.core.b.c)localObject1).gmP); !((com.tencent.mm.live.core.core.b.e)localObject2).b((Long)localObject1); localObject1 = null)
    {
      AppMethodBeat.o(209141);
      return -4;
    }
    final long l = bs.Gn();
    localObject1 = new SurfaceView(ai.getContext());
    ((SurfaceView)localObject1).getHolder().addCallback((SurfaceHolder.Callback)new c(this, l, (SurfaceView)localObject1));
    localObject2 = this.goE.gri;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.live.core.b.e)localObject2).grw;
      if (localObject2 != null)
      {
        ((com.tencent.mm.live.core.b.d)localObject2).grt = 0;
        ((com.tencent.mm.live.core.b.d)localObject2).grs = 0;
      }
    }
    this.goD.cw((View)localObject1);
    int i = super.cs(paramContext);
    AppMethodBeat.o(209141);
    return i;
  }
  
  public final void onEnterRoom(long paramLong)
  {
    AppMethodBeat.i(209143);
    super.onEnterRoom(paramLong);
    this.gox.post((Runnable)this.gnA);
    AppMethodBeat.o(209143);
  }
  
  public final void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(209147);
    if (paramInt == -3301)
    {
      paramBundle = com.tencent.mm.live.core.debug.a.gqF;
      com.tencent.mm.live.core.debug.a.uH("[-3301]create room fail,".concat(String.valueOf(paramString)));
      paramString = this.goH;
      if (paramString != null) {
        com.tencent.mm.live.core.core.b.a.a(paramString, paramInt);
      }
      this.goH = null;
      AppMethodBeat.o(209147);
      return;
    }
    super.onError(paramInt, paramString, paramBundle);
    AppMethodBeat.o(209147);
  }
  
  public final void release()
  {
    AppMethodBeat.i(209148);
    super.release();
    this.gox.removeCallbacks((Runnable)this.gnA);
    this.goH = null;
    this.goI = null;
    AppMethodBeat.o(209148);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-core_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(209132);
      Object localObject = com.tencent.mm.live.core.debug.a.gqF;
      localObject = b.b(this.gnD);
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.live.core.core.trtc.WXTRTCCloudImpl");
        AppMethodBeat.o(209132);
        throw ((Throwable)localObject);
      }
      com.tencent.mm.live.core.debug.a.uI(((com.tencent.mm.live.core.core.trtc.b)localObject).aiV().toString());
      b.c(this.gnD).removeCallbacks((Runnable)this);
      b.c(this.gnD).postDelayed((Runnable)this, 10000L);
      AppMethodBeat.o(209132);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$floatMode$1", "Landroid/view/SurfaceHolder$Callback;", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "plugin-core_release"})
  public static final class c
    implements SurfaceHolder.Callback
  {
    c(long paramLong, SurfaceView paramSurfaceView) {}
    
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(209133);
      ac.i("MicroMsg.LiveCoreAnchor", "float surfaceChange, holder:" + paramSurfaceHolder + ", size:[" + paramInt2 + ", " + paramInt3 + ']');
      com.tencent.mm.live.core.c.a.mG((int)bs.aO(l));
      paramSurfaceHolder = b.a(this.gnD);
      SurfaceHolder localSurfaceHolder = this.gnF.getHolder();
      k.g(localSurfaceHolder, "renderView.holder");
      paramSurfaceHolder.bE(localSurfaceHolder.getSurface());
      AppMethodBeat.o(209133);
    }
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder) {}
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(209134);
      ac.i("MicroMsg.LiveCoreAnchor", "float surface destroy");
      AppMethodBeat.o(209134);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  static final class d
    extends d.g.b.l
    implements q<j, Integer, Integer, y>
  {
    d(b paramb, long paramLong)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "mFps", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<Integer, y>
  {
    public static final e gnI;
    
    static
    {
      AppMethodBeat.i(209138);
      gnI = new e();
      AppMethodBeat.o(209138);
    }
    
    e()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "cost", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<Integer, y>
  {
    public static final f gnJ;
    
    static
    {
      AppMethodBeat.i(209140);
      gnJ = new f();
      AppMethodBeat.o(209140);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.core.a.b
 * JD-Core Version:    0.7.0.1
 */