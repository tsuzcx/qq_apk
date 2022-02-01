package com.tencent.mm.media.widget.b;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraCharacteristics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/widget/camera2/CameraFocusCoordinateTrans;", "", "mCameraCharacteristics", "Landroid/hardware/camera2/CameraCharacteristics;", "previewRect", "Landroid/graphics/Rect;", "(Landroid/hardware/camera2/CameraCharacteristics;Landroid/graphics/Rect;)V", "TAG", "", "mDriverRectF", "Landroid/graphics/RectF;", "mPreviewToCameraTransform", "Landroid/graphics/Matrix;", "previewToCameraTransform", "mirrorX", "", "sensorOrientation", "", "rectToRectF", "rect", "toCameraSpace", "source", "toFocusRect", "rectF", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private final String TAG;
  private RectF nGY;
  Matrix nuG;
  
  public b(CameraCharacteristics paramCameraCharacteristics, Rect paramRect)
  {
    AppMethodBeat.i(237522);
    this.TAG = "MicroMsg.CameraFocusCoordinateTrans";
    s.u(paramRect, "rect");
    RectF localRectF = new RectF(paramRect);
    int i;
    label74:
    Integer localInteger;
    label139:
    int j;
    if (localRectF.width() == 0.0F)
    {
      i = 1;
      if (i == 0)
      {
        if (localRectF.height() != 0.0F) {
          break label260;
        }
        i = 1;
        if (i == 0) {}
      }
      else
      {
        Log.e(this.TAG, "IllegalArgumentException(" + paramRect + ')');
      }
      paramRect = (Rect)paramCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
      localInteger = (Integer)paramCameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
      if (localInteger != null) {
        break label266;
      }
      i = 90;
      this.nGY = new RectF(paramRect);
      paramCameraCharacteristics = (Integer)paramCameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
      if ((paramCameraCharacteristics == null) || (paramCameraCharacteristics.intValue() != 0)) {
        break label276;
      }
      j = 1;
      label176:
      paramCameraCharacteristics = new Matrix();
      if (j == 0) {
        break label282;
      }
    }
    label260:
    label266:
    label276:
    label282:
    for (float f = -1.0F;; f = 1.0F)
    {
      paramCameraCharacteristics.setScale(f, 1.0F);
      paramCameraCharacteristics.postRotate(-i);
      paramCameraCharacteristics.mapRect(localRectF);
      paramRect = new Matrix();
      paramRect.setRectToRect(localRectF, this.nGY, Matrix.ScaleToFit.FILL);
      paramCameraCharacteristics.setConcat(paramRect, paramCameraCharacteristics);
      this.nuG = paramCameraCharacteristics;
      AppMethodBeat.o(237522);
      return;
      i = 0;
      break;
      i = 0;
      break label74;
      i = localInteger.intValue();
      break label139;
      j = 0;
      break label176;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.b
 * JD-Core Version:    0.7.0.1
 */