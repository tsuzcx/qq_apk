package androidx.camera.camera2.b.a;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.b.a.a.b.a;
import androidx.camera.camera2.b.a.a.g;
import androidx.camera.core.al;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class m
  implements i.a
{
  final CameraDevice AF;
  final Object Fg;
  
  m(CameraDevice paramCameraDevice, Object paramObject)
  {
    AppMethodBeat.i(198068);
    this.AF = ((CameraDevice)f.checkNotNull(paramCameraDevice));
    this.Fg = paramObject;
    AppMethodBeat.o(198068);
  }
  
  static List<Surface> C(List<androidx.camera.camera2.b.a.a.b> paramList)
  {
    AppMethodBeat.i(198076);
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((androidx.camera.camera2.b.a.a.b)paramList.next()).getSurface());
    }
    AppMethodBeat.o(198076);
    return localArrayList;
  }
  
  static void a(CameraDevice paramCameraDevice, g paramg)
  {
    AppMethodBeat.i(198082);
    f.checkNotNull(paramCameraDevice);
    f.checkNotNull(paramg);
    f.checkNotNull(paramg.ib());
    List localList = paramg.ia();
    if (localList == null)
    {
      paramCameraDevice = new IllegalArgumentException("Invalid output configurations");
      AppMethodBeat.o(198082);
      throw paramCameraDevice;
    }
    if (paramg.hI() == null)
    {
      paramCameraDevice = new IllegalArgumentException("Invalid executor");
      AppMethodBeat.o(198082);
      throw paramCameraDevice;
    }
    a(paramCameraDevice, localList);
    AppMethodBeat.o(198082);
  }
  
  private static void a(CameraDevice paramCameraDevice, List<androidx.camera.camera2.b.a.a.b> paramList)
  {
    AppMethodBeat.i(198092);
    paramCameraDevice = paramCameraDevice.getId();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = ((androidx.camera.camera2.b.a.a.b)paramList.next()).Fo.hX();
      if ((str != null) && (!str.isEmpty()))
      {
        new StringBuilder("Camera ").append(paramCameraDevice).append(": Camera doesn't support physicalCameraId ").append(str).append(". Ignoring.");
        al.R("CameraDeviceCompat");
      }
    }
    AppMethodBeat.o(198092);
  }
  
  static void a(CameraDevice paramCameraDevice, List<Surface> paramList, CameraCaptureSession.StateCallback paramStateCallback, Handler paramHandler)
  {
    AppMethodBeat.i(198100);
    try
    {
      paramCameraDevice.createCaptureSession(paramList, paramStateCallback, paramHandler);
      AppMethodBeat.o(198100);
      return;
    }
    catch (CameraAccessException paramCameraDevice)
    {
      paramCameraDevice = b.a(paramCameraDevice);
      AppMethodBeat.o(198100);
      throw paramCameraDevice;
    }
  }
  
  public void a(g paramg)
  {
    AppMethodBeat.i(198105);
    a(this.AF, paramg);
    if (paramg.ic() != null)
    {
      paramg = new IllegalArgumentException("Reprocessing sessions not supported until API 23");
      AppMethodBeat.o(198105);
      throw paramg;
    }
    if (paramg.hZ() == 1)
    {
      paramg = new IllegalArgumentException("High speed capture sessions not supported until API 23");
      AppMethodBeat.o(198105);
      throw paramg;
    }
    c.c localc = new c.c(paramg.hI(), paramg.ib());
    paramg = C(paramg.ia());
    a locala = (a)this.Fg;
    a(this.AF, paramg, localc, locala.Ej);
    AppMethodBeat.o(198105);
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
 * Qualified Name:     androidx.camera.camera2.b.a.m
 * JD-Core Version:    0.7.0.1
 */