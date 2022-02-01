package com.tencent.mm.media.widget.d;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/util/CameraCoordinateTransformer;", "", "()V", "CAMERA1_DRIVER_RECT", "Landroid/graphics/RectF;", "getCAMERA1_DRIVER_RECT", "()Landroid/graphics/RectF;", "cameraToPreviewTransform", "Landroid/graphics/Matrix;", "mirrorX", "", "displayOrientation", "", "cameraRect", "previewRect", "toCameraSpace", "source", "plugin-mediaeditor_release"})
public final class b
{
  private static final RectF lin;
  public static final b lio;
  
  static
  {
    AppMethodBeat.i(258145);
    lio = new b();
    lin = new RectF(-1000.0F, -1000.0F, 1000.0F, 1000.0F);
    AppMethodBeat.o(258145);
  }
  
  public static Matrix a(boolean paramBoolean, float paramFloat, RectF paramRectF1, RectF paramRectF2)
  {
    AppMethodBeat.i(258142);
    Matrix localMatrix1 = new Matrix();
    if (paramBoolean) {}
    for (float f = -1.0F;; f = 1.0F)
    {
      localMatrix1.setScale(f, 1.0F);
      localMatrix1.postRotate(-paramFloat);
      localMatrix1.mapRect(paramRectF2);
      Matrix localMatrix2 = new Matrix();
      localMatrix2.setRectToRect(paramRectF2, paramRectF1, Matrix.ScaleToFit.FILL);
      localMatrix1.setConcat(localMatrix2, localMatrix1);
      AppMethodBeat.o(258142);
      return localMatrix1;
    }
  }
  
  public static RectF bat()
  {
    return lin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.d.b
 * JD-Core Version:    0.7.0.1
 */