package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
{
  public static int WA()
  {
    AppMethodBeat.i(155646);
    int j = Camera.getNumberOfCameras();
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int i = 0;
    if (i < j)
    {
      Camera.getCameraInfo(i, localCameraInfo);
      if (localCameraInfo.facing == 1) {
        ad.d("MicroMsg.CameraUtil", "tigercam get fid %d", new Object[] { Integer.valueOf(i) });
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(155646);
      return i;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public static int Wz()
  {
    AppMethodBeat.i(155645);
    if (ae.fFH.fCk == 1)
    {
      AppMethodBeat.o(155645);
      return 0;
    }
    int j = Camera.getNumberOfCameras();
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int i = 0;
    if (i < j)
    {
      Camera.getCameraInfo(i, localCameraInfo);
      if (localCameraInfo.facing == 0) {
        ad.d("MicroMsg.CameraUtil", "tigercam get bid %d", new Object[] { Integer.valueOf(i) });
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(155645);
      return i;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public static d.a.a a(Context paramContext, int paramInt, Looper paramLooper)
  {
    AppMethodBeat.i(155647);
    if (ae.fFw.fBn == 1)
    {
      ad.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl20, cameraId = ".concat(String.valueOf(paramInt)));
      new e();
      paramContext = e.d(paramLooper);
      AppMethodBeat.o(155647);
      return paramContext;
    }
    if (ae.fFw.fBf)
    {
      ad.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImplConfig, cameraId = ".concat(String.valueOf(paramInt)));
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
      ad.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl23, cameraId = ".concat(String.valueOf(paramInt)));
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
  
  public static int getNumberOfCameras()
  {
    AppMethodBeat.i(155644);
    if ((ae.fFw.fBf) && (ae.fFw.fBl))
    {
      new i();
      i = i.getNumberOfCameras();
      AppMethodBeat.o(155644);
      return i;
    }
    new g();
    int i = Camera.getNumberOfCameras();
    AppMethodBeat.o(155644);
    return i;
  }
  
  public static abstract interface a
  {
    public static final class a
    {
      public int dwp;
      public v fBM;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.d
 * JD-Core Version:    0.7.0.1
 */