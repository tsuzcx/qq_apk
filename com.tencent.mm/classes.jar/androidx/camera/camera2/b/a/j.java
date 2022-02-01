package androidx.camera.camera2.b.a;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Handler;
import androidx.camera.camera2.b.a.a.a;
import androidx.camera.camera2.b.a.a.g;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

class j
  extends m
{
  j(CameraDevice paramCameraDevice, Object paramObject)
  {
    super(paramCameraDevice, paramObject);
  }
  
  public void a(g paramg)
  {
    AppMethodBeat.i(198060);
    a(this.AF, paramg);
    c.c localc = new c.c(paramg.hI(), paramg.ib());
    List localList = C(paramg.ia());
    Handler localHandler = ((m.a)f.checkNotNull((m.a)this.Fg)).Ej;
    a locala = paramg.ic();
    if (locala != null) {}
    try
    {
      paramg = (InputConfiguration)locala.hV();
      f.checkNotNull(paramg);
      this.AF.createReprocessableCaptureSession(paramg, localList, localc, localHandler);
      AppMethodBeat.o(198060);
      return;
    }
    catch (CameraAccessException paramg)
    {
      paramg = b.a(paramg);
      AppMethodBeat.o(198060);
      throw paramg;
    }
    if (paramg.hZ() == 1)
    {
      this.AF.createConstrainedHighSpeedCaptureSession(localList, localc, localHandler);
      AppMethodBeat.o(198060);
      return;
    }
    a(this.AF, localList, localc, localHandler);
    AppMethodBeat.o(198060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.j
 * JD-Core Version:    0.7.0.1
 */