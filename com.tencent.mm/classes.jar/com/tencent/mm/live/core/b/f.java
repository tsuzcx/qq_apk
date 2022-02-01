package com.tencent.mm.live.core.b;

import android.opengl.EGLSurface;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.a;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener;
import d.g.a.a;
import d.g.b.k;
import d.v;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/render/LiveVisitorRenderSurface;", "Lcom/tencent/trtc/TRTCCloudListener$TRTCVideoRenderListener;", "Lcom/tencent/mm/live/core/render/LiveRenderSurface;", "userId", "", "streamType", "", "(Ljava/lang/String;I)V", "eGLSurface", "Landroid/opengl/EGLSurface;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eglThread", "Landroid/os/HandlerThread;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "noSurface", "", "outputSurface", "", "outputSurfaceChange", "renderer", "Lcom/tencent/mm/live/core/render/LiveVisitorRenderer;", "getStreamType", "()I", "setStreamType", "(I)V", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "initRenderer", "", "makeEGLEnvironment", "makeOutputSurface", "onRenderVideoFrame", "frame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "queue", "callback", "Lkotlin/Function0;", "release", "renderFrame", "setOutputSurface", "surface", "unsetOutputSurface", "updateDrawSize", "width", "height", "Companion", "plugin-core_release"})
public final class f
  implements TRTCCloudListener.TRTCVideoRenderListener
{
  public static final f.a grQ;
  private EGLSurface grM;
  private boolean grN;
  private h grO;
  private boolean grP;
  private final HandlerThread grc;
  private c.b gre;
  private Object grh;
  private ao handler;
  public int streamType;
  public String userId;
  
  static
  {
    AppMethodBeat.i(209326);
    grQ = new f.a((byte)0);
    AppMethodBeat.o(209326);
  }
  
  public f(String paramString)
  {
    AppMethodBeat.i(209325);
    this.userId = paramString;
    this.streamType = 0;
    paramString = d.gz("MicroMsg.LiveCoreVisitor_render", 10);
    k.g(paramString, "SpecialThreadFactory.cre…er\", Thread.MAX_PRIORITY)");
    this.grc = paramString;
    this.grP = true;
    this.grc.start();
    this.handler = new ao(this.grc.getLooper(), (ao.a)new ao.a()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(209311);
        if (paramAnonymousMessage.what == 1024)
        {
          f localf = this.grR;
          paramAnonymousMessage = paramAnonymousMessage.obj;
          if (paramAnonymousMessage == null)
          {
            paramAnonymousMessage = new v("null cannot be cast to non-null type com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame");
            AppMethodBeat.o(209311);
            throw paramAnonymousMessage;
          }
          f.a(localf, (TRTCCloudDef.TRTCVideoFrame)paramAnonymousMessage);
        }
        AppMethodBeat.o(209311);
        return true;
      }
    });
    i((a)new c(this));
    i((a)new b(this));
    AppMethodBeat.o(209325);
  }
  
  private void i(a<y> parama)
  {
    AppMethodBeat.i(209319);
    this.handler.post((Runnable)new g(parama));
    AppMethodBeat.o(209319);
  }
  
  public final void ajJ()
  {
    AppMethodBeat.i(209321);
    i((a)new f(this));
    AppMethodBeat.o(209321);
  }
  
  public final void bE(final Object paramObject)
  {
    AppMethodBeat.i(209320);
    ac.i("MicroMsg.LiveCoreVisitor", "setOutputSurface:".concat(String.valueOf(paramObject)));
    i((a)new e(this, paramObject));
    AppMethodBeat.o(209320);
  }
  
  public final void cQ(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(209323);
    i((a)new g(this, paramInt1, paramInt2));
    AppMethodBeat.o(209323);
  }
  
  public final void onRenderVideoFrame(String paramString, int paramInt, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    AppMethodBeat.i(209322);
    if (((k.g(paramString, this.userId) ^ true)) || (paramInt != this.streamType))
    {
      AppMethodBeat.o(209322);
      return;
    }
    this.handler.obtainMessage(1024, paramTRTCVideoFrame).sendToTarget();
    AppMethodBeat.o(209322);
  }
  
  public final void release()
  {
    AppMethodBeat.i(209324);
    i((a)new d(this));
    AppMethodBeat.o(209324);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<y>
  {
    b(f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<y>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements a<y>
  {
    d(f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements a<y>
  {
    e(f paramf, Object paramObject)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements a<y>
  {
    f(f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.b.f
 * JD-Core Version:    0.7.0.1
 */