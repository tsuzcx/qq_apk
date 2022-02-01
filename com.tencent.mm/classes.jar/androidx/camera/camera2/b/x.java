package androidx.camera.camera2.b;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.core.impl.bi;
import androidx.camera.core.impl.h;
import androidx.camera.core.impl.j;
import androidx.camera.core.impl.j.a;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class x
  extends CameraCaptureSession.CaptureCallback
{
  private final h Cc;
  
  x(h paramh)
  {
    AppMethodBeat.i(197888);
    if (paramh == null)
    {
      paramh = new NullPointerException("cameraCaptureCallback is null");
      AppMethodBeat.o(197888);
      throw paramh;
    }
    this.Cc = paramh;
    AppMethodBeat.o(197888);
  }
  
  public final void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult)
  {
    AppMethodBeat.i(197893);
    super.onCaptureCompleted(paramCameraCaptureSession, paramCaptureRequest, paramTotalCaptureResult);
    paramCameraCaptureSession = paramCaptureRequest.getTag();
    if (paramCameraCaptureSession != null) {
      f.checkArgument(paramCameraCaptureSession instanceof bi, "The tagBundle object from the CaptureResult is not a TagBundle object.");
    }
    for (paramCameraCaptureSession = (bi)paramCameraCaptureSession;; paramCameraCaptureSession = bi.kA())
    {
      this.Cc.a(new e(paramCameraCaptureSession, paramTotalCaptureResult));
      AppMethodBeat.o(197893);
      return;
    }
  }
  
  public final void onCaptureFailed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureFailure paramCaptureFailure)
  {
    AppMethodBeat.i(197898);
    super.onCaptureFailed(paramCameraCaptureSession, paramCaptureRequest, paramCaptureFailure);
    paramCameraCaptureSession = new j(j.a.KJ);
    this.Cc.a(paramCameraCaptureSession);
    AppMethodBeat.o(197898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.x
 * JD-Core Version:    0.7.0.1
 */