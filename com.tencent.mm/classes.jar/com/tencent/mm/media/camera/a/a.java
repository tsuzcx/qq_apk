package com.tencent.mm.media.camera.a;

import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.camera.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.d.d<-TT;>;
import kotlin.g.a.b<-Lkotlin.d.d<-TT;>;+Ljava.lang.Object;>;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/analyse/CameraAnalyse;", "", "()V", "analyse", "Lcom/tencent/mm/media/camera/analyse/CameraRenderAnalyse;", "cameraKitInfo", "Lcom/tencent/mm/media/camera/model/CameraKitInfo;", "debugText", "Landroid/widget/TextView;", "debugWindow", "Landroid/view/ViewStub;", "enableDebug", "", "firstFrameTimeCostMs", "", "instanceName", "", "interval", "", "lastUpdateTimeStamp", "previewType", "startCameraCostMs", "startCameraFinishTimeStamp", "takePictureType", "cameraStartAnalyse", "T", "runnable", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "frameUpdate", "", "getInstanceName", "getPictureName", "getPreviewName", "init", "window", "markStart", "release", "setCameraKitInfo", "info", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a ntR;
  private static long ntS;
  public static ViewStub ntT;
  public static TextView ntU;
  private static c ntV;
  public static boolean ntW;
  private static final b ntX;
  public static String ntY;
  public static String ntZ;
  public static String nua;
  private static long nub;
  private static long nuc;
  private static long nud;
  
  static
  {
    AppMethodBeat.i(237343);
    ntR = new a();
    ntS = System.currentTimeMillis();
    ntX = new b();
    ntY = "";
    ntZ = "";
    nua = "";
    nub = -1L;
    nuc = -1L;
    nud = -1L;
    AppMethodBeat.o(237343);
  }
  
  private static final void GL(String paramString)
  {
    AppMethodBeat.i(237336);
    s.u(paramString, "$fixedInfo");
    TextView localTextView = ntU;
    if (localTextView != null)
    {
      paramString = new StringBuilder().append(paramString).append('\n');
      b localb = ntX;
      localTextView.setText((CharSequence)new StringBuilder("平均帧率:").append(localb.nuh.nuk).append("\n实时帧率:").append(localb.nui).toString());
    }
    AppMethodBeat.o(237336);
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(237329);
    s.u(paramc, "info");
    ntV = paramc;
    AppMethodBeat.o(237329);
  }
  
  public static void bnP()
  {
    Object localObject2 = null;
    AppMethodBeat.i(237324);
    if (!ntW)
    {
      AppMethodBeat.o(237324);
      return;
    }
    if (nud <= 0L) {
      nud = System.currentTimeMillis() - nuc;
    }
    Object localObject1 = ntX;
    long l = System.currentTimeMillis() - ((b)localObject1).nug;
    ((b)localObject1).nug = System.currentTimeMillis();
    if (l > 0L) {
      ((b)localObject1).nui = (1000L / l);
    }
    localObject1 = ((b)localObject1).nuh;
    ((b.a)localObject1).count += 1L;
    if (System.currentTimeMillis() - ((b.a)localObject1).startTime > ((b.a)localObject1).interval)
    {
      ((b.a)localObject1).startTime = System.currentTimeMillis();
      ((b.a)localObject1).nuk = (((b.a)localObject1).count * 1000L / ((b.a)localObject1).interval);
      Log.v("MicroMsg.Camera.CameraRenderAnalyse", ((b.a)localObject1).tag + " average frame:" + ((b.a)localObject1).nuk);
      ((b.a)localObject1).startTime = System.currentTimeMillis();
      ((b.a)localObject1).count = 0L;
    }
    StringBuilder localStringBuilder;
    if (System.currentTimeMillis() - ntS > 100L)
    {
      ntS = System.currentTimeMillis();
      localStringBuilder = new StringBuilder("实例:").append(nua).append("\n耗时:打开").append(nub).append("ms 首帧:").append(nud).append("ms\n预览方式:").append(ntY).append("\n拍照方式:").append(ntZ).append("\n分辨率:");
      localObject1 = ntV;
      if (localObject1 != null) {
        break label394;
      }
      localObject1 = null;
      localStringBuilder = localStringBuilder.append(localObject1).append("\n纹理裁剪:");
      localObject1 = ntV;
      if (localObject1 != null) {
        break label416;
      }
      localObject1 = null;
      label292:
      localStringBuilder = localStringBuilder.append(localObject1).append("\nView尺寸:");
      localObject1 = ntV;
      if (localObject1 != null) {
        break label438;
      }
      localObject1 = null;
      label315:
      localStringBuilder = localStringBuilder.append(localObject1).append("\n顺时针旋转:");
      localObject1 = ntV;
      if (localObject1 != null) {
        break label460;
      }
      localObject1 = null;
      label338:
      localStringBuilder = localStringBuilder.append(localObject1).append("°\n设置帧率:");
      localObject1 = ntV;
      if (localObject1 != null) {
        break label471;
      }
    }
    label394:
    label416:
    label438:
    label460:
    label471:
    for (localObject1 = localObject2;; localObject1 = Integer.valueOf(((c)localObject1).frameRate))
    {
      localObject1 = localObject1;
      h.ahAA.bk(new a..ExternalSyntheticLambda0((String)localObject1));
      AppMethodBeat.o(237324);
      return;
      localObject1 = ((c)localObject1).ntB;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((com.tencent.mm.media.camera.d.i)localObject1).nvM;
      break;
      localObject1 = ((c)localObject1).ntB;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label292;
      }
      localObject1 = ((com.tencent.mm.media.camera.d.i)localObject1).nvN;
      break label292;
      localObject1 = ((c)localObject1).ntB;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label315;
      }
      localObject1 = ((com.tencent.mm.media.camera.d.i)localObject1).nvL;
      break label315;
      localObject1 = Integer.valueOf(((c)localObject1).hYK);
      break label338;
    }
  }
  
  public static void release()
  {
    ntT = null;
    ntW = false;
  }
  
  public final <T> Object c(kotlin.g.a.b<? super kotlin.d.d<? super T>, ? extends Object> paramb, kotlin.d.d<? super T> paramd)
  {
    AppMethodBeat.i(237355);
    Object localObject;
    if ((paramd instanceof a))
    {
      localObject = (a)paramd;
      if ((((a)localObject).label & 0x80000000) != 0) {
        ((a)localObject).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super T>)localObject;; paramd = new a(this, paramd))
    {
      localObject = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramb = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237355);
        throw paramb;
      }
    }
    ResultKt.throwOnFailure(localObject);
    long l = System.currentTimeMillis();
    paramd.L$0 = this;
    paramd.Yx = l;
    paramd.label = 1;
    paramd = paramb.invoke(paramd);
    paramb = paramd;
    if (paramd == locala)
    {
      AppMethodBeat.o(237355);
      return locala;
      l = paramd.Yx;
      ResultKt.throwOnFailure(localObject);
      paramb = (kotlin.g.a.b<? super kotlin.d.d<? super T>, ? extends Object>)localObject;
    }
    nub = System.currentTimeMillis() - l;
    nuc = System.currentTimeMillis();
    nud = -1L;
    AppMethodBeat.o(237355);
    return paramb;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a<T>
    extends kotlin.d.b.a.d
  {
    Object L$0;
    long Yx;
    int label;
    
    a(a parama, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237281);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.nue.c(null, (kotlin.d.d)this);
      AppMethodBeat.o(237281);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.media.camera.a.a
 * JD-Core Version:    0.7.0.1
 */