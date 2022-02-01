package androidx.camera.camera2.b;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.view.Surface;
import androidx.camera.camera2.b.a.a.b;
import androidx.camera.camera2.b.a.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class s$a
  extends CameraCaptureSession.StateCallback
{
  private final List<CameraCaptureSession.StateCallback> cQ;
  
  s$a(List<CameraCaptureSession.StateCallback> paramList)
  {
    AppMethodBeat.i(197847);
    this.cQ = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CameraCaptureSession.StateCallback localStateCallback = (CameraCaptureSession.StateCallback)paramList.next();
      if (!(localStateCallback instanceof s.b)) {
        this.cQ.add(localStateCallback);
      }
    }
    AppMethodBeat.o(197847);
  }
  
  public final void onActive(CameraCaptureSession paramCameraCaptureSession)
  {
    AppMethodBeat.i(197853);
    Iterator localIterator = this.cQ.iterator();
    while (localIterator.hasNext()) {
      ((CameraCaptureSession.StateCallback)localIterator.next()).onActive(paramCameraCaptureSession);
    }
    AppMethodBeat.o(197853);
  }
  
  public final void onCaptureQueueEmpty(CameraCaptureSession paramCameraCaptureSession)
  {
    AppMethodBeat.i(197862);
    Iterator localIterator = this.cQ.iterator();
    while (localIterator.hasNext()) {
      a.d.a((CameraCaptureSession.StateCallback)localIterator.next(), paramCameraCaptureSession);
    }
    AppMethodBeat.o(197862);
  }
  
  public final void onClosed(CameraCaptureSession paramCameraCaptureSession)
  {
    AppMethodBeat.i(197857);
    Iterator localIterator = this.cQ.iterator();
    while (localIterator.hasNext()) {
      ((CameraCaptureSession.StateCallback)localIterator.next()).onClosed(paramCameraCaptureSession);
    }
    AppMethodBeat.o(197857);
  }
  
  public final void onConfigureFailed(CameraCaptureSession paramCameraCaptureSession)
  {
    AppMethodBeat.i(197866);
    Iterator localIterator = this.cQ.iterator();
    while (localIterator.hasNext()) {
      ((CameraCaptureSession.StateCallback)localIterator.next()).onConfigureFailed(paramCameraCaptureSession);
    }
    AppMethodBeat.o(197866);
  }
  
  public final void onConfigured(CameraCaptureSession paramCameraCaptureSession)
  {
    AppMethodBeat.i(197852);
    Iterator localIterator = this.cQ.iterator();
    while (localIterator.hasNext()) {
      ((CameraCaptureSession.StateCallback)localIterator.next()).onConfigured(paramCameraCaptureSession);
    }
    AppMethodBeat.o(197852);
  }
  
  public final void onReady(CameraCaptureSession paramCameraCaptureSession)
  {
    AppMethodBeat.i(197859);
    Iterator localIterator = this.cQ.iterator();
    while (localIterator.hasNext()) {
      ((CameraCaptureSession.StateCallback)localIterator.next()).onReady(paramCameraCaptureSession);
    }
    AppMethodBeat.o(197859);
  }
  
  public final void onSurfacePrepared(CameraCaptureSession paramCameraCaptureSession, Surface paramSurface)
  {
    AppMethodBeat.i(197864);
    Iterator localIterator = this.cQ.iterator();
    while (localIterator.hasNext()) {
      a.b.a((CameraCaptureSession.StateCallback)localIterator.next(), paramCameraCaptureSession, paramSurface);
    }
    AppMethodBeat.o(197864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.s.a
 * JD-Core Version:    0.7.0.1
 */