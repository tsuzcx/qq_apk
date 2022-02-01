package androidx.camera.camera2.b;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureRequest.Key;
import android.view.Surface;
import androidx.camera.camera2.c.c;
import androidx.camera.camera2.c.c.a;
import androidx.camera.core.al;
import androidx.camera.core.impl.ac;
import androidx.camera.core.impl.ac.a;
import androidx.camera.core.impl.ad;
import androidx.camera.core.impl.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class m
{
  public static CaptureRequest a(z paramz, CameraDevice paramCameraDevice)
  {
    AppMethodBeat.i(197915);
    if (paramCameraDevice == null)
    {
      AppMethodBeat.o(197915);
      return null;
    }
    paramCameraDevice = paramCameraDevice.createCaptureRequest(paramz.LW);
    a(paramCameraDevice, paramz.LV);
    paramz = paramCameraDevice.build();
    AppMethodBeat.o(197915);
    return paramz;
  }
  
  public static CaptureRequest a(z paramz, CameraDevice paramCameraDevice, Map<ad, Surface> paramMap)
  {
    AppMethodBeat.i(197908);
    if (paramCameraDevice == null)
    {
      AppMethodBeat.o(197908);
      return null;
    }
    Object localObject = Collections.unmodifiableList(paramz.Fs);
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Surface localSurface = (Surface)paramMap.get((ad)((Iterator)localObject).next());
      if (localSurface == null)
      {
        paramz = new IllegalArgumentException("DeferrableSurface not in configuredSurfaceMap");
        AppMethodBeat.o(197908);
        throw paramz;
      }
      localArrayList.add(localSurface);
    }
    if (localArrayList.isEmpty())
    {
      AppMethodBeat.o(197908);
      return null;
    }
    paramCameraDevice = paramCameraDevice.createCaptureRequest(paramz.LW);
    a(paramCameraDevice, paramz.LV);
    if (paramz.LV.a(z.LT)) {
      paramCameraDevice.set(CaptureRequest.JPEG_ORIENTATION, (Integer)paramz.LV.b(z.LT));
    }
    if (paramz.LV.a(z.LU)) {
      paramCameraDevice.set(CaptureRequest.JPEG_QUALITY, Byte.valueOf(((Integer)paramz.LV.b(z.LU)).byteValue()));
    }
    paramMap = localArrayList.iterator();
    while (paramMap.hasNext()) {
      paramCameraDevice.addTarget((Surface)paramMap.next());
    }
    paramCameraDevice.setTag(paramz.zU);
    paramz = paramCameraDevice.build();
    AppMethodBeat.o(197908);
    return paramz;
  }
  
  private static void a(CaptureRequest.Builder paramBuilder, ac paramac)
  {
    AppMethodBeat.i(197902);
    paramac = c.a.c(paramac).ir();
    Iterator localIterator = paramac.ke().iterator();
    while (localIterator.hasNext())
    {
      ac.a locala = (ac.a)localIterator.next();
      CaptureRequest.Key localKey = (CaptureRequest.Key)locala.jN();
      try
      {
        paramBuilder.set(localKey, paramac.b(locala));
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        "CaptureRequest.Key is not supported: ".concat(String.valueOf(localKey));
        al.T("CaptureRequestBuilder");
      }
    }
    AppMethodBeat.o(197902);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.m
 * JD-Core Version:    0.7.0.1
 */