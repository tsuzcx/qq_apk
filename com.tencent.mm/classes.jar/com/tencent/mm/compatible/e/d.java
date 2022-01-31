package com.tencent.mm.compatible.e;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
{
  public static int Lj()
  {
    AppMethodBeat.i(92923);
    if (ac.erF.epf == 1)
    {
      AppMethodBeat.o(92923);
      return 0;
    }
    int j = Camera.getNumberOfCameras();
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int i = 0;
    if (i < j)
    {
      Camera.getCameraInfo(i, localCameraInfo);
      if (localCameraInfo.facing == 0) {
        ab.d("MicroMsg.CameraUtil", "tigercam get bid %d", new Object[] { Integer.valueOf(i) });
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(92923);
      return i;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public static int Lk()
  {
    AppMethodBeat.i(92924);
    int j = Camera.getNumberOfCameras();
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int i = 0;
    if (i < j)
    {
      Camera.getCameraInfo(i, localCameraInfo);
      if (localCameraInfo.facing == 1) {
        ab.d("MicroMsg.CameraUtil", "tigercam get fid %d", new Object[] { Integer.valueOf(i) });
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(92924);
      return i;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public static boolean Ll()
  {
    AppMethodBeat.i(92925);
    if (ac.eru.eoi == 1)
    {
      AppMethodBeat.o(92925);
      return true;
    }
    if ((Build.VERSION.SDK_INT == 10) && (Build.MODEL.equals("GT-S5360")))
    {
      AppMethodBeat.o(92925);
      return true;
    }
    AppMethodBeat.o(92925);
    return false;
  }
  
  public static d.a.a a(Context paramContext, int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(92926);
    if (ac.eru.eoi == 1)
    {
      ab.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl20, cameraId = ".concat(String.valueOf(paramInt)));
      new e();
      paramContext = e.b(paramLooper);
      AppMethodBeat.o(92926);
      return paramContext;
    }
    if (ac.eru.enZ)
    {
      ab.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImplConfig, cameraId = ".concat(String.valueOf(paramInt)));
      new i();
      paramContext = i.a(paramInt, paramLooper);
      AppMethodBeat.o(92926);
      return paramContext;
    }
    if (Build.MODEL.equals("M9"))
    {
      new j();
      paramContext = j.b(paramLooper);
      AppMethodBeat.o(92926);
      return paramContext;
    }
    if (getNumberOfCameras() > 1)
    {
      ab.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl23, cameraId = ".concat(String.valueOf(paramInt)));
      new g();
      paramContext = g.a(paramContext, paramInt, paramLooper);
      AppMethodBeat.o(92926);
      return paramContext;
    }
    new f();
    paramContext = f.a(paramInt, paramLooper);
    AppMethodBeat.o(92926);
    return paramContext;
  }
  
  public static int getNumberOfCameras()
  {
    AppMethodBeat.i(92922);
    if ((ac.eru.enZ) && (ac.eru.eog))
    {
      new i();
      i = i.getNumberOfCameras();
      AppMethodBeat.o(92922);
      return i;
    }
    new g();
    int i = Camera.getNumberOfCameras();
    AppMethodBeat.o(92922);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.e.d
 * JD-Core Version:    0.7.0.1
 */