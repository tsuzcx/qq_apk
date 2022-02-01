package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.c.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
{
  public static d.a.a B(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(215250);
    paramContext = a(paramContext, paramInt, null);
    AppMethodBeat.o(215250);
    return paramContext;
  }
  
  public static d.a.a a(Context paramContext, int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(155647);
    if (ae.gKt.gFQ == 1)
    {
      Log.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl20, cameraId = ".concat(String.valueOf(paramInt)));
      new e();
      paramContext = e.d(paramLooper);
      AppMethodBeat.o(155647);
      return paramContext;
    }
    if (ae.gKt.gFI)
    {
      Log.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImplConfig, cameraId = ".concat(String.valueOf(paramInt)));
      new i();
      paramContext = i.a(paramInt, paramLooper);
      AppMethodBeat.o(155647);
      return paramContext;
    }
    if (Build.MODEL.equals("M9"))
    {
      new j();
      paramContext = j.d(paramLooper);
      AppMethodBeat.o(155647);
      return paramContext;
    }
    if (getNumberOfCameras() > 1)
    {
      Log.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl23, cameraId = ".concat(String.valueOf(paramInt)));
      new g();
      paramContext = g.a(paramContext, paramInt, paramLooper);
      AppMethodBeat.o(155647);
      return paramContext;
    }
    new f();
    paramContext = f.a(paramInt, paramLooper);
    AppMethodBeat.o(155647);
    return paramContext;
  }
  
  public static int aog()
  {
    AppMethodBeat.i(155645);
    if (ae.gKE.gGP == 1)
    {
      AppMethodBeat.o(155645);
      return 0;
    }
    Object localObject = a.gDs;
    int j = a.anJ();
    localObject = new Camera.CameraInfo();
    int i = 0;
    if (i < j)
    {
      Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
      if (((Camera.CameraInfo)localObject).facing == 0) {
        Log.d("MicroMsg.CameraUtil", "tigercam get bid %d", new Object[] { Integer.valueOf(i) });
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(155645);
      return i;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public static int aoh()
  {
    AppMethodBeat.i(155646);
    Object localObject = a.gDs;
    int j = a.anJ();
    localObject = new Camera.CameraInfo();
    int i = 0;
    if (i < j)
    {
      Camera.getCameraInfo(i, (Camera.CameraInfo)localObject);
      if (((Camera.CameraInfo)localObject).facing == 1) {
        Log.d("MicroMsg.CameraUtil", "tigercam get fid %d", new Object[] { Integer.valueOf(i) });
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(155646);
      return i;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public static int getNumberOfCameras()
  {
    AppMethodBeat.i(155644);
    if ((ae.gKt.gFI) && (ae.gKt.gFO))
    {
      new i();
      i = i.getNumberOfCameras();
      AppMethodBeat.o(155644);
      return i;
    }
    new g();
    a locala = a.gDs;
    int i = a.anJ();
    AppMethodBeat.o(155644);
    return i;
  }
  
  public static abstract interface a
  {
    public static final class a
    {
      public int dYT;
      public v gGr;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.d
 * JD-Core Version:    0.7.0.1
 */