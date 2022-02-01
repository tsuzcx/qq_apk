package com.tencent.mm.live.core.b;

import android.opengl.EGLSurface;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.e.c.d;
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
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/render/LiveVisitorRenderSurface;", "Lcom/tencent/trtc/TRTCCloudListener$TRTCVideoRenderListener;", "Lcom/tencent/mm/live/core/render/LiveRenderSurface;", "userId", "", "streamType", "", "(Ljava/lang/String;I)V", "eGLSurface", "Landroid/opengl/EGLSurface;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eglThread", "Landroid/os/HandlerThread;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "noSurface", "", "outputSurface", "", "outputSurfaceChange", "renderMode", "renderer", "Lcom/tencent/mm/live/core/render/LiveVisitorRenderer;", "getStreamType", "()I", "setStreamType", "(I)V", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "initRenderer", "", "makeEGLEnvironment", "makeOutputSurface", "onRenderVideoFrame", "frame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "queue", "callback", "Lkotlin/Function0;", "release", "renderFrame", "setOutputSurface", "surface", "unsetOutputSurface", "updateDrawSize", "width", "height", "updateRenderMode", "Companion", "plugin-core_release"})
public final class j
  implements TRTCCloudListener.TRTCVideoRenderListener
{
  public static final a kso;
  private MMHandler handler;
  private final HandlerThread krj;
  private c.b krl;
  private Object kro;
  private EGLSurface ksj;
  private boolean ksk;
  private l ksl;
  private boolean ksm;
  private int ksn;
  public int streamType;
  public String userId;
  
  static
  {
    AppMethodBeat.i(200938);
    kso = new a((byte)0);
    AppMethodBeat.o(200938);
  }
  
  public j(String paramString)
  {
    AppMethodBeat.i(200936);
    this.userId = paramString;
    this.streamType = 0;
    paramString = d.ik("MicroMsg.LiveCoreVisitor_render", 10);
    p.j(paramString, "SpecialThreadFactory.cre…er\", Thread.MAX_PRIORITY)");
    this.krj = paramString;
    this.ksm = true;
    this.ksn = 2;
    this.krj.start();
    this.handler = new MMHandler(this.krj.getLooper(), (MMHandler.Callback)new MMHandler.Callback()
    {
      public final boolean handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(200497);
        if (paramAnonymousMessage.what == 1024)
        {
          j localj = this.ksp;
          paramAnonymousMessage = paramAnonymousMessage.obj;
          if (paramAnonymousMessage == null)
          {
            paramAnonymousMessage = new t("null cannot be cast to non-null type com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame");
            AppMethodBeat.o(200497);
            throw paramAnonymousMessage;
          }
          j.a(localj, (TRTCCloudDef.TRTCVideoFrame)paramAnonymousMessage);
        }
        AppMethodBeat.o(200497);
        return true;
      }
    });
    j((a)new c(this));
    j((a)new b(this));
    AppMethodBeat.o(200936);
  }
  
  private void j(a<x> parama)
  {
    AppMethodBeat.i(200916);
    this.handler.post((Runnable)new k(parama));
    AppMethodBeat.o(200916);
  }
  
  public final void aMX()
  {
    AppMethodBeat.i(200922);
    j((a)new f(this));
    AppMethodBeat.o(200922);
  }
  
  public final void bO(final Object paramObject)
  {
    AppMethodBeat.i(200919);
    Log.i("MicroMsg.LiveCoreVisitor", "setOutputSurface:".concat(String.valueOf(paramObject)));
    j((a)new e(this, paramObject));
    AppMethodBeat.o(200919);
  }
  
  public final void dt(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(200930);
    j((a)new g(this, paramInt1, paramInt2));
    AppMethodBeat.o(200930);
  }
  
  public final void onRenderVideoFrame(String paramString, int paramInt, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    AppMethodBeat.i(200925);
    if (((p.h(paramString, this.userId) ^ true)) || (paramInt != this.streamType))
    {
      AppMethodBeat.o(200925);
      return;
    }
    this.handler.obtainMessage(1024, paramTRTCVideoFrame).sendToTarget();
    AppMethodBeat.o(200925);
  }
  
  public final void release()
  {
    AppMethodBeat.i(200933);
    j((a)new d(this));
    AppMethodBeat.o(200933);
  }
  
  public final void tn(final int paramInt)
  {
    AppMethodBeat.i(200928);
    j((a)new h(this, paramInt));
    AppMethodBeat.o(200928);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/render/LiveVisitorRenderSurface$Companion;", "", "()V", "RENDER_MSG", "", "TAG", "", "plugin-core_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(j paramj)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(j paramj)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(j paramj)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements a<x>
  {
    e(j paramj, Object paramObject)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements a<x>
  {
    f(j paramj)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements a<x>
  {
    g(j paramj, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements a<x>
  {
    h(j paramj, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.b.j
 * JD-Core Version:    0.7.0.1
 */