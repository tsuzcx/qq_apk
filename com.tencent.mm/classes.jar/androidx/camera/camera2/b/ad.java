package androidx.camera.camera2.b;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.c.a.b.a;
import androidx.camera.camera2.a.a.a;
import androidx.camera.camera2.b.a.h;
import androidx.camera.core.k.a;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ad
  implements as.a
{
  private Rect CI = null;
  private Rect CJ = null;
  private final h zI;
  private b.a<Void> zL;
  
  ad(h paramh)
  {
    this.zI = paramh;
  }
  
  private Rect gx()
  {
    AppMethodBeat.i(197444);
    Rect localRect = (Rect)f.checkNotNull((Rect)this.zI.a(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
    AppMethodBeat.o(197444);
    return localRect;
  }
  
  public final void a(float paramFloat, b.a<Void> parama)
  {
    AppMethodBeat.i(197495);
    Rect localRect = gx();
    float f1 = localRect.width() / paramFloat;
    paramFloat = localRect.height() / paramFloat;
    float f2 = (localRect.width() - f1) / 2.0F;
    float f3 = (localRect.height() - paramFloat) / 2.0F;
    this.CI = new Rect((int)f2, (int)f3, (int)(f1 + f2), (int)(f3 + paramFloat));
    if (this.zL != null) {
      this.zL.h(new k.a("There is a new zoomRatio being set"));
    }
    this.CJ = this.CI;
    this.zL = parama;
    AppMethodBeat.o(197495);
  }
  
  public final void a(TotalCaptureResult paramTotalCaptureResult)
  {
    AppMethodBeat.i(197501);
    if (this.zL != null)
    {
      paramTotalCaptureResult = paramTotalCaptureResult.getRequest();
      if (paramTotalCaptureResult != null) {
        break label66;
      }
    }
    label66:
    for (paramTotalCaptureResult = null;; paramTotalCaptureResult = (Rect)paramTotalCaptureResult.get(CaptureRequest.SCALER_CROP_REGION))
    {
      if ((this.CJ != null) && (this.CJ.equals(paramTotalCaptureResult)))
      {
        this.zL.ap(null);
        this.zL = null;
        this.CJ = null;
      }
      AppMethodBeat.o(197501);
      return;
    }
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(197476);
    if (this.CI != null) {
      parama.a(CaptureRequest.SCALER_CROP_REGION, this.CI);
    }
    AppMethodBeat.o(197476);
  }
  
  public final void gd()
  {
    AppMethodBeat.i(197484);
    this.CJ = null;
    this.CI = null;
    if (this.zL != null)
    {
      this.zL.h(new k.a("Camera is not active."));
      this.zL = null;
    }
    AppMethodBeat.o(197484);
  }
  
  public final Rect ge()
  {
    AppMethodBeat.i(197507);
    if (this.CI != null)
    {
      localRect = this.CI;
      AppMethodBeat.o(197507);
      return localRect;
    }
    Rect localRect = gx();
    AppMethodBeat.o(197507);
    return localRect;
  }
  
  public final float getMaxZoom()
  {
    AppMethodBeat.i(197465);
    Float localFloat = (Float)this.zI.a(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
    if (localFloat == null)
    {
      AppMethodBeat.o(197465);
      return 1.0F;
    }
    if (localFloat.floatValue() < 1.0F)
    {
      AppMethodBeat.o(197465);
      return 1.0F;
    }
    float f = localFloat.floatValue();
    AppMethodBeat.o(197465);
    return f;
  }
  
  public final float getMinZoom()
  {
    return 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.ad
 * JD-Core Version:    0.7.0.1
 */