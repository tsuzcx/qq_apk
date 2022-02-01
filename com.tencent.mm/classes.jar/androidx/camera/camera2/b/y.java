package androidx.camera.camera2.b;

import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import androidx.camera.core.impl.h;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class y
  extends h
{
  final CameraCaptureSession.CaptureCallback Cd;
  
  private y(CameraCaptureSession.CaptureCallback paramCaptureCallback)
  {
    AppMethodBeat.i(197889);
    if (paramCaptureCallback == null)
    {
      paramCaptureCallback = new NullPointerException("captureCallback is null");
      AppMethodBeat.o(197889);
      throw paramCaptureCallback;
    }
    this.Cd = paramCaptureCallback;
    AppMethodBeat.o(197889);
  }
  
  static y b(CameraCaptureSession.CaptureCallback paramCaptureCallback)
  {
    AppMethodBeat.i(197892);
    paramCaptureCallback = new y(paramCaptureCallback);
    AppMethodBeat.o(197892);
    return paramCaptureCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.y
 * JD-Core Version:    0.7.0.1
 */