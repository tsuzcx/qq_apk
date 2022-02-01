package androidx.camera.camera2.b.a;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.params.OutputConfiguration;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$d
{
  public static <T> OutputConfiguration a(Size paramSize, Class<T> paramClass)
  {
    AppMethodBeat.i(197938);
    paramSize = new OutputConfiguration(paramSize, paramClass);
    AppMethodBeat.o(197938);
    return paramSize;
  }
  
  public static void a(CameraCaptureSession.StateCallback paramStateCallback, CameraCaptureSession paramCameraCaptureSession)
  {
    AppMethodBeat.i(197932);
    paramStateCallback.onCaptureQueueEmpty(paramCameraCaptureSession);
    AppMethodBeat.o(197932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.a.d
 * JD-Core Version:    0.7.0.1
 */