package com.tencent.mm.media.camera.view.control;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.media.camera.d.g;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/view/control/CameraFocusAndMeteringView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cameraKitUiSetting", "Lcom/tencent/mm/media/camera/model/CameraKitUiSetting;", "focusView", "Lcom/tencent/mm/media/camera/view/control/CameraFocusView;", "gestureDetector", "Landroid/view/GestureDetector;", "lastDoubleClickTime", "", "lastPointerDistance", "", "pointerCount", "", "simpleGestureListener", "com/tencent/mm/media/camera/view/control/CameraFocusAndMeteringView$simpleGestureListener$1", "Lcom/tencent/mm/media/camera/view/control/CameraFocusAndMeteringView$simpleGestureListener$1;", "touchCallback", "Lcom/tencent/mm/media/camera/view/control/CameraFocusAndMeteringView$TouchCallback;", "initFocusView", "", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "pointerDistance", "setCameraUISetting", "setting", "setTouchCallback", "callback", "Companion", "TouchCallback", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CameraFocusAndMeteringView
  extends RelativeLayout
{
  public static final CameraFocusAndMeteringView.a nwS;
  private b nwT;
  private long nwU;
  private float nwV;
  private final CameraFocusView nwW;
  private g nwX;
  private final c nwY;
  private final GestureDetector nwZ;
  private int pointerCount;
  
  static
  {
    AppMethodBeat.i(237291);
    nwS = new CameraFocusAndMeteringView.a((byte)0);
    AppMethodBeat.o(237291);
  }
  
  public CameraFocusAndMeteringView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(237242);
    this.nwV = -1.0F;
    this.nwW = new CameraFocusView(paramContext);
    this.nwY = new c(this);
    this.nwZ = new GestureDetector(getContext(), (GestureDetector.OnGestureListener)this.nwY);
    this.nwZ.setIsLongpressEnabled(false);
    addView((View)this.nwW);
    int i = com.tencent.mm.cd.a.fromDPToPix(getContext(), 120);
    paramContext = this.nwW;
    paramContext.nxi = paramContext.getLayoutParams();
    if (paramContext.nxi != null)
    {
      paramContext.nxi.width = i;
      paramContext.nxi.height = i;
    }
    paramContext.mWidth = i;
    paramContext.mHeight = i;
    paramContext.nxg = (paramContext.mWidth / 2);
    paramContext.nxh = (paramContext.mHeight / 2);
    paramContext.mStrokeWidth = com.tencent.mm.cd.a.fromDPToPix(paramContext.getContext(), 1);
    paramContext.mPaint.setColor(-12206054);
    paramContext.mPaint.setStrokeWidth(paramContext.mStrokeWidth);
    paramContext.setLayerType(1, null);
    AppMethodBeat.o(237242);
  }
  
  private final float x(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(237255);
    try
    {
      if (this.pointerCount >= 2)
      {
        float f3 = paramMotionEvent.getX(0);
        float f1 = paramMotionEvent.getY(0);
        float f4 = paramMotionEvent.getX(1);
        float f2 = paramMotionEvent.getY(1);
        f3 = Math.abs(f3 - f4);
        f1 = Math.abs(f1 - f2);
        AppMethodBeat.o(237255);
        return f3 + f1;
      }
    }
    catch (Exception paramMotionEvent)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.Camera.CameraFocusAndMeteringView", "pointerDistance error: %s", new Object[] { paramMotionEvent.getMessage() });
      AppMethodBeat.o(237255);
    }
    return 0.0F;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(237312);
    s.u(paramMotionEvent, "event");
    GestureDetector localGestureDetector = this.nwZ;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala.aYi(), "com/tencent/mm/media/camera/view/control/CameraFocusAndMeteringView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/media/camera/view/control/CameraFocusAndMeteringView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    float f;
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            AppMethodBeat.o(237312);
            return true;
            com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.Camera.CameraFocusAndMeteringView", "ACTION_DOWN");
            this.nwV = -1.0F;
            this.pointerCount += 1;
            continue;
            com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.Camera.CameraFocusAndMeteringView", "ACTION_POINTER_DOWN");
            this.pointerCount += 1;
            continue;
            com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.Camera.CameraFocusAndMeteringView", "ACTION_POINTER_UP");
            this.pointerCount -= 1;
            continue;
            com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.Camera.CameraFocusAndMeteringView", "ACTION_UP");
            this.nwV = -1.0F;
            this.pointerCount = 0;
          }
        } while (this.pointerCount < 2);
        f = x(paramMotionEvent);
        com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.Camera.CameraFocusAndMeteringView", "distance: %s", new Object[] { Float.valueOf(f) });
      } while (f <= 0.0F);
      if (this.nwV <= 0.0F) {
        break;
      }
    } while (Math.abs(f - this.nwV) <= 15.0F);
    if (f > this.nwV)
    {
      com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.Camera.CameraFocusAndMeteringView", "zoom out");
      paramMotionEvent = this.nwT;
      if (paramMotionEvent != null) {
        paramMotionEvent.bof();
      }
    }
    for (;;)
    {
      this.nwV = f;
      break;
      com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.Camera.CameraFocusAndMeteringView", "zoom in");
      paramMotionEvent = this.nwT;
      if (paramMotionEvent != null) {
        paramMotionEvent.bog();
      }
    }
  }
  
  public final void setCameraUISetting(g paramg)
  {
    AppMethodBeat.i(237300);
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.Camera.CameraFocusAndMeteringView", s.X("setCameraUISetting:", paramg));
    if (paramg != null)
    {
      this.nwW.setFocusColor(paramg.nvJ);
      this.nwX = paramg;
    }
    AppMethodBeat.o(237300);
  }
  
  public final void setTouchCallback(b paramb)
  {
    this.nwT = paramb;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/view/control/CameraFocusAndMeteringView$TouchCallback;", "", "onDoubleClick", "", "onTouchDown", "x", "", "y", "onZoomIn", "onZoomOut", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void al(float paramFloat1, float paramFloat2);
    
    public abstract void bof();
    
    public abstract void bog();
    
    public abstract void bow();
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/media/camera/view/control/CameraFocusAndMeteringView$simpleGestureListener$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onDoubleTap", "", "e", "Landroid/view/MotionEvent;", "onSingleTapConfirmed", "onSingleTapUp", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends GestureDetector.SimpleOnGestureListener
  {
    c(CameraFocusAndMeteringView paramCameraFocusAndMeteringView) {}
    
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(237263);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/media/camera/view/control/CameraFocusAndMeteringView$simpleGestureListener$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/media/camera/view/control/CameraFocusAndMeteringView$simpleGestureListener$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(237263);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(237234);
      Object localObject = new b();
      ((b)localObject).cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/media/camera/view/control/CameraFocusAndMeteringView$simpleGestureListener$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, ((b)localObject).aYj());
      s.u(paramMotionEvent, "e");
      localObject = new StringBuilder("onDoubleTap enable:[");
      paramMotionEvent = CameraFocusAndMeteringView.c(this.nxa);
      if (paramMotionEvent == null)
      {
        paramMotionEvent = null;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.Camera.CameraFocusAndMeteringView", paramMotionEvent + ']');
        if (System.currentTimeMillis() - CameraFocusAndMeteringView.d(this.nxa) > 1000L)
        {
          paramMotionEvent = CameraFocusAndMeteringView.c(this.nxa);
          if ((paramMotionEvent == null) || (paramMotionEvent.nvK)) {
            break label184;
          }
        }
      }
      label184:
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          paramMotionEvent = CameraFocusAndMeteringView.b(this.nxa);
          if (paramMotionEvent != null) {
            paramMotionEvent.bow();
          }
          CameraFocusAndMeteringView.a(this.nxa, System.currentTimeMillis());
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/media/camera/view/control/CameraFocusAndMeteringView$simpleGestureListener$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(237234);
        return false;
        paramMotionEvent = Boolean.valueOf(paramMotionEvent.nvK);
        break;
      }
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(237253);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/media/camera/view/control/CameraFocusAndMeteringView$simpleGestureListener$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
      super.onLongPress(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/media/camera/view/control/CameraFocusAndMeteringView$simpleGestureListener$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(237253);
    }
    
    public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(237243);
      s.u(paramMotionEvent, "e");
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.Camera.CameraFocusAndMeteringView", "onSingleTapConfirmed");
      AppMethodBeat.o(237243);
      return true;
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(237225);
      Object localObject1 = new b();
      ((b)localObject1).cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/media/camera/view/control/CameraFocusAndMeteringView$simpleGestureListener$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, ((b)localObject1).aYj());
      s.u(paramMotionEvent, "e");
      com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.Camera.CameraFocusAndMeteringView", "onSingleTapUp");
      localObject1 = CameraFocusAndMeteringView.a(this.nxa);
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      Object localObject2 = ((CameraFocusView)localObject1).getLayoutParams();
      if (!(localObject2 instanceof ViewGroup.MarginLayoutParams)) {
        org.xwalk.core.Log.e("MicroMsg.CameraFrontSightView", "LayoutParams is not MarginLayoutParams! use doAimation()");
      }
      for (;;)
      {
        localObject1 = CameraFocusAndMeteringView.b(this.nxa);
        if (localObject1 != null) {
          ((CameraFocusAndMeteringView.b)localObject1).al(paramMotionEvent.getX(), paramMotionEvent.getY());
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/media/camera/view/control/CameraFocusAndMeteringView$simpleGestureListener$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(237225);
        return false;
        localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
        ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = ((int)f1 - ((CameraFocusView)localObject1).mWidth / 2);
        ((ViewGroup.MarginLayoutParams)localObject2).topMargin = ((int)f2 - ((CameraFocusView)localObject1).mHeight / 2);
        ((CameraFocusView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((CameraFocusView)localObject1).setVisibility(0);
        ((CameraFocusView)localObject1).nxb = true;
        ((CameraFocusView)localObject1).nxc = false;
        ((CameraFocusView)localObject1).nxd = false;
        ((CameraFocusView)localObject1).nxe = false;
        ((CameraFocusView)localObject1).nxf = System.currentTimeMillis();
        ((CameraFocusView)localObject1).invalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.view.control.CameraFocusAndMeteringView
 * JD-Core Version:    0.7.0.1
 */