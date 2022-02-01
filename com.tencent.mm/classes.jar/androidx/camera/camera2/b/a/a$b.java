package androidx.camera.camera2.b.a;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$b
{
  public static void a(CameraCaptureSession.StateCallback paramStateCallback, CameraCaptureSession paramCameraCaptureSession, Surface paramSurface)
  {
    AppMethodBeat.i(197936);
    paramStateCallback.onSurfacePrepared(paramCameraCaptureSession, paramSurface);
    AppMethodBeat.o(197936);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */