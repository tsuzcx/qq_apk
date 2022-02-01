package androidx.camera.camera2.b.a;

import android.hardware.camera2.CameraManager.AvailabilityCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$e
{
  public static void a(CameraManager.AvailabilityCallback paramAvailabilityCallback)
  {
    AppMethodBeat.i(197942);
    paramAvailabilityCallback.onCameraAccessPrioritiesChanged();
    AppMethodBeat.o(197942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.camera.camera2.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */