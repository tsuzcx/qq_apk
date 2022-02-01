package com.tencent.mm.media.camera.instance.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.a.c.b;
import androidx.camera.core.ad;
import androidx.camera.core.ad.a;
import androidx.camera.core.ad.e;
import androidx.camera.core.ae;
import androidx.camera.core.ag;
import androidx.camera.core.ag.a;
import androidx.camera.core.ap;
import androidx.camera.core.ap.a;
import androidx.camera.core.aw;
import androidx.camera.core.aw.b;
import androidx.camera.core.ba;
import androidx.camera.core.impl.af;
import androidx.camera.core.impl.al;
import androidx.camera.core.impl.as;
import androidx.camera.core.impl.bk;
import androidx.camera.core.impl.u;
import androidx.camera.core.q.a;
import androidx.camera.core.r;
import androidx.camera.core.t;
import androidx.camera.core.y.a;
import androidx.camera.lifecycle.LifecycleCamera;
import androidx.camera.lifecycle.LifecycleCameraRepository;
import androidx.camera.lifecycle.LifecycleCameraRepository.a;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j;
import androidx.lifecycle.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.camera.e.g;
import com.tencent.mm.media.camera.instance.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Landroid.graphics.Bitmap;>;
import kotlin.d.d<-Ljava.lang.Boolean;>;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/instance/camerax/CameraXImpl;", "Lcom/tencent/mm/media/camera/instance/BaseCameraInstance;", "Landroidx/lifecycle/Observer;", "Landroidx/camera/core/CameraState;", "sessionId", "", "(I)V", "camera", "Landroidx/camera/core/Camera;", "cameraProvider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "imageCapture", "Landroidx/camera/core/ImageCapture;", "lensFacing", "meteringPointFactory", "Lcom/tencent/mm/media/camera/instance/camerax/SurfaceCropMeteringPointFactory;", "preview", "Landroidx/camera/core/Preview;", "rotation", "bindCameraUseCases", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildImageCapture", "cameraKitInfo", "Lcom/tencent/mm/media/camera/model/CameraKitInfo;", "createCamera", "backCamera", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "focusOn", "x", "", "y", "getCameraOrientation", "hasBackCamera", "hasFrontCamera", "isBackCamera", "needMirror", "onChanged", "cameraState", "onZoomIn", "onZoomOut", "setup", "context", "Landroid/content/Context;", "lifecycle", "Landroidx/lifecycle/LifecycleOwner;", "glEnvBuilder", "Lcom/tencent/mm/media/camera/GLEnvBuilder;", "cameraCoroutines", "Lcom/tencent/mm/media/camera/ICameraCoroutines;", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mm/media/camera/GLEnvBuilder;Lcom/tencent/mm/media/camera/ICameraCoroutines;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startPreview", "(Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchCamera", "takePictureAsync", "Landroid/graphics/Bitmap;", "width", "height", "rotate", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFocusParam", "updateScreenSize", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.media.camera.instance.a
  implements androidx.lifecycle.y<r>
{
  public static final a.a nvf;
  private androidx.camera.lifecycle.c nvg;
  private int nvh;
  private ad nvi;
  private ap nvj;
  private volatile androidx.camera.core.i nvk;
  private b nvl;
  private final int rotation;
  
  static
  {
    AppMethodBeat.i(237429);
    nvf = new a.a((byte)0);
    AppMethodBeat.o(237429);
  }
  
  public a(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(237345);
    this.nvh = 1;
    ad localad = new ad.a().jc();
    s.s(localad, "Builder().build()");
    this.nvi = localad;
    this.nvl = new b();
    AppMethodBeat.o(237345);
  }
  
  private boolean boi()
  {
    return this.nvh == 1;
  }
  
  private static final void e(com.google.b.b.a.f paramf)
  {
    AppMethodBeat.i(237357);
    try
    {
      androidx.camera.core.impl.a.b.e.a((Future)paramf);
      AppMethodBeat.o(237357);
      return;
    }
    catch (ExecutionException paramf)
    {
      Log.i("MicroMsg.Camera.CameraXImpl", s.X("focusOn error:", paramf.getCause()));
      AppMethodBeat.o(237357);
      return;
    }
    catch (RuntimeException paramf)
    {
      Log.i("MicroMsg.Camera.CameraXImpl", s.X("focusOn error:", paramf));
      AppMethodBeat.o(237357);
      return;
    }
    catch (Error paramf)
    {
      Log.i("MicroMsg.Camera.CameraXImpl", s.X("focusOn error:", paramf));
      AppMethodBeat.o(237357);
    }
  }
  
  public final Object a(Context paramContext, androidx.lifecycle.q paramq, com.tencent.mm.media.camera.e parame, com.tencent.mm.media.camera.f paramf, boolean paramBoolean, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(237434);
    if ((paramd instanceof e))
    {
      localObject1 = (e)paramd;
      if ((((e)localObject1).label & 0x80000000) != 0) {
        ((e)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new e(this, paramd))
    {
      localObject2 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramContext = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237434);
        throw paramContext;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    if (paramBoolean)
    {
      bool = true;
      Log.i("MicroMsg.Camera.CameraXImpl", s.X("setup backCamera:", Boolean.valueOf(bool)));
      if (!paramBoolean) {
        break label222;
      }
    }
    label222:
    for (boolean bool = true;; bool = false)
    {
      paramd.L$0 = this;
      paramd.YF = paramBoolean;
      paramd.label = 1;
      localObject1 = this;
      if (super.a(paramContext, paramq, parame, paramf, bool, paramd) != locala) {
        break label250;
      }
      AppMethodBeat.o(237434);
      return locala;
      bool = false;
      break;
    }
    paramBoolean = paramd.YF;
    Object localObject1 = (a)paramd.L$0;
    ResultKt.throwOnFailure(localObject2);
    label250:
    int i;
    if (paramBoolean)
    {
      i = 1;
      ((a)localObject1).nvh = i;
      if (!paramBoolean) {
        break label314;
      }
    }
    label314:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramd.L$0 = null;
      paramd.label = 2;
      if (((a)localObject1).b(paramBoolean, paramd) != locala) {
        break label325;
      }
      AppMethodBeat.o(237434);
      return locala;
      i = 0;
      break;
    }
    ResultKt.throwOnFailure(localObject2);
    label325:
    paramContext = ah.aiuX;
    AppMethodBeat.o(237434);
    return paramContext;
  }
  
  public final Object a(final Boolean paramBoolean, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(237443);
    f localf;
    if ((paramd instanceof f))
    {
      localf = (f)paramd;
      if ((localf.label & 0x80000000) != 0) {
        localf.label += -2147483648;
      }
    }
    Object localObject;
    kotlin.d.a.a locala;
    for (;;)
    {
      localObject = localf.result;
      locala = kotlin.d.a.a.aiwj;
      switch (localf.label)
      {
      default: 
        paramBoolean = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237443);
        throw paramBoolean;
        localf = new f(this, paramd);
      }
    }
    ResultKt.throwOnFailure(localObject);
    Log.i("MicroMsg.Camera.CameraXImpl", s.X("startPreview backCamera:", paramBoolean));
    localf.L$0 = this;
    localf.label = 1;
    paramd = this;
    if (super.a(paramBoolean, localf) == locala)
    {
      AppMethodBeat.o(237443);
      return locala;
      paramd = (a)localf.L$0;
      ResultKt.throwOnFailure(localObject);
    }
    final com.tencent.mm.media.camera.e locale = paramd.bnX();
    if (locale == null)
    {
      paramBoolean = ah.aiuX;
      AppMethodBeat.o(237443);
      return paramBoolean;
    }
    paramBoolean = paramd.bnW();
    if (paramBoolean == null)
    {
      paramBoolean = ah.aiuX;
      AppMethodBeat.o(237443);
      return paramBoolean;
    }
    localf.L$0 = paramd;
    localf.Uf = locale;
    localf.VC = paramBoolean;
    localf.label = 2;
    if (locale.r(localf) == locala)
    {
      AppMethodBeat.o(237443);
      return locala;
      paramBoolean = (com.tencent.mm.media.camera.f)localf.VC;
      locale = (com.tencent.mm.media.camera.e)localf.Uf;
      paramd = (a)localf.L$0;
      ResultKt.throwOnFailure(localObject);
    }
    for (;;)
    {
      Log.i("MicroMsg.Camera.CameraXImpl", "makeSureEnvSetup");
      localObject = (kotlin.d.f)bg.kCh();
      paramBoolean = (kotlin.g.a.m)new g(paramd, locale, paramBoolean, null);
      localf.L$0 = null;
      localf.Uf = null;
      localf.VC = null;
      localf.label = 3;
      if (kotlinx.coroutines.l.a((kotlin.d.f)localObject, paramBoolean, localf) == locala)
      {
        AppMethodBeat.o(237443);
        return locala;
        ResultKt.throwOnFailure(localObject);
      }
      paramBoolean = ah.aiuX;
      AppMethodBeat.o(237443);
      return paramBoolean;
    }
  }
  
  public final void ak(float paramFloat1, float paramFloat2)
  {
    com.google.b.b.a.f localf = null;
    AppMethodBeat.i(237463);
    Object localObject1 = new y.a(this.nvl.o(paramFloat1, paramFloat2));
    Object localObject2 = TimeUnit.SECONDS;
    boolean bool;
    if (3L >= 1L)
    {
      bool = true;
      androidx.core.f.f.checkArgument(bool, "autoCancelDuration must be at least 1");
      ((y.a)localObject1).Ho = ((TimeUnit)localObject2).toMillis(3L);
      localObject1 = new androidx.camera.core.y((y.a)localObject1);
      s.s(localObject1, "Builder(it)\n            …\n                .build()");
      localObject2 = this.nvk;
      if (localObject2 != null) {
        break label145;
      }
    }
    for (;;)
    {
      if (localf != null)
      {
        localObject1 = new a..ExternalSyntheticLambda0(localf);
        localObject2 = bnW();
        s.checkNotNull(localObject2);
        localf.a((Runnable)localObject1, (Executor)localObject2);
      }
      AppMethodBeat.o(237463);
      return;
      bool = false;
      break;
      label145:
      localObject2 = ((androidx.camera.core.i)localObject2).iF();
      if (localObject2 != null) {
        localf = ((androidx.camera.core.k)localObject2).a((androidx.camera.core.y)localObject1);
      }
    }
  }
  
  public final Object b(final int paramInt1, final int paramInt2, final int paramInt3, kotlin.d.d<? super Bitmap> paramd)
  {
    AppMethodBeat.i(237455);
    if ((paramd instanceof j))
    {
      localObject1 = (j)paramd;
      if ((((j)localObject1).label & 0x80000000) != 0) {
        ((j)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (;;)
    {
      paramd = ((j)localObject1).result;
      locala = kotlin.d.a.a.aiwj;
      switch (((j)localObject1).label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237455);
        throw paramd;
        localObject1 = new j(this, paramd);
      }
    }
    ResultKt.throwOnFailure(paramd);
    paramd = bnW();
    if (paramd == null)
    {
      ((j)localObject1).label = 1;
      localObject1 = super.b(paramInt1, paramInt2, paramInt3, (kotlin.d.d)localObject1);
      paramd = (kotlin.d.d<? super Bitmap>)localObject1;
      if (localObject1 == locala)
      {
        AppMethodBeat.o(237455);
        return locala;
        ResultKt.throwOnFailure(paramd);
      }
      AppMethodBeat.o(237455);
      return paramd;
    }
    final long l = System.currentTimeMillis();
    Object localObject2 = com.tencent.mm.media.camera.b.a.nul;
    if (com.tencent.mm.media.camera.b.a.bnT() == 2)
    {
      ((j)localObject1).L$0 = this;
      ((j)localObject1).Uf = paramd;
      ((j)localObject1).aai = paramInt1;
      ((j)localObject1).asI = paramInt2;
      ((j)localObject1).nuz = paramInt3;
      ((j)localObject1).Yx = l;
      ((j)localObject1).label = 2;
      localObject2 = new kotlin.d.h(kotlin.d.a.b.au((kotlin.d.d)localObject1));
      kotlin.d.d locald = (kotlin.d.d)localObject2;
      this.nvi.a((Executor)paramd, (ad.e)new k(this, paramInt1, paramInt2, paramInt3, l, locald));
      localObject2 = ((kotlin.d.h)localObject2).kli();
      if (localObject2 == kotlin.d.a.a.aiwj) {
        s.u(localObject1, "frame");
      }
      paramd = (kotlin.d.d<? super Bitmap>)localObject2;
      if (localObject2 == locala)
      {
        AppMethodBeat.o(237455);
        return locala;
        ResultKt.throwOnFailure(paramd);
      }
      AppMethodBeat.o(237455);
      return paramd;
    }
    ((j)localObject1).Yx = l;
    ((j)localObject1).label = 3;
    Object localObject1 = super.b(paramInt1, paramInt2, paramInt3, (kotlin.d.d)localObject1);
    paramd = (kotlin.d.d<? super Bitmap>)localObject1;
    if (localObject1 == locala)
    {
      AppMethodBeat.o(237455);
      return locala;
      l = ((j)localObject1).Yx;
      ResultKt.throwOnFailure(paramd);
    }
    paramd = (Bitmap)paramd;
    Log.i("MicroMsg.Camera.CameraXImpl", s.X("takePictureAsync from read pixel cost:", kotlin.d.b.a.b.BF(System.currentTimeMillis() - l)));
    AppMethodBeat.o(237455);
    return paramd;
  }
  
  public final Object b(boolean paramBoolean, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(237439);
    if ((paramd instanceof d))
    {
      localObject1 = (d)paramd;
      if ((((d)localObject1).label & 0x80000000) != 0) {
        ((d)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (;;)
    {
      paramd = ((d)localObject1).result;
      locala = kotlin.d.a.a.aiwj;
      switch (((d)localObject1).label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237439);
        throw paramd;
        localObject1 = new d(this, paramd);
      }
    }
    ResultKt.throwOnFailure(paramd);
    if (paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((d)localObject1).L$0 = this;
      ((d)localObject1).label = 1;
      paramd = this;
      if (super.b(paramBoolean, (kotlin.d.d)localObject1) != locala) {
        break;
      }
      AppMethodBeat.o(237439);
      return locala;
    }
    Object localObject2 = (a)((d)localObject1).L$0;
    ResultKt.throwOnFailure(paramd);
    paramd = (kotlin.d.d<? super ah>)localObject2;
    localObject2 = androidx.camera.lifecycle.c.U(paramd.getContext());
    s.s(localObject2, "getInstance(context)");
    ((d)localObject1).L$0 = paramd;
    ((d)localObject1).label = 2;
    localObject2 = androidx.c.a.d.a((com.google.b.b.a.f)localObject2, (kotlin.d.d)localObject1);
    Object localObject1 = localObject2;
    if (localObject2 == locala)
    {
      AppMethodBeat.o(237439);
      return locala;
      localObject2 = (a)((d)localObject1).L$0;
      ResultKt.throwOnFailure(paramd);
      localObject1 = paramd;
      paramd = (kotlin.d.d<? super ah>)localObject2;
    }
    paramd.nvg = ((androidx.camera.lifecycle.c)localObject1);
    paramd = ah.aiuX;
    AppMethodBeat.o(237439);
    return paramd;
  }
  
  public final com.tencent.mm.media.camera.d.c bob()
  {
    Object localObject1 = null;
    AppMethodBeat.i(237484);
    com.tencent.mm.media.camera.d.c localc = bnZ();
    Object localObject2 = bnV();
    if (localObject2 == null) {
      if (localObject1 != j.b.bHk) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      localc.nvB = bool;
      localObject1 = super.bob();
      AppMethodBeat.o(237484);
      return localObject1;
      localObject2 = ((androidx.lifecycle.q)localObject2).getLifecycle();
      if (localObject2 == null) {
        break;
      }
      localObject1 = ((j)localObject2).getCurrentState();
      break;
    }
  }
  
  public final boolean bod()
  {
    AppMethodBeat.i(237477);
    androidx.camera.lifecycle.c localc = this.nvg;
    if (localc == null)
    {
      AppMethodBeat.o(237477);
      return false;
    }
    boolean bool = localc.a(androidx.camera.core.q.Gr);
    AppMethodBeat.o(237477);
    return bool;
  }
  
  public final boolean boe()
  {
    AppMethodBeat.i(237474);
    androidx.camera.lifecycle.c localc = this.nvg;
    if (localc == null)
    {
      AppMethodBeat.o(237474);
      return false;
    }
    boolean bool = localc.a(androidx.camera.core.q.Gs);
    AppMethodBeat.o(237474);
    return bool;
  }
  
  public final void bof()
  {
    AppMethodBeat.i(237465);
    Object localObject1 = this.nvk;
    if (localObject1 == null) {}
    for (androidx.camera.core.k localk = null; localk == null; localk = ((androidx.camera.core.i)localObject1).iF())
    {
      AppMethodBeat.o(237465);
      return;
    }
    localObject1 = this.nvk;
    if (localObject1 == null) {
      localObject1 = null;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(237465);
      return;
      localObject1 = ((androidx.camera.core.i)localObject1).iG();
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((androidx.camera.core.n)localObject1).gZ();
      }
    }
    Object localObject2 = (ba)((LiveData)localObject1).getValue();
    if (localObject2 == null) {}
    for (localObject2 = null; localObject2 == null; localObject2 = Float.valueOf(((ba)localObject2).hO()))
    {
      AppMethodBeat.o(237465);
      return;
    }
    float f1 = ((Float)localObject2).floatValue();
    localObject1 = (ba)((LiveData)localObject1).getValue();
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = Float.valueOf(((ba)localObject1).hN()))
    {
      AppMethodBeat.o(237465);
      return;
    }
    float f2 = Math.min(f1, ((Float)localObject1).floatValue() + 0.15F);
    Log.i("MicroMsg.Camera.CameraXImpl", "onZoomOut current:" + f2 + " max:" + f1);
    localk.h(f2);
    AppMethodBeat.o(237465);
  }
  
  public final void bog()
  {
    AppMethodBeat.i(237467);
    Object localObject1 = this.nvk;
    if (localObject1 == null) {}
    for (androidx.camera.core.k localk = null; localk == null; localk = ((androidx.camera.core.i)localObject1).iF())
    {
      AppMethodBeat.o(237467);
      return;
    }
    localObject1 = this.nvk;
    if (localObject1 == null) {
      localObject1 = null;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(237467);
      return;
      localObject1 = ((androidx.camera.core.i)localObject1).iG();
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = ((androidx.camera.core.n)localObject1).gZ();
      }
    }
    Object localObject2 = (ba)((LiveData)localObject1).getValue();
    if (localObject2 == null) {}
    for (localObject2 = null; localObject2 == null; localObject2 = Float.valueOf(((ba)localObject2).hP()))
    {
      AppMethodBeat.o(237467);
      return;
    }
    float f1 = ((Float)localObject2).floatValue();
    localObject1 = (ba)((LiveData)localObject1).getValue();
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = Float.valueOf(((ba)localObject1).hN()))
    {
      AppMethodBeat.o(237467);
      return;
    }
    float f2 = Math.max(f1, ((Float)localObject1).floatValue() - 0.15F);
    Log.i("MicroMsg.Camera.CameraXImpl", "onZoomIn current:" + f2 + " min:" + f1);
    localk.h(f2);
    AppMethodBeat.o(237467);
  }
  
  public final int boh()
  {
    AppMethodBeat.i(237482);
    Object localObject = this.nvk;
    if (localObject == null)
    {
      AppMethodBeat.o(237482);
      return 0;
    }
    localObject = ((androidx.camera.core.i)localObject).iG();
    if (localObject == null)
    {
      AppMethodBeat.o(237482);
      return 0;
    }
    int i = ((androidx.camera.core.n)localObject).gY();
    AppMethodBeat.o(237482);
    return i;
  }
  
  public final Object c(int paramInt1, int paramInt2, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(237459);
    paramd = c.a.a((com.tencent.mm.media.camera.instance.c)this, paramd);
    if (paramd == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(237459);
      return paramd;
    }
    paramd = ah.aiuX;
    AppMethodBeat.o(237459);
    return paramd;
  }
  
  public final boolean needMirror()
  {
    AppMethodBeat.i(369567);
    boolean bool = boi();
    AppMethodBeat.o(369567);
    return bool;
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(237445);
    super.tU(paramInt);
    Object localObject1 = bnX();
    s.checkNotNull(localObject1);
    Object localObject2 = ((com.tencent.mm.media.camera.e)localObject1).ntB.nvL;
    localObject1 = this.nvl;
    boolean bool = boi();
    int i = boc().width;
    int j = boc().height;
    int k = ((com.tencent.mm.media.camera.d.h)localObject2).width;
    int m = ((com.tencent.mm.media.camera.d.h)localObject2).height;
    ((b)localObject1).nvr.b(bool, paramInt, i, j, k, m);
    ((b)localObject1).transform.reset();
    localObject2 = ((b)localObject1).transform;
    if (bool) {}
    for (float f = -1.0F;; f = 1.0F)
    {
      ((Matrix)localObject2).setScale(f, 1.0F);
      ((b)localObject1).transform.setRotate(-paramInt, 0.5F, 0.5F);
      AppMethodBeat.o(237445);
      return;
    }
  }
  
  public final Object u(kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(237449);
    Object localObject1;
    if ((paramd instanceof h))
    {
      localObject1 = (h)paramd;
      if ((((h)localObject1).label & 0x80000000) != 0) {
        ((h)localObject1).label += -2147483648;
      }
    }
    for (paramd = (kotlin.d.d<? super Boolean>)localObject1;; paramd = new h(this, paramd))
    {
      localObject2 = paramd.result;
      localObject1 = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237449);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    this.nvh = ((this.nvh + 1) % 2);
    Object localObject2 = (kotlin.d.f)bg.kCh();
    kotlin.g.a.m localm = (kotlin.g.a.m)new i(this, null);
    paramd.label = 1;
    if (kotlinx.coroutines.l.a((kotlin.d.f)localObject2, localm, paramd) == localObject1)
    {
      AppMethodBeat.o(237449);
      return localObject1;
      ResultKt.throwOnFailure(localObject2);
    }
    paramd = Boolean.TRUE;
    AppMethodBeat.o(237449);
    return paramd;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements kotlin.g.a.b<kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(a parama, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237353);
      paramd = (kotlin.d.d)new c(this.nvm, paramd);
      AppMethodBeat.o(237353);
      return paramd;
    }
    
    public final Object invokeSuspend(Object arg1)
    {
      AppMethodBeat.i(237347);
      Object localObject1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        ??? = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237347);
        throw ???;
      }
      ResultKt.throwOnFailure(???);
      androidx.lifecycle.q localq = a.c(this.nvm);
      if (localq == null)
      {
        ??? = ah.aiuX;
        AppMethodBeat.o(237347);
        return ???;
      }
      androidx.camera.lifecycle.c localc = a.d(this.nvm);
      if (localc == null)
      {
        ??? = ah.aiuX;
        AppMethodBeat.o(237347);
        return ???;
      }
      localObject1 = new q.a().aS(a.e(this.nvm)).iJ();
      s.s(localObject1, "Builder().requireLensFacing(lensFacing).build()");
      androidx.camera.core.impl.a.l.checkMainThread();
      Object localObject5 = localc.QM;
      Object localObject6;
      for (;;)
      {
        synchronized (((LifecycleCameraRepository)localObject5).mLock)
        {
          localObject6 = ((LifecycleCameraRepository)localObject5).QJ.keySet().iterator();
          if (!((Iterator)localObject6).hasNext()) {
            break;
          }
          ??? = (LifecycleCameraRepository.a)((Iterator)localObject6).next();
          localObject8 = (LifecycleCamera)((LifecycleCameraRepository)localObject5).QJ.get(???);
        }
        synchronized (((LifecycleCamera)localObject8).mLock)
        {
          ((LifecycleCamera)localObject8).QH.l(((LifecycleCamera)localObject8).QH.kV());
          ((LifecycleCameraRepository)localObject5).c(((LifecycleCamera)localObject8).getLifecycleOwner());
          continue;
          localObject2 = finally;
          AppMethodBeat.o(237347);
          throw localObject2;
        }
      }
      for (;;)
      {
        try
        {
          localObject6 = this.nvm;
          ??? = new androidx.camera.core.ax[2];
          ???[0] = ((androidx.camera.core.ax)a.a(this.nvm));
          ???[1] = ((androidx.camera.core.ax)a.f(this.nvm));
          androidx.camera.core.impl.a.l.checkMainThread();
          ??? = new q.a(localObject3.Gt);
          i = 0;
          if (i >= 2) {
            break;
          }
          localObject5 = ???[i].JI.kK();
          if (localObject5 == null) {
            break label418;
          }
          localObject5 = ((androidx.camera.core.q)localObject5).Gt.iterator();
          if (!((Iterator)localObject5).hasNext()) {
            break label418;
          }
          localObject8 = (androidx.camera.core.m)((Iterator)localObject5).next();
          ???.Gt.add(localObject8);
          continue;
          ??? = ah.aiuX;
        }
        catch (Exception ???)
        {
          Log.e("MicroMsg.Camera.CameraXImpl", s.X("Use case binding failed:", ???));
        }
        AppMethodBeat.o(237347);
        return ???;
        label418:
        i += 1;
      }
      ??? = ???.iJ().c(localc.QR.GA.jW());
      if (???.isEmpty())
      {
        ??? = new IllegalArgumentException("Provided camera selector unable to resolve a camera for the given use case");
        AppMethodBeat.o(237347);
        throw ???;
      }
      localObject5 = new c.b(???);
      localObject5 = localc.QM.a(localq, (c.b)localObject5);
      Object localObject8 = localc.QM.ld();
      int i = 0;
      label505:
      Object localObject9;
      if (i < 2)
      {
        localObject9 = ???[i];
        Iterator localIterator = ((Collection)localObject8).iterator();
        LifecycleCamera localLifecycleCamera;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localLifecycleCamera = (LifecycleCamera)localIterator.next();
        } while ((!localLifecycleCamera.f((androidx.camera.core.ax)localObject9)) || (localLifecycleCamera == localObject5));
        ??? = new IllegalStateException(String.format("Use case %s already bound to a different lifecycle.", new Object[] { localObject9 }));
        AppMethodBeat.o(237347);
        throw ???;
      }
      if (localObject5 == null)
      {
        localObject5 = localc.QM;
        localObject8 = localc.QR;
        if (((t)localObject8).GI == null)
        {
          ??? = new IllegalStateException("CameraX not initialized yet.");
          AppMethodBeat.o(237347);
          throw ???;
        }
        localObject8 = ((t)localObject8).GI;
        localObject9 = localc.QR;
        if (((t)localObject9).GJ == null)
        {
          ??? = new IllegalStateException("CameraX not initialized yet.");
          AppMethodBeat.o(237347);
          throw ???;
        }
        localObject5 = ((LifecycleCameraRepository)localObject5).a(localq, new androidx.camera.core.a.c(???, (androidx.camera.core.impl.q)localObject8, ((t)localObject9).GJ));
        label703:
        ??? = null;
        localObject8 = localObject3.Gt.iterator();
      }
      for (;;)
      {
        if (((Iterator)localObject8).hasNext())
        {
          localObject4 = (androidx.camera.core.m)((Iterator)localObject8).next();
          if (((androidx.camera.core.m)localObject4).iI() != androidx.camera.core.m.Gq)
          {
            localObject4 = af.r(((androidx.camera.core.m)localObject4).iI()).getConfig(((LifecycleCamera)localObject5).iG(), localc.mContext);
            if (localObject4 == null) {
              continue;
            }
            if (??? == null) {
              break label888;
            }
            ??? = new IllegalArgumentException("Cannot apply multiple extended camera configs at the same time.");
            AppMethodBeat.o(237347);
            throw ???;
          }
        }
        else
        {
          ((LifecycleCamera)localObject5).a(???);
          localc.QM.a((LifecycleCamera)localObject5, Arrays.asList((Object[])???));
          a.a((a)localObject6, (androidx.camera.core.i)localObject5);
          ??? = a.g(this.nvm);
          if (??? == null) {
            break;
          }
          ??? = ???.iG();
          if (??? == null) {
            break;
          }
          ??? = ???.ha();
          if (??? == null) {
            break;
          }
          ???.a(localq, (androidx.lifecycle.y)this.nvm);
          break;
          break label703;
          i += 1;
          break label505;
        }
        Object localObject4 = ???;
        label888:
        ??? = localObject4;
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    d(a parama, kotlin.d.d<? super d> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237363);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.nvm.b(false, (kotlin.d.d)this);
      AppMethodBeat.o(237363);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.d
  {
    Object L$0;
    boolean YF;
    int label;
    
    e(a parama, kotlin.d.d<? super e> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237344);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.nvm.a(null, null, null, null, false, (kotlin.d.d)this);
      AppMethodBeat.o(237344);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    int label;
    
    f(a parama, kotlin.d.d<? super f> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237341);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.nvm.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(237341);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    g(a parama, com.tencent.mm.media.camera.e parame, com.tencent.mm.media.camera.f paramf, kotlin.d.d<? super g> paramd)
    {
      super(paramd);
    }
    
    private static final void a(final com.tencent.mm.media.camera.f paramf, final a parama, final com.tencent.mm.media.camera.e parame, aw paramaw)
    {
      AppMethodBeat.i(237350);
      paramf.f((kotlin.g.a.m)new a(paramaw, parama, parame, paramf, null));
      AppMethodBeat.o(237350);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237371);
      paramObject = (kotlin.d.d)new g(this.nvm, locale, paramBoolean, paramd);
      AppMethodBeat.o(237371);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237367);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237367);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = a.a(this.nvm);
        if (paramObject != null) {
          paramObject.a(null);
        }
        paramObject = this.nvm;
        Object localObject = new ap.a();
        Size localSize = locale.ntB.nvL.bol();
        ((ap.a)localObject).He.c(al.MK, localSize);
        int i = a.b(this.nvm);
        ((ap.a)localObject).He.c(androidx.camera.core.impl.ax.MJ, Integer.valueOf(i));
        a.a(paramObject, ((ap.a)localObject).jl());
        paramObject = a.a(this.nvm);
        if (paramObject != null) {
          paramObject.a((Executor)paramBoolean, new a.g..ExternalSyntheticLambda0(paramBoolean, this.nvm, locale));
        }
        paramObject = this.nvm;
        localObject = (kotlin.d.d)this;
        this.label = 1;
        if (a.a(paramObject, (kotlin.d.d)localObject) == locala)
        {
          AppMethodBeat.o(237367);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(237367);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
    {
      int label;
      
      a(aw paramaw, a parama, com.tencent.mm.media.camera.e parame, com.tencent.mm.media.camera.f paramf, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(237369);
        paramObject = (kotlin.d.d)new a(this.nvp, parama, parame, paramf, paramd);
        AppMethodBeat.o(237369);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(237365);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(237365);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = (kotlin.d.f)bg.kCh();
          kotlin.g.a.m localm = (kotlin.g.a.m)new kotlin.d.b.a.k(this.nvp, parama)
          {
            int label;
            
            private static final void a(aw.b paramAnonymousb) {}
            
            public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
            {
              AppMethodBeat.i(237382);
              paramAnonymousObject = (kotlin.d.d)new 1(this.nvp, this.nvm, this.nvn, this.nvo, paramAnonymousd);
              AppMethodBeat.o(237382);
              return paramAnonymousObject;
            }
            
            public final Object invokeSuspend(Object paramAnonymousObject)
            {
              AppMethodBeat.i(237378);
              kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
              Object localObject;
              switch (this.label)
              {
              default: 
                paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(237378);
                throw paramAnonymousObject;
              case 0: 
                ResultKt.throwOnFailure(paramAnonymousObject);
                localObject = new StringBuilder("onSurfaceRequested:").append(this.nvp.IZ).append(" rotate:");
                paramAnonymousObject = a.a(this.nvm);
                if (paramAnonymousObject == null) {}
                for (paramAnonymousObject = null;; paramAnonymousObject = Integer.valueOf(paramAnonymousObject.iE()))
                {
                  Log.i("MicroMsg.Camera.CameraXImpl", paramAnonymousObject);
                  paramAnonymousObject = this.nvn;
                  int i = this.nvp.IZ.getWidth();
                  int j = this.nvp.IZ.getHeight();
                  localObject = (kotlin.d.d)this;
                  this.label = 1;
                  if (paramAnonymousObject.b(i, j, (kotlin.d.d)localObject) != locala) {
                    break;
                  }
                  AppMethodBeat.o(237378);
                  return locala;
                }
              case 1: 
                ResultKt.throwOnFailure(paramAnonymousObject);
                paramAnonymousObject = this.nvm;
                localObject = (kotlin.d.d)this;
                this.label = 2;
                if (a.b(paramAnonymousObject, (kotlin.d.d)localObject) == locala)
                {
                  AppMethodBeat.o(237378);
                  return locala;
                }
              case 2: 
                ResultKt.throwOnFailure(paramAnonymousObject);
                paramAnonymousObject = this.nvn;
                localObject = (kotlin.d.d)this;
                this.label = 3;
                localObject = paramAnonymousObject.a("getGlInputSurface", (kotlin.g.a.m)new e.g(paramAnonymousObject, null), (kotlin.d.d)localObject);
                paramAnonymousObject = localObject;
                if (localObject != locala) {
                  break label292;
                }
                AppMethodBeat.o(237378);
                return locala;
              }
              ResultKt.throwOnFailure(paramAnonymousObject);
              label292:
              paramAnonymousObject = (Surface)paramAnonymousObject;
              if (paramAnonymousObject == null)
              {
                Log.e("MicroMsg.Camera.CameraXImpl", "getGLInputSurface error");
                paramAnonymousObject = ah.aiuX;
                AppMethodBeat.o(237378);
                return paramAnonymousObject;
              }
              this.nvp.a(paramAnonymousObject, (Executor)this.nvo, a.g.a.1..ExternalSyntheticLambda0.INSTANCE);
              paramAnonymousObject = ah.aiuX;
              AppMethodBeat.o(237378);
              return paramAnonymousObject;
            }
          };
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          if (kotlinx.coroutines.l.a(paramObject, localm, locald) == locala)
          {
            AppMethodBeat.o(237365);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(237365);
        return paramObject;
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.d.b.a.d
  {
    int label;
    
    h(a parama, kotlin.d.d<? super h> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237338);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.nvm.u((kotlin.d.d)this);
      AppMethodBeat.o(237338);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    i(a parama, kotlin.d.d<? super i> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237335);
      paramObject = (kotlin.d.d)new i(this.nvm, paramd);
      AppMethodBeat.o(237335);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237331);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237331);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.nvm;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (a.a(paramObject, locald) == locala)
        {
          AppMethodBeat.o(237331);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(237331);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    long Yx;
    int aai;
    int asI;
    int label;
    int nuz;
    
    j(a parama, kotlin.d.d<? super j> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237328);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.nvm.b(0, 0, 0, (kotlin.d.d)this);
      AppMethodBeat.o(237328);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/media/camera/instance/camerax/CameraXImpl$takePictureAsync$2$1", "Landroidx/camera/core/ImageCapture$OnImageCapturedCallback;", "onCaptureSuccess", "", "image", "Landroidx/camera/core/ImageProxy;", "onError", "exception", "Landroidx/camera/core/ImageCaptureException;", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    extends ad.e
  {
    k(a parama, int paramInt1, int paramInt2, int paramInt3, long paramLong, kotlin.d.d<? super Bitmap> paramd) {}
    
    public final void a(ae paramae)
    {
      AppMethodBeat.i(237360);
      s.u(paramae, "exception");
      super.a(paramae);
      Log.e("MicroMsg.Camera.CameraXImpl", "takePictureAsync from imageCapture happen error:" + paramae + " cost:" + (System.currentTimeMillis() - l));
      paramae = this.ntL;
      Result.Companion localCompanion = Result.Companion;
      paramae.resumeWith(Result.constructor-impl(null));
      AppMethodBeat.o(237360);
    }
    
    public final void d(ag paramag)
    {
      Result.Companion localCompanion = null;
      AppMethodBeat.i(237346);
      s.u(paramag, "image");
      int i = paramInt1;
      int j = paramInt2;
      int k = a.h(this.nvm).hYK;
      int m = paramInt3;
      s.u(paramag, "<this>");
      Object localObject1 = paramag.is()[0].getBuffer();
      s.s(localObject1, "planes[0].buffer");
      ((ByteBuffer)localObject1).rewind();
      Object localObject2 = new byte[((ByteBuffer)localObject1).capacity()];
      ((ByteBuffer)localObject1).get((byte[])localObject2);
      localObject1 = BitmapFactory.decodeByteArray((byte[])localObject2, 0, localObject2.length);
      s.s(localObject1, "decodeByteArray(bytes, 0, bytes.size)");
      localObject1 = a.b(i, j, k + m, (Bitmap)localObject1);
      paramag.close();
      localObject2 = new StringBuilder("takePictureAsync from imageCapture cost:").append(System.currentTimeMillis() - l).append(" size:[");
      if (localObject1 == null)
      {
        paramag = null;
        localObject2 = ((StringBuilder)localObject2).append(paramag).append(' ');
        if (localObject1 != null) {
          break label244;
        }
      }
      label244:
      for (paramag = localCompanion;; paramag = Integer.valueOf(((Bitmap)localObject1).getHeight()))
      {
        Log.i("MicroMsg.Camera.CameraXImpl", paramag + ']');
        paramag = this.ntL;
        localCompanion = Result.Companion;
        paramag.resumeWith(Result.constructor-impl(localObject1));
        AppMethodBeat.o(237346);
        return;
        paramag = Integer.valueOf(((Bitmap)localObject1).getWidth());
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.instance.a.a
 * JD-Core Version:    0.7.0.1
 */