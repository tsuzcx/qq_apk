package com.tencent.mm.media.camera.instance;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Display;
import android.view.WindowManager;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.camera.d.b;
import com.tencent.mm.media.camera.d.h;
import com.tencent.mm.media.camera.d.i;
import com.tencent.mm.media.camera.e;
import com.tencent.mm.media.camera.e.p;
import com.tencent.mm.media.camera.e.q;
import com.tencent.mm.media.camera.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/instance/BaseCameraInstance;", "Lcom/tencent/mm/media/camera/instance/ICameraInstance;", "sessionId", "", "(I)V", "cameraCoroutines", "Lcom/tencent/mm/media/camera/ICameraCoroutines;", "getCameraCoroutines", "()Lcom/tencent/mm/media/camera/ICameraCoroutines;", "setCameraCoroutines", "(Lcom/tencent/mm/media/camera/ICameraCoroutines;)V", "cameraKitCommonSetting", "Lcom/tencent/mm/media/camera/model/CameraKitCommonSetting;", "getCameraKitCommonSetting", "()Lcom/tencent/mm/media/camera/model/CameraKitCommonSetting;", "setCameraKitCommonSetting", "(Lcom/tencent/mm/media/camera/model/CameraKitCommonSetting;)V", "cameraKitInfo", "Lcom/tencent/mm/media/camera/model/CameraKitInfo;", "getCameraKitInfo", "()Lcom/tencent/mm/media/camera/model/CameraKitInfo;", "setCameraKitInfo", "(Lcom/tencent/mm/media/camera/model/CameraKitInfo;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "glEnvBuilder", "Lcom/tencent/mm/media/camera/GLEnvBuilder;", "getGlEnvBuilder", "()Lcom/tencent/mm/media/camera/GLEnvBuilder;", "setGlEnvBuilder", "(Lcom/tencent/mm/media/camera/GLEnvBuilder;)V", "lifecycle", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycle", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycle", "(Landroidx/lifecycle/LifecycleOwner;)V", "getSessionId", "()I", "setSessionId", "bitmapFormat", "Landroid/graphics/Bitmap;", "width", "height", "rotate", "bitmap", "createCamera", "", "backCamera", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "displayRotation", "getPreviewResolution", "Lcom/tencent/mm/media/camera/model/GLSize;", "hasBackCamera", "hasFrontCamera", "isPreviewing", "setCameraKitSetting", "setting", "setup", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mm/media/camera/GLEnvBuilder;Lcom/tencent/mm/media/camera/ICameraCoroutines;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startPreview", "(Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopPreview", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "takePictureAsync", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFocusParam", "updateRenderParam", "Companion", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements c
{
  public static final a.a nuu = new a.a((byte)0);
  protected Context context;
  public int hBm;
  private com.tencent.mm.media.camera.d.c ntV;
  private q nuv;
  private f nuw;
  private e nux;
  private b nuy;
  
  public a(int paramInt)
  {
    this.hBm = paramInt;
    this.ntV = new com.tencent.mm.media.camera.d.c();
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    Bitmap localBitmap;
    if (paramBitmap == null) {
      localBitmap = null;
    }
    label83:
    do
    {
      float f1;
      do
      {
        do
        {
          float f2;
          do
          {
            return localBitmap;
            if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
              break label83;
            }
            f1 = paramInt1 * 1.0F / paramBitmap.getWidth();
            f2 = paramInt2 * 1.0F / paramBitmap.getHeight();
            if ((Math.abs(f1 - f2) >= 0.1D) || (paramInt3 != 0)) {
              break;
            }
            localBitmap = paramBitmap;
          } while (f1 >= 1.0F);
          return BitmapUtil.rotateAndScale(paramBitmap, paramInt3, f1, f2);
          if (paramInt1 <= 0) {
            break label132;
          }
          f1 = paramInt1 * 1.0F / paramBitmap.getWidth();
          if (f1 < 1.0F) {
            break;
          }
          localBitmap = paramBitmap;
        } while (paramInt3 == 0);
        return BitmapUtil.rotateAndScale(paramBitmap, paramInt3, Math.min(f1, 1.0F), Math.min(f1, 1.0F));
        if (paramInt2 <= 0) {
          break label185;
        }
        f1 = Math.min(paramInt2 * 1.0F / paramBitmap.getHeight(), 1.0F);
        if (f1 < 1.0F) {
          break;
        }
        localBitmap = paramBitmap;
      } while (paramInt3 == 0);
      return BitmapUtil.rotateAndScale(paramBitmap, paramInt3, Math.min(f1, 1.0F), Math.min(f1, 1.0F));
      localBitmap = paramBitmap;
    } while (paramInt3 <= 0);
    label132:
    label185:
    return BitmapUtil.rotate(paramBitmap, paramInt3, true);
  }
  
  public Object a(Context paramContext, q paramq, e parame, f paramf, boolean paramBoolean, kotlin.d.d<? super ah> paramd)
  {
    s.u(paramContext, "<set-?>");
    this.context = paramContext;
    this.nuv = paramq;
    this.nux = parame;
    this.nuw = paramf;
    this.ntV.nvA = paramBoolean;
    paramContext = this.ntV;
    paramq = parame.ntB;
    s.u(paramq, "<set-?>");
    paramContext.ntB = paramq;
    paramContext = com.tencent.mm.media.camera.a.a.ntR;
    com.tencent.mm.media.camera.a.a.a(this.ntV);
    return ah.aiuX;
  }
  
  public Object a(Boolean paramBoolean, kotlin.d.d<? super ah> paramd)
  {
    this.ntV.nvB = true;
    return ah.aiuX;
  }
  
  public Object b(int paramInt1, int paramInt2, int paramInt3, kotlin.d.d<? super Bitmap> paramd)
  {
    return a(this, paramInt1, paramInt2, paramInt3, paramd);
  }
  
  public Object b(boolean paramBoolean, kotlin.d.d<? super ah> paramd)
  {
    paramd = com.tencent.mm.media.camera.g.a.nwA;
    paramd = com.tencent.mm.media.camera.g.a.tW(this.hBm);
    if (paramd != null) {
      paramd.iox = System.currentTimeMillis();
    }
    return ah.aiuX;
  }
  
  public final q bnV()
  {
    return this.nuv;
  }
  
  public final f bnW()
  {
    return this.nuw;
  }
  
  public final e bnX()
  {
    return this.nux;
  }
  
  protected final b bnY()
  {
    return this.nuy;
  }
  
  public final com.tencent.mm.media.camera.d.c bnZ()
  {
    return this.ntV;
  }
  
  public final boolean boa()
  {
    return this.ntV.nvB;
  }
  
  public com.tencent.mm.media.camera.d.c bob()
  {
    return this.ntV;
  }
  
  public final h boc()
  {
    return this.ntV.ntB.nvM;
  }
  
  public boolean bod()
  {
    return this.ntV.nvz.lSW;
  }
  
  public boolean boe()
  {
    return this.ntV.nvz.lSY;
  }
  
  protected final Context getContext()
  {
    Context localContext = this.context;
    if (localContext != null) {
      return localContext;
    }
    s.bIx("context");
    return null;
  }
  
  public Object s(kotlin.d.d<? super ah> paramd)
  {
    this.ntV.nvB = false;
    return ah.aiuX;
  }
  
  public final Object t(kotlin.d.d<? super ah> paramd)
  {
    d locald;
    if ((paramd instanceof d))
    {
      locald = (d)paramd;
      if ((locald.label & 0x80000000) != 0) {
        locald.label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (;;)
    {
      localObject2 = locald.result;
      locala = kotlin.d.a.a.aiwj;
      switch (locald.label)
      {
      default: 
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        locald = new d(this, paramd);
      }
    }
    ResultKt.throwOnFailure(localObject2);
    int k = boh();
    switch (((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getRotation())
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      Log.i("MicroMsg.Camera.BaseCameraInstance", s.X("displayRotation:", Integer.valueOf(i)));
      int m = (i - k + 360) % 360;
      j = (k - i + 360) % 360;
      Log.i("MicroMsg.Camera.BaseCameraInstance", "cameraRotate:" + k + " displayRotate:" + i + " render rotate:" + m + " mirror:" + needMirror() + " focusRotate:" + j);
      localObject1 = this.nux;
      i = j;
      paramd = this;
      if (localObject1 == null) {
        break;
      }
      locald.L$0 = this;
      locald.aai = j;
      locald.label = 1;
      i = j;
      paramd = this;
      if (((e)localObject1).a("updateInputRotate", (m)new e.q(m, (e)localObject1, null), locald) != locala) {
        break;
      }
      return locala;
      i = 0;
      continue;
      i = 90;
      continue;
      i = 180;
      continue;
      i = 270;
    }
    int i = locald.aai;
    paramd = (a)locald.L$0;
    ResultKt.throwOnFailure(localObject2);
    Object localObject2 = paramd.nux;
    int j = i;
    Object localObject1 = paramd;
    if (localObject2 != null)
    {
      boolean bool = paramd.needMirror();
      locald.L$0 = paramd;
      locald.aai = i;
      locald.label = 2;
      j = i;
      localObject1 = paramd;
      if (((e)localObject2).a("updateInputMirror", (m)new e.p(bool, (e)localObject2, null), locald) == locala)
      {
        return locala;
        j = locald.aai;
        localObject1 = (a)locald.L$0;
        ResultKt.throwOnFailure(localObject2);
      }
    }
    ((a)localObject1).tU(j);
    return ah.aiuX;
  }
  
  public void tU(int paramInt)
  {
    this.ntV.hYK = paramInt;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int aai;
    int asI;
    int label;
    int nuz;
    
    b(a parama, kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237325);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = a.a(this.nuA, 0, 0, 0, (kotlin.d.d)this);
      AppMethodBeat.o(237325);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, kotlin.d.d<? super Bitmap>, Object>
  {
    int label;
    
    c(a parama, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(237339);
      paramObject = (kotlin.d.d)new c(this.nuA, this.aMP, this.aMQ, this.ntQ, this.nuB, paramd);
      AppMethodBeat.o(237339);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237334);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237334);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = a.a(this.aMP, this.aMQ, this.ntQ, this.nuB);
      AppMethodBeat.o(237334);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int aai;
    int label;
    
    d(a parama, kotlin.d.d<? super d> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237320);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.nuA.t((kotlin.d.d)this);
      AppMethodBeat.o(237320);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.instance.a
 * JD-Core Version:    0.7.0.1
 */