package com.tencent.mm.media.camera.instance.camera1;

import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.w;
import com.tencent.mm.media.widget.camerarecordview.d.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/instance/camera1/Camera1FocusHelper;", "Lcom/tencent/mm/media/camera/instance/CameraKitFocusHelper;", "()V", "cameraRes", "Lcom/tencent/mm/compatible/deviceinfo/CameraUtil$IImpl$OpenCameraRes;", "currentFocusMode", "", "sAutoFocusCallback", "Landroid/hardware/Camera$AutoFocusCallback;", "transformer", "Lcom/tencent/mm/media/camera/instance/camera1/Camera1CoordinateTransformer;", "bindCameraRes", "", "res", "cacheFocusMode", "calculateTapArea", "Landroid/graphics/Rect;", "x", "", "y", "coefficient", "viewWidth", "", "viewHeight", "focusOn", "touchX", "touchY", "restoreFocusMode", "updateTransformer", "mirrorX", "", "rotate", "textureWidth", "textureHeight", "Companion", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.media.camera.instance.b
{
  public static final b.a nuI;
  d.a.a nuJ;
  private String nuK;
  private a nuL;
  private final Camera.AutoFocusCallback nuM;
  
  static
  {
    AppMethodBeat.i(237446);
    nuI = new b.a((byte)0);
    AppMethodBeat.o(237446);
  }
  
  public b()
  {
    AppMethodBeat.i(237421);
    b.b localb = com.tencent.mm.media.widget.camerarecordview.d.b.nKO;
    this.nuK = b.b.but();
    this.nuM = new b..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(237421);
  }
  
  private final Rect a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237430);
    paramFloat3 = 80.0F * paramFloat3;
    RectF localRectF = new RectF();
    float f = Math.max(paramFloat1 - paramFloat3, 0.0F);
    paramFloat1 = Math.min(paramFloat1 + paramFloat3, paramInt1);
    localRectF.set(f, Math.max(paramFloat2 - paramFloat3, 0.0F), paramFloat1, Math.min(paramFloat3 + paramFloat2, paramInt2));
    Object localObject = this.nuL;
    if (localObject == null) {}
    for (localRectF = null;; localRectF = ((a)localObject).e(localRectF))
    {
      localObject = new Rect();
      if (localRectF != null) {
        localRectF.round((Rect)localObject);
      }
      AppMethodBeat.o(237430);
      return localObject;
    }
  }
  
  private static final void a(b paramb, boolean paramBoolean, Camera paramCamera)
  {
    int i = 1;
    Object localObject = null;
    AppMethodBeat.i(237438);
    s.u(paramb, "this$0");
    Log.v("MicroMsg.Camera.Camera1FocusHelper", s.X("auto focus callback success ", Boolean.valueOf(paramBoolean)));
    for (;;)
    {
      try
      {
        paramCamera = paramb.nuJ;
        if (paramCamera != null)
        {
          paramCamera = paramCamera.lTN;
          if ((paramCamera != null) && (paramCamera.lWt == true))
          {
            if (i != 0) {
              continue;
            }
            paramCamera = paramb.nuJ;
            if (paramCamera != null) {
              continue;
            }
            paramCamera = null;
            break label184;
            if ((str == null) || (paramb.nuK == null)) {
              continue;
            }
            paramCamera.setFocusMode(paramb.nuK);
            paramb.nuK = null;
            paramb = paramb.nuJ;
            if (paramb != null) {
              continue;
            }
            paramb = localObject;
            if (paramb == null) {
              continue;
            }
            paramb.c(paramCamera);
            AppMethodBeat.o(237438);
            return;
          }
        }
        i = 0;
        continue;
        paramCamera = paramCamera.lTN;
        if (paramCamera == null)
        {
          paramCamera = null;
        }
        else
        {
          paramCamera = paramCamera.aPy();
          break label184;
          str = paramCamera.getFocusMode();
          continue;
          paramb = paramb.lTN;
          continue;
        }
        if (paramCamera != null) {
          continue;
        }
      }
      catch (Exception paramb)
      {
        Log.e("MicroMsg.Camera.Camera1FocusHelper", "auto focus return while camera is release");
        AppMethodBeat.o(237438);
        return;
      }
      label184:
      String str = null;
    }
  }
  
  public final void ak(float paramFloat1, float paramFloat2)
  {
    Object localObject3 = null;
    AppMethodBeat.i(237464);
    if ((getViewHeight() <= 0) || (getViewWidth() <= 0))
    {
      Log.i("MicroMsg.Camera.Camera1FocusHelper", "ignore focus,for width:" + getViewWidth() + " height:" + getViewHeight());
      AppMethodBeat.o(237464);
      return;
    }
    Object localObject1 = this.nuJ;
    Rect localRect2;
    Rect localRect1;
    if (localObject1 == null)
    {
      localObject1 = null;
      this.nuK = ((String)localObject1);
      localRect2 = a(paramFloat1, paramFloat2, 1.25F, getViewWidth(), getViewHeight());
      localRect1 = a(paramFloat1, paramFloat2, 1.0F, getViewWidth(), getViewHeight());
    }
    for (;;)
    {
      int i;
      try
      {
        Log.i("MicroMsg.Camera.Camera1FocusHelper", "focus on point:[" + paramFloat1 + ' ' + paramFloat2 + "] focusRect:" + localRect2 + " meteringRect:" + localRect1);
        localObject1 = this.nuJ;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label515;
          if ((localObject2 == null) || (!((List)localObject2).contains("auto"))) {
            break label526;
          }
          ((Camera.Parameters)localObject1).setFocusMode("auto");
          break label526;
          if (i <= 0) {
            break label536;
          }
          localObject2 = new ArrayList(1);
          ((ArrayList)localObject2).add(new Camera.Area(localRect2, 1000));
          if (localObject1 == null) {
            break label536;
          }
          ((Camera.Parameters)localObject1).setFocusAreas((List)localObject2);
          break label536;
          if (i > 0)
          {
            localObject2 = new ArrayList(1);
            ((ArrayList)localObject2).add(new Camera.Area(localRect1, 1000));
            if (localObject1 != null) {
              ((Camera.Parameters)localObject1).setMeteringAreas((List)localObject2);
            }
          }
          localObject2 = this.nuJ;
          if (localObject2 != null) {
            continue;
          }
          localObject2 = localObject3;
          if (localObject2 != null) {
            ((w)localObject2).c((Camera.Parameters)localObject1);
          }
          localObject1 = this.nuJ;
          if (localObject1 == null) {
            continue;
          }
          localObject1 = ((d.a.a)localObject1).lTN;
          if (localObject1 == null) {
            continue;
          }
          ((w)localObject1).a(this.nuM);
          AppMethodBeat.o(237464);
          return;
          localObject1 = ((d.a.a)localObject1).lTN;
          if (localObject1 == null)
          {
            localObject1 = null;
            break;
          }
          localObject1 = ((w)localObject1).aPy();
          if (localObject1 == null)
          {
            localObject1 = null;
            break;
          }
          localObject1 = ((Camera.Parameters)localObject1).getFocusMode();
          break;
        }
        localObject1 = ((d.a.a)localObject1).lTN;
        if (localObject1 == null)
        {
          localObject1 = null;
        }
        else
        {
          localObject1 = ((w)localObject1).aPy();
          break label515;
          localObject2 = ((Camera.Parameters)localObject1).getSupportedFocusModes();
          continue;
          i = ((Camera.Parameters)localObject1).getMaxNumFocusAreas();
          continue;
          i = ((Camera.Parameters)localObject1).getMaxNumMeteringAreas();
          continue;
          localObject2 = ((d.a.a)localObject2).lTN;
          continue;
        }
        if (localException != null) {
          continue;
        }
      }
      catch (Exception localException)
      {
        Log.w("MicroMsg.Camera.Camera1FocusHelper", "autofocus with area fail, exception %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(237464);
        return;
      }
      label515:
      Object localObject2 = null;
      continue;
      label526:
      if (localException == null)
      {
        i = 0;
        continue;
        label536:
        if (localException == null) {
          i = 0;
        }
      }
    }
  }
  
  public final void b(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(237456);
    super.b(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    this.nuL = new a(paramBoolean, paramInt1, this.nuD);
    AppMethodBeat.o(237456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.instance.camera1.b
 * JD-Core Version:    0.7.0.1
 */