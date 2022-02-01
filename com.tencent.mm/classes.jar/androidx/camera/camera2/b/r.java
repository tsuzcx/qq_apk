package androidx.camera.camera2.b;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.camera.camera2.b.a.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class r
  extends CameraCaptureSession.CaptureCallback
{
  final Map<CaptureRequest, List<CameraCaptureSession.CaptureCallback>> BY;
  a BZ;
  
  r()
  {
    AppMethodBeat.i(197911);
    this.BZ = null;
    this.BY = new HashMap();
    AppMethodBeat.o(197911);
  }
  
  private List<CameraCaptureSession.CaptureCallback> a(CaptureRequest paramCaptureRequest)
  {
    AppMethodBeat.i(197918);
    paramCaptureRequest = (List)this.BY.get(paramCaptureRequest);
    if (paramCaptureRequest != null)
    {
      AppMethodBeat.o(197918);
      return paramCaptureRequest;
    }
    paramCaptureRequest = Collections.emptyList();
    AppMethodBeat.o(197918);
    return paramCaptureRequest;
  }
  
  public final void onCaptureBufferLost(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, Surface paramSurface, long paramLong)
  {
    AppMethodBeat.i(197928);
    Iterator localIterator = a(paramCaptureRequest).iterator();
    while (localIterator.hasNext()) {
      a.c.a((CameraCaptureSession.CaptureCallback)localIterator.next(), paramCameraCaptureSession, paramCaptureRequest, paramSurface, paramLong);
    }
    AppMethodBeat.o(197928);
  }
  
  public final void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult)
  {
    AppMethodBeat.i(197934);
    Iterator localIterator = a(paramCaptureRequest).iterator();
    while (localIterator.hasNext()) {
      ((CameraCaptureSession.CaptureCallback)localIterator.next()).onCaptureCompleted(paramCameraCaptureSession, paramCaptureRequest, paramTotalCaptureResult);
    }
    AppMethodBeat.o(197934);
  }
  
  public final void onCaptureFailed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureFailure paramCaptureFailure)
  {
    AppMethodBeat.i(197941);
    Iterator localIterator = a(paramCaptureRequest).iterator();
    while (localIterator.hasNext()) {
      ((CameraCaptureSession.CaptureCallback)localIterator.next()).onCaptureFailed(paramCameraCaptureSession, paramCaptureRequest, paramCaptureFailure);
    }
    AppMethodBeat.o(197941);
  }
  
  public final void onCaptureProgressed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureResult paramCaptureResult)
  {
    AppMethodBeat.i(197947);
    Iterator localIterator = a(paramCaptureRequest).iterator();
    while (localIterator.hasNext()) {
      ((CameraCaptureSession.CaptureCallback)localIterator.next()).onCaptureProgressed(paramCameraCaptureSession, paramCaptureRequest, paramCaptureResult);
    }
    AppMethodBeat.o(197947);
  }
  
  public final void onCaptureSequenceAborted(CameraCaptureSession paramCameraCaptureSession, int paramInt)
  {
    AppMethodBeat.i(197962);
    Iterator localIterator1 = this.BY.values().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((List)localIterator1.next()).iterator();
      while (localIterator2.hasNext()) {
        ((CameraCaptureSession.CaptureCallback)localIterator2.next()).onCaptureSequenceAborted(paramCameraCaptureSession, paramInt);
      }
    }
    if (this.BZ != null) {
      this.BZ.onCaptureSequenceCompletedOrAborted(paramCameraCaptureSession, paramInt, true);
    }
    AppMethodBeat.o(197962);
  }
  
  public final void onCaptureSequenceCompleted(CameraCaptureSession paramCameraCaptureSession, int paramInt, long paramLong)
  {
    AppMethodBeat.i(197973);
    Iterator localIterator1 = this.BY.values().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((List)localIterator1.next()).iterator();
      while (localIterator2.hasNext()) {
        ((CameraCaptureSession.CaptureCallback)localIterator2.next()).onCaptureSequenceCompleted(paramCameraCaptureSession, paramInt, paramLong);
      }
    }
    if (this.BZ != null) {
      this.BZ.onCaptureSequenceCompletedOrAborted(paramCameraCaptureSession, paramInt, false);
    }
    AppMethodBeat.o(197973);
  }
  
  public final void onCaptureStarted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(197953);
    Iterator localIterator = a(paramCaptureRequest).iterator();
    while (localIterator.hasNext()) {
      ((CameraCaptureSession.CaptureCallback)localIterator.next()).onCaptureStarted(paramCameraCaptureSession, paramCaptureRequest, paramLong1, paramLong2);
    }
    AppMethodBeat.o(197953);
  }
  
  static abstract interface a
  {
    public abstract void onCaptureSequenceCompletedOrAborted(CameraCaptureSession paramCameraCaptureSession, int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.r
 * JD-Core Version:    0.7.0.1
 */