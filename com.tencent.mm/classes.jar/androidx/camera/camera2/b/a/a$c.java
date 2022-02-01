package androidx.camera.camera2.b.a;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureRequest;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$c
{
  public static void a(CameraCaptureSession.CaptureCallback paramCaptureCallback, CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, Surface paramSurface, long paramLong)
  {
    AppMethodBeat.i(197937);
    paramCaptureCallback.onCaptureBufferLost(paramCameraCaptureSession, paramCaptureRequest, paramSurface, paramLong);
    AppMethodBeat.o(197937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.a.c
 * JD-Core Version:    0.7.0.1
 */