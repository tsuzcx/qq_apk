package androidx.camera.camera2.b.a;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraCharacteristics.Key;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class h
{
  private final Map<CameraCharacteristics.Key<?>, Object> Fc;
  private final a Fd;
  
  h(CameraCharacteristics paramCameraCharacteristics)
  {
    AppMethodBeat.i(198044);
    this.Fc = new HashMap();
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.Fd = new f(paramCameraCharacteristics);
      AppMethodBeat.o(198044);
      return;
    }
    this.Fd = new g(paramCameraCharacteristics);
    AppMethodBeat.o(198044);
  }
  
  public final <T> T a(CameraCharacteristics.Key<T> paramKey)
  {
    AppMethodBeat.i(198053);
    if (paramKey.equals(CameraCharacteristics.SENSOR_ORIENTATION)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramKey = this.Fd.a(paramKey);
      AppMethodBeat.o(198053);
      return paramKey;
    }
    try
    {
      Object localObject = this.Fc.get(paramKey);
      if (localObject != null) {
        return localObject;
      }
      localObject = this.Fd.a(paramKey);
      if (localObject != null) {
        this.Fc.put(paramKey, localObject);
      }
      return localObject;
    }
    finally
    {
      AppMethodBeat.o(198053);
    }
  }
  
  public static abstract interface a
  {
    public abstract <T> T a(CameraCharacteristics.Key<T> paramKey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.a.h
 * JD-Core Version:    0.7.0.1
 */