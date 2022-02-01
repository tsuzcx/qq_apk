package androidx.camera.camera2.b.a;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.os.Build.VERSION;
import android.os.Handler;
import androidx.camera.camera2.b.a.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

public final class i
{
  public final a Fe;
  
  public i(CameraDevice paramCameraDevice, Handler paramHandler)
  {
    AppMethodBeat.i(198059);
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.Fe = new l(paramCameraDevice);
      AppMethodBeat.o(198059);
      return;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      this.Fe = new k(paramCameraDevice, new m.a(paramHandler));
      AppMethodBeat.o(198059);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.Fe = new j(paramCameraDevice, new m.a(paramHandler));
      AppMethodBeat.o(198059);
      return;
    }
    this.Fe = new m(paramCameraDevice, new m.a(paramHandler));
    AppMethodBeat.o(198059);
  }
  
  public static abstract interface a
  {
    public abstract void a(g paramg);
  }
  
  static final class b
    extends CameraDevice.StateCallback
  {
    final CameraDevice.StateCallback Ff;
    private final Executor mExecutor;
    
    b(Executor paramExecutor, CameraDevice.StateCallback paramStateCallback)
    {
      this.mExecutor = paramExecutor;
      this.Ff = paramStateCallback;
    }
    
    public final void onClosed(CameraDevice paramCameraDevice)
    {
      AppMethodBeat.i(198151);
      this.mExecutor.execute(new i.b..ExternalSyntheticLambda1(this, paramCameraDevice));
      AppMethodBeat.o(198151);
    }
    
    public final void onDisconnected(CameraDevice paramCameraDevice)
    {
      AppMethodBeat.i(198139);
      this.mExecutor.execute(new i.b..ExternalSyntheticLambda2(this, paramCameraDevice));
      AppMethodBeat.o(198139);
    }
    
    public final void onError(CameraDevice paramCameraDevice, int paramInt)
    {
      AppMethodBeat.i(198146);
      this.mExecutor.execute(new i.b..ExternalSyntheticLambda3(this, paramCameraDevice, paramInt));
      AppMethodBeat.o(198146);
    }
    
    public final void onOpened(CameraDevice paramCameraDevice)
    {
      AppMethodBeat.i(198134);
      this.mExecutor.execute(new i.b..ExternalSyntheticLambda0(this, paramCameraDevice));
      AppMethodBeat.o(198134);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.i
 * JD-Core Version:    0.7.0.1
 */