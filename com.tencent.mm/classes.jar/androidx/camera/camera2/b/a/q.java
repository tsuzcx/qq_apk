package androidx.camera.camera2.b.a;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraManager.AvailabilityCallback;
import android.os.Handler;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

class q
  implements n.b
{
  final CameraManager Fk;
  final Object mObject;
  
  q(Context paramContext, Object paramObject)
  {
    AppMethodBeat.i(198077);
    this.Fk = ((CameraManager)paramContext.getSystemService("camera"));
    this.mObject = paramObject;
    AppMethodBeat.o(198077);
  }
  
  static q c(Context paramContext, Handler paramHandler)
  {
    AppMethodBeat.i(198083);
    paramContext = new q(paramContext, new a(paramHandler));
    AppMethodBeat.o(198083);
    return paramContext;
  }
  
  public CameraCharacteristics K(String paramString)
  {
    AppMethodBeat.i(198107);
    try
    {
      paramString = this.Fk.getCameraCharacteristics(paramString);
      AppMethodBeat.o(198107);
      return paramString;
    }
    catch (CameraAccessException paramString)
    {
      paramString = b.a(paramString);
      AppMethodBeat.o(198107);
      throw paramString;
    }
  }
  
  public void a(String paramString, Executor paramExecutor, CameraDevice.StateCallback paramStateCallback)
  {
    AppMethodBeat.i(198109);
    f.checkNotNull(paramExecutor);
    f.checkNotNull(paramStateCallback);
    paramExecutor = new i.b(paramExecutor, paramStateCallback);
    Object localObject = (a)this.mObject;
    try
    {
      paramStateCallback = this.Fk;
      localObject = ((a)localObject).Ej;
      com.tencent.mm.hellhoundlib.a.a.a(paramStateCallback, new com.tencent.mm.hellhoundlib.b.a().cG(localObject).cG(paramExecutor).cG(paramString).aYi(), "androidx/camera/camera2/internal/compat/CameraManagerCompatBaseImpl", "openCamera", "(Ljava/lang/String;Ljava/util/concurrent/Executor;Landroid/hardware/camera2/CameraDevice$StateCallback;)V", "android/hardware/camera2/CameraManager", "openCamera", "(Ljava/lang/String;Landroid/hardware/camera2/CameraDevice$StateCallback;Landroid/os/Handler;)V");
      AppMethodBeat.o(198109);
      return;
    }
    catch (CameraAccessException paramString)
    {
      paramString = b.a(paramString);
      AppMethodBeat.o(198109);
      throw paramString;
    }
  }
  
  public void a(Executor paramExecutor, CameraManager.AvailabilityCallback paramAvailabilityCallback)
  {
    AppMethodBeat.i(198098);
    if (paramExecutor == null)
    {
      paramExecutor = new IllegalArgumentException("executor was null");
      AppMethodBeat.o(198098);
      throw paramExecutor;
    }
    Object localObject = null;
    a locala1 = (a)this.mObject;
    if (paramAvailabilityCallback != null) {}
    synchronized (locala1.Fl)
    {
      n.a locala = (n.a)locala1.Fl.get(paramAvailabilityCallback);
      localObject = locala;
      if (locala == null)
      {
        localObject = new n.a(paramExecutor, paramAvailabilityCallback);
        locala1.Fl.put(paramAvailabilityCallback, localObject);
      }
      this.Fk.registerAvailabilityCallback((CameraManager.AvailabilityCallback)localObject, locala1.Ej);
      AppMethodBeat.o(198098);
      return;
    }
  }
  
  public void b(CameraManager.AvailabilityCallback arg1)
  {
    AppMethodBeat.i(198104);
    Object localObject1 = null;
    if (??? != null) {
      localObject1 = (a)this.mObject;
    }
    synchronized (((a)localObject1).Fl)
    {
      localObject1 = (n.a)((a)localObject1).Fl.remove(???);
      if (localObject1 == null) {}
    }
    synchronized (((n.a)localObject1).mLock)
    {
      ((n.a)localObject1).mDisabled = true;
      this.Fk.unregisterAvailabilityCallback((CameraManager.AvailabilityCallback)localObject1);
      AppMethodBeat.o(198104);
      return;
      ??? = finally;
      AppMethodBeat.o(198104);
      throw ???;
    }
  }
  
  public final String[] hU()
  {
    AppMethodBeat.i(198089);
    try
    {
      String[] arrayOfString = this.Fk.getCameraIdList();
      AppMethodBeat.o(198089);
      return arrayOfString;
    }
    catch (CameraAccessException localCameraAccessException)
    {
      b localb = b.a(localCameraAccessException);
      AppMethodBeat.o(198089);
      throw localb;
    }
  }
  
  static final class a
  {
    final Handler Ej;
    final Map<CameraManager.AvailabilityCallback, n.a> Fl;
    
    a(Handler paramHandler)
    {
      AppMethodBeat.i(198159);
      this.Fl = new HashMap();
      this.Ej = paramHandler;
      AppMethodBeat.o(198159);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.q
 * JD-Core Version:    0.7.0.1
 */