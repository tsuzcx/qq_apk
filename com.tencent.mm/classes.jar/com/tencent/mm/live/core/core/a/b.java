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
import d.g.a.q;
import d.g.b.k;
import d.v;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "debugRunnable", "com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1;", "endScaleAnimation", "", "time", "", "enterRoom", "callback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "floatMode", "normalMode", "onEnterRoom", "result", "", "onError", "errCode", "errMsg", "", "extraInfo", "Landroid/os/Bundle;", "release", "startPush", "startScaleAnimation", "scale", "", "stopPush", "Companion", "plugin-core_release"})
public final class b
  extends com.tencent.mm.live.core.core.trtc.a
  implements a
{
  private static b qyl;
  public static final a qym;
  private final b qyk;
  
  static
  {
    AppMethodBeat.i(205617);
    qym = new a((byte)0);
    AppMethodBeat.o(205617);
  }
  
  public b(Context paramContext)
  {
    super(paramContext, true);
    AppMethodBeat.i(205616);
    this.qyk = new b(this);
    AppMethodBeat.o(205616);
  }
  
  public final void a(com.tencent.mm.live.core.core.b paramb)
  {
    AppMethodBeat.i(205609);
    k.h(paramb, "callback");
    super.a(paramb);
    paramb = com.tencent.mm.live.core.core.trtc.a.a.cpE();
    k.g(paramb, "ConfigHelper.getInstance()");
    Object localObject = paramb.cpF();
    paramb = com.tencent.mm.live.core.core.trtc.a.a.cpE();
    k.g(paramb, "ConfigHelper.getInstance()");
    paramb = paramb.cpP();
    k.g(localObject, "videoConfig");
    ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).kP(true);
    k.g(paramb, "audioConfig");
    paramb.kd(true);
    localObject = this.qDT;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).startLocalAudio();
    }
    localObject = this.qDT;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).hC(paramb.crp());
    }
    paramb = this.qDT;
    if (paramb != null)
    {
      paramb.cqb();
      AppMethodBeat.o(205609);
      return;
    }
    AppMethodBeat.o(205609);
  }
  
  public final int clG()
  {
    AppMethodBeat.i(205611);
    this.qDj.enableCustomVideoCapture(false);
    com.tencent.mm.live.core.core.trtc.a.c localc = this.qDT;
    if (localc != null) {
      localc.stopLocalAudio();
    }
    this.qEg = false;
    AppMethodBeat.o(205611);
    return 0;
  }
  
  public final int clI()
  {
    AppMethodBeat.i(205612);
    this.qDj.enableCustomVideoCapture(true);
    com.tencent.mm.live.core.core.trtc.a.c localc = this.qDT;
    if (localc != null) {
      localc.startLocalAudio();
    }
    this.qEg = true;
    this.qDX.v((d.g.a.b)e.qyD);
    this.qDX.D((d.g.a.b)f.qyE);
    AppMethodBeat.o(205612);
    return 0;
  }
  
  public final void clo()
  {
    AppMethodBeat.i(205613);
    final long l = bt.GC();
    super.clo();
    LivePreviewView localLivePreviewView = this.qDY;
    if (localLivePreviewView != null)
    {
      localLivePreviewView.c((q)new d(this, l));
      AppMethodBeat.o(205613);
      return;
    }
    AppMethodBeat.o(205613);
  }
  
  public final int eE(Context paramContext)
  {
    AppMethodBeat.i(205608);
    k.h(paramContext, "context");
    Object localObject2 = this.qEd;
    Object localObject1 = this.qEc;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.live.core.core.b.d)localObject1).qzr;
      if (localObject1 == null) {}
    }
    for (localObject1 = Long.valueOf(((com.tencent.mm.live.core.core.b.c)localObject1).DlB); !((com.tencent.mm.live.core.core.b.e)localObject2).h((Long)localObject1); localObject1 = null)
    {
      AppMethodBeat.o(205608);
      return -4;
    }
    long l = bt.GC();
    localObject1 = new SurfaceView(aj.getContext());
    ((SurfaceView)localObject1).getHolder().addCallback((SurfaceHolder.Callback)new c(l));
    localObject2 = this.qDX.qQa;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.live.core.b.e)localObject2).qSM;
      if (localObject2 != null)
      {
        ((com.tencent.mm.live.core.b.d)localObject2).qSK = 0;
        ((com.tencent.mm.live.core.b.d)localObject2).qSJ = 0;
      }
    }
    this.qDW.cV((View)localObject1);
    localObject2 = this.qDX;
    localObject1 = ((SurfaceView)localObject1).getHolder();
    k.g(localObject1, "renderView.holder");
    ((com.tencent.mm.live.core.b.b)localObject2).gc(((SurfaceHolder)localObject1).getSurface());
    int i = super.eE(paramContext);
    AppMethodBeat.o(205608);
    return i;
  }
  
  public final void onEnterRoom(long paramLong)
  {
    AppMethodBeat.i(205610);
    super.onEnterRoom(paramLong);
    this.gAC.post((Runnable)this.qyk);
    AppMethodBeat.o(205610);
  }
  
  public final void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(205614);
    if (paramInt == -3301)
    {
      paramBundle = com.tencent.mm.live.core.debug.a.qOL;
      com.tencent.mm.live.core.debug.a.aUd("[-3301]create room fail,".concat(String.valueOf(paramString)));
      paramString = this.qDZ;
      if (paramString != null) {
        com.tencent.mm.live.core.core.b.a.a(paramString, paramInt);
      }
      this.qDZ = null;
      AppMethodBeat.o(205614);
      return;
    }
    super.onError(paramInt, paramString, paramBundle);
    AppMethodBeat.o(205614);
  }
  
  public final void release()
  {
    AppMethodBeat.i(205615);
    super.release();
    this.gAC.removeCallbacks((Runnable)this.qyk);
    this.qDZ = null;
    this.qEa = null;
    AppMethodBeat.o(205615);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "TAG", "", "getInstance", "context", "Landroid/content/Context;", "hasInstance", "", "releaseInstance", "", "plugin-core_release"})
  public static final class a
  {
    public static boolean cnr()
    {
      AppMethodBeat.i(205597);
      if (b.cnq() != null)
      {
        AppMethodBeat.o(205597);
        return true;
      }
      AppMethodBeat.o(205597);
      return false;
    }
    
    public static b eG(Context paramContext)
    {
      AppMethodBeat.i(205596);
      k.h(paramContext, "context");
      if (b.cnq() == null) {
        b.d(new b(paramContext));
      }
      paramContext = b.cnq();
      if (paramContext == null) {
        k.fvU();
      }
      AppMethodBeat.o(205596);
      return paramContext;
    }
    
    public static void releaseInstance()
    {
      AppMethodBeat.i(205598);
      b localb = b.cnq();
      if (localb != null) {
        localb.release();
      }
      b.d(null);
      AppMethodBeat.o(205598);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-core_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(205599);
      Object localObject = com.tencent.mm.live.core.debug.a.qOL;
      localObject = b.b(this.qyn);
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.live.core.core.trtc.WXTRTCCloudImpl");
        AppMethodBeat.o(205599);
        throw ((Throwable)localObject);
      }
      com.tencent.mm.live.core.debug.a.aUe(((com.tencent.mm.live.core.core.trtc.b)localObject).coS().toString());
      b.c(this.qyn).removeCallbacks((Runnable)this);
      b.c(this.qyn).postDelayed((Runnable)this, 10000L);
      AppMethodBeat.o(205599);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$floatMode$1", "Landroid/view/SurfaceHolder$Callback;", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "plugin-core_release"})
  public static final class c
    implements SurfaceHolder.Callback
  {
    c(long paramLong) {}
    
    public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(205600);
      ad.i("MicroMsg.LiveCoreAnchor", "float surfaceChange, holder:" + paramSurfaceHolder + ", size:[" + paramInt2 + ", " + paramInt3 + ']');
      com.tencent.mm.live.core.c.a.CP((int)bt.aS(this.qyt));
      AppMethodBeat.o(205600);
    }
    
    public final void surfaceCreated(SurfaceHolder paramSurfaceHolder) {}
    
    public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
    {
      AppMethodBeat.i(205601);
      ad.i("MicroMsg.LiveCoreAnchor", "float surface destroy");
      AppMethodBeat.o(205601);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  static final class d
    extends d.g.b.l
    implements q<j, Integer, Integer, y>
  {
    d(b paramb, long paramLong)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "mFps", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<Integer, y>
  {
    public static final e qyD;
    
    static
    {
      AppMethodBeat.i(205605);
      qyD = new e();
      AppMethodBeat.o(205605);
    }
    
    e()
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "cost", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<Integer, y>
  {
    public static final f qyE;
    
    static
    {
      AppMethodBeat.i(205607);
      qyE = new f();
      AppMethodBeat.o(205607);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.a.b
 * JD-Core Version:    0.7.0.1
 */