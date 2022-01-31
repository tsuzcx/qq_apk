package com.tencent.mm.compatible.e;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class g
  implements d.a
{
  public static d.a.a u(Context paramContext, int paramInt)
  {
    d.a.a locala = new d.a.a();
    locala.dwJ = null;
    try
    {
      l = bk.UZ();
      y.i("MicroMsg.CameraUtil", "ashu::begin to try Call Camera.open cameraID %d", new Object[] { Integer.valueOf(paramInt) });
      locala.dwJ = Camera.open(paramInt);
      y.i("MicroMsg.CameraUtil", "ashu::Call Camera.open back, use %dms", new Object[] { Long.valueOf(bk.cp(l)) });
      if (locala.dwJ == null)
      {
        y.e("MicroMsg.CameraUtil", "open camera error, not exception, but camera null");
        return null;
      }
    }
    catch (Exception paramContext)
    {
      y.e("MicroMsg.CameraUtil", "open camera error %s", new Object[] { paramContext.getMessage() });
      y.printErrStackTrace("MicroMsg.CameraUtil", paramContext, "", new Object[0]);
      return null;
    }
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    long l = bk.UZ();
    y.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.getCameraInfo cameraID %d", new Object[] { Integer.valueOf(paramInt) });
    Camera.getCameraInfo(paramInt, localCameraInfo);
    y.i("MicroMsg.CameraUtil", "ashu::Call Camera.getCameraInfo back, use %dms", new Object[] { Long.valueOf(bk.cp(l)) });
    switch (((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRotation())
    {
    default: 
      paramInt = 0;
      if (localCameraInfo.facing != 1) {
        break;
      }
    }
    for (paramInt = (360 - localCameraInfo.orientation % 360) % 360;; paramInt = (localCameraInfo.orientation - paramInt + 360) % 360)
    {
      l = bk.UZ();
      y.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.setDisplayOrientation %d", new Object[] { Integer.valueOf(paramInt) });
      locala.dwJ.setDisplayOrientation(paramInt);
      y.i("MicroMsg.CameraUtil", "ashu::Call Camera.setDisplayOrientation back, use %dms", new Object[] { Long.valueOf(bk.cp(l)) });
      locala.rotate = localCameraInfo.orientation;
      return locala;
      paramInt = 0;
      break;
      paramInt = 90;
      break;
      paramInt = 180;
      break;
      paramInt = 270;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.compatible.e.g
 * JD-Core Version:    0.7.0.1
 */