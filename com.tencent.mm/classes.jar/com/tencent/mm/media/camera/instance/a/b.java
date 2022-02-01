package com.tencent.mm.media.camera.instance.a;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.camera.core.ao;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/instance/camerax/SurfaceCropMeteringPointFactory;", "Landroidx/camera/core/MeteringPointFactory;", "()V", "focusHelper", "Lcom/tencent/mm/media/camera/instance/CameraKitFocusHelper;", "transform", "Landroid/graphics/Matrix;", "convertPoint", "Landroid/graphics/PointF;", "x", "", "y", "updateTransformer", "", "mirrorX", "", "rotate", "", "textureWidth", "textureHeight", "viewWidth", "viewHeight", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends ao
{
  final com.tencent.mm.media.camera.instance.b nvr;
  final Matrix transform;
  
  public b()
  {
    AppMethodBeat.i(237349);
    this.nvr = new com.tencent.mm.media.camera.instance.b();
    this.transform = new Matrix();
    AppMethodBeat.o(237349);
  }
  
  public final PointF n(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(237356);
    paramFloat1 /= this.nvr.nuD.width();
    paramFloat2 /= this.nvr.nuD.height();
    Object localObject = new float[2];
    this.transform.mapPoints((float[])localObject, new float[] { paramFloat1, paramFloat2 });
    Log.i("MicroMsg.Camera.CameraKitFocusHelper", "convertPoint origin:[" + paramFloat1 + ' ' + paramFloat2 + "] dest:[" + localObject[0] + ' ' + localObject[1] + ']');
    localObject = new PointF(localObject[0], localObject[1]);
    AppMethodBeat.o(237356);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.instance.a.b
 * JD-Core Version:    0.7.0.1
 */