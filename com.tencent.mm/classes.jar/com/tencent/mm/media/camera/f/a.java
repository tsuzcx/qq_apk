package com.tencent.mm.media.camera.f;

import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/render/BaseCustomRenderCallback;", "Lcom/tencent/mm/media/camera/CustomRenderCallback;", "heavy", "", "(Z)V", "eglEnv", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "getHeavy", "()Z", "setHeavy", "heavyThread", "Landroid/os/HandlerThread;", "lock", "Ljava/lang/Object;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "todoList", "", "Ljava/lang/Runnable;", "kotlin.jvm.PlatformType", "", "clearWork", "", "doWorkInRenderThread", "glCreate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "glRelease", "glRender", "Lcom/tencent/mm/media/globject/GLTextureObject;", "texture", "(Lcom/tencent/mm/media/globject/GLTextureObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renderLaunch", "egl", "runnable", "Companion", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements com.tencent.mm.media.camera.d
{
  public static final a.a nvZ = new a.a((byte)0);
  private Object lock = new Object();
  private boolean nwa = false;
  private final List<Runnable> nwb = Collections.synchronizedList((List)new ArrayList());
  private HandlerThread nwc;
  private c.b nwd;
  private aq scope;
  
  private a()
  {
    if (this.nwa)
    {
      HandlerThread localHandlerThread = com.tencent.threadpool.c.d.jy("Heavy-GLThread", -2);
      localHandlerThread.start();
      this.scope = ar.d((f)kotlinx.coroutines.android.c.f(new Handler(localHandlerThread.getLooper())));
      ah localah = ah.aiuX;
      this.nwc = localHandlerThread;
    }
  }
  
  private static final void a(a parama, EGLContext paramEGLContext)
  {
    s.u(parama, "this$0");
    long l = System.currentTimeMillis();
    parama.nwd = c.a.a(com.tencent.mm.media.util.c.nFs, null, 0, 0, paramEGLContext, 14);
    Log.i("MicroMsg.BaseCustomRenderCallback", s.X("eglSetupBySurface finish,envCost:", Long.valueOf(System.currentTimeMillis() - l)));
    parama.bos();
  }
  
  private final void bos()
  {
    for (;;)
    {
      synchronized (this.lock)
      {
        Object localObject2 = this.nwb;
        s.s(localObject2, "todoList");
        if (!((Collection)localObject2).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break label102;
          }
          localObject2 = this.nwb;
          s.s(localObject2, "todoList");
          localObject2 = ((Iterable)localObject2).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          ((Runnable)((Iterator)localObject2).next()).run();
        }
      }
      int i = 0;
    }
    this.nwb.clear();
    label102:
    ah localah = ah.aiuX;
  }
  
  private void c(final boolean paramBoolean, final Runnable paramRunnable)
  {
    int i = 1;
    s.u(paramRunnable, "runnable");
    if (this.scope != null)
    {
      ??? = this.nwc;
      if ((??? != null) && (((HandlerThread)???).isAlive() == true)) {}
      while (i != 0)
      {
        ??? = this.scope;
        if (??? != null) {
          j.a((aq)???, null, null, (m)new b(this, paramBoolean, paramRunnable, null), 3);
        }
        return;
        i = 0;
      }
    }
    synchronized (this.lock)
    {
      this.nwb.add(paramRunnable);
      return;
    }
  }
  
  public Object a(com.tencent.mm.media.g.d paramd, kotlin.d.d<? super com.tencent.mm.media.g.d> paramd1)
  {
    bos();
    return paramd;
  }
  
  protected final void bot()
  {
    synchronized (this.lock)
    {
      this.nwb.clear();
      ah localah = ah.aiuX;
      return;
    }
  }
  
  public Object p(kotlin.d.d<? super ah> paramd)
  {
    if (this.nwa) {
      c(false, new a..ExternalSyntheticLambda0(this, EGL14.eglGetCurrentContext()));
    }
    return ah.aiuX;
  }
  
  public Object q(kotlin.d.d<? super ah> paramd)
  {
    paramd = null;
    Object localObject = this.scope;
    if (localObject != null) {
      ar.a((aq)localObject, null);
    }
    localObject = this.nwc;
    if (localObject == null) {}
    for (;;)
    {
      localObject = paramd;
      if (paramd != kotlin.d.a.a.aiwj) {
        localObject = ah.aiuX;
      }
      return localObject;
      paramd = Boolean.valueOf(((HandlerThread)localObject).quitSafely());
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(a parama, boolean paramBoolean, Runnable paramRunnable, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237159);
      paramObject = (kotlin.d.d)new b(this.nwe, paramBoolean, paramRunnable, paramd);
      AppMethodBeat.o(237159);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237152);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237152);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if ((a.a(this.nwe) == null) && (paramBoolean))
      {
        Log.i("MicroMsg.BaseCustomRenderCallback", "renderLaunch not exec for egl not ready");
        paramObject = ah.aiuX;
        AppMethodBeat.o(237152);
        return paramObject;
      }
      paramRunnable.run();
      paramObject = ah.aiuX;
      AppMethodBeat.o(237152);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.f.a
 * JD-Core Version:    0.7.0.1
 */