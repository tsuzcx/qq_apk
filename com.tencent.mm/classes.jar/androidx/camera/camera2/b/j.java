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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class j
{
  static CameraCaptureSession.CaptureCallback p(List<CameraCaptureSession.CaptureCallback> paramList)
  {
    AppMethodBeat.i(197584);
    paramList = new a(paramList);
    AppMethodBeat.o(197584);
    return paramList;
  }
  
  static final class a
    extends CameraCaptureSession.CaptureCallback
  {
    private final List<CameraCaptureSession.CaptureCallback> cQ;
    
    a(List<CameraCaptureSession.CaptureCallback> paramList)
    {
      AppMethodBeat.i(197790);
      this.cQ = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CameraCaptureSession.CaptureCallback localCaptureCallback = (CameraCaptureSession.CaptureCallback)paramList.next();
        if (!(localCaptureCallback instanceof j.b)) {
          this.cQ.add(localCaptureCallback);
        }
      }
      AppMethodBeat.o(197790);
    }
    
    public final void onCaptureBufferLost(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, Surface paramSurface, long paramLong)
    {
      AppMethodBeat.i(197803);
      Iterator localIterator = this.cQ.iterator();
      while (localIterator.hasNext()) {
        a.c.a((CameraCaptureSession.CaptureCallback)localIterator.next(), paramCameraCaptureSession, paramCaptureRequest, paramSurface, paramLong);
      }
      AppMethodBeat.o(197803);
    }
    
    public final void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult)
    {
      AppMethodBeat.i(197811);
      Iterator localIterator = this.cQ.iterator();
      while (localIterator.hasNext()) {
        ((CameraCaptureSession.CaptureCallback)localIterator.next()).onCaptureCompleted(paramCameraCaptureSession, paramCaptureRequest, paramTotalCaptureResult);
      }
      AppMethodBeat.o(197811);
    }
    
    public final void onCaptureFailed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureFailure paramCaptureFailure)
    {
      AppMethodBeat.i(197818);
      Iterator localIterator = this.cQ.iterator();
      while (localIterator.hasNext()) {
        ((CameraCaptureSession.CaptureCallback)localIterator.next()).onCaptureFailed(paramCameraCaptureSession, paramCaptureRequest, paramCaptureFailure);
      }
      AppMethodBeat.o(197818);
    }
    
    public final void onCaptureProgressed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureResult paramCaptureResult)
    {
      AppMethodBeat.i(197824);
      Iterator localIterator = this.cQ.iterator();
      while (localIterator.hasNext()) {
        ((CameraCaptureSession.CaptureCallback)localIterator.next()).onCaptureProgressed(paramCameraCaptureSession, paramCaptureRequest, paramCaptureResult);
      }
      AppMethodBeat.o(197824);
    }
    
    public final void onCaptureSequenceAborted(CameraCaptureSession paramCameraCaptureSession, int paramInt)
    {
      AppMethodBeat.i(197835);
      Iterator localIterator = this.cQ.iterator();
      while (localIterator.hasNext()) {
        ((CameraCaptureSession.CaptureCallback)localIterator.next()).onCaptureSequenceAborted(paramCameraCaptureSession, paramInt);
      }
      AppMethodBeat.o(197835);
    }
    
    public final void onCaptureSequenceCompleted(CameraCaptureSession paramCameraCaptureSession, int paramInt, long paramLong)
    {
      AppMethodBeat.i(197841);
      Iterator localIterator = this.cQ.iterator();
      while (localIterator.hasNext()) {
        ((CameraCaptureSession.CaptureCallback)localIterator.next()).onCaptureSequenceCompleted(paramCameraCaptureSession, paramInt, paramLong);
      }
      AppMethodBeat.o(197841);
    }
    
    public final void onCaptureStarted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(197846);
      Iterator localIterator = this.cQ.iterator();
      while (localIterator.hasNext()) {
        ((CameraCaptureSession.CaptureCallback)localIterator.next()).onCaptureStarted(paramCameraCaptureSession, paramCaptureRequest, paramLong1, paramLong2);
      }
      AppMethodBeat.o(197846);
    }
  }
  
  static final class b
    extends CameraCaptureSession.CaptureCallback
  {
    public final void onCaptureBufferLost(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, Surface paramSurface, long paramLong) {}
    
    public final void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult) {}
    
    public final void onCaptureFailed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureFailure paramCaptureFailure) {}
    
    public final void onCaptureProgressed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureResult paramCaptureResult) {}
    
    public final void onCaptureSequenceAborted(CameraCaptureSession paramCameraCaptureSession, int paramInt) {}
    
    public final void onCaptureSequenceCompleted(CameraCaptureSession paramCameraCaptureSession, int paramInt, long paramLong) {}
    
    public final void onCaptureStarted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, long paramLong1, long paramLong2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.j
 * JD-Core Version:    0.7.0.1
 */