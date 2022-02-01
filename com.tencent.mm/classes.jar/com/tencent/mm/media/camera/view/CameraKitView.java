package com.tencent.mm.media.camera.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.camera.a.e;
import com.tencent.mm.media.camera.a.j;
import com.tencent.mm.media.camera.i;
import com.tencent.mm.media.camera.m.b;
import com.tencent.mm.media.camera.m.d;
import com.tencent.mm.media.camera.view.control.CameraFocusAndMeteringView;
import com.tencent.mm.media.camera.view.control.CameraFocusAndMeteringView.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.r;
import kotlinx.coroutines.b.af;
import kotlinx.coroutines.b.z;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/view/CameraKitView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/media/camera/view/control/CameraFocusAndMeteringView$TouchCallback;", "Lcom/tencent/mm/media/camera/view/ICameraAdvancedUsage;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cameraKit", "Lcom/tencent/mm/media/camera/CameraKit;", "getCameraKit", "()Lcom/tencent/mm/media/camera/CameraKit;", "cameraKit$delegate", "Lkotlin/Lazy;", "cameraKitSetting", "Lcom/tencent/mm/media/camera/model/CameraKitSetting;", "cameraView", "Lcom/tencent/mm/media/camera/view/ICameraKitView;", "ratio", "", "viewBinding", "Lcom/tencent/mm/media/camera/databinding/CameraKitLayoutBinding;", "bindLifeCycleOwner", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "getCameraState", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlin/Pair;", "Lcom/tencent/mm/media/camera/view/CameraStatusEnum;", "Landroid/os/Bundle;", "onDoubleClick", "onMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "onTouchDown", "x", "y", "onZoomIn", "onZoomOut", "setCameraKitSetting", "setting", "setCustomRender", "render", "Lcom/tencent/mm/media/camera/CustomRenderCallback;", "setCustomRenderTarget", "surface", "Landroid/view/Surface;", "width", "height", "(Landroid/view/Surface;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setScreenRenderTarget", "switchCamera", "switchToCamera", "back", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "takePicture", "Landroid/graphics/Bitmap;", "rotate", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CameraKitView
  extends RelativeLayout
  implements b, CameraFocusAndMeteringView.b
{
  public static final CameraKitView.a nwI;
  private final com.tencent.mm.media.camera.c.b nwJ;
  private final j nwK;
  private final c nwL;
  private com.tencent.mm.media.camera.d.f nwM;
  private float nwN;
  
  static
  {
    AppMethodBeat.i(237264);
    nwI = new CameraKitView.a((byte)0);
    AppMethodBeat.o(237264);
  }
  
  public CameraKitView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(237235);
    Object localObject = com.tencent.mm.media.camera.c.b.a(LayoutInflater.from(paramContext), (ViewGroup)this);
    s.s(localObject, "inflate(LayoutInflater.from(context), this)");
    this.nwJ = ((com.tencent.mm.media.camera.c.b)localObject);
    this.nwK = k.cm((kotlin.g.a.a)b.nwO);
    this.nwM = new com.tencent.mm.media.camera.d.f();
    localObject = paramContext.obtainStyledAttributes(paramAttributeSet, m.d.CameraKitView);
    s.s(localObject, "context.obtainStyledAttr….styleable.CameraKitView)");
    switch (((TypedArray)localObject).getInt(m.d.CameraKitView_cameraView, 0))
    {
    default: 
      paramAttributeSet = this.nwJ.nus.inflate();
    }
    while (paramAttributeSet == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.media.camera.view.ICameraKitView");
      AppMethodBeat.o(237235);
      throw paramContext;
      paramAttributeSet = this.nwJ.nut.inflate();
      continue;
      paramAttributeSet = this.nwJ.nus.inflate();
    }
    this.nwL = ((c)paramAttributeSet);
    boolean bool;
    if (((TypedArray)localObject).getInt(m.d.CameraKitView_cameraId, 0) == 0)
    {
      bool = true;
      int i = ((TypedArray)localObject).getInt(m.d.CameraKitView_ratioWidth, 0);
      int j = ((TypedArray)localObject).getInt(m.d.CameraKitView_ratioHeight, 0);
      if ((j > 0) && (i > 0)) {
        this.nwN = (j * 1.0F / i);
      }
      Log.i("MicroMsg.Camera.CameraKitView", "cameraView instance:" + this.nwL.getClass().getName() + " backCamera:" + bool + " ratio:" + this.nwN + " [w:" + i + " h:" + j + ']');
      this.nwL.setCameraKitEnv((i)getCameraKit());
      getCameraKit().z(paramContext, bool);
      this.nwJ.nuq.setTouchCallback((CameraFocusAndMeteringView.b)this);
      paramContext = com.tencent.mm.media.camera.a.a.ntR;
      paramContext = this.nwJ.nur;
      s.s(paramContext, "viewBinding.debugView");
      s.u(paramContext, "window");
      com.tencent.mm.media.camera.a.a.ntT = paramContext;
      paramAttributeSet = com.tencent.mm.media.camera.b.a.nul;
      bool = com.tencent.mm.media.camera.b.a.bnQ();
      com.tencent.mm.media.camera.a.a.ntW = bool;
      if (bool)
      {
        com.tencent.mm.media.camera.a.a.ntU = (TextView)paramContext.inflate().findViewById(m.b.debug_text);
        paramContext = com.tencent.mm.media.camera.b.a.nul;
        if (!com.tencent.mm.media.camera.b.a.bnR()) {
          break label504;
        }
        paramContext = "纹理预览";
        label439:
        com.tencent.mm.media.camera.a.a.ntY = paramContext;
        paramContext = com.tencent.mm.media.camera.b.a.nul;
        if (com.tencent.mm.media.camera.b.a.bnS() != 1) {
          break label511;
        }
        paramContext = "camera1";
        label458:
        com.tencent.mm.media.camera.a.a.nua = paramContext;
        paramContext = com.tencent.mm.media.camera.b.a.nul;
        if (com.tencent.mm.media.camera.b.a.bnS() == 1) {
          break label518;
        }
        paramContext = com.tencent.mm.media.camera.b.a.nul;
        if (com.tencent.mm.media.camera.b.a.bnT() != 2) {
          break label518;
        }
      }
    }
    label518:
    for (paramContext = "imageCapture";; paramContext = "readPixel")
    {
      com.tencent.mm.media.camera.a.a.ntZ = paramContext;
      AppMethodBeat.o(237235);
      return;
      bool = false;
      break;
      label504:
      paramContext = "buffer预览";
      break label439;
      label511:
      paramContext = "camerax";
      break label458;
    }
  }
  
  private final com.tencent.mm.media.camera.a getCameraKit()
  {
    AppMethodBeat.i(237252);
    com.tencent.mm.media.camera.a locala = (com.tencent.mm.media.camera.a)this.nwK.getValue();
    AppMethodBeat.o(237252);
    return locala;
  }
  
  public final Object a(int paramInt, kotlin.d.d<? super r<Integer, Bitmap>> paramd)
  {
    AppMethodBeat.i(237351);
    paramd = getCameraKit().a(0, 1920, paramInt, paramd);
    AppMethodBeat.o(237351);
    return paramd;
  }
  
  public final void al(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(237288);
    com.tencent.mm.media.camera.a locala = getCameraKit();
    locala.f((m)new a.e(paramFloat1, paramFloat2, locala, null));
    AppMethodBeat.o(237288);
  }
  
  public final void b(Surface paramSurface, Integer paramInteger1, Integer paramInteger2)
  {
    AppMethodBeat.i(237383);
    s.u(paramSurface, "surface");
    Log.i("MicroMsg.Camera.CameraKitView", "setCustomRenderTarget width:" + paramInteger1 + " height:" + paramInteger2);
    this.nwL.setCameraKitEnv(null);
    getCameraKit().bnK();
    getCameraKit().a(paramSurface, paramInteger1, paramInteger2);
    AppMethodBeat.o(237383);
  }
  
  public final void bof()
  {
    AppMethodBeat.i(237310);
    com.tencent.mm.media.camera.instance.c localc = getCameraKit().ntl;
    if (localc != null) {
      localc.bof();
    }
    AppMethodBeat.o(237310);
  }
  
  public final void bog()
  {
    AppMethodBeat.i(237317);
    com.tencent.mm.media.camera.instance.c localc = getCameraKit().ntl;
    if (localc != null) {
      localc.bog();
    }
    AppMethodBeat.o(237317);
  }
  
  public final void bow()
  {
    AppMethodBeat.i(237301);
    getCameraKit().switchCamera();
    AppMethodBeat.o(237301);
  }
  
  public final void box()
  {
    AppMethodBeat.i(237394);
    getCameraKit().bnK();
    this.nwL.setCameraKitEnv((i)getCameraKit());
    AppMethodBeat.o(237394);
  }
  
  public final Object c(boolean paramBoolean, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(237333);
    Object localObject = getCameraKit();
    localObject = l.a((kotlin.d.f)kotlinx.coroutines.android.c.f(((com.tencent.mm.media.camera.a)localObject).ntj), (m)new a.j(paramBoolean, (com.tencent.mm.media.camera.a)localObject, null), paramd);
    paramd = (kotlin.d.d<? super ah>)localObject;
    if (localObject != kotlin.d.a.a.aiwj) {
      paramd = ah.aiuX;
    }
    if (paramd == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(237333);
      return paramd;
    }
    paramd = ah.aiuX;
    AppMethodBeat.o(237333);
    return paramd;
  }
  
  public final af<r<a, Bundle>> getCameraState()
  {
    AppMethodBeat.i(237340);
    af localaf = (af)new z((af)getCameraKit().ntn);
    AppMethodBeat.o(237340);
    return localaf;
  }
  
  public final void n(q paramq)
  {
    AppMethodBeat.i(237373);
    s.u(paramq, "owner");
    getCameraKit().m(paramq);
    AppMethodBeat.o(237373);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237273);
    if (this.nwN > 0.0F)
    {
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      if ((paramInt2 > 0) && (paramInt1 > 0))
      {
        int i;
        if (paramInt2 * 1.0F / paramInt1 > this.nwN)
        {
          i = (int)(paramInt1 * this.nwN);
          paramInt2 = paramInt1;
          paramInt1 = i;
        }
        for (;;)
        {
          super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
          AppMethodBeat.o(237273);
          return;
          i = (int)(paramInt2 / this.nwN);
          paramInt1 = paramInt2;
          paramInt2 = i;
        }
      }
    }
    else
    {
      super.onMeasure(paramInt1, paramInt2);
    }
    AppMethodBeat.o(237273);
  }
  
  public final void setCameraKitSetting(com.tencent.mm.media.camera.d.f paramf)
  {
    AppMethodBeat.i(237364);
    s.u(paramf, "setting");
    Log.i("MicroMsg.Camera.CameraKitView", s.X("setCameraKitSetting:", paramf));
    this.nwM = paramf;
    this.nwJ.nuq.setCameraUISetting(paramf.nvH);
    getCameraKit().bnJ();
    AppMethodBeat.o(237364);
  }
  
  public final void setCustomRender(com.tencent.mm.media.camera.d paramd)
  {
    AppMethodBeat.i(237368);
    getCameraKit().setCustomRender(paramd);
    AppMethodBeat.o(237368);
  }
  
  public final void switchCamera()
  {
    AppMethodBeat.i(369566);
    getCameraKit().switchCamera();
    AppMethodBeat.o(369566);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/media/camera/CameraKit;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<com.tencent.mm.media.camera.a>
  {
    public static final b nwO;
    
    static
    {
      AppMethodBeat.i(237215);
      nwO = new b();
      AppMethodBeat.o(237215);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.view.CameraKitView
 * JD-Core Version:    0.7.0.1
 */