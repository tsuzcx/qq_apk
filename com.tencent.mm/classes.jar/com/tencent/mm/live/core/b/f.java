package com.tencent.mm.live.core.b;

import android.opengl.EGLSurface;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener;
import d.g.a.a;
import d.g.b.k;
import d.v;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/render/LiveVisitorRenderSurface;", "Lcom/tencent/trtc/TRTCCloudListener$TRTCVideoRenderListener;", "Lcom/tencent/mm/live/core/render/LiveRenderSurface;", "userId", "", "streamType", "", "(Ljava/lang/String;I)V", "eGLSurface", "Landroid/opengl/EGLSurface;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eglThread", "Landroid/os/HandlerThread;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "noSurface", "", "outputSurface", "", "outputSurfaceChange", "renderer", "Lcom/tencent/mm/live/core/render/LiveVisitorRenderer;", "getStreamType", "()I", "setStreamType", "(I)V", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "initRenderer", "", "makeEGLEnvironment", "makeOutputSurface", "onRenderVideoFrame", "frame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "queue", "callback", "Lkotlin/Function0;", "release", "renderFrame", "setOutputSurface", "surface", "unsetOutputSurface", "updateDrawSize", "width", "height", "Companion", "plugin-core_release"})
public final class f
  implements TRTCCloudListener.TRTCVideoRenderListener
{
  public static final a qTX;
  private c.b gsl;
  private ap handler;
  private final HandlerThread qPJ;
  private Object qPU;
  private EGLSurface qTJ;
  private boolean qTK;
  private h qTT;
  private boolean qTW;
  public int streamType;
  public String userId;
  
  static
  {
    AppMethodBeat.i(205788);
    qTX = new a((byte)0);
    AppMethodBeat.o(205788);
  }
  
  public f(String paramString)
  {
    AppMethodBeat.i(205787);
    this.userId = paramString;
    this.streamType = 0;
    paramString = d.gv("MicroMsg.LiveCoreVisitor_render", 10);
    k.g(paramString, "SpecialThreadFactory.cre…er\", Thread.MAX_PRIORITY)");
    this.qPJ = paramString;
    this.qTW = true;
    this.qPJ.start();
    this.handler = new ap(this.qPJ.getLooper(), (ap.a)new ap.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(205774);
        if (paramAnonymousMessage.what == 1024)
        {
          f localf = this.qTY;
          paramAnonymousMessage = paramAnonymousMessage.obj;
          if (paramAnonymousMessage == null)
          {
            paramAnonymousMessage = new v("null cannot be cast to non-null type com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame");
            AppMethodBeat.o(205774);
            throw paramAnonymousMessage;
          }
          f.a(localf, (TRTCCloudDef.TRTCVideoFrame)paramAnonymousMessage);
        }
        AppMethodBeat.o(205774);
        return true;
      }
    });
    i((a)new c(this));
    i((a)new b(this));
    AppMethodBeat.o(205787);
  }
  
  public final void cAi()
  {
    AppMethodBeat.i(205784);
    i((a)new f(this));
    AppMethodBeat.o(205784);
  }
  
  public final void cR(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(205786);
    i((a)new g(this, paramInt1, paramInt2));
    AppMethodBeat.o(205786);
  }
  
  public final void gc(final Object paramObject)
  {
    AppMethodBeat.i(205783);
    ad.i("MicroMsg.LiveCoreVisitor", "setOutputSurface:".concat(String.valueOf(paramObject)));
    i((a)new e(this, paramObject));
    AppMethodBeat.o(205783);
  }
  
  public final void i(a<y> parama)
  {
    AppMethodBeat.i(205782);
    this.handler.post((Runnable)new g(parama));
    AppMethodBeat.o(205782);
  }
  
  public final void onRenderVideoFrame(String paramString, int paramInt, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    AppMethodBeat.i(205785);
    if (((k.g(paramString, this.userId) ^ true)) || (paramInt != this.streamType))
    {
      AppMethodBeat.o(205785);
      return;
    }
    this.handler.obtainMessage(1024, paramTRTCVideoFrame).sendToTarget();
    AppMethodBeat.o(205785);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/render/LiveVisitorRenderSurface$Companion;", "", "()V", "RENDER_MSG", "", "TAG", "", "plugin-core_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<y>
  {
    b(f paramf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<y>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class d
    extends d.g.b.l
    implements a<y>
  {
    public d(f paramf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements a<y>
  {
    e(f paramf, Object paramObject)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements a<y>
  {
    f(f paramf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements a<y>
  {
    g(f paramf, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.b.f
 * JD-Core Version:    0.7.0.1
 */