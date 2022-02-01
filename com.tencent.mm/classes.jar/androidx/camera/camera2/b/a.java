package androidx.camera.camera2.b;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Range;
import androidx.c.a.b.a;
import androidx.camera.camera2.a.a.a;
import androidx.camera.camera2.b.a.h;
import androidx.camera.core.k.a;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a
  implements as.a
{
  private final h zI;
  private final Range<Float> zJ;
  private float zK;
  private b.a<Void> zL;
  private float zM;
  
  a(h paramh)
  {
    AppMethodBeat.i(197607);
    this.zK = 1.0F;
    this.zM = 1.0F;
    this.zI = paramh;
    this.zJ = ((Range)this.zI.a(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE));
    AppMethodBeat.o(197607);
  }
  
  public final void a(float paramFloat, b.a<Void> parama)
  {
    AppMethodBeat.i(197637);
    this.zK = paramFloat;
    if (this.zL != null) {
      this.zL.h(new k.a("There is a new zoomRatio being set"));
    }
    this.zM = this.zK;
    this.zL = parama;
    AppMethodBeat.o(197637);
  }
  
  public final void a(TotalCaptureResult paramTotalCaptureResult)
  {
    AppMethodBeat.i(197641);
    if (this.zL != null)
    {
      paramTotalCaptureResult = paramTotalCaptureResult.getRequest();
      if (paramTotalCaptureResult == null) {}
      for (paramTotalCaptureResult = null; paramTotalCaptureResult == null; paramTotalCaptureResult = (Float)paramTotalCaptureResult.get(CaptureRequest.CONTROL_ZOOM_RATIO))
      {
        AppMethodBeat.o(197641);
        return;
      }
      float f = paramTotalCaptureResult.floatValue();
      if (this.zM == f)
      {
        this.zL.ap(null);
        this.zL = null;
      }
    }
    AppMethodBeat.o(197641);
  }
  
  public final void a(a.a parama)
  {
    AppMethodBeat.i(197625);
    parama.a(CaptureRequest.CONTROL_ZOOM_RATIO, Float.valueOf(this.zK));
    AppMethodBeat.o(197625);
  }
  
  public final void gd()
  {
    AppMethodBeat.i(197630);
    this.zK = 1.0F;
    if (this.zL != null)
    {
      this.zL.h(new k.a("Camera is not active."));
      this.zL = null;
    }
    AppMethodBeat.o(197630);
  }
  
  public final Rect ge()
  {
    AppMethodBeat.i(197647);
    Rect localRect = (Rect)f.checkNotNull((Rect)this.zI.a(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
    AppMethodBeat.o(197647);
    return localRect;
  }
  
  public final float getMaxZoom()
  {
    AppMethodBeat.i(197620);
    float f = ((Float)this.zJ.getUpper()).floatValue();
    AppMethodBeat.o(197620);
    return f;
  }
  
  public final float getMinZoom()
  {
    AppMethodBeat.i(197616);
    float f = ((Float)this.zJ.getLower()).floatValue();
    AppMethodBeat.o(197616);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a
 * JD-Core Version:    0.7.0.1
 */