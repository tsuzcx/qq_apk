package com.tencent.mm.live.core.core.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.b.d.i;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.live.core.view.LivePreviewView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.trtc.TRTCCloud;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "Lcom/tencent/mm/live/core/core/anchor/IMMLiveAnchorCore;", "()V", "debugRunnable", "com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1;", "endScaleAnimation", "", "time", "", "enterRoom", "callback", "Lcom/tencent/mm/live/core/core/LiveCallback;", "floatMode", "context", "Landroid/content/Context;", "forceMoveTask", "", "dontFinish", "generateType", "opType", "normalMode", "onEnterRoom", "result", "", "onError", "errCode", "errMsg", "", "extraInfo", "Landroid/os/Bundle;", "release", "startCrossLinkMic", "roomId", "username", "pkSign", "startPreview", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "startPush", "startScaleAnimation", "scale", "", "stopCrossLinkMic", "stopPush", "updateRenderMirror", "isMirror", "Companion", "plugin-core_release"})
public final class b
  extends com.tencent.mm.live.core.core.trtc.a
  implements a
{
  private static b hyu;
  public static final a hyv;
  private final b hyt;
  
  static
  {
    AppMethodBeat.i(196443);
    hyv = new a((byte)0);
    AppMethodBeat.o(196443);
  }
  
  public b()
  {
    super(true);
    AppMethodBeat.i(196442);
    this.hyt = new b(this);
    AppMethodBeat.o(196442);
  }
  
  public final int a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196432);
    p.h(paramContext, "context");
    Object localObject2 = this.hAz;
    Object localObject1 = this.hAy;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.live.core.core.b.f)localObject1).hwP;
      if (localObject1 == null) {}
    }
    for (localObject1 = Long.valueOf(((e)localObject1).liveId); !((com.tencent.mm.live.core.core.b.g)localObject2).b((Long)localObject1); localObject1 = null)
    {
      AppMethodBeat.o(196432);
      return -4;
    }
    final long l = Util.currentTicks();
    localObject1 = new TextureView(MMApplicationContext.getContext());
    ((TextureView)localObject1).setSurfaceTextureListener((TextureView.SurfaceTextureListener)new c(this, l, paramContext, (TextureView)localObject1));
    localObject2 = this.hAr.hDw;
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.live.core.b.g)localObject2).hDO;
      if (localObject2 != null)
      {
        ((com.tencent.mm.live.core.b.f)localObject2).hDL = 0;
        ((com.tencent.mm.live.core.b.f)localObject2).hDK = 0;
      }
    }
    this.hAq.co((View)localObject1);
    paramInt1 = super.a(paramContext, paramBoolean1, paramBoolean2, paramInt1, paramInt2);
    AppMethodBeat.o(196432);
    return paramInt1;
  }
  
  public final void a(com.tencent.mm.live.core.b.a parama, com.tencent.mm.live.core.b.b paramb)
  {
    AppMethodBeat.i(196439);
    a(this.hAs, parama, paramb);
    AppMethodBeat.o(196439);
  }
  
  public final void a(com.tencent.mm.live.core.core.c paramc)
  {
    AppMethodBeat.i(196433);
    p.h(paramc, "callback");
    super.a(paramc);
    paramc = com.tencent.mm.live.core.core.trtc.a.a.aDC();
    p.g(paramc, "ConfigHelper.getInstance()");
    Object localObject = paramc.aDD();
    paramc = com.tencent.mm.live.core.core.trtc.a.a.aDC();
    p.g(paramc, "ConfigHelper.getInstance()");
    paramc = paramc.aDE();
    p.g(localObject, "videoConfig");
    ((com.tencent.mm.live.core.core.trtc.a.a.d)localObject).eC(true);
    p.g(paramc, "audioConfig");
    paramc.ez(true);
    localObject = this.hAn;
    if (localObject != null) {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).startLocalAudio();
    }
    localObject = this.hAn;
    if (localObject != null)
    {
      ((com.tencent.mm.live.core.core.trtc.a.c)localObject).ey(paramc.aDQ());
      AppMethodBeat.o(196433);
      return;
    }
    AppMethodBeat.o(196433);
  }
  
  public final void aBU()
  {
    AppMethodBeat.i(196437);
    final long l = Util.currentTicks();
    super.aBU();
    LivePreviewView localLivePreviewView = this.hAs;
    if (localLivePreviewView != null)
    {
      localLivePreviewView.a((kotlin.g.a.q)new d(this, l));
      AppMethodBeat.o(196437);
      return;
    }
    AppMethodBeat.o(196437);
  }
  
  public final int aBX()
  {
    AppMethodBeat.i(196435);
    this.hAr.e(null);
    this.hAl.enableCustomVideoCapture(false);
    com.tencent.mm.live.core.core.trtc.a.c localc = this.hAn;
    if (localc != null) {
      localc.stopLocalAudio();
    }
    this.hAA = false;
    AppMethodBeat.o(196435);
    return 0;
  }
  
  public final int aBY()
  {
    AppMethodBeat.i(196436);
    this.hAl.enableCustomVideoCapture(true);
    com.tencent.mm.live.core.core.trtc.a.c localc = this.hAn;
    if (localc != null) {
      localc.startLocalAudio();
    }
    this.hAA = true;
    this.hAr.e((kotlin.g.a.b)e.hyB);
    this.hAr.f((kotlin.g.a.b)f.hyC);
    AppMethodBeat.o(196436);
    return 0;
  }
  
  public final void ew(boolean paramBoolean)
  {
    AppMethodBeat.i(196440);
    com.tencent.mm.live.core.b.d locald = this.hAr;
    locald.j((kotlin.g.a.a)new d.i(locald, paramBoolean));
    AppMethodBeat.o(196440);
  }
  
  public final void onEnterRoom(long paramLong)
  {
    AppMethodBeat.i(196434);
    super.onEnterRoom(paramLong);
    this.hAk.post((Runnable)this.hyt);
    AppMethodBeat.o(196434);
  }
  
  public final void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    AppMethodBeat.i(196438);
    if (paramInt == -3301)
    {
      paramBundle = com.tencent.mm.live.core.debug.a.hCA;
      com.tencent.mm.live.core.debug.a.GB("[-3301]create room fail,".concat(String.valueOf(paramString)));
      paramString = this.hAv;
      if (paramString != null) {
        c.a.a(paramString, paramInt);
      }
      this.hAv = null;
      AppMethodBeat.o(196438);
      return;
    }
    super.onError(paramInt, paramString, paramBundle);
    AppMethodBeat.o(196438);
  }
  
  public final void release()
  {
    AppMethodBeat.i(196441);
    super.release();
    this.hAk.removeCallbacks((Runnable)this.hyt);
    this.hAv = null;
    this.hAw = null;
    AppMethodBeat.o(196441);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore;", "TAG", "", "getInstance", "context", "Landroid/content/Context;", "hasInstance", "", "releaseInstance", "", "plugin-core_release"})
  public static final class a
  {
    public static b aDo()
    {
      AppMethodBeat.i(196418);
      if (b.aDn() == null) {
        b.d(new b());
      }
      b localb = b.aDn();
      if (localb == null) {
        p.hyc();
      }
      AppMethodBeat.o(196418);
      return localb;
    }
    
    public static boolean aDp()
    {
      AppMethodBeat.i(196419);
      if (b.aDn() != null)
      {
        AppMethodBeat.o(196419);
        return true;
      }
      AppMethodBeat.o(196419);
      return false;
    }
    
    public static void releaseInstance()
    {
      AppMethodBeat.i(196420);
      b localb = b.aDn();
      if (localb != null) {
        localb.release();
      }
      b.d(null);
      AppMethodBeat.o(196420);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$debugRunnable$1", "Ljava/lang/Runnable;", "run", "", "plugin-core_release"})
  public static final class b
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(196421);
      Object localObject = com.tencent.mm.live.core.debug.a.hCA;
      localObject = b.b(this.hyw);
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.live.core.core.trtc.WXTRTCCloudImpl");
        AppMethodBeat.o(196421);
        throw ((Throwable)localObject);
      }
      com.tencent.mm.live.core.debug.a.GC(((com.tencent.mm.live.core.core.trtc.b)localObject).aDA().toString());
      b.c(this.hyw).removeCallbacks((Runnable)this);
      b.c(this.hyw).postDelayed((Runnable)this, 10000L);
      AppMethodBeat.o(196421);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/core/core/anchor/LiveAnchorTRTCCore$floatMode$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-core_release"})
  public static final class c
    implements TextureView.SurfaceTextureListener
  {
    c(long paramLong, Context paramContext, TextureView paramTextureView) {}
    
    public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(196424);
      Log.i("MicroMsg.LiveCoreAnchor", "float onSurfaceTextureAvailable, surface:" + paramSurfaceTexture + ", size:[" + paramInt1 + ", " + paramInt2 + ']');
      com.tencent.mm.live.core.c.a.qA((int)Util.ticksToNow(l));
      int j = au.az(this.$context).x;
      int i = au.az(this.$context).y;
      if (j > i) {}
      for (;;)
      {
        float f;
        int m;
        if (paramInt1 < paramInt2)
        {
          f = paramInt1;
          m = (int)(j / i * f);
          k = paramInt1;
        }
        for (;;)
        {
          b.a(this.hyw).bO(this.hyy.getSurfaceTexture());
          b.a(this.hyw).cX(k, m);
          AppMethodBeat.o(196424);
          return;
          if (i <= j) {
            break label209;
          }
          k = i;
          i = j;
          j = k;
          break;
          k = paramInt1;
          m = paramInt2;
          if (paramInt2 < paramInt1)
          {
            f = paramInt2;
            k = (int)(j / i * f);
            m = paramInt2;
          }
        }
        label209:
        int k = i;
        i = j;
        j = k;
      }
    }
    
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(196423);
      Log.i("MicroMsg.LiveCoreAnchor", "float onSurfaceTextureDestroyed");
      AppMethodBeat.o(196423);
      return false;
    }
    
    public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(196422);
      Log.i("MicroMsg.LiveCoreAnchor", "float onSurfaceTextureSizeChanged, surface:" + paramSurfaceTexture + ", size:[" + paramInt1 + ", " + paramInt2 + ']');
      b.a(this.hyw).cX(paramInt1, paramInt2);
      AppMethodBeat.o(196422);
    }
    
    public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "surface", "Lcom/tencent/mm/live/core/render/RenderSurfaceHolder;", "i", "", "i1", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.q<com.tencent.mm.live.core.b.l, Integer, Integer, x>
  {
    d(b paramb, long paramLong)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "mFps", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, x>
  {
    public static final e hyB;
    
    static
    {
      AppMethodBeat.i(196429);
      hyB = new e();
      AppMethodBeat.o(196429);
    }
    
    e()
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "cost", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Integer, x>
  {
    public static final f hyC;
    
    static
    {
      AppMethodBeat.i(196431);
      hyC = new f();
      AppMethodBeat.o(196431);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.core.a.b
 * JD-Core Version:    0.7.0.1
 */