package com.tencent.mm.live.core.b;

import android.opengl.EGLSurface;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aq.a;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/render/LiveVisitorRenderSurface;", "Lcom/tencent/trtc/TRTCCloudListener$TRTCVideoRenderListener;", "Lcom/tencent/mm/live/core/render/LiveRenderSurface;", "userId", "", "streamType", "", "(Ljava/lang/String;I)V", "eGLSurface", "Landroid/opengl/EGLSurface;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eglThread", "Landroid/os/HandlerThread;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "noSurface", "", "outputSurface", "", "outputSurfaceChange", "renderer", "Lcom/tencent/mm/live/core/render/LiveVisitorRenderer;", "getStreamType", "()I", "setStreamType", "(I)V", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "initRenderer", "", "makeEGLEnvironment", "makeOutputSurface", "onRenderVideoFrame", "frame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "queue", "callback", "Lkotlin/Function0;", "release", "renderFrame", "setOutputSurface", "surface", "unsetOutputSurface", "updateDrawSize", "width", "height", "Companion", "plugin-core_release"})
public final class f
  implements TRTCCloudListener.TRTCVideoRenderListener
{
  public static final f.a gOh;
  private Object gNA;
  private final HandlerThread gNv;
  private c.b gNx;
  private EGLSurface gOd;
  private boolean gOe;
  private h gOf;
  private boolean gOg;
  private aq handler;
  public int streamType;
  public String userId;
  
  static
  {
    AppMethodBeat.i(196996);
    gOh = new f.a((byte)0);
    AppMethodBeat.o(196996);
  }
  
  public f(String paramString)
  {
    AppMethodBeat.i(196995);
    this.userId = paramString;
    this.streamType = 0;
    paramString = d.hg("MicroMsg.LiveCoreVisitor_render", 10);
    p.g(paramString, "SpecialThreadFactory.cre…er\", Thread.MAX_PRIORITY)");
    this.gNv = paramString;
    this.gOg = true;
    this.gNv.start();
    this.handler = new aq(this.gNv.getLooper(), (aq.a)new f.1(this));
    j((a)new c(this));
    j((a)new b(this));
    AppMethodBeat.o(196995);
  }
  
  private void j(a<z> parama)
  {
    AppMethodBeat.i(196989);
    this.handler.post((Runnable)new g(parama));
    AppMethodBeat.o(196989);
  }
  
  public final void amK()
  {
    AppMethodBeat.i(196991);
    j((a)new f(this));
    AppMethodBeat.o(196991);
  }
  
  public final void bG(final Object paramObject)
  {
    AppMethodBeat.i(196990);
    ae.i("MicroMsg.LiveCoreVisitor", "setOutputSurface:".concat(String.valueOf(paramObject)));
    j((a)new e(this, paramObject));
    AppMethodBeat.o(196990);
  }
  
  public final void cS(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(196993);
    j((a)new g(this, paramInt1, paramInt2));
    AppMethodBeat.o(196993);
  }
  
  public final void onRenderVideoFrame(String paramString, int paramInt, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    AppMethodBeat.i(196992);
    if (((p.i(paramString, this.userId) ^ true)) || (paramInt != this.streamType))
    {
      AppMethodBeat.o(196992);
      return;
    }
    this.handler.obtainMessage(1024, paramTRTCVideoFrame).sendToTarget();
    AppMethodBeat.o(196992);
  }
  
  public final void release()
  {
    AppMethodBeat.i(196994);
    j((a)new d(this));
    AppMethodBeat.o(196994);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<z>
  {
    b(f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<z>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<z>
  {
    d(f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<z>
  {
    e(f paramf, Object paramObject)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<z>
  {
    f(f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements a<z>
  {
    g(f paramf, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.b.f
 * JD-Core Version:    0.7.0.1
 */