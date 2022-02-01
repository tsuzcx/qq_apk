package com.tencent.mm.live.core.b;

import android.opengl.EGLSurface;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/render/LiveVisitorRenderSurface;", "Lcom/tencent/trtc/TRTCCloudListener$TRTCVideoRenderListener;", "Lcom/tencent/mm/live/core/render/LiveRenderSurface;", "userId", "", "streamType", "", "(Ljava/lang/String;I)V", "eGLSurface", "Landroid/opengl/EGLSurface;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eglThread", "Landroid/os/HandlerThread;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "noSurface", "", "outputSurface", "", "outputSurfaceChange", "renderer", "Lcom/tencent/mm/live/core/render/LiveVisitorRenderer;", "getStreamType", "()I", "setStreamType", "(I)V", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "initRenderer", "", "makeEGLEnvironment", "makeOutputSurface", "onRenderVideoFrame", "frame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "queue", "callback", "Lkotlin/Function0;", "release", "renderFrame", "setOutputSurface", "surface", "unsetOutputSurface", "updateDrawSize", "width", "height", "Companion", "plugin-core_release"})
public final class f
  implements TRTCCloudListener.TRTCVideoRenderListener
{
  public static final f.a gLy;
  private final HandlerThread gKM;
  private c.b gKO;
  private Object gKR;
  private EGLSurface gLu;
  private boolean gLv;
  private h gLw;
  private boolean gLx;
  private ap handler;
  public int streamType;
  public String userId;
  
  static
  {
    AppMethodBeat.i(216984);
    gLy = new f.a((byte)0);
    AppMethodBeat.o(216984);
  }
  
  public f(String paramString)
  {
    AppMethodBeat.i(216983);
    this.userId = paramString;
    this.streamType = 0;
    paramString = d.gX("MicroMsg.LiveCoreVisitor_render", 10);
    p.g(paramString, "SpecialThreadFactory.cre…er\", Thread.MAX_PRIORITY)");
    this.gKM = paramString;
    this.gLx = true;
    this.gKM.start();
    this.handler = new ap(this.gKM.getLooper(), (ap.a)new f.1(this));
    i((a)new c(this));
    i((a)new f.b(this));
    AppMethodBeat.o(216983);
  }
  
  private void i(a<z> parama)
  {
    AppMethodBeat.i(216977);
    this.handler.post((Runnable)new g(parama));
    AppMethodBeat.o(216977);
  }
  
  public final void amv()
  {
    AppMethodBeat.i(216979);
    i((a)new f(this));
    AppMethodBeat.o(216979);
  }
  
  public final void bG(final Object paramObject)
  {
    AppMethodBeat.i(216978);
    ad.i("MicroMsg.LiveCoreVisitor", "setOutputSurface:".concat(String.valueOf(paramObject)));
    i((a)new e(this, paramObject));
    AppMethodBeat.o(216978);
  }
  
  public final void cS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216981);
    i((a)new f.g(this, paramInt1, paramInt2));
    AppMethodBeat.o(216981);
  }
  
  public final void onRenderVideoFrame(String paramString, int paramInt, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    AppMethodBeat.i(216980);
    if (((p.i(paramString, this.userId) ^ true)) || (paramInt != this.streamType))
    {
      AppMethodBeat.o(216980);
      return;
    }
    this.handler.obtainMessage(1024, paramTRTCVideoFrame).sendToTarget();
    AppMethodBeat.o(216980);
  }
  
  public final void release()
  {
    AppMethodBeat.i(216982);
    i((a)new d(this));
    AppMethodBeat.o(216982);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<z>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<z>
  {
    d(f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<z>
  {
    e(f paramf, Object paramObject)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<z>
  {
    f(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.b.f
 * JD-Core Version:    0.7.0.1
 */