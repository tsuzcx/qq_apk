package com.tencent.mm.media.widget.b;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraCharacteristics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/widget/camera2/CameraFocusCoordinateTrans;", "", "mCameraCharacteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "previewRect", "Landroid/graphics/Rect;", "(Landroid/hardware/camera2/CameraCharacteristics;Landroid/graphics/Rect;)V", "TAG", "", "mDriverRectF", "Landroid/graphics/RectF;", "mPreviewToCameraTransform", "Landroid/graphics/Matrix;", "previewToCameraTransform", "mirrorX", "", "sensorOrientation", "", "rectToRectF", "rect", "toCameraSpace", "source", "toFocusRect", "rectF", "plugin-mediaeditor_release"})
public final class b
{
  private final String TAG;
  Matrix lcd;
  private RectF lce;
  
  public b(CameraCharacteristics paramCameraCharacteristics, Rect paramRect)
  {
    AppMethodBeat.i(259770);
    this.TAG = "MicroMsg.CameraFocusCoordinateTrans";
    p.k(paramRect, "rect");
    RectF localRectF = new RectF(paramRect);
    if ((localRectF.width() == 0.0F) || (localRectF.height() == 0.0F)) {
      Log.e(this.TAG, "IllegalArgumentException(" + paramRect + ')');
    }
    paramRect = (Rect)paramCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
    Integer localInteger = (Integer)paramCameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
    int i;
    int j;
    if (localInteger != null)
    {
      i = localInteger.intValue();
      this.lce = new RectF(paramRect);
      paramCameraCharacteristics = (Integer)paramCameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
      if ((paramCameraCharacteristics == null) || (paramCameraCharacteristics.intValue() != 0)) {
        break label248;
      }
      j = 1;
      label163:
      paramCameraCharacteristics = new Matrix();
      if (j == 0) {
        break label254;
      }
    }
    label248:
    label254:
    for (float f = -1.0F;; f = 1.0F)
    {
      paramCameraCharacteristics.setScale(f, 1.0F);
      paramCameraCharacteristics.postRotate(-i);
      paramCameraCharacteristics.mapRect(localRectF);
      paramRect = new Matrix();
      paramRect.setRectToRect(localRectF, this.lce, Matrix.ScaleToFit.FILL);
      paramCameraCharacteristics.setConcat(paramRect, paramCameraCharacteristics);
      this.lcd = paramCameraCharacteristics;
      AppMethodBeat.o(259770);
      return;
      i = 90;
      break;
      j = 0;
      break label163;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.b
 * JD-Core Version:    0.7.0.1
 */