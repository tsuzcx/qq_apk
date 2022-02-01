package androidx.camera.camera2.b.a;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraManager.AvailabilityCallback;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

class o
  extends q
{
  o(Context paramContext)
  {
    super(paramContext, null);
  }
  
  static o O(Context paramContext)
  {
    AppMethodBeat.i(198070);
    paramContext = new o(paramContext);
    AppMethodBeat.o(198070);
    return paramContext;
  }
  
  private static void c(Throwable paramThrowable)
  {
    AppMethodBeat.i(198078);
    paramThrowable = new b(paramThrowable);
    AppMethodBeat.o(198078);
    throw paramThrowable;
  }
  
  private static boolean d(Throwable paramThrowable)
  {
    AppMethodBeat.i(198085);
    if ((Build.VERSION.SDK_INT == 28) && (e(paramThrowable)))
    {
      AppMethodBeat.o(198085);
      return true;
    }
    AppMethodBeat.o(198085);
    return false;
  }
  
  private static boolean e(Throwable paramThrowable)
  {
    AppMethodBeat.i(198091);
    if (paramThrowable.getClass().equals(RuntimeException.class))
    {
      paramThrowable = paramThrowable.getStackTrace();
      if ((paramThrowable == null) || (paramThrowable.length < 0))
      {
        AppMethodBeat.o(198091);
        return false;
      }
      boolean bool = "_enableShutterSound".equals(paramThrowable[0].getMethodName());
      AppMethodBeat.o(198091);
      return bool;
    }
    AppMethodBeat.o(198091);
    return false;
  }
  
  public CameraCharacteristics K(String paramString)
  {
    AppMethodBeat.i(198108);
    try
    {
      paramString = super.K(paramString);
      AppMethodBeat.o(198108);
      return paramString;
    }
    catch (RuntimeException paramString)
    {
      if (d(paramString)) {
        c(paramString);
      }
      AppMethodBeat.o(198108);
      throw paramString;
    }
  }
  
  public void a(String paramString, Executor paramExecutor, CameraDevice.StateCallback paramStateCallback)
  {
    AppMethodBeat.i(198106);
    try
    {
      com.tencent.mm.hellhoundlib.a.a.a(this.Fk, new com.tencent.mm.hellhoundlib.b.a().cG(paramStateCallback).cG(paramExecutor).cG(paramString).aYi(), "androidx/camera/camera2/internal/compat/CameraManagerCompatApi28Impl", "openCamera", "(Ljava/lang/String;Ljava/util/concurrent/Executor;Landroid/hardware/camera2/CameraDevice$StateCallback;)V", "android/hardware/camera2/CameraManager", "openCamera", "(Ljava/lang/String;Ljava/util/concurrent/Executor;Landroid/hardware/camera2/CameraDevice$StateCallback;)V");
      AppMethodBeat.o(198106);
      return;
    }
    catch (CameraAccessException paramString)
    {
      paramString = b.a(paramString);
      AppMethodBeat.o(198106);
      throw paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      AppMethodBeat.o(198106);
      throw paramString;
    }
    catch (RuntimeException paramString)
    {
      if (d(paramString)) {
        c(paramString);
      }
      AppMethodBeat.o(198106);
      throw paramString;
    }
    catch (SecurityException paramString)
    {
      label67:
      break label67;
    }
  }
  
  public final void a(Executor paramExecutor, CameraManager.AvailabilityCallback paramAvailabilityCallback)
  {
    AppMethodBeat.i(198096);
    this.Fk.registerAvailabilityCallback(paramExecutor, paramAvailabilityCallback);
    AppMethodBeat.o(198096);
  }
  
  public final void b(CameraManager.AvailabilityCallback paramAvailabilityCallback)
  {
    AppMethodBeat.i(198102);
    this.Fk.unregisterAvailabilityCallback(paramAvailabilityCallback);
    AppMethodBeat.o(198102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.o
 * JD-Core Version:    0.7.0.1
 */