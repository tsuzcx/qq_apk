package androidx.camera.camera2.b.a;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.Executor;

public final class c
{
  public final a EX;
  
  public c(CameraCaptureSession paramCameraCaptureSession, Handler paramHandler)
  {
    AppMethodBeat.i(198045);
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.EX = new d(paramCameraCaptureSession);
      AppMethodBeat.o(198045);
      return;
    }
    this.EX = new e(paramCameraCaptureSession, new e.a(paramHandler));
    AppMethodBeat.o(198045);
  }
  
  public final CameraCaptureSession hR()
  {
    AppMethodBeat.i(198055);
    CameraCaptureSession localCameraCaptureSession = this.EX.hS();
    AppMethodBeat.o(198055);
    return localCameraCaptureSession;
  }
  
  public static abstract interface a
  {
    public abstract int a(CaptureRequest paramCaptureRequest, Executor paramExecutor, CameraCaptureSession.CaptureCallback paramCaptureCallback);
    
    public abstract int a(List<CaptureRequest> paramList, Executor paramExecutor, CameraCaptureSession.CaptureCallback paramCaptureCallback);
    
    public abstract CameraCaptureSession hS();
  }
  
  static final class b
    extends CameraCaptureSession.CaptureCallback
  {
    final CameraCaptureSession.CaptureCallback EY;
    private final Executor mExecutor;
    
    b(Executor paramExecutor, CameraCaptureSession.CaptureCallback paramCaptureCallback)
    {
      this.mExecutor = paramExecutor;
      this.EY = paramCaptureCallback;
    }
    
    public final void onCaptureBufferLost(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, Surface paramSurface, long paramLong)
    {
      AppMethodBeat.i(198103);
      this.mExecutor.execute(new c.b..ExternalSyntheticLambda6(this, paramCameraCaptureSession, paramCaptureRequest, paramSurface, paramLong));
      AppMethodBeat.o(198103);
    }
    
    public final void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult)
    {
      AppMethodBeat.i(198081);
      this.mExecutor.execute(new c.b..ExternalSyntheticLambda5(this, paramCameraCaptureSession, paramCaptureRequest, paramTotalCaptureResult));
      AppMethodBeat.o(198081);
    }
    
    public final void onCaptureFailed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureFailure paramCaptureFailure)
    {
      AppMethodBeat.i(198087);
      this.mExecutor.execute(new c.b..ExternalSyntheticLambda3(this, paramCameraCaptureSession, paramCaptureRequest, paramCaptureFailure));
      AppMethodBeat.o(198087);
    }
    
    public final void onCaptureProgressed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureResult paramCaptureResult)
    {
      AppMethodBeat.i(198073);
      this.mExecutor.execute(new c.b..ExternalSyntheticLambda4(this, paramCameraCaptureSession, paramCaptureRequest, paramCaptureResult));
      AppMethodBeat.o(198073);
    }
    
    public final void onCaptureSequenceAborted(CameraCaptureSession paramCameraCaptureSession, int paramInt)
    {
      AppMethodBeat.i(198097);
      this.mExecutor.execute(new c.b..ExternalSyntheticLambda0(this, paramCameraCaptureSession, paramInt));
      AppMethodBeat.o(198097);
    }
    
    public final void onCaptureSequenceCompleted(CameraCaptureSession paramCameraCaptureSession, int paramInt, long paramLong)
    {
      AppMethodBeat.i(198094);
      this.mExecutor.execute(new c.b..ExternalSyntheticLambda1(this, paramCameraCaptureSession, paramInt, paramLong));
      AppMethodBeat.o(198094);
    }
    
    public final void onCaptureStarted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(198066);
      this.mExecutor.execute(new c.b..ExternalSyntheticLambda2(this, paramCameraCaptureSession, paramCaptureRequest, paramLong1, paramLong2));
      AppMethodBeat.o(198066);
    }
  }
  
  static final class c
    extends CameraCaptureSession.StateCallback
  {
    final CameraCaptureSession.StateCallback EZ;
    private final Executor mExecutor;
    
    c(Executor paramExecutor, CameraCaptureSession.StateCallback paramStateCallback)
    {
      this.mExecutor = paramExecutor;
      this.EZ = paramStateCallback;
    }
    
    public final void onActive(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(198084);
      this.mExecutor.execute(new c.c..ExternalSyntheticLambda5(this, paramCameraCaptureSession));
      AppMethodBeat.o(198084);
    }
    
    public final void onCaptureQueueEmpty(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(198088);
      this.mExecutor.execute(new c.c..ExternalSyntheticLambda0(this, paramCameraCaptureSession));
      AppMethodBeat.o(198088);
    }
    
    public final void onClosed(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(198095);
      this.mExecutor.execute(new c.c..ExternalSyntheticLambda3(this, paramCameraCaptureSession));
      AppMethodBeat.o(198095);
    }
    
    public final void onConfigureFailed(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(198071);
      this.mExecutor.execute(new c.c..ExternalSyntheticLambda4(this, paramCameraCaptureSession));
      AppMethodBeat.o(198071);
    }
    
    public final void onConfigured(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(198065);
      this.mExecutor.execute(new c.c..ExternalSyntheticLambda1(this, paramCameraCaptureSession));
      AppMethodBeat.o(198065);
    }
    
    public final void onReady(CameraCaptureSession paramCameraCaptureSession)
    {
      AppMethodBeat.i(198079);
      this.mExecutor.execute(new c.c..ExternalSyntheticLambda2(this, paramCameraCaptureSession));
      AppMethodBeat.o(198079);
    }
    
    public final void onSurfacePrepared(CameraCaptureSession paramCameraCaptureSession, Surface paramSurface)
    {
      AppMethodBeat.i(198101);
      this.mExecutor.execute(new c.c..ExternalSyntheticLambda6(this, paramCameraCaptureSession, paramSurface));
      AppMethodBeat.o(198101);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.c
 * JD-Core Version:    0.7.0.1
 */