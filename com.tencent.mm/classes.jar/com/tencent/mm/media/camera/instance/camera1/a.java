package com.tencent.mm.media.camera.instance.camera1;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/instance/camera1/Camera1CoordinateTransformer;", "", "mirrorX", "", "displayOrientation", "", "previewRect", "Landroid/graphics/RectF;", "(ZILandroid/graphics/RectF;)V", "mCameraToPreviewTransform", "Landroid/graphics/Matrix;", "mPreviewToCameraTransform", "cameraToPreviewTransform", "hasNonZeroArea", "rect", "inverse", "source", "toCameraSpace", "toPreviewSpace", "Companion", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a nuE;
  private static final RectF nuH;
  private final Matrix nuF;
  private final Matrix nuG;
  
  static
  {
    AppMethodBeat.i(237412);
    nuE = new a.a((byte)0);
    nuH = new RectF(-1000.0F, -1000.0F, 1000.0F, 1000.0F);
    AppMethodBeat.o(237412);
  }
  
  public a(boolean paramBoolean, int paramInt, RectF paramRectF)
  {
    AppMethodBeat.i(237407);
    if (paramRectF.width() == 0.0F)
    {
      i = 1;
      if (i != 0) {
        break label96;
      }
      if (paramRectF.height() != 0.0F) {
        break label90;
      }
      i = 1;
      label47:
      if (i != 0) {
        break label96;
      }
    }
    label90:
    label96:
    for (int i = j;; i = 0)
    {
      if (i != 0) {
        break label102;
      }
      paramRectF = (Throwable)new IllegalArgumentException("previewRect".toString());
      AppMethodBeat.o(237407);
      throw paramRectF;
      i = 0;
      break;
      i = 0;
      break label47;
    }
    label102:
    Matrix localMatrix1 = new Matrix();
    if (paramBoolean) {}
    for (float f = -1.0F;; f = 1.0F)
    {
      localMatrix1.setScale(f, 1.0F);
      localMatrix1.postRotate(paramInt);
      Matrix localMatrix2 = new Matrix();
      localMatrix2.setRectToRect(nuH, paramRectF, Matrix.ScaleToFit.FILL);
      localMatrix1.setConcat(localMatrix2, localMatrix1);
      this.nuF = localMatrix1;
      paramRectF = this.nuF;
      localMatrix1 = new Matrix();
      paramRectF.invert(localMatrix1);
      this.nuG = localMatrix1;
      AppMethodBeat.o(237407);
      return;
    }
  }
  
  public final RectF e(RectF paramRectF)
  {
    AppMethodBeat.i(237417);
    RectF localRectF = new RectF();
    this.nuG.mapRect(localRectF, paramRectF);
    AppMethodBeat.o(237417);
    return localRectF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.instance.camera1.a
 * JD-Core Version:    0.7.0.1
 */