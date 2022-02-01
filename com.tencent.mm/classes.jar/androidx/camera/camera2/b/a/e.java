package androidx.camera.camera2.b.a;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.Executor;

class e
  implements c.a
{
  final CameraCaptureSession Fa;
  final Object mObject;
  
  e(CameraCaptureSession paramCameraCaptureSession, Object paramObject)
  {
    AppMethodBeat.i(198037);
    this.Fa = ((CameraCaptureSession)f.checkNotNull(paramCameraCaptureSession));
    this.mObject = paramObject;
    AppMethodBeat.o(198037);
  }
  
  public int a(CaptureRequest paramCaptureRequest, Executor paramExecutor, CameraCaptureSession.CaptureCallback paramCaptureCallback)
  {
    AppMethodBeat.i(198057);
    paramExecutor = new c.b(paramExecutor, paramCaptureCallback);
    paramCaptureCallback = (a)this.mObject;
    int i = this.Fa.setRepeatingRequest(paramCaptureRequest, paramExecutor, paramCaptureCallback.Ej);
    AppMethodBeat.o(198057);
    return i;
  }
  
  public int a(List<CaptureRequest> paramList, Executor paramExecutor, CameraCaptureSession.CaptureCallback paramCaptureCallback)
  {
    AppMethodBeat.i(198047);
    paramExecutor = new c.b(paramExecutor, paramCaptureCallback);
    paramCaptureCallback = (a)this.mObject;
    int i = this.Fa.captureBurst(paramList, paramExecutor, paramCaptureCallback.Ej);
    AppMethodBeat.o(198047);
    return i;
  }
  
  public final CameraCaptureSession hS()
  {
    return this.Fa;
  }
  
  static final class a
  {
    final Handler Ej;
    
    a(Handler paramHandler)
    {
      this.Ej = paramHandler;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.e
 * JD-Core Version:    0.7.0.1
 */