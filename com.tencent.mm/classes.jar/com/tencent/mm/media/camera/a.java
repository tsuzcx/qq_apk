package com.tencent.mm.media.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseArray;
import android.view.Surface;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.aj;
import com.tencent.mm.media.camera.lifecycle.CameraLifecycleProxy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.d.d<-Lkotlin.r<Ljava.lang.Integer;Landroid.graphics.Bitmap;>;>;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlin.r;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.ay;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/CameraKit;", "Lcom/tencent/mm/media/camera/ICameraKit;", "Lcom/tencent/mm/media/camera/ICameraCoroutines;", "()V", "cameraInstance", "Lcom/tencent/mm/media/camera/instance/ICameraInstance;", "cameraStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlin/Pair;", "Lcom/tencent/mm/media/camera/view/CameraStatusEnum;", "Landroid/os/Bundle;", "getCameraStateFlow$plugin_camera_release", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "glEnv", "Lcom/tencent/mm/media/camera/GLEnvBuilder;", "getGlEnv", "()Lcom/tencent/mm/media/camera/GLEnvBuilder;", "glEnv$delegate", "Lkotlin/Lazy;", "lifecycleProxy", "Lcom/tencent/mm/media/camera/lifecycle/CameraLifecycleProxy;", "operateThread", "Landroid/os/HandlerThread;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "scopeHandler", "Landroid/os/Handler;", "sessionId", "", "attachLifeCycleOwner", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "bindSurface", "surface", "Landroid/view/Surface;", "width", "height", "(Landroid/view/Surface;Ljava/lang/Integer;Ljava/lang/Integer;)V", "bindSurfaceTexture", "texture", "Landroid/graphics/SurfaceTexture;", "(Landroid/graphics/SurfaceTexture;Ljava/lang/Integer;Ljava/lang/Integer;)V", "cameraAsync", "Lkotlinx/coroutines/Deferred;", "T", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "cameraLaunch", "Lkotlinx/coroutines/Job;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "destroyGLEnv", "execute", "command", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "focusOn", "x", "", "y", "generateCameraKitInfo", "Lcom/tencent/mm/media/camera/model/CameraKitInfo;", "getCameraInstance", "getCameraState", "Lkotlinx/coroutines/flow/StateFlow;", "onDestroy", "onZoomIn", "onZoomOut", "pausePreview", "preOpenCamera", "backCamera", "", "resumePreview", "setCameraKitSetting", "setting", "Lcom/tencent/mm/media/camera/model/CameraKitCommonSetting;", "setCustomRender", "render", "Lcom/tencent/mm/media/camera/CustomRenderCallback;", "setUpCamera", "context", "Landroid/content/Context;", "switchCamera", "switchToCamera", "back", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "takePicture", "Landroid/graphics/Bitmap;", "rotate", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unbindSurface", "updateRenderScreenSize", "updateScreenSize", "Companion", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements f, g
{
  public static final a.a nth;
  private int hBm;
  private final HandlerThread nti;
  public final Handler ntj;
  private final kotlin.j ntk;
  public com.tencent.mm.media.camera.instance.c ntl;
  private CameraLifecycleProxy ntm;
  public final x<r<com.tencent.mm.media.camera.view.a, Bundle>> ntn;
  private final aq scope;
  
  static
  {
    AppMethodBeat.i(237131);
    nth = new a.a((byte)0);
    AppMethodBeat.o(237131);
  }
  
  public a()
  {
    AppMethodBeat.i(237086);
    this.hBm = hashCode();
    this.ntk = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.ntm = new CameraLifecycleProxy((g)this);
    this.ntn = kotlinx.coroutines.b.ah.ji(new r(com.tencent.mm.media.camera.view.a.nwP, new Bundle()));
    Object localObject = com.tencent.mm.media.camera.g.a.nwA;
    com.tencent.mm.media.camera.g.a.tX(this.hBm);
    localObject = com.tencent.threadpool.c.d.jy("CameraKit-Use", -2);
    kotlin.g.b.s.s(localObject, "this");
    this.nti = ((HandlerThread)localObject);
    ((HandlerThread)localObject).start();
    this.ntj = new Handler(((HandlerThread)localObject).getLooper());
    this.scope = ar.d((kotlin.d.f)kotlinx.coroutines.android.c.f(this.ntj));
    AppMethodBeat.o(237086);
  }
  
  public final Object a(int paramInt1, int paramInt2, int paramInt3, kotlin.d.d<? super r<Integer, Bitmap>> paramd)
  {
    AppMethodBeat.i(237172);
    if ((paramd instanceof k))
    {
      localObject1 = (k)paramd;
      if ((((k)localObject1).label & 0x80000000) != 0) {
        ((k)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super r<Integer, Bitmap>>)localObject1;; paramd = new k(this, paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237172);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Object localObject1 = this.ntl;
    if (localObject1 == null)
    {
      paramd = new r(Integer.valueOf(-2), null);
      AppMethodBeat.o(237172);
      return paramd;
    }
    long l1 = System.currentTimeMillis();
    paramd.L$0 = this;
    paramd.Yx = l1;
    paramd.label = 1;
    Object localObject2 = ((com.tencent.mm.media.camera.instance.c)localObject1).b(0, paramInt2, paramInt3, paramd);
    localObject1 = localObject2;
    paramd = this;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(237172);
      return locala;
      l1 = paramd.Yx;
      paramd = (a)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
    }
    localObject1 = (Bitmap)localObject1;
    localObject2 = com.tencent.mm.media.camera.g.a.nwA;
    paramInt1 = paramd.hBm;
    long l2 = System.currentTimeMillis();
    paramd = com.tencent.mm.media.camera.g.a.tW(paramInt1);
    if (paramd != null) {
      paramd.ioE = (l2 - l1);
    }
    if (localObject1 == null) {}
    for (paramInt1 = -1;; paramInt1 = 0)
    {
      paramd = new r(Integer.valueOf(paramInt1), localObject1);
      AppMethodBeat.o(237172);
      return paramd;
    }
  }
  
  public final void a(final SurfaceTexture paramSurfaceTexture, final Integer paramInteger1, final Integer paramInteger2)
  {
    AppMethodBeat.i(237146);
    kotlin.g.b.s.u(paramSurfaceTexture, "texture");
    f((m)new c(this, paramSurfaceTexture, paramInteger1, paramInteger2, null));
    AppMethodBeat.o(237146);
  }
  
  public final void a(final Surface paramSurface, final Integer paramInteger1, final Integer paramInteger2)
  {
    AppMethodBeat.i(237144);
    kotlin.g.b.s.u(paramSurface, "surface");
    f((m)new b(this, paramSurface, paramInteger1, paramInteger2, null));
    AppMethodBeat.o(237144);
  }
  
  public final e bnJ()
  {
    AppMethodBeat.i(237135);
    e locale = (e)this.ntk.getValue();
    AppMethodBeat.o(237135);
    return locale;
  }
  
  public final void bnK()
  {
    AppMethodBeat.i(237150);
    f((m)new l(this, null));
    AppMethodBeat.o(237150);
  }
  
  public final com.tencent.mm.media.camera.d.c bnL()
  {
    AppMethodBeat.i(237186);
    Object localObject = this.ntl;
    if (localObject == null)
    {
      AppMethodBeat.o(237186);
      return null;
    }
    localObject = ((com.tencent.mm.media.camera.instance.c)localObject).bob();
    AppMethodBeat.o(237186);
    return localObject;
  }
  
  public final void ep(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(237140);
    f((m)new m(this, paramInt1, paramInt2, null));
    AppMethodBeat.o(237140);
  }
  
  public final void execute(Runnable paramRunnable)
  {
    AppMethodBeat.i(237202);
    f((m)new a.d(paramRunnable, null));
    AppMethodBeat.o(237202);
  }
  
  public final cb f(m<? super aq, ? super kotlin.d.d<? super kotlin.ah>, ? extends Object> paramm)
  {
    AppMethodBeat.i(237191);
    kotlin.g.b.s.u(paramm, "block");
    paramm = kotlinx.coroutines.j.a(this.scope, null, null, paramm, 3);
    AppMethodBeat.o(237191);
    return paramm;
  }
  
  public final <T> ay<T> g(m<? super aq, ? super kotlin.d.d<? super T>, ? extends Object> paramm)
  {
    AppMethodBeat.i(237195);
    kotlin.g.b.s.u(paramm, "block");
    paramm = kotlinx.coroutines.j.a(this.scope, null, paramm, 3);
    AppMethodBeat.o(237195);
    return paramm;
  }
  
  public final void m(q paramq)
  {
    AppMethodBeat.i(237161);
    kotlin.g.b.s.u(paramq, "owner");
    CameraLifecycleProxy localCameraLifecycleProxy = this.ntm;
    kotlin.g.b.s.u(paramq, "owner");
    Log.i("MicroMsg.Camera.CameraLifecycleProxy", kotlin.g.b.s.X("attachLifeCycleOwner:", paramq.getLifecycle().getCurrentState()));
    paramq.getLifecycle().addObserver((p)localCameraLifecycleProxy);
    localCameraLifecycleProxy.nvu.f(paramq.getLifecycle().getCurrentState());
    AppMethodBeat.o(237161);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(237181);
    Log.i("MicroMsg.Camera.CameraKitView", "onDestroy");
    ar.a(this.scope, this + " release.");
    this.nti.quitSafely();
    bnJ().bnO();
    Object localObject = com.tencent.mm.media.camera.a.a.ntR;
    com.tencent.mm.media.camera.a.a.release();
    localObject = com.tencent.mm.media.camera.g.a.nwA;
    int i = this.hBm;
    Log.i("MicroMsg.CameraKitReport", "markExit sessionId:" + i + " size:" + com.tencent.mm.media.camera.g.a.nwB.size());
    localObject = com.tencent.mm.media.camera.g.a.tW(i);
    if (localObject != null)
    {
      ((aj)localObject).ioG = (System.currentTimeMillis() - ((aj)localObject).ioy);
      ((aj)localObject).ioz = System.currentTimeMillis();
      ((aj)localObject).bMH();
    }
    com.tencent.mm.media.camera.g.a.nwB.remove(i);
    AppMethodBeat.o(237181);
  }
  
  public final void setCustomRender(d paramd)
  {
    AppMethodBeat.i(237176);
    bnJ().setCustomRender(paramd);
    AppMethodBeat.o(237176);
  }
  
  public final void switchCamera()
  {
    AppMethodBeat.i(237166);
    f((m)new i(this, null));
    AppMethodBeat.o(237166);
  }
  
  public final void z(final Context paramContext, final boolean paramBoolean)
  {
    AppMethodBeat.i(237154);
    kotlin.g.b.s.u(paramContext, "context");
    Log.i("MicroMsg.Camera.CameraKitView", kotlin.g.b.s.X("setUpCamera backCamera:", Boolean.valueOf(paramBoolean)));
    if (this.ntl != null)
    {
      Log.w("MicroMsg.Camera.CameraKitView", "cameraInstance already setup,ignore operate");
      AppMethodBeat.o(237154);
      return;
    }
    f((m)new h(this, paramContext, paramBoolean, null));
    AppMethodBeat.o(237154);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    b(a parama, Surface paramSurface, Integer paramInteger1, Integer paramInteger2, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237087);
      paramObject = (kotlin.d.d)new b(this.nto, paramSurface, paramInteger1, paramInteger2, paramd);
      AppMethodBeat.o(237087);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237081);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237081);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = a.b(this.nto);
        Surface localSurface = paramSurface;
        Integer localInteger1 = paramInteger1;
        Integer localInteger2 = paramInteger2;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.a(localSurface, localInteger1, localInteger2, locald) == locala)
        {
          AppMethodBeat.o(237081);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = com.tencent.mm.media.camera.g.a.nwA;
      com.tencent.mm.media.camera.g.a.K(a.a(this.nto), "surface");
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(237081);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    c(a parama, SurfaceTexture paramSurfaceTexture, Integer paramInteger1, Integer paramInteger2, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237089);
      paramObject = (kotlin.d.d)new c(this.nto, paramSurfaceTexture, paramInteger1, paramInteger2, paramd);
      AppMethodBeat.o(237089);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237082);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237082);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = a.b(this.nto);
        SurfaceTexture localSurfaceTexture = paramSurfaceTexture;
        Integer localInteger1 = paramInteger1;
        Integer localInteger2 = paramInteger2;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (e.a(paramObject, localSurfaceTexture, localInteger1, localInteger2, locald) == locala)
        {
          AppMethodBeat.o(237082);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = com.tencent.mm.media.camera.g.a.nwA;
      com.tencent.mm.media.camera.g.a.K(a.a(this.nto), "texture");
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(237082);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class e
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    public e(float paramFloat1, float paramFloat2, a parama, kotlin.d.d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237102);
      paramObject = (kotlin.d.d)new e(this.ZA, this.Zz, this.nto, paramd);
      AppMethodBeat.o(237102);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237092);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237092);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      Log.i("MicroMsg.Camera.CameraKitView", "focusOn point[" + this.ZA + ' ' + this.Zz + ']');
      paramObject = a.c(this.nto);
      if (paramObject != null) {
        paramObject.ak(this.ZA, this.Zz);
      }
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(237092);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/media/camera/render/GLEnvPreloadBuilder;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<com.tencent.mm.media.camera.f.c>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class g
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    long Yx;
    int label;
    
    public g(a parama, boolean paramBoolean, kotlin.d.d<? super g> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237011);
      paramObject = (kotlin.d.d)new g(this.nto, this.ntu, paramd);
      AppMethodBeat.o(237011);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237004);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      long l;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237004);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        l = Util.currentTicks();
        paramObject = a.c(this.nto);
        if (paramObject != null)
        {
          boolean bool = this.ntu;
          kotlin.d.d locald = (kotlin.d.d)this;
          this.Yx = l;
          this.label = 1;
          if (paramObject.a(Boolean.valueOf(bool), locald) == locala)
          {
            AppMethodBeat.o(237004);
            return locala;
          }
        }
        break;
      case 1: 
        l = this.Yx;
        ResultKt.throwOnFailure(paramObject);
      }
      for (;;)
      {
        Log.i("MicroMsg.Camera.CameraKitView", kotlin.g.b.s.X("preOpenCamera cost:", kotlin.d.b.a.b.BF(Util.ticksToNow(l))));
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(237004);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    h(a parama, Context paramContext, boolean paramBoolean, kotlin.d.d<? super h> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237031);
      paramObject = (kotlin.d.d)new h(this.nto, paramContext, paramBoolean, paramd);
      AppMethodBeat.o(237031);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237020);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237020);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        a.a(this.nto, a.d(this.nto));
        paramObject = a.c(this.nto);
        if (paramObject != null)
        {
          Context localContext = paramContext;
          q localq = (q)a.e(this.nto);
          e locale = a.b(this.nto);
          f localf = (f)this.nto;
          boolean bool = paramBoolean;
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          if (paramObject.a(localContext, localq, locale, localf, bool, locald) == locala)
          {
            AppMethodBeat.o(237020);
            return locala;
          }
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      Log.i("MicroMsg.Camera.CameraKitView", kotlin.g.b.s.X("setUpCamera cameraInstance:", a.c(this.nto)));
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(237020);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    i(a parama, kotlin.d.d<? super i> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237023);
      paramObject = (kotlin.d.d)new i(this.nto, paramd);
      AppMethodBeat.o(237023);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237014);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      kotlin.d.d locald;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237014);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = a.b(this.nto);
        locald = (kotlin.d.d)this;
        this.label = 1;
        if (e.a(paramObject, locald) == locala)
        {
          AppMethodBeat.o(237014);
          return locala;
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = a.c(this.nto);
        if (paramObject != null)
        {
          locald = (kotlin.d.d)this;
          this.label = 2;
          if (paramObject.u(locald) == locala)
          {
            AppMethodBeat.o(237014);
            return locala;
          }
        }
      case 2: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = a.b(this.nto);
        locald = (kotlin.d.d)this;
        this.label = 3;
        if (e.c(paramObject, locald) == locala)
        {
          AppMethodBeat.o(237014);
          return locala;
        }
      case 3: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = a.b(this.nto);
        locald = (kotlin.d.d)this;
        this.label = 4;
        if (e.b(paramObject, locald) == locala)
        {
          AppMethodBeat.o(237014);
          return locala;
        }
      case 4: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.nto;
        locald = (kotlin.d.d)this;
        this.label = 5;
        if (b.a(paramObject, locald) != locala) {
          break label266;
        }
        AppMethodBeat.o(237014);
        return locala;
      }
      ResultKt.throwOnFailure(paramObject);
      label266:
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(237014);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class j
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    Object L$0;
    int label;
    
    public j(boolean paramBoolean, a parama, kotlin.d.d<? super j> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237003);
      paramObject = (kotlin.d.d)new j(this.ntv, this.nto, paramd);
      AppMethodBeat.o(237003);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(236998);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(236998);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Log.i("MicroMsg.Camera.CameraKitView", kotlin.g.b.s.X("switchToCamera back:", Boolean.valueOf(this.ntv)));
        paramObject = a.c(this.nto);
        if (paramObject == null) {
          break label372;
        }
        localObject = paramObject.bob();
        if (localObject == null) {
          break label372;
        }
        boolean bool = this.ntv;
        paramObject = this.nto;
        if (((((com.tencent.mm.media.camera.d.c)localObject).nvA) && (bool)) || ((!((com.tencent.mm.media.camera.d.c)localObject).nvA) && (!bool))) {
          break label372;
        }
        localObject = a.b(paramObject);
        this.L$0 = paramObject;
        this.label = 1;
        if (e.a((e)localObject, this) == locala)
        {
          AppMethodBeat.o(236998);
          return locala;
        }
      case 1: 
        localObject = (a)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localObject;
        com.tencent.mm.media.camera.instance.c localc = a.c(paramObject);
        localObject = paramObject;
        if (localc != null)
        {
          this.L$0 = paramObject;
          this.label = 2;
          localObject = paramObject;
          if (localc.u(this) == locala)
          {
            AppMethodBeat.o(236998);
            return locala;
          }
        }
      case 2: 
        localObject = (a)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = a.b((a)localObject);
        this.L$0 = localObject;
        this.label = 3;
        if (e.c(paramObject, this) == locala)
        {
          AppMethodBeat.o(236998);
          return locala;
        }
      case 3: 
        localObject = (a)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = a.b((a)localObject);
        this.L$0 = localObject;
        this.label = 4;
        if (e.b(paramObject, this) == locala)
        {
          AppMethodBeat.o(236998);
          return locala;
        }
      case 4: 
        localObject = (a)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        this.L$0 = null;
        this.label = 5;
        if (b.a((a)localObject, this) != locala) {
          break label372;
        }
        AppMethodBeat.o(236998);
        return locala;
      }
      ResultKt.throwOnFailure(paramObject);
      label372:
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(236998);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.d.b.a.d
  {
    Object L$0;
    long Yx;
    int label;
    
    k(a parama, kotlin.d.d<? super k> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(236992);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.nto.a(0, 0, 0, (kotlin.d.d)this);
      AppMethodBeat.o(236992);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    l(a parama, kotlin.d.d<? super l> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(236996);
      paramObject = (kotlin.d.d)new l(this.nto, paramd);
      AppMethodBeat.o(236996);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(236991);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(236991);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = a.b(this.nto);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (e.d(paramObject, locald) == locala)
        {
          AppMethodBeat.o(236991);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(236991);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    m(a parama, int paramInt1, int paramInt2, kotlin.d.d<? super m> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237012);
      paramObject = (kotlin.d.d)new m(this.nto, paramInt1, paramInt2, paramd);
      AppMethodBeat.o(237012);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237005);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      int i;
      int j;
      kotlin.d.d locald;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237005);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = com.tencent.mm.media.camera.g.a.nwA;
        i = a.a(this.nto);
        j = paramInt1;
        int k = paramInt2;
        paramObject = com.tencent.mm.media.camera.g.a.tW(i);
        if (paramObject != null)
        {
          paramObject.ios = j;
          paramObject.iot = k;
        }
        paramObject = a.b(this.nto);
        i = paramInt1;
        j = paramInt2;
        locald = (kotlin.d.d)this;
        this.label = 1;
        if (e.a(paramObject, i, j, locald) == locala)
        {
          AppMethodBeat.o(237005);
          return locala;
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = a.c(this.nto);
        if (paramObject == null) {
          break label218;
        }
        i = paramInt1;
        j = paramInt2;
        locald = (kotlin.d.d)this;
        this.label = 2;
        if (paramObject.c(i, j, locald) != locala) {
          break label218;
        }
        AppMethodBeat.o(237005);
        return locala;
      }
      ResultKt.throwOnFailure(paramObject);
      label218:
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(237005);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.a
 * JD-Core Version:    0.7.0.1
 */