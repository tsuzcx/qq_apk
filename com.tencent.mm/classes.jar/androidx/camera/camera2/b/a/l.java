package androidx.camera.camera2.b.a;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.SessionConfiguration;
import androidx.camera.camera2.b.a.a.g;
import androidx.camera.camera2.b.a.a.g.c;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class l
  extends k
{
  l(CameraDevice paramCameraDevice)
  {
    super((CameraDevice)f.checkNotNull(paramCameraDevice), null);
    AppMethodBeat.i(198058);
    AppMethodBeat.o(198058);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(198063);
    paramg = (SessionConfiguration)paramg.Fw.ie();
    f.checkNotNull(paramg);
    try
    {
      this.AF.createCaptureSession(paramg);
      AppMethodBeat.o(198063);
      return;
    }
    catch (CameraAccessException paramg)
    {
      paramg = b.a(paramg);
      AppMethodBeat.o(198063);
      throw paramg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.l
 * JD-Core Version:    0.7.0.1
 */