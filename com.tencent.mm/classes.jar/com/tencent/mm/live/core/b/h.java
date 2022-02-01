package com.tencent.mm.live.core.b;

import android.opengl.EGLSurface;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandler.Callback;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/render/LiveVisitorRenderSurface;", "Lcom/tencent/trtc/TRTCCloudListener$TRTCVideoRenderListener;", "Lcom/tencent/mm/live/core/render/LiveRenderSurface;", "userId", "", "streamType", "", "(Ljava/lang/String;I)V", "eGLSurface", "Landroid/opengl/EGLSurface;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eglThread", "Landroid/os/HandlerThread;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "noSurface", "", "outputSurface", "", "outputSurfaceChange", "renderMode", "renderer", "Lcom/tencent/mm/live/core/render/LiveVisitorRenderer;", "getStreamType", "()I", "setStreamType", "(I)V", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "initRenderer", "", "makeEGLEnvironment", "makeOutputSurface", "onRenderVideoFrame", "frame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "queue", "callback", "Lkotlin/Function0;", "release", "renderFrame", "setOutputSurface", "surface", "unsetOutputSurface", "updateDrawSize", "width", "height", "updateRenderMode", "Companion", "plugin-core_release"})
public final class h
  implements TRTCCloudListener.TRTCVideoRenderListener
{
  public static final h.a hEj;
  private final HandlerThread hDq;
  private c.b hDs;
  private Object hDv;
  private EGLSurface hEe;
  private boolean hEf;
  private j hEg;
  private boolean hEh;
  private int hEi;
  private MMHandler handler;
  public int streamType;
  public String userId;
  
  static
  {
    AppMethodBeat.i(196684);
    hEj = new h.a((byte)0);
    AppMethodBeat.o(196684);
  }
  
  public h(String paramString)
  {
    AppMethodBeat.i(196683);
    this.userId = paramString;
    this.streamType = 0;
    paramString = d.hA("MicroMsg.LiveCoreVisitor_render", 10);
    p.g(paramString, "SpecialThreadFactory.cre…er\", Thread.MAX_PRIORITY)");
    this.hDq = paramString;
    this.hEh = true;
    this.hEi = 2;
    this.hDq.start();
    this.handler = new MMHandler(this.hDq.getLooper(), (MMHandler.Callback)new h.1(this));
    k((a)new c(this));
    k((a)new h.b(this));
    AppMethodBeat.o(196683);
  }
  
  private void k(a<x> parama)
  {
    AppMethodBeat.i(196676);
    this.handler.post((Runnable)new i(parama));
    AppMethodBeat.o(196676);
  }
  
  public final void aEG()
  {
    AppMethodBeat.i(196678);
    k((a)new f(this));
    AppMethodBeat.o(196678);
  }
  
  public final void bO(final Object paramObject)
  {
    AppMethodBeat.i(196677);
    Log.i("MicroMsg.LiveCoreVisitor", "setOutputSurface:".concat(String.valueOf(paramObject)));
    k((a)new e(this, paramObject));
    AppMethodBeat.o(196677);
  }
  
  public final void cX(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(196681);
    k((a)new g(this, paramInt1, paramInt2));
    AppMethodBeat.o(196681);
  }
  
  public final void onRenderVideoFrame(String paramString, int paramInt, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    AppMethodBeat.i(196679);
    if (((p.j(paramString, this.userId) ^ true)) || (paramInt != this.streamType))
    {
      AppMethodBeat.o(196679);
      return;
    }
    this.handler.obtainMessage(1024, paramTRTCVideoFrame).sendToTarget();
    AppMethodBeat.o(196679);
  }
  
  public final void qy(final int paramInt)
  {
    AppMethodBeat.i(196680);
    k((a)new h(this, paramInt));
    AppMethodBeat.o(196680);
  }
  
  public final void release()
  {
    AppMethodBeat.i(196682);
    k((a)new d(this));
    AppMethodBeat.o(196682);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(h paramh)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(h paramh)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<x>
  {
    e(h paramh, Object paramObject)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<x>
  {
    f(h paramh)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements a<x>
  {
    g(h paramh, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements a<x>
  {
    h(h paramh, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.b.h
 * JD-Core Version:    0.7.0.1
 */