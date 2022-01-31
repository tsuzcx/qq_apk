package com.tencent.mm.compatible.e;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

final class f
  implements d.a
{
  @TargetApi(8)
  public static d.a.a gy(int paramInt)
  {
    d.a.a locala = new d.a.a();
    try
    {
      locala.dwJ = Camera.open();
      locala.rotate = 90;
      if (locala.dwJ == null) {
        return null;
      }
      Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
      Camera.getCameraInfo(paramInt, localCameraInfo);
      switch (((WindowManager)ae.getContext().getSystemService("window")).getDefaultDisplay().getRotation())
      {
      default: 
        paramInt = 0;
        if (localCameraInfo.facing != 1) {
          break;
        }
      }
      for (int i = (360 - (localCameraInfo.orientation + paramInt) % 360) % 360;; i = (localCameraInfo.orientation - paramInt + 360) % 360)
      {
        y.d("MicroMsg.CameraUtil.CameraUtilImpl22", "CameraUtilImpl22, open camera, info.orientation: %d, degrees: %d, result:%d", new Object[] { Integer.valueOf(localCameraInfo.orientation), Integer.valueOf(paramInt), Integer.valueOf(i) });
        locala.dwJ.setDisplayOrientation(i);
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
      return null;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.e.f
 * JD-Core Version:    0.7.0.1
 */