package androidx.camera.camera2.b.a;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

final class p
  extends o
{
  p(Context paramContext)
  {
    super(paramContext);
  }
  
  public final CameraCharacteristics K(String paramString)
  {
    AppMethodBeat.i(198099);
    try
    {
      paramString = this.Fk.getCameraCharacteristics(paramString);
      AppMethodBeat.o(198099);
      return paramString;
    }
    catch (CameraAccessException paramString)
    {
      paramString = b.a(paramString);
      AppMethodBeat.o(198099);
      throw paramString;
    }
  }
  
  public final void a(String paramString, Executor paramExecutor, CameraDevice.StateCallback paramStateCallback)
  {
    AppMethodBeat.i(198093);
    try
    {
      com.tencent.mm.hellhoundlib.a.a.a(this.Fk, new com.tencent.mm.hellhoundlib.b.a().cG(paramStateCallback).cG(paramExecutor).cG(paramString).aYi(), "androidx/camera/camera2/internal/compat/CameraManagerCompatApi29Impl", "openCamera", "(Ljava/lang/String;Ljava/util/concurrent/Executor;Landroid/hardware/camera2/CameraDevice$StateCallback;)V", "android/hardware/camera2/CameraManager", "openCamera", "(Ljava/lang/String;Ljava/util/concurrent/Executor;Landroid/hardware/camera2/CameraDevice$StateCallback;)V");
      AppMethodBeat.o(198093);
      return;
    }
    catch (CameraAccessException paramString)
    {
      paramString = b.a(paramString);
      AppMethodBeat.o(198093);
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.p
 * JD-Core Version:    0.7.0.1
 */