package androidx.camera.camera2.b.a;

import android.hardware.camera2.CameraManager.AvailabilityCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

final class n$a
  extends CameraManager.AvailabilityCallback
{
  final CameraManager.AvailabilityCallback Fj;
  boolean mDisabled;
  private final Executor mExecutor;
  final Object mLock;
  
  n$a(Executor paramExecutor, CameraManager.AvailabilityCallback paramAvailabilityCallback)
  {
    AppMethodBeat.i(197950);
    this.mLock = new Object();
    this.mDisabled = false;
    this.mExecutor = paramExecutor;
    this.Fj = paramAvailabilityCallback;
    AppMethodBeat.o(197950);
  }
  
  public final void onCameraAccessPrioritiesChanged()
  {
    AppMethodBeat.i(198009);
    synchronized (this.mLock)
    {
      if (!this.mDisabled) {
        this.mExecutor.execute(new n.a..ExternalSyntheticLambda0(this));
      }
      AppMethodBeat.o(198009);
      return;
    }
  }
  
  public final void onCameraAvailable(String paramString)
  {
    AppMethodBeat.i(198021);
    synchronized (this.mLock)
    {
      if (!this.mDisabled) {
        this.mExecutor.execute(new n.a..ExternalSyntheticLambda1(this, paramString));
      }
      AppMethodBeat.o(198021);
      return;
    }
  }
  
  public final void onCameraUnavailable(String paramString)
  {
    AppMethodBeat.i(198030);
    synchronized (this.mLock)
    {
      if (!this.mDisabled) {
        this.mExecutor.execute(new n.a..ExternalSyntheticLambda2(this, paramString));
      }
      AppMethodBeat.o(198030);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.camera.camera2.b.a.n.a
 * JD-Core Version:    0.7.0.1
 */