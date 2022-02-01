package com.tencent.mm.live.core.b;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloudDef.TRTCTexture;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame;
import com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/render/LiveVisitorRenderSurface;", "Lcom/tencent/trtc/TRTCCloudListener$TRTCVideoRenderListener;", "Lcom/tencent/mm/live/core/render/LiveRenderSurface;", "userId", "", "streamType", "", "(Ljava/lang/String;I)V", "eGLSurface", "Landroid/opengl/EGLSurface;", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eglThread", "Landroid/os/HandlerThread;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "noSurface", "", "outputSurface", "", "outputSurfaceChange", "renderMode", "renderer", "Lcom/tencent/mm/live/core/render/LiveVisitorRenderer;", "getStreamType", "()I", "setStreamType", "(I)V", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "initRenderer", "", "makeEGLEnvironment", "makeOutputSurface", "onRenderVideoFrame", "frame", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoFrame;", "queue", "callback", "Lkotlin/Function0;", "release", "renderFrame", "setOutputSurface", "surface", "unsetOutputSurface", "updateDrawSize", "width", "height", "updateRenderMode", "Companion", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements TRTCCloudListener.TRTCVideoRenderListener
{
  public static final h.a mWb;
  private MMHandler handler;
  private final HandlerThread mVg;
  private c.b mVi;
  private Object mVl;
  private EGLSurface mWc;
  private boolean mWd;
  private i mWe;
  private boolean mWf;
  private int mWg;
  public int streamType;
  public String userId;
  
  static
  {
    AppMethodBeat.i(247816);
    mWb = new h.a((byte)0);
    AppMethodBeat.o(247816);
  }
  
  public h(String paramString)
  {
    AppMethodBeat.i(247715);
    this.userId = paramString;
    this.streamType = 0;
    paramString = com.tencent.threadpool.c.d.jw("MicroMsg.LiveCoreVisitor_render", 10);
    s.s(paramString, "createAboutMeidaThread(T…er\", Thread.MAX_PRIORITY)");
    this.mVg = paramString;
    this.mWf = true;
    this.mWg = 2;
    this.mVg.start();
    this.handler = new MMHandler(this.mVg.getLooper(), new h..ExternalSyntheticLambda0(this));
    K((a)new c(this));
    K((a)new b(this));
    AppMethodBeat.o(247715);
  }
  
  private void K(a<ah> parama)
  {
    AppMethodBeat.i(247723);
    this.handler.post(new h..ExternalSyntheticLambda1(parama));
    AppMethodBeat.o(247723);
  }
  
  private static final void L(a parama)
  {
    AppMethodBeat.i(247754);
    parama.invoke();
    AppMethodBeat.o(247754);
  }
  
  private static final boolean a(h paramh, Message paramMessage)
  {
    AppMethodBeat.i(247745);
    s.u(paramh, "this$0");
    s.u(paramMessage, "it");
    Object localObject1;
    Object localObject2;
    int i;
    int j;
    if (paramMessage.what == 1024)
    {
      paramMessage = paramMessage.obj;
      if (paramMessage == null)
      {
        paramh = new NullPointerException("null cannot be cast to non-null type com.tencent.trtc.TRTCCloudDef.TRTCVideoFrame");
        AppMethodBeat.o(247745);
        throw paramh;
      }
      paramMessage = (TRTCCloudDef.TRTCVideoFrame)paramMessage;
      localObject1 = paramh.mVi;
      if ((localObject1 != null) && (paramh.mWd))
      {
        localObject2 = paramh.mVl;
        if (localObject2 != null)
        {
          Log.i("MicroMsg.LiveCoreVisitor", "makeOutputSurface");
          c.a locala = com.tencent.mm.media.util.c.nFs;
          paramh.mWc = c.a.a(((c.b)localObject1).nFB, localObject2);
          ((c.b)localObject1).eglSurface = paramh.mWc;
          EGL14.eglMakeCurrent(((c.b)localObject1).nFB, paramh.mWc, paramh.mWc, ((c.b)localObject1).eXL);
          paramh.mWd = false;
          paramh.mWf = false;
        }
      }
      if (!paramh.mWf)
      {
        localObject1 = paramh.mWe;
        if (localObject1 != null)
        {
          s.u(paramMessage, "frame");
          if (paramMessage.bufferType != 3) {
            break label384;
          }
          ((i)localObject1).mWk = 0;
          i = paramMessage.width;
          j = paramMessage.height;
          if (((i)localObject1).mWk != 0) {
            break label445;
          }
          if (((i)localObject1).mWl != null) {
            break label420;
          }
          ((i)localObject1).mWl = new e(i, j, ((i)localObject1).mWn, ((i)localObject1).mWo, 0, ((i)localObject1).mWg, 16);
          localObject2 = ((i)localObject1).mWl;
          if (localObject2 != null) {
            ((e)localObject2).el(i, j);
          }
          localObject2 = ((i)localObject1).mWl;
          if (localObject2 != null) {
            ((e)localObject2).ek(((i)localObject1).mWn, ((i)localObject1).mWo);
          }
          localObject2 = ((i)localObject1).mWl;
          if (localObject2 != null) {
            ((e)localObject2).th(paramMessage.rotation);
          }
          localObject2 = ((i)localObject1).mWl;
          if (localObject2 != null) {
            ((e)localObject2).mVb = paramMessage.texture.textureId;
          }
          paramMessage = ((i)localObject1).mWl;
          if (paramMessage != null) {
            paramMessage.bgE();
          }
        }
      }
    }
    label384:
    label420:
    label445:
    while (((i)localObject1).mWk != 1) {
      for (;;)
      {
        paramh = paramh.mVi;
        if (paramh != null) {
          EGL14.eglSwapBuffers(paramh.nFB, paramh.eglSurface);
        }
        AppMethodBeat.o(247745);
        return true;
        if ((paramMessage.pixelFormat == 1) && (paramMessage.bufferType == 2))
        {
          ((i)localObject1).mWk = 1;
          break;
        }
        Log.w("MicroMsg.LiveCoreVisitor", "error video frame type");
        continue;
        localObject2 = ((i)localObject1).mWm;
        if (localObject2 != null) {
          ((com.tencent.mm.media.j.b.d)localObject2).ud(((i)localObject1).mWg);
        }
      }
    }
    ((i)localObject1).mWq = Util.currentTicks();
    if (((i)localObject1).mWm == null)
    {
      ((i)localObject1).mWm = new com.tencent.mm.media.j.b.d(i, j, ((i)localObject1).mWn, ((i)localObject1).mWo, ((i)localObject1).mWg, (byte)0);
      ((i)localObject1).mWp.startTimer(1000L);
    }
    for (;;)
    {
      localObject2 = ((i)localObject1).mWm;
      if (localObject2 != null) {
        ((com.tencent.mm.media.j.b.d)localObject2).el(i, j);
      }
      localObject2 = ((i)localObject1).mWm;
      if (localObject2 != null) {
        ((com.tencent.mm.media.j.b.d)localObject2).ek(((i)localObject1).mWn, ((i)localObject1).mWo);
      }
      localObject2 = ((i)localObject1).mWm;
      if (localObject2 != null) {
        ((com.tencent.mm.media.j.b.d)localObject2).th(paramMessage.rotation);
      }
      localObject2 = ((i)localObject1).mWm;
      if (localObject2 != null)
      {
        paramMessage = paramMessage.data;
        s.s(paramMessage, "frame.data");
        ((com.tencent.mm.media.j.b.d)localObject2).ap(paramMessage);
      }
      paramMessage = ((i)localObject1).mWm;
      if (paramMessage != null) {
        paramMessage.bgE();
      }
      ((i)localObject1).mVW += 1;
      com.tencent.mm.live.core.c.c.hJ(Util.ticksToNow(((i)localObject1).mWq));
      break;
      localObject2 = ((i)localObject1).mWm;
      if (localObject2 != null) {
        ((com.tencent.mm.media.j.b.d)localObject2).ud(((i)localObject1).mWg);
      }
    }
  }
  
  public final void bgH()
  {
    AppMethodBeat.i(247845);
    K((a)new f(this));
    AppMethodBeat.o(247845);
  }
  
  public final void di(Object paramObject)
  {
    AppMethodBeat.i(247836);
    Log.i("MicroMsg.LiveCoreVisitor", s.X("setOutputSurface:", paramObject));
    K((a)new e(paramObject, this));
    AppMethodBeat.o(247836);
  }
  
  public final void ej(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(247863);
    K((a)new g(this, paramInt1, paramInt2));
    AppMethodBeat.o(247863);
  }
  
  public final void onRenderVideoFrame(String paramString, int paramInt, TRTCCloudDef.TRTCVideoFrame paramTRTCVideoFrame)
  {
    AppMethodBeat.i(247851);
    if ((!s.p(paramString, this.userId)) || (paramInt != this.streamType))
    {
      AppMethodBeat.o(247851);
      return;
    }
    this.handler.obtainMessage(1024, paramTRTCVideoFrame).sendToTarget();
    AppMethodBeat.o(247851);
  }
  
  public final void release()
  {
    AppMethodBeat.i(247869);
    K((a)new d(this));
    AppMethodBeat.o(247869);
  }
  
  public final void ti(final int paramInt)
  {
    AppMethodBeat.i(247858);
    K((a)new h(this, paramInt));
    AppMethodBeat.o(247858);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<ah>
  {
    e(Object paramObject, h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements a<ah>
  {
    f(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements a<ah>
  {
    g(h paramh, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements a<ah>
  {
    h(h paramh, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.core.b.h
 * JD-Core Version:    0.7.0.1
 */