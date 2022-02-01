package androidx.camera.camera2.b.a;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.Executor;

final class d
  extends e
{
  d(CameraCaptureSession paramCameraCaptureSession)
  {
    super(paramCameraCaptureSession, null);
  }
  
  public final int a(CaptureRequest paramCaptureRequest, Executor paramExecutor, CameraCaptureSession.CaptureCallback paramCaptureCallback)
  {
    AppMethodBeat.i(198050);
    int i = this.Fa.setSingleRepeatingRequest(paramCaptureRequest, paramExecutor, paramCaptureCallback);
    AppMethodBeat.o(198050);
    return i;
  }
  
  public final int a(List<CaptureRequest> paramList, Executor paramExecutor, CameraCaptureSession.CaptureCallback paramCaptureCallback)
  {
    AppMethodBeat.i(198041);
    int i = this.Fa.captureBurstRequests(paramList, paramExecutor, paramCaptureCallback);
    AppMethodBeat.o(198041);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.d
 * JD-Core Version:    0.7.0.1
 */