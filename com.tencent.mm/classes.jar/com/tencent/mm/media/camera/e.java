package com.tencent.mm.media.camera;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.camera.d.i;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/GLEnvBuilder;", "Lcom/tencent/mm/media/camera/ICameraKitEnv;", "Lcom/tencent/mm/media/camera/ICameraRender;", "sessionId", "", "(I)V", "availableListener", "Lkotlin/Function1;", "Landroid/graphics/SurfaceTexture;", "Lkotlin/ParameterName;", "name", "surfaceTexture", "", "Lcom/tencent/mm/media/camera/model/FrameAvailableListener;", "glEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "inputSurface", "Landroid/view/Surface;", "inputSurfaceTexture", "inputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "jumpNextFrame", "", "jumpRender", "oneOffTrigger", "Lcom/tencent/mm/media/camera/util/OneOffTrigger;", "renderHandler", "Landroid/os/Handler;", "renderPipeline", "Lcom/tencent/mm/media/camera/render/CameraRenderPipeline;", "renderThread", "Landroid/os/HandlerThread;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getSessionId", "()I", "setSessionId", "setupContinuation", "Lkotlin/coroutines/Continuation;", "sizeParameter", "Lcom/tencent/mm/media/camera/model/GLSizeParameter;", "bindSurface", "surface", "width", "height", "(Landroid/view/Surface;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindSurfaceTexture", "texture", "(Landroid/graphics/SurfaceTexture;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bufferUpdateFrame", "data", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createGLThread", "destroyGLEnv", "envValid", "getCurrentFrame", "Landroid/graphics/Bitmap;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGLInputSurface", "getGLInputTexture", "texturePreview", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScreenSize", "Lcom/tencent/mm/media/camera/model/GLSize;", "getSizeParameter", "makeSureEnvSetup", "pause", "renderLaunch", "block", "Lkotlin/Function2;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)V", "renderLaunchReturn", "T", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resume", "setCustomRender", "render", "Lcom/tencent/mm/media/camera/CustomRenderCallback;", "setRenderSetting", "setting", "Lcom/tencent/mm/media/camera/model/CameraKitRenderSetting;", "setUpGLEnv", "unbindSurface", "updateInputMirror", "mirror", "updateInputRotate", "rotate", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateInputSize", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateScreenSize", "Companion", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public class e
  implements h, k
{
  public static final e.a ntx;
  int hBm;
  private Surface inputSurface;
  private Handler mVD;
  private SurfaceTexture ntA;
  public final i ntB;
  private final com.tencent.mm.media.camera.f.b ntC;
  private c.b ntD;
  private kotlin.d.d<? super ah> ntE;
  private com.tencent.mm.media.camera.h.a ntF;
  private boolean ntG;
  private boolean ntH;
  private final kotlin.g.a.b<SurfaceTexture, ah> ntI;
  private HandlerThread nty;
  private com.tencent.mm.media.g.d ntz;
  private aq scope;
  
  static
  {
    AppMethodBeat.i(237240);
    ntx = new e.a((byte)0);
    AppMethodBeat.o(237240);
  }
  
  public e(int paramInt)
  {
    AppMethodBeat.i(237085);
    this.hBm = paramInt;
    this.ntB = new i();
    this.ntC = new com.tencent.mm.media.camera.f.b(this.hBm, this.ntB);
    this.ntF = new com.tencent.mm.media.camera.h.a((kotlin.g.a.a)e.j.ntN);
    Log.i("MicroMsg.Camera.GLEnvBuilder", "setUpGLEnv");
    Object localObject = com.tencent.threadpool.c.d.jy("CameraKit-GLThread", -2);
    this.nty = ((HandlerThread)localObject);
    ((HandlerThread)localObject).start();
    this.mVD = new Handler(((HandlerThread)localObject).getLooper());
    localObject = this.mVD;
    s.checkNotNull(localObject);
    this.scope = ar.d((kotlin.d.f)kotlinx.coroutines.android.c.f((Handler)localObject));
    h((m)new n(this, null));
    this.ntI = ((kotlin.g.a.b)new b(this));
    AppMethodBeat.o(237085);
  }
  
  private final boolean bnN()
  {
    return this.ntD != null;
  }
  
  public final Object a(Surface paramSurface, Integer paramInteger1, Integer paramInteger2, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(237251);
    paramSurface = a(this, paramSurface, paramInteger1, paramInteger2, paramd);
    AppMethodBeat.o(237251);
    return paramSurface;
  }
  
  public final <T> Object a(String paramString, m<? super aq, ? super kotlin.d.d<? super T>, ? extends Object> paramm, kotlin.d.d<? super T> paramd)
  {
    AppMethodBeat.i(237302);
    if (this.mVD == null)
    {
      Log.i("MicroMsg.Camera.GLEnvBuilder", "renderHandler already release,name:" + paramString + " will not execute");
      AppMethodBeat.o(237302);
      return null;
    }
    Handler localHandler = this.mVD;
    s.checkNotNull(localHandler);
    paramString = l.a((kotlin.d.f)kotlinx.coroutines.android.c.a(localHandler, paramString), paramm, paramd);
    AppMethodBeat.o(237302);
    return paramString;
  }
  
  public final Object a(final boolean paramBoolean, kotlin.d.d<? super SurfaceTexture> paramd)
  {
    AppMethodBeat.i(237286);
    paramd = a("getGLInputTexture", (m)new h(this, paramBoolean, null), paramd);
    AppMethodBeat.o(237286);
    return paramd;
  }
  
  public final Object b(final int paramInt1, final int paramInt2, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(237272);
    paramd = a("updateInputSize", (m)new r(this, paramInt1, paramInt2, null), paramd);
    AppMethodBeat.o(237272);
    return paramd;
  }
  
  public void bnO()
  {
    AppMethodBeat.i(237259);
    Log.i("MicroMsg.Camera.GLEnvBuilder", "destroyGLEnv");
    Handler localHandler = this.mVD;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    h((m)new e(this, null));
    AppMethodBeat.o(237259);
  }
  
  public final void h(m<? super aq, ? super kotlin.d.d<? super ah>, ? extends Object> paramm)
  {
    AppMethodBeat.i(237296);
    s.u(paramm, "block");
    aq localaq = this.scope;
    if (localaq != null) {
      j.a(localaq, null, null, paramm, 3);
    }
    AppMethodBeat.o(237296);
  }
  
  public final Object r(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(237268);
    Object localObject = new kotlin.d.h(kotlin.d.a.b.au(paramd));
    kotlin.d.d locald = (kotlin.d.d)localObject;
    Log.i("MicroMsg.Camera.GLEnvBuilder", "makeSureEnvSetup valid:" + bnN() + " screenSize:" + this.ntB.nvL);
    if ((bnN()) && (this.ntB.nvL.width > 0))
    {
      ah localah = ah.aiuX;
      Result.Companion localCompanion = Result.Companion;
      locald.resumeWith(Result.constructor-impl(localah));
    }
    for (;;)
    {
      localObject = ((kotlin.d.h)localObject).kli();
      if (localObject == kotlin.d.a.a.aiwj) {
        s.u(paramd, "frame");
      }
      paramd = (kotlin.d.d<? super ah>)localObject;
      if (localObject != kotlin.d.a.a.aiwj) {
        paramd = ah.aiuX;
      }
      AppMethodBeat.o(237268);
      return paramd;
      this.ntE = locald;
    }
  }
  
  public void setCustomRender(final d paramd)
  {
    AppMethodBeat.i(237279);
    h((m)new m(this, paramd, null));
    AppMethodBeat.o(237279);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<SurfaceTexture, ah>
  {
    b(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(Surface paramSurface, e parame, Integer paramInteger1, Integer paramInteger2, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237071);
      paramObject = (kotlin.d.d)new c(this.ntp, this.ntJ, this.ntq, this.ntr, paramd);
      AppMethodBeat.o(237071);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237067);
      Object localObject1 = kotlin.d.a.a.aiwj;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237067);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Log.i("MicroMsg.Camera.GLEnvBuilder", s.X("bindSurface surface hash:", Integer.valueOf(this.ntp.hashCode())));
        paramObject = e.b(this.ntJ);
        if (paramObject == null)
        {
          Log.e("MicroMsg.Camera.GLEnvBuilder", "bindSurface failed for glEnvironment is null!");
          paramObject = ah.aiuX;
          AppMethodBeat.o(237067);
          return paramObject;
        }
        if (!this.ntp.isValid())
        {
          Log.e("MicroMsg.Camera.GLEnvBuilder", "bindSurface failed for surface isn't valid!,step 1");
          paramObject = ah.aiuX;
          AppMethodBeat.o(237067);
          return paramObject;
        }
        long l = Util.currentTicks();
        Log.i("MicroMsg.Camera.GLEnvBuilder", "bindSurface step 1,create glsurface");
        localObject2 = com.tencent.mm.media.util.c.nFs;
        localObject2 = c.a.a(paramObject.nFB, this.ntp);
        Log.i("MicroMsg.Camera.GLEnvBuilder", s.X("bindSurface step 1 cost:", kotlin.d.b.a.b.BF(Util.ticksToNow(l))));
        if (!this.ntp.isValid())
        {
          Log.e("MicroMsg.Camera.GLEnvBuilder", "bindSurface failed for surface isn't valid!,step 2");
          paramObject = ah.aiuX;
          AppMethodBeat.o(237067);
          return paramObject;
        }
        Integer localInteger1 = this.ntq;
        Integer localInteger2 = this.ntr;
        e locale = this.ntJ;
        if ((localInteger1 != null) && (localInteger2 != null))
        {
          int i = ((Number)localInteger2).intValue();
          int j = ((Number)localInteger1).intValue();
          Log.i("MicroMsg.Camera.GLEnvBuilder", "updateSurfaceSize w:" + j + " h:" + i);
          if ((j > 0) && (i > 0)) {
            e.e(locale).eq(j, i);
          }
        }
        l = Util.currentTicks();
        Log.i("MicroMsg.Camera.GLEnvBuilder", "bindSurface step 2,make current");
        EGL14.eglMakeCurrent(paramObject.nFB, (EGLSurface)localObject2, (EGLSurface)localObject2, paramObject.eXL);
        Log.i("MicroMsg.Camera.GLEnvBuilder", s.X("bindSurface step 2 cost:", kotlin.d.b.a.b.BF(Util.ticksToNow(l))));
        paramObject = e.b(this.ntJ);
        if (paramObject != null) {
          paramObject.eglSurface = ((EGLSurface)localObject2);
        }
        e.a(this.ntJ).ntD = e.b(this.ntJ);
        paramObject = e.a(this.ntJ);
        localObject2 = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.v((kotlin.d.d)localObject2) == localObject1)
        {
          AppMethodBeat.o(237067);
          return localObject1;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = e.c(this.ntJ);
      if (paramObject != null)
      {
        localObject1 = ah.aiuX;
        localObject2 = Result.Companion;
        paramObject.resumeWith(Result.constructor-impl(localObject1));
      }
      e.d(this.ntJ);
      Log.i("MicroMsg.Camera.GLEnvBuilder", "bindSurface finish,thread-id:[" + Process.myTid() + "] name:" + Thread.currentThread().getName());
      paramObject = ah.aiuX;
      AppMethodBeat.o(237067);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    e(e parame, kotlin.d.d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237079);
      paramObject = (kotlin.d.d)new e(this.ntJ, paramd);
      AppMethodBeat.o(237079);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237073);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237073);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject1 = e.a(this.ntJ);
        paramObject = (kotlin.d.d)this;
        this.label = 1;
        Log.i("MicroMsg.Camera.CameraRenderPipeline", "release");
        Object localObject2 = ((com.tencent.mm.media.camera.f.b)localObject1).nwi;
        if (localObject2 != null) {
          ((com.tencent.mm.media.j.b.f)localObject2).release();
        }
        ((com.tencent.mm.media.camera.f.b)localObject1).nwi = null;
        localObject2 = ((com.tencent.mm.media.camera.f.b)localObject1).nwj;
        if (localObject2 != null) {
          ((com.tencent.mm.media.j.b.a)localObject2).release();
        }
        ((com.tencent.mm.media.camera.f.b)localObject1).nwj = null;
        localObject2 = ((com.tencent.mm.media.camera.f.b)localObject1).nwk;
        if (localObject2 != null) {
          ((com.tencent.mm.media.j.b.a)localObject2).release();
        }
        ((com.tencent.mm.media.camera.f.b)localObject1).nwk = null;
        localObject1 = ((com.tencent.mm.media.camera.f.b)localObject1).nwl;
        if (localObject1 == null)
        {
          if (kotlin.d.a.a.aiwj == null) {
            break label331;
          }
          paramObject = ah.aiuX;
        }
        break;
      }
      for (;;)
      {
        if (paramObject == locala)
        {
          AppMethodBeat.o(237073);
          return locala;
          localObject1 = ((d)localObject1).q(paramObject);
          paramObject = localObject1;
          if (localObject1 != kotlin.d.a.a.aiwj)
          {
            paramObject = ah.aiuX;
            continue;
            ResultKt.throwOnFailure(paramObject);
          }
        }
        else
        {
          paramObject = e.f(this.ntJ);
          if (paramObject != null) {
            paramObject.close();
          }
          paramObject = com.tencent.mm.media.util.c.nFs;
          c.a.a(e.b(this.ntJ));
          e.a(this.ntJ, null);
          e.g(this.ntJ);
          paramObject = e.h(this.ntJ);
          if (paramObject != null) {
            paramObject.quitSafely();
          }
          e.i(this.ntJ);
          e.a(this.ntJ, null);
          e.a(this.ntJ, null);
          paramObject = e.j(this.ntJ);
          if (paramObject != null) {
            ar.a(paramObject, null);
          }
          e.k(this.ntJ);
          Log.i("MicroMsg.Camera.GLEnvBuilder", "destroyGLEnv finish");
          paramObject = ah.aiuX;
          AppMethodBeat.o(237073);
          return paramObject;
          label331:
          paramObject = null;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/Surface;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class g
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super Surface>, Object>
  {
    int label;
    
    public g(e parame, kotlin.d.d<? super g> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237054);
      paramObject = (kotlin.d.d)new g(this.ntJ, paramd);
      AppMethodBeat.o(237054);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237047);
      Object localObject = kotlin.d.a.a.aiwj;
      int i;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237047);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = e.n(this.ntJ);
        if ((paramObject != null) && (paramObject.isValid() == true)) {
          i = 1;
        }
        break;
      }
      while (i == 0)
      {
        paramObject = (h)this.ntJ;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.a(true, locald) == localObject)
        {
          AppMethodBeat.o(237047);
          return localObject;
          i = 0;
          continue;
          ResultKt.throwOnFailure(paramObject);
        }
        else
        {
          e.a(this.ntJ, new Surface(e.l(this.ntJ)));
          localObject = new StringBuilder("create texture:[").append(e.f(this.ntJ)).append("] surface:[");
          paramObject = e.n(this.ntJ);
          if (paramObject != null) {
            break label233;
          }
        }
      }
      label233:
      for (paramObject = null;; paramObject = Integer.valueOf(paramObject.hashCode()))
      {
        Log.i("MicroMsg.Camera.GLEnvBuilder", paramObject + "] name:" + Thread.currentThread().getName());
        paramObject = e.n(this.ntJ);
        AppMethodBeat.o(237047);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/graphics/SurfaceTexture;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super SurfaceTexture>, Object>
  {
    int label;
    
    h(e parame, boolean paramBoolean, kotlin.d.d<? super h> paramd)
    {
      super(paramd);
    }
    
    private static final void a(kotlin.g.a.b paramb, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(237035);
      paramb.invoke(paramSurfaceTexture);
      AppMethodBeat.o(237035);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237061);
      paramObject = (kotlin.d.d)new h(this.ntJ, paramBoolean, paramd);
      AppMethodBeat.o(237061);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237055);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237055);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if (e.l(this.ntJ) == null)
      {
        e.a(this.ntJ, com.tencent.mm.media.g.c.d(false, 21L));
        paramObject = e.f(this.ntJ);
        if (paramObject != null) {
          paramObject.setSize(e.e(this.ntJ).nvM.width, e.e(this.ntJ).nvM.height);
        }
        paramObject = this.ntJ;
        localObject = e.f(this.ntJ);
        s.checkNotNull(localObject);
        e.a(paramObject, new SurfaceTexture(((com.tencent.mm.media.g.d)localObject).nAF));
        paramObject = e.l(this.ntJ);
        if (paramObject != null) {
          paramObject.setDefaultBufferSize(e.e(this.ntJ).nvM.width, e.e(this.ntJ).nvM.height);
        }
        if (paramBoolean)
        {
          paramObject = e.l(this.ntJ);
          if (paramObject != null) {
            paramObject.setOnFrameAvailableListener(new e.h..ExternalSyntheticLambda0(e.o(this.ntJ)));
          }
        }
        localObject = new StringBuilder("getGLInputTexture [");
        paramObject = e.l(this.ntJ);
        if (paramObject != null) {
          break label323;
        }
      }
      label323:
      for (paramObject = null;; paramObject = Integer.valueOf(paramObject.hashCode()))
      {
        Log.i("MicroMsg.Camera.GLEnvBuilder", paramObject + "] thread-id:[" + Process.myTid() + "] name:" + Thread.currentThread().getName() + " texturePreview:" + paramBoolean);
        paramObject = e.l(this.ntJ);
        s.checkNotNull(paramObject);
        AppMethodBeat.o(237055);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    m(e parame, d paramd, kotlin.d.d<? super m> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237040);
      paramObject = (kotlin.d.d)new m(this.ntJ, paramd, paramd);
      AppMethodBeat.o(237040);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237029);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237029);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        e.a(this.ntJ).setCustomRender(paramd);
        if (e.m(this.ntJ))
        {
          paramObject = paramd;
          if (paramObject != null)
          {
            kotlin.d.d locald = (kotlin.d.d)this;
            this.label = 1;
            if (paramObject.p(locald) == locala)
            {
              AppMethodBeat.o(237029);
              return locala;
            }
          }
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(237029);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    n(e parame, kotlin.d.d<? super n> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237026);
      paramObject = (kotlin.d.d)new n(this.ntJ, paramd);
      AppMethodBeat.o(237026);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237021);
      Object localObject2 = kotlin.d.a.a.aiwj;
      Object localObject1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237021);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        e.a(this.ntJ, c.a.a(com.tencent.mm.media.util.c.nFs));
        e.a(this.ntJ).ntD = e.b(this.ntJ);
        localObject1 = e.a(this.ntJ);
        paramObject = (kotlin.d.d)this;
        this.label = 1;
        Log.i("MicroMsg.Camera.CameraRenderPipeline", "setUpInGLEnv");
        ((com.tencent.mm.media.camera.f.b)localObject1).nwi = new com.tencent.mm.media.j.b.f(0, 0, 0, 0, 2, 2);
        ((com.tencent.mm.media.camera.f.b)localObject1).nwj = ((com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.c(0, 0, 0, 0, 2, 2));
        ((com.tencent.mm.media.camera.f.b)localObject1).nwk = ((com.tencent.mm.media.j.b.a)new com.tencent.mm.media.j.b.e(0, 0, 0, 0, 0, 0, 48));
        localObject1 = ((com.tencent.mm.media.camera.f.b)localObject1).nwl;
        if (localObject1 == null)
        {
          paramObject = null;
          if (kotlin.d.a.a.aiwj != null) {
            paramObject = ah.aiuX;
          }
        }
        break;
      }
      while (paramObject == localObject2)
      {
        AppMethodBeat.o(237021);
        return localObject2;
        localObject1 = ((d)localObject1).p(paramObject);
        paramObject = localObject1;
        if (localObject1 != kotlin.d.a.a.aiwj)
        {
          paramObject = ah.aiuX;
          continue;
          ResultKt.throwOnFailure(paramObject);
        }
      }
      paramObject = e.c(this.ntJ);
      if (paramObject != null)
      {
        localObject1 = ah.aiuX;
        localObject2 = Result.Companion;
        paramObject.resumeWith(Result.constructor-impl(localObject1));
      }
      e.d(this.ntJ);
      Log.i("MicroMsg.Camera.GLEnvBuilder", "gl env set up finish,thread-id:[" + Process.myTid() + "] name:" + Thread.currentThread().getName());
      paramObject = ah.aiuX;
      AppMethodBeat.o(237021);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    o(e parame, kotlin.d.d<? super o> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237287);
      paramObject = (kotlin.d.d)new o(this.ntJ, paramd);
      AppMethodBeat.o(237287);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237280);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237280);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      Log.i("MicroMsg.Camera.GLEnvBuilder", "unbindSurface");
      paramObject = com.tencent.mm.media.util.c.nFs;
      paramObject = e.b(this.ntJ);
      localObject = EGL14.EGL_NO_SURFACE;
      s.s(localObject, "EGL_NO_SURFACE");
      c.a.a(paramObject, (EGLSurface)localObject);
      Log.i("MicroMsg.Camera.GLEnvBuilder", "unbindSurface finish");
      paramObject = ah.aiuX;
      AppMethodBeat.o(237280);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    r(e parame, int paramInt1, int paramInt2, kotlin.d.d<? super r> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237283);
      paramObject = (kotlin.d.d)new r(this.ntJ, paramInt1, paramInt2, paramd);
      AppMethodBeat.o(237283);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237274);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237274);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = com.tencent.mm.media.camera.g.a.nwA;
      int i = this.ntJ.hBm;
      int j = paramInt1;
      int k = paramInt2;
      paramObject = com.tencent.mm.media.camera.g.a.tW(i);
      if (paramObject != null)
      {
        paramObject.iou = j;
        paramObject.iov = k;
      }
      Log.i("MicroMsg.Camera.GLEnvBuilder", "setCameraSize:[" + paramInt1 + ' ' + paramInt2 + ']');
      paramObject = e.e(this.ntJ);
      i = paramInt1;
      j = paramInt2;
      paramObject.nvM.width = i;
      paramObject.nvM.height = j;
      paramObject.bom();
      paramObject = e.f(this.ntJ);
      if (paramObject != null) {
        paramObject.setSize(paramInt1, paramInt2);
      }
      paramObject = e.l(this.ntJ);
      if (paramObject != null) {
        paramObject.setDefaultBufferSize(e.e(this.ntJ).nvM.width, e.e(this.ntJ).nvM.height);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(237274);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.e
 * JD-Core Version:    0.7.0.1
 */