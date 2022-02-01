package com.tencent.mm.media.camera.instance.camera1;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Looper;
import androidx.lifecycle.j;
import androidx.lifecycle.j.b;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.w;
import com.tencent.mm.media.camera.d.i;
import com.tencent.mm.media.camera.e.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Ljava.lang.Boolean;>;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/instance/camera1/Camera1Impl;", "Lcom/tencent/mm/media/camera/instance/BaseCameraInstance;", "sessionId", "", "(I)V", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "cameraRes", "Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "currentScreenSize", "Lcom/tencent/mm/media/camera/model/GLSize;", "focusHelper", "Lcom/tencent/mm/media/camera/instance/camera1/Camera1FocusHelper;", "selfControlLifecycle", "Lcom/tencent/mm/media/camera/instance/camera1/Camera1Lifecycle;", "zoomHelper", "Lcom/tencent/mm/media/camera/instance/camera1/Camera1ZoomHelper;", "bindHelperCameraRes", "", "res", "createCamera", "backCamera", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "focusOn", "x", "", "y", "getCameraOrientation", "isBackCamera", "needMirror", "onZoomIn", "onZoomOut", "setCameraKitSetting", "setting", "Lcom/tencent/mm/media/camera/model/CameraKitCommonSetting;", "setPreviewCallbackBuffer", "setup", "context", "Landroid/content/Context;", "lifecycle", "Landroidx/lifecycle/LifecycleOwner;", "glEnvBuilder", "Lcom/tencent/mm/media/camera/GLEnvBuilder;", "cameraCoroutines", "Lcom/tencent/mm/media/camera/ICameraCoroutines;", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mm/media/camera/GLEnvBuilder;Lcom/tencent/mm/media/camera/ICameraCoroutines;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupCamera", "cameraId", "startPreview", "(Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopPreview", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchCamera", "updateCameraParameter", "screenSize", "(Lcom/tencent/mm/media/camera/model/GLSize;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFocusParam", "rotate", "updateScreenSize", "width", "height", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.media.camera.instance.a
{
  public static final c.a nuN;
  private w lTN;
  private d.a.a nuJ;
  private final Camera1Lifecycle nuO;
  private final b nuP;
  private final e nuQ;
  private com.tencent.mm.media.camera.d.h nuR;
  
  static
  {
    AppMethodBeat.i(237481);
    nuN = new c.a((byte)0);
    AppMethodBeat.o(237481);
  }
  
  public c(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(237424);
    this.nuO = new Camera1Lifecycle(this);
    this.nuP = new b();
    this.nuQ = new e();
    AppMethodBeat.o(237424);
  }
  
  private final Object a(com.tencent.mm.media.camera.d.h paramh, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(237433);
    j localj;
    if ((paramd instanceof j))
    {
      localj = (j)paramd;
      if ((localj.label & 0x80000000) != 0) {
        localj.label += -2147483648;
      }
    }
    Object localObject;
    kotlin.d.a.a locala;
    for (;;)
    {
      localObject = localj.result;
      locala = kotlin.d.a.a.aiwj;
      switch (localj.label)
      {
      default: 
        paramh = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237433);
        throw paramh;
        localj = new j(this, paramd);
      }
    }
    ResultKt.throwOnFailure(localObject);
    paramd = this.lTN;
    if (paramd == null)
    {
      paramd = null;
      d.a(paramd, paramh);
      d.d(paramd);
      paramh = bnY();
      if (paramh != null) {
        break label269;
      }
      i = 30;
      label150:
      if (paramd != null) {
        break label277;
      }
      Log.e("MicroMsg.Camera.Camera1Impl", "trySetPreviewFrameRateParameters error, p is null!");
    }
    for (;;)
    {
      paramh = this.lTN;
      if (paramh != null) {
        paramh.c(paramd);
      }
      if (paramd == null) {
        break label565;
      }
      bnZ().frameRate = paramd.getPreviewFrameRate();
      localObject = bnX();
      s.checkNotNull(localObject);
      i = paramd.getPreviewSize().width;
      int j = paramd.getPreviewSize().height;
      localj.L$0 = this;
      localj.Uf = paramd;
      localj.label = 1;
      paramh = this;
      if (((com.tencent.mm.media.camera.e)localObject).b(i, j, localj) != locala) {
        break label551;
      }
      AppMethodBeat.o(237433);
      return locala;
      paramd = paramd.aPy();
      break;
      label269:
      i = paramh.nvw;
      break label150;
      try
      {
        label277:
        localObject = paramd.getSupportedPreviewFrameRates();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          paramh = ((Collection)localObject).toArray(new Integer[0]);
          if (paramh != null) {
            break label364;
          }
          paramh = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(237433);
          throw paramh;
        }
      }
      catch (Exception paramh)
      {
        Log.i("MicroMsg.Camera.Camera1Impl", "trySetPreviewFrameRateParameters Exception, %s, %s", new Object[] { Looper.myLooper(), paramh.getMessage() });
      }
    }
    label364:
    if (paramh == null)
    {
      paramh = "null";
      label372:
      Log.i("MicroMsg.Camera.Camera1Impl", s.X("frame list:", paramh));
      if (i == 0) {
        break label496;
      }
      paramh = Collections.max((Collection)localObject);
      s.s(paramh, "max(fr)");
    }
    for (int i = Math.min(i, ((Number)paramh).intValue());; i = Math.min(30, ((Number)paramh).intValue()))
    {
      paramd.setPreviewFrameRate(i);
      Log.i("MicroMsg.Camera.Camera1Impl", "set preview frame rate %d", new Object[] { Integer.valueOf(i) });
      break;
      StringBuilder localStringBuilder = new StringBuilder(kotlin.k.k.qv(paramh.length, 429496729) * 5 + 2);
      kotlin.a.m.a(paramh, localStringBuilder, (List)new ArrayList());
      paramh = localStringBuilder.toString();
      s.s(paramh, "StringBuilder(capacity).…builderAction).toString()");
      break label372;
      label496:
      paramh = Collections.max((Collection)localObject);
      s.s(paramh, "max(fr)");
    }
    paramd = (Camera.Parameters)localj.Uf;
    paramh = (c)localj.L$0;
    ResultKt.throwOnFailure(localObject);
    label551:
    paramh = paramh.lTN;
    if (paramh != null) {
      paramh.c(paramd);
    }
    label565:
    paramh = ah.aiuX;
    AppMethodBeat.o(237433);
    return paramh;
  }
  
  private final void a(d.a.a parama)
  {
    AppMethodBeat.i(237440);
    this.nuP.nuJ = parama;
    this.nuQ.b(parama);
    AppMethodBeat.o(237440);
  }
  
  private static final void a(final c paramc, final w paramw, byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(237444);
    s.u(paramc, "this$0");
    s.u(paramw, "$camera");
    paramCamera = paramc.bnW();
    if (paramCamera != null) {
      paramCamera.f((kotlin.g.a.m)new c(paramArrayOfByte, paramc, paramw, null));
    }
    AppMethodBeat.o(237444);
  }
  
  private boolean boi()
  {
    AppMethodBeat.i(237441);
    if (bnZ().cameraId == 0)
    {
      AppMethodBeat.o(237441);
      return true;
    }
    AppMethodBeat.o(237441);
    return false;
  }
  
  public final Object a(Context paramContext, final q paramq, final com.tencent.mm.media.camera.e parame, com.tencent.mm.media.camera.f paramf, final boolean paramBoolean, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(237495);
    Object localObject1;
    if ((paramd instanceof d))
    {
      localObject1 = (d)paramd;
      if ((((d)localObject1).label & 0x80000000) != 0) {
        ((d)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new d(this, paramd))
    {
      localObject2 = paramd.result;
      localObject1 = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramContext = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237495);
        throw paramContext;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    if (paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      paramd.L$0 = this;
      paramd.Uf = paramq;
      paramd.VC = paramf;
      paramd.YF = paramBoolean;
      paramd.label = 1;
      if (super.a(paramContext, paramq, parame, paramf, bool, paramd) != localObject1) {
        break;
      }
      AppMethodBeat.o(237495);
      return localObject1;
    }
    paramBoolean = paramd.YF;
    parame = (com.tencent.mm.media.camera.f)paramd.VC;
    paramq = (q)paramd.Uf;
    paramContext = (c)paramd.L$0;
    ResultKt.throwOnFailure(localObject2);
    for (;;)
    {
      paramf = (kotlin.d.f)bg.kCh();
      if (paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramContext = (kotlin.g.a.m)new e(paramContext, paramq, parame, paramBoolean, null);
        paramd.L$0 = null;
        paramd.Uf = null;
        paramd.VC = null;
        paramd.label = 2;
        if (l.a(paramf, paramContext, paramd) != localObject1) {
          break;
        }
        AppMethodBeat.o(237495);
        return localObject1;
      }
      ResultKt.throwOnFailure(localObject2);
      paramContext = ah.aiuX;
      AppMethodBeat.o(237495);
      return paramContext;
      parame = paramf;
      paramContext = this;
    }
  }
  
  public final Object a(final Boolean paramBoolean, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(237518);
    f localf;
    if ((paramd instanceof f))
    {
      localf = (f)paramd;
      if ((localf.label & 0x80000000) != 0) {
        localf.label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (;;)
    {
      localObject1 = localf.result;
      locala = kotlin.d.a.a.aiwj;
      switch (localf.label)
      {
      default: 
        paramBoolean = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237518);
        throw paramBoolean;
        localf = new f(this, paramd);
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Log.i("MicroMsg.Camera.Camera1Impl", s.X("startPreview isPreviewing:", Boolean.valueOf(boa())));
    if (!boa()) {
      paramd = this;
    }
    for (;;)
    {
      try
      {
        localf.L$0 = this;
        paramd = this;
        localf.Uf = paramBoolean;
        paramd = this;
        localf.label = 1;
        paramd = this;
        Object localObject2 = super.a(paramBoolean, localf);
        localObject1 = this;
        if (localObject2 == locala)
        {
          AppMethodBeat.o(237518);
          return locala;
          paramd = (Boolean)localf.Uf;
          paramBoolean = (c)localf.L$0;
        }
        localObject1 = com.tencent.mm.media.camera.g.a.nwA;
      }
      catch (Exception paramBoolean)
      {
        try
        {
          ResultKt.throwOnFailure(localObject1);
          localObject1 = paramBoolean;
          paramBoolean = paramd;
          paramd = (kotlin.d.d<? super ah>)localObject1;
          localObject2 = com.tencent.mm.media.camera.a.a.ntR;
          paramd = (kotlin.d.d<? super ah>)localObject1;
          paramBoolean = (kotlin.g.a.b)new g((c)localObject1, paramBoolean, null);
          paramd = (kotlin.d.d<? super ah>)localObject1;
          localf.L$0 = localObject1;
          paramd = (kotlin.d.d<? super ah>)localObject1;
          localf.Uf = null;
          paramd = (kotlin.d.d<? super ah>)localObject1;
          localf.label = 2;
          paramd = (kotlin.d.d<? super ah>)localObject1;
          paramBoolean = ((com.tencent.mm.media.camera.a.a)localObject2).c(paramBoolean, localf);
          if (paramBoolean == locala)
          {
            AppMethodBeat.o(237518);
            return locala;
            paramd = (c)localf.L$0;
          }
        }
        catch (Exception paramd)
        {
          for (;;)
          {
            localObject1 = paramBoolean;
            paramBoolean = paramd;
            paramd = (kotlin.d.d<? super ah>)localObject1;
          }
        }
        try
        {
          ResultKt.throwOnFailure(localObject1);
          paramBoolean = ah.aiuX;
          AppMethodBeat.o(237518);
          return paramBoolean;
        }
        catch (Exception paramBoolean)
        {
          break label323;
        }
        paramBoolean = paramBoolean;
      }
      label323:
      com.tencent.mm.media.camera.g.a.U(paramd.hBm, false);
      paramd.bnZ().nvB = false;
      Log.e("MicroMsg.Camera.Camera1Impl", s.X("startPreview error:", paramBoolean));
    }
  }
  
  public final void ak(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(237553);
    this.nuP.ak(paramFloat1, paramFloat2);
    AppMethodBeat.o(237553);
  }
  
  public final Object b(boolean paramBoolean, kotlin.d.d<? super ah> paramd)
  {
    Object localObject2 = null;
    AppMethodBeat.i(237507);
    Object localObject1;
    if ((paramd instanceof b))
    {
      localObject1 = (b)paramd;
      if ((((b)localObject1).label & 0x80000000) != 0) {
        ((b)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new b(this, paramd))
    {
      localObject1 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237507);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    if (paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      paramd.L$0 = this;
      paramd.YF = paramBoolean;
      paramd.label = 1;
      if (super.b(bool, paramd) != locala) {
        break;
      }
      AppMethodBeat.o(237507);
      return locala;
    }
    paramBoolean = paramd.YF;
    paramd = (c)paramd.L$0;
    ResultKt.throwOnFailure(localObject1);
    for (;;)
    {
      int i;
      if ((paramBoolean) && (paramd.bnZ().nvz.lSY))
      {
        paramd.bnZ().nvA = true;
        i = com.tencent.mm.compatible.deviceinfo.d.aOr();
      }
      for (;;)
      {
        paramd.bnZ().cameraId = i;
        localObject1 = paramd.getContext();
        Log.i("MicroMsg.Camera.Camera1Impl", "setupCamera");
        long l = Util.currentTicks();
        try
        {
          localObject1 = com.tencent.mm.compatible.deviceinfo.d.G((Context)localObject1, i);
          paramd.nuJ = ((d.a.a)localObject1);
          localObject1 = paramd.nuJ;
          if (localObject1 == null)
          {
            localObject1 = localObject2;
            paramd.lTN = ((w)localObject1);
            localObject1 = paramd.lTN;
            if (localObject1 != null) {
              ((w)localObject1).qV(0);
            }
            paramd.a(paramd.nuJ);
            Log.i("MicroMsg.Camera.Camera1Impl", s.X("setupCamera finish cost:", Long.valueOf(Util.ticksToNow(l))));
            paramd = ah.aiuX;
            AppMethodBeat.o(237507);
            return paramd;
            paramd.bnZ().nvA = false;
            i = com.tencent.mm.compatible.deviceinfo.d.aOs();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e("MicroMsg.Camera.Camera1Impl", s.X("openCamera failed:", localException.getMessage()));
            w localw = null;
            continue;
            localw = localw.lTN;
          }
        }
      }
      paramd = this;
    }
  }
  
  /* Error */
  public final void bof()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 659
    //   6: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 156	com/tencent/mm/media/camera/instance/camera1/c:nuQ	Lcom/tencent/mm/media/camera/instance/camera1/e;
    //   13: astore 6
    //   15: aload 6
    //   17: getfield 662	com/tencent/mm/media/camera/instance/camera1/e:isZooming	Z
    //   20: ifeq +19 -> 39
    //   23: ldc_w 664
    //   26: ldc_w 666
    //   29: invokestatic 669	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: ldc_w 659
    //   35: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: return
    //   39: aload 6
    //   41: iconst_1
    //   42: putfield 662	com/tencent/mm/media/camera/instance/camera1/e:isZooming	Z
    //   45: aload 6
    //   47: getfield 672	com/tencent/mm/media/camera/instance/camera1/e:nve	Lcom/tencent/mm/compatible/deviceinfo/d$a$a;
    //   50: astore 4
    //   52: aload 4
    //   54: ifnonnull +69 -> 123
    //   57: aconst_null
    //   58: astore 4
    //   60: aload 4
    //   62: ifnull +89 -> 151
    //   65: aload 4
    //   67: invokevirtual 675	android/hardware/Camera$Parameters:isZoomSupported	()Z
    //   70: iconst_1
    //   71: if_icmpne +80 -> 151
    //   74: iconst_1
    //   75: istore_1
    //   76: iload_1
    //   77: ifeq +183 -> 260
    //   80: aload 4
    //   82: invokevirtual 678	android/hardware/Camera$Parameters:getZoom	()I
    //   85: istore_1
    //   86: aload 6
    //   88: getfield 682	com/tencent/mm/media/camera/instance/camera1/e:nvd	Ljava/util/ArrayList;
    //   91: iload_1
    //   92: invokestatic 359	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   95: invokevirtual 686	java/util/ArrayList:indexOf	(Ljava/lang/Object;)I
    //   98: istore_2
    //   99: aload 4
    //   101: invokevirtual 689	android/hardware/Camera$Parameters:getMaxZoom	()I
    //   104: istore_3
    //   105: iload_1
    //   106: iload_3
    //   107: if_icmplt +49 -> 156
    //   110: aload 6
    //   112: iconst_0
    //   113: putfield 662	com/tencent/mm/media/camera/instance/camera1/e:isZooming	Z
    //   116: ldc_w 659
    //   119: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: return
    //   123: aload 4
    //   125: getfield 656	com/tencent/mm/compatible/deviceinfo/d$a$a:lTN	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   128: astore 4
    //   130: aload 4
    //   132: ifnonnull +9 -> 141
    //   135: aconst_null
    //   136: astore 4
    //   138: goto -78 -> 60
    //   141: aload 4
    //   143: invokevirtual 273	com/tencent/mm/compatible/deviceinfo/w:aPy	()Landroid/hardware/Camera$Parameters;
    //   146: astore 4
    //   148: goto -88 -> 60
    //   151: iconst_0
    //   152: istore_1
    //   153: goto -77 -> 76
    //   156: aload 6
    //   158: getfield 682	com/tencent/mm/media/camera/instance/camera1/e:nvd	Ljava/util/ArrayList;
    //   161: iload_2
    //   162: iconst_1
    //   163: iadd
    //   164: aload 6
    //   166: getfield 682	com/tencent/mm/media/camera/instance/camera1/e:nvd	Ljava/util/ArrayList;
    //   169: invokevirtual 690	java/util/ArrayList:size	()I
    //   172: iconst_1
    //   173: isub
    //   174: invokestatic 350	java/lang/Math:min	(II)I
    //   177: invokevirtual 694	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   180: astore 7
    //   182: aload 7
    //   184: ldc_w 696
    //   187: invokestatic 339	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   190: aload 7
    //   192: checkcast 341	java/lang/Number
    //   195: invokevirtual 344	java/lang/Number:intValue	()I
    //   198: istore_1
    //   199: ldc_w 664
    //   202: ldc_w 698
    //   205: iconst_2
    //   206: anewarray 304	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: iload_1
    //   212: invokestatic 359	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   215: aastore
    //   216: dup
    //   217: iconst_1
    //   218: aload 4
    //   220: invokevirtual 701	android/hardware/Camera$Parameters:isSmoothZoomSupported	()Z
    //   223: invokestatic 548	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   226: aastore
    //   227: invokestatic 703	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   230: aload 4
    //   232: iload_1
    //   233: invokevirtual 706	android/hardware/Camera$Parameters:setZoom	(I)V
    //   236: aload 6
    //   238: getfield 672	com/tencent/mm/media/camera/instance/camera1/e:nve	Lcom/tencent/mm/compatible/deviceinfo/d$a$a;
    //   241: astore 7
    //   243: aload 7
    //   245: ifnonnull +28 -> 273
    //   248: aload 5
    //   250: ifnull +10 -> 260
    //   253: aload 5
    //   255: aload 4
    //   257: invokevirtual 223	com/tencent/mm/compatible/deviceinfo/w:c	(Landroid/hardware/Camera$Parameters;)V
    //   260: aload 6
    //   262: iconst_0
    //   263: putfield 662	com/tencent/mm/media/camera/instance/camera1/e:isZooming	Z
    //   266: ldc_w 659
    //   269: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: return
    //   273: aload 7
    //   275: getfield 656	com/tencent/mm/compatible/deviceinfo/d$a$a:lTN	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   278: astore 5
    //   280: goto -32 -> 248
    //   283: astore 4
    //   285: ldc_w 664
    //   288: aload 4
    //   290: checkcast 708	java/lang/Throwable
    //   293: ldc_w 710
    //   296: iconst_0
    //   297: anewarray 304	java/lang/Object
    //   300: invokestatic 714	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   303: aload 6
    //   305: iconst_0
    //   306: putfield 662	com/tencent/mm/media/camera/instance/camera1/e:isZooming	Z
    //   309: ldc_w 659
    //   312: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   315: return
    //   316: astore 4
    //   318: aload 6
    //   320: iconst_0
    //   321: putfield 662	com/tencent/mm/media/camera/instance/camera1/e:isZooming	Z
    //   324: ldc_w 659
    //   327: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   330: aload 4
    //   332: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	this	c
    //   75	158	1	i	int
    //   98	66	2	j	int
    //   104	4	3	k	int
    //   50	206	4	localObject1	Object
    //   283	6	4	localException	Exception
    //   316	15	4	localObject2	Object
    //   1	278	5	localw	w
    //   13	306	6	locale	e
    //   180	94	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   65	74	283	java/lang/Exception
    //   80	105	283	java/lang/Exception
    //   156	243	283	java/lang/Exception
    //   253	260	283	java/lang/Exception
    //   273	280	283	java/lang/Exception
    //   65	74	316	finally
    //   80	105	316	finally
    //   156	243	316	finally
    //   253	260	316	finally
    //   273	280	316	finally
    //   285	303	316	finally
  }
  
  /* Error */
  public final void bog()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 716
    //   6: invokestatic 119	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 156	com/tencent/mm/media/camera/instance/camera1/c:nuQ	Lcom/tencent/mm/media/camera/instance/camera1/e;
    //   13: astore 5
    //   15: aload 5
    //   17: getfield 662	com/tencent/mm/media/camera/instance/camera1/e:isZooming	Z
    //   20: ifeq +19 -> 39
    //   23: ldc_w 664
    //   26: ldc_w 666
    //   29: invokestatic 669	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: ldc_w 716
    //   35: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: return
    //   39: aload 5
    //   41: iconst_1
    //   42: putfield 662	com/tencent/mm/media/camera/instance/camera1/e:isZooming	Z
    //   45: aload 5
    //   47: getfield 672	com/tencent/mm/media/camera/instance/camera1/e:nve	Lcom/tencent/mm/compatible/deviceinfo/d$a$a;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnonnull +58 -> 110
    //   55: aconst_null
    //   56: astore_3
    //   57: aload_3
    //   58: ifnull +74 -> 132
    //   61: aload_3
    //   62: invokevirtual 675	android/hardware/Camera$Parameters:isZoomSupported	()Z
    //   65: iconst_1
    //   66: if_icmpne +66 -> 132
    //   69: iconst_1
    //   70: istore_1
    //   71: iload_1
    //   72: ifeq +143 -> 215
    //   75: aload_3
    //   76: invokevirtual 678	android/hardware/Camera$Parameters:getZoom	()I
    //   79: istore_1
    //   80: aload 5
    //   82: getfield 682	com/tencent/mm/media/camera/instance/camera1/e:nvd	Ljava/util/ArrayList;
    //   85: iload_1
    //   86: invokestatic 359	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: invokevirtual 686	java/util/ArrayList:indexOf	(Ljava/lang/Object;)I
    //   92: istore_2
    //   93: iload_1
    //   94: ifne +43 -> 137
    //   97: aload 5
    //   99: iconst_0
    //   100: putfield 662	com/tencent/mm/media/camera/instance/camera1/e:isZooming	Z
    //   103: ldc_w 716
    //   106: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: return
    //   110: aload_3
    //   111: getfield 656	com/tencent/mm/compatible/deviceinfo/d$a$a:lTN	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   114: astore_3
    //   115: aload_3
    //   116: ifnonnull +8 -> 124
    //   119: aconst_null
    //   120: astore_3
    //   121: goto -64 -> 57
    //   124: aload_3
    //   125: invokevirtual 273	com/tencent/mm/compatible/deviceinfo/w:aPy	()Landroid/hardware/Camera$Parameters;
    //   128: astore_3
    //   129: goto -72 -> 57
    //   132: iconst_0
    //   133: istore_1
    //   134: goto -63 -> 71
    //   137: aload 5
    //   139: getfield 682	com/tencent/mm/media/camera/instance/camera1/e:nvd	Ljava/util/ArrayList;
    //   142: iconst_0
    //   143: iload_2
    //   144: iconst_1
    //   145: isub
    //   146: invokestatic 718	java/lang/Math:max	(II)I
    //   149: invokevirtual 694	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   152: astore 6
    //   154: aload 6
    //   156: ldc_w 720
    //   159: invokestatic 339	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   162: aload 6
    //   164: checkcast 341	java/lang/Number
    //   167: invokevirtual 344	java/lang/Number:intValue	()I
    //   170: istore_1
    //   171: ldc_w 664
    //   174: ldc_w 722
    //   177: iload_1
    //   178: invokestatic 359	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   181: invokestatic 325	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   184: invokestatic 724	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload_3
    //   188: iload_1
    //   189: invokevirtual 706	android/hardware/Camera$Parameters:setZoom	(I)V
    //   192: aload 5
    //   194: getfield 672	com/tencent/mm/media/camera/instance/camera1/e:nve	Lcom/tencent/mm/compatible/deviceinfo/d$a$a;
    //   197: astore 6
    //   199: aload 6
    //   201: ifnonnull +27 -> 228
    //   204: aload 4
    //   206: ifnull +9 -> 215
    //   209: aload 4
    //   211: aload_3
    //   212: invokevirtual 223	com/tencent/mm/compatible/deviceinfo/w:c	(Landroid/hardware/Camera$Parameters;)V
    //   215: aload 5
    //   217: iconst_0
    //   218: putfield 662	com/tencent/mm/media/camera/instance/camera1/e:isZooming	Z
    //   221: ldc_w 716
    //   224: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: return
    //   228: aload 6
    //   230: getfield 656	com/tencent/mm/compatible/deviceinfo/d$a$a:lTN	Lcom/tencent/mm/compatible/deviceinfo/w;
    //   233: astore 4
    //   235: goto -31 -> 204
    //   238: astore_3
    //   239: ldc_w 664
    //   242: aload_3
    //   243: checkcast 708	java/lang/Throwable
    //   246: ldc_w 726
    //   249: iconst_0
    //   250: anewarray 304	java/lang/Object
    //   253: invokestatic 714	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   256: aload 5
    //   258: iconst_0
    //   259: putfield 662	com/tencent/mm/media/camera/instance/camera1/e:isZooming	Z
    //   262: ldc_w 716
    //   265: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: return
    //   269: astore_3
    //   270: aload 5
    //   272: iconst_0
    //   273: putfield 662	com/tencent/mm/media/camera/instance/camera1/e:isZooming	Z
    //   276: ldc_w 716
    //   279: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: aload_3
    //   283: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	c
    //   70	119	1	i	int
    //   92	54	2	j	int
    //   50	162	3	localObject1	Object
    //   238	5	3	localException	Exception
    //   269	14	3	localObject2	Object
    //   1	233	4	localw	w
    //   13	258	5	locale	e
    //   152	77	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   61	69	238	java/lang/Exception
    //   75	93	238	java/lang/Exception
    //   137	199	238	java/lang/Exception
    //   209	215	238	java/lang/Exception
    //   228	235	238	java/lang/Exception
    //   61	69	269	finally
    //   75	93	269	finally
    //   137	199	269	finally
    //   209	215	269	finally
    //   228	235	269	finally
    //   239	256	269	finally
  }
  
  public final int boh()
  {
    d.a.a locala = this.nuJ;
    if (locala == null) {
      return 0;
    }
    return locala.hYK;
  }
  
  public final Object c(final int paramInt1, final int paramInt2, kotlin.d.d<? super ah> paramd)
  {
    int j = 1;
    AppMethodBeat.i(237540);
    Log.i("MicroMsg.Camera.Camera1Impl", "updateScreenSize width:" + paramInt1 + " height:" + paramInt2);
    com.tencent.mm.media.camera.d.h localh = this.nuR;
    if ((localh != null) && (localh.width == paramInt1))
    {
      i = 1;
      if (i == 0) {
        break label130;
      }
      localh = this.nuR;
      if ((localh == null) || (localh.height != paramInt2)) {
        break label124;
      }
    }
    label124:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        break label130;
      }
      Log.i("MicroMsg.Camera.Camera1Impl", "jump updateScreenSize");
      paramd = ah.aiuX;
      AppMethodBeat.o(237540);
      return paramd;
      i = 0;
      break;
    }
    label130:
    this.nuR = new com.tencent.mm.media.camera.d.h(paramInt1, paramInt2);
    paramd = com.tencent.mm.media.camera.a.a.ntR.c((kotlin.g.a.b)new k(this, paramInt1, paramInt2, null), paramd);
    AppMethodBeat.o(237540);
    return paramd;
  }
  
  public final boolean needMirror()
  {
    AppMethodBeat.i(237574);
    boolean bool = boi();
    AppMethodBeat.o(237574);
    return bool;
  }
  
  public final Object s(kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(237527);
    if ((paramd instanceof h))
    {
      localObject1 = (h)paramd;
      if ((((h)localObject1).label & 0x80000000) != 0) {
        ((h)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    kotlin.d.a.a locala;
    for (;;)
    {
      localObject2 = ((h)localObject1).result;
      locala = kotlin.d.a.a.aiwj;
      switch (((h)localObject1).label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237527);
        throw paramd;
        localObject1 = new h(this, paramd);
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Log.i("MicroMsg.Camera.Camera1Impl", "stopPreview");
    ((h)localObject1).L$0 = this;
    ((h)localObject1).label = 1;
    paramd = this;
    if (super.s((kotlin.d.d)localObject1) == locala)
    {
      AppMethodBeat.o(237527);
      return locala;
      paramd = (c)((h)localObject1).L$0;
      ResultKt.throwOnFailure(localObject2);
    }
    paramd.a(null);
    Object localObject1 = paramd.lTN;
    if (localObject1 != null) {
      ((w)localObject1).auq();
    }
    localObject1 = paramd.lTN;
    if (localObject1 != null) {
      ((w)localObject1).release();
    }
    paramd.lTN = null;
    paramd = ah.aiuX;
    AppMethodBeat.o(237527);
    return paramd;
  }
  
  public final void tU(int paramInt)
  {
    AppMethodBeat.i(237546);
    super.tU(paramInt);
    Object localObject = bnX();
    s.checkNotNull(localObject);
    localObject = ((com.tencent.mm.media.camera.e)localObject).ntB.nvL;
    b localb = this.nuP;
    if (!boi()) {}
    for (boolean bool = true;; bool = false)
    {
      localb.b(bool, paramInt, boc().width, boc().height, ((com.tencent.mm.media.camera.d.h)localObject).width, ((com.tencent.mm.media.camera.d.h)localObject).height);
      AppMethodBeat.o(237546);
      return;
    }
  }
  
  public final Object u(kotlin.d.d<? super Boolean> paramd)
  {
    AppMethodBeat.i(237534);
    Object localObject1;
    if ((paramd instanceof i))
    {
      localObject1 = (i)paramd;
      if ((((i)localObject1).label & 0x80000000) != 0) {
        ((i)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super Boolean>)localObject1;; paramd = new i(this, paramd))
    {
      localObject2 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237534);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Log.i("MicroMsg.Camera.Camera1Impl", "switchCamera");
    if (((bnZ().nvA) && (bod())) || ((!bnZ().nvA) && (boe())))
    {
      paramd.L$0 = this;
      paramd.label = 1;
      localObject1 = this;
      if (s(paramd) == locala)
      {
        AppMethodBeat.o(237534);
        return locala;
        localObject1 = (c)paramd.L$0;
        ResultKt.throwOnFailure(localObject2);
      }
      if (!((c)localObject1).bnZ().nvA) {}
      for (boolean bool = true;; bool = false)
      {
        paramd.L$0 = null;
        paramd.label = 2;
        if (((c)localObject1).a(Boolean.valueOf(bool), paramd) != locala) {
          break;
        }
        AppMethodBeat.o(237534);
        return locala;
      }
      ResultKt.throwOnFailure(localObject2);
      paramd = Boolean.TRUE;
      AppMethodBeat.o(237534);
      return paramd;
    }
    paramd = Boolean.FALSE;
    AppMethodBeat.o(237534);
    return paramd;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    boolean YF;
    int label;
    
    b(c paramc, kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237403);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.nuS.b(false, (kotlin.d.d)this);
      AppMethodBeat.o(237403);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(byte[] paramArrayOfByte, c paramc, w paramw, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237400);
      paramObject = (kotlin.d.d)new c(this.ntK, paramc, paramw, paramd);
      AppMethodBeat.o(237400);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237396);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237396);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        if (this.ntK != null)
        {
          paramObject = this.ntK;
          s.s(paramObject, "data");
          if (paramObject.length != 0) {
            break label104;
          }
        }
        label104:
        for (int i = 1; i != 0; i = 0)
        {
          Log.e("MicroMsg.Camera.Camera1Impl", "onPreviewFrame, frame data is null!!");
          paramObject = ah.aiuX;
          AppMethodBeat.o(237396);
          return paramObject;
        }
        paramObject = c.c(paramc);
        if (paramObject != null)
        {
          byte[] arrayOfByte = this.ntK;
          s.s(arrayOfByte, "data");
          kotlin.d.d locald1 = (kotlin.d.d)this;
          this.label = 1;
          kotlin.d.h localh = new kotlin.d.h(kotlin.d.a.b.au(locald1));
          kotlin.d.d locald2 = (kotlin.d.d)localh;
          Log.v("MicroMsg.Camera.GLEnvBuilder", "availableListener");
          com.tencent.mm.media.camera.a.a locala1 = com.tencent.mm.media.camera.a.a.ntR;
          com.tencent.mm.media.camera.a.a.bnP();
          paramObject.h((kotlin.g.a.m)new e.d(paramObject, arrayOfByte, locald2, null));
          paramObject = localh.kli();
          if (paramObject == kotlin.d.a.a.aiwj) {
            s.u(locald1, "frame");
          }
          if (paramObject == kotlin.d.a.a.aiwj) {
            break label270;
          }
          paramObject = ah.aiuX;
        }
        break;
      }
      label270:
      for (;;)
      {
        if (paramObject == locala)
        {
          AppMethodBeat.o(237396);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
        paramw.aj(this.ntK);
        paramObject = ah.aiuX;
        AppMethodBeat.o(237396);
        return paramObject;
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    boolean YF;
    int label;
    
    d(c paramc, kotlin.d.d<? super d> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237384);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.nuS.a(null, null, null, null, false, (kotlin.d.d)this);
      AppMethodBeat.o(237384);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    e(c paramc, q paramq, com.tencent.mm.media.camera.f paramf, boolean paramBoolean, kotlin.d.d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237395);
      paramObject = (kotlin.d.d)new e(this.nuS, paramq, parame, paramBoolean, paramd);
      AppMethodBeat.o(237395);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      boolean bool2 = true;
      AppMethodBeat.i(237390);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237390);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = c.a(this.nuS);
      localObject = paramq;
      com.tencent.mm.media.camera.f localf = parame;
      s.u(localObject, "owner");
      s.u(localf, "cameraCoroutines");
      if (localObject.hashCode() != paramObject.nuZ)
      {
        Log.i("MicroMsg.Camera.Camera1Lifecycle", s.X("attachLifeCycleOwner :", localObject));
        paramObject.nuZ = localObject.hashCode();
        paramObject.nuw = localf;
        ((q)localObject).getLifecycle().addObserver((p)paramObject);
        if (((q)localObject).getLifecycle().getCurrentState() == j.b.bHk) {
          localf.f((kotlin.g.a.m)new Camera1Lifecycle.b(paramObject, null));
        }
      }
      paramObject = c.b(this.nuS).nvz;
      boolean bool3 = paramBoolean;
      paramObject.nvv = com.tencent.mm.compatible.deviceinfo.d.aOG();
      int k = paramObject.nvv;
      if (k > 0) {}
      int j;
      label356:
      label362:
      for (int i = 0;; i = j)
      {
        j = i + 1;
        localObject = new Camera.CameraInfo();
        Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
        if (((Camera.CameraInfo)localObject).facing == 0)
        {
          bool1 = true;
          paramObject.lSY = bool1;
          paramObject.lSW = d.tV(paramObject.nvv);
          paramObject = new StringBuilder("cameraCount:").append(paramObject.nvv).append(" hasFrontCamera:").append(paramObject.lSW).append(" hasBackCamera:").append(paramObject.lSY).append(" backCamera:");
          if (!bool3) {
            break label356;
          }
        }
        for (boolean bool1 = bool2;; bool1 = false)
        {
          Log.i("MicroMsg.Camera.Camera1Impl", bool1);
          paramObject = ah.aiuX;
          AppMethodBeat.o(237390);
          return paramObject;
          if (j < k) {
            break label362;
          }
          bool1 = false;
          break;
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    f(c paramc, kotlin.d.d<? super f> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237385);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.nuS.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(237385);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.d.b.a.k
    implements kotlin.g.a.b<kotlin.d.d<? super ah>, Object>
  {
    long Yx;
    int label;
    
    g(c paramc, Boolean paramBoolean, kotlin.d.d<? super g> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237410);
      paramd = (kotlin.d.d)new g(this.nuS, paramBoolean, paramd);
      AppMethodBeat.o(237410);
      return paramd;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237402);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject;
      boolean bool1;
      label221:
      label234:
      long l;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237402);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = c.c(this.nuS);
        if (paramObject != null)
        {
          localObject = (kotlin.d.d)this;
          this.label = 1;
          if (paramObject.r((kotlin.d.d)localObject) == locala)
          {
            AppMethodBeat.o(237402);
            return locala;
          }
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        Log.i("MicroMsg.Camera.Camera1Impl", "makeSureEnvSetup");
        localObject = this.nuS;
        paramObject = c.c(this.nuS);
        if (paramObject == null)
        {
          paramObject = null;
          c.a((c)localObject, paramObject);
          paramObject = this.nuS;
          localObject = paramBoolean;
          if (localObject != null) {
            break label221;
          }
        }
        for (bool1 = c.b(this.nuS).nvA;; bool1 = ((Boolean)localObject).booleanValue())
        {
          localObject = (kotlin.d.d)this;
          this.label = 2;
          if (paramObject.b(bool1, (kotlin.d.d)localObject) != locala) {
            break label234;
          }
          AppMethodBeat.o(237402);
          return locala;
          paramObject = paramObject.ntB.nvL;
          break;
        }
      case 2: 
        ResultKt.throwOnFailure(paramObject);
        if (c.d(this.nuS) == null)
        {
          paramObject = this.nuS;
          localObject = com.tencent.mm.media.camera.g.a.nwA;
          com.tencent.mm.media.camera.g.a.U(paramObject.hBm, false);
          Log.e("MicroMsg.Camera.Camera1Impl", "startPreview error");
          paramObject = ah.aiuX;
          AppMethodBeat.o(237402);
          return paramObject;
        }
        paramObject = this.nuS;
        localObject = (kotlin.d.d)this;
        this.label = 3;
        if (c.a(paramObject, (kotlin.d.d)localObject) == locala)
        {
          AppMethodBeat.o(237402);
          return locala;
        }
      case 3: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = com.tencent.mm.media.camera.b.a.nul;
        boolean bool2 = com.tencent.mm.media.camera.b.a.gh(false);
        if (bool2)
        {
          bool1 = true;
          Log.i("MicroMsg.Camera.Camera1Impl", s.X("use texturePreview:", Boolean.valueOf(bool1)));
          if (!bool2) {
            c.e(this.nuS);
          }
          l = System.currentTimeMillis();
          paramObject = c.c(this.nuS);
          s.checkNotNull(paramObject);
          if (!bool2) {
            break label431;
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          localObject = (kotlin.d.d)this;
          this.Yx = l;
          this.label = 4;
          localObject = paramObject.a(bool1, (kotlin.d.d)localObject);
          paramObject = localObject;
          if (localObject != locala) {
            break label446;
          }
          AppMethodBeat.o(237402);
          return locala;
          bool1 = false;
          break;
        }
      case 4: 
        label431:
        l = this.Yx;
        ResultKt.throwOnFailure(paramObject);
        label446:
        paramObject = (SurfaceTexture)paramObject;
        if (paramObject == null)
        {
          paramObject = this.nuS;
          localObject = com.tencent.mm.media.camera.g.a.nwA;
          com.tencent.mm.media.camera.g.a.U(paramObject.hBm, false);
          Log.e("MicroMsg.Camera.Camera1Impl", "startPreview error for null texture");
          paramObject = ah.aiuX;
          AppMethodBeat.o(237402);
          return paramObject;
        }
        Log.i("MicroMsg.Camera.Camera1Impl", s.X("getGLInputTexture cost:", kotlin.d.b.a.b.BF(System.currentTimeMillis() - l)));
        localObject = c.d(this.nuS);
        if (localObject != null) {
          ((w)localObject).f(paramObject);
        }
        paramObject = c.d(this.nuS);
        if (paramObject != null) {
          paramObject.aPz();
        }
        paramObject = this.nuS;
        localObject = (kotlin.d.d)this;
        this.label = 5;
        if (c.b(paramObject, (kotlin.d.d)localObject) != locala) {
          break label585;
        }
        AppMethodBeat.o(237402);
        return locala;
      }
      ResultKt.throwOnFailure(paramObject);
      label585:
      paramObject = com.tencent.mm.media.camera.g.a.nwA;
      com.tencent.mm.media.camera.g.a.U(this.nuS.hBm, true);
      Log.i("MicroMsg.Camera.Camera1Impl", "startPreview finish");
      paramObject = ah.aiuX;
      AppMethodBeat.o(237402);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    h(c paramc, kotlin.d.d<? super h> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237392);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.nuS.s((kotlin.d.d)this);
      AppMethodBeat.o(237392);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    i(c paramc, kotlin.d.d<? super i> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237391);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.nuS.u((kotlin.d.d)this);
      AppMethodBeat.o(237391);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    j(c paramc, kotlin.d.d<? super j> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237398);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = c.a(this.nuS, null, (kotlin.d.d)this);
      AppMethodBeat.o(237398);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.d.b.a.k
    implements kotlin.g.a.b<kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    k(c paramc, int paramInt1, int paramInt2, kotlin.d.d<? super k> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237416);
      paramd = (kotlin.d.d)new k(this.nuS, paramInt1, paramInt2, paramd);
      AppMethodBeat.o(237416);
      return paramd;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237408);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237408);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = c.c(this.nuS);
        if (paramObject != null)
        {
          localObject = (kotlin.d.d)this;
          this.label = 1;
          if (com.tencent.mm.media.camera.e.a(paramObject, (kotlin.d.d)localObject) == locala)
          {
            AppMethodBeat.o(237408);
            return locala;
          }
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.nuS;
        localObject = new com.tencent.mm.media.camera.d.h(paramInt1, paramInt2);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 2;
        if (c.a(paramObject, (com.tencent.mm.media.camera.d.h)localObject, locald) == locala)
        {
          AppMethodBeat.o(237408);
          return locala;
        }
      case 2: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.nuS;
        localObject = (kotlin.d.d)this;
        this.label = 3;
        if (c.b(paramObject, (kotlin.d.d)localObject) == locala)
        {
          AppMethodBeat.o(237408);
          return locala;
        }
      case 3: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = c.c(this.nuS);
        if (paramObject == null)
        {
          AppMethodBeat.o(237408);
          return null;
        }
        localObject = (kotlin.d.d)this;
        this.label = 4;
        localObject = com.tencent.mm.media.camera.e.b(paramObject, (kotlin.d.d)localObject);
        paramObject = localObject;
        if (localObject != locala) {
          break label253;
        }
        AppMethodBeat.o(237408);
        return locala;
      }
      ResultKt.throwOnFailure(paramObject);
      label253:
      paramObject = (ah)paramObject;
      AppMethodBeat.o(237408);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.instance.camera1.c
 * JD-Core Version:    0.7.0.1
 */