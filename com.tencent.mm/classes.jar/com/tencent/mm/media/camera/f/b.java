package com.tencent.mm.media.camera.f;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLExt;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.camera.d.h;
import com.tencent.mm.media.camera.d.i;
import com.tencent.mm.media.camera.l;
import com.tencent.mm.media.j.b.f;
import com.tencent.mm.media.util.c;
import com.tencent.mm.media.util.c.a;
import com.tencent.mm.media.util.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d<-Lcom.tencent.mm.media.g.d;>;
import kotlin.d.d<-Ljava.lang.Long;>;
import kotlin.d.d<-Lkotlin.ah;>;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/render/CameraRenderPipeline;", "Lcom/tencent/mm/media/camera/ICameraRenderExport;", "sessionId", "", "sizeParameter", "Lcom/tencent/mm/media/camera/model/GLSizeParameter;", "(ILcom/tencent/mm/media/camera/model/GLSizeParameter;)V", "awaitFrameContinuation", "Lkotlin/coroutines/Continuation;", "", "customRender", "Lcom/tencent/mm/media/camera/CustomRenderCallback;", "customRenderCost", "", "formatRender", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "formatRenderCost", "glEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "lastTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "performance", "", "screenRender", "screenRenderCost", "screenTexture", "yuvRender", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcYuvToRgb;", "awaitFrameRender", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearFrame", "input", "(Lcom/tencent/mm/media/globject/GLTextureObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "drawLastFrame", "finishedAwaitAfterRender", "getCurrentFrame", "Landroid/graphics/Bitmap;", "performanceCheck", "release", "render", "data", "", "width", "height", "([BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renderCost", "function", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renderFormat", "renderScreen", "renderYUV", "setCustomRender", "setGLEnv", "env", "setUpInGLEnv", "Companion", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements l
{
  public static final b.a nwh;
  private int hBm;
  private final i ntB;
  public c.b ntD;
  public f nwi;
  public com.tencent.mm.media.j.b.a nwj;
  public com.tencent.mm.media.j.b.a nwk;
  public com.tencent.mm.media.camera.d nwl;
  private com.tencent.mm.media.g.d nwm;
  private com.tencent.mm.media.g.d nwn;
  private final boolean nwo;
  private long nwp;
  private long nwq;
  private long nwr;
  
  static
  {
    AppMethodBeat.i(237292);
    nwh = new b.a((byte)0);
    AppMethodBeat.o(237292);
  }
  
  public b(int paramInt, i parami)
  {
    AppMethodBeat.i(237173);
    this.hBm = paramInt;
    this.ntB = parami;
    parami = com.tencent.mm.media.camera.b.a.nul;
    this.nwo = com.tencent.mm.media.camera.b.a.bnU();
    AppMethodBeat.o(237173);
  }
  
  private final Object b(final byte[] paramArrayOfByte, final int paramInt1, final int paramInt2, kotlin.d.d<? super com.tencent.mm.media.g.d> paramd)
  {
    AppMethodBeat.i(237178);
    if ((paramd instanceof l))
    {
      localObject = (l)paramd;
      if ((((l)localObject).label & 0x80000000) != 0) {
        ((l)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super com.tencent.mm.media.g.d>)localObject;; paramd = new l(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramArrayOfByte = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237178);
        throw paramArrayOfByte;
      }
    }
    ResultKt.throwOnFailure(localObject);
    paramArrayOfByte = (kotlin.g.a.b)new m(this, paramArrayOfByte, paramInt1, paramInt2, null);
    paramd.L$0 = this;
    paramd.label = 1;
    Object localObject = d(paramArrayOfByte, paramd);
    paramd = (kotlin.d.d<? super com.tencent.mm.media.g.d>)localObject;
    paramArrayOfByte = this;
    if (localObject == locala)
    {
      AppMethodBeat.o(237178);
      return locala;
      paramArrayOfByte = (b)paramd.L$0;
      ResultKt.throwOnFailure(localObject);
      paramd = (kotlin.d.d<? super com.tencent.mm.media.g.d>)localObject;
    }
    paramArrayOfByte.nwp = (((Number)paramd).longValue() + paramArrayOfByte.nwp);
    paramArrayOfByte = paramArrayOfByte.nwi;
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(237178);
      return null;
    }
    paramArrayOfByte = paramArrayOfByte.nDF;
    AppMethodBeat.o(237178);
    return paramArrayOfByte;
  }
  
  private final void bov()
  {
    AppMethodBeat.i(237210);
    if (this.nwo) {
      GLES20.glFinish();
    }
    AppMethodBeat.o(237210);
  }
  
  private final Object c(final com.tencent.mm.media.g.d paramd, kotlin.d.d<? super com.tencent.mm.media.g.d> paramd1)
  {
    AppMethodBeat.i(237185);
    if ((paramd1 instanceof h))
    {
      localObject = (h)paramd1;
      if ((((h)localObject).label & 0x80000000) != 0) {
        ((h)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd1 = (kotlin.d.d<? super com.tencent.mm.media.g.d>)localObject;; paramd1 = new h(this, paramd1))
    {
      localObject = paramd1.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd1.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237185);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject);
    if (paramd == null)
    {
      AppMethodBeat.o(237185);
      return null;
    }
    paramd = (kotlin.g.a.b)new i(this, paramd, null);
    paramd1.L$0 = this;
    paramd1.label = 1;
    Object localObject = d(paramd, paramd1);
    paramd1 = (kotlin.d.d<? super com.tencent.mm.media.g.d>)localObject;
    paramd = this;
    if (localObject == locala)
    {
      AppMethodBeat.o(237185);
      return locala;
      paramd = (b)paramd1.L$0;
      ResultKt.throwOnFailure(localObject);
      paramd1 = (kotlin.d.d<? super com.tencent.mm.media.g.d>)localObject;
    }
    paramd.nwp = (((Number)paramd1).longValue() + paramd.nwp);
    paramd = paramd.nwj;
    if (paramd == null)
    {
      AppMethodBeat.o(237185);
      return null;
    }
    paramd = paramd.nDF;
    AppMethodBeat.o(237185);
    return paramd;
  }
  
  private final Object d(final com.tencent.mm.media.g.d paramd, kotlin.d.d<? super com.tencent.mm.media.g.d> paramd1)
  {
    AppMethodBeat.i(237193);
    if ((paramd1 instanceof b))
    {
      localObject = (b)paramd1;
      if ((((b)localObject).label & 0x80000000) != 0) {
        ((b)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd1 = (kotlin.d.d<? super com.tencent.mm.media.g.d>)localObject;; paramd1 = new b(this, paramd1))
    {
      localObject = paramd1.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd1.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237193);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject);
    paramd = (kotlin.g.a.b)new c(this, paramd, null);
    paramd1.L$0 = this;
    paramd1.label = 1;
    Object localObject = d(paramd, paramd1);
    paramd1 = (kotlin.d.d<? super com.tencent.mm.media.g.d>)localObject;
    paramd = this;
    if (localObject == locala)
    {
      AppMethodBeat.o(237193);
      return locala;
      paramd = (b)paramd1.L$0;
      ResultKt.throwOnFailure(localObject);
      paramd1 = (kotlin.d.d<? super com.tencent.mm.media.g.d>)localObject;
    }
    paramd.nwq = (((Number)paramd1).longValue() + paramd.nwq);
    paramd = paramd.nwm;
    AppMethodBeat.o(237193);
    return paramd;
  }
  
  private final Object d(kotlin.g.a.b<? super kotlin.d.d<? super ah>, ? extends Object> paramb, kotlin.d.d<? super Long> paramd)
  {
    AppMethodBeat.i(237207);
    if ((paramd instanceof g))
    {
      localObject1 = (g)paramd;
      if ((((g)localObject1).label & 0x80000000) != 0) {
        ((g)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super Long>)localObject1;; paramd = new g(this, paramd))
    {
      localObject2 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramb = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237207);
        throw paramb;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    long l = System.currentTimeMillis();
    paramd.L$0 = this;
    paramd.Yx = l;
    paramd.label = 1;
    Object localObject1 = this;
    if (paramb.invoke(paramd) == locala)
    {
      AppMethodBeat.o(237207);
      return locala;
      l = paramd.Yx;
      localObject1 = (b)paramd.L$0;
      ResultKt.throwOnFailure(localObject2);
    }
    ((b)localObject1).bov();
    paramb = kotlin.d.b.a.b.BF(System.currentTimeMillis() - l);
    AppMethodBeat.o(237207);
    return paramb;
  }
  
  private final Object e(final com.tencent.mm.media.g.d paramd, kotlin.d.d<? super ah> paramd1)
  {
    AppMethodBeat.i(237199);
    if ((paramd1 instanceof j))
    {
      localObject = (j)paramd1;
      if ((((j)localObject).label & 0x80000000) != 0) {
        ((j)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd1 = (kotlin.d.d<? super ah>)localObject;; paramd1 = new j(this, paramd1))
    {
      localObject = paramd1.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd1.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237199);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject);
    if (paramd == null)
    {
      paramd = ah.aiuX;
      AppMethodBeat.o(237199);
      return paramd;
    }
    paramd = (kotlin.g.a.b)new k(this, paramd, null);
    paramd1.L$0 = this;
    paramd1.label = 1;
    Object localObject = d(paramd, paramd1);
    paramd1 = (kotlin.d.d<? super ah>)localObject;
    paramd = this;
    if (localObject == locala)
    {
      AppMethodBeat.o(237199);
      return locala;
      paramd = (b)paramd1.L$0;
      ResultKt.throwOnFailure(localObject);
      paramd1 = (kotlin.d.d<? super ah>)localObject;
    }
    paramd.nwr = (((Number)paramd1).longValue() + paramd.nwr);
    paramd1 = com.tencent.mm.media.camera.g.a.nwA;
    int i = paramd.hBm;
    long l1 = paramd.nwp;
    long l2 = paramd.nwq;
    long l3 = paramd.nwr;
    paramd = com.tencent.mm.media.camera.g.a.tW(i);
    if (paramd != null)
    {
      paramd.ioA = l1;
      paramd.ioB = l2;
      paramd.ioC = l3;
    }
    paramd = ah.aiuX;
    AppMethodBeat.o(237199);
    return paramd;
  }
  
  public final Object a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(237315);
    if ((paramd instanceof f))
    {
      localObject1 = (f)paramd;
      if ((((f)localObject1).label & 0x80000000) != 0) {
        ((f)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new f(this, paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramArrayOfByte = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237315);
        throw paramArrayOfByte;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    paramd.L$0 = this;
    paramd.label = 1;
    Object localObject2 = b(paramArrayOfByte, paramInt1, paramInt2, paramd);
    Object localObject1 = localObject2;
    paramArrayOfByte = this;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(237315);
      return locala;
      paramArrayOfByte = (b)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
    }
    localObject1 = (com.tencent.mm.media.g.d)localObject1;
    if (localObject1 == null)
    {
      Log.i("MicroMsg.Camera.CameraRenderPipeline", "renderFormat return null");
      paramArrayOfByte = ah.aiuX;
      AppMethodBeat.o(237315);
      return paramArrayOfByte;
    }
    paramd.L$0 = paramArrayOfByte;
    paramd.Uf = paramArrayOfByte;
    paramd.label = 2;
    localObject2 = paramArrayOfByte.d((com.tencent.mm.media.g.d)localObject1, paramd);
    Object localObject3;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(237315);
      return locala;
      localObject3 = (b)paramd.Uf;
      paramArrayOfByte = (b)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
      localObject2 = localObject1;
    }
    for (;;)
    {
      ((b)localObject3).nwm = ((com.tencent.mm.media.g.d)localObject2);
      localObject1 = paramArrayOfByte.nwm;
      paramd.L$0 = null;
      paramd.Uf = null;
      paramd.label = 3;
      if (paramArrayOfByte.e((com.tencent.mm.media.g.d)localObject1, paramd) == locala)
      {
        AppMethodBeat.o(237315);
        return locala;
        ResultKt.throwOnFailure(localObject1);
      }
      paramArrayOfByte = ah.aiuX;
      AppMethodBeat.o(237315);
      return paramArrayOfByte;
      localObject1 = paramArrayOfByte;
      localObject3 = localObject1;
    }
  }
  
  public final Object b(com.tencent.mm.media.g.d paramd, kotlin.d.d<? super ah> paramd1)
  {
    AppMethodBeat.i(237305);
    if ((paramd1 instanceof e))
    {
      localObject1 = (e)paramd1;
      if ((((e)localObject1).label & 0x80000000) != 0) {
        ((e)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd1 = (kotlin.d.d<? super ah>)localObject1;; paramd1 = new e(this, paramd1))
    {
      localObject1 = paramd1.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd1.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237305);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    paramd1.L$0 = this;
    paramd1.label = 1;
    Object localObject2 = c(paramd, paramd1);
    Object localObject1 = localObject2;
    paramd = this;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(237305);
      return locala;
      paramd = (b)paramd1.L$0;
      ResultKt.throwOnFailure(localObject1);
    }
    localObject1 = (com.tencent.mm.media.g.d)localObject1;
    if (localObject1 == null)
    {
      Log.i("MicroMsg.Camera.CameraRenderPipeline", "renderFormat return null");
      paramd = ah.aiuX;
      AppMethodBeat.o(237305);
      return paramd;
    }
    paramd1.L$0 = paramd;
    paramd1.Uf = paramd;
    paramd1.label = 2;
    localObject2 = paramd.d((com.tencent.mm.media.g.d)localObject1, paramd1);
    Object localObject3;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(237305);
      return locala;
      localObject3 = (b)paramd1.Uf;
      paramd = (b)paramd1.L$0;
      ResultKt.throwOnFailure(localObject1);
      localObject2 = localObject1;
    }
    for (;;)
    {
      ((b)localObject3).nwm = ((com.tencent.mm.media.g.d)localObject2);
      localObject1 = paramd.nwm;
      paramd1.L$0 = null;
      paramd1.Uf = null;
      paramd1.label = 3;
      if (paramd.e((com.tencent.mm.media.g.d)localObject1, paramd1) == locala)
      {
        AppMethodBeat.o(237305);
        return locala;
        ResultKt.throwOnFailure(localObject1);
      }
      paramd = ah.aiuX;
      AppMethodBeat.o(237305);
      return paramd;
      localObject1 = paramd;
      localObject3 = localObject1;
    }
  }
  
  public final Bitmap bou()
  {
    AppMethodBeat.i(237326);
    try
    {
      Object localObject = c.nFs;
      localObject = this.nwm;
      if (localObject == null)
      {
        AppMethodBeat.o(237326);
        return null;
      }
      localObject = c.a.ad(((com.tencent.mm.media.g.d)localObject).nAF, ((com.tencent.mm.media.g.d)localObject).width, ((com.tencent.mm.media.g.d)localObject).height);
      AppMethodBeat.o(237326);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.Camera.CameraRenderPipeline", (Throwable)localException, "getCurrentFrame error", new Object[0]);
      AppMethodBeat.o(237326);
    }
    return null;
  }
  
  public final void setCustomRender(com.tencent.mm.media.camera.d paramd)
  {
    this.nwl = paramd;
  }
  
  public final Object v(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(237319);
    Object localObject1;
    if ((paramd instanceof d))
    {
      localObject1 = (d)paramd;
      if ((((d)localObject1).label & 0x80000000) != 0) {
        ((d)localObject1).label += -2147483648;
      }
    }
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new d(this, paramd))
    {
      localObject2 = paramd.result;
      localObject1 = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237319);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Object localObject2 = this.nwn;
    if (localObject2 != null)
    {
      Log.i("MicroMsg.Camera.CameraRenderPipeline", "drawLastFrame");
      paramd.label = 1;
      if (e((com.tencent.mm.media.g.d)localObject2, paramd) == localObject1)
      {
        AppMethodBeat.o(237319);
        return localObject1;
        ResultKt.throwOnFailure(localObject2);
      }
    }
    paramd = ah.aiuX;
    AppMethodBeat.o(237319);
    return paramd;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    b(b paramb, kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237197);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = b.c(this.nws, (kotlin.d.d)this);
      AppMethodBeat.o(237197);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements kotlin.g.a.b<kotlin.d.d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    c(b paramb, com.tencent.mm.media.g.d paramd, kotlin.d.d<? super c> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237220);
      paramd = (kotlin.d.d)new c(this.nws, paramd, paramd);
      AppMethodBeat.o(237220);
      return paramd;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237211);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237211);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.nws;
        localObject1 = b.d(this.nws);
        if (localObject1 != null) {
          break;
        }
      }
      for (Object localObject1 = null;; localObject1 = (com.tencent.mm.media.g.d)localObject1)
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = paramd;
        }
        b.a(paramObject, (com.tencent.mm.media.g.d)localObject2);
        paramObject = ah.aiuX;
        AppMethodBeat.o(237211);
        return paramObject;
        localObject2 = paramd;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.L$0 = paramObject;
        this.label = 1;
        localObject2 = ((com.tencent.mm.media.camera.d)localObject1).a((com.tencent.mm.media.g.d)localObject2, locald);
        localObject1 = localObject2;
        if (localObject2 == locala)
        {
          AppMethodBeat.o(237211);
          return locala;
          localObject2 = (b)this.L$0;
          ResultKt.throwOnFailure(paramObject);
          localObject1 = paramObject;
          paramObject = localObject2;
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.d
  {
    int label;
    
    d(b paramb, kotlin.d.d<? super d> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237192);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.nws.v((kotlin.d.d)this);
      AppMethodBeat.o(237192);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    e(b paramb, kotlin.d.d<? super e> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237196);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.nws.b(null, (kotlin.d.d)this);
      AppMethodBeat.o(237196);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    f(b paramb, kotlin.d.d<? super f> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237201);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.nws.a(null, 0, 0, (kotlin.d.d)this);
      AppMethodBeat.o(237201);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.d.b.a.d
  {
    Object L$0;
    long Yx;
    int label;
    
    g(b paramb, kotlin.d.d<? super g> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237162);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = b.e(this.nws, (kotlin.d.d)this);
      AppMethodBeat.o(237162);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    h(b paramb, kotlin.d.d<? super h> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237169);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = b.b(this.nws, (kotlin.d.d)this);
      AppMethodBeat.o(237169);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends k
    implements kotlin.g.a.b<kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    i(b paramb, com.tencent.mm.media.g.d paramd, kotlin.d.d<? super i> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237183);
      paramd = (kotlin.d.d)new i(this.nws, paramd, paramd);
      AppMethodBeat.o(237183);
      return paramd;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237179);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237179);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = b.c(this.nws);
      if (paramObject != null) {
        paramObject.el(paramd.width, paramd.height);
      }
      paramObject = b.c(this.nws);
      if (paramObject != null) {
        paramObject.ek(b.b(this.nws).nvN.width, b.b(this.nws).nvN.height);
      }
      paramObject = b.c(this.nws);
      if (paramObject != null) {
        paramObject.uc(paramd.nAF);
      }
      paramObject = b.c(this.nws);
      if (paramObject != null) {
        paramObject.th(b.b(this.nws).nvO);
      }
      paramObject = b.c(this.nws);
      if (paramObject != null) {
        paramObject.gr(b.b(this.nws).nvG);
      }
      paramObject = b.c(this.nws);
      if (paramObject != null) {
        paramObject.bgE();
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(237179);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    j(b paramb, kotlin.d.d<? super j> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237167);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = b.d(this.nws, (kotlin.d.d)this);
      AppMethodBeat.o(237167);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends k
    implements kotlin.g.a.b<kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    k(b paramb, com.tencent.mm.media.g.d paramd, kotlin.d.d<? super k> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237184);
      paramd = (kotlin.d.d)new k(this.nws, paramd, paramd);
      AppMethodBeat.o(237184);
      return paramd;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237180);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237180);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      b.b(this.nws, paramd);
      paramObject = b.e(this.nws);
      if (paramObject != null) {
        paramObject.el(paramd.width, paramd.height);
      }
      paramObject = b.e(this.nws);
      if (paramObject != null) {
        paramObject.ek(b.b(this.nws).nvL.width, b.b(this.nws).nvL.height);
      }
      paramObject = b.e(this.nws);
      if (paramObject != null) {
        paramObject.uc(paramd.nAF);
      }
      paramObject = b.e(this.nws);
      if (paramObject != null) {
        paramObject.bgE();
      }
      paramObject = b.f(this.nws);
      if (paramObject != null)
      {
        EGLExt.eglPresentationTimeANDROID(paramObject.nFB, paramObject.eglSurface, System.nanoTime());
        EGL14.eglSwapBuffers(paramObject.nFB, paramObject.eglSurface);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(237180);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    l(b paramb, kotlin.d.d<? super l> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237187);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = b.a(this.nws, (kotlin.d.d)this);
      AppMethodBeat.o(237187);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends k
    implements kotlin.g.a.b<kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    m(b paramb, byte[] paramArrayOfByte, int paramInt1, int paramInt2, kotlin.d.d<? super m> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237194);
      paramd = (kotlin.d.d)new m(this.nws, paramArrayOfByte, paramInt1, paramInt2, paramd);
      AppMethodBeat.o(237194);
      return paramd;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237190);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237190);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = b.a(this.nws);
      if (paramObject != null) {
        paramObject.ap(paramArrayOfByte);
      }
      paramObject = b.a(this.nws);
      if (paramObject != null) {
        paramObject.el(paramInt1, paramInt2);
      }
      paramObject = b.a(this.nws);
      if (paramObject != null) {
        paramObject.ek(b.b(this.nws).nvN.width, b.b(this.nws).nvN.height);
      }
      paramObject = b.a(this.nws);
      if (paramObject != null) {
        paramObject.th(b.b(this.nws).nvO);
      }
      paramObject = b.a(this.nws);
      if (paramObject != null) {
        paramObject.gr(b.b(this.nws).nvG);
      }
      paramObject = b.a(this.nws);
      if (paramObject != null) {
        paramObject.bgE();
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(237190);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.f.b
 * JD-Core Version:    0.7.0.1
 */