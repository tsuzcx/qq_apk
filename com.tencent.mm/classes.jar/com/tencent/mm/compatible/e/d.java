package com.tencent.mm.compatible.e;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.y;

public final class d
{
  public static int getNumberOfCameras()
  {
    if ((q.dyd.dwg) && (q.dyd.dwm))
    {
      new i();
      return i.getNumberOfCameras();
    }
    new g();
    return Camera.getNumberOfCameras();
  }
  
  public static d.a.a u(Context paramContext, int paramInt)
  {
    if (q.dyd.dwo == 1)
    {
      y.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl20, cameraId = " + paramInt);
      new e();
      return e.yO();
    }
    if (q.dyd.dwg)
    {
      y.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImplConfig, cameraId = " + paramInt);
      new i();
      return i.gy(paramInt);
    }
    if (Build.MODEL.equals("M9"))
    {
      new j();
      return j.yO();
    }
    if (getNumberOfCameras() > 1)
    {
      y.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl23, cameraId = " + paramInt);
      new g();
      return g.u(paramContext, paramInt);
    }
    new f();
    return f.gy(paramInt);
  }
  
  public static int yM()
  {
    if (q.dyn.dxh == 1) {
      return 0;
    }
    int j = Camera.getNumberOfCameras();
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int i = 0;
    if (i < j)
    {
      Camera.getCameraInfo(i, localCameraInfo);
      if (localCameraInfo.facing == 0) {
        y.d("MicroMsg.CameraUtil", "tigercam get bid %d", new Object[] { Integer.valueOf(i) });
      }
    }
    for (;;)
    {
      y.d("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", new Object[] { Integer.valueOf(i) });
      return i;
      i += 1;
      break;
      i = 0;
    }
  }
  
  public static boolean yN()
  {
    if (q.dyd.dwo == 1) {}
    while ((Build.VERSION.SDK_INT == 10) && (Build.MODEL.equals("GT-S5360"))) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.e.d
 * JD-Core Version:    0.7.0.1
 */